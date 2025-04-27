<!DOCTYPE html>
﻿<%@ page import ="eST.StDefineBarcodeRulesBean,java.util.ArrayList,webbeans.eCommon.*, java.sql.*, java.util.Properties, eST.Common.StRepository, eCommon.Common.OptionValues,eST.Common.*, eST.*,java.util.*" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	try {
			request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<html><head><title><fmt:message key="eMM.ItemforStore.label" bundle="${mm_labels}"/></title>
<!-- 	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
 	<script src='../../eCommon/js/messages.js' language='JavaScript'></script>
	<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script>
    <Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
	 <script language="javascript" src="../../eST/js/StMessages.js"></script>
		<script language="javascript" src="../../eMM/js/MmMessages.js"></script>
	<script language="javascript" src="../../eST/js/StDefineBarcodeRules.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

	<%

		String bean_id;
		String bean_name;
		String mode;
		String val	=			"";
		mode	= "" ;
		String newbarcode ="";
		bean_id								=			"stDefineBarcodeRulesBean" ;
		bean_name							=			"eST.StDefineBarcodeRulesBean";
		StDefineBarcodeRulesBean bean		=			(StDefineBarcodeRulesBean)getBeanObject( bean_id, bean_name,request);  
			
		bean.setLanguageId(locale);
		bean.clear() ;
		
		mode								=			bean.recordExists()?eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"):eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");

	ServletContext context				=			getServletConfig().getServletContext();

	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		
		bean.loadData();
}
	System.out.println("mode"+mode);
	//val = bean.getBarcode_gen_rule();
	//System.out.println("val"+val);
	//System.out.println("bean_id"+bean_id);
	//System.out.println("bean_name"+bean_name);
	//newbarcode = bean.getNewBarCode();
	//System.out.println("newbarcode"+newbarcode);
		
	%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad='focusObject();enabledisable();'>
<form name='formbarcoderule' id='formbarcoderule' >

<table width='98%' align='center' cellspacing='0' cellpadding='0'>

<tr>
		<td align="left" class="label"><fmt:message key="eST.GenerateBarCode.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		<input type='radio'  id="barcode_gen_1" <%=bean.getBarcode_gen_rule().equals("M")?"checked":""%> name="barcode_gen_rule" value="M" onclick="enabledisable();">
		&nbsp;&nbsp;<fmt:message key="eST.Manually.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;

		<input type='radio' id="barcode_gen_2" <%=bean.getBarcode_gen_rule().equals("S")?"checked":""%> name="barcode_gen_rule" value="S" onclick="enabledisable();">
		&nbsp;&nbsp;<fmt:message key="eST.SystemGenerated.label" bundle="${st_labels}"/>&nbsp;
		<% if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {%>
		<input type='radio' id="barcode_gen_3" checked name="barcode_gen_rule" id="barcode_gen_rule" value="P" onclick="enabledisable();">
		&nbsp;&nbsp;<fmt:message key="eST.PredefinedRules.label" bundle="${st_labels}"/>&nbsp;
		<%} else{%>

		<input type='radio' id="barcode_gen_3" <%=bean.getBarcode_gen_rule().equals("P")?"checked":""%> name="barcode_gen_rule" value="P" onclick="enabledisable();">
		&nbsp;&nbsp;<fmt:message key="eST.PredefinedRules.label" bundle="${st_labels}"/>&nbsp;
		<%}%>
	</table></td></tr></table><tr></tr><tr></tr>


