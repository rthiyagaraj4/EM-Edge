<!DOCTYPE html>
<html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" %>

<%@ page contentType="text/html; charset=UTF-8"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 	request.setCharacterEncoding("UTF-8"); %>
 	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
  <%
	
	//Periodontal Chart should not be displayed for Deciduous and Mixed Dentition Patients.
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String disabled = "";
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String chart_type_for_alert = checkForNull(request.getParameter("chart_type_for_alert"));//Added by Sridevi Joshi on 4/27/2010 for PE ...the qry for this value was getting executed in all frames mentioned in OH.jsp
	

	 try{
		con=ConnectionManager.getConnection(request);
		if(chart_type_for_alert.equals("")){//Added by Sridevi Joshi on 4/27/2010 for PE ...the qry for this value was getting executed in all frames mentioned in OH.jsp
			disabled = "disabled";
		}	
 %>
	
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<script language="javascript">
function changeTab(objStr){
	
	var frmObj=document.forms[0];
	selectTab(objStr);
	var param=frmObj.param.value;
	var oh_chart_level=frmObj.oh_chart_level.value;
	switch(objStr){
		case "BaselineChart": 
			  param=param+"&called_from_chart_tab_flag=B"+"&oh_chart_level="+oh_chart_level;
			  parent.document.getElementById("ohframeset").rows= "0%,4%,12%,*";
			  //parent.frames[1].location.href="../../eOH/jsp/PerioBaselineChart.jsp?"+param;
			  parent.perioChartHeaderFrame.location.href="../../eOH/jsp/PerioChartHeader.jsp?"+param;//frames[1]
			  parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			  break;
		case "EvaluationChart": 
			  param=param+"&called_from_chart_tab_flag=E"+"&oh_chart_level="+oh_chart_level;
			  parent.document.getElementById("ohframeset").rows= "0%,4%,12%,*";
			  //parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioEvaluationChart.jsp?"+param; //frames[1]
			  parent.perioChartHeaderFrame.location.href="../../eOH/jsp/PerioEvalChartHeader.jsp?"+param; //frames[1]
			  parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
    		  break;
		case "Compare": 
			  param=param+"&called_from_chart_tab_flag=C"+"&oh_chart_level="+oh_chart_level;;
			  parent.document.getElementById("ohframeset").rows= "0%,4%,25%,*";
			  parent.perioChartHeaderFrame.location.href="../../eOH/jsp/PerioCompareChartHeader.jsp?"+param; //frames[1]
			  //parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioCompare.jsp?"+param;//frames[1]
			  parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			  break;
		
	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- <fmt:message key="Common.Condition.label" bundle="${common_labels}"/> -->

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="OHCommonForm" id="OHCommonForm">

<table id="tab" cellspacing=0 cellpadding=3 border="0" width='100%'>
<tr>
	<td width= "100%" class="white">
	<ul id="tablist" class="tablist" >
		<li class="tablistitem" title='BaselineChart' >
			<!--Commented by Sharon Crasta on 11/26/2008 for SCR #6545-->
			<!-- Added disabled flag to disable the tabs for Deciduous and Mixed Dentition Patients-->
			 <!--<a  class="tabClicked"  onclick="changeTab('BaselineChart');" id="BaselineChart"> -->
			<!--	-->
			 <a  class="tabClicked"  onclick="changeTab('BaselineChart');" id="BaselineChart" <%=disabled%>> 
				<span class="tabSpanclicked" id="BaselineChartspan" value="1"><fmt:message key="eOH.BaselineChart.Label" bundle="${oh_labels}"/></span> 
			</a> 
			
		</li>
		<li class="tablistitem" title='EvaluationChart' >
			<!--Commented by Sharon Crasta on 11/26/2008 for SCR #6545-->
			<!--<a  class="tabA"  onclick="changeTab('EvaluationChart');" id="EvaluationChart" > -->
			<!-- -->
			<a  class="tabA"  onclick="changeTab('EvaluationChart');" id="EvaluationChart" <%=disabled%>> 
				<span class="tabAspan" id="EvaluationChartspan" value="15"><fmt:message key="eOH.EvaluationChart.Label" bundle="${oh_labels}"/> </span>
			</a>
		</li> 
		<li class="tablistitem" title='Compare' >
			<!--Commented by Sharon Crasta on 11/26/2008 for SCR #6545-->
			<!--<a  class="tabA"  onclick="changeTab('Compare');" id="Compare"> -->
			<!-- -->
			<a  class="tabA"  onclick="changeTab('Compare');" id="Compare" <%=disabled%>> 
				<span class="tabAspan" id="Comparespan" value="25"><fmt:message key="eOH.Compare.Label" bundle="${oh_labels}"/></span>
			</a>
		</li> 
	</ul>
	</td>
</tr>
	<!-- The below line is required to change the select state of Initial tab selected -->
	<script>
		prevTabObj='BaselineChart'
		
	</script>
	

</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<input type='hidden' name='oh_chart_level' id='oh_chart_level' value='<%=oh_chart_level%>'>
</form>
</body>
</html>
<% 
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}%>

