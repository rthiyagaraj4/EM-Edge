		
		function create() {
				content.location.href = contextPath + "/RepWrittenoffLinenAction.do?method=" + loadMethod;
				}

		function disLaundry(){
			var laundry = document.getElementById("vo.sourceType");
			if(laundry.value == "L"){
			document.getElementById("vo.sourceCode").value = "";
			document.getElementById("vo.sourceCode").disabled = true;
			document.getElementById("Laundry").disabled = true;
			}else{
			document.getElementById("vo.sourceCode").disabled = false;
			document.getElementById("Laundry").disabled = false;
			}
		}

		function showLookup(mode){
			var argArray = new Array();
			var datatypesArray = new Array();
			var sourceCode = document.getElementById("vo.sourceCode");
			var sourceCodeHidden = document.getElementById("sourceCodeHidden");
			var sourceType = document.getElementById("vo.sourceType").value;
			var linenItem = document.getElementById("vo.linenItem");
			var linenItemHidden = document.getElementById("linenItemHidden");
			var reasonforWriteOff = document.getElementById("vo.reasonforWriteOff");
			var reasonforWriteOffHidden = document.getElementById("reasonforWriteOffHidden");
				if(mode == "sourceCode"){
					if(sourceType == "W"){
							valuesArray[0]= document.getElementById("locale").value;
							valuesArray[1]= document.getElementById("facility_Id").value;
							namesArray[0] = "languageId";
							namesArray[1] = "facilityId";
							argArray[1] = namesArray;
							argArray[2] = valuesArray;
							argArray[0] = "ehis.lc.standardStock.nursingUnit";
						}else if(sourceType == "D"){
							valuesArray[0]= document.getElementById("locale").value;
							valuesArray[1]= document.getElementById("facility_Id").value;
							namesArray[0] = "languageId";
							namesArray[1] = "facilityId";
							argArray[1] = namesArray;
							argArray[2] = valuesArray;
							argArray[0] = "ehis.lc.standardStock.deptCode";
						}else if(sourceType == "C"){
							valuesArray[0]= document.getElementById("locale").value;
							valuesArray[1]= document.getElementById("facility_Id").value;
							namesArray[0] = "languageId";
							namesArray[1] = "facilityId";
							argArray[1] = namesArray;
							argArray[2] = valuesArray;
							argArray[0] = "ehis.lc.standardStock.clinic";
						}else{
							valuesArray[0]= document.getElementById("locale").value;
							namesArray[0] = "languageId";
							argArray[1] = namesArray;
							argArray[2] = valuesArray;
							argArray[0] = "ehis.lc.standardStock.deptCode";
						}
				}else if(mode == "linenItem"){
						valuesArray[0]= document.getElementById("locale").value;
						namesArray[0] = "languageId";
						argArray[1] = namesArray;
						argArray[2] = valuesArray;
						argArray[0] = "ehis.lc.standardStock.linenItem";
					}else if(mode == "reasonforWriteOff"){
						valuesArray[0]= document.getElementById("locale").value;
						namesArray[0] = "languageId";
						argArray[1] = namesArray;
						argArray[2] = valuesArray;
						argArray[0] = "ehis.lc.reasonCode.getReasonCode";
						}
						argArray[1] = new Array();
						argArray[2] = new Array();
											
					//Display Order
						argArray[3] =DESC_CODE ;
					// Link Description
						argArray[4] = DESC_LINK;
					if(mode == "sourceCode"){
					if(sourceType == "W"){
							argArray[5] = sourceCode.value;
						}else if(sourceType == "L"){
							argArray[5] = sourceCode.value;
						}else if(sourceType == "C"){
							argArray[5] = sourceCode.value;
						}else
							argArray[5] = sourceCode.value;
				}else if(mode == "linenItem"){
						argArray[5] = linenItem.value;
					}else if(mode == "reasonforWriteOff"){
						argArray[5] = reasonforWriteOff.value;
						}
						
					// Lookup will return code and description - retArr hold it

					getServerMessage("com.iba.ehis.lc.ward");
					var wardLabel = dwrMessage;
					getServerMessage("com.iba.ehis.lc.laundry");
					var laundryLabel = dwrMessage;
					getServerMessage("com.iba.ehis.lc.clinic");
					var clinicLabel = dwrMessage;
					getServerMessage("com.iba.ehis.lc.department");
					var deptLabel = dwrMessage;
					getServerMessage("com.iba.ehis.lc.linenItem");
					var linenItemLabel = dwrMessage;
					getServerMessage("com.iba.ehis.lc.reasonCode");
					var reasonLabel = dwrMessage;

					if(mode == "sourceCode"){
					if(sourceType == "W"){
							retArr= Lookup(wardLabel,argArray)
						}else if(sourceType == "L"){
							retArr= Lookup(laundryLabel,argArray)
						}else if(sourceType == "C"){
							retArr= Lookup(clinicLabel,argArray)
						}else
							retArr= Lookup(deptLabel,argArray)
				}else if(mode == "linenItem"){
						retArr= Lookup(linenItemLabel,argArray)
					}else if(mode == "reasonforWriteOff"){
						retArr= Lookup(reasonLabel,argArray)
						}
						if(retArr!=null){
							if(mode == "sourceCode"){
								sourceCode.value=retArr[1];
								sourceCodeHidden.value=retArr[0];
								}else if(mode == "linenItem"){
									linenItem.value=retArr[1];
									linenItemHidden.value=retArr[0];
									}else if(mode == "reasonforWriteOff"){
									reasonforWriteOff.value=retArr[1];	
									reasonforWriteOffHidden.value=retArr[0];	
								}	
							}			
						}
							
		function run(){
			var flag = checkNull();
		
			if (flag == true){
				checkDate();			
				}
			}

		function checkNull() {
			var fieldName = new Array("com.iba.ehis.lc.writeoffdate");
			var fields = new Array(content.document.getElementById("vo.fromDate"));
			var bool = checkNullDS(fieldName, fields);
			if (bool == false) {
				return false;
			} else {
				return true;
			}
		}

		function checkDate(){
	 	
	 		var fromDate = content.document.getElementById("vo.fromDate").value;
			var toDate = content.document.getElementById("vo.toDate").value;
			var legend =new Array("com.iba.ehis.lc.writeoffdatefrom","com.iba.ehis.lc.currentdate","com.iba.ehis.lc.writeoffdateto")
	 		if(fromDate !="" || toDate !="" ){
	 		IBADateValidator.isCurrentDateLesserThanJS(fromDate, 'en',callBackFunction);
			function callBackFunction(data){
				if(data ==true){											
					getServerMessage("APP-LC00012");
					var message_key = dwrMessage;
					var split_message = message_key.split("#")
					getServerMessage(legend[0]);
					var legend_key0 = dwrMessage;
					getServerMessage(legend[1]);
					var legend_key1 = dwrMessage;
					getServerMessage(legend[2]);
					var legend_key2 = dwrMessage;
				//	error="APP-LC00012 fromDate should be less than current Date"
					error = split_message[0]+" "+legend_key0 + " " + split_message[1] + " " + legend_key1+ "<br>";
					messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
				}else{
						IBADateValidator.isDateGreaterThanJS(fromDate,toDate,'en',callBackFunction);
					function callBackFunction(data){
						if(data==true){
						getServerMessage("APP-LC00012");
						var message_key = dwrMessage;
						var split_message = message_key.split("#")
						getServerMessage(legend[0]);
						var legend_key0 = dwrMessage;
						getServerMessage(legend[1]);
						var legend_key1 = dwrMessage;
						getServerMessage(legend[2]);
						var legend_key2 = dwrMessage;
						error= split_message[0]+" "+legend_key0 +" "+split_message[1]+ " "+legend_key2
					//	error="APP-LC00012 fromDate should be less than toDate"
						messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
						}
					else{
						var error="";
						messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;							
						getReport();
						}
					}
				}
			}
		}else{
				var f1;
				var error = "";
				var fieldName = new Array("com.iba.ehis.lc.writeoffdate");
				var fieldValues = new Array(content.document.getElementById("vo.fromDate"));
				var key_value = new Array();
				for (j = 0; j < 1; j++) {
					if(fieldValues[j]== "") {
						getServerMessage(fieldName[j]);
						key_value[j] = dwrMessage;
						getServerMessage("APP-LC0004");
						error = error + fieldName[j] + " " + dwrMessage + "<br>";
						}
					}
					messageFrame.location.href = contextPath + "/core/jsp/MessageFrame.jsp?error=" + error;
				}
			}
	
		function getReport(){
			
			content.document.RepWrittenoffLinenForm["p_report_id"].value = "LCRWOFLN";
			content.document.RepWrittenoffLinenForm["report_id"].value = "LCRWOFLN";
			
			var fromDate = content.document.RepWrittenoffLinenForm["vo.fromDate"].value;
			var linenItem = content.document.RepWrittenoffLinenForm["vo.linenItem"].value;
			var reasonforWriteOff = content.document.RepWrittenoffLinenForm["vo.reasonforWriteOff"].value;
			var sourceCode = content.document.RepWrittenoffLinenForm["vo.sourceCode"].value;
			
			var locale = content.document.getElementById("locale").value;
			var datepattrn = content.document.getElementById("datepattrn").value;
				
				content.IBADateValidator.convertJS(fromDate,locale,'en', datepattrn,callBackFromDate)
					function callBackFromDate(conDateFrom){
						var toDate = content.document.RepWrittenoffLinenForm["vo.toDate"].value;
						if(toDate!=""){
						content.IBADateValidator.convertJS(fromDate,locale,'en', datepattrn,callBackToDate)
							function callBackToDate(conToDate){

								if(linenItem == ""){
									content.document.RepWrittenoffLinenForm["linenItemHidden"].value = "";
								}if(reasonforWriteOff == ""){
									content.document.RepWrittenoffLinenForm["reasonforWriteOffHidden"].value = "";
								}if(sourceCode == ""){
									content.document.RepWrittenoffLinenForm["sourceCodeHidden"].value = "";
								}

								content.document.RepWrittenoffLinenForm["P_Write_Off_Date_From"].value = conDateFrom;
								content.document.RepWrittenoffLinenForm["P_Write_Off_Date_To"].value = conToDate;
								content.document.RepWrittenoffLinenForm["P_Linen_Item"].value = content.document.RepWrittenoffLinenForm["linenItemHidden"].value;
								content.document.RepWrittenoffLinenForm["P_Source_Type"].value = content.document.RepWrittenoffLinenForm["vo.sourceType"].value;
								content.document.RepWrittenoffLinenForm["P_Source_Code"].value = content.document.RepWrittenoffLinenForm["sourceCodeHidden"].value;
								content.document.RepWrittenoffLinenForm["P_Reason_For_Write_Off"].value = content.document.RepWrittenoffLinenForm["reasonforWriteOffHidden"].value;
								
								var formObj=content.document.RepWrittenoffLinenForm;
								formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
								content.document.RepWrittenoffLinenForm.submit();
							}
						}else{
								if(linenItem == ""){
									content.document.RepWrittenoffLinenForm["linenItemHidden"].value = "";
								}if(reasonforWriteOff == ""){
									content.document.RepWrittenoffLinenForm["reasonforWriteOffHidden"].value = "";
								}if(sourceCode == ""){
									content.document.RepWrittenoffLinenForm["sourceCodeHidden"].value = "";
								}

								content.document.RepWrittenoffLinenForm["P_Write_Off_Date_From"].value = conDateFrom;
								content.document.RepWrittenoffLinenForm["P_Write_Off_Date_To"].value = ""
								content.document.RepWrittenoffLinenForm["P_Linen_Item"].value = content.document.RepWrittenoffLinenForm["linenItemHidden"].value;
								content.document.RepWrittenoffLinenForm["P_Source_Type"].value = content.document.RepWrittenoffLinenForm["vo.sourceType"].value;
								content.document.RepWrittenoffLinenForm["P_Source_Code"].value = content.document.RepWrittenoffLinenForm["sourceCodeHidden"].value;
								content.document.RepWrittenoffLinenForm["P_Reason_For_Write_Off"].value = content.document.RepWrittenoffLinenForm["reasonforWriteOffHidden"].value;
								
								var formObj=content.document.RepWrittenoffLinenForm;
								formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
								content.document.RepWrittenoffLinenForm.submit();
							}
						}
					}

	  function reset() {
		   content.location.href=contextPath+"/RepWrittenoffLinenAction.do?method="+loadMethod
		}

		 
	