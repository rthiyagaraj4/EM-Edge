package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.*;
import eOT.Common.*;

public final class __collectduration extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/CollectDuration.jsp", 1724306016000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);

	String catalog_code=""+request.getParameter("catalog_code");
	String duration="";
	String strSurgeonCode="";
	String strOperationCode="";
	String flag=request.getParameter("flag");
	String sql="";
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
try{
	conn = ConnectionManager.getConnection(request);
	if(flag.equals("1")==true){
		sql=""+OTRepository.getOTKeyValue("SQL_OT_COLLECT_DURATION_SELECT1");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,catalog_code);
		rs = pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				duration=rs.getString("APPT_TIME1");
				duration+="::"+rs.getString("APPT_TIME2");
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();
		duration=duration.trim();
		out.print(duration);
	}else{
		/*			sql="SELECT AVG_SURGERY_TIME AVG_SURGERY_TIME1 FROM OT_SURG_OPER_AVG_TIME WHERE  PRACTITIONER_ID = ? AND OPER_CODE = ?";
		*/
		sql=""+OTRepository.getOTKeyValue("SQL_OT_COLLECT_DURATION_SELECT2");
		strSurgeonCode=request.getParameter("surgeonCode");
		strOperationCode=request.getParameter("operationCode");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,strSurgeonCode);
		pstmt.setString(2,strOperationCode);
		rs = pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				duration=rs.getString("AVG_SURGERY_TIME1");
			}
			out.print(duration);
		}
		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();
	}
}catch(Exception expSQL){
	System.err.println(expSQL);
}finally{
	if(rs!=null) rs.close();
	if(pstmt!=null)	pstmt.close();
	ConnectionManager.returnConnection(conn, request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
