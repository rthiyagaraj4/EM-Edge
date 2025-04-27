/* New file MealAcknowledgeReport.js created against ML-MMOH-CRF-0413 [IN:057274] */

var allSelected = new Array();
function run()
{
	var frm=f_query_rep.document.forms[0];
	var servDate=getLabel("eOT.ServingDate.Label","ot");
	var kitchen = getLabel("eOT.Kitchen.Label","ot");		
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
	var wardCode = "";
	var p_ward_code="";
	var p_patient_id = frm.patientId.value;
	var selectedValuesAll=frm.selectedAll.value;
	if(p_patient_id.length>0 ){
			/*var xmldoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");*/
			var xmlhttp = new XMLHttpRequest();
			var xmlstr = "<root><SEARCH  /></root>";
			var xmldoc = new DOMParser().parseFromString(xmlstr, "text/xml")
			//xmldoc.loadXML(xmlstr);
			xmlhttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?func_mode=checkPatId&fromPatient="+p_patient_id+"&toPatient="+p_patient_id,false);
			xmlhttp.send(xmldoc);
			var retVal = localTrimString(xmlhttp.responseText);
			var retValArr = retVal.split(":");
			if('Invalid' == retValArr[0]){
				alert("Invalid Patient ID");
			     return false ;
			}
			if('Invalid' == retValArr[1]){
				alert("Invalid  Patient ID");
			     return false ;
			}
	}
	
	var p_setStatus = frm.setStatus.value;
	var p_frequency = frm.frequency.value;
	var p_repType = frm.repType.value;
	var count = 0;
	var allflag=false;
	for (var i = 0; i < wardList.options.length; i++){
		if (wardList.options[i].selected){
			count++;
		if (count == 1) 
		{
			if(wardList.options[i].value == "All")
			{
				p_ward_code = frm.selectedAll.value;
				wardCode = frm.selectedAll.value;
				allflag=true;
			}
			else
			{
			p_ward_code=p_ward_code+'\''+wardList.options[i].value+'\'';
			wardCode=wardCode+",";
			}
		}
		else{
			if(wardList.options[i].value == "All")
			{
				allflag=true;
			}
			p_ward_code=p_ward_code+',\''+wardList.options[i].value+'\'';
			wardCode=wardCode+',\''+wardList.options[i].value+'\'';
		}
		}
	}
	if(allflag==true){
		frm.selectedAll.value="";
	}
	selectedValuesAll=frm.selectedAll.value;
	
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

	//frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_kitchen_code="+P_KITCHEN_CODE+"&PARAM1="+PARAM1+"&converDate="+converDate+"&facility_id="+facility_id+"&locale="+locale+"&p_ward_code="+p_ward_code+"&p_meal_class="+p_meal_class+"&p_meal_type="+p_meal_type+"&p_diet_type="+p_diet_type+"&p_patient_id="+p_patient_id+"&p_setStatus="+p_setStatus+"&p_frequency="+p_frequency+"&p_repType="+p_repType;
	frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_kitchen_code="+P_KITCHEN_CODE+"&PARAM1="+PARAM1+"&converDate="+converDate+"&facility_id="+facility_id+"&p_language_id="+locale+"&p_ward_code="+selectedValuesAll+"&p_meal_class="+p_meal_class+"&p_meal_type="+p_meal_type+"&p_diet_type="+p_diet_type+"&p_patient_id="+p_patient_id+"&p_setStatus="+p_setStatus+"&p_frequency="+p_frequency+"&p_repType="+p_repType;
	frm.submit();
}

function reset()
{
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
	return true;
}

function onSuccess()
{
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
		return true;
}
function restrictSpecialChars(event){
		var strCheck = '.~!@#$%^&*()+=`{}|[];:_-,/\\?<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) 
		{
			window.event.keyCode = 27;
			return false;  
		}
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
		alert(str_message);
		obj.focus();
		obj.select();
		return null;
}
function getCurrentServerDate(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="getCurrentServerDate";
		
	var xmlStr ="<root></root>";
	var params="mode="+mode;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	
	var jsonObjResponse=eval('(' + retVal + ')');
	var date=jsonObjResponse.CurrentDate;
	$("#servingDate").val(date[0].Server_Date);	
}

