function apply() {
	
	var row_count_up = parent.frames[2].frames[3].document.forms[0].row_count_up.value;
	var Status_flag = parent.frames[2].frames[3].document.forms[0].Status_flag.value;
	var row_count = parent.frames[2].frames[3].document.forms[0].row_count1.value;
	var cnt       =parent.frames[2].frames[3].document.forms[0].cnt.value;
	var   flagadd  =parent.frames[2].frames[1].document.forms[0].flagadd.value
	if(flagadd==undefined || flagadd==null) flagadd="";

	if ((parent.frames[2].frames[4].document.forms[0] == null) ||  (row_count_up==row_count && flagadd ==""))
	{
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=" + getMessage("NO_CHANGE_TO_SAVE","common");
		return;
	}else
	{ 
		var defciency = parent.frames[2].frames[3].document.forms[0].defi_code.value
		if (defciency !="" ) {
				var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action='../../servlet/eFM.FMFileDeficiencyMonitoringServlet'> </form></body></html>";
				parent.frames[2].frames[5].document.write(HTMLVal);
				parent.frames[2].frames[5].document.forms[0].submit();
		}else {
			var	mesg = getMessage("FILE_NO_DEF_MON","FM");
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+mesg+"&err_value=0";
			return false;	
		}
	}
}


