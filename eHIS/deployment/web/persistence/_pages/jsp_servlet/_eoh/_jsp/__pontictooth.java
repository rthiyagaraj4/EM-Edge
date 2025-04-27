package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import eOR.OrderEntryBillingQueryBean;
import eOR.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pontictooth extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PonticTooth.jsp", 1709119364598L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<html>\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t<head>\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eOH/js/OHCommon.js\"></script>\n\t\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t<script>\n\t\t\t\tfunction ponticToothValues(){\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tvar oRows = document.getElementById(\'pontic_table\').getElementsByTagName(\'tr\');\n\t\t\t\t\tvar iRowCount = oRows.length;\n\n\t\t\t\t\tvar oh_chart_level = document.forms[0].oh_chart_level.value;\n\t\t\t\t\tvar other_chart_facility_id = document.forms[0].other_chart_facility_id.value;\n\t\t\t\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\t\t\t\tvar chart_num = document.forms[0].chart_num.value;\n\t\t\t\t\tvar tooth_no = document.forms[0].tooth_no.value;\n\n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\tvar params_pontic_update = \"func_mode=getMaxChartLineNum&tooth_no=\"+tooth_no+\"&patient_id=\"+patient_id+\"&chart_num=\"+chart_num+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&trmt_category_type=BRIDGE\";\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?\"+params_pontic_update,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar retVal_max_chart_line_num = trimString(xmlHttp.responseText); \n\t\t\t\t\tretVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);\n\n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\tvar params_pontic_tooth = \"func_mode=getPonticCutToothValues&tooth_no=\"+tooth_no+\"&patient_id=\"+patient_id+\"&chart_num=\"+chart_num+\"&chart_line_num=\"+retVal_max_chart_line_num+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&oh_chart_level=\"+oh_chart_level+\"&trmt_category_type=BRIDGE\";\n\t\t\t\t\t\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?\"+params_pontic_tooth,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar retVal_bridge = trimString(xmlHttp.responseText); \n\t\t\t\t\tretVal_bridge = localTrimString(retVal_bridge);\n\t\t\t\t\tif(retVal_bridge.length > 0){\n\t\t\t\t\t\n\t\t\t\t\t\tvar retVal_pontic = retVal_bridge.split(\"##\");\n\t\t\t\t\t\tvar code_desc_arr = retVal_pontic[0].split(\"$$\");\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(code_desc_arr.length > 0){\n\t\t\t\t\t\t\tfor(var k = 0;k <= code_desc_arr.length;k++){\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor(var i = 1; i < iRowCount; i++){\n\t\t\t\t\t\t\t\t\tif(code_desc_arr[k] == document.getElementById(\"pontic_tooth_val\"+(i)).value){\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"pontic_tooth_check\"+(i)).checked = true;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"pontic_tooth_check\"+(i)).disabled = true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t   \n\t\t\t\t}\n\n\t\t\t\tfunction changeLegend(){\n\t\t\t\t\tvar oRows = document.getElementById(\'pontic_table\').getElementsByTagName(\'tr\');\n\t\t\t\t\tvar iRowCount = oRows.length;\n\t\t\t\t\tvar close_legend = getLabel(\"Common.close.label\",\"common_labels\");\n\t\t\t\t\tvar save_legend = getLabel(\"Common.record.label\",\"common_labels\");\n\t\t\t\t\tvar flag_legend = false;\n\t\t\t\t\tfor(var k = 1; k < iRowCount; k++){\n\t\t\t\t\t\tif(document.getElementById(\"pontic_tooth_check\"+(k)).checked && document.getElementById(\"pontic_tooth_check\"+(k)).disabled){\n\t\t\t\t\t\t\tcontinue;\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tflag_legend = true;\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(!flag_legend){\n\t\t\t\t\t\tdocument.getElementById(\"save_reset_button\").innerHTML =  \'<input type=\"button\" class=\"button\" id = \"save_reset_button\" name=\"save\" id=\"save\" align=\"center\" value=\"\'+close_legend+\'\" onclick =\"window.close();\">\';\n\t\t\t\t\t}else{\n\t\t\t\t\t\tdocument.getElementById(\"save_reset_button\").innerHTML =  \'<input type=\"button\" class=\"button\" id = \"save_reset_button\" name=\"save\" id=\"save\" align=\"center\" value=\"\'+save_legend+\'\" onclick =\"clearImage();\">&nbsp;<input type=\"button\" class=\"button\" id = \"save_reset_button\" name=\"save\" id=\"save\" align=\"center\" value=\"\'+close_legend+\'\" onclick =\"window.close();\">\';\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\tfunction setSeqCheckValue1(rowVal){\n\t\t\t\t\tvar formObj = document.forms[0];\n\t\t\t\t\tvar rowForward = rowVal;\n\t\t\t\t\tvar j = 0;\n\t\t\t\t\t\n\t\t\t\t\tif(document.getElementById(\"pontic_tooth_check\"+(rowVal)).checked){\n\t\t\t\t\t\tif((document.getElementById(\"pontic_tooth_check\"+(--rowVal)) != null) && (!(document.getElementById(\"pontic_tooth_check\"+(rowVal)).checked))) {\n\t\t\t\t\t\t\talert(getMessage(\"APP-OH000167\",\"OH\"));\n\t\t\t\t\t\t\tdocument.getElementById(\"pontic_tooth_check\"+(rowForward)).checked = false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tfunction setSeqCheckValue2(rowVal){\n\t\t\t\t\tvar formObj = document.forms[0];\n\t\t\t\t\tvar rowForward = rowVal;\n\t\t\t\t\tif(document.getElementById(\"pontic_tooth_check\"+(++rowVal)) != null){\n\t\t\t\t\t\tif(!(document.getElementById(\"pontic_tooth_check\"+(--rowVal)).checked)){\n\t\t\t\t\t\t\tif(document.getElementById(\"pontic_tooth_check\"+(++rowVal)).checked){\n\t\t\t\t\t\t\t\talert(getMessage(\"APP-OH000167\",\"OH\"));\n\t\t\t\t\t\t\t\tdocument.getElementById(\"pontic_tooth_check\"+(rowForward)).checked = true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\n\t\t\t\tfunction clearImage(){\n\t\t\t\t\tvar formObj = document.forms[0];\n\t\t\t\t\tvar patient_id = formObj.patient_id.value;\n\t\t\t\t\tvar chart_num = formObj.chart_num.value;\n\t\t\t\t\tvar oh_chart_level = formObj.oh_chart_level.value;\n\t\t\t\t\tvar other_chart_facility_id = formObj.other_chart_facility_id.value;\n\t\t\t\t\tvar tooth_no = formObj.tooth_no.value;\n\n\t\t\t\t\tvar pontic_tooth = new Array();\n\t\t\t\t\tvar pontic_tooth_split_values = new Array();\n\t\t\t\t\tvar l =0;\n\t\t\t\t\tvar k =0;\n\t\t\t\t\tvar oRows = document.getElementById(\'pontic_table\').getElementsByTagName(\'tr\');\n\t\t\t\t\tvar iRowCount = oRows.length;\n\t\t\t\t\tvar pontic_tooth_arr = formObj.pontic_tooth_arr;\n\t\t\t\t\tvar tooth_nos_arr = new Array();\n\t\t\t\t\tvar tooth_nos = \"\";\n\t\t\t\t\tvar j = 0;\n\t\t\t\t\tfor(i = 1; i < iRowCount; i++){\n\t\t\t\t\t\t//if(document.getElementById(\"pontic_tooth_check\"+(i)).checked && (!document.getElementById(\"pontic_tooth_check\"+(i)).disabled)){\n\t\t\t\t\t\tif(document.getElementById(\"pontic_tooth_check\"+(i)).checked) {\n\t\t\t\t\t\t\t tooth_nos_arr[j] =  document.getElementById(\"pontic_tooth_val\"+(i)).value;\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tcontinue;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tj++;\n\t\t\t\t\t}\n\t\t\t\t\ttooth_nos = tooth_nos_arr.join(\"$$\");\n\t\t\t\t    \n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\tvar params_bridge_extract = \"func_mode=getTrmtCatCode&tooth_no=\"+tooth_no+\"&patient_id=\"+patient_id+\"&chart_num=\"+chart_num+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?\"+params_bridge_extract,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar retVal_bridge_extract = trimString(xmlHttp.responseText); \n\t\t\t\t\tretVal_bridge_extract = localTrimString(retVal_bridge_extract);\n\t\t\t\t\tpontic_tooth = retVal_bridge_extract.split(\",\") ;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tif(tooth_no == (retVal_bridge_extract.substring(retVal_bridge_extract.lastIndexOf(\"$\")+1,retVal_bridge_extract.length))){\t// toothno == to the last number in the bridge \n\t\t\t\t\t\tfor(k = pontic_tooth.length-1;k >= 0;k--,l++){\n\n\t\t\t\t\t\t\tpontic_tooth_split_values[l] = pontic_tooth[k].substring((pontic_tooth[k].lastIndexOf(\"$\")+1),pontic_tooth[k].length) ;\n\n\t\t\t\t\t\t} \n\t\t\t\t\t}else{\n\t\t\t\t\t\tfor(k = 0; k < pontic_tooth.length;k++,l++){\n\t\t\t\t\t\t\tpontic_tooth_split_values[l] = pontic_tooth[k].substring((pontic_tooth[k].lastIndexOf(\"$\")+1),pontic_tooth[k].length) ;\n\t\t\t\t\t\t} \n\t\t\t\t\t}\n\t\t\t\t\tfor(var m =0; m < pontic_tooth_split_values.length; m++){\n\t\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\t\tvar params_pontic_update = \"func_mode=getMaxChartLineNum&tooth_no=\"+pontic_tooth_split_values[m]+\"&patient_id=\"+patient_id+\"&chart_num=\"+chart_num+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&trmt_category_type=BRIDGE\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?\"+params_pontic_update,false);\n\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\tvar retVal_max_chart_line_num = trimString(xmlHttp.responseText); \n\t\t\t\t\t\tretVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\t\tvar params_pontic_bridge_update = \"func_mode=updateCutPonticTooth&tooth_no=\"+pontic_tooth_split_values[m]+\"&patient_id=\"+patient_id+\"&chart_num=\"+chart_num+\"&chart_line_num=\"+retVal_max_chart_line_num+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&tooth_nos=\"+tooth_nos+\"&trmt_category_type=BRIDGE\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?\"+params_pontic_bridge_update,false);\n\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\tvar retVal_pontic_bridge_tooth = trimString(xmlHttp.responseText); \n\t\t\t\t\t\tretVal_pontic_bridge_tooth = localTrimString(retVal_pontic_bridge_tooth);\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\twindow.returnValue =  tooth_nos;\n\t\t\t\t\twindow.close();\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t</script>\n\t\t</head>\n\t\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onLoad=\"ponticToothValues();changeLegend();\">\n\t\t\t<form name=\'PonticToothForm\' id=\'PonticToothForm\' method=\'post\' action=\'\' target=\'messageFrame\'>\n\t\t\t<table id=\'pontic_table\' align=\'center\' cellpadding=\'2\' cellspacing=\'0\' border=\'1\' width=\'106%\' style=\'border:1px solid #666666\'>\n\t\t\t\t<td width=\"10%\" class=\"CAGROUPHEADING\" align=\"center\" nowrap>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t<td width=\"10%\" class=\"CAGROUPHEADING\" align=\"center\" nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<tr><td width=\"25%\" class=\"field\" align=\"center\" nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<input type=\"hidden\" id=\"pontic_tooth_val";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" > \n\t\t\t\t\t<td width=\"25%\" align=\"center\"><input type=\"checkbox\" id=\"pontic_tooth_check";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"  onClick=\"setSeqCheckValue1(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');setSeqCheckValue2(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" /></td></tr>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\n\t\t\t</table>\n\t\t\t<br></br>\n\t\t   <table width=\'106%\'>\n\t\t\t    <tr>\n\t\t\t\t   \t<td class=\"button\" colspan = \"4\" align=\"center\" id=\"save_reset_button\">\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\'pontic_tooth_arr\' id=\'pontic_tooth_arr\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t\t\t<input type=\"hidden\" name=\'title_desc\' id=\'title_desc\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t\t<input type=\"hidden\" name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\t\t\t<input type=\"hidden\" name=\'chart_num\' id=\'chart_num\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t\t<input type=\"hidden\" name=\'oh_chart_level\' id=\'oh_chart_level\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t\t\t<input type=\"hidden\" name=\'other_chart_facility_id\' id=\'other_chart_facility_id\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t\t<input type=\"hidden\" name=\'tooth_no\' id=\'tooth_no\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t\t\t<input type=\"hidden\" name=\'numbering_system\' id=\'numbering_system\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t\t\t</form>\n\t\t</body>\n\t</html>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}

	
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
 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	

	Connection con=null;

	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = request.getParameter( "patient_id" ) ;
	String chart_num = request.getParameter( "chart_num" ) ;
	String oh_chart_level = request.getParameter( "oh_chart_level" ) ;					    
	String other_chart_facility_id = request.getParameter( "other_chart_facility_id" ) ;
	String pontic_tooth = request.getParameter( "pontic_tooth" ) ;
	String numbering_system = request.getParameter( "numbering_system" ) ;

	String title_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PonticToothDtls.Label","oh_labels");  
	String tooth_no = request.getParameter( "tooth_no" ) ;

	String[] pontic_tooth_arr = null;
	String pontic_tooth_val = "";
	String pontic_tooth_checked = "";
	String pontic_tooth_disabled = "";

	String pontic_tooth_val_display = "";

	pontic_tooth_arr = 	pontic_tooth.split(",");
	
			
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}

	try{
		con = ConnectionManager.getConnection(request);

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(title_desc));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

				
				for(int i = 1; i< pontic_tooth_arr.length-1;i++){
					  pontic_tooth_val = pontic_tooth_arr[i];
					  if(i == 1){
						pontic_tooth_checked = "checked";
						pontic_tooth_disabled = "";

					  }else{
					  	pontic_tooth_checked = "";
					  }
					  //Added by Sharon Crasta on 3/8/2010 for IN019851
					  pstmt = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?");
					  pstmt.setString(1,numbering_system);
					  pstmt.setString(2,pontic_tooth_arr[i]);
					  rs = pstmt.executeQuery();
					  while(rs!= null && rs.next()){
						pontic_tooth_val_display = checkForNull(rs.getString("NS_TOOTH_NO"));
					  
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pontic_tooth_val_display));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pontic_tooth_val));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pontic_tooth_checked));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pontic_tooth_disabled));
            _bw.write(_wl_block18Bytes, _wl_block18);

					  }	//End
				} 
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pontic_tooth_arr));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(title_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tooth_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(numbering_system));
            _bw.write(_wl_block27Bytes, _wl_block27);

	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
				ConnectionManager.returnConnection(con,request);
		   }catch(Exception es){es.printStackTrace();}
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ToothNo.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Select.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
