package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;
import java.util.regex.Pattern;
import eXH.*;

public final class __displayresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DisplayResult.jsp", 1732869235286L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n<head>\n<script Language=\"JavaScript\"  src=\"../eCommon/js/ValidateControl.js\" ></script> \n<script language=\"JavaScript\">\nfunction formLoad()\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t   \n{\t\t\t\t\t\n\tvar qryString = document.getElementById(\"queryString\").value;\n\tif(document.forms[0].gen_flag.value==\'G\')\t   \n\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\tif(document.forms[0].exec_nature.value==\'T\' )\t\t\t\t\t\t\t\t \t  \n\t\t{\t\t\t\n\t\t   \tparent.frames[1].document.forms[0].downloadApi.disabled=false;  \t\t\t\t\t\t\t \n\t\t}\n\t\t//parent.frames[0].document.location.href=\'../eCommon/jsp/commonToolbar.jsp?&function_type=F&access=YYYYY&desktopFlag=N\',\'XH_J_INBOUND_DATA_MAPPING\'; \n\t\tparent.frames[0].document.location.href=\'../eCommon/jsp/commonToolbar.jsp?\'+qryString,\'XH_J_INBOUND_DATA_MAPPING\';\n\t}\t\t\t\n\telse\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t{\t\t\n\t\n\t\tif(document.forms[0].fun_id.value==\'\'||document.forms[0].fun_id.value==null)\t    \n\t\t{\n\t\t//\tif(document.forms[0].devconf_flag==\'true\'){\n\t\t\t\t//parent.frames[0].document.location.href=\"../eCommon/jsp/commonToolbar.jsp?&function_type=F&access=NYYNY\";\n\t\t\t\tparent.frames[0].document.location.href=\"../eCommon/jsp/commonToolbar.jsp?\"+qryString;\n\t\t//\t}\n\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\telse\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\n\t\t\t\tif(document.forms[0].fun_id.value==\'SWTCHEVENT\')\n\t\t\t\t{\t\n\t\t\t\t\t//parent.parent.frames[0].document.location.href=\'../../eCommon/jsp/commonToolbar.jsp?&function_type=F&access=NYNNN&desktopFlag=N&home_required_yn=N\',\'XH_J_INBOUND_DATA_MAPPING\';\n\t\t\t\t\tparent.parent.frames[0].document.location.href=\'../../eCommon/jsp/commonToolbar.jsp?\'+qryString,\'XH_J_INBOUND_DATA_MAPPING\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{ \t\t\t\n\t\t\t\t\t//parent.frames[0].document.location.href=\'../eCommon/jsp/commonToolbar.jsp?&function_type=F&access=YYYNN&desktopFlag=N\',\'XH_J_INBOUND_DATA_MAPPING\';\n\t\t\t\t\tparent.frames[0].document.location.href=\'../eCommon/jsp/commonToolbar.jsp?\'+qryString,\'XH_J_INBOUND_DATA_MAPPING\';\n\t\t\t\t}\n\t\t}\n\t\t\t\t\t\t\n\t}\t\t\t\t\t\t\t\t   \n}\n</script>\n<script src=\'../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\t\t\t\t\t\t\t\t\t   \n</head>\n<BODY CLASS=\"MESSAGE\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onLoad=\"formLoad()\">\n<form>\n<p align=\"left\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\t\t\t\t\t\t    \n</p>\t\n<input type=hidden name=\"fun_id\" id=\"fun_id\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">    \n<input type=hidden name=\"gen_flag\" id=\"gen_flag\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"> \n<input type=hidden name=\"exec_nature\" id=\"exec_nature\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"> \t \n<input type=hidden name=\"devconf_flag\" id=\"devconf_flag\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n<input type=hidden name=\"queryString\" id=\"queryString\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"> \t \n</form>\n</BODY>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n</html>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t \n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

																						    
	String result=(String)request.getParameter( "message" );
	String gen_flag=XHDBAdapter.checkNull((String)request.getParameter("gen_flag")); 			  
	String exec_nature=XHDBAdapter.checkNull((String)request.getParameter("exec_nature"));  
	String fun_id=XHDBAdapter.checkNull((String)request.getParameter("fun_id"));   
	String devconf_flag=XHDBAdapter.checkNull((String)request.getParameter("devconf_flag"));   
	
	String queryString = session.getValue("queryString").toString();

	//System.out.println("result 19"+result);												 
	//System.out.println("gen_flag :"+gen_flag);		   
 															  		 	   					 

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(result));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(fun_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(gen_flag));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(exec_nature));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(devconf_flag));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
