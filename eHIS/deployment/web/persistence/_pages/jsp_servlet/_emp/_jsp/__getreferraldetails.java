package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __getreferraldetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/getReferralDetails.jsp", 1742534377307L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\t \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n    <head>\n \t\n        <!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n        ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n        <script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n        <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<!--  -->\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\tvar BodyFrame = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"\t\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<script>\n\tvar ref_type = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\tvar referred_to = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\n\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script>\n\t\t\t\tvar ref_type= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\tvar temp\t= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\tvar temp1\t= \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\tvar jsp_val = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\n\t\t\t\tvar hcare_setting_type_desc\t= \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\tvar hcare_setting_type\t\t= \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\tvar hcareOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\thcareOpt.text\t= hcare_setting_type_desc;\n\t\t\t\thcareOpt.value\t= hcare_setting_type;\n\t\t\t\tif ((\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"==\"DischargePatient\" || (\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"==\"ModifyReferral\" && eval(BodyFrame).document.forms[0].onloadcount.value<1)) && (\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" == \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"))\n\t\t\t\t\thcareOpt.selected = true;  //above line modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 \n\t\t\t\telse\n\t\t\t\t\thcareOpt.selected = false;\n\t\t\t\thcareOpt.selected=true;\n\n\t\t\t\tif(ref_type == \"L\" || ref_type == \"E\")\n\t\t\t\t{\n\t\t\t\t\tvar opt3=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\topt3.text=temp1;\n\t\t\t\t\topt3.value=temp;\n\t\t\t\n\t\t\t\t\tif (jsp_val != \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar ref_code = eval(BodyFrame).document.forms[0].referral_type.value;\n\t\t\t\t\t\tif (ref_code == temp)\n\t\t\t\t\t\tif(ref_type == \"L\" || ref_type == \"E\")\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\topt3.selected=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\topt3.selected=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\tif ((\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"==\"DischargePatient\") && (\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' == temp))\n\t\t\t\t\topt3.selected = true;\n\t\t\t\t\teval(BodyFrame).document.forms[0].referral_source.value=opt3.text;  // added for crf 508\n\t\t\t\t\teval(BodyFrame).document.forms[0].referral_source_lkp_bkup_text.value=opt3.text;\n\t\t\t\t\teval(BodyFrame).document.forms[0].referred_to.value=opt3.value;\n\t\t\t\t\t//eval(BodyFrame).document.forms[0].referred_to.add(opt3);\n\t\t\t\t}\n\t\t\t\teval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);\n\n\t\t\t\t if(eval(BodyFrame).document.forms[0].speciality_desc && eval(BodyFrame).document.forms[0].onloadcount.value>0)\n\t\t\t\t{  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023\n\t\t\t\teval(BodyFrame).document.forms[0].speciality_desc.value=\"\"; \n\t\t\t\teval(BodyFrame).document.forms[0].speciality.value=\"\";  \n\t\t\t\t}\n\t\t\t\t// Commented on 7 SEP 2004\n\n\t\t\t\tif (\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"==\"DischargePatient\")\n\t\t\t\t{\n\t\t\t\t\teval(BodyFrame).document.forms[0].priority.value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\t\teval(BodyFrame).document.forms[0].speciality.value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar hcare_setting_type_desc = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\tvar hcare_setting_type_code = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\tvar hcareOpt = eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\thcareOpt.text\t= hcare_setting_type_desc;\n\t\t\t\t\thcareOpt.value\t= hcare_setting_type_code;\n\t\t\t\t\tif ((\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"==\"ModifyReferral\" && eval(BodyFrame).document.forms[0].onloadcount.value<1) ) && (\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"))\n\t\t\t\t\t{ //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023  \n\t\t\t\t\t\thcareOpt.selected = true; \n\t\t\t\t\t\teval(BodyFrame).getval2(hcare_setting_type_code); \n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\thcareOpt.selected = false;\n\t\t\t\teval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\tvar hcareOpt = eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\thcareOpt.text\t= hcare_setting_type_desc;\n\t\t\t\t\thcareOpt.value\t= hcare_setting_type_code;\n\t\t\t\t\t/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ \n\t\t\t\t\tif ((eval(BodyFrame).document.forms[0].onloadcount.value<1) && (\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"))\n\t\t\t\t\t{\n\t\t\t\t\t\thcareOpt.selected = true; \n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\thcareOpt.selected = false;\n\t\t\t\t\t/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ \n\t\t\t\t\teval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<script>\n\t\t\t\teval(BodyFrame).document.forms[0].location0.onchange(); \n\t\t\t\teval(BodyFrame).document.forms[0].onloadcount.value=+1;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" <script>\n\t\tvar length = eval(BodyFrame).document.forms[0].location0.length;\n\t\tfor(i=0;i<length;i++)\n\t\t{\n\t\t\teval(BodyFrame).document.forms[0].location0.remove(1);\n\t\t}</script> ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t <script>\n\t\t\t\tvar opt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\t\teval(BodyFrame).document.forms[0].location0.add(opt);\n\t\t\t\teval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt\n\t\t\t\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t<script>\n\t\t\t\t\teval(BodyFrame).document.forms[0].location0.options[0].selected=true; \n\t\t\t\t\teval(BodyFrame).document.forms[0].location0.onchange(); \n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" \n\t\t\t\t\t<script> \n\t\t\t\t\tif(eval(BodyFrame).document.forms[0].quick_admission && !eval(BodyFrame).document.forms[0].quick_admission.checked)\n\t\t\t\t\t{\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location0.options[1].selected=true;\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location0.onchange();\n\t\t\t\t\t}else if(!eval(BodyFrame).document.forms[0].quick_admission) \n\t\t\t\t\t{ \n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location0.options[1].selected=true; \n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location0.onchange(); \n\t\t\t\t\t} \n\t\t\t\t\t</script> \n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n     <script>\n          if(eval(BodyFrame).document.forms[0].quick_admission && eval(BodyFrame).document.forms[0].quick_admission.checked)\n\t\t  { \t \t\t\t \n\t\t\t     if(eval(BodyFrame).document.forms[0].location0){\t\t\t\t\n\t\t\t\t        for(var m=0; m< eval(BodyFrame).document.forms[0].location0.length; m++){ \n\t                        if(eval(BodyFrame).document.forms[0].location0[m].value==\"N\"){\n\t                           eval(BodyFrame).document.forms[0].location0.value=eval(BodyFrame).document.forms[0].location0[m].value;\t\n\t                           eval(BodyFrame).document.forms[0].location0.disabled=true;\n\t\t\t\t\t\t\t   //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187\n\t\t\t\t\t\t\t   if(eval(BodyFrame).document.forms[0].isImproveReferralProcessAppl.value == \"true\" && eval(BodyFrame).document.forms[0].hddFuncID.value != \"RegisterInpatientReferral\"){\n\t\t\t\t\t\t\t\t   eval(BodyFrame).document.forms[0].location0.onchange();\n\t\t\t\t\t\t\t   }\n\t                       }\n\t                   }\n\t            }\n\t     }\n       </script>\t\t\t   \n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<script>\n\t\t\t\t//var referredToCode = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\t\t\t\t//var referredToDesc = \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\t\t\t\t\n\t\t\t\t//var referredToOpt = eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t//referredToOpt.text\t= referredToDesc;\n\t\t\t\t//referredToOpt.value = referredToCode;\n\t\t\t\t//if ((\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' == referredToCode))\n\t\t\t\t\t//referredToOpt.selected = true;\n\t\t\t\t//eval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);\n\n\t\t\t\t/*\n\t\t\t\tif(eval(BodyFrame).document.getElementById(\'locn_type_img\'))\n\t\t\t\t{\n\t\t\t\t\teval(BodyFrame).document.getElementById(\'locn_type_img\').style.visibility=\'visible\';\n\t\t\t\t}*/\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<script>\n\t\t\t\t\t//var referredToCode = \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\t\t\t//var referredToDesc = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t//var referredToOpt = eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\t//referredToOpt.text\t= referredToDesc;\n\t\t\t\t\t//referredToOpt.value = referredToCode;\n\t\t\t\t\t//if ((\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' == referredToCode))\n\t\t\t\t\t\t//referredToOpt.selected = true;\n\t\t\t\t\t//eval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);\n\t\t\t\t\t\t\t\t\t//alert(\'3\')\t\n\t\t\t\t\t//eval(BodyFrame).document.forms[0].referral_source.value=referredToOpt.text;  // added for crf 508\n\t\t\t\t\t//eval(BodyFrame).document.forms[0].referral_source_lkp_bkup_text.value=referredToOpt.text;\n\t\t\t\t\t//eval(BodyFrame).document.forms[0].referral_source_lkp_id.value=referredToOpt.value;\n\t\n\n\t\t\t\tif(eval(BodyFrame).document.getElementById(\'locn_type_img\'))\n\t\t\t\t{\n\t\t\t\t\teval(BodyFrame).document.getElementById(\'locn_type_img\').style.visibility=\'hidden\';\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t//var referredToOpt = eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\t//referredToOpt.text\t= referredToDesc;\n\t\t\t\t\t//referredToOpt.value = referredToCode;\n\t\t\t\t\t//eval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);\n\t\t\t\t\t\t\t\t\t\t//alert(\'4\')\n\t\t\t\t\t//eval(BodyFrame).document.forms[0].referral_source.value=referredToOpt.text;  // added for crf 508\n\t\t\t\t\t//eval(BodyFrame).document.forms[0].referral_source_lkp_bkup_text.value=referredToOpt.text;\n\t\t\t\t\t//eval(BodyFrame).document.forms[0].referral_source_lkp_id.value=referredToOpt.value;\n\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t\t\teval(BodyFrame).document.forms[0].location0.add(opt);\n\t\t\t\teval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt\n\t\t\t\t </script>\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location0.options[1].selected=true;\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location0.onchange();\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\t\t\t\tvar opt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].speciality.add(opt);\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t<script>\n\t\tvar ref_type= \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\n\t\tif(ref_type == \'E\' || ref_type == \'X\')\n\n\t\tvar service = eval(BodyFrame).document.forms[0].service;\n\t\twhile(service.options.length > 0)\n\t\t\tservice.remove(service.options[1]);\n\n\t\tvar serviceOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\tserviceOpt.text\t= \"---------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------\";\n\t\tserviceOpt.value\t= \"\";\n\t\teval(BodyFrame).document.forms[0].service.add(serviceOpt);\n\t</script>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar opt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\topt.value\t= \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"; \n\t\t\t\t\topt.text\t= \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\t\t\t\t\teval(BodyFrame).document.forms[0].service.add(opt);\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t<script>\n\t\tvar service = eval(BodyFrame).document.forms[0].service;\n\t\twhile(service.options.length > 0)\n\t\t\tservice.remove(service.options[1]);\n\n\t\tvar serviceOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\tserviceOpt.text\t=\"---------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------\";\n\t\tserviceOpt.value\t= \"\";\n\t\teval(BodyFrame).document.forms[0].service.add(serviceOpt);\n\t</script>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n<script>  \nif(eval(BodyFrame).document.getElementById(\'referral_reg\')){ \neval(BodyFrame).document.getElementById(\'referral_reg\').style.visibility = \"visible\";\nif(\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"==\"X\")eval(BodyFrame).document.getElementById(\'referral_reg\').innerHTML=getLabel(\"Common.ReasonforRejection.label\",\"Common\");\n\nif(\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"==\"S\")eval(BodyFrame).document.getElementById(\'referral_reg\').innerHTML=getLabel(\"Common.ReasonforCancel.label\",\"Common\");\n}\nif(eval(BodyFrame).document.getElementById(\'referral_reg_id\'))eval(BodyFrame).document.getElementById(\'referral_reg_id\').style.visibility = \"visible\";\n\nif(eval(BodyFrame).document.getElementById(\'ref_reg_id\'))eval(BodyFrame).document.getElementById(\'ref_reg_id\').style.visibility = \"visible\";\n\n\t\tvar referral_reg_id = eval(BodyFrame).document.getElementById(\'referral_reg_id\');\n\t\t\tvar length1  = referral_reg_id.length;\n\t\n        for(var i=length1-1; i>=0; i--) { \n\t\t\t\treferral_reg_id.remove(i);\n\t\t}  \t\n\n\t\tvar referralOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\treferralOpt.text\t=\"---------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------\";\n\t\treferralOpt.value\t= \"\";\n\t\treferral_reg_id.add(referralOpt);\n\t</script>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\t\t\t\t\t\n\t\t\t\t\treferral_reg_id.add(opt);\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t<script>\n\t// If Loaction Type is clinic, then Referred For is Disabled...\n\t\tif(eval(BodyFrame).document.forms[0].ref_for_ip)\n\t\t{  \n             /*Below line Added for this CRF Bru-HIMS-CRF-261*/\t\t\t\n     \t\tif(eval(BodyFrame).document.forms[0].quick_admission && !eval(BodyFrame).document.forms[0].quick_admission.checked){ \n\t\t\t   eval(BodyFrame).document.forms[0].ref_for_ip.disabled = false; \n\t\t\t}\n\t\t}\n\t\tif(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'!=\"\"&&\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'!=\"N\"){\n\t\tif(eval(BodyFrame).document.forms[0].Bedcode){\n\t\teval(BodyFrame).document.forms[0].Bedcode.disabled = true; \n\t\teval(BodyFrame).document.forms[0].Bedcode.value = \'\';\n\t\t}if(eval(BodyFrame).document.forms[0].bed_type){\n\t\teval(BodyFrame).document.forms[0].bed_type.disabled = true; \n\t\teval(BodyFrame).document.forms[0].bed_type.value = \'\';\n\t\t}\n\t\t}else{\n\t\tif(eval(BodyFrame).document.forms[0].Bedcode)\n\t\teval(BodyFrame).document.forms[0].Bedcode.disabled = false; \t\n        if(eval(BodyFrame).document.forms[0].bed_type)\t\t\n\t\teval(BodyFrame).document.forms[0].bed_type.disabled = false; \n\t\n\t\t}\n\t</script>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar opt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\topt.text\t= \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"; \n\t\t\t\t\topt.value\t= \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t<script>opt.selected=true;\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location1.add(opt);\n\t\t\t\t\t\tif (eval(BodyFrame).document.forms[0].location1.options[0].text === \"---------Select---------\") {\n\t\t\t\t\t\t    // Change the value of the first option\n\t\t\t\t\t\t    eval(BodyFrame).document.forms[0].location1.options[0].value = \"\";\n\t\t\t\t\t\t  }\n\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t<script>\n\t\t\teval(BodyFrame).document.forms[0].location1.options[1].selected=true;\n\t\t\teval(BodyFrame).document.forms[0].location1.onchange();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t<script>\n\t\t// If Loaction Type is clinic, then Referred For is Disabled...\n\t\tif(eval(BodyFrame).document.forms[0].ref_for_ip)\n\t\t{\n\t\t\teval(BodyFrame).document.forms[0].ref_for_ip.disabled = true; \n\t\t\teval(BodyFrame).document.forms[0].ref_for_ip.value = \'\';\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t<script> opt.selected=true;\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location1.add(opt);\n\t\t\t\t\t\tif (eval(BodyFrame).document.forms[0].location1.options[0].text === \"---------Select---------\") {\n\t\t\t\t\t\t    // Change the value of the first option\n\t\t\t\t\t\t    eval(BodyFrame).document.forms[0].location1.options[0].value = \"\";\n\t\t\t\t\t\t  }\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t<script> opt.selected=true;\t</script>\n\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t<script> \n\t\tif(eval(BodyFrame).document.forms[0].location0 && eval(BodyFrame).document.forms[0].onloadcount.value<1){\n\t\t\t\n\t\t\teval(BodyFrame).document.forms[0].pract_name.disabled\t\t\t= false;\n\t\t\teval(BodyFrame).document.forms[0].pract_butt.disabled\t\t\t= false;\n\t\t\teval(BodyFrame).document.forms[0].service.value = eval(BodyFrame).document.forms[0].hddref_service_code.value;\n\t\t\teval(BodyFrame).document.forms[0].service_desc.value = \"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\t\t\teval(BodyFrame).document.forms[0].onloadcount.value=+1;\n\t        for(var m=0; m< eval(BodyFrame).document.forms[0].location0.length; m++){ \n                if(eval(BodyFrame).document.forms[0].location0[m].value==\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"){\n                \teval(BodyFrame).document.forms[0].location0.options[m].selected=true;  \n               }\n           }\n    }\t\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t<script>\n\t\t\tvar service = eval(BodyFrame).document.forms[0].service;\n\t\t\twhile(service.options.length > 0)\n\t\t\t\tservice.remove(service.options[1]);\n\n\t\t\tvar serviceOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\tserviceOpt.text\t=\"---------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------\";\n\t\t\tserviceOpt.value\t= \"\";\n\t\t\teval(BodyFrame).document.forms[0].service.add(serviceOpt);\n\t\t</script>\n\t\t\n\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar opt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text\t= \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"; \n\t\t\t\t\t\topt.value\t= \"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].service.add(opt);\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\n\t\t<script>  \n\t\t\tvar bedcode = eval(BodyFrame).document.forms[0].Bedcode;\n\t\t\twhile(bedcode.options.length > 0)\n\t\t\t\tbedcode.remove(bedcode.options[1]);\n\n\t\t\tvar bedcodeOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\tbedcodeOpt.text\t=\"---------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------\";\n\t\t\tbedcodeOpt.value\t= \"\";\n\t\t\teval(BodyFrame).document.forms[0].Bedcode.add(bedcodeOpt);\n\t\t</script>\n\t\t\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\tvar opt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text\t= \"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\";\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].Bedcode.add(opt);\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\n\t\t<script>  \n\t\t\tvar visitadmtype = eval(BodyFrame).document.forms[0].visit_adm_type;\n\t\t\twhile(visitadmtype.options.length > 0)\n\t\t\t\tvisitadmtype.remove(visitadmtype.options[1]);\n\n\t\t\tvar visitadmtypeOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\tvisitadmtypeOpt.text\t=\"---------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------\";\n\t\t\tvisitadmtypeOpt.value\t= \"\";\n\t\t\teval(BodyFrame).document.forms[0].visit_adm_type.add(visitadmtypeOpt);\n\t\t</script>\n\t\t\n\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].visit_adm_type.add(opt);\n\t\t\t\t\t\t//Added by shanmukh on 1st-AUG-2018 for ML-MMOH-CRF-0618\n\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" && (\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\")){\n\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\n\t\t<script>  \n\t\t\tvar bedtype = eval(BodyFrame).document.forms[0].bed_type;\n\t\t\twhile(bedtype.options.length > 0)\n\t\t\t\tbedtype.remove(bedtype.options[1]);\n\n\t\t\tvar bedtypeOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\tbedtypeOpt.text\t=\"---------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------\";\n\t\t\tbedtypeOpt.value\t= \"\";\n\t\t\teval(BodyFrame).document.forms[0].bed_type.add(bedtypeOpt);\n\t\t</script>\n\t\t\n\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";  \n\t\t\t\t\t\topt.value\t= \"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\";\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].bed_type.add(opt);\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t<script>\n\t\teval(BodyFrame).document.forms[0].referred.disabled\t\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].referral_type.disabled\t\t= true;\n\t\teval(BodyFrame).document.forms[0].hcare_setting_type.disabled\t= true;\n\t\t\n\t\teval(BodyFrame).document.forms[0].referred_to.disabled\t\t\t= true;  // comment for crf 508\n\t\teval(BodyFrame).document.forms[0].referral_source.disabled\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].referral_source_lkp_but.disabled\t\t\t= true;\n\n\t\teval(BodyFrame).document.forms[0].priority.disabled\t\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].preferred_date.disabled\t\t= true;\n\t\teval(BodyFrame).document.getElementById(\'preferred_date_cal\').disabled\t\t= true;\n\t\teval(BodyFrame).document.forms[0].speciality_desc.disabled\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].search_speciality.disabled\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].service.value = eval(BodyFrame).document.forms[0].hddref_service_code.value;\n\t\teval(BodyFrame).document.forms[0].service_desc.disabled\t\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].search_service.disabled\t\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].location0.disabled\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].location1.disabled\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].location2.disabled\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].pract_name.disabled\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].pract_butt.disabled\t\t\t= true;\n\t\teval(BodyFrame).document.forms[0].ref_for_ip.disabled\t\t\t= true;\n\t</script>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n</head>\n<body class=message onKeyDown = \'lockKey();\'>\n\t<form name=\'dummyform\' id=\'dummyform\'></form>\n</body>\n\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n</html>\n\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

	/*Below line Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 */
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// Module			: OutPatient Management...[OP]
/// Created By		: SRIDHAR R 
/// Created Date	: 8 JUNE 2004
/// Function		: This Page is built as an intermediate Page & is used for Validations for Referral Details Component...
/// Calling Page	: ../../eMP/jsp/ReferralDetailsComponent.jsp
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection con			= null;
		ResultSet rs			= null;
		PreparedStatement pstmt = null;
		
		

	try{
		con = ConnectionManager.getConnection(request);

		 Boolean isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS"); //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		 Boolean isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//Added by lakshmanan for ML-MMOH-CRF-1972 on 19july2023
		String facility_id	= (String) session.getValue( "facility_id" ) ;
	
		String sql						= "";
		
		//String org_type_desc			= "";
		String nursingUnitDesc			= "";
		String nursingUnitCode			= "";
		String clinicDesc				= "";
		String clinicCode				= "";
		String referredtoid				= "";
		String referredtodesc			= "";
		String hcare_setting_type_desc	= "";
		String hcare_setting_type_code	= "";
		String hcare_setting_type		= "";	
		
		String ServiceCode				= "";
		String ServiceDesc				= "";
	
		String locdesc="";
		String loctype="";
		
		String loc_sql="";

		int ip	= 0;
		int op	= 0;

		String ref_type	=	request.getParameter("ref_type");
		if(ref_type==null) ref_type="";

		String loc_type=request.getParameter("loc_type");
		if(loc_type==null) loc_type="";

		String ref_to=request.getParameter("ref_to");
		if(ref_to==null) ref_to="";

		String location1=request.getParameter("location1");
		if(location1==null) location1="";

		String specLoad=request.getParameter("specLoad");
		if(specLoad==null) specLoad="";

		String Option = request.getParameter("Option");
		if(Option == null) Option = "Y";

		String resetHcare = request.getParameter("resetHcare");
		if(resetHcare == null) resetHcare = "N";

		String referred_to_id=request.getParameter("referred_to_id");
		if(referred_to_id==null) referred_to_id="";

		String referred_to_code	= request.getParameter("ref_to_code");
		if(referred_to_code == null) referred_to_code ="";

		String referred_to_desc=request.getParameter("referred_to_desc");
		if(referred_to_desc==null) referred_to_desc="";

		String loc0=request.getParameter("loc0");
		if(loc0==null) loc0="";

		String src1=request.getParameter("src1");
		if(src1 == null) src1 = "";

		String specialty=request.getParameter("specialty");
		if (specialty == null ) specialty = "";

		String service=request.getParameter("service");
		if (service == null ) service = "";

		String ref_service_code=request.getParameter("ref_service_code");
		if (ref_service_code == null ) ref_service_code = "";
		
		/*Below line Added for this CRF Bru-HIMS-CRF-261*/
		String bedclasscode="",bedshortdesc="",bedtypecode="",bedtypeshortdesc="",admissiontypecode="",admissiontypedesc="";
		String loc_code=request.getParameter("loc_code");
		if (loc_code == null ) loc_code = "";	
		String bedclass_code=request.getParameter("bedclasscode");
		if(bedclass_code == null ) bedclass_code = "";	
		//End Bru-HIMS-CRF-261

		String jsp_val=request.getParameter("jsp_val");
		if (jsp_val == null ) jsp_val = "";

		String BodyFrame = request.getParameter("BodyFrame");
		if (BodyFrame == null ) BodyFrame = "";

		String Module = request.getParameter("Module");
		if (Module == null ) Module = "";


		String Transaction_type = request.getParameter("Transaction_type");
		if (Transaction_type == null ) Transaction_type = "";

		String hcare_type_code = request.getParameter("hcare_type");
		if(hcare_type_code==null) hcare_type_code="";
		
		String function_id = request.getParameter("function_id");
		if (function_id == null)   function_id = "";

		String ref_hcare_setting_type = request.getParameter("ref_hcare_setting_type");
		if (ref_hcare_setting_type == null)  ref_hcare_setting_type = "";
		
		String referred_to_value = request.getParameter("referred_to_value");
		if (referred_to_value == null)  referred_to_value = "";
		
		String ref_priority = request.getParameter("ref_priority");
		if (ref_priority == null)  ref_priority = "";
		
		String ref_specialty = request.getParameter("ref_specialty");
		if (ref_specialty == null)  ref_specialty = "";

		String ref_locn_type = request.getParameter("ref_locn_type");
		if (ref_locn_type == null)  ref_locn_type = "";
		
		
		String ref_locn_code = request.getParameter("ref_locn_code");
		if (ref_locn_code == null)  ref_locn_code = "";

		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(BodyFrame));
            _bw.write(_wl_block10Bytes, _wl_block10);

		/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/	
	       	if (function_id.equals("ModifyReferral")){
			referred_to_value=ref_to;
	         }
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
///********************************************************************************
/// Setting the Value For [ ORG TYPE ] For Different Referral Types ... 


            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(referred_to_code));
            _bw.write(_wl_block13Bytes, _wl_block13);

