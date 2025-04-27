package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ivprescriptiondrugdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVPrescriptionDrugDetails.jsp", 1732773191871L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="    \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/DrugNameCommonLookup.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/IVPrescriptionWithAdditives.js\"></SCRIPT>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n\t\t\t<FORM name=\"formIVPrescriptionDrugDetails\" id=\"formIVPrescriptionDrugDetails\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" VALUE=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" VALUE=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"patient_id\" id=\"patient_id\" VALUE=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" VALUE=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"start_date\" id=\"start_date\" VALUE=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"patient_class\" id=\"patient_class\" VALUE=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"act_patient_class\" id=\"act_patient_class\" VALUE=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"drug_codes\" id=\"drug_codes\" VALUE=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"resp_id\" id=\"resp_id\" VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"pract_id\" id=\"pract_id\" VALUE=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"pract_name\" id=\"pract_name\" VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"locn_type\" id=\"locn_type\" VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"locn_code\" id=\"locn_code\" VALUE=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"INFUSION_VALUE\" id=\"INFUSION_VALUE\" value=\"\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t\t<!-- added for ml-mmoh-crf-0863 start -->\n\t\t\t\t    <INPUT type=\"hidden\" name=\"take_home_medication\" id=\"take_home_medication\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t\t<INPUT type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t\t<INPUT type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<!-- added for ml-mmoh-crf-0863 end -->\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD WIDTH=\"17%\" CLASS=\"label\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;</TD>\n\t\t\t\t\t\t\t<TD WIDTH=\"83%\" colspan=\'3\'><INPUT TYPE=\"text\" name=\"DRUG_NAME\" id=\"DRUG_NAME\" VALUE=\"\" SIZE=\"45\" MAXLENGTH=\"40\" onBlur=\"checkValidDrug(\'D\', this.value)\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" > <INPUT TYPE=\"button\" CLASS=\"button\" name=\"DRUG_SEARCH\" id=\"DRUG_SEARCH\" VALUE=\"?\" onClick=\"searchIVDrugs(\'D\', DRUG_NAME)\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" >\n\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=hidden\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(DRUG_CODE.value);\" id=\"edlImg\">\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<IMG ID=\"mandate_drug\" SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></IMG>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD colspan=4><TABLE border=0><TR>\n\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</TD>\n\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" <input type=\"radio\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"D\" checked  disabled></TD>\n\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="<input type=\"radio\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"B\"  disabled></TD></TR></TABLE></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</TD>\n\t\t\t\t\t\t\t<TD><SELECT DISABLED name=\"DOSAGE\" id=\"DOSAGE\">\n\t\t\t\t\t\t\t\t<OPTION VALUE=\"\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</OPTION>\n\t\t\t\t\t\t\t\t<OPTION VALUE=\"\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</OPTION>\n\t\t\t\t\t\t\t\t</SELECT>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp;</TD>\n\t\t\t\t\t\t\t<TD >\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"STRENGTH_VALUE\" id=\"STRENGTH_VALUE\" VALUE=\"\"  DISABLED SIZE=\"10\" MAXLENGTH=\"11\" onKeyPress= \"return(ChkNumberInput(this,event,\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'))\">&nbsp;\n\t\t\t\t\t\t\t\t\n<!--   \"return allowValidNumber(this,event,8,";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =");\"-->\n\t\t\t\t\t\t\t\t<SELECT DISABLED name=\"STRENGTH_UOM\" id=\"STRENGTH_UOM\">\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"\">&nbsp;&nbsp;--- ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" ---&nbsp;&nbsp;</OPTION>\n\t\t\t\t\t\t\t\t</SELECT>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_product_id\" id=\"external_product_id\"  value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\" value=\"N\">\n\t\t\t\t\t</TABLE>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD WIDTH=\"15%\" CLASS=\"label\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;</TD>\n\t\t\t\t\t\t\t<TD WIDTH=\"*\" colspan=\'3\'>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="<!-- commented for SKR-SCF-1317 -->\n \t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"DRUG_NAME\" id=\"DRUG_NAME\" VALUE=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" SIZE=\"45\" MAXLENGTH=\"40\" DISABLED><INPUT TYPE=\"button\" CLASS=\"button\" name=\"DRUG_SEARCH\" id=\"DRUG_SEARCH\" VALUE=\"?\"  onClick=\"searchIVDrugs(\'D\', DRUG_NAME)\" DISABLED> <!-- REMOVED  onfocus for SKR-SCF-1317--> <!-- Modified for MMS-DM-CRF-0177 -->\n\n\t\t\t\t\t\t\t\t <img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(DRUG_CODE.value);\" id=\"edlImg\">\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t<IMG ID=\"mandate_drug\" SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></IMG>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<TD WIDTH=\"10%\" colspan=\'6\' TITLE=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' >&nbsp;&nbsp;&nbsp;<A HREF style=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" onMouseOver=\"changeCursor(this);\" onclick=\"viewReasonforRequest(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</A>&nbsp;</TD>\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</TR>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\"label\"   width=\"15%\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t<td colspan=8 class=\"data\" id=\"strength\" width=\"20%\">&nbsp;";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" / ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" \n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t<TD colspan=10><TABLE border=0><TR>\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<input type=\"radio\" id=\"CALC_DOSE_BASED_ON_D\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"D\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="  onClick=\"setCalculateBy(this,\'IVAD_NORMAL\');\"></TD>\n\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="<input type=\"radio\" id=\"CALC_DOSE_BASED_ON_B\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"B\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="  onClick=\"setCalculateBy(this,\'IVAD_NORMAL\');\">\n\n<!-- on click of the same radio button the value was getting changed. to avoid that, we have introduced this hidden var-->\n\t\t\t\t\t\t<input type=hidden name=\"current_CALC_DOSE_BASED_ON\" id=\"current_CALC_DOSE_BASED_ON\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\t\t\t\t<td CLASS=\"label\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&nbsp;\n\t\t\t\t\t<input type=\'checkbox\' name=\'allow_alternate_yn\' id=\'allow_alternate_yn\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" > </td><!-- GHL-CRF-0549-->\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t</TR></TABLE></TD>\n\t\t\t\t\t\t</TR><TR ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" id=\"calc_by_row1\">\n\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"DRUG_CODE\" id=\"DRUG_CODE\" VALUE=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t\t\t\t\t<TD WIDTH=\"15%\"  CLASS=\"label\" nowrap>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</TD>\n\t\t\t\t\t\t\t<TD WIDTH=\"25%\" ><SELECT name=\"DOSAGE\" id=\"DOSAGE\" onChange=\"changeScrDetails(this.value);ExternalDosageCheck(\'\',\'presc\');setEmptyDose();\" ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" >    <!-- setEmptyDose() is added for AAKH-CRF-0089  -->\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Q\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</OPTION>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"S\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</OPTION>\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Q\" SELECTED>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"S\" SELECTED>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</OPTION>\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Q\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t</SELECT>\n\t\t\t\t\t\t\t</TD>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t<TD WIDTH=\"10%\" CLASS=\"label\" ID=\"DOSAGE_LABEL\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</TD>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t<TD WIDTH=\"10%\" CLASS=\"label\" ID=\"DOSAGE_LABEL\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="&nbsp;</TD>\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t<TD colspan=\'4\' nowrap>\n\n \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="<!-- commented and added checkBeforeDecimal() and allowValidNumber() functions for ML-BRU-SCF-1437 -->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\'id_qty_value\' name=\"STRENGTH_VALUE\" id=\"STRENGTH_VALUE\"  VALUE=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" SIZE=\"10\" MAXLENGTH=\"13\" onChange=\"setCalculatedQty(this); DosageLimitCheck(this);\" ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" onKeyPress=\"checkBeforeDecimal(this,event); return allowValidNumber(this,event,8,";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =");\"  class=\"number\" >&nbsp;<SELECT name=\"STRENGTH_UOM\" id=\"STRENGTH_UOM\" ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" onChange=\"setQtyUOM(this.value);setDrugDosageDetails();\" ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =">   <!-- onBlur is changed to onChange and setEmptyDose() is included for AAHH-CRF-0089 -->\n\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"\">&nbsp;--- ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" ---&nbsp;</OPTION>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =">";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" \n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"\">&nbsp;--- ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t</SELECT><IMG SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></IMG>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t&nbsp;<a href=\"#\" onMouseOver=\"changeCursor(this);\" id=\"drug_remarks\" onClick=\"getFormatId(\'Drug\',\'Y\')\"> ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</A>&nbsp;&nbsp;\n\t\t\t\t\t\t\t        <!-- added for [IN:039576]-start -->\n\t\t\t\t\t\t\t        <img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' id=\'DrugRemarksMandImg\'></img>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksMandatory\' id=\'DrugRemarksMandatory\' value=\'N\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered\' id=\'DrugRemarksEntered\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t<!-- added for [IN:039576]-end -->\n\t\t\t\t\t\t\t<a href=\"#\" onMouseOver=\"changeCursor(this);\"  id=\"drug_ind_remarks\" onClick=\"drugindication_remarks()\">";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</a></TD><!--Added for  ML-BRU-CRF-072[Inc:29938]-->\n\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"INF_VAL\" id=\"INF_VAL\" VALUE=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t\t\t\t</TR>\t\t\t\t\t\t\t\n\t\t\t\t\t\t<TR ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" id=\"calc_by_row2\">\n\t\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</TD>\n\t\t\t\t\t\t\t<TD colspan=\"3\"><input type=\"text\" name=\"CALC_DOSE_VALUE\" id=\"CALC_DOSE_VALUE\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" size=\"5\" maxlength=\"8\" onKeyPress=\"return allowValidNumber(this,event,4,3);\" onBlur=\"calculateDosage_By_BSA_or_Weight(\'IVAD_NORMAL\');DosageLimitCheck(this);\" class=\"number\"><!-- Modified for IN:070451  -->\n\t\t\t\t\t\t\t<select name=\"calc_dose_value_unit\" id=\"calc_dose_value_unit\"><OPTION VALUE=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</OPTION></select><label class=\"label\"><b> / </b></label><select name=\"CALC_DOSE_BY\" id=\"CALC_DOSE_BY\" onChange=\"calculateDosage_By_BSA_or_Weight(\'IVAD_NORMAL\');\"><option value=\"KG\" ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</option><option value=\"M2\" ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</option></select><label class=\"label\"><b> = </b></label><INPUT TYPE=\"text\" name=\"strength_value_wt_bsa\" id=\"strength_value_wt_bsa\"  VALUE=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" SIZE=\"10\" MAXLENGTH=\"12\" onKeyPress=\"return allowValidNumber(this,event,8,3);\" class=\"number\"  onBlur=\"assignStrengthForBSA();setCalculatedQty(this); DosageLimitCheck(this);\">&nbsp;<label class=\"label\"> <b>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</b></label>\n\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></img></TD>\n\t\t\t\t\t\t\t<TD WIDTH=\"10%\" CLASS=\"label\"></TD>\t\t\t\t\t\t\t\n\t\t\t\t\t\t</TR>\n\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t<TR >\n\t\t\t\t\t\t\t\t<TD colspan=\'2\'>&nbsp;\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td CLASS=\"label\" ID=\"monograph\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t<label id=\'rec_legend\' onclick=\'defaultRecomDose()\'>\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t\t\t\t\t<font class=\'HYPERLINK\' onmouseover=\'changeCursor(this);\'>\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</font>\n\t\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t\t<label id=\"rec_value\" style=\"font-size:11;font-weight:bold;color:red\">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</label>\n\t\t\t\t\t\t\t\t\t&nbsp;<label id=\"rec_uom\" style=\"font-size:11;font-weight:bold;color:red\">";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</label>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\n\t\t\t\t\t</TABLE>\n\t\t\t\t\t<!-- Duplicate medication warning starts-->\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t<!-- Duplicate medication warning ends-->\n\n\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t<TR>\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\t<td class=\"label\" align=\'center\'><label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =";";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</label></td>\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t<td class=\"label\"  align=\'center\' colspan=\'2\'><label id=\'lbl_splapprvl\' style=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t\t\t<td class=\"label\" align=\'center\'><label id=\'lbl_cosign\' style=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t\t\t<TD WIDTH=\"15%\" CLASS=\"eORConsent\" ID=\"consent\" TITLE=\"Consent Required\"><FONT COLOR=\"#0066CC\" SIZE=\"1\"><B>";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</B></FONT></TD>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t\t\t<TD WIDTH=\"15%\" CLASS=\"label\" ID=\"consent\">&nbsp;</TD>\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t</TABLE>\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"GENERIC_ID\" id=\"GENERIC_ID\" VALUE=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"GENERIC_NAME\" id=\"GENERIC_NAME\" VALUE=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"DAILY_DOSE\" id=\"DAILY_DOSE\" VALUE=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"UNIT_DOSE\" id=\"UNIT_DOSE\" VALUE=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"MONO_GRAPH\" id=\"MONO_GRAPH\" VALUE=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"LIMIT_IND\" id=\"LIMIT_IND\" VALUE=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"dosage_std\" id=\"dosage_std\" VALUE=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"dosage_unit\" id=\"dosage_unit\" VALUE=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"recomm_dosage_by\" id=\"recomm_dosage_by\" VALUE=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"calc_by_ind\" id=\"calc_by_ind\" VALUE=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"recomm_yn\" id=\"recomm_yn\" VALUE=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"ALLERGY_YN\" id=\"ALLERGY_YN\" VALUE=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"CURRENT_RX\" id=\"CURRENT_RX\" VALUE=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"SRL_NO\" id=\"SRL_NO\" VALUE=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"FORM_CODE\" id=\"FORM_CODE\" VALUE=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"PRES_QTY_VALUE\" id=\"PRES_QTY_VALUE\" VALUE=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"PRES_BASE_UOM\" id=\"PRES_BASE_UOM\" VALUE=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"FREQ_CODE\" id=\"FREQ_CODE\" VALUE=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"DURN_VALUE\" id=\"DURN_VALUE\" VALUE=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"DURN_TYPE\" id=\"DURN_TYPE\" VALUE=\"H\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"OR_DURN_DESC\" id=\"OR_DURN_DESC\" VALUE=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"ORD_APPROVED_YN\" id=\"ORD_APPROVED_YN\" VALUE=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" ><!--APPROVAL_YN_VAL renamed as ORD_APPROVED_YN for HSA-SCF-0149 [IN:051784] -->\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"ORD_AUTHORIZED_YN\" id=\"ORD_AUTHORIZED_YN\" VALUE=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"> <!--AUTH_YN_VAL renamed as ORD_AUTHORIZED_YN for HSA-SCF-0149 [IN:051784] -->\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"ORD_COSIGNED_YN\" id=\"ORD_COSIGNED_YN\" VALUE=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"> <!--COSIGN_YN_VAL renamed as ORD_COSIGNED_YN for HSA-SCF-0149 [IN:051784] -->\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"ORDER_TYPE_CODE\" id=\"ORDER_TYPE_CODE\" VALUE=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"ROUTE_CODE\" id=\"ROUTE_CODE\" VALUE=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"END_DATE\" id=\"END_DATE\" VALUE=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"AUTH_YN\" id=\"AUTH_YN\" VALUE=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"APPROVAL_YN\" id=\"APPROVAL_YN\" VALUE=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"COSIGN_YN\" id=\"COSIGN_YN\" VALUE=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"CONSENT_REQD_YN\" id=\"CONSENT_REQD_YN\" VALUE=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"ALLERGY_DESC\" id=\"ALLERGY_DESC\" VALUE=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"EXCEED_DOSE_DESC\" id=\"EXCEED_DOSE_DESC\" VALUE=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"DUP_DRUG_DESC\" id=\"DUP_DRUG_DESC\" VALUE=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"UOM_CODE\" id=\"UOM_CODE\" VALUE=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"STRENGTH_UOM_DESC\" id=\"STRENGTH_UOM_DESC\" VALUE=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n<!--\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"STR_VAL\" id=\"STR_VAL\" VALUE=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">-->\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"STR_VAL\" id=\"STR_VAL\" VALUE=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"BMS_QTY\" id=\"BMS_QTY\" VALUE=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"DFLT_QTY_UOM\" id=\"DFLT_QTY_UOM\" VALUE=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"TAB_QTY_VALUE\" id=\"TAB_QTY_VALUE\" VALUE=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"QTY_DESC_CODE\" id=\"QTY_DESC_CODE\" VALUE=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"MIN_DAILY_DOSE\" id=\"MIN_DAILY_DOSE\" VALUE=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"MIN_UNIT_DOSE\" id=\"MIN_UNIT_DOSE\" VALUE=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t\t\t\t<!-- Added for IN:070451 start -->\n\t\t\t\t<input type=\"hidden\" name=\"max_daily_ceeling_dose\" id=\"max_daily_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_daily_ceeling_dose\" id=\"min_daily_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"max_unit_ceeling_dose\" id=\"max_unit_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_unit_ceeling_dose\" id=\"min_unit_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\t\t\n\t\t\t\t<!-- Added for IN:070451 end  -->\n\t\t\t\t\t<!-- Added for IN:072715 start -->\t\t\n      \t\t\t\t <input type=\"hidden\"  name=\"allergy_remarks_code\" id=\"allergy_remarks_code\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n       \t\t\t\t <input type=\"hidden\"  name=\"dose_remarks_code\" id=\"dose_remarks_code\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n      \t\t\t\t <input type=\"hidden\"  name=\"currentrx_remarks_code\" id=\"currentrx_remarks_code\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n      \t\t\t <!-- Added for IN:072715 end -->\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"STR_DESC\" id=\"STR_DESC\" VALUE=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"pack_size\" id=\"pack_size\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"license\" id=\"license\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"sRegRopt\" id=\"sRegRopt\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ORDERSET_STRENGTH\" id=\"ORDERSET_STRENGTH\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"strength_per_value_pres_uom\" id=\"strength_per_value_pres_uom\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"strength_per_pres_uom\" id=\"strength_per_pres_uom\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"interval_value\" id=\"interval_value\" value=\"1\">\t\n\t\t\t\t\t<input type=\"hidden\" name=\"perform_external_database_checks_yn\" id=\"perform_external_database_checks_yn\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_product_id\" id=\"external_product_id\"     value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"fract_dose_round_up_yn\" id=\"fract_dose_round_up_yn\"  value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason\" id=\"external_dosage_override_reason\" value=";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason\" id=\"external_duplicate_override_reason\" value=";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason\" id=\"external_interaction_override_reason\" value=";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason\" id=\"external_contra_override_reason\" value=";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_Alergy_override_reason\" id=\"external_Alergy_override_reason\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_dose_check_flag\" id=\"drug_db_dose_check_flag\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_yn\" id=\"amend_yn\" value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"saved_dosage_type\" id=\"saved_dosage_type\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"DrugIndicationRemarks\" id=\"DrugIndicationRemarks\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\"><!--Added for  ML-BRU-CRF-072[Inc:29938]-->\n\t\t\t\t\t<input type=\"hidden\" name=\"def_dosage_yn\" id=\"def_dosage_yn\" value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">   <!--Added for AAKH-CRF-0089 -->\n\t\t\t\t<input type=\"hidden\" name=\"abuse_restric_trn\" id=\"abuse_restric_trn\" value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\"> <!-- added for aakh-crf-0140 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"abuse_exists\" id=\"abuse_exists\"  value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\"><!-- added for aakh-crf-0140 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"ABUSE_OVERRIDE\" id=\"ABUSE_OVERRIDE\"  value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\"><!-- added for aakh-crf-0140 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"abuse_override_remarks\" id=\"abuse_override_remarks\"  value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\"><!-- added for aakh-crf-0140 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"abuse_drug_override_reason\" id=\"abuse_drug_override_reason\"  value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\"><!-- added for aakh-crf-0140 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"diagnosis_found_yn\" id=\"diagnosis_found_yn\"  value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\"><!-- added for MMS-DM-CRF-0204-->\n\t\t\t\t\t\n<input type=\"hidden\" name=\"abuse_action\" id=\"abuse_action\"  value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\t<!-- added for aakh-crf-0140 -->\n\t\t\t\t<input type=\"hidden\" name=\"item_type_site_app\" id=\"item_type_site_app\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" name=\"validate_overide_on_confirm_yn\"><!-- Added for IN:069887  -->\n\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\tDisableEnableDoseUOM();\n\t\t\t\t\t\tloadButtonsFrame();\n\t\t\t\t\t\tgetFormatId(\'Drug\',\'N\');\n\t\t\t\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t\t\tshowAbuseDetails(\'\', \'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\',\' ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\', \'\',\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\',\'Alert\');\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t    callCancel();\n\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t\t\t\n\t\t\t\t\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\tchangeScrDetails(document.formIVPrescriptionDrugDetails.DOSAGE.value);  // commented for IN23745 --14/09/2010-- priya \n\t\t\t\t\t\tdocument.formIVPrescriptionDrugDetails.STRENGTH_VALUE.focus();\n\t\t\t\t\t\n\t\t\t\t\t</SCRIPT>\n\t\t<!-- Hidden values ends-->\n";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tExternalDosageCheck(\'ONLOAD\',\'presc\');\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t\t<script>\n";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t\t\t\t   </script>\n";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\t\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.formIVPrescriptionDrugDetails.STRENGTH_VALUE.value=\"\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t\t</FORM>\n\t\t</BODY>\n\t\t<script> \n";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t\t\t//\tduplicateWarning();\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t</script>\n";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );
	
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
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
16/4/2020		IN072917			Shazana												SKR-SCF-1317
30/06/2020              IN:072715          Haribabu            25/06/2020              Manickavasagam J     MMS-DM-CRF-0165              
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
06/01/2021		TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
25-05-2022               AAKH-CRF-0140       PRATHYUSHA
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con			= null;   
	 try{
		con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
   	  	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
   	 boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
   	//Added for IN:069887  start
	boolean validate_overide_on_confirm =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","VALIDATE_OVERIDE_ON_CONFIRM");//added for MO-CRF-20152
	boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
	boolean req_diag_pres_found=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REQ_DIAG_PRES_FOUND");//added for MMS-DM-CRF-0204
			String validate_overide_on_confirm_yn="N";
	if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}		
