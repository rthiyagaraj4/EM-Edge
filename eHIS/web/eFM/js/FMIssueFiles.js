//var added_rem_remarks= new ActiveXObject("Scripting.Dictionary");
var added_patfile_vol = new Map();
var added_rem_remarks = new Map();


function apply() {
	
	
	if(parent.frames[2].frames[1].document.forms[0].issuetype.value != 'SelectAll') {
		var tab_check = parent.frames[2].frames[1].document.forms[0].selected_tab.value
			if ( tab_check=='page_three_tab') {
			if(parent.frames[2].frames[1].document.forms[0].issue_select.value == "Y") {
				var fields = new Array ( parent.frames[2].frames[1].document.forms[0].username  );
				var names = new Array (getLabel("Common.issuedby.label","common"));

				var p_tracer_card_yn = parent.frames[2].frames[1].document.forms[0].print_tracer_card.value ;
				var fileCount = "";
				var Patient_Id = "";
				if (parent.frames[2].frames[2].frames[0].document.forms[0].fileCount != null)
					fileCount = parent.frames[2].frames[2].frames[0].document.forms[0].fileCount.value;
					if(parseInt(fileCount) == 1)
					  Patient_Id = parent.frames[2].frames[2].frames[0].document.forms[0].Patient_Id.value;						
				
				var doc_or_file = parent.frames[2].frames[1].document.forms[0].file_doc.value;
				
				//Added for this CRF HSA-CRF-0306.1	
				var isSiteSpefCurrentFsLocation="";
                if(parent.frames[2].frames[2].frames[0].document.forms[0].isCurrentFsLocation)				
				  isSiteSpefCurrentFsLocation=parent.frames[2].frames[2].frames[0].document.forms[0].isCurrentFsLocation.value;
				var current_date="";
                if(parent.frames[2].frames[2].frames[0].document.forms[0].sys_date)				
				  current_date=parent.frames[2].frames[2].frames[0].document.forms[0].sys_date.value; 
				 
				
				var to_submit= false;
				if(fileCount == 0) {
					to_submit= false;
				} else {
					to_submit= true;
				}
				//File can be issued only if the current tab is issue file which will have tab_check=1
					if(to_submit == true) {
						if(parent.frames[2].frames[1].checkFields( fields, names, parent.frames[2].messageFrame)) {
							if(p_tracer_card_yn=='Y' && doc_or_file=='F')
								{
								
							//	if(confirm("Do you want to print tracer card ?")) {
								var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action='../../servlet/eFM.FMIssueFilesServlet'><input name='p_tracer_card_yn' id='p_tracer_card_yn' type='hidden' value='"+p_tracer_card_yn+"'>";
								HTMLVal += "<input name='fileCount' id='fileCount' type='hidden' value='"+fileCount+"'>";
								HTMLVal += "<input name='doc_or_file' id='doc_or_file' type='hidden' value='"+doc_or_file+"'>";	
								HTMLVal += "<input name='isCurrentFsLocation' id='isCurrentFsLocation' type='hidden' value='"+isSiteSpefCurrentFsLocation+"'>";
								HTMLVal += "<input name='sys_date' id='sys_date' type='hidden' value='"+current_date+"'>";
								if(parseInt(fileCount) == 1)
								 HTMLVal += "<input name='Patient_Id' id='Patient_Id' type='hidden' value='"+Patient_Id+"'>";
								var i = 0 ;
								while(i<parseInt(fileCount)) {  							 

									file_trans_mode = "parent.frames[2].frames[2].frames[0].document.forms[0].file_transport_mode"+i+".value";
									file_trans_mode = eval(file_trans_mode);
									carried_by = "parent.frames[2].frames[2].frames[0].document.forms[0].carried_by_name"+i+".value";
									carried_by = eval(carried_by);	
									var retdate = "parent.frames[2].frames[2].frames[0].document.forms[0].retdate"+i+".value";
									retdate = eval(retdate);
									//Added for this CRF HSA-CRF-0306.1
									var return_date = "parent.frames[2].frames[2].frames[0].document.forms[0].return_date"+i+".value";
									return_date = eval(return_date);                                     
								    var fslocn_return_criteria = "parent.frames[2].frames[2].frames[0].document.forms[0].fslocn_return_criteria"+i+".value";
								    fslocn_return_criteria = eval(fslocn_return_criteria); 
									var dischargedatetime = "parent.frames[2].frames[2].frames[0].document.forms[0].dischargedatetime"+i+".value";
								    dischargedatetime = eval(dischargedatetime);
									
									  HTMLVal += "<input name='file_transport_mode"+i+"' id='file_transport_mode"+i+"' type='hidden' value='"+file_trans_mode+"'>";
									  HTMLVal += "<input name='carried_by_name"+i+"' id='carried_by_name"+i+"' type='hidden' value='"+carried_by+"'>";
									  HTMLVal += "<input name='retdate"+i+"' id='retdate"+i+"' type='hidden' value='"+retdate+"'>";
									  HTMLVal += "<input name='return_date"+i+"' id='return_date"+i+"' type='hidden' value='"+return_date+"'>";
                                      HTMLVal += "<input name='fslocn_return_criteria"+i+"' id='fslocn_return_criteria"+i+"' type='hidden' value='"+fslocn_return_criteria+"'>";
									  HTMLVal += "<input name='dischargedatetime"+i+"' id='dischargedatetime"+i+"' type='hidden' value='"+dischargedatetime+"'>";  
									  i++;
								}
							  	HTMLVal += "</form></body></html>";
						  } else { 
							  var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action='../../servlet/eFM.FMIssueFilesServlet'><input name='p_tracer_card_yn' id='p_tracer_card_yn' type='hidden' value='"+p_tracer_card_yn+"'>";
							  HTMLVal += "<input name='fileCount' id='fileCount' type='hidden' value='"+fileCount+"'>";
							  HTMLVal += "<input name='doc_or_file' id='doc_or_file' type='hidden' value='"+doc_or_file+"'>";
							  HTMLVal += "<input name='isCurrentFsLocation' id='isCurrentFsLocation' type='hidden' value='"+isSiteSpefCurrentFsLocation+"'>";
							  HTMLVal += "<input name='sys_date' id='sys_date' type='hidden' value='"+current_date+"'>";
							  var i = 0 ;
							  while(i<parseInt(fileCount)) {
								  file_trans_mode = "parent.frames[2].frames[2].frames[0].document.forms[0].file_transport_mode"+i+".value";
								  file_trans_mode = eval(file_trans_mode);
								  carried_by = "parent.frames[2].frames[2].frames[0].document.forms[0].carried_by_name"+i+".value";
								  carried_by = eval(carried_by);
								  var retdate = "parent.frames[2].frames[2].frames[0].document.forms[0].retdate"+i+".value";
								  retdate = eval(retdate);								 
								 //Added for this CRF HSA-CRF-0306.1
								  var return_date = "parent.frames[2].frames[2].frames[0].document.forms[0].return_date"+i+".value";
								  return_date = eval(return_date);                                  
								  var fslocn_return_criteria = "parent.frames[2].frames[2].frames[0].document.forms[0].fslocn_return_criteria"+i+".value";
								  fslocn_return_criteria = eval(fslocn_return_criteria);
								  var dischargedatetime = "parent.frames[2].frames[2].frames[0].document.forms[0].dischargedatetime"+i+".value";
								  dischargedatetime = eval(dischargedatetime);
                                								  
								  HTMLVal += "<input name='file_transport_mode"+i+"' id='file_transport_mode"+i+"' type='hidden' value='"+file_trans_mode+"'>";
								  HTMLVal += "<input name='carried_by_name"+i+"' id='carried_by_name"+i+"' type='hidden' value='"+carried_by+"'>";
								  HTMLVal += "<input name='retdate"+i+"' id='retdate"+i+"' type='hidden' value='"+retdate+"'>";
								  HTMLVal += "<input name='return_date"+i+"' id='return_date"+i+"' type='hidden' value='"+return_date+"'>"; 
								  HTMLVal += "<input name='fslocn_return_criteria"+i+"' id='fslocn_return_criteria"+i+"' type='hidden' value='"+fslocn_return_criteria+"'>"; 
								  HTMLVal += "<input name='dischargedatetime"+i+"' id='dischargedatetime"+i+"' type='hidden' value='"+dischargedatetime+"'>";  
								  i++;
							   }
							   HTMLVal += "</form></body></html>";
							}
							
							parent.frames[2].frames[4].document.write(HTMLVal);
							parent.frames[2].frames[4].document.forms[0].submit();
						 }
					  } else {
					  parent.frames[2].frames[4].location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage('NO_FILE_SELECTED_ISSUE','FM');
					}
				} else {
				parent.frames[2].frames[4].location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage('NO_FILE_SELECTED_ISSUE','FM');
			}
		} else {
			alert(getMessage("ISSUE_TAB_SELECT","FM"));
			parent.frames[2].frames[4].location.href='../../eCommon/jsp/error.jsp?err_num=';
		}
	} else {
		parent.frames[2].frames[1].location.reload();
		parent.frames[2].frames[4].location.href='../../eCommon/jsp/error.jsp?err_num=';
	}
}//ENd of FUN
function onSuccess()
{
	frames[1].location.reload();
	frames[2].location.href='../../eCommon/html/blank.html';
	frames[3].location.href='../../eCommon/html/blank.html';
}
function reset() {
	var doc_or_file = frames[1].document.forms[0].file_doc.value;
	var prev_menu = commontoolbarFrame.document.getElementById("home").value;
	if(doc_or_file == 'D') {
		parent.frames[2].location.href = '../../eFM/jsp/FMIssueFiles.jsp?module_id=FM&function_id=FM_ISSUE_FILES&function_name=Issue%20Document&function_type=F&access=NYNNN';
	} else {
		parent.frames[2].location.href = '../../eFM/jsp/FMIssueFiles.jsp?module_id=FM&function_id=FM_ISSUE_FILES&function_name=Issue%20File&function_type=F&access=NYNNN&prev_menu='+prev_menu;
	}
}
function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

