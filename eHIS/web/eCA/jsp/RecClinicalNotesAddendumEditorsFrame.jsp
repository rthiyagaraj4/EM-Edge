<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?				100				?           	created
18/07/2012		IN034055		Menaka V		Record Clinical Notes>A note is recorded>Modify>Addendum cannot 
												be added .									
20/07/2012		IN033881		Dinesh T		Addendum data is not appearing in the multifacility scenario
25/07/2012		IN034224		Dinesh T		Recording and signing the addendum is not functioning properly
25/07/2012		IN033869		Dinesh T		Addendum contents clears when we try to click the sections on the left in the 													modify mode
19/09/2012		IN033677		Dinesh T		CRF-Recording and signing the addendum with new free text editor 
27/12/2012		IN034871		Ramesh G		Addendum details are not displayed only for modification and hence the issue is happen some times.
14/05/2019		IN067862		Ramesh G		ML-BRU-CRF-0530
21/10/2019		IN071569		Ramesh G		ML-MMOH-SCF-1389 
18/03/2020		IN071264		Nijitha S		GHL-CRF-0604
---------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%><!--IN071264-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %><!--IN033869-->
<html>
<head>
<title><fmt:message key="eCA.RichTextEditorandMEDIPainter.label" bundle="${ca_labels}"/> </title>
	<META content="text/html; charset=UTF-8" http-equiv=Content-Type>
	<META content="MSHTML 5.00.2920.0" name=GENERATOR>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);//IN033869
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<!-- 	<script language='javascript' src='../../eCA/js/prototype.js'></script>  -->
	<SCRIPT language="javascript" src="../../eCommon/js/RTEditor.js"></SCRIPT>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>

<%

String RTEText						=	"";
String strContentEditableYn			=	"";
String accessnum					= 	"";	//[IN033677]
String facility_id					=	""; //[IN033677]
String srl_no						=	"";

Connection			con				=	null;  //IN034871
PreparedStatement addendumTextPstmt = null; //IN034871
ResultSet addendumTextRs = null; //IN034871
strContentEditableYn		=	(request.getParameter("content_editable_yn")==null?"Y":request.getParameter("content_editable_yn"));


if(strContentEditableYn.equals("") )
	strContentEditableYn = "Y";
	
