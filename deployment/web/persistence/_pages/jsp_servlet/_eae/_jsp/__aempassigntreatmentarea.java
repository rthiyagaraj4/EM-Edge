package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aempassigntreatmentarea extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEMPAssignTreatmentArea.jsp", 1729501700856L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEManagePatient.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEUtilities.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEPractitionerComponent.js\'></script>\n\n<!--Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133-->\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></Script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>  \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onload=\"checkStatus(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\');disboth();chkboth();\" onKeyDown = \'lockKey()\'>\n<center>\n<br>\n<form name=\'AEMPAssgnTmtAreaForm\' id=\'AEMPAssgnTmtAreaForm\' method=\'POST\'>\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'97%\'>\n\t<tr>\n\t<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\'hidden\' name=\'strCA\' id=\'strCA\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<!-- changePriority(this) Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022 -->\n\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t  \t   <td class=\'fields\' width=\'25%\'><select name=\'priority_value\' id=\'priority_value\' onchange=\"getValues(this,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');chkboth();";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="changePriority(this);";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" disabled>\n       ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t  <td class=\'fields\' width=\'25%\'><select name=\'priority_value\' id=\'priority_value\'  onchange=\"getValues(this,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');chkboth();enableOK();";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="> \n\t    ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<td class=\'fields\' width=\'25%\'><select name=\'priority_value\' id=\'priority_value\'   onchange=\"getValues(this,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">\n\t\t ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n         \n\t\t<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->\n       ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<!--CRF  SKR-CRF-0021 [IN028173] end-->\n\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t\n\t</tr>\n \n    <!-- Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022 -->\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<tr> \n\t    <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t    <select name=\'priority11\' id=\'priority11\' >\n\t\t\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="----------\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="  \n\t\t\t\t\t</select>\n\t\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<!-- End ML-MMOH-CRF-1975 -->\n\n    <tr>\n\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n       ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<td class=\'fields\' width=\'25%\'><select name=\'treatment_area_code\' id=\'treatment_area_code\' onBlur=\'enableOK();\' onChange=\"chkboth(); clearBed();enableOK();\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  tabindex = \"1\" disabled>\n         ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \n            <td class=\'fields\' width=\'25%\'><select name=\'treatment_area_code\' id=\'treatment_area_code\' onBlur=\'enableOK();\' onChange=\"chkboth();clearBed();populateDynamicValues(\'AssignTreatmentArea\');\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="  tabindex = \"1\" > \n        ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n         <td class=\'fields\' width=\'25%\'><select name=\'treatment_area_code\' id=\'treatment_area_code\' onBlur=\'enableOK();\' onChange=\"chkboth();clearBed();populateDynamicValues(\'AssignTreatmentArea\');\"  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" tabindex = \"1\" >\n         ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<option value=\'\'>---------- ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="----------</option>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" </option>\n\t\t\t<!-- <script>\n\t\t\topenToAllPractForClnYN[";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="] = \'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\';\n\t\t\t</script> -->\n             <!-- treatmentGender[";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'; -->\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t<td class=\'QUERYDATA\' width=\'25%\'>\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t</td>\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t<tr>\t\n\t\t<input type=\'hidden\' name=\'bed_count\' id=\'bed_count\' value=\'\'>\n\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'bed_bay_no\' id=\'bed_bay_no\' size=\'8\' maxlength=\'8\' readonly onblur=\"ChangeUpperCase(this);\" onKeyPress=\"return(CheckForSpecChars(event));enableOK();\"   value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" tabindex = \"2\"><input type=button class=button value=\'?\' name=\'bed_button\' id=\'bed_button\'  onClick=\"callBedAvailChart();\" ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" tabindex = \"3\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'bed_mand\' style=\'visibility:hidden\'></img></td>\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t<script>\n\t\t\t\tdocument.getElementById(\"bed_mand\").style.visibility=\'visible\';\n\t\t        document.forms[0].bed_count.value=\'Y\';\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t<script>\n\t\t\t\tdocument.getElementById(\"bed_mand\").style.visibility=\'hidden\';\n\t\t        document.forms[0].bed_count.value=\'N\';\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t</tr>\n\t<tr>\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'><input type=text  name=practitioner_desc size=30 maxlength=30 value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" onBlur=\"beforeGetPractitioner(document.forms[0].pract_button,practitioner_desc);\" ><input type=hidden value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" name=\'practitioner_id\' id=\'practitioner_id\' ><input type=button class=button value=\'?\' name=pract_button   onclick=\"aegetPractitioner(this,practitioner_desc); \"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'pract_mand\'></img><input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\"\">\n\t\t</td> \n \n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t<script>\n\t\t\t\t\tdocument.forms[0].pract_mand.style.visibility=\'visible\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t<script>\n\t\t\t\t\tdocument.forms[0].pract_mand.style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t</tr>\n\t<tr>\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t<!--Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133-->\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'assign_tmt_area_time\' id=\'assign_tmt_area_time\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' size=\'16\' maxlength=\'16\'   disabled ></td>\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input type=\'text\' name=\'assign_tmt_area_time\' id=\'assign_tmt_area_time\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' onBlur=\"if(validDateObj(this,\'DMYHM\',localeName)){chkWithSysDt(this);}\" size=\'16\' maxlength=\'16\'><img type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].assign_tmt_area_time.select();return showCalendar(\'assign_tmt_area_time\', null, \'hh:mm\');\" style=\"cursor=\'hand\'\"></img>&nbsp;\n\t\t\t<img src=\'..\\..\\eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t<!--End ML-MMOH-CRF-1133-->\n\t</tr>\n</table> \n<p align=\'center\'>\n<input type=\'button\' class=\'BUTTON\' name=\'ok\' id=\'ok\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'\n   onClick=\'assignTreatmentArea();\'  >&nbsp;  \n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="   \n     \n      <input type=\'button\' class=\'BUTTON\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' onClick=\'cancelOperation1(\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\");\'>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t<input type=\'button\' class=\'BUTTON\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' onClick=\'cancelOperation()\'>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n</p>\n<br>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n<input type=\'hidden\' name=\'clinic_type\' id=\'clinic_type\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n<input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n<input type=\'hidden\' name=\'queue_date\' id=\'queue_date\'\tvalue=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n<input type=\'hidden\' name=\'sys_date_time\' id=\'sys_date_time\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n<input type=\'hidden\' name=\'visit_date_time\' id=\'visit_date_time\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n<input type=\'hidden\' name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n<input type=\'hidden\' name=\'selection_mode\' id=\'selection_mode\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n<input type=\'hidden\' name=\'start_date\' id=\'start_date\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n<input type=\'hidden\' name=\'end_date\' id=\'end_date\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n<input type=\'hidden\' name=\'queue_status\' id=\'queue_status\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n<input type=\'hidden\' name=\'operation_mode\' id=\'operation_mode\' value=\"AssignTreatmentArea\" >\n<input type=\'hidden\' name=\'prev_tmt_area_code\' id=\'prev_tmt_area_code\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n<input type=\'hidden\' name=\'userid\' id=\'userid\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n<input type=\'hidden\' name=\'open_to_all_prac_for_clinic_yn\' id=\'open_to_all_prac_for_clinic_yn\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<input type=\'hidden\' name=\'pract_for_workDay_check\' id=\'pract_for_workDay_check\' value=\"\">\n<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<input type=\'hidden\' name=\'episode_visit_num\' id=\'episode_visit_num\' value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n<input type=\'hidden\' name=\'enable_rights_yn\' id=\'enable_rights_yn\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n<input type=\'hidden\' name=\'pract_type1\' id=\'pract_type1\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n<input type=\'hidden\' name=\'sel_triage_yn\' id=\'sel_triage_yn\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n<input type=\'hidden\' name=\'sel_cons_yn\' id=\'sel_cons_yn\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n<input type=\'hidden\' name=\'brought_dead\' id=\'brought_dead\' value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n<input type=\'hidden\' name=\'min_age_for_lmp\' id=\'min_age_for_lmp\' value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n<input type=\'hidden\' name=\'year_value\' id=\'year_value\' value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n<input type=\'hidden\' name=\'isStartConsultationAppl\' id=\'isStartConsultationAppl\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"><!--Added by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623-->\n\n<!--Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133-->\n<input type=\'hidden\' name=\'isEnableDateTimeAppl\' id=\'isEnableDateTimeAppl\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n<input type=\'hidden\' name=\'visit_adm_date_time\' id=\'visit_adm_date_time\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\n</form>\n<script>\n\tsetFocusToFirstItem();\n</script>\n<!--Added by Rameswar on 08-Feb-16 for GDOH-CRF-081-->\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n <script>document.forms[0].practitioner_desc.onblur();</script>\n ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n</center> \n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n</body>\n</html> \n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	PreparedStatement	pstmt1		=	null;
	ResultSet			rs			=	null;
	ResultSet			rs1			=	null;
	String	facility_id				=	"";
	String  bl_install_yn           =	"";
	String	open_to_all_pract_yn	=	"";
	String	clinic_code				=	"";
	String	treatment_area_code		=	"",		treatment_area_desc		=	"";
	String	clinic_type				=	"",		encounter_id			=	"";
	String	queue_date				=	"",		tmt_area_prop			=	"";
	String	selection_mode			=	"";
	String	tmt_area_code			=	"";
	String	practitioner_name		=	"";
	String	pract_id				=	"";
	String	queue_status			=	"";
	String	patient_gender			=	"";
    String  regFlag					=	"",		treatment_area_gender	=	"";
	String  service_code			=   "";
	
	/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	String sql              ="";
	String color            ="";
	String  green           ="";
	String red              ="";
    String yellow           ="";
    String unassigned       ="";
	
	/* CRF  SKR-CRF-0021 [IN028173] end  */
	
	
	String	open_to_all_prac_for_clinic_yn	=	"";
	String	speciality_code		=	"";
	int		arrIndex				=	1 ;
	String  sys_date_time="",visit_date_time="";
	String patient_id = "";
	String strCA = "";
	String bed_no = "";
	String bed_prop = "";
	String priority_zone = "";
	//String pvr = "", pvy = "", pvg ="",pvu ="";
	int countBed =0;
	String treatAreaSel ="";
	//String sex ="";
	String open_to_all_prac_for_clinic_ynSel="";
	String visit_type_code = "";
	String pract_type = "";
	String login_user="";
	String episode_id="";
	String episode_visit_num="";	
	String locale			= (String)session.getAttribute("LOCALE");
	//String loginUser			= checkForNull((String)session.getValue("login_user"));
	String brought_dead="";
	String year_value="";

	String isStartConsultationAppl = "";//Added by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623
	
	/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
	Boolean isEnableDateTimeAppl = false;
	String visit_adm_date_time	 = "";
	/*End ML-MMOH-CRF-1133*/

    /*Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022*/
	Boolean isPriorityAssgnTmtAreaAppl = false;
	String sqlFinal		 = "";
	String optSelected	 = "";
	String priority_code = "";
	/*End ML-MMOH-CRF-1975*/
	
	try
	{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		con				=	(Connection)	ConnectionManager.getConnection(request);
		facility_id		=	(String) session.getValue("facility_id");
        bl_install_yn   =   (String) session.getValue("bl_operational"); 
		login_user		=   (String)session.getValue("login_user") ;
		//strCA = request.getParameter("CA");
		strCA = request.getParameter("CA")==null?"N":request.getParameter("CA");		
		String option_id =  request.getParameter("option_id");
		String start_date =  request.getParameter("start_date");
		String end_date =  request.getParameter("end_date");
		String enable_rights_yn =  request.getParameter("enable_rights_yn")==null?"":request.getParameter("enable_rights_yn");
		String min_age_for_lmp =  request.getParameter("min_age_for_lmp")==null?"":request.getParameter("min_age_for_lmp");		
		String sel_cons_yn =  request.getParameter("sel_cons_yn")==null?"":request.getParameter("sel_cons_yn");		
		String sel_triage_yn =  request.getParameter("sel_triage_yn")==null?"":request.getParameter("sel_triage_yn");		
		String pract_type1 =  request.getParameter("pract_type1")==null?"":request.getParameter("pract_type1");			
 		selection_mode			=	checkForNull(request.getParameter("selection_mode"));
		clinic_code				=	checkForNull(request.getParameter("clinic_code"));
		clinic_type				=	checkForNull(request.getParameter("clinic_type"));
		queue_date				=	checkForNull(request.getParameter("queue_date"));
		queue_status			=	checkForNull(request.getParameter("queue_status"));
		encounter_id			=	checkForNull(request.getParameter("encounter_id"));
		open_to_all_pract_yn	=	checkForNull(request.getParameter("open_to_all_pract_yn"));
		tmt_area_code			=	checkForNull(request.getParameter("treatment_area_code"));
		pract_id				=	checkForNull(request.getParameter("practitioner_id"));
		practitioner_name		=	checkForNull(request.getParameter("practitioner_name"));
		practitioner_name       =	java.net.URLDecoder.decode(practitioner_name,"UTF-8");
		patient_gender			=	checkForNull(request.getParameter("patient_gender"));
		bed_no					=	checkForNull(request.getParameter("bed_no"));
		brought_dead			=	checkForNull(request.getParameter("brought_dead"));
		bed_no=bed_no.trim();
		visit_type_code         =   checkForNull(request.getParameter("visit_type_code"));
	    pract_type              =   checkForNull(request.getParameter("pract_type"));
		priority_zone			=	checkForNull(request.getParameter("priority_zone"));

		isStartConsultationAppl	=	checkForNull(request.getParameter("isStartConsultationAppl"));//Added by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623
		
		/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
		isEnableDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","ENABLE_DATE_TIME"); 
		JSONObject jsonValue = eAE.AECommonBean.getRegistrationDate(con, facility_id, encounter_id);
		visit_adm_date_time	 = (String) jsonValue.get("visit_adm_date_time");
		/*End ML-MMOH-CRF-1133*/
	
		/*if(priority_zone.equals("R")) {pvr="Selected"; pvy="";pvg="";pvu="";}
		   else if(priority_zone.equals("Y")){pvr=""; pvy="Selected";pvg="";pvu="";}
				else if(priority_zone.equals("G")){pvr=""; pvy="";pvg="Selected";pvu="";}
                 else if(priority_zone.equals("U")){pvr=""; pvy="";pvg="";pvu="Selected";}*/
		patient_id				=	checkForNull(request.getParameter("patient_id"));
		regFlag					=	checkForNull(request.getParameter("regFlag"));

		//Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
		isPriorityAssgnTmtAreaAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "ADD_PRIORITY_ASSGN_TMTAREA");


		if(regFlag.equals("")) regFlag ="N";
		if(strCA != null)
		{
			if (strCA.equals("Y")){// Wednesday, June 02, 2010 PE_EXE venkat s
			StringBuffer sqlPatTri = new StringBuffer();
			sqlPatTri.append("select a.PATIENT_ID, a.treatment_area_code,a.practitioner_id,  a.priority_zone,a.ae_bed_no bed_no,TO_CHAR(a.queue_date,'dd/mm/yyyy') queue_date_time,   a.queue_status,   a.visit_type_code,  b.open_to_all_pract_yn, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1') practitioner_full_name, (case when a.practitioner_id is not null then (select pract_type from am_practitioner where practitioner_id = a.practitioner_id) end) pract_type,	TO_CHAR(d.date_of_birth,'dd/mm/yyyy') date_of_birth, CALCULATE_AGE(TO_CHAR(d.date_of_birth,'dd/mm/yyyy'),1) year,		CALCULATE_AGE(TO_CHAR(d.date_of_birth,'dd/mm/yyyy'),2) months, CALCULATE_AGE(TO_CHAR(d.date_of_birth,'dd/mm/yyyy'),3) days, d.sex , NVL((CASE   WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn  FROM ae_tmt_area_for_clinic  WHERE facility_id = a.facility_id  AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code)  END  ),'N') open_to_all_prac_for_clinic_yn,a.pat_priority from ae_current_patient a, op_clinic b, mp_patient d where a.facility_id = b.facility_id AND a.locn_code=b.clinic_code and a.patient_id=d.patient_id and a.facility_id = ? AND  a.encounter_id=?");
			
			pstmt		=	con.prepareStatement(sqlPatTri.toString());

			clinic_code				=	checkForNull(request.getParameter("location_code"));
			clinic_type				=	checkForNull(request.getParameter("location_type"));
			if(request.getParameter("option_id").equals("AE_REASSIGN_TA"))
			{
				selection_mode = "ReassignTreatmentArea";
			}
			episode_id			=	checkForNull(request.getParameter("episode_id"));
			
			pstmt.setString	(	1,	facility_id	);
			pstmt.setString	(	2,	encounter_id);
			rs					=	pstmt.executeQuery();
			
			
				while(rs.next())
				{

						patient_id = rs.getString("PATIENT_ID");
						open_to_all_pract_yn = checkForNull(rs.getString("open_to_all_pract_yn"));
						open_to_all_prac_for_clinic_yn =   checkForNull(rs.getString("open_to_all_prac_for_clinic_yn"));
						tmt_area_code		=	checkForNull(rs.getString("treatment_area_code"));	
						pract_id = checkForNull(rs.getString("practitioner_id"));
						practitioner_name = checkForNull(rs.getString("practitioner_full_name"));
						queue_date				=	checkForNull(rs.getString("queue_date_time"));
						queue_status			=	checkForNull(rs.getString("queue_status"));
						bed_no 		=	checkForNull(rs.getString("bed_no"));
					    priority_zone		    = checkForNull(rs.getString("priority_zone"));
					    priority_code		    = checkForNull(rs.getString("pat_priority")); //Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
		                
						/* if(priority_zone.equals("R")) {pvr="Selected"; pvy="";pvg="";pvu="";}
		                else if(priority_zone.equals("Y")){pvr=""; pvy="Selected";pvg="";pvu="";}
				        else if(priority_zone.equals("G")){pvr=""; pvy="";pvg="Selected";pvu="";}
                        else if(priority_zone.equals("U")){pvr=""; pvy="";pvg="";pvu="Selected";} */
					    patient_gender 		=	checkForNull(rs.getString("sex"));
					    year_value 		=	checkForNull(rs.getString("year"));
					

                        visit_type_code     =	checkForNull(rs.getString("visit_type_code"));
	                    pract_type          =	checkForNull(rs.getString("pract_type"));

				}

				
                if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();
				if((sqlPatTri != null) && (sqlPatTri.length() > 0))
				{
					sqlPatTri.delete(0,sqlPatTri.length());
				}
		}
	}
	   /* merged with below query for PE - 11/05/2010
	   StringBuffer sqlSpl = new StringBuffer();
	   sqlSpl.append("select SPECIALITY_CODE from op_clinic ");
	   sqlSpl.append(" where clinic_code=? and facility_id=? ");
       out.println(sqlSpl.toString());
       pstmt2				=	con.prepareStatement(sqlSpl.toString());
	 
	   pstmt2.setString(1,	clinic_code); 
	   pstmt2.setString(2,	 facility_id);
		 
		 rs2					=	pstmt2.executeQuery(); 
		 if (rs2.next())
			{
				speciality_code	=rs2.getString("speciality_code");
			}

	   if (rs2 != null)   rs2.close();
	   if (pstmt2 != null) pstmt2.close();  
	   if((sqlSpl != null) && (sqlSpl.length() > 0))
		{
			sqlSpl.delete(0,sqlSpl.length());
		} 
        
        
		pstmt			=	con.prepareStatement("select  TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth, CALCULATE_AGE(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1) year  from mp_patient where patient_id='"+patient_id+"' ");
		rs = pstmt.executeQuery();

		if(rs!= null &&  rs.next() )
		{
			year_value=rs.getString("year")==null?"":rs.getString("year");
		} 
        */

		 StringBuffer sqlVisitDt = new StringBuffer();
        sqlVisitDt.append("select to_char(a.queue_date,'dd/mm/yyyy hh24:mi') sys_date, to_char(sysdate,'dd/mm/yyyy hh24:mi') system_date, a.service_code, a.episode_id, a.OP_EPISODE_VISIT_NUM episode_visit_num, TO_CHAR(b.date_of_birth,'dd/mm/yyyy') date_of_birth, CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1) year, c.SPECIALITY_CODE,a.pat_priority from ae_current_patient a, mp_patient b, op_clinic c where a.FACILITY_ID=?  and  a.encounter_id=? and a.patient_id=? and a.patient_id = b.patient_id and a.FACILITY_ID = c.facility_id and a.locn_code = c.clinic_code");
		
		
		pstmt					=	con.prepareStatement(sqlVisitDt.toString());
		pstmt.setString(1,facility_id);
		pstmt.setString(2,encounter_id);
		pstmt.setString(3,patient_id);
		
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next())
        {
			visit_date_time=rs.getString("sys_date");
            sys_date_time=rs.getString("system_date");   
			service_code=rs.getString("service_code");
			episode_id=rs.getString("episode_id");
			episode_visit_num=rs.getString("episode_visit_num");
			year_value=rs.getString("year")==null?"":rs.getString("year");
			speciality_code	=rs.getString("speciality_code");
			priority_code = rs.getString("pat_priority"); //Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
		}
		 if (rs != null)   rs.close();
		 if (pstmt != null) pstmt.close();
	     if((sqlVisitDt != null) && (sqlVisitDt.length() > 0))
		 {
			sqlVisitDt.delete(0,sqlVisitDt.length());
		 }
		if(selection_mode.equals("AssignReassignPractitioner"))
		{
			tmt_area_prop			=	"disabled"; 
			bed_prop                =   "disabled";
			
        }

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strCA));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strCA));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(regFlag.equals("Y") && (!priority_zone.equals(""))) {  
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strCA));
            _bw.write(_wl_block15Bytes, _wl_block15);
