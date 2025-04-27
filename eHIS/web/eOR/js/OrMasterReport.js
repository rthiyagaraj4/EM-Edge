/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function loadPage(objVal) {
	if(objVal=="") {
		parent.searchResultFrame.location.href="../../eCommon/html/blank.html";
	}	
 else if(objVal==1){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportOrderType.jsp";
	 }
 else if(objVal==2){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportConsentNote.jsp";
	  }
 else if(objVal==3){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportOrderCatalog.jsp";
	 }
else if(objVal==4){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportIndexOrderCatalog.jsp";
	 }
else if(objVal==5){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportOrderEntryFormatItem.jsp";
	 }
else if(objVal==6){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportOrderEntryFormat.jsp";
	 }
else if(objVal==7){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportIndexOrderSet.jsp";
	 }
else if(objVal==8){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportTickSheet.jsp";
	 }
else if(objVal==9){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportTickSheetSection.jsp";
	 }
else if(objVal==10){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportCatalogBySection.jsp";
	 }
else if(objVal==11){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportIndexTickSheet.jsp";
	 }
else if(objVal==12){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportFrequencyScope.jsp";
	 }

else if(objVal==13){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportReasonCode.jsp";
	 }
	 else if(objVal==14){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportTextBlock.jsp";
	 }

 else if(objVal==15){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportOrderStatus.jsp";
	 }
	 else if(objVal==16){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportImageHotspot.jsp";
	 }
	 else if(objVal==17){

		parent.searchResultFrame.location.href="../../eOR/jsp/ORMasterReportImageHotspotLink.jsp";
	 }

	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

}

function run() {
		alert("run clicked");
	if(searchResultFrame.document.formOrRepOrderType) {
		if(CheckString(getLabel("eOR.OrderTypeCode.label","OR"), searchResultFrame.document.formOrRepOrderType.from_order_type, searchResultFrame.document.formOrRepOrderType.to_order_type, messageFrame) ) 
					searchResultFrame.document.formOrRepOrderType.submit(); 
				}

	if(searchResultFrame.document.formOrRepConsentNote) {
				if(CheckString(getLabel("eOR.ConsentNoteType.label","OR"), searchResultFrame.document.formOrRepConsentNote.from_consent_note, searchResultFrame.document.formOrRepConsentNote.to_consent_note, messageFrame) )
							searchResultFrame.document.formOrRepConsentNote.submit();
			}

	if(searchResultFrame.document.formOrRepTickSheet) {
			if(CheckString(getLabel("eOR.TickSheet.label","OR"), searchResultFrame.document.formOrRepTickSheet.from_tick_sheet, searchResultFrame.document.formOrRepTickSheet.to_tick_sheet, messageFrame) )
					searchResultFrame.document.formOrRepTickSheet.submit();
			}

	if(searchResultFrame.document.formOrTickSheetSection) {
			if(CheckString(getLabel("eOR.TickSheetSection.label","OR"), searchResultFrame.document.formOrTickSheetSection.from_tick_sheet_section, searchResultFrame.document.formOrTickSheetSection.to_tick_sheet_section, messageFrame) )
						searchResultFrame.document.formOrTickSheetSection.submit();
			}

	if(searchResultFrame.document.formOrTextBlock) {
		if(CheckString(getLabel("eOR.Text Block.label","OR"), searchResultFrame.document.formOrTextBlock.from_text_block, searchResultFrame.document.formOrTextBlock.to_text_block, messageFrame) )
			searchResultFrame.document.formOrTextBlock.submit();
	}

	if(searchResultFrame.document.formOrRepFrequencyScope) {
		if(CheckString(getLabel("eOR.FrequenctScope.label","OR"), searchResultFrame.document.formOrRepFrequencyScope.from_frequency_scope, searchResultFrame.document.formOrRepFrequencyScope.to_frequency_scope, messageFrame) ) 
						searchResultFrame.document.formOrRepFrequencyScope.submit();
		}
	

	if(searchResultFrame.document.formOrRepOrderEntryFormat) {
				if(CheckString(getLabel("eOR.OrderEntryFormat.label","OR"), searchResultFrame.document.formOrRepOrderEntryFormat.from_order_entry_format, searchResultFrame.document.formOrRepOrderEntryFormat.to_order_entry_format, messageFrame) )
						searchResultFrame.document.formOrRepOrderEntryFormat.submit();
	}

	if(searchResultFrame.document.formOrRepOrderEntryFormatItem) {
				if(CheckString(getLabel("eOR.OrderEntryFormat Item.label","OR"), searchResultFrame.document.formOrRepOrderEntryFormatItem.from_order_entry_format_item, searchResultFrame.document.formOrRepOrderEntryFormatItem.to_order_entry_format_item, messageFrame) ) {
							searchResultFrame.document.formOrRepOrderEntryFormatItem.submit();}
				}
	if(searchResultFrame.document.formOrRepImageHotspot) {
			if(CheckString(getLabel("eOR.ImageHotspot.label","OR"), searchResultFrame.document.formOrRepImageHotspot.from_image_hotspot, searchResultFrame.document.formOrRepImageHotspot.to_image_hotspot, messageFrame) ) {
						searchResultFrame.document.formOrRepImageHotspot.submit();}
				}

	if(searchResultFrame.document.formOrRepImageHotspotLink) {
					if(CheckString(getLabel("eOR.ImageHotspotLink.label","OR"), searchResultFrame.document.formOrRepImageHotspotLink.from_image_hotspot_link, searchResultFrame.document.formOrRepImageHotspotLink.to_image_hotspot_link, messageFrame) )
							searchResultFrame.document.formOrRepImageHotspotLink.submit();
			}

	if(searchResultFrame.document.formOrRepIndexOrderCatalog) {
				if(CheckString(getLabel("eOR.IndexOrderCatalog.label","OR"), searchResultFrame.document.formOrRepIndexOrderCatalog.from_index_order_catalog, searchResultFrame.document.formOrRepIndexOrderCatalog.to_index_order_catalog, messageFrame) )
						searchResultFrame.document.formOrRepIndexOrderCatalog.submit();
			}

	if(searchResultFrame.document.formOrRepIndexOrderSet) {
				if(CheckString(getLabel("eOR.IndexOrderSet.label","OR"), searchResultFrame.document.formOrRepIndexOrderSet.from_index_order_set, searchResultFrame.document.formOrRepIndexOrderSet.to_index_order_set, messageFrame) )
						searchResultFrame.document.formOrRepIndexOrderSet.submit();
				}

	if(searchResultFrame.document.formOrRepIndexTickSheet) {
				if(CheckString(getLabel("eOR.IndexTickSheet.label","OR"), searchResultFrame.document.formOrRepIndexTickSheet.from_index_tick_sheet, searchResultFrame.document.formOrRepIndexTickSheet.to_index_tick_sheet, messageFrame) ) {
							searchResultFrame.document.formOrRepIndexTickSheet.submit();	}
			}

	if(searchResultFrame.document.formOrRepOrderCatalog) {
				if(CheckString(getLabel("Common.ordercatalog.label","Common"), searchResultFrame.document.formOrRepOrderCatalog.p_from_otcode, searchResultFrame.document.formOrRepOrderCatalog.p_to_otcode, messageFrame) )
							searchResultFrame.document.formOrRepOrderCatalog.submit();
			}

	if(searchResultFrame.document.formOrRepOrderStatus) {
				if(CheckString(getLabel("Common.OrderStatus.label","Common"), searchResultFrame.document.formOrRepOrderStatus.p_from_order_status, searchResultFrame.document.formOrRepOrderStatus.p_to_order_status, messageFrame) )
						searchResultFrame.document.formOrRepOrderStatus.submit();  //formOrRepReasonCode
		}
	if(searchResultFrame.document.formOrRepReasonCode) {
				if(CheckString(getLabel("eOR.ReasonCode.label","OR"), searchResultFrame.document.formOrRepReasonCode.from_reason_code, searchResultFrame.document.formOrRepReasonCode.to_reason_code, messageFrame) )
						searchResultFrame.document.formOrRepReasonCode.submit();  //formOrRepReasonCode
		}
if(searchResultFrame.document.formOrRepIndexOrderCatalog) {
			if(CheckString(getLabel("eOR.IndexOrderCatalog.label","OR"), searchResultFrame.document.formOrRepIndexOrderCatalog.from_order_catalog, searchResultFrame.document.formOrRepIndexOrderCatalog.to_order_catalog, messageFrame) )
					searchResultFrame.document.formOrRepIndexOrderCatalog.submit();  //formOrRepReasonCode
			}
}

