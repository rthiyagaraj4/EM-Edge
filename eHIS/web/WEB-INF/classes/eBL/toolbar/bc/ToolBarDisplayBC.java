/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.toolbar.bc;

import eBL.toolbar.dao.ToolBarDisplayDAO;
import eBL.toolbar.dao.ToolBarDisplayDAOImpl;
import eBL.toolbar.request.ToolbarRequest;
import eBL.toolbar.response.ToolbarResponse;

/**
 * This is Service Class which Delegates the Request to ToolBarDisplayDAO.
 * @author Rajesh V
 *
 */
public class ToolBarDisplayBC {
    ToolBarDisplayDAO  toolBarDao = null;
	
    /**
     * This Method is used to get the User Specific Toolbar Functions and its Properties.
     * @param request
     * @return
     */
	public ToolbarResponse getToolBarForUser(ToolbarRequest request){
		toolBarDao = new ToolBarDisplayDAOImpl();
		ToolbarResponse response = null;
		response = toolBarDao.getToolBarForUser(request);
		return response;
	}
}
