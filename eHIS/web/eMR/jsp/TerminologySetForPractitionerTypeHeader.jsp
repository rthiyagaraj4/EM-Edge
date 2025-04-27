<!DOCTYPE html>
<!--TerminologySetForPractionerTypeHeader.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*  File Name		:	TerminologySetForPractitionerTypeHeader.jsp
*	Purpose 			:	
*	Created By		:	Suubulakshmy. K
*	Created On		:	30 Dec 2004-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.*,java.util.*, eCP.*, eCommon.Common.*,eCommon.XSSRequestWrapper "%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>

	
	<script>function_id = "<%=request.getParameter("function_id")%>";	</script>
	<script language="javascript" src="../js/TerminologySetForPractitionerType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	
	Connection conn 		= null;
	PreparedStatement pstmt_TermSet 	= null;
	ResultSet rs_TermSet	=	null;
	ArrayList TermSet_Data	= new ArrayList();
	String[] record				=	null;
	conn = ServiceLocator.getInstance().getConnection(request);
	try{
		String sql_TermSet="select term_set_id, term_set_desc from mr_term_set where eff_status='E' order by term_set_desc";
		pstmt_TermSet=conn.prepareStatement(sql_TermSet);
		rs_TermSet=pstmt_TermSet.executeQuery();
		while (rs_TermSet != null && rs_TermSet.next()) {
			record = new String[2];				
			record[0] = rs_TermSet.getString("term_set_id");
			record[1] = rs_TermSet.getString("term_set_desc");
			TermSet_Data.add(record) ;
		}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		rs_TermSet.close() ;
		pstmt_TermSet.close() ;
		ServiceLocator.getInstance().returnConnection(conn,request);
	}
%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='formSearch' id='formSearch'>
	<table width='100%' cellpadding='3' cellspacing='0' border='0' align='center'>
	
	<tr>
	<td width='20%' class='label'><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/> </td>
		<td width='80%' class='fields' ><select name='terminology' id='terminology' onchange='changeTerminology();'>
			<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
		<% for(int i=0;i<TermSet_Data.size();i++){
				record=(String[])TermSet_Data.get(i);
		%>
				<option value='<%=record[0]%>'><%=record[1]%></option>
		<%}%>
			</select><img src="../../eCommon/images/mandatory.gif"></td>
			<td class='label'></td>
			</tr>
	<tr>
	<!-- Modified by munisekhar on 18-09-12 against Incident Number 35168 --> 
	<td width='20%' class='label'><fmt:message key="Common.PractitionerTypeDescription.label" bundle="${common_labels}"/> </td>
	<!-- Commented by munisekhar on 18-09-12 for incident IN35168
	<td width='20%' class='label'><fmt:message key="Common.search.label" bundle="${common_labels}"/> </td> -->
	<td width='80%' class='fields'><input type='text' name='pract_type' id='pract_type' size='15' maxlength='15' ></input><select name='search_criteria' id='search_criteria'><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select></td>
	<td class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='searchPratType()'></td></tr>
	</table>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