<table width='98%' ><th width='20%' ><fmt:message key="eST.SequenceSelection.label" bundle="${st_labels}"/></td>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr></tr><tr></tr><tr></tr>
<tr><td width='60%' > <p  title='Sequence Selection'><table width='100%'><td align='center'><b><fmt:message key="eST.AllElements.label" bundle="${st_labels}"/></td><td>&nbsp;</td><td align='center'><b><fmt:message key="eST.BarCodeElements.label" bundle="${st_labels}"/></td>
	<% if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {%>
<tr>
<td width='45%' align=center ><select name='all_elements' id='all_elements' size='10'   >
	
	<option   value='N'><fmt:message key="eST.FacilityId.label" bundle="${st_labels}"/></option>
	<option   value='N'><fmt:message key="eST.TradeId.label" bundle="${st_labels}"/></option>
	<option   value='N'><fmt:message key="eST.ManufacturerId.label" bundle="${st_labels}"/></option>
	<option   value='N'><fmt:message key="eST.SupplierId.label" bundle="${st_labels}"/></option>
	<option   value='N'><fmt:message key="eST.StoreCode.label" bundle="${st_labels}"/></option>
	<option   value='N'><fmt:message key="eST.BinLocation.label" bundle="${st_labels}"/></option>
	<option   value='N'><fmt:message key="eST.MRP.label" bundle="${st_labels}"/></option></select></td>

<td align='center' width='3%' ><input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'>
<input type='button' name='remove' id='remove' class='button'  value='<----' onclick='removeOrderByCol()'></td>
<td width='45%' align='center'><select name='barcode_elements' id='barcode_elements' size='10' >
<option  value='Y'><fmt:message key="eST.ItemCode.label" bundle="${st_labels}"/></option>
<option   value='Y'><fmt:message key="eST.BatchId.label" bundle="${st_labels}"/></option>
<option  value='Y'><fmt:message key="eST.ExpiryDate.label" bundle="${st_labels}"/></option></select>&nbsp;&nbsp;
<img src='../../eCommon/images/up.gif' type='button' width='2%' name='moveup' class='button' onclick="listbox_move('barcode_elements', 'up');" ></img>
<img src='../../eCommon/images/down.gif' type='button' width='2%' name='movedown' class='button' onclick="listbox_move('barcode_elements', 'down');" ></img></td></td></tr>
<%}else{%>
<tr>
<td width='45%' align=center ><select name='all_elements' id='all_elements' size='10' >
	<%if(bean.getItem_yn().equals("N")) {%>
	<option  value='N'><fmt:message key="eST.ItemCode.label" bundle="${st_labels}"/></option>
	<%} if(bean.getBatch_id_yn().equals("N")) {%>
	<option   value='N'><fmt:message key="eST.BatchId.label" bundle="${st_labels}"/></option>
	<%}  if(bean.getExpiry_dt_yn().equals("N")) {%>
	<option  value='N'><fmt:message key="eST.ExpiryDate.label" bundle="${st_labels}"/></option>
	<%}if(bean.getFacility_id_yn().equals("N")) {%>
	<option   value='N'><fmt:message key="eST.FacilityId.label" bundle="${st_labels}"/></option>
	<%}  if(bean.getTrade_id_yn().equals("N")) {%>
	<option   value='N'><fmt:message key="eST.TradeId.label" bundle="${st_labels}"/></option>
	<%}  if(bean.getMfg_id_yn().equals("N")) {%>
	<option   value='N'><fmt:message key="eST.ManufacturerId.label" bundle="${st_labels}"/></option>
	<%}  if(bean.getSupp_id_yn().equals("N")) {%>
	<option   value='N'><fmt:message key="eST.SupplierId.label" bundle="${st_labels}"/></option>
	<%}  if(bean.getStore_code_yn().equals("N")) {%>
	<option   value='N'><fmt:message key="eST.StoreCode.label" bundle="${st_labels}"/></option>
	<%}  if(bean.getBin_locn_yn().equals("N")) {%>
	<option   value='N'><fmt:message key="eST.BinLocation.label" bundle="${st_labels}"/></option>
	<%}  if(bean.getMrp_yn().equals("N")) {%>
	<option   value='N'><fmt:message key="eST.MRP.label" bundle="${st_labels}"/></option><%}%></select></td>
	

<td align='center' width='3%' ><input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'>
<input type='button' name='remove' id='remove' class='button'  value='<----' onclick='removeOrderByCol()'></td>
<td width='45%' align='center'><select name='barcode_elements' id='barcode_elements' size='10' >
<%try{
		HashMap hmTemp	=	(HashMap)bean.fetchRecord("SELECT	BARCODE_SEQ FROM ST_ITEM_BARCODE_RULES WHERE FACILITY_ID=?",bean.getLoginFacilityId());
		newbarcode = (String)hmTemp.get("BARCODE_SEQ");
			System.out.println("newbarcode"+newbarcode);
			StringTokenizer StBarcodeRules = new StringTokenizer(newbarcode,"-");
			System.out.println("StBarcodeRules"+StBarcodeRules);

			while (StBarcodeRules.hasMoreTokens()) {

				String temp = StBarcodeRules.nextToken();
				System.out.println("temp"+temp);
				if(temp.equals("F")) {%>
				<option  value='Y'><fmt:message key="eST.FacilityId.label" bundle="${st_labels}"/></option>
				<%}if(temp.equals("I")) {%>
				<option  value='Y'><fmt:message key="eST.ItemCode.label" bundle="${st_labels}"/></option>
				<%}else if(temp.equals("B")) {%>
				<option   value='Y'><fmt:message key="eST.BatchId.label" bundle="${st_labels}"/></option>
				<%}else if(temp.equals("E")) {%>
				<option  value='Y'><fmt:message key="eST.ExpiryDate.label" bundle="${st_labels}"/></option>
				<%}else if(temp.equals("T")) {%>
				<option   value='Y'><fmt:message key="eST.TradeId.label" bundle="${st_labels}"/></option>
				<%}else if(temp.equals("BI")) {%>
				<option   value='Y'><fmt:message key="eST.BinLocation.label" bundle="${st_labels}"/></option>
				<%}else if(temp.equals("MA")) {%>
				<option   value='Y'><fmt:message key="eST.ManufacturerId.label" bundle="${st_labels}"/></option>
				<%}else if(temp.equals("SU")) {%>
				<option   value='Y'><fmt:message key="eST.SupplierId.label" bundle="${st_labels}"/></option>
				<%}else if(temp.equals("S")) {%>
				<option   value='Y'><fmt:message key="eST.StoreCode.label" bundle="${st_labels}"/></option>
				<%}else if(temp.equals("MR")) {%>
				<option   value='Y'><fmt:message key="eST.MRP.label" bundle="${st_labels}"/></option>
				<%}%>
			<%}%>
		<%} catch (Exception e) {
            e.printStackTrace();
        }%>
</select>&nbsp;&nbsp;
<img src='../../eCommon/images/up.gif' type='button' width='2%' name='moveup' class='button' onclick="listbox_move('barcode_elements', 'up');" ></img>
<img src='../../eCommon/images/down.gif' type='button' width='2%' name='movedown' class='button' onclick="listbox_move('barcode_elements', 'down');" ></img></td></td></tr>
<%}%>

