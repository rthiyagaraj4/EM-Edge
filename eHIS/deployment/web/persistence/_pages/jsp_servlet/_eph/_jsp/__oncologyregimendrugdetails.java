package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import eOR.*;
import eOR.Common.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __oncologyregimendrugdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/OncologyRegimenDrugDetails.jsp", 1732876948521L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" <!-- // java.text.DecimalFormat Added for ML-MMOH-SCF-1060 -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\' ></SCRIPT>\n\t\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></SCRIPT>\n\t\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></SCRIPT>\n\t\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\' ></SCRIPT>\n\t\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../ePH/js/OncologyRegimen.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"onCologyRegimenDrugDetails\" id=\"onCologyRegimenDrugDetails\">\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t<input type=\"hidden\" name=\"start_date\" id=\"start_date\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<input type=\"hidden\" name=\"resp_id\" id=\"resp_id\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t<input type=\"hidden\" name=\"pract_name\" id=\"pract_name\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t<input type=\"hidden\" name=\"locn_type\" id=\"locn_type\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<input type=\"hidden\" name=\"locn_code\" id=\"locn_code\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t<input type=\"hidden\" name=\"problem_ind\" id=\"problem_ind\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"7\" class=\'COLUMNHEADER\'><font style=\"font-size:9\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font></th> \n\t\t\t\t\t</tr>\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"8%\"  class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</TD>\n\t\t\t\t\t\t<td width=\"35%\" class=\"DATA\" id=\"DRUGDESC\" nowrap><input name=\"drug_name\" id=\"drug_name\" type=\"text\" size=\"40\" maxlength=\"60\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" ><input type=\"button\" value=\"?\" onclick=\"drugSearch(\'\')\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=\'hidden\'\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(\'\');\" id=\"eldImg\"></img>\n\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"10%\" class=\"label\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;</td>\n\t\t\t\t\t\t<td  class=\"DATA\" id=\"ROUTE\" nowrap></td>\n\t\t\t\t   </tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<TD  colspan=\"4\">\n\t\t\t\t\t\t<TABLE border=0><TR>\n\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</TD>\n\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" <input type=\"radio\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"D\" disabled></TD>\n\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<input type=\"radio\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"B\"  checked  disabled></TD></TR></TABLE></TD>\n\t\t\t\t\t</tr>\n\t\t\t\t   <tr>\n\t\t\t\t\t<td width=\"7%\"  class=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"20%\" class=\"data\" colspan=\'5\'><input type=\"text\" name=\'dose\' id=\'dose\' value=\"\"  size=\"5\" maxlength=\"12\" class=\"number\"  onKeyPress=\"return allowValidNumber(this,event,8,6);\" onblur=\'calcTotalDose(onCologyRegimenDrugDetails);setChngdDose(document.onCologyRegimenDrugDetails.totalDose.value);\' class=\"NUMBER\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =">\n\n\t\t\t\t\t\t<select name=\'doseUom\' id=\'doseUom\' onChange=\'calcTotalDose(onCologyRegimenDrugDetails)\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="></select>\n\t\t\t\t\t\t<label class=\'label\'><b>/</b></label>\n\t\t\t\t\t\t<select name=\'caclDoseBy_unit\' id=\'caclDoseBy_unit\' onChange=\'calcTotalDose(onCologyRegimenDrugDetails);\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<option value=\"kg\" >kg</option>\n\t\t\t\t\t\t\t<option value=\"m2\">m&sup2;</option> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t<option value=\"kg\" >Kg</option>\n\t\t\t\t\t\t\t<option value=\"m2\" >M2</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<label class=\'label\'><b>=</b></label>\n\t\t\t\t\t\t<input type=\"text\" name=\'totalDose\' id=\'totalDose\' value=\"\" onKeyPress=\"return allowValidNumber(this,event,8,6);\" onblur=\'checkDose(this);setChngdDose(document.onCologyRegimenDrugDetails.totalDose.value);calcDose(onCologyRegimenDrugDetails); \' class=\"NUMBER\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">\n\t\t\t\t\t\t<label class=\'label\'></label>\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></img>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td  id=\"DATA\" class=\"DATA\"><font size=\"1\"></font></td>\n\t\t\t\t</tr>\n\n\n\t\t\t\t\t<tr height=\'40\'><td class=\"label\" colspan=\'7\' >&nbsp;</td></tr>\n\t\t\t\t</table>\n\t\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"ocurrance_num\" id=\"ocurrance_num\" value=\"0\">\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</font></th> \n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"8%\"  class=\"label\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</TD>\n\t\t\t\t\t\t<td width=\"35%\" class=\"DATA\" id=\"DRUGDESC\" nowrap>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');\"></img>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=hidden\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"10%\" class=\"label\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&nbsp;</td>\n\t\t\t\t\t\t<td  class=\"label\" id=\"ROUTE\"  nowrap><font style=\'color:";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =";background-color:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =";\'><b>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</b></font>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t<label style=\'color:red;\' class=\'label\' >&nbsp;(";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =") </label> \n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" \n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t<td CLASS=\"label\" ID=\"monograph\" colspan=\'3\'>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="                          \n\t\t\t\t\t\t\t\t\t<label id=\'rec_legend\' onclick=\'defaultRecomDose()\'>\n\t\t\t\t\t\t\t\t\t<font class=\'HYPERLINK\' onmouseover=\'changeCursor(this);\'>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="                          \n\t\t\t\t\t\t\t\t\t<label id=\'rec_legend\' >\n\t\t\t\t\t\t\t\t\t<font class=\'label\' >\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</font>\n\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t<label id=\"rec_value\" style=\"font-size:11;font-weight:bold;color:red\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</label>\n\t\t\t\t\t\t\t&nbsp;<label id=\"rec_uom\" style=\"font-size:11;font-weight:bold;color:red\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</label>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t<TD colspan=\'3\'>&nbsp</TD>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr><td colspan=\'5\'>\n\t\t\t\t\t<TABLE border=0>\n\t\t\t\t\t\t<TR>\t\t\t\t\t\t\n\t\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</TD>\n\t\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<input type=\"radio\" id=\"CALC_DOSE_BASED_ON_D\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"D\" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="  onClick=\"setCalculateBy(this,\'IVAD_NORMAL\');\"></TD>\n\t\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="<input type=\"radio\" id=\"CALC_DOSE_BASED_ON_B\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"B\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="  onClick=\"setCalculateBy(this,\'IVAD_NORMAL\');\"></TD>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="     \n\t\t\t\t\t\t\t\t\t\t<td class=\"label\"><a HREF id=\"drug_remarks\" onMouseOver=\"changeCursor(this);\" onClick=\"getFormatId(\'Drug\',\'Y\')\" title=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</font></a>\n\t\t\t\t\t\t\t\t\t\t<!-- added for [IN:039576]-start -->\n\t\t\t\t\t\t\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' id=\'DrugRemarksMandImg\'></td>\n\t\t\t\t\t\t\t\t\t    <input type=\'hidden\' name=\'DrugRemarksMandatory\' id=\'DrugRemarksMandatory\' value=\'N\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered\' id=\'DrugRemarksEntered\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t\t\t\t\t\t\t\t\t<!-- added for [IN:039576]-end -->\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\"><a HREF id=\"drug_remarks\" onMouseOver=\"changeCursor(this);\" onClick=\" callOrderAmend(\'Drug\')\" style=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" title=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</font></a><!-- added for [IN:039576]-start -->\n\t\t\t\t\t\t\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' id=\'DrugRemarksMandImg\'></td>\n\t\t\t\t\t\t\t\t\t    <input type=\'hidden\' name=\'DrugRemarksMandatory\' id=\'DrugRemarksMandatory\' value=\'N\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered\' id=\'DrugRemarksEntered\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t\t\t\t\t\t\t\t\t<!-- added for [IN:039576]-end --></td>\n ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t<td class=\"label\"  colspan=\"2\" nowrap>\n\t\t\t\t\t\t\t\t<a href=\"javascript:drugindication_remarks();\" id=\"drug_ind_remarks\" style=\"visibility:visible\" title=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</a></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\t\t\t\t<td CLASS=\"label\" colspan=\"2\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="&nbsp;\n\t\t\t\t\t<input type=\'checkbox\' name=\'allow_alternate_yn\' id=\'allow_alternate_yn\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" > </td><!-- GHL-CRF-0549-->\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t</TABLE>\n\t\t\t\t</td>\n\t\t\t\t<td colspan=\'4\'>\n\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t<td class=\"label\" align=\'center\'><label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =";";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</label></td>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t<td class=\"label\"  align=\'center\' colspan=\'2\'><label id=\'lbl_splapprvl\' style=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\t\t\t<td class=\"label\" align=\'center\'><label id=\'lbl_cosign\' style=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</label></td>\n\n\t\t\t\t\t\t\t\t\t<td class=\"label\"><A HREF onMouseOver=\"changeCursor(this);\" title=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'  onClick=\"viewReasonforRequest(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\');\" style=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</A></td>\n\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"7%\"  class=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<input type=\"hidden\" name =\"display_dosage_type1\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" >\n\t\t\t\t\t<td width=\"20%\" class=\"data\" colspan=\'5\'>\n\t\t\t\t\t<SELECT name=\"dosage_type_list\" id=\"dosage_type_list\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" onChange=\'setDosageUOM();ExternalDosageCheck(\"\",\"admndtl\",\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\")\'>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Q\" Selected>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</OPTION>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"S\" ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</OPTION>\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Q\" ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t</SELECT>\n\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t<input type=\"text\" name=\'dose\' id=\'dose\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"  size=\"5\" maxlength=\"6\" class=\"number\"  onKeyPress=\"return allowValidNumber(this,event,8,3);\" onblur=\'calcTotalDose(onCologyRegimenDrugDetails);setChngdDose(document.onCologyRegimenDrugDetails.totalDose.value);ExternalDosageCheck(\"\",\"admndtl\",\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\")\' class=\"NUMBER\" ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =">\n<!--\t\t\t\t\t\t<font size=\"1\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</font> -->\n\t\t\t\t\t\t<select name=\'doseUom\' id=\'doseUom\' onChange=\'\' ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =">\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<label class=\'label\' ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" id=\"slashLabel\"><b>/</b></label>\n\t\t\t\t\t\t<select name=\'caclDoseBy_unit\' id=\'caclDoseBy_unit\' onChange=\'calcTotalDose(onCologyRegimenDrugDetails);setChngdDose(document.onCologyRegimenDrugDetails.totalDose.value);\' ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="> <!-- disableDoseBy Added for ML-MMOH-CRF-1004 -->\t\t\t\t\t\t\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t    <option value=\"kg\" ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =">kg</option>\n\t\t\t\t\t\t\t<option value=\"m2\" ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =">m&sup2;</option>\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t<option value=\"kg\" ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =">Kg</option>\n\t\t\t\t\t\t\t<option value=\"m2\" ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =">M2</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t\t\t<option value=\"Ag\" ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =">age</option> <!-- Age changed to age for ML-MMOH-CRF-1004 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t<!--\t<label class=\'label\' ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" id=\"equalLabel\"><b>=</b></label> -->\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="<!-- commented and added checkBeforeDecimal() and allowValidNumber() functions for ML-BRU-SCF-1437 -->\n\t\t\t\t\t\t<input type=\"text\"  name=\'totalDose\' id=\'totalDose\' value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" maxlength=\"12\" onKeyPress=\"checkBeforeDecimal(this,event); return allowValidNumber(this,event,8,3);\" onblur=\'checkDose(this,";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =",";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =");setChngdDose(this.value);ExternalDosageCheck(\"\",\"admndtl\",\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\");\' class=\"NUMBER\" ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="> <!-- total_qty_disable Added for ML-MMOH-CRF-0345 [IN:057441] -->\n\t\t\t\t\t\t<label class=\'label\' id=\"totaldoseUOM\">";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</label>\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></img>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td  id=\"DATA\" class=\"DATA\"><font size=\"1\">";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</font></td>\n\t\t\t\t\t<input type=\"hidden\" name=\"doseValue\" id=\"doseValue\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t\t</table> \n\t\t\t\t<input type=\"hidden\" name=\"g\" id=\"g\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"mg\" id=\"mg\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"mcg\" id=\"mcg\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ncg\" id=\"ncg\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\n\t\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drug_desc\" id=\"drug_desc\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"generic_id\" id=\"generic_id\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"generic_name\" id=\"generic_name\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"allergy_yn\" id=\"allergy_yn\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"current_rx\" id=\"current_rx\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"srl_no\" id=\"srl_no\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"form_code\" id=\"form_code\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"pres_qty_value\" id=\"pres_qty_value\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"pres_base_uom\" id=\"pres_base_uom\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"pres_base_uom_desc\" id=\"pres_base_uom_desc\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"freq_code\" id=\"freq_code\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"durn_type\" id=\"durn_type\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"or_durn_desc\" id=\"or_durn_desc\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"approval_yn_val\" id=\"approval_yn_val\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"auth_yn_val\" id=\"auth_yn_val\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ord_authorized_prev_yn\" id=\"ord_authorized_prev_yn\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"cosign_yn_val\" id=\"cosign_yn_val\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_type_code\" id=\"order_type_code\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"auth_yn\" id=\"auth_yn\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"approval_yn\" id=\"approval_yn\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"cosign_yn\" id=\"cosign_yn\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"consent_reqd_yn\" id=\"consent_reqd_yn\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"allergy_desc\" id=\"allergy_desc\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"exceed_dose_desc\" id=\"exceed_dose_desc\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dup_drug_desc\" id=\"dup_drug_desc\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"uom_code\" id=\"uom_code\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"strength_uom_desc\" id=\"strength_uom_desc\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"str_val\" id=\"str_val\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bms_qty\" id=\"bms_qty\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dflt_qty_uom\" id=\"dflt_qty_uom\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"tab_qty_value\" id=\"tab_qty_value\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"qty_desc_code\" id=\"qty_desc_code\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"route_code\" id=\"route_code\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"str_desc\" id=\"str_desc\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"durn_value\" id=\"durn_value\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"end_date\" id=\"end_date\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"SRL_NO\" id=\"SRL_NO\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"calc_by_ind\" id=\"calc_by_ind\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drug_unit\" id=\"drug_unit\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drug_unit_code\" id=\"drug_unit_code\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_calc_unit\" id=\"amend_calc_unit\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"daily_dose\" id=\"daily_dose\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"unit_dose\" id=\"unit_dose\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"unit_dose1\" id=\"unit_dose1\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\"><!-- Added for IN:070451  -->\n\t\t\t\t<input type=\"hidden\" name=\"mono_graph\" id=\"mono_graph\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"recomm_dosage_unit\" id=\"recomm_dosage_unit\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"recomm_dosage_by\" id=\"recomm_dosage_by\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"limit_ind\" id=\"limit_ind\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_unit_dose\" id=\"min_unit_dose\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_unit_dose1\" id=\"min_unit_dose1\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\"><!-- Added for IN:070451  -->\n\t\t\t\t<input type=\"hidden\" name=\"min_daily_dose\" id=\"min_daily_dose\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t\t\t\t<!-- Added for IN:070451 start -->\n\t\t\t\t<input type=\"hidden\" name=\"max_daily_ceeling_dose\" id=\"max_daily_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_daily_ceeling_dose\" id=\"min_daily_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"max_unit_ceeling_dose\" id=\"max_unit_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_unit_ceeling_dose\" id=\"min_unit_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dose_unit_desc\" id=\"dose_unit_desc\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dose_unit_desc1\" id=\"dose_unit_desc1\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n\t\t\t\t<!-- Added for IN:070451 end  -->\n\t\t\t\t<input type=\"hidden\" name=\"dosage_std\" id=\"dosage_std\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dosage_type\" id=\"dosage_type\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ocurrance_num\" id=\"ocurrance_num\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"exceedDosageReasonMand\" id=\"exceedDosageReasonMand\" value=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"weight\" id=\"weight\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bsa\" id=\"bsa\" value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"calc_yn\" id=\"calc_yn\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"external_product_id\" id=\"external_product_id\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"qty_value\" id=\"qty_value\" value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">  <!-- Code added for IN032142 -->\n\t\t\t\t<!--<input type=\"hidden\" name=\"perform_external_database_checks_yn\" id=\"perform_external_database_checks_yn\" value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">-->\n\t\t\t\t<input type=\"hidden\" name=\"DrugIndicationRemarks\" id=\"DrugIndicationRemarks\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\"><!--Added for  ML-BRU-CRF-072[Inc:29938]  --->\n\t\t\t\t<input type=\"hidden\" name=\"or_dose_type\" id=\"or_dose_type\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\"> <!-- Added for ML-MMOH-CRF-0345 -->\n\t\t\t\t\n\t\t\t\t<!-- Added for IN:070451 end  -->\n       <input type=\"hidden\"  name=allergy_remarks_code value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n       <input type=\"hidden\"  name=\"dose_remarks_code\" id=\"dose_remarks_code\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n       <input type=\"hidden\"  name=\"currentrx_remarks_code\" id=\"currentrx_remarks_code\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n       <!-- Added for IN:072715 end -->\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" name=\"validate_overide_on_confirm_yn\"><!-- Added for IN:069887  -->\n<input type=\"hidden\" name=\"diagnosis_found_yn\" id=\"diagnosis_found_yn\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\"><!-- added for mms-dm-crf-0204 -->\n<input type=\"hidden\" name=\"ord_set_reqd_or_opt\" id=\"ord_set_reqd_or_opt\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\"><!-- added for mms-dm-crf-0204 -->\n\n";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t   <input type=\"hidden\" name=\"pres_remarks\" id=\"pres_remarks\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n\t\t\t\t   <input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">  \n";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t <script> \n\t\t\t\t\t//calcTotalDose(onCologyRegimenDrugDetails);\n\t\t//\t\tExternalDosageCheck(\"\",\"admndtl\",\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\');\n\t\t\t\t </script> \n";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t<script>\n\t\t\tparent.oncology_fluid.location.href\t=\"../jsp/OncologyRegimenFluidDetail.jsp?\"+\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\'+\"&serial_no=\"+\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\'+\"&patient_id=\"+\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\'+\"&encounter_id=\"+\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'+\"&act_patient_class=\"+\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\'+\"&fluid_frame_display_yn=\"+\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\'+\"&start_date=\"+\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\'+\"&amend_serial_no=\"+\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'+\"&MAR_app_yn=\"+\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\';\n\t\t</script>\n";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t<script>\n\t\t\tgetFormatId(\'Drug\',\'N\');\n\t\t\tsaveWtBsa();//Added for IN:070451\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t\n\t\t\tcallCancel();\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\t</script>\n";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
12/08/2019	IN070451		B Haribabu          12/08/2019     Manickavasagam J	    ML-MMOH-CRF-1408
25/06/2020  IN:072715       Haribabu            25/06/2020     Manickavasagam J     MMS-DM-CRF-0165
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
-------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

