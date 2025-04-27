<!DOCTYPE html>
<!-- 
	Developer		: Sridevi Joshi
	Completed On	: 10/05/07
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
String trmt_category_code = checkForNull(request.getParameter("trmt_category_code"));
String trmt_code_disable = "";
String disable_flag = "";
String chk_checked="checked";
String chk_value="E";
String trmt_category_desc="";
String splty_module_id="";
String trmt_category_type="";
String eff_status="";
String sql="";
String moduleid ="";
String modulename = "";
String DBtrmt_category_type ="";
String DBtrmt_category_desc = "";
String denture_removable = ""; //Added by Sridevi Joshi on 2/8/2010 for IN010871(SRR20056-CRF-0478)
String denture_checked = ""; //Added by Sridevi Joshi on 2/8/2010 for IN010871(SRR20056-CRF-0478)
String denture_disable_flag = ""; //Added by Sridevi Joshi on 2/8/2010 for IN010871(SRR20056-CRF-0478)

try{
	con=ConnectionManager.getConnection(request);
	
	if(mode.equals("modify")){
		sql="SELECT TRMT_CATEGORY_DESC, SPLTY_MODULE_ID, TRMT_CATEGORY_TYPE, NVL(EFF_STATUS,'E') EFF_STATUS, NVL(DENTURE_REMOVABLE,'N') DENTURE_REMOVABLE FROM OH_TREATMENT_CATEGORY_LANG_VW WHERE TRMT_CATEGORY_CODE= ? AND LANGUAGE_ID=?";	
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,trmt_category_code);
		pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
		
		
		while(rs!=null && rs.next())
		{
			trmt_category_desc=checkForNull(rs.getString("trmt_category_desc"));
			splty_module_id=checkForNull(rs.getString("splty_module_id"));
			trmt_category_type=checkForNull(rs.getString("trmt_category_type"));
			eff_status=rs.getString("eff_status");
			denture_removable=rs.getString("DENTURE_REMOVABLE");//Added by Sridevi Joshi on 2/8/2010 for IN010871(SRR20056-CRF-0478)
		}

		if(denture_removable.equals("Y")){//Added by Sridevi Joshi on 2/8/2010 for IN010871(SRR20056-CRF-0478)
			denture_checked="checked";
			//denture_disable_flag="disabled";
			denture_disable_flag="";
		}
		else{//Added by Sridevi Joshi on 2/8/2010 for IN010871(SRR20056-CRF-0478)
			denture_checked="";
			denture_disable_flag="";
		}

		if(eff_status.equals("E")){
			chk_checked="checked";
			disable_flag="";
		}
		else{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}

	    trmt_code_disable="disabled";	
	}
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOH/js/MTreatmentCategories.js'></script>
	<script language='javascript' src='../../eOH/js/OHCommonMasters.js'></script>
	<script language='javascript' src='../../eOH/js/MCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false; AssignDBValue();" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="MTreatmentCategoriesForm" id="MTreatmentCategoriesForm"  onload='FocusFirstElement()'  action="../../servlet/eOH.MTreatmentCategoriesServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.TreatmentCategoryCode.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
		<input type="text" name="trmt_category_code" id="trmt_category_code" value="<%=trmt_category_code%>" size="20" maxlength="20" <%=trmt_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3" align="left">
		<input type="text" name="trmt_category_desc" id="trmt_category_desc" value="<%=trmt_category_desc%>" size="30" maxlength='30' onkeypress="CharCheck();" <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%" nowrap><fmt:message key="eOH.SpecialityModuleId.Label" bundle="${oh_labels}"/></td>
	<td class="fields" width="25%" colspan="3" align="left">
	
		<select name='splty_module_id' id='splty_module_id' onChange="populateTreatmentTypes(this)" <% if(mode.equals("modify")){ %> DB_VALUE="<%=splty_module_id%>" <% } %> <%=trmt_code_disable%>>
			<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%
				sql = "SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE_LANG_VW WHERE MODULE_GROUP_ID = ? AND LANGUAGE_ID = ? AND NVL(INSTALL_YN,'N')='Y' AND MODULE_ID = 'OH'";

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
	<td class=label width="25%" nowrap><fmt:message key="eOH.TreatmentCategoryType.Label" bundle="${oh_labels}"/></td>
	<td class="fields" width="25%" colspan="3" align="left">
		<select name='trmt_category_type' id='trmt_category_type' <% if(mode.equals("modify")){ %> DB_VALUE="<%=trmt_category_type%>" <% } %> <%=disable_flag%> onChange="setOptionValue(this);"> 
			<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%
				if(mode.equals("modify")){
					sql="SELECT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW WHERE SPLTY_MODULE_ID=? AND LANGUAGE_ID=?";
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,moduleid);
					pstmt.setString(2,locale);
					rs=pstmt.executeQuery();
					while(rs!=null && rs.next()){
						DBtrmt_category_type=rs.getString("TRMT_CATEGORY_TYPE");
						DBtrmt_category_desc=rs.getString("TRMT_CATEGORY_TYPE_DESC");
			%>
						<option value="<%=DBtrmt_category_type%>"><%=DBtrmt_category_desc%></option>
			<%		}
				}
			%>
		
		</select>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<!-- Added by Sridevi Joshi on 2/8/2010 for IN010871(SRR20056-CRF-0478) -->
<% if(mode.equals("modify") && trmt_category_type.equals("DENTURE")){ %>
	<tr>
		<td class=label width="25%" id="denture_removable_label">Removable</td>
		<td class="fields" width="25%" colspan="3" id="denture_removable_field"><input type='checkbox' name='denture_removable' id='denture_removable' onClick='setCheckValue("denture_removable");' value='<%=denture_removable%>' <%=denture_checked%> <%=denture_disable_flag%> <%=disable_flag%>></td>
	</tr>
<% }else{ %>
	<tr>
		<td class=label width="25%" id="denture_removable_label"></td>
		<td class="fields" width="25%" colspan="3" id="denture_removable_field"></td>
	</tr>
<% } %>
<!-- End -->
<tr>
	<td class=label width="25%">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
			<input type="checkbox" name="eff_status" id="eff_status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='trmt_category_code1' id='trmt_category_code1' value="<%=trmt_category_code%>">
<input type='hidden' name='trmt_category_desc1' id='trmt_category_desc1' value="<%=trmt_category_desc%>">
<input type='hidden' name='splty_module_id1' id='splty_module_id1' value="<%=splty_module_id%>">
<input type='hidden' name='trmt_category_type1' id='trmt_category_type1' value="<%=trmt_category_type%>">
<input type='hidden' name='denture_removable1' id='denture_removable1' value="<%=denture_removable%>">
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

