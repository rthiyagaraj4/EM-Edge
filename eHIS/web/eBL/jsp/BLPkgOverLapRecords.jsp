<!DOCTYPE html>
<%-- Added by Rajesh V for MMS-CRF-0125
	This page is used as a popup for displaying the Overlapped Records--%>
<%@page import="eBL.pkgpricerevision.request.PackagePriceBean"%>
<%@page import="java.util.List"%>
<%@page import="eBL.pkgpricerevision.response.PkgPriceRevisionResponse"%>
<%@page import="eBL.pkgpricerevision.request.PkgPriceRevisionRequest"%>
<%@page import="eBL.pkgpricerevision.bc.PkgPriceDisountBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Overlap Records</title>
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
	String facilityId = (String)session.getAttribute("facility_id");
	String sessionId = (String)request.getParameter("session_id");
	String pgmDate = (String)request.getParameter("pgm_date");
	String userId = (String)session.getAttribute("login_user");
	
	//Call to BC to get Lookup List
	PkgPriceDisountBC priceDiscountBC = new PkgPriceDisountBC();
	PkgPriceRevisionRequest priceRevisionRequest = new PkgPriceRevisionRequest();
	PkgPriceRevisionResponse priceRevisionResponse = new PkgPriceRevisionResponse();
	List<PackagePriceBean> priceList = null;
	
	try{
		priceRevisionRequest.setUserId(userId);
		priceRevisionRequest.setFacilityId(facilityId);
		priceRevisionRequest.setSessionId(sessionId);
		priceRevisionRequest.setPgmDate(pgmDate);
		
		priceRevisionResponse = priceDiscountBC.getOverlapRecords(priceRevisionRequest);
		priceList = priceRevisionResponse.getPriceList();
		if(priceList == null){
			priceList = new ArrayList<PackagePriceBean>();
		}
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
			$('#btnContinue').click(function(){
				window.returnValue = 'Y';
				window.close();
			});
			$('#btnCancel').click(function(){
				window.returnValue = 'N';
				window.close();
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
<body onScroll="processScroll();" >
	<form name='overlapFrm' id='overlapFrm' id='overlapFrm'>
		<table id='overlapTbl' name='overlapTbl' id='overlapTbl' width="100%" align="center" class='grid' border="1" cellpadding='3'  cellspacing=0>
	
			<tr  id='fixedHeaderTop'>
				<td class='COLUMNHEADER' nowrap colspan="8" id='pkgPriceHdr' align="center">
					Overlap Packages
				</td>
			</tr>
			<tr   id='fixedHeaderTop1'>
				<td class='COLUMNHEADER' nowrap>
					Sno
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.PackageCode.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap id='hideCustGroupTd'>
					<fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap id='hideCustTd'>
					<fmt:message key="eBL.Customer.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.BillingClass.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap >
					<fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels }"></fmt:message>
				</td>				
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.EffectiveFrom.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td class='COLUMNHEADER' nowrap>
					<fmt:message key="eBL.EffectiveTo.Label" bundle="${bl_labels }"></fmt:message>
				</td>
			</tr>
			<%
			int tableIndex = 1;
			for(PackagePriceBean priceBean: priceList){ %>
			<tr>
				<td class="label">
					<%=tableIndex %>
				</td>
				<td class="label" id='pkgCode<%=tableIndex%>'>
					<%=checkForNull(priceBean.getPkgCode()) %>					
				</td>
				<td class="label" id='hideCustGrp<%=tableIndex%>'>
					<%=checkForNull(priceBean.getCustGroupCode())%>
				</td>
				<td class="label" id='hideCust<%=tableIndex%>'>
					<%=checkForNull(priceBean.getCustCode())%>
				</td>
				<td class="label" id='blngClassCode<%=tableIndex%>'>
					<%=checkForNull(priceBean.getBlngClassCode())%>
				</td>
				<td class="label" id='blngGrpCode<%=tableIndex%>'>
					<%=checkForNull(priceBean.getBlngGroupCode())%>
				</td>

				<td class="label" id='effFrom<%=tableIndex%>'>
					<%=checkForNull(priceBean.getEffectiveFrom())%>
				</td>
				<td class="label" id='effTo<%=tableIndex%>'>
					<%=checkForNull(priceBean.getEffectiveTo())%>
				</td>				
			</tr>
		<%
		tableIndex++;
		} %>	
		</table>
		<br>
		<br>
		Do You Want to Continue or Cancel?
		<br>
		<table width='20%' align="center">
			<tr style="width: 100%">
				<td width="50%">
					<input type='button' class='button' id='btnContinue' name='btnContinue' id='btnContinue' value='Continue'>
				</td>
				<td width="50%">
					<input type='button' class='button' id='btnCancel' name='btnCancel' id='btnCancel' value='Cancel'>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

