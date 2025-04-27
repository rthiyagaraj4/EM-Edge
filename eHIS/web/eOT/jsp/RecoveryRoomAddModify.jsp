<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id=(String) session.getAttribute("facility_id");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/RecoveryRoom.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");

String recovery_room_code = request.getParameter("recovery_room_code")==null?"":request.getParameter( "recovery_room_code" );
String chk_checked="";
String chk_value="E";
String disable_flag="";
String recovery_room_disable="";
String recovery_room_desc="";
String status="";
String chargeable_yn="";
String sql="";
String sqlForUnitTime="SELECT CHARGE_RECOVERY_ROOM_YN FROM OT_PARAM_FOR_FACILITY  WHERE  OPERATING_FACILITY_ID = ?";
String oper_room_chk_yn="";
	try{
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement(sqlForUnitTime);
		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				oper_room_chk_yn=CommonBean.checkForNull(rs.getString(1));
			}
	 }catch(Exception e){
		e.printStackTrace();
		//out.println("Exception is "+e);
	}finally{
		try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){e.printStackTrace();}
   }




if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		//sql="SELECT HOLDING_AREA_CODE, HOLDING_AREA_DESC, NVL(STATUS,'E') STATUS FROM OT_HOLDING_AREAS WHERE OPERATING_FACILITY_ID=? AND HOLDING_AREA_CODE=? ";
		
		sql="SELECT RECOVERY_ROOM_CODE,RECOVERY_ROOM_DESC,CHARGEABLE_YN,STATUS FROM OT_RECOVERY_ROOM_LANG_VW WHERE LANGUAGE_ID=? AND OPERATING_FACILITY_ID=? AND RECOVERY_ROOM_CODE=? ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,facility_id);
		stmt.setString(3,recovery_room_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			recovery_room_code=rs.getString("RECOVERY_ROOM_CODE");
			recovery_room_desc=rs.getString("RECOVERY_ROOM_DESC");
			chargeable_yn=rs.getString("CHARGEABLE_YN");
			status=rs.getString("STATUS");
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
	/*	if(chargeable_yn.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";
			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}*/
	recovery_room_disable="disabled";	
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
}

%>
<form name="recovery_room_form" id="recovery_room_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.RecoveryRoomServlet" method="post" target="messageFrame"> 
<br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<!-- <tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr> -->

<tr>
	<td class=label>
		<fmt:message key="Common.code.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="recovery_room_code" id="recovery_room_code" value="<%=recovery_room_code%>" size=4 maxlength=4  <%=recovery_room_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="recovery_room_desc" id="recovery_room_desc" value="<%=recovery_room_desc%>"  <%=disable_flag%> size=30 maxlength=30 >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eOT.ChargableRoom.Label" bundle="${ot_labels}"/>
	</td>
	<%if(oper_room_chk_yn.equals("Y")){%>
		<td class="fields">
			<%if(chargeable_yn.equals("Y")){%>
			<input type="checkbox" name="chargeable_yn" id="chargeable_yn" onClick='setCheckChargable();' value='<%=chargeable_yn%>' checked >
			<%}else{%>
			<input type="checkbox" name="chargeable_yn" id="chargeable_yn" onClick='setCheckChargable();' value='<%=chargeable_yn%>' >	
			<%}%>
		</td>
	<%}else{
	%>
		<td class="fields">
			<%if(chargeable_yn.equals("Y")){%>
			<input type="checkbox" name="chargeable_yn" id="chargeable_yn" onClick='setCheckChargable();' value='<%=chargeable_yn%>' checked disabled>
			<%}else{%>
			<input type="checkbox" name="chargeable_yn" id="chargeable_yn" onClick='setCheckChargable();' value='<%=chargeable_yn%>' disabled>	
			<%}%>
		</td>
	<%}%>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<!-- <tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr> -->
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='recovery_room_code1' id='recovery_room_code1' value="<%=recovery_room_code%>">
<input type='hidden' name='recovery_room_desc1' id='recovery_room_desc1' value="<%=recovery_room_desc%>">
<input type='hidden' name=facility_id value="<%=facility_id%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


