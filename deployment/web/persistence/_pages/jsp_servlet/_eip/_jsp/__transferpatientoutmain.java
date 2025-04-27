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
import java.util.*;
import com.ehis.util.*;

public final class __transferpatientoutmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/TransferPatientOutMain.jsp", 1740132124170L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../js/TransferPatient.js\" language=\"javascript\"></script> \n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/DateUtils.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<script>\n\t\n\t//Added by Mujafar for ML-MMOH-CRF-1136 start\n\t\tfunction compareDates(obj,prefer_date)\n\t\t{\n\t\t\tif(obj.value!=\'\' && prefer_date.value!=\'\')\n\t\t\t{\n\t\t\t\tvar arr_date = convertDate(obj.value,\"DMYHM\",localeName,\"en\");\n\t\t\t\tvar prf_date = convertDate(prefer_date.value,\"DMYHM\",localeName,\"en\");\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tif(!isAfter(arr_date,prf_date,\'DMYHM\',\'en\'))\n\t\t\t  {\n\t\t\t\t \n\t\t\t\t var error = getMessage(\"DATE1_LT_DATE2\",\"IP\");\n\t\t\t\t error = error.replace(\"$\",getLabel(\"Common.ArrivalDateTime.label\",\'Common\'));\n\t\t\t\t error = error.replace(\"#\",getLabel(\'eIP.PreferredDateTime.label\',\'IP\'));\n\t\t\t\t alert(error);\n\t\t\t\t obj.select();\n\t\t\t\t obj.focus();\n\t\t\t\t return false;\n\t\t\t  }\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t}\n\t\n\t\t function validate_date(obj) \n\t\t {\n\t\t\t\tif(obj.value!=\'\'){\n\n\t\t\t\t\tif(isBeforeNow(obj.value,\"DMYHM\",localeName))\n\t\t\t\t\t\treturn true;\n\t\t\t\t\telse {\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar error = getMessage(\"DATE1_GT_DATE2\",\"IP\");\n\t\t\t\t\t\terror =  error.replace(\"$\",getLabel(\"Common.ArrivalDateTime.label\",\'Common\'));\n\t\t\t\t\t\terror =  error.replace(\"#\", getLabel(\"Common.SystemDateTime.label\",\'Common\'));\n\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\treturn false ;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t}\n\t\t//Added by Mujafar for ML-MMOH-CRF-1136 end\n\t\t\n\t\n\t\tfunction validateBackDate(prefDate)\n\t\t{\n\t\t\tvar max_trn_date_time = document.forms[0].max_trn_date_time.value;\n\t\t\tif (prefDate.value != \"\"  || prefDate.value != \'\')\n\t\t\t{\n\t\t \t\tif(!validDateObj(prefDate,\"DMYHM\",localeName))\n\t\t\t\t{\n\t\t\t\t return ;\n\t\t\t\t}\n\n\t\t\t\tvar greg_prefDateTime = convertDate(prefDate.value,\'DMYHM\',localeName,\'en\');\n\t\t\t\tvar greg_maxtfrDateTime = convertDate(max_trn_date_time,\'DMYHM\',localeName,\'en\');\n\t\t\t\tvar admission_date_time = convertDate(\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\",\'DMYHM\',localeName,\'en\');\n\t\t\t\tif(isBefore(greg_prefDateTime,admission_date_time,\'DMYHM\',\'en\'))\n\t\t\t\t{\n\t\t\t\t\tvar error = getMessage(\'DATE1_SHD_GT_DATE2\',\'IP\');\n\t\t\t\t\t/* 17956 Thursday, January 07, 2010*/\n\t\t\t\t\terror = error.replace(\'$\',getLabel(\"eIP.PreferredDateTime.label\",\'IP\'));\n\t\t\t\t\terror = error.replace(\'#\',getLabel(\"Common.AdmissionDateTime.label\",\'Common\'));\n\t\t\t\t\talert(error);\n\t\t\t\t\tprefDate.select();\n\t\t\t\t}////modified for 12/15/2008 6021  MF-SCF-0051\n\t\t\t\telse if(!isBefore(greg_maxtfrDateTime,greg_prefDateTime,\'DMYHM\',\'en\')){\n\t\t\t\n\t\t\t\t\tvar error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t\t\t\tvar last_encounter = getLabel(\"eIP.LastTransactionDateTime.label\",\"IP\");\n\t\t\t\t\terror = error.replace(\'$\',getLabel(\"eIP.PreferredDateTime.label\",\'IP\'));\n\t\t\t\t\terror = error.replace(\'#\',last_encounter);\n\t\t\t\t\talert(error);\n\t\t\t\t\tprefDate.select();\n\t\t\t\t\t}\n\n\t\t\t}\n\t\t}\n\t\tvar isShift = false;\n\t\tfunction setShift(){\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 16) isShift=true;\n\t}\n\n\t\tfunction shift_tab(){\n\t\t\tvar keyCode=window.event.keyCode;\n\t\t\tif(keyCode == 9 && isShift == true){\n\t\t\tparent.frames[5].button_s.focus();\n\t\t}\n\t\t}\n\n\t\tfunction shift_tab1(){\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 9 && isShift == true){\n\t\tdocument.forms[0].transfer_type1.focus();\n\t\t}\n\t\t\n\t}\n\tfunction shift_tab11(){\n\t\t\n\t\tvar keyCode = window.event.keyCode;\n\t\t\n\t\tif(keyCode == 9){\n\t\t\n\t\t\tparent.frames[1].document.forms[0].pref_date.focus();\n\t\t\t\n\t\t}\n\t\t\n\t}\nfunction setTab()\n\t{\n\t\tvar keyCode = window.event.keyCode;\n\t\tif(keyCode == 9)\n\t\tparent.frames[5].button_c.focus();\n\t}\n\tfunction changefocus()\n\t{\n\t\tdocument.forms[0].pref_date.focus();\n\t}\n\t</script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\n\n</script>\n\t\n\t<body ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="onload=\'getTfrType();\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey();setShift();\' > \n\t<form name=\"trf_form\" id=\"trf_form\"   method=\"\" action=\"\" target=\"parent.frames[1]\">\n\t\t\n\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\n\t\t <tr>\n\t\t\t\t<th colspan=\'4\' align=\"left\" style=\" color: white;\" class=\'columnheader\' width=\"100%\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t</tr>\n\t\t<tr><!-- 17956 Thursday, January 07, 2010 -->\n\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t <td  class=\'querydata\' WIDTH=\'25%\'><input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td class=\"label\" WIDTH=\'20%\'  >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<td  class=\'querydata\' WIDTH=\'30%\'><input type=\"hidden\" name=\"admission_type\" id=\"admission_type\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td> \n\t\t</tr>\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td><td  class=\'querydata\'><INPUT TYPE=\"text\" name=\"pref_date\" id=\"pref_date\" readOnly id=\"prefDate\"  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="  size=\"16\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onblur=\"\"  onKeyPress=\'\' onkeyDown=\'shift_tab();\'>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t</td> \n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td><td  class=\'querydata\'><INPUT TYPE=\"text\" name=\"pref_date\" id=\"pref_date\" size=\"16\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" onblur=\"validateBackDate(this);//compareSystemDate(this);\"  onKeyPress=\'\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" Readonly ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" onkeyDown=\'shift_tab1();\' tabindex = \'1\'><img name=\'beddt\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].pref_date.focus();return showCalendar(\'pref_date\',null,\'hh:mm\');\" tabindex = \'2\'/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' > </img></td> \n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<td class=\"label\" WIDTH=\'20%\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t<td  class=\"querydata\"  WIDTH=\'30%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<input type=hidden name=\'transfer_type_code\' id=\'transfer_type_code\'  value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" ></td>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<td class=\"label\" WIDTH=\'20%\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td><td class=\'querydata\' WIDTH=\'30%\'><select name=\"transfer_type1\" id=\"transfer_type1\" onChange=\"getBlockingDetails();";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="chkInformedDtlsMand();";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="disabled";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" onkeyDown=\'shift_tab1();setTab();\' tabindex = \'3\' onblur=\"changefocus()\">\n\t\t\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ---\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t</select>\n\t\t\t\t<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t<input type=\"hidden\" name=\"transfer_type_code\" id=\"transfer_type_code\"  value=\"\">\n\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t</tr>\n\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t<td class=\'querydata\'    >\n\t\t\t\t\t<select name = \"transfer_in_status\" onChange=\"enableAllFields()\" OnkeyDown=\'shift_tab11()\'>\n\t\t\t\t\t\t<option value = \"\">---";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="---</option>\n\t\t\t\t\t\t<option value = \"01\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</option>\n\t\t\t\t\t\t<option value = \"02\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t<img align=\"center\" id=\"img_trans_in\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\n\t\t\t\n\t\t\t<td class=\"label\"  id=\"arr_date_disp\" name=\"arr_date_disp\" style=\"display:none\" >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t<td  class=\'querydata\'  id=\"arr_date_disp1\" name=\"arr_date_disp1\" style=\"display:none\" >\n\t\t\t<INPUT TYPE=\"text\" name=\"arrival_date\"  id=\"arrival_date\" size=\"16\" maxlength=\"16\" value=\"\" onblur=\"if(validDateObj(this,\'DMYHM\',localeName)){validate_date(this);compareDates(this,document.forms[0].pref_date);}\"  onKeyPress=\'\' onkeyDown=\'shift_tab();\'><input type=\"image\" id=\"arr_img\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].arrival_date.focus();return showCalendar(\'arrival_date\',null,\'hh:mm\');\" ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'>\n\t\t\t</td> \n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t<tr><td class=\'DEFAULTBLANKROW2PT\' colspan=4>&nbsp;</td></tr>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t</table>\n\t<input type=\"hidden\" name=\"sysdate\" id=\"sysdate\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" name=\"priority_chk\" id=\"priority_chk\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\" name=\"max_trn_date_time\" id=\"max_trn_date_time\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"><!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617-->\n\t\n\t<input type=\"hidden\" name=\"isArrivalDateAppl\" id=\"isArrivalDateAppl\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"><!--Added by mujafar  for ML-MMOH-CRF-1136-->\n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t<br>\n\n\t</form>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n<script>\n\tif(document.forms[0].transfer_type1 != null)\n\t{\n\t\tif(document.forms[0].transfer_type1.value != \"\")\n\t\t{   \n\t\t\tdocument.forms[0].transfer_type1.disabled = true;\n\t\t}\n\t}\n</script>\n\t \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
String locale				= (String)session.getAttribute("LOCALE");

Connection con				= null;
Statement stmt				= null;
PreparedStatement pstmt		= null;
ResultSet rset				= null;
try
{
	con						=	ConnectionManager.getConnection(request);
	String facilityId		=	checkForNull((String)session.getValue("facility_id"));
	String eid				=	checkForNull(request.getParameter("encounter_id"));
	String sdate			=   checkForNull(request.getParameter("sdate"));
	String admissiondate	=	checkForNull(request.getParameter("admissiondate"));
	String admissiontype	=	checkForNull(request.getParameter("admissiontype"));
	String status_value		=	checkForNull(request.getParameter("status_value"));
	String MAX_TRN_DATE_TIME=   checkForNull(request.getParameter("max_trn_date_time"));
	
	long    encounterid		=	Long.parseLong(eid);
	String call_function	=	request.getParameter("call_function");
	StringBuffer strBuffer	=	new StringBuffer();
	String admissiondate_converted = "";
	String sdate_converted	= "";
	String d_converted		= "";
	String trans_Type		= "";
	if(!(admissiondate.equals("") || admissiondate == null))
			admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 
	
	if(!(sdate.equals("") || sdate == null))
			sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",locale); 
	if(!(MAX_TRN_DATE_TIME.equals("") || MAX_TRN_DATE_TIME == null))
	MAX_TRN_DATE_TIME		= DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);

	boolean isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");//Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617
	
	boolean isArrivalDateAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AR_DATE_IN_TR_PAT_IN_APPL_YN"); //Added by Mujafar for ML-MMOH-CRF-1136

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(admissiondate_converted));
            _bw.write(_wl_block8Bytes, _wl_block8);

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt=new java.util.Date();
	String d = dateFormat.format( dt ) ;
	String min = String.valueOf(dt.getMinutes()) ;
	if(min.length() == 1)   min = "0"+min ;
	d=d + " "+String.valueOf(dt.getHours())+":"+min;

