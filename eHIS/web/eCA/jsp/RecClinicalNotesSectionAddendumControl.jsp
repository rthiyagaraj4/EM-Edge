<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?				100				?           	created
23/07/2012		IN034160		Dinesh T		Printpreview function clears the contents in the addendum editor
19/09/2012		IN033677		Dinesh T		CRF-Recording and signing the addendum with new free text editor and uncommented 												
												some part of the code
03/06/2013		IN040265		Ramesh G		Issue 1: At print preview the addendum details displayed as "Addendum Created by"  instead of "Addendum Recorded by"
												Issue 2: Addendum details  displayed twice.
03/06/2013		IN040266		Ramesh G		Issue 1: Record Clinical Notes->Search Tab->Update->System is displaying the updated text in different font in Print Preview and Print.
												Issue 2: Chart Summary->Lab Results->Note Type text data is displayed in different font.
												Issue 3: OT Surgeon Notes->System is displaying the text in different font in Print Preview and Print.
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
27/07/2018	IN068105	Raja S			27/07/2018	    Ramesh G		MMS-DM-CRF-0143
18/03/2020	IN071264	Nijitha S	    18/03/2020		Ramesh G	    GHL-CRF-0604
---------------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %><!--IN071264-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	//IN071264 Starts
	String addendum_text_temp = "";
	String auto_save_yn ="N";
	CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
	auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
	//IN071264 Ends
	
	//sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code)
%>

<html>
<head>
<%
	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function recordSectionDetails()
{
	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.target =	messageFrameReference.name;
	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action	=	'../../servlet/eCA.RecClinicalNotesServlet';
	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.method	=	'post';
	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.submit();

	/*
	parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.target =	messageFrameReference.name;
	parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.action	=	'../../servlet/eCA.NewRecClinicalNotesServlet';
	parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.method	=	'post';
	parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.submit();
	*/
}

function callMeToGetTextAreaValue()
{
	 fnEnableLinks();
	document.GetTextAreaForm.target = parent.RecClinicalNotesSecDetailsFrame.name;
	document.GetTextAreaForm.submit();
}
function fnEnableLinks(){	
		parent.frameSetIdMessage.rows='*%,0%'
		compressSectionFrames();
	}
//[IN033869] Start
function callMeToGetEditorValue(){
	document.GetEditorForm.target = parent.RecClinicalNotesSecDetailsEditorFrame.name;
	document.GetEditorForm.submit();
}
//[IN033869] End
</script>
<BODY  style="background-color:'#D8D8ED'" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
String		section_content						  = "";
String		curr_sec_hdg_code					  = "";
String		curr_child_sec_hdg_code				  = "";
String		dummyValue							  = "";
String		patient_id 							  = "";
String		note_type							  = "";
String		prev_sec_hdg_code					  = "";
String		prev_child_sec_hdg_code				  = "";
String		prev_sec_content_type	 			  = "";
String		editor_title					 	  = "";
String		accession_num						  = "";
String		operation_mode						  = "";
String		strAmMode							  = "";
String		strRecordMode						  = "";
String		curr_section_type					  = "";
String		encounter_id							  = "";
String		episode_type							  = "";
String		patient_class							  = "";
String	    strKey									  =	"";

curr_sec_hdg_code			= request.getParameter("curr_sec_hdg_code")==null?"":request.getParameter("curr_sec_hdg_code");
curr_child_sec_hdg_code		= request.getParameter("curr_child_sec_hdg_code")==null?curr_sec_hdg_code:request.getParameter("curr_child_sec_hdg_code");
prev_sec_hdg_code			= request.getParameter("prev_sec_hdg_code")==null?"":request.getParameter("prev_sec_hdg_code");
prev_child_sec_hdg_code		= request.getParameter("prev_child_sec_hdg_code")==null?prev_sec_hdg_code:request.getParameter("prev_child_sec_hdg_code");
patient_id					= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
section_content				= request.getParameter("section_content")==null?"":request.getParameter("section_content");

