package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __sessiontest extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SessionTest.jsp", 1709120342000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<head>\n<script language=\"javascript\" src=\"../../eOT/js/HoldingArea.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form>\n<input type=\'hidden\' name=\'note_type\' id=\'note_type\' value= \"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\" >\n<input type=\'hidden\' name=\'title\' id=\'title\' value= \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" >                                                           \n<input type=\'hidden\' name=\'appl_task_id\' id=\'appl_task_id\' value= \'CLINICAL_NOTES\'>                                   \n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value= \'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'>                                           \n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value= \'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"\'>                                   \n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value= \'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>                                  \n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">                                        \n<input type=\'hidden\' name=\'event_class\' id=\'event_class\' value= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">                                      \n<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">                              \n<input type=\'hidden\' name=\'window_close\' id=\'window_close\' value= \"Y\">                                 \n<input type=\'hidden\' name=\'ot_speciality_code\' id=\'ot_speciality_code\' value= \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>                        \n<input type=\'hidden\' name=\'hide_header\' id=\'hide_header\' value= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >                                      \n<input type=\'hidden\' name=\'tab_yn\' id=\'tab_yn\' value= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">                                                   \n<input type=\'hidden\' name=\'contr_mod_accession_num\' id=\'contr_mod_accession_num\' value= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"  >\n<input type=\'hidden\' name=\'query_flag_yn\' id=\'query_flag_yn\' value= \"N\"  >\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"  >\n<input type=\'hidden\' name=\'jsessionid\' id=\'jsessionid\' value= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  >\n</form>                                                               \n<body>                                                                                                                                                                                      </html>                                                                \n  <SCRIPT>OpenNotesWindow();</SCRIPT>    \n\n                                                                            \n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
 
//java.util.Properties prop = (java.util.Properties)session.getAttribute("jdbc");
String jsessionid = request.getParameter("jsessionid");
//String locale = (String)session.getAttribute("LOCALE"); 
String title = request.getParameter("title");
//	String appl_task_id = request.getParameter("appl_task_id");
String patient_id = request.getParameter("patient_id");
String patient_class = request.getParameter("patient_class");
String function_id = request.getParameter("function_id");
String event_class = request.getParameter("event_class");
String accession_num = request.getParameter("accession_num");
String ot_speciality_code = request.getParameter("ot_speciality_code");
String hide_header = request.getParameter("hide_header");
String tab_yn = request.getParameter("tab_yn");
//String window_close = request.getParameter("window_close");
String contr_mod_accession_num = request.getParameter("contr_mod_accession_num");
String facility_id = request.getParameter("facility_id");
String encounter_id = request.getParameter("encounter_id");
String note_type = request.getParameter("note_type");
String episode_id = request.getParameter("episode_id");

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(title));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(event_class));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ot_speciality_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(hide_header));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tab_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(jsessionid));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
