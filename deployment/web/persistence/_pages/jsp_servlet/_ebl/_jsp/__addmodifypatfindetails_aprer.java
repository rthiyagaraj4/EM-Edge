package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import eBL.Common.*;
import com.ehis.util.*;
import eBL.*;
import eBL.BLReportIdMapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetails_aprer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetails_APRER.jsp", 1743570876460L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<!-- ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" -->\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<html>\t\n<head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/Hashtable.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script language=\"javascript\" src=\"../../eBL/js/PkgSubs.js\"></script>\n\t<script language=\"javascript\" src=\'../../eBL/js/PkgAssociate.js\'></script> \n\t<script language=\"javascript\" src=\'../../eBL/js/AddModifyPatFinDetailsPkgDiscDtls.js\'></script> \n\t<script language=\"javascript\" src=\'../../eBL/js/PkgVisitDiscount.js\'></script>\n\t\n\t<script language=\"javascript\">\n\tasync function activeHealthCard(){\n\tvar patient_id = document.forms[0].patient_id.value;\n\tvar title = \'Maintain Health Card\';\n\t \n\n\t\tvar retVal =await window.showModalDialog(\'../../eBL/jsp/BillingPrevilageCardFrame.jsp?title=\'+title+\'&modPatientId=\'+patient_id+\'&called_from=PAS\',\'Maintain Health Card\',\'dialogWidth:800px; dialogHeight:600px;\');\n\t\t//alert(\'Active Health card\');\n\t}\n\t</script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n<script language=\'javascript\'>\n//Added for FD - Rajesh V\nasync function uploadImage(){\n\t\n\n\tvar patient_id  =document.forms[0].patient_id.value;\n\tif(patient_id == \'\') \n\t\tpatient_id = document.forms[0].cur_patient_id.value;\n\nvar uplurl=\tdocument.forms[0].uploadurl.value;\n\n\tvar dialogUrl = uplurl+\"title=Upload Document&patient_id=\"+patient_id;\n\tvar dialogFeatures  = \"dialogHeight:\" + \"20\" + \"; dialogWidth:\" + \"70\" +\" ; scroll=auto; \";\n\tvar returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);\t\n}\n//Added for FD - Rajesh V\n//Added by MuthuN agianst 32426 on 07-09-12\nfunction payerstatus()\n{\n\tvar settlement_ind = parent.frames[0].document.forms[0].setlmt_ind.value;\n//\talert(settlement_ind)\n\n//Modidified by DhanasekarV against Quick admission  May 06 2013\n\n\n//&& settlement_ind !=null & settlement_ind !=\'undefined\'&& settlement_ind !=\'\' \n//alert(\'enter \t  payerstatus()\');\n\tif(settlement_ind !=\'C\' && settlement_ind !=\'R\' ){ \n\t\t\n// \talert(parent.frames[1].name);//Karthik commented here\n// \talert(parent.frames[1].frames[0].name);\n// \talert(parent.frames[1].frames[0].frames[1]);\n// \talert(parent.frames[1].frames[0].frames[1].document.forms[0].name);\n// \tif(parent.frames[1].frames[0].name==\'Frame61\'){\n// \t\t rtn_total_records=0;\t\n// \t}\n\n\tvar rtn_total_records;\n\t//alert(\"flag\"+document.forms[0].adm_rec_flag.value);\n\tif(document.forms[0].adm_rec_flag.value== \"1\")\n\t\t{\n\t\trtn_total_records=0;\t\n\t\t}\n\telse{\n\t\trtn_total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;\t\n\t}\n \t\n\t\n\t//alert(rtn_total_records); //Karthik added this validation\n\t//if(rtn_total_records==null || rtn_total_records==\'\') rtn_total_records=0;\n\tvar cust_code = \"\";\n\tvar payer_suspended_YN =\"\";\n\tfor(var i=0;i<rtn_total_records;i++){\n\tcust_code =\teval(\"parent.frames[1].frames[0].frames[1].document.forms[0].cust_3\"+i);\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\tvar param=\"called_from=payersuspended&cust_code=\"+cust_code.value;\t\n\tvar temp_jsp=\"../../eBL/jsp/BLInsuranceValidations.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tresponseText=trimString(xmlHttp.responseText);\n\tvar retVal = responseText;\n\tpayer_suspended_YN = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].payer_suspended_YN\"+i);\n\tpayer_suspended_YN.value = retVal;\n\t}\n\t}\n//\talert(\'exit \t  payerstatus()\');\n}\n//Added by MuthuN agianst 32426 on 07-09-12\n\t\t\nfunction funHealthScheme()\n{\n\tvar calling_module_id = document.forms[0].calling_module_id.value;\n\tvar billing_mode = document.forms[0].billing_mode.value;\n\tvar hcard_applicable_yn = document.forms[0].hcard_applicable_yn.value;\n\tvar hcare_applicable_yn = document.forms[0].hcare_applicable_yn.value;\n\tvar hcard_scheme_id= document.forms[0].hcard_scheme_id.value;\n\tvar hcare_scheme_id= document.forms[0].hcare_scheme_id.value;\n\tvar hcard_expired_yn= document.forms[0].hcard_expired_yn.value;\n\tvar hcare_expired_yn= document.forms[0].hcare_expired_yn.value;\n\tvar previous_blng_grp= document.forms[0].previous_blng_grp.value;\n\tvar previous_blng_grp_desc= document.forms[0].previous_blng_grp_desc.value;\n\tvar hcard_prerequisite_yn= document.forms[0].hcard_prerequisite_yn.value;\n\tvar special_scheme_blng_grp = document.forms[0].special_scheme_blng_grp.value;\t \t\n\tvar special_scheme_blng_grp_desc = document.forms[0].special_scheme_blng_grp_desc.value;\n\tvar special_scheme_message = document.forms[0].special_scheme_message.value;\n\tvar special_scheme_flag = document.forms[0].special_scheme_type.value;\n\tvar patient_blng_grp = document.forms[0].patient_blng_grp.value;\n\t\t\t\n\tif (calling_module_id != \'MP\') \n\t{\n\t\tdocument.getElementById(\'patientSchemeID\').innerText = special_scheme_message;\n\n\t\tif (billing_mode == \'Add\')\t\t\t\n\t\t{\n\t\t\tif (document.forms[0].strdfltbgyn.value == \'Y\' && ( (hcard_applicable_yn == \'Y\') || (hcare_applicable_yn == \'Y\') ) )\n\t\t\t{\n\t\t\t\tdocument.forms[0].billing_group.value = special_scheme_blng_grp;\n\t\t\t\tdocument.forms[0].billing_group_desc.value = special_scheme_blng_grp_desc;\n\t\t\t\tif (document.forms[0].mblnggroup.value != document.forms[0].billing_group.value)\n\t\t\t\t\tcallSettlements(document.forms[0].billing_group);\n\t\t\t}\n\t\t}\t\n\t}\n\telse\n\t{\n\t\t//document.forms[0].billing_group.value = \'\';\n\t}\n\t\n\tfunHealthCardValue(document.forms[0].billing_group);\n}\n\nfunction pkgSubsMsgDisplay()\n{\n\tvar open_pkg_exists_yn = document.forms[0].open_pkg_exists_yn.value;\t\n\tif(open_pkg_exists_yn==\'Y\'){\n\t\t\t\tparent.frames[0].document.getElementById(\'pkgSubsMsg\').style.display=\"inline\";\n\t}\n\telse\n\t{\n\t\tparent.frames[0].document.getElementById(\'pkgSubsMsg\').style.display==\"none\";\n\t}\n\n}\nfunction funChangeBillingGroup(obj)\n{\n\tcallglholdercheck(obj,\"change_bg\");\t\t\t\t\n\tfunHealthCardValue(obj);\n//\tcallSettlements(obj);\t\n}\n\nfunction disableMappingItemsAll()\n{\n\tcallglholdercheck(document.forms[0].billing_group);\n\tdisableMappingItems();\n}\n\nfunction funHealthCardValue(obj)\n{\n\t\n\ttry\n\t{\n\t\ttry\n\t\t{\n\t\t\tparent.frames[2].document.forms[0].validated_state.value = \'N\';\n\t\t}\n\t\tcatch(e)\n\t\t{\n\t\t\t//out.println(e.toString());\n\t\t}\n\t\tvar healthCardTot = document.getElementById(\'HealthCardTot\').value;\n\t\tvar valueBlngGrp = document.PatFinMainForm.billing_group.value;\n\t\tvar arrConcatenatedScheme = new Array();\n\t\t//var totbgroup = document.PatFinMainForm.billing_group.length\n\n\t\tarrConcatenatedScheme = healthCardTot.split(\"|\");\n\t\tvar totbgroup = arrConcatenatedScheme.length;\n\t\tvar eachElement = new Array();\n\n\t\tfor (i=0;i<totbgroup;i++)\n\t\t{\t\n\t\t\teachElement = (arrConcatenatedScheme[i]).split(\"-\");\n\t\t\tif (eachElement[0] == valueBlngGrp)\n\t\t\t{\n\t\t\t\tif (eachElement[1] == \'N\' )\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'blngSchemeID\').innerText = \" \";\n\t\t\t\t\tdocument.getElementById(\'special_scheme_appl\').value = \'N\';\n\t\t\t\t}\n\t\t\t\telse if (eachElement[1] == \'C\' )\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'blngSchemeID\').innerText = \"HealthCard Applicable\";\n\t\t\t\t\tdocument.getElementById(\'special_scheme_appl\').value  = \'C\';\n\t\t\t\t}\n\t\t\t\telse if (eachElement[1] == \'R\' )\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'blngSchemeID\').innerText = \"HealthCare Applicable\";\n\t\t\t\t\tdocument.getElementById(\'special_scheme_appl\').value  = \'R\';\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tcatch(e)\n\t{\n\t\t//out.println(e.toString());\n\t}\n}\n\nfunction dispAlert()\n{\t\t\t\n\tvar module_id = document.forms[0].calling_module_id.value;\n\n\tif (module_id == \"MP\" ) \n\t{\n\t\talert(getMessage(\"BL9310\",\"BL\"));\n\t}\t\t\n\tfunChangeBillingGroup();\n}\n\nfunction dispExpAlert()\n{\n\n\tvar module_id = document.forms[0].calling_module_id.value;\n\n\tif (module_id == \"MP\" ) \n\t{\n\t\talert(getMessage(\"BL9305\",\"BL\"));\n\t}\n\tfunChangeBillingGroup();\n}\n\nfunction funModifyPatDet(valflg,enc_sel_check)\n{\t\n\tvar boolFlag = authScr(valflg,enc_sel_check);\t// \tenc_sel_check is added by manivel on 13-Jun-07  to make the form fields enable on change of Previous Encounters\n\n\tvar strdfltbgyn = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\n\tif(boolFlag[0] == \"Y\") //&& strdfltbgyn==\'N\')\n\t{\n\n\t//Dhanasekar\n\t document.forms[0].uploadurl.value =  \'../../eBL/jsp/AddModifyInsUpldImgFrame.jsp?\';\n\n\t\tvar fin_auth_user_id=boolFlag[3];\n\t\tdocument.forms[0].fin_auth_user_id.value=fin_auth_user_id;\n\t\tif(document.forms[0].blng_grp_sel_frm_pkg_YN.value == \"Y\")\n\t\t{\n\t\t\tdocument.forms[0].billing_group_desc.value = document.forms[0].selecltd_bg_frm_pkg.value;\n\t\t\tdocument.forms[0].blnggrpbut.click();\n\t\t}\n\t\tcallglholdercheck(document.forms[0].billing_group);\n\t\t//Update pat fin details check box enabled based on parameter value\n\t\t\n\t\tvar upd_fin_dtl_chkbx  =  document.forms[0].upd_fin_dtl_chkbx.value;\n\t\t\n\t\tif(upd_fin_dtl_chkbx==\'Y\')\n\t\t\t{\n\t\t document.forms[0].upd_fin_dtls.checked = true;\n\t\t document.forms[0].upd_fin_dtls.disabled = true;\n\t\t\t}\n\n\t\t//22/08/2005\n\t}\n//\t}\n\t//return(boolFlag);\n}\t\n\n\t\t\n\n\n// Added on 09/11/2003 -->\nasync function getBlngGrpSearch()\n{\n\tvar billing_group=document.forms[0].billing_group.value;\n\t\n\tif(billing_group==\"select\") billing_group=\"\";\n\n\tif(billing_group==\"\")\n\t{\n\t\t\talert(getMessage(\"BL9301\",\"BL\"));\n\t\t\treturn;\n\t\t\t//document.forms[0].billing_group.focus();\n\t}\n\t\t\n\tif((billing_group!=\"\"))\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"15\" ;\n\t\tvar dialogWidth\t= \"45\" ;\n\t\tvar dialogTop = \"280\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"../../eBL/jsp/BLBillingGrpDetFrame.jsp?billing_group=\t\"+billing_group;\n\t\tretVal =await window.showModalDialog(url,arguments,features);\n\t}\n}\n\nasync function getRefDet()\n{\n\tvar refid = document.forms[0].ref_id.value;\n\tvar retVal;\n\tvar dialogHeight= \"38.6\" ;\n\tvar dialogWidth\t= \"100\" ;\n\tvar dialogTop = \"110\" ;\n\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\tvar url = \"../../eMP/jsp/ViewPatReferral.jsp?referral_id=\"+refid;\n\tretVal =await window.showModalDialog(url,arguments,features);\t\t\t\n}\n\n/* --Commented for Explanatory display ench\n\nfunction blnggrplkup()\n{\t\n\n\tvar msg=\"\";\n\tvar target\t\t\t= document.forms[0].billing_group_desc;\n\tvar retVal\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar sql1\t\t\t\t= \"\";\n\tvar sql2\t\t\t\t= \"\";\n\tvar search_desc\t\t\t= \"\";\n\tvar tit\t\t\t\t\t= \"\";\t\t\n\tvar blnggrp\t\t\t= document.forms[0].blnggrp.value; \n\n\t//\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\n\tvar ExtBillingGroup = document.forms[0].ext_billing_group.value;\n\n\t//\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14_0 ="\';\t\t\t\t\n\n\tsql1 = \" select blng_grp_id, rpad(short_desc,15,` `)||` (` || decode(settlement_ind|| adm_rec_flag, `C`, \t`CASH`, `C0`,`CASH`,`C1`,`CASH`,`C2`,`CASH`,`R`, `CREDIT`,`R0`, `CREDIT`,`R1`, `CREDIT`,`R2`, `CREDIT`,`X1`, `SPONSOR`,`X2`,`INSURANCE`)||`)` from bl_blng_grp_vw where \";\n\n\tif ( blnggrp == \"1\" ) \n\t{\n\t\tsql2 = \"  nvl(ref_yn,`N`)=`Y` and nvl(hcare_only_yn,`N`) = `N` and nvl(status,`X` )!=`S` \";\n\t}\n\n\tif ( blnggrp == \"2\" ) \n\t{\n\t\tsql2 = \" nvl(ref_yn,`N`)=`Y` and nvl(ref_valid_for_regn_yn,`N`)=`Y` and nvl(status,`X` )!=`S` and nvl(hcare_only_yn,`N`) = `N` \" ;\t\n\t}\n\n\tif ( blnggrp == \"3\" ) \n\t{\n\t\tsql2 = \" nvl(op_yn,`N`)=`Y` and nvl(status,`X` )!=`S` and  nvl(health_card_appl_yn,`N`)=`N` and nvl(hcare_only_yn,`N`)=`N` \";\n\t}\n\n\tif ( blnggrp == \"4\" ) \n\t{\n\t\tsql2 = \"  nvl(ip_yn,`N`)=`Y` and nvl(status,`X` )!=`S` and nvl(health_card_appl_yn,`N`)=`N` and nvl(hcare_only_yn,`N`)=`N`\";   \n\t}\n\n\tif ( blnggrp == \"5\" ) \n\t{\n\t\tsql2 = \" nvl(status,`X` ) != `S` and nvl(health_card_appl_yn,`N`)= `N` and nvl(hcare_only_yn,`N`)=`N`\";\n\t}\n\n\tif (blnggrp == \"6\") \n\t{\n\t\tsql2 = \" nvl(status,`X` )!=`S` and blng_grp_id = `\" + ExtBillingGroup + \"` \";\n\t}\n\n\t// EPI TYPE ENH\n\n\tif ( blnggrp == \"7\" ) \n\t{\n\t\tsql2 = \" nvl(ae_yn,`N`)=`Y` and nvl(status,`X` )!=`S` and  nvl(health_card_appl_yn,`N`)=`N` and nvl(hcare_only_yn,`N`)=`N` \";\n\t}\n\n\tif ( blnggrp == \"8\" ) \n\t{\n\t\tsql2 = \" nvl(dy_yn,`N`)=`Y` and nvl(status,`X` )!=`S` and  nvl(health_card_appl_yn,`N`)=`N` and nvl(hcare_only_yn,`N`)=`N` \";\n\t}\n\n\tsql = sql1 + sql2;\t\t\t\n\t\t\n\tsearch_code=\"blng_grp_id\";\n\tsearch_desc=\"short_desc\";\n\ttit=\"Billing Groups \"; \n\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"::\");\n\t\n\t\tdocument.forms[0].billing_group_desc.value=arr[0].substring(0,16);\n\t    document.forms[0].billing_group.value=arr[1];\t\t\t\n\t\t\t\n\t\tfunChangeBillingGroup(document.forms[0].billing_group);\n\t}\n\telse\n\t{\t\t\t\t\n\t\t//document.forms[0].billing_group_desc.value=\'\';\n\t\t//document.forms[0].billing_group.value = \'\';\t\t\t\t\n\t\t//Commented on \t26/10/2004\n\t\t//\tfunChangeBillingGroup(document.forms[0].billing_group);\n\t\t//Comment ends\n\n\t\ttarget.focus();\n\t}\n}\n*/\n\n//Added by Rajesh V for CRF-155\nasync function blnggrplkupNew(clng_evnt){\n\t\n\tvar target\t\t\t= document.forms[0].billing_group_desc;\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\n\t\t\tdocument.forms[0].billing_group_desc.value = \"\";\n\t\t\tdocument.forms[0].billing_group.value = \"\";\n\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\treturn;\n\t\t}\n\t}\n\tvar locale = document.forms[0].locale.value;\n\tvar facility_id = document.forms[0].facility_id.value;\n\tvar blnggrp\t\t\t= document.forms[0].blnggrp.value; \t\t\n\tvar ExtBillingGroup = document.forms[0].ext_billing_group.value;\n\tvar strCitizenYn = document.forms[0].CitizenYn.value;\n\tvar patient_id= document.forms[0].patient_id.value;\n\tvar encounter_date = document.forms[0].encounter_date_aft_trunc.value;\n\tvar episode_type = document.forms[0].episode_type.value;\n\tvar function_id = document.forms[0].function_id.value;\n\tencounter_date = convertDate(encounter_date,\'DMY\',locale,\"en\");\n\tvar capture_employer_id_yn = document.forms[0].capture_employer_id_yn.value;\n\tvar dialogHeight= \"35\" ;\n\tvar dialogWidth\t= \"70\" ;\n\tvar dialogTop = \"200\" ;\n\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\t\n\tvar param = \'clng_evnt=\'+clng_evnt+\'&patient_id=\'+patient_id+\'&episode_type=\'+episode_type+\'&function_id=\'+function_id+\n\t\t\t\t\'&blnggrp=\'+blnggrp+\'&encounter_date=\'+encounter_date+\'&citizen_yn=\'+strCitizenYn+\'&ext_blng_grp=\'+ExtBillingGroup+\n\t\t\t\t\'&billingGroup=\'+target.value;\n\tvar retVal =await window.showModalDialog(\"../../eBL/jsp/BLFinDtlsBGPayerLookup.jsp?\"+param,arguments,features);\n\t\n\tvar arr=new Array();\t\t\n\n\tif(retVal == null) retVal=\'\';\n\n\tif (retVal != null || retVal!=\"\")\n\t{\n\t\tvar retVal=unescape(retVal);\n\t    if(retVal != null && retVal.length>0 && retVal!=\'Y\')\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\tvar is_blng_grp_pkg_link_YN = arr[9];\n\t\t\tif(is_blng_grp_pkg_link_YN == null) is_blng_grp_pkg_link_YN=\"N\";\n\t\t\tvar sel_bg_has_valid_pkg_YN = arr[10];\n\t\t\tif(sel_bg_has_valid_pkg_YN == null) sel_bg_has_valid_pkg_YN=\"N\";\n\n  \t\t    document.forms[0].billing_group_desc.value=arr[1];\n  \t\t\t//Added by Rajesh V - To avoid on Blur evnt if the Billing grp is not changed\n\t\t\tif(document.forms[0].billing_group.value == arr[0]){\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t//Added by Rajesh V - To avoid on Blur evnt if the Billing grp is not changed\n\t\t\t//.substring(0,16);\n\t\t\tdocument.forms[0].billing_group.value=arr[0];\n\n\t\t\tref_src_code_YN=arr[3];\n\t\t\tpmry_ref_src_mand_YN = arr[4];\n\t\t\tsec_ref_src_mand_YN = arr[5];\n\n\t\t\tdocument.forms[0].currency_code_for_bg.value=arr[6];\n\t\t\tdocument.forms[0].currency_desc_for_bg.value=arr[7];\n\t\t\tdocument.forms[0].PAYER_EMP_ID_MAND_YN.value=arr[8];\n\t\t\tdocument.forms[0].is_blng_grp_pkg_link_YN.value=is_blng_grp_pkg_link_YN;\n\t\t\tdocument.forms[0].sel_bg_has_valid_pkg_YN.value=sel_bg_has_valid_pkg_YN;\n\n\t\t\tif(is_blng_grp_pkg_link_YN == \"Y\" && sel_bg_has_valid_pkg_YN == \"N\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6360\",\"BL\"));\n\t\t\t\ttarget.value = \"\";\n\t\t\t\tdocument.forms[0].billing_group.value = \"\";\n\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t    /*if (billinggroup.length == 0 || \n\t\t\t\t (billinggroup.length > 0  && billinggroup != arr[0]))\n\t  \t    */\n\n\t\t\tdocument.forms[0].blnggrpappyn.value = \"Y\";\n\t\t\tdocument.forms[0].BlngGrpStatus.value = \"\";\n\t\t\tdocument.forms[0].blnggrpcatgappyn.value = \"Y\";\t\t\t\n\n\t\t\tfunChangeBillingGroup(document.forms[0].billing_group);\n\n\t\t\tif(ref_src_code_YN==\"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'ref_src_code_main_leg_disp\').style.display=\"inline\";\n\t\t\t\tdocument.getElementById(\'ref_src_code_main_val_disp\').style.display=\"inline\";\n\t\t\t\tdocument.forms[0].referral_source_main_code.value=\"\";\n\t\t\t\tdocument.forms[0].referral_source_main_desc.value=\"\";\n\t\t\t\tif(pmry_ref_src_mand_YN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'ref_src_code_main_mand_disp\').style.display=\"inline\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'ref_src_code_main_mand_disp\').style.display=\"none\";\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.getElementById(\'ref_src_code_sub_leg_disp\').style.display=\"inline\";\n\t\t\t\tdocument.getElementById(\'ref_src_code_sub_val_disp\').style.display=\"inline\";\n\t\t\t\tdocument.getElementById(\"referral_source_sub_code\").value=\"\";\n\t\t\t\tdocument.getElementById(\'referral_source_sub_desc\').value=\"\";\n\t\t\t\tif(sec_ref_src_mand_YN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'ref_src_code_sub_mand_disp\').style.display=\"inline\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'ref_src_code_sub_mand_disp\').style.display=\"none\";\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.forms[0].cap_ref_src_dtl_flag.value=\"Y\";\n\t\t\t\tdocument.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;\n\t\t\t\tdocument.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;\n\t\t\t}\n\t\t\telse if(ref_src_code_YN==\"N\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'ref_src_code_main_leg_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'ref_src_code_main_val_disp\').style.display=\"none\";\n\t\t\t\tdocument.forms[0].referral_source_main_code.value=\"\";\n\t\t\t\tdocument.forms[0].referral_source_main_desc.value=\"\";\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.getElementById(\'ref_src_code_sub_leg_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'ref_src_code_sub_val_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\"referral_source_sub_code\").value=\"\";\n\t\t\t\tdocument.getElementById(\'referral_source_sub_desc\').value=\"\";\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.forms[0].cap_ref_src_dtl_flag.value=\"N\";\n\t\t\t\tdocument.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;\n\t\t\t\tdocument.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;\n\t\t\t}\n\t\t\tcurr_code();//currency code desc \n\n\t\t\tif(capture_employer_id_yn == \'Y\')\n\t\t\t{\n\t\t\t\tif(document.forms[0].PAYER_EMP_ID_MAND_YN.value == \'Y\')\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'emp_id_mand_YN_disp\').style.display=\'inline\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'emp_id_mand_YN_disp\').style.display=\'none\';\n\t\t\t\t\tdocument.forms[0].employer_code.value=\"\";\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].employer_code.value=\"\";\n\t\t\t\tdocument.getElementById(\'emp_id_mand_YN_disp\').style.display=\'none\';\n\t\t\t}\n\t\t\tif(patient_id !== \"\")\n\t\t\t{\n\t\t\t\tif(document.forms[0].sel_bg_has_valid_pkg_YN.value == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'vw_pkg_dtl_disp\').style.display=\"inline\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'vw_pkg_dtl_disp\').style.display=\"none\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\t // funChangeBillingGroup(document.forms[0].billing_group);\n//\t\t\ttarget.focus();\n\t     }\n\t  }\n\n\t//Ajax Call Rajesh V\n\tvar ajBillingGroup = document.forms[0].billing_group.value\n\tif(ajBillingGroup.length>0){\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\tvar ajFacilityId = document.forms[0].facility_id.value;\n\t\tvar ajPatientid = document.forms[0].patient_id.value;\n\t\t\n\t\t//alert(ajBillingGroup)\n\t\tvar param=\"func_mode=getActiveHealthCardVis&facility_id=\"+ajFacilityId+\"&billGroup=\"+ajBillingGroup+\"&patient_id=\"+ajPatientid;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"../../eBL/jsp/PkgSubscriptionValidation.jsp?\"+param,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar responseText=trimString(xmlHttp.responseText);\t\n\t\t//alert(responseText);\n\t\t//responseText = \"Y\";\n\t\tif(responseText == \"Y\"){\n\t\t\tdocument.getElementById(\'ref_active_health_card_link\').style.display=\'inline\';\n\t\t}\n\t\telse{\n\t\t\tdocument.getElementById(\'ref_active_health_card_link\').style.display=\'none\';\n\t\t}\n\t}\t\t\n\t//Ajax Call Rajesh V\n\n\t//alert(\'This is end of fn\')\n}\n\nfunction blnggrplkup(clng_evnt)\n{\n\n\tvar target\t\t\t= document.forms[0].billing_group_desc;\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\n\t\t\tdocument.forms[0].billing_group_desc.value = \"\";\n\t\t\tdocument.forms[0].billing_group.value = \"\";\n\t\t\t";
    private final static byte[]  _wl_block14_0Bytes = _getBytes( _wl_block14_0 );

    private final static java.lang.String  _wl_block14_1 ="parent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\treturn;\n\t\t}\n\t}\n\tvar billinggroup    = document.forms[0].billing_group.value;\n\tvar retVal\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"130\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"50\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar sql1\t\t\t\t= \"\";\n\tvar sql2\t\t\t\t= \"\";\t\t\n\n\tvar cash_leg=getLabel(\"eBL.CASH.label\",\"BL\");\n\tcash_leg=encodeURIComponent(cash_leg);\n\tvar credit_leg=getLabel(\"eBL.CREDIT.label\",\"BL\");\n\tcredit_leg=encodeURIComponent(credit_leg);\n\tvar sponsor_leg=getLabel(\"eBL.SPONSOR.label\",\"BL\");\n\tsponsor_leg=encodeURIComponent(sponsor_leg);\n\tvar ins_leg=getLabel(\"Common.Insurance.label\",\"common\");\n\tins_leg=encodeURIComponent(ins_leg);\n\n//\tvar title=\"Billing Groups\";\n\tvar title=getLabel(\"Common.BillingGroup.label\",\"common\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"10%,20%,45%,5%,5%,5%,5%,5%,0%,0%,0%\");               \n//\tvar column_descriptions = escape(\"Code,Description,Explanatory Note\"); \n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n//\tvar slmt_type = getLabel(\"Common.SettlementType.label\",\"common\");\n//\tslmt_type=encodeURIComponent(slmt_type);\n\tvar expnote=getLabel(\"eBL.EXPLANATORY_NOTE.label\",\"BL\");\n\texpnote=encodeURIComponent(expnote);\n\tvar capt_ref_src_dtl=getLabel(\"eBL.CAPTURE_REF_SOURCE_DTL.label\",\"BL\");\n\tcapt_ref_src_dtl=encodeURIComponent(capt_ref_src_dtl);\n\tvar ref_source_main_mand_yn=getLabel(\"eBL.PRMY_REF_SRC_MAND.label\",\"BL\");\n\tref_source_main_mand_yn=encodeURIComponent(ref_source_main_mand_yn);\n\tvar ref_source_sub_mand_yn=getLabel(\"eBL.SEC_REF_SRC_MAND.label\",\"BL\");\n\tref_source_sub_mand_yn=encodeURIComponent(ref_source_sub_mand_yn);\n\tvar cust_curr_code=getLabel(\"eBL.CURR_CODE.label\",\"BL\");\n\tcust_curr_code=encodeURIComponent(cust_curr_code);\n\tvar curr_desc=getLabel(\"eBL.CURR_DESC.label\",\"BL\");\n\tcurr_desc=encodeURIComponent(curr_desc);\n\tvar emp_mand_YN = \"Employer ID Mand YN\";\n\temp_mand_YN = encodeURIComponent(emp_mand_YN);\n\tvar package_YN = \"Package YN\";\n\tpackage_YN = encodeURIComponent(package_YN);\n\tvar package_avail_YN = \"Package Available YN\";\n\tpackage_avail_YN = encodeURIComponent(package_avail_YN);\n\n\tvar column_descriptions = code+\",\"+desc+\",\"+expnote+\',\'+capt_ref_src_dtl+\",\"+ref_source_main_mand_yn+\",\"+ref_source_sub_mand_yn+\",\"+cust_curr_code+\",\"+curr_desc+\",\"+emp_mand_YN+\",\"+package_YN+\",\"+package_avail_YN;\n\n\tvar message = \'\';\n\tvar blnggrp\t\t\t= document.forms[0].blnggrp.value; \t\t\n\tvar ExtBillingGroup = document.forms[0].ext_billing_group.value;\n\tvar strCitizenYn = document.forms[0].CitizenYn.value;\n\tvar locale = document.forms[0].locale.value;\n\tvar facility_id = document.forms[0].facility_id.value;\n\tvar patient_id= document.forms[0].patient_id.value;\n\tvar encounter_date = document.forms[0].encounter_date_aft_trunc.value;\n\tvar strCitizenYn = document.forms[0].CitizenYn.value;\n\tvar episode_type = document.forms[0].episode_type.value;\n\tvar function_id = document.forms[0].function_id.value;\n\tencounter_date = convertDate(encounter_date,\'DMY\',locale,\"en\");\n\n\tvar capture_employer_id_yn = document.forms[0].capture_employer_id_yn.value;\n\n\tvar ref_src_code_YN=\"N\";\n\tvar pmry_ref_src_mand_YN=\"N\";\n\tvar sec_ref_src_mand_YN=\"N\";\n\tvar currency_code_for_bg = \"\";\n\tvar currency_desc_for_bg = \"\";\n\t\n\tsql = \"called_for=BGLKUP&locale=\"+locale+\"&facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&episode_type=\"+episode_type+\"&function_id=\"+function_id+\"&blnggrp=\"+blnggrp+\"&encounter_date=\"+encounter_date+\"&citizen_yn=\"+strCitizenYn+\"&ext_blng_grp=\"+ExtBillingGroup;\n/*\n\tsql1 = \"select blng_grp_id,short_desc||\'(\'||decode(settlement_ind||adm_rec_flag, \'C\',\'\"+cash_leg+\"\', \'C0\',\'\"+cash_leg+\"\',\'C1\',\'\"+cash_leg+\"\',\'C2\',\'\"+cash_leg+\"\',\'R\', \'\"+credit_leg+\"\',\'R0\', \'\"+credit_leg+\"\',\'R1\', \'\"+credit_leg+\"\',\'R2\', \'\"+credit_leg+\"\',\'X1\', \'\"+sponsor_leg+\"\',\'X2\',\'\"+ins_leg+\"\')||\')\' SRT_DESC,replace(detail_desc,chr(10),\'<br>\') DTL_DESC,nvl(CAPTURE_REF_SOURCE_DTL_YN,\'N\') CAP_REF_SRC_YN, nvl(REF_SOURCE_MAIN_MAND_YN,\'N\') REF_SRC_MN_MAND_YN, nvl(REF_SOURCE_SUB_MAND_YN,\'N\') REF_SRC_SB_MAND_YN,CURRENCY_CODE,CURRENCY_DESC,PR_PAYER_EMPLOYER_ID_MAND_YN,PACKAGE_YN,blcore.package_blng_grp_yn(\'\"+facility_id+\"\',\'\"+patient_id+\"\',\'\"+episode_type+\"\',\'\"+function_id+\"\',blng_grp_id,to_date(\'\"+encounter_date+\"\',\'DD/MM/YYYY\'),\'B\',DECODE(\'\"+strCitizenYn+\"\',\'Y\',\'NATIONALS\',\'N\',\'OTHERS\',\'UNRESTRICTED\')) PKG_AVAIL_YN from BL_BLNG_GRP_LANG_VW a where (NVL(category,\'UNRESTRICTED\') IN (DECODE(\'\"+strCitizenYn+\"\',\'Y\',\'NATIONALS\',\'N\',\'OTHERS\',\'UNRESTRICTED\'),\'UNRESTRICTED\')) and language_id=\'\"+locale+\"\' AND \";\n\n\tif ( blnggrp == \"1\" ) \n\t{\n\t\tsql2 = \"nvl(ref_yn,\'N\')=\'Y\' and nvl(hcare_only_yn,\'N\') = \'N\' and nvl(status,\'X\' )!=\'S\'\";\n\t}\n\n\tif ( blnggrp == \"2\" ) \n\t{\n\t\tsql2 = \"nvl(ref_yn,\'N\')=\'Y\' and nvl(ref_valid_for_regn_yn,\'N\')=\'Y\' and nvl(status,\'X\' )!=\'S\' and nvl(hcare_only_yn,\'N\') = \'N\'\" ;\t\n\t}\n\n\tif ( blnggrp == \"3\" ) \n\t{\n\t\tsql2 = \"nvl(op_yn,\'N\')=\'Y\' and nvl(status,\'X\' )!=\'S\' and  nvl(health_card_appl_yn,\'N\')=\'N\' and nvl(hcare_only_yn,\'N\')=\'N\'\";\n\t}\n\n\tif ( blnggrp == \"4\" ) \n\t{\n\t\tsql2 = \"nvl(ip_yn,\'N\')=\'Y\' and nvl(status,\'X\' )!=\'S\' and nvl(health_card_appl_yn,\'N\')=\'N\' and nvl(hcare_only_yn,\'N\')=\'N\'\";   \n\t}\n\n\tif ( blnggrp == \"5\" ) \n\t{\n\t\tsql2 = \"nvl(status,\'X\' )!=\'S\' and nvl(health_card_appl_yn,\'N\')= \'N\' and nvl(hcare_only_yn,\'N\')=\'N\'\";\n\t}\n\n\tif (blnggrp == \"6\") \n\t{\n\t\tsql2 = \"nvl(status,\'X\' )!=\'S\' and blng_grp_id=\'\"+ExtBillingGroup+\"\'\";\n\t}\n\n\t// EPI TYPE ENH\n\n\tif ( blnggrp == \"7\" ) \n\t{\n\t\tsql2 = \"nvl(ae_yn,\'N\')=\'Y\' and nvl(status,\'X\' )!=\'S\' and  nvl(health_card_appl_yn,\'N\')=\'N\' and nvl(hcare_only_yn,\'N\')=\'N\'\";\n\t}\n\n\tif ( blnggrp == \"8\" ) \n\t{\n\t\tsql2 = \"nvl(dy_yn,\'N\')=\'Y\' and nvl(status,\'X\' )!=\'S\' and  nvl(health_card_appl_yn,\'N\')=\'N\' and nvl(hcare_only_yn,\'N\')=\'N\'\";\n\t}\n\tsql = sql1 + sql2;\nalert(sql);\n\tsql = escape(sql);\t\n//\tsql = sql1 + sql2;\n\n\tsql = encodeURIComponent(sql,\"UTF-8\"); // Changed the logic for ICN - 5986 on 10/14/2008\n*/\n\tif(document.forms[0].blng_grp_sel_frm_pkg_YN.value == \"Y\")\n\t{\n\t\tdocument.forms[0].blng_grp_sel_frm_pkg_YN.value = \"N\";\n//\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YYYNNNNNNNN\";\n\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YYYNNNNNNNN\";\n\t}\n\telse\n\t{\n//\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYNNNNNNNN\";\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYNNNNNNNN\";\n\t}\n\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\t\n\n//\talert(\"retvalues \"+retVal);\n\tvar arr=new Array();\t\t\n\n\tif(retVal == null) retVal=\'\';\n\n\tif (retVal != null || retVal!=\"\")\n\t{\n\t\tvar retVal=unescape(retVal);\n\n\t    if(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\tvar is_blng_grp_pkg_link_YN = arr[9];\n\t\t\tif(is_blng_grp_pkg_link_YN == null) is_blng_grp_pkg_link_YN=\"N\";\n\t\t\tvar sel_bg_has_valid_pkg_YN = arr[10];\n\t\t\tif(sel_bg_has_valid_pkg_YN == null) sel_bg_has_valid_pkg_YN=\"N\";\n\n  \t\t    document.forms[0].billing_group_desc.value=arr[1];\n  \t\t\t//Added by Rajesh V - To avoid on Blur evnt if the Billing grp is not changed\n\t\t\tif(document.forms[0].billing_group.value == arr[0]){\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t//Added by Rajesh V - To avoid on Blur evnt if the Billing grp is not changed\n\t\t\t//.substring(0,16);\n\t\t\tdocument.forms[0].billing_group.value=arr[0];\n\n\t\t\tref_src_code_YN=arr[3];\n\t\t\tpmry_ref_src_mand_YN = arr[4];\n\t\t\tsec_ref_src_mand_YN = arr[5];\n\n\t\t\tdocument.forms[0].currency_code_for_bg.value=arr[6];\n\t\t\tdocument.forms[0].currency_desc_for_bg.value=arr[7];\n\t\t\tdocument.forms[0].PAYER_EMP_ID_MAND_YN.value=arr[8];\n\t\t\tdocument.forms[0].is_blng_grp_pkg_link_YN.value=is_blng_grp_pkg_link_YN;\n\t\t\tdocument.forms[0].sel_bg_has_valid_pkg_YN.value=sel_bg_has_valid_pkg_YN;\n\n\t\t\tif(is_blng_grp_pkg_link_YN == \"Y\" && sel_bg_has_valid_pkg_YN == \"N\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6360\",\"BL\"));\n\t\t\t\ttarget.value = \"\";\n\t\t\t\tdocument.forms[0].billing_group.value = \"\";\n\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t    /*if (billinggroup.length == 0 || \n\t\t\t\t (billinggroup.length > 0  && billinggroup != arr[0]))\n\t  \t    */\n\n\t\t\tdocument.forms[0].blnggrpappyn.value = \"Y\";\n\t\t\tdocument.forms[0].BlngGrpStatus.value = \"\";\n\t\t\tdocument.forms[0].blnggrpcatgappyn.value = \"Y\";\t\t\t\n\n\t\t\tfunChangeBillingGroup(document.forms[0].billing_group);\n\n\t\t\tif(ref_src_code_YN==\"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'ref_src_code_main_leg_disp\').style.display=\"inline\";\n\t\t\t\tdocument.getElementById(\'ref_src_code_main_val_disp\').style.display=\"inline\";\n\t\t\t\tdocument.forms[0].referral_source_main_code.value=\"\";\n\t\t\t\tdocument.forms[0].referral_source_main_desc.value=\"\";\n\t\t\t\tif(pmry_ref_src_mand_YN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'ref_src_code_main_mand_disp\').style.display=\"inline\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'ref_src_code_main_mand_disp\').style.display=\"none\";\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.getElementById(\'ref_src_code_sub_leg_disp\').style.display=\"inline\";\n\t\t\t\tdocument.getElementById(\'ref_src_code_sub_val_disp\').style.display=\"inline\";\n\t\t\t\tdocument.getElementById(\"referral_source_sub_code\").value=\"\";\n\t\t\t\tdocument.getElementById(\'referral_source_sub_desc\').value=\"\";\n\t\t\t\tif(sec_ref_src_mand_YN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'ref_src_code_sub_mand_disp\').style.display=\"inline\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'ref_src_code_sub_mand_disp\').style.display=\"none\";\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.forms[0].cap_ref_src_dtl_flag.value=\"Y\";\n\t\t\t\tdocument.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;\n\t\t\t\tdocument.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;\n\t\t\t}\n\t\t\telse if(re";
    private final static byte[]  _wl_block14_1Bytes = _getBytes( _wl_block14_1 );

    private final static java.lang.String  _wl_block14_2 ="f_src_code_YN==\"N\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'ref_src_code_main_leg_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'ref_src_code_main_val_disp\').style.display=\"none\";\n\t\t\t\tdocument.forms[0].referral_source_main_code.value=\"\";\n\t\t\t\tdocument.forms[0].referral_source_main_desc.value=\"\";\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.getElementById(\'ref_src_code_sub_leg_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'ref_src_code_sub_val_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\"referral_source_sub_code\").value=\"\";\n\t\t\t\tdocument.getElementById(\'referral_source_sub_desc\').value=\"\";\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.forms[0].cap_ref_src_dtl_flag.value=\"N\";\n\t\t\t\tdocument.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;\n\t\t\t\tdocument.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;\n\t\t\t}\n\t\t\tcurr_code();//currency code desc \n\n\t\t\tif(capture_employer_id_yn == \'Y\')\n\t\t\t{\n\t\t\t\tif(document.forms[0].PAYER_EMP_ID_MAND_YN.value == \'Y\')\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'emp_id_mand_YN_disp\').style.display=\'inline\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'emp_id_mand_YN_disp\').style.display=\'none\';\n\t\t\t\t\tdocument.forms[0].employer_code.value=\"\";\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].employer_code.value=\"\";\n\t\t\t\tdocument.getElementById(\'emp_id_mand_YN_disp\').style.display=\'none\';\n\t\t\t}\n\t\t\tif(patient_id !== \"\")\n\t\t\t{\n\t\t\t\tif(document.forms[0].sel_bg_has_valid_pkg_YN.value == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'vw_pkg_dtl_disp\').style.display=\"inline\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'vw_pkg_dtl_disp\').style.display=\"none\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\t // funChangeBillingGroup(document.forms[0].billing_group);\n//\t\t\ttarget.focus();\n\t     }\n\t  }\n\n\t//Ajax Call Rajesh V\n\tvar ajBillingGroup = document.forms[0].billing_group.value\n\tif(ajBillingGroup.length>0){\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\tvar ajFacilityId = document.forms[0].facility_id.value;\n\t\tvar ajPatientid = document.forms[0].patient_id.value;\n\t\t\n\t\t//alert(ajBillingGroup)\n\t\tvar param=\"func_mode=getActiveHealthCardVis&facility_id=\"+ajFacilityId+\"&billGroup=\"+ajBillingGroup+\"&patient_id=\"+ajPatientid;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"../../eBL/jsp/PkgSubscriptionValidation.jsp?\"+param,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar responseText=trimString(xmlHttp.responseText);\t\n\t\t//alert(responseText);\n\t\t//responseText = \"Y\";\n\t\tif(responseText == \"Y\"){\n\t\t\tdocument.getElementById(\'ref_active_health_card_link\').style.display=\'inline\';\n\t\t}\n\t\telse{\n\t\t\tdocument.getElementById(\'ref_active_health_card_link\').style.display=\'none\';\n\t\t}\n\t}\t\t\n\t//Ajax Call Rajesh V\n\n\n\n}\n\nfunction callBlnggrp()\n{\n\n//Added by Manivel on 7-May-07 for resetting the settlement frame when blng_grp is null\n\tif(document.forms[0].billing_group.value==\"\")\n\t{\n\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\n\t}\n\n\tvar strdfltbgyn = \'";
    private final static byte[]  _wl_block14_2Bytes = _getBytes( _wl_block14_2 );

    private final static java.lang.String  _wl_block15_0 ="\';\n\tvar operation=document.forms[0].operation.value;\n\tvar strBillGrpId=document.forms[0].strBillGrpId.value;\n\tvar strModuleId=document.forms[0].calling_module_id.value;\n\t\n\tif (strdfltbgyn==\'N\' || (operation==\"Insert\" && strBillGrpId!=\"\" && strModuleId!=\"MP\"))\n\t{\n\t\tif(operation==\"Insert\" && strBillGrpId!=\"\" && strModuleId!=\"MP\")\n\t\t{\n\t\t\tenableAllElements();\n\t\t\tdisableModifyButton();\n\t    }\n\t\tfunChangeBillingGroup(document.forms[0].billing_group);\n\t}\n}\n/*\t   \nfunction glrellkup(clng_evnt)\n{\t\n\tvar msg\t\t\t\t\t= \"\";\n\tvar target\t\t\t\t= document.forms[0].pat_reln_with_gl_holder;\n\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\ttarget.value = \"\";\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar retVal\t\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"130\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"50\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t\t\t= \"\";\t\t\t\t\n\n\tvar glholdername\t\t= document.forms[0].gl_holder_name.value;\n    if (glholdername.length == 0)\n\t\treturn;\n\t\t\n\tvar locale = document.forms[0].locale.value;\n\t\t\n\tsql = \"\tselect relationship_code code, long_desc description from mp_relationship_lang_vw where language_id=\'\"+locale+\"\' and nvl(eff_status,\'E\') != \'D\' and upper(relationship_code) like upper(?) and upper(long_desc) like upper(?) order by 1\";\t\n\t\n\ttitle=getLabel(\"eBL.RELATIONSHIPS.label\",\"BL\");\n\n\tvar argArray = new Array();\n\tvar namesArray = new Array();\n\tvar valuesArray = new Array();\n\tvar datatypesArray = new Array();\n\n\targArray[0] = sql;\n\targArray[1] = namesArray;\n\targArray[2] = valuesArray;\n\targArray[3] = datatypesArray;\n\targArray[4] = \"1,2\";\n\targArray[5] = target.value;\n\targArray[6] = DESC_LINK;\n\targArray[7] = DESC_CODE;\t\t\n\tretArray = CommonLookup( title, argArray );\t\n\t\n\tif(retArray != null && retArray !=\"\")\n\t{\n\t\tdocument.forms[0].pat_reln_with_gl_holder.value=\'\';\t\t\t\t\t\t\t\t\t\t\n\t\tdocument.forms[0].pat_reln_with_gl_holder.value=retArray[1];\t\t\t\t\t\t\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].pat_reln_with_gl_holder.value=\'\';\t\t\t\t\t\t\t\t\t\t\n\t\ttarget.focus();\n\t}\n\n}\n*/\n/*\nfunction patrellkup()\n{\n\tvar msg\t\t\t\t\t= \"\";\n\tvar target\t\t\t\t= document.forms[0].pat_reln_with_resp_person;\n\tvar retVal\t\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"130\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"50\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar search_desc\t\t\t= \"\";\n\tvar tit\t\t\t\t\t= \"\";\t\t\t\t\n\n\tvar respforpymt\t\t\t= document.forms[0].resp_for_payment.value;\n    if (respforpymt.length == 0)\n\t\treturn;\n\n\tvar locale = document.forms[0].locale.value;\n\t\t\n\tsql = \"\tselect relationship_code, long_desc from mp_relationship_lang_vw where language_id=`\"+locale+\"` and nvl(eff_status,`E`) != `D`\";\t\n\n\tsearch_code=\"relationship_code\";\n\tsearch_desc=\"long_desc\";\n\ttit=getLabel(\"eBL.RELATIONSHIPS.label\",\"BL\");\n\n\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"::\");\n\n\t\tdocument.forms[0].pat_reln_with_resp_person.value=\'\';\t\t\t\t\t\t\t\t\t\t\n\t\tdocument.forms[0].pat_reln_with_resp_person.value=arr[0];\n\t}\n\telse\n\t{\t\n\t\tdocument.forms[0].pat_reln_with_resp_person.value=\'\';\t\t\t\t\t\t\t\t\t\t\n\t\ttarget.focus();\n\t}\n}\n*/\nfunction patrellkup(clng_evnt)\n\n{\t\n\n\tvar locale = document.forms[0].locale.value;\n\n\tvar target = document.forms[0].pat_reln_with_resp_person;\n\t\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].pat_reln_with_resp_person.value=\'\';\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar message=\"\";\n\tvar retVal\t\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"130\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"50\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar title\t\t\t\t= \"\";\n\tvar column_descriptions = \"\";\n\n\tvar title=getLabel(\"eBL.RELATIONSHIPS.label\",\"BL\"); \n\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\tsql = \"select RELATIONSHIP_CODE RELATIONSHIP_CODE,SHORT_DESC SHORT_DESC from MP_RELATIONSHIP_LANG_VW where language_id=\'\"+locale+\"\' and nvl(eff_status,\'E\') != \'D\'\";\n\t\n\tvar column_sizes = escape(\"30%,70%\");\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\n\tcolumn_descriptions = code+\",\"+desc;\n\n\tsql=escape(sql);\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"^~^\");\n\n\t\ttarget.value=arr[1];\n\t}\n\telse\n\t{\t\n\t\ttarget.value=\'\';\n\t}\n}\n\nfunction glrellkup(clng_evnt)\n{\t\n\n\tvar locale = document.forms[0].locale.value;\n\n\tvar target = document.forms[0].pat_reln_with_gl_holder;\n\t\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].pat_reln_with_gl_holder.value=\'\';\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar message=\"\";\n\tvar retVal\t\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"130\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"50\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar title\t\t\t\t= \"\";\n\tvar column_descriptions = \"\";\n\n\tvar title=getLabel(\"eBL.RELATIONSHIPS.label\",\"BL\"); \n\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\tsql = \"select RELATIONSHIP_CODE RELATIONSHIP_CODE,SHORT_DESC SHORT_DESC from MP_RELATIONSHIP_LANG_VW where language_id=\'\"+locale+\"\' and nvl(eff_status,\'E\') != \'D\'\";\n\t\n\tvar column_sizes = escape(\"30%,70%\");\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\n\tcolumn_descriptions = code+\",\"+desc;\n\n\tsql=escape(sql);\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"^~^\");\n\n\t\ttarget.value=arr[1];\n\t}\n\telse\n\t{\t\n\t\ttarget.value=\'\';\n\t}\n}\n\nfunction gllkup(clng_evnt)\n{\t     \n\n\tvar target\t\t\t= document.forms[0].gl_holder_name;\n\tvar module_id = document.forms[0].calling_module_id.value;\n\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\ttarget.value = \"\";\n//\t\t\tdocument.forms[0].pat_reln_with_gl_holder.value = \"\";\n\t\t\treturn;\n\t\t}\n\t\tif(module_id ==\'MP\')\n\t\t\treturn ;\n\t}\n\t\n\tvar patient_id\t\t= document.forms[0].patient_id.value;\t\t\t\t\t\t\n\tvar retVal\t\t\t= new String();\t\t\n\tvar dialogTop\t\t\t= \"130\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"50\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\t\t\n\tvar mode\t\t\t\t= \"\";\n\tvar slmt_ind\t\t\t= \"\";\n\tvar adm_rec_flag\t\t\t=\"\";\n\t\t\n\tvar encounter_date_time = document.forms[0].encounter_date_time.value;\n\tvar facility_id = document.forms[0].facility_id.value;\t\t\n\tvar billing_group=document.forms[0].billing_group.value;\n\tvar locale = document.forms[0].locale.value;\n\tvar title=getLabel(\"eBL.VALID_DOCUMENTS.label\",\"BL\");\n//\tvar column_sizes = escape(\"20%,12%,12%,20%,15%,7%,20%,7%,20%,0%,0%,0%,0%,0%\");               \n\tvar column_sizes = escape(\"20%,12%,12%,20%,7%,20%,7%,20%,0%,0%,0%,0%,0%,0%,0%,0%,0%\");               \n//\tvar column_descriptions = escape(\"Doc Reference,Start Date,End Date,GL Holder Name,Relationship with GL Holder,Customer Code,Customer Name\"); \n\tvar docref=getLabel(\"eBL.DOC_REF.label\",\"BL\");\n\tvar startdate=getLabel(\"Common.StartDate.label\",\"common\");\n\tvar enddate=getLabel(\"Common.enddate.label\",\"Common\");\n\tvar glholname=getLabel(\"eBL.GL_HOLDER_NAME.label\",\"BL\");\n//\tvar rshipglhol=getLabel(\"eBL.PATIENT_RELN_WITH_GL_HOLDER.label\",\"BL\");\n\tvar custmcode=getLabel(\"Common.CustomerCode.label\",\"common\");\n\tvar custmname=getLabel(\"Common.Customer.label\",\"common\");\n\tvar custgrpcode=getLabel(\"eBL.CUST_GROUP_CODE.label\",\"BL\");\n\tvar custgrpname=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\");\n\tvar tot_gl_valid_enc = \"Total GL Valid Encounter\";\n\tvar tot_op_gl_valid_enc = \"Total GL Valid Encounter for OP\";\n\tvar tot_ae_gl_valid_enc = \"Total GL Valid Encounter for AE\";\n\tvar tot_ip_gl_valid_enc = \"Total GL Valid Encounter for IP\";\n\tvar tot_dc_gl_valid_enc = \"Total GL Valid Encounter for DC\";\n\tvar tot_op_availed_enc = \"Total GL Encounters availed for OP\";\n\tvar tot_ae_availed_enc = \"Total GL Encounters availed for AE\";\n\tvar tot_ip_availed_enc = \"Total GL Encounters availed for IP\";\n\tvar tot_dc_availed_enc = \"Total GL Encounters availed for DC\";\n\n//\tvar column_descriptions = docref+\",\"+startdate+\",\"+enddate+\",\"+glholname+\",\"+rshipglhol+\",\"+custmcode+\",\"+custmname+\",\"+custgrpcode+\",\"+custgrpname+\",\"+tot_gl_valid_enc+\",\"+tot_ae_gl_valid_enc+\",\"+tot_op_gl_valid_enc+\",\"+tot_ip_gl_valid_enc+\",\"+tot_dc_gl_valid_enc;\n\tvar column_descriptions = docref+\",\"+startdate+\",\"+enddate+\",\"+glholname+\",\"+custmcode+\",\"+custmname+\",\"+custgrpcode+\",\"+custgrpname+\",\"+tot_gl_valid_enc+\",\"+tot_op_gl_valid_enc+\",\"+tot_ae_gl_valid_enc+\",\"+tot_ip_gl_valid_enc+\",\"+tot_dc_gl_valid_enc+\",\"+tot_op_availed_enc+\",\"+tot_ae_availed_enc+\",\"+tot_ip_availed_enc+\",\"+tot_dc_availed_enc;\n\tvar message = \'\';\n\t\t\n\tif (billing_group.length == 0) return;\n\n//\tslmt_ind = parent.frames[1].frames[0].frames[1].document.forms[0].setlmt_ind.value;\n\tslmt_ind = document.forms[0].setlmt_ind.value;\n\tadm_rec_flag = document.forms[0].adm_rec_flag.value;\n\t\n\tsql=\"called_for=GLHOLDERLKUP&locale=\"+locale+\"&facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&slmt_ind=\"+slmt_ind+\"&encounter_date_time=\"+encounter_date_time+\"&module_id=\"+module_id;\n/*\n\tif ( module_id == \"OP\" || module_id == \"AE\" || module_id == \"IP\" || module_id == \"DC\")\n\t{\n\t\tsql = \"SELECT DISTINCT credit_doc_ref_desc DOC_REF,TO_CHAR(credit_doc_ref_start_date,\'dd/mm/yyyy\') ST_DATE,TO_CHAR(credit_doc_ref_date,\'dd/mm/yyyy\') END_DATE,NVL(gl_holder_name,\'\') GL_NAME,NVL(cust_code,\'\') CUST_CODE,NVL(short_name,\'\') SHRT_DESC,NVL(CUST_GROUP_CODE,\'\') CUST_GRP_CODE,nvl(CUST_GROUP_DESC,";
    private final static byte[]  _wl_block15_0Bytes = _getBytes( _wl_block15_0 );

    private final static java.lang.String  _wl_block15_1 ="\'\') cust_grp_desc, nvl(NO_OF_ENC_GL_VALID,\'\') NO_ENC_GL_VALID,nvl(NO_OF_OP_ENC_GL_VALID,\'\') NO_OP_ENC_GL_VALID,nvl(NO_OF_AE_ENC_GL_VALID,\'\') NO_AE_ENC_GL_VALID,nvl(NO_OF_IP_ENC_GL_VALID,\'\') NO_IP_ENC_GL_VALID,nvl(NO_OF_DC_ENC_GL_VALID,\'\') NO_DC_ENC_GL_VALID,nvl(NO_OF_OP_ENC_GL_AVAILED,\'\') NO_OP_ENC_GL_AVAILED,nvl(NO_OF_AE_ENC_GL_AVAILED,\'\') NO_AE_ENC_GL_AVAILED,nvl(NO_OF_IP_ENC_GL_AVAILED,\'\') NO_IP_ENC_GL_AVAILED,nvl(NO_OF_DC_ENC_GL_AVAILED,\'\') NO_DC_ENC_GL_AVAILED FROM BL_GL_HOLDER_LOOKUP_VW WHERE operating_facility_id = \'\"+facility_id +\"\' AND language_id=\'\"+locale+\"\' AND patient_id = \'\"+patient_id+\"\' AND settlement_ind = \'\"+slmt_ind+\"\' AND credit_doc_ref_date > trunc( to_date(\'\"+encounter_date_time+\"\',\'dd/mm/yyyy HH24:MI\'))\";\n\t}\n\telse\n\t{\n\t\tsql = \"select \'\' DOC_REF,\'\' ST_DATE,\'\' END_DATE,\' \' GL_NAME,\' \' CUST_CODE,\' \' SHRT_DESC,\' \' CUST_GROUP_CODE,\' \' CUST_GRP_DESC, \' \' NO_ENC_GL_VALID, \' \' NO_AE_ENC_GL_VALID, \' \' NO_OP_ENC_GL_VALID, \' \' NO_IP_ENC_GL_VALID, \' \' NO_DC_ENC_GL_VALID ,\' \' NO_OP_ENC_GL_AVAILED,\' \' NO_AE_ENC_GL_AVAILED,\' \' NO_IP_ENC_GL_AVAILED,\' \' NO_DC_ENC_GL_AVAILED FROM dual a WHERE 1=2\";\n\t}\t\t\n\n//\tsql = escape(sql);\t\t\t\t\t\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=4\"+\"&col_show_hide=YYYYYYYYNNNNN\";\n*/\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=4\"+\"&col_show_hide=YYYYYYYYNNNNN\";\n\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\n\tvar arr=new Array();\t\t\t\t\t\n\t\t\n\tif(retVal == null) retVal=\'\';\t\t\n\n\tif (retVal != null || retVal != \"\")\n\t{\t\t\t\n\t\tvar retVal=unescape(retVal);\t\t\t\t\n\n\t\tif (billing_group.length > 0 )\n\t\t{\n\t\t\tif(slmt_ind==\"X\" && adm_rec_flag==\"2\")\n\t\t\t{\n\t\t\t\tmode = parent.frames[1].frames[0].frames[1].document.forms[0].Case.value;\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tmode = parent.frames[1].frames[0].document.forms[0].Case.value;\t\n\t\t\t}\n\t\t}\n\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\t\t\t   \n\n\t\t\tif (mode == \"2\")\n\t\t\t{\t\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].credit_doc_ref1.value  =arr[0];\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.value=arr[1];\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.disabled=true;\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].credit_doc_date1.value=arr[2];\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].credit_doc_date1.disabled=true;\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].cust_1.value=arr[4];\t\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].cust_1_desc.value=arr[5];\t\t\t   \n\t\t\t\tparent.frames[1].frames[0].document.forms[0].cust_group_code_1.value=arr[6];\t\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].cust_group_desc_1.value=arr[7];\t\t\t   \n\t\t\t}\n\t\t    else if (mode == \"3\")\n\t\t    { \t\n\t\t\t    parent.frames[1].frames[0].document.forms[0].credit_doc_ref2.value=arr[0];\n\t\t\t    parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.value=arr[1];\n\t\t\t    parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.disabled=true;\n\t\t\t    parent.frames[1].frames[0].document.forms[0].credit_doc_date2.value=arr[2];\n\t\t\t    parent.frames[1].frames[0].document.forms[0].credit_doc_date2.disabled=true;\n\t\t\t    parent.frames[1].frames[0].document.forms[0].cust_2.value=arr[4];\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].cust_2_desc.value=arr[5];\t\t\t   \n\t\t\t\tparent.frames[1].frames[0].document.forms[0].cust_group_code_2.value=arr[6];\t\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].cust_group_desc_2.value=arr[7];\t\t\t   \n\t\t\t}\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.value = arr[8];\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.disabled=true;\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.value = arr[9];\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.disabled=true;\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.value = arr[10];\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.disabled=true;\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.value = arr[11];\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.disabled=true;\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.value = arr[12];\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.disabled=true;\n\t\t\tdocument.forms[0].gl_holder_name.value=arr[3];\n//\t\t\tdocument.forms[0].pat_reln_with_gl_holder.value=if(arr[4]==\" \") arr[4]=\"\" ;\n\n\t\t\tvar tot_availed_op_enc_with_gl = arr[13];\n\t\t\tvar tot_availed_ae_enc_with_gl = arr[14];\n\t\t\tvar tot_availed_ip_enc_with_gl = arr[15];\n\t\t\tvar tot_availed_dc_enc_with_gl = arr[16];\n\n\t\t\tvar tot_availed_enc_with_gl = eval(tot_availed_op_enc_with_gl) + eval(tot_availed_ae_enc_with_gl) +eval(tot_availed_ip_enc_with_gl) + eval(tot_availed_dc_enc_with_gl); \n\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_availed_op_enc_with_gl.value = arr[13];\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_availed_ae_enc_with_gl.value = arr[14];\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_availed_ip_enc_with_gl.value = arr[15];\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_availed_dc_enc_with_gl.value = arr[16];\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_availed_enc_with_gl.value = tot_availed_enc_with_gl;\n\n\t\t\tparent.frames[1].frames[0].document.forms[0].gl_doc_ref_exist_YN.value = \"Y\";\n\t\t}\t\n\t\telse\n\t\t{\n//\t\t\tdocument.forms[0].pat_reln_with_gl_holder.value=\"\"; \n//\t\t\ttarget.focus();\n\n\t\t\tif (mode == \"2\")\n\t\t\t{\t\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.disabled=false;\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].credit_doc_date1.disabled=false;\n\t\t\t}\n\t\t\telse if (mode == \"3\")\n\t\t\t{ \t\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.disabled=false;\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].credit_doc_date2.disabled=false;\n\t\t\t}\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.value = \'\';\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.value = \'\';\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.value = \'\';\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.value = \'\';\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.value = \'\';\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.disabled=false;\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.disabled=false;\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.disabled=false;\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.disabled=false;\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.disabled=false;\n\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_availed_enc_with_gl.value = \'0\';\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_availed_op_enc_with_gl.value = \'0\';\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_availed_ae_enc_with_gl.value = \'0\';\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_availed_ip_enc_with_gl.value = \'0\';\n\t\t\tparent.frames[1].frames[0].document.forms[0].tot_availed_dc_enc_with_gl.value = \'0\';\n\n\t\t\tparent.frames[1].frames[0].document.forms[0].gl_doc_ref_exist_YN.value = \"N\";\n\t\t}\n\t}\n}\n\nfunction sel_frm_prev_enc()\n{\t \nvar payerGrpBySetup=document.forms[0].payerGrpBySetup.value;\n//alert(\"payerGrpBySetup\"+payerGrpBySetup);\n\tif((\"Y\")!= payerGrpBySetup ){\n\t\tif(document.forms[0].fin_auth_user_id.value==\"\")\n\t\t{\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar episode_type = document.forms[0].episode_type.value;\n\tvar patient_id = document.forms[0].patient_id.value;\t\n\tvar facility_id=document.forms[0].facility_id.value;\n\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\n\tvar sys_date= document.forms[0].sys_date.value;\t\n\tvar encounter_date= document.forms[0].encounter_date.value;\t\n\tif(encounter_date==null || encounter_date==\"\")\n\t\tencounter_date=sys_date;\n\n\tvar remarks = document.forms[0].remarks.value;\n\tremarks = encodeURIComponent(remarks);\n\tvar fin_auth_user_id = document.forms[0].fin_auth_user_id.value;\n\n\tvar query_string=document.forms[0].query_string.value;\t\n\tvar center=\'1\';\n\tvar dialogTop = \"110\";\n\tvar dialogHeight = \"35\" ;\n\tvar dialogWidth = \"70\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar title=getLabel(\"eBL.PRV_ENCOUNTER_FIN_DETAILS.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\t\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\t\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&calling_module_id=\"+calling_module_id+\"&episode_type=\"+episode_type+\"&title=\"+title+\"&encounter_date=\"+encounter_date+\"&\"+query_string;\n\t\n\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLPreviousEncounterMain.jsp?\"+param,arguments,features);\n\n\tif(retVal==\"success\")\n\t{\n\t\tif(document.forms[0].package_enabled_yn.value == \'Y\')\n\t\t{\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\tvar updation=formValidation(xmlStr,\"clearBean\");\n\t\t}\n//\t\tparent.frames[1].location.href=\"../../eBL/jsp/AddModifyPatFinDetails6.jsp?sel_frm_prev_enc=Y&\"+query_string;\n\t\tparent.frames[0].location.href=\"../../eBL/jsp/AddModifyPatFinDetails.jsp?sel_frm_prev_enc=Y&remarks=\"+remarks+\"&fin_auth_user_id=\"+fin_auth_user_id+\"&\"+query_string;\n\t}\n}\n\nfunction refsrclkup(ref_code,ref_desc,called_frm,clng_evnt)\n{\n\n\tvar setlmt_ind=document.forms[0].setlmt_ind.value;\n\tvar adm_rec_flag= document.forms[0].adm_rec_flag.value;\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar locale=document.forms[0].locale.value;\n\tvar billing_group=document.forms[0].billing_group.value;\n\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( ref_desc.value == \"\")\n\t\t{\t\n\t\t\tref_code.value = \"\";\n\t\t\tref_desc.value = \"\";\n\t\t\tif(called_frm == \"M\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=\"\";\n\t\t\t}\n\t\t\telse if (called_frm == \"S\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=\"\";\n\t\t\t}\n\t\t\tif(setlmt_ind == \"X\" && adm_rec_flag == \"2\")\n\t\t\t{\n\t\t\t\tvar total_records=parent.frames[1].frames[0].frames[1].document.for";
    private final static byte[]  _wl_block15_1Bytes = _getBytes( _wl_block15_1 );

    private final static java.lang.String  _wl_block15_2 ="ms[0].total_records.value;\n\n\t\t\t\tif(total_records > 0)\n\t\t\t\t{\n\t\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar sel_blng_grp=eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code\"+i);\n\n\t\t\t\t\t\tif(sel_blng_grp.value == billing_group)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(called_frm == \'M\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar ref_src_main_code_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_code\"+i);\n\t\t\t\t\t\t\t\tref_src_main_code_for_prmy_blng_grp.value=\"\";\n\n\t\t\t\t\t\t\t\tvar ref_src_main_desc_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_desc\"+i);\n\t\t\t\t\t\t\t\tref_src_main_desc_for_prmy_blng_grp.value=\"\";\n\n\t\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible\"+i);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(\"parent.frames[1].frames[0].frames[1].document.getElementById(\'pmy_ref_src_lng_name_\')\"+i);\n\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.alt=\"\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(called_frm == \'S\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar ref_src_sub_code_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_code\"+i);\n\t\t\t\t\t\t\t\tref_src_sub_code_for_prmy_blng_grp.value=\"\";\n\n\t\t\t\t\t\t\t\tvar ref_src_sub_desc_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_desc\"+i);\n\t\t\t\t\t\t\t\tref_src_sub_desc_for_prmy_blng_grp.value=\"\";\n\t\n\t\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(\"parent.frames[1].frames[0].frames[1].document.getElementById(\'sec_ref_src_lng_name_\')\"+i);\n\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.alt=\"\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar retVal\t\t\t= new String();\t\t\n\tvar dialogTop\t\t\t= \"130\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"60\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\t\t\n\t\t\n\tvar title=getLabel(\"Common.referralsource.label\",\"common\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"20%,20%,20%,30%,10%\");               \n\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar short_desc=getLabel(\"Common.shortdescription.label\",\"common\");\n\tshort_desc=encodeURIComponent(short_desc);\n\tvar long_desc=getLabel(\"Common.longdescription.label\",\"common\");\n\tlong_desc=encodeURIComponent(long_desc);\n\tvar long_name=getLabel(\"Common.longname.label\",\"common\");\n\tlong_name=encodeURIComponent(long_name);\n\tvar org_type=getLabel(\"Common.OrganisationType.label\",\"common\");\n\torg_type=encodeURIComponent(org_type);\n\tvar column_descriptions = code+\",\"+short_desc+\",\"+long_desc+\",\"+long_name+\",\"+org_type;\n\n\tvar gov_leg = getLabel(\"eBL.GOVT_REFERRAL.label\",\"BL\");\n\tgov_leg=encodeURIComponent(gov_leg);\n\n\tvar pvt_leg = getLabel(\"eBL.PVT_REFERRAL.label\",\"BL\");\n\tpvt_leg=encodeURIComponent(pvt_leg);\n\n\tvar message = \'\';\n\t\t\n\tif (billing_group.length == 0) return;\n\n\tvar sql=\"called_for=REFSRCLKUP&locale=\"+locale+\"&episode_type=\"+episode_type;\n\n//\tvar sql=\"Select REFERRAL_CODE REFERRAL_CODE,SHORT_DESC SHORT_DESC,LONG_DESC LONG_DESC,LONG_NAME LONG_NAME,decode(ORG_TYPE,\'G\',\'\"+gov_leg+\"\',\'P\',\'\"+pvt_leg+\"\') ORG_TYPE from AM_REFERRAL_LANG_VW where ((\'\"+episode_type+\"\' = \'R\' and SOURCE_USE_AT_REGN_YN=\'Y\') or (\'\"+episode_type+\"\' in (\'O\',\'E\') and SOURCE_USE_AT_VISIT_YN =\'Y\') or (\'\"+episode_type+\"\' in (\'I\',\'D\') and SOURCE_USE_AT_ADM_YN =\'Y\')) and language_id = \'\"+locale+\"\' and nvl(eff_status,\'E\')=\'E\'\";\n\n//\tsql = escape(sql);\t\t\t\t\t\n\n//\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(ref_desc.value)+\"&srch_by_clmn_index=3\"+\"&col_show_hide=YYYYY\";\n\t\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(ref_desc.value)+\"&srch_by_clmn_index=3\"+\"&col_show_hide=YYYYY\";\n\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\n\tvar arr=new Array();\t\t\t\t\t\n\t\t\n\tif(retVal == null) retVal=\'\';\t\n\t\n\tif (retVal != null || retVal != \"\")\n\t{\t\n\t\tvar retVal=unescape(retVal);\t\t\t\t\n\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\t\t\t   \n\n\t\t\tref_code.value=arr[0];\n\t\t\tref_desc.value=arr[2];\n\t\t\tvar ref_src_lng_name = arr[3];\n\n\t\t\tif(called_frm == \"M\")\n\t\t\t{\n\t\t\t\tif(ref_src_lng_name != \"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"visible\";\n\t\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=arr[3];\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if (called_frm == \"S\")\n\t\t\t{\n\t\t\t\tif(ref_src_lng_name != \"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"visible\";\n\t\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=arr[3];\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tif(setlmt_ind == \"X\" && adm_rec_flag == \"2\")\n\t\t\t{\n\t\t\t\tvar total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;\n\n\t\t\t\tif(total_records > 0)\n\t\t\t\t{\n\t\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar sel_blng_grp=eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\t\tif(sel_blng_grp.value == billing_group)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(called_frm == \'M\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar ref_src_main_code_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_code\"+i);\n\t\t\t\t\t\t\t\tref_src_main_code_for_prmy_blng_grp.value=arr[0];\n\n\t\t\t\t\t\t\t\tvar ref_src_main_desc_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_desc\"+i);\n\t\t\t\t\t\t\t\tref_src_main_desc_for_prmy_blng_grp.value=arr[2];\n\n\t\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible\"+i);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(ref_src_lng_name != \"\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(\"parent.frames[1].frames[0].frames[1].document.getElementById(\'pmy_ref_src_lng_name_\')\"+i);\n\n\t\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"visible\";\n\t\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.alt=arr[3];\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(\"parent.frames[1].frames[0].frames[1].document.getElementById(\'pmy_ref_src_lng_name_\')\"+i);\n\t\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.alt=\"\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(called_frm == \'S\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar ref_src_sub_code_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_code\"+i);\n\t\t\t\t\t\t\t\tref_src_sub_code_for_prmy_blng_grp.value=arr[0];\n\n\t\t\t\t\t\t\t\tvar ref_src_sub_desc_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_desc\"+i);\n\t\t\t\t\t\t\t\tref_src_sub_desc_for_prmy_blng_grp.value=arr[2];\n\n\t\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible\"+i);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(ref_src_lng_name != \"\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(\"parent.frames[1].frames[0].frames[1].document.getElementById(\'sec_ref_src_lng_name_\')\"+i);\n\n\t\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"visible\";\n\t\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.alt=arr[3];\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(\"parent.frames[1].frames[0].frames[1].document.getElementById(\'sec_ref_src_lng_name_\')\"+i);\n\t\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.alt=\"\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t}\n\t\t}\t\n\t\telse\n\t\t{\n\t\t\tref_code.value=\"\";\n\t\t\tref_desc.value=\"\";\n\t\t\tif(called_frm == \"M\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=\"\";\n\t\t\t}\n\t\t\telse if (called_frm == \"S\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=arr[3];\n\t\t\t}\n\n\t\t\tif(setlmt_ind == \"X\" && adm_rec_flag == \"2\")\n\t\t\t{\n\t\t\t\tvar total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;\n\n\t\t\t\tif(total_records > 0)\n\t\t\t\t{\n\t\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar sel_blng_grp=eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\t\tif(sel_blng_grp.value == billing_group)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(called_frm == \'M\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar ref_src_main_code_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_code\"+i);\n\t\t\t\t\t\t\t\tref_src_main_code_for_prmy_blng_grp.value=\"\";\n\n\t\t\t\t\t\t\t\tvar ref_src_main_desc_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_desc\"+i);\n\t\t\t\t\t\t\t\tref_src_main_desc_for_prmy_blng_grp.value=\"\";\n\n\t\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible\"+i);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(\"parent.frames[1].frames[0].frames[1].document.getElementById(\'pmy_ref_src_lng_name_\')\"+i);\n\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.alt=\"\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(called_frm == \'S\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar ref_src_sub_code_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_code\"+i);\n\t\t\t\t\t\t\t\tref_src_sub_code_for_prmy_blng_grp.value=\"\";\n\n\t\t\t\t\t\t\t\tvar ref_src_sub_desc_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_desc\"+i);\n\t\t\t\t\t\t\t\tref_src_sub_desc_for_prmy_blng_grp.value=\"\";\n\t\n\t\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(\"parent.frames[1].frames[0].frames[1].document.getElementById(\'sec_ref_src_lng_name_\')\"+i);\n\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.alt=\"\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\telse\n\t{\n\t\tref_";
    private final static byte[]  _wl_block15_2Bytes = _getBytes( _wl_block15_2 );

    private final static java.lang.String  _wl_block15_3 ="code.value=\"\";\n\t\tref_desc.value=\"\";\n\t\tif(setlmt_ind == \"X\" && adm_rec_flag == \"2\")\n\t\t{\n\t\t\tvar total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;\n\n\t\t\tif(total_records > 0)\n\t\t\t{\n\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t{\n\t\t\t\t\tvar sel_blng_grp=eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\tif(sel_blng_grp.value == billing_group)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(called_frm == \'M\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar ref_src_main_code_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_code\"+i);\n\t\t\t\t\t\t\tref_src_main_code_for_prmy_blng_grp.value=\"\";\n\n\t\t\t\t\t\t\tvar ref_src_main_desc_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_desc\"+i);\n\t\t\t\t\t\t\tref_src_main_desc_for_prmy_blng_grp.value=\"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(called_frm == \'S\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar ref_src_sub_code_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_code\"+i);\n\t\t\t\t\t\t\tref_src_sub_code_for_prmy_blng_grp.value=\"\";\n\n\t\t\t\t\t\t\tvar ref_src_sub_desc_for_prmy_blng_grp = eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_desc\"+i);\n\t\t\t\t\t\t\tref_src_sub_desc_for_prmy_blng_grp.value=\"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t}\n\t\t}\n\t}\n\n}\n\nfunction chng_class_for_inv_pyrs_on_rfrsh()\n{\n\tvar setlmt_ind=document.forms[0].setlmt_ind.value;\n\tvar adm_rec_flag=document.forms[0].adm_rec_flag.value;\n\tvar qry_odd_evn_chng_class=\"\";\n\n\tif(setlmt_ind==\"X\" && adm_rec_flag==\"2\")\n\t{\n\t\tvar total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;\n\n\t\tfor (var j=0;j<parent.frames[1].frames[0].frames[1].document.getElementById(\'ins_data\').rows.length;j++)\n\t\t{\n\t\t\tif(parent.frames[1].frames[0].frames[1].document.getElementById(\'ins_data\').rows[j].cells[0].className == \"QRYEVEN\")\n\t\t\t\tqry_odd_evn_chng_class=\"QRYODD\";\n\n\t\t\tif(parent.frames[1].frames[0].frames[1].document.getElementById(\'ins_data\').rows[j].cells[0].className == \"QRYODD\")\n\t\t\t\tqry_odd_evn_chng_class=\"QRYEVEN\";\n\n\t\t\tif(parent.frames[1].frames[0].frames[1].document.getElementById(\'ins_data\').rows[j].cells[0].className == \"PATIENTLINECOLOR\" && j==0)\n\t\t\t\tqry_odd_evn_chng_class=\"QRYEVEN\";\n\n\t\t\tif(parent.frames[1].frames[0].frames[1].document.getElementById(\'ins_data\').rows[j].cells[0].className == \"RED\")\n\t\t\t{\n\t\t\t\tparent.frames[1].frames[0].frames[1].document.getElementById(\'ins_data\').rows[j].cells[0].className = qry_odd_evn_chng_class;\n\t\t\t}\n\t\t}\n\t\t\n\t\tfor(var i=0;i<total_records;i++)\n\t\t{\n\t\t\tvar ins_blng_grp_code1=eval(\"parent.frames[1].frames[0].frames[1].document.forms[0].billing_group_desc\"+i);\n\t\n\t\t\tif(ins_blng_grp_code1.className == \'BACKGROUND\')\n\t\t\t{\n\t\t\t\tins_blng_grp_code1.className=\'\';\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction curr_code()\n{\n\tvar currency_desc_for_bg = document.forms[0].currency_desc_for_bg.value;\n\n\tif(currency_desc_for_bg != \"\")\n\t{\n\t\tdocument.getElementById(\'bg_curr_desc_disp\').style.display=\"inline\";\n\t\tdocument.getElementById(\'bg_curr_desc\').innerText=currency_desc_for_bg;\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\'bg_curr_desc_disp\').style.display=\"none\";\n\t\tdocument.getElementById(\'bg_curr_desc\').innerText=\"\";\n\n\t}\n}\n\nasync function view_trmt_pkg_dtl()\n{\n\tvar locale = document.forms[0].locale.value;\n\tvar patient_id = document.forms[0].patient_id.value;\n\tvar blng_grp_id = document.forms[0].billing_group.value;\n\tvar encounter_date = document.forms[0].encounter_date_aft_trunc.value;\n\tencounter_date = convertDate(encounter_date,\'DMY\',locale,\"en\");\n\tvar blnggrp\t= document.forms[0].blnggrp.value;\n\tvar ExtBillingGroup = document.forms[0].ext_billing_group.value;\n\tvar strCitizenYn = document.forms[0].CitizenYn.value;\n\n\n\tvar retVal;\n\tvar dialogHeight= \"35\" ;\n\tvar dialogWidth\t= \"70\" ;\n\tvar dialogTop = \"140\" ;\n\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\tvar url = \"../../eBL/jsp/BLViewTrmtPkgDtlsMain.jsp?patient_id=\"+patient_id+\"&blng_grp_id=\"+blng_grp_id+\"&encounter_date=\"+encounter_date+\"&cald_with_bg_YN=Y&cald_frm=REG&blnggrp=\"+blnggrp+\"&citizen_yn=\"+strCitizenYn+\"&ext_billing_group=\"+ExtBillingGroup;\n\tretVal =await window.showModalDialog(url,arguments,features);\n}\n\nasync function call_pkg_win()\n\t{ \n\t\tvar valid_pkg_for_pat_bg_avail_YN=document.forms[0].valid_pkg_for_pat_bg_avail_YN.value;\n\t\tvar valid_pkg_for_pat_avail_YN=document.forms[0].valid_pkg_for_pat_avail_YN.value;\n\n\t\tif(valid_pkg_for_pat_avail_YN == \'Y\')\n\t\t{\n\t\t\tvar locale = document.forms[0].locale.value;\n\t\t\tvar billing_group=document.forms[0].billing_group.value;\n\t\t\tvar patient_id=document.forms[0].patient_id.value;\t\n\t\t\tvar encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value;\n\t\t\tvar blnggrp\t= document.forms[0].blnggrp.value;\n\t\t\tvar ExtBillingGroup = document.forms[0].ext_billing_group.value;\n\t\t\tvar strCitizenYn = document.forms[0].CitizenYn.value;\n\t\t\t\n\t\t\tencounter_date_aft_trunc = convertDate(encounter_date_aft_trunc,\'DMY\',locale,\"en\");\n\n\t\t\tif(billing_group!=\"\" &&  patient_id != \"\")\n\t\t\t{\n\t\t\t\tvar retVal;\n\t\t\t\tvar dialogHeight= \"35\" ;\n\t\t\t\tvar dialogWidth\t= \"70\" ;\n\t\t\t\tvar dialogTop = \"140\" ;\n\t\t\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\tvar status=\"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tvar url = \"../../eBL/jsp/BLViewTrmtPkgDtlsMain.jsp?patient_id=\"+patient_id+\"&blng_grp_id=\"+billing_group+\"&encounter_date=\"+encounter_date_aft_trunc+\"&blnggrp=\"+blnggrp+\"&citizen_yn=\"+strCitizenYn+\"&ext_billing_group=\"+ExtBillingGroup+\"&cald_frm=REG\";\n\t\t\t\tretVal =await window.showModalDialog(url,arguments,features);\n\n\t\t\t\tif(retVal == \"undefined\" || retVal == undefined || retVal == null) retVal=\"\";\n\t\t\t\tif(retVal != \"\")\n\t\t\t\t{\n\t\t\t\t\tvar arr = retVal.split(\"||\");\t\t\t\t\t\n\n\t\t\t\t\tdocument.forms[0].selecltd_bg_frm_pkg.value = arr[0];\n\t\t\t\t\tdocument.forms[0].selecltd_bg_desc_frm_pkg.value = arr[1];\n\t\t\t\t\tdocument.forms[0].selecltd_cust_grp_frm_pkg.value = arr[2];\n\t\t\t\t\tdocument.forms[0].selecltd_cust_frm_pkg.value = arr[3];\n\t\t\t\t\tdocument.forms[0].blng_grp_sel_frm_pkg_YN.value = \"Y\";\n\n\t//\t\t\t\talert(getMessage(\"BL6347\",\"BL\"));\n\t\t\t\t\tdocument.getElementById(\'modify_button\').click();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction CheckSplApprAmt(Obj)\n\t{\n\t\tvar flag = CheckForChar(Obj);\n\n\t\tif(flag)\n\t\t{\n\t\t\tput_decimal(Obj,document.forms[0].noofdecimal.value);\n\t\t\treturn true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t}\n\n\tfunction CheckForChar(Obj)\n\t{ \n\t\n\t\tvar check_var = Obj.value;\n\n\t\tnumList = \'1234567890.\';\n\t\t\n\t\tfor (i=0;i<check_var.length;i++)\n\t\t{\n\t\t\tif (numList.indexOf(check_var.charAt(i)) == -1) \n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\'Common\'));\n\t\t\t\tObj.select();\n\t\t\t\treturn false;  \n\t\t\t}\n\t\t}\n\t\treturn true;\n\t}\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</head>\n";
    private final static byte[]  _wl_block15_3Bytes = _getBytes( _wl_block15_3 );

    private final static java.lang.String  _wl_block16 ="\n<body onLoad=\'disableAllElements();callBlnggrp();curr_code();call_pkg_win();pkgSubsMsgDisplay();disable1();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n<body onLoad=\'validate();callBlnggrp();curr_code();call_pkg_win();disableModifyButton();pkgSubsMsgDisplay();disable1();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<body onLoad=\'disableMappingItemsAll();callBlnggrp();curr_code();call_pkg_win();pkgSubsMsgDisplay();disable1();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<body onLoad=\'disableModifyButton();callBlnggrp();curr_code();call_pkg_win();pkgSubsMsgDisplay();disable1();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<body onLoad=\'curr_code();call_pkg_win();pkgSubsMsgDisplay();disable1();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"> \n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="      \n\n<form name=\'PatFinMainForm\' id=\'PatFinMainForm\' method=\'post\'   scrolling=no >\n\n<!-- The following changes are done for Internationalisation Process\nCellpadding changed from 1 to 3 by Manivel Natarajan on 10/Aug/2006 -->\n\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n<tr>\n\t\n\t ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<script>alert(getMessage(\"BL6360\",\"BL\"));</script>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\t<td width=\"25%\" class=\"label\"><a href=\"javascript:getBlngGrpSearch();\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a>&nbsp;&nbsp;<div id=\"bg_curr_desc_disp\" style=\"display:inline\"><Font color=\'red\'><b id=\"bg_curr_desc\"></b></font></div></td>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\n\t<td width=\"25%\" class=\"label\"><a href=\"javascript:getBlngGrpSearch();\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</a>&nbsp;&nbsp;<div id=\"bg_curr_desc_disp\" style=\"display:inline\"><Font color=\'red\'><b id=\"bg_curr_desc\"></b></font></div></td>\n\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t <!-- Added By Rajesh V - for CRF-155 -->\n\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t <td class=\'fields\' width=\"25%\" nowrap><input type=\'text\' name=\"billing_group_desc\" id=\"billing_group_desc\" maxlength=\'40\' size=\'40\' tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onBlur=\"return blnggrplkupNew(\'B\')\"><input type=\'button\' class=\'button\' name=\"blnggrpbut\" id=\"blnggrpbut\" value=\'?\' onClick=\"return blnggrplkupNew(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'>\n\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t \n\t\t <td class=\'fields\' width=\"25%\" nowrap><input type=\'text\' name=\"billing_group_desc\" id=\"billing_group_desc\" maxlength=\'40\' size=\'40\' tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onBlur=\"return blnggrplkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"blnggrpbut\" id=\"blnggrpbut\" value=\'?\' onClick=\"return blnggrplkup(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'>\n\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t  \n\t <!-- Added By Rajesh V - for CRF-155 -->\t\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\t<a href=\"javascript:uploadImage()\" id=\'insImage\'>Upload Insurance Doc </a>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<!-- Rajesh V -->\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<div id=\'ref_active_health_card_link\' style=\'display:inline\'><a href=\"javascript:activeHealthCard();\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</a>\n\t\t</div>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<div id=\'ref_active_health_card_link\' style=\'display:none\'><a href=\"javascript:activeHealthCard();\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\n\n\t<!-- Rajesh V -->\n\t</td>\n\n\t<input type= \"hidden\" name=\"billing_group\" id=\"billing_group\"  value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type= \"hidden\" name=\"PAYER_EMP_ID_MAND_YN\" id=\"PAYER_EMP_ID_MAND_YN\"  value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type= \"hidden\" name=\"currency_code_for_bg\" id=\"currency_code_for_bg\"  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type= \"hidden\" name=\"currency_desc_for_bg\" id=\"currency_desc_for_bg\"  value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type= \"hidden\" name=\"is_blng_grp_pkg_link_YN\" id=\"is_blng_grp_pkg_link_YN\"  value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type= \"hidden\" name=\"sel_bg_has_valid_pkg_YN\" id=\"sel_bg_has_valid_pkg_YN\"  value=\"\">\t\n\t<input type= \"hidden\" name=\"valid_pkg_for_pat_avail_YN\" id=\"valid_pkg_for_pat_avail_YN\"  value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\t\n\t<input type= \"hidden\" name=\"valid_pkg_for_pat_bg_avail_YN\" id=\"valid_pkg_for_pat_bg_avail_YN\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\t\n\n\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t<td width=\"25%\"  class=\"label\" id=\'BC1\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t<td width=\"25%\"  class=\'fields\' id=\'BC2\'><select name=\"billing_class\" id=\"billing_class\" tabIndex=\'2\'><option value=\'\'>---";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="---</option>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="      \n </select><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t<!--\t<td width=\"25%\"  class=\"label\" id=\'BC1\' ></td> -->\n\t<!--\t<td width=\"\" ><input type=\'hidden\' name=\'billing_class\' id=\'billing_class\' value=\'\'>\n\t\t<b class=\"label\" id=\"patientSchemeID\"> </b>\t</td> -->\n<input type=\'hidden\' name=\'billing_class\' id=\'billing_class\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<b class=\"label\" id=\"patientSchemeID\"> </b> \n\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n<td width=\"25%\" class=\"label\"></td>\n<td width=\"25%\" class=\"button\">\n<input type=button class=\'button\' name=\'modify_button\' id=\'modify_button\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"  onClick=\'return funModifyPatDet(\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\",document.forms[0].sel_frm_prev_enc);\'>\n<input type=button class=\'button\' name=\'close_button\' id=\'close_button\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" onClick=\'payerstatus();return sendBackFinDetails();\'></td>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n<td width=\"25%\" class=\"label\"></td>\n<td width=\"25%\" class=\"fields\">\n<input type=button class=\'button\' name=\'close_button\' id=\'close_button\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" onClick=\'return sendBackFinDetails();\'></td>\n</td>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n<input type=\'hidden\' name=\'employer_code\' id=\'employer_code\' value=\"\"></input>  \n<div id=\'emp_id_mand_YN_disp\' style=\'display:none\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\n<td width=\"25%\" class=\"label\"></td>\n<td width=\"25%\" class=\"label\"></td>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n<td width=\"25%\"  class=\'fields\' ><select name=\"employer_code\" id=\"employer_code\" tabIndex=\'3\'><option value=\"\">---";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="---</option>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="      \n</select>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n<div id=\'emp_id_mand_YN_disp\' style=\'display:inline\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n<div id=\'emp_id_mand_YN_disp\' style=\'display:none\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n</td>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n<td width=\"25%\" class=\"labels\">\n<a href=\"javascript:getPackageBill(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\',\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\');\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</a>\n</td>\n\n<td width=\"25%\"  class=\'fields\' >\n<input type=\'text\' name=\'package_bill_ref\' id=\'package_bill_ref\'  size=15 maxlength=15 readonly value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"><input type=\'text\' name=\'package_bill_ref1\' id=\'package_bill_ref1\'  size=15 maxlength=15 readonly value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n</td>\t\t\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\n<td width=\"25%\" class=\"label\"></td>\n<td  width=\"25%\" class=\"label\"></td>\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n<input type=\'hidden\' name=\'cur_patient_id\' id=\'cur_patient_id\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n<input type=\'hidden\' name=\'CitizenYn\' id=\'CitizenYn\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n<input type=\'hidden\' name=\'ins_auth_flag\' id=\'ins_auth_flag\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n<!--\n<input type=\'hidden\' name=\'upd_fin_dtls\' id=\'upd_fin_dtls\' value=\'\'>\n-->\n<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n<input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n<input type=\'hidden\' name=\'show_hide_blng_class\' id=\'show_hide_blng_class\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n\n<input type=\'hidden\' name=\'third_party_gl_in_use_yn\' id=\'third_party_gl_in_use_yn\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<input type=\'hidden\' name=\'third_party_gl_mandatory_yn\' id=\'third_party_gl_mandatory_yn\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n<input type=\'hidden\' name=\'ref_id\' id=\'ref_id\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n<input type=\'hidden\' name=\'org_type_ind\' id=\'org_type_ind\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n<input type=\'hidden\' name=\'capture_employer_id_yn\' id=\'capture_employer_id_yn\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n</tr>\n\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n<tr>\n\t<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n<!--\n\t<td width=\"25%\"  class=\'fields\' ><input maxlength=\'17\' type=text name=\'annual_income\' id=\'annual_income\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,2))\' onblur=\'put_decimal(this,document.forms[0].noofdecimal.value);\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'></input></td>\n-->\n\t<td width=\"25%\"  class=\'fields\' ><input maxlength=\'17\' type=text name=\'annual_income\' id=\'annual_income\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))\' onblur=\'CheckSplApprAmt(this);\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'></input></td>\n\t<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t<td width=\"25%\"  class=\'fields\' ><input type=\"text\" maxlength=\'17\' name=\'family_asset\' id=\'family_asset\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))\' onblur=\'CheckSplApprAmt(this);\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' ></input></td>\n</tr>\t\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'  ></input></td>\n</tr>\t\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n<input type=\'hidden\' name=\"annual_income\" id=\"annual_income\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=\'hidden\' name=\"family_asset\" id=\"family_asset\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n<input type=hidden name=\"HealthCardTot\" id=\"HealthCardTot\" value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'> \n<input type=hidden name=\"bl_oper_yn\" id=\"bl_oper_yn\" value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'> \n<input type=hidden name=\"HealthCardExpired\" id=\"HealthCardExpired\" value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'> \n<input type=hidden name=\"special_scheme_appl\" id=\"special_scheme_appl\" value=\'N\'> \n<input type=hidden name=\"alt_id1_exp_date\" id=\"alt_id1_exp_date\" value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'> \n<input type=hidden name=\"blng_applicable_yn\" id=\"blng_applicable_yn\" value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\t\n<input type=hidden name=\"bl_data_from_repos_yn\" id=\"bl_data_from_repos_yn\" value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\t\n<input type=hidden name=\"data_source_id\" id=\"data_source_id\" value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\t\n<input type=hidden name=\"items_disabled\" id=\"items_disabled\" value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\t\n<input type=hidden name=\"calling_module_id\" id=\"calling_module_id\" value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\t\n<input type=hidden name=\"ext_billing_group\" id=\"ext_billing_group\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\t\n<input type=hidden name=\"ext_settl_type\" id=\"ext_settl_type\" value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\t\n<input type=hidden name=\"function_id\" id=\"function_id\" value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\t\n<input type=hidden name=\"patient_found\" id=\"patient_found\" value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n<input type=hidden name=\"boolean_security\" id=\"boolean_security\" value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\t\t\n<input type=hidden name=\'chng_to_visit_yn\' id=\'chng_to_visit_yn\'   value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n<input type=hidden name=\'facility_id\' id=\'facility_id\'   value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n<input type=hidden name=\'episode_type\' id=\'episode_type\'   value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n<input type=hidden name=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\'   value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n<input type=hidden name=\'logged_user_id\' id=\'logged_user_id\'   value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n<input type=hidden name=\'temp_blng_class\' id=\'temp_blng_class\'   value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n<input type=hidden name=\'temp_bill_type\' id=\'temp_bill_type\'   value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n<input type=hidden name=\'bed_class_code\' id=\'bed_class_code\'   value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n<input type=hidden name=\'bed_type\' id=\'bed_type\'   value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n<input type=hidden name=\'bed_no\' id=\'bed_no\'   value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n<input type=hidden name=\'visit_adm_type\' id=\'visit_adm_type\'   value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n<input type=hidden name=\'nursing_unit_code\' id=\'nursing_unit_code\'   value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n<input type=hidden name=\'ip_message_id\' id=\'ip_message_id\'   value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n<input type=hidden name=\'dept_code\' id=\'dept_code\'   value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n<input type=hidden name=\'special_scheme_type\' id=\'special_scheme_type\'\t\tvalue=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n<input type=hidden name=\'special_scheme_message\' id=\'special_scheme_message\'\t\tvalue=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\"     value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"></input>\n<input type=\"hidden\" name=\"practitioner_type_ind\" id=\"practitioner_type_ind\"     value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"></input>\n<input type=hidden name=\'patient_blng_grp\' id=\'patient_blng_grp\'\t\tvalue=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n<input type=hidden name=\'special_scheme_blng_grp\' id=\'special_scheme_blng_grp\'\t\tvalue=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n<input type=hidden name=\'special_scheme_blng_grp_desc\' id=\'special_scheme_blng_grp_desc\'\tvalue=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n<input type=hidden name=\'spl_scheme_blng_grp_present\' id=\'spl_scheme_blng_grp_present\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\t\n<input type=hidden name=\'blnggrpappyn\' id=\'blnggrpappyn\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\t\t\n<input type=hidden name=\'blnggrpcatgappyn\' id=\'blnggrpcatgappyn\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n<input type=hidden name=\'BlngGrpStatus\' id=\'BlngGrpStatus\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\t\t\n<input type=hidden name=\'mblnggroup\' id=\'mblnggroup\' value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\t\t\n<input type=hidden name=\'hcard_applicable_yn\' id=\'hcard_applicable_yn\'\t\tvalue=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n<input type=hidden name=\'hcare_applicable_yn\' id=\'hcare_applicable_yn\'\t\tvalue=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n<input type=hidden name=\'hcard_scheme_id\' id=\'hcard_scheme_id\'\t\tvalue=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n<input type=hidden name=\'hcare_scheme_id\' id=\'hcare_scheme_id\'\t\tvalue=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n<input type=hidden name=\'hcard_expired_yn\' id=\'hcard_expired_yn\'\t\tvalue=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n<input type=hidden name=\'hcare_expired_yn\' id=\'hcare_expired_yn\'\t\tvalue=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n<input type=hidden name=\'previous_blng_grp\' id=\'previous_blng_grp\'\t\t\tvalue=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n<input type=hidden name=\'previous_blng_grp_desc\' id=\'previous_blng_grp_desc\'\tvalue=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n<input type=hidden name=\'hcard_prerequisite_yn\' id=\'hcard_prerequisite_yn\' \tvalue=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n<input type=hidden name=\'operation\' id=\'operation\'\tvalue=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n<input type=hidden name=\'billing_mode\' id=\'billing_mode\' \tvalue=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n<input type=hidden name=\'glholdername\' id=\'glholdername\' \tvalue=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n<input type=hidden name=\'glrel\' id=\'glrel\' \tvalue=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n<input type=hidden name=\'payresp\' id=\'payresp\' \tvalue=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n<input type=hidden name=\'blnggrp\' id=\'blnggrp\' \tvalue=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n<input type=hidden name=\'strBillGrpId\' id=\'strBillGrpId\' \tvalue=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n<input type=hidden name=\'strdfltbgyn\' id=\'strdfltbgyn\' \tvalue=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n<input type=hidden name=\'upd_fin_dtl_chkbx\' id=\'upd_fin_dtl_chkbx\' \tvalue=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n<tr>\n\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</td>\n\t<td width=\"25%\" class=\'fields\' ><input type=\"text\" maxlength=\'2\' size=\"2\" name=\'no_of_dependants\' id=\'no_of_dependants\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'></input></td>\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t<td width=\'25%\' class=\"label\"><div id=\'vw_pkg_dtl_disp\' style=\"display:inline\"><a href=\"javascript:view_trmt_pkg_dtl();\">";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</a></div></td>\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t<td width=\'25%\' class=\"label\"><div id=\'vw_pkg_dtl_disp\' style=\"display:none\"><a href=\"javascript:view_trmt_pkg_dtl();\">";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t<td width=\'25%\'></td>\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t<td width=\'25%\'></td>\n</tr>\n\n<tr>\n\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</td>\n\t<td width=\"25%\"  class=\"fields\" ><input maxlength=\'30\' size=\'20\' type=text name=\'resp_for_payment\' id=\'resp_for_payment\'  value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\' onBlur=\"chk_for_entry(this,document.forms[0].pat_reln_with_resp_person,document.forms[0].patrelbut);\"></input>\n<!--\n\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t<a href=\"javascript:getRefDet();\">";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</a></td>\n\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\n\t\t\t<a href=\"javascript:getRefDet();\">";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\t\n\t\t\t\n\t\t\n-->\n";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t<div id=\'sel_resp_for_pay_disp\' style=\"display:none\"><img src=\'../../eCommon/images/mandatory.gif\'></div>\n";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n<div id=\'sel_resp_for_pay_disp\' style=\"display:inline\"><img src=\'../../eCommon/images/mandatory.gif\'></div>\n";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n<div id=\'sel_resp_for_pay_disp\' style=\"display:none\"><img src=\'../../eCommon/images/mandatory.gif\'></div>\n";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\n\t</td>\n\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</td>\n\t<td width=\"25%\"  class=\"fields\" ><input type=\'text\' name=\"pat_reln_with_resp_person\" id=\"pat_reln_with_resp_person\" maxlength=\'30\' size=\'20\' tabindex=\'0\'  value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" onBlur=\"return patrellkup(\'B\')\" DISABLED><input type=\'button\' class=\'button\' name=\"patrelbut\" id=\"patrelbut\" value=\'?\' onClick=\"return patrellkup(\'C\')\" tabindex=\'0\' DISABLED></td>\n</tr>\n\n";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\t\n\n<tr>\n\t<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n\t<td width=\"25%\"  class=\"fields\" ><input maxlength=\'60\' size=\'30\' type=text name=\'gl_holder_name\' id=\'gl_holder_name\'  value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\' onBlur=\"gllkup(\'B\');chk_for_entry(this,document.forms[0].pat_reln_with_gl_holder,document.forms[0].glrelbut);\">\n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t<input type=\'button\' class=\'button\' name=\"glbut\" id=\"glbut\" value=\'?\' onClick=\"return gllkup(\'C\')\"  tabindex=\'0\'>\n";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t</td>\t\n\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\n\t<td width=\"25%\"  class=\"fields\" ><input type=\'text\' name=\"pat_reln_with_gl_holder\" id=\"pat_reln_with_gl_holder\" maxlength=\'30\' size=\'20\' tabindex=\'0\'  value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" onBlur=\"return glrellkup(\'B\')\" DISABLED><input type=\'button\' class=\'button\' name=\"glrelbut\" id=\"glrelbut\" value=\'?\' onClick=\"return glrellkup(\'C\')\" tabindex=\'0\' DISABLED></td>\n</tr>\t\t\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t<input type=\'hidden\' name=\'gl_holder_name\' id=\'gl_holder_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'pat_reln_with_gl_holder\' id=\'pat_reln_with_gl_holder\' value=\'\'>\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="</td>\n\t<td width=\"25%\"  class=\"fields\" ><input type=checkbox name=\'upd_fin_dtls\' id=\'upd_fin_dtls\' style=\'text-align:right\' onClick=\'chng_class_for_inv_pyrs_on_rfrsh()\' ";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="></input></td>\n\t<td width=\"25%\"  class=\"label\" >\n";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t<a href=\"javascript:getRefDet();\">";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</a></td>\t\t\n";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</a></td>\n";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</a></td>\t\n";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t</td>\n\t<td width=\"25%\"  class=\"label\" ></td>\n</tr>\n";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t<input type=\'hidden\' name=\'upd_fin_dtls\' id=\'upd_fin_dtls\' value=\'N\'>\n";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</td>\n\t<td width=\"25%\"  class=\'fields\' ><input type=\"text\" size=\"2\" maxlength=\'2\' name=\'no_of_dependants\' id=\'no_of_dependants\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' value=\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'></input></td> \n";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t<td width=\'25%\'></td>\n</tr>\n\n<tr>\n\t<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="</td>\n\t<td width=\"25%\"  class=\"fields\" ><input maxlength=\'30\' size=\'20\' type=text name=\'resp_for_payment\' id=\'resp_for_payment\' value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\' onBlur=\"chk_for_entry(this,document.forms[0].pat_reln_with_resp_person,document.forms[0].patrelbut);\"></input>\n<!--\n\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="<a href=\"javascript:getRefDet();\">";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="</a></td>";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\t\t\n-->\t\n\n\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\n\n\t</td>\n\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="</td>\n\t\t<td width=\"25%\"  class=\"fields\" ><input type=\'text\' name=\"pat_reln_with_resp_person\" id=\"pat_reln_with_resp_person\" maxlength=\'30\' size=\'20\' tabindex=\'0\'  value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" onBlur=\"return patrellkup(\'B\')\" DISABLED><input type=\'button\' class=\'button\' name=\"patrelbut\" id=\"patrelbut\" value=\'?\' onClick=\"return patrellkup(\'C\')\" tabindex=\'0\' DISABLED></td>\n\t</tr>\n\n<!-- Added on 09/11/2003 -->\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t<input type=\'button\' class=\'button\' name=\"glbut\" id=\"glbut\" value=\'?\' onClick=\"return gllkup(\'C\')\" tabindex=\'0\' >\n";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t</td>\t\n\n\t<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" onBlur=\"return glrellkup(\'B\')\" DISABLED><input type=\'button\' class=\'button\' name=\"glrelbut\" id=\"glrelbut\" value=\'?\' onClick=\"return glrellkup(\'C\')\" tabindex=\'0\' DISABLED></td>\n</tr>\n";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="</td>\n\t<td width=\"25%\"  class=\"fields\" ><input type=checkbox name=\'upd_fin_dtls\' id=\'upd_fin_dtls\' style=\'text-align:right\' onClick=\'\' ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n<input type=\'hidden\' name=\'cap_ref_src_dtl_flag\' id=\'cap_ref_src_dtl_flag\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n<input type=\'hidden\' name=\'referral_source_main_mand_YN\' id=\'referral_source_main_mand_YN\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n<input type=\'hidden\' name=\'referral_source_sub_mand_YN\' id=\'referral_source_sub_mand_YN\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'>\n<tr>\n\t\n\t<td width=\"25%\" class=\"Label\">\n\t\t<div id=\'ref_src_code_main_leg_disp\' style=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t</div>\n\t</td>\n\n\t<td width=\"25%\" class=\"fields\">\n\t\t<div id=\'ref_src_code_main_val_disp\' style=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'>\n\t\t\t<input type=\'text\' name=\"referral_source_main_desc\" id=\"referral_source_main_desc\" maxlength=\'50\' size=\'25\' tabindex=\'0\'  value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" onBlur=\"return refsrclkup(document.forms[0].referral_source_main_code,document.forms[0].referral_source_main_desc,\'M\',\'B\')\">\n\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcmainbut\" id=\"refsrcmainbut\" value=\'?\' onClick=\"return refsrclkup(document.forms[0].referral_source_main_code,document.forms[0].referral_source_main_desc,\'M\',\'C\')\" tabindex=\'0\'>\n\t\t\t<div id=\'ref_src_code_main_mand_disp\' style=\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\n";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"pmy_ref_src_lng_name\" id=\"pmy_ref_src_lng_name\" align=\'center\' style=\"visibility:hidden\">\n";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"pmy_ref_src_lng_name\" id=\"pmy_ref_src_lng_name\" align=\'center\' style=\"visibility:inline\" alt=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\t\t\t\n\t\t</div>\n\t</td>\n\t\n\t<td width=\"25%\" class=\"Label\">\n\t\t<div id=\'ref_src_code_sub_leg_disp\' style=\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t</div>\n\t</td>\n\t\n\t<td width=\"25%\" class=\"fields\">\n\t\t<div id=\'ref_src_code_sub_val_disp\' style=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'>\n\t\t\t<input type=\'text\' name=\"referral_source_sub_desc\" id=\"referral_source_sub_desc\" maxlength=\'50\' size=\'25\' tabindex=\'0\'  value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" onBlur=\"return refsrclkup(document.forms[0].referral_source_sub_code,document.forms[0].referral_source_sub_desc,\'S\',\'B\')\">\n\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcsubbut\" id=\"refsrcsubbut\" value=\'?\' onClick=\"return refsrclkup(document.forms[0].referral_source_sub_code,document.forms[0].referral_source_sub_desc,\'S\',\'F\')\" tabindex=\'0\'>\n\t\t\t<div id=\'ref_src_code_sub_mand_disp\' style=\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"sec_ref_src_lng_name\" id=\"sec_ref_src_lng_name\" align=\'center\' style=\"visibility:hidden\">\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"sec_ref_src_lng_name\" id=\"sec_ref_src_lng_name\" align=\'center\' style=\"visibility:inline\" alt=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\t\t\t\t\n\t\t</div>\n\t</td>\n\t\n</tr>\n<input type=\'hidden\' name=\'referral_source_main_code\' id=\'referral_source_main_code\' value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n<input type=\'hidden\' name=\'referral_source_sub_code\' id=\'referral_source_sub_code\' value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t<tr>\n<td width=\"25%\">&nbsp;</td>\n<td width=\"25%\">&nbsp;</td>\n <td colspan=\'2\' width=\"25%\" class=\'label\'>\n\t<div id=\"pkgSubsMsg\" style=\"display: none\">\n\t\t<b>\n\t\t<font color=\"#bf40bf\">\n\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t</font>\n\t\t</b>\n\t</div>\n </td>\t\n</tr>\n\t\t\t<tr>\n";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t<td width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="</td>\n\t\t<td width=\"25%\"  class=\"fields\" ><input type=checkbox name=\'spl_clinic_rel_enc_YN\' id=\'spl_clinic_rel_enc_YN\' style=\'text-align:right\' onClick=\'\' ";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="></input></td>\n";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\t\t\n\t\t<td width=\"25%\">&nbsp;</td>\n\t\t<td width=\"25%\">&nbsp;</td>\n\t\t<input type=\'hidden\' name=\'spl_clinic_rel_enc_YN\' id=\'spl_clinic_rel_enc_YN\' value=\'N\'>\n";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t\t\t<td width=\"25%\" class=\"Label\">\n\t\t<div id=\"pkgAssociateSubs\" style=\"display:none\">\n";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n\t\t\t<a  href=\"javascript:associatePkgFromVisit(document.forms[0].patient_id.value,document.forms[0].encounter_date.value,document.forms[0].encounter_date_time.value,document.forms[0].encounter_date_aft_trunc.value,document.forms[0].calling_module_id.value,document.forms[0].firstVisitDateTime.value);\">[";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="]</a>\n";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\t\t\n\t\t\t<a  href=\"javascript:subscribePackageFromVisit(document.forms[0].patient_id.value,document.forms[0].calling_module_id.value);\">[";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="]</a>\n\t\t\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\n\t\t\t<a  href=\"javascript:callPackgeDiscount(document.forms[0].patient_id.value,document.forms[0].calling_module_id.value);\">[";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t\t\t</div>\n\t\t\t\n\t\t\t</td>\n\t\t\t\n";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t<td width=\"25%\" class=\"Label\">\n\t\t<div id=\"sel_frm_prev_enc_disp\" style=\"display:none\">\n\t\t\t<a href=\"javascript:sel_frm_prev_enc();\"><B>[";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="]</b></a>\n\t\t</div>\n\t</td>\n</tr>\n\n";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n<tr>\n\t<td colspan=\'2\'>&nbsp;</td>\n</tr>\n";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\n<input type= \'hidden\' name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\'>\n<input type= \'hidden\' name=\"noofdecimal\" id=\"noofdecimal\"  value=\'";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\'>\n<input type= \'hidden\' name=\"sys_date\" id=\"sys_date\"  value=\'";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\'>\n<input type= \'hidden\' name=\"encounter_date\" id=\"encounter_date\"  value=\'";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\'>\n<input type= \'hidden\' name=\"sel_frm_prev_enc\" id=\"sel_frm_prev_enc\"  value=\'";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\'>\n<input type= \'hidden\' name=\"pat_ser_code\" id=\"pat_ser_code\"  value=\'";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\'>\n\n<input type=\'hidden\' name=\'setlmt_ind\' id=\'setlmt_ind\' value=\'";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\'>\n<input type=\'hidden\' name=\'adm_rec_flag\' id=\'adm_rec_flag\' value=\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'>\n<input type=\'hidden\' name=\'credit_doc_ref_reqd_yn\' id=\'credit_doc_ref_reqd_yn\' value=\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\'>\n<input type=\'hidden\' name=\'disaster_regn_YN\' id=\'disaster_regn_YN\' value=\'";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'>\n\n<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'\'>\n<input type= \'hidden\' name=\"fin_auth_user_id\" id=\"fin_auth_user_id\"  value=\'";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\'>\n\n<input type=\'hidden\' name=\'fin_class_flag_YN\' id=\'fin_class_flag_YN\' value=\'";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\'>\n<input type=\'hidden\' name=\'autoFinChk\' id=\'autoFinChk\' value=\'";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\'>\n<input type=\'hidden\' name=\'fin_class_dtls_updated_YN\' id=\'fin_class_dtls_updated_YN\' value=\'";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\'>\n\n<input type=\'hidden\' name=\'charge_for_pat_regn_yn\' id=\'charge_for_pat_regn_yn\' value=\'";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\'>\n\n<!-- Newly added for transfereing the values to a BLFinancialDetailsSubmit.jsp -->\n<input type=\'hidden\' name=\'rtn_blng_grp\' id=\'rtn_blng_grp\' value=\"\">\n<input type=\'hidden\' name=\'rtn_slmt_ind\' id=\'rtn_slmt_ind\' value=\"\">\n<input type=\'hidden\' name=\'rtn_credit_doc_reqd_yn\' id=\'rtn_credit_doc_reqd_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_blng_class\' id=\'rtn_blng_class\' value=\"\">\n<input type=\'hidden\' name=\'rtn_emp_code\' id=\'rtn_emp_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_slmt_type_code\' id=\'rtn_slmt_type_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_inst_ref\' id=\'rtn_inst_ref\' value=\"\">\n<input type=\'hidden\' name=\'rtn_inst_date\' id=\'rtn_inst_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_inst_remarks\' id=\'rtn_inst_remarks\' value=\"\">\n<input type=\'hidden\' name=\'rtn_credit_cust_group_code\' id=\'rtn_credit_cust_group_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_credit_cust_code\' id=\'rtn_credit_cust_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_credit_doc_ref\' id=\'rtn_credit_doc_ref\' value=\"\">\n<input type=\'hidden\' name=\'rtn_credit_doc_start_date\' id=\'rtn_credit_doc_start_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_credit_doc_end_date\' id=\'rtn_credit_doc_end_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_sponsor_cust_group_code\' id=\'rtn_sponsor_cust_group_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_sponsor_cust_code\' id=\'rtn_sponsor_cust_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_sponsor_credit_doc_ref\' id=\'rtn_sponsor_credit_doc_ref\' value=\"\">\n<input type=\'hidden\' name=\'rtn_sponsor_credit_doc_start_date\' id=\'rtn_sponsor_credit_doc_start_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_sponsor_credit_doc_end_date\' id=\'rtn_sponsor_credit_doc_end_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_blng_grp\' id=\'rtn_ins_blng_grp\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cust_group_code\' id=\'rtn_ins_cust_group_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cust_code\' id=\'rtn_ins_cust_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cust_priority\' id=\'rtn_ins_cust_priority\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_type_code\' id=\'rtn_ins_policy_type_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_no\' id=\'rtn_ins_policy_no\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_start_date\' id=\'rtn_ins_policy_start_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_expiry_date\' id=\'rtn_ins_policy_expiry_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_credit_auth_ref\' id=\'rtn_ins_credit_auth_ref\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_credit_auth_date\' id=\'rtn_ins_credit_auth_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cred_auth_req_yn\' id=\'rtn_ins_cred_auth_req_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cred_auth_mand_capt_yn\' id=\'rtn_ins_cred_auth_mand_capt_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_dflt_auth_ref_as_pol_no_yn\' id=\'rtn_ins_dflt_auth_ref_as_pol_no_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_credit_approval_days\' id=\'rtn_ins_credit_approval_days\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_credit_approval_amount\' id=\'rtn_ins_credit_approval_amount\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_eff_from_date\' id=\'rtn_ins_policy_eff_from_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_eff_to_date\' id=\'rtn_ins_policy_eff_to_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_adj_rule_ind\' id=\'rtn_ins_adj_rule_ind\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_adj_perc_amt_ind\' id=\'rtn_ins_adj_perc_amt_ind\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_adj_perc_amt_value\' id=\'rtn_ins_adj_perc_amt_value\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_pmnt_diff_adj_int\' id=\'rtn_ins_pmnt_diff_adj_int\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_drg_pmnt_diff_adj_int\' id=\'rtn_ins_drg_pmnt_diff_adj_int\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_spl_srv_pmnt_diff_adj_int\' id=\'rtn_ins_spl_srv_pmnt_diff_adj_int\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_blng_grp\' id=\'rtn_non_ins_blng_grp\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_credit_doc_reqd_yn\' id=\'rtn_non_ins_credit_doc_reqd_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_slmt_type_code\' id=\'rtn_non_ins_slmt_type_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_inst_ref\' id=\'rtn_non_ins_inst_ref\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_inst_date\' id=\'rtn_non_ins_inst_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_inst_remarks\' id=\'rtn_non_ins_inst_remarks\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_cust_group_code\' id=\'rtn_non_ins_cust_group_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_cust_code\' id=\'rtn_non_ins_cust_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_credit_doc_ref\' id=\'rtn_non_ins_credit_doc_ref\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_credit_doc_start_date\' id=\'rtn_non_ins_credit_doc_start_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_credit_doc_end_date\' id=\'rtn_non_ins_credit_doc_end_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_annual_income\' id=\'rtn_annual_income\' value=\"\">\n<input type=\'hidden\' name=\'rtn_family_asset\' id=\'rtn_family_asset\' value=\"\">\n<input type=\'hidden\' name=\'rtn_no_of_dependants\' id=\'rtn_no_of_dependants\' value=\"\">\n<input type=\'hidden\' name=\'rtn_resp_for_payment\' id=\'rtn_resp_for_payment\' value=\"\">\n<input type=\'hidden\' name=\'rtn_pat_reln_with_resp_person\' id=\'rtn_pat_reln_with_resp_person\' value=\"\">\n<input type=\'hidden\' name=\'rtn_fin_remarks\' id=\'rtn_fin_remarks\' value=\"\">\n<input type=\'hidden\' name=\'rtn_gl_holder_name\' id=\'rtn_gl_holder_name\' value=\"\">\n<input type=\'hidden\' name=\'rtn_pat_reln_with_gl_holder\' id=\'rtn_pat_reln_with_gl_holder\' value=\"\">\n<input type=\'hidden\' name=\'rtn_upd_patient_fin_dtls_yn\' id=\'rtn_upd_patient_fin_dtls_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_spl_clinic_rel_enc_YN\' id=\'rtn_spl_clinic_rel_enc_YN\' value=\"\">\n<input type=\'hidden\' name=\'rtn_user_id\' id=\'rtn_user_id\' value=\"\">\n<input type=\'hidden\' name=\'rtn_fin_auth_user_id\' id=\'rtn_fin_auth_user_id\' value=\"\">\n<input type=\'hidden\' name=\'rtn_calling_function_id\' id=\'rtn_calling_function_id\' value=\"\">\n<input type=\'hidden\' name=\'rtn_total_records\' id=\'rtn_total_records\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_restrict_check\' id=\'rtn_ins_restrict_check\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_apprd_amt_restrict_check\' id=\'rtn_ins_apprd_amt_restrict_check\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_apprd_days_restrict_check\' id=\'rtn_ins_apprd_days_restrict_check\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ref_src_main_code\' id=\'rtn_ref_src_main_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ref_src_main_desc\' id=\'rtn_ref_src_main_desc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ref_src_sub_code\' id=\'rtn_ref_src_sub_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ref_src_sub_desc\' id=\'rtn_ref_src_sub_desc\' value=\"\">\n\n<input type=\'hidden\' name=\'rtn_ins_ref_src_main_code\' id=\'rtn_ins_ref_src_main_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_ref_src_main_desc\' id=\'rtn_ins_ref_src_main_desc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_ref_src_sub_code\' id=\'rtn_ins_ref_src_sub_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_ref_src_sub_desc\' id=\'rtn_ins_ref_src_sub_desc\' value=\"\">\n\n<input type=\'hidden\' name=\'rtn_non_ins_ref_src_main_code\' id=\'rtn_non_ins_ref_src_main_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_ref_src_main_desc\' id=\'rtn_non_ins_ref_src_main_desc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_ref_src_sub_code\' id=\'rtn_non_ins_ref_src_sub_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_non_ins_ref_src_sub_desc\' id=\'rtn_non_ins_ref_src_sub_desc\' value=\"\">\n\n<input type=\'hidden\' name=\'encounter_date_time\' id=\'encounter_date_time\' value=\'";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\'>\n<input type=\'hidden\' name=\'encounter_date_aft_trunc\' id=\'encounter_date_aft_trunc\' value=\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\'>\n\n<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\">\n<input type=\'hidden\' name=\'selecltd_bg_frm_pkg\' id=\'selecltd_bg_frm_pkg\' value=\"\">\n<input type=\'hidden\' name=\'selecltd_bg_desc_frm_pkg\' id=\'selecltd_bg_desc_frm_pkg\' value=\"\">\n<input type=\'hidden\' name=\'selecltd_cust_grp_frm_pkg\' id=\'selecltd_cust_grp_frm_pkg\' value=\"\">\n<input type=\'hidden\' name=\'selecltd_cust_frm_pkg\' id=\'selecltd_cust_frm_pkg\' value=\"\">\n<input type=\'hidden\' name=\'blng_grp_sel_frm_pkg_YN\' id=\'blng_grp_sel_frm_pkg_YN\' value=\"\">\n\n<input type=\'hidden\' name=\'rtn_tot_valid_enc_with_gl\' id=\'rtn_tot_valid_enc_with_gl\' value=\"\">\n<input type=\'hidden\' name=\'rtn_tot_valid_op_enc_with_gl\' id=\'rtn_tot_valid_op_enc_with_gl\' value=\"\">\n<input type=\'hidden\' name=\'rtn_tot_valid_ae_enc_with_gl\' id=\'rtn_tot_valid_ae_enc_with_gl\' value=\"\">\n<input type=\'hidden\' name=\'rtn_tot_valid_ip_enc_with_gl\' id=\'rtn_tot_valid_ip_enc_with_gl\' value=\"\">\n<input type=\'hidden\' name=\'rtn_tot_valid_dc_enc_with_gl\' id=\'rtn_tot_valid_dc_enc_with_gl\' value=\"\">\n\n<input type=\'hidden\' name=\'rtn_tot_availed_enc_with_gl\' id=\'rtn_tot_availed_enc_with_gl\' value=\"\">\n<input type=\'hidden\' name=\'rtn_tot_availed_op_enc_with_gl\' id=\'rtn_tot_availed_op_enc_with_gl\' value=\"\">\n<input type=\'hidden\' name=\'rtn_tot_availed_ae_enc_with_gl\' id=\'rtn_tot_availed_ae_enc_with_gl\' value=\"\">\n<input type=\'hidden\' name=\'rtn_tot_availed_ip_enc_with_gl\' id=\'rtn_tot_availed_ip_enc_with_gl\' value=\"\">\n<input type=\'hidden\' name=\'rtn_tot_availed_dc_enc_with_gl\' id=\'rtn_tot_availed_dc_enc_with_gl\' value=\"\">\n\n<input type=\'hidden\' name=\'rtn_gl_doc_ref_exist_YN\' id=\'rtn_gl_doc_ref_exist_YN\' value=\"\">\n<input type=\'hidden\' name=\'rtn_pat_ser_code\' id=\'rtn_pat_ser_code\' value=\"\">\n\n\t\t\t<input type=\'hidden\' name=\'open_pkg_exists_yn\' id=\'open_pkg_exists_yn\' value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n<!-- Added for Classification Valued Capturing Purpose -->\n<input type=\'hidden\' name=\'rtn_class_type\' id=\'rtn_class_type\' value=\'\' >\n<input type=\'hidden\' name=\'rtn_class_code\' id=\'rtn_class_code\' value=\'\' >\t\n<input type=\'hidden\' name=\'rtn_remarks\' id=\'rtn_remarks\' value=\'\' >\t\t\t\t\n<input type=\'hidden\' name=\'rtn_social_pensioner_id\' id=\'rtn_social_pensioner_id\' value=\'\' >\t\t\t\t\n<input type=\'hidden\' name=\'rtn_inc_asset_ind\' id=\'rtn_inc_asset_ind\' value=\'\' >\t\t\t\n<input type=\'hidden\' name=\'rtn_ind_inc\' id=\'rtn_ind_inc\' value=\'\' >\t\t\t\t\n<input type=\'hidden\' name=\'rtn_ind_inc_freq\' id=\'rtn_ind_inc_freq\' value=\'\' >\t\t\n<input type=\'hidden\' name=\'rtn_spouse_inc\' id=\'rtn_spouse_inc\' value=\'\' >\t\t\t\n<input type=\'hidden\' name=\'rtn_spouse_inc_freq\' id=\'rtn_spouse_inc_freq\' value=\'\' >\t\n<input type=\'hidden\' name=\'rtn_dependent_inc\' id=\'rtn_dependent_inc\' value=\'\' >\t\n<input type=\'hidden\' name=\'rtn_dependent_inc_freq\' id=\'rtn_dependent_inc_freq\' value=\'\' >\n<input type=\'hidden\' name=\'rtn_valid_from\' id=\'rtn_valid_from\' value=\'\' >\n<input type=\'hidden\' name=\'rtn_valid_to\' id=\'rtn_valid_to\' value=\'\' >\n<input type=\'hidden\' name=\'rtn_last_date\' id=\'rtn_last_date\' value=\'\'  />\n<input type=\'hidden\' name=\'package_enabled_yn\' id=\'package_enabled_yn\' value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\"  />\n<input type=\'hidden\' name=\'isUserAuthorizedClass\' id=\'isUserAuthorizedClass\' value=\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\'>\n<input type=\'hidden\' name=\'str_charge_logic\' id=\'str_charge_logic\' value=\'";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\'><!-- 48333 -->\n<input type=\'hidden\' name=\'uploadurl\' id=\'uploadurl\' value =\'../../eBL/jsp/AddModifyInsUpldImgDtl.jsp?pat_view=Y&\'>\n<input type=\'hidden\' name=\'customer_id\' id=\'customer_id\' value=\'";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\'>\n<input type=\'hidden\' name=\'SiteSpecific\' id=\'SiteSpecific\' id=\'SiteSpecific\' value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" /> \n<!-- Added by MuthuN against 32426 on 07-09-12 -->\n<input type=\'hidden\' name=\'payer_suspended_YN\' id=\'payer_suspended_YN\' value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\"   />\n<!-- Added by MuthuN against 32426 on 07-09-12 -->\n<!-- Added by Rajesh V for CRF - 155 -->\n<input type=\'hidden\' name=\'payerGrpBySetup\' id=\'payerGrpBySetup\' value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\">\n<!-- Added by Karthik for 47345 -->\n<input type=\'hidden\' name=\'successfulUserAuthentication\' id=\'successfulUserAuthentication\' value=\'false\'>\n<!-- Karthik modified Default From Date for MMS-DM-SCF-0214.1 /MMS-DM-SCF-0152.1 Starts  -->\n";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\n<input type=\'hidden\' name=\'firstVisitDateTime\' id=\'firstVisitDateTime\' id=\'firstVisitDateTime\' value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\">\n\n<!--  Karthik added Default From Date for MMS-DM-SCF-0214.1 /MMS-DM-SCF-0152.1 Ends -->\n</table>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\n<script>\n\tparent.frames[1].location.href=\"../../eBL/jsp/AddModifyPatFinDetails6.jsp?setlmt_ind=";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="&boolean_security=";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="&payerGrpBySetup=";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="&adm_rec_flag=";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="&credit_doc_ref_reqd_yn=";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="&CitizenYn=";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="&";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\";\t\n</script>\n";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\n<script>\n\n//\tvar sel_frm_valid_pkg_for_pat_id = confirm(getMessage(\"BL6346\",\"BL\"));\n\n\t\n\n</script>\n";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	String open_pkg_exists_yn=""; 
	String pyrGrpYN="";
    System.err.println("KKKK AddModifyPatFinDetails.jsp?"+request.getQueryString());
	String bean_id		= "PkgAssociateBean" ;
	String bean_name	= "eBL.PkgAssociateBean";
	PkgAssociateBean bean			= (PkgAssociateBean)getBeanObject( bean_id, bean_name, request ) ;
	Connection con = null;
	CallableStatement call_pkg = null;
	PreparedStatement pstmt = null ;
	Statement stmt1				= null;
	ResultSet rs = null, rs0 = null;
	ResultSet rs1 = null, rs2 = null, rs3 = null,rs4 = null;
	ResultSet rset = null;
	String gl_holder_name = "", gl_rel = "";
	String locale			= (String)session.getAttribute("LOCALE");
	int noofdecimal=2;
	String sys_date="";
	String sys_date_wht_sec=""; // System time without seconds
	String encounter_date="";
	String billing_group="";
	String str_slmt_ind="";
	String str_credit_doc_reqd_yn="";
	String str_blng_class="";
	String str_emp_code="";
	String str_slmt_type_code="";
	String str_non_ins_credit_doc_reqd_yn="";
	String str_annual_income="";
	String str_family_asset="";
	String str_no_of_dependants="";
	String str_resp_for_payment="";
	String str_pat_reln_with_resp_person="";
	String str_gl_holder_name="";
	String str_pat_reln_with_gl_holder="";
	String str_upd_patient_fin_dtls_yn="";
	String upd_pat_fin_dtls_YN="";
	String spl_clinic_rel_enc_YN = "";
	String str_spl_clinic_rel_enc_YN="";
	String str_user_id="";
	String sql="";
	String str_adm_rec_flag ="";
	String credit_doc_ref_reqd_yn="";
	String disaster_regn_YN="";
	String strCustomerId = "";

	String ref_src_main_code="";
	String ref_src_main_desc="";
	String ref_src_main_lng_name = "";
	String ref_src_sub_code="";	
	String ref_src_sub_desc="";
	String ref_src_sub_lng_name = "";
	String cur_patient_id ="";

	String sel_frm_prev_enc="N";
	String pat_ser_code="";

	String encounter_date_time = "", encounter_date_aft_trunc="";

	String cash_leg ="", credit_leg ="", sponsor_leg ="", ins_leg ="";

	String fin_class_flag_YN="N", autoFinChk="N", fin_class_dtls_updated_YN="N",class_blng_grp_id="";

	String charge_for_pat_regn_yn = "N";

	String referral_source_capture_YN="N";
	String referral_source_main_mand_YN="N";
	String referral_source_sub_mand_YN="N";

	String fin_auth_user_id="", remarks="";
	String package_enabled_yn="N";//added for package billing
	String facility_id  =  "", strLoggedUser = "" ;
	//Rajesh V
	String hCardYn = "";
	String str_charge_logic ="";
	
	String payerGrpBySetup = "";
	//Rajesh V
	String isUserAuthorizedClass = request.getParameter("isUserAuthorizedClass");
	if(isUserAuthorizedClass == null)		isUserAuthorizedClass="";
//	System.err.println("eBL  Modify PatFin details");
//Boopathy
			String quickAdmissionBillingGroup = null;

			String callingModule= request.getParameter("calling_module_id");
			String callingFunction=request.getParameter("calling_function_id");
			String quickAdmission=request.getParameter("quick_admission");
			if(callingModule==null) callingModule="";
			if(callingFunction==null) callingFunction="";
			if(quickAdmission==null) quickAdmission="N";

//Boopathy
	try
	{
		con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);

		Properties p = (Properties)httpSession.getValue("jdbc");

		
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

		cash_leg = (String) bl_labels.getString("eBL.CASH.label");
		if(cash_leg == null) cash_leg="";
		credit_leg = (String) bl_labels.getString("eBL.CREDIT.label");
		if(credit_leg == null) credit_leg="";
		sponsor_leg = (String) bl_labels.getString("eBL.SPONSOR.label");
		if(sponsor_leg == null) sponsor_leg="";
		ins_leg = (String) common_labels.getString("Common.Insurance.label");
		if(ins_leg == null) ins_leg="";

		facility_id = (String)httpSession.getValue("facility_id");
		if(facility_id == null) facility_id="";
		strLoggedUser = p.getProperty("login_user");
		if(strLoggedUser == null) strLoggedUser="";

		String payer_suspended_YN =""; //Added by MuthuN against 32426 on 07-09-12

		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
		String strUpdFinDtls = null;		
		
		try{
			
			String sqlsiteParam = "Select CUSTOMER_ID from SM_SITE_PARAM ";
			pstmt = con.prepareStatement(sqlsiteParam);		
			rs1 = pstmt.executeQuery();
			
			if(rs1 != null){			
				while(rs1.next()){
					strCustomerId = rs1.getString("CUSTOMER_ID");
					strCustomerId=strCustomerId==null?"":strCustomerId;
				}
			}
			
			pstmt = null;
			rs1 = null;			

		}
		catch(Exception e)
		{
			System.out.println("Exception in getting CUSTOMER_ID"+e);
			e.printStackTrace();
		}
		
			Boolean SiteSpec=false;
			String SiteSpecific ="";
			try
			{
				con = ConnectionManager.getConnection();	
				SiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISABLE_FIN_DETAILS_IN_MP");				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if(SiteSpec){
				SiteSpecific="Y";
			}
			else{
				SiteSpecific="N";
			}
		try
		{
		pstmt = con.prepareStatement("select DFLT_UPDAT_FIN_DTL_CHKBX,NVL(CHARGE_LOGIC_YN,'N') CHARGE_LOGIC ,NVL(ADD_PAYER_CUSTGRP_BY_SETUP,'N') PAYER_GRP  from bl_parameters where OPERATING_FACILITY_ID =?");
		pstmt.setString(1,facility_id);
		ResultSet rsst = pstmt.executeQuery() ;
		if( rsst != null ) 
		{	
			while( rsst.next() )
			{  
				strUpdFinDtls = rsst.getString(1);
				str_charge_logic = rsst.getString(2);
				payerGrpBySetup  = rsst.getString(3);
				
			}
		}
		if (rsst != null) rsst.close();
		pstmt.close();	
		
		}catch(Exception ee)
		{
			strUpdFinDtls = "N";
		}

// Added acc_entity_id='ZZ' in the condition for PE Changes
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI:SS'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from  sm_acc_entity_param where acc_entity_id='ZZ'");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);
				sys_date = rscurr.getString(2);
				sys_date_wht_sec = rscurr.getString(3);
			}	
			if(rscurr!=null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}	

		package_enabled_yn = request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";	

		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;

