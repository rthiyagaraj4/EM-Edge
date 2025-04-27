<!DOCTYPE html>
<%@page import="com.ehis.persist.PersistenceHelper"%>
		<%
		webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
		String section_content = "";
		String curr_sec_hdg_code = (request.getParameter("section_code") == null) ? "" : request.getParameter("section_code");
		String curr_child_sec_hdg_code = (request.getParameter("child_section_code") == null) ? "" : request.getParameter("child_section_code");
		try
		{
			if(!curr_sec_hdg_code.equals("") && !curr_child_sec_hdg_code.equals(""))
			{
				section_content = (String) sectionBean.getSectionContent ( curr_sec_hdg_code,curr_child_sec_hdg_code );

				if(section_content == null || section_content.equals("") )
					section_content = "";
				
				section_content			=	java.net.URLDecoder.decode(section_content,"UTF-8");
				
				section_content=section_content.replace("<address>","<address1>");
				section_content=section_content.replace("</address>","</address1>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

		%>
		<style>
		.cke_contents
		{
			margin-top:50px;			
		}
		</style>
		<div id="RecNotesRTE_<%=curr_child_sec_hdg_code%>" style="overflow: hidden;">			
			<input type="hidden" name="section_contentvalue" id="section_contentvalue" id="section_contentvalue" value='<%=section_content %>'/>
		</div>
		
		

<script>
$( document ).ready(function() {
	console.log($("#cke_1_bottom"));
$("#cke_1_bottom").hide();
});
window.addEventListener("orientationchange", function() {
	window.parent.$("body").scrollTop(250);
	var me = document.activeElement;
	$(me).contents().find("body")[0].blur(); 
	setCkeContentHeight();
}, false);
var erange;
function initRTE(){
	var currentSection = $("#hdnCurChildSectionCode").val();
	
	editor = CKEDITOR.replace('RecNotesRTE_'+currentSection,
	{
		allowedContent:true
	});

	editor.setData($("#section_contentvalue").val());
		editor.ui.addButton('btnCannedtxt', {
			label: "Canned text",
			command: 'btnCannedtxtClick',
			//toolbar: 'editing',
			icon: path + "/eIPAD/images/ic_format_canned_black_18dp.png"
		});
		
		editor.config.toolbar = [
		
		{ name: 'clipboard', items: ['Undo', 'Redo'] },
		{ name: 'editing', items: [ 'SelectAll' ] },
		{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline' ] },
		{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-',  'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ] },
		{ name: 'styles', items: [ 'Format', 'FontSize' ] },
		{ name: 'canntext', items: [ 'btnCannedtxt' ] }
	];
		editor.addCommand("btnCannedtxtClick", {
		exec: function(edt) {
			 erange = editor.getSelection().getRanges()[0]; // store the selection
			saveOffset=erange.startOffset;
		
			var me = document.activeElement;
			$(me).contents().find("body")[0].blur(); 
			var element = editor.getSelection().getSelectedText();
			if(element!=null && element.length>0) return false;			
			$('.cke_wysiwyg_frame').contents().find('body').attr('contenteditable',false);
			$("#cannedTextPop").show();			
			loadTabTextTypes('text');		
			}
		});

	editor.on( 'loaded', function( evt ) 
		{
			 
			$(".cke").css({"box-sizing":"border-box","height":"100%"});
		//	$(".cke_inner").css({"box-sizing":"border-box","width":"100%","height":"100%","display":"flex","align-items":"stretch","flex-direction":"column"});
   
			$(".cke_top").css({"box-sizing":"border-box","width":"100%","z-index":"1"});
			$(".cke_contents").css({"box-sizing":"border-box","width":"100%","overflow-y":"hidden !important"});
			$(".cke_wysiwyg_frame").css({"position":"relative","width":"100%","height":"100%"});
			
			setCkeContentHeight();
		});  
	editor.on('focus', function(){
		window.parent.$("body").scrollTop(250);
	});  
}
initRTE();
function setCkeContentHeight(){
						//getting window height
						var windowHeight = parent.document.body.clientHeight;
						
						//getting cke_top top position
						//getting cke_top height
						var EMContentTopValue =  $("#EMHeader", parent.document).height();
						
						var ckeTopValue = $(".cke_top").offset().top;
						
						var cke_contentTop_value = EMContentTopValue + ckeTopValue + $(".cke_top").height();//33
						
						//getting em footer top position
						var EMFooterLink = $("#EMFooter", parent.document);
						
						var EMFooterHeight = EMFooterLink.height();
						
						//getting height of cke_content
						var cke_content_height = windowHeight - cke_contentTop_value - EMFooterHeight ;
						
						$(".cke_contents").css('height',cke_content_height - 100);
						
						$('.cke_wysiwyg_frame').contents().find('html').css({"overflow":"hidden","height":cke_content_height - 100+"px"});
						$('.cke_wysiwyg_frame').contents().find('body').css({"overflow":"auto","height":cke_content_height - 100+"px"}); 
						

}
</script>

