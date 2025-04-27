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
String composition_code = checkForNull(request.getParameter("composition_code"));
String composition_desc = "";
String composition_code_disable = "";
String composition_class_code="";
String eff_status="";
String disable_flag = "";
String chk_checked="checked";
String anesthesia_yn_checked="";
String anesthesia_yn_disabled="";
String chk_value="E";
String anesthesia_yn="";
String sql="";
String disable_oth="";

try{
	con=ConnectionManager.getConnection(request);

	if(mode.equals("modify")){
		//sql="SELECT COMPOSITION_DESC, COMPOSITION_CLASS_CODE, NVL(EFF_STATUS,'e') EFF_STATUS FROM OH_COMPOSITION WHERE COMPOSITION_CODE= ?";	
		sql="SELECT COMPOSITION_DESC, COMPOSITION_CLASS_CODE, NVL(EFF_STATUS,'E') EFF_STATUS, NVL(ANESTHESIA_YN,'N') ANESTHESIA_YN FROM OH_COMPOSITION_LANG_VW WHERE COMPOSITION_CODE= ? AND LANGUAGE_ID = ?";	
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,composition_code);
		pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
		
		while(rs!=null && rs.next())
		{
			composition_desc=checkForNull(rs.getString("COMPOSITION_DESC"));
			composition_class_code=checkForNull(rs.getString("COMPOSITION_CLASS_CODE"));
			eff_status=rs.getString("EFF_STATUS");
			anesthesia_yn=rs.getString("ANESTHESIA_YN");
		}

		//By Sridevi Joshi on 03/09/09 for IN012626(PMG20089-CRF-0709).... To disable record with OTH. As this is the default value to be mentained. 
		if(composition_code.equals("OTH")){
			disable_oth = "disabled";
		}

		if(eff_status.equals("E")){
			chk_checked="checked";
			disable_flag="";
			if(anesthesia_yn.equals("Y")){
				anesthesia_yn_disabled = "disabled";
			}else{
				anesthesia_yn_disabled = "";
			}
		}else{
			chk_checked="";
			disable_flag="disabled";
			anesthesia_yn_disabled="disabled";
			chk_value="D";
		}

		if(anesthesia_yn.equals("Y")){
			anesthesia_yn_checked="checked";
		}else{
			anesthesia_yn_checked="";
		}
	    composition_code_disable="disabled";	
	}
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOH/js/MProcComposition.js'></script>
	<script Language="JavaScript" src="../../eOH/js/OHCommonMasters.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false; AssignDBValue();" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="MProcCompositionForm" id="MProcCompositionForm"  onload='FocusFirstElement()'  action="../../servlet/eOH.MProcCompositionServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.CompositionCode.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
		<input type="text" name="composition_code" id="composition_code" value="<%=composition_code%>" size="6" maxlength="6" <%=composition_code_disable%> onkeypress="return CheckForSpecChars(event);ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3" align="left">
		<input type="text" name="composition_desc" id="composition_desc" value="<%=composition_desc%>" size="35" maxlength='30'  onkeypress="CharCheck();" <%=disable_flag%> <%=disable_oth%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%" nowrap><fmt:message key="eOH.CompositionClass.Label" bundle="${oh_labels}"/></td>
	<td class="fields" width="25%" colspan="3" align="left">
		<select name='composition_class_code' id='composition_class_code' <% if(mode.equals("modify")){ %> DB_VALUE="<%=composition_class_code%>" <% } %> <%=disable_flag%> <%=disable_oth%>> 
			<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%
					//sql="SELECT COMPOSITION_CLASS_CODE, COMPOSITION_CLASS_DESC FROM OH_COMPOSITION_CLASS ORDER BY 2";
					sql="SELECT COMPOSITION_CLASS_CODE, COMPOSITION_CLASS_DESC FROM OH_COMPOSITION_CLASS_LANG_VW WHERE LANGUAGE_ID = ? ORDER BY 2";
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,locale);
					rs=pstmt.executeQuery();
					while(rs!=null && rs.next()){						
			%>
						<option value="<%=rs.getString("COMPOSITION_CLASS_CODE")%>"><%=rs.getString("COMPOSITION_CLASS_DESC")%></option>
			<%		}   %>	

		</select>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
			<fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/>?
	</td>
	<td class="fields" width="25%" colspan="3">
			<input type="checkbox" name="anesthesia_yn" id="anesthesia_yn" onClick='assignAnesthesiaYN(this);' value='<%=anesthesia_yn%>' <%=anesthesia_yn_checked%> <%=anesthesia_yn_disabled%> <%=disable_oth%>>
	</td>
</tr>
<tr>
	<td class=label width="25%">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
			<input type="checkbox" name="eff_status" id="eff_status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> <%=disable_oth%>>
	</td>
</tr>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='composition_code1' id='composition_code1' value="<%=composition_code%>">
<input type='hidden' name='composition_desc1' id='composition_desc1' value="<%=composition_desc%>">
<input type='hidden' name='composition_class_code1' id='composition_class_code1' value="<%=composition_class_code%>">
<input type='hidden' name='anesthesia_yn1' id='anesthesia_yn1' value="<%=anesthesia_yn%>">
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