/// Func used to Populate Hcare Values based on Referral type & Module...
if(src1.equals("populateHcare"))
{
	int i=0;
	if(ref_type.equals("L"))
	{
		sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from sm_facility_param_lang_vw  a, am_hcare_setting_type_lang_vw b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.facility_id ='"+facility_id+"' and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.facility_name ";	


		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				i++;
				referredtoid=rs.getString("referred_to_id");
				referredtodesc=rs.getString("referred_to_id_desc");
				hcare_setting_type_desc=rs.getString("hcare_setting_type_desc");
				hcare_setting_type=rs.getString("hcare_setting_type_code");


			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(jsp_val));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(hcare_setting_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ref_hcare_setting_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hcare_setting_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(referred_to_id.equals(referredtoid) || ref_type.equals("L") || ref_type.equals("E")) 
					{
            _bw.write(_wl_block25Bytes, _wl_block25);
} 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(referred_to_value));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_priority));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ref_specialty));
            _bw.write(_wl_block31Bytes, _wl_block31);

			}// E.O While
		}// E.O If

		/// Added on 23 JULY 2004..
		/// This will be executed if there are no records found in Healthcare...
		if(i == 0 )
		{
			
			out.println("<script>alert(getMessage('REST_HCARE_SET','AM'));</script>");	
			out.println("<script>eval(BodyFrame).document.forms[0].referral_type.focus();</script>");
		}

		 if(rs != null) rs.close();
		 if(pstmt != null)pstmt.close();
	 
	}// E.O if(ref_type.equals("L")
	else
	if(ref_type.equals("E") || ref_type.equals("X"))
	{

		if(Module.equals("IP") || Transaction_type.equals("DA") || Transaction_type.equals("DP") )
		{
			/// Func used to Populate Hcare Values If Referral type is External or Enterprise  and Module is IP...
			sql= " SELECT HCARE_SETTING_TYPE_CODE, SHORT_DESC FROM AM_HCARE_SETTING_TYPE_LANG_VW  WHERE EFF_STATUS = 'E' AND HCARE_SETTING_TYPE_CODE = (SELECT FROM_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE IP_REFERRAL_YN = 'Y' AND FROM_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE UNION SELECT TO_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE IP_REFERRAL_YN = 'Y' AND TO_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE) and language_id='"+locale+"' order by SHORT_DESC ";

			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();

			if(rs!=null)
			{
				while(rs.next())
				{
					hcare_setting_type_desc	= rs.getString("SHORT_DESC");
					hcare_setting_type_code = rs.getString("HCARE_SETTING_TYPE_CODE");
				
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(hcare_setting_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ref_hcare_setting_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hcare_setting_type_code));
            _bw.write(_wl_block36Bytes, _wl_block36);

				}// E.O While
			}// E.O if
		
		   if(rs !=null ) rs.close();
		   if(pstmt!= null) pstmt.close();

		}
		else
		if(Module.equals("OP") || Transaction_type.equals("CO"))
		{
			/// Func used to Populate Hcare Values If Referral type is External or Enterprise  and Module is OP...
			sql = " SELECT HCARE_SETTING_TYPE_CODE, SHORT_DESC FROM AM_HCARE_SETTING_TYPE_LANG_VW   WHERE EFF_STATUS = 'E' AND HCARE_SETTING_TYPE_CODE = (SELECT FROM_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE OP_REFERRAL_YN = 'Y' AND FROM_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE UNION SELECT TO_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE OP_REFERRAL_YN = 'Y' AND TO_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE) and language_id='"+locale+"' order by SHORT_DESC ";

			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();

			if(rs!=null)
			{
				while(rs.next())
				{
					hcare_setting_type_desc	= rs.getString("SHORT_DESC");
					hcare_setting_type_code = rs.getString("HCARE_SETTING_TYPE_CODE");
				
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(hcare_setting_type_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ref_hcare_setting_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hcare_setting_type_code));
            _bw.write(_wl_block38Bytes, _wl_block38);

				}// E.O While
			}// E.O if
			 /*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/
			 if (isForAdmission && function_id.equals("ModifyReferral") && ref_type.equals("X")) { 
            _bw.write(_wl_block39Bytes, _wl_block39);
 }
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
			
		  if(rs != null) rs.close();
		  if(pstmt != null) pstmt.close();

		}
	}// E.O ref_type

	if(ref_type.equals("E") || ref_type.equals("L"))
	{
		/// <<<<< OP + IP >>>>> Value	
		sql=" select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		if(rs!=null)
		{
			if (rs.next())
			{
				ip	= rs.getInt(1);
				op	= rs.getInt(2);
			}
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		try{
       	 //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		if(isForAdmission && (function_id.equals("ModifyReferral") || function_id.equals("for_admission") ) )
			{
			if(ip > 0)
				{
				if ((ref_type.equals("L")||ref_type.equals("E")) && op > 0)
					{
					if(Option.equals("Y"))
						{
						loc_sql="care_locn_type_ind in ('D','N') and locn_type in ('Y','N') ";
						}
					else
						{
						loc_sql="care_locn_type_ind in ('D') and locn_type in ('Y') ";
						}
					}
				else 
					{
					loc_sql="care_locn_type_ind in ('N') and locn_type in ('N') ";
					}
				}	
				
			}
		else {
		if(ip > 0)
		{
			if ((ref_type.equals("L")||ref_type.equals("E")) && op > 0)
			{
				if(Option.equals("Y"))
				{
			 loc_sql="care_locn_type_ind in ('C','E','D','N') and locn_type in ('C','E','Y','N') ";
				}
				else
				{
			loc_sql="care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') ";
				}
			}else 
		       {
			 loc_sql="care_locn_type_ind in ('N') and locn_type in ('N') ";
			  }
		}else if (op >0 )
			{
			loc_sql="care_locn_type_ind in ('C') and locn_type in ('C') ";
			}
		}
		sql="select short_desc,locn_type,care_locn_type_ind from AM_CARE_LOCN_TYPE_LANG_VW where "+loc_sql+" and  SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc";
         
            _bw.write(_wl_block40Bytes, _wl_block40);

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		 if(rs != null)
			{
			  while(rs.next())
				{
				   locdesc=rs.getString(1);
				   loctype=rs.getString(2);
				
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(locdesc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(loctype));
            _bw.write(_wl_block43Bytes, _wl_block43);

				 }
			  
				/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/
				if (isForAdmission && function_id.equals("ModifyReferral")) { 
            _bw.write(_wl_block44Bytes, _wl_block44);
 
				/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
					/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
				}
				else if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")) { 
            _bw.write(_wl_block45Bytes, _wl_block45);
 	
					}
					/*End MMS-DM-CRF-0187*/
					
					 /*Below line Added for this CRF Bru-HIMS-CRF-261*/	
				 
            _bw.write(_wl_block46Bytes, _wl_block46);

			  /*End this CRF Bru-HIMS-CRF-261*/
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}


}// E.O if(src1.equals("populateHcare"))



