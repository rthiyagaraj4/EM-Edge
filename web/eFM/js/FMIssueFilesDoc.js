function AddDocs()
{
	var count = parent.frames[3].document.forms[0].count.value;
	parent.frames[3].document.forms[0].Issue_user_id.value = parent.parent.frames[1].document.forms[0].username.value;
	p_rec_count=0;

	for(i = 1;i <= count;i++)
	{
		if(eval("parent.frames[3].document.forms[0].chk"+i+".disabled") == false)
		{
			bool = eval("parent.frames[3].document.forms[0].chk"+i+".checked");
			if(bool == true)
			{
				eval("parent.frames[3].document.getElementById('chbox" + i + "').className='SELECT';");
				eval("parent.frames[3].document.getElementById('chk" + i + "').disabled=true;");

				p_rec_count++;
			}
		}
	}
	if (p_rec_count>0)
	{
		parent.frames[3].document.IssueOutstandingDetail.submit();
	}
	else
	{
	parent.parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=" + getMessage('NO_DOC_SELECTED_ISSUE','FM');
	}
}

function Cls()
{
	//parent.frames[3].location.reload();
	//parent.frames[2].location.href = '../../eCommon/html/blank.html';
	/*
	parent.frames[2].document.forms[0].reset();
	parent.frames[2].document.getElementById("detaillfields").style.visibility='hidden';
	*/
	document.location.reload();
}

function GetShowRemarks(name,remarksvalue,remarkstype)
{
    var comments;
	var inputArr = document.getElementsByTagName("input");
	for (u=0;u<inputArr.length;u++)
	{
		if (inputArr[u].name == name)
		{
			comments = inputArr[u].value;
		}
	}

	var retVal;
	var dialogHeight ='9' ;
	var dialogWidth = '30' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments;

	   if(comments=='' || comments == "null")
	      comments ='';
	 	arguments = comments ;

	retVal = window.showModalDialog('../../eFM/jsp/GetShowRemarks.jsp?RemarksValue='+escape(remarksvalue)+'&RemarksType='+remarkstype,arguments,features);

	for (u=0;u<inputArr.length;u++){
		if (inputArr[u].name == name){
			inputArr[u].value = ''+retVal+'';
		}
	}
}

function OnSelect(Reqno)
{
	var retVal;
	var dialogHeight ='7' ;
	var dialogWidth = '38' ;
	var dialogLeft = '177' ;
	var dialogTop = '405' ;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +'; dialogTop:' + dialogTop +'; scroll=auto; status=no';
	var arguments;
	retVal = window.showModalDialog('../../eFM/jsp/FMIssueFilesOutstanInvFiles.jsp?Reqno='+Reqno,arguments,features);
}

function setVal(Obj,ind)
{
	if(Obj.checked == true)
	{
		eval("parent.frames[3].document.forms[0].select"+ind+".value='Y'");
		Obj.value = "Y";
	}
	else
	{
		eval("parent.frames[3].document.forms[0].select"+ind+".value='N'");
		Obj.value = "N";
	}
}

