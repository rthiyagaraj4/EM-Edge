<!DOCTYPE html>
<%@page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
	request.setCharacterEncoding("UTF-8");
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
%>
<style>
		.cke_contents
		{
			margin-top:50px;			
		}
		</style>
<script>
var clinicalNotesSectBodyScroll;
function addendumclinicalNotesSectBodyScroll() {	
	clinicalNotesSectBodyScroll = new IScroll('#addendumScrollWrapper', { 
		scrollX: true, 
		scrollY: true, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: false,
		useTransition: false,
		bindToWrapper: true
		
	});	
	clinicalNotesSectBodyScroll.refresh();
}

$(document).ready(function () {	
	$("#cke_RecNotesRTE_CK").addClass("addendumSectionClass");
	var secHdgCode=$("#secHdgCode").val();
    var accession_num =$("#accessionNum").val();
	var childSecHdgCode=$("#childSecHdgCode").val();
    var secHdgCode=$("#secHdgCode").val();
	var childSecHdgCode=$("#childSecHdgCode").val();
	addendumclinicalNotesSectBodyScroll();	
});
</script>

<html>
<head>
	<title>RecClinicalNotesSectionView</title>
	<%	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<style>
		ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 9pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	</style>
	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>

<div class="table" style="width:100%;height:100%;">
   <div class="row" style="width:100%;height:100%;">
      <div id="addendumScrollWrapper" class="cell" style="position: relative;width:100%;overflow:hidden;">
        <div style="position: absolute;width:100%;">