note_type					= request.getParameter("note_type")==null?"":request.getParameter("note_type");
editor_title				= request.getParameter("editor_title")==null?"Addendum To Note":request.getParameter("editor_title");
accession_num				= request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
operation_mode				= request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");
strAmMode					= request.getParameter("ammend_mode")==null?"":request.getParameter("ammend_mode");
strRecordMode				= request.getParameter("record_mode")==null?"":request.getParameter("record_mode");
encounter_id				= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
episode_type				= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
patient_class				= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");

try
{

		if(prev_sec_hdg_code.equals("") )  //[IN033869]
		{									//[IN033869]
			prev_sec_hdg_code		= "*AmmendNotes*";
			prev_child_sec_hdg_code = prev_sec_hdg_code;
		}		//[IN033869]//IN033677

		


		// NOTE :- Get the patient section and set it as a current section reference.
		// It is very much important when the practitioner selects more than one patient for
		// recording clinical notes. please be careful if you are going to change this jsp.

		strKey	= patient_id + "~"+encounter_id;
		strKey = strKey.trim();

		sectionBean.getPatientSection(strKey);

		if(!prev_sec_hdg_code.equals("") && !prev_sec_hdg_code.equals("*AmmendNotes*")  )
	{
			prev_sec_content_type	= sectionBean.getSectionType(prev_sec_hdg_code,prev_child_sec_hdg_code);
		
	}
		if(!curr_sec_hdg_code.equals("") && !curr_sec_hdg_code.equals("*AmmendNotes*") )
	{	curr_section_type		= sectionBean.getSectionType(curr_sec_hdg_code,curr_child_sec_hdg_code);
		
	}
		
		try
		{
			if(!section_content.equals("") )
			{				
				section_content = section_content.replace("<ADDRESS>&nbsp;</ADDRESS><BR>","<ADDRESS>&nbsp;</ADDRESS>");  //IN040265,IN040266
				section_content = section_content.replace("<P>","<ADDRESS><P>"); //IN040265,IN040266
				section_content = section_content.replace("</P>","</P></ADDRESS>"); //IN040265,IN040266
				if("".equals(strRecordMode)){	//IN040265,IN040266
					//IN071264 Starts
					sectionBean.setAddendumText(prev_sec_hdg_code,prev_child_sec_hdg_code, section_content);
					if("Y".equals(auto_save_yn)){
						 if(prev_sec_hdg_code.equals("*AmmendNotes*"))
						{
							//addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("*tempAmmendNotes*","*tempAmmendNotes*");
							sectionBean.setAddendumText("*tempAmmendNotes*","*tempAmmendNotes*", section_content);
							//sectionBean.setAddendumText("*AmmendNotes*","*AmmendNotes*", section_content);
						} 
						 else
							sectionBean.setAddendumText("temp"+prev_sec_hdg_code,"temp"+prev_child_sec_hdg_code, section_content);
						
					
					}
					
					
					//IN071264 Ends
				}else{
					if((!"".equals(curr_sec_hdg_code)) && (!"".equals(curr_child_sec_hdg_code))){
						sectionBean.setAddendumText(curr_sec_hdg_code,curr_child_sec_hdg_code, section_content);
					}else{
						sectionBean.setAddendumText(prev_sec_hdg_code,prev_child_sec_hdg_code, section_content);
					}					
				}	//IN040265,IN040266
				if(!prev_sec_hdg_code.equals("*AmmendNotes*"))
				{	
					if(prev_sec_content_type.equals("T"))
						dummyValue="<USER-TEMPLATE></USER-TEMPLATE>";
					else
						dummyValue="<ADDRESS> </ADDRESS>";

					String strExistingContent = "";
					
					strExistingContent = (String) sectionBean.getSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code);

					
					if( strExistingContent == null || strExistingContent.equals("") ){	
						sectionBean.setSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code, dummyValue);
					}
				}

						
				putObjectInBean("sectionBean",sectionBean,session);
			}
			

			if( !(curr_sec_hdg_code.equals("")) ){
				//IN071264 Starts
				//section_content = (String) sectionBean.getAddendumText(curr_sec_hdg_code,curr_child_sec_hdg_code);
				  if("Y".equals(auto_save_yn) &&  operation_mode.equals("ModifyAddendum")){
					 if(curr_sec_hdg_code.equals("*AmmendNotes*"))
						addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("*tempAmmendNotes*","*tempAmmendNotes*");
					 else
					 	addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("temp"+curr_sec_hdg_code,"temp"+curr_child_sec_hdg_code);
				 }
				 if(null!=addendum_text_temp && !"".equals(addendum_text_temp)){
					 section_content = addendum_text_temp;
				 }
				 else{
					 section_content = (String) sectionBean.getAddendumText(curr_sec_hdg_code,curr_child_sec_hdg_code);
				 }
				//IN071264 Ends
			}
			
			if(section_content == null)
				section_content = "";

			section_content			=	java.net.URLEncoder.encode(section_content,"UTF-8");
		}
		catch(Exception e)
		{
			//out.println("Exception @ NewRecClinicalNotesSectionAddendumControl.jsp "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
}
catch (Exception eMain)
{
		//out.println("Exception @ Main Addnendum Control"+eMain.toString());//COMMON-ICN-0181
		eMain.printStackTrace();
}
%>
<form name='RecClinicalNotesSecControlForm' id='RecClinicalNotesSecControlForm' method='post' >
	<table align='center' cellspacing=2 cellpadding=3 border=1 width='100%' height='100%'>
	<input type= hidden name = note_type value = '<%=note_type%>'>
	<input type= hidden name = accession_num value = '<%=accession_num%>'>
	<input type= hidden name = operation_mode value = '<%=operation_mode%>'>
	<input type= hidden name = section_content value = ''>
