<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<% 
	String facility_id = (String)session.getAttribute("facility_id");
	String qry_locn = "Select locn_type, short_desc locn_desc from am_care_locn_type order by short_desc";
	String mode = request.getParameter("mode")==null ? "1":request.getParameter("mode");
	ArrayList  locn_list = new ArrayList();
	String record[]=null;
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/MstCodeCommon.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language="javascript" src="../js/ShiftForWorkplace.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	PreparedStatement pstmt=null;
	ResultSet rs_locn=null;
	Connection conn = null;
	try{
		conn = ConnectionManager.getConnection(request);

		pstmt = conn.prepareStatement(qry_locn);
		rs_locn = pstmt.executeQuery();
		while(rs_locn.next()){
			record=new String[2];
			record[0]=rs_locn.getString("locn_type");
			record[1]=rs_locn.getString("locn_desc");
			locn_list.add(record);
		}
		if(pstmt != null) 
			pstmt.close();
		if(rs_locn != null)
			rs_locn.close();
%>
<form name='frm_by_workplace' id='frm_by_workplace'>	
	<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">			
			<br><br><br><br><br>			
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="25%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="55%">&nbsp;&nbsp;&nbsp;<select name="locn_type" id="locn_type" onchange="locnchange();">
					<option value='' selected>&nbsp; --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- &nbsp;</option>
<%
					for(int i=0;i<locn_list.size();i++){
						record=(String[])locn_list.get(i);
%>
					<option value='<%=record[0] %>' ><%= record[1] %> </option>
<%
					}
%>
				</select>
				</td>
				<td align=left width="20%"></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="25%"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></td>
				<td align="left" class="label" width="55%">&nbsp;&nbsp;&nbsp;<input type=text size=35 maxlength='30' name='workplace' id='workplace' onblur='showWorkplaceLookup("T",workplace);'><input type=button class='button' value="?" onclick='showWorkplaceLookup("B",workplace);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				<input type=hidden name='workplace_code' id='workplace_code' value=''>
				</td>
				<td align=left width="20%"><input type=button class='button' name='show_shifts' id='show_shifts' value='<fmt:message key="eRS.ShowShifts.label" bundle="${rs_labels}"/>'onclick="showShiftsList()"></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
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
		ConnectionManager.returnConnection(conn,request);
	}
%>
<input type='hidden' name='facility_id' id='facility_id' value='<%= facility_id %>'>
<input type='hidden' name='mode' id='mode' value='<%= mode %>'>
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
</form>
</body>
</html>