function onSuccess() {

	var mntr_fldfcy_inc_fslocn_ntdf_yn = parent.frames[2].frames[1].document.forms[0].mntr_fldfcy_inc_fslocn_ntdf_yn.value;
	var userSecurity = parent.frames[2].frames[1].document.forms[0].userSecurity.value;
	var access_all = parent.frames[2].frames[1].document.forms[0].access_all.value;
	//parent.frames[2].frames[1].location.href = "../../eFM/jsp/FMFileDeficiencyMonitoringHeader.jsp?mntr_fldfcy_inc_fslocn_ntdf_yn="+mntr_fldfcy_inc_fslocn_ntdf_yn;
	
	//The above code has been commented for SKR-SCF-0087 [IN:028773] by Suresh M on 14.09.2011
	parent.frames[2].frames[1].location.href = "../../eFM/jsp/FMFileDeficiencyMonitoringHeader.jsp?mntr_fldfcy_inc_fslocn_ntdf_yn="+mntr_fldfcy_inc_fslocn_ntdf_yn+"&userSecurity="+userSecurity+"&access_all="+access_all;
	parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[3].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[4].location.href = "../../eCommon/html/blank.html";
}
function reset() {
	parent.frames[2].frames[1].location.reload();
	parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[3].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[4].location.href = "../../eCommon/html/blank.html";
}
/*function CheckDateReported(from,today,discdate)  { 
	//args objects 1st is this object & second is the date in dd/mm/yyyy hh:mi
	if(from.value != '') {
	 if (CheckDateTime(from) == true)
	 if(today != "" && from.value !="" ) {
		var dischargearray;
		var fromdate =from.value ;
		var todate =today ;
		var dischargedate = discdate;
	
		if(fromdate.length > 0 && todate.length > 0 ) {
		var a=  fromdate.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =a[0].split("/")
		var splittime1= a[1].split(":")

		 var fromdt  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		a=  todate.split(" ")
		splitdate=a[0];
		splittime=a[1]

	    splitdate1 =a[0].split("/")
		splittime1= a[1].split(":")

	    var todt  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
		if(Date.parse(todt) < Date.parse(fromdt)) {
			var msg =getMessage('DATE_REP_CURR_DATE','FM');
			parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			from.select();
			return false;
		}
	}
	if(fromdate.length > 0 && dischargedate.length > 0 ) {
		var a=  fromdate.split(" ")
		splitdate=a[0];
	    splittime=a[1]	
	    var splitdate1 =a[0].split("/")
		var splittime1= a[1].split(":")
	     var fromdt1  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	     a=  dischargedate.split(" ")
		splitdate=a[0];
	    splittime=a[1]
	    splitdate1 =a[0].split("/")
		splittime1= a[1].split(":")

	    var todt1  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
		if(Date.parse(todt1) > Date.parse(fromdt1)) 
		{
			var msg =getMessage('DATE_REP_DISC_DATE','FM');
			parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			from.select();
			return false;
		} else if(Date.parse(todt1) <= Date.parse(fromdt1)) {
				parent.frames[4].document.forms[0].defi_reported_date.value = fromdate;
				parent.frames[5].location.href='../../eCommon/jsp/error.jsp?' ;
				AddRecs();
				return true;
			}
		}
	 }
  } else {
//		var msg ="APP-000001 Date Reported cannot be blank..."
		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace('$',getLabel("eFM.DateReported.label","FM"));
		parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		from.select();
		return false;
	 }
}*/
function CheckDateResolved(from,today) { 
	//args objects 1st is this object & second is the date in dd/mm/yyyy hh:mi
	if (CheckDateTime(from) == true)
	if(today != "" && from.value !="" ) {
		var fromarray;
		var toarray;
		var reportedarray;
		var fromdate =from.value ;
		var todate =today ;
		var reporteddate = parent.frames[4].document.forms[0].defi_reported_date.value;

		if(fromdate.length > 0 && todate.length > 0 ) {
		var a=  fromdate.split(" ")
		splitdate=a[0];
	    splittime=a[1]
	    var splitdate1 =a[0].split("/")
		var splittime1= a[1].split(":")
	     var fromdt  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	     a=  todate.split(" ")
		splitdate=a[0];
	    splittime=a[1]

		 splitdate1 =a[0].split("/")
	     splittime1= a[1].split(":")

		 var todt  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
		if(Date.parse(todt) < Date.parse(fromdt)) {
				var msg =getMessage('DATE_RES_CURR_DATE','FM');
				parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				from.select();
				return false;
		}
	}
	if(fromdate.length > 0 && reporteddate.length > 0 ) 
	{
		var a=  fromdate.split(" ")
	    splitdate=a[0];
		splittime=a[1]

	    var splitdate1 =a[0].split("/")
		var splittime1= a[1].split(":")

	     var fromdt1  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		a=  reporteddate.split(" ")
	    splitdate=a[0];
		splittime=a[1]
	    splitdate1 =a[0].split("/")
		splittime1= a[1].split(":")

	    var todt1  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		if(Date.parse(todt1) > Date.parse(fromdt1)) 
		{
			var msg =getMessage('DATE_RES_REP_DATE','FM');
			parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			//from.select();
			from.value="";
			return false;
		} else if(Date.parse(todt1) <= Date.parse(fromdt1)) {
				parent.frames[5].location.href='../../eCommon/jsp/error.jsp?' ;
				return true;
			}
		}
	 } else {
//		var msg ="APP-000001 Date Resolved cannot be blank..."
		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace('$',getLabel("eFM.DateReported.label","FM"));
		parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		
		//from.select();
		from.value="";
		return false;
	 }
}
////////*********** JS Files of FMFIleDeficiencyMonitoringDetails.jsp ******************//////
function OnDefMonitorDtlsSelection(rownum,record_from,compStat,fac_id,encounter_id,file_no,file_type, volume_no,patient_class,defi_code,defi_desc,admission_date,discharge_date,care_locn_code,defi_completed_status,practitioner,practitioner_name,defi_reported_date,defi_status,defi_resolved_date,defi_remarks,Found,PatientId) {

	var Modify;
	if(record_from == "SCREEN") Modify = "ScreenModify";
	else Modify = "DatabaseModify";

			var count=0;
			if(eval("parent.frames[3].document.forms[0].select"+rownum+""))
			{
			if(eval("parent.frames[3].document.forms[0].select"+rownum+".checked"))
			{
				 count=1;
			}
			}

	parent.frames[4].location.href = "../../eFM/jsp/FMFileDeficiencyMonitoringAdd.jsp?Rec_num="+rownum+"&compStat="+escape(compStat)+"&DisplyAdd=Y&Oper_mode="+escape(Modify)+"&fac_id="+escape(fac_id)+"&EncounterId="+escape(encounter_id)+"&FileNo="+escape(file_no)+"&file_type="+file_type+"&volume_no="+volume_no+"&patient_class="+patient_class+"&defi_code="+escape(defi_code)+"&defi_desc="+escape(defi_desc)+"&Admndate="+escape(admission_date)+"&Discdate="+escape(discharge_date)+"&Carelocn="+escape(care_locn_code)+"&defi_completed_status="+escape(defi_completed_status)+"&practitioner="+escape(practitioner)+"&practitioner_name="+escape(practitioner_name)+"&defi_reported_date="+escape(defi_reported_date)+"&defi_status="+escape(defi_status)+"&defi_resolved_date="+defi_resolved_date+"&defi_remarks="+encodeURIComponent(defi_remarks)+"&Found="+escape(Found)+"&PatientId="+escape(PatientId)+"&chkcount="+escape(count);

}
function Remove(Indval) {
	var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMFileDeficiencyMonitoringRemoveRec.jsp?Indval="+Indval+" \"> </form></body></html>";
	
	parent.frames[5].document.write(HTMLVal);
	parent.frames[5].document.forms[0].submit();
}
////////*********** End of JS Files of FMFIleDeficiencyMonitoringDetails.jsp ******************//////
			////////////////////////////////////////////////////////////////////
