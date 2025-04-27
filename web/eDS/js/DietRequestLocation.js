/* Created for ML-MMOH-CRF-0419 */

	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/DietRequestLocationAddModify.jsp?"+params+"&mode=insert";
		
	}
	
	function apply() {
	    var frm=f_query_add_mod.document.forms[0];
		var fields = new Array (f_query_add_mod.document.forms[0].dietLocationCode,f_query_add_mod.document.forms[0].longDesc,f_query_add_mod.document.forms[0].shortDesc);
		var dietLocationCode=getLabel("eDS.LocationCode.Label","ds");
		var longDesc=getLabel("eOT.LongDescription.Label","ot");
		var shortDesc=getLabel("eOT.ShortDescription.Label","ot");
		
		var names = new Array ( dietLocationCode,longDesc,shortDesc);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
			
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/DietRequestLocationQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DietRequestLocationAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("DietRequestLocationMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DietRequestLocationQueryCriteria.jsp") != -1)
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
			f_query_add_mod.location.href="../../eDS/jsp/DietRequestLocationAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

	}

	function defaultCheck()
	{
		var dietLocationCode=document.getElementById("dietLocationCode").value; 
	        var temp_location=document.getElementById("temp_location").value;
	     	if(document.getElementById("defaultlocation").checked)
		{
		if(document.getElementById("default_Count").value > 0 && temp_location != dietLocationCode )
		{
			var message=getMessage("DS_DEFAULT_DIET_REQUEST_LOC_CHECK","ds");
			alert(message);
			document.getElementById('defaultlocation').checked=false;
		}
		else{
		if(!document.getElementById("enabledYn").checked)
		     document.getElementById('enabledYn').checked=true;
		     }
		}
	}
	
	function enableCheck()
	{
		if(!document.getElementById("enabledYn").checked)
		{
		if(document.getElementById("defaultlocation").checked)
		     document.getElementById('defaultlocation').checked=false;
		}
	}
