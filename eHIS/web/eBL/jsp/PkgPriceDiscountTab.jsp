<!DOCTYPE html>
<%-- Added by Rajesh V for MMS-CRF-0125
	Body Frame which contains all the pages belonging to this function  --%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eBL/js/PkgBulkUpdate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
		$(document).ready(function(){
			
			$('#PackageRevisionSpan').click(function(){
				var dtlDoc = parent.lookup.document;
				var srchFrm = parent.search.searchFrm;
				var lookUpData = parent.lookUpData.document;
				var pageId = $(dtlDoc).find('#pageId').val();
				var priceType = $(dtlDoc).find('#priceType').val();
				var blngClassCode = $(lookUpData).find('#blngClassCode').val();
				var blngGrpCode = $(lookUpData).find('#blngGrpCode').val();
				var custGrpCode = $(lookUpData).find('#custGrpCode').val();
				var custCode = $(lookUpData).find('#custCode').val();
				var pkgCode = $(lookUpData).find('#pkgCode').val();
				var policyCode = $(lookUpData).find('#policyCode').val(); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
				var srchType = srchFrm.srchType.value;
				if(pageId == 'Discount'){
					
					var trLength = '';
					var lastRow = $(dtlDoc).find('#priceRevisionTbl tr:last');
					
					if(isNaN($(lastRow).attr('rowValue'))){
						trLength = '1';
					}
					else{
						trLength = $(lastRow).attr('rowValue');						
					}
					for(var i=1;i<=trLength;i++){
						if($(dtlDoc).find('#pkgCode'+i).val() != undefined && $(dtlDoc).find('#pkgCode'+i).val() != ''){
							
							if(srchType == 'C'){
								if(dtlDoc.getElementById('custGrp'+i).value == ''){
									alert('Customer Group is a mandatory field');
									dtlDoc.getElementById('custGrp'+i).select();									
									return false;
								}
								if(dtlDoc.getElementById('cust'+i).value == ''){
									alert('Customer is a mandatory field');
									dtlDoc.getElementById('cust'+i).select();									
									return false;
								}
							}
							else{
								if(dtlDoc.getElementById('blngGroup'+i).value == ''){
									alert('Billing Group is a mandatory field');
									dtlDoc.getElementById('blngGroup'+i).select();									
									return false;
								}
							}
							
							if($(dtlDoc).find('#blngClass'+i).val() == ''){
								alert('Billing Class is a mandatory field');
								$(dtlDoc).find('#blngClass'+i).select();
								return false;
							}
							if($(dtlDoc).find('#revisedValue'+i).val() == ''){
								alert('Revised Price is a mandatory field');
								$(dtlDoc).find('#revisedValue'+i).select();
								return false;
							}
							if($(dtlDoc).find('#revisedType'+i).val() == ''){
								alert('Revised Type is a mandatory field');
								$(dtlDoc).find('#revisedType'+i).focus();
								return false;
							}
							if($(dtlDoc).find('#effFrom'+i).val() == ''){
								alert('Effective From is a mandatory field');
								$(dtlDoc).find('#effFrom'+i).select();
								return false;
							}
						}
						
					}
					$('#PackageRevision').attr('class','tabClicked');
					$('#PackageRevisionSpan').attr('class','tabSpanclicked');
					$('#DiscountRevision').attr('class','tabA');
					$('#DiscountRevisionSpan').attr('class','tabAspan');
					 $(dtlDoc).find('#lastRowIndex').val(trLength);					
					getXMLString('Discount');
					dtlDoc.location.href = '../../eBL/jsp/PkgPriceRevision.jsp?priceType='+priceType;
					lookUpData.location.href = '../../eBL/jsp/PkgPriceRevisionLookup.jsp?priceType='+priceType+
											'&blngClassCode='+blngClassCode+
											'&blngGrpCode='+blngGrpCode+
											'&custGrpCode='+custGrpCode+
											'&custCode='+custCode+
											'&pkgCode='+pkgCode+
											'&policyCode='+policyCode; //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
				}
				
			});
			$('#DiscountRevisionSpan').click(function(){
				var dtlDoc = parent.lookup.document;
				var lookUpData = parent.lookUpData.document;
				var srchFrm = parent.search.searchFrm;
				var pageId = $(dtlDoc).find('#pageId').val();
				var priceType = $(dtlDoc).find('#priceType').val();
				var blngClassCode = $(lookUpData).find('#blngClassCode').val();
				var blngGrpCode = $(lookUpData).find('#blngGrpCode').val();
				var custGrpCode = $(lookUpData).find('#custGrpCode').val();
				var custCode = $(lookUpData).find('#custCode').val();
				var pkgCode = $(lookUpData).find('#pkgCode').val();
				var policyCode = $(lookUpData).find('#policyCode').val();//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
				var srchType = srchFrm.srchType.value;
				if(pageId == 'Price'){
					
					var trLength = '';
					var lastRow = $(dtlDoc).find('#priceRevisionTbl tr:last');
					
					if(isNaN($(lastRow).attr('rowValue'))){
						trLength = '1';
					}
					else{
						trLength = $(lastRow).attr('rowValue');						
					}
					for(var i=1;i<=trLength;i++){
						if($(dtlDoc).find('#pkgCode'+i).val() != undefined && $(dtlDoc).find('#pkgCode'+i).val() != ''){
							
							if(srchType == 'C'){
								if(dtlDoc.getElementById('custGrp'+i).value == ''){
									alert('Customer Group is a mandatory field');
									dtlDoc.getElementById('custGrp'+i).select();									
									return false;
								}
								if(dtlDoc.getElementById('cust'+i).value == ''){
									alert('Customer is a mandatory field');
									dtlDoc.getElementById('cust'+i).select();									
									return false;
								}
							}
							if($(dtlDoc).find('#blngClass'+i).val() == ''){
								alert('Billing Class is a mandatory field');
								$(dtlDoc).find('#blngClass'+i).select();
								return false;
							}
							if($(dtlDoc).find('#revisedPrice'+i).val() == ''){
								alert('Revised Price is a mandatory field');
								$(dtlDoc).find('#revisedPrice'+i).select();
								return false;
							}
							if($(dtlDoc).find('#revisedType'+i).val() == ''){
								alert('Revised Type is a mandatory field');
								$(dtlDoc).find('#revisedType'+i).focus();
								return false;
							}
							if($(dtlDoc).find('#effFrom'+i).val() == ''){
								alert('Effective From is a mandatory field');
								$(dtlDoc).find('#effFrom'+i).select();
								return false;
							}
						}
						
					}
					$('#PackageRevision').attr('class','tabA');
					$('#PackageRevisionSpan').attr('class','tabAspan');
					$('#DiscountRevision').attr('class','tabClicked');
					$('#DiscountRevisionSpan').attr('class','tabSpanclicked');
					 $(dtlDoc).find('#lastRowIndex').val(trLength);					 
					 getXMLString('Price');
					dtlDoc.location.href = '../../eBL/jsp/PkgDiscountRevision.jsp?priceType='+priceType;
					lookUpData.location.href = '../../eBL/jsp/PkgDiscountRevisionLookup.jsp?priceType='+priceType+
											'&blngClassCode='+blngClassCode+
											'&blngGrpCode='+blngGrpCode+
											'&custGrpCode='+custGrpCode+
											'&custCode='+custCode+
											'&pkgCode='+pkgCode+
											'&policyCode='+policyCode; //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
				}
			})
		});
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
				<li class="tablistitem" title='<fmt:message key="eBL.ServicePolicyCoverage.label" bundle="${bl_labels}"/>'>
				<a  class="tabClicked" id="PackageRevision">
					<span class="tabSpanclicked" id="PackageRevisionSpan">
						Package Price Revision
						</span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eBL.MaterialPolicyCoverage.label" bundle="${bl_labels}"/>'>
				<a  class="tabA" id="DiscountRevision" >
					<span class="tabAspan" id="DiscountRevisionSpan">					
						Discount Price Revision			
					</span></a>
			</li>
		</ul>
	</td>	
	</tr>
</table>
</body>
</html>

