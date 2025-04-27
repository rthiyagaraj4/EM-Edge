<!DOCTYPE html>
<%-- Added by Rajesh V for MMS-CRF-0125
	This page contains the Discount Data for the search criteria enteref by user  --%>
<%@page import="eBL.pkgpricerevision.response.PkgPriceRevisionResponse"%>
<%@page import="eBL.pkgpricerevision.request.PackagePriceBean"%>
<%@page import="eBL.pkgpricerevision.request.PkgPriceRevisionRequest"%>
<%@page import="eBL.pkgpricerevision.bc.PkgPriceDisountBC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
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
	String priceType = checkForNull(request.getParameter("priceType"));
	String blngClass = checkForNull(request.getParameter("blngClassCode"));
	String blngGroup = checkForNull(request.getParameter("blngGrpCode"));
	String custGrpCode = checkForNull(request.getParameter("custGrpCode"));
	String custCode = checkForNull(request.getParameter("custCode"));
	String pkgCode = checkForNull(request.getParameter("pkgCode"));
	String facilityId = (String)session.getAttribute("facility_id");
	String policyCode = checkForNull(request.getParameter("policyCode")); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
	//For Traversal
	int constCount = 50;
	String nextYn = "N";
	String prevYn = "N";
	String traversal = "N";
	String fromRcrd = "";
	String toRcrd = "";
	int startIndex = 0;
	int startRcrd = 0;
	int endRcrd = 0;
	int totalRecord=0;
	//For Traversal
	//Call to BC to get Lookup List
		PkgPriceDisountBC priceDiscountBC = new PkgPriceDisountBC();
		PkgPriceRevisionRequest priceRevisionRequest = new PkgPriceRevisionRequest();
		PkgPriceRevisionResponse priceRevisionResponse = new PkgPriceRevisionResponse();
		List<PackagePriceBean> discountList = null;
		try{
			priceRevisionRequest.setPriceType(priceType);
			priceRevisionRequest.setBlngClassCode(blngClass);
			priceRevisionRequest.setBlngGroupCode(blngGroup);
			priceRevisionRequest.setCustGroupCode(custGrpCode);
			priceRevisionRequest.setCustCode(custCode);	
			priceRevisionRequest.setPkgCode(pkgCode);
			priceRevisionRequest.setFacilityId(facilityId);
			priceRevisionRequest.setRevisionType("Discount");
			priceRevisionRequest.setPolicyCode(policyCode); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
			
			//For Traversal
			fromRcrd = checkForNull(request.getParameter("fromRcrd"));
			toRcrd = checkForNull(request.getParameter("toRcrd"));

			if(fromRcrd == null || "".equals(fromRcrd)){
				startRcrd = 1;
			}
			else{
				startRcrd = Integer.parseInt(fromRcrd);
			}
				
			if(toRcrd == null || "".equals(toRcrd)){
				endRcrd = constCount;
			}
			else{
				endRcrd = Integer.parseInt(toRcrd);
			}
			startIndex = startRcrd;

			priceRevisionRequest.setStartFrom(startRcrd);
			priceRevisionRequest.setEndWith(endRcrd);
			priceRevisionRequest.setConstCount(constCount);
			//For Traversal
			
			priceRevisionResponse = priceDiscountBC.priceDiscountRevision(priceRevisionRequest);
			discountList = priceRevisionResponse.getPriceList();
			if(discountList == null){
				discountList = new ArrayList<PackagePriceBean>();
			}
			nextYn = priceRevisionResponse.getNextYN();
			prevYn = priceRevisionResponse.getPrevYN();
			traversal = priceRevisionResponse.getTraversal();
		}
		catch(Exception e){
			System.err.println("Exception in calling priceDiscountRevision->"+e);
		}
		//Call to BC to get Lookup List
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eBL/js/PkgBulkUpdate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
	$(document).ready(function(){
		if($('#priceType').val() == 'S'){
			$('td[id^=hideCust]').each(function(){
				$(this).hide();
			});
			$('#colHdrMain').attr('colspan','9');
			$('#colHdr1').attr('colspan','4');
		}
		else if($('#priceType').val() == 'C'){
			$('td[id^=hideBlng]').each(function(){
				$(this).hide();
			});
			$('#colHdrMain').attr('colspan','10');
			$('#colHdr1').attr('colspan','5');
		}
		
		if($('#traverse').val() == 'Y'){
			$('#trProgress').show();
		}else{
			$('#trProgress').hide();
		}
			
		if($('#hdnNextSpan').val() == 'Y'){
			$('#nextSpan').show();
		}else{
			$('#nextSpan').hide();
		}
			
		if($('#prevSpan').val() == 'Y'){
			$('#previousSpan').show();
		}else{
			$('#previousSpan').hide();
		}
		
		$('#nextSpan').click(function(){
			var startFrom = parseInt($('#fromRcrd').val())+parseInt($('#constCount').val());
			var endWith = parseInt($('#toRcrd').val())+parseInt($('#constCount').val());
			document.location.href = "PkgDiscountRevisionLookup.jsp?priceType="+$('#priceType').val()+
									"&blngClassCode="+$('#blngClassCode').val()+
									"&blngGrpCode="+$('#blngGrpCode').val()+
									"&custGrpCode="+$('#custGrpCode').val()+
									"&custCode="+$('#custCode').val()+
									"&pkgCode="+$('#pkgCode').val()+
									"&fromRcrd="+startFrom+
									"&toRcrd="+endWith+
									"&policyCode="+$('#policyCode').val(); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020

		});
		$('#previousSpan').click(function(){
			var startFrom = parseInt($('#fromRcrd').val())-parseInt($('#constCount').val());
			var endWith = parseInt($('#toRcrd').val())-parseInt($('#constCount').val());
			document.location.href = "PkgDiscountRevisionLookup.jsp?priceType="+$('#priceType').val()+
									"&blngClassCode="+$('#blngClassCode').val()+
									"&blngGrpCode="+$('#blngGrpCode').val()+
									"&custGrpCode="+$('#custGrpCode').val()+
									"&custCode="+$('#custCode').val()+
									"&pkgCode="+$('#pkgCode').val()+
									"&fromRcrd="+startFrom+
									"&toRcrd="+endWith+
									"&policyCode="+$('#policyCode').val(); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
		});
		
		$('#filterBtn').click(function(){
			document.location.href = "PkgDiscountRevisionLookup.jsp?priceType="+$('#priceType').val()+
									"&blngClassCode="+$('#filterBlngClass').val()+
									"&blngGrpCode="+$('#filterBlngGrp').val()+
									"&custGrpCode="+$('#filterCustGrp').val()+
									"&custCode="+$('#filterCust').val()+
									"&pkgCode="+$('#filterPkgCode').val();
		});
		
		$('#resetBtn').click(function(){
			var srchDoc = parent.search.document
			var pkgCode = $(srchDoc).find('#pkgCode').val();
			if(pkgCode == ''){
				pkgCode = '**';
			}
			document.location.href = "PkgDiscountRevisionLookup.jsp?priceType="+$('#priceType').val()+
									"&pkgCode="+pkgCode;
		});
	});
	
	function processScroll()
	{
		var x = document.body.scrollLeft;
		var y = document.body.scrollTop;
		var px = '';

		if(y > 0)
		{
		
			px = y+"px";
			$('#fixedHeaderTop').css('top',px);
			$('#fixedHeaderTop').css('position','relative');
			$('#fixedHeaderTop1').css('top',px);
			$('#fixedHeaderTop1').css('position','relative');
			$('#fixedHeaderTop2').css('top',px);
			$('#fixedHeaderTop2').css('position','relative');
			
		}
		else
		{
			$('#fixedHeaderTop').css('top','0px');
			$('#fixedHeaderTop').css('position','relative');
			$('#fixedHeaderTop1').css('top','0px');
			$('#fixedHeaderTop1').css('position','relative');
			$('#fixedHeaderTop2').css('top','0px');
			$('#fixedHeaderTop2').css('position','relative');
			
		}
	}
	</script>
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();" onScroll="processScroll();">
	<form name='priceRevisionFrm' id='priceRevisionFrm' id='priceRevisionFrm'>
		<table id='priceRevisionTbl' name='priceRevisionTbl' id='priceRevisionTbl' width="100%" cellpadding='3'  cellspacing=0 align="center" class='grid' border="1">
			<tr  id='fixedHeaderTop'>
				<td class='COLUMNHEADER' nowrap colspan="10" id='colHdrMain' align="center">
					Discount Price Revision Lookup
				</td>
			</tr>
			<tr  id='fixedHeaderTop1'>
				<td class='COLUMNHEADER' nowrap colspan="6" id='colHdr1'>
				</td>
				<td class='COLUMNHEADER' nowrap colspan="2" align="center">
					Current Discount
				</td>				
				<td class='COLUMNHEADER' nowrap colspan="3">
				</td>
			</tr>
			<tr  id='fixedHeaderTop2'>
				<td class='COLUMNHEADER' nowrap>
					Sno
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.PackageCode.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap  id='hideBlngGroupTd'>
					<fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.BillingClass.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap id='hideCustGroupTd'>
					<fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap id='hideCustTd'>
					<fmt:message key="eBL.Customer.label" bundle="${bl_labels }"></fmt:message>
				</td>
				
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="Common.Value.label" bundle="${common_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="Common.type.label" bundle="${common_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.EffectiveFrom.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.EffectiveTo.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				
			</tr>
			<tr>
				<td>
					<input type='button' class='button' name='filterBtn' id='filterBtn' id='filterBtn' value='Search'>
					&nbsp;<input type='button' class='button' name='resetBtn' id='resetBtn' id='resetBtn' value='Reset'>
				</td>
				<td>
					<input type='text' name='filterPkgCode' id='filterPkgCode' id='filterPkgCode' size="10" value='<%=pkgCode%>'>
				</td>
				<td  id='hideBlngGroup1'>
					<input type='text' name='filterBlngGrp' id='filterBlngGrp' id='filterBlngGrp' size="10" value='<%=blngGroup%>'>
				</td>
				<td>
					<input type='text' name='filterBlngClass' id='filterBlngClass' id='filterBlngClass' size="10" value='<%=blngClass%>'>
				</td>
				<td id='hideCustGroup1'>
					<input type='text' name='filterCustGrp' id='filterCustGrp' id='filterCustGrp' size="10" value='<%=custGrpCode%>'>
				</td>
				<td  id='hideCustGroup1'>
					<input type='text' name='filterCust' id='filterCust' id='filterCust' size="10" value='<%=custCode%>'>
				</td>
				<td  nowrap="nowrap">
					<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer;">
						<span id='previousSpan'>Previous</span>
					</span>
				</td>
				<td  nowrap="nowrap">
					<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer;">
						<span id='nextSpan'>Next</span>
					</span>
				</td>
				<td colspan='4'>
				</td>
				
			</tr>
			<%
			int tableIndex = 1;
			for(PackagePriceBean discountBean: discountList){ %>
			<tr onclick="moveData('Discount',<%=tableIndex%>)">
				<td class="label">
					<%=startIndex %>
				</td>
				<td class="label" id='pkgCode<%=tableIndex%>'>
					<%=discountBean.getPkgCode()%>
				</td>
				<%if("C".equals(priceType)){ %>
					<td class="label" style="display: none" id='blngGroup<%=tableIndex%>'>
						<%=discountBean.getBlngGroupCode()%>
					</td>
				<%} else{ %>
					<td class="label" id='blngGroup<%=tableIndex%>'>
						<%=discountBean.getBlngGroupCode()%>
					</td>
				<%} %>
				<td class="label" id='blngClassCode<%=tableIndex%>'>
					<%=discountBean.getBlngClassCode()%>
				</td>
				<td class="label" id='hideCustGrp<%=tableIndex%>'>
					<%=discountBean.getCustGroupCode()%>
				</td>
				<td class="label" id='hideCust<%=tableIndex%>'>
					<%=discountBean.getCustCode()%>
				</td>
				
				<td class="label" id='currPrice<%=tableIndex%>'>
					<%=discountBean.getCurrentPriceValue()%>
				</td>
				<td class="label" id='currType<%=tableIndex%>'>
					<%=discountBean.getCurrentPriceType()%>
				</td>
				
				<td class="label" id='effFrom<%=tableIndex%>'>
					<%=discountBean.getEffectiveFrom()%>
				</td>
				<td class="label" id='effTo<%=tableIndex%>'>
					<%=discountBean.getEffectiveTo()%>
				</td>
				<input type='hidden' name='pkgDesc<%=tableIndex%>' id='pkgDesc<%=tableIndex%>' id='pkgDesc<%=tableIndex%>' value='<%=discountBean.getPkgDesc()%>'>
			</tr>
		<%
			tableIndex++;
			startIndex++;
		} %>
		</table>
		<input type='hidden' name='pageId' id='pageId' id='pageId' value='Discount'>
		<input type='hidden' name='priceType' id='priceType' id='priceType' value='<%=priceType %>'>
		<input type='hidden' name='blngClassCode' id='blngClassCode' id='blngClassCode' value='<%=blngClass %>'>
		<input type='hidden' name='blngGrpCode' id='blngGrpCode' id='blngGrpCode' value='<%=blngGroup %>'>
		<input type='hidden' name='custGrpCode' id='custGrpCode' id='custGrpCode' value='<%=custGrpCode %>'>
		<input type='hidden' name='custCode' id='custCode' id='custCode' value='<%=custCode %>'>
		<input type='hidden' name='pkgCode' id='pkgCode' id='pkgCode' value='<%=pkgCode %>'>
		<input type='hidden' name='hdnNextSpan' id='hdnNextSpan' id='hdnNextSpan' value='<%=nextYn %>'>
		<input type='hidden' name='prevSpan' id='prevSpan' id='prevSpan' value='<%=prevYn %>'>
		<input type='hidden' name='traverse' id='traverse' id='traverse' value='<%=traversal%>'>
		<input type='hidden' name='fromRcrd' id='fromRcrd' id='fromRcrd' value='<%=startRcrd %>'>
		<input type='hidden' name='toRcrd' id='toRcrd' id='toRcrd' value='<%=endRcrd %>'>
		<input type='hidden' name='constCount' id='constCount' id='constCount' value='<%=constCount %>'>
		<input type='hidden' name='policyCode' id='policyCode' id='policyCode' value='<%=policyCode %>'>
	</form>
</body>
</html>

