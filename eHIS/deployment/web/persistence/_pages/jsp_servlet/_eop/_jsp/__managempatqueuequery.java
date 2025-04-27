package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __managempatqueuequery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ManageMPatQueueQuery.jsp", 1709529366019L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<script src=\"../../eOP/js/ManageMPatQueue.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<iframe src=\'../../eOP/jsp/MultiPatframe1.jsp?refresh=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&access_rule=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&oprstn=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&call_from=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&speciality_code=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&pat_id_length=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&sdate=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&bl_package_enabled_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&action_on_pending_bill=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' name=\'MultiPatframe1\' FRAMEBORDER=NO NORESIZE   style=\'height:20vh;width:100vw\'></iframe>\n\t<iframe src=\'../../eCommon/html/blank.html\' name=\'MultiPatframe3\' id=\'MultiPatframe3\' FRAMEBORDER=NO   marginwidth=\'5\' NORESIZE style=\'height:40vh;width:100vw\'></iframe>\n\t<iframe src=\'../../eOP/jsp/MultiPatStatusBar.jsp\' name=\'status\' id=\'status\' FRAMEBORDER=NO   marginwidth=\'5\' scrolling=\'no\' NORESIZE style=\'height:20vh;width:100vw\'></iframe>\n\t<iframe src=\'../../eOP/jsp/CheckBoxDisplay.jsp\' name=\'checkbox\' id=\'checkbox\' FRAMEBORDER=NO   marginwidth=\'5\' scrolling=\'no\' NORESIZE style=\'height:20vh;width:100vw\'></iframe>\n\n</html>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

    request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String oprstn=request.getParameter("oprstn")==null?"":request.getParameter("oprstn");
	String order=request.getParameter("orderbyvisit");

	if(order==null)
		order="no";	
	try{
	
	String rfresh_param = request.getParameter("refresh");
	String rule=request.getParameter("access_rule");
	String call_from=request.getParameter("call_from")==null?"":request.getParameter("call_from");
	String speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	if(rule == null) rule="";	
	String pat_id_length = request.getParameter("pat_id_length")==null?"":request.getParameter("pat_id_length");
	String bl_package_enabled_yn = request.getParameter("bl_package_enabled_yn")==null?"N":request.getParameter("bl_package_enabled_yn");
	String sdate = request.getParameter("sdate")==null?"":request.getParameter("sdate");
	String action_on_pending_bill =request.getParameter("action_on_pending_bill")==null?"":request.getParameter("action_on_pending_bill");// Added For MMS-QH-CRF-0126 [IN:041880]


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rfresh_param));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rule));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oprstn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bl_package_enabled_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(action_on_pending_bill));
            _bw.write(_wl_block15Bytes, _wl_block15);

	}catch(Exception e) {}
	finally{	
	}

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
