/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.webdav;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webdav.WebDAVUtil;
import com.liferay.portal.webdav.methods.Method;
import com.liferay.portlet.documentlibrary.webdav.DLWebDAVStorageImpl;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * @author Alexander Chow
 */
public class BaseWebDAVTestCase extends TestCase {

	public static void assertBytes(byte[] expected, byte[] actual) {
		if ((expected == null) && (actual == null)) {
			return;
		}

		if ((expected != null) && expected.equals(actual)) {
			return;
		}

		if (expected.length == actual.length) {
			boolean same = true;

			for (int i = 0; i < expected.length; i++) {
				if (expected[i] != actual[i]) {
					same = false;

					break;
				}
			}

			if (same) {
				return;
			}
		}

		fail(
			"Content does not match.  Expected " + expected + ", Actual " +
				actual);
	}

	public static void assertCode(int statusCode, Tuple tuple) {
		int returnedStatusCode = -1;

		if (tuple != null) {
			returnedStatusCode = getStatusCode(tuple);
		}

		assertEquals(statusCode, returnedStatusCode);
	}

	protected static String getDepth(int depth) {
		String depthString = "infinity";

		if (depth == 0) {
			depthString = "0";
		}

		return depthString;
	}

	protected static Map<String, String> getHeaders(Tuple tuple) {
		return (Map<String, String>)tuple.getObject(2);
	}

	protected static String getLock(Tuple tuple) {
		String token = "";

		Map<String, String> headers = getHeaders(tuple);

		String value = GetterUtil.getString(headers.get("Lock-Token"));

		int beg = value.indexOf(WebDAVUtil.TOKEN_PREFIX);

		if (beg >= 0) {
			beg += WebDAVUtil.TOKEN_PREFIX.length();

			if (beg < value.length()) {
				int end = value.indexOf(">", beg);

				token = GetterUtil.getString(value.substring(beg, end));
			}
		}

		return token;
	}

	protected static String getOverwrite(boolean overwrite) {
		String overwriteString = "F";

		if (overwrite) {
			overwriteString = "T";
		}

		return overwriteString;
	}

	protected static byte[] getResponseBody(Tuple tuple) {
		return (byte[])tuple.getObject(1);
	}

	protected static String getResponseBodyString(Tuple tuple) {
		byte[] data = getResponseBody(tuple);

		return new String(data);
	}

	protected static int getStatusCode(Tuple tuple) {
		return (Integer)tuple.getObject(0);
	}

