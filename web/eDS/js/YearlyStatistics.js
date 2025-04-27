		function run() {
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
					var p_facility_id = frm.p_facility_id.value;
					var p_user_name = frm.p_user_name.value;
					var p_module_id = frm.p_module_id.value;
					var p_report_id = frm.p_report_id.value;
					var p_language_id = frm.p_language_id.value;
					var facility_id = frm.facility_id.value;
					var locale = frm.locale.value;
					var datepattrn = frm.datepattrn.value;
					var conDate = "";
					var p_kitchen_code = frm.kitchen.value;
					var PARAM1 = frm.servingDate.value;
					var PARAM2 = frm.nursingUnitFrom.value;
					var PARAM3 = frm.nursingUnitTo.value;
					var PARAM4 = frm.dietTypeFrom.value;
					var PARAM5 = frm.dietTypeTo.value;
					var rep_type = frm.repType.value;

				if(PARAM1.length<1){
					alert(servDate+" cannot be empty");
					return false;
				}

				if(p_kitchen_code.length<1){
					alert(kitchen+" cannot be empty");
					return false;
				}

				frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+
							"&locale="+locale+"&datepattrn="+datepattrn+"&p_kitchen_code="+p_kitchen_code+"&PARAM1="+PARAM1+"&PARAM2="+PARAM2+"&PARAM3="+PARAM3+"&PARAM4="+PARAM4+"&PARAM5"+PARAM5+"&VO.REPORTTYPE="+rep_type;
				frm.submit();
		//}
	}


	function isValidDate(obj){
		if(obj.value!=""){
			var flag=true;
			if (obj.value.length !=4 ) flag=false;

			if (flag==false){
				return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
			}
		}

		return true;
	}

	function cal_error (str_message,obj) {
		alert (str_message);
		obj.focus();
		obj.select();
		return null;
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
	// modified by N Munisekhar on 20-May-2013 against [IN039994]
	 function reset(){
	 var formObj = parent.content.f_query_rep.MonthlyStatisticsReport;
	  formObj.reset();
		 }