async function callPatDetails(Patient_ID) {
	var dialogHeight	= "670px" ;
	var dialogWidth		= "1200px" ;
	var dialogTop		= "72" ;
	var dialogLeft		= "55" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	retVal				= await window.showModalDialog( "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Patient_ID), arguments, features );
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
function checkval(count) {
	parent.frames[0].document.forms[0].Issue_user_id.value = parent.parent.frames[1].document.forms[0].username.value;
	p_rec_count=0;

	if(count > 0) {
		for(i = 1;i <= count;i++) {
			if(eval("parent.frames[0].document.forms[0].chk"+i+".disabled") == false) {
				bool = eval("parent.frames[0].document.forms[0].chk"+i+".checked");
				if(bool == true) {
					eval("parent.frames[0].document.getElementById('chbox" + i + "').className='SELECT';");
					eval("parent.frames[0].document.getElementById('chk" + i + "').disabled=true;");
					//eval("parent.frames[0].document.getElementById("chbox")"+i+".className='SELECT'"); 
					//eval("parent.frames[0].document.getElementById("chk")"+i+".disabled=true"); 
					p_rec_count++;
				}
			}
		}
		if(p_rec_count>0) {
			parent.frames[0].document.IssueOutstandingDetail.submit();
		  	return true;
		}
	} else {
		parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+ getMessage('NO_FILE_SELECTED_ISSUE','FM');
		return false;
	}
}//End of Function

function Add() {
	var Obj = ManualEntry_form
	var strLocn = document.forms[0].strLocn.value;
	var Curr_file_status=parent.frames[2].document.forms[0].Curr_file_status.value;
	var filestat=parent.frames[2].document.forms[0].filestat.value;
	if(filestat==undefined || filestat==null) filestat="";
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
	
	/*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
	if(parent.frames[2].document.forms[0].reason.style.visibility=="visible"){	
	Obj.Borrowing_Reason.value=parent.frames[2].document.forms[0].reason.value;
	}else{
	Obj.Borrowing_Reason.value="";}
	 /* end ML-MMOH-CRF-0393-IN057159  */
	Obj.patientid.disabled = false;
	var fields = new Array ( Obj.username, Obj.locations, Obj.patientid, Obj.volume_no);
	var names = new Array (getLabel("Common.name.label","common"), getLabel("eFM.FSLocation.label","FM"), getLabel("Common.patientId.label","common"), getLabel("eFM.VolumeNo.label","FM"));
	/*Below line(s) modified by venkatesh.S existing bug */
	if(document.forms[0].file_type_appl_yn.value == "N" && Obj.fileno) {
		Obj.fileno.disabled = false;
 		fields[fields.length] = Obj.fileno;
 		names[names.length] = getLabel("Common.fileno.label","common");
	} else if (document.forms[0].file_type_appl_yn.value == "Y") {
		if(Obj.file_type)
		{
		Obj.file_type.disabled = false;
 		}
		fields[fields.length] = Obj.patient_file_type;
 		names[names.length] = getLabel("Common.filetype.label","common"); 
	}
	
	if(document.ManualEntry_form.reason.style.visibility=='visible' && document.ManualEntry_form.reason.value ==""){
	    
	    fields[fields.length] = Obj.reason;
 		names[names.length] = getLabel("Common.remarks.label","common");
	}
	if(parent.frames[2].checkFields( fields, names, parent.messageFrame)) {
		
		if(Obj.Curr_locn_code.value != strLocn || (Curr_file_status=="T" || Curr_file_status=="E" || Curr_file_status=="O" || Curr_file_status=="R")) {
			var errors="";
			
			if(Obj.Curr_locn_code.value != strLocn && (filestat!="" || Curr_file_status=="requested"))
			{
			errors = getMessage('FILE_IS_NOT_AT_ISS_LOCN','FM');
			}else if(Curr_file_status=="T" || Curr_file_status=="E" )
			{
               errors= getMessage('FILE_STATUS_TRANSIT','FM');
			}else if(Curr_file_status=="O" || Curr_file_status=="R")
			{
            errors= getMessage('FILE_ALREADY_EXIST','FM');
			}
			
			if(errors!="")alert(errors);			
					
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
			ManualEntry_form.patientid.onblur(); 
			ManualEntry_form.currfilelocn.value = "";
			ManualEntry_form.filestat.value = "";
			ManualEntry_form.remarks.value = "";
			parent.frames[2].document.getElementById("patline").innerText ="";

			if(document.forms[0].file_type_appl_yn.value == "N") {
				var patient_id_max_length	= Math.abs(ManualEntry_form.patient_id_max_length.value); 
				var file_no_function		= ManualEntry_form.file_no_function.value; 
			}
		} else {
			parent.frames[2].document.ManualEntry_form.submit();
			
			if (document.forms[0].file_type_appl_yn.value == "N") {
				var patient_id_max_length	= Math.abs(ManualEntry_form.patient_id_max_length.value); 
				var file_no_function		= ManualEntry_form.file_no_function.value; 
				if (parent.frames[2].document.getElementById("fileno") != null) {
					parent.frames[2].document.getElementById("fileno").innerHTML="<input type='text' name='fileno' id='fileno'  value='' onBlur='ChangeUpperCase(this);getPatIDVolume(this.value);"+file_no_function+"' onChange='ChkReqLocnValLoc(this.value);' maxlength='"+patient_id_max_length+"' size = '"+(patient_id_max_length+2)+"' >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
				}
			}
			var selectBox = parent.frames[2].document.ManualEntry_form.volume_no;
			var length = Math.abs(selectBox.length);
			for (i=0;i<length;i++)
				selectBox.remove(0);
			var option = parent.frames[2].document.createElement("OPTION");
			option.text		= "---"+getLabel("Common.defaultSelect.label","common")+"---";
			option.value	 = "";
			selectBox.add(option);
			parent.frames[2].document.ManualEntry_form.volume_no.value = "";
			parent.frames[2].document.getElementById("patline").innerText ="";
		}
	}
}
function Cls() { 	
	document.location.reload();
}

function displayDetails(val) {
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMIssueFileManualDisplay.jsp?FileNo="+val+" \"> </form></body></html>";
		parent.frames[4].document.write(HTMLVal);
		parent.frames[4].document.forms[0].submit();
}
async function showOtherRecs() {
	var retVal;
	var dialogHeight ='12' ;
	var dialogWidth = '48' ;
	var dialogTop = '355' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no';
	var arguments;
	var patid = ManualEntry_form.patientid.value;
	var selLocn = ManualEntry_form.Req_locn_code.value;

	retVal =await window.showModalDialog("../../eFM/jsp/FMIssueFileManualOtherRecsMain.jsp?PatientId="+patid+"&selLocn="+selLocn,arguments,features);
}
function showFiles() {
	//parent.parent.frames[2].IssueFileFrameSet.rows='6%,4%,*,0%,9%';
	parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
	parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
	parent.parent.frames[2].document.getElementById("issue_tab").style.height = '77vh';
	parent.parent.frames[2].document.getElementById("issue_detail").style.height = '0';
	parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh';
	parent.frames[2].document.getElementById("detaillfields").style.visibility = 'visible';
	//parent.frames[3].location.href = "../../eFM/jsp/FMIssueFileManualReqFile.jsp";
	parent.frames[2].document.getElementById("patientid").focus();
}
async function searchUser(target1,facility_id) {
	var target			= document.forms[0].username1;
	
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	//sql = "Select APPL_USER_ID code, APPL_USER_NAME description from SM_FACILITY_FOR_USER_VW where upper(facility_id) like upper(?) and upper(APPL_USER_ID) like upper(?) and upper(APPL_USER_NAME) like upper(?)"

	//sql= "select a.appl_user_id code, b.appl_user_name description from SM_FACILITY_FOR_USER a, sm_appl_user_lang b where a.appl_user_id = b.appl_user_id and language_id = '"+localeName+"' and a.facility_id = '"+facility_id+"' and upper(a.APPL_USER_ID) like upper(?) and upper(b.APPL_USER_NAME) like upper(?)";

	 tit=getLabel("eFM.AccountablePerson.label","FM");
	 //Below code was modified by N Munisekhar on 23-Jan-2013 against SKR-SCF-0761 [IN:037419] 
	sql= "  select distinct   a.appl_user_id code, b.appl_user_name description from SM_FACILITY_FOR_USER a, sm_appl_user_lang_vw b ,fm_user_access_rights c where a.appl_user_id = b.appl_user_id and language_id = '"+localeName+"' and a.facility_id = '"+facility_id+"' and a.appl_user_id = c.appl_user_id and a.facility_id = c.facility_id and (c.fs_locn_code = '*ALL' or c.manual_request_yn = 'Y')   and upper(b.appl_user_id) like upper(?) and  upper(b.APPL_USER_NAME) like upper(?) and b.EFF_STATUS='E' ";
   // end of SKR-SCF-0761 [IN:037419] 
	/*
	dataNameArray[0]	= "facility_id" ;
	dataValueArray[0]	= facility_id;
	dataTypeArray[0]	= STRING ;
	*/
/*	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC; */
  
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] =  DESC_LINK;
	argumentArray[7] = DESC_CODE ;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	
	//retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ) {
		var ret1	=	unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].username.value	=	arr[0];
		document.forms[0].username1.value	=	arr[1];
		populateLocations(arr[0]);
	} else {
		document.forms[0].username.value	=	"";
		document.forms[0].username1.value	=	"";
		Cls();
	}
} // End of getUser().