/* Commented for PE Change
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS'),to_char(sysdate,'dd/mm/yyyy HH24:MI'), to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

			stmt1 = con.createStatement();
			rs4 = stmt1.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date = rs4.getString(1);
					sys_date_wht_sec = rs4.getString(2);
					encounter_date_aft_trunc = rs.getString(3);
				}
			}
			if(rs4 !=null) rs4.close();
			stmt1.close();

			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt1 = con.createStatement();
			rs4 = stmt1.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date_wht_sec = rs4.getString(1);
				}
			}
			if(rs4 !=null) rs4.close();
			stmt1.close();
		}
		catch(Exception e)
		{
			out.println("Exception @ sysdate query"+e);
		}
*/
		try
		{
			String sql_trunc_time="select to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

			stmt1 = con.createStatement();
			rs = stmt1.executeQuery(sql_trunc_time) ;

			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			stmt1.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
		}
		if(!encounter_date_aft_trunc.equals(""))
		{
			encounter_date_aft_trunc = com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY","en",locale) ;
		}


		String query_string=request.getQueryString();

		encounter_date=request.getParameter("encounter_date");
		if(encounter_date==null) encounter_date="";

		disaster_regn_YN=request.getParameter("disaster_regn_YN");
		if(disaster_regn_YN==null || disaster_regn_YN.equals("")) disaster_regn_YN = "N";

		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null || billing_mode.equals("")) billing_mode = "Add";

		String operation = request.getParameter("operation");
		if(operation==null || operation.equals("")) operation = "Insert";

		sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";

		pat_ser_code =request.getParameter("pat_ser_code");
		if(pat_ser_code==null || pat_ser_code.equals("")) pat_ser_code = "";


		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";
		
		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";


		charge_for_pat_regn_yn = request.getParameter("charge_for_pat_regn_yn");
		if(charge_for_pat_regn_yn == null) charge_for_pat_regn_yn="N";

		fin_auth_user_id = request.getParameter("fin_auth_user_id");
		if(fin_auth_user_id == null) fin_auth_user_id="";

		remarks = request.getParameter("remarks");
		if(remarks == null) remarks="";

