<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
03/06/2020 	  		Ramesh Goli											AAKH-CRF-0122.2
01/07/2020 	  		Chandrashekar											AAKH-CRF-0122.2
31/10/2022          Kamatchi S                                              TH-KW-CRF-0143
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<title>
Coder Function
</title>
<script language='javascript' src='../js/CoderFunciton.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script> 
<script src="../../eMR/js/MRCoderDiagDtls.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String params = request.getQueryString() ;
	String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	String p_error_text         = "";
	String proceed_yn           = "";
	String transction_status    = "";
	String dischared_date       = "";
	String facility_id          = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String encounter_id         = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	HashMap blling_params       = new HashMap();
	String locale				= (String)session.getAttribute("LOCALE");
	String session_id           = "";
	//Added by Kamatchi S for TH-KW-CRF-0143
	Connection con	= null;
	con = ConnectionManager.getConnection(request);
	Boolean siteSpecServiceCode = false;
	siteSpecServiceCode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_SERVICE_CODE_REQD");
//V230330
	Boolean siteSpecPatPayable = false;
	siteSpecPatPayable =  eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ALLOW_CASH_PAT_IN_CODER_FN");//V230222
	
     CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
	 dischared_date = bean.getPatientDischargedDate(encounter_id);
	 //Added by Kamatchi S for TH-KW-CRF-0143
	 System.err.println("siteSpecPatPayable From CA  "+siteSpecPatPayable);
	if(siteSpecServiceCode ){//V230405
		blling_params =bean.getBillingValidation(encounter_id,locale);
         if(blling_params !=null){
			 p_error_text       =   (String)blling_params.get("p_error_text")==null?"":(String)blling_params.get("p_error_text");
			 transction_status  =   (String)blling_params.get("transction_status");
			 session_id         =   (String)blling_params.get("session_id")==null?"":(String)blling_params.get("session_id");
			 System.err.println("blling_params p_error_text From CA  "+p_error_text);
			 System.err.println("blling_params transction_status From CA  "+transction_status);
			 System.err.println("blling_params session_id From CA  "+session_id);
			 if(transction_status.equals("S"))
				        proceed_yn ="Y";
			 else if (p_error_text != null && transction_status.equals("E"))
                        proceed_yn ="N";
		 }

	}
	else{
	 if(!dischared_date.equals("")){
          blling_params =bean.getBillingValidation(encounter_id,locale);
         if(blling_params !=null){
			 p_error_text       =   (String)blling_params.get("p_error_text")==null?"":(String)blling_params.get("p_error_text");
			 transction_status  =   (String)blling_params.get("transction_status");
			 session_id         =   (String)blling_params.get("session_id")==null?"":(String)blling_params.get("session_id");
			 System.err.println("p_error_text From CA  "+p_error_text);
			 System.err.println("transction_status From CA  "+transction_status);
			 System.err.println("session_id From CA  "+session_id);
			 if(transction_status.equals("S"))
				        proceed_yn ="Y";
			 else if (p_error_text != null && transction_status.equals("E"))
                        proceed_yn ="N";

		 }
	 }else{
		     proceed_yn ="N";
	 }
	}
	 System.err.println("proceed_yn From CA  "+proceed_yn);
	  System.err.println("p_error_text From CA  "+p_error_text);
		
     if(proceed_yn.equals("N") && !p_error_text.equals("")){
		  System.err.println("95,p_error_text From CA  "+p_error_text);
		 out.println("<script>alert('"+p_error_text+"')</script>");
         }else if(proceed_yn.equals("N")){
			 if(siteSpecPatPayable){
				 out.println("<script>alert('This function is applicable for patients who are Discharged/Checked Out')</script>");//V230330
			 }else{
				out.println("<script>alert('This function is applicable for insurance patients who are Discharged/Checked Out')</script>");
			 }
	   }
	  
   if(proceed_yn.equals("Y")){
%>
<!--frame size changed for AAKH-CRF-0153-->
<!--<frameset rows="78*,130*,127*,77*,0,0" cols="*" >-->
<frameset rows="70*,138*,127*,77*,0,0" cols="*" >
	<frame src="../../eMR/jsp/MRCoderPatDemographicDtls.jsp?<%=params%>&session_id=<%=session_id%>" frameborder="0">
	<frame src="../../eMR/jsp/MRCoderDiagDtls.jsp?<%=params%>&session_id=<%=session_id%>" frameborder="0">
	<frame src="../../eBL/jsp/BLCoderFunction.jsp?<%=params%>&session_id=<%=session_id%>"  frameborder="0">
	<frame src="../../eCA/jsp/CACoderFunctionButtons.jsp?<%=params%>&session_id=<%=session_id%>" frameborder="0">
	<frame src="../../eCommon/html/blank.html" frameborder="0">
	<frame name="dummyFrame" id="dummyFrame"  src="../../eCommon/html/blank.html" frameborder="0">
</frameset><noframes></noframes>
<%
	}
%>
</html>

