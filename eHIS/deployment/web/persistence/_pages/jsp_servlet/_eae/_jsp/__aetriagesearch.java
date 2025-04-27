package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __aetriagesearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AETriageSearch.jsp", 1709113865834L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eAE/js/AETriageDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t <body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t <form name=\"ae_triage_search_form\" id=\"ae_triage_search_form\" >\n\t   <table border=\"0\" cellpadding=\"1\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n  \t\t  <tr>\n\t\t      <td class=\'BODYCOLORFILLED\' width=\'19%\'>&nbsp;</td>\n\t\t      <td class=\'BODYCOLORFILLED\' align=\'left\' width=\'81%\'>&nbsp;\n\t\t\t    <input type=\"button\" class=button name=\'triage\' id=\'triage\' value=\'Triage Details\' title=\'Triage Details\' onClick=\'callFunction(this);\'>\n\t\t\t    <input type=\"button\" class=button name=\'ae_details\' id=\'ae_details\' value=\'A&E Details\' title=\'A&E Details\' onClick=\'callFunction(this);\'>\n\t\t\t  </td>\n\t\t\t</tr>\n\t </table>\n          <input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'>\n   \t\t  <input type=\'hidden\' name=\'clinic_type\' id=\'clinic_type\' value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n   \t\t  <input type=\'hidden\' name=\'clinic_desc\' id=\'clinic_desc\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n\t\t  \n   \t\t  <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n   \t\t  <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t  <input type=\'hidden\' name=\'treatment_area_code\' id=\'treatment_area_code\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t  <input type=\'hidden\' name=\'queue_status\' id=\'queue_status\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t  <input type=\'hidden\' name=\'treatment_area_desc\' id=\'treatment_area_desc\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t   <input type=\'hidden\' name=\'orig_tmt_area_code\' id=\'orig_tmt_area_code\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t  <input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t </form>\n\t </body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String patient_id			 = request.getParameter("patient_id");

			   patient_id			 = (patient_id == null)?"":patient_id;
		String clinic_code			 = request.getParameter("clinic_code");
			   clinic_code			 = (clinic_code == null)?"":clinic_code;
		String clinic_type			 = request.getParameter("clinic_type");
			   clinic_type			 = (clinic_type == null)?"":clinic_type;
		String clinic_desc			 = request.getParameter("clinic_desc");
		if(clinic_desc==null || clinic_desc.equals("") || clinic_desc=="")
				clinic_desc			 = "";
	    String treatment_area_code	 = request.getParameter("treatment_area_code");
			   treatment_area_code	 = (treatment_area_code == null)?"":treatment_area_code;
	    String treatment_area_desc	 = request.getParameter("treatment_area_desc");
			   treatment_area_desc	 = (treatment_area_desc == null)?"":treatment_area_desc;

		String encounter_id			 = request.getParameter("encounter_id");
			   encounter_id			 = (encounter_id == null)?"":encounter_id;
		String queue_status			 = request.getParameter("queue_status");
			   queue_status			 = (queue_status == null)?"":queue_status;
		String orig_tmt_area_code			= request.getParameter("orig_tmt_area_code");
		if(orig_tmt_area_code==null || orig_tmt_area_code.equals("") || orig_tmt_area_code=="")
				orig_tmt_area_code			= "";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(orig_tmt_area_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
