	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/WardsForKitchenAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var formObj = f_query_add_mod.WardsForKitchenList.document.forms[0];
		var fields = new Array (f_query_add_mod.WardsForKitchenList.document.forms[0].kitchen_Code);
		var KitchenCode=getLabel("eOT.KitchenCode.Label","ot");

		var names = new Array (KitchenCode);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				formObj.submit();
			}
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/WardsForKitchenQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("WardsForKitchenAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("WardsForKitchenMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("WardsForKitchenQueryCriteria.jsp") != -1)
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
		//if(f_query_add_mod.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href="../../eDS/jsp/WardsForKitchenAddModify.jsp?"+params+"&mode=insert";
		//else
	         //f_query_add_mod.location.reload();

	}
	
	function localTrimString(sInString) {
		  return sInString.replace(/^\s+|\s+$/g,"");
		}
	
	function loadBottomPage(obj){
		parent.WardsForKitchenModify.location.href = '../../eDS/jsp/WardsForKitchenModify.jsp?kitchen_code='+obj.value;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?"
	}
	
	function selectWards(obj){
		var selWards = parent.WardsForKitchenList.document.getElementById('selectedWards');
		if(selWards.value!=''){
			selWards.value = 	selWards.value +','+obj;
		}else{
			selWards.value = 	selWards.value+obj;
		}

	}
	
	function removeWards(obj){
		var remWards = parent.WardsForKitchenList.document.getElementById('removedWards');
		if(remWards.value!=''){
			remWards.value = 	remWards.value +','+obj;
		}else{
			remWards.value = 	remWards.value+obj;
		}

	}