	public Tuple service(
		String method, String path, Map<String, String> headers, byte[] data) {

		if (headers == null) {
			headers = new HashMap<String, String>();
		}

		headers.put(HttpHeaders.USER_AGENT, getUserAgent());

		try {
			throw new Exception();
		}
		catch (Exception e) {
			StackTraceElement[] stackTraceElements = e.getStackTrace();

			for (StackTraceElement stackTraceElement : stackTraceElements) {
				String methodName = stackTraceElement.getMethodName();

				if (methodName.equals("setUp") ||
					methodName.equals("tearDown") ||
					methodName.startsWith("test")) {

					String testName = StringUtil.extractLast(
						stackTraceElement.getClassName(), StringPool.PERIOD);

					testName = StringUtil.replace(
						testName,
						new String[] {"WebDAV", "Test"},
						new String[] {"", ""});

					headers.put(
						"X-Litmus",
						testName + ": (" + stackTraceElement.getMethodName() +
							":" + stackTraceElement.getLineNumber() + ")");

					break;
				}
			}
		}

		String requestURI =
			_CONTEXT_PATH + _SERVLET_PATH + _PATH_INFO_PREFACE + path;

		MockHttpServletRequest request = new MockHttpServletRequest(
			method, requestURI);

		MockHttpServletResponse response = new MockHttpServletResponse();

		request.setContextPath(_CONTEXT_PATH);
		request.setServletPath(_SERVLET_PATH);
		request.setPathInfo(_PATH_INFO_PREFACE + path);

		if (data != null) {
			request.setContent(data);

			String contentType = headers.remove(HttpHeaders.CONTENT_TYPE);

			if (contentType != null) {
				request.setContentType(contentType);
			}
			else {
				request.setContentType(ContentTypes.TEXT_PLAIN);
			}
		}

		for (Map.Entry<String, String> entry : headers.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();

			request.addHeader(key, value);
		}

		try {
			DLWebDAVStorageImpl storage = new DLWebDAVStorageImpl();

			storage.setToken("document_library");

			WebDAVUtil.addStorage(storage);

			WebDAVServlet servlet = new WebDAVServlet();

			servlet.service(request, response);

			int statusCode = response.getStatus();
			byte[] responseBody = response.getContentAsByteArray();

			Map<String, String> responseHeaders = new HashMap<String, String>();

			for (String name : response.getHeaderNames()) {
				responseHeaders.put(name, (String)response.getHeader(name));
			}

			return new Tuple(statusCode, responseBody, responseHeaders);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Tuple serviceCopyOrMove(
		String method, String path, Map<String, String> headers,
		String destination, int depth, boolean overwrite) {

		if (headers == null) {
			headers = new HashMap<String, String>();
		}

		headers.put("Depth", getDepth(depth));
		headers.put("Destination", _PATH_INFO_PREFACE + destination);
		headers.put("Overwrite", getOverwrite(overwrite));

		return service(method, path, headers, null);
	}

	public Tuple serviceCopyOrMove(
		String method, String path, String destination) {

		return serviceCopyOrMove(method, path, destination, false);
	}

	public Tuple serviceCopyOrMove(
		String method, String path, String destination, boolean overwrite) {

		return serviceCopyOrMove(method, path, null, destination, 0, overwrite);
	}

	public Tuple serviceCopyOrMove(
			String method, String path, String destination, String lock) {

		Map<String, String> headers = null;

		if (Validator.isNotNull(lock)) {
			headers = new HashMap<String, String>();

			headers.put("If", "<opaquelocktoken:" + lock + ">");
		}

		return serviceCopyOrMove(method, path, headers, destination, 0, false);
	}

	public Tuple serviceDelete(String name) {
		return service(Method.DELETE, name, null, null);
	}

	public Tuple serviceGet(String name) {
		return service(Method.GET, name, null, null);
	}

	public Tuple serviceLock(
		String path, Map<String, String> headers, int depth) {

		if (headers == null) {
			headers = new HashMap<String, String>();
		}

		headers.put("Depth", getDepth(depth));
		headers.put("Timeout", "Second-" + 3600);

		return service(Method.LOCK, path, headers, _LOCK_XML.getBytes());
	}

	public Tuple servicePropFind(String name) {
		return service(Method.PROPFIND, name, null, _PROPFIND_XML.getBytes());
	}

	public Tuple servicePut(String name, byte[] data) {
		return servicePut(name, data, null);
	}

	public Tuple servicePut(String name, byte[] data, String lock) {
		Map<String, String> headers = null;

		if (Validator.isNotNull(lock)) {
			headers = new HashMap<String, String>();

			headers.put("If", "<opaquelocktoken:" + lock + ">");
		}

		return service(Method.PUT, name, headers, data);
	}

	public Tuple serviceUnlock(String path, String lock) {
		Map<String, String> headers = null;

		if (Validator.isNotNull(lock)) {
			headers = new HashMap<String, String>();

			headers.put("Lock-Token", "<opaquelocktoken:" + lock + ">");
		}

		return service(Method.UNLOCK, path, headers, null);
	}

	protected String getUserAgent() {
		return _DEFAULT_USER_AGENT;
	}

	private static final String _CONTEXT_PATH = "/webdav";

	private static final String _DEFAULT_USER_AGENT = "Liferay-litmus";

	private static final String _LOCK_XML =
		"<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
		"<D:lockinfo xmlns:D='DAV:'>\n" +
		"<D:lockscope><D:exclusive/></D:lockscope>\n" +
		"<D:locktype><D:write/></D:locktype>\n" +
		"<D:owner>\n" +
		"<D:href>http://www.liferay.com</D:href>\n" +
		"</D:owner>\n" +
		"</D:lockinfo>\n";

	private static final String _PATH_INFO_PREFACE =
		"/guest/document_library/WebDAVTest/";

	private static final String _PROPFIND_XML =
		"<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n"+
		"<D:propfind xmlns:D=\"DAV:\">\n"+
		"<D:allprop/>\n"+
		"</D:propfind>";

	private static final String _SERVLET_PATH = "";

}