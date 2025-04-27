	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/CommercialFoodItemAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		var frmName = f_query_add_mod.CommercialFoodItemAdd.document.forms[0].name;
		
		if(frmName=="diet_form"){
			var fields = new Array (f_query_add_mod.CommercialFoodItemAdd.document.forms[0].food_Item,f_query_add_mod.CommercialFoodItemAdd.document.forms[0].long_Desc,f_query_add_mod.CommercialFoodItemAdd.document.forms[0].short_Desc,f_query_add_mod.CommercialFoodItemAdd.document.forms[0].item_Type,f_query_add_mod.CommercialFoodItemAdd.document.forms[0].serving_Uom,f_query_add_mod.CommercialFoodItemAdd.document.forms[0].preparation_Uom,f_query_add_mod.CommercialFoodItemAdd.document.forms[0].base_Qty,f_query_add_mod.CommercialFoodItemAdd.document.forms[0].preparation_Factor,f_query_add_mod.CommercialFoodItemAdd.document.forms[0].calorie_Content);
			var foodItem=getLabel("eOT.CommercialFormula.Label","ot");
			var longDesc=getLabel("eOT.LongDescription.Label","ot");
			var shortDesc=getLabel("eOT.ShortDescription.Label","ot");
			var itemType=getLabel("eOT.ItemType.Label","ot");
			var servingUom=getLabel("eOT.ServingUOM.Label","ot");
			var preparationUom=getLabel("eOT.PreparationUOM.Label","ot");
			var baseQty=getLabel("eOT.PreparationBaseQty.Label","ot");
			var preparationFactor=getLabel("eOT.PreparationFactor.Label","ot");
			var calorieContent=getLabel("eOT.CalorieContentUOM.Label","ot");
			
			var names = new Array ( foodItem,longDesc,shortDesc,itemType,servingUom,preparationUom,baseQty,preparationFactor,calorieContent);
			if(checkFieldsofMst( fields, names, messageFrame)) 
				{	
					f_query_add_mod.CommercialFoodItemAdd.document.forms[0].submit();
				}
		}
		else if(frmName=="CommercialNutrients"){
			var fields = new Array (f_query_add_mod.CommercialFoodItemAdd.CommercialNutrientsPopulate.document.forms[0].commercial_Formula);
			var nutLabel = getLabel("eOT.CommercialFormula.Label","ot");
			var names = new Array (nutLabel);
			if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				var kitchenArr = new Array();
				var tbl = f_query_add_mod.CommercialFoodItemAdd.CommercialNutrientsPopulate.document.getElementById("listContentTable");
				var foodItmCode = f_query_add_mod.CommercialFoodItemAdd.CommercialNutrientsPopulate.document.getElementById("valueForNutCode").value;
				var rowCount = tbl.rows.length;
				for(j=2;j<=rowCount;j++){
					var k = j-1;
					var arrI = j-2;
					kitchenArr[arrI]=tbl.rows[k].cells[0].innerText+":::"+tbl.rows[k].cells[1].innerText+":::"+tbl.rows[k].cells[2].innerText;
				}
				for(var i=0;i<kitchenArr.length;i++){
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "nutRow"+i);
					input.setAttribute("value", kitchenArr[i]);
					f_query_add_mod.CommercialFoodItemAdd.CommercialNutrientsPopulate.document.getElementById("comNutrients_form").appendChild(input);
				}
				frm = f_query_add_mod.CommercialFoodItemAdd.CommercialNutrientsPopulate.document.forms[0];
				frm.action = '../../servlet/eDS.CommercialFoodItemServlet?Nutrients=yes&totalRow='+i+'&NutrientsValue='+kitchenArr+'&foodItmCode='+foodItmCode;
				frm.submit();
			}
			
		}
	}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/CommercialFoodItemQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("CommercialFoodItemAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("CommercialFoodItemMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("CommercialFoodItemQueryCriteria.jsp") != -1)
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
	
	function onSuccess()
	{
		var formObj =document.forms[0];
		var params = formObj.params.value;
		if(f_query_add_mod.CommercialFoodItemAdd.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href="../../eDS/jsp/CommercialFoodItemAddModify.jsp?"+params+"&mode=insert";
		else
			f_query_add_mod.CommercialFoodItemAdd.location.reload();

	}
	
	function getNutrientsUom(obj){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=getUom&nutrients_code="+obj.value;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);	
		if(retVal!=null){
			parent.CommercialNutrientsAdd.document.getElementById("uom_Code").value = retVal;
		}
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

		var sql= "select A.comm_formula_code code,A.short_desc description from ds_comm_formula_lang_vw A where A.eff_status = 'E' and A.language_id = '"+locale+"' and upper(A.SHORT_DESC) like upper(?) and upper(A.comm_formula_code) like upper(?) order by 2";
		//var sql="SELECT A.SHORT_DESC DESCRIPTION,A.order_catalog_code CODE FROM OR_ORDER_CATALOG_LANG_VW A  WHERE A.order_category = 'DS' and A.LANGUAGE_ID='"+locale+"' and  A.contr_mod_id is  null and A.contr_msr_panel_id is null and upper(A.SHORT_DESC) like upper(?) and upper(A.order_catalog_code) like upper(?) order by 2";
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		returnedValues = await CommonLookup(getLabel("Common.speciality.label","Common"), argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
			var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
			document.getElementById("commercial_Formula").value = arr[1];
			document.getElementById("valueForNutCode").value = arr[0];
			document.location.href = '../../eDS/jsp/CommercialNutrientsPopulate.jsp?foodItem='+arr[1]+'&nutCode='+arr[0];
		//document.forms[0].SPECIALITY_CODE.value = localTrimString(returnedValues[0]);	
		}

	}
	function localTrimString(sInString) {
		  //sInString = sInString.replace( /^\s+/g, "" );// strip leading space
		  //return sInString.replace( /\s+$/g, "" );// strip trailing space
		  return sInString.replace(/^\s+|\s+$/g,"");
		}
	
	/*function showNutrientsList(obj){
		//document.location.href='../../eDS/jsp/CommercialNutrientsPopulate.jsp?nutrients_code='+obj.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=comNutList&nutrients_code="+obj.value;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);	
		if(retVal!=null){
			//parent.CommercialNutrientsAdd.document.getElementById("uom_Code").value = retVal;
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
						var arg = cnt+","+'kitchenItems[3]';
						newCell.innerHTML = "<a href='javascript:callfn12("+cnt+");'>"+ kitchenItems[j]+"</a>";					
					}
					else if((j==1)||(j==2)){
						newCell.innerText = kitchenItems[j];
					}
					else if(j==3){
						var input = document.createElement("input");
						input.setAttribute("type", "hidden");
						input.setAttribute("name", "nutMode"+i);
						input.setAttribute("value", kitchenItems[0]+"::"+kitchenItems[j]+"::U");
						parent.CommercialNutrientsPopulate.document.getElementById("comNutrients_form").appendChild(input);
						//alert('hidden inserted');
						//alert(parent.CommercialNutrientsPopulate.comNutrients_form.nutMode0.value);
					}
					//document.getElementById("listContentTable").rows[i].cells[j].innerText = kitchenItems[j];
				}
			}
			}
		}
		
	}*/
	
	function selectRecord1() {
		var fields = new Array (parent.CommercialNutrientsAdd.document.getElementById("nutrients_List"),parent.CommercialNutrientsAdd.document.getElementById("content_Value"),parent.CommercialNutrientsAdd.document.getElementById("uom_Code"));
		var nutLabel=getLabel("eOT.Nutrient.Label","ot");
		var contentLabel=getLabel("eOT.ContentValue.Label","ot");
		var uomLabel=getLabel("eOT.UOMCode.Label","ot");
		
		var names = new Array ( nutLabel,contentLabel,uomLabel);
		if(checkFieldsofMst( fields, names, parent.parent.parent.messageFrame)){
			var rowCount = 0;
			rowCount = parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows.length;
			var sel = parent.CommercialNutrientsAdd.document.getElementById("nutrients_List");
			var selText = sel.options[sel.selectedIndex].text;
			var nutrient = document.CommercialNutrientsAdd.nutrients_List.value;
			var contentValue = document.CommercialNutrientsAdd.content_Value.value;
			var uom = document.CommercialNutrientsAdd.uom_Code.value;
			
			if(rowCount>1){
				/*if(rowCount==2){
					if(parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows[1].cells[0].innerText==''){
						parent.CommercialNutrientsPopulate.document.all("listContentTable").deleteRow(1);
						rowCount = rowCount-1;
					}
				}*/
				for(j=2;j<=rowCount;j++){
					var k = j-1;
					var selectedText = parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows[k].cells[0].innerText;
					if(selText == selectedText){
						if(document.CommercialNutrientsAdd.forUpdate.value == 'yes'){
							
							parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+selText+"</a>";
							parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows[k].cells[1].innerText = contentValue;
							parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows[k].cells[2].innerText = uom;
							
							 document.CommercialNutrientsAdd.nutrients_List.value = "";
							 document.CommercialNutrientsAdd.content_Value.value = "";
							 document.CommercialNutrientsAdd.uom_Code.value = "";
						}
						else{
							alert('Record already exists');
						}
						document.CommercialNutrientsAdd.forUpdate.value = 'no';
						return true;
					}
					
				}
			}
			
			document.CommercialNutrientsAdd.forUpdate.value = 'no';
			var newRow = parent.CommercialNutrientsPopulate.document.all("listContentTable").insertRow();
			 var newCell = newRow.insertCell();
			 rowCount = parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows.length;
			 var fncal = "javascript:callfn12("+rowCount+");"
			 //newCell.innerHTML = "<a href='javascript:callfn12("+nursingUnit+");'>"+nursingUnit+"</a>";
			 newCell.innerHTML = "<a href='"+fncal+"'>"+selText+"</a>";   
			 
			 newCell = newRow.insertCell();
			 newCell.innerHTML = contentValue;
			 
			 newCell = newRow.insertCell();
			 newCell.innerHTML = uom;
			
			var input = document.createElement("input");
			input.setAttribute("type", "hidden");
			var iCnt = rowCount-2;
			input.setAttribute("name", "nutMode"+iCnt);
			input.setAttribute("value", nutrient+"::I");
			parent.CommercialNutrientsPopulate.document.getElementById("comNutrients_form").appendChild(input);
			 document.CommercialNutrientsAdd.nutrients_List.value = "";
			 document.CommercialNutrientsAdd.content_Value.value = "";
			 document.CommercialNutrientsAdd.uom_Code.value = "";
		}
		
		
	}
	
	function callfn12(obj){
		obj = obj-1;
		var n = obj-1;
		var sel = parent.CommercialNutrientsAdd.document.getElementById("nutrients_List");
		var optLen = sel.length;
		var selecIndex = "";
		var cell1 = document.getElementById("listContentTable").rows[obj].cells[0].innerText;
		var cell2 = document.getElementById("listContentTable").rows[obj].cells[1].innerText;
		var cell3 = document.getElementById("listContentTable").rows[obj].cells[2].innerText;
		for(var i=0;i<optLen;i++){
			if((sel.options[i].text)==cell1){
				selecIndex = i;
			}
		}
		sel.selectedIndex = selecIndex;
		parent.CommercialNutrientsAdd.document.getElementById("content_Value").value = cell2;
		parent.CommercialNutrientsAdd.document.getElementById("uom_Code").value = cell3;
		parent.CommercialNutrientsAdd.document.getElementById("forUpdate").value = 'yes';
	}
	
	function cancelRecord(){
		document.CommercialNutrientsAdd.forUpdate.value = 'no';
		var nutrient = document.CommercialNutrientsAdd.nutrients_List.value;
		var contentValue = document.CommercialNutrientsAdd.content_Value.value;
		var uom = document.CommercialNutrientsAdd.uom_Code.value;
		var sel = parent.CommercialNutrientsAdd.document.getElementById("nutrients_List");
		var totRows = parent.CommercialNutrientsPopulate.document.getElementById("totalRows").value;
		var selText = sel.options[sel.selectedIndex].text;
		var rowCount = parent.CommercialNutrientsPopulate.document.all("listContentTable").rows.length-1;
		if(rowCount>0){
			for(i=1;i<=rowCount;i++){
				var hdnI = i-1;
				selectedText = parent.CommercialNutrientsPopulate.document.all("listContentTable").rows[i].cells[0].innerText;
				if(selectedText == selText){
					if(i<=totRows){
						parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows[i].cells[0].innerText = selectedText;
						parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows[i].cells[0].style.color = '#FF0000';
						parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows[i].cells[1].style.color = '#FF0000';
						parent.CommercialNutrientsPopulate.document.getElementById("listContentTable").rows[i].cells[2].style.color = '#FF0000';
						var hdntxt = "nutMode"+hdnI;
						var val = parent.CommercialNutrientsPopulate.document.getElementById(hdntxt).value;
						var valArr = val.split("::");
						val = valArr[0]+"::D";
						parent.CommercialNutrientsPopulate.document.getElementById(hdntxt).value=val;
					}
					else{
						parent.CommercialNutrientsPopulate.document.all("listContentTable").deleteRow(i);
						var rowCnt = parent.CommercialNutrientsPopulate.document.all("listContentTable").rows.length;
						if(rowCnt>1){	
							var l = i+1;
							for(j=l;j<=rowCnt;j++){
								var k = j-1;
								nutrient = parent.CommercialNutrientsPopulate.document.all("listContentTable").rows[k].cells[0].innerText;
								parent.CommercialNutrientsPopulate.document.all("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+nutrient+"</a>";
							}
						}
					}

					document.CommercialNutrientsAdd.nutrients_List.value = "";
					 document.CommercialNutrientsAdd.content_Value.value = "";
					 document.CommercialNutrientsAdd.uom_Code.value = "";
					return true;
				}
				document.CommercialNutrientsAdd.nutrients_List.value = "";
				 document.CommercialNutrientsAdd.content_Value.value = "";
				 document.CommercialNutrientsAdd.uom_Code.value = "";
			}
		}
		document.CommercialNutrientsAdd.nutrients_List.value = "";
		 document.CommercialNutrientsAdd.content_Value.value = "";
		 document.CommercialNutrientsAdd.uom_Code.value = "";
	}
