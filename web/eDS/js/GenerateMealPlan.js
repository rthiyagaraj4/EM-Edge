var allSelected = new Array();//Added against MMS-DM-CRF-0043
function run()
{
	var frm=at_tab_frame.record_details_frame.document.forms[0];		
	//GDOH-CRF-0083 starts
	var fields = new Array ();
	var tab_id = frm.tab_id.value;
	fields[0]=frm.servingDate;
		
	var servDate=getLabel("eOT.ServingDate.Label","ot");
	var servToDate=getLabel("eOT.ServingToDate.Label","ot");
	var names = new Array ();
	if(tab_id=='GenerateMealPlan'){
	servDate=getLabel("eOT.ServingFromDate.Label","ot");
	fields[1]=frm.servingToDate;
	names[1]=servToDate;
	}
	names[0]=servDate;
	//GDOH-CRF-0083 ends
	var today = new Date(); 
	var dd = today.getDate();
	if(dd<10){
		dd='0'+dd;
	} 
	var mm = today.getMonth()+1;//January is 0! 
	if(mm<10){
		mm='0'+mm;
	}
	var yyyy = today.getYear(); 
		
	var da = dd+"/"+mm+"/"+yyyy;
	var chkDtVal = chkDt1Dt2(da,frm.servingDate.value);
	if(!chkDtVal){
		if(tab_id!='DietOrderSheet') {
			var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArray = msg.split("#");
			var theatre_label = getLabel("eOT.ServingDate.Label","OT");
			var current_label = getLabel("Common.CurrentDate.label","common");
			alert(msgArray[0]+theatre_label+msgArray[1]+current_label+msgArray[2]);
			return false;
		}
	}
		
	//GDOH-CRF-0083 starts
	if(tab_id=='GenerateMealPlan'){
		chkDtVal=chkDt1Dt2(frm.servingDate.value,frm.servingToDate.value);
		if(!chkDtVal){
			var error="";
			var msg = getMessage("APP-OT0148","OT");
				var msgArray = msg.split("#");
				var theatre_label = getLabel("eOT.ServingFromDate.Label","OT");
				var current_label = getLabel("eOT.ServingToDate.Label","OT");
				//error=msgArray[0]+theatre_label+msgArray[1]+current_label+msgArray[2];
				error=msgArray[0]+current_label+msgArray[1]+theatre_label+msgArray[2];
				messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			return false;
		}
		//checking the difference between serving from date and serving to date is less than 7 days or not
			
		//checkDateDiff
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=checkDateDiff&StartTime="+frm.servingDate.value+"&EndTime="+frm.servingToDate.value;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);		
		//alert(retVal);
		if(retVal>7)
		{
			var error="Serving Date Range should be maximum 7 days";
			messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			return false;
		}	
					
		//return;
			
	}
	//GDOH-CRF-0083 ends
		
	if(checkFieldsofMst( fields, names, messageFrame))
	{
		if(tab_id=='GenerateMealPlanPrint'){
			var p_facility_id = frm.p_facility_id.value;
			var p_user_id = frm.p_user_id.value;
			var p_user_name = frm.p_user_name.value;
			var p_module_id = frm.p_module_id.value;
			var p_report_id = frm.p_report_id.value;
			var p_language_id = frm.p_language_id.value;
			var locale = frm.locale.value; //40625
			var pgm_id = frm.pgm_id.value;
			var p_user=frm.p_user.value;//55878					
			var nd_diet_category=frm.dietCategory.value;
			var nd_fr_meal=frm.mealType.value;
			var nd_to_meal=frm.mealType.value;
			var nd_fr_meal_class=frm.mealClass.value;
			var nd_to_meal_class=frm.mealClass.value;
			var nd_fr_diet_type=frm.dietType.value;
			//var nd_to_diet_type=frm.dietType.value;
			var nd_to_diet_type='';//MMS-DM-CRF-0043	
			var nd_fr_ward_code=frm.nursingUnit.value;
			var nd_to_ward_code=frm.nursingUnit.value;
			var P_MEAL_PLAN_SEQ_NO =frm.listNo.value;
			var servingDate =frm.servingDate.value;
			servingDate=convertDate(servingDate,'DMY',locale,'en');
			var frequencyYn = (frm.frequencyYn.checked)?'Y':'N';
					
			//KDAH-CRF-0352
			var nd_fr_feed_Type ="";
			var nd_to_feed_Type ="";
			var isMenuType=frm.isMenuType.value;
			if(!isMenuType=="true")
			{
				nd_fr_feed_Type = frm.feedType.value;
				nd_to_feed_Type = frm.feedType.value;
			}
			else
			{
				nd_fr_feed_Type = "";
				nd_to_feed_Type = "";
			}			
			//KDAH-CRF-0352
					
			//Added against MMS-DM-CRF-0043					
			var dietTypeList = frm.dietType;
			var p_diet_type="";
			var count = 0;
			for (var i = 0; i < dietTypeList.options.length; i++){
			  if (dietTypeList.options[i].selected){
				  count++;
				  if (count == 1) {
					  if(dietTypeList.options[i].value == "All"){
						  p_diet_type = '\',\'';
					  }else{
						  p_diet_type=p_diet_type+dietTypeList.options[i].value+'\',\'';
					  }
				  }
				  else{
						p_diet_type=p_diet_type+dietTypeList.options[i].value+'\',\'';
				  }
			  }
			}
			p_diet_type=p_diet_type.substring(0,p_diet_type.length-3);				
					
			//IN::40625
			frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_user_id="+p_user_id+"&p_user="+encodeURIComponent(p_user)+"&pgm_id="+pgm_id+"&facility_id="+p_facility_id+ 					"&p_kitchen_code_from=&p_kitchen_code_to=&nd_fr_pat_id=&nd_to_pat_id="+								"&locale="+locale+"&nd_diet_category="+nd_diet_category+"&nd_fr_meal="+nd_fr_meal+"&nd_to_meal="+nd_to_meal+"&nd_fr_meal_class="+nd_fr_meal_class+"&nd_to_meal_class="+nd_to_meal_class+"&nd_fr_diet_type="+p_diet_type+"&nd_to_diet_type="+nd_to_diet_type+								"&nd_fr_ward_code="+nd_fr_ward_code+"&nd_to_ward_code="+nd_to_ward_code+"&P_MEAL_PLAN_SEQ_NO="+P_MEAL_PLAN_SEQ_NO+"&nd_serv_date="+servingDate+"&freq_Yn="+frequencyYn+"&nd_fr_feed_Type="+nd_fr_feed_Type+"&nd_to_feed_Type="+nd_to_feed_Type;//KDAH-CRF-0352					
		}
		else if(tab_id=='DietOrderSheet')
		{
			//frm.action =  '../../servlet/eDS.GenerateMealPlanServlet?tab_id='+tab_id;
			 /* Added Against Start KDAH-CRF-0353 US1 */
	
	var mealType = frm.mealType.value;
	if(mealType==null)
	mealType="";
	var isDtCat_MlCls = frm.isDtCat_MlCls.value;
	if(isDtCat_MlCls == "true"){
		var reportValid = frm.reportStatus.value; //fixed 	
		if(reportValid=="S"){		
			if(mealType==""){
				var mealType_label=getLabel("eOT.MealType.Label","Common");
				var error = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",mealType_label);
				messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				return false;
			}
		}else if(reportValid=="D"){	
			var error = getMessage("DS_DETAIL_REPORT_FOR_EXCEL","DS");
			messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			return false;
		}
	}
	/* Added Against End KDAH-CRF-0353 US1 */
			var p_facility_id = frm.p_facility_id.value;
			var p_user_id = frm.p_user_id.value;
			var p_user_name = frm.p_user_name.value;
			var p_module_id = frm.p_module_id.value;
			var p_report_id = frm.p_report_id.value;
			var p_language_id = frm.p_language_id.value;
			var locale = frm.locale.value;
			var pgm_id = frm.pgm_id.value;
			var nd_diet_category=frm.dietCategory.value;
			var nd_frm_kitchen = frm.kitchen.value;
			var nd_to_kitchen = frm.kitchen.value;
			var nd_fr_meal=frm.mealType.value;
			var nd_to_meal=frm.mealType.value;
			var nd_fr_meal_class=frm.mealClass.value;
			var nd_to_meal_class=frm.mealClass.value;
			var nd_fr_diet_type=frm.dietType.value;
			var nd_to_diet_type=frm.dietType.value;
			var nd_fr_ward_code=frm.nursingUnit.value;
			var nd_to_ward_code=frm.nursingUnit.value;
			var nd_patient_id = frm.patientId.value;
			var servingDate=frm.servingDate.value;
			var status = frm.status.value;
			servingDate=convertDate(servingDate,'DMY',locale,'en');
			//Added against MMS-DM-CRF-0043					
			var dietTypeList = frm.dietType;
			var p_diet_type="";
			var count = 0;
			for (var i = 0; i < dietTypeList.options.length; i++){
			  if (dietTypeList.options[i].selected){
				  count++;
				  if (count == 1) {
					  if(dietTypeList.options[i].value == "All"){
						  p_diet_type = '\',\'';
					  }else{
						  p_diet_type=p_diet_type+dietTypeList.options[i].value+'\',\'';
					  }
				  }
				  else {
					  p_diet_type=p_diet_type+dietTypeList.options[i].value+'\',\'';
				  }
			  }
			}
			p_diet_type=p_diet_type.substring(0,p_diet_type.length-3);
			//Added against MMS-DM-CRF-0043
			//Added Against MMS-JU-SCF-0174 Starts
			var isDietReport=frm.isDietReport.value;
			if(isDietReport==true || isDietReport=='true') //19767
			{
		 var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=DietOrderSheet&p_facility_id="+p_facility_id+"&nd_dt_category="+nd_diet_category+"&p_kitchen_code="+nd_frm_kitchen+"&nd_meal_type="+nd_fr_meal+"&nd_meal_class="+nd_fr_meal_class+"&nd_diet_type="+p_diet_type+"&nd_ward_code="+nd_fr_ward_code+"&nd_flag="+status+"&nd_serv_date="+servingDate+"&nd_patient_id="+nd_patient_id+"&p_language_id="+p_language_id;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);	
		if(retVal=="S")
			{
			frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&pgm_id="+pgm_id+
			"&nd_dt_category="+nd_diet_category+"&p_kitchen_code="+nd_frm_kitchen+"&nd_meal_type="+nd_fr_meal+"&nd_meal_class="+nd_fr_meal_class+"&nd_diet_type="+p_diet_type+
			"&nd_ward_code="+nd_fr_ward_code+"&nd_flag="+status+"&nd_serv_date="+servingDate+"&nd_patient_id="+nd_patient_id;
			}

		}
				//Added Against MMS-JU-SCF-0174 Ends
		else
		{
			frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&pgm_id="+pgm_id+
			"&nd_dt_category="+nd_diet_category+"&p_kitchen_code="+nd_frm_kitchen+"&nd_meal_type="+nd_fr_meal+"&nd_meal_class="+nd_fr_meal_class+"&nd_diet_type="+p_diet_type+
			"&nd_ward_code="+nd_fr_ward_code+"&nd_flag="+status+"&nd_serv_date="+servingDate+"&nd_patient_id="+nd_patient_id;
		}
			}
			else
			{
				frm.action =  '../../servlet/eDS.GenerateMealPlanServlet?tab_id='+tab_id;
			}
		
		
		frm.submit();
	}
}

