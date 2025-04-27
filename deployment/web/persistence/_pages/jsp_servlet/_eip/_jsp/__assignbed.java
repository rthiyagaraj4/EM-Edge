package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __assignbed extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AssignBed.jsp", 1723025814947L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\t<script>\n\t   function reset()\n\t   {\n\t\t\tf_query_add_mod.document.forms[0].reset();\n\t\t\tif (f_query_add_mod.document.forms[0].searchby != null)\n\t\t\t{\n\t\t\t\tif (f_query_add_mod.document.forms[0].soundex.value!=\'\')\n\t\t\t\t{\n\t\t\t\t\tf_query_add_mod.document.forms[0].searchby.value\t\t=\t\"\";\n\t\t\t\t\tf_query_add_mod.document.forms[0].searchby.disabled\t=\ttrue;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tf_query_add_mod.document.forms[0].searchby.disabled\t=\tfalse;\n\t\t\t\t\tf_query_add_mod.document.forms[0].searchby.value\t\t=\t\"S\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tf_query_add_mod.document.forms[0].search.disabled = false;\n\t\t\tf_query_add_mod1.location.href = \'../../eCommon/html/blank.html\';\n\t   }\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=\'no\' noresize style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \tsrc=\'../../eIP/jsp/InpatientLookupCriteria.jsp?function_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&jsp_name=AssignBedMain.jsp&call_function=assign_bed&wherecondn=ASSIGN_BED_YN&oper_stn_id=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&chg_nurs_unit_in_assign_bed_yn=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:22vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'f_query_add_mod1\' id=\'f_query_add_mod1\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:55vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'desc_frame\' id=\'desc_frame\' \tsrc=\'QuerySearchResultFrames.jsp?step=assignbed\' frameborder=0 scrolling=\'auto\' noresize  style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/MstCodeError.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t  <script>\n\t\t\t\talert(getMessage(\'IP_PARAM_NOT_FOUND\',\'IP\'));\n\t\t\t\tdocument.location.href= \'../../eCommon/jsp/dmenu.jsp\';\n\t\t  </script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	StringBuffer sqlBuffer	=	new StringBuffer();
	String url				=	"../../eCommon/jsp/commonToolbar.jsp?";
	String params			=	checkForNull(request.getQueryString());
	String facilityId		=	checkForNull((String)session.getValue("facility_id"));
	String loginUser		=	checkForNull((String)session.getValue("login_user"));
	//String call_function	=	checkForNull((String)session.getValue("call_function"));
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
		
	String chg_nurs_unit_in_assign_bed_yn		=	"";

	sqlBuffer.append(url);
	sqlBuffer.append(params);
	String source			=	sqlBuffer.toString();
	
	Connection connection	=	null;
	ResultSet resultSet 	=	null; 
	Statement statement 	=	null;

	try
	{
		connection	= ConnectionManager.getConnection(request);
		statement	= connection.createStatement();		

		if (sqlBuffer.length() > 0)
			sqlBuffer.delete(0, sqlBuffer.length());
		sqlBuffer.append("select 1 from ip_param where facility_id = '");
		sqlBuffer.append(facilityId);
		sqlBuffer.append("' ");

		resultSet = statement.executeQuery(sqlBuffer.toString()) ;
		
		if((resultSet != null) && (resultSet.next()))
		{
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','ASSIGN_BED_YN') FROM dual") ;
			resultSet.next();
	     	String OsVal=resultSet.getString(1);
            if(OsVal.equals("1"))
			{
			out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else if(OsVal.equals("2"))
			{
				 /*if(call_function.equals("TransferPatient")){

				out.print(" <script>alert(getMessage(' ASSIGN_BED_USER_ACCESS,'IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else {*/
			out.print(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			//}
			}else  if(OsVal.equals("3"))
			{
			out.print(" <script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
			if(OsVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
			else	if(!OsVal.equals(""))
			{	

			
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(chg_nurs_unit_in_assign_bed_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
			
		}
		else
		{
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		if (resultSet != null) resultSet.close();
		if (statement != null) statement.close();

		}catch(Exception e)
		{
			//out.println("Exception in tryCatch : "+ e.toString());
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(resultSet!=null) resultSet.close();
				if(statement!=null) statement.close();

				if(connection != null)
				ConnectionManager.returnConnection(connection,request);
			}
			catch(Exception ee)
			{
				
				ee.printStackTrace();
			}
		}
	
            _bw.write(_wl_block10Bytes, _wl_block10);
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