if(src1.equals("populateReferredTo")){
	if(ref_type.equals("E")){			

		//String HCARE_TYPE_CODE = request.getParameter("hcare_type");
		//sql= " SELECT FACILITY_ID REFERRED_TO_ID, FACILITY_NAME REFERRED_TO_ID_DESC FROM SM_FACILITY_PARAM_LANG_VW WHERE FACILITY_ID != '"+facility_id+"' AND  HCARE_SETTING_TYPE_CODE='"+HCARE_TYPE_CODE+"' and language_id='"+locale+"' order by 2";

		//pstmt=con.prepareStatement(sql);
		//rs=pstmt.executeQuery();

		//if(rs!=null)	{
			//while(rs.next()){
				//referredtoid	=	rs.getString("REFERRED_TO_ID");
				//referredtodesc	=	rs.getString("REFERRED_TO_ID_DESC");
			
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(referred_to_value));
            _bw.write(_wl_block50Bytes, _wl_block50);

			//}// E.O while
		//}// E.O if
	
	  //if(rs != null) rs.close();
	  //if(pstmt != null) pstmt.close();

	}else if( ref_type.equals("X")){
		if(Module.equals("IP") || Transaction_type.equals("DA") || Transaction_type.equals("DP") ){

			//String HCARE_TYPE_CODE = request.getParameter("hcare_type");
			//sql = "SELECT LONG_DESC, REFERRAL_CODE FROM AM_REFERRAL_LANG_VW    WHERE EFF_STATUS = 'E' AND DEST_USE_AT_DISCH_YN = 'Y' AND HEALTHCARE_SETTING_TYPE='"+HCARE_TYPE_CODE+"' and language_id='"+locale+"' order by 1 ";
			
			//pstmt=con.prepareStatement(sql);
			//rs=pstmt.executeQuery();

			//if(rs!=null){
				//while(rs.next()){
					//referredtoid	=	rs.getString("REFERRAL_CODE");
					//referredtodesc	=	rs.getString("LONG_DESC");
				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(referred_to_value));
            _bw.write(_wl_block54Bytes, _wl_block54);

				//}// E.O while
			//}// E.O if
		
		//if(rs != null) rs.close();
		//if(pstmt != null) pstmt.close();

		}else if(Module.equals("OP") || Transaction_type.equals("CO")) {

			//String HCARE_TYPE_CODE = request.getParameter("hcare_type");
			//sql= " SELECT LONG_DESC, REFERRAL_CODE FROM AM_REFERRAL_LANG_VW WHERE EFF_STATUS = 'E' AND DEST_USE_AT_CONCL_YN = 'Y' AND //HEALTHCARE_SETTING_TYPE ='"+HCARE_TYPE_CODE+"' and language_id='"+locale+"' order by 1 ";

			///pstmt=con.prepareStatement(sql);
			//rs=pstmt.executeQuery();

			//if(rs!=null)			{
				//while(rs.next())				{
					//referredtoid	=	rs.getString("REFERRAL_CODE");
					//referredtodesc	=	rs.getString("LONG_DESC");
				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block55Bytes, _wl_block55);

				//}// E.O while
			//}// E.O if
		 // if(rs!= null) rs.close();
		 // if(pstmt!= null)  pstmt.close();
		}
	}