function searchCode( frmObj, searchFor, target ) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var retArray 		= new Array() ;

	if (searchFor == getLabel("eOR.OrderTypeCode.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_ORDER_TYPE_CODE_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}
	
	if (searchFor == getLabel("eOR.ConsentNoteText.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_CONSENT_NOTE_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.OrdercatalogCode.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_ORDER_CATALOG_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.IndexOrderCatalog.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_INDEX_ORDER_CATALOG_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.OrderEntryFormat Item.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_ORDER_ENTRY_FORMAT_ITEM_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.OrderEntryFormat.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_ORDER_ENTRY_FORMAT_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.IndexOrderSet.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_INDEX_ORDER_SET_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.TickSheet.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_TICK_SHEET_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.TickSheetSection.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_TICK_SHEET_SECTION_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.ReasonCode.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_REASON__CODE_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.Order CatalogByTickSheetSection.label","OR")) {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_ATC1_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.IndexTickSheet.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_INDEX_TICK_SHEET_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.FrequencyScope.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_FREQUENCY_SCOPE_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("eOR.Text Block.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_TEXT_BLOCK_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == getLabel("Common.OrderStatus.label","Common")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_ORDER_STATUS_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}
	if (searchFor == getLabel("eOR.ImageHotspot.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_IMAGE_HOTSPOT_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}
	if (searchFor == getLabel("eOR.ImageHotspotLink.label","OR")) {
		argumentArray[0] = frmObj.SQL_OR_REPORTS_IMAGE_HOTSPOT_LINK_LOOKUP.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}
	  
	retArray = CommonLookup( searchFor, argumentArray );

	if(retArray != null && retArray != "" ) {
		target.value = retArray[0];	/* if code need to be returned */
		target.focus();
	}

}																											 

function reset() {
	searchFrame.formORReportsMasterList.reset();
	searchResultFrame.document.location.href='../../eCommon/html/blank.html';
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