async function searchCode(target,facilityid)
	{
			var retVal =    new String();
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit="";		
			
				tit=getLabel("Common.user.label","common");
			//	sql="select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facilityid+"` ";
			//sql="select appl_user_id code, appl_user_name description from SM_FACILITY_FOR_USER_VW where facility_id='"+facilityid+"' and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by 2";

			sql="select a.appl_user_id code, a.appl_user_name description from sm_appl_user a, SM_FACILITY_FOR_USER b where b.facility_id='"+facilityid+"' and a.appl_user_id=b.appl_user_id and a.eff_status='E' and upper(a.appl_user_id) like upper(?) and upper(a.appl_user_name) like upper(?) order by 2";

			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = DESC_LINK  ;
			argumentArray[7] = DESC_CODE ;

			retVal = await CommonLookup( tit, argumentArray );

				
		var arr=new Array();

		if(retVal != null && retVal != "" ) 
		{

			var retVal=unescape(retVal);
		    arr=retVal.split(",");

		    document.forms[0].user1.value=arr[1];
			document.forms[0].user.value=arr[0];

		}
		else
		{			
			document.forms[0].user1.value="";
			document.forms[0].user.value="";
		}
	}








function enableFiles(objValue) {
	if (objValue != ""){
	          if(document.ManualEntry_form.reason.style.visibility=='visible' && document.ManualEntry_form.reason.value ==""){ 
			 
			  ManualEntry_form.files.disabled	= true;	
			  }else if(document.ManualEntry_form.reason.style.visibility=='visible' && document.ManualEntry_form.reason.value !=""&& document.getElementById("id1").innerHTML =="Requesting" ){ 
			
			   ManualEntry_form.files.disabled	= false;	
			  }else if(document.ManualEntry_form.reason.style.visibility=='visible' && document.ManualEntry_form.reason.value !=""&& document.getElementById("id1").innerHTML !="Requesting" && document.ManualEntry_form.returning_desc.value =="" ){ 
			
			   ManualEntry_form.files.disabled	= true;	
			  }
			  else
		ManualEntry_form.files.disabled	= false;		
	}else{
		ManualEntry_form.files.disabled = true;
		parent.frames[2].document.getElementById("detaillfields").style.visibility = 'hidden'; //Added by S.Sathish for IN021032 on Thursday, April 29, 2010
	}
}
////////**************** JS files of FMIssueFileOutstandingList1.jsp ****************//////////////
//Below Function Enabled for ML-MMOH-CRF-1415
function OnSelect(locations,s_file_no,no_of_days,facid,noofrecs,resLocnIdentities,strLocn, s_file_type, s_volume_no, file_type_yn) {
	parent.frames[2].location.href = "../../eFM/jsp/FMIssueFileOutstandingHeader.jsp?Locations="+locations+"&s_file_no="+s_file_no+"&no_of_days="+no_of_days+"&facid="+facid+"&noofrecs="+noofrecs+"&resLocnIdentities="+resLocnIdentities+"&issueLocn="+strLocn+"&strLocn="+strLocn+"&s_file_type="+s_file_type+"&s_volume_no="+s_volume_no+"&file_type_yn="+file_type_yn;
	parent.frames[3].location.href = "../../eCommon/html/blank.html";
	parent.frames[4].location.href = "../../eCommon/html/blank.html";
}