//// Added FOR LOCATION 
if(ref_type.equals("E") || ref_type.equals("L"))
{
	sql="select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";

	pstmt=con.prepareStatement(sql);
	rs=pstmt.executeQuery();
	
	if(rs!=null)
	{
		if (rs.next())
		{
			ip	= rs.getInt("ip");
			op	= rs.getInt("op");
		}
	}

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	//-----

   try{
       	       	 //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		if(isForAdmission && (function_id.equals("ModifyReferral") || function_id.equals("for_admission")))
			{  	
		if(ip > 0)
		{
			if (ref_type.equals("L") && op > 0)
			{
				if(Option.equals("Y"))
				{
			 loc_sql="care_locn_type_ind in ('D','N') and locn_type in ('Y','N') ";
				}
				else
				{
			loc_sql="care_locn_type_ind in ('D') and locn_type in ('Y') ";
				}
			}else if (op > 0)
			{
				if(Option.equals("Y")&& !function_id.equals("RegisterInpatientReferral"))
				{
			 loc_sql="care_locn_type_ind in ('D','N') and locn_type in ('Y','N') ";
				}
				else
				{
			loc_sql="care_locn_type_ind in ('D') and locn_type in ('Y') ";
				}
			}
			else 
		       {
			 loc_sql="care_locn_type_ind in ('N') and locn_type in ('N') ";
			  }
		}else if (op >0 )
			{
			loc_sql="care_locn_type_ind in ('C') and locn_type in ('C') ";
			}
		}else {
					if(ip > 0)
		{
			if (ref_type.equals("L") && op > 0)
			{
				if(Option.equals("Y"))
				{
			 loc_sql="care_locn_type_ind in ('C','E','D','N') and locn_type in ('C','E','Y','N') ";
				}
				else
				{
			loc_sql="care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') ";
				}
			}else if (op > 0)
			{
				if(Option.equals("Y")&& !function_id.equals("RegisterInpatientReferral"))
				{
			 loc_sql="care_locn_type_ind in ('C','E','D','N') and locn_type in ('C','E','Y','N') ";
				}
				else
				{
			loc_sql="care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') ";
				}
			}
			else 
		       {
			 loc_sql="care_locn_type_ind in ('N') and locn_type in ('N') ";
			  }
		}else if (op >0 )
			{
			loc_sql="care_locn_type_ind in ('C') and locn_type in ('C') ";
			}
		}
		sql="select short_desc,locn_type,care_locn_type_ind from AM_CARE_LOCN_TYPE_LANG_VW where "+loc_sql+" and  SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc";
         
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		 if(rs != null)
			{
			  while(rs.next())
				{
				   locdesc=rs.getString(1);
				   loctype=rs.getString(2);
				
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(locdesc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(loctype));
            _bw.write(_wl_block56Bytes, _wl_block56);

				 }
					//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
					if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
            _bw.write(_wl_block57Bytes, _wl_block57);
}
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}catch(Exception e){e.printStackTrace();}
	}
}

