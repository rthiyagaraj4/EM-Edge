package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eCommon.Common.*;
import eAE.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __aempsearchcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEMPSearchCriteria.jsp", 1743071364172L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- Added/Modified On 11/8/2002 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n<html>\n<head>\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=8\" >\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n \n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEManagePatient.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script> \n<script language=\'javascript\' src=\'../../eAE/js/AEUtilities.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEPractitionerComponent.js\'></script>\n</head>\n<!--Maheshwaran K added loadFields() for ML-MMOH-CRF-1973 as on 07-07-2023-->\n<body onLoad=\"document.forms[0].clinic_code.focus();   popTreatmentCode(document.forms[0].clinic_code,\'\',\'\',\'\'); loadFields(); showAll();\" onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'> \n<center>\n<form name=\'AEMPSearchCriteriaForm\' id=\'AEMPSearchCriteriaForm\'>\n<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\'>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n \t <tr><td colspan=4 class=label height=5></td></tr>\n\t<tr>\n\t\t<td class=\'LABEL\' width=\'20%\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td class=\'fields\' width=\'20%\' ><select name=\'clinic_code\' id=\'clinic_code\'  onChange=\"popTreatmentCode(this,\'\',\'\',\'onChange\');\" >\n\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="----------</option> \n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t<script>parent.AEMPSearchCriteriaFrame.openToAllPractionerYN[";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="]=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\tparent.AEMPSearchCriteriaFrame.clinicType[";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\tparent.AEMPSearchCriteriaFrame.specialtyForClinc[";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\t</script>  \n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</select></td>\n\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<td class=\'LABEL\'  width=\'20%\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<!--//Maheshwaran K added - document.forms[0].bed_bay_type1.value for ML-MMOH-CRF-1973 as on 21-07-2023-->\n\t\t<td class=\'fields\' width=\'20%\' ><select name=\'treatment_area_code\' id=\'treatment_area_code\' onChange=\'popBayType(this,document.forms[0].bed_bay_type1.value);checkTreatmentGender()\'>\n\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="----------</option>\n\t ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<option selected value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<b></option>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<option value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' ><b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<b></option>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t \n\t\t\t\t <option value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<script language=\'javascript\'> \n\t\t\t\tparent.AEMPSearchCriteriaFrame.openToAllPractionerYN[";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\';\n\t\t\t\tself.treatmentGender[";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="] = \'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</select></td>\n\t\t<td class=\'LABEL\' width=\'20%\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t<td class=\'fields\' width=\'20%\'><select name=\'bed_bay_type\' id=\'bed_bay_type\' onChange=\'changeBedBayType(this)\'>\n\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="----------</option>\n\t\t</select></td>\n\t\t<td class=\'LABEL\' align=\'RIGHT\' colspan=\'2\'>&nbsp;<input type=\'image\'  value=\"-\" src=\'../../eAE/images/maximize.gif\' id=\"toggleId\" onClick=\'toggleCriteria(this)\'  alt=\"Maximize\" height=\"20\" width=\"20\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr id=\'maxCriteria1\' style=\'display:none\'>\n\t\t<td class=\'LABEL\' width=\"20%\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td> \n\t\t<!--//Maheshwaran K added -practitioner_id value for ML-MMOH-CRF-1973 as on 21-07-2023-->\n\t\t<td class=\'fields\' width=\"20%\"><input type=text name=practitioner_desc id=practitioner_desc size=30 maxlength=30 onBlur=\"beforeGetPractitioner2(practitioner_id,practitioner_desc);\" ><input type=hidden name=practitioner_id id=practitioner_id  value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"><input type=button class=button value=\'?\' name=Practitioner_lookup_button id=Practitioner_lookup_button onClick=\"getPractitioner2(practitioner_id,practitioner_desc);\"><input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\"\"></td>\n\t\t<td class=\'LABEL\'  width=\"20%\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t<!--//Maheshwaran K added -patient_id value for ML-MMOH-CRF-1973 as on 21-07-2023-->\n\t\t<td class=\'fields\' width=\"20%\"><input type=\'text\' name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" size=\'20\'  maxlength=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onKeyPress=\"return(CheckForSpecChars(event))\" onBlur=\"ChangeToUpper(this)\"><input type=\'button\' class=\'BUTTON\' value=\'?\' name=\'patient_search\' id=\'patient_search\' onClick = \'callPatientSearch()\'></td>\n\t\t<td class=\'LABEL\'  width=\"20%\" >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t<td class=\'fields\' width=\"20%\" ><select name=\'gender\' id=\'gender\'>\n\t\t<option value=\'\'>---------";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="---------</option>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\t\t\t\n\t\t\t<option value=\'M\' ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" selected ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option> \n\t\t\t<option value=\'F\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="  >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n\t\t\t<option value=\'U\' ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\t \n\t\t<option value=\'M\' >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</option> \n\t\t<option value=\'F\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</option>\n\t\t<option value=\'U\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</option>\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t</select></td>\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t<tr id=\'maxCriteria2\' style=\'display:none\'>\n\t\t<td class=\'LABEL\'  width=\'20%\' >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" </td>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t <td class=\'fields\' width=\"20%\"\t><input type=\'checkbox\' name=\'prev_visit\' id=\'prev_visit\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="  disabled></td>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t<td class=\'fields\' width=\"20%\"\t><input type=\'checkbox\' name=\'prev_visit\' id=\'prev_visit\' value=\'N\'  disabled></td>\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t<td class=\'LABEL\'  width=\'20%\' >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t<td class=\'fields\'  width=\"20%\"><input type=\'checkbox\' name=\'include_checkedout\' id=\'include_checkedout\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" width=\"25%\" disabled><input type=\'hidden\' name=\'order_by_priority\' id=\'order_by_priority\' value=\'\'></td>\n        ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t<td class=\'fields\'  width=\"20%\"><input type=\'checkbox\' name=\'include_checkedout\' id=\'include_checkedout\' value=\'N\' width=\"25%\" disabled><input type=\'hidden\' name=\'order_by_priority\' id=\'order_by_priority\' value=\'\'></td>\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n<tr id=\'maxCriteria2\' style=\'display:none\'>\n\t\t<td class=\'LABEL\'  width=\'20%\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<td  class=\'fields\'  width=\"20%\"><input type=\'checkbox\' name=\'prev_visit\' id=\'prev_visit\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="  onClick=\"enableVal(this)\" ></td>\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t<td  class=\'fields\'  width=\"20%\"><input type=\'checkbox\' name=\'prev_visit\' id=\'prev_visit\' value=\'Y\'  onClick=\"enableVal(this)\" ></td>\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t<td  class=\'fields\'  width=\"20%\"><input type=\'checkbox\' name=\'include_checkedout\' id=\'include_checkedout\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" onClick=\"enableVal(this)\" ><input type=\'hidden\' name=\'order_by_priority\' id=\'order_by_priority\' value=\'\'></td>\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t<td  class=\'fields\'  width=\"20%\"><input type=\'checkbox\' name=\'include_checkedout\' id=\'include_checkedout\' value=\'Y\' onClick=\"enableVal(this)\" ><input type=\'hidden\' name=\'order_by_priority\' id=\'order_by_priority\' value=\'\'></td>\n     ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="<td>&nbsp;</td>\n\t\t\t\n\t</tr>   \n\t\n\t <tr>\n\t \n\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>\n       <td class=\'fields\' width=\"25%\"><input type=\'button\' class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' name=\'refresh\' id=\'refresh\' onClick=\"showAll_observID();\" ></td> \n\t   <td colspan=2 class=label height=5></td>\n\t <td class=label height=5  width=\'25%\' align=\'right\' ><input  type=\'image\' value=\'Config Display Order\' src=\'../../eAE/images/config.jpeg\' onClick=\'configFieldOrder(this);\'  alt=\"Configure Display Order\" height=\"20\" width=\"20\">\n\t </td>\n\t </tr>\t\n\t  \n\t</table>\n\t<table id=\"trid\" border=\'1\'  align=\'left\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' style=\'white-space: nowrap;\'>\n\n\t<tr>\t\t\n\t<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->\n\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\t<!--//Kamatchi added for Zone Count for ML-MMOH-CRF-1973 as on 07-07-2023-->\n\t\t\t\t\t<td class=RESUSCITATION id=\"priority_zone_tab_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" alt=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"  align=center  style=\'cursor:pointer;background-color:";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =";\'nowrap onclick=\"FnShowPriorityWise(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\')\">&nbsp;";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="(";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =")";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'priority_zone_color_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' id=\'priority_zone_color_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t<input type=\'hidden\' name=\'priority_zone_all_codes\' id=\'priority_zone_all_codes\' id=\"priority_zone_all_codes\" value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' >\n\t<!--  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End-->\n\t<!--CRF  SKR-CRF-0021 [IN028173] end-->\n\t<!-- modified by Sangeetha for ML-MMOH-CRF-0642 on 28/apr/17 -->\n\t<td class=PATIENTLINECOLOR id=\"others\" align=center style=\'cursor:pointer\' alt=\"All\" onclick=\"showAll()\" nowrap><font color=\'white\' ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="style=\"font-weight:bold\" ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =">&nbsp;";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</font>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\t\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t<!-- modified by Sangeetha for ML-MMOH-CRF-0642 on 28/apr/17 -->\n\t<td id=\"nurse\"    align=center style=\'cursor:pointer;background-color:#FFCCCC\' alt=\"nursingUnit\" onclick=\"showNursingUnit()\"nowrap><font color=\'RED\' ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =">&nbsp; ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="&nbsp;</font></td>\t\t\n\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t<td class=RESUSCITATION id=\"priority_zone_tab_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\t<input type=\'hidden\' name=\'priority_zone_color_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t<td id=\"pendingForAdmTab\" align=center style=\'cursor:pointer;\' nowrap onclick=\"FnShowPriorityWise(\'for_admission\')\">&nbsp;";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="&nbsp;";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" \n\t\t\n\t\t<td style=\'width:210px;break-row;\' class=RESUSCITATION id=\"treatment_area_tab_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =";color:";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =";\' nowrap onclick=\"FnShowPriorityWise(\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\',\'TREAT_TAB\',\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\',\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\')\">&nbsp;\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t<input type=\'hidden\' name=\'treatment_tab_color_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' id=\'treatment_tab_color_";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n<input type=\'hidden\' name=\'treatment_area_all_codes\' id=\'treatment_area_all_codes\' id=\"treatment_area_all_codes\" value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' >\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="  \n\t<tr  id=\"ForIPAdmissionTab\" style=\'visibility:hidden\'>\t\n\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t<td class=RESUSCITATION id=\"for_priority_zone_tab_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\',\'IP_ADM\')\">&nbsp;";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n<td class=PATIENTLINECOLOR id=\"for_others\" name=\"for_others\" align=center style=\'cursor:pointer\' alt=\"All\" onclick=\"showAll(\'IP_ADM\')\" nowrap><font color=\'white\' style=\"font-weight:bold\">&nbsp;";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</font>(";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =")</td>\t\n</tr>  \n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t</table> \n\t</div>\n\t<script>\n\t//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023\n\tif(";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="){\n\tvar row_ht  =(";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="*18)+90;\t\n\tvar frset = parent.document.getElementsByTagName(\"frameset\")[0];\n\tfrset.rows =  row_ht+\"px, *\";\n\t}\n\t</script> \n\t<!-- Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17 -->\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n    <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n    <input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t<input type=\'hidden\' name=\'queue_refresh_interval\' id=\'queue_refresh_interval\' value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"> \n\t<input type=\'hidden\' name=\'patient_gender\' id=\'patient_gender\' value=\"\">\n\t<input type=\'hidden\' name=\'clinic_type\' id=\'clinic_type\' value=\"\">\n\t<input type=\'hidden\' name=\'checkout_yn\' id=\'checkout_yn\' value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t<input type=\'hidden\' name=\'p_cutoff_hours_prv_day_visit\' id=\'p_cutoff_hours_prv_day_visit\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t<input type=\'hidden\' name=\'first_open_to_all_pract_yn\' id=\'first_open_to_all_pract_yn\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\t<input type=\'hidden\' name=\'priority_zone\' id=\'priority_zone\' value=\"\">\n\t<input type=\'hidden\' name=\'orderCriteria\' id=\'orderCriteria\' value=\'queueDate\'>\n\t<input type=\'hidden\' name=\'orderCriteria_sensor\' id=\'orderCriteria_sensor\' value=\'queueDate\'>\n\t<input type=\'hidden\' name=\'asc_desc\' id=\'asc_desc\' value=\' asc\'>\n\t<input type=\'hidden\' name=\'asc_desc_sensor\' id=\'asc_desc_sensor\' value=\'\'>\n    <input type=\'hidden\' name=\'ch_id\' id=\'ch_id\' value=\'N\'>\n\t<input type=\'hidden\' name=\'maxRcd\' id=\'maxRcd\'  value=\"\" >\n\t<input type=\'hidden\' name=\'ch_x\' id=\'ch_x\' value=\'X\'>\n\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'\'>\n\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'\'>\n\t<input type=\'hidden\' name=\'current_state\' id=\'current_state\' value=\'\'>\n\t<input type=\'hidden\' name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n\t<input type=\'hidden\' name=\'observe_id\' id=\'observe_id\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n\t<input type=\'hidden\' name=\'five_level_triage_appl_yn\' id=\'five_level_triage_appl_yn\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t<input type=\'hidden\' name=\'isPendingForAdmissionAppl\' id=\'isPendingForAdmissionAppl\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'><!--Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658-->\n\t<input type=\'hidden\' name=\'isForAdmission\' id=\'isForAdmission\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'><!--Added by Kamatchi S for ML-MMOH-CRF-1972-->\n\t<input type=\'hidden\' name=\'enable_admission_tab\' id=\'enable_admission_tab\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'><!--Added by Kamatchi S for ML-MMOH-CRF-1972-->\n\t<input type=\'hidden\' name=\'sel_admission_yn\' id=\'sel_admission_yn\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'><!--Added by Kamatchi S for ML-MMOH-CRF-1972-->\n\t<input type=\'hidden\' name=\'isLengthOfStayAppl\' id=\'isLengthOfStayAppl\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'><!--Added by mujafar against ML-MMOH-CRF-1194-->\n\t<!-- //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023 -->\n\t<input type=\'hidden\' name=\'reattance_hours\' id=\'reattance_hours\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t<input type=\'hidden\' name=\'boldPriorityZoneTab\' id=\'boldPriorityZoneTab\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n\t<input type=\'hidden\' name=\'sortPriorityZoneTab\' id=\'sortPriorityZoneTab\' value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n\t<input type=\'hidden\' name=\'waitingTimeIndYN\' id=\'waitingTimeIndYN\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n\t<input type=\'hidden\' name=\'appear_as_tab_yn\' id=\'appear_as_tab_yn\' value=\"\">\n\t<input type=\'hidden\' name=\'treatment_area_code1\' id=\'treatment_area_code1\' value=\'\' > <!--Maheshwaran K added for ML-MMOH-CRF-1973 as on 05-07-2023-->\n\t<input type=\'hidden\' name=\'treatment_area_code2\' id=\'treatment_area_code2\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" > <!--Maheshwaran K added for ML-MMOH-CRF-1973 as on 05-07-2023-->\n\t<input type=\'hidden\' name=\'isAppearAsTabEnable\' id=\'isAppearAsTabEnable\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t<input type=\'hidden\' name=\'clinic_code2\' id=\'clinic_code2\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t<input type=\'hidden\' name=\'bed_bay_type1\' id=\'bed_bay_type1\' value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t<input type=\'hidden\' name=\'bed_bay_type2\' id=\'bed_bay_type2\' value=\'\'>\n\t<input type=\'hidden\' name=\'practitioner_id1\' id=\'practitioner_id1\' value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\t\n\t<input type=\'hidden\' name=\'patient_id1\' id=\'patient_id1\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t<input type=\'hidden\' name=\'gender1\' id=\'gender1\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t<input type=\'hidden\' name=\'prev_visit1\' id=\'prev_visit1\' value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\t \n\t<input type=\'hidden\' name=\'include_checkedout1\' id=\'include_checkedout1\' value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\t \n\t<input type=\'hidden\' name=\'locationArr\' id=\'locationArr\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'><!--Added by Kamatchi S for ML-MMOH-CRF-1972-->\n\t<input type=\'hidden\' name=\'treatmentArr\' id=\'treatmentArr\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'><!--Added by Kamatchi S for ML-MMOH-CRF-1972-->\n\t<input type=\'hidden\' name=\'enableSubTabForIPAdm\' id=\'enableSubTabForIPAdm\' value=\"N\">\n\t<input type=\'hidden\' name=\'treatmentTabValue\' id=\'treatmentTabValue\' value=\"N\">\n\t<input type=\'hidden\' name=\'toggleId1\' id=\'toggleId1\' value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t<!-- / Ends /Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023 -->\n</form>\n</center>  \n</body>\n";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n<SCRIPT LANGUAGE=\"JavaScript\">\n//Maheshwaran K added for the HSA-CRF-318\n\t//Start\n\tasync function configFieldOrder(object)\n\t{\n\t\tvar ret =await window.showModalDialog(\"../../eAE/jsp/AEMPSearchResultOrder.jsp\",\"\",\"title=Display;dialogHeight:451px;dialogWidth:270px;dialogTop=30;status:no\");\n\t\t//If The Display order is saved properly the value returned will be 0\n\t\tif (ret==\'0\')\n\t\t\t{\n\t\t\tparent.AEMPSearchCriteriaFrame.AEMPSearchCriteriaForm.current_state.value=\'All\';\n\t\t\tparent.AEMPSearchCriteriaFrame.AEMPSearchCriteriaForm.priority_zone.value=\'\';\n\t\t\tparent.AEMPSearchCriteriaFrame.showAll_observID();\n\t\t\t}\n\t}\nfunction toggleCriteria(object)\n{\nvar function_id=parent.AEMPSearchCriteriaFrame.AEMPSearchCriteriaForm.function_id.value;\n\tif (object.value==\"-\")\n\t{\n\t\tobject.value=\"+\";\n\t\tobject.src=\"../../eAE/images/minimise.gif\";\n\t\tobject.alt=\"Minimize\";\t\t\n\t\tif(function_id==\'AE_MANAGE_PATIENT\')\n\t\t//parent.AECurEmerFrameset.rows=\"21.5%,*\";\n\t\t\tparent.document.getElementById(\'AEMPSearchCriteriaFrame\').style.height = \"24vh\";\n\t\t\tparent.document.getElementById(\'AEMPSearchResultFrame\').style.height = \"76vh\";\n\t\tif(function_id==\'AE_CHECK_OUT\')\n\t//\tparent.AECurEmerFrameset.rows=\"22.5%,*\";\n\t\t\tparent.document.getElementById(\'AEMPSearchCriteriaFrame\').style.height = \"13vh\";\n\t\t\tparent.document.getElementById(\'AEMPSearchResultFrame\').style.height = \"87vh\";\n\t\tparent.AEMPSearchCriteriaFrame.maxCriteria1.style=\"display\";\n\t\tparent.AEMPSearchCriteriaFrame.maxCriteria2.style=\"display\";\n\t\t\n\t}\n\telse\n\t{\n\t\tobject.value=\"-\";\n\t\tobject.src=\"../../eAE/images/maximize.gif\";\n\t\tobject.alt=\"Maximize\";\n\t\tif(function_id==\'AE_MANAGE_PATIENT\')\n\t\t//parent.AECurEmerFrameset.rows=\"12.5%,*\";\n\t\tparent.document.getElementById(\'AEMPSearchCriteriaFrame\').style.height = \"12vh\";\n\t\tparent.document.getElementById(\'AEMPSearchResultFrame\').style.height = \"87vh\";\n\t\tif(function_id==\'AE_CHECK_OUT\')\n\t\t//parent.AECurEmerFrameset.rows=\"13%,*\";\n\t\tparent.document.getElementById(\'AEMPSearchCriteriaFrame\').style.height = \"13vh\";\n\t\tparent.document.getElementById(\'AEMPSearchResultFrame\').style.height = \"87vh\";\n\t\tparent.AEMPSearchCriteriaFrame.maxCriteria1.style.display=\'none\';\n\t\tparent.AEMPSearchCriteriaFrame.maxCriteria2.style.display=\'none\';\n\t}\n\tdocument.getElementById(\"toggleId1\").value=object.value;\n}\n//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023\n//Starts\nfunction loadFields()\n\t{\n\tvar isAppearAsTabEnable =document.forms[0].isAppearAsTabEnable.value;\n\tif(isAppearAsTabEnable==\"true\" || isAppearAsTabEnable==true) {\n\tpopBayType(document.forms[0].treatment_area_code.value,document.forms[0].bed_bay_type1.value);\n\tbeforeGetPractitioner2(document.forms[0].practitioner_desc,document.forms[0].practitioner_id);\nif(\tdocument.getElementById(\"toggleId1\").value == \"Y\")\n\ttoggleCriteria1(\"-\");\n\t}\n\t}\nfunction toggleCriteria1(object)\n{\nvar function_id=parent.AEMPSearchCriteriaFrame.AEMPSearchCriteriaForm.function_id.value;\n\tif (object==\"-\")\n\t{\n\t\tobject=\"+\";\n\t\tobject.src=\"../../eAE/images/minimise.gif\";\n\t\tobject.alt=\"Minimize\";\t\nif(function_id==\'AE_MANAGE_PATIENT\')\n\t\tparent.AECurEmerFrameset.rows=\"21.5%,*\";\n\t\tif(function_id==\'AE_CHECK_OUT\')\n\t\tparent.AECurEmerFrameset.rows=\"22.5%,*\";\t\t\n\t\tparent.AEMPSearchCriteriaFrame.maxCriteria1.style=\"display\";\n\t\tparent.AEMPSearchCriteriaFrame.maxCriteria2.style=\"display\";\n\t}\n\telse\n\t{\n\t\tobject=\"-\";\n\t\tobject.src=\"../../eAE/images/maximize.gif\";\n\t\tobject.alt=\"Maximize\";\n\t\tif(function_id==\'AE_MANAGE_PATIENT\')\n\t\tparent.AECurEmerFrameset.rows=\"12.5%,*\";\n\t\tif(function_id==\'AE_CHECK_OUT\')\n\t\tparent.AECurEmerFrameset.rows=\"13%,*\";\t\n\t\tparent.AEMPSearchCriteriaFrame.maxCriteria1.style.display=\'none\';\n\t\tparent.AEMPSearchCriteriaFrame.maxCriteria2.style.display=\'none\';\n\t}\n}\t\n//Ends\t\n</SCRIPT>\n\n\n\n</html>\n<!--//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023-->\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
	public static Integer checkForNull1(Integer inputString, Integer defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}


 public HashMap getRecordCount(PageContext pageContext,Connection con,String facility_id,String  clinic_type,String clinic_code, String orderCriteria,String treatment_area_code,String bed_bay_type, String practitioner_id,String patient_id, String patient_gender,String include_checkedout, String priority_zone, String p_cutoff_hours_prv_day_visit, String oper_stn_id,String checkout_yn, String asc_desc, String observe_id, String maxRecord, String ch_id, String ch_x, String oberv_clinc_code, String locationArr1, String treatmentArr,String enableSubTabForIPAdm,String all_common_code,String login_user_id) throws java.sql.SQLException     
	{  
		String returnString="";
		HashMap countMap = new HashMap();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		String locale = (String)session.getAttribute("LOCALE"); // added by mujafar for ML-MMOH-CRF-0632
		StringBuffer getZoneCount= null;
		StringBuffer queryStat = new StringBuffer();
		Properties p=(java.util.Properties) session.getValue("jdbc");
		String locationCode1 = "";
		String treatment_area_desc = "";
		Integer admissionCount=0;
		String priorVal = "";
		String nursingCode = "";
		HashMap<String, Integer> priorityMap = new HashMap<String, Integer>();
		HashMap<String, Integer> priorityMapForAdm = new HashMap<String, Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Integer> treatMap = new HashMap<String, Integer>();
		int zoneU = 0;
		int zoneR = 0;
		int zoneG = 0;
		int zoneY = 0;
		int zoneUForAdm = 0;
		int zoneRForAdm = 0;
		int zoneGForAdm = 0;
		int zoneYForAdm = 0;
		int clinicCount = 0;
		StringBuffer whereClause    = new StringBuffer();
		StringBuffer orderByClause  = new StringBuffer();
		StringBuffer byObserveId_criteria  = new StringBuffer();
		StringBuffer byObserveId_criteria1  = new StringBuffer();
		PreparedStatement pstmt=null;
		ResultSet rs    = null; 
		PreparedStatement pstmt1=null;
		ResultSet rs1    = null; 
		PreparedStatement pstmt2=null;
		ResultSet rs2    = null; 
		int	columnIndex	= 1;
		int	totRec =	0;
		int max = 0;
		int treatmentAreaCount=0;
		String pendngadmdatetime = "";
		StringBuffer sqlPatQ1        = new StringBuffer();
		StringBuffer sqlForAdmVal = new StringBuffer();
		String sqlForAdmPat        = "";
		StringBuffer whereClause1   = new StringBuffer();
		StringBuffer orderByClause1  = new StringBuffer();
	//	 treatment_area_code		= checkForNull((String)	request.getParameter("treatment_area_code"));
	//	String bed_bay_type     = checkForNull((String)	request.getParameter("bed_bay_type")); 
	//	String patient_id     = checkForNull((String)request.getParameter("patient_id")); 
	//	String patient_gender      = checkForNull((String)request.getParameter("patient_gender")); 
		if(include_checkedout.equals("") || include_checkedout.equals("Y") ) include_checkedout="N"; 
		Boolean isLengthOfStayAppl      = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "LENGTH_OF_STAY_APPL");  
		Boolean isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//Added by Kamatchi S for ML-MMOH-CRF-1972 
		String prev_visit   = checkForNull((String)request.getParameter("prev_visit"));
		//if(prev_visit.equals("Y") ) prev_visit=""; 
		String reattance_hour         = checkForNull((String)request.getParameter("reattance_hours"));
		String register_reattance_hours="";
		int reattance_hours=0;
		//if(reattance_hour.equals(""))
	//	{
			try{
		register_reattance_hours=AEReattendanceEncounterDetails.getAEReattendanceDetails(con,facility_id,p);
		if(!register_reattance_hours.equals("")) reattance_hours=Integer.parseInt(register_reattance_hours);
			}
			catch(Exception e)
				{
					e.printStackTrace();
				}
	//	}
		String five_level_triage_appl_yn      =checkForNull((String)request.getParameter("five_level_triage_appl_yn"));
		if(five_level_triage_appl_yn.equals("") ) five_level_triage_appl_yn="N";//For five_level_triage_appl_yn in AEMPSearchResult.jsp value get by this method
		//String sortPriorityZoneTab      =(String)request.getParameter("sortPriorityZoneTab");
		Boolean sortPriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "SORT_PRIORITY_ZONE_TAB");
		if(asc_desc.equals("")) asc_desc="asc";
		Boolean waitingTimeIndYN			=	eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "WAITING_TIME_INDICATOR");
		if(ch_id.equals("N")) ch_id="";
		String ret_str     = checkForNull((String)request.getParameter("ch_x"));
		if(ret_str.equals("X")) ret_str=""; 
		String priority_status     = checkForNull((String)request.getParameter("priority_zone"));//priority_zone and priority_status same value
		String priority     = "";
		String admission_cnt     = "0";
		String oberv_TMT_code = "";//checkForNull((String)request.getParameter("oberv_clinc_code"));//oberv_clinc_code and oberv_TMT_code same value
		String priority_zone1 ="";
		String priority_zone_all_codes		= (request.getParameter("priority_zone_all_codes")==null || request.getParameter("priority_zone_all_codes")=="")?"":request.getParameter("priority_zone_all_codes");
		String loginUser			= checkForNull((String)session.getValue("login_user"));
		try { 
		StringBuilder priority_zone_order	 = new StringBuilder();
		if(!priority_zone_all_codes.equals("")){
		if (priority_zone_all_codes.length() > 0 && priority_zone_all_codes.charAt(priority_zone_all_codes.length()-1)==',') {
		priority_zone_all_codes = priority_zone_all_codes.substring(0, priority_zone_all_codes.length()-1);
		}
		String[] priority_zone_split = priority_zone_all_codes.split(",");
		for (int  x= 0; x < priority_zone_split.length; x++) {
		priority_zone_order.append("'"+priority_zone_split[x]+"',"+(x+1));
		if (x!= priority_zone_split.length - 1) {
		priority_zone_order.append(",");
		}
		}
		}
		if(priority_status.equals("for_admission") && orderCriteria.equals("")){orderCriteria="zone" ;}//priority_status
		else{if(orderCriteria.equals("")) orderCriteria="queueDate" ;}//orderCriteria
	/*	if (checkout_yn.equals("N")){
			if (observe_id.equals("C") && !oberv_clinc_code.equals("")) //checkout_yn,observe_id, oberv_clinc_code,facility_id
		{
			System.err.println("first if==============");
			byObserveId_criteria1.append("and a.locn_code='"+oberv_clinc_code+"'");
			}
		else if(observe_id.equals("T") && !oberv_TMT_code.equals("")){
			//observe_id . oberv_TMT_code
			System.err.println("second if==============");
		byObserveId_criteria1.append("and a.treatment_area_code='"+oberv_TMT_code+"'");
		}
		else{ if(!priority_status.equals("for_admission") && !priority_status.equals("")){if(observe_id.equals("T")){//priority_status,observe_id
		System.err.println("third if==============");
		byObserveId_criteria1.append("and  (a.TREATMENT_AREA_CODE not in(select nursing_unit_code from ae_param where operating_facility_id='"+facility_id+"' and  ae_observe_battery_id = '"+observe_id+"') or a.treatment_area_code is null )  "); 
		}
		//else{byObserveId_criteria1.append("and  (a.locn_code not in(select nursing_unit_code from ae_param where operating_facility_id='"+facility_id+"' and  ae_observe_battery_id = '"+observe_id+"') or a.locn_code is null  )");}
		}} 
		} */
		if(!(clinic_code.equals(""))) whereClause1.append(" and a.locn_code = ? and a.locn_type = ? "); //Clinic code
		if(!(treatment_area_code.equals(""))){whereClause1.append(" and a.treatment_area_code = ? ");} //treatment_area_code
		if(!(bed_bay_type.equals(""))){whereClause1	.append(" and d.bay_type_code = ? ");} //bed_bay_type
		if(!(practitioner_id.equals("")))		whereClause1.append(" and a.practitioner_id = ? "); //practitioner_id
		if(!(patient_id.equals("")))			whereClause1.append(" and a.patient_id = ? "); //patient_id
		if(!(priority.equals("")))				whereClause1.append(" and a.priority_indicator = ? "); //priority-always empty assign in code
		if(!(patient_gender.equals("")))		whereClause1.append(" and b.sex = ? "); //patient_gender
		if(include_checkedout.equals("Y"))		whereClause1.append(" and a.queue_status <= '07' ");//include_checkedout
		if(include_checkedout.equals("N"))		whereClause1.append(" and a.queue_status < '07' ");//include_checkedout
		if(!priority_status.equals("")){
		if(priority_status.equals("for_admission")) 
			{ 
			//whereClause1.append(" and a.PENDNG_ADMISSION_DATE_TIME IS NOT NULL ");//priority_status 
			}
		else if(priority_status.equals("observe") && isLengthOfStayAppl )
			{
			whereClause1.append("");
			} //isLengthOfStayAppl
		else {
			//whereClause1.append(" and a.priority_zone = '"+priority_status+"' ");
			}
		}
		if(!prev_visit.equals("") )//prev_visit	
		{whereClause1.append(" and (a.check_in_date_time between trunc(SYSDATE) -((1/(24*60*60))*3600*'"+p_cutoff_hours_prv_day_visit+"') and		trunc(sysdate)) ");}else{whereClause1.append(" AND SYSDATE BETWEEN a.check_in_date_time AND (("+reattance_hours+"/24)+(a.check_in_date_time))");}
		whereClause1.append(" and  (a.locn_type, a.locn_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = '"+facility_id+"' and Oper_stn_id ='"+oper_stn_id+"' and  appl_user_id ='"+loginUser+"' ");
		
	
		whereClause1.append((checkout_yn.equals("Y"))?"and checkout_pat_yn = 'Y'":"and manage_queue_yn = 'Y' ");//checkout_yn
		whereClause1.append(" )"); 
	//	if(enableSubTabForIPAdm.equals("Y")){whereClause1.append(" AND A.PENDNG_ADMISSION_DATE_TIME IS NOT NULL ");	}
		if(!priority_zone_order.toString().equals("") && five_level_triage_appl_yn.equals("Y")){//priority_zone_order(check comments), five_level_triage_appl_yn
		orderByClause1.append(" DECODE(priority_zone,"+priority_zone_order.toString()+")asc,queue_date_time desc ");}
		if(orderByClause1.length() > 0){orderByClause1.append(" , ");}
		if(!priority_status.equals("for_admission")){//priority_status
		if(sortPriorityZoneTab){orderByClause1.append(" locn_desc,treatment_area_code,practitioner_name ");//sortPriorityZoneTab
		}else{orderByClause1.append(" locn_desc,treatment_area_code ");}}
		if(orderCriteria.matches("practitioner||queueDate||bed_no||patientName||patientId||age||status||priorityZone||waitingTime||zone||for_admission")){if(orderByClause1.length() > 0) orderByClause1.append(" , ");
		if(orderCriteria.equals("practitioner")){orderByClause1.append("practitioner_name"+asc_desc+" ");}else if(orderCriteria.equals("queueDate"))
		{orderByClause1.append("queue_date_time ");orderByClause1.append(""+asc_desc+" ");}
		else if(orderCriteria.equals("bed_no")){if(sortPriorityZoneTab)//sortPriorityZoneTab
		{if(priority_zone.equals("Y") || priority_zone.equals("R") )//priority_zone
		{orderByClause1.append(""+asc_desc+" ");}else{orderByClause1.append("a.AE_BED_NO ");orderByClause1.append(""+asc_desc+" ");}}else{
		orderByClause1.append("a.AE_BED_NO "); orderByClause1.append(""+asc_desc+" ");}}
		else if(orderCriteria.equals("patientName")){orderByClause1.append("b.patient_name"+asc_desc+" ");}
		else if(orderCriteria.equals("patientId")){orderByClause1.append("a.patient_id"+asc_desc+" ");}
		else if(orderCriteria.equals("age")){orderByClause1.append("year "+asc_desc+" ");}
		else if(orderCriteria.equals("status")){orderByClause1.append("a.QUEUE_STATUS"+asc_desc+" ");}
		else if(orderCriteria.equals("priorityZone")){orderByClause1.append(" PAT_PRIORITY_DESC"+asc_desc+" ");}
		else if(orderCriteria.equals("waitingTime")){orderByClause1.append("a.QUEUE_DATE ");orderByClause1.append(""+asc_desc+" ");}
		else if(orderCriteria.equals("zone")){
		if(asc_desc.equals(" asc")){orderByClause1.append("DECODE(a.PRIORITY_ZONE, 'G', 1, 'Y', 2, 'R', 3, 'U', 4) ASC");} 
		else if(asc_desc.equals(" desc")){orderByClause1.append("DECODE(a.PRIORITY_ZONE, 'R', 1, 'Y', 2, 'G', 3, 'U', 4) ASC");}
		if(priority_status.equals("for_admission")) orderByClause1.append(" queue_date_time DESC");//priority_status
		}else if(orderCriteria.equals("for_admission")){orderByClause1.append(" PENDNG_ADMISSION_DATE_TIME "); orderByClause1.append(""+asc_desc+" ");}}
		if(priority_status.equals("for_admission") && orderCriteria.equals("locType")){//priority_status
		orderByClause1.append(" locn_desc "); orderByClause1.append(""+asc_desc+" ");}
		sqlPatQ1.append("select a.rowid row_id,a.locn_code, c.long_desc locn_desc,a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name,  to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time,  a.priority_zone , ");//locale
		sqlPatQ1.append("  (SELECT SUM(CASE WHEN a.pendng_admission_date_time IS NOT NULL THEN 1   ELSE 0   END) FROM DUAL )   AS admission_cnt , ");
		//sqlPatQ1.append(" (SELECT SUM(CASE WHEN ( (f.assign_bed_num IS NOT NULL OR f.adt_status in ('08','09')) AND (f.patient_class ='IP' OR f.patient_class ='DC')) then 1 ELSE 0 END)  from pr_encounter f  where f.facility_id = a.facility_id   AND f.patient_id = a.patient_id ) as admission_cnt , ");
		//sqlPatQ1.append(" (SELECT SUM(CASE WHEN ( f.ATTEND_PRACTITIONER_ID is not null) then 1 ELSE 0 END) from ip_open_encounter f where f.facility_id = a.facility_id   AND f.patient_id = a.patient_id ) as admission_cnt , ");
		if(include_checkedout.equals("Y")) //include_checkedout
		sqlPatQ1.append(" to_char(a.PENDNG_ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') pendngAdmDateTime, get_waiting_time(NVL (a.DISCHARGE_DATE_TIME, SYSDATE), a.PENDNG_ADMISSION_DATE_TIME) pendngForAdmissionTime ");
		else
		sqlPatQ1.append(" to_char(a.PENDNG_ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') pendngAdmDateTime, get_waiting_time(SYSDATE, a.PENDNG_ADMISSION_DATE_TIME) pendngForAdmissionTime ");
	 	if(include_checkedout.equals("Y")){sqlPatQ1.append(" from  op_patient_queue a, mp_patient b, op_clinic_lang_vw c ");}else{//include_checkedout
		sqlPatQ1.append(" from  ae_current_patient a, mp_patient b, op_clinic_lang_vw c ");}
		if(!(bed_bay_type.equals(""))){sqlPatQ1.append(" ,ae_bed_for_trmt_area d ");}//bed_bay_type 
		if(include_checkedout.equals("Y")){sqlPatQ1.append(" where a.patient_class = 'EM' and ");}//include_checkedout
		else{sqlPatQ1.append(" where ");}	
		if(ch_id.equals("Y")){sqlPatQ1.append("  a.rowid in('"+ret_str+"') and ");}//ch_id,ret_str
		sqlPatQ1.append("   a.facility_id = ?  and a.facility_id = c.facility_id and  a.patient_id = b.patient_id  and c.language_id = '"+locale+"'  and a.facility_id=c.facility_id and a.locn_code = c.clinic_code  ");//locale
		if(!(bed_bay_type.equals(""))){
		sqlPatQ1.append(" and a.facility_id=d.facility_id AND a.locn_code=d.CLINIC_CODE AND a.TREATMENT_AREA_CODE=d.TREATMENT_AREA_CODE AND a.AE_BED_NO=d.bed_no  AND d.occupying_patient_id IS NOT NULL ");}
		
		sqlPatQ1.append(whereClause1);	
		sqlPatQ1.append(byObserveId_criteria1);	
		sqlPatQ1.append(" ORDER BY ");  
		sqlPatQ1.append(orderByClause1);
		System.err.println("Criteria count ==========================================================="+sqlPatQ1.toString());
		pstmt		=	con.prepareStatement(sqlPatQ1.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
  	pstmt.setString	(	1,	facility_id		);
		if(!(clinic_code.equals("")))	
			{
			pstmt.setString	(	++columnIndex,	clinic_code	);
			pstmt.setString	(	++columnIndex,	clinic_type	);
			}
		if(!(treatment_area_code.equals("")))	
			pstmt.setString	(	++columnIndex,	treatment_area_code	);
		if(!(bed_bay_type.equals("")))				
			pstmt.setString	(	++columnIndex,	bed_bay_type	);
		if(!(practitioner_id.equals("")))	
			pstmt.setString	(	++columnIndex,	practitioner_id	);
		if(!(patient_id.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_id	);
		if(!(priority.equals("")))	
			pstmt.setString	(	++columnIndex,	priority	);
		if(!(patient_gender.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_gender	);	
	/*	System.err.println("clinic_code==================="+clinic_code);
		System.err.println("clinic_type==================="+clinic_type);
		System.err.println("treatment_area_code==================="+treatment_area_code);
		System.err.println("bed_bay_type==================="+bed_bay_type);
		System.err.println("practitioner_id==================="+practitioner_id);
		System.err.println("patient_id==================="+patient_id);
		System.err.println("priority==================="+priority);
		System.err.println("patient_gender==================="+patient_gender);
	System.err.println("===============final*******321*********************======");*/
		try
			{
			String sql = "select priority_zone from ae_priority_zone where eff_status='E'";
			String sql2 = "select NURSING_UNIT_CODE from ae_param where OPERATING_FACILITY_ID = '"+facility_id+"'";
			pstmt1		=	con.prepareStatement(sql);
			rs1	=	pstmt1.executeQuery();
			while(rs1 != null && rs1.next())
				{
				priorVal = checkForNull(rs1.getString( "priority_zone" ));
				priorityMap.put(priorVal,0);
				priorityMapForAdm.put(priorVal,0);
				}
			if (pstmt1 != null) pstmt1.close();	
			if (rs1!=null) rs1.close();
			pstmt1		=	con.prepareStatement(sql2);
			rs1	=	pstmt1.executeQuery();
			if(rs1 != null && rs1.next())
				{
				nursingCode = checkForNull(rs1.getString( "NURSING_UNIT_CODE" ));
				}
			if (pstmt1 != null) pstmt1.close();	
			if (rs1!=null) rs1.close();			
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}  

		//ArrayList<String> locationArr =  (ArrayList)request.getParameter("locationArr"); 		
		String treatmentStr = treatmentArr;
		treatmentStr=treatmentStr.substring(1, treatmentStr.length() - 1);
		String[] treatArr = treatmentStr.split(", ");
		for(int i =0;i<treatArr.length;i++){
			if(treatArr[i]!=null && treatArr[i] !="") {
			treatMap.put(treatArr[i],0);
			}
		}
		String firstClinic = treatArr[0];
		try {
			rs	=	pstmt.executeQuery();	
			while(rs != null && rs.next()) 
				{
				if(max == 0) 
					{
					priority_zone1 = checkForNull(rs.getString( "priority_zone" ));
					locationCode1 = checkForNull(rs.getString( "locn_code" ));
					pendngadmdatetime = checkForNull(rs.getString( "pendngadmdatetime"));
					treatment_area_desc = checkForNull(rs.getString( "treatment_area_desc" ));
					String treatment_area_code4 =checkForNull(rs.getString( "treatment_area_code" ));
					admission_cnt =checkForNull(rs.getString( "admission_cnt" ));
					totRec = rs.getRow();
					if(observe_id.equals("T")){
							if(all_common_code.equals(treatment_area_code4)){
							treatmentAreaCount++;
							}
					}
					if(observe_id.equals("C")){
							if(all_common_code.equals(locationCode1)){
							clinicCount++;
							}		
					}
				//	if(admission_cnt.equals("0")){
					if(!pendngadmdatetime.equals(""))
						{
						admissionCount++;
						//To get for Admission Zone count
						if(priorityMapForAdm.get(priority_zone1)!=null) 
							{
							priorityMapForAdm.put(priority_zone1, priorityMapForAdm.get(priority_zone1) + 1);
							}
						}
				//	}
					//else if(locationArr!=null && nursingCode.equals(locationCode1))
						else if(  nursingCode.equals(locationCode1))
						{
						if(map.containsKey(locationCode1)) {
						map.put(locationCode1, map.get(locationCode1) + 1);
						} else {
						map.put(locationCode1, 1);
						}
						} 
					if(priorityMap.get(priority_zone1)!=null) 
						{
						priorityMap.put(priority_zone1, priorityMap.get(priority_zone1) + 1);
						}
						if(treatMap.containsKey(treatment_area_desc)) {
							treatMap.put(treatment_area_desc, treatMap.get(treatment_area_desc) + 1);
						} else {
							if(treatment_area_desc!=null && treatment_area_desc!="null" && treatment_area_desc!=""){
							treatMap.put(treatment_area_desc, 1);
							}
						}
					}
				}
			if (pstmt != null) pstmt.close();	
			if (rs!=null) rs.close();				
			}
		catch(Exception e) {
		e.printStackTrace();
		}

		try 
			{	
			for(String c: priorityMap.keySet()) {
			if(c.equals("U")) zoneU = (int) priorityMap.get(c);
			if(c.equals("R")) zoneR = (int) priorityMap.get(c);
			if(c.equals("G")) zoneG = (int) priorityMap.get(c);
			if(c.equals("Y")) zoneY = (int) priorityMap.get(c);
			}		
			for(String c1: priorityMapForAdm.keySet()) {
			if(c1.equals("U")) zoneUForAdm = (int) priorityMapForAdm.get(c1);
			if(c1.equals("R")) zoneRForAdm = (int) priorityMapForAdm.get(c1);
			if(c1.equals("G")) zoneGForAdm = (int) priorityMapForAdm.get(c1);
			if(c1.equals("Y")) zoneYForAdm = (int) priorityMapForAdm.get(c1);
			}
		/*	for(String d: map.keySet()) {
			clinicCount = map.get(d);
			}		*/	
			countMap.put("zoneU",zoneU);
			countMap.put("zoneR",zoneR);
			countMap.put("zoneG",zoneG);
			countMap.put("zoneY",zoneY);
			countMap.put("zoneUForAdm",zoneUForAdm);
			countMap.put("zoneRForAdm",zoneRForAdm);
			countMap.put("zoneGForAdm",zoneGForAdm);
			countMap.put("zoneYForAdm",zoneYForAdm);
			countMap.put("allRec",totRec);
			countMap.put("clinicCount",clinicCount);
			countMap.put("admissionCount",admissionCount);
			countMap.put("treatMap",treatMap);
			countMap.put("treatmentAreaCount",treatmentAreaCount);			
			System.err.println("totRec============================================"+totRec);
			returnString =totRec+","+zoneU+","+zoneR+","+zoneG+","+zoneY+","+clinicCount+","+admissionCount+","+treatMap;
			System.err.println("criteria cout =============="+totRec+","+zoneU+","+zoneR+","+zoneG+","+zoneY+","+clinicCount+","+admissionCount);
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
	}
	catch(Exception e2) { 
		e2.printStackTrace();
	}                   
		//For Nursing Unit Count 
		StringBuffer sqlPatQ2        = new StringBuffer();
	 StringBuffer whereClause2    = new StringBuffer();
	/*	  String  admission_date_time       = "";
     String  encounter_id			   = "";
     String  patient_id                = "";
     String  observe_id                = "";
     String  gender            = "";
    // String  bed_bay_type              = "";
	 String  patient_name              = "";
     String  Sex                       = "";
     String  nursing_unit_short_desc   = "";
     String  bed_class_short_desc      = "";
     String  bed_type_short_desc       = "";
     String  bed_no                    = "";
     String  room_no                   = "";
    // String  location_desc             = "";
	 String nursing_unit_code          = "";
	 String facility_id                = "";
	 String login_user_id			   = "";
	 String oper_stn_id                = "";
	 String	from 					   = "",		to 						=	"";
	 String CAInstalled                = "";
	 String classValue                 = "";
	 patient_id			=	checkForNull(request.getParameter("patient_id"));
	 observe_id			=	checkForNull(request.getParameter("observe_id"));
	 gender		=	checkForNull(request.getParameter("gender"));*/
	 try {
	 int nursingCount =0;
	 System.err.println("nursing_unit_code1===================================="+all_common_code);
	  System.err.println("nursingCount===================================="+nursingCount);
	 if(observe_id.equals("N")) {
	 sqlPatQ2.append(" SELECT count(1) AS recordCount  FROM ip_open_encounter a, mp_patient c   WHERE facility_id = ?  AND a.patient_id = c.patient_id");
			sqlPatQ2.append(whereClause);	
			sqlPatQ2.append(" AND a.nursing_unit_code = ? AND a.adt_status IN ('01', '02') AND nursing_unit_code IN ( SELECT a.nursing_unit_code FROM ip_nursing_unit a, am_os_user_locn_access_vw b WHERE a.facility_id = a.facility_id AND a.facility_id = b.facility_id AND a.nursing_unit_code = b.locn_code AND a.locn_type = b.locn_type AND b.locn_type = 'N' AND a.eff_status = 'E' AND b.oper_stn_id = ? AND b.appl_user_id = ?)     AND a.oth_adt_status IS NULL AND a.ip_leave_status IS NULL AND facility_id = a.facility_id");
            pstmt		=	con.prepareStatement(sqlPatQ2.toString());
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	all_common_code	);
			pstmt.setString	(	3,	oper_stn_id		);
			pstmt.setString	(	4,	login_user_id		);
			System.err.println("sqlPatQ2.toString()=================="+sqlPatQ2.toString());
           System.err.println("facility_id " +facility_id);
		    System.err.println("all_common_code " +all_common_code);
			 System.err.println("oper_stn_id " +oper_stn_id);
			  System.err.println("login_user_id " +login_user_id);
			rs			=	pstmt.executeQuery();	
			if(rs!=null && rs.next())
			{
				nursingCount=rs.getInt("recordCount");
			}
			countMap.put("nursingCount",nursingCount);
			System.err.println("nursingCount????????????????????======="+nursingCount);
				if (pstmt != null) pstmt.close();	
			if (rs!=null) rs.close();			
		}
	 }
	 catch(Exception e)
		{
		e.printStackTrace();
		}
		//Ends  For Nursing Unit Count
        	return countMap;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	request.setCharacterEncoding("UTF-8");
	String locale							= (String)session.getAttribute("LOCALE");
	String	facility_id						=	"";
	String	login_user_id					=	"",		clinic_type				=	"";
	String	oper_stn_id						=	"";
	String	open_to_all_pract_yn			=	"";
	String	queue_refresh_interval			=	"";	
	String	treatment_area_gender			=	"",		selected_prop			=	"";
	String  checkout_yn						=	"";
	String	open_to_all_prac_for_clinic_yn	=	"";
	String	first_clinic_code				=	"";		
	String	first_open_to_all_pract_yn		=	"";
	String where_condition					=	"";
	String pid_length						=	"";
	String sys_date							=	"";
	String p_cutoff_hours_prv_day_visit		=	"";
	String function_id						=	"";
	String nursing_unit_code				=	"";
	String observe_id						=	"";
	String nursing_unit_desc 				=	"";
	String orderCriteria 				    =	"";
		int tab_row_cnt=1;
	/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	String color                            =   "";
	String non_critical                     =   "";
	String critical                         =   "";
	String semi_critical                    =   "";
	String unassigned                       =   "";
	String sql                              =   "";
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
	String priority_zone_code				= "";
	String priority_zone_desc			= "";
	String priority_zone_color			= "";
	String priority_zone_all_codes		= "";
	String treatment_area_all_codes		= "";
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	String	treatment_area_code				=	"",		treatment_area_desc		=	"";
	String	clinic_code						=	"",		clinic_desc				=	"";
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
	//Starts
	String treatment_area_code2="";
	String bed_bay_type	=	"";
	String bed_bay_type1 =	"";
	String patient_id="";
	String patient_id1="";
	String gender="";
	String gender1="";
	String toggleValue="N";
	String practitioner_id="";
	String practitioner_id1="";
	String include_checkedout="";
	String include_checkedout1="";
	String prev_visit="";
	String prev_visit1="";
	String priorityTab = "";
	String clinic_code2="";
	String appear_as_tab_yn = "";
	String include_chk_status="";
	String prev_visit_status="";
	Boolean isAppearAsTabEnable  =false;  	
	String selectedLocationCode="";
	int zoneU	=0;
	int zoneR	=0;
	int zoneG	=0;
	int zoneY	=0;
	int zoneUForAdm	=0;
	int zoneRForAdm	=0;
	int zoneGForAdm	=0;
	int zoneYForAdm	=0;
	int allRec	=0;
	int clinicCount	=0;
	int admissionCount	=0;
	int nursingCount=0;
	int treatmentAreaCount=0;
	int allCommonCount=0;
	HashMap<String, Integer> treatmentMap = new HashMap<String, Integer>();	
	String	short_desc ="";
	String	tab_colour ="";
	String tab_font_colour ="";
	String treat_area_code="";
	int tab_count=0;
	int first_tab_cnt=0;
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
	//Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
	String priority_zone_desc_unassign			= "";
	String priority_zone_color_unassign			= "";
	String priority_zone_code_unassign			= "";
	
	/* CRF  SKR-CRF-0021 [IN028173] end  */
    int countRec1 =0;
	int		rowIndex						=	1;

	Boolean isPendingForAdmissionAppl	= false;//Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658
	Boolean boldPriorityZoneTab	= false;//Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658
	Boolean isForAdmission	= false;//Added by Kamatchi S for ML-MMOH-CRF-1972
	JSONObject forAdmissionValue = new JSONObject();
	String enable_admission_tab = "N";
	String sel_admission_yn = "";
	Boolean isLengthOfStayAppl = false; // added by mujafar for ML-MMOH-CRF-1194 
	//Added by Kamatchi S for ML-MMOH-CRF-1972 as on 21-07-2023
	Boolean sortPriorityZoneTab = false;
	Boolean waitingTimeIndYN	= false;
	String register_reattance_hours="";
	int reattance_hours=0;
	Properties p=(java.util.Properties) session.getValue("jdbc");
	ArrayList<String> locationArr = new ArrayList<String>();                                     
	ArrayList<String> treatmentArr = new ArrayList<String>();
	//Ends

	try
	{
		con				=	(Connection)	ConnectionManager.getConnection(request);
		//Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/2017
		boldPriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "BOLD_PRIORITY_ZONE_TAB");//For SLY
		//Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
		Boolean rearrangePriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "REARRANGE_PRIORITY_ZONE_TAB");

		isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_PENDING_FOR_ADMISSION_TAB");//Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658
		isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//Added by Kamatchi S for ML-MMOH-CRF-1972
		isLengthOfStayAppl      = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "LENGTH_OF_STAY_APPL"); // for SLY added by mujafar for ML-MMOH-CRF-1194

		facility_id		=	(String)		session.getValue("facility_id");
		isAppearAsTabEnable  = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","AE_TREATMENT_AREA_TAB"); //Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		clinic_code=checkForNull(request.getParameter("clinic_code"));
			clinic_code2=clinic_code;
		if(isAppearAsTabEnable){
			
			treatment_area_code=checkForNull(request.getParameter("treatment_area_code"));
			treatment_area_code2=treatment_area_code;
			bed_bay_type=checkForNull(request.getParameter("bed_bay_type"));
				bed_bay_type1=checkForNull(request.getParameter("bed_bay_type1"));
			/*	if(bed_bay_type.equals("")) {
			bed_bay_type=bed_bay_type1;
		}
		if(!bed_bay_type1.equals("")) {
			bed_bay_type=bed_bay_type1;
		} */
			bed_bay_type1=bed_bay_type;
			patient_id=checkForNull(request.getParameter("patient_id"));
			patient_id1=patient_id;
			practitioner_id=checkForNull(request.getParameter("practitioner_id"));
			practitioner_id1=practitioner_id;
			gender=checkForNull(request.getParameter("gender"));
			gender1=gender;
			toggleValue=checkForNull(request.getParameter("toggleId1"));
			include_checkedout=checkForNull(request.getParameter("include_checkedout"),"N");
			include_checkedout1=include_checkedout;
			prev_visit=checkForNull(request.getParameter("prev_visit"),"N");
			prev_visit1=prev_visit;
			priorityTab = checkForNull(request.getParameter("priority_zone"));
		}
		//ENds
		Map<String, String> colorMap = new HashMap<String, String>();
		Map<String, String> colorFontMap = new HashMap<String, String>();
		colorMap.put("G", "Green");
		colorMap.put("R", "Red");
		colorMap.put("Y", "Yellow");
		colorMap.put("U", "ORANGE");
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		if(isAppearAsTabEnable){
		colorMap.put("PR", "Purple");
		colorMap.put("BR", "Brown");
		colorMap.put("BL", "Blue");
		colorMap.put("DB", "#00008B");
		colorMap.put("MG", "Magenta");
		colorMap.put("PK", "Pink");
		colorMap.put("CY", "Cyan");
		colorMap.put("GY", "Grey");		
		colorFontMap.put("G", "Green");
		colorFontMap.put("R", "Red");
		colorFontMap.put("Y", "Yellow");
		colorFontMap.put("U", "ORANGE");
		colorFontMap.put("PR", "White");
		colorFontMap.put("BR", "White");
		colorFontMap.put("BL", "White");
		colorFontMap.put("DB", "White");
		colorFontMap.put("MG", "White");
		colorFontMap.put("PK", "Black");
		colorFontMap.put("CY", "Black");
		colorFontMap.put("GY", "White");
		}
		//Ends
		//Added by Kamatchi S for ML-MMOH-CRF-1972 as on 21-07-2023
		//Starts
		if(isAppearAsTabEnable){
		register_reattance_hours=AEReattendanceEncounterDetails.getAEReattendanceDetails(con,facility_id,p);
		if(!register_reattance_hours.equals(""))reattance_hours=Integer.parseInt(register_reattance_hours);
		sortPriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "SORT_PRIORITY_ZONE_TAB");
		waitingTimeIndYN			=	eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "WAITING_TIME_INDICATOR");
		}
		//Ends
		StringBuffer sqlNursingUnit = new StringBuffer();
		observe_id = request.getParameter("observe_id")==null?"":request.getParameter("observe_id");
		pid_length = request.getParameter("pid_length")==null?"20":request.getParameter("pid_length");		
		login_user_id	=	(String)		session.getValue("login_user");
		function_id =	request.getParameter("function_id") ;
		if(function_id==null) function_id="";
		if(function_id.equals("AE_MANAGE_PATIENT"))
		first_tab_cnt=7;
		if(function_id.equals("AE_CHECK_OUT"))
		first_tab_cnt=6;
        oper_stn_id     = request.getParameter("oper_stn_id") ;
        if(oper_stn_id==null) oper_stn_id="";
		sys_date     = request.getParameter("sys_date") ;
        if(sys_date==null) sys_date="";
		p_cutoff_hours_prv_day_visit     = request.getParameter("p_cutoff_hours_prv_day_visit") ;
        if(p_cutoff_hours_prv_day_visit==null) p_cutoff_hours_prv_day_visit="";
		queue_refresh_interval	=	(request.getParameter("queue_refresh_interval")==null)? "0" : request.getParameter("queue_refresh_interval"); 
		checkout_yn	=	request.getParameter("checkout_yn") ;
		if(checkout_yn==null) checkout_yn="N";
		nursing_unit_code =	request.getParameter("nursing_unit_code") ;
		if(nursing_unit_code==null) nursing_unit_code="";
		orderCriteria =	request.getParameter("orderCriteria") ;
		if(orderCriteria==null) orderCriteria="";
		if(isForAdmission){
		forAdmissionValue = eAE.AECommonBean.getForAdmissionValue(con, facility_id, login_user_id);
		enable_admission_tab = (String) forAdmissionValue.get("enable_admission_tab");
		sel_admission_yn = (String) forAdmissionValue.get("sel_admission_yn");
		}
		where_condition=(checkout_yn.equals("Y"))?"and checkout_pat_yn = 'Y'":"and manage_queue_yn = 'Y' ";

		if(!observe_id.equals("")&&!nursing_unit_code.equals("")) {
			if (observe_id.equals("N")) 	{
				sqlNursingUnit.append("select  short_desc from ip_nursing_unit_lang_vw");
				sqlNursingUnit.append(" where facility_id = ? and nursing_unit_code = ? ");
			}else if (observe_id.equals("C")) 	{
				sqlNursingUnit.append("select  short_desc from op_clinic_lang_vw");
				sqlNursingUnit.append(" where facility_id = ? and clinic_code= ? ");
			}else if (observe_id.equals("T")) {
				sqlNursingUnit.append("select  short_desc from ae_tmt_area_for_clinic");
				sqlNursingUnit.append(" where facility_id = ? and TREATMENT_AREA_CODE= ? ");
			}

			pstmt		=	con.prepareStatement(sqlNursingUnit.toString());
			pstmt.setString	(1,	facility_id);
			pstmt.setString	(2,	nursing_unit_code);
			rs			=	pstmt.executeQuery();

			if(rs.next()) {
				nursing_unit_desc			=	rs.getString("short_desc");
			}
			 if(pstmt!=null) pstmt.close();
			 if(rs!=null) rs.close();
			 if((sqlNursingUnit != null) && (sqlNursingUnit.length() > 0)) {
				sqlNursingUnit.delete(0,sqlNursingUnit.length());
			}
		}

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		StringBuffer sqlLoc = new StringBuffer();

    		sqlLoc.append("select a.clinic_code, a.long_desc clinic_desc,  a.clinic_type, a.open_to_all_pract_yn,a.speciality_code  from op_clinic_lang_vw a, (select day_no from  sm_day_of_week where day_of_week =  rtrim(to_char(sysdate,'DAY'))) b where 	 decode(b.day_no,'1',working_day_1,'2', working_day_2,'3',working_day_3,'4',  working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y'   and a.facility_id = ? and a.clinic_type in  (select locn_type  from am_care_locn_type where care_locn_type_ind='C')   and a.level_of_care_ind = 'E'   and a.language_id='"+locale+"'  and a.eff_status = 'E'  and  (a.clinic_type, a.clinic_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = ? and Oper_stn_id = ? and  appl_user_id = ?   ");
			sqlLoc.append(where_condition);
			sqlLoc.append(" ) order by 2  ");
			pstmt		=	con.prepareStatement(sqlLoc.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	facility_id		);
			pstmt.setString	(	3,	oper_stn_id		);
			pstmt.setString	(	4,	login_user_id	);
			rs			=	pstmt.executeQuery();
			if(rs != null)
			  {
					  rs.last();
					  countRec1 = rs.getRow();
					  rs.beforeFirst();
			  }
			  if(countRec1==1) selected_prop ="selected";
			  else selected_prop ="";
			selectedLocationCode = clinic_code;
			String spec_code="";
			while(rs.next())
			{
				clinic_code				=	rs.getString("clinic_code");
				clinic_desc				=	rs.getString("clinic_desc");
				clinic_type				=	rs.getString("clinic_type");
				open_to_all_pract_yn	=	rs.getString("open_to_all_pract_yn");
				spec_code	=	rs.getString("speciality_code");
				//Added by Kamatchi S for ML-MMOH-CRF-1972 as on 21-07-2023
				if(isAppearAsTabEnable){
				locationArr.add(clinic_code);
				}
				if(rowIndex==1) 
				{
					first_clinic_code			=	clinic_code;
					first_open_to_all_pract_yn	=	open_to_all_pract_yn;
				 
				}
				else 
				{
					//selected_prop	=	"";
				}
				//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
				//Starts
				if(isAppearAsTabEnable) {
				if(clinic_code2.equals(clinic_code))
					{
					clinic_code=clinic_code2;
					selected_prop ="selected";	
					}
				else {
					selected_prop ="";
					}	
				}
				
				//Ends
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(selected_prop));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(spec_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
			
				rowIndex++;
			}
		    if(rs!=null) rs.close();
			if(pstmt!=null)	pstmt.close();
			if((sqlLoc != null) && (sqlLoc.length() > 0))
			 {
				sqlLoc.delete(0,sqlLoc.length());
			 }
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			rowIndex				=	1;
		//	clinic_code				=	(selectedLocationCode==null || selectedLocationCode.equals(""))?first_clinic_code:selectedLocationCode;
            StringBuffer sqlTrtA    = new StringBuffer();

			sqlTrtA.append("select treatment_area_code, short_desc treatment_area_desc,gender treatment_area_gender,  open_to_all_prac_for_clinic_yn  from ae_tmt_area_for_clinic_lang_vw where language_id='"+locale+"' and facility_id = ?  and CLINIC_CODE = ?  and eff_status = 'E'  order by 2 ");
			pstmt		=	con.prepareStatement(sqlTrtA.toString());

			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	clinic_code2		);

			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				treatment_area_code				=	rs.getString("treatment_area_code");
				treatment_area_desc				=	rs.getString("treatment_area_desc");
				treatment_area_gender			=	rs.getString("treatment_area_gender");
				open_to_all_prac_for_clinic_yn	=	rs.getString("open_to_all_prac_for_clinic_yn");
			
				if(treatment_area_gender==null)				treatment_area_gender			=	"";
				if(open_to_all_prac_for_clinic_yn==null)	open_to_all_prac_for_clinic_yn	=	"N";
				//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
				//Starts
				if(isAppearAsTabEnable) {
				if(treatment_area_code2.equals(treatment_area_code))
				{			
				treatment_area_code=treatment_area_code2;
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
			else {
				
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);

				}
				} else {
				//Ends
				
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(treatment_area_gender));
            _bw.write(_wl_block34Bytes, _wl_block34);

				rowIndex++;
			} // end of while
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
            if((sqlTrtA != null) && (sqlTrtA.length() > 0))
		    {
				sqlTrtA.delete(0,sqlTrtA.length());
		    }
		
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(pid_length));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

		if(isAppearAsTabEnable) { 
			
            _bw.write(_wl_block45Bytes, _wl_block45);
if(gender.equals("M")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
if(gender.equals("F")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
if(gender.equals("U")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
 
		}
		else {
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block56Bytes, _wl_block56);

		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
		if(isAppearAsTabEnable)
			{ 
			if(include_checkedout.equals("Y"))
			{
			include_chk_status="checked";	
			}
			if(prev_visit.equals("Y"))
			{
			prev_visit_status="checked";	
			}
			}
		 if(function_id.equals("AE_REC_PAT_VAL")){
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

		//Maheshwaran K added -prev_visit_status, prev_visit values ,include_checkedout,include_chk_status for ML-MMOH-CRF-1973 as on 21-07-2023
		if(isAppearAsTabEnable){ 
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(prev_visit));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(prev_visit_status));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
		else {
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
if(isAppearAsTabEnable){ 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(include_checkedout));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(include_chk_status));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
		else {
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
}else{
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
if(isAppearAsTabEnable){ 
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(prev_visit));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(prev_visit_status));
            _bw.write(_wl_block70Bytes, _wl_block70);
}
		else {
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
if(isAppearAsTabEnable){ 
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(include_checkedout));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(include_chk_status));
            _bw.write(_wl_block73Bytes, _wl_block73);
}
		else {
            _bw.write(_wl_block74Bytes, _wl_block74);

		}
		}
		
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Refresh.label","common_labels")));
            _bw.write(_wl_block76Bytes, _wl_block76);

		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
		//Starts
		if(isAppearAsTabEnable){ 		
		try {
			String ch_id="N";
			String asc_desc="asc";
			String ch_x="X";
			String priority_zone="";
			String locationArr1="";
			HashMap returnVal=getRecordCount(pageContext,con, facility_id,"C",clinic_code2, orderCriteria,treatment_area_code2, bed_bay_type1,practitioner_id,patient_id,gender, include_checkedout, priority_zone, p_cutoff_hours_prv_day_visit, oper_stn_id,checkout_yn, asc_desc, observe_id, "",  ch_id,  ch_x,  clinic_code2, locationArr1,  treatmentArr.toString(),"N",nursing_unit_code,login_user_id);
			zoneU			= checkForNull1((Integer)returnVal.get("zoneU"),0);
			zoneR			= checkForNull1((Integer)returnVal.get("zoneR"),0);
			zoneG			= checkForNull1((Integer)returnVal.get("zoneG"),0);
			zoneY			= checkForNull1((Integer)returnVal.get("zoneY"),0);
			zoneUForAdm			= checkForNull1((Integer)returnVal.get("zoneUForAdm"),0);
			zoneRForAdm			= checkForNull1((Integer)returnVal.get("zoneRForAdm"),0);
			zoneGForAdm			= checkForNull1((Integer)returnVal.get("zoneGForAdm"),0);
			zoneYForAdm			= checkForNull1((Integer)returnVal.get("zoneYForAdm"),0);
			allRec			= checkForNull1((Integer)returnVal.get("allRec"),0);
			clinicCount		= checkForNull1((Integer)returnVal.get("clinicCount"),0);
			admissionCount	= checkForNull1((Integer)returnVal.get("admissionCount"),0);
			nursingCount	= checkForNull1((Integer)returnVal.get("nursingCount"),0);
			treatmentAreaCount	= checkForNull1((Integer)returnVal.get("treatmentAreaCount"),0);
			treatmentMap = (HashMap)returnVal.get("treatMap");
				if (observe_id.equals("N")) 	{
				allCommonCount =nursingCount;
			}else if (observe_id.equals("C")) 	{
				allCommonCount =clinicCount;
			}else if (observe_id.equals("T")) {
			allCommonCount =treatmentAreaCount;	
			}
			}
		catch(Exception e )
			{
			e.printStackTrace();
			}
		}
		//Ends
				/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
				sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC,PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E' ";
	 			if(!five_level_triage_appl_yn.equals("Y")){
	 				sql	= sql + "  and priority_zone not in ('B','W') ";
				}
	 			sql= sql + " order by PRIORITY_ZONE_ORDER asc";
				pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rs    = pstmt.executeQuery();
				while(rs!=null && rs.next())
				{
					priority_zone_code	= rs.getString("PRIORITY_ZONE");
					priority_zone_desc	= rs.getString("PRIORITY_ZONE_TAB_DESC");
					priority_zone_color = (rs.getString("PRIORITY_ZONE_COLOR")==null || rs.getString("PRIORITY_ZONE_COLOR")=="")?"":rs.getString("PRIORITY_ZONE_COLOR");
				 	if(priority_zone_color.equals("")){
				 		priority_zone_color	= colorMap.get(priority_zone_code);
				 	}
				 	priority_zone_all_codes	= priority_zone_all_codes + priority_zone_code + ",";
					//START  Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017 
					if(rearrangePriorityZoneTab && priority_zone_code.equals("U")){ 
							priority_zone_color_unassign = priority_zone_color;
							priority_zone_desc_unassign  = priority_zone_desc;
							priority_zone_code_unassign  = priority_zone_code;
				   }else{
				 
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(priority_zone_color));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
if(isForAdmission)
					{if(priority_zone_code.equals("R")){
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(zoneR));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
					else if(priority_zone_code.equals("Y")){
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(zoneY));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
					else if(priority_zone_code.equals("G")){
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(zoneG));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
					else if(priority_zone_code.equals("U")){
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(zoneU));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
					}
					else {
            out.print( String.valueOf(priority_zone_desc));
}
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(priority_zone_color));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
				
				}
				//END  Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017 
				if (pstmt != null){
					pstmt.close();
				}
				if (rs!=null){
					rs.close();
				}
	
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(priority_zone_all_codes));
            _bw.write(_wl_block89Bytes, _wl_block89);
