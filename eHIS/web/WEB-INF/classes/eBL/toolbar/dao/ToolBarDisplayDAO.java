/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.toolbar.dao;

import eBL.toolbar.request.ToolbarRequest;
import eBL.toolbar.response.ToolbarResponse;

public interface ToolBarDisplayDAO {

	public ToolbarResponse getToolBarForUser(ToolbarRequest toolbarRequest);
}
