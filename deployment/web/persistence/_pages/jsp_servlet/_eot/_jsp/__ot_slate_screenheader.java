package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class __ot_slate_screenheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OT_slate_screenHeader.jsp", 1669269696000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\r\n<html>\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="  \r\n\r\n<head>\r\n\t<meta charset=\"utf-8\" /> \r\n\t<meta name=\"keywords\" content=\"\" />\r\n\t<meta name=\"description\" content=\"\" />\r\n\t<link rel=\"stylesheet\" href=\"../../eOT/html/disstyle.css\" type=\"text/css\" media=\"screen, projection\" />\r\n\t<script>\r\n\t\r\nfunction start()\r\n{ \r\n\tvar time=new Date();\r\n\t//Added Start AAKH-SCF-0280 [IN060381]\r\n\tvar date=time.getDate(); \r\n\tdate=((date < 10) ? \"0\" : \"\") + date; \r\n\tvar month = new Array();\r\n\tmonth[0] = \"Jan\";\r\n\tmonth[1] = \"Feb\";\r\n\tmonth[2] = \"Mar\";\r\n\tmonth[3] = \"Apr\";\r\n\tmonth[4] = \"May\";\r\n\tmonth[5] = \"Jun\";\r\n\tmonth[6] = \"Jul\";\r\n\tmonth[7] = \"Aug\";\r\n\tmonth[8] = \"Sep\";\r\n\tmonth[9] = \"Oct\";\r\n\tmonth[10] = \"Nov\";\r\n\tmonth[11] = \"Dec\";\r\n\tvar mon = month[time.getMonth()];\r\n\tvar year=time.getFullYear(); \r\n\t//Added End AAKH-SCF-0280 [IN060381]\r\n\tvar hours=time.getHours();\r\n\tvar minutes=time.getMinutes();\r\n\tminutes=((minutes < 10) ? \"0\" : \"\") + minutes;\r\n\tvar seconds=time.getSeconds();\r\n\tseconds=((seconds < 10) ? \"0\" : \"\") + seconds;\r\n\tvar clock=hours + \":\" + minutes + \":\" + seconds; \r\n\tvar display = date + \" \" + mon + \" \" + year;//Added for AAKH-SCF-0280 [IN060381]\r\n\tdocument.getElementById(\'dateSpan\').innerHTML =\"\";\r\n\tdocument.getElementById(\'timeDiv\').innerHTML =clock;\r\n\tdocument.getElementById(\'dateDiv\').innerHTML = display;//Added for AAKH-SCF-0280 [IN060381]\r\n}\r\n</script>\t\r\n</head>\r\n\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \r\n<body>\r\n   <span id=\"dateSpan\"></span>\r\n\t<div class=\"header\" id=\"header\">\r\n\t\t\t<div class=\"headerbg\">\r\n\t\t\t\t<div class=\"datetimeslot\" id=\"3\">\r\n\t\t\t\t\t\t<div class=\"dateslot\" id=\"4\">\r\n\t\t\t\t\t\t\t<div class=\"sdate\" id=\"dateDiv\"> </div> <!-- Modified for AAKH-SCF-0280 [IN060381] -->\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div class=\"timeslot\" >\r\n\t\t\t\t\t\t\t<div class=\"timecenter\" id=\"6\">\r\n\t\t\t\t\t\t\t\t<div id=\"timeDiv\" class=\"stime\"> </div>\r\n\t\t\t\t\t\t\t\t<!--<div id=\"secDiv\" class=\"smalltime\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"smtime\">:</div>\r\n\t\t\t\t\t\t\t\t</div>-->\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t<div class=\"screentitle\" id=\"7\">\r\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\t\t</div>\r\n\t\t</div>\r\n</body>\r\n<script>\r\nself.setInterval(\"start()\",1000);\r\n</script>\r\n</html>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String facility_id = (String) session.getAttribute( "facility_id" ) ;
	String p_user_name= (String) session.getAttribute( "login_user" ) ;	
	String locale = (String) session.getAttribute( "LOCALE" ) ;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	Date todaysDate = new Date();
	String formatedDate = dateFormat.format(todaysDate);
	String formatedTime = timeFormat.format(todaysDate);
	String minuteFormat = formatedTime.substring(0, formatedTime.lastIndexOf(':'));
	String secondFormat = formatedTime.substring(formatedTime.lastIndexOf(':')+1, formatedTime.length());
	String facility_name = "" ;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	Connection con=ConnectionManager.getConnection();
	pstmt=con.prepareStatement( "SELECT (SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?)FACILITY_NAME,APPL_USER_NAME,APPL_USER_ID FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? and APPL_USER_ID=?" );
	pstmt.setString(1,locale);
	pstmt.setString(2,facility_id);
	pstmt.setString(3,locale);
	pstmt.setString(4,p_user_name);
	rset = pstmt.executeQuery();
	if(rset !=null)	{
		if(rset.next()) {
			facility_name = rset.getString("FACILITY_NAME");
		}
	}
	if(rset!=null)rset.close();
	if(pstmt!=null)pstmt.close();
	ConnectionManager.returnConnection(con);

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facility_name));
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
