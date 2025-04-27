package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import eXH.InterfaceUtil;
import eXH.XHUtil;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __changepatientsubnames extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ChangePatientSubNames.jsp", 1742387226770L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<!--  \n\tLast Modified Date Time : 10/27/2005 3:00 PM\n\tChangePatientSubNames.jsp is an common component used for functions like Patient Registration, Change Patient Details, Rapid Registration & Emergency Registration. This JSP includes Patient Series, Preferred Fecility, National ID, Other Alternate ID Type and Number and all Alternate ID Type\'s and Numbers and Naming Fields such as Head of Family Patient ID, Relationship to Head, Name Prefix, Family Name, Name Suffix etc., Gender, Age, Date of Birth,  This file is Dynamically included in the files NewPatientRegistration.jsp, ChangePatientSub.jsp, InsertEmergnRegn.jsp & InsertRapidRegn.jsp. \n\t-- by Meghanath.  \n-->\t  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<html>\n<head>\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/DateUtils.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/calScript/hj/calendar.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eXH/js/ExternalApplication.js\" language=\"JavaScript\"></Script> <!-- added by mujafar for KDAH-CRF-370.1  -->\n<!-- Added by Sethu for KDAH-CRF-0362 -->\n<Script src=\"../../eXH/js/jquery-1.7.min.js\" language=\"JavaScript\"></Script> \n<script Language=\"javascript\" src=\"../../eMP/js/json02.js\"> </script>\n<script Language=\"javascript\" src=\"../../eMP/js/PasInterface.js\"> </script>\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link></head>\n<script>\t\nvar pat_name_in_loc_lang = new Array ();  \nfunction isNumber(evt) {\n    evt = (evt) ? evt : window.event;\n    var element  = document.getElementById(\"inputText\");\n    var initialValue  = element.value;\n    if(evt.type == \"paste\"){\n    \t  setTimeout(function() {\n        \tvar value  = element.value;\n      \tvar pastedText = value.replace(initialValue,\"\");\n          if(!isNaN(pastedText)){\n          \telement.value = value;\n          }else{\n          \telement.value = initialValue;\n          }\n        }, 2);         \n    }\n    var charCode = (evt.which) ? evt.which : evt.keyCode;\n    if (charCode > 31 && (charCode < 48 || charCode > 57)) {\n      return false;\n    }\n    return true;\n  }\n  function checkGCC()\n\t{\n\tif(document.getElementById(\"gccchk\").checked)\n\t\tdocument.getElementById(\"gccId\").value=\'Y\'\n\tif(!document.getElementById(\"gccchk\").checked)\n\t\tdocument.getElementById(\"gccId\").value=\'N\'\n\t}\nfunction clearABHA()\n\t{\n\tdocument.getElementById(\"abha_pat_id\").value=\"\";\t\n\tdocument.getElementById(\"abha_pat_id_1\").value=\"\";\t\n\tdocument.getElementById(\"unlinkId\").style.visibility=\"hidden\";\n\tdocument.getElementById(\"updatehealthid_visible\").style.display=\"none\";\n\tdocument.getElementById(\"linkhealthid_visible\").style.display=\"inline\";\n\t}\t\n</script>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<!-- Added for GDOH -CRF-0029 by Dharma on 11th sep 2014 Start -->\n\t<input type=\"hidden\" name=\"visit_adm_date_time\" id=\"visit_adm_date_time\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" />\n\t<!-- Added for GDOH -CRF-0029 by Dharma on 11th sep 2014 End -->\n\t<!--Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] Start-->\n\t<input type=\"hidden\" name=\"isNatIdMandatory\" id=\"isNatIdMandatory\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" />\n\t<input type=\"hidden\" name=\"isClearNatIdValues\" id=\"isClearNatIdValues\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" />\n\t<!--Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] End-->\n\t<input type=\"hidden\" name=\"isNatIdOrAltId1MandRes\" id=\"isNatIdOrAltId1MandRes\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" /><!-- Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] -->\n\t<input type=\"hidden\" name=\"isNatIdOrAltIdMandVisaType\" id=\"isNatIdOrAltIdMandVisaType\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" /><!-- Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750] -->\n\t<input type=\"hidden\" name=\"isNatIdAltIdMandVisaType\" id=\"isNatIdAltIdMandVisaType\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/> <!--//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022-->\n\t<input type=\"hidden\" name=\"dftNationalId\" id=\"dftNationalId\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/> <!--////Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022-->\n\t<input type=\"hidden\" name=\"biometric_authentication_yn\" id=\"biometric_authentication_yn\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/> <!--////Maheshwaran K added for AAKH-CRF-0175 as on 13-09-2023-->\n\t<input type=\"hidden\" name=\"isNuhdeekIDAppl\" id=\"isNuhdeekIDAppl\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" /><!--Added by SureshM on 16th Jan 2020 NMC-JD-CRF-0038 [IN:071904] -->\n\t<input type=\"hidden\" name=\"age_not_consider_natid_altid\" id=\"age_not_consider_natid_altid\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" /><!-- Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750] -->\n\t<input type=\"hidden\" name=\"isValidateNatIDWithDOB\" id=\"isValidateNatIDWithDOB\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" /><!--Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] -->\n\t<input type=\"hidden\" name=\"chkGenderWithNatID\" id=\"chkGenderWithNatID\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" /> <!--Added by Thamizh selvi on 24th Mar 2017 for GDOH-CRF-0145-->\n\t<input type=\"hidden\" name=\"chkPanValidate\" id=\"chkPanValidate\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" />     <!-- added by mujafar for KDAH-CRF-370.1 -->\n\t<input type=\"hidden\" name=\"chkForm60Allow\" id=\"chkForm60Allow\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" />   <!-- added by mujafar for KDAH-CRF-347 -->\n\t<input type=\"hidden\" name=\"form60_value_chk\" id=\"form60_value_chk\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" />  <!-- added by mujafar for KDAH-CRF-370.1 & KDAH-CRF-347 -->\n\t<input type=\'hidden\' name=\'isAutoPopulateNOKDOBAppl\' id=\'isAutoPopulateNOKDOBAppl\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></input><!--Added by Thamizh selvi on 1st Aug 2018 against ML-MMOH-CRF-1177-->\n\t<!--Below line added for this CRF ML-MMOH-CRF-0778-->\n\t<input type=\"hidden\" name=\"checkNatIdWithGender\" id=\"checkNatIdWithGender\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/> \n\t<!--End this CRF ML-MMOH-CRF-0778-->\n\t\n\t<input type=\'hidden\' name=\'pat_cat_sql\' id=\'pat_cat_sql\' value=\"\">\n\t<!--for smart card-->\n\t<input type=\"hidden\" name=\"txtSmartcard_path\" id=\"txtSmartcard_path\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\"hidden\" name=\"txtSmartcard_dup\" id=\"txtSmartcard_dup\" value=\"\">\n\t<input type=\"hidden\" name=\"txtSmartcard_succ\" id=\"txtSmartcard_succ\" value=\"\">\n\t<!--for smart card-->\n\t<!--for Alkhaleej smart card-->\n\t<input type=\"hidden\" name=\"txtSmart_fn_name\" id=\"txtSmart_fn_name\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\'hidden\' name=\'nat_id_accept_alphanumeric_yn\' id=\'nat_id_accept_alphanumeric_yn\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\'hidden\' name=\'display_new_born_age_in_hrs\' id=\'display_new_born_age_in_hrs\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<table border=\'0\' cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" id=\' \'>\n\t<input type=\'hidden\' name=\'CalledFromFunction\' id=\'CalledFromFunction\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\t\n\t<input type=\'hidden\' name=\'name_pfx_reqd_for_org_mem_yn\' id=\'name_pfx_reqd_for_org_mem_yn\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\'hidden\' name=\'dflt_patient_name\' id=\'dflt_patient_name\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\t\n\t<input type=\'hidden\' name=\'birthPlace\' id=\'birthPlace\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"></input>\n\t<input type=\'hidden\' name=\'nationality\' id=\'nationality\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"></input>\n\t<input type=\'hidden\' name=\'associated_relationship_code\' id=\'associated_relationship_code\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'relation_level1_code\' id=\'relation_level1_code\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"></input>\n\t<input type=\'hidden\' name=\'relationship_level1_description\' id=\'relationship_level1_description\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"></input>\n\t\n\t<!--Below line added for this CRF GHL-CRF-0332 [IN:042060]-->\n\t<input type=\'hidden\' name=\'alt_id1_man_non_ctz\' id=\'alt_id1_man_non_ctz\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\t\n\t<!--CRF GHL-CRF-0332 [IN:042060] -->\n\t\n\t<!--Below line Added for this CRF GDOH-CRF-0029 [IN:048764] -->\t\n\t<input type=\'hidden\' name=\'localeName\' id=\'localeName\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\'hidden\' name=\'old_regn_datetime\' id=\'old_regn_datetime\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<!--End  GDOH-CRF-0029 [IN:048764] -->\t\n\t\n\t<!--Below line added for this SCF BSP-SCF-0043-->\n\t<input type=\'hidden\' name=\'id_change_allowed_for_series\' id=\'id_change_allowed_for_series\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\'hidden\' name=\'id_type_series\' id=\'id_type_series\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\'hidden\' name=\'national_id_number\' id=\'national_id_number\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"> \n\t<!--End this CRF BSP-SCF-0043-->\n\n\t<input type=\"hidden\" name=\"chkAadhaarValidate\" id=\"chkAadhaarValidate\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" />     <!-- Added by Sethu for KDAH-CRF-0362 -->\n\n\t<!--Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1-->\n\t<input type=\'hidden\' name=\'uploaded_pat_yn\' id=\'uploaded_pat_yn\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\'hidden\' name=\'nat_id_chk\' id=\'nat_id_chk\' value=\"\">\n\t<input type=\'hidden\' name=\'pat_category_reqd_yn\' id=\'pat_category_reqd_yn\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">  <!-- Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522 -->\n\t<!--//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023-->\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\'hidden\' name=\'emp_service_no\' id=\'emp_service_no\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\'hidden\' name=\'ndhm_appl_YN\' id=\'ndhm_appl_YN\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\n\t\t\n\t<!--END MO-CRF-20183.2-->\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<input type=\'hidden\' name=\'other_era_diff\' id=\'other_era_diff\' value=\"543\"></input>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<input type=\'hidden\' name=\'other_era_diff\' id=\'other_era_diff\' value=\"0\"></input>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t<input type=\'hidden\' name=\'Select1\' id=\'Select1\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"></input>\n\t\t<tr width=\"100%\">\n\t\t\t<td width=\'20%\'></td>\n\t\t\t<td width=\'25%\'></td>\n\t\t\t<td width=\'15%\'></td>\n\t\t\t<td width=\'40%\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t<td  class=\'fields\'  ><Select name=\'pat_ser_grp_code\' id=\'pat_ser_grp_code\'  ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="<option value=\'\'>----";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="----</option>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t<Option value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"  ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</Option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t<Option value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" selected>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</Option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</Option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</option>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</Select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t\t<td class=\'fields\'><TABLE border=\'0\'>\n\t\t\t\t\t<TR>\n\n\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'pref_facility_desc\' id=\'pref_facility_desc\' size=\'30\' maxlength=\'35\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" onblur=\'if(this.value!=\"\"){searchFacility(pref_facility_id,pref_facility_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'pref_facility_code\'  name=\'pref_facility_id_id\' id=\'pref_facility_id_id\' value=\'?\' class=\'button\' onclick=\'searchFacility(this,pref_facility_desc)\' >\n\t\t\t\t<input type=\'hidden\' name=\'pref_facility_id\' id=\'pref_facility_id\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\n\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t <TD style=\'background-color:red\'><BLINK><font color=\'yellow\'><b>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</b></font></BLINK></TD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'patient_deceased_yn\' id=\'patient_deceased_yn\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'patient_deceased_date\' id=\'patient_deceased_date\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</TR>\n\t\t\t\t\t</TABLE> </TD>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\t<td class=\'label\' colspan=\'2\'> </td>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t </tr>\n\t\t\t\t<tr>\n\t\t\t\t<input type=\'hidden\' name=\'pat_name_in_loc_lang_reqd_yn\' id=\'pat_name_in_loc_lang_reqd_yn\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'ext_system_interface_yn\' id=\'ext_system_interface_yn\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\n\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t<td class=\'label\' id =\'natidprompt\' >";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t\t\t\t<td class=\'fields\'   >\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n         \t\t\t\t\t<!--Start BSP-SCF-0043-->\n\t\t\t\t\t\t <input type=\'hidden\' name=\'user_accescount\' id=\'user_accescount\' value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">  \n\t                        <!--End this CRF BSP-SCF-0043-->\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t<input type=\'button\' id=\'interface_button\' value=\'I\' name=\'ext_button\' id=\'ext_button\' class=\'button\' onClick=\"dla_interface(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\')\"  ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =">\n\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t<input type=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' id=\'interface_button\' value=\'M\' name=\'ext_button\' class=\'button\' onClick=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="> \n\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t<!--\t<applet code=\"CardReaderApplet.class\" name=\"CardReader\"\n\t\t\t\t\tcodebase=\"../../eMP/CardReader/\" archive=\"CardReaderApplet.jar\" width=\"5\"\n\t\t\t\t\theight=\"5\">\n\t\t\t\t\t<PARAM name=\"button_width\" value=\"0\" />\n\t\t\t\t\t<PARAM name=\"button_height\" value=\"0\" />\n\t\t\t\t\t<PARAM name=\"button_label\" value=\"0\" />\t\t\t\t\t\t\n\t\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\t\tSorry, Your browser does not support Java applet!\n\t\t\t\t\t</applet> -->\n\n\t\t\t\t\t<!-- Commented above old card reader applet and added for AAKH-CRF-0158 -->\n\t\t\t\t\t<APPLET style=\"border:solid 1px gray\" id=\"PublicDataWebComponent\" name=\"PublicDataWebComponent\" codebase=\"../../eMP/CardReader/\" CODE=\"emiratesid.jio.webcomponents.PublicDataReader\"\n                                                        ARCHIVE=\"PublicDataApplet-Sagem.jar\" WIDTH=\"0\" HEIGHT=\"0\">\n                                                        <param name=\"EncryptParameters\" value=\"false\" />\n                                                        <param name=\"RelativeCertPath\" value=\"certs\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<PARAM name=\"button_label\" value=\"0\" />\t\n                                                         This browser does not support Applets.\n                                             </APPLET> \n\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t<input type=\'button\' id=\'aadhar_num_int_button\' value=\'eKYC\' name=\'aadhar_num_int_button\' id=\'aadhar_num_int_button\' class=\'button\' onClick=\"eKYCmp();\" ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =">\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t<input type=\'button\' id=\'emp_privilege_button\' value=\'H\' name=\'emp_privilege_button\' id=\'emp_privilege_button\' class=\'button\' onclick=\'populateEmpData();\' style = \'display:none\'>\n\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" name=\'nat_gif\' id=\'nat_gif\'></img>\n\t\t\t\t<input type=\'hidden\' name=\'aadhaarStatus\' id=\'aadhaarStatus\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'aadhaarID\' id=\'aadhaarID\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'aadhaarTransId\' id=\'aadhaarTransId\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'aadharPatPhotoStr\' id=\'aadharPatPhotoStr\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'chkEKYCValidate\' id=\'chkEKYCValidate\' value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"> <!--ADDED BY PRITHIVI AADHAR CARD BUTTON SITE SPECIFIC KDAH-CRF-0362 14/04/2017-->\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" <input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\'\'> ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="<td class=\'label\' colspan=\'2\' ></td>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t<input type=\'hidden\' name=\'national_id_no_dup\' id=\'national_id_no_dup\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"> \n\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t<input type=\"hidden\" name=\'Site\' id=\'Site\' value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t<input type=\'hidden\' name=\'nat_id_pat_ser_grp\' id=\'nat_id_pat_ser_grp\' value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t<input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t<input type=\'hidden\' name=\'invoke_routine\' id=\'invoke_routine\' value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\t<input type=\'hidden\' name=\'nat_data_source_id\' id=\'nat_data_source_id\' value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t\t<input type=\'hidden\' name=\'nat_id_reqd_all_series\' id=\'nat_id_reqd_all_series\' value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\t<input type=\'hidden\' name=\'nat_id_check_digit_id\' id=\'nat_id_check_digit_id\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t<input type=\'hidden\' name=\'nat_id_chk_len\' id=\'nat_id_chk_len\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\t\t\t<td class=\'fields\'  >\t\t\t\n\t\t\t\t<select onchange=\'enableAltID();\' name=\'other_alt_id\' id=\'other_alt_id\' >\n\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="----</Option>\n\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t<Option value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</Option>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</select>\n\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="<td class=\'label\'  colspan=\'3\'></td> ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t</tr>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t<tr>\n\t\t\t\t<td class=\'label\'   >";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t<script>\n\t\t\t\t\t\tvar natidExpDate_date=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'; \n\t\t\t\t\t\tvar natidExpDate_arr = natidExpDate_date.split(\' \'); \n\t\t\t\t\t\tvar natidExpDate = natidExpDate_arr[0]; \n\t\t\t\t\t\tnatidExpDate_time = natidExpDate_arr[1]; \n\t\t\t\t\t\tnatidExpDate_time = natidExpDate_time.split(\':\'); \t\n\t\t\t\t\t\tnatidExpDate_hm = natidExpDate_time[0]+\":\"+natidExpDate_time[1];\n\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tnatidExpDate = convertDate(natidExpDate,\'DMY\',\'en\',\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\');\t\n\t\t\t\t\t\t</script>\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t<script>\n\t\t\t\tdocument.forms[0].nat_id_exp_date.value=natidExpDate;\n\t\t\t\t\t</script>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =" name=\'nat_gif\'></img>\n\t\t\t\t</td></tr>\n\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t<!-- Alternate IDs-->\t  \n\t\n\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'  >\t\t\t\n\t\t\t\t\t\t\t<select onchange=\'form60OnChange();\' name=\'formno60\' id=\'formno60\' ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =">\n\t\t\t\t\t\t\t\t<option value=\'Y\' ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" selected";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</Option>\n\t\t\t\t\t\t\t\t<option value=\'N\' ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</Option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\'2\'></td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t<input type=\'hidden\' name=\'isForm60Available\' id=\'isForm60Available\'  value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" />\n\t\t\t\t<input type=\'hidden\' name=\'isForm60Validation\' id=\'isForm60Validation\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" />\n\t\t\t\t<input type=\'hidden\' name=\'isDisabledForm60\' id=\'isDisabledForm60\'value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" />\n\t\t\t\t<!--Added by Dharma on 22nd Jan 2016 for KDAH-CRF-0331 [IN058799] End-->\n\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="<input type=\'hidden\' name=\'alt_id1_db\' id=\'alt_id1_db\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="<tr>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\t\t\t\t\t\t\n\t\t\t<td class=\'label\'    name=\'alt_id1_desc\' id=\'alt_id1_prompt\'><input type=\'hidden\' name=\'alt_id1_accept_alphanumeric\' id=\'alt_id1_accept_alphanumeric\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t</td><input type=\'hidden\' name=\'alt_id1_desc\' id=\'alt_id1_desc\' value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="<input type=\'hidden\' name=\'alt_id1_reqd_yn\' id=\'alt_id1_reqd_yn\' value=\'Y\'><img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\' ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="></img></td> \n\t\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'alt_id1_reqd_yn\' id=\'alt_id1_reqd_yn\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'><img src=\'../../eCommon/images/mandatory.gif\' \n\t\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="  style=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'></img></td>\n\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="<td class=\'label\'   >";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</td>\n\t\t\t\t<input type=\'hidden\' name=\'alt_date1_reqd_yn\' id=\'alt_date1_reqd_yn\' value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'>\n\t\t\t\t<!--Above line added for this CRF  GHL-CRF-0332 [IN:042060]-->\n\t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 =" \n\t\t\t   <input type=\'hidden\' name=\'alt_date1_reqd_yn\' id=\'alt_date1_reqd_yn\' value=\'N\'>\n\t\t\t\t<td class=\'label\' ></td>\n\t\t\t\t ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\t\t\t\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'alt_id1_type\' id=\'alt_id1_type\' value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_no_dup\' id=\'alt_id1_no_dup\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =" <td colspan=\'4\'></td></tr> ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t <td class=\'label\'   id=\'alt_id2_prompt\'>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="<input type=\'hidden\' name=\'alt_id2_reqd_yn\' id=\'alt_id2_reqd_yn\' value=\'Y\'><img src=\'../../eCommon/images/mandatory.gif\' id=\'alt2_gif\' style=\'visibility:visible\'></img>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\t\t\n\t\t\t\t<span id=\"gcc\" style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t<input type=\"checkbox\"  name=\"gccchk\" id=\"gccchk\"   ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="checked";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="  onclick=\'checkGCC()\'/>\t</span>\t\t\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t</td>";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =" <input type=\'hidden\' name=\'alt_id2_reqd_yn\' id=\'alt_id2_reqd_yn\' value=\'N\' /><img src=\'../../eCommon/images/mandatory.gif\' id=\'alt2_gif\' style=\'visibility:hidden\'>\n\t\t\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="  onclick=\'checkGCC()\' />\t</span>\t\t\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\t\t\t\n\t\t\t</td>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="<input name=\"gcc\" id=\"gccId\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\"/>\n\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 =" <td colspan=\'2\'>&nbsp;</td> ";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t<input type=\'hidden\' name=\'alt_id2_type\' id=\'alt_id2_type\' value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t<input type=\'hidden\' name=\'alt_id2_no_dup\' id=\'alt_id2_no_dup\' value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 =" <td colspan=\'4\'></td> ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 =" <tr> ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 =" \n\t\t\t\t<td class=\'label\'    id=\'alt_id3_prompt\'>";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t\t<input type=\'hidden\' name=\'alt_id3_reqd_yn\' id=\'alt_id3_reqd_yn\' value=\'Y\'><img src=\'../../eCommon/images/mandatory.gif\'  id=\'alt3_gif\' style=\'visibility:visible\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 =" <input type=\'hidden\' name=\'alt_id3_reqd_yn\' id=\'alt_id3_reqd_yn\' value=\'N\'><img src=\'../../eCommon/images/mandatory.gif\'  id=\'alt3_gif\' style=\'visibility:hidden\'></img> \n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 =" \n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t<input type=\'button\' id=\'val_button\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' style =\"display:\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'\"  name=\'pan_val_button\' class=\'button\' onClick=\"callfunc(\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\',\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\')\"   >\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'pan_holder_name\' id=\'pan_holder_name\' value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" />\n\t\t\t<input type=\'hidden\' name=\'pan_status\' id=\'pan_status\' value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" />\n\t\t\t<input type=\'hidden\' name=\'pan_trans_id\' id=\'pan_trans_id\' value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" />\n\t\t\t<input type=\'hidden\' name=\'pancard_no\' id=\'pancard_no\' value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" />\n\t\t\t";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t\t\t\t\t\t<select onchange=\'primaryOnChange(this);\' name=\'primaryMember\' id=\'primaryMember\' id=\'primaryMember\' ";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =">\n\t\t\t\t\t\t\t\t<option value=\'\' >--";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="--</option>\n\t\t\t\t\t\t\t\t<option value=\'Y\' ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="</Option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'  id=\'primary_gif\'></img>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- <input type=\'hidden\' name=\'alt_id3_reqd_yn\' id=\'alt_id3_reqd_yn\' value=\'Y\'><img src=\'../../eCommon/images/mandatory.gif\'  id=\'alt3_gif\' style=\'visibility:visible\'></img> -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t\t\t\t\t\n\n\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t\t</td><td class=\'label\'   >";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="</td>\n\t\t\t\t<td class=\'fields\'     >\n\t\t\t\t";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\t\t\t<input type=\'hidden\' name=\'alt_id3_type\' id=\'alt_id3_type\' value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n\t\t\t<input type=\'hidden\' name=\'alt_id3_no_dup\' id=\'alt_id3_no_dup\' value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t<input type=\'hidden\' name=\'alt_id3_no_dup\' id=\'alt_id3_no_dup\' value=\"\">\n\t\t\t";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t</td>";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t</tr><tr>\n\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'fields\'></td>\n\t\t\t\t\t\t<!-- <input type=\'hidden\' name=\'alt_id3_reqd_yn\' id=\'alt_id3_reqd_yn\' value=\'Y\'><img src=\'../../eCommon/images/mandatory.gif\'  id=\'alt3_gif\' style=\'visibility:visible\'></img> -->\n\t\t\t\t\t\t<td class=\'fields\' colspan=\'2\'>\t\t\t\t\t\t <input type=\'button\'  class=\'Button\' id=\'getOtp\' ";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 =" value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\' onclick=\"getOTP(\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\',\'GENERATE_OTP\',\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\')\"> \n\n\t\t\t\t\t\t \n\t\t\t\t\t\t <font size=\"1\" color=\"red\" ><B><span id=\"otpError\" style=\"visibility:\'hidden\'\"></B></span></font>\n\t\t\t\t\t\t<font size=\"1\" color=\"green\" ><B><span id=\"otpSuccess\" style=\"visibility:\'hidden\'\"></B></span></font> \n\t\t\t\t\t\t<span id=\"OTP\" style=\"visibility:\'hidden\'\">";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"text\"  name=\"OTP\" id=\"OTP\" maxlength=\"15\" size=\"15\"  value=\'\' onblur=\"validateOTP(\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\',\'VALIDATE_OTP\',\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\')\"  ></span>\n\n\t\t\t\t\t\t\t<font size=\"1\" color=\"green\" ><B><span id=\"otpValidationSuccess\" style=\"visibility:\'hidden\'\"></B></span></font>\n\t\t\t\t\t\t <font size=\"1\" color=\"red\" ><B><span id=\"otpValidationError\" style=\"visibility:\'hidden\'\"></B></span></font> </td>\n\n\t\t\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"nuhdeekReady\" id=\"nuhdeekReady\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\" /><!--Added by SureshM on 16th Jan 2020 NMC-JD-CRF-0038 [IN:071904] -->\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\t\t<tr>\n\t\t\n\t\t<td class=\'label\'>\n\t\t\t\n\t\t</td>\n\t\t<td class=\'fields\' >\n\t\t<font size=\"1\" color=\"green\" ><B><span id=\"pancard_display\" >";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="</B></span></font>\n\t\t</td>\n\t\t\n\t\t<td class=\'label\' id=\"pancard_pancardrelation\">";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="</td>\n\t\t\t\t\n\t\t\t\t<td class=\'fields\'  colspan=\'1\' id=\"pancard_relationship\" >\n\t\t\t\t<select name=\'pan_rel_mem\' id=\'pan_rel_mem\'  >\n\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="----</Option> \n\t\t\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="</option>\n\t\t\t\t\t<option value=\'F\' ";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 =" >";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="</option>\n\t\t\t\t\t<option value=\'M\' ";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</option>\n\t\t\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="</option>\n\t\t\t\t</select><img id=\'pancard_relationship_man\' src=\'../../eCommon/images/mandatory.gif\'></img> \n\t\t\t\t</td>\n\t\t<!-- pancard_relationship_man mandatory field added by mujafar for ICN-64500 -->\n\t\t \n\t\t\n\t\t</tr>\t\t\n\t\t";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t\t\n\t\t\t<tr>\n\t\t\n\t\t<td class=\'label\'>\n\t\t\t\n\t\t</td>\n\t\t<td class=\'fields\' >\n\t\t<font size=\"1\" color=\"green\" ><B><span id=\"pancard_display\" style=\"visibility:\'hidden\'\"></B></span></font>\n\t\t</td>\n\t\t\n\t\t<td class=\'label\' id=\"pancard_pancardrelation\" style=\"visibility:hidden;\">";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="</td>\n\t\t\t\t\n\t\t\t\t<td class=\'fields\'  colspan=\'1\' id=\"pancard_relationship\" style=\"visibility:hidden;\" >\n\t\t\t\t<select name=\'pan_rel_mem\' id=\'pan_rel_mem\'  >\n\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="----</Option> \n\t\t\t\t\t<option value=\'S\'  >";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="</option>\n\t\t\t\t\t<option value=\'F\'   >";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="</option>\n\t\t\t\t\t<option value=\'M\'  >";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="</option>\n\t\t\t\t\t<option value=\'G\' >";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="</option>\n\t\t\t\t</select><img id=\'pancard_relationship_man\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t<!-- pancard_relationship_man mandatory field added by mujafar for ICN-64500 -->\n\t\t \n\t\t\n\t\t</tr>\n\t\t\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 =" \n\t\t   <tr>\n\t\t\t<td class=\'label\'     id=\'alt_id4_prompt\'>";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'alt_id4_reqd_yn\' id=\'alt_id4_reqd_yn\' value=\'Y\'><img src=\'../../eCommon/images/mandatory.gif\' id=\'alt4_gif\' style=\'visibility:visible\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="<input type=\'hidden\' name=\'alt_id4_reqd_yn\' id=\'alt_id4_reqd_yn\' value=\'N\'><img src=\'../../eCommon/images/mandatory.gif\' id=\'alt4_gif\' style=\'visibility:hidden\'></img>";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 =" <!--GHL-CRF-0657 Link Health ID  --> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\t\t\t\t\t<a href=\"javascript:onClick=updateABHADetails(\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\');\" style=\'";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\' id=\'updatehealthid_visible\'  > <b>";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="</b></a>\n\t\t\t\t\t\t\t  <a href=\"javascript:onClick=openLinkHealthIdDialog(\'";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\' id=\'linkhealthid_visible\' > <b>";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="</b></a>\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t<span style=\"font-size: 8px \" style=\'visibility:hidden\'  id=\'aadhaar_visible\'>";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="</span>";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\n\t\t\t\t\t\t\t\t\t<td class =\'label\'   id=\'abha_label_visible\'>";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="</td> \n\t\t\t\t\t\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t\t\t\t\t<input id=\'abha_field_visible_1\'  type=\'text\'  readonly maxlength=\'";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\' size=\'";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\' name=\'abha_pat_id_1\'  value=\"XX-XXX-XXX-";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\" > \n\t\t\t\t\t\t\t\t\t<input id=\'abha_field_visible\'  type=\'hidden\'  readonly maxlength=\'";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\' name=\'abha_pat_id\'  value=\'";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\' > ";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\t<a href=\"javascript:onClick=clearABHA();\" id=\"unlinkId\">";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="</a>";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n\t\t\t\t\t\t\t\t\t<td class =\'label\' style=\'visibility:hidden\'  id=\'abha_label_visible\'>";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="</td> \n\t\t\t\t\t\t\t\t\t<td class=\"fields\"><input style=\'visibility:hidden\' readonly  id=\'abha_field_visible_1\' type=\'text\' maxlength=\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\' name=\'abha_pat_id_1\'  value=\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\' > \n\t\t\t\t\t\t\t\t\t<td class=\"fields\"><input style=\'visibility:hidden\' readonly  id=\'abha_field_visible\' type=\'hidden\' maxlength=\'";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\' > \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\n\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 =" \n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n\t\t\t\t\t</td><td class=\'label\'   >";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="</td><td class=\'fields\'     >\n\t\t\t\t\t";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\n\t\t\t\t<input type=\'hidden\' name=\'alt_id4_type\' id=\'alt_id4_type\' value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\n\t\t\t\t<input type=\'hidden\' name=\'alt_id4_no_dup\' id=\'alt_id4_no_dup\' value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\n\t\t\t</tr> ";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n\t\t\t\t\t\t<tr><td class =\'label\'   id=\'abha_label_visible\'>";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\n\t\t\t\t\t\t<tr><td class =\'label\' style=\'visibility:hidden\'  id=\'abha_label_visible\'>";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 =" \n\t\t\t";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n\t";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\n\t\t<tr></tr><tr></tr><tr></tr><tr>\n\t\t";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\n\t\t\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="</td>\n\t\t\t\t<td class=\'fields\' id=\'obj2\'  >\n\t\t\t\t\t<select name=\"family_org_membership\" id=\"family_org_membership\" onchange=\"if (document.forms[0].CalledFromFunction.value==\'ChangePatDtls\') {changeMakeOrgMand(this)} else {makeOrgMandate(this)}\" >\n\t\t\t\t\t<option selected value =\"\" >----------";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="----------</option>\n\t\t\t\t\t<option value =\"1\">";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="</option>\n\t\t\t\t\t<option value =\"2\">";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="</option>\n\t\t\t\t\t<option value =\"3\">";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="</option>\n\t\t\t\t\t<option value =\"4\">";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="</option>\n\t\t\t\t</select><img id=\'family_org_mem_img\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t<input type=\'hidden\' name=\'prev_mem_type\' id=\'prev_mem_type\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'mem_type_db\' id=\'mem_type_db\' value=\'\'></td>\n\t\t\t";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\tdocument.forms[0].family_org_membership.value=\'";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\';\n\t\t\t\t\t\tdocument.forms[0].prev_mem_type.value=\'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\'; \n\t\t\t\t\t\tdocument.forms[0].mem_type_db.value=\'";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\'; \n\t\t\t\t\t\tif ( \'";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\'!=\'4\') \n\t\t\t\t\t\t{ \n\t\t\t\t\t\t\tdocument.forms[0].alt_id1_no.disabled=false;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif ( \'";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\'!=\'\'&& document.forms[0].alt_id1_man_non_ctz && document.forms[0].alt_id1_man_non_ctz.value==\"false\")  \n\t\t\t\t\t\t\t\tdocument.forms[0].alt1_gif.style.visibility=\'visible\';\n\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\tdocument.forms[0].alt_id1_no.disabled=true;\n\t\t\t\t\t\t\t\tdocument.forms[0].alt1_gif.style.visibility=\'hidden\';\n\t\t\t\t\t\t} \t\t\t\t\t\t\n\t\t\t\t\t</script>";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="<td  class=\'label\'   >";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="</td>\n\t\t\t\t\t\t<td  class=\'fields\'  ><input type=\'text\' name=\'organization\' id=\'organization\' disabled maxlength=\'\' size=\'20\' onblur=\'if(this.value!=\"\"){get_org_sub_org(organization,sub_organization);}\' onchange=\'clearFieldVal(\"org\");\'><input type=\'hidden\' name=\'org_id\' id=\'org_id\' value=\'\'><input type=\'button\' disabled class=\'Button\' id=\'org_id_btn\' value=\'?\' onclick=\'get_org_sub_org(organization,sub_organization)\' >&nbsp;<input type=\'text\' name=\'sub_org_desc\' id=\'sub_org_desc\' disabled size=\'20\' onchange=\'clearFieldVal(\"suborg\");\' onblur=\'if(this.value!=\"\"){get_sub_org(sub_org_desc);getPatCategory();}if(document.forms[0].name_prefix){document.forms[0].name_prefix.disabled=false;}if(document.forms[0].name_prefix_oth_lang){document.forms[0].name_prefix_oth_lang.disabled=false;}populateEmpDat(organization,org_id,this);populateEmpDat(organization,org_id,this);\'><input type=\'hidden\' name=\'sub_organization\' id=\'sub_organization\' value=\'\'><input type=\'button\' disabled class=\'Button\' id=\'sub_org_id_btn\' value=\'?\' onclick=\'get_sub_org(sub_org_desc)\' >\n\n\t\t\n\t\t\t\t\t\t<img id=\'org_sub_org\' src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\'></img><input type=\'hidden\' name=\'selected_sub\' id=\'selected_sub\' value=\'\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tdocument.forms[0].organization.value=\'";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\';\n\t\t\t\t\t\t\t\tdocument.forms[0].org_id.value=\'";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\';\n\t\t\t\t\t\t\t\tdocument.forms[0].selected_sub.value=\'";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\';\t\t\n\t\t\t\t\t\t\t\t//document.forms[0].sub_org_desc.disabled=false;\n\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\'!=\'\')\t // for Non Organization member\n\t\t\t\t\t\t{\t/*To populate sub org details*/\t\n\t\t\t\t\t\t\tsetTimeout(\'chg_get_sub_org();\',1000);\n\t\t\t\t\t\t\tdocument.forms[0].sub_organization.value=\'";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\';\n\t\t\t\t\t\t\tdocument.forms[0].sub_org_desc.value=\'";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\';\n\t\t\t\t\t\t} /*For type 2,3,4 org suborg should be not updatable*/\n\t\t\n\t\t\t\t\t\tif ( (document.forms[0].family_org_membership.value==\'2\') \t\t\t\t\t\t  \t\t\t\t\t\t||(document.forms[0].family_org_membership.value==\'3\')  \t\t\t\t\t\t\t\t    \t\t||(document.forms[0].family_org_membership.value==\'4\') )\n\t\t\t\t\t\t{\n\t\t\n\t\t\t\t\t\t\tdocument.forms[0].sub_org_desc.disabled=true;\n\t\t\t\t\t\t\tdocument.forms[0].organization.disabled=true;\n\t\t\t\t\t\t\tdocument.forms[0].org_id_btn.disabled=true;\n\t\t\t\t\t\t\t//  family_link_no should be enabled for Non Org member in update mode\n\t\t\t\t\t\t\tif (document.forms[0].family_org_membership.value!=\'4\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif (document.forms[0].family_link_no)\n\t\t\t\t\t\t\t\t\tdocument.forms[0].family_link_no.disabled=true;\n\t\t\t\t\t\t\t\tif (document.forms[0].head_pat_search_reg)\n\t\t\t\t\t\t\t\t\tdocument.forms[0].head_pat_search_reg.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif (document.forms[0].family_link_no)\n\t\t\t\t\t\t\t\t\tdocument.forms[0].family_link_no.disabled=false;\n\t\t\t\t\t\t\t\tif (document.forms[0].head_pat_search_reg)\n\t\t\t\t\t\t\t\t\tdocument.forms[0].head_pat_search_reg.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="</tr><tr>";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="<input type=\'hidden\' name=\'head_pat_search_reg\' id=\'head_pat_search_reg\' value=\'\'><input type=\'button\' name=\'head_pat_search\' id=\'head_pat_search\' class=\'Button\' value=\'?\' onclick=\'get_patient_id()\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="<input type=\'button\' id=\'head_pat_search_reg\' name=\'head_pat_search_reg\' class=\'Button\' value=\'?\' onclick=\'get_patient_id()\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="  </td>\n\n\n\t\t\t\t  <td class=\'label\'>";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="</td>\n\t\t\t\t<td class=\'data\' id=\'head_pat_name\'  colspan=\'1\' >\t\t\t\t\t";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\n\t\t\t\t\t<td class=\'label\'   >";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 =" </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif ( (document.forms[0].family_org_membership.value==\'2\') || \t\n\t\t\t\t\t\t\t\t\t (document.forms[0].family_org_membership.value==\'3\') || (document.forms[0].family_link_no.value!=\'\') )\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tdocument.forms[0].relationship_to_head_desc.disabled=false;\n\t\t\t\t\t\t\t\tif(document.getElementById(\"relationship_to_head_code_id\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"relationship_to_head_code_id\").disabled=false;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tdocument.forms[0].relationship_to_head_desc.disabled=true;\n\t\t\t\t\t\t\t\tif(document.getElementById(\"relationship_to_head_code_id\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"relationship_to_head_code_id\").disabled=true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\n\n\t\t\t\t\t\t<img id=\'rel\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t  </td>\t \t\t\t\t\n\t\t\t\t  <td class =\'label\' id=\'relnlabel\'>&nbsp;</td>\n\t\t\t\t  <td class=\'fields\' id=\'relntext\'>&nbsp;</td>\t\n\n\t\t\t\t\t ";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\n\t\t\t</tr>";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\n<tr><td colspan=\'4\' width=\'100%\'>\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" ><tr>\n\t";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\n\t\t\n\t\t  ";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\n\t\t\t\t<td width=\'6%\'></td><td width=\'5%\'></td>\n\t\t  ";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\n\t\t\t\t<td width=\'6%\' ></td>\n\t\t  ";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\n\t\t\t<td width=\'14%\'></td><td width=\'5%\'></td>\n\t\t\t<td width=\'15%\'></td><td width=\'5%\'></td>\n\t\t\t<td width=\'15%\'></td><td width=\'5%\'></td>\n\t\t\t<td width=\'15%\'></td><td width=\'5%\'></td>\n\t ";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\n\t\t\t<td width=\'2%\'></td>\n\t";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\t\n\t\t\t ";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\n\t\t\t\t\t<td width=\'6%\'></td><td width=\'5%\'></td>\n\t\t\t ";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\n\t\t\t\t\t<td width=\'6%\' ></td>\n\t\t\t ";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\n\t<input type=\'hidden\' name=\'pat_name_as_multipart_yn\' id=\'pat_name_as_multipart_yn\' value=\"";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\"></input>\n\t<input type=\'hidden\' name=\'names_in_oth_lang\' id=\'names_in_oth_lang\' value=\"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\"></input>\n\t<input type=\'hidden\' name=\'AltdfltPSG\' id=\'AltdfltPSG\' value=\"";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\"></input>\n\t<input type=\'hidden\' name=\'defaultSelect\' id=\'defaultSelect\' value=\"----";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="----\"></input>\n\t</tr>\n\t";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 =" \n ";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\n</table>\n</td>\n</tr>\n <!-- End of Naming fields   -->\n<tr></tr><tr></tr>\n";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="</td>\n\t\t\t\t<td class=\'fields\'  colspan=\'1\'  >\n\t\t\t\t<Select name=\'sex\' id=\'sex\'  ";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 =">\n\t\t\t\t\t<Option value=\'\'>----";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="----</Option>\n\t\t\t\t\t<option value=\'M\' ";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="</option>\n\t\t\t\t\t<option value=\'F\'  ";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="</option>\n\t\t\t\t\t<option value=\'U\' ";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="</option>\n\t\t\t\t</Select><img src=\'../../eCommon/images/mandatory.gif\'></img>";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\n\t\t\t\t\t<script>document.forms[0].sex.value = \"";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\";</script>\n\t\t\t\t\t<input type=\'hidden\' name=\'v_sex\' id=\'v_sex\' value=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="<script>document.forms[0].sex.value=\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\";</script>";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 =" & ";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="</td>\n\t\t\t\t<td class=\'label\'  ><input type=\'checkbox\' name=\'age_or_dob\' id=\'age_or_dob\' ";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 =" onclick=\'disableEnableDate()\' value=\'Y\'></input>\n\t\t\t\t<input type=\'text\' name=\'b_age\' id=\'b_age\' style=\'width:35px\' maxlength=\'3\' onblur=\'gotoNext(this);disableEnableYMDH(this);fnMakeMandNatIdAltId();\' ";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="  value=\'";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\' onKeyPress=\"return ChkNumberInput(this,event,0)\">&nbsp;Y\n\t\t\t\t<input type=\'text\' name=\'b_months\' id=\'b_months\' style=\'width:25px\' maxlength=\'2\' onblur=\'gotoNext(this);disableEnableYMDH(this);fnMakeMandNatIdAltId();\' ";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\' onKeyPress=\"return ChkNumberInput(this,event,0)\">&nbsp;M\n\t\t\t\t<input type=\'text\' name=\'b_days\' id=\'b_days\' style=\'width:25px\' maxlength=\'2\' onblur=\'gotoNext(this);disableEnableYMDH(this);fnMakeMandNatIdAltId();\' ";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="  value=\"";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\" onKeyPress=\"return ChkNumberInput(this,event,0)\">&nbsp;D\n\n\t\t\t\t<input type=\'text\' name=\'b_hours\' id=\'b_hours\' style=\'width:25\' maxlength=\'2\'      value=\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\" onChange = \'gotoNext(this);\' onBlur=\'disableEnableYMDH(this);fnMakeMandNatIdAltId();\' ";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 =" onKeyPress=\"return ChkNumberInput(this,event,0);\">&nbsp;H\n\n\t\t\t\t";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'v_age\' id=\'v_age\' value=\"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'v_months\' id=\'v_months\' value=\"";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'v_days\' id=\'v_days\' value=\"";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'v_hours\' id=\'v_hours\' value=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 =" \n\t\t\t\t&nbsp;<input type=\'text\' name=\'date_of_birth\' id=\'date_of_birth\' maxlength=\'10\' size=\'8\' ";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="    value=\"\" onblur=\'gotoNext(this);disableEnableYMDH(this);calc_hij(this);fnMakeMandNatIdAltId();\'>\n\t\t\t\t";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\n\t\t\t\t<img id=\'imgdateofbirth\' src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"if (!document.getElementById(\'date_of_birth\').disabled) {document.forms[0].date_of_birth.select();return showCalendar(\'date_of_birth\',\'\',\'\',\'\');}\"  ";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 =">\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t<input type=\'hidden\' name=\'Birth_Date\' id=\'Birth_Date\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'v_date_of_birth\' id=\'v_date_of_birth\' value=\'\'>\t\t\t\t\n\t\t\t\t<input type=\'text\' name=\'b_time\' id=\'b_time\'  maxlength=\'5\' size=\'2\'  value=\"\"  onBlur=\"gotoNext(this);disableEnableYMDH(this);calc_hij(document.forms[0].date_of_birth);fnMakeMandNatIdAltId();\" ";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 =" >&nbsp;T\n\t\t\t\t<!--MMS-QH-CRF-0145  added calc_hij(this); on blur of date_of_birth control-->\n\t\t\t\t<input type=\'hidden\' name=\'hij_appl_YN\' id=\'hij_appl_YN\' value=\'";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'invalid_dob\' id=\'invalid_dob\' value=\'N\'>\n\t\t\t\t";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\n\t\t\t\t\t&nbsp;<img id=\'imgdateofbirth_hj\' src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"document.forms[0].date_of_birth_hj.select();return showCalendar_hj(\'date_of_birth_hj\',\'\',\'\',\'\');\"  ><input type=\'text\' name=\'date_of_birth_hj\' id=\'date_of_birth_hj\'  maxlength=\'10\' size=\'8\' ";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="    onblur=\'convertToGD(this);fnMakeMandNatIdAltId();\' value=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\" >";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\n\t\t\t\t";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\n\t\t\t\t<!--MMS-QH-CRF-0145-->\n\t\t\t\t";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar dob_date=\'";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\'; \n\t\t\t\t\t\tvar dob_arr = dob_date.split(\' \'); \n\t\t\t\t\t\tbirth_date = dob_arr[0]; \n\t\t\t\t\t\tdob_time = dob_arr[1]; \n\t\t\t\t\t\tdob_time = dob_time.split(\':\'); \n\t\t\t\t\t\t\n\t\t\t\t\t\t//dob_hrs = parseInt(dob_time[0],\'10\'); \n\t\t\t\t\t\t//dob_min = parseInt(dob_time[1],\'10\'); \n\n\t\t\t\t\t\tdob_hm = dob_time[0]+\":\"+dob_time[1];\n\n\t\t\t\t\t\t/*\n\t\t\t\t\t\tif(dob_min<30) {\n\t\t\t\t\t\t\tdob_hrs = dob_hrs;\n\t\t\t\t\t\t} else if(dob_min>=30) {\n\t\t\t\t\t\t\tdob_hrs = dob_hrs+1;\n\t\t\t\t\t\t} \n\t\t\t\t\t\tif(dob_hrs<=9) {\n\t\t\t\t\t\t\tdob_hrs=\'0\'+dob_hrs+\':00\';\n\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\tdob_hrs=dob_hrs+\':00\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\t*/ \n\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tbirth_date = convertDate(birth_date,\'DMY\',\'en\',\'";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.forms[0].date_of_birth.value=birth_date;\n\t\t\t\t\t\t\tdocument.forms[0].v_date_of_birth.value=birth_date;\n\t\t\t\t\t\t\tdocument.forms[0].Birth_Date.value=\'";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\'b_hours\').value!=\"\")\n\t\t\t\t\t\t\t\tdocument.forms[0].b_time.value = dob_hm;\n\t\t\t\t\t\t</script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\n\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tcalc_hij(document.forms[0].date_of_birth)\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\n\t\t\t\t\t    <script>document.forms[0].date_of_birth.value=\'";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\'</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\n\t\t\t\t\t\t<!--Commented below and added by Ashwin K for AAKH-CRF-0150 -->\n\t\t\t\t\t   <!-- <script>document.forms[0].date_of_birth.value=\'\' </script> -->\n\t\t\t\t\t    <script>document.forms[0].date_of_birth.value=\'";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\' </script> \n\n\t\t\t\t\t   \n\t\t\t\t\t";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\n\t\t\t\t\t\t\t\t\t<script>document.forms[0].date_of_birth.disabled=false;</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\n\t\t\t\t\t\t\t<select name=\"blood_group\" id=\"blood_group\" ";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="><option value=\"";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 =" ><option value=\"\" >------";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="-------</option>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\n\t\t\t\t\t    </select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<select name=\'rf_code\' id=\'rf_code\' ";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 =" ><option value=\'\'  >------";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="-----</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\n\t\t\t\t\t\t\t</select>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\n\t\t\t\t\t\t\t<select name=\'known_allergy_yn\' id=\'known_allergy_yn\'  ><option value=\'U\' >--";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="--</option>\n\t\t\t\t\t\t\t<option value=\'Y\'>";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="</option>\n\t\t\t\t\t\t\t<option value=\'N\'>";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="</option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].known_allergy_yn.value=\'";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\';\n\t\t\t\t\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 =" > 0) {\n\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].known_allergy_yn.disabled = true;\t\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'known_allergy_yn\' id=\'known_allergy_yn\' value=\'U\'>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'   >";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="</td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'mar_status_desc\' id=\'mar_status_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\" onblur=\'if(this.value!=\"\"){searchMaritalStatus(mar_status_code,mar_status_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'mar_status_id\'  name=\'mar_status_code_id\' id=\'mar_status_code_id\' value=\'?\' class=\'button\' onclick=\'searchMaritalStatus(this,mar_status_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'mar_status_code\' id=\'mar_status_code\' value=\"";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'mar_status_desc\' id=\'mar_status_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchMaritalStatus(mar_status_code,mar_status_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'mar_status_id\'  name=\'mar_status_code_id\' id=\'mar_status_code_id\' value=\'?\' class=\'button\' onclick=\'searchMaritalStatus(this,mar_status_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'mar_status_code\' id=\'mar_status_code\' value=\"\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\n\n\n\n\t\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="</td>\n\t\t\t\t\t\t<td  class=\'fields\'   >\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=hidden name=\'v_birth_place_code\' id=\'v_birth_place_code\' value=\"";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\">\t\n\t\t\t\t\t\t\t<input type=hidden name=\'v_birth_place_desc\' id=\'v_birth_place_desc\' value=\"";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\">\n\t\t\t\t\t\t\t<input type=\'text\' name=\'place_of_birth_desc\' id=\'place_of_birth_desc\' size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\" onblur=\'if(this.value!=\"\")searchBirthplace(place_of_birth_code,place_of_birth_desc); if(this.value==\"\"){if(document.forms[0].place_of_birth_code)document.forms[0].place_of_birth_code.value=\"\";}\'  ><input type=\'button\'  id=\'birth_place_id\'  name=\'birth_place\' id=\'birth_place\' value=\'?\' class=\'button\' onclick=\'searchBirthplace(this,place_of_birth_desc)\' >\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'place_of_birth_code\' id=\'place_of_birth_code\' value=\"";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\n\t\t\t\t\t\t\t<input type=\'text\' name=\'place_of_birth\' id=\'place_of_birth\' maxlength=\'30\' size=\'20\'  value=\"";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\" onblur=\'makeValidString(this);\'  >\n\t\t\t\t\t\t\t<input type=hidden name=\"v_place_of_birth\" id=\"v_place_of_birth\" value=\"";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\n\t\t\t\t\t\t\t<input type=\'text\' name=\'place_of_birth_desc\' id=\'place_of_birth_desc\' value=\"";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\" size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\")searchBirthplace(place_of_birth_code,place_of_birth_desc);\' ><input type=\'button\' name=\'birth_place\' id=\'birth_place\'  id=\'birth_place_id\'  value=\'?\' class=\'button\' onclick=\'searchBirthplace(this,place_of_birth_desc)\' >\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'place_of_birth_code\' id=\'place_of_birth_code\' value=\'\'>";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"place_of_birth\" id=\"place_of_birth\" maxlength=\"30\" size=\"20\"  value=\"";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\" onblur=\'makeValidString(this);\'  >";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"place_of_birth\" id=\"place_of_birth\" maxlength=\"30\" size=\"27\"  value=\'\' onblur=\'makeValidString(this);\'  >";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\'text\' name=\'place_of_birth_desc\' id=\'place_of_birth_desc\' size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\")searchBirthplace(place_of_birth_code,place_of_birth_desc);\'  ><input type=\'button\' name=\'birth_place\' id=\'birth_place\' id=\'birth_place_id\' value=\'?\' class=\'button\' onclick=\'searchBirthplace(this,place_of_birth_desc)\' >\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'place_of_birth_code\' id=\'place_of_birth_code\' value=\'\'>\n\t\t\t\t\t\t\t<input type=\"text\" name=\"place_of_birth\" id=\"place_of_birth\" maxlength=\"23\" size=\"20\"   onblur=\'makeValidString(this);\' value=\"\">";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t </tr>\n\t\t\t  \t <tr>\n\t\t\t\t\t<td  class=\"label\" >";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'pat_cat_desc\' id=\'pat_cat_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\" onblur=\'if(this.value!=\"\"){searchCategory(pat_cat_code,pat_cat_desc);}else{clearfields();} getExpDate(this.value,\"";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\")\'   ><input type=\'button\'  name=\'pat_cat_code_id\' id=\'pat_cat_code_id\' value=\'?\' class=\'button\' onclick=\'searchCategory(this,pat_cat_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'pat_cat_code\' id=\'pat_cat_code\' value=\"";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\">\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'pat_cat_desc\' id=\'pat_cat_desc\' size=\'20\' maxlength=\'20\' value=\"\"     onblur=\'if(this.value!=\"\"){searchCategory(pat_cat_code,pat_cat_desc);}else{clearfields();}getExpDate(this.value,\"";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\")\'><input type=\'button\'  name=\'pat_cat_code_id\' id=\'pat_cat_code_id\' value=\'?\' class=\'button\'  onclick=\'searchCategory(this,pat_cat_desc)\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'pat_cat_code\' id=\'pat_cat_code\' value=\"\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\n\t\t\t\t\t<img\tid=\'imgCategoryMan\' src=\'../../eCommon/images/mandatory.gif\' style=\"display:inline\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="<img id=\'imgCategoryMan\' src=\'../../eCommon/images/mandatory.gif\' style=\"display:none\"></td>";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].pat_cat_code.value=\'";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\'\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\n\t\t\t\t\t\t<td   class=\"label\"  >";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' ><input type=\'hidden\' name=\'exp_val_appl_yn\' id=\'exp_val_appl_yn\' value=\'\'><input type=\'text\'  name=\'pat_cat_code_exp_date\' id=\'pat_cat_code_exp_date\'  maxlength=\'\' size=\'8\' onblur=\'makeValidString(this);validDateObj(this,\"DMY\",localeName)\' value=\"\" ></input><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'imgCatExpDate\' \n\t\t\t\t\t\tonClick=\"document.forms[0].pat_cat_code_exp_date.select();return showCalendar(\'pat_cat_code_exp_date\',null,null,true);\" ><img\t  id=\'imgCatExpDateMan\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></img></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="<td class=\'fields\' colspan=\'2\'><input type=\'hidden\' name=\'exp_val_appl_yn\' id=\'exp_val_appl_yn\' value=\'\'><input type=\'hidden\' name=\'pat_cat_code_exp_date\' id=\'pat_cat_code_exp_date\'  value=\"\"><img id=\'imgCatExpDateMan\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\" ></img></td>";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\n\t\t\t\t<script>document.forms[0].pat_cat_code.value=\'";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\'</script>";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\n\t\t\t<script>\n\t\t\t\tif (document.forms[0].pat_cat_code_exp_date)\n\t\t\t\t{\tdocument.forms[0].pat_cat_code_exp_date.value=\'";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\';\n\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\'==\'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].pat_cat_code_exp_date.disabled=true;\n\t\t\t\t\t\tdocument.getElementById(\'imgCatExpDate\').disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].pat_cat_code_exp_date.disabled=false;\n\t\t\t\t\t\tdocument.getElementById(\'imgCatExpDate\').disabled=false;\n\t\t\t\t\t}\n\t\t\t\t }\n\t\t\t</script>";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\n\t\t\t\t\t<td  class=\"label\"  >";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="</td>\n\t\t\t\t\t<td   >\n\t\t\t\t\t\t<table width=\'100%\'>\n\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t<td class=\"oaBorder\"   >\n\t\t\t\t\t\t\t\t<input type=\'radio\' name=\'citizen\' id=\'citizen_y\' value=\'Y\' ";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 =" onClick=\'changestatdis();\' >";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\n\t\t\t\t\t\t\t\t<input type=\'radio\' name=\'citizen\' id=\'citizen_n\' value=\'Y\' ";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\t";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 =" onClick=\'changestatus();\' >";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="</td>\n\t\t\t\t\t\t\t\t<input type=hidden name=\'citizen_yn\' id=\'citizen_yn\' value=\"";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\'15%\'>&nbsp;</td>\n\t\t\t\t\t\t  </tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   class=\"label\" >";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\n\t\t\t\t\t<td  >\n\t\t\t\t\t<table width=\'100%\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"oaBorder\"    width=\'50%\'><input type=\'radio\' name=\'legal\' id=\'legal\' value=\"Y\" checked  onClick=\'selVal();\' ";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="  ";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="<input type=\'radio\' name=\'legal\' id=\'legal\' value=\"N\" onClick=\'selVal();\'  ";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="</td>\n\t\t\t\t\t\t<td >&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<input type=hidden name=\'legal_yn\' id=\'legal_yn\' value=\"";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="</td>\n\t\t\t\t\t<td    >\n\t\t\t\t\t\t<table width=\'100%\'>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"oaBorder\"  >\n\t\t\t\t\t\t\t\t<input type=\'radio\'  name=\'citizen\' id=\'citizen\' value=\'Y\' checked onClick=\'change_stat_dis();\' ><label for=\'citizenid\' id=\'lbl1\'>";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="</label>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\n\t\t\t\t\t\t\t\t<input type=\'radio\' name=\'citizen\' id=\'citizen\' value=\'Y\' onClick=\'change_status();\' >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="<input type=\'radio\' name=\'citizen\' id=\'citizen\' value=\'Y\' onClick=\'change_status_emer();\' >";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="<label for=\'citizenid2\' id=\'lbl2\'>";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="</label></td>\n\t\t\t\t\t\t\t\t<input type=hidden name=\'citizen_yn\' id=\'citizen_yn\' value=\"Y\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\n\t\t\t\t\t\t\t\t<script>\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t if(\'";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\' == \'Y\') {\n\t\t\t\t\t\t\t\t\t\tdocument.PatRegForm.citizen_yn.value=\'Y\';\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"citizen\").checked=true;}\n\t\t\t\t\t\t\t\t\t else if(\'";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\' == \'N\') {\n\t\t\t\t\t\t\t\t\t\tdocument.PatRegForm.citizen_yn.value=\'N\';\n\t\t\t\t\t\t\t\t\t\tdocument.PatRegForm.citizen[1].checked=true;\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t <td width=\'15%\'>&nbsp;</td> \n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   class=\"label\" >";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="</td>\t\t\t\t\n\t\t\t\t\t<td  ><table width=\'100%\'><tr><td class=\"oaBorder\"    width=\'50%\'><input type=\'radio\' name=\'legal\' id=\'legal\' value=\"Y\" checked onClick=\'select_val();\' \t  disabled>";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="<input type=\'radio\' name=\'legal\' id=\'legal\' value=\"Y\" onClick=\'select_val();\'  disabled>";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="</td>\n\t\t\t\t\t<td class=\'label\' >&nbsp;</td></tr></table></td>\n\t\t\t\t\t<input type=hidden name=\'legal_yn\' id=\'legal_yn\' value=\"Y\">";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\n\t\t\t\t\t\t<script>\t\t\t\t\t \n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\' == \'Y\') {\n\t\t\t\t\t\t\t\tdocument.PatRegForm.legal_yn.value=\'Y\';\n\t\t\t\t\t\t\t\tdocument.PatRegForm.legal[0].checked=true;\n\t\t\t\t\t\t\t} else if(\'";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\' == \'N\') {\n\t\t\t\t\t\t\t\tdocument.PatRegForm.legal_yn.value=\'N\';\n\t\t\t\t\t\t\t\tdocument.PatRegForm.legal[1].checked=true;\n\t\t\t\t\t\t\t} \n\t\t\t\t\t\t</script>";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\n\t\t\t</tr>\n\t\t\t\t<!--//Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750] Start-->\n\t\t\t";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' >\n\t\t\t\t\t<select name=\"visa_type\" id=\"visa_type\" ";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="disabled";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 =" onchange=\"fnMakeMandNatIdAltId();\">\n\t\t\t\t\t\t<option ";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="selected ";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 =" value=\"W\">";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="</option>\n\t\t\t\t\t\t<option ";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 =" value=\"V\">";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\n\t\t\t<!--//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022-->\n\t\t\t\t";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 =" onchange=\"fnMakeMandNatIdAltId();\">\t\t\t\t\t\t\n\t\t\t\t\t\t<option ";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 =" selected ";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 =" value=\"\">----";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="----</option>\n\t\t\t\t\t\t<option ";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="</option>\n\t\t\t\t\t</select><img style=\'visibility:hidden;\' id=\"madimg\" src=\'../images/mandatory.gif\'></img><!--Added by Kamatchi S for AAKH-CRF-0145-->\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\n\t\t\t\t<!--Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750] End-->\n\t\t\t<tr>\n\t\t\t <td class=\"label\" >";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="</td>\n\t\t\t <td class=\'fields\' >";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\n\t\t\t\t\t<input type=\'text\' name=\'nationality_desc\' id=\'nationality_desc\' size=\'20\' maxlength=\'20\'  onblur=\'if(this.value !=\"\") searchCountry(contry_code[0], nationality_desc);clearrace();validateResidency(this);\' value=\"";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="><input type=\'button\' name=\'contry_code\' id=\'contry_code\' id=\'nat_id_btn\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,nationality_desc);clearrace();validateResidency(nationality_desc);\'  ";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="><img src=\'../images/mandatory.gif\'></img>\n\t\t\t\t\t<input type=\'hidden\' name=\'nationality_code\' id=\'nationality_code\' value=\"";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"dft_natCd\" id=\"dft_natCd\" value=\"";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"dft_natDesc\" id=\"dft_natDesc\" value=\"";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\"></td>";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\n\t\t\t\t\t<input type=\'text\' name=\'nationality_desc\' id=\'nationality_desc\' size=\'20\' maxlength=\'20\'  onblur=\'if(this.value !=\"\") searchCountry(contry_code[0], nationality_desc); clearrace();validateResidency(this);\' value=\"";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\" ><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,nationality_desc);clearrace();validateResidency(nationality_desc);\' ><img src=\'../images/mandatory.gif\'></img>\n\t\t\t\t\t<input type=\'hidden\' name=\'nationality_code\' id=\'nationality_code\' value=\"";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"dft_natCd\" id=\"dft_natCd\" value=\"";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\n\t\t\t\t\t<input type=\'text\' name=\'nationality_desc\' id=\'nationality_desc\' size=\'20\' maxlength=\'20\'  onblur=\'if(this.value !=\"\") search_Country(this, nationality_desc);validateResidency(this);\' value=\"";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\" ><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'search_Country(this,nationality_desc);validateResidency(nationality_desc);\' ><img style=\'visibility:hidden;\' id=\'natimg\' name=\'natimg\' src=\'../images/mandatory.gif\'></img>\n\t\t\t\t\t<input type=\'hidden\' name=\'nationality_code\' id=\'nationality_code\' value=\"";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'dflt_nationality_desc\' id=\'dflt_nationality_desc\' value=\"";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\">\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\n\t\t\t";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\n\t\t\t\t<td  class=\"label\" >";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\n\t\t\t\t<input type = \'hidden\' name = \'default_race_desc\' id = \'default_race_desc\' value=\'";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\'>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\n\t\t\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'race_desc\' id=\'race_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="\" onblur=\'if(this.value!=\"\"){searchRace(race_code,race_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'race_id\'  name=\'race_desc_id\' id=\'race_desc_id\' value=\'?\' class=\'button\' onclick=\'searchRace(this,race_desc)\' >\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'race_code\' id=\'race_code\' value=\"";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\n\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'race_desc\' id=\'race_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\" onblur=\'if(this.value!=\"\"){searchRace(race_code,race_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'race_id\'  name=\'race_desc_id\' id=\'race_desc_id\' value=\'?\' class=\'button\' onclick=\'searchRace(this,race_desc)\' >\n\t\t\t\t<input type=\'hidden\' name=\'race_code\' id=\'race_code\' value=\"";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\" onblur=\'if(this.value!=\"\"){searchRace(race_code,race_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'race_id\'  name=\'race_desc_id\' id=\'race_desc_id\' value=\'?\' class=\'button\' onclick=\'searchRace(this,race_desc)\' >\n\t\t\t\t<!--Below Condition Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384-->\n\t\t\t\t";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'race_code\' id=\'race_code\' value=\"";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\n\t\t\t\t<input type=\'hidden\' name=\'race_code\' id=\'race_code\' value=\"";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\n\t\t\t\t<font id=\'eg\'><img id=\'image1\' src=\'../images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\'></img></font>\n\t\t\t\t<input type=\"hidden\" name=\"dft_raceCd\" id=\"dft_raceCd\" value=\"";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'race_required_yn\' id=\'race_required_yn\' value = \'";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\'>\t\n\t\t\n\t\t\t  </td>\n\t\t\t   </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td   class=\"label\" >";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\n\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'ethnic_group_desc\' id=\'ethnic_group_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\" onblur=\'if(this.value!=\"\"){searchEthnic(ethnic_group,ethnic_group_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'ethnic_id\'  name=\'ethnic_group_id\' id=\'ethnic_group_id\' value=\'?\' class=\'button\' onclick=\'searchEthnic(this,ethnic_group_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'ethnic_group\' id=\'ethnic_group\' value=\"";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'ethnic_group_desc\' id=\'ethnic_group_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'ethnic_group_desc\' id=\'ethnic_group_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchEthnic(ethnic_group,ethnic_group_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'ethnic_id\'  name=\'ethnic_group_id\' id=\'ethnic_group_id\' value=\'?\' class=\'button\' onclick=\'searchEthnic(this,ethnic_group_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'ethnic_group\' id=\'ethnic_group\' value=\"\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\n\t\t\t\t\t</td>\n                  <!--Below Fiels Added By Mano for ML-MMOH-CRF-0736 -->\n\t\t\t\t<td  class=\"label\" >";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="</td>  \n             \t\t";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'relgn_desc\' id=\'relgn_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\" onblur=\'if(this.value!=\"\"){searchReligion(relgn_code,relgn_desc);}else{clearfields();} \'   ><input type=\'button\'  id=\'relgn_id\'  name=\'relgncode_id\' id=\'relgncode_id\' value=\'?\' class=\'button\' onclick=\'searchReligion(this,relgn_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'relgn_code\' id=\'relgn_code\' value=\"";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\"><font id=\'eg\'><img id=\'image2\' src=\'../images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\n\t\t\t\t<td  class=\'fields\'><input type=\'text\' name=\'relgn_desc\' id=\'relgn_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\" onblur=\'if(this.value!=\"\"){searchReligion(relgn_code,relgn_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'relgn_id\'  name=\'relgncode_id\' id=\'relgncode_id\' value=\'?\' class=\'button\' onclick=\'searchReligion(this,relgn_desc)\' >\n\t\t\t\t<input type=\'hidden\' name=\'relgn_code\' id=\'relgn_code\' value=\"";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\n\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'relgn_desc\' id=\'relgn_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\'></img></font>\n\t\t\t\t";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\n\t\t\t\t<input type=\'hidden\' name=\'religion_reqd_yn\' id=\'religion_reqd_yn\' value = \'";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\'>  \n\t\t\t\t</td>\n                <!-- End of ML-MMOH-CRF-0736 by Mano -->\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'language_desc\' id=\'language_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\" onblur=\'if(this.value!=\"\")searchLanguage(language_code,language_desc);\'   ><input type=\'button\'  id=\'language_id\'  name=\'language_code_id\' id=\'language_code_id\' value=\'?\' class=\'button\' onclick=\'searchLanguage(this,language_desc)\'  >\n\t\t\t\t\t<input type=\'hidden\' name=\'language_code\' id=\'language_code\' value=\"";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\t\t\t\n\t\t\t\t<td  class=\'fields\'><input type=\'text\' name=\'language_desc\' id=\'language_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\" onblur=\'if(this.value!=\"\")searchLanguage(language_code,language_desc);\'   ><input type=\'button\'  id=\'language_id\'  name=\'language_code_id\' id=\'language_code_id\' value=\'?\' class=\'button\' onclick=\'searchLanguage(this,language_desc)\'  >\n\t\t\t\t<input type=\'hidden\' name=\'language_code\' id=\'language_code\' value=\"";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\">\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\n\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'language_desc\' id=\'language_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\n\t\t\t\t\n\t\t\t\t<td  class=\'fields\'><input type=\'text\' name=\'language_desc\' id=\'language_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\" onblur=\'if(this.value!=\"\")searchLanguage(language_code,language_desc);\'><input type=\'button\'  id=\'language_id\'  name=\'language_code_id\' id=\'language_code_id\' value=\'?\' class=\'button\' onclick=\'searchLanguage(this,language_desc)\' >\n\t\t\t\t<input type=\'hidden\' name=\'language_code\' id=\'language_code\'  value=\"";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\"><!--pat_language_id modified by Rameswar on 09/11/2016 against IN62532 -->\n\t\t\t\t";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<select name=\'eye_indicator\' id=\'eye_indicator\'><option value=\'\' >------";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="-------</option>\n\t\t\t\t\t\t<option value=\'RE\' ";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="</option>\n\t\t\t\t\t\t\t<option value=\'LE\' ";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="</option>\n\t\t\t\t\t\t\t\n\t\t\t\t\t    </select>\n\t\t\t\t\t</td>\n\t\t\t\t</tr><tr>\n\t\t\t\t";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="\n\t\t\t\t\t<td   class=\"label\" >";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="</td>\n\t\t\t\t\t<td  class=\'fields\'>";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\n\t\t\t\t\t<input type=\'text\' name=\'alias_name\' id=\'alias_name\' maxlength=\'30\' size=\'20\' value=\"\"   ";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="></td>\n\t\t\t\t\t<!--Below line Added for this CRF GDOH-CRF-0029 [IN:048764] --><!--below line Removed Seconds-->\n\t\t\t\t\t<!-- Added by Sangeetha for GDOH-CRF-0148 on 17-mar-17--> \n\t\t\t\t\t";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\n\t\t\t\t\t\t\t<td   class=\"label\" >";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="</td>\n\t\t\t\t\t\t\t<td  class=\'fields\'><input type=\'text\' name=\"disas_regn_date_time\" id=\"disas_regn_date_time\"  value=\"";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\" maxLength=\'19\' size=\'19\' onBlur=\'chkRegDateTime(this);\' ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'disas_regn_date_time\',\'dd/mm/yyyy\' ,\'hh:mm\',null );\" style=\'cursor:pointer\'></img>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></img></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\' ><input type=\'text\'  name=\"disas_regn_date_time\" id=\"disas_regn_date_time\"  value=\"";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="\" maxLength=\'19\' size=\'19\' disabled><img src=\"../../eCommon/images/CommonCalendar.gif\" style=\'cursor:pointer\' disabled></img></td>  \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="\n\t\t\t\t\t\t<td   class=\"label\" >";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 ="</td>\n\t\t\t\t\t<td  class=\'fields\'><input type=\'text\' name=\"disas_regn_date_time\" id=\"disas_regn_date_time\"  value=\"";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 ="\" maxLength=\'19\' size=\'19\' onBlur=\'chkRegDateTime(this);\' ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'disas_regn_date_time\',\'dd/mm/yyyy\' ,\'hh:mm\',null );\" style=\'cursor:pointer\'></img>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></img></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="\n\t\t\t\t\t<!--End GDOH-CRF-0029 [IN:048764] -->\n\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.forms[0].alias_name.value = \"";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="\";\n\t\t\t\t\t\t</script>";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 ="\n\t\t\t\t\t<td class=\'label\' colspan=\'2\'></td> \n\t\t\t\t";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="\n\t\n\t\t\t</tr>\n\n\t\t\t<!-- if block Added for MYHIX integration ML-MMOH-CRF-0507.1. -->\n\t\t\t";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="\t\t\t\t\n\t\t\t\t<tr><td class=\"label\" >";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 ="</td><td class=\"fields\" ><select name=\'myhix_consent\' id=\'myhix_consent\'>\n\t\t\t\t\t\t\t<option value=\'Y\' ";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 =">Yes</option>\n\t\t\t\t\t\t\t\t<option value=\'N\' ";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 =">No</option>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="\t\t\t \n\t\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 ="</td>\n\t\t\t\t\t\t<td class=\"fields\" ><input type=\"text\" readonly name=\"myhix_pat_id\" id=\"myhix_pat_id\" value=\'";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 ="\' size=\'60\'></td>\n\t\t\t\t\t\t<!--<td class=\"label\" >";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="</td>-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="\n\t\t\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 =" \n\t\t\t</tr>\n\n\t\t\t <!-- if block Added for NDHM integration GHL-CRF-0657.1. -->\n\t\t\t<!--";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="\t\t\t \n\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="</td>\n\t\t\t\t\t<td class=\"label\"><input type=\"text\" name=\"abha_pat_id\" id=\"abha_pat_id\"  readonly id=\"abha_pat_id\" value=\'";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\' size=\'20\' ><a href=\"javascript:onClick=clearABHA();\">Unlink</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="-->\n\t\t\t<!-- Below added by Suji Keerthi for ML-MMOH-CRF-1527 on June-22,2020 -->\n\t\t\t";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="\n\t\t\t<tr><td  class=\"label\" >";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 ="</td>\n\t\t\t<td  class=\'fields\'><input type=\"text\" name=\'household_monthly_income\' id=\'household_monthly_income\' id=\"inputText\" onpaste=\"return isNumber(event);\" onkeypress=\"return isNumber(event)\"  value=\"\" maxlength=\'6\' size=\'20\'>\n            </td>\n            \t\t\t\n\t\t\t";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.forms[0].household_monthly_income.value = \"";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 ="\n\t\t\t<!-- Ended for ML-MMOH-CRF-1527 -->\n\t\t\t<!--Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] Start-->\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="</td>\n\t\t\t\t<td class=\"fields\" ><input type=\"checkbox\" name=\"blood_donor\" id=\"blood_donor\" value=\"Y\" ";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 =" /></td>\n\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<!--Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] End-->\n\n\n\t\t";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 ="\n\t\t<script>\n\t\t<!--Starts Maheshwaran added for TH-KW-CRF-0019-->\n\t/*\tif(document.getElementById(\'nat_id_exp_date\') != null)\n\t\t\talert(\'document.getElementById(\'nat_id_exp_date\') : \'+document.getElementById(\'nat_id_exp_date\'));\n\t\t\tif(document.getElementById(\'nat_id_exp_date\').value == \'\')\n\t\t\t\tdocument.getElementById(\'natidexpdate\').disabled = true; */\n\t\t<!--Ends Maheshwaran added for TH-KW-CRF-0019-->\n\t\t\tif(document.getElementById(\'alt_id2_exp_date\') != null)\n\t\t\t\tif(document.getElementById(\'alt_id2_exp_date\').value == \'\')\n\t\t\t\t\tdocument.getElementById(\'altidexpdt2\').disabled = true;\n\t\t\t\t\n\t\t\tif(document.getElementById(\'alt_id3_exp_date\') != null)\n\t\t\t\tif(document.getElementById(\'alt_id3_exp_date\').value == \'\')\n\t\t\t\t\tdocument.getElementById(\'altidexpdt3\').disabled = true;\n\t\t\t\t\n\t\t\tif(document.getElementById(\'alt_id4_exp_date\') != null)\n\t\t\t\tif(document.getElementById(\'alt_id4_exp_date\').value == \'\')\n\t\t\t\t\tdocument.getElementById(\'altidexpdt4\').disabled = true;\n\n\t\t\tfunction aa() {\n\t\t\t\t\n\t\t\t\tif ( (\"";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="\"  == \"ChangePatDtls\") || (document.forms[0].function_id.value  == \"NEWBORN_REG\") ) {\n\t\t\tif(parent.patient_main.document.getElementById(\'patient_name\')) {\n\t\t\t\tparent.patient_main.document.getElementById(\'patient_name\').value=\"";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\"; \n\t\t\t}\n\t\t\t\t\t";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="\n\t\t\t\t\t\n\t\t\t\t\t\tif(parent.patient_main.document.getElementById(\'patient_name_loc_lang\'))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.patient_main.document.getElementById(\'patient_name_loc_lang\').value=\"";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\";\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(parent.patient_main.document.getElementById(\'patient_name_loc_lang_long\'))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.patient_main.document.getElementById(\'patient_name_loc_lang_long\').value=\"";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\";\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(document.forms[0].family_org_membership) {\n\t\t\t\t\t\tif(document.forms[0].family_org_membership.value==\'1\') {\n\t\t\t\t\t\t\tif(document.forms[0].name_prefix_img) {\n\t\t\t\t\t\t\t\tif(document.getElementById(\'name_pfx_reqd_for_org_mem_yn\')) {\n\t\t\t\t\t\t\t\t\tif(document.getElementById(\'name_pfx_reqd_for_org_mem_yn\').value==\'Y\') {\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].name_prefix_img.style.visibility=\'visible\';\t\n\t\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].name_prefix_img.style.visibility=\'hidden\';  \n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t</script>";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\n<script>\n/*function clearvalue(){\nalert(\"hhdhds\");\n\nif(document.forms[0].language_desc.value==\"\"){\nalert(\"kfkdfkd\");\ndocument.getElementById(\'language_code\').value==\"\";\n}\n\n}*/\n\nfunction getCurrentSysDate(format, locale){\n\tvar xhr =  getXHR();\n\tvar url = \"../../eCommon/jsp/DateUtils.jsp?methodName=getCurrentDate&format=\"+format+\"&locale=\"+locale;\n    xhr.open(\"POST\", url, false);\n\txhr.setRequestHeader(\"Content-Type\",\"text/plain\")\n   \txhr.send(\"\");\n\tvar xmlText = trimString(xhr.responseText)\n\treturn(xmlText);\n}\n/*Below line added for this CRF  GDOH-CRF-0029 [IN:048764]*/\nfunction chkRegDateTime(Obj)\n{\n\tvar fromatFormDate =\'\'; \n\tvar errors=\'\';\t\n\tvar CurrentDate = getCurrentSysDate(\"DMYHM\",localeName); /*Removed Seconds*/\n\tif(Obj.value != \'\') \n\t{\n\t\tif(!validDate(Obj.value,\'DMYHM\',localeName))\n\t\t{\n\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\'SM\'));\n\t\t\tObj.select();\n\t\t}\n\t\telse\n\t\t{ \n\t\tfromatFormDate = convertDate(Obj.value,\"DMYHM\",localeName,\"en\");\t\t/*Removed Seconds*/\n\t\t\n\t\tvar birthDate=document.getElementById(\'Birth_Date\').value; \n\t\tif(birthDate.length==19)birthDate=birthDate.substring(0,16);\t\n        if(birthDate.length==18)birthDate=birthDate.substring(0,15); //Added for this incident [54759]\t\t\n        if(birthDate.length==17)birthDate=birthDate.substring(0,14);\t//Added for this incident [54759]\t\t\n\t\tbirthDate=convertDate(birthDate,\"DMYHM\",localeName,\"en\");  /*Removed Seconds*/\n\t\t \n       //var birthDate=convertDate(document.getElementById(\'Birth_Date\').value,\"DMYHM\",localeName,\"en\");  /*Removed Seconds*/\n\t   \n\t\t       \t \n\t\tif(!isAfter(CurrentDate,Obj.value,\"DMYHM\",localeName)){ /*Removed Seconds*/\n\t\t\tvar error = getMessage(\'CANNOT_GREATER\',\'MP\');\t\t\t\n\t\t\tvar message2=getLabel(\"Common.RegistrationDate.label\",\'Common\')+\" \"+getLabel(\"Common.time.label\",\'Common\'); \n\t\t\tvar message1=getLabel(\"Common.CurrentDate.label\",\'Common\')+\" \"+getLabel(\"Common.time.label\",\'Common\'); \n\t\t\terror = error.replace(\'$\',message1);\t\t\t\n\t\t\terror = error.replace(\'#\',message2);\n\t\t\talert(error);\n\t\t\tObj.value=\"\";\n\t\t\tObj.select();\n\t\t} else if(birthDate!=\"\"&&!isAfter(fromatFormDate,birthDate,\"DMYHM\",localeName)){  /*Removed Seconds*/\t\t\n\t\t    var error = getMessage(\'CANNOT_LESSER\',\'MP\');\t\t\t\n\t\t\tvar message1=getLabel(\"Common.RegistrationDate.label\",\'Common\')+\" \"+getLabel(\"Common.time.label\",\'Common\'); \n\t\t\tvar message2=getLabel(\"Common.birthDate.label\",\'Common\')+\" \"+getLabel(\"Common.time.label\",\'Common\'); \n\t\t\terror = error.replace(\'$\',message2);\t\t\t\n\t\t\terror = error.replace(\'#\',message1);\n\t\t\talert(error);\n\t\t\tObj.value=\"\";\n\t\t\tObj.select();\n\t\t}\n\t\t}\n\t}\n}\n\n//End GDOH-CRF-0029 [IN:048764]\n\n</script>\n\t\t\n";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
	/*Added by lakshmanan on nov 03 2022 against GHL-CRF-0657.1*/
	public static String getNDHMApplicable(Connection con){
		String sqlNDHMApplicable="SELECT count(*) FROM XH_STANDARD_PROFILE WHERE PROFILE_ID LIKE '%NDHMPROF1%' and NVL(EFF_STATUS,'Y') = 'Y' AND ROWNUM = 1  ";
		int count=0;
		String ndhmYN="N";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(sqlNDHMApplicable);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			if(count > 0){
				ndhmYN="Y";
			}
		}catch(Exception ex){
			System.err.println("Exception in getNDHMApplicable --> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return ndhmYN;
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
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Properties p				=	(java.util.Properties) session.getValue("jdbc");
	String sStyle			=	checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String Smartcard_path="" ; //added for smart card                          
	String function_name="" ; //added for Alkhalej smart card 
	String MdisEnb						= "";
	String ClickVal						= "";
	String year_value					= "";
	String age_or_dob				= "";
	String month_value				= "";
	String day_value					= "";
	String hours_value					= "";
	String age_value					= "";
	String race_trigger					= "";
	String patient_id					= checkForNull(request.getParameter("patient_id"));
	String group							= checkForNull(request.getParameter("group"));
	String CalledFromFunction		= checkForNull(request.getParameter("CalledFromFunction"));	
	String applicableFor			= checkForNull(request.getParameter("ApplicableFor"));	//Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689
	String emeg_pat_ser_grp			= checkForNull(request.getParameter("emeg_pat_ser_grp"));
	String default_race_code			= checkForNull(request.getParameter("default_race_code"));
	String sessionID 		= 			session.getId();
	String facility			= (String) 	session.getValue("facility_id");
	String loginUser		= (String)	session.getValue("login_user");  // added by mujafar for KDAH-CRF-370.1
	String p_ws_no = p.getProperty("client_ip_address"); // added by mujafar for KDAH-CRF-370.1
	String hij_appl_YN="N";   //MMS-QH-CRF-0145
	String hijiri_b_date="";
	String myhix_consent=""; // Added for MYHIX integration ML-MMOH-CRF-0507.1.
	String ndhm_consent=""; // Added for NDHM integration GHL-CRF-0657.1
	String myhix_pat_id="";  // Added for MYHIX integration ML-MMOH-CRF-0507.1.
	String abha_pat_id="";  // Added for ABHA integration GHL-CRF-0657.1.
	String LinkHealthIDUpadatefieldname="";  // Added for ABHA integration GHL-CRF-0657.1.
	String UpdateHealthIDVisible="";  // Added for ABHA integration GHL-CRF-0657.1.
	String LinkHealthIDVisible="";  // Added for ABHA integration GHL-CRF-0657.1.
	String myhix_appl_YN = "N"; // Added for MYHIX integration ML-MMOH-CRF-0507.1.]
	String ndhm_appl_YN = "N"; // Added for NDHM integration GHL-CRF o657.1
	String employee_service_no="";//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023
	/*Below line added for this CRF GDOH-CRF-0029 [IN:048764]*/
	
	String regn_date="";
	String old_regn_datetime="";

	//**  variables for NewPatientRegistration.jsp & InsertEmergRegn.jsp files **//
	String dflt_patient_name ="";
	String a_family_name				= checkForNull(request.getParameter("a_family_name"));
	String a_first_name				= checkForNull(request.getParameter("a_first_name"));
	String a_second_name			= checkForNull(request.getParameter("a_second_name"));
	
	String a_third_name				= checkForNull(request.getParameter("a_third_name"));
	String a_name_prefix				= checkForNull(request.getParameter("a_name_prefix"));
	String a_name_suffix				= checkForNull(request.getParameter("a_name_suffix"));
	String a_name_prefix_loc_lang			= checkForNull(request.getParameter("a_name_prefix_loc_lang"));
	String a_first_name_loc_lang			= checkForNull(request.getParameter("a_first_name_loc_lang"));
	String a_second_name_loc_lang		= checkForNull(request.getParameter("a_second_name_loc_lang"));
	String a_third_name_loc_lang			= checkForNull(request.getParameter("a_third_name_loc_lang"));
	String a_family_name_loc_lang			= checkForNull(request.getParameter("a_family_name_loc_lang"));
	String a_name_suffix_loc_lang			= checkForNull(request.getParameter("a_name_suffix_loc_lang"));
	String a_patient_name_loc_lang		= checkForNull(request.getParameter("a_patient_name_loc_lang"));
	String nat_id_accept_alphanumeric_yn = checkForNull(request.getParameter("nat_id_accept_alphanumeric_yn"),"N");
	
		
		
	/*Below Variable Added for this CRF [RET-CRF-0011]*/
	String patient_cat_code	= checkForNull(request.getParameter("patient_cat_code"));
	String patient_cat_desc	= checkForNull(request.getParameter("patient_cat_desc"));	
    String language_id=checkForNull(request.getParameter("language_id")); //checkstyle violation
//	String language_desc=checkForNull(request.getParameter("language_desc"));
	
	//** end of variables for NewPatientRegistration.jsp & InsertEmergRegn.jsp files **//
	
	//** variables for NewPatientRegistration.jsp, InsertEmergRegn.jsp & InsertRapidRegn.jsp files **//

	String a_national_id_no	= checkForNull(request.getParameter("a_national_id_no"));
	String dfltPSG					= checkForNull(request.getParameter("dfltPSG"));
	String defaultSelect			= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

	//** end of variables for NewPatientRegistration.jsp & InsertEmergRegn.jsp & InsertRapidRegn.jsp files **//
	
	//**  variables for NewPatientRegistration.jsp file **//
	

	String AltdfltPSG					= "";		
	String a_oth_alt_id_type			= checkForNull(request.getParameter("a_oth_alt_id_type")); 
	String a_oth_alt_id_no			= checkForNull(request.getParameter("a_oth_alt_id_no"));
	String a_alt_id1_no					= checkForNull(request.getParameter("a_alt_id1_no"));
	String a_alt_id1_exp_date			= checkForNull(request.getParameter("a_alt_id1_exp_date"));
	String a_alt_id2_no				= checkForNull(request.getParameter("a_alt_id2_no"));
	String a_alt_id2_exp_date		= checkForNull(request.getParameter("a_alt_id2_exp_date"));
	String a_alt_id3_no				= checkForNull(request.getParameter("a_alt_id3_no"));
	String a_alt_id3_exp_date		= checkForNull(request.getParameter("a_alt_id3_exp_date"));
	String a_alt_id4_no				= checkForNull(request.getParameter("a_alt_id4_no"));
	String a_alt_id4_exp_date		= checkForNull(request.getParameter("a_alt_id4_exp_date"));
	String a_gender					= checkForNull(request.getParameter("a_gender"));
	String a_familyno					= checkForNull(request.getParameter("a_familyno"));
	String a_birth_place_desc		= checkForNull(request.getParameter("a_birth_place_desc"));
	String a_birth_place_code		= checkForNull(request.getParameter("a_birth_place_code"));
	String a_place_of_birth			= checkForNull(request.getParameter("a_place_of_birth"));
	String a_date_of_birth				= checkForNull(request.getParameter("a_date_of_birth"));
	String a_citizen_yn					= checkForNull(request.getParameter("a_citizen_yn"));
	
	String a_legal_yn					= checkForNull(request.getParameter("a_legal_yn"));
	String a_nationality_code			= checkForNull(request.getParameter("a_nationality_code"));
	String a_race_code				= checkForNull(request.getParameter("a_race_code"));
	String citizen_nationality_code	= checkForNull(request.getParameter("citizen_nationality_code"));
	
	
	//String relgn_code					= checkForNull(request.getParameter("relgn_code"));
	String flag							= checkForNull(request.getParameter("flag"), "N");
	// flag:  'Y' If Details unknown is 'unchecked' from AE 
	int		 Demoaddlcnt				= Integer.parseInt(checkForNull(request.getParameter("Demoaddlcnt"), "0"));
	//** end of variables for NewPatientRegistration.jsp file **//

	//**  variables for NewPatientRegistration.jsp & InsertRapidRegn.jsp files **//
	String alt_id1_disable			= "";
	String exeStrEmpId			= "";
	String altid1datelookup		= "";
	String altid2datelookup		= "";
	String altid3datelookup		= "";
	String altid4datelookup		= "";
	String rdonly					= ""; 
	String birth_place_desc		= "";
	String birth_place_code		= "";
	String birthenabledisable		= "";
	String birthenabledisable1	= "";
	String place_of_birth			= "";
	String disable_age			= "disabled";
	String disable_hours		= "disabled";
	String disable_time		= "";
	String disable_dob			= "";
	String check_age			= "";
	
	/*Below line added for this CRF GHL-CRF-0332 [IN:042060]*/
	String citizen_visibility = "visibility:hidden";
	String citizen_requied="N";
	
	//End GHL-CRF-0332 [IN:042060]
	
	//Added for this SCF BSP-SCF-0043
	 int useraccesscount=0;	
	//End BSP-SCF-0043



	String def_nat_desc						= checkForNull(request.getParameter("def_nat_desc"));
	String disabled_fields						= checkForNull(request.getParameter("disabled_fields"));
	String dflt_alt_id1_in_emp_id_yn			= checkForNull(request.getParameter("dflt_alt_id1_in_emp_id_yn"), "N");
	//String multi_birth							= checkForNull(request.getParameter("dflt_alt_id1_in_emp_id_yn"), "N");
	String nb_birth_place_code				= checkForNull(request.getParameter("nb_birth_place_code"));
	String nb_birth_place_desc				= checkForNull(request.getParameter("nb_birth_place_desc"));
	//** end of variables for ChangePatientSub.jsp file **//
	
	//**  variables for NewPatientRegistration.jsp & ChangePatientSub.jsp files **//
	String Site		= checkForNull(request.getParameter("Site"));
	String days		= checkForNull(request.getParameter("days"));
	String months	= checkForNull(request.getParameter("months"));
	String year		= checkForNull(request.getParameter("year"));
	//**  end of variables for NewPatientRegistration.jsp & ChangePatientSub.jsp files **//

	String PatInfflag = checkForNull(request.getParameter("PatInfflag"));
	String RapidPatInfflag = checkForNull(request.getParameter("RapidPatInfflag"));
	
	String appt_ref_no = checkForNull(request.getParameter("appt_ref_no")); 
	 
	String selectAttribute		= "";
	String selectAttribute1		= "";

	String disp_nat_man_gif		=	 "";
	String regpat_ser_val			=	 "";
	String MembershipType		=	 "";
	String birthPlace				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthPlace.label","common_labels");
	String nationality					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels");

	String downtime_regn_yn		= "N";/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724]*/

	String aadhaar_card_status = "", aadhaar_trans_id = "", aadhaar_id = ""; //aadhaar_card_status, aadhaar_trans_id Added by Sethu on 18/01/2018 for KDAH-CRF-0362 [IN063381]

	boolean oth_lang = false; 	
	Connection conn	= null;
	conn = ConnectionManager.getConnection(request); 
	Statement stmt_rh = conn.createStatement();	
	PreparedStatement pstmt=null;
	ResultSet rs_rh = null;
	/*Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
	HashMap hashdata					 = CommonBean.getSiteSpecificDetails(conn, "MP","NATSR_NONNATSR");
	String isNatIdMandatory				 = (String)hashdata.get("value1");
	String isClearNatIdValues			 = (String)hashdata.get("value2");
	/*Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] End*/
	boolean isValidateNatIDWithDOB		 = CommonBean.isSiteSpecific(conn, "MP","DOB_NATID_VALIDATION");/*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] */
	boolean disableRegnDate 		 = CommonBean.isSiteSpecific(conn, "MP","DISABLE_REGN_DATE");  //Added by Sangeetha for GDOH-CRF-0148
	boolean chkGenderWithNatID	= CommonBean.isSiteSpecific(conn, "MP","VALIDATE_GENDER_WITH_NATID"); //Added by Thamizh selvi on 24th Mar 2017 for GDOH-CRF-0145
			
	boolean isHeadFamilyPatient = CommonBean.isSiteSpecific(conn, "MP","CHECK_HEAD_FAMILY_PATID");// Added by KAMATCHI S for MO-CRF-20162 
	//Below line added for this CRF ML-MMOH-CRF-0778    
	//End this CRF ML-MMOH-CRF-0778
	boolean isNatIdOrAltId1MandRes	= CommonBean.isSiteSpecific(conn, "MP","MP_RESIDENCY_NAT_ALT1_ID_MAND");//Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128]
	boolean chkNatIdWithGender	= CommonBean.isSiteSpecific(conn, "MP","GENDER_DEFAULTED_NRIC");
	
	boolean chkPanValidate = CommonBean.isSiteSpecific(conn, "MP","PANCARD_VALIDATION"); // added by mujafar for KDAH-CRF-370.1 
	boolean chkForm60Allow = CommonBean.isSiteSpecific(conn, "MP","GENERATE_FORM_60");  // added for KDAH-CRF-347 start

	boolean chkAadhaarValidate = CommonBean.isSiteSpecific(conn, "MP","AADHAAR_PROFILE"); // Added by Sethu for KDAH-CRF-0362 
	Boolean isAutoPopulateNOKDOBAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","AUTO_POPULATE_NOK_DOB");//Added by Thamizh selvi on 1st Aug 2018 against ML-MMOH-CRF-1177
	
	//Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1
	boolean isEmployeePrivilegeAppl	= CommonBean.isSiteSpecific(conn, "MP","EMPLOYEE_PRIVILEGE"); 
	String uploaded_pat_yn = "N";
	String rdonly_temp = "";
	
	//Added by Suji Keerthi for ML-MMOH-CRF-1527 on June-22,2020
	boolean householdMonthlyIncome	= CommonBean.isSiteSpecific(conn, "MP","BMI_REG_PAT_CHNGES_RH101");
	

	/*Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750] Start*/
	boolean isNatIdOrAltIdMandVisaType	= CommonBean.isSiteSpecific(conn, "MP","MP_RES_VAL_VISA_TYPE");
	//isNatIdOrAltIdMandVisaType	= true;
	//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
	boolean isNatIdAltIdMandVisaType	= CommonBean.isSiteSpecific(conn, "MP","MP_VAL_VISA_TYPE");	
	//isNatIdAltIdMandVisaType	= true;
	/*Added by SureshM on 16th Jan 2020 NMC-JD-CRF-0038 [IN:071904] Start*/
	boolean isNuhdeekIDAppl	= CommonBean.isSiteSpecific(conn, "MP","NUHDEEK_ID_INTEGRATION");
	String nuhdeek_ready_yn = "N";
	System.err.println("isNuhdeekIDAppl-->"+isNuhdeekIDAppl);
	/* added by lakshmanan for MO-CRF-20183.2 US002 start*/
	
	String empSrvOnblur="";//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023
	/*added by lakshmanan for MO-CRF-20183.2 US002 end*/
	HashMap ResultParamHashMap = new HashMap();
	HashMap sqlColumns = new HashMap();
	sqlColumns.put("age_not_consider_natid_altid","S");
	sqlColumns.put("dft_national_id","S");//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
	sqlColumns.put("biometric_authentication_yn","S");//Maheshwaran K added for AAKH-CRF-0175 as on 13-09-2023
	String whereClause	= "where module_id='MP'";
	ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PARAM",conn);
	String age_not_consider_natid_altid				 = checkForNull((String) ResultParamHashMap.get("age_not_consider_natid_altid"),"0");
	String dft_national_id= checkForNull((String) ResultParamHashMap.get("dft_national_id"),"");//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
	String biometric_authentication_yn= checkForNull((String) ResultParamHashMap.get("biometric_authentication_yn"),"");//Maheshwaran K added for AAKH-CRF-0175 as on 13-09-2023

	/*Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750] End*/
	int form60_value_chk = 0;
	if(chkForm60Allow)
	{ int count = 0;
		if(CalledFromFunction.equals("ChangePatDtls") && !patient_id.equals(""))
		{      
			String pat_form60_chk_status = "";
			pat_form60_chk_status=eMP.MPForm60Bean.getForm60StatusForPatient(conn,patient_id);
			if(!pat_form60_chk_status.equals(""))
			{
			String[] retval = pat_form60_chk_status.split("\\##");
			count = Integer.parseInt(retval[1]);	
			form60_value_chk = count;
			}
		}
	} 
	// added by mujafar for KDAH-CRF-347	 end
	//Data added for the Incident no : 34531 as on 10/08/2012
	//String pat_lang_id=""; //commented for checkstyle voilation by  Munisekhar
	//Statement lang_stmt=null;//commented for checkstyle voilation by  Munisekhar
	//ResultSet lang_rest=null;//commented for checkstyle voilation by  Munisekhar
	//End
	HashMap hash_Map	= new HashMap();
	HashMap hash_Map1	= new HashMap();
	HashMap hash_Map2	= new HashMap();
	HashMap hash_Map3	= new HashMap();
	HashMap hash_Map4	= new HashMap();
	HashMap hash_Map5	= new HashMap();
	HashMap hash_Map6	= new HashMap();
	HashMap hash_Map7	= new HashMap();
	//HashMap hash_Map8	= new HashMap(); //commented for checkstyle voilation by  Munisekhar

//	ArrayList arrayList		= new ArrayList();
	ArrayList array_List1	= new ArrayList();
	ArrayList array_List2	= new ArrayList();
	
	array_List1	= eMP.ChangePatientDetails.getResultRows(conn,"mp_alternate_id_type",p);
	hash_Map	= eMP.ChangePatientDetails.getSetupData(facility,group, conn,p);//modified for the incident 34901
	int Alt_Id1_length	=	 Integer.parseInt((String) hash_Map.get("Alt_Id1_length"));
	int Alt_Id2_length	=	 Integer.parseInt((String) hash_Map.get("Alt_Id2_length"));
	int Alt_Id3_length	=	 Integer.parseInt((String) hash_Map.get("Alt_Id3_length"));
	int Alt_Id4_length	=	 Integer.parseInt((String) hash_Map.get("Alt_Id4_length"));
	dflt_patient_name =checkForNull((String) hash_Map.get("dflt_patient_name"));
	String alt_id1_len_validation_yn	=		checkForNull((String) hash_Map.get("alt_id1_len_validation_yn"));	
	String alt_id2_len_validation_yn	=		checkForNull((String) hash_Map.get("alt_id2_len_validation_yn"));
	String alt_id3_len_validation_yn	=		checkForNull((String) hash_Map.get("alt_id3_len_validation_yn"));	
	String alt_id4_len_validation_yn	=		checkForNull((String) hash_Map.get("alt_id4_len_validation_yn"));
	String disp_nat_id_length			=		checkForNull((String) hash_Map.get("nat_id_length"));
	String nat_id_chk_len					=		checkForNull((String)hash_Map.get("nat_id_chk_len"));
	String nat_id_check_digit_id		=		checkForNull((String)hash_Map.get("nat_id_check_digit_id"));
	
	String alt_id1_accept_alphanumeric_yn  =	 checkForNull((String)hash_Map.get("alt_id1_accept_alphanumeric_yn"));
	String alt_id1_chng_allowed_yn  =	 checkForNull((String)hash_Map.get("alt_id1_chng_allowed_yn"));

	/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start */
	
	String alt_id2_accept_alphanumeric_yn			= checkForNull((String) hash_Map.get("alt_id2_accept_alphanumeric_yn"),"N");
	String alt_id3_accept_alphanumeric_yn			= checkForNull((String) hash_Map.get("alt_id3_accept_alphanumeric_yn"),"N");
	String alt_id4_accept_alphanumeric_yn			= checkForNull((String) hash_Map.get("alt_id4_accept_alphanumeric_yn"),"N");

	/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End */
	/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 30th July 2108 Start */
	
	String alt_id1_alphanum_validate_yn			= checkForNull((String) hash_Map.get("alt_id1_alphanum_validate_yn"),"N");
	String alt_id2_alphanum_validate_yn			= checkForNull((String) hash_Map.get("alt_id2_alphanum_validate_yn"),"N");
	String alt_id3_alphanum_validate_yn			= checkForNull((String) hash_Map.get("alt_id3_alphanum_validate_yn"),"N");
	String alt_id4_alphanum_validate_yn			= checkForNull((String) hash_Map.get("alt_id4_alphanum_validate_yn"),"N");
	/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 30th July 2108 End */
	/*below line added for this CRF GHL-CRF-0332 [IN:042060]*/
	boolean isAltId1ManNonCtz=eOP.QMSInterface.isSiteSpecific(conn,"MP","ALT_ID1_MAN_NON_CTZN");
	//End CRF GHL-CRF-0332 [IN:042060]
	
	String pat_name_loc_lang = "";
	String pat_name_loc_lang_long = "";
	String alt_id1_exp_date = "";
	String alt_id2_exp_date = "";
	String alt_id3_exp_date = "";
	String alt_id4_exp_date = "";
	String nat_id_onKeyPress = "";

	String race_required_yn		= checkForNull((String)hash_Map.get("race_required_yn"),"N");	
	String religion_reqd_yn     = checkForNull((String)hash_Map.get("religion_reqd_yn"),"N"); //Added by Mano for ML-MMOH-CRF-0736
	String display_new_born_age_in_hrs	=	checkForNull((String)hash_Map.get("display_new_born_age_in_hrs"));
	String single_patient_numbering_yn	=	checkForNull((String)hash_Map.get("single_patient_numbering_yn"),"N");
	String race_visibility = "";
	String religion_visibility = ""; //Added by Mano for ML-MMOH-CRF-0736

	String patbloodgrp = "";
	String RHfactor = "";  	
	String gcc="N";//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022


	//for smart card
	pstmt = conn.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");

	rs_rh = pstmt.executeQuery();	


	if(rs_rh!=null && rs_rh.next())
	{
	Smartcard_path=rs_rh.getString("VALUE_1");
	function_name=rs_rh.getString("VALUE_2");   // alkhaleej smart card

	}		


	if(pstmt!=null)
	pstmt.close();
	if(rs_rh!=null)
	rs_rh.close();
	//for smart card

	//for Hijri MMS-QH-CRF-0145
	 
   Boolean hijirisitespecifApplicable = CommonBean.isSiteSpecific(conn, "MP","CAL_HIJ_APP");
   if(hijirisitespecifApplicable)  hij_appl_YN="Y";

	myhix_appl_YN 	= CommonBean.getMyHixApplicable(conn); //added for MYHIX integration ML-MMOH-CRF-0507.1.
	ndhm_appl_YN 	= getNDHMApplicable(conn); //added for NDHM integration GHL-CRF-0657.1 
	System.out.println("ndhm_appl_YN============="+ndhm_appl_YN);
	
	/*Added by Rameswar on 24/11/2016 for BSP-SCF-0021*/
	ArrayList column_name=new ArrayList();
	Boolean alt_id2_specialchar_validation =true; 
	Boolean alt_id3_specialchar_validation =true; 
	Boolean alt_id4_specialchar_validation =true; 
	String field_name ="";
	column_name  = CommonBean.getFunctionFieldRestriction(conn, "MP","ALT_ID_DATA_NO_VALIDATE","MP_PARAM","Y","Y"); 
					Iterator itr = column_name.iterator();
					while(itr.hasNext()){	
					field_name=(String)itr.next();
  					if(field_name.equals("ALT_ID2"))
  						alt_id2_specialchar_validation=false;
  					if(field_name.equals("ALT_ID3"))
  						alt_id3_specialchar_validation=false;
  					if(field_name.equals("ALT_ID4"))
  						alt_id4_specialchar_validation=false;
    					}
	/*Added by Rameswar on 24/11/2016 for BSP-SCF-0021*/
	/*pstmt = conn.prepareStatement("select decode(count(*),'1','Y','N') CAL_HIJ_APP  from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='CAL_HIJ_APP' and a.SITE_ID=B.CUSTOMER_ID");

	rs_rh = pstmt.executeQuery();	


	if(rs_rh!=null && rs_rh.next())
	{
	hij_appl_YN=rs_rh.getString("CAL_HIJ_APP");
	

	}		


	if(pstmt!=null)
	pstmt.close();
	if(rs_rh!=null)
	rs_rh.close();*/
	/* Added for GDOH -CRF-0029 by Dharma on 11th sep 2014 Start*/
	String visit_adm_date_time = "";
	if(CalledFromFunction.equals("ChangePatDtls") && !patient_id.equals("")){
	   	String sqlString="select TO_CHAR(min(VISIT_ADM_DATE_TIME) ,'dd/mm/yyyy hh24:mi:ss') VISIT_ADM_DATE_TIME from pr_encounter where patient_id='"+patient_id+"' and (ADT_STATUS!='09' or ADT_STATUS is null) and (VISIT_STATUS!='99' or VISIT_STATUS is null)";
		
		pstmt = conn.prepareStatement(sqlString);
		rs_rh = pstmt.executeQuery();	
		if(rs_rh!=null && rs_rh.next())	{
			visit_adm_date_time= checkForNull(rs_rh.getString("VISIT_ADM_DATE_TIME"));
			visit_adm_date_time=DateUtils.convertDate(visit_adm_date_time,"DMYHMS","en",localeName);
		}
		if(pstmt!=null)pstmt.close();
		if(rs_rh!=null)rs_rh.close();
		
	}
	/* Added for GDOH -CRF-0029 by Dharma on 11th sep 2014 End*/

/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] Start*/
String sqlDate="select to_char(sysdate,'dd/mm/yyyy HH24:mi') as regn_date from dual";
		String dbDate="";
		pstmt = conn.prepareStatement(sqlDate);
		rs_rh = pstmt.executeQuery();	
		if(rs_rh!=null && rs_rh.next())	{
			dbDate= checkForNull(rs_rh.getString("regn_date"));
		
		}
		if(pstmt!=null)pstmt.close();
		if(rs_rh!=null)rs_rh.close();
/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] End*/


	//for Hijri MMS-QH-CRF-0145
	
	if(CalledFromFunction.equals("ChangePatDtls") || PatInfflag.equals("Y") || RapidPatInfflag.equals("Y")) {
		hash_Map1 = eMP.ChangePatientDetails.getPatientData(patient_id, conn,p);	
		hijiri_b_date=checkForNull((String) hash_Map1.get("hijri_birth_date"));
		downtime_regn_yn=checkForNull((String) hash_Map1.get("downtime_regn_yn"));/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724] */
	
		MembershipType		= checkForNull((String) hash_Map1.get("MembershipType"));
		pat_name_loc_lang    = checkForNull((String)hash_Map1.get("patient_name_loc_lang"));
		pat_name_loc_lang_long    = checkForNull((String)hash_Map1.get("patient_long_name_loc_lang"));
		alt_id1_exp_date = checkForNull((String)hash_Map1.get("alt_id1_exp_date"));
		alt_id2_exp_date = checkForNull((String)hash_Map1.get("alt_id2_exp_date"));
		alt_id3_exp_date = checkForNull((String)hash_Map1.get("alt_id3_exp_date"));
		alt_id4_exp_date = checkForNull((String)hash_Map1.get("alt_id4_exp_date"));
		if ( !localeName.equals("en") )
		{ 
			if (!alt_id1_exp_date.equals(""))
					alt_id1_exp_date= DateUtils.convertDate(alt_id1_exp_date,"DMY","en",localeName);
			if (!alt_id2_exp_date.equals(""))
					alt_id2_exp_date= DateUtils.convertDate(alt_id2_exp_date,"DMY","en",localeName);
			if (!alt_id3_exp_date.equals(""))
					alt_id3_exp_date= DateUtils.convertDate(alt_id3_exp_date,"DMY","en",localeName);
			if (!alt_id4_exp_date.equals(""))
					alt_id4_exp_date= DateUtils.convertDate(alt_id4_exp_date,"DMY","en",localeName);
		}

		patbloodgrp	= checkForNull((String)hash_Map1.get("blood_grp"),"");
		RHfactor	= checkForNull((String)hash_Map1.get("rh_factor"),"");
		gcc	= checkForNull((String)hash_Map1.get("gcc"),"N");//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
		/*Below line added for this CRF GHL-CRF-0332 [IN:042060]*/
		if(((String)hash_Map1.get("citizen_yn")).equals("N") && isAltId1ManNonCtz){
		   citizen_visibility="visibility:visible";
           citizen_requied="Y";
		   }

	}
		/*Below line added for this CRF  GDOH-CRF-0029 [IN:048764]*/				
		regn_date=checkForNull((String)hash_Map1.get("regn_date"));	
        old_regn_datetime=regn_date;	
		java.util.Date dNow = new java.util.Date();
        java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");     
		
		//if(regn_date.equals(""))regn_date=ft.format(dNow);
		/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] */	
		if(regn_date.equals(""))regn_date=dbDate;	
        
		regn_date=DateUtils.convertDate(regn_date,"DMYHM","en",localeName);//Added by Rameswar on 29-Sep-15 for Leap Year issue
		//End GDOH-CRF-0029 [IN:048764]
		employee_service_no= checkForNull((String) hash_Map1.get("employee_service_no"));//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023
	String dflt_language_id			=	 checkForNull((String) hash_Map.get("dflt_language_id"));
	String dflt_relgn_code		=	 checkForNull((String) hash_Map.get("dflt_relgn_code"));

	String Accept_oth_alt_id_yn			=	 checkForNull((String) hash_Map.get("Accept_oth_alt_id_yn"));
	String accept_national_id_no_yn		=	 checkForNull((String) hash_Map.get("accept_national_id_no_yn"), "N");
	String family_org_id_accept_yn		=	 checkForNull((String) hash_Map.get("family_org_id_accept_yn"), "N");
	String entitlement_by_pat_cat_yn	=	 checkForNull((String) hash_Map.get("entitlement_by_pat_cat_yn"), "N");
	String pat_category_reqd_yn      	=	 checkForNull((String) hash_Map.get("pat_category_reqd_yn"), "N"); //Added by Suji keerthi on 21-Nov-2019 for KDAH-CRF-0522
	
	String id_change_allowed_for_series=	 checkForNull((String) hash_Map.get("id_change_allowed_for_series"));
	//String change_national_id_no_yn=	 checkForNull((String) hash_Map.get("change_national_id_no_yn")); //check style violation
	String nat_id_reqd_all_series			=	 checkForNull((String)hash_Map.get("nat_id_reqd_all_series"), "N");
	String nat_id_prompt						=	 checkForNull((String)hash_Map.get("nat_id_prompt"), "N");
	String invoke_routine						=	 checkForNull((String)hash_Map.get("invoke_routine"));
	String nat_data_source_id				=	 checkForNull((String)hash_Map.get("nat_data_source_id"));
	String ext_system_interface_yn			=	 checkForNull((String)hash_Map.get("ext_system_interface_yn"));
	String Alt_Id1_Type							=	 checkForNull((String)hash_Map.get("Alt_Id1_Type"));
	String Alt_Id2_Type							=	 checkForNull((String)hash_Map.get("Alt_Id2_Type"));
	String Alt_Id3_Type							=	 checkForNull((String)hash_Map.get("Alt_Id3_Type"));
	String Alt_Id4_Type							=	 checkForNull((String)hash_Map.get("Alt_Id4_Type"));
	String Family_No_Link_Yn				=	 checkForNull((String)hash_Map.get("Family_No_Link_Yn"));
	String pat_name_in_loc_lang_reqd_yn= checkForNull((String)hash_Map.get("pat_name_in_loc_lang_reqd_yn"),"N");
	String pat_name_as_multipart_yn   =	checkForNull((String)hash_Map.get("pat_name_as_multipart_yn"),"N");
	String names_in_oth_lang_yn			=	 checkForNull((String)hash_Map.get("names_in_oth_lang_yn"),"N");
	String name_pfx_reqd_for_org_mem_yn		= checkForNull((String)hash_Map.get("name_pfx_reqd_for_org_mem_yn"),"N");
	String 	nat_id_expiry_date = checkForNull((String)hash_Map1.get("nat_id_expiry_date"),"");
	if(CalledFromFunction.equals("ChangePatDtls")) {
		pat_name_in_loc_lang_reqd_yn = checkForNull((String)hash_Map1.get("pat_name_in_loc_lang_reqd_yn"),"N");
	}
	
	boolean alt_id1_exp_date_show = ((String) hash_Map.get("alt_id1_exp_date_accept_yn")).equalsIgnoreCase("Y") ? true : false;
	boolean alt_id2_exp_date_show = ((String) hash_Map.get("alt_id2_exp_date_accept_yn")).equalsIgnoreCase("Y") ? true : false;
	boolean alt_id3_exp_date_show = ((String) hash_Map.get("alt_id3_exp_date_accept_yn")).equalsIgnoreCase("Y") ? true : false;
	boolean alt_id4_exp_date_show = ((String) hash_Map.get("alt_id4_exp_date_accept_yn")).equalsIgnoreCase("Y") ? true : false;
		 
	///*** Start of National ID, Other Alternate ID type and number and all alternate ID type's ***///

	/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724] Start*/
	if(checkForNull((String)hash_Map1.get("regn_date")).equals("") && downtime_regn_yn.equals("Y") && CalledFromFunction.equals("ChangePatDtls")){
		hash_Map1.put("sex","");
		hash_Map1.put("p_age","");
		hash_Map1.put("date_of_birth","");
		hash_Map1.put("calculated_age_yn","N");
		hash_Map1.put("patient_name","");
	}
	/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724] End*/

	/*aadhaar_card_status, aadhaar_trans_id Added by Sethu on 18/01/2018 for KDAH-CRF-0362 [IN063381]*/
	aadhaar_card_status	= checkForNull((String)hash_Map1.get("aadhaar_card_status"),"");
	aadhaar_trans_id	= checkForNull((String)hash_Map1.get("aadhaar_trans_id"),"");

	if(CalledFromFunction.equals("ChangePatDtls")) { 
		aadhaar_id = checkForNull((String)hash_Map1.get("national_id_no"),"");
	} else if(!a_national_id_no.equals("")) {  
		aadhaar_id = a_national_id_no;
	} 
	//Added by santhosh for TH-KW-CRF-0019.1
	String blood_group = checkForNull(request.getParameter("blood_group"));
	String nat_id_exp_date = checkForNull(request.getParameter("nat_id_exp_date"));
	//End
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isNatIdMandatory));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(isClearNatIdValues));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(isNatIdOrAltId1MandRes));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(isNatIdOrAltIdMandVisaType));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(isNatIdAltIdMandVisaType));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dft_national_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(biometric_authentication_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(isNuhdeekIDAppl));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(age_not_consider_natid_altid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(isValidateNatIDWithDOB));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(chkGenderWithNatID));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(chkPanValidate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chkForm60Allow));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(form60_value_chk));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isAutoPopulateNOKDOBAppl));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(chkNatIdWithGender));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Smartcard_path));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nat_id_accept_alphanumeric_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(display_new_born_age_in_hrs));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(name_pfx_reqd_for_org_mem_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dflt_patient_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(birthPlace));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)hash_Map1.get("combined_rel_level_code")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((String)hash_Map1.get("combined_rel_level_desc")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(isAltId1ManNonCtz));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(old_regn_datetime));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(id_change_allowed_for_series));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(checkForNull((String)hash_Map1.get("id_type"))));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(checkForNull((String)hash_Map1.get("national_id_no"))));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(chkAadhaarValidate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(uploaded_pat_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(pat_category_reqd_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(employee_service_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ndhm_appl_YN));
            _bw.write(_wl_block48Bytes, _wl_block48);

		if (localeName.equals("th"))
		{
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(defaultSelect));
            _bw.write(_wl_block52Bytes, _wl_block52);

			/*Modified by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
			String onChangeNatID	= "onChange='";
			if(!CalledFromFunction.equals("ChangePatDtls")) 
			 {
 				regpat_ser_val = "checkPatGenYN();";
			 } else if(CalledFromFunction.equals("ChangePatDtls")) {
				regpat_ser_val = "changeBLSuccess();"; 	
			 }
			if(isNatIdMandatory.equals("Y")){
				 if(regpat_ser_val.equals("")){
					regpat_ser_val = "chkNatlIdMandatory(1);"; // Modified by Dharma on 10th Oct 2017 against GDOH-SCF-0274 [IN:065413]
				 }else{
					 regpat_ser_val	= "chkNatlIdMandatory(1);"+regpat_ser_val+""; // Modified by Dharma on 10th Oct 2017 against GDOH-SCF-0274 [IN:065413]
				 }
			}
			regpat_ser_val = onChangeNatID+regpat_ser_val+"'";
			/*Modified by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] End*/
			
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(regpat_ser_val));
            _bw.write(_wl_block55Bytes, _wl_block55);
  String selct = "" ;
				
				 if(!CalledFromFunction.equals("ChangePatDtls")) {
					 if(CalledFromFunction.equals("PatientRegistration")) {
						 
						array_List2 = eMP.ChangePatientDetails.getPatSerGrpCode(conn,group,Site,facility,"PatientRegistration",p);
						flag = "Y";
					 }else if(CalledFromFunction.equals("RapidReg")) {
										

						array_List2 = eMP.ChangePatientDetails.getPatSerGrpCode(conn,group,Site,facility,"RapidReg",p);
						flag = "Y";
						 
					}
					if(CalledFromFunction.equals("EmergencyReg")) {
						/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
						if(applicableFor.equals("MO_BID_REGN"))
							array_List2 = eMP.ChangePatientDetails.getPatSerGrpCode(conn,group,Site,facility,"BID_REGN",p);
						else if(applicableFor.equals("MO_EBP_REGN"))
							array_List2 = eMP.ChangePatientDetails.getPatSerGrpCode(conn,group,Site,facility,"EBP_REGN",p);
						else/*End*/
							array_List2 = eMP.ChangePatientDetails.getPatSerGrpCode(conn,group,Site,facility,"EmergencyReg",p);
					 }
 					int k = 1; // 0th element is 'select' option. So k starts from 1
					
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

						
					for(int i=0;i<array_List2.size();i+=5) { 
						if(flag.equals("Y")) {	//For normal registartion
							if(((String)array_List2.get(i)).equals(dfltPSG))
							{
								selct = "selected";
								pat_name_in_loc_lang_reqd_yn = (String)array_List2.get(i+3);
							}
							else selct = "";
						}	 else  if(CalledFromFunction.equals("EmergencyReg")) { //For emergency registartion
								
								/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
								if(applicableFor.equals("MO_BID_REGN") || applicableFor.equals("MO_EBP_REGN")){
									selct = "selected";
									pat_name_in_loc_lang_reqd_yn = (String)array_List2.get(i);
								}
								else if(((String)array_List2.get(i)).equals(emeg_pat_ser_grp))
								{
									selct = "selected";
									pat_name_in_loc_lang_reqd_yn = (String)array_List2.get(i+3);
								}
								else selct = "";
							//Added by Ashwin K for AAKH-CRF-0150	
							if(((String)array_List2.get(i)).equals(dfltPSG))
							{
								selct = "selected";
								pat_name_in_loc_lang_reqd_yn = (String)array_List2.get(i+3);
							}
							//Ended by Ashwin K for AAKH-CRF-0150
								/*End*/
						}	if(((String) array_List2.get(i+2)).equals("A")) 
							AltdfltPSG = (String) array_List2.get(i); 							
						
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)array_List2.get(i)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(selct));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((String)array_List2.get(i+1)));
            _bw.write(_wl_block61Bytes, _wl_block61);

						out.println("<script>") ;
						out.println("def_series["+k+"] = \""+(String)array_List2.get(i)+"`"+(String)array_List2.get(i+1)+"\";");
						out.println("pat_sergrp_id_types["+k+"] = \""+(String)array_List2.get(i+2)+"\";");
						out.println("pat_sergrp_reqd_yn["+k+"] = \""+(String)array_List2.get(i+4)+"\";");
						out.println("pat_name_in_loc_lang["+k+"] = \""+(String)array_List2.get(i+3)+"\";");
						k++;
						out.println("</script>");
					}
				}else{ 
					if(single_patient_numbering_yn.equals("Y"))	{
						String pat_ser_code = (String)hash_Map1.get("pat_ser_grp_code");
						//int k = 1;
						int k = 0;//Modified by Dharma on Apr 7th 2015 against HSA-CRF-0191 [IN:049772]
						rs_rh = stmt_rh.executeQuery("SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+localeName+"' AND GEN_PID_USING_ALT_ID1_RULE_YN='N' and (pat_ser_grp_code='"+pat_ser_code+"' OR ASSOCIATED_PAT_SER_GRP_CODE='"+pat_ser_code+"' OR associated_pat_ser_grp_code in (Select ASSOCIATED_PAT_SER_GRP_CODE FROM MP_PAT_SER_GRP WHERE PAT_SER_GRP_CODE='"+pat_ser_code+"') OR pat_ser_grp_code in (Select ASSOCIATED_PAT_SER_GRP_CODE FROM MP_PAT_SER_GRP WHERE PAT_SER_GRP_CODE='"+pat_ser_code+"'))");
						
						while (rs_rh!=null && rs_rh.next()) {
							String pat_ser = (String)rs_rh.getString("pat_ser_grp_code");
							if(pat_ser.equals(pat_ser_code)) {
							
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)rs_rh.getString("pat_ser_grp_code")));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)rs_rh.getString("short_desc")));
            _bw.write(_wl_block64Bytes, _wl_block64);

							} else {

							
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)rs_rh.getString("pat_ser_grp_code")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf((String)rs_rh.getString("short_desc")));
            _bw.write(_wl_block66Bytes, _wl_block66);

							}
						out.println("<script>") ;
						out.println("def_series["+k+"] = \""+rs_rh.getString("pat_ser_grp_code")+"`"+(String)rs_rh.getString("short_desc")+"\";");
						out.println("pat_sergrp_id_types["+k+"] = \""+(String)rs_rh.getString("id_type")+"\";");
						out.println("pat_sergrp_reqd_yn["+k+"] = \""+(String)rs_rh.getString("prefix_reqd_yn")+"\";");
						out.println("pat_name_in_loc_lang["+k+"] = \""+(String)rs_rh.getString("pat_name_in_loc_lang_reqd_yn")+"\";");
						k++;
						out.println("</script>");

						}
					} else {

					
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf((String)hash_Map1.get("pat_ser_grp_code")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf((String)hash_Map1.get("pat_ser_grp_desc")));
            _bw.write(_wl_block68Bytes, _wl_block68);
 
						out.println("<script>pat_sergrp_id_types[0] = \""+(String)hash_Map1.get("id_type")+"\";</script>");
					}
				}
            _bw.write(_wl_block69Bytes, _wl_block69);

