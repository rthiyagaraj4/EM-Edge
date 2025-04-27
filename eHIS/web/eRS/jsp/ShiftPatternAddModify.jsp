<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../js/RSMessages.js"></script>
<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/ShiftPattern.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String mode	       = request.getParameter("mode") ;
	String function_id = request.getParameter( "function_id") ;
	String facility_id = (String)session.getAttribute("facility_id");
	//System.err.println("facility_id----->"+facility_id);
	Connection conn 		= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet 	= null;

	ArrayList Locn_Data		= new ArrayList() ;
	ArrayList Shift_Data	= new ArrayList() ;
	ArrayList Week_Days		= new ArrayList();

	String[] record				= null;
	String locn_id	="";
	String locn_shortdesc="";
	String work_cycle="";
	String week_basis="";
	int week_count=0;
	char ch=' ';

	//String sql_locn="select locn_type, short_desc from am_care_locn_type order by short_desc";
	String sql_locn="select locn_type, short_desc from am_care_locn_type_lang_vw where language_id = ? order by short_desc";

	//String sql_shift="select shift_code, short_desc, mnemonic_key from am_shift where eff_status ='E' and shift_indicator in ('P','U')";
	String sql_shift="select shift_code, short_desc, mnemonic_key from am_shift_lang_vw where eff_status ='E' and shift_indicator in ('P','U') and language_id = ?";

	String sql_work_cycle="select facility_id,work_cycle_basis from rs_parameter where facility_id in   (select facility_id from rs_parameter where facility_id = ?  union select facility_id from rs_parameter   where facility_id = '*A' and not exists (select facility_id from rs_parameter where facility_id = ?))";
	String sql_week_days="Select day_no, initcap (substr( day_of_week,1,3) ) day_of_week from sm_day_of_week order by day_no";

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
		if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;

		//to get the shift_code & desc
		pstmt = conn.prepareStatement( sql_shift);
		pstmt.setString(1,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[3];				
			record[0] = resultSet.getString("shift_code");
			record[1] = resultSet.getString("short_desc");
			record[2] = resultSet.getString("mnemonic_key");
			Shift_Data.add(record) ;
		}
		if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;

		//to get work_cycle_basis
		pstmt = conn.prepareStatement( sql_work_cycle);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,facility_id);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			work_cycle=resultSet.getString("work_cycle_basis");
			//System.err.println("work_cycle---------line 81--->"+work_cycle);
		}
        if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;

		//to get the week days legend
		pstmt = conn.prepareStatement( sql_week_days);
		resultSet = pstmt.executeQuery();
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("day_no");
			record[1] = resultSet.getString("day_of_week");
			Week_Days.add(record);
		}
		if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;
	
		int total_locns=Locn_Data.size();
		week_count = Integer.parseInt(work_cycle.substring(0,1));
		ch = work_cycle.charAt(1);

		if(ch == 'M')
		{
			week_count = 5;
			week_basis = "Monthly";
		}
		else
		{
			week_basis = String.valueOf(week_count) + " Weekly";
		}
%>

<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=form_add_mod action='../../servlet/eRS.ShiftPatternServlet' method='POST'
target='messageFrame'>

