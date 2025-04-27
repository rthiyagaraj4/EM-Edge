package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import java.sql.*;
import webbeans.eCommon.*;
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

public final class __ivamenddrugdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVAmendDrugDetails.jsp", 1709120882450L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<!-- ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<HTML>\n\t<HEAD>\n\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/DrugNameCommonLookup.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IVPrescriptionWithAdditives.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</HEAD>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n\t\t<FORM name=\"formIVPrescriptionDrugDetails\" id=\"formIVPrescriptionDrugDetails\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" VALUE=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" VALUE=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"patient_id\" id=\"patient_id\" VALUE=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" VALUE=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"start_date\" id=\"start_date\" VALUE=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"patient_class\" id=\"patient_class\" VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"drug_codes\" id=\"drug_codes\" VALUE=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"resp_id\" id=\"resp_id\" VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"pract_id\" id=\"pract_id\" VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"pract_name\" id=\"pract_name\" VALUE=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"locn_type\" id=\"locn_type\" VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"locn_code\" id=\"locn_code\" VALUE=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<input type=\"hidden\" name=\"INFUSION_VALUE\" id=\"INFUSION_VALUE\" value=\"\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" VALUE=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t<TR> \n\t\t\t\t\t\t<TD WIDTH=\"17%\" CLASS=\"label\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;</TD>\n\t\t\t\t\t\t<TD WIDTH=\"83%\" colspan=\'3\'><INPUT TYPE=\"text\" name=\"DRUG_NAME\" id=\"DRUG_NAME\" VALUE=\"\" SIZE=\"45\" MAXLENGTH=\"40\" onBlur=\"checkValidDrug(\'D\', this.value)\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" ><INPUT TYPE=\"button\" CLASS=\"button\" name=\"DRUG_SEARCH\" id=\"DRUG_SEARCH\" VALUE=\"?\" onClick=\"searchIVDrugs(\'D\', DRUG_NAME)\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"\" id=\"edlImg\">\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t<IMG ID=\"mandate_drug\" SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></IMG>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>  \n\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" </TD>\n\t\t\t\t\t\t<TD  ><SELECT DISABLED name=\"DOSAGE\" id=\"DOSAGE\">\n\t\t\t\t\t\t\t<OPTION VALUE=\"\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</OPTION>\n\t\t\t\t\t\t\t<OPTION VALUE=\"\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</OPTION>\n\t\t\t\t\t\t\t</SELECT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD  CLASS=\"label\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</TD>\n\t\t\t\t\t\t<TD  >\n\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"STRENGTH_VALUE\" id=\"STRENGTH_VALUE\" VALUE=\"\" CLASS=\"number\" DISABLED SIZE=\"3\" MAXLENGTH=\"6\"><SELECT DISABLED name=\"STRENGTH_UOM\" id=\"STRENGTH_UOM\">\n\t\t\t\t\t\t\t\t<OPTION VALUE=\"\">&nbsp;&nbsp;--- ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ---&nbsp;&nbsp;</OPTION>\n\t\t\t\t\t\t\t</SELECT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TABLE>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t<TR>\n\t\t\t\t\t<TD WIDTH=\"10%\" CLASS=\"label\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</TD>\n\t\t\t\t\t<TD WIDTH=\"60%\" colspan=\'3\'><INPUT TYPE=\"text\" name=\"DRUG_NAME\" id=\"DRUG_NAME\" VALUE=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" SIZE=\"45\" MAXLENGTH=\"40\" DISABLED><INPUT TYPE=\"button\" CLASS=\"button\" name=\"DRUG_SEARCH\" id=\"DRUG_SEARCH\" VALUE=\"?\" onClick=\"searchIVDrugs(\'D\', DRUG_NAME)\" DISABLED>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t<IMG ID=\"mandate_drug\" SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></IMG>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(DRUG_CODE.value);\" id=\"edlImg\">\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<TD class=\"label\"  WIDTH=\"30%\" TITLE=\"TDM Result\"><A HREF style=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onMouseOver=\"changeCursor(this);\" onclick=\"viewReasonforRequest(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\');\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" </A>&nbsp;</TD>\n\n\t\t\t\t</TR>\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"label\"   width=\"15%\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t<td  class=\"data\" id=\"strength\" width=\"20%\">&nbsp;";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" / ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<TR>\t\n\t\t\t\t\t<TD colspan=5>\n\t\t\t\t\t\t<TABLE border=0>\n\t\t\t\t\t\t\t<TR>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<TD CLASS=\"label\" >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</TD>\n\t\t\t\t\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="<input type=\"radio\" id=\"CALC_DOSE_BASED_ON_D\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"D\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" onClick=\"setCalculateBy(this,\'IVAD_AMEND\');\"></TD>\n\t\t\t\t\t\t\t\t<TD CLASS=\"label\" >";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="<input type=\"radio\" id=\"CALC_DOSE_BASED_ON_B\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"B\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" onClick=\"setCalculateBy(this,\'IVAD_AMEND\');\"></TD>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\t\t\t\t<td CLASS=\"label\" nowrap id=\"allow_alternate\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&nbsp;\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' onclick =\"setAllowAlternate(this)\" name=\'allow_alternate_yn\' id=\'allow_alternate_yn\' value=\'N\' ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="  > </td><!-- GHL-CRF-0549-->\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t\t<TR ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" id=\"calc_by_row1\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"DRUG_CODE\" id=\"DRUG_CODE\" VALUE=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t\n\t\t\t\t\t<TD CLASS=\"label\" width=\'10%\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</TD>\n\t\t\t\t\t<TD   width=\'15%\'><SELECT name=\"DOSAGE\" id=\"DOSAGE\" onChange=\"changeScrDetails(this.value);\">\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t<OPTION VALUE=\"Q\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</OPTION>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t<OPTION VALUE=\"S\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</OPTION>\n\t\t\t\t\t\t\t<OPTION VALUE=\"Q\" SELECTED>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t<OPTION VALUE=\"S\" SELECTED>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</OPTION>\n\t\t\t\t\t\t\t<OPTION VALUE=\"Q\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t</SELECT>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD  CLASS=\"label\" ID=\"DOSAGE_LABEL\" colspan=\'4\' width=\'20%\'>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"STRENGTH_VALUE\" id=\"STRENGTH_VALUE\" CLASS=\"number\" VALUE=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" SIZE=\"3\" MAXLENGTH=\"6\" onBlur=\"setCalculatedQty(this); DosageLimitCheck(this);\"><SELECT name=\"STRENGTH_UOM\" id=\"STRENGTH_UOM\" ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" onChange=\"setQtyUOM(this.value);setDrugDosageDetails();\">\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t<OPTION VALUE=\"\">&nbsp;--- ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" ---&nbsp;</OPTION>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\n\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</OPTION>\n\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t<OPTION VALUE=\"\">&nbsp;--- ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t</SELECT><IMG SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></IMG>\n\t\t\t\t<!-- <TD WIDTH=\"15%\" ALIGN=\"right\" CLASS=\"label\">Infusion Rate&nbsp;</TD> -->\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t<A HREF=\"#\" onMouseOver=\"changeCursor(this);\" id=\"drug_remarks\" onClick=\"getFormatId(\'Drug\',\'Y\')\">";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" </A>\n\t\t\t\t\t\t\t        <!-- added for [IN:039576]-start -->\n\t\t\t\t\t\t\t        <img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' name=\'DrugRemarksMandImg\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksMandatory\' id=\'DrugRemarksMandatory\' value=\'N\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered\' id=\'DrugRemarksEntered\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t<!-- added for [IN:039576]-end -->\n\t\t\t\t\t<a href=\"#\" onMouseOver=\"changeCursor(this);\"  id=\"drug_ind_remarks\" onClick=\"drugindication_remarks()\">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</a></TD><!--Added for  ML-BRU-CRF-072[Inc:29938]-->\n\t\t\t\t</TD>\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"INF_VAL\" id=\"INF_VAL\" VALUE=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t</TR>\n\t\t\t<TR ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" id=\"calc_by_row2\">\n\t\t\t\t<TD CLASS=\"label\">";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</TD>\n\t\t\t\t<TD colspan=\"3\" nowrap><input type=\"text\" name=\"CALC_DOSE_VALUE\" id=\"CALC_DOSE_VALUE\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" size=\"5\" maxlength=\"8\" onKeyPress=\"return allowValidNumber(this,event,4,3);\" onBlur=\"calculateDosage_By_BSA_or_Weight(\'IVAD_AMEND\');DosageLimitCheck(this);\" CLASS=\"number\"><!-- Modified for IN:070451 added DosageLimitCheck function -->\n\t\t\t\t<select name=\"calc_dose_value_unit\" id=\"calc_dose_value_unit\"><OPTION VALUE=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</OPTION></select><label class=\"label\"><b> / </b></label><select name=\"CALC_DOSE_BY\" id=\"CALC_DOSE_BY\" onChange=\"calculateDosage_By_BSA_or_Weight(\'IVAD_AMEND\');\"><option value=\"KG\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</option><option value=\"M2\" ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</option></select><label class=\"label\"><b> = </b></label><INPUT TYPE=\"text\" name=\"strength_value_wt_bsa\" id=\"strength_value_wt_bsa\"  VALUE=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" SIZE=\"10\" MAXLENGTH=\"12\" onKeyPress=\"return allowValidNumber(this,event,8,3);\" class=\"number\" onBlur=\"assignStrengthForBSA();setCalculatedQty(this); DosageLimitCheck(this);\">&nbsp;<label class=\"label\"> <b>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</b></label>\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></img>\n\t\t\t\t</TD>\n\t\t\t</TR>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t<TR >\n\t\t\t\t\t<TD colspan=\'2\'>&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td CLASS=\"label\" ID=\"monograph\" colspan=\'2\'>\n\t\t\t\t\t\t<label id=\'rec_legend\' onclick=\'defaultRecomDose()\'>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t<font class=\'HYPERLINK\' onmouseover=\'changeCursor(this);\'>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</font>\n\t\t\t\t\t\t</label>\n\t\t\t\t\t\t<label id=\"rec_value\" style=\"font-size:11;font-weight:bold;color:red\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</label>\n\t\t\t\t\t\t&nbsp;<label id=\"rec_uom\" style=\"font-size:11;font-weight:bold;color:red\">";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</label>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t<!-- Duplicate medication warning ends-->\n\n\t\t\t<TR>\n\t\t\t\t<TD WIDTH=\"25%\"  CLASS=\"label\" ID=\"auth_yn_img\">\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t<IMG SRC=\"../../eOR/images/Authorized.gif\" BORDER=\"0\"></IMG>&nbsp;<B>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</B>\t\t\n\t\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t<IMG SRC=\"../../eOR/images/Authorization.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization(\'authorize\')\">";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" </A>\t\t\n\t\t\t\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t\t<IMG SRC=\"../../eOR/images/Authorized.gif\" BORDER=\"0\"></IMG>&nbsp;<B>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</B>\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\t<IMG SRC=\"../../eOR/images/Authorization.gif\" BORDER=\"0\"><font style=\'color:red;\'></IMG>&nbsp;";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</font>\n\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t</TD>\n\t\t\t\t<TD WIDTH=\"25%\" CLASS=\"label\" ID=\"spappl_yn_img\">\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\n\t\t\t\t\t\t\t<IMG SRC=\"../../eOR/images/SpecialApproval.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization(\'approve\')\">";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</A>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t<IMG SRC=\"../../eOR/images/SpecialApproval_click.gif\" BORDER=\"0\"></IMG>&nbsp;<B>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t<IMG SRC=\"../../eOR/images/SpecialApproval.gif\" BORDER=\"0\"></IMG>&nbsp;<font style=\'color:red;\'> ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</font>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t</TD>\n\t\t\t\t<TD WIDTH=\"20%\" CLASS=\"label\" ID=\"cosign_yn_img\">\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\n\t\t\t\t\t\t\t<IMG SRC=\"../../eOR/images/Cosign_click.gif\" BORDER=\"0\">&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization(\'cosign\')\">";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</A>\n\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\n\t\t\t\t\t\t\t<IMG SRC=\"../../eOR/images/Cosign.gif\" BORDER=\"0\">&nbsp;<B>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t<IMG SRC=\"../../eOR/images/Cosign_click.gif\" BORDER=\"0\"><font style=\'color:red;\'>&nbsp;";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t</TD>\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t<TD WIDTH=\"15%\" CLASS=\"eORConsent\" ID=\"consent\" TITLE=\"Consent Required\"><FONT COLOR=\"#0066CC\" SIZE=\"1\"><B> ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</B></FONT></TD>\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t<TD WIDTH=\"15%\" CLASS=\"label\" ID=\"consent\">&nbsp;</TD>\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t</TABLE>\n\n\t\t\t\n\t\t\t<INPUT TYPE=\"hidden\" name=\"GENERIC_ID\" id=\"GENERIC_ID\" VALUE=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"GENERIC_NAME\" id=\"GENERIC_NAME\" VALUE=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"DAILY_DOSE\" id=\"DAILY_DOSE\" VALUE=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"UNIT_DOSE\" id=\"UNIT_DOSE\" VALUE=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"MONO_GRAPH\" id=\"MONO_GRAPH\" VALUE=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"dosage_std\" id=\"dosage_std\" VALUE=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"dosage_unit\" id=\"dosage_unit\" VALUE=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"recomm_yn\" id=\"recomm_yn\" VALUE=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t<input type=\"hidden\" name=\"recomm_dosage_by\" id=\"recomm_dosage_by\"\t    value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"LIMIT_IND\" id=\"LIMIT_IND\" VALUE=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"MIN_DAILY_DOSE\" id=\"MIN_DAILY_DOSE\" VALUE=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"MIN_UNIT_DOSE\" id=\"MIN_UNIT_DOSE\" VALUE=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t\t<!-- Added for IN:070451 start -->\n\t\t\t\t<input type=\"hidden\" name=\"max_daily_ceeling_dose\" id=\"max_daily_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_daily_ceeling_dose\" id=\"min_daily_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"max_unit_ceeling_dose\" id=\"max_unit_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_unit_ceeling_dose\" id=\"min_unit_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"calc_by_ind\" id=\"calc_by_ind\"\t    value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t\t<!-- Added for IN:070451 end  -->\n\t        \t<!-- Added for IN:072715 Start -->\t\t\n\t               <input type=\"hidden\"  name=\"allergy_remarks_code\" id=\"allergy_remarks_code\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n                       <input type=\"hidden\"  name=\"dose_remarks_code\" id=\"dose_remarks_code\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n                       <input type=\"hidden\"  name=\"currentrx_remarks_code\" id=\"currentrx_remarks_code\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n                       <!-- Added for IN:072715 end -->\n\t\t\t<INPUT TYPE=\"hidden\" name=\"ALLERGY_YN\" id=\"ALLERGY_YN\" VALUE=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"CURRENT_RX\" id=\"CURRENT_RX\" VALUE=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"SRL_NO\" id=\"SRL_NO\" VALUE=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"FORM_CODE\" id=\"FORM_CODE\" VALUE=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"PRES_QTY_VALUE\" id=\"PRES_QTY_VALUE\" VALUE=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"PRES_BASE_UOM\" id=\"PRES_BASE_UOM\" VALUE=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"FREQ_CODE\" id=\"FREQ_CODE\" VALUE=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"DURN_VALUE\" id=\"DURN_VALUE\" VALUE=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"DURN_TYPE\" id=\"DURN_TYPE\" VALUE=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"OR_DURN_DESC\" id=\"OR_DURN_DESC\" VALUE=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"APPROVAL_YN_VAL\" id=\"APPROVAL_YN_VAL\" VALUE=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" >\n\t\t\t<INPUT TYPE=\"hidden\" name=\"AUTH_YN_VAL\" id=\"AUTH_YN_VAL\" VALUE=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"COSIGN_YN_VAL\" id=\"COSIGN_YN_VAL\" VALUE=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"ORDER_TYPE_CODE\" id=\"ORDER_TYPE_CODE\" VALUE=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"ROUTE_CODE\" id=\"ROUTE_CODE\" VALUE=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"END_DATE\" id=\"END_DATE\" VALUE=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"AUTH_YN\" id=\"AUTH_YN\" VALUE=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"APPROVAL_YN\" id=\"APPROVAL_YN\" VALUE=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"COSIGN_YN\" id=\"COSIGN_YN\" VALUE=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"CONSENT_REQD_YN\" id=\"CONSENT_REQD_YN\" VALUE=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"ALLERGY_DESC\" id=\"ALLERGY_DESC\" VALUE=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"EXCEED_DOSE_DESC\" id=\"EXCEED_DOSE_DESC\" VALUE=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"DUP_DRUG_DESC\" id=\"DUP_DRUG_DESC\" VALUE=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"UOM_CODE\" id=\"UOM_CODE\" VALUE=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"STRENGTH_UOM_DESC\" id=\"STRENGTH_UOM_DESC\" VALUE=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"STR_VAL\" id=\"STR_VAL\" VALUE=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"BMS_QTY\" id=\"BMS_QTY\" VALUE=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"DFLT_QTY_UOM\" id=\"DFLT_QTY_UOM\" VALUE=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"TAB_QTY_VALUE\" id=\"TAB_QTY_VALUE\" VALUE=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"QTY_DESC_CODE\" id=\"QTY_DESC_CODE\" VALUE=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"STR_DESC\" id=\"STR_DESC\" VALUE=\"\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"license\" id=\"license\" VALUE=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"order_id\" id=\"order_id\" VALUE=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"order_line_num\" id=\"order_line_num\" VALUE=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"pres_remarks\" id=\"pres_remarks\" VALUE=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t\t\t<input type=\"hidden\" name=\"ORDERSET_STRENGTH\" id=\"ORDERSET_STRENGTH\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" name=\"validate_overide_on_confirm_yn\"><!-- Added for IN:069887  -->\n\t\t\t<input type=\"hidden\" name=\"strength_per_value_pres_uom\" id=\"strength_per_value_pres_uom\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t\t\t<input type=\"hidden\" name=\"strength_per_pres_uom\" id=\"strength_per_pres_uom\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n\t\t\t<input type=\"hidden\" name=\"interval_value\" id=\"interval_value\" value=\"1\">\n\t\t\t<input type=\"hidden\" name=\"perform_external_database_checks_yn\" id=\"perform_external_database_checks_yn\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\t\t\t<input type=\"hidden\" name=\"external_product_id\" id=\"external_product_id\"     value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n\t\t\t<input type=\"hidden\" name=\"fract_dose_round_up_yn\" id=\"fract_dose_round_up_yn\"  value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason\" id=\"external_dosage_override_reason\" value=";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =">\n\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason\" id=\"external_duplicate_override_reason\" value=";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =">\n\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason\" id=\"external_interaction_override_reason\" value=";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 =">\n\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason\" id=\"external_contra_override_reason\" value=";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 =">\n\t\t\t<input type=\"hidden\" name=\"external_Alergy_override_reason\" id=\"external_Alergy_override_reason\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_db_dose_check_flag\" id=\"drug_db_dose_check_flag\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\" value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t\t\t<input type=\"hidden\" name=\"DrugIndicationRemarks\" id=\"DrugIndicationRemarks\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\"><!--Added for  ML-BRU-CRF-072[Inc:29938]-->\n\t\t\t<input type=\"hidden\" name=\"abuse_restric_trn\" id=\"abuse_restric_trn\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\"> <!-- added for aakh-crf-0140 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"abuse_exists\" id=\"abuse_exists\"  value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\"><!-- added for aakh-crf-0140 -->\n<input type=\"hidden\" name=\"abuse_action\" id=\"abuse_action\"  value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\t<!-- added for aakh-crf-0140 -->\n                       <input type=\"hidden\"  name=\"abuse_override_remarks\" id=\"abuse_override_remarks\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n                       <input type=\"hidden\"  name=\"ABUSE_OVERRIDE\" id=\"ABUSE_OVERRIDE\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n                       \n\t\t\t\n\t\t\t<SCRIPT>\n\t\t\t\tloadButtonsFrame(\'amend\',\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\',\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\');\n\t\t\t\tdocument.formIVPrescriptionDrugDetails.STRENGTH_VALUE.focus(); // this line was added so that dosage details wil be passed correctly when clicking on fdb viewmedicationalert()\n\t\t\t//changeScrDetails(document.formIVPrescriptionDrugDetails.DOSAGE.value); // commented for IN23745 --14/09/2010-- priya\n\t\t\t//if(document.formIVPrescriptionDrugDetails.DOSAGE.value!=\"\") {\n\t\t\t\t//changeScrDetails(document.formIVPrescriptionDrugDetails.DOSAGE.value);\n\t\t\t//}\n\t\t\tgetFormatId(\'Drug\',\'N\');//added for [IN:039576]\n\t\t\t</SCRIPT>\n\n";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n<!-- added for ml-mmoh-crf-0863 start -->\n\t\t\t\t    <INPUT type=\"hidden\" name=\"take_home_medication\" id=\"take_home_medication\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n\t\t\t\t\t<INPUT type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n\t\t\t\t\t<INPUT type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n\t\t\t\t\t<INPUT type=\"hidden\" name=\"ORD_AUTHORIZED_YN\" id=\"ORD_AUTHORIZED_YN\" value=\"\">\n<!-- added for ml-mmoh-crf-0863 end -->\n</FORM>\n";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n</BODY>\n<script>\n";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\n\t//duplicateWarning();\n";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n</script>\n</HTML>\n";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );
	
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
25/06/2020      IN:072715                  Haribabu            25/06/2020     Manickavasagam J     MMS-DM-CRF-0165
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
--------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block9Bytes, _wl_block9);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

