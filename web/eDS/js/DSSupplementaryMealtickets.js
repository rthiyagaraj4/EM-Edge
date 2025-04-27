/* This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release */

function run()
{
	var frm=f_query_rep.document.forms[0];
	var servDate=getLabel("Common.date.label","common");
	var kitchen = getLabel("eOT.Kitchen.Label","ot");		
	var p_facility_id = frm.p_facility_id.value;
	var facility_id = frm.facility_id.value;
	var p_user_name = frm.p_user_name.value;
	var p_module_id = frm.p_module_id.value;
	var p_report_id = frm.p_report_id.value;
	var p_language_id = frm.p_language_id.value;
	var p_kitchen_code = frm.kitchen.value;
	var p_serving_date = frm.servingDate.value;
	var p_supplementary_ord_for = frm.supplementaryfor.value;
	var PARAM1 = frm.servingDate.value;
	var datepattrn = frm.datepattrn.value;
	var locale = frm.locale.value;
	var p_ward_code=frm.ward.value;
	var p_patient_id = frm.patient_id.value;
	if(p_patient_id.length>0 ){
			/*var xmldoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");*/
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			var xmlstr = "<root><SEARCH  /></root>";
			//xmldoc.loadXML(xmlstr);
			xmlDoc = new DOMParser().parseFromString(xmlstr, "text/xml");
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
	
	var p_item_type_code = frm.itemtype.value;
	var p_food_itme_code = frm.itemcode.value;
	var p_status = frm.setStatus.value;	
	var p_meal_type_code = frm.mealType.value;

	if(PARAM1.length<1){
		alert(servDate+" cannot be blank");
		return false;
	}

	if(p_kitchen_code.length<1){
		alert(kitchen+" cannot be blank");
		return false;
	}

	frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_kitchen_code="+p_kitchen_code+"&PARAM1="+PARAM1+"&p_serving_date="+p_serving_date+"&facility_id="+facility_id+"&p_language_id="+locale+"&p_ward_code="+p_ward_code+"&p_item_type_code="+p_item_type_code+"&p_meal_type_code="+p_meal_type_code+"&p_food_itme_code="+p_food_itme_code+"&p_patient_id="+p_patient_id+"&p_status="+p_status+"&p_supplementary_ord_for="+p_supplementary_ord_for;

	frm.submit();
}

function isValidDate(obj)
{
	if(obj.value!="")
	{
		//var RE_NUM = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)[0-9]{2}$/;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length!=3) return cal_error ("Invalid date format: '" + str_date + "'.\nFormat accepted is DD/MM/YYYY.",obj);
		if (!arr_date[0]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo day of month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[0])) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[1]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[1])) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[2]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo year value can be found.",obj);
		if (arr_date[2].length!=4) return cal_error ("Invalid year value: '" + arr_date[2] + "'.\nAllowed format YYYY.",obj);
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed range is 01-12.",obj);
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed range is 01-"+dt_numdays.getDate()+".",obj);
		//if(arr_date[2].length==4 && arr_date[2]>=dt_date.getFullYear() ) return cal_error ("Not a valid Year value: '" + arr_date[2] + "'.\nCurrent Year "+dt_date.getFullYear()+" Only Allowed .",obj);
	}
	return true;
}


function cal_error (str_message,obj)
{
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}

function checkForSpecCharsforID(event)
{
	var strCheck = '0123456789/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) return false;
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true;
}

function cal_error (str_message,obj)
{
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}

function reset()
{
	location.reload();
}

function localTrimString(sInString)
{
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function itemChange()
{
	var formObj = document.forms[0];
	formObj.item.value="";
	var itemtype = formObj.itemtype.value;
	if (itemtype=="")
	{
		formObj.item.disabled = true;
		formObj.fooditembtn.disabled = true;
	}
	else
	{
		formObj.item.disabled = false;
		formObj.fooditembtn.disabled = false;
	}	
}

function fieldDisabled()
{
	document.getElementById("item").disabled = true;
	document.getElementById("fooditembtn").disabled = true;
}

function SupplementaryloadWards(obj){
	var kitchenCode = obj;
	if(kitchenCode==""){
		kitchenCode="All";
	}
	
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
	listItems = '<option selected="selected" value="">-----select-----</option>';
	if(wardList!=null && wardList!="undefined" && wardList!=""){
		
	for (var i = 0; i < wardList.length; i++) {
         listItems += "<option value='" + wardList[i].Ward_Code + "'>" + wardList[i].Ward_Desc + "</option>";
    }
		$("#ward").html(listItems);	
	}else{
			$("#ward").html(listItems);
		 }
}
