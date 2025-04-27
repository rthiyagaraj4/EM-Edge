package jsp_servlet._emp._jsp;

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
import org.json.simple.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __referraldetailscomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ReferralDetailsComponent.jsp", 1745466329012L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<TITLE>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</TITLE>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../html/text.css\'></link>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n\t<!--  -->\n\t<script src=\'../../eMP/js/ReferralDtls.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\n\t<!--Below line Added for this CRF  Bru-HIMS-CRF-261 -->\t\t\n\t<script src=\'../../eIP/js/AdmitPatient2.js\' language=\'javascript\'></script>\n\t<script src=\'../../eIP/js/AdmitPatient.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\nfunction Quickadmission(){\t\n\tif(document.forms[0].quick_admission){\n\tif(document.forms[0].quick_admission.checked){\n    for(var k=0; k< document.forms[0].referral_type.length; k++){\t\n\tif(document.forms[0].referral_type[k].value==\"L\"){\n\tdocument.forms[0].referral_type.value=document.forms[0].referral_type[k].value;\n\tdocument.forms[0].referral_type.disabled=true;\n\tgetval1(document.forms[0].referral_type);\n\t}\t\n  }\n\n for(var i=0; i< document.forms[0].ref_for_ip.length; i++){\t\n\tif(document.forms[0].ref_for_ip[i].value==\"A\"){\n\tdocument.forms[0].ref_for_ip.value=document.forms[0].ref_for_ip[i].value;\n\tdocument.forms[0].ref_for_ip.disabled=true;\n\t    }\n\t}\n\t\n\t\n\nfor(var r=0; r< document.forms[0].priority.length; r++){\t\n\tif(document.forms[0].priority[r].value==\"L\"){\n\tdocument.forms[0].priority.value=document.forms[0].priority[r].value;\t\n\t    }\n\t}\t\n\nif(document.getElementById(\'locntion_img\')) \ndocument.getElementById(\'locntion_img\').style.visibility\t= \'visible\';\nif(document.getElementById(\'PractImg\')) \ndocument.getElementById(\'PractImg\').style.visibility\t= \'visible\';\t\t\nif(document.getElementById(\'bedcode_img\')) \ndocument.getElementById(\'bedcode_img\').style.visibility\t= \'visible\';\nif(document.getElementById(\'locntion_type_img\')) \ndocument.getElementById(\'locntion_type_img\').style.visibility\t= \'visible\';\nif(document.getElementById(\'visit_adm_type_img\')) \ndocument.getElementById(\'visit_adm_type_img\').style.visibility\t= \'visible\';\nif(document.getElementById(\'service_desc_img\')) \ndocument.getElementById(\'service_desc_img\').style.visibility\t= \'visible\';\nif(document.getElementById(\'bedclass\')) \ndocument.getElementById(\'bedclass\').style.visibility\t= \'visible\';\nif(document.getElementById(\'bedclass1\')) \ndocument.getElementById(\'bedclass1\').style.visibility\t= \'visible\';\nif(document.getElementById(\'bedtype\')) \ndocument.getElementById(\'bedtype\').style.visibility\t= \'visible\';\nif(document.getElementById(\'bedtype1\')) \ndocument.getElementById(\'bedtype1\').style.visibility\t= \'visible\';\nif(document.getElementById(\'admtype\')) \ndocument.getElementById(\'admtype\').style.visibility\t= \'visible\';\nif(document.getElementById(\'admtype1\')) \ndocument.getElementById(\'admtype1\').style.visibility\t= \'visible\';\n\n\n\n\n\tvar len=document.forms[0].Bedcode.length;\n\tvar i=1;\n\twhile(i<len)\n\t{\n\t\tlen=document.forms[0].Bedcode.length\n\t\tdocument.forms[0].Bedcode.remove(i)\n\t}\n\t\n\tvar len=document.forms[0].bed_type.length;\t\n\tvar j=1;\n\twhile(j<len)\n\t{\n\t\tlen=document.forms[0].bed_type.length\n\t\tdocument.forms[0].bed_type.remove(j)\n\t} \n\t\n\tvar len=document.forms[0].visit_adm_type.length;\t\n\tvar k=1;\n\twhile(k<len)\n\t{\n\t\tlen=document.forms[0].visit_adm_type.length\n\t\tdocument.forms[0].visit_adm_type.remove(k)\n\t} \n\n\t\n\t\n//setTimeout(\"getlocationtype()\",200);\t\n   var locale= document.forms[0].locale_js.value;\n   var sys_dat = getCurrentDate(\"DMY\",locale);\t\n\tdocument.forms[0].preferred_date.value=sys_dat;\n\t\n\t}else{ \n      if(document.forms[0].referral_type){\n\t  document.forms[0].referral_type.disabled=false;\n\t  document.forms[0].referral_type.value=\"\";\n\t  }\n\t  if(document.forms[0].hcare_setting_type)\t{\n\t  document.forms[0].hcare_setting_type.disabled=false;\n\t  document.forms[0].hcare_setting_type.value=\"\";\n\t  }\n\t  if(document.forms[0].referral_source)\t{\n\t  document.forms[0].referral_source.disabled=false;\n\t  if (document.forms[0].onloadcount.value>0 ){  //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023\n\t  document.forms[0].referral_source.value=\"\";   \n\t  }\n\t  }\n\t  if(document.forms[0].ref_for_ip)\t{\n\t  document.forms[0].ref_for_ip.disabled=false;\n\t  document.forms[0].ref_for_ip.value=\"\";\n\t  }\n\t  if(document.forms[0].location0)\t{\n\t  document.forms[0].location0.disabled=false;\n\t  document.forms[0].location0.value=\"\";\n\t  }\n\t \n\t//getval1(document.forms[0].referral_type);popServiceXRef(document.forms[0].referral_type);\n\tdefaultLoginFacility();\n\n\tvar len=document.forms[0].Bedcode.length;\n\tvar i=1;\n\twhile(i<len)\n\t{\n\t\tlen=document.forms[0].Bedcode.length\n\t\tdocument.forms[0].Bedcode.remove(i)\n\t}\n\t\n\tvar len=document.forms[0].bed_type.length;\t\n\tvar j=1;\n\twhile(j<len)\n\t{\n\t\tlen=document.forms[0].bed_type.length\n\t\tdocument.forms[0].bed_type.remove(j)\n\t} \n\t\n\tvar len=document.forms[0].visit_adm_type.length;\t\n\tvar k=1;\n\twhile(k<len)\n\t{\n\t\tlen=document.forms[0].visit_adm_type.length\n\t\tdocument.forms[0].visit_adm_type.remove(k)\n\t} \n\t\n\tfor(var r=0; r< document.forms[0].priority.length; r++){\t\n\tif(document.forms[0].priority[r].value==\"L\"){\n\tdocument.forms[0].priority.value=\"\";\n\t//document.forms[0].ref_for_ip.disabled=true;\n\t    }\n\t}\t\n\n\t\n\nif(document.getElementById(\'locntion_img\')) \ndocument.getElementById(\'locntion_img\').style.visibility\t= \'hidden\';\t\nif(document.getElementById(\'PractImg\')) \ndocument.getElementById(\'PractImg\').style.visibility\t= \'hidden\';\t\nif(document.getElementById(\'bedcode_img\')) \ndocument.getElementById(\'bedcode_img\').style.visibility\t= \'hidden\';\nif(document.getElementById(\'locntion_type_img\')) \ndocument.getElementById(\'locntion_type_img\').style.visibility\t= \'hidden\';\nif(document.getElementById(\'visit_adm_type_img\')) \ndocument.getElementById(\'visit_adm_type_img\').style.visibility\t= \'hidden\';\nif(document.getElementById(\'service_desc_img\')) \ndocument.getElementById(\'service_desc_img\').style.visibility\t= \'hidden\';\nif(document.getElementById(\'bedclass\')) \ndocument.getElementById(\'bedclass\').style.visibility\t= \'hidden\';\nif(document.getElementById(\'bedclass1\')) \ndocument.getElementById(\'bedclass1\').style.visibility\t= \'hidden\';\nif(document.getElementById(\'bedtype\')) \ndocument.getElementById(\'bedtype\').style.visibility\t= \'hidden\';\nif(document.getElementById(\'bedtype1\')) \ndocument.getElementById(\'bedtype1\').style.visibility\t= \'hidden\';\nif(document.getElementById(\'admtype\')) \ndocument.getElementById(\'admtype\').style.visibility\t= \'hidden\';\nif(document.getElementById(\'admtype1\')) \ndocument.getElementById(\'admtype1\').style.visibility\t= \'hidden\';\t  \n\t  }\n\t  \n   }\n\n}\n\n/*function getlocationtype(){\nif(document.forms[0].location0){\nfor(var m=0; m< document.forms[0].location0.length; m++){ \n\tif(document.forms[0].location0[m].value==\"N\"){\n\tdocument.forms[0].location0.value=document.forms[0].location0[m].value;\n\t//clear_location(document.forms[0].location0.value);\t\n\tdocument.forms[0].location0.disabled=true;\n\t    }\n\t}\n\n}\n\n}*/\n\nfunction FnSetDefaultReferralType(){\n\tif(document.forms[0].referral_type!=null){\n\t\tgetval1(document.forms[0].referral_type);\n\t\tpopServiceXRef(document.forms[0].referral_type)\n\t}\n}\n//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362\nfunction disRecRefbut(){ \n\tif(document.forms[0].referral_type.value==\'X\' && document.forms[0].RecordReferralLetterNote.style.visibility == \'visible\'){ \n\tdocument.forms[0].RecordReferralLetterNote.disabled=true;\n\tparent.frames[1].document.forms[0].CA_REF_LETTER_NOTES_REC_YN.value=\"N\";\n\t}else{\n\tdocument.forms[0].RecordReferralLetterNote.disabled=false;\n\t}\n}\n/*Added by Dharma on 11th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] Start*/\n\nfunction defaultLoginFacility(){\n\n\tif(document.forms[0].referral_type!=null && document.forms[0].called_from.value!=\"CA\"){\n\n\t\tvar dropDown = document.forms[0].referral_type;\n\t\tvar i;\n\t\tvar isLoginFacility\t\t= \"\";\n\t\tfor (i = 0; i < dropDown.length; i++) {\n\t\t\tif(dropDown.options[i].value==\"L\"){\n\t\t\t\tisLoginFacility\t= \"Y\";\n\t\t\t\tbreak;\n\t\t\t}\n\t\t}\n\n\t\tif(isLoginFacility==\"Y\"){\n\t\t\tif(document.forms[0].hddFuncID.value==\"ModifyReferral\" && \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"!=\"\"){ //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 \n\t\t\t\tdocument.forms[0].referral_type.value\t= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"; \n\t\t\t\tif (\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"!=\"\" && \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"!=\"\"){\n\t\t\t\tdocument.forms[0].hcare_setting_type[0].value= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"; \n\t\t\t\tdocument.forms[0].hcare_setting_type.options[0].selected=true; \n\t\t\t\tdocument.forms[0].referral_source_lkp_but.onclick();\n\t\t\t\tdocument.forms[0].service_desc.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\tdocument.forms[0].service.value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\tdocument.forms[0].transfer_case_yn.checked=(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"==\"Y\")?true:false;\n\t\t\t\t}\n\t\t\t} else {\n\t\t\tdocument.forms[0].referral_type.value\t= \"L\";\n\t\t\t}\n\t\t\tdocument.forms[0].referral_type.onchange();\n\t\t}\n\t}\n}\n\nwindow.onload = function() {\n\tdefaultLoginFacility();\n}\n\n/*Added by Dharma on 11th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] End*/\n\n\n\t</script>\n\t<!--End this CRF  Bru-HIMS-CRF-261 -->\t\t\n\n</HEAD>\n<BODY onKeyDown = \'lockKey();\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="onload=\"FnSetDefaultReferralType();\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" >\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<TABLE id=\"referral_table\" cellspacing=0 cellpadding=0 border=\"0\" width=\"100%\" >\n\t<input type=\"hidden\" name=\"isForAdmissionAppl\" id=\"isForAdmissionAppl\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=\"hidden\" name=\"onloadcount\" id=\"onloadcount\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\t\t<input type=\'hidden\' name=\'hddModule\' id=\'hddModule\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t<input type=\'hidden\' name=\'hddOption\' id=\'hddOption\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type=\'hidden\' name=\'hddReasonForRef\' id=\'hddReasonForRef\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<input type=\'hidden\' name=\'hddBodyFrame\' id=\'hddBodyFrame\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type=\'hidden\' name=\'hddSubmitFrame\' id=\'hddSubmitFrame\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t<input type=\"hidden\" name=\"system_date\" id=\"system_date\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\t\t<input type=\"hidden\" name=\"system_date_time\" id=\"system_date_time\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t<input type=\"hidden\" name=\"hddref_service_code\" id=\"hddref_service_code\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n\t\t<input type=\"hidden\" name=\"hdd_Transaction_type\" id=\"hdd_Transaction_type\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t\t  <!--Below line modified for this CRF HSA-CRF-0263.1-->\n\t\t<input type=\"hidden\" name=\"allow_muti_bedside_review_yn\" id=\"allow_muti_bedside_review_yn\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t\n\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" border=\'0\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"hddFuncID\" id=\"hddFuncID\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n\n\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t<tr><td><input type=\"hidden\" name=\"referred\" id=\"referred\" value=\"Y\" ></td>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'25%\' colspan=\'3\'></td></tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td   class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\'25%\' class=\'fields\'><input type=\'checkbox\' name=\'referred\' id=\'referred\' value=\"Y\" onClick=\'enable_referred(this);\' onblur=\'scrollView(this)\'></td>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' width=\'25%\' colspan=\'2\'></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\'fields\' ><input type=\'checkbox\' name=\'Bedside\' id=\'Bedside\' value=\"Y\" onClick=\'setVal();disRecRefbut();\'></td> <!--Modified by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->\n\t\t\t\t\t\t\t\t<td  class=\'label\' colspan=\'2\'></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n\t\t\t<!--Below line Added for this CRF  Bru-HIMS-CRF-261 -->\t\n\t\t\t<!--&&(!function_id.equals(\"RegPatRefFromAEAssessment\")) Added For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014\t -->\t\n             ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\" class=label height=5>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" <input type=checkbox name=\"quick_admission\" id=\"quick_admission\" id=\"quick_admission\" onclick=\"Quickadmission();disRecRefbut();\"></td>\n\t\t\t\t\t\t<!--Modified by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n             <!-- End Bru-HIMS-CRF-261  --->\n\t\t\t\t\t<tr>\n\t\t\t\t<!-- Referral Type -->\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t\t<td  width=\'25%\' class=\'fields\'><select name=\"referral_type\" id=\"referral_type\" onchange=\'getval1(this);popServiceXRef(this);disRecRefbut();\' disabled> <!--Modified by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<option value=\'\'>-----------";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="-----------</option>\n\t\t\t\t\t\t<option value=\'L\' ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" selected";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\n\t\t\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\n\t\t\t\t\t\t<option value=\'X\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option></select><img id=id1 src=\'../../eCommon/images/mandatory.gif\' style=\"visibility : hidden\"></td>\n\n\n\t\t\t\t<!-- Health Care Setting -->\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\' NOWRAP>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t\t<td  width=\'25%\' class=\'fields\' NOWRAP><select name=\"hcare_setting_type\" id=\"hcare_setting_type\"\tdisabled onchange=\'getval2(this.value)\' >\n\t\t\t\t\t\t\n\t\t\t\t\t\t<option value=\'\'>-----------";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="----------------------</option>\n\t\t\t\t\t\t</select><img id=id5 src=\'../../eCommon/images/mandatory.gif\'  style=\"visibility : hidden;\"></td>\n\n\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t<!-- Added by Afruddin for ML-MMOH-CRF-1527 US3 on 23.07.2020 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\" class=label height=5></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\n                     \t\t\t<td align=\'right\' class=\'label\' id=\'transfer_case\'nowrap >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t         \t<td><input type=\'checkbox\' name=\'transfer_case_yn\' id=\'transfer_case_yn\'value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" onclick=\'ChangeState(this)\'>\n\t\t\t\t\t </td>\n\t\t\t\t\t </tr>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\t\n                     \t\t\t<!-- Ended by Afruddin for ML-MMOH-CRF-1527 US3 on 23.07.2020 -->\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\" class=label height=5></td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t<!-- Referred To --> <!--Legend name  modified  for PMG2014-CRF-0007 [IN:046756] -->\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'  nowrap >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\'25%\' class=\'fields\' nowrap >\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- <select name=\"referred_to\" id=\"referred_to\" onchange=\'populate_hcare(this);populate_ext_specialty(this);\' disabled><option value=\'\'>----------------";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="-----------------</option></select> -->\n\t\t\t\t\t\t<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023 start -->\n\t\t\t\t\t\t<input type=\'text\' name=\'referral_source\' id=\'referral_source\' size=\'25\' maxlength=\"15\" onBlur =\'clear_ref();\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" ><input type=\'button\' class=\'button\' name=\'referral_source_lkp_but\' id=\'referral_source_lkp_but\' value=\'?\' onClick=\'referralSourceLookup(this)\' ><img id=id2 src=\'../../eCommon/images/mandatory.gif\'  style=\"visibility : hidden;\"><img src=\'../../eCommon/images/more.gif\' name=\"lng_name\" id=\"lng_name\" align=center style=\"visibility:hidden\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'referral_source_lkp_bkup_text\' id=\'referral_source_lkp_bkup_text\' size=\'15\' maxlength=\"15\" >\n\t\t\t\t\t\t<input type=\'hidden\' name=\'referred_to\' id=\'referred_to\' size=\'5\' maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" ></td>\n\t\t\t\t\t\t<!--  above line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023 end -->\n\t\t\t\t\t\t<!-- Specialty -->\n\t\t\t\t\t\n\t\t\t\t\t\t<td  class=\'label\' width=\'25%\'  nowrap>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\n\t\t\t\t\t\t<td class=\'FIELDS\'><INPUT TYPE=\"text\" name=\"speciality_desc\" id=\"speciality_desc\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" onblur=\'beforegetspeciality1(this,referred_to);populateServices(this);\' size=18  ><input type=\'button\' class=\'button\'  name=\'search_speciality\' id=\'search_speciality\' value=\'?\' onclick=\"getspeciality(speciality_desc,referred_to);\" >\n\t\t         \n\t\t\t\t\t\t <input type=\'hidden\' name=\'speciality\' id=\'speciality\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t <td class=\'FIELDS\'><INPUT TYPE=\"text\" name=\"speciality_desc\" id=\"speciality_desc\" value=\"\" onblur=\'beforegetspeciality1(this,referred_to);populateServices(this);\' size=18  ><input type=\'button\' class=\'button\'  name=\'search_speciality\' id=\'search_speciality\' value=\'?\' onclick=\"getspeciality(speciality_desc,referred_to);\" >\n\t\t         \n\t\t\t\t\t\t <input type=\'hidden\' name=\'speciality\' id=\'speciality\' value=\'\'>\n\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n\t\t           \n\t\t              \t\t            \n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<img id=id4 src=\'../../eCommon/images/mandatory.gif\' style=\"visibility : hidden;\"></td>\n\t\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\" class=label height=5></td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t\t<!-- Location -->\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'  nowrap>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t\t<td  width=\'25%\' class=\'fields\' nowrap >\n\t\t\t\t\t\t<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->\n\t\t\t\t\t\t<select name=\"location0\" id=\"location0\" onchange=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="clearSpecVal();";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="clear_location(this.value);\' ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =">\n\t\t\t\t\t\t<option value=\'\' >-------- ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="------</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<img id=\"locn_type_img\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility : hidden;\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'  nowrap>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n                        <!--Below line modified for this CRF Bru-HIMS-CRF-261 -->\n\t\t\t\t\t\t<td  width=\'25%\'  nowrap>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t <!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->\n\t\t\t\t\t\t <select name=\"location1\" id=\"location1\"  onchange=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="autoPopulateSpecialty(this.value);";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="populateBedclass(this.value);\' ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t<select name=\"location1\" id=\"location1\"   disabled>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t<option value=\'\'>---------";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="-----------</option>\t\t\t\t\n\t\t\t\t\t\t</select><img id=\"locntion_img\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility : hidden;\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=label></td>\n\t\t\t\t\t\t<td class=label></td>\n\t\t\t\t\t\t<td class=label></td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=text name=\"location2\" id=\"location2\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" onBlur=\"makeValidString(this)\" size=\"15\" maxlength=30 id = \'location2_text\' style = \'display:inline\' disabled>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'location_Desc\' id=\'location_Desc\' value=\"\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\" class=label height=5></td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t\t\t<!-- Service -->\n\t\t\t\t\t\t<td  class=\'label\' width=\'25%\'  nowrap  >";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\n\t\t\t\t\t\t<td class=\'FIELDS\'><INPUT TYPE=\"text\" name=\"service_desc\" id=\"service_desc\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" onblur=\'if(this.value != \"\")getServicelook1(this,referred_to)\' size=18  ><input type=\'button\' class=\'button\'  name=\'search_service\' id=\'search_service\' value=\'?\' onclick=\"getServicelook(speciality_desc,referred_to)\" >\n\t\t         \n\t\t\t\t\t\t <input type=\'hidden\' name=\'service\' id=\'service\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'><img id=\"service_desc_img\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden;\"></td>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t<td class=\'FIELDS\'><INPUT TYPE=\"text\" name=\"service_desc\" id=\"service_desc\" value=\"\" onblur=\'if(this.value != \"\")getServicelook1(this,referred_to)\' size=18  ><input type=\'button\' class=\'button\'  name=\'search_service\' id=\'search_service\' value=\'?\' onclick=\"getServicelook(speciality_desc,referred_to)\" >\n\t\t         \n\t\t\t\t\t\t <input type=\'hidden\' name=\'service\' id=\'service\' value=\'\'><img id=\"service_desc_img\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden;\"></td>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t<td class=\'FIELDS\'><INPUT TYPE=\'text\' name=\'service_desc\' id=\'service_desc\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'     onblur=\'if(this.value==\"\")document.forms[0].service.value=\"\"; getServicelook1(this,referred_to);\' size=18  ><input type=\'button\' class=\'button\'  name=\'search_service\' id=\'search_service\' value=\'?\' onclick=\"getServicelook(speciality_desc,referred_to)\" >\n\t\t         \n\t\t\t\t\t\t <input type=\'hidden\' name=\'service\' id=\'service\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' ><img id=\"service_desc_img\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden;\"></td>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\n\n\n\t\t\t\t<!-- Practitioner -->\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t\t\t\t<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->\n\t\t\t\t\t\t<td  width=\'25%\' class=\'fields\'><input type=text name=\"pract_name\" id=\"pract_name\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" onchange=\"disable_ext_pract(this);\" onBlur=\'makeValidString(this);disable_ext_pract(this);getPractitioner22(practitioner,pract_name); if(this.value==\"\")document.forms[0].practitioner.value=\"\";\' size=\"30\" maxlength=30 disabled\" ><input type=\"button\" name=\"pract_butt\" id=\"pract_butt\" value=\"?\" class=\"button\" style= \"Visibility : \'Visible\'\" onClick=\"getPractitioner2(practitioner,pract_name);\" disabled ><input type=\"hidden\" name=\"practitioner\" id=\"practitioner\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"><img id=\"PractImg\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden;\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t <input type=\'text\' name=\'from_ext_practitioner_id\'  value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" onchange=\"disable_pract(this);\"   onBlur = \"disable_pract(this);\" tabIndex=\'12\' size=25 maxlength=30 id = \'pract_ext_name\' style = \'display:none\' >\n\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\" class=label height=5></td>\n\t\t\t\t\t</tr>\n\n\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t<!-- Referred for -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t<tr><!--Legend name  modified  for PMG2014-CRF-0007 [IN:046756] -->\n\t\t\t\t\t\t<td  class=\'label\' width=\'25%\'  nowrap  >";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td  width=\'25%\'  nowrap class=\'fields\'><select name=\"ref_for_ip\" id=\"ref_for_ip\" onChange = \'\' disabled>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t<option value=\"\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" >----------------------";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="----------------------</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t<option value=\"A\" ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" >";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t<option value=\"B\" ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</option>\n\t\t\t\t\t\t\t</select><img id=\"refID\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:\'hidden\';\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\t\t\t\n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'  nowrap >";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'querydata\' width=\'25%\'  nowrap >";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t<!-- Pref Date -->\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'  nowrap >";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\'25%\' class=\'fields\' nowrap><input type=text name=\"preferred_date\" id=\"preferred_date\" size=10 maxlength=10  onBlur=\"validate_from_date(this);\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" disabled><img id=\"preferred_date_cal\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'preferred_date\',null);\" disabled><img id=\"prefDateImg\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility: hidden;\"></td>            \n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t<!-- Pref Date -->\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'  nowrap>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td  width=\'25%\' class=\'fields\' nowrap><input type=text name=\"preferred_date\" id=\"preferred_date\" size=10 maxlength=10  onBlur=\"validate_from_date(this); validatePrefDate(this);\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" disabled><img id=\"preferred_date_cal\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'preferred_date\',null);\" disabled> ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="<!-- <img id=\"prefDateImg\" src=\'../../eCommon/images/mandatory.gif\' style=\"\"> -->";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td> \n\t\t\t\t\t\t<!--above added by Mano on 18-April-2018 against ML-MMOH-CRF-1046-->\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"4\" class=label height=5></td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<!-- Reason For Ref -->\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'  nowrap >";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t\t\t\t\t<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->\n\t\t\t\t\t\t<td   width=\'25%\'  class=\'fields\' nowrap ><input type=\'text\' name=\'referral_reason_desc\' id=\'referral_reason_desc\' onBlur = \'if(this.value != \"\")blurgetReasonForRef(this); if(this.value==\"\")document.forms[0].referral_reason_code.value=\"\";\'  size=30 maxlength=60 value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" disabled><input type=\'button\' class=\'button\' name=\'ref_reason\' id=\'ref_reason\' value=\'?\' id = \'refReason\' onclick=\"getReasonForRef(this);\" disabled><input type=\'hidden\' name=\'referral_reason_code\' id=\'referral_reason_code\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- Priority -->\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'  nowrap >";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td  width=\'25%\' class=\'fields\' nowrap><select name=\"priority\" id=\"priority\" disabled>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" >--------";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="---------</option>\n\n\t\t\t\t\t\t\t<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->\n                               ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\n\t\t\t\t\t\t<!--Ended by Suji Keerthi for NMC-JD-CRF-0130-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t<option value=\"L\" ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t\t<option value=\"U\" ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</option>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\t\t<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->\n\t\t\t\t\t\t\t</select><img id=\"id3\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility : hidden;\"></td> \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t         <!--Below line Added for this CRF  Bru-HIMS-CRF-261 -->\t\n            ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\t\n                   <tr>\t\n\t\t\t\t\t<td colspan=\'4\'>&nbsp;</td>\n\t\t\t\t\t</tr>\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\"label\" id=\"bedclass\" style=\"visibility : hidden\">";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</td>\n\t\t\t\t\t<td  class=\"fields\"id=\"bedclass1\" style=\"visibility : hidden\" ><select name=\'Bedcode\' id=\'Bedcode\' onChange=\'populateBedType(this.value)\'  >\n\t\t\t\t\t<option value=\"\" selected>--- ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =" ---</option></select>\n\t\t\t\t\t<img id=\"bedcode_img\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility : hidden\"></td>\n\t\t\t\t\t<td  class=\"label\" id=\"bedtype\" style=\"visibility : hidden\">";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</td>\n\t\t\t\t\t<td  class=\"fields\" id=\"bedtype1\" style=\"visibility : hidden\"><select name=\"bed_type\" id=\"bed_type\">\n\t\t\t\t\t<option value=\"\" selected>--- ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =" ---</option></select>\n\t\t\t\t\t<img id=\"locntion_type_img\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility : hidden\"></td>\n\t\t\t\t</tr>\n           ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t \t<tr>\t\n\t\t\t\t\t<td colspan=\'4\'>&nbsp;</td>\n\t\t\t\t\t</tr> \n\t\t\t\t\t<!--End Bru-HIMS-CRF-261 -->\n\t\t\t\t\t<!--Below line Modified for this CRF Bru-HIMS-CRF-261 -->\n\t\t\t\t<tr>\t   ";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\t\t\t\n\t\t\t\t\t<td  class=\"label\" id=\"admtype\" style=\"visibility : hidden\">";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</td>\n\t\t\t\t\t<td class=\"fields\" id=\"admtype1\" style=\"visibility : hidden\">\n\t\t\t\t\t<select name=\"visit_adm_type\" id=\"visit_adm_type\" ><option value=\"\">--- ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =" ---</select><img id=\"visit_adm_type_img\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility : hidden;\"></td>\t\t\t\t\t\n\t\t\t\t\t<td >&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t<!--Below line Added for this CRF  Bru-HIMS-CRF-354 [IN:038538]-->\n\t\t\t\t\t<td class=\'label\' width=\'25%\' style=\"visibility:hidden\" id=\"frm_pract_image\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td  width=\'25%\' class=\'fields\' style=\"visibility:hidden\" id=\"frm_practn_name\"><input type=text name=\"frm_pract_name\" id=\"frm_pract_name\" value=\"\" onchange=\"disable_ext_pract(this);\" onBlur=\"makeValidString(this);disable_ext_pract(this);getPractitioner22(frm_practitioner,frm_pract_name);\" size=\"30\" maxlength=30   ><input type=\"button\" name=\"frm_pract_butt\" id=\"frm_pract_butt\" value=\"?\" class=\"button\"  onClick=\"getPractitioner2(frm_practitioner,frm_pract_name);\"  ><input type=\"hidden\" name=\"frm_practitioner\" id=\"frm_practitioner\" value=\"\"><img id=\"frm_practimg\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden;\">\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t   <!--end Bru-HIMS-CRF-354 [IN:038538] -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t\t\t\t<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->\n\t\t\t\t\t<td  class=\'fields\' width=\'25%\'  nowrap ><input type=";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 =" class=button value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' name=\'ReferralNotesButton\' onclick=\"referral_notes(\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\')\" onblur=\'scrollView(this)\' disabled>\n\t\t\t\t\t<input type = \'hidden\' name=\'ReferralNotes\' id=\'ReferralNotes\' value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" >\n\t\t\t\t\t<!--End Bru-HIMS-CRF-261 -->\n\t\t\t\t\t<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t\t<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->\n\t\t\t\t\t<input type=";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' name=\'RecordReferralLetterNote\' onclick=\"record_referral_note();\" style=\"Visibility : ";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =";\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->\n\t\t\t\t</tr>\t\t\t\t\t\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tenable_referred(document.forms[0].referred);</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t\t\t<script>document.forms[0].referred.disabled\t= true;</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"referred\" id=\"referred\" value=\"Y\" >\n\t\t\t\t\t\t\t<script>enable_referred(document.forms[0].referred);</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\n\t\t\t\t\t<script>//document.forms[0].priority.value = \"L\"; //this line commented for this Bru-HIMS-CRF-261</script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.forms[0].referral_type.value = \'X\' ;\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tpopExternal(document.forms[0].referral_type);\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t<script>\n\t\t\tdocument.forms[0].Bedside.value\t\t= \"Y\";\n\t\t\tdocument.forms[0].Bedside.checked\t= true;\n\t\t\tsetTimeout(\'setVal()\',200);\n\t\t\tdocument.forms[0].Bedside.disabled\t= true;\n\t\t</script>\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\n\t\t\t<input type=\"hidden\" name=\"ref_locn_type\" id=\"ref_locn_type\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t\t\t<input type=\"hidden\" name=\"ref_locn_code\" id=\"ref_locn_code\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t\t\t<input type=\"hidden\" name=\"ref_hcare_setting_type\" id=\"ref_hcare_setting_type\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t<input type=\"hidden\" name=\"referred_to_value\" id=\"referred_to_value\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t\t<input type=\"hidden\" name=\"ref_priority\" id=\"ref_priority\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t<input type=\"hidden\" name=\"ref_specialty\" id=\"ref_specialty\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t\t\t<input type=\"hidden\" name=\"locale_js\" id=\"locale_js\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t\t\t<input type=\"hidden\" name=\"functionid\" id=\"functionid\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t<input type=\"hidden\" name=\"regOutref\" id=\"regOutref\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" >\n\t\t\t<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->\n\t\t\t<input type=\"hidden\" name=\"calling_module\" id=\"calling_module\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" >\n\t\t\t<input type=\"hidden\" name=\"temp_field\" id=\"temp_field\" value=\"N\" >\n\t\t\t<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->\n\t\t\t<input type=\"hidden\" name=\"isRefDateNonMandatory\" id=\"isRefDateNonMandatory\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"> \n            <!--Added by Mano on 18-April-2018 against ML-MMOH-CRF-1046-->\n            <!-- Added by afruddin for ML-MMOH-CRF-1527 on 28 jun 2020-->\n            <input type=\'hidden\' name=\'isTransferCase\' id=\'isTransferCase\' value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'>\n\t\t\t<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->\n\t\t\t<input type=\"hidden\" name=\"isImproveReferralProcessAppl\" id=\"isImproveReferralProcessAppl\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" >\n\t\t\t<input type=\"hidden\" name=\"facilityid\" id=\"facilityid\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" >\n\t\t\t<input type=\"hidden\" name=\"multi_spec\" id=\"multi_spec\" value=\"N\" >\n\t\t\t<input type=\"hidden\" name=\"from_encounter_id1\" id=\"from_encounter_id1\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" >\n\t\t\n\t\t\t\n\t</TABLE>\n";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

	/*Below line Added for this CRF  Bru-HIMS-CRF-354 [IN:038538] */
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
            _bw.write(_wl_block2Bytes, _wl_block2);

///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// Module			: OP
/// Created By		: SRIDHAR R 
/// Created Date	: 3 JUNE 2004
/// Function		: This is a common component for Referral Details that can be included & called from any Module.

// Page included from these foll Modules..
//Module->	Function name
//------------------------
// IP	->	Register InPatient Referral
// IP	->	Discharge Advice
// IP	->	Discharge Patient
// OP	->	Check OUT
// AE	->	Check OUT

/* Example...
	<jsp:include page="../../eOP/jsp/ReferralDetailsComponent.jsp" flush="true" > 
		<jsp:param name ="bodyFrame" value= "Main Frame Reference" /> 	
		<jsp:param name ="submitFrame" value= "Messaage or Submit Frame Reference" /> 	
		-------------
	</jsp:include>*/
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

    String locale =((String)session.getAttribute("LOCALE"));
	String facility_id	= (String) session.getValue( "facility_id" ) ;
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con			=	null; 
	PreparedStatement pstmt = null;
	
	ResultSet rs			=	null;
		

            _bw.write(_wl_block5Bytes, _wl_block5);

		String function_id	= request.getParameter("function_id");
			if(function_id	== null) function_id = "";	
		
			String functionid	= request.getParameter("functionid");
			if(functionid	== null) functionid = "";	
			

		String called_from	= request.getParameter("called_from");
			if(called_from	== null) called_from = "";	

		String patient_status	= request.getParameter("patient_status");
			if(patient_status	== null) patient_status = "";	
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
			String referral_id	= request.getParameter("referral_id");
			if(referral_id	== null) referral_id = "";	
			String recFun	= request.getParameter("recFun");
			if(recFun	== null) recFun = "";	
			String recFunVal	= request.getParameter("recFunVal");
			if(recFunVal	== null) recFunVal = "";	
			String to_pract_id	= request.getParameter("to_pract_id");
			if(to_pract_id	== null) to_pract_id = "";	
			String to_pract_desc	= request.getParameter("to_pract_desc");
			if(to_pract_desc	== null) to_pract_desc = "";	
			String referral_reason_code	= request.getParameter("referral_reason_code");
			if(referral_reason_code	== null) referral_reason_code = "";	
			String referral_reason_desc	= request.getParameter("referral_reason_desc");
			if(referral_reason_desc	== null) referral_reason_desc = "";	
			String encounter_id=checkForNull(request.getParameter("from_encounter_id"));
			String transfer_case_yn=checkForNull(request.getParameter("transfer_case_yn"),"N");
			String to_pract_name=checkForNull(request.getParameter("to_pract_name"));
			String to_locn_desc=checkForNull(request.getParameter("to_locn_desc"));
			String to_service_desc=checkForNull(request.getParameter("to_service_desc"));
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 
		String discharge_indicator	= request.getParameter("discharge_indicator");
			if(discharge_indicator	== null) discharge_indicator = "";	

		// For IP Module Discharge Patient Function. To Default the values., Starts.
		String ref_type = request.getParameter("ref_type");
			if(ref_type == null)  ref_type = "";

		String ref_hcare_setting_type = request.getParameter("ref_hcare_setting_type");
			if(ref_hcare_setting_type == null)  ref_hcare_setting_type = "";

		String referred_to_value = request.getParameter("referred_to_value");
			if(referred_to_value == null)  referred_to_value = "";

		String ref_priority  = request.getParameter("ref_priority");
			if(ref_priority == null) ref_priority = "";

		String preferred_treatment_date  = request.getParameter("preferred_treatment_date");
			if(preferred_treatment_date != null)
			{
				preferred_treatment_date=DateUtils.convertDate(preferred_treatment_date,"DMY","en",localeName);
			}
			else
			preferred_treatment_date = "";

		String ref_specialty  = request.getParameter("ref_specialty");
			if(ref_specialty == null) ref_specialty = "";
		
		String ref_service_code  = request.getParameter("ref_service_code");
			if(ref_service_code == null) ref_service_code = "";

		String ref_locn_type  = request.getParameter("ref_locn_type");
			if(ref_locn_type == null) ref_locn_type = "";

		String ref_locn_code  = request.getParameter("ref_locn_code");
			if(ref_locn_code == null) ref_locn_code = "";

		String ref_locn_desc  = request.getParameter("ref_locn_desc");
			if(ref_locn_desc == null) ref_locn_desc = "";

		String referred_for  = request.getParameter("referred_for");
			if(referred_for == null) referred_for = "";

		String referral_notes_value  = request.getParameter("referral_notes");
			if(referral_notes_value == null) referral_notes_value = "";

			String splty_desc="";
			String ServiceDesc="";
		
		
		// For IP Module Discharge Patient Function. End.


            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(referred_to_value));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ref_hcare_setting_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ref_hcare_setting_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(to_service_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ref_service_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(transfer_case_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
if(function_id.equals("RegPatRefFromAEAssessment")){
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);

	try
	{
		con	= ConnectionManager.getConnection(request);	
		
	    Boolean isRefDateNonMandatory = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","NON_MNDT_FOR_PREF_DATE"); //Added by Mano on 18-April-2018 against ML-MMOH-CRF-1046
        Boolean isTransferCase	= eCommon.Common.CommonBean.isSiteSpecific(con,"MP","BMI_REG_PAT_CHNGES_RH101"); //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020

		 Boolean isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS"); //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		 /*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
                Boolean isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");
		String refButton="button"; 
		String locdisable="disabled"; 
		int onloadcount=1; 
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 
		 //Below Added by Suji Keerthi for NMC-JD-CRF-0130
			String priority_Code="";
			String priority_Desc="";
			JSONObject RefPriorityJson = new JSONObject();
			JSONArray refPriorityjsonArr = new JSONArray();	
			 Boolean isReferralPriorityAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","REFERRAL_PRIORITY_DESC");
			 RefPriorityJson = eIP.IPCommonBean.getReferralPriority(con); 
			 refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
			 

		String strReasonForRef	= request.getParameter("ReasonForRef");
			if(strReasonForRef	== null	) strReasonForRef = "N";
		
		String strModule	= request.getParameter("Module");
		if (strModule == null)  strModule = "";

		String strOption  = request.getParameter("Option");
			if(strOption == null) strOption = "Y";

		String strBodyFrame		= request.getParameter("bodyFrame");
		String strSubmitFrame	= request.getParameter("submitFrame");

		String Transaction_type	= request.getParameter("Transaction_type");
			if(Transaction_type	== null) Transaction_type = "";	

        /*Below line modified for this CRF HSA-CRF-0263.1*/
	    String allow_muti_bedside_review_yn = checkForNull(request.getParameter("allow_muti_bedside_review_yn"),"N");
		String select_value			= "";	
		String system_date			= "";
		String system_date_time	= "";
		
		/*Below line Added for this CRF Bru-HIMS-CRF-354 [IN:038538] */
		//String frm_practitioner_name=checkForNull(request.getParameter("frm_practitioner_name"));//commented for checkstyle voilation by Munisekhar
		//String frm_practitioner_id=checkForNull(request.getParameter("frm_practitioner_id"));//commented for checkstyle voilation by Munisekhar
		
		//End this CRF Bru-HIMS-CRF-354
		String quickadm=""; //this line Added for this CRF Bru-HIMS-CRF-261
		String regOutref=checkForNull(request.getParameter("regOutref"));		
		
		String facilityid=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
		String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user"));
		//this line Added for this CRF Bru-HIMS-CRF-261
		

		if(function_id.equals("RegisterInpatientReferral")) {

			system_date_time = request.getParameter("system_date_time");
			system_date = request.getParameter("system_date");
			
		} else {  /*Below line modidied for this CRF  Bru-HIMS-CRF 261*/
				//pstmt=con.prepareStatement("select to_char(sysdate,'dd/mm/rrrr hh24:mi')system_date_time, to_char(sysdate,'dd/mm/rrrr')system_date from dual");
				pstmt=con.prepareStatement("select to_char(sysdate,'dd/mm/rrrr hh24:mi')system_date_time, to_char(sysdate,'dd/mm/rrrr')system_date,AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+globaluser+"','X','','QUICK_ADMISSION_YN') quickadm  from dual");
				rs		= pstmt.executeQuery();

				if((rs != null) && (rs.next())) {
					system_date_time	= rs.getString("system_date_time");			
					system_date			= rs.getString("system_date");
					quickadm			= checkForNull(rs.getString("quickadm")); //this line Added for this CRF Bru-HIMS-CRF-261
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
		}
		
		system_date_time=DateUtils.convertDate(system_date_time,"DMYHM","en",localeName);
		system_date=DateUtils.convertDate(system_date,"DMY","en",localeName);
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 20-07-2023 start*/
		if(isForAdmission){
			 refButton="hidden";
			 if(function_id.equals("ModifyReferral")){
				 locdisable="";
				 onloadcount=0;
			 }
			 
			}
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 20-07-2023 end*/


            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(isForAdmission));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(onloadcount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strModule));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strOption));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strReasonForRef));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strSubmitFrame));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(system_date_time));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_service_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Transaction_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(allow_muti_bedside_review_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block33Bytes, _wl_block33);


								//System.out.println("function_id--->"+function_id);
								//out.println("-"+Transaction_type);
								
							if(function_id.equals("RegisterInpatientReferral"))
								{	
            _bw.write(_wl_block34Bytes, _wl_block34);
	}
								else if(!Transaction_type.equals("DA") && !Transaction_type.equals("DP") && !Transaction_type.equals("CO"))
								{	
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
	}	
            _bw.write(_wl_block37Bytes, _wl_block37);
	if(function_id.equals("RegisterInpatientReferral"))
							{	
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
	}	
            _bw.write(_wl_block40Bytes, _wl_block40);
