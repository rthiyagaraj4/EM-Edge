<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AE" ;
	String p_report_id		= "AEBDTREG" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
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
    } catch(Exception e) {e.printStackTrace();}
finally {
  if (pstmt != null) pstmt.close();
  if (rs    != null)    rs.close();
  ConnectionManager.returnConnection(con,request);
}
%>

<html>

<HEAD>
<TITLE></TITLE>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<br>
<br>
<form name="RepDeathRegister" id="RepDeathRegister" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>					
		<td width="80%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0" align='center'>
					<tr>
						<td align="center" class='label' width="35%" >&nbsp;</td>
						<td  width="20%" class='label' align="left"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class='label' width="30%" align="left"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td align="right" class='label' ><fmt:message key="Common.DeceasedDate.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width="20%"><input type=text id='deathregsfrom' name='p_fm_deceased_date' id='p_fm_deceased_date' size="10" maxlength="10" onBlur="CheckDate(this)" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('deathregsfrom');" style='cursor:pointer'></img>
						</td>
						<td width="20%"><input type=text id='deathregsto' name='p_to_deceased_date' id='p_to_deceased_date' size="10" maxlength="10" onBlur="CheckDate(this)" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('deathregsto');" style='cursor:pointer'></img>
						</td>
				</tr>
                <tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
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
</form>
<script>document.forms[0].p_fm_deceased_date.focus();</script>
</body>
</html>

