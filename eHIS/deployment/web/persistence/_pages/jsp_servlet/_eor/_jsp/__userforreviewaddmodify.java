package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;

public final class __userforreviewaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/UserForReviewAddModify.jsp", 1709533442000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--ReasonCode.jsp -->\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n<head>\n \t<script language=\"JavaScript\" src=\"../js/UserForReview.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\"> function_id = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<iframe name=\'user_for_review_top1\' id=\'user_for_review_top1\' src=\'UserForReviewAddModifyTop1.jsp?function_id=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&mode=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:4vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'user_for_review_top2\' id=\'user_for_review_top2\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'reason_for_review_bottom\' id=\'reason_for_review_bottom\' src=\'../../eCommon/html/blank.html\' frameborder=0 style=\'height:88vh;width:100vw\'></iframe>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<iframe name=\'user_for_review_top2\' id=\'user_for_review_top2\' src=\'UserForReviewAddModifyTop2.jsp?mode=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&resp_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&pract_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&resp_name=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&pract_name=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=0 scrolling=\'no\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t<iframe name=\'reason_for_review_bottom\' id=\'reason_for_review_bottom\' src=\'UserForReviewAddModifyBottom.jsp?function_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=0 style=\'height:90vh;width:100vw\'></iframe>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n</html>\t\t\t\t\t\t\t\t\t\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, false , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id = request.getParameter( "function_id" ) ;


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
	
	String mode			= request.getParameter("mode");
	String resp_id		= request.getParameter("resp_id");	
	String resp_name	= request.getParameter("resp_name");
	String pract_id		= request.getParameter("pract_id");
	String pract_name	= request.getParameter("pract_name");

	mode = mode.trim();
	if(!(mode.equals("2"))){
		mode = "1";
	}

	if(mode.equals("1")){

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block8Bytes, _wl_block8);
	}else{ 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(resp_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block15Bytes, _wl_block15);

	}

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