try{
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String start_date		= request.getParameter("start_date");
	String problem_ind		= request.getParameter("problem_ind");
	String regimen_code		= request.getParameter("regimen_code");
	String stage			= request.getParameter("stage");
	String intention		= request.getParameter("intention");
	String height			= request.getParameter("height");
	String calc_yn = "N";
	String caclDoseBy_m2 = "selected";
	String caclDoseBy_kg = "";
	String caclDoseBy_age =""; // Added for ML-MMOH-CRF-0345 [IN:057441]
	String disableDoseBy  =""; // Added for ML-MMOH-CRF-1004
	String calc_dose = "";
	String calc_dose_uom = "";
	String calc_dose_by = "";
	String DrugIndicationRemarks="";//Added for  ML-BRU-CRF-072[Inc:29938]
	String DrugRemarksEntered			=	"";//added for [IN:039576]
        boolean default_dose_type_yn = false; // Added for ML-MMOH-CRF-0345 [IN:057441]
        String total_qty_disable = ""; // Added for ML-MMOH-CRF-0345 [IN:057441]
	int amend_serial_no     =0; 
	if(height==null || height.equals(""))
		height					= "0.0";
	String weight			= request.getParameter("weight");
	if(weight==null || weight.equals(""))
		height					= "0.0";
	String bsa				= request.getParameter("bsa");
	if(bsa==null || bsa.equals(""))
		bsa						= "0.0";
	String params			= request.getQueryString() ;
	String serialNum		= request.getParameter("serialNum") == null ? "":request.getParameter("serialNum");
	String MAR_app_yn		= request.getParameter("MAR_app_yn") == null ? "":request.getParameter("MAR_app_yn");
	String fluid_frame_display_yn=request.getParameter("fluid_frame_display_yn");

	String bean_id			= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name		= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	String bean_id_pres					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name_pres				= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean_pres			= (PrescriptionBean_1)getBeanObject(bean_id_pres,bean_name_pres,request);
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	boolean req_diag_pres_found=bean.isSiteSpecific("PH", "REQ_DIAG_PRES_FOUND"); //added for MMS-DM-CRF-0204
	
	String resp_id			= (String)ORbean.getResponsibilityId();
	String pract_id			= (String)ORbean.getPractitionerId();
	String pract_name		= (String)ORbean.getPractitionerName();
	String locn_type		= (String)ORbean.getLocationType();
	String locn_code		= (String)ORbean.getLocationCode();
	String facility_id	= "";
	facility_id	= (String) session.getValue("facility_id");
    String order_type_flag	=  "";
	order_type_flag		= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	String amend_search_yn	= "";
	if(order_type_flag.equals("Existing")) {
		amend_search_yn	= "DISABLED";
	}
	default_dose_type_yn = bean.isSiteSpecific("OR", "OR_ORDER_SET"); // Added for ML-MMOH-CRF-1004
	boolean item_type_site_app =  bean.isSiteSpecific("PH", "ITEM_TYPE_APP"); // added for GHL-CRF-0549
	//Added for IN:069887  start
	boolean validate_overide_on_confirm =  bean.isSiteSpecific("PH", "VALIDATE_OVERIDE_ON_CONFIRM");		
	String validate_overide_on_confirm_yn="N";
	if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}		
	//Added for IN:069887 end
	String remarks_style    =  "visibility:hidden";
	String pres_remarks     =  ""; 
	String fract_dose_appl_yn, calc_dosg_by_freq_durn_yn; // Added for IN032142
