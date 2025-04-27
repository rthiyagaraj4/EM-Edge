package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import eOT.OTCommonBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.*;
import com.ehis.util.*;

public final class __commonoperdtlshdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/CommonOperDtlsHdr.jsp", 1743149020151L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordSurgeon.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\'JavaScript\' src=\'../../eOT/js/CommonOperDtlsHdr.js\'></script>\n<script language=\'JavaScript\' src=\'../../eOT/js/Hashtable.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script > var lblPreOperDiag=getLabel(\"eOT.PreOperativeDiagnosis.Label\",\"OT\");</script>\n<script type=\'text/javascript\' src=\'../../eOT/js/CheckInOutRecoveryRoom.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/HoldingArea.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/CheckInToOR.js\'></script>\n</head>\n<script language=\"javascript\">\nasync function callOperativeNotes(){\n\tvar formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n\tvar formObjDtl = document.forms[0];\n\tvar slate_user_id = formObjDtl.slate_user_id.value;\n\tvar title=encodeURIComponent(getLabel(\"eOT.NursingNotes.Label\",\"OT\"));\n\tvar facility_id = formObj.facility_id.value;//1\n\tvar patient_id = formObj.patient_id.value;//2\n\tvar episode_id = formObj.episode_id.value;//3\n\tvar patient_class = formObj.patient_class.value;//4\n\tvar encounter_id = formObj.encounter_id.value;//5\n\tvar called_from = \"OPERATIVE_NOTES\";//6\n\tvar accession_num=formObj.oper_num.value;//7\n\tvar speciality_code=formObj.oper_speciality_code.value;//8\n\tvar performed_by_ql=formObj.strUser.value;\n\tvar locn_type = \"99\";//from OPERATIVE_NOTES Locn type=NULL;\n\tvar update_mode=\"N\";\n\tvar hide_header=\"N\";\n\tvar tab_yn=\"N\";\n\tvar cntrl_mode_accession_num=\"\";\n\tif(speciality_code==\"all\")\n\t\t\tcntrl_mode_accession_num = facility_id+accession_num+\"*ALL\"+speciality_code+locn_type;\n\t\telse\n\t\t\tcntrl_mode_accession_num = facility_id+accession_num+speciality_code+locn_type;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=Operative_notes&accession_num=\"+accession_num+\"&facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&patient_class=\"+patient_class+\"&encounter_id=\"+encounter_id+\"&called_from=\"+called_from+\"&speciality_code=\"+speciality_code+\"&locn_type=\"+locn_type+\"&slate_user_id=\"+slate_user_id,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText);\n\tvar arr_spec=retVal.split(\",\");\n\tvar arr2_spec=\"\";\n\tvar note_type_value=\"\";\n\tvar note_type=\"\";\n\tvar note_type_desc=\"\";\n\tnote_type =arr_spec[0];\n\tnote_type_desc=arr_spec[1];\n\tupdate_mode=arr_spec[3];\n\taccession_num=arr_spec[4];\n\tcntrl_mode_accession_num=arr_spec[2];\n\tvar function_id=\"SPCL_NOTE\";\n\tvar event_class=\"$PHY$\";\n\tvar window_close=\"Y\";\nif(note_type !=\"\")\n{\n\tvar action_url\t=\t\"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title=\"+title+\"&note_type=\"+note_type+\"&patient_id=\"+patient_id+\"&patient_class=\"+patient_class+\"&function_id=\"+function_id+\"&event_class=\"+event_class+\"&accession_num=\"+accession_num+\"&window_close=\"+window_close+\"&ot_speciality_code=\"+speciality_code+\"&hide_header=\"+hide_header+\"&tab_yn=\"+tab_yn+\"&encounter_id=\"+encounter_id+\"&facility_id=\"+facility_id+\"&contr_mod_accession_num=\"+cntrl_mode_accession_num+\"&performed_by_ql=\"+performed_by_ql;\n\tvar title1=\"\";\n\tvar dialogHeight= \"100\";\n\tvar dialogWidth\t= \"100\";\n\tvar status = \"no\";\n\tvar arguments\t= \"\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\tsecondwindow  = await window.showModalDialog(action_url, title1, features);\n}\n}\t\n\n async function funsubmitCheckInDtls_Chkeckin_To_Or(){\n\tvar formObj = parent.frames[4].document.forms[0];\t\n\tvar order_id = parent.frames[4].document.forms[0].order_id.value;\n    \tvar checklists=parent.frames[4].document.forms[0].verify_checklist_codes.value;\n\tvar checklist_arr = checklists.split(\"##\");\n\tvar verify_checklist_codes = \"&verify_checklist_code_1=\"+checklist_arr[0];\n\tvar count=1;\n\tfor(i=1;i<checklist_arr.length;i++){\n\t\tcount++;\t\t\n\t\t//verify_checklist_codes+=verify_checklist_codes+\"&verify_checklist_code_\"+count+\"=\"+checklist_arr[i];\n\t\tverify_checklist_codes=verify_checklist_codes+\"&verify_checklist_code_\"+count+\"=\"+checklist_arr[i];//Modified Against AAKH-SCF-0478\n\t}\n\n\tvar booking_or_oper_flag = \"B\";\n\tif(order_id!=null && order_id!=\"null\" && order_id!=\"\")\n\t\tbooking_or_oper_flag = \"ORD\";\n\tvar checklist_completed_yn = formObj.checklist_completed_yn.value;\n\tvar old_checklist_user_id = (formObj.old_checklist_user_id.value).toUpperCase();\n\tvar slate_user_id = (formObj.slate_user_id.value).toUpperCase();\n\tvar disable_checklist_fields = \"N\";\n\tvar access=\"NYNNY\";\n\tif(old_checklist_user_id!=\"\" && old_checklist_user_id!=\"null\" && old_checklist_user_id!=\"NULL\"){\n\t\tif(slate_user_id.toUpperCase()!=old_checklist_user_id.toUpperCase()){\n\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\taccess=\"NNNNN\";\n\t\t}\n\t}\n\tif(checklist_completed_yn==\"Y\"){\n\t\tdisable_checklist_fields = \"disabled\"\n\t\taccess=\"NNNNN\";\n\t}\n\t//RUT-SCF-0298 [IN:044218]  Bharati start\n\tvar speciality_code=document.CommonOperDtlsHdrForm.speciality_code.value;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=verifychecklist_call_post&speciality_code=\"+speciality_code,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText); \n\tif(retVal==\"false\")\n\t{\n\t\talert(\"APP-OT0170 Speciality does not have checklist defined\");\n\t\treturn; //Added Against ARYU-SCF-0087[IN:067241]\n\t}\n\tif(retVal==\"true\" ){ //RUT-SCF-0298 [IN:044218]  Bharati End\n\tvar viewchecklist_legend = encodeURIComponent(getLabel(\"eOT.ViewCheckList.Label\",\"OT\"));\n\tvar db_param_1=\"module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access=\"+access+\"&home_required_yn=N\";\n\tvar function_string = \"&function_id=OT_CHECK_LIST\";\n\tvar db_param = db_param_1 + function_string;\n\tvar url_desc = \"VerifyCheckListMain.jsp\";\n        var url = url_desc+\"?\"+db_param+\"&called_from=OT_CHECKIN_TO_OR&patient_id=\"+formObj.patient_id.value+\"&slate_user_id=\"+slate_user_id+verify_checklist_codes+\"&checklist_codes_count=\"+count+\"&function_name=\"+viewchecklist_legend+\"&apply_flag=Y&checklist_stage=C30&pre_or_post=P&booking_or_oper_flag=\"+booking_or_oper_flag+\"&no_of_verifications=\"+formObj.no_of_verifications.value+\"&user_id=\"+slate_user_id+\"&role_id_1=\"+formObj.role_id_1.value+\"&role_id_2=\"+formObj.role_id_2.value+\"&role_id_3=\"+formObj.role_id_3.value+\"&role_id_4=\"+formObj.role_id_4.value+\"&order_id=\"+order_id+\"&booking_num=\"+formObj.booking_num.value+\"&oper_num=\"+formObj.oper_num.value+\"&disable_checklist_fields=\"+disable_checklist_fields+\"&invoked_from=CHECKINTOOR\";\t\n\t// By Chaitanya IN:044980\n\tvar retVal;\n\tvar dialogHeight = \"40\" ;\n\tvar dialogWidth  = \"52\" ;\n\tvar dialogTop    = \"200\";\n\tvar dialogLeft   = \"100\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" + dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" ;\n\tvar arguments    = \"\" ;\n\tretVal \t   = await window.showModalDialog(url, arguments, features);\n\n\tif(retVal==null)\n\t{\n\t\tvar CheckInName = encodeURIComponent(getLabel(\"eOT.CheckIntoOR.Label\",\"OT\"));\t// By Chaitanya IN:044980\n\t\tparent.parent.commontoolbarFrame.location.href=\"../../eCommon/jsp/commonToolbar.jsp?\"+db_param+\"&function_name=\"+CheckInName;\n\t}\n\telse if(retVal==\"undefined\" || retVal==\'undefined\')\n\t{\n\t}\n\telse if(retVal!=\"null\" && retVal!=\"\" && retVal!=\"Y\")\n\t{\n\t\tparent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+retVal;\n\t}\n\telse if(retVal!=\"null\" && retVal!=\"\" && retVal==\"Y\")\n\t{\n\t\tformObj.checklist_completed_yn.value = \"Y\";\n\t}\n\telse\n\t{\n\t\tvar CheckInName = encodeURIComponent(getLabel(\"eOT.CheckIntoOR.Label\",\"OT\"));\t// By Chaitanya IN:044980\n\t\tparent.parent.commontoolbarFrame.location.href=\"../../eCommon/jsp/commonToolbar.jsp?\"+db_param+\"&function_name=\"+CheckInName;\n\t\tparent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\";\n\t}\n  } //RUT-SCF-0298 [IN:044218]\n  loadToolBar();//ML-BRU-SCF-1322 [IN:048967] \n}\n//ML-BRU-SCF-1322 [IN:048967]  Bharati start\nfunction loadToolBar(){\n\tvar CheckInName = encodeURIComponent(getLabel(\"eOT.CheckIntoOR.Label\",\"OT\"));\n\tvar qrystr=\"module_id=OT&function_type=F&menu_id=26&access=NYNNN&home_required_yn=N&function_id=OT_CHECKIN_TO_OR&function_name=\"+CheckInName+\"&called_from=OT_SLATE\";\n   \tparent.parent.frames[0].location.href=\"../../eCommon/jsp/commonToolbar.jsp?\"+qrystr;\n}\n//ML-BRU-SCF-1322 [IN:048967]  Bharati end\nasync function funsubmitCheckInDtls_Chkeckout_From_Or(){\n\tvar formObj = parent.frames[4].document.CheckOutFromORForm;\t\n    var checklists=formObj.verify_checklist_codes.value;\n    var chk_params = formObj.params.value;\n\tvar no_of_verifications = formObj.no_of_verifications.value;\n\tvar checklist_stage = \"\";\n\tvar post_oper_user1_completed_yn = formObj.post_oper_user1_completed_yn.value;\n\tvar post_oper_user2_completed_yn = formObj.post_oper_user2_completed_yn.value;\n\tvar post_oper_user3_completed_yn = formObj.post_oper_user3_completed_yn.value;\n\tvar post_oper_user4_completed_yn = formObj.post_oper_user4_completed_yn.value;\n\n\tif(no_of_verifications > 0 && post_oper_user1_completed_yn==\"N\")\n\t\tchecklist_stage=\"C50\";\t\t\n\telse if(no_of_verifications > 1 && post_oper_user2_completed_yn==\"N\")\n\t\tchecklist_stage=\"C60\";\t\t\n\telse if(no_of_verifications > 2 && post_oper_user3_completed_yn==\"N\")\n\t\tchecklist_stage=\"C70\";\t\t\n\telse if(no_of_verifications > 3 && post_oper_user4_completed_yn==\"N\")\n\t\tchecklist_stage=\"C80\";\t\t\n\n\tvar order_id = formObj.order_id.value;\n\tvar checklist_arr = checklists.split(\"##\");\n\tvar verify_checklist_codes = \"&verify_checklist_code_1=\"+checklist_arr[0];\n\tvar count=1;\n\tfor(i=1;i<checklist_arr.length;i++){\n\t\tcount++;\t\t\n\t\t//verify_checklist_codes+=verify_checklist_codes+\"&verify_checklist_code_\"+count+\"=\"+checklist_arr[i];\n\t\tverify_checklist_codes=verify_checklist_codes+\"&verify_checklist_code_\"+count+\"=\"+checklist_arr[i]; //Modified Against AAKH-SCF-0478\n\t}\n\tvar booking_or_oper_flag = \"B\";\n\tif(order_id!=null && order_id!=\"null\" && order_id!=\"\")\n\t\t\tbooking_or_oper_flag = \"ORD\";\n\n\tvar old_post_oper_user1_id = (formObj.old_post_oper_user1_id.value).toUpperCase();\n\tvar old_post_oper_user2_id = (formObj.old_post_oper_user2_id.value).toUpperCase();\n\tvar old_post_oper_user3_id = (formObj.old_post_oper_user3_id.value).toUpperCase();\n\tvar old_post_oper_user4_id = (formObj.old_post_oper_user4_id.value).toUpperCase();\n\n\tvar slate_user_id = (formObj.slate_user_id.value).toUpperCase();\n\t";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="var disable_checklist_fields = \"N\";\n\tvar access=\"NYNNY\";\n\tif(checklist_stage==\"C50\"){\n\t\tif(old_post_oper_user1_id!=null && old_post_oper_user1_id!=\"\" && old_post_oper_user1_id!=\"null\" && old_post_oper_user1_id!=\"NULL\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user1_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNN\";\n\t\t\t}\n\t\t}\n\t}else if(checklist_stage==\"C60\"){\n\t\tif(old_post_oper_user2_id!=null && old_post_oper_user2_id!=\"\" && old_post_oper_user2_id!=\"null\" && old_post_oper_user2_id!=\"NULL\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user2_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNN\";\n\t\t\t}\n\t\t}\n\t}\n\tif(checklist_stage==\"C70\"){\n\t\tif(old_post_oper_user3_id!=null && old_post_oper_user3_id!=\"\" && old_post_oper_user3_id!=\"null\" && old_post_oper_user3_id!=\"NULL\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user3_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNN\";\n\t\t\t}\n\t\t}\n\t}\n\tif(checklist_stage==\"C80\"){\n\t\tif(old_post_oper_user4_id!=null && old_post_oper_user4_id!=\"\" && old_post_oper_user4_id!=\"null\" && old_post_oper_user4_id!=\"null\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user4_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNN\";\n\t\t\t}\n\t\t}\n\t}\n\n\tvar checklist_completed_yn = formObj.checklist_completed_yn.value;\n\tif(checklist_completed_yn==\"Y\"){\n\t\tdisable_checklist_fields = \"disabled\"\n\t\taccess=\"NNNNN\";\n\t}\n\tvar db_param_1=\"module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access=\"+access+\"&home_required_yn=N\";\n\tvar function_string = \"&function_id=OT_CHECK_LIST&function_name=Verify Checklist\";\n\tvar db_param = db_param_1 + function_string;\n\tvar oper_num=document.forms[0].oper_num.value;\n\tvar url_desc = \"VerifyCheckListMain.jsp\";\n\t//Maheshwaran k added \'apply_flag\' for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013\n\tvar url = url_desc+\"?\"+db_param+\"&called_from=OT_SLATE&patient_id=\"+formObj.patient_id.value+\"&slate_user_id=\"+slate_user_id+verify_checklist_codes+\"&checklist_codes_count=\"+count+\"&checklist_stage=\"+checklist_stage+\"&apply_flag=Y&pre_or_post=O&booking_or_oper_flag=\"+booking_or_oper_flag+\"&no_of_verifications=\"+no_of_verifications+\"&user_id=\"+slate_user_id+\"&role_id_1=\"+formObj.role_id_1.value+\"&role_id_2=\"+formObj.role_id_2.value+\"&role_id_3=\"+formObj.role_id_3.value+\"&role_id_4=\"+formObj.role_id_4.value+\"&order_id=\"+order_id+\"&booking_num=\"+formObj.booking_num.value+\"&oper_num=\"+oper_num+\"&disable_checklist_fields=\"+disable_checklist_fields;\n\n\tvar retVal;\n\tvar dialogHeight = \"94\" ;\n\tvar dialogWidth  = \"445\" ;\n\tvar dialogTop    = \"790\";\n\tvar dialogLeft   = \"100\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" + dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" ;\n\tvar arguments    = \"\" ;\n\tretVal \t   = await window.showModalDialog(url, arguments, features);\n\tif(retVal==\"\"){\n\t\tparent.parent.frames[0].location.href=\"../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=26&access=NYNNY&home_required_yn=N&function_id=OT_CHECKOUT_FROM_OR&function_name=Check-Out%20From%20OR&called_from=OT_SLATE\";\n\t}\n\tif(retVal==null){\n\t}else if(retVal==\"undefined\" || retVal==\'undefined\'){\n\t}else if(retVal!=\"null\" && retVal!=\"\" && retVal!=\"Y\"){\n\t}else if(retVal!=\"null\" && retVal!=\"\" && retVal==\"Y\"){\n\t\tif(no_of_verifications > 0 && checklist_stage==\"C50\" ){\n\t\t\tformObj.post_oper_user1_completed_yn.value=\"Y\";\n\t\t\tformObj.old_post_oper_user1_id.value = slate_user_id;\n\t\t}else if(no_of_verifications > 1 && checklist_stage==\"C60\" ){\n\t\t\tformObj.post_oper_user2_completed_yn.value=\"Y\";\n\t\t\tformObj.old_post_oper_user2_id.value = slate_user_id;\n\t\t}else if(no_of_verifications > 2 && checklist_stage==\"C70\" ){\n\t\t\tformObj.post_oper_user3_completed_yn.value=\"Y\";\n\t\t\tformObj.old_post_oper_user3_id.value = slate_user_id;\n\t\t}else if(no_of_verifications > 3 && checklist_stage==\"C80\" ){\n\t\t\tformObj.post_oper_user4_completed_yn.value=\"Y\";\t\t\n\t\t\tformObj.old_post_oper_user4_id.value = slate_user_id;\n\t\t}\n\n\t\tif(no_of_verifications==1 && checklist_stage==\"C50\")\n\t\t\tformObj.checklist_completed_yn.value = \"Y\";\n\t\telse if(no_of_verifications==2 && checklist_stage==\"C60\")\n\t\t\tformObj.checklist_completed_yn.value = \"Y\";\n\t\telse if(no_of_verifications==3 && checklist_stage==\"C70\")\n\t\t\tformObj.checklist_completed_yn.value = \"Y\";\n\t\telse if(no_of_verifications==4 && checklist_stage==\"C80\")\n\t\t\tformObj.checklist_completed_yn.value = \"Y\";\n\t}else\n\t\tparent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\";\n}\n\nasync function funsubmitCheckInDtls_Checkout_Reco(){\n\tvar formObj = parent.frames[4].document.CheckInToRecoveryRoomForm;\t\n\tvar checklists=formObj.verify_checklist_codes.value;\n\tvar chk_params = formObj.params.value;\n\tvar no_of_verifications = formObj.no_of_verifications.value;\n  \n\tvar checklist_stage = \"\";\n\tvar post_oper_user1_completed_yn = formObj.post_oper_user1_completed_yn.value;\n\tvar post_oper_user2_completed_yn = formObj.post_oper_user2_completed_yn.value;\n\tvar post_oper_user3_completed_yn = formObj.post_oper_user3_completed_yn.value;\n\tvar post_oper_user4_completed_yn = formObj.post_oper_user4_completed_yn.value;\n\n\tif(no_of_verifications > 0 && post_oper_user1_completed_yn==\"N\")\n\t\tchecklist_stage=\"C50\";\t\t\n\telse if(no_of_verifications > 1 && post_oper_user2_completed_yn==\"N\")\n\t\tchecklist_stage=\"C60\";\t\t\n\telse if(no_of_verifications > 2 && post_oper_user3_completed_yn==\"N\")\n\t\tchecklist_stage=\"C70\";\t\t\n\telse if(no_of_verifications > 3 && post_oper_user4_completed_yn==\"N\")\n\t\tchecklist_stage=\"C80\";\t\t\n\n\tvar order_id = formObj.order_id.value;\n\tvar checklist_arr = checklists.split(\"##\");\n\tvar verify_checklist_codes = \"&verify_checklist_code_1=\"+checklist_arr[0];\n\tvar count=1;\n\tfor(i=1;i<checklist_arr.length;i++){\n\t\tcount++;\t\t\n\t\t//verify_checklist_codes+=verify_checklist_codes+\"&verify_checklist_code_\"+count+\"=\"+checklist_arr[i];\n\t\tverify_checklist_codes=verify_checklist_codes+\"&verify_checklist_code_\"+count+\"=\"+checklist_arr[i]; //Modified Against AAKH-SCF-0478\n\t}\n\tvar booking_or_oper_flag = \"B\";\n\tif(order_id!=null && order_id!=\"null\" && order_id!=\"\")\n\t\t\tbooking_or_oper_flag = \"ORD\";\n\n\tvar old_post_oper_user1_id = (formObj.old_post_oper_user1_id.value).toUpperCase();\n\tvar old_post_oper_user2_id = (formObj.old_post_oper_user2_id.value).toUpperCase();\n\tvar old_post_oper_user3_id = (formObj.old_post_oper_user3_id.value).toUpperCase();\n\tvar old_post_oper_user4_id = (formObj.old_post_oper_user4_id.value).toUpperCase();\n\n\tvar slate_user_id = (formObj.slate_user_id.value).toUpperCase();\n\tvar disable_checklist_fields = \"N\";\n\tvar access=\"NYNNY\";\n\tif(checklist_stage==\"C50\"){\n\t\tif(old_post_oper_user1_id!=null && old_post_oper_user1_id!=\"\" && old_post_oper_user1_id!=\"null\" && old_post_oper_user1_id!=\"NULL\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user1_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNN\";\n\t\t\t}\n\t\t}\n\t}else if(checklist_stage==\"C60\"){\n\t\tif(old_post_oper_user2_id!=null && old_post_oper_user2_id!=\"\" && old_post_oper_user2_id!=\"null\" && old_post_oper_user2_id!=\"NULL\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user2_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNN\";\n\t\t\t}\n\t\t}\n\t}\n\tif(checklist_stage==\"C70\"){\n\t\tif(old_post_oper_user3_id!=null && old_post_oper_user3_id!=\"\" && old_post_oper_user3_id!=\"null\" && old_post_oper_user3_id!=\"NULL\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user3_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNN\";\n\t\t\t}\n\t\t}\n\t}\n\tif(checklist_stage==\"C80\"){\n\t\tif(old_post_oper_user4_id!=null && old_post_oper_user4_id!=\"\" && old_post_oper_user4_id!=\"null\" && old_post_oper_user4_id!=\"null\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user4_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNN\";\n\t\t\t}\n\t\t}\n\t}\n\n\tvar checklist_completed_yn = formObj.checklist_completed_yn.value;\n\tif(checklist_completed_yn==\"Y\"){\n\t\tdisable_checklist_fields = \"disabled\"\n\t\taccess=\"NNNNN\";\n\t}\n\tvar speciality_code=document.CommonOperDtlsHdrForm.speciality_code.value;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=verifychecklist_call_post&speciality_code=\"+speciality_code,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText); \n\t//Added by Daniel against RUT-SCF-0262 [IN:039404]\n\tif(retVal==\"false\" )\n\t{\n\t\talert(\"APP-OT0170 Speciality does not have checklist defined\");\n\t}\t\n\t//Added by Daniel against RUT-SCF-0262 [IN:039404]\n\tif(retVal==\"true\" ){\n\tvar viewchecklist_legend = encodeURIComponent(getLabel(\"eOT.ViewCheckList.Label\",\"OT\"));\t\n\tvar db_param_1=\"module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access=\"+access+\"&home_required_yn=N\";\n\tvar function_string = \"&function_id=OT_CHECK_LIST&function_name=\"+viewchecklist_legend;\n\tvar db_param = db_param_1 + function_string;\n\tvar oper_num=document.forms[0].oper_num.value;\n\tvar url_desc = \"VerifyCheckListMain.jsp\";\n\t//Maheshwaran k added \'apply_flag\' for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013\n\tvar url = url_desc+\"?\"+db_param+\"&called_from=OT_SLATE&patient_id=\"+formObj.patient_id.value+\"&slate_user_id=\"+slate_user_id+verify_checklist_codes+\"&checklist_codes_count=\"+count+\"&checklist_stage=\"+checklist_stage+\"&apply_flag=Y&pre_or_post=O&booking_or_oper_flag=\"+booking_or_oper_flag+\"&no_of_verifications=\"+no_of_verifications+\"&user_id=\"+slate_user_id+\"&role_id_1=\"+formObj.role_id_1.value+\"&role_id_2=\"+formObj.role_id_2.value+\"&role_id_3=\"+formObj.role_id_3.value+\"&role_id_4=\"+formObj.role_id_4.value+\"&order_id=\"+order_id+\"&booking_num=\"+formObj.booking_num.value+\"&oper_num=\"+oper_num+\"&disable_checklist_fields=\"+disable_checklist_fields;\n\n\tvar retVal;\n\tvar dialogHeight = \"94\" ;\n\tvar dialogWidth  = \"445\" ;\n\tvar dialogTop    = \"790\";\n\tvar dialogLeft   = \"100\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" + dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" ;\n\n\tvar arguments    = \"\" ;\n\tretVal \t   = await window.showModalDialog(url, arguments, features);\n\t\n\tif(retVal==null || retVal==\"\" ){\n\t}else if(retVal==\"undefined\" || retVal==\'undefined\'){\n\t}else if(retVal!=\"null\" && retVal!=\"\" && retVal!=\"Y\"){\n\t\tparent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+retVal;\n\t\tparent.parent.document.frames.commontoolbarFrame.location.href = \"../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=26&access=NYNNY&home_required_yn=N&function_id=OT_CHECKOUT_FROM_OR&function_name=Check-Out%20From%20OR&called_from=OT_SLATE\";\n\t}else if(retVal!";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block7_2 ="=\"null\" && retVal!=\"\" && retVal==\"Y\"){\n\t\tif(no_of_verifications > 0 && checklist_stage==\"C50\" ){\n\t\t\tformObj.post_oper_user1_completed_yn.value=\"Y\";\n\t\t\tformObj.old_post_oper_user1_id.value = slate_user_id;\n\t\t}else if(no_of_verifications > 1 && checklist_stage==\"C60\" ){\n\t\t\tformObj.post_oper_user2_completed_yn.value=\"Y\";\n\t\t\tformObj.old_post_oper_user2_id.value = slate_user_id;\n\t\t}else if(no_of_verifications > 2 && checklist_stage==\"C70\" ){\n\t\t\tformObj.post_oper_user3_completed_yn.value=\"Y\";\n\t\t\tformObj.old_post_oper_user3_id.value = slate_user_id;\n\t\t}else if(no_of_verifications > 3 && checklist_stage==\"C80\" ){\n\t\t\tformObj.post_oper_user4_completed_yn.value=\"Y\";\t\t\n\t\t\tformObj.old_post_oper_user4_id.value = slate_user_id;\n\t\t}\n\n\t\tif(no_of_verifications==1 && checklist_stage==\"C50\")\n\t\t\tformObj.checklist_completed_yn.value = \"Y\";\n\t\telse if(no_of_verifications==2 && checklist_stage==\"C60\")\n\t\t\tformObj.checklist_completed_yn.value = \"Y\";\n\t\telse if(no_of_verifications==3 && checklist_stage==\"C70\")\n\t\t\tformObj.checklist_completed_yn.value = \"Y\";\n\t\telse if(no_of_verifications==4 && checklist_stage==\"C80\")\n\t\t\tformObj.checklist_completed_yn.value = \"Y\";\n\t}else\n\t\tparent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\";\n}\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7_2Bytes = _getBytes( _wl_block7_2 );

    private final static java.lang.String  _wl_block8 ="\n<body onLoad=\"setInitialValue(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');assignDiagnosistxt();docDisableEnable();\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<body onLoad=\"setInitialValue(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');assignDiagnosistxt(); callBillingProcedure();\" >\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');funRecoveryNotes();\" >\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');callRecordNotes();\" >\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\');\" >\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n<form name=\"CommonOperDtlsHdrForm\" id=\"CommonOperDtlsHdrForm\">\n<table border=\'0\' cellpadding=3 cellspacing=\'0\' width=\'100%\' align=\'center\'>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<tr>\n<!-- Added for PMG2017-SS-CRF-0001-US001 Starts -->\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<td class=\"label\" width=\'25%\' >\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<td class=\"fields\" width=\'25%\'>\n\t\t<input type=\'hidden\' name=\'anaesthesia_code\' id=\'anaesthesia_code\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' >\n\t\t<input type=\'text\' class=\"fields\" name=\'anaesthesia_desc\' id=\'anaesthesia_desc\' size=\'15\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'  disabled>\n\t</td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\n\t<td>\n\t\t<input type=\"hidden\"  name=\"anaesthesia_code\" id=\"anaesthesia_code\" id=\"anaesthesia_code\"  size=\'14\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t<input type=\"text\"  name=\"anaesthesia_desc\" id=\"anaesthesia_desc\" size=\'28\' onblur=\'if(this.value!=\"\")callAnaesthesia1(this); else clearDesc(this);\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n\t\t<input type=\"button\" class=\"button\" name=\"generic_search\" id=\"generic_search\" value=\"?\" onclick=\"callAnaesthesia1(anaesthesia_desc);\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<!-- Added for PMG2017-SS-CRF-0001-US001 Ends -->\n\t<td class=\"label\" width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t</td>\n\t<td class=\"fields\" width=\'25%\'>\n\t\t<input type=\'hidden\' name=\'anesthestist_code\' id=\'anesthestist_code\'  value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t<input type=\'text\' name=\'anesthestist_desc\' id=\'anesthestist_desc\' size=\'15\'  value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' disabled>\n\t</td>\n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<td class=\"label\" width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" </td>\n\t<td class=\"fields\"  width=\'25%\'>\n\t\t<input type=\'hidden\' name=\'theatre_code\' id=\'theatre_code\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' >\n\t\t<input type=\'text\' class=\"fields\" name=\'theatre_desc\' id=\'theatre_desc\' size=\'15\'  value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' disabled>\n\t</td>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \n\t</td>\n\t<td class=\"fields\" width=\'25%\'>\n\t\t<input type=\'hidden\' name=\'theatre_code\' id=\'theatre_code\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<input type=\'text\' name=\'theatre_desc\' id=\'theatre_desc\' size=\'15\'  value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" </td>\n\t<td class=\"fields\" width=\'25%\'>\n\t\t<select name=\'doc_level\' id=\'doc_level\' onChange=\'changeSpeciality();\' >\n\t\t\t<option value=\'IS\'>\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\t\t\n\t\t\t<option value=\'AS\'>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t</option>\n\t\t</select>\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n<tr>\n\t<td width=\'35%\'></td><!--changed  by Yadav for 13827 -->\t\n\t<td class=\"fields\" align=\"right\" colspan=\'4\'> <!--changed  by Yadav for 13827 -->\t\n\t\t<a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,\'500\');\">\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</a>\t&nbsp;\t&nbsp;\n\n\t\t<a class=\"gridLink\" href=\"javascript:callPostOPDiagnosis();\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</a>\t&nbsp;\t&nbsp;\n\t\t<a class=\"gridLink\" href=\"javascript:callpatientHistory();\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</a>&nbsp;\t&nbsp;\n\n ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<a class=\"gridLink\" href=\"javascript:funSurgeryAddlChargesView(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\',\'role_pract_id\');\">\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</a>\t\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n    </td>\t\t\t\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n <tr>\n\n <td width=\'30%\'></td> \n\t<td align=\'right\' COLSPAN=\'3\'>\n\t    <a class=\"gridLink\" id=\"operative_records\" href=\"javascript:callOperativeNotes();\">\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</a> \n\t\t<a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,\'500\');\">\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\n\t&nbsp;&nbsp;&nbsp;<a class=\"gridLink\" id=\'sl_intfc_vw\' style=\'visibility:hidden\' href=\"javascript:callOTSalesWindowview();\">\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t&nbsp;&nbsp;&nbsp;<a class=\"gridLink\" id=\'sl_intfc_vw\' style=\'visibility:hidden\' href=\"javascript:callOTSalesWindowview();\">\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</a>\n\t\t</a>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t<a class=\"gridLink\" id=\'sl_intfc_vw\'>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\n\n\t\t</a>\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n<tr>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t<td width=\'25%\'>\n\t\t</td>\n\t\t<td width=\'25%\'>\n\t\t</td>\n\n\t\t<td class=\"label\" width=\'50%\' colspan=\'3\' >\n\t\t\t<!-- <a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag);\"> -->\n\t\t<a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,\'500\');\">\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</a>\n\t    &nbsp; &nbsp;\n\t<!-- Added by MuthuN against CRF - 011 on 2/7/2013 -->\n\t\t<a class=\'gridLink\' href=\"javascript:callPreOPDiagnosis();\">\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</a>&nbsp; &nbsp;\n\t<!-- Added by MuthuN against CRF - 011 on 2/7/2013 -->\n\t\t\t\n\t\t<a class=\"gridLink\" href=\"javascript:callPostOPDiagnosis();\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</a>\n\t\t &nbsp; &nbsp;\n\n\t\t<a class=\"gridLink\" href=\"javascript:callpatientHistory();\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</a>\n\t</td>\t\n</tr>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n<tr>\t\n\t<td align=\"right\" colspan=\'3\'>\n\t\t<a class=\"gridLink\" id=\"operative_records\" href=\"javascript:callOperativeNotes();\">\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</a>&nbsp;&nbsp;\n\t\t<a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,\'500\');\">\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</a>\t\n\t\t&nbsp;&nbsp;\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t <a class=\"gridLink\" id=\'sl_intfc\' style=\'visibility:hidden\' href=\"javascript:callOTSalesWindow();\">\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</a>&nbsp;&nbsp;\n\t\t<a class=\"gridLink\" id=\'sl_intfc_vw\' style=\'visibility:hidden\' href=\"javascript:callOTSalesWindowview();\">\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</a>\n\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t <a class=\"gridLink\" id=\'sl_intfc\' >&nbsp;&nbsp;\n\t\t<a class=\"gridLink\" id=\'sl_intfc_vw\' style=\'visibility:hidden\' href=\"javascript:callOTSalesWindowview();\">\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</a>\n\t\t</a>\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<a class=\"gridLink\" id=\'sl_intfc\' ></a>\n\t\t<a class=\"gridLink\" id=\'sl_intfc_vw\'></a>\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t<td class=\"label\" width=\'25%\' colspan=\'3\'>\n\t<!-- <a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag);\">  -->\n\t <a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,\'500\');\"> \n\t ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</a>\n\t</td>\n\n</tr>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\n\t<td class=\"label\" width=\'25%\' colspan=\'3\'>\n\t<a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,\'500\');\"> \n\t ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</a>\n\t &nbsp;&nbsp\n\t <a class=\"gridLink\" href=\"javascript:callRecordVitals();\" id=\"record_vitals1\" \n\tstyle=\'visible:inline;\' > <!-- Modified by Muthukumar against SRR20056-SCF-7683 on 21-06-2011 -->\n\t &nbsp;&nbsp\n\t ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</a>\n\t</td>\t\n\t<td>\n\t</td>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n  <td class=\"label\" width=\'25%\' colspan=\'2\'>\n     <a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,\'500\');\"> \n\t ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</a>\n\t &nbsp;&nbsp\n\t <a class=\"gridLink\" href=\"javascript:funsubmitCheckInDtls_Checkout_Reco();\"> \n\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</a>\n </td>\n\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n    \n\t<td class=\"label\" width=\'25%\' colspan=\'3\'>\n\t <a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,\'500\');\"> \n\t ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</a>\n\t&nbsp;&nbsp\t\n\t<a class=\"gridLink\" href=\"javascript:callRecordVitals_holidingarea();\" id=\"record_vitals\" style=\'visible:inline;\'> \n\t ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a>\n\t</td>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n  <td class=\"label\" width=\'25%\' colspan=\'2\'>\n   <a class=\"gridLink\" href=\"javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,\'500\');\"> \n\t ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</a>\n    &nbsp;&nbsp;\n\t<a class=\"gridLink\" href=\"javascript:funsubmitCheckInDtls_Chkeckin_To_Or();\" > \n\t ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</a>\n  </td>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</a>\n    &nbsp;&nbsp;\n\t<a class=\"gridLink\" href=\"javascript:funsubmitCheckInDtls_Chkeckout_From_Or();\" > \n\t ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t<tr>\n\t<td class=\"label\" width=\'25%\'>\n\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t<td class=\"fields\">\n\t\t\t<select name=\"note_type_val\" id=\"note_type_val\"  onchange=\"onselectnotetype(this)\">\n\t\t\t<option value=\"\" selected>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</option>\n\t\t\t</select>\n\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t<tr>\n\t<td class=\"label\" width=\'25%\' >\n\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\n\t<td class=\"fields\">\t\t\n\t\t\t<select name=\"note_type_val\" id=\"note_type_val\"  onchange=\"onselectnotetypeholding(this)\">\n\t\t\t<option value=\"\" selected>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\n</table>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' size=\'22\'   value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' disabled>\n<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' size=\'25\'    value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' disabled>\n<input type=\'hidden\' name=\'sex\' id=\'sex\' size=\'10\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' disabled>\n<input type=\'hidden\' name=\'date_of_birth\' id=\'date_of_birth\' size=\'10\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' disabled> \n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' size=\'15\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' disabled>\n<input type=\'hidden\' name=\'nursing_unit_desc\' id=\'nursing_unit_desc\' size=\'12\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' disabled>\n<input type=\'hidden\' name=\'surgeon_code\' id=\'surgeon_code\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n<input type=\'hidden\' name=\'surgeon_desc\' id=\'surgeon_desc\' size=\'15\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' disabled>\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' >\n<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' >\n<input type=\'hidden\' name=\'discr_msr_id\' id=\'discr_msr_id\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' >\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' >\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' >\n<input type=\'hidden\' name=\'document_level\' id=\'document_level\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' >\n<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' >\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' >\n<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' >\n<input type=\'hidden\' name=\'oper_speciality_code\' id=\'oper_speciality_code\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' >\n<input type=\'hidden\' name=\'surgeon_doc_comp_yn\' id=\'surgeon_doc_comp_yn\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' >\n<input type=\'hidden\' name=\'nursing_doc_comp_yn\' id=\'nursing_doc_comp_yn\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' >\n<input type=\'hidden\' name=\'source_type\' id=\'source_type\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n<input type=\'hidden\' name=\'source_code\' id=\'source_code\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n<input type=\'hidden\' name=\"diagnosis\" id=\"diagnosis\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n<input type=\'hidden\' name=\"pre_oper_diag\" id=\"pre_oper_diag\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n<input type=\'hidden\' name=\'booking_num\' id=\'booking_num\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' >\n<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' >\n<input type=\'hidden\' name=\'contr_mod_accession_num\' id=\'contr_mod_accession_num\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n<input type=\'hidden\' name=\'recovery_room_code\' id=\'recovery_room_code\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' >\n<input type=\'hidden\' name=\'rec_start_time\' id=\'rec_start_time\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' >\n<input type=\'hidden\' name=\'rec_end_time\' id=\'rec_end_time\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' >\n<input type=\'hidden\' name=\'transfer_to\' id=\'transfer_to\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' >\n<input type=\'hidden\' name=\'transfer_ward_code\' id=\'transfer_ward_code\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' >\n<input type=\'hidden\' name=\'transfer_status\' id=\'transfer_status\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' >\n<input type=\'hidden\' name=\'oper_date\' id=\'oper_date\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' >\n<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' >\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n<input type=\'hidden\' name=\'storeCode\' id=\'storeCode\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n<input type=\'hidden\' name=\'practitioner_type\' id=\'practitioner_type\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n<input type=\'hidden\' name=\'diag_code_scheme\' id=\'diag_code_scheme\' value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n<input type=\'hidden\' name=\'bill_interface_flag_yn\' id=\'bill_interface_flag_yn\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n<input type=\'hidden\' name=\'bill_sub_services_yn\' id=\'bill_sub_services_yn\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n<input type=\'hidden\' name=\'trfr_to_ot_flag\' id=\'trfr_to_ot_flag\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n<input type=\'hidden\' name=\'st_interface_flag\' id=\'st_interface_flag\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n<input type=\'hidden\' name=\'p_ord_practitioner_id\' id=\'p_ord_practitioner_id\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n<input type=\'hidden\' name=\'chk_val\' id=\'chk_val\' value=\'\'>\n<input type=\'hidden\' name=\'row_length\' id=\'row_length\' value=\'\'>\n<input type=\'hidden\' name=\'note_type\' id=\'note_type\' value=\'\'>\n<input type=\'hidden\' name=\'update_mode\' id=\'update_mode\' value=\'\'>\n<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\'\'>\n<input type=\'hidden\' name=\'strUser\' id=\'strUser\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n<input type=\'hidden\' name=\'isRecordAnes\' id=\'isRecordAnes\' value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t<SCRIPT>loadToFrame()</SCRIPT>\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t<SCRIPT>loadToSecondFrame()</SCRIPT>\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String tab = checkForNull(request.getParameter("tab")); 
	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id = (String) session.getAttribute("facility_id");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String recovery_in_out_flag = checkForNull(request.getParameter("recovery_in_out_flag"));
	String function_id = checkForNull(request.getParameter("function_id"));
	System.err.println("17,function_id=="+function_id);
	//Added below slate_user_id_disp on 1/18/2011 by Anitha
	String slate_user_id_disp = checkForNull(request.getParameter("slate_user_id")).toUpperCase();
	if(slate_user_id_disp.equals("")){
		slate_user_id_disp=	(String)session.getValue("login_user");
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            _bw.write(_wl_block7_2Bytes, _wl_block7_2);
 
	String empty = "".intern();
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean common_bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	String params = request.getQueryString();
	String trfr_to_ot_flag = checkForNull(request.getParameter("trfr_to_ot_flag"));
	String bill_flag = checkForNull(request.getParameter("bill_flag"));
	String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String document_level_yn = checkForNull(request.getParameter("document_level_yn"));
	String oper_num =  checkForNull(request.getParameter("oper_num"));
	String order_id =  checkForNull(request.getParameter("order_id"));
	String storeCode =  checkForNull(request.getParameter("storeCode"));
	String st_interface_flag =  checkForNull(request.getParameter("st_interface_flag"));
	String consumable_entry_cmp_yn =  checkForNull(request.getParameter("consumable_entry_cmp_yn"));
	String rec_packs_in_nurs_notes_yn =  checkForNull(request.getParameter("rec_packs_in_nurs_notes_yn"));
	String operation_sub_services_yn =  checkForNull(request.getParameter("operation_sub_services_yn"));

	String bill_interface_flag_yn = checkForNull(request.getParameter("bill_interface_flag_yn"));//newly added by rajesh on 12/08/08
	String bill_sub_services_yn = checkForNull(request.getParameter("bill_sub_services_yn"));//newly added by rajesh on 12/08/08
	if(bill_flag.equals("false"))
	{
		bill_interface_flag_yn="N";
		bill_sub_services_yn="N";
	}

	ArrayList patient_codes = new ArrayList();
	ArrayList nursing_unit = new ArrayList();
	String booking_start_time="",encounter_id="",oper_speciality_code="",care_locn_type="",care_locn_code="",speciality_desc="",order_catalog="",str_order_catalog_code="",surgeon_desc="",surgeon_code="",practitioner_type="",diag_code_scheme="",anesthetist_code="",anesthetist_desc="",theatre_desc="",patient_name="",booking_num="",patient_id="",episode_id="",date_of_birth="",sex="",ward_code="",oper_room_code="",nursing_unit_desc="",doc_level="",patient_class="",episode_type="",discr_msr_id ="",disable_flag="",source_type="",source_code="",post_oper_diag="",pre_oper_diag="",anesthesia_code="",anesthesia_desc="",contr_mod_accession_num = "",rec_start_time="",rec_end_time="",transfer_to = "",transfer_ward_code="",transfer_status="",oper_date="",visit_id="",recovery_room_code="",p_ord_practitioner_id="";
	String strUser = "";

	patient_codes = common_bean.getPatientDtlCodes(oper_num);
	if(patient_codes!=null && patient_codes.size()>0){
		patient_id = (String) patient_codes.get(0); //0 patient_id
		patient_id = checkForNull(patient_id);
		episode_id = (String) patient_codes.get(1); //1 episode_id
		episode_id = checkForNull(episode_id);
		encounter_id =	(String) patient_codes.get(2); //2  encounter_id
		encounter_id = checkForNull(encounter_id);
		ward_code =	(String) patient_codes.get(3); //3  ward_code
		ward_code = checkForNull(ward_code);
		oper_room_code = (String) patient_codes.get(4); //4  oper_room_code
		oper_room_code = checkForNull(oper_room_code);
		booking_num = (String) patient_codes.get(5); //5  booking_num
		booking_num = checkForNull(booking_num);
		booking_start_time = common_bean.getBookingStartTime(booking_num);
		booking_start_time = checkForNull(booking_start_time);
		surgeon_code = (String) patient_codes.get(6); //6  surgeon_code
		surgeon_code = checkForNull(surgeon_code);
		anesthetist_code = (String) patient_codes.get(7); //7 anesthetist_code
		anesthetist_code = checkForNull(anesthetist_code);
		doc_level = (String) patient_codes.get(8);//documentation_level
		doc_level = checkForNull(doc_level);
		patient_class = (String) patient_codes.get(9); //patient_class
		patient_class = checkForNull(patient_class);
		episode_type = (String) patient_codes.get(10); // episode_type
		episode_type = checkForNull(episode_type);
		source_type = (String) patient_codes.get(11);
		source_type = checkForNull(source_type);  
		source_code = (String) patient_codes.get(12);
		source_code = checkForNull(source_code);
		post_oper_diag = (String) patient_codes.get(13);
		post_oper_diag= checkForNull(post_oper_diag);
		anesthesia_code= (String) patient_codes.get(14);
		anesthesia_code= checkForNull(anesthesia_code);
		oper_speciality_code = (String) patient_codes.get(15);
		oper_speciality_code= checkForNull(oper_speciality_code);
		common_bean.setSpecialityCodeForNotes(oper_speciality_code);
		pre_oper_diag = (String) patient_codes.get(16);
		pre_oper_diag= checkForNull(pre_oper_diag);
		rec_start_time = checkForNull((String) patient_codes.get(17));
		rec_end_time = checkForNull((String) patient_codes.get(18));
		transfer_to = checkForNull((String) patient_codes.get(19));
		transfer_ward_code = checkForNull((String) patient_codes.get(20));
		transfer_status = checkForNull((String) patient_codes.get(21));
		oper_date = checkForNull((String) patient_codes.get(22));
		visit_id = checkForNull((String) patient_codes.get(23));
		recovery_room_code = checkForNull((String) patient_codes.get(24));
	}

	surgeon_desc = common_bean.getSurgeonDesc(surgeon_code);
	anesthetist_desc = common_bean.getAnaesthetistDesc(anesthetist_code);
	anesthetist_desc=checkForNull(anesthetist_desc);
	anesthesia_desc = common_bean.getAnaesthesiaDesc(anesthesia_code);
	theatre_desc = common_bean.getTheatreDesc(oper_room_code);
	speciality_desc = common_bean.getSpecialityDesc(oper_speciality_code);
	nursing_unit = common_bean.getNursingUnitCode(patient_id,encounter_id);
	if(nursing_unit!=null && nursing_unit.size()>0){
		  care_locn_type= (String) nursing_unit.get(0); //assign_care_locn_type
		  care_locn_code = (String) nursing_unit.get(1); //assign_care_locn_code
		  nursing_unit_desc =  common_bean.getNursingUnitDesc(care_locn_code);
	}
	discr_msr_id = common_bean.getDISCR_MSR_ID(oper_speciality_code);
	if( surgeon_doc_comp_yn.equals("Y") || nursing_doc_comp_yn.equals("Y") )
		disable_flag="disabled";
	else 
		disable_flag=empty;

	//contr_mod_accession_num=facility_id+oper_num+oper_speciality_code+"30";
	if(doc_level.equalsIgnoreCase("AS"))
		contr_mod_accession_num = facility_id+oper_num+"*ALL"+"30";
	else
		contr_mod_accession_num = facility_id+oper_num+oper_speciality_code+"30";

            _bw.write(_wl_block2Bytes, _wl_block2);

	if( document_level_yn.equals("Y") &&(tab.equals("record_surgeon")||tab.equals("record_nursing")) ){ 

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block9Bytes, _wl_block9);

	}else if(tab.equals("record_surgeon")){

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block11Bytes, _wl_block11);

	}else if(recovery_in_out_flag.equals("CHECK_IN_RECO")){

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}else if(("OT_HOLDING_AREA").equals(function_id)) {

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}else{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}

            _bw.write(_wl_block15Bytes, _wl_block15);
	
	Connection con=null;
	PreparedStatement stmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rset_one=null;
	try
	{
		con=ConnectionManager.getConnection(request);
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
					
		String sql_phy_id="SELECT ORD_PRACT_ID from or_order where order_id='"+order_id+"'";
		pstmt1=con.prepareStatement(sql_phy_id);
		rset_one=pstmt1.executeQuery();
		if(rset_one !=null && rset_one.next())
		{
			p_ord_practitioner_id =rset_one.getString("ORD_PRACT_ID");
			if(p_ord_practitioner_id ==null) p_ord_practitioner_id="";
		}

		stmt=con.prepareStatement("SELECT (SELECT DIAG_CODE_SCHEME FROM OT_PARAM) DIAG_CODE_SCHEME, PRACT_TYPE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?");
		stmt.setString(1,surgeon_code);
		rs=stmt.executeQuery();
		while(rs.next()){
			diag_code_scheme=(rs.getString("DIAG_CODE_SCHEME"));
			practitioner_type=(rs.getString("PRACT_TYPE"));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		stmt=con.prepareStatement("select func_role_id from sm_appl_user_lang_vw where appl_user_id = ? and language_id = ? ");		
		stmt.setString(1,slate_user_id_disp);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();
		if(rs.next()){
			strUser=checkForNull(rs.getString("func_role_id"));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		stmt=con.prepareStatement("SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE IN (SELECT OPER_CODE FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM =? AND NVL(OPER_LINE_STATUS,'X') !='99')");
		stmt.setString(1,facility_id);
		stmt.setString(2,oper_num);
		rs=stmt.executeQuery();
		while(rs.next()){
			order_catalog=(rs.getString("ORDER_CATALOG_CODE"));
			str_order_catalog_code=str_order_catalog_code+order_catalog+"|";
		}
	}catch(Exception e){
		System.err.println("Error In CommonOperDtlsHdr.jsp   "+e);
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}

            _bw.write(_wl_block16Bytes, _wl_block16);

	boolean isRecordAnes = false;
	try{
			con = ConnectionManager.getConnection(request);
			isRecordAnes = CommonBean.isSiteSpecific(con,"OT","OT_RECORD_ANESTHESIA");	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}	

            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	if((!isRecordAnes) && (!function_id.equals("07"))){

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(anesthesia_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(anesthesia_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);

	}else if( function_id.equals("07") && isRecordAnes==true ){ 

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(anesthesia_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(anesthesia_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block26Bytes, _wl_block26);

	}else{

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(anesthesia_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(anesthesia_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);

}

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(anesthetist_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(anesthetist_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
 
	if( tab.equals("record_surgeon") || tab.equals("record_nursing") )  { 

            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oper_room_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(theatre_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);

	} else{	

            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(oper_room_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(theatre_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);

	} 

            _bw.write(_wl_block2Bytes, _wl_block2);
 
	if(document_level_yn.equals("Y")){ 

            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
 
	} 
	if(tab.equals("record_surgeon") || tab.equals("record_nursing")){	
	 if( tab.equals("record_surgeon") && surgeon_doc_comp_yn.equals("Y") && ("true").equals(bill_flag)){ 

            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

	if(("Y").equals(operation_sub_services_yn)){

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(str_order_catalog_code));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

	}

            _bw.write(_wl_block48Bytes, _wl_block48);

	}else if( tab.equals("record_nursing") && nursing_doc_comp_yn.equals("Y") ){

            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

	if( (rec_packs_in_nurs_notes_yn.equals("Y")) && (("N").equals(consumable_entry_cmp_yn))){

            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	if((rec_packs_in_nurs_notes_yn.equals("Y")) && ("Y").equals(consumable_entry_cmp_yn)) {

            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

	}else if((rec_packs_in_nurs_notes_yn.equals("N")) ) {

            _bw.write(_wl_block55Bytes, _wl_block55);

	}

            _bw.write(_wl_block56Bytes, _wl_block56);

	}else{

            _bw.write(_wl_block57Bytes, _wl_block57);

	if( tab.equals("record_surgeon" )){

            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

	}else{

            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
if( (rec_packs_in_nurs_notes_yn.equals("Y")) && (("N").equals(consumable_entry_cmp_yn))){
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block69Bytes, _wl_block69);
if((rec_packs_in_nurs_notes_yn.equals("Y")) && ("Y").equals(consumable_entry_cmp_yn)) {
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
}else if((rec_packs_in_nurs_notes_yn.equals("N")) ) {
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
}}
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	if( (!tab.equals("record_surgeon")) && (!tab.equals("record_nursing"))&& (!recovery_in_out_flag.equals("CHECK_IN_RECO")) && (!recovery_in_out_flag.equals("CHECK_OUT_RECO")) &&  (!function_id.equals("OT_HOLDING_AREA")) && (!function_id.equals("OT_CHECKIN_TO_OR"))&&(!function_id.equals("OT_CHECKOUT_FROM_OR"))){
	System.err.println("856,CommonOperDtls.jsp==function_id===>"+function_id);

            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	if( recovery_in_out_flag.equals("CHECK_IN_RECO") ){
	System.err.println("872,CommonOperDtls.jsp==function_id===>"+function_id);

            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	if( recovery_in_out_flag.equals("CHECK_OUT_RECO") ){
	System.err.println("887,CommonOperDtls.jsp==function_id===>"+function_id);

            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	if( ("OT_HOLDING_AREA").equals(function_id)){
	System.err.println("896,CommonOperDtls.jsp==function_id===>"+function_id);

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	if( ("OT_CHECKIN_TO_OR").equals(function_id)){
	System.err.println("908,CommonOperDtls.jsp==function_id===>"+function_id);

            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	if( ("OT_CHECKOUT_FROM_OR").equals(function_id)){
	System.err.println("921,CommonOperDtls.jsp==function_id===>"+function_id);

            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	if( recovery_in_out_flag.equals("CHECK_IN_RECO") ){
	System.err.println("932,CommonOperDtls.jsp==function_id===>"+function_id);

            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

	}else if(("OT_HOLDING_AREA").equals(function_id)) {
	System.err.println("946,CommonOperDtls.jsp==function_id===>"+function_id);

            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_name)));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(surgeon_desc));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(params));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(doc_level));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(oper_speciality_code));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(oper_speciality_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(surgeon_doc_comp_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(nursing_doc_comp_yn));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(post_oper_diag));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(pre_oper_diag));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(recovery_room_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(rec_start_time));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(rec_end_time));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(transfer_to));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(transfer_ward_code));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(transfer_status));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(oper_date));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(storeCode));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bill_interface_flag_yn));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(bill_sub_services_yn));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(str_order_catalog_code));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(trfr_to_ot_flag));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(request.getParameter("slate_user_id")));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(st_interface_flag));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(p_ord_practitioner_id));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(strUser));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(isRecordAnes));
            _bw.write(_wl_block142Bytes, _wl_block142);

	if(recovery_in_out_flag.equals("CHECK_IN_RECO")){

            _bw.write(_wl_block143Bytes, _wl_block143);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);
 

	if(function_id.equals("OT_HOLDING_AREA")) {

            _bw.write(_wl_block144Bytes, _wl_block144);
	} 
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaType.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Anaesthetist.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DocumentationLevel.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AcrossSpecialities.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PostOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientHistory.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ViewAdditionalCharges.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperativeRecords.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ViewConsumablesUsed.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ViewConsumablesUsed.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosisNew.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PostOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientHistory.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperativeRecords.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumablesUsed.Label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ViewConsumablesUsed.Label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ViewConsumablesUsed.Label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecordChart.Label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.VerifyCheckOutChecklist.Label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecordChart.Label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.VerifyCheckList.Label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.VerifyCheckOutChecklist.Label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecoveryNotes.Label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.HoldingAreaNotes.Label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