/*	 The billing_mode & Operation is reset because the billing_group is been reset & to avoid the session to validate  */
		String reset_blng_grp=request.getParameter("reset_blng_grp");

		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			billing_mode="Add";
			operation="Insert";
		}			
		Boolean siteSpec=false;
		
		try
		{
			
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_FIN_CLASS_DTLS_BLANK");
	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in site specific "+e);
		}


		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{

			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				String finDetClose="";
				finDetClose = ((String)bl_data.get("fin_det_close")).trim();
				if(finDetClose == null) finDetClose="";
				
				System.out.println("finDetClose BEF:::"+finDetClose);
				if(siteSpec)
				{
				if(callingModule.equals("IP") || callingModule.equals("DC")) {
					 
					if(finDetClose.equals("Y")){		
				billing_group=((String)bl_data.get("blng_grp")).trim();
				if(billing_group == null) billing_group="";
				str_slmt_ind=((String)bl_data.get("slmt_ind")).trim();
				if(str_slmt_ind == null) str_slmt_ind="";
				str_credit_doc_reqd_yn=((String)bl_data.get("credit_doc_reqd_yn")).trim();
				if(str_credit_doc_reqd_yn == null) str_credit_doc_reqd_yn="";
				str_blng_class=((String)bl_data.get("blng_class")).trim();
				if(str_blng_class == null) str_blng_class="";
				str_emp_code=((String)bl_data.get("emp_code")).trim();
				if(str_emp_code == null) str_emp_code="";
				str_slmt_type_code=((String)bl_data.get("slmt_type_code")).trim();
				if(str_slmt_type_code == null) str_slmt_type_code="";
				str_non_ins_credit_doc_reqd_yn=((String)bl_data.get("non_ins_credit_doc_reqd_yn")).trim();
				if(str_non_ins_credit_doc_reqd_yn == null) str_non_ins_credit_doc_reqd_yn="";
				str_annual_income=((String)bl_data.get("annual_income")).trim();
				if (str_annual_income.equals("")) str_annual_income = "0";
				str_family_asset=((String)bl_data.get("family_asset")).trim();
				if (str_family_asset.equals("")) str_family_asset = "0";
				str_no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
				if (str_no_of_dependants.equals("")) str_no_of_dependants = "0";
				str_resp_for_payment=((String)bl_data.get("resp_for_payment")).trim();
				if(str_resp_for_payment == null) str_resp_for_payment="";
				str_pat_reln_with_resp_person=((String)bl_data.get("pat_reln_with_resp_person")).trim();
				if(str_pat_reln_with_resp_person == null) str_pat_reln_with_resp_person="";
				str_gl_holder_name=((String)bl_data.get("gl_holder_name")).trim();
				if(str_gl_holder_name == null) str_gl_holder_name="";
				str_pat_reln_with_gl_holder=((String)bl_data.get("pat_reln_with_gl_holder")).trim();
				if(str_pat_reln_with_gl_holder == null) str_pat_reln_with_gl_holder="";
				str_upd_patient_fin_dtls_yn=((String)bl_data.get("upd_patient_fin_dtls_yn")).trim();
				if(str_upd_patient_fin_dtls_yn == null) str_upd_patient_fin_dtls_yn="N";
				str_spl_clinic_rel_enc_YN =((String)bl_data.get("spl_clinic_rel_enc_YN")).trim();
				if(str_spl_clinic_rel_enc_YN == null) str_spl_clinic_rel_enc_YN="N";
				str_user_id=((String)bl_data.get("user_id")).trim();
				if(str_user_id == null) str_user_id="";
				ref_src_main_code=((String)bl_data.get("ref_src_main_code")).trim();
				if(ref_src_main_code==null || ref_src_main_code.equals("")) ref_src_main_code="";
				ref_src_main_desc=((String)bl_data.get("ref_src_main_desc")).trim();
				if(ref_src_main_desc==null || ref_src_main_desc.equals("")) ref_src_main_desc="";
				ref_src_sub_code=((String)bl_data.get("ref_src_sub_code")).trim();
				if(ref_src_sub_code==null || ref_src_sub_code.equals("")) ref_src_sub_code="";
				ref_src_sub_desc=((String)bl_data.get("ref_src_sub_desc")).trim();
				if(ref_src_sub_desc==null || ref_src_sub_desc.equals("")) ref_src_sub_desc="";

				cur_patient_id=((String)bl_data.get("cur_patient_id"));
				if(cur_patient_id==null || cur_patient_id.equals("")) cur_patient_id="";
						
						if(autoFinChk.equals("Y"))
						{
							fin_class_dtls_updated_YN=((String)bl_data.get("fin_class_dtls_updated_YN")).trim();
							if(fin_class_dtls_updated_YN==null || fin_class_dtls_updated_YN.equals("")) fin_class_dtls_updated_YN="N";
						}

				
					}else{					
					
						billing_group=((String)bl_data.get("blng_grp")).trim();
						if(billing_group == null) billing_group="";
						str_no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
						if (str_no_of_dependants.equals("")) str_no_of_dependants = "0";
					}
				
				}else{

					billing_group=((String)bl_data.get("blng_grp")).trim();
					if(billing_group == null) billing_group="";
					str_slmt_ind=((String)bl_data.get("slmt_ind")).trim();
					if(str_slmt_ind == null) str_slmt_ind="";
					str_credit_doc_reqd_yn=((String)bl_data.get("credit_doc_reqd_yn")).trim();
					if(str_credit_doc_reqd_yn == null) str_credit_doc_reqd_yn="";
					str_blng_class=((String)bl_data.get("blng_class")).trim();
					if(str_blng_class == null) str_blng_class="";
					str_emp_code=((String)bl_data.get("emp_code")).trim();
					if(str_emp_code == null) str_emp_code="";
					str_slmt_type_code=((String)bl_data.get("slmt_type_code")).trim();
					if(str_slmt_type_code == null) str_slmt_type_code="";
					str_non_ins_credit_doc_reqd_yn=((String)bl_data.get("non_ins_credit_doc_reqd_yn")).trim();
					if(str_non_ins_credit_doc_reqd_yn == null) str_non_ins_credit_doc_reqd_yn="";
					str_annual_income=((String)bl_data.get("annual_income")).trim();
					if (str_annual_income.equals("")) str_annual_income = "0";
					str_family_asset=((String)bl_data.get("family_asset")).trim();
					if (str_family_asset.equals("")) str_family_asset = "0";
					str_no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
					if (str_no_of_dependants.equals("")) str_no_of_dependants = "0";
					str_resp_for_payment=((String)bl_data.get("resp_for_payment")).trim();
					if(str_resp_for_payment == null) str_resp_for_payment="";
					str_pat_reln_with_resp_person=((String)bl_data.get("pat_reln_with_resp_person")).trim();
					if(str_pat_reln_with_resp_person == null) str_pat_reln_with_resp_person="";
					str_gl_holder_name=((String)bl_data.get("gl_holder_name")).trim();
					if(str_gl_holder_name == null) str_gl_holder_name="";
					str_pat_reln_with_gl_holder=((String)bl_data.get("pat_reln_with_gl_holder")).trim();
					if(str_pat_reln_with_gl_holder == null) str_pat_reln_with_gl_holder="";
					str_upd_patient_fin_dtls_yn=((String)bl_data.get("upd_patient_fin_dtls_yn")).trim();
					if(str_upd_patient_fin_dtls_yn == null) str_upd_patient_fin_dtls_yn="N";
					str_spl_clinic_rel_enc_YN =((String)bl_data.get("spl_clinic_rel_enc_YN")).trim();
					if(str_spl_clinic_rel_enc_YN == null) str_spl_clinic_rel_enc_YN="N";
					str_user_id=((String)bl_data.get("user_id")).trim();
					if(str_user_id == null) str_user_id="";
					ref_src_main_code=((String)bl_data.get("ref_src_main_code")).trim();
					if(ref_src_main_code==null || ref_src_main_code.equals("")) ref_src_main_code="";
					ref_src_main_desc=((String)bl_data.get("ref_src_main_desc")).trim();
					if(ref_src_main_desc==null || ref_src_main_desc.equals("")) ref_src_main_desc="";
					ref_src_sub_code=((String)bl_data.get("ref_src_sub_code")).trim();
					if(ref_src_sub_code==null || ref_src_sub_code.equals("")) ref_src_sub_code="";
					ref_src_sub_desc=((String)bl_data.get("ref_src_sub_desc")).trim();
					if(ref_src_sub_desc==null || ref_src_sub_desc.equals("")) ref_src_sub_desc="";

					cur_patient_id=((String)bl_data.get("cur_patient_id"));
					if(cur_patient_id==null || cur_patient_id.equals("")) cur_patient_id="";
					
					if(autoFinChk.equals("Y"))
					{
						fin_class_dtls_updated_YN=((String)bl_data.get("fin_class_dtls_updated_YN")).trim();
						if(fin_class_dtls_updated_YN==null || fin_class_dtls_updated_YN.equals("")) fin_class_dtls_updated_YN="N";
					}	
						
				
				}
				
				}
				else{
					

					billing_group=((String)bl_data.get("blng_grp")).trim();
					if(billing_group == null) billing_group="";
					str_slmt_ind=((String)bl_data.get("slmt_ind")).trim();
					if(str_slmt_ind == null) str_slmt_ind="";
					str_credit_doc_reqd_yn=((String)bl_data.get("credit_doc_reqd_yn")).trim();
					if(str_credit_doc_reqd_yn == null) str_credit_doc_reqd_yn="";
					str_blng_class=((String)bl_data.get("blng_class")).trim();
					if(str_blng_class == null) str_blng_class="";
					str_emp_code=((String)bl_data.get("emp_code")).trim();
					if(str_emp_code == null) str_emp_code="";
					str_slmt_type_code=((String)bl_data.get("slmt_type_code")).trim();
					if(str_slmt_type_code == null) str_slmt_type_code="";
					str_non_ins_credit_doc_reqd_yn=((String)bl_data.get("non_ins_credit_doc_reqd_yn")).trim();
					if(str_non_ins_credit_doc_reqd_yn == null) str_non_ins_credit_doc_reqd_yn="";
					str_annual_income=((String)bl_data.get("annual_income")).trim();
					if (str_annual_income.equals("")) str_annual_income = "0";
					str_family_asset=((String)bl_data.get("family_asset")).trim();
					if (str_family_asset.equals("")) str_family_asset = "0";
					str_no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
					if (str_no_of_dependants.equals("")) str_no_of_dependants = "0";
					str_resp_for_payment=((String)bl_data.get("resp_for_payment")).trim();
					if(str_resp_for_payment == null) str_resp_for_payment="";
					str_pat_reln_with_resp_person=((String)bl_data.get("pat_reln_with_resp_person")).trim();
					if(str_pat_reln_with_resp_person == null) str_pat_reln_with_resp_person="";
					str_gl_holder_name=((String)bl_data.get("gl_holder_name")).trim();
					if(str_gl_holder_name == null) str_gl_holder_name="";
					str_pat_reln_with_gl_holder=((String)bl_data.get("pat_reln_with_gl_holder")).trim();
					if(str_pat_reln_with_gl_holder == null) str_pat_reln_with_gl_holder="";
					str_upd_patient_fin_dtls_yn=((String)bl_data.get("upd_patient_fin_dtls_yn")).trim();
					if(str_upd_patient_fin_dtls_yn == null) str_upd_patient_fin_dtls_yn="N";
					str_spl_clinic_rel_enc_YN =((String)bl_data.get("spl_clinic_rel_enc_YN")).trim();
					if(str_spl_clinic_rel_enc_YN == null) str_spl_clinic_rel_enc_YN="N";
					str_user_id=((String)bl_data.get("user_id")).trim();
					if(str_user_id == null) str_user_id="";
					ref_src_main_code=((String)bl_data.get("ref_src_main_code")).trim();
					if(ref_src_main_code==null || ref_src_main_code.equals("")) ref_src_main_code="";
					ref_src_main_desc=((String)bl_data.get("ref_src_main_desc")).trim();
					if(ref_src_main_desc==null || ref_src_main_desc.equals("")) ref_src_main_desc="";
					ref_src_sub_code=((String)bl_data.get("ref_src_sub_code")).trim();
					if(ref_src_sub_code==null || ref_src_sub_code.equals("")) ref_src_sub_code="";
					ref_src_sub_desc=((String)bl_data.get("ref_src_sub_desc")).trim();
					if(ref_src_sub_desc==null || ref_src_sub_desc.equals("")) ref_src_sub_desc="";

					cur_patient_id=((String)bl_data.get("cur_patient_id"));
					if(cur_patient_id==null || cur_patient_id.equals("")) cur_patient_id="";
					
					if(autoFinChk.equals("Y"))
					{
						fin_class_dtls_updated_YN=((String)bl_data.get("fin_class_dtls_updated_YN")).trim();
						if(fin_class_dtls_updated_YN==null || fin_class_dtls_updated_YN.equals("")) fin_class_dtls_updated_YN="N";
					}
				}
			}
		}
		else
		{
			billing_group=request.getParameter("billing_group");
	
		}



		if(callingModule.equals("IP") && callingFunction.equals("ADMISSION") && quickAdmission.equalsIgnoreCase("Y")){			
				
				/*	Boolean allowQuickAdmission=true;
					HashMap existingFinDtls=(HashMap)session.getAttribute("financial_details");
					if(existingFinDtls!=null){
					String existingBlngGrp=(String)existingFinDtls.get("blng_grp");
						if(existingBlngGrp==null || existingBlngGrp.equals("")){
						allowQuickAdmission=true;
						}	
						else 	allowQuickAdmission=false;

					}
					
					System.err.println("fin_dtls loaded:"+existingFinDtls);
					System.err.println("allowQuickAdmission flag:"+allowQuickAdmission);
								if(allowQuickAdmission){
					*/


			pstmt = con.prepareStatement( "SELECT DFLT_QUICK_ADM_BLNG_GRP_ID FROM  BL_MP_PARAM");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				billing_group = rscurr.getString(1)!= null ? rscurr.getString(1) : "";
			}	
			
			
			}

			if(billing_group == null) billing_group="";
		
		System.err.println("KKKK billing_group  after1 ->"+billing_group);
		
		if(autoFinChk.equals("Y")&&!quickAdmission.equalsIgnoreCase("Y"))
		{
			billing_group = class_blng_grp_id;
		}
		System.err.println("KKKK billing_group  after2 ->"+billing_group);
		System.err.println("KKKK autoFinChk  ->"+autoFinChk);

		String clinic_code_check="";
		String visit_type_code_check="";
		String patient_id_check="";
		String pract_id_check="";
		String billing_reset_flag="";
		String pat_ser_code_check="";

		String strBlngClass ="";
		String strBillType ="";
		String mbilling_group="",mbilling_class="",memployer_code="",package_flag="";
		String ins_auth_flag="",upd_pat_flag="",pkg_bill_type = "",	pkg_bill_no = "";
		String clinic_code ="",visit_type_code="",display="N",display_mode="",show_hide_blng_class="";
		String strEpisodeType = ""; //request.getParameter("episode_type");  
		String strNewEpisodeYN = request.getParameter("episode");  
		String strMessageId = "";
		String strErrorText = "";
		String strSysMessageId="";

		String strHcardSchemeId="";
		String strHcareSchemeId="";
		String strHcardExpiredYN="";
		String strHcareExpiredYN="";
		String strHcardApplicableYN="";
		String strHcareApplicableYN="";
		String strPatBlngGrp="";
		String strMessageDesc="";

		String strPreviousBlngGrp ="";
		String strPreviousBlngGrpDesc="";
		String strHcardPrerequisite_yn="";
		String strSchemeType="";

		String strIPBillingService="";
		String strBedNo="";
		String strDeptCode = "";

		String strdfltbgyn = "N";
		String srtencdfltbgyn="N";
		String strprovselfrmprevencyn="N";
		int prev_enc_check_count=0;
