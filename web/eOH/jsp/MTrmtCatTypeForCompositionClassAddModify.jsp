<!DOCTYPE html>
<!-- 
	Developer		: Sridevi Joshi
	Completed On	:  07/06/07
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
String composition_class_code = checkForNull(request.getParameter("composition_class_code"));
String composition_class_desc = "";
String composition_class_code_disable = "";
String trmt_category_type="";
String eff_status="";
String disable_flag = "";
String chk_checked="checked";
String chk_value="E";
String sql="";
String trmt_category_type_code ="";
String trmt_category_type_desc = "";
String task_code_disable = "";
String desc = "";
int row=0;

try{
	con=ConnectionManager.getConnection(request);

	if(mode.equals("modify")){
		//sql="SELECT COMPOSITION_CLASS_DESC, TRMT_CATEGORY_TYPE, NVL(EFF_STATUS,'e') EFF_STATUS FROM OH_COMPOSITION_CLASS WHERE COMPOSITION_CLASS_CODE= ?";	
		
		sql="SELECT COMPOSITION_CLASS_DESC, TRMT_CATEGORY_TYPE, NVL(EFF_STATUS,'e') EFF_STATUS FROM OH_COMPOSITION_CLASS_LANG_VW WHERE COMPOSITION_CLASS_CODE= ? AND LANGUAGE_ID=?";	
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,composition_class_code);
		pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
		
		while(rs!=null && rs.next())
		{
			composition_class_desc=checkForNull(rs.getString("COMPOSITION_CLASS_DESC"));
			trmt_category_type=checkForNull(rs.getString("trmt_category_type"));
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
	    composition_class_code_disable="disabled";	
	}
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script> 
   <script language='javascript' src='../../eOH/js/MTrmtCatTypeForCompositionClass.js'></script>
	<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad="AssignDBValue();" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="MProcCompositionClassForm" id="MProcCompositionClassForm"  onload='FocusFirstElement()'  action="../../servlet/eOH.MTrmtCatTypeForCompositionClassServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center>
<tr>	
	 <td class='label' width='25%' >
	
		<fmt:message key="eOH.CompositionClass.Label" bundle="${oh_labels}"/>
	</td>
	    <td  class="fields"  width='35%'>
			<input type="text"  name="composition_class_desc" id="composition_class_desc" size='30' maxlength='40' value="<%=desc%>" <%=task_code_disable%> onBlur="if(this.value!='') getCompositionLookUp(composition_class_code,composition_class_desc);getTreatment(this);">
			<input type="hidden" name="composition_class_code" id="composition_class_code" value="<%=composition_class_code%>">
			<input type="button" class="button" name="Composition_lookUp" id="Composition_lookUp" value="?" onclick="getCompositionLookUp(composition_class_code,composition_class_desc);getTreatment(this);" <%=task_code_disable%>>
		<% 
			if(composition_class_code.equals("") && mode.equals("insert")){
		%>
				<img id="img2" src='../../eCommon/images/mandatory.gif'></td>
		<%}else{%>
				<img id="img2" src='../../eCommon/images/Blank1.gif'></td>
		<%}%>				
</tr>
<!-- <tr>
	<td width='5%'></td>
	<td width='35%'></td>
</tr>
 -->
<tr></tr><tr></tr><tr></tr>
<tr>
	<td class="CAGROUPHEADING" width="25%" colspan="2"nowrap><fmt:message key="eOH.TreatmentCategoryType.Label" bundle="${oh_labels}"/></td>
	
			<%
					//sql="SELECT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TREATMENT_CATEGORY_TYPE WHERE SPLTY_MODULE_ID='OH' ORDER BY 2";
					sql="SELECT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW WHERE SPLTY_MODULE_ID=? AND LANGUAGE_ID =? ORDER BY 2";
				     if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,"OH");
					pstmt.setString(2,locale);
					rs=pstmt.executeQuery();
					while(rs!=null && rs.next()){
						row++;
						trmt_category_type_code=rs.getString("TRMT_CATEGORY_TYPE");
						trmt_category_type_desc=rs.getString("TRMT_CATEGORY_TYPE_DESC");
			%>
			<tr>		
				<td class="label" width = "25%"> <%=trmt_category_type_desc%> </td>
				<td class="text" width = "35%" > 
					<input type = "checkbox" name="chk_<%=row%>" id="chk_<%=row%>" value='<%=chk_value%>' onClick="assignValue(this,'<%=row%>');">
				</td>
				<input type = "hidden" name="trmt_category_type_code_<%=row%>" id="trmt_category_type_code_<%=row%>" value=<%=trmt_category_type_code%>
			</tr>
		<%
	          }
		%>

</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='composition_class_code1' id='composition_class_code1' value="<%=composition_class_code%>">
<input type='hidden' name='composition_class_desc1' id='composition_class_desc1' value="<%=composition_class_desc%>">
<input type='hidden' name='trmt_category_type1' id='trmt_category_type1' value="<%=trmt_category_type%>">
<input type='hidden' name='row_count' id='row_count' value="<%=row%>">
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




		

