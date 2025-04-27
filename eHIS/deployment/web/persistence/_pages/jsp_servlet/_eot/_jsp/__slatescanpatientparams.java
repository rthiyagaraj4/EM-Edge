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
import eOT.Common.*;
import eOT.*;
import java.util.Hashtable;
import java.util.*;
import com.ehis.util.*;

public final class __slatescanpatientparams extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SlateScanPatientParams.jsp", 1709120354000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n</body>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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

//"java.sql.*, java.util.*, java.io.*, eOT.Common.*, eOT.*"

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String 	booking_num = "";
		String order_id="";
		String oper_num="";
		String scan_sql="";
		String comp="parent.parent.frames[1].frames[1].forms[0].scan_option";
	try {
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String url_desc		= (String) hash.get("url_desc");
		String patient_id		= (String) hash.get("patient_id");
		String facility_id =(String)session.getAttribute("facility_id");

		conn			= ConnectionManager.getConnection(request);
		
		if(url_desc.equals("OTCheckIn")){
			scan_sql="SELECT OPERATING_FACILITY_ID, BOOKING_NUM, ORDER_ID FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND BOOKING_DATE BETWEEN TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 23:59', 'DD/MM/YYYY HH24:MI') AND BOOKING_STATUS IN ('0')";

			pstmt = conn.prepareStatement(scan_sql) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rs			= pstmt.executeQuery();
			while(rs!=null && rs.next()){
			oper_num += rs.getString("BOOKING_NUM")+"#";
			}
			if(oper_num==null) oper_num="";
			
			if(!oper_num.equals(""))
			{
				oper_num +="##"+"scheduled";
			}else{
				//oper_num +=
				scan_sql="SELECT ORDERING_FACILITY_ID, ORDER_ID FROM OR_ORDER WHERE ORDERING_FACILITY_ID = ? AND PATIENT_ID = ? AND ORD_DATE_TIME  BETWEEN TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 23:59', 'DD/MM/YYYY HH24:MI') AND ORDER_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  ORDER_STATUS_TYPE IN ('10'))";
				pstmt				= conn.prepareStatement(scan_sql) ;
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				rs			= pstmt.executeQuery();
				while(rs!=null && rs.next()){
				oper_num += rs.getString("ORDER_ID")+"#";
				}
				oper_num +="##"+"un_scheduled";

			}
		}
		else if(url_desc.equals("OTCheckInToOR")){
			scan_sql="SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND  OPER_DATE BETWEEN TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 23:59', 'DD/MM/YYYY HH24:MI') AND OPER_STATUS IN ('40','45')";
			pstmt				= conn.prepareStatement(scan_sql) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rs			= pstmt.executeQuery();
			while(rs!=null && rs.next()){
			oper_num += rs.getString("OPER_NUM")+"#";
		 }
	  }
			out.println(oper_num);	
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



            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
