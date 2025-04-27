package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.apache.commons.lang.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import com.ehis.util.*;
import eBL.Common.*;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetailsinsbodyedit_aprer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsInsBodyEdit_APRER.jsp", 1743663663870L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n<html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n<script Language=\'javaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script language=\"javascript\" src=\'../../eBL/js/AddModifyPatFinDetailsInsBodyPkgApprvDtls.js\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n \n</head>\n<script>\nasync function callPolicyDetails(count){\n\n\tvar dialogHeight= \"34\" ;\n\tvar dialogWidth\t= \"84\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status: \" + status + \"; scroll=auto; \";\n\tvar arguments\t= \"\" ;\t\n\t\t\n\tvar payerGroup=document.add_modify_pat_fin_det_ins_bodyedit.ins_cust_group_code.value;\n\tvar payerCode=document.add_modify_pat_fin_det_ins_bodyedit.cust_3.value;\n\tvar policy=document.add_modify_pat_fin_det_ins_bodyedit.policy_type_code.value;\t\n\tif(payerGroup==\"\"|| payerCode==\"\" || policy==\"\"){\n\t\treturn;\n\t}\n\tvar startDate=document.add_modify_pat_fin_det_ins_bodyedit.policy_start_date.value;\t\n\tvar endDate=document.add_modify_pat_fin_det_ins_bodyedit.policy_exp_date.value;\t\n\tvar priority=document.add_modify_pat_fin_det_ins_bodyedit.priority.value;\n\tvar policyNo=document.add_modify_pat_fin_det_ins_bodyedit.policy_no.value;\n\tvar episodeType=document.add_modify_pat_fin_det_ins_bodyedit.episode_type.value;\n\t//alert(\"details>>>\"+payerGroup+\"/\"+payerCode+\"/\"+policy+\"/\"+startDate+\"/\"+endDate+\"/\"+priority+\"/\"+policyNo+\"/\"+episodeType);\n\n\t// Patient Id Parameter is passed as null to get Policy Details, If patient_id,episode_id,visit_id,acctseq  is given then Encounter specific Policy Defn will be Loaded\n\tvar queryParams=\'mode=modify&patinetId=&payergroupCode=\'+ payerGroup  +\n\t\'&payerCode=\'+payerCode+\'&policyCode=\'+policy+\'&startDate=\'+startDate+\'&endDate=\'+endDate+\'&visitId=\'+\'&acctSeq=&priority=\'+priority+\n\t\'&policyNo=\'+policyNo+\'&episodeType=\'+episodeType+\'&episodeId=\'+\'&auth=N\';\n\t\t\n\tvar retVal =await window.showModalDialog(\'../../eBL/jsp/RcrdApprovalPolicyDefinitionMainFrame.jsp?\'+queryParams,arguments,features);\n}\n<!-- 08/07/2013\tKarthikeyan K\tMMS-QH-CRF-0010\t36789 starts-->\nfunction validAcrossEncounters(){\n\n\tvar pyrGrp=document.forms[0].ins_cust_group_code.value;\n\tvar pyr=document.forms[0].cust_3.value;\n\tvar pcyCd =document.forms[0].policy_type_code.value;\n\tvar patClass=document.forms[0].p_patient_class.value;\n\tvar patient_id=document.forms[0].patient_id.value;\n\tvar across_encounter=document.forms[0].acrossEncounter.value;\n\tvar priority=document.forms[0].priority.value;\n\tvar facility_id=document.forms[0].facility_id.value;\n\t//alert(\'across_encounter:priority\'+across_encounter+priority);\n\tif(pyrGrp!=\'\' && pyr!=\'\' & pcyCd!=\'\'){\n\tvar xmlhttp; \n\tif (window.XMLHttpRequest)\n\t  {// code for IE7+, Firefox, Chrome, Opera, Safari\n\t  xmlhttp=new XMLHttpRequest();\n\t  }\n\telse\n\t  {// code for IE6, IE5\n\t // xmlhttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t xmlHttp = new XMLHttpRequest();\n\t  }\n\n\txmlhttp.onreadystatechange=function()\n\t  {\n\t  if (xmlhttp.readyState==4 && xmlhttp.status==200)\n\t    {\n\n\t\tvar response=xmlhttp.responseText;\n\t\tvar validAcrossEnc = response.substring(response.indexOf(\"~\")+1,response.indexOf(\"~\")+2);\n\n\t\tif(validAcrossEnc==\'Y\'){\n\t\tdocument.getElementById(\'across_encounter_link\').disabled = false; \n\t\t}else{\n\t\tdocument.getElementById(\'across_encounter_link\').disabled = true; \n\t\t}\n\t    }\n\t  }\n\n\txmlhttp.open(\"POST\",\"BLInsuranceValidations.jsp?called_from=chk_validity_across_encounters&cust_group_code=\"+pyrGrp+\"&cust_code=\"+pyr+\"&policy_type_code=\"+pcyCd+\"&patClass=\"+patClass+\"&patient_id=\"+patient_id+\"&across_encounter=\"+across_encounter+\"&priority=\"+priority+\"&facility_id=\"+facility_id,true);\n\txmlhttp.send(null);\n\t}\n}\n\nasync function acrossEncountersLink(){\n\tvar pyrGrp=document.forms[0].ins_cust_group_code.value;\n\tvar pyr=document.forms[0].cust_3.value;\n\tvar pcyCd =document.forms[0].policy_type_code.value;\n\tvar ins_cust_group_name =document.forms[0].ins_cust_group_name.value;\n\tvar payer_desc =document.forms[0].payer_desc.value;\n\tvar policy_type_desc =document.forms[0].policy_type_desc.value;\n\tvar patient_id =document.forms[0].patient_id.value;\n\tvar patClass=document.forms[0].p_patient_class.value;\n\tvar  encGrpId=document.forms[0].acrossEncounter.value;\n\tvar priority = document.forms[0].priority.value;\n\t/*\n\tvar dialogUrl = \"../../eBL/jsp/BLPolicyValidAcrossEncounters.jsp?title=Policy Across Encounters&cust_group_code=\"+pyrGrp+\"&cust_code=\"+pyr+\"&policy_type_code=\"+pcyCd+\"&ins_cust_group_name=\"+ins_cust_group_name+\"&payer_desc=\"+payer_desc+\"&policy_type_desc=\"+policy_type_desc+\"&patient_id=\"+patient_id+\"&patClass=\"+patClass;\n\t\n\t*/\n\t\n\tvar dialogUrl       = \"../../eBL/jsp/EncounterSpecAcrossEncounter.jsp?title=Across Encounters\"+\n\t\"&payerGroup=\"+pyrGrp+\"&payer=\"+pyr+\"&policy=\"+pcyCd+\"&episodeType=\"+patClass+\n\t\"&encGrpId=\"+encGrpId+\"&patientId=\"+patient_id+\"&priority=\"+priority;\n\t\n\t\n\tvar dialogFeatures  = \"dialogHeight:\" + \"20\" + \"; dialogWidth:\" + \"50\" +\" ; scroll=auto; \";\n\t \n\tvar  returnVal =await window.showModalDialog(dialogUrl,\'Across Encounters\',dialogFeatures);\n\t\n\t//alert(\'returnValue \'+returnVal);\n\tif(returnVal != \'undefined\' && returnVal != \'null\' && returnVal != undefined && returnVal != null)\n\tdocument.forms[0].acrossEncounter.value=returnVal;\n\t//alert(document.forms[0].acrossEncounter.value);\n}\n<!-- 08/07/2013\tKarthikeyan K\tMMS-QH-CRF-0010\t36789 ends-->\nasync function callPolicy(plcyEnctr,plcyEpisdid,patntId,epsdType,vistId,acseq,plcyno){ // karthik added code INCLUDE_POLICY_DETAILS_CRF\n\t\n\t/* Karthik added the below Function to Authenticated User to check User Credentials to modify Policy  - Starts */\n\tif(doUserAuthenticationValidationMain(document.forms[0].login_user.value)==true)\n\t{\n\t\tawait callPolicyLink(plcyEnctr,plcyEpisdid,patntId,epsdType,vistId,acseq,plcyno);\n\t}else{\n\t\t\n\t\tvar dialogHeight= \"14\" ;\n\t\tvar dialogWidth\t= \"22\" ;\n\t\tvar dialogTop = \"225\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\t\t\t\n\t\t\n\t\tvar retVal =await window.showModalDialog(\"../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp\",arguments,features);\n\t\tvar successfulUser=retVal[3];\n\n\t\tif(doUserAuthenticationValidationMain(successfulUser)==true){\n\t\t\tawait callPolicyLink(plcyEnctr,plcyEpisdid,patntId,epsdType,vistId,acseq,plcyno);\n\t\t}else{\n\t\t\talert(\"User \"+successfulUser+\" dont have permissions to Add/Modify Payer\");\n\t\t}\n\t\t\n\t}\n\t/* Karthik added the below Function to Authenticated User to check User Credentials to modify Policy  - Ends */\n}\n\nfunction callPolicyLink(plcyEnctr,plcyEpisdid,patntId,epsdType,vistId,acseq,plcyno){\n\tvar pyrGrp=document.forms[0].ins_cust_group_code.value;\n\tvar pyr=document.forms[0].cust_3.value;\n\tvar pcyCd=document.forms[0].policy_type_code.value;\n\tvar pcyNo=document.forms[0].policy_no.value;\n\tvar priority=document.forms[0].priority.value;\n\tvar policy_start_date=document.forms[0].policy_start_date.value;\n\tvar policy_exp_date=document.forms[0].policy_exp_date.value;\n\t\n\tvar policyOrEncounter= document.forms[0].plcyorEncounter.value;\n//\talert(\' policy or encounter =\'+plcyEnctr+\' episode id =\'+plcyEpisdid);\n\t\n\tvar dialogUrl = \"../../eBL/jsp/PolicyDetailsResultFrame.jsp?\"+\n\t\"title=Policy Coverage Details\"+\n\t\"&startDate=\"+policy_start_date+\n\t\"&endDate=\"+policy_exp_date+\n\t\"&mode=modify\"+\n\t\"&facility_id=\"+\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\'+\n\t\"&payergroupCode=\"+pyrGrp+\n\t\"&payerCode=\"+pyr+\n\t\"&policyCode=\"+pcyCd+\n\t\"&patientId=\"+patntId+\n\t\"&visitId=\"+vistId+\n\t\"&acctSeq=\"+acseq+\n\t\"&priority=\"+priority+\n\t\"&episodeType=\"+epsdType+\n\t\"&episodeId=\"+plcyEpisdid+\n\t\"&policyNo=\"+plcyno+\n\t\"&policyEncounter=\"+policyOrEncounter+\n\t\"&priorityKey=\"+priority+\"~\"+pyrGrp+\"~\"+pyr+\"~\"+pcyCd+\"~\"+pcyNo;\n\n\t//alert(\'dialog URL \'+dialogUrl);\n\t\n\t\n\tvar dialogFeatures  = \"dialogHeight:\" + \"30\" + \"; dialogWidth:\" + \"75\" +\" ; scroll=auto; \";\n\twindow.showModalDialog(dialogUrl,\'Policy Details\',dialogFeatures);\t\t\n}\nfunction cancel()\n{\n//\tparent.window.returnValue = \"manivel\";\n\tparent.window.close();\n}\n\t\nfunction showCalendar_loc(Val1, Val2)\n{\t\n\tif (Val2.disabled == true)\t\t\n\t{\n\t\treturn false;\n\t}\n\telse\n\t{\n\t\treturn showCalendar(Val1);\n\t}\n}\n\n\nfunction checkValues()\n{\n\tvar action=document.forms[0].action.value;\n\tvar locn=document.forms[0].locn.value;\n\tvar blng_grp_select=\"\";\n\tif(action==\"add\" && locn==\"outside\")\n\t{\n\t\tblng_grp_select=document.forms[0].select_billing_group.value;\n\t\tif(blng_grp_select==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9301\",\"BL\"));\n\t\t\tdocument.forms[0].select_billing_group.focus();\n\t\t\treturn false;\n\t\t}\n\t}\n\tvar cust_group_name=document.forms[0].ins_cust_group_name.value;\n\tvar payer_desc=document.forms[0].payer_desc.value;\n\tvar priority=document.forms[0].priority.value;\n\tvar policy_type_desc=document.forms[0].policy_type_desc.value;\n\tvar policy_no=document.forms[0].policy_no.value;\n//\tif(!CheckChars_local(document.forms[0].policy_no))\n\tif(!CheckCharsAllLang_local(document.forms[0].policy_no))\n\t{\n\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\"common\"));\n\t\tdocument.forms[0].policy_no.select();\n\t\treturn false;\n\t}\n\tvar policy_start_date=document.forms[0].policy_start_date.value;\n\tvar policy_exp_date=document.forms[0].policy_exp_date.value;\n\tvar credit_auth_ref=document.forms[0].credit_auth_ref.value;\n//\tif(!CheckChars_local(document.forms[0].credit_auth_ref))\n\tif(!CheckCharsAllLang_local(document.forms[0].credit_auth_ref))\n\t{\n\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\"common\"));\n\t\tdocument.forms[0].credit_auth_ref.select();\n\t\treturn false;\n\t}\n\n\tvar credit_auth_date=document.forms[0].credit_auth_date.value;\n\t\n\tvar cred_auth_req_yn = document.forms[0].cred_auth_req_yn.value;\n\tvar cred_auth_mand_capt_yn = document.forms[0].cred_auth_mand_capt_yn.value;\n\n\tvar credit_apprd_amt=document.forms[0].credit_apprd_amt.value;\n\tvar credit_apprd_days=document.forms[0].credit_apprd_days.value;\n\tvar policy_eff_frm_date=document.forms[0].policy_eff_frm_date.value;\n\tvar policy_eff_to_date=document.forms[0].policy_eff_to_date.value;\n\n\tvar modify_refresh=document.forms[0].modify_refresh.value;\n\tvar restricted_YN=document.forms[0].restricted_YN.value;\n\n\tvar restrict_check=document.forms[0].restrict_check.value;\n\tvar apprd_amt_restrict_check=document.forms[0].apprd_amt_restrict_check.value;\n\tvar apprd_days_restrict_check=document.forms[0].apprd_days_restrict_check.value;\n\n\tvar valid_payer_YN=document.forms[0].valid_payer_YN.value;\n\tvar payer_suspended_YN =document.forms[0].payer_suspended_YN.value;\n\tvar valid_policy_type_code_YN=document.forms[0].valid_policy_type_code_YN.value;\n\tvar policy_suspended_YN =document.forms[0].policy_suspended_YN.value;\n\n\tvar ins_cust_group_code=document.forms[0].ins_cust_group_code.value;\n\n\tvar blng_grp_curr_code = document.forms[0].curr_code_for_bg.value;\n\tvar ins_cust_curr_code = document.forms[0].ins_cust_curr_code.value;\n\n\tvar locale = document.forms[0].locale.value;\n\t\tif(policy_eff_frm_date!=\"\")\n\t\t{\n\t\t\tif((validDate(policy_eff_frm_date,\'DMY\',locale)))\n\t\t\t{\t\n\t\t\t\tif(isAfter(policy_eff_frm_date,policy_start_date,\'DMY\',locale))\n\t\t\t{\n\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL00964\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].policy_eff_frm_date.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\talert(getMessage(\"INVALID_DATE_FMT\",\"SM\"));\n\t\t\t\tdocument.forms[0].policy_eff_frm_date.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\n\tif(cust_group_name==\"\")\n\t{\n\t\talert(getMessage(\"BL6277\",\"BL\"));\n\t\tdocument.forms[0].ins_cust_group_name.focus();\n\t\treturn false;\n\t}\n\n\tif(payer_desc==\"\")\n\t{\n\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\tdocument.forms[0].payer_desc.focus();\n\t\treturn false;\n\t}\n\tif(priority==\"\")\n\t{\n\t\talert(getMessage(\"BL9325\",\"BL\"));\n\t\tdocument.forms[0].priority.focus();\n\t\treturn false;\n\t}\n\tif(parseInt(priority)==0)\n\t{\n\t\talert(getMessage(\"BL9833\",\"BL\"));\n\t\tdocument.forms[0].priority.select();\n\t\treturn false;\n\t}\n\tif(!chk_for_decimal(document.forms[0].priority))\n\t{\n\t\treturn false;\n\t}\n\n\tif(policy_type_desc==\"\")\n\t{\n\t\talert(getMessage(\"BL9103\",\"BL\"));\t\n\t\tdocument.forms[0].policy_type_desc.focus();\n\t\treturn false;\n\t}\n\tif(policy_no==\"\")\n\t{\n\t\talert(getMessage(\"BL9104\",\"BL\"));\n\t\tdocument.forms[0].policy_no.focus();\n\t\treturn false;\n\t}\n\tif(policy_start_date==\"\")\n\t{\n\t\talert(getMessage(\"BL9324\",\"BL\"));\n\t\tdocument.forms[0].policy_start_date.focus();\n\t\treturn false;\n\t}\n\tif(policy_exp_date==\"\")\n\t{\n\t\talert(getMessage(\"BL9105\",\"BL\"));\n\t\tdocument.forms[0].policy_exp_date.focus();\n\t\treturn false;\n\t}\n\n\tif(cred_auth_req_yn == \"Y\")\n\t{\n\t\tif(cred_auth_mand_capt_yn == \"Y\")\n\t\t{\n\t\t\tif(credit_auth_ref==\"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL8148\",\"BL\"));\n\t\t\t\tdocument.forms[0].credit_auth_ref.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tif(credit_auth_date==\"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9562\",\"BL\"));\n\t\t\t\tdocument.forms[0].credit_auth_date.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif((credit_auth_ref==\"\" && credit_auth_date!=\"\") || (credit_auth_ref!=\"\" && credit_auth_date==\"\"))\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL7427\",\"BL\"));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\n\tif(restrict_check==\"R\")\n\t{\n\t\tif(apprd_amt_restrict_check == \"R\")\n\t\t{\n\t\t\tif(credit_apprd_amt==\"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9564\",\"BL\"));\n\t\t\t\tdocument.forms[0].credit_apprd_amt.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\tif(apprd_days_restrict_check == \"R\")\n\t\t{\n\t\t\tif(credit_apprd_days==\"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9563\",\"BL\"));\n\t\t\t\tdocument.forms[0].credit_apprd_days.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\t\n\tif(policy_eff_frm_date==\"\")\n\t{\n\t\talert(getMessage(\"BL9565\",\"BL\"));\n\t\tdocument.forms[0].policy_eff_frm_date.focus();\n\t\treturn false;\n\t}\n/*\tif(policy_eff_to_date==\"\")\n\t{\n\t\talert(\"policy_eff_to_date cannot be blank\");\n\t\treturn false;\n\t\tdocument.forms[0].policy_eff_to_date.focus();\n\t}\n\t*/\n\n\tif(valid_payer_YN==\"N\")\n\t{\n\t\talert(getMessage(\"BL9588\",\"BL\")+\":\"+payer_desc);\n\t\treturn false;\n\t}\n\telse if(valid_payer_YN==\"Y\")\n\t{\n\t\tif(payer_suspended_YN == \"S\")\n\t\t{\n\t\t\talert(getMessage(\"BL7435\",\"BL\")+\":\"+payer_desc);\n\t\t\treturn false;\n\t\t}\n\t}\n\n\tif(valid_policy_type_code_YN==\"N\")\n\t{\n\t\talert(getMessage(\"BL9589\",\"BL\")+\":\"+policy_type_desc);\n\t\treturn false;\n\t}\n\telse if(valid_policy_type_code_YN==\"Y\")\n\t{\n\t\tif(policy_suspended_YN == \"S\")\n\t\t{\n\t\t\talert(getMessage(\"BL7436\",\"BL\")+\":\"+policy_type_desc);\n\t\t\treturn false;\n\t\t}\n\t}\n\n\tif((blng_grp_curr_code != \"\" && ins_cust_curr_code == \"\") || (blng_grp_curr_code == \"\" && ins_cust_curr_code != \"\") || (blng_grp_curr_code != \"\" && ins_cust_curr_code != \"\" && ins_cust_curr_code != blng_grp_curr_code))\t\t\n\t{\n\t\talert(getMessage(\"BL6312\",\"BL\"));\n\t\treturn false;\n\t}\n\n\t//Added by Rajesh For CRF - 155\n\tvar patient_class=document.forms[0].p_patient_class.value;\n\tvar billing_class = document.forms[0].billing_group.value\n\tvar payerGrpBySetup = document.forms[0].blgrp_custgrp.value\n\n\tif(payerGrpBySetup == \'Y\'){\n\t\tif(billing_class.length>0 && ins_cust_group_code.length>0){\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\tvar param=\"func_mode=prevEncounterCheck&blngClass=\"+billing_class+\"&custGrp=\"+ins_cust_group_code+\"&patClass=\"+patient_class;\n\t\t\t//var param=\"func_mode=get_Card_Details&card_id=\"+retVal[0];\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"../../eBL/jsp/EncounterCommonValidation.jsp?\"+param,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar responseText=trimString(xmlHttp.responseText);\t\n\t\t\tif(responseText == \'Y\'){\n\t\t\t\talert(\'Customer Group is not valid for the Selected Billing Group\');\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\t//Added by Rajesh For CRF - 155\n\n\tretVal=date_checks();\n\tif(retVal)\n\t{\n\t\tif(chk_for_valid_apprv_days_entry())\n\t\t{\n\t\t\tif(!chk_pol_eff_date_validity())\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t\tif(!chkvalidcustYN())\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t\tacceptPayer();\n\t}\n\telse\n\t\treturn false;\n\n\n}\n\nfunction date_checks()\n{\n\tvar policy_eff_frm_date=document.forms[0].policy_eff_frm_date;\n\tvar policy_eff_to_date=document.forms[0].policy_eff_to_date;\n\tvar policy_start_date=document.forms[0].policy_start_date;\n\tvar policy_exp_date=document.forms[0].policy_exp_date;\n\tvar credit_auth_date = document.forms[0].credit_auth_date;\n\tvar encounter_date = document.forms[0].encounter_date_aft_trunc;\n\tvar module_id = document.forms[0].calling_module_id.value;\n\n\tretVal=false;\n\n/*\tif( (chkPolicyStartDate(policy_start_date,policy_exp_date,encounter_date,\'N\') ) && \n\t    (chkPolicyExpiryDate(policy_start_date,policy_exp_date,encounter_date,\'N\')) &&\n\t\t(chkCreditAuthDate(credit_auth_date,\'N\')) &&\n\t\t(chkPolicyEffFromDate(policy_eff_frm_date,policy_eff_to_date,policy_start_date,policy_exp_date,encounter_date)) && \n\t\t(chkPolicyEffToDate(policy_eff_to_date,policy_eff_frm_date,policy_exp_date,encounter_date)) )\n*/\n\tif( (chkPolicyStartDate(policy_start_date,policy_exp_date,encounter_date,\'N\') ) && \n\t    (chkPolicyExpiryDate(policy_start_date,policy_exp_date,encounter_date,\'N\')) &&\n\t\t(chkCreditAuthDate(credit_auth_date,\'N\')) &&\n\t\t(chkPolicyEffFromDateMain(policy_eff_frm_date,policy_eff_to_date,policy_start_date,policy_exp_date,encounter_date)) && \n\t\t(chkPolicyEffToDate(policy_eff_to_date,policy_eff_frm_date,policy_exp_date,encounter_date)) )\n\t\t\n\t{\n\t\t\tretVal=true;\n\t}\n\telse\n\t\tretVal=false;\n\n\treturn retVal;\n}\n\nfunction acceptPayer()\n{\n\tvar adj_rule_ind_v=document.forms[0].adj_rule_ind_lis.value;\n\tvar adj_perc_amt_value = document.forms[0].adj_perc_amt_value.value;\t\t\n\tvar pmnt_diff_adj_int = document.forms[0].pmnt_diff_adj_int_desc.value;\n\tvar adj_perc_amt_ind_lis = document.forms[0].adj_perc_amt_ind_lis.value;\n\t\n\tif(adj_rule_ind_v==\"AUT\")\n\t{\n\t\tif(adj_perc_amt_value==\"\"  || pmnt_diff_adj_int==\"\" ||adj_perc_amt_ind_lis==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL7193\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar locale=document.forms[0].locale.value;\n\n\tvar billing_group_desc=document.forms[0].billing_group_desc.value;\n\tif(billing_group_desc==\"\") billing_group_desc=\" \";\n\tvar blng_grp_code=document.forms[0].blng_grp_code.value;\n\tif(blng_grp_code==\"\") blng_grp_code=\" \";\n\tvar payer_desc=document.forms[0].payer_desc.value;\n\tif(payer_desc==\"\") payer_desc=\" \";\n\tvar cust_3=document.forms[0].cust_3.value;\n\tif(cust_3==\"\") cust_3=\" \";\n\tvar priority=document.forms[0].priority.value;\n\tif(priority==\"\") priority=\" \";\n\tvar policy_type_desc=document.fo";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="rms[0].policy_type_desc.value;\n\tif(policy_type_desc==\"\") policy_type_desc=\" \";\n\tvar policy_type_code=document.forms[0].policy_type_code.value;\n\tif(policy_type_code==\"\") policy_type_code=\" \";\n\tvar policy_no=document.forms[0].policy_no.value;\n\tif(policy_no==\"\") policy_no=\" \";\n\tvar policy_start_date=document.forms[0].policy_start_date.value;\n\tif(policy_start_date==\"\") policy_start_date=\" \";\n\tvar policy_exp_date=document.forms[0].policy_exp_date.value;\n\tif(policy_exp_date==\"\") policy_exp_date=\" \";\n\tvar credit_auth_ref=document.forms[0].credit_auth_ref.value;\n\tif(credit_auth_ref==\"\") credit_auth_ref=\" \";\n\tvar credit_auth_date=document.forms[0].credit_auth_date.value;\n\tif(credit_auth_date==\"\") credit_auth_date=\" \";\n\tvar cred_auth_req_yn = document.forms[0].cred_auth_req_yn.value;\n\tif(cred_auth_req_yn==\"\") cred_auth_req_yn= \" \";\n\tvar cred_auth_mand_capt_yn = document.forms[0].cred_auth_mand_capt_yn.value;\n\tif(cred_auth_mand_capt_yn==\"\") cred_auth_mand_capt_yn= \" \";\t\n\tvar dflt_auth_ref_as_pol_no_yn = document.forms[0].dflt_auth_ref_as_pol_no_yn.value;\n\tif(dflt_auth_ref_as_pol_no_yn==\"\") dflt_auth_ref_as_pol_no_yn=\" \";\n\tvar credit_apprd_amt=document.forms[0].credit_apprd_amt.value;\n\tif(credit_apprd_amt==\"\") credit_apprd_amt=\" \";\n\tvar credit_apprd_days=document.forms[0].credit_apprd_days.value;\n\tif(credit_apprd_days==\"\") credit_apprd_days=\" \";\n\tvar policy_eff_frm_date=document.forms[0].policy_eff_frm_date.value;\n\tif(policy_eff_frm_date==\"\") policy_eff_frm_date=\" \";\n\tvar policy_eff_to_date=document.forms[0].policy_eff_to_date.value;\n\tif(policy_eff_to_date==\"\") policy_eff_to_date=\" \";\n\tvar adj_rule_ind=document.forms[0].adj_rule_ind.value;\n\tif(adj_rule_ind==\"\") adj_rule_ind=\" \";\n\tvar adj_perc_amt_ind=document.forms[0].adj_perc_amt_ind.value;\n\tif(adj_perc_amt_ind==\"\") adj_perc_amt_ind=\" \";\n\tvar adj_perc_amt_value=document.forms[0].adj_perc_amt_value.value;\n\tif(adj_perc_amt_value==\"\") adj_perc_amt_value=\" \";\n\t\n\tvar pmnt_diff_adj_int=document.forms[0].pmnt_diff_adj_int.value;\n\tif(pmnt_diff_adj_int==\"\") pmnt_diff_adj_int=\" \";\n\tvar drg_pmnt_diff_adj_int=document.forms[0].drg_pmnt_diff_adj_int.value;\n\tif(drg_pmnt_diff_adj_int==\"\") drg_pmnt_diff_adj_int=\" \";\n\tvar spl_srv_pmnt_diff_adj_int=document.forms[0].spl_srv_pmnt_diff_adj_int.value;\n\tif(spl_srv_pmnt_diff_adj_int==\"\") spl_srv_pmnt_diff_adj_int=\" \";\n\n\tvar restrict_check=document.forms[0].restrict_check.value;\n\tif(restrict_check==\"\") restrict_check=\" \";\n\n\tvar apprd_amt_restrict_check = document.forms[0].apprd_amt_restrict_check.value;\n\tif(apprd_amt_restrict_check==\"\") apprd_amt_restrict_check=\" \";\n\n\tvar apprd_days_restrict_check = document.forms[0].apprd_days_restrict_check.value;\n\tif(apprd_days_restrict_check==\"\") apprd_days_restrict_check=\" \";\n\n\tvar valid_payer_YN=document.forms[0].valid_payer_YN.value;\n\tif(valid_payer_YN==\"\") valid_payer_YN=\" \";\n\n\tvar valid_policy_type_code_YN=document.forms[0].valid_policy_type_code_YN.value;\n\tif(valid_policy_type_code_YN==\"\") valid_policy_type_code_YN=\" \";\n\n\tvar ins_cust_group_code=document.forms[0].ins_cust_group_code.value;\n\tif(ins_cust_group_code==\"\") ins_cust_group_code=\" \";\n\n\tvar ins_cust_group_name=document.forms[0].ins_cust_group_name.value;\n\tif(ins_cust_group_name==\"\") ins_cust_group_name=\" \";\n\n\tvar policy_coverage_basis_ind= document.forms[0].policy_coverage_basis_ind.value;\n\tif(policy_coverage_basis_ind==\"\") policy_coverage_basis_ind=\" \";\n\n\tvar cust_valid_from_date = document.forms[0].cust_valid_from_date.value;\n\tif(cust_valid_from_date == \"\") cust_valid_from_date= \" \";\n\n\tvar cust_valid_to_date = document.forms[0].cust_valid_to_date.value;\n\tif(cust_valid_to_date == \"\") cust_valid_to_date= \" \";\n\n\tvar pol_validity_chk_date = document.forms[0].pol_validity_chk_date.value;\n\tif(pol_validity_chk_date == \"\") pol_validity_chk_date= \" \";\n\n\tvar rec_edited_YN = document.forms[0].rec_edited_YN.value;\n\t\n\t// Karthik added the code to add claim code starts  - IN50355\n\tvar claim_code = document.forms[0].claim_code.value;\n\tif(claim_code == \"\") claim_code= \" \";\n\t\n\tvar credit_authorisation_by = document.forms[0].credit_authorisation_by.value;\n\tif(credit_authorisation_by == \"\") credit_authorisation_by= \" \";\n\t\n\tvar membershipId = document.forms[0].membershipId.value;\n\tif(membershipId == \"\") membershipId= \" \";\n\t\n\tvar xmlStrClmCrdt =\"<root><SEARCH \";\n\txmlStrClmCrdt+= \"priority=\\\"\"+checkSpl(priority)+\"\\\" \" ;\n\txmlStrClmCrdt+= \"claim_code=\\\"\"+checkSpl(claim_code)+\"\\\" \" ;\t\n\txmlStrClmCrdt+= \"credit_authorisation_by=\\\"\"+checkSpl(credit_authorisation_by)+\"\\\" \" ;\n\txmlStrClmCrdt+= \"membershipId=\\\"\"+checkSpl(membershipId)+\"\\\" \" ;\n\txmlStrClmCrdt +=\" /></root>\";\t\n\t\n\tvar updationClmCrdt=formValidation(xmlStrClmCrdt,\"claimCreditMapSession\");\t// save these values to bean\n\t<!-- Karthik added the code to add claim code ends  - IN50355-->\t\n\t\n// These 4 values are passed as NULL as these values will b generated in the target page itself...\n\tvar referral_source_main_code=\" \", referral_source_main_desc=\" \",referral_source_sub_code=\" \",referral_source_sub_desc=\" \";\n\n\tif(locale!=\"en\")\n\t{\n\t\tif(!(policy_start_date==\"\" || policy_start_date==\" \"))\n\t\t\tpolicy_start_date=convertDate(policy_start_date,\"DMY\",locale,\"en\");\n\t\t\n\t\tif(!(policy_exp_date==\"\" || policy_exp_date==\" \"))\n\t\t\tpolicy_exp_date=convertDate(policy_exp_date,\"DMY\",locale,\"en\");\n\n\t\tif(!(credit_auth_date==\"\" || credit_auth_date==\" \"))\n\t\t\tcredit_auth_date=convertDate(credit_auth_date,\"DMY\",locale,\"en\");\n\n\t\tif(!(policy_eff_frm_date==\"\" || policy_eff_frm_date==\" \"))\n\t\t\tpolicy_eff_frm_date=convertDate(policy_eff_frm_date,\"DMY\",locale,\"en\");\n\n\t\tif(!(policy_eff_to_date==\"\" || policy_eff_to_date==\" \"))\n\t\t\tpolicy_eff_to_date=convertDate(policy_eff_to_date,\"DMY\",locale,\"en\");\n\n\t\tif(!(pol_validity_chk_date==\"\" || pol_validity_chk_date==\" \"))\n\t\t\tpol_validity_chk_date=convertDate(pol_validity_chk_date,\"DMY\",locale,\"en\");\n\t}\n\n\tvar retVal=encodeURIComponent(billing_group_desc)+\"^~^\"+encodeURIComponent(blng_grp_code)+\"^~^\"+encodeURIComponent(payer_desc)+\"^~^\"+encodeURIComponent(cust_3)+\"^~^\"+priority+\"^~^\"+encodeURIComponent(policy_type_desc)+\"^~^\"+encodeURIComponent(policy_type_code)+\"^~^\"+encodeURIComponent(policy_no)+\"^~^\"+policy_start_date+\"^~^\"+policy_exp_date+\"^~^\"+encodeURIComponent(credit_auth_ref)+\"^~^\"+credit_auth_date+\"^~^\"+credit_apprd_amt+\"^~^\"+credit_apprd_days+\"^~^\"+policy_eff_frm_date+\"^~^\"+policy_eff_to_date+\"^~^\"+encodeURIComponent(adj_rule_ind)+\"^~^\"+encodeURIComponent(adj_perc_amt_ind)+\"^~^\"+encodeURIComponent(adj_perc_amt_value)+\"^~^\"+encodeURIComponent(pmnt_diff_adj_int)+\"^~^\"+encodeURIComponent(drg_pmnt_diff_adj_int)+\"^~^\"+encodeURIComponent(spl_srv_pmnt_diff_adj_int)+\"^~^\"+restrict_check+\"^~^\"+valid_payer_YN+\"^~^\"+valid_policy_type_code_YN+\"^~^\"+encodeURIComponent(ins_cust_group_code)+\"^~^\"+policy_coverage_basis_ind+\"^~^\"+referral_source_main_code+\"^~^\"+referral_source_main_desc+\"^~^\"+referral_source_sub_code+\"^~^\"+referral_source_sub_desc+\"^~^\"+apprd_amt_restrict_check+\"^~^\"+apprd_days_restrict_check+\"^~^\"+cred_auth_req_yn+\"^~^\"+dflt_auth_ref_as_pol_no_yn+\"^~^\"+cust_valid_from_date+\"^~^\"+cust_valid_to_date+\"^~^\"+encodeURIComponent(ins_cust_group_name)+\"^~^\"+pol_validity_chk_date+\"^~^\"+\"Y\"+\"^~^\"+cred_auth_mand_capt_yn+\"^~^\";\n//\talert(\"retVal:\"+retVal);//41values\n\tparent.window.returnValue =escape(retVal);\n\tvalidAcrossEncounters();\n\t/******************package billing changes**********start*************/\n\t\nvar package_enabled_yn=document.forms[0].package_enabled_yn.value;\nvar appr_seq_no=document.forms[0].appr_seq_no.value;\nif(package_enabled_yn==\"\" || package_enabled_yn == null) package_enabled_yn=\"N\";\nif(package_enabled_yn==\"Y\"){\nif(appr_seq_no!=null && appr_seq_no!=\"\")\nappr_seq_no=trimString(appr_seq_no);\nif(credit_auth_ref!=null && credit_auth_ref!=\"\")\ncredit_auth_ref=trimString(credit_auth_ref);\nif(credit_apprd_amt!=null && credit_apprd_amt!=\"\")\ncredit_apprd_amt=trimString(credit_apprd_amt);\n/*if(credit_auth_ref!=null && credit_auth_ref!=\"\" && credit_apprd_amt!=null && credit_apprd_amt!=\"\")\n{*/// commented for IN 20964\n\tif(!validatePkgApprvDtlForm()){\n\t\treturn;\n\t}\n\tsaveToBean(parent.PkgDtls.document.PkgDtls,\'\')\n\tif(!validatePkgApprvPayerDtlForm()){\t\n\t\treturn;\n\t}\n\tsaveToBean(parent.PayerDtls.document.PayerDtls,\'\')\n\tvar formObj=document.forms[0];\t\n\tvar oldMapKey=formObj.oldMapKey.value;\n\tvar currMapKey=trimString(blng_grp_code)+\"~~\"+trimString(ins_cust_group_code)+\"~~\"+trimString(cust_3)+\"~~\"+trimString(priority)+\"~~\"+trimString(policy_type_code)+\"~~\"+trimString(policy_no)+\"~~\"+trimString(policy_eff_frm_date);\n\tif(oldMapKey!=currMapKey){//rename oldMapKey  with currMapKey in payerDtls collection of PkgApprovalBean\n\t\trenameBeanKey(formObj,oldMapKey,currMapKey,\'\');\n\t}\n\tvar xmlStr =\"<root><SEARCH \";\t\n\txmlStr+= \"billing_group_desc=\\\"\"+checkSpl(billing_group_desc)+\"\\\" \" ;\n\txmlStr+= \"blng_grp_code=\\\"\"+checkSpl(blng_grp_code)+\"\\\" \" ;\t\t\n\txmlStr+= \"payer_desc=\\\"\"+checkSpl(payer_desc)+\"\\\" \" ;\t\t\n\txmlStr+= \"cust_3=\\\"\"+checkSpl(cust_3)+\"\\\" \" ;\t\t\n\txmlStr+= \"priority=\\\"\"+checkSpl(priority)+\"\\\" \" ;\t\n\txmlStr+= \"policy_type_desc=\\\"\"+checkSpl(policy_type_desc)+\"\\\" \" ;\t\n\txmlStr+= \"policy_type_code=\\\"\"+checkSpl(policy_type_code)+\"\\\" \" ;\t\n\txmlStr+= \"policy_no=\\\"\"+checkSpl(policy_no)+\"\\\" \" ;\t\n\txmlStr+= \"policy_start_date=\\\"\"+checkSpl(policy_start_date)+\"\\\" \" ;\t\n\txmlStr+= \"policy_exp_date=\\\"\"+checkSpl(policy_exp_date)+\"\\\" \" ;\t\n\txmlStr+= \"appr_seq_no=\\\"\"+checkSpl(appr_seq_no)+\"\\\" \" ;\t\n\txmlStr+= \"credit_auth_ref=\\\"\"+checkSpl(credit_auth_ref)+\"\\\" \" ;\t\n\txmlStr+= \"credit_auth_date=\\\"\"+checkSpl(credit_auth_date)+\"\\\" \" ;\t\n\txmlStr+= \"credit_apprd_amt=\\\"\"+checkSpl(credit_apprd_amt)+\"\\\" \" ;\t\n\txmlStr+= \"credit_apprd_days=\\\"\"+checkSpl(credit_apprd_days)+\"\\\" \" ;\t\n\txmlStr+= \"policy_eff_frm_date=\\\"\"+checkSpl(policy_eff_frm_date)+\"\\\" \" ;\t\n\txmlStr+= \"policy_eff_to_date=\\\"\"+checkSpl(policy_eff_to_date)+\"\\\" \" ;\t\n\txmlStr+= \"adj_rule_ind=\\\"\"+checkSpl(adj_rule_ind)+\"\\\" \" ;\t\n\txmlStr+= \"adj_perc_amt_ind=\\\"\"+checkSpl(adj_perc_amt_ind)+\"\\\" \" ;\t\n\txmlStr+= \"adj_perc_amt_value=\\\"\"+checkSpl(adj_perc_amt_value)+\"\\\" \" ;\t\n\txmlStr+= \"pmnt_diff_adj_int=\\\"\"+checkSpl(pmnt_diff_adj_int)+\"\\\" \" ;\t\n\txmlStr+= \"drg_pmnt_diff_adj_int=\\\"\"+checkSpl(drg_pmnt_diff_adj_int)+\"\\\" \" ;\t\n\txmlStr+= \"spl_srv_pmnt_diff_adj_int=\\\"\"+checkSpl(spl_srv_pmnt_diff_adj_int)+\"\\\" \" ;\t\n\txmlStr+= \"restrict_check=\\\"\"+checkSpl(restrict_check)+\"\\\" \" ;\t\n\txmlStr+= \"valid_payer_YN=\\\"\"+checkSpl(valid_payer_YN)+\"\\\" \" ;\t\n\txmlStr+= \"valid_policy_type_code_YN=\\\"\"+checkSpl(valid_policy_type_code_YN)+\"\\\" \" ;\t\n\txmlStr+= \"ins_cust_group_code=\\\"\"+checkSpl(ins_cust_group_code)+\"\\\" \" ;\t\n\txmlStr+= \"policy_coverage_basis_ind=\\\"\"+checkSpl(policy_coverage_basis_ind)+\"\\\" \" ;\t\n\txmlStr+= \"referral_source_main_code=\\\"\"+checkSpl(referral_source_main_code)+\"\\\" \" ;\t\n\txmlStr+= \"referral_source_main_desc=\\\"\"+checkSpl(referral_source_main_desc)+\"\\\" \" ;\t\n\txmlStr+= \"ref";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block9_2 ="erral_source_sub_code=\\\"\"+checkSpl(referral_source_sub_code)+\"\\\" \" ;\t\n\txmlStr+= \"referral_source_sub_desc=\\\"\"+checkSpl(referral_source_sub_desc)+\"\\\" \" ;\t\n\txmlStr+= \"apprd_amt_restrict_check=\\\"\"+checkSpl(apprd_amt_restrict_check)+\"\\\" \" ;\t\n\txmlStr+= \"apprd_days_restrict_check=\\\"\"+checkSpl(apprd_days_restrict_check)+\"\\\" \" ;\t\n\txmlStr+= \"cred_auth_req_yn=\\\"\"+checkSpl(cred_auth_req_yn)+\"\\\" \" ;\t\n\txmlStr+= \"dflt_auth_ref_as_pol_no_yn=\\\"\"+checkSpl(dflt_auth_ref_as_pol_no_yn)+\"\\\" \" ;\t\n\txmlStr+= \"cust_valid_from_date=\\\"\"+checkSpl(cust_valid_from_date)+\"\\\" \" ;\t\n\txmlStr+= \"cust_valid_to_date=\\\"\"+checkSpl(cust_valid_to_date)+\"\\\" \" ;\t\n\txmlStr+= \"ins_cust_group_name=\\\"\"+checkSpl(ins_cust_group_name)+\"\\\" \" ;\t\n\txmlStr+= \"pol_validity_chk_date=\\\"\"+checkSpl(pol_validity_chk_date)+\"\\\" \" ;\n\txmlStr +=\" /></root>\";\t\t\n\tvar updation=formValidation(xmlStr,\"hdrVals\");\t// save these values to bean\n\t//} // commented for IN 20964\n\t}\n\t\t/******************package billing changes**********end*************/\n\tparent.window.close();\n}\n\nfunction cust_grp_lkup(clng_evnt)\n{\n\tvar autoFinChk = document.forms[0].autoFinChk.value;\n\tvar target\t= document.forms[0].ins_cust_group_name;\n\tvar locale = document.forms[0].locale.value;\n\tvar action=document.forms[0].action.value;\n\tvar locn=document.forms[0].locn.value;\n\t\n\tvar  blgrp_custgrp =document.forms[0].blgrp_custgrp.value;\n\t\n\t\n\tvar blng_grp_id =document.forms[0].billing_group.value;\n\t\n\t\n\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].ins_cust_group_name.value = \"\";\n\t\t\tdocument.forms[0].ins_cust_group_code.value = \"\";\n\t\t\treturn;\n\t\t}\n\t}\n\n\tif(action==\"add\" && locn==\"outside\")\n\t{\n\t\tif(document.forms[0].select_billing_group.value == \"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9301\",\"BL\"));\n\t\t\tdocument.forms[0].select_billing_group.focus();\n\t\t\treturn false;\n\t\t}\n\t}\n\t\n\tvar retVal\t\t\t= new String();\t\n\n\tvar dialogTop\t\t\t= \"240\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"50\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\t\n\tvar title=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\t\n\tvar column_sizes = escape(\"30%,70%\");\n\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\t\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\t\n\n\tvar column_descriptions = code+\",\"+desc;\n\n\tvar message = \'\';\t\n\n\tif (autoFinChk == \"Y\")\n\t{\n\t\t\n\t\t\n\t\tvar blng_grp_id = document.forms[0].blng_grp_code.value;\n\t\tvar class_code = document.forms[0].class_code.value;\n\t\t\n\t\tsql = \" SELECT DISTINCT a.appl_cust_group_code CUST_GROUP_CODE, b.SHORT_DESC SHORT_NAME FROM BL_APPL_BG_BY_CLASSFCTN a, ar_cust_group_lang_vw b WHERE a.appl_cust_group_code = b.CUST_GROUP_CODE AND language_id=\'\"+locale+\"\' AND a.CLASSIFICATION_CODE = \'\"+class_code+\"\' AND a.APPL_BLNG_GRP_ID = \'\"+blng_grp_id+\"\' AND b.status IS NULL\";\n\t}\n\telse\n\t{\n\t\tvar sql = \"select cust_group_code CUST_GRP_CODE,short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id=\'\"+locale+\"\' and status is null\";\n\t}\n\t\n\tif(blgrp_custgrp == \'Y\')\t\t\n\t sql = \"SELECT distinct A.CUST_GROUP_CODE CUST_GRP_CODE,A.SHORT_DESC SHORT_NAME FROM AR_CUST_GROUP_LANG_VW A, BL_PAYERS_PRIORITY_BY_BG  B WHERE  A.CUST_GROUP_CODE = B.CUST_GROUP_CODE and  B.BLNG_GRP_ID = \'\"+blng_grp_id+\"\' and    LANGUAGE_ID = \'\"+locale+\"\' AND    A.STATUS IS NULL and    NVL(B.STATUS,\'E\')=\'E\'\";\n\n\t\n\n\tsql = escape(sql);\t\t\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\t\n\tvar arr=new Array();\t\t\n\n\tif(retVal == null) retVal=\'\';\n\n\tif (retVal != null || retVal!=\"\")\n\t{\n\t\tvar retVal=unescape(retVal);\n\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\tdocument.forms[0].ins_cust_group_code.value=arr[0];\n\t\t\tdocument.forms[0].ins_cust_group_name.value=arr[1];\n\t\t\tdocument.forms[0].payer_desc.value=\'\';\n\t\t\tdocument.forms[0].cust_3.value=\'\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].ins_cust_group_code.value=\'\';\n\t\t\tdocument.forms[0].ins_cust_group_name.value=\'\';\t\n\t\t}\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].ins_cust_group_code.value=\'\';\n\t\tdocument.forms[0].ins_cust_group_name.value=\'\';\t\n\t}\n\tvar custGrpCode= document.forms[0].ins_cust_group_code.value;\n\tvar custGrpName= document.forms[0].ins_cust_group_name.value;\n\t\n\tvar custId=document.forms[0].cust_id.value;\n\t\n//\talert(\"custGrp>>>>>>\"+custGrpCode+\"/\"+custGrpCode);\nif(custId == \'ALMO\') {\t\n\tif(custGrpCode!= \"\" && custGrpName != \"\")\n\tpayerlkup(\'C\');\n}\n}\n\nfunction payerlkup(clng_evnt)\n{\t\n\t\tvar autoFinChk = document.forms[0].autoFinChk.value;\n\t\tvar target\t\t\t= document.forms[0].payer_desc;\t\n\t\tvar action=document.forms[0].action.value;\n\t\tvar locn=document.forms[0].locn.value;\n\n\t\tif(clng_evnt == \'B\')\n\t\t{\n\t\t\tif( target.value == \"\")\n\t\t\t{\t\n\t\t\t\tdocument.forms[0].payer_desc.value = \"\";\n\t\t\t\tif(document.forms[0].cust_3.value != \'**\')\n\t\t\t\t\tdocument.forms[0].cust_3.value = \"\";\n\t\t\t\tdocument.getElementById(\'ins_cust_curr_desc_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'ins_cust_curr_desc_val\').innerText=\"\";\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\t\t\n\t\tif(action==\"add\" && locn==\"outside\")\n\t\t{\n\t\t\tif(document.forms[0].select_billing_group.value == \"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9301\",\"BL\"));\n\t\t\t\tdocument.forms[0].select_billing_group.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\n\t\tvar cust_grp_code = document.forms[0].ins_cust_group_code.value;\n\t\tif(cust_grp_code == \"\")\n\t\t{\n\t\t\talert(getMessage(\"BL6277\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tvar retVal\t\t\t= new String();\t\n\n\t\tvar dialogTop\t\t\t= \"240\";\n\t\tvar dialogHeight\t\t= \"32\" ;\n\t\tvar dialogWidth\t\t\t= \"50\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar sql1\t\t\t\t= \"\";\t\n\t\t\n\t\tvar title=getLabel(\"Common.Payer.label\",\"common\");\n\t\ttitle=encodeURIComponent(title);\t\n//\t\tvar column_sizes = escape(\"5%,25%,5%,25%,10%,10%,10%,10%\");\n\t\tvar column_sizes = escape(\"5%,25%,5%,25%,10%,10%,10%,10%,0%,0%\");\n\t\tvar code=getLabel(\"eBL.PAYER_CODE.label\",\"BL\");\n\t\tcode=encodeURIComponent(code);\t\n\t\tvar desc=getLabel(\"eBL.PAYER_DESC.label\",\"BL\");\n\t\tdesc=encodeURIComponent(desc);\n\t\tvar ins_cust_group_code=getLabel(\"eBL.PAYER_GROUP_CODE.label\",\"BL\");\n\t\tins_cust_group_code=encodeURIComponent(ins_cust_group_code);\n\t\tvar cust_group_desc=getLabel(\"eBL.PAYER_GROUP_DESC.label\",\"BL\");\n\t\tcust_group_desc=encodeURIComponent(cust_group_desc);\t\n\t\tvar country = getLabel(\"Common.country.label\",\"common\");\n\t\tcountry = encodeURIComponent(country);\n\t\tvar region = getLabel(\"eMP.region.label\",\"MP\");\n\t\tregion = encodeURIComponent(region);\n\t\tvar cust_valid_frm=getLabel(\"eBL.VALID_FROM.label\",\"BL\");\n\t\tcust_valid_frm=encodeURIComponent(cust_valid_frm);\t\n\t\tvar cust_valid_to=getLabel(\"eBL.VALID_TO.label\",\"BL\");\n\t\tcust_valid_to=encodeURIComponent(cust_valid_to);\n\t\tvar curr_code=getLabel(\"eBL.CURR_CODE.label\",\"BL\");\n\t\tcust_curr_code=encodeURIComponent(curr_code);\n\t\tvar curr_desc=getLabel(\"eBL.CURR_DESC.label\",\"BL\");\n\t\tcurr_desc=encodeURIComponent(curr_desc);\n\n\t\tvar column_descriptions = code+\",\"+desc+\",\"+ins_cust_group_code+\",\"+cust_group_desc+\",\"+country+\",\"+region+\",\"+cust_valid_frm+\",\"+cust_valid_to+\",\"+curr_code+\",\"+curr_desc;\n\n\t\tvar message = \'\';\t\t\n\n\t\tvar locale = document.forms[0].locale.value;\n\t\tvar strModuleId = document.forms[0].calling_module_id.value;\n\t\tvar strCustGroupCode = document.forms[0].ins_cust_group_code.value;\n\n\t\tvar action=document.forms[0].action.value;\n\t\tvar locn=document.forms[0].locn.value;\n\t\tvar cust_valid_from_date = \"\", cust_valid_to_date = \"\",ins_cust_curr_code=\"\",ins_cust_curr_desc=\"\";\n\t\tvar encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc;\n\t\tvar search_by_items = document.forms[0].search_by_items.value;\n\t\tvar search_code = document.forms[0].search_code.value ;\n\t\tvar episode_type = document.forms[0].episode_type.value;\n\t\tvar blng_grp_curr_code = document.forms[0].curr_code_for_bg.value;\n\t\tvar facility_id = document.forms[0].facility_id.value;\n\n\t\tvar blng_grp_id = document.forms[0].blng_grp_code.value;\n\t\tvar class_code = document.forms[0].class_code.value;\n\n/*\n\t\tif(action==\"add\")\n\t\t{\n\t\t\tstrCustGroupCode=\"\";\n\t\t}\n*/\n\t\t//new one - added the condition (a.ref_yn = \'Y\') on 1-aug-2007  by manivel\n//\t\tsql1=\"select DISTINCT a.cust_code CUST_CODE, a.short_name CUST_NAME,b.cust_group_code CUST_GROUP_CODE, b.short_desc CUST_GROUP_NAME,to_char(a.VALID_FROM,\'dd/mm/yyyy\') VALID_FROM,to_char(a.VALID_TO,\'dd/mm/yyyy\') VALID_TO from ar_customer_lang_vw a,ar_cust_group_lang_vw b,sy_acc_entity c,bl_ins_policy_type_hdr d where a.acc_entity_code= b.acc_entity_code and a.cust_group_code = b.cust_group_code and (b.cust_group_code=\'\"+strCustGroupCode+\"\' or \'\"+strCustGroupCode+\"\' is null) and a.language_id = b.language_id and  a.language_id=\'\"+locale+\"\' and a.patient_flag = \'Y\' and NVL(a.pat_com_flag,\'N\') = \'N\'  and nvl(a.insurance_yn,\'Y\') = \'Y\'   and a.status is null  and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(a.op_yn,\'N\') = \'Y\') or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(a.ip_yn,\'N\') = \'Y\') or (\'\"+strModuleId+\"\' = \'MP\' and a.ref_yn = \'Y\')) and c.acc_entity_code = a.acc_entity_code and d.operating_facility_id = c.acc_entity_id and d.cust_group_code = a.cust_group_code and (d.cust_code = a.cust_code or d.cust_code = \'**\') and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(d.outpatient_cover,\'N\') = \'Y\') or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(d.inpatient_covered,\'N\') = \'Y\') or (\'\"+strModuleId+\"\' = \'MP\' and nvl(d.external_covered,\'N\') = \'Y\')) and decode(\'\"+search_by_items+\"\',\'CY\',nvl(country_code,\'XXXX\'),\'RN\',nvl(region_code,\'XXXX\')) = nvl(\'\"+search_code+\"\',decode(\'\"+search_by_items+\"\',\'CY\',nvl(country_code,\'XXXX\'),\'RN\',nvl(region_code,\'XXXX\')))\";\n\t\t\n//\t\tsql1=\"select DISTINCT a.cust_code CUST_CODE,a.short_name CUST_NAME,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,a.country_name COUNTRY_NAME,a.region_name REGION_NAME,a.VALID_FROM VALID_FROM,a.VALID_TO VALID_TO from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,sy_acc_entity c,bl_ins_policy_type_hdr d where a.acc_entity_code= b.acc_entity_code and c.acc_entity_code = a.acc_entity_code and d.operating_facility_id = c.acc_entity_id and a.language_id = b.language_id and a.language_id=\'\"+locale+\"\' and a.cust_group_code = b.cust_group_code and d.cust_group_code = a.cust_group_code and (b.cust_group_code=\'\"+strCustGroupCode+\"\' or \'\"+strCustGroupCode+\"\' is null) and (d.cust_code = a.cust_code or d.cust_code = \'**\') and a.patient_flag = \'Y\' and NVL(a.pat_c";
    private final static byte[]  _wl_block9_2Bytes = _getBytes( _wl_block9_2 );

    private final static java.lang.String  _wl_block9_3 ="om_flag,\'N\') = \'N\' and nvl(a.insurance_yn,\'Y\') = \'Y\' and a.status is null and decode(\'\"+search_by_items+\"\',\'CY\',nvl(country_code,\'XXXX\'),\'RN\',nvl(region_code,\'XXXX\')) = nvl(\'\"+search_code+\"\',decode(\'\"+search_by_items+\"\',\'CY\',nvl(country_code,\'XXXX\'),\'RN\',nvl(region_code,\'XXXX\')))\";\n\n//    Query changed to match the CRF-134(Multiple Cust Group for single Customer) need\n\t\t\n\t\tsql = \"called_for=INSPAYERLKUP&locale=\"+locale+\"&module_id=\"+strModuleId+\"&episode_type=\"+episode_type+\"&auto_fin_chk=\"+autoFinChk+\"&cust_grp_code=\"+strCustGroupCode+\"&class_code=\"+class_code+\"&blng_grp_id=\"+blng_grp_id+\"&search_by_items=\"+search_by_items+\"&search_code=\"+search_code+\"&facility_id=\"+facility_id;\n/*\n\t\tvar valid_cust_check = \"\";\n\t\tvar valid_pol_check = \"\";\n\n\t\tif(episode_type == \'R\' )\n\t\t{\n\t\t\tvalid_cust_check=\" and (\'\"+strModuleId+\"\'=\'MP\' and a.ref_yn=\'Y\') \";\n\t\t}\n\t\telse if(episode_type == \'O\')\n\t\t{\n\t\t\tvalid_cust_check=\" and (\'\"+strModuleId+\"\'=\'OP\' and a.op_yn =\'Y\') \";\n\t\t}\n\t\telse if(episode_type == \'E\')\n\t\t{\n\t\t\tvalid_cust_check=\" and (\'\"+strModuleId+\"\'=\'AE\' and a.op_yn=\'Y\') \";\n\t\t}\n\t\telse if(episode_type == \'I\')\n\t\t{\n\t\t\tvalid_cust_check=\" and (\'\"+strModuleId+\"\'=\'IP\' and a.ip_yn =\'Y\') \";\n\t\t}\n\t\telse if(episode_type == \'D\')\n\t\t{\n\t\t\tvalid_cust_check=\" and (\'\"+strModuleId+\"\'=\'DC\' and a.ip_yn = \'Y\') \";\n\t\t}\n\n\t\tif(episode_type == \'R\' )\n\t\t{\n\t\t\tvalid_pol_check=\" and (\'\"+strModuleId+\"\'=\'MP\' and nvl(c.external_covered,\'N\')=\'Y\')\";\n\t\t}\n\t\telse if(episode_type == \'O\')\n\t\t{\n\t\t\tvalid_pol_check=\" and (\'\"+strModuleId+\"\'=\'OP\' and nvl(c.outpatient_cover,\'N\')=\'Y\')\";\n\t\t}\n\t\telse if(episode_type == \'E\')\n\t\t{\n\t\t\tvalid_pol_check=\" and (\'\"+strModuleId+\"\'=\'AE\' and nvl(c.outpatient_cover,\'N\')=\'Y\')\";\n\t\t}\n\t\telse if(episode_type == \'I\')\n\t\t{\n\t\t\tvalid_pol_check=\" and (\'\"+strModuleId+\"\'=\'IP\' and nvl(c.inpatient_covered,\'N\')=\'Y\')\";\n\t\t}\n\t\telse if(episode_type == \'D\')\n\t\t{\n\t\t\tvalid_pol_check=\" and (\'\"+strModuleId+\"\'=\'DC\' and nvl(c.inpatient_covered,\'N\')=\'Y\')\";\n\t\t}\n\n\t\tif (autoFinChk == \"Y\")\n\t\t{\n\t\t\tvar blng_grp_id = document.forms[0].blng_grp_code.value;\n\t\t\tvar class_code = document.forms[0].class_code.value;\n\n\t\t\tsql1=\"select d.cust_code C_CDE,a.short_name C_NAM,b.cust_group_code C_GRP_CDE,b.short_desc C_GRP_NAM,\"\n\t\t\t\t+\" blcommon.getcntry(a.country_code,\'\"+locale+\"\') cny_nam, blcommon.getregn(a.region_code,\'\"+locale+\"\') rg_nam,\"\n\t\t\t\t+\" a.VALID_FROM VAL_FRM,a.VALID_TO VAL_TO,a.CURRENCY_CODE CUR_COD,a.CURRENCY_DESC CUR_DSC\"\n\t\t\t\t+\" from AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d,BL_APPL_BG_BY_CLASSFCTN f\"\n\t\t\t\t+\" where a.acc_entity_code=b.acc_entity_code\"\n\t\t\t\t+\" AND b.acc_entity_code=d.acc_entity_code\" \n\t\t\t\t+\" and a.language_id=b.language_id\" \n\t\t\t\t+\" and a.language_id=\'\"+locale+\"\'\" \n\t\t\t\t+\" and d.cust_group_code=f.APPL_CUST_GROUP_CODE\" \n\t\t\t\t+\" AND b.cust_group_code =NVL(\'\"+strCustGroupCode+\"\',b.cust_group_code)\"\n\t\t\t\t+\" and f.APPL_CUST_GROUP_CODE=NVL(\'\"+strCustGroupCode+\"\',f.APPL_CUST_GROUP_CODE)\"\n\t\t\t\t+\" and f.CLASSIFICATION_CODE=\'\"+class_code+\"\'\"\n\t\t\t\t+\" and f.APPL_BLNG_GRP_ID=\'\"+blng_grp_id+\"\'\"\n\t\t\t\t+\" and a.cust_code=d.cust_code\" \n\t\t\t\t+\" and d.cust_code = f.APPL_CUST_CODE\" \n\t\t\t\t+\" and a.patient_flag=\'Y\'\" \n\t\t\t\t+\" and NVL(a.pat_com_flag,\'N\')=\'N\'\" \n\t\t\t\t+\" and nvl(a.insurance_yn,\'Y\')=\'Y\'\" \n\t\t\t\t+\" and a.status is null\" \n\t\t\t\t+valid_cust_check\n\t\t\t\t+\" AND EXISTS (SELECT \'Y\' FROM bl_ins_policy_type_hdr c WHERE (c.cust_code = d.cust_code OR  c.cust_code = \'**\') \"+valid_pol_check+\" AND c.cust_group_code = d.cust_group_code)\"\n\t\t\t\t+\" AND decode(\'\"+search_by_items+\"\',\'CY\',nvl(country_code,\'XXXX\'),\'RN\',nvl(region_code,\'XXXX\'))=nvl(\'\"+search_code+\"\',decode(\'\"+search_by_items+\"\',\'CY\',nvl(country_code,\'XXXX\'),\'RN\',nvl(region_code,\'XXXX\')))\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tsql1=\"select d.cust_code C_CDE,a.short_name C_NAM,b.cust_group_code C_GRP_CDE,b.short_desc C_GRP_NAM,\"\n\t\t\t\t+\" blcommon.getcntry(a.country_code,\'\"+locale+\"\') cny_nam, blcommon.getregn(a.region_code,\'\"+locale+\"\') rg_nam,\"\n\t\t\t\t+\" a.VALID_FROM VAL_FRM,a.VALID_TO VAL_TO,a.CURRENCY_CODE CUR_COD,a.CURRENCY_DESC CUR_DSC\" \n\t\t\t\t+\" FROM AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d\"\n\t\t\t\t+\" WHERE a.acc_entity_code= b.acc_entity_code\"\n\t\t\t\t+\" AND b.acc_entity_code= d.acc_entity_code\"\n\t\t\t\t+\" AND a.language_id = b.language_id\"\n\t\t\t\t+\" AND b.cust_group_code = d.cust_group_code\"\n\t\t\t\t+\" AND a.language_id=\'\"+locale+\"\'\"\n\t\t\t\t+\" AND b.cust_group_code =NVL(\'\"+strCustGroupCode+\"\',b.cust_group_code)\"\n\t\t\t\t+\" AND a.cust_code = d.cust_code\" \n\t\t\t\t+\" AND a.patient_flag = \'Y\'\"\n\t\t\t\t+\" AND NVL(a.pat_com_flag,\'N\') = \'N\'\"\n\t\t\t\t+\" AND NVL(a.insurance_yn,\'Y\') = \'Y\'\" \n\t\t\t\t+\" AND a.status IS NULL\"\n\t\t\t\t+valid_cust_check\n\t\t\t\t+\" AND EXISTS (SELECT \'Y\' FROM bl_ins_policy_type_hdr c WHERE (c.cust_code = d.cust_code OR  c.cust_code = \'**\') \"+valid_pol_check+\" AND c.cust_group_code = d.cust_group_code)\"\n\t\t\t\t+\" AND decode(\'\"+search_by_items+\"\',\'CY\',nvl(country_code,\'XXXX\'),\'RN\',nvl(region_code,\'XXXX\'))=nvl(\'\"+search_code+\"\',decode(\'\"+search_by_items+\"\',\'CY\',nvl(country_code,\'XXXX\'),\'RN\',nvl(region_code,\'XXXX\')))\";\n\t\t}\n\n//\t\tsql = escape(sql1);\t\t\n\t\tsql = sql1;\t\t\n*/\n//\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYYYYYYNN\";\n\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYYYYYYNN\";\n\t\t\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\n\t\tvar arr=new Array();\t\t\n\n\t    if(retVal == null) retVal=\'\';\n\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tarr=retVal.split(\"^~^\");\t\t\n\t\t\t\tcust_valid_from_date = arr[6].substring(0,10);\n\t\t\t\tcust_valid_to_date = arr[7].substring(0,10);\n\t\t\t\tins_cust_curr_code = arr[8]; \n\t\t\t\tins_cust_curr_desc = arr[9];\n\n\t\t\t\tif(cust_valid_from_date != \"\")\n\t\t\t\t{\n\t\t\t\t\tvar cust_valid_from_date_loc=cust_valid_from_date;\n\t\t\t\t\tif(locale != \'en\')\n\t\t\t\t\tcust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,\'DMY\',\'en\',locale);\n\n\t\t\t\t\tif(!isAfter(encounter_date_aft_trunc.value,cust_valid_from_date_loc,\'DMY\',locale))\n\t\t\t\t\t{\n\t\t\t\t\t\t//Added by Rajesh V - If logic\n\t\t\t\t\t\tif(strModuleId != \'MP\'){\n\t\t\t\t\t\t\talert(getMessage(\"BL8227\",\"BL\"));\n\t\t\t\t\t\t\tdocument.forms[0].payer_desc.select();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t}\t\n\t\t\t\t}\n\t\t\t\tif(cust_valid_to_date != \"\")\n\t\t\t\t{\n\t\t\t\t\tvar cust_valid_to_date_loc=cust_valid_to_date;\n\t\t\t\t\tif(locale != \'en\')\n\t\t\t\t\tcust_valid_to_date_loc=convertDate(cust_valid_to_date_loc,\'DMY\',\'en\',locale);\n\n\t\t\t\t\tif(!isBefore(encounter_date_aft_trunc.value,cust_valid_to_date_loc,\'DMY\',locale))\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BL8227\",\"BL\"));\n\t\t\t\t\t\tdocument.forms[0].payer_desc.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\t\n\n\t\t\t\tif((blng_grp_curr_code != \"\" && ins_cust_curr_code == \"\") || (blng_grp_curr_code == \"\" && ins_cust_curr_code != \"\") ||\t(blng_grp_curr_code != \"\" && ins_cust_curr_code != \"\" && ins_cust_curr_code != blng_grp_curr_code))\t\t\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL6312\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].payer_desc.value = \"\";\n\t\t\t\t\tdocument.forms[0].cust_3.value = \"\";\n\t\t\t\t\tdocument.forms[0].ins_cust_curr_code.value = \"\";\n\t\t\t\t\tdocument.forms[0].ins_cust_curr_desc.value = \"\";\n\t\t\t\t\tdocument.getElementById(\'ins_cust_curr_desc_disp\').style.display=\"none\";\n\t\t\t\t\tdocument.getElementById(\'ins_cust_curr_desc_val\').innerText=\"\";\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].ins_cust_curr_code.value = ins_cust_curr_code;\n\t\t\t\t\tdocument.forms[0].ins_cust_curr_desc.value = ins_cust_curr_desc;\n\t\t\t\t}\n\n\t\t\t\tif(document.forms[0].cust_3.value != \'**\' && (document.forms[0].cust_3.value != arr[0] || document.forms[0].ins_cust_group_code.value != arr[2]))\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].policy_type_code.value=\"\";\n\t\t\t\t\tdocument.forms[0].policy_type_desc.value=\"\";\n\t\t\t\t\tdocument.forms[0].valid_policy_type_code_YN.value=\"N\";\n\t\t\t\t}\n\t\t\t\tdocument.forms[0].cust_3.value=arr[0];\n\t\t\t\tdocument.forms[0].payer_desc.value=arr[1];\n\t\t\t\tdocument.forms[0].ins_cust_group_code.value=arr[2];\n\t\t\t\tdocument.forms[0].ins_cust_group_name.value=arr[3];\n\t\t\t\tdocument.forms[0].cust_valid_from_date.value=cust_valid_from_date;\n\t\t\t\tdocument.forms[0].cust_valid_to_date.value=cust_valid_to_date;\n\t\t//\t\t\t\t\ttarget.focus();\n\t\t//\t\t\t\t\tsetTimeout(\'apprvd_amt_days_check()\',200);\n\t\t\t\tdocument.forms[0].valid_payer_YN.value=\"Y\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].cust_3.value=\"\";\n\t\t\t\tdocument.forms[0].payer_desc.value=\"\";\n\t\t\t\tdocument.forms[0].valid_payer_YN.value=\"N\";\n\t\t\t\tdocument.forms[0].policy_type_code.value=\"\";\n\t\t\t\tdocument.forms[0].policy_type_desc.value=\"\";\n\t\t\t\tdocument.forms[0].valid_policy_type_code_YN.value=\"N\";\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].cust_3.value=\"\";\n\t\t\tdocument.forms[0].payer_desc.value=\"\";\n\t\t\tdocument.forms[0].valid_payer_YN.value=\"N\";\n\t\t\tdocument.forms[0].policy_type_code.value=\"\";\n\t\t\tdocument.forms[0].policy_type_desc.value=\"\";\n\t\t\tdocument.forms[0].valid_policy_type_code_YN.value=\"N\";\n\t\t}\n\t\tif(apprvd_amt_days_check())\n\t\t{\n\t\t\tif(curr_desc_1())\n\t\t\t{\n\t\t\t\tadjustment_rule();\n\t\t\t}\n\t\t}\n\t\tvar payerDescVal= document.forms[0].payer_desc.value;\n\t\t\n\t\tvar custId=document.forms[0].cust_id.value;\n\t\t//alert(\"payerDescVal>>>>>>\"+payerDescVal);\n\t\t\n\t\tif(custId == \'ALMO\') {\t\n\t\tif(payerDescVal!= \"\")\n\t\tpolicylkup(\'C\');\n\t\t}\n}\n\nasync function getCustDet()\n{\n\tvar cust_3=document.forms[0].cust_3.value;\t\n\tvar cust_group_code=document.forms[0].ins_cust_group_code.value;\n\n\tif(cust_3 == \"\")\n\t{\n\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\treturn;\n\t}\n\t\t\t\t\n\tif((cust_3!=\"\"))\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"20\" ;\n\t\tvar dialogWidth\t= \"30\" ;\n\t\tvar dialogTop = \"320\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"../../eBL/jsp/BLCustomerDetFrame.jsp?cust_code=\"+cust_3+\"&cust_grp_code=\"+cust_group_code;;\n\t\tretVal =await window.showModalDialog(url,arguments,features);\n\t}\n}\n\nfunction curr_desc_1()\n{\n\tvar ins_cust_curr_desc = document.forms[0].ins_cust_curr_desc.value;\n\n\tif(ins_cust_curr_desc != \"\")\n\t{\n\t\tdocument.getElementById(\'ins_cust_curr_desc_disp\').style.display=\"inline\";\n\t\tdocument.getElementById(\'ins_cust_curr_desc_val\').innerText=ins_cust_curr_desc;\n\t\treturn true;\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\'ins_cust_curr_desc_disp\').style.display=\"none\";\n\t\tdocument.getElementById(\'ins_cust_curr_desc_val\').innerText=\"\";\n\t\treturn true;\n\t}\n\n}\n\nfunction policylkup(clng_evnt)\n{\t\n<!-- 08/07/2013\tKarthikeyan K\tMMS-QH-CRF-0010\t36789 Starts -->\n\t\tvali";
    private final static byte[]  _wl_block9_3Bytes = _getBytes( _wl_block9_3 );

    private final static java.lang.String  _wl_block9_4 ="dAcrossEncounters();\n<!-- 08/07/2013\tKarthikeyan K\tMMS-QH-CRF-0010\t36789 Ends-->\n//alert(\'here\');\n\t\tvar target\t\t\t= document.forms[0].policy_type_desc;\t\t\n\n\t\tif(clng_evnt == \'B\')\n\t\t{\n\t\t\tif( target.value == \"\")\n\t\t\t{\t\n\t\t\t\tdocument.forms[0].policy_type_code.value = \"\";\n\t\t\t\tdocument.forms[0].policy_type_desc.value = \"\";\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\n\t\tvar retVal\t\t\t= new String();\t\n\n\t\tvar dialogTop\t\t\t= \"240\";\n\t\tvar dialogHeight\t\t= \"32\" ;\n\t\tvar dialogWidth\t\t\t= \"50\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar sql1\t\t\t\t= \"\";\t\t\n\n\t\tvar payer_desc\t\t= document.forms[0].payer_desc.value;\t\n\t\tvar facility_id\t\t= document.forms[0].facility_id.value;\t\n\t\tvar strModuleId = document.forms[0].calling_module_id.value;\n\t\tvar cust_code=document.forms[0].cust_3.value;\n\t\tvar cust_group_code=document.forms[0].ins_cust_group_code.value;\n\n\t\tvar policy_coverage_basis_gbl_ind=document.forms[0].policy_coverage_basis_gbl_ind.value;\n\n\t\tvar policy_coverage_basis_ind=document.forms[0].policy_coverage_basis_ind.value;\n\n\t\tvar totalRecords=document.forms[0].totalRecords.value;\n\n\t\tif (payer_desc.length == 0)\n\t\t\treturn;\n\t\tvar title=getLabel(\"eBL.POLICY.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\t\n\n\t\t//var column_sizes = escape(\"20%,60%,20%\");\n\n\t\tvar column_sizes = escape(\"20,60,20\");\n\n\t\tvar code=getLabel(\"Common.code.label\",\"common\");\n\t\tcode=encodeURIComponent(code);\t\n\t\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\t\tdesc=encodeURIComponent(desc);\t\n\n\t\tvar policy_coverage_basis_ind=getLabel(\"eBL.POLICY_COVERAGE_BASIS_IND.label\",\"BL\");\n\t\tpolicy_coverage_basis_ind=encodeURIComponent(policy_coverage_basis_ind);\t\n\n\t\tvar column_descriptions = code+\",\"+desc+\",\"+policy_coverage_basis_ind;\n\n\t\tvar patient_basd_plcy_leg = getLabel(\"eBL.PATIENT_BASED.label\",\"BL\");\n\t\tpatient_basd_plcy_leg=encodeURIComponent(patient_basd_plcy_leg);\n\n\t\tvar pyer_basd_plcy_leg = getLabel(\"eBL.PAYER_BASED.label\",\"BL\");\n\t\tpyer_basd_plcy_leg=encodeURIComponent(pyer_basd_plcy_leg);\n\n\t\tvar message = \'\';\t\t\n\n\t\tvar locale = document.forms[0].locale.value;\n//\t\tvar cust_3=document.forms[0].cust_3.value;\n\n\t\t \n\t\t\n//\t\tsql1 =\"Select policy_type_code POLICY_TYPE_CODE,short_desc SHORT_DESC from bl_ins_policy_types_lang_vw where language_id=\'\"+locale+\"\' and cust_code=\'\"+cust_3+\"\' and operating_facility_id=\'\"+facility_id+\"\' and nvl(status,\'N\') <> \'S\' \";\t\t\n\n//\t\tsql1 =\"Select a.policy_type_code POLICY_TYPE_CODE,a.short_desc SHORT_DESC from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b where a.language_id=\'\"+locale+\"\' and  a.operating_facility_id=\'\"+facility_id+\"\' and nvl(a.status,\'N\') <> \'S\' and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and b.cust_code=\'\"+cust_code+\"\' and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(b.outpatient_cover,\'N\') = \'Y\') or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(b.inpatient_covered,\'N\') = \'Y\') or \'\"+strModuleId+\"\' = \'MP\') \";\n\n\t\t//new one\n\n//\t\tsql1=\"Select DISTINCT a.policy_type_code POLICY_TYPE_CODE,a.short_desc SHORT_DESC,decode(b.policy_coverage_basis,\'I\',\'\"+pyer_basd_plcy_leg+\"\',\'P\',\'\"+patient_basd_plcy_leg+\"\') POLICY_COVERAGE_BASIS from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, ar_customer c where a.language_id=\'\"+locale+\"\' and  a.operating_facility_id=\'\"+facility_id+\"\' and nvl(a.status,\'N\') <> \'S\' and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and c.cust_code=\'\"+cust_code+\"\' and c.cust_group_code = b.cust_group_code and (b.cust_code=c.cust_code or b.cust_code = \'**\') and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(b.outpatient_cover,\'N\') = \'Y\') or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(b.inpatient_covered,\'N\') = \'Y\') or (\'\"+strModuleId+\"\' = \'MP\' and nvl(b.external_covered,\'N\') = \'Y\'))\";\n\n//    Query changed to match the CRF-134(Multiple Cust Group for single Customer) need\n\t//alert(sql1);\n\t\n\t//Change for Incident 41309 Starts\n\n\t\t\tsql1=\"Select DISTINCT a.policy_type_code POLICY_TYPE_CODE,a.short_desc SHORT_DESC,POLICY_COVERAGE_BASIS POLICY_COVERAGE_BASIS\"\n\t\t\t +\" from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c\" \n\t\t\t +\" where a.language_id=\'\"+locale+\"\'\" \n\t\t\t +\" and  a.operating_facility_id=\'\"+facility_id+\"\'\" \n\t\t   \t +\" and nvl(a.status,\'N\') <> \'S\'\"\n\t\t\t +\" and a.operating_facility_id = b.operating_facility_id\"  \n\t\t\t +\" and a.policy_type_code = b.policy_type_code\"\n\t\t\t +\" and c.cust_code=\'\"+cust_code+\"\'\" \n\t\t\t +\" and c.cust_group_code = b.cust_group_code\"\n\t\t\t +\" and (b.cust_code=c.cust_code or b.cust_code = \'**\')\"\n\t\t\t +\" AND b.cust_group_code = \'\"+cust_group_code+\"\'\" \n\t\t\t +\" and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(b.outpatient_cover,\'N\') = \'Y\')\" \n\t\t\t +\" or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(b.inpatient_covered,\'N\') = \'Y\')\"\n\t\t\t +\" or (\'\"+strModuleId+\"\' = \'MP\' and nvl(b.external_covered,\'N\') = \'Y\'))\";\t\t\t \n\t\n\t\t//\tsql1=document.forms[0].sql1.value;\n\t\t//\tsql1=sql1+\" and c.cust_code=\'\"+cust_code+\"\' AND b.cust_group_code = \'\"+cust_group_code+\"\'\" ;\n\t\t\t\n\t //\tChange for Incident 41309 Starts\n\n\t\n\t\t\t//param =\"called_from=\"plcylookup\"+\"&locale=\"+locale+\"&facility_id=\"+facility_id+\"&cust_code=\"+cust_code+\"&cust_grp_code=\"+cust_group_code+\"&module_id=\"+strModuleId;\n\n\t\tvar action=document.forms[0].action.value;\n\t\tvar locn=document.forms[0].locn.value;\n\t\t//Added by Rajesh V\n\t\tvar link_policy_in_billing = \'N\';\n\t\t//Added by Rajesh V\n\t\tif(totalRecords>1 || (action==\"add\" && totalRecords>=1))\n\t\t{\n\t\t\tif(policy_coverage_basis_gbl_ind==\"I\")\n\t\t\t{\n\t\t\t\tsql1=sql1+\" and b.POLICY_COVERAGE_BASIS=\'\"+policy_coverage_basis_gbl_ind+\"\'\";\n\t\t\t}\n\t\t}\n\t\t\n\t\t/*Added by karthik to change the query for Policy specific changes*/\n\t\t  ";
    private final static byte[]  _wl_block9_4Bytes = _getBytes( _wl_block9_4 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t//Added by Rajesh V\n\t\t  \tlink_policy_in_billing = \'Y\';\n\t\t  //Added by Rajesh V\n\t\t\tsql1 += \"and trunc(SYSDATE) BETWEEN NVL(b.POLICY_EFF_FROM,SYSDATE-1) and NVL(b.POLICY_EFF_TO,SYSDATE) \";\n\t\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11_0 ="\n\n\t\t\n\t\t \n\t\tsql = escape(sql1);\n\t\t\n\t//\tsql = sql1;\n\n\t//\tvar param = \"sql=\"+sql+\"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYY\";\n\n\n\t//Modified by Rajesh V\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYY\"+\"&called_for=POLICYLUKP\"+\n\t\t\t\t\"&locale=\"+locale+\"&facility_id=\"+facility_id+\"&cust_code=\"+cust_code+\"&cust_group_code=\"+cust_group_code+\"&strModuleId=\"+strModuleId+\n\t\t\t\t\"&totalRecords=\"+totalRecords+\"&action=\"+action+\"&policy_coverage_basis_gbl_ind=\"+policy_coverage_basis_gbl_ind+\"&link_policy_in_billing=\"+link_policy_in_billing;\n\n\t//Modified by Rajesh V\n\t\t//alert(param);\n\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\n\t\tvar arr=new Array();\t\t\n\n\t    if(retVal == null) retVal=\'\';\n\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tarr=retVal.split(\"^~^\");\t\n\t\n\t\t\t\tdocument.forms[0].policy_type_desc.value=arr[1];\n\t\t\t\tdocument.forms[0].policy_type_code.value=arr[0];\n\t\t\t\t//\t\t\t\ttarget.focus();\n\t\t\t\t//\t\t\t\tapprvd_amt_days_check();\n\t\t\t\t//\t\t\t\tsetTimeout(\'apprvd_amt_days_check()\',200);\n\t\t\t\tif(apprvd_amt_days_check())\n\t\t\t\t{\n\t\t\t\t\tadjustment_rule();\n\t\t\t\t}\n\t\t\t\tdocument.forms[0].valid_policy_type_code_YN.value=\"Y\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].policy_type_desc.value=\"\";\n\t\t\t\tdocument.forms[0].policy_type_code.value=\"\";\n\t\t\t\tdocument.forms[0].valid_policy_type_code_YN.value=\"N\";\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].policy_type_desc.value=\"\";\n\t\t\tdocument.forms[0].policy_type_code.value=\"\";\n\t\t\tdocument.forms[0].valid_policy_type_code_YN.value=\"N\";\n\t\t}\n\n/* ***************GHL-0020 SCRUM CRF related changes ***************** */\n\t\tvar cust_code=document.forms[0].cust_3.value;\n\t\tvar policy_type_code=document.forms[0].policy_type_code.value;\n\t\tvar ins_cust_group_code=document.forms[0].ins_cust_group_code.value;\n\n\t\tif((!(cust_code==\"\")) && (!(policy_type_code==\"\"))&&(!(ins_cust_group_code==\"\")))\n\t\t{\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\n\t\t\t//var cust_code=document.forms[0].cust_3.value;\n\t\t\t//var policy_type_code=document.forms[0].policy_type_code.value;\n\t\t\tvar facility_id=document.forms[0].facility_id.value;\n\t\t\t//var cust_group_code=document.forms[0].ins_cust_group_code.value;\n\t\t\tvar encounter_date_time=document.forms[0].encounter_date_time.value;\n\n\t\t\tvar param=\"encounter_date_time=\"+encodeURIComponent(encounter_date_time)+\"&cust_code=\"+encodeURIComponent(cust_code)+\"&policy_type_code=\"+encodeURIComponent(policy_type_code)+\"&cust_group_code=\"+cust_group_code+\"&facility_id=\"+facility_id+\"&called_from=pocy_date_valid\";\n\n\t\t\tvar temp_jsp=\"../../eBL/jsp/BLInsuranceValidations.jsp?\"+param;\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tresponseText=trimString(xmlHttp.responseText);\n\n\t\t\tvar retVal = responseText.split(\"&^&\");\n\t\t\tvar cust_id =  document.forms[0].cust_id.value;\n\t\t\t\n\t\t//\talert(\'retVal \'+retVal);\n\t\t\t\n\t\t\t\n\t\t\tif(retVal[0]!=\'\'&&retVal[1]!=\'\' && cust_id !=\'ALMO\') \n\t\t\t{\n\t\t\n\t\t\t\t/*\n\t\t\t\tdocument.forms[0].policy_start_date.value=retVal[0];\n\t\t\t\tdocument.forms[0].policy_exp_date.value=retVal[1];\n\t\t\t\t*/\n\t\t\t\t/*RUT-SCF-0195: Change done by Karthik on 3/4/2013 to Provide Locale */\n\t\t\t\tvar pStDate=convertDate(retVal[0],\"DMY\",\"en\",locale);\n\t\t\t\tvar pExDate=convertDate(retVal[1],\"DMY\",\"en\",locale);\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\tdocument.forms[0].policy_start_date.value=pStDate;\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\tdocument.forms[0].policy_exp_date.value=pExDate;\n\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\tchkPolicyStartDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);\n\n\t\t\t\tchkPolicyExpiryDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);\n\t\t\t}\n/*\n\t\t\telse\n            {\n\t\t\t\tdocument.forms[0].policy_eff_frm_date.value=retVal[0];\n\t\t\t\tdocument.forms[0].policy_eff_to_date.value=retVal[1];\n\n\t\t\t}\n*/\n\n\t\t }\n\n\t\t /*\n\t\t * Defaulting policy start and end  dates based on policys \n\t\t */\n/* ***************GHL-0020 SCRUM CRF related changes ***************** */\t \n//alert(\'before check_for_related_policies\'); \ncheck_for_related_policies(\'B\');\n\t\tvar chargeLogicYn = document.forms[0].chargeLogicYn.value;\n\t\t/* Code changes by Boopath for efault - PolicyStartdate /End date Approved Amounmt , Aprroved no of days Starts Here */\t \n\t\t//Rajesh V\t\t\n\t\tif(chargeLogicYn == \'Y\'){\n\t\t\t if(strModuleId==\"OP\" || strModuleId==\"IP\" \n\t\t\t\t\t || strModuleId==\"DC\" || strModuleId==\"AE\"||strModuleId==\"MP\") \n\t\t\t {\n\t\t\t\t if(policy_type_code!=null && policy_type_code!=\"\")\n\t\t\t\t {\n\t\t\t\t\t LoadDefaultPolicyDateAndApprovedAmount(cust_group_code,cust_code,policy_type_code,strModuleId);\t \n\t\t\t\t\t document.forms[0].plcyorEncounter.value = \'policy\';\n\t\t\t\t }\n\t\t \n\t\t\t }\n\t\t}\n\t\t /* Code changes by Boopath for efault - PolicyStartdate /End date Approved Amounmt , Aprroved no of days Ends Here */\n\t\t\t\t\n\t\t \n\t\t\n\t\t\n}\n\nfunction policyDateHandle()\n{\n\t\n\tdflt_policy_exp_date();\n\t\n\tdflt_policy_eff_to_date();\n\t\n\tvar pStDate = document.forms[0].policy_start_date.value;\n\tvar pExDate = document.forms[0].policy_exp_date.value;\n\t\n\t\t\n\t\n\t\n\t\t\n\t//pStDate  = pStDate.trim();\n\t//pExDate  = pExDate.trim();\n\tif( pStDate !=\'\')\t\t\t\n\t\t{\n\t\n\t\tdocument.forms[0].plcyStrtCalen.disabled = true;\n\t\tdocument.forms[0].policy_start_date.readOnly = true;\t\t\n\t\t}\n\telse\n\t\t{\n\t\tdocument.forms[0].plcyStrtCalen.disabled = false;\n\t\tdocument.forms[0].policy_start_date.readOnly = false;\n\t\t}\n\t\t\n\t\n\tif(pExDate !=\'\')\n\t\t{\t\t\t\t\t\n\t\n\t\tdocument.forms[0].plcyExpCalen.disabled = true;\t\t\n\t\tdocument.forms[0].policy_exp_date.readOnly = true;\n\t\t}\n\telse\n\t\t{\n\t\t\n\t\tdocument.forms[0].plcyExpCalen.disabled = false;\t\t\n\t\tdocument.forms[0].policy_exp_date.readOnly = false;\n\t\tdocument.forms[0].plcyExpCalen.disabled = false;\n\t\t}\n\t\n\tvar approvedAmt = document.forms[0].credit_apprd_amt;\n\t\n\t\n\tif(approvedAmt.value !=\'\' && approvedAmt.value != null)\n\t{\t\t\t\t\t\n\tdocument.forms[0].credit_apprd_amt.readOnly = true;\n\t}\nelse\n\t{\t\n\tdocument.forms[0].credit_apprd_amt.readOnly = false;\n\t}\n\t\n\tvar approved_days =  document.forms[0].credit_apprd_days ;\n\t\n\tif(approved_days.value !=\'\' && approved_days.value != null)\n\t{\t\t\t\t\t\n\tdocument.forms[0].credit_apprd_days.readOnly = true;\n\t}\nelse\n\t{\t\n\tdocument.forms[0].credit_apprd_days.readOnly = false;\n\t}\n\t\n\t\n\tif(document.forms[0].policy_eff_frm_date.value == \'\'){\n\t\tdocument.forms[0].policy_eff_frm_date.value = document.forms[0].todayFormated.value;\n\t}\n\t\n\t\n\t\n\t\n}\n\n\nfunction  validate_eff_to_apprday()\n{\n\t\n\t\n\t\n\tvar policy_eff_frm_date=document.forms[0].policy_eff_frm_date;\n\tvar policy_eff_to_date  =  document.forms[0].policy_eff_to_date.value;\n\tvar approved_days =  document.forms[0].credit_apprd_days ;\n\t\n\tvar cust_id =  document.forms[0].cust_id.value;\n\t\n\tif(cust_id != \'ALMO\') return;\n\t\n\tvar locale = document.forms[0].locale.value;\n\n\tvar pol_validity_chk_date;\t\n\t\n\t\n\t\t\n\t\t\tif(approved_days.value != \'\' &&  approved_days.value != null  && policy_eff_to_date != \'\' && policy_eff_to_date != null && policy_eff_frm_date.value != null && policy_eff_frm_date.value != \'\')\n\t\t\t{\t\t\t       \n\t\t\n\t\t\t pol_validity_chk_date = plusDate(policy_eff_frm_date.value,\'DMY\',locale,eval(approved_days.value)-1,\'d\');\n\t\t\t \n\t\n\t\t\t if(!isBefore(policy_eff_to_date,pol_validity_chk_date,\'DMY\',locale))\n\t\t\t\t {\n\t\n\t\t\t\t alert(getMessage(\"BL00280\",\"BL\"));\n\t\t\t\t document.forms[0].policy_eff_to_date.value\t= pol_validity_chk_date;\n\t\t\t\t document.forms[0].policy_eff_to_date.focus();\n\t\t\t\t }\n\t\t\t \n\t\t\t}\n\t\n\t}\n\nfunction  dflt_policy_exp_date()\n{\n\t\n\tvar approved_days =  document.forms[0].credit_apprd_days ;\n\tvar exp_days  =  document.forms[0].exp_days ;\n\tvar policy_start_date = document.forms[0].policy_start_date;\n\t\n\tvar policy_exp_date =document.forms[0].policy_exp_date.value; \n\t\n\t\t\n\tvar locale = document.forms[0].locale.value;\n\n\tvar pol_validity_chk_date=\'\';\n\t\n\t\n\t\n\t\n\t\n\tif( policy_exp_date == \'\' || policy_exp_date == null || policy_exp_date == \'undefined\' || policy_exp_date == \'null\')\n\t\t{\n\t\n\t\n\t\t\n\tif( exp_days.value != \'\'  && exp_days.value != null)\n\t  {\n\t  pol_validity_chk_date = plusDate(policy_start_date.value,\'DMY\',locale,eval(exp_days.value)-1,\'d\');\n\n\t  }\n/*\n  Commented by  Dhanasekar as per karups & paban info  on 8/10/2013\n\telse if(approved_days.value != \'\' &&  approved_days.value != null)\n\t{\t\t\t       \n\n \tpol_validity_chk_date = plusDate(policy_start_date.value,\'DMY\',locale,eval(approved_days.value)-1,\'d\');\n\n\t}\n*/\n  document.forms[0].policy_exp_date.value  = \t pol_validity_chk_date;\n\t\t}\n\t\n\t}\n\n\nfunction  dflt_policy_eff_to_date()\n{\n\t\n\t\n\tvar policy_exp_date=document.forms[0].policy_exp_date.value;\n\tvar policy_eff_frm_date=document.forms[0].policy_eff_frm_date;\n\tvar policy_eff_to_date=document.forms[0].policy_eff_to_date; \n\tvar approved_days =  document.forms[0].credit_apprd_days ;\n\tvar exp_days  =  document.forms[0].exp_days ;\n\t\n\tvar cust_id =  document.forms[0].cust_id.value;\n\t\n\tif(cust_id != \'ALMO\') return;\n\t\n\tvar locale = document.forms[0].locale.value;\n\n\tvar encounter_date_trunc =  document.forms[0].encounter_date_aft_trunc;\n\t\n\t\n\t if(policy_eff_frm_date.value !=\'\' && encounter_date_trunc.value != \'\' && !isBefore(policy_eff_frm_date.value,encounter_date_trunc.value,\'DMY\',locale))\n\t {\n\t\t\t//Added by Rajesh V - If logic\n\t\t\tvar strModuleId = document.forms[0].calling_module_id.value;\n\t\t\tif(!isBefore(policy_eff_frm_date.value,encounter_date_trunc.value,\'DMY\',locale)){\n\t\t\t\tif(strModuleId != \'MP\'){\n\t\t\t\t\t alert(getMessage(\"BL8222\",\"BL\"));\t \n\t\t\t\t\t document.forms[0].policy_eff_frm_date.value = encounter_date_trunc.value;\n\t\t\t\t\t document.forms[0].policy_eff_frm_date.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t\telse{\n\t\t\t\talert(getMessage(\"BL8222\",\"BL\"));\t \n\t\t\t\t document.forms[0].policy_eff_frm_date.value = encounter_date_trunc.value;\n\t\t\t\t document.forms[0].policy_eff_frm_date.focus();\n\t\t\t}\n\t\t\t//Added by Rajesh V - If logic\n\t }\n/* MMS-DM-SCF-0212 - Temp Policy Effective date changed as \'EffectiveToDate\', earlier is Assigned to null,  */\t\nvar pol_validity_chk_date=policy_eff_to_date.value;\n\nif(approved_days.value != \'\' &&  approved_days.value != null)\n{\t      \n\n pol_validity_chk_date = plusDate(policy_eff_frm_date.value,\'DMY\',locale,eval(approved_days.value)-1,\'d\');\n}\nelse if( exp_days.value != \'\'  && exp_days.value != null)\n  {\n  pol_validity_chk_date = plusDate(policy_eff_frm_date.value,\'DMY\',locale,eval(exp_days.value)-1,\'d\');\n  }\n\nif( pol_validity_chk_date == null || pol_validity";
    private final static byte[]  _wl_block11_0Bytes = _getBytes( _wl_block11_0 );

    private final static java.lang.String  _wl_block11_1 ="_chk_date == \'\' || ( policy_exp_date.value!=undefined && !isBefore(pol_validity_chk_date.value,policy_exp_date.value,\'DMY\',locale)))\n  {\n\tdocument.forms[0].policy_eff_to_date.value  = \tpolicy_exp_date;\n\n  }\n else\t\t    \t\n  {\n  document.forms[0].policy_eff_to_date.value  = \t pol_validity_chk_date;\n }\n\nif(validDateObj(policy_eff_frm_date,\"DMY\",locale) && validDateObj(document.forms[0].policy_eff_to_date,\"DMY\",locale) && isBefore(policy_eff_frm_date.value,document.forms[0].policy_eff_to_date.value,\"DMY\",locale)){\n\tvar approvedDays = daysBetween(policy_eff_frm_date.value,document.forms[0].policy_eff_to_date.value,\'DMY\',locale);\n\tapprovedDays = parseInt(approvedDays)+parseInt(1);\n\tapproved_days.value = approvedDays;\n}\n\n\t}\n\n/* Code changes by Boopath for efault - PolicyStartdate /End date Approved Amounmt , Aprroved no of days Starts Here */\nfunction LoadDefaultPolicyDateAndApprovedAmount(cust_group_code,cust_code,policy_type_code,strModuleId)\n{\n\t \n\t\n//\talert(\"IN LoadDefaultPolicyDateAndApprovedAmount::::: \");\n//\talert(\"CUSTOM GROUP CODE::::: \"+cust_group_code);\n//\t alert(\"cust_code::::: \"+cust_code);\n//\t alert(\"policy_type_code::::: \"+policy_type_code);\n\t //alert(\"policy_type_desc::::: \"+policy_type_desc);\n\t \n\t \n\t// alert(\"strModuleId::::::\"+strModuleId);\n\t\n\tvar out;\n\t\n\tvar xmlhttp;    \n\t/*if (str==\"\")\n\t  {\n\t  document.getElementById(\"txtHint\").innerHTML=\"\";\n\t  return;\n\t  }*/\n\tif (window.XMLHttpRequest)\n\t  {// code for IE7+, Firefox, Chrome, Opera, Safari\n\t  xmlhttp=new XMLHttpRequest();\n\t  }\n\telse\n\t  {// code for IE6, IE5\n\t  //xmlhttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t  xmlHttp = new XMLHttpRequest();\n\t  }\n\txmlhttp.onreadystatechange=function()\n\t  {\n\t  if (xmlhttp.readyState==4 && xmlhttp.status==200)\n\t    {\n\t\t  out = xmlhttp.responseText;\n\t\t  var response = out.substring(out.indexOf(\"!\")+1,out.length);\n\t\t  var actual=response.split(\"~\");\n\t\t  \n\t\t  \n\t\t  if(actual[0]!=null && actual[0] !=\'undefined\')\n\t\t  document.forms[0].policy_start_date.value = actual[0];\n\t\t  if(actual[1]!=null && actual[1] !=\'undefined\')\n\t\t  document.forms[0].policy_exp_date.value \t= actual[1];\n\t\t  if(actual[2]!=null && actual[2] !=\'undefined\')\n\t\t  document.forms[0].credit_apprd_days.value = actual[2];\n\t\t  if(actual[3]!=null && actual[3] !=\'undefined\')\n\t\t  document.forms[0].credit_apprd_amt.value \t= actual[3];\n\t\t  if(actual[4]!=null && actual[4] !=\'undefined\')\n\t\t  document.forms[0].exp_days.value \t= actual[4];\n\t\t\t  \n\t\t  \n\t\t  var custid = document.forms[0].cust_id.value;\t\n\t\t\n\t\t  if(custid==\'ALMO\') \t\t\t policyDateHandle();\n\t\t  \n\t    }\n\t  }\n\txmlhttp.open(\"POST\",\"../../eBL/jsp/LoadDefaultPolicyDateAndApprovedAmount.jsp?cust_group_code=\"+cust_group_code+\"&cust_code=\"+cust_code+\"&policy_type_code=\"+policy_type_code+\"&strModuleId=\"+strModuleId,true);\n\txmlhttp.send(null);\n\t\n\n}\n\n/* Code changes by Boopath for efault - PolicyStartdate /End date Approved Amounmt , Aprroved no of days Ends Here */\n\nfunction LoadDefaultPolicydetails(cust_group_code,cust_code,policy_type_code,strModuleId)\n{\n\t \n\t\n//\talert(\"IN LoadDefaultPolicyDateAndApprovedAmount::::: \");\n//\talert(\"CUSTOM GROUP CODE::::: \"+cust_group_code);\n//\t alert(\"cust_code::::: \"+cust_code);\n//\t alert(\"policy_type_code::::: \"+policy_type_code);\n\t //alert(\"policy_type_desc::::: \"+policy_type_desc);\n\t \n\t \n\t// alert(\"strModuleId::::::\"+strModuleId);\n\t\n\tvar out;\n\t\n\tvar xmlhttp;    \n\t/*if (str==\"\")\n\t  {\n\t  document.getElementById(\"txtHint\").innerHTML=\"\";\n\t  return;\n\t  }*/\n\tif (window.XMLHttpRequest)\n\t  {// code for IE7+, Firefox, Chrome, Opera, Safari\n\t  xmlhttp=new XMLHttpRequest();\n\t  }\n\telse\n\t  {// code for IE6, IE5\n\t  //xmlhttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t  xmlHttp = new XMLHttpRequest();\n\t  }\n\txmlhttp.onreadystatechange=function()\n\t  {\n\t  if (xmlhttp.readyState==4 && xmlhttp.status==200)\n\t    {\n\t\t  out = xmlhttp.responseText;\n\t\t  var response = out.substring(out.indexOf(\"!\")+1,out.length);\n\t\t  var actual=response.split(\"~\");\n\t\t  \n\t\t  \n\t\t  if(actual[0]!=null && actual[0] !=\'undefined\' && (document.forms[0].policy_start_date.value == \'\' || document.forms[0].policy_start_date.value == undefined) )\n\t\t  document.forms[0].policy_start_date.value = actual[0];\n\t\t  if(actual[1]!=null && actual[1] !=\'undefined\' && (document.forms[0].policy_exp_date.value == \'\' || document.forms[0].policy_exp_date.value == undefined) )\n\t\t  document.forms[0].policy_exp_date.value \t= actual[1];\n\t\t  if(actual[2]!=null && actual[2] !=\'undefined\' && (document.forms[0].credit_apprd_days.value == \'\' || document.forms[0].credit_apprd_days.value == undefined) )\n\t\t  document.forms[0].credit_apprd_days.value = actual[2];\n\t\t  if(actual[3]!=null && actual[3] !=\'undefined\' && (document.forms[0].credit_apprd_amt.value == \'\' || document.forms[0].credit_apprd_amt.value == undefined) )\n\t\t  document.forms[0].credit_apprd_amt.value \t= actual[3];\n\t\t  if(actual[4]!=null && actual[4] !=\'undefined\' && (document.forms[0].exp_days.value == \'\' || document.forms[0].exp_days.value == undefined) )\n\t\t  document.forms[0].exp_days.value \t= actual[4];\n\t\t\t  \n\t\t  \n\t\t  var custid = document.forms[0].cust_id.value;\t\n\t\t\n\t\t  if(custid==\'ALMO\') \t\t\t policyDateHandle();\n\t\t  \n\t    }\n\t  }\n\txmlhttp.open(\"POST\",\"../../eBL/jsp/LoadDefaultPolicyDateAndApprovedAmount.jsp?cust_group_code=\"+cust_group_code+\"&cust_code=\"+cust_code+\"&policy_type_code=\"+policy_type_code+\"&strModuleId=\"+strModuleId,true);\n\txmlhttp.send(null);\n\t\n\n}\n\nfunction temp_test()\n{\n\t\n}\nfunction adjustment_rule()\n{\n\tvar payer_desc=document.forms[0].payer_desc.value;\n\tvar policy_type_desc=document.forms[0].policy_type_desc.value;\n\tvar priority=document.forms[0].priority.value;\n\tvar billing_group=\"\";\n\tvar blng_grp_select=\"\";\n\tvar action=document.forms[0].action.value;\n\tvar locn=document.forms[0].locn.value;\n\tif(action==\"add\" && locn==\"outside\")\n\t{\n\t\tbilling_group=document.forms[0].select_billing_group.value;\n\t}\n\telse if(action==\"add\" && locn==\"inside\")\n\t{\n\t\tbilling_group=document.forms[0].blng_grp_code.value;\n\t}\n\telse\n\t{\n\t\tbilling_group=document.forms[0].blng_grp_code.value;\n\t}\n\n\tvar facility_id=document.forms[0].facility_id.value;\n\tvar patient_class=document.forms[0].p_patient_class.value;\n\t\n\tif(action==\"add\" && locn==\"outside\")\n\t{\n\t\tif((!(payer_desc==\"\")) && (!(policy_type_desc==\"\")) && (!(priority==\"\")) && (!(billing_group==\"\")))\n\t\t{\n\t\t\tvar cust_group_code = document.forms[0].ins_cust_group_code.value;\n\t\t\tvar cust_code=document.forms[0].cust_3.value;\n\t\t\tvar policy_type_code=document.forms[0].policy_type_code.value;\n\t\t\tcust_code=encodeURIComponent(cust_code);\n\t\t\tpolicy_type_code=encodeURIComponent(policy_type_code);\n/*\t\t\tparent.frames[1].location.href=\"../../eBL/jsp/BLInsuranceValidations.jsp?cust_code=\"+cust_code+\"&policy_type_code=\"+policy_type_code+\"&priority=\"+priority+\"&facility_id=\"+facility_id+\"&billing_group=\"+billing_group+\"&patient_class=\"+patient_class+\"&called_from=adj_rul\";\n*/\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t\n\t\t\tvar param=\"cust_group_code=\"+encodeURIComponent(cust_group_code)+\"&cust_code=\"+encodeURIComponent(cust_code)+\"&policy_type_code=\"+encodeURIComponent(policy_type_code)+\"&priority=\"+priority+\"&facility_id=\"+facility_id+\"&billing_group=\"+encodeURIComponent(billing_group)+\"&patient_class=\"+patient_class+\"&called_from=adj_rul\";\n\t\t\tvar temp_jsp=\"../../eBL/jsp/BLInsuranceValidations.jsp?\"+param;\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tresponseText=trimString(xmlHttp.responseText);\n\n\t\t\tvar retVal = responseText.split(\"&^&\");\n\n\t\t\tdocument.forms[0].adj_rule_ind.value=retVal[0];\n\t\t\tdocument.forms[0].adj_perc_amt_ind.value=retVal[1];\n\t\t\tdocument.forms[0].adj_perc_amt_value.value=retVal[2];\n\t\t\tif(document.forms[0].adj_perc_amt_value.value != \" \" && document.forms[0].adj_perc_amt_value.value != \"\")\n\t\t\t{\n\t\t\t\tput_decimal(document.forms[0].adj_perc_amt_value,document.forms[0].noofdecimal.value);\n\t\t\t}\n\t\t\tdocument.forms[0].pmnt_diff_adj_int.value=retVal[3];\n\t\t\tdocument.forms[0].drg_pmnt_diff_adj_int.value=retVal[4];\n\t\t\tdocument.forms[0].spl_srv_pmnt_diff_adj_int.value=retVal[5];\n\t\t\tdocument.forms[0].pmnt_diff_adj_int_desc.value = retVal[6];\n\n\t\t\tif(document.forms[0].adj_rule_ind.value == \"A\")\n\t\t\t\tdocument.forms[0].adj_rule_ind_lis.value = \"AUT\";\n\t\t\telse\n\t\t\t\tdocument.forms[0].adj_rule_ind_lis.value = \"NA\";\n\t\t\tif(document.forms[0].adj_perc_amt_ind.value == \"P\")\n\t\t\t\tdocument.forms[0].adj_perc_amt_ind_lis.value = \"PER\";\n\t\t\telse if(document.forms[0].adj_perc_amt_ind.value == \"A\")\n\t\t\t\tdocument.forms[0].adj_perc_amt_ind_lis.value = \"AMT\";\n\t\t\telse\n\t\t\t\tdocument.forms[0].adj_perc_amt_ind_lis.value = \"\";\n\t\t}\n\t}\n\telse\n\t{\n\t\tif((!(payer_desc==\"\")) && (!(policy_type_desc==\"\")) && (!(priority==\"\")))\n\t\t{\n\t\t\tvar cust_group_code = document.forms[0].ins_cust_group_code.value;\n\t\t\tvar cust_code=document.forms[0].cust_3.value;\n\t\t\tvar policy_type_code=document.forms[0].policy_type_code.value;\n\t\t/*\tparent.frames[1].location.href=\"../../eBL/jsp/BLInsuranceValidations.jsp?cust_code=\"+cust_code+\"&policy_type_code=\"+policy_type_code+\"&priority=\"+priority+\"&facility_id=\"+facility_id+\"&billing_group=\"+billing_group+\"&patient_class=\"+patient_class+\"&called_from=adj_rul\";\n\t\t*/\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t\n\t\t\tvar param=\"cust_group_code=\"+encodeURIComponent(cust_group_code)+\"&cust_code=\"+encodeURIComponent(cust_code)+\"&policy_type_code=\"+encodeURIComponent(policy_type_code)+\"&priority=\"+priority+\"&facility_id=\"+facility_id+\"&billing_group=\"+encodeURIComponent(billing_group)+\"&patient_class=\"+patient_class+\"&called_from=adj_rul\";\n\t\t\tvar temp_jsp=\"../../eBL/jsp/BLInsuranceValidations.jsp?\"+param;\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tresponseText=trimString(xmlHttp.responseText);\n\n\t\t\tvar retVal = responseText.split(\"&^&\");\n\n\t\t\tdocument.forms[0].adj_rule_ind.value=retVal[0];\n\t\t\tdocument.forms[0].adj_perc_amt_ind.value=retVal[1];\n\t\t\tdocument.forms[0].adj_perc_amt_value.value=retVal[2];\n\t\t\tif(document.forms[0].adj_perc_amt_value.value != \" \" && document.forms[0].adj_perc_amt_value.value != \"\")\n\t\t\t{\n\t\t\t\tput_decimal(document.forms[0].adj_perc_amt_value,document.forms[0].noofdecimal.value);\n\t\t\t}\n\t\t\tdocument.forms[0].pmnt_diff_adj_int.value=retVal[3];\n\t\t\tdocument.forms[0].drg_pmnt_diff_adj_int.value=retVal[4];\n\t\t\tdocument.forms[0].spl_srv_pmnt_diff_adj_int.value=retVal[5];\n\t\t\tdocument.forms[0].pmnt_diff_adj_int_desc.value = retVal[6];\n\n\t\t\tif(document.forms[0].adj_rule_ind.value == \"A\")\n\t\t\t\tdocument.forms[0].adj_rule_ind_lis.value = \"AUT\";\n\t\t\telse\n\t\t\t\tdocument.forms[0].adj_rule_ind_lis.value = \"NA\";\n\t\t\tif(docu";
    private final static byte[]  _wl_block11_1Bytes = _getBytes( _wl_block11_1 );

    private final static java.lang.String  _wl_block11_2 ="ment.forms[0].adj_perc_amt_ind.value == \"P\")\n\t\t\t\tdocument.forms[0].adj_perc_amt_ind_lis.value = \"PER\";\n\t\t\telse if(document.forms[0].adj_perc_amt_ind.value == \"A\")\n\t\t\t\tdocument.forms[0].adj_perc_amt_ind_lis.value = \"AMT\";\n\t\t\telse\n\t\t\t\tdocument.forms[0].adj_perc_amt_ind_lis.value = \"\";\n\t\t}\n\t}\n\treturn true;\n//\tapprvd_amt_days_check();\n}\n\nfunction disableAllElements_modify()\n{\n\tvar len = document.forms[0].elements.length;\n\n\tfor(var i=0;i<len;i++)\n\t{\n\t\tdocument.forms[0].elements(i).disabled=true;\n\t}\n\tdocument.forms[0].modify_button.disabled=false;\n\tdocument.forms[0].cancel_button.disabled=false;\n}\n\nfunction disableAllElements_remove()\n{\n\tvar len = document.forms[0].elements.length;\n\n\tfor(var i=0;i<len;i++)\n\t{\n\t\tdocument.forms[0].elements(i).disabled=true;\n\t}\n//\tdocument.forms[0].remove_button.disabled=false;\n\tdocument.forms[0].cancel_button.disabled=false;\n}\n\nfunction enableAllElements_modify()\n{\n\tvar len = document.forms[0].elements.length;\n\tfor(var i=0;i<len;i++)\n\t{\n\t\tdocument.forms[0].elements(i).disabled=false;\n\t}\n//\tdocument.forms[0].remove_button.disabled=true;\n\tdocument.forms[0].modify_button.disabled=true;\n\n\tvar restricted_YN=document.forms[0].restricted_YN.value;\n\n\tif(restricted_YN==\"DISABLED\")\n\t{\n\t\tdocument.forms[0].credit_apprd_amt.disabled=true;\n\t\tdocument.forms[0].credit_apprd_days.disabled=true;\n\t}\n}\n\n\nfunction remove_payer()\n{\n\n\tparent.window.returnValue = \"remove\";\n\tparent.window.close();\n\t\n}\n\nfunction chkPolicyStartDateMain(policy_start_date,policy_exp_date,encounter_date)\n{\n\tif(chkPolicyStartDate(policy_start_date,policy_exp_date,encounter_date))\n\t\treturn dflt_policy_eff_frm_to_date();\n\telse\n\t\treturn false;\n}\n\nfunction chkPolicyExpiryDateMain(policy_start_date,policy_exp_date,encounter_date)\n{\n\t\n\tif(chkPolicyExpiryDate(policy_start_date,policy_exp_date,encounter_date))\n\t\treturn dflt_policy_eff_frm_to_date();\n\telse\n\t\treturn false;\n}\n\nfunction chkPolicyEffFromDateMain(policy_eff_frm_date,policy_eff_to_date,policy_start_date,policy_exp_date,encounter_date_aft_trunc)\n{\n\t\n\tvar blng_grp_code = document.forms[0].blng_grp_code.value;\n\tvar payer_group_code = document.forms[0].ins_cust_group_code.value;\n\tvar payer_code = document.forms[0].cust_3.value;\n\tvar policy_type_code = document.forms[0].policy_type_code.value;\n\tvar policy_no = document.forms[0].policy_no.value;\n\tvar priority = document.forms[0].priority.value;\n\n\tif(policy_eff_frm_date.value != \"\")\n\t{\n\t\tif(chkPolicyEffFromDate(policy_eff_frm_date,policy_eff_to_date,policy_start_date,policy_exp_date,encounter_date_aft_trunc))\n\t\t{\n\t\t\tif(chk_pol_eff_date_validity(policy_eff_frm_date,\'I\'))\n\t\t\t{\n\t\t\t\treturn pol_eff_dates_check(blng_grp_code,payer_group_code,payer_code,policy_type_code,policy_no,priority,policy_start_date,policy_exp_date,policy_eff_frm_date,policy_eff_to_date);\n\t\t\t}\n\t\t\telse\n\t\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t\treturn false;\n\t}\n\telse\n\t\treturn true;\n}\n\nfunction set_blng_values()\n{\n\tdocument.forms[0].blng_grp_code.value=document.forms[0].select_billing_group.value;\n\tvar billing_group =document.forms[0].blng_grp_code.value;\n\n//\tparent.frames[1].location.href=\"../../eBL/jsp/BLInsuranceValidations.jsp?billing_group=\"+billing_group+\"&called_from=bg_curr_code\";\n\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\t\n\tvar param=\"billing_group=\"+encodeURIComponent(billing_group)+\"&called_from=bg_curr_code\";\n\tvar temp_jsp=\"../../eBL/jsp/BLInsuranceValidations.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tresponseText=trimString(xmlHttp.responseText);\n\tdocument.forms[0].curr_code_for_bg.value=responseText;\n}\n\nfunction set_selected_blng_grp()\n{\n\tvar curr_code_for_bg = document.forms[0].curr_code_for_bg.value;\n\t\n\tif(curr_code_for_bg == \'\' || curr_code_for_bg == null || curr_code_for_bg == \'null\' || curr_code_for_bg ==undefined ||curr_code_for_bg == \'undefined\')\n\t\t{\n\t\tset_blng_values();\n\t\tcheck_priority();\n\t\t}\n\t\t\n\t}\n\nfunction apprvd_amt_days_check()\n{\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar facility_id=document.forms[0].facility_id.value;\n\tvar cust_group_code=document.forms[0].ins_cust_group_code.value;\n\tvar cust_code=document.forms[0].cust_3.value;\n\tvar policy_type_code=document.forms[0].policy_type_code.value;\n\tvar payer_desc=document.forms[0].payer_desc.value;\n\tvar policy_type_desc=document.forms[0].policy_type_desc.value;\n\tvar policy_no=document.forms[0].policy_no.value; \n\tvar credit_auth_ref = document.forms[0].credit_auth_ref.value;\n\tvar credit_auth_date = document.forms[0].credit_auth_date.value;\n\tvar encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value; \n\n\tif(payer_desc!=\"\" && policy_type_desc!=\"\")\n\t{\n\t\tvar action=document.forms[0].action.value;\n\n\t\tif(action==\"modify\" || action==\"add\")\n\t\t\tdocument.forms[0].modify_refresh.value=\"Y\";\n\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\t\n\t\tvar param=\"episode_type=\"+episode_type+\"&facility_id=\"+facility_id+\"&cust_group_code=\"+encodeURIComponent(cust_group_code)+\"&cust_code=\"+encodeURIComponent(cust_code)+\"&policy_type_code=\"+encodeURIComponent(policy_type_code)+\"&called_from=cust_pol_change\";\n\t\tvar temp_jsp=\"../../eBL/jsp/BLInsuranceValidations.jsp?\"+param;\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText=trimString(xmlHttp.responseText);\n\t\t\n\t\tvar retVal = responseText;\n\t\tvar retArr = retVal.split(\"/\");\n\t\tdocument.forms[0].restrict_check.value = retArr[0];\n\t\tdocument.forms[0].apprd_amt_restrict_check.value = retArr[1];\t\t\n\t\tdocument.forms[0].apprd_days_restrict_check.value = retArr[2];\n\t\tdocument.forms[0].cred_auth_req_yn.value =  retArr[3];\n\t\tdocument.forms[0].dflt_auth_ref_as_pol_no_yn.value = retArr[4];\n\t\tdocument.forms[0].policy_coverage_basis_ind.value = retArr[5];\n\t\tdocument.forms[0].cred_auth_mand_capt_yn.value = retArr[6];\n\n\t\tif(retArr[0]==\"R\")\n\t\t{\n\t\t\tdocument.forms[0].restricted_YN.value=\"\";\n\t\t\t\t\n\t\t\tif(retArr[1]==\"U\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].credit_apprd_amt.disabled = true;\n\t\t\t\tdocument.getElementById(\'apprd_amt_leg_disp\').style.display = \"none\";\n\t\t\t\tdocument.getElementById(\'apprd_amt_val_disp\').style.display = \"none\";\n\t\t\t\t/**** added for package billing *********** start *********commented for IN 20964****\n\t\t\t\tif(document.forms[0].package_enabled_yn.value==\"Y\" && document.getElementById(\'addl_apprv_leg_disp\') !=null){\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_leg_disp\').style.display = \"none\";\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_val_disp\').style.display = \"none\";\n\t\t\t\t\tparent.PayerDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.PkgDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\n\n\t\t\t\t}\n\t\t\t\t**** added for package billing *********** end *************/\n\t\t\t\t/**** added for package billing *********** start *********changed for IN 20964****/\n\t\t\t\tif(document.forms[0].package_enabled_yn.value==\"Y\" && document.getElementById(\'addl_apprv_leg_disp\') !=null){\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_leg_disp\').style.display = \"inline\";\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_val_disp\').style.display = \"inline\";\n\t\t\t\t\tparent.PayerDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.PkgDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.PkgDiscDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\tvar updation=formValidation(xmlStr,\"clearBean\");\n\t\t\t\t}\n\t\t\t\t/**** added for package billing *********** end *************/\n\t\t\t\tdocument.forms[0].credit_apprd_amt.value=\"\";\n\t\t\t}\n\t\t\telse if(retArr[1]==\"R\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].credit_apprd_amt.disabled = false;\n\t\t\t\tdocument.getElementById(\'apprd_amt_leg_disp\').style.display = \"inline\";\n\t\t\t\tdocument.getElementById(\'apprd_amt_val_disp\').style.display = \"inline\";\n\t\t\t\t/**** added for package billing *********** start ****commented for IN 20964*********\n\t\t\t\tif(document.forms[0].package_enabled_yn.value==\"Y\" && document.getElementById(\'addl_apprv_leg_disp\') !=null && document.getElementById(\'credit_auth_leg_disp\').style.display==\"inline\" && document.getElementById(\'credit_auth_val_disp\').style.display==\"inline\"){\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_leg_disp\').style.display = \"inline\";\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_val_disp\').style.display = \"inline\";\n\t\t\t\t\tparent.PayerDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.PkgDtls.location.href=\"../../eCommon/html/blank.html\";\n\n\t\t\t\t}\n\t\t\t\t**** added for package billing *********** end *************/\n\t\t\t\t/**** added for package billing *********** start ****change for IN 20964*********/\n\t\t\t\tif(document.forms[0].package_enabled_yn.value==\"Y\" && document.getElementById(\'addl_apprv_leg_disp\') !=null){\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_leg_disp\').style.display = \"inline\";\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_val_disp\').style.display = \"inline\";\n\t\t\t\t\tparent.PayerDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.PkgDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.PkgDiscDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\tvar updation=formValidation(xmlStr,\"clearBean\");\n\t\t\t\t}\n\t\t\t\t/**** added for package billing *********** end ****change for IN 20964*********/\n\n\t\t\t\t\n\t\t\t}\n\n\t\t\tif(retArr[2]==\"U\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].credit_apprd_days.disabled = true;\n\t\t\t\tdocument.getElementById(\'apprd_days_leg_disp\').style.display = \"none\";\n\t\t\t\tdocument.getElementById(\'apprd_days_val_disp\').style.display = \"none\";\n\t\t\t\tdocument.forms[0].credit_apprd_days.value=\"\";\n\t\t\t}\n\t\t\telse if(retArr[2]==\"R\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].credit_apprd_days.disabled = false;\n\t\t\t\tdocument.getElementById(\'apprd_days_leg_disp\').style.display = \"inline\";\n\t\t\t\tdocument.getElementById(\'apprd_days_val_disp\').style.display = \"inline\";\n\t\t\t}\n\t\t}\n\t\telse \n\t\t{\n\t\t\tdocument.forms[0].restricted_YN.value=\"DISABLED\";\n\t\t\tdocument.getElementById(\'apprd_amt_leg_disp\').style.display = \"none\";\n\t\t\tdocument.getElementById(\'apprd_amt_val_disp\').style.display = \"none\";\n\t\t\t/**** added for package billing *********** start ****commented for IN 20964*********\n\t\t\tif(document.forms[0].package_enabled_yn.value==\"Y\" && document.getElementById(\'addl_apprv_leg_disp\') !=null){\n\t\t\t\tdocument.getElementById(\'addl_apprv_leg_disp\').style.display = \"none\";\n\t\t\t\tdocument.getElementById(\'addl_apprv_val_disp\').style.display = \"none\";\n\t\t\t\tparent.PayerDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.PkgDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t}\n\t\t\t**** added for package billing *********** end *************/\n\t\t\t/**** added fo";
    private final static byte[]  _wl_block11_2Bytes = _getBytes( _wl_block11_2 );

    private final static java.lang.String  _wl_block11_3 ="r package billing *********** end *************/\n\t\t\tif(document.forms[0].package_enabled_yn.value==\"Y\" && document.getElementById(\'addl_apprv_leg_disp\') !=null){\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_leg_disp\').style.display = \"inline\";\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_val_disp\').style.display = \"inline\";\n\t\t\t\t\tparent.PayerDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.PkgDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.PkgDiscDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\tvar updation=formValidation(xmlStr,\"clearBean\");\n\t\t\t\t}\n\t\t\t/**** added for package billing *********** end *************/\n\t\t\tdocument.getElementById(\'apprd_days_leg_disp\').style.display = \"none\";\n\t\t\tdocument.getElementById(\'apprd_days_val_disp\').style.display = \"none\";\n\t\t\tdocument.forms[0].credit_apprd_amt.value=\"\";\n\t\t\tdocument.forms[0].credit_apprd_days.value=\"\";\n\t\t}\n\n\t\tif(retArr[3]==\"Y\")\n\t\t{\n\t\t\tdocument.getElementById(\'credit_auth_leg_disp\').style.display = \"inline\";\n\t\t\tdocument.getElementById(\'credit_auth_val_disp\').style.display = \"inline\";\n\t\t//\talert(\'document.getElementById(\'apprd_amt_leg_disp\').style=\'+document.getElementById(\'apprd_amt_leg_disp\').style.display)\n\t\t/**** added for package billing *********** start *****commented for IN 20964********\n\t\t\tif(document.forms[0].package_enabled_yn.value==\"Y\" && document.getElementById(\'addl_apprv_leg_disp\') !=null && document.getElementById(\'apprd_amt_leg_disp\').style.display==\"inline\" && document.getElementById(\'apprd_amt_val_disp\').style.display==\"inline\"){\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_leg_disp\').style.display = \"inline\";\n\t\t\t\t\tdocument.getElementById(\'addl_apprv_val_disp\').style.display = \"inline\";\n\t\t\t\t\tparent.PayerDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.PkgDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t}\n\t\t\t**** added for package billing *********** end *************/\n\t\t\tdocument.getElementById(\'credit_auth_date_leg_disp\').style.display = \"inline\";\n\t\t\tdocument.getElementById(\'credit_auth_date_val_disp\').style.display = \"inline\";\n\t\t\t\n\t\t\tif(retArr[6] == \"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'credit_auth_ref_mand\').style.display = \"inline\";\t\n\t\t\t\tdocument.getElementById(\'credit_auth_ref_date_mand\').style.display = \"inline\";\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'credit_auth_ref_mand\').style.display = \"none\";\t\n\t\t\t\tdocument.getElementById(\'credit_auth_ref_date_mand\').style.display = \"none\";\t\n\t\t\t}\n\n\t\t\tif(retArr[4]==\"Y\")\n\t\t\t{\n\t\t\t\tif(policy_no!=\"\" && credit_auth_ref==\"\")\n\t\t\t\t{\n\t\t\t\t\tvar policy_no_len = policy_no.length;\n\t\t\t\t\tif(policy_no_len <=20 )\n\t\t\t\t\t\tdocument.forms[0].credit_auth_ref.value = policy_no.substring(0,policy_no_len);\n\t\t\t\t\telse\n\t\t\t\t\t\tdocument.forms[0].credit_auth_ref.value = policy_no.substring(0,20);\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(retArr[6] == \"Y\")\n\t\t\t{\n\t\t\t\tif(credit_auth_date==\"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].credit_auth_date.value = encounter_date_aft_trunc;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(document.forms[0].credit_auth_ref.value == \"\" && credit_auth_date !=\"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].credit_auth_date.value = \"\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\'credit_auth_leg_disp\').style.display = \"none\";\n\t\t\tdocument.getElementById(\'credit_auth_val_disp\').style.display = \"none\";\n\t\t\t/**** added for package billing *********** start *******commented for IN 20964******\n\t\tif(document.forms[0].package_enabled_yn.value==\"Y\" && document.getElementById(\'addl_apprv_leg_disp\') !=null){\n\t\t\tdocument.getElementById(\'addl_apprv_leg_disp\').style.display = \"none\";\n\t\t\tdocument.getElementById(\'addl_apprv_val_disp\').style.display = \"none\";\n\t\t\tparent.PayerDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\tparent.PkgDtls.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t}\n\t\t\t**** added for package billing *********** end *************/\n\n\t\t\tdocument.getElementById(\'credit_auth_date_leg_disp\').style.display = \"none\";\n\t\t\tdocument.getElementById(\'credit_auth_date_val_disp\').style.display = \"none\";\n\t\t\tdocument.getElementById(\'credit_auth_ref_mand\').style.display = \"none\";\t\n\t\t\tdocument.getElementById(\'credit_auth_ref_date_mand\').style.display = \"none\";\t\n\t\t\tdocument.forms[0].credit_auth_ref.value = \"\";\n\t\t\tdocument.forms[0].credit_auth_date.value = \"\";\n\t\t}\n\t\t\n\t\treturn true;\n\t}\n\telse\n\t{\n\t\treturn true;\n\t}\n}\n\nfunction dflt_policy_eff_frm_to_date()\n{\n\tvar policy_start_date=document.forms[0].policy_start_date.value;\n\tvar policy_exp_date=document.forms[0].policy_exp_date.value;\n\tvar policy_eff_frm_date=document.forms[0].policy_eff_frm_date;\n\tvar policy_eff_to_date=document.forms[0].policy_eff_to_date;\n\tvar encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value;\n\tvar module_id = document.forms[0].calling_module_id.value;\n\tvar locale=document.forms[0].locale.value;\n\t\n\tvar cust_id =  document.forms[0].cust_id.value;\n\t\n\tif(cust_id == \'ALMO\')  return true;\n\n\tif(policy_start_date!=\"\" && policy_exp_date!=\"\")\n\t{\n\t\tif(module_id == \"MP\")\n\t\t{\n\t\t\tif(!isBeforeNow(document.forms[0].policy_start_date.value,\'DMY\',locale))\n\t\t\t{\n\t\t\t\tpolicy_eff_frm_date.value=policy_start_date;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tpolicy_eff_frm_date.value=encounter_date_aft_trunc;\n\t\t\t}\n\t\t}\n\t\telse if(module_id == \"IP\" || module_id == \"DC\")\n\t\t{\n\t\t\tif(!isBefore(document.forms[0].policy_start_date.value,encounter_date_aft_trunc,\"DMY\",locale))\n//\t\t\tif(!isBeforeNow(document.forms[0].policy_start_date.value,\'DMY\',locale))\n\t\t\t{\n\t\t\t\tpolicy_eff_frm_date.value=policy_start_date;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tpolicy_eff_frm_date.value=encounter_date_aft_trunc;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tpolicy_eff_frm_date.value=encounter_date_aft_trunc;\n\t\t}\n\t\n\t\tpolicy_eff_to_date.value=policy_exp_date;\n\n\t\t//chkPolicyEffFromDateMain(policy_eff_frm_date,policy_eff_to_date,document.forms[0].policy_start_date,document.forms[0].policy_exp_date,encounter_date_aft_trunc);\n\t}\n\telse\n\t{\n\t\tpolicy_eff_frm_date.value = \"\";\n\t\tpolicy_eff_to_date.value = \"\";\n\t}\n\treturn true;\n}\n\nfunction dflt_pol_eff_frm_date()\n{\n\t\n\t\n\tvar policy_eff_frm_date = document.forms[0].policy_eff_frm_date;\n\tvar encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc;\n\tvar module_id = document.forms[0].calling_module_id.value;\n\tvar modify_refresh = document.forms[0].modify_refresh.value;\n\tvar locale=document.forms[0].locale.value;\n\tvar rec_edited_YN = document.forms[0].rec_edited_YN.value;\n\n\tif(rec_edited_YN == \"N\" || rec_edited_YN == \"\")\n\t{\n\t\tif(module_id != \'MP\')\n\t\t{\n\t\t\tif(module_id == \'IP\' || module_id == \'DC\')\n\t\t\t{\n\t\t\t\tif(modify_refresh == \'Y\')\n\t\t\t\t{\n\t\t\t\t\tif(policy_eff_frm_date.value ==\"\")\n\t\t\t\t\t\tpolicy_eff_frm_date.value = encounter_date_aft_trunc.value;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(!isBeforeNow(document.forms[0].policy_start_date.value,\'DMY\',locale))\n\t\t\t\t\t{\n\t\t\t\t\t\tpolicy_eff_frm_date.value = policy_eff_frm_date.value;//No change in date\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tpolicy_eff_frm_date.value = encounter_date_aft_trunc.value;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(modify_refresh == \'Y\')\n\t\t\t\t{\n\t\t\t\t\tif(policy_eff_frm_date.value ==\"\")\n\t\t\t\t\t\tpolicy_eff_frm_date.value = encounter_date_aft_trunc.value;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tpolicy_eff_frm_date.value = encounter_date_aft_trunc.value;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\t\n}\n\nfunction bring_focus()\n{\n\tvar modify_refresh=document.forms[0].modify_refresh.value;\n\tif(modify_refresh==\"Y\")\n\t{\n\t\tvar payer_desc=document.forms[0].payer_desc.value;\n\t\tvar policy_type_desc=document.forms[0].policy_type_desc.value;\n\t\tvar priority=document.forms[0].priority.value;\n\n\t\tif(payer_desc!=\"\" && policy_type_desc!=\"\")\n\t\t{\n\t\t\tdocument.forms[0].policybut.focus();\n\t\t}\n\t}\n}\n\nfunction check_priority()\n{\n\tvar total_records=document.forms[0].totalRecords.value;\n\tvar action=document.forms[0].action.value;\n\tvar locn=document.forms[0].locn.value;\n\n\tvar select_billing_group=document.forms[0].blng_grp_code.value;\n\tvar priority=document.forms[0].priority;\n\tvar max_priority=document.forms[0].max_priority.value;\n\n\tvar existing_priority_modify=\"\";\n\n\tvar priorities=document.forms[0].priority_arr.value;\n\tvar priority_arr=priorities.split(\',\');\n\n\tif(parseInt(priority.value)==0)\n\t{\n\t\talert(getMessage(\"BL9833\",\"BL\"));\n\t\tpriority.select();\n\t\treturn false;\n\t}\n\n\tif(action==\"modify\")\n\t\texisting_priority_modify=document.forms[0].existing_priority_modify.value;\n\n\tif(priority.value!=\"\" )\n\t{\n\t\tfor (var i=0;i<priority_arr.length;i++)\n\t\t{\n\t\t\tvar priority_var1 = priority_arr[i];\n\n\t\t\tif((parseInt(priority_var1)==parseInt(priority.value)) && (( parseInt(priority.value) !=  parseInt(existing_priority_modify) && action==\"modify\") || action!=\"modify\" ))\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9831\",\"BL\"));\n\t\t\t\tpriority.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\n\tif(select_billing_group!=\"\" && priority.value!=\"\" )\n\t{\n\t\tif(locn==\"outside\" && total_records>=1)\n\t\t{\n\t\t\tvar total_keys=document.forms[0].total_keys.value;\n\t\t\tvar max_priorities=document.forms[0].max_priority_arr.value;\n\t\t\tvar min_priorities=document.forms[0].min_priority_arr.value;\n\n\t\t\tvar total_keys_arr=total_keys.split(\',\');\n\t\t\tvar max_priority_arr=max_priorities.split(\',\');\n\t\t\tvar min_priority_arr=min_priorities.split(\',\');\n\n\t\t\tvar prev_blng_grp_max_prio=\"\";\n\t\t\tvar next_blng_grp_min_prio=\"\";\n\n\t\t\tfor(var i=0;i<total_keys_arr.length;i++)\n\t\t\t{\n\t\t\t\tif(total_keys_arr[i]==select_billing_group)\n\t\t\t\t{\n\t\t\t\t\tif(max_priority_arr[i-1] != null)\n\t\t\t\t\t\tprev_blng_grp_max_prio=max_priority_arr[i-1];\n\n\t\t\t\t\tif(min_priority_arr[i+1] != null)\n\t\t\t\t\t\tnext_blng_grp_min_prio=min_priority_arr[i+1];\n\n\t\t\t\t\tif(prev_blng_grp_max_prio != \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parseInt(priority.value) <= parseInt(prev_blng_grp_max_prio))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(getMessage(\"BL9829\",\"BL\"));\n\t\t\t\t\t\t\tpriority.select();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(next_blng_grp_min_prio != \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parseInt(priority.value) >= parseInt(next_blng_grp_min_prio))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(getMessage(\"BL9830\",\"BL\"));\n\t\t\t\t\t\t\tpriority.select();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse if(locn==\"inside\")\n\t\t{\n\t\t\tif(parseInt(priority.value) <= max_priority)\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9831\",\"BL\"));\n\t\t\t\tpriority.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction chk_for_decimal(obj,cld_frm)\n{\n\tvar form_var=obj.value;\n\n\tvar count=\"\";\n\tcount=form_var.indexOf(\".\");\n\n\tif(parseInt(count) >= 0)\n\t{\n\t\tif(cld_frm != \"I\")\n\t\t{\n\t\t\talert(getMessage(\"BL9832\",\"BL\"));\n\t\t}\n\t\tobj.select();\n\t\treturn false;\n\t}\n\treturn true;\n}\n\nfunction dflt_pol_no_2_credit_auth(pol_no)\n{\n\tvar cred_auth_req_yn = document.forms[0].cred_auth_req_yn.value;\n\tvar cred_auth_mand_capt_yn = document.forms[0].cred_auth_mand_capt_yn.value;\n\tvar dflt_auth_ref_as_pol_no_yn = document.forms[0].dflt_auth_ref_as_pol_no_yn.value;\n\tvar policy_no = pol_no.value;\n\tvar credit_auth_ref =\"\";\n\n\tif(cred_auth_req_yn ==\"Y\" && dflt_auth_ref_as_pol_no_yn==\"Y\" && cred_auth_man";
    private final static byte[]  _wl_block11_3Bytes = _getBytes( _wl_block11_3 );

    private final static java.lang.String  _wl_block11_4 ="d_capt_yn==\"Y\")\n\t{\n\t\tcredit_auth_ref = policy_no.substring(0,20);\n\t\tdocument.forms[0].credit_auth_ref.value = credit_auth_ref;\n\t}\n\n\tcheck_for_related_policies(\'B\');\n}\n\nfunction chk_for_valid_apprv_days_entry()\n{\n\tvar policy_eff_frm_date = document.forms[0].policy_eff_frm_date.value;\n\tvar policy_eff_to_date = document.forms[0].policy_eff_to_date.value;\n\tvar credit_apprd_days = document.forms[0].credit_apprd_days.value;\n\tvar locale=document.forms[0].locale.value;\n\tvar apprd_days_restrict_check = document.forms[0].apprd_days_restrict_check.value;\n\n\tif(apprd_days_restrict_check == \"R\")\n\t{\n\t\tif(policy_eff_frm_date != \"\" && policy_eff_to_date != \"\" && credit_apprd_days !=\"\")\n\t\t{\n\t\t\tvar no_of_days = eval(daysBetween(policy_eff_frm_date,policy_eff_to_date,\"DMY\",locale))+1;\n\n\t\t\tif(eval(credit_apprd_days) >  eval(no_of_days))\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL0029\",\"BL\"));\n//\t\t\t\tdocument.forms[0].credit_apprd_days.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\treturn true;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n\telse\n\t{\n\t\treturn true;\n\t}\n}\n\nfunction chkvalidcustYN()\n{\n\tvar cust_valid_from_date = document.forms[0].cust_valid_from_date.value;\n\tvar cust_valid_to_date = document.forms[0].cust_valid_to_date.value;\n\tvar encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc;\n\tvar locale = document.forms[0].locale.value;\n\n\tif(locale != \'en\')\n\t{\n\t\tcust_valid_from_date=convertDate(cust_valid_from_date,\'DMY\',\'en\',locale);\n\t\tcust_valid_to_date=convertDate(cust_valid_to_date,\'DMY\',\'en\',locale);\n\t}\n\n\tif(cust_valid_from_date != \"\")\n\t{\n\t\tif(!isAfter(encounter_date_aft_trunc.value,cust_valid_from_date,\'DMY\',locale))\n\t\t{\n\t\t\t//Added by Rajesh V - If logic\n\t\t\tvar strModuleId = document.forms[0].calling_module_id.value;\n\t\t\tif(strModuleId != \'MP\'){\n\t\t\t\talert(getMessage(\"BL8227\",\"BL\"));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t//Added by Rajesh V - If logic\n\t\t}\n\t}\n\tif(cust_valid_to_date != \"\")\n\t{\n\t\tif(!isBefore(encounter_date_aft_trunc.value,cust_valid_to_date,\'DMY\',locale))\n\t\t{\n\t\t\talert(getMessage(\"BL8227\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t}\n\treturn true;\n}\n\nfunction srch_by_crit_for_cust()\n{\n\tvar srch_by = document.forms[0].search_by_items.value;\n/*\n\tif(srch_by == \"CG\")\n\t{\n\t\tdocument.getElementById(\'srch_by_leg\').innerText=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\");\n\t}\n\telse\n*/\n\tif (srch_by == \"CY\")\n\t{\n\t\tdocument.getElementById(\'srch_by_leg\').innerText=getLabel(\"Common.country.label\",\"common\");\n\t}\n\telse if (srch_by == \"RN\")\n\t{\n\t\tdocument.getElementById(\'srch_by_leg\').innerText=getLabel(\"eMP.region.label\",\"MP\");\n\t}\n\t\n\tif(document.forms[0].modify_refresh.value != \'Y\')\n\t{\n\t\tdocument.forms[0].srch_by_desc.value=\'\';\n\t\tdocument.forms[0].search_code.value = \'\';\n\t}\n\n\tif(document.forms[0].modify_refresh.value == \'Y\')\n\t\tdocument.forms[0].modify_refresh.value = \'\';\n}\n\nfunction srchbylkup(clng_evnt)\n{\t\n\tvar srch_by = document.forms[0].search_by_items.value;\n\tvar locale = document.forms[0].locale.value;\n\n\tvar target_code\t= document.forms[0].search_code ;\n\tvar target = document.forms[0].srch_by_desc;\n\t\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].srch_by_desc.value=\'\';\n\t\t\tdocument.forms[0].search_code.value = \'\';\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar message=\"\";\n\tvar retVal\t\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar title\t\t\t\t= \"\";\n\tvar column_descriptions = \"\";\n\n/*\t\n\tif(srch_by == \"CG\")\n\t{\n\t\tvar title=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\"); \n\t\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\t\tsql = \"\tselect cust_group_code CUST_GRP_CODE,short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id=\'\"+locale+\"\' and status is null\";\t\n\t}\n\telse \n*/\n\tif (srch_by == \"CY\")\n\t{\n\t\tvar title=getLabel(\"Common.country.label\",\"common\"); \n\t\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\t\tsql = \"select country_code COUNTRY_CODE,short_name SHORT_NAME from mp_country_lang_vw where language_id=\'\"+locale+\"\' and eff_status = \'E\'\";\t\n\t}\n\telse if (srch_by == \"RN\")\n\t{\n\t\tvar title=getLabel(\"eMP.region.label\",\"MP\"); \n\t\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\t\tsql = \"select region_code REGION_CODE,short_desc SHORT_NAME from mp_region_lang_vw where language_id=\'\"+locale+\"\' and eff_status = \'E\'\";\t\n\t}\n\n\tvar column_sizes = escape(\"30%,70%\");\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\n\tcolumn_descriptions = code+\",\"+desc;\n\n\tsql=escape(sql);\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"^~^\");\n\n\t\ttarget.value=arr[1];\n\t\ttarget_code.value = arr[0];\n\t}\n\telse\n\t{\t\n\t\ttarget.value=\'\';\n\t\ttarget_code.value = \'\';\n\t}\n}\n\nfunction chk_pol_eff_date_validity(obj,cld_frm)\n{\n\tvar policy_eff_frm_date = document.forms[0].policy_eff_frm_date;\n\tvar credit_apprd_days = document.forms[0].credit_apprd_days;\n\tvar encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc;\n\tvar locale=document.forms[0].locale.value;\n\tvar apprd_days_restrict_check = document.forms[0].apprd_days_restrict_check.value;\n\tvar module_id = document.forms[0].calling_module_id.value;\n\n\tif(module_id != \'MP\')\n\t{\n\t\tif(policy_eff_frm_date.value != \"\" && credit_apprd_days.value != \"\" && apprd_days_restrict_check==\'R\')\n\t\t{\n\t\t\tif(chk_for_decimal(credit_apprd_days,\'I\'))\n\t\t\t{\n\t\t\t\tvar pol_validity_chk_date = plusDate(policy_eff_frm_date.value,\'DMY\',locale,eval(credit_apprd_days.value)-1,\'d\');\n\n\t\t\t\tif(!isAfter(pol_validity_chk_date,encounter_date_aft_trunc.value,\'DMY\',locale))\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL6203\",\"BL\"));\n\t/*\n\t\t\t\t\tif(cld_frm == \'I\')\n\t\t\t\t\t{\n\t\t\t\t\t\tobj.vale=\'\';\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}\n\t*/\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].pol_validity_chk_date.value=pol_validity_chk_date;\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n\telse\n\t{\n\t\treturn true;\n\t}\n}\n\nfunction CheckForChar(Obj)\n{\n\tvar check_var = Obj.value;\n\n\tnumList = \'1234567890.\';\n\t\n\tfor (i=0;i<check_var.length;i++)\n\t{\n\t\tif (numList.indexOf(check_var.charAt(i)) == -1) \n\t\t{\n\t\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\'Common\'));\n\t\t\tObj.select();\n\t\t\treturn false;  \n\t\t}\n\t}\n\treturn true;\n}\n\nfunction CheckSplApprAmt(Obj)\n{\n\tvar flag = CheckForChar(Obj);\n\n\tif(flag)\n\t{\n\t\tput_decimal(Obj,document.forms[0].noofdecimal.value);\n\t\treturn true;\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}\n\nfunction CheckSplApprDays(Obj)\n{\n\tvar flag = CheckForChar(Obj);\n\n\tif(flag)\n\t{\n\t\tif(chk_for_decimal(Obj))\n\t\t{\n\t\t\tif(chk_for_valid_apprv_days_entry())\n\t\t\t{\n\t\t\t\tif(chk_pol_eff_date_validity(document.forms[0].credit_apprd_days,\"I\"))\n\t\t\t\t{\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}\n\nfunction priority_checks(obj)\n{\n\tif(chk_for_decimal(obj))\n\t{\n\t\tif(adjustment_rule())\n\t\t{\n\t\t\tcheck_priority();\n\t\t}\n\t}\n}\n\nfunction adj_rule_ind_set(obj)\n{\n\tvar adj_rule_ind_v=obj.value;\n\n\tif(adj_rule_ind_v==\"AUT\")\n\t{\n\t\tdocument.forms[0].adj_rule_ind.value=\"A\";\n\n\t\tdocument.forms[0].adj_perc_amt_value.disabled=false;\t\n\t\tdocument.forms[0].adj_perc_amt_ind_lis.disabled=false;\n\t\tdocument.forms[0].pmnt_diff_adj_int.disabled=false;\n\t\tdocument.forms[0].pmnt_diff_adj_int_desc.disabled=false;\n\t\tdocument.forms[0].adj_diff_btn.disabled=false;\n\t}\n\telse if(adj_rule_ind_v==\"NA\")\n\t{\n\t\tdocument.forms[0].adj_perc_amt_ind_lis.selectedIndex=0;\n\t\tdocument.forms[0].adj_rule_ind.value=\"\";\n\n\t\tdocument.forms[0].adj_perc_amt_ind.value=\"\";\n\t\tdocument.forms[0].adj_perc_amt_value.value=\"\";\n\t\tdocument.forms[0].pmnt_diff_adj_int_desc.value=\"\";\n\t\tdocument.forms[0].pmnt_diff_adj_int.value=\"\";\n\t\t\n\t\tdocument.forms[0].adj_perc_amt_ind_lis.disabled=true;\n\t\tdocument.forms[0].adj_perc_amt_value.disabled=true;\t\t\t\n\t\tdocument.forms[0].pmnt_diff_adj_int.disabled=true;\n\t\tdocument.forms[0].pmnt_diff_adj_int_desc.disabled=true;\n\t\tdocument.forms[0].adj_diff_btn.disabled=true;\n\t}\n}\n\nfunction adj_perc_amt_ind_set(obj)\n{\n\tvar adj_perc_amt_ind_v=obj.value;\n\tif(adj_perc_amt_ind_v==\"PER\")\n\t{\n\t\tdocument.forms[0].adj_perc_amt_ind.value=\"P\";\n\t}\n\telse if(adj_perc_amt_ind_v==\"AMT\")\n\t{\n\t\tdocument.forms[0].adj_perc_amt_ind.value=\"A\";\n\t}\n\tdocument.forms[0].adj_perc_amt_value.value=\"\";\n}\n\nfunction adjinterfacelkp(clng_evnt)\n{\n\tvar target\t = document.forms[0].pmnt_diff_adj_int_desc;\t\t\n\tvar adj_code = document.forms[0].pmnt_diff_adj_int.value;\t\t\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].pmnt_diff_adj_int.value = \"\";\n\t\t\tdocument.forms[0].pmnt_diff_adj_int_desc.value = \"\";\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar retVal\t\t\t= new String();\t\n\n\tvar dialogTop\t\t\t= \"240\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"50\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar sql1\t\t\t\t= \"\";\t\n//\tvar title=encodeURIComponent(getLabel(\"eBL.PRACT_STAFF_TYPE.label\",\"BL\"));\n\tvar title=getLabel(\"eBL.ADJUSTMENT_INTERFACE_CODE.label\",\"BL\");\n\ttitle = encodeURIComponent(title);\n\tvar column_sizes = escape(\"20%,60%\");\n\tvar acc_code=encodeURIComponent(getLabel(\"eBL.ADJUSTMENT_INTERFACE_CODE.label\",\"bl\"));\n\tvar acc_desc=encodeURIComponent(getLabel(\"Common.description.label\",\"common\"));\n\tvar message=\"\";\n\tvar column_descriptions =acc_desc+\",\"+acc_code;\n\tvar locale = document.forms[0].locale.value;\n\tvar facility_id\t\t= document.forms[0].facility_id.value;\t\n\n\n\tsql1=\"SELECT acc_int_desc description,acc_int_code code FROM bl_gl_account_lang_vw WHERE SubStr(acc_int_code ,1,1)=\'R\' and NVL(status, \'X\') != \'S\' AND acc_entity_code = (select acc_entity_code from sy_acc_entity where acc_entity_id=\'\"+facility_id+\"\' and LANGUAGE_ID=\'\"+locale+\"\') and language_id=\'\"+locale+\"\'\";\n\n\tsql = escape(sql1);\t\t\t\t\t\t\t\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YY\";\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\n\tvar arr=new Array();\t\n\tif(retVal == null) retVal=\'\';\n\tif (retVal != null || retVal!=\"\")\n\t{\n\t\tif(retVal!=\'undefined\' && retVal!=undefined)\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\t\n\n\t\t\tif(retVal != null && ret";
    private final static byte[]  _wl_block11_4Bytes = _getBytes( _wl_block11_4 );

    private final static java.lang.String  _wl_block11_5 ="Val.length>0)\n\t\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\tdocument.forms[0].pmnt_diff_adj_int.value=arr[1];\t\t\n\t\t\tdocument.forms[0].pmnt_diff_adj_int_desc.value=arr[0];\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction adj_amt_chk(obj)\n{\n\n\tvar amt_check = CheckSplApprAmt(obj);\n\tif(amt_check)\n\t{\n\t\tvar adj_perc_amt_value = document.forms[0].adj_perc_amt_value.value;\n\t\tvar adj_perc_amt_ind = document.forms[0].adj_perc_amt_ind.value;\n\n\t\tif(adj_perc_amt_ind==\'P\')\n\t\t{\n\t\t\tif(eval(adj_perc_amt_value) < 1 || eval(adj_perc_amt_value) >100)\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL8115\",\"BL\"));\n\t\t\t\tdocument.forms[0].adj_perc_amt_value.select();\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction adj_perc_amt_lis()\n{\n\tvar adj_rule_ind_v=document.forms[0].adj_rule_ind_lis.value;\n\tvar adj_rule_ind=document.forms[0].adj_rule_ind.value;\n\tvar adj_perc_amt_ind=document.forms[0].adj_perc_amt_ind.value;\n\n\tif(adj_rule_ind!=\'A\' )\n\t{\n\t\tdocument.forms[0].adj_perc_amt_ind_lis.selectedIndex=0;\n\t\tdocument.forms[0].adj_perc_amt_ind.value=\"\";\n\t\tdocument.forms[0].adj_perc_amt_value.value=\"\";\n\t\tdocument.forms[0].pmnt_diff_adj_int_desc.value=\"\";\n\t\tdocument.forms[0].pmnt_diff_adj_int.value=\"\";\n\t\tdocument.forms[0].adj_rule_ind.value=\"\";\n\t\tdocument.forms[0].adj_perc_amt_ind.value=\"\";\n\t\tdocument.forms[0].adj_perc_amt_ind_lis.disabled=true;\n\t\tdocument.forms[0].adj_perc_amt_value.disabled=true;\t\t\t\n\t\tdocument.forms[0].pmnt_diff_adj_int.disabled=true;\n\t\tdocument.forms[0].pmnt_diff_adj_int_desc.disabled=true;\n\t\tdocument.forms[0].adj_diff_btn.disabled=true;\n\t}\n}\n\nfunction CheckSplAdjVal(Obj)\n{\n\tvar flag = CheckForChar(Obj);\n\n\tif(flag)\n\t{\n\t\tput_decimal(Obj,document.forms[0].noofdecimal.value);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}\n\nfunction pol_eff_dates_check(blng_grp_code,payer_group_code,payer_code,policy_type_code,policy_no,priority,policy_start_date,policy_exp_date,policy_eff_frm_date,policy_eff_to_date)\n{\n\tvar checked_row = document.forms[0].checked_row.value;\n\tvar locn = document.forms[0].locn.value;\n\tvar action = document.forms[0].action.value;\n\tif(blng_grp_code != \"\" && payer_group_code != \"\" && payer_code != \"\" && policy_type_code != \"\" && policy_no != \"\" && priority != \"\" && policy_eff_frm_date.value != \"\")\n\t{\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\t\n\t\tvar param=\"called_from=pol_eff_dates_check&blng_grp_code=\"+blng_grp_code+\"&payer_group_code=\"+payer_group_code+\"&payer_code=\"+payer_code+\"&policy_type_code=\"+policy_type_code+\"&policy_no=\"+policy_no+\"&priority=\"+priority+\"&policy_start_date=\"+policy_start_date.value+\"&policy_exp_date=\"+policy_exp_date.value+\"&policy_eff_frm_date=\"+policy_eff_frm_date.value+\"&policy_eff_to_date=\"+policy_eff_to_date.value+\"&checked_row=\"+checked_row+\"&action=\"+action+\"&locn=\"+locn;\n\t\tvar temp_jsp=\"../../eBL/jsp/BLInsuranceValidations.jsp?\"+param;\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText=trimString(xmlHttp.responseText);\n\t\t\n\t\tif(responseText == \"Y\")\n\t\t{\n//\t\t\talert(\"Policy Eff. date Cannot Overlap for the same Payer Group,Payer,Policy Type,Policy No Combination\");\n\t\t\talert(getMessage(\"BL7425\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n\telse\n\t{\n\t\treturn true;\n\t}\n}\n\nfunction check_for_related_policies(clng_evnt)\n{\n\t<!-- 12/07/2013\tKarthikeyan K\tMMS-QH-CRF-0010\t36789 starts -->\n\tvalidAcrossEncounters();\n\t<!-- 12/07/2013\tKarthikeyan K\tMMS-QH-CRF-0010\t36789 ends-->\t\n\tvar action = document.forms[0].action.value;\n\tvar locn = document.forms[0].locn.value;\n\tvar blng_grp_code = document.forms[0].blng_grp_code.value;\n\tvar ins_cust_group_code = document.forms[0].ins_cust_group_code.value;\n\tvar cust_code = document.forms[0].cust_3.value;\n\tvar policy_type_code = document.forms[0].policy_type_code.value;\n\tvar priority = document.forms[0].priority.value;\n\tvar policy_no = document.forms[0].policy_no.value;\n\tvar policy_eff_frm_date = document.forms[0].policy_eff_frm_date.value;//added for package billing\n\tvar policy_start_date = document.forms[0].policy_start_date.value;\n\tvar policy_exp_date = document.forms[0].policy_exp_date.value;\n\tvar rec_edited_YN = document.forms[0].rec_edited_YN.value;\n\tvar total_records = document.forms[0].totalRecords.value;\n\tvar checked_row = document.forms[0].checked_row.value;\n\tvar locale = document.forms[0].locale.value;\n\tvar cur_pol_least_prio_YN;\n\t\n\tvar  cust_id =  document.forms[0].cust_id.value;\n\t\n\t\n\tif(cust_id == \'ALMO\')  return;\n\n\tif(locale!=\"en\")\n\t{\n\t\tif(!(policy_eff_frm_date==\"\" || policy_eff_frm_date==\" \"))\n\t\t\tpolicy_eff_frm_date=convertDate(policy_eff_frm_date,\"DMY\",locale,\"en\");\n\n\t\tif(!(policy_start_date==\"\" || policy_start_date==\" \"))\n\t\t\tpolicy_start_date=convertDate(policy_start_date,\"DMY\",locale,\"en\");\n\n\t\tif(!(policy_exp_date==\"\" || policy_exp_date==\" \"))\n\t\t\tpolicy_exp_date=convertDate(policy_exp_date,\"DMY\",locale,\"en\");\n\t}\n\tif((total_records == 1 && ((action != \"modify\" && locn == \"outside\") || ((action == \"add\" || action == \"modify\") && locn == \"inside\"))) || total_records != 1)\n\t{\n\t\tif(blng_grp_code != \"\" && ins_cust_group_code != \"\" && cust_code != \"\" && policy_type_code != \"\" && priority != \"\" && policy_no != \"\")\n\t\t{\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t\n\t\t\tvar param=\"called_from=chk_for_rltd_policies&action=\"+action+\"&locn=\"+locn+\"&blng_grp_code=\"+blng_grp_code+\"&payer_group_code=\"+ins_cust_group_code+\"&payer_code=\"+cust_code+\"&policy_type_code=\"+policy_type_code+\"&policy_no=\"+policy_no+\"&priority=\"+priority+\"&policy_start_date=\"+policy_start_date+\"&policy_exp_date=\"+policy_exp_date+\"&checked_row=\"+checked_row;\n\n\t\t\tvar temp_jsp=\"../../eBL/jsp/BLInsuranceValidations.jsp?\"+param;\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tresponseText=trimString(xmlHttp.responseText);\n\t\t\t\n\t\t\tvar retArr = responseText.split(\"&^&\");\n\n\t\t\tif(retArr[0] == \"Y\")\n\t\t\t{\n\t\t\t\tif(clng_evnt == \"B\")\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].policy_start_date.value = retArr[1];\n\t\t\t\t\tdocument.forms[0].policy_exp_date.value = retArr[2];\n\t\t\t\t\tcur_pol_least_prio_YN = retArr[3];\n\t\t\t\t\tif(chkPolicyStartDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc))\n\t\t\t\t\t{\n\t\t\t\t\t\tif(chkPolicyExpiryDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(cur_pol_least_prio_YN == \"N\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tdocument.forms[0].policy_start_date.disabled = true;\n\t\t\t\t\t\t\t\tdocument.forms[0].policy_exp_date.disabled = true;\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tdocument.forms[0].policy_start_date.disabled = false;\n\t\t\t\t\t\t\t\tdocument.forms[0].policy_exp_date.disabled = false;\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(clng_evnt == \"L\")\n\t\t\t\t{\n\t\t\t\t\tcur_pol_least_prio_YN = retArr[3];\n\t\t\t\t\tif(cur_pol_least_prio_YN == \"N\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].policy_start_date.disabled = true;\n\t\t\t\t\t\tdocument.forms[0].policy_exp_date.disabled = true;\t\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].policy_start_date.disabled = false;\n\t\t\t\t\t\tdocument.forms[0].policy_exp_date.disabled = false;\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(retArr[0] == \"N\")\n\t\t\t{\n\t\t\t\tif(clng_evnt == \"B\")\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].policy_start_date.value = retArr[1];\n\t\t\t\t\tdocument.forms[0].policy_exp_date.value = retArr[2];\n\t\t\t\t\tif(chkPolicyStartDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc))\n\t\t\t\t\t{\n\t\t\t\t\t\tif(chkPolicyExpiryDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].policy_start_date.disabled = false;\n\t\t\t\t\t\t\tdocument.forms[0].policy_exp_date.disabled = false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(clng_evnt == \"L\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].policy_start_date.disabled = false;\n\t\t\t\t\tdocument.forms[0].policy_exp_date.disabled = false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n}\n</script>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"bring_focus();dflt_pol_eff_frm_date();srch_by_crit_for_cust();check_priority();curr_desc_1();check_for_related_policies(\'L\');\"><!-- Dont Change the order of call of the script functions -->\n\n<form name=\'add_modify_pat_fin_det_ins_bodyedit\' id=\'add_modify_pat_fin_det_ins_bodyedit\' method=\'post\' action=\"../../eBL/jsp/AddModifyPatFinDetailsInsBodyEdit.jsp\">\n\n<table cellpadding=3 cellspacing=0  width=\"100%\" align=\'left\'>\n\n<td align=\'left\' class=\'columnHeader\' colspan=\'4\'>";
    private final static byte[]  _wl_block11_5Bytes = _getBytes( _wl_block11_5 );

    private final static java.lang.String  _wl_block12 ="</td>\n<tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n<td width=\"25%\" class=\'fields\' ><select name=\"select_billing_group\" id=\"select_billing_group\" onChange=\"set_blng_values();check_priority();\" onBlur=\'adjustment_rule();\'><option value=\'\'>---";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="---</option>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<input type=\'hidden\' name=\"billing_group_desc\" id=\"billing_group_desc\" value=\'\'>\n<input type=\'hidden\' name=\"blng_grp_code\" id=\"blng_grp_code\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=hidden name=\'curr_code_for_bg\' id=\'curr_code_for_bg\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n</select></td>\n\n</td>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n<td class=\'fields\' width=\'25%\'><B>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</B></td>\n<input type=hidden name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=hidden name=\'blng_grp_code\' id=\'blng_grp_code\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n</td>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</B></td>\n\t<input type=hidden name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=hidden name=\'blng_grp_code\' id=\'blng_grp_code\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=hidden name=\'curr_code_for_bg\' id=\'curr_code_for_bg\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n<td width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n<td width=\"25%\" class=\'label\'><B>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="<B></td>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n<td width=\"25%\" colspan=\'2\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</tr>\n\n<tr>\t\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</div></td>\n\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\t<select name=\'search_by_items\' id=\'search_by_items\' onChange=\'srch_by_crit_for_cust();\' >\n<!--\n\t\t\t\t\t<option value=\'CG\' SELECTED>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</option>\n-->\n\t\t\t\t\t<option value=\'CY\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t\t\t\t<option value=\'RN\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</option>\n\t\t\t\t</select>\n\t\t</td>\n\n\t\t<td width=\"25%\" class=\"label\"><b id=\'srch_by_leg\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\"srch_by_desc\" id=\"srch_by_desc\" maxlength=\'30\' size=\'20\'  tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" onBlur=\"return srchbylkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"srchbybut\" id=\"srchbybut\" value=\'?\' onClick=\"return srchbylkup(\'C\')\" tabindex=\'0\'><input type= \'hidden\' name=\"search_code\" id=\"search_code\"  value=\"\"><input type= \'hidden\' name=\"search_by_items_rfsh\" id=\"search_by_items_rfsh\"  value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"></td>\t\t\t\n</tr>\n\n<tr>\n<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n<td class=\'fields\' width=\'25%\' ><input maxlength=\'15\' size=\'30\' type=text name=\'ins_cust_group_name\' id=\'ins_cust_group_name\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" onBlur=\"return cust_grp_lkup(\'B\');\"><input type=\'button\' class=\'button\' name=\"custgrpbut\" id=\"custgrpbut\" value=\'?\'  tabindex=\'0\' onClick=\"return cust_grp_lkup(\'C\')\"><input type=\'hidden\' name=\'ins_cust_group_code\' id=\'ins_cust_group_code\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n<td width=\"25%\">&nbsp;</td>\n<td width=\"25%\">&nbsp;</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'25%\'><a href=\"javascript:getCustDet();\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</a>&nbsp;&nbsp;<div id=\"ins_cust_curr_desc_disp\" style=\"display:none\"><Font color=\'red\'><b id=\"ins_cust_curr_desc_val\"></b></font></div></td>\n\t<td class=\'fields\' width=\'25%\' ><input maxlength=\'40\' size=\'30\' type=text name=\'payer_desc\' id=\'payer_desc\'  value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"   onBlur=\"return payerlkup(\'B\');\" onChange=\'\' onBlur=\"\"><input type=\'button\' class=\'button\' name=\"payerbut\" id=\"payerbut\" value=\'?\'  tabindex=\'0\' onClick=\"return payerlkup(\'C\')\" onBlur=\'\'><img src=\'../../eCommon/images/mandatory.gif\'>\n\n\t\t<input type=\'hidden\' name=\'cust_3\' id=\'cust_3\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\'hidden\' name=\'ins_cust_curr_code\' id=\'ins_cust_curr_code\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\'hidden\' name=\'ins_cust_curr_desc\' id=\'ins_cust_curr_desc\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<input type=\'hidden\' name=\'valid_payer_YN\' id=\'valid_payer_YN\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t<input type=\'hidden\' name=\'cust_valid_from_date\' id=\'cust_valid_from_date\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t<input type=\'hidden\' name=\'cust_valid_to_date\' id=\'cust_valid_to_date\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t</td>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t<td class=\'fields\' width=\'25%\'><input type=\"text\" maxlength=\'2\' size=\"3\" name=\'priority\' id=\'priority\' style=\'text-align:right\'  value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' onBlur=\'priority_checks(this);\' onKeyPress=\'return(ChkNumberInput(this,event,0))\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n</tr>\n<!-- Change for Incident 41309 Starts\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n<input type=\'hidden\' name=\'sql1\' id=\'sql1\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\nChange for Incident 41309 ends-->\n\n<tr>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t<td class=\'fields\' width=\'25%\' ><input maxlength=\'40\' size=\'10\' type=text name=\'policy_type_desc\' id=\'policy_type_desc\'  value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"  onBlur= \"return policylkup(\'B\');\" ><input type=\'button\' class=\'button\' name=\"policybut\" id=\"policybut\" value=\'?\'  tabindex=\'0\' onClick= \"return policylkup(\'C\'); \" onBlur=\'\'><img src=\'../../eCommon/images/mandatory.gif\'>\n\t<a name=\'\' href=\"#\" onClick=\"callPolicyDetails(";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =")\" >(dtls)</a>\n\t</td>\n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\n\t\t<td class=\'fields\' width=\'25%\' ><input maxlength=\'40\' size=\'30\' type=text name=\'policy_type_desc\' id=\'policy_type_desc\'  value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"  onBlur= \"return policylkup(\'B\');\" ><input type=\'button\' class=\'button\' name=\"policybut\" id=\"policybut\" value=\'?\'  tabindex=\'0\' onClick= \"return policylkup(\'C\'); \" onBlur=\'\'><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\t\n\t<input type=hidden name=\'policy_type_code\' id=\'policy_type_code\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"><input type=\'hidden\' name=\'valid_policy_type_code_YN\' id=\'valid_policy_type_code_YN\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\n<!--\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t<td class=\'fields\' width=\'25%\'><input type=\"text\" maxlength=\'30\' size=\"23\" name=\'policy_no\' id=\'policy_no\'   value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\' onBlur=\'dflt_pol_no_2_credit_auth(document.forms[0].policy_no);\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" onKeyPress=\'return CheckForSpecCharsAllNotAlwSpc_local(event)\' onBlur=\'dflt_pol_no_2_credit_auth(document.forms[0].policy_no);\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n</tr>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n<tr>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\n\t ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t \n\t\n\t<td class=\'fields\' width=\'25%\' ><input type=\'text\'  name=\'policy_start_date\' id=\'policy_start_date\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'  readonly ><img name=\'plcyStrtCalen\' src=\"../../eCommon/images/CommonCalendar.gif\"  readonly ><img  src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t<td class=\'fields\' width=\'25%\' ><input type=\'text\'  name=\'policy_start_date\' id=\'policy_start_date\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'  onBlur=\'return chkPolicyStartDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc)\' ><img name=\'plcyStrtCalen\' src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'policy_start_date\',document.forms[0].policy_start_date);\" ><img  src=\'../../eCommon/images/mandatory.gif\'></td>\n\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\n\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\n\t<td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\'policy_exp_date\' id=\'policy_exp_date\' size=\'10\' maxlength=\'10\'  value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' readonly ><img name=\'plcyExpCalen\' src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'policy_exp_date\',document.forms[0].policy_exp_date);\"  disabled ><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\'policy_exp_date\' id=\'policy_exp_date\' size=\'10\' maxlength=\'10\'  value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' onBlur=\'dflt_policy_eff_to_date();return chkPolicyExpiryDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);\' ><img name=\'plcyExpCalen\' src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'policy_exp_date\',document.forms[0].policy_exp_date);\" ><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n</tr>\n<!-- ***************GHL-0020 SCRUM CRF related changes end ***************** -->\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t<script>\n\t\t// Based on policy start and end date defaulting the  Policy effective from and to date\n\t\tsetTimeout(\'chkPolicyStartDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc)\',5)\t;\n\t\tsetTimeout(\'chkPolicyExpiryDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc)\',5)\t;\n\t</script>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n<!-- ***************GHL-0020 SCRUM CRF related changes end ***************** -->\n<tr>\n<!-- ***************Package billing changes - changed label from Crdit Auth to Initia Credit Auth, added onBlur method for credit_auth_ref ie changePayerDtls(this), changed eBL.CREDIT_AUTH_DATE.label to eBL.InitialCreditAuthorizationDate.label,***************** -->\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n<td class=\'label\' width=\'25%\'><div id=\"credit_auth_leg_disp\" style=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</div></td>\n\t<td class=\'fields\' width=\'25%\'><div id=\"credit_auth_val_disp\" style=";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" ><input type=\"text\" maxlength=\'20\' size=\"17\" name=\'credit_auth_ref\' id=\'credit_auth_ref\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" onBlur=\"changePayerDtls(this)\" onKeyPress=\'return CheckForSpecCharsAllNotAlwSpc_local(event)\'></div><div id=\"credit_auth_ref_mand\" style=";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" ><img src=\'../../eCommon/images/mandatory.gif\'></div></td>\n\n\t<td class=\'label\' width=\'25%\'><div id=\"credit_auth_date_leg_disp\" style=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</div></td>\n\t<td class=\'fields\' width=\'25%\'><div id=\"credit_auth_date_val_disp\" style=";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" ><input type=\'text\'  name=\'credit_auth_date\' id=\'credit_auth_date\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' onBlur=\"return chkCreditAuthDate(document.forms[0].credit_auth_date);changePayerDtls(this);\" ><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'credit_auth_date\',document.forms[0].credit_auth_date);\"><div id=\"credit_auth_date_mand\" style=";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" ></div><div id=\"credit_auth_ref_date_mand\" style=";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" ><img src=\'../../eCommon/images/mandatory.gif\'></div></td>\n\t\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'25%\' ><div id=\"apprd_amt_leg_disp\" style=";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</div></td>\n\t\n\t\n\t ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t<td class=\'fields\' width=\'25%\'><div id=\"apprd_amt_val_disp\" style=";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" ><input type=\"text\" maxlength=\'10\' size=\"15\" name=\'credit_apprd_amt\' id=\'credit_apprd_amt\' style=\'text-align:right\'  value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'  readonly ><img src=\'../../eCommon/images/mandatory.gif\'></div></td>\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value));\' onBlur=\'changePayerDtls(this);return CheckSplApprAmt(this);\' ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="><img src=\'../../eCommon/images/mandatory.gif\'></div></td>\n    ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" \n    \n\t<td  class=\'label\' width=\'25%\'  ><div id=\"apprd_days_leg_disp\" style=";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</div></td>\n\t\n\t ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t<td class=\'fields\' width=\'25%\'><div id=\"apprd_days_val_disp\" style=";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" ><input type=\"text\" maxlength=\'4\' size=\"4\" name=\'credit_apprd_days\' id=\'credit_apprd_days\' style=\'text-align:right\'  value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' onBlur=\'CheckSplApprDays(this);changePayerDtls(this)\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' readonly><img src=\'../../eCommon/images/mandatory.gif\' ></div></td>\n\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' onBlur=\'CheckSplApprDays(this);changePayerDtls(this);dflt_policy_eff_to_date();\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="><img src=\'../../eCommon/images/mandatory.gif\' ></div></td>\n\t  ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n</tr>\n\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t<td class=\'label\' width=\'25%\'><div id=\"credit_auth_leg_disp\" style=";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</div></td>\n<!--\t\n\t<td class=\'fields\' width=\'25%\'><div id=\"credit_auth_val_disp\" style=";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\'></div></td>\n-->\n\t<td class=\'fields\' width=\'25%\'><div id=\"credit_auth_val_disp\" style=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" onKeyPress=\'return CheckForSpecCharsAllNotAlwSpc_local(event)\'></div><div id=\"credit_auth_ref_mand\" style=";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</div></td>\n\t\n\t<td class=\'fields\' width=\'25%\'><div id=\"credit_auth_date_val_disp\" style=";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' onBlur=\"return chkCreditAuthDate(document.forms[0].credit_auth_date);\" ><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'credit_auth_date\',document.forms[0].credit_auth_date);\"><div id=\"credit_auth_date_mand\" style=";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</div></td>\n\t<td class=\'fields\' width=\'25%\'><div id=\"apprd_amt_val_disp\" style=";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value));\' onblur=\'return CheckSplApprAmt(this)\' ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="><img src=\'../../eCommon/images/mandatory.gif\'></div></td>\n\n\t<td  class=\'label\' width=\'25%\'  ><div id=\"apprd_days_leg_disp\" style=";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</div></td>\n\t<td class=\'fields\' width=\'25%\'><div id=\"apprd_days_val_disp\" style=";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\' onBlur=\'CheckSplApprDays(this);\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="><img src=\'../../eCommon/images/mandatory.gif\' ></div></td>\n</tr>\n\n\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\n\n<tr>\n\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t<td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\'policy_eff_frm_date\' id=\'policy_eff_frm_date\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' onBlur=\'dflt_policy_eff_to_date();return chkPolicyEffFromDateMain(document.forms[0].policy_eff_frm_date,document.forms[0].policy_eff_to_date,document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);\' ><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'policy_eff_frm_date\',document.forms[0].policy_eff_frm_date);\" ><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\n\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\'policy_eff_to_date\' id=\'policy_eff_to_date\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' onBlur=\'return chkPolicyEffToDate(document.forms[0].policy_eff_to_date,document.forms[0].policy_eff_frm_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);\' ><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'policy_eff_to_date\',document.forms[0].policy_eff_to_date);\" ></td>\n\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' onBlur=\' validate_eff_to_apprday();dflt_policy_eff_to_date();return chkPolicyEffToDate(document.forms[0].policy_eff_to_date,document.forms[0].policy_eff_frm_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);\' ><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'policy_eff_to_date\',document.forms[0].policy_eff_to_date);\" ></td>\t\t\n\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" \n\n</tr>\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n<tr>\n\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t\t<select name=\"adj_rule_ind_lis\" id=\"adj_rule_ind_lis\"\tonChange=\"adj_rule_ind_set(this)\" DISABLED>\n\t\t\t<option value=\'AUT\' ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</option>\n\t\t\t<option value=\'NA\' ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</option>\n\t\t</select>\n\t\t<input type=\'hidden\' name=\'adj_rule_ind\' id=\'adj_rule_ind\' value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\n\t</td>\n\n\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t\t<select name=\"adj_perc_amt_ind_lis\" id=\"adj_perc_amt_ind_lis\" onChange=\'adj_perc_amt_ind_set(this)\' DISABLED>\n\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="---</option>\n\t\t\t<option value=\'PER\' ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</option>\n\t\t\t<option value=\'AMT\' ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</option>\n\t\t</select>\n\t\t<input type=\'hidden\' name=\'adj_perc_amt_ind\' id=\'adj_perc_amt_ind\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" >\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t\t<!--<input type=\'text\'  name=\'adj_perc_amt_value\' id=\'adj_perc_amt_value\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' onBlur=\"adj_amt_chk(this)\"  style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))\' READONLY>-->\n\t\t<input type=\'text\'  name=\'adj_perc_amt_value\' id=\'adj_perc_amt_value\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\' style=\'text-align:right\' READONLY>\n\t</td>\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t\t<!--\n\t\t<input type=\'text\'  name=\'pmnt_diff_adj_int_desc\' id=\'pmnt_diff_adj_int_desc\' size=\'30\' maxlength=\'100\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' onblur=\"return adjinterfacelkp(\'B\')\" READONLY>\n\t\t<input type=\'button\' class=\'button\' name=\"adj_diff_btn\" id=\"adj_diff_btn\" value=\'?\' onClick=\"return adjinterfacelkp(\'C\')\">\n\t\t-->\n\t\t<input type=\'text\'  name=\'pmnt_diff_adj_int_desc\' id=\'pmnt_diff_adj_int_desc\' size=\'30\' maxlength=\'100\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' READONLY>\n\n\t</td>\n\t<input type=hidden name=\'pmnt_diff_adj_int\' id=\'pmnt_diff_adj_int\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" >\n</tr>\n<!-- Karthik added the code to add claim code starts  - IN50355-->\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\t<td class=\'fields\' width=\'25%\'><input name=\'claim_code\' id=\'claim_code\' type=\'text\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'></td>\n\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td>\n\t<td class=\'fields\' width=\'25%\'><input name=\'credit_authorisation_by\' id=\'credit_authorisation_by\' type=\'text\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'></td>\n</tr>\n<!-- Karthik added the code to add claim code  ends  - IN50355-->\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n<tr>\n\n<td class=\'label\' width=\'25%\'><div id=\"addl_apprv_leg_disp\"  style=\'display:inline\'>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 =" / ";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</div></td>\n<td class=\'label\' width=\'25%\' ><div id=\"addl_apprv_val_disp\"  style=\'display:inline\' ><a name=\'addlApprvDtls\' href=\'#\' onClick=\'showAddlApprv(calling_module_id);\'>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</a></div>\n\n\n</td>\n<td class=\'label\' width=\'25%\'></td>\n<td class=\'label\' width=\'25%\'>&nbsp;</td>\n</tr>\n";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n<!-- karthik added code INCLUDE_POLICY_DETAILS_CRF -->\n<tr>\n\t<td class=\'label\' width=\'25%\' >Membership Id</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t<input type=\'text\'  name=\'membershipId\' id=\'membershipId\' id=\'membershipId\'  size=\'30\' maxlength=\'100\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t</td>\n\t<!-- 08/07/2013\tKarthikeyan K\tMMS-QH-CRF-0010\t36789 starts-->\n\t<td class=\'fields\' width=\'25%\'>\n\t<a href=\'#\' name=\"across_encounter_link\"  disabled onClick=\"acrossEncountersLink()\">Across Encounter</a>\n\t</td>\n\t<!-- 08/07/2013\tKarthikeyan K\tMMS-QH-CRF-0010\t36789 ends-->\n\t<td class=\'label\' width=\'25%\'>\n\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t<a name=\"callPolicy\" href=\n\t\t\'#\' onClick=\"callPolicy(\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\',\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\');\">Modify Policy Details</a>\n\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t</td>\n<!-- \t<td class=\'label\' width=\'25%\'>&nbsp;</td> -->\n\n</tr>\n<br>\n\n\n\n<tr>\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>\n\t\t<input type=\"button\" name=\"accept_button\" id=\"accept_button\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" class=\"button\" onClick=\'checkValues()\' >&nbsp;\n\t\t<input type=\"button\" name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" class=\"button\"  onClick=\'cancel()\' >\n\t</td>\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t<td width=\'25%\'>&nbsp;</td>\n\t<td width=\'25%\'>&nbsp;</td>\n\t<td width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>\n<!--\n\t\t<input type=\"button\" name=\"modify_button\" id=\"modify_button\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" class=\"button\" onClick=\'enableAllElements_modify()\' >&nbsp;\n\n\t<td class=\'label\' width=\'25%\'><input align=right type=\"button\" name=\"remove_button\" id=\"remove_button\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" class=\"button\" onClick=\'remove_payer()\' ></td>\n-->\n\t\t<input type=\"button\" name=\"accept_button\" id=\"accept_button\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" class=\"button\" onClick=\'return checkValues()\' >&nbsp;\n\n\t\t<input type=\"button\" name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n</tr>\n\n<!--<input type=hidden name=\'adj_rule_ind\' id=\'adj_rule_ind\' value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" >\n<input type=hidden name=\'adj_perc_amt_ind\' id=\'adj_perc_amt_ind\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" >\n<!--<input type=hidden name=\'adj_perc_amt_value\' id=\'adj_perc_amt_value\' value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" >-->\n<input type=hidden name=\'drg_pmnt_diff_adj_int\' id=\'drg_pmnt_diff_adj_int\' value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" >\n<input type=hidden name=\'spl_srv_pmnt_diff_adj_int\' id=\'spl_srv_pmnt_diff_adj_int\' value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" >\n<input type=hidden name=\'restrict_check\' id=\'restrict_check\' value=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' >\n<input type=hidden name=\'apprd_amt_restrict_check\' id=\'apprd_amt_restrict_check\' value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' >\n<input type=hidden name=\'apprd_days_restrict_check\' id=\'apprd_days_restrict_check\' value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' >\n\n<input type=hidden name=\'cred_auth_req_yn\' id=\'cred_auth_req_yn\' value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\' >\n<input type=hidden name=\'cred_auth_mand_capt_yn\' id=\'cred_auth_mand_capt_yn\' value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' >\n<input type=hidden name=\'dflt_auth_ref_as_pol_no_yn\' id=\'dflt_auth_ref_as_pol_no_yn\' value=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' >\n\n<input type=hidden name=\'policy_coverage_basis_ind\' id=\'policy_coverage_basis_ind\' value=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'>\n\n</table>\n\n<input type=hidden name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'>\n<input type=hidden name=\"calling_module_id\" id=\"calling_module_id\"  value=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>\n<input type=hidden name=\"noofdecimal\" id=\"noofdecimal\"  value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n<input type=hidden name=\"billing_group\" id=\"billing_group\"  value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n<input type=hidden name=\"p_patient_class\" id=\"p_patient_class\"  value=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\'>\n<input type=hidden name=\"facility_id\" id=\"facility_id\"  value=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'>\n<input type=hidden name=\"modify_refresh\" id=\"modify_refresh\" value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\'>\n<input type=hidden name=\"restricted_YN\" id=\"restricted_YN\" value=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\'>\n<input type=hidden name=\"action\" id=\"action\" value=\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\'>\n<input type=hidden name=\"locn\" id=\"locn\" value=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'>\n<input type=hidden name=\"episode_type\" id=\"episode_type\" value=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\'>\n<input type=hidden name=\"query_string\" id=\"query_string\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n<input type=hidden name=\"blng_grp_code_array\" id=\"blng_grp_code_array\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\n<input type=hidden name=\"policy_coverage_basis_gbl_ind\" id=\"policy_coverage_basis_gbl_ind\" value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'>\n<input type=hidden name=\"totalRecords\" id=\"totalRecords\" value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'>\n\n<input type=hidden name=\"total_keys\" id=\"total_keys\" value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'>\n<input type=hidden name=\"max_priority_arr\" id=\"max_priority_arr\" value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'>\n<input type=hidden name=\"min_priority_arr\" id=\"min_priority_arr\" value=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\'>\n<input type=hidden name=\"priority_arr\" id=\"priority_arr\" value=\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'>\n<input type=hidden name=\"existing_priority_modify\" id=\"existing_priority_modify\" value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'>\n<input type=hidden name=\"max_priority\" id=\"max_priority\" value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'>\n\n<input type=hidden name=\"encounter_date_time\" id=\"encounter_date_time\" value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'>\n<input type=hidden name=\"encounter_date_aft_trunc\" id=\"encounter_date_aft_trunc\" value=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'>\n<input type=hidden name=\"pol_validity_chk_date\" id=\"pol_validity_chk_date\" value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'>\n\n<input type=\'hidden\' name=\'fin_class_flag_YN\' id=\'fin_class_flag_YN\' value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'>\n<input type=\'hidden\' name=\'autoFinChk\' id=\'autoFinChk\' value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\'>\n<input type=\'hidden\' name=\'class_code\' id=\'class_code\' value=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\'>\n<input type=\'hidden\' name=\'oldMapKey\' id=\'oldMapKey\' value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'>\n<input type=\'hidden\' name=\'package_enabled_yn\' id=\'package_enabled_yn\' value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n<input type=\'hidden\' name=\'appr_seq_no\' id=\'appr_seq_no\' value=\"1\">\n<input type=\'hidden\' name=\'checked_row\' id=\'checked_row\' value=\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\'>\n<input type=\'hidden\' name=\'rec_edited_YN\' id=\'rec_edited_YN\' value=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\'>\n\n<input type=\'hidden\' name=\'payer_suspended_YN\' id=\'payer_suspended_YN\' value=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'>\n<input type=\'hidden\' name=\'policy_suspended_YN\' id=\'policy_suspended_YN\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n<input type=\'hidden\' name=\'chargeLogicYn\' id=\'chargeLogicYn\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n\n<input type=\'hidden\' name=\'cust_id\' id=\'cust_id\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'>\n<!-- 08/07/2013\tKarthikeyan K\tMMS-QH-CRF-0010\t36789 -->\n<input type=\'hidden\' name=\'acrossEncounter\' id=\'acrossEncounter\' value=\'\'>\n<!-- 08/07/2013\tKarthikeyan K\tMMS-QH-CRF-0010\t36789 -->\n<!-- todayFormated Hidden variable Added by Rajesh V -->\n<input type=\'hidden\' name=\'todayFormated\' id=\'todayFormated\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>\n\n<input type=\'hidden\' name=\'plcyorEncounter\' id=\'plcyorEncounter\' value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'>\n<input type=\'hidden\' name=\'exp_days\' id=\'exp_days\' value=\'\'>\n<input type=\'hidden\' name=\'login_user\' id=\'login_user\' value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'>\n\n<input type=\'hidden\' name=\'blgrp_custgrp\' id=\'blgrp_custgrp\'\t\tvalue=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\'>\n<!-- todayFormated Hidden variable Added by Rajesh V -->\n</form>\n</body>\n";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n<script> set_selected_blng_grp();\t</script>\n";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n<script>cust_grp_lkup(\'C\');</script>\n";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n<script>LoadDefaultPolicydetails(\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\');</script>\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n</html>\n\n";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 =" \n\n";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	ResultSet rs3				= null;
	ResultSet rs1				= null;
	String strPlcyorEnctr		= null;
	//Rajesh - V
	String chargeLogicYn = "";
	String strCustomerId = "";
	
	//Rajesh - V
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	try
	{

	con	=	ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);
	String oldMapKey="";//added for package billing
	String query_string=request.getQueryString();
	String package_enabled_yn= request.getParameter("package_enabled_yn");// added for package billing
	if(package_enabled_yn == null) package_enabled_yn="N";
	int noofdecimal=2;
	String restrict_check="";
	String apprd_amt_restrict_check = "";
	String apprd_days_restrict_check = "";
	String cred_auth_req_yn = "", dflt_auth_ref_as_pol_no_yn = "",cred_auth_mand_capt_yn="";
	String readonly="";
	String strModuleId = request.getParameter("calling_module_id");
	if(strModuleId== null) strModuleId="";
	String patient_id = request.getParameter("patient_id");//added for package billing
	if(patient_id== null) patient_id="";//added for package billing
	String facility_id = (String)httpSession.getValue("facility_id");
	String p_patient_class=request.getParameter("patient_class");
	String episode_type="";
	String restricted_YN="";
	String encounter_date_time = "", encounter_date_aft_trunc="", pol_validity_chk_date= "";

	String addl_days_policy_expdt="",days_policy_expdt="",days_policy_strtdt=""; //GHL-0020 SCRUM CRF Related

	String fin_class_flag_YN="N",autoFinChk="N", class_code="";

	String checked_row="", rec_edited_YN="N";

	String total_keys=request.getParameter("total_keys");
	if(total_keys == null) total_keys="";

	String max_priority_arr=request.getParameter("max_priority_arr");
	if(total_keys == null) total_keys="";

	String min_priority_arr=request.getParameter("min_priority_arr");
	if(min_priority_arr == null) min_priority_arr="";

	String priority_arr=request.getParameter("priority_arr");
	if(priority_arr == null) priority_arr="";

	String max_priority=request.getParameter("max_priority");
	if(max_priority == null || max_priority.equals("")) max_priority="0";


	String v_display_hide="", v_display_hide_apprvd_amt="", v_display_hide_apprvd_days="";
	String v_display_hide_cred_auth="", v_credit_auth_val_mand="",v_display_hide_add_aprv="display:none";
	String str_curr_code_for_bg="";

	String billing_group=request.getParameter("billing_group");
	if(billing_group==null || billing_group.equals("")) billing_group="";
	
	String action=request.getParameter("action");
	if(action==null || action.equals("")) action="";

	String modify_refresh=request.getParameter("modify_refresh");
	if(modify_refresh==null || modify_refresh.equals("")) modify_refresh="N";

	String location=request.getParameter("locn");
	if(location==null || location.equals("")) location="";

	fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
	if(fin_class_flag_YN == null) fin_class_flag_YN="N";

	autoFinChk = request.getParameter("autoFinChk");
	if(autoFinChk == null) autoFinChk="N";

	class_code = request.getParameter("class_code");
	if(class_code == null) class_code="";

	checked_row = request.getParameter("checked_row");
	if(checked_row == null) checked_row="";

	rec_edited_YN = request.getParameter("rec_edited_YN");
	if(rec_edited_YN == null) rec_edited_YN="";

	String billing_grp_code ="",blng_grp_code_tokens="";
	String blng_grp_long_desc="";	String billing_grp_qry="";

	String select_billing_group="",payer_desc="", cust_3="", priority="", policy_type_desc="",policy_type_code="",policy_no="";
	String policy_start_date="",policy_exp_date="",credit_auth_ref="",credit_auth_date="";
	String credit_apprd_amt="",credit_apprd_days="",policy_eff_frm_date="",policy_eff_to_date="";
	String adj_rule_ind="",adj_perc_amt_ind="",adj_perc_amt_value="",pmnt_diff_adj_int="";
	String drg_pmnt_diff_adj_int="",spl_srv_pmnt_diff_adj_int="";
	String valid_payer_YN="",valid_policy_type_code_YN="";
	String cust_valid_from_date = "", cust_valid_to_date = "";
	String cust_group_code="",cust_group_name="",str_ins_cust_curr_code="",str_ins_cust_curr_desc="";
	String policy_coverage_basis_ind="";
	String policy_coverage_basis_gbl_ind="";
	String totalRecords="";
	String search_by_items = "", search_code = "", srch_by_desc = "";
	String cnty_sel="", regn_sel="";
	
		
		select_billing_group=billing_group;
	

	String payer_suspended_YN="", policy_suspended_YN="";

	policy_coverage_basis_gbl_ind=request.getParameter("policy_coverage_basis_gbl_ind");
	if(policy_coverage_basis_gbl_ind==null) policy_coverage_basis_gbl_ind="";

	totalRecords=request.getParameter("totalRecords");
	if(totalRecords==null) totalRecords="";

	priority=request.getParameter("priority");
	if(priority==null || priority.equals(" ")) priority="";

	encounter_date_time = request.getParameter("encounter_date_time");
	if(encounter_date_time == null) encounter_date_time="";

	CurrencyFormat cf1 = new CurrencyFormat();
	//Added by Rajesh - V
String todayFormated = "";
String strModifyPlcyYN = "";
String addPayerCustGrpbySetup = "";

try {
	String sqlBLParam = "Select CHARGE_LOGIC_YN,to_char(sysdate,'dd/mm/yyyy') todaydate,MOD_POLICY_DTL_DURING_REG_YN MODIFY_POLICY_YN,ADD_PAYER_CUSTGRP_BY_SETUP from BL_PARAMETERS WHERE OPERATING_FACILITY_ID = ? ";
	pstmt = con.prepareStatement(sqlBLParam);
	pstmt.setString(1, facility_id);
	rs1 = pstmt.executeQuery();
	if (rs1 != null) {
		while (rs1.next()) {
			chargeLogicYn = rs1.getString("CHARGE_LOGIC_YN");
			todayFormated = rs1.getString("todaydate");
			strModifyPlcyYN = rs1.getString("MODIFY_POLICY_YN");
			addPayerCustGrpbySetup = rs1.getString("ADD_PAYER_CUSTGRP_BY_SETUP");
			chargeLogicYn = chargeLogicYn == null ? "": chargeLogicYn;
		}
	}

	pstmt = null;
	rs1 = null;
} catch (Exception e) {
	System.out.println("Exception in getting bl_param" + e);
}

	//Added by Rajesh - V

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
		System.out.println("Exception in getting bl_param"+e);
	}


	try
	{		
		String sql_deci_date = " select nvl(no_of_decimal,2),to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from sm_acc_entity_param where acc_entity_id='ZZ'";
		pstmt = con.prepareStatement( sql_deci_date);
					
		rs1 = pstmt.executeQuery();	
		if( rs1!= null ) 
		{
			while( rs1.next() )
			{
				noofdecimal  =  rs1.getInt(1);
				encounter_date_aft_trunc = rs1.getString(2);
			}
		}
		
		if (rs1 != null)   rs1.close();
		if (pstmt != null) pstmt.close();	
	}
	catch(Exception e)
	{
		System.out.println("4="+e.toString());
	}
	if(encounter_date_aft_trunc == null) encounter_date_aft_trunc="";

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
/* PE Changes
	try
	{
		String sql_trunc_time="select to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

		stmt = con.createStatement();
		rs = stmt.executeQuery(sql_trunc_time) ;

		if( rs!= null ) 
		{
			while( rs.next() )
			{  
				encounter_date_aft_trunc = rs.getString(1);
			}
		}
		if (rs != null)   rs.close();
		stmt.close();
	}
	catch(Exception e)
	{
		System.out.println("Exception while executing sql_trunc_time :"+e);
	}
	if(encounter_date_aft_trunc == null) encounter_date_aft_trunc="";
*/
	if(!encounter_date_aft_trunc.equals(""))
	{
		encounter_date_aft_trunc = com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY","en",locale);
	}

	if(action.equals("add") && location.equals("outside"))
	{
		blng_grp_code_tokens=request.getParameter("blng_grp_code_array");
		if(blng_grp_code_tokens==null || blng_grp_code_tokens.equals("")) blng_grp_code_tokens="";
	}

	if(action.equals("modify") || action.equals("remove") || (action.equals("add") && modify_refresh.equals("Y")))
	{
		select_billing_group=request.getParameter("select_billing_group");
		if(select_billing_group==null || select_billing_group.equals("")) select_billing_group="";
	
		billing_group=request.getParameter("blng_grp_code");
		if(billing_group==null || billing_group.equals(" ")) billing_group="";

		str_curr_code_for_bg=request.getParameter("curr_code_for_bg");
		if(str_curr_code_for_bg==null || str_curr_code_for_bg.equals(" ")) str_curr_code_for_bg="";

		payer_desc=request.getParameter("payer_desc");
		if(payer_desc==null || payer_desc.equals(" ")) payer_desc="";

		cust_3=request.getParameter("cust_3");
		if(cust_3==null || cust_3.equals(" ")) cust_3="";

		cust_group_code=request.getParameter("ins_cust_group_code");
		if(cust_group_code==null || cust_group_code.equals(" ")) cust_group_code="";


		str_ins_cust_curr_code =request.getParameter("ins_cust_curr_code");
		if(str_ins_cust_curr_code==null || str_ins_cust_curr_code.equals(" ")) str_ins_cust_curr_code="";

		str_ins_cust_curr_desc =request.getParameter("ins_cust_curr_desc");
		if(str_ins_cust_curr_desc==null || str_ins_cust_curr_desc.equals(" ")) str_ins_cust_curr_desc="";

		cust_group_name=request.getParameter("ins_cust_group_name");
		if(cust_group_name==null || cust_group_name.equals(" ")) cust_group_name="";
/*
		priority=request.getParameter("priority");
		if(priority==null || priority.equals(" ")) priority="";
*/
		policy_type_desc=request.getParameter("policy_type_desc");
		if(policy_type_desc==null || policy_type_desc.equals(" ")) policy_type_desc="";

		policy_type_code=request.getParameter("policy_type_code");
		if(policy_type_code==null || policy_type_code.equals(" ")) policy_type_code="";

		policy_no=request.getParameter("policy_no");
		if(policy_no==null || policy_no.equals(" ")) policy_no="";
		
		policy_start_date=request.getParameter("policy_start_date");
		if(policy_start_date==null || policy_start_date.equals(" ") || policy_start_date.equals("null")) policy_start_date="";

		policy_exp_date=request.getParameter("policy_exp_date");
		if(policy_exp_date==null || policy_exp_date.equals(" ") || policy_exp_date.equals("null")) policy_exp_date="";
		
//		System.out.println("Expiry date ####  "+policy_exp_date);

		credit_auth_ref=request.getParameter("credit_auth_ref");
		if(credit_auth_ref==null || credit_auth_ref.equals(" ")) credit_auth_ref="";

		credit_auth_date=request.getParameter("credit_auth_date");
		if(credit_auth_date==null || credit_auth_date.equals(" ")) credit_auth_date="";

		credit_apprd_amt=request.getParameter("credit_apprd_amt");
		if(credit_apprd_amt==null || credit_apprd_amt.equals(" ")) credit_apprd_amt="";

		credit_apprd_days=request.getParameter("credit_apprd_days");
		if(credit_apprd_days==null || credit_apprd_days.equals(" ")) credit_apprd_days="";

		policy_eff_frm_date=request.getParameter("policy_eff_frm_date");
		if(policy_eff_frm_date==null || policy_eff_frm_date.equals(" ")) policy_eff_frm_date="";

		policy_eff_to_date=request.getParameter("policy_eff_to_date");
		if(policy_eff_to_date==null || policy_eff_to_date.equals(" ")) policy_eff_to_date="";

		adj_rule_ind=request.getParameter("adj_rule_ind");
		if(adj_rule_ind==null || adj_rule_ind.equals(" ")) adj_rule_ind="";

		adj_perc_amt_ind=request.getParameter("adj_perc_amt_ind");
		if(adj_perc_amt_ind==null || adj_perc_amt_ind.equals(" ")) adj_perc_amt_ind="";

		adj_perc_amt_value=request.getParameter("adj_perc_amt_value");
		if(adj_perc_amt_value==null || adj_perc_amt_value.equals(" ")) adj_perc_amt_value="";
		if(!adj_perc_amt_value.equals(""))
		{
			adj_perc_amt_value = cf1.formatCurrency(adj_perc_amt_value,noofdecimal);
		}

		pmnt_diff_adj_int=request.getParameter("pmnt_diff_adj_int");
		if(pmnt_diff_adj_int==null || pmnt_diff_adj_int.equals(" ")) pmnt_diff_adj_int="";

		drg_pmnt_diff_adj_int=request.getParameter("drg_pmnt_diff_adj_int");
		if(drg_pmnt_diff_adj_int==null || drg_pmnt_diff_adj_int.equals(" ")) drg_pmnt_diff_adj_int="";

		spl_srv_pmnt_diff_adj_int=request.getParameter("spl_srv_pmnt_diff_adj_int");
		if(spl_srv_pmnt_diff_adj_int==null || spl_srv_pmnt_diff_adj_int.equals(" ")) spl_srv_pmnt_diff_adj_int="";

		valid_payer_YN=request.getParameter("valid_payer_YN");
		if(valid_payer_YN==null || valid_payer_YN.equals(" ")) valid_payer_YN="";

		cust_valid_from_date=request.getParameter("cust_valid_from_date");
		if(cust_valid_from_date==null || cust_valid_from_date.equals(" ")) cust_valid_from_date="";

		cust_valid_to_date=request.getParameter("cust_valid_to_date");
		if(cust_valid_to_date==null || cust_valid_to_date.equals(" ")) cust_valid_to_date="";

		valid_policy_type_code_YN=request.getParameter("valid_policy_type_code_YN");
		if(valid_policy_type_code_YN==null || valid_policy_type_code_YN.equals(" ")) valid_policy_type_code_YN="";

		policy_coverage_basis_ind=request.getParameter("policy_coverage_basis_ind");
		if(policy_coverage_basis_ind==null || policy_coverage_basis_ind.equals(" ")) policy_coverage_basis_ind="";

		search_by_items = request.getParameter("search_by_items");
		if(search_by_items==null || search_by_items.equals(" ")) search_by_items="";

		search_code = request.getParameter("search_code");
		if(search_code==null || search_code.equals(" ")) search_code="";

		srch_by_desc = request.getParameter("srch_by_desc");
		if(srch_by_desc==null || srch_by_desc.equals(" ")) srch_by_desc="";

		pol_validity_chk_date = request.getParameter("pol_validity_chk_date");
		if(pol_validity_chk_date==null || pol_validity_chk_date.equals(" ")) pol_validity_chk_date="";

		payer_suspended_YN = request.getParameter("payer_suspended_YN");
		if(payer_suspended_YN==null || payer_suspended_YN.equals(" ")) payer_suspended_YN="";

		policy_suspended_YN = request.getParameter("policy_suspended_YN");
		if(policy_suspended_YN==null || policy_suspended_YN.equals(" ")) policy_suspended_YN="";
	}
	
	if(action.equals("modify") || action.equals("remove") || (action.equals("add") && modify_refresh.equals("Y")))
	{
		if(search_by_items.equals("CY"))
		{
			cnty_sel="SELECTED";
		}
		else if(search_by_items.equals("RN"))
		{
			regn_sel="SELECTED";
		}
		else
		{
			regn_sel="SELECTED";
		}
	}
	else if(action.equals("add") && !modify_refresh.equals("Y"))
	{
		regn_sel="SELECTED";
		cnty_sel="";
	}

	if (!locale.equals("en") && !modify_refresh.equals("Y"))
	{
		if(!policy_start_date.equals(""))
			policy_start_date=com.ehis.util.DateUtils.convertDate(policy_start_date,"DMY","en",locale);
			
		if(!policy_exp_date.equals(""))
			policy_exp_date=com.ehis.util.DateUtils.convertDate(policy_exp_date,"DMY","en",locale);

		if(!credit_auth_date.equals(""))
			credit_auth_date=com.ehis.util.DateUtils.convertDate(credit_auth_date,"DMY","en",locale);

		if(!policy_eff_frm_date.equals(""))
			policy_eff_frm_date=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date,"DMY","en",locale);

		if(!policy_eff_to_date.equals(""))
			policy_eff_to_date=com.ehis.util.DateUtils.convertDate(policy_eff_to_date,"DMY","en",locale);

	}

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


	if(action.equals("modify") || action.equals("remove"))
	{
		readonly="readonly";
	}

	if(!(policy_type_code.equals("") && cust_3.equals("")))
	{
//	String restrict_check_sql="SELECT DECODE('"+episode_type+"','O',NVL(OUTPATIENT_LIMIT_TYPE,'U'),'E',NVL(OUTPATIENT_LIMIT_TYPE,'U'),'I',NVL(INPATIENT_LIMIT_TYPE,'U'),'D',NVL(INPATIENT_LIMIT_TYPE,'U'),'U') FROM BL_INS_POLICY_TYPE_HDR WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND POLICY_TYPE_CODE = '"+policy_type_code+"' AND CUST_CODE = '"+cust_3+"'";
		try
		{
			String restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U') , DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '"+cust_3+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code='"+cust_group_code+"'";
			String empty_sql_check="N";

			pstmt = con.prepareStatement(restrict_check_sql);
			rs=pstmt.executeQuery();
			if( rs != null ) 
			{
				empty_sql_check="Y";
				while(rs.next())
				{
					restrict_check = rs.getString(1);
					apprd_amt_restrict_check = rs.getString(2); 
					apprd_days_restrict_check = rs.getString(3); 
					cred_auth_req_yn = rs.getString(4); 
					dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
					cred_auth_mand_capt_yn = rs.getString(6); 
					empty_sql_check="N";
				}
			}
			if (rs != null)   rs.close();
			pstmt.close();

			if(empty_sql_check.equals("Y"))
			{
				restrict_check="";
				restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '**' and a.cust_group_code ='"+cust_group_code+"'";

				pstmt = con.prepareStatement(restrict_check_sql);
				rs=pstmt.executeQuery();
				if( rs != null ) 
				{
					while(rs.next())
					{
						restrict_check=rs.getString(1);
						apprd_amt_restrict_check = rs.getString(2); 
						apprd_days_restrict_check = rs.getString(3); 
						cred_auth_req_yn = rs.getString(4); 
						dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
						cred_auth_mand_capt_yn = rs.getString(6);
					}
				}
				if (rs != null)   rs.close();
				pstmt.close();
			}
		}
		catch(Exception e)
		{
			out.println("Exception in restrict_check_sql:"+e);
		}
	}
	if(restrict_check==null || restrict_check.equals("")) restrict_check="U";
	if(apprd_amt_restrict_check==null || apprd_amt_restrict_check.equals("")) apprd_amt_restrict_check="U";
	if(apprd_days_restrict_check==null || apprd_days_restrict_check.equals("")) apprd_days_restrict_check="U";
	if(cred_auth_req_yn==null || cred_auth_req_yn.equals("")) cred_auth_req_yn="N";
	if(cred_auth_mand_capt_yn == null || cred_auth_mand_capt_yn.equals("")) cred_auth_mand_capt_yn="N";
	if(dflt_auth_ref_as_pol_no_yn==null || dflt_auth_ref_as_pol_no_yn.equals("")) dflt_auth_ref_as_pol_no_yn="N";

	if(restrict_check.equals("R"))
	{
		restricted_YN="";
		
		if(apprd_amt_restrict_check.equals("U"))
		{
			v_display_hide_apprvd_amt = "display:none";
			credit_apprd_amt="";
		}

		if(apprd_days_restrict_check.equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
			credit_apprd_days="";
		}
	}
	else if(restrict_check.equals("U"))
	{
		restricted_YN="DISABLED";
		v_display_hide="display:none";
		v_display_hide_apprvd_amt = "display:none";
		v_display_hide_apprvd_days = "display:none";
		credit_apprd_amt="";
		credit_apprd_days="";
	}
	if(cred_auth_req_yn.equals("Y"))
	{
		v_display_hide_cred_auth = "display:inline";
		if(cred_auth_mand_capt_yn.equals("Y"))
		{
			v_credit_auth_val_mand = "display:inline";
		}
		else
		{
			v_credit_auth_val_mand = "display:none";
		}
/*		if(dflt_auth_ref_as_pol_no_yn.equals("Y"))
		{
			if(!policy_no.equals("") && credit_auth_ref.equals(""))
			{
				int policy_no_len = policy_no.length();
				if(policy_no_len <=20 )
					credit_auth_ref = policy_no.substring(0,policy_no_len);
				else
					credit_auth_ref = policy_no.substring(0,20);
			}
		}
		if(credit_auth_date.equals("") && !credit_auth_ref.equals(""))
		{
			credit_auth_date = encounter_date_aft_trunc;
		}
*/
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
		v_credit_auth_val_mand = "display:none";
		credit_auth_ref = "";
		credit_auth_date = "";
	}

	if(modify_refresh.equals("Y"))
	{
		try
		{
			String sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_GROUP_CODE = '"+cust_group_code+"' AND a.CUST_CODE = '"+cust_3+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;

			String empty_sql_check="N";

			if( rs!= null ) 
			{
				empty_sql_check="Y";
				while( rs.next() )
				{  
					policy_coverage_basis_ind = rs.getString(1);
					empty_sql_check="N";
				}
			}
			if (rs != null)   rs.close();
			stmt.close();

			if(empty_sql_check.equals("Y"))
			{
				sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_GROUP_CODE = '"+cust_group_code+"' AND a.CUST_CODE = '**' and b.cust_group_code = a.cust_group_code and b.cust_code='"+cust_3+"'";
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;

				if( rs!= null ) 
				{
					while( rs.next() )
					{  
						policy_coverage_basis_ind = rs.getString(1);
					}
				}
				if (rs != null)   rs.close();
				stmt.close();
			}
		}		
		catch(Exception e)
		{
			out.println("Exception in sql_policy_coverage_basis_ind:"+e);
		}
	}

	if(!credit_apprd_days.equals("") && !policy_eff_frm_date.equals("") && apprd_days_restrict_check.equals("R"))
	{
		if(!pol_validity_chk_date.equals(""))
		{
			if(!modify_refresh.equals("Y"))
				pol_validity_chk_date=com.ehis.util.DateUtils.convertDate(pol_validity_chk_date,"DMY","en",locale);
		}
	}

	if(!cust_3.equals(""))
	{
		try
		{
			pstmt = con.prepareStatement( " select currency_code,currency_desc from ar_customer_lang_vw where cust_code='"+cust_3+"' and language_id='"+locale+"'");
						
			rs1 = pstmt.executeQuery();	
			if ( rs1.next() && rs1 != null ) 
			{
				str_ins_cust_curr_code  =  rs1.getString(1);
				str_ins_cust_curr_desc  =  rs1.getString(2);	
			}
			if(str_ins_cust_curr_code == null) str_ins_cust_curr_code ="";		
			if(str_ins_cust_curr_desc == null) str_ins_cust_curr_desc="";		
			if (rs1 != null)   rs1.close();
			if (pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("5="+e.toString());
		}
	}

	try
	{

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);
            _bw.write(_wl_block9_2Bytes, _wl_block9_2);
            _bw.write(_wl_block9_3Bytes, _wl_block9_3);
            _bw.write(_wl_block9_4Bytes, _wl_block9_4);

		   String LINK_POLICY_IN_BILLING=(String)session.getAttribute("LINK_POLICY_IN_BILLING"); 
		   if(LINK_POLICY_IN_BILLING.equalsIgnoreCase("Y")){
		  
            _bw.write(_wl_block10Bytes, _wl_block10);
 } 
            _bw.write(_wl_block11_0Bytes, _wl_block11_0);
            _bw.write(_wl_block11_1Bytes, _wl_block11_1);
            _bw.write(_wl_block11_2Bytes, _wl_block11_2);
            _bw.write(_wl_block11_3Bytes, _wl_block11_3);
            _bw.write(_wl_block11_4Bytes, _wl_block11_4);
            _bw.write(_wl_block11_5Bytes, _wl_block11_5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

if(action.equals("add") && location.equals("outside"))
{

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

	StringTokenizer st=new StringTokenizer(blng_grp_code_tokens,"|");
	String temp_string="";
	while( st.hasMoreTokens() ) 
		{
			billing_grp_code = st.nextToken();

			if(!(temp_string.equals(billing_grp_code)))
			{
				billing_grp_qry="SELECT SHORT_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = '"+billing_grp_code+"' AND LANGUAGE_ID = '"+locale+"'";
				pstmt1 = con.prepareStatement(billing_grp_qry);
				rs3=pstmt1.executeQuery();
				if( rs3 != null ) 
				{
					while(rs3.next())
					{
						blng_grp_long_desc=rs3.getString(1);
					}
				}
				if(rs3 != null) rs3.close();
				pstmt1.close();
				if(blng_grp_long_desc == null) blng_grp_long_desc="";
		
				if(select_billing_group.equals(billing_grp_code))
				{
					out.println("<option value=\""+billing_grp_code+"\" SELECTED>"+blng_grp_long_desc+"</option>");
					temp_string=billing_grp_code;
				}
				else
				{
					out.println("<option value=\""+billing_grp_code+"\">"+blng_grp_long_desc+"</option>");
					temp_string=billing_grp_code;
				}
			}
		}
	
	pstmt.close() ;

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(select_billing_group));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(str_curr_code_for_bg));
            _bw.write(_wl_block18Bytes, _wl_block18);

		/******Remove this payer from the PkgApprovalBean and then insert the modified one********start*******/
oldMapKey=select_billing_group.trim()+"~~"+cust_group_code.trim()+"~~"+cust_3.trim()+"~~"+priority.trim()+"~~"+policy_type_code.trim()+"~~"+policy_no.trim()+"~~"+policy_eff_frm_date.trim();
/******Remove this payer from the PkgApprovalBean and then insert the modified one********end*******/
	}
	else if(action.equals("add") && location.equals("inside"))
	{

		billing_grp_qry="SELECT SHORT_DESC,CURRENCY_CODE FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = '"+billing_group+"' AND LANGUAGE_ID = '"+locale+"'";
	
		pstmt = con.prepareStatement(billing_grp_qry);
		rs2=pstmt.executeQuery();
		if( rs2 != null ) 
		{
			while(rs2.next())
			{
				blng_grp_long_desc=rs2.getString(1);
				str_curr_code_for_bg=rs2.getString(2);
			}
		}
		if(str_curr_code_for_bg == null) str_curr_code_for_bg="";
		if(rs2 != null) rs2.close();
		pstmt.close();

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(str_curr_code_for_bg));
            _bw.write(_wl_block22Bytes, _wl_block22);

		/******Remove this payer from the PkgApprovalBean and then insert the modified one*******start********/
oldMapKey=billing_group.trim()+"~~"+cust_group_code.trim()+"~~"+cust_3.trim()+"~~"+priority.trim()+"~~"+policy_type_code.trim()+"~~"+policy_no.trim()+"~~"+policy_eff_frm_date.trim();
		/******Remove this payer from the PkgApprovalBean and then insert the modified one*******end********/
	}
	else if(action.equals("modify") || action.equals("remove"))
	{
		billing_grp_qry="SELECT SHORT_DESC,CURRENCY_CODE FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = '"+billing_group+"' AND LANGUAGE_ID = '"+locale+"'";
	
		pstmt = con.prepareStatement(billing_grp_qry);
		rs2=pstmt.executeQuery();
		if( rs2 != null ) 
		{
			while(rs2.next())
			{
				blng_grp_long_desc=rs2.getString(1);
				str_curr_code_for_bg=rs2.getString(2);
			}
		}
		if(str_curr_code_for_bg == null) str_curr_code_for_bg="";
		if(rs2 != null) rs2.close();
		pstmt.close();

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(str_curr_code_for_bg));
            _bw.write(_wl_block22Bytes, _wl_block22);

		/******Remove this payer from the PkgApprovalBean and then insert the modified one********start*******/
oldMapKey=billing_group.trim()+"~~"+cust_group_code.trim()+"~~"+cust_3.trim()+"~~"+priority.trim()+"~~"+policy_type_code.trim()+"~~"+policy_no.trim()+"~~"+policy_eff_frm_date.trim();
	/******Remove this payer from the PkgApprovalBean and then insert the modified one********end*******/
	}
	if(!encounter_date_time.equals(""))
	{

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(encounter_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block28Bytes, _wl_block28);

	}
	else
	{

            _bw.write(_wl_block29Bytes, _wl_block29);

	}

            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cnty_sel));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(regn_sel));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(srch_by_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(srch_by_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(cust_group_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(cust_group_code));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(payer_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(cust_3));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(str_ins_cust_curr_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(str_ins_cust_curr_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(valid_payer_YN));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block51Bytes, _wl_block51);

String sql1="Select DISTINCT a.policy_type_code POLICY_TYPE_CODE,a.short_desc SHORT_DESC,POLICY_COVERAGE_BASIS POLICY_COVERAGE_BASIS"
			 +" from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c" 
			 +" where a.language_id='"+locale+"'" 
			 +" and  a.operating_facility_id='"+facility_id+"'" 
		   	 +" and nvl(a.status,'N') <> 'S'"
			 +" and a.operating_facility_id = b.operating_facility_id"  
			 +" and a.policy_type_code = b.policy_type_code"
			 +" and c.cust_group_code = b.cust_group_code"
			 +" and (b.cust_code=c.cust_code or b.cust_code = '**')"
			 +" and (('"+strModuleId+"' in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y')" 
			 +" or ('"+strModuleId+"' in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y')"
			 +" or ('"+strModuleId+"' = 'MP' and nvl(b.external_covered,'N') = 'Y'))";

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(sql1));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
 if( "Y".equals(chargeLogicYn)) { 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(policy_type_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block57Bytes, _wl_block57);
}else{
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(policy_type_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(policy_type_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(valid_policy_type_code_YN));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(policy_no));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(policy_no));
            _bw.write(_wl_block65Bytes, _wl_block65);

	/* ***************GHL-0020 SCRUM CRF related changes begins ***************** */

//	String encounter_date="";
	try
	{
/*		String enc_Date="select to_char((to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys from dual";
		pstmt = con.prepareStatement(enc_Date);
		rs2=pstmt.executeQuery();
		if( rs2 != null ) 
		{
			while(rs2.next())
			{
				encounter_date=rs2.getString("sys");
			}
		}
		
		if(rs2 != null) rs2.close();
		pstmt.close();

//		if(policy_start_date.equals("") || !policy_start_date.equals(encounter_date))
*/ //Commented the Query as its already available above with variable encounter_date_aft_trunc

	//Commented by Karthik against incident  IN035788 on date 25/3/2013

	//	if(policy_start_date.equals("") || !policy_start_date.equals(encounter_date_aft_trunc))

	//end  IN035788
	
	

	if(policy_start_date.equals("") && (strCustomerId.equals("ALMO")==false))
		{
			//String pocy_date_valid="select  ADDL_DAYS_POLICY_EXPDT,To_Char (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')+ADDL_DAYS_POLICY_EXPDT,'DD/MM/YYYY') SYS1, to_char((to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys from BL_INS_POLICY_TYPE_HDR 	where CUST_GROUP_CODE   = '"+cust_group_code+"' and POLICY_TYPE_CODE  ='"+policy_type_code +"' and CUST_CODE = '"+cust_3+"'  AND   DEF_REQ_POLICY_DATES='Y'";
			
			String pocy_date_valid="SELECT addl_days_policy_expdt, to_char(to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI') + nvl(addl_days_policy_expdt,0),'DD/MM/YYYY') sys1, to_char((to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys FROM bl_ins_policy_type_hdr WHERE OPERATING_FACILITY_ID='"+facility_id+"'AND cust_group_code = '"+cust_group_code+"' AND policy_type_code = '"+policy_type_code +"' AND (cust_code = '"+cust_3+"' OR (cust_code <> '"+cust_3+"' AND cust_code = '**')) AND def_req_policy_dates = 'Y'";

			pstmt = con.prepareStatement(pocy_date_valid);
			rs2=pstmt.executeQuery();
				
			if( rs2 != null ) 
			{
				while(rs2.next())
				{
					addl_days_policy_expdt=rs2.getString("addl_days_policy_expdt");
					policy_start_date=days_policy_strtdt=rs2.getString("sys");
					policy_exp_date=days_policy_expdt=rs2.getString("sys1");
				}
			}
		
			if(rs2 != null) rs2.close();
			pstmt.close();	
		}	
	}
	catch(Exception ex)
	{
		System.err.println("Exception occred in default policy validation"+ex);
		ex.printStackTrace();
	}

	
/* ***************GHL-0020 SCRUM CRF related changes end ***************** */

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
 if(strCustomerId.equals("ALMO") &&  policy_start_date.length() > 0) 
	 {
		 
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(policy_start_date));
            _bw.write(_wl_block69Bytes, _wl_block69);
} else { 
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(policy_start_date));
            _bw.write(_wl_block71Bytes, _wl_block71);
} 
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
 
	 	System.out.println("Policy exp date "+policy_exp_date);
	 
	 if(strCustomerId.equals("ALMO") &&  policy_exp_date.length() > 0) 
	 {
		 
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(policy_exp_date));
            _bw.write(_wl_block74Bytes, _wl_block74);
} else { 
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(policy_exp_date));
            _bw.write(_wl_block76Bytes, _wl_block76);
}  
            _bw.write(_wl_block77Bytes, _wl_block77);

	//System.out.println("rec_edited_yn "+rec_edited_YN);
	if(rec_edited_YN.equals("N") && strCustomerId.equals("ALMO")==false)
	{

            _bw.write(_wl_block78Bytes, _wl_block78);

	}

            _bw.write(_wl_block79Bytes, _wl_block79);
