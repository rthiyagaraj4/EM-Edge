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
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	String mode	   = request.getParameter("mode")==null?"":request.getParameter("mode") ;
	String table_name	   = request.getParameter("table_name") ;
	String bean_id = "Bl_PkgDefBean" ;
	String bean_name = "eBL.PkgDefBean";
	String locale			= (String)session.getAttribute("LOCALE");
	String order_associated="N";
	String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");
	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
		 modifyStatus = " disabled ";
	

	String colNum="";
	String key="";
	if(table_name.equals("ass_child_pack_tbl")){	
		colNum="18";//Split Reqd - Rajesh V
		 key="CHILD_PACK";
	}
	
	
%>

<form name='rate_based_btn' id='rate_based_btn'  target='messageFrame' >

<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="order_associated" id="order_associated" value="<%=order_associated%>">	
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	
<table width='100%' id="rate_based_btn_tbl">
<tr>
<td>&nbsp;</td>
<td width='20%' align='right'>
<INPUT type="button" class='button' <%=modifyStatus%> value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" onclick="addRow('<%=table_name%>','<%=key%>');" />
</td>
</tr>

 </table>
 <INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
 <%System.out.println("mode@@@@@@@@@@"+mode); %>
  </form>
 </body>
</html>

