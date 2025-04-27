<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCA.*,eCA.RecClinicalNotesMultiFileUploadBean.NoteDoc" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try 
	{
		request.setCharacterEncoding("UTF-8");		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		RecClinicalNotesMultiFileUploadBean fbean = (RecClinicalNotesMultiFileUploadBean) getObjectFromBean("MULTIFILEUPLOADBEAN", "eCA.RecClinicalNotesMultiFileUploadBean", session);
		String callFrom =(String) hash.get("CallFrom");
		String called_from =(String) hash.get("CALLED_FROM");
		String fileName =(String) hash.get("fileName");
		String operation_mode =(String) hash.get("operation_mode");

		if(callFrom.equals("REMOVEDOC"))
		{
			fbean.removeFile(fileName);	
			out.println("reLoadFrames('','"+called_from+"')");
		}
		else if(callFrom.equals("CHECKANDRECORD"))
		{
			if(fbean.checkForNewDoc())
			{
				if(called_from.equals(""))
				out.println("RecordNotesFileSection();");
				else if(called_from.equals("NOTES_HEADER"))
					out.println("RecordNotesFileSection1('"+operation_mode+"');");
			}
			else
			{
				//out.println("parent.window.close();");			
				out.println("alert(getMessage('RECORD_VALIDATE_ON_UPLOAD','CA'))");			
				 if(called_from.equals("NOTES_HEADER")){
					out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = false");		
					out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = false");		
					out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value=''");		
				 }
			}
		}
		else if(callFrom.equals("CLEARBEAN"))
		{
			fbean.clear();
		}
		putObjectInBean("MULTIFILEUPLOADBEAN",fbean,session);
	}catch(Exception e){
		e.printStackTrace();	
	}
%>	 
