package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.CommonBean;
import java.util.HashMap;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;

public final class __instrumentcountvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/InstrumentCountValidation.jsp", 1709117262000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	String params = request.getQueryString();
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id		= (String) hash.get( "bean_id" );
	String bean_name	= (String) hash.get( "bean_name" );
	String facility_id	= (String)session.getValue("facility_id");
	String booking_num	= (String)hash.get("booking_num");
	String oper_num		= (String)hash.get("oper_num");
	String patient_id	= (String)hash.get("patient_id");
	String set_code		= (String)hash.get("set_code");
	String oper_code	= (String)hash.get("oper_code");
	String tray_num		= (String)hash.get("tray_num");
	String func_mode= request.getParameter("func_mode");
try{
	if(func_mode!= null && func_mode.equals("item_confirm")){
		String initial_status_cmpl_yn	= (String)hash.get("initial_status_cmpl_yn");
		String final_status_cmpl_yn		= (String)hash.get("final_status_cmpl_yn");
		int tot_count			= Integer.parseInt((String)hash.get("tot_count"));
		String item_code= "", cssd_qty = "", open_qty = "",initial_status	= "",return_qty		= "",final_status		= "",finalized_yn		= "",initial_remarks	= "",final_remarks	= "",general_remarks	= "";
		booking_num	=booking_num==null?"":booking_num;
		booking_num	=booking_num.equalsIgnoreCase("null")?"":booking_num;
		oper_num	=oper_num==null?"":oper_num;
		oper_num	=oper_num.equalsIgnoreCase("null")?"":oper_num;
		InstrumentCountBean bean = (InstrumentCountBean)mh.getBeanObject( bean_id, request, bean_name );
		HashMap set_map = new HashMap();
		HashMap new_set_map = new HashMap();
		HashMap temp_map = new HashMap();
		set_map=bean.getSetDetails(oper_code+set_code+tray_num);
		for(int i=1;i<=tot_count;i++){
			temp_map = (HashMap)set_map.get(i+"");
			item_code 		= (String)hash.get("item_code_"+i);
			cssd_qty		= (String)hash.get("cssd_qty_"+i);
			open_qty		= (String)hash.get("open_qty_"+i);
			initial_status	= (String)hash.get("initial_status_"+i);
			return_qty		= (String)hash.get("return_qty_"+i);
			final_status	= (String)hash.get("final_status_"+i);
			finalized_yn	= (String)hash.get("finalized_yn_"+i);
			initial_remarks	= (String)hash.get("initial_status_remarks_"+i);
			initial_remarks=java.net.URLDecoder.decode(initial_remarks,"UTF-8");
			final_remarks	= (String)hash.get("final_remarks_"+i);
			final_remarks=java.net.URLDecoder.decode(final_remarks,"UTF-8");
			general_remarks	= (String)hash.get("general_remarks_"+i);
			general_remarks=java.net.URLDecoder.decode(general_remarks,"UTF-8");
			temp_map.put("CSSD_QTY",cssd_qty);
			temp_map.put("OPEN_QTY",open_qty);
			temp_map.put("INITIAL_STATUS",initial_status);
			temp_map.put("RETURN_QTY",return_qty);
			temp_map.put("INITIAL_STATUS_REMARKS",initial_remarks);
			temp_map.put("FINAL_STATUS",final_status);
			temp_map.put("FINAL_REMARKS",final_remarks);
			temp_map.put("GENERAL_REMARKS",general_remarks);
			temp_map.put("INITIAL_STATUS_CMPL_YN",initial_status_cmpl_yn);
			temp_map.put("FINAL_STATUS_CMPL_YN",final_status_cmpl_yn);			
			temp_map.put("UPDATE_FLAG","Y");
			new_set_map.put(i+"",temp_map);
		}
		bean.removeSetDetails(set_code+tray_num+item_code);
		bean.storeSetDetails(set_code+tray_num+item_code,new_set_map);
		}else if(func_mode!= null && func_mode.equals("check_tray_duplication")){
			Connection connection   = null ;
			PreparedStatement pstmt = null ;
			ResultSet rs = null ;
			try{
				int tray_exists = 0;
				String sql	= "SELECT COUNT(*) TRAY_EXISTS FROM OT_STORE_ISSUE_HDR WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID=? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))  AND OPER_NUM=? AND SET_CODE=? AND TRAY_NUM =?";
				connection	= ConnectionManager.getConnection(request);
				pstmt	= connection.prepareStatement(sql) ;
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,booking_num);
				pstmt.setString(4,oper_num);
				pstmt.setString(5,set_code);
				pstmt.setString(6,tray_num);
				rs		= pstmt.executeQuery();
				while(rs!=null && rs.next()){
					tray_exists = rs.getInt("TRAY_EXISTS");
				}
				// The below codes are passed to JS only to check the validation.
				// DUPLICATE_FOUND and NO_DUPLICATE_FOUND are not message keys.
				if(tray_exists>0){
					out.println("DUPLICATE_FOUND");
				}else{					
					out.println("NO_DUPLICATE_FOUND");
				}								
			}catch ( Exception e ) {
				System.err.println("Caught Exception error in InstrumentCountCreateSet: "+e);
				e.printStackTrace() ;
			}finally {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(connection!=null) ConnectionManager.returnConnection(connection,request);
			}
		}
	}catch( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountValidation: "+e);
		e.printStackTrace();
	}finally {
		try{
		}catch(Exception es){es.printStackTrace();}
	}

            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
