package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __recordasstsurgeon extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/RecordAsstSurgeon.jsp", 1733927608000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

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

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String facility_id =(String) session.getAttribute("facility_id"); 
	String asstSurgeon1=checkForNull(request.getParameter("asstSurgeon1"));
	String asstSurgeon2=checkForNull(request.getParameter("asstSurgeon2"));
	String booking_no=checkForNull(request.getParameter("booking_no"));
	String surgeon_code=checkForNull(request.getParameter("surgeon_code"));
	
	//Added Against ML-MMOH-CRF-1791-US03...starts
	
	String auto_schdl_yn=checkForNull(request.getParameter("auto_schdl_yn"));
	String surgeon_code2=checkForNull(request.getParameter("surgeon_code2"));
	String tab_name=checkForNull(request.getParameter("tab_name"));
	String appt_ref_num=checkForNull(request.getParameter("appt_ref_num"));
	String oper_num=checkForNull(request.getParameter("oper_num"));
	
	String sql_2 = "UPDATE OT_POST_OPER_HDR SET ASST_SURGEON_CODE = ? ,ASST_SURGEON_CODE_2 = ?,SURGEON_CODE = ?, MODIFIED_DATE = sysdate  WHERE OPERATING_FACILITY_ID=? AND OPER_NUM = ?";
	
	String sql_3 = "UPDATE OT_QUEUE SET SURGEON_CODE=? , MODIFIED_DATE = sysdate WHERE OPERATING_FACILITY_ID=? AND OPER_NUM = ?";
	
	//Added Against ML-MMOH-CRF-1791-US03...ends
	
	String sql="UPDATE OT_BOOKING_HDR SET ASST_SURGEON_CODE = ? ,ASST_SURGEON_CODE_2 = ?,TEAM_DOCTOR_CODE=? WHERE OPERATING_FACILITY_ID=? AND BOOKING_NUM=?"; 
	
	String ot_queue_updt="UPDATE OT_QUEUE SET SURGEON_CODE = ?  WHERE OPERATING_FACILITY_ID=? AND APPT_REF_NUM=?"; 

	Connection con = null;
	PreparedStatement pstmt=null;
	con = ConnectionManager.getConnection(request);

	try{
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,asstSurgeon1);
		pstmt.setString(2,asstSurgeon2);
		pstmt.setString(3,surgeon_code);
		pstmt.setString(4,facility_id);
		pstmt.setString(5,booking_no);
		int result=	pstmt.executeUpdate();
		/*if(result>0){
			con.commit();
			out.println("Updated Successfully");
		}else{
			con.rollback();
		}*/
		pstmt=con.prepareStatement(ot_queue_updt);
		pstmt.setString(1,surgeon_code);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,booking_no);
		int result1=	pstmt.executeUpdate();
		if(result>0 && result1>0){
			con.commit();
			out.println("Updated Successfully");
		}else{
			con.rollback();
		}
		//Added Against ML-MMOH-CRF-1791-US03...starts
		
		if((tab_name.equals("SLATE")) && appt_ref_num.equals("") && auto_schdl_yn.equals("Y") && surgeon_code2.equals("ALL_OT_SURG")){
	
		pstmt=con.prepareStatement(sql_2);
		pstmt.setString(1,asstSurgeon1);
		pstmt.setString(2,asstSurgeon2);
		pstmt.setString(3,surgeon_code);
		pstmt.setString(4,facility_id);
		pstmt.setString(5,oper_num);
		int result3 =	pstmt.executeUpdate();
				
		pstmt=con.prepareStatement(sql_3);
		pstmt.setString(1,surgeon_code);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		int result4 =	pstmt.executeUpdate();
		
		if(result3 > 0 && result4 > 0){
			con.commit();
			out.println("Updated Successfully");
		}else{
			con.rollback();
		}
		}
		//Added Against ML-MMOH-CRF-1791-US03...ends
		
		pstmt.close();
		
}catch(Exception e){
		 //out.println("Err in RecordAsstSurgeon.jsp"+e.getMessage());
		 e.printStackTrace();
	}finally{
		
		if(pstmt!=null) pstmt.close();		
		if(con!=null) con.close();
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