if(package_enabled_yn.equals("Y")){
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(credit_auth_ref));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(v_credit_auth_val_mand));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(credit_auth_date));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(v_credit_auth_val_mand));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(v_credit_auth_val_mand));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
 if(strCustomerId.equals("ALMO") &&  credit_apprd_amt.length() > 0) 
	 {	 
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(credit_apprd_amt));
            _bw.write(_wl_block94Bytes, _wl_block94);
 }else{ 
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(credit_apprd_amt));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(restricted_YN));
            _bw.write(_wl_block96Bytes, _wl_block96);
} 
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
 
	 if(strCustomerId.equals("ALMO") &&  credit_apprd_days.length() > 0) 
		 
	 {	 
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(credit_apprd_days));
            _bw.write(_wl_block101Bytes, _wl_block101);
 }else{ 
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(credit_apprd_days));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(restricted_YN));
            _bw.write(_wl_block103Bytes, _wl_block103);
} 
            _bw.write(_wl_block104Bytes, _wl_block104);
}else{
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(credit_auth_ref));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(credit_auth_ref));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(v_credit_auth_val_mand));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(credit_auth_date));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(v_credit_auth_val_mand));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(v_credit_auth_val_mand));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(credit_apprd_amt));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(restricted_YN));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(credit_apprd_days));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(restricted_YN));
            _bw.write(_wl_block116Bytes, _wl_block116);
}
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(policy_eff_frm_date));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
if("ALMO".equals(strCustomerId) && "Y".equals(chargeLogicYn)){ 
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(policy_eff_to_date));
            _bw.write(_wl_block122Bytes, _wl_block122);
} else{ 
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(policy_eff_to_date));
            _bw.write(_wl_block123Bytes, _wl_block123);
} 
            _bw.write(_wl_block124Bytes, _wl_block124);

	String adj_rule_select_A="",adj_rule_select_NA="";
	if(adj_rule_ind.equals("A"))
	{
		adj_rule_select_A = "SELECTED";
		adj_rule_select_NA = "";
	}
	else
	{
		adj_rule_select_NA= "SELECTED";
		adj_rule_select_A = "";
	}

	String adj_ind_select_P="",adj_ind_select_A="";
	if(adj_perc_amt_ind.equals("P"))
	{
		adj_ind_select_P = "SELECTED";
		adj_ind_select_A = "";
	}
	else if(adj_perc_amt_ind.equals("A"))
	{
		adj_ind_select_A= "SELECTED";
		adj_ind_select_P = "";
	}
	else
	{
		adj_ind_select_A= "";
		adj_ind_select_P = "";
	}

            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(adj_rule_select_A));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(adj_rule_select_NA));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(adj_rule_ind));
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(adj_ind_select_P));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(adj_ind_select_A));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(adj_perc_amt_ind));
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(adj_perc_amt_value));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(adj_perc_amt_value));
            _bw.write(_wl_block137Bytes, _wl_block137);

	String acc_int_desc="";

	String adj_code_sql="SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_entity_code = (select acc_entity_code from sy_acc_entity where acc_entity_id='"+facility_id+"') and acc_int_code='"+pmnt_diff_adj_int+"' and LANGUAGE_ID='"+locale+"'";

	pstmt = con.prepareStatement(adj_code_sql);
	rs=pstmt.executeQuery();
	while(rs.next())
	{
		acc_int_desc = rs.getString(1);
	}
	if (rs != null)   rs.close();
	pstmt.close();


            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(acc_int_desc));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(acc_int_desc));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(pmnt_diff_adj_int));
            _bw.write(_wl_block142Bytes, _wl_block142);

