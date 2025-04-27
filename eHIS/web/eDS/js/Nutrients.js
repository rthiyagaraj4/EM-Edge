	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/NutrientsAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		var fields = new Array (f_query_add_mod.document.forms[0].nutrients,f_query_add_mod.document.forms[0].long_Desc,f_query_add_mod.document.forms[0].short_Desc,f_query_add_mod.document.forms[0].uom);
		//IN::39912 - start
		var fields_set2 = new Array(f_query_add_mod.document.forms[0].nutrient_Conversion,f_query_add_mod.document.forms[0].energy_Conversion);
		
		var nutrients=getLabel("eOT.NutrientCode.Label","ot");
		var longDesc=getLabel("eOT.LongDescription.Label","ot");
		var shortDesc=getLabel("eOT.ShortDescription.Label","ot");
		var uom=getLabel("eOT.Uom.Label","ot");
		var names = new Array ( nutrients,longDesc,shortDesc,uom);
		
		var nutrientConversion = f_query_add_mod.document.forms[0].nutUnits.value;
		var energyConversion = f_query_add_mod.document.forms[0].energyUnits.value;
		var names_set2 = new Array ( nutrientConversion,energyConversion);
		
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				if(checkFieldsofMst( fields_set2, names_set2, messageFrame)) 
				{
					f_query_add_mod.document.forms[0].submit();
				}
			} //IN::39912 - end
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/NutrientsQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("NutrientsAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("NutrientsMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("NutrientsQueryCriteria.jsp") != -1)
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
			f_query_add_mod.location.href="../../eDS/jsp/NutrientsAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

	}
	
	
	function getUnit(obj){
		document.getElementById("nutUnits").value=obj.value;
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
	            parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+"Only Numbers allowed" ;
	            return false;
	        }
	    }
	}