function reset()
{
	at_tab_frame.location.reload();
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
			//var theatre_label = getLabel("eOT.ServingDate.Label","OT");
			var theatre_label = "";
			//GDOH-CRF-0083 Starts
					
			var frm=document.forms[0];		
			var tab_id = frm.tab_id.value;
			if(da1.name=="servingDate"){
				if(tab_id=="GenerateMealPlan"){
				theatre_label=getLabel("eOT.ServingFromDate.Label","OT");
				}else{
				theatre_label = getLabel("eOT.ServingDate.Label","OT");
				}
			}else if(da1.name=="servingToDate")
			{
				theatre_label=getLabel("eOT.ServingToDate.Label","OT");
			}					
					
			var current_label = getLabel("Common.CurrentDate.label","common");
			alert(msgArray[0]+theatre_label+msgArray[1]+current_label+msgArray[2]);
			$("#"+da1.name).focus();
			$("#"+da1.name).select();					
			return false;
			//GDOH-CRF-0083 Ends
		}
	}
	}
}

//added by N Munisekhar on 28-May-2013 against [IN39969]
function maxMealPlandDate(from)
{ 
    var theDate = new Date();
	var maxMealPlan=parseInt(document.GenerateMealPlanForm.maxMealPlan.value);
    theDate.setDate(theDate.getDate()+maxMealPlan);
	var mon = theDate.getMonth()+1;
	var to =theDate.getDate()+"/"+mon+"/"+theDate.getYear();
	var frdt = from.value;
	var greg_tdt = "";
	var greg_frdt = "";
	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
	}

	if(to !="" && validDate(to,"DMY","en"))
	{
		greg_tdt = convertDate(to,"DMY",localeName,"en");
	}
	
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(!isAfter(greg_tdt,greg_frdt,"DMY","en"))
		{
			//Commented for GDOH-CRF-0083 		
			//alert(getMessage("DS_SERVGDATE_LIMIT","DS"));
			/*document.forms[0].servingDate.focus();
			document.forms[0].servingDate.select();*/
			//GDOH-CRF-0083 Starts
			var msg = getMessage("DS_SERVGDATE_LIMIT","DS");
				var msgArray = msg.split("#");
				var label="";
				if(from.name=="servingDate"){
					label=getLabel("eOT.ServingFromDate.Label","OT");
					
				}else if(from.name=="servingToDate"){
					label=getLabel("eOT.ServingToDate.Label","OT");
				}		
				alert(label+msgArray[1]);
			
				$("#"+from.name).focus();
				$("#"+from.name).select();
			//GDOH-CRF-0083 Ends
			
		}
	}
}
//End of  [IN39969]

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
		obj.focus();
		obj.select();
		return null;
}