/// The function will query the SPECIALTY options if Referral Type is External..
if(src1.equals("populateSpecialty"))
{
	String hcare_code   = request.getParameter("hcare_code");
	String ref_to_code	= request.getParameter("ref_to_code");

	if(ref_to_code ==null) ref_to_code  ="";
	if(hcare_code==null) hcare_code="";

	if(ref_type.equals("X"))
	{
		String specialty_short_desc	= "";
		String specialty_code		= "";
		
		
			
			pstmt=con.prepareStatement("Select specialty_code,am_get_Desc.am_speciality(specialty_code,'"+locale+"',2) specialty_short_desc from am_referral_for_specialty_vw where referral_code='"+ref_to_code+"' order by 2");
			rs		= pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					specialty_code		= rs.getString("specialty_code");
					specialty_short_desc= rs.getString("specialty_short_desc");
					
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block60Bytes, _wl_block60);
	}	
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

	}//if ref type='X'

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block62Bytes, _wl_block62);

	ServiceCode = "";
	ServiceDesc = "";

	String reff_to_code	= request.getParameter("ref_to_code");
	if(reff_to_code ==null) reff_to_code  ="";	

	pstmt=con.prepareStatement("SELECT SHORT_DESC SERVICE_SHORT_DESC, SERVICE_CODE FROM AM_SERVICE_LANG_VW WHERE EFF_STATUS = 'E' and language_id='"+locale+"' order by 1");
	rs = pstmt.executeQuery();
	
	if(rs != null)
	{
		while(rs.next())
		{
			ServiceCode = rs.getString("SERVICE_CODE");
			ServiceDesc	= rs.getString("SERVICE_SHORT_DESC");	

			
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(ServiceCode));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ServiceDesc));
            _bw.write(_wl_block65Bytes, _wl_block65);

		}
	}
	
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

}

