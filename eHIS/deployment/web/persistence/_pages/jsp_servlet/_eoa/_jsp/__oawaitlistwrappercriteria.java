package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __oawaitlistwrappercriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OAWaitListWrapperCriteria.jsp", 1717484275861L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 =" \n<html>  \n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"> </script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\t\t<script>\n\t\t\tfunction loadWaitListCriteria(){\n\t\t\t\tdocument.forms[0].b_loc_val.disabled=true;\n\t\t\t\tdocument.forms[0].b_loc_search.disabled=true;\n\t\t\t\tdocument.forms[0].practitioner_name.disabled=true;\n\t\t\t\tdocument.forms[0].search_resource.disabled=true;\n\t\t\t\tif(document.forms[0].rd_appt_yn.value ==\"Y\"){\n\t\t\t\t\tdocument.forms[0].location_type.value=\"E\";\n\t\t\t\t\tdocument.forms[0].resource_type.selectedIndex=2;\n\t\t\t\t\tdocument.forms[0].location_type.disabled=true;\n\t\t\t\t\tdocument.forms[0].resource_type.disabled=true;\n\t\t\t\t\tdocument.forms[0].location.value=document.forms[0].clinnic_code.value;\n\t\t\t\t\tdocument.forms[0].b_loc_val.value=document.forms[0].clinic_name_sec.value;\n\t\t\t\t\tdocument.forms[0].practitioner_name.disabled=false;\n\t\t\t\t\tdocument.forms[0].search_resource.disabled=false;\n\t\t\t\t}\n\t\t\t\tvar specialty_code \t= document.waitlist_criteria.specialty_code.value;\n\t\t\t\tvar wtListControl \t= document.waitlist_criteria.wtListControl.value;\n\t\t\t\t//url=\'../../eOA/jsp/WaitListMgmtQueryResult.jsp?specCode=\'+specialty_code+\'&wtListControl=\'+wtListControl+\"&cliniccode=\"+document.forms[0].clinnic_code.value+\"&rd_appt_yn=\"+document.forms[0].rd_appt_yn.value;\n\t\t\t\turl=\'../../eOA/jsp/WaitListMgmtQueryResult.jsp?specCode=\'+specialty_code+\'&wtListControl=\'+wtListControl+\"&rd_appt_yn=\"+document.forms[0].rd_appt_yn.value;\n\t\t\t\tparent.frames[2].location.href=url;\n\t\t\t}\n\t\t\tfunction dispWaitListResult(){\n\t\t\t\tvar specialty_code \t= document.waitlist_criteria.specialty_code.value;\n\t\t\t\tvar clinic_type \t= document.waitlist_criteria.location_type.value;\n\t\t\t\tvar cliniccode\t\t= document.waitlist_criteria.location.value;\n\t\t\t\tvar resource_type\t= document.waitlist_criteria.resource_type.value;\n\t\t\t\tvar practitioner\t= document.waitlist_criteria.practitioner.value;\n\t\t\t\tvar wtListControl \t= document.waitlist_criteria.wtListControl.value;\n\t\t\t\turl=\'../../eOA/jsp/WaitListMgmtQueryResult.jsp?specCode=\'+specialty_code+\'&clinic_type=\'+clinic_type+\'&cliniccode=\'+cliniccode+\"&res_type=\"+resource_type+\'&practitioner=\'+practitioner+\'&wtListControl=\'+wtListControl+\"&practitioner_id=\"+document.waitlist_criteria.practitioner_id.value+\"&appt_date=\"+document.waitlist_criteria.appt_date.value+\"&no_of_slots=\"+document.waitlist_criteria.no_of_slots.value;\n\t\t\t\tparent.frames[2].location.href=url;\n\t\t\t}\n\t\t\tfunction enable_dsiable_res(obj){\n\t\t\t\t//var specialty=document.forms[0].speciality.value;\n\t\t\t\t//document.getElementById(\"specialty_code1\").value = specialty;\n\t\t\t\tvar res_value=obj.value;\n\t\t\t\tdocument.forms[0].practitioner_name.value=\"\";\n\t\t\t\tdocument.forms[0].practitioner.value=\"\";\n\t\t\t\tif(res_value==\"\" ){\n\t\t\t\t\tdocument.forms[0].practitioner_name.disabled=true;\n\t\t\t\t\tdocument.forms[0].search_resource.disabled=true;\n\t\t\t\t}else{\n\t\t\t\t\tdocument.forms[0].resourceType1.value=res_value;\n\t\t\t\t\t/*document.forms[0].resourceType_1.value=res_value;\n\t\t\t\t\tif(document.forms[0].clinic.value==\"\"){\n\t\t\t\t\t\tdocument.forms[0].location_code1.value=\"Y$\";\n\t\t\t\t\t}*/\n\t\t\t\t\tdocument.forms[0].practitioner_name.disabled=false;\n\t\t\t\t\tdocument.forms[0].search_resource.disabled=false;\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction locationTypeChange(obj){\n\t\t\t\tdocument.forms[0].location.value=\'\';\n\t\t\t\tdocument.forms[0].b_loc_val.value=\'\';\n\t\t\t\tif(obj.value==\'\'){\n\t\t\t\t\tdocument.forms[0].b_loc_val.disabled=true;\n\t\t\t\t\tdocument.forms[0].b_loc_search.disabled=true;\n\t\t\t\t}else{\n\t\t\t\t\tdocument.forms[0].b_loc_val.disabled=false;\n\t\t\t\t\tdocument.forms[0].b_loc_search.disabled=false;\n\t\t\t\t}\n\t\t\t\t/*document.forms[0].locationType.selectedIndex=0;\n\t\t\t\tdocument.forms[0].resourceType.value=\'\';\n\t\t\t\tdocument.forms[0].practitioner_name.value=\'\';\n\t\t\t\tdocument.forms[0].b_pract.value=\'\';\n\t\t\t\tdocument.forms[0].practitioner_name.disabled=true;\n\t\t\t\tdocument.forms[0].search_pract.disabled=true;\n\t\t\t\tdocument.forms[0].resourceType.disabled=true;\n\t\t\t\tdocument.getElementById(\"pract_type1\").innerHTML=\"\";\n\t\t\t\tif (obj.value==\'\')\n\t\t\t\t{\n\t\t\t\tObj=document.forms[0].locationType;\n\t\t\t\twhile(Obj.options.length >0 ) Obj.remove(Obj.options[0]);\n\t\t\t\topt=document.createElement(\'OPTION\');\n\t\t\t\topt.value=\'\';\n\t\t\t\topt.text=\"----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"----\";\n\t\t\t\tObj.add(opt);\n\t\t\t\t}\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\';*/\n\t\t\t}\n\t\t\t\n\t\t\tasync function location_search_lookup(){\t\n\t\t\t\tvar location_val=document.forms[0].b_loc_val.value;\n\t\t\t\tvar locn_type=document.forms[0].location_type.value;\n\t\t\t\tvar care_locn_ind=document.forms[0].location_type.value;\n\t\t\t\tvar specialty_code=document.forms[0].specialty_code.value;\n\t\t\t\t//var dialogTop = \"60\" ;\n\t\t\t\t//var dialogHeight= \"37\" ;\n\t\t\t\t//var dialogWidth\t= \"60\" ;\n\t\t\t\tvar dialogTop = \"10px\" ;\n\t\t\t\tvar dialogHeight= \"400px\" ;\n\t\t\t\tvar dialogWidth\t= \"700px\" ;\n\t\t\t\tvar status = \"no\";\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tvar tit=\"locn_Srch\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\t\tvar retVal=\"\";\n\t\t\t\tretVal = await window.showModalDialog(\"../../eOA/jsp/OALocationlookupframe.jsp?locn_type=\"+locn_type+\"&location_val=\"+encodeURIComponent(location_val)+\"&care_locn_ind=\"+care_locn_ind+\"&speciality_code=\"+specialty_code+\"&function_id=WAIT_LIST\",arguments,features);\n\t\t\t\tif(retVal!=null){\t\n\t\t\t\t\tvar rvalues=retVal.split(\"~\");\n\t\t\t\t\tvar clinic_code=rvalues[0];\n\t\t\t\t\tvar desc=rvalues[1];\n\t\t\t\t\tvar open_to_all_pract_yn=rvalues[2];\n\t\t\t\t\tvar clinic_type=rvalues[3];\n\t\t\t\t\tvar ident_at_checkin=rvalues[4];\n\t\t\t\t\tvar fi_visit_type_appl_yn=rvalues[5];\n\t\t\t\t\tvar alcn_criteria=rvalues[6];\n\t\t\t\t\tvar STime=rvalues[7];\n\t\t\t\t\tvar ETime=rvalues[8];\n\t\t\t\t\tvar dur=rvalues[9];\n\t\t\t\t\tdocument.forms[0].b_loc_val.value=desc;\n\t\t\t\t\tdocument.forms[0].location.value=clinic_code;\n\t\t\t\t\tdocument.forms[0].open_to_all_pract_yn.value=open_to_all_pract_yn;\n\t\t\t\t}else{\t\n\t\t\t\t\tdocument.forms[0].b_loc_val.value=\"\";\n\t\t\t\t\tdocument.forms[0].location.value=\"\";\n\t\t\t\t\t/*document.forms[0].resourceType.value=\"\";\n\t\t\t\t\tdocument.getElementById(\"resourceType\").disabled=true;\n\t\t\t\t\tdocument.forms[0].practitioner_name.value=\"\";\n\t\t\t\t\tdocument.forms[0].practitioner_name.disabled=true;\n\t\t\t\t\tdocument.forms[0].search_pract.disabled=true;\n\t\t\t\t\tparent.frames[1].document.forms[0].resourceType.value=\"\";\n\t\t\t\t\tparent.frames[1].document.getElementById(\"pract_type1\").innerHTML=\"\";\n\t\t\t\t\tvar location_val=document.forms[0].b_loc_val.value;*/\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction location_search(obj){\n\t\t\t\tif(obj.value==null || obj.value==\"\"){\n\t\t\t\t\tdocument.forms[0].b_loc_val.value=\"\";\n\t\t\t\t\tdocument.forms[0].location.value=\"\";\n\t\t\t\t\tdocument.forms[0].open_to_all_pract_yn.value=\"\";\n\t\t\t\t\t/*document.forms[0].resourceType.value=\"\";\n\t\t\t\t\tdocument.forms[0].locationType.value=\"\";\n\t\t\t\t\tdocument.getElementById(\"resourceType\").disabled=true;\n\t\t\t\t\tdocument.forms[0].practitioner_name.value=\"\";\n\t\t\t\t\tdocument.forms[0].practitioner_name.disabled=true;\n\t\t\t\t\tdocument.forms[0].search_pract.disabled=true;\n\t\t\t\t\tparent.frames[1].document.forms[0].resourceType.value=\"\";\n\t\t\t\t\tparent.frames[1].document.getElementById(\"pract_type1\").innerHTML=\"\";\n\t\t\t\t\tvar location_val=document.forms[0].b_loc_val.value;*/\n\t\t\t\t}else{\n\t\t\t\t\tlocation_search_lookup()\n\t\t\t\t}\n\t\t\t}\t\t\t\n\t\t</script>\n\t</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body onLoad=\"loadWaitListCriteria()\" OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t\t<form name=\'waitlist_criteria\' id=\'waitlist_criteria\'>\n\t\t\t<br>\n\t\t\t<table  border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'60%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' colspan=\'3\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b></td>\n\t\t\t\t\t<td nowrap class=label ><b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<select name=\'location_type\' id=\'location_type\' onChange=\'locationTypeChange(this)\' tabindex=2><option value=\'\'>---";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="---</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t</select></td>\n\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<input type=\'text\' size=\'25\' maxlength=\'25\' name=\'b_loc_val\' id=\'b_loc_val\' value=\'\' onblur=\"location_search(this)\"><input type=\"hidden\" name=\"location\" id=\"location\" value=\"\"><input type=\'button\' name=\"b_loc_search\" id=\"b_loc_search\" value=\"?\" onClick=\"location_search_lookup()\" class=\'button\'>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'resource_part\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' colspan=\'4\'>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'fields\' >&nbsp;</td><td class=\'button\' align=\'right\'><input type=\'button\' name=\'Search\' id=\'Search\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' class=\'button\' onClick=\'dispWaitListResult();\' tabindex=12><input type=button name=\'Clear\' id=\'Clear\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' class=\'button\' onClick=\'const dialogTag = parent.parent.document.getElementById(\"dialog_tag\"); dialogTag.close();\' tabindex=13></td>\n\t\t\t\t</tr>\n\t\t\t\t\t<input type=\'hidden\' name=\'specialty_code\' id=\'specialty_code\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'wtListControl\' id=\'wtListControl\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'clinnic_code\' id=\'clinnic_code\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'appt_date\' id=\'appt_date\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'no_of_slots\' id=\'no_of_slots\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'res_type\' id=\'res_type\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'clinic_type\' id=\'clinic_type\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'valfrmCrt\' id=\'valfrmCrt\' value=\'checkdata\'>\t\t\t\t\t\n\t\t\t\t\t<input type=\'hidden\' name=\'slot_appt_ctrl\' id=\'slot_appt_ctrl\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'visit_limit_rule\' id=\'visit_limit_rule\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'alcn_criteria\' id=\'alcn_criteria\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'override_no_of_slots_yn\' id=\'override_no_of_slots_yn\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'noshow_ctrl_by_splty_or_clinic\' id=\'noshow_ctrl_by_splty_or_clinic\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'min_ela_per_resc_noshow_in_day\' id=\'min_ela_per_resc_noshow_in_day\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'contact_num_reqd_yn\' id=\'contact_num_reqd_yn\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'no_of_noshow_appts_for_alert\' id=\'no_of_noshow_appts_for_alert\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'per_chk_for_no_show_alert\' id=\'per_chk_for_no_show_alert\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'rule_appl_yn\' id=\'rule_appl_yn\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'create_wait_list_yn\' id=\'create_wait_list_yn\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'install_yn_val\' id=\'install_yn_val\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'book_appt_yn\' id=\'book_appt_yn\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\"\">\n\t\t\t\t\t<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'rd_appt_yn\' id=\'rd_appt_yn\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'clinic_name_sec\' id=\'clinic_name_sec\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t</form>\n\t</body>\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n</html>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );


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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String facilityid=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
		String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user"));	
		String clinnic_code		= checkForNull(request.getParameter("clinnic_code"));
		String clinic_name_sec		= checkForNull(request.getParameter("clinic_name_sec"));
		String wtListControl	= checkForNull(request.getParameter("wtListControl"),"V");
		String rd_appt_yn	= checkForNull(request.getParameter("rd_appt_yn"),"N");
		String practitioner_id		= checkForNull(request.getParameter("practitioner_id"));
		String appt_date		= checkForNull(request.getParameter("appt_date"));
		String no_of_slots		= checkForNull(request.getParameter("no_of_slots"));
		String res_type		= checkForNull(request.getParameter("res_type"));
		String clinic_type		= checkForNull(request.getParameter("clinic_type"));
		String speciality_code 	= "";
		String speciality_desc 	= "";
		try{
			conn=ConnectionManager.getConnection(request);
			String spltySQL = "select speciality_code,Long_desc speciality_desc from am_speciality_lang_vw where speciality_code =(select speciality_code from op_clinic where clinic_code=? and facility_id=?) and language_id=?";
			pstmt=conn.prepareStatement(spltySQL);
			pstmt.setString(1,clinnic_code);
			pstmt.setString(2,facilityid);
			pstmt.setString(3,localeName);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				speciality_code = checkForNull(rs.getString("speciality_code"));
				speciality_desc = checkForNull(rs.getString("speciality_desc"));
			}
			
			String slot_appt_ctrl ="";
			String visit_limit_rule="";
			String alcn_criteria ="";
			String override_no_of_slots_yn="";
			String capture_fin_dtls_yn="";
			String noshow_ctrl_by_splty_or_clinic="";
			String min_ela_per_resc_noshow_in_day="";
			String contact_num_reqd_yn="";
			String no_of_noshow_appts_for_alert="";
			String per_chk_for_no_show_alert="";
			String rule_appl_yn="";
			String oper_stn_id ="";
			String create_wait_list_yn ="";
			String install_yn_val ="";
			String book_appt_yn ="N";
			if(wtListControl !=null && wtListControl.equals("B")){
				if(rs !=null)rs.close();
				pstmt=conn.prepareStatement("select SLOT_APPT_CTRL,VISIT_LIMIT_RULE,ALCN_CRITERIA,OVERRIDE_NO_OF_SLOTS_YN,CAPTURE_FIN_DTLS_YN,NOSHOW_CTRL_BY_SPLTY_OR_CLINIC,MIN_ELA_PER_RESC_NOSHOW_IN_DAY,CONTACT_NUM_REQD_YN,NO_OF_NOSHOW_APPTS_FOR_ALERT,PER_CHK_FOR_NO_SHOW_ALERT,RULE_APPL_YN from oa_param where module_id='OA'");
				rs 	= pstmt.executeQuery();
				if(rs !=null && rs.next()){
					slot_appt_ctrl =rs.getString("SLOT_APPT_CTRL")==null?"":rs.getString("SLOT_APPT_CTRL");
					visit_limit_rule =rs.getString("VISIT_LIMIT_RULE")==null?"":rs.getString("VISIT_LIMIT_RULE");
					alcn_criteria =rs.getString("ALCN_CRITERIA")==null?"":rs.getString("ALCN_CRITERIA");
					override_no_of_slots_yn =rs.getString("OVERRIDE_NO_OF_SLOTS_YN")==null?"":rs.getString("OVERRIDE_NO_OF_SLOTS_YN");
					capture_fin_dtls_yn =rs.getString("CAPTURE_FIN_DTLS_YN")==null?"":rs.getString("CAPTURE_FIN_DTLS_YN");
					noshow_ctrl_by_splty_or_clinic =rs.getString("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC")==null?"":rs.getString("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC");
					min_ela_per_resc_noshow_in_day =rs.getString("MIN_ELA_PER_RESC_NOSHOW_IN_DAY")==null?"":rs.getString("MIN_ELA_PER_RESC_NOSHOW_IN_DAY");
					contact_num_reqd_yn =rs.getString("CONTACT_NUM_REQD_YN")==null?"":rs.getString("CONTACT_NUM_REQD_YN");
					no_of_noshow_appts_for_alert =rs.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT")==null?"":rs.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT");
					per_chk_for_no_show_alert =rs.getString("PER_CHK_FOR_NO_SHOW_ALERT")==null?"":rs.getString("PER_CHK_FOR_NO_SHOW_ALERT");
					rule_appl_yn=rs.getString("RULE_APPL_YN")==null?"":rs.getString("RULE_APPL_YN");
				}
				if(rs !=null)rs.close();
				pstmt=conn.prepareStatement("SELECT (SELECT operational_yn  FROM sm_modules_facility  WHERE facility_id = ? AND module_id = 'OR') or_oper_yn,NVL (create_wait_list_yn, 'N') creat_wt_lst_yn, a.oper_stn_id,NVL (canc_appt_yn, 'N') canc_appt_yn,NVL (tfr_appt_yn, 'N') tfr_appt_yn,NVL (book_appt_yn, 'N') book_appt_yn,TO_CHAR (SYSDATE, 'dd/mm/yyyy') dt FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id = ?  AND a.facility_id = b.facility_id   AND a.oper_stn_id = b.oper_stn_id   AND b.appl_user_id = ?   AND TRUNC (SYSDATE) BETWEEN b.eff_date_from  AND NVL (b.eff_date_to, TRUNC (SYSDATE))");
				pstmt.setString(1,facilityid);
				pstmt.setString(2,facilityid);
				pstmt.setString(3,globaluser);
				rs 	= pstmt.executeQuery();
				if(rs !=null && rs.next()){
					oper_stn_id = rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
					create_wait_list_yn = rs.getString("creat_wt_lst_yn")==null?"":rs.getString("creat_wt_lst_yn");
					install_yn_val = rs.getString("or_oper_yn")==null?"":rs.getString("or_oper_yn");
					book_appt_yn = rs.getString("book_appt_yn")==null?"N":rs.getString("book_appt_yn");
				}
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

						//String sql_locn="Select Locn_Type, Short_Desc, care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y','N') and language_id = '"+locale+"' order by 2";
						String sql_locn="Select Locn_Type, Short_Desc, care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y') and language_id = ? order by 2";
						String locationType="";
						String shortDesc="";
						if(rs !=null)rs.close();
						pstmt=conn.prepareStatement(sql_locn);
						pstmt.setString(1,localeName);
						rs 	= pstmt.executeQuery();
						if (rs!=null){
							while(rs.next()){	
								locationType= rs.getString("care_locn_type_ind");
								shortDesc= rs.getString("Short_Desc");
								out.println("<option value='"+locationType+"'>"+shortDesc+"</option>");
							}
						}
						
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            {java.lang.String __page ="OAResourcelookupframe.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from_page"), weblogic.utils.StringUtils.valueOf("vw_book_appt_wtlist")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(wtListControl));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(clinnic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rule_appl_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(clinic_name_sec));
            _bw.write(_wl_block45Bytes, _wl_block45);
}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(conn,request);
	}
            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}
