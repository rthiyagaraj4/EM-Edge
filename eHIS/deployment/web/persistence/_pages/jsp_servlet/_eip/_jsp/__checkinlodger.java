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
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __checkinlodger extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/CheckinLodger.jsp", 1724078161283L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\t\t<script>\n\t\t\tfunction reset()\n\t\t\t{\n\t\t\t\tframes[1].document.forms[0].reset();\n\t\t\t\tframes[1].document.forms[0].search.disabled = false;\n\t\t\t\tframes[2].location.href = \'../../eCommon/html/blank.html\';\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t</head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'CheckInLodgerCriteriaFrame\' id=\'CheckInLodgerCriteriaFrame\' \tsrc=\'../jsp/InpatientLookupCriteria.jsp?function_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&call_function=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&oper_stn_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&chk_in_lodger_max_period=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:25vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'CheckInLodgerResultFrame\' id=\'CheckInLodgerResultFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:60vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</html>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	InPatient Management..(IP)
/// Func Name / ID	:	Check-In Loder / CHECK_IN_LODGER
/// Developer		:	SRIDHAR R
/// This File is called on the click of CheckIn Lodger Menu..
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			String call_function = request.getParameter("function_id");
			if(call_function == null) call_function = "";
		
            _bw.write(_wl_block8Bytes, _wl_block8);

		request.setCharacterEncoding("UTF-8");
		String url				= "../../eCommon/jsp/commonToolbar.jsp?"; 
		String params			= request.getQueryString();
		String source			= url + params ;
		String loginUser		= (String)session.getValue("login_user");
		String facility			= (String) session.getValue( "facility_id" ) ;
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
		Connection con			= null;
		ResultSet rs 			= null; 
		//Statement stmt 			= null;
		PreparedStatement pstmt = null;
        //ResultSet rset     = null;
		String chk_in_lodger_max_period	= "";
		String retVal           = "";
		try
		{
			con = ConnectionManager.getConnection(request);
			//stmt = con.createStatement(); PE_EXE venkat s
			//rs = stmt.executeQuery("select CHK_IN_LODGER_MAX_PERIOD from ip_param where facility_id='"+facility+"' ") ;
			pstmt = con.prepareStatement("select CHK_IN_LODGER_MAX_PERIOD,(AM_OPER_STN_ACCESS_CHECK(?,?,'N','','CHECK_LODGER_YN')) retVal from ip_param where facility_id='"+facility+"'");
			pstmt.setString(1,facility);
		    pstmt.setString(2,loginUser);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next())
			{
			
			chk_in_lodger_max_period = rs.getString("CHK_IN_LODGER_MAX_PERIOD");
			if(chk_in_lodger_max_period == null) chk_in_lodger_max_period ="0";
			retVal = rs.getString("retVal");



			//if(rset.next())
			//{
			//	retVal = rset.getString(1);
		//	}
	      if(retVal.equals("1")){
				out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
			else if(retVal.equals("2")){
				out.println(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
            }
			else if(retVal.equals("3")){
					out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
	                out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
            }else  if(retVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(retVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
            else if((!retVal.equals("1")) && (!retVal.equals("2")) && (!retVal.equals("3")) && (!retVal.equals("4")) && (!retVal.equals("5")))
            {		
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(retVal));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(chk_in_lodger_max_period));
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
			}
			else
				out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();

		}
		catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
		finally
		{
			try
			{
			if(rs!=null)			rs.close();
			//if(stmt!=null)			stmt.close();
			//if(rset!=null)			rset.close();
			if(pstmt!=null)			pstmt.close();
			}
			catch(Exception e)
			{out.println("Exception in tryCatch : "+ e.toString());}
			ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
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
