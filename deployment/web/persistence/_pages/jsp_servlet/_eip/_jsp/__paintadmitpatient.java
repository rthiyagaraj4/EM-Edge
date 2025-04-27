package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;

public final class __paintadmitpatient extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PaintAdmitPatient.jsp", 1734071970694L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\n<head>\n<script language=\'javascript\' src=\'../../eCommon/js/showModalDialog.js\'></script>\n</head>\n<iframe name=\"Select_frame\" id=\"Select_frame\" src=\"../jsp/AdmitPatientSelect.jsp?P_call_func=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&P_retval=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&patient_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&oper_stn_id=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&register_pat_in_admn_yn=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&bkg_grace_period=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&allowed_admission_type=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&called_from=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&bl_interfaced_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&noshow_bkng_period=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&from_adv_bed_mgmt=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&bedNo=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nursing_unit=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&appl_patient_class=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&quick_admission_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&quick_adm_referralid=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&quick_adm=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&ref_encounter_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" frameborder=0 noresize scrolling=NO style=\"height:17vh;width:98vw\"></iframe>\n<iframe src=\"../../eCommon/html/blank.html\" name=\"Pline_frame\" id=\"Pline_frame\" frameborder=0 noresize scrolling=NO style=\"height:10vh;width:98vw;/* margin-top:0px; margin-bottom:0px;padding-top:0px; padding-bottom:0px\"  */></iframe>\n\t<!-- modified for MMS-QH-CRF-0144 : passing reason_reqd_Flag parameter-- style=\"height:3%;width:98vw\"> -->\n\n\t<iframe name=\"Main_frame\" id=\"Main_frame\"  src=\"addModifyAdmitPatient.jsp?P_call_func=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&max_disch_period_for_dc=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&f_nursing_unit=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&adm_date_chk_days=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&adm_date_chk_days_type=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&pat_checkin_yn=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nurs_unt_auth_val=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&backdated_admission_yn=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&deactivate_pseudo_bed_yn=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&back_date=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&reason_reqd_Flag=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"  frameborder=0 noresize scrolling=no style=\"height:97vh;width:98vw\"></iframe>\n\t<iframe src=\"../jsp/AdmitPatientButtons.jsp\" name=\"Buttons_frame\" id=\"Buttons_frame\" frameborder=0 noresize scrolling=NO style=\"height:5vh;width:98vw\"></iframe>\n\t<iframe src=\"../../eCommon/html/blank.html\" name=\"dummy\" id=\"dummy\" frameborder=0 noresize scrolling=NO style=\"height:0vh;width:98vw\"></iframe>\n\n</html>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 
int adm_date_chk_days_int = 0;
String max_disch_period_for_dc	= checkForNull((String)request.getParameter("max_disch_period_for_dc"));
String back_date				= checkForNull((String)request.getParameter("back_date"));
String callfunc					= checkForNull((String)request.getParameter("P_call_func"));
String returnvalue				= checkForNull((String)request.getParameter("P_retval"));
String patientid				= checkForNull((String)request.getParameter("patient_id"));
String f_nursing_unit			= checkForNull((String)request.getParameter("f_nursing_unit"));
String oper_stn_id				= checkForNull((String)request.getParameter("oper_stn_id"));
String register_pat_in_admn_yn	= checkForNull((String)request.getParameter("register_pat_in_admn_yn"));
String bl_interfaced_yn			= checkForNull((String)request.getParameter("bl_interfaced_yn"));	
String nurs_unt_auth_val		= checkForNull((String)request.getParameter("nurs_unt_auth_val"));	
String backdated_admission_yn	= checkForNull((String)request.getParameter("backdated_admission_yn"));	
String deactivate_pseudo_bed_yn	= checkForNull((String)request.getParameter("deactivate_pseudo_bed_yn"));	
String allowed_admission_type	= checkForNull((String)request.getParameter("allowed_admission_type"));	
String adm_date_chk_days		= checkForNull((String)request.getParameter("adm_date_chk_days"));	

if(!adm_date_chk_days.equals(""))
	adm_date_chk_days_int = Integer.parseInt(adm_date_chk_days);

String adm_date_chk_days_type	= checkForNull((String)request.getParameter("adm_date_chk_days_type"));	
String bkg_grace_period			= checkForNull((String)request.getParameter("bkg_grace_period"));	
String pat_checkin_yn			= checkForNull((String)request.getParameter("pat_checkin_yn"));	
String called_from			= checkForNull((String)request.getParameter("called_from"));	
String noshow_bkng_period   = checkForNull(request.getParameter("noshow_bkng_period"));//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
//below code added for ABM CRF 643.1 ICN:36736
String from_adv_bed_mgmt			= checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");//modified for the incident 41661
String bedNo			= checkForNull((String)request.getParameter("bedNo"));
String nursing_unit			= checkForNull((String)request.getParameter("nursing_unit"));
String appl_patient_class			= checkForNull((String)request.getParameter("appl_patient_class"));

	/*Below line Added for this CRF  Bru-HIMS-CRF-261*/
	String quick_admission_type	= checkForNull((String)request.getParameter("quick_admission_type"));
	String quick_adm_referralid	= checkForNull((String)request.getParameter("quick_adm_referralid"));
	String quick_adm= checkForNull((String)request.getParameter("quick_adm"));
	String ref_encounter_id=checkForNull((String)request.getParameter("ref_encounter_id"));
	
String reason_reqd_Flag = checkForNull((String)request.getParameter("reason_reqd_Flag")); //Modified against MMS-QH-CRF-0144

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(callfunc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(returnvalue));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(register_pat_in_admn_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(allowed_admission_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noshow_bkng_period));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(from_adv_bed_mgmt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appl_patient_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(quick_admission_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(quick_adm_referralid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(quick_adm));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ref_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(callfunc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(returnvalue));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(max_disch_period_for_dc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(f_nursing_unit));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(adm_date_chk_days_int));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(adm_date_chk_days_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(pat_checkin_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nurs_unt_auth_val));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backdated_admission_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(back_date)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(from_adv_bed_mgmt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appl_patient_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(quick_admission_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(quick_adm_referralid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(quick_adm));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ref_encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(reason_reqd_Flag));
            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block33Bytes, _wl_block33);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
