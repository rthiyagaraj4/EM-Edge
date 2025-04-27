<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<%
String mode = request.getParameter("mode")==null ? "1":request.getParameter("mode");
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/MstCodeCommon.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
<script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/ShiftForWorkplace.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	PreparedStatement pstmt=null;
	ResultSet rs_locn=null;
	ResultSet rs_shift = null;
	Connection conn = null;
	try{

		conn = ConnectionManager.getConnection(request);

		Vector locn_list = new Vector();
		Vector shift_list = new Vector();

		//String qry_locn = "Select locn_type, short_desc locn_desc from am_care_locn_type order by short_desc";
		String qry_locn = "Select locn_type, short_desc locn_desc from am_care_locn_type_lang_vw where language_id = ? order by short_desc";




		//String qry_shift = "Select shift_code, short_desc shift_desc from am_shift where eff_status = 'E' order by shift_desc";
		String qry_shift = "Select shift_code, short_desc shift_desc from am_shift_lang_vw where eff_status = 'E' and language_id = ? order by shift_desc";

		pstmt = conn.prepareStatement(qry_locn);
		pstmt.setString(1,locale);
		rs_locn = pstmt.executeQuery();
		while(rs_locn.next()){
			locn_list.add(rs_locn.getString("locn_type"));
			locn_list.add(rs_locn.getString("locn_desc"));
		}
		if(pstmt != null)
			pstmt.close();
		if(rs_locn != null)
			rs_locn.close();
		pstmt = conn.prepareStatement(qry_shift);
		pstmt.setString(1,locale);
		rs_shift = pstmt.executeQuery();
		while(rs_shift.next()){
			shift_list.add(rs_shift.getString("shift_code"));
			shift_list.add(rs_shift.getString("shift_desc"));
		}

		if (pstmt != null) pstmt.close();
		if (rs_shift != null)   rs_shift.close();
%>
<form name='frm_by_shift' id='frm_by_shift'>	
	<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">			
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>			
			<tr>
				<td align="right" class="label" width="20%"><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="60%">&nbsp;&nbsp;&nbsp;<select name="shift_code" id="shift_code" onchange="selectShift()">
					<option value='' selected>&nbsp; ---  <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- &nbsp;</option>
				<%for(int i=0;i<shift_list.size();i+=2){%>
					<option value='<%= shift_list.get(i) %>'> <%= shift_list.get(i+1) %> </option>
				<%}%>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
				<td align=left width="20%"></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="20%"><fmt:message key="eRS.ShiftIndicator.label" bundle="${rs_labels}"/></td>
				<td align="left" class="label" width="60%">&nbsp;&nbsp;&nbsp;<input type=text name='shift_indicator' id='shift_indicator' readOnly value="">
				<label class='label' id='show_shift_radio'></label>	
				</td>
				<td align=left width="20%"></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="20%"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="60%">&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.WorkingDays.label" bundle="${rs_labels}"/> <input type=checkbox name='appl_for_working_days' id='appl_for_working_days' onclick="checkActiveApplicable(this)" disabled >&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.Non-WorkingDays.label" bundle="${rs_labels}"/> <input type=checkbox name='appl_for_nonworking_days' id='appl_for_nonworking_days'
				 onclick="checkActiveApplicable(this)" disabled>&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.Holidays.label" bundle="${rs_labels}"/> <input type=checkbox name='appl_for_holidays' id='appl_for_holidays' onclick="checkActiveApplicable(this)" disabled>&nbsp;&nbsp;&nbsp;
				</td>
				<td align=left width="20%"></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="20%"><fmt:message key="eRS.ShiftTiming.label" bundle="${rs_labels}"/></td>
				<td align="left" class="label" width="60%">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<input type=text size=4 name='shift_start_time' id='shift_start_time'  readonly value=''>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<input type=text size=4 name='shift_end_time' id='shift_end_time'  readonly value=''>
				</td>
				<td align=left width="20%"></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="20%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="60%">&nbsp;&nbsp;&nbsp;<select name="locn_type" id="locn_type" onchange="">
					<option value='' selected>&nbsp; --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- &nbsp;</option>
<%
				for(int i=0;i<locn_list.size();i+=2){
%>
					<option value='<%= locn_list.get(i) %>' ><%= locn_list.get(i+1) %> </option>
<%
				}
%>
				</select>
				</td>
				<td align=left width="20%"><input type=button class='button' name='show_facilities' id='show_facilities' value='<fmt:message key="eRS.ShowWorkplaces.label" bundle="${common_labels}"/>'onclick="showWorkplacesList()"></td>
			</tr>

	</table>
<%
	}catch(Exception e){
		out.println(e.getMessage());
		e.printStackTrace();
	}
	finally{
		 if (pstmt != null) pstmt.close();
		  if (rs_locn != null)   rs_locn.close();
		  if (rs_shift != null)   rs_shift.close();
		  ConnectionManager.returnConnection(conn,request);
	}
%>
<input type='hidden' name='mode' id='mode' value='<%= mode %>'>
<input type='hidden' name='shift_mnemonic' id='shift_mnemonic' value=''>
</form>
</body>
</html>

