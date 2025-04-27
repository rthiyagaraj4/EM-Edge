package jsp_servlet._emo._jsp;

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
import com.ehis.util.*;

public final class __getdetailsmo extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/getdetailsMO.jsp", 1709116973064L ,"10.3.6.0","Asia/Calcutta")) return true;
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

// This file added by dharma this file retruns only a json array....
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	String locale					= (String)session.getAttribute("LOCALE");
	String facility_id				= (String) session.getValue( "facility_id" ) ;
	String action					= request.getParameter("action")==null?"":request.getParameter("action");
	String patient_id				= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	int rowcnt					= 0;
	
	PreparedStatement pstmt			= null;
	ResultSet rs					= null;
	JSONObject json 				= new JSONObject();
	if(action.equals("get_service_details")){
		String dept_code				= request.getParameter("dept_code")==null?"":request.getParameter("dept_code");
		String recordslist			= "";

		String service_code					= "";
		String short_desc					= "";
	
		
		String  sql = "select SERVICE_CODE, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2) short_desc from AM_FACILITY_SERVICE_VW a where eff_status='E' and operating_facility_id=? and dept_code=? order by short_desc";
		pstmt		= conn.prepareStatement(sql.toString());
		pstmt.setString(1,facility_id);
	 	pstmt.setString(2,dept_code);
	  	rs = pstmt.executeQuery();
		JSONArray JsonlistArr = new JSONArray();
		while(rs.next()){
	 		JSONObject jsonobj		= new JSONObject();
	 		service_code			= rs.getString("service_code");
	 		short_desc				= rs.getString("short_desc");
	 		jsonobj.put("service_code",service_code);
	 		jsonobj.put("short_desc",short_desc);
			JsonlistArr.put(jsonobj);
			rowcnt++;
		}
		if(rowcnt>0){
			recordslist = JsonlistArr.toString();	
		}
		if(pstmt != null) pstmt.close();
		if(rs  != null) rs.close();
		json.put("recordslist", recordslist);
		json.put("rowcnt", rowcnt);
		out.print(json);
	}else if(action.equals("get_embalm_completed_status")){
		String  sql = "select 1 from mo_embalm_service where EMBALM_AT_HOSPITAL_YN = 'Y' and embalm_status < '04' and patient_id = ?  and facility_id = ?";
		pstmt		= conn.prepareStatement(sql.toString());
		pstmt.setString(1,patient_id);
	 	pstmt.setString(2,facility_id);
	  	rs = pstmt.executeQuery();
		while(rs.next()){
			rowcnt++;
		}
		if(pstmt != null) pstmt.close();
		if(rs  != null) rs.close();
		json.put("rowcnt", rowcnt);
		out.print(json);
	}
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