//		int op_ae_prev_enc_check_count=0;
//		int ip_dc_prev_enc_check_count=0;

		String bl_future_admn_YN="";

		String third_party_gl_in_use_yn = "N"; //muthu
		String third_party_gl_mandatory_yn = "N"; //muthu
		String capture_employer_id_yn = "N";

		String strSplSchemeBlngGrpPresent = "0";
		String strBlngGrpAppYN= "Y";

		String strBlngGrpCatgAppYN = "Y";

		String strBlngGrpStatus="";

		String strCategory = "";

		String strPractitionerId = "";
		String strPractitionerTypeInd = "";

		String ref_id = request.getParameter("financial_detail_ref_id");
		if (ref_id == null ) ref_id = "";

		String org_type_ind = request.getParameter("org_type_ind");
		if (org_type_ind == null ) org_type_ind = "";	

		String str_blng_grp_id = "",str_payer_emp_id_mand_yn="N", str_is_blng_grp_pkg_link_YN="N", str_valid_pkg_for_pat_avail_YN="N", str_valid_pkg_for_pat_bg_avail_YN="N";
		String str_short_desc = "";	
		String str_currency_code_for_bg = "",str_currency_desc_for_bg="";


		strPractitionerId = request.getParameter("practitioner_id");
		strPractitionerTypeInd = request.getParameter("practitioner_type_ind");

		if (strPractitionerId == null || strPractitionerId.equals("")) strPractitionerId = "";	
		if (strPractitionerTypeInd == null || strPractitionerTypeInd.equals("")) strPractitionerTypeInd = "";	

		boolean boolPatientFoundMP = false;
		//unused variable, commented on 09/06/05
		//boolean boolBillingGroupFound = false;
		boolean boolSecurity = false;	

		if (strLoggedUser == null) strLoggedUser="";
		if (strNewEpisodeYN==null) strNewEpisodeYN="";
		
		if (strEpisodeType == null) strEpisodeType ="";

			//The following parameters are used to retrieve the values from 
			//Added by Murugavel. on 11/Aug/2002
			// Health Card Expired Y 0r N logic also added 
			//	But the previous window not passing the parameter health_card_expired_yn
			
		String strHealthCardExpired_YN = request.getParameter("health_card_expired_yn");  
		String 	strBLInterfacedYN = "";
		strBedNo = request.getParameter("bed_no");  
		if (strBedNo == null) strBedNo ="";

		if (strBLInterfacedYN == null) strBLInterfacedYN ="N";

		if (strHealthCardExpired_YN == null) strHealthCardExpired_YN="N";

		String strAnnualIncome =  str_annual_income;   

		if (strAnnualIncome == null) strAnnualIncome = "";
		if (strAnnualIncome.equals("0.00")) strAnnualIncome = "";
		if (strAnnualIncome.equals("0")) strAnnualIncome = "";
		try
		{
			CurrencyFormat cf1 = new CurrencyFormat();
		
			if (!(strAnnualIncome.equals("")))
				strAnnualIncome = cf1.formatCurrency(strAnnualIncome,noofdecimal);
		}
		catch(Exception e)
		{
			System.out.println("Currency exception1 ::"+e);
		}

	//	String strFamilyAsset	= request.getParameter("family_asset");	
		String strFamilyAsset	= str_family_asset;	
		if (strFamilyAsset == null) strFamilyAsset="";
		if (strFamilyAsset.equals("0.00")) strFamilyAsset = "";
		if (strFamilyAsset.equals("0")) strFamilyAsset = "";

		try
		{
			CurrencyFormat cf1 = new CurrencyFormat();
		
			if (!(strFamilyAsset.equals("")))
				strFamilyAsset = cf1.formatCurrency(strFamilyAsset,noofdecimal);
		}
		catch(Exception e)
		{
			System.out.println("Currency exception2 ::"+e);
		}

	//	String strNoDependants = request.getParameter("no_of_dependants"); 
		String strNoDependants = str_no_of_dependants; 
			if (strNoDependants == null) strNoDependants = "";
			if (strNoDependants.equals("0")) strNoDependants = "";


	//	String strRespForPayment = request.getParameter("resp_for_payment"); 
		String strRespForPayment = str_resp_for_payment;	

		if (strRespForPayment == null) strRespForPayment = "";

		// Added on 12/09/2006
	//	String strPatRelnWithRespPerson = request.getParameter("pat_reln_with_resp_person"); 
		String strPatRelnWithRespPerson = str_pat_reln_with_resp_person; 
			if (strPatRelnWithRespPerson == null || strPatRelnWithRespPerson.equals("undefined")) strPatRelnWithRespPerson = "";	
			
		// Added on 09/11/2003 

	//	String strGlHolderName = request.getParameter("gl_holder_name"); 
		String strGlHolderName = str_gl_holder_name; 
			if (strGlHolderName == null || strGlHolderName.equals("undefined")) strGlHolderName = "";

	//	String strGlHolderReln = request.getParameter("pat_reln_with_gl_holder"); 
		String strGlHolderReln = str_pat_reln_with_gl_holder; 
			if (strGlHolderReln == null || strGlHolderReln.equals("undefined")) strGlHolderReln = "";	

