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
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetailsmultiblnggrphead extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsMultiBlngGrpHead.jsp", 1743570614358L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF                              Developer Name\n---------------------------------------------------------------------------------------------------------\n1            V210223           \t 14917  \tBL-Common-Secondary Billing Group Window\tMohana Priya K\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\n<script>\n async function blnggrplkup(clng_evnt)\n\t   {\t\t\t\n\t\tvar autoFinChk = document.forms[0].autoFinChk.value;\n\t\tvar target\t\t\t= document.forms[0].billing_group_desc;\n\t\tif(clng_evnt == \'B\')\n\t\t{\n\t\t\tif( target.value == \"\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].billing_group_desc.value = \"\";\n\t\t\t\tdocument.forms[0].billing_group.value = \"\";\n\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\t\tvar billinggroup    = document.forms[0].billing_group.value;\n\n\t\tvar retVal\t\t\t= new String();\n\n\t\t/* var dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ; */\n\t\t\n\t\tvar dialogTop\t\t\t= \"10vh\";\n\t\tvar dialogHeight\t\t= \"80vh\" ;\n\t\tvar dialogWidth\t\t\t= \"70vw\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar sql1\t\t\t\t= \"\";\n\t\tvar sql2\t\t\t\t= \"\";\t\t\n\n\t\tvar title=getLabel(\"Common.BillingGroup.label\",\"common\");\n\t\ttitle=encodeURIComponent(title);\n\t\tvar column_sizes = escape(\"10%,20%,50%,10%,5%,5%,5%,5%\");           \n\n\t\tvar code=getLabel(\"Common.code.label\",\"common\");\n\t\tcode=encodeURIComponent(code);\n\t\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\t\tdesc=encodeURIComponent(desc);\n\t\tvar expnote=getLabel(\"eBL.EXPLANATORY_NOTE.label\",\"BL\");\n\t\texpnote=encodeURIComponent(expnote);\n\n\t\tvar capt_ref_src_dtl=getLabel(\"eBL.CAPTURE_REF_SOURCE_DTL.label\",\"BL\");\n\t\tcapt_ref_src_dtl=encodeURIComponent(capt_ref_src_dtl);\n\t\tvar ref_source_main_mand_yn=getLabel(\"eBL.PRMY_REF_SRC_MAND.label\",\"BL\");\n\t\tref_source_main_mand_yn=encodeURIComponent(ref_source_main_mand_yn);\n\t\tvar ref_source_sub_mand_yn=getLabel(\"eBL.SEC_REF_SRC_MAND.label\",\"BL\");\n\t\tref_source_sub_mand_yn=encodeURIComponent(ref_source_sub_mand_yn);\n\t\tvar cust_curr_code=getLabel(\"eBL.CURR_CODE.label\",\"BL\");\n\t\tcust_curr_code=encodeURIComponent(cust_curr_code);\n\t\tvar curr_desc=getLabel(\"eBL.CURR_DESC.label\",\"BL\");\n\t\tcurr_desc=encodeURIComponent(curr_desc);\n\n\t\tvar column_descriptions = code+\",\"+desc+\",\"+expnote+\',\'+capt_ref_src_dtl+\",\"+ref_source_main_mand_yn+\",\"+ref_source_sub_mand_yn+\",\"+cust_curr_code+\",\"+curr_desc;\n\n\t\tvar message = \'\';\n\n\t\tvar blnggrp\t\t\t= document.forms[0].blnggrp.value; \t\t\n\n\t\tvar ExtBillingGroup = document.forms[0].ext_billing_group.value;\n\n\t\tvar strCitizenYn = document.forms[0].CitizenYn.value;\n\n\t\tvar locale = document.forms[0].locale.value;\n\n\t\tvar ref_src_code_YN=\"N\";\n\t\tvar pmry_ref_src_mand_YN=\"N\";\n\t\tvar sec_ref_src_mand_YN=\"N\";\n\t\t\n\t\tif (autoFinChk == \"Y\")\n\t\t{\n\t\t\tvar primary_blng_grp = document.forms[0].primary_blng_grp.value;\n\t\t\tprimary_blng_grp = primary_blng_grp.substring(0,primary_blng_grp.indexOf(\"|\"));\n\t\t\tvar class_code = document.forms[0].class_code.value;\n\t\n\t\t\tsql1 = \"select DISTINCT B.APPL_BLNG_GRP_ID BLG_GP,a.short_desc SHORT_DESC,replace(a.detail_desc,chr(10),\'<br>\') DTL_DESC,nvl(a.CAPTURE_REF_SOURCE_DTL_YN,\'N\') CAPTURE_REF_SOURCE_DTL_YN, nvl(a.REF_SOURCE_MAIN_MAND_YN,\'N\') REF_SOURCE_MAIN_MAND_YN, nvl(a.REF_SOURCE_SUB_MAND_YN,\'N\') REF_SOURCE_SUB_MAND_YN,a.CURRENCY_CODE,a.CURRENCY_DESC from BL_BLNG_GRP_LANG_VW A,BL_APPL_BG_BY_CLASSFCTN B where ( NVL(a.category,\'UNRESTRICTED\') IN ( DECODE(\'\"+strCitizenYn+\"\',\'Y\',\'NATIONALS\',\'N\',\'OTHERS\',\'UNRESTRICTED\'), \'UNRESTRICTED\')) and a.language_id=\'\"+locale+\"\' AND a.SETTLEMENT_IND=\'X\' AND a.ADM_REC_FLAG=\'2\' AND A.BLNG_GRP_ID=B.APPL_BLNG_GRP_ID AND B.CLASSIFICATION_CODE = \'\"+class_code+\"\' AND B.APPL_BLNG_GRP_ID!=\'\"+primary_blng_grp+\"\' AND\";\n\t\t}\n\t\telse\n\t    {\n\t\t\t//Modified V20180709-Aravindh/GHL-CRF-0427/Alias name added for table in the below query\n\t\t\tsql1 = \"select blng_grp_id BLG_GP,short_desc SHORT_DESC,replace(detail_desc,chr(10),\'<br>\') DTL_DESC,nvl(CAPTURE_REF_SOURCE_DTL_YN,\'N\')  CAPTURE_REF_SOURCE_DTL_YN, nvl(REF_SOURCE_MAIN_MAND_YN,\'N\') REF_SOURCE_MAIN_MAND_YN, nvl(REF_SOURCE_SUB_MAND_YN,\'N\') REF_SOURCE_SUB_MAND_YN,CURRENCY_CODE,CURRENCY_DESC from BL_BLNG_GRP_LANG_VW a where ( NVL(category,\'UNRESTRICTED\') IN ( DECODE(\'\"+strCitizenYn+\"\',\'Y\',\'NATIONALS\',\'N\',\'OTHERS\',\'UNRESTRICTED\'), \'UNRESTRICTED\')) and language_id=\'\"+locale+\"\' AND SETTLEMENT_IND=\'X\' AND ADM_REC_FLAG=\'2\' AND\";\n\t    }\t\n\t\t\t\t\t\t\n\t\tif ( blnggrp == \"1\" ) \n\t\t{\n\t\tsql2 = \"  nvl(ref_yn,\'N\')=\'Y\' and nvl(hcare_only_yn,\'N\') = \'N\' and nvl(status,\'X\' )!=\'S\' \";\n\t\t}\n\n\t\tif ( blnggrp == \"2\" ) \n\t\t{\n\t\tsql2 = \" nvl(ref_yn,\'N\')=\'Y\' and nvl(ref_valid_for_regn_yn,\'N\')=\'Y\' and nvl(status,\'X\' )!=\'S\' and nvl(hcare_only_yn,\'N\') = \'N\' \" ;\t\n\t\t}\n\n\t\tif ( blnggrp == \"3\" ) \n\t\t{\n\t\tsql2 = \" nvl(op_yn,\'N\')=\'Y\' and nvl(status,\'X\' )!=\'S\' and  nvl(health_card_appl_yn,\'N\')=\'N\' and nvl(hcare_only_yn,\'N\')=\'N\' \";\n\t\t}\n\n\t\tif ( blnggrp == \"4\" ) \n\t\t{\n\t\tsql2 = \"  nvl(ip_yn,\'N\')=\'Y\' and nvl(status,\'X\' )!=\'S\' and nvl(health_card_appl_yn,\'N\')=\'N\' and nvl(hcare_only_yn,\'N\')=\'N\'\";   \n\t\t}\n\n\t\tif ( blnggrp == \"5\" ) \n\t\t{\n\t\tsql2 = \" nvl(status,\'X\' ) != \'S\' and nvl(health_card_appl_yn,\'N\')= \'N\' and nvl(hcare_only_yn,\'N\')=\'N\'\";\n\t\t}\n\n\t\tif (blnggrp == \"6\") \n\t\t{\n\t\tsql2 = \" nvl(status,\'X\' )!=\'S\' and blng_grp_id = \'\" + ExtBillingGroup + \"\' \";\n\t\t}\n\n\t\t// EPI TYPE ENH\n\n\t\tif ( blnggrp == \"7\" ) \n\t\t{\n\t\tsql2 = \" nvl(ae_yn,\'N\')=\'Y\' and nvl(status,\'X\' )!=\'S\' and  nvl(health_card_appl_yn,\'N\')=\'N\' and nvl(hcare_only_yn,\'N\')=\'N\' \";\n\t\t}\n\n\t\tif ( blnggrp == \"8\" ) \n\t\t{\n\t\tsql2 = \" nvl(dy_yn,\'N\')=\'Y\' and nvl(status,\'X\' )!=\'S\' and  nvl(health_card_appl_yn,\'N\')=\'N\' and nvl(hcare_only_yn,\'N\')=\'N\' \";\n\t\t}\n\t\t\n\t\t/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */\n\t\tvar restrictBlngGrp\t= document.forms[0].restrictBlngGrp.value;\n\t\tvar SrchByBlngGp\t= document.forms[0].SrchByBlngGp.value;\n\t\tvar login_user\t= document.forms[0].login_user.value;\n\t\tvar fin_auth_user_id\t= document.forms[0].fin_auth_user_id.value;\n\t\tif(restrictBlngGrp == true || restrictBlngGrp == \"true\") {\n\t\t\tsql2 = sql2 + \" and blng_grp_id NOT in (select c.blng_grp_id from BL_BLNG_GRP_RES_BY_USER c\";\n\t\t\tif(fin_auth_user_id != \"\") {\n\t\t\t\tsql2 += \" where UPPER(c.user_id) = UPPER(\'\"+fin_auth_user_id+\"\')\";\n\t\t\t} else {\n\t\t\t\tsql2 += \" where UPPER(c.user_id) = UPPER(\'\"+login_user+\"\')\";\n\t\t\t}\n\t\t\tsql2 += \" and c.blng_grp_id=a.blng_grp_id and trunc(sysdate) between c.restrict_date_From and nvl(c.restrict_date_to, trunc(sysdate))) \";\n\t\t}\n\t\t/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */\n\t\t\n\t\tsql = escape(sql1 + sql2);\t\t\n\t\t\n\t\tvar param =\"\";\n\n\t\t//var param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYNNN\";\n\n\t\t//Added for ML-MMOH-CRF-1433/starts\n\t\tif(SrchByBlngGp == true || SrchByBlngGp == \"true\") {\n\t\t\tparam = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YYYNNN\";\n\t\t}else{\n\t\t\t//param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYNNN\";\n\t\t\tparam = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYNNNNN\"; //modified against V210223\n\t\t}\n\t\t//Added for ML-MMOH-CRF-1433/ends\n\t\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\n\t\tvar arr=new Array();\t\t\n\n\t    if(retVal == null) retVal=\'\';\n\n\t\tif (retVal != null || retVal!=\"\")\n\t\t {\n\t\t\t\n\t\t\t  var retVal=unescape(retVal);\n\t \n\t\t\t  if(retVal != null && retVal.length>0)\n\t\t\t  {\n\t\t\t\t   arr=retVal.split(\"^~^\");\t\t\t\t   \n\n\t   \t\t\t   document.forms[0].billing_group_desc.value=arr[1];\n\t\t\t\t   //.substring(0,16);\n\t\t\t\t   document.forms[0].billing_group.value=arr[0];\t\t\n\t\t\t\t   \n\t\t\t\t   ref_src_code_YN=arr[3];\n\t\t\t\t\tpmry_ref_src_mand_YN = arr[4];\n\t\t\t\t\tsec_ref_src_mand_YN = arr[5];\n\n\t\t\t\t\tdocument.forms[0].currency_code_for_bg.value=arr[6];\n\t\t\t\t\tdocument.forms[0].currency_desc_for_bg.value=arr[7];\n\n\t\t\t\t   /*if (billinggroup.length == 0 || \n\t\t\t\t\t      (billinggroup.length > 0  && billinggroup != arr[0]))\n\t\t\t\t\t\t  */\n\n\t\t\t\t   document.forms[0].blnggrpappyn.value = \"Y\";\n\t\t\t\t   document.forms[0].BlngGrpStatus.value = \"\";\n\t\t\t\t   document.forms[0].blnggrpcatgappyn.value = \"Y\";\t\t\t\n\n\t\t\t\t   funChangeBillingGroup(document.forms[0].billing_group);\n\n\t\t\t\t    if(ref_src_code_YN==\"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_main_leg_disp\').style.display=\"inline\";\n\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_main_val_disp\').style.display=\"inline\";\n\t\t\t\t\t\tdocument.forms[0].referral_source_main_code.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].referral_source_main_desc.value=\"\";\n\t\t\t\t\t\tif(pmry_ref_src_mand_YN == \"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_main_mand_disp\').style.display=\"inline\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_main_mand_disp\').style.display=\"none\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_sub_leg_disp\').style.display=\"inline\";\n\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_sub_val_disp\').style.display=\"inline\";\n\t\t\t\t\t\tdocument.getElementById(\"referral_source_sub_code\").value=\"\";\n\t\t\t\t\t\tdocument.getElementById(\'referral_source_sub_desc\').value=\"\";\n\t\t\t\t\t\tif(sec_ref_src_mand_YN == \"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_sub_mand_disp\').style.display=\"inline\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_sub_mand_disp\').style.display=\"none\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tdocument.forms[0].cap_ref_src_dtl_flag.value=\"Y\";\n\t\t\t\t\t\tdocument.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;\n\t\t\t\t\t\tdocument.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;\n\t\t\t\t\t}\n\t\t\t\t\telse if(ref_src_code_YN==\"N\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_main_leg_disp\').style.display=\"none\";\n\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_main_val_disp\').style.display=\"none\";\n\t\t\t\t\t\tdocument.forms[0].referral_source_main_code.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].referral_source_main_desc.value=\"\";\n\n\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_sub_leg_disp\').style.display=\"none\";\n\t\t\t\t\t\tdocument.getElementById(\'ref_src_code_sub_val_disp\').style.display=\"none\";\n\t\t\t\t\t\tdocument.getElementById(\'referral_source_sub_code\').value=\"\";\n\t\t\t\t\t\tdocument.getElementById(\'referral_source_sub_desc\').value=\"\";\n\n\t\t\t\t\t\tdocument.forms[0].cap_ref_src_dtl_flag.value=\"N\";\n\t\t\t\t\t\tdocument.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;\n\t\t\t\t\t\tdocument.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;\n\t\t\t\t\t}\n\t\t\t\t\tcurr_code();//currency code desc \n\t\t\t  }\n\t\t\t  else\n\t\t\t  {\n\t\t\t\t  // funChangeBillingGroup(document.forms[0].billing_group);";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="\n\t\t\t\t   target.focus();\n\t\t\t  }\n\n\t\t }\n\t\n}\nfunction funChangeBillingGroup(obj)\n\t\t{\n//\t\t\t\tcallglholdercheck(obj);\t\t\t\t\n//\t\t\t\tfunHealthCardValue(obj);\n\t\t\t\tcallSettlements(obj);\t\n\t\t}\n\nfunction callSettlements(Obj)\n{\n\t\n\ttry\n\t{\n\t\tvar obj1=document.forms[0].billing_group.value;\n\t\tvar obj2 = document.forms[0].ins_auth_flag.value;\n\t\tvar obj3 = document.forms[0].clinic_code.value;\n\t\tvar obj4 = document.forms[0].visit_type_code.value;\n\t\tvar obj5 = document.forms[0].show_hide_blng_class.value;\n//\t\tvar obj6 = document.forms[0].bl_data_from_repos_yn.value;\n\t\tvar obj7 = document.forms[0].items_disabled.value;\n//\t\tvar obj8 = document.forms[0].calling_module_id.value;\n\t\tvar obj9 = document.forms[0].ext_settl_type.value;\t\n\t\tvar obj10 = document.forms[0].patient_id.value;\n\t\tvar query_string=document.forms[0].query_string.value;\n\t\n\t\tparent.frames[1].location.href=\'../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpBodyFrame.jsp?billing_group=\'+obj1+\'&ins_auth_flag=\'+obj2+\'&clinic_code=\'+obj3+\'&visit_type_code=\'+obj4+\'&show_hide_blng_class=\'+obj5+\'&items_disabled=\'+obj7+\'&id_fun=1&set_typ_from_frame1=\'+obj9+\'&patient_id=\'+obj10+\'&\'+query_string;\n\n\n\t}\n\tcatch(e)\n\t{\n\t}\n\n}\nasync function getBlngGrpSearch()\n\t{\n\t\tvar billing_group=document.forms[0].billing_group.value;\n\t\t\n\t\t\n\t\tif(billing_group==\"select\") billing_group=\"\";\n\n\t\tif(billing_group==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9301\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t\t\n\t\tif((billing_group!=\"\"))\n\t\t{\n\t\t\tvar retVal;\n\t\t\tvar dialogHeight= \"15\" ;\n\t\t\tvar dialogWidth\t= \"43\" ;\n\t\t\tvar dialogTop = \"205\" ;\n\t\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar url = \"../../eBL/jsp/BLBillingGrpDet.jsp?billing_group=\t\"+billing_group;\n\t\t\tretVal =await window.showModalDialog(url,arguments,features);\n\t\t}\n\t\t\n\t}\n\nfunction refsrclkup(ref_code,ref_desc,called_frm,clng_evnt)\n{\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( ref_desc.value == \"\")\n\t\t{\t\n\t\t\tref_code.value = \"\";\n\t\t\tref_desc.value = \"\";\n\t\t\tif(called_frm == \"M\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=\"\";\n\t\t\t}\n\t\t\telse if (called_frm == \"S\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=\"\";\n\t\t\t}\n\t\t\treturn;\n\t\t}\n\t}\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar locale=document.forms[0].locale.value;\n\tvar billing_group=document.forms[0].billing_group.value;\n\n\tvar retVal\t\t\t= new String();\t\t\n\tvar dialogTop\t\t\t= \"130\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"50\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\t\t\n\t\t\n\tvar title=getLabel(\"Common.referralsource.label\",\"common\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"20%,20%,20%,30%,10%\");               \n\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar short_desc=getLabel(\"Common.shortdescription.label\",\"common\");\n\tshort_desc=encodeURIComponent(short_desc);\n\tvar long_desc=getLabel(\"Common.longdescription.label\",\"common\");\n\tlong_desc=encodeURIComponent(long_desc);\n\tvar long_name=getLabel(\"Common.longname.label\",\"common\");\n\tlong_name=encodeURIComponent(long_name);\n\tvar org_type=getLabel(\"Common.OrganisationType.label\",\"common\");\n\torg_type=encodeURIComponent(org_type);\n\tvar column_descriptions = code+\",\"+short_desc+\",\"+long_desc+\",\"+long_name+\",\"+org_type;\n\n\tvar gov_leg = getLabel(\"eBL.GOVT_REFERRAL.label\",\"BL\");\n\tgov_leg=encodeURIComponent(gov_leg);\n\n\tvar pvt_leg = getLabel(\"eBL.PVT_REFERRAL.label\",\"BL\");\n\tpvt_leg=encodeURIComponent(pvt_leg);\n\n\tvar message = \'\';\n\t\t\n\tif (billing_group.length == 0) return;\n\n\tvar sql=\"called_for=REFSRCLKUP&locale=\"+locale+\"&episode_type=\"+episode_type;\n\n/*\n\tvar sql=\"Select REFERRAL_CODE REFERRAL_CODE,SHORT_DESC SHORT_DESC,LONG_DESC LONG_DESC,LONG_NAME LONG_NAME,decode(ORG_TYPE,\'G\',\'\"+gov_leg+\"\',\'P\',\'\"+pvt_leg+\"\') ORG_TYPE from AM_REFERRAL_LANG_VW where ((\'\"+episode_type+\"\' = \'R\' and SOURCE_USE_AT_REGN_YN=\'Y\') or (\'\"+episode_type+\"\' in (\'O\',\'E\') and SOURCE_USE_AT_VISIT_YN =\'Y\') or (\'\"+episode_type+\"\' in (\'I\',\'D\') and SOURCE_USE_AT_ADM_YN =\'Y\')) and language_id = \'\"+locale+\"\' and nvl(eff_status,\'E\')=\'E\'\";\n\n\tsql = escape(sql);\t\t\t\t\t\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(ref_desc.value)+\"&srch_by_clmn_index=3\"+\"&col_show_hide=YYYYY\";\n*/\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(ref_desc.value)+\"&srch_by_clmn_index=3\"+\"&col_show_hide=YYYYY\";\n\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\n\tvar arr=new Array();\t\t\t\t\t\n\t\t\n\tif(retVal == null) retVal=\'\';\t\n\t\n\tif (retVal != null || retVal != \"\")\n\t{\t\n\t\tvar retVal=unescape(retVal);\t\t\t\t\n\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\t\t\t   \n\n\t\t\tref_code.value=arr[0];\n\t\t\tref_desc.value=arr[1];\n\t\t\tvar ref_src_lng_name = arr[3];\n\n\t\t\tif(called_frm == \"M\")\n\t\t\t{\n\t\t\t\tif(ref_src_lng_name != \"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"visible\";\n\t\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=arr[3];\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if (called_frm == \"S\")\n\t\t\t{\n\t\t\t\tif(ref_src_lng_name != \"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"visible\";\n\t\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=arr[3];\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\t\n\t\telse\n\t\t{\n\t\t\tref_code.value=\"\";\n\t\t\tref_desc.value=\"\";\n\t\t\tif(called_frm == \"M\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=\"\";\n\t\t\t}\n\t\t\telse if (called_frm == \"S\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=arr[3];\n\t\t\t}\n\t\t}\n\t}\n\telse\n\t{\n\t\tref_code.value=\"\";\n\t\tref_desc.value=\"\";\n\t\tif(called_frm == \"M\")\n\t\t{\n\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\tdocument.getElementById(\'pmy_ref_src_lng_name\').alt=\"\";\n\t\t}\n\t\telse if (called_frm == \"S\")\n\t\t{\n\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\tdocument.getElementById(\'sec_ref_src_lng_name\').alt=arr[3];\n\t\t}\n\t}\n}\n\nfunction curr_code()\n{\n\tvar currency_desc_for_bg = document.forms[0].currency_desc_for_bg.value;\n\n\tif(currency_desc_for_bg != \"\")\n\t{\n\t\tdocument.getElementById(\'bg_curr_desc_disp\').style.display=\"inline\";\n\t\tdocument.getElementById(\'bg_curr_desc\').innerText=currency_desc_for_bg;\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\'bg_curr_desc_disp\').style.display=\"none\";\n\t\tdocument.getElementById(\'bg_curr_desc\').innerText=\"\";\n\n\t}\n}\n</script>\n<html>\t\n<head>\n\n";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\'curr_code();\'>\n<form name=\'\' id=\'\' method=\'post\'   scrolling=no >\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n<tr>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<td width=\"25%\" class=\"label\"><a href=\"javascript:getBlngGrpSearch();\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</a>&nbsp;&nbsp;<div id=\"bg_curr_desc_disp\" style=\"display:inline\"><Font color=\'red\'><b id=\"bg_curr_desc\"></b></font></div></td>\n<td class=\'fields\' width=\"75%\" nowrap colspan=3><input type=\'text\' name=\"billing_group_desc\" id=\"billing_group_desc\" maxlength=\'40\' size=\'40\' tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"  onBlur=\"return blnggrplkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"blnggrpbut\" id=\"blnggrpbut\" value=\'?\' onClick=\"return blnggrplkup(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<input type= \"hidden\" name=\"currency_code_for_bg\" id=\"currency_code_for_bg\"  value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type= \"hidden\" name=\"currency_desc_for_bg\" id=\"currency_desc_for_bg\"  value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<input type=\'hidden\' name=\'cap_ref_src_dtl_flag\' id=\'cap_ref_src_dtl_flag\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'referral_source_main_mand_YN\' id=\'referral_source_main_mand_YN\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'referral_source_sub_mand_YN\' id=\'referral_source_sub_mand_YN\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<tr>\n\t\n\t<td width=\"25%\" class=\"Label\">\n\t\t<div id=\'ref_src_code_main_leg_disp\' style=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</div>\n\t</td>\n\n\t<td width=\"25%\" class=\"fields\">\n\t\t<div id=\'ref_src_code_main_val_disp\' style=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t<input type=\'text\' name=\"referral_source_main_desc\" id=\"referral_source_main_desc\" maxlength=\'50\' size=\'25\' tabindex=\'0\'  value=\"\" onBlur=\"return refsrclkup(document.forms[0].referral_source_main_code,document.forms[0].referral_source_main_desc,\'M\',\'B\')\">\n\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcmainbut\" id=\"refsrcmainbut\" value=\'?\' onClick=\"return refsrclkup(document.forms[0].referral_source_main_code,document.forms[0].referral_source_main_desc,\'M\',\'C\')\" tabindex=\'0\'>\n\t\t\t<div id=\'ref_src_code_main_mand_disp\' style=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"pmy_ref_src_lng_name\" id=\"pmy_ref_src_lng_name\" align=\'center\' style=\"visibility:hidden\">\n\t\t</div>\n\t</td>\n\t\n\t<td width=\"25%\" class=\"Label\">\n\t\t<div id=\'ref_src_code_sub_leg_disp\' style=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</div>\n\t</td>\n\t\n\t<td width=\"25%\" class=\"fields\">\n\t\t<div id=\'ref_src_code_sub_val_disp\' style=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<input type=\'text\' name=\"referral_source_sub_desc\" id=\"referral_source_sub_desc\" maxlength=\'50\' size=\'25\' tabindex=\'0\'  value=\"\" onBlur=\"return refsrclkup(document.forms[0].referral_source_sub_code,document.forms[0].referral_source_sub_desc,\'S\',\'B\')\">\n\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcsubbut\" id=\"refsrcsubbut\" value=\'?\' onClick=\"return refsrclkup(document.forms[0].referral_source_sub_code,document.forms[0].referral_source_sub_desc,\'S\',\'C\')\" tabindex=\'0\'>\n\t\t\t<div id=\'ref_src_code_sub_mand_disp\' style=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"sec_ref_src_lng_name\" id=\"sec_ref_src_lng_name\" align=\'center\' style=\"visibility:hidden\">\n\t\t</div>\n\t</td>\n\t\n</tr>\n\n<input type=\'hidden\' name=\'referral_source_main_code\' id=\'referral_source_main_code\' value=\"\">\n<input type=\'hidden\' name=\'referral_source_sub_code\' id=\'referral_source_sub_code\' value=\"\">\n\n</table>\n<input type=\'hidden\' name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=\'hidden\' name=\'blnggrp\' id=\'blnggrp\' \tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\"ext_billing_group\" id=\"ext_billing_group\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\t\n<input type=\'hidden\' name=\'CitizenYn\' id=\'CitizenYn\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'blnggrpappyn\' id=\'blnggrpappyn\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\t\t\n<input type=\'hidden\' name=\'blnggrpcatgappyn\' id=\'blnggrpcatgappyn\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'BlngGrpStatus\' id=\'BlngGrpStatus\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\t\n<input type=\'hidden\' name=\"bl_data_from_repos_yn\" id=\"bl_data_from_repos_yn\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\t\n<input type=\'hidden\' name=\'ins_auth_flag\' id=\'ins_auth_flag\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\'hidden\' name=\"items_disabled\" id=\"items_disabled\" value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\"calling_module_id\" id=\"calling_module_id\" value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\'hidden\' name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\n<input type=\'hidden\' name=\"ext_settl_type\" id=\"ext_settl_type\" value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'show_hide_blng_class\' id=\'show_hide_blng_class\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\"billing_group\" id=\"billing_group\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type=\'hidden\' name=\"primary_blng_grp\" id=\"primary_blng_grp\"  value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\n<input type=\'hidden\' name=\'fin_class_flag_YN\' id=\'fin_class_flag_YN\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=\'hidden\' name=\'autoFinChk\' id=\'autoFinChk\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n<input type=\'hidden\' name=\'class_code\' id=\'class_code\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n<!--Added for ML-MMOH-CRF-1433-->\n<input type=\'hidden\' name=\'SrchByBlngGp\' id=\'SrchByBlngGp\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<!-- Added V20180709-Aravindh/GHL-CRF-0427/Starts -->\n<input type=\'hidden\' name=\'restrictBlngGrp\' id=\'restrictBlngGrp\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=\'hidden\' name=\'login_user\' id=\'login_user\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type=\'hidden\' name=\'fin_auth_user_id\' id=\'fin_auth_user_id\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n<!-- Added V20180709-Aravindh/GHL-CRF-0427/Ends -->\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

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

	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	ResultSet  rs2 = null ;
	ResultSet rset = null;

	try
	{
	con = ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);
	request.setCharacterEncoding("UTF-8");
	String locale=(String)session.getAttribute("LOCALE");
	String fin_class_flag_YN="N", autoFinChk="N", class_code="";

	String query_string=request.getQueryString();
	String primary_blng_grp= request.getParameter("primary_blng_grp");
	if(primary_blng_grp == null) primary_blng_grp="";
	fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
	if(fin_class_flag_YN == null) fin_class_flag_YN="N";

	autoFinChk = request.getParameter("autoFinChk");
	if(autoFinChk == null) autoFinChk="N";

	class_code = request.getParameter("class_code");
	if(class_code == null) class_code="N";
	/*Added for ML-MMOH-CRF-1433/starts*/
	boolean SrchByBlngGp = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_MODIFY_FIN_DTL_BIL_GRP");
	/*Added for ML-MMOH-CRF-1433/ends*/
	/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */
	boolean restrictBlngGrp = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_BLNG_GRP_RESTRICT_FOR_USER");
	String login_user = (String) session.getAttribute("login_user");
	if(login_user == null) {
		login_user = "";
	}
	String fin_auth_user_id = (String) request.getParameter("fin_auth_user_id");
	if(fin_auth_user_id == null) {
		fin_auth_user_id = "";
	}
	/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */

/*
	if(autoFinChk.equals("Y"))
	{
		HashMap bl_data=(HashMap)session.getAttribute("financial_details");
		if(!(bl_data==null || bl_data.isEmpty()))
		{
			System.err.println("Inside Class Loop in bodyedit.jsp");
			class_code = ((String)bl_data.get("class_code")).trim();
		}
	}
*/		

            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String facility_id  =  ""; 

	//String strQuery = " ";

//	String strBlngClass ="";
//	String strBillType ="";
//	String mbilling_class="",memployer_code="",package_flag="";
//	String pkg_bill_type = "",	pkg_bill_no = "";

	String mbilling_group="";
	String ins_auth_flag="",upd_pat_flag="";

	String clinic_code ="",visit_type_code="",show_hide_blng_class="";
//Unused Var's
/*
	String display="N",display_mode="";
	String strEpisodeType = ""; //request.getParameter("episode_type");  
	String strSpecialSchemeBlngGrpDesc="";
*/
	String billing_group="";
	String strExtSettlType = "";
	String nationalityyn = "";
	String strdfltbgyn = "N";
	String srtencdfltbgyn="N";
	String strSplSchemeBlngGrpPresent = "0";
	String strblnggrp ="0";
	String strBlngGrpAppYN= "Y";
	String strRepositoryYN="";
	String strBlngGrpCatgAppYN = "Y";
	String strBlngGrpStatus="";
	String strCategory = "";
	String care_locn_type_ind="";
	String priority="";
	String strCitizenYn = "N";
	String strBillGrpId = "";
	String strBillingQuery ="";
	String strExtBillingGroup = "";
	String strArrayHealthCard_YN="";
	String strArrayBillingApp_YN="";	
	String strSpecialSchemeBlngGrp="";	
	
	String strModuleId = "";
	String alt_id1_exp_date = "";
	String strBillingOverride = "Y";
	String strItemsDisabled = "";
	boolean boolChangeBillQry = false;
	String str_slmt_type_code="";

	String p_patient_class  ="",episode_type="";

//	billing_group=request.getParameter("billing_group");
	if(billing_group==null) billing_group="";

	ins_auth_flag = request.getParameter("ins_auth_flag");
	if(ins_auth_flag==null) ins_auth_flag = "N";
	
	upd_pat_flag=request.getParameter("upd_pat_flag");
	if(upd_pat_flag==null) upd_pat_flag = "N";

	visit_type_code = request.getParameter("visit_type_code");
	if(visit_type_code==null) visit_type_code="";

	strRepositoryYN=request.getParameter("bl_data_from_repos_yn");
	if(strRepositoryYN==null) strRepositoryYN="";

	show_hide_blng_class=request.getParameter("show_hide_blng_class");
	if(show_hide_blng_class==null) show_hide_blng_class="SHOW";
	
	nationalityyn = request.getParameter("nationality_yn");		
	if (nationalityyn == null) nationalityyn = "";	
	
	strModuleId = request.getParameter("calling_module_id");
	if(strModuleId==null) strModuleId="";

	p_patient_class = request.getParameter("patient_class");
	if(p_patient_class == null) p_patient_class="";

	if(p_patient_class ==null || (p_patient_class.equals("")))
	{
		if(strModuleId.equals("MP")) p_patient_class="XT";
		else if(strModuleId.equals("EM")) p_patient_class="EM";
		else if(strModuleId.equals("OP")) p_patient_class="OP";
		else if(strModuleId.equals("IP")) p_patient_class="IP";
		else if(strModuleId.equals("DC")) p_patient_class="DC";
	}

	if(strModuleId.equals("MP")) episode_type="R";
	else if(strModuleId.equals("AE")) episode_type="E";
	else if(strModuleId.equals("OP")) episode_type="O";
	else if(strModuleId.equals("IP")) episode_type="I";
	else if(strModuleId.equals("DC")) episode_type="D";
	
	facility_id = (String)httpSession.getValue("facility_id");	
	if(facility_id==null) facility_id="";

	care_locn_type_ind = 	request.getParameter("care_locn_type_ind");
	if( care_locn_type_ind==null || care_locn_type_ind.equals("")) 	care_locn_type_ind ="";

	clinic_code = request.getParameter("clinic_code");
	if(clinic_code==null) clinic_code="";

	priority=request.getParameter("priority");
	if(priority==null)	priority ="";

	String patient_id = request.getParameter("patient_id");
	if(patient_id==null) patient_id="";

	strItemsDisabled=request.getParameter("items_disabled");
	if(strItemsDisabled==null) strItemsDisabled="";

	strdfltbgyn = request.getParameter("dfltbgyn");
	if ( strdfltbgyn == null) strdfltbgyn = "N";

	srtencdfltbgyn = request.getParameter("encdfltbgyn");
	if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";

	String str_blng_grp_id = "";
	String str_short_desc = "";	

	String str_currency_code_for_bg = "",str_currency_desc_for_bg="";

	boolean boolPatientFoundMP = false;
	boolean boolSecurity = false;	

	if (strRepositoryYN.equals("Y"))
	{
		strExtBillingGroup=billing_group;
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
			//out.println("Exception 3::"+excep);
			excep.printStackTrace();
		}
	}

	if (strExtBillingGroup == null) strExtBillingGroup = "";
	if (strExtSettlType == null) strExtSettlType="";

	mbilling_group=billing_group;
