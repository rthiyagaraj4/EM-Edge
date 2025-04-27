
//saved on 07/11/2005
var result		= false ;
var message		= "" ;
var flag		= "" ; 
var store_code	= "" ;
var scheduleDate=new Date();
var excludeHours;

async function NursingUnitSearch( target ) {
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
	var language_id    = document.formPHGenerateFillList.language_id.value;
	document.getElementById("Floor_Code_id").style.display="none";
	document.formPHGenerateFillList.Floor_Code.style.display="none";
	var sql="SELECT A.NURSING_UNIT_CODE code,SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW A WHERE  A.FACILITY_ID LIKE ? AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(SHORT_DESC )LIKE upper(?) AND EFF_STATUS='E' and a.language_id=";
	var ordering_facility_id = document.formPHGenerateFillList.OrderingFacility.options[document.formPHGenerateFillList.OrderingFacility.selectedIndex].value;
	var nursing_unit_or_locn = document.formPHGenerateFillList.nursing_unit_or_locn.options[document.formPHGenerateFillList.nursing_unit_or_locn.selectedIndex].value;
	var disp_locn_code	= document.formPHGenerateFillList.disp_locn_code.value ;

	if(nursing_unit_or_locn=="L"){
		document.formPHGenerateFillList.Nursing_Unit_To.value=""; 
	   	//var build_Sql="SELECT DISTINCT I.BLDNG_CODE code,C.SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW A, IP_NURSING_UNIT_LOCATION I, PH_ORDER_ROUTING B, AM_BLDNG_LANG_VW C WHERE  A.FACILITY_ID LIKE ? AND B.RTN_ORD_DISP_LOCN_CODE like ? AND a.nursing_unit_code = b.ordering_source_code AND b.ordering_source_type = 'N' AND i.nursing_unit_code = a.nursing_unit_code AND i.bldng_code = c.bldng_code AND i.facility_id = c.operating_facility_id AND a.language_id = c.language_id AND upper(I.BLDNG_CODE) LIKE upper(?) AND upper(C.SHORT_DESC )LIKE upper(?) AND A.EFF_STATUS='E' and a.language_id=";
	   	//var build_Sql="SELECT DISTINCT i.bldng_code code, c.short_desc description FROM ip_nursing_unit_lang_vw a,ip_nursing_unit_location i, ( select rtn_ord_disp_locn_code DISP_LOCN_CODE,ordering_source_code,ordering_source_type from ph_order_routing where   ordering_source_type = 'N' union  select DISP_LOCN_CODE DISP_LOCN_CODE,ordering_source_code,ordering_source_type from ph_alt_disp_locn where  ordering_source_type = 'N')b,am_bldng_lang_vw c WHERE a.facility_id LIKE ?  AND b.DISP_LOCN_CODE LIKE ?  AND a.nursing_unit_code = b.ordering_source_code  AND i.nursing_unit_code = a.nursing_unit_code  AND i.bldng_code = c.bldng_code  AND i.facility_id = c.operating_facility_id  AND a.language_id = c.language_id AND UPPER (i.bldng_code) LIKE UPPER (?) AND UPPER (c.short_desc) LIKE UPPER (?) AND a.eff_status = 'E' AND a.language_id =";
		//Modified Above query by Naveen===Regarding incident num:26055 on21/jan/2011(Displaying all buildings)

		var build_Sql="SELECT DISTINCT i.bldng_code code, c.short_desc description FROM ip_nursing_unit_lang_vw a,ip_nursing_unit_location i,	 am_bldng_lang_vw c WHERE a.facility_id LIKE ?   AND i.nursing_unit_code = a.nursing_unit_code  AND i.bldng_code = c.bldng_code AND i.facility_id = c.operating_facility_id  AND a.language_id = c.language_id  AND UPPER (i.bldng_code) LIKE UPPER (?) AND UPPER (c.short_desc) LIKE UPPER (?)  AND a.eff_status = 'E' AND a.language_id = ";
		dataNameArray[0]   = "FACILITY_ID" ;
		dataValueArray[0]  = ordering_facility_id;
		dataTypeArray[0]   = STRING ;
		//dataNameArray[1]   = "RTN_ORD_DISP_LOCN_CODE" ;
		//dataValueArray[1]  = disp_locn_code;
		//dataTypeArray[1]   = STRING ;
		
		//argumentArray[0]   = document.formPHGenerateFillList.nursing_unit_query.value +"'"+language_id+"' order by 2";
		argumentArray[0]   = build_Sql+"'"+language_id+"' order by I.BLDNG_CODE";
		
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "3,4";
		argumentArray[5]   = target.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;
		retVal=await CommonLookup(getLabel("ePH.BuildingName.label","PH"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if (retVal!="")	{
			target.value = arr[1];
			if (target.name=="Nursing_Unit_From"){
				document.formPHGenerateFillList.Building_Code_From_Code.value=arr[0];
			}
			else if (target.name=="Nursing_Unit_To"){
				document.formPHGenerateFillList.Building_Code_To_Code.value=arr[0];
			}
		}
	}
	else{
		dataNameArray[0]   = "FACILITY_ID" ;
		dataValueArray[0]  = ordering_facility_id;
		dataTypeArray[0]   = STRING ;
		//argumentArray[0]   = document.formPHGenerateFillList.nursing_unit_query.value +"'"+language_id+"' order by 2";
		argumentArray[0]   = sql+"'"+language_id+"' order by A.NURSING_UNIT_CODE";
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "2,3";
		argumentArray[5]   = target.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;

		retVal=await CommonLookup(getLabel("Common.NursingUnitSearch.label","Common"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if (retVal!="")	{
			target.value = arr[1];
			if (target.name=="Nursing_Unit_From"){
				document.formPHGenerateFillList.Nursing_Unit_From_Code.value=arr[0];
			}else if (target.name=="Nursing_Unit_To"){
				document.formPHGenerateFillList.Nursing_Unit_To_Code.value=arr[0];
			}
		}	//END IF
	}//END ELSE
}

function EnablerFloor(docobj){
	if(document.formPHGenerateFillList.Building_Code_To_Code.value!=""&&document.formPHGenerateFillList.Nursing_Unit_To.value!="")
	if(document.formPHGenerateFillList.Building_Code_From_Code.value==document.formPHGenerateFillList.Building_Code_To_Code.value){
		//docobj.floor_id.innerHTML="FloorName&nbsp;";
		var nursing_unit_or_locn = document.formPHGenerateFillList.nursing_unit_or_locn.options[document.formPHGenerateFillList.nursing_unit_or_locn.selectedIndex].value;
		if(nursing_unit_or_locn!="N"){
			document.getElementById("Floor_Code_id").style="display";
			document.formPHGenerateFillList.Floor_Code.style="display";
			//docobj.formPHGenerateFillList.Floor_CodeMandatory.style.display="inline";
			
			var objname		= document.formPHGenerateFillList.Floor_Code.name;
			var bean_id		= document.formPHGenerateFillList.bean_id.value ;
			var bean_name	= document.formPHGenerateFillList.bean_name.value ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH " ;
			xmlStr += objname+"=\""+ checkSpl(document.formPHGenerateFillList.Nursing_Unit_From_Code.value) +"\" " ;
			xmlStr +=" /></root>" ;

			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=BuildingandFloors&bean_id=" + bean_id + "&bean_name=" + bean_name +  "&building_code=" + document.formPHGenerateFillList.Building_Code_From_Code.value, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval( responseText );
		}
	}
	else{
		document.getElementById("Floor_Code_id").style.display="none";
		document.formPHGenerateFillList.Floor_Code.style.display="none";
		//docobj.formPHGenerateFillList.Floor_CodeMandatory.style.display="none";
	}
}

function enableAllFields(docobj){
	docobj.formPHGenerateFillList.Nursing_Unit_From.style.display="inline";
	docobj.formPHGenerateFillList.Nursing_Unit_To.style.display="inline";
	//docobj.formPHGenerateFillList.Building_Code.style.display="inline";
	//docobj.formPHGenerateFillList.Floor_Code.style.display="inline";
	docobj.formPHGenerateFillList.Nursing_Unit_From_Button.style.display="inline";
	docobj.formPHGenerateFillList.Nursing_Unit_To_Button.style.display="inline";
	//docobj.PhysicalLocMandatory1.style.display="inline";
	//docobj.PhysicalLocMandatory2.style.display="inline";
}

function nursingUnitLocationChange(obj,docobj){
	enableAllFields(docobj);
	to=getLabel("Common.to.label","Common");
	from=getLabel("Common.from.label","Common");
	building=getLabel("Common.building.label","Common");
	val=obj.options[obj.selectedIndex].value;
	if (val=='L'){
		docobj.NursingUnitLocnFromTD.innerHTML=building+" "+from;
		docobj.NursingUnitLocnToTD.innerHTML=to;
	  	docobj.formPHGenerateFillList.Nursing_Unit_From.value="";
		docobj.formPHGenerateFillList.Nursing_Unit_To.value="";
		docobj.PhysicalLocMandatory3.style.display="inline";
	}
	else if (val=='N'){
		docobj.NursingUnitLocnFromTD.innerHTML=from;
		docobj.NursingUnitLocnToTD.innerHTML=to;
		docobj.PhysicalLocMandatory3.style.display="none";		
 	    docobj.formPHGenerateFillList.Nursing_Unit_From.value="";
		docobj.formPHGenerateFillList.Nursing_Unit_To.value="";
	}
}
function disableFillPeriod(obj,docobj){
	val=obj.options[obj.selectedIndex].value;
	var Fill_Period_Unit = docobj.formPHGenerateFillList.Fill_Period_Unit.value;
	//docobj.formPHGenerateFillList.FillPeriodUnit.innerHTML = getLabel("Common.days.label","Common");
	if (val=='R'){
		/* Also change the Effective Start Time and End Time */
		var sTime	=docobj.formPHGenerateFillList.Schedule_Start_Time_Routine.value;
		docobj.formPHGenerateFillList.fill_int_start_date_time.value=sTime;
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.selectedIndex=docobj.formPHGenerateFillList.fill_prd_ahead_val.value;
    	//docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.value = "24";
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.disabled=false;
		CalculateEndTime(docobj);
		docobj.formPHGenerateFillList.fill_int_start_date_time.disabled=true;
		//if(Fill_Period_Unit=="H")
			//docobj.formPHGenerateFillList.FillPeriodUnit.innerText = getLabel("Common.hours.label","Common");
	}
	else if (val=='I'){
		//alert('I-docobj.formPHGenerateFillList.Default_Fill_Period.value->'+docobj.formPHGenerateFillList.Default_Fill_Period.value);
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.value=docobj.formPHGenerateFillList.Default_Fill_Period.value;
        frmobj.fill_int_start_date_time.value=frmobj.incstarttime.value;
		//alert("frmobj.fill_int_start_date_time.value=179===>" +frmobj.fill_int_start_date_time.value);
		frmobj.fill_int_end_date_time.value=frmobj.incendtime.value;
		//alert("frmobj.fill_int_end_date_time.value=181===>" +frmobj.fill_int_end_date_time.value);
		CalculateStartTime(docobj);
		CalculateEndTime(docobj);
		//docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.value = docobj.formPHGenerateFillList.temp_fill_prd_ahead.value;
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.options[docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.selectedIndex].text="1";
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.value = "24";
		docobj.formPHGenerateFillList.Ip_Fill_Prd_Ahead.disabled=false;
	}
}
 
function clearData(obj) {
	/*obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');	*/
   
   obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}


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
	}
	else{
		blankObject.focus() ;
	}
}

async function onSuccess(frmobj){
	if(message != '')
		flag = flag+':'+message;
	parent.messageFrame.location.href		= "../../eCommon/jsp/error.jsp?err_num=<br> <B>"+getMessage("FILL_PROC_ID_IS","PH") +":"+flag+"</B>";
	parent.f_generatefilllist.location.href = "../../ePH/jsp/PHGenerateFillListAll.jsp";
	disp_locn_code=document.formPHGenerateFillList.disp_locn_code.value
    proc_type	= document.formPHGenerateFillList.Proc_Type.value ;
	var fill_proc_id		= flag.split("<BR>");	
	var dialogHeight	= "30vh";//"34" ;
	var dialogWidth		= "40vw" ;
	var dialogTop		= "100" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await top.window.showModalDialog( "../../ePH/jsp/IpFillOnlineReport.jsp?disp_locn_code="+disp_locn_code+"&flag="+fill_proc_id[0]+"&proc_type="+proc_type, arguments, features );
}

function OnlineReport(fill_proc_id,disp_locn_code,proc_type,to_date){

   var frmobj=document.IpFillOnlineReportForm;
   var certificate_reimbursement="";
   if(document.IpFillOnlineReportForm.certificate_reimbursement)
	certificate_reimbursement = document.IpFillOnlineReportForm.certificate_reimbursement.value;
   var dispense_sheet="";
   if(document.IpFillOnlineReportForm.dispense_sheet)
	   dispense_sheet = document.IpFillOnlineReportForm.dispense_sheet.value;
   var drug_label= "";
   if(document.IpFillOnlineReportForm.drug_label)
	drug_label = document.IpFillOnlineReportForm.drug_label.value;
   var fill_list_drugmedical="";
   if(document.IpFillOnlineReportForm.fill_list_drugmedical)
	fill_list_drugmedical = document.IpFillOnlineReportForm.fill_list_drugmedical.value;
   var fill_list_patient= "";
   if(document.IpFillOnlineReportForm.fill_list_patient)
    fill_list_patient=document.IpFillOnlineReportForm.fill_list_patient.value;
   //var fill_list_unallocated=document.IpFillOnlineReportForm.fill_list_unallocated.value;
   var fill_list_unallocated="N";
   var medical_supply_label= "";
   if(document.IpFillOnlineReportForm.medical_supply_label)
	   medical_supply_label = document.IpFillOnlineReportForm.medical_supply_label.value;
   var medication_list="";
   if(document.IpFillOnlineReportForm.medication_list)
	 medication_list = document.IpFillOnlineReportForm.medication_list.value;
   var drug_yn="";
	if(drug_label=="PD" && medical_supply_label=="PT"){
	   drug_yn="Y";
	}else if(drug_label=="PT" && medical_supply_label=="PD"){
	   drug_yn="N";
	}else if(drug_label=="PD" && medical_supply_label=="PD"){
	   drug_yn="";
	}  

	var bean_id = "IpFillAllBean" ;
	var bean_name = "ePH.IpFillAllBean";
	//var xmlDoc				=	new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp		        =	new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	
	var xmlDoc				=	"" ;
	var xmlHttp		        =	new XMLHttpRequest();	

	var xmlAppend				=	"";
	xmlAppend += "certificate_reimbursement"+"=\""+certificate_reimbursement+"\" " ;	
	xmlAppend += "dispense_sheet"+"=\""+dispense_sheet+"\" " ;	
	xmlAppend += "drug_label"+"=\""+drug_label+"\" " ;	
	xmlAppend += "fill_list_drugmedical"+"=\""+fill_list_drugmedical+"\" " ;	
	xmlAppend += "fill_list_patient"+"=\""+fill_list_patient+"\" " ;	
	xmlAppend += "fill_list_unallocated"+"=\""+fill_list_unallocated+"\" " ;	
	xmlAppend += "medical_supply_label"+"=\""+medical_supply_label+"\" " ;	
	xmlAppend += "medication_list"+"=\""+medication_list+"\" " ;	
	xmlAppend += "fill_proc_id"+"=\""+fill_proc_id+"\" " ;	
	xmlAppend += "disp_locn_code"+"=\""+disp_locn_code+"\" " ;	
	xmlAppend += "proc_type"+"=\""+proc_type+"\" " ;	
	xmlAppend += "to_date"+"=\""+to_date+"\" " ;	
	xmlAppend += "drug_yn"+"=\""+drug_yn+"\" " ;	

	var  xmlStr ="<root><SEARCH " ;
	xmlStr = xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
	xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=onlineReport&bean_id=" + bean_id + "&bean_name=" + bean_name, true ) ; //changed from false(synchronous) to true(asynchronous) - IP FILL PROCESS ALL - on click of OK on print dialog after generation, the screen is freezing for some time and then it is releasing. 
	xmlHttp.send( xmlDoc ) ;
	//responseText=xmlHttp.responseText ; //commented for asynchronous call
	//eval( responseText ) ;	 //commented for asynchronous call
	window.close();
	
    
    //const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    //dialogTag.close();  
}
function certificate_reimbursement1(obj){

	if (obj.checked)
	 obj.value="CERTIFICATE_REIMBURSEMENT";
	else
	 obj.value="";  
}

function dispense_sheet1(obj){

	if (obj.checked)
	 obj.value="DISPENSE_SHEET";
	else
	 obj.value="";  
}

function drug_label1(obj){
	if (obj.checked)
	 obj.value="DRUG_LABEL";
	else
	 obj.value="";  
}

function fill_list_drugmedical1(obj){

	if (obj.checked)
	 obj.value="FILL_LIST_DRUGMEDICAL";
	else
	 obj.value="";  
}


function fill_list_patient1(obj){

	if (obj.checked)
	 obj.value="FILL_LIST_PATIENT";
	else
	 obj.value="";  
}

function fill_list_unallocated1(obj){

	if (obj.checked)
	 obj.value="FILL_LIST_UNALLOCATED";
	else
	 obj.value="";  
}

function medical_supply_label1(obj){

	if (obj.checked)
	 obj.value="MEDICAL_SUPPLY_LABEL";
	else
	 obj.value="";  
}

function medication_list1(obj){

	if (obj.checked)
	 obj.value="MEDICATION_LIST";
	else
	 obj.value="";  
}

function CalculateEndTime(docobj,fillType){
	
	var bean_id		= document.formPHGenerateFillList.bean_id.value ;
	var bean_name	= document.formPHGenerateFillList.bean_name.value ;
	var disp_locn_code	= document.formPHGenerateFillList.disp_locn_code.value ;
	var proc_type	= document.formPHGenerateFillList.Proc_Type.value ;
	var locale			= document.formPHGenerateFillList.p_language_id.value;
	//Converting Schedule Date for the incident num:24346 on 12/Oct/2010 --By Sandhya
	//var schedule_start = document.formPHGenerateFillList.schedule_start.value;
	var schedule_start = convertDate(document.formPHGenerateFillList.schedule_start.value,'DMYHM',locale,"en") ;
	//alert("schedule_start=====406==>" +schedule_start);
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var frmobj		= docobj.formPHGenerateFillList;
	var fPeriod		= frmobj.Ip_Fill_Prd_Ahead.value;
	var incstartime	= frmobj.incstarttime.value;
	var unit		= frmobj.Fill_Period_Unit.value;
	var date1="";

	if(schedule_start != ''){
		schedule_start = schedule_start.substring(0,10);
	}
	xmlStr			= "<root><SEARCH/></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=FindEndTime&fillperiodunit="+unit+"&incstartdate="+incstartime+"&fillperiod="+fPeriod+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&disp_locn_code="+disp_locn_code+"&proc_type="+proc_type+"&schedule_start="+schedule_start , false ) ;
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
	var locale			= document.formPHGenerateFillList.p_language_id.value;
	var schedule_start = document.formPHGenerateFillList.schedule_start.value ;
	//var schedule_start = convertDate(document.formPHGenerateFillList.schedule_start.value,'DMYHM',locale,"en");
	
	//alert("schedule_start====442===>" +schedule_start);

//alert("schedule_start====444===>" +schedule_start);
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var frmobj		= docobj.formPHGenerateFillList;
	var fPeriod		= frmobj.Ip_Fill_Prd_Ahead.value;
	//alert("fPeriod----->"+fPeriod);
	var incstartime	= frmobj.incstarttime.value;
	//alert("incstartime----->"+incstartime);
	//alert("fPeriod----->"+fPeriod);
	var unit		= frmobj.Fill_Period_Unit.value;
	xmlStr			= "<root><SEARCH/></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=FindStartTime&fillperiodunit="+unit+"&incstartdate="+incstartime+"&fillperiod="+fPeriod+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&disp_locn_code="+disp_locn_code+"&schedule_start="+schedule_start , false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}

/* =======================================================================================================*/
function Check_fill_int_start_date_time(fill_int_start_date_time,locale)
{

	//alert(getCurrentDate('DMYHM',locale));
	
	var eff_start_time = fill_int_start_date_time.value;

	var date =getCurrentDate('DMYHM',locale).substring(0,10);
	var date_time = date+" 00:01";

	if((Date.parse(eff_start_time) > Date.parse(getCurrentDate('DMYHM',locale))) || (Date.parse(eff_start_time) < Date.parse(date_time)))
	{
	
		alert(getMessage("EFFECTIVE_START_TIME BETWEEN","PH")+" "+date_time+" "+getLabel("Common.and.label","Common")+" "+getCurrentDate('DMYHM',locale));
		fill_int_start_date_time.focus();
	}

}

function ValidateTime(obj){

	if(obj.value!=""){
		if(!doDateTimeChk(obj)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.value="";
			//obj.focus;
			return false;
		}
		
	}
		return true;
}

/*function getCurrentDateTime()
{
	  var now         = new Date();
   
   var monthnumber = now.getMonth()+1;
  
   var monthday    = now.getDate();
   var year        = now.getYear();
      if (monthnumber   < 10) { monthnumber   = "0" + monthnumber;   }
   if (monthday < 10) { monthday = "0" + monthday; }

    var hour   = now.getHours();
   var minute = now.getMinutes();
   var second = now.getSeconds();

     if (hour   < 10) { hour   = "0" + hour;   }
   if (minute < 10) { minute = "0" + minute; }

   var curr_date_time = monthday+"/"+monthnumber+"/"+year+" "+hour+":"+minute;

   return(curr_date_time);
} */



/* =======================================================================================================*/


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
			if ((elem.name=="allocate_during_fill_yn")||(elem.name=="allocate_during_fill_yn")||(elem.name=="ip_fill_excl_prd_behind")||(elem.name=="fill_int_start_date_time")||(elem.name=="fill_int_end_date_time")){
				continue;
			}
		}
		if (elem.name!='disp_locn_code'){
			elem.disabled=bool;
		}
		frmobj.schedule_start_cal.style.pointerEvents = bool ? 'none' : ''; //shyampriya
	}
}
/* This function submits the page using XML and populates the values */
function clearValues(){
	var	frm=document.formPHGenerateFillList;
	frm.iv_drug_ind.selectedIndex		  = 0;
	frm.compound_drug_ind.selectedIndex	  = 2;
	frm.fillqtynotbyfreq.checked		  = false;
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
	frm.Floor_Code.value			      = ""
	frm.incstarttime.value			      = ""
	frm.incendtime.value			      = ""
	document.getElementById("Floor_Code_id").style.display="none";
	document.formPHGenerateFillList.Floor_Code.style.display="none";
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
	xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=DispenseLocationSelect&bean_id=" + bean_id + "&bean_name=" + bean_name +  "&dispense_code=" + dcode, false ) ;
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
	xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=CalculateTime&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
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
	}
	else if (parseInt(currHours)==parseInt(sHours)){
		if (parseInt(currMis)>parseInt(sMinutes)){
			ctgreater=true;
		}
	}
	return ctgreater;
}
  
