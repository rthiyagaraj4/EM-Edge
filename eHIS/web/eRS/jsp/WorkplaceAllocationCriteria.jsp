<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" 	src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/WorkplaceAllocation.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
Connection Con			= null;
PreparedStatement pstmt_fac = null;
PreparedStatement pstmt_loc = null;
ResultSet rs_fac		= null;
ResultSet rs_loc    	= null;
	String locn_type	="";
	String locn_desc	="";
	String facility_name	="";
	String facility_id	="";
	String sql_fac="";
	String sql_loc="";

try{
	Con=ConnectionManager.getConnection(request);
%>

<form name='formWorkplaceAllocCriteria' id='formWorkplaceAllocCriteria' method='post' target="messageFrame">
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>

<tr>
	<td width="30%"  align=right class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td>&nbsp;<SELECT name="facility" id="facility" onChange="resetVal()" >
		<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
		<%
			sql_fac="Select facility_name, facility_id from sm_facility_param order by facility_name";
			pstmt_fac=Con.prepareStatement(sql_fac);
			rs_fac = pstmt_fac.executeQuery();
			
			while(rs_fac.next()){
				facility_name=rs_fac.getString("facility_name");
				facility_id=rs_fac.getString("facility_id");
				out.println("<option value="+facility_id+'>'+facility_name+"</option>");
			}
		%>
		</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
</tr>

<tr>
	<td width="20%"  align=right class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
	<td>&nbsp;<SELECT name="locn_type" id="locn_type">
		<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
		<%
			//sql_loc="SELECT short_desc, locn_type FROM am_Care_locn_type ORDER BY short_desc";
			sql_loc="SELECT short_desc, locn_type FROM am_Care_locn_type_lang_vw where language_id = ? ORDER BY short_desc";
			pstmt_loc=Con.prepareStatement(sql_loc);
			pstmt_loc.setString(1,locale);
			rs_loc = pstmt_loc.executeQuery();

			while(rs_loc.next()){
				locn_type=rs_loc.getString("locn_type");
				locn_desc=rs_loc.getString("short_desc");
				out.println("<option value="+locn_type+'>'+locn_desc+"</option>");
			}
		%>
	</SELECT></td>
</tr>

<tr>
	<td width="20%"  align=right class="label"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
	<td>&nbsp;<input type=text name="work_text" id="work_text" value="" readonly size="25" onBlur=''><input class='button' type=button name="wrklookup_button" id="wrklookup_button" value="?"  onClick='viewWorkPlace(work_text)'>
	<input type="hidden" name="wrk_code" id="wrk_code" value="" ></td>

</tr>
<tr>
	<td width="20%"  align=right class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;</td>
	<td>&nbsp;<SELECT name="group_by" id="group_by" onChange="clearList( ),populateViewOption()">
		<option value="W"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></option>
		<option value="P"><fmt:message key="Common.Position.label" bundle="${common_labels}"/></option>
	</SELECT></td>
</tr>

<tr>
	<td width="15%"  align=right class="label" size=20><fmt:message key="eRS.ViewOptions.label" bundle="${rs_labels}"/>&nbsp;</td>
	<td>&nbsp;<SELECT name="view_opt" id="view_opt">
	<option value="">&nbsp;&nbsp;---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------&nbsp;&nbsp;</option>
	
	<option value="PD"><fmt:message key="Common.Position.label" bundle="${common_labels}"/>,<fmt:message key="Common.day.label" bundle="${common_labels}"/></option>
	<option value="SD"><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/>,<fmt:message key="Common.day.label" bundle="${common_labels}"/></option>
	<option value="SPD"><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/>,<fmt:message key="Common.Position.label" bundle="${common_labels}"/>,<fmt:message key="Common.day.label" bundle="${common_labels}"/></option>
	<option value="PSD"><fmt:message key="Common.Position.label" bundle="${common_labels}"/>,<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/>,<fmt:message key="Common.day.label" bundle="${common_labels}"/></option>
	</SELECT></td>
</tr>

<tr>
	<td width="25%"  align=right class="label"><fmt:message key="Common.duration.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class="label" align='left' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type=text name="frm_dt" id="frm_dt" value="" size="9" maxlength='10'  onBlur="CheckDate(this),checkDateRange1(this,'formWorkplaceAllocCriteria')" onKeyPress='return AllowDateFormat()'><img name="cal" src="../../eCommon/images/CommonCalendar.gif"
	onclick="return showCal(frm_dt,'frm_dt',null,null);" onBlur="CheckDate(this),checkDateRange1(this,'formWorkplaceAllocCriteria')" >&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;<class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type=text name="to_dt" id="to_dt" value="" size="9" maxlength='10'  onBlur="CheckDate(this),checkDateRange(this,'formWorkplaceAllocCriteria')" onKeyPress='return AllowDateFormat()'><img name="cal1" src="../../eCommon/images/CommonCalendar.gif"
	onclick="return showCal(to_dt,'to_dt',null,null);" onBlur="CheckDate(this),checkDateRange(this,'formWorkplaceAllocCriteria')" >&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;
	<input class='button' type=button name="search_button" id="search_button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' align='right' onClick='SearchDetails()'>
	</td>
</tr>
</table>
 <input type="hidden" name="locale" id="locale" value="<%=locale%>"> 
</form>

<%}catch(Exception e){
			out.println("Exception in try of WorkplaceAllocationCriteria.jsp : "+e);
		}finally {
			if (pstmt_fac != null) pstmt_fac.close();
			if (rs_fac != null) rs_fac.close();
			if (pstmt_loc != null) pstmt_loc.close();
			if (rs_loc != null) rs_loc.close();
			if(Con!=null) ConnectionManager.returnConnection(Con,request);
		}
	%>
</body>
</html>

