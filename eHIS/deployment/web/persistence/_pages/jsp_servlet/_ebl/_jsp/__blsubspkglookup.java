package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.jaxen.util.FollowingAxisIterator;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import eCommon.XSSRequestWrapper;

public final class __blsubspkglookup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLSubsPkgLookup.jsp", 1717263868000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<html>\r\n<head>\r\n<script type=\"text/javascript\" src=\'../../eBL/js/BLModifyFinancialDetails.js\'></script>\r\n</head>\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<body>\r\n\t<div>\r\n\t<div class=\"lookupContainer\" >\r\n    \t<div id=\"headerDiv\" class=\"lookup-headercontainer\" style=\"background-color: #00A0DD;\">\r\n\t\t\t<div class=\"lookup-title\">";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</div>\r\n\t\t\t<input type=\"Button\" class=\"icon-button\" value=\"X\" onclick=\"closePkgPopup()\" >\r\n\t\t\t<!-- <div class=\"buttoncontainer\">\r\n\t\t\t\t<span class=\"close-btn\" onclick=\"closePopup()\">X</span>\r\n\t\t\t</div> -->\r\n\t\t</div>\r\n\t\t<div id=\"searchDiv\" class=\"lookup-subcontainer\">\r\n\t\t\t<div>\r\n\t\t\t\t<input type=\"text\" class=\"gridInputs\"  id=\"searchText\" placeholder=\'Find...\' value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'>\r\n\t\t\t\t<button class=\"gridSerachIcon\" type=\"button\" id=\"pkgsrch\"  onclick=\"searchPkg()\" >\r\n\t\t\t\t\t<span class=\"mdi mdi-magnify\"></span>\r\n\t\t\t\t</button>\r\n\t\t\t</div> \r\n\t\t</div>\r\n\t\t<br>\r\n\t\t<div id=\"resultDiv\" class=\"lookup-subcontainer\">\r\n    \t\t<div class=\"table\" id=\"pkgLkupResult\" contenteditable=\"false\">\r\n    \t\t\t\r\n    \t\t</div>\r\n\t\t</div>\r\n\t\t<div align=\"right\">\r\n\t\t\t<input type=\"Button\" class=\"btn btn-primary\" value=\"OK\" onclick=\"loadSelectedpackages()\">\r\n\t\t\t<input type=\"Button\" class=\"btn btn-primary\" value=\"Cancel\" onclick=\"closePkgPopup();\" >\r\n\t\t</div>\r\n    </div>\r\n   </div>\r\n</body>\r\n    <input type=\"hidden\" id=\"columndescriptions\"  value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\r\n    <input type=\"hidden\" id=\"strWhereColmn\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/>\r\n    <input type=\"hidden\" id=\"strWhereColnTyp\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/>\r\n    <input type=\"hidden\" id=\"searchText\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>\r\n    <input type=\"hidden\" id=\"calledfor\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" />\r\n    <input type=\"hidden\" id=\"searchField\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" /> \r\n    <input type=\"hidden\" id=\"paramForQry\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\r\n     <input type=\"hidden\" id=\"seqNoString\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\r\n    <input type=\"hidden\" id=\"facility\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/> \r\n <script type=\"text/javascript\">\r\n     $(document).ready(function(){\r\n    \t$(\'#modifyFinancialDetails\').find(\'#pkgsrch\').click()\r\n    }); \r\n</script>\r\n</html>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------

*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block1Bytes, _wl_block1);
String queryString=request.getQueryString();
String title = request.getParameter("title");
request.setCharacterEncoding("UTF-8"); 
String called_for=request.getParameter("called_for");

String column_descriptions = request.getParameter("column_descriptions");
String column_sizes = request.getParameter("column_sizes");
String searchMainScreenVal = request.getParameter("searchMainScreenVal");
String strWhereColumnType = request.getParameter("strWhereColumnType");
String strWhereColumn = request.getParameter("strWhereColumn");
String searchFieldID = request.getParameter("searchFieldID");
String facility_id=request.getParameter("facility_id");
String seqNoString=request.getParameter("seqNoString");
String paramForQuery = request.getQueryString();


            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(title ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(searchMainScreenVal));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(column_descriptions ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( strWhereColumn));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( strWhereColumnType));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(searchMainScreenVal ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(called_for));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(searchFieldID ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(paramForQuery ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(seqNoString ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facility_id ));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
