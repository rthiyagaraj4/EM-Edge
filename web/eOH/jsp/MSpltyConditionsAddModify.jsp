<!DOCTYPE html>
<!--  
	Developer		: Sridevi Joshi
	Completed On	: 02/05/07
	Modified On		: 07/06/07 
 -->

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String mode=checkForNull(request.getParameter("mode"));
String condition_code = checkForNull(request.getParameter("condition_code"));
String condition_desc="";
String splty_module_id="";
String condition_type="";
String eff_status="";
String condition_code_disable = "";
String disable_flag = "";
String chk_checked="checked";
String chk_value="E";
String sql="";
String moduleid ="";
String modulename = "";
String DBcondition_type ="";
String DBcondition_type_desc = "";

try{
	con=ConnectionManager.getConnection(request);

	if(mode.equals("modify")){
		sql="SELECT CONDITION_DESC, SPLTY_MODULE_ID, CONDITION_TYPE, NVL(EFF_STATUS,'E') EFF_STATUS FROM OH_CONDITION_LANG_VW WHERE CONDITION_CODE = ? AND LANGUAGE_ID = ?";	
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,condition_code);
		pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
		
		while(rs!=null && rs.next())
		{
			condition_desc=checkForNull(rs.getString("condition_desc"));
			splty_module_id=checkForNull(rs.getString("splty_module_id"));
			condition_type=checkForNull(rs.getString("condition_type"));
			eff_status=rs.getString("eff_status");
		}


		if(eff_status.equals("E"))
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
	    condition_code_disable="disabled";	
	}
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOH/js/MSpltyConditions.js'></script>
	<script language='javascript' src='../../eOH/js/OHCommonMasters.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;AssignDBValue();" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="MSpltyConditionsForm" id="MSpltyConditionsForm"  onload='FocusFirstElement()'  action="../../servlet/eOH.MSpltyConditionsServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
<tr>
	<td class=label width="25%" nowrap><fmt:message key="eOH.SpecialityModuleId.Label" bundle="${oh_labels}"/></td>
	<td class="fields" width="25%" colspan="3" align="left">
	
		<select name='splty_module_id' id='splty_module_id' onChange="populateConditionTypes(this)" <% if(mode.equals("modify")){ %> DB_VALUE="<%=splty_module_id%>" <% } %> <%=condition_code_disable%>>
			<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%
				//sql = "SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE WHERE MODULE_GROUP_ID = 'SS' AND NVL(INSTALL_YN,'X')='Y'";
				//sql = "SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE_LANG_VW WHERE MODULE_GROUP_ID = ? AND LANGUAGE_ID=? AND NVL(INSTALL_YN,'X')='Y'";
				sql = "SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE_LANG_VW WHERE MODULE_GROUP_ID = ? AND LANGUAGE_ID=? AND NVL(INSTALL_YN,'X')='Y' AND MODULE_ID = 'OH'"; //CHANGED ON 20/10/07 BY SRIDEVI JOSHI.HERE WE DEFAULTED THE MODULE ID AS 'OH'  

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,"SS");
				pstmt.setString(2,locale);
				rs=pstmt.executeQuery();
				while(rs!=null && rs.next()){
					moduleid = rs.getString("MODULE_ID");
					modulename = rs.getString("MODULE_NAME");
			%>
				<option value="<%=moduleid%>"><%=modulename%></option>
			<% } %>
			
		</select>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.ConditionCode.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
		<input type="text" name="condition_code" id="condition_code" value="<%=condition_code%>" size="25" maxlength="20" <%=condition_code_disable%> onkeypress="return CheckForSpecChars(event);ChangeUpperCase(this)">
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3" align="left">
		<input type="text" name="condition_desc" id="condition_desc" value="<%=condition_desc%>" size="35" maxlength='30' onkeypress="CharCheck();" <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%" nowrap><fmt:message key="eOH.ConditionType.Label" bundle="${oh_labels}"/></td>
	<td class="fields" width="25%" colspan="3" align="left">
		<select name='condition_type' id='condition_type' <% if(mode.equals("modify")){ %> DB_VALUE="<%=condition_type%>" <% } %> <%=disable_flag%>> 
			<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%
				if(mode.equals("modify")){
					//sql="SELECT CONDITION_TYPE, CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE WHERE SPLTY_MODULE_ID='" + moduleid +"'";
					//sql="SELECT CONDITION_TYPE, CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW WHERE SPLTY_MODULE_ID=? AND LANGUAGE_ID=?";
					sql="SELECT CONDITION_TYPE, CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW WHERE SPLTY_MODULE_ID='OH' AND LANGUAGE_ID=?";
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql);
					//pstmt.setString(1,moduleid);
					pstmt.setString(1,locale);
					rs=pstmt.executeQuery();
					while(rs!=null && rs.next()){
						DBcondition_type=rs.getString("CONDITION_TYPE");
						DBcondition_type_desc=rs.getString("CONDITION_TYPE_DESC");
			%>
						<option value="<%=DBcondition_type%>"><%=DBcondition_type_desc%></option>
			<%		}
				}
			%>
		</select>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
			<input type="checkbox" name="eff_status" id="eff_status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
			<!-- <img src='../../eCommon/images/mandatory.gif'> -->
	</td>
</tr>

<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='condition_code1' id='condition_code1' value="<%=condition_code%>">
<input type='hidden' name='condition_desc1' id='condition_desc1' value="<%=condition_desc%>">
<input type='hidden' name='splty_module_id1' id='splty_module_id1' value="<%=splty_module_id%>">
<input type='hidden' name='condition_type1' id='condition_type1' value="<%=condition_type%>">
</form>
</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

