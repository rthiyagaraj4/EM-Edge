package jsp_servlet._emr._jsp;

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

public final class __repwehuadrequestcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/repWEHUADRequestCriteria.jsp", 1709119084192L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\"></link>\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n  <script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n  \n  \n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n  <script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n  <script language=\'javascript\' src=\"../../eMR/js/MRReports.js\"></script>\n</head>\n<script>\nfunction PeriodcheckDateTime(obj1,obj2)\n{\t\n\tvar a=obj1.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\tvar splitdate1 = a[0].split(\"/\")\n\n\t var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));\n\n\t a=obj2.split(\" \")\n\t splitdate=a[0];\n\t splittime=a[1]\n\n\t splitdate1 = a[0].split(\"/\")\n\t var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));\n\n\t if(Date.parse(to_date) < Date.parse(from_date))\n\t{\n\t\talert( getMessage(\"TO_DT_GR_EQ_FM_DT\",\'SM\') );\n\t\tdocument.forms[0].alt_id2_exp_date.focus();\n\t\tdocument.forms[0].alt_id2_exp_date.select();\n\t\treturn false;\n\t}\n}\nfunction ComparePeriodFromToTime(from,to)\n{\n\n\tvar frdt = from.value;\n\tvar tdt = to.value;\n\n\tif(from !=\'\')\n\t{\n\t\tvar t1 = CheckDate(from);\t\t\n\t\tif(!t1)\n\t\t{\n\t\t\tfrom.value=\"\"; \n\t\t\tfrom.focus();\n\t\t\treturn;\n\t\t}\n\t}\n\tif(to !=\'\')\n\t{\n\t\tvar t1 = CheckDate(to);\t\t\n\t\tif(!t1)\n\t\t{\n\t\t\tto.value=\"\"; \n\t\t\tto.focus();\n\t\t\treturn;\n\t\t}\n\t}\n\n\t\tPeriodcheckDateTime(frdt,tdt);\n}\nfunction reset()\n{\t\n\tf_query_add_mod.document.forms[0].reset();\n}\n\n\nfunction submitPage()\n{\n\tvar continue_yn = \"Y\";\n\t\n\tif(document.forms[0].call_function.value == \'DIAG_RECODE\' ||\n\tdocument.forms[0].call_function.value==\'MRBWEHUA\' || document.forms[0].call_function.value==\'MRBWEHUD\' || document.forms[0].call_function.value == \'MRBCANNT\')\n\t{\n\t\tif(document.forms[0].alt_id2_exp_date.value == \'\')\n\t\t{\n\t\t\tcontinue_yn = \"N\";\n\t\t\terror  = getMessage(\"CAN_NOT_BE_BLANK\",\'Common\');\n\t\t\terror = error.replace(\'$\', getLabel(\"Common.encounter.label\",\"Common\")+\' \'+getLabel(\"Common.periodto.label\",\"Common\"));\n\t\t\talert(error);\n\t\t\tdocument.forms[0].alt_id2_exp_date.focus();\n\t\t}\n\t\telse if(document.forms[0].alt_id1_exp_date.value == \'\')\n\t\t{\n\t\t\tcontinue_yn = \"N\";\n\t\t\terror  = getMessage(\"CAN_NOT_BE_BLANK\",\'Common\');\n\t\t\terror = error.replace(\'$\', getLabel(\"Common.encounter.label\",\"Common\")+\' \'+getLabel(\"Common.periodfrom.label\",\"Common\"));\n\t\t\talert(error);\n\t\t\tdocument.forms[0].alt_id1_exp_date.focus();\n\t\t}\n\t}\n\t\n\tif(document.forms[0].call_function.value!=\'QUERY_MARK_MLC_OSCC\' && document.forms[0].call_function.value!=\'QUERY_MATERNAL_REPORT\' && document.forms[0].call_function.value!=\'DIAG_RECODE\' && document.forms[0].call_function.value!=\'MRBWEHUA\' && document.forms[0].call_function.value!=\'MRBWEHUD\' &&  \n\tdocument.forms[0].call_function.value!=\'MRBCANNT\') \n\t{\n\t\tif(document.forms[0].PatientId.value == \'\')\n\t\t{\n\t\t\tcontinue_yn = \"N\";\n\t\t\terror  = getMessage(\"CAN_NOT_BE_BLANK\",\'Common\');\n\t\t\terror = error.replace(\'$\', getLabel(\"Common.patientId.label\",\"Common\"));\n\t\t\talert(error);\n\t\t\tdocument.forms[0].PatientId.focus();\n\t\t}\n\t}\n\tif(continue_yn == \"Y\")\n\t{\n\t\tvar condition=\"\"\n\t\tfor(var i=0; i<document.forms[0].elements.length; i++)\n\t\t\t\tcondition+= document.forms[0].elements[i].name +\"=\"+ escape(document.forms[0].elements[i].value)+\"&\"\n\t\t\t\n\t\toper_stn = document.forms[0].operstn.value;\n\n\t\tvar call_function = document.forms[0].call_function.value;\n\n\t\tparent.frames[2].location.href= \'../../eMR/jsp/repWEHUADRequestResult.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&\'+condition+\'&oper_stn_id=\'+oper_stn+\'&show_bed_yn=Y&fromSelect=fromSelect\';\n\t}\n}\n</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onLoad=\"FocusFirstElement()\"  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n   <form name = \'search_form\' action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n      <div>\n        <table cellpadding=\'0\'  border=\"0\" cellspacing=\'0\' width=\'100%\' align=\'center\' >\n\t\t\t<tr>\n\t\t\t\t<td align=\'right\' width=\'10%\' class=\"label\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t<td align=left>&nbsp;<input type=text  name=\'PatientId\' id=\'PatientId\' size=\"\" maxlength=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" onBlur=\"makeValidString(this);ChangeUpperCase(this);\" onKeypress=\'makeValidString(this);return CheckForSpecChars(event);\' align=\"center\"><input type=\'button\' name=\'patient_id\' id=\'patient_id\' value=\'?\' class=\'button\' onclick=\'callSearchScreenrepWEHUADReqCri()\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'patID_img\' style=\"visibility:visible\"></img>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\t\t\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<td align=\'right\'  class=\'label\'>&nbsp;</td>\t\t\t\n\t\t  <td align=\'right\'  class=\'label\'>&nbsp;</td>\n          </tr>\n\t<tr>\n\t\t<td colspan=6 align=left width=\'100%\'>\n\t\t<table cellpadding=\'0\'  border=0 cellspacing=\'0\' width=\'100%\' align=\'left\' >\n\t\t<tr align=left>\t\t\t\n\t\t<td class=label width=\'100%\' align=left>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n<table cellpadding=\'0\'  border=\'0\' cellspacing=\'0\' width=\'100%\' align=\'left\' >\n\t<tr>\n\t\t<td  align=\'right\' class=\"label\" width=\"10%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;</td><td  align=left width = \"44%\">&nbsp;<input type=\"text\" name=\"alt_id1_exp_date\" id=\"alt_id1_exp_date\" size=\"10\" maxlength=\'10\' id=\'altidexpdt1\'  onblur=\"ComparePeriodFromToTime(this,alt_id2_exp_date);\" onkeypress=\"return submitFormrepWEHUADReqCri(event)\"></input><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"document.forms[0].alt_id1_exp_date.focus();return showCalendar(\'altidexpdt1\');\">&nbsp;-&nbsp;<input type=\"text\" name=\"alt_id2_exp_date\" id=\"alt_id2_exp_date\" size=\"10\" maxlength=\'10\' id=\'altidexpdate2\'  onblur=\"ComparePeriodFromToTime(alt_id1_exp_date,this);\" onkeypress=\"return submitFormrepWEHUADReqCri(event)\" ></input><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\'   onClick=\"document.forms[0].alt_id2_exp_date.focus();return showCalendar(\'altidexpdate2\');\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'encDate_img\' style=\"visibility:hidden\"></img></td>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\n\t\t<td align=\'right\' class=\"label\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;</td>\n\t\t\t<td align=left>\n\t\t\t\t<select name=\"lstPatientClass\" id=\"lstPatientClass\">\n\t\t\t\t<option>----- ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" -----</option>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'encType_img\' style=\"visibility:hidden\"></img></td>\n\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\t\t\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n\t</tr>\n\n\t<tr>\n\t\t<td align=\'right\' class=\"label\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;</td>\n\t\t<td  nowrap  align=left>&nbsp;<input type=text  name=\'p_encounter_id\' id=\'p_encounter_id\' size=\"12\" maxlength=\"12\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNumValrepWEHUADReqCri(this)\" align=\"center\"></td>\t\t\n\t\t<td align=\'right\' class=\"label\" nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;</td>\n\t\t<td nowrap ><select name=\"orderBy\" id=\"orderBy\"><option>----- ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" -----</option>\n\t\t\t<option value=\"ED\" selected>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\n\t\t\t<option value=\"ET\"  >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t\t</select>\t\t\n\t\t</td>\n\t\t<td align=\'right\' colspan=2 class=\'label\'>&nbsp;&nbsp;</td>\t\t\n\t\t\n\t\t</tr>\n\t<tr>\n\t\t\t<td align=\'right\'  class=\'label\' colspan=\'3\'>&nbsp;&nbsp;</td>\n\t\t\t<td colspan=3 nowrap class=\'button\'><input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' class=\'button\' onclick=\'submitPage()\'><input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' class=\'button\' onclick=\'clearAllrepWEHUADReqCri()\'>&nbsp;&nbsp;</td>\n\t\t</tr>\n\t\t</table>\n\n     </div>\n\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\t\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t<input type=\'hidden\' name=\'operstn\' id=\'operstn\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" >\n\n     <input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'MRBIPFFPRC\'></input>\n     <input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'MR\'></input>\n     <input type= \'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'></input>\n     <input type=\'hidden\' name=\'p_user_name\' id=\'p_user_name\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'></input>\n     <input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'\'></input>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t<script>\n\t\t\t document.forms[0].all.encDate_img.style.visibility = \'visible\';\n\t\t</script>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\n\n\t ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n  </form>\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String p_user_name		= (String) session.getValue( "login_user" ) ;
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
		//module=ph
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
		stmt = con.createStatement();
		
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		try
		{
			 
			 rs	=	stmt.executeQuery("select patient_id_length from mp_param");
			 if (rs.next() && rs != null)
				 pat_id_length = rs.getString(1);

		}catch(Exception e) 
		{
			//out.println("Exception in Sysdate : "+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
		}

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block11Bytes, _wl_block11);
 if (!call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("MRBWEHUA") && !call_function.equals("MRBWEHUD") && !call_function.equals("MRBCANNT")) 
				{
            _bw.write(_wl_block12Bytes, _wl_block12);
 
				} 
            _bw.write(_wl_block13Bytes, _wl_block13);
	if(!call_function.equals("QUERY_MATERNAL_REPORT")&& !call_function.equals("QUERY_MARK_MLC_OSCC")) 
	{	
            _bw.write(_wl_block14Bytes, _wl_block14);
	}	
            _bw.write(_wl_block15Bytes, _wl_block15);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponentCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("mr_transaction"), weblogic.utils.StringUtils.valueOf("Y")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
	if(!call_function.equals("QUERY_MATERNAL_REPORT")) 
	{	
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
	
					if(rs != null) rs = null;
					rs = stmt.executeQuery("select PATIENT_CLASS, short_desc from am_patient_class order by 1")  ;
					if(rs != null)
					{									
						while (rs.next())
						{	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("PATIENT_CLASS")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block26Bytes, _wl_block26);
	}
					}	
            _bw.write(_wl_block27Bytes, _wl_block27);
 }else { 
            _bw.write(_wl_block28Bytes, _wl_block28);
 } 
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(module));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block52Bytes, _wl_block52);
	if( call_function.equals("MRBWEHUD") || call_function.equals("MRBWEHUA") || call_function.equals("MRBCANNT"))
	{	
            _bw.write(_wl_block53Bytes, _wl_block53);
	}	
            _bw.write(_wl_block54Bytes, _wl_block54);

     } catch(Exception e) {
          //out.println(e.toString());
		  e.printStackTrace();
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
     }
     finally {
		 try
		 {
		  if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		 }
		 catch(Exception e)
		 {
		 }
		  ConnectionManager.returnConnection(con,request);
     }

            _bw.write(_wl_block55Bytes, _wl_block55);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EncPeriod.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
}
