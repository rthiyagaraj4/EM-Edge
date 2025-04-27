	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/MenuAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.MenuModify.document.forms[0];
		
		var fields = new Array (frm.menu_Code,frm.long_Desc,frm.short_Desc,frm.diet_Type,frm.meal_Type,frm.meal_Class,frm.eff_FromDate);
		var menuCode=getLabel("eOT.Menu.Label","ot");
		var longDesc=getLabel("eOT.LongDescription.Label","ot");
		var shortDesc=getLabel("eOT.ShortDescription.Label","ot");
		var dietType=getLabel("eOT.DietType.Label","ot");
		var mealType=getLabel("eOT.MealType.Label","ot");
		var mealClass=getLabel("eOT.MealClass.Label","ot");
		var effFrom=getLabel("eOT.EffectiveFromDate.Label","ot");
		//var effTo=getLabel("eOT.EffectiveToDate.Label","ot");
		//var enable=getLabel("eOT.Enabled.Label","ot");
	
		var names = new Array (menuCode,longDesc,shortDesc,dietType,mealType,mealClass,effFrom);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				var ingrArr = new Array();
				var tbl = f_query_add_mod.MenuItemPopulate.document.getElementById("listContentTable");
				var totRows = f_query_add_mod.MenuItemPopulate.document.getElementById("totalRows").value;
				var rowCount = tbl.rows.length;
				
				var tbl_dummy = frm.querySelector("#dummyTable");
				var newRow = tbl_dummy.insertRow(0);
				
				for(j=2;j<=rowCount;j++){
					var k = j-1;
					var arrI = j-2;
					var ch = f_query_add_mod.MenuItemPopulate.document.forms[0].querySelector("#itemTypeCode"+k).value;//Added Against PMG2017-COMN-CRF-0012.1-US003
					ingrArr[arrI]=tbl.rows[k].cells[0].innerText+":::"+ch+":::"+tbl.rows[k].cells[2].innerText+":::"+tbl.rows[k].cells[3].innerText;//Modified Against PMG2017-COMN-CRF-0012.1-US003
				}
				for(var i=0;i<ingrArr.length;i++){
					/*var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "nutRow"+i);
					input.setAttribute("value", ingrArr[i]);*/
					var newCell = newRow.insertCell(0);
					var input="<input type='hidden' name='nutRow"+i+"' id='nutRow"+i+"' value='"+ingrArr[i]+"'>";
					newCell.innerHTML=input;
					
					var input1 = document.createElement("input");
					input1.setAttribute("type", "hidden");
					input1.setAttribute("name", "Hid_itemCode"+i);
					input1.setAttribute("value", f_query_add_mod.MenuItemPopulate.document.forms[0].querySelector("#itemCode"+(i+1)).value);
					
					var newCell1 = newRow.insertCell(0);
					var input1="<input type='hidden' name='Hid_itemCode"+i+"' id='Hid_itemCode"+i+"' value='"+f_query_add_mod.MenuItemPopulate.document.forms[0].querySelector("#itemCode"+(i+1)).value+"'>";
					newCell1.innerHTML=input1;					
				}
				for(var j=0;j<totRows;j++){
					var mip = f_query_add_mod.MenuItemPopulate;
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "nutMode"+j);
					input.setAttribute("value", mip.document.getElementById("nutMode"+j).value);
