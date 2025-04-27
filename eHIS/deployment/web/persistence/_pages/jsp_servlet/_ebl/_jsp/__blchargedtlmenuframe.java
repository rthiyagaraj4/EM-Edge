package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eBL.*;
import eOR.*;
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __blchargedtlmenuframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargeDtlMenuFrame.jsp", 1743571079702L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5_0 ="\n<html>\n<head>\n<script>\nfunction changeToUpper()\n{\n\tif( (window.event.keyCode >= 97) && (window.event.keyCode <= 122) )\t\n\t\treturn (window.event.keyCode -= 32);\n\telse\n\t\treturn true;\n\n}\nasync function funQry()\n{\n\tvar retVal = new Array();\n\tvar episode_type = document.forms[0].episode_type.value;\n\tvar patient_id = document.forms[0].patient_id.value;\t\n\tvar visit_id=document.forms[0].visit_id.value;\t\n\tvar episode_id=document.forms[0].episode_id.value;\t\n\tvar service_panel_code=document.forms[0].service_panel_code.value;\t\n\tvar service_panel_ind=document.forms[0].service_panel_ind.value;\t \n\tvar service_date=document.forms[0].service_date.value;\t\n\tvar pract_staff_ind=document.forms[0].pract_staff_ind.value;\t\n\tvar pract_staff_id=document.forms[0].pract_staff_id.value;\t\n\tvar order_catalog_code=document.forms[0].order_catalog_code.value;\t\n\tvar module_id=document.forms[0].module_id.value;\t\n\tvar encounter_id=document.forms[0].encounter_id.value;\t\n\tvar key=document.forms[0].key.value;\n\tvar key_line_no=document.forms[0].key_line_no.value;\n\tvar order_id=\"\";\n\tvar order_line_no=\"\";\n\t//service_date=convertDate(formObj.dt_from.value,\'DMYHM\',locale,\"en\"); \n\t\n\tvar dialogTop = \"100\";\n\tvar dialogHeight = \"30\" ;\n\tvar dialogWidth = \"70\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar title=getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\t\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\t//var include_label=encodeURIComponent(getLabel(\"Common.Include.label\",\"common\"));\n\t//var exclude_label=encodeURIComponent(getLabel(\"Common.Exclude.label\",\"common\"));\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"episode_type=\"+episode_type+\"&\"+\"patient_id=\"+patient_id+\"&\"+\"visit_id=\"+visit_id+\"&\"+\"episode_id=\"+episode_id+\"&\"+\"service_panel_code=\"+service_panel_code+\"&\"+\"service_panel_ind=\"+service_panel_ind+\"&\"+\"service_date=\"+service_date+\"&\"+\"order_catalog_code=\"+order_catalog_code+\"&\"+\"module_id=\"+module_id+\"&encounter_id=\"+encounter_id+\"&key=\"+key+\"&key_line_no=\"+key_line_no+\"&order_id=\"+order_id+\"&order_line_no=\"+order_line_no;\t\n\n\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?\"+param,arguments,features);\n//\talert(\"retVal from main\"+retVal)\n\t//parent.window.returnValue=returnArray;\t\n\tvar str =unescape(retVal);\n\tvar arr = str.split(\",\");\n\tif(retVal!=null)\n\t{\n\t\tif(arr[0]==\"Y\")\n\t\t{\n\t\t\t//alert(\"Updated Successfully\");\n\t\t\tparent.frames[1].location.href=\"../../eBL/jsp/BLChargeDtlMenuFrame.jsp\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//alert(\"Updation Failed\");\n\t\t}\n\t}\n\telse\n\t{\n\t\t\t//alert(\"Updation Failed\");\n\t}\n}\n\nasync function funQry1()\n{\n\tvar retVal;\n\tvar dialogHeight= \"10\";\n\tvar dialogWidth\t= \"40\";\n\tvar dialogTop = \"210\";\n\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\t\n\tvar clinic_code=\"CL34\";\n\tvar visit_type_code=\"V1\";\n\tvar patient_id=document.forms[0].patient_id.value;\n\tvar episode_type=\"O\";\n\tvar episode_id=document.forms[0].episode_id.value;\n\tvar visit_id=document.forms[0].visit_id.value;\n\tvar encounter_id=\"\";\n\tvar facility_id=\"HS\";\n\tvar calling_module_id=\"OP\";\n\tvar calling_function_id=\"CHECKOUT_VISIT\";//VISIT_REGISTRATION\n\tvar logged_user_id=\"KUILA\";\n\tvar practitioner_id=\"SR\";\n\tvar practitioner_type_ind=\"P\";\n\n\tvar url = \"../../eBL/jsp/BLVisitChargeDetCloseConsultFrame.jsp?call_after_reg=Y&start_valid=Y&clinic_code=\"+clinic_code+\"&visit_type_code=\"+visit_type_code+\"&patient_id=\"+patient_id+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&visit_id=\"+visit_id+\"&encounter_id=\"+encounter_id+\"&facility_id=\"+facility_id+\"&calling_module_id=\"+calling_module_id+\"&calling_function_id=\"+calling_function_id+\"&logged_user_id=\"+logged_user_id+\"&practitioner_id=\"+practitioner_id+\"&practitioner_type_ind=\"+practitioner_type_ind;\t\n\n\tretVal =await window.showModalDialog(url,arguments,features);\n\n\tif(retVal==\"1\")\n\t{\n\t\t//alert(\"Visit Charge Success\");\n\t}\n\telse\n\t{\n\t\t//alert(\"Visit Charge Failed\");\n\t}\n}\n\n\n\nfunction funBLStmt()\n{\n\t//alert(\"inside bill stlmt\"); \n\tvar retVal = new Array();\n\t//var billdoctype=\"HSBLOP\";\n\t//var billdocnum=\"5000054\";\n\tvar billdoctype=document.forms[0].billdoctypecode.value;\n\t//alert(\"billdoctype :\" +billdoctype);\n\tvar billdocnum=document.forms[0].billdocnum.value;\n\t//alert(\"billdocnum :\" +billdocnum);\n\tvar blnggrp=\"PT\";\n\tvar center=\'1\';\n\tvar dialogTop = \"100\";\n\tvar dialogHeight = \"40\" ;\n\tvar dialogWidth = \"70\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t//var title=getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\");\n\tvar title=\"\";\n\ttitle=encodeURIComponent(title);\t\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\t\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billdoctypecode=\"+billdoctype+\"&\"+\"billdocnum=\"+billdocnum+\"&\"+\"blnggrp=\"+blnggrp;\n//alert(\"param \"+ param);\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLBillSlmtMain.jsp?\"+param,arguments,features);\n\t//alert(\"retVal from main\"+retVal)\n\t}\n\n\nfunction funPharmacyBLStmt()\n{\t\n\tvar retVal = new Array();\t\n\tvar billdoctype=document.forms[0].billdoctypecode.value;\t\n\tvar billdocnum=document.forms[0].billdocnum.value;\t\n\tvar blnggrp=\"PT\";\t\n\tvar center=\'1\';\n\tvar dialogTop = \"100\";\n\tvar dialogHeight = \"40\" ;\n\tvar dialogWidth = \"70\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\t\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\t\n\n\tvar param = \"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billdoctypecode=\"+billdoctype+\"&\"+\"billdocnum=\"+billdocnum+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"module_id=PH\"+\"&\"+\"function_id=\";\n\n\t//alert(\"param \"+ param);\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLStoreBillSlmtMain.jsp?\"+param,arguments,features);\n}\n\tfunction funBLBillInterim()\n\t{\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"100\";\n\t\tvar dialogHeight = \"30\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar title=\"Interim Bill Generation\";\n\t\ttitle=encodeURIComponent(title);\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions;\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLBillInterimFrame.jsp?\"+param,arguments,features);\n\t}\n\nfunction funViewEncounterDet()\n\t{\n\t//alert(\"inside funViewEncounterDet1\");\n\tvar episode_type = document.forms[0].episode_type.value;\n\tvar patient_id = document.forms[0].patient_id.value;\t\n\tvar visit_id=document.forms[0].visit_id.value;\t\n\tvar episode_id=document.forms[0].episode_id.value;\t\n\tvar encounterid=document.forms[0].encounterid.value;\t\n\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"100\";\n\t\tvar dialogHeight = \"30\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar title=\"\";\n\t\ttitle=encodeURIComponent(title);\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"visit_id=\"+visit_id+\"&patient_id=\"+patient_id+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&visit_id=\"+visit_id+\"&encounter_id=\"+encounterid;\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLViewEncounterBillDetMain.jsp?\"+param,arguments,features);\n\t}\n\n\nfunction funViewPatEncounterDtls()\n\t{\n\t//alert(\"inside funViewPatEncounterDtls2 \");\n\tvar episode_type = document.forms[0].episode_type.value;\n\tvar patient_id = document.forms[0].patient_id.value;\t\n\tvar visit_id=document.forms[0].visit_id.value;\t\n\tvar episode_id=document.forms[0].episode_id.value;\t\n\tvar encounterid=document.forms[0].encounterid.value;\t\n\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"100\";\n\t\tvar dialogHeight = \"30\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar title=\"\";\n\t\ttitle=encodeURIComponent(title);\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"visit_id=\"+visit_id+\"&patient_id=\"+patient_id+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&visit_id=\"+visit_id+\"&encounter_id=\"+encounterid;\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLPatientEncounters.jsp?\"+param,arguments,features);\n\t}\nfunction funPrevEncounters()\n\t{\n\t\tvar episode_type = document.forms[0].episode_type.value;\n\t\tvar patient_id = document.forms[0].patient_id.value;\t\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"100\";\n\t\tvar dialogHeight = \"30\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar title=getLabel(\"eBL.PRV_ENCOUNTER_FIN_DETAILS.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&patient_id=\"+patient_id+\"&episode_type=\"+episode_type+\"&title=\"+title;\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLPreviousEncounterMain.jsp?\"+param,arguments,features);\n\t}\n\tfunction callOracleForm()\n\t\t{\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"100\";\n\t\tvar dialogHeight = \"30\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar title=\"\"\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions;\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/CreditCardInterfaceTestFrame.jsp?\"+param,arguments,features);\n\n\t\t}\n\n\tfunctio";
    private final static byte[]  _wl_block5_0Bytes = _getBytes( _wl_block5_0 );

    private final static java.lang.String  _wl_block5_1 ="n roundNumber() {\n\tvar numberField = document.forms[0].numberfield; // Field where the number appears\n\tvar rnum = numberField.value;\n\tvar rlength = 0; // The number of decimal places to round to\n\tif (rnum > 8191 && rnum < 10485) {\n\t\trnum = rnum-5000;\n\t\tvar newnumber = Math.round(rnum*Math.pow(10,rlength))/Math.pow(10,rlength);\n\t\tnewnumber = newnumber+5000;\n\t} else {\n\t\tvar newnumber = Math.round(rnum*Math.pow(10,rlength))/Math.pow(10,rlength);\n\t}\n\tnumberField.value = newnumber;\n}\n\n</script>\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n-->\n\t";
    private final static byte[]  _wl_block5_1Bytes = _getBytes( _wl_block5_1 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script> \n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form  method=\'post\'>\n\n\t\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\n\t\t</tr>\n\t</table>\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\t\n\t\t<tr>\n\t\t<td width=\'25%\'  class=\'label\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b></td>\n\t\t<td  width=\'25%\' class=\'fields\'>\n\t\t   <select name=\'episode_type\' id=\'episode_type\' onchange=\'\'>\n\t\t   <option value=\'\'>-------------------";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="-------------------</option>\n\t\t   <option value=\'E\'>Emergency</option>\n\t\t   <option value=\'O\'>OutPatient</option>\n\t\t   <option value=\'I\'>Inpatient</option>\n\t\t   <option value=\'D\'>Daycare</option>\n\t\t   <option value=\'R\'>External</option>\n\t\t   </select><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t   <td width=\'25%\'   class=\'label\'><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td>\n\t\t <td  width=\'25%\'  class=\"fields\"><input type=\'text\' name=\'patient_id\' id=\'patient_id\' size=\'20\' maxlength=\'30\' value=\'\' onKeyPress=\'changeToUpper()\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\t\n\t\t</tr>\n\t<tr>\n\t\t<td width=\'25%\' class=\'label\'><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td>\n\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'episode_id\' id=\'episode_id\' size=\'8\' maxlength=\'30\'style=\'text-align:right\'  value=\'\' onKeyPress=\'return(ChkNumberInput(this,event,2))\' onBlur=\'\'></td>\n\t\t<td width=\'25%\' class=\'label\'> <b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b> </td>\n\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'visit_id\' id=\'visit_id\' size=\'4\' maxlength=\'30\' style=\'text-align:right\'  value=\'\'  onKeyPress=\'return(ChkNumberInput(this,event,2))\' onBlur=\'\'></td>\n\t</tr>\n\n\t<tr>\n\t\t<td width=\'25%\' class=\'label\'><b>bill type code</b></td>\n\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'billdoctypecode\' id=\'billdoctypecode\' size=\'8\' maxlength=\'30\'style=\'text-align:right\'  value=\'HSBLOP\' ></td>\n\t\t<td width=\'25%\' class=\'label\'> <b>bill doc number</b> </td>\n\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'billdocnum\' id=\'billdocnum\' size=\'4\' maxlength=\'30\' style=\'text-align:right\'  value=\'\' ></td>\n\t\t<tr>\n\t\t<td width=\'25%\' class=\'label\'> <b>encounterid</b> </td>\n\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'encounterid\' id=\'encounterid\' size=\'4\' maxlength=\'30\' style=\'text-align:right\'  value=\'\' ></td>\n\t\t<td><input type=\'button\' class=\'button\' onclick=\'funViewEncounterDet()\' value=\"ViewEncounterBillDet\" ></td>\n\t\t<td><input type=\'button\' class=\'button\' onclick=\'funViewPatEncounterDtls()\' value=\"ViewPatEncounterDtls\" ></td>\n\t\t</tr>\n\t</tr>\t\n\t<tr>\n\t\t<td width=\'25%\'></td>\n\t\t<td width=\'25%\'></td>\n\t\t<td width=\'25%\'></td>\n\t\t<td width=\"25%\"  class=\"label\" ><input type=\'button\' class=\'button\' onclick=\'funQry()\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t\t<input type=\'button\' class=\'button\' onclick=\'funQry()\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" ></td>\n\t</tr>\n\n\t<tr>\n\t\t<td width=\'25%\'></td>\n\t\t<td width=\'25%\'></td>\n\t\t<td width=\'25%\'><input type=\'button\' class=\'button\' onclick=\'funPrevEncounters()\' value=\"BLPrevEnctr\" ></td>\n\t\t<td width=\'25%\'><input type=\'button\' class=\'button\' onclick=\'funQry1()\' value=\"Click\" >\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' onclick=\'funBLStmt()\' value=\"BillStmt\" >\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' onclick=\'funBLBillInterim()\' value=\"BLBillInterim\" ></td>\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' onclick=\'funPharmacyBLStmt()\' value=\"PharmacyBill\" ></td>\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' onclick=\'callOracleForm()\' value=\"CallForm\" ></td>\n\n\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t</tr>\t\n\t<tr>\n\t\t\n\t</tr>\n\n\t</table>\n\t\t<input type= hidden name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t<input type= hidden name=\"pract_staff_id\" id=\"pract_staff_id\"  value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<input type= hidden name=\"pract_staff_ind\" id=\"pract_staff_ind\"  value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<input type= hidden name=\"service_panel_ind\" id=\"service_panel_ind\"  value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t<input type= hidden name=\"service_panel_code\" id=\"service_panel_code\"  value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type= hidden name=\"service_date\" id=\"service_date\"  value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type= hidden name=\"order_catalog_code\" id=\"order_catalog_code\"  value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t<input type= hidden name=\"encounter_id\" id=\"encounter_id\"  value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t<input type= hidden name=\"acct_seq_no\" id=\"acct_seq_no\"  value=\'\'>\n\t\t<input type= hidden name=\"module_id\" id=\"module_id\"  value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type= hidden name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<input type= hidden name=\"key\" id=\"key\"  value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type= hidden name=\"key_line_no\" id=\"key_line_no\"  value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\n\t\t<!--<input type=\"text\" name=\"numberfield\" id=\"numberfield\">\n\t\t<input type=\"button\" value=\"Round\" onClick=\"roundNumber();\">-->\n\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");		
	
	double d_tot_amt=0;
//	double d_serv_amt=0;
	double d_pat_payable=0;
//	double d_min_chr_amt=0;
	double d_patient_paid=0;
	double serv_qty=1;
	String facility_id = "";
	String login_user = "";
	String str_excl_incl_ind="",str_preappr_yn="",str_error_code="";
	String str_sys_message_id="", str_error_text="";//str_rate_chr_ind="",str_override_yn=""
	//String str_blng_serv_desc=""
	String str_charge_based_yn="",str_excl_incl_act="", str_act_reason_code="";

	String panel_str="";
	String service_date="";
	String charged_YN="";
	String pat_billed_YN="";
	String key="";
	String key_line_no="";

	Connection con = null;
	//PreparedStatement pstmt = null ;
	ResultSet rs = null;
	Statement stmt=null;
	request.setCharacterEncoding("UTF-8");
	con	=	ConnectionManager.getConnection(request);
	String locale	= (String)session.getAttribute("LOCALE");
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");		
		session.removeAttribute("hosp_panel_str");
		session.removeAttribute("prof_panel_str");
		session.removeAttribute("prof_panel_str_YN");
		session.removeAttribute("hosp_panel_str_YN");
		session.removeAttribute("upd_hosp_chrg_amt");
		session.removeAttribute("upd_hosp_chrg_pat_amt");
		session.removeAttribute("upd_med_chrg_amt");
		session.removeAttribute("upd_med_chrg_pat_amt");
		session.removeAttribute("hosp_dtls");
		session.removeAttribute("prof_dtls");
		session.removeAttribute("fin_dtls_to_chrg_dtls");
		session.removeAttribute("hosp_panel");
		session.removeAttribute("prof_panel");

		String patient_id="SD00000726";
		String episode_type="O";
		long episode_id=10002435;
		int visit_id=1;	
		long encounter_id=0;

		String service_panel_code="HD1";
		String service_panel_ind="L"; //S
		
		String pract_staff_ind="P";
		String pract_staff_id="ALLEN";

		String order_catalog_code="00BN0ZX";
		String module_id="OP";
		String charge_based_amt="";
		String excl_incl_action_ind="";
		String action_reason_code="";
		
		String acc_flag=(String)session.getAttribute("acc_flag");
		if(acc_flag==null) acc_flag="";
//		System.out.println("acc_flag" +acc_flag);

		String strBlnggrpId="";                                      
		String strCustCode="";                                       
		String strPolicyTypeCode="";                                 
		String strPolicyPriority="";                                 
		String strPolicyNumber="";                                   
		String strPolicyStartDate="";                                
		String strPolicyExpiryDate="";                               
		String strCreditAuthRef="";                                  
		String strCreditAuthDate="";                                 
		String strEffectiveFrom="";                                  
		String strEffectiveTo="";                                    
		String strApprovedAmt="";                                    
		String strApprovedDays="";                                   
		String strNonInsBlnggrpId="";                                
		String strNonInsCustCode=""; 
		String strExclInclActionInd="";
		String strActionReasonCode="";
		String strNull="";

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					service_date = rs.getString(1);
				}
			}
			stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception in Sys Date :"+e);
		}
		if(module_id.equals("OP") || module_id.equals("AE"))
		{
		if(acc_flag.equals("true"))
		{
//			System.out.println("in s");
			/*HashMap bl_data=(HashMap)session.getAttribute("serv_panel_str");
			panel_str=(String)bl_data.get("serv_panel_str1");
			System.out.println("panel_str panel_str " +panel_str);
			accept_chk=(String)bl_data.get("accept_chk");
			System.out.println("accept_chk session" +accept_chk);*/
		}
		else
		{
			try
			{
				
				if(episode_id==0 || visit_id==0)
				{
					CallableStatement call = con.prepareCall("{ call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
				    call.setString(1,facility_id);//facility_id                         
					call.setString(2,module_id);	//module_id                           
					call.setString(3,episode_type);//Episode_type                       
					call.setString(4,patient_id);//patient_id                           
					call.setLong(5,episode_id);//strEpisodeId                         
					call.setInt(6,visit_id);                                         
					call.setLong(7,encounter_id);                                         
					call.setString(8,""); 
					call.setString(9,service_date);//service_date                         
					call.setString(10,service_panel_ind);//service_panel_ind             
					call.setString(11,service_panel_code);//service_panel_code           
					call.setDouble(12,serv_qty);//service_qty                                    
					call.setString(13,pract_staff_ind);//pract_staff_ind           
					call.setString(14,pract_staff_id);//pract_staff_id                 
					call.setString(39,locale);//locale                                    
					call.setString(15,strBlnggrpId);                                      
					call.setString(16,strCustCode);                                       
					call.setString(17,strPolicyTypeCode);                                 
					call.setString(18,strPolicyPriority);                                 
					call.setString(19,strPolicyNumber);                                   
					call.setString(20,strPolicyStartDate);                                
					call.setString(21,strPolicyExpiryDate);                               
					call.setString(22,strCreditAuthRef);                                  
					call.setString(23,strCreditAuthDate);                                 
					call.setString(24,strEffectiveFrom);                                  
					call.setString(25,strEffectiveTo);                                    
					call.setString(26,strApprovedAmt);                                    
					call.setString(27,strApprovedDays);                                   
					call.setString(28,strNonInsBlnggrpId);                                
					call.setString(29,strNonInsCustCode);           
					call.registerOutParameter(30,java.sql.Types.VARCHAR);                 
					call.registerOutParameter(31,java.sql.Types.VARCHAR);                 
					call.registerOutParameter(32,java.sql.Types.DOUBLE);                  
					call.registerOutParameter(33,java.sql.Types.DOUBLE);                  
					call.registerOutParameter(34,java.sql.Types.VARCHAR);                 
					call.registerOutParameter(35,java.sql.Types.VARCHAR);                 
					//call.registerOutParameter(36,java.sql.Types.VARCHAR);                 
					//call.registerOutParameter(37,java.sql.Types.DOUBLE); 
					call.setString(36,strExclInclActionInd);
					call.setString(37,strActionReasonCode);
					call.registerOutParameter(38,java.sql.Types.VARCHAR);	              
					call.registerOutParameter(40,java.sql.Types.VARCHAR);                 
					call.registerOutParameter(41,java.sql.Types.VARCHAR);                 
					call.registerOutParameter(42,java.sql.Types.VARCHAR);                 
					call.execute();	

					panel_str=call.getString(30);	
					if(panel_str==null || panel_str.equals("")) panel_str="";		
//					System.out.println("p_str frame  " + panel_str);	
					
					str_charge_based_yn=call.getString(31);
					if(str_charge_based_yn==null || str_charge_based_yn.equals("")) str_charge_based_yn="";		
					
					d_tot_amt=call.getDouble(32);
					d_pat_payable=call.getDouble(33);	

					str_excl_incl_ind=call.getString(34);	
					if(str_excl_incl_ind==null || str_excl_incl_ind.equals("")) str_excl_incl_ind="";		
					
					str_preappr_yn=call.getString(35);
					if(str_preappr_yn==null || str_preappr_yn.equals("")) str_preappr_yn="";		
					
					str_excl_incl_act=call.getString(36);	
					if(str_excl_incl_act==null || str_excl_incl_act.equals("")) str_excl_incl_act="";		
					
					str_act_reason_code=call.getString(37);
					if(str_act_reason_code==null || str_act_reason_code.equals("")) str_act_reason_code="";		
					
					d_patient_paid=call.getDouble(38);	

					str_error_code=call.getString(40);
					if(str_error_code==null || str_error_code.equals("")) str_error_code="";		
					
					str_sys_message_id=call.getString(41);
					if(str_sys_message_id==null || str_sys_message_id.equals("")) str_sys_message_id="";		
					
					str_error_text=call.getString(42);
					if(str_error_text==null || str_error_text.equals("")) str_error_text="";		
					
					call.close();
				}
				else
				{
//					System.out.println("222");
					CallableStatement call = con.prepareCall("{ call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
					call.setString(1,facility_id);//facility_id
					call.setString(2,module_id);	//module_id	
					call.setString(3,strNull); //key
					call.setString(4,strNull); //key_line_no
					call.setString(5,episode_type);//episode_type
					call.setString(6,patient_id);
					call.setLong(7,episode_id);
					call.setInt(8,visit_id);//visit_id
					call.setLong(9,encounter_id);
					call.setString(10,"");					
					call.setString(11,service_date);
					call.setString(12,strNull);//item_code
					call.setString(13,service_panel_ind);//service_panel_ind
					call.setString(14,service_panel_code);//service_panel_code
					call.setDouble(15,serv_qty);//serv_qty
					call.setString(16,charge_based_amt);//charge_based_amt
					call.setString(17,pract_staff_ind);//pract_staff_ind
					call.setString(18,pract_staff_id);//pract_staff_id	
					call.setString(25,excl_incl_action_ind);//excl_incl_action_ind
					call.setString(26,action_reason_code);//action_reason_code
					call.setString(30,locale);//locale
					call.registerOutParameter(19,java.sql.Types.VARCHAR);
					call.registerOutParameter(20,java.sql.Types.VARCHAR);					call.registerOutParameter(21,java.sql.Types.DOUBLE);
					call.registerOutParameter(22,java.sql.Types.DOUBLE);
					call.registerOutParameter(23,java.sql.Types.VARCHAR);
					call.registerOutParameter(24,java.sql.Types.VARCHAR);
									
					call.registerOutParameter(27,java.sql.Types.DOUBLE);
					call.registerOutParameter(28,java.sql.Types.VARCHAR);	
					call.registerOutParameter(29,java.sql.Types.VARCHAR);	
					call.registerOutParameter(31,java.sql.Types.VARCHAR);
					call.registerOutParameter(32,java.sql.Types.VARCHAR);
					call.registerOutParameter(33,java.sql.Types.VARCHAR);
					call.execute();		
					
					panel_str=call.getString(19);	
					if(panel_str==null || panel_str.equals("")) panel_str="";		
//					System.out.println("p_str frame  " + panel_str);	

					str_charge_based_yn=call.getString(20);
					if(str_charge_based_yn==null || str_charge_based_yn.equals("")) str_charge_based_yn="";	
					
					d_tot_amt=call.getDouble(21);

					d_pat_payable=call.getDouble(22);	

					str_excl_incl_ind=call.getString(23);	
					if(str_excl_incl_ind==null || str_excl_incl_ind.equals("")) str_excl_incl_ind="";		

					str_preappr_yn=call.getString(24);
					if(str_preappr_yn==null || str_preappr_yn.equals("")) str_preappr_yn="";	
					
//					str_excl_incl_act=call.getString(25);	
//					if(str_excl_incl_act==null || str_excl_incl_act.equals("")) str_excl_incl_act="";		

//					str_act_reason_code=call.getString(26);
//					if(str_act_reason_code==null || str_act_reason_code.equals("")) str_act_reason_code="";	
					
					d_patient_paid=call.getDouble(27);	

					charged_YN=call.getString(28);	
					if(charged_YN==null) charged_YN="";
					
					pat_billed_YN=call.getString(29);	
					if(pat_billed_YN==null) pat_billed_YN="";

					str_error_code=call.getString(31);
					if(str_error_code==null || str_error_code.equals("")) str_error_code="";	
					
					str_sys_message_id=call.getString(32);
					if(str_sys_message_id==null || str_sys_message_id.equals("")) str_sys_message_id="";	
					
					str_error_text=call.getString(33);
					if(str_error_text==null || str_error_text.equals("")) str_error_text="";	
					
					call.close();
				}
			}	
			catch(Exception exp1)
			{			
				System.out.println("error"+exp1);
			}

//			System.out.println("panel_str panel_str 1 " +panel_str);
			HashMap pString = new HashMap();
			pString.put("panel_str",panel_str); 
			session.setAttribute("BlChargeRecord",(HashMap)pString);
//			System.out.println((HashMap)pString);
		}
	}

            _bw.write(_wl_block5_0Bytes, _wl_block5_0);
            _bw.write(_wl_block5_1Bytes, _wl_block5_1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.query.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pract_staff_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pract_staff_ind));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(service_panel_ind));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(service_panel_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(service_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(key));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(key_line_no));
            _bw.write(_wl_block27Bytes, _wl_block27);

	}
	catch(Exception eX)
	{
			out.println("Error= "+eX);
	}
	finally
	{
		rs.close();
		ConnectionManager.returnConnection(con, request);				
   }

            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FIN_DTLS_QRY.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitID.label", java.lang.String .class,"key"));
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
