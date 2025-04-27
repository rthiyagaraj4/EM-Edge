var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var allow=true;

function query() {
	var QueryMode="2";
	f_query_criteria.wardretmedicationqueryframe.location.href="../../ePH/jsp/WardReturnAddModify.jsp?QueryMode="+QueryMode;
	// f_query_criteria.wardretmedicationdrugframe.location.href="../../eCommon/html/blank.html";
	f_query_criteria.wardretmedicationplineframe.location.href="../../eCommon/html/blank.html";
	f_query_criteria.wardretmedicationdrugframe.location.href="../../eCommon/html/blank.html";
	f_query_criteria.wardretmedicationremarksframe.location.href="../../eCommon/html/blank.html";
	f_query_criteria.wardretmedicationactionframe.location.href="../../eCommon/html/blank.html";
	f_query_criteria.wardretmedicationbuttonframe.location.href="../../eCommon/html/blank.html";
	messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function chkClose(){
	/*parent.window.close();*/
	parent.document.getElementById('dialog_tag').close();  
}

//for patient lookup
async function callPatientSearch(target){
	var patient_id = await PatientSearch();
		
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
	}
}
//for drug lookup
async function drugsearch(obj){
	var formObj = obj;
	retVal =await DrugSearch( "D", obj.Drug_Name,"ReturnMedication" );
	if( (retVal != null) && (retVal != "" ))  {
		formObj.Drug_Name.value = retVal[1] ;
		formObj.Drug_Code.value = retVal[0];
	}
}

function callResultPage(QueryMode){
	var formObj	=	document.FormWardReturnQueryCriteria;
	patientId   =   formObj.Patient_Id.value;

	if(QueryMode!=2){
		// Check for Mandatory Fields

		var formObj	=	document.FormWardReturnQueryCriteria;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";	
		verification(QueryMode);
		if (!allow){
			formObj.Patient_Id.focus();
			return;
		}		
		//populate the drug frame
		drugCode=formObj.Drug_Code.value;
		orderId=formObj.Order_Id.value;
		dispNo=formObj.Dispense_No.value;
		cutoff=formObj.CutOff.value;
		dispLocn=formObj.dispLocn.value;
		// ADDED for  KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start
		wardReturnYN=formObj.wardReturn_YN.value;
		ward_Date_To			= formObj.ward_Date_To.value;
		Ward_Date_From			= formObj.Ward_Date_From.value;
		systemdate				=formObj.systemdate.value;
		// ADDED for  KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 end
		var ordering_facility_id  =formObj.OrderingFacility.options[formObj.OrderingFacility.selectedIndex].value;
		// ADDED if condition for  KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start
		if(wardReturnYN == "Y"){
		   
		   if(  Ward_Date_From == ""){
		   alert(getMessage("PH_FROM_TIME_NOT_BLANK", "PH"));
		   formObj.Ward_Date_From.focus();
			return;
		   }
		   if(ward_Date_To == "" ){
		   alert(getMessage("PH_TO_TIME_NOT_BLANK","PH"));
		   formObj.ward_Date_To.focus();
			return;
		   }
		   if(!doDateCheckAlert(Ward_Date_From,systemdate,0))
			{
				alert(getMessage("FROM_DATE_LESS_THAN_SYSDATE","PH"));
				
				 formObj.Ward_Date_From.focus();
					return;
			}
			if(!doDateCheckAlert(ward_Date_To,systemdate,0))
			{
				//alert("To Should be Less than Sysdate");//For less then Sys date
				alert(getMessage("TO_DATE_LESS_THAN_SYSDATE","PH"));
				 formObj.ward_Date_To.focus();
					return;
			}
		    	if(!doDateCheck(Ward_Date_From,ward_Date_To,parent.parent.messageFrame))
			{
				//alert("To Should be Greater than From");//For less then Sys date
				alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
				 formObj.ward_Date_To.focus();
					return;
			}
		/*	parent.mainframeset.rows="21%,5%,*,0%,5%";
			parent.subframeset.cols="100%,*";*/
	        parent.document.getElementById("DIV1").style.height = "21%";
	        parent.document.getElementById("DIV2").style.height = "7%";
	        parent.document.getElementById("DIV3").style.height = "65%";
	        parent.document.getElementById("DIV4").style.height = "0%";
	        parent.document.getElementById("DIV5").style.height = "5%";
			parent.wardretmedicationdrugframe.location.href="../../ePH/jsp/WardReturnDrugReturnRequest.jsp?patientid="+patientId+"&drugcode="+drugCode+"&orderid="+orderId+"&dispno="+dispNo+"&cutoff="+cutoff+"&dispLocn="+dispLocn+"&ordering_facility_id="+ordering_facility_id+"&wardReturnYN="+wardReturnYN+"&ward_Date_To="+ward_Date_To+"&Ward_Date_From="+Ward_Date_From;
		}
		else{
			/*parent.mainframeset.rows="21%,5%,*,0%,0%";
			parent.subframeset.cols="60%,*";	*/
			parent.document.getElementById("DIV1").style.height = "21%";
			 parent.document.getElementById("DIV2").style.height = "7%";
			 parent.document.getElementById("DIV3").style.height = "70%";
			 parent.document.getElementById("DIV4").style.height = "0%";
			 parent.document.getElementById("DIV5").style.height = "0%";
		parent.wardretmedicationdrugframe.location.href="../../ePH/jsp/WardReturnDrug.jsp?patientid="+patientId+"&drugcode="+drugCode+"&orderid="+orderId+"&dispno="+dispNo+"&cutoff="+cutoff+"&dispLocn="+dispLocn+"&ordering_facility_id="+ordering_facility_id;
		}
		// ADDED for  KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 end
	}
	else if(QueryMode==2){
	
		toStore=formObj.disp_code.value;
		verification(QueryMode);
		if (!allow){
			formObj.Patient_Id.focus();
			return;
		}
		/*parent.mainframeset.rows="20%,0%,*,0%,0%";	
		parent.subframeset.cols="*,0%";	*/
		parent.document.getElementById("DIV1").style.height = "21%";
		 parent.document.getElementById("DIV2").style.height = "0%";
		 parent.document.getElementById("DIV3").style.height = "80%";
		 parent.document.getElementById("DIV4").style.height = "0%";
		 parent.document.getElementById("DIV5").style.height = "0%";
		parent.wardretmedicationdrugframe.location.href="../../ePH/jsp/WardReturnQueryResult.jsp?patientid="+patientId+"&StoreCode="+toStore+"&querymode="+QueryMode;
	}
}