	if(!(d.equals("") || d == null))
			d_converted = DateUtils.convertDate(d,"DMYHM","en",locale); 	

	//String admissiondate		= "";
	//String admissiontype		= "";
	String prefered_date		="";
	String tfr_type_code		="";
	String priority				= "";
	String TRANSFER_TY_SHORT_DESC ="";
	String prefered_date_converted ="";
	

	
		strBuffer.delete(0, strBuffer.length());
		if(call_function.equals("TransferPatientIn"))
		{
			strBuffer.append("select PRIORITY_CODE,ip_get_desc.IP_TRANSFER_PRIORITY(facility_id,PRIORITY_CODE,'"+locale+"',2) PRIORITY_SHORT_DESC, TFR_REQ_TYPE,to_char(PREF_DATE_TIME,'dd/mm/rrrr hh24:mi') PREF_DATE_TIME,TFR_REQ_REASON,ip_get_desc.IP_TRANSFER_TYPE(TFR_REQ_REASON,'"+locale+"',2) TRANSFER_TYPE_SHORT_DESC ");
			strBuffer.append("from ip_transfer_request where tfr_req_status = '3' and encounter_id =");
			strBuffer.append(encounterid);
            strBuffer.append("  and facility_id = '");
            strBuffer.append(facilityId);
            strBuffer.append("' ");
			
			
		}
		else
		{
			strBuffer.append("SELECT" );
			strBuffer.append("  PRIORITY_CODE" );
			strBuffer.append("  , ip_get_desc.IP_TRANSFER_PRIORITY(facility_id, PRIORITY_CODE,'"+locale+"',2) PRIORITY_SHORT_DESC" );
			strBuffer.append("  , TFR_REQ_REASON" );
			strBuffer.append("  , ip_get_desc.IP_TRANSFER_TYPE(TFR_REQ_REASON,'"+locale+"',2) TRANSFER_TYPE_SHORT_DESC" );
			strBuffer.append("  , TFR_REQ_TYPE" );
			strBuffer.append("  , TO_CHAR(PREF_DATE_TIME,'dd/mm/rrrr hh24:mi') PREF_DATE_TIME" );
			strBuffer.append("  , DECODE (TFR_REQ_TYPE, 'RT','Request for Transfer', 'TO', 'Transfer Out') tfr_req_type_desc " );
			strBuffer.append("FROM" );
			strBuffer.append("  ip_transfer_request " );
			strBuffer.append("WHERE " );
			strBuffer.append("  facility_id = '"+facilityId+"' " );
			strBuffer.append("  AND encounter_id ="+encounterid+" " );
			strBuffer.append("  AND tfr_req_status = '1' " );
		}
		stmt  = con.createStatement();
		rset  = stmt.executeQuery(strBuffer.toString());
		if(rset.next())
		{
			tfr_type_code			= checkForNull(rset.getString("TFR_REQ_REASON"));
			TRANSFER_TY_SHORT_DESC	= checkForNull(rset.getString("TRANSFER_TYPE_SHORT_DESC"));
			prefered_date			= checkForNull(rset.getString("PREF_DATE_TIME"));
			priority				= checkForNull(rset.getString("PRIORITY_SHORT_DESC"));
			if(rset	!= null)   rset.close();
			if(stmt  != null)   stmt.close();		
		}

