package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;
import eXH.*;

public final class __applicationaddmodifymastermain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ApplicationAddModifyMasterMain.jsp", 1733056853495L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script language=\'javascript\' src=\'../../eXH/js/Validate.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eXH/js/DomainApplication.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=\'no\' noresize\tstyle=\'height: 8vh; width: 100vw\'></iframe>\n<iframe name=\'hr_menu_bar\' id=\'hr_menu_bar\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\' style=\'height: 1vh; width: 100vw\'></iframe>\n<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\' style=\'height: 78vh; width: 100vw\'></iframe>\n<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/MstCodeError.jsp\' frameborder=0 noresize scrolling=\'no\' style=\'height: 7vh; width: 100vw\'></iframe>\n</html>\n\n\n\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block3Bytes, _wl_block3);

	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;
	//		System.out.println("source : "+source);
	String function_id = XHDBAdapter.checkNull(request
			.getParameter("function_id"));
	//		System.out.println("function_id : "+function_id);
	session.setAttribute("function_id", function_id);

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	Statement stmt1 = null;
	ResultSet rs1 = null;

	String sql1 = "select 1 from SM_MENU_DTL where submenu_id='XH_JG_DEVELOPMENT_CONFIG' ";
	String sql2 = "SELECT 1 FROM SM_MENU_RSTRN_RESP WHERE submenu_id='XH_JG_DEVELOPMENT_CONFIG' ";

	try {
		con = ConnectionManager.getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql1);
		if (rs.next()) {
			//					System.out.println("rs.next 1: ");
			stmt1 = con.createStatement();
			rs1 = stmt.executeQuery(sql2);
			if (rs1.next()) {
				//				  System.out.println("rs.next :2 ");
			} else {
				params = params.substring(0, params.length() - 12);
				source = url + params + "access=YYYYY";
				//				  System.out.println("flag source : "+source);
			}
		}
	} catch (Exception e) {
		e.printStackTrace(System.err);
	} finally {
		con.commit();
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (rs1 != null)
			rs1.close();
		if (stmt1 != null)
			stmt1.close();
		if (con != null)
			con.close();
	}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(source));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
