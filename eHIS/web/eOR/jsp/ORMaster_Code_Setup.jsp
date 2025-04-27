<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	 String licence_key		= eOR.OR_license_rights.getKey();
%>

<html>
	<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<style>
		A:active {
			COLOR: white;
		}

	</style>

	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				
				//parent.location.href='../../eCommon/jsp/CommonClearObjects.jsp';
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
			
		}
		/*function openMenu(obj){
		
				parent.parent.parent.parent.frames[1].expand(obj)	
		}

		function dummy(){}*/

		function chcol(ro)
		{
			//alert("ro="+ro.value);
			//alert("BEFORE:prevcol="+prevcol);
				document.getElementById("t").rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				//alert("AFTER:prevcol="+prevcol);
				//alert("BEFORE:prev="+prev);
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
				//alert("AFTER:prev="+prev);
		}

		function callJSPs(val)
		{

			//alert("val="+val);
			/*
				Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/

			if(val == 'Order_Category'){
				parent.frames[1].location.href = 'OrderCategory.jsp?module_id=OR&function_id=Order Category&function_name='+encodeURIComponent(getLabel("Common.OrderCategory.label","Common"))+'&function_type=F&access=NYNNN';
			}
			else if(val == 'Order_type'){
				parent.frames[1].location.href = 'OrderType.jsp?module_id=OR&function_id=Order_Type&function_name='+encodeURIComponent(getLabel("Common.OrderType.label","Common"))+'&function_type=F&access=YYYNN';
			}

			if (val=='Consent_Format'){
			parent.frames[1].location.href='ConsentFormat.jsp?module_id=OR&function_id=Consent_Format&function_name='+encodeURIComponent(getLabel("eOR.ConsentRefusalReferralNotes.label","OR"))+'&function_type=f&access=YYYNN';
			}

			if (val=='Order_Types_for_Orderable'){
				parent.frames[1].location.href='OrderTypesforOrderable.jsp?module_id=OR&function_id=Order_Types_for_Orderable&function_name='+encodeURIComponent(getLabel("eOR.OrderCatalogbyOrderType.label","OR"))+'&function_type=f&access=YYYNN';
			}

			if (val=='Index_Order_Catalog'){
				parent.frames[1].location.href='IndexOrderCatalog.jsp?module_id=OR&function_id=Index_Order_Catalog&function_name='+encodeURIComponent(getLabel("eOR.IndexOrderCatalog.label","OR"))+'&function_type=f&access=YYYNN';
			}
			if (val=='Consent_for_Catalog'){
				parent.frames[1].location.href='OROrderCatalogMultiConsent.jsp?module_id=OR&function_id=Consent_for_Catalog&function_name='+encodeURIComponent(getLabel("eOR.ConsentForCatalog.label","OR"))+'&function_type=f&access=NNNNN';
			}
			if (val=='Pract_for_Consent'){
				parent.frames[1].location.href='PractForConsent.jsp?module_id=OR&function_id=Pract_for_Consent&function_name='+encodeURIComponent(getLabel("eOR.PractitionerForConsent.label","OR"))+'&function_type=f&access=YYNNN';
			}
			if (val=='Order_Entry_Format_Items'){
				parent.frames[1].location.href='OrderEntryFormatItems.jsp?module_id=OR&function_id=Order_Entry_Format_Items&function_name='+encodeURIComponent(getLabel("eOR.OrderEntryFormatItem.label","OR"))+'&function_type=f&access=YYYNN';
			}
			if (val=='Order_Entry_Formats'){
				parent.frames[1].location.href='OrderEntryFormats.jsp?module_id=OR&function_id=Order_Entry_Formats&function_name='+encodeURIComponent(getLabel("eOR.OrderEntryFormat.label","OR"))+'&function_type=f&access=YYYYN';
			}
				if (val=='Tick_Sheet'){
				parent.frames[1].location.href='TickSheets.jsp?module_id=OR&function_id=Tick_Sheets&function_name='+encodeURIComponent(getLabel("eOR.TickSheet.label","OR"))+'&function_type=f&access=YYYNN';
			}
			if (val=='Tick_Sheet_Section'){
				parent.frames[1].location.href='SectionForTickSheet.jsp?module_id=OR&function_id=Tick_Sheet_Section&function_name='+encodeURIComponent(getLabel("eOR.TickSheetSection.label","OR"))+'&function_type=f&access=YYYNN';
			}
			if (val=='Catalogs_by_Section'){
				parent.frames[1].location.href='CatalogsbySection.jsp?module_id=OR&function_id=Catalogs_by_Section&function_name='+encodeURIComponent(getLabel("eOR.OrderCatalogbyTickSheetSection.label","OR"))+'&function_type=f&access=YYYNN';
			}

			if (val=='Order_Catalog'){
				parent.frames[1].location.href='OrderCatalog.jsp?module_id=OR&function_id=Order_Catalog&function_name='+encodeURIComponent(getLabel("Common.ordercatalog.label","COMMON"))+'&function_type=f&access=YYYNN';
			}

           if (val=='Index_Order_Care/Set'){
				parent.frames[1].location.href='IndexOrderCareSet.jsp?module_id=OR&function_id=Index_Order_Care/Set&function_name='+encodeURIComponent(getLabel("eOR.IndexOrderSet.label","OR"))+'&function_type=f&access=YYYNN';
			}

			if (val=='Index_Tick_Sheet'){
				parent.frames[1].location.href='IndexTickSheet.jsp?module_id=OR&function_id=Index_Tick_Sheet&function_name='+encodeURIComponent(getLabel("eOR.IndexTickSheet.label","OR"))+'&function_type=f&access=YYYNN';
			}
			if (val=='Performing_location'){
				parent.frames[1].location.href='PerformingLocation.jsp?module_id=OR&function_id=Performing_location&function_name='+encodeURIComponent(getLabel("Common.PerformingLocation.label","COMMON"))+'&function_type=f&access=YYYNN';
			}
		    if (val=='Orderables_Performing_Location'){
				parent.frames[1].location.href='OrderablesByPerformingLocation.jsp?module_id=OR&function_id=Orderables_By_Performing_Location&function_name='+encodeURIComponent(getLabel("eOR.OrderablesbyPerformingLocation.label","OR"))+'&function_type=f&access=YYYNN';
			}
              //Scheduled for second Phase
			if (val=='Multi_Facility_Processing'){
				parent.frames[1].location.href='MultiFacilityProcessing.jsp?module_id=OR&function_id=Multi_Facility_Processing&function_name='+encodeURIComponent(getLabel("eOR.MultiFacilityProcessing.label","OR"))+'&function_type=f&access=YYYYN';
			}
			if (val=='Order_Status'){
				parent.frames[1].location.href='OrderStatusCode.jsp?module_id=OR&function_id=Order_Status&function_name='+encodeURIComponent(getLabel("Common.OrderStatus.label","Common"))+'&function_type=f&access=YYYNN';
			}
			if (val=='Reason_Code'){
				parent.frames[1].location.href='ReasonCode.jsp?module_id=OR&function_id=Reason_Code&function_name='+encodeURIComponent(getLabel("Common.ReasonCode.label","COMMON"))+'&function_type=f&access=YYYNN';
			}
			if (val=='Text_Block'){
				parent.frames[1].location.href='TextBlock.jsp?module_id=OR&function_id=Text_Block&function_name='+encodeURIComponent(getLabel("Common.TextBlock.label","COMMON"))+'&function_type=f&access=YYYNN';
			}

			if (val=='Frequency_scope'){
				parent.frames[1].location.href='FrequencyScope.jsp?module_id=OR&function_id=Frequency&function_name='+encodeURIComponent(getLabel("eOR.FrequencyScope.label","OR"))+'&function_type=f&access=YYYNN';

			}
			if (val=='Image_Hotspot_Link'){
				parent.frames[1].location.href='ImageHotspotLink.jsp?module_id=OR&function_id=Image_Hotspot_Link&function_name='+encodeURIComponent(getLabel("eOR.ImageHotspotLink.label","OR"))+'&function_type=f&access=YYYYN';

			}

			if (val=='Chart_Result_Type'){
				parent.frames[1].location.href='ChartResultType.jsp?module_id=OR&function_id=Chart_Result_Type&function_name='+encodeURIComponent(getLabel("eOR.resultmatrix.label","OR"))+'&function_type=f&access=YYYNN';
			}
			if (val=='Chart_Horizontal'){
				parent.frames[1].location.href='ChartHorizontal.jsp?module_id=OR&function_id=Chart_Horizontal&function_name='+encodeURIComponent(getLabel("eOR.MatrixColumn.label","OR"))+'&function_type=f&access=YYYNN';

			}
			if (val=='Chart_Vertical'){
				parent.frames[1].location.href='ChartVertical.jsp?module_id=OR&function_id=Chart_Vertical&function_name='+encodeURIComponent(getLabel("eOR.MatrixRow.label","OR"))+'&function_type=f&access=YYYNN';

			}
			if (val=='Orders_Tab'){
				parent.frames[1].location.href='OrdersTab.jsp?module_id=OR&function_id=OrdersTab&function_name='+encodeURIComponent(getLabel("eOR.OrdersTab.label","OR"))+'&function_type=f&access=YYYYN';

			}
			if (val=='Result_Template'){
				parent.frames[1].location.href='ResultTemplate.jsp?module_id=OR&function_id=Result_Template&function_name='+encodeURIComponent(getLabel("Common.ResultTemplate.label","COMMON"))+'&function_type=f&access=YYYYN';

			}
 
			
			if (val=='Image_Hotspot'){
				parent.frames[1].location.href='ImageHotspot.jsp?module_id=OR&function_id=Image_Hotspot&function_name='+encodeURIComponent(getLabel("eOR.ImageHotspot.label","OR"))+'&function_type=f&access=YYNYN';

			}
			if (val=='Activity_Type'){
				parent.frames[1].location.href='ActivityType.jsp?module_id=OR&function_id=Activity_Type&function_name='+encodeURIComponent(getLabel("eOR.ActivityType.label","OR"))+'&function_type=f&access=YYYNN';

			}
			if (val=='Charge_Type'){
				parent.frames[1].location.href='ChargeType.jsp?module_id=OR&function_id=Charge_Type&function_name='+encodeURIComponent(getLabel("eOR.ChargeType.label","OR"))+'&function_type=f&access=YYYYN';

			}
			if (val=='Order_Catalog_Procedure_Link'){
				parent.frames[1].location.href='OrderCatalogProcedureLink.jsp?module_id=OR&function_id=Order_Catalog_Procedure_Link&function_name='+encodeURIComponent(getLabel("eOR.OrderCatalogtoProcedureLink.label","OR"))+'&function_type=f&access=YYYYN';

			}
			if(val=='Replaceable_Orderable'){
				parent.frames[1].location.href='ReplaceableOrderable.jsp?module_id=OR&function_id=Replaceable_Orderable&function_name='+encodeURIComponent(getLabel("eOR.ReplaceableOrderable.label","OR"))+'&function_type=f&access=YYYYN';
			}
			if(val=='Specimen_For_Orderable'){
				parent.frames[1].location.href='SpecimenForOrderable.jsp?module_id=OR&function_id=Specimen_For_Orderable&function_name='+encodeURIComponent(getLabel("eOR.SpecimenForOrderable.label","OR"))+'&function_type=f&access=YYNNYN';
			}
			if(val=='Speciality_For_Orderable'){
				parent.frames[1].location.href='SpecialityForOrderable.jsp?module_id=OR&function_id=Speciality_For_Orderable&function_name='+encodeURIComponent(getLabel("eOR.SpecialityForOrderable.label","OR"))+'&function_type=f&access=YYNNYN';
			}
			if(val=='Future_Order'){
				parent.frames[1].location.href='FutureOrder.jsp?module_id=OR&function_id=Future_Order&function_name=Future Order&function_type=f&access=YYNNYN';
			}
			if(val=='Order_Catalog_Lookup'){
				parent.frames[1].location.href='OrderCatalogLookup.jsp?module_id=OR&function_id=Order_Catalog_Lookup&function_name=Order Catalog Lookup&function_type=f&access=YYNNYN';
			}
			
		}



	async function showFunctionality(){
		var retVal = new Array();

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';
		var arguments	= '' ;

		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;

		arguments = vals

		//retVal = window.showModalDialog('change_functionality.jsp',arguments,features);

		retVal	= await window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			//alert(retVal)
			retVal = retVal.replace("location","parent.parent.frames[1].location")	 
			eval(retVal)
		}
	}

	</script>

	</head>

	<body style="background-color:dimgray;"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>

	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Order_Category')"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Order_type')"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		</tr>
				<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Consent_Format')"><fmt:message key="eOR.ConsentRefusalReferralNotes.label" bundle="${or_labels}"/></td>
		</tr>
		<!--<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Order_Types_for_Orderable')">Order Catalog by Order Type</td>
		</tr>-->


		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Index_Order_Catalog')"><fmt:message key="eOR.IndexOrderCatalog.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Consent_for_Catalog')"><fmt:message key="eOR.ConsentForCatalog.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Pract_for_Consent')"><fmt:message key="eOR.PractitionerForConsent.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Order_Entry_Format_Items')"><fmt:message key="eOR.OrderEntryFormatItem.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Order_Entry_Formats')"><fmt:message key="eOR.OrderEntryFormat.label" bundle="${or_labels}"/></td>
		</tr>


		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Index_Order_Care/Set')"><fmt:message key="eOR.IndexOrderSet.label" bundle="${or_labels}"/></td>
		</tr>

		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Tick_Sheet')"><fmt:message key="eOR.TickSheet.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Tick_Sheet_Section')"><fmt:message key="eOR.TickSheetSection.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Catalogs_by_Section')"><fmt:message key="eOR.OrderCatalogbyTickSheetSection.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Index_Tick_Sheet')"><fmt:message key="eOR.IndexTickSheet.label" bundle="${or_labels}"/></td>
		</tr>
<% if(licence_key.equals("ORFV")) { %>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Performing_location')"><fmt:message key="eOR.PerformingLocations.label" bundle="${or_labels}"/></td>
		</tr>
        <tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Orderables_Performing_Location')"><fmt:message key="eOR.OrderablesbyPerformingLocation.label" bundle="${or_labels}"/></td>
		</tr>


		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Multi_Facility_Processing')"><fmt:message key="eOR.MultiFacilityProcessing.label" bundle="${or_labels}"/></td>
		</tr>
<%	} %>
		<tr onClick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Frequency_scope')"><fmt:message key="eOR.FrequencyScope.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Reason_Code')"><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></td>
		</tr>
<% if(licence_key.equals("ORFV")) { %>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Text_Block')"><fmt:message key="Common.TextBlock.label" bundle="${common_labels}"/></td>
		</tr>
<% } %>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Order_Status')"><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
		</tr>

<% if(licence_key.equals("ORFV")) { %>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Image_Hotspot')"><fmt:message key="eOR.ImageHotspot.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Image_Hotspot_Link')"><fmt:message key="eOR.ImageHotspotLink.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Chart_Result_Type')"><fmt:message key="eOR.resultmatrix.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Chart_Horizontal')"><fmt:message key="eOR.MatrixColumn.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Chart_Vertical')"><fmt:message key="eOR.MatrixRow.label" bundle="${or_labels}"/></td>
		</tr>
<% } %>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Orders_Tab')"><fmt:message key="eOR.OrdersTab.label" bundle="${or_labels}"/></td>
		</tr>
	
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Activity_Type')"><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
		</tr>
<% if(licence_key.equals("ORFV")) { %>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Charge_Type')"><fmt:message key="eOR.ChargeType.label" bundle="${or_labels}"/></td>
		</tr>				

<!--		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Result_Template')">Result Template</td>
		</tr>-->

		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Order_Catalog_Procedure_Link')"><fmt:message key="eOR.OrderCatalogtoProcedureLink.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Replaceable_Orderable')"><fmt:message key="eOR.ReplaceableOrderable.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Specimen_For_Orderable')"><fmt:message key="eOR.SpecimenForOrderable.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Speciality_For_Orderable')"><fmt:message key="eOR.SpecialityForOrderable.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Order_Catalog_Lookup')">Order Catalog Lookup</td>
		</tr> 
		<!-- <tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Future_Order')">Future Order </td>
		</tr> -->
<!--		<tr onClick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('test')">Test</td>
		</tr> -->
<% } %>
<!--		<tr onClick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Template')">Template</td>
		</tr>-->

	 	<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href="javascript:goHomePage()" style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>
	
	 <!-- <tr >
			<td class='ECMENUHIGHERLEVELCOLOR' onclick=openMenu(this) style="cursor:pointer"><b>Menu</b></td>
				
	</tr> -->

	</table>

	</body>
	</form>
</html>