////////**************** JS files of FMIssueFileModelWindow.jsp ***********************///////
var by_person = new Array();
var incr = 0;
function submitdetails() { 
	var file_transport_mode	= document.getElementById("file_transport_mode").value;
	//  below function added for 19706 date:Monday, March 01, 2010 trim added
	var carried_by_name	= trimString(document.getElementById("carried_by_name").value);
	

	if(document.getElementById("file_transport_mode").value=="") {
		return false;		
	}
	else if(!document.getElementById("carried_by_name").disabled) {
		if(carried_by_name.length==0) {
			var msg1=getMessage("CAN_NOT_BE_BLANK","common");
			msg1=msg1.replace('$',getLabel("eFM.CarriedBy.label","FM"));
			alert(msg1);
			document.forms[0].carried_by_name.value="";
			document.forms[0].carried_by_name.focus();
			return false;
		} else {
			var retVal	= file_transport_mode+'::'+carried_by_name ;
			//window.returnValue=escape(retVal);
			//window.close();
			parent.document.getElementById('dialog-body').contentWindow.returnValue =  escape(retVal);
			parent.document.getElementById("dialog_tag").close(); 
		}
	}
	else if(document.getElementById("carried_by_name").disabled) {
		var retVal	= file_transport_mode+'::'+carried_by_name ;
		//window.returnValue=escape(retVal);
		//window.close();
		parent.document.getElementById('dialog-body').contentWindow.returnValue =  escape(retVal);
		parent.document.getElementById("dialog_tag").close(); 
	}
}
function enableDisable(obj) {
	var n = obj.selectedIndex-1;
	if(n == -1) document.getElementById("okbutton").disabled=true;
	else document.getElementById("okbutton").disabled=false;

	if(by_person[n]=="N") {
		document.getElementById("carried_by_name").disabled=true;
		document.getElementById("carried_by_name").value = "";
		showIdentity('D');
	}else if(obj.selectedIndex ==0) {
		document.getElementById("carried_by_name").disabled=true;
		document.getElementById("carried_by_name").value = "";
		showIdentity('D');
	} else {
		showIdentity('H');
		document.getElementById("carried_by_name").disabled=false;
		document.getElementById("carried_by_name").value = "";
	}
}
function showIdentity(obj) {
	if(obj == "D") {
		document.getElementById("td3").style.display="none";
		document.getElementById("td2").style.display="";
		document.getElementById("td2").style.visibility="visible";		
	} else if(obj =="H") {
		 document.getElementById("td2").style.display="none";
		 document.getElementById("td3").style.display="";
		 document.getElementById("td3").style.visibility="visible";
	} else {
		 document.getElementById("td3").style.display="none";
		 document.getElementById("td2").style.display="";
		 document.getElementById("td2").style.visibility="visible";
	}
	if(document.getElementById("carried_by_name").value =='') {
		document.getElementById("carried_by_name").disabled=true;
		document.getElementById("carried_by_name").value = "";
	}		
}
function ablDisablOK() {
	if(document.forms[0].file_transport_mode.value =='') document.getElementById("okbutton").disabled=true;
	else document.getElementById("okbutton").disabled=false;
}
////////**************** JS files of FMIssueFileOutStandingButton.jsp ****************///////
function AddForIssue() {
	
	var count = parent.frames[0].document.forms[0].count.value;
	var frameRef	= parent.parent; //Condition Added By Dharma for ML-MMOH-CRF-1415
	if(parent.parent.parent.frames[2].name == 'issue_tab'){
		frameRef	= parent.parent.parent; 
	}
	//parent.frames[0].document.forms[0].Issue_user_id.value = parent.parent.frames[1].document.forms[0].username.value;
	parent.frames[0].document.forms[0].Issue_user_id.value = frameRef.frames[1].document.forms[0].username.value;
	p_rec_count=0;

	for(i = 1;i <= count;i++) {
		if(eval("parent.frames[0].document.forms[0].chk"+i+".disabled") == false) {
			bool = eval("parent.frames[0].document.forms[0].chk"+i+".checked");		
			if(bool == true) {
				//eval("parent.frames[0].document.getElementById("chbox")"+i+".className='SELECT'"); 
				eval("parent.frames[0].document.getElementById('chbox" + i + "').className='SELECT';");

				//eval("parent.frames[0].document.getElementById("chbox")"+i+".align='center'"); 
				eval("parent.frames[0].document.getElementById('chbox" + i + "').align='center';");

				//eval("parent.frames[0].document.getElementById("select")"+i+".value='Y'");
				eval("parent.frames[0].document.getElementById('select" + i + "').value='Y';");

				//eval("parent.frames[0].document.getElementById("chk")"+i+".disabled=true"); 
				eval("parent.frames[0].document.getElementById('chk" + i + "').disabled=true;");

				

				p_rec_count++;

			}
			else{
					//eval("parent.frames[0].document.getElementById("select")"+i+".value='N'");	
					eval("parent.frames[0].document.getElementById('select" + i + "').value='N';");

				 }
		}
	}
	
	if(p_rec_count>0) {
		parent.frames[0].document.IssueOutstandingDetail.target = "messageFrame";
		parent.frames[0].document.IssueOutstandingDetail.action = "../../eFM/jsp/FMIssueFilesUpdateBean.jsp";
		parent.frames[0].document.IssueOutstandingDetail.submit();
	} else {
		// Modified By Dharma for ML-MMOH-CRF-1415
		// parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+
		// getMessage('NO_FILE_SELECTED_ISSUE','FM');
		frameRef.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+ getMessage('NO_FILE_SELECTED_ISSUE','FM');
	
	}
}
////////**************** JS files of FMIssueFileOutStandingDetail.jsp ***********************///////
async function GetShowRemarks(obj,remarksvalue,remarkstype,func) {

    var comments;
	var inputArr = document.getElementsByTagName("input");
	
	var frameRef	= parent.parent; //Condition Added By Dharma for ML-MMOH-CRF-1415
	if(parent.parent.parent.frames[2].name == 'issue_tab'){
		frameRef	= parent.parent.parent; 
	}
	
	for(u=0;u<inputArr.length;u++) {
		if(inputArr[u].name == obj) {
			comments = inputArr[u].value;
		}
	}
	var retVal;
	  
	var dialogHeight	= "9.3" ;
	var dialogWidth		= "435px" ;
	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments;

   if(comments=='' || comments == "null") comments ='';

// code added for icn:19422 date:Wednesday, February 24, 2010 

   var rowIndex	=	obj.substring(7,obj.length);
  // var file_no=eval("document.getElementById("fileno")"+rowIndex).value;
  /* var file_no = eval("document.getElementById('fileno" + rowIndex + "').value;");

	//var vol_no=eval("document.getElementById("volume_no")"+rowIndex).value;
   var vol_no = eval("document.getElementById('volume_no" + rowIndex + "').value;");

	//var pat_id=eval("document.getElementById("patient")"+rowIndex).value;
   var pat_id = eval("document.getElementById('patient" + rowIndex + "').value;");*/
	var file_no = document.getElementById('fileno' + rowIndex).value;
	var vol_no = document.getElementById('volume_no' + rowIndex).value;
	var pat_id = document.getElementById('patient' + rowIndex).value;


	var pat_file_volume=pat_id+"`"+file_no+"`"+vol_no; 
	// Modified By Dharma for ML-MMOH-CRF-1415
	/*
	 * var pat_file_vol
	 * =parent.parent.frames[2].document.forms[0].pat_file_vol.value; var
	 * added_rem_rem
	 * =parent.parent.frames[2].document.forms[0].added_rem_remarks.value; var
	 * added_rem_rem_val
	 * =parent.parent.frames[2].document.forms[0].added_rem_remarks_values.value;
	 */
	 var  pat_file_vol    = frameRef.frames[2].document.forms[0].pat_file_vol.value;
	 var  added_rem_rem  = frameRef.frames[2].document.forms[0].added_rem_remarks.value;
	var added_rem_rem_val  = frameRef.frames[2].document.forms[0].added_rem_remarks_values.value;

	var patarray="";
	var patfilevol="";
	var patfilevol_item="";
	var tempobj="";
	var  patarray_val="";
	var tempobj			= "";

	if(func=="issuefile")
		{

	 if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
	   patarray =added_rem_rem.split(",");
	   patarray_val =added_rem_rem_val.split(",");
			}


			for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		  patfilevol_item=patarray_val[i];
		 if (!added_rem_remarks.has(patfilevol) && patfilevol!=undefined)
		   {	
			added_rem_remarks.set(patfilevol,patfilevol_item);
		     }
		}

		if (added_rem_remarks.has(pat_file_volume))
		{
		tempobj=added_rem_remarks.get(pat_file_volume);
		
		}
	if(tempobj==undefined || tempobj==null) tempobj="";
		}

	if(func=="issuefile")
		tempobj=tempobj;
	else
		tempobj=remarksvalue;

