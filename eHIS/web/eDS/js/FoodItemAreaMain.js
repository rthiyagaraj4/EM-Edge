	var itemCodeArray=new Array();
	var itemDescArray=new Array();

	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/FoodItemForKitchenAreaCud.jsp?"+params+"&mode=insert";
	}
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/FoodItemAreaQueryCriteria.jsp?"+params;		
	}
	
	function apply() {	
		var flag=checkNull();
		if(flag==true){
			var formObj = parent.content.f_query_add_mod.FoodItemForKitchenArea;
			var kitchen = formObj.kitchen.value;
			formObj.kitchen1.value=kitchen;
			var mode = "insert"
			formObj.mode.value=mode;
			var kitchenArea = formObj.kitchenArea.value;
			formObj.kitchenArea1.value=kitchenArea;
			formObj.submit();
		}
	}
	
	function reset(){
	 f_query_add_mod.document.location.reload();
	}
	
	
	function checkNull(){
		var flag;
	 	var error="";
	 	var formObj = parent.content.f_query_add_mod.FoodItemForKitchenArea;
	 	
	 	var kitchen = formObj.kitchen.value;
	 	var kitchen_label=getLabel("eOT.Kitchen.Label","OT");
	 	
	 	var kitchenArea = formObj.kitchenArea.value;
	 	var kitchen_Area_label=getLabel("eOT.KitchenArea.Label","OT");
	 	
	 	var foodItemDesc = formObj.foodItemCodeDescription.value;
	 	var food_Item_label=getLabel("eOT.FoodItem.Label","OT");
	 	
	 	if(kitchen=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_label)+"<br>";
	 	}
	 	if(kitchenArea=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_Area_label)+"<br>";
	 	}
