		
	function create() {
			parent.content.location.href = contextPath + "/RepQualityFailuresAction.do?method=" + loadMethod;
	}

	function lookUpCommon(mode1)
	{
			if(mode1 == "linenItem")
			{
				var linenItem1 = document.getElementById("vo.linenItem");
				if(linenItem1.value!=""){showLookup(mode1);}
			}else if(mode1 == "natureOfDefect")
			{
				var natureOfDefect1 = document.getElementById("vo.natureOfDefect");
				if(natureOfDefect1.value!=""){showLookup(mode1);}
			}else if(mode1 == "reasonForDefect")
			{
				var reasonForDefect1 = document.getElementById("vo.reasonForDefect");
				if(reasonForDefect1.value!=""){showLookup(mode1);}
			}
	}
	
	function showLookup(mode){
		
		var retArr;
		var argArray = new Array();
		var datatypesArray = new Array();
		var valuesArray = new Array();
		var namesArray = new Array();
		var linenItem = document.getElementById("vo.linenItem");
		var linenItemHidden = document.getElementById("linenItemHidden");
		var natureOfDefect = document.getElementById("vo.natureOfDefect");
		var natureOfDefectHidden = document.getElementById("natureOfDefectHidden");
		var reasonForDefect = document.getElementById("vo.reasonForDefect");
		var reasonForDefectHidden = document.getElementById("reasonForDefectHidden");
		
		if(mode == "linenItem"){
			
			argArray[0] = "ehis.lc.standardStock.linenItem";
			namesArray[0] = "languageId";
			valuesArray[0]= document.getElementById("locale1").value;
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
		}else if(mode == "natureOfDefect"){
			
			argArray[0] = "ehis.lc.natureofdefectlookup";
			valuesArray[0]= document.getElementById("locale1").value;
			namesArray[0] = "language_Id";
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
		}else if(mode="reasonForDefect"){
			
			argArray[0] = "ehis.lc.reason.getActionType";
			valuesArray[0]= document.getElementById("locale1").value;
			namesArray[0] = "languageId";
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
		}
	
								
		//Display Order
		argArray[3] =DESC_CODE ;
		// Link Description
		argArray[4] = DESC_LINK;
		if(mode == "linenItem"){
			argArray[5] = linenItem.value;
		}else if(mode == "natureOfDefect"){
			argArray[5] = natureOfDefect.value;
		}else if(mode="reasonForDefect"){
			argArray[5] = reasonForDefect.value;
		}
		// Lookup will return code and description - retArr hold it

		getServerMessage("com.iba.ehis.lc.linenItem");
		var linenItemLabel = dwrMessage;
		getServerMessage("com.iba.ehis.lc.enterCleanedLinen.natureOfDefect");
		var natureLabel = dwrMessage;
		getServerMessage("com.iba.ehis.lc.reasonfordefect");
		var reasonLabel = dwrMessage;
		if(mode == "linenItem"){
			retArr= Lookup(linenItemLabel,argArray);
		}else if(mode == "natureOfDefect"){
			retArr= Lookup(natureLabel,argArray);
		}else if(mode == "reasonForDefect"){
			retArr= Lookup(reasonLabel,argArray);
		}
		if(retArr!=null){
			if(mode == "linenItem"){
				linenItem.value=retArr[1];
				linenItemHidden.value=retArr[0];
			}else if(mode == "natureOfDefect"){
				natureOfDefect.value=retArr[1];
				natureOfDefectHidden.value=retArr[0];
			}else if(mode == "reasonForDefect"){
				reasonForDefect.value=retArr[1];
				reasonForDefectHidden.value=retArr[0];
			}
		}else
		{
			if(mode == "linenItem"){
				linenItem.value="";
				linenItemHidden.value="";
			}else if(mode == "natureOfDefect"){
				natureOfDefect.value="";
				natureOfDefectHidden.value="";
			}else if(mode == "reasonForDefect"){
				reasonForDefect.value="";
				reasonForDefectHidden.value="";
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
		var fieldName = new Array("com.iba.ehis.lc.cleaningdate");
		var fields = new Array(content.document.RepQualityFailuresForm["vo.dateFrom"]);
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
		var locale = content.document.getElementById("locale1").value;
		getServerMessage("com.iba.ehis.lc.To");
		var To = dwrMessage;
		var legend =new Array("com.iba.ehis.lc.requestDateFrom","com.iba.ehis.lc.currentdate","com.iba.ehis.lc.requestForLinen.requestDate")
		if(fromDate !="" || toDate !="" ){
			content.IBADateValidator.isCurrentDateLesserThanJS(fromDate,locale,callBackFunction);
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
					content.IBADateValidator.isDateGreaterThanJS(fromDate,toDate,locale,callBackFunction);
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
					error= split_message[0]+" "+legend_key0 +" "+split_message[1]+ " "+legend_key2+" "+To;
				//	error="APP-LC00012 fromDate should be less than toDate"
					messageFrame.location.href = contextPath + "/core/jsp/MessageFrame.jsp?error=" + error;
					}
					else{
						
					var error="";
					messageFrame.location.href = contextPath + "/core/jsp/MessageFrame.jsp?error=" + error;
					getReport();
					}
				}
			}
		}
		}else{
			var f1;
			var error = "";
			var fieldName = new Array("com.iba.ehis.lc.cleaningdate");
			var fieldValues = new Array(content.document.RepQualityFailuresForm["vo.dateFrom"]);
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
		
		content.document.RepQualityFailuresForm["p_report_id"].value = "LCRQULFL";
		content.document.RepQualityFailuresForm["report_id"].value = "LCRQULFL";

		var fromDate = content.document.RepQualityFailuresForm["vo.dateFrom"].value;
		var locale = content.document.getElementById("locale1").value;
		var datFormate = content.document.getElementById("datFormate").value;
		
		var linenItem = content.document.getElementById("vo.linenItem").value;
		var natureOfDefect = content.document.getElementById("vo.natureOfDefect").value;
		var reasonForDefect = content.document.getElementById("vo.reasonForDefect").value;
		
		if(fromDate != ""){
				
			IBADateValidator.convertDateJS(fromDate,locale,'en',datFormate,callBackFromDate);
			function callBackFromDate(conFromDate){
				var toDate = content.document.RepQualityFailuresForm["vo.dateTo"].value;
				if(toDate!=""){
					IBADateValidator.convertDateJS(toDate,locale,'en',datFormate,callBackToDate);
					function callBackToDate(conToDate){
						
						content.document.RepQualityFailuresForm["p_report_id"].value = "LCRQULFL";
						content.document.RepQualityFailuresForm["report_id"].value = "LCRQULFL";
						if(linenItem==""){
							content.document.RepQualityFailuresForm["linenItemHidden"].value="";
						}if(natureOfDefect==""){
							content.document.RepQualityFailuresForm["natureOfDefectHidden"].value="";
						}if(reasonForDefect==""){
							content.document.RepQualityFailuresForm["reasonForDefectHidden"].value=="";
						}
						content.document.RepQualityFailuresForm["P_From_Date"].value = conFromDate;
						content.document.RepQualityFailuresForm["P_To_Date"].value =	conToDate;
						content.document.RepQualityFailuresForm["P_Linen_Item"].value = content.document.RepQualityFailuresForm["linenItemHidden"].value;
						content.document.RepQualityFailuresForm["P_Nature_of_Defect"].value = content.document.RepQualityFailuresForm["natureOfDefectHidden"].value;
						content.document.RepQualityFailuresForm["P_Reason_for_Defect"].value = content.document.RepQualityFailuresForm["reasonForDefectHidden"].value;
						
						var formObj=content.document.RepQualityFailuresForm;
						formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
						content.document.RepQualityFailuresForm.submit();
					}
				}else if(toDate==""){
						
						content.document.RepQualityFailuresForm["p_report_id"].value = "LCRQULFL";
						content.document.RepQualityFailuresForm["report_id"].value = "LCRQULFL";
						if(linenItem==""){
							content.document.RepQualityFailuresForm["linenItemHidden"].value="";
						}if(natureOfDefect==""){
							content.document.RepQualityFailuresForm["natureOfDefectHidden"].value="";
						}if(reasonForDefect==""){
							content.document.RepQualityFailuresForm["reasonForDefectHidden"].value=="";
						}
						content.document.RepQualityFailuresForm["P_From_Date"].value = conFromDate;
						content.document.RepQualityFailuresForm["P_To_Date"].value =	"";
						content.document.RepQualityFailuresForm["P_Linen_Item"].value = content.document.RepQualityFailuresForm["linenItemHidden"].value;
						content.document.RepQualityFailuresForm["P_Nature_of_Defect"].value = content.document.RepQualityFailuresForm["natureOfDefectHidden"].value;
						content.document.RepQualityFailuresForm["P_Reason_for_Defect"].value = content.document.RepQualityFailuresForm["reasonForDefectHidden"].value;
						
						var formObj=content.document.RepQualityFailuresForm;
						formObj.action=contextPath + "/eCommon/jsp/report_options.jsp";
						content.document.RepQualityFailuresForm.submit();
						}	
					}
				}
			}

	function reset(){
	   content.location.href=contextPath+"/RepQualityFailuresAction.do?method="+loadMethod
	}

	