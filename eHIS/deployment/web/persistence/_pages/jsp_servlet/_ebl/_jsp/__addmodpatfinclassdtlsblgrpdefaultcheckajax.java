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

public final class __addmodpatfinclassdtlsblgrpdefaultcheckajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModPatFinClassDtlsBlGrpDefaultCheckAjax.jsp", 1709114074912L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident\t\t\tSCF/CRF             Developer Name\n-----------------------------------------------------------------------------------\n1            V210413\t\t\t17021        Common-ICN-0009-TF         MuthukumarN\n-----------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="    \n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties) httpSession.getValue("jdbc"); //V210413
	Connection con = con=ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String defBlngGrpId="";
	JSONObject obj=new JSONObject();
	try{
			String facilityId=request.getParameter("facilityId");
			String classCode=request.getParameter("classCode");
			String incAssetInd = request.getParameter("incAssetInd");
			String InclFamilyYN=request.getParameter("InclFamilyYN");
			String totIncAsset=request.getParameter("totIncAsset");
			String totIncAssetParsed=request.getParameter("totIncAssetParsed");
			String strModuleId=request.getParameter("strModuleId");

			System.err.println("facilityId::"+facilityId+"/"+"classCode::"+classCode+"/"+"incAssetInd::"+incAssetInd+"/"+"InclFamilyYN::"+InclFamilyYN+"/"+"totIncAsset::"+totIncAsset+"/"+"totIncAssetParsed::"+totIncAssetParsed+"/"+strModuleId+"/"+strModuleId);	

			String sqlDefBlGrp = 	BlRepository.getBlKeyValue("DFLT_BILLING_GRP");
			String sqlDefBlGrpIP = 	BlRepository.getBlKeyValue("DFLT_BILLING_GRP_IP");
			
			if("IP".equalsIgnoreCase(strModuleId)){
			sqlDefBlGrp=sqlDefBlGrp+sqlDefBlGrpIP;
			}
			System.err.println("sqlDefBlGrp "+sqlDefBlGrp);
		
		 try {
				pstmt=con.prepareStatement(sqlDefBlGrp);				
				pstmt.setString(1,facilityId);
				pstmt.setString(2,classCode);
				pstmt.setString(3,incAssetInd);
				pstmt.setString(4,InclFamilyYN);
				pstmt.setString(5,totIncAsset);
				pstmt.setString(6,totIncAssetParsed);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					defBlngGrpId =rs.getString(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("defBlngGrpId" + e);
			} 
		obj.put("defBlngGrpId",defBlngGrpId);
		System.err.println("defBlngGrpId=frm back end=="+defBlngGrpId);
		out.println(obj);		
	}
	catch(Exception ee){	
		ee.printStackTrace();
		System.err.println("PkgDefIncludeHomeMedicationAjax : " + ee);
	}
	finally{
		ConnectionManager.returnConnection(con);
		//V210413 start
		//pstmt = null;
		//rs = null;
		pstmt.close();
		rs.close();		
		//V210413 end			
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
