package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyamentinpatientleave extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addModifyAmentInpatientLeave.jsp", 1727969298724L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n    <head>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\"../js/AmendInpatientLeave.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    \n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</head>\n\n    <body onLoad=\'document.forms[0].trans_type.focus();dispAmendDetail()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n        <form name=\"AmendInpatientLeave_form\" id=\"AmendInpatientLeave_form\" method=post action=\'../../servlet/eIP.IPAmendIPLeaveServlet\' target=\'dummy\'>\n        <input type=\"hidden\" name=leave_fr_date id=leave_fr_date value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n        <input type=\"hidden\" name=leave_to_date id=leave_to_date value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n        <input type=\"hidden\" name=hddPseudobed id=hddPseudobed value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<table cellpadding=0 cellspacing=0 align=center width=\"100%\" border=0>\n\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\' id=\'leave_dtls_th\'><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></td>\n\t</tr>\n\t<tr><td colspan=\'4\' class=\'label\'></td></tr>\n\t<tr><td colspan=\'4\' class=\'label\'></td></tr>\n\t<tr><td colspan=\'4\' class=\'label\'></td></tr>\n\n      <tr>\n           <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n            <td width=\'30%\' class=\'fileds\'>\n                        <select name=\'trans_type\' id=\'trans_type\' onchange = \"validateTransType(this);populateAmenddtls(this)\">\n                            <option value = \'2\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n                            ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n                            <option value = \'3\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n                            <option value = \'1\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n                            ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n                            <option value = \'9\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n                        </select>\n              </td>\n            <td  class=\'label\' nowrap width=\'20%\'></td>\n            <td  class=\'querydata\' nowrap width=\'25%\'></td>\n       </tr>\n\t\t<tr><td colspan=\'4\' class=\'label\' height=\'6\'></td></tr>\n        <tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </td>\n\t\t\t<td class=\'querydata\'> ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n            <td class=\'label\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n            <td nowrap class=\'querydata\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n                    \n        </tr>\t\t\n\t\t<tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n                    ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n                    <td class=\'fileds\'><input type=\"checkbox\" name=\"release_bed\" id=\"release_bed\" value=\"Y\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" onClick=\"validatePseudoBed(this)\" disabled></td>\n                    <td class=\'label\' nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n                    <td class=\'fileds\'>\n                    <input type=\"text\" name=\"pseudo_bed\" id=\"pseudo_bed\" size=6 maxlength=8 readonly value=\"\"><input type=\'button\' value=\'?\' onclick =\'searchPseudoBed()\' class=\'button\' name=\'PseudoBed_chart\' id=\'PseudoBed_chart\' disabled><img id=\"pseudoImg\" src=\'../../eCommon/images/mandatory.gif\' ></img></td> \n\t\t</tr>\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  id=\'leave_period_lgd\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t<td  class=\'querydata\' id=\'from_date1\' colspan=\'2\'><input type=\'hidden\'  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" name=\'from_date\'>\n\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" name=\'to_date\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'querydata\' id=\'to_date1\'></td>\n\t\t\t</tr>\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' id=\'leave_remarks_lgd\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t<td colspan=\'3\' class=\'fileds\'><textarea rows=\'3\' cols=\'60\' style = \"resize: none;\" name=\'leave_remarks\' onBlur=\'makeValidString(this)\' >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</textarea></td>\n            </tr>\n\t\t\t\n\t\t\t<tr><td colspan=\'4\' class=\'label\'></td></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\' ><b>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</b></td>\n\t       </tr>\n\n\t\t\t<tr>\n\t\t\t<td height=\'2\'> </td>\n\t\t\t<td height=\'2\'> </td>\n\t\t\t<td height=\'2\'> </td>\n\t\t\t<td height=\'2\'> </td>\t\t\t\n\t\t\t</tr>\n\t\t   <tr>\n\t\t\t\t <td class=\'label\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t<td class=\'querydata\'  >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t<td class=\'querydata\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t<td height=\'2\'> </td>\n\t\t\t<td height=\'2\'> </td>\n\t\t\t<td height=\'2\'> </td>\n\t\t\t<td height=\'2\'> </td>\t\t\t\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr><td colspan=\'4\' class=\'label\'></td></tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\' ><b>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</b></td>\n\t       </tr>\n\n\t\t\t<tr><td colspan=\'4\' class=\'label\'></td></tr>\n\t\t\t<tr><td colspan=\'4\' class=\'label\'></td></tr>\n\t\t\t<tr><td colspan=\'4\' class=\'label\'></td></tr>\n\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'   >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t<td  class=\'fileds\'>\n\t\t\t\t<input type=text value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" readonly name=\"nursing_unit_desc\" maxlength=15 size=15 ><input type=button class=button name=nursing_unit_lookup value=\'?\' onClick=\"NursingUnitLookup(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\')\">\n\t\t\t\t<input type=\"hidden\" name=\"nursing_unit\" id=\"nursing_unit\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"><img id = \"gifpop3\" src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t\t\t<td class=\'label\' ></td>\n\t\t\t\t<td class=\'label\'></td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t</tr>\n\n\t\t\t<tr><td colspan=\'4\' class=\'label\' height=\'6\'></td></tr>\n\n\t<tr> \n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t<td class=\'fileds\'><input type=\'text\' name=\"bed_no\" id=\"bed_no\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" size=\'8\' maxlength=\'8\' onBlur=\'ChangeUpperCase(this);validate_Bed_No();checkbed();\' readOnly onKeyPress=\'return CheckForSpecChars(event)\' ><input type=\'button\' value=\'?\' onclick =\'searchBed()\' class=\'button\' name=\'bed_chart\' id=\'bed_chart\' disabled> </td>\n\t\t\t<td colspan=\'1\' align=\'right\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t<td class=\'fileds\'><input type=\'text\' name=\'disp_room_no\' id=\'disp_room_no\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" readOnly size=10 maxlength=10> </td>\n\t\t\t\n\t</tr>\n\t\t\t<tr><td colspan=\'4\' class=\'label\' height=\'6\'></td></tr>\n\t\t\t<tr><td colspan=\'4\' class=\'label\'></td></tr>\n\t\t\t<tr><td colspan=\'4\' class=\'label\'></td></tr>\n\t\t\t<tr><td colspan=\'4\' class=\'label\'></td></tr> \n\t<tr>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t<td >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<img id =\"gifpop4\"  src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t<td class=\'fileds\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t</tr>\n\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\' id=\'amend_dtl\'></td>\n\t    </tr>\t\t\t\t\n\t<!-- CODED BY SRIDHAR ON 16 FEB 2004 -->\t\t\t\t    \n\t<!-- ADDITION FOR ABSCONDING STATUS & ABSCONDING DATE & TIME --> \n\t<TR>\n\t<TD colspan=\"4\" class=\"LABEL\">&nbsp;\n\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t</td>\n\t</tr>\n\t<tr><td colspan=\'4\' class=\'label\' height=\'6\'></td></tr>\n\t<tr><td colspan=\'4\' class=\'label\'></td></tr> \n\n\n\t<tr>\n\t\t<td class=\'label\' id=\'trans_remarks_lgd\' >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t<td colspan=\'3\' class=\'fileds\'><textarea  rows=\'2\' cols=\'60\' name=\'amend_remarks\' id=\'amend_remarks\' style = \"resize: none;\" onBlur=\'checkMaxLimit1(this,500);makeValidString(this)\' onKeyPress = \'chklim(this,500)\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</textarea></td>\n\t</tr>\n\n\t<tr><td colspan=\'4\' class=\'label\' height=\'6\'></td></tr>\n\t<tr>\n\t\t<td class=\'label\' id=\'date_time_lgd\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td><td colspan=3 class=\'fileds\'><input type=\"text\" name=\"returned_date_time\" id= \"returned_date_time\" size=16 maxlength=16 readonly onBlur=\"validateDate(\'R\',this)\" ><img name=\'redt\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].returned_date_time.select();return showCalendar(\'returned_date_time\',null,\'hh:mm\');\"><img id = \"gifpop1\" src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t</tr>\n\t\n\t\t<tr>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\' id=\'oth_details\'><b>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</b></td></tr>\n\t    </tr>\n\t\t<TR>\n\t\t<TD colspan=\"4\" class=\'fileds\'>\n\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="            \n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="   \n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="                                                      \n\t</td>\n\t</tr>\n\t\t<TR>\n\t<TD colspan=\"4\" class=\'fileds\'>\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t</td>\n\t</tr> \n\t<tr><td height=2 colspan=4></td></tr>\n\t<tr>\n\t\t<td> </td>\n\t\t<td> </td>\n\t\t<td> </td>\n\t\t<td class=\'fileds\'><input type=\'button\' name =\'record\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' class=\'button\' onclick=\'apply()\'>\n\t\t<input type=\'button\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' class=\'button\' onclick=\'const dialogTag = parent.parent.document.getElementById(\"dialog_tag\"); dialogTag.close();\'>\n\t\t</td>\n\t</tr>\n\t</table>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" name=\'patient_class\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" name=\'sStyle\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" name=\'srl_no\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" name=\'encounter_id\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" name=\'patient_id\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" name=\'release_bed_yn\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" name=\'max_allowed_lv_period\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" name = \'warn_or_error_max_leave\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" name=\'old_release_bed_yn\'>\n\t\t<!-- modified by senthil on 18th Dec 2003 -->\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" name=\'old_nursing_unit_code\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" name=\'old_room_no\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" name=\'old_bed_no\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" name=\'old_bed_class_code\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" name=\'old_bed_type_code\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" name=\'old_to_daily_rate\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" name=\'old_practitioner_id\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" name=\'old_speciality_code\'>  \n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" name=\'fr_service_code\'>  \n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" name=\'trn_type\'> \n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" name=\'trn_code\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" name=\'sys_date\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" name=\'def_leave_to_date\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" name=\'trn_date_time\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" name=\'admdate\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" name=\'to_service_code\'>\n\t\t<input type=\'hidden\' value=\"\" name=\'bed_cls_code\' id=\'bed_cls_code\'>\n\t\t<input type=\'hidden\' value=\"\" name=\'bed_typ_code\' id=\'bed_typ_code\'> \n\t\t<input type=\'hidden\' value=\"\" name=\'practitioner_id\' id=\'practitioner_id\'>\n\t\t<input type=\'hidden\' value=\"\" name=\'speciality_code\' id=\'speciality_code\'>\n\t\t<input type=\'hidden\' value=\"\" name=\'nursing_unit_code\' id=\'nursing_unit_code\'>\n\t\t<input type=\'hidden\' value=\"\" name=\'room_no\' id=\'room_no\'>\n\t\t<input type=\'hidden\' value=\'N\' name=\'bed_no_val\' id=\'bed_no_val\'>\n\t\t<input type=\'hidden\' value=\'N\' name=\'generate_pseudo_bed\' id=\'generate_pseudo_bed\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" name=\'setup_bl_dtls_in_ip_yn\'>\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" name=\'query_string\'>\n\t\t<input type=\'hidden\' name=\'hdd_allow_release_bed_on_lv\' id=\'hdd_allow_release_bed_on_lv\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_allow_rel_bed\' id=\'hdd_allow_rel_bed\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_trans_type\' id=\'hdd_trans_type\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'hdd_peudobed_val\' id=\'hdd_peudobed_val\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'pseudo_bed_yn\' id=\'pseudo_bed_yn\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t<input type=\'hidden\' name=\'deactivate_pseudoBed\' id=\'deactivate_pseudoBed\' value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t<input type=\'hidden\' name=\'modified_date_val\' id=\'modified_date_val\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t<script>\n\t\tdocument.forms[0].release_bed.disabled\t\t= false;\n\t\tdocument.forms[0].PseudoBed_chart.disabled\t= true;\n\t\tdocument.forms[0].pseudoImg.style.visibility=\"hidden\";\t\n\t</script>\n\t\t<input type=\'hidden\' name=\'hddPseudoBedVal\' id=\'hddPseudoBedVal\' value=\'pseudo\'>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t<script>\n\t\tdocument.forms[0].release_bed.disabled\t\t= true;\n\t\tdocument.forms[0].PseudoBed_chart.disabled\t= true;\n\t\tdocument.forms[0].pseudoImg.style.visibility=\"hidden\";\t\n\t</script>\n\t\t<input type=\'hidden\' name=\'hddPseudoBedVal\' id=\'hddPseudoBedVal\' value=\'\'>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" \n\t\t<script>\n\t\t\tdocument.getElementById(\"leave_dtls_th\").innerText=getLabel(\"eIP.AbscondedDetails.label\",\"IP\");\n\t\t\tdocument.getElementById(\"reported_to_lgd\").innerHTML=getLabel(\"eIP.InformedOthers.label\",\"IP\");\n\t\t\tdocument.getElementById(\"leave_period_lgd\").innerHTML=getLabel(\"eIP.AbscondedFrom.label\",\"IP\");\n\t\t\tdocument.getElementById(\"leave_remarks_lgd\").innerHTML=getLabel(\"eIP.AbscondedRemarks.label\",\"IP\");\n\t\t\tdocument.getElementById(\"trans_remarks_lgd\").innerHTML=getLabel(\"eIP.ReturnedRemarks.label\",\"IP\");\n\t\t\tdocument.getElementById(\"Abscndng_lgd\").style.visibility\t\t\t    =\t\"Hidden\";\n\t\t\tdocument.getElementById(\"Dateofabs_lgd\").style.visibility\t\t\t    =\t\"Hidden\";\n\t\t\tdocument.getElementById(\"AbsStatusID\").style.visibility\t\t\t    =\t\"Hidden\"; \n\t\t\tdocument.getElementById(\"AbsDateID\").style.visibility\t\t\t\t    =\t\"Hidden\";\n\t\t\tdocument.getElementById(\"absgif\").style.visibility\t\t\t\t    =\t\"Hidden\";\n\t\t\tdocument.getElementById(\"calgif\").style.visibility\t\t\t\t\t=\t\"Hidden\"; \n\t\t\tdocument.getElementById(\"pol_rep_no\").disabled\t\t= true;\n\t\t\tdocument.getElementById(\"pol_rep_no\").value\t\t= \"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\t\tdocument.getElementById(\"pol_stn_id\").disabled\t\t= true;\n\t\t\tdocument.getElementById(\"pol_stn_id\").value\t\t= \"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\t\t\tdocument.getElementById(\"pol_id\").disabled\t\t\t= true;\n\t\t\tdocument.getElementById(\"pol_id\").value\t\t\t= \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\tvar informed_select = \"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\";\n\t\t\t\tdocument.getElementById(\"inform_to\").options[informed_select].selected\t= true;\n\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\n\t\t\tdocument.getElementById(\"inform_to\").disabled\t\t\t= true;\n\t\t\tdocument.getElementById(\"informed_name\").disabled\t\t= true;\n\t\t\tdocument.getElementById(\"informed_name\").value\t\t= \"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\";\n\t\t\tdocument.getElementById(\"informed_date\").disabled\t\t= true;\n\t\t\tdocument.getElementById(\"informed_date\").value\t\t= \"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\";\n\t\t</script>\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t<input type=\'hidden\' name=\'leave_stat\' id=\'leave_stat\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" >\n\t\t\t<script> \n\t\t\t\tvalidateTransType(document.forms[0].trans_type);\n\t\t\t\tvalidate_Bed_No();\n\t\t\t</script>\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
/*	LEAVE_STATUS - added by Sridhar R 
	obj.value = '1'>Revise Leave
	obj.value = '2'>Record Return
	obj.value = '3'>Record No Show
	obj.value = '9'>Cancel Leave
	out.println("sqlsd2"+sqlsd2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String encounterid  = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String srl_no   = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String facilityid       = (String) session.getValue("facility_id");
	
	String call_function    = request.getParameter("call_function")==null?"":request.getParameter("call_function");

	String loginUser = (String)session.getValue("login_user");

	Connection con      = null;
	Statement stmt		= null;
	ResultSet rset      = null;
	Statement stmt_opn	= null;
	ResultSet rs_opn	= null;
	PreparedStatement pstmt    =   null;

	String p_oper_stn_id		= "";
	String admission_date_time	= "";
	String adm_date_display		= "";
	String patient_id           = "";
	String practitioner_name	= "";
	String leave_fr_date		= "";
	String leave_fr_display		= "";
	String leave_to_date		= "";
	String leave_to_display		= "";
	String leave_remarks		= "";
	String amend_remarks		= "";
	String max_leave_period		= "";
	String release_bed_yn		= ""; 
	String old_nursing_unit_code= "";
	String old_room_no			= "";
	String old_bed_no			= "";  
	String old_to_daily_rate	= "";
	String trn_date_time		= "";
	String trn_type				= "";
	String trn_code				= "";
	String allow_rel_bed		= "";
	String chk					= "";
	String pseudobed			= "";
	String record_no_show_yn	= "N";
	String cancel_leave_yn		= "N";
	String fr_nursing_unit		= "";
	String fr_bed_class			= "";
	String fr_bed_type			= "";
	String fr_speciality		= "";
	String fr_practitioner		= "";
	String fr_service_code		= "";
	String to_service_code		= "";
	String reported_to			= "";
	String AbsDateTime			= "";
	String AbsYN				= "";
	String absconding_yn		= "";
	String fr_room_no			= "";
	String fr_bed_no			= "";
	String pol_rep_no1			= "";
	String pol_stn_id1			= "";
	String pol_id1				= "";
	String informed_to1			= "";
	String informed_name1		= "";
	String informed_date_time1	= "";
	String pseudo_bed_yn		= "";
	String deactivate_pseudoBed	= "";
	String leave_status			= "";
	String setup_bl_dtls_in_ip_yn		= "";
	String to_nursing_unit_short_desc	= "";
	String allow_release_bed_on_lv		= "";
	String warn_or_error_max_leave		= "";
	String max_allowed_lv_cancel_period	= "";
	String def_leave_to_date			= "";
	String patient_class				= "";
	String modified_date				= "";
	java.sql.Timestamp to_date = null;
	long leave_prd = 0;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm") ;
	java.util.Date dt = new java.util.Date();
	String d = dateFormat.format(dt) ;
try
{
	con = ConnectionManager.getConnection(request);
	p_oper_stn_id		 =  request.getParameter("p_oper_stn_id")==null?"":request.getParameter("p_oper_stn_id");
	if(p_oper_stn_id.equals(""))
	{
		StringBuffer operSql = new StringBuffer();
		operSql.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b.appl_user_id =? AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
		
		pstmt = con.prepareStatement(operSql.toString());
		pstmt.setString(1, facilityid);
		pstmt.setString(2, loginUser);
		
		rs_opn = pstmt.executeQuery();
		
/* 		stmt_opn = con.createStatement();
		rs_opn = stmt_opn.executeQuery(operSql.toString()); */

		if (rs_opn.next())
		{
			p_oper_stn_id = checkForNull(rs_opn.getString("oper_stn_id"));
		}
		if(rs_opn != null) rs_opn.close();