/*END : Patient Series*/	
				if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
if(CalledFromFunction.equals("PatientRegistration")) { 
					
				hash_Map5 = eMP.ChangePatientDetails.getFacilityDesc(conn, facility ,p);
					
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(checkForNull((String)hash_Map5.get("pref_facility_desc"))));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(checkForNull((String)hash_Map5.get("pref_facility_id"))));
            _bw.write(_wl_block74Bytes, _wl_block74);
 }else if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hash_Map1.get("pref_facility_name")));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)hash_Map1.get("pref_facility_id")));
            _bw.write(_wl_block74Bytes, _wl_block74);
 } 
            _bw.write(_wl_block75Bytes, _wl_block75);
	if(CalledFromFunction.equals("ChangePatDtls")) {
					if(((String)hash_Map1.get("deceased_yn")).equals("Y")) { 
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

						String patient_deceased_yn = checkForNull((String)hash_Map1.get("deceased_yn"),"N");
						String patient_deceased_date = checkForNull((String)hash_Map1.get("deceased_date"));

						//code added for 21090

						if (!localeName.equals("en")) {
						patient_deceased_date = DateUtils.convertDate(patient_deceased_date,"DMYHMS","en",localeName); 
						}
					
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_deceased_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(patient_deceased_date));
            _bw.write(_wl_block80Bytes, _wl_block80);
}
					}
            _bw.write(_wl_block81Bytes, _wl_block81);

				} else { 
            _bw.write(_wl_block82Bytes, _wl_block82);
 }
		//		arrayList.clear();
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(pat_name_in_loc_lang_reqd_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(ext_system_interface_yn));
            _bw.write(_wl_block85Bytes, _wl_block85);
 if(accept_national_id_no_yn.equals("Y")) { 
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block87Bytes, _wl_block87);
  
				if (nat_id_reqd_all_series.equals("Y"))
						disp_nat_man_gif = "style='visibility:visible;'";
				else 
						disp_nat_man_gif = "style='visibility:hidden;'";

				if(CalledFromFunction.equals("ChangePatDtls")) { 
                        	
                        						
					if (id_change_allowed_for_series.equals("A") || (checkForNull((String)hash_Map1.get("id_type"))).equals(id_change_allowed_for_series)) {
						useraccesscount	= eMP.ChangePatientDetails.getMRAccessRights(facility, conn,p);					
					                         						
					
						if(useraccesscount==0 && (!((String)hash_Map1.get("national_id_no")).equals(""))){// Modified By dharma on July 3rd 2015 against PMG2015-CRF-HSA-0002 [IN:055774]
							rdonly = "disabled";	
						}else{
							rdonly = "";
						}
					} else if (((String)hash_Map1.get("national_id_no")).equals("")) {  
						rdonly = "disabled";//included for the CRF - BRU-HIMS-CRF 283 - Coding UT - 34833
						if(!((String)hash_Map1.get("nationality")).equals(def_nat_desc)) { //condition modified for the CRF - BRU-HIMS-CRF 283
							nat_id_reqd_all_series = "N";
							disp_nat_man_gif = "style='visibility:hidden;'";
						}		
					} else {
						rdonly = "disabled";
					}
					
					
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(useraccesscount));
            _bw.write(_wl_block89Bytes, _wl_block89);

					
				} else rdonly = "";
				
				
				if(disabled_fields.equals("disabled")) {
					nat_id_reqd_all_series = "N";
					disp_nat_man_gif = "style='visibility:hidden;'";
				}
				
				out.println("<input type='text' name='national_id_no' id='national_id_no' id='national_id_no1'  maxlength='"+disp_nat_id_length+"' size='"+disp_nat_id_length+"' "); 
				if(CalledFromFunction.equals("ChangePatDtls")) { 
				//Added if condition for AAKH-CRF-0168 Maheshwaran K
				if(dft_national_id.equals(checkForNull((String)hash_Map1.get("national_id_no_dft"))) && isNatIdAltIdMandVisaType)
					{
					out.println(" value='"+checkForNull((String)hash_Map1.get("national_id_no_dft"))+"' ");	
					}
					else {
					out.println(" value='"+checkForNull((String)hash_Map1.get("national_id_no"))+"' ");	
					}
					
				} else if(!a_national_id_no.equals("")) {  
					out.println(" value='"+a_national_id_no+"'  ");
				} 
	
    if(nat_id_accept_alphanumeric_yn.equals("Y"))
	{
		nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
	}
	else
	{
		if(nat_id_check_digit_id.equals("M11"))
			nat_id_onKeyPress = "CheckForCharsNatID(event);";
		else
			nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
	}
	/*Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
	String onBlurFunc	= "";
	if(isNatIdMandatory.equals("Y")){
		onBlurFunc	= "chkNatlIdMandatory();";
	}
	/*Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] End*/
	
	/*Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1*/
	String onBlurChkEmpPriv = "";
	rdonly_temp = rdonly;
	
	if(isEmployeePrivilegeAppl)
	{
		onBlurChkEmpPriv = "chkEmployeePrivilege();";
	
		if(CalledFromFunction.equals("ChangePatDtls")) { 
			
			String National_ID = checkForNull((String)hash_Map1.get("national_id_no"));
			
			if(!National_ID.equals(""))
			{
				JSONObject valJSONObj = new JSONObject();
				valJSONObj = eMP.MPCommonBean.getUploadedPatYN(conn, patient_id, National_ID);
				String disable_natid_yn = (String)valJSONObj.get("uploaded_pat_yn");
				
				if(disable_natid_yn.equals("Y"))
				{
					rdonly = "disabled"; 
				}
			}
		}
	}
	/*End TBMC-CRF-0010.1*/

	out.println("onkeypress=\"return "+nat_id_onKeyPress+"\"  onBlur=\"makeValidString(this);"+onBlurFunc+"validateNationality(this,'"+Site+"','"+(String)hash_Map.get("nat_id_pat_ser_grp")+"','"+invoke_routine+"','"+nat_data_source_id+"', '"+nat_id_check_digit_id+"','"+nat_id_chk_len+"','Y','N');"+onBlurChkEmpPriv+"\" "+rdonly+">");

	rdonly = rdonly_temp; //Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1

				if( ext_system_interface_yn.equals("Y") && nat_id_check_digit_id.equals("M11") && nat_data_source_id.equals("") ) {
					if(CalledFromFunction.equals("ChangePatDtls") || 
						CalledFromFunction.equals("PatientRegistration")) {
				
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block92Bytes, _wl_block92);

					}
				}
				
				/*
				if( ext_system_interface_yn.equals("N") && nat_id_check_digit_id.equals("M11_10") && nat_data_source_id.equals("") ) { }

				if( ext_system_interface_yn.equals("N") && nat_id_check_digit_id.equals("M11_5") && nat_data_source_id.equals("") ) { }

				if( ext_system_interface_yn.equals("N") && nat_id_check_digit_id.equals("") && nat_data_source_id.equals("NRIC") ) { }
				*/

				if( ext_system_interface_yn.equals("Y") && nat_id_check_digit_id.equals("") && nat_data_source_id.equals("NRIC") ) { 
					MdisEnb = "";
					if(CalledFromFunction.equals("ChangePatDtls")) {
						if(rdonly.equals("disabled")) MdisEnb = "disabled";
						else MdisEnb = "";
						ClickVal = "ReadDF1_onclick('C','NC');";
					} else if(CalledFromFunction.equals("PatientRegistration")) {
						ClickVal = "ReadDF1_onclick('P','NC');";
					} else if(CalledFromFunction.equals("EmergencyReg")) {
						ClickVal = "ReadDF1_onclick('E','NC');";
					} else if(CalledFromFunction.equals("RapidReg")) {
						ClickVal = "ReadDF1_onclick('R','NC');";
					}
					
            _bw.write(_wl_block93Bytes, _wl_block93);
 // Added by lakshmanan MOHE-CRF-0164.1
					String m_btn_display="button";
					if(function_name.equals("07")){ 
						m_btn_display="hidden";
					} // end MOHE-CRF-0164.1
					
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(m_btn_display));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ClickVal));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(MdisEnb));
            _bw.write(_wl_block96Bytes, _wl_block96);
