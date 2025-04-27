
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
			patient_id = document.forms[0].patient_id.value;    
	// FIRST CHANGE THE CURRENT SELECTED TAB
		if (objName == 'demogrp_tab') {
			parent.patient_sub.moveToTab(1);
		}
        else if (objName == 'cmodeaddr_tab')
            parent.patient_sub.moveToTab(2);            
        else if (objName == 'rlcnts_tab')
			parent.patient_sub.moveToTab(3);
        else if (objName == 'others_tab')
            parent.patient_sub.moveToTab(4);
         else if (objName == 'pat_docs_tab')
            parent.patient_sub.moveToTab(6);
        else if (objName == 'findtl_tab'){
            parent.patient_sub.moveToTab(1);
           // parent.patient_sub.moveToTab(5);
            getFinDtl(patient_id);
		}  else if(objName == 'add_mod_dtl')
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
		var dialogHeight= "42" ;
		var dialogWidth = "65" ;
		var dialogTop = "85" ;
		var center = "1" ;                                                         
		var status="no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments   = "" ;
		var Title       = encodeURIComponent(getLabel("Common.financialdetails.label","Common"));
		var url = "../../eBL/jsp/BLFinDtlQryMain.jsp?patientid="+patient_id+"&title="+Title;
		retVal = await window.showModalDialog(url,arguments,features);
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

async function capturePhoto(patient) 
{
	var url				= "../../eBT/jsp/photo_capture.jsp?patient_id="+patient;
	//alert(url);
    var dialogHeight	= "25";
    var dialogWidth		= "49";
    var arguments		= "";
    var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;";
    var reportURL		= await window.showModalDialog( url, arguments, features ) ;
	if(reportURL=='close')
		window.close();
}
async function uploadPhoto(patient,photoCount,facility_id,user_id,ws_no){
	//alert('uploadPhoto');
	var url				= "../../eBT/jsp/photo_upload_main.jsp?patient_id="+patient+"&photoCount="+photoCount+"&facility_id="+facility_id+"&user_id="+user_id+"&ws_no="+ws_no;
    var dialogHeight	= "12";
    var dialogWidth		= "39";
    var arguments		= "";
    var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;";
    var reportURL		= await window.showModalDialog( url, arguments, features ) ;	
	if(reportURL=='close')
		window.close();
}

async function capturePhotoMain(patient,facility_id,user_id,ws_no) 
{
	var url				= "../../eBT/jsp/photo_capture_main.jsp?patient_id="+patient+"&facility_id="+facility_id+"&user_id="+user_id+"&ws_no="+ws_no;
    var dialogHeight	= "12";
    var dialogWidth		= "25";
    var arguments		= "";
    var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;";
    var reportURL		= await window.showModalDialog( url, arguments, features ) ;	
	parent.parent.frames[1].location.reload();
}

function callsubmit(){
	//alert('submit');
	if(document.patPhotoMain.cam.checked){
		capturePhoto(document.patPhotoMain.patient_id.value);		
	}else{
		uploadPhoto(document.patPhotoMain.patient_id.value,document.patPhotoMain.photoCount.value);
	}
}
function callcancle(){
	window.close();
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
	//alert('uploadfile');
	/*var file_typ=parent.criteria_frame.document.photoUpload.patFile.value;
	file_typ=file_typ.substr(file_typ.indexOf(".")+1,4);*/

	var file_typ	= "";
	if(parent.criteria_frame.document.photoUpload.patFile.value!=""){
		var fileTypeArr = parent.criteria_frame.document.photoUpload.patFile.value.split(/[\s.]+/);
		file_typ	= fileTypeArr[fileTypeArr.length-1].toUpperCase();
	}

	if(file_typ=='gif' || file_typ=='jpg' || file_typ=='JPG' || file_typ=='GIF'){
		//alert('before submit' + parent.criteria_frame.document.photoUpload.action);
		parent.criteria_frame.document.photoUpload.submit();
	}else{
		alert(getMessage("INVALID_FILE_TYPE","MP"));
	}
}
function onkeyPressEvent(e){
			return false;
}