//GHL-CRF-0549 - start
	String disp_by_alt_form_param				=	"N"; //GHL-CRF-0549
	String disp_by_alt_form_drug				=   "N";//GHL-CRF-0549
	String item_type = "";
	String mm_item_low_cost_yn = ""; 
	String mm_item_high_margin_yn = "";
	String mm_item_Innovator_yn  = "";
	String allow_alternate_yn ="N"; //GHL-CRF-0549
	String allow_alternate_disabled	= "";
	String checked  = "";
		//GHL-CRF-0549 - end	
String diagnosis_found_yn="";//added for mms-dm-crf-0204
	if(start_date!=null){
		//if(! ORbean.getLanguageId().equals("en"))
          // start_date =com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",ORbean.getLanguageId(),"en");
		//bean.setOrderDate(start_date);
	}
	if(patient_id!=null)
		bean.setPatId(patient_id);
	if(encounter_id!=null)
		bean.setEncId(encounter_id);

	if(problem_ind!=null)
		bean.setProblemInd(problem_ind);
	else
		problem_ind					= bean.getProblemInd();
	
	int    count                    =0;

	ArrayList doseUom = new ArrayList();
	doseUom = bean.getDoseUom();
	bean.setExcludeADRAllergyAlert(CommonBean.checkForNull(request.getParameter("excludeADRAllergyAlert_yn")));

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( start_date ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( patient_class ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( resp_id ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( pract_id ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( pract_name ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( locn_type ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( locn_code ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( problem_ind ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(params));
            _bw.write(_wl_block23Bytes, _wl_block23);

			if (serialNum.equals("")) {

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(amend_search_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(amend_search_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(amend_search_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(amend_search_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(amend_search_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
if(default_dose_type_yn){ // if condition Added for ML-MMOH-CRF-1004 and else for existing -Start 
            _bw.write(_wl_block37Bytes, _wl_block37);
} else{ 
            _bw.write(_wl_block38Bytes, _wl_block38);
} // if condition Added for ML-MMOH-CRF-1004 and else for existing -End 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(amend_search_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);

			bean.setSerialNo(serialNum+""); //ML-MMOH-CRF-1014
			}
			else {
				int srlNo					= 0;
				srlNo						= Integer.parseInt(serialNum);
				ArrayList drugList			= bean.getDrugDetails();
				HashMap drugDetails			= (HashMap)drugList.get(srlNo-1);
				String generic_id			= (String)drugDetails.get("GENERIC_ID");
				String drug_desc			= (String)drugDetails.get("DRUG_DESC");
				String drug_code			= (String)drugDetails.get("DRUG_CODE");
				String generic_name			= (String)drugDetails.get("GENERIC_NAME");
				String allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
				String current_rx			= (String)drugDetails.get("CURRENT_RX");
				String srl_no				= (String)drugDetails.get("SRL_NO");
				String strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
				String strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
				String strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
				String form_code			= (String)drugDetails.get("FORM_CODE");
				String pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
				String pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
				String pres_base_uom_desc	= (String)drugDetails.get("PRES_BASE_UOM_DESC");
				String freq_code			= (String)drugDetails.get("FREQ_CODE");
				String durn_value			= (String)drugDetails.get("DURN_VALUE");
				String durn_type			= (String)drugDetails.get("DURN_TYPE");
				String or_durn_desc			= (String)drugDetails.get("OR_DURN_DESC");
				//String auth_yn_val		= (String)drugDetails.get("AUTH_YN_VAL");
				//String approval_yn_val	= (String)drugDetails.get("APPROVAL_YN_VAL");
				//String cosign_yn_val		= (String)drugDetails.get("COSIGN_YN_VAL");
				String auth_yn				= (String)drugDetails.get("AUTH_YN");
				String approval_yn			= (String)drugDetails.get("APPROVAL_YN");
				String cosign_yn			= (String)drugDetails.get("COSIGN_YN");
				String consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
				String order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
				String route_code			= (String)drugDetails.get("ROUTE_CODE");
				String end_date				= (String)drugDetails.get("END_DATE");
				String dup_drug_desc		= (String)drugDetails.get("CURRENTRX_REMARKS");
				String allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS");
				String exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS");
				String bms_qty				= (String)drugDetails.get("BMS_QTY");
				String dflt_qty_uom			= (String)drugDetails.get("DFLT_QTY_UOM");
				String tab_qty_value		= (String)drugDetails.get("TAB_QTY_VALUE");
				String qty_desc_code		= (String)drugDetails.get("QTY_DESC_CODE");
				String route_desc			= (String)drugDetails.get("ROUTE_DESC");
				String amend_yn	            = (String)drugDetails.get("AMEND_YN"); 
				String recomm_yn			= (String)drugDetails.get("RECOMM_YN")==null?"":(String)drugDetails.get("RECOMM_YN");
				String calc_by_ind			= (String)drugDetails.get("CALC_BY_IND")==null?"":(String)drugDetails.get("CALC_BY_IND");
				String dosage_std			= (String)drugDetails.get("DOSAGE_STD")==null?"":(String)drugDetails.get("DOSAGE_STD");
				String recomm_dosage_unit	= (String)drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
				String recomm_dosage_by		= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
				String min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_DOSE");
				String min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_DOSE");
				//Added for IN:070451 start
				String min_unit_dose1 = min_unit_dose;
				String      max_daily_ceeling_dose	    =   (String)drugDetails.get("max_daily_ceeling_dose")==null?"":(String)drugDetails.get("max_daily_ceeling_dose");
				String		min_daily_ceeling_dose	    =   (String)drugDetails.get("min_daily_ceeling_dose")==null?"":(String)drugDetails.get("min_daily_ceeling_dose");
				String		max_unit_ceeling_dose	    =   (String)drugDetails.get("max_unit_ceeling_dose")==null?"":(String)drugDetails.get("max_unit_ceeling_dose");
				String		min_unit_ceeling_dose	    =   (String)drugDetails.get("min_unit_ceeling_dose")==null?"":(String)drugDetails.get("min_unit_ceeling_dose");
				String dose_unit_desc = ""; 
				String dose_unit_desc1 = "";
				String dosage_uom			= (String)drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
						if(!dosage_uom.equals("")){ 
					   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_uom); 
					   dose_unit_desc1 =dose_unit_desc;
 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_uom.split("/")[0]));
 						 dose_unit_desc1 =dose_unit_desc;
					      dose_unit_desc =dose_unit_desc+"/"+(dosage_uom.split("/")[1]);
 						} 
						}
				//Added for IN:070451 end
				
				//Added for IN:072715 start
					String allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
					String dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
					String currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
					//Added for IN:072715 end
				
				String daily_dose			= (String)drugDetails.get("DAILY_DOSE")==null?"":(String)drugDetails.get("DAILY_DOSE");
				String unit_dose			= (String)drugDetails.get("UNIT_DOSE")==null?"":(String)drugDetails.get("UNIT_DOSE");
				String unit_dose1 = unit_dose;//Added for IN:070451
				String mono_graph	        = (String)drugDetails.get("MONO_GRAPH")==null?"":(String)drugDetails.get("MONO_GRAPH");
				String limit_ind			= (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
				String dosage_type			= (String)drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE");
				String ocurrance_num		= (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");
				String ord_auth_reqd_yn		= (String)drugDetails.get("ORD_AUTH_REQD_YN");
				String ord_spl_appr_reqd_yn	= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
				String ord_cosign_reqd_yn	= (String)drugDetails.get("ORD_COSIGN_REQD_YN");
				String ord_authorized_yn	= (String)drugDetails.get("ORD_AUTHORIZED_YN");
				String ord_authorized_prev_yn	= (String)drugDetails.get("ORD_AUTHORIZED_PREV_YN");
				String ord_approved_yn		= (String)drugDetails.get("ORD_APPROVED_YN");
				String ord_cosigned_yn		= (String)drugDetails.get("ORD_COSIGNED_YN");
				String calc_dose_based_on	= (String)drugDetails.get("CALC_DOSE_BASED_ON");
				calc_dose_by				= (String)drugDetails.get("calc_dose_by")==null?"":(String)drugDetails.get("calc_dose_by");
				calc_dose_uom				= (String)drugDetails.get("calc_dose_uom")==null?"":(String)drugDetails.get("calc_dose_uom");				
				String dose					= (String)drugDetails.get("dose")==null ? "":(String)drugDetails.get("dose");
				/* below code added for IN032142   -- Start   */
				fract_dose_appl_yn			= (String)drugDetails.get("FRACT_DOSE_APPL_YN")==null ? "":(String)drugDetails.get("FRACT_DOSE_APPL_YN");
				calc_dosg_by_freq_durn_yn	= (String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN")==null ? "":(String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN");
				String qty_value	= (String) drugDetails.get("QTY_VALUE"); 
				/* code added for IN032142   --End   */
				DrugIndicationRemarks      = (String)drugDetails.get("DRUG_INDICATION")==null ? "":(String)drugDetails.get("DRUG_INDICATION");//Added for  ML-BRU-CRF-072[Inc:29938]
				DrugRemarksEntered      = (String)drugDetails.get("DrugRemarksEntered")==null ? "":(String)drugDetails.get("DrugRemarksEntered");// added for [IN:039576]
				if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8");
				String display_auth_rule	= "visibility:hidden";
				String color_auth_rule		= "RED";
				String order_id				= "";
				String disable_existing     = "";
				String amend_srl_no         = ""; 
				String amend_order_id		= "";		 
				String dosage_unit			= "";	
				String calculatedDose		= "";					
				String disable_calc_dose	= "";	
				String select_calc_dose_WT_BSA		= "";	
				String select_calc_dose_Dosage		= "";	
				String display_dosage_type1	= "";	
				String display_dosage_type2	= "";
				String perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
				String ext_prod_id = drugDetails.get("EXTERNAL_PRODUCT_ID")==null ? "":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
				HashMap eqvlValues			= (HashMap)drugDetails.get("EQVL_VALUES");
				String ord_set_reqd_or_opt	        = (String) drugDetails.get("REQD_OR_OPT_IND")==null?"":(String) drugDetails.get("REQD_OR_OPT_IND");//mms-dm-crf-0204
	             diagnosis_found_yn=(String)drugDetails.get("DIAGNOSIS_FOUND_YN");//mms-dm-crf-0204	
						if(req_diag_pres_found){
							 diagnosis_found_yn=(String)drugDetails.get("DIAGNOSIS_FOUND_YN");//mms-dm-crf-0204	
									
						}
						else{
							diagnosis_found_yn="G";
						}
	             System.out.println("339 ord_set_reqd_or_opt"+ord_set_reqd_or_opt);
				HashMap Existingrecord;
				//order_type_flag		= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");       
                                calculatedDose =(String) drugDetails.get("calc_dose")==null?"":(String) drugDetails.get("calc_dose"); // Added for ML-MMOH-CRF-0345 - Start
				String or_dose_type = drugDetails.get("OR_DOSAGE_TYPE")==null ? "":(String)drugDetails.get("OR_DOSAGE_TYPE");
                                String or_qty_val = drugDetails.get("OR_QTY_VALUE")==null ? "":(String)drugDetails.get("OR_QTY_VALUE"); 
                                default_dose_type_yn = bean.isSiteSpecific("OR", "OR_ORDER_SET");
                             if (default_dose_type_yn && !or_dose_type.equals("") && !dosage_type.equals("Q")){
                	      total_qty_disable ="disabled";
                              }
                
                              if(!or_dose_type.equals("") && !dosage_type.equals("Q") && default_dose_type_yn){ 
					
					if(or_dose_type.equals("A") && calculatedDose.equals("") && !or_qty_val.equals("")){
						dose = or_qty_val;
					}
					else if(or_dose_type.equals("K") && calculatedDose.equals("") && !or_qty_val.equals("")){
						dose = String.valueOf((Float.parseFloat(or_qty_val) * Float.parseFloat(weight)));
					}
					else{
						if(calculatedDose.equals("") && !or_qty_val.equals(""))
						dose = String.valueOf((Float.parseFloat(or_qty_val) * Float.parseFloat(bsa)));
					}
					
					DecimalFormat dfTest        = new DecimalFormat("0.#######"); // Added for ML-MMOH-SCF-1060 
					if(calculatedDose.equals("") && !or_qty_val.equals("")){	
                            	   dose = dfTest.format(Double.parseDouble(dose))+"";//ADDED for ml-mmoh-scf-1060
                            	   // dose= String.valueOf(Math.round(Float.parseFloat(dose)*1000)/1000);//removed for ml-mmoh-scf-1060
                	        calculatedDose = or_qty_val;
			       }
			      } // Added for ML-MMOH-CRF-0345 - End
				if(stage==null||stage.equals(""))
					stage	= (String)drugDetails.get("stage");
				if(intention==null||intention.equals(""))
					intention	= (String)drugDetails.get("intention");
				if(regimen_code==null||regimen_code.equals(""))
					regimen_code			= (String)drugDetails.get("regimen_code");				
				if(dose.equals(""))
					dose= (String)drugDetails.get("QTY_VALUE")==null ? "":(String)drugDetails.get("QTY_VALUE");
				String route_color			= (String)drugDetails.get("ROUTE_COLOR");	// added for CRF RUT-CRF-0034.1[IN:037389]-start
				String fntColor="";
				String backgrndColor="";
				if(route_color!= null && !route_color.equals("")){
	                if(route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);
					}
				}	// added for CRF RUT-CRF-0034.1[IN:037389]-End
				//HashMap practRights			= (HashMap)bean.getAuthorizationReqd(resp_id, pract_id);
				ArrayList doseValues		= (ArrayList)bean.getDoseValues(drug_code,patient_id);
					
				String calc_unit			= "";
				String drug_unit			= "";
				String drug_unit_code			= "";

				if(doseValues!=null){
					dosage_unit				= (String)doseValues.get(1);
				}
				//out.println("amend yn=>"+amend_yn);
				if(amend_yn.equals("N")){
					if(!calc_by_ind.equals("") && calc_by_ind.equals("B")){
						if(!bsa.equals("0.0")){
							float calc_value    = ((Float.parseFloat(dose)) * (Float.parseFloat(bsa)));
							int calc_value_int  = (int)java.lang.Math.ceil(calc_value);
							min_unit_dose			= String.valueOf((int)java.lang.Math.ceil(((Float.parseFloat(CommonBean.checkForNull(min_unit_dose,"0"))) * (Float.parseFloat(bsa)))));//Added for IN:070451
							unit_dose			= String.valueOf((int)java.lang.Math.ceil(((Float.parseFloat(CommonBean.checkForNull(unit_dose,"0"))) * (Float.parseFloat(bsa)))));//Added for IN:070451
							dosage_unit="mt/sqr";
							calc_unit			= "("+ dosage_std + " "+drug_unit + "/" + dosage_unit + ")" ;
							dose				= String.valueOf(calc_value_int);
						}
					}
					else if(!calc_by_ind.equals("") && calc_by_ind.equals("W")){
						if(!weight.equals("0.0")){
							float calc_value    = ((Float.parseFloat(dose)) * (Float.parseFloat(weight)));
							//int calc_value_int  = (int)java.lang.Math.ceil(calc_value);
							min_unit_dose			= String.valueOf((int)java.lang.Math.ceil(((Float.parseFloat(CommonBean.checkForNull(min_unit_dose,"0"))) * (Float.parseFloat(weight)))));//Added for IN:070451
							unit_dose			= String.valueOf((int)java.lang.Math.ceil(((Float.parseFloat(CommonBean.checkForNull(unit_dose,"0"))) * (Float.parseFloat(weight)))));//Added for IN:070451
							 dosage_unit="mt/sqr";
							calc_unit			= "("+ dosage_std + " "+drug_unit + "/" + dosage_unit + ")" ;
							dose				= String.valueOf(calc_value);
						}
					}
				}
				String doseValue=dose;
				/*if (dose!=null && !dose.equals("")){   //commented for IN18269
					//Float f=new Float(dose);
					//doseValue=f.intValue()+"";
				}*/
				//out.println("dValue2="+doseValue);
				String TDM_order_id			=	"";
				String TDM_display		    =	"";
				TDM_order_id				=  bean_pres.getOorderIdForTDMDtls(patient_id,drug_code);

				if(TDM_order_id==null||TDM_order_id.equals("")){
					TDM_display="display:none";
				}
				else{
					TDM_display="display:inline";
				} 
				
//				calculatedDose =String.valueOf(Math.ceil((Float.parseFloat(doseValue))/(Float.parseFloat(bsa))));
				//calculatedDose =String.valueOf(new Float(Math.floor((Float.parseFloat(doseValue))/(Float.parseFloat(bsa)))).intValue());
			//	calculatedDose =(String) drugDetails.get("calc_dose")==null?"":(String) drugDetails.get("calc_dose");  // Commented for ML-MMOH-CRF-0345
				if(order_type_flag.equals("Existing")) {
	
					order_id=request.getParameter("order_id");
					bean.setDummyOrderID(order_id);		  
					ArrayList getExistingCYTORecords = bean.getExistingCYTORecords();
					for(int i=0;i<getExistingCYTORecords.size();i++){
						Existingrecord	= (HashMap) getExistingCYTORecords.get(count); 
						if( Existingrecord.containsKey("AMEND_SRL_NO")){
							amend_srl_no=(String) Existingrecord.get("AMEND_SRL_NO");	
							if(amend_srl_no.equals(serialNum)){
								if(amend_yn.equals("N"))
								{
									doseValue				= (String)Existingrecord.get("QTY_VALUE");
									calc_dose_based_on	    = (String)Existingrecord.get("CALC_DOSE_BASED_ON");	
									dosage_type			    = (String)Existingrecord.get("DOSAGE_TYPE");
									calculatedDose			= (String)Existingrecord.get("CALC_DOSE");	
									calc_dose_uom		    = (String)Existingrecord.get("CALC_DOSE_UOM");	
									calc_dose_by		    = (String)Existingrecord.get("CALC_DOSE_BY");										
								}
								drug_code				= (String)Existingrecord.get("ORDER_CATALOG_CODE");
								drug_desc				= (String)Existingrecord.get("CATALOG_DESC");		 
								amend_order_id		    = (String)Existingrecord.get("ORDER_ID");	
									
//								calculatedDose = String.valueOf((Float.parseFloat(doseValue))/(Float.parseFloat(bsa)));
								amend_serial_no         = count;	
								
								//if(order_type_flag.equals("Existing")){																		
									if(!calc_dose_uom.equals("")){
										drug_unit = calc_dose_uom;
									}
								//}
								break;		  
							}
							
						}
						count++;
						disable_existing="disabled" ;  
					}
					ArrayList drug_remarks	=	bean.getPrescribedRemarks(amend_order_id,"1");
					if(drug_remarks.size()!=0) { 
						for(int x=0; x<drug_remarks.size(); x++) {	
							if(x==(drug_remarks.size()-1)) {	
								pres_remarks	=pres_remarks+(String)drug_remarks.get(x);
							} else {
								pres_remarks	=pres_remarks+(String)drug_remarks.get(x)+",";
							}
						} 
					 } 
					 if(!pres_remarks.equals(""))
						remarks_style	="visibility:visible";
					 else
						remarks_style	="visibility:hidden";
				}
				if(dosage_type.equals("S")){
					drug_unit = strength_uom_desc;
					drug_unit_code = strength_uom;
				}
				else{
					drug_unit = pres_base_uom_desc;
					drug_unit_code = pres_base_uom;
				}
				if(calc_dose_based_on!=null && !calc_dose_based_on.equals(""))
				{
					if(calc_dose_based_on.equals("D"))
					{
					  	if (strength_value.equals("0")|| !fract_dose_appl_yn.equals("Y") || !calc_dosg_by_freq_durn_yn.equals("Y"))//fract_dose_appl_yn and calc_dosg_by_freq_durn_yn  added  for  IN032142 
							disable_calc_dose="disabled";
						else
							disable_calc_dose="";
						select_calc_dose_Dosage="checked";
						select_calc_dose_WT_BSA="";
						display_dosage_type1="style=display:inline";
						display_dosage_type2="style=display:none";						
					}
					else
					{						
						select_calc_dose_WT_BSA="checked";					
						select_calc_dose_Dosage="";
						display_dosage_type1="style=display:none";					
						display_dosage_type2="style=display:inline";						
					}
				}
				else
				{
					if (strength_value.equals("0") || !fract_dose_appl_yn.equals("Y") || !calc_dosg_by_freq_durn_yn.equals("Y"))//fract_dose_appl_yn and calc_dosg_by_freq_durn_yn  added  for  IN032142  
					{
						disable_calc_dose="disabled";
						select_calc_dose_Dosage="checked";
						select_calc_dose_WT_BSA="";
						display_dosage_type1="style=display:inline";
						display_dosage_type2="style=display:none";										
					}
					else
					{
						disable_calc_dose="";
						if(dosage_type.equals("Q"))
						{
							select_calc_dose_Dosage="checked";
							select_calc_dose_WT_BSA="";
							display_dosage_type1="style=display:inline";
							display_dosage_type2="style=display:none";
						}
						else
						{
							select_calc_dose_WT_BSA="checked";					
							select_calc_dose_Dosage="";
							display_dosage_type1="style=display:none";					
							display_dosage_type2="style=display:inline";
						}
					}
				}
				if(!or_dose_type.equals("") && !dosage_type.equals("Q") && default_dose_type_yn){ // Added for ML-MMOH-CRF-0345 - Start
                                   if(calc_dose_by.equals("m2") ||or_dose_type.equals("M") ) {
					caclDoseBy_m2 = "selected";
					disableDoseBy  = "disabled"; // Added for ML-MMOH-CRF-1004
					caclDoseBy_kg = "";
					caclDoseBy_age = "";
				  }
                                  else if(calc_dose_by.equals("Ag") || or_dose_type.equals("A")) {
                	          caclDoseBy_m2 = "";
					  caclDoseBy_kg = "";
					  caclDoseBy_age = "selected";
					  disableDoseBy  = "disabled"; // Added for ML-MMOH-CRF-1004
  				  }
                                else if(calc_dose_by.equals("kg") || or_dose_type.equals("K")){
					caclDoseBy_m2 = "";
					caclDoseBy_kg = "selected";
					disableDoseBy  = "disabled"; // Added for ML-MMOH-CRF-1004
					caclDoseBy_age = "";
				  }
				} // Added for ML-MMOH-CRF-0345 - End
			        else{ // else condition Added for ML-MMOH-CRF-0345  -Existing Functionality -Start
				if(calc_dose_by.equals("m2")) {
					caclDoseBy_m2 = "selected";
					caclDoseBy_kg = "";
				}else{
					caclDoseBy_m2 = "";
					caclDoseBy_kg = "selected";
				}
			        } // else condition Added for ML-MMOH-CRF-0345  -Existing Functionality -End
				//out.println("calc_dose_by=>"+calc_dose_by);

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block1Bytes, _wl_block1);

						if(drug_desc != null && !drug_desc.equals("")){	

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);

						}
						else{

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);

						}

            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(backgrndColor));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
							//Added for SKR-CRF-0006[IN029561] -Start
							String actionText =  bean.getActionText(form_code,route_code);					 
							if(actionText !=null && !actionText.equals("")){

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(actionText));
            _bw.write(_wl_block52Bytes, _wl_block52);
 
							}// Added for SKR-CRF-0006[IN029561]-End

            _bw.write(_wl_block53Bytes, _wl_block53);

						if(recomm_yn!=null && recomm_yn.equals("Y")) {

            _bw.write(_wl_block54Bytes, _wl_block54);

							if(!order_type_flag.equals("Existing"))	{
								if(dosage_type.equals(recomm_dosage_by)  ){

            _bw.write(_wl_block55Bytes, _wl_block55);

								}
							}
							else{
								if(dosage_type.equals(recomm_dosage_by)  ){

            _bw.write(_wl_block56Bytes, _wl_block56);

								}  
							}

            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block60Bytes, _wl_block60);

				}
				else{

            _bw.write(_wl_block61Bytes, _wl_block61);
				}

            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(select_calc_dose_Dosage));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable_calc_dose));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(select_calc_dose_WT_BSA));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable_calc_dose));
            _bw.write(_wl_block68Bytes, _wl_block68);

									//added for SRR20056-SCF-7085 IN26862 - Start
									if(!order_type_flag.equals("Existing"))	{

            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block72Bytes, _wl_block72);

									}   
									else{

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block76Bytes, _wl_block76);

									}
									//added for SRR20056-SCF-7085 IN26862 - End

            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
