package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.jsp.JspWriter;
import java.util.*;
import com.ehis.util.*;

public final class __regpatreferralmainpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RegPatReferralMainPage.jsp", 1723009751492L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\t\n\t\t<!-- \t -->\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eMP/js/RegPatReferral.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<iframe name=\'main_comp\' id=\'main_comp\'    src=\'../../eMP/jsp/RegPatReferralMainPage_NatID.jsp?calling_from=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&p_calling_function=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&mode=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&referral_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&speciality_code=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&service_code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&practitioner=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&practitioner_name=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&res_class=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&pat_ID=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&ass_func_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&ca_patient_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' frameborder=0 scrolling=\'auto\' noresize tabindex=-1 style=\'height:60vh;width:100vw\'></iframe>\n\t<iframe name=\'tab_comp\' id=\'tab_comp\'   src=\'../../eMP/jsp/RegPatReferralMainPage1_new.jsp?calling_from=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&p_to_locn_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&p_to_locn_code=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&p_service_desc=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&p_service_code=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' frameborder=0 scrolling=\'auto\' noresize tabindex=-1 style=\'height:40vh;width:100vw\'></iframe>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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

	request.setCharacterEncoding("UTF-8");
	String patientid		=(request.getParameter("patientid") == null)?"":request.getParameter("patientid");
	String calling_from		= request.getParameter("calling_from");
	if (calling_from==null) calling_from="";	
	String p_calling_function		= (request.getParameter("p_calling_function") == null)?"":request.getParameter("p_calling_function");
	
	String p_to_locn_type		= (request.getParameter("p_to_locn_type") == null)?"":request.getParameter("p_to_locn_type");
	String ass_func_id=(request.getParameter("ass_func_id") == null)?"":request.getParameter("ass_func_id");
	String mode = (request.getParameter("mode") == null)?"":request.getParameter("mode");	
	String speciality_code	= request.getParameter("speciality_code");
	if (speciality_code==null) speciality_code="";
	String service_code	= request.getParameter("service_code");
	if (service_code==null) service_code="";
	String practitioner	= request.getParameter("practitioner");
	if (practitioner==null) practitioner="";
	String practitioner_name	= request.getParameter("practitioner_name");
	if (practitioner_name==null) 	practitioner_name="";
	String referral_id	= request.getParameter("referral_id");
	if (referral_id==null) referral_id="";
	

	String res_class=(request.getParameter("res_class") == null)?"":request.getParameter("res_class");
		
	String p_to_locn_code=(request.getParameter("p_to_locn_code") == null)?"":request.getParameter("p_to_locn_code");
	
	String ca_patient_id=(request.getParameter("ca_patient_id") == null)?"":request.getParameter("ca_patient_id");

	//ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005
	String p_service_desc=(request.getParameter("p_service_desc") == null)?"":request.getParameter("p_service_desc");
	String p_service_code=(request.getParameter("p_service_code") == null)?"":request.getParameter("p_service_code");
	//END
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(calling_from));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_calling_function));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ass_func_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(calling_from));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_calling_function));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_to_locn_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ass_func_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_to_locn_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_to_locn_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_service_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_service_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