/* 		if(stmt_opn != null) stmt_opn.close(); */
		if(pstmt != null) pstmt.close();
	}
	/*Thursday, May 13, 2010 , commented for PE
	stmt = con.createStatement();
	
	StringBuffer sql_bl = new StringBuffer();
	sql_bl.append("select setup_bl_dtls_in_ip_yn, to_char((sysdate+max_allowed_lv_period/24),'dd/mm/rrrr hh24:mi') def_leave_to_preriod from ip_param where facility_id='"+facilityid+"' ");
	rset = stmt.executeQuery( sql_bl.toString() );

	if(rset!=null )
	{
		while(rset.next())
		 {
			setup_bl_dtls_in_ip_yn	= checkForNull(rset.getString("setup_bl_dtls_in_ip_yn"));
			def_leave_to_date		= checkForNull(rset.getString("def_leave_to_preriod"));
		 }
		if(rset != null) rset.close();
	}*/
	/* Commented for PE and merged with below query - 10/05/2010
	
	StringBuffer pseudobed_sql = new StringBuffer();
	pseudobed_sql.append("select PSEUDO_BED_YN, patient_class from IP_OPEN_ENCOUNTER_VW a where a.ENCOUNTER_ID = '"+encounterid+"' and a.facility_id = '"+facilityid+"' ");
	rset = stmt.executeQuery(pseudobed_sql.toString());
	if(rset!=null )
	{
		while(rset.next())
		 {
			pseudo_bed_yn	= checkForNull(rset.getString("PSEUDO_BED_YN"));
			patient_class   = checkForNull(rset.getString("patient_class"));
		 }
		if(rset != null) rset.close();
	}*/

	StringBuffer sql = new StringBuffer();
	sql.append(" select a.reported_to, to_char(a.leave_fr_date,'dd/mm/rrrr hh24:mi') leave_fr_date_disp, a.leave_fr_date, to_char(a.leave_to_date,'dd/mm/rrrr hh24:mi') leave_to_date_disp, a.leave_to_date, a.release_bed_yn, a.leave_remarks, decode(a.release_bed_yn,'Y','Yes','N','No') release_bed_yn, decode(a.override_yn,'Y','Yes','N','No') override_yn, a.approved_by_id, a.amend_remarks, a.leave_recorded_by, a.absconding_yn, to_char(a.ABSCONDING_DATE,'dd/mm/rrrr hh24:mi') absconding_date, a.leave_status, a.pol_rep_no, a.pol_stn_id, a.pol_id, a.informed_to, a.informed_name, to_char(a.informed_date_time,'dd/mm/rrrr hh24:mi') informed_date_time, (case when b.bed_num is not null then (select PSEUDO_BED_YN from ip_nursing_unit_bed where facility_id = b.facility_id and nursing_unit_code = b.nursing_unit_code and bed_no = b.bed_num) end ) PSEUDO_BED_YN, b.patient_class,to_char(a.modified_date,'dd/mm/rrrr hh24:mi:ss') modified_date from IP_LEAVE_DETAIL a, IP_OPEN_ENCOUNTER b where a.facility_id = ? and a.encounter_id = ? and a.srl_no = ? and a.facility_id = b.facility_id  and a.encounter_id = b.encounter_id "); 
	
	pstmt = con.prepareStatement(sql.toString());
	pstmt.setString(1, facilityid);
	pstmt.setString(2, encounterid);
	pstmt.setString(3, srl_no);
	
	rset = pstmt.executeQuery();