function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}
function callPatDetails(Patient_ID) {
	var dialogHeight	= "28" ;
	var dialogWidth		= "50" ;
	var dialogTop		= "84" ;
	var dialogLeft		= "55" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	retVal				= window.showModalDialog( "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Patient_ID), arguments, features );
}
function disasbleToolTipDataChange(classValue) {
    if( classValue == "DATACHANGE")
        document.getElementById("tooltiplayer").style.visibility = "hidden" ;
}
function displayToolTipDataChange(classValue,text) {
    if(classValue=="DATACHANGE") {
		buildTableDataChange(text);
	    bodwidth  = parent.parent.frames[1].document.body.offsetWidth
		bodheight = parent.parent.frames[1].document.body.offsetHeight
	    var x     = event.x
		var y     = event.y;
	    x     = x + (document.getElementById("tooltiplayer").offsetWidth)
		y     = y + (document.getElementById("tooltiplayer").offsetHeight)

		if(x<bodwidth) x = event.x
	    else x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

	    if(y<bodheight) y = event.y
	    else y = y - (document.getElementById("tooltiplayer").offsetHeight*2)

	    y += document.body.scrollTop
		x += document.body.scrollLeft
	    document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
	    document.getElementById("tooltiplayer").style.visibility='visible';
    } else {
	    document.getElementById("tooltiplayer").style.visibility='hidden';
    }
}
function buildTableDataChange(text) {
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
    tab_dat     += "<tr>";
    tab_dat     += "<td align='right'  style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow' nowrap  ><center><font size=1>"+text+"</font></td>";
    tab_dat     += "</tr>";
    tab_dat     += "</table>";

    document.getElementById("t").innerHTML = tab_dat;
}
////////**************** JS files of FMIssueFileManualEntry.jsp ****************//////////////
function getPractitioner(obj, target) {
	var practName_FName="";
	var practName_FValue="";
	var facility_id		= document.forms[0].facility_id.value;
	
	practName_FName=target.name;
	practName_FValue=target.value;
	getPractitioner_common(obj,target,"",facility_id,"Q2");
	//var sql = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";

	//var sql2 = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE  job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";
	
	/*var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr += " sql=\"" +encodeURIComponent(sql)+ "\"";
	xmlStr += " sqlSec=\"" +encodeURIComponent(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	*/
} // End of getPractitioner.
// To be called by the GeneralPractitionerSearch to set Practitioner.
function PractLookupRetVal(retVal,objName) {
	var arr;
	if (retVal != null) {
		arr=retVal.split("~");
		document.forms[0].returning_code.value=arr[0];
		document.forms[0].returning_desc.value=arr[1];			
		document.forms[0].files.disabled=false;
		document.forms[0].returning_desc.focus();
	} else {
		document.forms[0].returning_code.value="";
		document.forms[0].returning_desc.value="";			
		document.forms[0].files.disabled=true;
	}
} // End of PractLookupRetVal().
async function getValidRecords(returning_desc,locle) {
	var	fs_location	= document.forms[0].Req_locn_iden.value;	

	if ((fs_location == "C") || (fs_location == "N") || (fs_location == "E") || (fs_location == "Y")) {
		var target			= document.forms[0].returning_desc;
		var code			= document.forms[0].returning_code.value;
		var locations		= document.forms[0].locations.value;
		var facilityID		= document.forms[0].facility.value;	
		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var splitArray		= new Array();	

		splitArray = locations.split("@");
		if((fs_location == "C")) {
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E'  and language_id='"+locle+"' and facility_id like ? and mr_location_code like ? and  care_locn_type_ind = 'C' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
		
			window_title	=	getLabel("Common.clinic.label","common");
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facilityID;
			dataTypeArray[0]	= STRING ;
		
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= splitArray[0];
			dataTypeArray[1]	= STRING ;
		} else if ((fs_location == "E")) {
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and language_id='"+locle+"' and facility_id like ? and mr_location_code like ? and  care_locn_type_ind = 'E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.ProcedureUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facilityID;
			dataTypeArray[0]	= STRING ;
		
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= splitArray[0];
			dataTypeArray[1]	= STRING ;
		} else if ((fs_location == "Y")) {
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and language_id='"+locle+"'  and facility_id like ? and mr_location_code like ? and  care_locn_type_ind = 'D' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.DaycareUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facilityID;
			dataTypeArray[0]	= STRING ;
		
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= splitArray[0];
			dataTypeArray[1]	= STRING ;
		} else if ((fs_location == "N")) {
			sql	=	"Select nursing_unit_code code, long_desc description from ip_nursing_unit_lang_vw where eff_status='E' and language_id='"+locle+"'  and facility_id like ? and fs_locn_code like ? and upper(nursing_unit_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.nursingUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facilityID;
			dataTypeArray[0]	= STRING ;
			
			dataNameArray[1]	= "fs_locn_code" ;
			dataValueArray[1]	= splitArray[0];
			dataTypeArray[1]	= STRING ;
		}
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "3, 4";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		
		retVal = await CommonLookup( window_title, argumentArray );
		
		if(retVal != null && retVal != "" ) {
			var ret1	=	unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].returning_code.value	=	arr[0];
			document.forms[0].returning_desc.value	=	arr[1];
			if(document.ManualEntry_form.reason.style.visibility=='visible' && document.ManualEntry_form.reason.value ==""){
			
			//document.forms[0].files.disabled=false;
			document.forms[0].files.disabled=true;
			} else{
			  
			document.forms[0].files.disabled=false;
			
			}
			
			document.forms[0].returning_desc.focus();
		} else {
			document.forms[0].returning_desc.value	=	"";
			document.forms[0].returning_code.value	=	"";
			document.forms[0].files.disabled=true;
		} 
	}
	if(fs_location == "T") {
		var target			= document.forms[0].returning_desc;
		var code			= document.forms[0].returning_code;
		getPractitioner(code, target);
	}
}

