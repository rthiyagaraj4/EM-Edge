<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------
Date       	Edit History      	Name        		Description
-----------------------------------------------------------------------
?             	100            	?           		created
26/10/2012    IN032816       Chowminya G     Result Reporting > Record Clinical Note > Mark Error 
-----------------------------------------------------------------------
--> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*,eCommon.XSSRequestWrapper "%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%

//	out.println(request.getQueryString());
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String rows="";	
	String mode	= "1";//request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String func_type	= request.getParameter("func_type");	
	if (func_type == null) func_type = "";
	String bean_id = "Or_ResultEntry" ;
	String bean_name = "eOR.ResultEntryBean";
	/* Mandatory checks end */
	/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.clearForRecord(); //Added by prasad on 2/5/2007

	bean.setFunc_type(func_type);
	String option_id = bean.checkForNull(request.getParameter( "option_id" )) ;
	String fromval = bean.checkForNull(request.getParameter( "from" )) ;	
	/* Initialize Function specific end */

	 String task_type = request.getParameter("colval1");
	 String orderId = request.getParameter("orderId");
	 String order_line_num = request.getParameter("order_line_num")==null?"1": request.getParameter("order_line_num");
	 String patient_id = request.getParameter("patient_id");
	 String patient_class = request.getParameter("patient_class");
	 String encounter_id = request.getParameter("encounter_id");
/**
	modified by Deepa on 13/05/2010 for IN021020
**/
	 String dob = request.getParameter("dob");

	 String performed_only = request.getParameter("performed_only")==null?"":request.getParameter("performed_only");	


	
	 String colval = request.getParameter("colval");
	 if (colval==null||colval.equals("null")||colval=="")
	 {
		 colval="";
	 }
	 //colval = java.net.URLDecoder.decode(colval,"UTF-8");
	 String requestFrom = request.getParameter("requestFrom");
	 String report_srl_no = request.getParameter("report_srl_no");
	 String order_category = request.getParameter("order_category");
	  String order_status = request.getParameter("order_status");//--[IN032816]
/**
	modified by Deepa on 13/05/2010 for IN021020
	added sex,dob to handle multiple reference range
**/	
	 String sex = request.getParameter("sex");

	 String from = request.getParameter("from");	
	 String header_values = request.getParameter("header_values");

	
	 String resultReportingURL = request.getQueryString();
	  //out.println("<script>alert('resultReportingURL from res entry="+resultReportingURL+"');</script>");
	/********this two parameters will have values only when called from task list *****/
	 String child_order_index = request.getParameter("TLchild_order_index");
	 String child_reporting_date = request.getParameter("TLchild_reporting_date");
	 if(child_order_index==null)	child_order_index="";
	 if(child_reporting_date==null)	child_reporting_date="";
	 /*************/
	
	 if(requestFrom==null)	requestFrom="";
	 if(patient_id==null)	patient_id="";
	 if(encounter_id==null)	encounter_id="";
	 if(report_srl_no==null)	report_srl_no="";
	 if (order_category==null) order_category="";