//GHL-CRF-0549 - start
							disp_by_alt_form_param     = bean.getParamDispByAltForm();
						
							disp_by_alt_form_drug     = (String) drugDetails.get("DISP_ALT_FORM_YN")==null?"N":(String) drugDetails.get("DISP_ALT_FORM_YN");

						if(item_type_site_app){
						allow_alternate_yn = (String) drugDetails.get("allow_alternate")==null?"N":(String) drugDetails.get("allow_alternate"); //GHL-CRF-0549
						if(disp_by_alt_form_param.equals("Y") && disp_by_alt_form_drug.equals("Y"))
						{
							item_type = bean.getItemType(drug_code);
							mm_item_low_cost_yn = item_type.split("~")[0];
							mm_item_high_margin_yn = item_type.split("~")[1];
							mm_item_Innovator_yn = item_type.split("~")[2];
							if(mm_item_low_cost_yn.equals("Y") || mm_item_high_margin_yn.equals("Y")){
								checked = "checked";
							}else{
								checked = "";
							}
							
							if(mm_item_Innovator_yn.equals("Y")) //GHl-SCF-1430 - start
								checked = "";
							
							if(!mm_item_low_cost_yn.equals("Y") && !mm_item_high_margin_yn.equals("Y") && !mm_item_Innovator_yn.equals("Y")){ //4/24/2019
								checked = "checked";
							}//GHl-SCF-1430 - end

							allow_alternate_disabled = "";
						
						}else{
							allow_alternate_disabled = "disabled";
						}
						if(order_type_flag.equals("Existing")){ //GHL-CRF-0549
							allow_alternate_disabled = "disabled";
						}
						
					} 	//GHL-CRF-0549 - end
					if(item_type_site_app && disp_by_alt_form_param.equals("Y")){ //GHL-CRF-549

            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(allow_alternate_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(allow_alternate_disabled));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block83Bytes, _wl_block83);

					}//GHL-CRF-0549 - end

            _bw.write(_wl_block84Bytes, _wl_block84);

									display_auth_rule = "visibility:hidden";
									if(ord_auth_reqd_yn.equals("Y")){
										display_auth_rule = "visibility:visible";
										color_auth_rule = "color:red";
										if(ord_authorized_yn.equals("Y"))
											color_auth_rule = "color:green";
									}

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

									display_auth_rule = "visibility:hidden";
									color_auth_rule = "color:red";
									if(ord_spl_appr_reqd_yn.equals("Y")){
										display_auth_rule = "visibility:visible";
										if(ord_approved_yn.equals("Y"))
											color_auth_rule = "color:green";
									}

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

									display_auth_rule = "visibility:hidden";
									color_auth_rule = "color:red";
									if(ord_cosign_reqd_yn.equals("Y")){
										display_auth_rule = "visibility:visible";
										if(ord_cosigned_yn.equals("Y"))
											color_auth_rule = "color:green";
									}

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(TDM_order_id));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(TDM_display));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(display_dosage_type1));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(display_dosage_type1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block98Bytes, _wl_block98);

								if (strength_value.equals("0") || !fract_dose_appl_yn.equals("Y") || !calc_dosg_by_freq_durn_yn.equals("Y")) { //fract_dose_appl_yn and calc_dosg_by_freq_durn_yn  added  for  IN032142

            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

								}
								else {	
									String dosage_option_select_s="";
									String dosage_option_select_q="";
									if(dosage_type.equals("Q"))
										dosage_option_select_q="Selected";
									else
										dosage_option_select_s="Selected";

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(dosage_option_select_s));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(dosage_option_select_q));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

								}

            _bw.write(_wl_block104Bytes, _wl_block104);

					//if(drug_unit_code.toUpperCase().equals("G") || drug_unit_code.toUpperCase().equals("MG") || drug_unit_code.toUpperCase().equals("MCG") || drug_unit_code.toUpperCase().equals("NCG")){
						
						calc_yn = "Y";

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(calculatedDose.equals("0")?"":calculatedDose));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(display_dosage_type2));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(drug_unit));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(display_dosage_type2));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(display_dosage_type2));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(display_dosage_type2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disableDoseBy));
            _bw.write(_wl_block114Bytes, _wl_block114);
