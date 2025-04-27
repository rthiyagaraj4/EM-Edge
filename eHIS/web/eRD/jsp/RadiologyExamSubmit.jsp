<!DOCTYPE html>
<%
/*
Sr No        Version              TFS               SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735      PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
2            V220328            29768      PMG2021-COMN-CRF-0089.3-TF-US001            Mohanapriya K
*/
%>
<%@page import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eAE.resources.*,eCA.resources.*,eCA.*,eRD.* ,eRD.Common.*,webbeans.eCommon.*, eCommon.Common.*,java.util.*,java.lang.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
 <%
  request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String fetchoption="";
String fetchSts=request.getParameter("status"); 
	if(fetchSts==null) fetchSts=""; 
System.err.println("fetchSts="+fetchSts);

if(fetchSts.equals("Report Modified")) fetchoption="M"; 
else if(fetchSts.equals("Reported-On Hold")) fetchoption="H"; 
else if(fetchSts.equals("Reported-Prelim")) fetchoption="P"; 
else if(fetchSts.equals("Reported-Final")) fetchoption="F"; 
else fetchoption="";

	System.err.println("fetchoption="+fetchoption);
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
 	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../js/RadiologyExam.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="">

<form name='submit_form' id='submit_form' id="submit_form" target='messageFrame' action="" method="post" >


<table align='left' border='3' width='100%' >
<tr>
	
<td>
 <table border="0" id='tbId' width="100%" valign='bottom'>
	<tr>
		 <td   class='QRYEVEN' width="10%"><font size=1><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/>(P)</b></td> 
		<td bgcolor='Red' width="3%"></td><td   class='QRYEVEN' width="4%"><font size=1><b><fmt:message key="eRD.stat.label" bundle="${rd_labels}"/></b></td>
		<td bgcolor='orange' width="3%"></td><td   class='QRYEVEN' width="4%"><font size=1><b><fmt:message key="Common.urgent.label" bundle="${common_labels}"/> </b></td>
		<td bgcolor='33FFC9' width="3%"></td><td   class='QRYEVEN' width="4%"><font size=1><b><fmt:message key="Common.routine.label" bundle="${common_labels}"/> </b></td>
		<td class='label' style='text-align:right' width="68%"><b><fmt:message key="Common.type.label" bundle="${common_labels}"/></b>
		</td>
		<td class='fields'  style='text-align:center' width="69%">
			<SELECT name="type" id="type" id="type" style="width:75;" onChange='typeChange(this);' disabled>
			<%
			System.err.println("statussel befre--"+request.getParameter("seltype"));
			String statussel=request.getParameter("seltype") == null ? "": request.getParameter("seltype");
			System.err.println("statussel--"+statussel);
			if(statussel.equals("Y") && (fetchoption.equals("F") || fetchoption.equals("M"))){
				%>
				<option value='M' <%=fetchoption.equals("M")?"selected":""%>><fmt:message key="Common.Modify.label" bundle="${common_labels}"/></option>
			
			<%	}else{
				System.err.println("fetchoption--"+fetchoption);
				%>
				<option value='sel' <%=fetchoption.equals("")?"selected":""%>><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
				<option value='H' <%=fetchoption.equals("H")?"selected":""%>><fmt:message key="eOR.OnHold.label" bundle="${or_labels}"/> </option>
				<option value='P' <%=fetchoption.equals("P")?"selected":""%>><fmt:message key="eOR.Prelim.label" bundle="${or_labels}"/> </option>
				<option value='F' <%=fetchoption.equals("F")?"selected":""%>><fmt:message key="Common.Finalized.label" bundle="${common_labels}"/></option>
			
			<%
			}
			%>
			</SELECT>
		</td><td></td>
		<td  class='labels' style='text-align:center' width="20%">
			<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Submit.label","common_labels")%>' class='button' disabled id='submitbtn' name='submitbtn' onclick="insertRecords();" />
		</td>
	</tr>
	</table> 
</td>
</tr>
</table>
	 <input type="hidden" value="" name="count" id="count" id="count" />
	 <input type="hidden" value="" name="typeN" id="typeN" id="typeN" /><!--V221006-->
	 <input type="hidden" value="<%=fetchoption%>" name="report_from" id="report_from" />
	 <input type="hidden" value="" name="report_to" id="report_to" id="report_to" />
	 <input type="hidden" value="" name="mod_date" id="mod_date" id="mod_date" /> <!--V220328-->
	 <input type="hidden" value="" name="new_mod_date" id="new_mod_date" id="new_mod_date" /> <!--V220328-->
</form>
</body>
</html>

