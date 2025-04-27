<!DOCTYPE html>
<%
/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210217            14525 	       	MMS-QH-CRF-0128.2		       Nandhini M 
2			 V160522							MMS-QH-CRF-0128.4			   Nandhini M 
 */
%>

<%@page import="eBL.BlServiceDiscPriceBean"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@page import="java.util.*,java.sql.*, webbeans.eCommon.*, eCommon.Common.*,java.util.*,java.lang.*,java.text.*" contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			int tableIndex = 1; // added against 128.2
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id;
	String mode = checkForNull(request.getParameter("mode"));
	String bean_id					= "BlServiceDiscPriceBean" ;
	String bean_name				= "eBL.BlServiceDiscPriceBean";
	BlServiceDiscPriceBean blDiscPriceBean = null;
	BlServiceDiscPriceBean bean	= (BlServiceDiscPriceBean)getBeanObject( bean_id, bean_name , request) ;
	BlServiceDiscPriceBean callingObj = new BlServiceDiscPriceBean();
	System.err.println("32,mode==>"+mode);
	if("modify".equals(mode)){
		facility_id = checkForNull(request.getParameter("facilityId"));
	}
	else{		
		facility_id = (String)session.getAttribute("facility_id");
	}			
			
	String servInd = request.getParameter("servInd");
	if(servInd == null) servInd = "";
	
	String servCode = request.getParameter("servCode");
	if(servCode == null) servCode = "";
	
	String priceInd = request.getParameter("priceInd");
	if(priceInd == null) priceInd = "";
	
	String priceCode = request.getParameter("priceCode");
	if(priceCode == null) priceCode = "";
	
	String policyCode = request.getParameter("policyCode");
	if(policyCode == null) policyCode = "";
	
	String custGrpCode = request.getParameter("custGrpCode");
	if(custGrpCode == null) custGrpCode = "";
	
	String blngClass = request.getParameter("blngClass");
	if(blngClass == null) blngClass = "";
	
	String service_code = request.getParameter("service_code");
	if(service_code == null) service_code = "";
	
	System.err.println("56,service_code==>"+service_code);
	if("A".equals(blngClass)){
		blngClass = "**";
	}
	String effFrom = request.getParameter("effFrom");
	String effTo = request.getParameter("effTo");
	
	String blngClassCode	="";		
	String ratePriceInd 	="";	
	String chkCostAvl 		="N";	
	String costInd 			=""; 	
	String costAmt 			="";	
	String ipRate 			="";
	String opRate 			="";			
	String emRate 			="";
	String exRate 			="";
	String dcRate 			="";
	String minCharge 		 ="";
	String maxCharge 		 ="";
	String baseQty 		     ="";
	String Applicability 		="";
	String applyDiscount 		="N";
	String priceEffFrom 		="";
	String priceEffTo 		="";	
	String publicchk 		="N";	
	String rateind 		="N";	
	String discStringForBlngClass = "";
	String pat_cat_code = "";
	System.err.println("80,servCode==>"+servCode);
	
	int pkgGrpEnabledCount = 0; // V211109
	boolean isPkgGrpEnabledYN = false; // V211109
	String disabledForPackageGroup = ""; // V211109	
			
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	
	try 
	{		
		connection = ConnectionManager.getConnection(request);
	
		//V211109
		try
		{
			String sql = "SELECT COUNT (*) FROM sm_function_control a, sm_site_param b  WHERE a.site_id = b.customer_id AND module_id = 'BL'  AND functionality_id = 'PACK_GRP_SETUP_AMD_PD'";
			System.out.println("sql for Package Group Function Control:"+sql);
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();	
			if(resultSet.next())
			{
				pkgGrpEnabledCount=resultSet.getInt(1);
				System.err.println("count for Package Group Function Control:"+pkgGrpEnabledCount);
			}		
			
			if(pkgGrpEnabledCount > 0)
				isPkgGrpEnabledYN = true;
			else
				isPkgGrpEnabledYN = false;
		}catch(Exception e){
			System.out.println("Exception in Package Group Function Control Query :"+e);
			e.printStackTrace();
		}finally{
			if(resultSet!=null) resultSet.close();
			if(pstmt!=null) pstmt.close();	
		}
		
		//Changes done for MMS-KH-SCF-0187 by Manivel N
		
		String materialItemYN=callingObj.isServMatBased(servCode,servInd);
		String isServiceChargeBasedYN=callingObj.isServMMBased(servCode);
		System.err.println("94,materialItemYN==>"+materialItemYN);
		System.err.println("95,isServiceChargeBasedYN==>"+isServiceChargeBasedYN);
		
		if("PG".equals(servInd)){
			disabledForPackageGroup = "disabled";
		} else {
			disabledForPackageGroup = "";
		}		
		
		if("modify".equals(mode))
		{
			blDiscPriceBean = callingObj.loadDescriptions(facility_id, servInd, servCode, priceInd, priceCode, custGrpCode, policyCode, blngClass, locale, effFrom, mode, effTo);
				
			blngClassCode	= blDiscPriceBean.getBlngClassCode();
			pat_cat_code = callingObj.getBlngClassType(blngClassCode);
			System.err.println("pat_cat_code:"+pat_cat_code);

			// Added disabledForPackageGroup condition for enable/disable Rate option for V211109
			if("PG".equals(blDiscPriceBean.getServInd())){
				disabledForPackageGroup = "disabled";
			} else {
				disabledForPackageGroup = "";
			}
			System.err.println("disabledForPackageGroup--"+disabledForPackageGroup);		
			
		}
%>

<html>
<head>
<script>
function fnApplyDiscPrice(val,index)
	{
		var selBlngClass = document.getElementById("billing_class"+index).value;
		var effFromDate = document.getElementById("effFromDate"+index).value;
		var effToDate = document.getElementById("effToDate"+index).value;

		if(selBlngClass == ''){
			alert("Billing Class Cannot be Blank");
			document.getElementById('apply_discount'+index).checked = false;
			document.getElementById("billing_class"+index).focus();
			return false;
		}
		
		if(effFromDate == ''){
			alert("Effective From cannot be Blank");
			document.getElementById('apply_discount'+index).checked = false;
			document.getElementById("effFromDate"+index).focus();
			return false;
		}
		
		if(val.checked==true || val.checked=='true'){
			document.getElementById('apply_discount'+index).value='Y';
			document.getElementById('applydiscount'+index).value='Y';
			parent.BLMultiDiscPrice.location.href ='../../eBL/jsp/BLMultiDiscPriceCreate.jsp'+"?selBlngClass="+selBlngClass+"&effFromDate="+effFromDate+"&effToDate="+effToDate;		
			document.getElementById("dtls"+index).disabled=false;
			document.getElementById("dtls"+index).className = "";
			document.getElementById("indexSelected").value=index;
		}else{
			document.getElementById('apply_discount'+index).value='N';
			document.getElementById('applydiscount'+index).value='N';
			parent.BLMultiDiscPrice.location.href ='../../eCommon/html/blank.html';
			document.getElementById("dtls"+index).disabled=true;
			document.getElementById("dtls"+index).className = "disabled";
			document.getElementById("indexSelected").value='';
			//document.getElementById("isDiscountSavedYN_"+index).value="Y";
		}
		//alert("after jsp");
	}
	
function fnPublicChk(val,index)
	{
		var applicability=document.getElementById('applicability'+index).value;
		var BillingClass= document.getElementById('billing_class'+index).value;
		var priceInd= document.getElementById('price_ind_bot'+index).value;
		var effFromDate= document.getElementById('effFromDate'+index).value;
		if(BillingClass==""){
			alert("Billing Class Cannot be Null");
			return false;
		}
		else if(priceInd==""){
			alert("Rate/Factor Cannot be Null");
			return false;
		}
		else if(effFromDate==""){
		alert("Effective From Date Cannot be Null");
		return false;		
		}
		else if(applicability==""){
			alert("Applicability Cannot Be Null");
			return false;
		}
		if(val.checked==true || val.checked=='true'){
			document.getElementById('public_chk'+index).value='Y';
			document.getElementById('publicchk'+index).value='Y';
			
		}else{
			document.getElementById('public_chk'+index).value='N';
			document.getElementById('publicchk'+index).value='N';
			
		}
		//alert("after jsp");
	}
	
function priceindbot(val,index)
	{
		document.getElementById('price_ind_bot'+index).value=val.value;
		var price_ind_bot=document.getElementById('price_ind_bot'+index).value;
		//alert("241,price_ind_bot:::"+price_ind_bot);
		document.getElementById('priceindbot'+index).value=val.value;
		var servCode = parent.BLServiceDiscPrice.frmDiscPriceCreate.service_code.value;
		//alert("servCode==>"+servCode);
	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var temp_jsp="../../eBL/jsp/BLServiceDiscPriceValidation.jsp?servCode="+servCode+"&functionMode=isServiceChargeBasedYN";
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	
		if(retVal=="Y" && price_ind_bot=="R")
		{
			alert("Please Select Factor For Charge Based Services");
			document.getElementById('price_ind_bot'+index).value='';
			return false;
		} 
	}
function publicBasisPH(val,index)
	{
	var servCode = parent.BLServiceDiscPrice.frmDiscPriceCreate.service_code.value;
	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var temp_jsp="../../eBL/jsp/BLServiceDiscPriceValidation.jsp?servCode="+servCode+"&functionMode=isServiceChargeBasedYN";
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	}
	
function applicabilitychg(val,index)
	{
		document.getElementById('applicability'+index).value=val.value;
		document.getElementById('applicability'+index).value=val.value;
		//alert("after document.getElementById('applicability'+index).value--"+document.getElementById('applicability'+index).value);
	}
	
function rateBasisInd(val,index)
	{
		var applicability=document.getElementById('applicability'+index).value;
		var BillingClass= document.getElementById('billing_class'+index).value;
		var priceInd= document.getElementById('price_ind_bot'+index).value;
		var effFromDate= document.getElementById('effFromDate'+index).value;
		if(BillingClass==""){
			alert("Billing Class Cannot be Null");
			return false;
		}
		else if(priceInd==""){
			alert("Rate/Factor Cannot be Null");
			return false;
		}
		else if(effFromDate==""){
		alert("Effective From Date Cannot be Null");
		return false;		
		}
		else if(applicability==""){
			alert("Applicability Cannot Be Null");
			return false;
		}
		
		document.getElementById('rateBasisInd'+index).value=val.value;
		document.getElementById('rate_Basis_Ind'+index).value=val.value;
		//alert("after document.getElementById('rate_Basis_Ind'+index).value--"+document.getElementById('rate_Basis_Ind'+index).value);
	}
	
function costind(val,index)
	{
		document.getElementById('cost_ind'+index).value=val.value;
		document.getElementById('costind'+index).value=val.value;
		//alert("after document.getElementById('costind'+index).value--"+document.getElementById('costind'+index).value);
	}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLServiceDiscountPrice.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<STYLE TYPE="text/css">
div.tableContainer {
	width: 100%;		/* table width will be 99% of this*/
	height: 460px; 	/* must be greater than tbody*/
	overflow: auto;
	margin: 0 auto;
}
table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
 /*thead tr	{     added against MMS-QH-CRF-0128.4 */
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}	*/	

		TD.YELLOW 
		{			
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		
		.LocalYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border: 1x;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
SPAN.LABEL
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT;
  /*TEXT-ALIGN: RIGHT;*/
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}
SPAN.SpanYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
A.disabled
{
  color: #A0A0A0;	
}
		
