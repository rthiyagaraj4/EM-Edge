	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/MenuTimeTableAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		
		var fields = new Array (f_query_add_mod.document.forms[0].diet_Type,f_query_add_mod.document.forms[0].meal_Class,f_query_add_mod.document.forms[0].kitchen_Code,f_query_add_mod.document.forms[0].meal_Type,f_query_add_mod.document.forms[0].day_No,f_query_add_mod.document.forms[0].menu_Item);
		var dietType=getLabel("eOT.DietType.Label","ot");
		var mealClass=getLabel("eOT.MealClass.Label","ot");
		var kitchenCode=getLabel("eOT.Kitchen.Label","ot");
		var mealType = getLabel("eOT.MealType.Label","ot");
		var dayNo = getLabel("eOT.DayNo.Label","ot");
		var menuType = getLabel("eOT.Menu.Label","ot");
		var names = new Array ( dietType,mealClass,kitchenCode,mealType,dayNo,menuType);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/MenuTimeTableQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MenuTimeTableAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("MenuTimeTableMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MenuTimeTableQueryCriteria.jsp") != -1)
		 {
			 f_query_add_mod.document.forms[0].reset();
		 }
	}
		
	function setFieldToUpperCase(obj) {
		obj.value = obj.value.toUpperCase();
		return obj;
	}
	
	function checkAlpha(event){
		var strCheck = '~!@#$%^&*()+=`{}|[]<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) return false;  
		return true ;
	}
	
	
	function onSuccess()
	{
		var formObj = document.forms[0];
		var params = formObj.params.value;
		if(f_query_add_mod.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href="../../eDS/jsp/MenuTimeTableAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

	}
	
async	function loadDayNo(strMenuKey){
		if(strMenuKey == null || strMenuKey == undefined)
		strMenuKey = 'mealclass';
		var dietType = document.getElementById("diet_Type").value;
		var mealClass = document.getElementById("meal_Class").value;
		var mealType = document.getElementById("meal_Type").value;
		var retVal = "";
		if(dietType!='' && mealClass!=''){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var param="func_mode=loadDayNo&dietType="+dietType+"&mealClass="+mealClass+"&mealType="+mealType+"&strMenuKey="+strMenuKey;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
			xmlHttp.send(xmlDoc);
			retVal = await localTrimString(xmlHttp.responseText);	
      retVal = retVal.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
      
			//IN::39898 - start - To set the Menu list for the given diettype, mealclass and mealtype on change of the same 
				var allItems = retVal.split("%%%");
				var fullmenuItems = allItems[1].split("???");
				
				var selMenuItems = document.getElementById("menu_Item");
				while(selMenuItems.options.length>0){
					selMenuItems.remove(0);
				}
				var op = document.createElement("option");
				op.value = "";
				op.text = "----select----";
				selMenuItems.add(op);
				for(var i=0; i<fullmenuItems.length; i++){
					menuitems = fullmenuItems[i].split(":::");
					if(menuitems!=null && menuitems!="")
					{
						var opt = document.createElement("option");
						opt.value = menuitems[0];
						opt.text = menuitems[1];
						selMenuItems.add(opt);
					}
				}
					
			//IN::39898 - end
			if(strMenuKey != 'menulist')	//To set DayNo list
			{
				if(allItems[0]!=''){		
					//var indItems = retVal.split("???");
					var indItems = allItems[0].split("???");
					var kitchenItems = "";
					var sel = document.getElementById("day_No");
					while(sel.options.length>0){
						sel.remove(0);
					}
					var op = document.createElement("option");
					op.value = "";
					op.text = "----select----";
					sel.add(op);
					for(var i=0; i<indItems.length; i++){
						kitchenItems = indItems[i].split(":::");
					}
						for(var counter=1;counter <=kitchenItems[0];counter++) {
							var opt = document.createElement("option");
							opt.value = counter;
							opt.text = counter;
							sel.add(opt);
						}
				}
				else{
					alert('Combination Not Available');
					var sel = document.getElementById("day_No");
					while(sel.options.length>0){
						sel.remove(0);
					}
					var op = document.createElement("option");
					op.value = "";
					op.text = "----select----";
					sel.add(op);
				}
			}
		}
	}
	
//Added Against Start ML-MMOH-CRF-1006-US6
function changeMealType(){
	 var patient_class=document.getElementById("Patient_Class").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var params = "func_mode=getMealTypeForCat&patient_class="+patient_class;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("???");
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	var selObj = "";
	for(var i=0; i < retVal_arr.length; i++){
		var dum = retVal_arr[i].split(":::");
		var meal_type_code= dum[0];
		var meal_type_desc= dum[1];
		if(meal_type_desc!=undefined)
		selObj += "<OPTION value='" + meal_type_code + "'>" + meal_type_desc + "</OPTION>";
	}
	var selectStart = "<select id= 'meal_Type' name='meal_Type' id='meal_Type' onchange='loadDayNo()'>";
	selectStart = selectStart+listItems;
	selObj = selectStart +selObj;
	var selectEnd = "</select>";
	selObj= selObj + selectEnd;
	document.getElementById("MealTypeTD").innerHTML = selObj; 
}

function changeDietType(){
	 var patient_class=document.getElementById("Patient_Class").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var params = "func_mode=getDietTypeValues&patient_class="+patient_class;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("???");
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	var selObj = "";
	for(var i=0; i < retVal_arr.length; i++){
		var dum = retVal_arr[i].split(":::");
		var diet_type_code= dum[0];
		var diet_type_desc= dum[1];
		if(diet_type_desc!=undefined)
		selObj += "<OPTION value='" + diet_type_code + "'>" + diet_type_desc + "</OPTION>";
	}
	var selectStart = "<select id='diet_Type' name='diet_Type' id='diet_Type' onchange='loadDayNo()'>";
	selectStart = selectStart+listItems;
	selObj = selectStart +selObj;
	var selectEnd = "</select>";
	selObj= selObj + selectEnd;
	document.getElementById("dietTypeTD").innerHTML = selObj; 
}
//Added Against End ML-MMOH-CRF-1006-US6
	
function localTrimString(sInString) {
		  return sInString.replace(/^\s+|\s+$/g,"");
		}

