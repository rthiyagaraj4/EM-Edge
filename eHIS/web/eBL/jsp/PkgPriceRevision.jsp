<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
SNo		Version     TFS ID			CRF/SCF     		Developer Name
------------------------------------------------------------------------------------------------
1      	V210624     19511		MMS-DM-CRF-118.9        Nandhini M
------------------------------------------------------------------------------------------------
-->
<%-- Added by Rajesh V for MMS-CRF-0125
	This page contains the Price Data selected by the user for Revision--%>
<%@page import="eBL.pkgpricerevision.request.PackagePriceBean"%>
<%@page import="eBL.pkgpricerevision.request.PkgPriceRevisionRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Package Price Revision</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String priceType = request.getParameter("priceType");
	String locale = (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getAttribute("facility_id");
	String beanId = "PkgPriceRevisionRequest" ;
	String beanName = "eBL.pkgpricerevision.request.PkgPriceRevisionRequest";
	PkgPriceRevisionRequest pkgPriceDiscount = null;
	List<PackagePriceBean> priceRevision = null;
	try{
		pkgPriceDiscount = (PkgPriceRevisionRequest) getObjectFromBean(beanId, beanName, session);
		if(pkgPriceDiscount.getPriceRevision() == null){
			pkgPriceDiscount.setPriceRevision(new ArrayList<PackagePriceBean>());
		}
		priceRevision = pkgPriceDiscount.getPriceRevision();		
	}
	catch(Exception e){
		e.printStackTrace();		
	}
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eBL/js/PkgBulkUpdate.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonCalendar.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	$(document).ready(function(){
		if($('#priceType').val() == 'S'){
			$('td[id^=hideCust]').each(function(){
				$(this).hide();
			});
		}		
		$("body").on("keydown", "input:text", function (e){			
			if($(this).prop('readonly') && e.which == 8){
				e.preventDefault();  
			    return false; 
			}
		});
	});
	</script>
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<form name='priceRevisionFrm' id='priceRevisionFrm' id='priceRevisionFrm' >
		<table id='priceRevisionTbl' name='priceRevisionTbl' id='priceRevisionTbl' width="100%" align="center" class='grid' border="1" cellpadding='3'  cellspacing=0>
			<tr>
				<td class='COLUMNHEADER' nowrap>
					Sno
				</td>
				<!-- Added against MMS-DM-CRF-118.9 starts -->
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.PKG_PRICE.label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.VAT.label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<!-- Added against MMS-DM-CRF-118.9 ends -->
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.PackageCode.Label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<td class='COLUMNHEADER' nowrap >
					<fmt:message key="eBL.PackageDesc.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap id='hideCustGroupTd'>
					<fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td class='COLUMNHEADER' nowrap id='hideCustTd'>
					<fmt:message key="eBL.Customer.label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.BillingClass.Label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>

				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.CurrentPrice.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap>
					Type
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.RevisedPrice.label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<td class='COLUMNHEADER' nowrap>
					Type
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<!--added against MMS-DM-CRF-118.9 starts-->
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.VAT_APPLICABLE.label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.VAT_PERCENTAGE.label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.RULE_COVERAGE.label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<!--added against MMS-DM-CRF-118.9 ends-->
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.EffectiveFrom.Label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.EffectiveTo.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td  class='COLUMNHEADER' nowrap>
					Select
				</td>
			</tr>
		<%
			int tableIndex = 1;
			String readOnly = "";
			String disabled = "";
			for(PackagePriceBean priceBean: priceRevision){ 
				if("U".equals(priceBean.getStatus())){
					readOnly = "readonly";
					disabled = "disabled";
				}
				else{
					readOnly = "";
					disabled = "";
				}
		%>
			<tr rowValue='<%=tableIndex %>' id='tr<%=tableIndex %>'>
				<td class='label' nowrap id='tdSn<%=tableIndex %>'>
					<%=tableIndex %>
				</td>
				<!--added against MMS-DM-CRF-118.9 starts-->
				<td class='fields' nowrap>
				<select name='pkgPrice1' id='pkgPrice1' id='pkgPrice1' onchange='PkgPriceInd("1")'>
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					<option value="R"><fmt:message key="eBL.Retainpackageprice.label" bundle="${bl_labels }"></fmt:message></option>
					<option value="I"><fmt:message key="eBL.Revisepackageprice.label" bundle="${bl_labels }"></fmt:message></option>					
				</select>
				</td>
				<td class='fields' nowrap>
					<select name='VAT1' id='VAT1' id='VAT1' onchange='VatOptionInd("1")'>
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					<option value="N"><fmt:message key="eBL.Retainvat.label" bundle="${bl_labels }"></fmt:message></option>
					<option value="E"><fmt:message key="eBL.Revisevat.label" bundle="${bl_labels }"></fmt:message></option>					
				</select></td>					
				<!--added against MMS-DM-CRF-118.9 ends-->
				<td class='fields' nowrap>
					<input type='text' size='10' readonly name='pkgCode<%=tableIndex %>' id='pkgCode<%=tableIndex %>' id='pkgCode<%=tableIndex %>' value='<%=priceBean.getPkgCode() %>'>											
				</td>
				<td class='fields' nowrap>						
					<input type='text' size='15' name='pkgDesc<%=tableIndex %>' id='pkgDesc<%=tableIndex %>' id='pkgDesc<%=tableIndex %>' value='<%=priceBean.getPkgDesc() %>' readonly >						
					
					&nbsp; <input type='button' disabled  class='button' id='pkgLkpBtn<%=tableIndex %>' name='pkgLkpBtn<%=tableIndex %>' value='?' >
					&nbsp; <span class='LABEL' style='font-weight: normal; color: blue; cursor: pointer;' onclick='showDiscount(<%=tableIndex %>)'>Discount</span>
				</td>
		<%if("S".equals(priceType)){ %>
				<td class='fields' nowrap style='display:none;' id='hideCustGrpTd<%=tableIndex %>' >
					<input type='text'  size='10' name='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' value='<%=priceBean.getCustGroupCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp<%=tableIndex %>,2,1); }'>
					&nbsp; <input type='button' class='button' id='custGrpLkpBtn<%=tableIndex %>' name='custGrpLkpBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(custGrp<%=tableIndex %>,2,1);'>
				</td>
				<td class='fields' nowrap style='display:none;' id='hideCustTd<%=tableIndex %>'>
					<input type='text' size='10' name='cust<%=tableIndex %>' id='cust<%=tableIndex %>' id='cust<%=tableIndex %>' value='<%=priceBean.getCustCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust<%=tableIndex %>,3,1,custGrp<%=tableIndex %>); }'>
					&nbsp; <input type='button' class='button' id='custBtn<%=tableIndex %>' name='custBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(cust<%=tableIndex %>,3,1,custGrp<%=tableIndex %>);'>
				</td>
		<%}else{%>
				<td class='fields' nowrap>
		<%if("readonly".equalsIgnoreCase(readOnly)){ %>
					<input type='text' size='10' name='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' value='<%=priceBean.getCustGroupCode() %>' readonly>
		<%}else{ %>
					<input type='text' size='10' name='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' value='<%=priceBean.getCustGroupCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp<%=tableIndex %>,2,1); }'>
		<%} %>
						
					&nbsp; <input type='button' <%=disabled %> class='button' id='custGrpLkpBtn<%=tableIndex %>' name='custGrpLkpBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(custGrp<%=tableIndex %>,2,1);'>
				</td>
				<td class='fields' nowrap>
		<%if("readonly".equalsIgnoreCase(readOnly)){ %>
					<input type='text' size='10' name='cust<%=tableIndex %>' id='cust<%=tableIndex %>' id='cust<%=tableIndex %>' value='<%=priceBean.getCustCode() %>' readonly>
		<%}else{ %>
					<input type='text' size='10' name='cust<%=tableIndex %>' id='cust<%=tableIndex %>' id='cust<%=tableIndex %>' value='<%=priceBean.getCustCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust<%=tableIndex %>,3,1,custGrp<%=tableIndex %>); }'>
		<%} %>
						
					&nbsp; <input type='button' <%=disabled %> class='button' id='custBtn<%=tableIndex %>' name='custBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(cust<%=tableIndex %>,3,1,custGrp<%=tableIndex %>);'>
				</td> 
		<%} %>
				<td class='fields' nowrap>
		<%if("readonly".equalsIgnoreCase(readOnly)){ %>
					<input type='text' size='10' name='blngClass<%=tableIndex %>' id='blngClass<%=tableIndex %>' id='blngClass<%=tableIndex %>' value='<%=priceBean.getBlngClassCode() %>' readonly>
		<%}else{ %>
					<input type='text' size='10' name='blngClass<%=tableIndex %>' id='blngClass<%=tableIndex %>' id='blngClass<%=tableIndex %>' value='<%=priceBean.getBlngClassCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngClass<%=tableIndex %>,1,1); }'>
		<%} %>
						
					&nbsp; <input <%=disabled %> type='button' class='button' id='blngClassBtn<%=tableIndex %>' name='blngClassBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(blngClass<%=tableIndex %>,1,1);'>
				</td>
					
				<td class='fields' nowrap>
						<input readonly type='text' size='10' maxlength='13' name='currentPrice<%=tableIndex %>' id='currentPrice<%=tableIndex %>' id='currentPrice<%=tableIndex %>' value='<%=priceBean.getCurrentPriceValue() %>' onkeypress='return checkForSpecChars(event)' >
				</td>
				<td class='fields' nowrap>
						<Select name='currentType<%=tableIndex %>' id='currentType<%=tableIndex %>' id='currentType<%=tableIndex %>' disabled >
							<option value='' <%="".equals(priceBean.getCurrentPriceType())?"selected":"" %>>Select</option>
							<option value='R' <%="R".equals(priceBean.getCurrentPriceType())?"selected":"" %>>Price</option>
							<option value='F' <%="F".equals(priceBean.getCurrentPriceType())?"selected":"" %>>Factor</option>
						</Select>
				</td>
				<td class='fields' nowrap>
						<input type='text' size='10' maxlength='13' name='revisedPrice<%=tableIndex %>' id='revisedPrice<%=tableIndex %>' id='revisedPrice<%=tableIndex %>' value='<%=priceBean.getRevisedPriceValue() %>'  onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(revisedType<%=tableIndex %>,this)'>
				</td>
				<td class='fields' nowrap>
						<Select name='revisedType<%=tableIndex %>' id='revisedType<%=tableIndex %>' id='revisedType<%=tableIndex %>'  onchange="checkForPerc(this,revisedPrice<%=tableIndex %>)" > 
							<option value='' <%="".equals(priceBean.getRevisedPriceType())?"selected":"" %>>Select</option>
							<option value='P' <%="P".equals(priceBean.getRevisedPriceType())?"selected":"" %>>Percentage</option>
							<option value='A' <%="A".equals(priceBean.getRevisedPriceType())?"selected":"" %>>Amount</option>
						</Select>
				</td>
					<!--added against MMS-DM-CRF-118.9 & 21058 starts-->
				<td class='fields' nowrap><input type='checkbox' name='VATapp1' id='VATapp1' id='VATapp1' onclick="VatBoxInd('1')"></td>
				<td class='fields' nowrap><input type='text' name='VATpercent1' id='VATpercent1' id='VATpercent1' size='10' maxlength='10'/>
					<input type='button' class='button' name='VATpercent_temp1' id='VATpercent_temp1' id='VATpercent_temp1' value='?' onClick='ruleCodeLookup(VATpercent1,'1')'/></td>
				<%if("S".equals(priceType) || "C".equals(priceType))
				{ %>
				<td class='fields' nowrap>
					<select name='RuleCoverage1' id='RuleCoverage1' id='RuleCoverage1' disabled>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
						<option value="S"><fmt:message key="eBL.AS_PER_POLICY.label" bundle="${bl_labels }"></fmt:message></option>
						<option value="C"><fmt:message key="eBL.PATIENT_COVERAGE.label" bundle="${bl_labels }"></fmt:message></option>
						<option value="P"><fmt:message key="eBL.PAYER_COVERAGE.label" bundle="${bl_labels }"></fmt:message></option>
					</select>
					</td>
				<%}else{%>
				<td class='fields' nowrap>
					<select name='RuleCoverage1' id='RuleCoverage1' id='RuleCoverage1'>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
						<option value="S"><fmt:message key="eBL.AS_PER_POLICY.label" bundle="${bl_labels }"></fmt:message></option>
						<option value="C"><fmt:message key="eBL.PATIENT_COVERAGE.label" bundle="${bl_labels }"></fmt:message></option>
						<option value="P"><fmt:message key="eBL.PAYER_COVERAGE.label" bundle="${bl_labels }"></fmt:message></option>
					</select>
					</td>
				<%}%>
				<td class='fields' nowrap>
					<select name='RuleCoverage1' id='RuleCoverage1' id='RuleCoverage1' >
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
						<option value="A"><fmt:message key="eBL.AS_PER_POLICY.label" bundle="${bl_labels }"></fmt:message></option>
						<option value="P"><fmt:message key="eBL.PATIENT_COVERAGE.label" bundle="${bl_labels }"></fmt:message></option>
						<option value="C"><fmt:message key="eBL.PAYER_COVERAGE.label" bundle="${bl_labels }"></fmt:message></option>
					</select>
				</td>
				<!--added against MMS-DM-CRF-118.9 ends-->
				<td class='fields' nowrap>
						<input type='text'  id='effFrom<%=tableIndex %>' name='effFrom<%=tableIndex %>' value='<%=priceBean.getEffectiveFrom() %>' size='10' onblur='validateDiscountDate(this,this,effTo<%=tableIndex %>,<%=tableIndex %>);'>
						<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_<%=tableIndex %>' onClick='return showCalendarLocal(1,<%=tableIndex %>)' />
				</td>
				<td class='fields' nowrap>
						<input type='text'  id='effTo<%=tableIndex %>' name='effTo<%=tableIndex %>' value='<%=priceBean.getEffectiveTo() %>' size='10' onblur='validateDiscountDate(this,effFrom<%=tableIndex %>,this,<%=tableIndex %>);'>
						<img src='../../eCommon/images/CommonCalendar.gif'  id='effTo_ctrl_<%=tableIndex %>' onClick='return showCalendarLocal(2,<%=tableIndex %>)' />
				</td>
				<td class='fields' nowrap>
						<input type='checkbox' id='removeChk<%=tableIndex%>' name='removeChk<%=tableIndex%>'>
					</td> 
					<input type='hidden' id='status<%=tableIndex %>' name='status<%=tableIndex %>'	value='<%=priceBean.getStatus() %>'>
			</tr>
		<%
			tableIndex++;
			} 
		%>
		</table>
		<input type='hidden' name='pageId' id='pageId' id='pageId' value='Price'>
		<input type='hidden' name='priceType' id='priceType' id='priceType' value='<%=priceType %>'>
		<input type='hidden' name='lastRowIndex' id='lastRowIndex' id='lastRowIndex' value=''>
		<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale %>' />
		<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value='<%=facilityId %>' />		
	</form>
</body>
</html>

