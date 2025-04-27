package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCommon.Common.CommonBean;
import eOT.*;
import eOT.Common.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __tempconsentvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/TempConsentValidation.jsp", 1709117292000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	String order_id =CommonBean.checkForNull(request.getParameter("order_id")); 
	String patient_id =CommonBean.checkForNull(request.getParameter("patient_id"));

	//String SQL1="SELECT NVL(ORD_CONSENT_REQD_YN,'N') ORD_CONSENT_REQD_YN FROM  OR_ORDER WHERE ORDER_ID=?";
	//Below query is modified against Bru-HIMS-CRF-382

	String SQL1="SELECT NVL(ORD_CONSENT_REQD_YN,'N') ORD_CONSENT_REQD_YN FROM  OR_ORDER_LINE WHERE ORDER_ID=? order by 1"; // Added Against IN 57507
	
	String SQL2="SELECT REFUSAL_TYPE, REFUSED_PRACT_ID FROM OR_REFUSAL_ORDERABLE WHERE ORDER_ID =? AND PATIENT_ID=?";
	
	String sql_order_line = "SELECT ORDER_LINE_NUM FROM OR_ORDER_LINE WHERE ORDER_ID = ? AND ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('93','95','96','97','99'))";
	
	String sql_chk_consents = "SELECT 1 FROM OR_ORDER_LINE A WHERE ORDER_ID=? AND ORDER_LINE_NUM=? AND NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0) < = (SELECT COUNT(*) FROM OR_CONSENT_REF_DTL B WHERE ORDER_ID=A.ORDER_ID AND ORDER_LINE_NUM=A.ORDER_LINE_NUM)";

	//Below query is modified against Bru-HIMS-CRF-382
	//String sql_chk_consents = "SELECT 1 FROM OR_ORDER_LINE A WHERE ORDER_ID=? AND ORDER_LINE_NUM=? AND (SELECT COUNT(*) FROM OR_CONSENT_REF_DTL B WHERE ORDER_ID=A.ORDER_ID AND ORDER_LINE_NUM=A.ORDER_LINE_NUM) < = NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0) ";

	String consent_reqd_yn="";
	String refusal_type="";
	String practitioner_id="";
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_consent = null;
	ResultSet rst = null;
	ResultSet rst_order_line =null;
	boolean consent_flag = true;
	String order_line_num="";

	if(!order_id.equals("")){
		try{
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(SQL1);
				pstmt.setString(1,order_id);
				rst = pstmt.executeQuery();
				while(rst.next()){
					consent_reqd_yn = rst.getString(1);
				}
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(consent_reqd_yn.equals("Y")){
					pstmt = con.prepareStatement(SQL2);
					pstmt.setString(1,order_id);
					pstmt.setString(2,patient_id);
					rst = pstmt.executeQuery();
					while(rst.next()){
						refusal_type = CommonBean.checkForNull(rst.getString(1));
						practitioner_id =CommonBean.checkForNull(rst.getString(2));
					}
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();

				if(!refusal_type.equals("") && !practitioner_id.equals("") ){
					out.println("Patient has refused for this operation. Cannot proceed further");
					//APP-OT0093
				}else{
					//GETTING THE ORDER_LINE_NUMBERS
					pstmt = con.prepareStatement(sql_order_line);					
					pstmt.setString(1,order_id);
					rst_order_line = pstmt.executeQuery();
					int count=-1;
					pstmt_consent = con.prepareStatement(sql_chk_consents);					
					boolean cons = true;//Added against 57507
					//while(rst_order_line.next() && consent_flag==true){//Commented against 57507
					while(rst_order_line.next()){//Added against 57507
							order_line_num=rst_order_line.getString("ORDER_LINE_NUM");	
							//check all the concents are recorded or not
							if(rst!=null) rst.close();
							pstmt_consent.setString(1,order_id);
							pstmt_consent.setString(2,order_line_num);						
							rst = pstmt_consent.executeQuery();
						if(rst!=null && rst.next())
						{//Added against 57507
							//while(rst!=null && rst.next()){//Commented against 57507
							count=0;
							consent_flag = ("1".equals(checkForNull(rst.getString(1))))?true:false;  // commented Against IN 57507												
						}
						else
							{						
								cons=false;							
							}						
					if(rst!=null) rst.close();
					}
					if(rst_order_line!=null) rst_order_line.close();
					if(rst!=null) rst.close();
					if(pstmt!=null) pstmt.close();
					if(pstmt_consent!=null) pstmt_consent.close();

					if(count==-1 || consent_flag==false || cons == false){
					//if(count == 0){
						out.println("Consent is not taken for the patient");						
					}else{
						out.println("CONSENT_TAKEN");
					}
				}
			}else 
				out.println("CONSENT_NOT_REQUIRED");
		}catch(Exception e){
			System.err.println("Err Msg in TempConsentValidation.jsp "+e.getMessage());
		}finally{
			try{
				if(rst!=null) rst.close();
				if(rst_order_line!=null) rst_order_line.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt_consent!=null) pstmt_consent.close();

				if(con!=null) ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
		}
	}else
		out.println("ORDER_ID_NULL");	
   
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
