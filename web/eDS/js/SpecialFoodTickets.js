


	async function run() {
		var frm=f_query_rep.document.forms[0];
		//var fields = new Array (frm.servingDate,frm.kitchenFrom,frm.kitchenTo);
		var servDate=getLabel("eOT.ServingDate.Label","ot");
		var kitchenFrom = getLabel("eOT.Kitchen.Label","ot");
		var kitchenTo = getLabel("eOT.Kitchen.Label","ot");
		//var tab_id = frm.tab_id.value;
		//var names = new Array (servDate,kitchenFrom,kitchenTo);
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
		var frmPatient = frm.patientIdFrom.value;
		var toPatient = frm.patientIdTo.value;
		if(frmPatient.length>0 || toPatient.length>0){
			/*var xmldoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");*/
			var xmlHttp = new XMLHttpRequest();
			var xmlstr = "<root><SEARCH  /></root>";
			var xmlDoc = new DOMParser().parseFromString(xmlstr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?func_mode=checkPatId&fromPatient="+frmPatient+"&toPatient="+toPatient,false);
			xmlHttp.send(xmlDoc);
			var retVal = await localTrimString(xmlHttp.responseText);
			var retValArr = retVal.split(":");
			if('Invalid' == retValArr[0]){
				alert("Invalid From Patient ID");
			     return false ;
			}
			if('Invalid' == retValArr[1]){
				alert("Invalid To Patient ID");
			     return false ;
			}
		}
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
					var nd_serv_date = frm.servingDate.value;
					var p_kitchen_code_from = frm.kitchenFrom.value;
					var p_kitchen_code_to = frm.kitchenTo.value;
					var nd_fr_meal = frm.mealTypeFrom.value;
					var nd_to_meal = frm.mealTypeTo.value;
					var nd_fr_ward_code = frm.nursingUnitFrom.value;
					var nd_to_ward_code = frm.nursingUnitTo.value;
					var chkPatientId2 = "";
					var nd_fr_pat_id = frm.patientIdFrom.value;
					var nd_to_pat_id = frm.patientIdTo.value;
					var p_user = "";
					var P_TYPE = frm.frequency.value;
					var P_MEAL_PLAN_SEQ_NO = "";
					var chkPatientId1 = "";

				if(nd_serv_date.length<1){
					alert(servDate+" cannot be empty");
					return false;
				}

				if(p_kitchen_code_from.length<1){
					alert(kitchenFrom+" cannot be empty");
					return false;
				}

				if(p_kitchen_code_to.length<1){
					alert(kitchenTo+" cannot be empty");
					return false;
				}

				frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+
							"&locale="+locale+"&datepattrn="+datepattrn+"&nd_serv_date="+nd_serv_date+"&p_kitchen_code_from="+p_kitchen_code_from+"&p_kitchen_code_to="+p_kitchen_code_to+"&nd_fr_meal="+nd_fr_meal+"&nd_to_meal="+nd_to_meal+
							"&nd_fr_ward_code="+nd_fr_ward_code+"&nd_to_ward_code="+nd_to_ward_code+"&nd_fr_pat_id="+nd_fr_pat_id+"&nd_to_pat_id="+nd_to_pat_id+"&P_TYPE="+P_TYPE+"&p_user="+p_user_name;
				frm.submit();
		//}
	}

// modified by N Munisekhar on 20-May-2013 against [IN039994]
	 function reset(){
	 var formObj = parent.content.f_query_rep.MealStatisticsReport;
	  formObj.reset();
		 //at_tab_frame.location.reload();
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
		//commontoolbarFrame.location.reload();
		//window.location.reload();
		//messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?0="+"Operation Completed Sucessfully" ;
		var params = document.forms[0].params.value;
		commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?&'+params;
		at_tab_frame.location.reload();

	}

	function checkDateValidate(da1) {

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

	function isValidDate(obj){
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

	function cal_error (str_message,obj) {
		alert (str_message);
		obj.focus();
		obj.select();
		return null;
	}

	function chkDt1Dt2(d1,d2){
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

	function localTrimString(sInString) {
		  return sInString.replace(/^\s+|\s+$/g,"");
		}