<% if (mode.equals("1")){%>

	<table width='100%' cellspacing='0' cellpadding='0' border='0'>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="eRS.ShiftPatternID.label" bundle="${rs_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='15' maxlength='10' value='' name='shift_pattern_id' id='shift_pattern_id' onKeyPress="return CheckForSpecChars(event);" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='20' maxlength='15' value='' name='shift_short_desc' id='shift_short_desc'onKeyPress="return CheckForSpecCharsAllCase(event);" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='40' maxlength='30' value='' name='shift_long_desc' id='shift_long_desc' onKeyPress="return CheckForSpecCharsAllCase(event);">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<select name="locn_type" id="locn_type">
					<option value='' selected>-------- <fmt:message key="Common.all.label" bundle="${common_labels}"/> ------- </option>
					<%
						for(int i=0; i<total_locns;i++){
							record=(String[])Locn_Data.get(i);
							locn_id=record[0];
							locn_shortdesc=record[1];%>
						<option value=<%=locn_id%>><%=locn_shortdesc%></option>
					<%}%>					
				</select></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;<input type='checkbox' value='N' name='eff_status' id='eff_status' onclick='onenable(this);'></td>
		</tr>	
		<tr><td colspan=2><hr></td></tr>
		<tr>
			<td class='label' width='30%'><b><fmt:message key="eRS.WorkCycleBasis.label" bundle="${rs_labels}"/>:</b></td>
			<td class='label' width='70%' align='left'>&nbsp;&nbsp;&nbsp;<%=week_basis%></td>
		</tr>
		</table>
		<table width='100%' cellspacing='0' cellpadding='0' border='0'>
		<%
			for(int i=0;i<Shift_Data.size();i++){
			record=(String[]) Shift_Data.get(i); %>			
				<input type='hidden' name='shift_id<%=i%>' id='shift_id<%=i%>' value='<%=record[0]%>'>
				<input type='hidden' name='shift_desc<%=i%>' id='shift_desc<%=i%>' value='<%=record[1]%>'>
				<input type='hidden' name='mnemonic_key<%=i%>' id='mnemonic_key<%=i%>' value='<%=record[2]%>'>
		<%}%>
		</table>

	<table width='100%' cellspacing='0' cellpadding='0' align='center' border='0'>	
		<input type='hidden' name='week_count' id='week_count' value='<%=week_count%>'>
		<input type='hidden' name='day_count' id='day_count' value='<%=Week_Days.size()%>'>
		<tr><td colspan=10>&nbsp;</td></tr>
		<tr><td width='20%'>&nbsp;</td><td width='11%'>&nbsp;&nbsp;&nbsp;</td>

			<%for(int i=0; i<Week_Days.size();i++){
			record=(String[])Week_Days.get(i);%>
			<td class='label' width='7%'><b>&nbsp;<%=record[1]%></b></td><%}%>			
			<td width='24%'>&nbsp;</td>
			</tr>
				
			<%for(int i=0; i<week_count;i++){%>
				<tr><td width='22%'>&nbsp;</td><td class='label' width='7%'><b><fmt:message key="Common.Week.label" bundle="${common_labels}"/><%=i+1%></b> </td>
				<%for(int j=0; j<Week_Days.size();j++){
				record=(String[])Week_Days.get(j);%>
					<td width='7%'><input type='text' name='shift_mnemonic<%=i%><%=j%>' id='shift_mnemonic<%=i%><%=j%>' size='2' maxlength='1' value='' onkeypress='return check(<%=Shift_Data.size()%>,<%=i%>,<%=j%>);' onblur=' check1(this,<%=Shift_Data.size()%>,<%=i%>,<%=j%>);'>
					<input type='hidden' name='shift_code<%=i%><%=j%>' id='shift_code<%=i%><%=j%>' value=''>
					<input type='hidden' name='day_no<%=i%><%=j%>' id='day_no<%=i%><%=j%>' value='<%=record[0]%>'></td>
			<%}%><td width='24%'>&nbsp;</td><%}%>
			</tr>

			<tr><td colspan=10>&nbsp;</td></tr>
		<%}

	/**********************************************************************/
		else{
			String shift_pattern_id="";
			String long_desc="";
			String short_desc="";
			String locn_type="";
			String eff_status="";
			String enable="";
			String disable="";
			String readonly="";
			ArrayList Shift_Details=new ArrayList();
			String sql_shiftdata="select week_no, day_no, shift_code,shift_mnemonic from rs_shift_pattern_dtl where facility_id=? and shift_pattern_id=?";

			shift_pattern_id=((request.getParameter("shift_pattern_id")==null) ? "":request.getParameter("shift_pattern_id").trim());
			long_desc=((request.getParameter("long_desc")==null) ? "":request.getParameter("long_desc").trim());
			
			
			short_desc=((request.getParameter("short_desc")==null) ? "":request.getParameter("short_desc").trim());
			locn_type=((request.getParameter("locn_type")==null) ? "":request.getParameter("locn_type").trim());
			eff_status=((request.getParameter("eff_status")==null) ? "":request.getParameter("eff_status").trim());
			if(eff_status.equalsIgnoreCase("E"))
				enable = "checked";
			else{
				enable = "";
				disable="disabled";
				readonly="readonly";
			}
			pstmt = conn.prepareStatement( sql_shiftdata);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,shift_pattern_id);
			resultSet = pstmt.executeQuery() ;

			while (resultSet != null && resultSet.next()) {
				record = new String[4];				
				record[0] = resultSet.getString("week_no");
				record[1] = resultSet.getString("day_no");
				record[2] = resultSet.getString("shift_code");
				record[3] = resultSet.getString("shift_mnemonic");
				Shift_Details.add(record) ;
			}
		%>

		<table width='100%' cellspacing='0' cellpadding='0' border='0'>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="eRS.ShiftPatternID.label" bundle="${rs_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='15' maxlength='10' value='<%=shift_pattern_id%>' name='shift_pattern_id' readonly >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>

		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='20' maxlength='15' value='<%=short_desc%>'onKeyPress="return CheckForSpecCharsAllCase(event);" name='shift_short_desc' <%=readonly%>>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>

		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			
			<td class='label' width='30%' align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='40' maxlength='30' value="<%=long_desc%>" <%=readonly%> onKeyPress="return CheckForSpecCharsAllCase(event);" name='shift_long_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>

		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<select name="locn_type" id="locn_type" <%=disable%>>
				<option value="">-----<fmt:message key="Common.all.label" bundle="${common_labels}"/>-----</option>
					<%
						for(int i=0; i<total_locns;i++){
							record=(String[])Locn_Data.get(i);
							locn_id=record[0];
							locn_shortdesc=record[1];
							if(locn_id.equalsIgnoreCase(locn_type)){ %>
						<option value='<%=locn_id %>' selected><%=locn_shortdesc%></option>
							<%}else%>
						<option value=<%=locn_id%>><%=locn_shortdesc%></option>
					<%}%>					
				</select></td>
		</tr>

		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;<input type='checkbox' value='<%=eff_status%>' name='eff_status' <%=enable%> onclick='onenable(this);'>
			<input type=hidden value='<%=eff_status%>' name='eff_status1' ></td>
		</tr>	
		<tr><td colspan=2><hr></td></tr>
		<tr>
			<td class='label' width='30%'><b><fmt:message key="eRS.WorkCycleBasis.label" bundle="${rs_labels}"/>:</b></td>
			<td class='label' width='70%' align='left'><%=week_basis%></td>
		</tr>

		<tr><td colspan=2><b><fmt:message key="eRS.Shifts.label" bundle="${rs_labels}"/></b></td></tr>
		</table>

		<table width='100%' cellspacing='0' cellpadding='0' border='0'>
		<%
			for(int i=0;i<Shift_Data.size();i++){
			record=(String[]) Shift_Data.get(i);%>			
				<input type='hidden' name='shift_id<%=i%>' id='shift_id<%=i%>' value='<%=record[0]%>'>
				<input type='hidden' name='shift_desc<%=i%>' id='shift_desc<%=i%>' value='<%=record[1]%>'>
				<input type='hidden' name='mnemonic_key<%=i%>' id='mnemonic_key<%=i%>' value='<%=record[2]%>'>
		<%}%>
		</table>

		<table width='100%' cellspacing='0' cellpadding='0' align='center' border='0'>	
			<tr><td colspan=10>&nbsp;</td></tr>
			<input type='hidden' name='week_count' id='week_count' value='<%=week_count%>'>
			<input type='hidden' name='day_count' id='day_count' value='<%=Week_Days.size()%>'>
			<tr><td width='22%'>&nbsp;</td><td width='11%'>&nbsp;</td>

				<%int l=0;
				String[] record1=null;
				if(!Shift_Details.isEmpty()){
					record1=(String[])Shift_Details.get(l++);
				for(int i=0; i<Week_Days.size();i++){
				record=(String[])Week_Days.get(i);%>
				<td class='label' width='7%'><b>&nbsp;<%=record[1]%></b></td><%}%>			<td width='24%'>&nbsp;</td></tr>	
					
			<%for(int i=0; i<week_count;i++){%>
				<tr><td width='20%'>&nbsp;</td><td class='label' width='7%'><b><fmt:message key="Common.Week.label" bundle="${common_labels}"/><%=i+1%></b> </td>

				<%for(int j=0; j<Week_Days.size();j++){
				record=(String[])Week_Days.get(j);

				if((Integer.parseInt(record1[0])==(i+1))&&(Integer.parseInt(record1[1])==(j+1))){%>

					<td width='7%'><input type='text' name='shift_mnemonic<%=i%><%=j%>' id='shift_mnemonic<%=i%><%=j%>' size='2' maxlength='1' value='<%=record1[3]%>' <%=readonly%>  onkeypress='return check(<%=Shift_Data.size()%>,<%=i%>,<%=j%>);' onblur=' check1(this,<%=Shift_Data.size()%>,<%=i%>,<%=j%>);'>
					<input type='hidden' name='shift_code<%=i%><%=j%>' id='shift_code<%=i%><%=j%>' value='<%=record1[2]%>'>
					<input type='hidden' name='update<%=i%><%=j%>' id='update<%=i%><%=j%>' value='U'>
					<input type='hidden' name='day_no<%=i%><%=j%>' id='day_no<%=i%><%=j%>' value='<%=record[0]%>'></td>

				<%if(l<Shift_Details.size())
					record1=(String[])Shift_Details.get(l++);
					}else{%>

					<td width='7%'><input type='text' name='shift_mnemonic<%=i%><%=j%>' id='shift_mnemonic<%=i%><%=j%>' size='2' maxlength='1' value='' <%=readonly%>  onkeypress='return check(<%=Shift_Data.size()%>,<%=i%>,<%=j%>);' onblur=' check1(this,<%=Shift_Data.size()%>,<%=i%>,<%=j%>);'>
					<input type='hidden' name='shift_code<%=i%><%=j%>' id='shift_code<%=i%><%=j%>' value=''>
					<input type='hidden' name='update<%=i%><%=j%>' id='update<%=i%><%=j%>' value='I'>
					<input type='hidden' name='day_no<%=i%><%=j%>' id='day_no<%=i%><%=j%>' value='<%=record[0]%>'></td>

			<%}}%><td width='24%'>&nbsp;</td>
			<%}}else{

				for(int i=0; i<Week_Days.size();i++){
				record=(String[])Week_Days.get(i);%>

				<td class='label' width='7%'><b>&nbsp;<%=record[1]%></b></td><%}%>			<td width='24%'>&nbsp;</td></tr>			
			<%for(int i=0; i<week_count;i++){%>
				<tr><td width='20%'>&nbsp;</td><td class='label' width='7%'><b><fmt:message key="Common.Week.label" bundle="${common_labels}"/><%=i+1%></b> </td>

				<%for(int j=0; j<Week_Days.size();j++){
				record=(String[])Week_Days.get(j);%>

					<td width='7%'><input type='text' name='shift_mnemonic<%=i%><%=j%>' id='shift_mnemonic<%=i%><%=j%>' size='2' maxlength='1' value='' <%=readonly%>  onkeypress='return check(<%=Shift_Data.size()%>,<%=i%>,<%=j%>);' onblur=' check1(this,<%=Shift_Data.size()%>,<%=i%>,<%=j%>);'>
					<input type='hidden' name='shift_code<%=i%><%=j%>' id='shift_code<%=i%><%=j%>' value=''>
					<input type='hidden' name='update<%=i%><%=j%>' id='update<%=i%><%=j%>' value='I'>
					<input type='hidden' name='day_no<%=i%><%=j%>' id='day_no<%=i%><%=j%>' value='<%=record[0]%>'></td>

			<%}%><td width='24%'>&nbsp;</td><%}}%>
			</tr>
			<tr><td colspan=10>&nbsp;</td></tr>
	<%}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;
		ConnectionManager.returnConnection(conn,request);
	}
%>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
</form>
</body>
</html>