////////*********** End of JS Files of FMFIleDeficiencyMonitoringAdd.jsp ******************//////

async function searchCode(target,facilityid,locle)
{
			var retVal = 	new String();
			var dialogHeight= "28vh" ;
			var dialogWidth	= "43vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";			
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			
			tit=getLabel("Common.practitioner.label","common");
		//	sql="select PRACTITIONER_ID code, PRACTITIONER_NAME description from am_pract_for_facility_vw where operating_facility_id ='"+facilityid+"' and eff_status ='E' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?)";
		sql="SELECT a.practitioner_id code, a.practitioner_name description  FROM am_practitioner_lang_vw a, am_pract_for_facility b  WHERE b.facility_id = '"+facilityid+"'   AND b.eff_status = 'E' AND a.language_id ='"+locle+"'  AND a.practitioner_id = b.practitioner_id  AND UPPER(a.practitioner_id) LIKE UPPER(?) AND UPPER(a.practitioner_name) LIKE UPPER(?)"
			
			
			search_code="PRACTITIONER_ID";
			search_desc= "PRACTITIONER_NAME";
			
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] =DESC_LINK  ;
			argumentArray[7] =DESC_CODE ;

			retVal = await CommonLookup( tit, argumentArray );

			var arr=new Array();
			
			if(retVal != null && retVal != "" ) 
			{
				var retVal=unescape(retVal);
				arr=retVal.split(",");
				target.value=arr[1];
			   document.forms[0].physician.value=arr[0];
				}
		
			/*if (!(retVal == null))
			{
				target.value=retVal;
			}*/
			else
	{
			target.value="";
  			 document.forms[0].physician.value="";
			target.focus();
    }
}