async function searchDispLocn(obj){
	var sql="";
	sql="SELECT DISP_LOCN_CODE CODE, SHORT_DESC description FROM PH_DISP_LOCN_LANG_VW PH_DISP_LOCN WHERE EFF_STATUS='E' AND DISP_LOCN_CODE LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?) and facility_id ="; 
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var FACILITY_ID=document.FormWardReturnQueryCriteria.facility_id.value;
	var LANGUAGE_ID=document.FormWardReturnQueryCriteria.locale.value;

	argumentArray[0]   =sql+"'"+FACILITY_ID+"'"+" and language_id="+"'"+LANGUAGE_ID+"'"+"order by 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal =await CommonLookup(getLabel("Common.Location.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != "") {
		document.FormWardReturnQueryCriteria.disp_locn.value = arr[1] ;
		document.FormWardReturnQueryCriteria.disp_code.value = arr[0];
	}
	else{
		document.FormWardReturnQueryCriteria.disp_locn.value = '' ;
		document.FormWardReturnQueryCriteria.disp_code.value = '' ;
	}
}

function StoreCodeSelect(objval){
	document.FormWardReturnQueryCriteria.FormStore.value=objval.value
}

async function WardRemarks(reason,querymode){
	var frmobj=parent.wardretmedicationdrugframe.document.WardReturnQueryResultform;	 

	var dialogHeight	= "400px" ;
	var dialogWidth		= "700px" ;
	var dialogTop		= "200" ;
	var dialogLeft		= "203" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="no";
	var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scroll:no" ;
	var arguments	= "";
  
	var bean_id="WardReturnBean"+frmobj.login_at_ws_no.value; 
	var bean_name="ePH.WardReturnBean";
	var retVal = await window.showModalDialog("../../ePH/jsp/ReturnMedicationRemarks1.jsp?bean_id="+bean_id+"&querymode="+querymode+"&remark_desc="+reason+"&bean_name="+bean_name,arguments,features);
	//if(retVal!=undefined && retVal!="")
	//obj.value=retVal;
}

