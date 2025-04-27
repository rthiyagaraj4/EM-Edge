<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOH.* "%>
<%-- JSP Page specific attributes end --%> 


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	/* Mandatory checks start */
	String mode	= "1";//request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String func_type	= request.getParameter("func_type");
	if (func_type == null) func_type = "";
	String bean_id = "Oh_ResultEntry" ;
	String bean_name = "eOH.ResultEntryBean";
	/* Mandatory checks end */
	/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.clearForRecord(); //Added by prasad on 2/5/2007

	bean.setFunc_type(func_type);
	/* Initialize Function specific end */

	 String task_type = request.getParameter("colval1");
	 String orderId = request.getParameter("orderId");
	 String order_line_num = request.getParameter("order_line_num");
	 String patient_id = request.getParameter("patient_id");
	 String patient_class = request.getParameter("patient_class");
	 String encounter_id = request.getParameter("encounter_id");
	
	 String colval = request.getParameter("colval");
	 if (colval==null||colval.equals("null")||colval=="")
	 {
		 colval="";
	 }
	 //colval = java.net.URLDecoder.decode(colval,"UTF-8");
	 String requestFrom = request.getParameter("requestFrom");
	 String report_srl_no = request.getParameter("report_srl_no");
	 String order_category = request.getParameter("order_category");
	 String sex = request.getParameter("sex");
	 String from = request.getParameter("from");
	 String header_values = request.getParameter("header_values");
	 String resultReportingURL = request.getQueryString();
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
		
	 StringBuffer qryStr=new StringBuffer(); 
	qryStr.append("orderId="+orderId+"&function_id="+function_id+"&order_line_num="+order_line_num+"&from="+from);

	 if(requestFrom.trim().equalsIgnoreCase("RA"))
		qryStr.append( "&task_type=ResultEntry"+"&report_srl_no="+report_srl_no+"&requestFrom="+requestFrom+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class);
	 else	qryStr.append( "&task_type="+task_type+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&TLchild_order_index="+child_order_index+"&TLchild_reporting_date="+ child_reporting_date);
	 
	 qryStr.append("&order_category="+order_category+"&sex="+sex+"&colval="+colval);

	boolean freqExplApplies = true;
	freqExplApplies = bean.checkFreqExplosion(orderId);

	//out.println("<script>alert('=freqExplApplies=="+freqExplApplies+"==requestFrom="+requestFrom+"====')</script>");
//out.println("<script>alert('=qryStr=="+qryStr+"=======')</script>");

	%>
	
<title><fmt:message key="eOR.ResultEntry.label" bundle="${or_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%if(!freqExplApplies || requestFrom.trim().equalsIgnoreCase("RA")){%>
<!-- <frameset rows='16%,10%,5%,*%,6%,0%'> -->
<frameset rows='16%,10%,*%,6%,0%'>
	<frame name='ResultEntryTop' src='ResultEntryTop.jsp?<%=qryStr%>&<%=resultReportingURL%>' frameborder=0  noresize scrolling=auto>
	<frame name='ResultEntryReport' src='ResultEntryReport.jsp?<%=resultReportingURL%>&<%=qryStr%>' frameborder=0  noresize  scrolling=auto>
	<!-- <frame name='ResultEntryHeader' src='ResultEntryHeader.jsp?<%=qryStr%>' frameborder=0 scrolling=auto noresize> -->
	<frame name='ResultEntryDtl' src='ResultEntryDetail.jsp?<%=qryStr%>' frameborder=0 scrolling=auto>
	<frame name='ResultEntryBtn' src='ResultEntryBtn.jsp?<%=header_values%>&<%=resultReportingURL%>&<%=qryStr%>' frameborder=0 scrolling=no>
	<frame name='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no>
</frameset>
<%}else{ 
%>
<frameset rows='15%,84%,6%'>
	<frame name='ResultEntryTop' src='ResultEntryTop.jsp?<%=qryStr%>' frameborder=0  noresize scrolling=auto>
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
