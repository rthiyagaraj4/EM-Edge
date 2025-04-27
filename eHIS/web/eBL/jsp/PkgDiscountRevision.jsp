<!DOCTYPE html>
<%-- Added by Rajesh V for MMS-CRF-0125
	This page contains the Discount Data selected by the user for Revision--%>
<%@page import="eBL.pkgpricerevision.request.PackagePriceBean"%>
<%@page import="eBL.pkgpricerevision.request.PkgPriceRevisionRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Package Discount Revision</title>
<%!
private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String priceType = request.getParameter("priceType");
	String locale = (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getAttribute("facility_id");
	String addNew =  checkForNull(request.getParameter("addNew"));		
	String sBlngClassCode = checkForNull(request.getParameter("sBlngClassCode"));
	String sCustGrpCode = checkForNull(request.getParameter("sCustGrpCode"));
	String sCustCode = checkForNull(request.getParameter("sCustCode"));
	String sPkgCode = checkForNull(request.getParameter("sPkgCode"));
	String beanId = "PkgPriceRevisionRequest" ;
	String beanName = "eBL.pkgpricerevision.request.PkgPriceRevisionRequest";
	PkgPriceRevisionRequest pkgPriceDiscount = null;
	List<PackagePriceBean> discountRevision = null;
	try{
		pkgPriceDiscount = (PkgPriceRevisionRequest) getObjectFromBean(beanId, beanName, session);
		if(pkgPriceDiscount.getDiscountRevision() == null){
			pkgPriceDiscount.setDiscountRevision(new ArrayList<PackagePriceBean>());
		}
		discountRevision = pkgPriceDiscount.getDiscountRevision();
		
	}
	catch(Exception e){
		
	}
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
		if($('#priceType').val() == 'S'){
			$('td[id^=hideCust]').each(function(){
				$(this).hide();
			});
			//$('#colHdrMain').attr('colspan','11');
			$('#colHdr1').attr('colspan','5');
			$('#mandImgBlngGr').css('visibility','visible');
		}
		else if($('#priceType').val() == 'C'){
			$('td[id^=hideBlngGrp]').each(function(){
				$(this).hide();
			});
			$('#colHdr1').attr('colspan','6');
		}
		
		if($('#addNew').val() == 'Y'){
			addNewDiscount();
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
	<form name='priceRevisionFrm' id='priceRevisionFrm' id='priceRevisionFrm'>
		<table id='priceRevisionTbl' name='priceRevisionTbl' id='priceRevisionTbl' width="100%" cellpadding='3'  cellspacing=0 align="center" class='grid' border="1">
			<!-- <tr>
				<td class='COLUMNHEADER' nowrap colspan="13" id='colHdrMain' align="center">
					Discount Price Revision
				</td>
			</tr>  -->
			<tr>
				<td class='COLUMNHEADER' nowrap colspan="7" id='colHdr1'>
				</td>
				<td class='COLUMNHEADER' nowrap colspan="2" align="center">
					Current Discount
				</td>
				<td class='COLUMNHEADER' nowrap colspan="2" align="center">
					Revised Revision
				</td>
				<td class='COLUMNHEADER' nowrap colspan="3">
				</td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class='COLUMNHEADER' nowrap>
					Sno
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.PackageCode.Label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<td class='COLUMNHEADER' nowrap >
					<fmt:message key="eBL.PackageDesc.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap id='hideBlngGrpTd'>
					<fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif' id='mandImgBlngGr' style="visibility: hidden;">
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.BillingClass.Label" bundle="${bl_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
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
					<fmt:message key="Common.Value.label" bundle="${common_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="Common.type.label" bundle="${common_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="Common.Value.label" bundle="${common_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="Common.type.label" bundle="${common_labels }"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>	
				</td>
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
			for(PackagePriceBean discountBean: discountRevision){ 
				if("U".equals(discountBean.getStatus())){
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
					<td class='fields' nowrap>						
						<input type='text' size='10' readonly name='pkgCode<%=tableIndex %>' id='pkgCode<%=tableIndex %>' id='pkgCode<%=tableIndex %>' value='<%=discountBean.getPkgCode() %>'>
					</td>
					<td class='fields' nowrap>
						<input type='text' size='15' name='pkgDesc<%=tableIndex %>' id='pkgDesc<%=tableIndex %>' id='pkgDesc<%=tableIndex %>' value='<%=discountBean.getPkgDesc() %>' readonly >
						&nbsp; <input type='button' disabled  class='button' id='pkgLkpBtn<%=tableIndex %>' name='pkgLkpBtn<%=tableIndex %>' value='?' >
					</td>
					<%if("S".equals(priceType)){ %>
						<td class='fields' nowrap>
							<%if("readonly".equalsIgnoreCase(readOnly)){ %>
								<input type='text' size='10' name='blngGroup<%=tableIndex %>' id='blngGroup<%=tableIndex %>' id='blngGroup<%=tableIndex %>' value='<%=discountBean.getBlngGroupCode() %>' readonly>
							<%}else{ %>
								<input type='text' size='10'  name='blngGroup<%=tableIndex %>' id='blngGroup<%=tableIndex %>' id='blngGroup<%=tableIndex %>' value='<%=discountBean.getBlngGroupCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngGroup<%=tableIndex %>,5,1); }'>
							<%} %>
							
							&nbsp; <input type='button' <%=disabled %> class='button' id='blngGroupBtn<%=tableIndex %>' name='blngGroupBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(blngGroup<%=tableIndex %>,5,1);'>
						</td> 
					<%}
					else{%>
						<td class='fields' nowrap style='display:none;' id='hideBlngGrpTd<%=tableIndex %>'>
							<input type='text' size='10'  name='blngGroup<%=tableIndex %>' id='blngGroup<%=tableIndex %>' id='blngGroup<%=tableIndex %>' value='<%=discountBean.getBlngGroupCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngGroup<%=tableIndex %>,5,1); }'>
						</td>
					<%} %>
					<td class='fields' nowrap>
						<%if("readonly".equalsIgnoreCase(readOnly)){ %>
							<input type='text' size='10' name='blngClass<%=tableIndex %>' id='blngClass<%=tableIndex %>' id='blngClass<%=tableIndex %>' value='<%=discountBean.getBlngClassCode() %>' readonly>
						<%}else{ %>
							<input type='text' size='10' name='blngClass<%=tableIndex %>' id='blngClass<%=tableIndex %>' id='blngClass<%=tableIndex %>' value='<%=discountBean.getBlngClassCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngClass<%=tableIndex %>,6,1); }'>
						<%} %>
						
						&nbsp; <input <%=disabled %> type='button' class='button' id='blngClassBtn<%=tableIndex %>' name='blngClassBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(blngClass<%=tableIndex %>,6,1);'>
					</td>
				<%if("S".equals(priceType)){ %>
					<td class='fields' nowrap style='display:none;' id='hideCustGrpTd<%=tableIndex %>' >
						<input type='text'  size='10' name='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' value='<%=discountBean.getCustGroupCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp<%=tableIndex %>,2,1); }'>
						&nbsp; <input type='button' class='button' id='custGrpLkpBtn<%=tableIndex %>' name='custGrpLkpBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(custGrp<%=tableIndex %>,2,1);'>
					</td>
					<td class='fields' nowrap style='display:none;' id='hideCustTd<%=tableIndex %>'>
						<input type='text' size='10' name='cust<%=tableIndex %>' id='cust<%=tableIndex %>' id='cust<%=tableIndex %>' value='<%=discountBean.getCustCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust<%=tableIndex %>,3,1,custGrp<%=tableIndex %>); }'>
						&nbsp; <input type='button' class='button' id='custBtn<%=tableIndex %>' name='custBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(cust<%=tableIndex %>,3,1,custGrp<%=tableIndex %>);'>
					</td>
				<%}
				else{%>
					<td class='fields' nowrap>
						<%if("readonly".equalsIgnoreCase(readOnly)){ %>
							<input type='text' size='10' name='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' value='<%=discountBean.getCustGroupCode() %>' readonly>
						<%}else{ %>
							<input type='text' size='10' name='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' id='custGrp<%=tableIndex %>' value='<%=discountBean.getCustGroupCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp<%=tableIndex %>,2,1); }'>
						<%} %>
						
						&nbsp; <input type='button' <%=disabled %> class='button' id='custGrpLkpBtn<%=tableIndex %>' name='custGrpLkpBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(custGrp<%=tableIndex %>,2,1);'>
					</td>
					<td class='fields' nowrap>
						<%if("readonly".equalsIgnoreCase(readOnly)){ %>
							<input type='text' size='10' name='cust<%=tableIndex %>' id='cust<%=tableIndex %>' id='cust<%=tableIndex %>' value='<%=discountBean.getCustCode() %>' readonly>
						<%}else{ %>
							<input type='text' size='10' name='cust<%=tableIndex %>' id='cust<%=tableIndex %>' id='cust<%=tableIndex %>' value='<%=discountBean.getCustCode() %>' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust<%=tableIndex %>,3,1,custGrp<%=tableIndex %>); }'>
						<%} %>
						
						&nbsp; <input type='button' <%=disabled %> class='button' id='custBtn<%=tableIndex %>' name='custBtn<%=tableIndex %>' value='?' onclick='callCommonLookupWoDesc(cust<%=tableIndex %>,3,1,custGrp<%=tableIndex %>);'>
					</td> 
				<%} %>
					
					<td class='fields' nowrap>
						<input readonly type='text' size='10' maxlength='13' name='currentValue<%=tableIndex %>' id='currentValue<%=tableIndex %>' id='currentValue<%=tableIndex %>' value='<%=discountBean.getCurrentPriceValue() %>' onkeypress='return checkForSpecChars(event)' >
					</td>
					<td class='fields' nowrap>
						<Select name='currentType<%=tableIndex %>' id='currentType<%=tableIndex %>' id='currentType<%=tableIndex %>' disabled >
							<option value='' <%="".equals(discountBean.getCurrentPriceType())?"selected":"" %>>Select</option>
							<option value='R' <%="R".equals(discountBean.getCurrentPriceType())?"selected":"" %>>Percentage</option>
							<option value='A' <%="A".equals(discountBean.getCurrentPriceType())?"selected":"" %>>Amount</option>
						</Select>
					</td>
					<td class='fields' nowrap>
						<input type='text' size='10' maxlength='13' name='revisedValue<%=tableIndex %>' id='revisedValue<%=tableIndex %>' id='revisedValue<%=tableIndex %>' value='<%=discountBean.getRevisedPriceValue() %>' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(revisedType<%=tableIndex %>,this)'>
					</td>
					<td class='fields' nowrap>
						<Select name='revisedType<%=tableIndex %>' id='revisedType<%=tableIndex %>' id='revisedType<%=tableIndex %>' onchange="checkForPerc(this,revisedValue<%=tableIndex %>)">
							<option value='' <%="".equals(discountBean.getRevisedPriceType())?"selected":"" %>>Select</option>
							<option value='P' <%="P".equals(discountBean.getRevisedPriceType())?"selected":"" %>>Percentage</option>
							<option value='A' <%="A".equals(discountBean.getRevisedPriceType())?"selected":"" %>>Amount</option>
						</Select>
					</td>
					<td class='fields' nowrap>
						<input type='text' id='effFrom<%=tableIndex %>' name='effFrom<%=tableIndex %>' value='<%=discountBean.getEffectiveFrom() %>' size='10' onblur='validateDiscountDate(this,this,effTo<%=tableIndex %>,<%=tableIndex %>);'>						
						<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_<%=tableIndex %>' onClick='return showCalendarLocal(1,<%=tableIndex %>)' />
					</td>
					<td class='fields' nowrap>
						<input type='text'  id='effTo<%=tableIndex %>' name='effTo<%=tableIndex %>' value='<%=discountBean.getEffectiveTo() %>' size='10' onblur='validateDiscountDate(this,effFrom<%=tableIndex %>,this,<%=tableIndex %>);'>
						<img src='../../eCommon/images/CommonCalendar.gif'  id='effTo_ctrl_<%=tableIndex %>' onClick='return showCalendarLocal(2,<%=tableIndex %>)' />
					</td>
					<td class='fields' nowrap>
						<input type='checkbox' id='removeChk<%=tableIndex%>' name='removeChk<%=tableIndex%>'>
					</td> 
					<input type='hidden' id='status<%=tableIndex %>' name='status<%=tableIndex %>'	value='<%=discountBean.getStatus() %>'>
				</tr>
			<%
			tableIndex++;
			} %>
		</table>
		<input type='hidden' name='pageId' id='pageId' id='pageId' value='Discount'>
		<input type='hidden' name='priceType' id='priceType' id='priceType' value='<%=priceType %>'>
		<input type='hidden' name='lastRowIndex' id='lastRowIndex' id='lastRowIndex' value=''>
		<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale %>' />
		<input type='hidden' name='addNew' id='addNew' id='addNew' value='<%=addNew %>'>
		<input type='hidden' name='sBlngClassCode' id='sBlngClassCode' id='sBlngClassCode' value='<%=sBlngClassCode %>'>
		<input type='hidden' name='sCustGrpCode' id='sCustGrpCode' id='sCustGrpCode' value='<%=sCustGrpCode %>'>
		<input type='hidden' name='sCustCode' id='sCustCode' id='sCustCode' value='<%=sCustCode %>'>
		<input type='hidden' name='sPkgCode' id='sPkgCode' id='sPkgCode' value='<%=sPkgCode %>'>
		<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value='<%=facilityId %>' />		
	</form>
</body>
</html>

