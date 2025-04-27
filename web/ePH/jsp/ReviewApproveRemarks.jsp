<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028(newly created for this crf)
---------------------------------------------------------------------------------------------------------------
*/ %>
<html>
	<head>
		<title><fmt:message key="ePH.Review&Approve.label" bundle="${ph_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String	bean_id_1					=	"DispMedicationBean" ;
		String	bean_name_1					=	"ePH.DispMedicationBean";
		DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
		bean_1.setLanguageId(locale);
		String	bean_id						=	"DispMedicationAllStages" ;
		String	bean_name					=	"ePH.DispMedicationAllStages";

		DispMedicationAllStages bean		= (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
		bean.setLanguageId(locale);

		String login_user	=	(String)session.getValue("login_user");	
		String user_id	=	(String)session.getValue("user_id");	
		String sysdate		=   bean.getCurrDateTime();
		String ReviewRemarks	= request.getParameter("ReviewRemarks")==null?"":request.getParameter("ReviewRemarks");
		String alergy_details="";
		String  dosage_details="";
		String  duplicate_details="";
		String  intaraction_details="";
		String reviewed_by="";
		String review_date="";
		String calling_func=request.getParameter("calling_func")==null?"":request.getParameter("calling_func");
		String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_no = request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String allergy_cnt = request.getParameter("allergy_cnt")==null?"":request.getParameter("allergy_cnt");
		ArrayList ReviewDetails	=	new ArrayList();
		ReviewDetails=bean.getReviewDetails(order_id,order_line_no);
		
		  alergy_details=(String)ReviewDetails.get(2);
		  dosage_details=(String)ReviewDetails.get(3);
		  duplicate_details=(String)ReviewDetails.get(4);
		  intaraction_details=(String)ReviewDetails.get(5);
		  reviewed_by=(String)ReviewDetails.get(0);
			  if(reviewed_by.equals("")){
			  reviewed_by=login_user;
			  }
		 
		  if(review_date.equals("")){
			  review_date=sysdate;
		  }
		  if(calling_func.equals("alergy")){
			  ReviewRemarks = java.net.URLDecoder.decode(alergy_details,"UTF-8");   
		  }
		  else if(calling_func.equals("diagnosis")){
				ReviewRemarks = java.net.URLDecoder.decode(duplicate_details,"UTF-8"); 		  
			 }
		  else if(calling_func.equals("doselimit")){
				ReviewRemarks = java.net.URLDecoder.decode(dosage_details,"UTF-8"); 		  
			 }
			  else if(calling_func.equals("intaraction")){
				ReviewRemarks = java.net.URLDecoder.decode(intaraction_details,"UTF-8"); 		  
			 }
		  else{
				ReviewRemarks	= request.getParameter("ReviewRemarks")==null?"":request.getParameter("ReviewRemarks");
		  }
		
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="ReviewRemarks" id="ReviewRemarks" >
			<table  border='0' align="center" width='100%' cellpadding='0' cellspacing='0'>
				<tr>	
					
					<td  ><label ><fmt:message key="ePH.ReviewedBy.label" bundle="${ph_labels}"/> :</label></td>
					<td  ><label ><%=reviewed_by%></label></td>
					<td  ><label ><fmt:message key="ePH.ReviewedDateTime.label" bundle="${ph_labels}"/> :</label></td>
					<td  ><label ><%=review_date%></label></td>
					
				</tr>
				<tr>	
					<td colspan='4'>&nbsp;</td>
				</tr>
				</table>
				<table  border='0' align="center" width='100%' cellpadding='0' cellspacing='0'>
				<tr>
					<td  colspan='2'><label ><fmt:message key="ePH.ReviewComments.label" bundle="${ph_labels}"/><img align="center" src="../../eCommon/images/mandatory.gif"></img> :</label></td>
					<td >
						<textarea name="drug_indicate" value=""   rows='7' cols='60' maxlength="200" onKeyPress="return checkDrugIndMaxLimit_disp(this,200);" ><%=ReviewRemarks%></textarea>
					</td>
				</tr>
				<tr>	
					<td colspan='4'>&nbsp;</td>
				</tr>
				<tr>						
					<td class="white" align='center'colspan='4'> 
						<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="savedrugIndicationRemarks(document.ReviewRemarks.drug_indicate,'<%=calling_func%>','<%=order_id%>','<%=order_line_no%>','<%=allergy_cnt%>');">&nbsp;&nbsp;
						<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="parent.window.close();">
					</td>
				</tr>
				<input type='hidden' name='drug_indication' id='drug_indication' value='<%=ReviewRemarks%>'>
			</table>
			<input type="hidden" name="reviewed_by" id="reviewed_by" value="<%=reviewed_by%>" />
		<input type="hidden" name="review_date" id="review_date" value="<%=review_date%>" />  
		<input type="hidden" name="alergy_details" id="alergy_details" value="<%=alergy_details%>" />
		<input type="hidden" name="dosage_details" id="dosage_details" value="<%=dosage_details%>" />
		<input type="hidden" name="duplicate_details" id="duplicate_details" value="<%=duplicate_details%>" />  
		<input type="hidden" name="intaraction_details" id="intaraction_details" value="<%=intaraction_details%>" />  
		
		<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>" />
		<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>" />   
		</form>  
	</body>
</html>