</form>
<form name='GetTextAreaForm' id='GetTextAreaForm' method='post' action='../../eCA/jsp/RecClinicalNotesAddendumHeader.jsp' >
	<input type='hidden' name='txtAreaValue' id='txtAreaValue' value='<%=section_content%>'>
</form>
<!-- [IN033869] Start -->
<form name='GetEditorForm' id='GetEditorForm' method='post' action='../../eCA/jsp/RecClinicalNotesAddendumEditorsFrame.jsp'>
	<input type= hidden name ='accession_num' value = '<%=accession_num%>'>
	<input type= hidden name ='curr_sec_hdg_code' value = '<%=curr_sec_hdg_code%>'><!--IN033677-->
	<input type= hidden name ='curr_child_sec_hdg_code' value = '<%=curr_child_sec_hdg_code%>'><!--IN033677-->
	<input type= hidden name = note_type value = '<%=note_type%>'><!--IN071264-->
	<input type= hidden name = patient_id value = '<%=patient_id%>'><!--IN071264-->
	<input type= hidden name = encounter_id value = '<%=encounter_id%>'><!--IN071264-->
</form>
<!-- [IN033869] End. -->
<%
try
	{
		
		if(strAmMode.equals("*AmmendNotes*"))
		{
			%>
				<script>
				//alert("ammend notes..content view..."+"<%=strAmMode%>");
				changeEditorTitle("<%=editor_title%>");
				parent.RecClinicalNotesContentViewFrame.location.href = '../../eCA/jsp/RecClinicalNotesContentView.jsp?accession_num=<%=accession_num%>&operation_mode=<%=operation_mode%>&note_type=<%=note_type%>';
				callMeToGetTextAreaValue();
				</script>
			<%
		}
		else if(strAmMode.equals("SectionAmmend"))
		{
			%>
				<script>
				//alert("section ammend ..SectionAddendumView..."+"<%=strAmMode%>");
				changeEditorTitle("<%=editor_title%>");
				parent.RecClinicalNotesContentViewFrame.location.href = "../../eCA/jsp/RecClinicalNotesSectionAddendumView.jsp?sec_hdg_code=<%=curr_sec_hdg_code%>&note_type=<%=note_type%>&sec_content_type=<%=curr_section_type%>&child_sec_hdg_code=<%=curr_child_sec_hdg_code%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>";
				callMeToGetTextAreaValue();
				</script>
			<%
		}
		else if( strAmMode.equals("sectionView") )
		{
			%>
				<script>
				parent.frameSetIdMessage.rows='*%,0%';
				//alert('curr_sec_hdg_code...'+'<%=curr_sec_hdg_code%>'+'...editor_title...'+'<%=editor_title%>'+'....note_type....'+'<%=note_type%>'+'.....accession_num....'+'<%=accession_num%>');
				parent.RecClinicalNotesContentViewFrame.location.href = '../../eCA/jsp/RecClinicalNotesSectionView.jsp?sec_hdg_code=<%=curr_sec_hdg_code%>&editor_title=<%=editor_title%>&note_type=<%=note_type%>&accession_num=<%=accession_num%>&addendum=Y&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>';
				</script>
			<%
		}
	else if(strAmMode.equals("Preview"))
	{
		%>
			<script>
				parent.frameSetIdMessage.rows='*%,0%';
//			parent.RecClinicalNotesSecDetailsFrame.location.href = '../../eCA/jsp/NewRecClinicalNotesSectionAddendumView.jsp?note_type=<%=note_type%>';
			//IN037701 Starts
			//var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;	
			var Obj =  ""
			if(undefined!= top.content && undefined!= top.content.workAreaFrame && undefined!= top.content.workAreaFrame.RecClinicalNotesFrame )
			{
				Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;	
			}	
			else
			{
				Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;	
			}
			//IN037701 Ends
			var note_title			= "";
			var med_service			= "";
			var event_date_time		= "";
			var performed_by_name	= "";

			event_date_time		= Obj.event_date_time.value;
			performed_by_name	= Obj.performing_phy_name.value;
			note_title			= Obj.event_title_desc.value;

			if(Obj.serv_disp != null)
				med_service			= Obj.serv_disp.value;
			//IN068105
			var noteCopiedYN = "";
			if(parent.RecClinicalNotesToolbarFrame!=undefined)
				noteCopiedYN=parent.RecClinicalNotesToolbarFrame.document.getElementById("noteCopiedYN").value
			//IN068105
			var url ='../../eCA/jsp/RecClinicalNotesPrintPreview.jsp?note_type=<%=note_type%>&encounter_id=<%=encounter_id%>&episode_type=<%=episode_type%>&accession_num=<%=accession_num%>&patient_class=<%=patient_class%>&patient_id=<%=patient_id%>&note_title='+encodeURIComponent(note_title)+'&med_service='+encodeURIComponent(med_service)+'&event_date_time='+event_date_time+'&performed_by_name='+encodeURIComponent(performed_by_name);
			url=url+'&noteCopiedYN='+noteCopiedYN; //IN068105
			window.open(url,'Document','height=570,width=790,top=0,left=0,resizable=yes,scrollbars=yes' ); 						
			</script>
		<%
	}
		//if (strRecordMode.equals("RecordAddendum") )    [IN033677]
		if (strRecordMode.equals("RecordAddendum") || strRecordMode.equals("SignAddendum") )   //[IN033677]
		{
			%>
				<script>recordSectionDetails()</script>
			<%
		}
		//[IN033869] Start
		if(strRecordMode.equals("") && !strAmMode.equals("Preview") && operation_mode.equals("ModifyAddendum")){//IN034160
			%>
			<script>
			callMeToGetEditorValue();
			</script>
			<%
		}
		//[IN033869] End.
	}
	catch (Exception eSub)
	{
		//out.println("Exception @ Addnencum Control"+eSub.toString());//common-icn-0181
		eSub.printStackTrace();
	}


%>
</body>
</html>