</STYLE>
</head>
<!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->
<%
if("modify".equals(mode)){
%>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onload="changeFieldColor('<%= tableIndex%>'); showDiscAvailable('<%= tableIndex%>');">
<%}else{%>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();">
<%}%>
	<form  method='post' name = 'Pricedtlsbulkadd' id='Pricedtlsbulkadd'>	
	<div id="tableContainer">	
      		<table cellpadding=0 cellspacing=3  width="100%" id='Multipricebulkupd' name='Multipricebulkupd' id='Multipricebulkupd'>
				
		<tr>
			<td colspan='19' align="left" nowrap><fmt:message key="eBL.PriceDetails.label" bundle="${bl_labels}"></fmt:message> </td>
		</tr>
		<tr>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.BillingClass.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.FactorRate.label" bundle="${bl_labels }"></fmt:message>	
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.EffectiveFrom.Label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.EffectiveTo.Label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.IP_amt.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.OP_amt.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.EM_amt.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.EX_amt.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.DC_amt.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.Applicability.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.BASE_QTY.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.Public.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.Basis.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.MIN_CHARGE.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.MAX_CHARGE.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.ChkCostAvl.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.CostIndicator.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left">
				<fmt:message key="eBL.CostAmt.label" bundle="${bl_labels }"></fmt:message>
			</th>
			<th class='columnheader'	width='4%'	align="left" colspan=2>
				<fmt:message key="eBL.Discount.label" bundle="${bl_labels }"></fmt:message>
			</th>

      		</tr>
			<%
				if("modify".equals(mode)){
					
					ArrayList blDiscPrceBean = (ArrayList)bean.getloadpricecls(facility_id, servInd, servCode, priceInd, priceCode, custGrpCode, policyCode, blngClass, locale, effFrom, mode, effTo);
					System.err.println("blDiscPriceBean rec size-"+blDiscPrceBean.size());
			
			if(blDiscPrceBean.size()!=0){
				for(int i=0;i<blDiscPrceBean.size();i=i+19){
				
					%>
					<!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->
			<tr onclick="changeFieldColor('<%= tableIndex%>'); if(alrdSelect('<%= tableIndex%>')){showDiscAvailable('<%= tableIndex%>');}">
			
			<td id='blng_class<%= tableIndex%>' width='10%' nowrap class='fields'>
      				<input type="text" name='billing_class<%= tableIndex%>' id='billing_class<%= tableIndex%>' id='billing_class<%= tableIndex%>' size='20' maxlength="20" value="<%=blngClassCode%>" onKeypress="validatedtls();" readonly>
      				<input type='button' class='button' id='billing_class_btn<%= tableIndex%>' name="billing_class_btn<%= tableIndex%>" value='?' onClick="callCommonValidationDtls(1,billing_desc<%= tableIndex%>,billing_class<%= tableIndex%>,<%= tableIndex%>);" tabindex='2' disabled>
      				<img src='../../eCommon/images/mandatory.gif'>
					<input type="hidden"  name='billing_desc<%= tableIndex%>' id='billing_desc<%= tableIndex%>' id='billing_desc<%= tableIndex%>' value="" >				
      			</td>
				
				<td id='rateFactor<%= tableIndex%>' width='10%' nowrap class='fields'>
      				<!-- Modified By Nandhini rate/factor Readonly for MMS-QH-CRF-0128.4 -->
      				<select name='price_ind_bot<%= tableIndex%>' id='price_ind_bot<%= tableIndex%>' id='price_ind_bot<%= tableIndex%>' onChange='priceindbot(this,<%= tableIndex%>)' disabled >
      					<option value='' <%=(blDiscPrceBean.get(i)).equals("")?"selected":""%>><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      					<option value="R" <%=(blDiscPrceBean.get(i)).equals("R")?"selected":""%> <%=disabledForPackageGroup%>><fmt:message key="eBL.RATE.label" bundle="${bl_labels }"></fmt:message> </option>
      					<option value="F" <%=(blDiscPrceBean.get(i)).equals("F")?"selected":""%>><fmt:message key="eBL.FACTOR.label" bundle="${bl_labels }"></fmt:message> </option>
      				</select> 
					<img src='../../eCommon/images/mandatory.gif'>
      			</td>				
			<td id='effectiveFrmDate<%= tableIndex%>' width='20%' nowrap class='fields'>							
				<input type='text' name='effFromDate<%= tableIndex%>' id='effFromDate<%= tableIndex%>' id='effFromDate<%= tableIndex%>'size='10' maxlength='10' onBlur='isValidDate(this,"EF",<%= tableIndex%>);' value='<%=blDiscPrceBean.get(i+1)%>' readonly />
				<img src='../../eCommon/images/CommonCalendar.gif'  id='effFromDate_ctrl<%= tableIndex%>' onClick="return showCalendar('effFromDate<%= tableIndex%>');" disabled />&nbsp;<img src='../../eCommon/images/mandatory.gif'>&nbsp;
			</td>
			<td id='effectivetoDate<%= tableIndex%>' width='20%' nowrap class='fields'>
				<input type='text' name='effToDate<%= tableIndex%>' id='effToDate<%= tableIndex%>' id='effToDate<%= tableIndex%>'  size='10' maxlength='10' onBlur='isValidDate(this,"ET",<%= tableIndex%>); discdate(<%= tableIndex%>);' value='<%=blDiscPrceBean.get(i+2)%>' <%= !"".equals(blDiscPrceBean.get(i+2)) ? "readonly":""%> />
				<img src='../../eCommon/images/CommonCalendar.gif'  id='effToDate_ctrl<%= tableIndex%>' onClick="return showCalendar('effToDate<%= tableIndex%>');" <%= !"".equals(blDiscPrceBean.get(i+2)) ? "disabled":""%> />
			</td>
			<td id='disc_ip<%= tableIndex%>' width='10%' nowrap class='fields'>
				<input style="padding:0px" type="text" name='discPer_ip<%= tableIndex%>' id='discPer_ip<%= tableIndex%>' id='discPer_ip<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this,<%= tableIndex%>,'ip')" size='10' maxlength="10" value='<%=blDiscPrceBean.get(i+3)%>' <%=("I".equals(pat_cat_code) || "**".equals(blngClassCode)) ? "" : "readonly"%> />
			</td>
			<td id='disc_op<%= tableIndex%>' width='10%' nowrap class='fields'>
				<input  style="padding:0px" type="text" name='discPer_op<%= tableIndex%>' id='discPer_op<%= tableIndex%>' id='discPer_op<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this,<%= tableIndex%>,'op')" size='10' maxlength="10" value='<%=blDiscPrceBean.get(i+4)%>' <%=("O".equals(pat_cat_code) || "**".equals(blngClassCode)) ? "" : "readonly"%>/>
			</td>			
			<td id='disc_em<%= tableIndex%>' width='10%' nowrap class='fields'>
				<input  style="padding:0px"  type="text" name='discPer_em<%= tableIndex%>' id='discPer_em<%= tableIndex%>' id='discPer_em<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this,<%= tableIndex%>,'em')" size='10' maxlength="10" value='<%=blDiscPrceBean.get(i+5)%>' <%=("E".equals(pat_cat_code) || "**".equals(blngClassCode)) ? "" : "readonly"%>/>
			</td>
			<td id='disc_ex<%= tableIndex%>' width='10%' nowrap class='fields'>
				<input   style="padding:0px" type="text" name='discPer_ex<%= tableIndex%>' id='discPer_ex<%= tableIndex%>' id='discPer_ex<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this,<%= tableIndex%>,'ex')" size='10' maxlength="10" value='<%=blDiscPrceBean.get(i+6)%>' <%=("X".equals(pat_cat_code) || "**".equals(blngClassCode)) ? "" : "readonly"%>/>
			</td>
			<td id='disc_dc<%= tableIndex%>' width='10%' nowrap class='fields'>
				<input  style="padding:0px" type="text" name='discPer_dc<%= tableIndex%>' id='discPer_dc<%= tableIndex%>' id='discPer_dc<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this,<%= tableIndex%>,'dc')" size='10' maxlength="10" value='<%=blDiscPrceBean.get(i+7)%>' <%=("D".equals(pat_cat_code) || "**".equals(blngClassCode)) ? "" : "readonly"%>/>
			</td>
			<!-- Modified By Nandhini applicability Readonly for MMS-QH-CRF-0128.4 -->
			<td id='applblty<%= tableIndex%>' width='10%' nowrap class='fields'>
				<select name='applicability<%= tableIndex%>' id='applicability<%= tableIndex%>' id='applicability<%= tableIndex%>' disabled onChange="applicabilitychg(this,<%= tableIndex%>)" readonly>
      					<option value='' <%=(blDiscPrceBean.get(i+8)).equals("")?"selected":""%>><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      					<option value="G" <%=(blDiscPrceBean.get(i+8)).equals("G")?"selected":""%>><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"></fmt:message> </option>
      					<option value="N" <%=(blDiscPrceBean.get(i+8)).equals("N")?"selected":""%>><fmt:message key="eBL.Net.label" bundle="${bl_labels}"></fmt:message></option>
				</select> <img src='../../eCommon/images/mandatory.gif'>
			</td>
			<!-- Modified By Nandhini baseQty Readonly for MMS-QH-CRF-0128.4 -->
			<td id='base_quanty<%= tableIndex%>' width='10%' nowrap class='fields'>
			<input type="text" name='base_qty<%= tableIndex%>' id='base_qty<%= tableIndex%>' id='base_qty<%= tableIndex%>' readonly onkeypress="return checkForNumChars(event)" onblur="checkForNumber(this,<%= tableIndex%>)" size='10' maxlength="10" value='<%=blDiscPrceBean.get(i+9)%>' readonly />
			</td>
			<td id='public_check<%= tableIndex%>' width='5%' nowrap class='fields'>
		      		<input type="checkbox" name='public_chk<%=tableIndex%>' id='public_chk<%=tableIndex%>' id='public_chk<%=tableIndex%>' disabled onclick='fnPublicChk(this,<%= tableIndex%>);' 
					value='<%=blDiscPrceBean.get(i+10)%>' <%="Y".equals(blDiscPrceBean.get(i+10))?"checked":""%>>
					<img id="isPublicMandEnableYN_<%= tableIndex%>" src='../../eCommon/images/mandatory.gif' style='<%=materialItemYN.equals("Y")? "visibility:visible" : "visibility:hidden"%>'>
			</td>
			<!-- Modified By Nandhini rateBasisInd Readonly for MMS-QH-CRF-0128.4 -->
			<td id='rtbasisInd<%= tableIndex%>' width='10%' nowrap class='fields'> 
			<select name='rateBasisInd<%= tableIndex%>' id='rateBasisInd<%= tableIndex%>' id='rateBasisInd<%= tableIndex%>' disabled onChange="rateBasisInd(this,<%= tableIndex%>)" readonly> 
		      			<option value='' <%=(blDiscPrceBean.get(i+11)).equals("")?"selected":""%>><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<option value='B'  <%=(blDiscPrceBean.get(i+11)).equals("B")?"selected":""%>><fmt:message key="eBL.BASE_PRICE.label" bundle="${bl_labels}"/></option>
						<option value='C' <%=(blDiscPrceBean.get(i+11)).equals("C")?"selected":""%>><fmt:message key="eBL.AVERAGE_COST.label" bundle="${bl_labels}"/></option>
						<option value='V' <%=(blDiscPrceBean.get(i+11)).equals("V")?"selected":""%>><fmt:message key="eBL.COMPUTED_VALUE.label" bundle="${bl_labels}"/></option>
					</select>
					<!-- //Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends-->
				<img id="isBasisEnableYN_<%= tableIndex%>" src='../../eCommon/images/mandatory.gif' style='<%=materialItemYN.equals("Y")? "visibility:visible" : "visibility:hidden"%>'>
			</td>
			<!-- Modified By Nandhini mincharge Readonly for MMS-QH-CRF-0128.4 -->
			<td id='mini_chrg<%= tableIndex%>' width='10%' nowrap class='fields'>
			<input type="text" name='min_charge<%= tableIndex%>' id='min_charge<%= tableIndex%>' id='min_charge<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this,<%= tableIndex%>,'mc')" size='10' maxlength="10" value='<%=blDiscPrceBean.get(i+12)%>' readonly />
			</td>
			<!-- Modified By Nandhini maxcharge Readonly for MMS-QH-CRF-0128.4 -->
			<td id='max_chrg<%= tableIndex%>' width='10%' nowrap class='fields'>
			<input type="text" name='max_charge<%= tableIndex%>' id='max_charge<%= tableIndex%>' id='max_charge<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this,<%= tableIndex%>,'maxc')" size='10' maxlength="10" value='<%=blDiscPrceBean.get(i+13)%>' readonly />
			</td>
			<td id='costAval<%= tableIndex%>' width='5%' nowrap class='fields'>
      			<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->
      			<input type="checkbox" name='checkCostAvl<%= tableIndex%>' id='checkCostAvl<%= tableIndex%>' id='checkCostAvl<%= tableIndex%>' disabled onclick= 'fnChkChkBox(this,<%= tableIndex%>);' value='<%=blDiscPrceBean.get(i+14)%>'  <%="Y".equals(blDiscPrceBean.get(i+14))?"checked":""%> />
			</td>
			<!-- Modified By Nandhini costInd Readonly for MMS-QH-CRF-0128.4 -->
			<td id='cost_indicator<%= tableIndex%>' width='10%' nowrap class='fields'>
				<select name='cost_ind<%= tableIndex%>' id='cost_ind<%= tableIndex%>' id='cost_ind<%= tableIndex%>' disabled onchange="costind(this,<%= tableIndex%>);" readonly >
      					<option value='' <%=(blDiscPrceBean.get(i+15)).equals("")?"selected":""%>><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      						<option value="A" <%=(blDiscPrceBean.get(i+15)).equals("A")?"selected":""%>><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"></fmt:message> </option>
	      					<option value="P" <%=(blDiscPrceBean.get(i+15)).equals("P")?"selected":""%>><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"></fmt:message></option>
      				</select>
      			</td>
				<!-- Modified By Nandhini costamt Readonly for MMS-QH-CRF-0128.4 -->
				<td id='cost_amount<%= tableIndex%>' width='10%' nowrap class='fields'>
      				<input type="text" name='cost_amt<%= tableIndex%>' id='cost_amt<%= tableIndex%>'  id='cost_amt<%= tableIndex%>' size='10' readonly maxlength="10" onblur="checkForNumberDecimal(this,<%= tableIndex%>,'ca')" value='<%=blDiscPrceBean.get(i+16)%>'>
      			</td>
				<%
				if((blDiscPrceBean.get(i+17)).equals("N")){
				%>
			<td id='apply_dis<%= tableIndex%>' width='5%' nowrap class='fields'>
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->
      				<input type="checkbox" name='apply_discount<%=tableIndex%>' id='apply_discount<%=tableIndex%>' id='apply_discount<%=tableIndex%>' disabled onclick='fnApplyDiscPrice(this,<%= tableIndex%>);' value='<%=blDiscPrceBean.get(i+17)%>' />
					<a href="#"  onclick="showDisc(<%=tableIndex%>)" name="dtls<%=tableIndex%>" id="dtls<%=tableIndex%>" disabled class="disabled" value="<%=blDiscPrceBean.get(i+18)%>" >Dtls</a>
					<input type='hidden' name='discStringForBlngClass_<%=tableIndex%>' id='discStringForBlngClass_<%=tableIndex%>' id='discStringForBlngClass_<%=tableIndex%>' value='<%=discStringForBlngClass%>' />					
			</td>
<%
			}
			else
			{
%>
			<td id='apply_dis<%= tableIndex%>' width='5%' nowrap class='fields'>
				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->
				<input type="checkbox" name='apply_discount<%=tableIndex%>' id='apply_discount<%=tableIndex%>' id='apply_discount<%=tableIndex%>' disabled onclick='fnApplyDiscPrice(this,<%= tableIndex%>);' checked value='<%=blDiscPrceBean.get(i+17)%>' />
				<a href="#" style="color: #696969;" onclick="showDiscMod(<%=tableIndex%>)" name="dtls<%=tableIndex%>" id="dtls<%=tableIndex%>" disabled class="disabled" value="<%=blDiscPrceBean.get(i+18)%>" >Dtls</a>
				<input type='hidden' name='discStringForBlngClass_<%=tableIndex%>' id='discStringForBlngClass_<%=tableIndex%>' id='discStringForBlngClass_<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+18)%>' />				
			</td>
<% 
			}
			
%>	
		<input type='hidden' name='discString<%=tableIndex%>' id='discString<%=tableIndex%>' id='discString<%=tableIndex%>' value=''><!--to catch the disc dtls-->				
				<input type='hidden' name='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' value=''>
				<input type='hidden' name='applydiscount<%=tableIndex%>' id='applydiscount<%=tableIndex%>' id='applydiscount<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+17)%>'>
				<input type='hidden' name='billingclass<%=tableIndex%>' id='billingclass<%=tableIndex%>' id='billingclass<%=tableIndex%>' value='<%=blngClassCode%>'>
				<input type='hidden' name='billingdesc<%=tableIndex%>' id='billingdesc<%=tableIndex%>' id='billingdesc<%=tableIndex%>' value=''>
				<input type='hidden' name='priceindbot<%=tableIndex%>' id='priceindbot<%=tableIndex%>' id='priceindbot<%=tableIndex%>' value='<%=blDiscPrceBean.get(i)%>'>
				<input type='hidden' name='effFrmDate<%=tableIndex%>' id='effFrmDate<%=tableIndex%>' id='effFrmDate<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+1)%>'>
				<input type='hidden' name='efftodate<%=tableIndex%>' id='efftodate<%=tableIndex%>' id='efftodate<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+2)%>'>
				<input type='hidden' name='discPerip<%=tableIndex%>' id='discPerip<%=tableIndex%>' id='discPerip<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+3)%>'>
				<input type='hidden' name='discPerop<%=tableIndex%>' id='discPerop<%=tableIndex%>' id='discPerop<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+4)%>'>
				<input type='hidden' name='discPerem<%=tableIndex%>' id='discPerem<%=tableIndex%>' id='discPerem<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+5)%>'>
				<input type='hidden' name='discPerex<%=tableIndex%>' id='discPerex<%=tableIndex%>' id='discPerex<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+6)%>'>
				<input type='hidden' name='discPerdc<%=tableIndex%>' id='discPerdc<%=tableIndex%>' id='discPerdc<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+7)%>'>
				<input type='hidden' name='Applicability<%=tableIndex%>' id='Applicability<%=tableIndex%>' id='Applicability<%=tableIndex%>' value='<%=(blDiscPrceBean.get(i+8))%>'>
				<input type='hidden' name='baseqty<%=tableIndex%>' id='baseqty<%=tableIndex%>' id='baseqty<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+9)%>'>
				<input type='hidden' name='publicchk<%=tableIndex%>' id='publicchk<%=tableIndex%>' id='publicchk<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+10)%>'>
				<input type='hidden' name='rate_Basis_Ind<%=tableIndex%>' id='rate_Basis_Ind<%=tableIndex%>' id='rate_Basis_Ind<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+11)%>'>
				<input type='hidden' name='mincharge<%=tableIndex%>' id='mincharge<%=tableIndex%>' id='mincharge<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+12)%>'>
				<input type='hidden' name='maxcharge<%=tableIndex%>' id='maxcharge<%=tableIndex%>' id='maxcharge<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+13)%>'>
				<input type='hidden' name='checkcostavl_<%=tableIndex%>' id='checkcostavl_<%=tableIndex%>' id='checkcostavl_<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+14)%>'>
				<input type='hidden' name='costind<%=tableIndex%>' id='costind<%=tableIndex%>' id='costind<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+15)%>'>
				<input type='hidden' name='costamt<%=tableIndex%>' id='costamt<%=tableIndex%>' id='costamt<%=tableIndex%>' value='<%=blDiscPrceBean.get(i+16)%>'>

				<input type='hidden' name='rowMode_<%=tableIndex%>' id='rowMode_<%=tableIndex%>' id='rowMode_<%=tableIndex%>' value='modify'>
				<input type='hidden' name='billingdesc<%=tableIndex%>' id='billingdesc<%=tableIndex%>' id='billingdesc<%=tableIndex%>' value=''>
				<input type='hidden' name='patCatCode_<%=tableIndex%>' id='patCatCode_<%=tableIndex%>' id='patCatCode_<%=tableIndex%>' value='<%=pat_cat_code%>'>					
				<input type='hidden' name='inclRowCnt' id='inclRowCnt' id='inclRowCnt' value='<%=tableIndex %>'>
				<input type='hidden' name='prevClicked' id='prevClicked' id='prevClicked' value="<%=tableIndex %>" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->
				<input type='hidden' name='indexSelected' id='indexSelected' id='indexSelected' value='<%=tableIndex %>'> <!--128.4-->
				<input type='hidden' name='isDiscSavedYN<%=tableIndex %>' id='isDiscSavedYN<%=tableIndex %>' value="N" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->				
		</tr>	
<%						tableIndex++;
				}	
				}
			}
			else
			{
%>
		<tr>
			<td width='10%' nowrap class='fields'>
      				<input type="text" name='billing_class<%= tableIndex%>' id='billing_class<%= tableIndex%>' id='billing_class<%= tableIndex%>' size='20' maxlength="20" value="" onKeypress="validatedtls(<%= tableIndex%>);" onblur="if(this.value!=''){callCommonValidationDtls(1,billing_desc<%= tableIndex%>,billing_class<%= tableIndex%>,<%= tableIndex%>);} else{ fnClearCode(billing_class<%= tableIndex%>); }">
					<input type='button' class='button' id='billing_class_btn<%= tableIndex%>' name="billing_class_btn<%= tableIndex%>" value='?' onClick="if(validatedtls()){  callCommonValidationDtls(1,billing_desc<%= tableIndex%>,billing_class<%= tableIndex%>,<%= tableIndex%>);}" tabindex='2'>
      				<img src='../../eCommon/images/mandatory.gif'>
					<input type="hidden"  name='billing_desc<%= tableIndex%>' id='billing_desc<%= tableIndex%>' id='billing_desc<%= tableIndex%>' value="">
			</td>
				
			<td width='10%' nowrap class='fields'>
				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->
				<!-- Added disabledForPackageGroup condition for enable/disable Rate option for V211109 -->
				<select name='price_ind_bot<%= tableIndex%>' id='price_ind_bot<%= tableIndex%>' id='price_ind_bot<%= tableIndex%>' onChange='if(validatedtls()){priceindbot(this,<%= tableIndex%>);}'>
					<option value='' ><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
					<option value="R" <%=disabledForPackageGroup%>><fmt:message key="eBL.RATE.label" bundle="${bl_labels }"></fmt:message> </option>
					<option value="F" ><fmt:message key="eBL.FACTOR.label" bundle="${bl_labels }"></fmt:message> </option>
				</select> 
				<img src='../../eCommon/images/mandatory.gif'>
			</td>				
			<td width='20%' nowrap class='fields'>							
				<input type='text' name='effFromDate<%= tableIndex%>' id='effFromDate<%= tableIndex%>' id='effFromDate<%= tableIndex%>'size='10' maxlength='10' onBlur='isValidDate(this,"EF",<%= tableIndex%>);checkDates(<%= tableIndex%>);callValidateDate(<%= tableIndex%>)' value='' />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='effFromDate_ctrl<%= tableIndex%>' onClick="if(validatedtls()){return showCalendar('effFromDate<%= tableIndex%>');}"/>
					<img src='../../eCommon/images/mandatory.gif'>&nbsp;
			</td>
					<td width='20%' nowrap class='fields'>
					<input type='text' name='effToDate<%= tableIndex%>' id='effToDate<%= tableIndex%>' id='effToDate<%= tableIndex%>'  size='10' maxlength='10' onBlur='isValidDate(this,"ET",<%= tableIndex%>);checkDates(<%= tableIndex%>);' value='' />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='effToDate_ctrl<%= tableIndex%>' onClick="if(validatedtls()){return showCalendar('effToDate<%= tableIndex%>');}" />
			</td>
			<td width='10%' nowrap class='fields'>
				<input type="text" name='discPer_ip<%= tableIndex%>' id='discPer_ip<%= tableIndex%>' id='discPer_ip<%= tableIndex%>' onkeypress="return checkForSpecChars(event);" onblur="if(validatedtls()){checkForNumberDecimal(this,<%= tableIndex%>,'ip');}else{ fnClearCode(discPer_ip<%= tableIndex%>); }" size='10' maxlength="10" value='' />
			</td>
			<td width='10%' nowrap class='fields'>
				<input type="text" name='discPer_op<%= tableIndex%>' id='discPer_op<%= tableIndex%>' id='discPer_op<%= tableIndex%>' onkeypress="return checkForSpecChars(event);" onblur="if(validatedtls()){checkForNumberDecimal(this,<%= tableIndex%>,'op');}else{ fnClearCode(discPer_op<%= tableIndex%>); }" size='10' maxlength="10" value='' />
			</td>			
			<td width='10%' nowrap class='fields'>
				<input type="text" name='discPer_em<%= tableIndex%>' id='discPer_em<%= tableIndex%>' id='discPer_em<%= tableIndex%>' onkeypress="return checkForSpecChars(event);" onblur="if(validatedtls()){checkForNumberDecimal(this,<%= tableIndex%>,'em');}else{ fnClearCode(discPer_em<%= tableIndex%>); }" size='10' maxlength="10" value='' />
			</td>
			<td width='10%' nowrap class='fields'>
				<input type="text" name='discPer_ex<%= tableIndex%>' id='discPer_ex<%= tableIndex%>' id='discPer_ex<%= tableIndex%>' onkeypress="return checkForSpecChars(event);" onblur="if(validatedtls()){checkForNumberDecimal(this,<%= tableIndex%>,'ex');}else{ fnClearCode(discPer_ex<%= tableIndex%>);}" size='10' maxlength="10" value='' />
			</td>
			<td width='10%' nowrap class='fields'>
				<input type="text" name='discPer_dc<%= tableIndex%>' id='discPer_dc<%= tableIndex%>' id='discPer_dc<%= tableIndex%>' onkeypress="return checkForSpecChars(event);" onblur="if(validatedtls()){checkForNumberDecimal(this,<%= tableIndex%>,'dc');}else{ fnClearCode(discPer_dc<%= tableIndex%>);}" size='10' maxlength="10" value='' />
			</td>
			<td width='10%' nowrap class='fields'>
				<select name='applicability<%= tableIndex%>' id='applicability<%= tableIndex%>' id='applicability<%= tableIndex%>' onChange="if(validatedtls()){applicabilitychg(this,<%= tableIndex%>);}">
      					<option value='' ><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      						<option value="G" selected><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"></fmt:message> </option>
      						<option value="N" ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"></fmt:message></option>
      				</select>
					<img src='../../eCommon/images/mandatory.gif'>
			</td>
			<td width='10%' nowrap class='fields'>
			<input type="text" name='base_qty<%= tableIndex%>' id='base_qty<%= tableIndex%>' id='base_qty<%= tableIndex%>' onkeypress="return checkForNumChars(event);" onblur="if(validatedtls()){checkForNumber(this,<%= tableIndex%>);}else{ fnClearCode(base_qty<%= tableIndex%>);}" size='10' maxlength="10" value='' />
			</td>
			<td width='5%' nowrap class='fields'>
		      	<input type="checkbox" name='public_chk<%=tableIndex%>' id='public_chk<%=tableIndex%>' id='public_chk<%=tableIndex%>' onclick='if(validatedtls()){fnPublicChk(this,<%= tableIndex%>);}' value=''> 
				<img id="isPublicMandEnableYN_<%= tableIndex%>" src='../../eCommon/images/mandatory.gif' style='<%=materialItemYN.equals("Y")? "visibility:visible" : "visibility:hidden"%>'>
			</td>
			<td width='10%' nowrap class='fields'> 
				<select name='rateBasisInd<%= tableIndex%>' id='rateBasisInd<%= tableIndex%>' id='rateBasisInd<%= tableIndex%>' onChange="if(validatedtls()){rateBasisInd(this,<%= tableIndex%>)}"> 
					<option value='' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<option value='B'  ><fmt:message key="eBL.BASE_PRICE.label" bundle="${bl_labels}"/></option>
					<option value='C'><fmt:message key="eBL.AVERAGE_COST.label" bundle="${bl_labels}"/></option>
					<option value='V'><fmt:message key="eBL.COMPUTED_VALUE.label" bundle="${bl_labels}"/></option>
					<img src='../../eCommon/images/mandatory.gif'>
				</select>
				<img id="isBasisEnableYN_<%= tableIndex%>" src='../../eCommon/images/mandatory.gif' style='<%=materialItemYN.equals("Y")? "visibility:visible" : "visibility:hidden"%>'>				
				
			<td width='10%' nowrap class='fields'>
			<input type="text" name='min_charge<%= tableIndex%>' id='min_charge<%= tableIndex%>' id='min_charge<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(validatedtls()){checkForNumberDecimal(this,<%= tableIndex%>,'mc');}else{fnClearCode(min_charge<%= tableIndex%>);}" size='10' maxlength="10" value='' />
			</td>
			<td width='10%' nowrap class='fields'>
			<input type="text" name='max_charge<%= tableIndex%>' id='max_charge<%= tableIndex%>' id='max_charge<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(validatedtls()){checkForNumberDecimal(this,<%= tableIndex%>,'maxc');}else{fnClearCode(max_charge<%= tableIndex%>);}" size='10' maxlength="10" value='' />
			</td>
			<td width='5%' nowrap class='fields'>
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->
      				<input type="checkbox" name='checkCostAvl<%= tableIndex%>' id='checkCostAvl<%= tableIndex%>' id='checkCostAvl<%= tableIndex%>' onclick= 'if(validatedtls()){fnChkChkBox(this,<%= tableIndex%>);}' value=''  />
			</td>
			<td width='10%' nowrap class='fields'>
				<select name='cost_ind<%= tableIndex%>' id='cost_ind<%= tableIndex%>' id='cost_ind<%= tableIndex%>' onchange="if(validatedtls()){costind(this,<%= tableIndex%>);}">
      					<option value='' ><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      						<option value="A" ><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"></fmt:message> </option>
	      					<option value="P" ><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"></fmt:message></option>
      				</select>
      			</td>
				<td width='10%' nowrap class='fields'>
      				<input type="text" name='cost_amt<%= tableIndex%>' id='cost_amt<%= tableIndex%>'  id='cost_amt<%= tableIndex%>' size='10' maxlength="10" onblur="if(validatedtls()){checkForNumberDecimal(this,<%= tableIndex%>,'ca');}else{fnClearCode(cost_amt<%= tableIndex%>);}" value=''>
      			</td>
			<td width='5%' nowrap class='fields'>
      				<input type="checkbox" name='apply_discount<%=tableIndex%>' id='apply_discount<%=tableIndex%>' id='apply_discount<%=tableIndex%>' onclick='fnApplyDiscPrice(this,<%= tableIndex%>);' value='N' />
					<a href="#" onclick="showDisc(<%=tableIndex%>)" name="dtls<%=tableIndex%>" id="dtls<%=tableIndex%>" disabled class="disabled" value="" >Dtls</a>
					<input type='hidden' name='isDiscountSavedYN_<%=tableIndex%>' id='isDiscountSavedYN_<%=tableIndex%>' id='isDiscountSavedYN_<%=tableIndex%>' value='Y'>					
					<input type='hidden' name='discStringForBlngClass_<%=tableIndex%>' id='discStringForBlngClass_<%=tableIndex%>' id='discStringForBlngClass_<%=tableIndex%>' value='<%=discStringForBlngClass%>' />					
			</td>			
			
			<input type='hidden' name='discString<%=tableIndex%>' id='discString<%=tableIndex%>' id='discString<%=tableIndex%>' value=''>			
			<input type='hidden' name='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' value=''>
			<input type='hidden' name='applydiscount<%=tableIndex%>' id='applydiscount<%=tableIndex%>' id='applydiscount<%=tableIndex%>' value='N'>
			<input type='hidden' name='billingclass<%=tableIndex%>' id='billingclass<%=tableIndex%>' id='billingclass<%=tableIndex%>' value=''>
			<input type='hidden' name='billingdesc<%=tableIndex%>' id='billingdesc<%=tableIndex%>' id='billingdesc<%=tableIndex%>' value=''>
			<input type='hidden' name='priceindbot<%=tableIndex%>' id='priceindbot<%=tableIndex%>' id='priceindbot<%=tableIndex%>' value=''>
			<input type='hidden' name='effFrmDate<%=tableIndex%>' id='effFrmDate<%=tableIndex%>' id='effFrmDate<%=tableIndex%>' value=''>
			<input type='hidden' name='efftodate<%=tableIndex%>' id='efftodate<%=tableIndex%>' id='efftodate<%=tableIndex%>' value=''>
			<input type='hidden' name='discPerip<%=tableIndex%>' id='discPerip<%=tableIndex%>' id='discPerip<%=tableIndex%>' value=''>
			<input type='hidden' name='discPerop<%=tableIndex%>' id='discPerop<%=tableIndex%>' id='discPerop<%=tableIndex%>' value=''>
			<input type='hidden' name='discPerem<%=tableIndex%>' id='discPerem<%=tableIndex%>' id='discPerem<%=tableIndex%>' value=''>
			<input type='hidden' name='discPerex<%=tableIndex%>' id='discPerex<%=tableIndex%>' id='discPerex<%=tableIndex%>' value=''>
			<input type='hidden' name='discPerdc<%=tableIndex%>' id='discPerdc<%=tableIndex%>' id='discPerdc<%=tableIndex%>' value=''>
			<input type='hidden' name='Applicability<%=tableIndex%>' id='Applicability<%=tableIndex%>' id='Applicability<%=tableIndex%>' value=''>
			<input type='hidden' name='baseqty<%=tableIndex%>' id='baseqty<%=tableIndex%>' id='baseqty<%=tableIndex%>' value=''>
			<input type='hidden' name='publicchk<%=tableIndex%>' id='publicchk<%=tableIndex%>' id='publicchk<%=tableIndex%>' value='N'>
			<input type='hidden' name='mincharge<%=tableIndex%>' id='mincharge<%=tableIndex%>' id='mincharge<%=tableIndex%>' value=''>
			<input type='hidden' name='maxcharge<%=tableIndex%>' id='maxcharge<%=tableIndex%>' id='maxcharge<%=tableIndex%>' value=''>
			<input type='hidden' name='checkcostavl_<%=tableIndex%>' id='checkcostavl_<%=tableIndex%>' id='checkcostavl_<%=tableIndex%>' value=''>
			<input type='hidden' name='costind<%=tableIndex%>' id='costind<%=tableIndex%>' id='costind<%=tableIndex%>' value=''>
			<input type='hidden' name='costamt<%=tableIndex%>' id='costamt<%=tableIndex%>' id='costamt<%=tableIndex%>' value=''>
			<input type='hidden' name='rate_Basis_Ind<%=tableIndex%>' id='rate_Basis_Ind<%=tableIndex%>' id='rate_Basis_Ind<%=tableIndex%>' value=''>
			<input type='hidden' name='rowMode_<%=tableIndex%>' id='rowMode_<%=tableIndex%>' id='rowMode_<%=tableIndex%>' value='add'>
			<input type='hidden' name='patCatCode_<%=tableIndex%>' id='patCatCode_<%=tableIndex%>' id='patCatCode_<%=tableIndex%>' value=''>
			<input type='hidden' name='inclRowCnt' id='inclRowCnt' id='inclRowCnt' value='<%=tableIndex %>'>
			<input type='hidden' name='prevClicked' id='prevClicked' id='prevClicked' value="<%=tableIndex %>" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->
			<input type='hidden' name='indexSelected' id='indexSelected' id='indexSelected' value='<%=tableIndex %>'> <!--128.4-->
			<input type='hidden' name='isDiscSavedYN<%=tableIndex %>' id='isDiscSavedYN<%=tableIndex %>' value="N" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->
</tr>	
<%
			}
