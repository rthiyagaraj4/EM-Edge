	

	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/SpecialtiesForKitchenAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var formObj = f_query_add_mod.SpecialtiesForKitchenList.document.forms[0];
		var fields = new Array (f_query_add_mod.SpecialtiesForKitchenList.document.forms[0].kitchen_Code);
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
		f_query_add_mod.location.href="../../eDS/jsp/SpecialtiesForKitchenQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SpecialtiesForKitchenAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("SpecialtiesForKitchenMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SpecialtiesForKitchenQueryCriteria.jsp") != -1)
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
			f_query_add_mod.location.href="../../eDS/jsp/SpecialtiesForKitchenAddModify.jsp?"+params+"&mode=insert";
	}
	
	function localTrimString(sInString) {
		  return sInString.replace(/^\s+|\s+$/g,"");
		}
	
	function loadSpecialties(obj){
		
		parent.SpecialtiesForKitchenList.document.getElementById('selectedSpecialties').value="";
		parent.SpecialtiesForKitchenList.document.getElementById('removedSpecialties').value="";
		
		parent.SpecialtiesForKitchenModify.location.href = '../../eDS/jsp/SpecialtiesForKitchenModify.jsp?kitchen_code='+obj.value;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?";
	}
	
	function selectSpeciality(obj){
		var selSpecialties = parent.SpecialtiesForKitchenList.document.getElementById('selectedSpecialties');
		var remSpecialties = parent.SpecialtiesForKitchenList.document.getElementById('removedSpecialties');
		
		if(selSpecialties.value!=''){
			selSpecialties.value = 	selSpecialties.value +','+obj;
		}else{
			selSpecialties.value = 	selSpecialties.value+obj;
		}

		if(remSpecialties.value!=obj){
			remSpecialties.value = 	remSpecialties.value.replace(','+obj,''); 
		}else{
			remSpecialties.value = 	remSpecialties.value.replace(obj,'');
		}
		

	}
	
	function removeSpeciality(obj){
		var remSpecialties = parent.SpecialtiesForKitchenList.document.getElementById('removedSpecialties');
		var selSpecialties = parent.SpecialtiesForKitchenList.document.getElementById('selectedSpecialties');
		
		if(remSpecialties.value!=''){
			remSpecialties.value = 	remSpecialties.value +','+obj;
		}else{
			remSpecialties.value = 	remSpecialties.value+obj;
		}
		
		if(selSpecialties.value!=obj){
			selSpecialties.value = 	selSpecialties.value.replace(','+obj,''); 
		}else{
			selSpecialties.value = 	selSpecialties.value.replace(obj,'');
		}		

	}
	
	function addRemoveSpeciality(obj,speciality) {
		if(obj.checked==true) {
			selectSpeciality(speciality);
		}
		else {
			removeSpeciality(speciality);
		}
	}
