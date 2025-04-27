<!DOCTYPE html>
<%@page import="com.ehis.persist.PersistenceHelper"%>

<%
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	String section_content = "";	
	String curr_sec_hdg_code = (request.getParameter("section_code") == null) ? "" : request.getParameter("section_code");
	String curr_child_sec_hdg_code = (request.getParameter("child_section_code") == null) ? "" : request.getParameter("child_section_code");
	String addum="";
    addum = (request.getParameter("addum") == null) ? "" : request.getParameter("addum");   
	try
	{ 	
		if(addum.equals("addumMode")){						
			section_content = (String) sectionBean.getAddendumText ( curr_sec_hdg_code,curr_child_sec_hdg_code );

			if(section_content == null || section_content.equals("") )
				section_content			="";
			
			section_content			=	java.net.URLDecoder.decode(section_content,"UTF-8");
			
		}else{
			
			if(!curr_sec_hdg_code.equals("") && !curr_child_sec_hdg_code.equals(""))
			{
				section_content = (String) sectionBean.getSectionContent ( curr_sec_hdg_code,curr_child_sec_hdg_code );

				if(section_content == null || section_content.equals("") )
					section_content			="";
				
				section_content			=	java.net.URLDecoder.decode(section_content,"UTF-8");
			}	
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

%>
<%-- <%
String section_content;
webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
section_content = (String) sectionBean.getAddendumText ( "*AmmendNotes*","*AmmendNotes*" );

if(section_content == null || section_content.equals("") )
	section_content			="";

section_content			=	java.net.URLDecoder.decode(section_content,"UTF-8");

%> --%>
<style>
		.cke_contents
		{
			margin-top:50px;			
		}
</style>
<div id="RecNotesRTE_CK" style="min-height:300px">
			
		<%=section_content %>
		
</div>
<script>
function initRTE(){
	var currentSection = $("#hdnCurChildSectionCode").val();
	CKEDITOR.config.toolbar = [

		{ name: 'clipboard', items: ['Undo', 'Redo' ] },
		{ name: 'editing', items: [ 'SelectAll' ] },
		{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline' ] },
		{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-',  'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ] },
		{ name: 'styles', items: [ 'Format', 'FontSize' ] },
	];
	CKEDITOR.config.resize_enabled = false;

	CKEDITOR.replace('RecNotesRTE_CK', {
		height: 200,
		removePlugins: 'floatingspace,resize,elementspath',
		resize_enabled: false
	});
}

initRTE();

</script>
