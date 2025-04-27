<!DOCTYPE html>
<!-- 
	Developer   : Muraleedhar
	Created On  : 01/02/2009
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
	String extPermLoc_code = checkForNull(request.getParameter("extPermLoc_code"));
	String disable_flag = "";
	String chk_value="E";
	String eff_status="";
	String sql="";
	String extPermLoc_desc="";
	String chk_checked="checked";
	String extPermLoc_code_disabled="";

	try{
		con=ConnectionManager.getConnection(request);

		if(mode.equals("modify")){
			//sql="SELECT EXT_LOC_DESC, NVL(EFF_STATUS,'E') EFF_STATUS FROM OH_EXT_PERFORM_LOCATIONS WHERE EXT_LOC_CODE= ?";	
			sql="SELECT EXT_LOC_DESC, NVL(EFF_STATUS,'E') EFF_STATUS FROM OH_EXT_PERFORM_LOC_LANG_VW WHERE EXT_LOC_CODE= ? AND LANGUAGE_ID = ?";	//Added by SRidevi Joshi on 5/18/2010 for IN021464
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,extPermLoc_code);
			pstmt.setString(2,locale);
			rs=pstmt.executeQuery();
			while(rs!=null && rs.next())
			{
				extPermLoc_desc=checkForNull(rs.getString("ext_Loc_desc"));
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
			extPermLoc_code_disabled="disabled";	
		}
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOH/js/MExtPermLocation.js'></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script Language="JavaScript" src="../../eOH/js/OHCommonMasters.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

	var treatmentDescription=getLabel("eOH.ExternalPerformingLocationCode.Label","OH");
	var catalogCrossReference=getLabel("eOH.ExternalPerformingLocationDesc.Label","OH");
	var enabled=getLabel("Common.Enabled.label","common");

</script>
</head>

<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="MExtPermLocationForm" id="MExtPermLocationForm"  onload='FocusFirstElement()'  action="../../servlet/eOH.MExtPermLocationServlet" method="post" target="messageFrame"> 
<br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.ExternalPerformingLocationCode.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
		<input type="text" name="extPermLoc_code" id="extPermLoc_code" value="<%=extPermLoc_code%>" size="10" maxlength="10" <%=extPermLoc_code_disabled%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.ExternalPerformingLocationDesc.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
		 <input type="text" name="extPermLoc_desc" id="extPermLoc_desc" value="<%=extPermLoc_desc%>" size="32" maxlength="30" <%=disable_flag%> onkeypress="CharCheck();" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label width="25%">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3" onclick="setCheckValue('eff_status');">
		<input type="checkbox" name="eff_status" id="eff_status" value='<%=chk_value%>' <%=chk_checked%> >
			
	</td>
</tr>

<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='extPermLoc_code1' id='extPermLoc_code1' value="<%=extPermLoc_code%>">
<input type='hidden' name='extPermLoc_desc1' id='extPermLoc_desc1' value="<%=extPermLoc_desc%>">


<input type='hidden' name='splity_module_id' id='splity_module_id' value="OH">
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


