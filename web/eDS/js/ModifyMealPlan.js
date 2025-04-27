	var meal_Category_Value;
	var patient_Class_Value;
	var meal_plan_hdr_status;
	var lengthCheck = new Array();
	var required_Duplicate_Check = 0;
	//var contentList =new Hashtable();
	
	function create(){
		f_query_add_mod.location.href="../../eDS/jsp/ModifyMealPlanFrame.jsp?";	
	}

	function apply() {
		var error;
		if(parent.content.f_query_add_mod.ModifyMealPlanSearch != null) {
			var formObj = parent.content.f_query_add_mod.ModifyMealPlanSearch.document.forms[0];
			var formObj1 = parent.content.f_query_add_mod.ModifyMealPlanCud.document.forms[0];
			var status = parent.content.f_query_add_mod.ModifyMealPlanCud.document.getElementById("status").value;
			var totrecords = parent.content.f_query_add_mod.ModifyMealPlanSearch.document.getElementById("listContentTable").rows.length-1;
			//MMS-KH-CRF-0029.1-US009 Start
			var formObj2 = parent.content.f_query_add_mod.ModifyMealPlanItem;
			var remarksAlert = formObj2.document.getElementById("remarksAlert").value;
			var remarksVal   = formObj2.document.getElementById("remarksVal").value;
			var enbDrugYN 	 = formObj2.document.getElementById("enableDrugYN").value;
			var onLoadRem 	 = parent.content.f_query_add_mod.ModifyMealPlanSearch.document.getElementById("onLoadRem").value;
			//MMS-KH-CRF-0029.1-US009 End
			
			if(totrecords<1) {
				error = getMessage("ATLEAST_ONE_SELECTED","common");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
				return false;
	        }
			//MMS-KH-CRF-0029.1-US009 Start
			if(remarksAlert == 'Y' && (remarksVal == '' || remarksVal == null)) {
				if(onLoadRem == "null" || onLoadRem == null ||  onLoadRem == ""){
					alert(getMessage("DS_REM_NOT_BLANK","DS"));
					formObj2.document.getElementById('remarks').focus();
					error = "";
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
					return;
				}
	        }
			//MMS-KH-CRF-0029.1-US009 End
			formObj.method='post';
			formObj.action="../../servlet/eDS.ModifyMealPlanServlet?status="+status+"&totalRecords="+totrecords+"&enableDrugYN="+enbDrugYN+"&remarksVal="+remarksVal;
			formObj.submit();
		}
		else {
			var error = "";
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
			return false;
		}
	}

	function onSuccess()
	{	
     f_query_add_mod.location.reload();
	}

	function showCalForNonFreq(i, id, format, showsTime, showsOtherMonths, name) {
	fmt = format;
	{
		calend = format;
		if (showsTime) {
			time = true;
		} else {
			time = false;
		}

		var cal;
		currentDateElement = document.getElementById(id);
		cal = new PopupWindow();
		cal.offsetX = 50;
		cal.offsetY = 50;
		cal.setSize(250, 200);
		cal.autoHide();
		cal.setUrl("../../framework/jsp/Calendar.jsp");
		cal.refresh();
		cal.showPopup(name);
		return false;
	}
}

	function reset(){
		var formObj=parent.content.f_query_add_mod.ModifyMealPlanCud.document.forms[0];
		var formObj1=parent.content.f_query_add_mod.ModifyMealPlanSearch.document.forms[0];
		var formObj2=parent.content.f_query_add_mod.ModifyMealPlanItem.document.forms[0];
		formObj.reset();
		formObj1.reset();
		formObj2.reset();
	}

	function callStatus(){
	//IN:39963 
		//if(document.getElementById("status").checkéed==true){
			//document.getElementById("status").value="9";
		if(document.getElementById("status").checked==true){
			document.getElementById("status").value="9";
		}else if(document.getElementById("status").checked==false){
			document.getElementById("status").value="";
		}
	}

	//IN:39963 
	function fetchStatusValue(statusValue)
	{ 
		if(statusValue == 'Y')
		{
			parent.ModifyMealPlanCud.document.forms[0].status.checked = true;
			parent.ModifyMealPlanCud.document.forms[0].status.value = 'Y';
		}else
		{
			parent.ModifyMealPlanCud.document.forms[0].status.checked = false;
			parent.ModifyMealPlanCud.document.forms[0].status.value = 'N';
		}
	}
	// modified by Subhani on 09-07-2013 against [INC 41451]
	function getItemDetails(item_slr,item_Type,item_Code,short_Desc,spl_Food_Item_Yn,freq_Yn,rowCount){
		var item_Qty = document.getElementById("item_Qty"+rowCount).innerText;
		parent.ModifyMealPlanItem.document.forms[0].srlNo.value = item_slr;
		parent.ModifyMealPlanItem.document.forms[0].itemType.value = item_Type;
		parent.ModifyMealPlanItem.document.forms[0].itemDesc.value = short_Desc;
		parent.ModifyMealPlanItem.document.forms[0].itemCode.value = item_Code;
		parent.ModifyMealPlanItem.document.forms[0].itemQty.value = item_Qty;
		parent.ModifyMealPlanItem.document.forms[0].rowCount.value = rowCount;

		parent.ModifyMealPlanItem.document.forms[0].srlNo.disabled = true;
		parent.ModifyMealPlanItem.document.forms[0].itemType.disabled = true;
		parent.ModifyMealPlanItem.document.forms[0].itemDesc.disabled = true;
		parent.ModifyMealPlanItem.document.forms[0].splFoodItem.disabled = true;
		parent.ModifyMealPlanItem.document.forms[0].freq.disabled = true;
	}

