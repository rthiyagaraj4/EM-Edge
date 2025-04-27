/*function create()
{
	f_query_add_mod.location.href = '../../eAM/jsp/TransportModeAddModify.jsp?operation=insert' ;
	var msg="";
	//parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
	frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
	
}

function reset()
{

		if(f_query_add_mod.document.forms[0].name == "TransportModeForm")
			{
			if(f_query_add_mod.document.forms[0].operation.value =="insert")
				{
					f_query_add_mod.document.forms[0].reset();
				}
				else
				f_query_add_mod.document.forms[0].reset();
			}
			 else 
				 if(f_query_add_mod.document.forms[0].name == "query_form")
			{
				f_query_add_mod.document.query_form.reset() ;
			}

}

function query() 
{
	//var msg="";
//	parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
////	frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
	f_query_add_mod.location.href ="../../eAM/jsp/TransportModeQueryCriteria.jsp?operation=modify" ;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply() 
{
		var messageFrame1	=	frames[2];
if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var error_page1		=	'../../eCommon/jsp/MstCodeError.jsp';

	
	var x=f_query_add_mod.location.href;
	
	if (parseInt(x.indexOf("blank.html"))!=-1)
	{
		//parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + "";	
		parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + "";	
		return false;
	}

	var fields1			=	new Array(f_query_add_mod.document.TransportModeForm.transport_mode);
	var names1			=	new Array(getLabel("Common.TransportMode.label","Common"));
//	var messageFrame1	=	parent.frames[1].frames[2];
	
	//var error_page1		=	'../../eCommon/jsp/MstCodeError.jsp';
	

	if(SpecialCharCheck(fields1,names1,messageFrame1,"M", error_page1))
	{
		var fields = new Array ( f_query_add_mod.document.TransportModeForm.transport_mode,
				 f_query_add_mod.document.TransportModeForm.long_desc,
				 f_query_add_mod.document.TransportModeForm.short_desc);

		var names = new Array ( getLabel("Common.mode.label","Common"),
								getLabel("Common.longdescription.label","Common"),
								getLabel("Common.shortdescription.label","Common"));

	//	if (!f_query_add_mod.checkFieldsofMst( fields, names, parent.frames[1].frames[2])) 
			if (!f_query_add_mod.checkFieldsofMst( fields, names, frames[2])) 
			return false;
		else
		{
			 f_query_add_mod.document.TransportModeForm.by_person_yn.disabled=false;
	         f_query_add_mod.document.TransportModeForm.specimen_related_yn.disabled=false;
	         f_query_add_mod.document.TransportModeForm.file_related_yn.disabled=false;
	         f_query_add_mod.document.TransportModeForm.patient_related_yn.disabled=false;
	         f_query_add_mod.document.TransportModeForm.eff_status.disabled=false;
			 
			 f_query_add_mod.document.TransportModeForm.submit();
		}
	}
}

function onSuccess()
{
	//parent.frames[1].frames[1].document.location.reload();
	frames[1].document.location.reload();

}
*/
function create()
{
	f_query_add_mod.location.href = '../../eAM/jsp/TransportModeAddModify.jsp?operation=insert' ;
	var msg="";
	parent.frames[2].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
	
}

function reset()
{
		if(f_query_add_mod.document.forms[0].name == "TransportModeForm")
			{
			if(f_query_add_mod.document.forms[0].operation.value =="insert")
				{
					//f_query_add_mod.document.forms[0].reset();
					f_query_add_mod.document.location.reload();
				}
				else
			//	f_query_add_mod.document.forms[0].reset();
				f_query_add_mod.document.location.reload();
			}
			 else 
				 if(f_query_add_mod.document.forms[0].name == "query_form")
			{

				//f_query_add_mod.document.query_form.reset() ;
				f_query_add_mod.document.location.reload();
			}

}

function query() 
{
	var msg="";
	parent.frames[2].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
	f_query_add_mod.location.href ="../../eAM/jsp/TransportModeQueryCriteria.jsp?operation=modify" ;
}

