

function show() 
{
	//parent.parent.window.document.title = "Setup Contact Modes" ;
}

function create() 
{
	f_query_add_mod.location.href = "../../eMP/jsp/addContact.jsp" ;
}

function edit() 
{
	//formToolbarFrame.location.href = "formToolbar.html" ;
}

/*
function query() 
{ 
	plineFrame.location.href ="../../eCommon/html/blank.html";

	if(f_query_add_mod.frames[1].document.forms[0] != null)
	{  
		
		if(f_query_add_mod.frames[1].document.forms[0] != null)
		{ 
			if(f_query_add_mod.frames[1].document.forms[0].name == 'PatRegForm')
			{
				var r, re;
				var s =f_query_add_mod.frames[1].document.location.href;
				re = "blank.jsp";
				r = s.match(re);
				var func_id="";
				if(r == null)
				{
					func_id = f_query_add_mod.frames[0].document.forms[0].function_id.value;
					if (func_id=='')
						f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=3";
					else
						f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=8";
				}
				else
				{
					f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=3";
				}
			}
			else
			{
				f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=3";
			}
		}
		else if(frames[1].frames[0] != null)
			{
				if(frames[1].frames[0].document.forms[0].function_id.value == '\"CAPTUREPATPHOTO\"')
					f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=8";
				else
					f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=3";
			}
			else
				f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=3";
		
	}
	else
	{
		f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=3";
	}
}
*/

function apply() 
{
	var fields = new Array ( f_query_add_mod.document.contact_form.contact_code, 
	 f_query_add_mod.document.contact_form.long_desc, 				 f_query_add_mod.document.contact_form.short_desc );	
				       
        var names = new Array(getLabel("Common.contactmode.label","common"), getLabel("Common.longdescription.label","common"), getLabel("Common.shortdescription.label","common"));	
		
        var transform = new Array(f_query_add_mod.document.contact_form,
				    f_query_add_mod.document.contact_form.eff_date_from,
				    f_query_add_mod.document.contact_form.eff_date_from1,
				    f_query_add_mod.document.contact_form.eff_date_to,
				    f_query_add_mod.document.contact_form.eff_date_to1 );		
							   
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{
		if(f_query_add_mod.DateTransform(transform,messageFrame)) 
		{	
		   var fn_status = f_query_add_mod.document.contact_form.function_name.value ;
		}	
	} 
}
	
function reset() 
{
	//f_query_add_mod.document.forms[0].reset();
}

function onSuccess() 
{
	f_query_add_mod.contact_form.contact_code.value		= "" ;
	f_query_add_mod.contact_form.long_desc.value		= "" ;
	f_query_add_mod.contact_form.short_desc.value		= "" ;
	f_query_add_mod.contact_form.eff_date_from1.value	= "" ;
	f_query_add_mod.contact_form.eff_date_to1.value		= "" ;
}

function f1()
{
	parent.patient_main.document.getElementById("refrel").click()
}

var currentTab = new String();
currentTab = "demogrp_tab";

function tab_click(objName)
{
   	   var patient_id = "";
	   if(document.forms[0].patient_id)
			patient_id = document.getElementById('patient_id').value;    
	// FIRST CHANGE THE CURRENT SELECTED TAB
		if (objName == 'demogrp_tab') {
			parent.patient_sub.moveToTab(1);
		}
        else if (objName == "cmodeaddr_tab")
            parent.patient_sub.moveToTab(2);            
        else if (objName == "rlcnts_tab")
			parent.patient_sub.moveToTab(3);
        else if (objName == 'others_tab')
            parent.patient_sub.moveToTab(4);
         else if (objName == "pat_docs_tab")
            parent.patient_sub.moveToTab(6);
        else if (objName == "findtl_tab"){
            parent.patient_sub.moveToTab(1);
           // parent.patient_sub.moveToTab(5);
            getFinDtl(patient_id);
		}  else if(objName == "add_mod_dtl")
			parent.patient_sub.moveToTab(7);
		/*
		if(objName == 'rlcnts_tab'){
			 parent.frames[1].document.getElementById("kin").focus(); 
		}
		*/
		
	}

 async function getFinDtl(patient_id) 
	{
		var retVal;
		var dialogHeight= "95vh" ;//600px
		var dialogWidth = "80vw" ;//900px
		//var dialogTop = "10px" ;//85
		var dialogTop = "0px" ;
		var center = "1" ;                                                         
		var status="no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments   = "" ;
		var Title       = encodeURIComponent(getLabel("Common.financialdetails.label","Common"));
		var url = "../../eBL/jsp/BLFinDtlQryMain.jsp?patientid="+patient_id+"&title="+Title;
		retVal = await top.window.showModalDialog(url,arguments,features);
		if(retVal==null) retVal="";
		return retVal; 
	
	}

    
   /* function checkPatientId()   {
        if ( document.getElementById("patient_id").value.length != document.getElementById("patient_id").size && document.getElementById("patient_id").value.length > 0)
        {

			var msg = getMessage("PAT_ID_CH","MP");
			msg = msg.replace("$",document.getElementById("patient_id").size );
			alert(msg);
            document.getElementById("patient_id").focus();
        }

        if ( document.getElementById("patient_id").value.length == document.getElementById("patient_id").size )
        {

            var HTMLVal = new String();
            HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='3'><input name='pat_id' id='pat_id' type='hidden' value='"+document.getElementById("patient_id").value+"'></form></BODY></HTML>";
            parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.parent.messageFrame.document.form1.submit();
        }
    }*/