//Added for IN:069887 end
		String patient_id		= request.getParameter("patient_id");		
		String encounter_id		= request.getParameter("encounter_id");
		String act_patient_class= request.getParameter("act_patient_class");
		String patient_class	= request.getParameter("patient_class")== null ? "":request.getParameter("patient_class");	//IN30118-SCF No: MO-GN-5400. Check Null for patient_class.
		String classValue	    = request.getParameter("classValue")==null?"":request.getParameter("classValue");		
		String mode				= request.getParameter("mode")==null?"":request.getParameter("mode");
		String start_date		= request.getParameter("start_date");
		String serialNum		= request.getParameter("serialNum") == null ? "":request.getParameter("serialNum");		
		String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
		// added for ml-mmoh-crf-0863 start 
		String iv_prep_yn		= request.getParameter("iv_prep_yn") == null ? "":request.getParameter("iv_prep_yn");
		String take_home_medication		= request.getParameter("take_home_medication") == null ? "":request.getParameter("take_home_medication");
		String priority		= request.getParameter("priority") == null ? "":request.getParameter("priority");
		// added for ml-mmoh-crf-0863 end
		System.out.println("take_home_medication in amend"+take_home_medication);
		System.out.println("priority in amend"+priority);
		System.out.println("iv_prep_yn in amend "+iv_prep_yn);
		String disaExst			= "";
		String disaAmend		= "";

		String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;

		if(!patient_class.equals("")){//IN30118-SCF No: MO-GN-5400. Set patient_class to Bean.
		bean.setPatientClass(patient_class);
		}
		bean.setExcludeADRAllergyAlert(CommonBean.checkForNull(request.getParameter("excludeADRAllergyAlert_yn")));
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		String or_bean_name		= "eOR.OrderEntryBean";
		OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
		if((bean.getOrder_type_flag()).equals("Existing")) 
			disaExst = "";
		if(mode.equals("amend")) 
			disaAmend = "disabled";
		String resp_id			= (String)ORbean.getResponsibilityId();
		String pract_id			= (String)ORbean.getPractitionerId();
		String pract_name		= (String)ORbean.getPractitionerName();
		String locn_type		= (String)ORbean.getLocationType();
		String locn_code		= (String)ORbean.getLocationCode();
		String order_id			= (String)ORbean.getOrderId();
		String license			=	bean.getLicense();
		String current_rx		=	"";
		String DrugRemarksEntered			=	""; //added for [IN:039576]
