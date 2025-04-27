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
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
<!--  	<script language="javascript" src='../js/PkgDefTemp.js'></script> 
 -->	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String mode	   = request.getParameter("mode") ;
	String table_name	   = request.getParameter("table_name") ;
	System.out.println("table_name ***** "+table_name);
	String func_mode			= request.getParameter("func_mode");
	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
		 modifyStatus = " disabled ";
%>

<form name='frmChargeBasedBtn' id='frmChargeBasedBtn'  target='messageFrame' >
<table width='100%' id="tblChargeBsd">
<tr>
<td>&nbsp;</td>
<td width='20%' align='right'>
<INPUT type="button" class='button'	 <%=modifyStatus%> value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" onclick="addRow('<%=table_name%>','<%=func_mode%>');" /></td>
</tr>
 </table>
 <INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
  </form>
 </body>
</html>

