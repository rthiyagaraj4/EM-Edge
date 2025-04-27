<%@page import="eBL.billreceipt.request.BillGenerationRequest"%>
<%@page import="eBL.placeorder.request.PlaceNewOrderRequest"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@page import="eBL.billreceipt.model.BillReceiptPackageInfo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="eBL.billreceipt.model.BillReceiptExclusionDiscount"%>
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%!
private String decodeParam(String input){
	String output = "";
	try{
		if(input!=null){
			input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			input = input.replaceAll("\\+", "%2B");
			output = URLDecoder.decode(input,"UTF-8");
		}
	}
	catch(Exception e){
		System.err.println("Exception while Decoding BillHdrAjax->"+e);
	}
	return output;
}
%>
<%!

public String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";	
	}
	return input;
}	
%>

<%
System.out.println("calledddddd");
	String calledFrom = "";
 	Connection con = null;
 	PreparedStatement pstmt = null;		
	CallableStatement cstmt = null;
 	ResultSet rs = null;
 	String retVal="";
	String facilityId = (String) session.getValue("facility_id");
	String loginUser = (String) session.getValue("login_user");
	Properties p = null ;
	String client_ip_address = "";
	try 
	{
		con = ConnectionManager.getConnection();
		calledFrom = request.getParameter("calledFrom");
		String locale = (String)session.getAttribute("LOCALE");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("calledFrom="+calledFrom+"-locale="+locale);
		if("episodeOption".equals(calledFrom)){
		String episodeType = request.getParameter("episodeType");
			System.out.println("episodeType="+episodeType);
			String sqlOption =" SELECT   a.list_srl_no, NVL (b.list_elmt_label, a.list_elmt_label) listdesc, a.list_elmt_value listvalue FROM sm_list_item a, sm_list_item_desc b "+
					   "WHERE a.module_id = 'BL' AND a.module_id = b.module_id(+) "+
					     " AND a.list_ref = b.list_ref(+) "+
					     "AND a.list_srl_no = b.list_srl_no(+) "+
					     "AND (   (   '"+episodeType+"' IN ('I', 'D') "+
					              " AND a.list_ref = 'BILVT_ND_OPTION_IP' "+
					              " AND (a.list_srl_no IS NULL OR a.list_srl_no IN ('1', '2', '3') "+
					                  ")) "+
					          " OR (   '"+episodeType+"'IN ('O', 'E') "+
					              " AND a.list_ref = 'BILVT_ND_OPTION' "+
					              " AND (   a.list_srl_no IS NULL "+
					                   " OR a.list_srl_no IN ('1', '2', '3', '4', '5') "+
					                  " )) "+
					          " OR (    '"+episodeType +"' IN ('R') "+
					              " AND a.list_ref = 'BILVT_ND_OPTION_RF' "+
					              " AND (   a.list_srl_no IS NULL "+
					                   " OR a.list_srl_no IN ('1', '2', '3') "+
					                  "))) "+
						     " AND UPPER (b.language_id(+)) = UPPER ('"+locale+"') "+
						" UNION ALL "+
						" SELECT   1 list_srl_no, 'All' listdesc, 'A' listvalue "+
						    " FROM DUAL "+
						   " WHERE '"+ episodeType+"' = 'A' ";//+
					//	" ORDER BY 1 desc";
			System.err.println(sqlOption);
			 pstmt=con.prepareStatement(sqlOption);			 
			 rs=pstmt.executeQuery();

			 while(rs.next()){
				 if (!retVal.equals("")) {
					 retVal = retVal+ rs.getString(3)+"::"+rs.getString(2)+":::" ;	 
				 }else {
					 retVal =  rs.getString(3)+"::"+rs.getString(2)+":::" ;
				 }
				 
				 
			}
			out.println(retVal);
		}else if("practStaffType".equals(calledFrom)){
			String type = request.getParameter("type");
			String code = request.getParameter("code");
			String sqlOption = "Select ST_TYPE_DESC  FROM BL_AM_PRACT_STAFF_VW  WHERE  FACILITY_ID = 'QF' AND UPPER(LANGUAGE_ID) = UPPER('en')  AND PRACT_STAFF_IND = '"+type+"'  AND PRACTITIONER_ID = '"+code+"'";
			System.err.println(sqlOption);
			 pstmt=con.prepareStatement(sqlOption);			 
			 rs=pstmt.executeQuery();

			 while(rs.next()){				 
				 retVal= rs.getString(1);
			}
			 System.out.println("retVal="+retVal);
			out.println(retVal);
		}
		else if("slmtAmtValidate".equals(calledFrom)){
			System.out.println("in slmtAmtValidate");
			facilityId= replaceNull(request.getParameter("facility_id"));
			
			String patientId = replaceNull(request.getParameter("patient_id"));
			String episodeType = replaceNull(request.getParameter("episode_type"));
			String episodeId = replaceNull(request.getParameter("episode_id"));
			String visitId = replaceNull(request.getParameter("visit_id"));
			String custAmt = replaceNull(request.getParameter("cust_amt"));
			String exemptAmt = replaceNull(request.getParameter("exempt_amt"));
			String slmtAmt = replaceNull(request.getParameter("slmt_amt"));
			String docAmt = replaceNull(request.getParameter("doc_amt"));
			String depAmt = replaceNull(request.getParameter("dep_amt"));
			String cashCounterCode = replaceNull(request.getParameter("cash_counter_code"));
			String userId = replaceNull(request.getParameter("user"));

			BillReceiptBC billBC = new BillReceiptBC();
			BillGenerationRequest billRequest = new BillGenerationRequest();
			billRequest.setFacilityId(facilityId);
			billRequest.setPatientId(patientId);
			billRequest.setEpisodeType(episodeType);
			billRequest.setEpisodeId(episodeId);
			billRequest.setVisitId(visitId);
			billRequest.setPayerAmt(custAmt);
			billRequest.setExemptAmt(exemptAmt);
			billRequest.setDocAmt(docAmt);
			billRequest.setSlmtAmt(slmtAmt);
			billRequest.setDeposits(depAmt);
			billRequest.setCashCntrCode(cashCounterCode);
			billRequest.setLoginUser(userId);
			
			JsonObject obj = billBC.validateSettlementAmt(billRequest);
			out.println(obj);
			
		}else if ("exemptReqValidate".equals(calledFrom)) {
			System.out.println("in exemptReqValidate");
			String facility_id= (String)request.getParameter("facility_id");
			System.out.println("facility_id="+facility_id);
			String doc_amt =((String)request.getParameter("doc_amt"));
			System.out.println("doc_amt="+doc_amt);
			String slmt_amt = ((String)request.getParameter("slmt_amt"));
			System.out.println("slmt_amt="+slmt_amt);			
			String exempt_amt = ((String)request.getParameter("exempt_amt"));
			System.out.println("exempt_amt="+exempt_amt);		
			String user = (String)request.getParameter("user");
			System.out.println("user="+user);
			 locale = (String)session.getAttribute("LOCALE");
			String exemptType= (String)request.getParameter("exemptType");
			String patientId = replaceNull(request.getParameter("patient_id"));
			String episodeType = replaceNull(request.getParameter("episode_type"));
			String episodeId = replaceNull(request.getParameter("episode_id"));
			String visitId = replaceNull(request.getParameter("visit_id"));
			String custAmt = replaceNull(request.getParameter("cust_amt"));
			String depAmt = replaceNull(request.getParameter("dep_amt"));
			String cashCounterCode = replaceNull(request.getParameter("cash_counter_code"));
			
			
			BillReceiptBC billBC = new BillReceiptBC();
			BillGenerationRequest billRequest = new BillGenerationRequest();
			billRequest.setFacilityId(facility_id);
			billRequest.setDocAmt(doc_amt);
			billRequest.setSlmtAmt(slmt_amt);
			billRequest.setLoginUser(user);
			billRequest.setExemptAmt(exempt_amt);
			billRequest.setExemptType(exemptType);
			billRequest.setLocale(locale);
			billRequest.setPatientId(patientId);
			billRequest.setEpisodeType(episodeType);
			billRequest.setEpisodeId(episodeId);
			billRequest.setVisitId(visitId);
			billRequest.setPayerAmt(custAmt);
			
			billRequest.setDeposits(depAmt);
			billRequest.setCashCntrCode(cashCounterCode);
			JsonObject obj = billBC.validateExemptionAmt(billRequest);
			 
			
			 String errorYn= obj.get("errorYn").getAsString();//obj.toString();
			
			if(errorYn=="N"){
				String docAmt= obj.get("docAmt").getAsString();
				 billRequest.setDocAmt(docAmt);
				 billRequest.setSlmtAmt(docAmt);
				JsonObject object= billBC.validateSettlementAmt(billRequest);
				
				out.println(object);
				
			}
			 
		
			else{
		out.println(obj);
				
			}
		}else if ("chkExcludeServValidate".equals(calledFrom)) {	
			System.out.println("here");
			facilityId = replaceNull(request.getParameter("facility_id"));			  
	      	String patientId = replaceNull(request.getParameter("patient_id"));
		    String episodeType = replaceNull(request.getParameter("episode_type"));
		    String episodeId = replaceNull(request.getParameter("episode_id"));
		    String visitId  = replaceNull(request.getParameter("visit_id"));
		    String trxDocRef = replaceNull(request.getParameter("trxDocRef"));
		    String trxDocRefLineNum = replaceNull(request.getParameter("trxDocRefLineNum"));
		    String excludedInBillYn  = replaceNull(request.getParameter("serv_grp_chk"));
		    String billBlngServSeparatly = replaceNull(request.getParameter("bil_blng_serv_separatly"));
		    String pkgClosedYn = replaceNull(request.getParameter("pkgClosedYn"));
		      
		    BillReceiptBC billBC = new BillReceiptBC();
			BillReceiptRequest billRequest = new BillReceiptRequest();
			billRequest.setFacilityId(facilityId);
			billRequest.setPatientId(patientId);
			billRequest.setEpisodeId(episodeId);
			billRequest.setEpisodeType(episodeType);
			billRequest.setVisitId(visitId);
			billRequest.setTrxDocRef(trxDocRef);
			billRequest.setTrxDocRefLine(trxDocRefLineNum);
			billRequest.setExcludeInBill(excludedInBillYn);
			billRequest.setBlngServSeparate(billBlngServSeparatly);
	      
		  	JsonObject obj = billBC.chkExcludeServValidate(billRequest);
		  	System.err.println(obj);
		  	if(!"Y".equals(pkgClosedYn) && "N".equals(obj.get("allowYn").getAsString()) && "BL2001".equals(obj.get("errorId").getAsString())){
		  		obj.remove("allowYn");
		  		obj.addProperty("allowYn", "Y");
		  	}
		  	System.err.println(obj);
		  	out.println(obj);
		}
		if("assignTo".equals(calledFrom)){
				String code = request.getParameter("code");
				String exempt_amt = request.getParameter("exempt_amt");
				System.err.println(exempt_amt+""+code);				
				String assign_to= "SELECT Distinct User_Id, UserNAME  FROM sy_user_lang_vw A Where facility_id ='"+facilityId+"' AND upper(language_id)=upper('"+locale+"') And User_Id In  ( Select APPL_USER_ID From BL_USERS_FOR_EXEMPTION F "+
	        			"Where F.ACTION_REASON_CODE = '"+code+"' And ( EXISTS ( Select DISTINCT E.APPL_USER_ID From BL_USERS_EXEMPTION_PRIV E   Where E.APPL_USER_ID = A.USER_ID "+
					   "And E.ACTION_REASON_CODE='"+code+"'  And ( Stage_Limit_Amt Is Null Or (Stage_limit_Amt Is Not Null And Stage_limit_Amt>'"+exempt_amt+"')  ))  OR F.ACTION_REASON_CODE ='"+code+"') ) "; 
			
				 pstmt=con.prepareStatement(assign_to);			 
				 rs=pstmt.executeQuery();
				 while(rs.next()){
					 if (!retVal.equals("")) {
						 retVal = retVal+ rs.getString(1)+"::"+rs.getString(2)+":::" ;	 
					 }else {
						 retVal =  rs.getString(1)+"::"+rs.getString(2)+":::" ;
					 }
					 
					 
				}
				out.println(retVal);
			
			
			}
		
	}catch (Exception e) {
	
		System.out.println("Exception from BillHdrAjax :" + e);
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con);
	}


%>

