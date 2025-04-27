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
package eIP.advbedmgmt.transaction.requestfortransfer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommon.Common.CommonBean;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.transaction.requestfortransfer.RequestForTransferConstants;
import eIP.advbedmgmt.transaction.requestfortransfer.dao.TransferMetaDataDaoImpl;
import eIP.advbedmgmt.transaction.requestfortransfer.request.TransferMetatDataRequest;
import eIP.advbedmgmt.transaction.requestfortransfer.response.TransferMetaDataResponse;

/**
 * This servlet launches the request for transfer page
 * 
 * @author GRamamoorthy
 * 
 */
public class RequestForTransferServlet extends HttpServlet {

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * This is the main method in this class services the request to launch the
	 * page
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter prntWriter = resp.getWriter();
		prntWriter.println("Welcome to request for transfer");

		// get the session object - there is a need to get the bl_operational
		// value stored in the session
		HttpSession session = req.getSession();
		String bl_operational = (String) session.getAttribute("bl_operational");
		// get data from the request parameters
		String facilityId = CommonBean
				.checkForNull(req
						.getParameter(RequestForTransferConstants.FACILITYID_REQ_PARAM_KEY));
		String encounterId = CommonBean
				.checkForNull(req
						.getParameter(RequestForTransferConstants.ENCOUNTERID_REQ_PARAM_KEY));
		String patientId = CommonBean
				.checkForNull(req
						.getParameter(RequestForTransferConstants.PATIENTID_REQ_PARAM_KEY));
		String practId = CommonBean
				.checkForNull(req
						.getParameter(RequestForTransferConstants.PRACTITIONERID_REQ_PARAM_KEY));
		String nursingUnitCode = CommonBean
				.checkForNull(req
						.getParameter(RequestForTransferConstants.NURSING_UNIT_REQ_PARAM_KEY));
		String sex = CommonBean.checkForNull(req
				.getParameter(RequestForTransferConstants.SEX_PARAM_KEY));
		String bedNumber = CommonBean.checkForNull(req
				.getParameter(RequestForTransferConstants.BEDNUMBER_PARAM_KEY));
		String mode = CommonBean.checkForNull(req
				.getParameter(RequestForTransferConstants.MODE_PARAM_KEY));

		// get the meta data
		TransferMetaDataDaoImpl daoImpl = new TransferMetaDataDaoImpl();
		TransferMetatDataRequest transferMetaDataRequest = new TransferMetatDataRequest();
		transferMetaDataRequest.setFacilityId(facilityId);
		TransferMetaDataResponse transferMetaDataResponse = daoImpl
				.getTransferMetaData(transferMetaDataRequest);
		// now get values from meta data response
		String blInterface = CommonBean.checkForNull(transferMetaDataResponse
				.getBlInterfacedYN());
		String setupBillDetls = CommonBean
				.checkForNull(transferMetaDataResponse
						.getSetupBillDetailsInIPYN());
		String patCheckInAllowed = CommonBean
				.checkForNull(transferMetaDataResponse
						.getPatientCheckInAllowedYN());
		String priorityStatus = CommonBean
				.checkForNull(transferMetaDataResponse.getPriorityStatus());
		String changeBedClass = CommonBean
				.checkForNull(transferMetaDataResponse.getChangeBedClassYN());
		String deactivatePseudoBed = CommonBean
				.checkForNull(transferMetaDataResponse
						.getDeactivatePseudoBedYN());
		int defaultBlockPeriod = transferMetaDataResponse
				.getDefaultBlockPeriodForTransferOut();
		int bedBlocPeriodNormal = transferMetaDataResponse
				.getBedBlockPeriodNormal();
		String reserveBedOnTransfer = CommonBean
				.checkForNull(transferMetaDataResponse
						.getReserveBedOnTransferYN());
		int bedBlockPeriodMax = transferMetaDataResponse.getBedBlockPeriodMax();
		String bedBlockPeriodMaxType = CommonBean
				.checkForNull(transferMetaDataResponse
						.getBedBlockPeriodMaxType());
		String allowMultipleBed = CommonBean
				.checkForNull(transferMetaDataResponse
						.getAllowMultipleBedForReservationYN());
		int maxDischargePeriod = transferMetaDataResponse
				.getMaxDischargePeriodForDC();

