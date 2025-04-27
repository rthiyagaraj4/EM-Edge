<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
06/07/2011    101            Dinesh T    Incident No: 28014, Notes Message shouldn't appearing in the modes such as modify, update
10/05/2012	  IN032682	 	Ramesh G	 System does not display the Print Preview Button some times.
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template 
																			if filled up earlier for same patient in template format.
22/01/2018	IN063931		Prakash C		23/01/2018	Ramesh				KDAH-CRF-0431(Copy previous Section)
22/05/2018	IN067607		Raja S			22/05/2018	Ramesh G			ML-MMOH-CRF-1130.2
27/07/2018	IN068105		Raja S			27/07/2018	Ramesh G		MMS-DM-CRF-0143
07/08/2018	IN063818		Raja S			07/08/2018	Ramesh G		MMS-DM-CRF-0102 
18/03/2020  IN071264		Nijitha S	    18/03/2020	Ramesh G	    GHL-CRF-0604
19/06/2024	  62372			Twinkle Shah    19/04/2021	    ML-MMOH-CRF-2149.1

28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<title><fmt:message key="eCA.RecordClinicalNotesToolbar.label" bundle="${ca_labels}"/></title> 
<%
String auto_save_yn ="N";//IN071264
String operation_mode		=	"";//IN071264
try
{
	Connection			con		= null; //62372
	PreparedStatement	pstmt	= null; //62372
	ResultSet			rs		= null; //62372
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCA/js/prototype.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesPart3.js'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesPart4.js'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesFileUpload.js'></script>
<!-- Added by Dinesh for temp -->
<script language='javascript' src='../../eCA/js/RTEditor.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<%
	String oledb_con_string				=	"";
	String license_rights				=	"",		strLinkDocEnDis		=	"";
	String doc_linked_note_yn			=	"",		login_user_id		=	"";
	String function_id					=	"";
	String appl_task_id					=	"";
	String displayNotesView					=	"display:none";
	//IN063818 starts
	boolean isModifyDescSS = false;
	String isModifyDescYN = "N";
	String beanId					= "CAClinicalHistoryBean" ;
	String beanName				= "eCA.CAClinicalHistoryBean";
	CAClinicalHistoryBean beanObj	= (CAClinicalHistoryBean)getBeanObject( beanId, beanName , request) ;
	isModifyDescSS = beanObj.isSiteSpecific("DIS_MODIFY_AS_UPDATE");
	if(isModifyDescSS)
		isModifyDescYN ="Y";
	//IN063818 ends
	//62372  starts.
	String hide_copy_pre_rec_clnt_yn="";
	int getAccessRightsViewPractYN=0;
	String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
						if(ca_practitioner_id == null) ca_practitioner_id="";
						String facilityId = (String) session.getValue("facility_id");
getAccessRightsViewPractYN=beanObj.getAccessRightsViewCopyPreviousBtn(ca_practitioner_id, facilityId);
try{
con = ConnectionManager.getConnection(request);
pstmt= con.prepareStatement("SELECT NVL(HIDE_COPY_PRE_REC_CLNT_YN,'N') HIDE_COPY_PRE_REC_CLNT_YN FROM CA_NOTE_PARAM");
rs=pstmt.executeQuery();

if(rs.next())
{
hide_copy_pre_rec_clnt_yn  = rs.getString("HIDE_COPY_PRE_REC_CLNT_YN");	
}
if(rs != null) rs.close();
if(pstmt != null) pstmt.close();
}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
if(con != null) ConnectionManager.returnConnection(con);	
}
//62372 end
    String order_id=""; //68801
	oledb_con_string	=	(String) session.getValue("oledb_con_string");
	login_user_id		=	(String) session.getValue("login_user");

	operation_mode		=	(request.getParameter("operation_mode")==null) ? "" : request.getParameter("operation_mode");
	doc_linked_note_yn	=	(request.getParameter("doc_linked_note_yn")==null) ? "" : request.getParameter("doc_linked_note_yn");

	

	function_id			=	(request.getParameter("function_id")==null)?"":request.getParameter("function_id");
	appl_task_id			=	(request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");
	String contr_mod_accession_num = (request.getParameter("contr_mod_accession_num")==null)?"":request.getParameter("contr_mod_accession_num");  //[IN032874]
	order_id			=	(request.getParameter("order_id")==null)?"":request.getParameter("order_id"); //68801

		
	if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
		license_rights= "FULL";
	else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
		license_rights= "BASIC";
	else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
		license_rights= "MINI";
	//IN071264 Starts
	CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
	auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
	//IN071264 Ends
%>
	<center>
	<form name='RecClinicalNotesToolbarForm' id='RecClinicalNotesToolbarForm'>
	<div id ="Temp2" name ="Temp2">
		<table border='0' cellpadding='3' cellspacing='0' width='100%' height='100%'  id='general_toolbar' name='general_toolbar' id='general_toolbar'style='display:inline'>		
		<tr>	
		<!-- <td><img id='digitalNote' src='../../eCA/images/digitaEditor.gif' onClick="return getDigitalNote()" style="display:inline" title='Digital Note Image' ></td> -->
		<td class= 'button'>
		<!-- IN052940 Start.-->		
		<!--62372  start-->
		<% if(hide_copy_pre_rec_clnt_yn.equals("N") || (hide_copy_pre_rec_clnt_yn.equals("Y") && getAccessRightsViewPractYN > 0)){
		%> 
		<input type='BUTTON' class='BUTTON' name='Previous_Notes' id='Previous_Notes' id='Previous_Notes' style='display:none'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CopyFromPreviousNote.label","ca_labels")%>'	onClick="openPreviousNotesDtls();" >
		<%}
		else{
		%>  
			<input type='BUTTON' class='BUTTON' name='Previous_Notes' id='Previous_Notes' id='Previous_Notes' style='visibility:hidden'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CopyFromPreviousNote.label","ca_labels")%>'	onClick="openPreviousNotesDtls();" >
		<%} %> 
			<!-- IN052940 End. -->
			
			<!-- 62372  end -->
			
			<!--IN063931 start-->
			<input type='BUTTON' class='BUTTON' name='Previous_Section' id='Previous_Section' id='Previous_Section_Id' style='display:none' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CopyFromPreviousSection.label","ca_labels")%>' onClick="openPreviousSectionDtls();">
			<!--IN063931 ends-->
			<input type='BUTTON' class='BUTTON' name='canned_text' id='canned_text'		value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CannedText.label","ca_labels")%>'		  onClick='return getCannedText();'	style="display:none" >
			<input type='BUTTON' class='BUTTON' name='chief_complaints' id='chief_complaints' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChiefComplaints.label","ca_labels")%>'  onClick='return getChiefComplaints();' style="display:none">
			<input type='BUTTON' class='BUTTON' id='req_transcription' name='req_transcription' id='req_transcription' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReqTranscription.label","ca_labels")%>'  onClick='return getTransReq();' style="display:none">
			</td>
			
			<td class = button align="right" width="28%">
			<%
			if(!function_id.equals("SIGN_NOTES") && !function_id.equals("REVIEW_NOTES")&& !appl_task_id.equals("PROGRESS_NOTES"))
			{
				%>
					<input type='BUTTON' class='BUTTON' name='Prev_Notes' id='Prev_Notes' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PrevNotes.label","ca_labels")%>' onClick=' getPreNotes();' >&nbsp;&nbsp;
				<%
			}

			if( operation_mode.equals("ModifyAddendum") )
				strLinkDocEnDis = "style=display:none";
		%>
				<input type='BUTTON' class='BUTTON' name='link_doc' id='link_doc' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LinkDoc.label","ca_labels")%>' <%=strLinkDocEnDis%>  onClick='return callMeOnLinkDocs();' style="display:none" >&nbsp;</td>
		<%
			
			String strEnDis = "display:none";

			if(doc_linked_note_yn.equals("Y"))
				strEnDis = "";
			else
				strEnDis = "display:none";
		%>
			<td class = button align="right">
				<input type='BUTTON' class='BUTTON' id='fileupload_btn' name='FileUpload' id='FileUpload' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Upload.label","ca_labels")%>' onClick='return RecordClinicalNotesFileUpload(this);' style="<%=strEnDis%>">&nbsp;&nbsp;

		<%			
		
			String strSignButCaption = "";

			if( operation_mode.equals("ModifyAddendum") )
				strSignButCaption = "Sign Addendum";
			else{
			//IN063818 starts
				if(isModifyDescSS)
					strSignButCaption = "  Update  ";		
				else
					strSignButCaption = "  Modify  ";		
			//IN063818 ends
			}

				if(operation_mode.equals(""))
					displayNotesView = "display";

			if( operation_mode.equals("ModifyAddendum") )
			{
				%>
					
					<input type='BUTTON' class='BUTTON' name='record' id='record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick='return RecordClinicalNotes(this);' >&nbsp;&nbsp;  <!-- Ramesh -->
					<input type='BUTTON' class='BUTTON' name='sign' id='sign'	value='<%=strSignButCaption%>'	onClick='return RecordClinicalNotes(this);'	 >
					<!--IN071264 Starts-->
					<td class=button><input type='BUTTON' class='BUTTON' id ='savedraft' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")%> Draft' onClick='return saveClinicalNotes();' style='display:none'>
					<input type='BUTTON' class='BUTTON' id='cleardraft' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")%> Draft' onClick='return clearSavedNoteInSecTemp(this);' style='display:none'></td>
					<!--IN071264 Ends-->
				<%
			}
			else if(operation_mode.equals("ModifySection"))
			{
				%>
					<input type='BUTTON' class='BUTTON' name='sign' id='sign'	value='<%=strSignButCaption%>'	onClick='return RecordClinicalNotes(this);'	 style='display:none'>&nbsp;&nbsp;
					<!--IN071264 Starts-->
					<td class=button align="center"><input type='BUTTON' class='BUTTON' id ='savedraft' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")%> Draft' onClick='return saveClinicalNotes();' style='display:none'>
					<input type='BUTTON' class='BUTTON' id='cleardraft' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")%> Draft' onClick='return clearSavedNoteInSecTemp(this);' style='display:none'></td>
					<!--IN071264 Ends-->
				<%
			}
			else
			{
				%>
				
				</td>
				
		<!--IN071264 Starts-->
		<td class=button align="center"><input type='BUTTON' class='BUTTON' id ='savedraft' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")%> Draft' onClick='return saveClinicalNotes();' style='display:none'>
		<input type='BUTTON' class='BUTTON' id='cleardraft' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")%> Draft' onClick='return clearSavedNoteInSecTemp(this);' style='display:none'></td>
				<!--IN071264 Ends-->
			<td class = button align="right">&nbsp;
					<input type='BUTTON' class='BUTTON' name='record' id='record'		value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>'					onClick='return RecordClinicalNotes(this);' style="display:none">&nbsp;&nbsp;
					<input type='BUTTON' class='BUTTON' name='sign' id='sign' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sign.label","common_labels")%>' onClick='return RecordClinicalNotes(this);' style="display:none">

					<input type='BUTTON' class='BUTTON' name='notesView' id='notesView' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notes.label","common_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")%>' onClick='return PreviewRecordClinicalNotes(this);' style="<%=displayNotesView%>"></td>
				<%
			}  %>
		
		<td class = button align="right">&nbsp;
<%		if( operation_mode.equals("ModifyAddendum") )
		{
			%>
				<!-- <input type='BUTTON' class='BUTTON' name='btn_Print' id='btn_Print'	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")%>'			onClick="showNotes('','<%=operation_mode%>','Preview')" style="display:none"> [IN032683] --> <!-- </td> -->
				<input type='BUTTON' class='BUTTON' name='btn_Print' id='btn_Print'	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")%>'			onClick="showNotes('','<%=operation_mode%>','Preview')">
			<%
		}else if( operation_mode.equals("Update") || operation_mode.equals("ModifySection")){
	%>			
				<input type='BUTTON' class='BUTTON' name='btn_Print' id='btn_Print' 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")%>'			onClick="assignSectionDetails('','','','','Preview')" >
<%		}
		else
		{
			%><!-- <td class = button> -->
			<input type='BUTTON' class='BUTTON' name='btn_Print' id='btn_Print' 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")%>'			onClick="assignSectionDetails('','','','','Preview')" >
			<%
		}
		%>
		</td>
		</tr>
		<% 
		//101,starts
		if( operation_mode.equals("ModifyAddendum") || operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals(""))
		{
		%>
		<tr align='right' id='display_msg' >
			<!-- <td style='display:none;color:red' id='process_msg' align="left"><b>Under Process, Please wait........</b></td> -->
			<td colspan="5" id='display_view' align='right'  style='display:none;color:red' >&nbsp;&nbsp;<b><fmt:message key="eCA.ClickForRecAndSign.label" bundle="${ca_labels}"/></b></td>
		<td>&nbsp</td>
		<td>&nbsp</td>
		</tr>
		<%
		}		
		else
		{
		%>
		<tr align='right' id='display_msg' >
			<!-- <td style='display:none;color:red' id='process_msg' align="left"><b>Under Process, Please wait........</b></td> -->
			<td colspan="5" id='display_view' align='right'  style='display;color:red' >&nbsp;&nbsp;<b><fmt:message key="eCA.ClickForRecAndSign.label" bundle="${ca_labels}"/></b></td>
		<td>&nbsp</td>
		<td>&nbsp</td>
		</tr>
		<%
		}//101,ends	
		%>
		</table>
	</div>
	</p>

<input type=hidden name=user_id id=user_id value="<%=login_user_id%>">
<input type='hidden' name ='oledb_con_string' value='<%=oledb_con_string%>' >
<input type='hidden' name = "facility_id"	value ="">
<input type='hidden' name = "encounter_id"	value ="">
<input type='hidden' name = "resp_id"		value ="">
<input type='hidden' name = "note_type"		value ="">
<input type='hidden' name = "function_id"		value ="<%=function_id%>">
<input type='hidden' name = "contr_mod_accession_num"		value ="<%=contr_mod_accession_num%>">  <!--  [IN032874] Start->		<!--  Ramesh -->
<!--IN063931 start-->
<input type='hidden' name="sec_hdg_code" id="sec_hdg_code" value="">
<input type='hidden' name="child_sec_hdg_code" id="child_sec_hdg_code" value="">
<input type="hidden" name="myHIXYN" id="myHIXYN" value="N"/><!--IN067607-->
<input type="hidden" name="myHIXNoteType" id="myHIXNoteType" value=""/><!--IN067607-->
<input type="hidden" name="noteCopiedYN" id="noteCopiedYN" value="N"/><!--IN068105-->
<input type="hidden" name="isModifyDescYN" id="isModifyDescYN" value="<%=isModifyDescYN%>"/><!--IN063818-->
<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>"/><!--68801-->
<!--IN063931 ends-->
</form>
	</center>
	<!-- <OBJECT ID="WebFp"
CLASSID="CLSID:CA452A7B-737F-434D-904A-AB06E644C25F"
CODEBASE="PrintFPCom.CAB#version=1,0,0,0" VIEWASTEXT></OBJECT> -->
</body>
<%
}
catch(Exception e)
{
	e.printStackTrace();	
}
%>
</html>
<!--IN071264 Starts-->
<script  type="text/javascript">
var note_type = "";
if(null!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm && undefined!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm && null!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type && undefined!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type)
	note_type = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;
if('<%=auto_save_yn%>' == "Y" && ('<%=operation_mode%>'=='ModifyAddendum' || '<%=operation_mode%>'=='Update' || '<%=operation_mode%>'=='ModifySection' )){
	
	document.getElementById("savedraft").style="display";
 	document.getElementById("cleardraft").style="display";
	 
}
else if('<%=auto_save_yn%>' == "Y" && note_type!='')
{
	document.getElementById("savedraft").style="display";
 	document.getElementById("cleardraft").style="display";
}
</script>
<!--IN071264 Ends-->

