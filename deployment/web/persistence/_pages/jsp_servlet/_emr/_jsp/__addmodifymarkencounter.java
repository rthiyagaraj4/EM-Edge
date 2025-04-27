package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifymarkencounter extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/addModifyMarkEncounter.jsp", 1724676366727L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" </TITLE>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n    <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\'javascript\' src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script src=\'../../eMR/js/MedRecRequest.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t<script>\n/// added by SRIDHAR R on 31 SEP 2004\n\t/*function compareDates0(obj)\n\t{\n\tif(!doDateCheckAlert(document.forms[0].from_date,document.forms[0].to_date))\n\t\t{\n\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\'SM\'));\n\t\t\tdocument.forms[0].to_date.select();\n\t\t\tdocument.forms[0].to_date.focus();\n\t\t}\n\t}\n\t*/\n\t</script>\n</HEAD>\n<body OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey()\'>\n <form name=\'markencounter_Form\' id=\'markencounter_Form\' action=\'../../servlet/eMR.MarkEncounterServlet\' method=\'post\' target=\'messageFrame\'>\n<table cellspacing=0 cellpadding=2 align=\'center\' width=\'100%\' border=\'0\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<tr>\n\t<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n\t       ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t  <td width=\"50%\" class=\"label\" nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td width=\"50%\" class=\"label\" nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<!--end ML-MMOH-CRF-0354 [IN057191 -->\n\t\t<td width=\"50%\" class=\"fields\"><INPUT TYPE=\"checkbox\" name=\"mlc\" id=\"mlc\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'onclick=\'setvalue(this);setImg();\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=\"fields\"><INPUT TYPE=\"checkbox\" name=\"oscc\" id=\"oscc\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onclick=\'setvalue(this);setImg();\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t<td class=\"fields\"><INPUT TYPE=\"text\" name=\"marked_by\" id=\"marked_by\" size=\'30\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" onblur=\"beforeGetuser(document.forms[0].marked_by_hid,this)\"><input type=button class=button name=\'search_user\' id=\'search_user\' value=\'?\' disabled onclick=\"getuser(document.forms[0].marked_by_hid,document.forms[0].marked_by)\"><img src=\'../../eCommon/images/mandatory.gif\' id=\'img1\' style=\'visibility:hidden\'></img></td><input type=hidden name=\"marked_by_hid\" id=\"marked_by_hid\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t<td class=\"fields\">\n\t\t<!-- Below code is commented by Akhilesh because unnecessary functions are using.-->\n\t\t<!--<INPUT TYPE=\"text\" name=\"marked_date\" id=\"marked_date\" size=\'15\' maxlength=\'15\' id=\'markingdate\' onkeypress=\"return Valid_DT(event);\"  value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  onblur=\'date_Validate(this);compareDates0(this);check_date_to_from(this);\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >-->\n\n\t\t<!--Modified by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140-->\n\t\t<INPUT TYPE=\"text\" name=\"marked_date\" id=\"marked_date\" size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT(event);\"  value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  onblur=\'date_Validate(this);\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ><img id=\'cal1\' src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].marked_date.select();";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="return showCalendar(\'marked_date\',null,\'hh:mm\');";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="return showCalendar(\'marked_date\');";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="/><img src=\'../../eCommon/images/mandatory.gif\' id=\'img2\' style=\'visibility:hidden\'></img></td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t<td class=\"fields\"><INPUT TYPE=\"text\" name=\"closed_by\" id=\"closed_by\" size=\'30\' maxlength=\'30\' onblur=\"beforeGetuser(document.forms[0].closed_by_hid,this)\" value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="><input type=button class=button name=\'search_closed_by\' id=\'search_closed_by\' value=\'?\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" onclick=\"getuser(document.forms[0].closed_by_hid,document.forms[0].closed_by)\"><img src=\'../../eCommon/images/mandatory.gif\' id=\'img3\' style=\'visibility:hidden\'></td><input type=hidden name=\"closed_by_hid\" id=\"closed_by_hid\" value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t<td class=\"fields\">\n\t\t<!-- Below code is commented by Akhilesh because unnecessary functions are using.-->\n\t\t<!--<INPUT TYPE=\"text\" name=\"closed_date\" id=\"closed_date\" size=\'15\' maxlength=\'15\' id=\'closeddate\' onkeypress=\"return Valid_DT(event)\"  value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onblur=\'check_date_to_from(this);compareDates0(this);compareDates1(this);\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">-->\n\t\t<INPUT TYPE=\"text\" name=\"closed_date\" id=\"closed_date\" size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT(event)\"  value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onblur=\'compareDates1(this);\' ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].closed_date.select();";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="return showCalendar(\'closed_date\',null,\'hh:mm\');";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="return showCalendar(\'closed_date\');";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="/><img src=\'../../eCommon/images/mandatory.gif\' id=\'img4\' style=\'visibility:hidden\'></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t<tr>\n\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' onclick=\'setvalue(this)\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t<td class=\'fields\'><input type=\"checkbox\" name=\'mlc\' id=\'mlc\' value=\'N\' onClick = \"enableOthMlcFlds(this);setvalue(this)\"  ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" ></td>\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\"checkbox\" name=\'mlc_death\' id=\'mlc_death\' onClick=\"updateSelf(this)\" value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="></td>\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\"police_rep_no\" id=\"police_rep_no\" maxlength=\'100\' onpaste=\"maxLengthPaste(this, \'100\')\" value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="></td>\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t\t\t<td class=\'fields\' ><input type=\'text\' name=\"police_stn_dtls\" id=\"police_stn_dtls\" maxlength=\'100\' onpaste=\"maxLengthPaste(this, \'100\')\" value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="></td>\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t\t\t<td class=\'fields\' ><input type=\'text\' name=\'outside_mlc_dtls\' id=\'outside_mlc_dtls\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' maxlength=\'100\' onpaste=\"maxLengthPaste(this, \'100\')\" ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="></td>\t\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\t\t<td class=\'fields\' >\n\t\t\t\t\t<input type=\'text\'  id=\'dateofmlccapture\' name=\"date_of_mlc_capture\" id=\"date_of_mlc_capture\" value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onBlur=\"validateMlcCapture(this)\" maxLength=\'19\' size=\'19\' ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\"mlcCaptureDateCalendar\" onClick=\"return showCalendar(\'dateofmlccapture\',\'dd/mm/yyyy\' ,\'hh:mm:ss\',null )\" style=\'cursor:pointer\'></img>\n\t\t\t\t\t</td>\t\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t\t<td class=\'fields\' >\n\t\t\t\t\t<textarea name=\'mlc_remarks\' rows=\"3\" cols=\"45\" onKeyPress=\"checkMaxLimit(this, 500)\" onpaste=\"maxLengthPaste(this, \'500\')\" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</textarea>\n\t\t\t\t\t</td>\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t<tr>\n\t\t<td class=\"label\">&nbsp;</td>\n\t\t<td class=\"button\" ><INPUT TYPE=button class=button name=\'record_button\' id=\'record_button\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' onclick=\"submitPage1();\" ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" ><INPUT TYPE=button class=button value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' onClick=\"closeWindow();\"></td>\n\t</tr>\n</table>\n\n\t<input type=\'hidden\' name=\'ENCOUNTER_ID\' id=\'ENCOUNTER_ID\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\'hidden\' name=\'hddBDate\' id=\'hddBDate\' >\n\t<input type=\'hidden\' name=\'hddDate\' id=\'hddDate\' >\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =">\n\t<input type=\'hidden\' name=\'mlc_yn_temp\' id=\'mlc_yn_temp\' value=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =">\n\t<input type=\'hidden\' name=\'oscc_yn_temp\' id=\'oscc_yn_temp\' value=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =">\n\t<input type=\'hidden\' name=\'encounter_date\' id=\'encounter_date\' value=";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =">\n\t<!--Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140-->\n\t<input type=\'hidden\' name=\'isDateTimeAppl\' id=\'isDateTimeAppl\' value=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">\n\n\t<!-- Added by Ajay Hatwate for GHL-CRF-0650 -->\n\t<input type=\'hidden\' name=\'isMLCAppl\' id=\'isMLCAppl\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t<input type=\'hidden\' name=\'visit_date_time\' id=\'visit_date_time\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\n\t<script>\n\t\tif(document.forms[0].isMLCAppl.checked){\n\t\t\tif(document.forms[0].mlc.checked){\n\t\t\t\tenableOthMlcFlds(document.forms[0].mlc);\n\t\t\t}\n\t\t}\n\t\tif(document.forms[0].isMLCAppl.value ==\'false\'){\n\t\tif (document.forms[0].mlc_yn_temp.value==\'Y\' && document.forms[0].closed_date.value==\'\')\n\t\t{\n\t\t\tdocument.getElementById(\"img3\").style.visibility=\'visible\';\t\t  document.getElementById(\"img4\").style.visibility=\'visible\';\n\t\t}\n\t\tif (document.forms[0].oscc_yn_temp.value==\'Y\' && document.forms[0].closed_date.value==\'\')\n\t\t{\n\t\t\tdocument.getElementById(\"img3\").style.visibility=\'visible\';\t\t  document.getElementById(\"img4\").style.visibility=\'visible\';\n\t\t}\n\t\t}\n\t</script>\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	//To handle HTML Special characters for GHL-CRF-0650 by Ajay Hatwate
	public static String escapeHTML(String s) {
	  StringBuilder procStr = new StringBuilder(Math.max(16, s.length()));
	  for (int i = 0; i < s.length(); i++) {
	      char c = s.charAt(i);
	      if (c > 127 || c == '"' || c == '\'' || c == '<' || c == '>' || c == '&') {
	      	procStr.append("&#");
	      	procStr.append((int) c);
	      	procStr.append(';');
	      } else {
	      	procStr.append(c);
	      }
	  }
	  return procStr.toString();
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
 
	String locale = (String)session.getAttribute("LOCALE"); 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String EncounterId = request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
	String FacilityId = request.getParameter("FacilityId")==null?"":request.getParameter("FacilityId");
	String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");

	Connection con = ConnectionManager.getConnection(request);
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
	/*end ML-MMOH-CRF-0354 [IN057191] */
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	String 	mlc_yn				= "";
	String  oscc_yn				= "";
	String	marked_by_id		= "";
	String	marked_by			= "";
	String 	marked_date			= "";
	String  closed_by_id		= "";
	String  closed_by			= "";
	String 	closed_date			= "";
	String readonlyfields_marked= "";
	String readonlyfields_closed= "";
	String disable				= "";
	String disabledfields		= "";
	String disabledfield		= "";
	String disabledfields1		= "";
	String sys_date				="";
	String checked_mlc			= "";
	String checked_oscc			= "";
	String disable_mlc			= "";
	String disable_oscc			= "";
	String encounter_date		= "";

	//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
	String sql		= "";
	

	boolean isDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MLC_OSCC_DATE_TIME"); //Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140

	//Added by Ajay Hatwate for GHL-CRF-0650		
	Boolean isMLCAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"AE", "MLC_DTLS");
	String polRepNo = "";
	String polStnDtl = "";
	String outMlcNoDtl = "";
	String dateOfMlcCapt = "";
	String mlcRem = "";
	String checkedMlcDeath = "";
	String visitDateTime = "";
	String recordedDate = "";
	String mlcDeathYn = "N";
	String pClass = "";
	String aeType = "";
	String disMlcFld = " disabled ";
