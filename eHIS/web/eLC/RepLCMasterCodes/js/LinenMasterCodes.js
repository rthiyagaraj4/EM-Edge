		var functionId="LC_CODE_LIST_REPORTS";
		function create() { 
				var Mode = "master";
				content.location.href = contextPath + "/RepLinenMasterCodesAction.do?method=" + loadMethod+"&mode="+Mode+"&vo.functionId="+functionId;
			}
		function getMasterCodes(objVal){
				if(objVal=="") {
				parent.reportsFrame.location.href = contextPath+"/core/jsp/blank.jsp";		
			}
			else if(objVal=="I") {
				var Mode = "I";
				parent.reportsFrame.location.href = contextPath + "/RepLinenMasterCodesAction.do?method="+loadMethod+"&mode="+Mode+"&vo.functionId="+functionId;
			}
			else if(objVal=="T") {
				var Mode = "T";
				parent.reportsFrame.location.href= contextPath + "/RepLinenMasterCodesAction.do?method="+loadMethod+"&mode="+Mode+"&vo.functionId="+functionId;
			}
			else if(objVal=="A"){
				var Mode = "A";
				parent.reportsFrame.location.href= contextPath + "/RepLinenMasterCodesAction.do?method="+loadMethod+"&mode="+Mode+"&vo.functionId="+functionId;
			}
			else if(objVal=="R"){
				var Mode = "R";
				parent.reportsFrame.location.href= contextPath + "/RepLinenMasterCodesAction.do?method="+loadMethod+"&mode="+Mode+"&vo.functionId="+functionId;
			}
			else if(objVal=="S"){
				var Mode = "S";
				parent.reportsFrame.location.href= contextPath + "/RepLinenMasterCodesAction.do?method="+loadMethod+"&mode="+Mode+"&vo.functionId="+functionId;
			}
			else if(objVal=="L"){
				var Mode = "L";
				parent.reportsFrame.location.href= contextPath + "/RepLinenMasterCodesAction.do?method="+loadMethod+"&mode="+Mode+"&vo.functionId="+functionId;
			}
		}
		
	function showLookup(mode,method){

		var sourceCodeHiddenFrom = document.getElementById("sourceCodeHiddenFrom");
		var sourceCodeHiddenTo = document.getElementById("sourceCodeHiddenTo");
		var laundryHiddenFrom = document.getElementById("laundryHiddenFrom");
		var laundryHiddenTo = document.getElementById("laundryHiddenTo");
		var reasonCodeHiddenFrom = document.getElementById("reasonCodeHiddenFrom");
		var reasonCodeHiddenTo = document.getElementById("reasonCodeHiddenTo");
		var actionTypeCodeHiddenFrom = document.getElementById("actionTypeCodeHiddenFrom");
		var actionTypeCodeHiddenTo = document.getElementById("actionTypeCodeHiddenTo");
		var agencyCodeHiddenFrom = document.getElementById("agencyCodeHiddenFrom");
		var agencyCodeHiddenTo = document.getElementById("agencyCodeHiddenTo");
		var linenItemHiddenFrom = document.getElementById("linenItemHiddenFrom");
		var linenItemHiddenTo = document.getElementById("linenItemHiddenTo");
		var linenTypeHiddenFrom = document.getElementById("linenTypeHiddenFrom");
		var linenTypeHiddenTo = document.getElementById("linenTypeHiddenTo");
		
		var linenTypeFrom = document.getElementById("vo.linenTypeFrom");
		var linenTypeTo = document.getElementById("vo.linenTypeTo");
		var linenItemFrom = document.getElementById("vo.linenItemFrom");
		var linenItemTo = document.getElementById("vo.linenItemTo");
		var agencyCodeFrom = document.getElementById("vo.agencyCodeFrom");
		var agencyCodeTo = document.getElementById("vo.agencyCodeTo");
		var reasonCodeFrom = document.getElementById("vo.reasonCodeFrom");
		var reasonCodeTo = document.getElementById("vo.reasonCodeTo");
		var actionTypeCodeFrom = document.getElementById("vo.actionTypeCodeFrom");
		var actionTypeCodeTo = document.getElementById("vo.actionTypeCodeTo");
		var laundryFrom = document.getElementById("vo.laundryFrom");
		var laundryTo = document.getElementById("vo.laundryTo");
		var sourceCodeFrom = document.getElementById("vo.sourceCodeFrom");
		var sourceCodeTo = document.getElementById("vo.sourceCodeTo");
		var sourceType = document.getElementById("vo.sourceType");
		
		var argArray = new Array();
		var datatypesArray = new Array();
		var valuesArray = new Array();
		var namesArray = new Array();

			if(mode == "linenType"){
				valuesArray[0]= document.getElementById("locale").value;
				namesArray[0] = "languageId";
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[0] = "ehis.lc.linenItem.getLinenType";
				}else if(mode == "agencyCode"){
					valuesArray[0]= document.getElementById("locale").value;
					namesArray[0] = "languageId";
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					argArray[0] = "ehis.lc.agencyCode.getAgencyCode";					
				}else if(mode == "reasonCode"){
				if(method == "RCLookupFrom" || method == "RCLookupTo"){
						valuesArray[0]= document.getElementById("locale").value;
						namesArray[0] = "languageId";
						argArray[1] = namesArray;
						argArray[2] = valuesArray;
						argArray[0] = "ehis.lc.reasonCode.getReasonCode";
					}else{
						valuesArray[0]= document.getElementById("locale").value;
						namesArray[0] = "languageId";
						argArray[1] = namesArray;
						argArray[2] = valuesArray;
						argArray[0] = "ehis.lc.reason.getActionType";
					}
			}else if(mode == "laundryCodes"){
						valuesArray[0]= document.getElementById("facilityId").value;
						namesArray[0] = "facilityId";
						argArray[1] = namesArray;
						argArray[2] = valuesArray;
						argArray[0] = "ehis.lc.getLcUser";
					}else if(mode == "linenItem"){
				if(method == "LILookupFrom" || method == "LILookupTo"){
						valuesArray[0]= document.getElementById("locale").value;
						namesArray[0] = "languageId";
						argArray[1] = namesArray;
						argArray[2] = valuesArray;
						argArray[0] = "ehis.lc.standardStock.linenItem";
					}else{
					argArray[0] = "ehis.lc.linenItem.getLinenType";
					}
			}else if(mode == "standardStock"){
			if(method == "LILookupFrom" || method == "LILookupTo"){	
				valuesArray[0]= document.getElementById("locale").value;
				namesArray[0] = "languageId";
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[0] = "ehis.lc.standardStock.linenItem";
				}	
			if(method == "SCLookupFrom" || method == "SCLookupTo"){		
				if(sourceType.value == "W"){
					valuesArray[0]= document.getElementById("locale").value;
					namesArray[0] = "languageId";
					valuesArray[1]= document.getElementById("facilityId").value;
					namesArray[1] = "facilityId";
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					argArray[0] = "ehis.lc.standardStock.nursingUnit";
				}else if(sourceType.value == "C"){
					valuesArray[0]= document.getElementById("locale").value;
					namesArray[0] = "languageId";
					valuesArray[1]= document.getElementById("facilityId").value;
					namesArray[1] = "facilityId";
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					argArray[0] = "ehis.lc.standardStock.clinic";
				}else if(sourceType.value == "D"){
					valuesArray[0]= document.getElementById("locale").value;
					namesArray[0] = "languageId";
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					argArray[0] = "ehis.lc.standardStock.deptCode";
					}
				}
			}	
		
			//Display Order
			argArray[3] =DESC_CODE ;
			// Link Description
			argArray[4] = DESC_LINK;
			if(mode == "linenType"){
					if(method == "LTLookupFrom"){
					argArray[5] = linenTypeFrom.value;
					}else{
					argArray[5] = linenTypeFrom.value;
					}
				}else if(mode == "linenItem"){
					if(method == "LTLookupFrom"){
						
						argArray[5] = linenTypeFrom.value;
					}else if(method == "LTLookupTo"){
						argArray[5] = linenTypeFrom.value;
					}else if(method == "LILookupFrom"){
						argArray[5] = linenItemFrom.value;
					}else if(method == "LILookupTo"){
						argArray[5] = linenItemTo.value;
					}
				}else if(mode == "agencyCode"){
					if(method == "ACLookupFrom"){
						argArray[5] = agencyCodeFrom.value;
					}else{
						argArray[5] = agencyCodeTo.value;
					}
				}else if(mode == "reasonCode"){
					if(method == "RCLookupFrom"){
						argArray[5] = reasonCodeFrom.value;
					}else if(method == "RCLookupTo"){
						argArray[5] = reasonCodeTo.value;
					}else if(method == "ATCLookupFrom"){
						argArray[5] = actionTypeCodeFrom.value;
					}else if(method == "ATCLookupTo"){
						argArray[5] = actionTypeCodeTo.value;
					}
				}else if(mode == "standardStock"){
					if(method == "SCLookupFrom"){
						argArray[5] = sourceCodeFrom.value;
					}else if(method == "SCLookupTo"){
						argArray[5] = sourceCodeTo.value;
					}else if(method == "LILookupFrom"){
						argArray[5] = linenItemFrom.value;
					}else if(method == "LILookupTo"){
						argArray[5] = linenItemTo.value;
					}
				}else if(mode == "laundryCodes"){
					if(method == "LCLookupFrom"){
						argArray[5] = laundryFrom.value;
					}else {
						argArray[5] = laundryTo.value;
					}
				}
			// Lookup will return code and description - retArr hold it

			getServerMessage("com.iba.ehis.lc.linenType");
			var linenTypeLabel = dwrMessage;
			getServerMessage("com.iba.ehis.lc.linenItem");
			var linenItemLabel = dwrMessage;
			getServerMessage("com.iba.ehis.lc.agencyCode.agencyCode");
			var agencyLabel = dwrMessage;
			getServerMessage("com.iba.ehis.lc.reasonCode");
			var reasonCodeLabel = dwrMessage;
			getServerMessage("com.iba.ehis.lc.reason.actionType");
			var actionTypeLabel = dwrMessage;
			getServerMessage("com.iba.ehis.lc.laundryUserId");
			var lanudryuserIdLabel = dwrMessage;
			getServerMessage("com.iba.ehis.lc.ward");
			var wardLabel = dwrMessage;
			getServerMessage("com.iba.ehis.lc.clinic");
			var clinicLabel = dwrMessage;
			getServerMessage("com.iba.ehis.lc.department");
			var deptLabel = dwrMessage;

			if(mode == "linenType"){
			retArr= Lookup(linenTypeLabel,argArray)
			}else if(mode == "linenItem"){
				if(method == "LILookupFrom" || method == "LILookupTo"){
					retArr = Lookup(linenItemLabel,argArray);
				}else{
					retArr = Lookup(linenTypeLabel,argArray);
					}
			}else if(mode == "agencyCode"){
				retArr = Lookup(agencyLabel,argArray);
			}else if(mode == "reasonCode"){
				if(method == "RCLookupFrom" || method == "RCLookupTo"){
					retArr = Lookup(reasonCodeLabel,argArray);	
				}else{
					retArr = Lookup(actionTypeLabel,argArray);	
					}
			}else if(mode == "laundryCodes"){
				retArr = Lookup(lanudryuserIdLabel,argArray);			
			}else if(mode == "standardStock"){
				if(method == "SCLookupFrom" || method == "SCLookupTo"){
				if(sourceType.value == "W"){
					retArr = Lookup(wardLabel,argArray);			
				}else if(sourceType.value == "C"){
					retArr = Lookup(clinicLabel,argArray);			
				}else if(sourceType.value == "D"){
					retArr = Lookup(deptLabel,argArray);			
				}
			}else
				retArr = Lookup(linenItemLabel,argArray);
			}if(retArr!=null){
				if(mode == "linenType"){
					if(method == "LTLookupFrom"){
						linenTypeFrom.value = retArr[1];
						linenTypeHiddenFrom.value = retArr[0];

					}else{
						linenTypeTo.value = retArr[1];
						linenTypeHiddenTo.value = retArr[0];
					}
				}else if(mode == "linenItem"){
					if(method == "LTLookupFrom"){
						linenTypeFrom.value = retArr[1];
						linenTypeHiddenFrom.value = retArr[0];
					}else if(method == "LTLookupTo"){
						linenTypeTo.value = retArr[1];
						linenTypeHiddenTo.value = retArr[0];
					}else if(method == "LILookupFrom"){
						linenItemFrom.value = retArr[1];
						linenItemHiddenFrom.value = retArr[0];
					}else if(method == "LILookupTo"){
						linenItemTo.value = retArr[1];
						linenItemHiddenTo.value = retArr[0];
					}
				}else if(mode == "agencyCode"){
					if(method == "ACLookupFrom"){
						agencyCodeFrom.value = retArr[1];
						agencyCodeHiddenFrom.value = retArr[0];
					}else{
						agencyCodeTo.value = retArr[1];
						agencyCodeHiddenTo.value = retArr[0];
					}
				}else if(mode == "reasonCode"){
					if(method == "RCLookupFrom"){
						reasonCodeFrom.value = retArr[1];
						reasonCodeHiddenFrom.value = retArr[0];
					}else if(method == "RCLookupTo"){
						reasonCodeTo.value = retArr[1];
						reasonCodeHiddenTo.value = retArr[0];
					}else if(method == "ATCLookupFrom"){
						actionTypeCodeFrom.value = retArr[1];
						actionTypeCodeHiddenFrom.value = retArr[0];
					}else if(method == "ATCLookupTo"){
						actionTypeCodeTo.value = retArr[1];
						actionTypeCodeHiddenTo.value = retArr[0];
					}
				}else if(mode == "standardStock"){
					if(method == "SCLookupFrom"){
						sourceCodeFrom.value = retArr[1];
						sourceCodeHiddenFrom.value = retArr[0];
					}else if(method == "SCLookupTo"){
						sourceCodeTo.value = retArr[1];
						sourceCodeHiddenTo.value = retArr[0];
					}else if(method == "LILookupFrom"){
						linenItemFrom.value = retArr[1];
						linenItemHiddenFrom.value = retArr[0];
					}else if(method == "LILookupTo"){
						linenItemTo.value = retArr[1];
						linenItemHiddenTo.value = retArr[0];
					}
				}else if(mode == "laundryCodes"){
					if(method == "LCLookupFrom"){
						laundryFrom.value = retArr[1];
						laundryHiddenFrom.value = retArr[0];
					}else {
						laundryTo.value = retArr[1];
						laundryHiddenTo.value = retArr[0];
					}
				}
			}	
		}

	function run(){
		
		var reportId = content.reportsFrame.document.RepLinenMasterCodesForm["vo.repId"].value;
 		
		// 1. AGENCY CODE
		if(reportId == "LCRAGNCY"){
		var agencyCodeFrom = content.reportsFrame.document.RepLinenMasterCodesForm["vo.agencyCodeFrom"];
		var agencyCodeTo = content.reportsFrame.document.RepLinenMasterCodesForm["vo.agencyCodeTo"];
			if(agencyCodeFrom.value == ""){
				content.reportsFrame.document.RepLinenMasterCodesForm["agencyCodeHiddenFrom"].value = "";
			}if(agencyCodeTo.value == ""){
				content.reportsFrame.document.RepLinenMasterCodesForm["agencyCodeHiddenTo"].value = "";
			}
		content.reportsFrame.document.RepLinenMasterCodesForm["p_report_id"].value = "LCRAGNCY";
		content.reportsFrame.document.RepLinenMasterCodesForm["report_id"].value = "LCRAGNCY";
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Agency_Code_From"].value = content.reportsFrame.document.RepLinenMasterCodesForm["agencyCodeHiddenFrom"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Agency_Code_To"].value = content.reportsFrame.document.RepLinenMasterCodesForm["agencyCodeHiddenTo"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Status"].value = content.reportsFrame.document.RepLinenMasterCodesForm["vo.effStatus"].value;
		getReport();
		}else if(reportId == "LCRUSERS"){		
		
		// 2. LAUNDRY USERS

		content.reportsFrame.document.RepLinenMasterCodesForm["p_report_id"].value = "LCRUSERS";
		content.reportsFrame.document.RepLinenMasterCodesForm["report_id"].value = "LCRUSERS";
		
		var laundryFrom = content.reportsFrame.document.RepLinenMasterCodesForm["vo.laundryFrom"];
		var laundryTo = content.reportsFrame.document.RepLinenMasterCodesForm["vo.laundryTo"];
		if(laundryFrom.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["laundryHiddenFrom"].value = "";
		}
		if(laundryTo.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["laundryHiddenTo"].value = "";
		}
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Laundry_User_ID_From"].value = content.reportsFrame.document.RepLinenMasterCodesForm["laundryHiddenFrom"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Laundry_User_ID_To"].value = content.reportsFrame.document.RepLinenMasterCodesForm["laundryHiddenTo"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Override_Ward_Conf"].value = content.reportsFrame.document.RepLinenMasterCodesForm["vo.overRide"].value;
		getReport();
		}else if(reportId == "LCRLNITM"){

		// 3. LINEN ITEM
		var linenTypeFrom = content.reportsFrame.document.RepLinenMasterCodesForm["vo.linenTypeFrom"];
		var linenTypeTo =  content.reportsFrame.document.RepLinenMasterCodesForm["vo.linenTypeTo"];
		var linenItemFrom = content.reportsFrame.document.RepLinenMasterCodesForm["vo.linenItemFrom"];
		var linenItemTo = content.reportsFrame.document.RepLinenMasterCodesForm["vo.linenItemTo"];
		if(linenItemFrom.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["linenItemHiddenFrom"].value = "";
		}	
		if(linenItemTo.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["linenItemHiddenTo"].value = "";
		}	
		if(linenTypeFrom.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["linenTypeHiddenFrom"].value = "";
		}
		if(linenTypeTo.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["linenTypeHiddenTo"].value = "";
		}
		content.reportsFrame.document.RepLinenMasterCodesForm["p_report_id"].value = "LCRLNITM";
		content.reportsFrame.document.RepLinenMasterCodesForm["report_id"].value = "LCRLNITM";
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Linen_Item_From"].value = content.reportsFrame.document.RepLinenMasterCodesForm["linenItemHiddenFrom"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Linen_Item_To"].value = content.reportsFrame.document.RepLinenMasterCodesForm["linenItemHiddenTo"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Linen_Type_From"].value = content.reportsFrame.document.RepLinenMasterCodesForm["linenTypeHiddenFrom"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Linen_Type_To"].value = content.reportsFrame.document.RepLinenMasterCodesForm["linenTypeHiddenTo"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Status"].value = content.reportsFrame.document.RepLinenMasterCodesForm["vo.effStatus"].value
		getReport();
		}else if(reportId == "LCRLNTYP"){
		
		// 4. LINEN TYPE
			
		var linenTypeFrom = content.reportsFrame.document.RepLinenMasterCodesForm["vo.linenTypeFrom"];
		var linenTypeTo =  content.reportsFrame.document.RepLinenMasterCodesForm["vo.linenTypeTo"];
		if(linenTypeFrom.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["linenTypeHiddenFrom"].value = "";
		}
		if(linenTypeTo.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["linenTypeHiddenTo"].value = "";
		}
		content.reportsFrame.document.RepLinenMasterCodesForm["p_report_id"].value = "LCRLNTYP";
		content.reportsFrame.document.RepLinenMasterCodesForm["report_id"].value =  "LCRLNTYP";
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Linen_Type_From"].value = content.reportsFrame.document.RepLinenMasterCodesForm["linenTypeHiddenFrom"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Linen_Type_To"].value = content.reportsFrame.document.RepLinenMasterCodesForm["linenTypeHiddenTo"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Status"].value = content.reportsFrame.document.RepLinenMasterCodesForm["vo.effStatus"].value
		
		getReport();
		}else if(reportId == "LCRRSNAT"){
	
		// 5. REASON COMPLAINT CODE
		var reasonCodeFrom = content.reportsFrame.document.RepLinenMasterCodesForm["vo.reasonCodeFrom"];
		var reasonCodeTo = content.reportsFrame.document.RepLinenMasterCodesForm["vo.reasonCodeTo"];
		var actionTypeCodeFrom = content.reportsFrame.document.RepLinenMasterCodesForm["vo.actionTypeCodeFrom"];
		var actionTypeCodeTo = content.reportsFrame.document.RepLinenMasterCodesForm["vo.actionTypeCodeTo"];
		var groupParam = content.reportsFrame.document.RepLinenMasterCodesForm["vo.groupBy"].value;	
	     if(groupParam == "A"){
			content.reportsFrame.document.RepLinenMasterCodesForm["p_report_id"].value = "LCRRSNAT";
			content.reportsFrame.document.RepLinenMasterCodesForm["report_id"].value = "LCRRSNAT";
		}
		if(groupParam == "R"){
			content.reportsFrame.document.RepLinenMasterCodesForm["p_report_id"].value = "LCRRSNRE";
			content.reportsFrame.document.RepLinenMasterCodesForm["report_id"].value = "LCRRSNRE";
		}
		if(reasonCodeFrom.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["reasonCodeHiddenFrom"].value = "";
		}	
		if(reasonCodeTo.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["reasonCodeHiddenTo"].value = "";
		}
		if(actionTypeCodeFrom.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["actionTypeCodeHiddenFrom"].value = "";
		}
		if(actionTypeCodeTo.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["actionTypeCodeHiddenTo"].value = "";
		}
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Reason_Code_From"].value = content.reportsFrame.document.RepLinenMasterCodesForm["reasonCodeHiddenFrom"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Reason_Code_To"].value = content.reportsFrame.document.RepLinenMasterCodesForm["reasonCodeHiddenTo"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Action_Type_Code_From"].value = content.reportsFrame.document.RepLinenMasterCodesForm["actionTypeCodeHiddenFrom"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Action_Type_Code_To"].value =	content.reportsFrame.document.RepLinenMasterCodesForm["actionTypeCodeHiddenTo"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Active"].value = content.reportsFrame.document.RepLinenMasterCodesForm["vo.active"].value;
		getReport();	
		}else if(reportId == "LCRSSSRC"){
	
		// 6. STANDERD STOCK FOR WCD
		var facility_id = content.reportsFrame.document.RepLinenMasterCodesForm["facility_id"].value;
		if(facility_id != null){
		var groupId = content.reportsFrame.document.RepLinenMasterCodesForm["vo.groupBy"].value;
		if(groupId == "S"){
		content.reportsFrame.document.RepLinenMasterCodesForm["p_report_id"].value = "LCRSSSRC";
		content.reportsFrame.document.RepLinenMasterCodesForm["report_id"].value = "LCRSSSRC";
		}else if(groupId == "I"){
		content.reportsFrame.document.RepLinenMasterCodesForm["p_report_id"].value = "LCRSSITM";
		content.reportsFrame.document.RepLinenMasterCodesForm["report_id"].value = "LCRSSITM";
		}
		var sourceCodeFrom = content.reportsFrame.document.RepLinenMasterCodesForm["vo.sourceCodeFrom"];
		var sourceCodeTo = content.reportsFrame.document.RepLinenMasterCodesForm["vo.sourceCodeTo"];
		var linenItemFrom = content.reportsFrame.document.RepLinenMasterCodesForm["vo.linenItemFrom"];
		var linenItemTo = content.reportsFrame.document.RepLinenMasterCodesForm["vo.linenItemTo"];
		if(sourceCodeFrom.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["sourceCodeHiddenFrom"].value = "";
		}if(sourceCodeTo.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["sourceCodeHiddenTo"].value = "";
		}if(linenItemFrom.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["linenItemHiddenFrom"].value = "";
		}if(linenItemTo.value == ""){
			content.reportsFrame.document.RepLinenMasterCodesForm["linenItemHiddenTo"].value = "";
		}
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Source_Type"].value = content.reportsFrame.document.RepLinenMasterCodesForm["vo.sourceType"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Source_Code_From"].value = content.reportsFrame.document.RepLinenMasterCodesForm["sourceCodeHiddenFrom"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Source_Code_To"].value = content.reportsFrame.document.RepLinenMasterCodesForm["sourceCodeHiddenTo"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Linen_Item_From"].value = content.reportsFrame.document.RepLinenMasterCodesForm["linenItemHiddenFrom"].value;
		content.reportsFrame.document.RepLinenMasterCodesForm["P_Linen_Item_To"].value = content.reportsFrame.document.RepLinenMasterCodesForm["linenItemHiddenTo"].value;
		getReport();
		}
	}
}
	function getReport(){
		var formObj=content.reportsFrame.document.RepLinenMasterCodesForm;
		formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
		content.reportsFrame.document.RepLinenMasterCodesForm.submit();
		}

	function reset(){
		  var Mode = "master";
				content.location.href = contextPath + "/RepLinenMasterCodesAction.do?method=" + loadMethod+"&mode="+Mode;
		}
	