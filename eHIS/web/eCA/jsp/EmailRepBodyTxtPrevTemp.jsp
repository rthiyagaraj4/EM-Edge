<!DOCTYPE html>
<%
/*
 
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
28/11/2014    IN052646		Chowminya										TO provide Patient id in email content
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%> 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,java.sql.*,java.net.*,webbeans.eCommon.*,java.io.*, eCA.* ,eCommon.Common.*" %> 
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
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<!-- ****  Modified by Ambiga--CSS @02-02-09 **** -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>  <!-- For the common Lookup -->
 	<script language="JavaScript" src="../js/EmailRepBodyTxt.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>

<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	
  	/* Mandatory checks start */
	String[] record = null;	 
	/* Mandatory checks end */

 	/* Initialize Function specific start */
 	 	ArrayList templateValues		= null;
	/* Initialize Function specific end */
%>


<form name="EmailRepBodyTxtPrevEdtrForm" id="EmailRepBodyTxtPrevEdtrForm" method="post" target="messageFrame">
<table class="grid" width="100%" align=center>
<tr>
 	<td class='columnheader' width="25%"><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width="25%"><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></td>
	</tr>
<tr VALIGN="top">
<%	
	// For the Patient bring the details
	templateValues		= getTemplateValues("MBP"); 
	if(templateValues!=null && templateValues.size()>0) {  	
%>

<td width="25%" class="label">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>

<%		for( int i=0 ; i< templateValues.size(); i++ ) { 
			 record = (String[])templateValues.get(i); 
%>
			<tr><td class="label"><A href="javascript:setPrevTemplate('<%=record[1]%>')" class="gridLink"><%=record[0]%></a></td></tr>
 
<%  } %>
<%  } %>
</table>
</td>
<%
	// For the Encounter bring the details
	templateValues		= getTemplateValues("MBE"); 
	if(templateValues!=null && templateValues.size()>0) {  		 %>
<td width="25%"  class="label">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>

 <%		for( int i=0 ; i< templateValues.size(); i++ ) { 
			 record = (String[])templateValues.get(i);  
%>
			<tr><td class="label"><A href="javascript:setPrevTemplate('<%=record[1]%>')" class="gridLink"><%=record[0]%></a></td></tr>
  
 <%  } %>
<%  } %>
</table>
</td>
<%
	// Nullifying the objects
	if(templateValues!=null) {
		templateValues.clear();	
		templateValues		= null;
	}
%>
</form>
</body>

</html>
<%!
	public ArrayList getTemplateValues(String field_mnemonic_type) throws Exception {
		Connection connection 				= null;
		PreparedStatement pstmt 			= null;
		ResultSet resultSet 				= null;
		ArrayList TemplateValues			= new ArrayList() ;

		try {
				connection	= ConnectionManager.getConnection();
				pstmt		= connection.prepareStatement("SELECT field_mnemonic_desc,field_mnemonic,field_mnemonic_type,field_mnemonic_data_type,field_mnemonic_query FROM CA_mnemonic WHERE eff_Status = 'E' and field_mnemonic_type = ? ORDER BY srl_no") ;
				pstmt.setString(1, field_mnemonic_type);
 				resultSet = pstmt.executeQuery() ;
				String[] record =	null;
				while ( resultSet != null && resultSet.next() ) {
					record = new String[5];
	
 					record[0] = resultSet.getString( "field_mnemonic_desc" )  ;
					record[1] = resultSet.getString( "field_mnemonic" )  ;
					record[2] = resultSet.getString( "field_mnemonic_type" )  ;
					record[3] = resultSet.getString( "field_mnemonic_data_type" )  ;
					record[4] = resultSet.getString( "field_mnemonic_query" )  ;
					//if(!(record[1].toString()).equals("PATIENT_ID"))//IN052646
	 					TemplateValues.add(record) ;
			}
		} catch ( Exception e )	{
			
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet!=null) resultSet.close() ;
			if(pstmt!=null) pstmt.close() ;
			if(connection!=null) connection.close() ;
		}
		return TemplateValues;
	}
%>