if(function_name.equals("01")){
            _bw.write(_wl_block97Bytes, _wl_block97);
}
				}
				//ADDED BY PRITHIVI AADHAR CARD BUTTON SITE SPECIFIC KDAH-CRF-0362 14/04/2017
				String eKYCBtnDisabled = "", chkEKYCValidate = "N";
				boolean isAADHAAREnabledYN = false; 
			    String profileIdExists = InterfaceUtil.isInterfaceProfileExisting("AADHAARPROF1");
				if("Y".equalsIgnoreCase(profileIdExists) && (CalledFromFunction.equals("ChangePatDtls") || 
					CalledFromFunction.equals("PatientRegistration")) ) {
					isAADHAAREnabledYN = (XHUtil.singleParamExeQry("Select AADHAR_CONFIG_ENABLED_YN from MP_PARAM").equals("Y")) ? true : false;
					if (isAADHAAREnabledYN){
						eKYCBtnDisabled = "";
						chkEKYCValidate = "Y";
					}
					else
					{
						eKYCBtnDisabled = "disabled";
						chkEKYCValidate = "N";
					}					

	            
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(eKYCBtnDisabled));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block100Bytes, _wl_block100);

				}
				/*Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1*/
				if(isEmployeePrivilegeAppl)
				{
            _bw.write(_wl_block101Bytes, _wl_block101);
	}/*End TBMC-CRF-0010.1*/
			
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(disp_nat_man_gif));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(aadhaar_card_status));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(aadhaar_id));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(aadhaar_trans_id));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(chkEKYCValidate));
            _bw.write(_wl_block107Bytes, _wl_block107);
 
			} else {   
				if(!CalledFromFunction.equals("ChangePatDtls")) {
					
            _bw.write(_wl_block108Bytes, _wl_block108);

				} 
            _bw.write(_wl_block109Bytes, _wl_block109);

			}
			if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf((String)hash_Map1.get("national_id_no")));
            _bw.write(_wl_block111Bytes, _wl_block111);
 } 
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(Site));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf((String)hash_Map.get("nat_id_pat_ser_grp")));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(invoke_routine));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(nat_data_source_id));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(nat_id_reqd_all_series));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(nat_id_check_digit_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(nat_id_chk_len));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block120Bytes, _wl_block120);
/*For Other Alt No */ 
				if(Accept_oth_alt_id_yn.equals("Y")) 
				{ 
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);

				String sel = "";
				for(int i=0;i<array_List1.size();i+=2) {
					sel = "";
						if(CalledFromFunction.equals("ChangePatDtls")) {
							if(((String)hash_Map1.get("oth_alt_id_type")).equals((String)array_List1.get(i)))
								sel="selected"; 
							else sel = ""; 
						} else if(CalledFromFunction.equals("PatientRegistration")) {
							if(a_oth_alt_id_type.equals((String)array_List1.get(i)))
								sel="selected"; 
							else sel = ""; 
					} 
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf((String)array_List1.get(i)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((String)array_List1.get(i+1)));
            _bw.write(_wl_block125Bytes, _wl_block125);

				} 
            _bw.write(_wl_block126Bytes, _wl_block126);

				out.println("<input type ='text' name='other_alt_Id_text' id='other_alt_Id_text' size='20' maxlength='20'  disabled ");
				if(CalledFromFunction.equals("ChangePatDtls"))
					out.println(" value=\""+(String)hash_Map1.get("demo_oth_alt_id_no")+"\" >");
				else if(CalledFromFunction.equals("PatientRegistration"))
					out.println(" value=\""+a_oth_alt_id_no+"\" ");
				else out.println(" value='' >");
				
            _bw.write(_wl_block127Bytes, _wl_block127);

			} else { 
            _bw.write(_wl_block128Bytes, _wl_block128);
 }
			
            _bw.write(_wl_block129Bytes, _wl_block129);

				//Maheshwaran K added for the TH-KW-CRF-0019 
				if(function_name.equals("05")){
				 if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("ChangePatDtls")) {
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);

				String snat_id_exp_date="";
			//	out.println("hash_Map1.get(nat_id_expiry_date)=========="+checkForNull((String)hash_Map1.get("nat_id_expiry_date")));
			//	checkForNull((String)hash_Map1.get("nat_id_expiry_date")
				if(CalledFromFunction.equals("ChangePatDtls") && !(checkForNull((String)hash_Map1.get("nat_id_expiry_date"))).equals("")) {
				snat_id_exp_date = (String)hash_Map1.get("nat_id_expiry_date");
				//out.println("MdisEnb - "+MdisEnb);
				
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(snat_id_exp_date));
            _bw.write(_wl_block133Bytes, _wl_block133);
						
						if (!localeName.equals("en")) {
						snat_id_exp_date = DateUtils.convertDate(snat_id_exp_date,"DMYHMS","en",localeName); 
					
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block135Bytes, _wl_block135);

						}							
					
            _bw.write(_wl_block136Bytes, _wl_block136);

				out.print("<input type='text' id='natidexpdate' name='nat_id_exp_date' id='nat_id_exp_date' maxlength='10' size='8' value='"+snat_id_exp_date+"' onBlur=\""+"makeValidString(this);"+"\"  "+MdisEnb+"><img  src='../../eCommon/images/CommonCalendar.gif' "+MdisEnb+"  onClick=\"return showCalendar('natidexpdate');\" >");
				}
				else {
					if(function_name.equals("05")){
					out.print("<input type='text' id='natidexpdate' name='nat_id_exp_date' id='nat_id_exp_date' maxlength='10' size='8' value='"+nat_id_exp_date+"' onBlur=\""+"makeValidString(this);"+"\"><img  src='../../eCommon/images/CommonCalendar.gif'   onClick=\"return showCalendar('natidexpdate');\" >");
					}
					else {
					out.print("<input type='text' id='natidexpdate' name='nat_id_exp_date' id='nat_id_exp_date' maxlength='10' size='8' value='' onBlur=\""+"makeValidString(this);"+"\"><img  src='../../eCommon/images/CommonCalendar.gif'   onClick=\"return showCalendar('natidexpdate');\" >");
					}
				
				}
				
				
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(disp_nat_man_gif));
            _bw.write(_wl_block137Bytes, _wl_block137);
 
				}
				}
            _bw.write(_wl_block138Bytes, _wl_block138);

				String blood_donor			= checkForNull((String)hash_Map1.get("blood_donor"),"N");//Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857]
				String visa_type			= checkForNull((String)hash_Map1.get("visa_type"));
				/*Added by Dharma on 22nd Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
				String Alt_Id3_Reqd_Yn		= (String)hash_Map.get("Alt_Id3_Reqd_Yn");
				String isForm60Validation	= "N";
				String isCitizen			= checkForNull((String)hash_Map1.get("citizen_yn"),"Y");
				String form_60_yn			= checkForNull((String)hash_Map1.get("form_60_yn"),"N");
				Boolean isForm60Available	= CommonBean.isSiteSpecific(conn, "MP","REG_PAT_ALT_ID3_PAN_CARD");
				String isDisabledForm60		= "";
				//if(isCitizen.equals("N")){
				/*Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809]*/
				/*if(isCitizen.equals("N") && isForm60Available){ //Modified By Dharma on 20th June 2016 against ML-MMOH-SCF-0434 [IN:060703]
					isDisabledForm60		= "disabled";
				}*/

			//&& isForm60Available
				if((!Alt_Id3_Type.equals("")) && !CalledFromFunction.equals("EmergencyReg") && isForm60Available ) { 
					isForm60Validation	= "Y";
					
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(isDisabledForm60));
            _bw.write(_wl_block141Bytes, _wl_block141);
