package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __reppatdischarge extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/RepPatDischarge.jsp", 1720631660146L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\t\n<HEAD>\n<TITLE></TITLE>\n<link rel=\"stylesheet\" type=\"text/css\" href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\'javascript\'></script>\n<script src=\"../../eCommon/js/common.js\" language=\'javascript\'></script>\n<script src=\"../../eCommon/js/DateUtils.js\" language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\n\n function validate_date(obj) {\n\t\n\t\tif(obj.value!=\'\'){\n\n\t\t\tif(isBeforeNow(obj.value,\"DMY\",localeName))\n\t\t\t\treturn true;\n\t\t\telse {\n\t\t\t\talert(getMessage(\"START_DATE_GREATER_SYSDATE\",\"COMMON\"));\n\t\t\t\tobj.select();\n\t\t\t\tobj.focus();\n\t\t\t\treturn false ;\n\t\t\t}\n\t\t}\n  }\n  \n   function validate_date1(obj) {\n\t\n\t\tif(obj.value!=\'\'){\n\n\t\t\tif(isBeforeNow(obj.value,\"DMYHM\",localeName))\n\t\t\t\treturn true;\n\t\t\telse {\n\t\t\t\talert(getMessage(\"START_DATE_GREATER_SYSDATE\",\"COMMON\"));\n\t\t\t\tobj.select();\n\t\t\t\tobj.focus();\n\t\t\t\treturn false ;\n\t\t\t}\n\t\t}\n  }\n\n\nasync function searchCode(obj,target)\n\t{\t\t\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar locale= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"\n\t\t\t/* var dialogHeight= \"28\" ;\n\t\t\tvar dialogWidth\t= \"43\" ; */\n\t\t\tvar dialogTop = \"10px\" ;\n\t\t\tvar dialogHeight= \"400px\" ;\n\t\t\tvar dialogWidth=\"900px\";\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar sql=\"\";\n\t\t\tvar search_code=\"\";\n\t\t\tvar search_desc=\"\";\n\t\t\tvar tit=\"\";\n\t\n\t\t\tif(obj.name==\"company_id\")\n\t\t\t{\n\t\t\t\ttit=getLabel(\'eBL.CompanyName.label\',\'bl\')\n\t\t\t\tvar group_id=document.getElementById(\"p_company_group\").value;\n\t\t\t\t\n\t\t\t\tif(group_id==\"\"){\n\t\t\t\t\tsql=\"SELECT cust_code,long_name FROM ar_customer_lang_vw  where language_id =`\"+locale+\"` \";\n\t\t\t\t\tsearch_code=\"cust_code\";\n\t\t\t\t    search_desc= \"long_name\";\n\t\t\t\t}else{\n\t\t\t\t     sql=\"select a.cust_code ,a.long_name FROM AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d where a.acc_entity_code= b.acc_entity_code AND b.acc_entity_code= d.acc_entity_code AND a.language_id = b.language_id AND b.cust_group_code = d.cust_group_code AND a.cust_group_code = b.cust_group_code AND a.cust_code = d.cust_code AND a.patient_flag = `Y` AND NVL(a.pat_com_flag,`N`) = `N` AND NVL(a.insurance_yn,`Y`) = `Y` AND a.language_id=`\"+locale+\"` AND b.cust_group_code =`\"+group_id+\"`\";\n\t\t\t\t\tsearch_code=\"d.cust_code\";\n\t\t\t\t    search_desc= \"long_name\";\n\t\t\t\t}\t\t\t\t\n\t\t\t\t\n\t\t\t}\n\t\t\tif(obj.name==\"company_group_id\")\n\t\t\t{\n\t\t\t\ttit=getLabel(\'Common.CompanyGroup.label\',\'common\');\n\t\t\t\tsql=\"select cust_group_code,short_desc from ar_cust_group_lang_vw where language_id=`\"+locale+\"` \";\n\t\t\t\tsearch_code=\"cust_group_code\";\n\t\t\t\tsearch_desc= \"short_desc\";\n\t\t\t}\n\t\t\tif(obj.name==\"nursing_unit_code\")\n\t\t\t{\n\t\t\t\ttit=getLabel(\'Common.nursingUnit.label\',\'common\');\n\t\t\t\tsql=\"select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10_0 ="` and language_id=`\"+locale+\"` \";\n\t\t\t\tsearch_code=\"nursing_unit_code\";\n\t\t\t\tsearch_desc= \"short_desc\";\n\t\t\t}\n\t\t\tif(obj.name==\"cash_group_id\"){\n\t\t\ttit=getLabel(\'Common.CashGroup.label\',\'common\');\n\t\t\tsql=\"SELECT BLNG_GRP_ID,SHORT_DESC FROM bl_blng_grp_lang_vw where settlement_ind =`C` and language_id=`\"+locale+\"` \";\n\t\t\t    search_code=\"blng_grp_id\";\n\t\t\t\tsearch_desc= \"short_desc\";\n\t\t\t}\n\t\t\t\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\tretVal = await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit),arguments,features);\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\ttarget.value=retVal;\n\t\t\t}\n\t\t\telse\n\t\t\t\ttarget.focus();\n\t}\n\n\t\n\t function showHide()\n        {\n\t\t document.getElementById(\'adm_id\').checked=true;\n\t\t document.getElementById(\'dis_id\').checked=false;\n\t\t \n\t\t\t\tif(document.getElementById(\'adm_id\').checked)\n\t\t\t\t{   \n\t\t\t\t\tdocument.getElementById(\'adm_date_id\').style.visibility = \'visible\';\n\t\t\t\t\tdocument.getElementById(\'dis_date_id\').style.visibility = \'hidden\';\n\t\t\t\t\tdocument.getElementById(\'adm_order_id\').style.visibility = \'visible\';\n\t\t\t\t\tdocument.getElementById(\'adm_order_id1\').style.visibility = \'hidden\';\n\t\t\t\t\tdocument.getElementById(\'dis_group_id\').style.visibility = \'visible\';\n\t\t\t\t\tdocument.getElementById(\'dis_group_id1\').style.visibility = \'hidden\';\n\t\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\'CashGroup_disp_yn\').style.visibility = \'hidden\';\n\t\t\t                document.getElementById(\'CashPatient_td1\').style.display = \'none\';\n\t\t\t\t\tdocument.getElementById(\'CashGroup_td1\').style.display = \'none\';\n\t\t\t\t\t document.getElementById(\'CashPat_id\').checked=false;\n\t\t\t\t\t\n\t\t\t\t\tif(document.getElementById(\'CashPat_id\').checked==false){ \n\t\t\t\t\tdocument.getElementById(\"CompanyGroup\").style.display = \"\";\n\t\t\t\t\tdocument.getElementById(\"CompanyName\").style.display = \"\";\n\t\t\t\t\tdocument.getElementById(\"CashGroup_disp_yn\").style.visibility = \'hidden\';\n\t\t\t\t\tdocument.getElementById(\"CashPatient_td1\").style.display = \"none\";\n\t\t\t\t\tdocument.getElementById(\"CompanyGroup_id\").style.display = \"\";\n\t\t\t\t\t }\n\t\t\t\t\t document.getElementById(\"current_IP\").style.display =\"\";\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\'dis_hid\').style.display = \"none\";\n\t\t\t\t\tdocument.getElementById(\'adm_hid\').style.display = \"\";\n\t\t\t\t\tdocument.getElementById(\'order_hide\').style.display = \"\";\n\t\t\t\t\tdocument.getElementById(\'group_hide\').style.display = \"none\";\n\t\t\t\t\tdocument.getElementById(\"dis_date_from\").value=\"\";\n\t\t\t\t    document.getElementById(\"dis_date_to\").value=\"\";\n\t\t\t\t\tdocument.getElementById(\"p_company_group\").value=\"\";\n\t\t\t\t    document.getElementById(\"p_company_name\").value=\"\";\n\t\t\t\t\tdocument.getElementById(\"p_to_nursing_unit\").value=\"\";\n\t\t\t\t    document.getElementById(\"p_fm_nursing_unit\").value=\"\";\n\t\t\t\t\tdocument.getElementById(\"currentIP_id\").checked=false\n\t\t\t\t\t document.getElementById(\'adm_mand_1\').style.display=\"\" \n\t\t                         document.getElementById(\'adm_mand_2\').style.display=\"\" \n\t\t\t\t\t\n\t\t\t\n\t\t\t\t\n\t\t\tfields = new Array(getLabel(\"eBL.CompanyName.label\",\"bl\"),getLabel(\"Common.admissiondate.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.PatientName.label\",\"Common\"))\n\t\t\tvar selected =document.forms[0].p_adm_order_by;                \n\t\t    var order_length=selected.length\n\t\t\tvar order_lengths=1;\n\t\t\tfor(i=0; i<order_length; i++)\n\t\t\tselected.remove(selected.options[i]);\n\t\t\n\t\t\tfor(i=0; i<fields.length; i++){\n\t\t\tvar x = document.getElementById(\"p_adm_order_by\");\n            var option = document.createElement(\"option\");\n\t\t    option.value = \"\";\n\t\t    \n\t\t\toption.value=order_lengths++;\n\t\t\toption.text=fields[i]\n\t\t\t\n\t\t\tx.add(option);} \n\t\t\t\n\t\t\t\n\t\t\tfields = new Array(getLabel(\"eBL.CompanyName.label\",\"bl\"),getLabel(\"Common.CompanyGroup.label\",\"Common\"),getLabel(\"Common.admissiondate.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"))\n\t\t\tvar selected =document.forms[0].p_adm_group_by;                \n\t\t    var order_length=selected.length\n\t\t\tvar order_lengths=1;\n\t\t\tfor(i=0; i<order_length; i++)\n\t\t\tselected.remove(selected.options[i]);\n\t\t\n\t\t\tfor(i=0; i<fields.length; i++){\n\t\t\tvar x = document.getElementById(\"p_adm_group_by\");\n            var option = document.createElement(\"option\");\n\t\t    option.value = \"\";\n\t\t  \n\t\t\toption.value=order_lengths++;\n\t\t\toption.text=fields[i]\n\t\t\n\t\t\tx.add(option);} \n\t\t\t\t\n\t\t\t\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\'p_cash_group\').value=\"\";\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction showHide1()\n\t\t\t{\n\t\t\tdocument.getElementById(\'dis_id\').checked=true;\n\t\t\tdocument.getElementById(\'adm_id\').checked=false;\n\t\t\t\n\t\t\t   if(document.getElementById(\'dis_id\').checked)\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'dis_date_id\').style.visibility = \'visible\';\n\t\t\t\t\tdocument.getElementById(\'adm_date_id\').style.visibility = \'hidden\';\n\t\t\t\t\tdocument.getElementById(\'adm_order_id\').style.visibility = \'hidden\';\n\t\t\t\t\tdocument.getElementById(\'adm_order_id1\').style.visibility = \'visible\';\n\t\t\t\t\tdocument.getElementById(\'dis_group_id\').style.visibility = \'hidden\';\n\t\t\t\t\tdocument.getElementById(\'dis_group_id1\').style.visibility = \'visible\';\n\t\t\t\t\t\n\t\t\t\t\t document.getElementById(\'CashPat_id\').checked=false;\n\t\t\t\t\t  if(document.getElementById(\'CashPat_id\').checked==false){  \n\t\t\t\t\tdocument.getElementById(\"CompanyGroup\").style.display = \"\";\n\t\t\t\t\tdocument.getElementById(\"CompanyName\").style.display = \"\";\n\t\t\t\t\tdocument.getElementById(\"CashGroup_disp_yn\").style.visibility = \'hidden\';\n\t\t\t\t\tdocument.getElementById(\"CashPatient_td1\").style.display = \"none\";\n\t\t\t\t\tdocument.getElementById(\"CompanyGroup_id\").style.display = \"\";\n\t\t\t\t\t }\n\t\t\t\t\t \n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\'adm_hid\').style.display = \"none\";\n\t\t\t\t\tdocument.getElementById(\'dis_hid\').style.display = \"\";\n\t\t\t\t\tdocument.getElementById(\'order_hide\').style.display = \"none\";\n\t\t\t\t\tdocument.getElementById(\'group_hide\').style.display = \"none\";\n\t\t\t\t\tdocument.getElementById(\"adm_date_from\").value=\"\";\n\t\t\t\t    document.getElementById(\"adm_date_to\").value=\"\";\n\t\t\t\t\tdocument.getElementById(\"p_company_group\").value=\"\";\n\t\t\t\t    document.getElementById(\"p_company_name\").value=\"\";\n\t\t\t\t\tdocument.getElementById(\"p_to_nursing_unit\").value=\"\";\n\t\t\t\t    document.getElementById(\"p_fm_nursing_unit\").value=\"\";\n                   \t\t\t\t\n\t\t\t\t\tdocument.getElementById(\"current_IP\").style.display =\"none\";\n\t\t\t\t\t\tdocument.getElementById(\"currentIP_id\").checked=false\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\tfields = new Array(getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"eBL.CompanyName.label\",\"bl\"),getLabel(\"Common.dischargedate.label\",\"Common\"),getLabel(\"Common.PatientName.label\",\"Common\"))\n\t\t\t\tvar selected =document.forms[0].p_dis_order_by;                \n\t\t\t\tvar order_length=selected.length\n\t\t\t\tvar order_lengths=1;\n\t\t\t\tfor(i=0; i<order_length; i++)\n\t\t\t\tselected.remove(selected.options[i]);\n\t\t\n\t\t\t\tfor(i=0; i<fields.length; i++){\n\t\t\t\tvar x = document.getElementById(\"p_dis_order_by\");\n\t\t\t\tvar option = document.createElement(\"option\");\n\t\t\t\toption.value = \"\";\n\t\t\t\n\t\t\t\toption.value=order_lengths++;\n\t\t\t\toption.text=fields[i]\n\t\t\t\n\t\t\t\tx.add(option);} \n\t\t\t\n\t\t\t\n\t\t\t\tfields = new Array(getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.dischargedate.label\",\"Common\"),getLabel(\"eBL.CompanyName.label\",\"bl\"),getLabel(\"Common.CompanyGroup.label\",\"Common\"))\n\t\t\t\tvar selected =document.forms[0].p_dis_group_by;                \n\t\t\t\tvar order_length=selected.length\n\t\t\t\tvar order_lengths=1;\n\t\t\t\tfor(i=0; i<order_length; i++)\n\t\t\t\tselected.remove(selected.options[i]);\n\t\t\t\n\t\t\t\tfor(i=0; i<fields.length; i++){\n\t\t\t\tvar x = document.getElementById(\"p_dis_group_by\");\n\t\t\t\tvar option = document.createElement(\"option\");\n\t\t\t\toption.value = \"\";\n\t\t\t\n\t\t\t\toption.value=order_lengths++;\n\t\t\t\toption.text=fields[i]\n\t\t\t\n\t\t\t\tx.add(option);} \n\t\n\t\t\t\tdocument.getElementById(\'p_cash_group\').value=\"\";\n\t\t\t\t}\n           }\n\t\t   \nfunction fields_disable(obj){\n\t\t   \n\t\t\tif(obj.checked==true){\n\t\t\n\t\t\tdocument.getElementById(\"CompanyGroup\").style.display = \"none\";\n\t\t\tdocument.getElementById(\"CompanyName\").style.display = \"none\";\n\t\t\tdocument.getElementById(\"CashGroup_disp_yn\").style.visibility = \'visible\';\n\t\t\tdocument.getElementById(\"CashPatient_td1\").style.display = \"\";\n\t\t\t\n\t\t\tdocument.getElementById(\"CompanyGroup_id\").style.display = \"none\";\n\t\t\t\n\t\t\t\n\t\t\tfields = new Array(getLabel(\"Common.CashGroup.label\",\"Common\"),getLabel(\"Common.admissiondate.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.PatientName.label\",\"Common\"))\n\t\t\tvar selected =document.forms[0].p_adm_order_by;                \n\t\t    var order_length=selected.length\n\t\t\tfor(i=0; i<order_length; i++)\n\t\t\tselected.remove(selected.options[i]);\n\t\t\torder_length=order_length+1;\n\t\t\tfor(i=0; i<fields.length; i++){\n\t\t\tvar x = document.getElementById(\"p_adm_order_by\");\n            var option = document.createElement(\"option\");\n\t\t    option.value = \"\";\n\t\t    order_lengths=order_length++;\n\t\t\toption.value=order_lengths;\n\t\t\toption.text=fields[i]\n\t\t\tx.add(option);} \n\t\t\t\t \n\t\t\t\t \n\t\t   \tfields1 = new Array(getLabel(\"Common.CashGroup.label\",\"Common\"),getLabel(\"Common.admissiondate.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"))\n\t\t   \tvar selected1 =document.forms[0].p_adm_group_by; \n\t\t    var order_length1=selected1.length\n\t\t    for(i=0; i<order_length1; i++)\n\t\t    selected1.remove(selected1.options[i]);\n\t\t    order_length1=order_length1+1;     \n\t\t    for(i=0; i<fields1.length; i++){\n\t\t\tvar x = document.getElementById(\"p_adm_group_by\");\n            var option = document.createElement(\"option\");\n\t\t\toption.value = \"\";\n\t\t\torder_lengths=order_length1++;\n\t\t\toption.value=order_lengths;\n\t\t    option.text=fields1[i]\n\t\t\tx.add(option);} \n\t\t  \n\t\t   \n\t\t    fields2 = new Array(getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.CashGroup.label\",\"Common\"),getLabel(\"Common.dischargedate.label\",\"Common\"),getLabel(\"Common.PatientName.label\",\"Common\"))\n\t\t\tvar selected2 =document.forms[0].p_dis_order_by;                \n\t\t    var order_length2=selected2.length;\n\t\t\tfor(i=0; i<order_length2; i++)\n\t\t\tselected2.remove(selected2.options[i]);\n\t\t\t//order_length2=order_length2+1;\n\t\t\torder_length2=order_length2+2;     //modified by Sangeetha on 4/8/2016\n\t\t\tfor(i=0; i<fields2.length; i++){\n\t\t\tvar x = document.getElementById(\"p_dis_order_by\");\n            var option = document.createElement(\"option\");\n\t\t    option.value = \"\";\n\t\t    order_lengths=order_length2++;\n\t\t\toption.value=order_lengths;\n\t\t\toption.text=fields2[i]\n\t\t\n\t\t\tx.add(option);}  \n\t\t\t\n\t\t\t\n\t\t\tfields1 = new Array(getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.dischargedate.label\",\"Common\"),getLabel(\"Common.CashGroup.label\",\"Common\",\"Common\"))\n\t\t   \tvar selected1 =document.forms[0].p_dis_group_by; \n\t\t    var order";
    private final static byte[]  _wl_block10_0Bytes = _getBytes( _wl_block10_0 );

    private final static java.lang.String  _wl_block10_1 ="_length1=selected1.length\n\t\t    for(i=0; i<order_length1; i++)\n\t\t    selected1.remove(selected1.options[i]);\n\t\t    //order_length1=order_length1+1;\n\t\t\torder_length1=order_length1+2;      // modified by Sangeetha on 4/8/2016\n\t\t    for(i=0; i<fields1.length; i++){\n\t\t\tvar x = document.getElementById(\"p_dis_group_by\");\n            var option = document.createElement(\"option\");\n\t\t\toption.value = \"\";\n\t\t\torder_lengths=order_length1++;\n\t\t\toption.value=order_lengths;\n\t\t    option.text=fields1[i]\n\t\t\t\n\t\t\tx.add(option);} \n\t\t\t\n\t\t   \n\t\t  \n\t\t\t\n\t\t\t} else{\n\t\t\t\n\t\t\tdocument.getElementById(\"CompanyGroup\").style.display = \"\";\n\t\t\tdocument.getElementById(\"CompanyName\").style.display = \"\";\n\t\t\tdocument.getElementById(\"CashGroup_disp_yn\").style.visibility = \'hidden\';\n\t\t\tdocument.getElementById(\"CashPatient_td1\").style.display = \"none\";\n\t\t\t\n\t\t\tdocument.getElementById(\"CompanyGroup_id\").style.display = \"\";\n\t\t\tdocument.getElementById(\'p_cash_group\').value=\"\";\n\t\t\t \n\t\t\t\n\t\t\tfields = new Array(getLabel(\"eBL.CompanyName.label\",\"bl\"),getLabel(\"Common.admissiondate.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.PatientName.label\",\"Common\"))\n\t\t\tvar selected =document.forms[0].p_adm_order_by;                \n\t\t    var order_length=selected.length\n\t\t\t\n\t\t    for(i=0; i<order_length; i++)\n\t\t\tselected.remove(selected.options[i]);\n\t\t    order_length=1;\n\t\t\tfor(i=0; i<fields.length; i++){\n\t\t    var x = document.getElementById(\"p_adm_order_by\");\n            var option = document.createElement(\"option\");\n\t\t\toption.value = \"\";\n\t\t\torder_lengths=order_length++;\n\t\t\toption.value=order_lengths;\n\t\t\toption.text=fields[i]\n\t\t\tx.add(option);} \n\t\t\t\t \n\t\t\t\t \n\t\t    fields1 = new Array(getLabel(\"eBL.CompanyName.label\",\"bl\"),getLabel(\"Common.CompanyGroup.label\",\"Common\"),getLabel(\"Common.admissiondate.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"))\n\t\t   \tvar selected1 =document.forms[0].p_adm_group_by; \n\t\t    var order_length1=selected1.length\n\t\t    for(i=0; i<order_length1; i++)\n\t\t    selected1.remove(selected1.options[i]);\n\t\t    order_length1=1;     \n\t\t    for(i=0; i<fields1.length; i++){\n\t\t\t\t var x = document.getElementById(\"p_adm_group_by\");\n                   var option = document.createElement(\"option\");\n\t\t\t\t   option.value = \"\";\n\t\t\t\t   order_lengths=order_length1++;\n\t\t\t\t    option.value=order_lengths;\n\t\t\t\t    option.text=fields1[i]\n\t\t\t\t\tx.add(option);\n\t\t\t\t } \n\t\t\n\t\t\t\n\t\t\tfields = new Array(getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"eBL.CompanyName.label\",\"bl\"),getLabel(\"Common.dischargedate.label\",\"Common\"),getLabel(\"Common.PatientName.label\",\"Common\"))\n\t\t\tvar selected =document.forms[0].p_dis_order_by;                \n\t\t    var order_length=selected.length\n\t\t\t\n\t\t    for(i=0; i<order_length; i++)\n\t\t\tselected.remove(selected.options[i]);\n\t\t    order_length=1;\n\t\t\tfor(i=0; i<fields.length; i++){\n\t\t    var x = document.getElementById(\"p_dis_order_by\");\n            var option = document.createElement(\"option\");\n\t\t\toption.value = \"\";\n\t\t\torder_lengths=order_length++;\n\t\t\toption.value=order_lengths;\n\t\t\toption.text=fields[i]\n\t\t\t\n\t\t\tx.add(option);} \n\t\t\t\n\t\t\t\n\t\t\t fields1 = new Array(getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.dischargedate.label\",\"Common\"),getLabel(\"eBL.CompanyName.label\",\"bl\"),getLabel(\"Common.CompanyGroup.label\",\"Common\"))\n\t\t   \tvar selected1 =document.forms[0].p_dis_group_by; \n\t\t    var order_length1=selected1.length\n\t\t    for(i=0; i<order_length1; i++)\n\t\t    selected1.remove(selected1.options[i]);\n\t\t    order_length1=1;     \n\t\t    for(i=0; i<fields1.length; i++){\n\t\t\t\t var x = document.getElementById(\"p_dis_group_by\");\n                   var option = document.createElement(\"option\");\n\t\t\t\t   option.value = \"\";\n\t\t\t\t   order_lengths=order_length1++;\n\t\t\t\t    option.value=order_lengths;\n\t\t\t\t    option.text=fields1[i]\n\t\t\t\t\tx.add(option);\n\t\t\t\t } \n\t\t\t\n\t\t\n\t\t\t\n\t\t\t\n\t\t\t}\n\t\t   }\n\t\t   \n\t\t   function enable_disable(obj){\n\t\t   if(obj.checked==true){\n\t\t  \n\t\t   document.getElementById(\'adm_mand_1\').style.display=\"none\" \n\t\t   document.getElementById(\'adm_mand_2\').style.display=\"none\" \n\t\t   document.getElementById(\'adm_date_from\').value=\"\"\n\t\t   document.getElementById(\'adm_date_to\').value=\"\"\n\t\t \n\t\t   }else{\n\t\t\n\t\t    document.getElementById(\'adm_mand_1\').style.display=\"\" \n\t\t    document.getElementById(\'adm_mand_2\').style.display=\"\" \n\t\t\t  document.getElementById(\'adm_date_from\').value=\"\"\n\t\t\t  document.getElementById(\'adm_date_to\').value=\"\"\n\t\t\t \n\t\t   }\n\t\t    \n\t\t   }\n\t\t   \n</script>\n</HEAD>\n\n<BODY onMouseDown=\'CodeArrest()\' onload=\'showHide()\'  onKeyDown=\'lockKey()\'>\n<br>\n<br>\n<form name=\"Rep2PatDischargeForm\" id=\"Rep2PatDischargeForm\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n";
    private final static byte[]  _wl_block10_1Bytes = _getBytes( _wl_block10_1 );

    private final static java.lang.String  _wl_block11 ="\n           <table width=\'30%\' align=\'center\' valign=\'top\'>\n\n\t\t\t\t<tr>\n\t\t\t\t<td width=\'3%\'><input type=\'radio\' id=\'adm_id\' checked onClick=\"showHide();\"></td>\n\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t\n\t\t\t    <td width=\'3%\'><input type=\'radio\' id=\'dis_id\'  onClick=\"showHide1();\"></td>\n\t\t\t\t<td align=\"center\" width=\'30%\' class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t <tr>\n\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;</td>\n\t\t\t    </tr>\n\t\t</table>\n   <table width=\'80%\' align=\'center\' >\n\n\t\t<th align=\'left\'> ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</th>\n\n\t<tr>\n\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\n\t\t\t<table width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'center\' >\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"center\" width=\"30%\">&nbsp;</td>\n\t\t\t\t\t<td class=\"querydata\" width=\"30%\" style=\"font-weight: bold;\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t<td class=\"querydata\" width=\"40%\" style=\"font-weight: bold;\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t</tr>\n\t\n\t\t\t\t</tr>\t\n\t\t\t\t     <tr id=\'adm_hid\'>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t    \t</tr>\n                 <tr id=\'adm_date_id\'>\n \t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" &nbsp;</td>\n\t\t\t\t\t\t<td width=\'40%\'  >\n\t\t\t\t\t\t\t<input type=text id=\"adm_date_from\"  name=\'p_fm_admission_date\' id=\'p_fm_admission_date\' size=\"16\" maxlength=\"16\" align=\"center\" onblur=\"if(validDateObj(this,\'DMYHM\',localeName))validate_date1(this)\"><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"Rep2PatDischargeForm.p_fm_admission_date.focus();return showCalendar(\'adm_date_from\',\'dd/mm/yyyy\' ,\'hh:mm\',null);\"/>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' id=\"adm_mand_1\"></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\'30%\'> \n\t\t\t\t\t\t\t<input type=text id=\"adm_date_to\"  name=\'p_to_admission_date\' id=\'p_to_admission_date\' size=\"16\" maxlength=\"16\" align=\"center\" onblur=\"if(validDateObj(this,\'DMYHM\',localeName))validate_date1(this)\"><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"Rep2PatDischargeForm.p_to_admission_date.focus();return showCalendar(\'adm_date_to\',\'dd/mm/yyyy\' ,\'hh:mm\',null);\"/>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' id=\"adm_mand_2\"></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n                 \t\t\t\t\n\n\t\t\t\t<tr id=\'dis_date_id\'>\n\t\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" &nbsp;</td>\n\t\t\t\t\t\t<td width=\'30%\'  >\n\t\t\t\t\t\t\t<input type=text id=\"dis_date_from\"  name=\'p_fm_discharge_date\' id=\'p_fm_discharge_date\' size=\"10\" maxlength=\"10\" align=\"center\" onblur=\"if(validDateObj(this,\'DMY\',localeName))validate_date(this)\"><img  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dis_date_from\');\"/>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\'40%\'> \n\t\t\t\t\t\t\t<input type=text id=\"dis_date_to\"  name=\'p_to_discharge_date\' id=\'p_to_discharge_date\' size=\"10\" maxlength=\"10\" align=\"center\" onblur=\"if(validDateObj(this,\'DMY\',localeName))validate_date(this);\"><img  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dis_date_to\');\"/>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n                    <tr id=\'dis_hid\'>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t    \t</tr>\n\t\t\t\t\n\t\t\t\t<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" &nbsp;</td>\n\t\t\t\t\t\t<td width=\'30%\'  >\n\t\t\t\t\t\t\t<input type=text  name=\'p_fm_nursing_unit\' id=\'p_fm_nursing_unit\' id=\'p_fm_nursing_unit\' size=\"15\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_fm_nursing_unit)\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\'40%\'> \n\t\t\t\t\t\t\t<input type=text  name=\'p_to_nursing_unit\' id=\'p_to_nursing_unit\' id=\'p_to_nursing_unit\'size=\"14\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_to_nursing_unit)\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<Td>&nbsp;</td>\n\t\t\t\t</tr>\n            \t\n\t\t\t\t <tr>\n\t\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" &nbsp;</td>\n\t\t\t\t\t\t<td width=\'30%\'>\n\t\t\t\t\t\t\t<input type=checkbox  id=\'CashPat_id\' name=\'CashPat\' id=\'CashPat\'\t onClick=\"fields_disable(this)\" align=\"center\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td id=\"current_IP\" align=\'right\'  class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<input type=checkbox  name=\'current_patient\' id=\'current_patient\' value=\"N\" id=\'currentIP_id\' onClick=\"enable_disable(this)\" align=\"center\"></td>\n\t\t\t\t\t\t\n\t\t\t\t  </tr>\n\t\t\t\t  \t<tr id=\"CashPatient_td1\">\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t <tr id=\'CashGroup_disp_yn\' >\n\t\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" &nbsp;</td>\n\t\t\t\t\t\t<td width=\'30%\'  >\n\t\t\t\t\t\t\t<input type=text  name=\'p_cash_group\' id=\'p_cash_group\' id=\'p_cash_group\' size=\"4\" maxlength=\"2\" align=\"center\"><input type=\'button\' name=\'cash_group_id\' id=\'cash_group_id\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_cash_group)\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t  </tr>\n\t\t\t\t<tr id=\'CashGroup_td1\'>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t <tr id=\"CompanyGroup\">\n\t\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" &nbsp;</td>\n\t\t\t\t\t\t<td width=\'30%\'  >\n\t\t\t\t\t\t\t<input type=text  name=\'p_company_group\' id=\'p_company_group\' id=\'p_company_group\'size=\"4\" maxlength=\"2\" align=\"center\"><input type=\'button\' name=\'company_group_id\' id=\'company_group_id\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_company_group)\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t  </tr>\n\t\t\t\t<tr id=\"CompanyGroup_id\">\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<Td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t        <tr id=\"CompanyName\">\n\t\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" &nbsp;</td>\n\t\t\t\t\t\t<td width=\'30%\'  >\n\t\t\t\t\t\t\t<input type=text  name=\'p_company_name\' id=\'p_company_name\' id=\'p_company_name\' size=\"8\" maxlength=\"8\" align=\"center\"><input type=\'button\' name=\'company_id\' id=\'company_id\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_company_name)\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t  </tr>\n\t\t\t\t<tr id=\'order_hide\'>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<Td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'adm_order_id\'>\n\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" &nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  width=\'30%\' align=\"left\">\n\t\t\t\t\t\t<select id=\'p_adm_order_by\' name=\'p_adm_order_by\' id=\'p_adm_order_by\'>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t<option value=\'2\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<option value=\'3\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<option value=\'4\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr id=\'adm_order_id1\'>\n\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" &nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  width=\'30%\' align=\"left\">\n\t\t\t\t\t\t<select id=\'p_dis_order_by\' name=\'p_dis_order_by\' id=\'p_dis_order_by\'>\n\t\t\t\t\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t<option selected value=\'2\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'group_hide\'>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'dis_group_id\'>\n\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" &nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  width=\'30%\' align=\"left\">\n\t\t\t\t\t\t<select id=\'p_adm_group_by\' name=\'p_adm_group_by\' id=\'p_adm_group_by\'>\n\t\t\t\t\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr  id=\'dis_group_id1\'>\n\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" &nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  width=\'30%\' align=\"left\">\n\t\t\t\t\t\t<select id=\'p_dis_group_by\' name=\'p_dis_group_by\' id=\'p_dis_group_by\'>\n\t\t\t\t\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n                        <option selected value=\'3\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\n\t</td>\n</tr>\n</table>\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t<!-- <INPUT TYPE=\"hidden\" name=\"p_passing_local_date\" id=\"p_passing_local_date\" value=\"N\"> -->\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<INPUT TYPE=\"hidden\" name=\"P_passing_local_date\" id=\"P_passing_local_date\" value=\"Y\">\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" name=\"p_current_patient\" id=\"p_current_patient\"\t\tvalue=\"\">\n\n     <input type=\"hidden\" name=\"p_cash\" id=\"p_cash\"\t\tvalue=\">\n\t<input type=\"hidden\" name=\"CurrentDate\" id=\"CurrentDate\"\t\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\n\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	//String p_report_id		= "IPPDISLT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String isSpltyNurUnitToEnableYNAppl="";//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( p_facility_id));
            _bw.write(_wl_block10_0Bytes, _wl_block10_0);
            _bw.write(_wl_block10_1Bytes, _wl_block10_1);

	Connection con  =  null;
	Statement stmt = null;
	StringBuffer sql1 = new StringBuffer();
	sql1.append("Select PRACT_TYPE, DESC_USERDEF,to_char(sysdate,'dd/mm/yyyy')CurrentDate From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E'  and language_id='"+locale+"' order by 2" );
	ResultSet rset = null;
	String CurrentDate = "";
	
	StringBuffer StrVal = new StringBuffer();

    try
    {
		con  =  ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
		stmt = con.createStatement(); 
		rset = stmt.executeQuery(sql1.toString());


		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append(" <option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option> ");
				CurrentDate=rset.getString("CurrentDate");

				
			}
		}
	 }
	 catch(Exception e){/* out.println(e); */ e.printStackTrace();}
	 finally
	 {
		 try
		 {
			if(rset != null)    rset.close();
			if(stmt != null)    stmt.close();
		 }
		 catch(Exception e)
		 {
		 /* out.println("Exception in tryCatch : "+ e.toString()); */ e.printStackTrace();}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
if(isSpltyNurUnitToEnableYNAppl.equals("N")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            {java.lang.String __page ="CommonNursingUnitLookup.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("nursing_unit_code_Appl"), weblogic.utils.StringUtils.valueOf("p_fm_nursing_unit")},{ weblogic.utils.StringUtils.valueOf("nursing_unit_to_code_Appl"), weblogic.utils.StringUtils.valueOf("p_to_nursing_unit")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
if(localeName.equals("en"))
	{
            _bw.write(_wl_block43Bytes, _wl_block43);
}
	else if(localeName.equals("th"))
	{
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( CurrentDate ));
            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmissionReport.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeReport.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportcritera.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CashPatient.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CURR_IP.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CashGroup.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CompanyGroup.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CompanyName.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CompanyName.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CompanyName.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.groupby.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CompanyName.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CompanyGroup.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.groupby.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CompanyName.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CompanyGroup.label", java.lang.String .class,"key"));
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
}
