package jsp_servlet._eca._jsp;

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
import eCommon.XSSRequestWrapper;

public final class __encsearchcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncSearchCriteria.jsp", 1743657603029L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n  <script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n   <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n  <script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n  <script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n  <script language=\'javascript\' src=\"../js/EncSearchCriteria.js\"></script>\n<script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\nfunction callcheck_val()\n{ \n\tif (document.forms[0].discharge_val.checked==true)\n\t\tdocument.forms[0].discharge_val.value=\"Y\";\n\telse\n\t\tdocument.forms[0].discharge_val.value=\"N\";\n}\n\n//Func will return an alert message if FROM DATE is null and TO Date is selected\nfunction checkFromDt(to,frmDt)\n{\n\tif ( (frmDt.value==\'\') && (to.value!=\'\') )\n\t{\n\t\terror  = getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t\terror = error.replace(\'$\', getLabel(\"Common.fromdate.label\",\"Common\"));\t\t\n\t\talert(error);\n\t\tto.value=\'\';\n\t\tfrmDt.focus();\n\t}\n\t\treturn;\n}\n\nfunction doDcsdDateCheck(from,to) {\n    var fromarray; var toarray;\n    var fromdate = from.value ;\n    var todate = to.value ;\n    if(fromdate.length > 0 && todate.length > 0 ) {\n            fromarray = fromdate.split(\"/\");\n            toarray = todate.split(\"/\");\n            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);\n            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);\n            if(Date.parse(todt) <= Date.parse(fromdt)) {\n                return false;\n            }\n            else if(Date.parse(todt) > Date.parse(fromdt)) return true;\n    }\nreturn true;\n}\n\nfunction DscdPeriodChk(Dt)\n{\t\t\n\tif(Dt.value!=\"\")\t\n\t{\n\t\tvar SystemDate\t= document.forms[0].SystemDate.value;\n\t\tif(validDate(Dt.value,\"DMY\",\"en\"))\n\t\t{\n\t\t\tvar toDt\t= convertDate(Dt.value,\"DMY\",localeName,\"en\");\n\t\t\tif(!isAfter(SystemDate,toDt,\'DMY\',localeName))// DateUtils.js\n\t\t\t{\n\t\t\t\terror=getMessage(\"MRDATE1_GT_DATE2\",\"MR\");\n\t\t\t\terror = error.replace(\'$\', getLabel(\"eMR.DeceasedPeriod.label\",\"MR\"));\t\t\n\t\t\t\terror = error.replace(\'#\', getLabel(\"Common.CurrentDate.label\",\"Common\"));\t\n\t\t\t\talert(error);\n\t\t\t\tDt.value=\'\';\n\t\t\t\tDt.focus();\n\t\t\t}\n\t\t}\n\treturn;\n}\n}\n\n//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] \n//Func will return an alert message if TO DATE is Less than FROM DATE\nfunction ComparePeriodFromToTime(from,to)\n{\n\tvar frdt = from.value;\n\tvar tdt = to.value;\n\n\tif(frdt !=\'\' && tdt !=\'\' )// DateUtils.js\n\t{\n\t\tif(validDate(frdt,\"DMY\",\"en\") && validDate(tdt,\"DMY\",\"en\"))\n\t\t{\n\t\t\tvar fromDt\t= convertDate(frdt,\"DMY\",localeName,\"en\");\n\t\t\tvar toDt\t= convertDate(tdt,\"DMY\",localeName,\"en\");\n\n\t\t\tif(!isBefore(fromDt,toDt,\'DMY\',localeName))// DateUtils.js\n\t\t\t{\n\t\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\t\tto.focus();\n\t\t\t}\n\t\t}\n\t}\n}\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onLoad=\"FocusFirstElement()\"  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n   <form name = \'enc_search_form\' action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<table cellpadding=\'2\' border=\"0\" cellspacing=\'0\' width=\'100%\' >\n\t\t\t<tr>\n\t\t\t\t<td width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td width=\'25%\' class=\"fields\"><input type=text  name=\'PatientId\' id=\'PatientId\' size=\"\" maxlength=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onBlur=\"makeValidString(this);ChangeUpperCase(this);document.forms[0].clear.onclick();\" onKeypress=\'return CheckForSpecChars(event);\' align=\"center\"><input type=\'button\' name=\'patient_id\' id=\'patient_id\' value=\'?\' class=\'button\' onclick=\'callSearchScreen()\'>\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td class=\"fields\" width=\"25%\"><input type=text  name=\'p_encounter_id\' id=\'p_encounter_id\' size=\"12\" maxlength=\"12\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNumVal(this);EncTypeMand(this);\"></td>\t\t\t\n\t\t\t</tr>\n\t<tr>\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td class=\"fields\" width=\"25%\"><input type=\"text\" name=\"alt_id1_exp_date\" id=\"alt_id1_exp_date\" size=\"10\" maxlength=\'10\' id=\'altidexpdt1\'  onblur=\"validDateObj(this,\'DMY\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');ComparePeriodFromToTime(this,alt_id2_exp_date);\" onkeypress=\"return Valid_DT(event)\"></input><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"document.forms[0].alt_id1_exp_date.focus();return showCalendar(\'altidexpdt1\');\">-<input type=\"text\" name=\"alt_id2_exp_date\" id=\"alt_id2_exp_date\" size=\"10\" maxlength=\'10\' id=\'altidexpdate2\'  onblur=\"validDateObj(this,\'DMY\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');ComparePeriodFromToTime(alt_id1_exp_date,this);\" onkeypress=\"return Valid_DT(event)\" ></input><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\'   onClick=\"document.forms[0].alt_id2_exp_date.focus();return showCalendar(\'altidexpdate2\');\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'encDate_img\' style=\"visibility:hidden\"></img></td>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\"patID_img\").style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].alt_id1_exp_date.value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\tdocument.forms[0].alt_id2_exp_date.value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t</script>\n\t\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\n\t\t\t<td width=\"22%\" class=\"label\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td  class=\"fields\">\n\t\t\t\t<select name=\"lstPatientClass\" id=\"lstPatientClass\">\n\t\t\t\t<option>---";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="---</option>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'encType_img\' style=\"visibility:hidden\"></img></td>\n\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<td width=\'25%\' class=\'label\'></td>\t\t\t\n\t\t\t\t<td width=\'25%\' class=\'label\'></td>\t\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</tr>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\"><input name=\'p_discharge_date_from\' id=\'p_discharge_date_from\' id=\'dischargedatefrom\' onblur=\"validDateObj(this,\'DMY\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');ComparePeriodFromToTime(this,p_discharge_date_to);DscdPeriodChk(this);\" value=\'\' size=\'10\' maxlength=\'10\' onkeypress=\"return Valid_DT(event)\"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].dischargedatefrom.focus();return showCalendar(\'dischargedatefrom\',\'dd/mm/y\',null );\" ></input>-<input name=\'p_discharge_date_to\' id=\'p_discharge_date_to\' id=\'dischargedateto\' value=\'\' size=\'10\' maxlength=\'10\' onblur=\"validDateObj(this,\'DMY\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');ComparePeriodFromToTime(p_discharge_date_from,this);DscdPeriodChk(this);\" onkeypress=\"return Valid_DT(event)\"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'dischargedateto\',\'dd/mm/y\',null );\"></input></td>\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\"><input name=\'p_discharge_date_from\' id=\'p_discharge_date_from\' id=\'dischargedatefrom\' value=\'\' size=\"10\" maxlength=\'10\' onkeypress=\"return Valid_DT(event)\" onblur=\'validDateObj(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\");CompareDisPeriodFromToTime(this,p_discharge_date_to);disChargePeriodChk(this);\'><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'dischargedatefrom\',null,\'hh:mm\' );\"></input><input name=\'p_discharge_date_to\' id=\'p_discharge_date_to\' id=\'dischargedateto\' value=\'\' size=\"10\" maxlength=\'10\' onblur=\"validDateObj(this,\'DMYHM\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');CompareDisPeriodFromToTime(p_discharge_date_from,this);disChargePeriodChk(this);\'\" onkeypress=\"return Valid_DT(event)\"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'dischargedateto\',null,\'hh:mm\' );\"></input><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'DischDate_img\' style=\"visibility:hidden\"></img></td>\n\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t\t<script>\n\t\t\tdocument.forms[0].dischargedateto.value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\tdocument.forms[0].dischargedatefrom.value = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t\tdocument.getElementById(\"patID_img\").style.visibility = \"hidden\";\n\t\t    document.getElementById(\"encDate_img\").style.visibility = \"hidden\";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<td width=\"25%\"  class=\'label\'>&nbsp;</td>\t\t\t\n\t\t<td width=\"25%\"   class=\'label\'>&nbsp;</td>\t\t\n\t\t<td width=\"25%\"   class=\'label\'>&nbsp;</td>\t\t\n\t\t<td width=\"25%\"   class=\'label\'>&nbsp;</td>\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t<tr>\n\t\t<td class=\"label\" width=\"25%\" nowrap>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t<td nowrap ><select name=\"orderBy\" id=\"orderBy\"><option>---";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="---</option>\n\t\t\t<option value=\"ED\" selected>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\n\t\t\t<option value=\"ET\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n\t\t\t</select>\t\t\n\t\t</td>\n\t\t<td class=\"label\" width=\"25%\"></td>\n\t\t<td class=\"label\" width=\"25%\"></td>\n\t</tr>\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<td width=\"25%\" class=\'label\' colspan=\'1\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t<td width=\"25%\"  class=\'fields\' colspan=\'1\'><input type=\"checkbox\" name=\"discharge_val\" id=\"discharge_val\" onclick=\"callcheck_val();\"></td>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t<td  colspan=\'1\'></td>\n\t\t\t\t<td  colspan=\'1\'></td>\n\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<td width=\"25%\" class=\'label\' colspan=\'1\'></td>\n\t\t\t<td width=\"25%\" class=\'button\' colspan=3 nowrap><input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' class=\'button\' onclick=\'submitPage()\'><input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' class=\'button\' onclick=\'clearAll()\'></td>\n\t\t</tr>\n\t\t</table>\n     </div>\n\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\n\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\t\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t<input type=\'hidden\' name=\'operstn\' id=\'operstn\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n\t<input type=\'hidden\' name=\'SystemDate\' id=\'SystemDate\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\t<input type=\'hidden\' name=\'qerString\' id=\'qerString\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n\n     <input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'MRBIPFFPRC\'></input>\n     <input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'MR\'></input>\n     <input type= \'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'></input>\n     <input type=\'hidden\' name=\'p_user_name\' id=\'p_user_name\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'></input>\n     <input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'\'></input>\n\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<script>\n\t\t\t document.forms[0].encType_img.style.visibility = \'visible\';\n\t\t\t document.forms[0].encDate_img.style.visibility = \'visible\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t<script>\n\t\t\t document.forms[0].DischDate_img.style.visibility = \'visible\';\n\t\t\t document.forms[0].encType_img.style.visibility = \'visible\';\n\t\t</script>\n\t\t \n\t ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t<script>\n\t\t\t\t document.forms[0].encType_img.style.visibility = \'visible\';\n\t\t\t</script>\n\t\t \n\t ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n  </form>\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block8Bytes, _wl_block8);

  String p_user_name		= (String) session.getValue( "login_user" ) ;
  String locale           = (String) session.getAttribute("LOCALE");
  Connection con = ConnectionManager.getConnection(request);
  ResultSet rs   = null;
  Statement stmt = null;
  String pat_id_length = "";
	try 
	{
		String jsp_name =request.getParameter("jsp_name");
		if( jsp_name == null) jsp_name="";
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

		String encounterID_repDischargeAdvice=request.getParameter("encounter_id");
		if( encounterID_repDischargeAdvice == null) encounterID_repDischargeAdvice="";
		String loginUser = (String)session.getValue("login_user");
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		String SystemDate = "";

			try
			{
		    	 stmt = con.createStatement();
				 rs	=	stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy') SystemDate from dual");
 				 if (rs.next() && rs != null)
					 SystemDate = rs.getString(1);
			
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			}
			catch(Exception e) 
			{
				//out.println("Exception in Sysdate : "+e.toString());//COMMON-ICN-0181
                               e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(rs!=null) rs.close();
			}
			try
			{
		    	 stmt = con.createStatement();
				 rs	=	stmt.executeQuery("select patient_id_length from mp_param");
 				 if (rs.next() && rs != null)
					 pat_id_length = rs.getString(1);

			}catch(Exception e) 
			{
				//out.println("Exception in Sysdate : "+e.toString());//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(rs!=null) rs.close();
			}
			String SystemDate_display = DateUtils.convertDate(SystemDate,"DMY" ,"en",localeName);

            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponentCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("mr_transaction"), weblogic.utils.StringUtils.valueOf("Y")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
	
	if( call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL"))
		{	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block22Bytes, _wl_block22);

		}	
		
	
            _bw.write(_wl_block23Bytes, _wl_block23);
	
	if(!call_function.equals("QUERY_MATERNAL_REPORT")) 
	{	
	
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
	
					if(rs != null) rs.close();
										
					rs = stmt.executeQuery("select patient_class, short_desc from am_patient_class_lang_vw where language_id='"+locale+"' order by 1");
					

					if(rs != null)
					{									
						while (rs.next())
						{	
						
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs.getString("patient_class")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block29Bytes, _wl_block29);

						}
					}	
					if(rs!=null) rs.close();
					
					
            _bw.write(_wl_block30Bytes, _wl_block30);
 
	}
	else 
	{ 
	
            _bw.write(_wl_block31Bytes, _wl_block31);
 
	} 

            _bw.write(_wl_block32Bytes, _wl_block32);
 if(call_function.equals("QUERY_MATERNAL_REPORT")||call_function.equals("DIAG_RECODE") || call_function.equals("MR_VIEW_DTH_REG"))
{

            _bw.write(_wl_block33Bytes, _wl_block33);
 
	  if (call_function.equals("MR_VIEW_DTH_REG"))
		{
	
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block37Bytes, _wl_block37);

		} 
		else 
		{
	
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block41Bytes, _wl_block41);
 
	} 
	if(call_function.equals("DIAG_RECODE"))
	{
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block44Bytes, _wl_block44);

	}
	
            _bw.write(_wl_block45Bytes, _wl_block45);
 } 
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

			if(call_function.equals("MR_REC_PAT_VAL"))
			{
		
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

			}
			else 
			{
			
            _bw.write(_wl_block53Bytes, _wl_block53);

			}
			
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(module));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block74Bytes, _wl_block74);
	
	if(call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL") )
	{	
	
            _bw.write(_wl_block75Bytes, _wl_block75);

	}
	if(call_function.equals("DIAG_RECODE"))
	{
	
            _bw.write(_wl_block76Bytes, _wl_block76);

	}
	 if(call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
	{
	
            _bw.write(_wl_block77Bytes, _wl_block77);

	 }
     } catch(Exception e) {
        //  out.println(e.toString());//COMMON-ICN-0181
            e.printStackTrace();//COMMON-ICN-0181
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
     }
     finally {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  ConnectionManager.returnConnection(con,request);
     }

            _bw.write(_wl_block78Bytes, _wl_block78);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EncPeriod.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeceasedPeriod.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DischPeriod.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.discharged.label", java.lang.String .class,"key"));
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
}
