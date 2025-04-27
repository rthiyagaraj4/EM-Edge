<!DOCTYPE html>
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
String trmt_code = checkForNull(request.getParameter("trmt_code"));
String disable_flag = "";
//String chk_checked="checked";
//String chk_value="E";
String splty_module_id="";
String trmt_code_disable = "";
String trmt_category_code="";
String order_catalog_code = "";
String eff_status="";
String sql="";
String DBmoduleid ="";
String DBmodulename = "";
String DBtrmt_category_code ="";
String DBtrmt_category_desc = "";
String DBdiscr_msr_id ="";
String DBshort_desc = "";
String DBorder_catalog_code = "";
String DBordershort_desc = "";

try{
	con=ConnectionManager.getConnection(request);

	if(mode.equals("modify")){
		sql="SELECT TRMT_DESC, SPLTY_MODULE_ID, TRMT_CATEGORY_CODE, ORDER_CATALOG_CODE, NVL(EFF_STATUS,'E') EFF_STATUS FROM OH_TREATMENT_LANG_VW WHERE TRMT_CODE= ? AND LANGUAGE_ID = ?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,trmt_code);
		pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
		while(rs!=null && rs.next())
		{
			order_catalog_code=checkForNull(rs.getString("order_catalog_code"));
			splty_module_id=checkForNull(rs.getString("splty_module_id"));
			trmt_category_code=checkForNull(rs.getString("trmt_category_code"));
			eff_status=rs.getString("eff_status");
		
		}
		
		if(eff_status.equals("E"))
		{
			//chk_checked="checked";
			disable_flag="";
		}
		else
		{
			//chk_checked="";
			disable_flag="disabled";
			//chk_value="D";
		}
	    trmt_code_disable="disabled";	
	}
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOH/js/MSpltyTreatmentProc.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false; AssignDBValue();" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="MSpltyTreatmentProcForm" id="MSpltyTreatmentProcForm"  onload='FocusFirstElement()'  action="../../servlet/eOH.MSpltyTreatmentProcServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
<tr>
	<td class=label width="25%" nowrap><fmt:message key="eOH.SpecialityModuleId.Label" bundle="${oh_labels}"/></td>
	<td class="fields" width="25%" colspan="3" align="left">
	
		<select name='splty_module_id' id='splty_module_id' onChange="populateTreatmentCodes(this)" <% if(mode.equals("modify")){ %> DB_VALUE="<%=splty_module_id%>" <% } %> <%=trmt_code_disable%>>
			<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%
			
				sql = "SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE_LANG_VW WHERE MODULE_GROUP_ID = 'SS' AND LANGUAGE_ID = ? AND NVL(INSTALL_YN,'N')='Y' ORDER BY 2";

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,locale);
				rs=pstmt.executeQuery();
				while(rs!=null && rs.next()){
					DBmoduleid = rs.getString("MODULE_ID");
					DBmodulename = rs.getString("MODULE_NAME");
			%>
				<option value="<%=DBmoduleid%>"><%=DBmodulename%></option>
			<% } %>
			
		</select>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.TreatmentProcedure.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3" align="left">
	
		<select name='trmt_code' id='trmt_code' <% if(mode.equals("modify")){ %> DB_VALUE="<%=trmt_code%>" <% } %> <%=trmt_code_disable%>>
			<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%
				sql = "SELECT DISCR_MSR_ID, SHORT_DESC FROM AM_DISCR_MSR_LANG_VW WHERE LANGUAGE_ID = ? AND NVL(EFF_STATUS,'E') = 'E' ORDER BY 2";

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,locale);
				rs=pstmt.executeQuery();
				while(rs!=null && rs.next()){
					DBdiscr_msr_id = rs.getString("DISCR_MSR_ID");
					DBshort_desc = rs.getString("SHORT_DESC");
			%>
				<option value="<%=DBdiscr_msr_id%>"><%=DBshort_desc%></option>
			<% } %>
			
		</select>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%" nowrap><fmt:message key="eOH.TreatmentCategoryCode.Label" bundle="${oh_labels}"/></td>
	<td class="fields" width="25%" colspan="3" align="left">
		<select name='trmt_category_code' id='trmt_category_code' <% if(mode.equals("modify")){ %> DB_VALUE="<%=trmt_category_code%>" <% } %> <%=disable_flag%>> 
			<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%
				if(mode.equals("modify")){
					sql="SELECT TRMT_CATEGORY_CODE, SHORT_DESC FROM OH_TREATMENT_CATEGORY WHERE SPLTY_MODULE_ID='" + DBmoduleid +"' ORDER BY 2";
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					while(rs!=null && rs.next()){
						DBtrmt_category_code=rs.getString("TRMT_CATEGORY_CODE");
						DBtrmt_category_desc=rs.getString("SHORT_DESC");
			%>
						<option value="<%=DBtrmt_category_code%>"><%=DBtrmt_category_desc%></option>
			<%		}
				}
			%>
		
		</select>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%" nowrap><fmt:message key="eOH.OrderCatalogue.Label" bundle="${oh_labels}"/></td>
	<td class="fields" width="25%" colspan="3" align="left">
		<select name='order_catalog_code' id='order_catalog_code' <% if(mode.equals("modify")){ %> DB_VALUE="<%=order_catalog_code%>" <% } %> <%=disable_flag%>> 
			<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%
				sql = "SELECT ORDER_CATALOG_CODE, SHORT_DESC FROM OR_ORDER_CATALOG_LANG_VW WHERE ORDER_CATEGORY = 'MI' AND LANGUAGE_ID =? AND NVL(EFF_STATUS,'E') = 'E'";

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,locale);
				rs=pstmt.executeQuery();
				while(rs!=null && rs.next()){
					DBorder_catalog_code = rs.getString("ORDER_CATALOG_CODE");
					DBordershort_desc = rs.getString("SHORT_DESC");
			%>
				<option value="<%=DBorder_catalog_code%>"><%=DBordershort_desc%></option>
			<% } %>
		
		</select>
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
<input type='hidden' name='trmt_code1' id='trmt_code1' value="<%=trmt_code%>">
<input type='hidden' name='order_catalog_code1' id='order_catalog_code1' value="<%=order_catalog_code%>">
<input type='hidden' name='splty_module_id1' id='splty_module_id1' value="<%=splty_module_id%>">
<input type='hidden' name='trmt_category_code1' id='trmt_category_code1' value="<%=trmt_category_code%>">
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