//changed during PE by naveen

		//String allow_duplicate	=	bean.checkDuplicateYN();//commented all for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
		//		String	allow_duplicate	=	"";
		//code added for external data base checks 
		
		String perform_external_database_checks_yn	=	"";	
		String loading_ext_prod_id					=	"";
		String external_dosage_override_reason		=   "";	
		String external_duplicate_override_reason	=   "";
		String external_interaction_override_reason	=   "";
		String external_contra_override_reason		=   ""; 
		String external_alergy_override_reason		=   ""; 
		String fract_dose_round_up_yn				=   "";
		String drug_db_dosage_check_flag			=   "Y";
	//GHL-CRF-0549 -start
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
		
		String ex_bean_id   = "@ExternalProductLinkBean";
		String ex_bean_name = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

	//comented during PE By Naveen

		/*	String facility_id					= (String)session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );*/
		//String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
		/*String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
		String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
		String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
		String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);*/
		//String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);   
		//param_bean.clear();	
		String display_auth_rule			=	"visibility:hidden";
		String color_auth_rule				=	"RED";
		String abuse_exists="";//added for aakh-crf-0140
		String abuse_action="";//aded for aakh-crf-0140
		String abuse_restric_trn="";//added for aakh-crf-0140
				String abuse_override="";//added for AAKH-CRF-0140
				String abuse_override_remarks="";//added for AAKH-CRF-0140
						String abuse_override_remarks1="";//added for aakh-crf-0140
	   //ends here

	//Added for MMS-DM-CRF-0177
	String new_generic_name = ""; 
	String pre_alloc_appl = ""; 
	String drug_search = "";
	pre_alloc_appl = bean.getPreAllocApplYN();
	//Added for MMS-DM-CRF-0177
		int dose_decimal = 2;

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( start_date ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( patient_class ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( act_patient_class ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( bean.getDrugCodes() ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( resp_id ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( pract_id ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( pract_name ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( locn_type ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( locn_code ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( mode ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(take_home_medication));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
 
				if (serialNum.equals("")) {

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disaAmend));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disaAmend));
            _bw.write(_wl_block30Bytes, _wl_block30);

							if (iv_option.equals("Y")) {

            _bw.write(_wl_block31Bytes, _wl_block31);

							}

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);


				}
				else {
					String facility_id					= (String)session.getValue("facility_id");
					String param_bean_id				= "@DrugInterfaceControlBean";
					String param_bean_name				= "ePH.DrugInterfaceControlBean";
					DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
					/* Commented for SRR20056-SCF-7354
					String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
					String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
					String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
					String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
					*/

					//Added for SRR20056-SCF-7354
					String drug_db_dosecheck_yn			= "N";
					String drug_db_duptherapy_yn		= "N";
					String drug_db_interact_check_yn	= "N";
					String drug_db_contraind_check_yn	= "N";
					String[] sDrugDBAllChecks = param_bean.drugDBALLChecksYN(facility_id);
					if(sDrugDBAllChecks != null && sDrugDBAllChecks.length>5){
						drug_db_dosecheck_yn			=	sDrugDBAllChecks[2];    
						drug_db_duptherapy_yn		=	sDrugDBAllChecks[3];    
						drug_db_interact_check_yn	=	sDrugDBAllChecks[4];      
						drug_db_contraind_check_yn	=	sDrugDBAllChecks[5];    
					}
					//SRR20056-SCF-7354
					param_bean.clear();	


					String disabled	= "";
					int srlNo		= 0;
					srlNo			= Integer.parseInt(serialNum);
					ArrayList drugList			= bean.getDrugDetails();

					HashMap drugDetails			= (HashMap)drugList.get(srlNo-1);
					ArrayList orderSetValues	= bean.getOrderSetValues();
					String generic_id			= (String)drugDetails.get("GENERIC_ID");
					String drug_desc			= (String)drugDetails.get("DRUG_DESC");
					String drug_code			= (String)drugDetails.get("DRUG_CODE");
					String generic_name			= (String)drugDetails.get("GENERIC_NAME");
					String daily_dose			= (String)drugDetails.get("DAILY_DOSE");
					String min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_DOSE");
					String min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_DOSE");
					String unit_dose			= (String)drugDetails.get("UNIT_DOSE")==null?"":(String)drugDetails.get("UNIT_DOSE");
					String dosage_std			= (String)drugDetails.get("DOSAGE_STD")==null?"":(String)drugDetails.get("DOSAGE_STD");
					String recomm_dosage_by		= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
					String calc_by_ind			= (String)drugDetails.get("CALC_BY_IND")==null?"":(String)drugDetails.get("CALC_BY_IND");
					String mono_graph			= (String)drugDetails.get("MONO_GRAPH")==null?"":(String)drugDetails.get("MONO_GRAPH");
					String limit_ind			= (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
					//Added for IN:070451 start
					String      max_daily_ceeling_dose	    =   (String)drugDetails.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
					String		min_daily_ceeling_dose	    =   (String)drugDetails.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
					String		max_unit_ceeling_dose	    =   (String)drugDetails.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
					String		min_unit_ceeling_dose	    =   (String)drugDetails.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
					//Added for IN:070451 end
					//Added for IN:072715 start
					String allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
					String dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
					String currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
					//Added for IN:072715 end
					String allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
					current_rx					= (String)drugDetails.get("CURRENT_RX");
					String srl_no				= (String)drugDetails.get("SRL_NO");
					String strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
					String act_strength_value=(String)drugDetails.get("ACT_STRENGTH_VALUE");//added for NMC-JD-CRF-0026
					String def_dosage_yn=(String)drugDetails.get("DEF_DOSAGE_YN")==null?"":(String)drugDetails.get("DEF_DOSAGE_YN");  //Added for AAKH-CRF-0089 ends
					String strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
					String strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
					String form_code			= (String)drugDetails.get("FORM_CODE");
					String pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
					String pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
					String freq_code			= (String)drugDetails.get("FREQ_CODE");
					String durn_value			= (String)drugDetails.get("DURN_VALUE");
					String or_durn_desc			= (String)drugDetails.get("OR_DURN_DESC");
					//String auth_yn_val			= (String)drugDetails.get("AUTH_YN_VAL");
					//String approval_yn_val		= (String)drugDetails.get("APPROVAL_YN_VAL");
					//String cosign_yn_val		= (String)drugDetails.get("COSIGN_YN_VAL");
					String auth_yn				= (String)drugDetails.get("AUTH_YN");
					String approval_yn			= (String)drugDetails.get("APPROVAL_YN");
					String cosign_yn			= (String)drugDetails.get("COSIGN_YN");
					String consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
					String order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
					String fract_dose_appl_yn	= (String)drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_APPL_YN");
					String route_code			= (String)drugDetails.get("ROUTE_CODE");
					String startdate			= (String)drugDetails.get("START_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
					String end_date				= (String)drugDetails.get("END_DATE");
					String dup_drug_desc		= (String)drugDetails.get("CURRENTRX_REMARKS");
					String allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS");
					String exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS");
					String dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
					String bms_qty				= (String)drugDetails.get("BMS_QTY");
					String dflt_qty_uom			= (String)drugDetails.get("DFLT_QTY_UOM");
					String tab_qty_value		= (String)drugDetails.get("TAB_QTY_VALUE");
					String qty_desc_code		= (String)drugDetails.get("QTY_DESC_CODE");
					String amend_yn				= (String)drugDetails.get("AMEND_YN");
					String qty_value			= (String)drugDetails.get("QTY_VALUE");
					String dosage_unit			= (String)drugDetails.get("DOSAGE_UNIT");
					String ord_auth_reqd_yn		= (String) drugDetails.get("ORD_AUTH_REQD_YN")==null?"":(String) drugDetails.get("ORD_AUTH_REQD_YN");
					String ord_spl_appr_reqd_yn	= (String) drugDetails.get("ORD_SPL_APPR_REQD_YN")==null?"":(String) drugDetails.get("ORD_SPL_APPR_REQD_YN");
					String ord_cosign_reqd_yn	= (String) drugDetails.get("ORD_COSIGN_REQD_YN")==null?"":(String) drugDetails.get("ORD_COSIGN_REQD_YN");
					String ord_authorized_yn	= (String) drugDetails.get("ORD_AUTHORIZED_YN")==null?"":(String) drugDetails.get("ORD_AUTHORIZED_YN");
					String ord_authorized_prev_yn	= (String) drugDetails.get("ORD_AUTHORIZED_PREV_YN")==null?"":(String) drugDetails.get("ORD_AUTHORIZED_PREV_YN");
					String ord_approved_yn		= (String) drugDetails.get("ORD_APPROVED_YN")==null?"":(String) drugDetails.get("ORD_APPROVED_YN");
					String ord_cosigned_yn		= (String) drugDetails.get("ORD_COSIGNED_YN")==null?"N":(String) drugDetails.get("ORD_COSIGNED_YN");
					String sRegRopt				= (String)drugDetails.get("REQD_OR_OPT_IND"); 
					String strength_per_value_pres_uom  = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
					if(drug_abuse_appl){
					abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"N":(String)drugDetails.get("ABUSE_EXISTS"); //Added for AAKH-CRF-0140
					abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"U":(String)drugDetails.get("ABUSE_ACTION"); //Added for AAKH-CRF-0140
					abuse_restric_trn=(String)drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N":(String)drugDetails.get("ABUSE_RESTRIC_TRN"); //Added for AAKH-CRF-0140
					abuse_override_remarks=(String)drugDetails.get("abuse_drug_override_reason")==null?"":(String)drugDetails.get("abuse_drug_override_reason"); //Added for AAKH-CRF-0140
					abuse_override_remarks1=(String)drugDetails.get("abuse_override_remarks")==null?"":(String)drugDetails.get("abuse_override_remarks"); //Added for AAKH-CRF-0140
					
					abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"U":(String)drugDetails.get("ABUSE_OVERRIDE"); //Added for AAKH-CRF-0140
					System.out.println("333 abuse_restric_trn"+abuse_restric_trn);
					System.out.println(abuse_override_remarks1+"334 abuse_override_remarks"+abuse_override_remarks);
					}
					else{
						abuse_exists="N";
						abuse_action="U";
						abuse_restric_trn="N";
						abuse_override_remarks="";//added for aakh-crf-0140
						abuse_override="";//added for aakh-crf-0140
					}
					//added for MMS-DM-CRF-0204 START
					String diagnosis_found_yn="";
                     diagnosis_found_yn=(String)drugDetails.get("DIAGNOSIS_FOUND_YN");//mms-dm-crf-0204	
							if(req_diag_pres_found){
								 diagnosis_found_yn=(String)drugDetails.get("DIAGNOSIS_FOUND_YN");//mms-dm-crf-0204	
										
							}
							else{
								diagnosis_found_yn="G";
							}
							//added for MMS-DM-CRF-0204 END
					String strength_per_pres_uom		= (String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
					String DrugIndicationRemarks				= (String)drugDetails.get("DRUG_INDICATION")==null?"":(String) drugDetails.get("DRUG_INDICATION");//Added for  ML-BRU-CRF-072[Inc:29938]  
					if(!DrugIndicationRemarks.equals(""))
						DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8");
					String ext_prod_id			= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
					/*	if(bean.getPatientClass()!=null && bean.getPatientClass().equals("IP")){//IN30118-SCF No: MO-GN-5400. Assingning OutPatient Duplicate Drug Check.
								allow_duplicate		= (String)drugDetails.get("ALLOW_DUPLICATE_DRUG");
						}else if(bean.getPatientClass()!=null && bean.getPatientClass().equals("OP")){
							allow_duplicate = (String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
						}*/ 	//commented all for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
					String calc_dose_based_on	= (String)drugDetails.get("CALC_DOSE_BASED_ON");
					String calc_dose_value		= "";
					String calc_dose_by			= "KG";
					String select_calc_dose_Dosage="checked";
					String select_calc_dose_WT_BSA="";
					String kg_selected			="Selected";
					String m2_selected			="";
					String displaydose			="";
					String displayBSA			="style='display:none'";
					String disable_calc_dose	="";
					//===============================//
					if(calc_dose_based_on!=null && calc_dose_based_on.equals("B")) // calculate the dose based on the BSA or Weight
					{
						select_calc_dose_Dosage="";
						select_calc_dose_WT_BSA="checked";
						
						calc_dose_value	= (String)drugDetails.get("CALC_DOSE_VALUE");
						calc_dose_by	= (String)drugDetails.get("CALC_DOSE_BY");
						displaydose		= "style='display:none'";
						displayBSA		= "";
						if(calc_dose_by.equals("M2"))
						{
							kg_selected	=	"";
							m2_selected	=	"Selected";
						}
					}

					drug_db_dosage_check_flag				= (String) drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	
					perform_external_database_checks_yn		= (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");		
					loading_ext_prod_id						= ext_prod_id;
					external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
					external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
					external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
					external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
					external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
					
					//Added for MMS-DM-CRF-0177
					drug_search = (String) drugDetails.get("DRUG_SEARCH_BY")==null?"":(String) drugDetails.get("DRUG_SEARCH_BY");
					if(pre_alloc_appl.equals("Y") && drug_search.equals("G") && !mode.equals("amend"))
					{
						new_generic_name= (String)drugDetails.get("DRUG_DESC_NEW")==null?"":(String)drugDetails.get("DRUG_DESC_NEW");
					}
					else
					{
						new_generic_name= drug_desc;
					}
					//Added for MMS-DM-CRF-0177
					
					HashMap practRights	= (HashMap)bean.getAuthorizationReqd(resp_id, pract_id);
					String dflt_code	= "";
					String pack_values	=	bean.getInfuseOverValue(drug_code,"");//Added "" for ML-MMOH-CRF-1223
					StringTokenizer st1	=	new StringTokenizer(pack_values,"::");
					String pack_size	=	"";

					if(fract_dose_appl_yn.equals("N"))
						dose_decimal = 0;
					if(recomm_dosage_by.equals("B"))
						recomm_dosage_by = "Q";

					if(st1.hasMoreTokens()) {
						st1.nextToken(); st1.nextToken(); st1.nextToken();
						pack_size	=	st1.nextToken();
					}

					if (!classValue.equals("AMENDEDDRUGS")) {
					
						String orgLineNum	= Integer.toString(srlNo+1);
						HashMap qtyValues	=	bean.getQtyValue(patient_id,order_id,orgLineNum);
						dflt_code			= (String)qtyValues.get("strengthUom")==null?"":(String)qtyValues.get("strengthUom");
						if((bean.getOrder_type_flag()).equals("Existing")) 
							qty_desc_code = dflt_code;
					}
					//TDM

					String tdmOrder_id		= "";
					String display_tdm		= "display:none";
					if(drugDetails.get("TDM_ORDER_ID")== null){
						tdmOrder_id				= bean.getOrderIdForTDMDtls(patient_id,drug_code);
						drugDetails.put("TDM_ORDER_ID",tdmOrder_id);
					}
					else 
						tdmOrder_id = (String)drugDetails.get("TDM_ORDER_ID");

					if(tdmOrder_id==null||tdmOrder_id.equals("")){
						display_tdm			="display:none";
					}else{
						display_tdm			="display:inline";
					} 

						//code for drug interaction check
					HashMap drug_Interactions				= null;
					String drug_db_interact_check_flag	= "N";
					String drug_db_duptherapy_flag		= "N";
					String drug_db_contraind_check_flag	= "N";
					String dup_drug_det					= "";

					if(perform_external_database_checks_yn.equals("Y")){
/*
						if(drug_db_interact_check_yn.equals("Y")){
							if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
								beanex.getDDInteractions(loading_ext_prod_id);//Store interactions
								drug_Interactions		= beanex.getInteractions();//get Interactions
								if(drug_Interactions.size()>0){							
									drug_db_interact_check_flag="Y";
								}
							}
						}
						if(drug_db_duptherapy_yn.equals("Y")){ 
							dup_drug_det			= beanex.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result
							if(!dup_drug_det.equals("")&&dup_drug_det!=null)
								drug_db_duptherapy_flag="Y";
						}

						if(drug_db_contraind_check_yn.equals("Y")){
							ArrayList ex_prod_ids =new ArrayList();
							ex_prod_ids.add(loading_ext_prod_id);

							boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
							HashMap contra_indications =(HashMap)beanex.getContraIndications();
							if(contra_indications.containsKey(ext_prod_id)){
							// String  contra_indication_for_drug   =(String)contra_indications.get(ext_prod_id);
								drug_db_contraind_check_flag="Y";
							}					  
						}  
*/
						if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")){
							String storeIDs = "N";
							HashMap tempDetails= null;
							/*ArrayList reqChecks = new ArrayList();
							reqChecks.add("N"); //Dosage Check 
							reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
							reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
							reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
							reqChecks.add("N"); //AllergyCheck  - is done in IVPiggyBackDrugDetails.jsp
							HashMap drugDosageResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", null ,null, null, storeIDs); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
*/
							HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBCheckResult(ext_prod_id, srl_no);
							if(drugDBCheckResult==null){
								ArrayList reqChecks = new ArrayList();
								reqChecks.add("N"); //Dosage Check 
								reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
								reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
								reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
								reqChecks.add("N"); //AllergyCheck  - is done in IVPiggyBackDrugDetails.jsp
								drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", null ,null, null, storeIDs, startdate, end_date); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
								if(drugDBCheckResult!=null)
									beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
							}
							drug_db_interact_check_flag="N";
							drug_db_duptherapy_flag="N";
							drug_db_contraind_check_flag="N";
							if(drugDBCheckResult!=null){
								if(drug_db_interact_check_yn.equals("Y")){
									tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
									if(tempDetails!=null && tempDetails.size()>0){
										 drug_db_interact_check_flag="Y";
									}
								}

								if(drug_db_duptherapy_yn.equals("Y")){ 
								   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
								   if(dup_drug_det!=null && !dup_drug_det.equals(""))
										drug_db_duptherapy_flag="Y";
								   }
								if(drug_db_contraind_check_yn.equals("Y")){
									if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS
										tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */

			System.err.println("----------tempDetails"+tempDetails);
									if(tempDetails!=null && tempDetails.size()>0){ //IN066787- Performance
										 drug_db_contraind_check_flag="Y";
									}
									
									}
									else{
										tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
										if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
											drug_db_contraind_check_flag="Y";
										}	
									}
								}
							}
						}
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
					}
										

            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(new_generic_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

								if (iv_option.equals("Y")) {

            _bw.write(_wl_block47Bytes, _wl_block47);

								}

            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(display_tdm));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(tdmOrder_id));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
if(strength_value.equals("0")){				
							select_calc_dose_Dosage ="checked";
							select_calc_dose_WT_BSA ="";
							disable_calc_dose		="disabled";						

						}
						//added for nmc-jd-crf-0026 start
						if(strength_display_app){
						
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
if(act_strength_value!=null && act_strength_value!="" && !act_strength_value.equals("0")){
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(act_strength_value));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),pres_base_uom)));
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
}//added for nmc-jd-crf-0026 end
						
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(select_calc_dose_Dosage));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disable_calc_dose));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(select_calc_dose_WT_BSA));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disable_calc_dose));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(select_calc_dose_Dosage.equals("checked")?'D':'B'));
            _bw.write(_wl_block65Bytes, _wl_block65);
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
							
							if(mm_item_Innovator_yn.equals("Y")) //GHL-SCF-1430
								checked = "";
							
							if(!mm_item_low_cost_yn.equals("Y") && !mm_item_high_margin_yn.equals("Y") && !mm_item_Innovator_yn.equals("Y")){ //4/24/2019
								checked = "checked";
							}//GHL-SCF-1430 - end

							allow_alternate_disabled = "";
						
						}else{
							allow_alternate_disabled = "disabled";
						}
						if(allow_alternate_yn.equals("Y")) 
							checked = "checked";
						
					} 	//GHL-CRF-0549 - end
					if(item_type_site_app && disp_by_alt_form_param.equals("Y")){ //GHL-CRF-549

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(allow_alternate_yn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(allow_alternate_disabled));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block69Bytes, _wl_block69);

					}

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(displaydose));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( drug_code ));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disaExst));
            _bw.write(_wl_block74Bytes, _wl_block74);
						
								if (strength_value.equals("0")) {

            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

								}
								else {
									if(dosage_type.equals("Q")) {

            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

									}
									else {

            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

									}
								}

            _bw.write(_wl_block81Bytes, _wl_block81);

							String str_value = "";
							if (strength_value.equals("0")) {
								disabled	= "";
								str_value	= pres_qty_value;

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

							}
							else {
								if(dosage_type.equals("S")) {
									str_value	= strength_value;
									disabled	= "DISABLED";


            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

								}
								else {
									str_value	= pres_qty_value;
									disabled	= "";


            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

								}
							}
							if(qty_value!=null && !qty_value.equals("")) {
								str_value	=	qty_value;
							}

							if(orderSetValues.size() > 0){
								for(int i = 0; i < orderSetValues.size(); i=i+8){
									if(orderSetValues.get(i).equals(drug_code)){
										qty_value	= (String)orderSetValues.get(i+1);
										if(dosage_type.equals("S")){
											str_value = ((Float.parseFloat(qty_value)*Float.parseFloat(strength_value))/Float.parseFloat(strength_per_value_pres_uom))+"";
										}
									}
								}
							}

							if(str_value != null && str_value != "" && Float.parseFloat(str_value) < 1.0){
								str_value = Float.parseFloat(str_value)+"";
							}

            _bw.write(_wl_block86Bytes, _wl_block86);
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf( str_value ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(disaExst));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( disabled ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(disaExst));
            _bw.write(_wl_block92Bytes, _wl_block92);

								if (!strength_value.equals("0")) {
									if(dosage_type.equals("S")) {

            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf( strength_uom ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( strength_uom_desc ));
            _bw.write(_wl_block76Bytes, _wl_block76);

									}
									else {

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

										Hashtable QtyDescDetails	= (Hashtable)bean.listQtyDetails(drug_code);
										Enumeration keys_des		= QtyDescDetails.keys();
										String uom_code				= "";
										String uom_desc				= "";
										String def_uom				= "";

										while(keys_des.hasMoreElements()) {
											uom_code	= (String)keys_des.nextElement();
											uom_desc	= (String)QtyDescDetails.get(uom_code);

											if(!uom_code.equals("dflt_code")) {
												if(uom_code.equals(qty_desc_code))
													def_uom = "SELECTED";
												else
													def_uom = "";

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf( uom_code ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( def_uom ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf( uom_desc ));
            _bw.write(_wl_block76Bytes, _wl_block76);

											}
										}
									}
								}
								else {

            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

									Hashtable QtyDescDetails	= (Hashtable)bean.listQtyDetails(drug_code);
									Enumeration keys_des		= QtyDescDetails.keys();
									String uom_code				= "";
									String uom_desc				= "";
									String def_uom				= "";

									if (amend_yn.equals("N"))
										dflt_code = QtyDescDetails.get("dflt_code") == null ? "" : QtyDescDetails.get("dflt_code").toString();
									else
										dflt_code = qty_desc_code;

									while(keys_des.hasMoreElements()) {
										uom_code	= (String)keys_des.nextElement();
										uom_desc	= (String)QtyDescDetails.get(uom_code);

										if(!uom_code.equals("dflt_code")) {
											if(uom_code.equals(dflt_code))
												def_uom = "SELECTED";
											else
												def_uom = "";

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf( uom_code ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( def_uom ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf( uom_desc ));
            _bw.write(_wl_block76Bytes, _wl_block76);

										}
									}
								}

            _bw.write(_wl_block102Bytes, _wl_block102);

							//String inf_uom = "";
							int srlNum		= Integer.parseInt(srl_no)-1;
							String inf_val	= bean.getInfRate(Integer.toString(srlNum), 3);

							if (strength_value.equals("0")) {
								disabled = "DISABLED";
							}
							else {
								if(dosage_type.equals("S")) {
									//inf_uom = strength_uom_desc;
									disabled = "";

									if(!inf_val.equals("") && !(bean.getInfRate(Integer.toString(srlNum), 1).equals(Integer.toString(srlNum)))){
										disabled = "DISABLED";
									}
									else if (inf_val.equals("")) {
										disabled = "";
									}
								}
								else {
									disabled = "DISABLED";
								}
							}

            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf( bean.getInfRate(Integer.toString(srlNum), 2) ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(displayBSA));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(calc_dose_value));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( strength_uom_desc));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(kg_selected));
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(m2_selected));
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);

						if(drugDetails.get("RECOMM_YN").equals("Y")) {

            _bw.write(_wl_block116Bytes, _wl_block116);

									if(dosage_type.equals(recomm_dosage_by)){

            _bw.write(_wl_block117Bytes, _wl_block117);

									}

            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block121Bytes, _wl_block121);

						}

            _bw.write(_wl_block122Bytes, _wl_block122);
	
	//commented all for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