async function viewFillList(){
	var formObj = document.formPHGenerateFillList;
	var	nursing_unit_or_locn	 = formObj.nursing_unit_or_locn.value;
	
	if(nursing_unit_or_locn=='L')
	if(!CheckString(getLabel("ePH.BuildingID.label","PH"), document.formPHGenerateFillList.Building_Code_From_Code,  document.formPHGenerateFillList.Building_Code_To_Code, parent.messageFrame) ){
	  return;
	}
	var disp_locn_code			 = formObj.disp_locn_code.value;
	var disp_locn_desc			 = formObj.disp_locn_code.options[formObj.disp_locn_code.selectedIndex].text;
	var OrderingFacility_code	 = formObj.OrderingFacility.value;
	var OrderingFacility_desc	 = formObj.OrderingFacility.options[formObj.OrderingFacility.selectedIndex].text;
	var compound_drug_ind		 = formObj.compound_drug_ind.value;
	
	var	Nursing_Unit_From_desc	 = formObj.Nursing_Unit_From.value;
	var Nursing_Unit_To_desc	 = formObj.Nursing_Unit_To.value;
	
	if(Nursing_Unit_From_desc==""){
		Nursing_Unit_From_desc=getLabel("Common.Lowest.label","Common");
	}
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
	
	var Building_Code_from		 = formObj.Building_Code_From_Code.value;
	var Building_Code_to		 = formObj.Building_Code_To_Code.value;
	var Floor_Code				 = formObj.Floor_Code.value;
	var ip_medical_items		 = formObj.MedicalItems.value;
	var iv_drug_ind					= formObj.iv_drug_ind.value;
	if(formObj.fillqtynotbyfreq.checked== true)
		var ip_excl_intermittent_fill	= "Y";
    else 
		var ip_excl_intermittent_fill	= "N";

	if(formObj.PrnDrugs.checked== true)
		var ip_prn_drugs	= "P";
    else 
		var ip_prn_drugs	= "I";
	  		
	var ip_fill_prd_unit			= formObj.Fill_Period_Unit.value;
	var ip_fill_excl_prd_behind		= formObj.ip_fill_excl_prd_behind.value;	
	var val							= formObj.fill_int_start_date_time.value;
	var arr							= val.split(" ");
	var cut_off_limit_for_new_ord	= arr[1];
	//if (isValidFromToField(formObj.Nursing_Unit_From_Code, formObj.Nursing_Unit_To_Code, STRING, getLabel("Common.StoreCode.label", "Common"), parent.messageFrame)) {
	 //return;
	//}	
	if(nursing_unit_or_locn=='N'){
		if(!CheckString(getLabel("Common.nursingUnit.label", "Common"), formObj.Nursing_Unit_From_Code, formObj.Nursing_Unit_To_Code, parent.messageFrame) ){
			return;
		}
	}

	if(nursing_unit_or_locn=='L'){
		if(nursing_unit_or_locn=='L' && Building_Code_from!=''){
			if(Ip_Fill_Prd_Ahead != ''){
				var patient_id = "";
				var dialogHeight= "42vh" ;
				var dialogWidth	= "64vw" ;
				var dialogTop = "72" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

				var arguments	= "" ;
				//alert("&ip_prn_drugs="+ip_prn_drugs+"&ip_medical_items="+ip_medical_items);
				
				retVal =await window.showModalDialog("../../ePH/jsp/PHViewFillListFramesAll.jsp?Nursing_Unit_From="+Nursing_Unit_From+"&Nursing_Unit_To="+Nursing_Unit_To+"&Proc_Type="+Proc_Type+"&Ip_Fill_Prd_Ahead="+Ip_Fill_Prd_Ahead+"&disp_locn_code="+disp_locn_code+"&disp_locn_desc="+encodeURIComponent(disp_locn_desc,"UTF-8")+"&schedule_start="+schedule_start+"&fill_int_start_date_time="+fill_int_start_date_time+"&fill_int_end_date_time="+fill_int_end_date_time+"&compound_drug_ind="+compound_drug_ind+"&nursing_unit_or_locn="+nursing_unit_or_locn+"&Building_Code_from="+Building_Code_from+"&Building_Code_to="+Building_Code_to+"&Floor_Code="+Floor_Code+"&iv_drug_ind="+iv_drug_ind+"&ip_excl_intermittent_fill="+ip_excl_intermittent_fill+"&ip_fill_prd_unit="+ip_fill_prd_unit+"&ip_fill_excl_prd_behind="+ip_fill_excl_prd_behind+"&order_by_for_list="+order_by_for_list+"&cut_off_limit_for_new_ord="+cut_off_limit_for_new_ord+"&Nursing_Unit_To_desc="+encodeURIComponent(Nursing_Unit_To_desc,"UTF-8")+"&Nursing_Unit_From_desc="+encodeURIComponent(Nursing_Unit_From_desc,"UTF-8")+"&OrderingFacility_desc="+encodeURIComponent(OrderingFacility_desc)+"&OrderingFacility_code="+OrderingFacility_code+"&ip_prn_drugs="+ip_prn_drugs+"&ip_medical_items="+ip_medical_items,arguments,features);
				//window.open("../../ePH/jsp/PHViewFillListFramesAll.jsp?Nursing_Unit_From="+Nursing_Unit_From+"&Nursing_Unit_To="+Nursing_Unit_To+"&Proc_Type="+Proc_Type+"&Ip_Fill_Prd_Ahead="+Ip_Fill_Prd_Ahead+"&disp_locn_code="+disp_locn_code+"&disp_locn_desc="+disp_locn_desc+"&schedule_start="+schedule_start+"&fill_int_start_date_time="+fill_int_start_date_time+"&fill_int_end_date_time="+fill_int_end_date_time+"&compound_drug_ind="+compound_drug_ind+"&nursing_unit_or_locn="+nursing_unit_or_locn+"&Building_Code_from="+Building_Code_from+"&Building_Code_to="+Building_Code_to+"&Floor_Code="+Floor_Code+"&iv_drug_ind="+iv_drug_ind+"&ip_excl_intermittent_fill="+ip_excl_intermittent_fill+"&ip_fill_prd_unit="+ip_fill_prd_unit+"&ip_fill_excl_prd_behind="+ip_fill_excl_prd_behind+"&order_by_for_list="+order_by_for_list+"&cut_off_limit_for_new_ord="+cut_off_limit_for_new_ord+"&Nursing_Unit_To_desc="+Nursing_Unit_To_desc+"&Nursing_Unit_From_desc="+Nursing_Unit_From_desc+"&OrderingFacility_desc="+OrderingFacility_desc+"&OrderingFacility_code="+OrderingFacility_code+"&ip_prn_drugs="+ip_prn_drugs+"&ip_medical_items="+ip_medical_items,arguments,features);
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
				}
				else{
					parent.f_generatefilllist.location.href = "../../ePH/jsp/PHGenerateFillListAll.jsp";
				}
			}
			else{ alert(getMessage('FILLPROCESS_FILLPERIOD_CANNOT_BE_BLANK','PH'));	}
	  
		} 
		else {
			if(nursing_unit_or_locn=='L') 
			alert(getMessage('BUILD_NAME_CANNOT_BLANK','PH'));
		}
	}
	else{
		if(Ip_Fill_Prd_Ahead != ''){
			var patient_id = "";
			var dialogHeight= "1000px" ;
			var dialogWidth	= "1200px" ;
			var dialogTop = "72" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

			var arguments	= "" ;
			//PAssed EncodeURIComponent for Nursing_Unit_From_desc,Nursing_Unit_To_desc to get into Thai regarding incident  num:25067 on 25/Nov/2010==By Sandhya
			retVal =await window.showModalDialog("../../ePH/jsp/PHViewFillListFramesAll.jsp?Nursing_Unit_From="+Nursing_Unit_From+"&Nursing_Unit_To="+Nursing_Unit_To+"&Proc_Type="+Proc_Type+"&Ip_Fill_Prd_Ahead="+Ip_Fill_Prd_Ahead+"&disp_locn_code="+disp_locn_code+"&disp_locn_desc="+encodeURIComponent(disp_locn_desc,"UTF-8")+"&schedule_start="+schedule_start+"&fill_int_start_date_time="+fill_int_start_date_time+"&fill_int_end_date_time="+fill_int_end_date_time+"&compound_drug_ind="+compound_drug_ind+"&nursing_unit_or_locn="+nursing_unit_or_locn+"&Building_Code_from="+Building_Code_from+"&Building_Code_to="+Building_Code_to+"&Floor_Code="+Floor_Code+"&iv_drug_ind="+iv_drug_ind+"&ip_excl_intermittent_fill="+ip_excl_intermittent_fill+"&ip_fill_prd_unit="+ip_fill_prd_unit+"&ip_fill_excl_prd_behind="+ip_fill_excl_prd_behind+"&order_by_for_list="+order_by_for_list+"&cut_off_limit_for_new_ord="+cut_off_limit_for_new_ord+"&Nursing_Unit_To_desc="+encodeURIComponent(Nursing_Unit_To_desc,"UTF-8")+"&Nursing_Unit_From_desc="+encodeURIComponent(Nursing_Unit_From_desc,"UTF-8")+"&OrderingFacility_desc="+encodeURIComponent(OrderingFacility_desc,"UTF-8")+"&OrderingFacility_code="+OrderingFacility_code+"&ip_prn_drugs="+ip_prn_drugs+"&ip_medical_items="+ip_medical_items,arguments,features);
			//window.open("../../ePH/jsp/PHViewFillListFramesAll.jsp?Nursing_Unit_From="+Nursing_Unit_From+"&Nursing_Unit_To="+Nursing_Unit_To+"&Proc_Type="+Proc_Type+"&Ip_Fill_Prd_Ahead="+Ip_Fill_Prd_Ahead+"&disp_locn_code="+disp_locn_code+"&disp_locn_desc="+disp_locn_desc+"&schedule_start="+schedule_start+"&fill_int_start_date_time="+fill_int_start_date_time+"&fill_int_end_date_time="+fill_int_end_date_time+"&compound_drug_ind="+compound_drug_ind+"&nursing_unit_or_locn="+nursing_unit_or_locn+"&Building_Code_from="+Building_Code_from+"&Building_Code_to="+Building_Code_to+"&Floor_Code="+Floor_Code+"&iv_drug_ind="+iv_drug_ind+"&ip_excl_intermittent_fill="+ip_excl_intermittent_fill+"&ip_fill_prd_unit="+ip_fill_prd_unit+"&ip_fill_excl_prd_behind="+ip_fill_excl_prd_behind+"&order_by_for_list="+order_by_for_list+"&cut_off_limit_for_new_ord="+cut_off_limit_for_new_ord+"&Nursing_Unit_To_desc="+Nursing_Unit_To_desc+"&Nursing_Unit_From_desc="+Nursing_Unit_From_desc+"&OrderingFacility_desc="+OrderingFacility_desc+"&OrderingFacility_code="+OrderingFacility_code+"&ip_prn_drugs="+ip_prn_drugs+"&ip_medical_items="+ip_medical_items,arguments,features);
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
			}
			else{
				parent.f_generatefilllist.location.href = "../../ePH/jsp/PHGenerateFillListAll.jsp";
			}
		}
		else{
			alert(getMessage('FILLPROCESS_FILLPERIOD_CANNOT_BE_BLANK','PH'));	
		}
	}
}
/*
function assignAltDrugCode(obj){
	 window.returnValue = obj.value;
}*/ //not used

