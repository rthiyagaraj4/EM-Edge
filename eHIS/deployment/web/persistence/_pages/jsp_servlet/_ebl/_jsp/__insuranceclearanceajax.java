package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eBL.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.util.*;

public final class __insuranceclearanceajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/InsuranceClearanceAjax.jsp", 1709114125708L ,"10.3.6.0","Asia/Calcutta")) return true;
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

public String checkNull(String inputString)
{
	if(inputString == null || inputString.equals("") ||  inputString.equalsIgnoreCase("null") )
		inputString = "";
	return inputString;
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
/*
Sr No        Version           Incident        SCF/CRF             			Developer Name
-------------------------------------------------------------------------------------------
 1			V221130								TH-KW-CRF-0084.1  		Mohana Priya K
 -------------------------------------------------------------------------------------------
*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

String functionMode = "";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;


try {
	con = ConnectionManager.getConnection();
	functionMode = request.getParameter("functionMode");
	if (null == functionMode) {
		functionMode = "";
	}
	System.err.println("functionMode "+functionMode);
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_user = (String) p.getProperty("login_user");
	HttpSession httpSession = request.getSession(false);	
	String facility_id = (String)httpSession.getValue("facility_id");
	
	if("insuranceClearanceSts".equals(functionMode)){ 
		String visitId = checkNull(request.getParameter("visitId"));
		String episodeType = checkNull(request.getParameter("episodeType"));
		String episodeId = checkNull(request.getParameter("episodeId"));
		String patient_Id = checkNull(request.getParameter("patientId"));
		
		System.err.println("visitId insuranceClearanceSts "+visitId);
		System.err.println("episodeType "+episodeType);
		System.err.println("episodeId "+episodeId);
		System.err.println("patient_Id "+patient_Id);
		System.err.println("facility_id "+facility_id);
		pstmt=con.prepareStatement("select  blinstransactions.get_ins_clearance_status(?,?,?,?,?) from dual");
		pstmt.setString(1, facility_id);
		pstmt.setString(2, patient_Id);
		pstmt.setString(3,episodeType);
		pstmt.setString(4, episodeId);
		pstmt.setString(5, visitId);
		rs = pstmt.executeQuery();
		String status="";
		while (rs.next()) {
			status =rs.getString(1);
		}
		
		System.err.println("status:::"+status);
		out.println(status);
		
	}else if ("cancelInsuranceClearance".equals(functionMode)) {
		String visitId = checkNull(request.getParameter("visitId"));
		String episodeType = checkNull(request.getParameter("episodeType"));
		String episodeId = checkNull(request.getParameter("episodeId"));
		String patient_Id = checkNull(request.getParameter("patientId"));
		
		System.err.println("visitId cancelInsuranceClearance "+visitId);
		System.err.println("episodeType "+episodeType);
		System.err.println("episodeId "+episodeId);
		System.err.println("patient_Id "+patient_Id);
		CallableStatement cstmt = con.prepareCall("{ call blinstransactions.cancel_ins_clearance(?,?,?,?,?,?,?) }");
			
		cstmt.setString(1, facility_id);
		cstmt.setString(2, episodeType);
		cstmt.setString(3,patient_Id);
		cstmt.setString(4, episodeId);
		cstmt.setString(5, visitId);
		cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
		cstmt.execute();
				
		String cancelSts = cstmt.getString(6);
		String errmessage = cstmt.getString(7);	
		
		if(null != errmessage && !"".equals(errmessage)){
			System.err.println("errmessage:::"+errmessage);
			out.println(errmessage);
		}
		System.err.println("cancelSts:::"+cancelSts);
		out.println(cancelSts);
		con.commit();
		
		if(cstmt!=null) cstmt.close();
	}else if("get_bill_ip_indicator".equals(functionMode)){ 
		String visitId = checkNull(request.getParameter("visitId"));
		String episodeType = checkNull(request.getParameter("episodeType"));
		String episodeId = checkNull(request.getParameter("episodeId"));
		String patient_Id = checkNull(request.getParameter("patientId"));
		
		System.err.println("visitId get_bill_ip_indicator "+visitId);
		System.err.println("episodeType "+episodeType);
		System.err.println("episodeId "+episodeId);
		System.err.println("patient_Id "+patient_Id);
		pstmt=con.prepareStatement("select  bl_get_bill_gen_dtls.get_bill_ip_indicator(?,?,?,?) from dual");
		pstmt.setString(1, facility_id);
		pstmt.setString(2, patient_Id);
		pstmt.setString(3,episodeType);
		pstmt.setString(4, episodeId);
		rs = pstmt.executeQuery();
		String dischargebill="";
		while (rs.next()) {
			dischargebill =rs.getString(1);
		}
		
		System.err.println("dischargebill:::"+dischargebill);
		out.println(dischargebill);
		
	}
}catch(Exception e){
	e.printStackTrace();
	System.err.println("Exception from InsuranceClearanceAjax.jsp :" + e);
}finally {
		ConnectionManager.returnConnection(con, request);
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