//					newCell.appendChild(input);
					
					var newCell2 = newRow.insertCell(0);
					var input_Hid="<input type='hidden' name='nutMode"+j+"' id='nutMode"+j+"' value='"+mip.document.getElementById("nutMode"+j).value+"'>";
					newCell2.innerHTML=input_Hid;					
					
					
				}
				frm.action = '../../servlet/eDS.MenuServlet?totalRow='+i;
				frm.submit();
				
				//f_query_add_mod.document.forms[0].submit();
			}
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/MenuQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MenuAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("MenuMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MenuQueryCriteria.jsp") != -1)
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
	
	function checkForSpecCharsforID(event)
	{
	    var strCheck = '0123456789/';
	    var whichCode = (window.Event) ? event.which : event.keyCode;
	    key = String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
	
	function isValidDate(obj){
		if(obj.value!=""){
			var flag=true;
			var RE_NUM =  /^\/?\d+$/;
			var str_date = obj.value;
			var arr_date = str_date.split('/');
			if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
		
			if(arr_date[0]!=null)
			{
			if (arr_date[0].length !=2 ) flag=false;
			}
			if(arr_date[1]!=null)
			{
			if (arr_date[1].length !=2 ) flag=false;
			}
			if(arr_date[2]!=null)
			{
			if (arr_date[2].length !=4 ) flag=false;
			}
			if (!arr_date[0]) flag=false;
			if (!RE_NUM.exec(arr_date[0])) flag=false;
			if (!arr_date[1]) flag=false;
			if (!RE_NUM.exec(arr_date[1])) flag=false;
			if (!arr_date[2]) flag=false;
			if (arr_date[2].length!=4) flag=false;
			var dt_date = new Date();
			dt_date.setDate(1);
			if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
			dt_date.setMonth(arr_date[1]-1);
			var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
			dt_date.setDate(arr_date[0]);
			if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

			if (flag==false){
				return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
			}
		}

		return true;
	}
	
	function cal_error (str_message,obj) {
		alert (str_message);
		obj.focus();
		obj.select();
		return null;
	}
	
	function onSuccess()
	{
		var formObj = document.forms[0];
		var params = formObj.params.value;
		if(f_query_add_mod.MenuModify.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href="../../eDS/jsp/MenuAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

	}
	//Added Against PMG2017-COMN-CRF-0012.1-US003 Starts Here
	function changeItemType()
	{
		document.menuItemAdd_form.forUpdate.value = "";
		var ItemType_chk  = document.menuItemAdd_form.forUpdate.value; 
		if(ItemType_chk == ""){
			document.getElementById("valueForItmtypCode").value = document.menuItemAdd_form.item_Type.value;
		}		
	}
	//Added Against PMG2017-COMN-CRF-0012.1-US003 Ends Here
	
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
		var itemType = document.getElementById("item_Type").value;
		var sql= "select A.food_item_code code,A.short_desc description from ds_items A where A.eff_status = 'E' and A.item_type = '"+itemType+"' and A.language_id = '"+locale+"' and upper(A.SHORT_DESC) like upper(?) and upper(A.food_item_code) like upper(?) order by 2";
		//var sql="SELECT A.SHORT_DESC DESCRIPTION,A.order_catalog_code CODE FROM OR_ORDER_CATALOG_LANG_VW A  WHERE A.order_category = 'DS' and A.LANGUAGE_ID='"+locale+"' and  A.contr_mod_id is  null and A.contr_msr_panel_id is null and upper(A.SHORT_DESC) like upper(?) and upper(A.order_catalog_code) like upper(?) order by 2";
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		returnedValues = await CommonLookup(getLabel("eOT.ItemDtls.Label","ot"), argumentArray );
		if((returnedValues != null) && (returnedValues != "") && (returnedValues != undefined))  {
			if(returnedValues.length === 1){
				returnedValues = returnedValues[0].split(',') ;
			}
			document.getElementById("item_Name").value = returnedValues[1];
			document.getElementById("valueForNutCode").value = returnedValues[0];
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var param="func_mode=getUomCode&item_code="+returnedValues[0]+"&item_type="+itemType;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
			xmlHttp.send(xmlDoc);
			var retVal = await localTrimString(xmlHttp.responseText);	
			if(retVal !== undefined && retVal !== null)
				document.getElementById("units").value= '('+retVal+')';
			//var uomQty = retVal.split("::");
			//document.getElementById("prep_Uom").value = uomQty[0];
			//document.getElementById("base_Qty").value = uomQty[1];
		//document.forms[0].SPECIALITY_CODE.value = localTrimString(returnedValues[0]);	
		}
	else
		{
		//document.forms[0].SPECIALITY_CODE.value ='';		
		//document.getElementById("prep_Uom").value = '';
		//document.getElementById("base_Qty").value = '';
			//obj.value = returnedValues[1];
		} 


	}
	
	/*function showNutrientsList(obj){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=recNutList&fooditem_code="+obj.value;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);	
		alert('retVal->'+retVal);
		if(retVal!=null){
			var indItems = retVal.split("???");
			var kitchenItems = "";
			var rowCount = document.getElementById("listContentTable").rows.length;
			if(rowCount>1){
				for (var i=rowCount;i>=2;i--){
					document.all("listContentTable").deleteRow(i-1);
				}
			}
			for(var i=0; i<indItems.length; i++){
				var newRow = document.all("listContentTable").insertRow();
				kitchenItems = indItems[i].split(":::");
				var cnt = i+2;
				for(var j=0;j<kitchenItems.length;j++){
					var newCell = newRow.insertCell();
					if(j==0){
						var arg = cnt;
						newCell.innerHTML = "<a href='javascript:callfn12("+cnt+");'>"+ kitchenItems[j]+"</a>";					
					}
					else if((j==1)||(j==2)){
						newCell.innerText = kitchenItems[j];
					}
					else if(j==3){
						if(kitchenItems[j] == 'E'){
							newCell.innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
						}
						else{
							newCell.innerHTML = "<img src='../../eCommon/images/RRnwd.gif'></img>";
						}
						var input = document.createElement("input");
						input.setAttribute("type", "hidden");
						input.setAttribute("name", "nutMode"+i);
						input.setAttribute("value", "U");
						document.getElementById("recipe_form").appendChild(input);
						//alert('hidden inserted');
						//alert(parent.CommercialNutrientsPopulate.comNutrients_form.nutMode0.value);
					}
					//document.getElementById("listContentTable").rows[i].cells[j].innerText = kitchenItems[j];
				}
			}
		}
		
	}*/
	
	function localTrimString(sInString) {
		  return sInString.replace(/^\s+|\s+$/g,"");
		}
	
	function checkNumberSrl(obj) {
	    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
	        return true;
	    }
	    else {
	        if ( obj.value.length > 0 ) {

	            alert(getMessage("NUM_ALLOWED", "SM"));
	            document.getElementById("item_Srl").value = "";
	            return false;
	        }
	    }
	}
	
	function checkNumberQty(obj) {
	    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
	        return true;
	    }
	    else {
	        if ( obj.value.length > 0 ) {

	            alert(getMessage("NUM_ALLOWED", "SM"));
	            document.getElementById("item_Qty").value = "";
	            return false;
	        }
	    }
	}
	
	function selectRecord1() {
		
		document.getElementById("item_Srl").disabled = false;
		document.getElementById("item_Type").disabled = false;
		document.getElementById("item_Name").disabled = false;
		document.getElementById("click").disabled = false;
		var fields = new Array (document.forms[0].item_Srl,document.forms[0].item_Type,document.forms[0].item_Name,document.forms[0].item_Qty);
		var itemSrlLbl=getLabel("eOT.ItemSrl.Label","ot");
		var itmTypeLbl=getLabel("eOT.ItemType.Label","ot");
		var itemLbl=getLabel("eOT.Item.Label","ot");
		var itemQtyLbl = getLabel("eOT.ItemQty.Label","ot");
		
		var names = new Array ( itemSrlLbl,itmTypeLbl,itemLbl,itemQtyLbl);
		if(checkFieldsofMst( fields, names, parent.parent.messageFrame)) 
		{	
			var tbl = parent.MenuItemPopulate.document.getElementById("listContentTable");
			var rowCount = 0;
			rowCount = tbl.rows.length;
			var itemSrl = document.menuItemAdd_form.item_Srl.value;
			var itemType = document.menuItemAdd_form.item_Type.value;
			var itemName = document.menuItemAdd_form.item_Name.value;
			var itemQty = document.menuItemAdd_form.item_Qty.value;
			var itemCode=document.getElementById("valueForNutCode").value;
			//Added Against PMG2017-COMN-CRF-0012.1-US003 Starts Here
			var itemTypeCode=document.getElementById("valueForItmtypCode").value;
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var param="func_mode=getItemTypeDesc&item_type="+itemType;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
			xmlHttp.send(xmlDoc);
			var retVal = localTrimString(xmlHttp.responseText);
			var itemTypedesc = retVal;			
			//Added Against PMG2017-COMN-CRF-0012.1-US003 Ends Here
			if(rowCount>1){
				for(j=2;j<=rowCount;j++){
					var k = j-1;
					var selectedText = tbl.rows[k].cells[2].innerText;
					var selectedItemTypeText = tbl.rows[k].cells[1].innerText;//Added Against PMG2017-COMN-CRF-0012.1-US003
					var selecteditemSrl = tbl.rows[k].cells[0].innerText;
					
					if(trimString(itemSrl) == trimString(selecteditemSrl)) {
						if(document.menuItemAdd_form.forUpdate.value != 'yes') {
							alert("Duplicate Item Srl Number");
							return;
						}
					}
					
					if(trimString(itemName) == trimString(selectedText)){
						if(document.menuItemAdd_form.forUpdate.value == 'yes'){
							tbl.rows[k].cells[0].innerText = itemSrl;
							//tbl.rows[k].cells[1].innerText = itemType; //Commented Against PMG2017-COMN-CRF-0012.1-US003
							tbl.rows[k].cells[1].innerHTML = selectedItemTypeText+"<input type='hidden' name='itemTypeCode"+k+"' id='itemTypeCode"+k+"' value='"+itemTypeCode+"'>";//Added Against PMG2017-COMN-CRF-0012.1-US003
							tbl.rows[k].cells[2].innerHTML = "<a href='javascript:callfn12("+j+");'>"+itemName+"</a>"+"<input type='hidden' name='itemCode"+k+"' id='itemCode"+k+"' value='"+itemCode+"'>";
							tbl.rows[k].cells[3].innerText = itemQty;
							
							 document.menuItemAdd_form.item_Srl.value = "";
							 document.menuItemAdd_form.item_Type.value = "";
							 document.menuItemAdd_form.item_Name.value = "";
							 document.menuItemAdd_form.item_Qty.value = "";
						}
						else{
							alert('Record already exists');
						}
						document.menuItemAdd_form.forUpdate.value = 'no';
						return true;
					}
					
				}
			}
			
			document.menuItemAdd_form.forUpdate.value = 'no';
			var newRow = tbl.insertRow();
			var newCell = newRow.insertCell();
			rowCount = tbl.rows.length;
			 newCell.innerHTML = itemSrl;
			 newCell = newRow.insertCell();
			 //newCell.innerHTML = itemType;// commented Against PMG2017-COMN-CRF-0012.1-US003
			 newCell.innerHTML = itemTypedesc+"<input type='hidden' name='itemTypeCode"+(rowCount-1)+"' id='itemTypeCode"+(rowCount-1)+"' value='"+itemTypeCode+"'>"; //Added Against PMG2017-COMN-CRF-0012.1-US003
			 newCell = newRow.insertCell();
			 //rowCount = tbl.rows.length;//Commented Against PMG2017-COMN-CRF-0012.1-US003
			 var fncal = "javascript:callfn12("+rowCount+");"			 
			 newCell.innerHTML = "<a href='"+fncal+"'>"+itemName+"</a>"+"<input type='hidden' name='itemCode"+(rowCount-1)+"' id='itemCode"+(rowCount-1)+"' value='"+itemCode+"'>"; 
			 newCell = newRow.insertCell();
			 newCell.innerHTML = itemQty;
			    
			/*var input = document.createElement("input");
			input.setAttribute("type", "hidden");*/
			var iCnt = rowCount-2;
			/*input.setAttribute("name", "nutMode"+iCnt);
			input.setAttribute("value", "I");
			parent.MenuModify.document.getElementById("menu_form").appendChild(input);*/
			
			var frm=parent.MenuModify.document.forms[0];
			var tbl_dummy = frm.querySelector("#dummyTable");
			var newRow = tbl_dummy.insertRow(0);
			var newCell = newRow.insertCell(0);
			
			var input_Hid="<input type='hidden' name='nutMode"+iCnt+"' id='nutMode"+iCnt+"' value='I'>";
			newCell.innerHTML=input_Hid;					
			

			document.menuItemAdd_form.item_Srl.value = "";
			 document.menuItemAdd_form.item_Type.value = "";
			 document.menuItemAdd_form.item_Name.value = "";
			 document.menuItemAdd_form.item_Qty.value = "";
		}
		
		
	}
	
	function callfn12(obj){
		obj = obj-1;
		var tbl = parent.MenuItemPopulate.document.getElementById("listContentTable");
		var cell1 = tbl.rows[obj].cells[0].innerText;
		var cell2 = tbl.rows[obj].cells[1].innerText;
		var cell3 = tbl.rows[obj].cells[2].innerText;
		var cell4 = tbl.rows[obj].cells[3].innerText;
		parent.MenuItemAdd.document.getElementById("valueForNutCode").value=document.getElementById("itemCode"+obj).value;
		parent.MenuItemAdd.document.getElementById("valueForItmtypCode").value=document.getElementById("itemTypeCode"+obj).value; // Added Against PMG2017-COMN-CRF-0012.1-US003
	
		cell2 = document.getElementById("itemTypeCode"+obj).value; // Added Against PMG2017-COMN-CRF-0012.1-US003
		parent.MenuItemAdd.document.getElementById("item_Srl").value = cell1;
		parent.MenuItemAdd.document.getElementById("item_Type").value = cell2;
		parent.MenuItemAdd.document.getElementById("item_Name").value = cell3;
		parent.MenuItemAdd.document.getElementById("item_Qty").value = cell4;
		parent.MenuItemAdd.document.getElementById("forUpdate").value = 'yes';
		
		parent.MenuItemAdd.document.getElementById("item_Srl").disabled = true;
		parent.MenuItemAdd.document.getElementById("item_Type").disabled = true;
		parent.MenuItemAdd.document.getElementById("item_Name").disabled = true;
		parent.MenuItemAdd.document.getElementById("click").disabled = true;
	}
	
	function cancelRecord(){
		document.menuItemAdd_form.forUpdate.value == 'no';
		document.getElementById("item_Srl").disabled = false;
		document.getElementById("item_Type").disabled = false;
		document.getElementById("item_Name").disabled = false;
		document.getElementById("click").disabled = false;
		
		var itemSrl = document.menuItemAdd_form.item_Srl.value;
		var itemName = "";
		var tbl = parent.MenuItemPopulate.document.getElementById("listContentTable");
		var totRows = parent.MenuItemPopulate.document.getElementById("totalRows").value;
		var rowCount = tbl.rows.length-1;
		if(rowCount>0){
			for(i=1;i<=rowCount;i++){
				var hdnI = i-1;
				selectedText = tbl.rows[i].cells[0].innerText;
				if(selectedText == itemSrl){
					if(i<=totRows){
						tbl.rows[i].cells[0].innerText = selectedText;
						//tbl.rows[i].cells[2].innerText = tbl.rows[i].cells[2].innerText; // IN:39956
						tbl.rows[i].cells[0].style.color = '#FF0000';
						tbl.rows[i].cells[1].style.color = '#FF0000';
						tbl.rows[i].cells[2].style.color = '#FF0000';
						tbl.rows[i].cells[3].style.color = '#FF0000';
						var hdntxt = "nutMode"+hdnI;
						parent.MenuItemPopulate.document.getElementById(hdntxt).value='D';
					}
					else{
						tbl.deleteRow(i);
						var rowCnt = tbl.rows.length;
						if(rowCnt>1){
							var l = i+1;
							for(j=l;j<=rowCnt;j++){
								var k = j-1;
								itemName = tbl.rows[k].cells[2].innerText;
								tbl.rows[k].cells[2].innerHTML = "<a href='javascript:callfn12("+j+");'>"+itemName+"</a>";
							}
						}
					}
					document.menuItemAdd_form.item_Srl.value = "";
					 document.menuItemAdd_form.item_Type.value = "";
					 document.menuItemAdd_form.item_Name.value = "";
					 document.menuItemAdd_form.item_Qty.value = "";
					return true;
				}
				document.menuItemAdd_form.item_Srl.value = "";
				 document.menuItemAdd_form.item_Type.value = "";
				 document.menuItemAdd_form.item_Name.value = "";
				 document.menuItemAdd_form.item_Qty.value = "";
			}
		}
		document.menuItemAdd_form.item_Srl.value = "";
		 document.menuItemAdd_form.item_Type.value = "";
		 document.menuItemAdd_form.item_Name.value = "";
		 document.menuItemAdd_form.item_Qty.value = "";
}
//Added Against Start ML-MMOH-CRF-1006-US5
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
	var selectStart = "<select id= 'meal_Type' name='meal_Type' id='meal_Type'>";
	selectStart = selectStart+listItems;
	selObj = selectStart +selObj;
	var selectEnd = "</select><img src='../../eCommon/images/mandatory.gif'></img>";
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
	var selectStart = "<select id='diet_Type' name='diet_Type' id='diet_Type'>";
	selectStart = selectStart+listItems;
	selObj = selectStart +selObj;
	var selectEnd = "</select><img src='../../eCommon/images/mandatory.gif'></img>";
	selObj= selObj + selectEnd;
	document.getElementById("dietTypeTD").innerHTML = selObj;
}
//Added Against End ML-MMOH-CRF-1006-US5