%>
	</table>
	</div>	
	<table width='100%'>
		<tr>
			<td width='90%'> &nbsp;
			</td>
			<td width='10%' align='right'>
				<input type='button' name='priceBulkAdd' id='priceBulkAdd' id='priceBulkAdd' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onclick='addRow("pricedtlbulk")'>
			</td>
		</tr>
	</table>
	<input type='hidden' name='called' id='called' id='called' value='pricedtls'>
	<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='facilityid' id='facilityid' id='facilityid' value='<%=facility_id%>'>
	<input type='hidden' name='pricedtls' id='pricedtls' id='pricedtls' value=''>
	<input type='hidden' name='eachDisc' id='eachDisc' id='eachDisc' value=''>
	
	<input type='hidden' name='facility' id='facility' id='facility' value=''>
	<input type='hidden' name='service_ind' id='service_ind' id='service_ind' value=''>
	<input type='hidden' name='service_code' id='service_code' id='service_code' value=''>
	<input type='hidden' name='service_desc' id='service_desc' id='service_desc' value=''>
	<input type='hidden' name='price_ind' id='price_ind' id='price_ind' value=''>
	<input type='hidden' name='price_code' id='price_code' id='price_code' value=''>
	<input type='hidden' name='price_desc' id='price_desc' id='price_desc' value=''>
	<input type='hidden' name='cust_grp_code' id='cust_grp_code' id='cust_grp_code' value=''>
	<input type='hidden' name='cust_grp_desc' id='cust_grp_desc' id='cust_grp_desc' value=''>
	<input type='hidden' name='cust_code' id='cust_code' id='cust_code' value=''>
	<input type='hidden' name='cust_desc' id='cust_desc' id='cust_desc' value=''>
	<input type='hidden' name='mode' id='mode' id='mode' value='Add'>
	<input type='hidden' name='policy_code' id='policy_code' id='policy_code' value=''>
	<input type='hidden' name='policy_desc' id='policy_desc' id='policy_desc' value=''>
	<input type='hidden' name='materialItemYN' id='materialItemYN' id='materialItemYN' value='<%=materialItemYN%>'>	
	<input type='hidden' name='pat_cat_code' id='pat_cat_code' id='pat_cat_code' value='<%=pat_cat_code%>'>	
	
	</form>
</body>
</html>
<%
	}
	catch(Exception e) {
		System.err.println("Exception in BLAmendMultiServicePriceDtls.jsp:"+e);
		e.printStackTrace();
	} 
	finally{
		ConnectionManager.returnConnection(connection);
	}
%>	

