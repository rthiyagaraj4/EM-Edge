package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eOR.Common.*;
import webbeans.eCommon.*;

public final class __emdashboardvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/EMDashboardValidate.jsp", 1709116504904L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n<HTML>\n<HEAD>\n<title>EMDashBoard</title>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</HEAD>\n<script>\n\nfunction openDashBoard()\n{\t\t\n\tif(document.emdash.dash_board_url.value==\'\'){\n\t\tvar msg\t= getMessage(\'DASHBOARD_URL_NOT_CONFIGURED\',\'Common\');\n\t\talert(msg);\n\t\twindow.close();\n\t}else{\n\t\tdocument.emdash.submit();\n\t}\n\t\n}\n\n\n</script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<BODY onKeyDown = \'lockKey()\'>\n</BODY>\n<form name=\"emdash\" id=\"emdash\" action=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" method=\"POST\">\n  <input type=\"hidden\" name=\"username\" id=\"username\" value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n  <input type=\"hidden\" name=\"password\" id=\"password\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n  <input type=\"hidden\" name=\"dash_board_url\" id=\"dash_board_url\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\n  \n</form>\n\n</HTML>\n\t<script >\n\topenDashBoard();\n\t</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

Connection con=null ;
Statement stmt=null;
ResultSet rs=null;
con = ConnectionManager.getConnection(request);

Properties properties		= (Properties) session.getValue( "jdbc" );
//String user_id				= (String) session.getAttribute( "login_user" ) ;
String user_id				= request.getParameter("username") ;
String 	user_password		= "";
String 	dash_board_url		= "";

try{
	stmt = con.createStatement();
	String query="select app_password.decrypt(appl_user_password) appl_user_password,(select nvl( DASHBOARD_APP,'') from sm_db_info ) DASHBOARD_APP from sm_appl_user where appl_user_id ='"+user_id+"'";

	rs = stmt.executeQuery(query);
	while(rs.next())
	{
		user_password=checkForNull(rs.getString("appl_user_password"));
		dash_board_url=checkForNull(rs.getString("DASHBOARD_APP"));
	}
	

	if(rs!=null) rs.close();	
	if(stmt!=null) stmt.close();

}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();	
}
 finally
{
	
	if(con!=null) ConnectionManager.returnConnection(con,request);
	
}


	
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(dash_board_url));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(user_password));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(dash_board_url));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
