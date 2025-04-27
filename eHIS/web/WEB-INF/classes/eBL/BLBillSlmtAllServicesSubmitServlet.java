/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law. 
 ******************************************************************************/
/*
Sr No        Version           TFS/Incident        SCF/CRF            		 			Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129            13523        	 MOHE-CRF-0060       					Shikha Seth
2            V210416            17021        	Common-ICN-0009-TF	           			Mohana Priya K
--------------------------------------------------------------------------------------------------------
 */

package eBL;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
*/
import org.json.simple.JSONObject;

import webbeans.eCommon.ConnectionManager;

import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.PersistenceHelper;


public class BLBillSlmtAllServicesSubmitServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	java.util.Properties p;
	PrintWriter out;

	/**
	 * Default constructor.
	 */
	public BLBillSlmtAllServicesSubmitServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
    	multiBillSettlement(request, response);
	}


String toDateFormat(String date,int type) throws ParseException{	
	if(date==null || date.equals("")){
		return null;
	}	
	String formattedDate;	
    String oldFormat = "dd/MM/yyyy HH:mm";// 2013-10-08 17:15:33.0
	if(type==1){
		oldFormat = "dd/MM/yyyy HH:mm";
	}else if(type==2){
		oldFormat = "dd/MM/yyyy";
	}

    String newFormat = "yyyy-MM-dd hh:mm:ss";
    SimpleDateFormat sdfOld = new SimpleDateFormat(oldFormat);
    SimpleDateFormat sdfNew = new SimpleDateFormat(newFormat);    
	formattedDate=sdfNew.format(sdfOld.parse(date));	
	return formattedDate;		
} 

Double toDoubleFormat(String number){	
	if(number==null || number.equals("")){
		return 0.0;
	}	
	Double formattedNumber;		
	formattedNumber=Double.parseDouble(number);
	return formattedNumber;		
} 

Integer toIntegerFormat(String number){	
	if(number==null || number.equals("")){
		return 0;
	}	
	Integer formattedNumber;		
	formattedNumber=Integer.parseInt(number);
	return formattedNumber;		
} 