	//}
	/*Monday, May 03, 2010 , commented for PE
	String trn_date_time = "";
	String Sql_trnTime = " Select to_char(trn_date_time,'dd/mm/rrrr hh24:mi') trn_date_time from IP_ADT_TRN where encounter_id = '"+encounterid+"' and facility_id  = '"+facilityId+"' ";    
	stmt  = con.createStatement();
	rset    = stmt.executeQuery(Sql_trnTime);
	if(rset != null)
	{
		if(rset.next())
		{
			trn_date_time = checkForNull(rset.getString("trn_date_time"));
		}    
		if(rset	!= null)   rset.close();
		if(stmt  != null)   stmt.close();		
	}
	
//modified for 12/15/2008 6021  MF-SCF-0051
	String trn_date = "SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi')  FROM IP_ADT_TRN WHERE FACILITY_ID = '"+facilityId+"' AND ENCOUNTER_ID = '"+encounterid+"'";
		stmt  = con.createStatement();
		rset	=stmt.executeQuery(trn_date.toString());
			if(rset != null){
				if(rset.next()){
					MAX_TRN_DATE_TIME = rset.getString(1);
				}
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
MAX_TRN_DATE_TIME = DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);

	/**/
	if(prefered_date.equals(""))
	prefered_date=sdate;