if(isPriorityAssgnTmtAreaAppl){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
}else if(!priority_zone.equals("")){ 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strCA));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(isPriorityAssgnTmtAreaAppl){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tmt_area_prop));
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strCA));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(isPriorityAssgnTmtAreaAppl){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tmt_area_prop));
            _bw.write(_wl_block24Bytes, _wl_block24);
 }
            _bw.write(_wl_block25Bytes, _wl_block25);

	   sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER ";
				
			    pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rs    = pstmt.executeQuery();
				while(rs!=null && rs.next())
				{
				if(priority_zone.equals(rs.getString(1)))
				out.println("<option value='"+rs.getString(1)+"' selected>");	
			else
			   out.println("<option value='"+rs.getString(1)+"'>");	     
			   out.println(rs.getString(2));
			   out.println("</option>"); 
				}
		    
			
	   
            _bw.write(_wl_block26Bytes, _wl_block26);
if(isPriorityAssgnTmtAreaAppl){
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

					   
                       StringBuffer sqlpriority = new StringBuffer();
					   sqlpriority.append("select PRIORITY_CODE,SHORT_DESC from ");
					   sqlpriority.append("ae_pat_priority_lang_vw where language_id='"+locale+"'  and PRIORITY_ZONE=? and EFF_STATUS='E'");
	                     	
						sqlFinal = sqlpriority.toString();
					
						 pstmt = con.prepareStatement(sqlFinal);
						 pstmt.setString(1,priority_zone);
					     rs = pstmt.executeQuery();
						 while(rs !=null && rs.next())
						   {
							   if(rs.getString(1).equals(priority_code))
							   {
                                    optSelected = "selected";
							   }
							   else
								   optSelected="";

							   out.println("<option value='"+rs.getString(1)+"'"+optSelected+">"+rs.getString(2)+" ");
							  
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rs!=null) rs.close();
						 if((sqlpriority != null) && (sqlpriority.length() > 0))
						 {
							sqlpriority.delete(0,sqlpriority.length());
						 }
					   
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
if(regFlag.equals("Y") && (!priority_zone.equals(""))&& (!tmt_area_code.equals("")))
				{ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tmt_area_prop));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else if((!priority_zone.equals("")) && (!tmt_area_code.equals(""))){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tmt_area_prop));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else { 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tmt_area_prop));
            _bw.write(_wl_block38Bytes, _wl_block38);
 } 
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

	    StringBuffer sqlTreat = new StringBuffer();
		sqlTreat.append("SELECT TREATMENT_AREA_CODE,  SHORT_DESC,open_to_all_prac_for_clinic_yn  FROM AE_TMT_AREA_FOR_CLINIC_LANG_VW WHERE  language_id='"+locale+"'  and FACILITY_ID =? AND CLINIC_CODE =?  AND PRIORITY_ZONE=? and eff_status='E' and  (gender = ? OR gender IS NULL) order by 2");
		pstmt		=	con.prepareStatement(sqlTreat.toString());
		pstmt.setString(1,facility_id);
		pstmt.setString(2,clinic_code);
		pstmt.setString(3,priority_zone);
		pstmt.setString(4,patient_gender);

		rs			=	pstmt.executeQuery();
		while(rs.next())
		{
			treatment_area_code				=	rs.getString("TREATMENT_AREA_CODE");
			treatment_area_desc				=	rs.getString("SHORT_DESC");
			open_to_all_prac_for_clinic_yn	=	rs.getString("open_to_all_prac_for_clinic_yn");
			if(open_to_all_prac_for_clinic_yn==null)
				open_to_all_prac_for_clinic_yn	=	"N";
			if(tmt_area_code.equals(treatment_area_code))	
			{
				tmt_area_prop				=	"selected";
				treatAreaSel                = treatment_area_code;
				open_to_all_prac_for_clinic_ynSel =open_to_all_prac_for_clinic_yn;
			}
			else
			{
				tmt_area_prop	=	"";
			}

			
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tmt_area_prop));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(arrIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(arrIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(treatment_area_gender));
            _bw.write(_wl_block47Bytes, _wl_block47);

				arrIndex++;
		}  
		open_to_all_prac_for_clinic_yn = open_to_all_prac_for_clinic_ynSel;

		if(rs!=null) rs.close(); 
    	if (pstmt != null) pstmt.close();
		if((sqlTreat != null) && (sqlTreat.length() > 0))
		 {
			sqlTreat.delete(0,sqlTreat.length());
		 }


            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
 
	                StringBuffer sqlSev = new StringBuffer();

                    sqlSev.append("select SHORT_DESC from AM_SERVICE_LANG_VW WHERE language_id='"+locale+"' AND SERVICE_CODE =  ?");
					 pstmt1 = con.prepareStatement(sqlSev.toString());
					 pstmt1.setString(1,service_code);

					 rs1 = pstmt1.executeQuery();
					 if (rs1 != null)
					{
					 while (rs1.next())
						{
						
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rs1.getString("SHORT_DESC")));
            _bw.write(_wl_block51Bytes, _wl_block51);

						}
					}
					 if(pstmt1!=null)pstmt1.close();
		             if(rs1!=null)rs1.close();
					 if((sqlSev != null) && (sqlSev.length() > 0))
					 {
						sqlSev.delete(0,sqlSev.length());
					 }
				
	
            _bw.write(_wl_block52Bytes, _wl_block52);

		           // StringBuffer sqlBed = new StringBuffer(); Wednesday, June 02, 2010 PE_EXE venkat S
	                //sqlBed.append("select count(*) from ae_bed_for_trmt_area where FACILITY_ID= ? and  clinic_code= ? and  TREATMENT_AREA_CODE= ? and EFF_STATUS='E' ");
					pstmt1   = con.prepareStatement("select count(*) from ae_bed_for_trmt_area where FACILITY_ID= ? and  clinic_code= ? and  TREATMENT_AREA_CODE= ? and EFF_STATUS='E'");
					pstmt1.setString(1,facility_id);
					pstmt1.setString(2,clinic_code);
					pstmt1.setString(3,treatAreaSel);

					rs1		 = pstmt1.executeQuery(); 
					if(rs1!=null)
					{
						while(rs1.next())
							{
								countBed=rs1.getInt(1);
							}
					}
					if(pstmt1!=null) pstmt1.close();
		            if(rs1!=null) rs1.close(); 
			    
		
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bed_prop));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bed_prop));
            _bw.write(_wl_block56Bytes, _wl_block56);

		if (countBed > 0)
		{
		
            _bw.write(_wl_block57Bytes, _wl_block57);
}
		else
		{ 
		
            _bw.write(_wl_block58Bytes, _wl_block58);
} 
            _bw.write(_wl_block59Bytes, _wl_block59);
 /*Added by Rameswar on 12-Feb-16 for GDOH-CRF-081*/
		Boolean isPracApplicable	= eCommon.Common.CommonBean.isSiteSpecific(con, "AE","PRACT_MANDATORY_AE");//Dummy Column name
		if(isPracApplicable){
					
		if(tmt_area_code.equals("") || priority_zone.equals("U")){
			practitioner_name	= "";
			pract_id			= "";
		}
		}/*Added by Rameswar on 12-Feb-16 for GDOH-CRF-081*/		
		
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block63Bytes, _wl_block63);

			if ((selection_mode.equals("AssignReassignPractitioner")))
			{
		
            _bw.write(_wl_block64Bytes, _wl_block64);
	}else{
            _bw.write(_wl_block65Bytes, _wl_block65);
	}
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
if(!isEnableDateTimeAppl){
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(DateUtils.convertDate(sys_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block69Bytes, _wl_block69);
}else{
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(DateUtils.convertDate(sys_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block73Bytes, _wl_block73);
 if(strCA .equals("Y")) {
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
}else{
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(visit_date_time));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(selection_mode));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(tmt_area_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(episode_visit_num));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(enable_rights_yn));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(pract_type1));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(sel_triage_yn));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(sel_cons_yn));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(brought_dead));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(min_age_for_lmp));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(year_value));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(isStartConsultationAppl));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(isEnableDateTimeAppl));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block112Bytes, _wl_block112);
if(isPracApplicable){
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            _bw.write(_wl_block114Bytes, _wl_block114);
	}
	catch(Exception e) 
	{
		e.printStackTrace();			
	}
	finally 
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block115Bytes, _wl_block115);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PriorityZone.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayNo.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