if(default_dose_type_yn){ // if condition Added for ML-MMOH-CRF-1004 and else for existing -Start 
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(caclDoseBy_kg));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(caclDoseBy_m2));
            _bw.write(_wl_block117Bytes, _wl_block117);
} else{
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(caclDoseBy_kg));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(caclDoseBy_m2));
            _bw.write(_wl_block120Bytes, _wl_block120);
 } // if else condition Added for ML-MMOH-CRF-1004 else for existing -End 
            _bw.write(_wl_block57Bytes, _wl_block57);
if(!or_dose_type.equals("") && !dosage_type.equals("Q") && default_dose_type_yn){ // Added for ML-MMOH-CRF-0345 - Start 
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(caclDoseBy_age));
            _bw.write(_wl_block122Bytes, _wl_block122);
} // Added for ML-MMOH-CRF-0345 - End 
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(display_dosage_type2));
            _bw.write(_wl_block124Bytes, _wl_block124);

				//}

            _bw.write(_wl_block125Bytes, _wl_block125);
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(doseValue));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(total_qty_disable));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(drug_unit));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(calc_unit));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(doseValue));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf( eqvlValues.get("G") ));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf( eqvlValues.get("MG") ));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf( eqvlValues.get("MCG") ));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf( eqvlValues.get("NCG") ));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf( drug_code ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf( drug_desc ));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf( generic_id ));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf( generic_name ));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf( allergy_yn ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf( current_rx ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf( srl_no ));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf( pres_qty_value ));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf( pres_base_uom ));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf( pres_base_uom_desc ));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf( freq_code ));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf( durn_type ));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf( or_durn_desc ));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf( ord_approved_yn ));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf( ord_authorized_yn ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf( ord_authorized_prev_yn ));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf( ord_cosigned_yn ));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf( order_type_code ));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf( auth_yn ));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf( approval_yn ));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf( cosign_yn ));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf( consent_reqd_yn ));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf( allergy_desc ));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf( exceed_dose_desc ));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf( dup_drug_desc ));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf( strength_uom ));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf( strength_uom_desc ));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf( strength_value ));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf( bms_qty ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf( dflt_qty_uom ));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf( tab_qty_value ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf( qty_desc_code ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf( durn_value ));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf( end_date ));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf( srlNo ));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(calc_by_ind));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(drug_unit));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(drug_unit_code));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf( daily_dose ));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf( unit_dose ));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf( unit_dose1 ));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf( mono_graph ));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf( recomm_dosage_unit ));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf( recomm_dosage_by ));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf( limit_ind ));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(min_unit_dose1));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(dose_unit_desc1));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(ocurrance_num));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(bsa));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(calc_yn));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(or_dose_type));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(allergy_remarks_code));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(dose_remarks_code));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(currentrx_remarks_code));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(validate_overide_on_confirm_yn));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf( diagnosis_found_yn ));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf( ord_set_reqd_or_opt ));
            _bw.write(_wl_block212Bytes, _wl_block212);

				if(order_type_flag.equals("Existing")){

            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(pres_remarks));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(amend_order_id));
            _bw.write(_wl_block215Bytes, _wl_block215);

				}
			
			//if(!strength_value.equals("0")){
		//		if(!ext_prod_id.equals("") && perform_external_database_checks_yn.equals("Y"))
		//		{

            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block217Bytes, _wl_block217);

	//		}
	  			bean.setSerialNo(ocurrance_num+""); //added for ML-MMOH-CRF-01014
	  }

            _bw.write(_wl_block218Bytes, _wl_block218);


	if (!serialNum.equals("")){

            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(params));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(serialNum));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(fluid_frame_display_yn));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(amend_serial_no));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(MAR_app_yn));
            _bw.write(_wl_block228Bytes, _wl_block228);

	}
	//if(order_type_flag.equals("Existing")&&!pres_remarks.equals("")){

            _bw.write(_wl_block229Bytes, _wl_block229);
if(req_diag_pres_found && diagnosis_found_yn.equals("N")){//added for mms-dm-crf-0204
				
            _bw.write(_wl_block230Bytes, _wl_block230);
}
	
            _bw.write(_wl_block231Bytes, _wl_block231);

	//}

            _bw.write(_wl_block232Bytes, _wl_block232);

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,ORbean,request);
}catch(Exception exception) {
       exception.printStackTrace();
 }

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDetails/UnitDose.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CalculateBy.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BodywtBSA.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dose.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDetails/UnitDose.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CalculateBy.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BodywtBSA.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllowAlternate.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.splapproval.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cosign.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TDMDetails.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dose.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
}
