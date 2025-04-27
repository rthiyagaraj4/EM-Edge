package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __viewqrymeesagemenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewQryMeesageMenu.jsp", 1709717515796L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n</head>\n<title>View Message</title> \n<iframe src=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="  name=\"master_menu\" noresize scrolling=\'auto\' style=\'height:100vh;width:38.5vw></iframe>\n<iframe src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" name=\"master_pages\"  marginwidth=\"0\" marginheight=\"0\" scrolling=\'no\' noresize style=\'height:100vh;width:61.5vw></iframe>\n\n</html> \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);

String url ="";
String url2 ="";
String applicationid=request.getParameter("application_id");
String Facility_id=request.getParameter("Facility_id");
String eventype=request.getParameter("eventype");
String protocollinkid=request.getParameter("protocollinkid");

//System.out.println("applicationid :"+applicationid+"Facility_id :"+Facility_id+"eventype :"+eventype+"protocollinkid 17 :"+protocollinkid);
/*String	appli=(String)session.getAttribute("applicationName");
String	facility_name=(String)session.getAttribute("facilityname");
String Query_Option=(String)session.getAttribute("Query_Option");
String Query_Status=(String)session.getAttribute("Query_Status");
String	msgid=(String)session.getAttribute("msgId");*/
String	appli=request.getParameter("applicationName");
String	facility_name=request.getParameter("facilityname");
String  Query_Option=request.getParameter("Query_Option");
String  Query_Status=request.getParameter("Query_Status");
String	msgid=request.getParameter("msgId");
//System.out.println("appli :"+appli+" facility_name :"+facility_name+"msgId :"+msgid);
String	mode=request.getParameter("mode");
if(mode!=null){ 
	if(appli!=null)
	{
		//session.setAttribute("applicationName",appli);
	}
	else
	{ 
		appli="All";
		//session.setAttribute("applicationName","All");
	}

if(facility_name!=null){
		//session.setAttribute("facilityName",facility_name);
		}

else
	{
	facility_name="All";
	//session.setAttribute("facilityName","All");
	}

//session.setAttribute("Query_Option",Query_Option);
//session.setAttribute("msgId",msgid);
session.setAttribute("mode",mode); 
//session.setAttribute("Query_Status",Query_Status);
}
 url = "../../eXH/jsp/ViewQueryMessageMenuTreeText.jsp?application_id="+applicationid+"&msgId="+msgid+"&Facility_id="+Facility_id+"&eventype="+eventype+"&protocollinkid="+protocollinkid+"&facilityname="+facility_name+"&applicationName="+appli+"&Query_Option="+Query_Option+"&Query_Status="+Query_Status;

//System.out.println("URL2 :"+url);

url2="../../eXH/jsp/ViewQueryMessageMenuTree.jsp?application_id="+applicationid+"&msgId="+msgid+"&Facility_id="+Facility_id+"&eventype="+eventype+"&protocollinkid="+protocollinkid+"&facilityname="+facility_name+"&applicationName="+appli+"&Query_Option="+Query_Option+"&Query_Status="+Query_Status;
//System.out.println("URL2 :"+url2);

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(url2));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(url));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