//Added by Manivel on 05/06/07 
		String strRefSrcMainCode=ref_src_main_code;
			if(strRefSrcMainCode==null) strRefSrcMainCode="";

		String strRefSrcSubCode=ref_src_sub_code;
			if(strRefSrcSubCode==null) strRefSrcSubCode="";

		String strRefSrcMainDesc=ref_src_main_desc;
			if(strRefSrcMainDesc==null) strRefSrcMainDesc="";

		String strRefSrcSubDesc=ref_src_sub_desc;
			if(strRefSrcSubDesc==null) strRefSrcSubDesc="";
/******* Over *****/

		// Added End

		//Added on 23/10/2004
		String strCreditStartDate = request.getParameter("cred_start_date"); 
			if (strCreditStartDate == null) strCreditStartDate = "";	

		//Added End


	//	String strCreditDocReqd_YN1 = request.getParameter("credit_doc_reqd_yn1");
		String strCreditDocReqd_YN1 = str_credit_doc_reqd_yn;
			if (strCreditDocReqd_YN1 == null) strCreditDocReqd_YN1 = "";

			
	//	String strCreditDocReqd_YN2 = request.getParameter("credit_doc_reqd_yn2");
		String strCreditDocReqd_YN2 = str_non_ins_credit_doc_reqd_yn;
			if ( strCreditDocReqd_YN2 == null ) strCreditDocReqd_YN2 = "";
		
		String patient_id = request.getParameter("patient_id");
		if(patient_id == null) patient_id = "";

		/** 
			The following variables are for the billing group or any items
			which are imported from the external interface
		**/
			
		String strExtBillingGroup = "";
		String strExtSettlType = "";
		
		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strDataSourceId =  request.getParameter("data_source_id");
		String strItemsDisabled = request.getParameter("items_disabled");
		String bl_oper_yn = request.getParameter("bl_oper_yn");

		String strBillingOverride = "Y";

		String strBedClass = "";
		/************** changed the below code block location for package billing*********start***************/	

		//unused variable, commented on 09/06/05
		//String strBedType ="";
		/************** added for package billing*********start***************/		
		String strBedType ="";

		if(rs3!=null) rs3.close();
		if(pstmt!=null) pstmt.close();