/* 	stmt = con.createStatement();
	rset = stmt.executeQuery(sql.toString()); */
	if(rset != null)
	{
		if(rset.next())
		{
			pseudo_bed_yn	= checkForNull(rset.getString("PSEUDO_BED_YN"));
			patient_class   = checkForNull(rset.getString("patient_class"));
			leave_fr_date		= checkForNull(rset.getString("leave_fr_date_disp"));
			if(!(leave_fr_date==null || leave_fr_date.equals("")))
				leave_fr_display = DateUtils.convertDate(leave_fr_date,"DMYHM","en",locale);
			leave_to_date		= rset.getString("leave_to_date_disp")==null ? "" : rset.getString("leave_to_date_disp") ;
			if(!(leave_to_date==null || leave_to_date.equals("")))
				leave_to_display = DateUtils.convertDate(leave_to_date,"DMYHM","en",locale);
			leave_remarks		= checkForNull(rset.getString("leave_remarks"));
			amend_remarks		= rset.getString("amend_remarks") == null ?"" : rset.getString("amend_remarks") ;
			release_bed_yn		= rset.getString("release_bed_yn");
			leave_status		= rset.getString("leave_status");
			reported_to			= rset.getString("REPORTED_TO") == null ?"" : rset.getString("REPORTED_TO") ;
			AbsYN	= rset.getString("ABSCONDING_YN");
			if(AbsYN == null) AbsYN = "N";
			absconding_yn = AbsYN.equals("Y") ?"checked" :"" ;
			AbsDateTime	= rset.getString("ABSCONDING_DATE") == null ?"":rset.getString("ABSCONDING_DATE");
			if(!(AbsDateTime==null || AbsDateTime.equals("")))
						AbsDateTime = DateUtils.convertDate(AbsDateTime,"DMYHM","en",locale);


			pol_rep_no1	= rset.getString("POL_REP_NO")==null?"":rset.getString("POL_REP_NO");
			pol_stn_id1	= rset.getString("POL_STN_ID")==null?"":rset.getString("POL_STN_ID");
			pol_id1	= rset.getString("POL_ID")==null?"":rset.getString("POL_ID");

			informed_to1	= rset.getString("INFORMED_TO")==null?"":rset.getString("INFORMED_TO");
			if(informed_to1.equals(""))
				informed_to1="0";
			informed_name1	= rset.getString("INFORMED_NAME")==null?"":rset.getString("INFORMED_NAME");

			informed_date_time1	= rset.getString("INFORMED_DATE_TIME")==null?"":rset.getString("INFORMED_DATE_TIME");
	
			java.sql.Timestamp from_date= rset.getTimestamp("leave_fr_date");
			to_date	= rset.getTimestamp("leave_to_date");

			long to_dt_long_val=0;
			long from_dt_long_val= 0;

			if(from_date != null)
			{
				from_dt_long_val =  from_date.parse(from_date.toLocaleString())/(60*60*1000) ;
			}
			if(to_date != null)
			{
				to_dt_long_val =  to_date.parse(to_date.toLocaleString())/(60*60*1000) ;           
			}

			leave_prd	= to_dt_long_val - from_dt_long_val ;

			if(leave_prd%24 == 0)
			{
				leave_prd =leave_prd/24;
			}
			
			modified_date		= rset.getString("modified_date")==null?"":rset.getString("modified_date");

			if(rset != null)    {rset.close(); rset = null;}
			if(pstmt != null)	pstmt.close();

			if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select trn_type, trn_code,to_nursing_unit ,patient_id, to_room_no, to_bed_no, to_bed_class_code , to_bed_type_code ,to_daily_rate ,to_practitioner_id , AM_GET_DESC.AM_PRACTITIONER(to_practitioner_id,?,'1') to_practitioner_long_name , fr_specialty_code, fr_practitioner_id,to_specialty_code,to_char(trn_date_time,'dd/mm/rrrr hh24:mi') trn_date_time, to_char(admission_date_time,'dd/mm/rrrr hh24:mi')admission_date_time, fr_room_no, fr_bed_no, fr_bed_class_code, fr_nursing_unit_code, fr_bed_type_code, AM_GET_DESC.AM_PRACTITIONER(fr_practitioner_id,?,'1') fr_practitioner_long_name , fr_room_no, fr_bed_no, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, TO_NURSING_UNIT,?,'2') to_nursing_unit_short_desc, FR_SERVICE_CODE, TO_SERVICE_CODE from IP_ADT_TRN where facility_id = ? and encounter_id = ?   and srl_no = (SELECT MAX(SRL_NO) FROM IP_ADT_TRN WHERE  facility_id = ? and ENCOUNTER_ID = ?) "); 

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, locale);
			pstmt.setString(2, locale);
			pstmt.setString(3, locale);
			pstmt.setString(4, facilityid);
			pstmt.setString(5, encounterid);
			pstmt.setString(6, facilityid);
			pstmt.setString(7, encounterid);
			
			rset = pstmt.executeQuery();
				
