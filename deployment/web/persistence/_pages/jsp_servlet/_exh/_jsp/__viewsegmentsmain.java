package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;

public final class __viewsegmentsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewSegmentsMain.jsp", 1709715440442L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n</head>\n<title>View Message</title>\n<iframe name=\'f_query_main\' id=\'f_query_main\' src=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'   scrolling=\'no\' style=\'height:6vh;width:100vw\'></iframe>\n<iframe name=\'f_query_add_mod_detail_main\' id=\'f_query_add_mod_detail_main\' src=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'   scrolling=\'no\' style=\'height:84vh;width:100vw\'></iframe>\n<iframe name=\'messageFrame\' id=\'messageFrame\'\t src=\'../../eXH/jsp/ViewQueryMessageViewerClose.jsp\' frameborder=0 noresize scrolling=\'no\' style=\'height:10vh;width:100vw\'></iframe>\n</html>\t\t\t\t\t\t\t \t\t \t     \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 
String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String protocol_link_id=request.getParameter("protocollinkid");
String applicationId = request.getParameter("application_id");
String facilityId = request.getParameter("Facility_Id");
String msgId = request.getParameter("msg_id");
String qryid = request.getParameter("qryid");
String eventType = request.getParameter("eventype");
String sub_module = request.getParameter("sub_module"); 
String qapplname=request.getParameter("qapplname"); 
String faciname=request.getParameter("faciname"); 
String purge_status=request.getParameter("purge_status");
String url = "../../eXH/jsp/viewQueryeventTreeHeader.jsp?";  
String url2="../../eXH/jsp/ViewSegmentsQueryTree.jsp?application_id="+applicationId+"&Facility_Id="+facilityId+"&msg_id="+msgId+"&eventype="+eventType+"&protocollinkid="+protocol_link_id+"&sub_module="+sub_module+"&qapplname="+qapplname+"&faciname="+faciname+"&qryid="+qryid+"&purge_status="+purge_status;
//String url = "../../eXH/jsp/ViewQueryTree.jsp?application_Id="+applicationId+"&Facility_Id="+facilityId+"&Msg_Id="+msgId+"&Even_type="+eventType+"&protocol_link_id="+protocol_link_id+"&sub_module="+sub_module+"&qapplname="+qapplname+"&faciname="+faciname+"&rule=J";
//String url2 = "";//"../../eXH/jsp/ViewQueryTreeRight.jsp?application_Id="+applicationId+"&Facility_Id="+facilityId+"&Msg_Id="+msgId+"&Even_type="+eventType+"&protocol_link_id="+protocol_link_id+"&sub_module="+sub_module+"&protocol_mode=Q";
 
//System.out.println("this url:"+url); 

  


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( url ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( url2));
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
