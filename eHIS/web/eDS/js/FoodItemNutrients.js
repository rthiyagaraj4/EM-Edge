	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/FoodItemAddModify.jsp?"+params+"&mode=insert";
	}
	
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/FoodItemQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("FoodItemAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("FoodItemMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("FoodItemQueryCriteria.jsp") != -1)
		 {
			 f_query_add_mod.document.forms[0].reset();
		 }
	}
		
	
	function onSuccess()
	{
		var formObj =document.forms[0];
		var params = formObj.params.value;
		if(f_query_add_mod.FoodItemAdd.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href="../../eDS/jsp/FoodItemAddModify.jsp?"+params+"&mode=insert";
		else
			f_query_add_mod.FoodItemAdd.location.reload();

	}
	
	function getNutrients(obj){
		document.location.href='../../eDS/jsp/NutrientsPopulate.jsp?foodItem='+obj.value;
		/*var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=getNutrientsList&nutrients_code="+obj.value;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);	
		alert(retVal);
		var indItems = retVal.split("???");
		var kitchenItems = "";
		var rowCount = document.getElementById("listContentTable").rows.length;
		if(rowCount>1){
			for (var i=rowCount;i>=2;i--){
				document.all("listContentTable").deleteRow(i-1);
			}
		}
		if(indItems!=''){
		for(var i=0; i<indItems.length; i++){
			var newRow = document.all("listContentTable").insertRow();
			kitchenItems = indItems[i].split(":::");
			var cnt = i+2;
			for(var j=0;j<kitchenItems.length;j++){
				var newCell = newRow.insertCell();
				if(j==0){
					newCell.innerHTML = "<a href='javascript:callfn12("+cnt+");'>"+ kitchenItems[j]+"</a>";
				}
				else if((j==1)){
					newCell.innerText = kitchenItems[j];
				}
				else{
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "nutMode"+i);
					input.setAttribute("value", kitchenItems[j]+"::U");
					document.getElementById("nutrients_form").appendChild(input);
				}
				//document.getElementById("listContentTable").rows[i].cells[j].innerText = kitchenItems[j];
			}
			
		}
		}
		/*for(var i=0; i<retVal.length;i++){
			alert(retVal[i]);
		}*/
	}
	
	function localTrimString(sInString) {
		 
		  return sInString.replace(/^\s+|\s+$/g,"");
		}
	
	function CheckPosNumber(obje) {
		var obj = document.getElementById(obje);
	    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
	        return true;
	    }
	    else {
	        if ( obj.value.length > 0 ) {

	            alert(getMessage("NUM_ALLOWED", "SM"));
	            document.getElementById(obje).value = "";
	            return false;
	        }
	    }
	}
	
	//IN:39847 
	function checkPosAfterEnter(obj){
		var str = document.getElementById("content_Value").value;
		var nPosition =str.indexOf(".");
		if( nPosition >= 0)
		{
			nRealvalue = str.substring(0, nPosition);
			nDecimalvalue = str.substring(nPosition,str.length);
			if(nRealvalue.length>5 || nDecimalvalue.length>3)
				document.getElementById("content_Value").value = document.getElementById("hdnContentValue").value; 
		}
	}
	
	//IN:39847 - Modified by Abirami
	function CheckValidNumber(e){
	
	//Declaration
	var str = document.getElementById("content_Value").value;
	var totalLength = str.length;
	var nPosition =str.indexOf(".");
	var nRealvalue  = "";
	var nDecimalvalue ="";
	var code = "";
	
	
	if (e.keyCode)
		 code = e.keyCode;
	else if (e.which)
		  code = e.which;
	
	//Allowing Backspace,Delete,Home key:
	if(code == 8 || code == 46 || code == 37 || code == 36 || code == 39 || code == 35)
		return true;

	if(code == 32)
		return false;
	
   	   //To Block more than one dots :
		if(code == 110 || code == 190)
			{ 
			  if(document.getElementById("content_Value").value.split('.').length > 1)
			  {
					return false;
			  }else
			  {
				return true;
			  }
			}
		
		if( nPosition >= 0)
		{
			nRealvalue = str.substring(0, nPosition);
			nDecimalvalue = str.substring(nPosition,str.length);
			document.getElementById("hdnContentValue").value = document.getElementById("content_Value").value;
		}else
		{ 
			nRealvalue  = str;
			//To Block the real value to 5 in length
			if(nRealvalue.length>4)
			{
			  return false;
			}
		}
	var nReallength = nRealvalue.length;
	
		if(totalLength>7)
		{
			//To Block the decimal value to [totallength-Reallength+1 !=8]
			if(totalLength-nReallength+1 != 8)
			{
			 window.event.returnValue = null;
			}
		}
	}
	
	function selectRecord1() {
		var fields = new Array (document.NutrientsAdd.nutrient_Code,document.NutrientsAdd.content_Value);
		var nutLabel=getLabel("eOT.Nutrient.Label","ot");
		var contentLabel=getLabel("eOT.ContentValue.Label","ot");
		
		var names = new Array ( nutLabel,contentLabel);
		if(checkFieldsofMst( fields, names, parent.parent.parent.messageFrame)){
			var rowCount = 0;
			rowCount = parent.NutrientsPopulate.document.getElementById("listContentTable").rows.length;
			var nutrient = document.NutrientsAdd.nutrient_Code.value;
			var contentValue = document.NutrientsAdd.content_Value.value;
			
			if(rowCount>1){
				/*if(rowCount==2){
					if(parent.NutrientsPopulate.document.getElementById("listContentTable").rows[1].cells[0].innerText==''){
						parent.NutrientsPopulate.document.all("listContentTable").deleteRow(1);
						rowCount = rowCount-1;
					}
				}*/
				for(j=2;j<=rowCount;j++){
					var k = j-1;
					var selectedText = parent.NutrientsPopulate.document.getElementById("listContentTable").rows[k].cells[0].innerText;
					//IN:39847 Start:
					//Selected Value:
					var selectedValue = parent.NutrientsPopulate.document.getElementById("listContentTable").rows[k].cells[1].innerText;
					if(nutrient == selectedText && contentValue == selectedValue){
						alert('Record already exists');
						return true;
					}
					//IN:39847 End:
					if(nutrient == selectedText){
						if(document.NutrientsAdd.forUpdate.value == 'yes'){
							parent.NutrientsPopulate.document.getElementById("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+nutrient+"</a>";
							parent.NutrientsPopulate.document.getElementById("listContentTable").rows[k].cells[1].innerText = contentValue;
							
							 document.NutrientsAdd.nutrient_Code.value = "";
							 document.NutrientsAdd.content_Value.value = "";
						}
						else{
							alert('Record already exists');
						}
						document.NutrientsAdd.forUpdate.value = 'no';
						return true;
					}
					
				}
			}
			
			document.NutrientsAdd.forUpdate.value = 'no';
			var newRow = parent.NutrientsPopulate.document.all("listContentTable").insertRow();
			 var newCell = newRow.insertCell();
			 rowCount = parent.NutrientsPopulate.document.getElementById("listContentTable").rows.length;
			 var fncal = "javascript:callfn12("+rowCount+");"
			 //newCell.innerHTML = "<a href='javascript:callfn12("+nursingUnit+");'>"+nursingUnit+"</a>";
			 newCell.innerHTML = "<a href='"+fncal+"'>"+nutrient+"</a>";   
			 
			 newCell = newRow.insertCell();
			 newCell.innerHTML = contentValue;
			
			var input = document.createElement("input");
			input.setAttribute("type", "hidden");
			var iCnt = rowCount-2;
			input.setAttribute("name", "nutMode"+iCnt);
			input.setAttribute("value", parent.NutrientsPopulate.document.getElementById("valueForNutCode").value+"::I");
			parent.NutrientsPopulate.document.getElementById("nutrients_form").appendChild(input);
			parent.NutrientsPopulate.document.getElementById("valueForNutCode").value = '';
			 document.NutrientsAdd.nutrient_Code.value = "";
			 document.NutrientsAdd.content_Value.value = "";
		}
		
		
	}
	
	function callfn12(obj){
		obj = obj-1;
		
		

					var cell1 = document.getElementById("listContentTable").rows[obj].cells[0].innerText;
					var cell2 = document.getElementById("listContentTable").rows[obj].cells[1].innerText;

		parent.NutrientsAdd.document.getElementById("nutrient_Code").value = cell1;
		parent.NutrientsAdd.document.getElementById("content_Value").value = cell2;
		parent.NutrientsAdd.document.getElementById("forUpdate").value = 'yes';
	}
	
	function cancelRecord(){
		document.NutrientsAdd.forUpdate.value = 'no';
		var nutrient = document.NutrientsAdd.nutrient_Code.value;
		var contentValue = document.NutrientsAdd.content_Value.value;


		var totRows = parent.NutrientsPopulate.document.getElementById("totalRows").value;
		var rowCount = parent.NutrientsPopulate.document.all("listContentTable").rows.length-1;
		if(rowCount>0){
			for(i=1;i<=rowCount;i++){
				var hdnI = i-1;
				selectedText = parent.NutrientsPopulate.document.all("listContentTable").rows[i].cells[0].innerText;
				if(selectedText == nutrient){
					if(i<=totRows){
						parent.NutrientsPopulate.document.getElementById("listContentTable").rows[i].cells[0].innerText = selectedText;
						parent.NutrientsPopulate.document.getElementById("listContentTable").rows[i].cells[0].style.color = '#FF0000';
						parent.NutrientsPopulate.document.getElementById("listContentTable").rows[i].cells[1].style.color = '#FF0000';
						var hdntxt = "nutMode"+hdnI;
						var val = parent.NutrientsPopulate.document.getElementById(hdntxt).value;
						var valArr = val.split("::");
						val = valArr[0]+"::D";
						parent.NutrientsPopulate.document.getElementById(hdntxt).value=val;
					}
					else{
						parent.NutrientsPopulate.document.all("listContentTable").deleteRow(i);
						var rowCnt = parent.NutrientsPopulate.document.all("listContentTable").rows.length;
						if(rowCnt>1){
							var l = i+1;
							for(j=l;j<=rowCnt;j++){
								var k = j-1;
								nutrient = parent.NutrientsPopulate.document.all("listContentTable").rows[k].cells[0].innerText;
								parent.NutrientsPopulate.document.all("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+nutrient+"</a>";
							}
						}
					}

					document.NutrientsAdd.nutrient_Code.value = "";
					 document.NutrientsAdd.content_Value.value = "";
					return true;
				}
				document.NutrientsAdd.nutrient_Code.value = "";
				 document.NutrientsAdd.content_Value.value = "";
			}
		}
		document.NutrientsAdd.nutrient_Code.value = "";
		 document.NutrientsAdd.content_Value.value = "";
	}
	
	//IN:39847
	function getLookuponblur(obj){
		var tmpValue = localTrimString(obj.value);
		if(tmpValue != "")
			getLookup(obj);
	}
	
	async function getLookup(obj){
		var locale = document.forms[0].locale.value;
		var result		=	false ;
		var message		=	"" ;
		var flag		=	"" ;
		var function_id = "";
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();

		var sql= "select A.nutrients_code code,A.short_desc description from ds_nutrients A where A.eff_status = 'E' and upper(A.SHORT_DESC) like upper(?) and upper(A.nutrients_code) like upper(?) order by 2";
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		returnedValues = await toOpenShowModal(getLabel("eOT.Nutrient.Label","ot"), argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
			var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
			document.NutrientsAdd.nutrient_Code.value = arr[1];
			parent.NutrientsPopulate.document.getElementById("valueForNutCode").value = arr[0];
			//console.log("document.NutrientsAdd.nutrient_Code.value");
			//console.log(document.NutrientsAdd.nutrient_Code.value);
			//const parentDoc = parent.document;
//const valueForNutCodeInput = parentDoc.querySelector("#valueForNutCode");
/*
if (valueForNutCodeInput) {
    valueForNutCodeInput.value = arr[0];
}*/


			//console.log("valueForNutCodeInput");
			//console.log(valueForNutCodeInput.value);
			//parent.NutrientsPopulate.document.getElementById("valueForNutCode").value = arr[0];
			//document.querySelector("[name='NutrientsAdd.nutrient_Code']").value = arr[1];
			//parent.document.querySelector("#valueForNutCode").value = arr[0];
		}
	else
		{
		document.NutrientsAdd.nutrient_Code.value = '';
		} 


	}
	
	
	async function toOpenShowModal(title, pArgumentArray) {

	    var retVal = new String();
	    /*
	    var dialogHeight= "30" ;
	    var dialogWidth = "50" ;
	    */
	    
	    var dialogTop   = "10px";
	    var dialogHeight= "450px" ;
	    var dialogWidth = "700px" ;
	    
	    var status = "no";
		//var fin_Val=pArgumentArray.split(",");
	    var xmlDoc = "" ;
	    var xmlHttp = new XMLHttpRequest() ;

		firstCodeVal = "" ;
		firstDescVal = "" ;

	    xmlStr ="<root><SEARCH " ;
	    xmlStr +=" /></root>" ;
	    
	    // added for PE on 26th April 2010
	    
	    if (pArgumentArray[5] != "")
	    {
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "GET", "../../eCommon/jsp/CommonLookupResult.jsp?callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			responseText = trimString(responseText);
			eval(responseText) ;
		}
	    if(firstCodeVal == "")
	    {

			var dialogUrl       = "../../eCommon/jsp/CommonLookup.jsp?title="+title;
			
			pArgumentArray[9] = title;

			var dialogArguments = pArgumentArray ;
	        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	        
	        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	        
			//var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
	        
	        var returnVal = "";  
	        
	        returnVal =   await parent.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
	        
	        if( returnVal == null || returnVal == "" )
	            return "";
	        else
	            return returnVal.split("\"") ;
			
	     }
		 
	     else
	     {
	         if(pArgumentArray[7] == CODE_DESC )
	         {
	            var temp = firstCodeVal
	            firstCodeVal = firstDescVal
	            firstDescVal = temp
	         }
			 
	          returnVal = firstCodeVal + "\"" + firstDescVal

	         return returnVal.split("\"") ;
	     }
	}
