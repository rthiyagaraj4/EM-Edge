  //saved on 07/11/2005
var result		= false ;
var message		= "" ;
var flag		= "" ;
var scheduleDate=new Date();
var excludeHours;

async function NursingUnitSearch( target ) {
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
	var language_id    = document.formPHGenerateFillList.language_id.value;
	var sql="SELECT A.NURSING_UNIT_CODE code,SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW A WHERE  A.FACILITY_ID LIKE ? AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(SHORT_DESC )LIKE upper(?) AND EFF_STATUS='E' and a.language_id=";
	var ordering_facility_id = document.formPHGenerateFillList.OrderingFacility.options[document.formPHGenerateFillList.OrderingFacility.selectedIndex].value;
	//alert("ordering_facility_id---->"+ordering_facility_id);
	
	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = ordering_facility_id;
	dataTypeArray[0]   = STRING ;

	//argumentArray[0]   = document.formPHGenerateFillList.nursing_unit_query.value +"'"+language_id+"' order by 2";
	argumentArray[0]   = sql+"'"+language_id+"' order by code";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	var retVal=await CommonLookup(getLabel("Common.NursingUnitSearch.label","Common"), argumentArray );
	if (retVal!="")	{
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		target.value = arr[1];
		if (target.name=="Nursing_Unit_From"){
			document.formPHGenerateFillList.Nursing_Unit_From_Code.value=arr[0];
		}else if (target.name=="Nursing_Unit_To"){
			document.formPHGenerateFillList.Nursing_Unit_To_Code.value=arr[0];
		}
	}
}
function enableAllFields(docobj){
	docobj.formPHGenerateFillList.Nursing_Unit_From.style.display="inline";
	docobj.formPHGenerateFillList.Nursing_Unit_To.style.display="inline";
	docobj.formPHGenerateFillList.Building_Code.style.display="inline";
	docobj.formPHGenerateFillList.Floor_Code.style.display="inline";
	docobj.formPHGenerateFillList.Nursing_Unit_From_Button.style.display="inline";
	docobj.formPHGenerateFillList.Nursing_Unit_To_Button.style.display="inline";
	docobj.PhysicalLocMandatory1.style.display="inline";
	docobj.PhysicalLocMandatory2.style.display="inline";
	
}
function nursingUnitLocationChange(obj,docobj){
	enableAllFields(docobj);
	val=obj.options[obj.selectedIndex].value;
	if (val=='L'){
		docobj.formPHGenerateFillList.Nursing_Unit_From.style.display="none";
		docobj.formPHGenerateFillList.Nursing_Unit_To.style.display="none";
		docobj.formPHGenerateFillList.Nursing_Unit_From_Button.style.display="none";
		docobj.formPHGenerateFillList.Nursing_Unit_To_Button.style.display="none";
		docobj.PhysicalLocMandatory3.style.display="none";
		docobj.formPHGenerateFillList.Building_Code.style.width="1.72in";
		docobj.formPHGenerateFillList.Floor_Code.style.width="1.72in";
		docobj.NursingUnitLocnFromTD.innerHTML="Building&nbsp;";
		docobj.NursingUnitLocnToTD.innerHTML="Floor&nbsp;";
		}else if (val=='N'){
		docobj.formPHGenerateFillList.Building_Code.style.display="none";
		docobj.formPHGenerateFillList.Floor_Code.style.display="none";
		docobj.PhysicalLocMandatory1.style.display="none";
		docobj.PhysicalLocMandatory2.style.display="none";
		docobj.NursingUnitLocnFromTD.innerHTML="From&nbsp;";
		docobj.NursingUnitLocnToTD.innerHTML="To&nbsp;";
		docobj.PhysicalLocMandatory3.style.display="inline";
	}
}
function disableFillPeriod(obj,docobj){
	//alert("doc79"+docobj);
	val=obj.options[obj.selectedIndex].value;
	if (val=='R'){
		/* Also change the Effective Start Time and End Time */
		var sTime	=docobj.formPHGenerateFillList.Schedule_Start_Time_Routine.value;
		docobj.formPHGenerateFillList.fill_int_start_date_time.value=sTime;
			
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.value = "24";
		CalculateEndTime(docobj);
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.disabled=false;
		
	}else if (val=='I'){
		//alert('ss-->'+docobj.formPHGenerateFillList.Default_Fill_Period.value);
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.value=docobj.formPHGenerateFillList.Default_Fill_Period.value;
//		docobj.formPHGenerateFillList.lbl_Ip_Fill_Prd_Ahead.innerHTML = "<b>"+docobj.formPHGenerateFillList.Default_Fill_Period.value+"</b>";
		/* Also change the Effective Start Time and End Time */
		//alert("val--->"+val);

		frmobj.fill_int_start_date_time.value=frmobj.incstarttime.value;
		frmobj.fill_int_end_date_time.value=frmobj.incendtime.value;
		CalculateStartTime(docobj);
		CalculateEndTime(docobj);
		//docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.value = docobj.formPHGenerateFillList.temp_fill_prd_ahead.value;
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.value = "24";
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.disabled=false;

		
	}
}





