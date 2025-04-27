		
		function create() {
				content.location.href = contextPath + "/RepInfectedLinenAction.do?method=" + loadMethod;
			}

		function clearSourceType(){
			document.getElementById("vo.sourceCode").value="";
		}
		
		function showLookup(mode){
			var retArr = "";
			var argArray = new Array();
			var datatypesArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();
						
			var sourceCode = document.getElementById("vo.sourceCode");
			var sourceCodeHidden = document.getElementById("sourceCodeHidden");
			var sourceType = document.getElementById("vo.sourceType").value;
			var linenItem = document.getElementById("vo.linenItem");
			var linenItemHidden = document.getElementById("linenItemHidden");
			
			if(mode == "sourceCode" && sourceType != ""){
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
				}else if(sourceType == "D"){
					
					argArray[0] = "ehis.lc.standardStock.deptCode";
					valuesArray[0]= document.getElementById("locale").value;
					namesArray[0] = "languageId";
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
				}
			}
					
			if(mode == "linenItem"){
				argArray[0] = "ehis.lc.standardStock.linenItem";
				valuesArray[0] = document.getElementById("locale").value;
				namesArray[0] = "languageId";
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				}
				
										
				//Display Order
					argArray[3] =DESC_CODE ;
				// Link Description
					argArray[4] = DESC_LINK;
					if(mode == "sourceCode"){
						argArray[5] = sourceCode.value;
							}else if(mode == "linenItem"){
							argArray[5] = linenItem.value;
						}
				// Lookup will return code and description - retArr hold it

				getServerMessage("com.iba.ehis.lc.infected");
				var infectedLabel = dwrMessage;
				
				getServerMessage("com.iba.ehis.lc.linenItem");
				var linenLabel = dwrMessage;
				linen=linenLabel.split(" ");
				var infectedLinen=infectedLabel+" "+linen[0]
				getServerMessage("com.iba.ehis.lc.ward");
				var wardLabel = dwrMessage;
				
				getServerMessage("com.iba.ehis.lc.clinic");
				var clinicLabel = dwrMessage;
				
				getServerMessage("com.iba.ehis.lc.department");
				var deptLabel = dwrMessage;

					if(mode == "linenItem"){
					retArr= Lookup(infectedLinen,argArray)
					}
					if(mode == "sourceCode" && sourceType != ""){
						if(sourceType == "W"){
							retArr= Lookup(wardLabel,argArray)
						}if(sourceType == "C"){
							retArr= Lookup(clinicLabel,argArray)
						}if(sourceType == "D"){
							retArr= Lookup(deptLabel,argArray)
							}
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
			var flag = checkNull();
			
			if (flag == true){
				checkDate();			
				}
			}


		function checkNull() {
			var fieldName = new Array("com.iba.ehis.lc.crdate");
			var fields = new Array(content.document.RepInfectedLinenForm["vo.dateFrom"]);
			var bool = checkNullDS(fieldName, fields);
			if (bool == false) {
				return false;
			} else {
				return true;
			}
		}
		
		function checkDate(){
			
	 		var fromDate = content.document.getElementById("vo.dateFrom").value;
			var locale = content.document.getElementById("locale").value;
			var toDate = content.document.getElementById("vo.dateTo").value;
			getServerMessage("com.iba.ehis.lc.From");
			var From= dwrMessage;
			getServerMessage("com.iba.ehis.lc.To");
			var To = dwrMessage;

			var legend =new Array("com.iba.ehis.lc.crdate","com.iba.ehis.lc.currentdate","com.iba.ehis.lc.crdate");
				if(fromDate !="" || toDate !="" ){
				content.IBADateValidator.isCurrentDateLesserThanJS(fromDate, locale,callBackFunction);
				function callBackFunction(data){
					if(data ==true){				
						getServerMessage("APP-LC00012");
							var message_key = dwrMessage;
							var splitMessage = message_key.split("#");
							getServerMessage(legend[0]);
							var legend_key0 = dwrMessage;
							getServerMessage(legend[1]);
							var legend_key2 = dwrMessage;
							error = splitMessage[0]+" "+legend_key0 + " " + splitMessage[1] +"<br>";
							messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
						}else{
						content.IBADateValidator.isDateGreaterThanJS(fromDate,toDate,locale,callBackFunction);
						function callBackFunction(data){
							if(data==true){
							getServerMessage("APP-LC00012");
							var message_key = dwrMessage;
							var splitMessage = message_key.split("#");
							getServerMessage(legend[0]);
							var legend_key0 = dwrMessage;
							getServerMessage(legend[2]);
							var legend_key2 = dwrMessage;
							error = splitMessage[0]+" "+legend_key0 +" "+From+ " " + splitMessage[1] + " "+legend_key2+" "+To+"<br>";
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
				var fieldName = new Array("com.iba.ehis.ds.date");
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
			
			content.document.RepInfectedLinenForm["p_report_id"].value = "LCRINFLN";
			content.document.RepInfectedLinenForm["report_id"].value = "LCRINFLN";

			var sourceCode = content.document.getElementById("vo.sourceCode").value;
			var sourceType = content.document.getElementById("vo.sourceType").value;
			var linenItem = content.document.getElementById("vo.linenItem").value;
			
			if(linenItem==""){
				content.document.RepInfectedLinenForm["linenItemHidden"].value="";
			}if(sourceCode==""){
				content.document.RepInfectedLinenForm["sourceCodeHidden"].value="";
			}if(sourceType==""){
				content.document.RepInfectedLinenForm["vo.sourceType"].value="";
			}
			
			content.document.RepInfectedLinenForm["P_From_Date"].value = content.document.RepInfectedLinenForm["conFromDate"].value;
			content.document.RepInfectedLinenForm["P_To_Date"].value = content.document.RepInfectedLinenForm["conToDate"].value;
			
			content.document.RepInfectedLinenForm["P_Linen_Item"].value = content.document.RepInfectedLinenForm["linenItemHidden"].value;
			content.document.RepInfectedLinenForm["P_Source_Type"].value = content.document.RepInfectedLinenForm["vo.sourceType"].value;
			content.document.RepInfectedLinenForm["P_Source_Code"].value = content.document.RepInfectedLinenForm["sourceCodeHidden"].value;
			
			var formObj=content.document.RepInfectedLinenForm;
			formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
			content.document.RepInfectedLinenForm.submit();
		}

		function call(){
			
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

	   function reset(){
		   content.location.href=contextPath+"/RepInfectedLinenAction.do?method="+loadMethod
		}
	
		 
	
