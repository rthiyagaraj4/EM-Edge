	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/DeliveryInstructionsAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		var fields = new Array (f_query_add_mod.document.forms[0].del_Instr,f_query_add_mod.document.forms[0].long_Desc);
		var delInstr=getLabel("eOT.InstructionCode.Label","ot");
		var longDesc=getLabel("eOT.Description.Label","ot");

		
		var names = new Array ( delInstr,longDesc);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/DeliveryInstructionsQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DeliveryInstructionsAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("DeliveryInstructionsMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DeliveryInstructionsQueryCriteria.jsp") != -1)
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
	
	
	function textAreaLimit(field, maxlen) {
		if (field.value.length > maxlen + 1)
		alert('Should not be more than  '+maxlen+" characters");
		if (field.value.length > maxlen)
		field.value = field.value.substring(0, maxlen);
	}

	function onSuccess()
	{
		var formObj = document.forms[0];
		var params = formObj.params.value;
		if(f_query_add_mod.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href="../../eDS/jsp/DeliveryInstructionsAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

	}
