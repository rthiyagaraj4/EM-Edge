<!DOCTYPE html>
<%
/*
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ShiftPatternForWorkplace.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	16-11-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eRS/js/ShiftPatternForWorkplace.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
    Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;

	String mode	   = request.getParameter("mode")==null?"":request.getParameter("mode");
	String facility_id = (String)session.getAttribute("facility_id");
	String facility_name = (String)session.getAttribute("facility_name")==null?"":request.getParameter("facility_name");
	
	ArrayList Locn_Data		= new ArrayList();
	String[] record				= null;
	String work_cycle="";
	String week_basis="";
	int week_count=0;
	char ch = ' ';
	//String sql_locn="Select locn_type, short_desc from am_care_locn_type order by short_desc";
	String sql_locn="Select locn_type, short_desc from am_care_locn_type_lang_vw where language_id = ? order by short_desc";
	String sql_work_cycle="select facility_id,work_cycle_basis from rs_parameter where facility_id in   (select facility_id from rs_parameter where facility_id = ?  union select facility_id from rs_parameter   where facility_id = '*A' and not exists (select facility_id from rs_parameter where facility_id = ?))";

	conn = ConnectionManager.getConnection(request);
	try {
		//to get the locantion type
		pstmt = conn.prepareStatement( sql_locn);
		pstmt.setString(1,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("locn_type");
			record[1] = resultSet.getString("short_desc");
			Locn_Data.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		//to get work_cycle_basis
		pstmt = conn.prepareStatement( sql_work_cycle);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,facility_id);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			work_cycle=resultSet.getString("work_cycle_basis");
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();

		if(work_cycle.length() > 1)
		{
		week_count = Integer.parseInt(work_cycle.substring(0,1));
		 ch = work_cycle.charAt(1);
		}
		
		if(ch == 'M'){
			week_count = 5;
			week_basis = "Monthly";
		}
		else{
			week_basis = String.valueOf(week_count) + " Weekly";
		}
%>
		<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name=form_byWorkplace>
			<table border='0' cellpadding='0' cellspacing='0' align='left' width="100%">
				<tr>
					<td class='label' width='40%' align='right'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<td width='60%' align='left'>&nbsp;&nbsp;&nbsp;<select name='locn_type' id='locn_type' onchange='locn_change(form_name);'>
						<option value='' selected>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------- </option>
<%
						for(int i=0; i<Locn_Data.size();i++){
							record=(String[])Locn_Data.get(i);
%>
							<option value=<%=record[0]%>><%=record[1]%></option>
<%
						}
%>					
					</select></td>
			</tr>
			<tr><td colspan='2'>&nbsp;</td></tr>
			<tr>
				<td class='label' width='40%' align='right'><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></td>
				<td width='60%' align='left'>&nbsp;&nbsp;&nbsp;<input name='workplace_desc' id='workplace_desc' size='35'  type='text'  maxlength='30'><input class='button' type='button' name='wrklookup_button' id='wrklookup_button' value='?' Onclick='showWrkplace("B",workplace_desc);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				<input type='hidden' name='workplace_code' id='workplace_code' value=''>
				</td></tr>
			<tr><td colspan=2>&nbsp;</td></tr>
			<tr>
				<td class='label' width='40%' align='right'><fmt:message key="eRS.WorkCycle.label" bundle="${rs_labels}"/></td>
				<td class='label' width='60%' align='left'>&nbsp;&nbsp;&nbsp;<b><%=week_basis%>			</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type='button' class='button' name='listshiftpattern' id='listshiftpattern' value='<fmt:message key="eRS.ShowShiftPattern.label" bundle="${rs_labels}"/>'onclick='listShiftPattern(<%=week_count%>);'></td>
			</tr>
		</table>
		<input type='hidden' name='mode' id='mode'  value='<%=mode%>'>
		<input type='hidden' name='facility_id' id='facility_id'  value='<%=facility_id%>'>
		<input type='hidden' name='facility_name' id='facility_name'  value='<%=facility_name%>'>
		<input type='hidden' name='form_name' id='form_name' value='form_byWorkplace'>
		<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
	</form>
	</body>
<%
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>
</html>