//					if((current_rx.equals("Y") && allow_duplicate.equals("N"))) {//IN30118-SCF No: MO-GN-5400. Removed condition patient_class.equals("IP").	
		//commented all for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
/*
							String dup_drug_info	=	"";
							ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
							HashMap  dup_info		=	null;

							if(curr_info.size()>=1) {
								dup_info	  =	(HashMap)curr_info.get(0);
								dup_drug_info = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PatientisCurrentlyOn.label","ph_labels")+" "+generic_name+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Medicationtill.label","ph_labels")+dup_info.get("end_date")+";\n";
								dup_drug_info =  dup_drug_info + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hasbeenprescribedby.label","ph_labels")+dup_info.get("practitioner_name")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.from.label","ph_labels")+dup_info.get("location");
							}*/
				//	} //Marque HTML code also remmoved  for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX

            _bw.write(_wl_block123Bytes, _wl_block123);

							display_auth_rule = "visibility:hidden";
							if(ord_auth_reqd_yn != null && ord_auth_reqd_yn.equals("Y")){
								display_auth_rule	= "visibility:visible";
								color_auth_rule		= "color:red";
								if(ord_authorized_yn.equals("Y"))
									color_auth_rule = "color:green";
							}

            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

							display_auth_rule	= "visibility:hidden";
							color_auth_rule		= "color:red";
							if(ord_spl_appr_reqd_yn != null && ord_spl_appr_reqd_yn.equals("Y")){
								display_auth_rule = "visibility:visible";
								if(ord_approved_yn.equals("Y"))
									color_auth_rule = "color:green";
							}

            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

							display_auth_rule = "visibility:hidden";
							color_auth_rule   = "color:red";
							if(ord_cosign_reqd_yn != null && ord_cosign_reqd_yn.equals("Y")){
								display_auth_rule = "visibility:visible";
								if(ord_cosigned_yn.equals("Y"))
									color_auth_rule = "color:green";
							}

            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

							if (drugDetails.get("CONSENT_REQD_YN").equals("Y")) {

            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);

							}
							else {

            _bw.write(_wl_block132Bytes, _wl_block132);

							}

            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf( generic_id ));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf( generic_name ));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf( daily_dose ));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf( unit_dose ));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf( mono_graph ));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf( limit_ind ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf( dosage_std ));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf( dosage_unit ));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf( recomm_dosage_by ));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf( calc_by_ind ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf( drugDetails.get("RECOMM_YN")==null?"":drugDetails.get("RECOMM_YN") ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf( allergy_yn ));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf( current_rx ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf( srl_no ));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf( form_code ));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf( pres_qty_value ));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf( pres_base_uom ));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf( freq_code ));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf( durn_value ));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf( or_durn_desc ));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf( ord_approved_yn ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf( ord_authorized_yn ));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf( ord_cosigned_yn ));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf( order_type_code ));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf( route_code ));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf( end_date ));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf( auth_yn ));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf( approval_yn ));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf( cosign_yn ));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf( consent_reqd_yn ));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf( allergy_desc ));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf( exceed_dose_desc ));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf( dup_drug_desc ));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf( strength_uom ));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf( strength_uom_desc ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf( strength_value ));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf( str_value ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf( bms_qty ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf( dflt_qty_uom ));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf( tab_qty_value ));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf( qty_desc_code ));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf( min_daily_dose ));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf( min_unit_dose ));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(allergy_remarks_code));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(dose_remarks_code));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(currentrx_remarks_code));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(pack_size));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(license));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(sRegRopt));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(strength_per_pres_uom));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(fract_dose_round_up_yn));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(external_dosage_override_reason));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(external_duplicate_override_reason));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(external_interaction_override_reason));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(external_contra_override_reason));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(external_alergy_override_reason));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(amend_yn));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(def_dosage_yn));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(abuse_restric_trn));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(abuse_exists));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(abuse_override));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(abuse_override_remarks1));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(abuse_override_remarks));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(diagnosis_found_yn));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(abuse_action));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(item_type_site_app));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(validate_overide_on_confirm_yn));
            _bw.write(_wl_block212Bytes, _wl_block212);
	if((abuse_exists.equals("Y") && abuse_action.equals("B") && !(bean.getOrder_type_flag().equals("Existing") || classValue.equals("AMENDEDDRUGS")))){
						System.out.println("1028 mode"+mode);
						
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block216Bytes, _wl_block216);
} 
					if(req_diag_pres_found && diagnosis_found_yn.equals("N")){ // added for mms-dm-crf-0204
					
            _bw.write(_wl_block217Bytes, _wl_block217);
}
						
            _bw.write(_wl_block218Bytes, _wl_block218);