Connection con			= null;    //added for GHL-CRF-0549
	try{
		con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
   	  	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
   	 boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
   	//Added for IN:069887 start
	boolean validate_overide_on_confirm =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","VALIDATE_OVERIDE_ON_CONFIRM");//added for MO-CRF-20152
	boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
	
	String validate_overide_on_confirm_yn="N";
	if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}			
//Added for IN:069887 end

	String params			= request.getQueryString() ;
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String classValue		= request.getParameter("classValue");
	//added for ml-mmoh-crf-0863 start
	String iv_prep_yn		= request.getParameter("iv_prep_yn");
	String take_home_medication	= request.getParameter("take_home_medication");
	String priority		= request.getParameter("priority");
	String order_status="";
	//added for ml-mmoh-crf-0863 end
	
	if(classValue == null) classValue="";

	String mode				= request.getParameter("mode");
		if(mode == null) mode = "";

	String amendDisa		= "";
	   if(mode.equals("amend")) amendDisa = "disabled";

	String start_date		= request.getParameter("start_date");
	    if(start_date == null) start_date="";

	String serialNum		= request.getParameter("serialNum") == null ? "":request.getParameter("serialNum");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
	String facility_id		= (String)session.getValue("facility_id");

	String param_bean_id				= "@DrugInterfaceControlBean";
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name,request);

	bean.setPatientClass(patient_class);
	bean.setEncId(encounter_id);
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name				= "eOR.OrderEntryBean";
	OrderEntryBean ORbean			= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);

	String disp_bean_id			= "DispMedicationBean";
	String disp_bean_name		= "ePH.DispMedicationBean";
	DispMedicationBean disp_bean	= (DispMedicationBean)getBeanObject(disp_bean_id, disp_bean_name,request);
