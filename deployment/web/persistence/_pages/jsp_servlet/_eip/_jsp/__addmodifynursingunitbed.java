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
import eCommon.XSSRequestWrapper;

public final class __addmodifynursingunitbed extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addModifyNursingUnitBed.jsp", 1709117697238L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../js/NursingUnitBed.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</head>\n\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<body onLoad=\'focusTxt();\' onMouseDown=\"CodeArrest()\" onKeyDown = \"lockKey()\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<body onMouseDown=\"CodeArrest()\" onKeyDown = \"lockKey()\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t<form name=\'Nursing_Unit_Bed\' id=\'Nursing_Unit_Bed\' method=\'post\' action=\'../../servlet/eIP.NursingUnitBedServlet\' target=\'messageFrame\'>\n\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' height=\'100%\'  border=\'0\'>\n\t<tr>\n\t\t<td height=\'100%\' width=\'100%\' align=\'middle\' class=\'white\'>\n\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t<td colspan=\'3\' align =\'left\'>&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<input type=\'text\' name=\'nursing_unit1\' id=\'nursing_unit1\' maxlength=\'15\' size=\'15\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" readonly><input type=\'hidden\' name=\'nursing_unit\' id=\'nursing_unit\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" readonly><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr><td colspan=\'4\'>&nbsp</td></tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<td colspan=\'3\' align =\'left\'>&nbsp;&nbsp;<input type=\'text\'  name=\'main_bed_no\' id=\'main_bed_no\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" size=\'8\' maxlength=\'8\' onKeyPress=\'return CheckForSpecChars(event)\' value=\'\' onblur=\'ChangeUpperCase(this);getDetails(this);\'><input type=\'button\'  name=\'search_bed\' id=\'search_bed\' value=\'?\' onclick=\'searchBed()\' class=\'button\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="></td>\n\t\t\t</tr>\n\t\t\t<tr><td colspan=\'4\'>&nbsp</td></tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td>&nbsp;&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<select name=\'room\' id=\'room\'>\n\t\t\t\t<option value=\'\' >---&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;---</option>\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" selected>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<input type=\'text\' name=\'room\' id=\'room\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" maxlength=8 size=12 readonly>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t\t</td>\n\t\t\t\n\t\t\t\t<td  class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<input type=\'text\' name=\'bed_no\' id=\'bed_no\' size=\'8\' maxlength=\'8\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" onBlur=\'ChangeUpperCase(this)\' onKeyPress=\"return CheckForSpecChars(event)\" ><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr><td colspan=\'4\'>&nbsp</td></tr>\n            <tr>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<td class=\'label\' align=\'right\'>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>     \n\t\t\t<td>&nbsp;&nbsp;<input type=\'checkbox\'  name=\'CENSUS_BED\' id=\'CENSUS_BED\' value=\'Y\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" ></td> \n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<input type=\'hidden\' name=\'CENSUS_BED\' id=\'CENSUS_BED\' value=\"\" />\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<td  class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t<td ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="colspan=\'2\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="colspan=\'3\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =">&nbsp;<input type=\'checkbox\'  name=\'eff_status\' id=\'eff_status\' value=\'E\'  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="></td>\n\t\t\n\t\t\t\n\t\t\t</tr>\n\t\t\t<tr><td colspan=4 class=\'white\'>&nbsp</td></tr>\n\t\t\t<tr><td colspan=4 class=\'white\'>&nbsp</td></tr>\n\n\t\t\t<tr>\n\t\t\t\t<th colspan=\'4\' align=\'left\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</th>\n\t\t\t</tr>\n\n\t\t\t<tr><td colspan=\'4\'>&nbsp</td></tr>\n\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="<select name=\"bed_class\" id=\"bed_class\" onchange=\'popDynamicValues(this)\'>\n\t\t\t\t\t\t\t<option value=\'\'>---&nbsp;";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;---</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t</select>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="<input type=\'hidden\' name=\'bed_class\' id=\'bed_class\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"><input type=\'text\' name=\'bed_class_desc\' id=\'bed_class_desc\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" maxlength=15 size=15 readonly>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="<select name=\"bed_type\" id=\"bed_type\">\n\t\t\t\t\t\t\t\t<option value=\'\'>---&nbsp;";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&nbsp;---</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="<input type=\'hidden\' name=\'bed_type\' id=\'bed_type\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"><input type=\'text\' name=\'bed_type_desc\' id=\'bed_type_desc\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" maxlength=15 size=15 readonly>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr><td colspan=\'4\'>&nbsp</td></tr>\n\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<select name=\"gender_specific_ind\" id=\"gender_specific_ind\" onchange=\"assign_gender_specific_ind(this)\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="disabled";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =">\n\t\t\t\t<option value=\'\'>---&nbsp;";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t<option value=\'M\' ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t<option value=\'F\' ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t<option value=\'U\' ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t\t\t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t</select>\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="<input type=\'text\' name=\'gender_specific_ind\' id=\'gender_specific_ind\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" maxlength=15 size=10 readonly>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'gender_specific_ind_code\' id=\'gender_specific_ind_code\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="<select name=\"speciality\" id=\"speciality\">\n\t\t\t\t\t\t<option value=\'\'>---&nbsp;";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t</select>\n\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="<input type=hidden name=\'speciality\' id=\'speciality\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"><input type=text name=\'speciality_desc\' id=\'speciality_desc\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" maxlength=15 size=15 readonly >\n\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr><td colspan=\'4\'>&nbsp</td></tr>\n\n\t\t\t<tr><td colspan=4 class=\'white\'>&nbsp</td></tr>\n\t\t\t<tr><td colspan=4 class=\'white\'>&nbsp</td></tr>\n\t\t\t\t\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t<input type=\'hidden\' name=\'occupying_patient_id\' id=\'occupying_patient_id\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t<input type=\'hidden\'  name=\'inpatient\' id=\'inpatient\' value=\'Y\'>\n\t<input type=\'hidden\'  name=\'emergency\' id=\'emergency\' value=\'Y\'>\n\t<input type=\'hidden\'  name=\'day_care\' id=\'day_care\' value=\'Y\'>\n\t<input type=\'hidden\'  name=\'new_born\' id=\'new_born\' value=\'Y\'>\n\t<input type=\'hidden\'  name=\'lodger\' id=\'lodger\' value=\'Y\'>\n\t<input type=\'hidden\'  name=\'hdd_room\' id=\'hdd_room\' value=\'\'>\n\t<input type=\'hidden\'  name=\'hdd_bed_class\' id=\'hdd_bed_class\' value=\'\'>\n\t<input type=\'hidden\'  name=\'hdd_bed_type\' id=\'hdd_bed_type\' value=\'\'>\n\t<input type=\'hidden\'  name=\'hdd_bed_type_desc\' id=\'hdd_bed_type_desc\' value=\'\'>\n\t<input type=\'hidden\'  name=\'hdd_speciality_code\' id=\'hdd_speciality_code\' value=\'\'>\n\t<input type=\'hidden\'  name=\'hdd_speciality_desc\' id=\'hdd_speciality_desc\' value=\'\'>\n\t<input type=\"hidden\" name=\"hddBedVal\" id=\"hddBedVal\" value=";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" >\n\t<input type=\"hidden\" name=\"sStyle\" id=\"sStyle\" value=";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" >\n<input type=\"hidden\" name=\"status\" id=\"status\" value=\"\">\n\t\t\t\t</form>\n<script>\n\t\t\t\n\t\tif(\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"==\"modify\" && \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"==\"E\")\n\t\t{\n\t\t\tdocument.forms[0].room.focus();\n\t\t}\n\nif(\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"==\"modify\" )\n{\n\tif(document.forms[0].hddBedVal.value != \"\")\n\t{\n\t\t/*Thursday, December 02, 2010, PMG20089-CRF-0864 [IN:025309]*/\n\t\t//if(document.forms[0].customer_id.value ==\'EK\'){  //this line commented CRF [AMRI-CRF-0220]*/ \n\t\t\n\t\t\tdocument.forms[0].room.disabled = true;\n\t\t\tdocument.forms[0].bed_no.disabled = true;\n\t\t\t//document.forms[0].bed_no.readonly = true;\n\t\t\tif(document.forms[0].hddBedVal.value == \'TransactionExists\')\n\t\t\t\tdocument.forms[0].eff_status.disabled = false;\n\t\t\telse\n\t\t\t\tdocument.forms[0].eff_status.disabled = true;\n\t\t\tdocument.forms[0].bed_class.disabled = true;\n\t\t\tdocument.forms[0].bed_type.disabled = true;\n\t\t\tdocument.forms[0].gender_specific_ind.disabled = true;\n\t\t\tdocument.forms[0].speciality.disabled = true;\n\t\t\tdocument.forms[0].main_bed_no.disabled = true;\n\t\t\tdocument.forms[0].CENSUS_BED.disabled = true;//Added by Mano GHL-CRF-418\n\t\t\t\n\t\t\tif(document.forms[0].hddBedVal.value == \'bedReserved\' && document.forms[0].hddBedVal.value != \'TransactionExists\')\n\t\t\t{\n\t\t\t\tvar message = getMessage(\"BED_RESERVED_BY_PATIENT\",\"IP\")\n\t\t\t\t\tmessage = message.replace(\"$\",getLabel(\"Common.Modify.label\",\"Common\"));\n\t\t\t\talert(message);\n\t\t\t}\n\t\t\telse if(document.forms[0].hddBedVal.value != \'bedReserved\' && document.forms[0].hddBedVal.value != \'TransactionExists\')\n\t\t\t\talert(getMessage(\"BED_OCCUPIED_BY_PATIENT\",\"IP\"));\t\n\t\t\t\n\t\t/*Below else condtion commeneted for this CRF [AMRI-CRF-0220]*/ \t\t\n\t\t/*}else\n\t\t{\n\t\t\t\t\n\t\t\t\tdocument.forms[0].room.disabled = true;\n\t\t\t\tdocument.forms[0].bed_no.disabled = true;\n\t\t\t\t//document.forms[0].bed_no.readonly = true;\n\t\t\t\tdocument.forms[0].eff_status.disabled = true;\n\t\t\t\tdocument.forms[0].bed_class.disabled = true;\n\t\t\t\tdocument.forms[0].bed_type.disabled = true;\n\t\t\t\tdocument.forms[0].gender_specific_ind.disabled = true;\n\t\t\t\tdocument.forms[0].speciality.disabled = true;\n\t\t\t\tdocument.forms[0].main_bed_no.disabled = true;\n\t\t\t\tif(document.forms[0].hddBedVal.value == \'TransactionExists\')\n\t\t\t\talert(getMessage(\"BEDS_USED\",\"IP\"));\n\t\t\t\telse\n\t\t\t\talert(getMessage(\"BED_OCCUPIED_BY_PATIENT\",\"IP\"));\n\t\t}*/\n\t}\n}\n\nif(\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"==\"modify\")\n{\n\tif(document.forms[0].main_bed_no.value != \'\')\n\t{\n\t\tdocument.forms[0].room.disabled = true;\n\t\tdocument.forms[0].bed_class.disabled = true;\n\t\tdocument.forms[0].bed_type.disabled = true;\n\t\tdocument.forms[0].speciality.disabled = true;\n\t}\n}\n\n</script>\n\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );


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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

			request.setCharacterEncoding("UTF-8");
			//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
			Connection con			= null;
			ResultSet GenderRS1		= null;
			Statement Genderstmt1	= null;
			Statement stmt			= null;
			ResultSet rs			= null;
			Statement stmt1			= null;
			ResultSet rs1			= null;
			ResultSet BedRs			= null;
			Statement BedStmt		= null;

			String facility_id		= (String)session.getAttribute("facility_id");
			String nursing_unit_code= request.getParameter("nursing_unit_code");

			String fn_val				= "insert";
			String nursing_unit_desc	= "";
			String bed_no				= "";
			String room_no				= "";
			String eff_status			= "E";
			String bed_class_code		= "";
			String bed_type				= "";
			String gender_spec_ind		= "";
			String speciality_code		= "";
			String bed_class_desc		= "";
			String speciality_code_desc	= "";
			String mainBedNo			= "";
			String disable				= "";
			String bed_type_desc		= "";
			String disableVal			= "";
			String occupying_patient_id = "";
			String DisVal				= "";
			String isCensusBedEnable    = "";     //Added by mano GHL-CRF-418
			String census_bed_yn	    = "";     //Added by Mano GHL-CRF-418
			StringBuffer BedSql         = new StringBuffer();