/*	 	if(foodItemDesc=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",food_Item_label)+"<br>";
	 	}*/
		messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		if(flag==false) return false; else return true;
	 	
	 	
	}
	
	function foodItemForKitchenArea(obj){
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?"
		var formObj = parent.frames[1].document.forms[0];
		var KitchenValue = obj.value;
		var facilityId = document.getElementById("facilityId").value;
		var language_Id =document.getElementById("language_id").value;
		//var xmldoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlstr = "<root><SEARCH  /></root>";
		itemCodeArray=new Array();//IN::39913
		//xmlDoc.loadXML(xmlstr);
		var xmlDoc = new DOMParser().parseFromString(xmlstr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?func_mode=foodItemForKitchenArea&KitchenValue="+KitchenValue+"&facilityId="+facilityId,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		var primary_id =   formObj.kitchenArea;

		while(primary_id.length > 0){
			primary_id.remove(0);
		}
		if(retVal!=''){
			var retValArr = retVal.split("???");
			var kitchenArea = "";
			var primary_id =   formObj.kitchenArea;
			var listOption1	= document.createElement('OPTION');
			var msg = "----select----";
			listOption1.text = msg;
			listOption1.value= "";
			primary_id.add(listOption1);
			if(retValArr!=''){
				for(var i=0; i<retValArr.length; i++){
					kitchenArea = retValArr[i].split(":::");
					var listOption1	= document.createElement('option');
					var msg = "----select----"
					listOption1.text = msg;
					listOption1.value= "";
					
					listOption1.value = kitchenArea[1];
					listOption1.text = kitchenArea[0];
					
					primary_id.add(listOption1);
				}
			}
		
		}else{
			var listOption1	= document.createElement('OPTION');
			var msg = "----select----";
			listOption1.text = msg;
			listOption1.value= "";
			primary_id.add(listOption1);
		parent.frames[1].document.forms[0].kitchenArea.value='';
		document.FoodItemForKitchenArea.document.getElementById("listContentTable").innerText='';
		}
	}
	function foodItemForKitchenAreaItem(){
		var formObj = parent.frames[1].document.forms[0];
		var kitchenAreaCode = formObj.kitchenArea.value;
		var kitchenCode = formObj.kitchen.value;
		var facilityId = document.getElementById("facilityId").value;
		//var xmldoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		
		var xmlstr = "<root><SEARCH  /></root>";
		//xmlDoc.loadXML(xmlstr);
		var xmlDoc = new DOMParser().parseFromString(xmlstr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?func_mode=foodItemForKitchenAreaItem&kitchenAreaCode="+kitchenAreaCode+"&kitchenCode="+kitchenCode+"&facilityId="+facilityId,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		itemCodeArray=new Array(); //IN::39913
		itemDescArray=new Array();
		if(retVal!=''){
			var retValArr = retVal.split("???");
			var kitchenAreaItems = "";
			if(retValArr!=''){
				var tableObj=document.getElementById("listContentTable");
				var foodItemCodeDesc = formObj.foodItemCode;
				while(tableObj.rows.length>1){
					//tableObj.deleteRow(1)
					tableObj.deleteRow(0); //Modified for IN:39031
				}
				index=0;
				index=parseInt(index)
				var qryEven = "QRYEVEN";
				var qryOdd = "QRYODD";
				for(var i=0; i<retValArr.length; i++){
					kitchenAreaItems = retValArr[i].split(":::");
					var classVal = (index % 2 == 0) ? qryEven : qryOdd;
					if(kitchenAreaItems!=null){
						var row = tableObj.insertRow(index);
						var col1 = row.insertCell();
						col1.innerHTML='<a href=javascript:showLookup1("'+ escape(kitchenAreaItems[0]) +'","'+ escape(kitchenAreaItems[1]) +'")>'+kitchenAreaItems[1]+'</a>'; //Modified for IN:39031
						col1.align="left";
						col1.className = classVal;
						
						itemCodeArray.push(kitchenAreaItems[0]);
						itemDescArray.push(kitchenAreaItems[1]);
					}
					index++;
				}
			}
			
		}else{document.getElementById("listContentTable").innerText='';}
		
		document.getElementById("foodItemCode1").value = itemCodeArray;
		
	}
	
	 function getLookupDetail(){
		 var formObj = parent.frames[1].document.forms[0];
		 var val = formObj.foodItemCodeDescription.value;
		 if( val !=""){
			 showLookup();
		 }
			 
	 }
	
	function localTrimString(sInString) {
		return sInString.replace(/^\s+|\s+$/g,"");
	}
	
	async function showLookup(){
		var locale=document.getElementById("language_id").value;
		var formObj = parent.frames[1].document.forms[0];
		var val = localTrimString(formObj.foodItemCodeDescription.value);
		
		var argumentArray = new Array();
		var dataNameArray = new Array();
		var dataValueArray = new Array();
		var dataTypeArray = new Array();
		
		var sql = "SELECT FOODITEM.FOOD_ITEM_CODE CODE,FOODITEM.SHORT_DESC DESCRIPTION FROM DS_FOOD_ITEM_LANG_VW FOODITEM WHERE UPPER(FOODITEM.SHORT_DESC) LIKE UPPER(?) AND UPPER(FOODITEM.FOOD_ITEM_CODE) LIKE UPPER(?) AND FOODITEM.LANGUAGE_ID='"+locale+"'";
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = val;
		
		// Link Description
		argumentArray[6] = DESC_LINK;
		//Display Order
		argumentArray[7] = DESC_CODE;
		
		// Lookup will return code and description - retArr hold it
		var retArr =await CommonLookup("Food Item Code", argumentArray);
		var ret1=unescape(retArr);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		var foodItemCode = formObj.foodItemCode;
		var foodItemCodeDesc = formObj.foodItemCodeDescription;
		
		if(retArr!=null){
			foodItemCode.value=arr[0];
		    foodItemCodeDesc.value=arr[1];
		}
		//IN::39913
		if(!retArr){
			foodItemCode.value="";
		    foodItemCodeDesc.value="";
		}
	}
	
	//IN:39031-The below method is modified by Abirami
	//Modification: Passing FoodItemCode to this method
	function showLookup1(code, desc){
		var locale=document.getElementById("language_id").value;
		var formObj = parent.frames[1].document.forms[0];
		var val = localTrimString(formObj.foodItemCodeDescription.value);
		
		var argumentArray = new Array();
		var dataNameArray = new Array();
		var dataValueArray = new Array();
		var dataTypeArray = new Array();
		
		var sql = "SELECT FOODITEM.FOOD_ITEM_CODE CODE,FOODITEM.SHORT_DESC DESCRIPTION FROM DS_FOOD_ITEM_LANG_VW FOODITEM WHERE UPPER(FOODITEM.SHORT_DESC) LIKE UPPER(?) AND UPPER(FOODITEM.FOOD_ITEM_CODE) LIKE UPPER(?) AND FOODITEM.LANGUAGE_ID='"+locale+"'";
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = desc;
		
		// Link Description
		argumentArray[6] = DESC_LINK;
		//Display Order
		argumentArray[7] = DESC_CODE;
		
		// Lookup will return code and description - retArr hold it
		//var retArr = CommonLookup("Food Item Code", argumentArray); //Commented for IN:39031
		
		var foodItemCode = formObj.foodItemCode;
		var foodItemCodeDesc = formObj.foodItemCodeDescription;
		//IN:39031
		/*if(retArr!=null){
			foodItemCode.value=retArr[0];
		    foodItemCodeDesc.value=retArr[1];
		}*/
		foodItemCode.value=code; 
		foodItemCodeDesc.value=desc;
	}
 function onSuccess()
    {
    f_query_add_mod.location.reload();
    }
	
	function pickupContent(obj){
		//alert(code);
		//var formObj = parent.frames[1].document.forms[0];
		//var foodItemCode = formObj.foodItemCode;
		
		//var foodItemCodeDesc = formObj.foodItemCodeDescription;
		//foodItemCodeDesc.value = code;
		//alert(foodItemCodeDesc.value);
		var formObj = document.FoodItemForKitchenArea;
		
		
		//alert(cell1);
		
	}
	
	function selectRecord(){
		var foodItemCode = document.FoodItemForKitchenArea.foodItemCode.value;
	    if(foodItemCode==""){
			alert("Food Item Cannot be Blank ");
		}else{
		var fields = new Array (document.FoodItemForKitchenArea.foodItemCode,document.FoodItemForKitchenArea.foodItemCodeDescription);
		var food_Item = getLabel("eOT.FoodItem.Label","ot");
		var names = new Array (food_Item);
		if(checkFieldsofMst( fields, names, parent.parent.parent.messageFrame)){
			var rowCount = 0;
			//rowCount = document.FoodItemForKitchenArea.document.getElementById("listContentTable").rows.length;
			rowCount = document.getElementById("listContentTable").rows.length;
			var foodItemCode = document.FoodItemForKitchenArea.foodItemCode.value;
			var length=itemCodeArray.length;
			itemCodeArray[length] = foodItemCode;
			document.getElementById("foodItemCode1").value = itemCodeArray;
			var foodItemCodeDesc = document.FoodItemForKitchenArea.foodItemCodeDescription.value;
			itemDescArray[length]=foodItemCodeDesc;
			
			if(rowCount>1){
				//for(j=2;j<=rowCount;j++){
				//IN:39031-Modification - start
				var j=1; 
				for(j=1;j<rowCount;j++){
					k = j-1;
				    //IN:39031-Modification - end
					//var selectedText = document.FoodItemForKitchenArea.document.getElementById("listContentTable").rows[k].cells[0].innerText;
					var selectedText = document.getElementById("listContentTable").rows[k].cells[0].innerText;
					if(foodItemCodeDesc == selectedText){
						if(document.FoodItemForKitchenArea.forUpdate.value == 'yes'){
							document.getElementById("listContentTable").rows[k].cells[0].innerText = "<a href=javascript:pickupContent("+j+")>"+foodItemCode+"</a>"
							document.FoodItemForKitchenArea.foodItemCodeDescription.value = "";
						}
						else{
							alert('Record already exists');
							// delete the recently added item
							itemCodeArray.splice(length,1);
							itemDescArray.splice(length,1);
							document.getElementById("foodItemCode1").value = itemCodeArray;
						}
						document.FoodItemForKitchenArea.forUpdate.value = 'no';
						return true;
					}
					
				}
			}
			document.FoodItemForKitchenArea.forUpdate.value = 'no';
			var newRow = document.getElementById("listContentTable").insertRow(j-1);//IN:39031 Modification
			var newCell = newRow.insertCell();
			rowCount = document.getElementById("listContentTable").rows.length;
			newCell.innerHTML = '<a href=javascript:showLookup1("'+ escape(foodItemCode) +'","' +escape(foodItemCodeDesc)+'")>'+foodItemCodeDesc+'</a>'; //IN:39031 Modification
			document.FoodItemForKitchenArea.foodItemCode.value = "";
			document.FoodItemForKitchenArea.foodItemCodeDescription.value = "";
			
		}
	 }
	}
	
	function checkNullValues(){
		var flag;
	 	var error="";
	 	var formObj = document.FoodItemForKitchenArea;
		var kitchen=formObj.kitchen.value;
	 	var kitchen_label=getLabel("eOT.Kitchen.Label","OT");
	 	var kitchenArea = formObj.kitchenArea.value;
	 	var kitchen_Area_label=getLabel("eOT.KitchenArea.Label","OT");
	 	var foodItemDesc = formObj.foodItemCodeDescription.value;
	 	var food_Item_label=getLabel("eOT.FoodItem.Label","OT");
	 	
	 	if(kitchen=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_label)+"<br>";
	 	}
	 	if(kitchenArea=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_Area_label)+"<br>";
	 	}
	 	if(foodItemDesc=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",food_Item_label)+"<br>";
	 	}
		
		parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		if(flag==false) return false; else return true;
	 	
	 	
	}
	function cancelRecord(){
        var flag=checkNullValues();
		if(flag==true){
            /*var formObj = document.FoodItemForKitchenArea;
		    var kitchen = formObj.kitchen.value;
			formObj.kitchen1.value=kitchen;
			var mode = "delete"
			formObj.mode.value=mode;
			var kitchenArea = formObj.kitchenArea.value;
			formObj.kitchenArea1.value=kitchenArea;
			foodItemForKitchenAreaItem();
			parent.f_query_add_mod.document.forms[0].submit();*/
			var itemCode=document.getElementById("foodItemCode").value;
			var index=-1;
			for(var i=0; i<itemCodeArray.length; i++){
				if(itemCodeArray[i] == itemCode) {
					index=i;
					break;
				}
			}
//			var index=itemCodeArray.indexOf(itemCode);
			if(parseInt(index)!=-1) {
				itemCodeArray.splice(index,1);
				itemDescArray.splice(index,1);
			}
			document.getElementById("foodItemCode1").value = itemCodeArray;
			iter=0;
			iter=parseInt(iter)
			var qryEven = "QRYEVEN";
			var qryOdd = "QRYODD";
			
			var tableObj=document.getElementById("listContentTable");
			
			while(tableObj.rows.length>1){
				//tableObj.deleteRow(1)
				tableObj.deleteRow(0); //Modified for IN:39031
			}
			
			for(var i=0; i<itemCodeArray.length; i++){
				var classVal = (iter % 2 == 0) ? qryEven : qryOdd;
				if(itemCodeArray[i] !=null){
					var row = tableObj.insertRow(iter);
					var col1 = row.insertCell();
					col1.innerHTML='<a href=javascript:showLookup1("'+ escape(itemCodeArray[i]) +'","'+ escape(itemDescArray[i]) +'")>'+itemDescArray[i]+'</a>'; //Modified for IN:39031
					col1.align="left";
					col1.className = classVal;
				}
				iter++;
			}			
			
			}
		document.FoodItemForKitchenArea.foodItemCode.value = "";
		document.FoodItemForKitchenArea.foodItemCodeDescription.value = "";
			
	}