if(form_60_yn.equals("Y")){
            _bw.write(_wl_block142Bytes, _wl_block142);
}
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
if(form_60_yn.equals("N")){
            _bw.write(_wl_block142Bytes, _wl_block142);
}
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);
}
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(isForm60Available));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(isForm60Validation));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(isDisabledForm60));
            _bw.write(_wl_block148Bytes, _wl_block148);
  	
		if(CalledFromFunction.equals("ChangePatDtls")) {
			if ( ((String)hash_Map.get("alt_id1_accept_oth_pat_ser_yn")).equals("N")
				 && !(checkForNull((String)hash_Map1.get("id_type"))).equals("A")) {
				if( (checkForNull((String)hash_Map1.get("inhouse_birth_yn"))).equals("N"))  
					alt_id1_disable = "disabled";
			}
			if(alt_id1_chng_allowed_yn.equals("Y")) {
				alt_id1_disable = ""; 
			}
			else {
				if((checkForNull((String)hash_Map1.get("alt_id1_no"))).equals("")) alt_id1_disable = "";	 /*alt_id1_no*/
				else alt_id1_disable = "disabled";
				//if(id_change_allowed_for_series.equals("A")) alt_id1_disable = "";
			}
			/*If organization Membership is enabled*/
			if(family_org_id_accept_yn.equals("Y")) alt_id1_disable = "";	
			
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(checkForNull((String)hash_Map1.get("alt_id1_no"))));
            _bw.write(_wl_block150Bytes, _wl_block150);

		}			
		
            _bw.write(_wl_block151Bytes, _wl_block151);


		if((!Alt_Id1_Type.equals(""))) {
			String onblur_part1 = "";
			if (dflt_alt_id1_in_emp_id_yn.equals("Y"))	exeStrEmpId = "assignEmpID(this);";
			//Maheshwaran K added empSrvOnblur for MO-CRF-20183.2 as on 08-05-2023
			
					if(CalledFromFunction.equals("ChangePatDtls")) {
					empSrvOnblur=" checkForEmpSrvNum(this);";
					}
					else if(!a_alt_id1_no.equals("")) {
					empSrvOnblur=" checkForEmpSrvNum(this);";
					} else {
					empSrvOnblur=" checkForEmpSrvNum(this);";
					}
				
			
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf((String)hash_Map.get("alt_id1_desc")));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf((String)hash_Map.get("alt_id1_desc")));
            _bw.write(_wl_block65Bytes, _wl_block65);

			out.print("<td class='fields' ><input type='text'  name='alt_id1_no' id='alt_id1_no' maxlength='"+Alt_Id1_length+"' size='"+Alt_Id1_length+"'   ");
           onblur_part1 = "makeValidString(this); clearMembership();"+exeStrEmpId+empSrvOnblur;		 //Maheshwaran K added empSrvOnblur for MO-CRF-20183.2 as on 08-05-2023
	 


		   if(CalledFromFunction.equals("ChangePatDtls")) {
				onblur_part1 = "chkMembershipID(this);makeValidString(this);"+exeStrEmpId+empSrvOnblur ; //Maheshwaran K added empSrvOnblur for MO-CRF-20183.2 as on 08-05-2023
				if(!((String)hash_Map1.get("alt_id1_no")).equals("")) {
						out.print(" value=\""+checkForNull((String)hash_Map1.get("alt_id1_no"))+"\" ");	
					} else {
						out.print(" value=\"\" ");
						altid1datelookup = "disabled";
					}
			} else if(!a_alt_id1_no.equals("")) {
				out.print(" value=\""+a_alt_id1_no+"\" ");
			} else {
				out.print(" value=\"\" ");
				altid1datelookup = "disabled";
			}
			
			/*Depending on above various conditions Alt ID1 is either enabled or disabled*/
			
			out.print(" "+alt_id1_disable+" ");
			out.println(" onKeyPress='return SpecialCharRestriction(event)' ");
			if(((String)hash_Map.get("Alt_Id1_Unique_Yn")).equals("Y")) {
				out.print("onblur=\" ChangeToUpperCase(this);checkAlternateIdForUnique(this,1,'"+(String)hash_Map.get("Alt_Id1_Unique_Yn")+"','"+(String)hash_Map.get("alt_id1_routine_yn")+"','"+(String)hash_Map.get("alt_id1_routine")+"','"+ (String) hash_Map.get("alt_id1_chk_digit_scheme")+"','"+alt_id1_len_validation_yn+"','"+(String)hash_Map.get("alt_id1_accept_alphanumeric_yn")+"');"+onblur_part1+"\"> "); 
			} else {
				out.print("onblur=\" ChangeToUpperCase(this);checkAltIDLength(this,1,'"+alt_id1_len_validation_yn+"','"+(String)hash_Map.get("alt_id1_routine_yn")+"','"+(String)hash_Map.get("alt_id1_routine")+"','"+(String) hash_Map.get("alt_id1_chk_digit_scheme")+"','"+(String)hash_Map.get("alt_id1_accept_alphanumeric_yn")+"');"+onblur_part1+"\"> ");
			}
			String altid1_imgname = " id='alt1_gif' ";
			if(((String)hash_Map.get("Alt_Id1_Reqd_Yn")).equals("Y")) {   
				
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(altid1_imgname));
            _bw.write(_wl_block155Bytes, _wl_block155);
}else{ 
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(citizen_requied));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(altid1_imgname));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(citizen_visibility));
            _bw.write(_wl_block159Bytes, _wl_block159);
 }

			if(alt_id1_exp_date_show) { 
				
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(citizen_requied));
            _bw.write(_wl_block162Bytes, _wl_block162);
 
				out.print("<td class='fields'><input type='text' name='alt_id1_exp_date' id='alt_id1_exp_date' maxlength='10' size='8'");
				if(CalledFromFunction.equals("ChangePatDtls")) {
						out.print(" value=\""+alt_id1_exp_date+"\" ");
						out.print(((String)hash_Map1.get("alt_id1_no")).equals("") ? "readonly" : "");
				} else if(CalledFromFunction.equals("PatientRegistration")) {
			
					if ( a_alt_id1_no.equals("") ) {
						out.print(" value=\""+a_alt_id1_exp_date+"\" readonly");
						altid1datelookup = "disabled";
					}else{
						out.print(" value=\""+a_alt_id1_exp_date+"\" ");
					}
				} else out.print(" value=''  readonly");
				out.print(" onBlur= \""+"makeValidString(this);checkExpiryDate(this,1);"+"\"  "+alt_id1_disable+"><img src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt1' "+altid1datelookup+" onClick=\"return showCalendar('alt_id1_exp_date'); \"  "+alt_id1_disable+" ><img src='../../eCommon/images/mandatory.gif' id='alt1_exp_date1' style='"+citizen_visibility+"'></img></td>");
				/*Above line modified for this CRF  GHL-CRF-0332 [IN:042060]*/
			} else { 
            _bw.write(_wl_block163Bytes, _wl_block163);
	} 
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(Alt_Id1_Type));
            _bw.write(_wl_block120Bytes, _wl_block120);
 if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf((String)hash_Map1.get("alt_id1_no")));
            _bw.write(_wl_block65Bytes, _wl_block65);

			} 
            _bw.write(_wl_block127Bytes, _wl_block127);
 
		} else { 
            _bw.write(_wl_block166Bytes, _wl_block166);
 }
		
            _bw.write(_wl_block151Bytes, _wl_block151);

		if((!Alt_Id2_Type.equals(""))) { 
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf((String)hash_Map.get("alt_id2_desc")));
            _bw.write(_wl_block127Bytes, _wl_block127);
 
			String alt_id2_disable	= "disabled";
			if(id_change_allowed_for_series.equals("A")) alt_id2_disable = "";
			out.print("<td  class='fields'  ><input type='text' name='alt_id2_no' id='alt_id2_no' maxlength='"+Alt_Id2_length+"' size='"+Alt_Id2_length+"'   '"+alt_id2_disable+"' onKeyPress='if("+alt_id2_specialchar_validation+"){ return SpecialCharRestriction(event)}'");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			if(CalledFromFunction.equals("ChangePatDtls")) {
				if(!((String)hash_Map1.get("alt_id2_no")).equals("")) {
					alt_id2_disable="disabled";
					out.print(" value=\""+(String)hash_Map1.get("alt_id2_no")+"\" ");
				} else {
					out.print(" value=\"\" ");
					altid2datelookup = "disabled";
				}
			} else if(CalledFromFunction.equals("PatientRegistration")) {
				out.print(" value=\""+a_alt_id2_no+"\" ");
			} else {
				out.print(" value=\"\" ");
				altid2datelookup = "disabled";
			}
			if(((String)hash_Map.get("Alt_Id2_Unique_Yn")).equals("Y")) {
				out.print(" onBlur=\"if("+alt_id2_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,2,'"+alt_id2_accept_alphanumeric_yn+"','"+alt_id2_alphanum_validate_yn+"');}makeValidString(this);checkAlternateIdForUnique(this,2,'"+(String)hash_Map.get("Alt_Id2_Unique_Yn")+"','"+(String)hash_Map.get("alt_id2_routine_yn")+"','"+(String)hash_Map.get("alt_id2_routine")+"','"+(String) hash_Map.get("alt_id2_chk_digit_scheme")+"','"+alt_id2_len_validation_yn+"');\" > ");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			} else {
				out.print(" onBlur=\"if("+alt_id2_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,2,'"+alt_id2_accept_alphanumeric_yn+"','"+alt_id2_alphanum_validate_yn+"');}makeValidString(this);checkAltIDLength(this,2,'"+alt_id2_len_validation_yn+"','"+(String)hash_Map.get("alt_id2_routine_yn")+"','"+(String)hash_Map.get("alt_id2_routine")+"','"+(String) hash_Map.get("alt_id2_chk_digit_scheme")+"');\" > ");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			}	 
			if(((String)hash_Map.get("Alt_Id2_Reqd_Yn")).equals("Y")) { 
				String imgName = "";
				if(CalledFromFunction.equals("EmergencyReg")) {
					imgName = " id='alt2_gif' ";
				} 
				
            _bw.write(_wl_block168Bytes, _wl_block168);
if(isNatIdAltIdMandVisaType ){
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
if("Y".equals(gcc)){
            _bw.write(_wl_block171Bytes, _wl_block171);
}
            _bw.write(_wl_block172Bytes, _wl_block172);
	}
            _bw.write(_wl_block173Bytes, _wl_block173);
 
			} else { 
            _bw.write(_wl_block174Bytes, _wl_block174);
if(isNatIdAltIdMandVisaType ){
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
if("Y".equals(gcc)){
            _bw.write(_wl_block171Bytes, _wl_block171);
} 
            _bw.write(_wl_block175Bytes, _wl_block175);
	}
            _bw.write(_wl_block176Bytes, _wl_block176);
 
			
			}
			
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(gcc));
            _bw.write(_wl_block178Bytes, _wl_block178);

			
			if(alt_id2_exp_date_show) { 
				
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
 
				out.print("<td class='fields'    ><input type='text' id='altidexpdate2' name='alt_id2_exp_date' id='alt_id2_exp_date' maxlength='10' size='8'   ");
				if(CalledFromFunction.equals("ChangePatDtls")) {
					out.print(" value=\""+alt_id2_exp_date+"\" ");
					out.print(((String)hash_Map1.get("alt_id2_no")).equals("")? "readonly" : "");
				} else if(CalledFromFunction.equals("PatientRegistration")) {
			
					if ( a_alt_id2_no.equals("") ) {
						out.print(" value=\""+a_alt_id2_exp_date+"\" readonly");
						altid2datelookup = "disabled";
					}else{
						out.print(" value=\""+a_alt_id2_exp_date+"\" ");
					}
			} else  out.print(" value=\"\"  readonly");
		out.print(" onBlur=\""+"makeValidString(this);checkExpiryDate(this,2);"+"\"><img  src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt2' "+altid2datelookup+" onClick=\"return showCalendar('altidexpdate2');\" >");
		} else { 
            _bw.write(_wl_block179Bytes, _wl_block179);
 } 
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(Alt_Id2_Type));
            _bw.write(_wl_block181Bytes, _wl_block181);
 if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf((String)hash_Map1.get("alt_id2_no")));
            _bw.write(_wl_block65Bytes, _wl_block65);

		}
            _bw.write(_wl_block127Bytes, _wl_block127);
 
		} 
		else { 
            _bw.write(_wl_block183Bytes, _wl_block183);
 } 
            _bw.write(_wl_block184Bytes, _wl_block184);