async function searchCode2(target,facilityid) {
	var retVal = 	new String();
	var dialogHeight= "28vh" ;
	var dialogWidth	= "43vw" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";
	
	tit=getLabel("Common.practitioner.label","common");
	sql = "select practitioner_id, practitioner_name from am_pract_for_facility_vw where operating_facility_id = `"+facilityid+"` and eff_status = `E` ";

	search_code="practitioner_id";
	search_desc= "practitioner_name";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
	retVal = 	await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

	var arr=new Array();

	if (!(retVal == null)) {
		var retVal=unescape(retVal);
		arr=retVal.split("::");

		document.forms[0].physician1.value=arr[0];
		document.forms[0].physician.value=arr[1];
	}
}
function RadioOptions(objvalue) {
	
	var flagclick=""; 
	var sys_date = document.forms[0].sys_date.value;
	parent.frames[4].document.forms[0].defi_status.value = objvalue;
	if(objvalue == "O") {
		parent.frames[4].document.forms[0].date_resolved.value			= "";
		parent.frames[4].document.forms[0].date_resolved.disabled		= true;
		parent.frames[4].document.forms[0].res_date.style.visibility	= "hidden";
	} else if(objvalue == "X") {
		flagclick="X" ;
		parent.frames[4].document.forms[0].date_resolved.disabled		= false;
		sys_date=convertDate(sys_date,"DMYHM","en",localeName);
		parent.frames[4].document.forms[0].date_resolved.value			= sys_date;
		parent.frames[4].document.forms[0].res_date.style.visibility	= "visible";
		parent.frames[4].document.forms[0].date_resolved.disabled		= true;
	
	} else if(objvalue == "C"){
		flagclick="C" ;
		parent.frames[4].document.forms[0].date_resolved.disabled		= false;
		sys_date=convertDate(sys_date,"DMYHM","en",localeName);
		parent.frames[4].document.forms[0].date_resolved.value			= sys_date;
		parent.frames[4].document.forms[0].res_date.style.visibility	= "visible";
		parent.frames[4].document.forms[0].date_resolved.disabled		= true;
	}
 parent.frames[3].document.forms[0].flagclick.value=flagclick;
	
}
function ClearRecs() {
	var dflt_practitioner		= document.forms[0].dflt_practitioner.value;
	var dflt_practitioner_name	= document.forms[0].dflt_practitioner_name.value;
	
	parent.frames[4].document.forms[0].deficiency.disabled = false;
	parent.frames[4].document.forms[0].physician.disabled = false;
	parent.frames[4].document.forms[0].searchcode.disabled=false;
	parent.frames[4].document.forms[0].date_reported.disabled = false;
	parent.frames[4].document.forms[0].defy_status(0).disabled = false;
	parent.frames[4].document.forms[0].defy_status(1).disabled = true;
	parent.frames[4].document.forms[0].defy_status(2).disabled = true;
	parent.frames[4].document.forms[0].remarks.disabled = false;
	parent.frames[4].document.forms[0].add.disabled = false;

	parent.frames[4].document.forms[0].deficiency.value = "";
	parent.frames[4].document.forms[0].physician.value = dflt_practitioner;
	parent.frames[4].document.forms[0].physician1.value = dflt_practitioner_name;
	parent.frames[4].document.forms[0].date_reported.value = "";
	parent.frames[4].document.forms[0].date_resolved.value = "";
	parent.frames[4].document.forms[0].remarks.value = "";
	parent.frames[4].document.forms[0].defy_status(0).checked = true;
	parent.frames[4].document.forms[0].date_resolved.disabled = true;
	parent.frames[4].document.forms[0].operation_mode.value = "Add";
	parent.frames[4].document.forms[0].prefdt.disabled = false;
}
////////*********** End of JS Files of FMFIleDeficiencyMonitoringAdd.jsp ******************//////
			/////////////////////////////////////////////////////////////////