/* 			rset = stmt.executeQuery ( sql.toString() ); */
			if(rset != null)
			{
				if(rset.next())
				{
					patient_id                = rset.getString("patient_id");

					practitioner_name         = rset.getString("to_practitioner_long_name");
					if (rset.getString("to_practitioner_long_name")==null)
						practitioner_name = rset.getString("fr_practitioner_long_name");

					old_nursing_unit_code  = rset.getString("to_nursing_unit");
					if (rset.getString("to_nursing_unit")==null)
					old_nursing_unit_code  = rset.getString("fr_nursing_unit_code");
			
					old_room_no              = rset.getString("to_room_no");

					if (rset.getString("to_room_no")==null)
						old_room_no  = rset.getString("fr_room_no");

					if(old_room_no == null || old_room_no.equals("")) 
							old_room_no = "";

					old_bed_no  = rset.getString("to_bed_no");

					if (old_bed_no == null)
					old_bed_no  = rset.getString("fr_bed_no");

					if(release_bed_yn.equals("Y"))
					pseudobed = old_bed_no;

					admission_date_time = checkForNull(rset.getString("admission_date_time"));
					if(!(admission_date_time==null || admission_date_time.equals("")))
						adm_date_display = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale);

					if(setup_bl_dtls_in_ip_yn.equals("Y")) 
						old_to_daily_rate         = rset.getString("to_daily_rate");

					trn_type                          =rset.getString("trn_type")==null ? "" :  rset.getString("trn_type"); 
					
					trn_code     =rset.getString("trn_code")==null ? ""  :  rset.getString("trn_code"); 
					
					trn_date_time = rset.getString("trn_date_time");
					fr_room_no=rset.getString("fr_room_no");
					if(fr_room_no == null || fr_room_no.equals("null")) fr_room_no = "";
					
					fr_bed_no=rset.getString("fr_bed_no");
					if(fr_bed_no == null) fr_bed_no = "";
					
					fr_service_code=rset.getString("FR_SERVICE_CODE");
					if(fr_service_code == null) fr_service_code = "";

					to_service_code=rset.getString("TO_SERVICE_CODE");
					if(to_service_code == null) to_service_code = "";

					to_nursing_unit_short_desc = rset.getString("to_nursing_unit_short_desc");
					if(to_nursing_unit_short_desc == null) to_nursing_unit_short_desc = "";

					fr_nursing_unit = rset.getString("fr_nursing_unit_code");
					if(fr_nursing_unit == null) fr_nursing_unit = "";

					fr_bed_class = rset.getString("fr_bed_class_code");
					if(fr_bed_class == null) fr_bed_class = "";

					fr_bed_type = rset.getString("fr_bed_type_code");
					if(fr_bed_type == null) fr_bed_type = "";

					fr_practitioner = rset.getString("fr_practitioner_id");
					if(fr_practitioner == null) fr_practitioner = "";

					fr_speciality = rset.getString("fr_specialty_code");
					if(fr_speciality == null) fr_speciality = "";
				}
			}
		}
		if(rset != null) rset.close();
		if(pstmt != null)	pstmt.close();
	}
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" select a.DEACTIVATE_PSEUDO_BED_YN, b.RELEASE_BED_ON_LEAVE_YN, a.max_allowed_lv_period, a.warn_or_error_max_leave, a.max_allowed_lv_cancel_period, a.allow_release_bed_on_lv,a.setup_bl_dtls_in_ip_yn, to_char((sysdate+a.max_allowed_lv_period/24),'dd/mm/rrrr hh24:mi') def_leave_to_preriod ");
		//sql.append(",(select leave_fr_date+(a.max_allowed_lv_cancel_period/1440) from ip_leave_detail where facility_id='"+facilityid+"' and encounter_id ="+encounterid+" and leave_status = '1')leave_fr_date");
		sql.append("from ip_param a,ip_nursing_unit b where a.facility_id = ? and  a.facility_id = b.facility_id  and b.nursing_unit_code=? ");

		pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, facilityid);
		pstmt.setString(2, old_nursing_unit_code);
		
		rset = pstmt.executeQuery();
