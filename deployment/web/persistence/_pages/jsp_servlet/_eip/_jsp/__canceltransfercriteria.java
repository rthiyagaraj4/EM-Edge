package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;

public final class __canceltransfercriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/CancelTransferCriteria.jsp", 1742368916490L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t<script>\n\n\tfunction compareDates(Obj)\n\t{\n\t\tif(!doDateCheckAlert(document.forms[0].from_date,document.forms[0].to_date))\n\t\t{\n\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\n\t\t\tdocument.forms[0].to_date.focus();\n\t\t\t\n\t\t\tdocument.forms[0].to_date.select();\n\t\t}\n\t}\t\n\t\t\nfunction DateCompare(from,to,messageFrame,getVal) \n\t\t{\n\t\t\t\n\t\t\tvar getValue = getVal;\n\t\t\t\n\t\t\tvar fromarray; var toarray;\n\t\t\t\n\t\t\tvar fromdate = from.value ;\n\t\t\t\n\t\t\tvar todate = to.value ;\n\t\t\t\n\t\t\tif(fromdate.length > 0 && todate.length > 0 ) {\n\t\t\t\n\t\t\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\t\t\t\n\t\t\t\t\ttoarray = todate.split(\"/\");\n\t\t\t\t\t\n\t\t\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\t\t\t\n\t\t\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\n\t\t\t\t\t\n\t\t\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) \n\t\t\t\t\t{\n\t\t\t\t\t\tif(messageFrame.name ==\"f_query_add_mod1\")\n\t\t\t\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\t\t\t\telse\n\t\t\t\t\t\tmessageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\");\n\t\t\t\t\t\tto.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\telse if(Date.parse(todt) >= Date.parse(fromdt)) return true;\n\t\t\t}\n\t\t\treturn true;\n\t\t}\n           \n\t\tfunction clearAll()\n\t\t{\t\t\t\n\t\t\t\tparent.frames[2].document.location.href =\'../../eCommon/html/blank.html\';\n\t\t\t\tif(parent.messageFrame)\n\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t}\n\t\tfunction validSplchars1(obj)\n\t\t\t{\t\n\t\t\t\tvar val = obj.value.toUpperCase();\t\t\t\n\t\t\t\t\n\t\t\t\tobj.value = val;\t\n\t\t\t\t\n\t\t\t\tvar fields=new Array();\n\t\t\t\t\n\t\t\t\tvar names=new Array();\n\t\t\t\t\n\t\t\t\tfields[0]=obj;\n\t\t\t\t\n\t\t\t\tnames[0]=\"Encounter ID\";\n\t\t\t\t\n\t\t\t\tif(SpecialCharCheck( fields, names,\'\',\"A\",\'\'))\n\t\t\t\t\treturn true;\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tobj.select();\n\t\t\t\t\tobj.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t</script>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script src=\'../../eIP/js/IPQueryCommon.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t\t<script>\n\t\tasync function getNursingUnit(getFacilitID)\n\t\t{\n\t\t\tvar msg=\"\";\n\t\t\tvar facility_id\t\t\t\t=\"`\"+getFacilitID+\"`\";\n\t\t\tvar loginUser\t\t\t\t=\"`\"+\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'+\"`\";\n\t\t\tvar operstn\t\t\t\t\t=\"`\"+\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'+\"`\";\n\t\t\tvar target\t\t\t= document.forms[0].nursing_unit_desc;\n\t\t\tvar retVal\t\t\t=    new String();\n\t\t\tvar dialogTop\t\t\t= \"40\";\n\t\t\tvar dialogHeight\t\t= \"10\" ;\n\t\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\tvar sql\t\t\t\t= \"\";\n\t\t\tvar search_desc\t\t\t= \"\";\n\t\t\tvar tit\t\t\t\t= \"\";\n\t\t\tvar wherecondn      = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\tif (wherecondn.length>0)\n\t\t\t{\n\t\t\tsql = \"select a.nursing_unit_code,a.short_desc from ip_nursing_unit a, am_os_user_locn_access_vw b where a.eff_status = \'E\' and a.facility_id=\"+facility_id+\" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.oper_stn_id=\"+operstn+\" and b.appl_user_id=\"+loginUser+\"  and b.\"+wherecondn+\" =`Y` \";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tsql=\"Select nursing_unit_code,short_desc  from ip_nursing_unit where facility_id=\"+facility_id+\"  and eff_status=`E` \";\n\t\t}\n\t\tsearch_code=\"nursing_unit_code\";\n\t\tsearch_desc=\"short_desc\";\n\t\ttit=getLabel(\'Common.nursingUnit.label\',\'common\');;\n\t\tretVal=await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit)+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\t\tvar arr=new Array();\n\n\t\tif (!(retVal == null))\n\t\t{\n\n  \t\t\tvar retVal=unescape(retVal);\n\t\t    arr=retVal.split(\"::\");\n\t\t    document.forms[0].nursing_unit_desc.value=arr[0];\n\t\t\tdocument.forms[0].nursing_unit.value=arr[1];\n\t\t    document.forms[0].nursing_unit_desc.focus();\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttarget.focus();\n\t\t}\n\t}\n\n\t\tasync function getSpecialty(getFacilitID)\n\t\t{\n\t\t\tvar msg=\"\";\n\t\t\tvar facility_id\t\t\t\t=\"`\"+getFacilitID+\"`\";\n\t\t\tvar target\t\t\t= document.forms[0].specialty_desc;\n\t\t\tvar retVal\t\t\t=    new String();\n\t\t\tvar dialogTop\t\t\t= \"40\";\n\t\t\tvar dialogHeight\t\t= \"10\" ;\n\t\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\tvar sql\t\t\t\t= \"\";\n\t\t\tvar search_desc\t\t\t= \"\";\n\t\t\tvar tit\t\t\t\t= \"\";\n\t\t\tsql=\"Select speciality_code,short_desc from am_speciality where eff_status=`E` \";\n\n\t\t\tsearch_code=\"speciality_code\";\n\t\t\tsearch_desc=\"short_desc\";\n\t\t\tvar tit=getLabel(\'Common.speciality.label\',\'common\');\n\t\t\tretVal=await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit)+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\t\t\n\t\t\tvar arr=new Array();\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\tvar retVal=unescape(retVal);\n\t\t\t\tarr=retVal.split(\"::\");\n\t\t\t\tdocument.forms[0].specialty_desc.value=arr[0];\n\t\t\t\tdocument.forms[0].Splcode.value=arr[1];\n\t\t\t\tdocument.forms[0].specialty_desc.focus();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\ttarget.focus();\n\t\t\t}\n\t\t}\n\n\t\tfunction submitPage()\n\t\t{\n\t\t\t\tvar flag=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\tif(flag==\"true\")\n\t\t\t\t{\t\n\t\t\t\t\tif(document.forms[0].patient_id.value==\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar msg = getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\t\t\t\tmsg = msg.replace(\'$\',getLabel(\"Common.patientId.label\",\"Common\"))\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tdocument.forms[0].patient_id.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\tvar condition=\"\"\n\t\t\t\tfor(var i=0; i<document.forms[0].elements.length; i++)\n\t\t\t\t\t\tcondition+= document.forms[0].elements[i].name +\"=\"+ escape(document.forms[0].elements[i].value)+\"&\"\n\t\t\t\t\t\n\t\t\t\toper_stn = document.forms[0].operstn.value;\n\t\t\t\tvar callfunc = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\tif(callfunc == \"ReferralPatientDetails\")\n\t\t\t\t   document.forms[0].nursing_unit.disabled = true\n\t\t\t\telse\n\t\t\t\t\tdocument.forms[0].nursing_unit_lookup.disabled = true;\n\n\t\t\t\tdocument.forms[0].specialty_lookup.disabled = true;\n\t\t\t\tdocument.forms[0].pract_id_search.disabled = true;\n\t\t\t\tdocument.forms[0].from_date.readOnly = true;\n\t\t\t\tdocument.forms[0].to_date.readOnly = true;\n\t\t\t\tdocument.forms[0].encounter_id.readOnly = true;\n\t\t\t\tdocument.forms[0].patient_id.readOnly = true;\n\t\t\t\tdocument.forms[0].patient_search.disabled = true;\n\t\t\t\tdocument.forms[0].gender.disabled = true;\n\t\t\t\tdocument.forms[0].soundex.disabled = true;\n\t\t\t\tdocument.forms[0].search.disabled = true;\n\t\t\t\tdocument.forms[0].clear.disabled = true;\n\n\t\t\t\tif(document.forms[0].modal.value == \'yes\')\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\tparent.frames[1].location.href= \'../../eIP/jsp/CancelTransferResult.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&\'+condition+\'&oper_stn_id=\'+oper_stn+\'&show_bed_yn=Y\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tparent.frames[2].location.href= \'../../eIP/jsp/CancelTransferResult.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&\'+condition+\'&oper_stn_id=\'+oper_stn+\'&show_bed_yn=Y\';\n\t\t\t\t}\n\t\t\t}\t\t\t\n\t\t</script>\t\t\n\t</head>\t\n\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad= \'FocusFirstElement()\' onSelect=\"codeArrestThruSelect()\" >\n\t\t<form name=\'Inpatientlookup_Form\' id=\'Inpatientlookup_Form\' action=\'../../eIP/jsp/BookingReferenceLookupResult.jsp\' target=\'result\' >\n\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t\t<tr>\t\t\t\n\t\t\t\t\t<td  class=\'label\' align=\'right\' width=12%>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" &nbsp;</td>\n\t\t\t\t\t<td><input type=text name=nursing_unit_desc id=nursing_unit_desc size=15 readonly><input type=hidden class=label name=nursing_unit id=nursing_unit size=15 readonly><input type=button class=button name=\'nursing_unit_lookup\' id=\'nursing_unit_lookup\' value=\'?\' onClick=\'getNursingUnit(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\")\'>\n\t\t\t\t    </td>\n\t\t\t\t\t<td  class=\'label\' align=\'right\' width=9%>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;</td>\n\t\t\t\t\t<td><input type=text name=specialty_desc id=specialty_desc size=15 readonly><input type=hidden class=label name=Splcode id=Splcode size=15 readonly><input type=button class=button name=\'specialty_lookup\' id=\'specialty_lookup\' value=\'?\' onClick=\'getSpecialty(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\'>\n\t\t\t\t\t<td  class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" &nbsp;</td>\n\t\t\t\t\t<td class=\'label\' align=\'left\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<td class=\'label\' align=right nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp; ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td><td colspan=\'2\' nowrap><input type=\'text\' maxlength=\'10\' size=\'10\' name=\'from_date\' id=\'from_date\'  value=\"\" onBlur=\'CheckDate(this);compareDates(this);\'> - <input type=\'text\' value=\"\" maxlength=\'10\' size=\'10\' name=\'to_date\' id=\'to_date\' onBlur=\'CheckDate(this);compareDates(this);\'></td>\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td><td colspan=\'2\' nowrap><input type=\'text\' maxlength=\'10\' size=\'10\' name=\'from_date\' id=\'from_date\'  value=\"\" onBlur=\'CheckDate(this);DateCompare(to_date,this,parent.frames[3],\"Admission Date\");\'> - <input type=\'text\' value=\"\" maxlength=\'10\' size=\'10\' name=\'to_date\' id=\'to_date\' onBlur=\'CheckDate(this);DateCompare(from_date,this,parent.frames[3],\"Admission Date\");\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t<td class=\'2\' align=\'left\'><input type=\'text\'  size=\'12\'  maxlength=\'12\' name=\'encounter_id\' id=\'encounter_id\' onKeyPress=\"return allowValidNumber(this,event,12,0)\" onBlur=\"validSplchars1(this)\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\t<td colspan=6>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t</td>\n\t\t\t\t\n\t\t\t</tr>\t\n\t</table>\n\t<table align=\'right\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' class=\'white\'>\n\t\t\t\t\t\t<input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' class=\'button\' onclick=\'submitPage()\'>\n\t\t\t\t\t\t<input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' class=\'button\' onclick=\'clearAll()\'>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\t\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t<input type=\'hidden\' name=\'operstn\' id=\'operstn\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n\t<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\n\t\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n</html>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
		Connection con 	= null;
		Statement  stmt	= null;
		ResultSet  rs 	= null;
		Statement  stmt10	= null;
		ResultSet  rs10 	= null;
	
   try{
		   	con = ConnectionManager.getConnection(request);
			String window_styl=request.getParameter("window_styl");
	
			if( window_styl == null) window_styl="";
			String close_yn	=request.getParameter("close_yn");
			
			if( close_yn == null) close_yn="";
			String win_top =request.getParameter("win_top");
			
			if( win_top == null) win_top="";
			String win_height =request.getParameter("win_height");
			
			if(win_height ==null) win_height="";
			String win_width =request.getParameter("win_width");
			
			if( win_width == null) win_width="";
			String call_function=request.getParameter("call_function");
			
			if(call_function == null) call_function="";

			String mandat="";
			
			String modal=request.getParameter("modal");
			if(modal == null) modal="";			
			
			String dialogTop =request.getParameter("dialogTop");
			if(dialogTop ==null) dialogTop="";			

			String module=request.getParameter("module");
			if(module == null) module="";

			String model_window=request.getParameter("model_window");
			if( model_window == null) model_window="";
			
			String function_id=request.getParameter("function_id");
			if( function_id == null) function_id="";
			
			String prog_id=request.getParameter("prog_id");
			if( prog_id == null) prog_id="";

			String practitioner_id=request.getParameter("practitioner_id");
			if( practitioner_id == null) practitioner_id="";
			
			String wherecondn = request.getParameter("wherecondn");
				if(wherecondn == null) wherecondn ="";	
			
			String operstn	= request.getParameter("wherecondn");
				if(wherecondn == null) wherecondn ="";	
			
			String facilityID=(String)session.getValue("facility_id");
			
			String loginUser = (String)session.getValue("login_user");
			
			String p_module_id=request.getParameter("p_module_id");
			
			if(p_module_id == null) p_module_id="";
			
	try{
			String operSql = " select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b 	   "+
			 " where a.facility_id='"+facilityID+"' and a.facility_id=b.facility_id	   "+
			 " and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"'   "+
			 " and trunc(sysdate) between b.eff_date_from and 			   "+
			 " nvl(b.eff_date_to,trunc(sysdate)) ";
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(operSql);
			
			if(rs!=null)
			{
				while(rs.next())
				{
					operstn	 = rs.getString("oper_stn_id");
					if(operstn == null) operstn ="";
				}
			}		

	}catch(Exception e)
	{
		e.toString();
	}
	
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(rs10!=null) rs10.close();
	if(stmt10!=null) stmt10.close();

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mandat));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            {java.lang.String __page ="PractitionerComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block21Bytes, _wl_block21);
 
						if(modal.equals("yes")) { 
					
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
 		
						}
					else 
						{
						
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
		
					}  					
					
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            {java.lang.String __page ="IPPatientLookUpDetailCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("mandat"), weblogic.utils.StringUtils.valueOf(mandat
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(module));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p_module_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
 }catch(Exception e)	{out.println(e);}
finally
{
	ConnectionManager.returnConnection(con,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.transferdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.transferdate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
}
