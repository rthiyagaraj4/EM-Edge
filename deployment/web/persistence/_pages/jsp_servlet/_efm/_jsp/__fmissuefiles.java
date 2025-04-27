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

public final class __fmissuefiles extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIssueFiles.jsp", 1733843577438L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eFM/js/FMIssueFiles.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t <iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=\'0\' scrolling=no noresize style=\'height:6vh;width:100vw\'></iframe> \n\t <iframe name=\'issue_header\' id=\'issue_header\' src=\'../../eFM/jsp/FMIssueFilesHeader.jsp?userSecurity=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&resLocnIdentities=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&refresh=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&file_doc=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&access_all=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&p_tracer_card_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&file_type_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&prev_menu=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&issue_file_refresh_interval=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'  frameborder=0 scrolling=\'no\'  noresize style=\'height:7vh;width:100vw\'></iframe>\n\t <iframe name=\'issue_tab\' id=\'issue_tab\' src=\'../../eCommon/html/blank.html\' frameborder=\'0\' scrolling=\'no\'  style=\'height:31vh;width:100vw\'></iframe>\n\t <iframe name=\'issue_detail\' id=\'issue_detail\' src=\'../../eCommon/html/blank.html\' frameborder=\'0\' scrolling=\'no\' noresize style=\'height:48vh;width:100vw\'></iframe>\n     <iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'no\' frameborder=\'0\' noresize style=\'position: absolute; bottom: 0; left: 0; width: 100vw; height:9vh; border: none;\'></iframe>\n\t \n</html>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eFM.FMFilesIssueCart FMIssueFilesCart= null;synchronized(session){
                FMIssueFilesCart=(webbeans.eFM.FMFilesIssueCart)pageContext.getAttribute("FMIssueFilesCart",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMIssueFilesCart==null){
                    FMIssueFilesCart=new webbeans.eFM.FMFilesIssueCart();
                    pageContext.setAttribute("FMIssueFilesCart",FMIssueFilesCart,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            eFM.FMIssueFileAddBean FMIssueFileAddBean= null;synchronized(session){
                FMIssueFileAddBean=(eFM.FMIssueFileAddBean)pageContext.getAttribute("FMIssueFileAddBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMIssueFileAddBean==null){
                    FMIssueFileAddBean=new eFM.FMIssueFileAddBean();
                    pageContext.setAttribute("FMIssueFileAddBean",FMIssueFileAddBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String url			= "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params	= request.getQueryString() ;
		String prev_menu	= checkForNull(request.getParameter("prev_menu"));
		String source	= url + params;
		
		Connection con					= ConnectionManager.getConnection(request);
		java.sql.Statement stmt		= null;
		PreparedStatement pstmt	= null;
		ResultSet rs						= null;
		
		String facility_id			= (String) session.getValue("facility_id");
		String user_id			= (String) session.getValue("login_user");

		String sql					= "";
		String userSecurity		= "";
		String resLocnIdentities	= "N";
		String refresh				= "5";
		String file_doc				= "";
		String file_type_yn			= "";
		String access_all			= "";
		String p_tracer_card_yn	= "";
		String issue_file_refresh_interval	= "";//Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014

		int userVal = 0;
		
		FMIssueFilesCart.clearCart();
	try
	{
		stmt = con.createStatement();

		sql = "select MAINTAIN_DOC_OR_FILE, file_type_appl_yn from mp_param"  ;
		//stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs != null && rs.next())
		{
			file_doc = rs.getString("MAINTAIN_DOC_OR_FILE");
			file_type_yn = rs.getString("file_type_appl_yn");
		} 
		if(rs!=null) rs.close();
		
		sql = "";
		//issue_file_refresh_interval added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014
		sql  = "Select USER_SECURITY_YN,print_tr_card_iss_from_mr_yn,issue_file_refresh_interval from FM_PARAMETER where facility_id = '"+facility_id+"' ";
		rs   = stmt.executeQuery(sql);
		if(rs != null && rs.next())
		{
			 userSecurity = rs.getString(1);
			 p_tracer_card_yn = rs.getString("print_tr_card_iss_from_mr_yn");
			 issue_file_refresh_interval	= (rs.getString("issue_file_refresh_interval")=="" || rs.getString("issue_file_refresh_interval")==null)?"":rs.getString("issue_file_refresh_interval");
		} if(rs!=null)	rs.close();

		if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";

		if(userSecurity.equals("Y"))
		{
			sql = "";				
			sql = "Select 1, fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ?  and APPL_USER_ID = ?  and (ISS_YN = 'Y' or ISS_ACROSS_FACILITIES_YN = 'Y')";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,user_id);			
			rs = pstmt.executeQuery();

			if(rs != null && rs.next())
			{
				 userVal = rs.getInt(1);
				 access_all = rs.getString("fs_locn_code");
			} 

				if(userVal != 1) 
			{
				out.println("<script> alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
			}
		}
	if(rs!=null)	rs.close();
	if(stmt!=null)  stmt.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){out.println("Exception e :"+e);}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
if(session.getAttribute("username")!=null)
session.removeAttribute("username");


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(refresh));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_doc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_tracer_card_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(prev_menu));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(issue_file_refresh_interval));
            _bw.write(_wl_block18Bytes, _wl_block18);
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
