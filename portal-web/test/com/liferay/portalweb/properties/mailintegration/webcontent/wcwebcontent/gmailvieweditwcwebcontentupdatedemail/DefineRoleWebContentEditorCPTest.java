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

package com.liferay.portalweb.properties.mailintegration.webcontent.wcwebcontent.gmailvieweditwcwebcontentupdatedemail;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DefineRoleWebContentEditorCPTest extends BaseTestCase {
	public void testDefineRoleWebContentEditorCP() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Roles", RuntimeVariables.replace("Roles"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("//input[@id='_128_keywords']",
			RuntimeVariables.replace("Web Content Editor"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Web Content Editor"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Regular"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace(
				"Web Content Editors are users who have full permissions and usage over all available Web Content"),
			selenium.getText("//td[3]/a"));
		selenium.clickAt("//td[1]/a",
			RuntimeVariables.replace("Web Content Editor"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Web Content Editor"),
			selenium.getText("//h1[@class='header-title']"));
		selenium.clickAt("link=Define Permissions",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Web Content"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.journalSUBSCRIBE']");
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"The role permissions were updated."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.clickAt("link=Define Permissions",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.typeKeys("_128_add-permissions",
			RuntimeVariables.replace("wwwwwwwwww"));
		selenium.saveScreenShotAndSource();
		selenium.keyPress("_128_add-permissions",
			RuntimeVariables.replace("\\13"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.check("//input[@value='15ACCESS_IN_CONTROL_PANEL']");
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"The role permissions were updated."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Access in Control Panel"),
			selenium.getText("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("Subscribe"),
			selenium.getText("//tr[4]/td[3]"));
	}
}