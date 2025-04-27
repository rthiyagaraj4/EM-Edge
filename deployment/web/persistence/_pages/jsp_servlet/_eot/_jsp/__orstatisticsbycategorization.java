package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eOT.*;
import eOT.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __orstatisticsbycategorization extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ORStatisticsByCategorization.jsp", 1709120280000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="               \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head><title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script src=\"../../eOT/js/OtReports.js\" ></script>\n\t<script src=\"../../eOT/js/OTReportsLkupSQL.js\" ></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n    \t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n<script>\t\t\n\tvar speciality_title=getLabel(\"Common.speciality.label\",\"common\");\n\tvar procedure_title=getLabel(\"Common.Procedure.label\",\"common\");\n\tvar operationType_title=getLabel(\"eOT.OperationType.Label\",\"ot\");\t\t\n\tvar theatre_title=getLabel(\"Common.Theatre.label\",\"Common\");\n\t\t\nfunction checkProcess(obj){\n\tvar frmObj=document.forms[0];\n\tif(obj.checked==true)\n\t{\n\t\tfrmObj.param18.value=\'Y\';\n\t\tfrmObj.p_report_id.value=\'OTRSTOSG\';\n\t\tfrmObj.pgm_id.value=\'OTRSTOSG\';\n\n\t\tvar len = frmObj.param6.length;\n\t\tvar val = frmObj.param6.value;\n\t\tfor (var i=len;i>-1;i--)\n\t\t{\n\t\t\tfrmObj.param6.remove(i); \n\t\t}\n\t\tvar surgeon_title=getLabel(\"Common.Surgeon.label\",\"Common\");\n\t\tvar anaesthetist_title=getLabel(\"Common.Anaesthetist.label\",\"Common\");\n\t\tvar element = document.createElement(\'OPTION\'); \n\t\telement.text = surgeon_title;\n\t\telement.value= \'2\';\n\t\tfrmObj.param6.add(element);\n\t\tvar element = document.createElement(\'OPTION\');\n\t\telement.text = anaesthetist_title;\n\t\telement.value= \'3\';\n\t\tfrmObj.param6.add(element);\n\t\tif(val==\'2\'||val==\'3\')\n\t\t\tfrmObj.param6.value = val;\n\t\telse\n\t\t\tassignReportId(frmObj.param6);\t\t \n\t}\n\telse\n\t{\n\t\t frmObj.param18.value=\'N\';\n\t\t frmObj.p_report_id.value=\'OTRSTOPG\';\n\t\t frmObj.pgm_id.value=\'OTRSTOPG\';\n\t\tvar len = frmObj.param6.length;\n\t\tvar val = frmObj.param6.value;\n\n\t\tvar theatre_title=getLabel(\"Common.Theatre.label\",\"Common\");\n\t\tvar surgeon_title=getLabel(\"Common.Surgeon.label\",\"Common\");\n\t\tvar anaesthetist_title=getLabel(\"Common.Anaesthetist.label\",\"Common\");\n\t\tvar anaesthesia_title=getLabel(\"Common.Anaesthesia.label\",\"Common\");\n\t\tvar duration=getLabel(\"Common.duration.label\",\"Common\");\n\t\tvar operationType_title=getLabel(\"eOT.OperationType.Label\",\"ot\");\n\n\t\tfor (var i=len;i>-1;i--)\n\t\t{\n\t\t\tfrmObj.param6.remove(i); \n\t\t}\n\t\tvar element = document.createElement(\'OPTION\'); \n\t\telement.text = theatre_title;\t\t\n\t\tfrmObj.param6.add(element);\n\t\tvar element = document.createElement(\'OPTION\'); \n\t\telement.text = surgeon_title;\n\t\telement.value= \'2\';\n\t\tfrmObj.param6.add(element);\n\t\tvar element = document.createElement(\'OPTION\');\n\t\telement.text = anaesthetist_title;\n\t\telement.value= \'3\';\n\t\tfrmObj.param6.add(element);\n\t\tvar element = document.createElement(\'OPTION\'); \n\t\telement.text = anaesthesia_title;\n\t\telement.value= \'4\';\n\t\tfrmObj.param6.add(element);\n\t\tvar element = document.createElement(\'OPTION\');\n\t\telement.text =duration;\n\t\telement.value= \'5\';\n\t\tfrmObj.param6.add(element);\n\t\tvar element = document.createElement(\'OPTION\');\n\t\telement.text = operationType_title;\n\t\telement.value= \'6\';\n\t\tfrmObj.param6.add(element);\n\t\tfrmObj.param6.value = val;\n\t\tfrmObj.param6.selectedIndex=0;\n\t\tassignReportId();\t\t \n\t}\n}\n</script>\n\n<script language=\"javascript\">\n\tfunction assignReportId(){\n\t\tvar formObj = document.forms[0];\n\t\tvar facility_id = formObj.facility_id.value;\n\t\tvar locale = formObj.locale.value;\n\t\tvar type= formObj.param6.value;\n\t\tvar theatre_title=getLabel(\"Common.Theatre.label\",\"Common\");\n\t\tvar surgeon_title=getLabel(\"Common.Surgeon.label\",\"Common\");\n\t\tvar anaesthetist_title=getLabel(\"Common.Anaesthetist.label\",\"Common\");\n\t\tvar anaesthesia_title=getLabel(\"Common.Anaesthesia.label\",\"Common\");\n\t\tvar operationType_title=getLabel(\"eOT.OperationType.Label\",\"ot\");\n\t\tvar param15=formObj.param15.value;\n\t\t\n\t\tif(param15==\"2\"){\n\n\t\t\tdocument.getElementById(\"FromLabel\").innerHTML=getLabel(\"eOT.FromOperationDate.Label\",\"OT\")+\"  &nbsp\";\n\t\t\tdocument.getElementById(\"fromid\").innerHTML=\"<input type=\'text\' id=\'param1\' value=\'\"+document.getElementById(\"CURRENT_DATE\").value+\"\' \tname=\'param1\' id=\'param1\' maxlength=\'10\' size =\'10\' onBlur=\'if(CheckDate(this)){}\'><img  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].param1.select();return showCalendar(\'param1\',\'dd/mm/y\',null)\\\"/>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>(DD/MM/YYYY)\";\n\n\t\t\tdocument.getElementById(\"mandatory_fm_1\").value=\"param1##";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\tdocument.getElementById(\"mandatory_fm_2\").value=\"param2##";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\tdocument.getElementById(\"ToLabel\").innerHTML=getLabel(\"eOT.ToOperationDate.Label\",\"OT\")+\"  &nbsp\";\n\t\t\tdocument.getElementById(\"toid\").innerHTML=\"<input type=\'text\' id=\'param2\' value=\'\"+document.getElementById(\"CURRENT_DATE\").value+\"\' name=\'param2\' id=\'param2\' maxlength=\'10\' size =\'10\' onBlur=\'if(CheckDate(this)){}\'><img  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].param2.select();return showCalendar(\'param2\',\'dd/mm/y\',null)\\\"/>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>(DD/MM/YYYY)\";\t\t\n\t\t\n\t\t\tdocument.getElementById(\"report_id\").value = \"OTROPTPSP\";\n\t\t\tdocument.getElementById(\"p_report_id\").value = \"OTROPTPSP\";\n\t\t}\n\t\tif(param15==\"1\" || param15==\"3\"){\n\t\t\tdocument.getElementById(\"FromLabel\").innerHTML=getLabel(\"eOT.FromOperationMonth.Label\",\"OT\")+\"  &nbsp\";\n\t\t\tdocument.getElementById(\"fromid\").innerHTML=\"<input type=\'text\' id=\'param1\' value=\'\"+document.getElementById(\"surgery_date\").value+\"\' name=\'param1\' id=\'param1\' maxlength=\'7\' size =\'7\' onBlur=\'if(CheckMonth(this)){}\'><img  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].param1.select();return showCalendar(\'param1\',\'mm/y\',null)\\\"/>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>(MM/YYYY)\";\t\t\n\t\t\tdocument.getElementById(\"ToLabel\").innerHTML=getLabel(\"eOT.ToOperationMonth.Label\",\"OT\")+\"  &nbsp\";\n\t\t\tdocument.getElementById(\"toid\").innerHTML=\"<input type=\'text\' id=\'param2\' value=\'\"+document.getElementById(\"surgery_date\").value+\"\' name=\'param2\' id=\'param2\' maxlength=\'7\' size =\'7\' onBlur=\'if(CheckMonth(this)){}\'><img  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].param2.select();return showCalendar(\'param2\',\'mm/y\',null)\\\"/>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>(MM/YYYY)\";\n\t\t\t\n\t\t\tif(param15==\"1\"){\n\t\t\t\tdocument.getElementById(\"report_id\").value = \"OTROPTPCA\";\n\t\t\t\tdocument.getElementById(\"p_report_id\").value = \"OTROPTPCA\";\n\t\t\t}\n\t\t\tif(param15==\"3\"){\n\t\t\t\tdocument.getElementById(\"report_id\").value = \"OTROPTPST\";\n\t\t\t\tdocument.getElementById(\"p_report_id\").value = \"OTROPTPST\";\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\tdocument.getElementById(\"mandatory_fm_1\").value=\"param1##";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t}\n\t\t\n\t\t/*if(param15==\"3\"){\n\t\t\t\tdocument.getElementById(\"BillingGroupLabel\").innerHTML=getLabel(\"Common.BillingGroup.label\",\"common_labels\")+\" &nbsp\";\n\t\t\t\tdocument.getElementById(\"BillingGroupId\").innerHTML=\"<select name=\'BillingGroup\' id=\'BillingGroup\' id=\'BillingGroup\' style=\'visibility:visible\' multiple><option value=\'CA\' selected>\"+getLabel(\"eBL.CASH.label\",\"BL\")+\"</option><option value=\'CR\' selected>\"+getLabel(\"eBL.CREDIT.label\",\"BL\")+\"</option><option value=\'AR\' selected>\"+getLabel(\"eOT.ARAMCO.Label\",\"OT\")+\"</option></select>\";\n\t\t}else{\n\t\t\t\tdocument.getElementById(\"BillingGroupLabel\").innerHTML=\"\";\n\t\t\t\tdocument.getElementById(\"BillingGroupId\").innerHTML=\"\";\n\t\t}*/\n\t\tformObj.param3_desc.value=\"\";\n\t\tformObj.param5_desc.value=\"\";\n\t\tformObj.param7_desc.value=\"\";\n\t\tformObj.param9_desc.value=\"\";\n\t\tformObj.param11_desc.value=\"\";\t\t\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body  onload=\'assignReportId()\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eOT/jsp/OTReportsIntermediate.jsp\"  target=\"messageFrame\">\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n<tr> \n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t\t<select name=\"param15\" id=\"param15\"  onchange=\"assignReportId();\">  \n\t\t<option value= \"1\" > ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </option>\n\t\t<option value= \"2\" > ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </option>\n\t\t<option value= \"3\" > ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </option>\n\t\t</select>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n</tr>\n\n<tr>\n\t <td class=\'label\' width=\'25%\' id=\"FromLabel\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </td>\n\t <td class=\'fields\' width=\'25%\' id=\"fromid\">\n\t\t <input type=\'text\' name=\'param1\' id=\'param1\' id=\"param1\" size=\'5\'  value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onBlur=\"doDate(this);\" onkeypress=\"return checkForSpecCharsforID(event);\"  maxlength=\'7\'> \n\t\t <img src=\'../../eCommon/images/CommonCalendar.gif\' style=\'visibility:visible\' id=\"FromMYcalendar\" onClick=\"return showCalendar(\'param1\',\'mm/y\');\"></img>\n\t\t <img src=\'../../eCommon/images/CommonCalendar.gif\' style=\'visibility:hidden\' id=\"FromDMYcalendar\"  onClick=\"return showCalendar(\'param1\');\"></img>\n\t\t <img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\t\t <label id=\'DMYFromLabel\' style=\'visibility:visible\' vaue=\'(MM/YYYY)\'>(MM/YYYY)</label>\t\t  \n\t </td>\n\t <td class=\'label\' width=\'25%\' id=\"ToLabel\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </td>\n\t <td class=\'fields\' width=\'25%\' id=\"toid\">\n\t\t <input type=\'text\' name=\'param2\' id=\'param2\' size=\'5\'  value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onkeypress=\"return checkForSpecCharsforID(event);\"  maxlength=\'7\'>\n\t\t <img src=\'../../eCommon/images/CommonCalendar.gif\' style=\'visibility:visible\' id=\"TOMYcalendar\" onClick=\"return showCalendar(\'param2\',\'mm/y\');\">\n\t\t <img src=\'../../eCommon/images/CommonCalendar.gif\' style=\'visibility:hidden\' id=\"TODMYcalendar\"  onClick=\"return showCalendar(\'param2\');\"></img>\n\t\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t <label id=\'DMYToLabel\' style=\'visibility:visible\' vaue=\'(MM/YYYY)\'>(MM/YYYY)</label>\n\t </td>\n\t <td colspan=\'8\'></td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n    <td class=\'fields\' width=\'25%\'>\n\t\t<input type=\'hidden\' name=\'param4\' id=\'param4\' value=\"\">\n\t\t<input type=\'hidden\' name=\"param3\" id=\"param3\" value=\"\">\n\t\t<input type=\'text\' name=\'param3_desc\' id=\'param3_desc\' size=\'20\' onBlur=\"if(this.value!=\'\')srchCommonCode(param3,param3_desc,param4,operationType_title, document.forms[0].sql_text_2.value ); else {param3.value = \'\'; param4.value=\'\';}\"><input type=\'button\' class=\'button\' value=\'?\' name=\'OperCodeLookUp\' id=\'OperCodeLookUp\' onClick=\"srchCommonCode(param3,param3_desc,param4,operationType_title, document.forms[0].sql_text_2.value );\" >\n\t</td>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n    <td class=\'fields\' width=\'25%\' colspan=\'6\'>\n\t\t<input type=\'hidden\' name=\'param6\' id=\'param6\' value=\"\">\n\t\t<input type=\'hidden\' name=\"param5\" id=\"param5\" value=\"\">\n\t\t<input type=\'text\' name=\'param5_desc\' id=\'param5_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' param1 = \'param6\'  param2 = \'param6\' key =\'PROCEDURE\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param5.value=\'\',param6.value=\'\' \" colspan=\"2\">\n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'OperCodeLookUp\' id=\'OperCodeLookUp\' onClick=\"callCommonLookup(param5_desc);\" >\n\t</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'25%\' id=\"test\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t  <input type=\'hidden\' name=\'param17\' id=\'param17\' >\n\t  <input type=\'hidden\' name=\'param7\' id=\'param7\'>\n\t  <input type=\'text\' name=\'param7_desc\' id=\'param7_desc\' id=\'hidedesc\' title=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' size=\'20\' onBlur=\"if(this.value!=\'\')srchCommonCode(param7,param7_desc,param17,theatre_title,document.forms[0].qry_sql.value);else param7.value=\'\',param17.value=\'\'\">\n\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'CommonLookUp1\' id=\'CommonLookUp1\' id=\'hidelookup\' onClick=\"srchCommonCode(param7,param7_desc,param17,theatre_title,document.forms[0].qry_sql.value);\" >\n\t</td>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n    <td class=\'fields\' width=\'25%\' colspan=\'6\'>\n\t   <input type=\'hidden\' name=\'param10\' id=\'param10\' value=\"\"> \n\t   <input type=\'hidden\' name=\"param9\" id=\"param9\" value=\"\"> \n\t   <input type=\'text\' name=\'param9_desc\' id=\'param9_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' param1 = \'param9\'  param2 = \'param10\' key =\'SPECIALITY\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param9.value=\'\',param10.value=\'\' \">\n\t   <input type=\'button\' class=\'button\' value=\'?\' name=\'OperCodeLookUp\' id=\'OperCodeLookUp\' onClick=\"callCommonLookup(param9_desc);\" >\n\t</td>\t\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n     <td class=\'fields\' width=\'25%\'>\n        <input type=\'hidden\' name=\'param12\' id=\'param12\'>\n\t\t<input type=\'hidden\' name=\'param11\' id=\'param11\'>\n\t\t<input type=\'text\' name=\'param11_desc\' id=\'param11_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' param1 = \'param11\'  param2 = \'param12\' key =\'SURGEON\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param11.value=\'\',param12.value=\'\' \"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'OperTypeLookUp\' id=\'OperTypeLookUp\' onClick=\"callCommonLookup(param11_desc);\" >\n\t</td>\n\t\t<td class=\'label\' width=\'25%\' id=\"BillingGroupLabel\"> </td>\n\t\t<td class=\'fields\' width=\'25%\' id=\"BillingGroupId\">\n\t\t</td>\n\t\t</tr> \n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\" name=\"p_user_id\" id=\"p_user_id\"\tvalue=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"  value=\"OT\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"OTROPTPCA\">\n\t<input type=\"hidden\" name=\"report_id\" id=\"report_id\" value=\"OTROPTPCA\">\n\t<input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" value=\"OTROPTPCA\">\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\"\tvalue=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=\"hidden\" name=\"sql_text_1\" id=\"sql_text_1\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_2\" id=\"sql_text_2\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_3\" id=\"sql_text_3\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text\" id=\"sql_text\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_4\" id=\"sql_text_4\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" disabled>\n\t<input type=\"hidden\" name=\"qry_sql\" id=\"qry_sql\" value=\"SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' AND OPERATING_FACILITY_ID =\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2\" disabled>\n\n\t<input type=\"hidden\" name=\"mandatory_fm_1\" id=\"mandatory_fm_1\" id=\"mandatory_fm_1\" value=\"param1##";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" disabled>\n\t<input type=\"hidden\" name=\"mandatory_fm_2\" id=\"mandatory_fm_2\" id=\"mandatory_fm_2\" value=\"param2##";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" disabled>\n\t<input type=\"hidden\" name=\"no_of_mandatory_fields\" id=\"no_of_mandatory_fields\" value=\"2\" disabled>\n\t<input type=\"hidden\" name=\"no_of_compare_date_fields\" id=\"no_of_compare_date_fields\" value=\"1\" disabled>\n\t<input type=\"hidden\" name=\"compare_date_fm_1\" id=\"compare_date_fm_1\" value=\"param1##Registration Date\" disabled>\n    \t<input type=\"hidden\" name=\"compare_date_to_1\" id=\"compare_date_to_1\" value=\"param2\" disabled>\n\t<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\"\tvalue=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\t<input type=\"hidden\" name=\"no_of_comparison_fields\" id=\"no_of_comparison_fields\" value=\"0\" disabled>\n\n\t<input type=\"hidden\" name=\"no_of_comparison_fields\" id=\"no_of_comparison_fields\" value=\"3\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_1\" id=\"compare_fm_1\" value=\"param9##Operation Type\">\n    \t<input type=\"hidden\" name=\"compare_to_1\" id=\"compare_to_1\" value=\"param10\">\n\n\t<input type=\"hidden\" name=\"compare_fm_2\" id=\"compare_fm_2\" value=\"param3##Procedure\">\n    \t<input type=\"hidden\" name=\"compare_to_2\" id=\"compare_to_2\" value=\"param4\">\n\n \t<input type=\"hidden\" name=\"compare_fm_3\" id=\"compare_fm_3\" value=\"param7##Code\">\n    \t<input type=\"hidden\" name=\"compare_to_3\" id=\"compare_to_3\" value=\"param17\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\'hidden\' name=\'cur_date\' id=\'cur_date\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" name=\"param18\" id=\"param18\" value=\"N\" >\n\t<input type=\'hidden\' name=\'reportParams\' id=\'reportParams\' value=\"param1#param2#param9#param10#param4#param3#param6#param7#param17#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id\">\n\t<input type=\"hidden\" name=\"CURRENT_DATE\" id=\"CURRENT_DATE\" id=\"CURRENT_DATE\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" name=\"surgery_date\" id=\"surgery_date\" id=\"surgery_date\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\t\n </form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
 
	String locale = (String)session.getAttribute("LOCALE"); 
	locale=locale.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
 
	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String fromregistrationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationMonth.Label","ot_labels");
	
	String toregistrationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationMonth.Label","ot_labels");
	String fromdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	
	String todate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(fromdate));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(todate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fromregistrationdate));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(toregistrationdate));
            _bw.write(_wl_block11Bytes, _wl_block11);

	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	//String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operation.label","common_labels");
	/*String fromregistrationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationMonth.Label","ot_labels");	
	String toregistrationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationMonth.Label","ot_labels");
	String fromdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");	
	String todate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");*/
	String Surgeon_Title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String Theatre_Title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Theatre.label","common_labels");
	
	String surgery_date = "";
	String CURRENT_DATE="";
	if(facility_id == null) facility_id="";
	String  sql_surgeon = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"'  AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	//String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND B.EFF_STATUS='E' AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
	
	String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE  AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
	
	String  sql_role_type = "SELECT ROLE_TYPE CODE, nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF) DESCRIPTION FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ROLE_TYPE IN ('OS', 'AS') AND UPPER(nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF)) LIKE UPPER(?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) ORDER BY 2";

	String  sql_oper_procedure = "SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";
	String sql_time_range = "SELECT TIME_RANGE_CODE, TIME_RANGE_CODE FROM OT_OPER_TIME_RANGE ORDER BY 2";
		
	//String sql_Oper_Type="SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE_LANG_VW WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) AND LANGUAGE_ID ='"+locale+"'  ORDER BY 2";
	
	String sql_Oper_Type="SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE_LANG_VW WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) AND LANGUAGE_ID ='"+locale+"'  ORDER BY 2";//vikash 215
  
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//Buddhist date conversion (Thai Locale)
			surgery_date=com.ehis.util.DateUtils.convertDate(rst.getString("MON_YEAR"),"MY","en",locale);
			CURRENT_DATE = rst.getString("CURRENT_DATE");
		}

		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		pstmt = con.prepareStatement(sql_time_range);
		rst = pstmt.executeQuery();
	

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(procedure_title));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Theatre_Title));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(speciality_title));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Surgeon_Title));
            _bw.write(_wl_block29Bytes, _wl_block29);

	}catch(Exception e){
			System.err.println("Err Msg StatisticsBySpecialityReports.jsp "+e.getMessage());
		}finally{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request); 
		}

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sql_surgeon));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sql_Oper_Type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sql_role_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sql_oper_procedure));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sql_time_range));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(fromregistrationdate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(toregistrationdate));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CURRENT_DATE));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reporttype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OTbyCategorization.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OTbySpecialist.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OTStatisticalReport.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FromOperationMonth.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ToOperationMonth.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationType.Label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
