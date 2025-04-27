package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patientprofilecontent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatientProfileContent.jsp", 1743594396931L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n        \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n    <script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n    <script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n\t<script src=\"../js/PatHighRisk.js\" language=\"javascript\"></SCRIPT>\n\t<script src=\"../../ePH/js/Prescription_1.js\" language=\"javascript\"></script>\n\t<script>\n\t    function display_records(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)\n\t\t{\n\t\n\t\t\teval(\"document.forms[0].detail\"+obj).innerHTML=\"<a href=\'#\'  onClick=\\\" display_records1(\'\"+obj+\"\',\'\"+PatientId+\"\',\'\"+causative_code+\"\',\'\"+adv_event_type_ind_code+\"\',\'\"+adv_event_type_code+\"\',\'\"+reaction_date1+\"\',\'\"+status+\"\',\'\"+error_status+\"\',\'\"+onset_date+\"\')\\\"><font color=\'black\' bgcolor=\'#FF9933\'>-</font></a>\";\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\txmlStr =\"<root><SEARCH PatientId=\\\"\"+PatientId+\"\\\"  adv_event_type_ind_code=\\\"\"+adv_event_type_ind_code+\"\\\" adv_event_type_code=\\\"\"+adv_event_type_code+\"\\\" causative_code=\\\"\"+causative_code+\"\\\"\treaction_date1=\\\"\"+reaction_date1+\"\\\"  cnt=\\\"\"+obj+\"\\\" status=\\\"\"+status+\"\\\" error_status=\\\"\"+error_status+\"\\\" onset_date=\\\"\"+onset_date+\"\\\" det=\'add\' steps=\'7\'/></root>\"\n\t\n\t\t\tvar xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\txmlHttp.open(\"POST\",\"../../eCA/jsp/AdverseEventType.jsp\",false)\t\t   \n\t\t\txmlHttp.send(xmlDoc)\n\t\t\tresponseText=xmlHttp.responseText\n\t\t\tresponseText = trimString(responseText)\n\t\t\teval(responseText)\n\t\t}\n\n\t\tfunction display_records1(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)\n\t\t{\n\t\t\teval(\"document.forms[0].detail\"+obj).innerHTML=\"<a href=\'#\' onClick=\\\"display_records(\'\"+obj+\"\',\'\"+PatientId+\"\',\'\"+causative_code+\"\',\'\"+adv_event_type_ind_code+\"\',\'\"+adv_event_type_code+\"\',\'\"+reaction_date1+\"\',\'\"+status+\"\',\'\"+error_status+\"\',\'\"+onset_date+\"\')\\\"><font color=\'black\'>+</font></a>\";\n\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\txmlStr =\"<root><SEARCH PatientId=\\\"\"+PatientId+\"\\\"  adv_event_type_ind_code=\\\"\"+adv_event_type_ind_code+\"\\\" adv_event_type_code=\\\"\"+adv_event_type_code+\"\\\" causative_code=\\\"\"+causative_code+\"\\\"\treaction_date1=\\\"\"+reaction_date1+\"\\\"  cnt=\\\"\"+obj+\"\\\" det=\'sub\' status=\\\"\"+status+\"\\\" error_status=\\\"\"+error_status+\"\\\" onset_date=\\\"\"+onset_date+\"\\\"  steps=\'7\'/></root>\"\n\t\t\tvar xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\txmlHttp.open(\"POST\",\"../../eCA/jsp/AdverseEventType.jsp\",false)\n\t\t\txmlHttp.send(xmlDoc)\n\t\t\tresponseText=xmlHttp.responseText\n\t\t\tresponseText = trimString(responseText)\n\t\t\teval(responseText)\n\t\n\t\t}\n\t\tfunction callonload()\n\t\t{\n\t\t\tvar tot_allr=document.forms[0].rowcolor.value;\n\t\t}\t\n </script>\n\n</head>\n<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t<script language=javascript>\n\t\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\t\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\t\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\t\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\t\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\t\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\t\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\t</script>\n<form name=\"frmPatientContent\" id=\"frmPatientContent\">\n<div id=\"header\"></div>\n<div id=\"printArea\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<div id = \"one\">\n\t\t\t<a name = \"1\">\n\t\t\t\n\t\t\t<table width = \"100%\" class = \'grid\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class = \'columnheader\' colspan = \"2\" align = \"left\" style=\"background-color: black; color: white;\"><input type = \"checkbox\" name = \"chk1\" checked>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class = \"gridData\" width = \"50%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td> <td class=\"gridData\" width=\"50%\"> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class = \"gridData\" width = \"50%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width = \"50%\" class = \"gridData\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td></td> <td width=\"50%\" class=\"gridData\" > ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </td>\n\t\t\t\t</tr>\t\n\t\t\t\t\n\t\t\t</table>\n\t\t\t</div>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<div id = \"two\">\n\t\t\t<br> <br> <br>\n\t\t\t<a name = \"2\">\n\t\t\t<table width = \"100%\" class = \'grid\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class = \'columnheader\' colspan = \"3\" ><input type = \"checkbox\" name = \"chk2\" checked>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<td class=\'columnheadercenter\' width=\"25%\" > ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t<td class=\'columnheadercenter\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"50%\"  class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </td>\n\t\t\t\t\t\t<td width=\"50%\"  class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</table>\n\t\t\t</div>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" \n\t\t\t<div id=\"three\">\n\t\t\t<br> <br> <br>\n\t\t\t<a name=\"3\">\n\t\t\t<body OnMouseDown = \"CodeArrest()\" onKeyDown = \'lockKey()\' >\n\t\t\t<form name = \'chk_val\'>\n\t\n\t\t\t<table cellpadding=\'0\'  border=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' >\n            <tr>\n\t\t\t\t<td class=\'columnheader\' colspan=\"3\" style=\"background-color: black; color: white;\"><input type=\"checkbox\" name=\"chk3\" id=\"chk3\" checked>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table class=\'grid\' width=\'100%\'  id=\'record\'>\n\t\t\t<tr>\n\t\t\t\t<th width=\'3%\'><div  id=\'head1\'  class=\'myClass\' nowrap width=\'3%\'>&nbsp;&nbsp;</div></th>\n\t\t\t\t<th width=\'15%\'><div  id=\'head2\' class=\'myClass\' nowrap width=\'24%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</div></th>\n\t\t\t\t<th width=\'15%\'><div  id=\'head3\' class=\'myClass\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</div></th>\n\t\t\t\t<th width=\'15%\'><div  id=\'head4\' class=\'myClass\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</div></th>\n\t\t\t\t<th width=\'15%\'><div  id=\'head5\' class=\'myClass\' nowrap width=\'23%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</div></th>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\t\t\t<tr id=\'first\' >\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' nowrap id=\'detail";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'><a href=\"javascript:onclick=display_records1(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\">&nbsp;-&nbsp;</a></td>\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' nowrap >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t<td   class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' nowrap id=\'header\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="<img src=\'../../eCA/images/mc_history.gif\' BORDER=\'0\' style=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'> </td>\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="(";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =")<img src=\'../../eCommon/images/mandatory.gif\' ></img></td>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t</tr>\n\t\t\t<tr id=\'third";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' Style=\"display;visibility:visible\">\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' nowrap >&nbsp;</td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="  nowrap><b>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</b></th>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</b></th>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<tr id=\'second";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' Style=\"display;visibility:visible\" >\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' nowrap >&nbsp;</td>\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t<tr id=\'third";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' Style=\"display:none;visibility:hidden\" >\n\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' nowrap >&nbsp;</td>\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" align=center nowrap>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" align=center nowrap >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr id=\'second";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' Style=\"display;visibility:visible\" >\n\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' nowrap >&nbsp;</td>\n\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t</table>\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\' width=\'auto\' height=\'100%\' align=\'center\'>\n\t\t\t<tr><td width=\'100%\' id=\'t\'></td></tr>\n\t\t</table>\n\t\t</div>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\n\t<input type=\"hidden\" name=\"detail\" id=\"detail\" value=\"\" >\n\t<input type=\"hidden\" name=\"rowcolor\" id=\"rowcolor\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\t<input type=\"hidden\" name=\"cnt\" id=\"cnt\" value=\"\" >\n\t<input type=\"hidden\" name=\"flag1\" id=\"flag1\" VALUE=\"\">\n\n\t<input type=\"hidden\" name=\"PatientId\" id=\"PatientId\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n\t<input type=\"hidden\" name=\"Encounter_Id\" id=\"Encounter_Id\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n  </form>\n</body></div>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t<div id=\"four\">\n\n\t\t\t<br> <br> <br>\n\t\t\t<a name=\"4\">\n\t\t\t<table width=\"100%\" class = \'grid\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheader\' colspan=\"4\" align=\"left\" style=\"background-color: black; color: white;\"> <input type=\"checkbox\" name=\"chk4\" id=\"chk4\" checked>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t\t\t<td class=\'columnheadercenter\' style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" </td>\n\t\t\t\t\t<td class=\'columnheadercenter\' style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" </td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" </td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\n\t\t\t<div id = \"five\">\n\n\t\t\t<br> <br> <br>\n\t\t\t<a name=\"5\">\n\t\t\t<table width=\"100%\" class = \'grid\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheader\' colspan=\"2\" align=\"left\" style=\"background-color: black; color: white;\"> <input type=\"checkbox\" name=\"chk5\" id=\"chk5\" checked>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="<br><a href=\"javascript:;\" onClick=\'return loadDrugInfo(\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\",\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\")\'><img src=\'../../ePH/images/info.gif\' width=\'15\' height=\'15\'></img></a>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t</table>\n\t\t\t</div>\n\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\n\t\t\t<div id=\"six\">\n\t\t\t<br> <br> <br>\n\t\t\t<a name=\"6\">\n\t\t\t<table width=\"100%\" class = \'grid\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheader\' style=\"background-color: black; color: white;\" colspan=\"6\" > <input type=\"checkbox\" name=\"chk6\" id=\"chk6\" checked>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td></td>\n\t\t\t\t\t<td class=\'columnheadercenter\' style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" </td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t</table>\n\t\t</div>\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\n\t\t\t<div id=\"seven\">\n\t\t\t<br> <br> <br>\n\t\t\t<a name=\"7\">\n\t\t\t<table width=\"100%\" class = \'grid\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheader\' style=\"background-color: black; color: white;\"colspan=\"3\" > <input type=\"checkbox\" name=\"chk7\" id=\"chk7\" checked> ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="  </td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\n\t\t\t<div id=\"eight\">\n\t\t\t<br> <br> <br>\n\t\t\t<a name=\"8\">\n\t\t\t<table width=\"100%\" class = \'grid\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheader\' colspan=\"4\" align=\"left\" style=\"background-color: black; color: white;\"> <input type=\"checkbox\" name=\"chk8\" id=\"chk8\" checked>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" </td>\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t</table>\n\t\t\t</div>\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\n\t\t\t<div id=\"nine\">\n\t\t\t<br> <br> <br>\n\t\t\t<a name=\"9\">\n\t\t\t<table width=\"100%\" class = \'grid\'>\n\t\t\t\t <tr>\n\t\t\t\t\t<td class=\'columnheader\' colspan=\"4\" style=\"background-color: black; color: white;\" align=\"left\"> <input type=\"checkbox\" name=\"chk9\" id=\"chk9\" checked>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\n\t\t\t\t</tr>\n\t\t\t   ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" </td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\n\t\t\t<div id=\"eight\">\n\t\t\t<br> <br> <br>\n\t\t\t<a name=\"8\">\n\t\t\t<table width=\"100%\" class = \'grid\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheader\' style=\"background-color: black; color: white;\" colspan=\"5\" align=\"left\"> <input type=\"checkbox\" name=\"chk10\" id=\"chk10\" checked>Family Members";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\t\t\t\t\t\n\t\t\t\t\t<th class=\'columnHeadercenter\' style=\"background-color: black; color: white;\" width=\"15%\">Patient ID </th>\n\t\t\t\t\t<th class=\'columnHeadercenter\' style=\"background-color: black; color: white;\" width=\"15%\">NON Patient ID </th>\n\t\t\t\t\t<th class=\'columnHeadercenter\' style=\"background-color: black; color: white;\" width=\"40%\">Patient Name </th>\n\t\t\t\t\t<th class=\'columnHeadercenter\' style=\"background-color: black; color: white;\" width=\"15%\">Age </th>\n\t\t\t\t\t<th class=\'columnHeadercenter\' style=\"background-color: black; color: white;\" width=\"15%\">Gender </th>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t<tr>\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' >";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="&nbsp;</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n</div>\n<input type=hidden name=counter value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n</form>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");	
	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");
	String patient_profile = request.getParameter("patient_profile");
	if(patient_profile == null) patient_profile = "";
	if(encounter_id == null) encounter_id = "";
	String facility_id = (String)session.getValue("facility_id");

	StringBuffer strSql = new StringBuffer();
	StringBuffer sql  = new StringBuffer();
	StringBuffer sql1 = new StringBuffer();
	String drug_code = "";

	Connection con  = null;
	ResultSet oRs = null;
	ResultSet rset = null;
	PreparedStatement stmt = null;
	PreparedStatement pstmt  = null;

	int j =0;
	String classValue = "";

	String content_id = "";
	boolean found; 
	String titlemsg; 

	// PATIENT MARKERS
	String blood_grp	= "";
	String rh_factor	= "";
	String g6pd			= "";
	String 	sicc		= "";

	// CURRENT PROBLEMS
	String diag_desc	= "";
	String diag_type	= "";
	String dtype		= "";
	String onset_date	= "";

	// CURRENT ALLERGIES
	String allergen		= "";

	// VITAL_SIGNS
	String  discr_msr_desc		= "";
	
	String care_flow_detail		= "";
	String color_cell_indicator	= "";
	String descCellInd		= "";
	String styleValue		= "";
	String legend_type		= "";
	String normal_low		= "";
	String normal_high		= "";
	String normalcy_ind		= "";
	String result_num		= "";

	// MEDICATIONS
	String drug_name			= "";
	String drug_duration		= "";

	//	CURRENT ENCOUNTERS
	String location_desc		= "";
	String speciality			= "";
	String practitioner_name	= "";
	String visit_date			= "";
	String los					= "";

	// PROCEDURE PERFORMED
	String proc_name			= "";
	String proc_date			= "";
	String long_desc			= "";
	String diagnosis = "";
	String calculated_onset_date_yn = "";
	String img_disp_yn = "";

	try
	{
		con  =  ConnectionManager.getConnection(request);
		if(strSql.length() > 0) strSql.delete(0,strSql.length());
		
		strSql.append("select CONTENT_ID,");
		strSql.append("NVL(CONTENT_USER_DEF_DESC,CONTENT_SYS_DEF_DESC)");
		strSql.append(" TITLE_DESC ");
		strSql.append(" FROM CA_PAT_PROF_CONT_LANG_VW ");
		strSql.append(" WHERE INCLUDE_YN='Y' AND LANGUAGE_ID = ?");
		strSql.append(" ORDER BY ORDER_SEQ_NO");

		stmt = con.prepareStatement(strSql.toString());
		stmt.setString(1,locale);
		oRs = 	stmt.executeQuery();

		String checkBoxClick = "";
		int counter = 0;
		int k = 0;
		
		while (oRs.next())
		{
			content_id = oRs.getString("content_id");
			checkBoxClick = request.getParameter("chk"+content_id)==null?"":request.getParameter("chk"+content_id);

			if (content_id.equals("1") && checkBoxClick.equals("Y"))
			{
				found = false;
				titlemsg = "";
				sql = new StringBuffer();
     
				sql.append("SELECT C.SHORT_DESC blood_grp, b.short_desc ");   sql.append("rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc");
				sql.append(" FROM MP_PAT_OTH_DTLS A,MR_RHESUS_FACTOR_LANG_VW B,"); sql.append("MR_BLOOD_GRP_LANG_VW C WHERE PATIENT_ID = ?"); 
				sql.append("and a.rh_factor = b.RHESUS_FACTOR_CODE(+) ");
				sql.append("and a.blood_grp = c.blood_grp(+) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = ? ") ;
			 
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, patient_id );
				pstmt.setString(2, locale );
				pstmt.setString(3, locale );
				rset = pstmt.executeQuery();

				if (rset.next())
				{
					found = true;
					titlemsg = "";
				}
			
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, patient_id );
				pstmt.setString(2, locale );
				pstmt.setString(3, locale );
				rset = pstmt.executeQuery();

				while(rset.next())
				{
					blood_grp = rset.getString("blood_grp")==null?"":rset.getString("blood_grp");
					rh_factor = rset.getString("rh_factor")==null?"":rset.getString("rh_factor");
					g6pd	  = rset.getString("g6pd")==null?"":rset.getString("g6pd");
					sicc	  = rset.getString("sicc")==null?"":rset.getString("sicc");
					k++;
					j++;
				}
							
				if (k==0)
				{
					found = false;
					titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NotIdentified.label","ca_labels");
				}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(titlemsg));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(blood_grp));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rh_factor));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(g6pd));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sicc));
            _bw.write(_wl_block15Bytes, _wl_block15);

		} //if 1
		else if(content_id.equals("2") && checkBoxClick.equals("Y"))
		{
			found = false;;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NotExist.label","ca_labels");
			sql = new StringBuffer();
			
			sql.append("select srl_no,"); 
			sql.append("diag_type dtype,");
			sql.append("to_char(onset_date,'dd/mm/yyyy') onset_date,");
			sql.append("sensitive_yn,diag_desc, diag_code,");
			sql.append("diag_code_scheme_desc from pr_problem_vw ");
			sql.append("where patient_Id=? and ");
			sql.append("nvl(problem_status,'O')!='C' and ");
			sql.append("nvl(sensitive_yn,'N')=decode('N','N','N',NVL(sensitive_yn,'N')) ");
			sql.append("and diag_code_scheme=(select diag_code_scheme ");
			sql.append("from mr_parameter where rownum=1)  order by ");
			sql.append("to_date(onset_date,'dd/mm/yyyy') desc");

			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, patient_id );
			rset = pstmt.executeQuery();

			if(rset.next())
			{
				found = true;
				titlemsg = "";
				k++;
			}
			if (k == 0)
			{
				found = false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NotExist.label","ca_labels");
			}
			
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, patient_id );
			rset = pstmt.executeQuery();

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(titlemsg));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

				classValue = "gridData";
				while(rset.next())
				{
					diag_desc = rset.getString("diag_desc")==null?"":rset.getString("diag_desc");
					diag_type = rset.getString("dtype")==null?"":rset.getString("dtype").trim();
					if(diag_type.equals("P"))
						dtype = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");
					else if (diag_type.equals("D"))
						dtype = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
					else if (diag_type.equals("F"))
						dtype = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");

					onset_date = rset.getString("onset_date")==null?"":rset.getString("onset_date");
					if(!locale.equals("en"))
					  onset_date = com.ehis.util.DateUtils.convertDate(onset_date,"DMYHM","en",locale);

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dtype));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
	
					j++;
				}

            _bw.write(_wl_block25Bytes, _wl_block25);

		}//if 2
		else if(content_id.equals("3") && checkBoxClick.equals("Y"))
		{
			ResultSet rs = null;
			Statement stmt1 = null;
			PreparedStatement pstmt2 = null;//common-icn-0180
			String allergen1="",adv_event_type="",Certainity="",status="",causative_code="",adv_event_type_ind_code="",adv_event_type_code="",severity_main="",classValue1="",adv_event_dtl_srl_no="",reaction_date_prev="",reaction_date1="",causative_substance="",route_of_exposure="",severity_two="",adv_reac_code="",reac_desc="",diagnosis_code="",severity_code="",active_date="",cnt_recurring="",final_reac_code_val="",reaction_site="",onset_date_disply="",reaction_date1_disply="",others_reaction="",adv_event_type_code1="",error_status="" ,status1="",adv_event_type_ind_code1="",onset_date_disply1="",onset_date1="",status_pass="";
        
			try 
			{

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

			//stmt1 = con.createStatement();//common-icn-0180
          
			int rowcolor = 0,m = 0;
			
			//String sql2="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code, CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"'))) END allergen, MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') adv_event_type_ind_desc, MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1') adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION,CALCULATED_ONSET_DATE_YN,f.status error_status FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+patient_id+"' AND  a.status='A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code,  f.reaction_date";//common-icn-0180	
			String sql2="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,?,'1') reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code, CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id=?),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id=?))) END allergen, MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,?,'1') adv_event_type_ind_desc, MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,?,'1') adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id=?),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION,CALCULATED_ONSET_DATE_YN,f.status error_status FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = ? AND  a.status='A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code,  f.reaction_date";	//common-icn-0180
			pstmt2 = con.prepareStatement(sql2);//common-icn-0180
			//common-icn-0180 starts
			pstmt2.setString(1, locale);
			pstmt2.setString(2, locale);
			pstmt2.setString(3, locale);
			pstmt2.setString(4, locale);
			pstmt2.setString(5, locale);
			pstmt2.setString(6, locale);
			pstmt2.setString(7, patient_id);
			
			
			//rs = stmt1.executeQuery(sql2);//common-icn-0180
			rs = pstmt2.executeQuery();
			//common-icn-0180 ends
			if(rs !=null)
			{
				classValue = "gridData";	
				while(rs.next())
				{
					causative_code = rs.getString("allergen_code");
					adv_event_type_ind_code = rs.getString("ADV_EVENT_TYPE_IND");

					adv_event_type_code = rs.getString("ADV_EVENT_TYPE");
					allergen = rs.getString("allergen");
					adv_event_type = rs.getString("adv_event_type_desc");
					Certainity = rs.getString("CERTAINTY");
					onset_date = rs.getString("ONSET_DATE");
					if(onset_date == null) onset_date = "";
					status = rs.getString("STATUS");
					severity_main = rs.getString("severity1");
					if(severity_main == null) severity_main = "";
					adv_event_dtl_srl_no = rs.getString("adv_event_dtl_srl_no");
					if(adv_event_dtl_srl_no == null) adv_event_dtl_srl_no = "";
					causative_substance = rs.getString("causative_substance");
					if(causative_substance == null) causative_substance = "";
					route_of_exposure = rs.getString("route_of_exposure");
					if(route_of_exposure == null) route_of_exposure = "";
					severity_two = rs.getString("severity_two");
					if(severity_two == null) severity_two = "&nbsp;";
					adv_reac_code = rs.getString("adv_reac_code");
					if(adv_reac_code == null) adv_reac_code = "";
					reaction_date1 = rs.getString("reaction_date");
					if(reaction_date1 == null) reaction_date1 = "";
					reac_desc = rs.getString("reac_desc");

					if(reac_desc == null) reac_desc = "&nbsp;";
					severity_code = rs.getString("severity_code");
					if(severity_code == null)severity_code = "";
					diagnosis_code = rs.getString("diagnosis_code");
					if(diagnosis_code == null)diagnosis_code = "";
					active_date = rs.getString("active_date");
					if(active_date == null) active_date = "";
					final_reac_code_val = rs.getString("REACTION_CODE_VALUES");
					if(final_reac_code_val == null || final_reac_code_val.equals("THR")) final_reac_code_val = "";
					reaction_site= rs.getString("reaction_site");
					if(reaction_site == null || reaction_site == "") reaction_site = "&nbsp;";
					
					others_reaction = rs.getString("OTHERS_REACTION");
					if(others_reaction == null) others_reaction = "&nbsp;";
					
					calculated_onset_date_yn = rs.getString("CALCULATED_ONSET_DATE_YN");
					if(calculated_onset_date_yn == null) calculated_onset_date_yn = "&nbsp;";
					error_status = rs.getString("error_status") == null ? "A" : rs.getString("error_status");

					if(calculated_onset_date_yn.equals("Y"))
					{
						img_disp_yn = "display:visible";
					}
					else
					{
						img_disp_yn = "display:none";
					}

					cnt_recurring = rs.getString("COUNT");

					if(adv_event_type_ind_code.equals("01"))
						classValue1 = "MRALLERGY";
					else if(adv_event_type_ind_code.equals("02"))
						classValue1 = "MRHYPERII";
					else if(adv_event_type_ind_code.equals("03"))
						classValue1 = "MRHEADER";
					else if(adv_event_type_ind_code.equals("04"))
						classValue1 = "ORBROWN";
					
					if(severity_main.equals("U"))
						severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					else if(severity_main.equals("M"))
						severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
					else if(severity_main.equals("O"))
						severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
					else if(severity_main.equals("S"))
						severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");

					if(Certainity.equals("D"))
						Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Definitive.label","common_labels");
					else if(Certainity.equals("P"))
						Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Probable.label","common_labels");

					status_pass = status;

					if(status.equals("A"))
						status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
				
					if(route_of_exposure.equals("1"))
						route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Probable.label","common_labels");
					else if(route_of_exposure.equals("2"))
						route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Inhalation.label","mr_labels");
					else if(route_of_exposure.equals("3"))
						route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Injection.label","mr_labels");
					else if(route_of_exposure.equals("4"))
						route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Tropical.label","mr_labels");

					if(severity_two.equals("U"))
						severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					else if(severity_two.equals("M"))
						severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
					else if(severity_two.equals("O"))
						severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
					else if(severity_two.equals("S"))
						severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");

					onset_date_disply=DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
					reaction_date1_disply=DateUtils.convertDate(reaction_date1,"DMYHM","en",locale);

					if((!adv_event_type_code.equals(adv_event_type_code1) || !causative_code.equals(allergen1)|| !status.equals(status1)|| !adv_event_type_ind_code.equals(adv_event_type_ind_code1)|| !onset_date_disply.equals(onset_date_disply1)))
					{

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(m));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(m));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(adv_event_type_ind_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(adv_event_type_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(reaction_date1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(status_pass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(error_status));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(adv_event_type));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(allergen));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(onset_date_disply));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(img_disp_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);

				if(cnt_recurring.equals("0"))
				{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(status));
            _bw.write(_wl_block45Bytes, _wl_block45);

				}
				else
				{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(status));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(cnt_recurring));
            _bw.write(_wl_block47Bytes, _wl_block47);

				}

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(m));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

			if(!error_status.equals("E"))
			{

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(m));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reaction_date1_disply));
            _bw.write(_wl_block45Bytes, _wl_block45);
 
				if(adv_reac_code.equals("Oth")) 
				{ 

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(others_reaction));
            _bw.write(_wl_block45Bytes, _wl_block45);

				}
				else
				{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reac_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);

				}

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(severity_two));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reaction_site));
            _bw.write(_wl_block57Bytes, _wl_block57);

			}
			}
			else
			{
				if(!error_status.equals("E"))
				{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(m));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(m));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reaction_date1_disply));
            _bw.write(_wl_block45Bytes, _wl_block45);
 
					if(adv_reac_code.equals("Oth")) 
					{

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(others_reaction));
            _bw.write(_wl_block45Bytes, _wl_block45);

					}
					else
					{

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reac_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);

					}

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(severity_two));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reaction_site));
            _bw.write(_wl_block20Bytes, _wl_block20);

				}
				}
				
				allergen1=rs.getString("allergen_code");
				reaction_date_prev =rs.getString("reaction_date");
				adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");

				adv_event_type_ind_code1 = rs.getString("adv_event_type_ind");
				onset_date1 = rs.getString("onset_date");
				onset_date_disply1=DateUtils.convertDate(onset_date1,"DMYHMS","en",locale);
				status1 = rs.getString("status");
					
				if(status1.equals("A"))
					status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
				else if(status1.equals("R"))
					status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
				else if(status1.equals("E"))
					status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
				
				rowcolor ++;
				m++;
				j++;
			}

            _bw.write(_wl_block69Bytes, _wl_block69);

		}

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(rowcolor));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block73Bytes, _wl_block73);

			}
			catch(Exception e)
			{
				e.printStackTrace();
				if (rs != null) rs.close();
				if (stmt1 != null) stmt1.close();
				if (pstmt2 != null) pstmt2.close();//common-icn-0180
			}
		} //if 3
		else if(content_id.equals("4") && checkBoxClick.equals("Y"))
		{
			found = false;
			titlemsg = "";
						
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM");
			rset = pstmt.executeQuery();
			if (rset.next())
			{
				legend_type = rset.getString(1) == null ? "S" : rset.getString(1);
			}

			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();

			sql = new StringBuffer();
			 
			sql.append("select EVENT_DATE dummydate , b.short_desc ");
			sql.append(" discr_msr_desc, a.NORMAL_LOW, a.NORMAL_HIGH, a.RESULT_NUM, A.NORMALCY_IND,");
			sql.append("RESULT_NUM_UOM,to_char(EVENT_DATE, 'dd/mm/yyyy hh24:mi') event_date ,");
			sql.append("nvl(RESULT_NUM,'')||nvl(RESULT_STR,'')||' '||nvl(RESULT_NUM_UOM,'')");
			sql.append(" care_flow_detail,(SELECT DECODE(A.NORMALCY_IND,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR ,crit_low_color_code,'')");
            sql.append("from CR_CLIN_EVENT_PARAM ) COLOR_CELL_IND, ");
			sql.append("(SELECT DECODE(A.NORMALCY_IND,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)");
			sql.append("from CR_CLIN_EVENT_PARAM ) DESC_CELL_IND, ");
			sql.append("(select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol ");
			sql.append("from cr_encounter_detail a,");
			sql.append("CR_CLN_EVT_MST_LANG_VW b where B.LANGUAGE_ID = ? and ");
			sql.append("a.hist_rec_type = 'PTCR' and ");
			sql.append("b.hist_rec_type  = a.hist_rec_type   and ");
			sql.append("b.event_code = a.event_code and  b.EVENT_CODE_TYPE = a.EVENT_CODE_TYPE and patient_id = ? ");
			sql.append("and event_date in (select max(event_date) from ");
			sql.append("cr_encounter_detail where ");
			sql.append("patient_id=? and hist_rec_type = 'PTCR') and nvl(a.STATUS,'`') not in('S','E') order by dummydate desc ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2, patient_id );
			pstmt.setString(3, patient_id );
			rset = pstmt.executeQuery();

			if(rset.next())
			{
				found = true;
				String eventdate = rset.getString("event_date");
				if(!locale.equals("en"))
					eventdate = com.ehis.util.DateUtils.convertDate(eventdate,"DMYHM","en",locale);

				titlemsg = " : "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Recorded.label","ca_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.At.label","common_labels")+ " " + eventdate;
				k++;
			}
			if(k == 0)
			{
				found = false;
				titlemsg = " : "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NotRecorded.label","ca_labels");

			}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2, patient_id );
			pstmt.setString(3, patient_id );
			rset = pstmt.executeQuery();

            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(titlemsg));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

				while(rset.next())
				{
					classValue = "gridData" ;

					discr_msr_desc = rset.getString("discr_msr_desc")==null?"":rset.getString("discr_msr_desc");
					care_flow_detail = rset.getString("care_flow_detail")==null?"":rset.getString("care_flow_detail");
					normal_low = rset.getString("NORMAL_LOW")==null?"0":rset.getString("NORMAL_LOW");
					normal_high = rset.getString("NORMAL_HIGH")==null?"0":rset.getString("NORMAL_HIGH");
					result_num = rset.getString("RESULT_NUM")==null?"0":rset.getString("RESULT_NUM");
					normalcy_ind = rset.getString("NORMALCY_IND")==null?"":rset.getString("NORMALCY_IND");
					color_cell_indicator = rset.getString("COLOR_CELL_IND")==null?"":rset.getString("COLOR_CELL_IND");

					if(legend_type.equals("S"))
						color_cell_indicator = rset.getString("normal_range_symbol") == null? "" : rset.getString("normal_range_symbol");
					else
						color_cell_indicator = rset.getString("COLOR_CELL_IND")== null ? "" : rset.getString("COLOR_CELL_IND");
				   
					descCellInd = rset.getString("DESC_CELL_IND") == null ? "&nbsp;" : rset.getString("DESC_CELL_IND");
					if(!color_cell_indicator.equals("") && color_cell_indicator != null)
					{
						if(legend_type.equals("S"))
							styleValue = "<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";
						else
							styleValue = "<font style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";
					}
					else if(!normal_low.equals("0") && !normal_high.equals("0"))
					{
						if(Float.parseFloat(result_num)>0)
						{
							if((Float.parseFloat(result_num) >= Float.parseFloat(normal_low)) && (Float.parseFloat(result_num) <= 	Float.parseFloat(normal_high)))
							{
								if(legend_type.equals("S"))
									styleValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";
								else
									styleValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";

								descCellInd = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
							}
						}
					}
					else if(normalcy_ind.equals("."))
					{
						if(legend_type.equals("S"))
							styleValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";
						else
							styleValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";

						descCellInd = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
					}
					else
						styleValue = "";

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(discr_msr_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(styleValue));
            out.print( String.valueOf(care_flow_detail));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(descCellInd));
            _bw.write(_wl_block24Bytes, _wl_block24);

					j++;
				}

            _bw.write(_wl_block25Bytes, _wl_block25);

		}//if 4

		else if(content_id.equals("5") && checkBoxClick.equals("Y"))
		{
			found =false;;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			sql = new StringBuffer();
			
			sql.append(" SELECT NULL drug_code,e.form_code||' '||");
			sql.append("e.DRUG_DESC||' '||decode (g.SLIDING_SCALE_YN ,'Y','<font color=red>(Sliding Scale)</font>',RTRIM (RTRIM (TO_CHAR (a.dosage, '9999999999999990.999999999999'), '0'), '.') ||' '||");
			sql.append(" PH_GET_UOM_DISPLAY('"+facility_id+"',a.dosage_uom_code,'"+localeName+"'))||' '||DECODE (drug_yn, 'Y', DECODE (a.split_yn, 'Y', '(Divided)',d.freq_desc), '')||decode(DRUG_YN, 'Y',' * ','')||");
			sql.append(" decode(DRUG_YN, 'Y', a.DURATION,'')  ||' '||decode(DRUG_YN, 'Y', c.durn_desc,'') ");  
			sql.append(" drug_name,TO_CHAR (sm_convert_date(a.start_date,'"+locale+"'), 'dd/mm/yy')||'-'||TO_CHAR (sm_convert_date(a.end_date,'"+locale+"'), 'dd/mm/yy') drug_duration ");
			sql.append(" FROM ph_patient_drug_profile a ,am_duration_type c,am_frequency d, ph_drug e ,ph_generic_name f,or_order_line_ph g WHERE a.orig_order_id =g.ORDER_ID and a.ORIG_ORDER_LINE_NO =g.ORDER_LINE_NUM");
			sql.append(" and a.patient_id = ? AND TRUNC(NVL(a.end_date,SYSDATE)) >= TRUNC(SYSDATE) and nvl(CANCEL_YN,'N')='N' ");
			sql.append(" AND a.discont_date_time IS NULL AND ");
			sql.append(" a.on_hold_date_time IS NULL AND ");
			sql.append(" d.freq_code(+)=a.FREQ_CODE AND e.DRUG_CODE=a.DRUG_CODE  and f.GENERIC_ID=a.GENERIC_ID and e.drug_yn='Y' AND ");
			sql.append(" c.durn_type(+)=a.DURN_TYPE ORDER BY start_date DESc ");
 			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, patient_id );
			rset=pstmt.executeQuery();
			
			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
			if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			}

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, patient_id );
			rset=pstmt.executeQuery();
	
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(titlemsg));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

			while(rset.next())
			{
				classValue = "gridData" ;

				drug_name = rset.getString("drug_name")==null?"":rset.getString("drug_name");
				drug_code = rset.getString("drug_code")==null?"":rset.getString("drug_code");
				drug_duration= rset.getString("drug_duration")==null?"":rset.getString("drug_duration");
				

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_duration));
if(!drug_code.equals("")){
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

				j++;
			}

            _bw.write(_wl_block88Bytes, _wl_block88);
	
		}//end if 5
		else if(content_id.equals("6") && checkBoxClick.equals("Y"))
		{
			found =false;;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
			sql = new StringBuffer();
		
			sql.append( "Select PATIENT_CLASS, " );
			sql.append("DECODE (assign_care_locn_type,");
	        sql.append("'N', IP_GET_DESC.IP_NURSING_UNIT(facility_id,assign_care_locn_code,?,'1'),");
			sql.append("OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,?,'1')) LOCATION_DESC,"); 
			sql.append("AM_GET_DESC.AM_SPECIALITY(pr_encounter.SPECIALTY_CODE,?,'2') Short_desc,"); 
			sql.append("AM_GET_DESC.AM_PRACTITIONER(attend_practitioner_id,?,'2') ");
			sql.append("practitioner_name,");
			sql.append("to_char(sm_convert_date(visit_adm_date_time,'"+locale+"'),'dd/mm/yyyy') visit_date, ");
			sql.append("to_char(TRUNC(SYSDATE-VISIT_ADM_DATE_TIME))||' days' LOS " );
			sql.append(" from pr_encounter where facility_id=? " );
			
			if(encounter_id == null || encounter_id.equals(""))
			{
				sql.append(" and (facility_id,encounter_id) in (select facility_id,encounter_id from (select facility_id,encounter_id, ROW_NUMBER() OVER (order by visit_adm_date_time desc) RANK_NO  from  pr_encounter where patient_id= ?) where RANK_NO < 2)" );
			}
			else
			{
				sql.append(" and encounter_id=? " );
			}

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, locale );
			pstmt.setString(2, locale );
			pstmt.setString(3, locale );
			pstmt.setString(4, locale );
			pstmt.setString(5, facility_id );
			
			if(encounter_id == null || encounter_id.equals(""))
			{
				pstmt.setString(6, patient_id );
			}
			else
			{
				pstmt.setString(6, encounter_id );
			}
			rset=pstmt.executeQuery();

			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
				if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
			}

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, locale );
			pstmt.setString(2, locale );
			pstmt.setString(3, locale );
			pstmt.setString(4, locale );
			pstmt.setString(5, facility_id  );

			if(encounter_id.equals(""))
			{
				pstmt.setString(6, patient_id );
			}
			else
			{
				pstmt.setString(6, encounter_id );
			}

			rset=pstmt.executeQuery();

            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

				while(rset.next())
				{
					classValue = "gridData" ;
					
					location_desc= rset.getString("location_desc")==null?"":rset.getString("location_desc");
					speciality =  rset.getString("short_desc")==null?"":rset.getString("short_desc");
					practitioner_name =  rset.getString("practitioner_name")==null?"":rset.getString("practitioner_name");
						
					visit_date =  rset.getString("visit_date")==null?"":rset.getString("visit_date");

					los =  rset.getString("los")==null?"":rset.getString("los");

			
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(location_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_date));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(los));
            _bw.write(_wl_block93Bytes, _wl_block93);

				 j++;
				}
            _bw.write(_wl_block94Bytes, _wl_block94);
			
		}// end if 6	
		else if(content_id.equals("7") && checkBoxClick.equals("Y"))
		{
			found = false;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			String error_yn = "";
			sql = new StringBuffer();
			
			sql.append( "Select a.proc_narration  proc_name,");
			sql.append("AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') practitioner_name,");
			sql.append( "to_char(proc_date,'dd/mm/yyyy hh24:mi') ");
			sql.append( "proc_date,proc_date dummydate, a.ERROR_YN error_yn from ");
			sql.append( "pr_encounter_procedure a ");
			sql.append( "where a.facility_id = ? and a.PATIENT_ID = ? ");
			sql.append( "order by dummydate desc");

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,patient_id);			
			rset=pstmt.executeQuery();

			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
				if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,patient_id);			
			rset=pstmt.executeQuery();
			
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(titlemsg));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

				while(rset.next())
				{
					classValue = "gridData" ;

					proc_name = rset.getString("proc_name")==null?"":rset.getString("proc_name");
					practitioner_name= rset.getString("practitioner_name")==null?"":rset.getString("practitioner_name");		proc_date= rset.getString("proc_date")==null?"":rset.getString("proc_date");
					if(!locale.equals("en"))
					  proc_date=com.ehis.util.DateUtils.convertDate(proc_date,"DMYHM","en",locale);
					error_yn= rset.getString("error_yn")==null?"N":rset.getString("error_yn");

					if(!error_yn.equals("Y"))
					{
				
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(proc_name));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(proc_date));
            _bw.write(_wl_block93Bytes, _wl_block93);
}
				  j++;
				}
            _bw.write(_wl_block88Bytes, _wl_block88);

		} // end if 7
		else if(content_id.equals("8") && checkBoxClick.equals("Y"))
		{
			found =false;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			sql = new StringBuffer();
			
			sql.append("Select MR_GET_DESC.MR_HIGH_RISK(a.high_risk_code,?,'1') long_desc, to_char(sm_convert_date(a.onset_date,'"+locale+"'),'dd/mm/yyyy')");
			sql.append(" onset_date from pr_high_risk_condition a ");
			sql.append("where a.patient_id =? and a.close_date is null");

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);			
			rset=pstmt.executeQuery();

			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
			if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			}


			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);	
			rset=pstmt.executeQuery();


			
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(titlemsg));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

				while(rset.next())
				{
					classValue = "gridData" ;

					long_desc = rset.getString("long_desc")==null?"":rset.getString("long_desc");
					onset_date= rset.getString("onset_date")==null?"":rset.getString("onset_date");	
					

				
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block100Bytes, _wl_block100);

				j++;
				}
				
            _bw.write(_wl_block101Bytes, _wl_block101);