function callBatchDetails(querystring){

// Check for Mandatory Fields
	var formObj	=	document.FormWardReturnRemarks;

	var ToStoreCode=document.FormWardReturnRemarks.ToStoreCode.value;
	var ToStore=document.FormWardReturnRemarks.ToStore.value;
	//alert("ToStoreCode---->"+ToStoreCode);
	var fields=new Array();
	var names=new Array();
	fields[0]=formObj.ReturnRemarks;
	fields[1]=formObj.ToStore;
	names[0]=getLabel("Common.remarks.label","Common");
	names[1]=getLabel("Common.ToStore.label","Common");

	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	var blankObject= checkFields( fields, names, parent.parent.messageFrame, errorPage) ;

	if (blankObject!=true){
		//messageFrame.location.href="../../eCommon/jsp/error.jsp";
		return;
	}
	else//Added for MMS ADHOC Testing
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	//we have to refer 2 forms here
	formObjdrug=parent.wardretmedicationdrugframe.FormWardReturnDrug
	formObjremarks=document.FormWardReturnRemarks;
	//loop through the check boxes and get value of selected check boxes...value is nothing but drug code

	check=formObjdrug.DrugSelect;
	drugid=formObjdrug.drugid;
	var checkstring="";
	if (isNaN(check.length)){
		if (check.checked){	
			checkstring="'"+drugid.value+"'";
			//disabling all select boxes
			check.disabled=true;
		}
	}
	else{
		for (i=0;i<check.length ;i++ ){
			if (check[i].checked){
				if (i==check.length-1){
					checkstring+="'"+drugid[i].value+"'";
				}
				else{
					checkstring+="'"+drugid[i].value+"'"+",";
				}
			}
			check[i].disabled=true;
		}
	}	
	remarks=formObjremarks.ReturnRemarks.value;
	
	//disable both drug and remarks frame
	formObjremarks.ReturnRemarks.disabled=true;
	formObjremarks.ToStore.disabled=true;
	formObjremarks.proceed.disabled=true;
	formObjremarks.ToStore_Button.disabled=true;
	
	formObjdrug.SelectAll.disabled=true;
	//populate the action frame
	//parent.mainframeset.rows="17%,6%,20%,*,7%";
	 parent.document.getElementById("DIV1").style.height = "17%";
	 parent.document.getElementById("DIV2").style.height = "6%";
	 parent.document.getElementById("DIV3").style.height = "20%";
	 parent.document.getElementById("DIV4").style.height = "50%";
	 parent.document.getElementById("DIV5").style.height = "7%";
	
	parent.wardretmedicationactionframe.location.href="../../ePH/jsp/WardReturnAction.jsp?"+querystring+"&remarks="+remarks+"&ToStoreCode="+ToStoreCode+"&drugcodes="+checkstring+"&ToStore="+ToStore;
}

function reset() {
	var url = location.href;
	var QueryMode =	f_query_criteria.wardretmedicationqueryframe.FormWardReturnQueryCriteria.QueryMode.value;
	
	url = url.toLowerCase();
	 //f_query_criteria.mainframeset.rows="21%,5%,*,0%,0%";
	
	f_query_criteria.document.getElementById("DIV1").style.height = "24%";
	f_query_criteria.document.getElementById("DIV2").style.height = "6%";
	f_query_criteria.document.getElementById("DIV3").style.height = "0%";
	f_query_criteria.document.getElementById("DIV4").style.height = "0%";
	//if(QueryMode=='')  {

		// if ( (url.indexOf("wardreturnmedicationframes")!=-1) ) {
			f_query_criteria.wardretmedicationqueryframe.location.href="../../ePH/jsp/WardReturnAddModify.jsp?&mode="+f_query_criteria.wardretmedicationqueryframe.FormWardReturnQueryCriteria.mode.value+"&dispLocn="+f_query_criteria.wardretmedicationqueryframe.FormWardReturnQueryCriteria.dispLocn.value+"&password="+f_query_criteria.wardretmedicationqueryframe.FormWardReturnQueryCriteria.password.value;
			//f_query_criteria.wardretmedicationqueryframe.FormWardReturnQueryCriteria.reset();
			f_query_criteria.wardretmedicationplineframe.location.href="../../eCommon/html/blank.html";
			f_query_criteria.wardretmedicationdrugframe.location.href="../../eCommon/html/blank.html";
			f_query_criteria.wardretmedicationremarksframe.location.href="../../eCommon/html/blank.html";
			f_query_criteria.wardretmedicationactionframe.location.href="../../eCommon/html/blank.html";
			f_query_criteria.wardretmedicationbuttonframe.location.href="../../eCommon/html/blank.html";
			messageFrame.location.href="../../eCommon/jsp/error.jsp";
	//}
}

