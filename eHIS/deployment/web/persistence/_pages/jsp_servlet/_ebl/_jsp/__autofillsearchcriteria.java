package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.Common.BlRepository;
import java.util.HashMap;
import java.util.Properties;
import eBL.PolicyInsuranceMasterBean;
import java.sql.Date;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;

public final class __autofillsearchcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AutoFillSearchCriteria.jsp", 1731317405423L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection();	
	con.setAutoCommit(false);
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String func_id = request.getParameter("func_id") == null ? "" :request.getParameter("func_id") ;
	String mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
	String autoFillSearchList = request.getParameter("autoFillSearchList") == null ? "" :request.getParameter("autoFillSearchList") ;
	Properties p;
	String facilityId = "";
	String userId = "";
	String clienIpAddress="";
	String searchDispFields = "";
	int recordCount = 0;
	//HashMap<String,String> searchFieldMap = new HashMap<String,String> ();
	
try{

	facilityId	= (String) session.getValue( "facility_id" );
	p = (Properties) session.getValue( "jdbc" );
	clienIpAddress = p.getProperty("client_ip_address");
	userId = p.getProperty( "login_user" );

	String loadCriteriaQuery = 	BlRepository.getBlKeyValue("DFLT_SEARCH_LOAD_CRITERIA");
	String checkRecordCount = 	BlRepository.getBlKeyValue("DFLT_SEARCH_RECORD_COUNT");
	String insertNewCriteria = BlRepository.getBlKeyValue("DFLT_SEARCH_INSERT_NEW");
	String updateExistingCriteria = BlRepository.getBlKeyValue("DFLT_SEARCH_UPDATE_EXISTING");
									
	if("LoadCriteria".equals(mode)){
		pstmt = con.prepareStatement(loadCriteriaQuery);
		pstmt.setString(1, facilityId);
		pstmt.setString(2, userId);
		pstmt.setString(3, func_id);
		rst = pstmt.executeQuery();
		if(rst != null){
			while(rst.next()){
				searchDispFields = rst.getString("SEARCH_DISPL_FIELDS");
			}
		}
		
		if(searchDispFields == null){
			/*String searcfFieldsArr [] = searchDispFields.split(":::");
			for(int i=0;i<searcfFieldsArr.length;i++){
				String searcfIndFieldsArr[] = searcfFieldsArr[i].split("=");
				if(searcfIndFieldsArr.length == 2){
					searchFieldMap.put(searcfIndFieldsArr[0], searcfIndFieldsArr[1]);
				}				
			}*/
			searchDispFields = "";
		}
	}
	else if("SaveCriteria".equals(mode)){
		pstmt = con.prepareStatement(checkRecordCount);
		pstmt.setString(1, facilityId);
		pstmt.setString(2, userId);
		pstmt.setString(3, func_id);
		rst = pstmt.executeQuery();
		if(rst != null){
			while(rst.next()){
				recordCount = rst.getInt("Total");
			}
		}
		
		if(recordCount > 0){
			pstmt = con.prepareStatement(updateExistingCriteria);
			pstmt.setString(1, autoFillSearchList);
			pstmt.setString(2, userId);
			pstmt.setString(3, clienIpAddress);
			pstmt.setString(4, facilityId);
			pstmt.setString(5, facilityId);
			pstmt.setString(6, func_id);			
			pstmt.setString(7, userId);
			pstmt.execute();
		}
		else{
			pstmt = con.prepareStatement(insertNewCriteria);
			pstmt.setString(1, facilityId);
			pstmt.setString(2, func_id);
			pstmt.setString(3, userId);
			pstmt.setString(4, autoFillSearchList);
			pstmt.setString(5, userId);
			pstmt.setString(6, userId);
			pstmt.setString(7, clienIpAddress);
			pstmt.setString(8, clienIpAddress);
			pstmt.setString(9, facilityId);
			pstmt.setString(10, facilityId);
			pstmt.execute();
		}
		
		con.commit();
		searchDispFields = "Criteria Saved Successfully";
	}	
	out.println(searchDispFields);	
	}catch (Exception e) {
		e.printStackTrace() ;
		System.err.println("Exception from Auto Fill Search Criteria :"+e);
		con.rollback();
	}
	finally
		{	
			pstmt.close();//V210413
			rst.close();//V210413
			ConnectionManager.returnConnection(con, request);		
		}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