function populateData ( obj ){
	val=obj.value;
	if (val==""){
		document.formPHGenerateFillList.Floor_Code.selectedIndex=0;
		return false;
	}
	document.getElementById('Floor_Code').innerText = "";
	var objname		= obj.name ;
	var bean_id		= document.formPHGenerateFillList.bean_id.value ;
	var bean_name	= document.formPHGenerateFillList.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
	xmlStr += obj.name+"=\""+ checkSpl(obj.value) +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocation.jsp?function=BuildingandFloors&bean_id=" + bean_id + "&bean_name=" + bean_name +  "&building_code=" + val, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
}

function addData(code, desc, obj) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = unescape(decodeURIComponent(desc));
	obj.add(opt);
}

function apply(){
	//Store cut off here....
	storeCutOff();
	var fields=new Array();
	fields[0]=document.formPHGenerateFillList.Ip_Fill_Prd_Ahead;

	var names=new Array();
	names[0]=getLabel("ePH.FillPeriod.label","PH");
	if (document.formPHGenerateFillList.nursing_unit_or_locn.value=='L'){
		fields[1]=document.formPHGenerateFillList.Building_Code;
		fields[2]=document.formPHGenerateFillList.Floor_Code;
		names[1]=getLabel("ePH.BuildingName.label","PH");
		names[2]=getLabel("ePH.FloorName.label","PH");
	
	}
	var frmobj =document.formPHGenerateFillList;
	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	var blankObj 	= null ;
	blankObject  = getBlankField( fields, names, parent.messageFrame, errorPage) ;
	if(blankObject==null){
		//Check if Fill type is routine and the current time is less than scheduled time. If so return
		var ctgreater=	CurrentTimeGreater();
		parent.messageFrame.location.href	="../../eCommon/jsp/error.jsp";
		eval( formApply(frmobj, PH_CONTROLLER) ) ;
		onSuccess(frmobj);
	}else{
		blankObject.focus() ;
	}
}
function onSuccess(frmobj){
	//alert("message---->"+message);
	if(message != '')
		flag = flag+':'+message;
	parent.messageFrame.location.href		= "../../eCommon/jsp/error.jsp?err_num=<br> <B>"+getMessage("FILL_PROC_ID_IS","PH") +":"+flag+"</B>";
	parent.f_generatefilllist.location.href = "../../ePH/jsp/PHGenerateFillList.jsp";
}
function CalculateEndTime(docobj,fillType){
	var bean_id		= document.formPHGenerateFillList.bean_id.value ;
	var bean_name	= document.formPHGenerateFillList.bean_name.value ;
	var disp_locn_code	= document.formPHGenerateFillList.disp_locn_code.value ;
	var proc_type	= document.formPHGenerateFillList.Proc_Type.value ;
	var schedule_start = document.formPHGenerateFillList.schedule_start.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var frmobj		= docobj.formPHGenerateFillList;
	var fPeriod		= frmobj.Ip_Fill_Prd_Ahead.value;
	var incstartime	= frmobj.incstarttime.value;
	var unit		= frmobj.Fill_Period_Unit.value;
	if(schedule_start != ''){schedule_start = schedule_start.substring(0,10);}

	xmlStr			= "<root><SEARCH/></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocation.jsp?function=FindEndTime&fillperiodunit="+unit+"&incstartdate="+incstartime+"&fillperiod="+fPeriod+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&disp_locn_code="+disp_locn_code+"&proc_type="+proc_type+"&schedule_start="+schedule_start , false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}
function beforePost(str){
	//alert("IP FILL::"+str);
}
function CalculateStartTime(docobj,fillType){
	
	var bean_id		= document.formPHGenerateFillList.bean_id.value ;
	var bean_name	= document.formPHGenerateFillList.bean_name.value ;
	var disp_locn_code	= document.formPHGenerateFillList.disp_locn_code.value ;
	var schedule_start = document.formPHGenerateFillList.schedule_start.value ;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var frmobj		= docobj.formPHGenerateFillList;
	var fPeriod		= frmobj.Ip_Fill_Prd_Ahead.value;
	//alert("fPeriod----->"+fPeriod);
	var incstartime	= frmobj.incstarttime.value;
	var unit		= frmobj.Fill_Period_Unit.value;
	xmlStr			= "<root><SEARCH/></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocation.jsp?function=FindStartTime&fillperiodunit="+unit+"&incstartdate="+incstartime+"&fillperiod="+fPeriod+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&disp_locn_code="+disp_locn_code+"&schedule_start="+schedule_start , false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}

function storeCutOff(){
	//Also calculate and store the cut off hours
	var val	=document.formPHGenerateFillList.fill_int_start_date_time.value;
	var arr	=val.split(" ");
	document.formPHGenerateFillList.cut_off_limit_for_new_ord.value=arr[1];
}
function assignResult( result1, message1, flag1 ,temp) {
	result	= result1 ;
    message	= message1 ;
    flag	= flag1 ;
}

function reset(){
	var	frm	= f_generatefilllist.document.formPHGenerateFillList;
	frm.disp_locn_code.selectedIndex = 0;
	f_generatefilllist.submitDispense("");
}

function disableAll(bool){
	/* This function initially disables all the values */
	frmobj	=formPHGenerateFillList;
	for (i=0;i<frmobj.elements.length ;i++ ){
		elem	=frmobj.elements[i];
		if (bool==false){
			//All the following elements should not be enabled
			if ((elem.name=="allocate_during_fill_yn")||(elem.name=="ip_fill_excl_prd_behind")||(elem.name=="fill_int_start_date_time")||(elem.name=="fill_int_end_date_time")){
				continue;
			}
		}
		if (elem.name!='disp_locn_code'){
			elem.disabled=bool;
		}
	}
}
/* This function submits the page using XML and populates the values */
function clearValues(){
	var	frm=document.formPHGenerateFillList;
	frm.iv_drug_ind.selectedIndex		  = 0;
	frm.compound_drug_ind.selectedIndex	  = 2;
	frm.fillqtynotbyfreq.checked		  = true;
	frm.nursing_unit_or_locn.selectedIndex= 0;
	nursingUnitLocationChange(frm.nursing_unit_or_locn,document);
	frm.Nursing_Unit_From_Code.value	  = "";
	frm.Nursing_Unit_To_Code.value		  = "";
	frm.Nursing_Unit_From.value			  = "";
	frm.Nursing_Unit_To.value			  = "";
	frm.Proc_Type.selectedIndex			  = 0;
	disableFillPeriod(frm.Proc_Type,document);
	frm.order_by_for_list.selectedIndex	  = 0;
	frm.Ip_Fill_Prd_Ahead.value			  = "";
	frm.Fill_Period_Unit.value			  = "";
	frm.fill_int_end_date_time.value	  = "";
	frm.fill_int_start_date_time.value	  = "";
	frm.ip_fill_excl_prd_behind.value	  = "";
	frm.schedule_start.value			  = ""
}
function submitDispense(dcode){
	if (dcode==""){
		//When --select-- is selected
		clearValues();
		disableAll(true);
		document.formPHGenerateFillList.allocate_during_fill_yn.checked=false;
		return;
	}
	clearValues();
	disableAll(false);
	// Call a jsp page which will retrieve all values for the dispense location and pass it back
	var bean_id		= document.formPHGenerateFillList.bean_id.value ;
	var bean_name	= document.formPHGenerateFillList.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH/></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocation.jsp?function=DispenseLocationSelect&bean_id=" + bean_id + "&bean_name=" + bean_name +  "&dispense_code=" + dcode, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}

function CurrentTimeGreater(){
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var bean_id		= document.formPHGenerateFillList.bean_id.value ;
	var bean_name	= document.formPHGenerateFillList.bean_name.value ;
	xmlStr ="<root><SEARCH /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocation.jsp?function=CalculateTime&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
   //Retrieving current hours and minutes
	currHours=document.formPHGenerateFillList.currHours.value;
	currMis=document.formPHGenerateFillList.currMinutes.value;
	sHours=document.formPHGenerateFillList.cHours.value;
	sMinutes=document.formPHGenerateFillList.cMinutes.value;
	//Check if the current time is greater than the schedule start time
	ctgreater=false;
	if (parseInt(currHours)>parseInt(sHours)){
		ctgreater=true;
	}else if (parseInt(currHours)==parseInt(sHours)){
		if (parseInt(currMis)>parseInt(sMinutes)){
			ctgreater=true;
		}
	}
	return ctgreater;
}
async function viewFillList(){
	var formObj = document.formPHGenerateFillList;
	
	var disp_locn_code			 = formObj.disp_locn_code.value;
	var disp_locn_desc			 = formObj.disp_locn_code.options[formObj.disp_locn_code.selectedIndex].text;
	var OrderingFacility_code	 = formObj.OrderingFacility.value;
	var OrderingFacility_desc	 = formObj.OrderingFacility.options[formObj.OrderingFacility.selectedIndex].text;
	var compound_drug_ind		 = formObj.compound_drug_ind.value;
	var	nursing_unit_or_locn	 = formObj.nursing_unit_or_locn.value;
	var	Nursing_Unit_From_desc	 = formObj.Nursing_Unit_From.value;
	var Nursing_Unit_To_desc	 = formObj.Nursing_Unit_To.value;
	if(Nursing_Unit_To_desc==""){
	Nursing_Unit_To_desc=getLabel("Common.Highest.label","Common");
	}
	var	Nursing_Unit_From		 = formObj.Nursing_Unit_From_Code.value;
	var Nursing_Unit_To			 = formObj.Nursing_Unit_To_Code.value;
	var Proc_Type				 = formObj.Proc_Type.value;
	var schedule_start			 = formObj.schedule_start.value;
	var Ip_Fill_Prd_Ahead		 = formObj.Ip_Fill_Prd_Ahead.value;
	var fill_int_start_date_time = formObj.fill_int_start_date_time.value;
	var fill_int_end_date_time	 = formObj.fill_int_end_date_time.value;
	var allocate_during_fill_yn	 = formObj.allocate_during_fill_yn.value;
	var order_by_for_list		 = formObj.order_by_for_list.value;
	var Building_Code			 = formObj.Building_Code.value;
	var Floor_Code				 = formObj.Floor_Code.value;

	var iv_drug_ind					= formObj.iv_drug_ind.value;
	if(formObj.fillqtynotbyfreq.checked== true)
	var ip_excl_intermittent_fill	= "Y";
    else var ip_excl_intermittent_fill	= "N";

	/*var fillqtynotbyfreq			= formObj.fillqtynotbyfreq.value;
	var ip_excl_intermittent_fill	= "Y";
        if(fillqtynotbyfreq != "on")  {ip_excl_intermittent_fill	= "N";} */
  		
	var ip_fill_prd_unit			= formObj.Fill_Period_Unit.value;
	var ip_fill_excl_prd_behind		= formObj.ip_fill_excl_prd_behind.value;	
	var val							= formObj.fill_int_start_date_time.value;
	var arr							= val.split(" ");
	var cut_off_limit_for_new_ord	= arr[1];
	if(Nursing_Unit_From != ''){
		if(parent.f_generatefilllist.CheckString(getLabel("Common.NursingUnitDetails.label","Common"), document.formPHGenerateFillList.Nursing_Unit_From, document.formPHGenerateFillList.Nursing_Unit_To, parent.messageFrame))
         {
		if(Ip_Fill_Prd_Ahead != ''){
			var patient_id = "";
			var dialogHeight= "1000px" ;
			var dialogWidth	= "1500px" ;
			var dialogTop = "0px" ;
			var center = "1px" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal = await window.showModalDialog("../../ePH/jsp/PHViewFillListFrames.jsp?Nursing_Unit_From="+Nursing_Unit_From+"&Nursing_Unit_To="+Nursing_Unit_To+"&Proc_Type="+Proc_Type+"&Ip_Fill_Prd_Ahead="+Ip_Fill_Prd_Ahead+"&disp_locn_code="+disp_locn_code+"&disp_locn_desc="+disp_locn_desc+"&schedule_start="+schedule_start+"&fill_int_start_date_time="+fill_int_start_date_time+"&fill_int_end_date_time="+fill_int_end_date_time+"&compound_drug_ind="+compound_drug_ind+"&nursing_unit_or_locn="+nursing_unit_or_locn+"&Building_Code="+Building_Code+"&Floor_Code="+Floor_Code+"&iv_drug_ind="+iv_drug_ind+"&ip_excl_intermittent_fill="+ip_excl_intermittent_fill+"&ip_fill_prd_unit="+ip_fill_prd_unit+"&ip_fill_excl_prd_behind="+ip_fill_excl_prd_behind+"&order_by_for_list="+order_by_for_list+"&cut_off_limit_for_new_ord="+cut_off_limit_for_new_ord+"&Nursing_Unit_To_desc="+Nursing_Unit_To_desc+"&Nursing_Unit_From_desc="+Nursing_Unit_From_desc+"&OrderingFacility_desc="+OrderingFacility_desc+"&OrderingFacility_code="+OrderingFacility_code,arguments,features);
			//alert("retVal--->"+retVal);
			if(retVal != '' && retVal != undefined){
				var retResult = retVal.split("~");
				if(retResult.length > 1) {
					flag=retResult[0];
					message=retResult[1];
				}
				else
				flag=retResult[0];
				//flag = retVal;
				//message = retVal;
				onSuccess();
			}else{
				parent.f_generatefilllist.location.href = "../../ePH/jsp/PHGenerateFillList.jsp";
			   }
		   }
		    else{ alert(getMessage('FILLPROCESS_FILLPERIOD_CANNOT_BE_BLANK','PH'));	}
	   }//end CheckString	Method 
	} 
	else {
		 alert(getMessage('PH_NURSING_CANNOT_BLANK','PH'));	
	}
}

 function assignAltDrugCode(obj){
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue= obj.value;
}

//Remove selected Drugs or Select Any Drugs

function checkOne(obj){
	if(obj.checked == true){
		obj.value = "Y";
	}else if(obj.checked == false){
		obj.value = "N";	
	}
}

//Remove All selected Drugs or Select All Drugs

function checkAll(obj){
	tot_drugs =  document.formPHViewFillList.total_drugs.value;
	var ip_fill_chk		= "";
	for(i=0;i<tot_drugs; i++){
		ip_fill_chk		= eval("document.formPHViewFillList.ip_fill_chk_"+i);
		if(ip_fill_chk.disabled != true){
			if(obj.checked == true){
				ip_fill_chk.checked = true;
				ip_fill_chk.value	= "Y";
			}else if(obj.checked == false){
				ip_fill_chk.checked = false;
				ip_fill_chk.value	= "N";
			}
		}
	}
}

async function showDrugProfile(patient_id,called_frm){
	var pat_class	=	'IP';

	var dialogHeight	= "800px";//"34" ;
	var dialogWidth		= "1200px" ;
	var dialogTop		= "100" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				= await window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+escape(patient_id)+"&pat_class="+pat_class+"&called_frm=Prescription", arguments, features );
}

async function callMenuFunctions(colval1,colval,orderId,sex,patient_id){
	var dialogHeight ='700px' ;
	var dialogWidth = '1000px' ;
	var dialogTop	= '129';
	var dialogLeft = '11' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
	var arguments = "";
    ord_cat_code = "PH";
	var finalString	= "colval1="+colval1+ "&colval=" +escape(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&ord_cat_code="+ord_cat_code;
	var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}

async function altDrugSearch(disp_locn_code,ord_drug_qty,fill_int_start_date_time,fill_int_end_date_time,ord_drug_code,order_id,Proc_Type,rec_no) {
	recd_no = rec_no;
	var fill_int_end_date = fill_int_end_date_time.substring(0,10);
	var drug_code        =eval("formPHViewFillList.ord_drug_code_"+rec_no).value;

	var bean_id		= document.formPHViewFillList.bean_id.value;
	var bean_name	= document.formPHViewFillList.bean_name.value;
	var dialogHeight= "500px" ;
	var dialogWidth	= "1000px" ;
	var dialogTop = "200" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/PHViewFillLisAltDrgs.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&disp_locn_code="+disp_locn_code+"&ord_drug_qty="+ord_drug_qty+"&fill_int_end_date_time="+fill_int_end_date+"&ord_drug_code="+ord_drug_code,arguments,features);
	if(retVal != undefined && retVal != ""){
		var alt_drug_code = retVal;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "IpFillDispenseLocation.jsp?function=assignAltDrug&bean_id=" + bean_id + "&bean_name=" + bean_name + "&disp_locn_code=" + disp_locn_code + "&alt_drug_code=" + alt_drug_code + "&fill_int_start_date_time=" + fill_int_start_date_time + "&fill_int_end_date_time=" + fill_int_end_date_time + "&order_id=" + order_id + "&Proc_Type=" +Proc_Type+"&drug_code="+drug_code , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}

}

 function assignAltDrugNoBatchDetails()
 {
	 alert(getMessage('NO_BATCHES_FOR_ALLOC','PH'));
 }


function assignAltDrugVals(disp_qty,disp_drug_desc,disp_btch,disp_drg_code,disp_qty_uom){

	var disp_drug_code	= eval("document.formPHViewFillList.drug_code_"+recd_no);
	var disp_drg_name	= document.getElementById("disp_drug_id_"+recd_no);
	var disp_qty_id		= document.getElementById("disp_qty_id_"+recd_no);
	var disp_batch_dtl	= eval("document.formPHViewFillList.disp_batch_dtl_"+recd_no);
	var ip_fill_chk		= eval("document.formPHViewFillList.ip_fill_chk_"+recd_no);
	var disp_qty_uom_id = document.getElementById("disp_qty_uom_id_"+recd_no);
    var disp_uom_id  	= eval("document.formPHViewFillList.disp_uom_id_"+recd_no);

	
	disp_drg_name.innerText		= disp_drug_desc;
	disp_qty_id.innerText		= "     "+disp_qty;
	disp_qty_uom_id.innerText	= "     "+disp_qty_uom;	
	disp_drg_name.style.color	= '#CC6600';
	disp_qty_id.style.cursor	= 'hand';
	disp_qty_id.style.color		= 'blue';
	disp_batch_dtl.value		= disp_btch;
	disp_drug_code.value        = disp_drg_code;
	disp_uom_id.value			= disp_qty_uom;

	ip_fill_chk.disabled = false;
	ip_fill_chk.checked = true;
	ip_fill_chk.value = "Y";
}



async function showBatchDetails(rec_no,order_id){
	
	var disp_drg_name	= document.getElementById("disp_drug_id_"+rec_no);
	var drug_code		= eval("document.formPHViewFillList.drug_code_"+rec_no);
	var store_code		= document.formPHViewFillList.store_code.value;
	var end_date_time   = eval("document.formPHViewFillList.end_date_time_"+rec_no);
	var disp_batch_dtl	= eval("document.formPHViewFillList.disp_batch_dtl_"+rec_no);
	var bean_id		= document.formPHViewFillList.bean_id.value;
	var bean_name	= document.formPHViewFillList.bean_name.value;

   if(disp_drg_name.innerText != ''){
		var batch_dtls = eval("document.formPHViewFillList.disp_batch_dtl_"+rec_no).value;
		var dialogHeight ='55vh' ;
		var dialogWidth = '55vw' ;
		var dialogTop	= '219';
		var dialogLeft = '81' ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var arguments = "";

		var retVals = await window.showModalDialog("../../ePH/jsp/PHViewFillListBtchDtls.jsp?batch_dtls="+batch_dtls+"&drug_code="+drug_code.value+"&store_code="+store_code+"&end_date_time="+end_date_time,arguments,features);
		//alert("retVals---577-->"+retVals)
				
		if(retVals!=undefined && retVals!='') {
			disp_batch_dtl.value = retVals;
			
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "IpFillDispenseLocation.jsp?function=assignBtchDtls&bean_id=" + bean_id + "&bean_name=" + bean_name +"&order_id=" + order_id +"&batch_dtls="+retVals, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval( responseText ) ;
		}
	}
}
async function callBatchSearch(params,item_code,store_code,end_date,batch_qty) {

		var store_code				=	store_code;
		var item_code				=	item_code;
		var includeZeroStockBatches =	"N";
		var includeExpiredBatches	=	"N";
		var includeSuspendedBatches =	"N";
		var searchFunction			=	"Y";
		var multipleSelect			=	"N";
       	var retval=await callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,end_date);
		//alert("retval---->"+retval);
	    if(retval!=undefined && retval!='') {
			
			var record			= retVal.split("`");	
			var exp_date		= record[6];
			var batch_id		= record[0];
			var trade_name		= record[10];
			var bin_location	= record[7];
            var btch_qty		= record[15]; 

	  		/* alert("record[15]---->"+record[15]);
	  		 alert("batch_qty---->"+batch_qty);	*/
	  		

			if(parseInt(record[15])>=parseInt(batch_qty)||parseInt(batch_qty)==''){
				var batch_dtls		= exp_date+"^"+batch_id+"^"+trade_name+"^"+bin_location+"^"+batch_qty;
				document.getElementById('exp_date').innerText		= exp_date;
				document.getElementById('btch_id').innerText		= batch_id;
				document.getElementById('trade_name').innerText	= decodeURIComponent(trade_name);
				document.getElementById('dflt_bin').innerText		= bin_location;
				//if(parseInt(batch_qty)=='0')
			    //document.getElementById("btch_qty").innerText		= record[15];
				//else
				document.getElementById("btch_qty").innerText		= batch_qty;
				let dialogBody = parent.parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue  = batch_dtls;
			}else{
                alert(getMessage('PH_SELECT_BATCH_WITH_MORE_QTY','PH')+batch_qty);
			}
		}
		
}

async function callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect){
	var dialogHeight	= "80vh" ;
	var dialogWidth		= "80vw";
	var dialogTop		= "100" ;
	var dialogLeft		= "200" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	retVal=await top.window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect,arguments,features);
	

	return retVal;
}