//Remove selected Drugs or Select Any Drugs
function checkOne(obj,i,iv_count){
	if(obj.checked == true){
		obj.value = "Y";
	}
	else if(obj.checked == false){
		obj.value = "N";	
	}
	var frmobj      = document.formPHViewFillList;
	var j           = 0;
	order_id_org	= eval("document.formPHViewFillList.order_id_"+i).value;
	var tot_drugs   = document.formPHViewFillList.total_drugs.value;
	var k           = 1;

	for (j=parseInt(i)+1;j<tot_drugs;j++){
			order_id_l	= eval("document.formPHViewFillList.order_id_"+j).value;
			if(order_id_l != order_id_org) {
				break;
			}
			 if(obj.checked == true){   
				 if(eval("frmobj.ip_fill_chk_"+j).disabled == true){
					  if((parseInt(eval("document.getElementById('disp_qty_id_')"+j).innerText) >0 &&parseInt(eval("document.getElementById('disp_qty_id_')"+i).innerText)>0)&&(eval("frmobj.drug_choice_"+i).value !='N'&&eval("frmobj.drug_choice_"+j).value !='N')&&(eval("frmobj.drug_choice_"+i).value =='C' && eval("frmobj.drug_choice_"+j).value =='C')){	 
						eval("frmobj.ip_fill_chk_"+j).checked = true;
						eval("frmobj.ip_fill_chk_"+j).value	  = "Y";
					  }
					  else{
						 // alert(eval("frmobj.drug_choice_"+i).value+"====="+eval("frmobj.drug_choice_"+j).value);
						if((eval("frmobj.drug_choice_"+i).value =='N' ||eval("frmobj.drug_choice_"+j).value =='N') ||(eval("frmobj.drug_choice_"+i).value =='C' ||eval("frmobj.drug_choice_"+j).value =='C') ){
							 alert(getMessage('PH_DIRECT_DISPENCING_NO_STOCK','PH'));
							 eval("frmobj.ip_fill_chk_"+i).checked = false;
							 eval("frmobj.ip_fill_chk_"+i).value	  = "N";
							 eval("frmobj.ip_fill_chk_"+j).checked = false;
							 eval("frmobj.ip_fill_chk_"+j).value	  = "N";
						}
						else{
							 eval("frmobj.ip_fill_chk_"+i).checked = true;
							 eval("frmobj.ip_fill_chk_"+i).value	  = "Y"; // value="N" changed to "Y" for SKR-SCF-0118-29120
							 eval("frmobj.ip_fill_chk_"+j).checked = true;
							 eval("frmobj.ip_fill_chk_"+j).value	  = "Y"; // value="N" changed to "Y" for SKR-SCF-011-29120
						}							 
					}
				 }
				 else{
					break;
				 }
			}
			else if(obj.checked == false){
				if(eval("frmobj.ip_fill_chk_"+j).disabled == true){
					eval("frmobj.ip_fill_chk_"+j).checked = false;
					eval("frmobj.ip_fill_chk_"+j).value	  = "N";
				}
				else{
					break;
				}
			}
	}//end for
}

