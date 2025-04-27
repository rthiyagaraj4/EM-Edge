<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<head>

<script language="JavaScript">

function onsuccess(operation_mode,accession_num,called_from)
{

/*if ( operation_mode == "SignOnModify" )
{
	alert(getCAMessage("RECORD_INSERTED"));	
	//top.opener.location.reload();
	//top.opener.parent.frames[1].location.reload();
	top.close();
}
else
{*/
	

	if(top.content!=null )
	{
		
		if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame!=null)
		{
			
			if(called_from == "NOTES_HEADER")
			{
				//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.accession_num.value = accession_num;
			/*	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value = accession_num;

				patient_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
				note_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;
				facility_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sel_facility_id.value;
				encounter_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
				patient_class = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_class.value;
				appl_task_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.appl_task_id.value;		*/
				
				//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?note_type='+note_type+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&patient_id='+patient_id+'&patient_class='+patient_class+'&appl_task_id='+appl_task_id+'&accession_num='+accession_num+'&called_from=NOTES_HEADER';

				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = false;
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = false;
			}else{
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.accession_num.value = accession_num;
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value = accession_num;

				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = false;
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = false;
			}
		}
	}
		
		if(operation_mode == "Sign")
		{
			alert(getMessage("RECORD_INSERTED","CA"));	
			if(top.content!=null)
			{
				var fn_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.function_id.value;
				
				if(fn_id=="TASK_LIST")
				{
					top.close();
					if (top.opener && !top.opener.closed)
						{
							top.opener.location.reload();
						}

				}
				else
				{
					top.content.workAreaFrame.RecClinicalNotesFrame.location.reload();
				}
			}
			else
				window.close();

		}
		else if(operation_mode == "UpdateSign"  || operation_mode == "UpdateRecord" )
		{
			var patient_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.patient_id.value;
			var encounter_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.encounter_id.value;
			var episode_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.episode_type.value;
			var function_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.function_id.value;
			var from_date_time = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.from_date_time.value;
			var to_date_time = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.to_date_time.value;
			var appl_task_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.appl_task_id.value;
			var note_group = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.note_group.value;
			var patient_class = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.patient_class.value;
			var note_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.note_type.value;
			
			var query_str = "patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&function_id="+function_id+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&appl_task_id="+appl_task_id+"&note_group="+note_group+"&note_type="+note_type;

			if(operation_mode == "UpdateRecord" )
			{
				top.content.workAreaFrame.RecClinicalNotesTabsFrame.document.forms[0].query_string.value = query_str;
			}
			else
			{
				alert(getMessage("RECORD_INSERTED","CA"));	
				top.content.workAreaFrame.location.href  = "../../eCA/jsp/RecClinicalNotes.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&function_id="+function_id+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&appl_task_id="+appl_task_id+"&patient_class="+patient_class;
			}
		}
		else if(operation_mode == "Forward" || operation_mode == "MakeAsError" || operation_mode == "Delete" || operation_mode == "SignOnModify")
		{
			
			if((operation_mode == "SignOnModify" || operation_mode == "Delete" ) && top.content==null)
			{
					window.close();

			}
			else
			{
				var query_string = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].query_string.value;
				var note_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchCriteriaFrame.document.forms[0].note_type.value
				alert(getMessage("RECORD_INSERTED","CA"));	
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.location.href  = "../../eCA/jsp/RecClinicalNotesSearchResult.jsp?"+query_string+"&note_type="+note_type;
			}
		}
//}	
	
}

function enable_buttons()
{

if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame!=null)
{

	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = false;
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = false;
}

}
</script>
</head>

<BODY CLASS="MESSAGE" onKeyDown="lockKey()">

<p align="left">
<%
	String error=request.getParameter( "err_num" );

	if ( error != null ) {
		
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");
		String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
		
		if(error.equals("FILE_SIZE_NOT_SUPPORTED") || error.equals("FILE_NOT_SUPPORTED"))
		{
			out.println("<script>alert(getMessage('"+error+"'))</script>");
		}
	else
		{
		//out.println("<script>alert('+error_value==="+error_value+"')</script>");
		if(operation_mode.equals("Record") || operation_mode.equals("UpdateRecord") || operation_mode.equals("Update") || operation_mode.equals("UpdateSign") ||  error_value.equals( "0" ) ||  error_value.equals("false"))
			out.println( error ) ;
		}
		if ( error_value.equals( "1" ) ||  error_value.equals("true")){
			out.println( "<script language='JavaScript'>onsuccess('"+operation_mode+"','"+accession_num+"','"+called_from+"');</script>" ) ;
		}

		if(!operation_mode.equals("Delete")){
				out.println( "<script language='JavaScript'>enable_buttons();</script>" ) ;
		}

	}

%>
</p>
</BODY>

