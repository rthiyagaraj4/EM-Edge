package jsp_servlet._eop._jsp;

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
import eDS.Common.JSONArray;

public final class __checkblockscheduleforpract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/Checkblockscheduleforpract.jsp", 1709117134504L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
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
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id		= (String) session.getValue( "facility_id" ) ;
		String pract_id			= request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String block_date		= request.getParameter("block_date")==null?"":request.getParameter("block_date");
		String block_time		= request.getParameter("block_time")==null?"":request.getParameter("block_time");
		String clinic_code		= request.getParameter("cl_code")==null?"":request.getParameter("cl_code");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		if(block_time.equals("")){
			String sql = "select to_char(sysdate,'hh24:mi:ss') SysTime from dual";
			pstmt = conn.prepareStatement(sql);
			//System.err.println("sql==>"+sql);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				block_time		= rs.getString("SysTime");
			}
			if(pstmt != null) pstmt.close();
			if(rs  != null) rs.close();
		}
		
		boolean isJsonResults		= false;
		JSONObject json = new JSONObject();
		
		String sql1	= "SELECT 1 FROM oa_block_appt WHERE block_date = TO_DATE (?, 'dd/mm/yyyy') AND facility_id = ? AND practitioner_id = ?  AND TO_DATE (TO_CHAR (effective_from_date_time, 'dd/mm/yyyy') || ?,'dd/mm/yyyy hh24:mi:ss') BETWEEN effective_from_date_time AND effective_to_date_time AND CLINIC_CODE=?";
		pstmt = conn.prepareStatement(sql1);
		
		pstmt.setString(1,block_date);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,pract_id);
		pstmt.setString(4,block_time);
		pstmt.setString(5,clinic_code);
		//System.err.println("sql1==>"+sql1);
		rs = pstmt.executeQuery();
		if(rs!=null && rs.next()){
			isJsonResults	= true;	
		}
		if(!isJsonResults){
			if(pstmt != null) pstmt.close();
			if(rs  != null) rs.close();
		
			String sql2	= "SELECT SCHEDULE_STATUS FROM oa_clinic_schedule WHERE clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND practitioner_id = ? AND facility_id	= ? and schedule_status='B' AND CLINIC_CODE=?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1,block_date);
			pstmt.setString(2,pract_id);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,clinic_code);
			rs = pstmt.executeQuery();
			//System.err.println("sql2==>"+sql2);
			if(rs!=null && rs.next()){
				isJsonResults	= true;	
			}
		}
		json.put("isJsonResults", isJsonResults);
		json.put("block_time", block_time);
		out.print(json);
		if(pstmt != null) pstmt.close();
		if(rs  != null) rs.close();
		
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