function checktwo(cnt,iv_count){
	var frmobj                      = document.formPHViewFillList;	
	var i                           = parseInt(cnt)-parseInt(iv_count)-1; //two find out order_id counter
	var fluid_order_id	            = eval("document.formPHViewFillList.order_id_"+i).value;
	var fluid_order_id_drug_choice	= eval("document.formPHViewFillList.drug_choice_"+i).value;
	var flag ="N";

    for (j=parseInt(i);j<cnt;j++){
		var order_id_l	= eval("document.formPHViewFillList.order_id_"+(j)).value;
		if(order_id_l != fluid_order_id) {
			break;
		}
		if(eval("document.formPHViewFillList.drug_choice_"+j).value=="N" || eval("document.formPHViewFillList.drug_choice_"+j).value=="C"){
			flag	="Y";
			break;
		}
	}

	if(fluid_order_id_drug_choice=='N' ||fluid_order_id_drug_choice=='N'||flag=='Y'){
		for (j=parseInt(i);j<cnt;j++){
            var order_id_l	= eval("document.formPHViewFillList.order_id_"+(j)).value;
			if(order_id_l != fluid_order_id) {
				break;
			}
			//alert(eval("document.formPHViewFillList.ip_fill_chk_"+j).name);
			eval("document.formPHViewFillList.ip_fill_chk_"+j).checked     = false;
			eval("document.formPHViewFillList.ip_fill_chk_"+j).value	   = "N";
			eval("document.formPHViewFillList.check_box_checked_yn_"+j).value	   = "N";
	    }
	}
}