function loadKitchen(){

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="loadKitchen_MealTicket";
	var facility_id=$('#facility_id').val();
	var xmlStr ="<root></root>";
	
	var params="mode="+mode;
	params+="&facilityid="+facility_id;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var kitchenList=new Array();
	kitchenList = jsonObjResponse.jsonKitchenList;
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(kitchenList!=null && kitchenList!="undefined" && kitchenList!=""){
	for (var i = 0; i < kitchenList.length; i++) {
         listItems += "<option value='" + kitchenList[i].KitchenCode + "'>" + kitchenList[i].KitchenDesc + "</option>";
    }
		$("#kitchen").html(listItems);
	}
}

function loadWards(obj){
	var kitchenCode = obj;
	var facility_id=$('#facility_id').val();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "mode=loadWards&facility="+facility_id+"&kitchenCode="+kitchenCode;
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var wardList=new Array();
	wardList = jsonObjResponse.Ward;
	$("#selectedAll").val("");	
	var listItems = '';
	if(wardList!=null && wardList!="undefined" && wardList!=""){
		listItems = '<option selected="selected" value="All">All</option>';
	for (var i = 0; i < wardList.length; i++) {
         listItems += "<option value='" + wardList[i].Ward_Code + "'>" + wardList[i].Ward_Desc + "</option>";
    }
		$("#ward").html(listItems);	
	}else{ // Added Against ML-MMOH-CRF-1818-37552...starts
		    var listItems = '<option selected="selected" value="">-----'+getLabel("eOT.select.Label","eOT")+'-----</option>';
			$("#ward").html(listItems);
			// Added Against ML-MMOH-CRF-1818-37552...ends
		}
}

function loadMealClass(){
	var facility_id=$('#facility_id').val();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "mode=loadMealClass&facility="+facility_id;
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var mealClassList=new Array();
	mealClassList = jsonObjResponse.MealClass;
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(mealClassList!=null && mealClassList!="undefined" && mealClassList!=""){
	for (var i = 0; i < mealClassList.length; i++) {
         listItems += "<option value='" + mealClassList[i].Meal_Code + "'>" + mealClassList[i].Meal_Desc + "</option>";
    }
		$("#mealClass").html(listItems);	
		}
		else{
			$("#mealClass").html(listItems);
		}
}

function loadMealType(){
	var facility_id=$('#facility_id').val();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mealOrderFor="IP"; // Modified Against KDAH-CRF-0505
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "mode=loadMealType&facility="+facility_id+"&mealOrderFor="+mealOrderFor;
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var mealTypeList=new Array();
	mealTypeList = jsonObjResponse.jsonMealTypeList;
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(mealTypeList!=null && mealTypeList!="undefined" && mealTypeList!=""){
	for (var i = 0; i < mealTypeList.length; i++) {
         listItems += "<option value='" + mealTypeList[i].MealCode + "'>" + mealTypeList[i].MealDesc + "</option>";
    }
		$("#mealType").html(listItems);	
		}
	else{
		$("#mealType").html(listItems);
		}
}

function loadDietType(){
	var facility_id=$('#facility_id').val();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mealOrderFor="All";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "mode=loadDietType&facility="+facility_id+"&mealOrderFor="+mealOrderFor;
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var dietTypeList=new Array();
	dietTypeList = jsonObjResponse.jsonDietTypeList;
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(dietTypeList!=null && dietTypeList!="undefined" && dietTypeList!=""){
	for (var i = 0; i < dietTypeList.length; i++) {
         listItems += "<option value='" + dietTypeList[i].DietCode + "'>" + dietTypeList[i].DietDesc + "</option>";
    }
		$("#dietType").html(listItems);	
		}
	else{
		$("#dietType").html(listItems);
		}
}

function selectAll(selectedAll)
{

		var selectedValues = $('#ward').val();
		var selectedValuesAll="";
		selectedValues=selectedValues.toString();
				
		selectedValuesAll = selectedValues.replace(/,/g, "','");
		selectedValues = "'"+selectedValues.replace(/,/g, "','")+"'";
				
		$('#selectedAll').val(selectedValuesAll);

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

function enableDisableField()
{
	var generaterep=$('#generaterep').val();
	if(generaterep=="M"){
		 $('#frequency').attr("disabled","disabled");
		 $('#frequency').val('');		 
		 
		 $('#mealClass').removeAttr('disabled');
		 $('#dietType').removeAttr('disabled');
	}else if(generaterep=="S"){
		 $('#frequency').removeAttr('disabled');
		 
		 $('#mealClass').attr("disabled","disabled");
		 $('#dietType').attr("disabled","disabled");
		 
		 $('#mealClass').val('');
		 $('#dietType').val('');
	}
}
function localTrimString(sInString)
{
	  return sInString.replace(/^\s+|\s+$/g,"");
}
