//var  added_volumes  = new ActiveXObject("Scripting.Dictionary");
var added_volumes = new Map();

function apply() 
{
	var doc_or_file = parent.frames[2].frames[1].document.forms[0].doc_or_file.value;
	if (parent.frames[2].frames[3].document.forms[0]) 
	{
		var obj				  = parent.frames[2].frames[3].document.forms[0]
		var file_type_appl_yn = obj.file_type_appl_yn.value;		
		var p_file_no		  = "";
		var p_file_type_code  = "";
		var p_volume_no		  = "";
		var p_issue_locn	  = "";
		var p_req_select      = "";
		var p_rec_count       = 0;
		var to_proceed;
		var p_senderfacility  = "";
		var p_currlocnid  = ""; //Added for this CRF HSA-CRF-0306.1
		var p_patientid=""; //Added for this CRF HSA-CRF-0306.1
    	for(i = 1;i < obj.reccount.value;i++) 
		{
			p_req_select = eval("obj.confirmbox"+i+".checked");
			if (p_req_select==true) 
			{
				if (p_file_no.length==0)
					p_file_no = eval("obj.file"+i+".value");
				else
					p_file_no = p_file_no+"|"+eval("obj.file"+i+".value");
				if ( p_file_type_code.length==0)
					p_file_type_code = eval("obj.filetype"+i+".value");
				else
					p_file_type_code = p_file_type_code+"|"+eval("obj.filetype"+i+".value");
				if (p_volume_no.length==0)
					p_volume_no = eval("obj.volume"+i+".value");
				else
					p_volume_no = p_volume_no+"|"+eval("obj.volume"+i+".value");

				p_rec_count++;
			}
		}
		if(p_rec_count>0)
		{
 			to_proceed = true;
		}
		else
		{
			to_proceed = false;
		}	
		if(to_proceed == true)
		{	
		obj.filenos.value = p_file_no;
		obj.filetypecodes.value = p_file_type_code;
		obj.volumenos.value = p_volume_no;

		for(i = 1;i < obj.reccount.value;i++) {
			p_req_select = eval("obj.confirmbox"+i+".checked");
			if (p_req_select==true) {
				if (p_issue_locn.length==0)
				{
					p_issue_locn = eval("obj.issuelocn"+i+".value");
					
				}
				else
				{
					p_issue_locn = p_issue_locn+"|"+eval("obj.issuelocn"+i+".value");
				}
			}
		}
		obj.issue_locns.value = p_issue_locn;


		for(i = 1;i < obj.reccount.value;i++) {
			p_req_select = eval("obj.confirmbox"+i+".checked");
			if (p_req_select==true) {
				if (p_senderfacility.length==0)
				{
					p_senderfacility = eval("obj.senderfacility"+i+".value");
				}
				else
				{
					p_senderfacility =  p_senderfacility+"|"+eval("obj.senderfacility"+i+".value");
				}
			}
		}


		obj.senderfacility.value = p_senderfacility;
		/*Below line added for this CRF HSA-CRF-0306.1*/
		for(i = 1;i < obj.reccount.value;i++) {
			p_req_select = eval("obj.confirmbox"+i+".checked");
			if (p_req_select==true) {
				if (p_currlocnid.length==0)
				{
					p_currlocnid = eval("obj.fs_curr_locn_id"+i+".value");
				}
				else
				{
					p_currlocnid =  p_currlocnid+"|"+eval("obj.fs_curr_locn_id"+i+".value");
				}
			}
		}
		obj.fs_curr_locn_id.value = p_currlocnid;
		
		
		for(i = 1;i < obj.reccount.value;i++) {
			p_req_select = eval("obj.confirmbox"+i+".checked");
			if (p_req_select==true) {
				if (p_patientid.length==0)
				{
					p_patientid = eval("obj.patientid"+i+".value");
				}
				else
				{
					p_patientid =  p_patientid+"|"+eval("obj.patientid"+i+".value");
				}
			}
		}
		obj.patientid.value = p_patientid;
			
		
		//End HSa-CRF-0306.1
		
		obj.rec_locn_code.value = parent.frames[2].frames[1].document.forms[0].hdrec_locn_code.value;
		obj.rec_locn_iden.value = parent.frames[2].frames[3].document.forms[0].rec_locn_iden.value;
	  	var fields = new Array ( parent.frames[2].frames[1].document.forms[0].username  );
		var names = new Array ( getLabel("eFM.ReceiverName.label","FM") );
		if(parent.frames[2].frames[1].checkFields( fields, names, parent.frames[1].messageFrame)) 
		{
			obj.rec_user_id.value = parent.frames[2].frames[1].document.forms[0].username.value;
			if (p_issue_locn.length>0) 
			{
				obj.submit();
			}
			else 
			{
				parent.frames[2].frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num=";
			}
		}
	}
	else if(to_proceed == false)
		{
			if(doc_or_file =='D')
			{
			var	messag = getMessage("NO_DOC_FOR_CONFIRM","FM");
			}
			else
			{
			var	messag = getMessage("NO_RECORD_FOR_CONFIRM","FM");
			}
			parent.frames[2].frames[4].location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
		}
	}
	else 
	{
		if(doc_or_file =='D')
			{
			var	messag = getMessage("NO_DOC_FOR_CONFIRM","FM");
			}
			else
			{
			var	messag = getMessage("NO_RECORD_FOR_CONFIRM","FM");
			}
			parent.frames[2].frames[4].location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
	}
}