////////*********** End of JS Files of FMFIleDeficiencyMonitoringHeader.jsp ******************//////
async function callSearchScreen1(val){


	if(val=='E') {
		var retVal =    new String();
		var dialogHeight = "80vh" ;
		var dialogWidth  = "70vw" ;
		var dialogTop    = "190";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
		var arguments   = "" ;
		var file_type_appl_yn = document.FileDeficiencyMonitoring_header.file_type_appl_yn.value;
		var file_no = "";
		var file_type = ""; 
		if (file_type_appl_yn == "N")
			file_no = document.FileDeficiencyMonitoring_header.file_no.value
		else if (file_type_appl_yn == "Y")
			file_type = document.FileDeficiencyMonitoring_header.patient_file_type.value
		var volume_no = document.FileDeficiencyMonitoring_header.volume_no.value
		var patient_id = document.FileDeficiencyMonitoring_header.patient_id.value
		
		retVal = await top.window.showModalDialog("../../eFM/jsp/IPEncounterDisplayFrame.jsp?file_no="+file_no+"&file_type="+file_type+"&patient_id="+patient_id+"&volume_no="+volume_no+"&file_type_appl_yn="+file_type_appl_yn,arguments,features);

		
		if(retVal != null) {
			 retVal = retVal.split("|");
			document.FileDeficiencyMonitoring_header.encounter_id.value = retVal[0];
			document.FileDeficiencyMonitoring_header.encounter_id.focus();

			
		}
	}
}
async function ShowEncCriteria() {
	var retVal =    new String();
	var dialogTop   = "65";
	var dialogHeight    = "33.4vh" ;
	var dialogWidth = "50vw" ;
	var features    ="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;		
	retVal = await window.showModalDialog("../../eIP/jsp/InpatientLookupCriteria.jsp?jsp_name=PaintEmergencyTransfer.jsp&win_height=33.4&win_width=49.6&call_function=TransferPatient&wherecondn=EMERGENCY_TFR_YN",arguments,features);
}
function validSplchars1(obj) {	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]=getLabel("Common.encounterid.label","common");
	if(SpecialCharCheck( fields, names,'',"A",'')) {
		return true;
	} else {
		//obj.select();
		//obj.focus();
		obj.value="";
		return false;
	}
}
function searchData() { 
	var fields = new Array();
	var names = new Array();
	var file_type_appl_yn = FileDeficiencyMonitoring_header.file_type_appl_yn.value;

	//fields[fields.length] = FileDeficiencyMonitoring_header.cuurfslocn;
	//names[names.length] = getLabel("eFM.CurrentFSLocation.label","FM");
	fields[fields.length] = FileDeficiencyMonitoring_header.patient_id;
	names[names.length] = getLabel("Common.patientId.label","common");
	if (file_type_appl_yn == "N") {
		fields[fields.length] = FileDeficiencyMonitoring_header.file_no;
		names[names.length] = getLabel("Common.fileno.label","common");
	} else if (file_type_appl_yn == "Y") {
		fields[fields.length] = FileDeficiencyMonitoring_header.patient_file_type;
		names[names.length] = getLabel("Common.filetype.label","common");
	}
	fields[fields.length] = FileDeficiencyMonitoring_header.encounter_id;
	names[names.length] = getLabel("Common.encounterid.label","common");
	fields[fields.length] = FileDeficiencyMonitoring_header.volume_no;
	names[names.length] = getLabel("eFM.VolumeNo.label","FM");

	FileDeficiencyMonitoring_header.search.disabled=true;

	var file_no			= "";
	var file_type_code	= "";

	if (file_type_appl_yn == "N")
		file_no = FileDeficiencyMonitoring_header.file_no.value;
	else if (file_type_appl_yn == "Y")
		file_type_code = FileDeficiencyMonitoring_header.patient_file_type.value;
	
	var volume_no = FileDeficiencyMonitoring_header.volume_no.value;
	var curr_fs_locn_code ="";
	 if(FileDeficiencyMonitoring_header.cuurfslocn)
		curr_fs_locn_code= FileDeficiencyMonitoring_header.cuurfslocn.value;
	
	
	if(parent.frames[1].checkFields( fields, names, parent.messageFrame)) {
		parent.frames[2].location.href = "../../eFM/jsp/FMFileDeficiencyMonitoringResult.jsp?FSLocation="+FileDeficiencyMonitoring_header.cuurfslocn.value+"&PatientID="+FileDeficiencyMonitoring_header.patient_id.value+"&FileNo="+FileDeficiencyMonitoring_header.file_no.value+"&EncounterID="+FileDeficiencyMonitoring_header.encounter_id.value+"&file_type_code="+file_type_code+"&volume_no="+FileDeficiencyMonitoring_header.volume_no.value+"&file_type_appl_yn="+file_type_appl_yn+"&curr_fs_locn_code="+curr_fs_locn_code;

		FileDeficiencyMonitoring_header.search.disabled			=	true;
		FileDeficiencyMonitoring_header.patient_id.disabled		=	true;
		if (FileDeficiencyMonitoring_header.file_type_appl_yn.value == "N")
			FileDeficiencyMonitoring_header.file_no.disabled		=	true;
		else if (FileDeficiencyMonitoring_header.file_type_appl_yn.value == "Y")
			FileDeficiencyMonitoring_header.file_type_code.disabled	=	true;
		FileDeficiencyMonitoring_header.volume_no.disabled		=	true;
		FileDeficiencyMonitoring_header.encounter_id.disabled	=	true;
		FileDeficiencyMonitoring_header.pat_search.disabled		=	true;
		FileDeficiencyMonitoring_header.encounter_id_search.disabled =	true;
		parent.frames[5].location.href = '../../eCommon/jsp/error.jsp'
	} else {
		FileDeficiencyMonitoring_header.search.disabled=false;
		parent.frames[2].location.href = '../../eCommon/html/blank.html'
		parent.frames[3].location.href = '../../eCommon/html/blank.html'
		parent.frames[4].location.href = '../../eCommon/html/blank.html'
	}
}
////////*********** End of JS Files of FMFIleDeficiencyMonitoringHeader.jsp ******************//////

