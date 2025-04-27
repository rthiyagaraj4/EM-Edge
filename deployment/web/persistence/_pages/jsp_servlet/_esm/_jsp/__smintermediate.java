package jsp_servlet._esm._jsp;

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
import eCommon.Common.*;
import org.json.simple.*;

public final class __smintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/SMIntermediate.jsp", 1723629494468L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action			=	(String) hash.get("action")==null?"":(String) hash.get("action");

	if (action.equals("validateFacility")){
		String gstin_facility	= (String) hash.get("gstin_facility");
		int GSTINFacCnt			= eSM.SMCommonBean.getGSTINFacilityCnt(conn,gstin_facility);	
		out.println(GSTINFacCnt);
	} 

	else if(action.equals("getLinkedADUserDetails")){
		PreparedStatement pstmt	= null;
		ResultSet  rs			= null;
		String loginID			= (String) hash.get("loginID");
		loginID					= java.net.URLDecoder.decode(loginID,"UTF-8");
		String active_dir_id	= "";
		String appl_user_id		= "";
		String appl_user_paswd	= "";
		String appl_user_pin	= "";
		String user_dtls		= "";

		try{
			
			String sql = " SELECT active_dir_id, appl_user_id, app_password.decrypt (appl_user_password) AS appl_user_password, app_password.decrypt (pin_no) AS appl_user_pin FROM sm_appl_user WHERE upper(active_dir_id) = upper('"+loginID+"') ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()){

				active_dir_id = rs.getString("active_dir_id")==null?"":rs.getString("active_dir_id");
				appl_user_id = rs.getString("appl_user_id")==null?"":rs.getString("appl_user_id");
				appl_user_paswd = rs.getString("appl_user_password")==null?"":rs.getString("appl_user_password");
				appl_user_pin = rs.getString("appl_user_pin")==null?"":rs.getString("appl_user_pin");
			}	
						
		}catch(Exception ex){
			System.err.println("Exception in getLinkedADUserDetails - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}

		user_dtls = active_dir_id+"~"+appl_user_id+"~"+appl_user_paswd;
		
		out.println(user_dtls);
	}

	else if(action.equals("getEMUserLinkedToADUserDetails")){
		PreparedStatement pstmt	= null;
		ResultSet  rs			= null;
		String loginID			= (String) hash.get("loginID");
		loginID					= java.net.URLDecoder.decode(loginID,"UTF-8");
		String lnkd_actv_dir_id	= "";
		
		try{
			
			String sql = " SELECT active_dir_id FROM sm_appl_user WHERE upper(appl_user_id) = upper('"+loginID+"') ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()){

				lnkd_actv_dir_id = rs.getString("active_dir_id")==null?"":rs.getString("active_dir_id");
			}	
						
		}catch(Exception ex){
			System.err.println("Exception in getEMUserLinkedToADUserDetails - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		
		out.println(lnkd_actv_dir_id);
	}

	else if(action.equals("getADAndEMUserYN")){
		PreparedStatement pstmt_ad	= null;
		ResultSet  rs_ad			= null;
		PreparedStatement pstmt_em	= null;
		ResultSet  rs_em			= null;
		String loginID				= (String) hash.get("loginID");
		loginID						= java.net.URLDecoder.decode(loginID,"UTF-8");
		String sql_ad				= "";
		String sql_em				= "";
		String active_dir_id		= "";
		String appl_user_id			= "";
		String ad_em_user_yn		= "N";

		try{
			
			sql_ad = " SELECT active_dir_id FROM sm_appl_user WHERE upper(active_dir_id) = upper('"+loginID+"') ";
			
			pstmt_ad = conn.prepareStatement(sql_ad);
			rs_ad = pstmt_ad.executeQuery();
			
			if(rs_ad != null && rs_ad.next()){
				active_dir_id = rs_ad.getString("active_dir_id")==null?"":rs_ad.getString("active_dir_id");
			}

			if(!active_dir_id.equals("")){
				sql_em = " SELECT appl_user_id FROM sm_appl_user WHERE upper(appl_user_id) = upper('"+loginID+"') and active_dir_id is null ";
			
				pstmt_em = conn.prepareStatement(sql_em);
				rs_em = pstmt_em.executeQuery();
				
				if(rs_em != null && rs_em.next()){
					appl_user_id = rs_em.getString("appl_user_id")==null?"":rs_em.getString("appl_user_id");
				}

				if(!appl_user_id.equals("")){
					ad_em_user_yn = "Y";
				}
			}
						
		}catch(Exception ex){
			System.err.println("Exception in getADAndEMUserYN - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt_ad !=null) pstmt_ad.close();
				if(pstmt_em !=null) pstmt_em.close();
				if(rs_ad !=null) rs_ad.close();
				if(rs_em !=null) rs_em.close();
			}
			catch(Exception fe){
			}
		}
				
		out.println(ad_em_user_yn);
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