function apply() 
{
	
	if(f_query_add_mod.document.TransportModeForm){	
	var x=f_query_add_mod.location.href;
	
	if (parseInt(x.indexOf("blank.html"))!=-1)
	{
		parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + "";	
		return false;
	}

	var fields1			=	new Array(f_query_add_mod.document.TransportModeForm.transport_mode);
	var names1			=	new Array(getLabel("Common.TransportMode.label","Common"));
	var messageFrame1	=	frames[2];
	//	var messageFrame1	=	parent.frames[1].frames[2];
	var error_page1		=	'../../eCommon/jsp/MstCodeError.jsp';

	if(SpecialCharCheck(fields1,names1,messageFrame1,"M", error_page1))
	{
		var fields = new Array ( f_query_add_mod.document.TransportModeForm.transport_mode,
				 f_query_add_mod.document.TransportModeForm.long_desc,
				 f_query_add_mod.document.TransportModeForm.short_desc);

		var names = new Array ( getLabel("Common.mode.label","Common"),
								getLabel("Common.longdescription.label","Common"),
								getLabel("Common.shortdescription.label","Common"));

		if (!f_query_add_mod.checkFieldsofMst( fields, names, frames[2])) 
			return false;
		else
		{
			 f_query_add_mod.document.TransportModeForm.by_person_yn.disabled=false;
	         f_query_add_mod.document.TransportModeForm.specimen_related_yn.disabled=false;
	         f_query_add_mod.document.TransportModeForm.file_related_yn.disabled=false;
	         f_query_add_mod.document.TransportModeForm.patient_related_yn.disabled=false;

			 if(f_query_add_mod.document.TransportModeForm.isCnrmReqPatOutChngAppl.value == "true")
			 {
				 f_query_add_mod.document.TransportModeForm.tfr_pat_out_yn.disabled=false;
			 }

			 //Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
			 if(f_query_add_mod.document.TransportModeForm.isMedRepModeAppl.value == "true")
			 {
				 f_query_add_mod.document.TransportModeForm.application_mode.disabled=false;
				 f_query_add_mod.document.TransportModeForm.collection_mode.disabled=false;
				 f_query_add_mod.document.TransportModeForm.notification_mode.disabled=false;
			 }
	         
			 f_query_add_mod.document.TransportModeForm.eff_status.disabled=false;
			 
			 f_query_add_mod.document.TransportModeForm.submit();
		}
	}
	}else{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	}
}

function onSuccess()
{
	f_query_add_mod.location.reload();

}

//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
function disableMedRepCheckbox()
{	
	if(document.getElementById('application_mode').checked || document.getElementById('collection_mode').checked || document.getElementById('notification_mode').checked)
	{
	document.getElementById('patient_related_yn').disabled=true;
	document.getElementById('patient_related_yn').checked = false;
	document.getElementById('file_related_yn').disabled=true;
	document.getElementById('file_related_yn').checked = false;
	document.getElementById('specimen_related_yn').disabled=true;
	document.getElementById('specimen_related_yn').checked = false;
	document.getElementById('by_person_yn').disabled=true;
	document.getElementById('by_person_yn').checked = false;
	if(document.getElementById('tfr_pat_out_yn') != null)
		{
		document.getElementById('tfr_pat_out_yn').disabled=true;
		document.getElementById('tfr_pat_out_yn').checked = false;
		}
	}else
	{
	if(document.getElementById('eff_status').checked)
	{
	document.getElementById('patient_related_yn').disabled=false;
	document.getElementById('file_related_yn').disabled=false;
	document.getElementById('specimen_related_yn').disabled=false;
	document.getElementById('by_person_yn').disabled=false;
	if(document.getElementById('tfr_pat_out_yn') != null)
		{
		document.getElementById('tfr_pat_out_yn').disabled=false;
		}
	}
	}
}

//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
function disableCheckbox()
{	
	if(document.getElementById('patient_related_yn').checked || document.getElementById('file_related_yn').checked || document.getElementById('specimen_related_yn').checked || document.getElementById('by_person_yn').checked || (document.getElementById('tfr_pat_out_yn') != null && document.getElementById('tfr_pat_out_yn').checked))
	{
	document.getElementById('application_mode').disabled=true;
	document.getElementById('application_mode').checked = false;
	document.getElementById('collection_mode').disabled=true;
	document.getElementById('collection_mode').checked = false;
	document.getElementById('notification_mode').disabled=true;
	document.getElementById('notification_mode').checked = false;
	}else
	{
	if(document.getElementById('eff_status').checked)
	{
	document.getElementById('application_mode').disabled=false;
	document.getElementById('collection_mode').disabled=false;
	document.getElementById('notification_mode').disabled=false;
	}
	}
}