function CheckDateReported(from,today,discdate)  { 
	//args objects 1st is this object & second is the date in dd/mm/yyyy hh:mi
	parent.frames[4].document.forms[0].prefdt.disabled =false;

	parent.frames[1].document.forms[0].flagadd.value= parent.frames[3].document.forms[0].flagclick.value;
	parent.frames[3].document.forms[0].flagclick.value="";
	if(from.value != '') {
	// if (CheckDateTime(from) == true)
	 if (validDateObj(from,'DMYHM',localeName) == true)
	 if(today != "" && from.value !="" ) {
		var dischargearray;
		var fromdate =from.value ;
		var todate =today ;
		var dischargedate = discdate;
	
		/*if(isAfterNow(fromdate,"DMYHM", localeName))
		{
		  alert(getMessage("DATE_REP_CURR_DATE",'FM'));
		}*/
		if(isAfterNow(fromdate,"DMYHM", localeName)) {
			var msg =getMessage('DATE_REP_CURR_DATE','FM');
			parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			//from.select();
			from.value="";
			return false;
		}
	
		//if(Date.parse(todt1) > Date.parse(fromdt1)) 
		
		if(isBefore(fromdate,dischargedate,"DMYHM",localeName)) 
		{
			var msg =getMessage('DATE_REP_DISC_DATE','FM');
			parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			//from.select();
			from.value="";
			return false;
		} else if(!isAfterNow(fromdate,"DMYHM", localeName)) {
				parent.frames[4].document.forms[0].defi_reported_date.value = fromdate;
				parent.frames[5].location.href='../../eCommon/jsp/error.jsp?' ;
				AddRecs();
				return true;
			}
		
	 }
  } else {
//		var msg ="APP-000001 Date Reported cannot be blank..."
		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace('$',getLabel("eFM.DateReported.label","FM"));
		parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		//from.select();
		from.value="";
		return false;
	 }
}



function encounter_disable()
{

	FileDeficiencyMonitoring_header.encounter_id.disabled	=	true;
	FileDeficiencyMonitoring_header.encounter_id_search.disabled	=	true;
	

}
//parent.frames[1].document.forms[0].name
function checkEncounter(obj){


	var HTMLVal = new String();		
	var enc_id=obj.value;
	var flag="encounter_details";
	if(enc_id=='')
	{
	//	var msg=getMessage("CAN_NOT_BE_BLANK","common");
		//msg=msg.replace('$',getLabel("Common.encounterid.label","common"));		
	//	alert(msg);
			
	}else
	{
		
	var patient_id=parent.deficiency_header.FileDeficiencyMonitoring_header.patient_id.value;
	
		
	HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMTransFileFromPopFSLocn.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='enc_id' id='enc_id' value='"+enc_id+"'><input type='hidden' name='flag' id='flag' value='"+flag+"'></form></BODY></HTML>";

	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();
	
	}
	

}

 function clearvalues(obj)
 {
FileDeficiencyMonitoring_header.patient_id.value="";
FileDeficiencyMonitoring_header.patient_id.onblur();
 }



