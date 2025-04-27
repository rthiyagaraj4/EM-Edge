var viewId;
// *************************** FOR DISPALYING CUD PAGE  *****************************************************
	
	function create() {
		//content.location.href = contextPath + "/ReturnofLinentoLaundryAction.do?method=" + loadMethod;
		
		content.location.href = contextPath + "/eLC/ReturnofLinentoLaundry/jsp/ReturnofLinentoLaundryFrames.jsp";
	}
	
// ***************************  VALIDATING FOR ALFANUMERIC VALUES  ******************************************
	
	function checkAlphaNum(){
		obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z_0-9]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   		getServerMessage("messages.AlphaNumeric");
	   		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   		window.event.keyCode = 27;
   		}
   	   }  	
   	   
// *****************************  VALIDATING FOR NUMERIC VALUES  ********************************************
   	   
   	
	   
// ***************************** INSETING RECORDS FOR APPLY  ************************************************

	function apply() {

			var flag=checkNullLocal1();
			if(flag==true){
				content.document.ReturnofLinentoLaundryForm.submit();
				setClearFields1();				
			}
	}
	
// *********************************  NULLCHECK FOR APPLY ***************************************************

		function checkNullLocal1() {
			var flag;
		 	var error="";
		 	var fieldName = new Array("com.iba.ehis.lc.returnoflinentolaundry.source", "com.iba.ehis.lc.returnoflinentolaundry.returnedby", "com.iba.ehis.lc.returnoflinentolaundry.receivedby","com.iba.ehis.lc.linenItem");
	//	 	var fields = new Array(document.getElementById("vo.sourceCode"), document.getElementById("vo.returnedBy"), document.getElementById("vo.receivedBy"), document.getElementById("linenItemDesc"));
		 	var fields = new Array(content.document.ReturnofLinentoLaundryForm["SourceDesc"],content.document.ReturnofLinentoLaundryForm["vo.referenceNum"],content.document.ReturnofLinentoLaundryForm["vo.requestDate"],content.document.ReturnofLinentoLaundryForm["vo.returnedBy"],content.document.ReturnofLinentoLaundryForm["vo.receivedBy"],content.document.ReturnofLinentoLaundryForm["linenItemDesc"]);
			var key_value=new Array();
			for(j=0;j<fieldName.length;j++)
	 			{	
	 			if(fields[j].value=="")
				{	
			 		getServerMessage(fieldName[j]);
			 		key_value[j]=dwrMessage;
					getServerMessage("message.cannot.blank");
					msg=dwrMessage;
			 		msgArray=msg.split('#');
			 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
			 		flag=false;
	 			}
	 		}		 	
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			if(flag==false) return false; else return true;
		}
	
// ***************************** INSETING RECORDS FOR SUBMIT  ***********************************************
	
	function apply1() {
			
				document.ReturnofLinentoLaundryForm.submit();
				setClearFields();				
			
	}

// *********************************  FOR CLEAR FIELDS TO SUBMIT ********************************************
		
	function setClearFields(){
		
	//	document.getElementById("sourceDesc").value="";
		//document.ReturnofLinentoLaundryForm["vo.sourceType"].value="";
		document.ReturnofLinentoLaundryForm["vo.returnedBy"].value="";
		document.ReturnofLinentoLaundryForm["vo.receivedBy"].value="";
		document.ReturnofLinentoLaundryForm["linenItemDesc"].value="";
		document.ReturnofLinentoLaundryForm["qty"].value="";	
	}

// *********************************  FOR CLEAR FIELDS TO APPLY *********************************************

	function setClearFields1(){
		
		document.getElementById("sourceDesc").value="";
		//content.document.getElementById("vo.sourceType").value="";
		content.document.getElementById("vo.returnedBy").value="";
		content.document.getElementById("vo.receivedBy").value="";
		content.document.getElementById("linenItemDesc").value="";
		content.document.getElementById("qty").value="";
	}		
		
// *********************************  CLEAR SOURCE **********************************************************
		
	function setClear(){
		
		document.getElementById("sourceDesc").value="";
		
	}	
	
// *********************************  REMARKS VALIDATION  ***************************************************

	function textAreaLimit(field, maxlen) {
		if (field.value.length > maxlen+1)
			{
				var textVal=field.value.substring(0, maxlen);
				field.value=textVal;
				alert('Should not be more than  '+maxlen+" characters");
			}
			return textVal;
		}

// *********************************  TO DISPLAY CURRENT DATE  **********************************************

	function CurrDate(){	
		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		scNow = currDate.getSeconds();

		mon = mon+1;
		var year = currDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		var convert1= date + "/" + mon + "/" + year;
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		
		convert1=convert1+" "+hrNow+ ":" +mnNow;
		
		var seven = 1000 * 60 * 60 * 24 * 7;
		var reqFromCurrDate = new Date(currDate - seven);
		var fromDate = reqFromCurrDate.getDate();
		var fromMonth = reqFromCurrDate.getMonth();
		fromMonth = fromMonth+1;
		var fromYear = reqFromCurrDate.getYear();
		if(fromDate <10)
			fromDate = "0"+fromDate;
		if(fromMonth <10)
			fromMonth = "0"+fromMonth;
		var reqFromDate= fromDate + "/" + fromMonth + "/" + fromYear;
		var reqFromDate1= reqFromDate+" "+hrNow+ ":" +mnNow;

		var rdate=document.getElementById("vo.requestDate");
		rdate.value=convert1;
		
	}

