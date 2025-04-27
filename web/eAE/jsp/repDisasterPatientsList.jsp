<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AE" ;
	String p_report_id		= "AEBDISPT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale						= (String)session.getAttribute("LOCALE");
    Connection con			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null ;
	String currdate			= "";
try {
		con = ConnectionManager.getConnection(request);
	      String sql = "Select  to_char(sysdate,'dd/mm/yyyy') sys_date from dual";
		  pstmt = con.prepareStatement(sql);
	      rs    = pstmt.executeQuery();
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	currdate = rs.getString("sys_date") ;
			  }
		  }		   	
    } catch(Exception e) {  e.printStackTrace();}
finally {
  if (pstmt != null) pstmt.close();
  if (rs    != null)    rs.close();
  ConnectionManager.returnConnection(con,request);
}
%>

<html>

<HEAD><TITLE></TITLE>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eAE/js/DisasterPatientsList.js" language="JavaScript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



 </HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name="repDisasterPatList" id="repDisasterPatList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
	<td width="80%" class="Border" align='center'>
	<table border='0' width='80%' cellPadding="0" cellSpacing="0" align='center'>
	<tr><td class='label' height='5'></td></tr>
	<tr>
	  
			<td  class='label' width="50%"><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
			<td width="50%"><input type=text id='dlyregs' name='p_registration_date' id='p_registration_date' size="10" maxlength="10" onBlur="validDateObj(this,'DMY','<%=localeName%>')" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dlyregs');" style='cursor:pointer'></img>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
	</tr>
	<tr>
			<td  class='label' width="50%"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
			<td width="50%">
			<input name='p_locn_code' id='p_locn_code' value='' size='5' maxlength='4'>
			<input type='button' name='clinic' id='clinic' value='?' class='button' onclick='searchCode1(this,p_locn_code)'>
		</td>
	</tr>
	<tr>
			<td colspan=2 height='5'></td>
			<td></td>
	</tr>
	</table>
  </td>
</tr>
</table>

<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_curr_date" id="p_curr_date"			value="<%= currdate%>">
<input type="hidden" name="locale" id="locale"			value="<%= locale %>">
</form>
<script>document.forms[0].p_registration_date.focus();</script>
</body>
</html>

