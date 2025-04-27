function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/RecipeAddModify.jsp?"+params+"&mode=insert";
	}
	
function apply() {
		var frm=f_query_add_mod.document.forms[0];		
		var fields = new Array (f_query_add_mod.document.forms[0].foodItemDesc);
		var foodItem=getLabel("eOT.FoodItem.Label","ot");		
		var names = new Array (foodItem);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				var ingrArr = new Array();
				var tbl = f_query_add_mod.document.getElementById("listContentTable");
				var foodItemCode = f_query_add_mod.document.getElementById("valueForNutCode").value;
				var rowCount = tbl.rows.length;
				for(j=2;j<=rowCount;j++){
					var k = j-1;
					var arrI = j-2;
					//Added Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
					var ingredient_value = f_query_add_mod.document.forms[0].querySelector("#ingredientCode"+k).value;
					var uom_value = f_query_add_mod.document.forms[0].querySelector("#uomCode"+k).value;
					//Added Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
					//ingrArr[arrI]=tbl.rows[k].cells[0].innerText+":::"+tbl.rows[k].cells[1].innerText+":::"+tbl.rows[k].cells[2].innerText+":::"+tbl.rows[k].cells[3].innerHTML; //Commented Against PMG2017-COMN-CRF-0012.1-US004
					
					ingrArr[arrI]=ingredient_value+":::"+tbl.rows[k].cells[1].innerText+":::"+uom_value+":::"+tbl.rows[k].cells[3].innerHTML; //Added Against PMG2017-COMN-CRF-0012.1-US004
				}
				for(var i=0;i<ingrArr.length;i++){
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "nutRow"+i);
					input.setAttribute("value", ingrArr[i]);
					f_query_add_mod.document.getElementById("recipe_form").appendChild(input);
				}
				frm = f_query_add_mod.document.forms[0];
				frm.action = '../../servlet/eDS.RecipeServlet?totalRow='+i+'&NutrientsValue='+ingrArr+'&foodItmCode='+foodItemCode;
				frm.submit();
			}
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/RecipeQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("RecipeAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("RecipeMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("RecipeQueryCriteria.jsp") != -1)
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
			f_query_add_mod.location.href="../../eDS/jsp/RecipeAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

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

		var sql= "select A.food_item_code code,A.short_desc description from ds_food_item_lang_vw A where A.eff_status = 'E' and A.language_id = '"+locale+"' and upper(A.SHORT_DESC) like upper(?) and upper(A.food_item_code) like upper(?) order by 2";
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		returnedValues = await CommonLookup(getLabel("eOT.FoodItemCode.Label","ot"), argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
			if(returnedValues.length === 1){
				returnedValues = returnedValues[0].split(',') ;
			}
			document.getElementById("foodItemDesc").value = returnedValues[1];
			document.getElementById("valueForNutCode").value = returnedValues[0];
			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var param="func_mode=recUomQty&fooditem_code="+returnedValues[0];
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
			xmlHttp.send(xmlDoc);
			var retVal = await localTrimString(xmlHttp.responseText);	
			var uomQty = retVal.split("::");
			document.getElementById("prep_Uom").value = uomQty[0];
			document.getElementById("base_Qty").value = uomQty[1];
			document.location.href = '../../eDS/jsp/RecipeAddModify.jsp?mode=modify&foodItem='+returnedValues[1]+'&prepUom='+uomQty[0]+'&baseQty='+uomQty[1]+'&fooditem_Code='+returnedValues[0];
		}
	else
		{
		document.getElementById("prep_Uom").value = '';
		document.getElementById("base_Qty").value = '';
		} 
	}
	
	function localTrimString(sInString) {
		  return sInString.replace(/^\s+|\s+$/g,"");
		}
	
	function checkNumber(obj) {
	    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
	        return true;
	    }
	    else {
	        if ( obj.value.length > 0 ) {
	            alert(getMessage("NUM_ALLOWED", "SM"));
	            document.getElementById("qty").value = "";
	            return false;
	        }
	    }
	}
	//Added Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
	function changeIngredient()
	{
		document.recipe_form.forUpdate.value = "";
		var Ingdredient_chk  = document.recipe_form.forUpdate.value;
		if(Ingdredient_chk == ""){
			document.getElementById("valueForIngCode").value = document.recipe_form.ingredient_Code.value;
		}		
	}
	function changeUom()
	{
		document.recipe_form.forUpdate.value = "";
		var Uom_chk  = document.recipe_form.forUpdate.value; 
		if(Uom_chk == ""){
			document.getElementById("valueForUomCode").value = document.recipe_form.uom_Value.value;
		}		
	}	
	//Added Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
	
	function selectRecord1() {
		var fields = new Array (document.forms[0].ingredient_Code,document.forms[0].qty,document.forms[0].uom_Value);
		var ingLabel=getLabel("eOT.Ingredients.Label","ot");
		var qtyLabel=getLabel("eOT.Qty.Label","ot");
		var uomLabel=getLabel("eOT.Uom.Label","ot");
		var names = new Array ( ingLabel,qtyLabel,uomLabel);
		if(checkFieldsofMst( fields, names, parent.messageFrame)) 
		{	
			var rowCount = 0;
			rowCount = document.getElementById("listContentTable").rows.length;
			var ingredients = document.recipe_form.ingredient_Code.value;			
			var qty = document.recipe_form.qty.value;
			var uom = document.recipe_form.uom_Value.value;
			var enabled = "";
			//Added Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
			var ingredientCode = document.getElementById("valueForIngCode").value;
			var uomCode = document.getElementById("valueForUomCode").value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var param="func_mode=getIngDesc&ingredient_code="+ingredients;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
			xmlHttp.send(xmlDoc);
			var retVal = localTrimString(xmlHttp.responseText);
			var ingredientDesc = retVal;
			
			var param1="func_mode=getUomDesc&uom_code="+uom;
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param1,false);
			xmlHttp.send(xmlDoc);
			var retVal1 = localTrimString(xmlHttp.responseText);
			var uomDesc = retVal1;
			//Added Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
			if(document.recipe_form.status.checked){
				enabled = "on";
			}
			else{
				enabled = "off";
			}
			if(rowCount>1){
			  for(j=2;j<=rowCount;j++){
				var k = j-1;
				//Commented Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
				/* var selectedText = document.getElementById("listContentTable").rows[k].cells[0].innerText;
				if(ingredients == selectedText){ */
				//Commented Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
				
				//Added Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
				var selectedText1 = document.recipe_form.querySelector("#ingredientCode"+k).value;
				if(trimString(ingredients) == trimString(selectedText1)){
				//Added Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
				
				if(document.recipe_form.forUpdate.value == 'yes'){
				//document.getElementById("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+ingredients+"</a>"; // Commented Against PMG2017-COMN-CRF-0012.1-US004
				document.getElementById("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+ingredientDesc+"</a>"+"<input type='hidden' name='ingredientCode"+k+"' id='ingredientCode"+k+"' value='"+ingredientCode+"'>";//Added Against PMG2017-COMN-CRF-0012.1-US004
					document.getElementById("listContentTable").rows[k].cells[1].innerText = qty;
					//document.getElementById("listContentTable").rows[k].cells[2].innerText = uom;//Commented Against PMG2017-COMN-CRF-0012.1-US004
					document.getElementById("listContentTable").rows[k].cells[2].innerHTML = uomDesc+"<input type='hidden' name='uomCode"+k+"' id='uomCode"+k+"' value='"+uomCode+"'>";//Added Against PMG2017-COMN-CRF-0012.1-US004
			 if(enabled == "on"){
					document.getElementById("listContentTable").rows[k].cells[3].innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
			 }else{
					document.getElementById("listContentTable").rows[k].cells[3].innerHTML = "<img src='../../eCommon/images/RRnwd.gif'></img>";
				 }
							 document.recipe_form.ingredient_Code.value = "";
							 document.recipe_form.qty.value = "";
							 document.recipe_form.uom_Value.value = "";
						}
						else{
							alert('Record already exists');
						}
						document.recipe_form.forUpdate.value == 'no';
						return true;
					}
					
				}
			}
			
			document.recipe_form.forUpdate.value = 'no';
			var newRow = document.all("listContentTable").insertRow();
			 var newCell = newRow.insertCell();
			 rowCount = document.getElementById("listContentTable").rows.length;
			 var fncal = "javascript:callfn12("+rowCount+");"
			 //newCell.innerHTML = "<a href='"+fncal+"'>"+ingredients+"</a>";//Commented Against PMG2017-COMN-CRF-0012.1-US004  
			 newCell.innerHTML = "<a href='"+fncal+"'>"+ingredientDesc+"</a>"+"<input type='hidden' name='ingredientCode"+(rowCount-1)+"' id='ingredientCode"+(rowCount-1)+"' value='"+ingredientCode+"'>"; //Added Against PMG2017-COMN-CRF-0012.1-US004
			 newCell = newRow.insertCell();
			 newCell.innerHTML = qty;
			 
			 newCell = newRow.insertCell();
			 //newCell.innerHTML = uom; //Commented Against PMG2017-COMN-CRF-0012.1-US004  
			 newCell.innerHTML = uomDesc+"</a>"+"<input type='hidden' name='uomCode"+(rowCount-1)+"' id='uomCode"+(rowCount-1)+"' value='"+uomCode+"'>"; //Added Against PMG2017-COMN-CRF-0012.1-US004
			 newCell = newRow.insertCell();
			 if(enabled == "on"){
				 newCell.innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
			 }else{
				 newCell.innerHTML = "<img src='../../eCommon/images/RRnwd.gif'></img>";
			 }
			
			var input = document.createElement("input");
			input.setAttribute("type", "hidden");
			var iCnt = rowCount-2;
			input.setAttribute("name", "nutMode"+iCnt);
			input.setAttribute("value", "I");
			document.getElementById("recipe_form").appendChild(input);
			 document.recipe_form.ingredient_Code.value = "";
			 document.recipe_form.qty.value = "";
			 document.recipe_form.uom_Value.value = "";
		}		
	}
	
	function callfn12(obj){		
		obj = obj-1;
		var cell1 = document.getElementById("listContentTable").rows[obj].cells[0].innerText;
		var cell2 = document.getElementById("listContentTable").rows[obj].cells[1].innerText;
		var cell3 = document.getElementById("listContentTable").rows[obj].cells[2].innerText;
		var cell4 = document.getElementById("listContentTable").rows[obj].cells[3].innerHTML;
		//Added Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
		parent.parent.frames[2].frames[1].document.forms[0].querySelector("#valueForIngCode").value=document.getElementById("ingredientCode"+obj).value;
		cell1=document.getElementById("ingredientCode"+obj).value;
		parent.parent.frames[2].frames[1].document.forms[0].querySelector("#valueForUomCode").value=document.getElementById("uomCode"+obj).value;
		cell3=document.getElementById("uomCode"+obj).value;
		//Added Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
		document.getElementById("ingredient_Code").value = cell1;	
		document.getElementById("qty").value = cell2;		
		document.getElementById("uom_Value").value = cell3;
		if(cell4.indexOf("enabled")!=-1){
			document.getElementById("status").checked = true;
		}
		else{
			document.getElementById("status").checked = false;
			}
		document.getElementById("forUpdate").value = 'yes';
	}
	
	function cancelRecord(){
		document.recipe_form.forUpdate.value == 'no';
		var ingredients = document.recipe_form.ingredient_Code.value;
		//Added Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
		var ingredientCode = document.getElementById("valueForIngCode").value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=getIngDesc&ingredient_code="+ingredients;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		var ingredientDesc = retVal;
		//Added Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
		var totRows = document.getElementById("totalRows").value;
		var rowCount = document.all("listContentTable").rows.length-1;
		if(rowCount>0){
			for(i=1;i<=rowCount;i++){
				var hdnI = i-1;
				//Commented Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
				/* selectedText = document.all("listContentTable").rows[i].cells[0].innerText;
				if(selectedText == ingredients){ */
				//Commented Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
				
				//Added Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
				selectedText1 = document.recipe_form.querySelector("#ingredientCode"+i).value;
				if(trimString(selectedText1) == trimString(ingredients)){
				//Added Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
				
					if(i<=totRows){
						//document.getElementById("listContentTable").rows[i].cells[0].innerHTML = selectedText; //Commented Against PMG2017-COMN-CRF-0012.1-US004
						document.getElementById("listContentTable").rows[i].cells[0].innerHTML = ingredientDesc+"<input type='hidden' name='ingredientCode"+i+"' id='ingredientCode"+i+"' value='"+ingredientCode+"'>";//Added Against PMG2017-COMN-CRF-0012.1-US004
						document.getElementById("listContentTable").rows[i].cells[0].style.color = '#FF0000';
						document.getElementById("listContentTable").rows[i].cells[1].style.color = '#FF0000';
						document.getElementById("listContentTable").rows[i].cells[2].style.color = '#FF0000';
						document.getElementById("listContentTable").rows[i].cells[3].style.color = '#FF0000';
						var hdntxt = "nutMode"+hdnI;
						document.getElementById(hdntxt).value='D';
					}
					else{
						document.all("listContentTable").deleteRow(i);
						var rowCnt = document.all("listContentTable").rows.length;
						if(rowCnt>1){
							var l = i+1;
							for(j=l;j<=rowCnt;j++){
								var k = j-1;
								ingredients = document.all("listContentTable").rows[k].cells[0].innerText;
								document.all("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+ingredients+"</a>";
							}
						}
					}
					document.recipe_form.ingredient_Code.value = "";
					 document.recipe_form.qty.value = "";
					 document.recipe_form.uom_Value.value = "";
					return true;
				}
				 document.recipe_form.ingredient_Code.value = "";
				 document.recipe_form.qty.value = "";
				 document.recipe_form.uom_Value.value = "";
			}
		}
		 document.recipe_form.ingredient_Code.value = "";
		 document.recipe_form.qty.value = "";
		 document.recipe_form.uom_Value.value = "";	
}