function winClose(){
	let dialogBody = parent.parent.document.getElementById('dialog-body');
	if(dialogBody.contentWindow.returnValue != undefined){
		parent.parent.document.getElementById('dialog_tag').close();
	}else{
		dialogBody.contentWindow.returnValue = "";
		parent.parent.document.getElementById('dialog_tag').close();
	}
}

function genFillList(){


    var flag1=true;
    var selectArray  = new Array() ;
	var rec_count=parent.fill_list.document.formPHViewFillList.total_drugs.value;
	for(i=0;i<rec_count;i++)
	{  
		if(eval("parent.fill_list.document.formPHViewFillList.ip_fill_chk_"+i).value)
		    selectArray[i]=eval("parent.fill_list.document.formPHViewFillList.ip_fill_chk_"+i).value;
		if(selectArray[i]=="Y")
			flag1=false;
			
	}
	 if(flag1==true)
	    alert(getMessage('PH_ATLEAST_ONE_SELECTED','PH'));
	 else
	{
		document.formViewFillListButtons.GenerateFillList.disabled=true;

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var bean_id   = parent.fill_list.document.formPHViewFillList.bean_id.value
	    var bean_name = parent.fill_list.document.formPHViewFillList.bean_name.value

		xmlStr ="<root><SEARCH " ;
		xmlStr += "sel_array=\""+ selectArray +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "IpFillDispenseLocation.jsp?function=GENERATEFILLLIST&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
		//if(message=='PH_DOC_TYPE_SETTINGS_NOT_AVAIL')
		//message=getMessage('PH_DOC_TYPE_SETTINGS_NOT_AVAIL','PH')
		//if(!result)
		let dialogBody = parent.parent.document.getElementById('dialog-body');
        dialogBody.contentWindow.returnValue = flag+'<BR>'+message;
		//else
		//window.returnValue = flag;
		//window.close();
		const dialogTag = parent.parent.document.getElementById('dialog_tag');    
		dialogTag.close(); 
	}


}


function ClearNursingUnit()
{
   	document.formPHGenerateFillList.Nursing_Unit_From.value="";
   	document.formPHGenerateFillList.Nursing_Unit_From_Code.value="";
    document.formPHGenerateFillList.Nursing_Unit_To.value="";
    document.formPHGenerateFillList.Nursing_Unit_To_Code.value="";

}
