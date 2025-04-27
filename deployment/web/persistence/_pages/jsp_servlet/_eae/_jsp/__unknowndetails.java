package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __unknowndetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/UnknownDetails.jsp", 1709719739987L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eAE/js/UpdateUnknownDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t\tvar errortext = getMessage(\'DR_NOT_INSTALLED\',\'Common\');\n\t        alert(errortext);\n\t\t\tdocument.location.href= \'../../eCommon/jsp/dmenu.jsp\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\tvar errortext = getMessage(\'NO_USER_RIGHTS\',\'DR\');\n\t\t\talert(errortext);\n\t\t\tdocument.location.href= \'../../eCommon/jsp/dmenu.jsp\';\n\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script>\n\t\t\t\tvar errortext = getMessage(\'DR_PARAM_NOT_AVAILABLE\',\'DR\');\n\t\t\t\talert(errortext);\n\t\t\t\tdocument.location.href= \'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\t\tvar errortext = getMessage(\'DR_PROCESS_CYCLE\',\'DR\');\n\t\t\t\talert(errortext);\n\t\t\t\tdocument.location.href= \'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\n\t\t\t\tvar errortext = getMessage(\'DR_PROCESS_CYCLE\',\'DR\');\n\t\t\t\talert(errortext);\n\t\t\t\tdocument.location.href= \'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t</script> \n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=\'0\' scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eAE/jsp/UpdateUnknownDetails.jsp\' frameborder=\'0\' scrolling=\'no\' noresize style=\'height:83vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'no\' frameborder=\'0\' noresize style=\'height:9vh;width:100vw\'></iframe>\n\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String url					= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params				= request.getQueryString() ;
	String source				= url + params ;
	String check_rights			= "";
	boolean check_rights_flag	= false;
	
	Connection con				= null;
	PreparedStatement pstmt		=	null;
	ResultSet rs				= null;
	java.util.Properties p		= (java.util.Properties) session.getValue("jdbc" ) ;
	
	String proc_status	= "";
	String effstatus	= "";	 
	
	try
	{
        con					= ConnectionManager.getConnection(request);
	    String addedById	= p.getProperty( "login_user" ) ;
	    int p_count			= 0;
		StringBuffer sqlStr0=new StringBuffer();
		StringBuffer sqlStr = new StringBuffer();
		sqlStr0.append("SELECT install_yn  FROM sm_module where module_id='DR' ");
        String dr_install_yn="";
   		pstmt	= con.prepareStatement(sqlStr0.toString());
		rs		= pstmt.executeQuery();
		while(rs!=null  && rs.next())
		  {
						dr_install_yn		= rs.getString(1);
		  }
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
       if(dr_install_yn.equals("N"))
        
            _bw.write(_wl_block8Bytes, _wl_block8);
 else
		{
		sqlStr.append("select eff_status,merge_privilege_level from dr_user_rights  "); 
		sqlStr.append(" where appl_user_id= ? ");
		pstmt		=	con.prepareStatement(sqlStr.toString());
        pstmt.setString	(	1,	addedById		);
		rs			=	pstmt.executeQuery();	
		while (rs.next())
		{
			check_rights = rs.getString("merge_privilege_level");	
			effstatus    = rs.getString("eff_status");

			check_rights_flag = true;
		}
		if(rs !=null) rs.close();
        if(pstmt !=null) pstmt.close();
		if((sqlStr != null) && (sqlStr.length() > 0))
		{
			sqlStr.delete(0,sqlStr.length());
		}
	if (check_rights_flag == false || check_rights.equals("N") || effstatus.equals("D"))
	{

            _bw.write(_wl_block9Bytes, _wl_block9);

	}
		StringBuffer sqlStr1 = new StringBuffer();
		sqlStr1.append("select count(*) total from dr_param where module_id='DR' "); 
		pstmt		=	con.prepareStatement(sqlStr1.toString());
		rs			=	pstmt.executeQuery();	
		while (rs.next())
		{
			p_count = rs.getInt("total");	
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if (p_count == 0 )
		{
			
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		}
		StringBuffer sqlStr2 = new StringBuffer();
		sqlStr2.append("select proc_status  from dr_process_ctl  "); 
		pstmt		=	con.prepareStatement(sqlStr2.toString());
		rs			=	pstmt.executeQuery();
		while (rs.next())
		{
			proc_status = rs.getString("proc_status");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		if (proc_status.equals("S0") )
		{
	
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else if(proc_status.equals("S1") || proc_status.equals("S2") || proc_status.equals("M1") || proc_status.equals("M2") )
		{
	
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
		StringBuffer sqlStr3 = new StringBuffer();
		sqlStr3.append("select count(*) total from dr_process_ctl"); 
		pstmt		=	con.prepareStatement(sqlStr3.toString());
		rs			=	pstmt.executeQuery();
		while (rs.next())
		{
			p_count = rs.getInt("total");
		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if (p_count == 0)
		{
	
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
		if (rs!=null) rs.close();
		if (pstmt!=null) pstmt.close();
		}
}catch(Exception e){e.printStackTrace();}
finally
{
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(source));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