function apply(){
	frmobj=parent.wardretmedicationactionframe.document.FormWardReturnAction;
	totalrows=frmobj.totalrows.value;
	var patientid=frmobj.patientid.value;
	//frmobj.msg.value=getMessage("RECORD_INSERTED","PH");
	count=0;
	srlnobatcharray=new Array();
	srlnoarray=new Array();
	dispnoarray=new Array();
	arrcount=0;
	if(frmobj.site.value=="true"||frmobj.site.value==true){ // if else condition added for GHL-CRF-0413.8 - Start
		count1=totalrows;
		for (i=1;i<=totalrows ;i++ ){
		  if(eval("frmobj.check_name"+i).checked==true){
			  count1--;
			obj=eval("frmobj.actualReturn"+i);
			if ((obj.value!="0")&&(obj.value!="")){
				count=1;
			}
		  }
		}
		if(count1==totalrows){
			alert(getMessage("NO_RECORDS_HAVE_BEEN_SELECTED","PH"));
			   return;
		}
	}
	else{
		for (i=1;i<=totalrows ;i++ ){
			obj=eval("frmobj.actualReturn"+i);
			if ((obj.value!="0")&&(obj.value!="")){
				count=1;
			   	//parent.wardretmedicationqueryframe.document.FormWardReturnQueryCriteria.Search.click();
			}
		}
	} // if else condition added for GHL-CRF-0413.8 - End
	if (count==0){
		alert(getMessage("PH_NO_RET_QTY","PH"));
		return;
	}
	eval( formApply(frmobj, PH_CONTROLLER) ) ;
	if (result){
		document.formWardReturn.Return.disabled='true';
		onSuccess(patientid);
		parent.wardretmedicationqueryframe.document.FormWardReturnQueryCriteria.Search.click();	// Moved here for [IN:45989]
	}
	if(message==getMessage("CANNOT_RETURN","PH")) // Added for GHL-CRF-0412.3 - Start
	{
		alert(message);
		return;
	} // Added for GHL-CRF-0412.3 - End
    parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	/*if(flag!=0){
		  parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message + getLabel("ePH.TokenNo.label","PH")+" : <label style='font-size:18'><b>"+flag+"</b></label>";
	}else{
		 parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message ;
	}*/
}

