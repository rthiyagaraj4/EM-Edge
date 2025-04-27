	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/FoodItemAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		var frmName = f_query_add_mod.FoodItemAdd.document.forms[0].name;
		
		if(frmName=="foodItem_form"){
			var fields = new Array (f_query_add_mod.FoodItemAdd.document.forms[0].food_Item,f_query_add_mod.FoodItemAdd.document.forms[0].long_Desc,f_query_add_mod.FoodItemAdd.document.forms[0].short_Desc,f_query_add_mod.FoodItemAdd.document.forms[0].item_Type,f_query_add_mod.FoodItemAdd.document.forms[0].serving_Uom,f_query_add_mod.FoodItemAdd.document.forms[0].preparation_Uom,f_query_add_mod.FoodItemAdd.document.forms[0].base_Qty,f_query_add_mod.FoodItemAdd.document.forms[0].preparation_Factor,f_query_add_mod.FoodItemAdd.document.forms[0].calorie_Content);
			var foodItem=getLabel("eOT.FoodItemCode.Label","ot");
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
					f_query_add_mod.FoodItemAdd.document.forms[0].submit();
				}
		}
		else if(frmName=="FoodItemNutrients"){
			var fields = new Array (f_query_add_mod.FoodItemAdd.NutrientsPopulate.document.forms[0].nutrients_List);
			var nutLabel = getLabel("eOT.FoodItem.Label","ot");
			var names = new Array (nutLabel);
			if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				var nutrientsArr = new Array();
				var tbl = f_query_add_mod.FoodItemAdd.NutrientsPopulate.document.getElementById("listContentTable");
				var foodItmCode = f_query_add_mod.FoodItemAdd.NutrientsPopulate.document.getElementById("nutrients_List").value;
				//modified by N Munisekhar on 24-May-2013 against [IN39921]
				if(tbl.rows.length <= 1){
				var error = getMessage("ATLEAST_ONE_SELECTED","common");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
				return false;
		        }
				var rowCount = tbl.rows.length;
				for(j=2;j<=rowCount;j++){
					var k = j-1;
					var arrI = j-2;
					nutrientsArr[arrI]=tbl.rows[k].cells[1].innerText;
				}
				for(var i=0;i<nutrientsArr.length;i++){
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "nutRow"+i);
					input.setAttribute("value", nutrientsArr[i]);
					f_query_add_mod.FoodItemAdd.NutrientsPopulate.document.getElementById("nutrients_form").appendChild(input);
				}
				if(i>0){
					frm = f_query_add_mod.FoodItemAdd.NutrientsPopulate.document.forms[0];
					frm.action = '../../servlet/eDS.FoodItemServlet?Nutrients=yes&totalRow='+i+'&NutrientsValue='+nutrientsArr+'&foodItmCode='+foodItmCode;
					frm.submit();
				}
				
			}
			
		}
		
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
		var formObj =document.forms[0];
		var params = formObj.params.value;
		if(f_query_add_mod.FoodItemAdd.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href="../../eDS/jsp/FoodItemAddModify.jsp?"+params+"&mode=insert";
		else
			f_query_add_mod.FoodItemAdd.location.reload();

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