//}
            _bw.write(_wl_block102Bytes, _wl_block102);

		}
		else if(content_id.equals("9") && checkBoxClick.equals("Y"))
		{
			found =false;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			sql = new StringBuffer();
			sql1 = new StringBuffer();
			
			sql1.append("select  DIAGNOSIS  from PR_REFERRAL_REGISTER a, PR_ENCOUNTER B where B.FACILITY_ID=? and  B.ENCOUNTER_ID =? AND A.REFERRAL_ID=B.REFERRAL_ID ");

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt=con.prepareStatement(sql1.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);			
			rset=pstmt.executeQuery();

			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
				if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			}

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql1.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);			
			rset=pstmt.executeQuery();
			
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(titlemsg));
            _bw.write(_wl_block104Bytes, _wl_block104);

				while(rset.next())
				{
					classValue = "gridData" ;

					diagnosis = rset.getString("diagnosis")==null?"":rset.getString("diagnosis");
					

				
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(diagnosis));
            _bw.write(_wl_block106Bytes, _wl_block106);

					j++;
				}
            _bw.write(_wl_block101Bytes, _wl_block101);
//}
            _bw.write(_wl_block102Bytes, _wl_block102);

	
		}
		
		else if(content_id.equals("10") && checkBoxClick.equals("Y"))
		{
			found =false;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			sql = new StringBuffer();
			
			sql.append("SELECT A.GENO_ID, A.SRL_NO, A.PATIENT_ID, A.NON_PATIENT_ID, A.NAME, A.SEX, DECODE(A.SEX,'M','Male','F','Female','U','Unknown') SEX_DESC, A.DATE_OF_BIRTH, CA_GET_AGE(A.DATE_OF_BIRTH,SYSDATE,'YMD') AGE FROM CA_GENOGRAM_ATTRIBUTE A, CA_GENOGRAM_ATTRIBUTE B WHERE A.GENO_ID=B.GENO_ID AND B.PATIENT_ID=?");
			

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			
			pstmt.setString(1,patient_id);			
			rset=pstmt.executeQuery();

			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
			if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			}


			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());			
			pstmt.setString(1,patient_id);	
			rset=pstmt.executeQuery();


			
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(titlemsg));
            _bw.write(_wl_block108Bytes, _wl_block108);

				while(rset.next())
				{
					classValue = "gridData" ;
				
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(rset.getString("PATIENT_ID")==null?"":(String)rset.getString("PATIENT_ID") ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(rset.getString("NON_PATIENT_ID")==null?"":(String)rset.getString("NON_PATIENT_ID") ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(rset.getString("NAME")==null?"":(String)rset.getString("NAME") ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(rset.getString("AGE")==null?"":(String)rset.getString("AGE") ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(rset.getString("SEX_DESC")==null?"":(String)rset.getString("SEX_DESC") ));
            _bw.write(_wl_block112Bytes, _wl_block112);

				j++;
				}
				
            _bw.write(_wl_block101Bytes, _wl_block101);
//}
            _bw.write(_wl_block102Bytes, _wl_block102);

		}
		counter++;
	} //while
	if(patient_profile.equals("P"))
	{
	   if(j==0)
		{
			out.println("<script>alert('APP-002415 Query caused no records to be retrieved')</script>");
		 }
	}
	

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block114Bytes, _wl_block114);

	if(oRs!=null) oRs.close();
	if(stmt!=null) stmt.close();
	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception @ 3444"+e.toString());//common-icn-0181
	e.printStackTrace();
}
finally
{	
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block115Bytes, _wl_block115);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientMarkers.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RhFactor.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.g6pd.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.sicc.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.current.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Problems.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Problem.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.current.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Allergies.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventType.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Allergen.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReactionDate.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.reactiondesc.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SiteOfReaction.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReactionDate.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.reactiondesc.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SiteOfReaction.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientCare.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Observation.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Result.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NormalcyStatus.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Medications.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugName.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DrugDuration.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CurrentEncounter.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LOS.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformedOn.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HighRisk.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HighRiskConditions.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferralDiagnosis.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }
}