/*         rset = stmt.executeQuery( sql.toString() ) ; */



	if( rset != null )
	{
		if(rset.next())
		{
	        deactivate_pseudoBed		= checkForNull(rset.getString("DEACTIVATE_PSEUDO_BED_YN"));
			allow_release_bed_on_lv		= checkForNull(rset.getString("allow_release_bed_on_lv"));
			max_allowed_lv_cancel_period= checkForNull(rset.getString("max_allowed_lv_cancel_period"));
   
			max_leave_period		= rset.getString("max_allowed_lv_period");
			if(max_leave_period == null) max_leave_period = "0";

			warn_or_error_max_leave = rset.getString("warn_or_error_max_leave");
			if(warn_or_error_max_leave ==null) warn_or_error_max_leave ="";	

			allow_rel_bed = checkForNull(rset.getString("RELEASE_BED_ON_LEAVE_YN")); 

			setup_bl_dtls_in_ip_yn	= checkForNull(rset.getString("setup_bl_dtls_in_ip_yn"));
			def_leave_to_date		= checkForNull(rset.getString("def_leave_to_preriod"));
		}



		if(rset != null)    rset.close();

		if(sql.length() > 0) sql.delete(0,sql.length());
		if(pstmt!=null) pstmt.close();
		if(max_allowed_lv_cancel_period == "") max_allowed_lv_cancel_period = "0";
		sql.append(" select leave_fr_date+(?/1440) from ip_leave_detail where facility_id=? and encounter_id =? and leave_status = '1' " );
		
		pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, max_allowed_lv_cancel_period);
		pstmt.setString(2, facilityid);
		pstmt.setString(3, encounterid);
		
		rset = pstmt.executeQuery();


