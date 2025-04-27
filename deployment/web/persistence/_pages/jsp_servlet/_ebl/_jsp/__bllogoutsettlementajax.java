package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import java.text.SimpleDateFormat;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import org.json.simple.JSONObject;

public final class __bllogoutsettlementajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLLogoutSettlementAjax.jsp", 1709114105974L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\t\n    \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

HttpSession httpSession = request.getSession(false);
Properties p = (Properties) httpSession.getValue("jdbc");
Connection con = con=ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rs = null;
String site_id=" ";
String outst=" ";
String billcount_KDAH=" ";
String billcount_MC=" ";
JSONObject obj=new JSONObject();
try{
	
	
	String strLoginTime=request.getParameter("login_time");
	String strLogoutTime=request.getParameter("logout_time");
	String strCashCounterCode=request.getParameter("cashcounter1");
	String facility_id=request.getParameter("facility_id");
	
	
	try {
		pstmt=con.prepareStatement("select customer_id from sm_site_param");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			site_id = rs.getString(1);
		}
		System.out.println("site id " + site_id);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("site id " + e);
	}

	try {
		pstmt=con.prepareStatement("SELECT nvl(outst_bills_only,'N')  outstanding_ind FROM bl_parameters WHERE  operating_facility_id = '"+facility_id+"'");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			outst = rs.getString(1);
		}
		System.out.println("outst : " + outst);
		
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Execption outst settlement " + e);
	}

	try {
		pstmt=con.prepareStatement("SELECT COUNT (*) bill_count FROM bl_bill_hdr WHERE cust_code IS NULL AND bill_status IS NULL AND NVL (bill_tot_outst_amt, 0) <> 0 AND cash_counter_facility_id ='"+facility_id+"' AND CASH_COUNTER_CODE ='"+strCashCounterCode+"' AND DOC_DATE BETWEEN to_date('"+strLoginTime+"','dd/mm/yyyy hh24:mi:ss') AND to_date('"+strLogoutTime+"','dd/mm/yyyy hh24:mi:ss')");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			billcount_KDAH = rs.getString(1);
		}
		System.out.println("billcount_KDAH : " + billcount_KDAH);

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Execption billcount_KDAH settlement  " + e);
	}

	try {
		pstmt=con.prepareStatement("SELECT COUNT (*) bill_count FROM bl_bill_hdr WHERE cust_code IS NULL AND bill_status IS NULL AND NVL (bill_tot_outst_amt, 0) <> 0 AND cash_counter_facility_id ='"+facility_id+"'  AND CASH_COUNTER_CODE ='"+strCashCounterCode+"' AND DOC_DATE BETWEEN to_date('"+strLoginTime+"','dd/mm/yyyy hh24:mi:ss') AND to_date('"+strLogoutTime+"','dd/mm/yyyy hh24:mi:ss') AND episode_type in ('O','E','R')");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			billcount_MC = rs.getString(1);
		}
		System.out.println("billcount_MC : " + billcount_MC);

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Execption billcount_MC settlement  " + e);
	}
	
	obj.put("site_id",site_id);
	obj.put("outst",outst);
	obj.put("billcount_KDAH",billcount_KDAH);
	obj.put("billcount_MC",billcount_MC);

	
	out.print(obj);
    out.flush();
	
}
catch(Exception ee){
	
	ee.printStackTrace();
	System.err.println("BLLogoutSettlementAjax : " + ee);
	
	
	//ee.printStackTrace(ee);
}



            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
