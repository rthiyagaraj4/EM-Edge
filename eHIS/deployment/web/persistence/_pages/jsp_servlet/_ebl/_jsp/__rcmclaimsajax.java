package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.sql.*;
import eBL.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.util.*;

public final class __rcmclaimsajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/RCMClaimsAjax.jsp", 1709114145411L ,"10.3.6.0","Asia/Calcutta")) return true;
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

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String functionMode="";
	try{
	    con = ConnectionManager.getConnection();
		String facilityId = (String) session.getValue("facility_id");
		String loginUser = (String) session.getValue("login_user");
		functionMode = request.getParameter("functionMode");
		if (null == functionMode) {
			functionMode = "";
		}
		if(functionMode.equals("SinglePDF")){
			String rcmid = request.getParameter("rcmid");
			System.out.println("rcmid " + rcmid); 
			String locale = request.getParameter("locale");
			String file_name="";
			String file_path="";
			String obj="";
			 try {
				pstmt=con.prepareStatement("select file_path,file_name from BL_RCM_DATA_ENC_DTL hdr where hdr.rcm_id='"+rcmid+"' and hdr.operating_facility_id = '"+facilityId+"'");			
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					file_name =rs.getString("file_name");
					file_path =rs.getString("file_path");
				}
				if (null == file_name) {
					file_name = "";
				}
				if (null == file_path) {
					file_path = "";
				}
				if(file_name!="" && file_path!="" ){
					obj=file_path+"\\"+file_name;
					System.out.println("rcm file_path " + obj); 
					System.out.println("obj " + obj); 
					obj= obj.replaceAll("\\\\", "/");
					System.out.println("obj  1 " + obj); 
					out.println(obj);
				}else{
					System.out.println("else rcm folder click"); 
					out.println(obj);
				}
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("rcm file_path exception " + e);
			} 
			
			
			//out.println(obj);
		}
	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception from BLCommonAjax :" + e);
	} finally {
		ConnectionManager.returnConnection(con, request);
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
