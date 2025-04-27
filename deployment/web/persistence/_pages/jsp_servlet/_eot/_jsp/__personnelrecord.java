package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import eCommon.Common.CommonBean;
import java.sql.CallableStatement;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import eOT.*;
import eOT.Common.*;
import eCommon.XSSRequestWrapper;
import eOR.OrderEntryBillingQueryBean;
import java.util.ArrayList;
import java.util.*;
import com.ehis.util.*;

public final class __personnelrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PersonnelRecord.jsp", 1743663229939L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordSurgeon.js\"></script>\n   ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordNursing.js\"></script>\n   ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11_0 ="\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\n<script language=\'javascript\'>\n\nfunction Class_personnelrow()\n{\n     this.speciality_code=\"\";\n\t this.speciality_desc=\"\";\n\t this.role_id =\"\";\n\t this.role_desc =\"\";\n\t this.role_type=\"\";\n     this.practitioner_id=\"\";\n     this.practitioner_name=\"\";\n\t this.position_desc=\"\";\n\t this.db_mode=\"\";\n\t this.recId =\"\";\n\t //Added Against ML-MMOH-CRF-1979-US02...starts\n\t var isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;\n\tif(isMandateEffortEstimation == \'true\'){\n\t this.operation_code=\"\";\n     this.operation_desc=\"\";\n\t this.team = \"\";\n\t this.time_in_date = \"\";\n\t this.time_in_time = \"\";\n\t this.time_out_date = \"\";\n\t this.time_out_time = \"\";\n\t}\n\t //Added Against ML-MMOH-CRF-1979-US02...ends\n}\n\nfunction disableDocLevel(){\n   var formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n   if(formObj.doc_level.disabled==false)\n\t   formObj.doc_level.disabled=true;\n}\n\nfunction assignSpeciality(){\n\tvar formObjHdr = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n\tvar doc_level = formObjHdr.doc_level.value;\t\n\tvar isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;\n\tif(document.forms[0].tab.value !=\"record_surgeon\")\n\t{\t\n\t\tcallPopulateList(doc_level);\n\t\tif(isMandateEffortEstimation == \'true\'){\n\t\t\tpopulateOperations();\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(doc_level==\"IS\")\n\t\t{\n\t\t\tif(isMandateEffortEstimation == \'true\'){\n\t\t\t\tpopulateOperations();\n\t\t\t}else{\n\t\t\t\tvar facility_id=document.forms[0].facility_id.value;\n\t\t\t\tvar db_mode=parent.parent.parent.frames[4].RecordSurgeonTabForm.db_mode.value;\n\t\t\t\tvar status_value=parent.parent.parent.frames[4].RecordSurgeonTabForm.status_value.value;\n\t\t\t\tvar oper_code_all=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_all.value;\n\t\t\t\tvar oper_code_new=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_new.value;\n\t\t\t\tvar spec_code_final=parent.parent.parent.frames[4].RecordSurgeonTabForm.spec_code_final.value;\n\t\t\t\tvar oper_num=document.forms[0].oper_num.value;\n\t\t\t\tvar arr2=oper_code_all.split(\"*\");\n\t\t\t\tvar arr3=status_value.split(\"*\");\n\t\t\t\tvar arr1=db_mode.split(\"*\");\n\t\n\t\t\t\tvar oper_code=\"\";\n\t\t\t\tvar chk_status=\"\";\n\t\t\t\tvar db_mode_val=\"\";\n\t\t\t\t\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t    xmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=exist_operation_speciality&spec_code_final=\"+spec_code_final,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tvar arr_spec=retVal.split(\"*\");\n\t\t\t\tvar spec_code_new=\"\";\n\t\t\t\tvar spec_code_old=\"\";\n\t\t\t\tvar arr2_spec=\"\";\n\t\t\t\tvar opt =\"\";\n\t\t\t\tfor (var m=0;m<arr_spec.length-1;m++ )\n\t\t\t\t{\n\t\t\t\t\tspec_code_new=arr_spec[m];\n\t\t\t\t\t arr2_spec=spec_code_new.split(\",\");\n\t\t\t\t\t opt = parent.frames[0].document.createElement(\'OPTION\');\n\t\t\t\t\topt.text =arr2_spec[1];\n\t\t\t\t\topt.value=arr2_spec[0];\n\t\t\t\t\tdocument.forms[0].speciality.add(opt);\n\t\t\t\t}\n}else if(doc_level==\"AS\")\n\t\t{\n\t\t\tassignListItems(\'*ALL\',\'All Specialities\');\n\t\t}\n\t}\n}\n\n\nfunction splitString(strVal){\n\tvar isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;\n\tvar arr = strVal.split(\'::\');\n\tvar frmObj = document.forms[0];\n\tfrmObj.speciality.value=arr[0];\n\tfrmObj.role_id.value=arr[2];\n\tfrmObj.role_desc.value=arr[3]\n\tfrmObj.practitioner_id.value=arr[4];\n\tfrmObj.practitioner_name.value=arr[5];\n\tfrmObj.recId.value = arr[6];\n\tfrmObj.role_type.value=arr[7];\n\tfrmObj.mode.value=arr[8];\n\t//Added Against ML-MMOH-CRF-1979-US02...starts\n\tif(isMandateEffortEstimation == \'true\'){\n\tfrmObj.operation.value=arr[9];\n\tif (arr[11] == \'A\') document.getElementById(\'A\').checked = true;\n\telse if (arr[11] == \'B\') document.getElementById(\'B\').checked = true;\n\t\n\tfrmObj.time_in_date.value = arr[12];\n\tfrmObj.time_in_time.value = arr[13];\n\tfrmObj.time_out_date.value = arr[14];\n\tfrmObj.time_out_time.value = arr[15];\n\tfrmObj.operation.disabled=true;\n\tfrmObj.practitioner_name.disabled=true;\n\t//Added Against ML-MMOH-CRF-1979-US02...ends\n\t}else{\n\tfrmObj.record.disabled=true;\t\n\t}\n\tfrmObj.speciality.disabled=true;\n\tfrmObj.role_desc.disabled=true;\n\tfrmObj.speciality.disabled=true;\n\tfrmObj.DoctorLookUp.disabled=true;\n\tfrmObj.record.disabled=true;\t\n}\n\nfunction resetFields(){\n\tvar frmObj = document.PersonnelRecordForm;\n\tfrmObj.mode.value=\'I\';\n\tfrmObj.role_desc.value=\'\';\n\tfrmObj.practitioner_name.value=\'\';\n\tfrmObj.role_desc.value=\'\';\n\tfrmObj.role_type.value=\'\';\n\t//Added Against ML-MMOH-CRF-1979-US02...starts\n\tvar isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;\n\tif(isMandateEffortEstimation == \'true\'){\n\t//frmObj.operation.value = \"\";\n\tfrmObj.time_in_date.value = \"\";\n\tfrmObj.time_in_time.value = \"\";\n\tfrmObj.time_out_date.value = \"\";\n\tfrmObj.time_out_time.value = \"\";\n\tif (frmObj.team.value == \'A\') document.getElementById(\'A\').checked = false;\n\telse if (frmObj.team.value == \'B\') document.getElementById(\'B\').checked = false;\n\tfrmObj.operation.disabled=false;\n\tfrmObj.operation.textContent = \'Select\';\n\tfrmObj.practitioner_name.disabled=false;\n\t}else{\n\t//Added Against ML-MMOH-CRF-1979-US02...ends\n\tfrmObj.speciality.disabled=false;\n\tfrmObj.role_desc.disabled=false;\n\tfrmObj.DoctorLookUp.disabled=false;\n\tfrmObj.record.disabled=false;\n\t//refresh();\n}\n\nfunction refresh(){\n\tvar params = document.forms[0].params.value;\n\tvar disp_hosp = \'\';//Added for CHL-CRF-0020.1 [IN:043132]\n\tif(document.forms[0].tab.value ==\"record_surgeon\")\n\t\tdisp_hosp = parent.parent.parent.frames[4].RecordSurgeonTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]\n\telse if(document.forms[0].tab.value ==\"record_nursing\")\n\t\tdisp_hosp = parent.parent.parent.frames[3].RecordNursingTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]\n\t//parent.DetailFrame.location.href=\'../../eOT/jsp/PersonnelDtls.jsp?\'+params+ \"&disp_hosp=\"+disp_hosp,1000;\n\tsetTimeout(function(){parent.DetailFrame.location.href=\'../../eOT/jsp/PersonnelDtls.jsp?\'+params+ \"&disp_hosp=\"+disp_hosp,1000});//Added Against SKR-SCF-1744\n}\n\nfunction addRow(operation,speciality,team,role_desc,practitioner_name,time_in_date,time_in_time,time_out_date,time_out_time){\n\tvar objrow = newRow();\n\tvar formObj = document.PersonnelRecordForm;\n\tvar params = formObj.params.value;\n\tvar disp_hosp = \'\';\n\tvar isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;\nif(isMandateEffortEstimation == \'true\'){\n\tvar check_in_time = trimString(document.forms[0].check_in_time.value);\n\tvar check_out_time = trimString(document.forms[0].check_out_time.value);\n\tvar time_in = document.forms[0].time_in_date.value+\" \"+document.forms[0].time_in_time.value;\n\tvar time_out = document.forms[0].time_out_date.value+\" \"+document.forms[0].time_out_time.value;\n\t   if(time_in == \'\' || time_in == \'undefined\' || time_in == null) time_in = \'\';\n\t   if(time_out == \'\' || time_out == \'undefined\' || time_out == null) time_out = \'\';\n\t}\n\t//var mandate_eff_estimation_yn = document.forms[0].mandate_eff_estimation_yn.value;\t\t\t\t\t\t\n\tif(document.forms[0].tab.value ==\"record_surgeon\")\n\t\tdisp_hosp = parent.parent.parent.frames[4].RecordSurgeonTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]\n\telse if(document.forms[0].tab.value ==\"record_nursing\")\n\t\tdisp_hosp = parent.parent.parent.frames[3].RecordNursingTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]\n\tvar locale = formObj.locale.value;\n\tvar mode = formObj.mode.value;\n\t\tif(mode==\'I\'){\n\t\t\t  if(chkEmpty() && validateTimeInTimeOut(time_in,time_out,check_in_time,check_out_time,isMandateEffortEstimation)){\n\t\t\t  if(alreadyExist()){\n\t\t\t\t  var obj = formObj.speciality;\n\t\t\t\t  var obj1 = formObj.role_desc;\n\t\t\t\t  var rows = parent.parent.parent.ObjectCollect.personnelrows;\n\t\t\t\t  var tempPersonnelRows = parent.parent.parent.ObjectCollect.tempPersonnelRows;\n\t\t\t\t  //Added Aganst ML-MMOH-CRF-1979-US02...starts\n\t\t\t\t  if(isMandateEffortEstimation == \'true\'){  \n\t\t\t\t\tobjrow.operation_code =formObj.operation.value; \n\t\t\t\t\tobjrow.operation_desc=formObj.operation.options[formObj.operation.selectedIndex].text;\t\t  \n\t\t\t\t\tif (document.getElementById(\'A\').checked) objrow.team = document.getElementById(\'A\').value;\t\n\t\t\t\t\tif (document.getElementById(\'B\').checked) objrow.team = document.getElementById(\'B\').value;\t\t\tobjrow.time_in = document.forms[0].time_in_date.value+\" \"+document.forms[0].time_in_time.value;\n\t\t\t\t\tobjrow.time_out = document.forms[0].time_out_date.value+\" \"+document.forms[0].time_out_time.value;\n\t\t\t\t\tif(objrow.operation_desc == null && objrow.operation_desc == \'undefined\') objrow.operation_desc = \'\';\n\t\t\t\t\tif(objrow.team == null && objrow.team == \'undefined\') objrow.team = \'\';\n\t\t\t\t\tif(objrow.time_in == null && objrow.time_in == \'undefined\') objrow.time_in = \'\';\n\t\t\t\t\tif(objrow.time_out == null && objrow.time_out == \'undefined\') objrow.time_out = \'\';\n\t\t\t\t  }\n\t\t\t\t  //Added Aganst ML-MMOH-CRF-1979-US02...ends\n\t\t\t\t  objrow.speciality_code =formObj.speciality.value; \n\t\t\t\t  objrow.speciality_desc=formObj.speciality.options[obj.selectedIndex].text;\n\t\t\t\t  objrow.role_id=formObj.role_id.value;\n\t\t\t\t  objrow.role_desc = formObj.role_desc.options[obj1.selectedIndex].text;// formObj.role_desc.value;\n\t\t\t\t  objrow.role_type=formObj.role_type.value;\n\t\t\t\t  objrow.practitioner_id=formObj.practitioner_id.value;\n\t\t\t\t  objrow.practitioner_name=formObj.practitioner_name.value;\n\t\t\t\t  objrow.db_mode=\'I\';\n\t\t\t\t  objrow.position_desc = getPositionDesc(formObj.practitioner_id.value,locale);\n\t\t\t\t  objrow.recId = rows.length+1;\n\t\t\t\t  rows.push(objrow);\n\t\t\t\t  //if(disp_hosp == \'N\')\n\t\t\t\t  //\ttempPersonnelRows.push(objrow);\n\t\t\t\t  resetFields();\n\t\t\t\t  //parent.DetailFrame.location.href=\'../../eOT/jsp/PersonnelDtls.jsp?\'+params+ \"&disp_hosp=\"+disp_hosp,1000;\n\t\t\t\t  setTimeout(function(){parent.DetailFrame.location.href=\'../../eOT/jsp/PersonnelDtls.jsp?\'+params+ \"&disp_hosp=\"+disp_hosp,1000});//Added Against SKR-SCF-1744\n\t\t\t\t  parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t   }else { //else part of alreadyExist method\n\t\t\t\t var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n\t\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\t   }\n\t\t}\n    }//if part of mode Check Ends Here\n\telse if(mode != \"I\" && isMandateEffortEstimation == \'true\') {\n\tupdateRow(operation,speciality,team,formObj.practitioner_id.value,role_desc,practitioner_name,time_in_date,time_in_time,time_out_date,time_out_time,mode);\n}\n}\n\n\nfunction updateRow(operation,speciality,team,practitioner_id,role_id,role_desc,practitioner_name,time_in_date,time_in_time,time_out_date,time_out_time,mode){\n\tvar formObj = document.Perso";
    private final static byte[]  _wl_block11_0Bytes = _getBytes( _wl_block11_0 );

    private final static java.lang.String  _wl_block11_1 ="nnelRecordForm;\n\tvar rows2 = parent.parent.parent.ObjectCollect.personnelrows;\n\t\n\tvar params = formObj.params.value;\n\tvar disp_hosp = \'\';\n\tvar check_in_time = trimString(document.forms[0].check_in_time.value);\n\tvar check_out_time = trimString(document.forms[0].check_out_time.value);\n\tvar time_in = document.forms[0].time_in_date.value+\" \"+document.forms[0].time_in_time.value;\n\tvar time_out = document.forms[0].time_out_date.value+\" \"+document.forms[0].time_out_time.value;\n\tvar isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;\n\tvar locale = formObj.locale.value;\n\tif(document.forms[0].tab.value ==\"record_surgeon\")\n\t\tdisp_hosp = parent.parent.parent.frames[4].RecordSurgeonTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]\n\telse if(document.forms[0].tab.value ==\"record_nursing\")\n\t\tdisp_hosp = parent.parent.parent.frames[3].RecordNursingTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]\n\t\n\t\tfor(var jj=0;jj<rows2.length;jj++){\n\t\t\tif(rows2[jj].operation_code == \'\' || rows2[jj].operation_code == \'undefined\' || rows2[jj].operation_code == null) rows2[jj].operation_code = document.forms[0].oper_code.value;\n\t\t\tif(rows2[jj]!=null && rows2[jj].operation_code!=null && rows2[jj].operation_code!=\"\" && rows2[jj].practitioner_id!=null && rows2[jj].practitioner_id!=\"\" ) {\n\t\t\t\tif(rows2[jj].operation_code==operation && rows2[jj].practitioner_id==practitioner_id ){\n\t\t\t\t\n\t\t\t\t\tif(mode !=\"I\" && validateTimeInTimeOut(time_in,time_out,check_in_time,check_out_time,isMandateEffortEstimation) && chkEmpty()){\n\t\t\t\t\t//Added Aganst ML-MMOH-CRF-1979-US02...starts\n\t\t\t\t\t\t\tif (document.getElementById(\'A\').checked) rows2[jj].team = document.getElementById(\'A\').value;\n\t\t\t\t\t\t\tif (document.getElementById(\'B\').checked) rows2[jj].team = document.getElementById(\'B\').value;\n\t\t\t\t\t\t\trows2[jj].time_in = document.forms[0].time_in_date.value+\" \"+document.forms[0].time_in_time.value;\n\t\t\t\t\t\t\trows2[jj].time_out = document.forms[0].time_out_date.value+\" \"+document.forms[0].time_out_time.value;\n\t\t\t\t\t\t\tif(rows2[jj].db_mode==\'L\') rows2[jj].db_mode=\'U\';\n\t\t\t\t\t\tresetFields();\n\t\t\t\t\t\tsetTimeout(function(){parent.DetailFrame.location.href=\'../../eOT/jsp/PersonnelDtls.jsp?\'+params+ \"&disp_hosp=\"+disp_hosp,1000});\n\t\t\t\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t}\n}\n\nfunction assignRecId(){\n\tvar rows = parent.parent.parent.ObjectCollect.personnelrows;\n\tparent.parent.parent.ObjectCollect.personnelrowLength=rows.length;\n\t\n}\n\nfunction getRecId(){\n\tvar rowLength=parent.parent.parent.ObjectCollect.personnelrowLength;\n\tvar recId = rowLength+1;\n\tparent.parent.parent.ObjectCollect.personnelrowLength  =  recId;\n\treturn recId;\n}\n\n\nfunction removeRow()\n {\n\t var formObj = document.PersonnelRecordForm;\n\t var mode = formObj.mode.value;\n\t var recId = formObj.recId.value;\n\t var params = formObj.params.value;\n\t var objrow = newRow();\n\t var rows = parent.parent.parent.ObjectCollect.personnelrows;\n\t objrow=rows;\n\t\tif(rows.length>0&& mode==\'U\')\n\t\t{\n\t\t\tfor(var  jj=rows.length; jj>-1; jj--)\n\t\t\t{\n\t\t\t\tif(rows[jj]!=null  && rows[jj].recId!=null && rows[jj].recId!=\"\")\n\t\t\t\t{\n\t\t\t\t\tif(rows[jj].recId==recId )\n\t\t\t\t\t{\n\t\t\t\t\t  if(rows[jj].db_mode==\'L\')\n\t\t\t\t\t\t  {\t\n\t\t\t\t\t\t\t  rows[jj].db_mode=\'D\';\n\t\t\t\t\t\t  }\n\t\t\t\t\t  else\n\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t  rows.splice(jj,1);\n\t\t\t\t\t\t  }\n\t\t\t\t\t\t // rows.splice(jj,1);//ML-BRU-SCF-1192 [IN:045650]\n\t         \t\t\t  break;\n\t\t\t\t\t }\n\t\t\t\t }\n\t\t\telse\n\t\t\tcontinue;\n\t\t }//end for-Loop\n\t   resetFields();\n\t   parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\t   //parent.DetailFrame.location.href=\'../../eOT/jsp/PersonnelDtls.jsp?\'+params;\n\t   setTimeout(function(){parent.DetailFrame.location.href=\'../../eOT/jsp/PersonnelDtls.jsp?\'+params,1000});//Added Against SKR-SCF-1744\n\t   refresh(); //added for cancel\n\t }else\n\t   resetFields();\n\t   isValidDocumentation();\n }\n\nfunction isValidDocumentation(){\n\t var rows = parent.parent.parent.ObjectCollect.personnelrows;\n\t var role=\"\";\n\t var formObj = parent.parent.parent.doc_status_frame.SurgeonDocStatusForm;\n\t  if(rows!=null && rows.length>0){\n\t\t\tfor(i=0;i<rows.length;i++){\n\t\t\t\tif(rows[i]!=null && rows[i].db_mode!=\'D\') role+=rows[i].role_type+\",\";\n\t\t\t}\n\t}\n\tif(role.length>0){\n\t\tif(role.indexOf(\"OS\")>=0 && role.indexOf(\"MA\")>=0){\n\t\t}else\n\t\t\tformObj.doc_complete.checked = false;\n\t}\n  }\n\nfunction newRow()\n{\n   var objrow = new Class_personnelrow();\n   objrow.recId = parent.parent.parent.ObjectCollect.personnelrows.length+1;\n   return(objrow);\n}\n\n\nfunction chkEmpty(){\n\tvar formObj = document.PersonnelRecordForm;\n\tvar fields = new Array(formObj.role_desc,formObj.practitioner_name);\n\tvar names = new Array(\'Role\',\'Name\');\n\tvar messageFrame = parent.parent.parent.messageFrame;\n\tvar mandate_eff_estimation_yn = document.forms[0].mandate_eff_estimation_yn.value;\n\tvar isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;\n\tif(mandate_eff_estimation_yn === \'Y\' && isMandateEffortEstimation == \'true\'){\n\t\tvar names = new Array(\'Role\',\'Name\',\'Time in Date\',\'Time in Time\',\'Time out Date\',\'Time out Time\');//Added Against ML-MMOH-CRF-1979-US02\n\t\tvar fields = new Array(formObj.role_desc,formObj.practitioner_name,formObj.time_in_date,formObj.time_in_time,formObj.time_out_date,formObj.time_out_time);//Added Against ML-MMOH-CRF-1979-US02\n\t\n\t\tif(checkFields( fields, names, messageFrame)){\n\t\t\tif(document.getElementById(\'A\').checked == true || document.getElementById(\'B\').checked == true) {\n\t\t\t\treturn true;\n\t\t\t}else{\n\t\t\t\terrors = getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(\'Team Selection\')))+\"<br>\"\n\t\t\t\tmessageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors;\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}else if(mandate_eff_estimation_yn === \'N\' && isMandateEffortEstimation == \'true\'){\n\t\t\n\t\tvar time_in_date = formObj.time_in_date.value;\n\t\tvar time_in_time = formObj.time_in_time.value;\n\t\tvar time_out_date = formObj.time_out_date.value;\n\t\tvar time_out_time = formObj.time_out_time.value;\n\t\t\n\t\tif ((time_in_date || time_in_time || time_out_date || time_out_time) && !(time_in_date && time_in_time && time_out_date && time_out_time)){\n\t\t\t\t/* errors = getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(\'Time in/out\')))+\"<br>\"\n\t\t\t\tmessageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors;\n\t\t \n\t\t\t\treturn false; */\n\t\tvar names = new Array(\'Role\',\'Name\',\'Time in Date\',\'Time in Time\',\'Time out Date\',\'Time out Time\');\n\t\tvar fields = new Array(formObj.role_desc,formObj.practitioner_name,formObj.time_in_date,formObj.time_in_time,formObj.time_out_date,formObj.time_out_time);\n\t\t\n\t\t}else{\n\t\tvar names = new Array(\'Role\',\'Name\');\n\t\tvar fields = new Array(formObj.role_desc,formObj.practitioner_name);\n\t\t}\n\t\tif(checkFields(fields, names, messageFrame)) return true;\n\t}else{\n\t\tvar names = new Array(\'Role\',\'Name\');\n\t\tvar fields = new Array(formObj.role_desc,formObj.practitioner_name);\n\t\tif(checkFields(fields, names, messageFrame)) return true;\n\t}\n}\n\nfunction alreadyExist(){\n\tvar formObj = document.PersonnelRecordForm;\n\tvar codeDtl = parent.DetailFrame.code; \n\tvar spltyCodeDtl = parent.DetailFrame.splty_code; \n\tvar operCodeDtl = parent.DetailFrame.oper_code; \n\tvar rows = parent.parent.parent.ObjectCollect.personnelrows;\n\tvar speciality_code=formObj.speciality.value;\n\tvar role_id = formObj.role_id.value;\n\tvar practitioner_id = formObj.practitioner_id.value;\n\tvar codeRecord = practitioner_id+\",\";\n\tvar operCodeArr = operCodeDtl.split(\",\");\n\tvar spltyArr = spltyCodeDtl.split(\",\");\n\tvar splCode =  codeDtl.split(\",\");\n\tvar isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;//Added Agaisnt ML-MMOH-CRF-1979-US02\n\n//modified by DhanasekarV 17/01/2011 against issue IN025911\n\tif(isMandateEffortEstimation == \'true\'){\n\t\tvar operation_code = formObj.operation.value;\t\t\t\n\t\t\tfor (var i=0 ;i<splCode.length;i++){\n\t\t\t\tif(splCode[i]==practitioner_id && operCodeArr[i]==operation_code) return false; //Modified Against ML-MMOH-SCF-2950 By Gaurav\n\t\t\t}\n\t}else{\n\t\tfor (var i=0 ;i<spltyArr.length;i++)\n\t\t{ \n\t\t\tif(spltyArr[i]==speciality_code && splCode[i]==practitioner_id) return false;\n\t\t}\n\t}\n\treturn true;\n\n\n }\n\n function assign(obj){\n\t formObj = document.PersonnelRecordForm;\n\t var str = obj.value;\n\t var arr = str.split(\"##\");\n\t formObj.role_id.value=arr[0];\n\t formObj.role_type.value=arr[1];\n }\n//CRF-CHL-20.1\nfunction hideSelect()\n{\n\tvar disp_hosp = \'\';\n\tif(document.forms[0].tab.value ==\"record_surgeon\")\n\t\tdisp_hosp = parent.parent.parent.frames[4].RecordSurgeonTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]\n\telse if(document.forms[0].tab.value ==\"record_nursing\")\n\t\tdisp_hosp = parent.parent.parent.frames[3].RecordNursingTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]\n\tif(disp_hosp == \'N\')\n\t{\n\t\tdocument.getElementById(\"recordId\").style.display = \'none\';\n\t\tdocument.getElementById(\"cancelId\").style.display = \'none\';\n\t}\n}\n//Added Against ML-MMOH-CRF-1979-US02...starts\nfunction populateOperations(){\n\tvar formObj=document.forms[0];\n\tvar oper_desc=new Array();\n\tvar oper_code=new Array();\n\tvar oper_line_no=new Array();\n\tvar specialityArr=new Array();\n\tvar objFrm = parent.parent.parent.ObjectCollect;\n\tvar operationObj=formObj.operation;\n\tvar specialityObj=formObj.speciality;\n\tvar count = 0;\n\tvar value = \"\";\n\t  \n\tif(objFrm.rows!=null){\n\t\tfor(var i=0;i<objFrm.rows.length;i++) {\n\t\t\tif(objFrm.rows[i]!=null  && objFrm.rows[i].db_mode!=\'D\'){\n\t\t\t\toper_code[i]=objFrm.rows[i].oper_code;\n\t\t\t\toper_desc[i]=objFrm.rows[i].oper_desc; \n\t\t\t\toper_line_no[i]=objFrm.rows[i].line_no;\n\t\t\t\toperationObj.options[i]=new Option(oper_desc[i],oper_code[i]);\n\t\t\t\t\n\t\t\t\tspecialityArr = populateSpeciality(oper_code[i]);\n\t\t\t\tspecialityArr[3] = oper_line_no[i];\n\t\t\t\tif(oper_line_no[i] == 1 && specialityArr[3] == 1){\t\n\t\t\t\t\tcount = i;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\toperationObj.selectedIndex = count;\n\tspecialityObj.selectedIndex = count;\n\t//Added against ML-MMOH-SCF-2899\n\tif(formObj.speciality.value == \'\' || formObj.speciality.value == null)\n\t\tcount = 0;\n\t\n\tspecialityObj.selectedIndex = count;\n}\n\n\nfunction isValueInObj(Obj, specialityArr) {\n    for (var i = 0; i < Obj.options.length; i++) {\n        if (Obj.options[i].value === specialityArr[0]) {\n            return true;\n        }\n    }\n\t\treturn false;\n}\n\nfunction getSpeciality(oper_code){\n\tvar Obj = document.forms[0].speciality;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\txmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=getSpecialityDesc&oper_code=\"+oper_code,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.re";
    private final static byte[]  _wl_block11_1Bytes = _getBytes( _wl_block11_1 );

    private final static java.lang.String  _wl_block11_2 ="sponseText);\n\tvar specialityArr = retVal.split(\"*\");\n\treturn specialityArr;\n}\n\nfunction populateSpeciality(oper_code){\n\tvar Obj = document.forms[0].speciality;\n\tvar specialityArr = getSpeciality(oper_code);\n    // Check if the value already exists in the dropdown\n    if (!isValueInObj(Obj, specialityArr)) {\n        var listOption1\t= document.createElement(\'option\');\n\t\tlistOption1.value = specialityArr[0];\n\t\tlistOption1.text = specialityArr[1];\n\t\tObj.add(listOption1);\n    }\n\treturn specialityArr;\n}\n\nfunction updateSpeciality(oper_code){\n\tvar Obj = document.forms[0].speciality;\n\tvar specialityArr = getSpeciality(oper_code);\t\n\tfor (var i = 0; i < Obj.options.length; i++) {\n            if (Obj.options[i].value === specialityArr[0]) {\n\t\t\t\tcount = i;\n            }\n        }\n\tObj.selectedIndex = count;\t\n}\t\n\nfunction changeDateForm(date_time){\n\tvar fromdt = \"\";\n\tif(date_time.length > 0) {\n\t\tvar date_time_array = date_time.split(\" \");\n\t\tvar date = date_time_array[0];\n\t\tvar time = date_time_array[1];\n        var datearray = date.split(\"-\");\n        var timearray = time.split(\":\");\n\t\tfromdt = datearray[2]+\"/\"+datearray[1]+\"/\"+datearray[0]+\" \"+timearray[0]+\":\"+timearray[1];            \n    }\n\treturn fromdt;\n}\n\t\nfunction validateTimeInTimeOut(timeIn, timeOut, checkIn_Time, checkOut_Time,isMandateEffortEstimation) {\n\tif((isMandateEffortEstimation == \'true\') && (document.forms[0].time_in_date.value != \'\' && document.forms[0].time_in_time.value  != \'\' && document.forms[0].time_out_date.value  != \'\' && document.forms[0].time_out_time.value != \'\')){\n\t\t\n\t\tvar checkInTime = changeDateForm(checkIn_Time);\n\t\tvar checkOutTime = changeDateForm(checkOut_Time);\n\t\tvar timeInParsed = timeIn;\n\t\tvar timeOutParsed = timeOut;\n\t\tvar messageFrame = parent.parent.parent.messageFrame;\n\t\tvar locale = document.forms[0].locale.value;\n\t\tvar sysdate = document.forms[0].sysdate.value;\n\t\t// Check if \'to date&time\' is not before \'from date&time\'\n\t\tif(compareDates2(timeOutParsed,timeInParsed,locale,\'DMYHM\')) {\n\t\t\terror = getMessage(\"TIME_OUT_LESS_TIME_IN\",\"OT\");\n\t\t\tmessageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"TIME_OUT_LESS_TIME_IN\",\"OT\");\n\t\t\treturn false;\n\t\t}\n\n\t\t// Check if \'from date&time\' and \'to date&time\' fall within the given date range\n\t\tif(compareDates2(timeInParsed,checkInTime,locale,\'DMYHM\')){\n\t\t\tmessageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"TIME_IN_LESS_CHECK_IN\",\"OT\");\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tif(compareDates2(checkOutTime,timeOutParsed,locale,\'DMYHM\')) {\n\t\t\tmessageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"TIME_OUT_GREATER_CHECK_OUT\",\"OT\")+\"[\"+(trimString(checkOutTime))+\"]\";\n\t\treturn false;\n\t\t}\n\t\tvar returnValone = compareDates2(timeInParsed,sysdate,locale,\'DMYHM\');\n\t\tif(returnValone==false){\n\t\t\tmessageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"APP-OT0244\",\"OT\");\n\t\t\treturn false;\n\t\t}\n\t\tvar returnValone2 = compareDates2(timeOutParsed,sysdate,locale,\'DMYHM\');\n\t\tif(returnValone2==false){\n\t\t\tmessageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"APP-OT0245\",\"OT\");\n\t\t\treturn false;\n\t\t}\n\t}\t\n\treturn true;\n}\n\nfunction compareDates2(fromdate,todate,locale,format) {\n    var fromarray; var toarray;\n\tvar fromdate = dateUtils(fromdate,locale,format);\n\tvar todate = dateUtils(todate,locale,format);\n\t\n    if(fromdate.length > 0 && todate.length > 0 ) {\n\t\tvar from_date_array = fromdate.split(\" \");\n\t\tvar from_date = from_date_array[0];\n\t\tvar from_time = from_date_array[1];\n\t\t\n\t\tvar to_date_array = todate.split(\" \");\n\t\tvar to_date = to_date_array[0];\n\t\tvar to_time = to_date_array[1];\n\t\t\n\t\tvar fromdatearray = from_date.split(\"/\");\n        var todatearray = to_date.split(\"/\");\n\t\t\n\t\tvar fromtimearray = from_time.split(\":\");\n        var totimearray = to_time.split(\":\");\n\t\t\n\t\tvar fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);\n        var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);\n        if(Date.parse(todt) < Date.parse(fromdt)) {\n\t\t\treturn false;\n        }\n\t\treturn true;\n\t}else{\n\t\treturn false;\n\t}\n\t\n}\n\nfunction clearFields(){\n\t\n\t//var team = document.getElementsByName(\'team\');\n\t//for(var i=0;i<team.length;i++)  team[i].checked = false;\n\tdocument.getElementById(\"role_desc\").selectedIndex = 0\n\tdocument.forms[0].practitioner_name.value = \'\';\n\tdocument.forms[0].time_in_date.value = \'\';\n\tdocument.forms[0].time_in_time.value = \'\';\n\tdocument.forms[0].time_out_date.value = \'\';\n\tdocument.forms[0].time_out_time.value = \'\';\n\tdocument.PersonnelRecordForm.speciality.disabled = true;\n}\n//Added Against ML-MMOH-CRF-1979-US02...ends\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<!--Added Against ML-MMOH-CRF-1979-US02...starts-->\n\n<body onLoad=\"assignSpeciality();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<!--<body onLoad=\"assignSpeciality();hideSelect();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'-->\n<!--Added Against ML-MMOH-CRF-1979-US02...ends-->\n<form name = \'PersonnelRecordForm\'>\n<input type = \"hidden\"  name=\'params\' id=\'params\'  value=\"";
    private final static byte[]  _wl_block11_2Bytes = _getBytes( _wl_block11_2 );

    private final static java.lang.String  _wl_block12 ="\" > \n<input type=\'hidden\' name=\'tab\' id=\'tab\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\n<table  border=\'0\' cellpadding=3 cellspacing=\'0\' width=\'100%\' align=\"center\">\n<tr>\n\t<!--ML-MMOH-CRF-1979-US02 starts-->\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<td class=\"label\" width=\'5%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t</td>\n\t\t<td class=\"label\" width=\'20%\'>\n\t\t\t<select name=\'operation\' id=\'operation\' id = \'operation\'  onChange=\"clearFields(); updateSpeciality(this.value)\" >\n\t\t\t\t<option value=\"\"></option>\n\t\t\t</select>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t</td>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t<!--ML-MMOH-CRF-1979-US02 end-->\n\t\t\n\t\t<td class=\"label\" width=\'5%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</td>\n\t\t<td class=\"label\" width=\'20%\'>\n\t\t\t<select name=\'speciality\' id=\'speciality\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" ></select>\n\t\t</td>\n\t<!--ML-MMOH-CRF-1979-US02 start-->\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</td>\n\t\t<td class=\"label\" width=\'20%\'>\n\t\t\tA<input type=\"radio\" name=\"team\" id=\"team\" id=\"A\" value=\"A\">&nbsp;&nbsp;&nbsp;\n\t\t\tB<input type=\"radio\" name=\"team\" id=\"team\" id=\"B\" value=\"B\">\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</td>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\n\t<!--ML-MMOH-CRF-1979-US02 end-->\t\n</tr>\t\t\n<tr> \n\t\t<td class=\"label\" width=\'30%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</td>\n\t\t<td class=\"fields\" width=\'70%\'>\n\t\t\t<select name=\'role_desc\' id=\'role_desc\'  onChange=\"assign(this);\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">\n\t\t\t\t<option value=\"\">\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t</option>\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\n\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n</select>\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n</tr>\n<tr> \n\t\t\t<td class=\"label\" width=\'30%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</td>\n\t\t\t<td class=\"fields\" width=\'70%\'>\n\t\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' >\n\t\t\t<input type=\'text\' name=\'practitioner_name\' id=\'practitioner_name\' size=\'20\' onblur=\"if(this.value!=\'\')searchDoctor(practitioner_id,practitioner_name); else practitioner_id.value=\'\';\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" >\t\t\t\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'DoctorLookUp\' id=\'DoctorLookUp\' \tonClick=\'searchDoctor(practitioner_id,practitioner_name);\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n</tr>\n<!--ML-MMOH-CRF-1979-US02 starts-->\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<tr>\n\t\t\n\t\t\t<td class=\"label\" width=\'5%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t</td>\n\t\t\t<td class=\"fields\" width=\'10%\' align=\'left\'>\n\t\t\t<input type=\'text\' name=\'time_in_date\' id=\'time_in_date\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' size=\'8\' readonly> \n\t\t\t\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'time_in_date\');\" >\n\t\t\t\n\t\t\t<input type=\'text\' name=\'time_in_time\' id=\'time_in_time\' size=\'2\' maxlength=\'5\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onkeypress =\'return checkForSpecCharsforIDTime(event);\' onBlur=\"if(this.value!=\'\')checkTimeFormat(time_in_date,this);\"  >\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t        </td>\n\t\t\t\n\t\t\t<td class=\"label\" width=\'5%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t</td>\n\t\t\t<td class=\"fields\" width=\'10%\' align=\'left\'>\n\t\t\t<input type=\'text\' name=\'time_out_date\' id=\'time_out_date\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' size=\'8\' readonly> \n\t\t\t\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'time_out_date\');\" >\n\t\t\t\n\t\t\t<input type=\'text\' name=\'time_out_time\' id=\'time_out_time\' size=\'2\' maxlength=\'5\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' onkeypress =\'return checkForSpecCharsforIDTime(event);\'  onBlur=\"if(this.value!=\'\')checkTimeFormat(time_out_date,this);\"  >\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t</td>\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\n<!--ML-MMOH-CRF-1979-US02 end--> \n\n\t\t\t<td width=\'25%\'class=\"button\" colspan=\"2\" >\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t<input type=\'button\' name=\'view\' id=\'view\' class=\'button\' value=\'View Staff Assignment\' onClick=\'javascript:viewStaffAssignment(\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\",\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\")\'>\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\n\t\t\t\t<input type=\'button\' name=\'record\' id=\'record\' id=\'recordId\' class=\'button\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' onClick=\'addRow(document.forms[0].operation.value,document.forms[0].speciality.value,document.forms[0].team.value,document.forms[0].role_desc.value,document.forms[0].practitioner_name.value,document.forms[0].time_in_date.value,document.forms[0].time_in_time.value,document.forms[0].time_out_date.value,document.forms[0].time_out_time.value); disableDocLevel();\' ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" >\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<input type=\'button\' name=\'record\' id=\'record\' id=\'recordId\' class=\'button\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' onClick=\'addRow(); disableDocLevel();\' ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\t\t\n\t\t\t\t<input type=\'button\' name=\'cancel\' id=\'cancel\' id=\'cancelId\' class=\'button\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" >\n\t\t\t</td>\n\t\n</tr>\n</table>\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<input type=\'hidden\' name=\'db_speciality_code\' id=\'db_speciality_code\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' >\n<input type=\'hidden\' name=\'role_type\' id=\'role_type\' >\n<input type=\'hidden\' name=\'role_id\' id=\'role_id\' >\n<input type=\'hidden\' name=\'refresh_flag\' id=\'refresh_flag\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<input type=\'hidden\' name=\'check_in_time\' id=\'check_in_time\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"><!--ML-MMOH-CRF-1979-US02-->\n<input type=\'hidden\' name=\'check_out_time\' id=\'check_out_time\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"><!--ML-MMOH-CRF-1979-US02-->\n<input type=\'hidden\' name=\'mandate_eff_estimation_yn\' id=\'mandate_eff_estimation_yn\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"><!--ML-MMOH-CRF-1979-US02-->\n<input type=\'hidden\' name=\'isMandateEffortEstimation\' id=\'isMandateEffortEstimation\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"><!--ML-MMOH-CRF-1979-US02-->\n<input type=\'hidden\' name=\'oper_code\' id=\'oper_code\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"><!--ML-MMOH-CRF-1979-US02-->\n<input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"><!--ML-MMOH-CRF-1979-US02-->\n<!-- Added below hidden field on march 1,2011 by Anitha -->\n<input type=\'hidden\' name=\'tab_id\' id=\'tab_id\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );
 
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

 
	String encode(String data){	  
	  byte byteData[] = data.getBytes();
		String outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
	}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 String tab = CommonBean.checkForNull(request.getParameter("tab")); 
	String params = request.getQueryString();
	boolean isMandateEffortEstimation = false;
	String oper_code = CommonBean.checkForNull(request.getParameter("oper_code"));
	Connection con = null;
	
	try{
		con = ConnectionManager.getConnection(request);
		
		isMandateEffortEstimation = eCommon.Common.CommonBean.isSiteSpecific(con, "OT", "MANDATE_EFFORT_ESTIMATION");//Added Against ML-MMOH-CRF-1979-US02
		//isMandateEffortEstimation = true;
		System.err.println("isMandateEffortEstimation="+isMandateEffortEstimation);
	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{ 
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
	
   if(tab.equals("record_surgeon")){ 
            _bw.write(_wl_block9Bytes, _wl_block9);
 } else if(tab.equals("record_nursing")){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11_0Bytes, _wl_block11_0);
            _bw.write(_wl_block11_1Bytes, _wl_block11_1);
            _bw.write(_wl_block11_2Bytes, _wl_block11_2);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block13Bytes, _wl_block13);

	String called_from =  CommonBean.checkForNull(request.getParameter("called_from"));
	String refresh_flag=CommonBean.checkForNull(request.getParameter("refresh_flag"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String oper_room_code = CommonBean.checkForNull(request.getParameter("oper_room_code"));
	String theatre_date = CommonBean.checkForNull(request.getParameter("theatre_date"));
	String check_in_time = "";//CommonBean.checkForNull(request.getParameter("check_in_time"));//Added Against ML-MMOH-CRF-1979-US02
	String sysdate = "";//Added Against ML-MMOH-CRF-1979-US02
	String surgeon_doc_comp_yn ="";
	String nursing_doc_comp_yn ="";
	String customer_id1=""; // Added for IN:046182
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
	if(tab.equals("record_surgeon")){
		surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	} else if(tab.equals("record_nursing")){
		nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn"));
	}
	//String db_speciality_code="";
	String db_speciality_code=CommonBean.checkForNull(request.getParameter("SPECIALITY_CODE"));
	String disable_flag="";
	if(surgeon_doc_comp_yn.equals("Y") || nursing_doc_comp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";

	String SQL1 ="SELECT DISTINCT(SPECIALITY_CODE) FROM OT_POST_OPER_PERSONNEL WHERE  OPERATING_FACILITY_ID=? AND  OPER_NUM=?";
	
	//Added Against ML-MMOH-CRF-1979-US02...starts
	
	String defaultDate = "";
	String defaultTime = "";
	String disable_flag2="";
	if(isMandateEffortEstimation) 
		disable_flag2="disabled";
	else 
		disable_flag2="";
	String mandate_eff_estimation_yn = "N"; 
	String check_out_time = "";
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	String sql2 = "Select CHECK_OUT_TIME,CHECK_IN_TIME,TO_CHAR(sysdate,'DD/MM/YYYY HH24:MI') from OT_POST_OPER_HDR where OPERATING_FACILITY_ID=? AND  OPER_NUM=?";
		
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	//CHL-CRF-0020
	PreparedStatement pstmt1 = null;
	ResultSet rst1 = null;
	//CHL-CRF-0020
	try{
		con = ConnectionManager.getConnection(request);
		
		mandate_eff_estimation_yn = checkForNull(bean.getMandateEffEstimation(facility_id)); //Added Against ML-MMOH-CRF-1979-US02
		System.err.println("mandate_eff_estimation_yn === "+mandate_eff_estimation_yn); //Added Against ML-MMOH-CRF-1979-US02
				
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();	 
		while(rst.next()){
           check_out_time = CommonBean.checkForNull(rst.getString(1));
           check_in_time = CommonBean.checkForNull(rst.getString(2));
           sysdate = CommonBean.checkForNull(rst.getString(3));
		}
	
	defaultDate = sysdate.substring(0,10);
	defaultTime = sysdate.substring(11,16);
	//Added Against ML-MMOH-CRF-1979-US02...ends
		 pstmt=con.prepareStatement(sql_sm_report); // Added for IN:046182
		 rst=pstmt.executeQuery();
		 if(rst !=null && rst.next())
	    {
	    customer_id1=CommonBean.checkForNull(rst.getString("customer_id"));
	    }	
	    if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();// End for IN:046182
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();	 
		while(rst.next()){
           db_speciality_code=rst.getString(1);
		}

		if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
				if(rst!=null)rst.close();
				if(rst1!=null)rst1.close();
					if(pstmt!=null)pstmt.close();
				out.println("<script>assignRecId()</script>");
				out.println("<script>refresh()</script>");
			//CHL-CRF-0020 

            _bw.write(_wl_block14Bytes, _wl_block14);
if(isMandateEffortEstimation){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(mandate_eff_estimation_yn.equals("Y")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag2));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(isMandateEffortEstimation){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
if(mandate_eff_estimation_yn.equals("Y")){
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
	  
					String SQL ="SELECT ROLE_DESC,ROLE_ID ,ROLE_TYPE FROM OT_ROLES_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(APPL_TO_OT_SLATE,'N') = 'N' AND NVL(STATUS,'E') = 'E'";
					String val = "";
		
					pstmt = con.prepareStatement(SQL) ;
					rst = pstmt.executeQuery();
					while(rst.next()){
						val = rst.getString("ROLE_ID")+"##"+rst.getString("ROLE_TYPE");
						
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(val));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rst.getString("ROLE_DESC")));
            _bw.write(_wl_block31Bytes, _wl_block31);
	}
			
			
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block35Bytes, _wl_block35);
if(isMandateEffortEstimation){
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(defaultDate));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(defaultTime));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(mandate_eff_estimation_yn.equals("Y")){
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(defaultDate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(defaultTime));
            _bw.write(_wl_block44Bytes, _wl_block44);
if(mandate_eff_estimation_yn.equals("Y")){
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
 if(customer_id1.equalsIgnoreCase("MOHBR")){ // Added for IN:046182
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( theatre_date ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(oper_room_code ));
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
if(isMandateEffortEstimation){
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block53Bytes, _wl_block53);
}else{
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block58Bytes, _wl_block58);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(db_speciality_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(refresh_flag));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(check_in_time));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(check_out_time));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mandate_eff_estimation_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(isMandateEffortEstimation));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(CommonBean.checkForNull(request.getParameter("tab_id"))));
            _bw.write(_wl_block74Bytes, _wl_block74);


	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Operation.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Team.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TimeIn.Label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TimeOut.Label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