/* 		rset = stmt.executeQuery(sql.toString()) ; */

			if(rset != null)
			{
				if(rset.next())
				{
					if(rset.getTimestamp(1).after( new Timestamp(System.currentTimeMillis())))
					{
						cancel_leave_yn = "Y";
					}
								
				if(to_date != null)
				{
					if (to_date.before(new Timestamp(System.currentTimeMillis())))
						record_no_show_yn = "Y";
				}

			}
		}
		if(rset != null) rset.close();
	}
		if(rset != null)	    rset.close();
		if(rs_opn != null)		rs_opn.close();
		if(stmt_opn != null)    stmt_opn.close();
		if(stmt != null)		stmt.close();
		if(pstmt != null)		pstmt.close();

	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();}
	finally
	{
        ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(leave_fr_date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(leave_to_date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pseudobed));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(record_no_show_yn.equals("Y")){ 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
if(!leave_status.equals("4")){
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
if(cancel_leave_yn.equals("Y")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(adm_date_display));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
if(release_bed_yn.equals("Y")) chk = "checked"; else chk="";
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(leave_fr_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(leave_to_date));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(leave_remarks));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(fr_bed_no));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(fr_room_no));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(to_nursing_unit_short_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(old_nursing_unit_code));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(old_bed_no));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(old_room_no));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            {java.lang.String __page ="BedClassComponent.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            {java.lang.String __page ="BedTypeComponent.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block54Bytes, _wl_block54);
            {java.lang.String __page ="../../eIP/jsp/AbscondingDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf(call_function
                        )},{ weblogic.utils.StringUtils.valueOf("absconding_yn"), weblogic.utils.StringUtils.valueOf(absconding_yn
                        )},{ weblogic.utils.StringUtils.valueOf("AbsDateTime"), weblogic.utils.StringUtils.valueOf(AbsDateTime
                        )},{ weblogic.utils.StringUtils.valueOf("reported_to"), weblogic.utils.StringUtils.valueOf(reported_to
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(amend_remarks));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            {java.lang.String __page ="../../eIP/jsp/InformedDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("called_from"), weblogic.utils.StringUtils.valueOf("ament_inpatient_leave")},{ weblogic.utils.StringUtils.valueOf("informed_to"), weblogic.utils.StringUtils.valueOf(informed_to1
                        )},{ weblogic.utils.StringUtils.valueOf("informed_name"), weblogic.utils.StringUtils.valueOf(informed_name1
                        )},{ weblogic.utils.StringUtils.valueOf("informed_date_time"), weblogic.utils.StringUtils.valueOf(informed_date_time1
                        )},{ weblogic.utils.StringUtils.valueOf("system_date_time"), weblogic.utils.StringUtils.valueOf(d
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block64Bytes, _wl_block64);
            {java.lang.String __page ="../../eIP/jsp/MLCDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("called_from"), weblogic.utils.StringUtils.valueOf("amend_leave")},{ weblogic.utils.StringUtils.valueOf("pol_rep_no"), weblogic.utils.StringUtils.valueOf(pol_rep_no1
                        )},{ weblogic.utils.StringUtils.valueOf("pol_stn_id"), weblogic.utils.StringUtils.valueOf(pol_stn_id1
                        )},{ weblogic.utils.StringUtils.valueOf("pol_id"), weblogic.utils.StringUtils.valueOf(pol_id1
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(release_bed_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(max_leave_period));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(warn_or_error_max_leave));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(release_bed_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(fr_nursing_unit));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(fr_room_no));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(fr_bed_no));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(fr_bed_class));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(fr_bed_type));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(old_to_daily_rate));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(fr_practitioner));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(fr_speciality));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fr_service_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(trn_type));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(trn_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(d));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(def_leave_to_date));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(trn_date_time));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(admission_date_time));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(to_service_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(java.net.URLEncoder.encode(request.getQueryString())));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(allow_release_bed_on_lv));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(allow_rel_bed));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(pseudo_bed_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(deactivate_pseudoBed));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(modified_date));
            _bw.write(_wl_block99Bytes, _wl_block99);

