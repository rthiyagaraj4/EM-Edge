package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.Common.*;
import eFM.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmissuefilesview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIssueFilesView.jsp", 1734166555222L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMIssueFiles.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/checkSystemDate.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script><!-- Supporting Js File For Fixed Header with scroll.... -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \n\n</head>\n<SCRIPT>\nIssueTabSel=\'Y\';\n<!-- Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 25th 2014 Start -->\nwindow.onload=function(){\n\n\tif(document.getElementById(\"ViewTabledata\")!=null && document.forms[0].fileCount.value > 0){\t\n\t\tfxheaderInit(\'ViewTabledata\',420);\n\t}\n};\n<!-- Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 25th 2014 End -->\n\n\nfunction ValidateDateTime(from,sys_date) {\n\tvar originalObj = from ;\n\tvar obj=from;\n\tif(from.value!=\"\") {\n\t  var obj=convertDate(from.value,\"DMYHM\",localeName,\"en\");\n\t\tif(doDateTimeChk(obj)) {\n\t\t\t//from = from.value\n\t\t\tfrom = obj;\n\t\t\tsys_date =\tsys_date.value;\n\t\t\t\n\t\t\tvar a=  from.split(\" \");\n\t\t\tsplitdate=a[0];\n\t\t\tsplittime=a[1];\n\n\t\t\tvar splitdate1 =a[0].split(\"/\");\n\t\t\tvar splittime1= a[1].split(\":\");\n\n\t\t\tvar from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\t\t\t\t\n\t\t\ta= sys_date.split(\" \");\n\t\t\tsplitdate=a[0];\n\t\t\tsplittime=a[1];\n\n\t\t\tsplitdate1 =a[0].split(\"/\");\n\t\t\tsplittime1= a[1].split(\":\");\n\n\t\t\tvar sys_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));\n\t\t\t\n\t\t\tif(Date.parse(from_date) >= Date.parse(sys_date)) {\n\t\t\t\tvar msg = \"\";\n\t\t\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\t\t\treturn true;\n\t\t\t} else {\n\t\t\t\tvar msg = getMessage(\'RETURN_DATE_NOT_LESS_SYSDATE\',\'FM\');\n\t\t\t\talert(msg);\n\t\t\t\toriginalObj.value=\"\";\n\t\t\t\toriginalObj.focus();\n\t\t\t\toriginalObj.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t} else if(doDateTimeChk(from)== false) {\n\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"));\n\t\t\toriginalObj.value=\"\";\n\t\t\toriginalObj.focus();\n\t\t\toriginalObj.select();\n\t\t\treturn false;\t\n\t\t}\n\t}\n}\n\n\n\n</SCRIPT>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n<form name=\'IssueFileView_form\' id=\'IssueFileView_form\'>\n\t<Script>\n\tfunction tab_click1(id) \n\t{\n\t\tselectTab(id);\n\t\tobjClick(id);\n\t}\n\nfunction objClick(objName) {\n\tif(objName == \'page_one_tab\') { \n\t\t//parent.parent.parent.frames[2].IssueFileFrameSet.rows=\'6%,4%,33%,*,9%\';\n\t\tparent.parent.parent.frames[2].document.getElementById(\"commontoolbarFrame\").style.height = \'6vh\';\n\t\tparent.parent.parent.frames[2].document.getElementById(\"issue_header\").style.height = \'4vh\';\n\t\tparent.parent.parent.frames[2].document.getElementById(\"issue_tab\").style.height = \'81vh\';\n\t\tparent.parent.parent.frames[2].document.getElementById(\"issue_detail\").style.height = \'0vh\';\n\t\tparent.parent.parent.frames[2].document.getElementById(\"messageFrame\").style.height = \'9vh\';\n\t\tparent.parent.frames[2].location.href = \'../../eFM/jsp/FMIssueFilesTab.jsp?userSecurity=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&resLocnIdentities=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&strLocn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&refresh=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&access_all=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&file_type_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\tparent.parent.issue_detail.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.parent.frames[1].document.forms[0].selected_tab.value=\'page_one_tab\';\n\t} else if(objName == \'page_two_tab\') {\n\t\t\t//parent.parent.parent.frames[2].IssueFileFrameSet.rows=\'6%,4%,*,0%,9%\';\n\t\t\t\t\tparent.parent.parent.frames[2].document.getElementById(\"commontoolbarFrame\").style.height = \'6vh\';\n\t\t\t\t\tparent.parent.parent.frames[2].document.getElementById(\"issue_header\").style.height = \'4vh\';\n\t\t\t\t\tparent.parent.parent.frames[2].document.getElementById(\"issue_tab\").style.height = \'81vh\';\n\t\t\t\t\tparent.parent.parent.frames[2].document.getElementById(\"issue_detail\").style.height = \'0vh\';\n\t\t\t\t\tparent.parent.parent.frames[2].document.getElementById(\"messageFrame\").style.height = \'9vh\';\n\t\t\tparent.parent.frames[2].location.href = \'../../eFM/jsp/FMIssueFileManualEntry.jsp?userSecurity=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\tparent.parent.frames[1].document.forms[0].selected_tab.value=\'page_two_tab\';\n\n\t\t\t\n\t} else if(objName == \'page_three_tab\') {\n\t\tparent.parent.parent.frames[2].document.getElementById(\"commontoolbarFrame\").style.height = \'6vh\';\n\t\tparent.parent.parent.frames[2].document.getElementById(\"issue_header\").style.height = \'4vh\';\n\t\tparent.parent.parent.frames[2].document.getElementById(\"issue_tab\").style.height = \'81vh\';\n\t\tparent.parent.parent.frames[2].document.getElementById(\"issue_detail\").style.height = \'0vh\';\n\t\tparent.parent.parent.frames[2].document.getElementById(\"messageFrame\").style.height = \'9vh\';\n\t// Changes Modified By Saanthaakumar\n\t\t\t//parent.parent.parent.frames[2].IssueFileFrameSet.rows=\'6%,4%,10%,*,9%\';\n\t\t\tparent.parent.frames[2].location.href = \'../../eFM/jsp/FMIssueFilesViewMain.jsp?file_type_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&userSecurity=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\tparent.parent.frames[1].document.forms[0].selected_tab.value=\'page_three_tab\';\n\t}\n\t}\t\n</Script>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t\t<tr>\n\t\t<td width= \"85%\" class=\"white\">\n\t\t<ul id=\"tablist\" class=\"tablist\" style=\"width: 1330px; padding-left: 5px;\">\n\t\t\t<li class=\"tablistitem\" title=\"Outstanding Request\">\n\t\t\t\t<a onclick=\"tab_click1(\'page_one_tab\')\" class=\"tabA\" id=\"page_one_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"page_one_tabspan\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Manual Request\">\n\t\t\t\t<a onclick=\"tab_click1(\'page_two_tab\')\" class=\"tabA\" id=\"page_two_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"page_two_tabspan\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t\t<li class=\"tablistitem\" title=\"Issue File\">\n\t\t\t\t<a onclick=\"tab_click1(\'page_three_tab\')\" class=\"tabClicked\" id=\"page_three_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"page_three_tabspan\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t</ul>\n\t\t<td width=\"10%\" class=\'button\' id=\"tab1\">\t<input type=\'button\' class=\'button\' name=\'add\' id=\'add\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' \t\t\tonClick=\"javascript:GetRemarks(); \"><input type=\"hidden\" name=\"file_transport_mode\" id=\"file_transport_mode\" value=\"\"><input type=\"hidden\" name=\"carried_by_name\" id=\"carried_by_name\" value=\"\">\n\t </td>\n\t </tr>\n\t </table>\n\t<!-- The below line is required to change the select state of \'Outstanding Request\' tab initially selected -->\n\t<script>prevTabObj=\'page_three_tab\'</script>\n\t<table border=\"1\" width=\"100%\" style=\'border-spacing:0px ;border-collapse: collapse;\' id=\'ViewTabledata\'>\n \t<td class=\'COLUMNHEADER\' width=\'14%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td> \t\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\t\n\t\t<td class=\'COLUMNHEADER\' width=\"5%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\t\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t<td class=\'COLUMNHEADER\'><!--Modified for this CRF HSA-CRF-0306";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="--> <!--Modified by Ashwini on 18-Jul-2017 for ML-MMOH-SCF-0763-->";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="?</td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t        <tr>\n\t\t        <td  width=\"90%\" height=\"20\" colspan=8  class=\'CAGROUPHEADING\' ><b>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</b></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t        <tr>\n\t\t        <td  width=\"90%\" height=\"20\" colspan=8 class=\'CAGROUPHEADING\' ><b>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<td class=\'\"+classValue+\"\' >\n\t\t<input type=\'text\' name=\'retdate";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'retdate";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'datetd";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' size=\'16\' maxlength=\'16\' tabIndex=\'3\' value=\'\' onBlur=\"ValidateDateTime(this,sys_date);";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="holiday(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"><img name=\'im";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'retdate";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\', null, \'hh:mm\');\" onMouseover=\"changeCursor(this)\"></img>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t  \t\t\n\t\t\t<SCRIPT>\n\t\t\t    if(\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"==\"true\"){ \n\t\t\t\t    if(\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"==\"true\")document.forms[0].retdate";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =".value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"; \t\t\t\t\t\n\t\t\t\t    document.forms[0].retdate";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =".disabled = false; \n\t\t\t\t\tdocument.forms[0].im";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =".disabled    = false ;\t\n                    \t\t\t\t\t\n\t\t\t\t}else{\t\t\t\t\n\t\t    \tdocument.forms[0].retdate";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =".value    = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"; \n\t\t\t\tif(\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"==\"I\" && \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" > 0){\n\t\t\t\t\tdocument.forms[0].retdate";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =".disabled = true; \n\t\t\t\t\tdocument.forms[0].im";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =".disabled      = true; \n\t\t\t\t} else{\t\t\t\n\t\t\t\t\tdocument.forms[0].retdate";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =".disabled    = false ;\n\t\t\t   }\n\t\t\t }\n             <!--End Added for this CRF HSA-CRF-0306.1 -->\t\t\t \n\t\t\t\n\t\t\t</SCRIPT> \n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\t\t\n\t\t\t<SCRIPT>\n\t\t\t\tif(document.forms[0].retdate";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =".disabled  == true)\n\t\t\t\tdocument.forms[0].retdate";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =".disabled = false;\n\t\t\t\tif(document.forms[0].im";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =".disabled  == true)\n\t\t\t\t\tdocument.forms[0].im";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =".disabled = false\n\t\t\t    </SCRIPT> \n\t\t\t   ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t <a href=\'javascript:GetIssueFileViewRemarks(";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =")\'>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</a></font></td>\n\t\n\t\t<input type=\"hidden\" name=\"rem_recnum_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"rem_recnum_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" value=\"\">\n\t\t<input type=\"hidden\" name=\"file_transport_mode";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"file_transport_mode";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" value=\"\">\n\t\t<input type=\"hidden\" name=\"carried_by_name";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"carried_by_name";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" value=\"\">\n\t\t<input type=\"hidden\" name=\"ret_date";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"ret_date";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" value=\"\">\n\t\t<input type=\'hidden\' name=\'tab_check\' id=\'tab_check\' value=\'1\'>\n\t\t<!--Below line added for this CRF HSA-CRF-0306.1 --> \t\t\n\t\t<input type=\'hidden\' name=\"return_date";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"return_date";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\t\t\n\t\t<input type=\'hidden\' name=\"fslocn_return_criteria";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"fslocn_return_criteria";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"> \n        <input type=\'hidden\' name=\"dischargedatetime";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"dischargedatetime";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"> \t\t\n\t\t<!--End HSA-CRF-0306.1-->\t\t\n\t\t<input type=\'hidden\' name=\'Patient_Id\' id=\'Patient_Id\' value=";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =">\n\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t<input type=\"hidden\" name=\"comm_file_transport_mode\" id=\"comm_file_transport_mode\" value=\"\">\n\t<input type=\"hidden\" name=\"comm_carried_by_name\" id=\"comm_carried_by_name\" value=\"\">\n\t<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t<input type=\'hidden\' name=\'isCurrentFsLocation\' id=\'isCurrentFsLocation\' value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"><!--Added for this CRF HSA-CRF-0306.1-->\n\t<input type=\'hidden\' name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">    \n\t\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

	public boolean sortFMFilesIssueCart(webbeans.eFM.FMFilesIssueCart FMIssueFilesCart) throws Exception
	{
		String	Rec_Locn_Code	=	"", next_Rec_Locn_Code		=	"";
		boolean	isSorted		=	true;

		ArrayList ArrFileCart						= (ArrayList) FMIssueFilesCart.getPresCart();
		webbeans.eFM.FMFilesIssueDetail fissuebean	= new webbeans.eFM.FMFilesIssueDetail();
		webbeans.eFM.FMFilesIssueDetail fissuebean2 = new 	
		webbeans.eFM.FMFilesIssueDetail();
		
		try
		{
			for( int i=0; i<ArrFileCart.size(); i++ )
			{
				for(int j=0; j<ArrFileCart.size()-1-i;j++)
				{
					fissuebean	=	FMIssueFilesCart.getIssuesfromCart(j);
					Rec_Locn_Code	=	(String)			
					fissuebean.getRec_Locn_Code();
					fissuebean2	=	FMIssueFilesCart.getIssuesfromCart(j+1);
					next_Rec_Locn_Code	=	(String)				fissuebean2.getRec_Locn_Code();

					if(Rec_Locn_Code.compareToIgnoreCase(next_Rec_Locn_Code)<0)
					{
	    FMIssueFilesCart.updIssuestoCart(fissuebean2.cloneFMFilesIssueDetail(), j);
		FMIssueFilesCart.updIssuestoCart(fissuebean.cloneFMFilesIssueDetail(), j+1);
					}
				}
			}
		}catch(Exception e){isSorted = false;}
		return isSorted;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
 

            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eFM.FMFilesIssueCart FMIssueFilesCart= null;synchronized(session){
                FMIssueFilesCart=(webbeans.eFM.FMFilesIssueCart)pageContext.getAttribute("FMIssueFilesCart",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMIssueFilesCart==null){
                    FMIssueFilesCart=new webbeans.eFM.FMFilesIssueCart();
                    pageContext.setAttribute("FMIssueFilesCart",FMIssueFilesCart,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            eFM.FMIssueFileAddBean FMIssueFileAddBean= null;synchronized(session){
                FMIssueFileAddBean=(eFM.FMIssueFileAddBean)pageContext.getAttribute("FMIssueFileAddBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMIssueFileAddBean==null){
                    FMIssueFileAddBean=new eFM.FMIssueFileAddBean();
                    pageContext.setAttribute("FMIssueFileAddBean",FMIssueFileAddBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection conn				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	java.sql.Statement stmt     = null;
	ResultSet rs				= null;
	String classValue			= "";
	String otherValue			= "";
	String sql					= "";
	String daystoreturn			= "";
	String reqlocndesc			= "";	
	String p_locncode			= "";	
	//String sys_date_query		= "";
	String sys_date				= "";
	String return_criteria		= "";
	String returndays			= "";
	String userSecurity			= request.getParameter("userSecurity");
	String resLocnIdentities	= request.getParameter("resLocnIdentities");
	String refresh 				= request.getParameter("refresh ");
	String strLocn				= request.getParameter("strLocn");
	String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
//	String file_doc				= request.getParameter("file_doc");	
	String file_type_yn			= request.getParameter("file_type_yn")==null?"N":request.getParameter("file_type_yn");
	String file_type_appl_yn	= request.getParameter("file_type_yn");
	//Added for this CRF HSA-CRF-0306.1
	boolean isCurrentFsLocation=false;	
		
	String dischargedatetime=""; //Added CRF HSA-CRF-0306.1
	
	Properties p=(java.util.Properties) session.getValue("jdbc"); 
	java.sql.Statement stmt1	= null;
	ResultSet rset1				= null;
	
	try
	{
		
		conn	= ConnectionManager.getConnection(request);
        
        isCurrentFsLocation = CommonBean.isSiteSpecific(conn,"FM","CURRENT_FS_LOCATION");//Added for this CRF HSA-CRF-0306	
       

		if((file_type_appl_yn==null) || (file_type_appl_yn.equals("null"))) file_type_appl_yn = "N";

	/*	sys_date_query = "select to_char(sysdate,'dd/mm/yyyy hh24:mi')from dual";
		stmt = conn.createStatement();
		rs   = stmt.executeQuery(sys_date_query);
		if(rs !=null && rs.next())
		{
			sys_date = rs.getString(1);
		} if(rs !=null) rs.close();  ) */

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(refresh));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(refresh));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(refresh));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 if (file_type_appl_yn.equals("N")) { 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
 } else if (file_type_appl_yn.equals("Y")) { 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
 } 
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
if(isCurrentFsLocation){

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

	sortFMFilesIssueCart(FMIssueFilesCart);
	ArrayList ArrFileCart	= (ArrayList) FMIssueFilesCart.getPresCart();
	int countRec			= ArrFileCart.size();

	if(countRec > 0)
	{
		out.println("<script>if (parent.parent.parent.frames[2].document.getElementById('tab1')) { parent.parent.parent.frames[2].document.getElementById('tab1').style.visibility='visible'; parent.parent.parent.frames[2].document.getElementById('tab1').style.display='inline'; }</script>");
	}
	
	int ind = 0;
	
	for(ind=0;ind < ArrFileCart.size();ind++)
	{
		if( ind % 2 == 0) classValue = "QRYEVEN" ;
		else classValue = "QRYODD" ;
		
		webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
		fissuebean = FMIssueFilesCart.getIssuesfromCart(ind);	
		//String issue_remarks			= request.getParameter("rem_recnum_"+ind);
		
		
//		String indval			= fissuebean.getIndex_Value();
		String fileno			= fissuebean.getFile_No();
		String pline			= fissuebean.getPatient_Line();
		pline=java.net.URLDecoder.decode(pline,"UTF-8");
		String Patient_Id		= fissuebean.getPatient_Id();
		String reqno			= fissuebean.getReq_No();
		String file_type		= fissuebean.getFile_Type();
		String volume_no		= fissuebean.getVolume_No();
		String reqby			= fissuebean.getRec_Name_Desc();
		String locncode			= fissuebean.getRec_Locn_Code();
		String locn_identity	= fissuebean.getRec_Locn_Identity();
		String fac_id			= fissuebean.getReq_Facility_Id();
//		String from				= fissuebean.getRequest_From();
		String reqfrom			= fissuebean.getRequest_From();
		String  Reqlocnid     =fissuebean.getRequesting_From(); 
		
		
		
		
		/*Below line added for the incident [46675]*/
		String reqdatetime		= fissuebean.getRequest_Date_Time();				
		if(reqdatetime==null) reqdatetime="";
		if(!reqdatetime.equals(""))  reqdatetime=DateUtils.convertDate(reqdatetime,"DMYHM","en",localeName);
		//End incident [46675]
		
		String mlc_check		= fissuebean.getMLC_Check();
		String file_type_desc	= fissuebean.getFile_Typedesc();
		if((file_type == null) || (file_type.equals("")))  file_type = "";
		if (volume_no == null)  volume_no = "&nbsp;";
		String number			= "";
		String duration_type	= "";
		String fslocn_return_criteria="",permanent_file_area_yn="",fslocn_identity="";//Added for this CRF HSA-CRF-0306.1
		

		int hrs = 0;	
    /*below line modified for this incident  [IN:058795]*/      		
	//if(locn_identity.equals("C") || locn_identity.equals("N")|| locn_identity.equals("E") ||  locn_identity.equals("D") || locn_identity.equals("Y")){
	if(locn_identity.equals("C") || locn_identity.equals("N")|| locn_identity.equals("E") ||  locn_identity.equals("D") || locn_identity.equals("Y") || locn_identity.equals("T")){ // Modified By Dharma on Aug 3rd 2016 agianst ML-MMOH-SCF-0466 [IN:061037]
		
		sql="SELECT (CASE  WHEN locn_identity IN 'C' and exists (SELECT 1 FROM op_clinic             WHERE clinic_type = 'C' AND level_of_care_ind = 'E'   AND clinic_code = ? AND mr_location_code = ? ) THEN  no_of_dh_to_return_em     ELSE (CASE                  WHEN locn_identity IN ('C', 'E') THEN no_of_dh_to_return_op   ELSE (CASE                            WHEN locn_identity = 'N' THEN no_of_dh_to_return_ip    ELSE (CASE                                      WHEN locn_identity = 'Y' THEN no_of_dh_to_return_dc   END)  END)                  END) END) no_of_dh_to_return,duration_type,return_criteria,permanent_file_area_yn,locn_identity FROM fm_storage_locn WHERE fs_locn_code = ? AND facility_id = ? " ;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,Reqlocnid);
			pstmt.setString(2,locncode);
			pstmt.setString(3,locncode);
			pstmt.setString(4,fac_id);
			rset = pstmt.executeQuery();
			while(rset != null && rset.next())
			{
				number			= rset.getString(1);
				duration_type	= rset.getString(2);
				fslocn_return_criteria= rset.getString(3); //Added for this CRF HSA-CRF-0306.1
				permanent_file_area_yn= rset.getString(4);	
			    fslocn_identity= rset.getString(5);
			}
			
			if(rset  !=null) rset.close();
			if(pstmt !=null) pstmt.close();

			if(number==null || number.equals("")) number = "0";
			if(duration_type == null || duration_type.equals("null"))	  duration_type = "";
			
			//Added for this CRF HSA-CRF-0306.1
			if(fslocn_return_criteria == null || fslocn_return_criteria.equals("null")) fslocn_return_criteria = ""; 
			if(fslocn_return_criteria.equals("")) fslocn_return_criteria="I";
			
        if(duration_type.equals("D")) hrs = Integer.parseInt(number)*24;
			else if(duration_type.equals("H")) hrs = Integer.parseInt(number);
			
		}

		//sql = "Select to_char(SYSDATE+"+(hrs)+"/24,'DD/MM/YYYY HH24:MI') RET, SHORT_DESC,RETURN_CRITERIA from FM_STORAGE_LOCN Where FACILITY_ID = ? and FS_LOCN_CODE = ? ";
		sql = "SELECT To_char(SYSDATE + "+(hrs)+" / 24,'DD/MM/YYYY HH24:MI') RET, SHORT_DESC, RETURN_CRITERIA,to_char(sysdate,'dd/mm/yyyy hh24:mi') sydat FROM   FM_STORAGE_LOCN_LANG_VW WHERE  FACILITY_ID = ? AND FS_LOCN_CODE = ? AND LANGUAGE_ID=? ";
 	   
	   pstmt = conn.prepareStatement(sql);
	   
		pstmt.setString(1,fac_id);
		pstmt.setString(2,locncode);
		pstmt.setString(3,localeName);
		rset = pstmt.executeQuery();

		if(rset != null && rset.next())
		{
			returndays		= rset.getString(1);
			reqlocndesc		= rset.getString(2);
			return_criteria = rset.getString(3);
		   sys_date     = rset.getString(4);
		}
		
		if(rset  !=null) rset.close();
		if(pstmt !=null) pstmt.close();		

     if(return_criteria == null || return_criteria.equals("null")) return_criteria = "";
	  if(hrs<=0 || return_criteria.equals("D"))
		{
     returndays =null;
		}
		if((file_type_desc==null) || (file_type_desc.equals(""))) file_type_desc = "&nbsp;";
		//else file_type_desc =file_type_desc + " / " ;
        else file_type_desc =file_type_desc;
		if(returndays != null )
		{
		returndays=DateUtils.convertDate(returndays,"DMYHM","en",localeName);
		}else
			returndays = "";

		
		
		if(return_criteria.equals("I") || locn_identity.equals("D")|| locn_identity.equals("C")|| 
		locn_identity.equals("N"))
		{
			daystoreturn = returndays;
			}
		else
		{
			daystoreturn = "";
		 }

		if(reqno.equals("")) reqno = "&nbsp;";
		if(reqfrom.equals("S") || reqfrom.equals("MS")) otherValue = "lightgreen";  //"CCEEDD";
		else if(reqfrom.equals("D") || reqfrom.equals("MD")) otherValue = "lightpink";	//"FFEECC";
		
		
		//Added for this CRF HSA-CRF-0306.1	
				
		String returndate="";
        int hours=0;
        boolean comparecurrDate=true;		
	   
	  //if(isCurrentFsLocation&&(!dischargedatetime.equals("")&&fslocn_return_criteria.equals("D"))|| fslocn_return_criteria.equals("I")){
	   if(isCurrentFsLocation){	   
	   
	   int recorCount=0;	   
	   //Added for this CRF HSA-CRF-0306.1	
		 ArrayList List=(ArrayList)FMCurrentEncounterDetails.getFileCurrentEncounterDetails(conn,Patient_Id,Reqlocnid,locn_identity,fac_id,p);
		 recorCount=List.size();  
		 for(int k=0; k<List.size(); k++){
			   FMCurrentEncounterDetailsBean currencounterDetails=(FMCurrentEncounterDetailsBean)List.get(k);            
			   dischargedatetime=currencounterDetails.getDischargedatetime();		
			   if((dischargedatetime==null) || (dischargedatetime.equals("null")))	dischargedatetime = "";
		 }	
		//End HSA-CRF-0306.1	   
	   
	   
	   //Added HSA-CRF-0306.1
	   
	  String assigncare_locn="";
	   if(!locn_identity.equals("") && locn_identity.equals("Y")){
	   try{
	     assigncare_locn=FMCurrentEncounterDetails.getCurrentAssignCareLocation(conn,Patient_Id,Reqlocnid,fac_id,p);
		 Reqlocnid=assigncare_locn;
	    }catch(Exception e){
	      e.printStackTrace() ;
	    }
	   }
	   
		//End HSA-CRF-0306.1
		
		hours = Integer.parseInt(number);			
		/*String returndateSqlQuery="select FM_GET_RETURN_DATE("+hours+",'"+fac_id+"','"+PatientClass+"','"+Assigncarecode+"','"+fileno+"',"+volume_no+",'"+Patient_Id+"','"+strLocn+"','"+fslocn_return_criteria+"','"+duration_type+"','FI') returndate from dual";*/
		
		String returndateSqlQuery="select FM_GET_RETURN_DATE("+hours+",'"+fac_id+"','"+Reqlocnid+"','"+fileno+"',"+volume_no+",'"+Patient_Id+"','"+strLocn+"','"+fslocn_return_criteria+"','"+duration_type+"','FI') returndate from dual";
		
                  
		 
		 stmt1 = conn.createStatement();
		 rset1 = stmt1.executeQuery(returndateSqlQuery);
    	 if(rset1 != null && (rset1.next())){
		      // returndate =rset1.getString("returndate");
             returndate =rset1.getString("returndate")==null?"":rset1.getString("returndate");          
		 }	
         		 
		
	  
 if(returndate == null || returndate.equals("null"))	returndate="";
 
	if(!returndate.equals("") && returndate!=null && !returndate.equals("null")){	
	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
     	    java.util.Date retd1 = null;
		    java.util.Date sysd2 = null;		
			retd1 = format.parse(returndate);
			sysd2 = format.parse(sys_date);
			 if(retd1.compareTo(sysd2)<0){
			 comparecurrDate=false;	             		 
			 }	  
		} 
		 
		   if(rset1!=null)	rset1.close();
		   if(stmt1!=null) stmt1.close();	   
		   if(returndate==null) returndate="";
		   if(!returndate.equals("") || returndate!=null){
				  returndate=DateUtils.convertDate(returndate,"DMYHM","en",localeName);
			}
			           
		  			
	  }	 
	   //End HSA-CRF-0306.1
		
		

        if(ind == 0)
        {
			p_locncode = locncode;
			
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(reqlocndesc));
            _bw.write(_wl_block33Bytes, _wl_block33);

        }
		else if (!p_locncode.equals(locncode))
        {
			p_locncode = locncode;
			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(reqlocndesc));
            _bw.write(_wl_block33Bytes, _wl_block33);

		}
		out.println("<tr><td class='"+classValue+"' nowrap><font size='1'>");
		out.println(reqdatetime);
		if(file_type_appl_yn.equals("Y"))
		{
			out.println("</font></td><td class='"+classValue+"'><font size='1'><b>");
			out.println("</b><br>&nbsp;&nbsp;"+pline);
			out.println("</font></td><td class='"+classValue+"' align='CENTER'><font size='1'>");
			out.println(file_type_desc+volume_no);
		}
		else if (file_type_appl_yn.equals("N"))
		{

			out.println("</font></td><td class='"+classValue+"'><font size='1'><b>");
			out.println(fileno+"</b><br>&nbsp;&nbsp;"+pline);
			out.println("</font></td><td class='"+classValue+"' align='CENTER'><font size='1'>");
			out.println(volume_no);
		}
		out.println("</font></td><td class='"+classValue+"'><font size='1'>");
		out.println(reqno);
		out.println("</font></td><td class='"+classValue+"'><font size='1'>");
		out.println(reqby);
		out.println("</font></td>");
		
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(isCurrentFsLocation){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ind));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block44Bytes, _wl_block44);
		
		if(locn_identity.equals("C") || locn_identity.equals("N") || locn_identity.equals("D") || locn_identity.equals("E") || locn_identity.equals("Y"))
		{      /*Above line modified for this CRF HSA-CRF-0306.1*/
			
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(isCurrentFsLocation));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(comparecurrDate));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(returndate));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(daystoreturn));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(return_criteria));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(number));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block58Bytes, _wl_block58);

		}
		else if(locn_identity.equals("T") || locn_identity.equals("D"))
		{
			
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block63Bytes, _wl_block63);

		   }
		  out.println("<td class='"+classValue+"'><font size='1'>");
		 
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(ind));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(ind));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(returndate));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(ind));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(ind));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(fslocn_return_criteria));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(ind));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(ind));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(dischargedatetime));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block82Bytes, _wl_block82);

		out.println("</font></td><td style='background-color:"+otherValue+";' align='CENTER'>");
		if(mlc_check.equals("Y"))
		{
			if(reqfrom.equals("MS") || reqfrom.equals("MD"))
				out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'><img src='../../eFM/images/stop.gif' align='center'></img>#");
			else
				out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;<img src='../../eFM/images/stop.gif' align='center'></img>");
		}
		else
		{
			if(reqfrom.equals("MS") || reqfrom.equals("MD"))
				out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;#");
			else
				out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;");
		}
		out.println("</font></td></tr>");
	}
	out.println("<input type='hidden' name='fileCount' id='fileCount' value=\""+ind+"\">");
if(rs    !=null) rs.close();
if(rset  !=null) rset.close();
if(stmt  !=null) stmt.close();
if(pstmt !=null) pstmt.close();
}catch(Exception e){out.println("Exception e :"+e);}
finally
{	
	ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(isCurrentFsLocation));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block86Bytes, _wl_block86);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.OutstandingRequest.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ManualRequest.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.IssueFile.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeOfTransport.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.requesteddate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileNoPatientDetails.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.VolumeNo.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileTypeVolumeNo.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestNo.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestedBy.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReturnDueDateTime.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReturnDate.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReturnDueDateTime.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransportMode.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Issue.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeOfTransport.label", java.lang.String .class,"key"));
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
}
