package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;

public final class __blmodifyfindetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLModifyFinDetails.jsp", 1709114546603L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<script language=\'javascript\'>\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t</script>\n\n\n\n";
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

Connection con = null;
PreparedStatement pstmt = null ;
Statement stmt			= null;
ResultSet rs = null;
String patientId=request.getParameter("patient_id");
System.out.println("patientId             "+patientId);
String pat_regn_date_time="";
String billing_grp_id="";
Properties p = null ;
String pat_regn_date_time_date="";
String called_from=request.getParameter("calledFrom");
String blng_grp=request.getParameter("blng_group");
String locale	= (String)session.getAttribute("LOCALE");
String login_user=(String)session.getAttribute("login_user");
String client_ip_address=(String)session.getValue("client_ip_address");
String facility_id="";
	try
	{
		
con=ConnectionManager.getConnection(request);
HttpSession httpSession = request.getSession(false);
p = (Properties)httpSession.getValue("jdbc");
String modifiedAtWsNo = p.getProperty("client_ip_address");
facility_id=(String)httpSession.getValue("facility_id");
	if("modify_fin".equals(called_from)){
		String pat_regn_date= "select REGN_DATE from mp_patient where patient_id='"+patientId+"'";
		
		 stmt = con.createStatement();
		 rs = stmt.executeQuery(pat_regn_date);	

			if(rs.next())
			{
				pat_regn_date_time  =  rs.getString(1);	
			}
		out.println(pat_regn_date_time);
		
		
		if(rs!=null)   rs.close();
		
		}

		
		if("modify_fin1".equals(called_from)){
		 HashMap insert_values	= new HashMap() ;
	     HashMap fin_dtls= new HashMap();
	     Hashtable blTabdata = new Hashtable();

	
		 blTabdata.put("calling_function_id","CHG_PAT_DTLS");
		 blTabdata.put("credit_auth_user_id","");
		 blTabdata.put("locale",locale);
		 blTabdata.put("patient_id_new", patientId);
		 blTabdata.put("facility_id",facility_id);
		 blTabdata.put("operation_mode","U");
		 blTabdata.put("added_at_ws_no",modifiedAtWsNo);
		 blTabdata.put("added_by_id",login_user);
		 blTabdata.put("billing_group","");
		 blTabdata.put("dflt_pat_regn_blng_class","EX");
		 blTabdata.put("pat_ser_grp_code",facility_id);
		 blTabdata.put("pat_regn_date_time",pat_regn_date_time); 
       	 blTabdata.put("pat_regn_prev_date",pat_regn_date_time); 
		 blTabdata.put("apptrefno","");
		 blTabdata.put("bookingrefno","");
			try
			{
			
				  fin_dtls=(HashMap)session.getAttribute("financial_details");
				if ( fin_dtls!=null )
				{
		 			blTabdata.put("fin_dtls",fin_dtls);
		 			 
				}
			}
			catch (Exception e)
			{

				e.printStackTrace();
			}
			
			blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
			Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
			boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

if(boolRes==true)
{
		con.commit();
		blTabdata.clear();
		resultsBL.clear();
		
	}

		}

	
	}
catch(Exception e)
{
	System.out.println("Exception from modify :"+e);
	e.printStackTrace();
}
	finally
	{
		if(con!=null) 
		{
			if(con!=null) ConnectionManager.returnConnection(con);
		}
	}
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            {java.lang.String __page ="../../eBL/jsp/BLSessionValuesReset.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("fin_dtls_reset"), weblogic.utils.StringUtils.valueOf("Y")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