function getValidDatas(e,ObjVal) {
	
	if(document.forms[0].patientid.value=="")
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	else {
		document.forms[0].flag.value='Y';
		ChkReqLocnValPat(ObjVal);
	}
}
function getValidFiles(e,ObjVal) {
	if(document.forms[0].fileno.value=="")
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	else {
		document.forms[0].flag.value='Y';
		ChkReqLocnValLoc(ObjVal);
	}
}
function CheckMaxLength(lab,obj,max,messageFrame) {
	if(obj.value.length > max) {
	//	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-SM0045 - " + lab + " cannot exceed " + max  + " characters" ;
		var msg1=getMessage("REMARKS_CANNOT_EXCEED","common");
		msg1=msg1.replace('$',lab);
		msg1=msg1.replace('#',max);
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" + msg1 ;
		obj.focus();
        return false;
    } else {
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="; 
		return true;
	}
}

function populateLocations(user) {
	var fac = ManualEntry_form.facility.value;
	var userSecurity = document.forms[0].userSecurity.value;
	var strLocn = document.forms[0].strLocn.value;

	var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMIssueFileFetchLocnValues.jsp?userSecurity="+userSecurity+"&Facility="+fac+"&User="+user+"&issueLocn="+strLocn+"&called_from=1 \"></form></body></html>";
	
	parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.forms[0].submit();

	ManualEntry_form.fileno.value = "";
	if(document.forms[0].file_type_appl_yn.value == "Y") {
		if(ManualEntry_form.file_type)
		ManualEntry_form.file_type.value			= "";
		if(ManualEntry_form.patient_file_type)
		ManualEntry_form.patient_file_type.value	= "";
	}
//	ManualEntry_form.volume_no.value = "";
	ManualEntry_form.patientid.value = "";
	ManualEntry_form.currfilelocn.value = "";
	ManualEntry_form.filestat.value = "";
	ManualEntry_form.remarks.value = "";
	parent.frames[2].document.getElementById("patline").innerText ="";
	ManualEntry_form.files.disabled = true;
	parent.frames[2].document.getElementById("detaillfields").style.visibility = 'hidden';
}
function populateUsers(facility) { 
	if(facility.length==0) {
		document.forms[0].searchuser.disabled=true;
	}else {
		document.forms[0].searchuser.disabled=false;
	}
	var selected = document.forms[0].locations;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);

	var opt = document.createElement("OPTION");
	opt.text = "---"+getLabel("Common.defaultSelect.label","common")+"---" ;
	opt.value = "" ;
	selected.add(opt);

	var selected1 = document.forms[0].narration;
	while ( selected1.options.length > 0 )
		selected1.remove(selected1.options[0]);

	var opt1 = document.createElement("OPTION");
	opt1.text = "---"+getLabel("Common.defaultSelect.label","common")+"---" ;
	opt1.value = "" ;
	selected1.add(opt1);

	document.forms[0].username1.value="";
	document.forms[0].username.value="";
	/*var HTMLVal = "<html><body><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMIssueFileFetchUserValues.jsp?Facility="+facility+" \"> </form></body></html>";
	parent.frames[4].document.write(HTMLVal);
	parent.frames[4].document.forms[0].submit();*/

	ManualEntry_form.fileno.value = "";
	if(document.forms[0].file_type_appl_yn.value == "Y") {
		if(ManualEntry_form.patient_file_type)
		ManualEntry_form.patient_file_type.value	= "";
		if(ManualEntry_form.file_type)
		ManualEntry_form.file_type.value			= "";
	}
	ManualEntry_form.volume_no.value = "";
	ManualEntry_form.patientid.value = "";
	ManualEntry_form.currfilelocn.value = "";
	ManualEntry_form.filestat.value = "";
	ManualEntry_form.remarks.value = "";
	ManualEntry_form.files.disabled = true; 
	parent.frames[2].document.getElementById("patline").innerText ="";
	parent.frames[2].document.getElementById("detaillfields").style.visibility = 'hidden';
}
function assignValues(ObjValue) {
	
	
	ManualEntry_form.patientid.value="";
	ManualEntry_form.patientid.onblur();
	ManualEntry_form.currfilelocn.value="";
	ManualEntry_form.filestat.value="";
	ManualEntry_form.remarks.value="";
	
	if(ObjValue != "")
	{
		//ManualEntry_form.files.disabled = false;
	}
	else
	{  
         /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
	    document.getElementById("remark_visible").style.visibility='hidden' 
	    document.ManualEntry_form.reason.style.visibility='hidden'
		 /* end ML-MMOH-CRF-0393-IN057159  */
		if(ManualEntry_form.fileno)
		ManualEntry_form.fileno.value = "";
		if (document.forms[0].file_type_appl_yn.value == "Y")
		{
			if(ManualEntry_form.patient_file_type)
			ManualEntry_form.patient_file_type.value	= "";
			if(ManualEntry_form.file_type)
			ManualEntry_form.file_type.value			= "";
		}
		ManualEntry_form.volume_no.value = "";
		ManualEntry_form.patientid.value = "";
		ManualEntry_form.currfilelocn.value = "";
		ManualEntry_form.filestat.value = "";
		ManualEntry_form.remarks.value = "";
		parent.frames[2].document.getElementById("patline").innerText ="";
		ManualEntry_form.files.disabled = true;
		parent.frames[2].document.getElementById("detaillfields").style.visibility = 'hidden';
	}

	var reqLocnArr = ObjValue.split("@");
	ManualEntry_form.Req_locn_code.value = reqLocnArr[0];
	ManualEntry_form.Req_locn_iden.value = reqLocnArr[1];	
	ManualEntry_form.Req_locn_mr_locn.value = reqLocnArr[2];
	
	document.forms[0].returning_desc.disabled=false;
	document.forms[0].requesting_btn.disabled=false;

	if(reqLocnArr[1]=="C") {
		document.getElementById("id1").innerHTML=getLabel("Common.clinic.label","common");
		ManualEntry_form.files.disabled = true;
		document.forms[0].returning_desc.value		="";
		document.forms[0].returning_code.value		="";
	} else if (reqLocnArr[1]=="N") {
		document.getElementById("id1").innerHTML=getLabel("Common.nursingUnit.label","common");
		ManualEntry_form.files.disabled = true;
		document.forms[0].returning_desc.value		="";
		document.forms[0].returning_code.value		="";
	} else if (reqLocnArr[1]=="E") {
		document.getElementById("id1").innerHTML=getLabel("Common.ProcedureUnit.label","common");
		ManualEntry_form.files.disabled = true;
		document.forms[0].returning_desc.value		="";
		document.forms[0].returning_code.value		="";
	} else if (reqLocnArr[1]=="Y") {
		document.getElementById("id1").innerHTML=getLabel("Common.DaycareUnit.label","common");
		ManualEntry_form.files.disabled = true;
		document.forms[0].returning_desc.value		="";
		document.forms[0].returning_code.value		="";
	} else if (reqLocnArr[1]=="T") {
		document.getElementById("id1").innerHTML=getLabel("Common.practitioner.label","common");
		ManualEntry_form.files.disabled = true;
		document.forms[0].returning_desc.value		="";
		document.forms[0].returning_code.value		="";
	} else {
		document.getElementById("id1").innerHTML=getLabel("eFM.Requesting.label","FM");
		document.forms[0].returning_desc.value		="";
		document.forms[0].returning_code.value		="";
		document.forms[0].returning_desc.disabled	=true;
		document.forms[0].requesting_btn.disabled	=true;
		ManualEntry_form.files.disabled				= false;
	}
	if(ObjValue=="")
		ManualEntry_form.files.disabled = true;
	var narrcode = reqLocnArr[3];
	if(narrcode == null || narrcode == "null")	narrcode = "";
	ManualEntry_form.narration.value = narrcode;

	/*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
	if(document.forms[0].narration.options[document.forms[0].narration.selectedIndex].text.toLowerCase()=='others')
	{ 
	    document.getElementById("remark_visible").style.visibility='visible' 
	    document.ManualEntry_form.reason.style.visibility='visible' 
		document.ManualEntry_form.mandatory.style.visibility='visible'
		 ManualEntry_form.files.disabled				= true;
		 document.ManualEntry_form.reason.value=""
	} else{
	
		document.getElementById("remark_visible").style.visibility='hidden' 
	    document.ManualEntry_form.reason.style.visibility='hidden'
		document.ManualEntry_form.mandatory.style.visibility='hidden'
	}
	/* end ML-MMOH-CRF-0393-IN057159  */
	var noofdays = reqLocnArr[4];
	if(noofdays == null || noofdays == "null")	noofdays = "0";
	ManualEntry_form.No_Of_Days.value = noofdays;
}
function CheckPatientExists(ObjVal) {
	
	if(ObjVal != "" ) {

		var facility = ManualEntry_form.facility.value;
		var selLocn = ManualEntry_form.Req_locn_code.value;
		var userSecurity = document.forms[0].userSecurity.value;
		var access_all = document.forms[0].access_all.value;
		var strLocn = document.forms[0].strLocn.value;
		var file_type=ManualEntry_form.file_type.value;
     
	  var file_no="";
	 // if(document.forms[0].file_type_appl_yn.value =="N")
	//	{
	     file_no=ManualEntry_form.file_no.value;
			//}
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMIssueFileManualCheckPatient.jsp?userSecurity="+userSecurity+"&access_all="+access_all+"&Patient="+ObjVal+"&Facility="+facility+"&selLocn="+selLocn+"&file_no="+file_no+"&issueLocn="+strLocn+"\"> </form></body></html>";
		parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
//parent.frames[4].document.write(HTMLVal);
		parent.frames[4].document.Dummy.submit();
	}
}
function CheckFileExists(ObjVal) {
	if(ObjVal != "") {
		var facility = ManualEntry_form.facility.value;
		var selLocn = ManualEntry_form.Req_locn_code.value;
		var userSecurity = document.forms[0].userSecurity.value;
		var access_all = document.forms[0].access_all.value;
		var strLocn = document.forms[0].strLocn.value;
//		var doc_or_file = document.forms[0].doctype_appl_yn.value;

		//alert("int");
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMIssueFileManualCheckFile.jsp?userSecurity="+userSecurity+"&access_all="+access_all+"&FileNo="+ObjVal+"&Facility="+facility+"&selLocn="+selLocn+"&issueLocn="+strLocn+"\"> </form></body></html>";
		parent.frames[4].document.write(HTMLVal);
		parent.frames[4].document.forms[0].submit();
	}
}
function ChkReqLocnValPat(fldval) {
	
	if(fldval != "" && ManualEntry_form.locations.value != "")
		CheckPatientExists(fldval);
	else if(fldval != "" && ManualEntry_form.locations.value == "") {
		var errors = getMessage('FILE_STORAGE_NOT_BLANK','FM');
		parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		parent.frames[3].document.forms[0].locations.focus();
	}
}
function ChkReqLocnValLoc(fldval) {
	if(fldval != "" && ManualEntry_form.locations.value != "")
		CheckFileExists(fldval);
	else if(fldval != "" && ManualEntry_form.locations.value == "") {
		var errors = getMessage('FILE_STORAGE_NOT_BLANK','FM');
		parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		parent.frames[3].document.forms[0].locations.focus();
	}
}
function ValidateDateTime(from,sys_date) {
	var obj=from;
	if(from.value!="") {
		if(doDateTimeChk(from)) {
			from = from.value
			sys_date =	sys_date.value
			
			var a=  from.split(" ")
			splitdate=a[0];
			splittime=a[1]

			var splitdate1 =a[0].split("/")
			var splittime1= a[1].split(":")

			var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
				
			a= sys_date.split(" ")
			splitdate=a[0];
			splittime=a[1]

			splitdate1 =a[0].split("/")
			splittime1= a[1].split(":")

			var sys_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
			
			if(Date.parse(from_date) >= Date.parse(sys_date)) {
				var msg = "";
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				return true;
			} else {
				var msg = getMessage('RETURN_DATE_NOT_LESS_SYSDATE','FM');
				alert(msg);
				obj.focus();
				obj.select();
				return false;
			}
		} else if(doDateTimeChk(from)== false) {
			alert(getMessage('INVALID_DATE_TIME','SM'));
		    obj.focus();
			obj.select();
			return false;	
		}
	}
}

