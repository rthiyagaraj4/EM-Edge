<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.*, eCommon.XSSRequestWrapper"%>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/OTHoldingAreas.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String facility_id=(String) session.getAttribute("facility_id");
String sqlForUnitTime="SELECT CHARGE_HOLDING_AREA_YN FROM OT_PARAM_FOR_FACILITY  WHERE  OPERATING_FACILITY_ID = ?";
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



String mode=request.getParameter("mode");

String holding_area_code = request.getParameter("holding_area_code")==null?"":request.getParameter( "holding_area_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String holding_area_disable="";
String holding_area_desc="";
String status="";
String chargeable_yn="";
String sql="";
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		//sql="SELECT HOLDING_AREA_CODE, HOLDING_AREA_DESC, NVL(STATUS,'E') STATUS FROM OT_HOLDING_AREAS WHERE OPERATING_FACILITY_ID=? AND HOLDING_AREA_CODE=? ";
		
		sql="SELECT HOLDING_AREA_CODE, HOLDING_AREA_DESC, NVL(STATUS,'E') STATUS,NVL(CHARGEABLE_YN,'N') CHARGABLE_BAY FROM OT_HOLDING_AREAS_LANG_VW WHERE LANGUAGE_ID = ? AND OPERATING_FACILITY_ID=? AND HOLDING_AREA_CODE=? ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,facility_id);
		stmt.setString(3,holding_area_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			holding_area_code=rs.getString("holding_area_code");
			holding_area_desc=rs.getString("holding_area_desc");
			status=rs.getString("status");
			chargeable_yn=rs.getString("chargable_bay");
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

	holding_area_disable="disabled";	
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
<form name="holding_area_form" id="holding_area_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.HoldingAreasServlet" method="post" target="messageFrame"> 
<br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td class=label>
		<fmt:message key="Common.code.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="holding_area_code" id="holding_area_code" value="<%=holding_area_code%>" size=4 maxlength=4  <%=holding_area_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="holding_area_desc" id="holding_area_desc" value="<%=holding_area_desc%>"  <%=disable_flag%> size=30 maxlength=30 >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eOT.ChargableBay.Label" bundle="${ot_labels}"/>
	</td>
<%if(oper_room_chk_yn.equals("Y")){%>
	<td class="fields">
		<%if(chargeable_yn.equals("Y")) {%>
		<input type="checkbox" name="chargeable_yn" id="chargeable_yn" onClick='setCheckChargeBay();' value='<%=chargeable_yn%>' checked >
		<%}else{%>
		<input type="checkbox" name="chargeable_yn" id="chargeable_yn" onClick='setCheckChargeBay();' value='<%=chargeable_yn%>' >	
		<%}%>
	</td>
<%}else{%>
	<td class="fields">
		<%if(chargeable_yn.equals("Y")) {%>
		<input type="checkbox" name="chargeable_yn" id="chargeable_yn" onClick='setCheckChargeBay();' value='<%=chargeable_yn%>' checked disabled>
		<%}else{%>
		<input type="checkbox" name="chargeable_yn" id="chargeable_yn" onClick='setCheckChargeBay();' value='<%=chargeable_yn%>' disabled>	
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
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name=holding_area_code1 value="<%=holding_area_code%>">
<input type=hidden name=holding_area_desc1 value="<%=holding_area_desc%>">
<input type=hidden name=facility_id value="<%=facility_id%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