facility_id			= (String)session.getValue("facility_id"); //[IN033677]
accessnum			= (request.getParameter("accession_num")==null)?"":request.getParameter("accession_num");  //[IN033677]
String curr_sec_hdg_code			= (request.getParameter("curr_sec_hdg_code")==null)?"":request.getParameter("curr_sec_hdg_code");//IN033677
String curr_child_sec_hdg_code			= (request.getParameter("curr_child_sec_hdg_code")==null)?"":request.getParameter("curr_child_sec_hdg_code");//IN033677
String login_user_id = (String) session.getValue("login_user");
String patient_id			= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
String encounter_id			= (request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
String note_type			= (request.getParameter("encounter_id")==null)?"":request.getParameter("note_type");

//String strExistingContent = (String) sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");//IN033869//IN033677
String strExistingContent = "";

//IN071264 Starts
String addendum_text_temp = "";
String auto_save_yn ="N";
CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
//IN071264 Ends
//IN033677,starts
if( !(curr_sec_hdg_code.equals("")) )
{
	//IN071264 Starts
	//strExistingContent = (String) sectionBean.getAddendumText(curr_sec_hdg_code,curr_child_sec_hdg_code);
	  if("Y".equals(auto_save_yn)){
		 if(curr_sec_hdg_code.equals("*AmmendNotes*"))
			addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("*tempAmmendNotes*","*tempAmmendNotes*");
		 else	
			 addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("temp"+curr_sec_hdg_code,"temp"+curr_child_sec_hdg_code);
		}
if(null!=addendum_text_temp && !"".equals(addendum_text_temp)){
	strExistingContent = addendum_text_temp;
}
else{
	strExistingContent = (String) sectionBean.getAddendumText(curr_sec_hdg_code,curr_child_sec_hdg_code);
} 
//IN071264 Ends
}
else
{ 
	try{//IN071264
	con				=	ConnectionManager.getConnection(request); //IN071264
	//[IN034871] Start.
	//IN067862 Start.
	//String addendumTextSql = "SELECT srl_no, addendum_text, addendum_status FROM ca_encntr_note_addendum WHERE accession_num = ? AND addendum_status = 'R' and sec_hdg_code = ? and SUBSEC_HDG_CODE = ? ORDER BY srl_no";
	String addendumTextSql = "SELECT srl_no, addendum_text, addendum_status,addendum_clob,addendum_storage_type FROM ca_encntr_note_addendum WHERE accession_num = ? AND addendum_status = 'R' and sec_hdg_code = ? and SUBSEC_HDG_CODE = ? ORDER BY srl_no";
	//IN067862 End.
	String addendumTexttmp = "";//IN071264 Starts
	 if("Y".equals(auto_save_yn)){
		 
			addendumTextPstmt = con.prepareStatement("SELECT ADDENDUM_CLOB FROM CA_ENCNTR_NOTE_ADDENDUM_TMP WHERE PATIENT_ID=? AND ENCOUNTER_ID=? AND NOTE_TYPE=? AND ADDED_BY_ID=? AND SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ? ");
			addendumTextPstmt.setString(1,patient_id);
			addendumTextPstmt.setString(2,encounter_id);
			addendumTextPstmt.setString(3,note_type);
			addendumTextPstmt.setString(4,login_user_id);
			addendumTextPstmt.setString(5,"*AmmendNotes*");
			addendumTextPstmt.setString(6,"*AmmendNotes*");
			addendumTextRs	=	addendumTextPstmt.executeQuery();
			if(addendumTextRs.next())
			{
				addendumTexttmp = addendumTextRs.getString("ADDENDUM_CLOB");
			}
			sectionBean.setAddendumText("*tempAmmendNotes*","*tempAmmendNotes*",addendumTexttmp);
			addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("*tempAmmendNotes*","*tempAmmendNotes*");
	 }
	if(null!=addendum_text_temp && !"".equals(addendum_text_temp))
	{
		strExistingContent =addendum_text_temp;
	}
	 else{//IN071264 Ends
	/* try{
		con				=	ConnectionManager.getConnection(request); *//* Commented for IN071264  */
		
		if(!accessnum.equals("&nbsp;") && !accessnum.equals(""))
		{
			addendumTextPstmt = con.prepareStatement(addendumTextSql);
			addendumTextPstmt.setString(1,accessnum);
			addendumTextPstmt.setString(2,"*AmmendNotes*");
			addendumTextPstmt.setString(3,"*AmmendNotes*");
			addendumTextRs				=	addendumTextPstmt.executeQuery();
			String addendumText = "";

			if(addendumTextRs.next())
			{
				//IN067862 Start.
				//addendumText = addendumTextRs.getString("addendum_text");
				if("CLOB".equals((String)addendumTextRs.getString("addendum_storage_type")))
					addendumText = addendumTextRs.getString("addendum_clob");
				else
					addendumText = addendumTextRs.getString("addendum_text");
				
				//IN067862 End.
			}			
			sectionBean.setAddendumText("*AmmendNotes*","*AmmendNotes*",addendumText);
		}
	
	
	//[IN034871] End.
	strExistingContent = (String) sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");
	 }//IN071264
 }catch(Exception e)
 {
 	//out.println("Exception@2: "+e);//COMMON-ICN-0181
 	e.printStackTrace();
 }
 finally
 {
 	if(addendumTextRs!=null) addendumTextRs.close();
 	if(addendumTextPstmt!=null) addendumTextPstmt.close();
 	if(con!=null)	ConnectionManager.returnConnection(con,request);
 }
}
//IN033677,ends

//System.out.println("RecClinicalNotesAddendumEditorsFrame.jsp,strExistingContent=>"+strExistingContent);
if(strExistingContent == null)//IN033677
	strExistingContent = "";
//strExistingContent			=	java.net.URLEncoder.encode(strExistingContent,"UTF-8");
RTEText = java.net.URLEncoder.encode(strExistingContent,"UTF-8");//IN033677

//Dinesh T on 9/14/2012,starts

//Dinesh T on 9/14/2012,ends

//IN033677,starts
/*if(strExistingContent.equals("") || strExistingContent.equals("<ADDRESS>&nbsp;</ADDRESS>"))//IN033869
{
	if(!accessnum.equals(""))
	{
		Connection			con			=	null;
		PreparedStatement	pstmt		=	null;
		ResultSet			rs			=	null;
		try{
			con				=	ConnectionManager.getConnection(request);
			//pstmt			=	con.prepareStatement("SELECT SRL_NO,ADDENDUM_TEXT FROM CA_ENCNTR_NOTE_ADDENDUM WHERE FACILITY_ID=? AND ACCESSION_NUM=? AND ADDENDUM_STATUS='R'");//IN033881
			//IN071569 Start.
			//pstmt			=	con.prepareStatement("SELECT SRL_NO,ADDENDUM_TEXT FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND ADDENDUM_STATUS='R'");//IN033881
			pstmt			=	con.prepareStatement("SELECT SRL_NO,ADDENDUM_TEXT,ADDENDUM_CLOB,ADDENDUM_STORAGE_TYPE FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND ADDENDUM_STATUS='R'");//IN033881
			//IN071569 End.
			//pstmt.setString(1, facility_id );
			pstmt.setString(1, accessnum);
			
			rs				=	pstmt.executeQuery();
			String  tem_text ="";
			if(rs.next())
			{
					srl_no	=rs.getString(1);
					//IN071569 Start.
					//tem_text =rs.getString(2);
					if("CLOB".equals((String)rs.getString(4)))
						tem_text =rs.getString(3);
					else
						tem_text =rs.getString(2);
					//IN071569 end.
					RTEText  =java.net.URLEncoder.encode(tem_text,"UTF-8");
			}
		}catch(Exception e){
			out.println("Exception@1 : "+e);
		}finally{			
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
}
else//IN033869,starts
{
	RTEText = java.net.URLEncoder.encode(strExistingContent,"UTF-8");
}//IN033869,ends
*/
//IN033677,ends
%>
<script language='JavaScript'>

var HTMLContent = "<html><body><form name=\'ImageRTEditorForm\' action = \'../../eCA/jsp/RTEditor.jsp\' method=\'post\'>";
HTMLContent += "<textarea name = \'RTEText\' style = \'visibility:hidden\' ><%=RTEText%></textarea>";
HTMLContent += "<input type = hidden name = content_editable_yn value = '<%=strContentEditableYn%>'>";
HTMLContent += "<input type = hidden name = editor_param value = 'A'>";
HTMLContent += "</form></body></html>";
//parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.srl_no.value='<%=srl_no%>';	//[IN033869]
var controller = parent.RecClinicalNotesSecControlFrame;
//controller.document.body.innerHTML = "";
controller.document.body.insertAdjacentHTML('beforeend', HTMLContent);
//parent.RecClinicalNotesHeaderFrame.document.getElementById("srl_no").value='<%=srl_no%>';//IN034055//IN034224
</script>
</head>
<body>
<FRAMESET  id = "frameSetIDPainterEditor" border="0" >
	<iFRAME SRC="../../eCommon/html/blank.html" NAME="RecClinicalNotesRTEditorFrame" id="RecClinicalNotesRTEditorFrame" noresize style="height:98vh;width:97vw;"></iFRAME>
</FRAMESET>

<script language="JavaScript">

getEditor(); 

function getEditor()
{
	var controller = parent.RecClinicalNotesSecControlFrame;
	controller.document.ImageRTEditorForm.target = parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame.name;
	controller.document.ImageRTEditorForm.submit();
}
</script>
</body>
</html>

