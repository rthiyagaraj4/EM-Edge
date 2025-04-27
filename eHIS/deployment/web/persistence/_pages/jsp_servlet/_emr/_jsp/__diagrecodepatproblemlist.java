package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __diagrecodepatproblemlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DiagRecodePatProblemList.jsp", 1709117046592L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n<title>Problem List</title>\n</head>\n<!-- \t<frameset rows=\'56%,*\' framespacing=0 border=0> -->\n\t<frameset rows=";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" framespacing=0>\n\t\t<frame   src=\"problemsframe0.jsp?Patient_Id=";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="&Context=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&P_function_id=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&P_no_of_items=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&P_option_type=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&modal_yn=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&encounter_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" name=\"problemsframe0\" marginheight=\'0\'  frameborder=no scrolling=no >\n\t\t<frame  src=\"problemsframe1.jsp?Patient_Id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&P_access_type=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&radio_par=A&P_function_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" name=\"problemsframe1\"   scrolling=yes frameborder=no>\n\t\t<frameset cols=\"60%,*\" border=\"1\" framespacing=2>\n\t\n\t\t<frame src = \"ProblemsDetails.jsp?Patient_Id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" name=\"problemsdetails\" marginheight=\'0\' marginwidth=\'0\' scrolling=no frameborder=no >\n\t\t<frame src = \"ProblemsAssessment.jsp?Patient_Id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" name=\"problemsassessments\" marginheight=\'0\' marginwidth=\'0\' frameborder=no>\n\t\t</frameset>\n\t\t<frame name=\"problemframeControl\" src=\"PatProblemControl.jsp?modal_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" frameborder=no scrolling=no>\n\t\t<frame name=\"problemframeEncounter\" src=\"\" frameborder=no scrolling=yes>\n\t</frameset>\n\n</html> \n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

String patientid = request.getParameter("patient_id");
String context = (String)request.getParameter("PQ");
if (context==null) context="Y";

String P_access_type = request.getParameter("Access_Type");
//String P_access_data = request.getParameter("Access_Data");
//String P_patient_type = request.getParameter("Patient_Type");

//****added for PH function usage
String P_function_id=request.getParameter("P_function_id")==null?"":request.getParameter("P_function_id");
String P_no_of_items=request.getParameter("P_no_of_items")==null?"0":request.getParameter("P_no_of_items");

String P_option_type=request.getParameter("P_option_type")==null?"":request.getParameter("P_option_type");
String modal_yn=request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
String encounter_id=request.getParameter("encounter_id")==null?"N":request.getParameter("encounter_id");
//out.println("<script>alert('"+P_function_id+"')</script>");

String frameSet="23%,37%,*,0%,8%";
if(P_function_id.equals("PH"))
{
	frameSet="23%,37%,*,8%,0%";
}
//****


            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(frameSet));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(context));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(P_function_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(P_option_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(context));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(P_access_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(P_function_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(P_option_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(context));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(context));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
