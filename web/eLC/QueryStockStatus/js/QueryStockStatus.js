		function create() { 
			
			content.location.href = contextPath + "/eLC/QueryStockStatus/jsp/StockStatusFrame.jsp";
		}
						
		function getStock(obj){
			var functionId="Source"
			parent.criteriaFrame.location.href=contextPath+"/QueryStockStatusAction.do?method="+loadMethod+"&function_Id="+functionId+"&vo.functionId=LC_SOURCESTOCKSTATUS";
			parent.stockStatusResult.location.href = contextPath + "/core/jsp/blank.jsp";
		}
		
		function getLinen(obj)
			{
			var functionId="LinenItem"
			parent.criteriaFrame.location.href=contextPath+"/QueryStockStatusAction.do?method="+loadMethod+"&function_Id="+functionId+"&vo.functionId=LC_LINENITEMSTOCKSTATUS";
			parent.stockStatusResult.location.href = contextPath + "/core/jsp/blank.jsp";
		}
		
		function clearField(){
			var sourceCode = document.getElementById("vo.criteriaItems[0].itemValue");
			var sourceDesc = document.getElementById("sourceDesc");
			var sourceType = document.getElementById("source");
			sourceCode.value = "";
			sourceDesc.value = "";
		}

		function showSourceLookup()
			{
			var argArray = new Array();
			var datatypesArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();
			var facilityId = document.getElementById("vo.facilityId").value;
			var sourceCode = document.getElementById("vo.criteriaItems[0].itemValue");
			var sourceDesc = document.getElementById("sourceDesc");
			var sourceType = document.getElementById("source");
			var languageId = document.getElementById("languageId").value;
			if(sourceType.value == "W"){
					argArray[0] = "ehis.lc.standardStock.nursingUnit";
					}else if(sourceType.value == "C")
					{
					argArray[0] = "ehis.lc.standardStock.clinic";
					}else if(sourceType.value == "D"){
					argArray[0] = "ehis.lc.standardStock.deptCode";
				}
				else
				{
					getServerMessage("com.iba.ehis.lc.standardStock.sourceType");
					var label=dwrMessage;
					getServerMessage("message.cannot.blank");
					var msg=dwrMessage;
					msgArray=msg.split('#');
					var error="";
					error=error +msgArray[0]+ label + " " + msgArray[1] +"<br>";
					parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
				}
				namesArray[0]="languageId";
				valuesArray[0]=languageId;

				namesArray[1]="facilityId";
				valuesArray[1]=facilityId;

				
				argArray[1] = new Array();
				argArray[2] = new Array();
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
						
				argArray[3] = DESC_CODE ;
				argArray[4] = DESC_LINK;
				argArray[5] = document.getElementById("sourceDesc").value;
				
				if(sourceType.value == "W"){
						getServerMessage("com.iba.ehis.lc.ward");
						var lable = dwrMessage;
						retArr= Lookup(lable,argArray)
					}else if(sourceType.value == "C"){
						getServerMessage("com.iba.ehis.lc.clinic");
						var lable = dwrMessage;
						retArr= Lookup(lable,argArray)
					}else if(sourceType.value == "D"){
						getServerMessage("com.iba.ehis.lc.deptcodes");
						var lable = dwrMessage;
						retArr= Lookup(lable,argArray)
					}
			if(retArr!=null){		
				if(parseInt(retArr.length)>0){
						sourceCode.value=retArr[0];
						sourceDesc.value=retArr[1];
						
						}}
					}

		function linenItemLookup()
			{
			var argArray = new Array();
			var datatypesArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();
			var linenItemDesc = document.getElementById("linenItemDesc");
			var languageId = document.getElementById("languageId").value;
			var linenItemCode = document.getElementById("vo.criteriaItems[0].itemValue");
						
			argArray[0] = "ehis.lc.standardStock.linenItem";
			namesArray[0]="languageId";
			valuesArray[0]=languageId;
			
			argArray[1] = new Array();
			argArray[2] = new Array();
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = DESC_CODE;
			argArray[4] = DESC_LINK;
			argArray[5] = linenItemDesc.value;
			
			getServerMessage("com.iba.ehis.lc.linenItem");
			var lable = dwrMessage;
			retArr= Lookup(lable,argArray)
			if(retArr!=null){
				linenItemDesc.value=retArr[1];
				linenItemCode.value=retArr[0];
						
				}
			}

	function sourceChk()
		{
		//document.QueryCriteriaForm.submit();
		var error="";
		var fields=document.getElementById("vo.criteriaItems[0].itemValue");
		if(fields.value=="")
			{
				getServerMessage("com.iba.ehis.lc.source");
				key_value=dwrMessage;
		 		getServerMessage("message.cannot.blank");
		 		msg=dwrMessage;
				msgArray=msg.split('#');
		 		error=error +msgArray[0]+ " " +key_value+" "+msgArray[1] +"<br>";
		 	
			parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			}
			else{
				document.QueryCriteriaForm.submit();
			}
		}
		
	function linenItemChk()
		{
		var error="";
		var fieldName=new Array("com.iba.ehis.lc.linenItem");
		var fields=new Array(document.getElementById("vo.criteriaItems[0].itemValue"));
		if(fields[0].value=="")
			{
				getServerMessage(fieldName[0]);
		 		key_value=dwrMessage;
		 		getServerMessage("message.cannot.blank");
		 		msg=dwrMessage;
				msgArray=msg.split('#');
		 		error=error +msgArray[0]+ key_value + " " + msgArray[1] +"<br>";
			parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			}
			else{
				var error="";
		
			document.QueryCriteriaForm.submit();
				
			}
		}
				
	function reset()
		{
 	    	content.location.href = contextPath + "/eLC/QueryStockStatus/jsp/StockStatusFrame.jsp";
 		}
 		 		