String nullFormatter(String input){
	if(input==null){
		return "";
	}else{
		return input;
	}
}
	

	/*
	 * This method invokes the EJB component and it updates or Inserts Records
	 * in the DB based on the passing Parameter.
	 */
	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public void multiBillSettlement(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session=request.getSession(false);
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs =null;

		try{				
				System.out.println("getQueryString episode type: "+ request.getQueryString() );
			    String record_count=request.getParameter("total_records")==null ? "0": request.getParameter("total_records");
			    int total_records=Integer.parseInt(record_count);			    
			    
				/* Parameters for Procedure Call */
			    String ecnounterFacilityId = request.getParameter("strfacilityid");  //V210129
				String facility_id = (String) session.getValue("facility_id");
				String language_id = (String)session.getAttribute("LOCALE");
				String cust_code = "";
				String episode_type = request.getParameter("episode_type"); //
				String slmt_amt =request.getParameter("slmt_amt");
				String outst_amt=request.getParameter("outst_amt");
				String user_id =(String) session.getValue("login_user");
				HttpSession httpSession = request.getSession(false);
				Properties p = (Properties)httpSession.getValue("jdbc");	
				String ws_no = p.getProperty("client_ip_address");
				//String slmt_doc_type_code = ""; //commented V210416
				//String slmt_doc_num = ""; //commented V210416
				String cash_amt_given ="0";
				String cash_amt_returned = "0";
				String slmtModeWiseWcptYN="";
				/*Parameter for Procedure Call ends*/
		    
				/* Array of BILL_DOC_NUMBERS is Constructed here - Start  */	
				String beanId = "BillDetailsBean";
				String beanName = "eBL.BLBillDetailsBean";
				BLBillDetailsBean bean=(BLBillDetailsBean) getBeanObject(beanId, beanName, request);
				HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap=bean.getBillDtlMap();
				ArrayList<BLBillDetailsBean> billDetailList=billDtlMap.get("REPRINT");
				int bill_doc_rec_count=billDetailList.size(); // Total Records Placed in Array
				System.out.println("176,bill_doc_rec_count "+bill_doc_rec_count);
			 	/*StructDescriptor bill_doc_record_descriptor =  StructDescriptor.createDescriptor("IBAEHIS.BILL_DOC_NUMBERS",con);
			    ArrayDescriptor bill_doc_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.BILL_DTLS", con);
			    
				Object[] bill_doc_numbers_record_array = new Object[bill_doc_rec_count];  // to store n number of object data
			    Object[] bill_doc_numbers_object   = new Object[15];  // to store object data
			    */
				StringBuffer patientIdStr=new StringBuffer();
				StringBuffer episodeTypeStr=new StringBuffer();
				StringBuffer episodeIdStr=new StringBuffer();
				StringBuffer visitIdStr=new StringBuffer();
				StringBuffer DocTypeCodeStr=new StringBuffer();
				StringBuffer docNumStr=new StringBuffer();
				StringBuffer billTotAmtStr=new StringBuffer();
				StringBuffer docDateStr=new StringBuffer();
				StringBuffer totOutAmtStr=new StringBuffer();
				StringBuffer remSlmtAmtStr=new StringBuffer();
				StringBuffer billPrintYNStr=new StringBuffer();
				StringBuffer recptNatureStr=new StringBuffer();
				
				StringBuffer rcptTypeCodeStr=new StringBuffer();
				StringBuffer extAccCodeStr=new StringBuffer();
				StringBuffer extAccDeptSTr=new StringBuffer();
				
			    for(int rec_count=0; rec_count<bill_doc_rec_count; rec_count++){
			    	if(!"".equals(billDetailList.get(rec_count).getPatientId())){
			    			patientIdStr.append(billDetailList.get(rec_count).getPatientId()).append("|");
					}else{
						patientIdStr.append(" ").append("|");
					}
			    	System.err.println("patientIdStr->"+patientIdStr.toString());
			    	if(!"".equals(billDetailList.get(rec_count).getEpisodeType())){
			    		episodeTypeStr.append(billDetailList.get(rec_count).getEpisodeType()).append("|");
			    	}else{
			    		episodeTypeStr.append(" ").append("|");
			    	}
			    	
			    	if(!"".equals(billDetailList.get(rec_count).getEpisodeId())){
			    		episodeIdStr.append(toIntegerFormat(billDetailList.get(rec_count).getEpisodeId())).append("|");
			    	}else{
			    		episodeIdStr.append(" ").append("|");
			    	}
			    	
			    	if(!"".equals(billDetailList.get(rec_count).getVisitId())){
			    		visitIdStr.append(toIntegerFormat(billDetailList.get(rec_count).getVisitId())).append("|");
			    	}else{
			    		visitIdStr.append(" ").append("|");
			    	}
			    	
			    	if(!"".equals(billDetailList.get(rec_count).getDocTypeCode())){
			    		DocTypeCodeStr.append(billDetailList.get(rec_count).getDocTypeCode()).append("|");
			    	}else{
			    		DocTypeCodeStr.append(" ").append("|");
			    	}
			    	 System.out.println("DocTypeCodeStr->"+DocTypeCodeStr.toString());
			    	if(!"".equals(billDetailList.get(rec_count).getDocNum())){
			    		docNumStr.append(toIntegerFormat(billDetailList.get(rec_count).getDocNum())).append("|");
			    	}else{
			    		docNumStr.append(" ").append("|");
			    	}
			    	if(!"".equals(billDetailList.get(rec_count).getBillTotAmt())){
			    		billTotAmtStr.append(toDoubleFormat(billDetailList.get(rec_count).getBillTotAmt())).append("|");
			    		System.out.println("billTotAmtStr->"+billTotAmtStr.toString());
					}else{
			    		billTotAmtStr.append("0").append("|");
			    	}
			    	 	
			    	if(!"".equals(billDetailList.get(rec_count).getDocDate())){
			    		docDateStr.append(toDateFormat(billDetailList.get(rec_count).getDocDate(),1)).append("|");
			    	}else{
			    		docDateStr.append(" ").append("|");
			    	}
			    	 System.out.println("docDateStr->"+docDateStr.toString());

			    	if(!"".equals(billDetailList.get(rec_count).getTotOutStdAmt())){
			    		totOutAmtStr.append(toDoubleFormat(billDetailList.get(rec_count).getTotOutStdAmt())).append("|");
			    	}else{
			    		totOutAmtStr.append(" ").append("|");
			    	}
					System.out.println("totOutAmtStr->"+totOutAmtStr.toString());
			    	if(!"".equals(billDetailList.get(rec_count).getRemSlmtAmt())){
			    		remSlmtAmtStr.append(toDoubleFormat(billDetailList.get(rec_count).getRemSlmtAmt())).append("|");
			    	}else{
			    		remSlmtAmtStr.append(" ").append("|");
			    	}
					System.out.println("remSlmtAmtStr->"+remSlmtAmtStr.toString());
			    	
			    	if(!"".equals(billDetailList.get(rec_count).getBillPrintYn())){
			    		billPrintYNStr.append(billDetailList.get(rec_count).getBillPrintYn()).append("|");
			    	}else{
			    		billPrintYNStr.append(" ").append("|");
			    	}
			    	if(!"".equals(billDetailList.get(rec_count).getReceiptNature())){
			    		recptNatureStr.append(billDetailList.get(rec_count).getReceiptNature()).append("|");
			    	}else{
			    		recptNatureStr.append(" ").append("|");
			    	}
			    	if(!"".equals(billDetailList.get(rec_count).getReceiptTypeCode())){
			    		rcptTypeCodeStr.append(billDetailList.get(rec_count).getReceiptTypeCode()).append("|");
			    	}else{
			    		rcptTypeCodeStr.append(" ").append("|");
			    	}
					
			    	if(!"".equals(billDetailList.get(rec_count).getExtAccCode())){
			    		extAccCodeStr.append(billDetailList.get(rec_count).getExtAccCode()).append("|");
			    	}else{
			    		extAccCodeStr.append(" ").append("|");
			    	}
			    	if(!"".equals(billDetailList.get(rec_count).getExtAccDept())){
			    		extAccDeptSTr.append(billDetailList.get(rec_count).getExtAccDept()).append("|");
			    	}else{
			    		extAccDeptSTr.append(" ").append("|");
			    	}
					//System.out.println("extAccDeptSTr->"+extAccDeptSTr.toString());
/*	patientIdStr episodeTypeStr episodeIdStr visitIdStr DocTypeCodeStr
			    	docNumStr
			    	billTotAmtStr
			    	docDateStr
			    	totOutAmtStr
			    	remSlmtAmtStr
			    	billPrintYNStr
			    	recptNatureStr
			    	rcptTypeCodeStr
			    	extAccCodeStr
			    	extAccDeptSTr		
			    		  bill_doc_numbers_object[0]=billDetailList.get(rec_count).getPatientId();
			    bill_doc_numbers_object[1]=billDetailList.get(rec_count).getEpisodeType();
			    bill_doc_numbers_object[2]=toIntegerFormat(billDetailList.get(rec_count).getEpisodeId());
			    bill_doc_numbers_object[3]=toIntegerFormat(billDetailList.get(rec_count).getVisitId());
			    bill_doc_numbers_object[4]=billDetailList.get(rec_count).getDocTypeCode();
			    bill_doc_numbers_object[5]=toIntegerFormat(billDetailList.get(rec_count).getDocNum());
			    bill_doc_numbers_object[6]=toDoubleFormat(billDetailList.get(rec_count).getBillTotAmt());
			    bill_doc_numbers_object[7]=toDateFormat(billDetailList.get(rec_count).getDocDate(),1);
			    bill_doc_numbers_object[8]=toDoubleFormat(billDetailList.get(rec_count).getTotOutStdAmt());
			    bill_doc_numbers_object[9]=toDoubleFormat(billDetailList.get(rec_count).getRemSlmtAmt());
			    System.err.println("bill_doc_numbers_object[9] ->"+bill_doc_numbers_object[9]);
			    bill_doc_numbers_object[10]=billDetailList.get(rec_count).getBillPrintYn();
			    System.err.println("bill_doc_numbers_object[10] ->"+bill_doc_numbers_object[10]);
			    bill_doc_numbers_object[11]=billDetailList.get(rec_count).getReceiptNature();
			    bill_doc_numbers_object[12]=billDetailList.get(rec_count).getReceiptTypeCode();
			    System.err.println("bill_doc_numbers_object[11] ->"+bill_doc_numbers_object[11]);
			    System.err.println("bill_doc_numbers_object[12] ->"+bill_doc_numbers_object[12]);
			    bill_doc_numbers_object[13]=billDetailList.get(rec_count).getExtAccCode();
			    bill_doc_numbers_object[14]=billDetailList.get(rec_count).getExtAccDept();
			    System.out.println(Arrays.asList(bill_doc_numbers_object));
			    */
			   // STRUCT bill_doc_numbers_record = new STRUCT(bill_doc_record_descriptor, con, bill_doc_numbers_object);     
			//	bill_doc_numbers_record_array[rec_count]=bill_doc_numbers_record;	
				
			    }    
			   // ARRAY bill_doc_numbers_parameter_array = new ARRAY(bill_doc_array_descriptor,con,bill_doc_numbers_record_array);
				//System.out.println("BILL_DOC_NUMBERS - BILL_DTLS"+ Arrays.asList(bill_doc_numbers_parameter_array)); 
				/* Array of BILL_DOC_NUMBERS is Constructed here - End  */
			
				/* Array of DEPOSIT_DTLS is Constructed Here   - Start */
			   // ARRAY deposit_parameter_array = (ARRAY) session.getAttribute("deposit_parameter_array_session");
			    /*StringBuffer deposit_parameter_array=new StringBuffer();
			    if(!"".equals(session.getAttribute("deposit_parameter_array_session"))){
			    	deposit_parameter_array.append(session.getAttribute("deposit_parameter_array_session")).append("|");
		    	
			    	
			    	session.setAttribute("depDocTypeStr",depDocTypeStr);
					   session.setAttribute("depdocNumStr",depdocNumStr);
					   session.setAttribute("depSrlnoStr",depSrlnoStr);
					   session.setAttribute("depSlmtTypStr",depSlmtTypStr);
					   session.setAttribute("depDepositStr",depDepositStr);
					   session.setAttribute("depAdjAmtStr",depAdjAmtStr);
					   session.setAttribute("depremarkStr",depremarkStr);
					  
			    }else{
		    		deposit_parameter_array.append(" ").append("|");
		    	}
			    System.out.println("DEPOSIT_DTLS"+deposit_parameter_array.toString());
			  */ /* l_DEP_DOC_TYPE_CODE 		VARCHAR2(6);
		        l_DEP_DOC_NUMBER 			NUMBER;
		        l_DEP_DOC_SRNO 				NUMBER;
		        l_DEP_SLMT_TYPE  			VARCHAR2(2);
		        l_DEP_AMT 					NUMBER;
		        l_DEP_ADJ 					NUMBER;
		        l_DEPOSIT_REMARKS */
			    
			    /*boolean addDepositInSettlement=false;
				if(deposit_parameter_array==null){
				    ArrayDescriptor deposit_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.DEP_DTLS", con);
					deposit_parameter_array = new ARRAY(deposit_array_descriptor,con,new Object[1]);    
				}else{
					addDepositInSettlement=true;
				}
				System.out.println("DEPOSIT_DTLS"+ Arrays.asList(deposit_parameter_array));
				*//* Array of DEPOSIT_DTLS is Constructed Here   - End */
				
			    
				/* Array of SLMT_MODE is Constructed here - Data from BillSlmtTypeForm Starts */
				/*StructDescriptor slmt_mode_record_descriptor = StructDescriptor.createDescriptor("IBAEHIS.SLMT_MODE", con);
				ArrayDescriptor slmt_mode_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.SLMT_DTLS", con);
			  */  
			    
				Object[] slmt_mode_record_array = new Object[total_records];  // to store n number of object data
			    Object[] slmt_mode_object   = new Object[13];  // to store object data		//size changed from 12 to 13 for addition TID No by Monika against NMC-JD-CRF-0199
			    StringBuffer slmtTypeStr=new StringBuffer();
			    StringBuffer billslmtamtStr=new StringBuffer();
			    StringBuffer slmtSrnoStr=new StringBuffer();
			    StringBuffer SlmtDocRefStr=new StringBuffer();
			    StringBuffer instdateStr=new StringBuffer();
			   
			    StringBuffer instremarkcodeStr=new StringBuffer();
			    StringBuffer rcpt_rfnd_idStr=new StringBuffer();
			    StringBuffer payernameStr=new StringBuffer();
			    StringBuffer apprrefnoStr=new StringBuffer();
			   
			    StringBuffer onlineapprovalChckStr=new StringBuffer();
			    StringBuffer batchnoStr=new StringBuffer();
			    StringBuffer saledraftnoStr=new StringBuffer();
			    StringBuffer cc_term_id_numStr=new StringBuffer();
			   
			  for(int rec_count=0; rec_count<total_records ;rec_count++){
				    String slmtType=request.getParameter("slmttype"+rec_count);
					System.out.println("slmtType "+slmtType);
				    slmtType=slmtType.substring(0,2);
				    if(slmtType.equals("CA")){
				    	cash_amt_given=	request.getParameter("cash_given"+rec_count);
				    	cash_amt_returned=request.getParameter("cash_return"+rec_count);
				    }
				    if(!"".equals(slmtType)){
				    	slmtTypeStr.append(slmtType).append("|");
			    	}else{
			    		slmtTypeStr.append(" ").append("|");
			    	}
				    if(!"".equals(Float.parseFloat(request.getParameter("billslmtamt"+rec_count)))){
				    	billslmtamtStr.append(Float.parseFloat(request.getParameter("billslmtamt"+rec_count))).append("|");
			    	}else{
			    		billslmtamtStr.append("0").append("|");
			    	}
				    System.out.println("billslmtamtStr "+billslmtamtStr);
				   	slmtSrnoStr.append("0").append("|");
				   	SlmtDocRefStr.append(" ").append("|"); //null
				    System.out.println("SlmtDocRefStr "+SlmtDocRefStr);
				   	if(!"".equals(request.getParameter("instdate"+rec_count))){
				   		instdateStr.append(toDateFormat(request.getParameter("instdate"+rec_count),2)).append("|");
			    	}else{
			    		instdateStr.append(" ").append("|");
			    	}
				   	if(!"".equals(nullFormatter(request.getParameter("instremarkcode"+rec_count)))){
				   		instremarkcodeStr.append(nullFormatter(request.getParameter("instremarkcode"+rec_count))).append("|");
			    	}else{
			    		instremarkcodeStr.append(" ").append("|");
			    	}
				    System.out.println("instremarkcodeStr "+instremarkcodeStr);
				   	rcpt_rfnd_idStr.append("0").append("|");
				   	if(!"".equals(request.getParameter("payername"+rec_count))){
				   		payernameStr.append(request.getParameter("payername"+rec_count)).append("|");
			    	}else{
			    		payernameStr.append(" ").append("|");
			    	}
				   	if(!"".equals(request.getParameter("apprrefno"+rec_count))){
				   		apprrefnoStr.append(request.getParameter("apprrefno"+rec_count)).append("|");
			    	}else{
			    		apprrefnoStr.append(" ").append("|");
			    	}
				    System.out.println("apprrefnoStr "+apprrefnoStr);
					String onlineApprovalCheckedYN= nullFormatter(request.getParameter("onlineapproval"+rec_count)).equalsIgnoreCase("checked") ? "Y" : "N";
					if(!"".equals(onlineApprovalCheckedYN)){
						onlineapprovalChckStr.append(onlineApprovalCheckedYN).append("|");
			    	}
					System.out.println("onlineapprovalChckStr "+onlineapprovalChckStr);
					if(!"".equals(request.getParameter("batchno"+rec_count))){
						batchnoStr.append(request.getParameter("batchno"+rec_count)).append("|");
			    	}else{
			    		batchnoStr.append(" ").append("|");
			    	}
					System.out.println("batchnoStr "+batchnoStr);
					if(!"".equals(request.getParameter("saledraftno"+rec_count))){
						saledraftnoStr.append(request.getParameter("saledraftno"+rec_count)).append("|");
			    	}else{
			    		saledraftnoStr.append(" ").append("|");
			    	}
					if(!"".equals(request.getParameter("cc_term_id_num"+rec_count))){
						cc_term_id_numStr.append(request.getParameter("cc_term_id_num"+rec_count)).append("|");
			    	}else{
			    		cc_term_id_numStr.append(" ").append("|");
			    	}
				    /* slmt_mode_object[0]=slmtType;
				    slmt_mode_object[1]=Float.parseFloat(request.getParameter("billslmtamt"+rec_count));
				    slmt_mode_object[2]=0; //slmt_srno
					slmt_mode_object[3]=null; //slmt_doc_ref
				    slmt_mode_object[4]=toDateFormat(request.getParameter("instdate"+rec_count),2);//slmt_doc_ref_date
					slmt_mode_object[5]=nullFormatter(request.getParameter("instremarkcode"+rec_count));//bank_cc_code
				    slmt_mode_object[6]=0;//rcpt_rfnd_id_no
				    slmt_mode_object[7]=request.getParameter("payername"+rec_count);
				    slmt_mode_object[8]=request.getParameter("apprrefno"+rec_count);
				    String onlineApprovalCheckedYN= nullFormatter(request.getParameter("onlineapproval"+rec_count)).equalsIgnoreCase("checked") ? "Y" : "N";
				    slmt_mode_object[9]=onlineApprovalCheckedYN;
				    slmt_mode_object[10]=request.getParameter("batchno"+rec_count);
					slmt_mode_object[11]=request.getParameter("saledraftno"+rec_count); 
					slmt_mode_object[12]=request.getParameter("cc_term_id_num"+rec_count); 	//  Added by Monika Gupta for NMC-JD-CRF-0199	
					*/
				    /*System.out.println(Arrays.asList(slmt_mode_object));
					
					STRUCT slmt_mode_record = new STRUCT(slmt_mode_record_descriptor,con, slmt_mode_object);
					slmt_mode_record_array[rec_count]=slmt_mode_record;*/
			    }
				  
			/*    ARRAY slmt_mode_parameter_array = new ARRAY(slmt_mode_array_descriptor,con,slmt_mode_record_array); 
				System.out.println("SLMT_MODE- SLMT_DTLS "+ Arrays.asList(slmt_mode_parameter_array)); 
			*/	/* Array of SLMT_MODE is Constructed here - Data from BillSlmtTypeForm Ends */
				
				
				/* Array of SETT_DTLS is Constructed Here - Starts */
					    
				TreeSet<BLBillSlmtServiceBean> slmt_by_svc_parameter_array_session = (TreeSet<BLBillSlmtServiceBean>) session.getAttribute("slmt_by_svc_parameter_array_session");
				Iterator<BLBillSlmtServiceBean> it=null;
			
				if(slmt_by_svc_parameter_array_session==null){
					total_records=1;
				}else{
					it=slmt_by_svc_parameter_array_session.iterator();
					total_records=slmt_by_svc_parameter_array_session.size();
				}
				
				/*StructDescriptor slmt_by_svc_record_descriptor = StructDescriptor.createDescriptor("IBAEHIS.SETT_BY_SERV", con);
				ArrayDescriptor slmt_by_svc_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.SETT_DTLS", con);
				*/
				Object[] slmt_by_svc_record_array = new Object[total_records]; // to store n number of object data
				Object[] slmt_by_svc_object = new Object[11]; // to store object data
				
				int servCount=0;
				 StringBuffer slmtDocTypeStr=new StringBuffer();
				 StringBuffer slmtBillNumStr=new StringBuffer();
				 StringBuffer slmtServdateStr=new StringBuffer();
				 StringBuffer slmtTrxDocRefStr=new StringBuffer();
				
				 StringBuffer smtTrxLineNoStr=new StringBuffer();
				 StringBuffer smtTrxSeqnoStr=new StringBuffer();
				 StringBuffer slmtBlngServStr=new StringBuffer();
				 StringBuffer slmtChrgAmtStr=new StringBuffer();
				
				 StringBuffer slmtSetAmtStr=new StringBuffer();
				 StringBuffer SmtUpdNetChrgStr=new StringBuffer();
				 StringBuffer slmtInclExclStr=new StringBuffer();
				
				 if(it!=null){
				   	while(it.hasNext()){
				   	BLBillSlmtServiceBean serviceBean=it.next();	
				   	System.out.println("serviceBean "+serviceBean.getBillDocType());
				   	if(!"".equals(serviceBean.getBillDocType())){
				   		slmtDocTypeStr.append(serviceBean.getBillDocType()).append("|");
			    	}else{
			    		slmtDocTypeStr.append(" ").append("|");
			    	}
				    if(!"".equals(serviceBean.getBillNumber())){
				    	slmtBillNumStr.append(Integer.parseInt(serviceBean.getBillNumber())).append("|");
			    	}else{
			    		slmtBillNumStr.append(" ").append("|");
			    	}
				    
				   	if(!"".equals(serviceBean.getServiceDate())){
				   		slmtServdateStr.append(toDateFormat(serviceBean.getServiceDate(),1)).append("|");
			    	}else{
			    		slmtServdateStr.append(" ").append("|");
			    	}
				   	System.out.println("slmtServdateStr "+slmtServdateStr);
				    if(!"".equals(serviceBean.getTrxDocRef())){
				    	slmtTrxDocRefStr.append(serviceBean.getTrxDocRef()).append("|");
			    	}else{
			    		slmtTrxDocRefStr.append(" ").append("|");
			    	}
				    if(!"".equals(serviceBean.getTrxDocRefLineNum())){
				   		smtTrxLineNoStr.append(Integer.parseInt(serviceBean.getTrxDocRefLineNum())).append("|");
			    	}else{
			    		smtTrxLineNoStr.append(" ").append("|");
			    	}
				    System.out.println("smtTrxLineNoStr "+smtTrxLineNoStr);
				    
				    if(!"".equals(serviceBean.getTrxDocRefSeqNum())){
				    	smtTrxSeqnoStr.append(Integer.parseInt(serviceBean.getTrxDocRefSeqNum())).append("|");
			    	}else{
			    		smtTrxSeqnoStr.append(" ").append("|");
			    	}
				    if(!"".equals(serviceBean.getBillingService())){
				    	slmtBlngServStr.append(serviceBean.getBillingService()).append("|");
			    	}else{
			    		slmtBlngServStr.append(" ").append("|");
			    	}
				    System.out.println("slmtBlngServStr "+slmtBlngServStr);
				    
				    if(!"".equals(serviceBean.getChargeAmt())){
				    	slmtChrgAmtStr.append(Double.parseDouble(serviceBean.getChargeAmt())).append("|");
			    	}else{
			    		slmtChrgAmtStr.append(" ").append("|");
			    	}
				    if(!"".equals(serviceBean.getSettledAmt())){
				    	slmtSetAmtStr.append(Double.parseDouble(serviceBean.getSettledAmt())).append("|");
			    	}else{
			    		slmtSetAmtStr.append(" ").append("|");
			    	}
				    System.out.println("slmtSetAmtStr "+slmtSetAmtStr);
				    
				    if(!"".equals(serviceBean.getUpdNetChargeAmt())){
				    	SmtUpdNetChrgStr.append(Double.parseDouble(serviceBean.getUpdNetChargeAmt())).append("|");
			    	}else{
			    		SmtUpdNetChrgStr.append(" ").append("|");
			    	}
				    if(!"".equals(serviceBean.getInclusionExclusionCriteria())){
				    	slmtInclExclStr.append(serviceBean.getInclusionExclusionCriteria()).append("|");
			    	}else{
			    		slmtInclExclStr.append(" ").append("|");
			    	}
				    System.out.println("slmtInclExclStr "+slmtInclExclStr);
				    
				   /*	
					slmt_by_svc_object[0] = serviceBean.getBillDocType();
					slmt_by_svc_object[1] = Integer.parseInt(serviceBean.getBillNumber());
					slmt_by_svc_object[2] = toDateFormat(serviceBean.getServiceDate(),1);
					slmt_by_svc_object[3] = serviceBean.getTrxDocRef();
					slmt_by_svc_object[4] = Integer.parseInt(serviceBean.getTrxDocRefLineNum());
					slmt_by_svc_object[5] = Integer.parseInt(serviceBean.getTrxDocRefSeqNum());
					slmt_by_svc_object[6] = serviceBean.getBillingService();
					slmt_by_svc_object[7] = Double.parseDouble(serviceBean.getChargeAmt());
					slmt_by_svc_object[8] = Double.parseDouble(serviceBean.getSettledAmt());
					slmt_by_svc_object[9] = Double.parseDouble(serviceBean.getUpdNetChargeAmt());
					slmt_by_svc_object[10] = serviceBean.getInclusionExclusionCriteria();
				
					System.out.println(Arrays.asList(slmt_by_svc_object));
				
					STRUCT slmt_by_svc_record = new STRUCT(slmt_by_svc_record_descriptor, con, slmt_by_svc_object);
					slmt_by_svc_record_array[servCount] = slmt_by_svc_record;
					
				*/	servCount++;
					}
				}	
				//ARRAY slmt_by_svc_parameter_array = new ARRAY(slmt_by_svc_array_descriptor, con, slmt_by_svc_record_array);
				//System.out.println("SETT_BY_SERV - SETT_DTLS");
			   /* Array of SETT_DTLS is Constructed Here - Ends */
					
					try{
						pstmt = con.prepareStatement("select slmt_mode_wise_rcpt_yn from bl_parameters where operating_facility_id=?");
						pstmt.setString(1,facility_id);
						rs = pstmt.executeQuery();					
						if(rs != null && rs.next()){
							slmtModeWiseWcptYN = rs.getString(1);
						}
					}catch(SQLException ex){
						ex.printStackTrace();
					}finally{
						rs.close();
						pstmt.close();
					}
					
					String error_level = "";
					String error_id = "";
					String error_text = "";
					String warningId = "";
					
					boolean local_ejbs = false;
					/*if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null)	&& 
							(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) {
						local_ejbs = true;
					}*/

					//Object home = ServiceLocator.getInstance().getHome("java:comp/env/MultiBillSettlement",eBL.MultiBillSettlement.MultiBillSettlementHome.class, local_ejbs);
					//Object busObj = (home.getClass().getMethod("create")).invoke(home);

				   HashMap<String, String> inputParameters = new HashMap<String, String>(); 			
				   inputParameters.put("facility_id", facility_id);
				   inputParameters.put("language_id", language_id);
				   inputParameters.put("cust_code", cust_code);
				   inputParameters.put("episode_type", episode_type);
				   inputParameters.put("slmt_amt", slmt_amt);
				   inputParameters.put("outst_amt",outst_amt);
				   inputParameters.put("user_id", user_id);
				   inputParameters.put("ws_no", ws_no);
				   inputParameters.put("cash_amt_given", cash_amt_given);
				   inputParameters.put("cash_amt_returned", cash_amt_returned);
				   inputParameters.put("ecnounterFacilityId", ecnounterFacilityId); //V210129
				   /*Params for Down time Entry*/
				   String downTimeEntry = request.getParameter("downTimeEntry");
				   String downType = "";
				   String downDoc = "";
				   String downDate = "";
				   String downReason = "";
				   String blRecRefInd = request.getParameter("blRecRefInd");
				   if(blRecRefInd == null || "null".equals(blRecRefInd)){
					   blRecRefInd = "";
				   }
				   if("Y".equals(downTimeEntry)){
					   downType = request.getParameter("downType");
					   downDoc = request.getParameter("downDoc");
					   downDate = request.getParameter("downDate");
					   downReason = request.getParameter("downReason");
					   inputParameters.put("downEntryYn", "Y");
				   }
				   else{
					   inputParameters.put("downEntryYn", "N");
				   }
				   
				   inputParameters.put("downType", downType);
				   inputParameters.put("downDoc", downDoc);
				   inputParameters.put("downDate", downDate);
				   inputParameters.put("downReason", downReason);
				   inputParameters.put("blRecRefInd", blRecRefInd);

				   //bill_doc_numbers_parameter_array
				   inputParameters.put("patientIdStr", patientIdStr.toString());
				   inputParameters.put("episodeTypeStr", episodeTypeStr.toString());
				   inputParameters.put("episodeIdStr", episodeIdStr.toString());
				   inputParameters.put("visitIdStr", visitIdStr.toString());
				   inputParameters.put("DocTypeCodeStr", DocTypeCodeStr.toString());
				   inputParameters.put("docNumStr", docNumStr.toString());
				   inputParameters.put("billTotAmtStr", billTotAmtStr.toString());
				   inputParameters.put("docDateStr", docDateStr.toString());
				   inputParameters.put("totOutAmtStr", totOutAmtStr.toString());
				   inputParameters.put("remSlmtAmtStr", remSlmtAmtStr.toString());
				   inputParameters.put("billPrintYNStr", billPrintYNStr.toString());
				   inputParameters.put("recptNatureStr", recptNatureStr.toString());
				   inputParameters.put("rcptTypeCodeStr", rcptTypeCodeStr.toString());
				   inputParameters.put("extAccCodeStr", recptNatureStr.toString());
				   inputParameters.put("extAccDeptSTr", rcptTypeCodeStr.toString());
					
				   //deposit_parameter_array
				    inputParameters.put("depDocTypeStr", (String)session.getAttribute("depDocTypeStr"));
				     inputParameters.put("depdocNumStr", (String)session.getAttribute("depdocNumStr"));
				     inputParameters.put("depSrlnoStr", (String)session.getAttribute("depSrlnoStr"));
				     inputParameters.put("depSlmtTypStr", (String)session.getAttribute("depSlmtTypStr"));
				     inputParameters.put("depDepositStr", (String)session.getAttribute("depDepositStr"));
				     inputParameters.put("depAdjAmtStr", (String)session.getAttribute("depAdjAmtStr"));
				     inputParameters.put("depremarkStr", (String)session.getAttribute("depremarkStr"));
				    System.out.println("DEPOSIT_DTLS");
				    
				    //slmt_mode_parameter_array
					   inputParameters.put("slmtTypeStr", slmtTypeStr.toString());
					   inputParameters.put("billslmtamtStr", billslmtamtStr.toString());
					   inputParameters.put("slmtSrnoStr", slmtSrnoStr.toString());
					   inputParameters.put("SlmtDocRefStr", SlmtDocRefStr.toString());
					   inputParameters.put("instdateStr", instdateStr.toString());
					   inputParameters.put("instremarkcodeStr", instremarkcodeStr.toString());
					   inputParameters.put("rcpt_rfnd_idStr", rcpt_rfnd_idStr.toString());
					   inputParameters.put("payernameStr", payernameStr.toString());
					   inputParameters.put("apprrefnoStr", apprrefnoStr.toString());
					   inputParameters.put("onlineapprovalChckStr", onlineapprovalChckStr.toString());
					   inputParameters.put("batchnoStr", batchnoStr.toString());
					   inputParameters.put("saledraftnoStr", saledraftnoStr.toString());
					   inputParameters.put("cc_term_id_numStr", cc_term_id_numStr.toString());
					   
				  //  HashMap<String,ARRAY> arrayInputParameters=new HashMap<String,ARRAY>();
					   //slmt_by_svc_parameter_array
				   	   inputParameters.put("slmtDocTypeStr", slmtDocTypeStr.toString());
					   inputParameters.put("slmtBillNumStr", slmtBillNumStr.toString());
					   inputParameters.put("slmtServdateStr", slmtServdateStr.toString());
					   inputParameters.put("slmtTrxDocRefStr", slmtTrxDocRefStr.toString());
					   inputParameters.put("smtTrxLineNoStr", smtTrxLineNoStr.toString());
					   inputParameters.put("smtTrxSeqnoStr", smtTrxSeqnoStr.toString());
					   inputParameters.put("slmtBlngServStr", slmtBlngServStr.toString());
					   inputParameters.put("slmtChrgAmtStr", slmtChrgAmtStr.toString());
					   inputParameters.put("slmtSetAmtStr", slmtSetAmtStr.toString());
					   inputParameters.put("SmtUpdNetChrgStr", SmtUpdNetChrgStr.toString());
					   inputParameters.put("slmtInclExclStr", slmtInclExclStr.toString());
					 
					 
				  // inputParameters.put("deposit_parameter_array", deposit_parameter_array.toString());
				   //arrayInputParameters.put("bill_doc_numbers_parameter_array", bill_doc_numbers_parameter_array);
				 //  arrayInputParameters.put("slmt_mode_parameter_array", slmt_mode_parameter_array);
				  // arrayInputParameters.put("slmt_by_svc_parameter_array", slmt_by_svc_parameter_array);
				  // arrayInputParameters.put("deposit_parameter_array", deposit_parameter_array);
					
					
					Object argArray[] = new Object[2]; //Changed from 3 to 2
					//   Object argArray[] = new Object[3]; //Changed from 5 to 3
					argArray[0] = p;
					argArray[1] = inputParameters;
					//argArray[2] = arrayInputParameters;

					Class[] paramArray = new Class[2]; //Changed from 3 to 2
					//Class[] paramArray = new Class[3]; //Changed from 5 to 3
					paramArray[0] = p.getClass();
					paramArray[1] = inputParameters.getClass();	
					//paramArray[2] = arrayInputParameters.getClass();
					
					
					HashMap<String,String> results = new HashMap<String,String>();
					//results=(HashMap<String,String>) (busObj.getClass().getMethod("insertRecords",paramArray)).invoke(busObj, argArray);
					results = (HashMap<String,String>) insertRecords(p,inputParameters);
					boolean executionSuccess= results.get("status").equals("success") ? true:false;					
					System.out.println("Manivel BLBillSlmtAllServicesSubmitServlet EXECUTED SUCCESSFULLY:"+executionSuccess);
					
					System.out.println("Manivel BLBillSlmtAllServicesSubmitServlet EXECUTED SUCCESSFULLY:"+error_level);
					System.out.println("Manivel BLBillSlmtAllServicesSubmitServlet EXECUTED SUCCESSFULLY:"+error_id);
					System.out.println("Manivel BLBillSlmtAllServicesSubmitServlet EXECUTED SUCCESSFULLY:"+error_text);
					System.out.println("Manivel BLBillSlmtAllServicesSubmitServlet EXECUTED SUCCESSFULLY:"+warningId);
					if (executionSuccess==false) {
						
						error_level = results.get("error_level");
						error_id = results.get("error_id");
						error_text = results.get("error_text");
						warningId = results.get("warningId");
						
						JSONObject obj=new JSONObject();
						String strErrorId = nullFormatter(error_id);
						obj.put("flag","F");  
						obj.put("error_level",nullFormatter(error_level));    
						obj.put("error_id",nullFormatter(error_id));  
						obj.put("error_text",nullFormatter(error_text));  
						obj.put("warningId",nullFormatter(warningId)); 
						
						String chequeDays = "";
						if("BL9624".equals(strErrorId) || "BL9625".equals(strErrorId)){
							chequeDays = getPostBackDays(con, strErrorId, facility_id);
						}
						obj.put("chequeDays",chequeDays); 
						
						out.print(obj);
						out.flush();
						
					}else{				
						 String slmt_doc_type_code_op=results.get("slmt_doc_type_code_op");
						 String slmt_doc_num_op=results.get("slmt_doc_num_op");
						 String multiple_slmt_doc_numbers=results.get("multiple_slmt_doc_numbers");
						 String printYN = results.get("printYN");
						 String sessionId = results.get("sessionId");
						 String pgmDate = results.get("pgmDate");
						 String reportId = results.get("reportId");
						 warningId = results.get("warningId");

						String receiptGeneratedString;
						if(slmtModeWiseWcptYN.equals("Y")){
							receiptGeneratedString= multiple_slmt_doc_numbers ;
						}else{
							receiptGeneratedString=slmt_doc_type_code_op +"/" + slmt_doc_num_op;
						}
						System.out.println("Manivel - receiptGeneratedString:"+receiptGeneratedString);
						JSONObject obj=new JSONObject();
						obj.put("flag","S");  
						obj.put("info",receiptGeneratedString);   
						obj.put("printYN", printYN);
						obj.put("sessionId", sessionId);
						obj.put("pgmDate", pgmDate);
						obj.put("reportId", reportId);
						obj.put("warningId",nullFormatter(warningId)); 
						
						out.print(obj);
						out.flush();
		   			}

		System.out.println("BLBillSlmtAllServicesSubmitServlet EXECUTED SUCCESSFULLY");
		     
		} catch(Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		    System.out.println(e);
			JSONObject obj=new JSONObject();
			obj.put("flag","F"); 
			obj.put("error_level","");    
			obj.put("error_id","");  
			obj.put("error_text","Exception has Occured in Bill Settlement Procedure");  
			out.print(obj);
			out.flush();
		}
		finally{
				ConnectionManager.returnConnection(con);
		}

		
		
	}
	
	public String getPostBackDays(Connection con, String messageId, String facilityId){
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String days = "";
		try{
			if("BL9624".equals(messageId)){
				pstmt = con.prepareStatement("Select POST_DTD_CHQ_ALLOW_DAYS from bl_parameters where operating_facility_id = ?");
				pstmt.setString(1, facilityId);
				rst = pstmt.executeQuery();
				if(rst != null && rst.next()){
					days = rst.getString("POST_DTD_CHQ_ALLOW_DAYS");
				}
			}
			else if("BL9625".equals(messageId)){
				pstmt = con.prepareStatement("Select BACKDATED_CHQ_ALLOW_DAYS from bl_parameters where operating_facility_id = ?");
				pstmt.setString(1, facilityId);
				rst = pstmt.executeQuery();
				if(rst != null && rst.next()){
					days = rst.getString("BACKDATED_CHQ_ALLOW_DAYS");
				}
			}
		}
		catch(Exception e){
			days = "";
			System.err.println(e);
		}
		finally{
			try{
				if(pstmt != null) {
					pstmt.close();
				}
				if(rst != null) {
					rst.close();
				}  //Added for V210416
				//pstmt = null;
				//rst = null; //commented V210416
			}catch(Exception e){	
				e.printStackTrace();
			}
		}
		
		return days;
	}
	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		Object obj = PersistenceHelper.getBeanObject(id,ClassName,request);		
		return obj;
	}
	
	public HashMap<String,String> insertRecords(java.util.Properties p,HashMap<String,String> inputParameters) {
		
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		Connection con = ConnectionManager.getConnection(p);	
		
		try{
		String facility_id = inputParameters.get("facility_id");
		String language_id = inputParameters.get("language_id");
		String cust_code = inputParameters.get("cust_code");
		String episode_type = inputParameters.get("episode_type");
		String slmt_amt =inputParameters.get("slmt_amt");
		String outst_amt=inputParameters.get("outst_amt");
		String user_id =inputParameters.get("user_id");
		String ws_no = inputParameters.get("ws_no");
		String cash_amt_given =inputParameters.get("cash_amt_given");
		String cash_amt_returned = inputParameters.get("cash_amt_returned");
		String ecnounterFacilityId = inputParameters.get("ecnounterFacilityId"); //V210129 
		String downType = inputParameters.get("downType");
	    String downDoc = inputParameters.get("downDoc");
	    String downDate = inputParameters.get("downDate");
	    String downReason = inputParameters.get("downReason");
	    String downEntryYn = inputParameters.get("downEntryYn");
	    String blRecRefInd = inputParameters.get("blRecRefInd");
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    if("Y".equals(downEntryYn)){
	    	Timestamp ts = new Timestamp(sdf.parse(downDate).getTime());
	    	System.err.println(ts);
	    }
		
		System.out.println("array assignment begins" );
		//bill_doc_numbers_parameter_array
		String patientidStr=inputParameters.get("patientIdStr");
		String episodeTypeStr=inputParameters.get("episodeTypeStr");
		String episodeIdStr=inputParameters.get("episodeIdStr");
		String visitIdStr=inputParameters.get("visitIdStr");
		String DocTypeCodeStr=inputParameters.get("DocTypeCodeStr");
		String docNumStr=inputParameters.get("docNumStr");
		String billTotAmtStr=inputParameters.get("billTotAmtStr");
		String docDateStr=inputParameters.get("docDateStr");
		String totOutAmtStr=inputParameters.get("totOutAmtStr");
		String remSlmtAmtStr=inputParameters.get("remSlmtAmtStr");
		String billPrintYNStr=inputParameters.get("billPrintYNStr");
		String recptNatureStr=inputParameters.get("recptNatureStr");
		String rcptTypeCodeStr=inputParameters.get("rcptTypeCodeStr");
		String extAccCodeStr=inputParameters.get("extAccCodeStr");
		String extAccDeptSTr=inputParameters.get("extAccDeptSTr");
		 //deposit_parameter_array
		String depDocTypeStr=inputParameters.get("depDocTypeStr");
		String depdocNumStr=inputParameters.get("depdocNumStr");
		String depSrlnoStr=inputParameters.get("depSrlnoStr");
		String depSlmtTypStr=inputParameters.get("depSlmtTypStr");
		String depDepositStr=inputParameters.get("depDepositStr");
		String depAdjAmtStr=inputParameters.get("depAdjAmtStr");
		String depremarkStr=inputParameters.get("depremarkStr");
		
		//slmt_mode_parameter_array
	    String slmtTypeStr=inputParameters.get("slmtTypeStr");
		String billslmtamtStr=inputParameters.get("billslmtamtStr");
		String slmtSrnoStr=inputParameters.get("slmtSrnoStr");
		String SlmtDocRefStr=inputParameters.get("SlmtDocRefStr");
		String instdateStr=inputParameters.get("instdateStr");
		String instremarkcodeStr=inputParameters.get("instremarkcodeStr");
		String rcpt_rfnd_idStr=inputParameters.get("rcpt_rfnd_idStr");
		
		String payernameStr=inputParameters.get("payernameStr");
		String apprrefnoStr=inputParameters.get("apprrefnoStr");
		String onlineapprovalChckStr=inputParameters.get("onlineapprovalChckStr");
		String batchnoStr=inputParameters.get("batchnoStr");
		String saledraftnoStr=inputParameters.get("saledraftnoStr");
		String cc_term_id_numStr=inputParameters.get("cc_term_id_numStr");
		 
		  /*slmtDocTypeStr slmtBillNumStr slmtServdateStr slmtTrxDocRefStr
		   	 smtTrxLineNoStr smtTrxSeqnoStr slmtBlngServStr slmtChrgAmtStr
		   	 slmtSetAmtStr SmtUpdNetChrgStr slmtInclExclStr*/
		  //slmt_by_svc_parameter_array 
		String slmtDocTypeStr=inputParameters.get("slmtDocTypeStr");
		String slmtBillNumStr=inputParameters.get("slmtBillNumStr");
		String slmtServdateStr=inputParameters.get("slmtServdateStr");
		String slmtTrxDocRefStr=inputParameters.get("slmtTrxDocRefStr");
		String smtTrxLineNoStr=inputParameters.get("smtTrxLineNoStr");
		String smtTrxSeqnoStr=inputParameters.get("smtTrxSeqnoStr");
		String slmtBlngServStr=inputParameters.get("slmtBlngServStr");
		
		String slmtChrgAmtStr=inputParameters.get("slmtChrgAmtStr");
		String slmtSetAmtStr=inputParameters.get("slmtSetAmtStr");
		String SmtUpdNetChrgStr=inputParameters.get("SmtUpdNetChrgStr");
		String slmtInclExclStr=inputParameters.get("slmtInclExclStr");
			
		//ARRAY bill_doc_numbers_parameter_array=arrayInputParameters.get("bill_doc_numbers_parameter_array");
		//ARRAY slmt_mode_parameter_array=arrayInputParameters.get("slmt_mode_parameter_array");
		//ARRAY slmt_by_svc_parameter_array=arrayInputParameters.get("slmt_by_svc_parameter_array");
		//ARRAY deposit_parameter_array=arrayInputParameters.get("deposit_parameter_array");
		/*slmtTypeStr billslmtamtStr slmtSrnoStr SlmtDocRefStr instdateStr
	    instremarkcodeStr rcpt_rfnd_idStr payernameStr apprrefnoStr  
	    onlineapprovalChckStr batchnoStr saledraftnoStr cc_term_id_numStr
	   */ 
		con.setAutoCommit(false);
		System.out.println("call proc bl_bill_settlement_proc.populate_slmt_cons_rcpt() begins" );
		//CallableStatement cst = con.prepareCall("call bl_bill_settlement_proc.populate_slmt_cons_rcpt(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //V210129
		CallableStatement cst = con.prepareCall("call bl_bill_settlement_proc.populate_slmt_cons_rcpt(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //V210129 ?,?,?,?
		/*bill_doc_numbers_parameter_array-15  
		deposit_parameter_array-7
		slmt_mode_parameter_array-13
		slmt_by_svc_parameter_array-11*/
		//cst.setString(1, facility_id); // facility_id //V210129 Commented
		cst.setString(1, ecnounterFacilityId); // facility_id //V210129 Added
		cst.setString(2, language_id); // language_id
		cst.setString(3, cust_code); // cust_code
		cst.setString(4, episode_type); // episode_type
		cst.setDouble(5, Double.parseDouble(slmt_amt)); // slmt_amt
		cst.setDouble(6, Double.parseDouble(outst_amt)); //p_bill_oustanding_amt
		// b_cnt // bill_dtls
		cst.setString(7,patientidStr);
		cst.setString(8,episodeTypeStr);
		cst.setString(9,episodeIdStr);
		cst.setString(10,visitIdStr);
		cst.setString(11,DocTypeCodeStr);
		cst.setString(12,docNumStr);
		cst.setString(13,billTotAmtStr);
		System.out.println("210" );
		cst.setString(14,docDateStr);
		cst.setString(15,totOutAmtStr);
		cst.setString(16,remSlmtAmtStr);
		cst.setString(17,billPrintYNStr);
		System.out.println("215" );
		cst.setString(18,recptNatureStr);
		cst.setString(19,rcptTypeCodeStr);
		cst.setString(20,extAccCodeStr);
		cst.setString(21,extAccDeptSTr);
		System.out.println("220" );
		// slmt_cnt slmt_dtls
		cst.setString(22,slmtTypeStr);
		cst.setString(23,billslmtamtStr);
		cst.setString(24,slmtSrnoStr);
		cst.setString(25,SlmtDocRefStr);
		cst.setString(26,instdateStr);
		cst.setString(27,instremarkcodeStr);
		System.out.println("228" );
		cst.setString(28,rcpt_rfnd_idStr);
		cst.setString(29,payernameStr);
		cst.setString(30,apprrefnoStr);
		cst.setString(31,onlineapprovalChckStr);
		cst.setString(32,batchnoStr);
		cst.setString(33,saledraftnoStr);
		cst.setString(34,cc_term_id_numStr);
		System.out.println("236" );
		// sett_serv	// sett_dtls
		cst.setString(35,slmtDocTypeStr);
		cst.setString(36,slmtBillNumStr);
		cst.setString(37,slmtServdateStr);
		cst.setString(38,slmtTrxDocRefStr);
		cst.setString(39,smtTrxLineNoStr);
		cst.setString(40,smtTrxSeqnoStr);
		cst.setString(41,slmtBlngServStr);
		System.out.println("245" );
		cst.setString(42,slmtChrgAmtStr);
		cst.setString(43,slmtSetAmtStr);
		cst.setString(44,SmtUpdNetChrgStr);
		cst.setString(45,slmtInclExclStr);
		System.out.println("250" );
		 // dedtl dep_dtls
		cst.setString(46,depDocTypeStr);
		cst.setString(47,depdocNumStr);
		cst.setString(48,depSrlnoStr);
		cst.setString(49,depSlmtTypStr);
		cst.setString(50,depDepositStr);
		cst.setString(51,depAdjAmtStr);
		cst.setString(52,depremarkStr);
		System.out.println("259" );
	/*cst.setArray(7, bill_doc_numbers_parameter_array); // b_cnt // bill_dtls
		cst.setArray(8, slmt_mode_parameter_array); // slmt_cnt slmt_dtls
		cst.setArray(9, slmt_by_svc_parameter_array); // sett_serv	// sett_dtls
		cst.setArray(10, deposit_parameter_array); // dedtl dep_dtls
		*/
		cst.setString(53, user_id); // user_id
		cst.setString(54, ws_no); // ws_no
		System.out.println("267" );
		cst.setDouble(55, Double.parseDouble(cash_amt_given)); // cash_amt_given
		cst.setDouble(56, Double.parseDouble(cash_amt_returned)); // cash_amt_returned
		/*below params for downtime entry*/
		cst.setString(57, downEntryYn);
		cst.setString(58, downDoc); //num
		//cst.setInt(58, Integer.parseInt(downDoc));
		System.out.println("268" );
		cst.setString(59, downType);
		System.out.println("275" );
		if("Y".equals(downEntryYn)){
			cst.setTimestamp(60, new Timestamp(sdf.parse(downDate).getTime()));
		}
		else{
			cst.setString(60, null);
		}
		
		cst.setString(61, downReason);
		cst.setString(62, blRecRefInd);
		/*below params for downtime entry*/
		cst.registerOutParameter(63, Types.VARCHAR); // slmt_doc_type_code
		cst.registerOutParameter(64, Types.INTEGER); // slmt_doc_num
		cst.registerOutParameter(65, Types.VARCHAR); //multiple_slmt_doc_numbers
		cst.registerOutParameter(66, Types.VARCHAR); // print yn
		cst.registerOutParameter(67, Types.VARCHAR); // session id
		cst.registerOutParameter(68, Types.VARCHAR); // report id
		cst.registerOutParameter(69, Types.VARCHAR); // pgm date
		cst.registerOutParameter(70, Types.INTEGER); // error_level
		cst.registerOutParameter(71, Types.VARCHAR); // error_id
		cst.registerOutParameter(72, Types.VARCHAR); // error_text
		cst.registerOutParameter(73, Types.VARCHAR); // warning_id
		cst.setString(74,facility_id); //facility_id //V210129 
		System.out.println("before execution" );
		cst.execute();		
		System.out.println("after execution" );
		String error_level = cst.getString(70);
		String error_id = cst.getString(71);
		String error_text = cst.getString(72);
		String warningId = cst.getString(73);
		if(warningId == null){
			warningId = "";
		}
		
		String slmt_doc_type_code_op=cst.getString(63);
		String slmt_doc_num_op=cst.getString(64);
		String multiple_slmt_doc_numbers=cst.getString(65);
		String printYN = cst.getString(66);
		String sessionId = cst.getString(67);
		String reportId = cst.getString(68);
		String pgmDate = cst.getString(69);
		
		
		System.out.println("PROCEDURE bl_bill_settlement_proc.populate_slmt_cons_rcpt EXECUTED SUCCESSFULLY");
		System.out.println("error_level:" + error_level + "|error_id:" + error_id + "|error_text: "+error_text);
		System.out.println("printYN-"+printYN+"-sessionId"+sessionId+"-reportId"+reportId+"-pgmDate"+pgmDate);
		
		if (error_level != null || error_id != null || error_text != null) {
			con.rollback();
			returnMessage.put("status", "fail");
			returnMessage.put("error_level",error_level);
			returnMessage.put("error_id",error_id);
			returnMessage.put("error_text",error_text);
			returnMessage.put("warningId", warningId);
		}else{			
			con.commit();
			returnMessage.put("slmt_doc_type_code_op",slmt_doc_type_code_op);
			returnMessage.put("slmt_doc_num_op",slmt_doc_num_op);
			returnMessage.put("multiple_slmt_doc_numbers",multiple_slmt_doc_numbers);
			returnMessage.put("printYN", printYN);
			returnMessage.put("sessionId", sessionId);
			returnMessage.put("pgmDate", pgmDate);
			returnMessage.put("reportId", reportId);
			returnMessage.put("status", "success");
			returnMessage.put("warningId", warningId);
		}		

		}catch(Exception e){
			try{
				con.rollback();
			}
			catch(Exception rb){
				
			}
			
			System.out.println("Exception in procedure bl_bill_settlement_proc.populate_slmt_cons_rcpt " + e.getMessage()); 
			returnMessage.put("status", "fail");
			returnMessage.put("error_level","");
			returnMessage.put("error_id","");
			returnMessage.put("error_text","Fatal Exception Occured");
		}finally{
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Error in EJB insertRecords()"+ e);
				}
		}
		}

		
		

		return returnMessage;
	}

}