try{
			con							= ConnectionManager.getConnection(request);
			stmt						= con.createStatement();
			//added by mano GHL-CRF-418
            boolean isCensusBedApplicable	= eCommon.Common.CommonBean.isSiteSpecific(con, "IP","CENSUS_BED");
			//End of the GHL-CRF-418
			if(nursing_unit_code!=null)
			{
				fn_val					= "modify"; 
				bed_no					= request.getParameter("bed_no");
				StringBuffer modify_sql = new StringBuffer();

				modify_sql.append("select * from ip_nursing_unit_bed_vw where nursing_unit_code='"+nursing_unit_code+"' and bed_no='"+bed_no+"'  and facility_id='"+facility_id+"'");

				rs						= stmt.executeQuery(modify_sql.toString());

				if(rs!=null)
				{
					if(rs.next())
					{
						nursing_unit_desc	= rs.getString("NURSING_UNIT_SHORT_DESC")	;
						bed_no				= rs.getString("bed_no")	;
						room_no				= rs.getString("room_no");
						occupying_patient_id= rs.getString("occupying_patient_id");
						if(occupying_patient_id==null)
							occupying_patient_id="";
						eff_status			= rs.getString("eff_status")	;

						bed_class_code		= rs.getString("bed_class_code")	;
						bed_class_desc		= rs.getString("BED_CLASS_SHORT_DESC")	;

						bed_type			= rs.getString("bed_type_code")	;
						bed_type_desc		= rs.getString("BED_TYPE_SHORT_DESC")	;

						gender_spec_ind		= rs.getString("sex_spec_ind")	;
						if(gender_spec_ind==null)	gender_spec_ind="";

						speciality_code		= rs.getString("specialty_code")	;
						if(speciality_code==null)	speciality_code="";

						speciality_code_desc= rs.getString("SPECAILTY_SHORT_DESC")	;
						if(speciality_code_desc==null)
							speciality_code_desc="";

						mainBedNo			=	rs.getString("MAIN_BED_NO")	;

						census_bed_yn	    =  rs.getString("census_bed_yn")	;   //Added By Mano GHL-CRF-418
						

						if(mainBedNo==null) mainBedNo = "";
						disable				= "Disabled";

						//inpatient	= rs.getString("inpatient_pat_class_appl_yn")	;
						//emergency	= rs.getString("emergency_pat_class_appl_yn")	;
						//day_care	= rs.getString("daycare_pat_class_appl_yn")	;
						//new_born	= rs.getString("newborn_pat_class_appl_yn")	;
						//lodger		= rs.getString("lodger_pat_class_appl_yn")	;
					}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
				StringBuffer sql_gender = new StringBuffer();
				sql_gender.append("select gender from am_age_group ");
				sql_gender.append("where  age_group_code=(select age_group_code from ip_nursing_unit ");
				sql_gender.append("where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"')");

				stmt					= con.createStatement();
				rs						= stmt.executeQuery(sql_gender.toString());
				String gender			= "";
				if(rs != null)
				if(rs.next())
				{
					gender				= rs.getString(1);
					if(gender == null || gender.equals("null"))		gender = "";
				}
					if(rs!=null) rs.close();

				if(!gender.equals(""))
					disableVal			= "disabled";
				else
					disableVal			= "";

				
			}

// Added on 6 FEB by Sridhar
// DisVal will contain the Patient_ID who has Ocuppied the Corresponding Bed.
	if(fn_val.equals("modify"))
	{
		bed_no							= request.getParameter("bed_no");

		BedSql.append("Select occupying_patient_id FROM ip_nursing_unit_bed WHERE bed_no = '"+bed_no+"' and nursing_unit_code='"+nursing_unit_code+"' and facility_id='"+facility_id+"' ");

		BedStmt							= con.createStatement();
		BedRs							= BedStmt.executeQuery(BedSql.toString());

		if(BedRs != null)
		{
			while(BedRs.next())
			{
				DisVal					= BedRs.getString("occupying_patient_id");
			}
		}
		
		if(DisVal == null)
		{	
			if(BedRs!=null) BedRs.close();
			if(BedStmt!=null) BedStmt.close();
			if(BedSql.length() > 0) BedSql.delete(0,BedSql.length());
			//BedSql.append("select count(*) count from pr_encounter where ASSIGN_CARE_LOCN_CODE = '"+nursing_unit_code+"' and ASSIGN_BED_NUM = '"+bed_no+"'");

			BedSql.append(" select count(1) from IP_ADT_TRN where to_nursing_unit ='"+nursing_unit_code+"' and TO_BED_NO='"+bed_no+"'and facility_id='"+facility_id+"' ");

			BedStmt						= con.createStatement();
			BedRs						= BedStmt.executeQuery(BedSql.toString());

			if(BedRs != null)
			{
				while(BedRs.next())
				{
					int count			= BedRs.getInt(1);
					if(count > 0)
					DisVal				= "TransactionExists";
					else
					DisVal				= "";
				}
			}
		}
		if(BedRs!=null) BedRs.close();
		if(BedStmt!=null) BedStmt.close();
		if(DisVal == null ) DisVal="";
	}

	String Gender = "";
	if(gender_spec_ind == "")
	{	
			Genderstmt1=con.createStatement();
			GenderRS1=Genderstmt1.executeQuery(" SELECT a.nursing_unit_code, a.short_desc, a.age_group_code, DECODE(b.gender,'M','Male','F','Female','U','Unknown')gender FROM ip_nursing_unit a, am_age_group b WHERE a.nursing_unit_code ='"+nursing_unit_code+"' AND b.age_group_code = a.age_group_code and a.facility_id='"+facility_id+"' ");
			if(GenderRS1!=null)
			{
				while(GenderRS1.next())
				{
					Gender = GenderRS1.getString("Gender");
				}
			}
			if(Gender == null)	Gender = "";
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
if(fn_val.equals("insert")){
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(fn_val.equals("insert"))
					{
            _bw.write(_wl_block14Bytes, _wl_block14);
            {java.lang.String __page ="NursingUnitComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block15Bytes, _wl_block15);
}
					else
					{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);

				String disbl_bed = "disabled";
				if(fn_val.equals("modify"))
				 {
					if(eff_status.equals("D")) 
						disbl_bed = "disabled";
					else
						disbl_bed = "";
				 }
				 else if(fn_val.equals("insert"))
						 disbl_bed = "disabled";
				
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(mainBedNo));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disbl_bed));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disbl_bed));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

					if(eff_status.equals("E"))
					{
						StringBuffer sql_room = new StringBuffer();
						sql_room.append("select room_no from ip_nursing_unit_room where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"' and eff_status='E' order by 1");
				
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

					if (fn_val.equals("modify"))
					{

						stmt1 = con.createStatement();

						rs1 = stmt1.executeQuery(sql_room.toString());
						
						String p_room_no="";

						while (rs1.next())
						{
							p_room_no = rs1.getString("room_no");

							if (p_room_no.equals(room_no))
							{
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_room_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( p_room_no ));
            _bw.write(_wl_block31Bytes, _wl_block31);
		
							}
							else
							{
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_room_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( p_room_no ));
            _bw.write(_wl_block31Bytes, _wl_block31);
			}
						}
					if(rs1!=null) rs1.close();
					if(stmt1!=null) stmt1.close();
					}
				
            _bw.write(_wl_block33Bytes, _wl_block33);
}
					else
					{
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block35Bytes, _wl_block35);

					}
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

				String readOnly="";
				if(fn_val.equals("modify"))	readOnly="readonly";
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block38Bytes, _wl_block38);

			  if(isCensusBedApplicable) { //Added by Mano GHL-CRF-418
				 isCensusBedEnable = "checked";
				 if(census_bed_yn.equals("Y"))
					isCensusBedEnable = "checked";	
				 else if(census_bed_yn.equals("N"))
					 isCensusBedEnable = "";
			
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(isCensusBedEnable));
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

					String chk_val="checked";
					if(eff_status.equals("D"))
						chk_val="";
				
            _bw.write(_wl_block45Bytes, _wl_block45);