try 
{	
	//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
	if(!isDateTimeAppl)
	{
		 sql = "select mlc_yn, oscc_yn, marked_by_id,sm_get_desc.sm_appl_user (marked_by_id,?, 1) marked_by, to_char(marked_date,'dd/mm/yyyy'), closed_by_id,sm_get_desc.sm_appl_user (closed_by_id,?, 1) closed_by, to_char(closed_date,'dd/mm/yyyy'),to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy') encounter_date,to_char(sysdate,'dd/mm/yyyy')sys_date, POL_REP_NO, POL_STN_ID, patient_class,to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') visit_adm_date_time, mlc_death_yn, mlc_remarks, to_char(MLC_CAPTURE_DATE,'DD/MM/YYYY HH24:MI:SS') MLC_CAPTURE_DATE, MLC_NO_OUTSIDE_DTLS  from pr_encounter where facility_id =? and encounter_id =? ";
	}else
	{
		 sql = "select mlc_yn, oscc_yn, marked_by_id,sm_get_desc.sm_appl_user (marked_by_id,?, 1) marked_by, to_char(marked_date,'dd/mm/yyyy hh24:mi'), closed_by_id,sm_get_desc.sm_appl_user (closed_by_id,?, 1) closed_by, to_char(closed_date,'dd/mm/yyyy hh24:mi'),to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') encounter_date,to_char(sysdate,'dd/mm/yyyy hh24:mi')sys_date, POL_REP_NO, POL_STN_ID, patient_class, to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') visit_adm_date_time, mlc_death_yn, mlc_remarks, to_char(MLC_CAPTURE_DATE,'DD/MM/YYYY HH24:MI:SS') MLC_CAPTURE_DATE, MLC_NO_OUTSIDE_DTLS from pr_encounter where facility_id =? and encounter_id =? ";
	}

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,locale);
	pstmt.setString(3,FacilityId);
	pstmt.setString(4,EncounterId);
	rset = pstmt.executeQuery();
	while(rset.next()){
		mlc_yn				= rset.getString("mlc_yn")==null?"N":rset.getString("mlc_yn");
		oscc_yn			= rset.getString("oscc_yn")==null?"N":rset.getString("oscc_yn");
		marked_by_id  = rset.getString("marked_by_id")==null?"":rset.getString("marked_by_id");
		marked_by	= rset.getString("marked_by")==null?"":rset.getString("marked_by");
		marked_date    = rset.getString(5)==null?"":rset.getString(5);
		
		//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
		if(!isDateTimeAppl)
		{
			if(!(marked_date==null || marked_date.equals(""))){
				marked_date	= DateUtils.convertDate(marked_date,"DMY","en",locale);
			}
		}else
		{
			if(!(marked_date==null || marked_date.equals(""))){
				marked_date	= DateUtils.convertDate(marked_date,"DMYHM","en",locale);
			}
		}
		closed_by_id   = rset.getString("closed_by_id")==null?"":rset.getString("closed_by_id");
		closed_by		= rset.getString("closed_by")==null?"":rset.getString("closed_by");
		closed_date     = rset.getString(8)==null?"":rset.getString(8);

		//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
		if(!isDateTimeAppl)
		{
			if(!(closed_date==null || closed_date.equals(""))){
				closed_date		= DateUtils.convertDate(closed_date,"DMY","en",locale);
			}
		}else
		{
			if(!(closed_date==null || closed_date.equals(""))){
				closed_date		= DateUtils.convertDate(closed_date,"DMYHM","en",locale);
			}
		}
		encounter_date    = rset.getString(9)==null?"":rset.getString(9);
		
		//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
		if(isDateTimeAppl)
		{
		encounter_date	  = encounter_date.replace(' ','$');
		}

		sys_date		  = rset.getString("sys_date");

		/*Added by Ajay Hatwate for GHL-CRF-0650 */
		pClass 		  = rset.getString("patient_class")==null?"":rset.getString("patient_class") ;
		polRepNo 		  = rset.getString("POL_REP_NO")==null?"":rset.getString("POL_REP_NO") ;
		polStnDtl 		  = rset.getString("POL_STN_ID")==null?"":rset.getString("POL_STN_ID");
		visitDateTime = rset.getString("visit_adm_date_time")==null?"":rset.getString("visit_adm_date_time");
		outMlcNoDtl = rset.getString("MLC_NO_OUTSIDE_DTLS")==null?"":rset.getString("MLC_NO_OUTSIDE_DTLS");
		dateOfMlcCapt = rset.getString("MLC_CAPTURE_DATE")==null?"":rset.getString("MLC_CAPTURE_DATE");
		mlcRem = rset.getString("mlc_remarks")==null?"":rset.getString("mlc_remarks");
		mlcDeathYn = rset.getString("mlc_death_yn")==null?"N":rset.getString("mlc_death_yn");
		mlcRem = escapeHTML(mlcRem);
		outMlcNoDtl = escapeHTML(outMlcNoDtl);
		polRepNo = escapeHTML(polRepNo);
		polStnDtl = escapeHTML(polStnDtl);
		if(mlcDeathYn.equals("Y")){
			checkedMlcDeath = " Checked ";
		}
		/* End GHL-CRF-0650 */
	}
	visitDateTime = visitDateTime.replace(' ','$'); //Added by Ajay Hatwate for GHL-CRF-0650
	if(pstmt!=null){
		pstmt.close();
	}
	if(rset!=null){
		rset.close();
	}
}catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
}
finally{
	if(pstmt!=null){
		pstmt.close();
	}
	if(rset!=null){
		rset.close();
	}
	if(con != null)
	ConnectionManager.returnConnection(con,request);
}
/*
Commented on 6/15/2010 for PE
try 
{
	if (rset!=null) rset.close();
	if (pstmt!=null)pstmt.close();

	String sql1 = "select to_char(sysdate,'dd/mm/yyyy') from dual ";
	pstmt = con.prepareStatement(sql1);
	rset = pstmt.executeQuery();
	while(rset.next())
	{
		sys_date = rset.getString(1);
	}
	if (rset!=null) rset.close();
	if (pstmt!=null)pstmt.close();

}
catch (Exception e)
{
	out.println(e.toString());
}*/