//Remove All selected Drugs or Select All Drugs
function checkAll(obj){
	var frmobj			=  document.formPHViewFillList;
	tot_drugs			=  document.formPHViewFillList.total_drugs.value;
	var ip_fill_chk		=  "";
	var prev_order_id_1	=  "";
	var temp			=  true;
	var count			=  0;
	var iv_prep_yn="";

	for(i=0;i<tot_drugs; i++){
				ip_fill_chk		= eval("document.formPHViewFillList.ip_fill_chk_"+i);
				if(obj.checked == true){
					order_id_1		= eval("document.formPHViewFillList.order_id_"+i).value;
					order_line_num_1= eval("document.formPHViewFillList.order_line_num_"+i).value;
					disp_qty        = parseInt(document.getElementById('disp_qty_id_'+i).innerText);
					drug_choice     = eval("document.formPHViewFillList.drug_choice_"+i).value;
					iv_prep_yn      = eval("document.formPHViewFillList.iv_prep_yn_"+i).value;

					if( drug_choice == "M" || drug_choice == "N" || drug_choice == "C" ){
						ip_fill_chk.checked = false;
						ip_fill_chk.value	= "N";
						continue;
					}
					if( iv_prep_yn!=''){
						if(eval("document.formPHViewFillList.check_box_checked_yn_"+i).value=='Y' && disp_qty>0){
								ip_fill_chk.checked = true;
								ip_fill_chk.value	= "Y";
						}
				    }else{
					    if(disp_qty>0){
							ip_fill_chk.checked = true;
							ip_fill_chk.value	= "Y";
						}
				    }

					//var j=0;
					//commented by naveen on 20Dec2010
					/*if(prev_order_id_1!=order_id_1){
					    if(disp_qty>0){
							ip_fill_chk.checked = true;
							ip_fill_chk.value	= "Y";
						}
						prev_order_id_1=order_id_1;
						if(temp==false)
						{
							for(var k=count;k>0;k--)
							{
								 var h =(parseInt(i)-parseInt(k))-1
								 if(disp_qty<0){
									 ip_fill_chk_temp=eval("document.formPHViewFillList.ip_fill_chk_"+h);
									 ip_fill_chk_temp.checked = false;
									 ip_fill_chk_temp.value	= "N";
								  }
							}
							temp=true;
							count=0;
						}
					}else if(prev_order_id_1==order_id_1)
					{
					   if(disp_qty>0){
							ip_fill_chk.checked = true;
							ip_fill_chk.value	= "Y";
						}else{
							temp=false;			
						 }
						 count++;
						 prev_order_id_1=order_id_1;

				 }*/
			}else if(obj.checked == false){
						ip_fill_chk.checked = false;
						ip_fill_chk.value	= "N";
			 }
	
	}
   
}

