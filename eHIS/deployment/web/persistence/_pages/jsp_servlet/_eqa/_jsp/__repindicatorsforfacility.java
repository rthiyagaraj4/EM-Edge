package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;

public final class __repindicatorsforfacility extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/repIndicatorsForFacility.jsp", 1742817546434L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n<HEAD>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\"../../eQA/js/QAResetrunList.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<br><br>\n<form name=\"repIndFacility\" id=\"repIndFacility\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<table width=\'80%\' align=\'center\' valign=\'top\'>\n<th align=\'left\'> Report Criteria</th>\n<tr><td width=\"80%\" class=\"Border\" align=\'center\'>\n<table width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\" align=\'center\'>\n<tr>\n\t<td align=\"center\" class=\'label\' width=\"35%\" >&nbsp;</td>\n\t<td  width=\"20%\" class=\'label\' align=\"left\">From</td>\n\t<td class=\'label\' width=\"30%\" align=\"left\">To</td>\n</tr>\n<tr>\n\t<td align=\"right\" class=\'label\' >Facility ID&nbsp;</td>\n\t<td width=\"20%\"><input type=text  name=\'p_fm_facility\' id=\'p_fm_facility\' size=\"4\" maxlength=\"4\"\tonKeyPress=\"return CheckForSpecChars(event)\" onBlur=\'ChangeUpperCase(this);parent.validSplchars(this,\"Facility Id\")\'><input type=\'button\' name=\'Facility Id\' id=\'Facility Id\' tabindex=-1 value=\'?\' class=\'button\' onclick=\'searchCode(this, p_fm_facility)\'>\n\t</td>\n\t<td width=\"40%\"><input type=text  name=\'p_to_facility\' id=\'p_to_facility\' size=\"4\" maxlength=\"4\" onBlur=\'ChangeUpperCase(this);parent.validSplchars(this,\"Facility Id\")\' onKeyPress=\"return CheckForSpecChars(event)\" ><input type=\'button\' name=\'Facility Id\' id=\'Facility Id\' value=\'?\' class=\'button\' tabindex=-1 onclick=\'searchCode(this, p_to_facility)\'>\n\t</td>\n</tr>\n<tr>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n</tr>\n<tr>\n\t<td align=\"right\" class=\'label\'>Order By&nbsp;</td>\n\t<td >\n\t\t<select name=\'p_order_by\' id=\'p_order_by\'>\n\t\t<option value=\'1\'>Facility ID\n\t\t<option value=\'2\'>Facility Name\n\t\t</select>\n\t</td>\n</tr>\n<tr>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n</tr>\n</table>\n</td>\n</tr>\n</table>\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

	String p_module_id		= "MR" ;
	String p_report_id		= "QABINDFC" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
