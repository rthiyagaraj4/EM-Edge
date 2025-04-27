package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __displayreviewresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DisplayReviewResult.jsp", 1709122325804L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script Language=\"JavaScript\"  src=\"../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"JavaScript\">\nfunction callFirst()\n{\n\tparent.f_query_img.location.href =\'../eCommon/html/blank.html\';\n\tparent.f_query_btn.location.href =\'../eCommon/html/blank.html\';\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" review_commprocess_refresh_form.action =\'../eXH/jsp/ReviewCommProcessOutbound.jsp\';\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n      review_commprocess_refresh_form.action =\'../eXH/jsp/ReviewCommProcessInbound.jsp\';\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\treview_commprocess_refresh_form.target=\"f_query_add_mod\";\n\treview_commprocess_refresh_form.submit();\n\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<BODY CLASS=\"MESSAGE\" onLoad=\"callFirst();\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n<form name=\"review_commprocess_refresh_form\" id=\"review_commprocess_refresh_form\">\n<input type=\"hidden\" name=\"facility\" id=\"facility\" value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'/>\n<input type=\"hidden\" name=\"comm_client\" id=\"comm_client\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'/>\n<input type=\"hidden\" name=\"appl_Id\" id=\"appl_Id\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'/>\n<input type=\"hidden\" name=\"process_status\" id=\"process_status\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'/>\n<input type=\"hidden\" name=\"process_id\" id=\"process_id\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'/>\n<input type=\"hidden\" name=\"comm_type\" id=\"comm_type\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'/>\n<p align=\"left\">\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</p>\n</form>\n</BODY>\n</html>\n\n";
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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
 
  String  message = "";
  String facility="";
  String comm_type ="";
  String comm_client = "";
  String appl_Id ="";
  String process_id ="";
  String process_status = "";
  message =request.getParameter("message");
  facility=(String)request.getAttribute("facility");
  comm_type =(String) request.getAttribute("comm_type"); 
  comm_client =(String) request.getAttribute("comm_client"); 
  appl_Id = (String)request.getAttribute("appl_Id");
  process_id =(String) request.getAttribute("process_id");
  process_status =(String) request.getAttribute("process_status");

            _bw.write(_wl_block4Bytes, _wl_block4);
 
		if (comm_type.equalsIgnoreCase("O")) 
	{ 
            _bw.write(_wl_block5Bytes, _wl_block5);
} if (comm_type.equalsIgnoreCase("I")) { 
            _bw.write(_wl_block6Bytes, _wl_block6);
} 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(comm_client));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appl_Id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(process_status));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(process_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(comm_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(message));
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