/* Commented and moved down for PE Changes
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
		if(rs != null) rs.close();
		pstmt.close();
	}
	catch(Exception e)
	{
		System.out.println("Exception in 1:"+e);
		e.printStackTrace();
	}
*/
	if(!patient_id.equals(""))
	{
		try
		{
			String sqlCiti = "select citizen_yn,to_char(alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date from mp_patient where patient_id = ? ";
			pstmt = con.prepareStatement(sqlCiti);
			pstmt.setString(1,patient_id);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() )
				{  
					strCitizenYn = rs2.getString("citizen_yn");
					alt_id1_exp_date = rs.getString("alt_id1_exp_date");
					boolPatientFoundMP = true;
				}
			}
			if(rs2 != null) rs2.close();
			pstmt.close();	
			if (alt_id1_exp_date == null) alt_id1_exp_date = "";
			if(strCitizenYn == null) strCitizenYn="N";
		}
		catch(Exception e)
		{
			System.out.println("Exception1:"+e);
			e.printStackTrace();
		}
	}
/* Commented as these variables are available as IN Parameters
	try
	{
	String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg,nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N') last_enc_bg from bl_mp_param ";
	pstmt = con.prepareStatement(sql0);
	rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{
			while( rs2.next() )
			{  
				strdfltbgyn = rs2.getString("bg");
				srtencdfltbgyn=rs2.getString("last_enc_bg");
			}
		}
		if(rs2 != null) rs2.close();
		pstmt.close();		
	}
	
	catch(Exception e)
	{
		System.out.println("Exception2:"+e);
		e.printStackTrace();
	}
	if ( strdfltbgyn == null) strdfltbgyn = "N";
	if ( srtencdfltbgyn == null) srtencdfltbgyn="N";
*/
		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}

	if (strModuleId.equals("MP"))
	{
		strCitizenYn = nationalityyn;
		strdfltbgyn = "Y";
	}

