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

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src='../../eBL/js/PkgDefBlngGrp.js'></script>  
	<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	System.out.println("PkgDefBlngGrpBtn.jsp Start");
	String mode	   = request.getParameter("mode")==null?"": request.getParameter("mode");
	String table_name	   = request.getParameter("table_name") ;
	String bean_id = "Bl_PkgDefBean" ;
	String bean_name = "eBL.PkgDefBean";
	String locale			= (String)session.getAttribute("LOCALE");
	String colNum="";
	String key="";
	String deleteOption="Y";
	System.out.println("PkgDefBlngGrpBtn.jsp 1="+table_name);
	if(table_name.equals("blng_grp_tbl")){
		 colNum="3";
		 key="BILLINGGROUP";
		 deleteOption="N";
	}else if(table_name.equals("blng_grp_period_tbl")){
		colNum="4";
		 key="BLNG_GRP_PERIOD";
		 deleteOption="N";
	}
	else if(table_name.equals("blng_grp_base_price_tbl")){
		colNum="5";
		 key="BLNG_GRP_PRICE";
		 deleteOption="N";
	}
	else if(table_name.equals("blng_grp_rate_based_tbl")){
		colNum="21";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/from 20 -> 21
		 key="BLNG_GRP_RATE_BASED";
		 deleteOption="Y";
	}else if(table_name.equals("blng_grp_srvLimit_rate_based_tbl")){
		colNum="17";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/from 16 -> 17
		 key="BLNG_GRP_SRVLIMIT_RATE_BASED";
		 deleteOption="Y";
	}
	else if(table_name.equals("blng_grp_charge_based_tbl")){
		//colNum="9";
		colNum="12";//Split reqd
		 key="BLNG_GRP_CHARGE_BASED";
		 deleteOption="Y";
	}
	else if(table_name.equals("blng_grp_charge_based_excl_tbl")){
		colNum="6";//Split reqd
		 key="BLNG_GRP_CHARGE_BASED_ITEM";
		 deleteOption="Y";
	}
	
	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
		 modifyStatus = " disabled ";
	System.out.println("PkgDefBlngGrpBtn.jsp 2");
%>

<form name='blnggrp_btn' id='blnggrp_btn'  target='messageFrame' >

<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	
<table width='100%' id="blng_grp_btn_tbl">
<tr>
<td>&nbsp;</td>
<td width='20%' align='right'>
	<!-- //sarath added MMS-QF-SCF-0545 below button id added -->
	<INPUT type="button" id='blngGrpDefAddBtn' class='button'  <%=modifyStatus%>  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" onclick="addRow('<%=table_name%>','<%=key%>');" />
	<%if(deleteOption.equals("Y")) { %>
		<input type="button" class="button"	 <%=modifyStatus%>  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")%>" onClick="deleteRowBlngGrp('<%=table_name%>','<%=colNum%>','');">
	<%}%>
</td>

</tr>

 </table>
 <INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
  </form>
 </body>
</html>