if(src1.equals("populateServiceVals"))
{	
	
            _bw.write(_wl_block66Bytes, _wl_block66);

	ServiceCode = "";
	ServiceDesc = "";

	String reff_to_code	= request.getParameter("ref_to_code");
	if(reff_to_code ==null) reff_to_code  ="";
	
// for referral type  =  Login Facility or Enterprise
	sql = " SELECT b.SHORT_DESC, a.service_code FROM am_facility_service a , AM_SERVICE_LANG_VW b WHERE a.eff_status = 'E' AND a.operating_facility_id = '"+reff_to_code+"' and a.service_code = b.service_code and b.language_id='"+locale+"' ORDER BY 1 ";
	
	pstmt=con.prepareStatement(sql);
	rs = pstmt.executeQuery();
	if(rs != null)
	{
		while(rs.next())
		{
			ServiceCode = rs.getString("SERVICE_CODE");
			ServiceDesc	= rs.getString("SERVICE_SHORT_DESC");	
			
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(ServiceCode));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ServiceDesc));
            _bw.write(_wl_block65Bytes, _wl_block65);

		}
	}

	if(rs != null) rs.close();
	if(pstmt!= null) pstmt.close();
}
/*Below line added for this CRF ML-MMOH-CRF-0566*/
if(src1.equals("populateReason"))
{
String bedsideReferral=request.getParameter("bedsideReferral");
if(bedsideReferral==null) bedsideReferral="";

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(bedsideReferral));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bedsideReferral));
            _bw.write(_wl_block69Bytes, _wl_block69);

	
	String cancel_reason_code="", cancel_reason_desc="";
	if(bedsideReferral.equals("S")){
	   sql = "select contact_reason_code, contact_reason from am_contact_reason where cancel_ref_reason_yn='Y' order by contact_reason";
	}if(bedsideReferral.equals("X")){
	   sql = "select contact_reason_code, contact_reason from am_contact_reason where reject_ref_reason_yn='Y' order by contact_reason";	
	}
		
	pstmt=con.prepareStatement(sql);
	rs = pstmt.executeQuery();
	if(rs != null)
	{
		while(rs.next())
		{
			cancel_reason_code = rs.getString("contact_reason_code");
			if(cancel_reason_code==null) cancel_reason_code="";
			cancel_reason_desc	= rs.getString("contact_reason");	
			if(cancel_reason_desc==null) cancel_reason_desc="";
			
			
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(cancel_reason_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(cancel_reason_desc));
            _bw.write(_wl_block70Bytes, _wl_block70);

		}
	}

	if(rs != null) rs.close();
	if(pstmt!= null) pstmt.close();
}
//End this CRF ML-MMOH-CRF-0566

if(src1.equals("populateLocation"))
{
	/// Func used to Display Location Values based on Location Type...

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(loc_type));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(loc_type));
            _bw.write(_wl_block73Bytes, _wl_block73);

	if(service == null) service = "";

	String referred_to = request.getParameter("ref_to");
	if(referred_to == null) referred_to = "";

/// FOR Location Type = "clinic"
	if(loc_type.equals("C"))
	{	
		if(!service.equals(""))
		{
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql=" SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='C' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',2) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
				}else{
					sql=" SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='C' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',2) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
				}
			}else{
				sql=" SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='C' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',2) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
			}
		}
		else if(service.equals(""))
		{
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE, CARE_LOCN_TYPE_IND FROM OP_CLINIC_LANG_VW     WHERE EFF_STATUS = 'E' and clinic_type='C' AND FACILITY_ID = '"+referred_to+"' and language_id='"+locale+"' order by 1 ";
				}else{
					sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE, CARE_LOCN_TYPE_IND FROM OP_CLINIC_LANG_VW     WHERE EFF_STATUS = 'E' and clinic_type='C' AND FACILITY_ID = '"+referred_to+"' and speciality_code = '"+specialty+"' and language_id='"+locale+"' order by 1 ";
				}
			}else{
				sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE, CARE_LOCN_TYPE_IND FROM OP_CLINIC_LANG_VW     WHERE EFF_STATUS = 'E' and clinic_type='C' AND FACILITY_ID = '"+referred_to+"' and speciality_code = '"+specialty+"' and language_id='"+locale+"' order by 1 ";	
			}
		}

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		int clinic_cnt = 0;

		if(rs!=null)
		{
			while(rs.next())
			{
				clinicDesc			= rs.getString("CLINIC_DESC");
				clinicCode			= rs.getString("CLINIC_CODE");
				clinic_cnt ++;
				
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(clinicDesc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(clinicCode));
            _bw.write(_wl_block76Bytes, _wl_block76);
if((location1.equals(clinicCode)) || (ref_locn_code.equals(clinicCode)) )
				{
            _bw.write(_wl_block77Bytes, _wl_block77);
} 
            _bw.write(_wl_block78Bytes, _wl_block78);

			}// E.O While
		}// E.O If
		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral") && !specialty.equals("") && (clinic_cnt == 1)){
		
            _bw.write(_wl_block79Bytes, _wl_block79);

		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		
            _bw.write(_wl_block80Bytes, _wl_block80);

	}// E.O if(loc_type.equals("C"))

