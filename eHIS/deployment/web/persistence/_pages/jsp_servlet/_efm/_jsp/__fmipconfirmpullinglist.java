package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmipconfirmpullinglist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIPConfirmPullingList.jsp", 1726137192005L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMIPConfirmPullingList.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head> \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=\'0\' scrolling=no noresize style=\'height:7vh;width:100vw\'></iframe>\n\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eFM/jsp/FMIPConfirmPullingListMain.jsp?user_security_yn=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&access_all=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=\'0\' scrolling=\'no\' style=\'height:85vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'no\' frameborder=\'0\' noresize style=\'height:8vh;width:100vw\'></iframe>\n  <iframe name=\'submit_frame\' id=\'submit_frame\' src=\'../../eCommon/html/blank.html\' scrolling=\'no\' frameborder=\'0\' noresize style=\'height:0%;width:100vw\'></iframe>\n\n\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con	=	null;
	PreparedStatement pstmt	= null;
	Statement stmt	=	null;
	ResultSet rs	=	null;
	PreparedStatement stmt1=null;
	ResultSet rs1=null;
	String sql1 = "";
	String facility_id="", login_user="", sql="";
	String access_all = "";
	String user_security_yn="";

	
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		login_user	=	(String)session.getValue("login_user");
		String install_yn="";
		String row_count = "";		
		stmt	=	con.createStatement();
		
		sql=" Select install_yn from sm_module where module_id = 'IP' ";
		rs = stmt.executeQuery(sql);

		if(rs.next())
		{
			 install_yn = rs.getString("install_yn");
		}
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();

		if(install_yn == null || install_yn.equals("null"))
		install_yn = "N";

		if(install_yn.equals("Y"))
		{
			String fm_param_query="select user_security_yn from fm_parameter where facility_id=?";			
				
			pstmt	=	con.prepareStatement(fm_param_query);
			pstmt.setString(1,facility_id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				user_security_yn	=	rs.getString("user_security_yn");
			}
			if(rs!=null)	rs.close();
			if(pstmt!=null) pstmt.close();		
			
			if(user_security_yn.equals("Y"))
			{
				sql1 = "Select 1, fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ? and APPL_USER_ID = ? and TRACK_OUT_TO_IPW_YN = 'Y'";

				stmt1 = con.prepareStatement(sql1);
				stmt1.setString(1,facility_id);
				stmt1.setString(2,login_user);
				rs1   = stmt1.executeQuery();

				if(rs1.next())
				{
					row_count	=	rs1.getString(1);
					access_all = rs1.getString("fs_locn_code");
				}
				if(rs1!=null)	rs1.close();

				if(!row_count.equals("1"))
				{					
					out.println("<script> alert(getMessage('FM_NO_USER_RIGHTS','FM')); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
		}
		else
		{			
			out.println("<script> alert(getMessage('FM_NO_USER_RIGHTS','FM')); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");

		}
	if(pstmt!=null) pstmt.close();
	if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
		out.println("Exception while fetching connection :"+e);
	}
	finally
	{				
		ConnectionManager.returnConnection(con, request);
	}

if(session.getAttribute("user_name")!=null)
session.removeAttribute("user_name");
if(session.getAttribute("user_security_yn")!=null)
session.removeAttribute("user_security_yn");
if(session.getAttribute("sys_date")!=null)
session.removeAttribute("sys_date");



            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(user_security_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