if (strModuleId.equals("MP") && (boolPatientFoundMP == true))	
	{
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+
						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" REF_YN , status , category "+
							" FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE "+
							" ( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+
							"  (((NVL(REF_YN,'N')='Y' AND NVL(HCARE_ONLY_YN,'N') = 'N' AND "+
							" nvl(status,'X' )!='S') "+
							" OR BLNG_GRP_ID = ? )) and language_id=? order by 2";

	   strblnggrp = "1";
		
	}

	if (strModuleId.equals("MP") && (boolPatientFoundMP == false))
	{
		strBillingQuery =" SELECT BLNG_GRP_ID,short_desc, "+
						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
						" REF_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
						" WHERE "+
						" ( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+	
						" (((NVL(REF_YN,'N')='Y' AND NVL(REF_VALID_FOR_REGN_YN,'N')='Y' AND "+
						" nvl(status,'X' )!='S')  AND NVL(HCARE_ONLY_YN,'N') = 'N'  "+
						" OR BLNG_GRP_ID = ? )) and language_id=? order by 2";	

		strblnggrp = "2";
		
	}

	//if (strModuleId.equals("OP")||strModuleId.equals("AE"))

	if (strModuleId.equals("OP"))
	{

		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" OP_YN , status , category "+
							" FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE "+
							" ((( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
							" ((NVL(OP_YN,'N')='Y' AND "+
							" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N')) "+
							" OR ( BLNG_GRP_ID = ? AND NVL(?,'N') = 'Y' )))  and language_id=? order by 2";
		strblnggrp = "3";
	
	 
	}
	

	//if (strModuleId.equals("IP") || strModuleId.equals("DC"))

	if (strModuleId.equals("IP"))
	{
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
						" IP_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE " + 
							" ((( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
								" ((NVL(IP_YN,'N')='Y' AND "+
							" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N'))  "+
							" OR (BLNG_GRP_ID = ? AND NVL(?,'N') = 'Y' ) )) and language_id=? order by 2";
		strblnggrp = "4";

	}

	if (strBillingQuery.equals("")) 
	{
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+
						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
						" REF_YN , status , category  FROM BL_BLNG_GRP_LANG_VW WHERE "+
							" ((( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
							" ( nvl(status,'X' )!='S'    AND ( NVL(HEALTH_CARD_APPL_YN,'N')= 'N' AND NVL(HCARE_ONLY_YN,'N')='N')  "+ 
							" OR BLNG_GRP_ID = ? ))) and language_id=? order by 2";
		
		strblnggrp = "5";


		

	}

	if (strRepositoryYN.equals("Y") && strBillingOverride.equals("N") && strModuleId.equals("MP") &&  (boolPatientFoundMP ==false) &&(!strExtBillingGroup.equals("")))
	{
		boolChangeBillQry =true;
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+
						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
						"  REF_YN , status , category  FROM BL_BLNG_GRP_LANG_VW WHERE "+
							" ( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+
							" (( nvl(status,'X' )!='S' "+ 
							" AND BLNG_GRP_ID = ? )) and language_id=?";
		strblnggrp = "6";
		
	}


	if (strModuleId.equals("AE"))
	{
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" AE_YN , status , category "+
							" FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE " +
							" ((( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
							" ((NVL(AE_YN,'N')='Y' AND "+
							" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N')) "+
							" OR ( BLNG_GRP_ID = ? AND NVL(?,'N') = 'Y' ))) and language_id=? order by 2";
		strblnggrp = "7";
	 
	}

	if (strModuleId.equals("DC"))
	{
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
						" DY_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE " + 
							" ((( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
							" ((NVL(DY_YN,'N')='Y' AND "+
							" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N'))  "+
							" OR (BLNG_GRP_ID = ? AND NVL(?,'N') = 'Y' ))) and language_id=? order by 2";
		strblnggrp = "8";

	}

	if (
		((strModuleId.equals("MP")) && (boolPatientFoundMP == true)) ||
		((strModuleId.equals("IP") || strModuleId.equals("DC") || strModuleId.equals("OP")||strModuleId.equals("AE")) && (boolPatientFoundMP == true))
	   )
	{
		boolSecurity = true;
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

	try
	{	
		String query="select BL_eBLCOMMON.BL_GET_ENCNTR_DEFAULT_BG(?,?,?,?,?) from dual";		
		pstmt = con.prepareStatement(query);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,care_locn_type_ind);
		pstmt.setString(3,clinic_code);
		pstmt.setString(4,priority);
		pstmt.setString(5,strCitizenYn);
		rset = pstmt.executeQuery();

		if(rset!=null && rset.next())
		 {
			strBillGrpId = rset.getString(1); 
		 }
				
		if ( strBillGrpId == null ) strBillGrpId = "";
		if(rset != null) rset.close();
			pstmt.close();	
	}
	catch(Exception e)
	{
		System.out.println("Exception2:"+e);
		e.printStackTrace();			
	}		

	pstmt = con.prepareStatement( strBillingQuery ) ;
	
	if(strModuleId.equals("MP") || strBillingQuery.equals("")){
		pstmt.setString(1,strCitizenYn);
		pstmt.setString(2,mbilling_group);
		pstmt.setString(3,locale);
	}
	if(strModuleId.equals("OP") || strModuleId.equals("IP") || strModuleId.equals("AE") || strModuleId.equals("DC")){
		pstmt.setString(1,strCitizenYn);
		pstmt.setString(2,mbilling_group);
		pstmt.setString(3,strdfltbgyn);
		pstmt.setString(4,locale);
	}
	if (strRepositoryYN.equals("Y") && strBillingOverride.equals("N") && strModuleId.equals("MP") &&  (boolPatientFoundMP ==false) &&(!strExtBillingGroup.equals(""))){
		pstmt.setString(1,strCitizenYn);
		pstmt.setString(2,strExtBillingGroup);
		pstmt.setString(3,locale);
	}
		
	rs = pstmt.executeQuery();

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
		}
		if ((boolRecordFound == false) && (boolChangeBillQry == true))
		{
			str_blng_grp_id = blng_grp_id;
			str_short_desc = short_desc;
		}			
			
	}

	if(str_blng_grp_id==null || str_blng_grp_id=="") str_blng_grp_id="";

	if(!str_blng_grp_id.equals(""))
	{
		String currency_desc_for_bg_qry="Select CURRENCY_CODE,CURRENCY_DESC from bl_blng_grp_lang_vw where blng_grp_id='"+str_blng_grp_id+"' and language_id='"+locale+"'";
//		System.out.println("currency_desc_for_bg_qry:"+currency_desc_for_bg_qry);
		pstmt = con.prepareStatement( currency_desc_for_bg_qry ) ;
		rs = pstmt.executeQuery();

		if( rs != null )
		{
			while( rs.next() ) 
			{
				str_currency_code_for_bg = rs.getString(1);
				str_currency_desc_for_bg = rs.getString(2);
			}
			if(str_currency_code_for_bg == null) str_currency_code_for_bg="";
			if(str_currency_desc_for_bg == null) str_currency_desc_for_bg="";

			if (rs != null) rs.close();
				pstmt.close();	
		}	
	}