/* Commented and moved the value fetch to the top
		try
		{
			pstmt = con.prepareStatement("SELECT bl_package_enabled_yn(?)  package_enabled_yn from dual");
			pstmt.setString(1,facility_id);
			rs3 = pstmt.executeQuery();
			if( rs3 != null  && rs3.next()) 
			{
					package_enabled_yn = rs3.getString("package_enabled_yn");		
					
					if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";						
			}
			if (rs3 != null) rs3.close();
			pstmt.close();		
		}
		catch(Exception e)
		{
			System.out.println("Exception  while geting package_enabled_yn from bl_parameters:"+e);
			e.printStackTrace();
		}
*/		
		if(package_enabled_yn.equals("Y"))
				 strBedType = request.getParameter("bed_type")==null?"":request.getParameter("bed_type");       
				 //System.out.println("strBedType="+strBedType);
		/************** added for package billing*********end***************/
		String strAdmissionType = "";
		String strNursingUnit ="";
		//String strNursingUnitType ="";
		//String strDepReqYN="";
		//String strAddlDepReqYN="";

		String strCitizenYn = "N";
		String nationalityyn = "";
		String care_locn_type_ind="N";
		String alt_id1_exp_date = "";
		
		if(!patient_id.equals(""))
		{
			try
			{
				String sqlCiti = "select a.citizen_yn,to_char(a.alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date, b.gl_holder_name gl_holder_name, b.pat_reln_with_gl_holder pat_reln_with_gl_holder from mp_patient a, bl_patient_fin_dtls b where a.patient_id ='"+patient_id+"' and a.patient_id=b.patient_id";
				pstmt = con.prepareStatement(sqlCiti);
				rs2 = pstmt.executeQuery() ;
				if( rs2 != null ) 
				{	
					while( rs2.next() )
					{  
						strCitizenYn = rs2.getString("citizen_yn");
						alt_id1_exp_date = rs2.getString("alt_id1_exp_date");
						gl_holder_name = rs2.getString("gl_holder_name");
						gl_rel = rs2.getString("pat_reln_with_gl_holder");
						boolPatientFoundMP = true;
					}
				}
				if (rs2 != null) rs2.close();
				pstmt.close();	
			}
			catch(Exception e)
			{
				System.out.println("Exception in sqlCiti:"+e);
			}
			if(strCitizenYn == null) strCitizenYn="N";
			if (alt_id1_exp_date == null) alt_id1_exp_date = "";
			if ( gl_holder_name == null ) gl_holder_name = "";
			if ( gl_rel == null ) gl_rel = "";
/* commented and added with the above query for PE Changes
			try
			{
				String sql1 = "select gl_holder_name, pat_reln_with_gl_holder from bl_patient_fin_dtls where patient_id = '"+patient_id+"'";
				pstmt = con.prepareStatement(sql1);
				rs0 = pstmt.executeQuery() ;
				if( rs0 != null ) 
				{
					while( rs0.next() )
					{  
						gl_holder_name = rs0.getString("gl_holder_name");
						gl_rel = rs0.getString("pat_reln_with_gl_holder");				
					}
				}
				if(rs0!=null) rs0.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception in sql1:"+e);
			}		
			if ( gl_holder_name == null ) gl_holder_name = "";
			if ( gl_rel == null ) gl_rel = "";
*/
		}

		boolean boolChangeBillQry = false;
		/******* End of the External Interface table data **************/

		if (strRepositoryYN == null ) 
		{
			strRepositoryYN = "";
		}
		if (strDataSourceId == null )
		{
			strDataSourceId = "";
		}
		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}

		strBedClass = request.getParameter("bed_class_code");      
		strAdmissionType = request.getParameter("visit_adm_type");     
		strNursingUnit = request.getParameter("nursing_unit_code");        

/* Commented for PE Changes and Added in the Main.jsp
		try
		{
			String sql2 = "select nvl(third_party_gl_in_use_yn,'N') third_party_gl_in_use_yn, nvl(third_party_gl_mandatory_yn,'N') third_party_gl_mandatory_yn, NVL(capture_employer_id_yn,'N') capture_employer_id_yn from bl_parameters where operating_facility_id = '"+facility_id +"'";
		
			pstmt = con.prepareStatement(sql2);
			rs3 = pstmt.executeQuery() ;
			if( rs3 != null ) 
			{
				while( rs3.next() )
				{  
					third_party_gl_in_use_yn = rs3.getString("third_party_gl_in_use_yn");
					third_party_gl_mandatory_yn = rs3.getString("third_party_gl_mandatory_yn");
					capture_employer_id_yn = rs3.getString("capture_employer_id_yn");
				}
			}
			if (rs3 != null) rs3.close();
			pstmt.close();		
		}
		catch(Exception e)
		{
			System.out.println("Exception in sql2:"+e);
		}
*/
		third_party_gl_in_use_yn = request.getParameter("third_party_gl_in_use_yn");
		if(third_party_gl_in_use_yn == null) third_party_gl_in_use_yn="N";

		third_party_gl_mandatory_yn = request.getParameter("third_party_gl_mandatory_yn");
		if(third_party_gl_mandatory_yn == null) third_party_gl_mandatory_yn="N";

		capture_employer_id_yn = request.getParameter("capture_employer_id_yn");
		if(capture_employer_id_yn == null) capture_employer_id_yn="N";

		if (strBedClass == null) strBedClass = "";
		if (strAdmissionType == null) strAdmissionType = "";
		if (strNursingUnit == null) strNursingUnit = "";

		if (strRepositoryYN.equals("Y"))
		{
	//		strExtBillingGroup =  request.getParameter("billing_group");
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
				strExtBillingGroup =  billing_group;
			}
			else
			{
				strExtBillingGroup=billing_group;
			}
		//		strExtSettlType = request.getParameter("cash_set_type1");
				strExtSettlType = str_slmt_type_code;

			try
			{
				StringTokenizer strTokenizer = new StringTokenizer(strItemsDisabled,"|");
				String strTotData = "";
				
				int intIdx = 0;
				String strColumn="";
				String strOverride ="N";
				while(strTokenizer.hasMoreElements())
				{	
					strTotData = strTokenizer.nextToken();
						
					intIdx = strTotData.indexOf("-");
					strColumn = strTotData.substring(0,intIdx);
					strOverride = strTotData.substring(intIdx+1);

					if (strColumn.equals("billing_group")) 
					{
						if (strOverride.equals("N"))
						{
							strBillingOverride = "N";
						}
						else 
						{
							strBillingOverride = "Y";
						}
					}
				}
			}
			catch(Exception excep)
			{
				out.println("Exception 3::"+excep);
			}
		}
		if (strExtBillingGroup == null) 
		{
			strExtBillingGroup = "";
			
		}
		if (strExtSettlType == null)
		{
			strExtSettlType="";
		}
/* Commented and moved up for PE Changes
		//Added for Health Card Expiry date check	
		String alt_id1_exp_date = "";
		try
		{
			pstmt = con.prepareStatement("select to_char(alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date from mp_patient where patient_id = ?");
			pstmt.setString(1, patient_id);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				alt_id1_exp_date = rs.getString("alt_id1_exp_date");
				if (alt_id1_exp_date == null) alt_id1_exp_date = "";
				boolPatientFoundMP = true;
			}
			if (rs != null) rs.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in alt_id1_exp_date:"+e);
		}
*/
		// End of Addition

		// If the strRepositoryYN = 'Y' then get the items to be disabled
		
		String strDfltBillingGroup = "";
		//String strDfltBillingGroupDesc = "";
		//String query_string=request.getQueryString();
		//String strDefHealthCard_YN = "N";        
		String strArrayHealthCard_YN="";
		String strArrayBillingApp_YN="";	
	//	String user_id = request.getParameter("user_id");
		String user_id = str_user_id;
		String strBillingQuery ="";
		String strblnggrp ="0";
		String strModuleId = "";
		String strFunctionId = "";
		String strChngToVisit = request.getParameter("Chg_to_Visitor_Grp");
		String strSpecialSchemeBlngGrp="";		// 
		String strSpecialSchemeBlngGrpDesc="";		
		String priority="N";
		String strBillGrpId = "";

		if  (strChngToVisit  == null )
		{
			strChngToVisit = "N";
		}

		if(user_id==null) user_id = "";

		
		package_flag = request.getParameter("package_flag");
		if(package_flag==null) package_flag = "N";
		ins_auth_flag = request.getParameter("ins_auth_flag");
		if(ins_auth_flag==null) ins_auth_flag = "N";
		upd_pat_flag=request.getParameter("upd_pat_flag");
		if(upd_pat_flag==null) upd_pat_flag="N";
		String episode = request.getParameter("episode");
		if(episode==null) episode = "";
		String record = request.getParameter("record");
		if(record==null) record = "";

		pkg_bill_type = request.getParameter("pkg_bill_type");
		if(pkg_bill_type==null) pkg_bill_type="";
		pkg_bill_no = request.getParameter("pkg_bill_no");
		if(pkg_bill_no==null) pkg_bill_no="";

		clinic_code = request.getParameter("clinic_code");
		if(clinic_code==null) clinic_code="";
		visit_type_code = request.getParameter("visit_type_code");
		if(visit_type_code==null) visit_type_code="";
		
		display = request.getParameter("display");
		
		if(display==null||display.equals("null")) display="N";

		if(display.equals("Y"))
		{
			display_mode="disabled";
		}

		show_hide_blng_class=request.getParameter("show_hide_blng_class");

		if(show_hide_blng_class==null) show_hide_blng_class="SHOW";

		strModuleId = request.getParameter("calling_module_id");	
	
		strFunctionId = request.getParameter("calling_function_id");

		if (strModuleId == null) strModuleId= "";
		if (strFunctionId == null) strFunctionId = "";

		strdfltbgyn = request.getParameter("dfltbgyn");
		if ( strdfltbgyn == null) strdfltbgyn = "N";

		srtencdfltbgyn = request.getParameter("encdfltbgyn");
		if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";

		strprovselfrmprevencyn = request.getParameter("provselfrmprevencyn");
		if ( strprovselfrmprevencyn == null) strprovselfrmprevencyn = "N";
