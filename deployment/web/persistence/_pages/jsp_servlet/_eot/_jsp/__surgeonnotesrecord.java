package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.CommonBean;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __surgeonnotesrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SurgeonNotesRecord.jsp", 1743149530417L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\' type=\'text/css\'/>\n\t<script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/RecordSurgeon.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"JavaScript\">\n function assignSpeciality(){\n\t\n\tvar formObjHdr = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n\tvar doc_level = formObjHdr.doc_level.value;\n\tif(document.forms[0].tab.value !=\"record_surgeon\")\n\t{\n\t\t\n\tcallPopulateList(doc_level);\n\t}else\n\t{\n\t\t\tif(doc_level==\"IS\")\n\t\t{\n\t\t\t\tvar facility_id=document.forms[0].facility_id.value;\n\t\t\t\tvar db_mode=parent.parent.parent.frames[4].RecordSurgeonTabForm.db_mode.value;\n\t\t\t\tvar status_value=parent.parent.parent.frames[4].RecordSurgeonTabForm.status_value.value;\n\t\t\t\tvar oper_code_all=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_all.value;\n\t\t\t\tvar oper_code_new=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_new.value;\n\t\t\t\tvar spec_code_final=parent.parent.parent.frames[4].RecordSurgeonTabForm.spec_code_final.value;\n\t\t\t\tvar oper_num=document.forms[0].oper_num.value;\n\t\t\t\tvar arr2=oper_code_all.split(\"*\");\n\t\t\t\tvar arr3=status_value.split(\"*\");\n\t\t\t\tvar arr1=db_mode.split(\"*\");\n\t\t\t\tvar oper_code=\"\";\n\t\t\t\tvar chk_status=\"\";\n\t\t\t\tvar db_mode_val=\"\";\n\t\t\t\t\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t    xmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=exist_operation_speciality&spec_code_final=\"+spec_code_final,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tvar arr_spec=retVal.split(\"*\");\n\t\t\t\tvar spec_code_new=\"\";\n\t\t\t\tvar spec_code_old=\"\";\n\t\t\t\tvar arr2_spec=\"\";\n\t\t\t\tvar opt =\"\";\n\t\t\t\tvar ret=\"\";\t\n\t\t\t\tfor (var m=0;m<arr_spec.length-1;m++ )\n\t\t\t\t{\n\t\t\t\t\tspec_code_new=arr_spec[m];\n\t\t\t\t\t arr2_spec=spec_code_new.split(\",\");\n\t\t\t\t\t opt = document.forms[0].document.createElement(\'OPTION\');\n\t\t\t\t\topt.text =arr2_spec[1];\n\t\t\t\t\topt.value=arr2_spec[0];\n\t\t\t\t\tdocument.forms[0].speciality.add(opt);\n\t\t\t\t}\t\t\t\n\t//PMG20089-CRF-0858 - Added Start\n\t /* if(arr2.length > 2 )\n\t {\n\t\tret=confirm(getMessage(\"APP-OT0132\",\"OT\")); \n\t }*/\n\t \n\tif(arr_spec.length == 2)\n\t\t{\n\t\t\tdocument.forms[0].speciality.options[1].selected = true;\n\t\t\tloadNotetype(document.forms[0].speciality);\n\t\t}\n\t\t\t//PMG20089-CRF-0858 - End \n\t}\n\t\telse\n\t\t{\n\t//\tassignListItems(\' ,*ALL\',\"----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"----,All Specialities\");\n\tassignListItems(\'*ALL\',\"All Specialities\");\n\t//\t\tassignListItems(\'*ALL\',);\n\t\t\tvar spec=document.forms[0].speciality;\n\t\t\tdocument.forms[0].speciality.selectedIndex=1;\n\t\t\tloadNotetype(spec);\n\t\t\t\n\t\t}\n\t}\n}\n\nfunction refresh1(){\n\tvar params = document.forms[0].params.value;\n\tparent.parent.parent.common_patient_hdr_frame.location.href=\'../../eOT/jsp/CommonOperDtlsHdr.jsp?\'+params;\n}\n\n\nfunction loadNotetype(obj)\n{\n\tvar formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n\tvar formObjDtl = document.forms[0];\n\tvar title=getLabel(\"eOT.SurgeonNotes.Label\",\"ot\");\n\tvar facility_id = formObj.facility_id.value;//1\n\tvar patient_id = formObj.patient_id.value;//2\n\tvar episode_id = formObj.episode_id.value;//3\n\tvar patient_class = formObj.patient_class.value;//4\n\tvar encounter_id = formObj.encounter_id.value;//5\n\tvar called_from = \"SURGEON_NOTES\";//6\n\tvar accession_num=formObj.oper_num.value;//7\t\n\t//speciality_code=formObj.oper_speciality_code.value;\n\tvar speciality_code=obj.value;//8\n\tvar doc_level = formObj.doc_level.value;//FRONT END VALUE\t\n\tvar document_level = formObj.document_level.value;//BACK END VALUE\t\n//Added on 2/3/2011 by Anitha\n\tvar modified_date = formObjDtl.modified_date.value;\n\tvar ret=\"\";\t\n\tvar locn_type = \"30\";\n\tif(document_level==\'\' && formObj.doc_level.disabled == false) \n\t{\n    if(doc_level==\'IS\')\n\t{\t\t\n\t ret=confirm(getMessage(\"APP-OT0132\",\"OT\"));\n\t}\n\telse if(doc_level==\'AS\')\n\t{\t\t\n     ret=confirm(getMessage(\"APP-OT0131\",\"OT\"));\n\t}\n\t}\n\telse\n\t{\n\t\tret=true;\n\t}\n\t  if(ret==true)\n   {\n\tformObj.doc_level.disabled=true;\n\t\n\tif(document_level==\'\')\n\t{\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=updatedoclevel&facility_id=\"+facility_id+\"&oper_num=\"+accession_num+\"&doc_level=\"+doc_level+\"&document_level=\"+document_level+\"&modified_date=\"+modified_date,false);\n\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText); \n\n\t//refresh1();\n\t}\n\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\nxmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=Surgeon_notes_dispaly&accession_num=\"+accession_num+\"&facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&patient_class=\"+patient_class+\"&encounter_id=\"+encounter_id+\"&called_from=\"+called_from+\"&speciality_code=\"+speciality_code+\"&locn_type=\"+locn_type+\"&slate_user_id=\"+formObjDtl.slate_user_id.value+\"&doc_level=\"+doc_level+\"&document_level=\"+doc_level,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText);\n\tvar arr_spec=retVal.split(\"~\");\n\tvar arr2_spec=\"\";\n\tvar note_type_value=\"\";\n\n\tif(retVal !=\"\")\n\t   {\n\t\t\tvar obj1=document.forms[0].note_type;\n\t  var len =obj1.options.length;\n\t  while (len-- >= 0) obj1.remove(obj1.options[0]);\n\t  opt=document.createElement(\'OPTION\');\n\t  opt.value=\'\';\n\t  opt.text=\"----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"----\";\n\t  obj1.add(opt);\n\n\tfor (var m=0;m<arr_spec.length-1;m++ )\n\t{\n\t\tnote_type_value=arr_spec[m];\n\t\tarr2_spec=note_type_value.split(\",\");\n\t\topt = parent.frames[0].document.createElement(\'OPTION\');\n\t\topt.text =arr2_spec[1];\n\t\topt.value=arr2_spec[0];\n\t\tdocument.forms[0].contr_mod_accession_num.value=arr2_spec[2];\n\t\tparent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.contr_mod_accession_num.value=arr2_spec[2];\n\t\tdocument.forms[0].update_mode.value=arr2_spec[3];\n\t\tdocument.forms[0].accession_num.value=arr2_spec[4];\n\t\tdocument.forms[0].note_type.add(opt);\t\t\n\t}\n\t}else\n\t   {\n\t\tvar obj1=document.forms[0].note_type;\n\t  var len =obj1.options.length;\n\t  while (len-- >= 0) obj1.remove(obj1.options[0]);\n\t  opt=document.createElement(\'OPTION\');\n\t  opt.value=\'\';\n\t  opt.text=\"----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"----\";\n\t  obj1.add(opt);\n\t // obj1.selectedIndex = 1; \n\t   }\n\t  //PMG20089-CRF-0858 - Added by SelvinM\n\t   if(document.forms[0].note_type.options.length == 2)\n\t\t{\n\t\t\tdocument.forms[0].note_type.options[1].selected = true;\n\t\t\tCallnoteswin();\n\t\t}\n\t\t//PMG20089-CRF-0858 - Added by SelvinM\n   }\n    else\t\t\n\t{\n\t//Modified By Muthukumar against Cancel - Undefined on 24/10/11\n\tvar obj1=document.forms[0].speciality;\n\t//Modified By Muthukumar against Cancel - Undefined on 24/10/11\n\tobj1.selectedIndex = 0;\n\t}\n/*   else\n\t{\n\t   alert(\'before\');\n\t   var obj1=document.forms[0].speciality;\n\t    var len =obj1.options.length;\n\t\tif (len == 1) \n\t\t{\n\t  opt=document.createElement(\'OPTION\');\n\t  opt.value=\'\';\n\t  opt.text=\"----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"----\";\n\t  obj1.add(opt);\n\t     obj1.selectedIndex = 1;\n\t  }\n\t\telse\n\t\t\tobj1.selectedIndex = 0;\n\t}*/\n}\n\nasync function Callnoteswin()\n{\n\tvar url=\"\";\n\tvar surgeonNotes    = getLabel(\"eOT.SurgeonNotes.Label\",\"OT\");\n\ttitle = surgeonNotes  ;\n\tvar formObj1=document.forms[0];\n\tvar formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n\tvar facility_id = formObj.facility_id.value;\n\t\tvar note_type= formObj1.note_type.value;\n\t\tvar patient_id = formObj.patient_id.value;\n\t\tvar episode_id = formObj.episode_id.value;\n\t\tvar patient_class = formObj.patient_class.value;\n\t\tvar encounter_id = formObj.encounter_id.value;\n\t\tvar function_id=\"SPCL_NOTE\";\n\t\tvar event_class=\"$PHY$\";\n\t\tvar accession_num=formObj1.accession_num.value;\n\t\tvar window_close=\"Y\";\n\t\tvar ot_speciality_code=formObj.speciality_code.value;\n\t\tvar hide_header=\"N\";\n\t\tvar contr_mod_accession_num = formObj1.contr_mod_accession_num.value;\n\t\tvar tab_yn=\"N\";\n\t\tvar secondwindow;\n\t\tvar locn_type = \"30\";\n\t\tvar episode_type=\"\";\n\t\tvar performed_by_ql=formObj.strUser.value;\n\n\tif(patient_class == \"IP\" || patient_class==\"DC\")\n\t\t\tepisode_type =\"I\";\n\t\tif(patient_class==\"OP\" ||patient_class==\"EM\")\n\t\t\tepisode_type =\"O\";\n\nif(note_type !=\"\")\n\t{\n\t//Added performed_by_ql on 1/19/2011 by Anitha for 25928\n\t\n\t var action_url\t=\t\"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title=\"+encodeURIComponent(title)+\"&note_type=\"+note_type+\"&patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&patient_class=\"+patient_class+\"&function_id=\"+function_id+\"&event_class=\"+event_class+\"&accession_num=\"+accession_num+\"&window_close=\"+window_close+\"&ot_speciality_code=\"+ot_speciality_code+\"&hide_header=\"+hide_header+\"&tab_yn=\"+tab_yn+\"&encounter_id=\"+encounter_id+\"&facility_id=\"+facility_id+\"&contr_mod_accession_num=\"+contr_mod_accession_num+\"&performed_by_ql=\"+performed_by_ql;\n\t \n\t //Sanjay\t \n\t//alert(\"action_url-> \"+ action_url);\n\tvar title1=\"\";\n\n\tvar dialogHeight= \"100\";\n\tvar dialogWidth\t= \"100\";\n\tvar status = \"no\";\n\tvar arguments\t= \"\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t//Sanjay\n//\talert(\"action_url before Modal-> \"+ action_url);\n\tsecondwindow  = await window.showModalDialog(action_url, title1, features);\n\t}\n\n//\tCommented by DhanasekarV against incident - IN026701\n\tvar obj1=document.forms[0].note_type;\n\t  var len =obj1.options.length;\n\t  while (len-- >= 0) obj1.remove(obj1.options[0]);\n\t  opt=document.createElement(\'OPTION\');\n\t  opt.value=\'\';\n\t  opt.text=\"----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"----\";\n\t  obj1.add(opt);\n\tdocument.forms[0].speciality.selectedIndex=0;\n\t\n}\n/*\n//Function added by Sanjay\nfunction deleteDuplicate()\n{\n\tvar formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n\tvar facility_id = formObj.facility_id.value;\n\tvar oper_num = formObj.oper_num.value;\n\tvar spec_code = formObj.oper_speciality_code.value;\n\tvar contr_mod_accession_num= facility_id+oper_num+spec_code+\"30\";\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=delete_duplicate&facility_id=\"+facility_id+\"&accession_num=\"+contr_mod_accession_num,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText);\n}\n//Changes done by Sanjay Ends here\n*/\n</script>\n<script src=\'../";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<body onLoad=\"assignSpeciality();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name = \"SurgeonNotesChildForm\">\n<input type=\'hidden\' name=params value=\"";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="\" >\n<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<input type=\'hidden\' name=\'tab_id\' id=\'tab_id\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n <tr> \n\t  <td class=\'label\' align=\'right\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\n\t  <td align=\'left\'>\n\t\t <select name=\"speciality\" id=\"speciality\" onchange=\'loadNotetype(this)\'>\n\t\t   <option value=\'\' selected> ------";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="----- </option>\n\t\t </select>\n\t</td>\n\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td>\n\t\t<td class=\"fields\">\t\t\t\n\t\t\t\n\t\t\t<select name=\"note_type\" id=\"note_type\" onchange=\"Callnoteswin()\" > \n\t\t\t<!-- Changes made by Sanjay -->\n\t\t\t<!--\n\t\t\t<select name=\"note_type\" id=\"note_type\" onchange=\"Callnoteswin()\" onblur=\"deleteDuplicate()\">\n\t\t\t-->\n\t\t\t<option value=\"\" selected>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option>\n\t\t\t</select>\n\n\t\t</td>\n\n  </tr>\n</table>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\'hidden\' name=\'tab\' id=\'tab\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\'hidden\' name=\'contr_mod_accession_num\' id=\'contr_mod_accession_num\' value=\"\">\n<input type=\'hidden\' name=\'update_mode\' id=\'update_mode\' value=\"\">\n<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\"\">\n<input type=\'hidden\' name=\'strUser\' id=\'strUser\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<!-- Added modified_date by Anitha as a hidden field on 2/3/2011 -->\n<input type=\'hidden\' name=\'modified_date\' id=\'modified_date\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String locale = (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getParameter("slate_user_id")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getParameter("tab_id")));
            _bw.write(_wl_block9Bytes, _wl_block9);
 
 	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String strUser="";
	String disable_flag="";
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String tab = checkForNull(request.getParameter("tab")); 
	String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
	if(surgeon_doc_comp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";

//Added below slate_user_id_disp on 1/18/2011 by Anitha
 String slate_user_id_disp = checkForNull(request.getParameter("slate_user_id")).toUpperCase();
 if(slate_user_id_disp.equals("")){
	slate_user_id_disp=	(String)session.getValue("login_user");
 }
String modified_date = checkForNull(request.getParameter("modified_date"));
//System.out.println("modified_date   -----------------"+modified_date);
try
	{
		con=ConnectionManager.getConnection(request);

//Added below qry to fetch func_role_id associated to slate user id on 1/18/2011 by Anitha
		stmt=con.prepareStatement("select func_role_id from sm_appl_user_lang_vw where appl_user_id = ? and language_id = ? ");		
		stmt.setString(1,slate_user_id_disp);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();
		if(rs.next()){
			strUser=checkForNull(rs.getString("func_role_id"));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
				
	}catch(Exception e){
		System.err.println("Error In SurgeonNotesRecord.jsp   "+e);
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
			
		}catch(Exception e){}
	}

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strUser));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(modified_date));
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