if(!CalledFromFunction.equals("EmergencyReg")) { 
			
            _bw.write(_wl_block185Bytes, _wl_block185);

			if (!Alt_Id3_Type.equals("")){ 
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf((String)hash_Map.get("alt_id3_desc")));
            _bw.write(_wl_block187Bytes, _wl_block187);
 
				String alt_id3_disable = "disabled";
				if(id_change_allowed_for_series.equals("A")) alt_id3_disable = "";





				out.print("<td  class='fields'   ><input type='text' name='alt_id3_no' id='alt_id3_no' "+isDisabledForm60+" maxlength='"+Alt_Id3_length+"' size='"+Alt_Id3_length+"'   '"+alt_id3_disable+"' onKeyPress='if("+alt_id3_specialchar_validation+"){return SpecialCharRestriction(event);}'  ");/*Added by Rameswar on 24/11/2016 for BSP-SCF-0021 -- onblur added by mujafar for KDAH-CRF-370.1 */ 
				if(CalledFromFunction.equals("ChangePatDtls")) {
					if(!(((String)hash_Map1.get("alt_id3_no")).equals(""))) {
						 alt_id3_disable="disabled";
						 out.print(" value=\""+(String)hash_Map1.get("alt_id3_no")+"\" ");
					} else {out.print(" value=\"\" ");altid3datelookup = "disabled";}
				}
				else if(CalledFromFunction.equals("PatientRegistration")) {
					out.print(" value=\""+a_alt_id3_no+"\" ");
				} else {out.print(" value=\"\" ");altid3datelookup = "disabled";}
			if(((String)hash_Map.get("Alt_Id3_Unique_Yn")).equals("Y")) {
				out.print(" onBlur=\"makeClear();nuhdeekField();if("+alt_id3_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,3,'"+alt_id3_accept_alphanumeric_yn+"','"+alt_id3_alphanum_validate_yn+"');}makeValidString(this);checkAlternateIdForUnique(this,3,'"+(String)hash_Map.get("Alt_Id3_Unique_Yn")+"','"+(String)hash_Map.get("alt_id3_routine_yn")+"','"+(String)hash_Map.get("alt_id3_routine")+"','"+(String) hash_Map.get("alt_id3_chk_digit_scheme")+"','"+alt_id3_len_validation_yn+"');\" >");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			} else {
				out.print(" onBlur=\"makeClear();nuhdeekField();if("+alt_id3_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,3,'"+alt_id3_accept_alphanumeric_yn+"','"+alt_id3_alphanum_validate_yn+"');}makeValidString(this);checkAltIDLength(this,3,'"+alt_id3_len_validation_yn+"','"+ (String)hash_Map.get("alt_id3_routine_yn")+"','"+(String)hash_Map.get("alt_id3_routine")+"','"+(String) hash_Map.get("alt_id3_chk_digit_scheme")+"');\" >");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			}																						 
			//if(((String)hash_Map.get("Alt_Id3_Reqd_Yn")).equals("Y")) { 
			//if(((String)hash_Map.get("Alt_Id3_Reqd_Yn")).equals("Y") || (isForm60Available && isDisabledForm60.equals(""))) { //Modified By Dharma on 22nd Jan 2016 for KDAH-CRF-0331 [IN058799] 
				if(((String)hash_Map.get("Alt_Id3_Reqd_Yn")).equals("Y") && (!isForm60Available)) {//Modified by Dharma on july 13th 2016 against KDAH-SCF-0358 [IN:060809]
				
            _bw.write(_wl_block188Bytes, _wl_block188);
} else { 
            _bw.write(_wl_block189Bytes, _wl_block189);
 }
            _bw.write(_wl_block190Bytes, _wl_block190);
 
				// added by mujafar for KDAH-CRF-370.1 START
				if(chkPanValidate) {
					
					String chk_val="";
					String valu="";
					String value1="";
					String value2="";
					String value3="";
					if(CalledFromFunction.equals("ChangePatDtls"))
					{	
						String alt_id3_chng_allowed_yn  =	 checkForNull((String)hash_Map.get("alt_id3_chng_allowed_yn"));
						
							if(alt_id3_chng_allowed_yn.equals("Y")) 
							{
								chk_val = "";
								
							}
							else
							{
							chk_val="none";
							}
							valu =  checkForNull((String)hash_Map1.get("alt_id3_no"));
							value1 =  checkForNull((String)hash_Map1.get("pancard_status"));
							value2 =  checkForNull((String)hash_Map1.get("pancard_holder_name"));
							value3=  checkForNull((String)hash_Map1.get("pan_transaction_id"));
							
					
					}
					else if(CalledFromFunction.equals("PatientRegistration")) 
					{
						   chk_val = "";
					   
					}
					
					
				
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(chk_val));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(p_ws_no));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(value2));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(value1));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(value3));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(valu));
            _bw.write(_wl_block199Bytes, _wl_block199);
 }
			//added by mujafar for KDAH-CRF-370.1 
			
			//	isNuhdeekIDAppl = true;
				if((!Alt_Id3_Type.equals("")) && !CalledFromFunction.equals("EmergencyReg") && isNuhdeekIDAppl ) { 
						String primary_nuhdeek_yn = "";
					
						String getOtpDisable = "disabled";
						if(CalledFromFunction.equals("ChangePatDtls")) {
							if(!((String)hash_Map1.get("alt_id3_no")).equals("")) {
								getOtpDisable = "visible"; 
							  }
							 primary_nuhdeek_yn  = checkForNull((String)hash_Map1.get("primary_nuhdeek_yn"));
						}
						
					
					
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(getOtpDisable));
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block203Bytes, _wl_block203);
if(primary_nuhdeek_yn.equals("Y")){
            _bw.write(_wl_block142Bytes, _wl_block142);
}
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
if(primary_nuhdeek_yn.equals("N")){
            _bw.write(_wl_block142Bytes, _wl_block142);
}
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);
}
            _bw.write(_wl_block205Bytes, _wl_block205);
