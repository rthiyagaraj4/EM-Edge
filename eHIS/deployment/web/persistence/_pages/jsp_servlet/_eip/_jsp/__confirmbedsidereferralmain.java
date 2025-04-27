package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;

public final class __confirmbedsidereferralmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ConfirmBedSideReferralMain.jsp", 1718798183762L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n</head>\n<script>\n\nfunction reset()\n{\n\tf_query_add_mod.document.forms[0].reset();\n\tf_query_add_mod1.location.href = \"../../eCommon/html/blank.html\";\n\tif (f_query_add_mod.document.forms[0].searchby != null)\n\t{\n\t\tif (f_query_add_mod.document.forms[0].soundex.value!=\'\')\n\t\t{\n\t\t\tf_query_add_mod.document.forms[0].searchby.value=\"\";\n\t\t\tf_query_add_mod.document.forms[0].searchby.disabled=true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tf_query_add_mod.document.forms[0].searchby.disabled=false;\n\t\t\tf_query_add_mod.document.forms[0].searchby.value=\"S\";\n\t\t}\n\t}\n\tframes[1].document.forms[0].search.disabled=false;\n}\n\n</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t\tsrc=\'../jsp/ConfirmBedsideReferralCriteria.jsp?";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&jsp_name=ConfirmBedSideReferralDetail.jsp&win_height=27&win_width=48&call_function=BedSideReferral\' frameborder=0 scrolling=\'no\' noresize style=\'height:25vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'f_query_add_mod1\' id=\'f_query_add_mod1\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:55vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'messageFrame2\' id=\'messageFrame2\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t\t</html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
*******************************************************************************************
* @Module			: InPatient Management [IP]
* @Function Name	: Inpatient Referral -> Confirm Bedside Referral 
* @Author			: SRIDHAR R 
* @Created Date		: 6 JULY 2004
* @Funtion			: This function provides the receipt for Bedside Visit in Register Inpatient Referral...
*******************************************************************************************
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String facility_id	= (String)session.getAttribute("facility_id");
String loginUser		=	checkForNull((String)session.getValue("login_user"));

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8"); 
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	Connection con		= null;
	ResultSet rs 		= null; 
	ResultSet rset 		= null; 
	Statement stmt 		= null;
	try
	{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();

	rs = stmt.executeQuery("select 1 from ip_param where facility_id = '"+facility_id+"'") ;
	if(rs.next())
	{

		rset = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facility_id+"','"+loginUser+"','N','','CONFIRM_BEDSIDE_REFERRAL_YN') FROM dual") ;
		rset.next();
		String OsVal=rset.getString(1);
		if(OsVal.equals("1"))
		{
			out.print("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
		else if(OsVal.equals("2"))
		{
			out.print("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
		else if(OsVal.equals("3"))
		{
			out.print("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
		else if(OsVal.equals("4"))
		{
			out.print("<script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}else if(OsVal.equals("5"))
		{
			out.print("<script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
		else if(!OsVal.equals(""))
		{	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(source));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(source));
            _bw.write(_wl_block6Bytes, _wl_block6);
		}
	}else
	{
		out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));</script>");
		out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
	}
	if(rs	!= null)   rs.close();
	if(stmt  != null)   stmt.close();	
	}catch(Exception e)
	{
		out.println("Exception in tryCatch ConfirmBedSideReferralMain : "+ e.toString());
	}	finally
	{
		ConnectionManager.returnConnection(con,request);
	}			
		

            _bw.write(_wl_block7Bytes, _wl_block7);
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