//added for ML-MMOH-CRF-0863 STSRT

	     String pre_bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
		String pre_bean_name				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pre_bean			= (PrescriptionBean_1)getBeanObject( pre_bean_id, pre_bean_name, request );
		String called_amend_from=pre_bean.getCalledFromAmend();
		
		//added for ML-MMOH-CRF-0863  END

	String resp_id					= (String)ORbean.getResponsibilityId();
	String pract_id					= (String)ORbean.getPractitionerId();
	String pract_name				= (String)ORbean.getPractitionerName();
	String locn_type				= (String)ORbean.getLocationType();
	String locn_code				= (String)ORbean.getLocationCode();
	String order_id					= (String)ORbean.getOrderId();	
	bean.setOrderStatus("");//adde for ml-mmoh-crf-0863
	order_status=bean.getOrderStatusUsingOrderId(order_id);//adde for ml-mmoh-crf-0863
	bean.setOrderStatus(order_status);//added for ml-mmoh-crf-0863
	String license					=	bean.getLicense();
	//added for ml-mmoh-crf-0863 start
	bean.setDisp_locn_code("");//added for ml-mmoh-crf-0863
	 ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(locn_type,locn_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added empty parameter for Bru-HIMS-CRF-347 [IN:037862] -- Begin ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
	String disp_locn_code	= "";
	if(ord_disp_location != null & ord_disp_location.size()>0){ 
		disp_locn_code		=	(String)ord_disp_location.get(0) ==null?"":(String)ord_disp_location.get(0);	
		bean.setDisp_locn_code(disp_locn_code);
	}
     String auth_amend_pres_yn="";
	auth_amend_pres_yn = bean.getAuthAmendPres(disp_locn_code);
	//added for ml-mmoh-crf-0863 end
	 String make_disabled			=	"";
	String readOnly					=	"";
	String current_rx				=	"";
//	String	allow_duplicate						=	bean.checkDuplicateYN();
	String perform_external_database_checks_yn	=	"";	
	String external_dosage_override_reason		=   "";	
	String external_duplicate_override_reason	=   "";
	String external_interaction_override_reason	=   "";
	String external_contra_override_reason		=   ""; 
	String external_alergy_override_reason		=   ""; 
	String fract_dose_round_up_yn				=   "";
	String drug_db_dosage_check_flag			=   "Y";
	String DrugRemarksEntered			=	""; //added for [IN:039576]
	bean.setExcludeADRAllergyAlert(CommonBean.checkForNull(request.getParameter("excludeADRAllergyAlert_yn")));		

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( start_date ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( patient_class ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( bean.getDrugCodes() ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( resp_id ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( pract_id ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( pract_name ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( locn_type ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( locn_code ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( mode ));
            _bw.write(_wl_block25Bytes, _wl_block25);

			if (serialNum.equals("")) {

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(amendDisa));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(amendDisa));
            _bw.write(_wl_block29Bytes, _wl_block29);

						if (iv_option.equals("Y")) {

            _bw.write(_wl_block30Bytes, _wl_block30);

						}

            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

			}
			else {

				String disabled	= "";
				int srlNo		= 0;
				srlNo			= Integer.parseInt(serialNum);
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

				ArrayList exstngIVOrders    = new ArrayList();	
				HashMap exstngDrgDtls 	    = new HashMap();				
				exstngIVOrders              = bean.getAllExistingIVOrders();
				ArrayList drugList			= bean.getDrugDetails();
				HashMap drugDetails			= (HashMap)drugList.get(srlNo-1);
				String generic_id			= (String)drugDetails.get("GENERIC_ID");
				String drug_desc			= (String)drugDetails.get("DRUG_DESC");
				String drug_code			= (String)drugDetails.get("DRUG_CODE");
				String min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE");
				String min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE");
				String dosage_unit			= (String)drugDetails.get("DOSAGE_UNIT");
				String generic_name			= (String)drugDetails.get("GENERIC_NAME");
				String daily_dose			= (String)drugDetails.get("DAILY_DOSE");
				//Added for IN:070451 start
				String      max_daily_ceeling_dose	    =   (String)drugDetails.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
				String		min_daily_ceeling_dose	    =   (String)drugDetails.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
				String		max_unit_ceeling_dose	    =   (String)drugDetails.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
				String		min_unit_ceeling_dose	    =   (String)drugDetails.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
				String		calc_by_ind	    =   (String)drugDetails.get("CALC_BY_IND")==null?"":(String)drugDetails.get("CALC_BY_IND");
				//Added for IN:070451 end
				//Added for IN:072715 start
			        String allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
				String dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
				String currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
				//Added for IN:072715 end
				String unit_dose			= (String)drugDetails.get("UNIT_DOSE");
				String mono_graph			= (String)drugDetails.get("MONO_GRAPH");
				String dosage_std			= (String)drugDetails.get("DOSAGE_STD");
				String limit_ind			= (String)drugDetails.get("LIMIT_IND");
				String recomm_yn			= (String)drugDetails.get("RECOMM_YN")==null?"":(String)drugDetails.get("RECOMM_YN");
				String recomm_dosage_by		= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
				String allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
				current_rx					=  bean.checkForNull((String)drugDetails.get("CURRENT_RX"),"N");
				String srl_no				= (String)drugDetails.get("SRL_NO");
				String strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
				String act_strength_value=(String)drugDetails.get("ACT_STRENGTH_VALUE");//ADDED FOR NMC-JD-CRF-0026
				String strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
				String strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
				String form_code			= (String)drugDetails.get("FORM_CODE");
				String pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
				String pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
				String freq_code			= (String)drugDetails.get("FREQ_CODE");
				String durn_value			= (String)drugDetails.get("DURN_VALUE");
				String durn_type			= (String)drugDetails.get("DURN_TYPE");
				String or_durn_desc			= (String)drugDetails.get("OR_DURN_DESC");
				String auth_yn_val			= (String)drugDetails.get("AUTH_YN_VAL");
				String approval_yn_val		= (String)drugDetails.get("APPROVAL_YN_VAL");
				String cosign_yn_val		= (String)drugDetails.get("COSIGN_YN_VAL");
				String auth_yn				= (String)drugDetails.get("AUTH_YN");
				String approval_yn			= (String)drugDetails.get("APPROVAL_YN");
				String cosign_yn			= (String)drugDetails.get("COSIGN_YN");
				String consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
				String order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
				String route_code			= (String)drugDetails.get("ROUTE_CODE");
				String end_date				= (String)drugDetails.get("END_DATE");
				String dup_drug_desc		= (String)drugDetails.get("CURRENTRX_REMARKS");
				String allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS");
				String exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS")==null?"":(String)drugDetails.get("DOSE_REMARKS");
				String dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
				String bms_qty				= (String)drugDetails.get("BMS_QTY");
				String dflt_qty_uom			= (String)drugDetails.get("DFLT_QTY_UOM");
				String tab_qty_value		= (String)drugDetails.get("TAB_QTY_VALUE");
				String qty_desc_code		= (String)drugDetails.get("QTY_DESC_CODE");
				String order_uom			= (String)drugDetails.get("ORDER_UOM");
				String amend_yn				= (String)drugDetails.get("AMEND_YN");
				String qty_value			= (String)drugDetails.get("QTY_VALUE");
				String qty_unit			    = (String)drugDetails.get("QTY_UNIT");
				String calc_dose_based_on	= (String)drugDetails.get("CALC_DOSE_BASED_ON");
				String calc_dose_by		    = "";
				String calc_dose_value	    = "";
				String displaydose			= "";
				String displayBSA			= "style='display:none'";
				String kg_selected			= "Selected";
				String m2_selected			= "";
				String select_calc_dose_Dosage="checked";
				String select_calc_dose_WT_BSA="";
				String disable_calc_dose	="";
				String allow_alternate_yn ="N"; //GHL-CRF-0549
				String allow_alternate_disabled	= "";//GHL-CRF-0549
				String allow_alternate_checked = "";//GHL-CRF-0549
				String allow_alternate		   = "N";//GHL-CRF-0549
				String abuse_exists="N";
				String abuse_action="U";
				String abuse_restric_trn="N";
				String abuse_override="";
				String abuse_override_remarks="";
				if(drug_abuse_appl){
					abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"N":(String)drugDetails.get("ABUSE_EXISTS"); //Added for AAKH-CRF-0140
					abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"U":(String)drugDetails.get("ABUSE_ACTION"); //Added for AAKH-CRF-0140
					abuse_restric_trn=(String)drugDetails.get("ABUSE_RESTRIC_TRN")==null?"U":(String)drugDetails.get("ABUSE_RESTRIC_TRN"); //Added for AAKH-CRF-0140
					abuse_override_remarks=(String)drugDetails.get("abuse_override_remarks")==null?"U":(String)drugDetails.get("abuse_override_remarks"); //Added for AAKH-CRF-0140
					abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"":(String)drugDetails.get("ABUSE_OVERRIDE"); //Added for AAKH-CRF-0140

					System.out.println("333 abuse_exists"+abuse_exists);
					System.out.println(abuse_override_remarks+"334 abuse_action"+abuse_action);
					}
					else{
						abuse_exists="N";
						abuse_action="U";
						abuse_restric_trn="N";
						abuse_override="";
						abuse_override_remarks="";
						
					}
				if(calc_dose_based_on!=null && calc_dose_based_on.equals("B")){
					select_calc_dose_Dosage="";
					select_calc_dose_WT_BSA="checked";
					calc_dose_by			= (String)drugDetails.get("CALC_DOSE_BY")==null?"KG":(String)drugDetails.get("CALC_DOSE_BY");
					calc_dose_value			= (String)drugDetails.get("CALC_DOSE_VALUE")==null?"":(String)drugDetails.get("CALC_DOSE_VALUE");
					displaydose="style='display:none'";
					displayBSA="";
					if(calc_dose_by.equals("M2")){
						kg_selected="";
						m2_selected="Selected";
					}
				}
				
				String strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
				String strength_per_pres_uom	   = (String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
				String ext_prod_id			= (String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
				drug_db_dosage_check_flag				= (String) drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	
				perform_external_database_checks_yn		= (String) drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");		
				external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
				external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
				external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
				external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
				external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
				String DrugIndicationRemarks				= (String)drugDetails.get("DRUG_INDICATION")==null?"":(String) drugDetails.get("DRUG_INDICATION");//Added for  ML-BRU-CRF-072[Inc:29938]  
				if(!DrugIndicationRemarks.equals(""))
					DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); ;

				String pres_remarks			=  "";
				HashMap practRights			= (HashMap)bean.getAuthorizationReqd(resp_id, pract_id);
				String pres_base			=	bean.getPresBase(drug_code);
				String base_desc			=	"";
				String infusion_uom			=	"";
				String dr_flow_unit			=	"";				
				String dflt_code			= "";

				if(drugDetails.containsKey("INFUSION_UOM"))
					infusion_uom			= (String)drugDetails.get("INFUSION_UOM");

				if(drugDetails.containsKey("dr_flow_unit"))
					dr_flow_unit			= (String)drugDetails.get("dr_flow_unit");

				StringTokenizer st	=	new StringTokenizer(pres_base,"::");
				if(st.hasMoreTokens()) {
					base_desc	=	st.nextToken();
				}

				if (!classValue.equals("AMENDEDDRUGS")) {

					String orgLineNum	= Integer.toString(srlNo+1);
					HashMap qtyValues	=	bean.getQtyValue(patient_id,order_id,orgLineNum);
					dosage_type			= (String)qtyValues.get("dosage_type")==null?"":(String)qtyValues.get("dosage_type");
					qty_value			= (String)qtyValues.get("qty_value")==null?"":(String)qtyValues.get("qty_value");
					dflt_code			= (String)qtyValues.get("strengthUom")==null?"":(String)qtyValues.get("strengthUom");
				}
				String order_line_num	= Integer.toString(srlNo+1);
				HashMap drugReasons     = new HashMap();
				drugReasons				= bean.getDrugReasons(order_id,order_line_num,"");
				if(drugReasons != null){
					if(allergy_desc.equals("")){
						allergy_desc=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");
						drugDetails.put("ALLERGY_REMARKS",(String)drugReasons.get("ALLERGY_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ALLERGY_OVERRIDE_REASON"));//Added for IN:072715 
						if(allergy_desc == null) {
							allergy_desc=""; 
//							allergy_yn = "N";
						}
					}
					if(exceed_dose_desc.equals("")){
						exceed_dose_desc=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
						drugDetails.put("DOSE_REMARKS",(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON"));//Added for IN:072715 
						if(exceed_dose_desc == null){ 
							exceed_dose_desc=""; 
							limit_ind="Y";
						}
					}
					if(dup_drug_desc.equals("")){
						dup_drug_desc=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");
						drugDetails.put("CURRENTRX_REMARKS",(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON"));//Added for IN:072715 
						if(dup_drug_desc == null) {
							dup_drug_desc=""; 
			//				current_rx="N";
						}
					}
					//Added for IN:072715 start
					if(allergy_remarks_code.equals("")){
						allergy_remarks_code=(String)drugReasons.get("ALLERGY_REMARKS_CODE");
						drugDetails.put("ALLERGY_REMARKS_CODE",(String)drugReasons.get("ALLERGY_REMARKS_CODE")==null?"":(String)drugReasons.get("ALLERGY_REMARKS_CODE"));//Added for IN:072715 
						if(allergy_remarks_code == null){ 
							allergy_remarks_code=""; 
						}
					}
					if(dose_remarks_code.equals("")){
						dose_remarks_code=(String)drugReasons.get("DOSE_REMARKS_CODE");
						drugDetails.put("DOSE_REMARKS_CODE",(String)drugReasons.get("DOSE_REMARKS_CODE")==null?"":(String)drugReasons.get("DOSE_REMARKS_CODE"));//Added for IN:072715 
						if(dose_remarks_code == null){ 
							dose_remarks_code=""; 
						}
					}
					if(currentrx_remarks_code.equals("")){
						currentrx_remarks_code=(String)drugReasons.get("CURRENTRX_REMARKS_CODE");
						drugDetails.put("CURRENTRX_REMARKS_CODE",(String)drugReasons.get("CURRENTRX_REMARKS_CODE")==null?"":(String)drugReasons.get("CURRENTRX_REMARKS_CODE"));//Added for IN:072715 
						if(currentrx_remarks_code == null){ 
							currentrx_remarks_code=""; 
						}
					}
					if(abuse_override_remarks.equals("") && abuse_exists.equals("Y") && abuse_action.equals("B")){
						abuse_override_remarks=(String)drugReasons.get("ABUSE_DRUG_OVERRIDE_REASON");
						drugDetails.put("abuse_override_remarks",(String)drugReasons.get("ABUSE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ABUSE_DRUG_OVERRIDE_REASON"));//Added for IN:072715 
						if(abuse_override_remarks == null){ 
							abuse_override_remarks=""; 
						}
					}
					//Added for IN:072715 end
				}
				ArrayList drug_remarks	=	bean.getPrescribedRemarks(order_id,order_line_num);
				if(drug_remarks.size()!=0) { 
					for(int x=0; x<drug_remarks.size(); x++) {	
						if(x==(drug_remarks.size()-1)) {	
							pres_remarks	+=	(String)drug_remarks.get(x);
						} 
						else {
							pres_remarks	+=	(String)drug_remarks.get(x)+",";
						}
					} 
				} 
				
		// TDM
				String tdmOrder_id = "";
				String display_tdm = "display:none";
				//tdmOrder_id			= bean.getOrderIdForTDMDtls(patient_id,drug_code);
				if(drugDetails.get("TDM_ORDER_ID")== null){
					tdmOrder_id				= bean.getOrderIdForTDMDtls(patient_id,drug_code);
					drugDetails.put("TDM_ORDER_ID",tdmOrder_id);
				}
				else 
					tdmOrder_id = (String)drugDetails.get("TDM_ORDER_ID");

				if(tdmOrder_id==null||tdmOrder_id.equals("")){
					display_tdm="display:none";
				}
				else{
					display_tdm="display:inline";
				} 
				if(exstngIVOrders != null && exstngIVOrders.size()>0){
					for(int i=0;i<exstngIVOrders.size();i++){
						exstngDrgDtls =  (HashMap)exstngIVOrders.get(i);
						if(drug_code.equals((String)exstngDrgDtls.get("ORDER_CATALOG_CODE"))){
							auth_yn_val			= (String)exstngDrgDtls.get("ORD_AUTH_REQD_YN")==null?"N":(String)exstngDrgDtls.get("ORD_AUTH_REQD_YN");    
							approval_yn_val		= (String)exstngDrgDtls.get("ORD_APPR_REQD_YN")==null?"N":(String)exstngDrgDtls.get("ORD_APPR_REQD_YN");
							cosign_yn_val		= (String)exstngDrgDtls.get("ORD_COSIGN_REQD_YN")==null?"N":(String)exstngDrgDtls.get("ORD_COSIGN_REQD_YN");  
							order_uom			= (String)exstngDrgDtls.get("ORDER_UOM")==null?"N":(String)exstngDrgDtls.get("ORDER_UOM");  
							allow_alternate = (String)exstngDrgDtls.get("ALLOW_ALTERNATE_YN")==null?"N":(String)exstngDrgDtls.get("ALLOW_ALTERNATE_YN");//GHL-CRF-0549
							if(calc_dose_based_on==null){
								calc_dose_based_on   = (String)exstngDrgDtls.get("CALC_DOSE_BASED_ON")==null?"D":(String)exstngDrgDtls.get("CALC_DOSE_BASED_ON");
								if(calc_dose_based_on!=null && calc_dose_based_on.equals("B")){
									select_calc_dose_Dosage="";
									select_calc_dose_WT_BSA="checked";
									calc_dose_by			= (String)exstngDrgDtls.get("CALC_DOSE_BY")==null?"KG":(String)exstngDrgDtls.get("CALC_DOSE_BY");
									calc_dose_value			= (String)exstngDrgDtls.get("CALC_DOSE_VALUE")==null?"":(String)exstngDrgDtls.get("CALC_DOSE_VALUE");
									displaydose="style='display:none'";
									displayBSA="";
									if(calc_dose_by.equals("M2")){
										kg_selected="";
										m2_selected="Selected";
									}
									drugDetails.put("CALC_DOSE_BASED_ON",calc_dose_based_on);
									drugDetails.put("CALC_DOSE_BY",calc_dose_by);
									drugDetails.put("CALC_DOSE_VALUE",calc_dose_value);
								}
							}
							if(amend_yn.equals("N")){
								qty_unit = (String)exstngDrgDtls.get("QTY_UNIT")==null?"":(String)exstngDrgDtls.get("QTY_UNIT");  
								drugDetails.put("QTY_UNIT",qty_unit);
								drugDetails.put("Dosage_Uom",qty_unit);
								drugDetails.put("QTY_DESC_CODE",qty_unit);
							}
						}
					}
				}

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( drug_desc ));
            _bw.write(_wl_block39Bytes, _wl_block39);

					if (iv_option.equals("Y")) {

            _bw.write(_wl_block40Bytes, _wl_block40);

					}

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(display_tdm));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tdmOrder_id));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
 if (strength_value.equals("0")) {
				
						select_calc_dose_Dosage ="checked";
						select_calc_dose_WT_BSA ="";
						disable_calc_dose		="disabled";						

				}
				System.err.println("drugDetails=====444==>"+drugDetails);
				 //GHL-CRF-0549

					allow_alternate_disabled = "disabled";
					if(allow_alternate.equals("Y")){
					 allow_alternate_checked = "checked";
					}
					//added for NMC-JD-CRF-0026 START
					if(strength_display_app){
				
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
	if(act_strength_value != null && act_strength_value!="" && !act_strength_value.equals("0")){ 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(act_strength_value));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),pres_base_uom)));
            _bw.write(_wl_block46Bytes, _wl_block46);
} 
            _bw.write(_wl_block50Bytes, _wl_block50);
} //added for NMC-JD-CRF-0026 END
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(select_calc_dose_Dosage));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disable_calc_dose));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(select_calc_dose_WT_BSA));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disable_calc_dose));
            _bw.write(_wl_block57Bytes, _wl_block57);
				
						
								if(item_type_site_app){ //GHL-CRF-549
			
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(allow_alternate_disabled));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(allow_alternate_checked));
            _bw.write(_wl_block60Bytes, _wl_block60);

								} 
								//GHL-CFR-0549 - end
			
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(displaydose));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf( drug_code ));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

					if (strength_value.equals("0")) {

            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

					}
					else {
						if(dosage_type.equals("Q")) {

            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

						}
						else {

            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

						}
					}

            _bw.write(_wl_block71Bytes, _wl_block71);

					String str_value = "";
					if (strength_value.equals("0")) {
						disabled	 = "";
						str_value	 = pres_qty_value;

            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

					}
					else {
						if(dosage_type.equals("S")) {
							str_value	= strength_value;
							disabled	= "DISABLED";

            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

						}	
						else {
							str_value	= pres_qty_value;
							disabled	= "";

            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

						}
					}
					if(qty_value!=null && !qty_value.equals("")) {
						str_value	  =	qty_value;
						if(Float.parseFloat(str_value) < 1.0){
							str_value = Float.parseFloat(str_value)+"";
						}			
					}


            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( str_value ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( disabled ));
            _bw.write(_wl_block76Bytes, _wl_block76);

					if (!strength_value.equals("0")) {
						if(dosage_type.equals("S")) {

            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( strength_uom ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( strength_uom_desc ));
            _bw.write(_wl_block66Bytes, _wl_block66);

					}
					else {

            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

		//				Hashtable QtyDescDetails	= (Hashtable)bean.loadQtyDetails(form_code);
						Hashtable QtyDescDetails	= (Hashtable)bean.listQtyDetails(drug_code);						
						Enumeration keys_des		= QtyDescDetails.keys();
						String uom_code				= "";
						String uom_desc				= "";
						String def_uom				= "";

						while(keys_des.hasMoreElements()) {
							uom_code	= (String)keys_des.nextElement();
							uom_desc	= (String)QtyDescDetails.get(uom_code);

							if(!uom_code.equals("dflt_code")) {
						/*	 if (!classValue.equals("AMENDEDDRUGS")) {
								if(uom_code.equals(dflt_code))
									def_uom = "SELECTED";
								else
									def_uom = "";
							 }else{*/
//							 	if(uom_code.equals(qty_desc_code))

							 	if(uom_code.equals(qty_unit)){

									def_uom = "SELECTED";
								}
								else{
									def_uom = "";
								}
						//	 }


            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( uom_code ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf( def_uom ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( uom_desc ));
            _bw.write(_wl_block84Bytes, _wl_block84);

							}
						}
					}
				}
				else {

            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

		//			Hashtable QtyDescDetails	= (Hashtable)bean.loadQtyDetails(form_code);
					Hashtable QtyDescDetails	= (Hashtable)bean.listQtyDetails(drug_code);			
					Enumeration keys_des		= QtyDescDetails.keys();
					String uom_code				= "";
					String uom_desc				= "";
					String def_uom				= "";
		//			String dflt_code			= "";

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

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( uom_code ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf( def_uom ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( uom_desc ));
            _bw.write(_wl_block66Bytes, _wl_block66);

						}
					}
				}

            _bw.write(_wl_block87Bytes, _wl_block87);

				String inf_uom = "";
				int srlNum		= Integer.parseInt(srl_no)-1;
				String inf_val	= bean.getInfRate(Integer.toString(srlNum), 3);
				
				if (strength_value.equals("0")) {
					disabled = "DISABLED";
				}
				else {
					if(dosage_type.equals("S")) {
						inf_uom = strength_uom_desc;
						disabled = "";

						if (!inf_val.equals("") && !(bean.getInfRate(Integer.toString(srlNum), 1).equals(Integer.toString(srlNum)))) {
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

				if(inf_uom.equals("")) {
					make_disabled	=	"disabled";
					readOnly		=	"READONLY";
				}
				else {
					make_disabled	=	"";
					readOnly		=	"";
				}

            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf( bean.getInfRate(Integer.toString(srlNum), 2) ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(displayBSA));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(calc_dose_value));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( strength_uom_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(kg_selected));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(m2_selected));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block100Bytes, _wl_block100);

			if(recomm_yn!=null && recomm_yn.equals("Y")) {

            _bw.write(_wl_block101Bytes, _wl_block101);

						if(dosage_type.equals(recomm_dosage_by)){

            _bw.write(_wl_block102Bytes, _wl_block102);

						}

            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block105Bytes, _wl_block105);

			}

            _bw.write(_wl_block106Bytes, _wl_block106);

			if (drugDetails.get("ORD_AUTH_REQD_YN") != null){
				if (drugDetails.get("ORD_AUTH_REQD_YN").equals("Y")) {
					/*String authYN = (String)practRights.get("AUTH_YN");
					if(authYN == null) authYN = "";*///commented for ML-MMOH-CRF-0343 [IN:057182]
				//	if (authYN.equals("Y")) //commented for ML-MMOH-CRF-0343 [IN:057182]
						
				if (drugDetails.get("ORD_AUTHORIZED_YN").equals("N") ) {
					
            _bw.write(_wl_block107Bytes, _wl_block107);
			
				 if (drugDetails.get("ORD_AUTHORIZED_YN").equals("N") && auth_amend_pres_yn.equals("Y") && called_amend_from.equals("PH") ) {
						
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
			}
		
				else {
					
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
					}
	
				
				}
			
				else if (drugDetails.get("ORD_AUTHORIZED_YN").equals("Y") ) {
							
						

            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

							}
						
						else {

            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);

						}//commented for ML-MMOH-CRF-0343 [IN:057182]
					}
				}

            _bw.write(_wl_block116Bytes, _wl_block116);

			if (drugDetails.get("ORD_SPL_APPR_REQD_YN") != null){
				if (drugDetails.get("ORD_SPL_APPR_REQD_YN").equals("Y")) {

					String splAprvl = (String)practRights.get("SPL_APPR_YN");
					if(splAprvl == null) splAprvl = "";
					if (splAprvl.equals("Y")) {
						if (approval_yn_val.equals("N")) {

            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

						}
						else {

            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

						}
					}
					else {

            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

					}
				}
			}

            _bw.write(_wl_block122Bytes, _wl_block122);

				
			 if (drugDetails.get("ORD_COSIGN_REQD_YN") != null){
				if (drugDetails.get("ORD_COSIGN_REQD_YN").equals("Y")) {

					String consignYN = (String)practRights.get("COSIGN_YN");
					if(consignYN == null) consignYN = "";
					if (consignYN.equals("Y")) {
						if (cosign_yn_val.equals("N")) {

            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

						}
						else {

            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

						}
					}
					else {

            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

					}
				}
			 }

            _bw.write(_wl_block127Bytes, _wl_block127);

				if (drugDetails.get("CONSENT_REQD_YN").equals("Y")) {

            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

				}
				else {

            _bw.write(_wl_block130Bytes, _wl_block130);

				}

            _bw.write(_wl_block131Bytes, _wl_block131);

	/*
				if(current_rx.equals("Y") && allow_duplicate.equals("N") && patient_class.equals("IP")) {	
					String dup_drug_info	=	"";
					ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
					HashMap  dup_info		=	null;

					if(curr_info.size()>=1) {
						dup_info	  =	(HashMap)curr_info.get(0);

						dup_drug_info = "Patient is Currently On "+generic_name+" Medication till :"+dup_info.get("end_date")+";\n";
						dup_drug_info +="Has been prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
					}
					*/

				//} //commented all & HTML MArgue code removed for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
				drugDetails.put("Dosage_Uom",dflt_code);

            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf( generic_id ));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf( generic_name ));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf( daily_dose ));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf( unit_dose ));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf( mono_graph ));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf( dosage_std ));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf( dosage_unit ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf( recomm_yn ));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(recomm_dosage_by));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf( limit_ind ));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf( min_daily_dose ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf( min_unit_dose ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(calc_by_ind));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(allergy_remarks_code));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(dose_remarks_code));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(currentrx_remarks_code));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf( allergy_yn ));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf( current_rx ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf( srl_no ));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf( form_code ));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf( pres_qty_value ));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf( pres_base_uom ));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf( freq_code ));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf( durn_value ));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf( durn_type ));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf( or_durn_desc ));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf( approval_yn_val ));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf( auth_yn_val ));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf( cosign_yn_val ));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf( order_type_code ));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf( route_code ));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf( end_date ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf( auth_yn ));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf( approval_yn ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf( cosign_yn ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf( consent_reqd_yn ));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf( allergy_desc ));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf( exceed_dose_desc ));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf( dup_drug_desc ));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf( strength_uom ));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf( strength_uom_desc ));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf( str_value ));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf( bms_qty ));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf( dflt_qty_uom ));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf( tab_qty_value ));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf( qty_desc_code ));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(license));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(pres_remarks));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(validate_overide_on_confirm_yn));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(strength_per_pres_uom));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(fract_dose_round_up_yn));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(external_dosage_override_reason));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(external_duplicate_override_reason));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(external_interaction_override_reason));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(external_contra_override_reason));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(external_alergy_override_reason));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(abuse_restric_trn));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(abuse_exists));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(abuse_action));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(abuse_override_remarks));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(abuse_override));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(serialNum));
            _bw.write(_wl_block208Bytes, _wl_block208);

			}




            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(take_home_medication));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block212Bytes, _wl_block212);
 
	putObjectInBean(bean_id,bean,request); 
	putObjectInBean(or_bean_id,ORbean,request);
		putObjectInBean(pre_bean_id,pre_bean,request);

            _bw.write(_wl_block213Bytes, _wl_block213);
 
	//if(current_rx.equals("Y") && allow_duplicate.equals("N") && patient_class.equals("IP")) {
            _bw.write(_wl_block214Bytes, _wl_block214);
	
	//}

            _bw.write(_wl_block215Bytes, _wl_block215);
}catch(Exception e){
	e.printStackTrace();
}finally{ 
       	if(con != null)
      		ConnectionManager.returnConnection(con,request);	 //added for GHL-CRF-0549
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DosageBy.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Additive.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CalculateBy.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BodywtBSA.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllowAlternate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DosageBy.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dose.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dose.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.KG.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.M2.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorized.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorized.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuthorizationReqd..label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Approve.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Approved.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.SplApprovalReqd.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cosigned.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CosignReqd.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ConsentReqd..label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }
}
