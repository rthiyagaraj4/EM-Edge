package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.CommonBean;
import java.util.*;
import com.ehis.util.*;

public final class __scheduleframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ScheduleFrame.jsp", 1737729854000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<iframe name=\'schdule_dtl\' id=\'schdule_dtl\' src=\"../../eOT/jsp/Schedule.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" noresize style=\'height:90vh;width:98vw\'></iframe>\n\t\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<div style=\"display: grid; grid-template-columns: 1fr 1fr; height: 100vh;width:100vw;\">\n\t\t\t<iframe name=\'result0\' id=\'result0\' src=\"../../eOT/jsp/Schedule.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" noresize style=\'height:100vh;width:50vw;display: inline-block;\'></iframe>\n\t\t\t<iframe name=\'result1\' id=\'result1\' src=\"../../eOT/jsp/Schedule.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  noresize style=\'height:100vh;width:50vw;display: inline-block;\'></iframe>\n\t\t\t</div>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<div style=\"display: grid; grid-template-columns: 1fr 1fr; height: 100vh;width:100vw;\">\n\t\t<iframe name=\'result0\' id=\'result0\' src=\"../../eOT/jsp/Schedule.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" frameborder=0 noresize style=\'height:94vh;width:32.5vw\'></iframe>\n\t\t<iframe name=\'result1\' id=\'result1\' src=\"../../eOT/jsp/Schedule.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" frameborder=0 noresize style=\'height:94vh;width:32.5vw\'></iframe>\n\t\t<iframe name=\'result2\' id=\'result2\' src=\"../../eOT/jsp/Schedule.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" frameborder=0 noresize style=\'height:94vh;width:32vw\'></iframe>\n\t\t</div>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
	request.setCharacterEncoding("UTF-8"); 
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 

            _bw.write(_wl_block3Bytes, _wl_block3);

	String chkSize = CommonBean.checkForNull(request.getParameter("chkSize"));
	if(chkSize != null && chkSize.trim().equals("1"))
	{

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block7Bytes, _wl_block7);

	}
	else if(chkSize != null && chkSize.trim().equals("2"))
	{
		String param = request.getQueryString();
		String param0 = "";
		String param1 = "";
		if(param.indexOf("~") != -1)
		{
			param0 = param.substring(0, param.indexOf("~"));
			param1 = param.substring(param.indexOf("~")+1, param.length());
		}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(param0));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(param1));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	else if(chkSize != null && chkSize.trim().equals("3"))
	{
		String param = request.getQueryString();
		String param0 = "";
		String param1 = "";
		String param2 = "";

		if(param.indexOf("~") != -1 && param.indexOf("~~") != -1)
		{
			param0 = param.substring(0, param.indexOf("~"));

			param1 = param.substring(param.indexOf("~")+1, param.indexOf("~~"));

			param2 = param.substring(param.indexOf("~~")+2, param.length());
		}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(param0));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(param1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(param2));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}

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
