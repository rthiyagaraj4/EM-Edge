package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

public final class __vwvisitwithoutmdslocation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/vwVisitWithoutMDSLocation.jsp", 1709117089420L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	
	Connection con = null;
	Statement stmt=null;
	ResultSet rs=null;
	con =  ConnectionManager.getConnection(request);
	 stmt	= con.createStatement();

	 String clinic_code="";
	 String nursing_unit_code="";
	 String short_desc="";
	 String enc_type1=checkForNull(request.getParameter("enc_type"));
	 
	 
	 try
	 {
		if(enc_type1.equals("OP"))
		{

		StringBuffer clinicCode = new StringBuffer();
		String sql				= "";
		sql="SELECT CLINIC_CODE,short_desc FROM  op_clinic WHERE LEVEL_OF_CARE_IND='A'";
		rs = stmt.executeQuery(sql);

		while(rs!= null && rs.next()){
				clinic_code = checkForNull(rs.getString("CLINIC_CODE"));
				short_desc = checkForNull(rs.getString("short_desc"));
				clinicCode.append(clinic_code+"##"+short_desc);
				clinicCode.append("~");
			}
			out.println(clinicCode);
			
				
			
		}
		else if(enc_type1.equals("DC"))
		{

		StringBuffer nursingUNitCode = new StringBuffer();
		String sql				= "";
		sql="select NURSING_UNIT_CODE, SHORT_DESC from ip_nursing_unit where facility_id='"+p_facility_id+"' and APPL_PATIENT_CLASS='DC' order by SHORT_DESC";
		rs = stmt.executeQuery(sql);

		while(rs!= null && rs.next()){
				nursing_unit_code = checkForNull(rs.getString("NURSING_UNIT_CODE"));
				short_desc = checkForNull(rs.getString("short_desc"));
				nursingUNitCode.append(nursing_unit_code+"##"+short_desc);
				nursingUNitCode.append("~");
			}
			out.println(nursingUNitCode);	
		
				
		}
		else if(enc_type1.equals("IP"))
		{
		StringBuffer nursingUNitCode = new StringBuffer();
		String sql				= "";
		sql="select NURSING_UNIT_CODE, SHORT_DESC from ip_nursing_unit where facility_id='"+p_facility_id+"' and APPL_PATIENT_CLASS='IP' order by SHORT_DESC";
		rs = stmt.executeQuery(sql);
		
				
		while(rs!= null && rs.next()){
				nursing_unit_code = checkForNull(rs.getString("NURSING_UNIT_CODE"));
				short_desc = checkForNull(rs.getString("short_desc"));
				nursingUNitCode.append(nursing_unit_code+"##"+short_desc);
				nursingUNitCode.append("~");
			}
			out.println(nursingUNitCode);	
		
		}
		else if(enc_type1.equals("EM"))
		{

			StringBuffer clinicCode = new StringBuffer();
		String sql				= "";
		sql="select CLINIC_CODE, SHORT_DESC from op_clinic where facility_id='HS' and LEVEL_OF_CARE_IND='E' order by SHORT_DESC";
		rs = stmt.executeQuery(sql);

		while(rs!= null && rs.next()){
				clinic_code = checkForNull(rs.getString("CLINIC_CODE"));
				short_desc = checkForNull(rs.getString("short_desc"));
				clinicCode.append(clinic_code+"##"+short_desc);
				clinicCode.append("~");
			}
			out.println(clinicCode);				
				
			}

            _bw.write(_wl_block2Bytes, _wl_block2);

	 }
	 catch(Exception e){
		//out.println("Exception="+e.toString());
		e.printStackTrace();
		}
	finally
	{
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