		// this will have all the params which will be passed to the request
		// for transfer page - cannot help constructing this as a separate method
		// call will require a number of parameters to be passed which is also
		// cumbersome
		StringBuilder paramBuilder = new StringBuilder();
		paramBuilder.append("?");
		paramBuilder
				.append(RequestForTransferConstants.NURSING_UNIT_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(nursingUnitCode);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.ENCOUNTERID_REQ_PARAM_KEY)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(encounterId);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.FUNCTIONID_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.REQUEST_FOR_TRANSFER_FUNC_IDENTIFIER);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.FUNCTIONNAME_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.FUNCTION_NAME_PARAM_VALUE);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.PATIENTID_REQ_PARAM_KEY)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(patientId);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.PRACTITIONERID_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(practId);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.CALLFROM_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(GBMConstants.IP_MODULE_IDENTIFIER);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.CALLFUNCTION_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.CALL_FUNCTION_PARAM_VALUE);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.SEX_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(sex);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.MODE_PARAM_KEY)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(mode);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.BLINSTAL_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(bl_operational);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.STATUSVALUE_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.STATUS_VALUE_PARAM_VALUE);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.CONFIRMIP_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.CONFIRM_IP_PARAM_VALUE);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.SERVICETYPE_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.SERVICE_TYPE_PARAM_VALUE);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.CHANGE_NURSINGUNIT_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.CHANGE_NURSINGUNIT_PARAM_VALUE);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.OPER_STND_ID_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.OPER_STND_PARAM_VALUE);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.PATIENT_CHECKIN_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(patCheckInAllowed);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.SETUP_BILLDETAILS_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(setupBillDetls);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.BILL_INTERFACED_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(blInterface);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.PRIORITY_STATUS_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(priorityStatus);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.CHANGE_BEDCLASS_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(changeBedClass);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.DEACTIVATE_PSEUDOBED_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(deactivatePseudoBed);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.DEFAULT_BLOCK_PERIOD_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(defaultBlockPeriod);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.BED_BLOCK_PERIOD_NORMAL_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(bedBlocPeriodNormal);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.RESERVE_BED_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(reserveBedOnTransfer);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.BED_BLOCK_PERIOD_MAX_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(bedBlockPeriodMax);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.BED_BLOCK_PERIOD_MAXTYPE_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(bedBlockPeriodMaxType);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.ALLOW_MULTIPLE_BED_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(allowMultipleBed);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.MOTHER_CUTOFF_AGE_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.MOTHER_CUTOFF_AGE_PARAM_VALUE);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.MOTHER_MAXAGE_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.MOTHER_MAX_AGE_PARAM_VALUE);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.MAX_DISCHARGE_PERIOD_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(maxDischargePeriod);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.CONTACT1_NAME_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.CONTACT1_NAME_PARAM_VALUE);
		paramBuilder.append("&");
		paramBuilder
				.append(RequestForTransferConstants.CONTACT2_NAME_PARAM_KEYWORD)
				.append(RequestForTransferConstants.REQUEST_PARAM_VALUE_DELIMITER)
				.append(RequestForTransferConstants.CONTACT2_NAME_PARAM_VALUE);
		
		String url = "../eIP/jsp/PaintBedBookingTransfer.jsp"+paramBuilder.toString();
		// now call the jsp page
		//req.getRequestDispatcher(url).include(req, resp);
		//req.getRequestDispatcher(url).forward(req, resp);
		
		resp.sendRedirect(url);
		
	}

}
