	
	var ordTypeArr = new Array();
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/DietCategoryAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var formObj = f_query_add_mod.document.forms[0];
		var fields = new Array (formObj.order_Type);
		var orderType=getLabel("eOT.order_Type.Label","ot");
		var names = new Array (orderType);
		var ordTypeArr = formObj.document.getElementById("ordList").value;
		var errors = "";
		if(checkFieldsofMst( fields, names, messageFrame)) 
		{	
			var dietCategory =  formObj.diet_Category.value;
			var orderType = formObj.order_Type.value;
			var longDesc =  formObj.long_Desc.value;
			var mode = "update"
			if(ordTypeArr != orderType){
				formObj.mode.value=mode;
				formObj.description.value=dietCategory;
				formObj.longDesc1.value=longDesc;
				formObj.submit();
			}else{
				var errors = "Order Type can not be Duplicate Record";
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;
				return;
			}
				//}
		}
			/*formObj.mode.value=mode;
			formObj.description.value=dietCategory;
			formObj.longDesc1.value=longDesc;
			formObj.submit();*/
			
		
	}

	
	
	function orderTypeDuplicate(obj){
		var orderTypeCode = obj;
		var locale = document.getElementById("locale").value;
		//var xmldoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlstr = "<root><SEARCH  /></root>";
		//xmldoc.loadXML(xmlstr);
		xmlDoc=new DOMParser().parseFromString(getXMLString(xmlStr), "text/xml");
		xmlhttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?func_mode=orderTypeDuplicate",false);
		xmlhttp.send(xmldoc);
		var retVal = localTrimString(xmlhttp.responseText);
		if(retVal!=''){
			var retValArr = retVal.split("???");
			var errors = "";
			var index=0;
			if(retValArr!=''){
				for(var i=0; i<retValArr.length; i++){
					var orderTypeDupCode = retValArr[i].split(":::");
					for(var j =1; j < orderTypeDupCode.length; j++){
						if(orderTypeDupCode[j] == orderTypeCode){
							var errors = "Order Type can not be Duplicate Record";
							parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;
							ordTypeArr[index] = orderTypeDupCode[j];
							document.getElementById("ordList").value = ordTypeArr[index];
							index++;
						}else{
							parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;
						}
					}
					
				}
			}
		}
	}
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/DietCategoryQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DietCategoryAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("DietCategoryMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DietCategoryQueryCriteria.jsp") != -1)
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
			f_query_add_mod.location.href="../../eDS/jsp/DietCategoryAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

	}
	
	function localTrimString(sInString) {
		return sInString.replace(/^\s+|\s+$/g,"");
	}
