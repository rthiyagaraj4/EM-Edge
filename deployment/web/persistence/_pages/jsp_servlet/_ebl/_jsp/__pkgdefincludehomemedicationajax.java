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

public final class __pkgdefincludehomemedicationajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgDefIncludeHomeMedicationAjax.jsp", 1733475467753L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\t\n    \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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

HttpSession httpSession = request.getSession(false);
Properties p = (Properties) httpSession.getValue("jdbc");
Connection con = con=ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rs = null;
String includeHomeMedicationAllYN="N";
String preappDurCapping="N"; //Added V180725-Gayathri/MMS-DM-CRF-0126
String dailyLimitYN ="N"; //Added V190404-Dhananjay/MMS-DM-CRF-0129
boolean dailyLimitSiteSpec = false;//Added V190405-Dhananjay/MMS-DM-CRF-0129
JSONObject obj=new JSONObject();
try{
	
	
	String service_code=request.getParameter("service_code");
	String called_from=request.getParameter("calledFrom");
	String type=request.getParameter("type");
	String locale = (String)session.getAttribute("LOCALE");
	System.out.println("service_code"+service_code+"/"+"type"+type+"/"+"locale"+locale);

	if("policyDefn".equals(called_from)){	
	 try {
		pstmt=con.prepareStatement("select blcommonproc.bl_pharm_service_yn(?,?,?)  from dual");
		
		pstmt.setString(1,locale);
		pstmt.setString(2,type);
		pstmt.setString(3,service_code);
		
		rs = pstmt.executeQuery();
		while (rs.next()) {
			includeHomeMedicationAllYN =rs.getString(1);
		}
		System.out.println("includeHomeMedicationAllYN" + includeHomeMedicationAllYN);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("includeHomeMedicationAllYN" + e);
	} 
	obj.put("includeHomeMedicationAllYN",includeHomeMedicationAllYN);
	System.out.println("includeHomeMedicationAllYN=frm back end=="+includeHomeMedicationAllYN);
	
	}
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
	if("preApproval".equals(called_from)){
		if ("".equals(service_code)){ preappDurCapping="N"; }
		else{
	 try {
			pstmt=con.prepareStatement("select blcommonproc.bl_preappr_ph_dur_yn(?,?,?) from dual");
			
			
			pstmt.setString(1,type);
			pstmt.setString(2,service_code);
			pstmt.setString(3,locale);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				preappDurCapping =rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("preappDurCapping" + e);
		} 
		}
		obj.put("preappDurCapping",preappDurCapping);
		//System.out.println("preappDurCapping=frm back end=="+preappDurCapping);
	}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
	//Added V190404-DHANANJAY/MMS-DM-CRF-0129/Starts
	if("rate_based_dtl".equals(called_from)){
		dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT"); //Added V190405-Dhananjay/MMS-DM-CRF-0129
	 	if(dailyLimitSiteSpec) {
			if ("".equals(service_code)) {
				dailyLimitYN ="N";
			} else {
			 	try {
					pstmt=con.prepareStatement("select blcommonproc.bl_pharm_service_yn(?,?,?) from dual"); 
					pstmt.setString(1,locale);
					pstmt.setString(2,type);
					pstmt.setString(3,service_code);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						dailyLimitYN =rs.getString(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		else 
		{
			dailyLimitYN ="R"; //Added V190405-Dhananjay/MMS-DM-CRF-0129
		}
		obj.put("dailyLimitYN",dailyLimitYN);
	}
	//Added V190404-DHANANJAY/MMS-DM-CRF-0129/Ends
	

	out.println(obj);
   
	
}


catch(Exception ee){
	
	ee.printStackTrace();
	System.err.println("PkgDefIncludeHomeMedicationAjax : " + ee);
}finally
{	

	ConnectionManager.returnConnection(con);
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
