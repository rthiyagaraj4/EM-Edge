<!--<!DOCTYPE html>-->
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function
19/10/2012    IN033061      Chowminya G  System doesnt display menu cancel/discontinue if the orders are IV Fluid ,IV Fluid+Drug, IV Fluid+Drug(Frequency).
07/08/2013	  IN042100      Chowminya G  Ph Category  -  Hold Order Option line level with MAR status P	
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
11/08/2014		IN049419		Karthi L											An Audit Trail for Additional Information Amendment of Order	
10/05/2017		IN064215		Krishna Gowtham J	10/05/2017		Ramesh G		PMG2017-SH-CRF-0001		
10/07/2017		IN061903		Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
18/07/2018              IN061961		sivabagyam M       18/07/2018		Ramesh G		GHL-CRF-0433
14/10/2019  	IN071315	    Nijitha S   		14/10/2019  	Ramesh G		GHL-CRF-0607
06/07/2020	  IN072654		Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
24/09/2020		IN074110		Nijitha S	24/09/2020	Remesh G	MMS-KH-CRF-0029.4/05
---------------------------------------------------------------------------------------------------------------
*/
%>

<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String task_type = request.getParameter("colval1");
String iv_prep_yn = request.getParameter("iv_prep_yn");//--[IN033061]
String order_line_num = request.getParameter("order_line_num");
//String event_code = request.getParameter("event_code");//	IN061961//commented for checkstyle
//String catalog_code = request.getParameter("catalog_code")==null?"":request.getParameter("catalog_code");//	IN061961//commented for checkstyle
//String order_category = request.getParameter("order_category")==null?"":request.getParameter("order_category");//	IN061961//commented for checkstyle
if(iv_prep_yn == null) iv_prep_yn = ""; //IN042100 to avoid null value
if(order_line_num == null) order_line_num = "";
//IN049419 - Start
String bean_id1   = "Or_ExistingOrder" ;
String bean_name1 = "eOR.ExistingOrder";
ExistingOrder bean1 = (ExistingOrder)getBeanObject( bean_id1, bean_name1, request ) ;
bean1.setLanguageId(localeName);
String audit_reqd_yn = bean1.getOrderFormatAuditTrailYN();
String instrn_type = request.getParameter("instrn_type")==null?"T":request.getParameter("instrn_type");
String p_called_from_ca			=request.getParameter("p_called_from_ca");//Added for IN071315
String existing_order_called_from_new = ((String)request.getParameter("existing_order_called_from_new"))==null ? "" : (String)request.getParameter("existing_order_called_from_new");//IN074110
String patient_id	= request.getParameter("patient_id");//IN072654
String encounter_id	= request.getParameter("encounter_id");//IN072654
//IN049419 - End
//String view_by = request.getParameter("view_by")==null?"":request.getParameter("view_by"); //IN064215 //commented for checkstyle IN061961
/*
String orderId = request.getParameter("orderId");// order_id
String colval = request.getParameter("colval"); //order category desctription
String patient_id = request.getParameter("patient_id"); 
String sex =  request.getParameter("sex");
String image_ref =  request.getParameter("image_ref");

//if(patient_id == null) patient_id = "";
if(from == null) from = "";
*/    
//out.println(patient_id); 
//out.println(task_type);
//out.println(colval);
//out.println(sex);
/*
the fg 4 req.getparameter are used in cancel of line records - begin
*/
/*String ord_cat_id = request.getParameter("val1");
String ord_cat = request.getParameter("ord_cat");
String cancel_type = request.getParameter("cancel_type");

String cont_order_ind = request.getParameter("cont_order_ind");
if(cont_order_ind == null) cont_order_ind = "";
String order_status = request.getParameter("order_status");

//out.println("ord_cat = "+ord_cat);

if(ord_cat_id == null) ord_cat_id = "";
if(ord_cat == null) ord_cat = "";
if(cancel_type == null) cancel_type = "";
if(order_line_num == null) order_line_num = "";
*/
/* - end */

//out.println(">>orderId>>>"+orderId+"<<<");

/*the fg req.getparameter for line Preps- end*/
/*String catalog_code = request.getParameter("catalog_code");
if(catalog_code == null) catalog_code = "";
*/
/*the fg req.getparameter for line comments- end*/
//if(item_narration == null) item_narration = "";