System.out.println("1042"+bean.getOrder_type_flag().equals("Existing"));	
						System.out.println("1042"+classValue);	
if(!(bean.getOrder_type_flag().equals("Existing") || classValue.equals("AMENDEDDRUGS"))) //if condition added and comment removed from below line (strength value was coming as null) --08/10/2010-- priya   //classValue.equals("AMENDEDDRUGS") was added coz when dose value was changed and confirmed, then when reloading the default value was geting loaded.
					{

            _bw.write(_wl_block219Bytes, _wl_block219);

					}
					if(!mode.equals("blank")&& perform_external_database_checks_yn.equals("Y")){		  
						if(drug_db_dosecheck_yn.equals("Y")){

            _bw.write(_wl_block220Bytes, _wl_block220);

						}

            _bw.write(_wl_block221Bytes, _wl_block221);

						  //out.println("viewMedicationAlert('"+patient_id+"','"+loading_ext_prod_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dosage_check_flag+"','ONLOAD','"+external_dosage_override_reason+"','"+drug_code+"','"+srl_no+"','"+external_duplicate_override_reason+"','"+external_interaction_override_reason+"','"+external_contra_override_reason+"','"+pract_name+"','"+external_alergy_override_reason+"','"+drug_db_dosecheck_yn+"')");

            _bw.write(_wl_block222Bytes, _wl_block222);

					}
					
					//AAKH-CRF-0089 starts
					
					if(def_dosage_yn.equals("N") && amend_yn.equals("N") && !(bean.getOrder_type_flag().equals("Existing"))){
					
            _bw.write(_wl_block223Bytes, _wl_block223);
	
					}
					//AAKH-CRF-0089 ends
				}

            _bw.write(_wl_block224Bytes, _wl_block224);
 
	//commented all for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
			//if(current_rx.equals("Y") && allow_duplicate.equals("N")) { //IN30118-SCF No: MO-GN-5400. Removed condition patient_class.equals("IP").

            _bw.write(_wl_block225Bytes, _wl_block225);

		//	}

            _bw.write(_wl_block226Bytes, _wl_block226);

		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,ORbean,request);	
	}
	catch(Exception e) {
		e.printStackTrace();
	}finally{ 
        	if(con != null)
          		ConnectionManager.returnConnection(con,request);	 //added for GHL-CRF-0549
	}

            _bw.write(_wl_block227Bytes, _wl_block227);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Additive.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CalculateBy.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BodywtBSA.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DosageBy.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Additive.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Result.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CalculateBy.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BodywtBSA.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllowAlternate.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DosageBy.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dose.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dose.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.KG.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.M2.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.splapproval.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cosign.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ConsentReqd..label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }
}