if((!function_id.equals("RegisterInpatientReferral")) &&(!function_id.equals("RegPatRefFromAEAssessment")) && (!function_id.equals("PRE_DIS_ADVICE")) && (!quickadm.equals("1")) && (!quickadm.equals("2")) && (!quickadm.equals("3")) && (!quickadm.equals("4")) && (!quickadm.equals("5")) && !isForAdmission ){ 
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
if(function_id.equals("RegPatRefFromAEAssessment")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
 if(isTransferCase){
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(transfer_case_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
 }
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(referred_to_value));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(referred_to_value));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
 
							
						pstmt=con.prepareStatement(" Select Short_Desc  from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+locale+"' and Speciality_Code='"+ref_specialty+"'  order by 1");
						rs = pstmt.executeQuery();
						if(rs != null)
						{
							while(rs.next())
							{
								splty_desc=checkForNull(rs.getString("Short_Desc"));
							}
						}

						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();

						if(!splty_desc.equals(""))
						{
							
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(splty_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(ref_specialty));
            _bw.write(_wl_block64Bytes, _wl_block64);

						}else{
							 
            _bw.write(_wl_block65Bytes, _wl_block65);
 } 
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
if(isImproveReferralProcessAppl && (!function_id.equals("RegisterInpatientReferral"))){
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(locdisable));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
//if(functionid.equals("")){ 
						  if((!function_id.equals("RegisterInpatientReferral")) && (!function_id.equals("PRE_DIS_ADVICE"))){ 
						 
            _bw.write(_wl_block73Bytes, _wl_block73);
if(isImproveReferralProcessAppl || isForAdmission ){
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(locdisable));
            _bw.write(_wl_block76Bytes, _wl_block76);
 } else{
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(to_locn_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

						if(function_id.equals("DischargePatient"))
						{
			
							pstmt=con.prepareStatement("SELECT SHORT_DESC FROM AM_SERVICE_LANG_VW WHERE EFF_STATUS = 'E' and language_id='"+locale+"' and SERVICE_CODE='"+ref_service_code+"' order by 1");
							rs = pstmt.executeQuery();
							if(rs != null)
							{
								while(rs.next())
								{
									
									ServiceDesc= rs.getString("SHORT_DESC");

								}			
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
						

						if(!ServiceDesc.equals(""))
						{
						
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(ServiceDesc));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(ref_service_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
 }
						 else
							{  
            _bw.write(_wl_block85Bytes, _wl_block85);
 } 
						} else {
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(to_service_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(ref_service_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
 } 
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(to_pract_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(to_pract_id));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(to_pract_name));
            _bw.write(_wl_block93Bytes, _wl_block93);
if(!function_id.equals("RegisterInpatientReferral")){
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

							if (referred_for.equals(""))
								select_value = "Selected";
							else
								select_value = "";
						
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(select_value));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

							if (referred_for.equals("A"))
								select_value = "Selected";
							else
								select_value = "";
						
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(select_value));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

							if (referred_for.equals("B"))
								select_value = "Selected";
							else
								select_value = "";
						
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(select_value));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
}
            _bw.write(_wl_block104Bytes, _wl_block104);
if(function_id.equals("RegisterInpatientReferral")){
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block107Bytes, _wl_block107);
//	if(function_id.equals("RegisterInpatientReferral")){
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(preferred_treatment_date));
            _bw.write(_wl_block110Bytes, _wl_block110);
	}else{	
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(preferred_treatment_date));
            _bw.write(_wl_block113Bytes, _wl_block113);
if(!isRefDateNonMandatory){
            _bw.write(_wl_block114Bytes, _wl_block114);
}
            _bw.write(_wl_block115Bytes, _wl_block115);
//}
            _bw.write(_wl_block116Bytes, _wl_block116);
}
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(referral_reason_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(referral_reason_code));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

						if (ref_priority.equals(""))
							  select_value = "Selected";
						else  select_value = "";
						
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(select_value));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
 if(isReferralPriorityAppl && !function_id.equals("ModifyReferral")){ 	 // modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023

								   refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
					               for(int i = 0 ; i < refPriorityjsonArr.size() ; i++) 
				                   {
                             
									JSONObject jsonObj = (JSONObject) refPriorityjsonArr.get(i);
									priority_Code		= checkForNull((String) jsonObj.get("priority_Code"));
									priority_Desc		= checkForNull((String) jsonObj.get("priority_Desc"));
									out.println("<option value='"+priority_Code+"'>"+priority_Desc+"</option>");	
							
						           }	
						 
						 }else{
            _bw.write(_wl_block125Bytes, _wl_block125);

						if (ref_priority.equals("L") || (isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")))
							  select_value = "Selected";
						else  select_value = "";
						
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(select_value));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

						if (ref_priority.equals("U"))
							  select_value = "Selected";
						else  select_value = "";
						
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(select_value));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

						if (ref_priority.equals("E"))
							  select_value = "Selected";
						else  select_value = "";
						
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(select_value));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
} 
            _bw.write(_wl_block130Bytes, _wl_block130);