/*
		try
		{
			String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg,nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N') last_enc_bg,nvl(PROV_TO_SEL_FROM_PRV_ENCTRS_YN,'N') prov_sel_frm_prev_enc from bl_mp_param ";
			pstmt = con.prepareStatement(sql0);
			rs2 = pstmt.executeQuery() ;
				if( rs2 != null ) 
				{
					while( rs2.next() )
					{  
						strdfltbgyn = rs2.getString("bg");
						srtencdfltbgyn=rs2.getString("last_enc_bg");
						strprovselfrmprevencyn=rs2.getString("prov_sel_frm_prev_enc");
					}
				}
				if (rs2 != null) rs2.close();
				pstmt.close();

		}
		catch(Exception e)
		{
			System.out.println("Exception in sqlCiti:"+e);
		}			
*/
		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}

		bl_future_admn_YN= request.getParameter("bl_future_admn_YN");
		if(bl_future_admn_YN==null) bl_future_admn_YN="N";

		if(bl_future_admn_YN.equals("Y") && ((strModuleId.equals("IP") || strModuleId.equals("DC")) && strFunctionId.equals("ADMISSION")))
		{
//			System.out.println("Inside the Future Admn Check");
			strdfltbgyn="Y";
		}
		// Added on 16/08/2005

		nationalityyn = request.getParameter("nationality_yn");

		if (nationalityyn == null) nationalityyn = "";	

		if (strModuleId.equals("MP"))
		{
			strCitizenYn = nationalityyn;
			strdfltbgyn = "Y";
		}


		// Added New on 25/12/2003

		if ( strdfltbgyn.equals("N") && (!(strModuleId.equals("MP")) ) )
			{
			strGlHolderName = "";
			strNoDependants = "";
			strGlHolderReln = "";
			}

		// End New on 25/12/2003

		try
		{			
	//		mbilling_group=request.getParameter("billing_group");
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
				mbilling_group=billing_group;
			}
			else
			{
				mbilling_group=billing_group;
			}

			priority=request.getParameter("priority");
			if((priority==null) || (priority.equals("null")))
				priority ="N";
			care_locn_type_ind = 	request.getParameter("care_locn_type_ind");

			if((care_locn_type_ind==null) || (care_locn_type_ind.equals("null")))
				care_locn_type_ind ="N";
	//		mbilling_class=request.getParameter("billing_class");
			mbilling_class=str_blng_class;
	//		memployer_code=request.getParameter("employer_code");
			memployer_code=str_emp_code;
			if (mbilling_group == null)
			{
				mbilling_group="";
			}
			if (mbilling_class == null)
			{
				mbilling_class="";
			}

			if (memployer_code == null)
			{
				memployer_code="";
			}
			
			String getDfltEncBg = (String) session.getAttribute("blGetDfltEncBg");
			String getDfltEncCC = (String) session.getAttribute("blGetDfltEncCC");
			String comClinincCode = clinic_code;
			if("".equals(comClinincCode)){
				comClinincCode = strNursingUnit;
			}
			if(getDfltEncCC == null)	getDfltEncCC = "";
			
			if("DC".equals(callingModule)){
				care_locn_type_ind = "D";
			}
			
			try
			{	
				if("Y".equals(getDfltEncBg) || comClinincCode.equals(getDfltEncCC) == false){
					String query="select BL_eBLCOMMON.BL_GET_ENCNTR_DEFAULT_BG(?,?,?,?,?) from dual";		
					pstmt = con.prepareStatement(query);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,care_locn_type_ind);
					pstmt.setString(3,comClinincCode);
					pstmt.setString(4,priority);
					pstmt.setString(5,strCitizenYn);
					rset = pstmt.executeQuery();

					if(rset!=null && rset.next())
					 {
						strBillGrpId = rset.getString(1);  
					 }
					
					if ( strBillGrpId == null ){
						strBillGrpId = "";
					}
					else{
						boolChangeBillQry = true;
						billing_group = strBillGrpId;
						mbilling_group = strBillGrpId;
						/*HashMap bl_data=(HashMap)session.getAttribute("financial_details");
						
						bl_data.put("blng_grp",billing_group);						
						
						session.setAttribute("financial_details",bl_data);			*/								
					}
					if(rset !=null) rset.close();
					pstmt.close();	
					
					session.setAttribute("blGetDfltEncBg", "Y");
					session.setAttribute("blGetDfltEncCC", comClinincCode);
				}
												
			}
			catch(Exception e)
			{
				System.out.println("Exception happened in BL_GET_ENCNTR_DEFAULT_BG :"+e);
			}
		}
		catch(Exception exParm)
		{
			System.out.println("Exception with Modify Mode Block:"+exParm);
		}

		try
		{
			if (!(strModuleId.equalsIgnoreCase("MP"))	)
			{
				String strBLIntQuery = "";
			
				if (strModuleId.equalsIgnoreCase("IP") || strModuleId.equalsIgnoreCase("DC") )
				{
					strBLIntQuery = "select nvl(bl_interfaced_yn,'N') from ip_param where facility_id =?";
				}
				else if ( strModuleId.equalsIgnoreCase("OP") )
				{
					strBLIntQuery = "select nvl(bl_interfaced_yn,'N') from op_param where operating_facility_id =?";
				}
				else if ( strModuleId.equalsIgnoreCase("AE") )
				{
					strBLIntQuery = "select nvl(billing_interfaced_yn,'N') from ae_param where operating_facility_id =?";
				}

				pstmt = con.prepareStatement(strBLIntQuery );
				pstmt.setString(1, facility_id);
				rs = pstmt.executeQuery();
			
				if (rs.next())
				{
					strBLInterfacedYN = rs.getString(1);
				}
				else
				{
					strBLInterfacedYN = "N";
				}
				if (rs != null) rs.close();
				pstmt.close();
			}
			
		}
		catch(Exception exBl)
		{
			System.out.println("Exception in MP check logic:"+exBl);
		}
		
		if ((strModuleId.equals("OP"))|| (strModuleId.equals("AE")))
		{
			try
			{
				pstmt = con.prepareStatement("select bill_type_code , blng_class_code from bl_op_clinic where "+" facility_id =? and clinic_code =? and rownum=1");
				pstmt.setString(1, facility_id);
				pstmt.setString(2, clinic_code);

				rs = pstmt.executeQuery();
				if (rs.next())
				{
					strBlngClass = rs.getString(1);
					strBillType = rs.getString(2);
				}
				if (rs != null) rs.close();
				pstmt.close();
				
				if (strBlngClass == null) strBlngClass="";
				if (strBillType == null) strBillType="";
			}
			catch(Exception e)
			{
				System.out.println("Exception in OP AE check logic:"+e);
			}
		}
	// HealthSchemes
		if (!(strModuleId.equals("MP")))
		{
			try
			{
				CallableStatement call = con.prepareCall("{ call blcommon.GET_HEALTH_SCHEME_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");						
				call.setString(1,patient_id);
				call.setString(2,facility_id);
				call.setString(3,locale);
				call.registerOutParameter(4,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
				call.registerOutParameter(5,java.sql.Types.VARCHAR); // _hcare_scheme_id out varchar2,
				call.registerOutParameter(6,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
				call.registerOutParameter(7,java.sql.Types.VARCHAR); // _hcare_scheme_id out varchar2,
				call.registerOutParameter(8,java.sql.Types.VARCHAR); // p_hcard_expired_yn out varchar2,
				call.registerOutParameter(9,java.sql.Types.VARCHAR); // p_hcare_expired_yn out varchar2,
				call.registerOutParameter(10,java.sql.Types.VARCHAR); // p_dflt_blng_grp_for_hc out varchar2,
				call.registerOutParameter(11,java.sql.Types.VARCHAR); // p_dflt_blng_grp_for_hc_desc out varchar2,
				call.registerOutParameter(12,java.sql.Types.VARCHAR); // p_previous_blng_grp out varchar2,
				call.registerOutParameter(13,java.sql.Types.VARCHAR); // p_previous_blng_grp_desc out varchar2, 
				call.registerOutParameter(14,java.sql.Types.VARCHAR); // p_hcard_prerequisite_yn out varchar2,
				call.registerOutParameter(15,java.sql.Types.VARCHAR); // error text			call.execute();
				call.registerOutParameter(16,java.sql.Types.VARCHAR); // error text			call.execute();
				call.registerOutParameter(17,java.sql.Types.VARCHAR); // error text			call.execute();
				call.registerOutParameter(18,java.sql.Types.VARCHAR); // error text			call.execute();
				call.registerOutParameter(19,java.sql.Types.VARCHAR); // error text			call.execute();

				call.registerOutParameter(20,java.sql.Types.VARCHAR); // error text			call.execute();

				call.execute();

				strPatBlngGrp = call.getString(4);		// _hcard_scheme_id out varchar2,            
				strMessageDesc=call.getString(5);		// _hcare_scheme_id out varchar2,            
				strHcardApplicableYN =call.getString(6);		// _hcard applicable out varchar2,            
				strHcareApplicableYN =call.getString(7);		// _hcard applicable out varchar2,            
				strHcardSchemeId=call.getString(8);		// _hcard_scheme_id out varchar2,            
				strHcareSchemeId=call.getString(9);		// _hcare_scheme_id out varchar2,            
				strHcardExpiredYN=call.getString(10);	// p_hcard_expired_yn out varchar2,          
				strHcareExpiredYN=call.getString(11);	// p_hcare_expired_yn out varchar2,          
				strDfltBillingGroup = call.getString(12);			// p_dflt_blng_grp_for_hc out varchar2,     
				//strDfltBillingGroupDesc = call.getString(12);		// p_dflt_blng_grp_for_hc_desc out varchar2,
				strPreviousBlngGrp = call.getString(14);				// p_previous_blng_grp out varchar2,         
				strPreviousBlngGrpDesc= call.getString(15);			// p_previous_blng_grp_desc out varchar2,    
				strHcardPrerequisite_yn= call.getString(16)	;		// p_hcard_prerequisite_yn out varchar2,     
				strSpecialSchemeBlngGrp=call.getString(17);		// _hcard_scheme_id out varchar2,            
				strSpecialSchemeBlngGrpDesc=call.getString(18);		// _hcare_scheme_id out varchar2,            
				strSchemeType = 	call.getString(19);					 // error text			call.execute();      
				strErrorText = 	call.getString(20);					 // error text			call.execute();      
				
				if ((strHcardSchemeId == null) || ( strHcardSchemeId.equals("")) || ( strHcardSchemeId.equalsIgnoreCase("null")) )
				{ 
					strHcardSchemeId="";
				}

				if ((strHcareSchemeId == null) || ( strHcareSchemeId.equals("")) || ( strHcareSchemeId.equalsIgnoreCase("null")) )
				{ 
					strHcareSchemeId="";
				}

				if ((strHcardExpiredYN == null) || ( strHcardExpiredYN.equals("")) || ( strHcardExpiredYN.equalsIgnoreCase("null")) )
				{ 
					strHcardExpiredYN="";
				}

				if ((strHcareExpiredYN == null) || ( strHcareExpiredYN.equals("")) || ( strHcareExpiredYN.equalsIgnoreCase("null")) )
				{ 
					strHcareExpiredYN="";
				}

				if ((strDfltBillingGroup == null) || ( strDfltBillingGroup.equals("")) || ( strDfltBillingGroup.equalsIgnoreCase("null")) )
				{ 
					//unused variable, commented on 09/06/05
					//strDfltBillingGroupDesc="";
				}

				if ((strPreviousBlngGrp  == null) || ( strPreviousBlngGrp.equals("")) || ( strPreviousBlngGrp.equalsIgnoreCase("null")) )
				{ 
					strPreviousBlngGrp ="";
					strPreviousBlngGrpDesc="";

				}

				if ((strHcardPrerequisite_yn == null) || ( strHcardPrerequisite_yn.equals("")) || ( strHcardPrerequisite_yn.equalsIgnoreCase("null")) )
				{ 
					strHcardPrerequisite_yn  ="";
				}

				if ((strHcardApplicableYN  == null) || ( strHcardApplicableYN.equals("")) || ( strHcardApplicableYN.equalsIgnoreCase("null")) )
				{ 
					strHcardApplicableYN ="";
				}

				if ((strHcareApplicableYN  == null) || ( strHcareApplicableYN.equals("")) || ( strHcareApplicableYN.equalsIgnoreCase("null")) )
				{ 
					strHcareApplicableYN ="";
				}

				if ((strSpecialSchemeBlngGrp== null) || ( strSpecialSchemeBlngGrp.equals("")) || ( strSpecialSchemeBlngGrp.equalsIgnoreCase("null")) )
				{ 
					strSpecialSchemeBlngGrp ="";
					strSpecialSchemeBlngGrpDesc="";
				}
				if ((strMessageDesc== null) || ( strMessageDesc.equals("")) || ( strMessageDesc.equalsIgnoreCase("null")) )
				{ 
					strMessageDesc ="";
				}

				call.close();
			}
			catch(Exception e)
			{
				out.println(" Err: HealthScheme Dtls: "+e);
			}
		}	// End of HealthSchemes details if

		if (strModuleId.equals("OP")||strModuleId.equals("AE"))
		{
			try
			{
				pstmt = con.prepareStatement("select bill_type_code , blng_class_code from bl_op_clinic where "+
							" facility_id =? and clinic_code =? and rownum=1");
				pstmt.setString(1, facility_id);
				pstmt.setString(2, clinic_code);

				rs = pstmt.executeQuery();
				if (rs.next())
				{
					strBlngClass = rs.getString(1);
					strBillType = rs.getString(2);
				}
				if (rs != null) rs.close();
				pstmt.close();
				
				if (strBlngClass == null) strBlngClass="";
				if (strBillType == null) strBillType="";
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in billing class & bill type query exec:"+e);
			}
		}	// End of OP Checking

		if (strModuleId.equals("IP") || strModuleId.equals("DC"))
		{
			try
			{
				CallableStatement call = con.prepareCall("{ call bl_ip_interface.proc_get_ip_billing_details(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");						
				call.setString(1,facility_id);
				call.setString(2,strNursingUnit);
				call.setString(3,strBedClass);
				call.setString(4,strAdmissionType);
				call.setString(5,strBedNo);
				call.registerOutParameter(6,java.sql.Types.VARCHAR); // Nursing Unit type
				call.registerOutParameter(7,java.sql.Types.VARCHAR); // billing class
				call.registerOutParameter(8,java.sql.Types.VARCHAR); // bill type
				call.registerOutParameter(9,java.sql.Types.VARCHAR); // Dep. Reqd
				call.registerOutParameter(10,java.sql.Types.VARCHAR); // Addl. Reqd
				call.registerOutParameter(11,java.sql.Types.VARCHAR);  //
				call.registerOutParameter(12,java.sql.Types.VARCHAR);	
				call.registerOutParameter(13,java.sql.Types.VARCHAR);
				call.registerOutParameter(14,java.sql.Types.VARCHAR);
				call.registerOutParameter(15,java.sql.Types.VARCHAR);
				call.registerOutParameter(16,java.sql.Types.VARCHAR);
				call.execute();
				 
				//unused variable, commented on 09/06/05 
				//strBedType = call.getString(6);
				//strNursingUnitType = call.getString(7);
				strBlngClass = call.getString(8);
				strBillType = call.getString(9);
				strIPBillingService = call.getString(10);
				//strDepReqYN = call.getString(11);
				//strAddlDepReqYN = call.getString(12);
				strDeptCode = call.getString(13);
				strMessageId = call.getString(14);
				strSysMessageId = call.getString(15);
				strErrorText = call.getString(16);

				if ((strMessageId == null) || (strMessageId.equals("null")))
				{
					strMessageId ="";
				}
				if ( (strDeptCode == null) ||  (strDeptCode.equalsIgnoreCase("null")) )
				{
					strDeptCode = "";
				}

				if ( (strBlngClass == null) ||  (strBlngClass.equalsIgnoreCase("null")) )
				{
					strBlngClass = "";
				}
				if ( (strIPBillingService== null) ||  (strIPBillingService.equalsIgnoreCase("null")) )
				{
					strIPBillingService = "";
				}
				if ( (strBillType == null) ||  (strBillType.equalsIgnoreCase("null")) )
				{
					strBillType  = "";
				}

				call.close();
			}
			catch(Exception e)
			{
				out.println("Error "+e);
			}

		}	// End of IP module checking
System.err.println("KKKK billing_group3:"+billing_group);
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			sql="select settlement_ind, adm_rec_flag, credit_doc_ref_reqd_yn  from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}
		else
		{
			sql="select settlement_ind, adm_rec_flag, credit_doc_ref_reqd_yn  from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				str_slmt_ind = rs.getString("settlement_ind");
				str_adm_rec_flag = rs.getString("adm_rec_flag");
				credit_doc_ref_reqd_yn = rs.getString("credit_doc_ref_reqd_yn");
			}
		}
		if (rs != null) rs.close();
		pstmt.close();
		
		if(str_slmt_ind==null) str_slmt_ind="";
		if(str_adm_rec_flag==null) str_adm_rec_flag="";
		if(credit_doc_ref_reqd_yn == null) credit_doc_ref_reqd_yn="";

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
	//		mbilling_group=request.getParameter("billing_group");
			mbilling_group=billing_group;
			priority=request.getParameter("priority");
			if((priority==null) || (priority.equals("null")))
				priority ="N";
			care_locn_type_ind = 	request.getParameter("care_locn_type_ind");
			if((care_locn_type_ind==null) || (care_locn_type_ind.equals("null")))
				care_locn_type_ind ="N";
	//		mbilling_class=request.getParameter("billing_class");
			mbilling_class=str_blng_class;
	//		memployer_code=request.getParameter("employer_code");
			memployer_code=str_emp_code;

			if (mbilling_group == null)
			{
				mbilling_group="";
			}
			if (mbilling_class == null)
			{
				mbilling_class="";
			}

			if (memployer_code == null)
			{
				memployer_code="";
			}
		}
		
		// This modification is done on :09/Sep/2002 for the Gap Identification 
		// the Requirements are Billing Groups filter critrea.
		// Fixing up of Bug for the Health Card Applicable (Enabling)

		//	if (strModuleId.equals("OP")||strModuleId.equals("AE"))  // Episode Type ENH
			
		if (strModuleId.equals("OP")) 
		{
			strEpisodeType = "O";
		}
		else if (strModuleId.equals("AE")) 
		{
			strEpisodeType = "E";
		}
		else if (strModuleId.equals("IP")) 
		{
			strEpisodeType = "I";
		}
		else if (strModuleId.equals("DC")) 
		{
			strEpisodeType = "D";
		}
		else if(strModuleId.equals("MP"))
		{
			strEpisodeType = "R";
		}

		try{
			
					String vst_adm_date_time="";
										
					if(strEpisodeType.equals("O")){
						vst_adm_date_time=request.getParameter("vst_regn_date_time"); 
					}else if(strEpisodeType.equals("I")||strEpisodeType.equals("D")){
						vst_adm_date_time=request.getParameter("encounter_date_time"); 
					}else if(strEpisodeType.equals("E")){
						vst_adm_date_time=sys_date;
					}else{
						vst_adm_date_time=request.getParameter("encounter_date_time");
					}
					
					System.err.println("facility_id/patient_id/strEpisodeType/vst_adm_date_time ::::"+facility_id+"/"+patient_id+"/"+strEpisodeType+"/"+vst_adm_date_time);
					pstmt = con.prepareStatement("SELECT blpackage.get_open_pkg_exists_yn(?,?,?,to_date(?,'dd/mm/yyyy HH24:MI:SS'))  open_pkg_exists_yn from dual");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,strEpisodeType);
					pstmt.setString(4,vst_adm_date_time);
					rs = pstmt.executeQuery();
					
					
					if( rs!= null && rs.next()) 
					 {
					  open_pkg_exists_yn = rs.getString(1);
					  if(open_pkg_exists_yn==null || !open_pkg_exists_yn.equals("Y")) open_pkg_exists_yn="N";						
					 }
					
					System.err.println("open_pkg_exists_yn "+open_pkg_exists_yn);
					  if (rs != null) rs.close();
					  pstmt.close();
				}
				catch(Exception e)
				{
					System.out.println("Exception in open subscribed package function"+e);
					e.printStackTrace();
				}
		if (strModuleId.equals("MP") && (boolPatientFoundMP == true))	
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+
							"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
								" REF_YN , status , category "+
								" FROM BL_BLNG_GRP_LANG_VW "+
								" WHERE "+
								" ( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+
								"  (((NVL(REF_YN,'N')='Y' AND NVL(HCARE_ONLY_YN,'N') = 'N' AND "+
								" nvl(status,'X' )!='S') "+
//								" OR BLNG_GRP_ID = '" + mbilling_group + "' )) and language_id='"+locale+"' order by 2";
								" AND BLNG_GRP_ID = '" + mbilling_group + "' )) and language_id='"+locale+"' order by 2";

			strblnggrp = "1";
		}

		if (strModuleId.equals("MP") && (boolPatientFoundMP == false))
		{
			strBillingQuery =" SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+
							"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" REF_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE "+
							" ( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+	
							" (((NVL(REF_YN,'N')='Y' AND NVL(REF_VALID_FOR_REGN_YN,'N')='Y' AND "+
							" nvl(status,'X' )!='S')  AND NVL(HCARE_ONLY_YN,'N') = 'N'  "+
//							" OR BLNG_GRP_ID = '" + mbilling_group + "' )) and language_id='"+locale+"' order by 2";	
							" AND BLNG_GRP_ID = '" + mbilling_group + "' )) and language_id='"+locale+"' order by 2";	

			strblnggrp = "2";
		}

		//if (strModuleId.equals("OP")||strModuleId.equals("AE"))

		if (strModuleId.equals("OP"))
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
								" OP_YN , status , category "+
								" FROM BL_BLNG_GRP_LANG_VW "+
								" WHERE "+
								" ((( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
								" ((NVL(OP_YN,'N')='Y' AND "+
								" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N')) "+
								" AND ( BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' )))  and language_id='"+locale+"' order by 2";
//								" OR ( BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' )))  and language_id='"+locale+"' order by 2";
//As per the new requirement the OR condtion changed to AND condition by Manivel on 07/05/07
			strblnggrp = "3";
		}
		
		//if (strModuleId.equals("IP") || strModuleId.equals("DC"))

		if (strModuleId.equals("IP"))
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" IP_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
								" WHERE " + 
								" ((( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
									" ((NVL(IP_YN,'N')='Y' AND "+
								" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N'))  "+
//								" OR (BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ) )) and language_id='"+locale+"' order by 2";
								" AND (BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ) )) and language_id='"+locale+"' order by 2";
			strblnggrp = "4";
		}

		if (strBillingQuery.equals("")) 
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+
							"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" REF_YN , status , category  FROM BL_BLNG_GRP_LANG_VW WHERE "+
								" ((( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
								" ( nvl(status,'X' )!='S'    AND ( NVL(HEALTH_CARD_APPL_YN,'N')= 'N' AND NVL(HCARE_ONLY_YN,'N')='N')  "+ 
								" OR BLNG_GRP_ID = '" + mbilling_group + "' ))) and language_id='"+locale+"' order by 2";
			
			strblnggrp = "5";
		}

		if (strRepositoryYN.equals("Y") && strBillingOverride.equals("N") && strModuleId.equals("MP") &&  (boolPatientFoundMP ==false) &&(!strExtBillingGroup.equals("")))
		{
			boolChangeBillQry =true;
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+
							"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							"  REF_YN , status , category  FROM BL_BLNG_GRP_LANG_VW WHERE "+
								" ( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+
								" (( nvl(status,'X' )!='S' "+ 
								" AND BLNG_GRP_ID = '" + strExtBillingGroup + "' )) and language_id='"+locale+"'";
			strblnggrp = "6";
		}

		if (strModuleId.equals("AE"))
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
								" AE_YN , status , category "+
								" FROM BL_BLNG_GRP_LANG_VW "+
								" WHERE " +
								" ((( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
								" ((NVL(AE_YN,'N')='Y' AND "+
								" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N')) "+
//								" OR ( BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ))) and language_id='"+locale+"' order by 2";
								" AND ( BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ))) and language_id='"+locale+"' order by 2";
			strblnggrp = "7";
		}

		if (strModuleId.equals("DC"))
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" DY_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
								" WHERE " + 
								" ((( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
								" ((NVL(DY_YN,'N')='Y' AND "+
								" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N'))  "+
//								" OR (BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ))) and language_id='"+locale+"' order by 2";
								" AND (BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ))) and language_id='"+locale+"' order by 2"; 
			strblnggrp = "8";
		}

		if (((strModuleId.equals("MP")) && (boolPatientFoundMP == true)) || ((strModuleId.equals("IP") || strModuleId.equals("DC") ||           strModuleId.equals("OP")||strModuleId.equals("AE")) && (boolPatientFoundMP == true)))
		{
			boolSecurity = true;
		}


            _bw.write(_wl_block8Bytes, _wl_block8);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
 
		/**** 
			This function is added by 
			Murugavel on 11/Aug/2002
			Reason		:Enhancements
			Script Function	:funHealthCardValue(obj)
			New Field 		:strHealthCard_YN variable, 
						:Check Box, Annual income(label+text field), 
						:Family Asset(label+text field),
						:No. of Dependants(label+text field), and the Responisible for the
						payment.(label+text field),
			Decoration		: Rearranged the position of the 
							Package required information to the second row		
							to optimize the space for the above fields.
					
			Form	table 
			Total Column	: 9					
			
		*******/
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strdfltbgyn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strblnggrp));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strExtBillingGroup));
            _bw.write(_wl_block14_0Bytes, _wl_block14_0);
            _bw.write(_wl_block14_1Bytes, _wl_block14_1);
            _bw.write(_wl_block14_2Bytes, _wl_block14_2);
            out.print( String.valueOf(strdfltbgyn));
            _bw.write(_wl_block15_0Bytes, _wl_block15_0);
            _bw.write(_wl_block15_1Bytes, _wl_block15_1);
            _bw.write(_wl_block15_2Bytes, _wl_block15_2);
            _bw.write(_wl_block15_3Bytes, _wl_block15_3);

		

		if(((operation.equals("Update")) || (display.equals("Y")) || 
		( boolSecurity == true) ) && (strModuleId.equals("MP") || (strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP")))) ) )
		{
			if(!("Y").equalsIgnoreCase(payerGrpBySetup))
			{
			

            _bw.write(_wl_block16Bytes, _wl_block16);

			}
			else
			{

            _bw.write(_wl_block17Bytes, _wl_block17);

			}
		}
		else if (strRepositoryYN.equals("Y") && strModuleId.equals("MP") )
		{


            _bw.write(_wl_block18Bytes, _wl_block18);
	
		}
		else if ((strdfltbgyn.equals("N")||strModuleId.equals("MP")) && (operation.equals("Update")))
		{		
			System.out.println("3");

            _bw.write(_wl_block19Bytes, _wl_block19);

		}
		else if (operation.equals("Insert") && !strBillGrpId.equals("") && !strModuleId.equals("MP"))
		{		
			System.out.println("4");

            _bw.write(_wl_block19Bytes, _wl_block19);

		}
		else
		{
			System.out.println("5");

            _bw.write(_wl_block20Bytes, _wl_block20);

		}

            _bw.write(_wl_block1Bytes, _wl_block1);

				/******
		try
		{

			pstmt = con.prepareStatement( " select  NVL(HEALTH_CARD_APPL_YN,'N')    from   bl_blng_grp x,bl_patient_fin_dtls y where x.BLNG_GRP_ID=y.BLNG_GRP_ID and PATIENT_ID='"+patient_id+"'" ) ;

			pstmt = con.prepareStatement( " select  NVL(HEALTH_CARD_APPL_YN,'N')    from   bl_blng_grp_vw x  where x.BLNG_GRP_ID='"+mbilling_group+"'" ) ;

			rs = pstmt.executeQuery() ;
			if( rs != null )
			{
				while( rs.next() ) 
				{
					strHealthCard_YN = rs.getString(1);
				}
			}
			pstmt.close() ;
		}
		catch(Exception sqlException)
		{
			out.println("Err :"+sqlException);
		}
					*****/
		/**************** 
			If the Health Card is Ex, then
			the Default Billing Group is taken
			Correction	: Murugavel.
			Reason  	: Additional Validation for the Health Card.
			Date		: 13/08/2002	


		if (strHealthCardExpired_YN.equals("Y") || (strHealthCard_YN.equals("Y") && alt_id1_exp_date.equals(""))) 
		{
			
			try
			{
				strQuery = " select DEF_BLNG_GRP_FOR_EXPIRED_HC,SHORT_DESC, "+ 
						"	nvl(HEALTH_CARD_APPL_YN,'N') "+        
						" from BL_PARAMETERS,bl_BLNG_GRP_vw "+
						" where BLNG_GRP_ID=DEF_BLNG_GRP_FOR_EXPIRED_HC and "+
						" operating_facility_id = '"+facility_id+"'";

				pstmt = con.prepareStatement(strQuery); 
				rs = pstmt.executeQuery() ;
				if( rs != null )
				{
					while( rs.next() ) 
					{						
						strDfltBillingGroup = rs.getString(1);
						strDfltBillingGroupDesc = rs.getString(2);
						strDefHealthCard_YN = rs.getString(3);
					}
				}
				pstmt.close() ;
			}
			catch(Exception sqlException)
			{
				out.println("Err :"+sqlException);
			}
		}

		************/		

		

            _bw.write(_wl_block21Bytes, _wl_block21);

//System.out.println("Checking the strBillingQuery:"+strBillingQuery);
		pstmt = con.prepareStatement( strBillingQuery ) ;
		rs = pstmt.executeQuery();
//System.out.println("Checking the exception:"+strBillingQuery);
		if( rs != null )
		{
			String blng_grp_id = strExtBillingGroup;
			String short_desc = strExtBillingGroup;	

			boolean boolRecordFound = false;
			while( rs.next() ) 
			{
				blng_grp_id = rs.getString( "blng_grp_id" ) ;
				short_desc = rs.getString( "short_desc" ) ;			


				if(blng_grp_id.equals(strBillGrpId))
				{
					str_blng_grp_id = rs.getString( "blng_grp_id" ) ;
					 str_short_desc = rs.getString( "short_desc" ) ;
				}
		
				strArrayHealthCard_YN = strArrayHealthCard_YN + (blng_grp_id+"-"+rs.getString(3)+"|");	
				strArrayBillingApp_YN = strArrayBillingApp_YN + rs.getString(4)+"|";	

				if (strSpecialSchemeBlngGrp.equals(blng_grp_id))
					strSplSchemeBlngGrpPresent = "1"; 

				if (mbilling_group.equals(blng_grp_id))		
				{
					strBlngGrpAppYN = rs.getString(4);
					strBlngGrpStatus = rs.getString("status");
					strCategory = rs.getString("category");
			
					if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
						strBlngGrpAppYN = "N";		
					if(strBlngGrpStatus == null ||strBlngGrpStatus.equals("null")) 
						strBlngGrpStatus="";
					if(strCategory == null ||strBlngGrpAppYN.equals("null") || strCategory.equals("")) 
						strCategory="UNRESTRICTED";					
//					strCategory="";

					if (strCitizenYn.equals("Y"))
					{
						if (strCategory.equals("UNRESTRICTED") || strCategory.equals("NATIONALS"))
						{
							strBlngGrpCatgAppYN = "Y";
						}
						else
						{
							strBlngGrpCatgAppYN = "N";
						}
					}
					else
					{
						if (strCategory.equals("UNRESTRICTED") || strCategory.equals("OTHERS"))
						{
							strBlngGrpCatgAppYN = "Y";
						}
						else
						{
							strBlngGrpCatgAppYN = "N";
						}
					}
				}

				if (boolChangeBillQry == false)
				{
					if((mbilling_group.equals(blng_grp_id)) && ((strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP"))))||strModuleId.equals("MP")))
					{
						str_blng_grp_id = blng_grp_id;
						str_short_desc = short_desc;
					}
					else
					{																

					}
				}
				else
				{
						str_blng_grp_id = blng_grp_id;
						str_short_desc = short_desc;
				}
				boolRecordFound = true;
//						System.out.println("testing3");			
			}
			if ((boolRecordFound == false) && (boolChangeBillQry == true))
			{
				str_blng_grp_id = blng_grp_id;
				str_short_desc = short_desc;
			}	
			
			//Rajesh V 
			if((str_blng_grp_id != null) && (!("".equals(str_blng_grp_id)))){
				CallableStatement callInt = con.prepareCall("{call  blhealthcard.get_hcard_enable_yn(?,?,SYSDATE,?,?,?,?,null,null)}");	
	
				callInt.setString(1,facility_id);
				callInt.setString(2,patient_id);
				callInt.registerOutParameter(3,java.sql.Types.VARCHAR);
				callInt.setInt(4,0);
				callInt.setInt(5,0);
				callInt.setString(6,str_blng_grp_id);
				callInt.execute();	
				hCardYn = callInt.getString(3);
				//out.println(hCardYn);
				callInt.close();
			}
			//System.err.println("From JSP ->"+hCardYn+"-"+facility_id+"-"+patient_id+"-"+str_blng_grp_id);

			//Rajesh V
		}

		if (strSplSchemeBlngGrpPresent== null||strSplSchemeBlngGrpPresent.equals("null"))		
			strSplSchemeBlngGrpPresent="0";		

		if (rs != null) rs.close();
		pstmt.close();	

		if(!str_blng_grp_id.equals(""))
		{
			String currency_desc_for_bg_qry="Select CURRENCY_CODE,CURRENCY_DESC,PR_PAYER_EMPLOYER_ID_MAND_YN,PACKAGE_YN,nvl(CAPTURE_REF_SOURCE_DTL_YN,'N'),nvl(REF_SOURCE_MAIN_MAND_YN,'N'),nvl(REF_SOURCE_SUB_MAND_YN,'N') from bl_blng_grp_lang_vw where blng_grp_id='"+str_blng_grp_id+"' and language_id='"+locale+"'";
//			System.out.println("currency_desc_for_bg_qry:"+currency_desc_for_bg_qry);
			pstmt = con.prepareStatement( currency_desc_for_bg_qry ) ;
			rs = pstmt.executeQuery();

			if( rs != null )
			{
				while( rs.next() ) 
				{
					str_currency_code_for_bg = rs.getString(1);
					str_currency_desc_for_bg = rs.getString(2);
					str_payer_emp_id_mand_yn = rs.getString(3);
					str_is_blng_grp_pkg_link_YN = rs.getString(4);
					referral_source_capture_YN = rs.getString(5);
					referral_source_main_mand_YN = rs.getString(6);
					referral_source_sub_mand_YN = rs.getString(7);
				}
				if (rs != null) rs.close();
				pstmt.close();	
			}
			if(str_currency_code_for_bg == null) str_currency_code_for_bg="";
			if(str_currency_desc_for_bg == null) str_currency_desc_for_bg="";
			if(str_payer_emp_id_mand_yn == null) str_payer_emp_id_mand_yn="N";
			if(str_is_blng_grp_pkg_link_YN == null) str_is_blng_grp_pkg_link_YN="N";

/*			
			if(!patient_id.equals(""))
			{
				String str_pkg_rel_blng_grp = "";
				String valid_pkg_for_bg_avail_YN_qry="Select 'Y',blng_grp_id from BL_PATIENT_PACKAGE_HDR where  PATIENT_ID='"+patient_id+"' and STATUS = 'O' and facility_id='"+facility_id+"' and to_date('"+com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en")+"','DD/MM/YYYY') between EFF_DATE_FROM and nvl(EFF_DATE_FROM,to_date('"+com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en")+"','DD/MM/YYYY') ";
				System.out.println("valid_pkg_for_bg_avail_YN_qry:"+valid_pkg_for_bg_avail_YN_qry);
				pstmt = con.prepareStatement( valid_pkg_for_bg_avail_YN_qry ) ;
				rs = pstmt.executeQuery();

				if( rs != null )
				{
					while( rs.next() ) 
					{
						str_valid_pkg_for_bg_avail_YN = rs.getString(1);
						str_pkg_rel_blng_grp = rs.getString(2);
					}
					rs.close();
					pstmt.close();	
					if(str_valid_pkg_for_bg_avail_YN == null) str_valid_pkg_for_bg_avail_YN="N";
					if(str_pkg_rel_blng_grp == null) str_pkg_rel_blng_grp="";
				}
				if(str_valid_pkg_for_bg_avail_YN.equals("Y"))
				{
					str_valid_pkg_for_pat_id_YN = "Y";
				}
				else
				{
					str_valid_pkg_for_pat_id_YN = "N";
				}

				if(str_pkg_rel_blng_grp.equals(str_blng_grp_id))
				{
					str_valid_pkg_for_bg_avail_YN = "Y";
				}
				else
				{
					str_valid_pkg_for_bg_avail_YN = "N";
				}
			}
*/
			if(!patient_id.equals(""))
			{
				try
				{
//					System.out.println("encounter_date_aft_trunc:"+encounter_date_aft_trunc);
					call_pkg = con.prepareCall("{ ? = call  blcore.package_blng_grp_yn(?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?)}");
					call_pkg.registerOutParameter(1,java.sql.Types.VARCHAR);

					call_pkg.setString(2,facility_id);
					call_pkg.setString(3,patient_id);
					call_pkg.setString(4,strEpisodeType);
					call_pkg.setString(5,strFunctionId);
					call_pkg.setString(6,str_blng_grp_id);
					call_pkg.setString(7,com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en"));
					call_pkg.setString(8,"P");
					if(strCitizenYn.equals("Y"))
					{
						call_pkg.setString(9,"NATIONALS");
					}
					else
					{
						call_pkg.setString(9,"OTHERS");
					}

					call_pkg.execute();							
					str_valid_pkg_for_pat_avail_YN = call_pkg.getString(1);				
					call_pkg.close();
					if ( str_valid_pkg_for_pat_avail_YN == null ) str_valid_pkg_for_pat_avail_YN = "";

					call_pkg = con.prepareCall("{ ? = call  blcore.package_blng_grp_yn(?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?)}");
					call_pkg.registerOutParameter(1,java.sql.Types.VARCHAR);

					call_pkg.setString(2,facility_id);
					call_pkg.setString(3,patient_id);
					call_pkg.setString(4,strEpisodeType);
					call_pkg.setString(5,strFunctionId);
					call_pkg.setString(6,str_blng_grp_id);
					call_pkg.setString(7,com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en"));
					call_pkg.setString(8,"B");
					if(strCitizenYn.equals("Y"))
					{
						call_pkg.setString(9,"NATIONALS");
					}
					else
					{
						call_pkg.setString(9,"OTHERS");
					}

					call_pkg.execute();							
					str_valid_pkg_for_pat_bg_avail_YN = call_pkg.getString(1);				
					call_pkg.close();

					
					if ( str_valid_pkg_for_pat_bg_avail_YN == null ) str_valid_pkg_for_pat_bg_avail_YN = "";
				}
				catch(Exception e)
				{
					System.out.println("Exception while chekcing package:"+e.toString());
					out.println("Exception while chekcing package:"+e.toString());
				}
				
				if(str_is_blng_grp_pkg_link_YN.equals("Y") && str_valid_pkg_for_pat_bg_avail_YN.equals("N"))
				{
					str_blng_grp_id = "" ;
					str_short_desc = "" ;

            _bw.write(_wl_block22Bytes, _wl_block22);

				}
			}
		}

		if (strModuleId.equals("MP"))
		{ 
	
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
	
		}
		else
		{
	
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

		}
	 
            _bw.write(_wl_block27Bytes, _wl_block27);
	

	 if("Y".equals(payerGrpBySetup)){ 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(str_short_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
	 else{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(str_short_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
 	

	//	if(strModuleId.equals("MP") &&strFunctionId.equals("PAT_REG") &&  str_short_desc.length() > 0 ) 
		
		if((strModuleId.equals("MP")) && (strFunctionId.equals("PAT_REG")) && (patient_id.length()>0))
		//	if((cur_patient_id.length()>0)&& strModuleId.equals("MP")&&(strFunctionId.equals("PAT_REG"))
		{ 
            _bw.write(_wl_block33Bytes, _wl_block33);
}	
            _bw.write(_wl_block34Bytes, _wl_block34);
if("Y".equals(hCardYn)){ 
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
}
	else{
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
} 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(str_blng_grp_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(str_payer_emp_id_mand_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_currency_code_for_bg));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(str_currency_desc_for_bg));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(str_is_blng_grp_pkg_link_YN));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(str_valid_pkg_for_pat_avail_YN));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(str_valid_pkg_for_pat_bg_avail_YN));
            _bw.write(_wl_block45Bytes, _wl_block45);

		if(strModuleId.equals("@@@") && (operation.equals("Insert")))
		{

            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

			pstmt = con.prepareStatement( "select blng_class_code, short_desc from bl_blng_class_lang_vw where 	nvl(status,'X') !='S' order by 2" ) ;
			rs1 = pstmt.executeQuery() ;
			if( rs1 != null ) 
			{
				while( rs1.next() ) 
				{
					String blng_class_code = rs1.getString( "blng_class_code" ) ;
					String short_desc = rs1.getString( "short_desc" ) ;
					if(mbilling_class.equals(blng_class_code))
					{
						out.println("<option selected value=\""+blng_class_code+"\">"+short_desc+"</option>");
					}
					else
					{
						out.println("<option value=\""+blng_class_code+"\">"+short_desc+"</option>");
					}
				}
			}
			if(rs1 !=null) rs1.close();
			pstmt.close() ;		

            _bw.write(_wl_block49Bytes, _wl_block49);

		}
		else 
	    {	

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mbilling_class));
            _bw.write(_wl_block51Bytes, _wl_block51);

	    }
		if(operation.equals("Update")||(boolSecurity == true))
		{


            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(upd_pat_flag));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block55Bytes, _wl_block55);

		}
		else
		{
		
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block57Bytes, _wl_block57);

		}

            _bw.write(_wl_block58Bytes, _wl_block58);
  
		if (capture_employer_id_yn.equals("N"))
		{

            _bw.write(_wl_block59Bytes, _wl_block59);

		}
		else
		{

            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

			pstmt = con.prepareStatement( "select cust_code, short_name from bl_emp_ins_mst_lang_vw where language_id='"+locale+"' and  nvl(insurance_yn,'N')='N' and status is null order by 2" );
			rs1 = pstmt.executeQuery() ;
			if( rs1 != null ) 
			{
				while( rs1.next() ) 
				{
					String cust_code = rs1.getString( "cust_code" ) ;
					String short_name = rs1.getString( "short_name" ) ;
					if(memployer_code.equals(cust_code))
					{
						out.println("<option selected value=\""+cust_code+"\">"+short_name+"</option>");
					}
					else
					{
						out.println("<option value=\""+cust_code+"\">"+short_name+"</option>");
					}
				}
			}
			if(rs1 !=null) rs1.close();
			pstmt.close() ;

            _bw.write(_wl_block63Bytes, _wl_block63);

	if(str_payer_emp_id_mand_yn.equals("Y"))
	{

            _bw.write(_wl_block64Bytes, _wl_block64);

	}
	else
	{

            _bw.write(_wl_block65Bytes, _wl_block65);

	}

            _bw.write(_wl_block66Bytes, _wl_block66);
 
		}

		if(package_flag.equals("Y"))
		{

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(pkg_bill_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(pkg_bill_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(pkg_bill_type));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(pkg_bill_no));
            _bw.write(_wl_block72Bytes, _wl_block72);

		}
		else
		{

            _bw.write(_wl_block73Bytes, _wl_block73);

		}

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(cur_patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(strCitizenYn));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(ins_auth_flag));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(show_hide_blng_class));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(third_party_gl_in_use_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(third_party_gl_mandatory_yn));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(ref_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(org_type_ind));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(capture_employer_id_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
 
		if(strModuleId.equals("MP"))
		{
			if (operation.equals("Update"))
			{

            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(strAnnualIncome));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(strAnnualIncome));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(strFamilyAsset));
            _bw.write(_wl_block94Bytes, _wl_block94);

			}
			else
			{

            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(strAnnualIncome));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(strAnnualIncome));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(strFamilyAsset));
            _bw.write(_wl_block95Bytes, _wl_block95);

			}
		}
		else
		{


            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(strAnnualIncome));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(strFamilyAsset));
            _bw.write(_wl_block98Bytes, _wl_block98);

		}

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(strArrayHealthCard_YN));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(bl_oper_yn));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(strHealthCardExpired_YN));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(strArrayBillingApp_YN));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(strRepositoryYN));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(strDataSourceId));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(strItemsDisabled));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(strExtBillingGroup));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(strExtSettlType));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strFunctionId));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(boolPatientFoundMP));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(boolSecurity));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(strChngToVisit));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(strBLInterfacedYN));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(strLoggedUser));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(strBlngClass));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(strBillType));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(strBedClass));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(strBedType));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(strBedNo));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(strAdmissionType));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(strNursingUnit));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(strMessageId));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(strDeptCode));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(strSchemeType));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(strMessageDesc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(strPractitionerId));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(strPractitionerTypeInd));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(strPatBlngGrp));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(strSpecialSchemeBlngGrp));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(strSpecialSchemeBlngGrpDesc));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(strSplSchemeBlngGrpPresent));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(strBlngGrpAppYN));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(strBlngGrpCatgAppYN));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(strBlngGrpStatus));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(mbilling_group));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(strHcardApplicableYN));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(strHcareApplicableYN));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(strHcardSchemeId));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(strHcareSchemeId));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(strHcardExpiredYN));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(strHcareExpiredYN));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(strPreviousBlngGrp));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(strPreviousBlngGrpDesc));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(strHcardPrerequisite_yn));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(billing_mode));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(gl_holder_name));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(gl_rel));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(strRespForPayment));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(strblnggrp));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(strBillGrpId));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(strdfltbgyn));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(strUpdFinDtls));
            _bw.write(_wl_block157Bytes, _wl_block157);

		if (operation.equals("Update"))
		{

            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(strNoDependants));
            _bw.write(_wl_block160Bytes, _wl_block160);

			if(!patient_id.equals(""))
			{
				if(str_valid_pkg_for_pat_bg_avail_YN.equals("Y"))
				{

            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

				}	
				else
				{

            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

				}
			}
			else
			{

            _bw.write(_wl_block164Bytes, _wl_block164);

			}

            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(strRespForPayment));
            _bw.write(_wl_block167Bytes, _wl_block167);

			if (!(ref_id.equals("")))
			{	
				if (org_type_ind.equals("P"))
			{
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
}
				else if (org_type_ind.equals("G"))
			{
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
}
			else 
			{
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
}
			}
		
            _bw.write(_wl_block171Bytes, _wl_block171);