//out.println("requestFrom in result entry "+requestFrom+" ==");
	 StringBuffer qryStr=new StringBuffer(); 
	 StringBuffer qryStr1=new StringBuffer(); 
	 //--[IN032816]
	qryStr.append("orderId="+orderId+"&function_id="+function_id+"&order_line_num="+order_line_num+"&from="+from+"&order_status="+order_status);
	//qryStr.append("orderId="+orderId+"&function_id="+function_id+"&order_line_num="+order_line_num+"&from="+from);
	 if(requestFrom.trim().equalsIgnoreCase("RA"))
		qryStr.append( "&task_type=ResultEntry"+"&report_srl_no="+report_srl_no+"&requestFrom="+requestFrom+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&performed_only="+performed_only);
	 else	qryStr.append( "&task_type="+task_type+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&TLchild_order_index="+child_order_index+"&TLchild_reporting_date="+ child_reporting_date+"&performed_only="+performed_only);
	 
	 qryStr.append("&order_category="+order_category+"&sex="+sex+"&colval="+colval+"&dob="+dob+"&performed_only="+performed_only);

 //out.println("<script>alert('resultReportingURL from res entry="+qryStr.toString()+"');</script>");

	boolean freqExplApplies = true;
	freqExplApplies = bean.checkFreqExplosion(orderId);

	//out.println("<script>alert('=freqExplApplies=="+freqExplApplies+"==requestFrom="+requestFrom+"====')</script>");
//out.println("<script>alert('=qryStr=="+qryStr+"=======')</script>");

	%>
	
<title><fmt:message key="eOR.ResultEntry.label" bundle="${or_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%if(!freqExplApplies || requestFrom.trim().equalsIgnoreCase("RA")){
	if(!(((fromval.equalsIgnoreCase("TaskList"))&&(option_id.equals("CA_TASK_LIST_DT")))||((fromval.equalsIgnoreCase("ResultReporting"))&&(option_id.equals("TASK_ORDER_REPORT")))))
	{
		rows="16%,10%,*%,6%,0%";
	}else{
		rows="5%,10%,*%,6%,0%";}
		
%>
<!-- <frameset rows='16%,10%,5%,*%,6%,0%'> -->
<frameset rows='<%=rows%>'>
	<frame name='ResultEntryTop' src='ResultEntryTop.jsp?<%=qryStr%>&<%=resultReportingURL%>' frameborder=0  noresize scrolling=auto>
	<frame name='ResultEntryReport' src='ResultEntryReport.jsp?<%=resultReportingURL%>&<%=qryStr%>' frameborder=0  noresize  scrolling=auto>
	<!-- <frame name='ResultEntryHeader' src='ResultEntryHeader.jsp?<%=qryStr%>' frameborder=0 scrolling=auto noresize> -->
	<frame name='ResultEntryDtl' src='ResultEntryDetail.jsp?<%=qryStr%>' frameborder=0 scrolling=auto>
	<frame name='ResultEntryBtn' src='ResultEntryBtn.jsp?<%=header_values%>&<%=resultReportingURL%>&<%=qryStr%>' frameborder=0 scrolling=no>
	<frame name='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no>
</frameset>
<%}else{
		if(!(((fromval.equalsIgnoreCase("TaskList"))&&(option_id.equals("CA_TASK_LIST_DT")))||((fromval.equalsIgnoreCase("ResultReporting"))&&(option_id.equals("TASK_ORDER_REPORT")))))
		{
			rows="15%,84%,6%";
		}else
		{
		rows="5%,84%,6%";}		
		qryStr1=qryStr;
		qryStr1.append("&option_id="+option_id);
%>
<frameset rows='<%=rows%>'>
	<frame name='ResultEntryTop' src='ResultEntryTop.jsp?<%=qryStr1%>' frameborder=0  noresize scrolling=auto>
	<frameset cols ='14%,*%'>
		<frame name='ResultEntryFrequency' src='ResultEntryFrequency.jsp?<%=resultReportingURL%>&<%=qryStr%>' frameborder=0  noresize >
		<!-- <frameset rows='12%,7%,*%'> -->
		<frameset rows='12%,*%'>
			<frame name='ResultEntryReport' src='../../eCommon/html/blank.html' frameborder=0  noresize  scrolling=auto>
		<!-- 	<frame name='ResultEntryHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize> -->
			<frame name='ResultEntryDtl' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto>
		</frameset>
	</frameset>
	<frame name='ResultEntryBtn' src='ResultEntryBtn.jsp?<%=header_values%>&<%=resultReportingURL%>&<%=qryStr%>&freqExplApplies=Y&showRecordButton=N' frameborder=0 scrolling=no>
</frameset>
<%}
	putObjectInBean(bean_id,bean,request);	
%>
