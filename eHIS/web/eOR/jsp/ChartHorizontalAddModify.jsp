<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>

<%-- JSP Page specific attributes start --%>

<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/ChartHorizontal.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<    <style>
        table {
            border-collapse: collapse; /* Ensures borders are merged */
            width: 100%; /* Optional: makes the table take the full width */
        }
        table, th, td {
            border: 1px solid transparent; /* Set transparent borders for inner cells */
        }
        table {
            border: 2px solid #a9a9a9; /* Lighter outline border for the table */
        }
        th, td {
            padding: 8px; /* Adds some padding to cells */
            text-align: left; /* Aligns text to the left */
        }
    </style>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" onload="FocusFirstElement()">
<%


	String readOnly = "" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "or_organism" ;
	String bean_name = "eOR.ChartHorizontalBean";
	//String disabled = "" ;
	int		totalRecords	=	0;
	
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ChartHorizontalBean bean = null ;
	try{
	 bean = 	(ChartHorizontalBean)getBeanObject( bean_id,bean_name, request );  
	}catch(Exception e){
	System.out.println("Caught=" + e.getMessage());	
	}
	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;

	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	/* Initialize Function specific end */


%>

<form name='Org_insert' id='Org_insert' target='messageFrame' >
<table  width='100%'>
 <tr>
		<td class='COLUMNHEADER' width='15%' align="left"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='40%' align="left"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='20%' align="left"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='4%' align="left"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='4%' align="left"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
</tr>

<%
int i = 0;
while(i < 10){
	
	String  classValue = "";

	if ( i % 2 == 0 )
		  	classValue = "gridData" ;
		  else
		  	classValue = "gridData" ;
	%>
<tr >
	<td class='<%=classValue%>'><input type=text name='org_code<%=i%>' id='org_code<%=i%>' onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this);parent.parent.resetColorCode(this);CheckForSpecCharsWithoutSpaceBlur(this)" size=2 maxlength=4 value='' <%=readOnly%>>
	<%if(i==0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%></td>

	<!-- <td align="left" class='<%=classValue%>'><input type=text name='org_long_desc<%=i%>' id='org_long_desc<%=i%>' onBlur="makeValidString(this);parent.parent.resetColorCode(this);" size=39 maxlength=40 value=""  <%=readOnly%>>
	<%if(i==0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%></td>
 -->
	<td class='<%=classValue%>'><input type=text name='org_long_desc<%=i%>' id='org_long_desc<%=i%>' onBlur="makeValidString(this);parent.parent.resetColorCode(this);" size=34 maxlength=40 value=""  <%=readOnly%>>
	<%if(i==0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%></td>

	<td class='<%=classValue%>'><input type=text name='org_short_desc<%=i%>' id='org_short_desc<%=i%>' onBlur="makeValidString(this);parent.parent.resetColorCode(this);" size=9 maxlength=15 value=""  <%=readOnly%> >
	<%if(i==0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%></td>
	
	<td class='<%=classValue%>'><input type="text" name='seq_no<%=i%>' id='seq_no<%=i%>' value="" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this);parent.parent.resetColorCode(this);" size=2 maxlength=2  <%=readOnly%> ><%if(i==0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%></td>
	
	<td class='<%=classValue%>'><input type="checkbox" name='eff_status<%=i%>' id='eff_status<%=i%>' value="E" checked  <%=readOnly%> ></td>
</tr >
<%i++;}%>

</table>
	
	<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
	<INPUT TYPE="hidden" name="chart_result_type" id="chart_result_type" value="">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
  
  </form>
	  
 </body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

