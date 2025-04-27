//KDAH-CRF-0351 for Floor wise feed type.
function run()
{  
		var frm=f_query_rep.document.forms[0];
		var p_facility_id = frm.p_facility_id.value;
		var facility_id = frm.facility_id.value;
		var p_user_name = frm.p_user_name.value;
		var p_module_id = frm.p_module_id.value;
		var p_report_id = frm.p_report_id.value;
		var p_language_id = frm.p_language_id.value;
		var converDate = frm.servingDate.value;
		var sysdate=getCurrentDate("DMH",'en');
		var datepattrn = frm.datepattrn.value;
		var locale = frm.locale.value;
		var p_serving_date = frm.servingDate.value;
		var p_ward_code = frm.nursing_Unit.value;
		var p_feed_type = frm.feedType.value;
		var p_meal_type = frm.mealType.value;
		//Added Against AMS-SCF-0930 Starts
		var p_serving_date_Array = new Array();
		var sysdate_Array = new Array();
		p_serving_date_Array	=	p_serving_date.split("/");
		p_serving_date_Array=new Date(p_serving_date_Array[2], p_serving_date_Array[1]-1, p_serving_date_Array[0]);
		sysdate_Array	=	sysdate.split("/");
		sysdate_Array=new Date(sysdate_Array[2], sysdate_Array[1]-1, sysdate_Array[0]);
		//Added Against AMS-SCF-0930 Ends
		
        if(p_serving_date.length<1){
			alert(getMessage("DS_PROD_DATE","DS"));//Date cannot be blank
			return false;
		}
		//if(p_serving_date < sysdate){
		if(p_serving_date_Array < sysdate_Array){ //Modified Against AMS-SCF-0930
			alert(getMessage("DS_MEAL_PROD","DS"));//Date Should not be less than Current Date.
			return false;
		}
		if(p_ward_code.length<1){ 
			alert(getMessage("DS_NURSGUNIT_NOT_BLANK","DS"));//Nursing Unit Cannot be Blank
			return false;
		}
		
		frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_serving_date="+p_serving_date+"&converDate="+converDate+"&facility_id="+facility_id+"&locale="+locale+"&p_meal_type="+p_meal_type+"&p_ward_code="+p_ward_code+"&p_feed_type="+p_feed_type;
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
		return true ;
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
	    key = String.fromCharCode(whichCode);  
	    if (strCheck.indexOf(key) == -1) return false;  
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
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);

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
		obj.focus();
		obj.select();
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