function AddFiles(val) 
{
	var fields         = "";
	var names          = "";
	var file_no        = "";
	var file_type_code = "";
	var rec_locn_code="";
	var volume_no            = parent.frames[2].document.forms[0].volume_no.value;
	if(val=='1')
	{
	volume_no="1";
	}
	var file_type_appl_yn    = parent.frames[2].document.forms[0].file_type_appl_yn.value;
	var maintain_doc_or_file = parent.frames[2].document.forms[0].maintain_doc_or_file.value; 
	var p_stored_val=parent.frames[2].document.forms[0].p_stored_val.value;
	if(parent.frames[2].document.forms[0].file_no)
	file_no = parent.frames[2].document.forms[0].file_no.value;
	if(file_no !="")
	{
		if(volume_no=="")
		{
		volume_no="1";
		}
	}	
	var LocnVal =parent.frames[1].document.forms[0].fslocation.value;
	var doc_or_num = '';

	        parent.frames[2].document.forms[0].show.disabled=true;
			parent.frames[2].document.forms[0].add.disabled=true;
			parent.frames[2].document.forms[0].clear.disabled=true;
	if(maintain_doc_or_file == 'D')
	{
		doc_or_num		  = parent.frames[1].document.forms[0].doc_or_file.value;	
		doc_folder_id	  = parent.frames[2].document.forms[0].doc_folder_id.value; 
		doc_type_id		  = parent.frames[2].document.forms[0].doc_type_id.value; 
	}
	else if(maintain_doc_or_file == 'F')
	{
		var patient_id   = parent.frames[2].document.forms[0].patient_id.value;
		patientlistval =  parent.frames[2].document.forms[0].patientlistvals.value;
	if(patient_id=="")
		{
          

		}else
		{
          p_stored_val=p_stored_val+"/"+patient_id+"`"+file_no+"`"+volume_no;
		 }
		
		if(p_stored_val=="")
		{
        parent.frames[2].document.forms[0].p_stored_val.value = "";
		}else{
     parent.frames[2].document.forms[0].p_stored_val.value =p_stored_val;
		}
		
		if(patientlistval == "")
		{
		 parent.frames[2].document.forms[0].patientlistvals.value = "'"+patient_id+"'";
		}
		else
		{
			patientlistval += ",'"+patient_id+"'";
			parent.frames[2].document.forms[0].patientlistvals.value = patientlistval;
		}
		if (file_type_appl_yn == 'Y')
			file_type_code = parent.frames[2].document.forms[0].patient_file_type.value; 
	}
	if(LocnVal != "")
	{
		var recLocnArr = LocnVal.split("!");
		var LocnCode = recLocnArr[0];
		//var LocnIden = rec_locn_code;
		var LocnIden =recLocnArr[1];
		var flag='N';

		
		parent.frames[1].document.forms[0].hdrec_locn_code.value = LocnCode;
		
		parent.frames[1].document.forms[0].hdrec_locn_iden.value = LocnIden;
		if(doc_or_num == 'D')
		{
				fields = new Array(parent.frames[2].document.forms[0].doc_folder_id, parent.frames[2].document.forms[0].doc_type_id);
				names = new Array(getLabel("eFM.DocumentFolder.label","FM"), getLabel("Common.documenttype.label","common"));
		}
		else 
		{
			if(file_type_appl_yn == 'N')
			{
			
			if(parent.frames[2].document.forms[0].file_no)
				{
				fields = new Array(parent.frames[2].document.forms[0].patient_id, parent.frames[2].document.forms[0].file_no);
				}else{
				fields = new Array(parent.frames[2].document.forms[0].patient_id);
				}
				names = new Array(getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"));
			}
			else if(file_type_appl_yn == 'Y')
			{
			
			fields = new Array(parent.frames[2].document.forms[0].patient_id,parent.frames[2].document.forms[0].file_type_code);
			names = new Array(getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"));
			}	
		}
		
	var remove_volume =parent.frames[2].document.forms[0].remove_volume.value;
	if(remove_volume == "ALL")
		added_volumes.removeAll();
	//var volume_value = "";
	if(volume_no != "") 
	{
	    var volume_value = "'"+volume_no+"'";
		if(!added_volumes.has(volume_value))
		{
		added_volumes.set(volume_value, volume_value);
		document.forms[0].remove_volume.value="";
		}
		if((remove_volume != "") && ((remove_volume!="ALL"))) 
		{
			volume_value = "'"+remove_volume+"'";
			if (added_volumes.has(volume_value))
				added_volumes.remove(volume_value);
		}
		//volume_value = ((added_volumes.Keys()).toArray()).toString();
		volume_value = Array.from(added_volumes.keys()).toString();

			}
		
		
		
		if(checkFields( fields,names,parent.messageFrame)) 
		{
			if(doc_or_num == 'D')
			{
			parent.frames[3].location.href = "../../eFM/jsp/DTConfirmReceiptFilesDetail.jsp?file_type_appl_yn="+file_type_appl_yn+"&FSLocation="+LocnCode+"&fileno="+file_no+"&volumeno="+volume_no+"&clearflag="+flag+"&doc_folder_id="+doc_folder_id+"&doc_type_id="+doc_type_id;
			}
			else
			{
				if (file_type_appl_yn == 'N')
				{
				parent.frames[3].location.href = "../../eFM/jsp/FMConfirmReceiptFilesDetail.jsp?file_type_appl_yn="+file_type_appl_yn+"&FSLocation="+LocnCode+"&fileno="+file_no+"&patient_id="+parent.frames[2].document.forms[0].patientlistvals.value+"&volumeno="+volume_value+"&clearflag="+flag+"&hdrec_locn_iden="+LocnIden+"&p_stored_val="+p_stored_val;
					}
				else if (file_type_appl_yn == 'Y')
				 {
				   	parent.frames[3].location.href = "../../eFM/jsp/FMConfirmReceiptFilesDetail.jsp?file_type_appl_yn="+file_type_appl_yn+"&FSLocation="+LocnCode+"&file_type_code="+file_type_code+"&patient_id="+parent.frames[2].document.forms[0].patientlistvals.value+"&volumeno="+volume_value+"&clearflag="+flag+"&hdrec_locn_iden="+LocnIden+"&p_stored_val="+p_stored_val;
				}
			}
		}else{
	             parent.frames[2].document.forms[0].show.disabled=false;
			     parent.frames[2].document.forms[0].add.disabled=false;
			     parent.frames[2].document.forms[0].clear.disabled=false;
		}
	}
}
function selectVals() 
{
	
	var obj = parent.frames[1].document.forms[0]
	var LocnVal = obj.fslocation.value;
	var file_type_appl_yn = parent.frames[2].document.forms[0].file_type_appl_yn.value;
	var doc_or_num		  = parent.frames[1].document.forms[0].doc_or_file.value;	
	
	if(LocnVal != "") 
	{
	    var recLocnArr = LocnVal.split("!");
		var LocnCode = recLocnArr[0];
		var LocnIden = recLocnArr[1];
		if(doc_or_num == 'D')
		{
			parent.frames[3].location.href = "../../eFM/jsp/DTConfirmReceiptFilesDetail.jsp?file_type_appl_yn="+file_type_appl_yn+"&FSLocation="+LocnCode;
			parent.frames[1].document.forms[0].hdrec_locn_code.value = LocnCode;
			parent.frames[1].document.forms[0].hdrec_locn_iden.value = LocnIden;
			var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMConfirmFileRemoveObject.jsp \"> </form></body></html>";

			parent.frames[4].document.write(HTMLVal);
			parent.frames[4].document.forms[0].submit();
		}
		else if(doc_or_num == 'F')
		{
			

			parent.frames[3].location.href = "../../eFM/jsp/FMConfirmReceiptFilesDetail.jsp?file_type_appl_yn="+file_type_appl_yn+"&FSLocation="+LocnCode+"&hdrec_locn_iden="+LocnIden;
			parent.frames[1].document.forms[0].hdrec_locn_code.value = LocnCode;
			parent.frames[1].document.forms[0].hdrec_locn_iden.value = LocnIden;
			var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMConfirmFileRemoveObject.jsp \"> </form></body></html>";

			parent.frames[4].document.write(HTMLVal);
			parent.frames[2].document.forms[0].show.disabled=true
			parent.frames[2].document.forms[0].add.disabled=true
			parent.frames[2].document.forms[0].clear.disabled=true
			parent.frames[4].document.forms[0].submit();
		}
	}
	else 
	{
		parent.frames[2].document.forms[0].show.disabled=false;
			parent.frames[2].document.forms[0].add.disabled=false;
			parent.frames[2].document.forms[0].clear.disabled=false;
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
	}
}
function selectValues()
{
	var obj = parent.frames[1].document.forms[0]
	if(obj.fslocation.value == "") 
	{
		var error = getMessage('REC_FS_LOCN_BLANK','FM');
		parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
	}
	else 
	{
		parent.frames[3].location.href = "../../eFM/jsp/FMConfirmReceiptFilesDetail.jsp?FSLocation="+parent.frames[1].frames[1].document.forms[0].hdrec_locn_code.value;
	}
}
function searchUser(target,fac_id) 
{
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
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

		var arr=new Array();

		if (!(retVal == null))
		{

			var retVal=unescape(retVal);
		    arr=retVal.split("::");

		    document.forms[0].username1.value=arr[0];
			document.forms[0].username.value=arr[1];
		}
}
function clearValues()
{
	parent.frames[2].location.reload();
	parent.frames[3].location.href = "../../eCommon/html/blank.html";
	var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMConfirmFileRemoveObject.jsp \"> </form></body></html>";
	parent.frames[4].document.write(HTMLVal);
	parent.frames[4].document.forms[0].submit();
	parent.parent.frames[2].frames[4].location.href="../../eCommon/jsp/error.jsp?";
}
function GetShowRemarks(obj,remarksvalue,remarkstype)
{
	var comments;
	var inputArr = document.getElementsByTagName("input");
	for (u=0;u<inputArr.length;u++)
	{
		if (inputArr[u].name == obj)
		{
			comments = inputArr[u].value;
			}
	}

	var retVal;
	var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE " )
	if ( msie > 0 )     
        brow_ver_no=parseInt (ua.substring (msie+5, ua.indexOf (".", msie )));
	  
	var dialogHeight	= "9.3" ;
	var dialogWidth		= "30" ;
	if(brow_ver_no > '6'){
			dialogHeight	= "7.4" ;
			dialogWidth		= "28.5" ;
	  }
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments;

	   if(comments=='' || comments == "null")
		  comments ='';
		
	if(comments==undefined || comments=="" )
	{
	 arguments =remarksvalue ;
	 }else{
		arguments = comments ;
	 }
	retVal = window.showModalDialog('../../eFM/jsp/GetShowRemarks.jsp?RemarksValue='+encodeURIComponent(remarksvalue)+'&RemarksType='+remarkstype,arguments,features);

	if (remarkstype=='I')
	{
		for (u=0;u<inputArr.length;u++)
		{
			if (inputArr[u].name == name)
			{
				inputArr[u].value = ''+retVal+'';
			}
		}
	}
}

function confirmSelection(){}

function PopulateData(objval) 
{
	if(objval != '') 
	{
		parent.frames[2].location.href = "../../eCommon/html/blank.html";
		parent.frames[3].location.href = "../../eCommon/html/blank.html";

		var userSecurity				= document.forms[0].userSecurity.value;
		var auto_rec_ward				= document.forms[0].Auto_rec_ward.value;
		var auto_rec_clinic				= document.forms[0].Auto_rec_clinic.value;
		var auto_rec_procedure_yn		= document.forms[0].AUTO_REC_PROCEDURE_YN.value;
		var auto_rec_daycare_yn			= document.forms[0].AUTO_REC_DAYCARE_YN.value;
		var auto_rec_pract				= document.forms[0].Auto_rec_pract.value;
		var auto_rec_dept				= document.forms[0].Auto_rec_dept.value;
		var auto_rec_external			= document.forms[0].Auto_rec_external.value;
		var Dflt_archive_fs_locn_code	= document.forms[0].Dflt_archive_fs_locn_code.value;
		var Dflt_lost_fs_locn_code		= document.forms[0].Dflt_lost_fs_locn_code.value;
		var accessAll					= document.forms[0].accessAll.value;
		
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='GetLocIdentity' id='GetLocIdentity' method='post' action='../../eFM/jsp/FMConfirmReceiptPopLocation.jsp?locn_code="+objval+"&accessAll="+accessAll+"&userSecurity="+userSecurity+"&auto_rec_ward="+auto_rec_ward+"&auto_rec_clinic="+auto_rec_clinic+"&auto_rec_procedure_yn="+auto_rec_procedure_yn+"&auto_rec_daycare_yn="+auto_rec_daycare_yn+"&auto_rec_pract="+auto_rec_pract+"&auto_rec_dept="+auto_rec_dept+"&auto_rec_external="+auto_rec_external+"&Dflt_archive_fs_locn_code="+Dflt_archive_fs_locn_code+"&Dflt_lost_fs_locn_code="+Dflt_lost_fs_locn_code+"'></form></body></html>" ;
		parent.frames[4].document.write(HTMLVal) ;
		parent.frames[4].document.GetLocIdentity.submit() ;
	}
	else 
	{
		var len = parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.length;
		for (var i=0; i<=len; i++) 
		{
			parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.remove("fslocation");
		}
		var opt	= parent.frames[1].ConfirmReceiptHeader_form.document.createElement('OPTION');
		opt.value =	"";
		opt.text = "----- "+getLabel("Common.defaultSelect.label","common")+" -----"; 
		parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.add(opt);
		parent.frames[2].location.href = "../../eCommon/html/blank.html";
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
	}
}
function showcriteria(ObjVal) 
{
	var doc_or_file = '';

	if(parent.frames[1].document.forms[0].doc_or_file)
		doc_or_file		  = parent.frames[1].document.forms[0].doc_or_file.value;
	
	if(ObjVal == "")
	{
		parent.frames[2].location.href = "../../eCommon/html/blank.html";
	}
	else 
	{
		if(doc_or_file == 'D')
		{
			parent.frames[2].location.href = "../../eFM/jsp/DTConfirmRcptCriteria.jsp";
		}
		else if(doc_or_file == 'F')
		{
			parent.frames[2].location.href = "../../eFM/jsp/FMConfirmRcptCriteria.jsp";
		}
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
	}
}
function ClearData() 
{
	parent.frames[2].document.getElementById("hdr_tab0").style.visibility = 'hidden';
	parent.frames[2].document.getElementById("hdr_tab").style.visibility = 'hidden';
	parent.frames[2].document.forms[0].remove_volume.value="ALL";
	parent.frames[2].document.forms[0].patientlistvals.value="";
	parent.frames[2].document.forms[0].p_stored_val.value="";
	parent.frames[3].location.href = "../../eCommon/html/blank.html";
	var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMConfirmFileRemoveObject.jsp \"> </form></body></html>";
	parent.frames[4].document.write(HTMLVal);
	parent.frames[4].document.forms[0].submit();
	parent.parent.frames[2].frames[4].location.href="../../eCommon/jsp/error.jsp?";
}
function reset() 
{
	parent.frames[2].frames[1].document.location.reload();
	parent.frames[2].frames[2].document.location.href="../../eCommon/html/blank.html";
	parent.frames[2].frames[3].document.location.href="../../eCommon/html/blank.html";
	

	var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMConfirmFileRemoveObject.jsp \"> </form></body></html>";
	messageFrame.document.write(HTMLVal);

	messageFrame.document.forms[0].submit();
	parent.frames[2].frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num=";
}
function onSuccess()
{
	parent.frames[2].frames[1].location.reload();
	parent.frames[2].frames[2].location.href = '../../eCommon/html/blank.html';
	parent.frames[2].frames[3].location.href = '../../eCommon/html/blank.html';
}


//ragha
//these functions are added for on click events of encounter_id and patient_id in DTConfirmReceiptFilesDetail.jsp
function changeCursor(obj) 
{
	obj.style.cursor = "pointer" ;
}

function callPatDetails(Patient_ID) 
{
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

function showEncounter(enc,patid,fileno,Patient_Class)
{
	//alert(fileno);
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

