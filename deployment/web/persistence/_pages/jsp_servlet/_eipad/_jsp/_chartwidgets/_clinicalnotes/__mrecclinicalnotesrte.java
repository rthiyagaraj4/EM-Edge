package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.persist.PersistenceHelper;

public final class __mrecclinicalnotesrte extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesRTE.jsp", 1709118015193L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t<style>\n\t\t.cke_contents\n\t\t{\n\t\t\tmargin-top:50px;\t\t\t\n\t\t}\n\t\t</style>\n\t\t<div id=\"RecNotesRTE_";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" style=\"overflow: hidden;\">\t\t\t\n\t\t\t<input type=\"hidden\" name=\"section_contentvalue\" id=\"section_contentvalue\" id=\"section_contentvalue\" value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'/>\n\t\t</div>\n\t\t\n\t\t\n\n<script>\n$( document ).ready(function() {\n\tconsole.log($(\"#cke_1_bottom\"));\n$(\"#cke_1_bottom\").hide();\n});\nwindow.addEventListener(\"orientationchange\", function() {\n\twindow.parent.$(\"body\").scrollTop(250);\n\tvar me = document.activeElement;\n\t$(me).contents().find(\"body\")[0].blur(); \n\tsetCkeContentHeight();\n}, false);\nvar erange;\nfunction initRTE(){\n\tvar currentSection = $(\"#hdnCurChildSectionCode\").val();\n\t\n\teditor = CKEDITOR.replace(\'RecNotesRTE_\'+currentSection,\n\t{\n\t\tallowedContent:true\n\t});\n\n\teditor.setData($(\"#section_contentvalue\").val());\n\t\teditor.ui.addButton(\'btnCannedtxt\', {\n\t\t\tlabel: \"Canned text\",\n\t\t\tcommand: \'btnCannedtxtClick\',\n\t\t\t//toolbar: \'editing\',\n\t\t\ticon: path + \"/eIPAD/images/ic_format_canned_black_18dp.png\"\n\t\t});\n\t\t\n\t\teditor.config.toolbar = [\n\t\t\n\t\t{ name: \'clipboard\', items: [\'Undo\', \'Redo\'] },\n\t\t{ name: \'editing\', items: [ \'SelectAll\' ] },\n\t\t{ name: \'basicstyles\', items: [ \'Bold\', \'Italic\', \'Underline\' ] },\n\t\t{ name: \'colors\', items: [ \'TextColor\', \'BGColor\' ] },\n\t\t{ name: \'paragraph\', items: [ \'NumberedList\', \'BulletedList\', \'-\', \'Outdent\', \'Indent\', \'-\',  \'JustifyLeft\', \'JustifyCenter\', \'JustifyRight\', \'JustifyBlock\' ] },\n\t\t{ name: \'styles\', items: [ \'Format\', \'FontSize\' ] },\n\t\t{ name: \'canntext\', items: [ \'btnCannedtxt\' ] }\n\t];\n\t\teditor.addCommand(\"btnCannedtxtClick\", {\n\t\texec: function(edt) {\n\t\t\t erange = editor.getSelection().getRanges()[0]; // store the selection\n\t\t\tsaveOffset=erange.startOffset;\n\t\t\n\t\t\tvar me = document.activeElement;\n\t\t\t$(me).contents().find(\"body\")[0].blur(); \n\t\t\tvar element = editor.getSelection().getSelectedText();\n\t\t\tif(element!=null && element.length>0) return false;\t\t\t\n\t\t\t$(\'.cke_wysiwyg_frame\').contents().find(\'body\').attr(\'contenteditable\',false);\n\t\t\t$(\"#cannedTextPop\").show();\t\t\t\n\t\t\tloadTabTextTypes(\'text\');\t\t\n\t\t\t}\n\t\t});\n\n\teditor.on( \'loaded\', function( evt ) \n\t\t{\n\t\t\t \n\t\t\t$(\".cke\").css({\"box-sizing\":\"border-box\",\"height\":\"100%\"});\n\t\t//\t$(\".cke_inner\").css({\"box-sizing\":\"border-box\",\"width\":\"100%\",\"height\":\"100%\",\"display\":\"flex\",\"align-items\":\"stretch\",\"flex-direction\":\"column\"});\n   \n\t\t\t$(\".cke_top\").css({\"box-sizing\":\"border-box\",\"width\":\"100%\",\"z-index\":\"1\"});\n\t\t\t$(\".cke_contents\").css({\"box-sizing\":\"border-box\",\"width\":\"100%\",\"overflow-y\":\"hidden !important\"});\n\t\t\t$(\".cke_wysiwyg_frame\").css({\"position\":\"relative\",\"width\":\"100%\",\"height\":\"100%\"});\n\t\t\t\n\t\t\tsetCkeContentHeight();\n\t\t});  \n\teditor.on(\'focus\', function(){\n\t\twindow.parent.$(\"body\").scrollTop(250);\n\t});  \n}\ninitRTE();\nfunction setCkeContentHeight(){\n\t\t\t\t\t\t//getting window height\n\t\t\t\t\t\tvar windowHeight = parent.document.body.clientHeight;\n\t\t\t\t\t\t\n\t\t\t\t\t\t//getting cke_top top position\n\t\t\t\t\t\t//getting cke_top height\n\t\t\t\t\t\tvar EMContentTopValue =  $(\"#EMHeader\", parent.document).height();\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar ckeTopValue = $(\".cke_top\").offset().top;\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar cke_contentTop_value = EMContentTopValue + ckeTopValue + $(\".cke_top\").height();//33\n\t\t\t\t\t\t\n\t\t\t\t\t\t//getting em footer top position\n\t\t\t\t\t\tvar EMFooterLink = $(\"#EMFooter\", parent.document);\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar EMFooterHeight = EMFooterLink.height();\n\t\t\t\t\t\t\n\t\t\t\t\t\t//getting height of cke_content\n\t\t\t\t\t\tvar cke_content_height = windowHeight - cke_contentTop_value - EMFooterHeight ;\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(\".cke_contents\").css(\'height\',cke_content_height - 100);\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(\'.cke_wysiwyg_frame\').contents().find(\'html\').css({\"overflow\":\"hidden\",\"height\":cke_content_height - 100+\"px\"});\n\t\t\t\t\t\t$(\'.cke_wysiwyg_frame\').contents().find(\'body\').css({\"overflow\":\"auto\",\"height\":cke_content_height - 100+\"px\"}); \n\t\t\t\t\t\t\n\n}\n</script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

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

		
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(section_content ));
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
