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

public final class __fmtransferfile extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMTransferFile.jsp", 1738425678257L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- by Meghanath -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n\t<!-- <LINK rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script> <!-- Added by Sangeetha for GDOH-CRF-0133 -->\n\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\'></SCRIPT>\n\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n\t<SCRIPT language=\'javascript\' src=\'../../eFM/js/FMTransferFile.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<body>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=\'0\' scrolling=\'no\' noresize style=\'height:6vh;width:100vw\'></iframe>\n\t\t<FRAMESET cols=\"55%,45%\" border=0>\n\t\t<iframe name=\'transfer_from\' id=\'transfer_from\' src=\'../../eFM/jsp/FMTransferFileFrom.jsp?userSecurity=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Dflt_Archive_Locn=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Dflt_Lost_Locn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&accessAll=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&auto_rec_ward_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&auto_rec_clinic_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&auto_rec_pract_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&auto_rec_dept_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' frameborder=\'0\' scrolling=\'no\' noresize style=\'height:30%;width:50vw\'></iframe>\n\t\t<iframe name=\'transfer_to\' id=\'transfer_to\' src=\"../../eFM/jsp/FMTransferFileTo.jsp\" frameborder=\'0\' scrolling=\'no\' noresize style=\'height:16%;width:49vw\'></iframe>\n\t\t<iframe name=\'transfer_criteria\' id=\'transfer_criteria\' src=\'../../eCommon/html/blank.html\'  frameborder=\'0\' scrolling=\'no\' noresize style=\"width: 100%;height: 12.6vh;\"></iframe>\n\t\t<iframe name=\'transfer_detail\' id=\'transfer_detail\' src=\'../../eCommon/html/blank.html\' frameborder=\'0\' scrolling=\'auto\' noresize style=\"width:100%\"></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=\'0\' scrolling=\'no\'  noresize style=\"width: 100%;height: 10vh;position: absolute;bottom: 0;left: 0;\"></iframe>\n\t</FRAMESET>\n\t</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String url	  = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params;

	Connection con		= ConnectionManager.getConnection(request);

	PreparedStatement pstmt	= null;
	ResultSet rs			= null;

	String sql							= "";
	String sql1							= "";
	String locnIden						= "";
	String userSecurity					= "";
	String Dflt_archive_fs_locn_code	= "";
	String Dflt_lost_fs_locn_code		= "";
	String auto_rec_ward_yn				= "";
	String auto_rec_clinic_yn			= "";
	String auto_rec_pract_yn			= "";
   String auto_rec_dept_yn        ="";
	int userVal = 0;

	String facility_id	= (String) session.getValue("facility_id");
	String user_id		= (String) session.getValue("login_user");

	try
	{
		sql  = "SELECT transfer_file_yn, user_security_yn, dflt_archive_fs_locn_code, dflt_lost_fs_locn_code,auto_rec_ward_yn, auto_rec_clinic_yn, auto_rec_pract_yn ,auto_rec_dept_yn FROM fm_parameter WHERE facility_id = ? ";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		rs = pstmt.executeQuery();
		if(rs != null && rs.next())
		{
			locnIden					= rs.getString(1);
			userSecurity				= rs.getString(2);
			Dflt_archive_fs_locn_code	= rs.getString(3);
			Dflt_lost_fs_locn_code		= rs.getString(4);
			auto_rec_ward_yn			= rs.getString(5);
			auto_rec_clinic_yn			= rs.getString(6);
			auto_rec_pract_yn			= rs.getString(7);
		    auto_rec_dept_yn           = rs.getString(8);
		  }
		if(rs != null)    rs.close();
		if(pstmt != null) pstmt.close();
		
		if(locnIden == null || locnIden.equals("null"))	locnIden = "N";
		if(userSecurity == null || userSecurity.equals("null"))	userSecurity = "N";

		if(locnIden.equals("N"))
		{
			out.println("<SCRIPT>alert(getMessage(\"NO_TRANSFER_FILES\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </SCRIPT>");
		}
		if(userSecurity.equals("Y"))
		{
			sql1 = "SELECT 1 FROM fm_user_access_rights WHERE facility_id = ?  AND appl_user_id = ?  AND transfer_file_yn = 'Y' ";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,user_id);			

			rs = pstmt.executeQuery();

			if(rs != null && rs.next())
			{
				 userVal = rs.getInt(1);
			}
			if(userVal != 1)
			{
				out.println("<SCRIPT>alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';</SCRIPT>");
			}
		}
	if(rs	 !=null) rs.close();
	if(pstmt !=null) pstmt.close();
	}catch(Exception e){out.println("Exception e :"+e.toString());}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
if(session.getAttribute("user_name")!=null)
session.removeAttribute("user_name");


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Dflt_archive_fs_locn_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Dflt_lost_fs_locn_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(userVal));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(auto_rec_ward_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(auto_rec_clinic_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(auto_rec_pract_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(auto_rec_dept_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
