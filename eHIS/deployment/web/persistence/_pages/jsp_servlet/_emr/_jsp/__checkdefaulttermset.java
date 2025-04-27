package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import webbeans.eCommon.*;
import eDS.Common.JSONObject;

public final class __checkdefaulttermset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/CheckDefaultTermset.jsp", 1709117043217L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="          \n            \n            \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	String locale				= (String)session.getAttribute("LOCALE");
	String facility_id			= (String) session.getValue( "facility_id" ) ;
	String defaulttermset		= request.getParameter("defaulttermset")==null?"":request.getParameter("defaulttermset");
	String mode					= request.getParameter("mode")==null?"":request.getParameter("mode");
	String diag_class_code		= request.getParameter("diag_class_code");
	int isDefaultAlreadyExists	= 0;
	
	PreparedStatement pstmt=null;
	ResultSet rs1=null;
	
	JSONObject json = new JSONObject();
	if(mode.equals("insert")){
		String sql = "select  count(*)  TotCount  from MR_DIAG_CLASS_DTL where TERM_SET_ID=? and DEFAULT_STATUS='Y'";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,defaulttermset);
		rs1 = pstmt.executeQuery();			
		if(rs1!=null && rs1.next()) {		 
			isDefaultAlreadyExists = rs1.getInt("TotCount");
		} 
	}else if(mode.equals("modify")){
		String sql = "select  count(*)  TotCount  from MR_DIAG_CLASS_DTL A, mr_diag_class B where TERM_SET_ID=?   AND a.diag_class_code = b.diag_class_code and A.DEFAULT_STATUS='Y' and B.DIAG_CLASS_CODE!=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,defaulttermset);
		pstmt.setString(2,diag_class_code);
		rs1 = pstmt.executeQuery();			
		if(rs1!=null && rs1.next()) {		 
			isDefaultAlreadyExists = rs1.getInt("TotCount");
		} 
	}

	if(pstmt != null) pstmt.close();
	if(rs1  != null) rs1.close();
	json.put("isDefaultAlreadyExists", isDefaultAlreadyExists);
	out.print(json);
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           

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