function back(obj)
{
	var s=escape(obj);
	parent.window.document.location.href="ViewPatFamilyMembers1.jsp?Patient_ID="+s
}


var currentTab = new String();
currentTab = "demogrp_tab";

  
/*function checkPatientId() 
{
	if ( document.getElementById("patient_id").value.length != document.getElementById("patient_id").size && document.getElementById("patient_id").value.length > 0)
	{
			var msg = getMessage("PAT_ID_CH","MP");
			msg = msg.replace("$",document.getElementById("patient_id").size );
			alert(msg);
		document.getElementById("patient_id").focus();
	}

	if ( document.getElementById("patient_id").value.length == document.getElementById("patient_id").size )
	{

		var HTMLVal = new String();
		HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='3'><input name='pat_id' id='pat_id' type='hidden' value='"+document.getElementById("patient_id").value+"'></form></BODY></HTML>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
	}
}*/


function back(obj)
{
	var s=escape(obj);
	parent.window.document.location.href="ViewPatFamilyMembers1.jsp?Patient_ID="+s
}

function f1()
{
  document.getElementById("demogrp_tab").focus(); 
}

async function capturePhoto(patientid, name, moduleid, facilityid, userid, wsno, locale) 
{

	// Patient Name Value added as parameter in the capturePhoto

	// Code commented by Sethu for 64523	PMG2017-COMN-CRF-0005	Patient Photo capture in EM 

	/*
	var url				= "../../eMP/jsp/photo_capture.jsp?patient_id="+patient;
	var dialogHeight	= "25";
    var dialogWidth		= "49";
    */

	// Code added by Sethu for 64523	PMG2017-COMN-CRF-0005	Patient Photo capture in EM 

	var url				= "../../eMP/jsp/EM_Patient_Photo.jsp?patient_id="+patientid+"&module_id="+moduleid+"&patient_name="+name+"&facility_id="+facilityid+"&user_id="+userid+"&ws_no="+wsno+"&locale="+locale;
    var dialogHeight	= "24";//24
    var dialogWidth		= "47";//47
    var arguments		= "";

    var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;";
    var reportURL		= await window.showModalDialog( url, arguments, features ) ;
	if(reportURL=='close')
		//window.close();
	var dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();

	if (moduleid == "MP")
	{
		parent.parent.frames[1].location.reload();
	}
	
}
async function uploadPhoto(patient,photoCount){
	// height & width modified for smart card
	var url				= "../../eMP/jsp/photo_upload_main.jsp?patient_id="+patient+"&photoCount="+photoCount;
    var dialogHeight	= "300px";//17
    var dialogWidth		= "500px";//45
    var arguments		= "";
    var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;";
    var reportURL		= await window.showModalDialog( url, arguments, features ) ;
	
	if(reportURL=='close')
		//window.close();
	var dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}

async function capturePhotoMain(patient, name) 
{
	var url				= "../../eMP/jsp/photo_capture_main.jsp?patient_id="+patient+"&module_id=MP&patient_name="+name;
	var dialogHeight	= "150px";
	var dialogWidth		= "350px";
    var arguments		= "";
    var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;";
    var reportURL		= await window.showModalDialog( url, arguments, features ) ;	
	parent.parent.frames[1].location.reload();
}


function capturePhotoH5(patient_id, patient_name,module_id,facility_id,user_id,ws_no,locale,photo_count){
	
	var action_url="../../eMP/jsp/capture_image.jsp?patient_id="+patient_id+"&photo_count="+photo_count+"&module_id="+module_id+"&patient_name="+patient_name+"&facility_id="+facility_id+"&user_id="+user_id+"&ws_no="+ws_no+"&locale="+locale;
	var title="";
	var bodwidth  = window.screen.width+window.screen.width;
	var	bodheight = window.screen.height+window.screen.height;	
	var var1 = window.open(action_url,"","height="+bodheight+",width="+bodwidth+",top=0,status=0,toolbar=no,menubar=no,location=no,left=0,right=0,bottom=0,this.minimise=no");
}

 function reloadPline() {
	callcancle();
	parent.parent.frames[1].location.reload();
	
}