function AddDoc() {
	var Obj = ManualEntry_form
	var strLocn = document.forms[0].strLocn.value;
	Obj.Issue_user_id.value = parent.frames[1].document.forms[0].username.value;
	Obj.Req_fac_id.value = Obj.facility.options[Obj.facility.selectedIndex].value;
	Obj.Req_fac_name.value = Obj.facility.options[Obj.facility.selectedIndex].text;
	
	if(Obj.locations.selectedIndex != 0) {
		Obj.Req_locn_desc.value = Obj.locations.options[Obj.locations.selectedIndex].text;
	}
	if(Obj.req_mode.selectedIndex != 0) {
		Obj.Req_req_mode.value = Obj.req_mode.options[Obj.req_mode.selectedIndex].value;
	}
	if(Obj.username.length != 0) {
		Obj.Req_by.value = Obj.username.value;
		Obj.Req_by_name.value = Obj.username1.value;
	}
	if(Obj.narration.selectedIndex != 0) {
		Obj.Narration_code.value = Obj.narration.options[Obj.narration.selectedIndex].value;
		Obj.Narration_desc.value = Obj.narration.options[Obj.narration.selectedIndex].text;
	}
	Obj.patientid.disabled = false;
	var fields = new Array ( Obj.username, Obj.locations, Obj.patientid, Obj.volume_no);
	var names = new Array ( getLabel("Common.name.label","common"), getLabel("eFM.FSLocation.label","FM"), getLabel("Common.patientId.label","common"), getLabel("eFM.VolumeNo.label","FM"));
	if(document.forms[0].file_type_appl_yn.value == "N") {
		Obj.fileno.disabled = false;
 		fields[fields.length] = Obj.fileno;
 		names[names.length] = getLabel("Common.fileno.label","common");
	} else if (document.forms[0].file_type_appl_yn.value == "Y") {
		Obj.file_type.disabled = false;
 		fields[fields.length] = Obj.patient_file_type;
 		names[names.length] = getLabel("Common.filetype.label","common");
	}
//	if(parent.frames[3].checkFields( fields, names, parent.messageFrame)) {
		if(Obj.Curr_locn_code.value != strLocn) {
			var errors = getMessage('FILE_IS_NOT_AT_ISS_LOCN','FM');
			alert(errors);
			ManualEntry_form.fileno.value = "";
			if (document.forms[0].file_type_appl_yn.value == "Y")
			{
				if(ManualEntry_form.patient_file_type)
				ManualEntry_form.patient_file_type.value	= "";
				if(ManualEntry_form.file_type)
				ManualEntry_form.file_type.value			= "";
			}	
			
			len = ManualEntry_form.volume_no.length;  			
			for(i=1;i<=len;i++) { 				
				ManualEntry_form.volume_no.remove(0);
			}

			var selectOption	=  document.createElement("OPTION");		
			selectOption.value	=	"";
			selectOption.text	=	"--------"+getLabel("Common.defaultSelect.label","common")+"--------";
			ManualEntry_form.volume_no.add(selectOption);

			ManualEntry_form.patientid.value = "";
			ManualEntry_form.currfilelocn.value = "";
			ManualEntry_form.filestat.value = "";
			ManualEntry_form.remarks.value = "";
			parent.frames[3].document.getElementById("patline").innerText ="";

			if(document.forms[0].file_type_appl_yn.value == "N") {
				var patient_id_max_length	= Math.abs(ManualEntry_form.patient_id_max_length.value); 
				var file_no_function		= ManualEntry_form.file_no_function.value; 
			}
		} else {
			parent.frames[3].document.ManualEntry_form.submit();
			if (document.forms[0].file_type_appl_yn.value == "N") {
				var patient_id_max_length	= Math.abs(ManualEntry_form.patient_id_max_length.value); 
				var file_no_function		= ManualEntry_form.file_no_function.value; 
				if (parent.frames[3].document.getElementById("fileno") != null) {
					parent.frames[3].document.getElementById("fileno").innerHTML="<input type='text' name='fileno' id='fileno'  value='' onBlur='ChangeUpperCase(this);"+file_no_function+"' onChange='ChkReqLocnValLoc(this.value);' maxlength='"+patient_id_max_length+"' size = '"+(patient_id_max_length+2)+"' ><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
				}
			}
		/*	var selectBox = parent.frames[3].document.ManualEntry_form.volume_no;
			var length = Math.abs(selectBox.length);
			for (i=0;i<length;i++)
				selectBox.remove(0);
			var option = parent.frames[3].document.createElement("OPTION");
			option.text		= "-Select-";
			option.value	 = "";
			selectBox.add(option);
			parent.frames[3].document.ManualEntry_form.volume_no.value = "";
			parent.frames[3].document.getElementById("patline").innerText ="";*/
		}
//	}
}