function onSuccess(patientid){
	var	printReport = confirm(getMessage("PRINT_WARD_RET_MED_VOUCHER","PH"));
	if (printReport) {
		/*var xmlDoc			= new ActiveXObject("Microsoft.XMLDom");
		var xmlHttp			= new ActiveXObject("Microsoft.XMLHTTP");*/
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH  /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "ReturnMedicationPrintReport.jsp?func_mode=WardReturnonLinePrinting"+"&patient_id=" + patientid + "&flag=" + flag, true);
		xmlHttp.send( xmlDoc ) ;
		//responseText=xmlHttp.responseText ;
		//eval( responseText ) ;
	}		
 }

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function  enableProceed(obj){
	formObj=document.FormWardReturnDrug;
	if (obj.checked==false)
		formObj.SelectAll.checked=false;

	check=formObj.DrugSelect;
	vcheck=false;

	if (isNaN(check.length)){
		if (check.checked){
			//Added for GHL-CRF-0412 start
			if(formObj.dispLocationCount.value == 1){
				objs=eval("formObj.disp_value0");
				parent.wardretmedicationremarksframe.FormWardReturnRemarks.ToStore.value=objs.value;	
			}//Added for GHL-CRF-0412 end
			parent.wardretmedicationremarksframe.FormWardReturnRemarks.proceed.disabled=false;	}	
		else
			parent.wardretmedicationremarksframe.FormWardReturnRemarks.proceed.disabled=true;		
		return;
	}
	for (i=0;i<check.length ;i++ ){

		if (check[i].checked){
			//Added for GHL-CRF-0412 start
			if(formObj.dispLocationCount.value == 1){
				objs=eval("formObj.disp_value"+i);
				parent.wardretmedicationremarksframe.FormWardReturnRemarks.ToStore.value=objs.value;		
			}//Added for GHL-CRF-0412 end
			parent.wardretmedicationremarksframe.FormWardReturnRemarks.proceed.disabled=false;		
			return;
		}
	}
	parent.wardretmedicationremarksframe.FormWardReturnRemarks.proceed.disabled=true;	
}

 function StoreCheck(StoreCount){
	frmobj=document.FormWardReturnAction;
	var table = frmobj.getElementsByTagName('table')[0];
	totalrows=table.rows.length;
	store_cunt = "";
	if(StoreCount=="0"){ 
	for (i=1;i<=totalrows ;i++ ){
		obj=eval("frmobj.actualReturn"+i);
		store_cunt = eval("frmobj.StoreCount"+i).value;//added for GHL-SCF-1395

		if (store_cunt=="0" && (obj.value!="0")&&(obj.value!="")&&(obj.disabled==false)){
		
			alert(getMessage("ITEM_IS_NOT_ASSIGNED","PH"));
			//obj.disabled=true;
			obj.value="";
			obj.focus();
			return false; 
			
		} //end if
	  }//end for
	} //end if
 }

function checkQty(obj,conv_factor,base_to_disp_uom_equl,base_to_def_uom_equl,DetailsUom,dflt_issue_uom){
   	var str="";
	if(base_to_disp_uom_equl==0||base_to_disp_uom_equl==null||base_to_disp_uom_equl==''){
		str= DetailsUom;
	}
	if(base_to_def_uom_equl==0||base_to_def_uom_equl==null||base_to_def_uom_equl==''){
		str=str+" , "+dflt_issue_uom;
	}
	 
	if(str!=''){
	     alert(getMessage("PH_ITEM_UOM_DEF_NOT_FOUND_FOR","PH")+" "+str);
		 return;
	  }
	
	obj.value	=	trimString(obj.value);
	if(obj.value=="" || isNaN(parseInt(obj.value)) || parseInt(obj.value)==0)//Added for KDAH-SCF-0464
		obj.value="0"; //Added for KDAH-SCF-0464
	
	actual		=	obj.value;
	formObj		=	document.FormWardReturnAction;
	id			=	obj.id;
	//find the no in the row-actualReturn contains 12 chars and so
	no			=	id.substr(12,id.length);
	//find the corresponding returnable qty
	returnable=eval("formObj.returnable"+no+".value");
	if(parseInt(conv_factor)!=0){
		if((actual%conv_factor) != '0'){
			alert(getMessage("PH_ISSUE_UOM_MUL","PH")+conv_factor);
			obj.select();
			obj.focus();
		}
		if (parseInt(returnable)<parseInt(actual) ){
			alert(getMessage("PH_EXCEED_BALANCE_QTY","PH"));
			obj.select();
			obj.focus();
		}
	}
	else{
		alert(getMessage("PH_ITEM_UOM_DEF_NOT_FOUND","PH"));
		obj.value="";
	}
}

function cancelAction(){
	document.location.href="../../eCommon/html/blank.html";
	parent.wardretmedicationactionframe.location.href="../../eCommon/html/blank.html";
	parent.mainframeset.rows="17%,5%,*,0%,0%";
	//also enable the top frame
	formObjdrug=parent.wardretmedicationdrugframe.FormWardReturnDrug
	formObjremarks=parent.wardretmedicationremarksframe.FormWardReturnRemarks;
	//loop through the check boxes and get value of selected check boxes...value is nothing but drug code
	check=formObjdrug.DrugSelect;

	if (isNaN(check.length)){
		check.disabled=false;
	}
	else{
		for (i=0;i<check.length ;i++ ){
			check[i].disabled=false;
		}
	}	
	
	//disable both drug and remarks frame
	formObjremarks.ReturnRemarks.disabled=false;
	formObjremarks.proceed.disabled=false;
	formObjdrug.SelectAll.disabled=false;
	formObjremarks.ToStore_Button.disabled=false;
	formObjremarks.ToStore.disabled=false;
}

