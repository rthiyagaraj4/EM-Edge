
		function create() {
				content.location.href = contextPath + "/RepLinenDeliveryAction.do?method=" + loadMethod+"&vo.functionId="+functionId;
			}
		function clearSource(){
			document.getElementById("vo.sourceCode").value="";
		}
		
		function showLookup(mode){
			var argArray = new Array();
			var datatypesArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();
			var retArr="";

			var sourceCode = document.getElementById("vo.sourceCode");
			var sourceCodeHidden = document.getElementById("sourceCodeHidden");
			var sourceType = document.getElementById("vo.sourceType").value;
			var linenItem = document.getElementById("vo.linenItem");
			var linenItemHidden = document.getElementById("linenItemHidden");
			
			if(mode == "sourceCode"){
				if(sourceType == "C"){
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
				}else{
					argArray[0] = "ehis.lc.standardStock.nursingUnit";
					valuesArray[0]= document.getElementById("locale").value;
					valuesArray[1]= document.getElementById("facility_Id").value;
					namesArray[0] = "languageId";
					namesArray[1] = "facilityId";
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					}
				}else if(mode == "linenItem"){
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
				
				getServerMessage("com.iba.ehis.lc.clinic");
				var clinicLabel = dwrMessage;
				getServerMessage("com.iba.ehis.lc.department");
				var departmentLabel = dwrMessage;
				getServerMessage("com.iba.ehis.lc.writeOffLinen.ward");
				var wardLabel = dwrMessage;
				getServerMessage("com.iba.ehis.lc.linenItem");
				var linenItemLabel = dwrMessage;

				if(mode == "sourceCode"){
				if(sourceType == "C"){
					retArr= Lookup(clinicLabel,argArray)
					}else if(sourceType == "D"){
						retArr= Lookup(departmentLabel,argArray)
					}else if(sourceType == "W"){
						retArr= Lookup(wardLabel,argArray)
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
								linenItemHidden.value=retArr[0];
							}
						}	
					}
				
	
	   function reset(){
		  		 content.location.href=contextPath+"/RepLinenDeliveryAction.do?method="+loadMethod
			}

		function run(){
			
			var flag = checkNull();
			
			if (flag == true){
				checkDate();			
				}
			}

		function checkNull() {
			
			var fieldName = new Array("com.iba.ehis.lc.reqestdate");
			var fields = new Array(content.document.getElementById("vo.dateFrom"));
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
			
		//	var legend =new Array("com.iba.ehis.lc.reqestdatefrom","com.iba.ehis.lc.currentdate","com.iba.ehis.lc.reqestdateto")
			var legend =new Array("com.iba.ehis.lc.reqestdate","com.iba.ehis.lc.currentdate","com.iba.ehis.lc.deliverydate")
	 		if(fromDate !="" || toDate !="" ){
				
	 		content.IBADateValidator.isCurrentDateLesserThanJS(fromDate, locale,callBackFunction);
			function callBackFunction(data){
				
				if(data ==true){											
						getServerMessage("APP-LC00012");
						var message_key = dwrMessage;
						var split_message = message_key.split("#")
						getServerMessage(legend[0]);
						var legend_key0 = dwrMessage;
						getServerMessage(legend[1]);
						var legend_key1 = dwrMessage;
						error=split_message[0]+" "+legend_key0 +" "+From+ " " + split_message[1] + " " + legend_key1+"<br>";
						messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
					}else{
						content.IBADateValidator.isDateGreaterThanJS(fromDate,toDate,locale,callBackFunction);
						function callBackFunction(data){
							
							if(data==true){
								getServerMessage("APP-LC00012");
								var message_key = dwrMessage;
								var split_message = message_key.split("#")
								getServerMessage(legend[0]);
								var legend_key0 = dwrMessage;
								getServerMessage(legend[2]);
								var legend_key2 = dwrMessage;
								error=split_message[0]+" "+legend_key0 +" "+From+ " " + split_message[1] + " " + legend_key0 +" "+To+"<br>";
								messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
							}
							else{
								
								DeliveryCheckDate();
								}
							}
						}
					}
				}else{
				var f1;
				var error = "";
				var fieldName = new Array("com.iba.ehis.lc.reqestdate");
				var fieldValues = new Array(content.document.RepLinenDeliveryForm["vo.dateFrom"]);
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

		function DeliveryCheckDate(){
			
	 		var from = content.document.getElementById("vo.from").value;
			var to = content.document.getElementById("vo.to").value;
			var locale = content.document.getElementById("locale").value;
			var legend =new Array("com.iba.ehis.lc.reqestdate","com.iba.ehis.lc.currentdate","com.iba.ehis.lc.deliverydate")
			if(from == "" && to == ""){
				
				getReport();
			}
	 		if(from !="" || to !="" ){
				
	 		content.IBADateValidator.isCurrentDateLesserThanJS(from, locale,callBackFunction);
		
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
				error = split_message[0]+" "+legend_key0 + " " + split_message[1] + " " + legend_key2+ "<br>";
				messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			}else{
				IBADateValidator.isDateGreaterThanJS(from,to,locale,callBackFunction);
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
							var error = "";
							messageFrame.location.href = contextPath + "/core/jsp/MessageFrame.jsp?error=" + error;
							getReport();
						}
					}
				}
			}
		}
	}

	function getReport(){
		
		content.document.getElementById("p_report_id").value = "LCRLNDLY";
		content.document.getElementById("report_id").value = "LCRLNDLY";
		
		var dateFrom = content.document.getElementById("vo.dateFrom").value;
		var linenItem = content.document.RepLinenDeliveryForm["vo.linenItem"].value;
		var sourceCode = content.document.RepLinenDeliveryForm["vo.sourceCode"].value;
		
		var dateFormate = content.document.getElementById("dateFormate").value;
		var locale = content.document.getElementById("locale").value;
		if(linenItem==""){
			content.document.RepLinenDeliveryForm["linenItemHidden"].value="";
		}if(sourceCode==""){
			content.document.RepLinenDeliveryForm["sourceCodeHidden"].value="";
		}
		content.document.RepLinenDeliveryForm["P_REQUEST_DATE_FROM"].value = content.document.getElementById("conFromDate").value;
		content.document.RepLinenDeliveryForm["P_REQUEST_DATE_TO"].value = content.document.getElementById("conToDate").value;
		content.document.RepLinenDeliveryForm["P_Delivery_Date_From"].value = content.document.getElementById("conFrom").value;
		content.document.RepLinenDeliveryForm["P_Delivery_Date_To"].value = content.document.getElementById("conTo").value;
		content.document.RepLinenDeliveryForm["P_Linen_Item"].value = content.document.RepLinenDeliveryForm["linenItemHidden"].value;
		content.document.RepLinenDeliveryForm["P_Source_Type"].value = content.document.RepLinenDeliveryForm["vo.sourceType"].value;
		content.document.RepLinenDeliveryForm["P_Source_Code"].value = content.document.RepLinenDeliveryForm["sourceCodeHidden"].value;
		
					
		var formObj=content.document.RepLinenDeliveryForm;
		formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
		content.document.RepLinenDeliveryForm.submit();

	}
	
	function converDates(){
		
		var fromDate = document.getElementById("vo.dateFrom").value;
		var toDate = document.getElementById("vo.dateTo").value;
		var from = document.getElementById("vo.from").value;
		var to = document.getElementById("vo.to").value;
		var locale = document.getElementById("locale").value;
		var dateFormate = document.getElementById("dateFormate").value;
		if(fromDate!=""){
			IBADateValidator.convertDateJS(fromDate,locale,'en',dateFormate,callBackFromDate);
			function callBackFromDate(conFromDate){
				document.getElementById("conFromDate").value=conFromDate;
				if(toDate!=""){
				IBADateValidator.convertDateJS(toDate,locale,'en',dateFormate,callBackToDate);
				function callBackToDate(conToDate){
					document.getElementById("conToDate").value=conToDate;
					}
				}else{
					document.getElementById("conToDate").value="";
					}
				if(from!=""){
					IBADateValidator.convertDateJS(from,locale,'en',dateFormate,callBackFrom);
					function callBackFrom(conFrom){
					document.getElementById("conFrom").value=conFrom;
					}
				
				}else{
					document.getElementById("conFrom").value="";
				}
				if(to!=""){
					IBADateValidator.convertDateJS(to,locale,'en',dateFormate,callBackTo);
					function callBackTo(conTo){
					document.getElementById("conTo").value=conTo;
					}
				}else{
					document.getElementById("conTo").value="";
				}
			}
		}else{
			document.getElementById("conFromDate").value="";
		}
					
	}



