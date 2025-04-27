<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eFM/js/QueryEncounterWiseDoc.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
		
		Connection con	= ConnectionManager.getConnection(request);
		Statement stmt =	null;
		ResultSet rset =	null;
		stmt	=	con.createStatement();
		int patient_id_max_length = 0;
		try{
		rset	=	stmt.executeQuery("SELECT patient_id_length FROM mp_param ");
		if((rset != null) && (rset.next()))
		{
			patient_id_max_length	=	rset.getInt("patient_id_length");			
		}
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			}
		finally
		{			
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
%>
<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>
<form name='encounterDocsCriteria' id='encounterDocsCriteria'>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
<td colspan=4 class=label>&nbsp;</td>
</tr>
<tr>
<td  class='label' width="15%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<td  class='fields' width="25%"><input type='text' name='patient_id' id='patient_id' value='' onKeyPress='return CheckForSpecChars(event)' maxlength="<%=patient_id_max_length%>" size="<%=patient_id_max_length+2%>" onBlur='ChangeUpperCase(this);'><input type='button' class='button' name='pat_search' id='pat_search' value='?' align=center onClick='callPatientSearch();'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
<td class='label'  width="14%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
<td class='fields' width='20%' ><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);"><input type="button" name='encounter_id_search' id='encounter_id_search' value="?" class="button" onclick="callSearchScreen('E');">&nbsp;<!-- <img src='../../eCommon/images/mandatory.gif' align='center'></img> --></td>
</tr>
<tr>
<td colspan=4 class='button'><input type='button' class='button' name='search_button' id='search_button'   value='Search' onClick='searchData();'></td>
</tr>
</table>

<input type='hidden' name='file_no' id='file_no' value=''>
<input type='hidden' name='volume_no' id='volume_no' value=''>
</form>
</body>
</html>

