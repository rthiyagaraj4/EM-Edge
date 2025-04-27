function run()
{
		var frm=f_query_rep.document.forms[0];
		var servDate=getLabel("eOT.ServingDate.Label","ot");
		var kitchenFrom = getLabel("eOT.Kitchen.Label","ot");
		var kitchenTo = getLabel("eOT.Kitchen.Label","ot");
		var customer_id = frm.customer_id.value;				
		if(customer_id == 'WCH'){
		var dietCategory = getLabel("eOT.DietCategory.Label","ot");  // Added for CRF -782
		}
		/* Added Against Start AMS-CRF-0180 */
		var nd_from_serv_date="",nd_to_serv_date="",p_rep_duration= "",isDateOption=""; 
		var MealTicketfor= frm.MealTicketfor.value; 
		isDateOption = f_query_rep.document.getElementById("isDateOption").value;
		if(isDateOption=="true"){
			nd_from_serv_date = frm.servingDate1.value;	
				if(MealTicketfor=="Patient"){
					nd_to_serv_date = frm.servingDate2.value;
					p_rep_duration = frm.dateOption.value;
				}	
		}
		/* Added Against End AMS-CRF-0180 */
		var frmPatient = frm.patientIdFrom.value;
		var toPatient = frm.patientIdTo.value;
		if(frmPatient.length>0 || toPatient.length>0){
			/*var xmldoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");*/
			var xmlstr = "<root><SEARCH  /></root>";
			 var xmldoc = new DOMParser().parseFromString(xmlstr, "text/xml");
			var xmlhttp = new XMLHttpRequest() ;
			/*xmldoc.loadXML(xmlstr);*/
			xmlhttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?func_mode=checkPatId&fromPatient="+frmPatient+"&toPatient="+toPatient,false);
			xmlhttp.send(xmldoc);
			var retVal = localTrimString(xmlhttp.responseText);
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
					if(customer_id == 'WCH'){
					var p_diet_category = frm.dietCategory.value; // Added for CRF -782
					}
					else{
					p_diet_category ='';
					}
					var nd_fr_meal = frm.mealTypeFrom.value;
					var nd_to_meal = frm.mealTypeTo.value;
					var nd_fr_ward_code = frm.nursingUnitFrom.value;
					var nd_to_ward_code = frm.nursingUnitTo.value;
					var nd_fr_diet_type = frm.dietTypeFrom.value;
					var chkPatientId2 = "";
					var nd_to_diet_type = frm.dietTypeTo.value;
					var nd_fr_meal_class = frm.mealClassFrom.value;
					var nd_to_meal_class = frm.mealClassTo.value;
					var nd_fr_pat_id = frm.patientIdFrom.value;
					var nd_to_pat_id = frm.patientIdTo.value;
					var p_user = frm.p_user.value;//55878
					var P_MEAL_PLAN_SEQ_NO = '';//MMS-DM-CRF-0044
					var SearchFor=frm.SearchFor.value;//409					
					if(p_report_id =='DSRSTDMT')//MMS-DM-CRF-0044					
					P_MEAL_PLAN_SEQ_NO = frm.mealPlanSeqNo.value;
									
					var nd_from_bed_no = frm.bedNumberFrom.value;
					var nd_to_bed_no = frm.bedNumberTo.value;

					//KDAH-CRF-0352
					var nd_fr_feed_Type ="";
					var nd_to_feed_Type ="";
					var isMenuType=frm.isMenuType.value;
					if(!isMenuType=="true")
					{
						nd_fr_feed_Type = frm.feedTypeFrom.value;
						nd_to_feed_Type = frm.feedTypeTo.value;
					}
					else
					{
						nd_fr_feed_Type = "";
						nd_to_feed_Type = "";
					}			
					//KDAH-CRF-0352

					var chkPatientId1 = "";
					
	
				/* Added Against Start AMS-CRF-0180 */
				if(isDateOption=="true"){
					if(nd_from_serv_date.length<1){
						alert("From Date cannot be empty");
						return false;
					}
						
					if(MealTicketfor=="Patient"){
						if(nd_to_serv_date.length<1){
							alert("To Date cannot be empty");
							return false;
						}
					}
				
						if(p_rep_duration=="DR"){
							if(!checkTODate()){
								return false;
							}
							if(nd_from_serv_date!="" && nd_to_serv_date!=""){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest() ;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								var params = "func_mode=getDatediff&fromDate="+nd_from_serv_date+"&toDate="+nd_to_serv_date;
								xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
									if(retVal > 90){
										flag =false;
										alert(getMessage("DS_MEAL_DIFFS_DAYS","DS"));
										return false;
									}								
							}								
						}
						
				}
				/* Added Against End AMS-CRF-0180 */				
				if(nd_serv_date.length<1){
					alert(servDate+" cannot be empty");
					return false;
				}			
				/* Added Against Start AMS-CRF-0180 */
				if(isDateOption=="true"){
					nd_serv_date = nd_from_serv_date ; 
				}
				/* Added Against End AMS-CRF-0180 */
		
				if(p_kitchen_code_from.length<1){
					alert(kitchenFrom+" cannot be empty");
					return false;
				}else if(p_kitchen_code_to.length<1){
					alert(kitchenTo+" cannot be empty");
					return false;
				}
				/* Added Against Start AMS-CRF-0180 */
				if(isDateOption=="true" && p_rep_duration=="DR"){
						if(frmPatient.length==0){
							alert("Patient ID cannot be empty");
							return false;
						}					
				}
				/* Added Against End AMS-CRF-0180 */
				
				frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_user="+encodeURIComponent(p_user)+"&facility_id="+facility_id+"&locale="+locale+"&datepattrn="+datepattrn+"&nd_serv_date="+nd_serv_date+"&p_kitchen_code_from="+p_kitchen_code_from+"&p_kitchen_code_to="+p_kitchen_code_to+"&p_diet_category="+p_diet_category+"&nd_fr_meal="+nd_fr_meal+"&nd_to_meal="+nd_to_meal+"&nd_fr_ward_code="+nd_fr_ward_code+"&nd_to_ward_code="+nd_to_ward_code+"&nd_fr_diet_type="+nd_fr_diet_type+"&nd_to_diet_type="+nd_to_diet_type+"&nd_fr_meal_class="+nd_fr_meal_class+"&nd_to_meal_class="+nd_to_meal_class+"&nd_fr_pat_id="+nd_fr_pat_id+"&nd_to_pat_id="+nd_to_pat_id+"&P_MEAL_PLAN_SEQ_NO="+P_MEAL_PLAN_SEQ_NO+"&nd_from_bed_no="+nd_from_bed_no+"&nd_to_bed_no="+nd_to_bed_no+"&SearchFor="+SearchFor+"&nd_fr_feed_Type="+nd_fr_feed_Type+"&nd_to_feed_Type="+nd_to_feed_Type+"&nd_to_serv_date="+nd_to_serv_date+"&p_rep_duration="+p_rep_duration; // p_diet_category Added Against CRF-782 & KDAH-CRF-0352 & (nd_to_serv_date,p_rep_duration) Added Against AMS-CRF-0180		
				
				frm.submit();
		//}
}

// modified by N Munisekhar on 20-May-2013 against [IN039994]
function reset()
{
	 var formObj = parent.content.f_query_rep.MealStatisticsReport;
	 formObj.reset();
	 formObj.bedNumberFrom.disabled = true;
	 formObj.bedNumberTo.disabled = true;
	 formObj.mealPlanSeqNo.disabled = false;//MMS-DM-CRF-0044
	 formObj.SearchFor.style.visibility='visible';
      // Added against CRF-409
        var MealTicketfor = f_query_rep.document.getElementById("MealTicketfor").value;
	var isDateOption="";
	isDateOption = f_query_rep.document.getElementById("isDateOption").value;
	var dateOption="";
	
	if(MealTicketfor == 'Patient')
	{
		f_query_rep.document.getElementById("report_id").value = "DSRSTDMT";
		f_query_rep.document.getElementById("p_report_id").value = "DSRSTDMT";
		f_query_rep.document.getElementById("mealPlanSeqNo").disabled=false;
		f_query_rep.document.getElementById("SearchFor").style.visibility='visible'
		f_query_rep.document.getElementById("SearchForLabel").style.visibility='visible'
		//Added against KDAH-CRF-0352 Starts here
		var isMenuType=formObj.isMenuType.value;
		if(isMenuType=="true"){
			return false;
		}else{
			f_query_rep.document.getElementById("feedTypeLabel").style.visibility='visible'
			f_query_rep.document.getElementById("feedTypeFrom").style.visibility='visible'
			f_query_rep.document.getElementById("feedTypeTo").style.visibility='visible'
		}
		//Added against KDAH-CRF-0352 Ends here
	//Added against Start AMS-CRF-0180
	if(isDateOption=="true"){
		dateOption = formObj.document.getElementById("dateOption").value;
		f_query_rep.document.getElementById("toLabel").style.visibility = "visible";
		f_query_rep.document.getElementById("servingDate2").style.visibility = "visible";				
		f_query_rep.document.getElementById("reportRow").style.visibility = "visible";	
		f_query_rep.document.getElementById("imgDateFrom").style.visibility = "hidden";	
		f_query_rep.document.getElementById("imgMonthFrom").style.visibility = "hidden";
		f_query_rep.document.getElementById("servingDate1").value = f_query_rep.document.getElementById("servingDate").value;
		f_query_rep.document.getElementById("servingDate1").readOnly = true;		
	if(dateOption=="CD"){	
		f_query_rep.document.getElementById("servingDate1").readOnly = true;
		f_query_rep.document.getElementById("servingDate2").readOnly = true;	
		f_query_rep.document.getElementById("imgDateFrom").style.visibility = "hidden";
		f_query_rep.document.getElementById("imgMonthFrom").style.visibility = "hidden";	
		f_query_rep.document.getElementById("imgDateTo").style.visibility = "hidden";
		f_query_rep.document.getElementById("imgMonthTo").style.visibility = "hidden";
		f_query_rep.document.getElementById("servingDate2").value = f_query_rep.document.getElementById("servingDate").value;		
		f_query_rep.document.getElementById("searchPatTo").style.visibility = "visible";
		f_query_rep.document.getElementById("imgPatFrom").style.visibility = "hidden";
		f_query_rep.document.getElementById("patientIdTo").style.visibility = "visible";
		f_query_rep.document.getElementById("mealPlanRow").style.visibility = "visible";
		f_query_rep.document.getElementById("SearchFor").style.visibility='visible';
		f_query_rep.document.getElementById("SearchForLabel").style.visibility='visible';
		}			
	}
	//Added against End AMS-CRF-0180
	}
      // Added against CRF-409
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
		obj.focus();
		obj.select();
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

function checkTODate()
	{
 		var formObj=f_query_rep.document.forms[0];
		var fromDate= formObj.servingDate1.value;
		var toDate= formObj.servingDate2.value;
		var d1Arr = fromDate.split("/");
		var d2Arr = toDate.split("/");
		var errMsg = 'To Date should be Greater than or equal to From Date';
		if(parseInt(d2Arr[2],10)<parseInt(d1Arr[2],10)){
			alert(errMsg);
			return false;
		}
		else if(parseInt(d2Arr[2],10)==parseInt(d1Arr[2],10)){
			if(parseInt(d2Arr[1],10)<parseInt(d1Arr[1],10)){
					alert(errMsg);
					return false;
			}
			else if(parseInt(d2Arr[1],10)==parseInt(d1Arr[1],10)){
				if(parseInt(d2Arr[0],10)<parseInt(d1Arr[0],10)){
					alert(errMsg);
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
	
/* Added Against Start AMS-CRF-0180 */	
function dateDisable(obj){
		var serDate=obj.name;
		var servingDate = document.getElementById("servingDate").value;
		var locale = document.getElementById("locale").value;
		var enConvertDate = convertDate(obj.value,"DMY",locale,"en");
		var dateArr = enConvertDate.split("/");
		var date1 = new Date(dateArr[2],dateArr[1]-1,dateArr[0]);
		var today = new Date();	
			if(date1>today){
				if(serDate==document.getElementById("servingDate1").name){
					document.getElementById("servingDate1").value = "";
					alert("From Date cannot be greater than System Date");
					obj.focus();
					obj.select();
				return;
				}else if(serDate==document.getElementById("servingDate2").name){
					document.getElementById("servingDate2").value = "";
					alert("To Date cannot be greater than System Date");
					obj.focus();
					obj.select();
				return;
				}				
			}
}	
/* Added Against End AMS-CRF-0180 */
function localTrimString(sInString)
{
	  return sInString.replace(/^\s+|\s+$/g,"");
}

