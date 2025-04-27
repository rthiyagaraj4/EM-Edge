		
		function create(){
				content.location.href = contextPath + "/RepShortageofLinenSupplyAction.do?method=" + loadMethod;
			}
		
		function clearSourceType(){
			document.getElementById("vo.sourceCode").value="";
		}

		function showLookup(mode){
			var argArray;
			var argArray = new Array();
			var datatypesArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();

			var sourceCode = document.getElementById("vo.sourceCode");
			var sourceCodeHidden = document.getElementById("sourceCodeHidden");
			var sourceType = document.getElementById("vo.sourceType").value;
			var linenItem = document.getElementById("vo.linenItem");
			var linenItemHidden = document.getElementById("linenItemHidden");
			if(mode == "sourceCode"){
				if(sourceType == "W"){
					argArray[0] = "ehis.lc.standardStock.nursingUnit";
					valuesArray[0]= document.getElementById("locale").value;
					valuesArray[1]= document.getElementById("facility_Id").value;
					namesArray[0] = "languageId";
					namesArray[1] = "facilityId";
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					}else if(sourceType == "C"){
						argArray[0] = "ehis.lc.standardStock.clinic";
						valuesArray[0]= document.getElementById("locale").value;
						valuesArray[1]= document.getElementById("facility_Id").value;
						namesArray[0] = "languageId";
						namesArray[1] = "facilityId";
						argArray[1] = namesArray;
						argArray[2] = valuesArray;
					}else{
						argArray[0] = "ehis.lc.standardStock.deptCode";
						valuesArray[0]= document.getElementById("locale").value;
						namesArray[0] = "languageId";
						argArray[1] = namesArray;
						argArray[2] = valuesArray;
						}
					}else{
						argArray[0] = "ehis.lc.standardStock.linenItem";
						valuesArray[0]= document.getElementById("locale").value;
						namesArray[0] = "languageId";
						argArray[1] = namesArray;
						argArray[2] = valuesArray;
						}
							
										
				//Display Order
					argArray[3] =DESC_CODE ;
				// Link Description
					argArray[4] = DESC_LINK;
					if(mode == "sourceCode"){
				if(sourceType == "C"){
					argArray[5] = sourceCode.value;
					}else if(sourceType == "D"){
						argArray[5] = sourceCode.value;
					}else{
						argArray[5] = sourceCode.value;
					}
				}else if(mode == "linenItem"){
					argArray[5] = linenItem.value;
					}
				// Lookup will return code and description - retArr hold it
				
				getServerMessage("com.iba.ehis.lc.ward");
				var wardLabel = dwrMessage;
				getServerMessage("com.iba.ehis.lc.clinic");
				var clinicLabel = dwrMessage;
				getServerMessage("com.iba.ehis.lc.department");
				var deptLabel = dwrMessage;
				getServerMessage("com.iba.ehis.lc.shortageofLinenSupply");
				var linenLabel = dwrMessage;

				if(mode == "sourceCode"){
				if(sourceType == "W"){
						retArr= Lookup(wardLabel,argArray)
					}else if(sourceType == "C"){
						retArr= Lookup(clinicLabel,argArray)
					}else if(sourceType == "D"){
						retArr= Lookup(deptLabel,argArray)
						}
				}else if(mode == "linenItem"){
						retArr= Lookup(linenLabel,argArray)
						}
					if(retArr!=null){
						if(mode == "sourceCode"){
							sourceCode.value=retArr[1];
							sourceCodeHidden.value=retArr[0];
						}else if(mode == "linenItem"){
								linenItem.value=retArr[1];
								linenItemHidden.value=retArr[0];
							}
						}	
					}	

		function run(){
		
			getReport();
			}
		
		function getReport(){
			content.document.RepShortageofLinenSupplyForm["p_report_id"].value = "LCRSGLNS";
			content.document.RepShortageofLinenSupplyForm["report_id"].value = "LCRSGLNS";
			
			var linenItem = content.document.RepShortageofLinenSupplyForm["vo.linenItem"].value;
			var sourceCode = content.document.RepShortageofLinenSupplyForm["vo.sourceCode"].value;
			
			if(linenItem == ""){
				content.document.RepShortageofLinenSupplyForm["linenItemHidden"].value = "";
			}if(sourceCode == ""){
				content.document.RepShortageofLinenSupplyForm["sourceCodeHidden"].value = "";
			}
			content.document.RepShortageofLinenSupplyForm["P_Linen_Item"].value = content.document.RepShortageofLinenSupplyForm["linenItemHidden"].value;
			content.document.RepShortageofLinenSupplyForm["P_Source"].value = content.document.RepShortageofLinenSupplyForm["vo.sourceType"].value
			content.document.RepShortageofLinenSupplyForm["P_Source_Type"].value = content.document.RepShortageofLinenSupplyForm["sourceCodeHidden"].value
			
			var formObj=content.document.RepShortageofLinenSupplyForm;
			formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
			content.document.RepShortageofLinenSupplyForm.submit();
			}

		function reset(){
		   content.location.href=contextPath+"/RepShortageofLinenSupplyAction.do?method="+loadMethod
			}
	
		
