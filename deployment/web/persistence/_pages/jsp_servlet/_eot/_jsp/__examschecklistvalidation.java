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

public final class __examschecklistvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ExamsCheckListValidation.jsp", 1709120216000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
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
 
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	String facility_id = request.getParameter("facility_id");
	String order_id = request.getParameter("order_id");
	String patient_id = "";
	String patient_class = "";
	StringBuffer append_str = new StringBuffer();
	String sql = "";
	String patient_name = "";
	String encounter_id = "";
	String sex = "";
	String dob = "";
	String episode_type = "";
	String patient_class_desc = "";
	String data_count = "";
	String order_type_code ="";
	String ordered_date = "";
	append_str.append("::");
	try{
		connection = ConnectionManager.getConnection(request);
// GET THE PATIENT ID BASED FOR THE SELECTED ORDER_ID
		sql="SELECT PATIENT_ID, PATIENT_CLASS, ENCOUNTER_ID FROM OR_ORDER WHERE ORDER_CATEGORY = 'RD' AND ORDER_ID=?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,order_id);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			patient_id = resultset.getString("PATIENT_ID");
			patient_class = resultset.getString("PATIENT_CLASS");
			encounter_id = resultset.getString("ENCOUNTER_ID");
		}
		append_str.append(patient_id+"::");
		append_str.append(encounter_id+"::");

// GET THE PATIENT DETAILS


//Modifued by rajesh for displaying patient name in locale language
		sql ="SELECT decode (?,'en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH, DECODE(SEX,'F','Female','M','Male','Unknown') SEX FROM MP_PATIENT WHERE PATIENT_ID=?";
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,patient_id);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			patient_name = resultset.getString("SHORT_NAME");
			sex = resultset.getString("SEX");
			dob = resultset.getString("DATE_OF_BIRTH");
		}
		append_str.append(patient_name+"::");
		append_str.append(sex+"::");
		append_str.append(dob+"::");

// GET THE PATIENT CLASS DESCRIPTION
		sql = "SELECT EPISODE_TYPE, SHORT_DESC FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = ?"; 

		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,patient_class);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			episode_type = resultset.getString("EPISODE_TYPE");
			patient_class_desc = resultset.getString("SHORT_DESC");
		}
		append_str.append(episode_type+"::");
		append_str.append(patient_class+"::");
		append_str.append(patient_class_desc+"::");	


// CHECK WHETHER DATA EXISTS OR NOT FOR THE SELECTED ORDER_ID
		sql = "SELECT COUNT(*) DATA_COUNT FROM RD_REQUEST_CHECK_LSIT_HDR WHERE OPERATING_FACILITY_ID = ? AND CHECK_LIST_REF=? AND CHECK_LIST_SRL='1'"; 

		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,order_id);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			data_count = resultset.getString("DATA_COUNT");
		}
		if(data_count.equals("1")){
			append_str.append("DATA_EXISTS::");
			sql = "SELECT NVL(COMPLETED_BY_ID,'##') COMPLETED_BY_ID FROM RD_REQUEST_CHECK_LSIT_HDR WHERE OPERATING_FACILITY_ID = ? AND CHECK_LIST_REF=? AND CHECK_LIST_SRL=1"; 

			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();		
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,order_id);
			resultset=pstmt.executeQuery();
			String completed_by_id = "";
			while(resultset.next()){
				completed_by_id = resultset.getString("COMPLETED_BY_ID");
			}
			if(completed_by_id.equals("##"))
				append_str.append("N::");	
			else
				append_str.append("Y::");	
		}else{
			append_str.append("NO_DATA_EXISTS::");
			append_str.append("N::");	
		}
// GET THE ORDER_TYPE_CODE
		sql="SELECT TO_CHAR(ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') ORD_DATE_TIME, ORDER_TYPE_CODE FROM OR_ORDER WHERE ORDER_CATEGORY = 'RD' AND ORDER_ID=?";
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,order_id);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			order_type_code = resultset.getString("ORDER_TYPE_CODE");
			ordered_date	= resultset.getString("ORD_DATE_TIME");			
		}
		append_str.append(order_type_code+"::");	
		append_str.append(ordered_date+"::");	
	}catch(Exception e){
		System.err.println("Err Msg in ExamsCheckListValidation.jsp"+e.getMessage());
	} finally{
		try{
			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
	out.println(append_str);
	append_str.setLength(0);

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
