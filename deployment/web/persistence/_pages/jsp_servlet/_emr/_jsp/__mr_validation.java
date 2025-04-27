package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;

public final class __mr_validation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MR_validation.jsp", 1709117062514L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t\n";
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

	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	try
	{
		
	con = ConnectionManager.getConnection(request);
		request.setCharacterEncoding("UTF-8");
		String termsetid=request.getParameter("termsetid");
		String callfunction=request.getParameter("callfunction");
		String sensitive_yn="";
		String notifiable_yn="";
		String diag_spec_yn="";
		String proc_spec_yn="";

		if(callfunction.equals("sensvity/notifiable")){
			String querySen_notif="select SENSITIVITY_APPL_YN,NOTIFICATION_APPL_YN,DIAG_SPEC_YN,PROC_SPEC_YN from  MR_TERM_SET  where  term_set_id =?";
			
			
			pstmt = con.prepareStatement(querySen_notif);
			pstmt.setString(1,termsetid);
			rs = pstmt.executeQuery() ;
			if(rs!=null)
		{
			if(rs.next())
			{
				sensitive_yn = rs.getString("SENSITIVITY_APPL_YN");
				notifiable_yn = rs.getString("NOTIFICATION_APPL_YN");
				/*Monday, January 25, 2010 18499 , 18499*/
				diag_spec_yn = rs.getString("DIAG_SPEC_YN");
				if(diag_spec_yn == null) diag_spec_yn = "N";
				proc_spec_yn = rs.getString("PROC_SPEC_YN");
				if(proc_spec_yn == null) proc_spec_yn = "N";
				/**/
			}
		}
		
		if (rs != null)   rs.close();
					pstmt.close();
						

		}

		if(callfunction.equals("sensvity/notifiable")){

			/*Monday, January 25, 2010 18499 , 18499*/
			//out.println(sensitive_yn+"&^&"+notifiable_yn);
			out.println(sensitive_yn+"&^&"+notifiable_yn+"&^&"+diag_spec_yn+"&^&"+proc_spec_yn);
		}
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	finally{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
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
