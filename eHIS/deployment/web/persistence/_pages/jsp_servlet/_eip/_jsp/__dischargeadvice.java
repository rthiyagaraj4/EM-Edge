package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;

public final class __dischargeadvice extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeAdvice.jsp", 1742377704642L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<head>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'</link>\n\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\t\t\t\n\t\t\t\n</head>\n<script>\nvar pat_id;\nvar enc_id;\nvar  fac_id;\n//Below code added by venkatesh on 28/November/2011 against the IP-CA-KDAH-CRF-0041-ICN-IN029671\nvar myarr = new Array();\nindex=0;\nvar cons;\nasync function message(myarr,flag,cont,ward_return,chk_pen_ward_rtn_bfr_dis_adv){\n\tvar listno=1;\n\n\tvar order_list=\"\";\n\tvar i;\n\tvar pendingWardReturn = \"\";\n\tvar dialogHeight= \"1200px\" ;\n\tvar dialogTop = \"1200px\" ;\n\tvar dialogWidth\t= \"10px\" ;\n\tvar status = \"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status  + \"; dialogTop :\" + dialogTop ;\n\n\t\t\t\t\t\t\t\n\tvar url=\"../../eOR/jsp/ViewPendingOrders.jsp?patient_id=\"+pat_id+\"&encounter_id=\"+enc_id+\"&facility_id=\"+fac_id+\"&discharge_ind=A\";\n\n\tif(chk_pen_ward_rtn_bfr_dis_adv==\"Y\" && ward_return==\"W\"){\n\t\tpendingWardReturn = \"Y\";\t\n\t} \n\t\n\t\n\tif(flag==\'Y\') {\t\t\t\t\n\t\t\t\n\t\tif(pendingWardReturn==\"\"){\t\t\t\t\n\t\t\tdocument.getElementById(\'pda\').rows=\'0%,0%,0%,0%,*\';\n\t\t\tdocument.getElementById(\'messageFrame\').src=\'../html/blank.html\'\n\t\t\tvar retVal = new String();\n\t\t\tretVal = await window.showModalDialog(url,arguments,features);\t\t\n\t\t\tif(window.confirm(getMessage(\"PROCEED_DISCHARGE_ADVICE\",\"IP\"))){\n\t\t\t\tdocument.getElementById(\'pda\').rows=\'0,50,128,8,0\';\n\t\t\t}else{\n\t\t\t\tdocument.getElementById(\'f_query_add_mod_display\').src=\'../html/blank.html\'\n\t\t\t\tdocument.getElementById(\'f_query_add_mod\').src=\'../html/blank.html\'\n\t\t\t\tdocument.getElementById(\'f_query_add_mod_button\').src=\'../html/blank.html\'\n\t\t\t\tdocument.getElementById(\'messageFrame\').src=\'../html/blank.html\'\n\t\t\t}\n\t\t}else{\n\t\t\t\tdocument.getElementById(\'f_query_add_mod_display\').src=\'../html/blank.html\'\n\t\t\t\tdocument.getElementById(\'f_query_add_mod\').src=\'../html/blank.html\'\n\t\t\t\tdocument.getElementById(\'f_query_add_mod_button\').src=\'../html/blank.html\'\n\t\t\t\tdocument.getElementById(\'messageFrame\').src=\'../html/blank.html\'\n\t\t}\n\t}else{\n\t\t\tif(window.confirm(getMessage(\"ORDER_PENDING_CNT_PROCEED_VIEW\",\"IP\"))){\n\t\t\t\tvar retVal = new String();\n\t\t\t\tretVal = await window.showModalDialog(url,arguments,features);\n\t\t\t}\t\n\t}\t\t\n} \n\t\t\n\n\t// venkatesh IP-CA-KDAH-CRF-0041-ICN-IN029671 END\n</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<script>\t\t\t\t\t\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'==\"W\"){\n\t\t\t\t\t\talert(getMessage(\'WARD_RETURN\',\'IP\'));\n\t\t\t\t\t}</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\tpat_id=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\tenc_id=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\t\tfac_id=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\n\t\n\n\t\t\t<title>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</title>\n\t\t\t<iframe name=\'pline\' id=\'pline\' SRC=\'\' noresize  frameborder=no scrolling=\'no\'>\n\t\t\t\t<!--Maheshwaran K added patient_class for the  JD-CRF-0145 [IN:030011] --><!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-- style=\'height:0%;width:100vw\'></iframe><iframe id=\'frame\' name=\'f_query_add_mod_display\' id=\'f_query_add_mod_display\' \t src=\'addmodifyDischargeAdvice.jsp?jsp_name=&win_height=1&win_width=40&is_ca_yn=Y&&EncounterId=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&patient_class=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&patient_Id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&admissiondatetime=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&admissiontypedesc=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&specialtyshortdesc=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&practitionername=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nursingunitshortdesc=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&serviceshortdesc=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&bedno=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&roomno=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&bedclassshortdesc=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&bed_type_desc=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&weight_on_admission=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&weight_on_admission_unit=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&weight_on_admission_unit_display=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&is_validate_weight_on_admission=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&is_value_already_captured=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&height_on_admission=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&height_on_admission_unit=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&is_validate_height_on_admission=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&bmi=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&enable_height_bmi_pat_cls=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&is_value_already_captured_height=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:70%;width:100vw\'></iframe> \n\t\t\t\t\n\t\t\t\t<iframe id=\'frame2\' name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t src=\'AddModifyDischargeAdvTabs.jsp?jsp_name=&win_height=1&win_width=40&is_ca_yn=Y&EncounterId=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&practitioner_id=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&spltycode=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&patienttype=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nursingunitcode=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&gender=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&DOB=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&expdischargedatetime=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&leave_exp_dt_flag=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&patient_status=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&patient_age=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&&mlc_yn=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&pol_rep_no_vw=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&pol_stn_id_vw=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&pol_id_vw=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&setup_bl_dtls_in_ip_yn=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&allow_discharge_date_predc=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&max_disch_period_for_predc=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&bl_interfaced_yn=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&mother_cut_off_age_pda=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&mother_max_age_pda=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&pat_dtls_unknown_yn_pda=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&contact1_name_pda=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&contact2_name_pda=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:118%;width:100vw\'></iframe> \n\n\t\t\t\t<iframe id=\'frame3\' name=\'f_query_add_mod_button\' id=\'f_query_add_mod_button\' \t src=\'AddModifyDischargeAdvButtons.jsp?jsp_name=&win_height=1&win_width=40&patient_Id=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&is_ca_yn=Y&nursingunitcode=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:8%;width:100vw\'></iframe>\n\n\t\t\t\t<iframe id=\'frame4\' name=\'messageFrame\' id=\'messageFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:0%;width:100vw\'></iframe>\n\t\t\t\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t<title>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</title>\n\t\t\t<iframe name=\'pline\' id=\'pline\' SRC=\'\' noresize  frameborder=no scrolling=\'no\'>\n\t\t\t\t<!--Maheshwaran K added patient_class for the  JD-CRF-0145 [IN:030011] -- style=\'height:0%;width:100vw\'></iframe><iframe name=\'f_query_add_mod_display\' id=\'f_query_add_mod_display\' \t src=\'addmodifyDischargeAdvice.jsp?jsp_name=&win_height=1&win_width=40&is_ca_yn=Y&&EncounterId=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:70%;width:100vw\'></iframe> \n\t\t\t\t\n\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t src=\'AddModifyDischargeAdvTabs.jsp?jsp_name=&win_height=1&win_width=40&is_ca_yn=Y&EncounterId=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:118%;width:100vw\'></iframe> \n\n\t\t\t\t<iframe name=\'f_query_add_mod_button\' id=\'f_query_add_mod_button\' \t src=\'AddModifyDischargeAdvButtons.jsp?jsp_name=&win_height=1&win_width=40&patient_Id=";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:8%;width:100vw\'></iframe>\n\n\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:0%;width:100vw\'></iframe>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\n\t\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\n\t\n\t\t\n\n\n \n \n\t\n</html>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

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

