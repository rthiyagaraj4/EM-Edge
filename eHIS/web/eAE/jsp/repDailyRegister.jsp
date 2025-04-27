<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
   request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AE" ;
	String p_report_id		= "AEBDLREG" ;
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
    
	 if (rs    != null)    rs.close();
	 if (pstmt != null) pstmt.close();

	} catch(Exception e) {e.printStackTrace();}
finally {
  if(con!=null) 
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
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
        <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>


<script src="../../eAE/js/AERepDailyRegister.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>


<form name="repDailyRegister" id="repDailyRegister" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' border='0'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="80%" class="Border" align='center' >

				<table width='80%' cellPadding="2" cellSpacing="0" align='center' border=0>
					
					<!--Commented by Ashwini on 26-Jun-2019 for ML-MMOH-CRF-1413-->
					<!--<tr>
						<td  class='label' width="25%"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
						<td width="25%"><input type=text id='dlyregs' name='p_visit_date' id='p_visit_date' size="10" maxlength="10" onBlur="validDateObj(this,'DMY','<%=localeName%>')" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dlyregs');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td width="25%"></td><td width="25%"></td>
    				</tr>-->
					<tr>
						<td width="25%"></td>
						<td class="querydata" width="205"><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td> 
						<td class="querydata" width="25%"><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
						<td width="25%"></td>
					</tr>

					<!--Added by Ashwini on 26-Jun-2019 for ML-MMOH-CRF-1413-->
					<tr>
						<td  class='label' width="25%"><fmt:message key="Common.Visit.label" bundle="${common_labels}"/><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></td>
						<td width="25%">
						<input type=text name='p_fm_visit_date' id='p_fm_visit_date' size="16" maxlength="16" onBlur="validDateObj(this,'DMYHM','<%=localeName%>')"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_visit_date','dd/mm/yyyy','hh:mm',null);" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img> 
						</td>
						<td width="25%">
						<input type=text name='p_to_visit_date' id='p_to_visit_date' size="16" maxlength="16" onBlur="validDateObj(this,'DMYHM','<%=localeName%>')"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_visit_date','dd/mm/yyyy','hh:mm',null );" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img> 
						</td>
					</tr>

					<tr>
						<td  class='label' width="25%"><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td>
						<td width="25%"><input type=text  name='p_fm_patient_type' id='p_fm_patient_type' size="4" maxlength="4" onBlur='ChangeUpperCase(this);validSplchars(this,"Patient Type")' onKeyPress='return(CheckForSpecChars(event))'><input type='button' name='patient type' id='patient type' value='?' class='button' tabindex=-1 onclick='searchCode(this, p_fm_patient_type)'>
						</td>
						<td width="25%"><input type=text  name='p_to_patient_type' id='p_to_patient_type' size="4" maxlength="4" onBlur='ChangeUpperCase(this);validSplchars(this,"Patient Type")' onKeyPress='return(CheckForSpecChars(event))'><input type='button' tabindex=-1 name='patient type' id='patient type' value='?' class='button' onclick='searchCode(this, p_to_patient_type)'>
						</td>
						<td width="25%"></td>
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
<input type="hidden" name="locale" id="locale"			    value="<%= locale%>">
</form>
<!-- <script>document.forms[0].p_visit_date.focus();</script> -->
</body>
</html>

