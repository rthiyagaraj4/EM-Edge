<!DOCTYPE html>
<!-- 
	Developer   : Sridevi Joshi
	Created On  : 04/06/07
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
String complication_code = checkForNull(request.getParameter("complication_code"));
String complication_desc="";
String eff_status = "";
String complication_code_disable = "";
String disable_flag = "";
String chk_checked="checked";
String chk_value="E";
String sql="";

try{
	con=ConnectionManager.getConnection(request);

	if(mode.equals("modify")){
		//below line is commented by bshankar on 18th Feb as new master for treatment category types association is being created
		// backup is in jsp/backup/ComplicationsMasterBeforechaning_18022008
//		sql="SELECT COMPLICATION_DESC, TRMT_CATEGORY_TYPE, NVL(EFF_STATUS,'E') EFF_STATUS FROM OH_COMPLICATION_LANG_VW WHERE LANGUAGE_ID=? AND COMPLICATION_CODE = ?";	
		sql="SELECT COMPLICATION_DESC, NVL(EFF_STATUS,'E') EFF_STATUS FROM OH_COMPLICATION_LANG_VW WHERE LANGUAGE_ID=? AND COMPLICATION_CODE = ?";	
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,complication_code);
		rs=pstmt.executeQuery();
		
		while(rs!=null && rs.next())
		{
			complication_desc=checkForNull(rs.getString("complication_desc"));
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
	    complication_code_disable="disabled";	
	}
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOH/js/MComplications.js'></script>
	<script Language="JavaScript" src="../../eOH/js/OHCommonMasters.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="MComplicationsForm" id="MComplicationsForm"  onload='FocusFirstElement()'  action="../../servlet/eOH.MComplicationsServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.ComplicationCode.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
		<input type="text" name="complication_code" id="complication_code" value="<%=complication_code%>" size="6" maxlength="6" onkeypress="return CheckForSpecChars(event);ChangeUpperCase(this)" <%=complication_code_disable%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3" align="left">
		<input type="text" name="complication_desc" id="complication_desc" value="<%=complication_desc%>" size="35" maxlength='30'  onkeypress="CharCheck();"<%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
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
<input type='hidden' name='complication_code1' id='complication_code1' value="<%=complication_code%>">
<input type='hidden' name='complication_desc1' id='complication_desc1' value="<%=complication_desc%>">
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

