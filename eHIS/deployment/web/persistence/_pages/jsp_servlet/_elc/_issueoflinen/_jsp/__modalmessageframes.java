package jsp_servlet._elc._issueoflinen._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.cache.pojo.business.Cache;
import com.iba.framework.cache.pojo.business.CacheManager;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.IBADateTime;

public final class __modalmessageframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/elc/IssueOfLinen/jsp/ModalMessageFrames.jsp", 1709118352682L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script language=\"JavaScript\" >\n\nfunction reset()\n{\n\twindow.returnValue=true;\n\twindow.close();\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<title>";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</title>\n</head>\n\t<iframe name=\"linenIssue\" id=\"linenIssue\" src=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/IssueOfLinenViewAction.do?method=4&vo.checkView=issue&vo.issueOfLinenVO.requestNum=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&vo.issueOfLinenVO.requestDate=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&vo.issueOfLinenVO.requestDate.pattern=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&vo.issueOfLinenVO.sourceType=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&vo.issueOfLinenVO.sourceCode=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&vo.issueOfLinenVO.raisedBy=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&vo.issueOfLinenVO.requestStatus=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&vo.issueOfLinenVO.linenItem=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&vo.issueOfLinenVO.requestedQty=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&vo.issueOfLinenVO.sourceDesc=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&vo.issueOfLinenVO.linenDesc=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' / style=\'height:100vh;width:100vw\'></iframe><iframe name=\"messageFrame\" id=\"messageFrame\" src= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/core/jsp/MessageFrame.jsp\" / style=\"height:65%;width:100vw\"></iframe>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

String title=(String)request.getParameter("title");
String sourceDesc=(String)request.getParameter("sourceDesc");
String linenDesc=(String)request.getParameter("linenDesc");
String	requestDate=(String)request.getParameter("requestDate");
String pattern="dd/MM/yyyy hh:mm";

			

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(title));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(request.getParameter("requestNum")));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request.getParameter("requestDate")));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(pattern));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getParameter("sourceType")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getParameter("sourceCode")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getParameter("raisedBy")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getParameter("requestStatus")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getParameter("linenItem")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getParameter("requestedQty")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sourceDesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(linenDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getContextPath()));
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