if(alt_id3_exp_date_show) { 
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);
 out.print("<input type='text' id='altidexpdate3' name='alt_id3_exp_date' id='alt_id3_exp_date' maxlength='10' size='8'  ");
				if(CalledFromFunction.equals("ChangePatDtls")) {
						if(!((String)hash_Map1.get("alt_id3_exp_date")).equals("")) {
							out.print(" value=\""+alt_id3_exp_date+"\" ");
						} else out.print(" value=\"\"  ");
				} else if(CalledFromFunction.equals("PatientRegistration")) {
					//out.print(" value=\""+a_alt_id3_exp_date+"\" readonly ");
					if ( a_alt_id3_no.equals("") ) {
						out.print(" value=\""+a_alt_id3_exp_date+"\" readonly");
						altid3datelookup = "disabled";
					}else{
						out.print(" value=\""+a_alt_id3_exp_date+"\" ");
					}
				} else out.print(" value=\"\" readonly ");
				out.print(" onBlur=\""+"makeValidString(this);checkExpiryDate(this,3);"+"\"><img src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt3' "+altid3datelookup+" onClick=\"return showCalendar('altidexpdate3');\" >");
		
			} else { 
            _bw.write(_wl_block179Bytes, _wl_block179);
 } 
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(Alt_Id3_Type));
            _bw.write(_wl_block120Bytes, _wl_block120);
 if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf((String)hash_Map1.get("alt_id3_no")));
            _bw.write(_wl_block65Bytes, _wl_block65);

			}else{ 
            _bw.write(_wl_block210Bytes, _wl_block210);
}
            _bw.write(_wl_block211Bytes, _wl_block211);

		} else { 
            _bw.write(_wl_block183Bytes, _wl_block183);
 }	   
            _bw.write(_wl_block212Bytes, _wl_block212);
 
						if((!Alt_Id3_Type.equals("")) && !CalledFromFunction.equals("EmergencyReg") && isNuhdeekIDAppl ) { 
						//String nuhdeek_ready_yn = "";
					
						String getOtpDisable = "disabled";
						if(CalledFromFunction.equals("ChangePatDtls")) {
							if(!((String)hash_Map1.get("alt_id3_no")).equals("")) {
								getOtpDisable = "visible"; 
							  }							
							nuhdeek_ready_yn = checkForNull((String)hash_Map1.get("nuhdeek_ready_yn"));
							
						}
						
					
					
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(getOtpDisable));
            _bw.write(_wl_block214Bytes, _wl_block214);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(p_ws_no));
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(p_ws_no));
            _bw.write(_wl_block220Bytes, _wl_block220);
}
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(nuhdeek_ready_yn));
            _bw.write(_wl_block222Bytes, _wl_block222);

		//added by mujafar for KDAH-CRF-370.1 START
		if(chkPanValidate && !Alt_Id3_Type.equals("")){
		if(CalledFromFunction.equals("ChangePatDtls") && !((String)hash_Map1.get("alt_id3_no")).equals("")&&!((String)hash_Map1.get("pancard_relation")).equals(""))
		{ 
				
			  String sel1="",sel2="",sel3="",sel4="";
			  String status_val="";
			  if(((String)hash_Map1.get("pancard_relation")).equals("S")) sel1="selected"; 
			  if(((String)hash_Map1.get("pancard_relation")).equals("F")) sel2="selected"; 
			  if(((String)hash_Map1.get("pancard_relation")).equals("M")) sel3="selected"; 
			  if(((String)hash_Map1.get("pancard_relation")).equals("G")) sel4="selected"; 	   
			  if(((String)hash_Map1.get("pancard_status")).equals("A"))   status_val="ACTIVE"; 

		
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(status_val));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf((String)hash_Map1.get("pancard_holder_name")));
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block226Bytes, _wl_block226);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(sel1));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(sel2));
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(sel3));
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(sel4));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);
}else{
            _bw.write(_wl_block233Bytes, _wl_block233);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block236Bytes, _wl_block236);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block238Bytes, _wl_block238);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block239Bytes, _wl_block239);
}		
		}
		//End added by mujafar for KDAH-CRF-370.1
		
		if (!Alt_Id4_Type.equals(""))  { 
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf((String)hash_Map.get("alt_id4_desc")));
            _bw.write(_wl_block241Bytes, _wl_block241);
 String alt_id4_disable	= "";
			if(id_change_allowed_for_series.equals("A")) alt_id4_disable = "";
			if(CalledFromFunction.equals("ChangePatDtls")) {
				if(!(((String)hash_Map1.get("alt_id4_no")).equals(""))) alt_id4_disable="disabled";
			}
			out.print("<td class='fields'  ><input type='text' name='alt_id4_no' id='alt_id4_no' maxlength='"+Alt_Id4_length+"' size='"+Alt_Id4_length+"'  '"+alt_id4_disable+"' onKeyPress='if("+alt_id4_specialchar_validation+"){return SpecialCharRestriction(event)}'");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			if(CalledFromFunction.equals("ChangePatDtls")) {
				if(!(((String)hash_Map1.get("alt_id4_no")).equals(""))) 
					out.print(" value=\""+(String)hash_Map1.get("alt_id4_no")+"\" ");
				else
				{out.print(" value=\"\" ");altid4datelookup = "disabled";}
			}
			else if(CalledFromFunction.equals("PatientRegistration"))
			{out.print(" value=\""+a_alt_id4_no+"\" ");}
			else 
			{out.print(" value=\"\" ");altid4datelookup = "disabled";}
			if(((String)hash_Map.get("Alt_Id4_Unique_Yn")).equals("Y")) {
				out.print(" onBlur=\"if("+alt_id4_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,4,'"+alt_id4_accept_alphanumeric_yn+"','"+alt_id4_alphanum_validate_yn+"');}makeValidString(this);checkAlternateIdForUnique(this,4,'"+(String)hash_Map.get("Alt_Id4_Unique_Yn")+"','"+(String)hash_Map.get("alt_id4_routine_yn")+"','"+(String)hash_Map.get("alt_id4_routine")+"','"+(String) hash_Map.get("alt_id4_chk_digit_scheme")+"','"+alt_id4_len_validation_yn+"');\" >");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			}
			else {	out.print(" onBlur=\"if("+alt_id4_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,4,'"+alt_id4_accept_alphanumeric_yn+"','"+alt_id4_alphanum_validate_yn+"');}makeValidString(this);checkAltIDLength(this,4,'"+alt_id4_len_validation_yn+"','"+ (String)hash_Map.get("alt_id4_routine_yn") +"','"+ (String)hash_Map.get("alt_id4_routine")+"','"+(String) hash_Map.get("alt_id4_chk_digit_scheme")+"');\" >");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
						}
				if(((String)hash_Map.get("Alt_Id4_Reqd_Yn")).equals("Y")) { 
            _bw.write(_wl_block242Bytes, _wl_block242);
 } else { 
            _bw.write(_wl_block243Bytes, _wl_block243);
 }
				
            _bw.write(_wl_block244Bytes, _wl_block244);
 
							if (ndhm_appl_YN.equals("Y") && (CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("ChangePatDtls"))){
							abha_pat_id = checkForNull((String)hash_Map1.get("myhix_pat_id"));
						
							 if(CalledFromFunction.equals("ChangePatDtls") && !abha_pat_id.equals("")){
								UpdateHealthIDVisible="display:inline";
								LinkHealthIDVisible="display:none";
							  } else { 
								UpdateHealthIDVisible="display:none";
								LinkHealthIDVisible="display:inline";
							}
							
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(p_ws_no));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(sessionID));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(UpdateHealthIDVisible));
            _bw.write(_wl_block247Bytes, _wl_block247);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(p_ws_no));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(sessionID));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(LinkHealthIDVisible));
            _bw.write(_wl_block249Bytes, _wl_block249);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block251Bytes, _wl_block251);

							if(!alt_id4_exp_date_show) {
            _bw.write(_wl_block252Bytes, _wl_block252);
 if(CalledFromFunction.equals("ChangePatDtls") && !abha_pat_id.equals(""))
									{
									
            _bw.write(_wl_block253Bytes, _wl_block253);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(abha_pat_id.substring(abha_pat_id.length()-4)));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(abha_pat_id));
            _bw.write(_wl_block259Bytes, _wl_block259);
if(!abha_pat_id.equals("")) {
            _bw.write(_wl_block260Bytes, _wl_block260);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
}
            _bw.write(_wl_block262Bytes, _wl_block262);

									}
								else {
									
            _bw.write(_wl_block263Bytes, _wl_block263);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(abha_pat_id));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(abha_pat_id));
            _bw.write(_wl_block267Bytes, _wl_block267);
if(!abha_pat_id.equals("")) {
            _bw.write(_wl_block260Bytes, _wl_block260);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
}
            _bw.write(_wl_block268Bytes, _wl_block268);

									} 
								}
							} 
            _bw.write(_wl_block269Bytes, _wl_block269);

				
				if(alt_id4_exp_date_show) { 
            _bw.write(_wl_block270Bytes, _wl_block270);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block271Bytes, _wl_block271);
 out.print("<input type='text' name='alt_id4_exp_date' id='alt_id4_exp_date' id='altidexpdate4' maxlength='10' size='8'  ");
						if(CalledFromFunction.equals("ChangePatDtls"))
						{
								out.print(" value=\""+alt_id4_exp_date+"\" ");
								out.print(((String)hash_Map1.get("alt_id4_no")).equals("") ? "readonly" : "" );
						}
						else if(CalledFromFunction.equals("PatientRegistration"))
						{
		
								if ( a_alt_id4_no.equals("") ) 
								{
									out.print(" value=\""+a_alt_id4_exp_date+"\" readonly");
									altid4datelookup = "disabled";
								}
								else
								{
									out.print(" value=\""+a_alt_id4_exp_date+"\" ");
								}
						}
						else out.print(" value=\"\"  readonly");
		
					out.print(" onBlur=\""+"makeValidString(this);checkExpiryDate(this,4);"+"\"><img  src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt4' "+altid4datelookup+" onClick=\"return showCalendar('altidexpdt4');\" >");
				} else { 
            _bw.write(_wl_block179Bytes, _wl_block179);
 } 
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(Alt_Id4_Type));
            _bw.write(_wl_block74Bytes, _wl_block74);
 if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf((String)hash_Map1.get("alt_id4_no")));
            _bw.write(_wl_block74Bytes, _wl_block74);
 } 
            _bw.write(_wl_block241Bytes, _wl_block241);
 } else { 
            _bw.write(_wl_block183Bytes, _wl_block183);
 } 
            _bw.write(_wl_block274Bytes, _wl_block274);
 if (ndhm_appl_YN.equals("Y") && (CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("ChangePatDtls"))){
				 abha_pat_id = checkForNull((String)hash_Map1.get("myhix_pat_id"));
					if(alt_id4_exp_date_show) {
					if(CalledFromFunction.equals("ChangePatDtls") && !abha_pat_id.equals(""))
						{
						
            _bw.write(_wl_block275Bytes, _wl_block275);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(abha_pat_id.substring(abha_pat_id.length()-4)));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(abha_pat_id));
            _bw.write(_wl_block259Bytes, _wl_block259);
if(!abha_pat_id.equals("")) {
            _bw.write(_wl_block260Bytes, _wl_block260);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
}
            _bw.write(_wl_block276Bytes, _wl_block276);
	
						}
					else {
						
            _bw.write(_wl_block277Bytes, _wl_block277);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(abha_pat_id));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(Alt_Id4_length));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(abha_pat_id));
            _bw.write(_wl_block267Bytes, _wl_block267);
if(!abha_pat_id.equals("")) {
            _bw.write(_wl_block260Bytes, _wl_block260);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
}
            _bw.write(_wl_block278Bytes, _wl_block278);

						}
						} 
					
					} 
            _bw.write(_wl_block279Bytes, _wl_block279);
}
            _bw.write(_wl_block280Bytes, _wl_block280);

	//** End of National ID, Other Alternate ID type and number and all alternate ID type's - Start of Naming fields  **//
	if(Family_No_Link_Yn.equals("Y") || family_org_id_accept_yn.equals("Y")) 
	{ 
	
            _bw.write(_wl_block281Bytes, _wl_block281);
if(family_org_id_accept_yn.equals("Y")){
            _bw.write(_wl_block282Bytes, _wl_block282);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block283Bytes, _wl_block283);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block284Bytes, _wl_block284);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block285Bytes, _wl_block285);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block286Bytes, _wl_block286);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block287Bytes, _wl_block287);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block288Bytes, _wl_block288);
if(CalledFromFunction.equals("ChangePatDtls")){
				String mem_type = (String)hash_Map1.get("MembershipType");
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(mem_type));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(mem_type));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(mem_type));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(mem_type));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(mem_type));
            _bw.write(_wl_block294Bytes, _wl_block294);
}
				}
				if(family_org_id_accept_yn.equals("Y"))
					{
            _bw.write(_wl_block295Bytes, _wl_block295);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block296Bytes, _wl_block296);