function  selectAll(obj){
	var flag ="";
	if (obj.checked==false){
		//return;
		flag="false";
	}
	else{
		flag="true";
	}
	formObj=document.FormWardReturnDrug;
	check=formObj.DrugSelect;

	if (isNaN(check.length)){
		check.checked=true;
		//alert("single checked box");
		formObjremarks=parent.wardretmedicationremarksframe.FormWardReturnRemarks;
		parent.wardretmedicationremarksframe.document.getElementById("proceed").disabled=false;
		return;
	}
	for (i=0;i<check.length ;i++ ){
		if(flag=='true'){
		   check[i].checked=true;
		 //Added for GHL-CRF-0412 start
		   if(formObj.dispLocationCount.value == 1){
			   objs=eval("formObj.disp_value"+i);
				parent.wardretmedicationremarksframe.FormWardReturnRemarks.ToStore.value=objs.value;	
			}//Added for GHL-CRF-0412 end
		}
		else{
			check[i].checked=false;
		}
	}
	formObjremarks=parent.wardretmedicationremarksframe.FormWardReturnRemarks;
	if(flag=='true'){
	   formObjremarks.proceed.disabled=false;
	}
	else{
		formObjremarks.proceed.disabled=true;
	}
}

function verification(QueryMode){
	var formObj1=document.FormWardReturnQueryCriteria;
	
	//var message=" Patient ID or Dispense No must be Entered"
	var message=getMessage("PATIENT_ID_REQUIRED","PH");
	
    if(QueryMode==2){
	var fields=new Array();
	var names=new Array();
	fields[0]=formObj1.Patient_Id;
	fields[1]=formObj1.disp_locn;

	names[0]=getLabel("Common.patientId.label","Common");
	names[1]=getLabel("Common.ToStore.label","Common");

	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	var blankObject= checkFields( fields, names, parent.parent.messageFrame, errorPage) ;
		if (blankObject!=true){
			//messageFrame.location.href="../../eCommon/jsp/error.jsp";
			allow=false; 
			parent.wardretmedicationdrugframe.location.href = "../../eCommon/html/blank.html"; 
			return;
     	}
		else{
			allow=true;
		}
	}

	if(formObj1.Patient_Id.value==""){
		//alert("Patient ID or Dispense No must be entered");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		allow=false;
	}
	else{
		allow=true;
	}
}

function uppercase() {
	key = window.event.keyCode;
	if((key>0x60) && (key< 0x7B))
		window.event.keyCode=key-0x20;
}

