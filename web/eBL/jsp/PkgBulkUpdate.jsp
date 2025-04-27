<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
SNo			Version     TFS ID			CRF/SCF     			Developer Name
----------------------------------------------------------------------------------------------
1      		V210624     19511			MMS-DM-CRF-118.9        Nandhini M
----------------------------------------------------------------------------------------------
-->
<%-- Added by Rajesh V for MMS-CRF-0125
	Bulk Upadate page for Price Revision--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bulk Update</title>
</head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	//Added against MMS-DM-CRF-118.9
	String facilityId = (String)session.getAttribute("facility_id");
	String priceType = request.getParameter("priceType");
	//Added against MMS-DM-CRF-118.9
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonCalendar.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eBL/js/PkgBulkUpdate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	$(document).ready(function(){
		$('#priceBulkAdd').click(function(){
			addPriceBulkUpdate();
		});
		$('#priceBulkRemove').click(function(){
			fnBulkRemove();
		});
		//added against MMS-DM-CRF-118.9 and 21436 starts
		var priceType = $('#priceType').val();			
		if(priceType == 'S' || priceType == 'C'){				
			priceTypeCall(1);
		}
		//added against MMS-DM-CRF-118.9 ends
		/*$('#packageRate').click(function(){
			var discount = $(parent.lookUpData.document).find('#discountRate');
			$(discount).prop('checked',false);
		});*/
	});
	</script>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
