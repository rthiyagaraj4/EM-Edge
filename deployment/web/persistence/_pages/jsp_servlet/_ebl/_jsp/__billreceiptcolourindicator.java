package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __billreceiptcolourindicator extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptColourIndicator.jsp", 1737913078113L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Color Indicator Status</title>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\n<style>\n\t.billApproved{\n\t\twidth: 50px;\n\t\theight: 12.5px;\n\t\tbackground: #52BD15;\n\t}\n\t.onHold{\n\t\twidth: 50px;\n\t\theight: 12.5px;\n\t\tbackground: #5EF7ED;\n\t}\n\t.pending{\n\t\twidth: 50px;\n\t\theight: 12.5px;\n\t\tbackground: #F2FA52;\n\t}\n\t.sent{\n\t\twidth: 50px;\n\t\theight: 12.5px;\n\t\tbackground: #0C1EE8;\n\t}\n\t.rejected{\n\t\twidth: 50px;\n\t\theight: 12.5px;\n\t\tbackground: #9F9FA1;\n\t}\n\t.clarification{\n\t\twidth: 50px;\n\t\theight: 12.5px;\n\t\tbackground: #FC9DFC;\n\t}\n</style>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script>\n$(document).ready(function(){\n\t$(\'#back\').click(function(){\n\t\twindow.close();\n\t});\n});\n</script>\n</head>\n<body>\n\t<br/>\n\t<table style=\"width: 90%;\" align=\"center\">\n\t\t<tr>\n\t\t\t<td style=\"width: 20%;\">\n\t\t\t\t<span class=\'billApproved\'>&nbsp;</span>\n\t\t\t<td style=\"width: 80%;\" class=\'LABEL\'>\n\t\t\t\tApproved\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td style=\"width: 20%;\">\n\t\t\t\t<span class=\'onHold\'>&nbsp;</span>\n\t\t\t<td style=\"width: 80%;\" class=\'LABEL\'>\n\t\t\t\tOn Hold\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td style=\"width: 20%;\">\n\t\t\t\t<span class=\'pending\'>&nbsp;</span>\n\t\t\t<td style=\"width: 80%;\" class=\'LABEL\'>\n\t\t\t\tPending\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td style=\"width: 20%;\">\n\t\t\t\t<span class=\'sent\'>&nbsp;</span>\n\t\t\t<td style=\"width: 80%;\" class=\'LABEL\'>\n\t\t\t\tSent\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td style=\"width: 20%;\">\n\t\t\t\t<span class=\'rejected\'>&nbsp;</span>\n\t\t\t<td style=\"width: 80%;\" class=\'LABEL\'>\n\t\t\t\tRejected\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td style=\"width: 20%;\">\n\t\t\t\t<span class=\'clarification\'>&nbsp;</span>\n\t\t\t<td style=\"width: 80%;\" class=\'LABEL\'>\n\t\t\t\tClarification\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=\'2\' align=\"right\">\n\t\t\t\t<input type=\'button\' name=\'back\' id=\'back\' id=\'back\' value=\'Back\'>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
			

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