if(isCensusBedApplicable){
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(chk_val));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

						if(eff_status.equals("E"))
						{
					
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

								StringBuffer bed_class_sql = new StringBuffer();
								bed_class_sql.append("select short_desc, bed_class_code from ip_bed_class ");
     							bed_class_sql.append("where eff_status='E' order by short_desc");
								try
								{
									rs = stmt.executeQuery(bed_class_sql.toString());
									String sel = "";
									while(rs.next())
									{
										if(rs.getString(2).equals(bed_class_code))
										{
											sel="selected";
										}
										out.print("<option value='"+rs.getString(2)+"' "+sel+">"+rs.getString(1)+"</option>");
										sel="";
									}
									if(rs!=null) rs.close();
									if(stmt!=null) stmt.close();
								}
								catch(Exception e)
								{
									//out.print(e);
									e.printStackTrace();
								}
							
            _bw.write(_wl_block53Bytes, _wl_block53);
}else
						{
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bed_class_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
if(eff_status.equals("E"))
					{
					StringBuffer sql_bed_type = new StringBuffer();
					sql_bed_type.append("select short_desc, bed_type_code from ip_bed_type where bed_class_code='"+bed_class_code+"' and eff_status='E' order by short_desc");
					
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

				if (fn_val.equals("modify"))
					{
						stmt1 = con.createStatement();
						rs1	  = stmt1.executeQuery(sql_bed_type.toString());
						
						String p_bed_type_code="";
						String p_bed_type_desc="";

						while (rs1.next())
						{
							p_bed_type_code = rs1.getString("bed_type_code");
							p_bed_type_desc = rs1.getString("short_desc");

							if (p_bed_type_code.equals(bed_type))
							{
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_bed_type_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( p_bed_type_desc ));
            _bw.write(_wl_block31Bytes, _wl_block31);
		
							}
							else
							{
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_bed_type_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( p_bed_type_desc ));
            _bw.write(_wl_block31Bytes, _wl_block31);
			}
						}
					if(rs1!=null) rs1.close();
					if(stmt1!=null) stmt1.close();
					}
					
            _bw.write(_wl_block60Bytes, _wl_block60);
}
							else
							{
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bed_type_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);

							}
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
if(eff_status.equals("E"))
				{													
				
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disableVal));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(!mainBedNo.equals("")){
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
 String sel="";
				if(gender_spec_ind.equals("M"))	sel="selected";
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
sel="";
				if(gender_spec_ind.equals("F"))	sel="selected";
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
sel="";
				if(gender_spec_ind.equals("U"))	sel="selected";
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

					String sel1=""; 
					if (fn_val.equals("modify"))
					{	
						if(gender_spec_ind.equals("") && !Gender.equals(""))	
						{
							sel1="selected";
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(sel1));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(Gender));
            _bw.write(_wl_block74Bytes, _wl_block74);
	}
					}
            _bw.write(_wl_block75Bytes, _wl_block75);
}
					else
					{
						String gend="";
						if(gender_spec_ind.equals("U"))
								gend="Unknown";
						if(gender_spec_ind.equals("M"))
								gend="Male";
						if(gender_spec_ind.equals("F"))
								gend="Female";
						
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(gend));
            _bw.write(_wl_block77Bytes, _wl_block77);

					}
					
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(gender_spec_ind));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);


				if(eff_status.equals("E"))
				{
				StringBuffer sql_speciality = new StringBuffer();
				sql_speciality.append("select specialty_code, specialty_short_desc from ip_nurs_unit_for_specialty_vw where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"' order by specialty_short_desc");

				
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

					if (fn_val.equals("modify"))
					{

						stmt1 = con.createStatement();
						rs1	  = stmt1.executeQuery(sql_speciality.toString());
						String p_specialty_code="";
						String p_specialty_desc="";

						while (rs1.next())
						{
							p_specialty_code = rs1.getString("specialty_code");
								if(p_specialty_code == null) p_specialty_code = "";
							p_specialty_desc = rs1.getString("specialty_short_desc");
								if(p_specialty_desc == null) p_specialty_desc = "";

							if (p_specialty_code.equals(speciality_code))
							{
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_specialty_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( p_specialty_desc ));
            _bw.write(_wl_block31Bytes, _wl_block31);
		
							}
							else
							{
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_specialty_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( p_specialty_desc ));
            _bw.write(_wl_block31Bytes, _wl_block31);
			}
						}
					if(rs1!=null) rs1.close();
					if(stmt1!=null) stmt1.close();
					}
				
            _bw.write(_wl_block81Bytes, _wl_block81);
}
				else
				{
					
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(speciality_code_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);

				}
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(fn_val));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(occupying_patient_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(DisVal));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(fn_val));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(fn_val));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(fn_val));
            _bw.write(_wl_block93Bytes, _wl_block93);

		if (rs != null)			rs.close();
		if (stmt != null)		stmt.close();
		if (GenderRS1 != null)	GenderRS1.close();
		if (Genderstmt1 != null)Genderstmt1.close();
		if (rs1 != null)		rs1.close();
		if (stmt1 != null)		stmt1.close();
		if (BedRs != null)		BedRs.close();
		if (BedStmt != null)	BedStmt.close();

	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		if(con != null )ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block94Bytes, _wl_block94);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MainBedNo.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CensusBed.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Characteristics.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GenderSpecificInd.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
