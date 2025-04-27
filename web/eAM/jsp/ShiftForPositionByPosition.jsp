<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
     <head>
      	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		
		<script src='../js/ShiftForPosition.js' language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">	

<%
request.setCharacterEncoding("UTF-8");	
Connection conn = ConnectionManager.getConnection(request);
PreparedStatement pstmt_position=null;
ResultSet rs_position=null;
try{

 String	facilityId 	  = "";
 facilityId = (String) session.getValue( "facility_id" ) ;

//Vector position_list = new Vector();
  ArrayList position_list = new ArrayList();

	String qry_position = "Select position_code, position_desc from am_position where eff_status='E' order by position_desc";
	pstmt_position = conn.prepareStatement(qry_position);
	
	rs_position = pstmt_position.executeQuery();
	while(rs_position.next())
	{
		position_list.add(rs_position.getString("position_code"));
		position_list.add(rs_position.getString("position_desc"));
	}
%>
<form name='frm_position_by_position' id='frm_position_by_position'>
	
	<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			<br>
			<br>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td class="label" width="25%"> <fmt:message key="Common.Position.label" bundle="${common_labels}"/> &nbsp;</td>
				<td class="fields" width="55%">
				<select name="position" id="position" onchange='clearval()'>
					<option value='' selected> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
				for(int i=0;i<position_list.size();i+=2)
				{
				%>
					<option value='<%= position_list.get(i) %>' ><%= position_list.get(i+1) %> </option>
				<%
				}
				%>
				</select>
				<img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
			<td colspan="3" class='button'><input type=button class=button value='<fmt:message key="Common.ShowShifts.label" bundle="${common_labels}"/>' onclick='showShiftsList()'></td></tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
	</table>
				<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>'>
<%
	
position_list.clear();
}catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally
{
    if (rs_position != null)   rs_position.close();
	if (pstmt_position != null) pstmt_position.close();
	ConnectionManager.returnConnection(conn,request);
}
%>

</form>
</body>
</html>