HashMap<String,String> claimCreditMap=(HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION");
String claim_code="";
String credit_authorisation_by="";
String membershipId="";

if(claimCreditMap!=null){
String claimCredit=claimCreditMap.get(priority);
	
	if(claimCredit!=null){
		
		String[] arrClaimCredit= StringUtils.splitPreserveAllTokens(claimCredit,"~");
		if(arrClaimCredit.length >0){
		claim_code=arrClaimCredit[0];
		credit_authorisation_by=arrClaimCredit[1];
		membershipId=arrClaimCredit[2];
		}
/* 		StringTokenizer stClaimCredit=new StringTokenizer(claimCredit,"~");
		if(stClaimCredit.hasMoreTokens())
		claim_code=stClaimCredit.nextToken();
		if(stClaimCredit.hasMoreTokens())
		credit_authorisation_by=stClaimCredit.nextToken(); */
	}
}

            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(claim_code));
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(credit_authorisation_by));
            _bw.write(_wl_block146Bytes, _wl_block146);

		/**** added for package billing *********** start *************/		
if(package_enabled_yn.equals("Y") && !v_display_hide_apprvd_amt.equals("display:none") ){
v_display_hide_add_aprv="display:inline";
}else{
v_display_hide_add_aprv="display:none";
}


if((strModuleId.equals("OP") || strModuleId.equals("IP")) && package_enabled_yn.equals("Y")){
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
}		/**** added for package billing *********** end *************/

            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(membershipId));
            _bw.write(_wl_block152Bytes, _wl_block152);
 

			 strPlcyorEnctr ="policy";
			String enc_episode_id ="";
			String  enc_patient_id ="";
			String  enc_visit_id ="";
			String  enc_episode_type ="";
			String  enc_locale ="";
			String  strEncPatRegDate="";
			String enc_facility_id="";
			String enc_acc_seq ="";
			String enc_polcy_no="";
			String dflt_policy_vst_reg="";

	System.out.println(" Elements ########### "+session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS"));
		if(session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS")!=null)
		{

		HashMap hashPlcyorEnctr=(HashMap)session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS");

		enc_facility_id		=""+hashPlcyorEnctr.get("enc_facility_id");
		enc_patient_id		=""+hashPlcyorEnctr.get("enc_patient_id");
		enc_episode_type	=""+hashPlcyorEnctr.get("enc_episode_type");
		enc_episode_id		=""+hashPlcyorEnctr.get("enc_episode_id");
		enc_visit_id		=""+hashPlcyorEnctr.get("enc_visit_id");
		enc_acc_seq			=""+hashPlcyorEnctr.get("acct_seq");
		enc_polcy_no		=""+hashPlcyorEnctr.get("policy_num");
		dflt_policy_vst_reg =""+hashPlcyorEnctr.get("dflt_policy_vst_reg");

		enc_locale			=""+hashPlcyorEnctr.get("enc_locale");
		strEncPatRegDate =  ""+hashPlcyorEnctr.get("encounter_date");		
		
		
		//if((enc_episode_type.equals("R") || (enc_episode_id!=null && enc_episode_id.equals("null")==false && !"".equals(enc_episode_id)) ) && dflt_policy_vst_reg.equals("N"))
		//	strPlcyorEnctr ="encounter"; 
		
		System.out.println(" Elements ###########  enc_episode_type "+enc_episode_type+" enc_episode_id =  "+enc_episode_id);   
				
		
		}
		try{
			String strPolicyorEncQry = " SELECT count(*) FROM bl_ins_policy_addl_hdr hdr "+
					 	" WHERE hdr.operating_facility_id = '"+facility_id+"'"+
					    " AND hdr.cust_group_code  = '"+cust_group_code+"'"+
					    " AND hdr.cust_code  = '"+cust_3+"'"+
					    " AND hdr.policy_type_code = '"+policy_type_code+"'"+
					    " AND hdr.patient_id  = '"+patient_id+"'"+
						" AND hdr.episode_type  = 'R'";

			//System.out.println(strPolicyorEncQry);
			PreparedStatement pstmtPolEnc = con.prepareStatement(strPolicyorEncQry);		
			ResultSet rsPolEnc = pstmtPolEnc.executeQuery();
			if(rsPolEnc != null){
				while(rsPolEnc.next()){
					String strPolicyorEnc = rsPolEnc.getString(1);
					if(strPolicyorEnc!=null){
						int polEncChk=Integer.parseInt(strPolicyorEnc);
						if(polEncChk==0){
							strPlcyorEnctr ="policy";
						}else{
							strPlcyorEnctr ="encounter";
						}
					}
				}
			}
			if(pstmtPolEnc!=null){
				pstmtPolEnc.close();
			}
			if(rsPolEnc!=null){
				rsPolEnc.close();
			}
	}catch(Exception e){
		System.out.println("Exception in getting strPolicyorEncQry"+e);
	}	
			
	String policyBLInclusionFlag= (session.getAttribute("LINK_POLICY_IN_BILLING")==null) ? "N": (String)session.getAttribute("LINK_POLICY_IN_BILLING");
	if(policyBLInclusionFlag!=null && policyBLInclusionFlag.equals("Y") && strModifyPlcyYN.equals("Y")){ 
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(strPlcyorEnctr));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(enc_episode_id));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(enc_patient_id));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(enc_episode_type));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(enc_visit_id));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(enc_acc_seq));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(enc_polcy_no));
            _bw.write(_wl_block155Bytes, _wl_block155);
 }
            _bw.write(_wl_block156Bytes, _wl_block156);

	if(action.equals("add"))
	{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block159Bytes, _wl_block159);

	}
	else
	{

            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block159Bytes, _wl_block159);

	}
	}catch(Exception e)
		{
		out.println("Exception in Design:"+e);
		}

            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(adj_rule_ind));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(adj_perc_amt_ind));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(adj_perc_amt_value));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(drg_pmnt_diff_adj_int));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(spl_srv_pmnt_diff_adj_int));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(restrict_check));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(apprd_amt_restrict_check));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(apprd_days_restrict_check));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(cred_auth_req_yn));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(cred_auth_mand_capt_yn));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(dflt_auth_ref_as_pol_no_yn));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(policy_coverage_basis_ind));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(modify_refresh));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(restricted_YN));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(action));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(location));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(blng_grp_code_tokens));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(policy_coverage_basis_gbl_ind));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(total_keys));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(max_priority_arr));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(min_priority_arr));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(priority_arr));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(max_priority));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(encounter_date_time));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(encounter_date_aft_trunc));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(pol_validity_chk_date));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(fin_class_flag_YN));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(autoFinChk));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(oldMapKey));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(package_enabled_yn));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(checked_row));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(rec_edited_YN));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(payer_suspended_YN));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(policy_suspended_YN));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(chargeLogicYn));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(strCustomerId));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(todayFormated));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(strPlcyorEnctr));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf((String)session.getAttribute("login_user")));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(addPayerCustGrpbySetup));
            _bw.write(_wl_block216Bytes, _wl_block216);