function isValidDate(obj){
	if(obj.value!=""){
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

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}

	function isValidMonth(obj){
		var RE_NUM =/^\d{2}\/+\d{4}$/
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		var dt_date = new Date();	
		var flag=true;
	if(obj.value!=""){
		if(!RE_NUM.test(str_date) && arr_date.length!=2) flag=false;
		if (arr_date[0] < 1 || arr_date[0] > 12) flag=false;
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=4 ) flag=false;
		}
		
		if(flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
		var flag1=false;
		if( arr_date[1]<dt_date.getFullYear() ) flag1=false;	
		if(flag==false){
			alert(getMessage("MONTH_COMPARE_CURMONTH","OT"));
			return false;
		}
	}
	return true
	}

	function isValidTime(obj){
		var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
		if(obj.value!="" && !RE_EXP.test(obj.value) ){
			var err_text="";
			var time = obj.value;
			var arr_time =  time.split(":")
			if(arr_time.length!=2){
				cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
			}
			if(  isNaN(arr_time[0]) || isNaN(arr_time[1]) ){
				cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
			}
			if(arr_time[0]<0 || arr_time[0]>23 ){
				err_text+=getMessage("APP-OT0040","OT");
			}
			if(arr_time[1]<0 || arr_time[1]>59 ){
				err_text+=getMessage("APP-OT0041","OT");
			}
			if(err_text.length>0)	
				cal_error(err_text,obj);
			}
			return true
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
/*
	function CheckNumber(obj) {
		if(obj.value == "")
			return true;
		if(isNaN(obj.value) == false && obj.value >= 0) 
			return true;
		else{
				var error = f_query_add_mod.getMessage('ONLY_POSITIVE_NUM','SM');
  				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
  				obj.select();
	  			obj.focus();
	  			return false;
  		}
	} */
	function CheckNumber(){
	 obj =  String.fromCharCode(window.event.keyCode);
		var alphaFilter =/^[0-9]+$/;
		
		if (!(alphaFilter.test(obj))||((obj.charCodeAt(0)==48)&&(document.ModifyMealPlan_Item.itemQty.value.length==0))){ 
		  alert(getMessage("ONLY_POSITIVE_NUM", "SM"));
			//alert("Special Characters,Zero and Negative Values are not Allowed");
		    window.event.keyCode = 27;
		
		}
	   }

	function setFlagToInsert(){
		document.getElementById("splFoodItem").disabled=true;
		document.getElementById("freq").disabled=true;
	}
	function callLookUp(){
		if (document.getElementById("itemCode").value != "")
			showLookup();
	}

	async function showLookup(obj,target){
	var formObj = document.forms[0];
	var itemType = formObj.itemType.value;
	var locale = formObj.locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.item.label","common");

	var sql="select FOOD_ITEM_CODE CODE,SHORT_DESC DESCRIPTION from Ds_Items where item_type like '"+itemType+"' and language_Id = '"+locale+"' and upper(SHORT_DESC) like UPPER(?) and upper(FOOD_ITEM_CODE) like UPPER(?)";

    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
		}		
	}

	function showModifyMealPlanRecords(){
		var servingDate = document.ModifyMealPlan_form.service_date.value;
		var freq;		
		var kitchenCode=document.forms[0].kitchenCode.value;
		var encounterId=document.forms[0].encounter_id.value;
		var dietType=document.forms[0].dietType.value;
		var mealType=document.forms[0].mealType.value;
		var facilityId=document.forms[0].facility_id.value;
		var locale=document.forms[0].locale.value;
		//Added for MMS-KH-CRF-0029.1-US009 Start
		var enbDrugYN=parent.frames[1].document.getElementById("enableDrugYN").value;
		//Added for MMS-KH-CRF-0029.1-US009 End
	
		if(document.getElementById("frequency").checked){			
			document.getElementById("frequency").value="Y";
			freq="Y";
			var dietType="";
			var mealType="";
		}else{
			var dietType=document.forms[0].dietType.value;
			var mealType=document.forms[0].mealType.value;
			document.getElementById("frequency").value="N";
			freq="N";
		}	
		
		//Added newly for testing on Nov 1
		/*var currentTime = new Date()
		var month = currentTime.getMonth() + 1
		var day = currentTime.getDate()
		var year = currentTime.getFullYear()
		if(month < 10)
			month="0"+month;
		if(day < 10)
			day="0"+day;
		var	sysDate = day+"/"+month+"/"+year;
		var returnVal =  compareDates1(sysDate,servingDate);
		if(returnVal == false){
			var errors = "APP-NF0011 "+" Serving Date should be greater than or equal to current date" + "<br>" ;
			parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;
			return false;
		}
		//Added newly for testing on Nov 1
		//if(freq =="N"){*/
		//}
		// modified by N Munisekhar on 21-May-2013 against [IN39611]
		var flag=checkNull();
		if(flag==true){
		//MMS-KH-CRF-0029.1-US009 Start
		if(enbDrugYN=='Y'){
			var formObj2 = parent.frames[1].document.forms[0];
			formObj2.document.getElementById("remarksAlert").value = "";
			formObj2.document.getElementById("remarksImg").style.visibility = 'hidden';
		}
		//MMS-KH-CRF-0029.1-US009 End
		parent.ModifyMealPlanSearch.location.href="../../eDS/jsp/ModifyMealPlanSearch.jsp?kitchenCode="+kitchenCode+"&encounterId="+encounterId+"&dietType="+dietType+"&mealType="+mealType+"&facilityId="+facilityId+"&servingDate="+servingDate+"&freq="+freq+"&enbDrugYN="+enbDrugYN;}
	}

	async function patientLookup()
	{	
		var patient_id	= await PatientSearch('','','','','','','Y','','','OTHER');		
		if(patient_id != null)
		{
			document.getElementById("patient_id").value = patient_id;			
		}
		encounterLookup();
	}

	async function PatientSearch(jsp_name,window_styl,close_yn,win_top,win_height,win_width,act_yn,srr,register_button_yn,func_act,dr_function_id) {
        if (window_styl == null || window_styl.length     == 0)         window_styl='O';
        if (close_yn    == null || close_yn.length         == 0)        close_yn='Y';
        if (jsp_name    == null || jsp_name.length        ==0   )   jsp_name='';
        if (win_top == null || win_top.length == 0) win_top= '61';
        if (win_height == null || win_height.length == 0) win_height= '500px';
        if (win_width == null || win_width.length == 0) win_width= '800px';
        if (act_yn == null || act_yn.length == 0) act_yn= 'N';
        if (register_button_yn == null || register_button_yn.length == 0) register_button_yn = 'N';
        if(func_act == null || func_act.length == 0) func_act='';
        if(dr_function_id == null || dr_function_id.length == 0) dr_function_id='';
        if (srr == null || srr.length == 0) srr='Y';
        window_styl = window_styl.toUpperCase();
        close_yn = close_yn.toUpperCase();
        act_yn = act_yn.toUpperCase();
		var url ="";
		url     =contextPath+"/eMP/jsp/ModelPatientSearch.jsp?jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_top="+win_top+"&win_height="+win_height+"&win_width="+win_width+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&func_act="+func_act+"&dr_function_id="+dr_function_id;
		var dialogTop   = "65";
        var dialogHeight    = "500px" ;
        var dialogWidth = "800px" ;
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
        var returnval =await window.showModalDialog( url, arguments, features );		
        return returnval;
	}

	function encounterLookup1(){
		if(document.getElementById("patient_id").value != ""){
			encounterLookup();
		}
	}

	function encounterLookup(){
		var patient_id = document.getElementById("patient_id").value;	
	
		//var sql=escape("SELECT ENCOUNTER_ID,PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS=?) EPISODE_TYPE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND PATIENT_ID=? AND PATIENT_CLASS=?");

		var sql=escape("SELECT ENCOUNTER_ID,PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS=?) EPISODE_TYPE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND PATIENT_ID=? AND PATIENT_CLASS=? and adt_status not in ('08','09') AND discharge_date_time IS NULL");//56537
		
		var dir_param = "sql="+sql+"&patient_class=IP&patient_id="+patient_id;		
		var xmlDoc = "" ;		
		var xmlHttp = new XMLHttpRequest() ;		
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("GET","../../eDS/jsp/PatientEncounterSearch.jsp?"+dir_param,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;	
		var retVal_arr = retVal.split("::");
		if(retVal_arr[0]==1){
			document.getElementById("encounter_id").value	= retVal_arr[1];
			document.getElementById("encounter_id").readOnly = true;
		}else{
			document.getElementById("encounter_id").value="";
			document.getElementById("encounter_id").readOnly = false;
		}
	}

	function chkFrequency(){
		if(document.getElementById("frequency").checked==true){
			document.getElementById("frequency").value="N";
			document.getElementById("dietType").disabled=true;
			document.getElementById("dietType").value="";
			document.getElementById("mealType").disabled=true;
			document.getElementById("mealType").value="";
			document.getElementById("mand1").style.visibility="hidden";
			document.getElementById("mand2").style.visibility="hidden";
		}else{
			document.getElementById("frequency").value="Y"
			document.getElementById("dietType").disabled=false;
			document.getElementById("mealType").disabled=false;
			document.getElementById("mand1").style.visibility="visible";
			document.getElementById("mand2").style.visibility="visible";
		}	
	}	

function cancelRecord(){	
		var srlNo=document.getElementById("srlNo").value;
		var itemType=document.getElementById("itemType").value;
		var itemDesc=document.getElementById("itemDesc").value;
		var itemQty=document.getElementById("itemQty").value;
		var splFoodItem=document.getElementById("splFoodItem").value;
		var freq=document.getElementById("freq").value;			
		var rowCount = document.forms[0].rowCount.value;
		var totalRows = parent.frames[2].document.getElementById("listContentTable").rows.length;		
		if(totalRows>0){			
			for(i=1;i<=totalRows;i++){				
		 var hdnI = i;
		 var selectedText = parent.frames[2].document.getElementById("listContentTable").rows[i].cells[0].innerText;
			 if(selectedText == srlNo){				
				if(i<=rowCount){
          // modified by N Munisekhar on 23-May-2013 against [IN39955]				
				resetFields();					
						parent.frames[2].document.getElementById("listContentTable").rows[i].cells[0].innerText = selectedText;
						parent.frames[2].document.getElementById("listContentTable").rows[i].cells[0].style.color = '#FF0000';
						parent.frames[2].document.getElementById("listContentTable").rows[i].cells[1].style.color = '#FF0000';
						parent.frames[2].document.getElementById("listContentTable").rows[i].cells[2].style.color = '#FF0000';
						parent.frames[2].document.getElementById("listContentTable").rows[i].cells[3].style.color = '#FF0000';
						parent.frames[2].document.getElementById("listContentTable").rows[i].cells[4].style.color = '#FF0000';
						parent.frames[2].document.getElementById("listContentTable").rows[i].cells[5].style.color = '#FF0000';
						
						var hdntxt = "mode"+hdnI;
						parent.frames[2].document.getElementById(hdntxt).value='delete';
					}
					/*else{
						document.getElementById("listContentTable").deleteRow(i);
						var rowCnt = document.getElementById("listContentTable").rows.length;
						if(rowCnt>1){
							var l = i+1;
							for(j=l;j<=rowCnt;j++){
								var k = j-1;
								nursingUnit = document.getElementById("listContentTable").rows[k].cells[0].innerText;						
								document.getElementById("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+nursingUnit+"</a>";
							}
						}
					}*/
					
					return true;
				}
				//document.mealAttendents.nursing_Unit.value = "";
				 //document.mealAttendents.noAttendents.value = 0;
			}
		}
		//document.mealAttendents.nursing_Unit.value = "";
		 //document.mealAttendents.noAttendents.value = 0;
		
		}
		// added by N Munisekhar on 23-May-2013 against [IN39955]
		function resetFields(){
		alert(document.forms[0].srlNo.value);
		document.forms[0].srlNo.value = "";
		document.forms[0].itemType.value = "";
		document.forms[0].itemDesc.value = "";
		document.forms[0].itemCode.value = "";
		document.forms[0].itemQty.value = "";
		document.getElementById("splFoodItem").checked = false;
		document.getElementById("freq").checked = false;
		//document.forms[0].splFoodItem.value = "";
		//document.forms[0].frequency.value ="";

		parent.ModifyMealPlanItem.document.forms[0].srlNo.disabled = false;
		parent.ModifyMealPlanItem.document.forms[0].itemType.disabled = false;
		parent.ModifyMealPlanItem.document.forms[0].itemDesc.disabled = false;
}

	function localTrimString(sInString) {	
		 sInString = sInString.replace( /^\s+/g, "" );// strip leading space
	  return sInString.replace(/^\s+|\s+$/g,"");
	}

	function checkNull(){		
		//var fieldName=new Array("service_date","kitchenCode","encounter_id","dietType","mealType","patient_id");
		//var fields=new Array(document.forms[0].service_date.value, document.forms[0].kitchenCode.value, document.forms[0].encounter_id.value, document.forms[0].dietType.value, document.forms[0].mealType.value,document.forms[0].patient_id.value);		
		var frequency = document.forms[0].frequency.value;
		// modified by N Munisekhar on 21-May-2013 against [IN39611]
		var flag;
		if(frequency =="Y"){
		var fieldName=new Array("Serving Date","Kitchen","Encounter ID");
		var fields=new Array(document.forms[0].service_date.value, document.forms[0].kitchenCode.value, document.forms[0].encounter_id.value);
		 	var errors="";
		 	for (j = 0; j < fields.length; j++) {
				if (fields[j] =="") {
                 flag=false;				
				//errors = errors + "APP-SM0073 " + fieldName[j] + " cannot be blank..." + "<br>" ;
                 errors = errors + getMessage("CAN_NOT_BE_BLANK","Common").replace("$", fieldName[j]) + "<br>" ;
			}
		}
		parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;
		if(flag==false) return false; else return true;
		}
		else{
		var fieldName=new Array("Serving Date","Kitchen","Encounter ID","Diet Type","Meal Type");
		var fields=new Array(document.forms[0].service_date.value, document.forms[0].kitchenCode.value, document.forms[0].encounter_id.value, document.forms[0].dietType.value, document.forms[0].mealType.value);
		 	var errors="";
		 	for (j = 0; j < fields.length; j++) {
				if (fields[j] =="") {	
                 flag=false;				
				//errors = errors + "APP-SM0073 " + fieldName[j] + " cannot be blank..." + "<br>" ;
                 errors = errors + getMessage("CAN_NOT_BE_BLANK","Common").replace("$", fieldName[j]) + "<br>" ;
			}
		}
		parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;
		if(flag==false) return false; else return true;
		}
	}

	function checkDate(flag){
		var data="";
		var obj=document.forms[0];	
		var locale = obj.locale.value;	
		var format ='DMY';
		if(flag=='1'){
			data=obj.service_date.value;
			var change_serv_date=dateUtils(data,locale,format);
			if(data == null || data == '') return false;
			data=changeDate(change_serv_date);
			var dat1=new Date(data);
			var dat2=new Date(obj.date_compare.value);
			if(dat1<=dat2){		
				//var errors = "APP-NF0011 "+" Serving Date should be greater than or equal to current date" + "<br>" ;
				var errors =  getMessage("DS_SERVDAT_GRTROREQL_CURDAT","DS") + "<br>" ;
				parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;
				return false;			
			}else
				return true;		
		}
 }

 //modified by N Munisekhar on 23-May-2013 against [IN39955]
 function vaidateFromTime(){
	var time1=document.getElementById("sheduleTime").value;
	var timeLenght1=time1.length;
	if(timeLenght1==0){
		getNumericFilterUpto2();
	}
	if(timeLenght1==1){
		if(time1.charAt(0)==0 || time1.charAt(0)==1 || time1.charAt(0)==2){
			if(time1.charAt(0)==0 || time1.charAt(0)==1){
				getNumericFilterUpto9();
			}
		if(time1.charAt(0)==2){
			getNumericFilterUpto3();
			}
		}
	}
		if(timeLenght1==3){
			if(time1.charAt(4)<=5){
			getNumericFilterUpto5();
			}
		}
		if(timeLenght1==4){
			if(time1.charAt(4)<=9){
			getNumericFilterUpto9();
			}
		}
		if(timeLenght1==2){
			var limiter = time1.charAt(2);
			if(limiter!=":"){
			getDelimiter();
			}
		}
	}

function getNumericFilterUpto9(){
		obj =  String.fromCharCode(window.event.keyCode);
		var numericFilter =/^[0-9]+$/;
		if (!(numericFilter.test(obj))){
			getMinutesMessage();
		}else {
			getClearMessage();
		}
	}

function getNumericFilterUpto5(){
		obj =  String.fromCharCode(window.event.keyCode);
		var numericFilter =/^[0-5]+$/;
		if (!(numericFilter.test(obj))){
			getMinutesMessage();
		}else{
		getClearMessage();
		}
	}

function getNumericFilterUpto3(){
		obj =  String.fromCharCode(window.event.keyCode);
		var numericFilter =/^[0-3]+$/;
		if (!(numericFilter.test(obj))){
			getHoursMessage();
		}else {
			getClearMessage();
		}
	}
function getNumericFilterUpto2(){
		obj =  String.fromCharCode(window.event.keyCode);
		var numericFilter =/^[0-2]+$/;
		if (!(numericFilter.test(obj))){
		getHoursMessage();
		}else{
		getClearMessage();
		}
	}

function getDelimiter(){
			var obj =  String.fromCharCode(window.event.keyCode);
			var checkDelimiter =/^[:]+$/;
			if (!(checkDelimiter.test(obj))){
				getDelimiterMessage();
			}else{
				getClearMessage();
			}

	}

function getHoursMessage(){
var error="";
var servingTime=getLabel("eOT.servingTime.Label","OT");
error+= getMessage("APP-NF0008","ot").replace("$",servingTime)+"<br>";
 window.event.keyCode = 27;
	}

function getMinutesMessage(){
	  var error="";
      var servingTime=getLabel("eOT.servingTime.Label","OT");
      error+= getMessage("APP-OT0041","ot").replace("$",servingTime)+"<br>";
      window.event.keyCode = 27;
	}

function getClearMessage(){
        var error="";
		parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}

function getDelimiterMessage(){
      var error="";
      var servingTime=getLabel("eOT.servingTime.Label","OT");
      error+= getMessage("APP-OT0130","ot").replace("$",servingTime)+"<br>";
      window.event.keyCode = 27;
	}
function EnabledScheduleTime()
{ 
if(document.getElementById("freq").checked==true)
{
parent.ModifyMealPlanItem.document.forms[0].sheduleTime.disabled=false;
}
else{
parent.ModifyMealPlanItem.document.forms[0].sheduleTime.value='';
parent.ModifyMealPlanItem.document.forms[0].sheduleTime.disabled=true;
}
}
// End of [IN39955]
 function dateUtils(date,locale,format){
		format=(format!=null)?format:"DMY";
		return (locale=="en")?date:trimString(convertDate(date,format,locale,"en"));
	}
	
function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO',"IP"));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}



function trimString(sInString){
   return sInString.replace(/^\s+|\s+$/g,"");
 }


 function changeDate(da){
	var dat=new Array();
	var retDat="";
	dat=da.split("/");
	if(dat[0]==null || dat[0]=="null" || dat[0]=="undefined")dat[0]="";
	if(dat[1]==null || dat[1]=="null" || dat[1]=="undefined")dat[1]="";
    if(dat[1].length==1) 	dat[1]="0"+dat[1];
	if(dat[0].length==1) 	dat[0]="0"+dat[0];
	retDat=dat[1]+"/";
	retDat+=dat[0]+"/";
	retDat+=dat[2];
	return retDat;
}


function compareDates1(fromdate,todate) {
	var fromarray; var toarray;
    if(fromdate.length > 0 && todate.length > 0 ) {

			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];

			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];

            var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");

			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);

			if(Date.parse(fromdt) > Date.parse(todt)) {
                return false;
            }
    }
	return true;
}
//Added Against Ml-MMOH-CRF-0674 starts Here
function fecthDietType() // MMS-QH-CRF-0190
{
	var diettype_auto=document.getElementById("diettype_auto").value;//Added Against ML-MMOH-CRF-0674	
	var obj;
	obj = document.getElementById("DietType");
	while(obj.length > 0){
		obj.remove(0);
	}
	var mode = "fecthDietTypes_forpatient";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="&mode_diet="+mode+"&diettype_auto="+diettype_auto;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",  "../../servlet/eDS.ModifyMealPlanServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
		
	if(retVal != null && trim(retVal).length != 0){
		fecthedDietTypes = retVal.split(',');
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	for(var j=0; j < fecthedDietTypes.length; j++){
		if(j % 2 == 0){
			var Entry = document.createElement("option");
			var msg = "----select----";
			Entry.text = msg;
			Entry.value= "";
			Entry.value  = trim(fecthedDietTypes[j]);
			Entry.text  = trim(fecthedDietTypes[j+1]);
			obj.add(Entry);
			}
		}
	}else{
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	}
	//Added Against ML-MMOH-CRF-0674 Starts Here
	var str=document.getElementById("DietType").value;
	var auto_flag=document.getElementById("auto_flag").value
	if(str == "" && auto_flag == "true")
		{
			var sel = document.getElementById('DietType');
			var len = sel.options.length;
			if(len <= 5)
				sel.setAttribute('size', len);
			else
				sel.setAttribute('size', 5);
		}
			
	else if(str != "" && auto_flag == "false2")
		{
			var sel = document.getElementById('DietType');
			var len = sel.options.length;
			if(len <= 5)
				sel.setAttribute('size', len);
			else
				sel.setAttribute('size', 5);
		}		
		//Added Against ML-MMOH-CRF-0674 Ends Here
}
	