</table>
	</p>
	</td>

	</table>
	<% if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {%>
	
	<input type="hidden" name="facility_id_yn" id="facility_id_yn" value="N">
	<input type="hidden" name="trade_id_yn" id="trade_id_yn" value="N">
	<input type="hidden" name="mfg_id_yn" id="mfg_id_yn" value="N">
	<input type="hidden" name="supp_id_yn" id="supp_id_yn" value="N">
	<input type="hidden" name="store_code_yn" id="store_code_yn" value="N">
	<input type="hidden" name="bin_locn_yn" id="bin_locn_yn" value="N">
	<input type="hidden" name="mrp_yn" id="mrp_yn" value="N">
	<input type="hidden" name="item_yn" id="item_yn" value="Y">
	<input type="hidden" name="batch_id_yn" id="batch_id_yn" value="Y">
	<input type="hidden" name="expiry_dt_yn" id="expiry_dt_yn" value="Y">
	<input type="hidden" name="barcode_seq" id="barcode_seq" value="I-B-E">
	
	<%}else{%>
	
	<input type="hidden" name="facility_id_yn" id="facility_id_yn" value="<%=bean.getFacility_id_yn()%>">
	<input type="hidden" name="trade_id_yn" id="trade_id_yn" value="<%=bean.getTrade_id_yn()%>">
	<input type="hidden" name="mfg_id_yn" id="mfg_id_yn" value="<%=bean.getMfg_id_yn()%>">
	<input type="hidden" name="supp_id_yn" id="supp_id_yn" value="<%=bean.getSupp_id_yn()%>">
	<input type="hidden" name="store_code_yn" id="store_code_yn" value="<%=bean.getStore_code_yn()%>">
	<input type="hidden" name="bin_locn_yn" id="bin_locn_yn" value="<%=bean.getBin_locn_yn()%>">
	<input type="hidden" name="mrp_yn" id="mrp_yn" value="<%=bean.getMrp_yn()%>">
	<input type="hidden" name="item_yn" id="item_yn" value="<%=bean.getItem_yn()%>">
	<input type="hidden" name="batch_id_yn" id="batch_id_yn" value="<%=bean.getBatch_id_yn()%>">
	<input type="hidden" name="expiry_dt_yn" id="expiry_dt_yn" value="<%=bean.getExpiry_dt_yn()%>">
	<input type="hidden" name="barcode_seq" id="barcode_seq" value="<%=bean.getBarcode_seq()%>">
	<%}%>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="barcode_gen_rules" id="barcode_gen_rules" value="<%=bean.getBarcode_gen_rule()%>">
	</form>
	<%
		
putObjectInBean("StDefineBarcodeRulesBean",bean,request);
%>
	</body>
	</html>

<%}catch(Exception e){
	e.printStackTrace();
}%>

