package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;

public final class __tempencounterlkup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/TempEncounterLkup.jsp", 1724855122000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n";
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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
		String locale = (String)session.getAttribute("LOCALE");
		String encounter_id = request.getParameter("encounter_id");
		String patient_class = request.getParameter("patient_class");
		String facility_id = (String)session.getAttribute("facility_id");
		String result="";
		String locn_type="";
		String locn_code="";
		String locn_desc="";

		String SQL ="SELECT ASSIGN_CARE_LOCN_TYPE,ASSIGN_CARE_LOCN_CODE  FROM PR_ENCOUNTER WHERE FACILITY_ID=?  AND ENCOUNTER_ID=?";

		String location_desc1="SELECT LONG_DESC FROM IP_NURSING_UNIT_LANG_VW WHERE FACILITY_ID=? AND LANGUAGE_ID=? AND NURSING_UNIT_CODE=?";

		String location_desc2="	SELECT LONG_DESC FROM OP_CLINIC_LANG_VW WHERE FACILITY_ID=? AND LANGUAGE_ID=? AND CLINIC_CODE=?";
				
		String NURSING_UNIT_DESC = ("IP".equals(patient_class) || "DC".equals(patient_class))? location_desc1:location_desc2;

		if("XT".equals(patient_class)){
			out.println("R@''@''");
			return;
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			rst = pstmt.executeQuery();
			while(rst.next()){
				 locn_type=rst.getString(1);
				 locn_code=rst.getString(2);
			}
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();

			pstmt = con.prepareStatement(NURSING_UNIT_DESC);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);
			pstmt.setString(3,locn_code);
			rst = pstmt.executeQuery();
			while(rst.next()){
				 locn_desc=rst.getString(1);
			}
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			result=locn_type+"@"+locn_code+"@"+locn_desc;
			out.println(result);
		}catch(Exception e){
			System.err.println("Err Msg in TempEncounterLkup.jsp"+e.getMessage());
			out.println(e);
		} finally{
			try{
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
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
