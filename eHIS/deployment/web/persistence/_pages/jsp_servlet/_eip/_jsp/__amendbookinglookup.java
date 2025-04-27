package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __amendbookinglookup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AmendBookingLookup.jsp", 1734954820422L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../js/AmendBooking.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<iframe name = \'commontoolbarFrame\'\tsrc = ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" frameborder=0 scrolling = \'no\' noresize style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\"../jsp/BookingReferenceLookup.jsp?function_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&oper_stn_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&revise_booking_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&cancel_booking_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&confirm_booking_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&create_booking_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&create_booking_with_conf_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&ismult_bkg_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&bkg_grace_period=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&bl_interfaced_yn=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&capture_fin_dtls_yn=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&noshow_bkng_period=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"  frameborder=0 scrolling=\'auto\' style=\'height:84vh;width:100vw\'></iframe>\n\t\t\t\t\t<!-- modified   for Bru-HIMS-CRF-153 [IN:030273] by Srinivas-->\n\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:8vh;width:100vw\'></iframe>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'OPER_STN_FUNC_RESTRN\',\'IP\'))\n\t\t\t\t\tdocument.location.href =\'../../eCommon/jsp/dmenu.jsp\'\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n            <script>alert(getMessage(\'IP_PARAM_NOT_FOUND\',\'IP\'));\n\t\t\tdocument.location.href= \'../../eCommon/jsp/dmenu.jsp\'\n\t\t\t</script>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n</html>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String url					= "../../eCommon/jsp/commonToolbar.jsp?";
	String params				= request.getQueryString();
	String source				= url + params;
	String facilityId			= (String)session.getValue("facility_id");
	String loginUser			= (String)session.getValue("login_user");
	String function_id			= request.getParameter("function_id");
        if(function_id == null) function_id = "";

	Connection con				= null;
	PreparedStatement stmt		= null;
	Statement stmt1				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs 				= null; 
	ResultSet rs1 				= null; 
	ResultSet rset 				= null;
	String oper_stn_id			= "";  
	String revise_booking_yn	= "";
	String cancel_booking_yn	= "";
	String reject_admission_yn	= "";
	String confirm_booking_yn	= "";
	String create_booking_yn	= "";
	String create_booking_with_conf_yn = "";
	String ismult_bkg_yn		= "";
	String bkg_grace_period		= "";
	String bl_interfaced_yn		= "";
	String capture_fin_dtls_yn	= "";
	String noshow_bkng_period   = "";//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	try
	{
		con						= ConnectionManager.getConnection(request);	
		//The below query is modified   for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
		String ip_paramSql      = "select multi_book_pat_yn,bkg_grace_period,bl_interfaced_yn,capture_fin_dtls_yn,NOSHOW_BKNG_PERIOD from ip_param where facility_id='"+facilityId+"'";
		pstmt					= con.prepareStatement(ip_paramSql);
		rs = pstmt.executeQuery() ;
		if(rs.next())
		{
			ismult_bkg_yn		= checkForNull(rs.getString("multi_book_pat_yn"));
			bkg_grace_period	= checkForNull(rs.getString("bkg_grace_period"));
			bl_interfaced_yn	= checkForNull(rs.getString("bl_interfaced_yn"));
			capture_fin_dtls_yn = checkForNull(rs.getString("capture_fin_dtls_yn"));
			noshow_bkng_period  = checkForNull(rs.getString("NOSHOW_BKNG_PERIOD"));//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			
			String accessCheck	= "Select  AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','REVISE_BOOKING_YN') revise_booking_yn, AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','CANC_BOOKING_YN') canc_booking_yn, AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','REJECT_ADMISSION_YN') reject_admission_yn, DECODE(AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','CONFIRM_BOOKING_YN'),'1','N','2','N','3','N','4','N','Y') confirm_booking_yn, DECODE(AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','CREATE_BOOKING_YN'),'1','N','2','N','3','N','4','N','Y') create_booking_yn, DECODE(AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','CREATE_BOOKING_WITH_CONF_YN'),'1','N','2','N','3','N','4','N','Y') create_booking_with_conf_yn FROM dual";
			stmt = con.prepareStatement(accessCheck);
			rs = stmt.executeQuery() ;

			rs.next();
			revise_booking_yn	= checkForNull(rs.getString("revise_booking_yn"));

			if((!revise_booking_yn.equals("1")) && (!revise_booking_yn.equals("2")) && (!revise_booking_yn.equals("3")) && (!revise_booking_yn.equals("4")))
			{
				oper_stn_id			=  revise_booking_yn;
				revise_booking_yn   = "Y";
			}
			else
			{
				revise_booking_yn   = "N";
			}

			cancel_booking_yn		= checkForNull(rs.getString("canc_booking_yn"));
			if((!cancel_booking_yn.equals("1")) && (!cancel_booking_yn.equals("2")) && (!cancel_booking_yn.equals("3")) && (!cancel_booking_yn.equals("4")))
			{
				oper_stn_id			=  cancel_booking_yn;
				cancel_booking_yn   = "Y";
			}
			else
			{
				cancel_booking_yn   = "N";
			}

			reject_admission_yn		= checkForNull(rs.getString("reject_admission_yn"));
			if((!reject_admission_yn.equals("1")) && (!reject_admission_yn.equals("2")) && (!reject_admission_yn.equals("3")) && (!reject_admission_yn.equals("4")))
			{
				oper_stn_id =  reject_admission_yn;
				reject_admission_yn = "Y";
			}
			else
			{
				reject_admission_yn = "N";
			}

			confirm_booking_yn		= checkForNull(rs.getString("confirm_booking_yn"));
			create_booking_yn		= checkForNull(rs.getString("create_booking_yn"));
			create_booking_with_conf_yn = checkForNull(rs.getString("create_booking_with_conf_yn"));

			if((revise_booking_yn.equals("Y")) || (cancel_booking_yn.equals("Y")) ||(reject_admission_yn.equals("Y")))
			{	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(revise_booking_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(cancel_booking_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(confirm_booking_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(create_booking_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(create_booking_with_conf_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ismult_bkg_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(noshow_bkng_period));
            _bw.write(_wl_block21Bytes, _wl_block21);
	}
			else
			{	
            _bw.write(_wl_block22Bytes, _wl_block22);
	}
		}
		else 
            _bw.write(_wl_block23Bytes, _wl_block23);
		if(rset != null)	rset.close();
		if(rs != null)		rs.close();
		if(rs1 != null)		rs1.close();
		if(stmt != null)	stmt.close();
		if(pstmt != null)	pstmt.close();
		if(stmt1 != null)	stmt1.close();
	}catch(Exception e)
	{	
		//out.println("Exception in tryCatch : "+ e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block24Bytes, _wl_block24);
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
