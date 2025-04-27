package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmfiledeficiencymonitoring extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMFileDeficiencyMonitoring.jsp", 1725267087500L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eFM/js/FMFileDeficiencyMonitoring.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=\'0\' scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe name=\'deficiency_header\' id=\'deficiency_header\' src=\'../../eFM/jsp/FMFileDeficiencyMonitoringHeader.jsp?userSecurity=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&access_all=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&dflt_incomplete_fs_locn_code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&mntr_fldfcy_inc_fslocn_ntdf_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'frameborder=\'0\' noresize scrolling=\'no\' style=\'height:20vh;width:100vw\'></iframe>\n\t<iframe name=\'deficiency_result\' id=\'deficiency_result\' src=\'../../eCommon/html/blank.html\' noresize frameborder=\'0\' scrolling=\'no\' noresize style=\'height:20vh;width:100vw\'></iframe>\n\t<iframe name=\'deficiency_detail\' id=\'deficiency_detail\' src=\'../../eCommon/html/blank.html\' noresize frameborder=\'0\' scrolling=\'auto\' noresize style=\'height:20vh;width:100vw\'></iframe>\n\t<iframe name=\'deficiency_detail_add\' id=\'deficiency_detail_add\' src=\'../../eCommon/html/blank.html\' frameborder=\'0\'noresize scrolling=\'no\' noresize style=\'height:20vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'no\' frameborder=\'0\' noresize style=\'height:12vh;width:100vw\'></iframe>\n\t\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
	
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

	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params;

	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	
	

	String facility_id	= (String) session.getValue("facility_id");
	String user_id		= (String) session.getValue("login_user");

	
	String sql				= "";
	String userSecurity		= "";
	String access_all		= "";
	String dflt_incomplete_fs_locn_code = "";
	String mntr_fldfcy_inc_fslocn_ntdf_yn = "";

	int userVal		= 0;
	int checkVal	= 0;

	try
	{
		stmt = con.createStatement();
		sql  = "Select COUNT(*) cnt from SM_MODULE where module_id='IP' and INSTALL_YN = 'Y' ";
		rs = stmt.executeQuery(sql);
		if(rs != null && rs.next())
		{
			userVal = rs.getInt(1);
		} if(rs != null) rs.close();
		
		if(userVal == 0)
		{
			out.println("<script> alert(getMessage(\"NO_ACCESS_FOR_DEFICIENCY\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
		}
		else
		{
			sql = "";
			sql = "Select USER_SECURITY_YN,DFLT_INCOMPLETE_FS_LOCN_CODE,MNTR_FLDFCY_INC_FSLOCN_NTDF_YN from FM_PARAMETER where facility_id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			rs = pstmt.executeQuery();

			if(rs != null && rs.next())
			{
				 userSecurity = rs.getString("USER_SECURITY_YN");
				 dflt_incomplete_fs_locn_code = rs.getString("DFLT_INCOMPLETE_FS_LOCN_CODE");
				 mntr_fldfcy_inc_fslocn_ntdf_yn = rs.getString("MNTR_FLDFCY_INC_FSLOCN_NTDF_YN");
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";
			if(dflt_incomplete_fs_locn_code == null || dflt_incomplete_fs_locn_code.equals("null")) dflt_incomplete_fs_locn_code = "";
			if(mntr_fldfcy_inc_fslocn_ntdf_yn == null || mntr_fldfcy_inc_fslocn_ntdf_yn.equals("null")) mntr_fldfcy_inc_fslocn_ntdf_yn = "";

			if(userSecurity.equals("Y"))
			{
				sql = "";
				sql = "Select 1 ,fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ?  and APPL_USER_ID = ? and DEFICIENCY_CHECK_YN = 'Y' ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,user_id);				
				rs = pstmt.executeQuery();

				if(rs != null && rs.next())
				{
					 checkVal = rs.getInt(1);
					 access_all = rs.getString("fs_locn_code");
				}

				if(checkVal != 1)
				{
					out.println("<script> alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
		}
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	if(pstmt!=null)	pstmt.close();
	}catch(Exception e){out.println(e);}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dflt_incomplete_fs_locn_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mntr_fldfcy_inc_fslocn_ntdf_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
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
