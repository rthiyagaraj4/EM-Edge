<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String record[] = null;
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList Shift_Data		= new ArrayList() ;
	String shift_desc="", mnemonic_key="", shift_indicator="", productive_flag="", shift_type="", prev_flag="";
	//String sql_shift="select   short_desc, mnemonic_key, shift_indicator, productive_flag from am_shift where eff_status = 'E' AND shift_indicator in ('P', 'U') order by shift_indicator, productive_flag desc,short_desc";
	String sql_shift="select short_desc, mnemonic_key, shift_indicator, productive_flag from am_shift_lang_vw where eff_status = 'E' AND shift_indicator in ('P', 'U') and language_id = ? order by shift_indicator, productive_flag desc,short_desc";
	conn = ConnectionManager.getConnection(request);
	try {
		//to get the shift_code & desc
		pstmt = conn.prepareStatement( sql_shift);
		pstmt.setString(1,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[4];				
			record[0] = resultSet.getString("short_desc");
			record[1] = resultSet.getString("mnemonic_key");
			record[2] = resultSet.getString("shift_indicator");
			record[3] = resultSet.getString("productive_flag");
			Shift_Data.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet!=null)
			resultSet.close();
	%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=formShiftList >
	<table width='100%' cellspacing='0' cellpadding='0' border='0'>
		<tr><th width='75%'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></th>
				<th width='25%'><fmt:message key="eRS.Key.label" bundle="${rs_labels}"/></th>
		</tr>
		<% for(int i=0; i<Shift_Data.size();i++){
					record=(String[])Shift_Data.get(i);
					shift_desc=record[0]==null?"":record[0];
					mnemonic_key=record[1]==null?"":record[1];
					shift_indicator=record[2]==null?"":record[2];
					productive_flag=record[3]==null?"":record[3];
					shift_indicator=shift_indicator.trim();
					productive_flag=productive_flag.trim();
					if(!prev_flag.equals(productive_flag)){
						prev_flag=productive_flag;
						if(shift_indicator.equalsIgnoreCase("P")){
							if(productive_flag.equalsIgnoreCase("W"))
								shift_type="Working Shifts";
							else if(productive_flag.equalsIgnoreCase("O"))
								shift_type="Oncall Shifts";
						}
						else if(shift_indicator.equalsIgnoreCase("U"))
							shift_type="Unproductive Shifts";
		%>
	<tr></tr>
		<tr><th colspan='2' align='center'><%=shift_type%></th></tr><tr></tr>
		<% }%>
		<tr>
			<td class='label' width='75%' align='left'><%=shift_desc%></td>
			<td class='label' width='25%' align='center'><%=mnemonic_key%></td>
		</tr>
		<%} %>
	</table>
</form>
</body>
<%	} catch ( Exception e )	{
		out.println(e);
		throw e ;
	} finally {
		if(pstmt != null)
			pstmt.close();
		if(resultSet!=null)
			resultSet.close();
		ConnectionManager.returnConnection(conn,request);
	}%>
</html>					

