package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __pline extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/pline.jsp", 1742809832358L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n        <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t    <script src=\'../../eMP/js/PatEncBanner.js\' language=\'javascript\'></script>\n\t    <script src=\'../../eXH/js/ExternalApplication.js\' language=\'javascript\'></script>\n\t    <script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body onKeyDown=\"lockKey()\" OnMouseDown=\'CodeArrest()\'>\n\t\t<form name=\'patLineForm\' id=\'patLineForm\'>\n\t\t\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' height=\'44\' width=\'1024\' bgcolor=\"#fff791\">\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\n\t\t\t</table>\n\t\t\t<!--Below line was added by Suresh.M on 14-Aug-2012  against  SKR-SCF-0631 [IN035065]-->\n\t\t\t <input type = \'hidden\' name=\'Remarks\' id=\'Remarks\' value = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'> \n\t\t\t <input type = \'hidden\' name=\'visit_date_time\' id=\'visit_date_time\' value = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'> \n\t\t\t <input type = \'hidden\' name=\'TOOL_TIP_TEXT\' id=\'TOOL_TIP_TEXT\' value = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t<!--end-->\n\t\t\t\n\t\t\t<!--Added for ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-00601--> \n            <input type=\"hidden\" name=\"increasedaddressLength\" id=\"increasedaddressLength\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"> \n            <input type=\"hidden\" name=\"alterAddressApplicable\" id=\"alterAddressApplicable\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"> \n\t\t\t<input type=\"hidden\" name=\"isDiscRefCountApplicable\" id=\"isDiscRefCountApplicable\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">  \n\t\t\t<input type=\"hidden\" name=\"disc_sum_count\" id=\"disc_sum_count\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<input type=\"hidden\" name=\"ref_sum_count\" id=\"ref_sum_count\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n            <input type=\"hidden\" name=\"cdrCount\" id=\"cdrCount\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"> \n            <input type=\"hidden\" name=\"practEnableCDR\" id=\"practEnableCDR\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"> \n            <input type=\"hidden\" name=\"workStationId\" id=\"workStationId\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"> \n            <!--End ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-0601-->\n\t    <input type=\"hidden\" name=\"isFPPDisplayApplicable\" id=\"isFPPDisplayApplicable\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"> <!--Added by Kamatchi S for ML-MMOH-CRF-1182-->\n\t    <input type=\"hidden\" name=\"isArchivalDisplayApplicable\" id=\"isArchivalDisplayApplicable\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"> <!--Added by Prakash for PMG2023-COMN-CRF-0002.4-->\t\n\t\t</form>\n\t</body>\n</html>\n<script>\n    var classValue = \"NORMPATLINE\";\n\tif(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' == \'Y\') classValue = \'DECEASEDPATLINE\';\n\telse classValue = \"NORMPATLINE\";\n\tif(document.getElementById(\'tdLine1\') != null)\n\t\tdocument.getElementById(\'tdLine1\').className = classValue;\n\tif(document.getElementById(\'tdLine2\') != null)\n\t\tdocument.getElementById(\'tdLine2\').className = classValue;\n\tif(document.getElementById(\'tdPhoto\') != null)\n\t\tdocument.getElementById(\'tdPhoto\').className = classValue;\n\tif(document.getElementById(\'FINANCIAL\') != null)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' == \"Y\" && \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' != \"\")\n\t\t{\n\t\t\tdocument.getElementById(\'FINANCIAL\').style.cursor = \'pointer\';\n\t\t\t\n\t\t\tdocument.getElementById(\'FINANCIAL\').addEventListener(\"click\",function(){ViewBLDtl(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\",\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\")});\n\t\t}\t\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\"FINANCIAL\").style.display = \'none\';\n\t\t}\n\t}\n\n\t\n\tif(document.getElementById(\'PAT_PROFILE\') != null)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' == \'A\')\n\t\t{\n\t\t\tdocument.getElementById(\"PAT_PROFILE\").style.cursor = \'pointer\';\n\t\t\tdocument.getElementById(\"PAT_PROFILE\").addEventListener(\"click\",function(){callPatientProfile(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\")});\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\"PAT_PROFILE\").style.display = \'none\';\n\t\t}\n\t}\n\t\n\tif(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' == \'A\')\n\t{\n\t\tif(document.getElementById(\"PAT_ALERTS_ALLERGY\") != null )\n\t\t{\n\t\t\tif((\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' == \'Y\') || (\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' == \'Y\'))\n\t\t\t{\n\t\t\t\t//Added by Sangeetha for ML-MMOH-CRF-0692 on 27/07/17\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' == \'true\')\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"PAT_ALERTS_ALLERGY\").innerHTML=\"<img src=\'../../eCommon/images/PI_Allergies.gif\'><span style=\'color:red;font-weight:bold;font-size:14px\'>\"+getLabel(\"Common.KnownAllergy.label\",\"Common\")+\"</span>\";\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\"PAT_ALERTS_ALLERGY\").style.cursor = \'pointer\';\n\t\t\t\tdocument.getElementById(\"PAT_ALERTS_ALLERGY\").addEventListener(\"click\",function(){callAllery(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')});\n\t\t\t}\n\t\t\telse if((\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' == \'N\') && (\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' == \'N\'))\n\t\t\t{\n\t\t\t\t//document.getElementById(\"PAT_ALERTS_ALLERGY\").style.display = \'none\';\n\t\t\t\t//Added by Sangeetha for ML-MMOH-CRF-0692 on 27/07/17\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' == \'true\')\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"PAT_ALERTS_ALLERGY\").innerHTML=\"<img src=\'../../eCommon/images/PI_Allergies_Gray.gif\'><span style=\'color:black;font-weight:bold;font-size:14px\'>\"+getLabel(\"Common.no.label\",\"Common\")+ \" \" +getLabel(\"Common.KnownAllergy.label\",\"Common\")+\"</span>\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"PAT_ALERTS_ALLERGY\").innerHTML=\"<img src=\'../../eCommon/images/PI_Allergies_Gray.gif\'>\";\n\t\t\t\t}\n\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"PAT_ALERTS_ALLERGY\").style.display = \'none\';\n\t\t\t}\n\t\t}\n\t}\n\tif(document.getElementById(\"PAT_CLIN_RSRCH_CAT\") != null)\n\t{\n\t\tif(";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" > 0 )\n\t\t{\n\t\t\tdocument.getElementById(\"PAT_CLIN_RSRCH_CAT\").style.cursor = \'pointer\';\n\t\t\tdocument.getElementById(\"PAT_CLIN_RSRCH_CAT\").addEventListener(\"click\",function(){return researchPatient(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\')});\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\"PAT_CLIN_RSRCH_CAT\").style.display = \'none\';\n\t\t}\n\t}\n\n\tif(document.getElementById(\"PAT_PHOTO\") != null)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' != \"\")\n\t\t{\t\t\t\n\t\t\tif(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'==\"Y\" ){\n\t\t\t\t\tdocument.getElementById(\"PAT_PHOTO\").style.cursor = \'pointer\';\t\t\t\n\t\t\t\t\tdocument.getElementById(\"PAT_PHOTO\").addEventListener(\"click\",function(){ showPatientImage(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\')});\n\t\t\t\t\tdocument.getElementById(\"PAT_PHOTO\").innerHTML= \'<img id=\"patient_photo\" src = \"../../eMP/jsp/PaintImage.jsp?patient_id=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&pat_photo_in_db_yn=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&pat_photo_http_path=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" height=\"45\" width=\"50\" border = \"2\">\';\t\t\t\t\n\n\t\t\t\tif(";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" > ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" && ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" !=0) { \n\t\t\t\t\tdocument.getElementById(\"patient_photo\").style.filter=\"alpha(opacity=20)\";\t\t\t\t\t \n\t\t\t\t}\t\t\t\t\n\t\t\t\tdocument.getElementById(\"patient_photo\").style.border = \'2px solid black\';\n\t\t\t}else if(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'==\"N\" && \'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'==\'Y\'){\n\t\t\t\t\tdocument.getElementById(\"PAT_PHOTO\").style.cursor = \'pointer\';\t\t\t\n\t\t\t\t\tdocument.getElementById(\"PAT_PHOTO\").addEventListener(\"click\",function(){ showPatientImage(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" height=\"45\" width=\"20\">\';\t\n\t\t\t\tif(";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" !=0) {\n\t\t\t\t\tdocument.getElementById(\"patient_photo\").style.filter=\"alpha(opacity=20)\";\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\"patient_photo\").style.border = \'2px solid black\';\n\t\t\t}\n\t\t}\n\t\t/* else\n\t\t{\n\t\t\tdocument.getElementById(\"PAT_PHOTO\").style.display = \'none\';\n\t\t\tif(document.getElementById(\"tdPhoto\") != null)\n\t\t\t\tdocument.getElementById(\"tdPhoto\").style.display = \'none\';\n\t\t} */\n\t}\n\n\tif(document.getElementById(\"DEACTIVATED\") != null)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' == \'N\')\n\t\t\tdocument.getElementById(\"DEACTIVATED\").style.display = \'inline\';\n\t\telse\n\t\t\tdocument.getElementById(\"DEACTIVATED\").style.display = \'none\';\n\t}\n\n\tif(document.getElementById(\"SUSPENDED\") != null)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' == \'Y\')\n\t\t\tdocument.getElementById(\"SUSPENDED\").style.display = \'inline\';\n\t\telse\n\t\t\tdocument.getElementById(\"SUSPENDED\").style.display = \'none\';\n\t}\n\n\tif(document.getElementById(\"PATIENT_NAME\") != null)\n\t{\n\t\tdocument.getElementById(\"PATIENT_NAME\").style.cursor = \'pointer\';\n\t\tdocument.getElementById(\"PATIENT_NAME\").style.color = \'BLUE\';\n\t\t//document.getElementById(\"PATIENT_NAME\").addEventListener(\"onmouseover\",function(){ dispPatName()});\n\t\t//document.getElementById(\"PATIENT_NAME\").addEventListener(\"click\",function(){ callDemographics(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\')});\n\t\tdocument.getElementById(\"PATIENT_NAME\").addEventListener(\"click\",function(){ callDemographics(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\')});\n\t\t\n\t\tif(\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"==\"\"){\n\t\t\tif(document.getElementById(\"long_name\"))\n\t\t\t\tdocument.getElementById(\"long_name\").style.display = \'none\';\n\t\t}else{\n\t\t\t//document.getElementById(\"lng_name\").style.cursor = \'arrow\';\n\t\t\tif(document.getElementById(\"long_name\"))\n\t\t\t\tdocument.getElementById(\"long_name\").title=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\t}\n\t\t\n\t}\n\t\n\tif(document.getElementById(\"PAT_NAME_LOCAL_LANG\") != null){\n\t\tif(\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"==\"\"){\n\t\t\tif(document.getElementById(\"long_name_loc\"))\n\t\t\t\tdocument.getElementById(\"long_name_loc\").style.display = \'none\';\n\t\t}else{\n\t\t\t//document.getElementById(\"lng_name_loc\").style.cursor = \'pointer\';\n\t\t\tif(document.getElementById(\"long_name_loc\"))\n\t\t\t\tdocument.getElementById(\"long_name_loc\").title=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t}\n\t}\n  // alert(document.getElementById(\"VIP_PAT\"));alert(vipYN);\n\tif(document.getElementById(\"VIP_PAT\") != null)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' == \'Y\')\n\t\t\tdocument.getElementById(\"VIP_PAT\").style.display = \'inline\';\n\t\telse\n\t\t\tdocument.getElementById(\"VIP_PAT\").style.display = \'none\';\n\t}\n\n\tif(document.getElementById(\"FINANCIAL\") != null)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' == \'Y\')\n\t\t\tdocument.getElementById(\"FINANCIAL\").style.display = \'inline\';\n\t\telse\n\t\t\tdocument.getElementById(\"FINANCIAL\").style.display = \'none\';\n\t}\n\n\tif(document.getElementById(\"DIAGNOSIS\") != null)\n\t{\n\t\tdocument.getElementById(\"DIAGNOSIS\").style.cursor = \'pointer\';\n\t\tdocument.getElementById(\"DIAGNOSIS\").addEventListener(\"click\",function(){ callDiagnosis(\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\',\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\')});\n\t}\n\n\t//Added the below code for RUT-CRF-0016 IN023399 on 01.05.2012 by Suresh M\n\tif(document.getElementById(\"FREE_TEXT\") != null){ \t\t \n\n\t\tif(document.getElementById(\"Remarks\").value !=\"\"){\t\t\t\n\t\t\tdocument.getElementById(\"FREE_TEXT\").style.cursor = \'pointer\';\n\t\t\tdocument.getElementById(\"FREE_TEXT\").addEventListener(\"click\",function(){ callRemarks(decodeURIComponent(document.getElementById(\"Remarks\").value,\'UTF-8\'))});\n\t\t} else {\n\t\t\tdocument.getElementById(\"FREE_TEXT\").style.display = \'none\';\n\t\t}\n\t\n\t}\n\n\tif(document.getElementById(\"RIGHT_EYE\") != null || document.getElementById(\"LEFT_EYE\") != null)\n\t{  \t\t\n\t\tif(\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' == \'RE\') { \t\t\t\n\t\t\tif(document.getElementById(\"LEFT_EYE\") != null)document.getElementById(\"LEFT_EYE\").innerHTML=\"\";\n\t\t}else if(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' == \'LE\'){  \n\t\t\tif(document.getElementById(\"RIGHT_EYE\") != null)document.getElementById(\"RIGHT_EYE\").innerHTML=\"\";\n\t\t} else {  \n\t\t\tif(document.getElementById(\"LEFT_EYE\") != null)document.getElementById(\"LEFT_EYE\").innerHTML=\"\";\n\t\t\tif(document.getElementById(\"RIGHT_EYE\") != null)document.getElementById(\"RIGHT_EYE\").innerHTML=\"\";\n\t\t}\n\t}\n\n\tif(document.getElementById(\"BIRTH_DAY\") != null )\n\t{ \t\t \n\t\tif(\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' == \'\' && (\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' != \'\'  || \'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' != \'\' )) {  \n\t\t\tdocument.getElementById(\"BIRTH_DAY\").style.display = \'inline\';\t\t\t \n\t\t}\n\t\telse{  \t\t\t \n\t\t\tdocument.getElementById(\"BIRTH_DAY\").style.display = \'none\';\n\t\t}\n\t} \t \n\n\tif(document.getElementById(\"SURGERY\") != null)\n\t{\t\t\t\n\t\tif(\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' > 0){  \t\t\t\n\t\t   document.getElementById(\"SURGERY\").style.cursor = \'pointer\';\n\t\t   document.getElementById(\"SURGERY\").addEventListener(\"click\",function(){ callProcedureDetails(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\')});\n\t\t}else{\n\t\t\tdocument.getElementById(\"SURGERY\").style.display = \'none\';\n\t\t}\n\t}\n\n\tif(document.getElementById(\"PAT_NOTES\") != null)\t{\t\n\t\tif(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' > 0){ \t\n\t\t\tdocument.getElementById(\"PAT_NOTES\").innerHTML = \"<span class=\'image\' title=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' id=\'PAT_NOTES\' style = \'cursor:pointer\' onclick = patientNotes(\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\') ><img src=\'../../eCommon/images/DataNotes.png\'></span>\";\t\t\t\t\t\n\t\t}else{\n\t\t\tdocument.getElementById(\"PAT_NOTES\").style.cursor = \'pointer\';\t\t\n\t\t    document.getElementById(\"PAT_NOTES\").addEventListener(\"click\",function(){patientNotes(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\')});\t\n\t\t}\t\n\t}\n    /*Below line added for this CRF ML-MMOH-CRF-0780*/\n   if(document.getElementById(\"NEXT_OF_KIN\")!=null){\t  \n\t\tif(\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' > 0){\n\t\t   document.getElementById(\"NEXT_OF_KIN\").innerHTML = \"\";\n\t\t}else{\t   \n\t\t   //document.getElementById(\"NEXT_OF_KIN\").style.cursor = \'pointer\';\n\t\t   document.getElementById(\'NEXT_OF_KIN\').innerHTML = \"<span title=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' id=\'nextofkin_blinker\'style=\'color:red;font-size:16px\'><img src=\'../../eCommon/images/NextofKin.png\'></span>\";\t\t   \n\t\t}\t\n\n       \t\t\n\t}\t\n\t//End this CRF ML-MMOH-CRF-0780\n\n\tif(document.getElementById(\'MYHIX_VIEW\') != null) //Added for MYHIX integration ML-MMOH-CRF-0507.1\n\t{\t\t\t\n\t\tif(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' ==\'Y\' && \'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' ==\'Y\'){\n\t\t\tif(document.getElementById(\'isDiscRefCountApplicable\').value==\"true\") // added by mujafar for ML-MMOH-CRF-1130.1 START\n\t\t\t{\n\t\t\tvar temp = \"<b><font size=\'1\'>\";\n\t\t\tif(document.getElementById(\'disc_sum_count\').value!=\"\")\n\t\t\t\ttemp=temp+\" \"+\"DS:\"+document.getElementById(\'disc_sum_count\').value;\n\t\t\tif(document.getElementById(\'ref_sum_count\').value!=\"\")\n\t\t\t\ttemp=temp+\" \"+\"RS:\"+document.getElementById(\'ref_sum_count\').value;\n\t\t\t  temp = temp+\"</font></b>\";\n\t\t\tdocument.getElementById(\"MYHIX_VIEW\").innerHTML = document.getElementById(\"MYHIX_VIEW\").innerHTML+temp; // added by mujafar for ML-MMOH-CRF-1130.1 END\n\t\t\tdocument.getElementById(\"MYHIX_VIEW\").style.cursor = \'pointer\';\n\t\t\tdocument.getElementById(\"MYHIX_VIEW\").addEventListener(\"click\",function(){ callMyHix(\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\')});\n\t\t\t} \n\t\t\telse\n\t\t\t{\n\t\t\tdocument.getElementById(\'MYHIX_VIEW\').innerHTML = document.getElementById(\'MYHIX_VIEW\').innerHTML;\n\t\t\tdocument.getElementById(\"MYHIX_VIEW\").style.cursor = \'pointer\';\n\t\t\tdocument.getElementById(\"MYHIX_VIEW\").addEventListener(\"click\",function(){ callMyHix(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\')});\t\n\t\t\t} // added by mujafar for ML-MMOH-CRF-1130.1 END\n\t\t}else{\n\t\t\tdocument.getElementById(\'MYHIX_VIEW\').style.visibility = \'hidden\';\n\t\t}\n\t}\t\n\t\n\t/*Added by Thamizh selvi on 4th June 2018 against MMS-DM-CRF-0115 Start*/\n\tif(document.getElementById(\"CDR\") != null && (\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' == \"Y\" && \"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"==\"Y\")){\n\t\tif(\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' > 0)\t{\n\t\t\tdocument.getElementById(\"CDR\").style.cursor = \'pointer\';\n\t\t\t//document.getElementById(\"CDR\").addEventListener(\"click\",function(){callClinicalDataRepository(\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\")});\n\t\t\tdocument.getElementById(\"CDR\").addEventListener(\"click\",function(){callClinicalDataRepository(\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\")});\n\t\t}else{\n\t\t\t\n\t\t\t\n\t\t\tdocument.getElementById(\'CDR\').innerHTML = \"<span class=\'image\' title=\'\"+getLabel(\"Common.CDRNoData.label\",\"Common\")+\"\' id=\'CDR\'><img src=\'../../eCommon/images/CDR_NoData.PNG\'></span>\";\n\t\t}\n\t}else if(document.getElementById(\'CDR\') != null){\n\t\tdocument.getElementById(\'CDR\').style.visibility = \'hidden\';\n\t}\n\t/*End*/\n\n\t/*Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1117 Start*/\n\tif(document.getElementById(\'HIST_ALLERGY\') != null)\n\t{\t\t\t\n\t\tif(!(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' > 0))\n\t\t\tdocument.getElementById(\'HIST_ALLERGY\').style.visibility = \'hidden\';\n\t}/*End*/\t\n\t\n\t/*below line added for this CRF Bru-HIMS-CRF-411*/\n\t\t\n\tif(document.getElementById(\"LENGTH_OF_STAY\") != null && \'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'==\"\")\n\t{   \t\n\tdocument.getElementById(\"LENGTH_OF_STAY\").innerHTML=\"\"; \t\t\t \n\t}\t\n    //End Bru-HIMS-CRF-411\t\n\n\t/*Added by Ashwini on 09-Sep-2019 for ML-MMOH-CRF-1158*/\n\tif(document.getElementById(\"MORSE_FALL_SCALE\") && document.getElementById(\"MORSE_FALL_SCALE\") != null)\n\t{\n\t\tvar MFSScoreValue = \'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\';\n\n\t\tif(MFSScoreValue.indexOf(\"24\") != -1)\n\t\t{\n\t\t\tdocument.getElementById(\"MORSE_FALL_SCALE\").innerHTML = \"<span class=\'image\' id=\'MORSE_FALL_SCALE\'><img src=\'../../eCommon/images/Fall_Low_risk.png\'></span>\";\n\t\t}\n\t\telse if(MFSScoreValue.indexOf(\"44\") != -1)\n\t\t{\n\t\t\tdocument.getElementById(\"MORSE_FALL_SCALE\").innerHTML = \"<span class=\'image\' id=\'MORSE_FALL_SCALE\'><img src=\'../../eCommon/images/Fall_moderate_risk.png\'></span>\";\n\t\t}\n\t\telse if(MFSScoreValue.indexOf(\"45\") != -1)\n\t\t{\n\t\t\tdocument.getElementById(\"MORSE_FALL_SCALE\").innerHTML = \"<span class=\'image\' id=\'MORSE_FALL_SCALE\'><img src=\'../../eCommon/images/Fall_high_risk.png\'></span>\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\"MORSE_FALL_SCALE\").style.visibility = \'hidden\';\n\t\t}\n\t}else\n\t{\n\t\tif (document.getElementById(\"MORSE_FALL_SCALE\"))\n\t\t{\n\t\t\tdocument.getElementById(\"MORSE_FALL_SCALE\").style.visibility = \'hidden\';\n\t\t}\n\t}\n\t/*End ML-MMOH-CRF-1158*/\n\t\n\t/*Modified By Dharma Start*/\n/*Added by Rameswar on 15-Jun-16 for AAKH-CRF-0083 -Start*/\n\tif(document.getElementById(\'HAAD_DISEASE\') != null)\n\t{\n\n\t\tvar patientId = \'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\';\n\t\tvar spanElement ;\n\t\tvar temp;\n\t\tvar COLOR_CODE =\"\";\n\t\tvar DISEASE_NAME =\"\";\n\t\tvar docElement ;\n\t\tvar data;\n\t\tif(patientId!=\"\"){\n\t\t\t\tdata = \'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\';\n\t\t\t\tif(data!=\'\'){\n\t\t\t\t\tspanElement = data.split(\'|\');\n\t\t\t\t\t\n\t\t\t\t\tfor(i=0;i<spanElement.length-1;i++){\n\t\t\t\t\t\t\ttemp=spanElement[i].split(\'~\');\n\t\t\t\t\t\t\tDISEASE_NAME = temp[0];\n\t\t\t\t\t\t\tCOLOR_CODE\t= temp[1];\n\t\t\t\t\t\t\tdocElement = eval(document.getElementById(\"dis\"+i));\n\t\t\t\t\t\n\t\t\t\t\t\t\tdocElement.style.width=\"10px\";\n\t\t\t\t\t\t\tdocElement.style.height=\"15px\";\n\t\t\t\t\t\t\tdocElement.style.border=\"1px solid\";\n\t\t\t\t\t\t\tdocElement.style.backgroundColor=$.trim(COLOR_CODE);\n\t\t\t\t\t\t\tdocElement.title=$.trim(DISEASE_NAME);\t\t\t\t\n\t\t\t\t\t\t}\t\n\t\t\t\t}\t\n\t\t}\n\t} /*Added by Rameswar on 15-Jun-16 for AAKH-CRF-0083 - End*/\n\n\tif(document.getElementById(\'NUHDEEK_ID\') != null)\t{\t\n\t\tif(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' !=\"\"){\n\t\t\tdocument.getElementById(\'NUHDEEK_ID\').innerHTML = \"<span class=\'image\' title=\'Nuhdeek\' id=\'NUHDEEK_ID\' style = \'cursor:pointer\'><img src=\'../../eCommon/images/NUHDEEK.png\'></span>\";\t\t\t\t\t\n\t\t}else{\n\t\t\tdocument.getElementById(\'NUHDEEK_ID\').innerHTML=\"\";\t\n\t\t}\t\n\t}\n\t$( \"#NUHDEEK_ID\" ).click(function() {\n\t\t\tvar dataElements\t= \"P_USE_ID=";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="&P_NUHDEEK_ID=";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="&P_PATIENT_ID=";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="&P_ENCNTR_DATE=";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="&P_VISIT_ID=";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="&P_EPISODE_ID=";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="&P_EPISODE_TYPE=";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="&P_PHYSICIAN_ID=";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&P_ACCESSION_NUM=&P_ORDER_ID=&P_ORDER_TYPE_CODE=&P_LOCN_TYPE=";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="&P_LOCN_CODE=";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="&P_CUST_CODE=&P_ITEM_CODE=&P_RESP_ID=";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="&P_FACILITY_ID=";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="&P_INV_ORG_ID=&P_MODULE_ID=";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="&P_FUNCTION_ID=";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="&P_ACCESS_RIGHTS=&P_LANGUAGE_ID=";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="&P_MULTI_SITE_YN=&P_MULTI_LANG_YN=&P_WS_NO=&P_Ext_Input_Key=&P_Ext_Application_ID=DMS&P_Ext_Function=VIEW&P_pwd=&P_Connect_string=&P_LOCN_DESC=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\";\t\n\t\t\tdispExtApp(dataElements);\t\t\n\t});\n\t/*Modified By Dharma End*/\n\t/*Added By Dharma on 8th July 2020 against AAKH-CRF-0119.1 Start*/\n\t$( \"#MALAFFI_ICON\" ).click(function() {\n\t\t\tvar dataElements\t= \"<PATIENT_ID>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="$!^<PRACTITIONER_ID>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="$!^<USER_NAME>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="$!^<MACHINE_ID>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="$!^<SESSION_ID>\";\t\n\t\t\tEMWebMalaffi(dataElements);\t\t\n\t});\n\t/*Added By Dharma on 8th July 2020 against AAKH-CRF-0119.1 End*/\n\n\t$( \"#PAT_DMS\" ).click(function() {\n\t\t/* $.ajax({  \n\t\t\turl:\'../../servlet/eXH.InvokeExternalApplication\',\t\t  \n\t\t      type:\'post\',  \n\t\t      data:{\'P_USE_ID\':\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\',\'P_PATIENT_ID\':\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\',\'P_ENCNTR_DATE\':\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\',\'P_VISIT_ID\':\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\',\'P_EPISODE_ID\':\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\',\'P_EPISODE_TYPE\':\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\',\'P_PHYSICIAN_ID\':\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\',\'P_ACCESSION_NUM\':\'\',\'P_ORDER_ID\':\'\',\'P_ORDER_TYPE_CODE\':\'\',\'P_LOCN_TYPE\':\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\',\'P_LOCN_CODE\':\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\',\'P_CUST_CODE\':\'\',\'P_ITEM_CODE\':\'\',\'P_RESP_ID\':\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\',\'P_FACILITY_ID\':\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\',\'P_INV_ORG_ID\':\'\',\'P_MODULE_ID\':\'\',\'P_FUNCTION_ID\':\'\',\'P_ACCESS_RIGHTS\':\'\',\'P_LANGUAGE_ID\':\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\',\'P_MULTI_SITE_YN\':\'\',\'P_MULTI_LANG_YN\':\'\',\'P_WS_NO\':\'\',\'P_Ext_Input_Key\':\'\',\'P_Ext_ Application_ID\':\'DMS\',\'P_Ext_Function\':\'VIEW\',\'P_pwd\':\'\',\'P_Connect_string\':\'\'},\n\t\t      dataType: \'html\'\t\t    \n\t\t });*/\n         \n\t\tvar dataElements\t= \"P_USE_ID=";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\";\n\t\n\t\tdispExtApp(dataElements);\n\t});\n\t/*Modified By Dharma End*/\n\t\n\t/*Added by Ajay Hatwate for ML-MMOH-CRF-1954 on 05/07/2023 */\n\tvar mlc_yn = \'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\';\n\tvar mlcAppl = \'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\';\n\tif(mlcAppl == \'true\'){\n\t\tif(document.getElementById(\'MLC\') || document.getElementById(\'MLC\') != null){\n\t\t\tif(mlc_yn != \'Y\'){\n\t\t\t\tdocument.getElementById(\'MLC\').style.display = \'none\';\n\t\t\t}\n\t\t}\n\t}else{\n\t\tif(document.getElementById(\'MLC\') || document.getElementById(\'MLC\') != null){\n\t\t\tdocument.getElementById(\'MLC\').style.display = \'none\';\n\t\t}\n\t}\n\t/*End of ML-MMOH-CRF-1954 */\n\t//Added by Kamatchi S for ML-MMOH-CRF-1182\n    if(document.getElementById(\'FPP_ICON\') && document.getElementById(\'FPP_ICON\') != null)\n    {       \n        var FPPValue = \'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\';\n        if(FPPValue == \"Y\" && document.getElementById(\'isFPPDisplayApplicable\').value==\"true\")\n        {\n            document.getElementById(\'FPP_ICON\').innerHTML = \"<span class=\'image\' id=\'FPP_ICON\'><img src=\'../../eCommon/images/FPP.png\'></span>\";\n        }\n        else\n        {\n            document.getElementById(\'FPP_ICON\').style.display = \'none\';\n        }\n    }\n\telse\n\t{\n\t\tif (document.getElementById(\'FPP_ICON\'))\n\t\t{\n\t\t\tdocument.getElementById(\'FPP_ICON\').style.visibility = \'hidden\';\n\t\t}\n\t}\n\t/*End*/\n\t\n\t\n\tif(document.getElementById(\'ARCHIVE_LINK\') != null)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' == \'Y\' && document.getElementById(\"isArchivalDisplayApplicable\").value==\"true\"){\n\t\t\tdocument.getElementById(\"ARCHIVE_LINK\").style.cursor = \'pointer\';\n\t\t\tdocument.getElementById(\"ARCHIVE_LINK\").addEventListener(\"click\",function(){callArchivalData(\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\")});\n\t\t}\n\t\telse {\n\t\t\tdocument.getElementById(\'ARCHIVE_LINK\').style.display = \'none\';\n\t\t}\n\t}\n// Ends Suresh\t\n\n//Below NOK blinker code commented on 1st Aug 2018 by Thamizh selvi\n/*Below line added for this CRF ML-MMOH-CRF-0780\t\nvar blink_speed = 600; \nsetInterval(function () {\nvar elemt =\"\";\nif(document.getElementById(\'nextofkin_blinker\')) elemt=document.getElementById(\'nextofkin_blinker\'); \n\nif(document.getElementById(\'NEXT_OF_KIN\')!=null && \'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'==0) elemt.style.visibility = (elemt.style.visibility == \'hidden\' ? \'\' : \'hidden\'); \n \n }, blink_speed);\n//End this CRF ML-MMOH-CRF-0780*/\n</script>\n\n\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block5Bytes, _wl_block5);
 
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			

			String ctx_banner_content = "";

			String pat_photo_in_db_yn = "N";
			String pat_photo_http_path = "";
			int pat_photo_rnwl_dys = 0;
			int diff_in_days=0;
			int no_of_days = 0;
			int past_surgery_cnt = 0;
			int patient_notes_cnt = 0;
			String P_ENCNTR_DATE	= "";
			String P_LOCN_CODE		= "";
			String P_LOCN_TYPE		= "";
			String P_VISIT_ID		= "";
			String P_EPISODE_ID		= "";
			String P_PHYSICIAN_ID	= "";
			String P_EPISODE_TYPE	= "";
			
			String length_of_stay="";//this line added for this CRF Bru-HIMS-CRF-411
			
			
			String P_MODULE_ID=request.getParameter("P_MODULE_ID")==null?"":request.getParameter("P_MODULE_ID");
			String P_FUNCTION_ID=request.getParameter("P_FUNCTION_ID")==null?"":request.getParameter("P_FUNCTION_ID");
			String enableCDR=request.getParameter("enableCDR")==null?"N":request.getParameter("enableCDR");
			String practEnableCDR	= "N";
						
 
			 String patient_id = request.getParameter("Patient_ID");

			 if(patient_id == null || patient_id.equals("null"))
				patient_id = "";
				
			 if(patient_id.equals(""))
				patient_id = request.getParameter("Patient_Id");

   		     if(patient_id == null || patient_id.equals("null"))
				patient_id = "";

 			 String episode_id = request.getParameter("EncounterId");

			 if(episode_id == null || episode_id.equals("null"))
				episode_id = "";

 			 String facility_id = "";
			 facility_id = request.getParameter("Facility_Id") == null ? "" : request.getParameter("Facility_Id");
			 if(facility_id.equals(""))
			 	facility_id = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");

			 String bl_install_yn = (String)session.getValue("bl_operational") == null ? "" : (String)session.getValue("bl_operational");
			String login_user_id	=	(String)session.getValue("login_user");	
  			 String visit_id = request.getParameter("visit_id") == null? "" : request.getParameter("visit_id");
 			 //String bl_details = "";
			 String bl_episode_id = "";
			 String bl_episode_visit_num = "";
			 String bannerCateg = "P";
             String viewPatPhotoYN = "N";
 			 String allergyListYN = "N";
		 	 String profileYN = "N";
		 	 String highRiskYN = "N";
			 String known_allergy_yn = "N";			 
			 String eye_indicator = "";
			 String general_remarks = "";
			 String Day_before_BirthDay = "";
			 String Birth_day = "";
			 String EstimatedAge = "";
			 String TOOL_TIP_TEXT = "";
 			 String deceasedYN = "N";
			 int researchCount = 0;
			 String activeYN = "N";
			 String suspended = "N";
			 String vipYN = "N";
			 String viewPatFinDtlsYN = "N";
			 String P_LOCN_DESC = "";
			 //String cp_operational_yn = "N";
			 String myhix_appl_YN = "N"; // Added for MYHIX integration ML-MMOH-CRF-0507.1.
			 String myhix_view_YN="N";// Added for MYHIX integration ML-MMOH-CRF-0507.1.
			 
			 String altID1	= ""; //Added By Dharma on Aug 14th 2018 against MMS-DM-CRF-0115.2 [IN:068313]
			 String alt_id4_no	= ""; 
			 String mlc_yn = ""; //Added for ML-MMOH-CRF-1954
			 boolean isMlcApplicable = false; //Added for ML-MMOH-CRF-1954

			 if(episode_id.equals("")) bannerCateg = "P";
			 else bannerCateg = "E";
			 
 			java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
			String locale = (String) p.getProperty("LOCALE") == null ? "" : (String) p.getProperty("LOCALE");
			String workStationId	= (String) p.getProperty("client_ip_address") == null ? "" : (String) p.getProperty("client_ip_address");
			
 			Connection con = null;
			PreparedStatement ps = null;
			ResultSet res = null;
			StringBuffer testBuffer = new StringBuffer();
			String patient_long_name="";
			String patient_long_name_loc_lang="";
			
			/*Added by Rameswar on  27-07-2016 for  AAKH-CRF-0083 */				
			String HAAD_Data ="";
			
			//Added by Sangeetha for ML-MMOH-CRF-0692 on 27/07/17
			boolean isAllergyIconReplaced = false; 
			
			//Below line added for this CRF ML-MMOH-CRF-0780
			int nextofKin=0;
			String NEXT_OF_KIN_TOOLTIP="";
			
			//Below line added for ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-0601
            Boolean increasedaddressLength = false;	
            Boolean alterAddressApplicable = false; 
			Boolean isDiscRefCountApplicable=false; // added by mujafar for ML-MMOH-CRF-1130.1 START
			 String disc_sum_count = "";
			 String ref_sum_count = "";
			 String disc_ref_count_temp=""; // added by mujafar for ML-MMOH-CRF-1130.1 END
			
			/*Added by Thamizh selvi on 4th June 2018 against MMS-DM-CRF-0115 Start*/
			int cdrCount = 0;
			String nationalityId = "";	
			/*End*/
			String isCDRConfigured	= "N";
			int histAllergyCnt = 0;//Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1117

			String MFSScore = ""; //Added by Ashwini on 09-Sep-2019 for ML-MMOH-CRF-1158

			/* Added by kamatchi S for ML-MMOH-CRF-1182 */
			String FPPPatient_yn = "N";
			String Episode_Type = ""; 
			boolean isFPPDisplayApplicable = false;
			/* Added by kamatchi S for ML-MMOH-CRF-1182 END*/
			
			/* Added by Prakash for PMG2023-COMN-CRF-0002.4 */ 
			String archival_yn = "N";
			String user_password = "";
			String ArchivalDBUrl = "";
			String lst_purge_encntr_id = "";
			boolean isArchivalDisplayApplicable = false;
			/* Added by Prakash for PMG2023-COMN-CRF-0002.4 END*/

		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
	
		
		String sqlDeceased = "";
		String File_exist="N"; 
		try
		{
			con = ConnectionManager.getConnection(request);	
			/* Added by kamatchi S for ML-MMOH-CRF-1182 START */
			isFPPDisplayApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","FPP_DISPLAY");
			if(isFPPDisplayApplicable)
			{
			Episode_Type = eMP.MPCommonBean.getPatientEncounterDetails(con,facility_id,episode_id);
			if(!Episode_Type.equals(""))
			FPPPatient_yn = eMP.MPCommonBean.getFPPDetails(con,facility_id,Episode_Type,episode_id);
			}
			/* Added by kamatchi S for ML-MMOH-CRF-1182 END */
			
			/* Added by Prakash for PMG2023-COMN-CRF-0002.4 */ 
			isArchivalDisplayApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ARCHIVE_DISPLAY");
			
			user_password=eMP.MPCommonBean.getUserPassword(con,login_user_id);
		
		
		
			if(isArchivalDisplayApplicable)
			{
				ArchivalDBUrl=eMP.MPCommonBean.getArchivalDBUrl(con);
				archival_yn=eMP.MPCommonBean.getArchivalYN(con,patient_id);
				lst_purge_encntr_id = eMP.MPCommonBean.getLstPurgeEncId(con,patient_id);
			}
			/* Added by Prakash for PMG2023-COMN-CRF-0002.4 END*/

			//Added for ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-0601
			increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
			alterAddressApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE"); 	
			isDiscRefCountApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","DISC_REF_COUNT_APPL"); // added by mujafar for ML-MMOH-CRF-1130.1 
			//End ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-0601

			//Added by Sangeetha for ML-MMOH-CRF-0692 on 27/07/17
			isAllergyIconReplaced = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","REPLACE_ALLERGY_ICON");
		
			//Below line added for this CRF ML-MMOH-CRF-0780		
			//nextofKin = eMP.ChangePatientDetails.getNextofKin(con, patient_id);
		
			isMlcApplicable = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MARK_PATIENT_MLC");//SiteSpecific added for ML-MMOH-CRF-1954 by Ajay Hatwate
			
			if(!patient_id.equals("") || !episode_id.equals(""))
			{
				java.sql.Clob bnrContentClob = null;
				java.io.Reader bnrContentReader = null;
				java.io.BufferedReader bnrBuffReader = null;

				String bannerContentStr = "";
				try
				{		
					eMP.PatEncBannerReplacementBean patEncBannerReplaceBean = new eMP.PatEncBannerReplacementBean();
					
					//Start Read the banner content from the application context instead of database
					
					if(bannerCateg.equalsIgnoreCase("E")){
						ctx_banner_content = (application.getAttribute("User_Banner_Encounter") == null)?"":(String)application.getAttribute("User_Banner_Encounter");
						if(ctx_banner_content != null || ctx_banner_content.length()>0);
						else 
							ctx_banner_content = (application.getAttribute("System_Banner_Encounter") == null)?"":(String)application.getAttribute("System_Banner_Encounter");
					}else if(bannerCateg.equalsIgnoreCase("P")){
						ctx_banner_content = (application.getAttribute("User_Banner_Patient") == null)?"":(String)application.getAttribute("User_Banner_Patient");
						if(ctx_banner_content != null || ctx_banner_content.length()>0);
						else 
							ctx_banner_content = (application.getAttribute("System_Banner_Patient") == null)?"":(String)application.getAttribute("System_Banner_Patient");
					}
					
				
					if(ctx_banner_content != null && ctx_banner_content.length()>0);
					else{ 
						ps = con.prepareStatement("select BANNER_CONTENT from MP_PAT_BANNER_HDR where BANNER_REF='U01' and BANNER_CATEG = ? ");
						ps.setString(1,bannerCateg);
						res = ps.executeQuery();
						if(res != null && res.next()){
							Clob clob = (java.sql.Clob) res.getObject("BANNER_CONTENT");
							BufferedReader reader = new BufferedReader(clob.getCharacterStream());
							ctx_banner_content = reader.readLine();
							reader.close();
						}
						if(res != null)res.close();
						if(ps != null)ps.close();
						if(ctx_banner_content != null && ctx_banner_content.length() > 0){
							if(bannerCateg.equalsIgnoreCase("E")){
								application.setAttribute("User_Banner_Encounter",ctx_banner_content);
							}else if(bannerCateg.equalsIgnoreCase("P")){
								application.setAttribute("User_Banner_Patient",ctx_banner_content);
							}
						}else{
							ps = con.prepareStatement("select BANNER_CONTENT from MP_PAT_BANNER_HDR where BANNER_REF='Sys' and BANNER_CATEG = ? ");
							ps.setString(1,bannerCateg);
							res = ps.executeQuery();
							
							if(res != null && res.next()){
								Clob clob = (java.sql.Clob) res.getObject("BANNER_CONTENT");
								BufferedReader reader = new BufferedReader(clob.getCharacterStream());
								ctx_banner_content = reader.readLine();
								reader.close();
							}
							if(res != null)res.close();
							if(ps != null)ps.close();
							if(ctx_banner_content != null && ctx_banner_content.length() > 0){
								if(bannerCateg.equalsIgnoreCase("E")){
									application.setAttribute("System_Banner_Encounter",ctx_banner_content);
								}else if(bannerCateg.equalsIgnoreCase("P")){
									application.setAttribute("System_Banner_Patient",ctx_banner_content);
								}
							}							
						}
					}
					//End Read the banner content from the application context instead of database
					
					HashMap testHashValues = null;
					
					if(episode_id.equals(""))
						testHashValues = (HashMap)patEncBannerReplaceBean.putToHash(con, "P", patient_id, episode_id, facility_id, locale);
					else
						testHashValues = (HashMap)patEncBannerReplaceBean.putToHash(con, "E", patient_id, episode_id, facility_id, locale);

					testBuffer = (StringBuffer) patEncBannerReplaceBean.replaceVariables(ctx_banner_content,testHashValues);
					
					HashMap mpPatientValues = (HashMap)patEncBannerReplaceBean.getMpPatientValues();	
					patient_id = (String) mpPatientValues.get("PATIENT_ID");
					deceasedYN = (String) mpPatientValues.get("DECEASED_YN");
					activeYN = (String) mpPatientValues.get("ACTIVE_YN");
					suspended = (String) mpPatientValues.get("SUSPEND_YN");
					vipYN = (String) mpPatientValues.get("VIP_YN");
					eye_indicator = (String) mpPatientValues.get("eye_indicator");
					general_remarks =java.net.URLEncoder.encode( (String) mpPatientValues.get("general_remarks")==null?"":(String) mpPatientValues.get("general_remarks"),"UTF-8");
					Day_before_BirthDay = (String) mpPatientValues.get("Day_before_BirthDay");
					Birth_day = (String) mpPatientValues.get("Birth_day");
					EstimatedAge = (String) mpPatientValues.get("EstimatedAge");
					TOOL_TIP_TEXT = (String) mpPatientValues.get("TOOL_TIP_TEXT");
					NEXT_OF_KIN_TOOLTIP  = (String) mpPatientValues.get("NEXT_OF_KIN_TOOLTIP"); //Added for this CRF ML-MMOH-CRF-0780
					nationalityId = (String) mpPatientValues.get("nationalityId");//Added by Thamizh selvi on 5th June 2018 against MMS-DM-CRF-0115

					mlc_yn = (String)mpPatientValues.get("MLC_YN") == null ?"N":(String)mpPatientValues.get("MLC_YN"); //Added for ML-MMOH-CRF-1954		
				
					if(bannerCateg.equals("E")) { 
						bl_episode_id = (String) mpPatientValues.get("BL_EPISODE_ID");
						bl_episode_visit_num = (String) mpPatientValues.get("BL_OP_EPISODE_VISIT_NUM");
						P_ENCNTR_DATE	= (String) mpPatientValues.get("P_ENCNTR_DATE");
						P_LOCN_CODE		= (String) mpPatientValues.get("P_LOCN_CODE");
						P_LOCN_TYPE		= (String) mpPatientValues.get("P_LOCN_TYPE");
						P_VISIT_ID		= (String) mpPatientValues.get("P_VISIT_ID");
						P_EPISODE_ID	= (String) mpPatientValues.get("P_EPISODE_ID");
						P_PHYSICIAN_ID	= (String) mpPatientValues.get("P_PHYSICIAN_ID");
						P_EPISODE_TYPE	= (String) mpPatientValues.get("P_EPISODE_TYPE");
						length_of_stay  = (String) mpPatientValues.get("LENGTH_OF_STAY");
						P_LOCN_DESC  = (String) mpPatientValues.get("P_LOCN_DESC");
					}

					HAAD_Data =eMR.MRHaadcolorConfigBean.getHAADPlinecontext(con,patient_id,facility_id);
					/*Added by Rameswar on  27-07-2016 for  AAKH-CRF-0083 */

					if(res != null) res.close();
					if(ps != null) ps.close();
				}
				catch(Exception e)
				{  
				   e.printStackTrace();
					out.println("Exception at try - Clob of PLine.jsp -"+e.toString());
					e.printStackTrace(System.err);
				}
			}//end of if patient_id	
		
			// query modified to get myhix access right. Added for MYHIX integration ML-MMOH-CRF-0507.1
			
			String sqlQuery = "SELECT "+
					" GET_TASK_APPLICABILITY('PATIENT_SEARCH',null,?,null) PATIENT_SEARCH,'N' TAB_MENU_YN,"+
					" GET_TASK_APPLICABILITY('ALLERGY_LST',null,?,null) ALLERGY_LST, "+
					" GET_TASK_APPLICABILITY('VIEW_PROFILE',null,?,null) VIEW_PROFILE, "+
					" KNOWN_ALLERGY_YN , pat_photo_in_db_yn, "+
					" (Select 'Y' from pr_high_risk_condition where patient_id =? and close_date is null  AND rownum=1) HIGH_RISK_COUNT, "+
					" null CURRENT_LOCATION, "+
					" (select view_pat_photo_yn from mp_access_rights where resp_id =?) view_pat_photo_yn, "+
					" (select VIEW_PAT_FIN_DTLS_YN from mp_access_rights where resp_id =?) view_pat_fin_dtls_yn, "+ 
					" (SELECT COUNT(*) FROM CA_RESEARCH_PATIENT_DETAIL WHERE  PATIENT_ID=?) total, "+
					" (select pat_photo_renewal_alert_days from mp_param) pat_photo_renewal_alert_days,"+
					" (Select  pat_photo_http_path from sm_db_info) pat_photo_http_path ,"+
					" (Select trunc(sysdate-modified_date) no_of_days from MP_PATIENT_PHOTO where PATIENT_ID = ?) no_of_days,"+
					" (select count(*) from pr_encounter_procedure where patient_id = ? and error_yn != 'Y') past_surgery_cnt,"+ 
					" (select count(*) from mp_patient_notes where patient_id = ?) patient_notes_cnt,"+
					" (select myhix_view_YN from MR_USER_ACCESS_RIGHTS where appl_user_id = ? and facility_id=?) myhix_view_YN ,"+
					" patient_long_name,patient_long_name_loc_lang,cdr_count,alt_id1_no,alt_id4_no,national_id_no "+
					" from mp_all_patients_vw where patient_id = ?";
					
			ps = con.prepareStatement("SELECT "+
						" GET_TASK_APPLICABILITY('PATIENT_SEARCH',null,?,null) PATIENT_SEARCH,'N' TAB_MENU_YN,"+
						" GET_TASK_APPLICABILITY('ALLERGY_LST',null,?,null) ALLERGY_LST, "+
						" GET_TASK_APPLICABILITY('VIEW_PROFILE',null,?,null) VIEW_PROFILE, "+
						" KNOWN_ALLERGY_YN , pat_photo_in_db_yn, "+
						" (Select 'Y' from pr_high_risk_condition where patient_id =? and close_date is null  AND rownum=1) HIGH_RISK_COUNT, "+
						" null CURRENT_LOCATION, "+
						" (select view_pat_photo_yn from mp_access_rights where resp_id =?) view_pat_photo_yn, "+
						" (select VIEW_PAT_FIN_DTLS_YN from mp_access_rights where resp_id =?) view_pat_fin_dtls_yn, "+ 
						" (SELECT COUNT(*) FROM CA_RESEARCH_PATIENT_DETAIL WHERE  PATIENT_ID=?) total, "+
						" (select pat_photo_renewal_alert_days from mp_param) pat_photo_renewal_alert_days,"+
						" (Select  pat_photo_http_path from sm_db_info) pat_photo_http_path ,"+
						" (Select trunc(sysdate-modified_date) no_of_days from MP_PATIENT_PHOTO where PATIENT_ID = ?) no_of_days,"+
						" (select count(*) from pr_encounter_procedure where patient_id = ? and error_yn != 'Y') past_surgery_cnt,"+ 
						" (select count(*) from mp_patient_notes where patient_id = ?) patient_notes_cnt,"+
						" (select myhix_view_YN from MR_USER_ACCESS_RIGHTS where appl_user_id = ? and facility_id=?) myhix_view_YN ,"+
						" patient_long_name,patient_long_name_loc_lang,cdr_count,alt_id1_no,alt_id4_no,national_id_no "+
						" from mp_all_patients_vw where patient_id = ?");
			
			
			ps.setString(1, resp_id);
			ps.setString(2, resp_id);
			ps.setString(3, resp_id);			
			ps.setString(4, patient_id);
			ps.setString(5, resp_id);
			ps.setString(6, resp_id);
			ps.setString(7, patient_id);
			ps.setString(8, patient_id);
			ps.setString(9, patient_id);
			ps.setString(10, patient_id);
			ps.setString(11, (String)session.getValue("login_user")); // Added for MYHIX integration ML-MMOH-CRF-0507.1
			ps.setString(12, facility_id); // Added for MYHIX integration ML-MMOH-CRF-0507.1
			ps.setString(13, patient_id);
			res = ps.executeQuery();
			while(res.next())
			{
				allergyListYN = res.getString("ALLERGY_LST") == null ? "N" : res.getString("ALLERGY_LST");
				profileYN = res.getString("VIEW_PROFILE") == null ? "N" : res.getString("VIEW_PROFILE");		
				known_allergy_yn = res.getString("KNOWN_ALLERGY_YN") == null ? "U" : res.getString("KNOWN_ALLERGY_YN");
				highRiskYN = res.getString("HIGH_RISK_COUNT") == null ? "N" : res.getString("HIGH_RISK_COUNT");
				viewPatPhotoYN = res.getString("VIEW_PAT_PHOTO_YN") == null ? "N" : res.getString("VIEW_PAT_PHOTO_YN");
				viewPatFinDtlsYN = res.getString("view_pat_fin_dtls_yn") == null ? "N" : res.getString("view_pat_fin_dtls_yn");
				researchCount = res.getInt("total");					
				pat_photo_in_db_yn = res.getString("pat_photo_in_db_yn")==null?"N":res.getString("pat_photo_in_db_yn");				
				pat_photo_rnwl_dys = res.getInt("pat_photo_renewal_alert_days"); 					
				no_of_days = res.getInt("no_of_days");			
				past_surgery_cnt = res.getInt("past_surgery_cnt");		
				patient_notes_cnt = res.getInt("patient_notes_cnt");			
				pat_photo_http_path = res.getString("pat_photo_http_path");			
				patient_long_name =	res.getString("patient_long_name")==null?"":res.getString("patient_long_name");	
				myhix_view_YN =	res.getString("myhix_view_YN")==null?"N":res.getString("myhix_view_YN");	 //Added for MYHIX integration ML-MMOH-CRF-0507.1	 				
				altID1			 =	res.getString("alt_id1_no")==null?"":res.getString("alt_id1_no");	  //Added By Dharma on Aug 14th 2018 against MMS-DM-CRF-0115.2 [IN:068313]	 				
				alt_id4_no			 =	res.getString("alt_id4_no")==null?"":res.getString("alt_id4_no");	 
				nationalityId	 =	res.getString("national_id_no")==null?"":res.getString("national_id_no");	  //Added By Dharma on Aug 14th 2018 against MMS-DM-CRF-0115.2 [IN:068313] 			
				//cdrCount		 =	res.getInt("cdr_count");	 //Added By Dharma on Aug 14th 2018 against MMS-DM-CRF-0115.2 [IN:068313]	 				
			} 
			
			/* System.out.println(" ******************* Inside pline jsp 431 allergyListYN : "+allergyListYN+" profileYN : "+profileYN
					+" known_allergy_yn : "+known_allergy_yn+" highRiskYN : "+highRiskYN
					+" viewPatPhotoYN : "+viewPatPhotoYN+" viewPatFinDtlsYN : "+viewPatFinDtlsYN
					+" viewPatFinDtlsYN : "+viewPatFinDtlsYN+" researchCount : "+researchCount
					+" pat_photo_in_db_yn : "+pat_photo_in_db_yn+" pat_photo_rnwl_dys : "+pat_photo_rnwl_dys
					+" pat_photo_rnwl_dys : "+pat_photo_rnwl_dys+" no_of_days : "+no_of_days
					+" past_surgery_cnt : "+past_surgery_cnt+" patient_notes_cnt : "+patient_notes_cnt
					+" pat_photo_http_path : "+pat_photo_http_path+" patient_long_name : "+patient_long_name
					+" myhix_view_YN : "+myhix_view_YN+" altID1 : "+altID1); */
			
			if(res != null) res.close();
			if(ps != null) ps.close();
			
			
		   //Below line added for this CRF ML-MMOH-CRF-0780		
		    nextofKin = eMP.ChangePatientDetails.getNextofKin(con, patient_id);
			//Added By Dharma on Aug 14th 2018 against MMS-DM-CRF-0115.2 [IN:068313]
			if(testBuffer.indexOf("id='CDR'") != -1){
				isCDRConfigured	= "Y";
			}
			if("Y".equals(enableCDR) && "Y".equals(isCDRConfigured)){
				practEnableCDR	= eCommon.Common.CommonBean.getCDRIconEnableYNforPract(con, login_user_id);
			}
			
		   	if("Y".equals(enableCDR) && "Y".equals(practEnableCDR) && "Y".equals(isCDRConfigured)){
				cdrCount = eMP.MPCommonBean.getCDRCount(con, nationalityId,altID1,patient_id);//Added by Thamizh selvi on 6th June 2018 against MMS-DM-CRF-0115	
			}

			myhix_appl_YN 	= CommonBean.getMyHixApplicable(con); //added for MYHIX integration ML-MMOH-CRF-0507.1.

			MFSScore = eMP.MPCommonBean.getMorseFallScaleScore(con, episode_id, patient_id); //Added by Ashwini on 09-Sep-2019 for ML-MMOH-CRF-1158

			histAllergyCnt = eMP.MPCommonBean.getHistAllergyCnt(con, patient_id);//Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1117
			disc_ref_count_temp = eCommon.Common.CommonBean.getDisRefSumCnt(con,patient_id); // added by mujafar for ML-MMOH-CRF-1130.1 START
			if(disc_ref_count_temp.contains("~~"))
			{
				String[] retVal = disc_ref_count_temp.split("~~");
				if(retVal.length==2)
				{
					disc_sum_count= retVal[0];
					ref_sum_count = retVal[1];
				}
				else
				{
					disc_sum_count= retVal[0];
				}
			}
			String path="";
			String fmt_file_modified_date="";
			path=pat_photo_http_path+patient_id+".jpg";
			File f = new File(path);    
			
			if(f.exists()){
				pat_photo_http_path=pat_photo_http_path.replaceAll("\\\\","|");
				java.util.Date file_modified_date =new java.util.Date(f.lastModified());
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
				fmt_file_modified_date=sdf.format(file_modified_date);
				/*
					Query will get the difference in dates of System date and file modified date
				*/
				String Date_Query="SELECT TRUNC(SYSDATE-TO_DATE('"+fmt_file_modified_date+"','DD/MM/YYYY')) DIFF_IN_DAYS FROM DUAL";
				ps = con.prepareStatement(Date_Query);
				res=ps.executeQuery();
				while(res.next()){
					diff_in_days=Integer.parseInt(res.getString("DIFF_IN_DAYS"));
				}
				File_exist="Y";
			}
			else
			{
				File_exist="N";
			}
			
			if(res != null) res.close();
			if(ps != null) ps.close();
			
		}//end of try - main
		catch(Exception excep)
		{
          excep.printStackTrace();	
		  out.println("Exception in try main of PLine.jsp------"+excep.toString());
			excep.printStackTrace(System.err);			
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(testBuffer));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(general_remarks));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(P_ENCNTR_DATE));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(TOOL_TIP_TEXT));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(increasedaddressLength));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(alterAddressApplicable));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(isDiscRefCountApplicable));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disc_sum_count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ref_sum_count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cdrCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practEnableCDR));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(workStationId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(isFPPDisplayApplicable));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(isArchivalDisplayApplicable));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(deceasedYN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bl_episode_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bl_episode_visit_num));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(profileYN));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(allergyListYN));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(known_allergy_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(highRiskYN));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(isAllergyIconReplaced));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(known_allergy_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(highRiskYN));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(isAllergyIconReplaced));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(researchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(viewPatPhotoYN));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(pat_photo_in_db_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pat_photo_in_db_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(pat_photo_http_path));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(pat_photo_rnwl_dys));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(pat_photo_rnwl_dys));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(pat_photo_in_db_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(File_exist));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pat_photo_in_db_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(pat_photo_http_path));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(diff_in_days));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(pat_photo_rnwl_dys));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(pat_photo_rnwl_dys));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(activeYN));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(suspended));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patient_long_name));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_long_name));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_long_name_loc_lang));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_long_name_loc_lang));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(vipYN));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(viewPatFinDtlsYN));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(eye_indicator));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(eye_indicator));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(EstimatedAge));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(Day_before_BirthDay));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(Birth_day));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(past_surgery_cnt));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(past_surgery_cnt));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(patient_notes_cnt));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(TOOL_TIP_TEXT));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(nextofKin));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(NEXT_OF_KIN_TOOLTIP));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(myhix_appl_YN));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(myhix_view_YN));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(enableCDR));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(practEnableCDR));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(isCDRConfigured));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(cdrCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_EPISODE_TYPE));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nationalityId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(altID1));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(histAllergyCnt));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(length_of_stay));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(MFSScore));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(HAAD_Data));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(P_ENCNTR_DATE));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(P_VISIT_ID));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(P_EPISODE_ID));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(P_EPISODE_TYPE));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(P_PHYSICIAN_ID));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(P_LOCN_TYPE));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(P_LOCN_CODE));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(P_MODULE_ID));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(P_FUNCTION_ID));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(P_LOCN_DESC));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(P_PHYSICIAN_ID));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(workStationId));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(P_ENCNTR_DATE));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(P_VISIT_ID));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(P_EPISODE_ID));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(P_EPISODE_TYPE));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(P_PHYSICIAN_ID));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(P_LOCN_TYPE));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(P_LOCN_CODE));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(P_ENCNTR_DATE));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(P_VISIT_ID));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(P_EPISODE_ID));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(P_EPISODE_TYPE));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(P_PHYSICIAN_ID));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(P_LOCN_TYPE));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(P_LOCN_CODE));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(P_MODULE_ID));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(P_FUNCTION_ID));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(P_LOCN_DESC));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(mlc_yn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(isMlcApplicable));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(FPPPatient_yn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(archival_yn));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(user_password));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(lst_purge_encntr_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ArchivalDBUrl));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(nextofKin));
            _bw.write(_wl_block131Bytes, _wl_block131);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
