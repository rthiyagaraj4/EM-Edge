package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __termcodesearchmainframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TermCodeSearchMainFrame.jsp", 1732525072348L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<title>";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="</title>\n</head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<!-- <frameset rows=\'4%,*,10%\' id=\'TermCodeSearchMain\' name=\'TermCodeSearchMain\'> -->\n\t\t<iframe name=\'TermCodeSearchMainFrame\' id=\'TermCodeSearchMainFrame\' src=\"TermCodeSearchMain.jsp?";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&term_set_desc=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&sensitivity_appl_yn=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&age_group_appl_yn=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&notification_appl_yn=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&defn_levels=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&dfltSearchYn=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=no style=\"height:4vh;width:99vw\"></iframe>\n\t\t<!-- \n\t\t\tCommented On 10/20/2009.\n\t\t\tF.Y.I:1.Old code.\n\t\t-->\n\t\t<!-- <frame name=\'TermCodeSearchByFrame\' id=\'TermCodeSearchByFrame\' src=\"TermCodeSearchByCL.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" noresize  scrolling=no  frameborder=no  marginheight=0 marginwidth=0> -->\n\n\t\t<iframe name=\'TermCodeSearchByFrame\' id=\'TermCodeSearchByFrame\' src=\'../../eCommon/html/blank.html\'  noresize  frameborder=\"no\" scrolling=\"no\"  marginheight=\"0\" marginwidth=\"0\" style=\"height:88vh;width:99vw\"></iframe>\n\t\t\n\t\t<iframe name=\'TermCodeSearchToolbarFrame\' id=\'TermCodeSearchToolbarFrame\' src=\'TermCodeSearchToolbar.jsp\' noresize  frameborder=no marginheight=0 marginwidth=0 style=\"height:10vh;width:99vw\"></iframe>\n\t\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String sql = "";
	String age_group_appl_yn = "";
	String sensitivity_appl_yn = "";
	String term_set_desc = "";
	String notification_appl_yn = "";
	String defn_levels = "";
	String dfltSearchYn = "N";
	
	try
	{
		con=ConnectionManager.getConnection(request);
		
		String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	
		sql = "select AGE_GROUP_APPL_YN,SENSITIVITY_APPL_YN,TERM_SET_DESC,NOTIFICATION_APPL_YN ,DEFN_LEVELS,(select DFLT_TAB_IN_DIAG_SEL from mr_parameter) DFLT_TAB_IN_DIAG_SEL from mr_term_set where TERM_SET_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,term_set_id);
		rs = pstmt.executeQuery();

		
		while(rs.next())
		{
			age_group_appl_yn = rs.getString("AGE_GROUP_APPL_YN");
			sensitivity_appl_yn = rs.getString("SENSITIVITY_APPL_YN");
			term_set_desc = rs.getString("TERM_SET_DESC");
			notification_appl_yn = rs.getString("NOTIFICATION_APPL_YN");
			defn_levels = rs.getString("DEFN_LEVELS");
			dfltSearchYn = rs.getString("DFLT_TAB_IN_DIAG_SEL");
			
		}
	}
	catch(Exception e){
		 e.printStackTrace();
	}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	}



            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block2Bytes, _wl_block2);

	String queryString=request.getQueryString();
		//out.println("<script>alert(\"option_id 1888 :"+queryString+"\");</script>");			


	

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sensitivity_appl_yn));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(age_group_appl_yn));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(notification_appl_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(defn_levels));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dfltSearchYn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sensitivity_appl_yn));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(age_group_appl_yn));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(notification_appl_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(defn_levels));
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
