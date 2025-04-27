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
	if(called_from == "NOTES_HEADER")
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value = accession_num;
	}else{
		top.window.opener.top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value = accession_num;

		top.window.close();
	}

	

}
function enable_buttons(called_from,accession_num)
{
	if(called_from == "NOTES_HEADER"){		
		
		patient_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
		note_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;
		facility_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sel_facility_id.value;
		encounter_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		patient_class = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_class.value;
		appl_task_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.appl_task_id.value;		
		
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?note_type='+note_type+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&patient_id='+patient_id+'&patient_class='+patient_class+'&appl_task_id='+appl_task_id+'&accession_num='+accession_num+'&called_from=NOTES_HEADER';
	
	/*	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.location.reload();
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.accession_num.value = accession_num;*/
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = false;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = false;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.btnUploadFile.disabled = false;
	}else{
		top.RecClinicalNotesFileUploadToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record_sec.disabled = false;
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
		if(operation_mode.equals("Record") )
		//	out.println( error ) ;
		if(error.equals("FILE_SIZE_NOT_SUPPORTED") || error.equals("FILE_NOT_SUPPORTED"))
		{
			out.println("<script>alert(getMessage('"+error+"'))</script>");
		}
		else
			out.println("<script>alert('"+error+"')</script>");

		if ( error_value.equals( "1" ) ||  error_value.equals("true")){			
			out.println( "<script language='JavaScript'>onsuccess('"+operation_mode+"','"+accession_num+"','"+called_from+"');</script>" ) ;
			
			}
			out.println( "<script language='JavaScript'>enable_buttons('"+called_from+"','"+accession_num+"');</script>" ) ;
	}

%>
</p>
</BODY>