// encodeURIComponent added for icn:19717

 	if(comments=="")
	{
	arguments=tempobj;
	}else{
	arguments = comments;
	}	
	retVal = await window.showModalDialog('../../eFM/jsp/GetShowRemarks.jsp?RemarksValue='+encodeURIComponent(tempobj)+'&RemarksType='+remarkstype+'&func='+func,arguments,features);

	if(func=="issuefile")
	{

	if(retVal!="")
	{
		tempobj	= unescape(retVal);

		  if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
	     patarray =added_rem_rem.split(",");
		  patarray_val =added_rem_rem_val.split(",");
			}

		for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		  patfilevol_item=patarray_val[i];
		 if (!added_rem_remarks.has(patfilevol) && patfilevol!=undefined)
		   {	
			added_rem_remarks.set(patfilevol,patfilevol_item);
		    eval('document.forms[0].rem_recnum_'+rowIndex).value=patfilevol_item; 
			 }
		}

		if (!added_rem_remarks.has(pat_file_volume))
		   {	
			added_rem_remarks.set(pat_file_volume,tempobj);
		   eval('document.forms[0].rem_recnum_'+rowIndex).value=tempobj; 
		   }
	if (added_rem_remarks.has(pat_file_volume))
		   {	
		 added_rem_remarks.delete(pat_file_volume);
		 added_rem_remarks.set(pat_file_volume,tempobj);
		eval('document.forms[0].rem_recnum_'+rowIndex).value=tempobj; 		
			  }

			  var str=Array.from(added_rem_remarks.values()).toString();
			var str1=str.replace(",,",",");
			var str2=Array.from(added_rem_remarks.keys()).toString();
			var str3=str2.replace(",,",",");
			frameRef.frames[2].document.forms[0].added_rem_remarks.value=str3;
			frameRef.frames[2].document.forms[0].added_rem_remarks_values.value=str1;

			 

			
	}

	else if( retVal==undefined || retVal=="undefined"||retVal=="")
	{	
     
	  tempobj	="" ;
	     if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
	   patarray =added_rem_rem.split(",");
	   patarray_val =added_rem_rem_val.split(",");
		}
	for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		  patfilevol_item=patarray_val[i];
		 if (!added_rem_remarks.has(patfilevol))
		   {	
			added_rem_remarks.set(patfilevol,patfilevol_item);
		   eval('document.forms[0].rem_recnum_'+rowIndex).value=patfilevol_item; 
		   }
		}
	 
	 pat_file_volume=pat_file_volume;
	 if (!added_rem_remarks.has(pat_file_volume))
		   {	
			if(tempobj!=""){
			added_rem_remarks.set(pat_file_volume,tempobj);
			}
		   eval('document.forms[0].rem_recnum_'+rowIndex).value=""; 
		   }
	 if (added_rem_remarks.has(pat_file_volume))
		   {	
		 
		 added_rem_remarks.delete(pat_file_volume);
		// added_rem_remarks.set(pat_file_volume,tempobj);
		eval('document.forms[0].rem_recnum_'+rowIndex).value=""; 
		}
	 frameRef.frames[2].document.forms[0].added_rem_remarks.value=Array.from(added_rem_remarks.keys()).toString();
	 frameRef.frames[2].document.forms[0].added_rem_remarks_values.value=Array.from(added_rem_remarks.values()).toString();
	 
	 added_rem_remarks.clear();
	
		 }

	}
    else
	{
	for(u=0;u<inputArr.length;u++) {
		if(inputArr[u].name == obj) {
			inputArr[u].value = ''+retVal+'';
		}
	}
	}
}
function setVal(Obj,ind) 
	{

	var file_type="";
    var volume_no="";
   var patient_id="";
  var loops=1;
   var count;
   count=parent.frames[0].document.forms[0].count.value;
	count=parseInt(count);
    var file_type_old=eval("parent.frames[0].document.forms[0].file_type"+ind).value;
	var volume_no_old=eval("parent.frames[0].document.forms[0].volume_no"+ind).value;
   var patient_id_old=eval("parent.frames[0].document.forms[0].patient"+ind).value;
	if(Obj.checked ==true) {
		eval("parent.frames[0].document.forms[0].select"+ind+".value='Y'");
		Obj.value = "Y";
	for(loops=1;loops<=count;loops++)
	{
   file_type=eval("parent.frames[0].document.forms[0].file_type"+loops).value;
   volume_no=eval("parent.frames[0].document.forms[0].volume_no"+loops).value;
	patient_id=eval("parent.frames[0].document.forms[0].patient"+loops).value;
	if((file_type_old==file_type) && (volume_no_old==volume_no) && (patient_id_old==patient_id))
		{
     
		if(ind !=loops)
		{
		eval("parent.frames[0].document.forms[0].chk"+loops).checked=false;
		eval("parent.frames[0].document.forms[0].chk"+loops).disabled=false;
		if (eval("parent.frames[0].document.getElementById('chbox" + loops + "')"))
			{
			eval("parent.frames[0].document.getElementById('chbox" + loops + "').className='';");
			eval("parent.frames[0].document.getElementById('chbox" + loops + "').align='left';");
			}else{
          eval("parent.frames[0].document.forms[0].chk"+loops+".className=''"); 
		  eval("parent.frames[0].document.forms[0].chk"+loops+".align='left'");
     		}
		eval("parent.frames[0].document.getElementById('select" + loops + "').value='N';");
		}
		}
		}
	} else {
		eval("parent.frames[0].document.forms[0].select"+ind+".value='N'");
		Obj.value = "N";
	 for(loops=1;loops<=count;loops++)
	{
	 file_type=eval("parent.frames[0].document.forms[0].file_type"+loops).value;
   volume_no=eval("parent.frames[0].document.forms[0].volume_no"+loops).value;
	patient_id=eval("parent.frames[0].document.forms[0].patient"+loops).value;
	if((file_type_old==file_type) && (volume_no_old==volume_no) && (patient_id_old==patient_id))
	{
	eval("parent.frames[0].document.forms[0].chk"+loops).checked=false;
  
	//eval("parent.frames[0].document.forms[0].chk"+loops).disabled=false;
	}
		}
		}

	
}
////////**************** JS files of FMIssueFileOutStandingHedder.jsp ***********************///////
function OnSelection(reqon,reqno,reqfacilityid,reqfacilityname,reqfslocncode,reqfslocndesc,reqfslocnidentity,reqlocnismrlocnyn,reqby,reqbyname,narrationcode,narrationdesc,s_file_no,no_of_days,no_of_recs,resLocnIdentities,issueLocn, s_file_type, s_volume_no, file_type_yn, reqfslocnid) {  
		parent.frames[3].location.href = "../../eFM/jsp/FMIssueFileOutstandingDetail.jsp?ReqOn="+reqon+"&Reqno="+reqno+"&Reqfacilityid="+reqfacilityid+"&Reqfacilityname="+escape(reqfacilityname)+"&Reqfslocncode="+reqfslocncode+"&Reqfslocndesc="+escape(reqfslocndesc)+"&Reqfslocnidentity="+reqfslocnidentity+"&Reqlocnismrlocnyn="+reqlocnismrlocnyn+"&Reqby="+reqby+"&Reqbyname="+escape(reqbyname)+"&Narrationcode="+narrationcode+"&Narrationdesc="+escape(narrationdesc)+"&s_file_no="+s_file_no+"&NoOfdays="+no_of_days+"&NoOfRecs="+no_of_recs+"&resLocnIdentities="+escape(resLocnIdentities)+"&issueLocn="+issueLocn+"&s_file_type="+s_file_type+"&s_volume_no="+s_volume_no+"&file_type_yn="+file_type_yn+"&Reqfslocnid="+reqfslocnid;
		parent.frames[4].location.href = "../../eFM/jsp/FMIssueFileOutstandingButton.jsp?resLocnIdentities="+resLocnIdentities;
	}