if(boldPriorityZoneTab){}else{
            _bw.write(_wl_block90Bytes, _wl_block90);
 } 
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
if(isForAdmission)
{
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(allRec));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block93Bytes, _wl_block93);
if(!nursing_unit_desc.equals("")){
            _bw.write(_wl_block94Bytes, _wl_block94);
if(boldPriorityZoneTab){}else{
            _bw.write(_wl_block90Bytes, _wl_block90);
 } 
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(nursing_unit_desc));
if(isForAdmission)
	{
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(allCommonCount));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block96Bytes, _wl_block96);
}
	//Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
	if(rearrangePriorityZoneTab){
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(priority_zone_code_unassign));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(priority_zone_desc_unassign));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(priority_zone_color_unassign));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(priority_zone_code_unassign));
            _bw.write(_wl_block81Bytes, _wl_block81);
if(isForAdmission)
	{if(priority_zone_code_unassign.equals("U")){
            out.print( String.valueOf(priority_zone_desc_unassign));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(zoneU));
            _bw.write(_wl_block83Bytes, _wl_block83);
}}
	else {
            out.print( String.valueOf(priority_zone_desc_unassign));
}
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(priority_zone_code_unassign));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(priority_zone_code_unassign));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(priority_zone_color_unassign));
            _bw.write(_wl_block99Bytes, _wl_block99);
} 

	/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
	//if condition is modified for ML-MMOH-CRF-1972 by Kamatchi S
	if(isPendingForAdmissionAppl || (isForAdmission && enable_admission_tab.equals("Y") && sel_admission_yn.equals("Y"))){
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
if(isForAdmission)
	{
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(admissionCount));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block102Bytes, _wl_block102);
}/*End*/ 
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	//Starts
	try {
		if(isAppearAsTabEnable) {
		//Added for ML-MMOH-CRF-1973
		sql="SELECT TREATMENT_AREA_CODE,short_desc, appear_as_tab_yn, tab_colour FROM ae_tmt_area_for_clinic WHERE appear_as_tab_yn = 'Y' AND facility_id =? AND clinic_code =?  and treatment_area_code=NVL(?,treatment_area_code) and eff_status = 'E' "; 
		pstmt   = con.prepareStatement(sql.toString());
		pstmt.setString(1,facility_id) ;
		pstmt.setString(2,clinic_code2) ;
		pstmt.setString	(	3,	treatment_area_code2		);
		rs    = pstmt.executeQuery();							
		while(rs!=null && rs.next())
			{
			short_desc	= rs.getString("short_desc");
			appear_as_tab_yn	= rs.getString("appear_as_tab_yn");
			tab_colour	= rs.getString("tab_colour");
			treat_area_code	= rs.getString("TREATMENT_AREA_CODE");
			treatmentArr.add(short_desc);
			tab_font_colour	= colorFontMap.get(tab_colour);
			tab_colour	= colorMap.get(tab_colour);
			treatment_area_all_codes = treatment_area_all_codes + treat_area_code + ",";
			if(appear_as_tab_yn.equals("Y")){
				if(!treat_area_code.equals(nursing_unit_code)) {   
		
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(treat_area_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(tab_colour));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(tab_font_colour));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(treat_area_code));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(appear_as_tab_yn));
            _bw.write(_wl_block108Bytes, _wl_block108);
if(isForAdmission)
	{
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf((treatmentMap.get(short_desc)!=null)?treatmentMap.get(short_desc):0));
            _bw.write(_wl_block83Bytes, _wl_block83);
}else{
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(short_desc));
}
            _bw.write(_wl_block109Bytes, _wl_block109);

		tab_count++;
		if((tab_count==3 && first_tab_cnt==6 && function_id.equals("AE_CHECK_OUT")) || (tab_count==2 && first_tab_cnt==7 && function_id.equals("AE_MANAGE_PATIENT")))	
			{
			tab_count=0;
			out.println("</tr>");
			out.println("<tr  width='15%'>");
			first_tab_cnt=0;
			tab_row_cnt++;
			}
		else if(tab_count==9)
			{
			tab_count=0;
			out.println("</tr>");
			out.println("<tr  width='15%'>");	
			tab_row_cnt++;
			}	 			
			}	 			
		}
	else {		
	out.println("</tr>");	
	}
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(treat_area_code));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(treat_area_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(tab_colour));
            _bw.write(_wl_block112Bytes, _wl_block112);

	}
	
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(treatment_area_all_codes));
            _bw.write(_wl_block114Bytes, _wl_block114);

	}
	if (pstmt != null){
	pstmt.close();
	}
	if (rs!=null){
	rs.close();
	} 
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
 
	//Ends //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	if(isForAdmission){
	
            _bw.write(_wl_block115Bytes, _wl_block115);
	try {
			sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC,PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E' ";
			if(!five_level_triage_appl_yn.equals("Y")){
			sql	= sql + "  and priority_zone not in ('B','W') ";
			}
			sql= sql + " order by PRIORITY_ZONE_ORDER asc";
			pstmt   = con.prepareStatement(sql.toString());
			pstmt.setString(1,locale) ;
			rs    = pstmt.executeQuery();
			//	 rs.beforeFirst(); 
			while(rs!=null && rs.next())
			{
			priority_zone_code	= rs.getString("PRIORITY_ZONE");
			priority_zone_desc	= rs.getString("PRIORITY_ZONE_TAB_DESC");
			priority_zone_color = (rs.getString("PRIORITY_ZONE_COLOR")==null || rs.getString("PRIORITY_ZONE_COLOR")=="")?"":rs.getString("PRIORITY_ZONE_COLOR");
			if(priority_zone_color.equals("")){
			priority_zone_color	= colorMap.get(priority_zone_code);
			}
			priority_zone_all_codes	= priority_zone_all_codes + priority_zone_code + ",";

			
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(priority_zone_color));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block117Bytes, _wl_block117);

			if(priority_zone_code.equals("R")){
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(zoneRForAdm));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
			else if(priority_zone_code.equals("Y")){
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(zoneYForAdm));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
			else if(priority_zone_code.equals("G")){
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(zoneGForAdm));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
			else if(priority_zone_code.equals("U")){
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(zoneUForAdm));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
			else {
            out.print( String.valueOf(priority_zone_desc));
}
            _bw.write(_wl_block118Bytes, _wl_block118);

			}
			if (pstmt != null){
				pstmt.close();
			}
			if (rs!=null){
				rs.close();
			}
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(admissionCount));
            _bw.write(_wl_block121Bytes, _wl_block121);
}
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(isAppearAsTabEnable));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(tab_row_cnt));
            _bw.write(_wl_block124Bytes, _wl_block124);
	}
	catch(Exception e)
	{
		e.printStackTrace() ;
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(queue_refresh_interval));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(checkout_yn));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(p_cutoff_hours_prv_day_visit));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(first_open_to_all_pract_yn));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(observe_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(five_level_triage_appl_yn));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(isPendingForAdmissionAppl));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(isForAdmission));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(enable_admission_tab));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(sel_admission_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(isLengthOfStayAppl));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(reattance_hours));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(boldPriorityZoneTab));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(sortPriorityZoneTab));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(waitingTimeIndYN));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(treatment_area_code2));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(isAppearAsTabEnable));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(clinic_code2));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(bed_bay_type1));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(practitioner_id1));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(gender1));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(prev_visit1));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(include_checkedout1));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(locationArr));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(treatmentArr));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(toggleValue));
            _bw.write(_wl_block158Bytes, _wl_block158);
            _bw.write(_wl_block159Bytes, _wl_block159);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayType.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreviousDayVisitsOnly.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.IncludeCheckOutPat.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreviousDayVisitsOnly.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.IncludeCheckOutPat.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.for.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