function callsubmit(){
	// Added by Sethu for 64523	PMG2017-COMN-CRF-0005	Patient Photo capture in EM 
	// Patient Name Value added as parameter in the capturePhoto

	var moduleId = "";
	var facility_id = "";
	var user_id = "";
	var ws_no = "";
	var locale = "";
	
	moduleId = document.patPhotoMain.module_id.value;
	facility_id = document.patPhotoMain.facility_id.value;
	user_id = document.patPhotoMain.user_id.value;
	ws_no = document.patPhotoMain.ws_no.value;
	locale = document.patPhotoMain.locale.value;
	var photo_count = document.getElementById("photoCount").value;

	if(document.patPhotoMain.cam.checked){ 
		//capturePhoto(document.patPhotoMain.patient_id.value, document.patPhotoMain.patient_name.value, document.patPhotoMain.module_id.value , document.patPhotoMain.facility_id.value, document.patPhotoMain.user_id.value, document.patPhotoMain.ws_no.value,  document.patPhotoMain.locale.value   );	
		capturePhotoH5(document.patPhotoMain.patient_id.value, document.patPhotoMain.patient_name.value, document.patPhotoMain.module_id.value , document.patPhotoMain.facility_id.value, document.patPhotoMain.user_id.value, document.patPhotoMain.ws_no.value,  document.patPhotoMain.locale.value,photo_count );
	}else{
			
		if (moduleId == "BD")
		{
			uploadBTPhoto(document.patPhotoMain.patient_id.value,document.patPhotoMain.photoCount.value, facility_id, user_id, ws_no);
		}
		else if (moduleId == "MP")
			uploadPhoto(document.patPhotoMain.patient_id.value,document.patPhotoMain.photoCount.value);
		
	}
}

async function uploadBTPhoto(patient,photoCount,facility_id,user_id,ws_no){
	var url				= "../../eBT/jsp/photo_upload_main.jsp?patient_id="+patient+"&photoCount="+photoCount+"&facility_id="+facility_id+"&user_id="+user_id+"&ws_no="+ws_no;
    var dialogHeight	= "12";
    var dialogWidth		= "39";
    var arguments		= "";
    var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;";
    var reportURL		= await window.showModalDialog( url, arguments, features ) ;	
	if(reportURL=='close')
		//window.close();
	var dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}	
function callcancle(){
	//window.close();
	var dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}

function  select_cam(obj){
	if(obj.checked ==true){
			document.patPhotoMain.uplfile.checked=false;
	}
}

function  select_upload(obj){
	if(obj.checked ==true){
		document.patPhotoMain.cam.checked=false;
	}
}

function changephotofun(obj){
	if(obj.checked){
		document.patPhotoMain.cam.disabled=false;		
		document.patPhotoMain.uplfile.disabled=false;		
		document.patPhotoMain.OK.disabled=false;		
	}else{
		document.patPhotoMain.uplfile.checked=false;
		document.patPhotoMain.cam.checked=true;
		document.patPhotoMain.cam.disabled=true;		
		document.patPhotoMain.uplfile.disabled=true;		
		document.patPhotoMain.OK.disabled=true;		
	}
}

function uploadfile(){
	


	/*Modified By Dharma against AMS-SCF-0516 [IN:064237] on 19th May 2017 Start*/
	//var file_typ=parent.criteria_frame.document.photoUpload.patFile.value;
	//file_typ=file_typ.substr(file_typ.indexOf(".")+1,4);
	var file_typ	= "";
	if(criteria_frame.document.photoUpload.patFile.value!=""){
		var fileTypeArr = criteria_frame.document.photoUpload.patFile.value.split(/[\s.]+/);
		file_typ	= fileTypeArr[fileTypeArr.length-1].toUpperCase();
	}
	/*Modified By Dharma against AMS-SCF-0516 [IN:064237] on 19th May 2017 End*/

	if(file_typ=='gif' || file_typ=='jpg' || file_typ=='JPG' || file_typ=='GIF'){
		/*var  fso,f;
		fso = new ActiveXObject("Scripting.FileSystemObject");
				
		if(fso.FileExists(criteria_frame.document.photoUpload.patFile.value)){ 
			file=fso.getFile(criteria_frame.document.photoUpload.patFile.value);
			if(file.size > 2147483648){
				alert(getMessage("FILE_GREATER_2GB","MP"));	
			}else{
				criteria_frame.document.photoUpload.action="../../servlet/eMP.PhotoUploadServlet"
				criteria_frame.document.photoUpload.submit();
			}*/
			var fileInput = criteria_frame.document.photoUpload.patFile;
    
    if (fileInput.files && fileInput.files.length > 0) {
        var file = fileInput.files[0];  
  
        if (file.size > 2147483648) {
            alert(getMessage("FILE_GREATER_2GB", "MP"));
        } else {
          
            criteria_frame.document.photoUpload.action = "../../servlet/eMP.PhotoUploadServlet";
            criteria_frame.document.photoUpload.submit();
        }
		 }	
	}else{
		alert(getMessage("INVALID_FILE_TYPE","MP"));
	}
}
function onkeyPressEvent(e){
			return false;
}