// *********************************  NULLCHECK FOR SUBMIT **************************************************

	function checkNullLocal() {
		var flag;
	 	var error="";
 	
 	 	var fieldName = new Array("com.iba.ehis.lc.returnoflinentolaundry.source","com.iba.ehis.lc.returnoflinentolaundry.ref.Num","com.iba.ehis.lc.returnoflinentolaundry.date","com.iba.ehis.lc.returnoflinentolaundry.returnedby","com.iba.ehis.lc.returnoflinentolaundry.receivedby","com.iba.ehis.lc.linenItem","com.iba.ehis.lc.returnoflinentolaundry.returnedQuantity");
 	  	var fields = new Array(document.ReturnofLinentoLaundryForm["vo.sourceCode"],document.ReturnofLinentoLaundryForm["vo.referenceNum"],document.ReturnofLinentoLaundryForm["vo.requestDate"],document.ReturnofLinentoLaundryForm["vo.returnedBy"],document.ReturnofLinentoLaundryForm["vo.receivedBy"],document.ReturnofLinentoLaundryForm["linenItemDesc"],document.ReturnofLinentoLaundryForm["qty"]);
		
		var key_value=new Array();
	 	for(j=0;j<fieldName.length;j++)
	 	{	
	 		if(fields[j].value=="")
			{	
		 		getServerMessage(fieldName[j]);
		 		key_value[j]=dwrMessage;
				getServerMessage("message.cannot.blank");
				msg=dwrMessage;
		 		msgArray=msg.split('#');
		 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
		 		flag=false;
	 		}
	 	}
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		if(flag==false) return false; else return true;
	}
	
// ******************************** GET REFERENCE NUMBER THOUGH DWR REQUEST  ***********************

	function getReferenceNumber(){
		
		ReturnofLinentoLaundry.getRefNum(callRefNum)
	}

// ******************************** GET REFERENCE NUMBER CALL BACK FUNCTION  ***********************

	function callRefNum(data){
		
	var obj=document.getElementById("vo.referenceNum");
			var max=0;
			var temp=0;
			 var i = 0;
			var popArray = new Array();
			 for(prop in data){
				popArray[i] = prop;
				i++;
			 }
			 for (var j=0; j <popArray.length;j++ ){
				if(parseInt(popArray[j])>parseInt(max))	
				max=parseInt(popArray[j]);
				
				}
			 obj.value=parseInt(max)+1;
	}

// ******************************** GET AVAILBLE STOCK THOUGH DWR REQUEST  ***********************

	function getAvailbleQty(){
				
		var facility_id = document.getElementById("vo.operatingFacilityId").value;
		var sourceType = document.getElementById("vo.sourceType").value;
		var sourceCode = document.getElementById("vo.sourceCode").value;
		var linenItemCode = document.getElementById("linenItem").value;
		ReturnofLinentoLaundry.getAvailQty(facility_id,sourceType,sourceCode,linenItemCode,callAvailQty)
	}

// ******************************** GET AVAILBLE STOCK CALL BACK FUNCTION  ***********************

	function callAvailQty(data){
		var qty = document.getElementById("qty").value;
		var qty=parseInt(qty);
			
			for(prop in data){
				
				var availQty = data[prop];
				if(availQty==null)availQty=0;
				var availQty=parseInt(availQty);
						
				error=" ";
				if(qty > 0 && qty <= availQty){

					parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
				}else{
					
					if(availQty != '0'){
						
						var flag=getMessage(availQty);
						document.getElementById("qty").value =" ";
						
					//	document.getElementById("linenItemDesc").value =" ";
						document.getElementById("remark").value =" ";
						getServerMessage("APP-LC00021");
						msg=dwrMessage;
						alert(msg+":"+availQty)
						}
						else{
							getServerMessage("APP-LC00020");
							msg1=dwrMessage;
							alert(msg1)
							document.getElementById("qty").value =" ";
							document.getElementById("linenItemDesc").value =" ";
							document.getElementById("remark").value =" ";
						}
					}
				}	
		
			}
	
// ******************************** VALIDATION FOR GET AVAILBLE STOCK ********************************
	
	function getMessage(stock){
		var flag;
	 	var error="";
	 	var fieldName = "com.iba.ehis.lc.returnoflinentolaundry.returnedQuantity";
		var key_value;
	 		 	getServerMessage(fieldName);
		 		key_value=dwrMessage;
				getServerMessage("APP-LC00012");
				msg=dwrMessage;
		 		msgArray=msg.split('#');
		 		error=error +msgArray[0]+ key_value + " " + msgArray[1] +" "+ "AvailableStock"+"("+stock+")"+"<br>";
		 		flag=false;
	 		 	
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		if(flag==false) return false; else return true;
	}
	