function showEncounter(enc,patid,fileno,Patient_Class)
{
	
	var call_function = "VIEW_ENCOUNTER_DTLS";
	var jsp_name="FMCurrentEncounterMain.jsp";
	var win_height = "30.8";
	var win_width= "50";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "58" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = window.showModalDialog("../../eFM/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&fileNo="+fileno+"&Patient_Class="+Patient_Class,arguments,features);
}


function CheckPatientExists1(ObjVal,volcount) {
	
	if(ObjVal != "" ) {
		var facility = ManualEntry_form.facility.value;
		var selLocn = ManualEntry_form.Req_locn_code.value;
		var userSecurity = document.forms[0].userSecurity.value;
		var access_all = document.forms[0].access_all.value;
		var strLocn = document.forms[0].strLocn.value;
		
		var file_type=ManualEntry_form.patient_file_type.value;
		var volume_no = ManualEntry_form.volume_no.value;
		//var currfilelocn=parent.frames[2].ManualEntry_form.locations.value;
		var file_no="";
	 if(document.forms[0].file_type_appl_yn.value =="N")
	 {
	 		 file_no=ManualEntry_form.fileno.value;
	 }
		
		/*
		if(file_type != "")
		{ 
			var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMIssueFileManualCheckPatient.jsp?userSecurity="+userSecurity+"&access_all="+access_all+"&Patient="+ObjVal+"&Facility="+facility+"&selLocn="+selLocn+"&issueLocn="+strLocn+"&file_type="+file_type+"&volume_no="+volume_no+"&volcount="+volcount+"\"> </form></body></html>";
			//parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[4].document.write(HTMLVal);
			parent.frames[4].document.Dummy.submit();
		}
		else
		{
			parent.frames[4].document.location.href='../../eCommon/jsp/error.jsp';
		}
		*/
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMIssueFileManualCheckPatient.jsp?userSecurity="+userSecurity+"&access_all="+access_all+"&Patient="+ObjVal+"&Facility="+facility+"&selLocn="+selLocn+"&issueLocn="+strLocn+"&file_type="+file_type+"&volume_no="+volume_no+"&file_no="+file_no+"&volcount="+volcount+"\"> </form></body></html>"; 		
		parent.frames[4].document.write(HTMLVal);
		parent.frames[4].document.getElementById("Dummy").submit();
	}
}