if(CalledFromFunction.equals("ChangePatDtls")){
							
							String Orgname="";
							String Orgsubname = "";
							String OrgsubnameDesc = "";
							String family_org_id = "";
							
							if ( (checkForNull((String)hash_Map1.get("MembershipType")).equals("2")) || 					 (checkForNull((String)hash_Map1.get("MembershipType")).equals("3")) )
							{	
								String  rPatient_id =   eMP.ChangePatientDetails.getMemberPatID(checkForNull((String)hash_Map1.get("alt_id1_no")),conn,p);
								hash_Map2	= eMP.ChangePatientDetails.getOrgMembership(rPatient_id, conn,p);	
								
								Orgname = checkForNull((String)hash_Map2.get("Orgname"));
								Orgsubname = checkForNull((String)hash_Map2.get("Orgsubname"));
								OrgsubnameDesc = checkForNull((String)hash_Map2.get("OrgsubnameDesc"));
								family_org_id = checkForNull((String)hash_Map2.get("family_org_id"));								
								
							}else{
								Orgname = checkForNull((String)hash_Map1.get("Orgname"));
								Orgsubname = checkForNull((String)hash_Map1.get("Orgsubname"));
								OrgsubnameDesc = checkForNull((String)hash_Map1.get("OrgsubnameDesc"));
								family_org_id = checkForNull((String)hash_Map1.get("family_org_id"));
							}							
							
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(Orgname));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(family_org_id));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(Orgsubname));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(Orgname));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(Orgsubname));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(OrgsubnameDesc));
            _bw.write(_wl_block303Bytes, _wl_block303);

					}
				 }
				 
            _bw.write(_wl_block304Bytes, _wl_block304);

				if (Family_No_Link_Yn.equals("Y"))	 {
				
            _bw.write(_wl_block282Bytes, _wl_block282);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);
out.print("<td  class='fields'   ><input type='text' name='family_link_no' id='family_link_no' maxlength=\""+(String)hash_Map.get("Patient_Id_Length")+"\" size=\""+(String)hash_Map.get("Patient_Id_Length")+"\"   ");
				
					out.print(" onfocusout='checkForEmpSrvNum(this);' ");
				
					//Added checkstatus for MO-CRF-20162 by KAMATCHI S
					if(isHeadFamilyPatient){
					if(CalledFromFunction.equals("ChangePatDtls"))
					{ out.print(" onblur='getPatCategory();checkstatus(this);ChangeUpperCase(this);checkCurPatient(this);makeValidString(this);'value=\""+checkForNull((String)hash_Map1.get("family_link_no"))+"\" >"); 
					}else{
					out.print(" onblur='getPatCategory();checkstatus(this);makeValidString(this);ChangeUpperCase(this);enableimg();sendToServer(4)' value=\""+a_familyno+"\" >");
					}
					}
					else
					{
						if(CalledFromFunction.equals("ChangePatDtls"))
						{ out.print(" onblur='getPatCategory();ChangeUpperCase(this);checkCurPatient(this);makeValidString(this);'value=\""+checkForNull((String)hash_Map1.get("family_link_no"))+"\" >"); 
						}else{
						out.print(" onblur='getPatCategory();makeValidString(this);ChangeUpperCase(this);enableimg();sendToServer(4)' value=\""+a_familyno+"\" >");
						}
					}
					if(CalledFromFunction.equals("EmergencyReg"))
					{
            _bw.write(_wl_block305Bytes, _wl_block305);
}else{
            _bw.write(_wl_block306Bytes, _wl_block306);
} 
            _bw.write(_wl_block307Bytes, _wl_block307);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block308Bytes, _wl_block308);
if(CalledFromFunction.equals("ChangePatDtls")){
            out.print( String.valueOf((String)hash_Map1.get("head_patient_name")));
            _bw.write(_wl_block93Bytes, _wl_block93);
}
					
            _bw.write(_wl_block309Bytes, _wl_block309);

					if(family_org_id_accept_yn.equals("Y"))
					{
					
            _bw.write(_wl_block310Bytes, _wl_block310);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block311Bytes, _wl_block311);

					}else{
					
            _bw.write(_wl_block310Bytes, _wl_block310);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);
}
		
		if(CalledFromFunction.equals("ChangePatDtls")) 
		{ 
		out.println("<td  class='fields'><input type='text' name='relationship_to_head_desc' id='relationship_to_head_desc' size='20' maxlength='20' value='"+(String)hash_Map1.get("relationship_name")+"' onblur='if(this.value!=\"\"){ searchRelationship1(relationship_to_head,relationship_to_head_desc);}else{clearfields();} validateFamilyNumber(this); getLevel(); if(document.forms[0].entitlement_by_pat_cat_yn.value==\"Y\"){getPatCategory();}'");
		}
		else
		 {
		out.println("<td  class='fields'><input type='text' name='relationship_to_head_desc' id='relationship_to_head_desc' size='20' maxlength='20' value='' onblur='if(this.value!=\"\"){ searchRelationship1(relationship_to_head,relationship_to_head_desc);}else{clearfields();} validateFamilyNumber(this); getLevel(); if(document.forms[0].entitlement_by_pat_cat_yn.value==\"Y\"){getPatCategory();if(this.value==\"\"){document.forms[0].pat_cat_code.value=\"\";document.forms[0].pat_cat_desc.value=\"\";document.forms[0].pat_cat_sql.value=\"\";}}'");

		 }
				
					if(CalledFromFunction.equals("ChangePatDtls")) 
					{ 
						if(!(((String)hash_Map1.get("family_link_no")).equals(""))) 
						{ 
							out.println(" >");
						}
						else 
						{ 
							out.println(" disabled >");
						}
							if(family_org_id_accept_yn.equals("Y")) 
							{
							
            _bw.write(_wl_block313Bytes, _wl_block313);
}
					}
					else 
					{ 
						out.println(" disabled >");
					}  
					
					out.println("<input type='button'   name='relationship_to_head_code_id' id='relationship_to_head_code_id' value='?' class='button' onclick='searchRelationship1(this,relationship_to_head_desc)' ");

					if(CalledFromFunction.equals("ChangePatDtls")) 
					{ 
						if(!(((String)hash_Map1.get("family_link_no")).equals(""))) 
						{ 
							out.println(" >");
						}
						else 
						{ 
							out.println("	 disabled >");
						}
					}
					else 
						{ 
							out.println("	 disabled >");
						}  
					
					
					if(CalledFromFunction.equals("ChangePatDtls")) 
					{
					out.println("<input type='hidden' name='relationship_to_head' id='relationship_to_head' value='"+(String)hash_Map1.get("relationship_to_head")+"'>");
					}else
					 {
					out.println("<input type='hidden' name='relationship_to_head' id='relationship_to_head' value=''>");
					 }

				
            _bw.write(_wl_block314Bytes, _wl_block314);

					}
            _bw.write(_wl_block315Bytes, _wl_block315);
}
            _bw.write(_wl_block316Bytes, _wl_block316);
oth_lang = true;
	if(((String)hash_Map.get("Name_Prefix_Accept_Yn")).equals("Y"))
		{ 
            _bw.write(_wl_block317Bytes, _wl_block317);
if(pat_name_as_multipart_yn.equals("Y")){
            _bw.write(_wl_block318Bytes, _wl_block318);
}else{
            _bw.write(_wl_block319Bytes, _wl_block319);
}
		}
		if(pat_name_as_multipart_yn.equals("Y")){
            _bw.write(_wl_block320Bytes, _wl_block320);
}else{
            _bw.write(_wl_block321Bytes, _wl_block321);
} /*prefix's place is suffix's place in local lang  */
            _bw.write(_wl_block280Bytes, _wl_block280);

		if ( ( (((String)hash_Map.get("Name_Suffix_Accept_Yn")).equals("Y")) 
			 && (pat_name_as_multipart_yn.equals("Y")) ) 
			|| (((String)hash_Map.get("Name_Prefix_Accept_Yn")).equals("Y")) )
		{
            _bw.write(_wl_block322Bytes, _wl_block322);
if(pat_name_as_multipart_yn.equals("Y")){
            _bw.write(_wl_block323Bytes, _wl_block323);
}else{
            _bw.write(_wl_block324Bytes, _wl_block324);
}
		}
	
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(AltdfltPSG));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(defaultSelect));
            _bw.write(_wl_block329Bytes, _wl_block329);
            {java.lang.String __page ="../../eMP/jsp/PatNamesComp.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("group"), weblogic.utils.StringUtils.valueOf(group
                        )},{ weblogic.utils.StringUtils.valueOf("CalledFromFunction"), weblogic.utils.StringUtils.valueOf(CalledFromFunction
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_prefix"), weblogic.utils.StringUtils.valueOf(a_name_prefix
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_suffix"), weblogic.utils.StringUtils.valueOf(a_name_suffix
                        )},{ weblogic.utils.StringUtils.valueOf("a_family_name"), weblogic.utils.StringUtils.valueOf(a_family_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_first_name"), weblogic.utils.StringUtils.valueOf(a_first_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_second_name"), weblogic.utils.StringUtils.valueOf(a_second_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_third_name"), weblogic.utils.StringUtils.valueOf(a_third_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_prefix_loc_lang"), weblogic.utils.StringUtils.valueOf(a_name_prefix_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_first_name_loc_lang"), weblogic.utils.StringUtils.valueOf(a_first_name_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_second_name_loc_lang"), weblogic.utils.StringUtils.valueOf(a_second_name_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_third_name_loc_lang"), weblogic.utils.StringUtils.valueOf(a_third_name_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_family_name_loc_lang"), weblogic.utils.StringUtils.valueOf(a_family_name_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_suffix_loc_lang"), weblogic.utils.StringUtils.valueOf(a_name_suffix_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_patient_name_loc_lang"), weblogic.utils.StringUtils.valueOf(a_patient_name_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("pat_name_in_loc_lang_reqd_yn"), weblogic.utils.StringUtils.valueOf(pat_name_in_loc_lang_reqd_yn
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block330Bytes, _wl_block330);


            _bw.write(_wl_block331Bytes, _wl_block331);
 String emerg_sex_event = "";
	String sel_male = "";
	String sel_female = "";
	String sel_unknown = "";

			if(CalledFromFunction.equals("EmergencyReg")) { 
				emerg_sex_event = "onchange='callassignUnknowValues();'";
			} 
			
			if(CalledFromFunction.equals("ChangePatDtls")) {

				String gen = (String)hash_Map1.get("sex");
				if(gen.equals("M"))
					sel_male = "selected";
				else if(gen.equals("F"))
					sel_female = "selected";
				else if(gen.equals("U"))
					sel_unknown = "selected";
			}
			
			
            _bw.write(_wl_block332Bytes, _wl_block332);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(emerg_sex_event));
            _bw.write(_wl_block334Bytes, _wl_block334);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(sel_male));
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(sel_female));
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(sel_unknown));
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block338Bytes, _wl_block338);

				if(CalledFromFunction.equals("ChangePatDtls")) { 				
					
					age_value = (String) hash_Map1.get("p_age")==null?"":(String) hash_Map1.get("p_age");

					if(!age_value.equals("")) {

						StringTokenizer st = new StringTokenizer(age_value," ");

						while ( st.hasMoreTokens() ) {

							String date_elmnt = st.nextToken();						

							char ymdh_char = date_elmnt.charAt(date_elmnt.length()-1);							

							String ymdh_elmnt = date_elmnt.substring(0,(date_elmnt.length()-1));				

							if(ymdh_char=='Y') {
								year_value = ymdh_elmnt;
							     if(year_value.equals("0"))year_value="";
							} else if (ymdh_char=='M') {
								month_value	= ymdh_elmnt;
							     if(month_value.equals("0"))month_value="";
							} else if (ymdh_char=='D') {
								day_value	= ymdh_elmnt;
							   if(day_value.equals("0"))day_value="";
							} else if (ymdh_char=='H') {
								hours_value	= ymdh_elmnt;
								//if(hours_value.equals("0"))hours_value="";
							}
						}							
						
					}

					age_or_dob = (String) hash_Map1.get("calculated_age_yn");

					
					
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf((String)hash_Map1.get("sex")));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf((String)hash_Map1.get("sex")));
            _bw.write(_wl_block65Bytes, _wl_block65);

				} else if(CalledFromFunction.equals("PatientRegistration")) { 
					year_value	= year;
					month_value	= months;
					day_value	= days;
					
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(a_gender));
            _bw.write(_wl_block342Bytes, _wl_block342);

				} else if(CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) { 	
					year_value	= "";
					month_value = "";
					day_value	= "";
					if(CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) {
						
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(a_gender));
            _bw.write(_wl_block342Bytes, _wl_block342);

					}
				} 
            _bw.write(_wl_block343Bytes, _wl_block343);
					
					if(age_or_dob.equals("Y") && CalledFromFunction.equals("ChangePatDtls")) {					
						if( hours_value.equals("") ) {
							disable_age="";
						}
						check_age = "checked";
						disable_dob = "disabled";
					} else {
						disable_age="disabled";						
						check_age = "";
						disable_dob = "";
					}

					if(display_new_born_age_in_hrs.equals("")) {
							disable_hours = "disabled";
							disable_time = "disabled";
					} else if(age_or_dob.equals("Y") && CalledFromFunction.equals("ChangePatDtls")) {
						if( !hours_value.equals("") ) {
							disable_hours = "";
						}						
						disable_time = "disabled";
					} else {
						disable_hours = "disabled";
						disable_time = "";
					}

				
            _bw.write(_wl_block344Bytes, _wl_block344);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block345Bytes, _wl_block345);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block345Bytes, _wl_block345);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(check_age));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(disable_age));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(year_value));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(disable_age));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(month_value));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(disable_age));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(day_value));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(hours_value));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(disable_hours));
            _bw.write(_wl_block354Bytes, _wl_block354);
 if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(year_value));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(month_value));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(day_value));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(hours_value));
            _bw.write(_wl_block74Bytes, _wl_block74);
 } 
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(disable_dob));
            _bw.write(_wl_block360Bytes, _wl_block360);
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(disable_dob));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(disable_time));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(hij_appl_YN));
            _bw.write(_wl_block364Bytes, _wl_block364);

				if(hij_appl_YN.equals("Y")){ 
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(disable_dob));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(hijiri_b_date));
            _bw.write(_wl_block367Bytes, _wl_block367);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block368Bytes, _wl_block368);
}
            _bw.write(_wl_block369Bytes, _wl_block369);

					String sDate_of_birth = "";
					if (!a_date_of_birth.equals(""))
					{
							sDate_of_birth = a_date_of_birth;
							
					}
					/*Modified By Dharma on Sep 6th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724]*/
					//if(CalledFromFunction.equals("ChangePatDtls")) {
					if(CalledFromFunction.equals("ChangePatDtls") && !(checkForNull((String)hash_Map1.get("date_of_birth"))).equals("")) {
						sDate_of_birth = (String)hash_Map1.get("date_of_birth");
					
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(sDate_of_birth));
            _bw.write(_wl_block371Bytes, _wl_block371);
						
						if (!localeName.equals("en")) {
						sDate_of_birth = DateUtils.convertDate(sDate_of_birth,"DMYHMS","en",localeName); 
					
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block135Bytes, _wl_block135);

						}							
					
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(sDate_of_birth));
            _bw.write(_wl_block374Bytes, _wl_block374);

						if(hij_appl_YN.equals("Y")){
							if(hijiri_b_date.equals("")){
            _bw.write(_wl_block375Bytes, _wl_block375);
}
						}

						} else if(CalledFromFunction.equals("PatientRegistration")) { 
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(sDate_of_birth));
            _bw.write(_wl_block377Bytes, _wl_block377);

						} else if(CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) { 
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(sDate_of_birth));
            _bw.write(_wl_block379Bytes, _wl_block379);

							if(CalledFromFunction.equals("EmergencyReg")) {
								
            _bw.write(_wl_block380Bytes, _wl_block380);

							}						
						} 
					
            _bw.write(_wl_block381Bytes, _wl_block381);
	
					int count = 0;
					String dis_blood_grp = "";
					
					if(CalledFromFunction.equals("ChangePatDtls")) {							
						rs_rh = stmt_rh.executeQuery("select count(1) from bt_patient_blgrp_rh_ant where patient_id = '"+patient_id+"' ");
						if (rs_rh != null) {
								while(rs_rh.next() ) {
									count = rs_rh.getInt(1);
								}
						} rs_rh.close();								
				  }
					
				if(count > 0)
					dis_blood_grp = "disabled";								
			
            _bw.write(_wl_block382Bytes, _wl_block382);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block383Bytes, _wl_block383);
if(function_name.equals("05") && (blood_group != null || blood_group !="" || blood_group != "undefined")){
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(dis_blood_grp));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(blood_group));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(blood_group));
            _bw.write(_wl_block386Bytes, _wl_block386);
}
						else{
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(dis_blood_grp));
            _bw.write(_wl_block387Bytes, _wl_block387);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block388Bytes, _wl_block388);
}
							try {
											
								rs_rh = stmt_rh.executeQuery("select blood_grp , short_desc  from mr_blood_grp_lang_vw  where eff_status='E' AND language_id='"+localeName+"'");
								if (rs_rh != null) {
										while(rs_rh.next() ) {
											String BloodGroup = rs_rh.getString("blood_grp");
											String ShortDesc = rs_rh.getString("short_desc");
											if(CalledFromFunction.equals("ChangePatDtls")) {												
												if(BloodGroup.equals(patbloodgrp))
													selectAttribute="selected";
												else 
												selectAttribute="";	
											} 
											
											out.println("<option value ='"+BloodGroup+"' "+selectAttribute+">"+ShortDesc);
										}
								}
							}catch(Exception e) {
								out.println(e);
							} finally {
								if (rs_rh != null) rs_rh.close();								
							}
							
            _bw.write(_wl_block389Bytes, _wl_block389);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(dis_blood_grp));
            _bw.write(_wl_block391Bytes, _wl_block391);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block392Bytes, _wl_block392);

								 try {
								   rs_rh = stmt_rh.executeQuery("select rhesus_factor_code, short_desc from mr_rhesus_factor_lang_vw  where eff_status='E' and language_id='"+localeName+"'");
								   if(rs_rh != null) {
									   while(rs_rh.next()) {
										   if(CalledFromFunction.equals("ChangePatDtls")) {
											   if(rs_rh.getString("rhesus_factor_code").equals(RHfactor))
													selectAttribute1="selected";
											   else 
													selectAttribute1="";	 
										   } 
										   out.println("<option value='" + rs_rh.getString("rhesus_factor_code") + "' "+selectAttribute1+">"+ rs_rh.getString("short_desc"));
									   }
									}
								
								 }catch(Exception e) {
									out.println(e);
								 } finally {
									if (rs_rh != null) rs_rh.close();									
								 }
								 
            _bw.write(_wl_block393Bytes, _wl_block393);

							if(CalledFromFunction.equals("ChangePatDtls") || CalledFromFunction.equals("PatientRegistration"))
							{
								
							
            _bw.write(_wl_block394Bytes, _wl_block394);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block395Bytes, _wl_block395);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block396Bytes, _wl_block396);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block397Bytes, _wl_block397);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block398Bytes, _wl_block398);

							if(CalledFromFunction.equals("ChangePatDtls"))
							{
								String known_allergy_yn1 = checkForNull((String)hash_Map1.get("known_allergy_yn"));

								//String mr_install_yn = "N";
								int allergyCount = 0;

								rs_rh = stmt_rh.executeQuery("select (case when install_yn='Y' then(SELECT COUNT(*) cnt FROM PR_ALLERGY_SENSITIVITY WHERE PATIENT_ID='"+patient_id+"')end) allergyCount from sm_module where module_id = 'MR'");

								if(rs_rh!= null && rs_rh.next()) {
									//mr_install_yn = rs_rh.getString("install_yn");
									allergyCount  = rs_rh.getInt("allergyCount");
								}

								if(rs_rh!=null)
									rs_rh.close();	
								//commented as part of PE
								/*if(mr_install_yn.equals("Y")) {

									rs_rh = stmt_rh.executeQuery("SELECT COUNT(*) cnt FROM PR_ALLERGY_SENSITIVITY WHERE PATIENT_ID='"+patient_id+"'");

									if(rs_rh!=null && rs_rh.next()) {
										allergyCount = rs_rh.getInt("cnt");
									}

									if(rs_rh!=null)
										rs_rh.close();
									if(stmt_rh!=null)	
										stmt_rh.close();
								}*/
															
								
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(known_allergy_yn1));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(allergyCount));
            _bw.write(_wl_block401Bytes, _wl_block401);
}
							}
							else
							{
            _bw.write(_wl_block402Bytes, _wl_block402);
}
            _bw.write(_wl_block403Bytes, _wl_block403);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block404Bytes, _wl_block404);
if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf((String)hash_Map1.get("mar_status_desc")));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf((String)hash_Map1.get("mar_status_code")));
            _bw.write(_wl_block407Bytes, _wl_block407);
 } else { 
            _bw.write(_wl_block408Bytes, _wl_block408);
 } 
            _bw.write(_wl_block409Bytes, _wl_block409);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block410Bytes, _wl_block410);

						if(CalledFromFunction.equals("ChangePatDtls")) {
							if(!(((String)hash_Map1.get("birth_place_desc")).equals(""))) {
								birth_place_desc	= (String)hash_Map1.get("birth_place_desc");
								birth_place_code	= (String)hash_Map1.get("birth_place_code");
								birthenabledisable	= "disabled";
								//Added by Sangeetha for ML-MMOH-SCF-0717
								/*if(!(function_name.equals("03")))								
									birthenabledisable	= "disabled";*/
							}
							//Modified by Sangeetha for ML-MMOH-SCF-0717
							//if(!(((String)hash_Map1.get("place_of_birth")).equals("")) && !(function_name.equals("03"))) 
							      
								if(!(((String)hash_Map1.get("place_of_birth")).equals("")))  
								birthenabledisable1 = "disabled";
								
													
							if(!nb_birth_place_code.equals("")) {
								birth_place_desc	= nb_birth_place_desc;
								birth_place_code	= nb_birth_place_code;
								birthenabledisable	= "disabled";
								
								//Added by Sangeetha for ML-MMOH-SCF-0717								
								/*if(!(function_name.equals("03")))
									birthenabledisable	= "disabled";*/
									
							   	
							}
							
							/*Below line modified for this SCF ML-MMOH-SCF-0860*/							
							
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block65Bytes, _wl_block65);

							if(!(((String)hash_Map1.get("place_of_birth")).equals(""))) { 					place_of_birth = (String)hash_Map1.get("place_of_birth");
							} 
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(place_of_birth));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(place_of_birth));
            _bw.write(_wl_block417Bytes, _wl_block417);

						} else if ( (CalledFromFunction.equals("PatientRegistration")) || (CalledFromFunction.equals("EmergencyReg"))) { 
            _bw.write(_wl_block418Bytes, _wl_block418);
            out.print( String.valueOf(a_birth_place_desc));
            _bw.write(_wl_block419Bytes, _wl_block419);
 if(a_birth_place_code.equals("")) { 
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(a_place_of_birth));
            _bw.write(_wl_block421Bytes, _wl_block421);

							} else { 
            _bw.write(_wl_block422Bytes, _wl_block422);

							} 
						} else if(CalledFromFunction.equals("RapidReg")) { 
            _bw.write(_wl_block423Bytes, _wl_block423);

						} 
						  //End this SCF ML-MMOH-SCF-0860
						
            _bw.write(_wl_block424Bytes, _wl_block424);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);

					if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf((String)hash_Map1.get("pat_cat_desc")));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf((String)hash_Map1.get("pat_cat_code")));
            _bw.write(_wl_block407Bytes, _wl_block407);
 } else { if (entitlement_by_pat_cat_yn.equals("N"))
					{
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(patient_cat_desc));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(patient_cat_code));
            _bw.write(_wl_block428Bytes, _wl_block428);
}else {
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block430Bytes, _wl_block430);
}  }
            _bw.write(_wl_block93Bytes, _wl_block93);
if (entitlement_by_pat_cat_yn.equals("Y") || pat_category_reqd_yn.equals("Y")){
            _bw.write(_wl_block431Bytes, _wl_block431);
}else{
            _bw.write(_wl_block432Bytes, _wl_block432);
}
            _bw.write(_wl_block93Bytes, _wl_block93);
	if(CalledFromFunction.equals("ChangePatDtls"))
					{
						String pat_cat_code = checkForNull((String)hash_Map1.get("pat_cat_code"));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block434Bytes, _wl_block434);
}
            _bw.write(_wl_block435Bytes, _wl_block435);
if (entitlement_by_pat_cat_yn.equals("Y")){
            _bw.write(_wl_block436Bytes, _wl_block436);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block437Bytes, _wl_block437);
}else{
            _bw.write(_wl_block438Bytes, _wl_block438);
}
            _bw.write(_wl_block93Bytes, _wl_block93);
if(CalledFromFunction.equals("ChangePatDtls")){
				String pat_cat_code = checkForNull((String)hash_Map1.get("pat_cat_code"));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block440Bytes, _wl_block440);
}
            _bw.write(_wl_block93Bytes, _wl_block93);
if ( (CalledFromFunction.equals("ChangePatDtls")) &&(entitlement_by_pat_cat_yn.equals("Y"))){ 
				String patexpirtydate = checkForNull((String)hash_Map1.get("patexpirtydate"));
				if (!patexpirtydate.equals("") && !localeName.equals("en"))
					patexpirtydate= DateUtils.convertDate(patexpirtydate,"DMY","en",localeName);
				
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(patexpirtydate));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(patexpirtydate));
            _bw.write(_wl_block443Bytes, _wl_block443);

			} 
            _bw.write(_wl_block444Bytes, _wl_block444);
 if(CalledFromFunction.equals("ChangePatDtls")) {
					String check		= "";
					String checkNon		= "";
					String checkenable	= "";
					String enableLegal	= "";

					if(((String)hash_Map1.get("citizen_yn")).equals("Y")) check="checked";
					else checkNon="checked";

					if(!(((String)hash_Map1.get("national_id_no")).equals(""))) checkenable="disabled";
					else checkenable="";	
					
					
					
					if(!(((String)hash_Map1.get("national_id_no")).equals(""))) {
						if(((String)hash_Map1.get("citizen_yn")).equals("Y")) {
							enableLegal="disabled";
						} else {
							enableLegal="";
						}
					} else { 
						if(((String)hash_Map1.get("citizen_yn")).equals("Y")) {
							enableLegal="disabled";
						} else {
							enableLegal="";
						}
					} 	

					
            _bw.write(_wl_block445Bytes, _wl_block445);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(check));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(checkenable));
            _bw.write(_wl_block447Bytes, _wl_block447);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(checkNon));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(checkenable));
            _bw.write(_wl_block450Bytes, _wl_block450);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf((String)hash_Map1.get("citizen_yn")));
            _bw.write(_wl_block452Bytes, _wl_block452);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);
  
					check		= "";									  
					checkNon	= "";
					if(((String)hash_Map1.get("legal_yn")).equals("Y")) check = "checked";
					else checkNon = "checked";
					
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(check));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(enableLegal));
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(checkNon));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(enableLegal));
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf((String)hash_Map1.get("legal_yn")));
            _bw.write(_wl_block74Bytes, _wl_block74);
} else if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")){
            _bw.write(_wl_block445Bytes, _wl_block445);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block457Bytes, _wl_block457);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block458Bytes, _wl_block458);

								if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg") ){
            _bw.write(_wl_block459Bytes, _wl_block459);
}else{
            _bw.write(_wl_block460Bytes, _wl_block460);
}
            _bw.write(_wl_block461Bytes, _wl_block461);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block462Bytes, _wl_block462);

								if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("EmergencyReg")) { 
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(a_citizen_yn));
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(a_citizen_yn));
            _bw.write(_wl_block465Bytes, _wl_block465);
}
            _bw.write(_wl_block466Bytes, _wl_block466);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block467Bytes, _wl_block467);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block468Bytes, _wl_block468);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block469Bytes, _wl_block469);

					if(CalledFromFunction.equals("PatientRegistration")) { 
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(a_legal_yn));
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(a_legal_yn));
            _bw.write(_wl_block472Bytes, _wl_block472);

					}  
				} 
			
            _bw.write(_wl_block473Bytes, _wl_block473);
if(isNatIdOrAltIdMandVisaType){
			
            _bw.write(_wl_block474Bytes, _wl_block474);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block475Bytes, _wl_block475);
if(visa_type.equals("")){
            _bw.write(_wl_block476Bytes, _wl_block476);
}
            _bw.write(_wl_block477Bytes, _wl_block477);
if(visa_type.equals("W")){
            _bw.write(_wl_block478Bytes, _wl_block478);
}
            _bw.write(_wl_block479Bytes, _wl_block479);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block480Bytes, _wl_block480);
if(visa_type.equals("V")){
            _bw.write(_wl_block478Bytes, _wl_block478);
}
            _bw.write(_wl_block481Bytes, _wl_block481);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block482Bytes, _wl_block482);
}
            _bw.write(_wl_block483Bytes, _wl_block483);
