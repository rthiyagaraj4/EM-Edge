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
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/ShiftForWorkplace.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode				 = request.getParameter("mode")==null ? "1":request.getParameter("mode");
	String facility			= request.getParameter("facility_id")==null ? "":request.getParameter("facility_id");
	String workplace_code = request.getParameter("workplace_code")==null?"": request.getParameter("workplace_code");
	String totalRecords = "";
	ArrayList Shift_Data = new ArrayList();
	String[] record=null;

	Connection conn 		= null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;
	
	//String qry_shift = "SELECT  a.shift_code,b.long_desc shift_desc, TO_CHAR(b.shift_start_time,'hh24:mi') start_time, TO_CHAR(b.shift_end_time,'hh24:mi') end_time, DECODE(b.shift_indicator,'P','Productive', 'U','Unproductive','L','Leave','A','Absence') shift_indicator, DECODE(b.productive_flag,'W','Working','O', 'On Call','T','Training') productive_flag, b.appl_for_working_days appl_for_working_days, b.appl_for_nonworking_days appl_for_nonworking_days, b.appl_for_holidays appl_for_holidays,b.mnemonic_key shift_mnemonic, 'U' db_action, a.eff_status enabled FROM  rs_shift_for_workplace a, am_shift b WHERE  facility_id = ? AND a.workplace_code = ? AND  a.shift_code = b.shift_code UNION ALL SELECT  shift_code,long_desc shift_desc, TO_CHAR(shift_start_time,'hh24:mi') start_time, TO_CHAR(shift_end_time,'hh24:mi') end_time, DECODE(shift_indicator,'P','Productive','U','Unproductive', 'L','Leave','A','Absence') shift_indicator, DECODE(productive_flag,'W','Working','O','On Call','T','Training') productive_flag, appl_for_working_days, appl_for_nonworking_days,appl_for_holidays, mnemonic_key, 'I' db_action, 'E' enabled FROM  am_shift WHERE  eff_status = 'E' AND  shift_code NOT IN ( SELECT shift_code FROM rs_shift_for_workplace WHERE facility_id = ? AND workplace_code = ?) ORDER BY shift_desc";
	String qry_shift = "SELECT  a.shift_code,b.long_desc shift_desc, TO_CHAR(b.shift_start_time,'hh24:mi') start_time, TO_CHAR(b.shift_end_time,'hh24:mi') end_time, DECODE(b.shift_indicator,'P','Productive', 'U','Unproductive','L','Leave','A','Absence') shift_indicator, DECODE(b.productive_flag,'W','Working','O', 'On Call','T','Training') productive_flag, b.appl_for_working_days appl_for_working_days, b.appl_for_nonworking_days appl_for_nonworking_days, b.appl_for_holidays appl_for_holidays,b.mnemonic_key shift_mnemonic, 'U' db_action, a.eff_status enabled FROM  rs_shift_for_workplace a, am_shift_lang_vw b WHERE  facility_id = ? AND a.workplace_code = ? AND  a.shift_code = b.shift_code and b.language_id = ? UNION ALL SELECT  shift_code,long_desc shift_desc, TO_CHAR(shift_start_time,'hh24:mi') start_time, TO_CHAR(shift_end_time,'hh24:mi') end_time, DECODE(shift_indicator,'P','Productive','U','Unproductive', 'L','Leave','A','Absence') shift_indicator, DECODE(productive_flag,'W','Working','O','On Call','T','Training') productive_flag, appl_for_working_days, appl_for_nonworking_days,appl_for_holidays, mnemonic_key, 'I' db_action, 'E' enabled FROM  am_shift_lang_vw WHERE  eff_status = 'E' AND  shift_code NOT IN ( SELECT shift_code FROM rs_shift_for_workplace WHERE facility_id = ? AND workplace_code = ?) and language_id = ? ORDER BY shift_desc";

	try{
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(qry_shift);
		
		pstmt.setString(1,facility);
		pstmt.setString(2,workplace_code);
		pstmt.setString(3,locale);
		pstmt.setString(4,facility);
		pstmt.setString(5,workplace_code);
		pstmt.setString(6,locale);
		
		resultSet = pstmt.executeQuery();
		while(resultSet.next())	{
			record=new String[12];
			record[0] = resultSet.getString("shift_code")==null ? "":resultSet.getString("shift_code");
			record[1] = resultSet.getString("shift_mnemonic")==null ? "":resultSet.getString("shift_mnemonic");
			record[2] = resultSet.getString("shift_desc")==null ? "":resultSet.getString("shift_desc");
			record[3] = resultSet.getString("start_time")==null ? "":resultSet.getString("start_time");
			record[4] = resultSet.getString("end_time")==null ? "":resultSet.getString("end_time");
			record[5] = resultSet.getString("shift_indicator")==null ? "":resultSet.getString("shift_indicator");
			record[6] = resultSet.getString("productive_flag")==null ? "":resultSet.getString("productive_flag");
			record[7] = resultSet.getString("appl_for_working_days")==null ? "":resultSet.getString("appl_for_working_days");
			record[8] = resultSet.getString("appl_for_nonworking_days")==null ? "":resultSet.getString("appl_for_nonworking_days");
			record[9] = resultSet.getString("appl_for_holidays")==null ? "":resultSet.getString("appl_for_holidays");
			record[10] = resultSet.getString("db_action")==null ? "":resultSet.getString("db_action");
			record[11]=resultSet.getString("enabled")==null ? "":resultSet.getString("enabled");
			Shift_Data.add(record);
		}
		totalRecords = String.valueOf(Shift_Data.size());
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name='frm_shift_list' id='frm_shift_list' action='../../servlet/eRS.ShiftForWorkplaceServlet' method='POST' target='messageFrame'>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
			<th rowspan="2"><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></th>
			<th rowspan="2"><fmt:message key="Common.from.label" bundle="${common_labels}"/></th>
			<th rowspan="2"><fmt:message key="Common.to.label" bundle="${common_labels}"/></th>
			<th rowspan="2"><fmt:message key="eRS.ShiftIndicator.label" bundle="${rs_labels}"/></th>
			<th rowspan="2"><fmt:message key="eRS.ProductiveFlag.label" bundle="${rs_labels}"/></th>
			<th colspan="3"><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></th>
			<th rowspan="2"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' onclick='click_selectall();'</th>
			</tr>
			<tr>
				<th><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></th>
				<th><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></th>
				<th><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></th>
			</tr>
<%
			String classValue = "" ;
			for(int i=0;i<Shift_Data.size();i++){
				String select = "";
				record=(String[])Shift_Data.get(i);
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				  else
					classValue = "QRYODD" ;
%>
				<tr>
				<td class='<%=classValue%>'>&nbsp;<%= record[2]%></td>
				<td class='<%=classValue%>'>&nbsp;<%= record[3]%></td>
				<td class='<%=classValue%>'>&nbsp;<%= record[4]%></td>
				<td class='<%=classValue%>'>&nbsp;<%= record[5]%></td>
				<td class='<%=classValue%>'>&nbsp;<%=record[6]%></td>
				<td class='<%=classValue%>' align='center'>
<%
				if(record[7].equalsIgnoreCase("Y")){
%>
					<img src='../../eCommon/images/enabled.gif'></img>
<%
				}
				else{
%>
					<img src='../../eCommon/images/RRnwd.gif'></img>
<%
				}
%>
				</td>
				<td class='<%=classValue%>' align='center'>
<%
				if(record[8].equalsIgnoreCase("Y")){
%>
					<img src='../../eCommon/images/enabled.gif'></img>
<%
				}
				else{
%>
					<img src='../../eCommon/images/RRnwd.gif'></img>
<%
				}
%>
			</td>
			<td class='<%=classValue%>' align='center'>
<%
			if(record[9].equalsIgnoreCase("Y")){
%>
				<img src='../../eCommon/images/enabled.gif'></img>
<%
			}
			else{
%>
				<img src='../../eCommon/images/RRnwd.gif'></img>
<%
			}
%>
			</td>
<%
			if((record[10].equalsIgnoreCase("U"))&&(record[11].equals("E")))
				select="checked";
			else
				select="";
%>
			<td class='<%=classValue%>' align='center'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='' <%=select%> onclick='click_select(this);'>
			</td>
			<input type='hidden' name='shift_code<%=i%>' id='shift_code<%=i%>' value='<%= record[0] %>'>
			<input type='hidden' name='shift_mnemonic<%=i%>' id='shift_mnemonic<%=i%>' value='<%=  record[1]%>'>
			<input type='hidden' name='db_action<%=i%>' id='db_action<%=i%>' value='<%=record[10]%>' ></td>
<%
		}
%>
</tr>
</table>
<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
<input type='hidden' name='totalRecords' id='totalRecords' value='<%=totalRecords%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility %>'>
<input type='hidden' name='formName' id='formName' value='frm_shift_list'>
<input type='hidden' name='mode' id='mode' value='<%=mode %>'>
</form>
</body>	
<%
	}catch(Exception e){
		out.println(e.getMessage());
		e.printStackTrace();
	}
	finally{
		if (pstmt != null) pstmt.close();
		if (resultSet != null)   resultSet.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>
</html>

