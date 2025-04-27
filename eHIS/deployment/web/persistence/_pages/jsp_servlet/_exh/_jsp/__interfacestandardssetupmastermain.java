package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __interfacestandardssetupmastermain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/InterfaceStandardsSetupMasterMain.jsp", 1710010735086L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html> \n<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/InterfaceStandards.js\" ></script> \n<script language=\"JavaScript\" src=\"../../eXH/js/checkfield.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" frameborder=0 scrolling=\'no\' noresize scrolling=\'auto\' style=\'height:8vh;width:100vw\'></iframe>\n<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\'  src=\'../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?rule=NR&mode=I\' frameborder=0  scrolling=\'auto\' style=\'height:50vh;width:100vw\'></iframe>\n<iframe name=\'f_query_add_mod_detail\' id=\'f_query_add_mod_detail\'  src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\'height:30vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/MstCodeError.jsp\' frameborder=0  scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n\n</html>\n\n\n\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);

String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
String params = request.getQueryString() ;
	String source = url + params ;
	session.setAttribute("params",params);
//System.out.println("params1"+params);
String application_id=""; 
String facility_id=""; 
String mesg_type_id=""; 
String event_type_id=""; 
String segment_type_id="";
String protocol_link_id=""; 

String standard_code="";
String standard_desc="";
String standard_type="";
String msg_start="";
String msg_end="";
String seg_start="";
String seg_end="";
String fld_separator="";
String elmnt_separator="";

String application_name=""; 
String facility_name=""; 
String mesg_type=""; 
String event_type=""; 
String segment_type="";
String protocol_linkName="";



try
{
String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	standard_desc=request.getParameter("standard_desc");
	standard_type=request.getParameter("standard_type");
	msg_start=request.getParameter("msg_start");
	msg_end=request.getParameter("msg_end");
	seg_start=request.getParameter("seg_start");
	seg_end=request.getParameter("seg_end");
	fld_separator=request.getParameter("fld_separator");
	elmnt_separator=request.getParameter("elmnt_separator");

	session.setAttribute("standard_desc",standard_desc);
session.setAttribute("standard_type",standard_type);
session.setAttribute("msg_start",msg_start);
session.setAttribute("msg_end",msg_end);
session.setAttribute("seg_start",seg_start);
session.setAttribute("seg_end",seg_end);
session.setAttribute("fld_separator",fld_separator);
session.setAttribute("elmnt_separator",elmnt_separator);
session.setAttribute("standard_code",standard_code);
session.setAttribute("application_id",application_id);
session.setAttribute("facility_id",facility_id);
session.setAttribute("mesg_type_id",mesg_type_id);
session.setAttribute("event_type_id",event_type_id);
session.setAttribute("segment_type_id",segment_type_id);
session.setAttribute("protocol_link_id",protocol_link_id);
application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	mesg_type=request.getParameter("mesg_type");
	event_type=request.getParameter("event_type");
	segment_type=request.getParameter("segment_type");
	protocol_linkName=request.getParameter("protocol_linkName");
	}

else
{
}

application_id		=	request.getParameter("application_id");
facility_id			=	request.getParameter("facility_id");
mesg_type_id		=	request.getParameter("mesg_type_id");
event_type_id		=	request.getParameter("event_type_id");
segment_type_id		=	request.getParameter("segment_type_id");
protocol_link_id	=	request.getParameter("protocol_link_id");

}
catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
    }


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
