var allSelected = new Array();
function run()
{
		var frm=f_query_rep.document.forms[0];
		//var fields = new Array (frm.servingDate,frm.kitchen);
		var servDate=getLabel("eOT.ServingDate.Label","ot");
		var kitchen = getLabel("eOT.Kitchen.Label","ot");
		//var tab_id = frm.tab_id.value;
		//var names = new Array (servDate,kitchen);
		/*var today = new Date();
		var mon = today.getMonth()+1;
		var da = today.getDate()+"/"+mon+"/"+today.getYear();
		var chkDtVal = chkDt1Dt2(da,frm.servingDate.value);
		if(!chkDtVal){
			var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArray = msg.split("#");
			var theatre_label = getLabel("eOT.ServingDate.Label","OT");
			var current_label = getLabel("Common.CurrentDate.label","common");
			alert(msgArray[0]+theatre_label+msgArray[1]+current_label+msgArray[2]);
			return false;
		}*/
		//if(checkFieldsofMst( fields, names, messageFrame))
		//{
				//if(tab_id=='GenerateMealPlanPrint'){
					var p_facility_id = frm.p_facility_id.value;
					var facility_id = frm.facility_id.value;
					var p_user_name = frm.p_user_name.value;
					var p_module_id = frm.p_module_id.value;
					var p_report_id = frm.p_report_id.value;
					var p_language_id = frm.p_language_id.value;
					var P_KITCHEN_CODE = frm.kitchen.value;
					var converDate = frm.servingDate.value;
					var PARAM1 = frm.servingDate.value;
					var datepattrn = frm.datepattrn.value;
					var locale = frm.locale.value;
					var wardList = frm.ward;
					var SearchFor = frm.SearchFor.value;//409- US5
					var p_textureofdiet = frm.textureofdiet.value;//412- US5
					//var p_ward_code = [];
					var p_ward_code="";
					var count = 0;
					for (var i = 0; i < wardList.options.length; i++){
					  if (wardList.options[i].selected){
						  count++;
//						  p_ward_code.push(wardList.options[i].value);
						  if (count == 1) {
							  if(wardList.options[i].value == "All"){
								  p_ward_code = f_query_rep.document.getElementById("selectedAll").value;
							  }else{
								  p_ward_code=p_ward_code+'\''+wardList.options[i].value+'\'';
							  }
						  }
						  else {
							  p_ward_code=p_ward_code+',\''+wardList.options[i].value+'\'';
						  }
					  }
					}
					var p_meal_class = frm.mealClass.value;
					var p_meal_type = frm.mealType.value;
					var p_diet_type = frm.dietType.value;

				if(PARAM1.length<1){
					alert(servDate+" cannot be empty");
					return false;
				}

				if(P_KITCHEN_CODE.length<1){
					alert(kitchen+" cannot be empty");
					return false;
				}
				frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_kitchen_code="+P_KITCHEN_CODE+"&PARAM1="+PARAM1+"&converDate="+converDate+"&facility_id="+facility_id+"&locale="+locale+"&p_ward_code="+p_ward_code+"&p_meal_class="+p_meal_class+"&p_meal_type="+p_meal_type+"&p_diet_type="+p_diet_type+"&SearchFor="+SearchFor+"&p_textureofdiet="+p_textureofdiet;//409- US5 & 412-US5
				frm.submit();
		//}
}

// modified by N Munisekhar on 20-May-2013 against [IN039994]
function reset() // Modified Against ML-MMOH-CRF-1818-37552...
{
	   //var formObj = parent.content.f_query_rep.MealOrderReport;
	   //formObj.ward.options.length = 0;
	   //formObj.reset();
	   //f_query_rep.location.href="../../eDS/jsp/OPMealOrderList.jsp";
	   location.reload();
}

function setFieldToUpperCase(obj)
{
		obj.value = obj.value.toUpperCase();
		return obj;
}

function checkAlpha(event)
{
		var strCheck = '~!@#$%^&*()+=`{}|[]<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);
		if (strCheck.indexOf(key) != -1) return false;
		return true ;
}

function onSuccess()
{
		//commontoolbarFrame.location.reload();
		//window.location.reload();
		//messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?0="+"Operation Completed Sucessfully" ;
		var params = document.forms[0].params.value;
		commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?&'+params;
		at_tab_frame.location.reload();
}

function checkDateValidate(da1)
{
	if(CheckDate(da1)==true)
	{
			var today = new Date();
			var mon = today.getMonth()+1;
			var da = today.getDate()+"/"+mon+"/"+today.getYear();
			if(da1.value!="" && da!="")
			{
				var chkDtVal = chkDt1Dt2(da,da1.value);
				if(!chkDtVal){
					var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArray = msg.split("#");
					var theatre_label = getLabel("eOT.ServingDate.Label","OT");
					var current_label = getLabel("Common.CurrentDate.label","common");
					alert(msgArray[0]+theatre_label+msgArray[1]+current_label+msgArray[2]);
					return false;
				}
			}
		}
}

