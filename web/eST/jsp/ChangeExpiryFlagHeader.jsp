<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
07/08/2020  IN073577        B Haribabu          07/08/2020                          MMS-DM-CRF-0174.2
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
 <head>
  <title> </title>

<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/ChangeExpiryFlag.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
		eST.ChangeExpiryFlagBean bean		=		(eST.ChangeExpiryFlagBean) getBeanObject( "ChangeExpiryFlagBean","eST.ChangeExpiryFlagBean",request);
		bean.setLanguageId(locale);
		String item_code					=		"";
		String finalize						=		"false";
		//Added for GHL-CRF-0413 starts
		Connection con				= null;
		con						= ConnectionManager.getConnection(request);
		boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
		bean.setSite_spec_yn(site_main);
		boolean site=bean.isSite_spec_yn();
		//Added for GHL-CRF-0413 ends
	%>

	</head>
<body onLoad="FocusFirstElement()">
<form name=formChangeExpiryFlagHeader id=formChangeExpiryFlagHeader >
<br>
	<table border='0' cellpadding='0' cellspacing='0' width='85%' align=center>
		<tr>
			<td width='20%'>&nbsp;</td>
			<td width='20%'>&nbsp;</td>
			<td width='20%'>&nbsp;</td>
			<td width='10%'>&nbsp;</td>
			<td width='20%'>&nbsp;</td>
			<td width='10%' colspan='2'>&nbsp;</td>
	</tr>
	<% if(site_main){//Added for GHL-CRF-0413%>
	<tr>
	<td class=label ><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<td  class='fields' colspan="5"><input type=text name=barcode id=barcode size=80  maxlength=100 value="" onkeypress="callItemSearchScreenExpFlag(event, barcode);" ></td><!--Modified for IN:073577 increased size from 70 to 80 -->
	</tr>
	<%} %>
	<tr>
		<td class=label ><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  class='fields' colspan='3'><input type=text name=item_desc id=item_desc size=60  maxlength=60 value=""  ><input type=button name="item_search" id="item_search" class="button"     value='?' onClick="callItemSearchScreen(item_code)"><%=bean.getImage("M")%></td>
		<td class=label ><fmt:message key="eST.ExpiryFlag.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<td  class='fields' colspan='2'><input type=checkbox name=expiry_yn id=expiry_yn onclick="setExpiryFlag('CB');setBatchReload('')"></td>
		<td class=label  nowrap><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<td  id=td_qoh class=label></td>
	</tr>
	<tr>
		<td colspan=6>&nbsp;</td>
        	</tr>
	</table>
	<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
	<input type="hidden" name="item_code" id="item_code"						value="<%=item_code%>">
	<input type="hidden" name="batch_id_applicable_yn" id="batch_id_applicable_yn">
	<input type="hidden" name="trade_id_applicable_yn" id="trade_id_applicable_yn">
	<input type="hidden" name="trade_id" id="trade_id">
	<input type="hidden" name="tab3Selected" id="tab3Selected"					value="No">
	<input type="hidden" name="trade_id" id="trade_id">
	<input type="hidden" name="item_flag" id="item_flag" >
	<input type="hidden" name="change_flag" id="change_flag" >
	<input type="hidden" name="finalize" id="finalize"						value="<%=finalize%>">
	<!-- added on 24/08/2004  -->
	<input type="hidden" name="change_flag_ph_item_assoc_check" id="change_flag_ph_item_assoc_check" value="N" >
	<input type="hidden" name="noPendingRecords" id="noPendingRecords" value="">
	<input type=hidden name=batch_reload id=batch_reload value="">
	<input type="hidden"    name="site" id="site"	 value="<%=site%>">
</form>
<%
//Added for GHL-CRF-0413
	if(con != null)
		ConnectionManager.returnConnection(con,request);
%>
<%
	putObjectInBean("ChangeExpiryFlagBean",bean,request);
%>
</body>
</html> 