<form name='bulkUpdateFrm' id='bulkUpdateFrm' id='bulkUpdateFrm'>
	<table id='bulkUpdateTbl' name='bulkUpdateTbl' id='bulkUpdateTbl' width="100%" align="center">
		<tr  style="padding-bottom: 10px;" >
			<td colspan="17" class='COLUMNHEADER' nowrap>Package Price Bulk Update</td>
		</tr>
		<tr>
			<td class='label' width="2%" style="padding-bottom: 5px;padding-top: 5px;padding-left: 10px;">
			<!-- <input type="checkbox" name="packageRate" id="packageRate" id='packageRate'>  -->&nbsp;
				<fmt:message key="eBL.PackageRate.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<!--added against MMS-DM-CRF-118.9 starts-->
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
			<fmt:message key="eBL.PKG_PRICE.label" bundle="${bl_labels }"></fmt:message>
				<img src='../../eCommon/images/mandatory.gif'> </td>
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
			<fmt:message key="eBL.VAT.label" bundle="${bl_labels }"></fmt:message><img src='../../eCommon/images/mandatory.gif'> </td>
			<!--added against MMS-DM-CRF-118.9-->
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
				<fmt:message key="eBL.PkgPriceType.label" bundle="${bl_labels }"></fmt:message>
				<img src='../../eCommon/images/mandatory.gif'>	
			</td>
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
				<fmt:message key="eBL.Percentage.label" bundle="${bl_labels }"></fmt:message>
				<img src='../../eCommon/images/mandatory.gif'>	
			</td>
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
				<fmt:message key="eBL.MarkUpOrDown.label" bundle="${bl_labels }"></fmt:message>
				<img src='../../eCommon/images/mandatory.gif'>	
			</td>
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
				<fmt:message key="eBL.RoundOff.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
				<fmt:message key="eBL.RoundUpOrDown.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<!--added against MMS-DM-CRF-118.9 starts-->
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
			<fmt:message key="eBL.VAT_APPLICABLE.label" bundle="${bl_labels }"></fmt:message> </td>
			<td width="1%" align='left' nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
			<fmt:message key="eBL.VAT_PERCENTAGE.label" bundle="${bl_labels }"></fmt:message> </td>
			<td></td>
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
			<fmt:message key="eBL.RULE_COVERAGE.label" bundle="${bl_labels }"></fmt:message> </td>
			<!--added against MMS-DM-CRF-118.9 ends-->
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
				<fmt:message key="eBL.EffectiveFrom.Label" bundle="${bl_labels }"></fmt:message>
				<img src='../../eCommon/images/mandatory.gif'>	
			</td>
			<td></td>
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;">
				<fmt:message key="eBL.EffectiveTo.Label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td></td>
			<td width="1%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
			</td>
			
		</tr>
		<tr rowValue='1' id='tr1'>
			<td width="1%" nowrap class='label' style="padding-left: 30px;" align="center">
				
			</td>
			<td width="1%"> <!--added against MMS-DM-CRF-118.9 starts-->
			<select name='pkgPrice1' id='pkgPrice1' id='pkgPrice1' onchange='PkgPriceVal("1")'>
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					<option value="R"><fmt:message key="eBL.Retainpackageprice.label" bundle="${bl_labels }"></fmt:message></option>
					<option value="I"><fmt:message key="eBL.Revisepackageprice.label" bundle="${bl_labels }"></fmt:message></option>					
				</select>
			<!--<input type='checkbox' name='Retpack' id='Retpack' id='Retpack' onclick='callfn("1")'-->
			</td>
			<td width="1%">
			<select name='VAT1' id='VAT1' id='VAT1' onchange='VatOption("1")'>
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					<option value="N"><fmt:message key="eBL.Retainvat.label" bundle="${bl_labels }"></fmt:message></option>
					<option value="E"><fmt:message key="eBL.Revisevat.label" bundle="${bl_labels }"></fmt:message></option>					
				</select></td> <!--added against MMS-DM-CRF-118.9 ends-->
			<td width="1%" >
				<select name='pkgPriceType1' id='pkgPriceType1' id='pkgPriceType1' onchange="checkForPerc(this,pkgPriceOrAmt1)">
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					<option value="P"><fmt:message key="eBL.Percentage.label" bundle="${bl_labels }"></fmt:message></option>										
				</select>
			</td>
			<td width="1%" >
				<input type='text' name='pkgPriceOrAmt1' id='pkgPriceOrAmt1' id='pkgPriceOrAmt1' size="10"  maxlength="15" onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(pkgPriceType1,this)'>&nbsp;
			</td>
			<td width="1%" >
				<select name='priceMarkUpDown1' id='priceMarkUpDown1' id='priceMarkUpDown1'>
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					<option value="U"><fmt:message key="Common.Up.label" bundle="${common_labels }"></fmt:message></option>
					<option value="D"><fmt:message key="eBL.DOWN.label" bundle="${bl_labels }"></fmt:message></option>					
				</select>
			</td>
			<td width="1%" >
				<input type='text' name='priceRoundOff1' id='priceRoundOff1' id='priceRoundOff1' size="10"  maxlength="15"  onkeypress='return checkAlpha(event)' onblur='checkForNumber(this)'>&nbsp;
			</td>
			<td width="1%" >
				<select name='priceRndMarkUpDown1' id='priceRndMarkUpDown1' id='priceRndMarkUpDown1'>
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					<option value="U"><fmt:message key="Common.Up.label" bundle="${common_labels }"></fmt:message></option>
					<option value="D"><fmt:message key="eBL.DOWN.label" bundle="${bl_labels }"></fmt:message></option>					
				</select>
			</td>
				<!--added against MMS-DM-CRF-118.9 starts-->
				<td width="1%"><input type='checkbox' name='VATapp1' id='VATapp1' id='VATapp1' onclick="VatCheckBox('1')"></td>
				<td width="1%" align='left'><input type='text' name='VATpercent1' id='VATpercent1' id='VATpercent1' size='10' maxlength='15'  onBlur="ruleCodeLookup(VATpercent1,'1')"/></td>
				<td><input type='button' class='button' align='left' name='VATpercent_temp1' id='VATpercent_temp1' id='VATpercent_temp1' value='?' onClick="ruleCodeLookup(VATpercent1,'1')"/></td>
				
				<td width="1%" >
				<select name='RuleCoverage1' id='RuleCoverage1' id='RuleCoverage1' >
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					<option value="S"><fmt:message key="eBL.AS_PER_POLICY.label" bundle="${bl_labels }"></fmt:message></option>
					<option value="C"><fmt:message key="eBL.PATIENT_COVERAGE.label" bundle="${bl_labels }"></fmt:message></option>
					<option value="P"><fmt:message key="eBL.PAYER_COVERAGE.label" bundle="${bl_labels }"></fmt:message></option>
				</select>
			</td>
				<!--added against MMS-DM-CRF-118.9 ends-->
				<td width="1%" >
				<input type='text' name='effFrom1' id='effFrom1'  id='effFrom1' size='10' maxlength='15' onBlur='validDateLocal(this,1,1);' value='' /></td>
				<td><img src='../../eCommon/images/CommonCalendar.gif'  id='pStartDate_ctrl1' onClick="return showCalendarLocal(1,1);" /></td>
			<td width="1%" >
				<input type='text' name='effTo1' id='effTo1'  id='effTo1' size='10' maxlength='10' onBlur='validDateLocal(this,2,1);' value='' /></td>
				<td><img src='../../eCommon/images/CommonCalendar.gif' id='dEndDate_ctrl1' onClick="return showCalendarLocal(2,1);" /></td>
			<td width="1%" >
				<input type='checkbox' name='bulkRemove1' id='bulkRemove1'  id='bulkRemove1'  />				
			</td>
		</tr>
	</table>
	<br/>
	<input type='hidden' name='lastRowIndex' id='lastRowIndex' id='lastRowIndex' value=''>
	<input type='hidden' name='locale' id='locale' id='locale' value="<%=locale %>">
	<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value='<%=facilityId %>' />
	<input type='hidden' name='priceType' id='priceType' id='priceType' value="<%=priceType%>">
	<table width='100%'>
		<tr>
			<td width='80%'>
			</td>
			<td width='10%'>
				<input type='button' name='priceBulkAdd' id='priceBulkAdd' id='priceBulkAdd' value='Add'>
			</td>
			<td width='10%'>
				<input type='button' name='priceBulkRemove' id='priceBulkRemove' id='priceBulkRemove' value='Remove'>
			</td>
		</tr>
	</table>
</form>
</body>
</html>