<center>
<table  border='0' cellpadding='3' cellspacing='0' width = '100%' align='center'>
<%
	String	sec_content_type			=	"",		section_content		=	"";
	String	sec_hdg_code				=	"",		child_sec_hdg_code	=	"";	
	String  patient_id				    =	"",		encounter_id		=	"";
    String accession_num="";
    String  strExistingContent="";
    String section_add_content= "";

	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI();
	String root = url.substring( 0, url.indexOf(uri) ) + request.getContextPath();	
     url = root + "/eCA/html/RecClinicalNotesTemplateDispayView.xsl";	
	try
	{
		sec_hdg_code		=	checkForNull(	request.getParameter("sec_hdg_code")	);
		sec_content_type	=	checkForNull( request.getParameter("sec_content_type") );
		child_sec_hdg_code	=	checkForNull( request.getParameter("child_sec_hdg_code") );
		encounter_id	=	(request.getParameter("encounter_id")==null)		? ""	:	request.getParameter("encounter_id");
		patient_id		=	(request.getParameter("patient_id")==null)		? ""	:	request.getParameter("patient_id");		
		accession_num	=	checkForNull( request.getParameter("accession_num") );
		String strKey	=	"";
		strKey = patient_id + "~"+ encounter_id;
		strKey = strKey.trim();
		sectionBean.getPatientSection(strKey);	
		
		if( !(sec_hdg_code.equals("")) )
		{
			section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code), "&nbsp;" );
		    if(sec_content_type.equals("T"))
			{	
				if(!(section_content.equals("&nbsp;")))
					section_content=converter.buildHTMLFromXML(section_content,url);	
			}		
			if(!(section_content.equals("&nbsp;")))
			{
				%>
				<tr><td class='BODYCOLORFILLED'><%=section_content%></td></tr>
				<%		
			}
		}
	}
	catch(Exception e)
	{
		out.println("Exception@2 : "+e);
	}
	finally
	{
		converter =null;
	}
	
	Connection			con				=	null;  //IN034871
	PreparedStatement addendumTextPstmt = null; //IN034871
	ResultSet addendumTextRs = null; //IN034871
	if( !(sec_hdg_code.equals("")) )
	{
		strExistingContent = (String) sectionBean.getAddendumText(sec_hdg_code,child_sec_hdg_code);
	}
	else
	{ //[IN034871] Start.
		String addendumTextSql = "SELECT srl_no, addendum_text, addendum_status FROM ca_encntr_note_addendum WHERE accession_num = ? AND addendum_status = 'R' and sec_hdg_code = ? and SUBSEC_HDG_CODE = ? ORDER BY srl_no";
	try{
			con				=	ConnectionManager.getConnection(request);
			if(!accession_num.equals("&nbsp;") && !accession_num.equals(""))
			{
				addendumTextPstmt = con.prepareStatement(addendumTextSql);
				addendumTextPstmt.setString(1,accession_num);
				addendumTextPstmt.setString(2,"*AmmendNotes*");
				addendumTextPstmt.setString(3,"*AmmendNotes*");
				addendumTextRs				=	addendumTextPstmt.executeQuery();
				String addendumText = "";

				if(addendumTextRs.next())
				{
					addendumText = addendumTextRs.getString("addendum_text");
				}						
				sectionBean.setAddendumText("*AmmendNotes*","*AmmendNotes*",addendumText);
			}
		}catch(Exception e)
		{
			out.println("Exception@2: "+e);		
			e.printStackTrace();
		}
		finally
		{
			if(addendumTextRs!=null) addendumTextRs.close();
			if(addendumTextPstmt!=null) addendumTextPstmt.close();
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
		//[IN034871] End.
		strExistingContent = (String) sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");			
	}	
%>
</table>
</center>
</div>
</div>
</div>

<div class="row" style="width:100%;height:100%;">
  <div  style="position: relative;bottom: 0;height: 245px;width: 100%;">
  <div style="background: #e0e0eb;font-size: 14px;vertical-align: middle;line-height: 45px;padding-left: 15px;font-weight: bold;">Add Your Addendum Below</div>
 <%
 section_add_content = (String) sectionBean.getAddendumText ( sec_hdg_code,child_sec_hdg_code );

	if(section_add_content == null || section_add_content.equals("") )
		section_add_content			="";
	
	section_add_content			=	java.net.URLDecoder.decode(section_add_content,"UTF-8");
 %>
  <div style="margin-right: 22px;min-height: 200px;" id="RecNotesRTE_CK" ><%=section_add_content %></div> 
  
  <script>
  function initRTE(){
	CKEDITOR.config.toolbar = [
		{ name: 'clipboard', items: [ 'Undo', 'Redo' ] },
		{ name: 'editing', items: [ 'SelectAll' ] },
		{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline' ] },
		{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-',  'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ] },
		{ name: 'styles', items: [ 'Format', 'FontSize' ] },
	];
	CKEDITOR.config.resize_enabled = false;
	CKEDITOR.replace('RecNotesRTE_CK', {
		height: 100,
		removePlugins: 'floatingspace,resize,elementspath',
		resize_enabled: false
	});
}

initRTE();
  </script>
  
</div>
</div>
</div>

<input type="hidden" name="secHdgCode" id="secHdgCode" id="secHdgCode" value="<%=sec_hdg_code%>"/>
<input type="hidden" name="secContentType" id="secContentType" id="secContentType" value="<%=sec_content_type%>"/>
<input type="hidden" name="secHdgCode" id="secHdgCode" id="secHdgCode" value="<%=sec_hdg_code%>"/>
<input type="hidden" name="patientId" id="patientId" id="patientId" value="<%=patient_id%>"/>
<input type="hidden" name="encounterID" id="encounterID" id="encounterID" value="<%=encounter_id%>"/>
<input type="hidden" name="childSecHdgCode" id="childSecHdgCode" id="childSecHdgCode" value="<%=child_sec_hdg_code%>"/>
<input type="hidden" name="accessionNum" id="accessionNum" id="accessionNum" value="<%=accession_num%>"/>
</body>
</html>

<%!
	public String checkForNull(String inputString)
	{
		return ((inputString==null )	?	""	:	inputString).trim();
	}
	public String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null )inputString ="";		
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();		
	}

%>