// ***************************** LOOKUP FOR SOURCE TYPE *****************************************

	function sourceDescLookup()
		{	
			var sourceType=document.getElementById("vo.sourceType").value;
			
			var sourceDesc = document.getElementById("sourceDesc").value;
			
			if(sourceType != '' && sourceDesc != '')
				showLookup();
	}
	
// ***************************** LOOKUP FOR SOURCE TYPE *****************************************
	
	function showLookup() {
		var sourceType=document.getElementById("vo.sourceType").value;
	
		if(sourceType != ''){
			var facility_Id = document.getElementById("vo.operatingFacilityId").value
			var language_Id = document.getElementById("languageId").value

			var argArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();
			var datatypesArray = new Array();
			
			namesArray[0]="languageId";
			valuesArray[0]=language_Id;
	
			if(sourceType=="W"){
				argArray[0] = "ehis.lc.standardStock.nursingUnit"
				namesArray[1]="facilityId";
				valuesArray[1]=facility_Id;
			}else if(sourceType=="C"){
				argArray[0] = "ehis.lc.standardStock.clinic"
				namesArray[1]="facilityId";
				valuesArray[1]=facility_Id;
			}else if(sourceType=="D"){
				argArray[0] = "ehis.lc.standardStock.deptCode"
			}
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = DESC_CODE;
			argArray[4] = DESC_LINK;
			argArray[5]=document.getElementById("sourceDesc").value;
			getServerMessage("com.iba.ehis.lc.sourceCode");
			retArr = Lookup(dwrMessage, argArray);
			var sourceCode = document.getElementById("vo.sourceCode");
			var sourceDesc = document.getElementById("sourceDesc");
			
			if(retArr!=null){
				sourceCode.value = retArr[0];
				sourceDesc.value = retArr[1];
			}
		}
	}

// ***************************** LOOKUP FOR LINEN ITEM *****************************************

	function showLookupLinenItem()
		{	
			var linenItemDesc=document.getElementById("linenItemDesc").value;
			if(linenItemDesc != "")
				linenItemLookup();
		}

// ***************************** LOOKUP FOR LINEN ITEM *****************************************
	
	function linenItemLookup() {
		var sourceType=document.getElementById("vo.sourceType").value;
		var sourceCode=document.getElementById("vo.sourceCode").value;
		var language_Id=document.getElementById("languageId").value;
		var flag=true;
		var error="";
		var fieldName = new Array(
			"com.iba.ehis.lc.standardStock.sourceType",
			"com.iba.ehis.lc.standardStock.source");
		var fields = new Array(sourceType,sourceCode);
		var key_value= new Array();
		
		for(j=0;j<fieldName.length;j++)
		{
			if(fields[j]=="")
			{	
				getServerMessage(fieldName[j]);
				key_value[j]=dwrMessage;
				getServerMessage("message.cannot.blank");
				msg=dwrMessage;
				msgArray=msg.split('#');
				error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
				flag=false;
			}
				parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		}

		if(flag==true){
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = "ehis.lc.requestForLinen.getlinen"
		
		namesArray[0]="sourceType";
		namesArray[1]="sourceCode";
		namesArray[2]="languageId";
		
		valuesArray[0]=sourceType;
		valuesArray[1]=sourceCode;
		valuesArray[2]=language_Id;
		
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
							
				//Display Order
		argArray[3] = DESC_CODE;

				// Link Description
		argArray[4] = DESC_LINK;
		argArray[5] =document.getElementById("linenItemDesc").value;
		retArr = Lookup("LinenItemCode", argArray);
		
		if(retArr!=null){
			//Set the data in to the fields
			var linenTxt=document.getElementById("linenItem");
			linenTxt.value = retArr[0];
			document.getElementById("linenItemDesc").value=retArr[1];
			}
		}
		
	}		
	
// ***********************************NullCheck for LinenItem ***********************************

	function NullCheckLinenItem() {
		
		var flag;
	 	var error="";
	 	var fieldName = new Array("com.iba.ehis.lc.linenItem");
	 	
		var fields = new Array(document.ReturnofLinentoLaundryForm["linenItem"]);
		
		var key_value=new Array();
	 	for(j=0;j<fieldName.length;j++)
	 	{
	 		if(fields[j].value=="")
			{	
		 		getServerMessage(fieldName[j]);
		 		key_value[j]=dwrMessage;
				getServerMessage("message.cannot.blank");
				msg=dwrMessage;
		 		msgArray=msg.split('#');
		 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
		 		flag=false;
	 		}
	 	}
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		
		if(flag==false) return false; else return true;
		
	}
	
// ***********************************NullCheck for LinenItem ****************************************************************
function reset() {
		create();
	}

// **********************************************************************************************************