/*
Sr No        Version           TFS/Incident        SCF/CRF            			Developer Name
--------------------------------------------------------------------------------------------------
1            V210129            13523			MOHE-CRF-0060       			Shikha Seth
2				V221230							NMC-JD-CRF-0191.1 			Mohanapriya
--------------------------------------------------------------------------------------------------
 */

package eBL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.PersistenceHelper;

import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import eBL.billreceipt.request.BillGenerationRequest;
import eBL.billreceipt.response.BillGenerationResponse;
import eBL.placeorder.response.PlaceNewOrderResponse;

/**
 * This Servlet routes the Request from New Order Related Pages to EJB ChargePatientNewOrder.
 * Response Object is recieved by this Servlet.
 * Decides Whether Error occurred in Transaction.
 * Based on the Error Rsponse is redirected to BLExistingOrderMessage.jsp  
 * @author ravaradharajan
 *
 */
public class BillReceiptGenerationServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; //commented checkstyle
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillReceiptGenerationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Locale loc = null;
		ResourceBundle rb = null;
		try{
			HttpSession session = request.getSession(false);
			String locale = (String)session.getAttribute("LOCALE");
			Properties p = (java.util.Properties) session.getValue( "jdbc" );
			String login_user = p.getProperty( "login_user" ) ;
			String facility_id = (String) session.getValue( "facility_id" );
			String client_ip_address = p.getProperty("client_ip_address");
			String blngGrpId = request.getParameter("blngGrpId");
			//V221230
			String ZatcaYN = replaceNull(request.getParameter("ZatcaYN"));
			System.err.println("ZatcaYN billgenServlet "+ZatcaYN);
			String orgBillRefNum="";
			if(ZatcaYN.equals("Y")){
				orgBillRefNum = request.getParameter("orgBillRefNum");
				System.err.println("orgBillRefNum billgenServlet "+orgBillRefNum);
			}
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eSM.resources.Messages",loc);
			BillGenerationRequest billGenrequest = new BillGenerationRequest();
			BillGenerationResponse billGenResponse = new BillGenerationResponse();
			billGenrequest.setEncounterFacilityId(request.getParameter("encounterFacilityId")); //V210129
			billGenrequest.setFacilityId(facility_id);
			billGenrequest.setPatientId(request.getParameter("patient_id"));
			billGenrequest.setEpisodeType(request.getParameter("episode_type"));
			billGenrequest.setEpisodeId(request.getParameter("episode_id"));
			billGenrequest.setVisitId(request.getParameter("visit_id"));
			billGenrequest.setCashCntrCode(request.getParameter("hdnCntrUserName"));
			billGenrequest.setShiftId(request.getParameter("hdnCntrUserShift"));
			billGenrequest.setPrevUnBilled(request.getParameter("hdnUnBillAmt"));
			billGenrequest.setEncounterId(request.getParameter("encounter_id"));
			billGenrequest.setLoginUser(login_user);
			billGenrequest.setAltIdType(request.getParameter("altIdType"));
			billGenrequest.setAltIdNo(request.getParameter("altIdNo"));
			billGenrequest.setPatientName(request.getParameter("patientName"));
			billGenrequest.setRemarks(request.getParameter("remarks"));
			billGenrequest.setExemptType(request.getParameter("exemptType"));
			billGenrequest.setExemptAmt(request.getParameter("exemptAmt"));
			billGenrequest.setAssignTo(request.getParameter("assignTo"));
			billGenrequest.setClientIpAddress(client_ip_address);
			billGenrequest.setServLocn(request.getParameter("serviceLocation"));
			if("on".equals(request.getParameter("depAdjChk"))){
				billGenrequest.setDepAdjYn("Y");
			}
			else{
				billGenrequest.setDepAdjYn("N");
			}
			
			if("on".equals(request.getParameter("prePayChk"))){
				billGenrequest.setPrePayAdjYn("Y");			
			}
			else{
				billGenrequest.setPrePayAdjYn("N");
			}
			billGenrequest.setMinDepAdjYn(request.getParameter("splDepChk"));
			billGenrequest.setPkgClosedYn(request.getParameter("pkgClosedYn"));
			
			billGenrequest.setPkgSeqNo(request.getParameter("pkgSeqNo"));
			billGenrequest.setTotalCount(request.getParameter("totalCount"));
			billGenrequest.setPackageCode(request.getParameter("packageCode"));
			billGenrequest.setDocAmt(request.getParameter("docAmt"));
			
			String visitTypeCode = request.getParameter("visitTypeCode");
			if(visitTypeCode == null || "null".equals(visitTypeCode)){
				visitTypeCode = "";
			}
			
			billGenrequest.setVstTypeCode(visitTypeCode);
			billGenrequest.setSlmtAmt(request.getParameter("slmtAmt"));
			billGenrequest.setExemptAmt(request.getParameter("exemptAmt"));
			billGenrequest.setBillGenOpt(request.getParameter("billGenOpt"));
			billGenrequest.setBillGenType(request.getParameter("billGenType"));
			billGenrequest.setIpBillType(request.getParameter("inPatBillType"));
			String beanId = "BillReceiptExistOrderExclusion" ;
			String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
			BillReceiptExistOrderExclusion exclusionBean = (BillReceiptExistOrderExclusion) PersistenceHelper.getObjectFromBean(beanId, beanName, session) ;
			
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE"))) {
				local_ejbs = true;
			}

			Object home = ServiceLocator.getInstance().getHome(
					"java:comp/env/BillGeneration",eBL.BillGeneration.BillGenerationHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create")).invoke(home);
		//	HashMap results = new HashMap(); //commented checkstyle
			
			Object argArray[]  = new Object[2];
			argArray[0] = billGenrequest;	
			argArray[1] = exclusionBean;	


			Class [] paramArray	   = new Class[2];
			paramArray[0] = billGenrequest.getClass();
			paramArray[1] = exclusionBean.getClass();
			
			billGenResponse=(BillGenerationResponse) (busObj.getClass().getMethod("generateBills",paramArray)).invoke(busObj, argArray);
			
			List<String> errorList = billGenResponse.getErrorList();

			if(errorList == null){
				errorList = new ArrayList<String>();
			}
			
			
			StringBuffer consErrorText = new StringBuffer();
			String error = "";
			int err_val = 1;
			if(!errorList.isEmpty()){
				for (Iterator<String> iterator = errorList.iterator(); iterator.hasNext();) {
					err_val = 2;
					error = (String) iterator.next();
					if(!"".equals(replaceNull(error))){
						consErrorText.append(error);
						consErrorText.append("<br/>");
					}					
				}
				error = consErrorText.toString();
			}
			
			
			if("".equals(error)){
				/*if("Y".equals(billGenResponse.getUnProcessedExists())){
					err_val = 2;
					error = "Bill not Generated"+"<br/>"+"Unconfirmed Services Exists";
				}
				else{*/
					try{
						error = rb.getString("RECORD_INSERTED");
						session.setAttribute("billRecBillGenNum", billGenResponse.getGeneratedBillS());
					}
					catch(Exception rbException){
						System.err.println("Exceprion in RB ->"+rbException);
						error = "APP-SM0070 Operation Completed Successfully ....";
					}
				//}
			}
			else{
				error = "Bill not Generated"+"<br/>"+error;
			}
			response.sendRedirect("../eBL/jsp/BillReceiptMessage.jsp?calledFrom=billGeneration&err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val+
					"&billDocType="+billGenResponse.getBillDocTypeCode()+
					"&receiptDocType="+billGenResponse.getReceiptDocTypeCode()+
					"&refundDocType="+billGenResponse.getRefundDocTypeCode()+
					"&blngGrpId="+blngGrpId+
					"&patientId="+billGenrequest.getPatientId()+
					"&episodeType="+billGenrequest.getEpisodeType()+
					"&episodeId="+billGenrequest.getEpisodeId()+
					"&visitId="+billGenrequest.getVisitId()+
					"&billSlmtAmt="+billGenrequest.getSlmtAmt()+
					"&billDocAmt="+billGenrequest.getDocAmt()+
					"&billExemptAmt="+billGenrequest.getExemptAmt()+
					"&patDocType="+billGenResponse.getPatDocType()+
					"&patDocNum="+billGenResponse.getPatDocNum()+
					"&billPrintYn="+billGenResponse.getBillPrintYn()+
					"&Pgmid="+billGenResponse.getPgm_id()+
					"&PgmDate="+billGenResponse.getPgm_date()+
					"&Sessionid="+billGenResponse.getSession_id()+
					"&billMessage="+billGenResponse.getGeneratedBillS()+
					"&unProcessedYn="+billGenResponse.getUnProcessedExists()+
					"&invokeSlmt="+billGenResponse.getInvokeSlmt()+
					"&exemptWarning="+billGenResponse.getExemptWarning()+
					"&exemptConsWarning="+billGenResponse.getExemptConsWarning()+
					"&slmtMsgId="+billGenResponse.getSlmtValidationMsg()+
					"&orgBillRefNum="+orgBillRefNum);//V221230
					
		}
		catch(Exception e){
			System.err.println("Exception in Bill Generation Servlet ->"+e);
			e.printStackTrace();
			response.sendRedirect("../eBL/jsp/BillReceiptMessage.jsp?calledFrom=billGeneration&err_num=" + java.net.URLEncoder.encode( e.getMessage(),"UTF-8" ) +"&err_value=2");
		}
	}
	
	private String replaceNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		
		return input;
	}
}