if(strCustomerId.equalsIgnoreCase("GP")) {
//	if(str_slmt_ind.equalsIgnoreCase("R")) {	
	if(str_slmt_ind.equalsIgnoreCase("R")||str_slmt_ind.equalsIgnoreCase("X")) {	
	
	
            _bw.write(_wl_block172Bytes, _wl_block172);
} 
	//else if(str_slmt_ind.equalsIgnoreCase("C")||str_slmt_ind.equalsIgnoreCase("X")){
		else if(str_slmt_ind.equalsIgnoreCase("C")){

            _bw.write(_wl_block173Bytes, _wl_block173);
} 
else{ 

            _bw.write(_wl_block174Bytes, _wl_block174);
} 
	
	} 
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(strPatRelnWithRespPerson));
            _bw.write(_wl_block177Bytes, _wl_block177);
 
			if (third_party_gl_in_use_yn.equals("Y"))
			{	

            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(strGlHolderName));
            _bw.write(_wl_block180Bytes, _wl_block180);

	if(!strModuleId.equals("MP"))
	{

            _bw.write(_wl_block181Bytes, _wl_block181);

	}

            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(strGlHolderReln));
            _bw.write(_wl_block184Bytes, _wl_block184);

		    }	
			else
			{

            _bw.write(_wl_block185Bytes, _wl_block185);


			}
			
			if(!(strModuleId.equals("MP")) && !(strFunctionId.equals("BOOKING")))
			{
				if(str_upd_patient_fin_dtls_yn.equals("Y"))
					upd_pat_fin_dtls_YN="checked";
				if(strUpdFinDtls.equals("Y"))
					upd_pat_fin_dtls_YN="checked  readonly";

            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(upd_pat_fin_dtls_YN));
            _bw.write(_wl_block187Bytes, _wl_block187);

				if (!(ref_id.equals("")))
				{	
					if (org_type_ind.equals("P"))
					{	

            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);

					}
					else if(org_type_ind.equals("G"))
					{

            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);

					}
					else
					{

            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);

					}
				}

            _bw.write(_wl_block192Bytes, _wl_block192);

			}
			else
			{

            _bw.write(_wl_block193Bytes, _wl_block193);

			}
		}
		else
		{

            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(strNoDependants));
            _bw.write(_wl_block195Bytes, _wl_block195);

			if(!patient_id.equals(""))
			{
				if(str_valid_pkg_for_pat_bg_avail_YN.equals("Y"))
				{

            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

				}	
				else
				{

            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

				}
			}
			else
			{

            _bw.write(_wl_block164Bytes, _wl_block164);

			}

            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(strRespForPayment));
            _bw.write(_wl_block198Bytes, _wl_block198);

			if (!(ref_id.equals("")))
			{	
			   if (org_type_ind.equals("P"))
				{
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);
}
			   else if (org_type_ind.equals("G"))
				{
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);
}
			   else 
				{
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);
}
			}
	
            _bw.write(_wl_block201Bytes, _wl_block201);


if(strCustomerId.equalsIgnoreCase("GP")) {	
//	if(str_slmt_ind.equalsIgnoreCase("R")) {	
	if(str_slmt_ind.equalsIgnoreCase("R")||str_slmt_ind.equalsIgnoreCase("X")) {		
		
            _bw.write(_wl_block172Bytes, _wl_block172);
} 
//else if(str_slmt_ind.equalsIgnoreCase("C")||str_slmt_ind.equalsIgnoreCase("X")){
	else if(str_slmt_ind.equalsIgnoreCase("C")){
	System.out.println("str_slmt_ind"+str_slmt_ind);
	
            _bw.write(_wl_block173Bytes, _wl_block173);
} 
else{ 

            _bw.write(_wl_block174Bytes, _wl_block174);
} 
	} 
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(strPatRelnWithRespPerson));
            _bw.write(_wl_block204Bytes, _wl_block204);
 
			if (third_party_gl_in_use_yn.equals("Y"))
			{	

            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(strGlHolderName));
            _bw.write(_wl_block180Bytes, _wl_block180);

	if(!strModuleId.equals("MP"))
	{

            _bw.write(_wl_block205Bytes, _wl_block205);

	}

            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(strGlHolderReln));
            _bw.write(_wl_block207Bytes, _wl_block207);

			}
			else
			{

            _bw.write(_wl_block185Bytes, _wl_block185);


			}
			if(!(strModuleId.equals("MP")) && !(strFunctionId.equals("BOOKING")))
			{
				if(str_upd_patient_fin_dtls_yn.equals("Y"))
					upd_pat_fin_dtls_YN="checked";
				if(strUpdFinDtls.equals("Y"))
					upd_pat_fin_dtls_YN="checked  readonly";

            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(upd_pat_fin_dtls_YN));
            _bw.write(_wl_block187Bytes, _wl_block187);

				if (!(ref_id.equals("")))
				{	
					if (org_type_ind.equals("P"))
					{	

            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);

					}
					else if(org_type_ind.equals("G"))
					{

            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);

					}
					else
					{

            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);

					}
				}

            _bw.write(_wl_block192Bytes, _wl_block192);

			}
			else
			{

            _bw.write(_wl_block193Bytes, _wl_block193);

			}	
		}

            _bw.write(_wl_block1Bytes, _wl_block1);

	String ref_src_code_disp="";
	String ref_src_code_main_mand_disp ="";
	String ref_src_code_sub_mand_disp = "";

/*	Commented and moved up for PE Changes
	String ref_src_code_qry="select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N'),nvl(REF_SOURCE_MAIN_MAND_YN,'N'),nvl(REF_SOURCE_SUB_MAND_YN,'N') from bl_blng_grp where BLNG_GRP_ID='"+str_blng_grp_id+"'";

	try
	{
		pstmt = con.prepareStatement(ref_src_code_qry);
		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{	
			while( rs2.next() )
			{  
				referral_source_capture_YN = rs2.getString(1);
				referral_source_main_mand_YN = rs2.getString(2);
				referral_source_sub_mand_YN = rs2.getString(3);
			}
		}
		if (rs2 != null) rs2.close();
		pstmt.close();	
	}
	catch(Exception e)
	{
		System.out.println("Exception in ref_src_code_qry:"+e);
	}
*/		
	if(referral_source_capture_YN.equals("Y"))
	{
		ref_src_code_disp="display:inline";
		if(referral_source_main_mand_YN.equals("Y"))
		{
			ref_src_code_main_mand_disp = "display:inline";
		}
		else
		{
			ref_src_code_main_mand_disp = "display:none";
		}
		if(referral_source_sub_mand_YN.equals("Y"))
		{
			ref_src_code_sub_mand_disp = "display:inline";
		}
		else
		{
			ref_src_code_sub_mand_disp = "display:none";
		}
	}
	else if(referral_source_capture_YN.equals("N"))
	{
		ref_src_code_disp="display:none";
		ref_src_code_main_mand_disp = "display:none";
		ref_src_code_sub_mand_disp = "display:none";
	}
	else
	{
		ref_src_code_disp="display:none";
	}

	if(!strRefSrcMainCode.equals(""))
	{
		CallableStatement call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
		call.registerOutParameter(1,java.sql.Types.VARCHAR);

		call.setString(2,strRefSrcMainCode);
		call.setString(3,locale);
		call.setString(4,"3");

		call.execute();							
		ref_src_main_lng_name = call.getString(1);				
		call.close();
		if ( ref_src_main_lng_name == null ) ref_src_main_lng_name = "";
	}
	else
	{
		ref_src_main_lng_name="";
	}

	if(!strRefSrcSubCode.equals(""))
	{
		CallableStatement call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
		call.registerOutParameter(1,java.sql.Types.VARCHAR);

		call.setString(2,strRefSrcSubCode);
		call.setString(3,locale);
		call.setString(4,"3");

		call.execute();							
		ref_src_sub_lng_name = call.getString(1);				
		call.close();
		if ( ref_src_sub_lng_name == null ) ref_src_sub_lng_name = "";
	}
	else
	{
		ref_src_sub_lng_name="";
	}
//	System.out.println("ref_src_code_disp:"+ref_src_code_disp);
//	System.out.println("referral_source_main_mand_YN:"+referral_source_main_mand_YN);
//	System.out.println("referral_source_sub_mand_YN:"+referral_source_sub_mand_YN);

            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(referral_source_capture_YN));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(referral_source_main_mand_YN));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(referral_source_sub_mand_YN));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(strRefSrcMainDesc));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(ref_src_code_main_mand_disp));
            _bw.write(_wl_block217Bytes, _wl_block217);

			if(ref_src_main_lng_name.equals(""))
			{

            _bw.write(_wl_block218Bytes, _wl_block218);

			}
			else
			{

            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(ref_src_main_lng_name));
            _bw.write(_wl_block220Bytes, _wl_block220);

			}

            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(strRefSrcSubDesc));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(ref_src_code_sub_mand_disp));
            _bw.write(_wl_block217Bytes, _wl_block217);

			if(ref_src_sub_lng_name.equals(""))
			{

            _bw.write(_wl_block225Bytes, _wl_block225);

			}
			else
			{

            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(ref_src_sub_lng_name));
            _bw.write(_wl_block220Bytes, _wl_block220);

			}

            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(strRefSrcMainCode));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(strRefSrcSubCode));
            _bw.write(_wl_block220Bytes, _wl_block220);

	try
	{
		String prev_enc_check_qry = "";
//		String op_ae_prev_enc_check_qry="";
//		String ip_dc_prev_enc_check_qry="";
/*
		if(strEpisodeType.equals("O") || strEpisodeType.equals("E"))
		{
			prev_enc_check_qry="select count(1) from op_last_visit where OPERATING_FACILITY_ID ='"+facility_id+"' and last_episode_type ='"+strEpisodeType+"' and LAST_PATIENT_ID = '"+patient_id+"'";
		}
		else if(strEpisodeType.equals("I") || strEpisodeType.equals("D"))
		{
			prev_enc_check_qry="select count(1) from ip_last_episode where FACILITY_ID ='"+facility_id+"' and last_episode_type ='"+strEpisodeType+"' and PATIENT_ID = '"+patient_id+"'";
		}

		op_ae_prev_enc_check_qry="select count(1) from op_last_visit where OPERATING_FACILITY_ID ='"+facility_id+"' and last_episode_type in ('O','E') and LAST_PATIENT_ID = '"+patient_id+"'";

		if(!op_ae_prev_enc_check_qry.equals("")) 
		{
			pstmt = con.prepareStatement(op_ae_prev_enc_check_qry);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{	
				while( rs2.next() )
				{  
					op_ae_prev_enc_check_count = rs2.getInt(1);
				}
			}
			if (rs2 != null) rs2.close();
			pstmt.close();	
		}

		ip_dc_prev_enc_check_qry="select count(1) from ip_last_episode where FACILITY_ID ='"+facility_id+"' and last_episode_type in ('I','D') and PATIENT_ID = '"+patient_id+"'";

		if(!ip_dc_prev_enc_check_qry.equals(""))
		{
			pstmt = con.prepareStatement(ip_dc_prev_enc_check_qry);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{	
				while( rs2.next() )
				{  
					ip_dc_prev_enc_check_count = rs2.getInt(1);
				}
			}
			if (rs2 != null) rs2.close();
			pstmt.close();	
		}
*/
		pstmt = con.prepareStatement("SELECT count(*) FROM pr_encounter WHERE patient_id=? and FACILITY_ID=? AND ((patient_class IN ('OP','EM') AND visit_status NOT IN ('99')) OR (patient_class IN ('IP','DC') AND adt_status NOT IN ('09')))");
		pstmt.setString(1,patient_id);
		pstmt.setString(2,facility_id);
		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{	
			while( rs2.next() )
			{  
				prev_enc_check_count = rs2.getInt(1);
			}
		}
		if (rs2 != null) rs2.close();
		pstmt.close();	

//System.out.println("prev_enc_check_count:"+prev_enc_check_count);
	}
	catch(Exception e)
	{
		System.out.println("Exception in ref_src_code_qry:"+e);
	}

            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);

	if(strEpisodeType.equals("I") || strEpisodeType.equals("D") || (strEpisodeType.equals("I") && strFunctionId.equals("BOOKING")))
	{
		if(str_spl_clinic_rel_enc_YN.equals("Y"))
			spl_clinic_rel_enc_YN="checked";
		else
			spl_clinic_rel_enc_YN="";

            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(spl_clinic_rel_enc_YN));
            _bw.write(_wl_block233Bytes, _wl_block233);

	}
	else
	{

            _bw.write(_wl_block234Bytes, _wl_block234);

	}
	//added for package billing   previous encounter link  separeted if it not OP 
//if it is OP package subscription is added along with prv Enounter link 
/***** package billing *************** start**************/	
	
	if(package_enabled_yn.equals("Y") && (strModuleId.equals("OP") || strModuleId.equals("IP")))
	{	

            _bw.write(_wl_block235Bytes, _wl_block235);
	

		String associate_pkg_req_yn=bean.subsOpenPkgsExists(facility_id,locale,patient_id,encounter_date_aft_trunc);
		if(associate_pkg_req_yn.equals("Y"))
		{

            _bw.write(_wl_block236Bytes, _wl_block236);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block237Bytes, _wl_block237);

		}	

            _bw.write(_wl_block238Bytes, _wl_block238);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block239Bytes, _wl_block239);

			//Karthik commented on 21/7/2013 as Discount Page was called Twice IN050265
			//if(str_charge_logic.equals("Y"))
			//{
			 
            _bw.write(_wl_block240Bytes, _wl_block240);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block239Bytes, _wl_block239);
 //} 
            _bw.write(_wl_block241Bytes, _wl_block241);

	}//end module id if
	/***** package billing *************** end**************/	

//	if(srtencdfltbgyn.equals("Y") && strprovselfrmprevencyn.equals("Y") && !strModuleId.equals("MP") && (op_ae_prev_enc_check_count>0 || ip_dc_prev_enc_check_count>0))
/*System.err.println("AddModifyPatFinDetails.jsp $$$$$$$$$$$$$$-------->"+srtencdfltbgyn+"    "+strprovselfrmprevencyn+"   "+strModuleId+"  "+prev_enc_check_count);*/

	String custID= BLReportIdMapper.getCustomerId();
	if( ( ( srtencdfltbgyn.equals("Y") && strprovselfrmprevencyn.equals("Y") ) || "ALKA".equals(custID) ) && !strModuleId.equals("MP") && prev_enc_check_count>0)
	{

	

            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);

	}
	else
	{

            _bw.write(_wl_block244Bytes, _wl_block244);

	}

            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(encounter_date));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(sel_frm_prev_enc));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(pat_ser_code));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(str_slmt_ind));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(str_adm_rec_flag));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(credit_doc_ref_reqd_yn));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(disaster_regn_YN));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(fin_auth_user_id));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(fin_class_flag_YN));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(autoFinChk));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(fin_class_dtls_updated_YN));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(charge_for_pat_regn_yn));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(encounter_date_time));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(encounter_date_aft_trunc));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(open_pkg_exists_yn));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(package_enabled_yn));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf( isUserAuthorizedClass));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(str_charge_logic));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(strCustomerId));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(SiteSpecific));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(payer_suspended_YN));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(payerGrpBySetup));
            _bw.write(_wl_block271Bytes, _wl_block271);
 
String firstVisitDateTime="";
if(callingModule.equals("OP")){
	firstVisitDateTime=request.getParameter("vst_regn_date_time"); 
}else if(callingModule.equals("IP")){
	firstVisitDateTime=request.getParameter("encounter_date_time"); 
}	

            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(firstVisitDateTime));
            _bw.write(_wl_block273Bytes, _wl_block273);

	/*****
	if (strHealthCardExpired_YN.equals("Y") && (boolPatientFoundMP==true)) 
	{		
		if (!strDfltBillingGroup.equals(mbilling_group))
		{
			out.println("<script>setTimeout('dispExpAlert()',100);</script>");	
		}
	} //Added as request by HMC on 20/8/2002.
	else if (strHealthCard_YN.equals("Y") && alt_id1_exp_date.equals("")&& (boolPatientFoundMP==true)) 
	{
		out.println("<script>setTimeout('dispAlert()',100);</script>");	
	}
	******/
		out.println("<script>setTimeout('funHealthScheme();',500);</script>");	
	
		clinic_code_check=(String)session.getAttribute("clinic_code");
		if(clinic_code_check == null) clinic_code_check="";
		visit_type_code_check=(String)session.getAttribute("visit_type_code");
		if(visit_type_code_check == null) visit_type_code_check="";
		patient_id_check=(String)session.getAttribute("patient_id");
		if(patient_id_check == null) patient_id_check="";
		pract_id_check=(String)session.getAttribute("practitioner_id");
		if(pract_id_check == null) pract_id_check="";
		billing_reset_flag=(String)request.getParameter("billingFlag");
		if(billing_reset_flag==null) billing_reset_flag="";

		pat_ser_code_check = (String)session.getAttribute("pat_ser_code");
		if(pat_ser_code_check == null) pat_ser_code_check="";
//System.err.println("pat_ser_code_check from sess:"+pat_ser_code_check);
//System.err.println("pat_ser_code_check from req:"+pat_ser_code);
		if( ((!clinic_code.equals(clinic_code_check) || !visit_type_code.equals(visit_type_code_check) || !patient_id.equals(patient_id_check) || !strPractitionerId.equals(pract_id_check) || billing_reset_flag.equals("N")) && !strModuleId.equals("MP")) || (strModuleId.equals("MP") && !pat_ser_code_check.equals(pat_ser_code) && charge_for_pat_regn_yn.equals("Y")))
		{
//			System.err.println("Inside Session values clear");
			session.removeAttribute("hosp_panel_str");
			session.removeAttribute("prof_panel_str");
			session.removeAttribute("prof_panel_str_YN");
			session.removeAttribute("hosp_panel_str_YN");
			session.removeAttribute("upd_hosp_chrg_amt");
			session.removeAttribute("upd_hosp_chrg_pat_amt");
			session.removeAttribute("upd_med_chrg_amt");
			session.removeAttribute("upd_med_chrg_pat_amt");
//			System.err.println("Inside Session values hosp_dtls");
			session.removeAttribute("hosp_dtls");
//			System.err.println("Inside Session values prof_dtls");
			session.removeAttribute("prof_dtls");
			session.removeAttribute("fin_dtls_to_chrg_dtls");
			session.removeAttribute("hosp_panel");
			session.removeAttribute("prof_panel");
		}

		session.setAttribute("clinic_code",clinic_code);
		session.setAttribute("visit_type_code",visit_type_code);
		session.setAttribute("patient_id",patient_id);
		session.setAttribute("practitioner_id",strPractitionerId);
		session.setAttribute("pat_ser_code",pat_ser_code);

		if(((billing_mode.equals("Modify") || operation.equals("Update")) && autoFinChk.equals("N")) || ((billing_mode.equals("Modify") || operation.equals("Update")) && autoFinChk.equals("Y") && fin_class_dtls_updated_YN.equals("Y")))
		{

            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(str_slmt_ind));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(boolSecurity));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(payerGrpBySetup));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(str_adm_rec_flag));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(credit_doc_ref_reqd_yn));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(strCitizenYn));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block281Bytes, _wl_block281);

		}
		if(str_valid_pkg_for_pat_bg_avail_YN.equals("Y") || str_valid_pkg_for_pat_avail_YN.equals("Y"))
		{

            _bw.write(_wl_block282Bytes, _wl_block282);

		}
	}
	catch(Exception ee)
	{
		out.println("Exception in Details.jsp"+ee);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
	
	}
	putObjectInBean(bean_id,bean,request);
	
	/*Added by Karthik to take Patient Financial details by default - starts */
	
	
	try
	{

		quickAdmissionBillingGroup = "";		
		System.err.println("~~~~~callingModule:"+callingModule);	
		System.err.println("~~~~~callingFunction:"+callingFunction);	
		System.err.println("~~~~~quickAdmission:"+quickAdmission);	
		if(callingModule.equals("IP") && callingFunction.equals("ADMISSION") && quickAdmission.equalsIgnoreCase("Y")){			

			out.println("<script>blnggrplkup();</script>");//blnggrplkup();	
			out.println("<script>setTimeout('sendBackFinDetails();',500)</script>");//blnggrplkup();	
		}

	}
	catch(Exception ee)
	{
		out.println("Exception in quickAdmission:::::: "+ee);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	
	
	/*Added by Karthik to take Patient Financial details by default - ends*/
	

            _bw.write(_wl_block4Bytes, _wl_block4);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRIMARY_BILLING_GROUP.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ActiveHealthCard.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ActiveHealthCard.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingClass.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EMPLOYER_NAME.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PACKAGE_BILL.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FAMILY_ANNUAL_INCOME.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FAMILY_ASSET.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FAMILY_ANNUAL_INCOME.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FAMILY_ASSET.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NO_OF_DEPENDANTS.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VW_SUBS_OPEN_PACKAGE_DTL.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VW_SUBS_OPEN_PACKAGE_DTL.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RESPONSIBLE_FOR_PAYMENT.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PVT_REFERRAL.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GOVT_REFERRAL.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.REFERRAL_LINK.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PATIENT_RELN_WITH_RESP_PERSON.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GL_HOLDER_NAME.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PATIENT_RELN_WITH_GL_HOLDER.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UPDATE_PATIENT_FIN_DTL.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PVT_REFERRAL.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GOVT_REFERRAL.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.REFERRAL_LINK.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NO_OF_DEPENDANTS.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VW_SUBS_OPEN_PACKAGE_DTL.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VW_SUBS_OPEN_PACKAGE_DTL.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RESPONSIBLE_FOR_PAYMENT.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PVT_REFERRAL.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GOVT_REFERRAL.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.REFERRAL_LINK.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PATIENT_RELN_WITH_RESP_PERSON.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GL_HOLDER_NAME.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PATIENT_RELN_WITH_GL_HOLDER.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UPDATE_PATIENT_FIN_DTL.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PVT_REFERRAL.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GOVT_REFERRAL.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.REFERRAL_LINK.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PMY_REF_SRC.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEC_REF_SRC.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PKG_SUBS_MSG.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IS_SPL_CLINIC_ENC_YN.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AssociateSubscribedPackage.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Subs_pack.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageDiscount.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEL_FRM_PREV_ENC.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