if((mlc_yn.equals("Y"))||(oscc_yn.equals("Y"))){
	readonlyfields_marked = "disabled";
	disabledfields = "disabled";
	disabledfields1 = "";
	readonlyfields_closed = "";
	disable = "";
}
if ( ( (mlc_yn.equals("Y")) || (oscc_yn.equals("Y")) ) &&(!closed_date.equals(""))){
	readonlyfields_marked = "disabled";
	readonlyfields_closed = "disabled";
	disable = "disabled";
	disabledfields = "disabled";
	disabledfields1 = "disabled";
	disabledfield = "disabled";
}
if((mlc_yn.equals("N"))&&(oscc_yn.equals("N"))){ 
	readonlyfields_marked = "disabled";
	readonlyfields_closed = "disabled";
	disable = "disabled";
	disabledfields = "disabled";
	disabledfields1 = "disabled";
	disabledfield = "disabled";
}

if (mlc_yn.equals("Y")){ checked_mlc="checked"; disable_mlc="disabled";disable_oscc="disabled";}
if (oscc_yn.equals("Y")){ checked_oscc="checked"; disable_oscc="disabled";disable_mlc="disabled";}
/*if ((!( marked_by_id.equals("")))&&(!(marked_date.equals(""))))
{
	readonlyfields_marked = "disabled";
	disabledfields = "disabled";
}*/
if(checked_mlc.equals("checked")){
	disMlcFld = "";
}
if (call_from.equals("QUERY_MARK_MLC_OSCC")){
	readonlyfields_marked = "disabled";
	disabledfields = "disabled";
	disabledfield = "disabled";
	disabledfields1 = "disabled";
	readonlyfields_closed = "disabled";
	disable = "disabled";
	disable_mlc="disabled";
	disable_oscc="disabled";
} 

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
if(!isMLCAppl){ 
            _bw.write(_wl_block9Bytes, _wl_block9);
if(siteSpecific){
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mlc_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(checked_mlc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_mlc));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oscc_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(checked_oscc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_oscc));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(marked_by));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(readonlyfields_marked));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(marked_by_id));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(marked_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(readonlyfields_marked));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(marked_date));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(readonlyfields_marked));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(isDateTimeAppl){
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disabledfields));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(closed_by));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(readonlyfields_closed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(closed_by_id));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(closed_date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(readonlyfields_closed));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(closed_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(readonlyfields_closed));
            _bw.write(_wl_block42Bytes, _wl_block42);
if(isDateTimeAppl){
            _bw.write(_wl_block43Bytes, _wl_block43);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disabledfields1));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else if(isMLCAppl){ 
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oscc_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(checked_oscc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_oscc ));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(checked_mlc));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(mlcDeathYn ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disMlcFld ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkedMlcDeath ));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(polRepNo));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disMlcFld ));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(polStnDtl ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disMlcFld ));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(outMlcNoDtl ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disMlcFld ));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(dateOfMlcCapt ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(disMlcFld ));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disMlcFld ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(mlcRem ));
            _bw.write(_wl_block66Bytes, _wl_block66);
} 
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(disabledfield));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(mlc_yn));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(oscc_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(encounter_date));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(isDateTimeAppl));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(isMLCAppl));
            _bw.write(_wl_block80Bytes, _wl_block80);
if(isMLCAppl){ 
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(visitDateTime));
            _bw.write(_wl_block82Bytes, _wl_block82);
} 
            _bw.write(_wl_block83Bytes, _wl_block83);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MarkingofMLCOSCC.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MarkedBy.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MarkedDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ClosedBy.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ClosedDate.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MlcDeath.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceReportNo.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceStationDetails.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OutMlcNoDtls.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateOfMlcCapture.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