if(isNatIdAltIdMandVisaType){ 
			
            _bw.write(_wl_block474Bytes, _wl_block474);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block475Bytes, _wl_block475);
if(visa_type.equals("")){
}
            _bw.write(_wl_block484Bytes, _wl_block484);
if(visa_type.equals("")){
            _bw.write(_wl_block485Bytes, _wl_block485);
}
            _bw.write(_wl_block486Bytes, _wl_block486);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block487Bytes, _wl_block487);
if(visa_type.equals("W")){
            _bw.write(_wl_block478Bytes, _wl_block478);
}
            _bw.write(_wl_block479Bytes, _wl_block479);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block480Bytes, _wl_block480);
if(visa_type.equals("V")){
            _bw.write(_wl_block478Bytes, _wl_block478);
}
            _bw.write(_wl_block481Bytes, _wl_block481);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block488Bytes, _wl_block488);
}
            _bw.write(_wl_block489Bytes, _wl_block489);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block490Bytes, _wl_block490);
 			

				if(CalledFromFunction.equals("ChangePatDtls") || (PatInfflag.equals("Y")) || (RapidPatInfflag.equals("Y"))) { 
					
					String chkNat = "";
					
            _bw.write(_wl_block491Bytes, _wl_block491);
            out.print( String.valueOf((String)hash_Map1.get("nationality_desc")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(chkNat));
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(chkNat));
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf((String)hash_Map1.get("nationality_code")));
            _bw.write(_wl_block407Bytes, _wl_block407);

					if(PatInfflag.equals("Y") || RapidPatInfflag.equals("Y"))
					{
					
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(checkForNull((String)hash_Map1.get("nationality_code"))));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(checkForNull((String)hash_Map1.get("nationality_desc"))));
            _bw.write(_wl_block496Bytes, _wl_block496);

					}
				} else if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg")) { 
					
					hash_Map3 = eMP.ChangePatientDetails.getCountryCodeDesc(conn, a_nationality_code, citizen_nationality_code,p);
					
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_long_desc"))));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_code"))));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_code"))));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_long_desc"))));
            _bw.write(_wl_block65Bytes, _wl_block65);

					//}
					} else if(CalledFromFunction.equals("EmergencyReg")) {
					hash_Map3 = eMP.ChangePatientDetails.getCountryCodeDesc(conn, a_nationality_code, citizen_nationality_code,p);
					
            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_long_desc"))));
            _bw.write(_wl_block501Bytes, _wl_block501);
            out.print( String.valueOf(a_nationality_code));
            _bw.write(_wl_block502Bytes, _wl_block502);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_long_desc"))));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_code"))));
            _bw.write(_wl_block503Bytes, _wl_block503);

				} 
					
            _bw.write(_wl_block504Bytes, _wl_block504);

				race_trigger = "onchange='sendToServer(14,this)'"; 
				
				 hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn,checkForNull((String)hash_Map.get("default_race_code")),p);
				 
			
            _bw.write(_wl_block505Bytes, _wl_block505);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_desc"))));
            _bw.write(_wl_block507Bytes, _wl_block507);

					
					if(race_required_yn.equals("Y"))
						race_visibility = "visibility:visible";					
					else
						race_visibility = "visibility:hidden";
					
					if(CalledFromFunction.equals("PatientRegistration")) { 
						
						if(PatInfflag.equals("Y"))
						{
							hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn, checkForNull((String)hash_Map1.get("race_code")) ,p);
							
							
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_desc"))));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf((String)hash_Map1.get("race_code")));
            _bw.write(_wl_block510Bytes, _wl_block510);

						}
						else
						{
						
						hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn,a_race_code ,p); //uncommented for HSA-SCF-0046
						
					
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_desc"))));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(a_race_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
 }
						}else if(CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) { 
							if(RapidPatInfflag.equals("Y"))
						{
							hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn, checkForNull((String)hash_Map1.get("race_code")) ,p);
														
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_desc"))));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf((String)hash_Map1.get("race_code")));
            _bw.write(_wl_block513Bytes, _wl_block513);

						}
					else
					{
				//Below Condition Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384
				if(!a_race_code.equals("")){

					hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn, a_race_code ,p);

				}else{
					hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn, default_race_code ,p);
				}
				
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_desc"))));
            _bw.write(_wl_block514Bytes, _wl_block514);
if(!a_race_code.equals("")){
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(a_race_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
}else{
            _bw.write(_wl_block516Bytes, _wl_block516);
            out.print( String.valueOf(checkForNull((String)hash_Map.get("default_race_code"))));
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block368Bytes, _wl_block368);
 } }else if(CalledFromFunction.equals("ChangePatDtls")) { 
					
				hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn, (String)hash_Map1.get("race_code") ,p);		
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_desc"))));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf((String)hash_Map1.get("race_code")));
            _bw.write(_wl_block74Bytes, _wl_block74);
 } 
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(race_visibility));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(checkForNull((String)hash_Map.get("default_race_code"))));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(race_required_yn));
            _bw.write(_wl_block520Bytes, _wl_block520);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);
if((CalledFromFunction.equals("PatientRegistration") && (PatInfflag.equals("Y"))) || (RapidPatInfflag.equals("Y"))) { 
            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf((String)hash_Map1.get("ethnic_long_desc")));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf((String)hash_Map1.get("ethnic_grp_code")));
            _bw.write(_wl_block428Bytes, _wl_block428);
}else if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf((String)hash_Map1.get("ethnic_long_desc")));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf((String)hash_Map1.get("ethnic_grp_code")));
            _bw.write(_wl_block407Bytes, _wl_block407);
 } else { 
            _bw.write(_wl_block524Bytes, _wl_block524);
 } 
            _bw.write(_wl_block525Bytes, _wl_block525);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block526Bytes, _wl_block526);
if(religion_reqd_yn.equals("Y"))
					religion_visibility = "visibility:visible";					
				else
					religion_visibility = "visibility:hidden";
             		
             		
             		
            _bw.write(_wl_block368Bytes, _wl_block368);
if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) { 
				if((CalledFromFunction.equals("PatientRegistration") && (PatInfflag.equals("Y"))) || (RapidPatInfflag.equals("Y")))
				{
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf((String)hash_Map1.get("relgn_desc")));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf((String)hash_Map1.get("relgn_code")));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(religion_visibility));
            _bw.write(_wl_block530Bytes, _wl_block530);
}
				else
				{
					
				hash_Map7 = eMP.ChangePatientDetails.getReligionDesc(conn, dflt_relgn_code,p);
					
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(checkForNull((String)hash_Map7.get("relgn_desc"))));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(checkForNull((String)hash_Map7.get("relgn_code"))));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(religion_visibility));
            _bw.write(_wl_block530Bytes, _wl_block530);
 }
				}else if(CalledFromFunction.equals("ChangePatDtls")) { 
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf((String)hash_Map1.get("relgn_desc")));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf((String)hash_Map1.get("relgn_code")));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(religion_visibility));
            _bw.write(_wl_block534Bytes, _wl_block534);
 } 
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(religion_reqd_yn));
            _bw.write(_wl_block536Bytes, _wl_block536);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);
 
				if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) { 
				if((CalledFromFunction.equals("PatientRegistration") && (PatInfflag.equals("Y"))) || (RapidPatInfflag.equals("Y")))
				{ 
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf((String)hash_Map1.get("language_desc")));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf((String)hash_Map1.get("pat_language_id")));
            _bw.write(_wl_block74Bytes, _wl_block74);
}else if(CalledFromFunction.equals("PatientRegistration") && PatInfflag.equals("") && RapidPatInfflag.equals(""))
				{
				// Code Fix Aganist Incident Number 34531 By SaanthaakumarG Dated on 10-08-2012
				
				if(!appt_ref_no.equals("")&& !language_id.equals("")){
					hash_Map4 = eMP.ChangePatientDetails.getLanguageDesc(conn,language_id,p);
				}else{
					hash_Map4 = eMP.ChangePatientDetails.getLanguageDesc(conn,dflt_language_id,p);
				}
				
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(checkForNull((String)hash_Map4.get("language_desc"))));
            _bw.write(_wl_block540Bytes, _wl_block540);
            out.print( String.valueOf(checkForNull((String)hash_Map4.get("language_id"))));
            _bw.write(_wl_block541Bytes, _wl_block541);
}else
				{
					
				hash_Map4 = eMP.ChangePatientDetails.getLanguageDesc(conn, dflt_language_id,p);
					
            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(checkForNull((String)hash_Map4.get("language_desc"))));
            _bw.write(_wl_block540Bytes, _wl_block540);
            out.print( String.valueOf(checkForNull((String)hash_Map4.get("language_id"))));
            _bw.write(_wl_block74Bytes, _wl_block74);
 
				}
				}else if(CalledFromFunction.equals("ChangePatDtls"))
				{ 
				//Issue Fix added for the Incident no : 34531 as on 10/08/2012
				/*try
					{
					lang_stmt=conn.createStatement();
					lang_rest=lang_stmt.executeQuery("select LANGUAGE_ID from mp_patient where patient_id='"+patient_id+"'");
					lang_rest.next();
					pat_lang_id=lang_rest.getString(1);
					
					lang_stmt.close();
					lang_rest.close();
					}
				catch(SQLException e)	
					{
					e.printStackTrace();
					System.out.println("Exception occurred while getting the Language ID from mp_patient "+e);
					}
				finally
					{
					try
						{
						if(lang_stmt!=null)
						lang_stmt.close();
						}
					catch(Exception e)	
						{}
					}
				hash_Map8 = eMP.ChangePatientDetails.getLanguageDesc(conn,pat_lang_id,p);
				//hash_Map1 has been changed to hash_Map8 in the below <TD>
				//End*/
				
            _bw.write(_wl_block543Bytes, _wl_block543);
            out.print( String.valueOf(checkForNull((String)hash_Map1.get("language_desc"))));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(checkForNull((String)hash_Map1.get("pat_language_id"))));
            _bw.write(_wl_block545Bytes, _wl_block545);
 } 
            _bw.write(_wl_block368Bytes, _wl_block368);

				String sel_right = "";
				String sel_left = "";
				String sel_Y = ""; //Added for MYHIX integration ML-MMOH-CRF-0507.1.
				String sel_N = ""; //Added for MYHIX integration ML-MMOH-CRF-0507.1.
				if(CalledFromFunction.equals("ChangePatDtls")) {

					String eye_indicator = checkForNull((String)hash_Map1.get("eye_indicator"));
					
					if(eye_indicator.equals("RE"))
						sel_right = "selected";
					else if(eye_indicator.equals("LE"))
						sel_left = "selected";			


					/*  block added for MYHIX integration ML-MMOH-CRF-0507.1. */
					myhix_consent = checkForNull((String)hash_Map1.get("myhix_consent"));
					myhix_pat_id = checkForNull((String)hash_Map1.get("myhix_pat_id"));
					/*  block added for NDHM integration GHL-CRF-0657.1. */ 
					ndhm_consent = checkForNull((String)hash_Map1.get("myhix_consent"));
					abha_pat_id = checkForNull((String)hash_Map1.get("myhix_pat_id"));


					
					if(myhix_consent.equals("Y")){
						sel_Y = "selected";
					}else{
						sel_N = "selected";	
					}
					/* end MYHIX block */

					if(ndhm_consent.equals("Y")){
						sel_Y = "selected";
					}else{
						sel_N = "selected";	
					}
					/* end NDHM block */
			   }
				
            _bw.write(_wl_block546Bytes, _wl_block546);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block547Bytes, _wl_block547);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(sel_right));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(sel_left));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block550Bytes, _wl_block550);

				if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("ChangePatDtls"))  { 
            _bw.write(_wl_block551Bytes, _wl_block551);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block552Bytes, _wl_block552);

					String event_value = "";
					if(Demoaddlcnt > 0) {
						event_value = "onblur='makeValidString(this);'";
					} else {
						if(CalledFromFunction.equals("ChangePatDtls") || CalledFromFunction.equals("PatientRegistration")) { 
							event_value = "onblur='makeValidString(this);'";
						} 
					}
					
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(event_value));
            _bw.write(_wl_block554Bytes, _wl_block554);
 if(disableRegnDate) {
						if(CalledFromFunction.equals("ChangePatDtls") && downtime_regn_yn.equals("Y") && checkForNull((String)hash_Map1.get("regn_date")).equals("")) {  
            _bw.write(_wl_block555Bytes, _wl_block555);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(regn_date));
            _bw.write(_wl_block557Bytes, _wl_block557);
}else{ 
            _bw.write(_wl_block551Bytes, _wl_block551);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block558Bytes, _wl_block558);
            out.print( String.valueOf(regn_date));
            _bw.write(_wl_block559Bytes, _wl_block559);
} 
					}
					else{
					
            _bw.write(_wl_block560Bytes, _wl_block560);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(regn_date));
            _bw.write(_wl_block562Bytes, _wl_block562);
 } 
            _bw.write(_wl_block563Bytes, _wl_block563);
if(CalledFromFunction.equals("ChangePatDtls")) {  
            _bw.write(_wl_block564Bytes, _wl_block564);
            out.print( String.valueOf((String)hash_Map1.get("alias_name")));
            _bw.write(_wl_block565Bytes, _wl_block565);

					}
				} else { 
            _bw.write(_wl_block566Bytes, _wl_block566);
 } 
            _bw.write(_wl_block567Bytes, _wl_block567);
 if (myhix_appl_YN.equals("Y")){
            _bw.write(_wl_block568Bytes, _wl_block568);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(sel_Y));
            _bw.write(_wl_block570Bytes, _wl_block570);
            out.print( String.valueOf(sel_N));
            _bw.write(_wl_block571Bytes, _wl_block571);
if(CalledFromFunction.equals("ChangePatDtls")) {  
            _bw.write(_wl_block572Bytes, _wl_block572);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block573Bytes, _wl_block573);
            out.print( String.valueOf(myhix_pat_id));
            _bw.write(_wl_block574Bytes, _wl_block574);
            out.print( String.valueOf(myhix_pat_id));
            _bw.write(_wl_block575Bytes, _wl_block575);
 }else{
            _bw.write(_wl_block576Bytes, _wl_block576);
}
            _bw.write(_wl_block577Bytes, _wl_block577);
}
            _bw.write(_wl_block578Bytes, _wl_block578);
 
				if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("ChangePatDtls"))  {  
			//if (ndhm_appl_YN.equals("Y")){
            _bw.write(_wl_block568Bytes, _wl_block568);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(sel_Y));
            _bw.write(_wl_block570Bytes, _wl_block570);
            out.print( String.valueOf(sel_N));
            _bw.write(_wl_block571Bytes, _wl_block571);
if(CalledFromFunction.equals("ChangePatDtls")) {  
            _bw.write(_wl_block579Bytes, _wl_block579);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block580Bytes, _wl_block580);
            out.print( String.valueOf(abha_pat_id));
            _bw.write(_wl_block581Bytes, _wl_block581);
 }else{
            _bw.write(_wl_block576Bytes, _wl_block576);
}
            _bw.write(_wl_block577Bytes, _wl_block577);
//}
			
			}
            _bw.write(_wl_block582Bytes, _wl_block582);
if(householdMonthlyIncome){ 
			if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("ChangePatDtls") || CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg") )  {
            _bw.write(_wl_block583Bytes, _wl_block583);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block584Bytes, _wl_block584);
 if(CalledFromFunction.equals("ChangePatDtls")) {  
            _bw.write(_wl_block585Bytes, _wl_block585);
            out.print( String.valueOf((String)hash_Map1.get("household_monthly_income")));
            _bw.write(_wl_block565Bytes, _wl_block565);

					}
				}} 
            _bw.write(_wl_block586Bytes, _wl_block586);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block587Bytes, _wl_block587);
if("Y".equals(blood_donor)){
            _bw.write(_wl_block171Bytes, _wl_block171);
}
            _bw.write(_wl_block588Bytes, _wl_block588);
 if(conn != null) ConnectionManager.returnConnection(conn,request); 
            _bw.write(_wl_block589Bytes, _wl_block589);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block590Bytes, _wl_block590);
            out.print( String.valueOf((String)hash_Map1.get("patient_name")));
            _bw.write(_wl_block591Bytes, _wl_block591);
 if(oth_lang) { 
            _bw.write(_wl_block592Bytes, _wl_block592);
            out.print( String.valueOf(pat_name_loc_lang));
            _bw.write(_wl_block593Bytes, _wl_block593);
            out.print( String.valueOf(pat_name_loc_lang_long));
            _bw.write(_wl_block594Bytes, _wl_block594);
 } 
            _bw.write(_wl_block595Bytes, _wl_block595);

			if(CalledFromFunction.equals("ChangePatDtls")) {  
            _bw.write(_wl_block596Bytes, _wl_block596);

			}
		
            _bw.write(_wl_block597Bytes, _wl_block597);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientSeries.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PrefFacility.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deceased.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FormNo60.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.GCC.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.GCC.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ValidatePAN.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primary.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.GenerateOTP.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.EnterOTP.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.pancardrelation.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.self.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Father.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mother.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.guardian.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.pancardrelation.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.self.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Father.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mother.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.guardian.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UpdateDownloadHealthID.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LinkHealthID.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AadhaarValidated.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ABHANumber.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Unlink.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ABHANumber.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Unlink.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ABHANumber.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Unlink.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ABHANumber.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Unlink.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.membership.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.organizationmember.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedmemberfamily.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedmembernonfamily.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.nonorganizationmember.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Organization.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.HeadofFamilyPatientID.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.HeadofFamilyPatientName.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RelationshiptoHeadofFamily.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Hijri.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RHDFactor.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.KnownAllergy.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.maritalstatus.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.legal.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.illegal.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.legal.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.illegal.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VisaType.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Work.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Visit.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VisaType.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ResidentWork.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Visit.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }

    private boolean _jsp__tag97(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag97 = null ;
        int __result__tag97 = 0 ;

        if (__tag97 == null ){
            __tag97 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag97);
        }
        __tag97.setPageContext(pageContext);
        __tag97.setParent(null);
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag97;
        __result__tag97 = __tag97.doStartTag();

        if (__result__tag97!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag97== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag97.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag97);
            return true;
        }
        _activeTag=__tag97.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag97);
        __tag97.release();
        return false;
    }

    private boolean _jsp__tag98(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag98 = null ;
        int __result__tag98 = 0 ;

        if (__tag98 == null ){
            __tag98 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag98);
        }
        __tag98.setPageContext(pageContext);
        __tag98.setParent(null);
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag98;
        __result__tag98 = __tag98.doStartTag();

        if (__result__tag98!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag98== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag98.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag98);
            return true;
        }
        _activeTag=__tag98.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag98);
        __tag98.release();
        return false;
    }

    private boolean _jsp__tag99(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag99 = null ;
        int __result__tag99 = 0 ;

        if (__tag99 == null ){
            __tag99 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag99);
        }
        __tag99.setPageContext(pageContext);
        __tag99.setParent(null);
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ethnicity.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag99;
        __result__tag99 = __tag99.doStartTag();

        if (__result__tag99!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag99== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag99.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag99);
            return true;
        }
        _activeTag=__tag99.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag99);
        __tag99.release();
        return false;
    }

    private boolean _jsp__tag100(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag100 = null ;
        int __result__tag100 = 0 ;

        if (__tag100 == null ){
            __tag100 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag100);
        }
        __tag100.setPageContext(pageContext);
        __tag100.setParent(null);
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.religion.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag100;
        __result__tag100 = __tag100.doStartTag();

        if (__result__tag100!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag100== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag100.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag100);
            return true;
        }
        _activeTag=__tag100.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag100);
        __tag100.release();
        return false;
    }

    private boolean _jsp__tag101(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag101 = null ;
        int __result__tag101 = 0 ;

        if (__tag101 == null ){
            __tag101 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag101);
        }
        __tag101.setPageContext(pageContext);
        __tag101.setParent(null);
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Language.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag101;
        __result__tag101 = __tag101.doStartTag();

        if (__result__tag101!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag101== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag101.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag101);
            return true;
        }
        _activeTag=__tag101.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag101);
        __tag101.release();
        return false;
    }

    private boolean _jsp__tag102(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag102 = null ;
        int __result__tag102 = 0 ;

        if (__tag102 == null ){
            __tag102 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag102);
        }
        __tag102.setPageContext(pageContext);
        __tag102.setParent(null);
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OneEye.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag102;
        __result__tag102 = __tag102.doStartTag();

        if (__result__tag102!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag102== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag102.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag102);
            return true;
        }
        _activeTag=__tag102.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag102);
        __tag102.release();
        return false;
    }

    private boolean _jsp__tag103(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag103 = null ;
        int __result__tag103 = 0 ;

        if (__tag103 == null ){
            __tag103 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag103);
        }
        __tag103.setPageContext(pageContext);
        __tag103.setParent(null);
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag103;
        __result__tag103 = __tag103.doStartTag();

        if (__result__tag103!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag103== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag103.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag103);
            return true;
        }
        _activeTag=__tag103.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag103);
        __tag103.release();
        return false;
    }

    private boolean _jsp__tag104(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag104 = null ;
        int __result__tag104 = 0 ;

        if (__tag104 == null ){
            __tag104 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag104);
        }
        __tag104.setPageContext(pageContext);
        __tag104.setParent(null);
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OneRightEye.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag104;
        __result__tag104 = __tag104.doStartTag();

        if (__result__tag104!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag104== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag104.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag104);
            return true;
        }
        _activeTag=__tag104.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag104);
        __tag104.release();
        return false;
    }

    private boolean _jsp__tag105(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag105 = null ;
        int __result__tag105 = 0 ;

        if (__tag105 == null ){
            __tag105 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag105);
        }
        __tag105.setPageContext(pageContext);
        __tag105.setParent(null);
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OneLeftEye.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag105;
        __result__tag105 = __tag105.doStartTag();

        if (__result__tag105!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag105== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag105.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag105);
            return true;
        }
        _activeTag=__tag105.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag105);
        __tag105.release();
        return false;
    }

    private boolean _jsp__tag106(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag106 = null ;
        int __result__tag106 = 0 ;

        if (__tag106 == null ){
            __tag106 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag106);
        }
        __tag106.setPageContext(pageContext);
        __tag106.setParent(null);
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AliasName.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag106;
        __result__tag106 = __tag106.doStartTag();

        if (__result__tag106!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag106== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag106.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag106);
            return true;
        }
        _activeTag=__tag106.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag106);
        __tag106.release();
        return false;
    }

    private boolean _jsp__tag107(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag107 = null ;
        int __result__tag107 = 0 ;

        if (__tag107 == null ){
            __tag107 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag107);
        }
        __tag107.setPageContext(pageContext);
        __tag107.setParent(null);
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegistrationDate.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag107;
        __result__tag107 = __tag107.doStartTag();

        if (__result__tag107!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag107== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag107.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag107);
            return true;
        }
        _activeTag=__tag107.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag107);
        __tag107.release();
        return false;
    }

    private boolean _jsp__tag108(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag108 = null ;
        int __result__tag108 = 0 ;

        if (__tag108 == null ){
            __tag108 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag108);
        }
        __tag108.setPageContext(pageContext);
        __tag108.setParent(null);
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag108;
        __result__tag108 = __tag108.doStartTag();

        if (__result__tag108!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag108== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag108.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag108);
            return true;
        }
        _activeTag=__tag108.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag108);
        __tag108.release();
        return false;
    }

    private boolean _jsp__tag109(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag109 = null ;
        int __result__tag109 = 0 ;

        if (__tag109 == null ){
            __tag109 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag109);
        }
        __tag109.setPageContext(pageContext);
        __tag109.setParent(null);
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegistrationDate.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag109;
        __result__tag109 = __tag109.doStartTag();

        if (__result__tag109!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag109== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag109.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag109);
            return true;
        }
        _activeTag=__tag109.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag109);
        __tag109.release();
        return false;
    }

    private boolean _jsp__tag110(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag110 = null ;
        int __result__tag110 = 0 ;

        if (__tag110 == null ){
            __tag110 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag110);
        }
        __tag110.setPageContext(pageContext);
        __tag110.setParent(null);
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag110;
        __result__tag110 = __tag110.doStartTag();

        if (__result__tag110!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag110== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag110.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag110);
            return true;
        }
        _activeTag=__tag110.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag110);
        __tag110.release();
        return false;
    }

    private boolean _jsp__tag111(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag111 = null ;
        int __result__tag111 = 0 ;

        if (__tag111 == null ){
            __tag111 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag111);
        }
        __tag111.setPageContext(pageContext);
        __tag111.setParent(null);
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegistrationDate.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag111;
        __result__tag111 = __tag111.doStartTag();

        if (__result__tag111!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag111== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag111.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag111);
            return true;
        }
        _activeTag=__tag111.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag111);
        __tag111.release();
        return false;
    }

    private boolean _jsp__tag112(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag112 = null ;
        int __result__tag112 = 0 ;

        if (__tag112 == null ){
            __tag112 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag112);
        }
        __tag112.setPageContext(pageContext);
        __tag112.setParent(null);
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag112.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag112;
        __result__tag112 = __tag112.doStartTag();

        if (__result__tag112!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag112== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag112.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag112);
            return true;
        }
        _activeTag=__tag112.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag112);
        __tag112.release();
        return false;
    }

    private boolean _jsp__tag113(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag113 = null ;
        int __result__tag113 = 0 ;

        if (__tag113 == null ){
            __tag113 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag113);
        }
        __tag113.setPageContext(pageContext);
        __tag113.setParent(null);
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ConsentforMyHIX.label", java.lang.String .class,"key"));
        __tag113.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag113;
        __result__tag113 = __tag113.doStartTag();

        if (__result__tag113!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag113== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag113.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag113);
            return true;
        }
        _activeTag=__tag113.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag113);
        __tag113.release();
        return false;
    }

    private boolean _jsp__tag114(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag114 = null ;
        int __result__tag114 = 0 ;

        if (__tag114 == null ){
            __tag114 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag114);
        }
        __tag114.setPageContext(pageContext);
        __tag114.setParent(null);
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MyHIXGlobalID.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag114;
        __result__tag114 = __tag114.doStartTag();

        if (__result__tag114!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag114== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag114.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag114);
            return true;
        }
        _activeTag=__tag114.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag114);
        __tag114.release();
        return false;
    }

    private boolean _jsp__tag115(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag115 = null ;
        int __result__tag115 = 0 ;

        if (__tag115 == null ){
            __tag115 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag115);
        }
        __tag115.setPageContext(pageContext);
        __tag115.setParent(null);
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ConsentforNDHM.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag115;
        __result__tag115 = __tag115.doStartTag();

        if (__result__tag115!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag115== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag115.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag115);
            return true;
        }
        _activeTag=__tag115.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag115);
        __tag115.release();
        return false;
    }

    private boolean _jsp__tag116(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag116 = null ;
        int __result__tag116 = 0 ;

        if (__tag116 == null ){
            __tag116 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag116);
        }
        __tag116.setPageContext(pageContext);
        __tag116.setParent(null);
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ABHANumber.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag116;
        __result__tag116 = __tag116.doStartTag();

        if (__result__tag116!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag116== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag116.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag116);
            return true;
        }
        _activeTag=__tag116.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag116);
        __tag116.release();
        return false;
    }

    private boolean _jsp__tag117(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag117 = null ;
        int __result__tag117 = 0 ;

        if (__tag117 == null ){
            __tag117 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag117);
        }
        __tag117.setPageContext(pageContext);
        __tag117.setParent(null);
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.HouseholdMonthlyIncome.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag117;
        __result__tag117 = __tag117.doStartTag();

        if (__result__tag117!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag117== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag117.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag117);
            return true;
        }
        _activeTag=__tag117.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag117);
        __tag117.release();
        return false;
    }

    private boolean _jsp__tag118(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag118 = null ;
        int __result__tag118 = 0 ;

        if (__tag118 == null ){
            __tag118 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag118);
        }
        __tag118.setPageContext(pageContext);
        __tag118.setParent(null);
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BloodDonor.label", java.lang.String .class,"key"));
        __tag118.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag118;
        __result__tag118 = __tag118.doStartTag();

        if (__result__tag118!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag118== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag118.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag118);
            return true;
        }
        _activeTag=__tag118.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag118);
        __tag118.release();
        return false;
    }
}
