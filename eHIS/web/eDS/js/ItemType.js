	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/ItemTypeAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		var fields = new Array (f_query_add_mod.document.forms[0].item_Type,f_query_add_mod.document.forms[0].long_Desc,f_query_add_mod.document.forms[0].short_Desc,f_query_add_mod.document.forms[0].diet_Category);
		var itemType=getLabel("eOT.ItemType.Label","ot");
		var longDesc=getLabel("eOT.LongDescription.Label","ot");
		var shortDesc=getLabel("eOT.ShortDescription.Label","ot");
		var dietCategory = getLabel("eOT.ApplDietCategory.Label","ot");
		
		var names = new Array ( itemType,longDesc,shortDesc,dietCategory);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/ItemTypeQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ItemTypeAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("ItemTypeMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ItemTypeQueryCriteria.jsp") != -1)
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
			f_query_add_mod.location.href="../../eDS/jsp/ItemTypeAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

	}
