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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
04/12/2012		IN031304		ChowminyaG		Include Dept_authorization validation for RD orders br appt schedule(IN035976)	 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eOR.*,java.text.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="beanQuery" scope="page" class="eOR.QueryBean"/>
<%-- Mandatory declarations end --%>
 
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/PendingOrdersSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%

//String bean_id	 = "Or_PatOrderByPrivRelnBean" ;
//String bean_name = "eOR.PatOrderByPrivRelnBean";
//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)getBeanObject( bean_id, bean_name, request ) ;

SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
java.util.Date date	 			= new java.util.Date();
String dateString 				= dtSystemFormat.format(date);
request.setCharacterEncoding("UTF-8");

String order_category	 = request.getParameter( "order_category" )	== null?"":request.getParameter( "order_category" )	;
String order_type		 = request.getParameter( "order_type" )		== null?"":request.getParameter( "order_type" )		;
String activity_type	 = request.getParameter( "activity_type" )	== null?"":request.getParameter( "activity_type" )	;
String order_catalog_code= request.getParameter( "orderable" )		== null?"":request.getParameter( "orderable" )		;
String performing_locn	 = request.getParameter( "performing_locn" )== null?"":request.getParameter( "performing_locn" );
String priority			 = request.getParameter( "priority" )		== null?"":request.getParameter( "priority" )		;
String patient_id		 = request.getParameter( "patient_id" )		== null?"":request.getParameter( "patient_id")		;
String patient_class	 = request.getParameter( "patient_class" )	== null?"":request.getParameter( "patient_class" )	;
String period_from		 = request.getParameter( "date_from" )		== null?"":request.getParameter( "date_from" )		;
String period_to		 = request.getParameter( "date_to" )		== null?"":request.getParameter( "date_to" )		;

String facility_id = (String)session.getValue("facility_id");
//out.print("<script>alert('period_from:-"+period_from+"--period_to-"+period_to+"--');</script>");	

ArrayList resultData=new ArrayList();
Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 

//resultData=(ArrayList)bean.getSearchDetails(order_category,order_type, activity_type ,order_catalog_code ,performing_locn ,priority ,patient_id , patient_class , period_from, period_to,facility_id);
beanQuery.setLanguageId(localeName);

resultData=(ArrayList)beanQuery.getPendingScheduleSearchDetails(order_category,order_type, activity_type ,order_catalog_code ,performing_locn ,priority ,patient_id , patient_class , period_from, period_to,facility_id,properties);

//out.println("<script>alert('"+resultData.size()+"');</script>");
if(resultData.size() == 0)
{
	//parent.pendingOrdersScheduleSearch.document.pendingOrder_schedule.search_result.disabled=false;
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
	%>
	<script>
		parent.pendingOrdersScheduleHeader.document.location.href="../../eCommon/html/blank.html";
		parent.pendingOrdersScheduleResult.document.location.href="../../eCommon/html/blank.html";
		parent.pendingOrdersScheduleSearch.document.pendingOrder_schedule.search_result.disabled = false;
	</script>
<%
}
%>
<form name='pendingOrder_schedule_result' id='pendingOrder_schedule_result'>
<table name='' id='' border='1' cellspacing='0' cellpadding = '3'  width="100%" align="center" class="grid">
<%
try{

String slClassValue		 = "";
//String order_cat		 = "";
String sex				 = "";
String Patient_Id		 = "";
String Patient_details   = "";
//String temp_grpby		 = "";
String order_id			 = "";
String colorString		 = "";
String wait_indicator	 = "";
String locn_code		 = "";
String start_date_time	 = "";
String order_line_num	 = "";
String  Priority="";
String rad_auth_yn	 = "N"; //--[IN031304]

String[] row_details = null;
row_details			 = new String[25];
for(int i=0;i<resultData.size();i++){

	//row_details			 = new String[25];
	row_details			 = (String[])resultData.get(i);
	Patient_details		 = (String)row_details[0]	;
//	order_cat			 = (String)row_details[1]	;
	order_id			 = (String)row_details[6]	;
	Patient_Id			 = (String)row_details[7]	;
	order_catalog_code	 = (String)row_details[11]	;
	locn_code			 = (String)row_details[13]	;
	order_line_num		 = (String)row_details[20]	;
	start_date_time		 = (String)row_details[21]	;
	wait_indicator		 = (String)row_details[23]	;
	sex					 = (String)row_details[24]	;
	Priority           =  (String)row_details[3];
	
	//--[IN031304]-Start
	rad_auth_yn=(String)beanQuery.getRadiologyAuthYn(order_id,order_line_num);
	//--[IN031304] - End
	/*if(i % 2 == 0)
		slClassValue = "QRYEVEN";
	else
		slClassValue = "QRYODD";*/
		slClassValue="gridData";
	
	if(wait_indicator==null)
		wait_indicator= "";
	
	if(!wait_indicator.equals("") && wait_indicator.equals("GREEN"))
		colorString = "QRY2";
	else if(!wait_indicator.equals("") && wait_indicator.equals("RED"))
		colorString = "QRY7";
	else if(!wait_indicator.equals("") && wait_indicator.equals("YELLOW"))
		colorString = "YELLOW";
	
	if(Priority.trim().equalsIgnoreCase("U")){
				
			Priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");	

			}else if(Priority.trim().equalsIgnoreCase("S")){
				
				Priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
			}else{
				
				Priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			}
	
	
	%>
	<tr>
	
		<td width='8%' class='<%=((!wait_indicator.equals("") && wait_indicator.equals("NORMAL"))?slClassValue:colorString)%>' align=left><font size=1>&nbsp;</font></td>
		
		<td width='8%' class='<%=slClassValue%>' align=left><font size=1><%=Priority%>&nbsp;</font></td>
		<!--Pass rad_auth_yn --[IN031304]  -->
		<td width='17%' class='<%=slClassValue%>' align=left nowrap><font size=1><a class='gridLink' href='#' onClick="BookAppointment('<%=Patient_Id%>','<%=locn_code%>','<%=start_date_time%>','<%=order_catalog_code%>','<%=order_id%>','<%=order_line_num%>','<%=rad_auth_yn%>')" ><%=com.ehis.util.DateUtils.convertDate(start_date_time,"DMYHM","en",localeName)%></a></font></td>
		
		<td width='25%' class='<%=slClassValue%>' align=left><font size=1><a class='gridLink' href='#' onClick="callfunc('View','<%=(String)row_details[2]%>','<%=order_id%>','<%=sex%>', '<%=Patient_Id%>')" ><%=(String)row_details[10]%></a></font></td>

		<td width='27%' class='<%=slClassValue%>' align=left><font size=1><%=Patient_details%></font></td>
		
		<td width='15%' class='<%=slClassValue%>' align=left><font size=1><%=(String)row_details[18]%></font></td> 

	</tr>
	<%}

}catch(Exception e){
	//out.println("Exception in displaying the values::"+e.getMessage());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
	
}%>
<script>
parent.pendingOrdersScheduleSearch.document.pendingOrder_schedule.search_result.disabled=false;
</script>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%//=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%//=bean_name%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<!-- <input type="hidden" name="total_recs" id="total_recs" value="<%//=resultData.size()%>" >-->
<input type="hidden" name="current_date" id="current_date" value="<%=dateString%>">
<form>

</body>
</html>
 

