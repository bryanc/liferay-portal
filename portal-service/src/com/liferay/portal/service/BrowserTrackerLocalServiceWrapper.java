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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link BrowserTrackerLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BrowserTrackerLocalService
 * @generated
 */
public class BrowserTrackerLocalServiceWrapper
	implements BrowserTrackerLocalService {
	public BrowserTrackerLocalServiceWrapper(
		BrowserTrackerLocalService browserTrackerLocalService) {
		_browserTrackerLocalService = browserTrackerLocalService;
	}

	/**
	* Adds the browser tracker to the database. Also notifies the appropriate model listeners.
	*
	* @param browserTracker the browser tracker
	* @return the browser tracker that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.BrowserTracker addBrowserTracker(
		com.liferay.portal.model.BrowserTracker browserTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.addBrowserTracker(browserTracker);
	}

	/**
	* Creates a new browser tracker with the primary key. Does not add the browser tracker to the database.
	*
	* @param browserTrackerId the primary key for the new browser tracker
	* @return the new browser tracker
	*/
	public com.liferay.portal.model.BrowserTracker createBrowserTracker(
		long browserTrackerId) {
		return _browserTrackerLocalService.createBrowserTracker(browserTrackerId);
	}

	/**
	* Deletes the browser tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param browserTrackerId the primary key of the browser tracker
	* @throws PortalException if a browser tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteBrowserTracker(long browserTrackerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_browserTrackerLocalService.deleteBrowserTracker(browserTrackerId);
	}

	/**
	* Deletes the browser tracker from the database. Also notifies the appropriate model listeners.
	*
	* @param browserTracker the browser tracker
	* @throws SystemException if a system exception occurred
	*/
	public void deleteBrowserTracker(
		com.liferay.portal.model.BrowserTracker browserTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		_browserTrackerLocalService.deleteBrowserTracker(browserTracker);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the browser tracker with the primary key.
	*
	* @param browserTrackerId the primary key of the browser tracker
	* @return the browser tracker
	* @throws PortalException if a browser tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.BrowserTracker getBrowserTracker(
		long browserTrackerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.getBrowserTracker(browserTrackerId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the browser trackers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of browser trackers
	* @param end the upper bound of the range of browser trackers (not inclusive)
	* @return the range of browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.BrowserTracker> getBrowserTrackers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.getBrowserTrackers(start, end);
	}

	/**
	* Returns the number of browser trackers.
	*
	* @return the number of browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public int getBrowserTrackersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.getBrowserTrackersCount();
	}

	/**
	* Updates the browser tracker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param browserTracker the browser tracker
	* @return the browser tracker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.BrowserTracker updateBrowserTracker(
		com.liferay.portal.model.BrowserTracker browserTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.updateBrowserTracker(browserTracker);
	}

	/**
	* Updates the browser tracker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param browserTracker the browser tracker
	* @param merge whether to merge the browser tracker with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the browser tracker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.BrowserTracker updateBrowserTracker(
		com.liferay.portal.model.BrowserTracker browserTracker, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.updateBrowserTracker(browserTracker,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _browserTrackerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_browserTrackerLocalService.setBeanIdentifier(beanIdentifier);
	}

	public void deleteUserBrowserTracker(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_browserTrackerLocalService.deleteUserBrowserTracker(userId);
	}

	public com.liferay.portal.model.BrowserTracker getBrowserTracker(
		long userId, long browserKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.getBrowserTracker(userId, browserKey);
	}

	public com.liferay.portal.model.BrowserTracker updateBrowserTracker(
		long userId, long browserKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTrackerLocalService.updateBrowserTracker(userId,
			browserKey);
	}

	public BrowserTrackerLocalService getWrappedBrowserTrackerLocalService() {
		return _browserTrackerLocalService;
	}

	public void setWrappedBrowserTrackerLocalService(
		BrowserTrackerLocalService browserTrackerLocalService) {
		_browserTrackerLocalService = browserTrackerLocalService;
	}

	private BrowserTrackerLocalService _browserTrackerLocalService;
}