if((!function_id.equals("RegisterInpatientReferral")) && (!function_id.equals("PRE_DIS_ADVICE"))){ 
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
}
            _bw.write(_wl_block136Bytes, _wl_block136);
if(!function_id.equals("RegisterInpatientReferral")){ /*this line changed for this CRF Bru-HIMS-CRF-261*/
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
}else{
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
} 
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(refButton));
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(referral_notes_value));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(referral_notes_value));
            _bw.write(_wl_block146Bytes, _wl_block146);

					String 	dispButton="hidden";
					pstmt=con.prepareStatement("select CA_RECORD_REFERRAL_NOTE_YN from ip_param where facility_id='"+facilityid+"'");
					rs		= pstmt.executeQuery();
					if((rs != null) && (rs.next())) {
					if(checkForNull(rs.getString("CA_RECORD_REFERRAL_NOTE_YN")).equals("Y")){
					dispButton ="Visible";
					}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
					
					
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(refButton));
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(dispButton));
            _bw.write(_wl_block149Bytes, _wl_block149);
	if(function_id.equals("RegisterInpatientReferral"))
						{	
            _bw.write(_wl_block150Bytes, _wl_block150);
	}	
            _bw.write(_wl_block151Bytes, _wl_block151);
	if(function_id.equals("PrepareDischargeAdvice") && patient_status.equals("3"))
						{	
            _bw.write(_wl_block152Bytes, _wl_block152);
	}	

					if(function_id.equals("DischargePat") && patient_status.equals("3"))
						{	
            _bw.write(_wl_block152Bytes, _wl_block152);
	}	
            _bw.write(_wl_block151Bytes, _wl_block151);
	if(Transaction_type.equals("DA") || Transaction_type.equals("DP") || 		Transaction_type.equals("CO"))
						{	
            _bw.write(_wl_block153Bytes, _wl_block153);
	}	
            _bw.write(_wl_block154Bytes, _wl_block154);
	if(discharge_indicator.equals("ED"))
						{	
            _bw.write(_wl_block155Bytes, _wl_block155);
	}	
            _bw.write(_wl_block2Bytes, _wl_block2);
	if(called_from.equals("CA"))
	{	
            _bw.write(_wl_block156Bytes, _wl_block156);
	}	
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(ref_locn_type));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(ref_locn_code));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(ref_hcare_setting_type));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(referred_to_value));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(ref_priority));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(ref_specialty));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(functionid));
            _bw.write(_wl_block167Bytes, _wl_block167);
/*Below line Added for this CRF Bru-HIMS-CRF-261*/
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(regOutref));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(request.getParameter("calling_module")));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(isRefDateNonMandatory));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(isTransferCase));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(isImproveReferralProcessAppl));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block175Bytes, _wl_block175);

}catch(Exception e) 
{
	out.println(e.toString());
	e.printStackTrace();
}
finally
{
	try{
		if (rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}catch(Exception ee){}

	
	if(con != null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block176Bytes, _wl_block176);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargeAdvise.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Referred.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedSideReferral.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.QuickAdmission.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraltype.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.loginfacility.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enterprise.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.external.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HealthcareSettingType.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.TransferCase.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referredfor.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admit.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredDate.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforReferral.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.elective.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.semiemergency.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ReferraltoPractioner.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ReferralNotes.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RecordReferralLetterNote.label", java.lang.String .class,"key"));
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
}
