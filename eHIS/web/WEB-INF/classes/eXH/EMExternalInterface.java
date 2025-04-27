/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EMExternalInterface extends HttpServlet
{
	static final String DMS_PROTOCOL_LINK = "DMSIPL";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		try
		{
			Map<String, String> reqParams = XHUtil.getRequestParams(request);
			System.out.println("REQ_PARAM123 " + reqParams);
			
			Map<String, String> responseMap = processRequest(request);
			
			if("SERVICE".equals(responseMap.get("INTERFACE_TYPE"))) {
				PrintWriter responseWriter = response.getWriter();
				responseWriter.write(responseMap.get("statusMessage"));
				responseWriter.flush();
				responseWriter.close();
			}
			else {
				System.out.println("URL FOR "+responseMap.get("FORWARD_URL"));
				response.sendRedirect(responseMap.get("FORWARD_URL"));
			}
		}
		catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
    }
	public Map<String, String> processRequest(HttpServletRequest request) 
	{
		Map<String, String> reqParams = XHUtil.getRequestParams(request);
		StringBuilder additionalParams = new StringBuilder();
		String linkID = reqParams.get("linkID");
		
		try {
			addInteractiveParams(reqParams, request);
			
			if("PATIENT_HISTORY".equals(linkID)) {
				additionalParams.append(processPatientHistoryParams(reqParams));
				reqParams.put("FORWARD_URL", "../eCA/jsp/InvokePatientHistoryWrapper.jsp?" + additionalParams.toString() + "&" + request.getQueryString());
			}
			else if(reqParams.get("documentDetails") != null) {
				reqParams.put("statusMessage", processDMSDocDtls(reqParams));
				reqParams.put("INTERFACE_TYPE", "SERVICE");
			}
		}
		catch(Exception exp) {
			System.out.println("(EMExternalInterface:processRequest) Error - " + exp.getMessage());
			exp.printStackTrace(System.err);
			reqParams.put("statusMessage", XHUtil.getMessage("1", "en"));
		}
		
		return reqParams;
	}
	public void addInteractiveParams(Map<String, String> reqParams, HttpServletRequest request)
	{
		String strDate = XHUtil.getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", null);
		reqParams.put("MODULE_ID", "XH");
		reqParams.put("REQUEST_DATE", strDate);
		reqParams.put("MESSAGE_DATE", strDate);
		reqParams.put("SESSION_ID", request.getSession().getId());
	}
	public String processDMSDocDtls(Map<String, String> reqParams)
	{
		String t01Msg = "";
		String statusMessage = null;
		String requestSyntax = "PatientID|DMS RecipientID|EncounterID|EM Order number|Unique Document Number|Observation Identifier|Observation Sub-ID|Scan Techncian|Scan Date|Document Status|Status Change Date Time|Reviewing Practitioner|FacilityID|User|Workstation|Filename";
		String [] docDtls = reqParams.get("documentDetails").split(Pattern.quote("|"));
		
		try {
			String appID = XHUtil.singleParamExeQry("SELECT application_id FROM xh_protocol_link WHERE protocol_link_id = '"+ DMS_PROTOCOL_LINK +"'");
			reqParams.put("facilityID", docDtls[12]);
			reqParams.put("protocolLinkID", DMS_PROTOCOL_LINK);
			reqParams.put("processID", "");
			reqParams.put("APPLICATION_ID", appID);
			reqParams.put("EVENT_TYPE", "T13");
			reqParams.put("PATIENT_ID", docDtls[0]);
			reqParams.put("ENCOUNTER_ID", docDtls[2]);
			reqParams.put("REQUEST_SYNTAX", requestSyntax);
			reqParams.put("PROTOCOL_LINK_ID", DMS_PROTOCOL_LINK);
			reqParams.put("LOGIN_USER", docDtls[13]);
			reqParams.put("FACILITY_ID", docDtls[12]);
			reqParams.put("CLIENT_MACHINE", docDtls[14]);
			reqParams.put("PGM_ID", appID);
			reqParams.put("SESSION_ID", reqParams.get("SESSION_ID"));
			
			t01Msg = buildT01Msg(reqParams);
			reqParams.put("message", t01Msg);
			reqParams.put("REQUEST_TEXT", t01Msg);
			
			statusMessage = XHUtil.processInboundMessage(reqParams);
			
			reqParams.put("RESPONSE_TEXT", statusMessage);
			System.out.println("(EMExternalInterface:processDMSDocDtls) Parameters " + reqParams);
			XHUtil.updateInteractiveDetails(reqParams);
		}
		catch(Exception exp) {
			System.out.println("(EMExternalInterface:processDMSDocDtls) Error - " + exp.getMessage());
			exp.printStackTrace(System.err);
			statusMessage = XHUtil.getMessage("1", reqParams.get("locale"));
		}
		
		return statusMessage;
	}
	public String buildT01Msg(Map<String, String> reqParams) 
	{
		StringBuilder message = new StringBuilder();
		XHUtil.getMessageDelimiters(reqParams, DMS_PROTOCOL_LINK, null);
		System.out.println("reqParams "+reqParams);
		
		message.append(reqParams.get("messageStart"));
		message.append(buildMSHSegment(reqParams));
		message.append(buildPIDSegment(reqParams));
		message.append(buildPV1Segment(reqParams));
		message.append(buildTXASegment(reqParams));
		message.append(reqParams.get("messageEnd"));
		
		return message.toString();
	}
	public String buildTXASegment(Map<String, String> reqParams) 
	{
		String txaSegment = "";
		List<String> txaContents = new ArrayList<String>();
		String [] docDtls = reqParams.get("documentDetails").split(Pattern.quote("|")); 
		
		txaContents.add("TXA");
		txaContents.add(docDtls[1]);
		txaContents.add((docDtls[3].contains("!") || docDtls[3].equals("")) ? docDtls[3] : docDtls[3] + "!1");
		txaContents.add(docDtls[4]);
		txaContents.add(docDtls[3]);
		txaContents.add(docDtls[5]);
		txaContents.add(docDtls[6]);
		txaContents.add(docDtls[7]);
		txaContents.add(docDtls[8]);
		txaContents.add(docDtls[9]);
		txaContents.add(docDtls[10]);
		txaContents.add(docDtls[11]);
		txaContents.add(docDtls[12]);
		txaContents.add(docDtls[13]);
		txaContents.add(docDtls[14]);
		txaContents.add(docDtls[15]);

		txaSegment = buildSegment(txaContents, reqParams);
		
		return txaSegment;
	}
	public String buildPV1Segment(Map<String, String> reqParams) 
	{
		String pv1Segment = "";
		List<String> pv1Contents = new ArrayList<String>();
		
		pv1Contents.add("PV1");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add("");
		pv1Contents.add(reqParams.get("ENCOUNTER_ID"));
		pv1Segment = buildSegment(pv1Contents, reqParams);
		
		return pv1Segment;
	}
	
	public String buildPIDSegment(Map<String, String> reqParams) 
	{
		String pidSegment = "";
		List<String> pidContents = new ArrayList<String>();
		
		pidContents.add("PID");
		pidContents.add("");
		pidContents.add("");
		pidContents.add(reqParams.get("PATIENT_ID"));
		pidSegment = buildSegment(pidContents, reqParams);
		
		return pidSegment;
	}
	public String buildMSHSegment(Map<String, String> reqParams) 
	{
		String mshSegment = "";
		List<String> mshContents = new ArrayList<String>();
		
		mshContents.add("MSH");
		mshContents.add("^~\\&");
		mshContents.add("DMS");
		mshContents.add(reqParams.get("FACILITY_ID"));
		mshContents.add("DMS");
		mshContents.add(reqParams.get("FACILITY_ID"));
		mshContents.add(XHUtil.convertDateToStr(null, "yyyyMMddHHmmss"));
		mshContents.add("");
		mshContents.add("MDM^T13");
		mshContents.add(XHUtil.singleParamExeQry("SELECT xh_hl7_message_id_seq.NEXTVAL FROM DUAL"));
		mshContents.add("P");
		mshContents.add("2.3.1");
		mshContents.add("");
		mshContents.add("");
		mshContents.add("AL");
		mshSegment = buildSegment(mshContents, reqParams);
		
		return mshSegment;
	}
	public String buildSegment(List<String> segmentContentList, Map<String, String> reqParams)
	{
		StringBuilder segment = new StringBuilder();
		for(String field : segmentContentList) {
			segment.append(field);
			segment.append(reqParams.get("fieldSeperator"));
		}
		segment.append(reqParams.get("segmentEnd"));
		return segment.toString();
	}
	public String processPatientHistoryParams(Map<String, String> reqParams) 
	{
		StringBuilder additionalParams = new StringBuilder();
		additionalParams.append("p_user_password=");
		additionalParams.append(getEMEncryptedPwd(reqParams.get("p_login_user")));
		return additionalParams.toString();
	}
	public String getEMEncryptedPwd(String userID) 
	{
		String qry = "SELECT APPL_USER_PASSWORD FROM SM_APPL_USER WHERE APPL_USER_ID = '" + userID + "'";
		return XHUtil.singleParamExeQry(qry);
	}
	
}