	if(!( prefered_date==null || prefered_date.equals("")))
			prefered_date_converted=DateUtils.convertDate(prefered_date,"DMYHM","en",locale);
			

            _bw.write(_wl_block9Bytes, _wl_block9);
if(call_function.equals("TransferPatientOut")){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(admissiondate_converted));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block17Bytes, _wl_block17);
            _bw.write(_wl_block18Bytes, _wl_block18);
	
		
		if(!priority.equals("") || call_function.equals("TransferPatientIn") || !tfr_type_code.equals(""))
			{
						
						String disable_yn="";  // added by mujafar for ML-MMOH-CRF-1136
						if(isArrivalDateAppl)disable_yn="disabled";
		
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(prefered_date_converted));
            _bw.write(_wl_block22Bytes, _wl_block22);

				if(!isArrivalDateAppl) // added by mujafar for ML-MMOH-CRF-1136
				{
				
            _bw.write(_wl_block23Bytes, _wl_block23);

				}
				
            _bw.write(_wl_block24Bytes, _wl_block24);
	}
			else
			{	
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sdate_converted));
            _bw.write(_wl_block26Bytes, _wl_block26);
if(status_value.equals("Confirmed")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
	}	
            _bw.write(_wl_block29Bytes, _wl_block29);
	if(call_function.equals("TransferPatientIn"))
			{	
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(TRANSFER_TY_SHORT_DESC));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tfr_type_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
	}
			else
			{	
				
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
 if(isCnrmReqPatOutChngAppl){
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
 if(status_value.equals("Confirmed")){
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

					
						if(!status_value.equals("Confirmed"))
						{
							//rset = stmt.executeQuery("select ip_get_desc.IP_TRANSFER_TYPE(transfer_type_code,'"+locale+"',1)short_desc, transfer_type_code||'='|| blocking_type_code || '=' ||blokcing_type_short_desc ||'='|| decode(block_units, 'H', block_period, 'D', block_period*24)   ||'='|| to_char(sysdate+(decode(block_units, 'H', block_period, 'D', block_period*24)/24), 'dd/mm/rrrr hh24:mi') || '='||block_units||'='|| override_yn ||'='||(select bed_block_period_normal from ip_param where facility_id ='"+facilityId+"') transfer_type_code from IP_TRANSFER_TYPE_VW where EFF_STATUS = 'E' order by 1");
							trans_Type = "select ip_get_desc.IP_TRANSFER_TYPE(transfer_type_code,?,2)short_desc, transfer_type_code||'='|| blocking_type_code || '=' ||blokcing_type_short_desc ||'='|| decode(block_units, 'H', block_period, 'D', block_period*24)   ||'='|| to_char(sysdate+(decode(block_units, 'H', block_period, 'D', block_period*24)/24), 'dd/mm/rrrr hh24:mi') || '='||block_units||'='|| override_yn ||'='||(select bed_block_period_normal from ip_param where facility_id =?) ||'='|| informed_dtls_mand_yn transfer_type_code  from IP_TRANSFER_TYPE_VW where EFF_STATUS = 'E' order by 1"; //Modified by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617
						}
						else
						{
							// 17956 
							//rset = stmt.executeQuery("select ip_get_desc.IP_TRANSFER_TYPE(transfer_type_code,'"+locale+"',1) short_desc, transfer_type_code from IP_TRANSFER_TYPE_VW where EFF_STATUS = 'E' order by 1");
							trans_Type = "select ip_get_desc.IP_TRANSFER_TYPE(transfer_type_code,?,2) short_desc, transfer_type_code from IP_TRANSFER_TYPE where EFF_STATUS = 'E' order by 1";
						}
					
					pstmt = con.prepareStatement(trans_Type);
					pstmt.setString(1,locale);
					if(!status_value.equals("Confirmed"))
						pstmt.setString(2,facilityId);
					rset  = pstmt.executeQuery();
					while(rset.next())
					{
						String desc = rset.getString("short_desc");
						String code = rset.getString("transfer_type_code");
						String sel = "";
						if (code.equals(tfr_type_code))
							sel = "selected";
						else
							sel = "";
						out.print("<option value=\""+code+"\""+sel+">"+desc );
					}
					if(rset	!= null)   rset.close();
					if(pstmt  != null)   pstmt.close();		
				
            _bw.write(_wl_block41Bytes, _wl_block41);
	}	
            _bw.write(_wl_block42Bytes, _wl_block42);
	if(call_function.equals("TransferPatientIn"))
		{	
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

			
			if(isArrivalDateAppl) // added by mujafar for ML-MMOH-CRF-1136
			{
				
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
	}
		else
		{	
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(MAX_TRN_DATE_TIME));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(isArrivalDateAppl));
            _bw.write(_wl_block57Bytes, _wl_block57);
if(call_function.equals("TransferPatientIn") ||!priority.equals(""))
	{
            _bw.write(_wl_block58Bytes, _wl_block58);
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
		
		if(rset	  != null)			rset.close();
		if(stmt   != null)			stmt.close();
	}catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}
	 
            _bw.write(_wl_block61Bytes, _wl_block61);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PreferredDateTime.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PreferredDateTime.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforTransfer.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforTransfer.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TransferInStatus.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accepted.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Rejected.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ArrivalDateTime.label", java.lang.String .class,"key"));
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
}