function diettype_Autocomplete()
{
	document.getElementById("diettype_auto").value=""; 
	var selText="";
	var theKeyCode = window.event.keyCode;
	if(theKeyCode != 37 && theKeyCode != 38 && theKeyCode != 39 && theKeyCode != 40 && theKeyCode != 13 && theKeyCode != 8)
	{
		document.getElementById("auto_flag").value="true";
		selText += String.fromCharCode(theKeyCode);
		document.getElementById("diettype_auto").value=selText;
		fecthDietType();			 
	}
}
   
function Select()
{
	var auto_flag=document.getElementById("auto_flag").value;
	var myDropDown = document.getElementById("DietType");
	var str = myDropDown.options[myDropDown.selectedIndex].value;
		
	if(auto_flag == "true" && str!="")
		{
			myDropDown.size = 1;
			document.getElementById("auto_flag").value="false2";
			document.getElementById("diettype_auto").value="";
		}
	else if(auto_flag == "true" && str=="")
		{			
			myDropDown.size = 1;  
			document.getElementById("auto_flag").value="false";
			document.getElementById("diettype_auto").value="";		
			fecthDietType();				
		}

	else if(auto_flag == "false2" && str=="")
		{
			document.getElementById("auto_flag").value="false";
			document.getElementById("diettype_auto").value="";				
			fecthDietType();			 
		}		
}
//Added Against Ml-MMOH-CRF-0674 Ends Here


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
	returnedValues = await CommonLookup(title, argumentArray);
	if((returnedValues != null) && (returnedValues != "")) {
		document.getElementById("dietTypeDesc").value = returnedValues[1];
		document.getElementById("dietType").value = returnedValues[0];		
	}else{
		document.getElementById("dietTypeDesc").value = '';
		document.getElementById("dietType").value = '';		
	}
}	
//Added Against Ml-MMOH-CRF-1818 ends
