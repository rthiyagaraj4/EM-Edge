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
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import eOT.Common.*;
import eOT.*;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __anaesthesiaparams extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AnaesthesiaParams.jsp", 1735794466000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

	try {
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String order_id		= (String) hash.get("order_id");
		String function_id		= (String) hash.get("function_id");

		
//		String facility_id =(String)session.getAttribute("facility_id");
		String anaes_sql="";
		
		anaes_sql="SELECT ANAESTHESIA_SERIAL_NUM, PREOP_ASSE_DONE_YN, INTRAOP_DONE_YN, POSTOP_DONE_YN FROM AT_ANAESTHESIA_RECORD_HDR WHERE SOURCE_ORDER_ID= ? ";

		String 	anaesthesia_serial_num="";
		String  preop_asse_done_yn="";
		String  intraop_done_yn="";
		String  postop_done_yn="";
		String source_order_id ="";
		String request_source_type ="";
		String anaesthetist_code = "";

		String pre_oper_flag="AnesthesiaDetails";
		conn			= ConnectionManager.getConnection(request);
		pstmt				= conn.prepareStatement(anaes_sql) ;
		pstmt.setString(1,order_id);
		rs			= pstmt.executeQuery();
		if(rs!=null && rs.next()){
		anaesthesia_serial_num = rs.getString("ANAESTHESIA_SERIAL_NUM");
		if(anaesthesia_serial_num==null) anaesthesia_serial_num="";
		preop_asse_done_yn = rs.getString("PREOP_ASSE_DONE_YN");
		intraop_done_yn = checkForNull(rs.getString("INTRAOP_DONE_YN"),"N");
		postop_done_yn = checkForNull(rs.getString("POSTOP_DONE_YN"),"N");

		}	

		if(anaesthesia_serial_num.equals("") && function_id.equals("09")){
		anaes_sql="SELECT ORDER_ID,SOURCE_ORDER_ID,REQUEST_SOURCE_TYPE, ANAESTHETIST_CODE FROM AT_PENDING_ORDERS WHERE SOURCE_ORDER_ID =? ";
		pstmt	= conn.prepareStatement(anaes_sql) ;
		pstmt.setString(1,order_id);
		rs		= pstmt.executeQuery();
		if(rs!=null && rs.next()){
			order_id = checkForNull(rs.getString("ORDER_ID"));
			source_order_id = checkForNull(rs.getString("SOURCE_ORDER_ID"));
			request_source_type = checkForNull(rs.getString("REQUEST_SOURCE_TYPE"));
			anaesthetist_code = checkForNull(rs.getString("ANAESTHETIST_CODE"));
			pre_oper_flag="PendingOrders";
		}else{
			pre_oper_flag="AnaesthesiaNotApplicable";
		}
		}
		out.println(anaesthesia_serial_num+"::"+preop_asse_done_yn+"::"+intraop_done_yn+"::"+postop_done_yn+"::"+pre_oper_flag+"::"+order_id+"::"+source_order_id+"::"+request_source_type+"::"+anaesthetist_code);
					
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
	finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(conn,request);
	}catch(Exception es){es.printStackTrace();}
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
