package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __discrmsrcompsamplepreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/DiscrMsrCompSamplePreview.jsp", 1724422754129L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n<?xml-stylesheet type=\"text/xsl\" href=\"../../eCA/html/RecClinicalNotesTemplateRecordingView.xsl\"?>\n<DOCUMENT FORM-NAME=\"RecClinicalNotesTemplateForm\" >\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<CSS sStyle=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\"/>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/common.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/dchk.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/RecClinicalNotesPart1.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/RecClinicalNotesPart2.js\'></SCRIPT>\n<SCRIPT type=\'text/javascript\' SRC=\'../../eCommon/js/CommonCalendar.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<STYLE type=\"text/css\">\n\t.READONLY\n\t{\n\t\tBACKGROUND-COLOR: #C0C0C0;\n\t}\n</STYLE>\n\n\n\n<USER-TEMPLATE><ROW><COL>\n<PARAGRAPH  COLSPAN=\'6\' CLASS=\'LABEL\'><PRE> </PRE><SHORT-TEXT-WTD CLASS=\'LABEL\'  NAME=\'C_MRLAE0\' \t COMPTYPE=\'H\' PROMPT=\'Abdominal+Examination\' SIZE =\'0\' MANDATORY=\"N\"  MAXLENGTH = \"0\" ></SHORT-TEXT-WTD><PRE> </PRE><HIDDEN-FIELD NAME=\"mandatory_fields_para\" VALUE=\"\"></HIDDEN-FIELD><HIDDEN-FIELD NAME=\"para_std_component_information\" VALUE=\"\"></HIDDEN-FIELD><PRE></PRE></PARAGRAPH>\n</COL></ROW></USER-TEMPLATE>\n\n</DOCUMENT>\n\n\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "application/xml;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("application/xml;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
