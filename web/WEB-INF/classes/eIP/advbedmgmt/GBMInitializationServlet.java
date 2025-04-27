/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIP.advbedmgmt;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import eIP.advbedmgmt.common.CommonResourceConstants;
import eIP.advbedmgmt.common.bedcolor.BedColorResourceConstants;
import eIP.advbedmgmt.common.bedlegend.BedLegendResourceConstants;
import eIP.advbedmgmt.setup.beddimension.BedDimensionResourceConstants;
import eIP.advbedmgmt.transaction.cataskaccess.CATaskAccessResourceConstants;
import eIP.advbedmgmt.transaction.floorlayout.FloorLayoutResourceConstants;
import eIP.advbedmgmt.transaction.patientfinancial.FinancialInfoResourceConstants;
import eIP.advbedmgmt.transaction.patientsearch.PatientSearchResourceConstants;
import eIP.advbedmgmt.transaction.rolebasedaccess.TransactionListResourceConstants;

/**
 * This is the initialization servlet for GBM submodule in IP module
 * This class initializes the resource bundle constants as of now
 * @author GRamamoorthy
 *
 */
public class GBMInitializationServlet extends HttpServlet {

	/**
	 * This method initializes the resource bundle messages
	 */
	public void init(ServletConfig config) throws ServletException {
		CommonResourceConstants.initialize();
		FloorLayoutResourceConstants.initialize();
		PatientSearchResourceConstants.initialize();
		CATaskAccessResourceConstants.initialize();
		FinancialInfoResourceConstants.initialize();
		BedColorResourceConstants.initialize();
		BedLegendResourceConstants.initialize();
		BedDimensionResourceConstants.initialize();
		TransactionListResourceConstants.initialize();
		
	}
}