//	System.out.println("str_currency_code_for_bg:"+str_currency_code_for_bg);
//	System.out.println("str_currency_desc_for_bg:"+str_currency_desc_for_bg);


	if (strSplSchemeBlngGrpPresent==null||strSplSchemeBlngGrpPresent.equals("null"))		
		strSplSchemeBlngGrpPresent="0";		
	if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
		strBlngGrpAppYN = "N";		
	if(rs != null) rs.close();
	pstmt.close();		

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(str_short_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);

	String referral_source_capture_YN="N";
	String referral_source_main_mand_YN="N";
	String referral_source_sub_mand_YN="N";
	String ref_src_code_disp="";
	String ref_src_code_main_mand_disp ="";
	String ref_src_code_sub_mand_disp = "";
	String ref_src_code_qry="select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N'),nvl(REF_SOURCE_MAIN_MAND_YN,'N'),nvl(REF_SOURCE_SUB_MAND_YN,'N') from bl_blng_grp where BLNG_GRP_ID='"+str_blng_grp_id+"'";
//	System.out.println("ref_src_code_qry Secondary Ins Head File:"+ref_src_code_qry);
	
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
		e.printStackTrace();
	}
		
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
//	System.out.println("ref_src_code_disp:"+ref_src_code_disp);
//	System.out.println("referral_source_main_mand_YN:"+referral_source_main_mand_YN);
//	System.out.println("referral_source_sub_mand_YN:"+referral_source_sub_mand_YN);

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(str_currency_code_for_bg));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(str_currency_desc_for_bg));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(referral_source_capture_YN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(referral_source_main_mand_YN));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(referral_source_sub_mand_YN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ref_src_code_main_mand_disp));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ref_src_code_sub_mand_disp));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strblnggrp));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strExtBillingGroup));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strCitizenYn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strBlngGrpAppYN));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strBlngGrpCatgAppYN));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strBlngGrpStatus));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strRepositoryYN));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ins_auth_flag));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strItemsDisabled));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strExtSettlType));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(show_hide_blng_class));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(str_blng_grp_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(primary_blng_grp));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(fin_class_flag_YN));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(autoFinChk));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(SrchByBlngGp));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(restrictBlngGrp));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(fin_auth_user_id));
            _bw.write(_wl_block53Bytes, _wl_block53);

	}
	
	catch(Exception ee)
	{
		out.println("Exception in main try"+ee);
		ee.printStackTrace();
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block54Bytes, _wl_block54);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PMY_REF_SRC.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEC_REF_SRC.label", java.lang.String .class,"key"));
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
}