async function showDrugProfile(patient_id,called_frm){

	var pat_class	=	'IP';
	var dialogHeight	= "800px";//"34" ;
	var dialogWidth		= "1000px" ;
	var dialogTop		= "100" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+escape(patient_id)+"&pat_class="+pat_class+"&called_frm=Prescription", arguments, features );
}

async function callMenuFunctions(colval1,colval,orderId,sex,patient_id){
	var dialogHeight ='700px' ;
	var dialogWidth = '900px' ;
	var dialogTop	= '129';
	var dialogLeft = '11' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
	var arguments = "";
    ord_cat_code = "PH";
	var finalString	= "colval1="+colval1+ "&colval=" +escape(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&ord_cat_code="+ord_cat_code;
	 
	var retVals =await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}

async function altDrugSearch(disp_locn_code,ord_drug_qty,fill_int_start_date_time,fill_int_end_date_time,ord_drug_code,order_id,order_line_num,Proc_Type,rec_no,iv_prep_yn,nursing_unit_or_locn,Nursing_Unit_From,Nursing_Unit_To,Building_Code,Building_Code_to,Floor_Code,ip_fill_excl_prd_behind,compound_drug_ind,ip_medical_items,ip_excl_intermittent_fill,ip_prn_drugs, alt_drug_remarks_ind) {
	recd_no = rec_no;
	var fill_int_end_date = fill_int_end_date_time.substring(0,10);
	var drug_code        =eval("formPHViewFillList.ord_drug_code_"+rec_no).value;

	var bean_id		= document.formPHViewFillList.bean_id.value;
	var bean_name	= document.formPHViewFillList.bean_name.value;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "200" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal =await window.showModalDialog("../../ePH/jsp/PHViewFillLisAltDrgsAll.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&disp_locn_code="+disp_locn_code+"&ord_drug_qty="+ord_drug_qty+"&fill_int_end_date_time="+fill_int_end_date+"&ord_drug_code="+ord_drug_code+"&order_id="+order_id+"&order_line_num="+order_line_num,arguments,features);
	if(retVal != undefined && retVal != ""){
		var alt_drug_code = retVal;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=assignAltDrug&bean_id=" + bean_id + "&bean_name=" + bean_name + "&disp_locn_code=" + disp_locn_code + "&alt_drug_code=" + alt_drug_code + "&fill_int_start_date_time=" + fill_int_start_date_time + "&fill_int_end_date_time=" + fill_int_end_date_time + "&order_id=" + order_id + "&order_line_num=" + order_line_num +"&Proc_Type=" + Proc_Type+ "&drug_code="+drug_code+ "&iv_prep_yn="+iv_prep_yn+ "&nursing_unit_or_locn="+ nursing_unit_or_locn+"&Nursing_Unit_From="+Nursing_Unit_From+"&Nursing_Unit_To="+Nursing_Unit_To+"&Building_Code="+Building_Code+"&Building_Code_to="+Building_Code_to+"&Floor_Code="+Floor_Code+"&ip_fill_excl_prd_behind="+ip_fill_excl_prd_behind+"&compound_drug_ind="+compound_drug_ind+"&ip_medical_items="+ip_medical_items+"&ip_excl_intermittent_fill="+ip_excl_intermittent_fill+"&ip_prn_drugs="+ip_prn_drugs+"&alt_drug_remarks_ind="+alt_drug_remarks_ind, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
}

function assignAltDrugNoBatchDetails(){
	 alert(getMessage('NO_BATCHES_FOR_ALLOC','PH'));
}

function assignAltDrugVals(disp_qty,disp_drug_desc,disp_btch,disp_drg_code,disp_qty_uom,disp_qty_uom_desc, alt_drug_remarks_ind){

	var disp_drug_code	= eval("document.formPHViewFillList.drug_code_"+recd_no);
	var disp_drg_name	= eval("document.getElementById('disp_drug_id_')"+recd_no);
	var disp_qty_id		= eval("document.getElementById('disp_qty_id_')"+recd_no);
	var disp_batch_dtl	= eval("document.formPHViewFillList.disp_batch_dtl_"+recd_no);
	var ip_fill_chk		= eval("document.formPHViewFillList.ip_fill_chk_"+recd_no);
	var disp_qty_uom_id = eval("document.getElementById('disp_qty_uom_id_')"+recd_no);
    var disp_uom_id  	= eval("document.formPHViewFillList.disp_uom_id_"+recd_no);
	disp_drg_name.innerText		= decodeURIComponent(disp_drug_desc,"UTF-8");//decoded for [IN:044657]
	disp_qty_id.innerText		= "     "+disp_qty;
	disp_qty_uom_id.innerText	= "     "+disp_qty_uom_desc;	
	disp_drg_name.style.color	= '#CC6600';
	disp_qty_id.style.cursor	= 'hand';
	disp_qty_id.style.color		= 'blue';
	disp_batch_dtl.value		= disp_btch;
	disp_drug_code.value        = disp_drg_code;
	disp_uom_id.value			= disp_qty_uom;

	if(alt_drug_remarks_ind=="M" || alt_drug_remarks_ind=="O")
		eval('document.getElementById("alt_drug_remarks")'+recd_no).style.display="inline";
	if(alt_drug_remarks_ind=='M')
		eval('document.getElementById("alt_remarks_image_")'+recd_no).style.display="inline";
    if(parseInt(disp_qty)>0){
		if(parseInt(eval("document.formPHViewFillList.order_line_num_"+recd_no).value)==1){
		   ip_fill_chk.disabled = false;
		}
		ip_fill_chk.checked = true;
		ip_fill_chk.value = "Y";
	}
}
						  
async function showBatchDetails(rec_no,order_id,disp_qty_uom){
	
	var disp_drg_name	= eval(document.getElementById('disp_drug_id_'+rec_no));
	var drug_code		= eval("document.formPHViewFillList.drug_code_"+rec_no);
	var store_code		= document.formPHViewFillList.store_code.value;
	var end_date_time   = eval("document.formPHViewFillList.end_date_time_"+rec_no);
	var disp_batch_dtl	= eval("document.formPHViewFillList.disp_batch_dtl_"+rec_no);

	var bean_id		= document.formPHViewFillList.bean_id.value;
	var bean_name	= document.formPHViewFillList.bean_name.value;
		//alert("drug_code--->"+drug_code.value);
		//alert("store_code--->"+store_code);

   if(disp_drg_name.innerText != ''){
		var batch_dtls = eval("document.formPHViewFillList.disp_batch_dtl_"+rec_no).value;
		
		var dialogHeight ='600px' ;
		var dialogWidth = '900px' ;
		var dialogTop	= '219';
		var dialogLeft = '81' ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var arguments = "";
		var retVals =await window.showModalDialog("../../ePH/jsp/PHViewFillListBtchDtlsAll.jsp?batch_dtls="+batch_dtls+"&drug_code="+drug_code.value+"&store_code="+store_code+"&end_date_time="+end_date_time+"&disp_qty_uom="+encodeURIComponent(eval(document.getElementById('disp_qty_uom_id_'+rec_no)).innerText,"UTF-8"),arguments,features); //Added encode URIcomponent for disp_qty_uom for the incident num:24926 on12/Nov/2010===By Sandhya
		//alert("retVals---577-->"+retVals)
				
		if(retVals!=undefined && retVals!='') {
			disp_batch_dtl.value = retVals;
			
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=assignBtchDtls&bean_id=" + bean_id + "&bean_name=" + bean_name +"&order_id=" + order_id +"&batch_dtls="+retVals, false ) ;
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
	if(retval!=undefined && retval!='') {
		
		var record			= retVal.split("`");	
		var exp_date		= record[6];
		var batch_id		= record[0];
		var trade_name		= record[10];
		var bin_location	= record[7];
		var btch_qty		= record[15]; 

		if(parseInt(record[15])>=parseInt(batch_qty)||parseInt(batch_qty)==''){
			var batch_dtls		= exp_date+"^"+batch_id+"^"+trade_name+"^"+bin_location+"^"+batch_qty;
			document.getElementById("exp_date").innerText		= exp_date;
			document.getElementById("btch_id").innerText		= batch_id;
			//document.getElementById("trade_name").innerText	= decodeURIComponent(trade_name);
			document.getElementById("trade_name").innerText	= trade_name;
			document.getElementById("dflt_bin").innerText		= bin_location;
			//if(parseInt(batch_qty)=='0')
			//document.getElementById("btch_qty").innerText		= record[15];
			//else
			document.getElementById("btch_qty").innerText		= batch_qty;
			window.returnValue = batch_dtls;
		}
		else{
			alert(getMessage('PH_SELECT_BATCH_WITH_MORE_QTY','PH')+batch_qty);
		}
	}
}

async function callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect){
	var dialogHeight	= "500px" ;
	var dialogWidth		= "800px";
	var dialogTop		= "100" ;
	var dialogLeft		= "200" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal=await top.window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect,arguments,features);
	return retVal;
}

function winClose(order_id, order_line_num, alt_drug_remarks_ind){
	var altRemEntered = 'Y';// Added For Bru-HIMS-CRF-082 [IN:029948]-start
	var fillListAltDrug = document.formPHViewFillList.fillListAltDrug.value;
	if(fillListAltDrug!="" && alt_drug_remarks_ind=='M'){
		altRemEntered = openAltDrugRemarks(order_id, order_line_num, alt_drug_remarks_ind );
	}
	if(altRemEntered!='Y')
		return false;
	//window.returnValue = fillListAltDrug; // Added For Bru-HIMS-CRF-082 [IN:029948]-End
	let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = fillListAltDrug;

	if(window.returnValue != undefined){
		//window.close();
		const dialogTag =parent.document.getElementById("dialog_tag");
		dialogTag.close();
		
	}
	else{
		//window.returnValue = '';
		let dialogBody = parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = "";
		const dialogTag = parent.document.getElementById("dialog_tag");
		dialogTag.close();
		//window.close();
	}
}

async function genFillList(){
    var flag1=true;
    var selectArray  = new Array() ;
    var patientArray  = new Array() ;  
	var rec_count=parent.fill_list.document.formPHViewFillList.total_drugs.value;
	//added for SRR20056-CRF-0612 - start
	var unalloc_record_cnt=parent.fill_list.document.formPHViewFillList.unalloc_record_cnt.value;
	var UnAllocRepprintOption =document.formViewFillListButtons.UnAllocRepprintOption.value;
	var store_code = parent.fill_list.document.formPHViewFillList.store_code.value
	var retVal = 'N';	
	var tmp_selectedReports  = new Array() ;//code added for SKR-SCF-0765[IN037730]		
	var normal_rx = false, iv_rx = false, iv_intermittent = false;
	var iv_prep_yn='';
	for(i=0;i<rec_count;i++){  
		if(eval("parent.fill_list.document.formPHViewFillList.ip_fill_chk_"+i).value){
		    selectArray[i]=eval("parent.fill_list.document.formPHViewFillList.ip_fill_chk_"+i).value;
		    patientArray[i]=eval("parent.fill_list.document.formPHViewFillList.patient_id"+i).value;
			//var stock_yn = eval("parent.fill_list.document.formPHViewFillList.stock_yn"+i).value;
			if(selectArray[i]=="Y")
				flag1=false;
			iv_prep_yn = eval("parent.fill_list.document.formPHViewFillList.iv_prep_yn_"+i).value;
			if(selectArray[i] == "Y" ) {/*code added for SKR-SCF-0765[IN037730] -- Start */
			    if(normal_rx == true && iv_intermittent == true && iv_rx == true)					
					break;
						
				if( iv_prep_yn=="" ){					
					tmp_selectedReports[i] = "PHPRDISLBFILL";
					normal_rx = true;  
				}	
				else if(iv_prep_yn == 1 || iv_prep_yn == 5)	{			
					tmp_selectedReports[i] = "PHRIVCONTFILL"; 
					iv_rx = true; 
				}	
				else if(iv_prep_yn == 3){				
					tmp_selectedReports[i] = "PHRIVINTTFILL";
					iv_intermittent = true; 
				}	
 			} /* code added for SKR-SCF-0765[IN037730] -- End */        			
		}
	}
	//RUT-CRF-0035 [IN029926] Added for PIN Validation  - begin
	if(parent.fill_list.document.formPHViewFillList.userAuthPINYN.value=='Y'){
		var dialogHeight	= "30vh";
		var dialogWidth		= "35vw";
		var dialogTop		=  window.screen.availWidth - 1100;
		var dialogLeft		=  window.screen.availWidth - 1000;
		var center			= "0";
		var status			= "no";	
		var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		//var retVal=true;
		var retVal=await window.showModalDialog("../../ePH/jsp/UserPINAuthorization.jsp?call_from=IPFA&disp_locn_code="+store_code,"",features);
		if(retVal==undefined || retVal=='C')
			return;
		else{
			retVal=trimString(retVal);
			if(retVal!="0"){
				storeUserinBean(retVal);
			}
		}
	}
	//RUT-CRF-0035 [IN029926] Added for PIN Validation  - end
	if(UnAllocRepprintOption=='PD' || UnAllocRepprintOption=='PT'){
		var dialogHeight	= "40vh" ;
		var dialogWidth		= "35vw";
		var dialogTop		= "350" ;
		var dialogLeft		= "200" ;
		var center			= "1" ;
		var status			="no";
		var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
		retVal=await window.showModalDialog("../../ePH/jsp/UnallocatedDrugMedicalSupplyPrintAlert.jsp",arguments,features);
	}
	if(retVal!=undefined && retVal == 'Y'){
		if(parseInt(unalloc_record_cnt)>0)
			callUnallocatedReport("GENFILLLIST");
		else if(UnAllocRepprintOption =='PD')
			alert(getMessage('PH_IP_FILL_ALL_PRINT_UNALLOC_NO_REC','PH'));
	}
	//added for SRR20056-CRF-0612 - end
	if(flag1==true){
	    alert(getMessage('PH_ATLEAST_ONE_SELECTED','PH'));
	}
	else if(flag1==false){
		document.formViewFillListButtons.GenerateFillList.disabled=true;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var bean_id   = parent.fill_list.document.formPHViewFillList.bean_id.value
	    var bean_name = parent.fill_list.document.formPHViewFillList.bean_name.value

		xmlStr ="<root><SEARCH " ;
		xmlStr += "sel_array=\""+ selectArray +"\" " ;
		xmlStr += "patient_Array=\""+ patientArray +"\" " ;
		xmlStr += "store_code=\""+ store_code +"\" " ;
		xmlStr += "tmp_selectedReports=\""+ tmp_selectedReports +"\" " ;//code added for SKR-SCF-0765[IN037730]		
		xmlStr +=" /></root>" ;		
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=GENERATEFILLLIST&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
		//if(message=='PH_DOC_TYPE_SETTINGS_NOT_AVAIL')
		//message=getMessage('PH_DOC_TYPE_SETTINGS_NOT_AVAIL','PH')
		//if(!result)
		
		window.returnValue = flag+'<BR>'+message;
		//else
		//window.returnValue = flag;
	//	window.close();
	
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
	}
//	+ message+" <B>Fill Process id is :"+flag+"</B>"

//	onSuccess();

}

function ClearNursingUnit(){
   	document.formPHGenerateFillList.Nursing_Unit_From.value="";
   	document.formPHGenerateFillList.Nursing_Unit_From_Code.value="";
    document.formPHGenerateFillList.Nursing_Unit_To.value="";
    document.formPHGenerateFillList.Nursing_Unit_To_Code.value="";
}

function callUnallocatedReport(calledFrom){
	if(calledFrom=='PRINTREPORT'){
		if(!(parseInt(parent.fill_list.document.formPHViewFillList.unalloc_record_cnt.value)>0)){
			alert(getMessage('PH_IP_FILL_ALL_PRINT_UNALLOC_NO_REC','PH'));
			return false;
		}
	}
	//if(parseInt(parent.fill_list.document.formPHViewFillList.unalloc_record_cnt.value)>0){ //commented for SRR20056-CRF-0612
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var bean_id   = parent.fill_list.document.formPHViewFillList.bean_id.value
	var bean_name = parent.fill_list.document.formPHViewFillList.bean_name.value	   
	xmlStr ="<root><SEARCH " ;
	xmlStr += "disp_locn_code=\""+ parent.fill_list.document.formPHViewFillList.store_code.value +"\" " ;
	xmlStr += "Proc_Type=\""+ parent.fill_list.document.formPHViewFillList.Proc_Type.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=CALL_UNALLOC_REPORT&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	/*} //commented for SRR20056-CRF-0612  - start
	else{
		alert(getMessage("NO_RECORDS_PRINT","PH"));
	}*/ //commented for SRR20056-CRF-0612 - end
}
/* added for SRR20056-CRF-0663 --START*/
function DispDfltDisplay(sProcessType,sIncPRNDrugs){

	if(sIncPRNDrugs == 'I'){
		document.formPHGenerateFillList.PrnDrugs.checked = true
	}
	var leng = document.formPHGenerateFillList.Proc_Type.length;
	for(index=0; index< leng; index++ ){
		if(document.formPHGenerateFillList.Proc_Type.options[index].value==sProcessType){
			document.formPHGenerateFillList.Proc_Type.selectedIndex= index	;
			document.formPHGenerateFillList.Proc_Type.onchange();
			break;
		}
	}
}
/* added for SRR20056-CRF-0663 --END*/

function closeWindow(printYN){
//	window.returnValue = printYN;
//	window.close();
	
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue =  printYN;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
//}
}

// RUT-CRF-0035 [IN029926] PIN Authentication  --begin
function storeUserinBean(auth_user_id){
	var bean_id		= parent.fill_list.document.formPHViewFillList.bean_id.value ;
	var bean_name	= parent.fill_list.document.formPHViewFillList.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
	xmlStr += "auth_user_id=\""+ auth_user_id +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=storeAuthUserInBean&bean_id=" + bean_id + "&bean_name=" + bean_name, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}
// RUT-CRF-0035 [IN029926] PIN Authentication  -- end
/*
var INT = "Integer";
var LONG = "Long";
var FLOAT = "Float";
var DOUBLE = "Double";
var STRING = "String";
var DATE = "Date";

function isValidFromToField(fromObj, toObj, dataType, stLegend, messageFrame, errorPage) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue.toUpperCase() > stToValue.toUpperCase()) {
			bReturn = false;
		}
	}
	if ((!bReturn) && (messageFrame != null)) {
		if (errorPage == null) {
			errorPage = "../../eCommon/jsp/error.jsp";
		}
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		messageFrame.location.href = errorPage + "?err_num=" + stMessage;
		//toObj.focus();
	}
	return bReturn;
} */
/*
function confirm1(oLink)
{
var el = oLink.parentNode;
var text;
var href = oLink.href;
var original_text = el.innerHTML;
text = 'Confirm? ';
text += '<a href="' + href + '">Yes</a>';
text += ' / ';
text += '<a href="#" onclick="this.innerHTML=\'".escape(original_text)."\';return false;">No</a>'

}

function confirm(i){
    var options = '<br/><br/><input class="button1" value="Yes" type="button" onclick="return true"> <input class="button1" value="No" type="button" onclick="return false">';
    $('#text').html(i+options);
    $('#confirmDiv').fadeIn('fast');
}*/
async function openAltDrugRemarks(order_id, order_line_num, alt_drug_remarks_ind, callFrom ){
	var dialogHeight= "40vh" ;
	var dialogWidth	= "35vw" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retRem = await window.showModalDialog("../../ePH/jsp/DispMedicationRemarks.jsp?alt_drug_remarks_ind="+alt_drug_remarks_ind+"&order_id="+order_id+"&order_line_num="+order_line_num+"&called_from=IPFILL&callFrom="+callFrom,arguments,features);
	if(callFrom!='LINK'){
		if(retRem!="Y" && alt_drug_remarks_ind=='M' )
			return callFrom;
		else
			return retRem;
	}
	//	openAltDrugRemarks(order_id, order_line_num, alt_drug_remarks_ind );
}

function saveRemarks(){
	var forObj = document.DispMedicationRemarks;
	var alt_drug_remarks_ind = forObj.alt_drug_remarks_ind.value;
	if(forObj.alt_drug_remarks.value=="" && alt_drug_remarks_ind=='M'){
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
	    msg = msg.replace('$', getLabel("ePH.AltDrugRemarks.label","PH"));
		alert(msg);
		return false;
	}
	var bean_id = "IpFillAllBean" ;
	var bean_name = "ePH.IpFillAllBean";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var order_id = forObj.order_id.value;
	var order_line_num = forObj.order_line_num.value;
	var alt_drug_remarks =encodeURIComponent(forObj.alt_drug_remarks.value,"UTF-8") ;
	var xmlStr ="<root><SEARCH " ;
	xmlStr+= "order_id =\"" + order_id + "\" " ;
	xmlStr+= "order_line_num =\"" + order_line_num + "\" " ;
	xmlStr+= "alt_drug_remarks =\"" + alt_drug_remarks + "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocationAll.jsp?function=storeAltDrugRemarks&bean_id=" + bean_id + "&bean_name=" + bean_name, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;

	forObj.alt_drug_remarks_yn.value = "Y";
//	window.returnValue="Y";
//	window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "Y";
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

function checkRemarksMaxLimit(obj,maxLeng, label) {  //function checkRemarksMaxLimit added for [IN:039007]
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label","Common"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}

