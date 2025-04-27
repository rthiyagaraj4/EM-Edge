	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/MealClassAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		var fields = new Array (f_query_add_mod.document.forms[0].mealClass,f_query_add_mod.document.forms[0].longDesc,f_query_add_mod.document.forms[0].shortDesc);
		var mealClass=getLabel("eOT.MealClass.Label","ot");
		var longDesc=getLabel("eOT.LongDescription.Label","ot");
		var shortDesc=getLabel("eOT.ShortDescription.Label","ot");
		var names = new Array ( mealClass,longDesc,shortDesc);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/MealClassQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MealClassAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("MealClassMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MealClassQueryCriteria.jsp") != -1)
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
			f_query_add_mod.location.href="../../eDS/jsp/MealClassAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

	}
	//CRF-673
	function checkValue(obj){
		var check = document.forms[0].check;
		var chkedValues = "";
		var chkedArray = new Array();
		var j = 0;
		for (i=0; i < check.length; i++)
		{
		if (check[i].checked)
			{
			if(chkedValues.length == 0)
			chkedValues = chkedValues; 
			chkedValues = chkedValues + check[i].value + ",";
			chkedArray[j] = i;
			j++;
			}
		}
	chkedValues=chkedValues.substring(0,chkedValues.length-1);
	document.forms[0].bedClassCode.value = chkedValues;
	}
	//CRF-673
