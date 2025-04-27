package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;

public final class __referralsearchframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ReferralSearchFrameset.jsp", 1728552602616L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n   \t\t Developed By  :- M.F.Mohamed Ali Suhail\n   \t\t Function      :-  Referral Search (To search a referral id)\n--> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/ecis.css\'></link> -->\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n  <TITLE>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&nbsp;";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</TITLE>\n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t  <iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eMP/jsp/ReferralSearchCriteria.jsp?p_calling_function=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&function_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&p_patient_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&p_referral_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&p_from_date=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&p_to_date=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&p_from_ref_type=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&p_from_ref_code=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&p_from_locn_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&p_from_locn_code=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&p_from_pract_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&p_to_ref_type=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&calledFrom=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&p_to_ref_code=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&p_to_locn_type=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&p_to_locn_code=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&p_speciality_code=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&p_service_code=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&p_to_pract_id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&p_to_pract_name=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&p_select=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&p_reg_patient=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&res_class=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&ass_func_id=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&ca_patient_id=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&callingMode=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&p_service_desc=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' frameborder=0 scrolling=\'auto\' noresize  style=\'height:68vh;width:99vw\'></iframe>\n\t  <iframe name=\'f_query_add_mod_result\' id=\'f_query_add_mod_result\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\'height:32vh;width:99vw\'></iframe>\n\t  <iframe name=\'validation_frame\' id=\'validation_frame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize style=\'height:0vh;width:99vw\' scrolling=\'no\'></iframe>\n       \n    ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' frameborder=0 scrolling=\'auto\' style=\'height:68vh;width:99vw\' noresize></iframe>\n\t  <iframe name=\'f_query_add_mod_result\' id=\'f_query_add_mod_result\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\'height:5vh;width:99vw\'></iframe>\n\t  <iframe name=\'validation_frame\' id=\'validation_frame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize style=\'height:0vh;width:99vw\' scrolling=\'no\'></iframe>\n     \n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String p_calling_function	 = checkForNull(request.getParameter("p_calling_function"),"INDEPENDENT");
	
	//String function_id	 = checkForNull(request.getParameter("function_id"));
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");


	if(function_id.equals("IP_PENDING_REFERRAL_BOOKING") || function_id.equals("OA_PENDING_REFERRAL_BOOKING"))
		p_calling_function = function_id;