//Added if condition in cancel task type --[IN033061]
	if((task_type.trim()).equals("View")){%>
		<jsp:include page="ViewOrders.jsp" />
	<%}else if(task_type.equals("Cancels")){
	%>	
		<jsp:include page="CancelOrders.jsp" />
	<%}else if((task_type.trim()).equals("Completion")){%>
		<jsp:include page="CompleteOrder.jsp" />
	<%}else if((task_type.trim()).equals("UpdateOrder") || (task_type.trim()).equals("UpdateLine")){%>
		<jsp:include page="ReviewStatus.jsp" />
	<%}else if((task_type.trim()).equals("Cancel")){
		if((iv_prep_yn.trim()).equals("1") ||(iv_prep_yn.trim()).equals("2")||(iv_prep_yn.trim()).equals("3")||(iv_prep_yn.trim()).equals("4")||(iv_prep_yn.trim()).equals("5") )
		{
		%>
			<jsp:include page="CancelOrders.jsp" />
		<%
		}
		else
		{
		%> <!-- line level -->
			<jsp:include page="CancelLineComment.jsp" >
			<jsp:param value="<%=p_called_from_ca%>" name="p_called_from_ca"></jsp:param>
			 </jsp:include><!-- Added for IN071315 -->
		<%}
	}else if((task_type.trim()).equals("Preps")){
		//IN049419 - Start
		/* <jsp:include page="PrepsComment.jsp" /> */
		//IN64543, added instrn_type as param
		if(audit_reqd_yn.equalsIgnoreCase("N")){
		%>		
			<jsp:include page="PrepsComment.jsp"><jsp:param value="<%=instrn_type%>" name="instrn_type"></jsp:param> </jsp:include>
		<%}else{%>
			<jsp:include page="ViewOrderLineInstructions.jsp" ><jsp:param value="<%=instrn_type%>" name="instrn_type"></jsp:param></jsp:include>
		<%}			
		//IN049419 - End
	}
	else if((task_type.trim()).equals("Comments")){
		//IN049419 - Start
		/* <jsp:include page="ViewLineComment.jsp" />  */
		if(audit_reqd_yn.equalsIgnoreCase("N")) {
		%>
			<jsp:include page="ViewLineComment.jsp"><jsp:param value="<%=instrn_type%>" name="instrn_type"></jsp:param></jsp:include>
			<% }
		else {
		%>
			<jsp:include page="ViewOrderLineInstructions.jsp"><jsp:param value="<%=instrn_type%>" name="instrn_type"></jsp:param></jsp:include>
		<%	
		}
		//IN049419 - End
	}
	else if((task_type.trim()).equals("Instructions")){
		//IN049419 - Start
		/* <jsp:include page="ViewInstructions.jsp" /> */
		//IN64543, added instrn_type as param
		if(audit_reqd_yn.equalsIgnoreCase("N")) {
		%>
			<jsp:include page="ViewInstructions.jsp"><jsp:param name="instrn_type" value="<%=instrn_type%>"></jsp:param></jsp:include>
		<% }
		else {
			%>
			<jsp:include page="ViewOrderLineInstructions.jsp"><jsp:param name="instrn_type" value="<%=instrn_type%>"></jsp:param></jsp:include>
			<%	
		} //IN049419 - End
	}
	else if((task_type.trim()).equals("Review")){%>
		<jsp:include page="ReviewOrders.jsp" />
	<%}else if((task_type.trim()).equals("Discontinue")){%>
		<jsp:include page="DiscontinueOrders.jsp" />
	<%}else if((task_type.trim()).equals("Hold") && order_line_num.equals("")){%>
		<jsp:include page="HoldOrders.jsp" />
	<%}else if((task_type.trim()).equals("Hold")){%>
		<jsp:include page="HoldLineOrders.jsp" />
	<%}else if((task_type.trim()).equals("Resume")){%>  
		<jsp:include page="ResumeOrders.jsp" />
	<%}else if((task_type.trim()).equals("Result")){%>
		<jsp:include page="ResultViewOrders.jsp" />
	<%}else if((task_type.trim()).equals("Refusal")){%>
		<jsp:include page="RefusalOrderFrameset.jsp" />
	<%}else if((task_type.trim()).equals("Replace")){%>
		<jsp:include page="ReplaceAddOrderable.jsp" />
	<%}else if((task_type.trim()).equals("ChangeChargeType")){%>
		<jsp:include page="ChangeChargeType.jsp" />
	<%}else if((task_type.trim()).equals("ViewReplacedOrder")){%>	
		<jsp:include page="ViewOrders.jsp" /> 
	<%}else if((task_type.trim()).equals("ViewOriginalOrder")){%>	
		<jsp:include page="ViewOrders.jsp" /> 
	<!--IN29559,starts-->
	<%}else if((task_type.trim()).equals("RecordConsent")){%>	
		<jsp:include page="ConsentOrders.jsp" />
	<!--IN29559,ends-->
	<!--IN061903 starts-->
	<%}else if((task_type.trim()).equals("NotDone")){%>	
		<jsp:include page="NotDone.jsp" />
	<!--IN061903 ends-->
	<!--IN072654 starts-->
	<%}else if((task_type.trim()).equals("InteractionDtls")){%>	
		<jsp:include page="OROrderDrugInteractionDetails.jsp" >
		<jsp:param value="<%=patient_id%>" name="patient_id"></jsp:param>
		<jsp:param value="<%=encounter_id%>" name="encounter_id"></jsp:param>
	</jsp:include>
		<!--IN072654 ENDS-->
	<!--IN061903 ends-->
	<%}
	%>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<style>
textarea {
  resize: none;
}
</style>