// Added by Sridhar R on 15 JUNE 2004
// This part of code will check the value of allow release bed obtained from ip_pram & ip_nursing_unit & will enable Release bed Check box if the value is 'Y'
if(allow_release_bed_on_lv.equals("Y") && allow_rel_bed.equals("Y"))
{

            _bw.write(_wl_block100Bytes, _wl_block100);

}
else
{

            _bw.write(_wl_block101Bytes, _wl_block101);

} 	

            _bw.write(_wl_block1Bytes, _wl_block1);
	if(leave_status.equals("4"))         
	{	
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(pol_rep_no1));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(pol_stn_id1));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(pol_id1));
            _bw.write(_wl_block105Bytes, _wl_block105);
	if(!informed_to1.equals(""))
			{	
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(informed_to1));
            _bw.write(_wl_block107Bytes, _wl_block107);
	}	
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(informed_name1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(informed_date_time1));
            _bw.write(_wl_block110Bytes, _wl_block110);
	}	
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(leave_status));
            _bw.write(_wl_block112Bytes, _wl_block112);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AmendInpatientLeave.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.LeaveDetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.transactiontype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RecordReturn.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RecordNoShow.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReviseLeave.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CancelLeave.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReleaseBed.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PseudoBed.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LeavePeriod.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.LeaveRemarks.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PreviousBedDetails.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitDetails.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransactionRemarks.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DateTimeReturned.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