/// FOR Location Type = "NursingUnit [N]"
	if (loc_type.equals("N"))
	{
		if(!service.equals(""))
		{
		   sql=" SELECT long_desc nu_desc, nursing_unit_code FROM ip_nursing_unit_lang_vw WHERE eff_status = 'E' AND facility_id = '"+referred_to+"' AND service_code = '"+service+"'AND patient_class = 'IP' AND LOCN_TYPE = 'N'  and language_id='"+locale+"' UNION SELECT   ip_get_desc.IP_NURSING_UNIT(FACILITY_ID,NURSING_UNIT_CODE,'"+locale+"',1) nu_desc, nursing_unit_code FROM ip_nurs_unit_for_service_vw WHERE facility_id = '"+referred_to+"' AND service_code = '"+service+"' AND appl_patient_class = 'IP' ORDER BY 1 ";
		}
		else if(service.equals(""))
		{
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql="  Select distinct a.long_desc NU_DESC, a.nursing_unit_code NURSING_UNIT_CODE ,'N' open_to_all_pract_yn from ip_nursing_unit_lang_vw  a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+referred_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.locn_type='N' and a.patient_class = 'IP' and a.facility_id = b.facility_id and a.language_id='"+locale+"' order by 1 ";
				}else{
					sql="  Select a.long_desc NU_DESC, a.nursing_unit_code NURSING_UNIT_CODE ,'N' open_to_all_pract_yn from ip_nursing_unit_lang_vw  a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+referred_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.locn_type='N' and a.patient_class = 'IP' and a.facility_id = b.facility_id and b.specialty_code = '"+specialty+"' and a.language_id='"+locale+"' order by 1 ";
				}
			}else{
				sql="  Select a.long_desc NU_DESC, a.nursing_unit_code NURSING_UNIT_CODE ,'N' open_to_all_pract_yn from ip_nursing_unit_lang_vw  a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+referred_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.locn_type='N' and a.patient_class = 'IP' and a.facility_id = b.facility_id and b.specialty_code = '"+specialty+"' and a.language_id='"+locale+"' order by 1 ";
			}
		}

		pstmt=con.prepareStatement(sql);
		rs	  = pstmt.executeQuery();
		int nu_cnt = 0;

		if(rs!=null)
		{
			while(rs.next())
			{
				nursingUnitDesc	= rs.getString("NU_DESC");
				nursingUnitCode	= rs.getString("NURSING_UNIT_CODE");
				nu_cnt ++;
				
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(nursingUnitDesc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(nursingUnitCode));
            _bw.write(_wl_block76Bytes, _wl_block76);
if((location1.equals(nursingUnitCode)) || (nursingUnitCode.equals(ref_locn_code))) 
				{
            _bw.write(_wl_block81Bytes, _wl_block81);
} 
            _bw.write(_wl_block82Bytes, _wl_block82);

			}// E.O While
		}// E.O If

		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral") && !specialty.equals("") && (nu_cnt == 1)){
		
            _bw.write(_wl_block79Bytes, _wl_block79);

		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

	}// E.O if (loc_type.equals("N"))

/// FOR Location Type = "day care"
	if (loc_type.equals("Y"))
	{   
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 13-08-2023 start*/	
		String SqlAppend="UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1)  CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"'";
		if(isForAdmission && function_id.equals("ModifyReferral")){
			SqlAppend="";
			}
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 13-08-2023 end*/
		if(!service.equals(""))
		{ 
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql=" SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' AND clinic_type='Y' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and CARE_LOCN_TYPE_IND = 'D' and language_id='"+locale+"' "+SqlAppend+" order by 1 ";
				}else{
					sql=" SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' AND clinic_type='Y' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'D' and language_id='"+locale+"'  "+SqlAppend+" order by 1 ";
				}
			}else{
					sql=" SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' AND clinic_type='Y' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'D' and language_id='"+locale+"'  "+SqlAppend+" order by 1 ";
			}
		}
		else if(service.equals(""))
		{ 
		    //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql=" SELECT  CLINIC_CODE , long_desc SHORT_DESC FROM OP_CLINIC_LANG_VW  WHERE eff_status = 'E' AND FACILITY_ID = '"+referred_to+"' AND CLINIC_TYPE = 'Y' and CARE_LOCN_TYPE_IND = 'D' and language_id='"+locale+"'  ORDER BY 2";
				}else{
					sql=" SELECT  CLINIC_CODE , long_desc SHORT_DESC FROM OP_CLINIC_LANG_VW  WHERE eff_status = 'E' AND FACILITY_ID = '"+referred_to+"' AND CLINIC_TYPE = 'Y' and CARE_LOCN_TYPE_IND = 'D' and speciality_code = '"+specialty+"' and language_id='"+locale+"'  ORDER BY 2";
				}
			}else{
				sql=" SELECT  CLINIC_CODE , long_desc SHORT_DESC FROM OP_CLINIC_LANG_VW  WHERE eff_status = 'E' AND FACILITY_ID = '"+referred_to+"' AND CLINIC_TYPE = 'Y' and CARE_LOCN_TYPE_IND = 'D' and speciality_code = '"+specialty+"' and language_id='"+locale+"'  ORDER BY 2";
			}
		}
		pstmt=con.prepareStatement(sql);
		rs		= pstmt.executeQuery();
		int dc_cnt = 0;

		if(rs!=null)
		{
			while(rs.next())
			{
				nursingUnitDesc	= checkForNull(rs.getString("SHORT_DESC"));
				nursingUnitCode	= checkForNull(rs.getString("CLINIC_CODE"));
				dc_cnt ++;
				
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(nursingUnitDesc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(nursingUnitCode));
            _bw.write(_wl_block83Bytes, _wl_block83);
//	if(location1.equals(nursingUnitCode)) 
				//below line modified by lakshmanan for ML-MMOH-CRF-1972 on 13-08-2023
		if(location1.equals(nursingUnitCode) || (isForAdmission && function_id.equals("ModifyReferral") && nursingUnitCode.equals(ref_locn_code))) 
				{	
            _bw.write(_wl_block84Bytes, _wl_block84);
	} 
            _bw.write(_wl_block82Bytes, _wl_block82);

			}// E.O While
		}// E.O If
		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral") && !specialty.equals("") && (dc_cnt == 1)){
		
            _bw.write(_wl_block79Bytes, _wl_block79);

		}

		if(rs !=null) rs.close();
		if(pstmt != null) pstmt.close();

	
            _bw.write(_wl_block80Bytes, _wl_block80);

	
	}// E.O if (loc_type.equals("D"))

	if(loc_type.equals("E"))
	{	
		if(!service.equals(""))
		{	 
			 //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			 if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
		 			sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
				}else{
					sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
				}
			 }else{
				 sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
			 }
		}
		else if(service.equals(""))
		{
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' and clinic_type='E' AND FACILITY_ID = '"+referred_to+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' order by 1 ";
				}else{
					sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' and clinic_type='E' AND FACILITY_ID = '"+referred_to+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' order by 1 ";
				}
			}else{
				sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' and clinic_type='E' AND FACILITY_ID = '"+referred_to+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' order by 1 ";
			}
		}

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		int pu_cnt = 0;

		if(rs!=null)
		{
			while(rs.next())
			{
				clinicDesc	= rs.getString("CLINIC_DESC");
				clinicCode	= rs.getString("CLINIC_CODE");
				pu_cnt ++;
				
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(clinicDesc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(clinicCode));
            _bw.write(_wl_block76Bytes, _wl_block76);
	if((location1.equals(clinicCode))||(ref_locn_code.equals(clinicCode)))
					{	
						out.println("<script>opt.selected=true;</script>");
					} 
					out.println("<script> eval(BodyFrame).document.forms[0].location1.add(opt);");
					out.println("if (eval(BodyFrame).document.forms[0].location1.options[0].text === '---------Select---------') {");
					out.println("    eval(BodyFrame).document.forms[0].location1.options[0].value = '';}}");
						  
					
            _bw.write(_wl_block85Bytes, _wl_block85);

			}// E.O While
		}// E.O If
		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral") && !specialty.equals("") && (pu_cnt == 1)){
		
            _bw.write(_wl_block79Bytes, _wl_block79);

		}		

		if(rs != null) rs.close();
		if(pstmt !=null) pstmt.close();

	
            _bw.write(_wl_block80Bytes, _wl_block80);
	
	}
	/* added by lakhsmanan for ML-MMOH-CRF-1972  start*/
	if(function_id.equals("ModifyReferral")){
		String service_desc="";
		String modifyreferralsql="select am_get_desc.am_service(?,'en','2') as service_desc from dual";
		pstmt=con.prepareStatement(modifyreferralsql);
		pstmt.setString(1,service);
		rs=pstmt.executeQuery();
		System.err.println("in getReferralDetails.jsp 1243 service_desc=="+service_desc);
		System.err.println("in getReferralDetails.jsp 1243 service=="+service);
		System.err.println("in getReferralDetails.jsp 1243 ref_priority=="+ref_priority);
		if(rs!=null && rs.next()){
			service_desc=checkForNull(rs.getString("service_desc"));
		}
		if(rs != null) rs.close();
		if(pstmt !=null) pstmt.close();
		System.err.println("in getReferralDetails.jsp 1243 service_desc=="+service_desc);
		
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(loc_type));
            _bw.write(_wl_block88Bytes, _wl_block88);
}
	/* added by lakhsmanan for ML-MMOH-CRF-1972  end*/	
}