function checkForSpecCharsforID(event)
{
	    var strCheck = '0123456789/';
	    var whichCode = (window.Event) ? event.which : event.keyCode;
	    key = String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
}

function isValidDate(obj)
{
		if(obj.value!=""){
			var flag=true;
			var RE_NUM =  /^\/?\d+$/;
			var str_date = obj.value;
			var arr_date = str_date.split('/');
			if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;

			if(arr_date[0]!=null)
			{
			if (arr_date[0].length !=2 ) flag=false;
			}
			if(arr_date[1]!=null)
			{
			if (arr_date[1].length !=2 ) flag=false;
			}
			if(arr_date[2]!=null)
			{
			if (arr_date[2].length !=4 ) flag=false;
			}
			if (!arr_date[0]) flag=false;
			if (!RE_NUM.exec(arr_date[0])) flag=false;
			if (!arr_date[1]) flag=false;
			if (!RE_NUM.exec(arr_date[1])) flag=false;
			if (!arr_date[2]) flag=false;
			if (arr_date[2].length!=4) flag=false;
			var dt_date = new Date();
			dt_date.setDate(1);
			if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
			dt_date.setMonth(arr_date[1]-1);
			var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
			dt_date.setDate(arr_date[0]);
			if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

			if (flag==false){
				return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
			}
		}

		return true;
}

function cal_error (str_message,obj) 
{
		alert (str_message);
		//obj.focus();
		//obj.select();
		obj.value="";
		return null;
}

function chkDt1Dt2(d1,d2)
{
		var d1Arr = d1.split("/");
		var d2Arr = d2.split("/");
		if(parseInt(d2Arr[2])<parseInt(d1Arr[2])){
			return false;
		}
		else if(parseInt(d2Arr[2])==parseInt(d1Arr[2])){
			if(parseInt(d2Arr[1])<parseInt(d1Arr[1])){
					return false;
			}
			else if(parseInt(d2Arr[1])==parseInt(d1Arr[1])){
				if(parseInt(d2Arr[0])<parseInt(d1Arr[0])){
					return false;
				}
				else{
					return true;
				}
			}
			else{
				return true;
			}
		}
		else{
			return true;
		}

}

async function getWards(obj)
{
		var wardCode = obj;
		var facility = document.getElementById("facility_id").value;
		var formObj = parent.frames[1].document.forms[0];
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params = "func_mode=getWards&facility="+facility+"&wardCode="+wardCode;
		xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal =await trimString(xmlHttp.responseText);
		var ward = formObj.ward;
		while(ward.length > 0){
			ward.remove(0);
		}
		if(retVal != null && retVal != ""){
			var retValArr = retVal.split("???");
			if(retValArr!=''){
				var listOption	= document.createElement('option');
				listOption.value = "All";
				listOption.text = "All";
				ward.add(listOption);
				
				for(var i=0; i<retValArr.length; i++){
					var wardCode = retValArr[i].split(":::");
					var listOption1	= document.createElement('option');
						listOption1.value = wardCode[0];
						listOption1.text = wardCode[1];
						ward.add(listOption1);
				}
			}
		}else{ // Added Against ML-MMOH-CRF-1818-37552...starts
			 var listOption	= document.createElement('option');
				listOption.text = getLabel("eOT.select.Label","eOT");
				 ward.add(listOption);
				 // Added Against ML-MMOH-CRF-1818-37552...ends
		}
}

function selectAll(selectedAll)
{
		var formObj = parent.frames[1].document.forms[0];
		var ward = formObj.ward;
		if(selectedAll == "All"){
			var k=0;
			for(i=1;i<ward.length;i++){
				allSelected[k] = ""+'\''+ward.options[i].value+'\'';
				k++;
			}
			document.getElementById("selectedAll").value = allSelected;
		}else
			return;
}

//Added Against Ml-MMOH-CRF-1818 starts
async function dietTypeLookup(obj) {
	var formObj = document.forms[0];
	var locale = document.getElementById("locale").value;
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT DIET.SHORT_DESC DESCRIPTION, DIET.DIET_TYPE  CODE FROM DS_DIET_TYPE_LANG_VW DIET WHERE UPPER(DIET.SHORT_DESC) LIKE UPPER(?) AND UPPER(DIET.DIET_TYPE) LIKE UPPER(?) AND DIET.LANGUAGE_ID= '"
			+ locale + "' AND   DIET.EFF_STATUS='E'";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.getElementById("dietTypeDesc").value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var title=getLabel("eOT.DietType.Label","OT");
	returnedValues =await CommonLookup(title, argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if((returnedValues != null) && (returnedValues != "")) {
		document.getElementById("dietTypeDesc").value = arr[1];
		document.getElementById("dietType").value = arr[0];		
	}else{
		document.getElementById("dietTypeDesc").value = '';
		document.getElementById("dietType").value = '';		
	}
}	
//Added Against Ml-MMOH-CRF-1818 ends
