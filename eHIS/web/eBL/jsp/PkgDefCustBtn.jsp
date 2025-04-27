<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src='../../eBL/js/PkgDefCust.js'></script> 
<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	String mode	   = request.getParameter("mode")==null?"": request.getParameter("mode");
	String table_name	   = request.getParameter("table_name") ;
	String bean_id = "Bl_PkgDefBean" ;
	String bean_name = "eBL.PkgDefBean";
	String locale			= (String)session.getAttribute("LOCALE");
	String colNum="";
	String key="";
	String deleteOption="Y";

	if(table_name.equals("cust_tbl")){
		 colNum="3";
		 key="CUSTOMER";
		 deleteOption="N";
	}else if(table_name.equals("cust_period_tbl")){
		colNum="4";
		 key="CUST_PERIOD";
		 deleteOption="N";
	}
	else if(table_name.equals("cust_base_price_tbl")){
		colNum="5";
		 key="CUST_PRICE";
		 deleteOption="N";
	}
	else if(table_name.equals("cust_rate_based_tbl")){
		colNum="22";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/from 20 -> 21//Modified V200813-Shikha/MMS-QH-CRF-0170/from 21 -> 22
		 key="CUST_RATE_BASED";
		 deleteOption="Y";
	}else if(table_name.equals("cust_srvLimit_rate_based_tbl")){
		colNum="17";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/from 16 -> 17
		 key="CUST_SRVLIMIT_RATE_BASED";
		 deleteOption="Y";
	}
	else if(table_name.equals("cust_charge_based_tbl")){
		//colNum="9";
		colNum="12";//Split reqd
		 key="CUST_CHARGE_BASED";
		 deleteOption="Y";
	}
	else if(table_name.equals("cust_charge_based_excl_tbl")){
		colNum="6";//Split reqd
		 key="CUST_CHARGE_BASED_ITEM";
		 deleteOption="Y";
	}
	
	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
		 modifyStatus = " disabled ";
%>

<form name='cust_btn' id='cust_btn'  target='messageFrame' >

<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	
<table width='100%' id="cust_btn_tbl">
<tr>
<td>&nbsp;</td>
<td width='20%' align='right'>
	<!-- //sarath added MMS-QF-SCF-0545 below button id added -->
	<INPUT type="button" id='custDefAddBtn' class='button'  <%=modifyStatus%>  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" onclick="addRow('<%=table_name%>','<%=key%>');" />
	<%if(deleteOption.equals("Y")) { %>
		<input type="button" class="button"	 <%=modifyStatus%>  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")%>" onClick="deleteRowCust('<%=table_name%>','<%=colNum%>','');">
	<%}%>
</td>

</tr>

 </table>
 <INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
  </form>
 </body>
</html>