if(action.equals("add") && location.equals("outside"))  { 
            _bw.write(_wl_block217Bytes, _wl_block217);
 if(("ALMO").equals(strCustomerId)) {	
            _bw.write(_wl_block218Bytes, _wl_block218);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
 if(strCustomerId.equals("ALMO") &&  policy_type_code.length() > 0)
{  
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(cust_group_code));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(cust_3));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(policy_type_code));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block220Bytes, _wl_block220);
} 
            _bw.write(_wl_block221Bytes, _wl_block221);

	String bean_id		= "PkgApprovalBean" ;
	String bean_name	= "eBL.PkgApprovalBean";
	PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setDetails(new ArrayList());
	
	putObjectInBean(bean_id,bean,request);	
	}
	catch(Exception e )
	{ 
		out.println("Main Exception:"+e);
	}
	finally
	{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	

            _bw.write(_wl_block222Bytes, _wl_block222);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_POLICY_DTLS.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdatetime.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchby.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.region.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.region.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_NO.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_NO.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_START_DATE.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EXPIRY_DATE.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.InitialCreditAuthorization.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.InitialCreditAuthorizationDate.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_AUTH.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_AUTH_DATE.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADJUSTMENT_RULE_INDICATOR.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AUTOMATIC.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PERC_AMOUNT_INDICATOR.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Percent.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADJUSTMENT_VALUE.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADJUSTMENT_INTERFACE_CODE.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ClaimCode.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreditAuthorisationBy.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.additionalApprovals.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageDiscount.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Dtls.label", java.lang.String .class,"key"));
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
}