////////**************** JS files of FMIssueFileSerarchCriteria.jsp ************************///////
function PopulateData(objval) {
	if(objval != '') {
		var userSecurity = parent.issue_tab.document.FileIsuueTab.userSecurity.value;
		var access_all = parent.issue_tab.document.FileIsuueTab.access_all.value;
		parent.issue_tab.document.FileIsuueTab.fs_narration.value="";
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='GetLocIdentity' id='GetLocIdentity' method='post' action='../../eFM/jsp/FMIssueFilePopFSLocn.jsp?popmode=1&locn_code="+objval+"&access_all="+access_all+"&userSecurity="+userSecurity+"'></form></body></html>" ;
		parent.messageFrame.document.write(HTMLVal) ;
		parent.messageFrame.document.GetLocIdentity.submit() ;
	}
	else {
		var len = parent.issue_tab.document.FileIsuueTab.fs_locn_name.length;
		for (var i=0; i<=len; i++) {
			parent.issue_tab.document.FileIsuueTab.fs_locn_name.remove("fs_locn_name");
		}
		var opt	= parent.issue_tab.document.createElement('OPTION');
		opt.value =	"";
		opt.text = "----- "+getLabel("Common.defaultSelect.label","common")+" -----";
		parent.issue_tab.document.FileIsuueTab.fs_locn_name.add(opt);
		parent.issue_tab.document.FileIsuueTab.fs_narration.value="";
	}
}
function PopulateIdentity(obj) {
	if (obj.value.length>0) {
		var storage_location = obj.value;
		parent.issue_tab.document.FileIsuueTab.fs_narration.value="";
		var HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><FORM name='GetLocIdentity' id='GetLocIdentity' METHOD='post' ACTION='../../eFM/jsp/FMIssueFilePopFSLocn.jsp?popmode=2&storage_location="+storage_location+"'></FORM></BODY></HTML>" ;
		parent.messageFrame.document.write(HTMLVal) ;
		parent.messageFrame.document.GetLocIdentity.submit() ;
	}
	else {
		parent.issue_tab.document.FileIsuueTab.fs_narration.value="";
	} 
//parent.issue_tab.document.FileIsuueTab.patient_id.value="";
//parent.issue_tab.document.FileIsuueTab.patient_id.onblur();
}
async function searchRequestedByUser(facility_id) {
	var target			= document.forms[0].request_by_name;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	sql = "Select APPL_USER_ID code, APPL_USER_NAME description from SM_FACILITY_FOR_USER_VW where upper(facility_id) like upper(?) and upper(APPL_USER_ID) like upper(?) and upper(APPL_USER_NAME) like upper(?)";

	tit = getLabel("eFM.AccountablePerson.label","FM");
	
	dataNameArray[0]	= "facility_id" ;
	dataValueArray[0]	= facility_id;
	dataTypeArray[0]	= STRING ;
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2, 3";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup(tit, argumentArray);
	
	if(retVal != null && retVal != "" )
	{
		var ret1	=	unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].request_by_id.value	=	arr[0];
		document.forms[0].request_by_name.value	=	arr[1];
	}
	else
	{
		document.forms[0].request_by_id.value	=	"";
		document.forms[0].request_by_name.value	=	"";
	} 
} // End of getUser().
function submitAllDetails() {
	
	/* below tab_click1 () method added by venkatesh.s on 22-April-2013 against AAKH-SCF-0046 [IN039392] */
	tab_click1('page_one_tab');
	/*end AAKH-SCF-0046 [IN039392]  */
	
	var	doc_or_file		= parent.issue_header.document.IssueFilesHeader.file_doc.value
	var	requestDate		= parent.issue_tab.document.FileIsuueTab.request_date;
	//var	sysDate			= parent.issue_tab.document.FileIsuueTab.sys_date;
	var	file_type_appl_yn	= parent.issue_header.document.IssueFilesHeader.file_type_appl_yn.value;
	var	userSecurity		= parent.issue_tab.document.FileIsuueTab.userSecurity.value;
	var	access_all		= parent.issue_tab.document.FileIsuueTab.access_all.value;
	var	volume_no		= parent.issue_tab.document.FileIsuueTab.volume_no.value;	
	var	fs_locn_name	= parent.issue_tab.document.FileIsuueTab.fs_locn_name.value;
	var	fs_narration		= parent.issue_tab.document.FileIsuueTab.fs_narration.value;
	var	request_date	= parent.issue_tab.document.FileIsuueTab.request_date.value;
	var	request_by_id	= parent.issue_tab.document.FileIsuueTab.request_by_id.value;
	var	request_by_name	= parent.issue_tab.document.FileIsuueTab.request_by_id.value;
	var	fs_locn_id		= parent.issue_tab.document.FileIsuueTab.fs_locn_id.value;
	var	resLocnIdentities		= parent.issue_tab.document.FileIsuueTab.resLocnIdentities.value;
	var	file_type_yn		= parent.issue_tab.document.FileIsuueTab.file_type_yn.value;
	var	strLocn			= parent.issue_header.document.IssueFilesHeader.issuetype.value;
	var	file_no			=	"";
	var	file_type			=	"";
    var file_no_concat="";
    /*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
    var issue_file_refresh_interval = 	parent.issue_tab.document.FileIsuueTab.issue_file_refresh_interval.value;
    var isRefreshIntervalAvailable  = 	parent.issue_tab.document.FileIsuueTab.isRefreshIntervalAvailable.value;
    var isAutoPopulateAvailable 	= 	parent.issue_tab.document.FileIsuueTab.isAutoPopulateAvailable.value;
    var ChkIncludePreviousDayRequest	= "N";
    if(parent.issue_tab.document.FileIsuueTab.ChkIncludePreviousDayRequest!=null){
    	if(parent.issue_tab.document.FileIsuueTab.ChkIncludePreviousDayRequest.checked==true){
    		ChkIncludePreviousDayRequest	="Y";
    	}
    	
    }
	/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End
	the below condition isAutoPopulateAvailable also added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014
	 */
    if(isAutoPopulateAvailable!='true'){
    
	    if (parent.issue_tab.document.FileIsuueTab.patient_id.value == '')
		{
			if (request_date=='' && fs_locn_name=='')
			{
				var msg = getMessage('EITHER_CRITERIA_REQRD','FM');
				msg = msg.replace('$',getLabel("eFM.RequestedOnDate.label","FM"));
				msg = msg.replace('#',getLabel("eFM.FSLocation.label","FM"));
				alert(msg);
				return;
			}
		}
		else
		{
			
			if(parent.issue_tab.document.FileIsuueTab.file_type)
			{
			if( file_type_appl_yn == "Y" && parent.issue_tab.document.FileIsuueTab.file_type.value=='')
			{
				var msg1=getMessage('CAN_NOT_BE_BLANK','common');
				msg1=msg1.replace('$',getLabel('Common.filetype.label','common'));
				alert(msg1);
				return;
			}
			}
		}
    }else{
    	if (parent.issue_tab.document.FileIsuueTab.patient_id.value == '')
		{
			if (request_date=='')
			{
				var msg = getMessage('CAN_NOT_BE_BLANK','common');;
				msg = msg.replace('$',getLabel("eFM.RequestedOnDate.label","FM"));
				alert(msg);
				return;
			}
		}
		else
		{
			if(parent.issue_tab.document.FileIsuueTab.file_type)
			{
			if( file_type_appl_yn == "Y" && parent.issue_tab.document.FileIsuueTab.file_type.value=='')
			{
				var msg1=getMessage('CAN_NOT_BE_BLANK','common');
				msg1=msg1.replace('$',getLabel('Common.filetype.label','common'));
				alert(msg1);
				return;
			}
			}
		}
    }


	if (parent.issue_tab.document.FileIsuueTab.patient_id.value != '')
	{
		file_no	=parent.issue_tab.document.FileIsuueTab.file_no.value;
	}
	if (file_type_appl_yn == "Y") 
	{
		file_type		= parent.issue_tab.document.FileIsuueTab.patient_file_type.value;
	}
	var concatedvalue	= file_no+'::'+fs_locn_name+'::'+fs_narration+'::'+request_date+'::'+request_by_id+'::'+fs_locn_id+'::'+file_type+'::'+volume_no;
	while(concatedvalue.indexOf("+") != -1)
		concatedvalue=concatedvalue.replace('+', " ");
	file_no_concat=parent.issue_tab.document.FileIsuueTab.file_no_concat.value;
	
	var filenumb="";
	if(parent.issue_tab.document.FileIsuueTab.file_no)
	{
	filenumb=parent.issue_tab.document.FileIsuueTab.file_no.value;
	}
	file_no_concat =file_no_concat +'|'+filenumb;
   var volumenoconcat="";
   if(parent.issue_tab.document.FileIsuueTab.volume_no_concat)
     volumenoconcat=parent.issue_tab.document.FileIsuueTab.volume_no_concat.value
   volume_no_concat=volumenoconcat;
   var volumenum="";
   if(parent.issue_tab.document.FileIsuueTab.volume_no)
  volumenum =parent.issue_tab.document.FileIsuueTab.volume_no.value;
   volume_no_concat=volume_no_concat +'|'+volumenum;



//	if(obj !=undefined)
//	{
//     file_no_concat="";
//	}
	parent.issue_tab.document.FileIsuueTab.file_no_concat.value=file_no_concat;
	parent.issue_tab.document.FileIsuueTab.volume_no_concat.value=volume_no_concat;
if (parent.issue_tab.document.FileIsuueTab.patient_id.value=="")
	{
     parent.issue_tab.document.FileIsuueTab.file_no_concat.value="";
	 parent.issue_tab.document.FileIsuueTab.volume_no_concat.value="";
	  volume_no_concat="";
	  file_no_concat="";
	  }
		// issue_file_refresh_interval isRefreshIntervalAvailable ,
		// isAutoPopulateAvailable and ChkIncludePreviousDayRequest Added For
		// MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014
	  parent.issue_detail.location.href = '../../eFM/jsp/FMIssueFileAddBean.jsp?userSecurity='+userSecurity+'&access_all='+access_all+'&resLocnIdentities='+resLocnIdentities+'&file_type_yn='+file_type_yn+'&strLocn='+strLocn+'&s_file_no='+file_no+'&s_fs_locn_code='+fs_locn_name+'&s_fs_narration='+fs_narration+'&s_request_date='+request_date+'&s_request_by_id='+request_by_id+'&s_fs_locn_identity='+fs_locn_id+'&s_file_type='+file_type+'&file_no_concat='+file_no_concat+'&volume_no_concat='+volume_no_concat+'&s_volume_no='+volume_no+'&issue_file_refresh_interval='+issue_file_refresh_interval+'&isRefreshIntervalAvailable='+isRefreshIntervalAvailable+'&isAutoPopulateAvailable='+isRefreshIntervalAvailable+'&ChkIncludePreviousDayRequest='+ChkIncludePreviousDayRequest+''; 
/*	if(request_date != '') {
		if(ValidateReqDateTime(requestDate,sysDate) == true) {
			window.parent.parent.returnValue=escape(concatedvalue);
			window.parent.parent.close();
		}
	} else {
		window.parent.parent.returnValue = escape(concatedvalue);
		window.parent.parent.close();
	}*/
}
/*Below function added by Dharma for ML-MMOH-CRF-1415*/
function submitAllDetails1(userSecurity,access_all,resLocnIdentities,strLocn,reqon,reqno,reqfacilityid,reqfacilityname,reqfslocncode,reqfslocndesc,reqfslocnidentity,reqlocnismrlocnyn,reqby,reqbyname,narrationcode,narrationdesc,s_file_no,no_of_days,no_of_recs,resLocnIdentities,issueLocn, s_file_type, s_volume_no, file_type_yn, reqfslocnid) {
	
	var	file_type_appl_yn	= file_type_yn;
	var	userSecurity		= userSecurity;
	var	access_all		= access_all;
	var	volume_no		= s_volume_no;	
	var	fs_locn_name	= reqfslocndesc;
	var	fs_narration		= "";
	var	request_date	= "";
	var	request_by_id	= ""; 
	var	request_by_name	= "";
	var	fs_locn_id		= reqfslocncode;
	var	resLocnIdentities		= resLocnIdentities;
	var	file_type_yn		= file_type_yn;
	var	strLocn			= strLocn;
	var	file_no			=	"";
	var	file_type			=	"";
    var file_no_concat="";
    file_no	= s_file_no;
	if (file_type_appl_yn == "Y"){
		file_type		= s_file_type;
	}
	
	parent.frames[3].location.href = '../../eFM/jsp/FMIssueFileAddBean.jsp?strLocn='+strLocn+'&userSecurity='+userSecurity+'&access_all='+access_all+'&resLocnIdentities='+resLocnIdentities+'&file_type_yn='+file_type_yn+'&strLocn='+strLocn+'&s_file_no='+file_no+'&s_fs_locn_code='+fs_locn_id+'&s_fs_locn_identity='+reqfslocnidentity+'&s_file_type='+file_type+'&s_volume_no='+volume_no; 

}
function ValidateReqDateTime(request_date,sys_date) { 
	var obj = request_date;
	if(request_date.value != '') {
		if(doDateReqTimeChk(request_date)) {
			request_date	= request_date.value;
			sys_date		= sys_date.value;			
			splitDate = request_date.split("/");
			var requestDateTime = new Date(eval(splitDate[2]),eval(splitDate[1]),eval(splitDate[0]))
			splitDate = sys_date.split("/");
			var sysDateTime = new Date(eval(splitDate[2]),eval(splitDate[1]),splitDate[0])
			
			if(Date.parse(requestDateTime) > Date.parse(sysDateTime)) {				
				alert(getMessage('DATE_NOT_GRT_SYS_DATE','FM'));
				obj.value = '';
				obj.focus();
				return false;
			} else {
				return true;
			}
		}
	}
}
function doDateReqTimeChk(obj) {
	var comp = obj
	obj = obj.value
	
	var dttime = obj.split(" ");
	var dt
	var time
	var retval = true
	if(dttime.length > 1) {
		dt=dttime[0]
		time=dttime[1]
		if(!checkDt(dt)) {
			
			var msg = getMessage('FM_INVALID_DATE_TIME','FM');
			alert(msg);
			comp.value = '';
			comp.focus();
			retval= false;
		}
	}
	return retval;
}
////////**************** JS files of FMIssueFileSerarchHeader.jsp ****************///////
async function searchIssueFileHeaderUser(target,fac_id) {
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit=getLabel("Common.user.label","common");

	tit=getLabel("Common.user.label","common");
	sql="Select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+fac_id+"` ";
	search_code="APPL_USER_ID";
	search_desc= "APPL_USER_NAME";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

	var arr=new Array();

	if(!(retVal == null)) {
		var retVal=unescape(retVal);
		arr=retVal.split("::");

		document.forms[0].username1.value=arr[0];
		document.forms[0].username.value=arr[1];
	}
}

////////**************** JS files of FMIssueFilesTab.jsp ***********************///////
async function GetRemarks(recnum) {
	var dialogHeight	= "12" ;
	var dialogWidth		= "20" ;
	var dialogTop		= "185" ;
	var dialogLeft		= "250" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	retVal				=await window.showModalDialog( "../../eFM/jsp/FMIssueFileModelWindow.jsp?from=tab", arguments, features );
	
	var arr = new Array();

	if(!(retVal == null)) {
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		var cnt = parent.frames[0].document.forms[0].fileCount.value;
		var transport_mode = "";
		var carried_by_name = "";
		var k = 0;

		while(k<cnt) {
			transport_mode = "parent.frames[0].document.forms[0].file_transport_mode"+k;
			transport_mode = eval(transport_mode);
			transport_mode.value = arr[0];
			carried_by_name = "parent.frames[0].document.forms[0].carried_by_name"+k;
			carried_by_name = eval(carried_by_name);
			carried_by_name.value = arr[1];
			k++;
		}
	}
}
////////**************** End of JS files of FMIssueFileView.jsp ****************///////

async function GetIssueFileViewRemarks(recnum) {
	var dialogHeight	= "12" ;
	var dialogWidth		= "20" ;
	var dialogTop		= "185" ;
	var dialogLeft		= "250" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
		
	var transmode1 = "document.forms[0].file_transport_mode"+recnum;
	var obj1 = eval(transmode1);	
	var carriedbyname1 = "document.forms[0].carried_by_name"+recnum;
	var obj2 = eval(carriedbyname1);
	// icn:19721  component added encodeURIComponent(obj2.value)
		
	retVal =await window.showModalDialog( "../../eFM/jsp/FMIssueFileModelWindow.jsp?from=detail&file_transport_mode="+obj1.value+"&carried_by_name="+encodeURIComponent(obj2.value), arguments, features );
	var arr=new Array();
	if(!(retVal == null)) {
		var retVal=unescape(retVal);
		arr=retVal.split("::");

		var transmode = "document.forms[0].file_transport_mode"+recnum;
		var obj1 = eval(transmode);
		obj1.value = arr[0];
		var carriedbyname = "document.forms[0].carried_by_name"+recnum;
		var obj2 = eval(carriedbyname);
		obj2.value = arr[1];
	}
}
function RemoveIssueFileView(Indval) {
	var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMIssueFileRemoveRec.jsp?Indval="+Indval+" \"> </form></body></html>";
	parent.parent.frames[4].document.write(HTMLVal);
	parent.parent.frames[4].document.forms[0].submit();
}

function clearResult()
{
	//parent.frames[2].document.forms[0].reset();
	parent.frames[2].document.location.reload();
	parent.frames[3].location.href="../../eCommon/html/blank.html";
}
////////**************** End of JS files of FMIssueFileView.jsp ****************///////
function aa(v){
	var HTMLVal = new String();
	var u=v;
	var flag="visit_type";
	HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/getservice.jsp'>	<input type='hidden' name='flag' id='flag' value='"+flag+"'><input type='hidden' name='locn_code' id='locn_code' value='"+u+"'></form></BODY></HTML>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();

}

function validDateSys(from,today) { // args objects 1st is this object & second
									// is the date in dd/mm/yyyy
 if(today != "" && from.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 )
				{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);

						// if(Date.parse(todt) < Date.parse(fromdt))
						if (!isBeforeNow(fromdate,"DMY", localeName))
						{
							//var msg ="APP-FM0041 Date Entered should be lesser than System Date"
							var msg =getMessage("DATE_NOT_GRT_SYS_DATE","FM");
				
					alert(msg)
					//		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.value = "";
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							// messageFrame.location.href='../../eCommon/jsp/error.jsp?'
							// ;
							return true;
						}
				}
			return true;
	 }
	 return true;
}

function checkMaxLimit1(obj, maxSize, keycode) {

		
			if (keycode == 96 || keycode == 126 ||  keycode == 39 ||
				keycode == 34 || obj.value.length >= maxSize) return false;
			else return true;
		}
		
/*Below line added for this CRF HSA-CRF-0306.1*/

function holiday(facility_id,fileno,volume_no,Patient_Id,strLocn,retdatenum)
{               
	var retdate= "document.forms[0].retdate"+retdatenum;
	var obj1 = eval(retdate); 
    var localeName=document.forms[0].localeName.value;	 
	//parent.frames[2].frames[2].frames[0].document.forms[0].return_date"
	var returndate =obj1.value ;
	
	var strDate1;
	if(returndate.length>0 && returndate.length==16)
	{
	   returndate=returndate.substring(0,10);
	   strDate1=convertDate(returndate,"DMY",localeName,"en");
			
			   var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlStr ="<root><SEARCH steps='Holiday_Date_Check' facility_id=\""+facility_id+"\" fileno=\""+fileno+"\" volume_no=\""+volume_no+"\" Patient_Id=\""+Patient_Id+"\" strLocn=\""+strLocn+"\" retdate=\""+strDate1+"\" /></root>";
				
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","FMConfirmPullingListConfirmAll.jsp",false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);  	
				eval(responseText); 
               				
				if(flag=="1")	
				{
						var error = getMessage('DATE_ALREADY_HOLIDAY','FM');
                        var str1="''";						
					    var strDate2=str1.concat(strDate1).concat(str1); 
                        error = error.replace('#',strDate2);					   
						alert(error);
						eval("document.forms[0].retdate"+retdatenum).value="";
						eval("document.forms[0].retdate"+retdatenum).focus();
					
					//tosubmit=false;
				}//else
				//{
				//tosubmit=true;
				//}
	
          }
}		
//End HSA-CRF-0306.1	
/*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
function enableReason(obj){

if (obj.options[obj.selectedIndex].text.toLowerCase()=='others')
  {
   document.getElementById("remark_visible").style.visibility='visible'
   document.ManualEntry_form.reason.style.visibility='visible'
   document.ManualEntry_form.mandatory.style.visibility='visible'
    ManualEntry_form.files.disabled				= true;
     document.ManualEntry_form.reason.value=""
  }else{
    document.getElementById("remark_visible").style.visibility='hidden' 
	document.ManualEntry_form.reason.style.visibility='hidden'
    document.ManualEntry_form.mandatory.style.visibility='hidden'
	if(document.getElementById("id1").innerHTML =="Requesting")
	ManualEntry_form.files.disabled				= false;
  }
}	

function checkMaxLen(obj){ 
   
   
   
    if(obj && obj.value=="" && document.ManualEntry_form.returning_desc.value=="" )
   {
  
   document.forms[0].files.disabled=true;
   } else if (obj && obj.value=="" &&  document.ManualEntry_form.returning_desc.value !="" ){  
     
	document.forms[0].files.disabled=true;
   }else if(obj && obj.value!="" &&  document.ManualEntry_form.returning_desc.value =="" ){
   
    document.forms[0].files.disabled=true;
  }
   else {
   
   document.forms[0].files.disabled=false;
   }
    if (obj.value.length>100){
      var error = getMessage("REMARKS_CANNOT_EXCEED",'Common'); 
      error = error.replace("$",getLabel("Common.remarks.label","Common"));
      error = error.replace("#","100");
      alert(error)
      obj.value="";
	    obj.focus(); 
		}
	}
	
function checkValidCharacter(obj, maxSize, keycode) {
             
			if (keycode == 96 || keycode == 126 ||  keycode == 39 ||
				keycode == 34 || obj.value.length >= maxSize) return false;
			else return true;
		}
/* end ML-MMOH-CRF-0393-IN057159  */
		

