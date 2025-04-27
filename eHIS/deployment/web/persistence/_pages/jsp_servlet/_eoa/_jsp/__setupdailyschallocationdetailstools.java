package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;

public final class __setupdailyschallocationdetailstools extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/SetUpDailySchAllocationDetailsTools.jsp", 1718354639454L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- <!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\"> -->\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"JavaScript\">\n\t\t\tfunction returnSlotValues(from)\n\t\t\t{\n\t\t\t\tvar ret = \'\';\n\t\t\t\tif(from == \'O\')\n\t\t\t\t{\n\t\t\t\t\tvar n = parent.BlockApptAllocationDetailsFrame.document.forms[0].total_count.value;\n\t\t\t\t\tvar sumtext = 0;\n\t\t\t\t\tvar finalvals = \'\';\n\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar a = eval(\"parent.BlockApptAllocationDetailsFrame.document.getElementById(\"block_slot_text\")\"+i+\".value\");\n\t\t\t\t\t\tsumtext+=eval(a);\n\t\t\t\t\t\t\tvar b = eval(\"parent.BlockApptAllocationDetailsFrame.document.getElementById(\"block_slot\")\"+i+\".value\");\n\t\t\t\t\t\t\tb = b.replace(\'$\',a);\n\t\t\t\t\t\t\tfinalvals+=b+\"#\";\n\t\t\t\t\t}\n\t\t\t\t\tvar totalslots = parent.BlockApptAllocationDetailsFrame.document.forms[0].slots_inc_dec.value;\n\t\t\t\t\tif(totalslots != sumtext)\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\talert(\'Total number of ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" SLOTS must match SLOTS TO BE ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\');\n\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tret = finalvals;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\tret = \'\';\n\t\t\t\t\n\t\t\t\tparent.window.returnValue = ret ;\n\t\t\t\tif(ret != \'F\')\n\t\t\t\t\tparent.window.close();\n\t\t\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\"CodeArrest()\"onKeyDown = \'lockKey()\' >\n\t<hr>\n\t<table cellpadding=0 cellspacing=0 width=\"100%\" border=0>\n\t\t<tr>\n\t\t\t<td align=center class=BODYCOLORFILLED>\n\t\t\t\t<b><font size=2>Sum of ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" SLOTS and SLOTS TO BE ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" must match</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=right class=BODYCOLORFILLED>\n\t\t\t\t<input type=\"button\" class=BUTTON value=\"   Ok   \" onClick=\"returnSlotValues(\'O\')\">\n\t\t\t\t<input type=\"button\" class=BUTTON value=\"Cancel\" onClick=\"returnSlotValues(\'C\')\">\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String incdec = request.getParameter("inc_dec")==null?"":request.getParameter("inc_dec");

            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(incdec));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(incdec));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(incdec));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(incdec));
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