function chkDt1Dt2(d1,d2)
{
		var d1Arr = d1.split("/");
		var d2Arr = d2.split("/");
		if(parseInt(d2Arr[2],10)<parseInt(d1Arr[2],10)){ //IN::39863
			return false;
		}
		else if(parseInt(d2Arr[2],10)==parseInt(d1Arr[2],10)){
			if(parseInt(d2Arr[1],10)<parseInt(d1Arr[1],10)){
					return false;
			}
			else if(parseInt(d2Arr[1],10)==parseInt(d1Arr[1],10)){
				if(parseInt(d2Arr[0],10)<parseInt(d1Arr[0],10)){
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

//Added against MMS-DM-CRF-0043
function selectAll(selectedAll)
{
		var formObj = document.forms[0];
		var dietType = formObj.dietType;
		if(selectedAll == "All")
		{
			var k=0;
			for(i=1;i<dietType.length;i++){
				allSelected[k] = ""+'\''+dietType.options[i].value+'\'';
				k++;
			}
			document.getElementById("selectedAll").value = allSelected;
		}else
			return;
}
//Added against MMS-DM-CRF-0043
function localTrimString(sInString) {
		  return sInString.replace(/^\s+|\s+$/g,"");
		}

/* Added Against Start KDAH-CRF-0353 US1 */		
function reportOrExcel(obj){
	if(obj.value == "D")
	{
		document.forms[0].status.disabled=true;
		document.forms[0].status.value="A";			
		document.getElementById("excel").style.visibility = "visible";
		document.getElementById("mandatory").style.visibility = "hidden";//Added Inc-68899
	}else{
		document.forms[0].status.disabled=false;		
		document.forms[0].status.value="A";		
		document.getElementById("excel").style.visibility = "hidden";
		document.getElementById("mandatory").style.visibility = "visible";//Added Inc-68899
	}
}

function callExcelDisplay(){
	var frm=window.parent.frames[0];
	formObj = document.GenerateMealPlanForm;
	var p_module_id = formObj.p_module_id.value;
	var p_facility_id = formObj.p_facility_id.value;
	var p_report_id = formObj.p_report_id.value; 
	var locale = formObj.locale.value; 
	var patientId = formObj.patientId.value; 
	var servingDate=formObj.servingDate.value; 
	servingDate=convertDate(servingDate,'DMY',locale,'en');
	var kitchen = document.getElementById("kitchen");
	var kitchenText = kitchen.options(kitchen.selectedIndex).text;
	var kitchenVal = kitchen.options(kitchen.selectedIndex).value;

	var mealClass = document.getElementById("mealClass");
	var mealClassText = mealClass.options(mealClass.selectedIndex).text;
	var mealClassVal = mealClass.options(mealClass.selectedIndex).value;

	var nursingUnit = document.getElementById("nursingUnit");
	var nursingUnitText = nursingUnit.options(nursingUnit.selectedIndex).text;
	var nursingUnitVal = nursingUnit.options(nursingUnit.selectedIndex).value;
	
	var dietCategory = document.getElementById("dietCategory");
	var dietCategoryText = dietCategory.options(dietCategory.selectedIndex).text;
	var dietCategoryVal = dietCategory.options(dietCategory.selectedIndex).value;
	
	var mealType = document.getElementById("mealType");
	var mealTypeText = mealType.options(mealType.selectedIndex).text;
	var mealTypeVal = mealType.options(mealType.selectedIndex).value;
	
	var dietType = document.getElementById("dietType");
	if(dietType.value!=""){
	var dietTypeText = dietType.options(dietType.selectedIndex).text;
	var dietTypeVal = dietType.options(dietType.selectedIndex).value;
	}
	var status = formObj.status.value;
	var p_report_id = formObj.p_report_id.value;
	tmpformObj = document.dummy1;
	
	var dietTypeList = dietType;
			var p_diet_type="";
			var count = 0;
			for(var i = 0; i < dietTypeList.options.length; i++){
			  if(dietTypeList.options[i].selected){
				  count++;
				  if(count == 1){
					  if(dietTypeList.options[i].value == "All"){
						  p_diet_type = '\',\'';
					  }else{
						  p_diet_type=p_diet_type+dietTypeList.options[i].value+'\',\'';
					  }
				  }
				  else{
						p_diet_type=p_diet_type+dietTypeList.options[i].value+'\',\'';
				  }
			  }
			}

			p_diet_type=p_diet_type.substring(0,p_diet_type.length-3);				

			if(p_diet_type.length==1)
			  p_diet_type="";
	var qryHeader = "SELECT DISTINCT serving_date, a.meal_type ,b.short_desc meal_type_desc, b.meal_order FROM ds_epsd_meal_plan_hdr a,ds_meal_type_lang_vw b, pr_encounter c WHERE operating_facility_id = '"+p_facility_id+"' AND serving_date = TO_DATE ( '"+servingDate+"', 'DD/MM/YYYY') AND a.meal_type = b.meal_type AND b.language_id = '"+locale+"' AND a.operating_facility_id = c.facility_id AND a.encounter_id = c.encounter_id AND a.diet_category_code LIKE UPPER (NVL ('"+dietCategoryVal+"', '%')) AND a.kitchen_code LIKE UPPER (NVL ('"+kitchenVal+"', '%')) AND a.meal_type LIKE UPPER (NVL ('"+mealTypeVal+"', '%')) AND a.meal_class LIKE UPPER (NVL ('"+mealClassVal+"', '%'))  AND c.assign_care_locn_code LIKE UPPER (NVL ('"+nursingUnitVal+"', '%')) AND c.patient_id LIKE UPPER (NVL ('"+patientId+"', '%')) ";		

	if(p_diet_type!=""){
	qryHeader =  qryHeader + " AND a.diet_type IN ('"+p_diet_type+"') " ;
	}
	qryHeader =  qryHeader + " ORDER BY b.meal_order " ;
	
	var qryStr = "SELECT a.assign_bed_num, a.patient_id, c.patient_name, get_age (c.date_of_birth) age, ds_get_desc.ds_diet_type(b.diet_type,'"+locale+"','2') diet_type_desc,  b.nil_by_mouth_frm || ' - ' || b.nil_by_mouth_to nbm, b.prep_instr prep_instruction, dietary_remarks, b.remarks, ds_get_desc.ds_meal_type(d.meal_type,'"+locale+"','2') meal_type_desc, f.meal_order, ds_meal_items('"+p_facility_id+"', a.encounter_id, d.serving_date, d.meal_type, '"+locale+"') food_item_desc FROM pr_encounter a, ds_epsd_diet_profile_hdr b, mp_patient c, ds_epsd_meal_plan_hdr d, ds_meal_type f WHERE a.patient_id    = b.patient_id AND a.encounter_id  = b.encounter_id AND a.patient_id = c.patient_id AND a.facility_id   = b.operating_facility_id    AND a.facility_id   = '"+p_facility_id+"' AND a.facility_id   = d.operating_facility_id AND a.encounter_id  = d.encounter_id AND b.patient_class = d.patient_class AND d.meal_type = f.meal_type AND NVL(b.status,'#') != 'X' AND TO_DATE ('"+servingDate+"', 'DD/MM/YYYY') BETWEEN period_from AND NVL (period_to, TO_DATE ('31/12/5000','DD/MM/YYYY')) AND TRUNC (d.serving_date) = TO_DATE ('"+servingDate+"', 'DD/MM/YYYY') AND a.assign_care_locn_code LIKE UPPER (NVL ('"+nursingUnitVal+"', '%')) AND b.meal_class LIKE UPPER (NVL ('"+mealClassVal+"', '%')) AND a.patient_id LIKE UPPER (NVL ('"+patientId+"', '%')) AND d.kitchen_code LIKE UPPER (NVL ('"+kitchenVal+"', '%')) AND d.meal_type LIKE UPPER (NVL ('"+mealTypeVal+"', '%')) AND b.diet_category LIKE UPPER (NVL ('"+dietCategoryVal+"', '%')) AND d.meal_type not in (select meal_type from ds_meal_type_exclusions where encounter_id = b.encounter_id and profile_sl = b.profile_sl and excluded_date = TO_DATE('"+servingDate+"','DD/MM/YYYY')) ";
	if(p_diet_type!=""){
	qryStr =  qryStr + " AND d.diet_type IN ('"+p_diet_type+"') " ;
	}
	qryStr = qryStr + " order by a.assign_care_locn_code, a.assign_bed_num,a.patient_id, meal_order ";
	
	var sql_site_name="SELECT SITE_NAME  FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID= '"+locale+"' ";
	var sql_facility_name="SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE  FACILITY_ID ='"+p_facility_id+"' ";
	var sql_report_desc="SELECT REPORT_DESC FROM SM_REPORT WHERE  REPORT_ID = '"+p_report_id+"' AND  MODULE_ID  = '"+p_module_id+"' ";
	
	/* Header Details - 8 */
	var servingDateHdr  	=getLabel("eOT.ServingDate.Label","OT");
	var KitchenHdr     		=getLabel("eDS.Kitchen.Label","DS");
	var mealClassHdr     	=getLabel("eDS.MealClass.Label","DS");	
	var nursingUnitHdr  	=getLabel("eOT.NursingUnit.Label","OT");
	var statusHdr			=getLabel("Common.status.label","Common");
	var dietCategoryHdr		=getLabel("eDS.DietCategory.Label","DS");
	var mealTypeHdr			=getLabel("eDS.MealType.Label","DS");
	var dietTypeHdr			=getLabel("eDS.DietType.Label","DS");	
	var DietOrderSheetHdr   =getLabel("eOT.DietOrderSheet.Label","OT");	
	
	
	if(kitchenVal=="")
		kitchenText="ALL";
	if(mealClassVal=="")
		mealClassText="ALL";
	if(nursingUnitVal=="")
		nursingUnitText="ALL";	
	if(status=="" || status=="A")
		status="ALL";	
	if(dietCategoryVal=="")
		dietCategoryText="ALL";		
	if(mealTypeVal=="")
		mealTypeText="ALL";	

	var header_Details = servingDateHdr+"*"+servingDate+"*"+KitchenHdr+"*"+kitchenText+"*"+mealClassHdr+"*"+mealClassText+"*"+nursingUnitHdr+"*"+nursingUnitText+"*"+statusHdr+"*"+status+"#"+dietCategoryHdr+"*"+dietCategoryText+"*"+mealTypeHdr+"*"+mealTypeText;

	if(dietType.value=="" || dietType.value==undefined){
		dietTypeText="ALL";
	}
	if(dietTypeText=="All" || dietTypeText=="" || dietTypeText=="ALL"){
			header_Details = header_Details+"*"+dietTypeHdr+"*"+dietTypeText;
	}		
	
	 tmpformObj.header_Details.value=header_Details;
	 tmpformObj.sql_site_name.value=sql_site_name;
	 tmpformObj.sql_facility_name.value=sql_facility_name;
	 tmpformObj.sql_report_desc.value=sql_report_desc;
	 tmpformObj.qryStr.value = qryStr;
	 tmpformObj.qryHeader.value = qryHeader;
	 tmpformObj.noOfCols.value = "15";
	 tmpformObj.method = 'POST';
	 tmpformObj.action='../../servlet/eDS.DsRegistryReportsServlet?servingDate='+servingDate;
	 tmpformObj.submit();
}
 /* Added Against End KDAH-CRF-0353 US1 */  
