package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.persist.PersistenceHelper;

public final class __mrecclinicalnotesaddendumeditorsframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesAddendumEditorsFrame.jsp", 1709116941973L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<style>\n\t\t.cke_contents\n\t\t{\n\t\t\tmargin-top:50px;\t\t\t\n\t\t}\n</style>\n<div id=\"RecNotesRTE_CK\" style=\"min-height:300px\">\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\n</div>\n<script>\nfunction initRTE(){\n\tvar currentSection = $(\"#hdnCurChildSectionCode\").val();\n\tCKEDITOR.config.toolbar = [\n\n\t\t{ name: \'clipboard\', items: [\'Undo\', \'Redo\' ] },\n\t\t{ name: \'editing\', items: [ \'SelectAll\' ] },\n\t\t{ name: \'basicstyles\', items: [ \'Bold\', \'Italic\', \'Underline\' ] },\n\t\t{ name: \'colors\', items: [ \'TextColor\', \'BGColor\' ] },\n\t\t{ name: \'paragraph\', items: [ \'NumberedList\', \'BulletedList\', \'-\', \'Outdent\', \'Indent\', \'-\',  \'JustifyLeft\', \'JustifyCenter\', \'JustifyRight\', \'JustifyBlock\' ] },\n\t\t{ name: \'styles\', items: [ \'Format\', \'FontSize\' ] },\n\t];\n\tCKEDITOR.config.resize_enabled = false;\n\n\tCKEDITOR.replace(\'RecNotesRTE_CK\', {\n\t\theight: 200,\n\t\tremovePlugins: \'floatingspace,resize,elementspath\',\n\t\tresize_enabled: false\n\t});\n}\n\ninitRTE();\n\n</script>\n";
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


            _bw.write(_wl_block2Bytes, _wl_block2);
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