function clearDispLocn(disp_locn){
	if (disp_locn.value == ''){
		document.FormWardReturnQueryCriteria.disp_code.value = '';
	}
	else{
		searchDispLocn(disp_locn);
	}
}
// ADDED for  KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start
function SelectwardReturnChk(obj){

	var formObj=document.wardReturn_YN;
	if(obj.checked) {

		obj.value="Y";
		document.getElementById("fromdate_label").style='display'; 
		document.getElementById("fromdate_value").style='display'; 
		document.getElementById("todate_label").style='display'; 
		
		
	}
	else{

		obj.value="N";
		document.getElementById("fromdate_label").style.display = 'none'; 
		document.getElementById("fromdate_value").style.display = 'none'; 
		document.getElementById("todate_label").style.display = 'none'; 
		

	}
}
function  selectAllDrugs(obj){
	
	formObj=document.FormWardReturnDrug1;
	var flag ="";
	if (obj.checked==false){
		
		flag="false";
	}
	else{
		
		flag="true";
	}
	checkcount=formObj.total_count.value;
	if(flag=='true'){
	for (var i=1;i<=checkcount;i++ ){
		
		if(eval("document.FormWardReturnDrug1.check_id"+i).checked != obj.checked)  //Added for IN032747 - end
			eval("document.FormWardReturnDrug1.check_id"+i).click(); 
	
	}
	
		
	}	
	else{
		for (var i=1;i<=checkcount;i++ ){
			
			if(eval("document.FormWardReturnDrug1.check_id"+i).checked = obj.checked)  //Added for IN032747 - end
				eval("document.FormWardReturnDrug1.check_id"+i).click(); 
		
		}
		
	}

}
function validateDate1(){

	var formObj = document.FormWardReturnQueryCriteria;
	if (formObj.Ward_Date_From.value!="" && formObj.ward_Date_To.value!=""){
		if(!doDateCheck(formObj.Ward_Date_From,formObj.ward_Date_To,parent.parent.messageFrame)){
			formObj.ward_Date_To.select();
		}else{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}

function AssignValue(obj,i){
	var total_count = document.FormWardReturnDrug1.total_count.value;
	var c=0;
	if(obj.checked==true){
		eval("document.FormWardReturnDrug1.chk_"+i).value = "Y";
		
	}
	else{
		eval("document.FormWardReturnDrug1.chk_"+i).value = "N";
		document.FormWardReturnDrug1.SelectAll.checked=false;
	}
	for (var j=1;j<=total_count;j++ ){
	if(eval("document.FormWardReturnDrug1.chk_"+j).checked)
		c++;
}
	if((parseInt(total_count))==c)
		document.FormWardReturnDrug1.SelectAll.checked=true;
}
// ADDED for  KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 end
function cancelReturn(){//Added for KDAH-CRF-0250 [IN:039018]
	frmobj=parent.wardretmedicationdrugframe.FormWardReturnDrug1;
	
	eval( formApply(frmobj, PH_CONTROLLER) ) ;
	if (result){
		parent.wardretmedicationqueryframe.document.FormWardReturnQueryCriteria.Search.click();	// Moved here for [IN:45989]
	}
    parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	
}
function callBarcodeflg(barcode_id,querystring){ //Added for GHL-CRF-0413.8[IN063028]  - Start		
	var frmobj=parent.wardretmedicationdrugframe.FormWardReturnDrug;
	var frmobj1=parent.wardretmedicationactionframe.document.FormWardReturnAction;
	if(barcode_id.value==undefined || barcode_id.value==""){
		alert(getMessage('NOT_A_VALID_BARCODE','PH'));
		document.FormWardReturnRemarks.barcode_id.value="";
		return false;
	}
	else{
		var formObj	=	document.FormWardReturnRemarks;
		var ToStoreCode=document.FormWardReturnRemarks.ToStoreCode.value;
		var ToStore=document.FormWardReturnRemarks.ToStore.value;
		//alert("ToStoreCode---->"+ToStoreCode);
		var fields=new Array();
		var names=new Array();
		fields[0]=formObj.ReturnRemarks;
		fields[1]=formObj.ToStore;
		names[0]=getLabel("Common.remarks.label","Common");
		names[1]=getLabel("Common.ToStore.label","Common");
		var errorPage	= "../../eCommon/jsp/error.jsp" ;
		var blankObject= checkFields( fields, names, parent.parent.messageFrame, errorPage) ;
		if (blankObject!=true){
		   if(document.FormWardReturnRemarks.barcode_id.value!=undefined)
			document.FormWardReturnRemarks.barcode_id.value="";
			return;
		}
		else
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		
		formObjdrug=parent.wardretmedicationdrugframe.FormWardReturnDrug
		formObjremarks=document.FormWardReturnRemarks;

		check=formObjdrug.DrugSelect;
		drugid=formObjdrug.drugid;
		var checkstring="";
		var checkstring1="";
		
		for (i=0;i<check.length ;i++ ){
			if (check[i].checked){
				if(check[i].disabled==false){
				if (i==check.length-1){
					checkstring1+="'"+drugid[i].value+"'";
				}
				else{
					checkstring1+="'"+drugid[i].value+"'"+",";
				}
				}
			}
			//check[i].disabled=true;
		}
		
		if(checkstring.length<=0){
		  for (i=0;i<check.length ;i++ ){
			  if (check[i].checked){
				  if(check[i].disabled==false){
					if (i==check.length-1){
						checkstring+="'"+drugid[i].value+"'";
					}
					else{
						checkstring+="'"+drugid[i].value+"'"+",";
					}
			    }
			  }
				check[i].disabled=true;
		 }
		}
		remarks=formObjremarks.ReturnRemarks.value;
		formObjremarks.ReturnRemarks.disabled=true;
		formObjremarks.ToStore.disabled=true;
		formObjremarks.proceed.disabled=true;
		formObjremarks.ToStore_Button.disabled=true;
		formObjdrug.SelectAll.disabled=true;
		parent.mainframeset.rows="17%,5%,20%,*,7%";
		parent.wardretmedicationactionframe.location.href="../../ePH/jsp/WardReturnAction.jsp?"+querystring+"&remarks="+remarks+"&ToStoreCode="+ToStoreCode+"&drugcodes="+checkstring+"&ToStore="+ToStore+"&barcode_id="+barcode_id.value+"&checkstring1="+checkstring1+"&calledFrom=ScannedBatch";
		
		if( barcode_id.value!="" || barcode_id.value!=null ){
			document.FormWardReturnRemarks.barcode_id.value="";
		}
		}	
}
function SelectAll_1(selected,totalrows){
	frmobj=parent.wardretmedicationactionframe.document.FormWardReturnAction;
	if(selected.checked==true){
		for(var cnt=1;cnt<=totalrows;cnt++){
			eval("frmobj.check_name"+cnt).checked =true;
			eval("frmobj.check_name"+cnt).value = "Y";
		}
	}
	else{
		for(var cnt=1;cnt<=totalrows;cnt++){
			eval("frmobj.check_name"+cnt).checked =false;
			eval("frmobj.check_name"+cnt).value = "N";
			eval("frmobj.actualReturn"+cnt).value = "";
		}
	}
	if(selected.checked==false){
		var frmObj = parent.wardretmedicationactionframe.document.FormWardReturnAction;
		var bean_id		= frmObj.bean_id.value ;
		var bean_name	= frmObj.bean_name.value ;
		var actual="0";
		var count ="0";
		var mode="SELECTALL";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();					
		xmlStr	="<root><SEARCH " ;												
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "WardReturnTemporary.jsp?bean_id="+bean_id+ "&bean_name="+bean_name+"&qty="+ actual +"&count="+count+"&mode="+mode+"&identity=SAVECHANGEDQTY", false ) ;		
	     xmlHttp.send( xmlDoc ) ;
	     responseText=xmlHttp.responseText;
	     eval(responseText);	
	}
}
function selectCheck(cnt){
	frmobj=parent.wardretmedicationactionframe.document.FormWardReturnAction;
	if(eval("frmobj.check_name"+cnt).checked ==true)
		 eval("frmobj.check_name"+cnt).value = "Y";
	else{
		 eval("frmobj.check_name"+cnt).value = "N";
		 eval("frmobj.actualReturn"+cnt).value = "0";
	}
	saveChangedQty(eval("frmobj.actualReturn"+cnt),cnt);
} 

function checkOnChange(cnt){
	
	frmobj=parent.wardretmedicationactionframe.document.FormWardReturnAction;
	
	if(eval("frmobj.actualReturn"+cnt).value>0)
		eval("frmobj.check_name"+cnt).checked =true;	
	else
		eval("frmobj.check_name"+cnt).checked =false;
}

function saveChangedQty(qty,count){
	var frmObj = parent.wardretmedicationactionframe.document.FormWardReturnAction;
	var bean_id		= frmObj.bean_id.value ;
	var bean_name	= frmObj.bean_name.value ;
	var mode ="";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();					
	xmlStr	="<root><SEARCH " ;												
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var actual     = qty.value;
	id			=	qty.id;
	no			=	id.substr(12,id.length);
	var returnable=eval("frmObj.returnable"+no).value;
	if (parseInt(returnable)>=parseInt(actual) ){
	     xmlHttp.open( "POST", "WardReturnTemporary.jsp?bean_id="+bean_id+ "&bean_name="+bean_name+"&qty="+ actual +"&count="+count+"&mode="+mode+"&identity=SAVECHANGEDQTY", false ) ;		
	     xmlHttp.send( xmlDoc ) ;
	     responseText=xmlHttp.responseText;
	     eval(responseText);	
	}
	else
		return;
	
} // Added for GHL-CRF-0413.8[IN063028]  - End	
