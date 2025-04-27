package jsp_servlet._eor._jsp;

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
import java.util.*;
import java.text.*;
import java.net.*;
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
        if (sci.isResourceStale("/eor/jsp/EncSearchCriteria.jsp", 1743589986520L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\"></link>\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n  <script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n   <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n  <script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n  <script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n  <script language=\'javascript\' src=\"../../eOR/js/EncSearchCriteria.js\"></script>\n  <script language=\'javascript\' src=\"../../eOR/js/EncSearchMain.js\"></script>\n  <Script language=\'javascript\' src=\'../../eMP/js/natAltIDComponentCriteria.js\'></Script>\n<Script src=\"../../eMP/js/SmartCard.js\" language=\"JavaScript\"></Script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n<body OnMouseDown=\'CodeArrest();\' onLoad=\'FocusFirstElement()\' onKeyDown=\'lockKey()\'>\n<form name=\'enc_search_form\' id=\'enc_search_form\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<table id=\'moreCrite1\' border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' height=\'auto\' >\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'  ><span>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span></td>\t\t\t\t\n\t\t\t\t<td class=\'fields\'  width=\'25%\'><span><input type=\'text\' name=\'national_id_no\' id=\'national_id_no\' maxlength=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onKeyPress=\'return ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' size=\'27\' onBlur=\'validateID(this,\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\");\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span></td>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<tr>\t\n\t\t\t\t<td class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t<input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\"\">\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<input type=\'hidden\' name=\'nat_id_accept_alphanumeric_yn\' id=\'nat_id_accept_alphanumeric_yn\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t\t<td class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<input type=\'hidden\' name=\'h_accept_oth_alt_id_yn\' id=\'h_accept_oth_alt_id_yn\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\n\t\t\t\t<td class=\'fields\' width=\'25%\'><select onchange=\'enabledFields(this);\' name=\'other_alt_type\' id=\'other_alt_type\'  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="><option value=\'\'>------";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="------</option>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t</select></td>\n\t\t\t\t<td class=label width=\'25%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'other_alt_Id\' id=\'other_alt_Id\' value=\"\" size=\'27\' maxlength=\'15\' disabled></td>\n\t\t\t\t<input type=\'hidden\' name=\'alert_reqd_yn\' id=\'alert_reqd_yn\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<!-- Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records -->\n\t\t\t\t<input type=\'hidden\' name=\'mr_transaction\' id=\'mr_transaction\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\t\n\t\t\t<!-- Addition Ends -->\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<td  class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t<td  class=\'label\' width=\'25%\' >&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t<!-- Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records -->\n\t\t\t\t<input type=\'hidden\' name=\'mr_transaction\' id=\'mr_transaction\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\t\n\t\t\t<!-- Addition Ends -->\n\t\t\t \t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<td  class=\'label\' width=\'25%\' >&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</TR>\n\t\t\t<TR>\t\t\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<td class=\'label\'   width=\'25%\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t<td  class=\'fields\' width=\'25%\'><input type=\'text\' name=\'alt_id1_no\' id=\'alt_id1_no\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" onKeyPress=\'return CheckForSpeclChars(event)\' size=\'27\' maxlength=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_reqd_yn\' id=\'alt_id1_reqd_yn\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_type\' id=\'alt_id1_type\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"></td>\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_accept_alphanumeric\' id=\'alt_id1_accept_alphanumeric\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="<td  class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t<td  class=\'label\' width=\'25%\' >&nbsp;</td>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t<td  class=\'fields\' width=\'25%\'><input type=\'text\' name=\'alt_id2_no\' id=\'alt_id2_no\' onBlur=\'//validateID(this);\'  size=\'27\' maxlength=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id2_reqd_yn\' id=\'alt_id2_reqd_yn\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id2_type\' id=\'alt_id2_type\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="<td  class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t\t<td  class=\'label\'  width=\'25%\'>&nbsp;</td>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t</tr>\n\t\t\t<tr>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\n\t\t\t\t<td  class=\'fields\'  width=\'25%\'><input type=\'text\' name=\'alt_id3_no\' id=\'alt_id3_no\' onBlur=\'//validateID(this);\' size=\'27\' maxlength=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id3_reqd_yn\' id=\'alt_id3_reqd_yn\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id3_type\' id=\'alt_id3_type\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t\t<td  class=\'fields\'  width=\'25%\' ><input type=\'text\' name=\'alt_id4_no\' id=\'alt_id4_no\' onBlur=\'//validateID(this);\' size=\'27\' maxlength=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id4_reqd_yn\' id=\'alt_id4_reqd_yn\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id4_type\' id=\'alt_id4_type\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="<td  class=\'label\' width=\'25%\' >&nbsp;</td>\n\t\t\t\t\t<td  class=\'label\' width=\'25%\'>&nbsp;</td>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\t\t\t\n\t<tr>\n\t\t\t\t<td width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\'  name=\'PatientId\' id=\'PatientId\' size=\"20\" maxlength=\"65\" onKeypress=\'return CheckForSpecChars(event);\' align=\"center\"><input type=\'button\' name=\'patient_id\' id=\'patient_id\' value=\'?\' class=\'button\' onclick=\'callSearchScreen()\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'encTypePatID\' style=\"visibility:hidden\"></img>\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t\t<td class=\"fields\" width=\"25%\"><input type=text  name=\'p_encounter_id\' id=\'p_encounter_id\' size=\"12\" maxlength=\"12\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNumVal(this);EncTypeMand(this);\"></td>\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t<td class=\"fields\" width=\"25%\"><input type=\"text\" name=\"alt_id1_exp_date\" id=\"alt_id1_exp_date\"  style=\"width:60px\" maxlength=\'10\' id=\'altidexpdt1\'  onblur=\"validDateObj(this,\'DMY\',\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\');ComparePeriodFromToTime(this,alt_id2_exp_date);\" onkeypress=\"return Valid_DT(event)\"></input><img src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"document.forms[0].alt_id1_exp_date.focus();return showCalendar(\'altidexpdt1\');\">-<input type=\"text\" name=\"alt_id2_exp_date\" id=\"alt_id2_exp_date\"  maxlength=\'10\' id=\'altidexpdate2\' style=\"width:60px\" onblur=\"validDateObj(this,\'DMY\',\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\');ComparePeriodFromToTime(alt_id1_exp_date,this);\" onkeypress=\"return Valid_DT(event)\" ></input><img src=\'../../eCommon/images/CommonCalendar.gif\'   onClick=\"document.forms[0].alt_id2_exp_date.focus();return showCalendar(\'altidexpdate2\');\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'encDate_img\' style=\"visibility:hidden\"></img></td>\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t<script>\n\t\t\t\tdocument.forms[0].patID_img.style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].alt_id1_exp_date.value = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\t\t\tdocument.forms[0].alt_id2_exp_date.value = \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\t\t\t</script>\n\t\n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\t\t\n\t\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t<td  class=\"fields\">\n\t\t\t\t<select name=\"lstPatientClass\" id=\"lstPatientClass\" onChange=\"chkMandPatient(this);\">\n\t\t\t\t<option>---";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="---</option>\n\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'encType_img\' name=\'encType_img\' style=\"visibility:hidden\"></img></td>\n\n\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t<td width=\'25%\' class=\'label\'></td>\t\t\t\n\t\t\t\t<td width=\'25%\' class=\'label\'></td>\t\n\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n</tr>\n\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\"><input name=\'p_discharge_date_from\' id=\'p_discharge_date_from\'  onblur=\"validDateObj(this,\'DMY\',\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\');ComparePeriodFromToTime(this,p_discharge_date_to);DscdPeriodChk(this);\" value=\'\' size=\'10\' maxlength=\'10\' onkeypress=\"return Valid_DT(event)\"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].p_discharge_date_from.focus();return showCalendar(\'p_discharge_date_from\',\'dd/mm/y\',null );\" ></input>-<input name=\'p_discharge_date_to\' id=\'p_discharge_date_to\'  value=\'\' size=\'10\' maxlength=\'10\' onblur=\"validDateObj(this,\'DMY\',\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\');ComparePeriodFromToTime(p_discharge_date_from,this);DscdPeriodChk(this);\" onkeypress=\"return Valid_DT(event)\"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'p_discharge_date_to\',\'dd/mm/y\',null );\"></input></td>\n\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\"><input name=\'p_discharge_date_from\' id=\'p_discharge_date_from\'  value=\'\' size=\"10\" maxlength=\'10\' onkeypress=\"return Valid_DT(event)\" onblur=\'validDateObj(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\");CompareDisPeriodFromToTime(this,p_discharge_date_to);disChargePeriodChk(this);\'><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'p_discharge_date_from\',null,\'hh:mm\' );\"></input><input name=\'p_discharge_date_to\' id=\'p_discharge_date_to\' id=\'p_discharge_date_to\' value=\'\' size=\"10\" maxlength=\'10\' onblur=\"validDateObj(this,\'DMYHM\',\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\');CompareDisPeriodFromToTime(p_discharge_date_from,this);disChargePeriodChk(this);\'\" onkeypress=\"return Valid_DT(event)\"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'p_discharge_date_to\',null,\'hh:mm\' );\"></input><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'DischDate_img\' style=\"visibility:hidden\"></img></td>\n\n\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\n\t\t<script>\n\t\t\tdocument.forms[0].p_discharge_date_to.value = \"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\t\tdocument.forms[0].p_discharge_date_from.value = \"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\";\n\t\t\tdocument.forms[0].patID_img.style.visibility = \"hidden\";\n\t\t    document.forms[0].encDate_img.style.visibility = \"hidden\";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t<td width=\"25%\"  class=\'label\'>&nbsp;</td>\t\t\t\n\t\t<td width=\"25%\"   class=\'label\'>&nbsp;</td>\t\t\n\t\t<td width=\"25%\"   class=\'label\'>&nbsp;</td>\t\t\n\t\t<td width=\"25%\"   class=\'label\'>&nbsp;</td>\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t<tr>\n\t\t<td class=\"label\" width=\"25%\" nowrap>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\t\t<td nowrap width=\"25%\" ><select name=\"orderBy\" id=\"orderBy\"><option>---";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="---</option>\n\t\t\t<option value=\"ED\" selected>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</option>\n\t\t\t<option value=\"ET\">";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</option>\n\t\t\t</select>\t\t\n\t\t</td>\n\t\t<td class=\"label\" width=\"25%\"></td>\n\t\t<td class=\"label\" width=\"25%\"></td>\n\t</tr>\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t<td width=\"25%\" class=\'label\' colspan=\'1\'>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\t\t\t\t<td width=\"25%\"  class=\'fields\' colspan=\'1\'><input type=\"checkbox\" name=\"discharge_val\" id=\"discharge_val\" onclick=\"callcheck_val();\"></td>\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t<td width=\"25%\" colspan=\'1\'></td>\n\t\t\t\t<td  width=\"25%\" colspan=\'1\'></td>\n\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t<td width=\"25%\" class=\'label\' colspan=\'1\'></td>\n\t\t\t<td width=\"25%\" class=\'button\' colspan=3 nowrap><input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' class=\'button\' onclick=\'submitPage()\'><input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' class=\'button\' onclick=\'clearAll()\'></td>\n\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t<img src=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' width=\'100%\' height=\'15\'/> \n\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n     </div>\n\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" >\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" >\n\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" >\t\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" >\n\t<input type=\'hidden\' name=\'operstn\' id=\'operstn\' value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" >\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" >\n\t<input type=\'hidden\' name=\'SystemDate\' id=\'SystemDate\' value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" >\n\t<input type=\'hidden\' name=\'qerString\' id=\'qerString\' value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" >\n\n     <input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'MRBIPFFPRC\'></input>\n     <input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'MR\'></input>\n     <input type= \'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'></input>\n     <input type=\'hidden\' name=\'p_user_name\' id=\'p_user_name\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'></input>\n     <input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'\'></input>\n\t <input type=\'hidden\' name=\'cnsnt_with_order_yn\' id=\'cnsnt_with_order_yn\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'></input>  <!-- IN057196 -->\n\n\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t<script>\n\t\t\t document.getElementById(\'encType_img\').style.visibility = \'visible\';\n\t\t\t document.forms[0].encDate_img.style.visibility = \'visible\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t<script>\n\t\t\t document.forms[0].DischDate_img.style.visibility = \'visible\';\n\t\t\t document.getElementById(\'encType_img\').style.visibility = \'visible\';\n\t\t</script>\n\t\t \n\t ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t<script>\n\t\t\t\t document.getElementById(\'encType_img\').style.visibility = \'visible\';\n\t\t\t</script>\n\t\t \n\t ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n  </form>\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

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

/*
-----------------------------------------------------------------------
Date       		Edit History      Name        		Description
-----------------------------------------------------------------------
?             	100            		?           		created
21/10/2015		IN057196		Ramesh G		Recording Of Consent Form
-----------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String p_user_name		= (String) session.getValue( "login_user" ) ;
  String locale           = (String) session.getAttribute("LOCALE");
  String cnsnt_with_order_yn=request.getParameter("cnsnt_with_order_yn")==null?"N":request.getParameter("cnsnt_with_order_yn"); //IN057196
  Connection con = ConnectionManager.getConnection(request);
  Statement stmt = null;
  PreparedStatement pstmt	= null;
  ResultSet rs			= null ;


	String sql							= "";
	String alt_id1_reqd_yn				= "";
	String alt_id2_reqd_yn				= "";
	String alt_id3_reqd_yn				= "";
	String alt_id4_reqd_yn				= "";
	String alt_id1_type					= "";
	String alt_id2_type					= "";
	String alt_id3_type					= "";
	String alt_id4_type					= "";
	String alt_id1_length				= "";
	String alt_id2_length				= "";
	String alt_id3_length				= "";
	String alt_id4_length				= "";
	String nat_id_length				= "";
	String alt_id1_exp_date_accept_yn	= "";
	String alt_id2_exp_date_accept_yn	= "";
	String alt_id3_exp_date_accept_yn	= "";
	String alt_id4_exp_date_accept_yn	= "";
	String accept_national_id_no_yn		= "";
	String nat_id_accept_alphanumeric_yn= "";
	String nat_id_prompt				= "";
	String alt_id1_desc					= "";
	String alt_id2_desc					= "";
	String alt_id3_desc					= "";
	String alt_id4_desc					= "";
	String alt_id1_no					= "";
	String alt_id2_no					= "";
	String alt_id3_no					= "";
	String alt_id4_no					= "";
	String national_id_no				= "";
	String alt_id1_exp_date				= "";
	String alt_id2_exp_date				= "";
	String alt_id3_exp_date				= "";
	String alt_id4_exp_date				= "";
	String disabledFields				= "";
	String Accept_oth_alt_id_yn			= "";
	String nat_id_check_digit_id = "";
	String nat_data_source_id = "";
	String ext_system_interface_yn = "";
	String nat_id_onKeyPress = "";
	String alt_id1_accept_alphanumeric_yn = "";
	
	String patient_id		= request.getParameter("patient_id");
	String alert_reqd_yn	= request.getParameter("alert_reqd_yn");
    String hidetbl	= request.getParameter("hidetbl")==null?"":request.getParameter("hidetbl"); 
	String validateIDFn = "";
    String validateIdYN	= request.getParameter("validateIdYN")==null?"Y":request.getParameter("validateIdYN"); 

	if(validateIdYN.equals("Y")) {
		validateIDFn = "onBlur='validateID(this);'";
	} else {
		validateIDFn = "";
	}

	//Added for disabling fields as per parameter obtained from OP

	String nat_id_disabled = request.getParameter("nat_id_disabled");
	if(nat_id_disabled == null) nat_id_disabled = "N";
	
	if(alert_reqd_yn == null) alert_reqd_yn = "N";
    if (patient_id==null || patient_id.equals("") || patient_id == "") patient_id = "";	
	if(nat_id_disabled.equals("N")) disabledFields = "";

	//Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records

	String mr_transaction = request.getParameter("mr_transaction") == null ? "N" : request.getParameter("mr_transaction");	

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

		
	try
	{
		if(!patient_id.equals(""))
		{
			disabledFields = "disabled";
			
			sql = "SELECT alt_id1_no, alt_id2_no, alt_id3_no, alt_id4_no, to_char(alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date, to_char(alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date, to_char(alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date, to_char(alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date, national_id_no FROM mp_patient WHERE patient_id = '"+patient_id+"' ";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			if (rs!= null&&rs.next())
			{
			
				alt_id1_no = rs.getString("alt_id1_no");
				alt_id2_no = rs.getString("alt_id2_no");
				alt_id3_no = rs.getString("alt_id3_no");
				alt_id4_no = rs.getString("alt_id4_no");
				national_id_no = rs.getString("national_id_no");
				alt_id1_exp_date = rs.getString("alt_id1_exp_date");
				alt_id2_exp_date = rs.getString("alt_id2_exp_date");
				alt_id3_exp_date = rs.getString("alt_id3_exp_date");
				alt_id4_exp_date = rs.getString("alt_id4_exp_date");
			}
			if(alt_id1_no==null) alt_id1_no = "";
			if(alt_id2_no==null) alt_id2_no = "";
			if(alt_id3_no==null) alt_id3_no = "";
			if(alt_id4_no==null) alt_id4_no = "";
			if(national_id_no==null) national_id_no = "";
			if(alt_id1_exp_date==null) alt_id1_exp_date = "";
			if(alt_id2_exp_date==null) alt_id2_exp_date = "";
			if(alt_id3_exp_date==null) alt_id3_exp_date = "";
			if(alt_id4_exp_date==null) alt_id4_exp_date = "";
		}
		
		//sql = " SELECT nvl(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, nvl(Alt_Id2_reqd_yn,'N')Alt_Id2_reqd_yn, nvl(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, nvl(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn, Alt_Id1_type,substr(alt_id1.short_desc,1,15) alt_id1_desc, Alt_Id2_type, substr(alt_id2.short_desc,1,15) alt_id2_desc, Alt_Id3_type,substr(alt_id3.short_desc,1,15) alt_id3_desc, Alt_Id4_type, substr(alt_id4.short_desc,1,15) alt_id4_desc, nvl(Alt_Id1_length,0) Alt_Id1_length, nvl(Alt_Id2_length,0) Alt_Id2_length, nvl(Alt_Id3_length,0) Alt_Id3_length, nvl(Alt_Id4_length,0) Alt_Id4_length, nat_id_length, Accept_oth_alt_id_yn, alt_id1_exp_date_accept_yn, alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn, alt_id4_exp_date_accept_yn, accept_national_id_no_yn, nvl(nat_id_prompt,'National ID No') nat_id_prompt FROM mp_param, mp_alternate_id_type_lang_vw  alt_id1, mp_alternate_id_type_lang_vw  alt_id2, mp_alternate_id_type_lang_vw alt_id3, mp_alternate_id_type_lang_vw  alt_id4 WHERE alt_id1_type = alt_id1.alt_id_type AND alt_id2_type = alt_id2.alt_id_type(+) AND alt_id3_type = alt_id3.alt_id_type(+) AND alt_id4_type = alt_id4.alt_id_type(+) and alt_id1.language_id='"+locale+"' and alt_id2.language_id='"+locale+"' and alt_id3.language_id='"+locale+"' and  alt_id4.language_id='"+locale+"'";
		sql = "SELECT NVL(alt_id1_reqd_yn,'N') alt_id1_reqd_yn,"+
				 "        NVL(alt_id2_reqd_yn,'N') alt_id2_reqd_yn,"+
				 "        NVL(alt_id3_reqd_yn,'N') alt_id3_reqd_yn,"+
				 "        NVL(alt_id4_reqd_yn,'N') alt_id4_reqd_yn,"+
				 "        alt_id1_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id1_desc,"+
				 "        alt_id2_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1') alt_id2_desc,"+
				 "        alt_id3_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1') alt_id3_desc,"+
				 "        alt_id4_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1') alt_id4_desc,"+
				 "        NVL(alt_id1_length,0) alt_id1_length,"+
				 "        NVL(alt_id2_length,0) alt_id2_length,"+
				 "        NVL(alt_id3_length,0) alt_id3_length,"+
				 "        NVL(alt_id4_length,0) alt_id4_length,"+
				 "        nat_id_length,"+
				 "        accept_oth_alt_id_yn,"+
				 "        alt_id1_exp_date_accept_yn,"+
				 "        alt_id2_exp_date_accept_yn,"+
				 "        alt_id3_exp_date_accept_yn,"+
				 "        alt_id4_exp_date_accept_yn,"+
				 "        accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_alphanumeric_yn,"+
				 "        NVL(nat_id_prompt,'National ID No') nat_id_prompt,"+
				 "        nat_id_check_digit_id,nat_data_source_id,ext_system_interface_yn"+
				 " FROM   mp_param_lang_vw"+
				 " WHERE  module_id = 'MP' and language_id='"+localeName+"'";

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if(rs != null)
		{
			while(rs.next())
			{
				alt_id1_reqd_yn				= rs.getString("Alt_Id1_reqd_yn");
				alt_id2_reqd_yn				= rs.getString("Alt_Id2_reqd_yn");
				alt_id3_reqd_yn				= rs.getString("Alt_Id3_reqd_yn");
				alt_id4_reqd_yn				= rs.getString("Alt_Id4_reqd_yn");
				alt_id1_type				= rs.getString("Alt_Id1_type");
				alt_id2_type				= rs.getString("Alt_Id2_type");
				alt_id3_type				= rs.getString("Alt_Id3_type");
				alt_id4_type				= rs.getString("Alt_Id4_type");
				alt_id1_length				= rs.getString("Alt_Id1_length");
				alt_id2_length				= rs.getString("Alt_Id2_length");
				alt_id3_length				= rs.getString("Alt_Id3_length");
				alt_id4_length				= rs.getString("Alt_Id4_length");
				nat_id_length				= rs.getString("nat_id_length");
				alt_id1_exp_date_accept_yn	= rs.getString("alt_id1_exp_date_accept_yn");
				alt_id2_exp_date_accept_yn	= rs.getString("alt_id2_exp_date_accept_yn");
				alt_id3_exp_date_accept_yn	= rs.getString("alt_id3_exp_date_accept_yn");
				alt_id4_exp_date_accept_yn	= rs.getString("alt_id4_exp_date_accept_yn");
				accept_national_id_no_yn	= rs.getString("accept_national_id_no_yn");
				nat_id_accept_alphanumeric_yn	= rs.getString("nat_id_accept_alphanumeric_yn");
				nat_id_prompt 				= rs.getString("nat_id_prompt");
				nat_id_check_digit_id		= rs.getString("nat_id_check_digit_id")==null?"":rs.getString("nat_id_check_digit_id");
				nat_data_source_id		= rs.getString("nat_data_source_id")==null?"":rs.getString("nat_data_source_id");
				ext_system_interface_yn		= rs.getString("ext_system_interface_yn")==null?"":rs.getString("ext_system_interface_yn");
				alt_id1_desc 				= rs.getString("alt_id1_desc");
				alt_id2_desc 				= rs.getString("alt_id2_desc");
				alt_id3_desc 				= rs.getString("alt_id3_desc");
				alt_id4_desc 				= rs.getString("alt_id4_desc");
				Accept_oth_alt_id_yn 		= rs.getString("Accept_oth_alt_id_yn");
				alt_id1_accept_alphanumeric_yn 		= rs.getString("alt_id1_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id1_accept_alphanumeric_yn");
				
			}
		}

		if(alt_id1_exp_date_accept_yn == null) alt_id1_exp_date_accept_yn = "N";
		if(alt_id2_exp_date_accept_yn == null) alt_id2_exp_date_accept_yn = "N";
		if(alt_id3_exp_date_accept_yn == null) alt_id3_exp_date_accept_yn = "N";
		if(alt_id4_exp_date_accept_yn == null) alt_id4_exp_date_accept_yn = "N";
		if(accept_national_id_no_yn == null) accept_national_id_no_yn = "N";
		if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn = "N";
		if(Accept_oth_alt_id_yn == null) Accept_oth_alt_id_yn = "N";
		if(alt_id1_reqd_yn == null) alt_id1_reqd_yn = "N";
		if(alt_id2_reqd_yn == null) alt_id2_reqd_yn = "N";
		if(alt_id3_reqd_yn == null) alt_id3_reqd_yn = "N";
		if(alt_id4_reqd_yn == null) alt_id4_reqd_yn = "N";
		if(alt_id1_length == null) alt_id1_length = "0";
		if(alt_id2_length == null) alt_id2_length = "0";
		if(alt_id3_length == null) alt_id3_length = "0";
		if(alt_id4_length == null) alt_id4_length = "0";
		if(nat_id_length == null) nat_id_length = "0";
		if(nat_id_prompt == null) nat_id_prompt = "";
		if(nat_id_check_digit_id == null) nat_id_check_digit_id = "";
		if(alt_id1_type == null) alt_id1_type = "";
		if(alt_id2_type == null) alt_id2_type = "";
		if(alt_id3_type == null) alt_id3_type = "";
		if(alt_id4_type == null) alt_id4_type = "";
		if(alt_id1_desc == null) alt_id1_desc = "";
		if(alt_id2_desc == null) alt_id2_desc = "";
		if(alt_id3_desc == null) alt_id3_desc = "";
		if(alt_id4_desc == null) alt_id4_desc = "";
		
		
		if(hidetbl.equals("Y"))
		{
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
		if(accept_national_id_no_yn.equals("Y"))
			{
				/*
				if ( nat_id_check_digit_id.equals("M11") )
					nat_id_onKeyPress = " return CheckForCharsNatID(event);";
				else
					nat_id_onKeyPress = "return allowValidNumber(this,event,2, 0);";
				*/
				
				 if(nat_id_accept_alphanumeric_yn.equals("Y"))
				 {
					nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
				 }
				 else
				 {
					if(nat_id_check_digit_id.equals("M11"))
						nat_id_onKeyPress = "CheckForCharsNatID(event);";
					else
						nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
				 }
				 String interface_btn = "";
				 if(ext_system_interface_yn.equals("Y") && nat_id_check_digit_id.equals("") && nat_data_source_id.equals("NRIC")) {
					 interface_btn = "<input type='button' value='M' class= 'button' name='myKadBtn' id='myKadBtn' onClick=\"ReadDF2_onclick('CC','NC');\">";
				 } else {
					 interface_btn = "";
				 }
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( nat_id_length ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nat_id_check_digit_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(interface_btn));
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			else
			{
				
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
			
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nat_id_accept_alphanumeric_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Accept_oth_alt_id_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);

			if(Accept_oth_alt_id_yn.equals("Y"))
			{
				
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

				sql = "SELECT alt_id_type,long_desc FROM mp_alternate_id_type_lang_vw   WHERE alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM) and EFF_STATUS='E' and language_id='"+locale+"' ORDER BY SHORT_DESC";
			
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();	
		
				if(rs != null)
				{
					while(rs.next())
					{
						
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rs.getString("alt_id_type")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rs.getString("long_desc")));
            _bw.write(_wl_block30Bytes, _wl_block30);

					}
				}
				
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(alert_reqd_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mr_transaction));
            _bw.write(_wl_block34Bytes, _wl_block34);

			}
			else if(!Accept_oth_alt_id_yn.equals("Y") && mr_transaction.equals("Y"))
			{
				
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mr_transaction));
            _bw.write(_wl_block36Bytes, _wl_block36);

			}
			else 
			{
				
            _bw.write(_wl_block37Bytes, _wl_block37);

			} 
			
            _bw.write(_wl_block38Bytes, _wl_block38);

			if(!alt_id1_type.equals(""))
			{
				
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(alt_id1_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(validateIDFn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(alt_id1_reqd_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);

			}
			else
			{
				
            _bw.write(_wl_block48Bytes, _wl_block48);

			}
			
			if(!alt_id2_type.equals(""))
			{
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(alt_id2_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(alt_id2_length));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(alt_id2_reqd_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(alt_id2_type));
            _bw.write(_wl_block52Bytes, _wl_block52);

			}
			else
			{
				
            _bw.write(_wl_block53Bytes, _wl_block53);

			}
			
            _bw.write(_wl_block54Bytes, _wl_block54);

			if(!alt_id3_type.equals(""))
			{
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(alt_id3_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(alt_id3_length));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(alt_id3_reqd_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(alt_id3_type));
            _bw.write(_wl_block52Bytes, _wl_block52);

			}
			else
			{
				
            _bw.write(_wl_block53Bytes, _wl_block53);

			}
		
			if(!alt_id4_type.equals(""))
			{
				
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(alt_id4_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(alt_id4_reqd_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(alt_id4_type));
            _bw.write(_wl_block47Bytes, _wl_block47);

			}
			else
			{
				
            _bw.write(_wl_block62Bytes, _wl_block62);

			}
			
            _bw.write(_wl_block63Bytes, _wl_block63);

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e) 
	{ 
		//out.println(e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block69Bytes, _wl_block69);
	
	
	if( call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL"))
		{	
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block72Bytes, _wl_block72);

		}	
		
	
            _bw.write(_wl_block73Bytes, _wl_block73);
	
	if(!call_function.equals("QUERY_MATERNAL_REPORT")) 
	{	
	
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
	
					if(rs != null) rs.close();
										
					rs = stmt.executeQuery("select patient_class, short_desc from am_patient_class_lang_vw where language_id='"+locale+"' order by 1");
					

					if(rs != null)
					{									
						while (rs.next())
						{	
						
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(rs.getString("patient_class")));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block30Bytes, _wl_block30);

						}
					}	
					if(rs!=null) rs.close();
					
					
            _bw.write(_wl_block79Bytes, _wl_block79);
 
	}
	else 
	{ 
	
            _bw.write(_wl_block80Bytes, _wl_block80);
 
	} 

            _bw.write(_wl_block81Bytes, _wl_block81);
 if(call_function.equals("QUERY_MATERNAL_REPORT")||call_function.equals("DIAG_RECODE") || call_function.equals("MR_VIEW_DTH_REG"))
{

            _bw.write(_wl_block82Bytes, _wl_block82);
 
	  if (call_function.equals("MR_VIEW_DTH_REG"))
		{
	
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block86Bytes, _wl_block86);

		} 
		else 
		{
	
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block90Bytes, _wl_block90);
 
	} 
	if(call_function.equals("DIAG_RECODE"))
	{
	
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block93Bytes, _wl_block93);

	}
	
            _bw.write(_wl_block94Bytes, _wl_block94);
 } 
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

			if(call_function.equals("MR_REC_PAT_VAL"))
			{
		
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

			}
			else 
			{
			
            _bw.write(_wl_block102Bytes, _wl_block102);

			}
			
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block105Bytes, _wl_block105);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block107Bytes, _wl_block107);
}
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(module));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(cnsnt_with_order_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
	
	if(call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL") )
	{	
	
            _bw.write(_wl_block128Bytes, _wl_block128);

	}
	if(call_function.equals("DIAG_RECODE"))
	{
	
            _bw.write(_wl_block129Bytes, _wl_block129);

	}
	 if(call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
	{
	
            _bw.write(_wl_block130Bytes, _wl_block130);

	 }
     } catch(Exception e) {
          //out.println(e.toString());//COMMON-ICN-0181
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
          e.printStackTrace();//COMMON-ICN-0181
     }
     finally {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  ConnectionManager.returnConnection(con,request);
     }

            _bw.write(_wl_block131Bytes, _wl_block131);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EncPeriod.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeceasedPeriod.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DischPeriod.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.discharged.label", java.lang.String .class,"key"));
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
}