if(src1.equals("populateService"))
{
	String Nursing_unit	=	request.getParameter("Nursunit");
		if(Nursing_unit==null) Nursing_unit="";

	String Location_Type	=	request.getParameter("Location_Type");
		if(Location_Type==null) Location_Type="";

	String reff_to	=	request.getParameter("reff_to");
		if(reff_to==null) reff_to="";

	String speciality_code	=	request.getParameter("speciality_code");
		if(speciality_code==null) speciality_code="";

	if(ref_type.equals("L") || ref_type.equals("E"))
	{
		if(Location_Type.equals("Y")) // For DayCare
		{
			sql=" select service_code, short_desc from AM_SERVICE_LANG_VW  where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+Nursing_unit+"' and a.facility_id='"+reff_to+"' and a.care_locn_type_ind = 'D' and a.clinic_type='Y' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+reff_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+Nursing_unit+"') and language_id='"+locale+"' order by short_desc ";
		}
		else if(Location_Type.equals("C")) // For Clinic
		{
			sql=" select service_code, short_desc from AM_SERVICE_LANG_VW where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+Nursing_unit+"' and a.facility_id='"+reff_to+"' and a.care_locn_type_ind = 'C' and a.clinic_type='C' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+reff_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+Nursing_unit+"') and language_id='"+locale+"' order by short_desc ";

		}
		else if(Location_Type.equals("E")) // For Procedure Unit
		{
			sql=" select service_code, short_desc from AM_SERVICE_LANG_VW where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+Nursing_unit+"' and a.facility_id='"+reff_to+"' and a.care_locn_type_ind = 'E' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+reff_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+Nursing_unit+"') and language_id='"+locale+"' order by short_desc ";

		}
		else if(Location_Type.equals("N")) // For NursingUnit
		{
			sql=" select service_code, short_desc from AM_SERVICE_LANG_VW where service_code in(select a.service_code from ip_nursing_unit a where a.nursing_unit_code ='"+Nursing_unit+"' and a.facility_id='"+reff_to+"' and a.appl_patient_class = 'IP' union select a.service_code from ip_nurs_unit_for_service a,ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id=b.facility_id and a.facility_id='"+reff_to+"' and b.appl_patient_class = 'IP' and a.nursing_unit_code = '"+Nursing_unit+"') and language_id='"+locale+"' order by short_desc ";
		}
		
            _bw.write(_wl_block89Bytes, _wl_block89);

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();


		if(rs != null)
		{
			while(rs.next())
			{
				ServiceCode = rs.getString("service_code");
				ServiceDesc	= rs.getString("short_desc");		
				
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(ServiceDesc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(ServiceCode));
            _bw.write(_wl_block92Bytes, _wl_block92);

			}
		}
	if(rs != null ) rs.close();
	if(pstmt != null) pstmt.close();
	}
}	
		/*Below line Added for this CRF  Bru-HIMS-CRF-261 */
		if(src1.equals("populateBedclass") && !loc_code.equals("")){ 		
		sql=" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.IP_BED_CLASS(a.BED_CLASS_CODE,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facility_id+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+loc_code+"' ORDER BY short_desc ";
		
		
            _bw.write(_wl_block93Bytes, _wl_block93);

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();


		if(rs != null)
		{
			while(rs.next())
			{
				bedclasscode = rs.getString("bed_class_code");
				bedshortdesc	= rs.getString("short_desc");		
				
				
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bedshortdesc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block95Bytes, _wl_block95);

			}
	if(rs != null ) rs.close();
	if(pstmt != null) pstmt.close();
		}
		
/* Below line code populate the admision type CRF Bru-HIMS-CRF-261*/
sql="select admission_type_code,ip_get_desc.IP_ADMISSION_TYPE(admission_type_code,'"+locale+"',2) short_desc from IP_ADMISSION_TYPE where  eff_status='E' order by short_desc";
		
		
            _bw.write(_wl_block96Bytes, _wl_block96);

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
 		Boolean isAdmissionTypeAppl = CommonBean.isSiteSpecific(con,"IP","ADMISSION_TYPE_APPL");//Added by Shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618
        String admission_type	= eIP.IPCommonBean.getAdmissionType(con,facility_id);//Added by shanmukh on 1st-AUG-2018 for ML-MMOH-CRF-0618
	

		if(rs != null)
		{
			while(rs.next())
			{
				admissiontypecode = rs.getString("admission_type_code");
				admissiontypedesc	= rs.getString("short_desc");	
                //admissiontypecode="",admissiontypedesc="";				
				
				
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(admissiontypedesc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(admissiontypecode));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(isAdmissionTypeAppl));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(admissiontypecode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(admission_type));
            _bw.write(_wl_block99Bytes, _wl_block99);

			}
	if(rs != null ) rs.close();
	if(pstmt != null) pstmt.close();
		}
		
   //populate the admission type End Bru-HIMS-CRF-261
	}
/*Below code  for the popolate the bedtyp*/
if(src1.equals("populateBedtype") && !loc_code.equals("")&& !bedclass_code.equals("")){

sql="SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b WHERE b.language_id = '"+locale+"' and a.facility_id = '"+facility_id+"' AND a.nursing_unit_code = '"+loc_code+"' AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = '"+bedclass_code+"' AND a.eff_status='E' AND b.eff_status = 'E' AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc";
	
		
            _bw.write(_wl_block100Bytes, _wl_block100);

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();


		if(rs != null)
		{
			while(rs.next())
			{
				bedtypecode = rs.getString("bed_type_code");
				bedtypeshortdesc	= rs.getString("bed_type_short_desc");
              			
				
				
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bedtypeshortdesc));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(bedtypecode));
            _bw.write(_wl_block102Bytes, _wl_block102);

			}
	if(rs != null ) rs.close();
	if(pstmt != null) pstmt.close();
		}
	
   
	}
	
 //End  Bru-HIMS-CRF-261	

if (function_id.equals("DischargePatient"))
{	
            _bw.write(_wl_block103Bytes, _wl_block103);
	
}


            _bw.write(_wl_block104Bytes, _wl_block104);

	}catch(Exception e)
	{
		out.println(e);
	}
	finally 
	{ 
		try{
		
			if(rs!=null)		rs.close();
			if(pstmt != null) pstmt.close();
		}catch(Exception ee){}		

		if(con != null) ConnectionManager.returnConnection(con,request);		
	}
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block105Bytes, _wl_block105);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
