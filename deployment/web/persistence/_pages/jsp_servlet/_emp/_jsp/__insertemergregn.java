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
import webbeans.eCommon.ConnectionManager;

public final class __insertemergregn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/InsertEmergRegn.jsp", 1727256497300L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n    <head>\t \n        <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n        <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n        <Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t\t<Script language=\"JavaScript\" src=\"../../eMP/js/SmartCard.js\"></Script>\n\t\t<Script language=\"JavaScript\"src=\"../../eCommon/js/DateUtils.js\" ></Script>\n\t\t<!--Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1-->\n\t\t<Script language=\"JavaScript\" src=\"../../eMP/js/EmployeePrivilege.js\"></Script>\n\t\t<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\n\t\t<Script src=\"../../eMP/js/json02.js\"></Script>\n\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<Script language=\"JavaScript\"src=\"../../eCommon/js/dchk.js\" ></Script>\n        <Script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration3.js\'></Script>\n         <script language=\'javascript\' src=\'../../eMP/js/EmergRegn.js\'></script> \n\t\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></Script>\n\t\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t\t<Script language=\"JavaScript\" src=\"../../eAE/js/AERegisterAttn.js\"></Script>\n\n\n\n\n        \n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t        <script>\n\t\t\t\tif (parent.frames[0].document.getElementById(\"patient_id\"))\n\t\t\t\t    parent.frames[0].document.getElementById(\"patient_id\").maxLength =\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\t\t\t\t\t\n\t\t\t</script>\n\t\t</head>\n\t\t\t\t\n\n\t\t<body onSelect=\"codeArrestThruSelect()\" OnMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey()\'  onload=\'change_status_emer();chkDetailsUnknown();\'>\n\t\t\t<form name=\"Emergency_Regn\" id=\"Emergency_Regn\" action=\"../../servlet/eMP.PatientRegistrationServlet\" method=\"post\" target=\"messageFrame\">\n\t\t\t\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t\t<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t                    <td class=\'label\' nowrap width=\'10%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t                <td colspan=\'8\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'details_unknown\' id=\'details_unknown\' value=\'N\' disabled>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" <!--Modified by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689-->\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'details_unknown\' id=\'details_unknown\' value=\'Y\' checked disabled>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<input type=\'checkbox\'  checked name=\'details_unknown\' id=\'details_unknown\' value=\'Y\' onclick=\'chkDetailsUnknown()\' tabindex=\'-1\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t    </tr>\n\t\t\t\t\t<tr><td colspan=\'8\' class=\'white\'>&nbsp;</td></tr>\n\t\t\t\t</table>\n\t\t\t\t<input type=\'hidden\' name=\'accept_national_id_no\' id=\'accept_national_id_no\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_accept_oth_pat_ser_yn\' id=\'alt_id1_accept_oth_pat_ser_yn\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_accept_alphanumeric_yn\' id=\'alt_id1_accept_alphanumeric_yn\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t<!--  added by mujafar for ML-MMOH-CRF-524.1 start -->\t\n\t\t\t<input type=\'hidden\' name=\'alt_id1_alphanum_validate_yn\' id=\'alt_id1_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t\t<input type=\'hidden\' name=\'alt_id2_alphanum_validate_yn\' id=\'alt_id2_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id3_alphanum_validate_yn\' id=\'alt_id3_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id4_alphanum_validate_yn\' id=\'alt_id4_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t\t<!-- added by mujafar for ML-MMOH-CRF-524.1 end -->\n\t\t\t\t<input type=\'hidden\' name=\'max_patient_age\' id=\'max_patient_age\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t<input type =\'hidden\' name=\'family_org_id_accept_yn\' id=\'family_org_id_accept_yn\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"></input>\n\t\t\t\t<input type =\'hidden\' name=\'entitlement_by_pat_cat_yn\' id=\'entitlement_by_pat_cat_yn\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"></input>\n\t\t\t\t<!-- Below Added by Suji keerthi on 04-Dec-2019 for KDAH-CRF-0522 -->\n\t\t\t\t<input type =\'hidden\' name=\'pat_cat_reqd_yn\' id=\'pat_cat_reqd_yn\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></input>\n\t\t\t\t<input type =\'hidden\' name=\'org_member_relationship_code\' id=\'org_member_relationship_code\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></input>\n\t\t\t\t<input type =\'hidden\' name=\'org_member_relationship_desc\' id=\'org_member_relationship_desc\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"></input>\n\n\t\t\t\t<!--Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start -->\n\t\t\t\t<input type=\"hidden\" name=\"alt_id2_accept_oth_pat_ser_yn\" id=\"alt_id2_accept_oth_pat_ser_yn\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"alt_id2_accept_alphanumeric_yn\" id=\"alt_id2_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" /> \n\t\t\t\t<!--Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End -->\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\n\t\t\t<!-- Added by Ashwin K for AAKH-CRF-0150-->\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<!-- Ended by Ashwin K for AAKH-CRF-0150-->\n\t\t\t\t<table>\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t</tr><tr></tr><tr></tr>\n\t\t\t\t</table>\t         \n\t\t\t\t<input type=\'hidden\' name=\'maintain_doc_or_file\' id=\'maintain_doc_or_file\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'create_file_at_pat_regn_yn\' id=\'create_file_at_pat_regn_yn\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"></input>\n\t\t\t\t\n\t\t\t<!-- \t<input type=\"hidden\" name=\"place_of_birth_code\" id=\"place_of_birth_code\" > --> \n\t\t\t\t<input type=\"hidden\" name=\"citizen\" id=\"citizen\">\n\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\"\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'patient_name_loc_lang\' id=\'patient_name_loc_lang\' value=\"\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'name_drvn_logic\' id=\'name_drvn_logic\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_long\' id=\'name_drvn_logic_long\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_oth_lang\' id=\'name_drvn_logic_oth_lang\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_oth_lang_long\' id=\'name_drvn_logic_oth_lang_long\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'dflt_grp\' id=\'dflt_grp\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'pat_no_gen_yn\' id=\'pat_no_gen_yn\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'patient_group\' id=\'patient_group\' value=\'G\'>\n\t\t\t\t<input type=\'hidden\' name=\'patient_name_long\' id=\'patient_name_long\' value=\"\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'patient_name_loc_lang_long\' id=\'patient_name_loc_lang_long\' value=\"\"></input>\n\t\t\t\t<!-- Comment : The above hidden fields should always be before the code wiche is the below script -->\n\n\t\t\t\t<script>\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].national_id_no.focus();\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tFocusFirstElement();\n\t\t\t\t\t}\n\t\t\t\t\tputPatientName(document.forms[0].first_name);\n\t\t\t\t</script>\n\n\t\t\t\t<input type=\'hidden\' name=\'dflt_nationality_code\' id=\'dflt_nationality_code\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'dflt_pat_regn_blng_class\' id=\'dflt_pat_regn_blng_class\' value=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =">\n\t\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'nat_id_val\' id=\'nat_id_val\' value=\'S\'>\n\t\t\t\t<input type=\'hidden\' name=\'error_alt_no1\' id=\'error_alt_no1\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'error_alt_no2\' id=\'error_alt_no2\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'pat_ser_grpcode\' id=\'pat_ser_grpcode\' value=\"\"> \n\t\t\t\t<input type=\'hidden\' name=\'Alt_Id1_Unique_Yn1\' id=\'Alt_Id1_Unique_Yn1\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'Alt_Id1_Unique_Yn2\' id=\'Alt_Id1_Unique_Yn2\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'EMERG_REG\'>\n\t\t\t\t<input type=\'hidden\' name=\'func_act\' id=\'func_act\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_exp_date_fromHCS\' id=\'alt_exp_date_fromHCS\' value=\"N\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'transaction_continue\' id=\'transaction_continue\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'setlmt_ind\' id=\'setlmt_ind\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\t\t\t\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'default_race_code\' id=\'default_race_code\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'sflag\' id=\'sflag\' value=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =">\n\t\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'datasource_id\' id=\'datasource_id\' value=\"\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'dflt_pat_ser_grp_code\' id=\'dflt_pat_ser_grp_code\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"></input>\n\n\t\t\t\t<input type =\'hidden\' name=\'altId1Desc\' id=\'altId1Desc\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t<input type =\'hidden\' name=\'altId2Desc\' id=\'altId2Desc\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t<input type =\'hidden\' name=\'altId3Desc\' id=\'altId3Desc\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t<input type =\'hidden\' name=\'altId4Desc\' id=\'altId4Desc\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\n\n\t\t\t\t<br><br>\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.forms[0].pat_ser_grp_code.disabled = false;\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' == \'Y\')\n\t\t\t\t\t\tdocument.forms[0].pat_ser_grp_code.value = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' == \'AE\'){\n\t\t\t\t\t\tdocument.forms[0].pat_ser_grp_code.value = \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<!-- FOR MYKAD READING -->\n\t\t\t\t<OBJECT id=Cad style=\\\"WIDTH: 149px; HEIGHT: 25px\\\" data=data:application/x-oleobject;base64,6bldI31CwEeRWh+s54i2NAADAABmDwAAlQIAAA== classid=clsid:235DB9E9-427D-47C0-915A-1FACE788B634></OBJECT>\n\t\t\t\t<OBJECT id=jpndf1 style=\\\"WIDTH: 192px; HEIGHT: 24px\\\" data=data:application/x-oleobject;base64,arMlNbqDrEKC9D9p0v5gBQADAADYEwAAewIAAA== classid=clsid:3525B36A-83BA-42AC-82F4-3F69D2FE6005></OBJECT>\n\t\t\t\t<OBJECT id=jpndf4 style=\\\"LEFT: 0px; WIDTH: 192px; TOP: 0px; HEIGHT: 24px\\\" data=data:application/x-oleobject;base64,zUFYb5tV40iaOd6s6vQBygADAADYEwAAewIAAA== classid=clsid:6F5841CD-559B-48E3-9A39-DEACEAF401CA></OBJECT>\n\t\t\t\t<OBJECT id=gmpcpic style=\\\"WIDTH: 345px; HEIGHT: 303px\\\" data=data:application/x-oleobject;base64,2lmqMIeVKU6C6+Ww4x0h3QADAACoIwAAUR8AAA== classid=clsid:30AA59DA-9587-4E29-82EB-E5B0E31D21DD></OBJECT> \n\t\t\t\t<!-- FOR MYKAD READING -->\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t</form>\n\t <script>\n\t\t document.forms[0].ethnic_group.disabled=false;\n\t\t populateethnicity();\n\t\t document.forms[0].ethnic_group.disabled=true;\n\t</script>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" : inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		
            _bw.write(_wl_block9Bytes, _wl_block9);

	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");		
		Connection con				= null;
		PreparedStatement pstmt		= null;
        PreparedStatement pstmt1	= null;
		ResultSet rset				= null;		
		
		String name_dervn_logic_oth_lang = "" ;	
		String name_drvn_logic_oth_lang_long = "" ;	
		String name_dervn_logic = "" ;	
		String name_drvn_logic_long = "" ;	
		String patient_id_length = "" ;	
		String accept_national_id_no_yn			= "N";
		String nat_id_accept_alphanumeric_yn	= "N";
		String alt_id1_accept_oth_pat_ser_yn	= "N"; 
		String alt_id1_accept_alphanumeric_yn	= "N";
		String max_pat_age						= "";
		String dflt_nationality					= "";
		String default_race_code				= "";
		String gen_slno_unknown_pat_yn			= "";
		String maintain_doc_or_file			= "";
		String emer_blng_grp_id				= "";
		String transaction_continue			= "Y";
		String setlmt_ind					= "";
		String create_file_at_pat_regn_yn	= "";
		String ext_system_interface_yn		= "";
		String nat_data_source_id		= "";
		String dfltPSG						= "";
		String org_member_relationship_desc	= "";
		String family_org_id_accept_yn="";
		String org_member_relationship_code="";
		String entitlement_by_pat_cat_yn="";
		String pat_category_reqd_yn=""; //Added by Suji keerthi on 04-Dec-2019 for KDAH-CRF-0522
		String alt_id1_unique_yn="";
		String alt_id2_unique_yn="";
		String emeg_pat_ser_grp				= "";
		String gen_pat_ser_grp				= "";
		String dflt_grp				= "";
		String alt_id1_desc = "";
		String alt_id2_desc = "";
		String alt_id3_desc = "";
		String alt_id4_desc = "";
		String Site	 	= "";
		/* added by mujafar for ML-MMOH-CRF-524.1 START	*/
		String alt_id1_alphanum_validate_yn = "N" ; 
		String alt_id2_alphanum_validate_yn = "N" ;
		String alt_id3_alphanum_validate_yn = "N" ;
		String alt_id4_alphanum_validate_yn = "N" ; 
		/* added by mujafar for ML-MMOH-CRF-524.1 END	*/

		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
		String alt_id2_accept_oth_pat_ser_yn		= "";
		String alt_id2_accept_alphanumeric_yn		= "";

		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */

		String function_name =""; //Added by Ashwin K for AAKH-CRF-0150
		String pat_series =""; //Added by Ashwin K for AAKH-CRF-0150

		alt_id1_desc=request.getParameter("alt_id1_desc");		
		alt_id2_desc=request.getParameter("alt_id2_desc");		
		alt_id3_desc=request.getParameter("alt_id3_desc");		
		alt_id4_desc=request.getParameter("alt_id4_desc");		
		name_dervn_logic_oth_lang=request.getParameter("name_dervn_logic_oth_lang");		
		name_drvn_logic_oth_lang_long=request.getParameter("name_dervn_logic_oth_lang_long");		
		name_dervn_logic=request.getParameter("name_dervn_logic");
		name_drvn_logic_long=request.getParameter("name_drvn_logic_long");
		patient_id_length=request.getParameter("patient_id_length");
		accept_national_id_no_yn=request.getParameter("accept_national_id_no_yn");
		nat_id_accept_alphanumeric_yn=request.getParameter("nat_id_accept_alphanumeric_yn");
		alt_id1_accept_oth_pat_ser_yn=request.getParameter("alt_id1_accept_oth_pat_ser_yn");
		alt_id1_accept_alphanumeric_yn=request.getParameter("alt_id1_accept_alphanumeric_yn");
		/* added by mujafar for ML-MMOH-CRF-524.1 START */	
		alt_id1_alphanum_validate_yn = request.getParameter("alt_id1_alphanum_validate_yn");
		alt_id2_alphanum_validate_yn = request.getParameter("alt_id2_alphanum_validate_yn");
		alt_id3_alphanum_validate_yn = request.getParameter("alt_id3_alphanum_validate_yn");
		alt_id4_alphanum_validate_yn = request.getParameter("alt_id4_alphanum_validate_yn");
		 /* added by mujafar for ML-MMOH-CRF-524.1 END */	
		max_pat_age=checkForNull(request.getParameter("max_pat_age"));
		dflt_nationality=request.getParameter("dflt_nationality");
		default_race_code=request.getParameter("default_race_code");
		gen_slno_unknown_pat_yn=request.getParameter("gen_slno_unknown_pat_yn");
		maintain_doc_or_file=request.getParameter("maintain_doc_or_file");
		create_file_at_pat_regn_yn=request.getParameter("create_file_at_pat_regn_yn");
		ext_system_interface_yn=request.getParameter("ext_system_interface_yn");
		nat_data_source_id=request.getParameter("nat_data_source_id");
		family_org_id_accept_yn=request.getParameter("family_org_id_accept_yn");
		org_member_relationship_code=request.getParameter("org_member_relationship_code");
		entitlement_by_pat_cat_yn=request.getParameter("entitlement_by_pat_cat_yn");
		pat_category_reqd_yn=request.getParameter("pat_category_reqd_yn"); //Added by Suji keerthi on 04-Dec-2019 for KDAH-CRF-0522
		alt_id1_unique_yn=request.getParameter("alt_id1_unique_yn");
		alt_id2_unique_yn=request.getParameter("alt_id2_unique_yn");
		emeg_pat_ser_grp=request.getParameter("emeg_pat_ser_grp");
		gen_pat_ser_grp=request.getParameter("gen_pat_ser_grp");
		dflt_grp=request.getParameter("dflt_grp");
		org_member_relationship_desc=checkForNull(request.getParameter("org_member_relationship_desc"));
		Site=request.getParameter("Site");	
		
		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
		alt_id2_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id2_accept_oth_pat_ser_yn"),"N");
		alt_id2_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id2_accept_alphanumeric_yn"),"N");

		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */

		con = ConnectionManager.getConnection(request);		
		String called_from = request.getParameter("called_from");		 
		if(called_from == null || called_from.equals("null")) called_from = "N";
			
		String flag = request.getParameter("emerg_reg");
		if(flag == null || flag.equals("null")) flag = "N";
		String operation = "";
		String func_act = request.getParameter("func_act");
		if(func_act == null || func_act.equals("")) operation = "Generate_File";
		else operation = "insert";
			
		String bl_install_yn = (String)session.getValue("mp_bl_oper_yn");
		
		String dflt_pat_regn_blng_class		= "";
       
		
			
		String a_national_id_no = request.getParameter("National_Id_No");
		if(a_national_id_no == null || a_national_id_no.equals("null")) a_national_id_no = "";
		String a_alt_id1_no = request.getParameter("a_alt_id1_no");
		if(a_alt_id1_no == null || a_alt_id1_no.equals("null")) a_alt_id1_no = "";

		String a_first_name  = request.getParameter("First_Name");
		if(a_first_name == null) a_first_name = "";
            
		String a_second_name = request.getParameter("Second_Name");
		if(a_second_name== null)a_second_name = "";
            
		String a_third_name  = request.getParameter("Third_Name");
		if(a_third_name == null)a_third_name = "";
		/*Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384*/
		String a_gender  = request.getParameter("Sex");
		if(a_gender == null)a_gender = "";
		if(a_gender.equals("A")){
			a_gender	= "";
		}
		//Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384
		String a_race_code  = request.getParameter("race_code");
		if(a_race_code == null)a_race_code = "";
		String a_date_of_birth	= ""; //Added by Ashwin K for AAKH-CRF-0150
		String a_family_name = request.getParameter("Family_Name");
		if(a_family_name == null || a_family_name.equals("null")) a_family_name = "";
		if(a_family_name.length() >= 1)
		{
			int ch = a_family_name.charAt(0);
			if((ch >= 65 && ch <= 90) || (ch >= 97) && ch <= 122)
			{
				a_family_name = (a_family_name.substring(0,1)).toUpperCase() + a_family_name.substring(1);
			}
			
		}
					
		if(bl_install_yn.equals("Y"))
		{
			pstmt = con.prepareStatement("SELECT a.emer_blng_grp_id,a.dflt_pat_regn_blng_class, b.settlement_ind FROM bl_mp_param a, bl_blng_grp b WHERE b.blng_grp_id = a.emer_blng_grp_id");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				emer_blng_grp_id			= rset.getString(1);
				dflt_pat_regn_blng_class = rset.getString(2) == null ? "" : rset.getString(2);
				setlmt_ind					= rset.getString(3);				
				if(setlmt_ind == null) setlmt_ind = "";
				if(emer_blng_grp_id == null) emer_blng_grp_id = "";
				if(!emer_blng_grp_id.equals("")) transaction_continue = "Y";
				else transaction_continue = "N";
			} else {
				transaction_continue = "N";
			}
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
		}
			/*
				This query is merged with the Above Query
				if(bl_install_yn.equals("Y"))
				{
					sql_bl	= "SELECT dflt_pat_regn_blng_class FROM bl_mp_param";
					stmt_bl	= con.prepareStatement(sql_bl);
					rs_bl	= stmt_bl.executeQuery();
					if(rs_bl != null)
					{
						while(rs_bl.next())
						{
							dflt_pat_regn_blng_class = rs_bl.getString(1) == null ? "" : rs_bl.getString(1);
						}
					}
					if(rs_bl != null) rs_bl.close();
					if(stmt_bl != null) stmt_bl.close();
				}
			*/	
		
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat ("dd/MM/yyyy");
        
        String gen_pat_id_yn = "N";	
		ResultSet rs				= null;
        String sysdate = formatter.format(dt);		
		

		// This array building is now handled in PatNamesComp.jsp
       /* ArrayList arrayList2 = new ArrayList();
		arrayList2 = eMP.ChangePatientDetails.getResultRows(con,"mp_name_prefix",p);
		int a = 0;
		out.println("<script>");
		for(int i=0;i<arrayList2.size();i+=3) 
		{
			out.print("NamePrefixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
			out.print("NamePrefixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
			out.print("PrefixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
			a++;
		} 
		out.println("</script>");
		arrayList2.clear();
		arrayList2 = eMP.ChangePatientDetails.getResultRows(con,"mp_name_suffix2",p);
		
		out.println("<script>");
		a = 0;
		for(int i=0;i<arrayList2.size();i+=3) 
		{
			out.print("NameSuffixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
			out.print("NameSuffixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
			out.print("SuffixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
			a++;
		} 
		out.println("</script>");*/
		try
		{	
				
			pstmt1 = con.prepareStatement("SELECT nvl(pat_ser_grp_code, '') pat_ser_grp_code, nvl(gen_pat_id_yn,'N') gen_pat_id_yn FROM mp_pat_ser_grp WHERE id_type NOT IN ('X', 'R') ");
			rs = pstmt1.executeQuery();
            if(rs != null)
            {
                int k = 0;
                out.println("<script>");
				while(rs.next())
                {
					if(dflt_grp.equals(rs.getString(1)))
					{
						gen_pat_id_yn = rs.getString(2);
					}					
					out.println("PSGCodeArray["+k+"]=\""+rs.getString(1)+"\";");
					out.println("PSGYNArray["+k+"]=\""+rs.getString(2)+"\";");
					k++;
				}
				out.println("</script>");
            }
	 if(rs != null) rs.close();
          if(pstmt1 != null) pstmt1.close();
		//Added by Ashwin K for AAKH-CRF-0150	
		//for smart card
		pstmt1 = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");
		rs = pstmt1.executeQuery();	
		if(rs!=null && rs.next())
			{
			function_name=rs.getString("VALUE_2");   // alkhaleej smart card
			}	
			 if(rs != null) rs.close();
          	  if(pstmt1 != null) pstmt1.close();

		pstmt1 = con.prepareStatement("select PAT_SER_GRP_CODE from MP_PAT_SER_GRP where DEFAULT_YN = 'Y'");
		rs = pstmt1.executeQuery();	
		if(rs!=null && rs.next())
			{
			pat_series=rs.getString(1);   // alkhaleej smart card
			}	


			 if(rs != null) rs.close();
          	  if(pstmt1 != null) pstmt1.close();
		//Ended by Ashwin K for AAKH-CRF-0150           
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(flag.equals("Y")){
            _bw.write(_wl_block16Bytes, _wl_block16);
}else if(called_from.equals("AE") || called_from.equals("MO_BID_REGN") || called_from.equals("MO_EBP_REGN")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(accept_national_id_no_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alt_id1_accept_oth_pat_ser_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alt_id1_alphanum_validate_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alt_id2_alphanum_validate_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(alt_id3_alphanum_validate_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_id4_alphanum_validate_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(max_pat_age));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(family_org_id_accept_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(pat_category_reqd_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(org_member_relationship_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(org_member_relationship_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(alt_id2_accept_oth_pat_ser_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_id2_accept_alphanumeric_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
				
				dfltPSG =gen_pat_ser_grp;
				if(dfltPSG == null) dfltPSG = "";
				
            _bw.write(_wl_block35Bytes, _wl_block35);
 if(function_name.equals("01"))
			{
				try
				{
					if(session.getAttribute("smart_data") != null)
					{
						String smartdata = (String)session.getAttribute("smart_data");
						String smartdata_arr[] = smartdata.split("!~");
						a_national_id_no = smartdata_arr[0];
						//a_oth_contact_no = smartdata_arr[1];
						a_first_name = smartdata_arr[2];
						a_second_name =  smartdata_arr[3];
						a_third_name = smartdata_arr[4];
						//a_name_prefix = smartdata_arr[5];
						a_family_name = smartdata_arr[6];
						a_gender = smartdata_arr[7];
						a_date_of_birth = smartdata_arr[8];
						//alt_addr_line1 = smartdata_arr[9];
						alt_id1_unique_yn =  smartdata_arr[10]; //passport numer
						//a_first_name =  smartdata_arr[11]; //passport exp date
						//dflt_nationality = smartdata_arr[12];
						//a_res_country_desc = smartdata_arr[13];
						//a_first_name = smartdata_arr[14]; //emirates
						dfltPSG = pat_series;

						//to get the nationality code --start

						System.err.println("query ---> select country_code as VALUE_2 from mp_country where long_name = '"+smartdata_arr[12]+"'");
						pstmt1 = con.prepareStatement("select country_code as VALUE_2 from mp_country where long_name = '"+smartdata_arr[12]+"'");
						rs = pstmt1.executeQuery();	
						if(rs!=null && rs.next())
						{
							dflt_nationality=rs.getString("VALUE_2");   // alkhaleej smart card
						}		
						if(rs!=null) rs.close();
						if(pstmt1!=null) pstmt1.close();
						//to get the nationality code --end

					


						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
			
			}  
            _bw.write(_wl_block36Bytes, _wl_block36);
            {java.lang.String __page ="../../eMP/jsp/ChangePatientSubNames.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("group"), weblogic.utils.StringUtils.valueOf("G")},{ weblogic.utils.StringUtils.valueOf("CalledFromFunction"), weblogic.utils.StringUtils.valueOf("EmergencyReg")},{ weblogic.utils.StringUtils.valueOf("a_family_name"), weblogic.utils.StringUtils.valueOf(a_family_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_gender"), weblogic.utils.StringUtils.valueOf(a_gender
                        )},{ weblogic.utils.StringUtils.valueOf("a_race_code"), weblogic.utils.StringUtils.valueOf(a_race_code
                        )},{ weblogic.utils.StringUtils.valueOf("a_first_name"), weblogic.utils.StringUtils.valueOf(a_first_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_second_name"), weblogic.utils.StringUtils.valueOf(a_second_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_third_name"), weblogic.utils.StringUtils.valueOf(a_third_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_national_id_no"), weblogic.utils.StringUtils.valueOf(a_national_id_no
                        )},{ weblogic.utils.StringUtils.valueOf("flag"), weblogic.utils.StringUtils.valueOf(flag
                        )},{ weblogic.utils.StringUtils.valueOf("dfltPSG"), weblogic.utils.StringUtils.valueOf(dfltPSG
                        )},{ weblogic.utils.StringUtils.valueOf("Site"), weblogic.utils.StringUtils.valueOf(Site
                        )},{ weblogic.utils.StringUtils.valueOf("emeg_pat_ser_grp"), weblogic.utils.StringUtils.valueOf(emeg_pat_ser_grp
                        )},{ weblogic.utils.StringUtils.valueOf("a_nationality_code"), weblogic.utils.StringUtils.valueOf(dflt_nationality
                        )},{ weblogic.utils.StringUtils.valueOf("default_race_code"), weblogic.utils.StringUtils.valueOf(default_race_code
                        )},{ weblogic.utils.StringUtils.valueOf("nat_id_accept_alphanumeric_yn"), weblogic.utils.StringUtils.valueOf(nat_id_accept_alphanumeric_yn
                        )},{ weblogic.utils.StringUtils.valueOf("ApplicableFor"), weblogic.utils.StringUtils.valueOf(called_from
                        )},{ weblogic.utils.StringUtils.valueOf("a_date_of_birth"), weblogic.utils.StringUtils.valueOf(a_date_of_birth
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(create_file_at_pat_regn_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(name_dervn_logic));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(name_drvn_logic_long));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(name_dervn_logic_oth_lang));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(name_drvn_logic_oth_lang_long));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dflt_grp));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(gen_pat_id_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(a_national_id_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(dflt_nationality));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(dflt_pat_regn_blng_class));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(alt_id1_unique_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(alt_id2_unique_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(transaction_continue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(emer_blng_grp_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(setlmt_ind));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(default_race_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(gen_slno_unknown_pat_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(dflt_grp));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(alt_id1_desc == null ? "&nbsp;" :alt_id1_desc ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(alt_id2_desc == null ? "&nbsp;" : alt_id2_desc ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(alt_id3_desc == null ? "&nbsp;" : alt_id3_desc ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(alt_id4_desc == null ? "&nbsp;" : alt_id4_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);

				if(rs != null) rs.close();
				if(rset != null) rset.close();					
				if(pstmt != null) pstmt.close();				
			}catch(Exception e) {
				e.printStackTrace();		
			} finally {
				ConnectionManager.returnConnection(con,request);
			}
			
			if(flag.equals("Y") || called_from.equals("AE")) {
				
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(dfltPSG));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(emeg_pat_ser_grp));
            _bw.write(_wl_block73Bytes, _wl_block73);

			}

			if(ext_system_interface_yn.equals("Y") && nat_data_source_id.equals("NRIC"))	{ 

				
				
            _bw.write(_wl_block74Bytes, _wl_block74);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.detailsunknown.label", java.lang.String .class,"key"));
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
}
