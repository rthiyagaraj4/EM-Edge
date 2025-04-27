<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>
<title><fmt:message key="eBL.CopyPackage.label" bundle="${bl_labels}"/></title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%	
	String locale			= (String)session.getAttribute("LOCALE");
	String facilityId		= (String) session.getValue( "facility_id" ) ;
	String copyFrm_pkgCode=request.getParameter("copyFrm_pkgCode");
	String copyFrm_pkgDesc=request.getParameter("copyFrm_pkgDesc");
	String copyTo_pkgCode=request.getParameter("copyTo_pkgCode");
	//String copyTo_PkgDesc=request.getParameter("copyTo_PkgDesc");	 
	String copyTo_longDesc=request.getParameter("copyTo_longDesc");	
	String copyTo_shortDesc=request.getParameter("copyTo_shortDesc");	
	String copyTo_effFromDate=request.getParameter("copyTo_effFromDate");	
		
%>

<form name='copy_pkg' id='copy_pkg'  target='messageFrame' >
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>">

<table class='grid' width='100%' align='center' id="copyFrom_tbl" border='0'>
<tr>
<td colspan='2' class='columnheader' ><fmt:message key="eBL.CopyFrom.label" bundle="${bl_labels}"/></td> 
</tr>
<tr>
<td align='right' class='label' width='25%'><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>
<td align="left" nowrap><input type='text' name='copyFrm_pkgCode' id='copyFrm_pkgCode' value='<%=copyFrm_pkgCode%>' size='8' maxlength="8"  onBlur="copyFrm_pkgCodeLookUp(copyFrm_pkgDesc,this)"><input type='text' name = 'copyFrm_pkgDesc' size='40' maxlength="40"  onBlur="copyFrm_pkgDescLookUp(this,copyFrm_pkgCode)" value="<%=copyFrm_pkgDesc%>"><INPUT type='hidden' name='copyFrm_pkgCode_temp' id='copyFrm_pkgCode_temp' value=''><INPUT type='hidden' name='copyFrm_pkgDesc_temp' id='copyFrm_pkgDesc_temp' value=''><input type='button' name='copyFrm_button' id='copyFrm_button' class='button' value='?' onclick="copyFrm_PkgLookUp(copyFrm_pkgDesc,copyFrm_pkgCode)"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
</table>
	
<table class='grid' width='100%' align='center' id="copyTo_tbl" border='0'>
<tr>
<td colspan='2' class='columnheader' ><fmt:message key="eBL.CopyTo.label" bundle="${bl_labels}"/></td> 
</tr>
<tr>
<td  class="label" align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>	
<td  class='fields' align='left'><input type='text' name='copyTo_pkgCode' id='copyTo_pkgCode' size='8' maxlength="8"  value="<%=copyTo_pkgCode%>"  onKeyPress='return CheckForSpecChars_loc(event,copyTo_pkgCode)' onBlur='clearBean(this.value);duplicateCheck(this,"insert")'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
<td class="label" ><fmt:message key="Common.LongDesc.label" bundle="${common_labels}"/></td>	
<td class="fields" ><input type='text' name='copyTo_longDesc' id='copyTo_longDesc' size='50' maxlength="100"  value="<%=copyTo_longDesc%>" onBlur=""><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
<td class='label' align='right'><fmt:message key="Common.ShortDesc.label" bundle="${common_labels}"/></td>	
<td class='fields' align='left'><input type='text' name='copyTo_shortDesc' id='copyTo_shortDesc' size='40' maxlength="40"  value="<%=copyTo_shortDesc%>" onBlur=""><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
<td class='label' align='right'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>	
<td class='fields' align='left'><input type='text' name='copyTo_effFromDate' id='copyTo_effFromDate' size='10' maxlength="10"  value="<%=copyTo_effFromDate%>" onBlur="return validDateChk(this,'1')"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('copyTo_effFromDate');" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
<td align="right" colspan='2' nowrap><INPUT type="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onclick="saveCopyPkg()" /><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="window.close();"></td>
</tr>
 </table>
  </form>   
 </body>

</html>

