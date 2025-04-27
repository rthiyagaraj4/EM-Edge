package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __reviewapplmessage_menu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ReviewApplMessage_Menu.jsp", 1709720132765L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\'></link>\n</head>\n<title>View</title>\n\n<iframe src=\'../../eXH/jsp/ReviewApplMessageMenuTree.jsp?applicationId=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&facilityId=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&msgid=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&eventType=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&protocol_link_id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&sub_module=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&applicationName=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&facilityName=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&protocol_mode=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&eventName=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&srlNo=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&queueType=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'  name=\"master_menu\" noresize scrolling=\'auto\' style=\'height:100vh;width:38.5vw\'></iframe>\n<iframe src=\'../../eXH/jsp/ReviewApplMessageMenuTreeText.jsp?applicationId=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  name=\"master_pages\"  marginwidth=\"0\" marginheight=\"0\" scrolling=\'no\' noresize style=\'height:100vh;width:61.5vw\'></iframe>\n\n</html> \n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

String protocol_mode = request.getParameter("protocol_mode"); 
String sub_module=request.getParameter("sub_module");
String application_id="";
String application_name="";
String facility_id="";
String facility_name="";
String Event_type="";
String msgid="";
String protocol_link_id = "";
String eventName = "";
String srlNo = request.getParameter("srlNo");
String queueType = request.getParameter("queueType");

if(queueType != null) queueType = queueType.toUpperCase();

try
{
	eventName = request.getParameter("eventName");
	if(protocol_mode.equals("O"))
	{
		 application_id=request.getParameter("application_id");
		 application_name=request.getParameter("application_name");
		 facility_id=request.getParameter("facility_id");
		 facility_name=request.getParameter("facility_name");
		 Event_type=request.getParameter("event_type");
		 msgid=request.getParameter("msgid");
		 protocol_link_id = request.getParameter("protocol_link_id");
		 if(application_name!=null)
		 {
			 if(application_name.equalsIgnoreCase("*A")) 
			 {
				application_name="All";
			 }
			 else 
			 {
			 }
		 }
		 else 
		 {
			 application_name="All";
		 }
		 if(facility_name!=null)
		 {
			 if(facility_name.equalsIgnoreCase("*A")) 
			 {
				facility_name="All";
			 }
			 else
			 {
			 }
		 }
	}
	else
	{     
		 application_id=request.getParameter("application_id");
		 application_name=request.getParameter("application_name");
		 facility_id=request.getParameter("facility_id");
		 facility_name=request.getParameter("facility_name");
		 Event_type=request.getParameter("event_type");
		 msgid=request.getParameter("msgid");
		 protocol_link_id = request.getParameter("protocol_link_id");
    	 if(application_name!=null)
		 {
			 if(application_name.equalsIgnoreCase("*A")) 
			 {
				application_name="All";
			 }
			 else 
			 {
			 }
		 }
		 else 
		 {
			 application_name="All";
		 }
		 if(facility_name!=null)
		 {
			 if(facility_name.equalsIgnoreCase("*A")) 
			 {
				facility_name="All";
			 }
			 else
			 {
			 }
		 }
	  }

}
catch(Exception e)
{
	System.out.println("Error is in ReviewApplMessage_Menu :"+e);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(application_id));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(msgid));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Event_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(protocol_link_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(application_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(protocol_mode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(eventName));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(srlNo));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(queueType));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(application_id));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(msgid));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Event_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(protocol_link_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(application_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(protocol_mode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(queueType));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(eventName));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(srlNo));
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