/*
* This is used only when called from CA - Discharge Advice,
* This page is used to define frames...
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String locale = (String)session.getAttribute("LOCALE");
	
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8"); 
    Connection con  = null;
	ResultSet rs 	= null; 
	PreparedStatement pstmt 	= null;
	Statement stmt			=	null;
	StringBuffer SqlSB = new StringBuffer();
	String facilityId = (String)session.getValue("facility_id");
	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String EncounterId			= checkForNull(request.getParameter("encounter_id"));
	String ward_return="";
	
	//String query_string			= request.getParameter("query_string");
	//String option_id			= checkForNull(request.getParameter("option_id"));
	//String CA			= checkForNull(request.getParameter("CA"));
	String admissiondatetime	= "";
	String admissiontypedesc	= "";
	String specialtyshortdesc	= "";
	String practitionername		= "";
	String nursingunitshortdesc = "";
	String serviceshortdesc		= "";
	String bedno				= "";
	String roomno				= "";
	String bedclassshortdesc	= "";
	String bed_type_desc		= "";
	String practitioner_id		= "";
	int patient_age				= 0;
	String spltycode			= "";
	String patienttype 			= "";
	String nursingunitcode 		= "";
	String gender				= "";
	String DOB					= "";
	String expdischargedatetime = "";
	String patient_class		= "";
	String patient_status		= "";
	String pol_rep_no_vw		= "";
	String pol_stn_id_vw		= ""; 
	String pol_id_vw			= "";
	String mlc_yn				= "";
	String setup_bl_dtls_in_ip_yn		= "";
	String allow_discharge_date_predc	= "";
	String max_disch_period_for_predc	= "";
	String bl_interfaced_yn		= "";
	String mother_cut_off_age_pda		= "";
	String mother_max_age_pda			= "";
	String pat_dtls_unknown_yn_pda		= "";
	String contact1_name_pda			= "";
	String contact2_name_pda			= "";
	//String leave_expiry_date_time		= "";
	
	//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 Start
	String pre_disch_appl_yn			= "";
	String pre_dis_initiate_yn			= "";
	//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 End
	String chk_pen_sale_rtn_bfr_dis_adv	  =""; 
	String pend_sal_ret_fin_stats		  ="Y";

	String dis_adv_ot_pend_ord_yn	= "N";
	String isAllowDischargeDisAdv	= "Y";
	
	/*Added By Dharma on Nov 3rd 2014 against HSA-CRF-0181 [IN:049541]  Start*/
	String age								= "";
	String weight_on_admission				= "";
	String weight_on_admission_unit			= "";
	String weight_on_admission_unit_display	= "";
	String weight_on_admn_mandatory			= "";
	String chk_pen_ward_rtn_bfr_dis_adv			= "N";
	String is_value_already_captured		= "";
	int no_of_days							= 0;
	/*Added By Dharma on  Nov 3rd 2014 against HSA-CRF-0181 [IN:049541]  End*/
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission				= "";
	String height_on_admission_unit			= "";
	String height_on_admn_mandatory         = "";
	String enable_height_bmi_pat_cls        = "";
	String bmi="";
	String is_value_already_captured_height="";
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527  END*/

	
	String ip_leave_status		= "";
	String leave_exp_dt_flag	= "";
	boolean result				= true;
	int cnt						= 0;
	
	//Below code added by venkatesh on 28/November/2011 against the IP-CA-KDAH-CRF-0041-ICN-IN029671
	
	String chc_for_pen_orders_bfr_dis_adv="";
	String dis_adv_allow_yn="";
	String query="";
	int count =0;
	
  //List arr = new ArrayList<String>();
	// venkatesh IP-CA-KDAH-CRF-0041-ICN-IN029671 END

	try
	{
		con = ConnectionManager.getConnection(request);		
		Boolean isRestrictDisAdvSaleRetPend = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","RESTRICT_DIS_ADV_SALE_RET_PEND");
		/*Monday, May 10, 2010 , modified for PE */
		//pstmt = con.prepareStatement("select 1 from ip_discharge_advice where facility_id= ? and encounter_id = ? and DIS_ADV_STATUS!='9'" );
		//pstmt = con.prepareStatement("SELECT setup_bl_dtls_in_ip_yn,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN, TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date,max_disch_period_for_dc, bl_interfaced_yn , b.nb_mother_cutoff_age mother_cut_off_age,b.nb_mother_upper_age mother_max_age,(SELECT 1 FROM ip_discharge_advice WHERE facility_id = ? AND encounter_id = ? AND dis_adv_status != '9') cnt , (select ip_leave_status from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time >  sysdate or leave_expiry_date_time is null)) ip_leave_status FROM ip_param, mp_param b WHERE facility_id = ? AND b.module_id = 'MP'" );
		//Modified for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 (PRE_DIS_INITIATE_YN and pre_disch_appl_yn added to the query)
		//weight_on_admn_mandatory  Added By Dharma on  Nov 3rd 2014 against HSA-CRF-0181 [IN:049541
		
		String disSql	= "SELECT setup_bl_dtls_in_ip_yn,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN, TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date,max_disch_period_for_dc, bl_interfaced_yn , b.nb_mother_cutoff_age mother_cut_off_age,b.nb_mother_upper_age mother_max_age,(SELECT 1 FROM ip_discharge_advice WHERE facility_id = ? AND encounter_id = ? AND dis_adv_status != '9') cnt , (select ip_leave_status from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time >  sysdate or leave_expiry_date_time is null)) ip_leave_status,(select pre_dis_initiate_yn from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? ) pre_dis_initiate_yn,pre_disch_appl_yn,weight_on_admn_mandatory,chk_pen_ward_rtn_bfr_dis_adv,chk_pen_sale_rtn_bfr_dis_adv,dis_adv_ot_pend_ord_yn,(select ot_allow_discharge_patient('"+facilityId+"','"+EncounterId+"','"+patient_id+"') from dual) isAllowDischargeDisAdv ";

		if(isRestrictDisAdvSaleRetPend){
			disSql	= disSql + " ,(select ST_SAL_FIN_STATUS('"+patient_id+"','"+EncounterId+"','"+facilityId+"') from dual) pend_sal_ret_fin_stats ";
		}
		disSql	= disSql + " FROM ip_param, mp_param b WHERE facility_id = ? AND b.module_id = 'MP'";
		//pstmt = con.prepareStatement("SELECT setup_bl_dtls_in_ip_yn,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN, TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date,max_disch_period_for_dc, bl_interfaced_yn , b.nb_mother_cutoff_age mother_cut_off_age,b.nb_mother_upper_age mother_max_age,(SELECT 1 FROM ip_discharge_advice WHERE facility_id = ? AND encounter_id = ? AND dis_adv_status != '9') cnt , (select ip_leave_status from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time >  sysdate or leave_expiry_date_time is null)) ip_leave_status,(select pre_dis_initiate_yn from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? ) pre_dis_initiate_yn,pre_disch_appl_yn,weight_on_admn_mandatory,chk_pen_ward_rtn_bfr_dis_adv,chk_pen_sale_rtn_bfr_dis_adv,(select ST_SAL_FIN_STATUS('"+patient_id+"','"+EncounterId+"','"+facilityId+"') from dual) pend_sal_ret_fin_stats FROM ip_param, mp_param b WHERE facility_id = ? AND b.module_id = 'MP'" );
		pstmt = con.prepareStatement(disSql);
		pstmt.setString	( 1, facilityId ) ;
		pstmt.setString	( 2, EncounterId ) ;
		pstmt.setString	( 3, facilityId ) ;
		pstmt.setString	( 4, patient_id ) ;
		pstmt.setString	( 5, EncounterId ) ;
		/*Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 Start*/
		
		pstmt.setString	( 6, facilityId ) ;
		pstmt.setString	( 7, patient_id ) ;
		pstmt.setString	( 8, EncounterId ) ;
		pstmt.setString	( 9, facilityId ) ;
		
		/*Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 End*/
	
		
		rs=pstmt.executeQuery();
  
		if(rs!=null && rs.next())
        {
			setup_bl_dtls_in_ip_yn		= checkForNull(rs.getString("setup_bl_dtls_in_ip_yn"));
			allow_discharge_date_predc	= checkForNull(rs.getString("allow_discharge_date"));
			max_disch_period_for_predc	= checkForNull(rs.getString("max_disch_period_for_dc"));
			bl_interfaced_yn			= checkForNull(rs.getString("bl_interfaced_yn"));
			mother_cut_off_age_pda		= checkForNull(rs.getString("mother_cut_off_age"));
			mother_max_age_pda			= checkForNull(rs.getString("mother_max_age"));
			cnt							= rs.getInt("cnt");
			ip_leave_status				= checkForNull(rs.getString("ip_leave_status"));
			//Below code added by venkatesh on 28/November/2011 against the IP-CA-KDAH-CRF-0041-ICN-IN029671
			
			chc_for_pen_orders_bfr_dis_adv= checkForNull(rs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS_ADV"));
			dis_adv_allow_yn              =checkForNull(rs.getString("DIS_ADV_ALLOW_YN"));
			
		// venkatesh IP-CA-KDAH-CRF-0041-ICN-IN029671 END
			
			/*result = false;
			out.println("<script>alert(getMessage('DIS_ADVICE_ALREAD_EXISIT','IP'));</script>");*/
			//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 Start
			pre_disch_appl_yn			= checkForNull(rs.getString("pre_disch_appl_yn")); 
			pre_dis_initiate_yn			= checkForNull(rs.getString("pre_dis_initiate_yn"));
			//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 End
			weight_on_admn_mandatory	= checkForNull(rs.getString("weight_on_admn_mandatory"));//Added By Dharma on Nov 3rd 2014 against HSA-CRF-0181 [IN:049541] 
			chk_pen_ward_rtn_bfr_dis_adv	= checkForNull(rs.getString("chk_pen_ward_rtn_bfr_dis_adv"));
			chk_pen_sale_rtn_bfr_dis_adv	= checkForNull(rs.getString("chk_pen_sale_rtn_bfr_dis_adv"),"Y");
			if(isRestrictDisAdvSaleRetPend){
				pend_sal_ret_fin_stats	= checkForNull(rs.getString("pend_sal_ret_fin_stats"),"Y");
			}
		
			dis_adv_ot_pend_ord_yn	= checkForNull(rs.getString("dis_adv_ot_pend_ord_yn"),"N");
			isAllowDischargeDisAdv	= checkForNull(rs.getString("isAllowDischargeDisAdv"),"Y");
		}
		
		
		if(cnt > 0)
		{
			result = false;
			out.println("<script>alert(getMessage('DIS_ADVICE_ALREAD_EXISIT','IP'));</script>");
		}
		//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 Start
		else if(pre_disch_appl_yn.equals("Y") && pre_dis_initiate_yn.equals("N")){
			out.println("<script>alert(getMessage('PREDISCHARGE_NOT_INITIATED','IP'));</script>");
		}
		//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 End
		/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start*/
		else if(chk_pen_sale_rtn_bfr_dis_adv.equals("Y") && pend_sal_ret_fin_stats.equals("N") && isRestrictDisAdvSaleRetPend){
			result = false;
			out.println("<script>alert(getMessage('SALE_RET_PENDING_CNT_PROCEED','IP'));</script>");
		} 
		/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End*/
		else if(dis_adv_ot_pend_ord_yn.equals("Y") && isAllowDischargeDisAdv.equals("N")){
			result = false;
			out.println("<script>alert(getMessage('OT_REC_PENDING_CNT_PROCEED','IP'));</script>");

		} 
			else {
			/*Monday, May 10, 2010 , modified for PE & query merged to line no 39
			if(result)
			{
				if (rs != null)		rs.close();
				if (pstmt != null)	pstmt.close();
				pstmt = con.prepareStatement(" select 1 from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time >  sysdate or leave_expiry_date_time is null) AND ip_leave_status = '1' ");
				pstmt.setString	( 1, facilityId ) ;
				pstmt.setString	( 2, patient_id ) ;
				pstmt.setString	( 3, EncounterId ) ;
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next())
				{
						result = false;
						out.println("<script>alert(getMessage('LEAVE_CANNOT_DISCHARGE_ADYC','IP'));</script>");
				}
				

			}
			if(result)
			{
				if (rs != null)		rs.close();
				if (pstmt != null)	pstmt.close();
				pstmt = con.prepareStatement(" select 1 from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time > sysdate or leave_expiry_date_time is null) AND ip_leave_status = '3' ");
				pstmt.setString	( 1, facilityId ) ;
				pstmt.setString	( 2, patient_id ) ;
				pstmt.setString	( 3, EncounterId ) ;
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next())
				{
						result = false;
						out.println("<script>alert(getMessage('NOSHOW_CANNOT_DISCHARGE_ADYC','IP'));</script>");
				}
				

			}
			if(result)
			{
				if (rs != null)		rs.close();
				if (pstmt != null)	pstmt.close();
				pstmt = con.prepareStatement(" select 1 from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time > sysdate or leave_expiry_date_time is null) AND ip_leave_status = '4' ");
				pstmt.setString	( 1, facilityId ) ;
				pstmt.setString	( 2, patient_id ) ;
				pstmt.setString	( 3, EncounterId ) ;
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next())
				{
						result = false;
						out.println("<script>alert(getMessage('ABS_CANNOT_DISCHARGE_ADYC','IP'));</script>");
				}
				

			}*/
		
			if(result && ip_leave_status.equals("1") )
			{
				result = false;
				out.println("<script>alert(getMessage('LEAVE_CANNOT_DISCHARGE_ADYC','IP'));</script>");
			}
			if(result && ip_leave_status.equals("3") )
			{
				result = false;
				out.println("<script>alert(getMessage('NOSHOW_CANNOT_DISCHARGE_ADYC','IP'));</script>");
			}
			if(result && ip_leave_status.equals("4") )
			{
				result = false;
				out.println("<script>alert(getMessage('ABS_CANNOT_DISCHARGE_ADYC','IP'));</script>");
			}
			
			
			
			
			if(result && "y".equalsIgnoreCase(chk_pen_ward_rtn_bfr_dis_adv)){			
				

				
			
				pstmt = con.prepareStatement("SELECT distinct patient_id, store_acknowledge_status store_status FROM ph_ward_return_dtl a, ph_ward_return_hdr b WHERE a.facility_id = b.facility_id AND a.ret_doc_no = b.ret_doc_no AND patient_id = ? and encounter_id=? and b.facility_id=? and store_acknowledge_status is null");
				pstmt.setString	( 1, patient_id ) ;
				pstmt.setString	( 2, EncounterId ) ;
				pstmt.setString	( 3, facilityId ) ;
				rs=pstmt.executeQuery();

				if (rs!=null && rs.next()){
					 ward_return=rs.getString("store_status")==null?"W":rs.getString("store_status");  
				}

				

				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ward_return));
            _bw.write(_wl_block10Bytes, _wl_block10);

			
			}
			
			//Below code added by venkatesh on 28/November/2011 against the IP-CA-KDAH-CRF-0041-ICN-IN029671
		
		
			
			
			if (result && chc_for_pen_orders_bfr_dis_adv.equals("Y") )
			{  
			
				/*stmt =con.createStatement();
				query ="SELECT COUNT (*)conut,b.long_desc FROM or_order a ,or_order_category b WHERE order_status IN (SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE oper_or_group_ref = 'OPER_AMENDCANCEL' AND a.order_status_type = b.order_status_type) AND patient_id = '"+patient_id+"'AND encounter_id = '"+EncounterId+"' AND patient_class IN ('IP','DC') AND a.ORDER_CATEGORY=b.ORDER_CATEGORY AND b.order_category IN (SELECT order_category FROM or_order_category WHERE chk_pend_ord_category = 'Y') group by b.ORDER_CATEGORY,b.long_desc";
				
				rs =stmt.executeQuery(query);
				
				
				while (rs.next())
				{
				count=0;
			   arr.add(rs.getString("LONG_DESC"));
			   String temp=rs.getString("LONG_DESC");
			  
				/*count++;
				}
				} 
						
				count=arr.size();	
				*/

				String ord_stat="";
				stmt =con.createStatement();
				query ="select Or_patient_Order_Pend('"+patient_id+"','"+facilityId+"','"+EncounterId+"','A') ord_stat   from dual";
				rs =stmt.executeQuery(query);

				if (rs!=null && rs.next()){
					ord_stat=rs.getString("ord_stat");
				}

				if(ord_stat.equals("Y")){
					count=1;
				}else{
					count=0;
				}

				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block15Bytes, _wl_block15);


			}
			//out.println("count" + count);
	// venkatesh IP-CA-KDAH-CRF-0041-ICN-IN029671 END






		
		
		
		if(result)
			{	
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				SqlSB.append(" SELECT ");
				SqlSB.append("	To_char(a.Admission_Date_Time,'dd/mm/rrrr HH24:mi') Admission_Date_Time,");
				SqlSB.append("        c.Sex Gender,");
				SqlSB.append("        a.Encounter_Id,");
				SqlSB.append("        To_char(a.exp_Discharge_Date_Time,'dd/mm/rrrr HH24:mi') exp_Discharge_Date_Time,");
				SqlSB.append("        ip_Get_desc.Ip_admission_type(a.Admission_Type,'"+locale+"',2) Admission_Short_desc,");
				SqlSB.append("        a.Specialty_Code,");
				SqlSB.append("        Am_Get_desc.Am_speciality(a.Specialty_Code,'"+locale+"',2) Specialty_Short_desc,");
				SqlSB.append("        a.Encounter_Id,");
				SqlSB.append("        a.Attend_Practitioner_Id practitioner_id,");
				SqlSB.append("        Am_Get_desc.Am_practitioner(a.Attend_Practitioner_Id,'"+locale+"',1) Practitioner_Name,");
				SqlSB.append("        NULL Patient_Type_Short_desc,");
				SqlSB.append("        a.nurSing_Unit_Code,");
				SqlSB.append("        ip_Get_desc.Ip_nursing_unit(a.Facility_Id,a.nurSing_Unit_Code,'"+locale+"',2) nurSing_Unit_Short_desc,");
				SqlSB.append("        Am_Get_desc.Am_service(a.Service_Code,'"+locale+"',2) Service_Short_desc,");
				SqlSB.append("        a.Bed_num Bed_No,");
				SqlSB.append("        a.Room_num Room_No,");
				SqlSB.append("        a.Patient_Class,");
				SqlSB.append("        a.oth_Adt_Status,");
				SqlSB.append("        DECODE(Sign((a.Leave_exPiry_Date_Time - SYSDATE)),");
				SqlSB.append("               -1,'Y',");
				SqlSB.append("                                                          ");
				SqlSB.append("               'N') Leave_Flag,");
				SqlSB.append("        To_char(c.Date_Of_Birth,'dd/mm/rrrr') Date_Of_Birth,");
				SqlSB.append("        Calculate_age(To_char(c.Date_Of_Birth,'dd/mm/rrrr'),1) Patient_Age,");
				SqlSB.append("        ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,'"+locale+"',2) Bed_Type_Short_desc,");
				SqlSB.append("        ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,'"+locale+"',2) Bed_Class_Short_desc,");
				SqlSB.append("        a.pol_rep_No,");
				SqlSB.append("        a.pol_stn_Id,");
				SqlSB.append("        a.pol_Id,");
				SqlSB.append("        a.mlc_yn");
				SqlSB.append("        , c.pat_dtls_unknown_yn, b.contact1_name, b.contact2_name ");
				SqlSB.append(" ,a.height_on_admission,a.bmi ");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
				SqlSB.append(" 		  , get_age(c.DATE_OF_BIRTH) age,a.weight_on_admission,a.weight_on_admission_unit,trunc (sysdate) - trunc (c.DATE_OF_BIRTH) no_of_days  ");//Added By Dharma on Nov 3rd 2014 against HSA-CRF-0181 [IN:049541]
				SqlSB.append(" FROM   IP_OPEN_ENCOUNTER a,");
				SqlSB.append("        mp_pat_rel_contacts b,");
				SqlSB.append("        MP_PATIENT c");
				SqlSB.append(" WHERE  a.Facility_Id = '"+facilityId+"'");
				SqlSB.append("        AND a.Encounter_Id = '"+EncounterId+"'");
				SqlSB.append("        AND a.patient_id = b.patient_id");
				SqlSB.append("        AND a.patient_id = c.patient_id");
				SqlSB.append("        AND b.patient_id = c.patient_id");
				

	/*

				SqlSB.append(" SELECT TO_CHAR(admission_date_time,'dd/mm/rrrr HH24:mi') admission_date_time,");
				SqlSB.append(" a.gender gender, a.encounter_id, ");
				SqlSB.append(" TO_CHAR (exp_discharge_date_time,'dd/mm/rrrr HH24:mi') exp_discharge_date_time,");
				SqlSB.append(" a.admission_short_desc, a.specialty_code, ");
				SqlSB.append(" a.specialty_short_desc, a.encounter_id, a.admission_short_desc,");
				SqlSB.append(" a.practitioner_id, a.practitioner_name, a.patient_type_short_desc,");
				SqlSB.append(" a.nursing_unit_code, a.nursing_unit_short_desc, ");
				SqlSB.append(" a.service_short_desc, a.bed_no, a.room_no, a.patient_class, a.oth_adt_status, ");
				SqlSB.append(" decode(sign(( leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag,");
				SqlSB.append(" to_char(a.date_of_birth,'dd/mm/rrrr') date_of_birth,");
				SqlSB.append(" calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),1) patient_age,");
				SqlSB.append(" a.bed_type_short_desc, a.bed_class_short_desc, POL_REP_NO, POL_STN_ID, POL_ID, MLC_YN ");
				SqlSB.append(" FROM ");
				SqlSB.append(" ip_open_encounter_vw a, pr_encounter_other_detail b ");
				SqlSB.append(" WHERE ");
				SqlSB.append(" a.facility_id = '"+facilityId+"' ");
				SqlSB.append(" AND a.encounter_id ='"+EncounterId+"' ");
				SqlSB.append(" AND a.facility_id = b.operating_facility_id ");
				SqlSB.append(" AND a.encounter_id = b.encounter_id" );
	*/


				stmt=con.createStatement();
				rs=stmt.executeQuery(SqlSB.toString());
				if(rs.next())
				{
					admissiondatetime 	= checkForNull(rs.getString("admission_date_time"));
					admissiontypedesc 	= checkForNull(rs.getString("admission_short_desc"));
					specialtyshortdesc 	= checkForNull(rs.getString("specialty_short_desc"));
					practitionername 	= checkForNull(rs.getString("practitioner_name"));
					nursingunitshortdesc= checkForNull(rs.getString("Nursing_unit_short_desc"));
					serviceshortdesc 	= checkForNull(rs.getString("service_short_desc"));
					bedno 				= checkForNull(rs.getString("bed_no"));
					roomno 				= checkForNull(rs.getString("room_no"));
					bedclassshortdesc 	= checkForNull(rs.getString("bed_class_short_desc"));
					bed_type_desc		= checkForNull(rs.getString("bed_type_short_desc"));
						session.putValue("practitioner_name",practitionername);
					practitioner_id		= checkForNull(rs.getString("practitioner_id"));
					patient_age			= Integer.parseInt(rs.getString("patient_age"))	;
					spltycode			= checkForNull(rs.getString("specialty_code"));
					patienttype 		= checkForNull(rs.getString("patient_type_short_desc"));
					nursingunitcode 	= checkForNull(rs.getString("nursing_unit_code"));
					gender				= checkForNull(rs.getString("gender"));
					DOB					= checkForNull(rs.getString("date_of_birth"));
					expdischargedatetime= checkForNull(rs.getString("exp_discharge_date_time"));
					patient_class		= checkForNull(rs.getString("patient_class"));
					patient_status		= checkForNull(rs.getString("OTH_ADT_STATUS"));
				
					mlc_yn				= checkForNull(rs.getString("MLC_YN"),"N");
					pol_rep_no_vw		= checkForNull(rs.getString("POL_REP_NO"));
					pol_stn_id_vw		= checkForNull(rs.getString("POL_STN_ID"));
					pol_id_vw			= checkForNull(rs.getString("POL_ID"));

					pat_dtls_unknown_yn_pda			= checkForNull(rs.getString("pat_dtls_unknown_yn"));
					contact1_name_pda				= checkForNull(rs.getString("contact1_name"));
					contact2_name_pda				= checkForNull(rs.getString("contact2_name"));
					contact2_name_pda				= checkForNull(rs.getString("contact2_name"));
					/*Tuesday, December 28, 2010 , SRR20056-SCF-6317 [IN:025692]*/
					leave_exp_dt_flag	= rs.getString("leave_flag");
							if(leave_exp_dt_flag == null) leave_exp_dt_flag="";
							
					/*Added By Dharma on Nov 3d 2014 against HSA-CRF-0181 [IN:049541]  Start*/
					age  				= checkForNull(rs.getString("age"));
					weight_on_admission			= checkForNull(rs.getString("weight_on_admission"));
					weight_on_admission_unit	= checkForNull(rs.getString("weight_on_admission_unit"));
					no_of_days					= rs.getInt("no_of_days");
					/*Added By Dharma on Nov 3d 2014 against HSA-CRF-0181 [IN:049541]  End*/	
					/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
						height_on_admission			= checkForNull(rs.getString("height_on_admission"));
						bmi			= checkForNull(rs.getString("bmi"));
						/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END*/

				}
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				
				/*Added By Dharma on Nov 3rd 2014 against HSA-CRF-0181 [IN:049541]  Start*/
				String is_validate_weight_on_admission	= (weight_on_admn_mandatory.equals("P")?"Y":"N");
				if(weight_on_admission.equals("") && weight_on_admission_unit.equals("")){
					/*String lastchar	="";
					int calculate_age	= 0;
					if (age.length() > 0 ){
						lastchar		= age.substring(age.length() - 1);
						if (!age.contains("Y"))
							calculate_age	= Integer.parseInt(age.substring(0, age.length()-1));
					}
					weight_on_admission_unit	= (lastchar.equals("D")?(calculate_age >30 ? "K":"G"):"K");*/
					weight_on_admission_unit	= (no_of_days >30 ? "K":"G");
				}else{
					is_value_already_captured	= "Y";
				}
				weight_on_admission_unit_display	= (weight_on_admission_unit.equals("G")?"Gram":"Kg");
				/*Added By Dharma on Nov 3rd 2014 against HSA-CRF-0181 [IN:049541]  End*/
				
				/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527  Start*/
		if(height_on_admn_mandatory.equals("")||enable_height_bmi_pat_cls.equals("")){//If discharge advise called from CA.
			stmt=con.createStatement();
			rs=stmt.executeQuery("select HEIGHT_ON_ADMN_MANDATORY,ENABLE_HEIGHT_BMI_PAT_CLS from ip_param where facility_id = '"+facilityId+"'");
			if(rs.next()){
				 height_on_admn_mandatory	= checkForNull(rs.getString("height_on_admn_mandatory"));
				 enable_height_bmi_pat_cls	= checkForNull(rs.getString("enable_height_bmi_pat_cls"));
			}
		}
		if (rs != null)		rs.close();
		if (stmt != null)	stmt.close();
		String is_validate_height_on_admission = (height_on_admn_mandatory.equals("P")?"Y":"N");
		if(height_on_admission.equals("") || height_on_admission_unit.equals("")){
			height_on_admission_unit	= ("Cm");
		}
		else{
			is_value_already_captured_height = "Y";
		}
		/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527  End*/


			
            _bw.write(_wl_block16Bytes, _wl_block16);
 
			if(chc_for_pen_orders_bfr_dis_adv.equals("Y") && count >0 ){ if(dis_adv_allow_yn.equals("Y")){ 
		
			
			
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(EncounterId)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_id)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiondatetime)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitionername,"UTF-8")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedno,"UTF-8")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(roomno,"UTF-8")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type_desc,"UTF-8")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(weight_on_admission));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(weight_on_admission_unit));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(weight_on_admission_unit_display));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(is_validate_weight_on_admission));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(is_value_already_captured));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(height_on_admission));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(height_on_admission_unit));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(is_validate_height_on_admission));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(is_value_already_captured_height));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(EncounterId)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_id)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiondatetime)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitionername,"UTF-8")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedno,"UTF-8")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(roomno,"UTF-8")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type_desc,"UTF-8")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_id)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(spltycode)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLEncoder.encode(patienttype)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitcode)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(java.net.URLEncoder.encode(gender)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(java.net.URLEncoder.encode(DOB)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(java.net.URLEncoder.encode(expdischargedatetime)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(java.net.URLEncoder.encode(leave_exp_dt_flag)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_status)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(java.net.URLEncoder.encode(mlc_yn)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(java.net.URLEncoder.encode(pol_rep_no_vw,"UTF-8")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(java.net.URLEncoder.encode(pol_stn_id_vw,"UTF-8")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(java.net.URLEncoder.encode(pol_id_vw,"UTF-8")));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(java.net.URLEncoder.encode(setup_bl_dtls_in_ip_yn)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(java.net.URLEncoder.encode(allow_discharge_date_predc)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(java.net.URLEncoder.encode(max_disch_period_for_predc)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(java.net.URLEncoder.encode(bl_interfaced_yn)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(java.net.URLEncoder.encode(mother_cut_off_age_pda)));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(java.net.URLEncoder.encode(mother_max_age_pda)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(java.net.URLEncoder.encode(pat_dtls_unknown_yn_pda)));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(java.net.URLEncoder.encode(contact1_name_pda,"UTF-8")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(java.net.URLEncoder.encode(contact2_name_pda,"UTF-8")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitcode)));
            _bw.write(_wl_block68Bytes, _wl_block68);
 out.println("<script>message(myarr,'"+dis_adv_allow_yn+"','"+count+"','"+ward_return+"','"+chk_pen_ward_rtn_bfr_dis_adv+"');</script>");
				
			}if(dis_adv_allow_yn.equals("N")) { 
			out.println("<script> message(myarr,'"+dis_adv_allow_yn+"','"+count+"','"+ward_return+"','"+chk_pen_ward_rtn_bfr_dis_adv+"');</script>");
			} }
			
            _bw.write(_wl_block16Bytes, _wl_block16);
 if (count==0 && !"w".equalsIgnoreCase(ward_return))
			{ 
			
			
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(java.net.URLEncoder.encode(EncounterId)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_id)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiondatetime)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitionername,"UTF-8")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedno,"UTF-8")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(roomno,"UTF-8")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type_desc,"UTF-8")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(weight_on_admission));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(weight_on_admission_unit));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(weight_on_admission_unit_display));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(is_validate_weight_on_admission));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(is_value_already_captured));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(is_validate_height_on_admission));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(is_value_already_captured_height));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(height_on_admission));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(height_on_admission_unit));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(java.net.URLEncoder.encode(EncounterId)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_id)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiondatetime)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitionername,"UTF-8")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedno,"UTF-8")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(roomno,"UTF-8")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type_desc,"UTF-8")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_id)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(spltycode)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLEncoder.encode(patienttype)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitcode)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(java.net.URLEncoder.encode(gender)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(java.net.URLEncoder.encode(DOB)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(java.net.URLEncoder.encode(expdischargedatetime)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(java.net.URLEncoder.encode(leave_exp_dt_flag)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_status)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(java.net.URLEncoder.encode(mlc_yn)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(java.net.URLEncoder.encode(pol_rep_no_vw,"UTF-8")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(java.net.URLEncoder.encode(pol_stn_id_vw,"UTF-8")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(java.net.URLEncoder.encode(pol_id_vw,"UTF-8")));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(java.net.URLEncoder.encode(setup_bl_dtls_in_ip_yn)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(java.net.URLEncoder.encode(allow_discharge_date_predc)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(java.net.URLEncoder.encode(max_disch_period_for_predc)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(java.net.URLEncoder.encode(bl_interfaced_yn)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(java.net.URLEncoder.encode(mother_cut_off_age_pda)));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(java.net.URLEncoder.encode(mother_max_age_pda)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(java.net.URLEncoder.encode(pat_dtls_unknown_yn_pda)));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(java.net.URLEncoder.encode(contact1_name_pda,"UTF-8")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(java.net.URLEncoder.encode(contact2_name_pda,"UTF-8")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitcode)));
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
	}
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());
	e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block75Bytes, _wl_block75);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargeAdvice.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrepareDischargeAdvice.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrepareDischargeAdvice.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
