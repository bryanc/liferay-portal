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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ResourceBlockPermission;

/**
 * The cache model class for representing ResourceBlockPermission in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceBlockPermission
 * @generated
 */
public class ResourceBlockPermissionCacheModel implements CacheModel<ResourceBlockPermission> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{resourceBlockPermissionId=");
		sb.append(resourceBlockPermissionId);
		sb.append(", resourceBlockId=");
		sb.append(resourceBlockId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", actionIds=");
		sb.append(actionIds);
		sb.append("}");

		return sb.toString();
	}

	public ResourceBlockPermission toEntityModel() {
		ResourceBlockPermissionImpl resourceBlockPermissionImpl = new ResourceBlockPermissionImpl();

		resourceBlockPermissionImpl.setResourceBlockPermissionId(resourceBlockPermissionId);
		resourceBlockPermissionImpl.setResourceBlockId(resourceBlockId);
		resourceBlockPermissionImpl.setRoleId(roleId);
		resourceBlockPermissionImpl.setActionIds(actionIds);

		resourceBlockPermissionImpl.resetOriginalValues();

		return resourceBlockPermissionImpl;
	}

	public long resourceBlockPermissionId;
	public long resourceBlockId;
	public long roleId;
	public long actionIds;
}