/*
	if(p_calling_function.equals("") && function_id.equals("PENDING_REFERRAL_BOOKING"))
		p_calling_function = function_id;
	else		
		p_calling_function = "INDEPENDENT";
*/
	String ass_func_id	 = checkForNull(request.getParameter("ass_func_id"));
	String ca_patient_id=checkForNull(request.getParameter("ca_patient_id"));

	String p_patient_id	="";
	if(ca_patient_id.equals(""))
	{
		p_patient_id = 	request.getParameter("p_patient_id");
		p_patient_id = (p_patient_id==null)?"":p_patient_id;
	}
	else
	{
		p_patient_id = 	request.getParameter("ca_patient_id");
		p_patient_id = (p_patient_id==null)?"":p_patient_id;
	}

	String p_referral_id	     = 	request.getParameter("p_referral_id");
	p_referral_id			     = (p_referral_id==null)?"":p_referral_id;

	String p_from_date		     = 	request.getParameter("p_from_date");
	p_from_date				     = (p_from_date==null)?"":p_from_date;

	String p_to_date		     = 	request.getParameter("p_to_date");
	p_to_date				     = (p_to_date==null)?"":p_to_date;

	String p_from_ref_type	     = 	request.getParameter("p_from_ref_type");
	p_from_ref_type			     = (p_from_ref_type==null)?"":p_from_ref_type;

	String p_from_ref_code	     = 	request.getParameter("p_from_ref_code");
	p_from_ref_code			     = (p_from_ref_code==null)?"":p_from_ref_code;

	String p_from_locn_type	     = 	request.getParameter("p_from_locn_type");
	p_from_locn_type		     = (p_from_locn_type==null)?"":p_from_locn_type;

	String p_from_locn_code	     = 	request.getParameter("p_from_locn_code");
	p_from_locn_code		     = (p_from_locn_code==null)?"":p_from_locn_code;

	String p_from_pract_id	     = 	request.getParameter("p_from_pract_id");
	p_from_pract_id			     = (p_from_pract_id==null)?"":p_from_pract_id;

	String p_to_ref_type	     = 	request.getParameter("p_to_ref_type");
	p_to_ref_type			     = (p_to_ref_type==null)?"":p_to_ref_type;

	String p_to_ref_code	     = 	request.getParameter("p_to_ref_code");
	p_to_ref_code			     = (p_to_ref_code==null)?"":p_to_ref_code;

	String calledFrom         = request.getParameter("calledFrom");
	if(calledFrom==null) calledFrom =""; 

	String p_to_locn_type	     = 	request.getParameter("p_to_locn_type");
	p_to_locn_type			     = (p_to_locn_type==null)?"":p_to_locn_type;

	String p_to_locn_code	     = 	request.getParameter("p_to_locn_code");
	p_to_locn_code			     = (p_to_locn_code==null)?"":p_to_locn_code;

	String p_to_pract_id	     = 	request.getParameter("p_to_pract_id");
	p_to_pract_id			     = (p_to_pract_id==null)?"":p_to_pract_id;
	String p_to_pract_name=request.getParameter("p_to_pract_name");
	p_to_pract_name 			     = (p_to_pract_name==null)?"":p_to_pract_name ;
	String p_select			     = 	request.getParameter("p_select");
	p_select				     = (p_select==null)?"":p_select;
	String p_reg_patient	     = 	request.getParameter("p_reg_patient");
	p_reg_patient			     = (p_reg_patient==null)?"":p_reg_patient;
    String p_speciality_code     =  request.getParameter("p_speciality_code");
     p_speciality_code            = (p_speciality_code==null)?"":p_speciality_code;
    String p_service_code     =  request.getParameter("p_service_code");
     p_service_code            = (p_service_code==null)?"":p_service_code;
	 
	 //Added by Santhosh for MMS-DM-CRF-0209.4-US005
	 String p_service_desc = "";
	 if(ass_func_id.equals("REFERAL_REQUIRED")){
		 
		Connection con = null;
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs    = null; 
				
		pstmt  = con.prepareStatement("SELECT SHORT_DESC FROM AM_SERVICE WHERE SERVICE_CODE='"+p_service_code+"'");
		rs = pstmt.executeQuery() ;
		if( rs != null ) {
			if( rs.next() ) {
				p_service_desc = checkForNull(rs.getString(1));
			}
		}
	 }
	//END
	
	 String res_class=(request.getParameter("resorce_type") == null)?"":request.getParameter("resorce_type");
	 String waitListNo=(request.getParameter("waitListNo") == null)?"":request.getParameter("waitListNo");
	  String callingMode=(request.getParameter("callingMode") == null)?"":request.getParameter("callingMode");
	if(!waitListNo.equals(""))
	{
		ca_patient_id=p_patient_id;
	}

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

    if((p_calling_function!=null && p_calling_function.equalsIgnoreCase("INDEPENDENT"))||(p_calling_function!=null && p_calling_function.equalsIgnoreCase("REPRINT_REF_LETTER"))) { 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_calling_function));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_referral_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_from_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_to_date));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_from_ref_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_from_ref_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_from_locn_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_from_locn_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_from_pract_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_to_ref_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_to_ref_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_to_locn_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_to_locn_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_speciality_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_service_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_to_pract_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_to_pract_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_select));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_reg_patient));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ass_func_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_service_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
 } else { 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_calling_function));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_referral_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_from_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_to_date));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_from_ref_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_from_ref_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_from_locn_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_from_locn_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_from_pract_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_to_ref_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_to_ref_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_to_locn_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_to_locn_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_speciality_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_service_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_to_pract_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_to_pract_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_select));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_reg_patient));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ass_func_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_service_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
 } 
            _bw.write(_wl_block38Bytes, _wl_block38);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referral.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
