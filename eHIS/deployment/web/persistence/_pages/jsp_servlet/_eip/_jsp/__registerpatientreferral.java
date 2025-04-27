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

public final class __registerpatientreferral extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/RegisterPatientReferral.jsp", 1728895753323L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\t\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n</head>\n\n<script>\n\tfunction reset()\n\t{\n\t\tf_query_add_mod.document.forms[0].reset();\n\t\tf_query_add_mod1.location.href = \"../../eCommon/html/blank.html\";\n\t\tif (f_query_add_mod.document.forms[0].searchby != null)\n\t    {\n\t\t\tif (f_query_add_mod.document.forms[0].soundex.value!=\'\')\n\t\t\t{\n\t\t\t\tf_query_add_mod.document.forms[0].searchby.value=\"\";\n\t\t\t\tf_query_add_mod.document.forms[0].searchby.disabled=true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tf_query_add_mod.document.forms[0].searchby.disabled=false;\n\t\t\t\tf_query_add_mod.document.forms[0].searchby.value=\"S\";\n\t\t\t}\n\t    }\n\t\tframes[1].document.forms[0].search.disabled=false;\n\t}\n</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t<iframe name=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=\'no\' noresize style=\'height:0vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'f_query_add_mod\' \t\tsrc=\'../jsp/InpatientLookupCriteria.jsp?function_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&jsp_name=PaintReferralPatientDetails.jsp&win_height=27&win_width=48&call_function=ReferralPatientDetails&wherecondn=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:25vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'f_query_add_mod1\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:65vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t<!--Santhosh starts ML-MMOH-CRF-1894-->\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'f_query_add_mod\' \t\tsrc=\'../jsp/InpatientLookupCriteria.jsp?function_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:30vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'f_query_add_mod1\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:51vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t<!--Santhosh end-->\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\t\t\t\t<iframe name=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:25vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'f_query_add_mod1\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:57vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</html>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String facility_id	= (String)session.getAttribute("facility_id");
String loginUser		=	checkForNull((String)session.getValue("login_user"));

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String locncode = request.getParameter("location_code");
	String function_id=request.getParameter("function_id");
	/*below Line Added for this CRF Bru-HIMS-CRF-182.1 */
	String invokedModule = request.getParameter("invokedModule")==null?"":request.getParameter("invokedModule");	
    if(function_id == null) function_id = "";
		if(locncode == null) locncode= "";
	//String wherecondn	= "ADMIT_PAT_YN";
	String wherecondn	= "REG_IP_REFERRAL_YN";
	Connection con		= null;
	ResultSet rs 		= null; 
	PreparedStatement pstmt 		= null;
	try
	{
	con = ConnectionManager.getConnection(request);	
	String sqlQuery = "" ;
	sqlQuery = "select 1,AM_OPER_STN_ACCESS_CHECK(?,?,'N','','REG_IP_REFERRAL_YN') OsVal from ip_param where FACILITY_ID =? " ;
	pstmt = con.prepareStatement(sqlQuery);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,loginUser);
	pstmt.setString(3,facility_id);
	rs =pstmt.executeQuery();
	if(rs.next())
	{		
		String OsVal=rs.getString("OsVal")==null?"":rs.getString("OsVal");
		if(OsVal.equals("1")) {			out.print("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		} else if(OsVal.equals("2")) {
			out.print("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		} else if(OsVal.equals("3")) {
			out.print("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		} else if(OsVal.equals("4")) {

			out.print("<script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}else if(OsVal.equals("5")) {
			out.print("<script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		} else if(!OsVal.equals("")) {	
		/*below Condtion Added for this CRF Bru-HIMS-CRF-182.1 */	
		if(invokedModule.equals("CA")){ 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block7Bytes, _wl_block7);
}else if(function_id.equals("REG_PATIENT_REFERRAL")){
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block11Bytes, _wl_block11);
 }
            _bw.write(_wl_block12Bytes, _wl_block12);
	}
	}
	else
	{
		out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));</script>");
		out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
	}

	if(rs	!= null)   rs.close();
	if(pstmt  != null)   pstmt.close();	
	}catch(Exception e)
	{
		out.println("Exception in tryCatch RegisterPatientReferral : "+ e.toString());
		e.printStackTrace();
	}	
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}			
		

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
