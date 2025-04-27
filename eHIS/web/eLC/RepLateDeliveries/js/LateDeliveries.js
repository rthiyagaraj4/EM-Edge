		
		function create() {
			content.location.href = contextPath + "/RepLateDeliveriesAction.do?method=" + loadMethod;
			}
		
		function clearSourceCode(){
			document.getElementById("vo.sourceCode").value="";
		}

		function showLookup(mode){
			
			var argArray = new Array();
			var datatypesArray = new Array();
			var valuesArray = new Array();
			var namesArray = new Array();
			
			var sourceCode = document.getElementById("vo.sourceCode");
			var sourceCodeHidden = document.getElementById("sourceCodeHidden");
			var sourceType = document.getElementById("vo.sourceType").value;
			var linenItem = document.getElementById("vo.linenItem");
			var linenItemHidden = document.getElementById("linenItemHidden");
			
			if(mode == "sourceCode"){
				if(sourceType == "W"){
					valuesArray[0]= document.getElementById("locale").value;
					valuesArray[1]= document.getElementById("facility_Id").value;
					namesArray[0] = "languageId";
					namesArray[1] = "facilityId";
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					argArray[0] = "ehis.lc.standardStock.nursingUnit";
				}else if(sourceType == "C"){
					valuesArray[0]= document.getElementById("locale").value;
					valuesArray[1]= document.getElementById("facility_Id").value;
					namesArray[0] = "languageId";
					namesArray[1] = "facilityId";
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					argArray[0] = "ehis.lc.standardStock.clinic";
				}else if(sourceType == "D"){
					argArray[0] = "ehis.lc.standardStock.deptCode";
				}
			}else if(mode == "linenItem"){
					valuesArray[0]= document.getElementById("locale").value;
					namesArray[0] = "languageId";
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					argArray[0] = "ehis.lc.standardStock.linenItem";
					
					}	
				
									
			//Display Order
				argArray[3] =DESC_CODE ;
			// Link Description
				argArray[4] = DESC_LINK;
				if(mode == "sourceCode"){
				if(sourceType == "W"){
					argArray[5] = sourceCode.value;
				}else if(sourceType == "C"){
					argArray[5] = sourceCode.value;
				}else if(sourceType == "D"){
					argArray[5] = sourceCode.value;
				}
				}else if(mode == "linenItem"){
					argArray[5] = linenItem.value;
				}	
					
				// Lookup will return code and description - retArr hold it
				
				getServerMessage("com.iba.ehis.lc.ward");
				var wardLabel=dwrMessage;
				getServerMessage("com.iba.ehis.lc.clinic");
				var clinicLabel=dwrMessage;
				getServerMessage("com.iba.ehis.lc.department");
				var deptLabel=dwrMessage;
				getServerMessage("com.iba.ehis.lc.linenItem");
				var linenItemLabel=dwrMessage;

				if(mode == "sourceCode"){
					if(sourceType == "W"){
						retArr= Lookup(wardLabel,argArray)
					}else if(sourceType == "C"){
						retArr= Lookup(clinicLabel,argArray)
					}else if(sourceType == "D"){
						retArr= Lookup(deptLabel,argArray)
					}
				}else if(mode == "linenItem"){
						retArr= Lookup(linenItemLabel,argArray)
					}	
				if(retArr!=null){
					if(mode == "sourceCode"){
						sourceCode.value=retArr[1];
						sourceCodeHidden.value=retArr[0];
						}else if(mode == 'linenItem'){
						linenItem.value=retArr[1];
						linenItemHidden.value = retArr[0];
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
			var fieldName = new Array("com.iba.ehis.lc.crdate");
			var fields = new Array(content.document.RepLateDeliveriesForm["vo.dateFrom"]);
			var bool = checkNullDS(fieldName, fields);
			if (bool == false) {
				return false;
			} else {
				return true;
			}
		}
		
	 	function checkDate(){
	 	
	 		var fromDate = content.document.getElementById("vo.dateFrom").value;
			var toDate = content.document.getElementById("vo.dateTo").value;
			var locale = content.document.getElementById("locale").value;

			getServerMessage("com.iba.ehis.lc.From");
			var From= dwrMessage;
			getServerMessage("com.iba.ehis.lc.To");
			var To = dwrMessage;

		//	var legend =new Array("com.iba.ehis.lc.crdatefrom","com.iba.ehis.lc.currentdate","com.iba.ehis.lc.crdateto");
			var legend =new Array("com.iba.ehis.lc.crdate","com.iba.ehis.lc.currentdate","com.iba.ehis.lc.deliverydate");
				if(fromDate !="" || toDate !="" ){
				IBADateValidator.isCurrentDateLesserThanJS(fromDate, locale,callBackFunction);
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
							error = split_message[0]+" "+legend_key0 +" "+From+ " " + split_message[1] + " " + legend_key1+"<br>";
							messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
						}else{
							IBADateValidator.isDateGreaterThanJS(fromDate,toDate,locale,callBackFunction);
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
								error= split_message[0]+" "+legend_key0 +" "+From+" "+split_message[1]+ " "+legend_key0+" "+To;
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
				var fieldName = new Array("com.iba.ehis.lc.crdate");
				var fieldValues = new Array(content.document.RepLateDeliveriesForm["vo.dateFrom"]);
				var key_value = new Array();
				for (j = 0; j < 1; j++) {
					if ( fieldValues[j]== "") {
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
			content.document.RepLateDeliveriesForm["p_report_id"].value = "LCRLTDLY";
			content.document.RepLateDeliveriesForm["report_id"].value = "LCRLTDLY";
			
			var sourceCode = content.document.getElementById("vo.sourceCode").value;
			var linenItem = content.document.getElementById("vo.linenItem").value;
			
			if(linenItem == ""){
				content.document.RepLateDeliveriesForm["linenItemHidden"].value = "";
			}if(sourceCode == ""){
				content.document.RepLateDeliveriesForm["sourceCodeHidden"].value = "";
			}	
				content.document.RepLateDeliveriesForm["P_REQUEST_DATE_FROM"].value = content.document.RepLateDeliveriesForm["conFromDate"].value;
				content.document.RepLateDeliveriesForm["P_REQUEST_DATE_TO"].value = content.document.RepLateDeliveriesForm["conToDate"].value;
				
				content.document.RepLateDeliveriesForm["P_SOURCE_TYPE"].value = content.document.RepLateDeliveriesForm["vo.sourceType"].value;
				content.document.RepLateDeliveriesForm["P_SOURCE_CODE"].value = content.document.RepLateDeliveriesForm["sourceCodeHidden"].value;
				content.document.RepLateDeliveriesForm["P_LINEN_ITEM"].value = content.document.RepLateDeliveriesForm["linenItemHidden"].value;
						
				var formObj=content.document.RepLateDeliveriesForm;
				formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
				content.document.RepLateDeliveriesForm.submit();
				
		}

		function convert(){
			var fromDate = document.getElementById("vo.dateFrom").value;
			var toDate = document.getElementById("vo.dateTo").value;
			var locale = document.getElementById("locale").value;
			var dateFormate = document.getElementById("datepattrn").value;
			if(fromDate!=""){
				IBADateValidator.convertDateJS(fromDate,locale,'en',dateFormate,callBackFromDate);
				function callBackFromDate(conFromDate){
				
				document.getElementById("conFromDate").value=conFromDate;
				if(toDate!=""){
				IBADateValidator.convertDateJS(toDate,locale,'en',dateFormate,callBackFromDate);
				function callBackFromDate(conToDate){
				
				document.getElementById("conToDate").value=conToDate;
				}
				}else{
					document.getElementById("conToDate").value="";
					}
				}
			}else{
				document.getElementById("conFromDate").value="";
			}
		}
/*
		function getReport(){
		
			content.document.RepLateDeliveriesForm["p_report_id"].value = "LCRLTDLY";
			content.document.RepLateDeliveriesForm["report_id"].value = "LCRLTDLY";
			
			var fromDate = content.document.RepLateDeliveriesForm["vo.dateFrom"].value;
			var locale = content.document.getElementById("locale").value;
			var datepattrn = content.document.getElementById("datepattrn").value;
				
				content.IBADateValidator.convertJS(fromDate,locale,'en', datepattrn,callBackFromDate)
					function callBackFromDate(conFromDate){
						var toDate = content.document.RepLateDeliveriesForm["vo.dateTo"].value;
						if(toDate!=""){
							content.IBADateValidator.convertJS(fromDate,locale,'en', datepattrn,callBackToDate)
								function callBackToDate(conToDate){
									if(linenItem == ""){
										content.document.RepLateDeliveriesForm["linenItemHidden"].value = "";
									}if(sourceCode == ""){
										content.document.RepLateDeliveriesForm["sourceCodeHidden"].value = "";
									}
									content.document.RepLateDeliveriesForm["P_REQUEST_DATE_FROM"].value = conFromDate;
									content.document.RepLateDeliveriesForm["P_REQUEST_DATE_TO"].value = conToDate;
									content.document.RepLateDeliveriesForm["P_SOURCE_TYPE"].value = content.document.RepLateDeliveriesForm["vo.sourceType"].value;
									content.document.RepLateDeliveriesForm["P_SOURCE_CODE"].value = content.document.RepLateDeliveriesForm["sourceCodeHidden"].value;
									content.document.RepLateDeliveriesForm["P_LINEN_ITEM"].value = content.document.RepLateDeliveriesForm["linenItemHidden"].value;
											
									var formObj=content.document.RepLateDeliveriesForm;
									formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
									content.document.RepLateDeliveriesForm.submit();
									}
							}else{
													
									if(linenItem == ""){
										content.document.RepLateDeliveriesForm["linenItemHidden"].value = "";
									}if(sourceCode == ""){
										content.document.RepLateDeliveriesForm["sourceCodeHidden"].value = "";
									}
									content.document.RepLateDeliveriesForm["P_REQUEST_DATE_FROM"].value = conFromDate;
									content.document.RepLateDeliveriesForm["P_REQUEST_DATE_TO"].value = "";
									content.document.RepLateDeliveriesForm["P_SOURCE_TYPE"].value = content.document.RepLateDeliveriesForm["vo.sourceType"].value;
									content.document.RepLateDeliveriesForm["P_SOURCE_CODE"].value = content.document.RepLateDeliveriesForm["sourceCodeHidden"].value;
									content.document.RepLateDeliveriesForm["P_LINEN_ITEM"].value = content.document.RepLateDeliveriesForm["linenItemHidden"].value;
											
									var formObj=content.document.RepLateDeliveriesForm;
									formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
									content.document.RepLateDeliveriesForm.submit();
								}
							}
						}
*/
		function reset(){
		   content.location.href=contextPath+"/RepLateDeliveriesAction.do?method="+loadMethod
			}

			