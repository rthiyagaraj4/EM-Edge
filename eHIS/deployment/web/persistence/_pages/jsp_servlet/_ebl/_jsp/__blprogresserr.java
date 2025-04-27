package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;

public final class __blprogresserr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLProgressErr.jsp", 1709114580556L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<head>\n    <Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n    <Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n<script language=\"JavaScript\">\n</script>\n\n</head>\n<BODY CLASS=\"MESSAGE\" onKeyDown = \'lockKey()\'>\n\n<p align=\"left\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script language=\'JavaScript\'>\n\tfunction toolBarReset(){\n\tif(parent.commontoolbarFrame!=null){\n\t\tvar qry_stg=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\tvar error=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\tvar qry_string1= qry_stg.lastIndexOf(\"&expand\");\n\t\tvar finalString;\n\t\tvar expand;\n\t\tvar url;\n\t\tvar final_name=getLabel(\"Common.menu.label\",\"Common\");\n\t\tif(parent.commontoolbarFrame.document.forms[0])\n\t\t{\n\t\t\tif(parent.commontoolbarFrame.document.forms[0].home)\n\t\t{\n\t\t\tif(parent.commontoolbarFrame.document.forms[0].home.value !=null )\n\t\t{\n\t\tif(parent.commontoolbarFrame.document.forms[0].home.value ==final_name )\n\t\t{\n\t\t\texpand=\"0\";\n\t\t}else\n\t\t{\n\t\t\texpand=\"1\";\n\t\t}\n\t\t}\n\t\t}\n\t\t}else\n\t\t{\n\t\t\texpand=\"0\";\n\t\t}\n\t\tif(qry_string1 !=-1)\n\t\t{\n\t\t finalString=qry_stg.substring(0,qry_string1);\n\t\turl=\"../../eCommon/commonToolbar.jsp?qry_stg=\"+finalString+\"&expand=\"+expand;\n\t\t}else\n\t\t{\n\t\turl=\"../../eCommon/commonToolbar.jsp?qry_stg=\"+qry_stg+\"&expand=\"+expand;\n\t\t}\n\t\n\t\tif(error==\"R\")\n\t\t{\n\t\n\t\tparent.commontoolbarFrame.location.href=url;\n\t\tparent.reset();\n\t\t}else\n\t\t{\n\t\tparent.commontoolbarFrame.location.href=url;\n\t\t}\t\n\t}}</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</p>\n</BODY>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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

			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

                

    String error=request.getParameter( "err_num" );
    //String home_required_yn=request.getParameter("home_required_yn");
	
    if ( error != null ) {
        String queryString = (String) session.getValue( "queryString" ) ;
        if ( queryString == null ) queryString = "" ;
		
        if ( error == null ) error = "" ;

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(error));
            _bw.write(_wl_block10Bytes, _wl_block10);

			
////changes ends.
		
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		String reqId =  request.getParameter("reqId");

		System.err.println("error_value-->"+error_value);
        if ( error_value.equals( "1" ) )
		{
            out.println( "<script language='JavaScript'>parent.onSuccess('"+reqId+"');"+
            "</script>" ) ;
		}else if(error.equals("R"))
		{
		}else
		{
                out.println( error ) ;
                out.println( "<script language='JavaScript'>toolBarReset();</script>" ) ;
		}
            
/*
            if(error.indexOf("APP-SM0001") !=-1 || error.indexOf("APP-SM0002") !=-1 ||  error.indexOf("APP-SM0003") !=-1) 
                out.println("<script>alert('"+error.substring(0,error.length()-4)+"')</script>");
*/            
    }


            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