/*

				var dateTo = content.document.RepLinenDeliveryForm["vo.dateTo"].value;
				if(dateTo!=""){
					content.IBADateValidator.convertJS(dateTo,locale,'en',dateFormate,callBackToDate)
						function callBackToDate(conToDate){
						enToDate=conToDate;
					}
				}else{
					enToDate="";
				}
				var from = content.document.RepLinenDeliveryForm["vo.from"].value;
				if(from != ""){
					content.IBADateValidator.convertJS(from,locale,'en',dateFormate,callBackFrom)
						function callBackFrom(conFrom){ 
							enFrom=conFrom;
						}
				}else{
					enFrom="";
				}
				var to = content.document.RepLinenDeliveryForm["vo.to"].value;
				if(to != ""){
					content.IBADateValidator.convertJS(from,locale,'en',dateFormate,callBackTo)
						function callBackTo(conTo){
							enTo=conTo;
					}

				}else{
					enTo="";
				}
				
				content.document.RepLinenDeliveryForm["P_REQUEST_DATE_FROM"].value = conFromDate;
				content.document.RepLinenDeliveryForm["P_REQUEST_DATE_TO"].value = enToDate;
				content.document.RepLinenDeliveryForm["P_Delivery_Date_From"].value = enFrom;
				content.document.RepLinenDeliveryForm["P_Delivery_Date_To"].value = enTo;
				content.document.RepLinenDeliveryForm["P_Linen_Item"].value = content.document.RepLinenDeliveryForm["linenItemHidden"].value;
				content.document.RepLinenDeliveryForm["P_Source_Type"].value = content.document.RepLinenDeliveryForm["vo.sourceType"].value;
				content.document.RepLinenDeliveryForm["P_Source_Code"].value = content.document.RepLinenDeliveryForm["sourceCodeHidden"].value;
											
				var formObj=content.document.RepLinenDeliveryForm;
				formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
				content.document.RepLinenDeliveryForm.submit();
			}
		}		

/*
	function getReport(){
		
		content.document.getElementById("p_report_id").value = "LCRLNDLY";
		content.document.getElementById("report_id").value = "LCRLNDLY";
		
		var dateFrom = content.document.RepLinenDeliveryForm["vo.dateFrom"].value;
		var linenItem = content.document.RepLinenDeliveryForm["vo.linenItem"].value;
		var sourceCode = content.document.RepLinenDeliveryForm["vo.sourceCode"].value;
		
		var dateFormate = content.document.getElementById("dateFormate").value;
		var locale = content.document.getElementById("locale").value;
		
		content.IBADateValidator.convertJS(dateFrom,locale,'en',dateFormate,callBackFromDate)
			function callBackFromDate(conFromDate){
				
				var dateTo = content.document.RepLinenDeliveryForm["vo.dateTo"].value;
				content.IBADateValidator.convertJS(dateTo,locale,'en',dateFormate,callBackToDate)
					function callBackToDate(conToDate){
				
						var from = content.document.RepLinenDeliveryForm["vo.from"].value;
						content.IBADateValidator.convertJS(from,locale,'en',dateFormate,callBackFrom)
							function callBackFrom(conFrom){ 
								var to = content.document.RepLinenDeliveryForm["vo.to"].value;
								content.IBADateValidator.convertJS(from,locale,'en',dateFormate,callBackTo)
									function callBackTo(conTo){
										if(dateTo == ""){
											content.document.RepLinenDeliveryForm["vo.dateTo"].value = "";
										}if(from == ""){
											content.document.RepLinenDeliveryForm["vo.from"].value = "";		
										}if(to == ""){
											content.document.RepLinenDeliveryForm["vo.to"].value = "";
										}if(linenItem == ""){
											content.document.RepLinenDeliveryForm["linenItemHidden"].value = "";			
										}if(sourceCode == ""){
											content.document.RepLinenDeliveryForm["sourceCodeHidden"].value = "";
										}
									
										content.document.RepLinenDeliveryForm["P_REQUEST_DATE_FROM"].value = conFromDate;
										content.document.RepLinenDeliveryForm["P_REQUEST_DATE_TO"].value = conToDate;
										content.document.RepLinenDeliveryForm["P_Delivery_Date_From"].value = conFrom;
										content.document.RepLinenDeliveryForm["P_Delivery_Date_To"].value = conTo;
										content.document.RepLinenDeliveryForm["P_Linen_Item"].value = content.document.RepLinenDeliveryForm["linenItemHidden"].value;
										content.document.RepLinenDeliveryForm["P_Source_Type"].value = content.document.RepLinenDeliveryForm["vo.sourceType"].value;
										content.document.RepLinenDeliveryForm["P_Source_Code"].value = content.document.RepLinenDeliveryForm["sourceCodeHidden"].value;
										
													
										var formObj=content.document.RepLinenDeliveryForm;
										formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
										content.document.RepLinenDeliveryForm.submit();
									}
								}
							}
						}
					}
*/
	