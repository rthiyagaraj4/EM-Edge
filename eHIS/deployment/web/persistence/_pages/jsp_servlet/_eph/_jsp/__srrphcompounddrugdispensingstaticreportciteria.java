package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
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

public final class __srrphcompounddrugdispensingstaticreportciteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/SRRPhCompoundDrugDispensingStaticReportCiteria.jsp", 1709121438500L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> \n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script> \n\t\t<script language=\"javascript\" src=\"../js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/IVPiggyBack.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n\t\t\t<form name=\"formIVPiggyBackDrugDetails\" id=\"formIVPiggyBackDrugDetails\" >\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"6\"><font style=\"font-size:9\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</font></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" width=\"2%\">\n\t\t\t\t\t\t\t<table>\n\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"label\" id=\"adr\" name=\"adr\" ><img style=\"visibility:";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\' height =25 width =25 title=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' ></td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"SHIFTTOTAL\" id=\"external\" name=\"external\"  onclick=\"displayDosageCheckResult(\'1\',\'presc\')\"><img  id=\"external_img\" name=\"external_img\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" id=\"external\" name=\"external\"  onclick=\"displayDosageCheckResult(\'1\',\'presc\')\"><img  id=\"external_img\" name=\"external_img\" src=\'../../ePH/images/exceed1.gif\' style=\"visibility:hidden\"></img></td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"SHIFTTOTAL\" id=\"external\" name=\"external\"  onclick=\"displayDosageCheckResult(\'1\',\'presc\')\"><img  id=\"external_img\" name=\"external_img\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"SHIFTTOTAL\" id=\"external\" name=\"external\"  onclick=\"displayDosageCheckResult(\'1\',\'presc\')\"><img  id=\"external_img\" name=\"external_img\" src=\'../../ePH/images/exceed1.gif\' style=\"visibility:hidden\"></img></td>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" id=\"external\" name=\"external\"  onclick=\"displayDosageCheckResult(\'1\',\'presc\')\"><img  id=\"external_img\" name=\"external_img\" src=\'../../ePH/images/exceed1.gif\' style=\"visibility:hidden\"></img></td>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"ALLERGY\" id=\"allergy\" style=\"visibility:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" TITLE=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onClick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\"><img style=\"visibility:";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"allergy_img\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"DOSELIMIT\" id=\"ovr_dosage\"  style=\"visibility:";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' onClick=\"showDosageLimit(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' );\"><img style=\"visibility:";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"ovr_dosage_img\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"CURRENTRX\" id=\"currentrx\" style=\"visibility:";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onClick=\"callCurrentMedication(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\')\"><img style=\"visibility:";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"currentrx_img\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t<!-- onblur=\"checkValidDrug(\'D\', this.value)\" -->\n\t\t\t\t\t<td width=\'30%\' class=\"label\" nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;\n\t\t\t\t\t\t<input type=\"text\" name=\"drug_name\" id=\"drug_name\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"  size=\"38\" maxlength=\"60\" >\n\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"drug_search\" id=\"drug_search\" value=\"?\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" onfocus = \"searchIVDrug(formIVPiggyBackDrugDetails,\'D\', drug_name);volume_focus();\" onclick=\"searchIVDrug(formIVPiggyBackDrugDetails,\'D\', drug_name)\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t\t\t<img id=\"mandatory\" src=\"../../eCommon/images/mandatory.gif\"  ></img>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(drug_code.value);\" id=\"edlImg\" >\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=hidden\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(drug_code.value);\" id=\"edlImg\" >\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t</td>\n\n\t<!--\t\t\t\t\n\t\t\t\t\t<td class=\"label\" width=\"15%\" nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t<input type=\"text\" name=\"dosage\" id=\"dosage\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" onKeyPress=\"return allowValidNumber(this,event,8,2);\" onBlur=\"CheckNum(this);setVolume(this);DosageLimitCheck(this);\" size=\"5\"  maxlength=\"5\" style=\"text-align:right\">\n\t\t\t\t\t\t<label id=\"dosage_unit\"></label>\n\t\t\t\t\t</td>\n\n-->\n\t\t\t\t\t\n\t\t\t\t\t<td class=\"label\" width=\"12%\" nowrap>\n\n\t\t\t\t\t\t\t<input style=\"visibility:";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" type=\"button\" class=\"button\" width=\"5%\" value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\"dosage_limit\" onclick=\"showOverRideRemarks()\" > \n\n\t\t\t\t\t\t&nbsp;<A title=\"TDM Result\" id=\"tdmRslt\" style=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" HREF onMouseOver=\"changeCursor(this);\"\tonClick=\"viewReasonforRequest(tdmOrderId.value);\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</A>\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t<td class=\"label\" id=\"iv_admixture\" width =\"10%\" nowrap> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"admixture\" id=\"admixture\" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" value=\"N\" onClick=\"setAdmixtureValue(formIVPiggyBackDrugDetails),checkadmixture(formIVPiggyBackDrugDetails)\">\t\t\t\t\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" \n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\"label\" id=\"iv_admixture\" width =\"10%\">&nbsp;<input type=\"checkbox\" name=\"admixture\" id=\"admixture\" style=\"visibility:hidden\" value=\"N\">\t</td>  \n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" \n\t\t\t\t\t\t<td class=\"fields\" id=\"iv_admixture\" width =\"10%\" nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"admixture\" id=\"admixture\" ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" value=\"N\" onClick=\"setAdmixtureValue(formIVPiggyBackDrugDetails)\">\t\t\t\t\n\t\t\t\t\t\t</td>             \n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t<td class=\'label\' width =\"10%\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" onclick=\'assignValue(this);\'></td>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t<td class=\'label\'width =\"10%\" ><!-- &nbsp;<input type=\'hidden\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\'> -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&nbsp;\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\' disabled>\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t</tr>\t\t\t\t\t\n<!-- ******************************************* -->\n\t\t\t\t <TR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t<td class=\"label\" width=\"2%\"></td>\n\t\t\t\t\t\t<TD colspan=9>\n\t\t\t\t\t\t\t<TABLE border=0>\n\t\t\t\t\t\t\t<TR>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<TD CLASS=\"label\">Calculate By</TD>\n\t\t\t\t\t\t\t\t<TD CLASS=\"label\">Dosage <input type=\"radio\" id=\"CALC_DOSE_BASED_ON_D\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"D\" ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" onClick=\"setCalculateBy(this,\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\');\" ></TD>\n\t\t\t\t\t\t\t\t<TD CLASS=\"label\">Body wt/BSA <input type=\"radio\" id=\"CALC_DOSE_BASED_ON_B\" name=\"CALC_DOSE_BASED_ON\" id=\"CALC_DOSE_BASED_ON\" value=\"B\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\');\" ></TD>\n\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t\t<tr ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" id=\"calc_by_row1\">\n\t\t\t\t\t<td class=\"label\" width=\"2%\"></td>\n\t\t\t\t\t<TD WIDTH=\"15%\"  CLASS=\"label\" nowrap>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t<SELECT name=\"dosage\" id=\"dosage\" onChange=\"changeScrDetails(this.value);ExternalDosageCheck(\'\',\'presc\');\"  onchange=\'setDrugDosageDetails()\' >\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<OPTION VALUE=\"Q\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</OPTION>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"S\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</OPTION>\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Q\" SELECTED>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"S\" SELECTED>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</OPTION>\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Q\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t</SELECT>\n\t\t\t\t\t\t</TD>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t<TD WIDTH=\"10%\" CLASS=\"label\" ID=\"DOSAGE_LABEL\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</TD>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t<TD WIDTH=\"10%\" CLASS=\"label\" ID=\"DOSAGE_LABEL\">";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="&nbsp;</TD>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t<TD > \n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"STRENGTH_VALUE\" id=\"STRENGTH_VALUE\" class=\"NUMBER\" VALUE=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" SIZE=\"10\" MAXLENGTH=\"11\" onBlur=\"setCalculatedQty(this); DosageLimitCheck(this);setDrugDosageDetails();\"  onKeyPress=\"return allowValidNumber(this,event,8,";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =");\" >&nbsp;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<SELECT name=\"STRENGTH_UOM\" id=\"STRENGTH_UOM\" ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="  onchange=\'setDrugDosageDetails()\'>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"\">&nbsp;--- ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" ---&nbsp;</OPTION>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t<OPTION VALUE=\"\">&nbsp;--- ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t</SELECT><IMG SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></IMG>\n\t\t\t\t\t\t</TD>\n\n\t\t\t</tr>\n<!-- ****************************** -->\n\t\t\t<TR ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" id=\"calc_by_row2\">\n\t\t\t<TD CLASS=\"label\" width=\"2%\">&nbsp</TD>\n\t\t\t<TD CLASS=\"label\" nowrap colspan=9>Dose &nbsp;\n\t\t\t<input type=\"text\" name=\"CALC_DOSE_VALUE\" id=\"CALC_DOSE_VALUE\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" size=\"5\" maxlength=\"8\" onKeyPress=\"return allowValidNumber(this,event,4,3);\" onBlur=\"calculateDosage_By_BSA_or_Weight(\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\');\">\n\t\t\t<select name=\"calc_dose_value_unit\" id=\"calc_dose_value_unit\"><OPTION VALUE=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</OPTION></select><label class=\"label\"><b> / </b></label><select name=\"CALC_DOSE_BY\" id=\"CALC_DOSE_BY\" onChange=\"calculateDosage_By_BSA_or_Weight(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\');\"><option value=\"KG\" ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =">Kg</option><option value=\"M2\" ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =">M2</option></select><label class=\"label\"><b> = </b></label><INPUT TYPE=\"text\" name=\"strength_value_wt_bsa\" id=\"strength_value_wt_bsa\"  VALUE=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" SIZE=\"10\" MAXLENGTH=\"12\" onKeyPress=\"return allowValidNumber(this,event,8,3);\" class=\"number\">&nbsp;<label class=\"label\"> <b>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</b></label>\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\"></img></TD>\t\t\t\n\t\t\t</TR>\n\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'2\'>&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<TD WIDTH=\"8%\" CLASS=\"label\">\n\t\t\t\t\t\t<label id=\'rec_legend\' onclick=\'defaultRecomDose()\' style=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t\t\t\t<font class=\'HYPERLINK\' onmouseover=\'changeCursor(this);\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</font>\n\t\t\t\t\t\t</label>\n\t\t\t\t\t\t<label id=\"rec_value\" style=\"font-size:11;font-weight:bold;color:red\" style=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</label>\n\t\t\t\t\t\t&nbsp;<label id=\"rec_uom\" style=\"font-size:11;font-weight:bold;color:red\" style=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</label>\n\t\t\t\t\t</td> \n\t\t\t\t\t<td colspan=\'3\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t\t\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t<script>formIVPiggyBackDrugDetails.drug_name.focus();</script>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"FORM_CODE\" id=\"FORM_CODE\" VALUE=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"DRUG_CODE\" id=\"DRUG_CODE\" VALUE=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"PRES_QTY_VALUE\" id=\"PRES_QTY_VALUE\" VALUE=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"PRES_BASE_UOM\" id=\"PRES_BASE_UOM\" VALUE=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"UOM_CODE\" id=\"UOM_CODE\" VALUE=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"dosage_unit\" id=\"dosage_unit\" VALUE=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"STRENGTH_UOM_DESC\" id=\"STRENGTH_UOM_DESC\" VALUE=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"STRENGTH_UOM_CODE\" id=\"STRENGTH_UOM_CODE\" VALUE=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"STR_VAL\" id=\"STR_VAL\" VALUE=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ORDERSET_STRENGTH\" id=\"ORDERSET_STRENGTH\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"QTY_DESC_CODE\" id=\"QTY_DESC_CODE\" VALUE=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\n\t\t\t\t<input type=\"hidden\"\tname=\"mode\" id=\"mode\"\tvalue=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"patient_class\" id=\"patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"bean_id\" id=\"bean_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"\t>\n\t\t\t\t<input type=\"hidden\"\tname=\"bean_name\" id=\"bean_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"\t>\n\t\t\t\t<input type=\"hidden\"\tname=\"patient_id\" id=\"patient_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"\t>\n\t\t\t\t<input type=\"hidden\"\tname=\"encounter_id\" id=\"encounter_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"iv_bean_id\" id=\"iv_bean_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"\t>\n\t\t\t\t<input type=\"hidden\"\tname=\"iv_bean_name\" id=\"iv_bean_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"f_i_flag\" id=\"f_i_flag\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\t\n\n\t\t\t\t<input type=\"hidden\"\tname=\"mono_graph\" id=\"mono_graph\"\tvalue=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"daily_dose\" id=\"daily_dose\"\t\tvalue=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"unit_dose\" id=\"unit_dose\"\t\tvalue=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"min_daily_dose\" id=\"min_daily_dose\"\tvalue=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"min_unit_dose\" id=\"min_unit_dose\"\tvalue=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"recom_dosage_unit\" id=\"recom_dosage_unit\"\tvalue=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"drug_desc\" id=\"drug_desc\"\t    value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"recomm_yn\" id=\"recomm_yn\"\t    value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"dosage_std\" id=\"dosage_std\"\t    value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"recomm_dosage_by\" id=\"recomm_dosage_by\"\t    value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"calc_by_ind\" id=\"calc_by_ind\"\t    value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"tdmOrderId\" id=\"tdmOrderId\"\t    value=\"\">\n\t\t\t\t<input type=\"hidden\"\tname=\"order_set_code\" id=\"order_set_code\"\tvalue=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"dosage_by\" id=\"dosage_by\"\tvalue=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"MAR_app_yn\" id=\"MAR_app_yn\"\tvalue=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\n\t\t\t\t<input type=\"hidden\"\tname=\"generic_id\" id=\"generic_id\"\t    value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\t\n\t\t\t\t<input type=\"hidden\"\tname=\"generic_name\" id=\"generic_name\"\t    value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\n\t\t\t\t<input type=\"hidden\"\tname=\"limit_ind\" id=\"limit_ind\"\t    value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"allergy_yn\" id=\"allergy_yn\"\t    value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"current_rx\" id=\"current_rx\"\t    value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"srl_no\" id=\"srl_no\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"allergy_desc\" id=\"allergy_desc\"\t    value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"exceed_dose_desc\" id=\"exceed_dose_desc\"\tvalue=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"dup_drug_desc\" id=\"dup_drug_desc\"\tvalue=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"> \n\t\t\t\t<input type=\"hidden\"\tname=\"order_id\" id=\"order_id\"\tvalue=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"> \n\t\t<!-- for validating ivapplicapable parameter in PH PARAMETER FOR FACILITY -->\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t<!-- <input type=\"hidden\"\tname=\"time_flag\" id=\"time_flag\"\tvalue=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"> -->\n\t\t\t\t\t<input type=\"hidden\"\tname=\"alert_practitioner_yn\" id=\"alert_practitioner_yn\"\tvalue=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t<input type=\"hidden\"\tname=\"AUTH_YN_VAL\" id=\"AUTH_YN_VAL\"\t    value=\"Y\">\n\t\t\t\t\t<input type=\"hidden\"\tname=\"APPROVAL_YN_VAL\" id=\"APPROVAL_YN_VAL\"\tvalue=\"Y\">\n\t\t\t\t\t<input type=\"hidden\"\tname=\"COSIGN_YN_VAL\" id=\"COSIGN_YN_VAL\"\tvalue=\"Y\">\n";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t\t<input type=\"hidden\"\tname=\"AUTH_YN_VAL\" id=\"AUTH_YN_VAL\"\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\"\tname=\"APPROVAL_YN_VAL\" id=\"APPROVAL_YN_VAL\"\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\"\tname=\"COSIGN_YN_VAL\" id=\"COSIGN_YN_VAL\"\tvalue=\"\">\n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t<!--end here -->\n\t\t\t\t<input type=\"hidden\" name=\"perform_external_database_checks_yn\" id=\"perform_external_database_checks_yn\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"external_product_id\" id=\"external_product_id\"     value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"fract_dose_round_up_yn\" id=\"fract_dose_round_up_yn\"  value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason\" id=\"external_dosage_override_reason\" value=";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 =">\n\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason\" id=\"external_duplicate_override_reason\" value=";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =">\n\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason\" id=\"external_interaction_override_reason\" value=";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =">\n\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason\" id=\"external_contra_override_reason\" value=";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =">\n\t\t\t\t<input type=\"hidden\" name=\"external_alergy_override_reason\" id=\"external_alergy_override_reason\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drug_db_dose_check_flag\" id=\"drug_db_dose_check_flag\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_dup_check_yn\" id=\"ext_med_alerts_fired_for_dup_check_yn\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_inte_check_yn\" id=\"ext_med_alerts_fired_for_inte_check_yn\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_contra_check_yn\" id=\"ext_med_alerts_fired_for_contra_check_yn\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_allergy_check_yn\" id=\"ext_med_alerts_fired_for_allergy_check_yn\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t</form>\n";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t<script>changeScrDetails(document.formIVPiggyBackDrugDetails.dosage.value)</script>\n";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t<script>\n\t\t   \tsetTimeout(\"searchOrdersetPiggyBack(\'D\',\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\');\",1000);\n\t\t</script>\n";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\n\t\t<script>\n\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\t\n\t\t\t\t\tparent.parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails.all.dosage_unit.innerText =\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\";\n\t\t\t\t\tparent.parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails.mandatory.style.visibility=\"hidden\";\n";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\t\n\t\t\t\t\tparent.parent.f_detail.f_iv_pb_drug.formIVPiggyBackDrugDetails.all.dosage_unit.innerText =\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\";\n\t\n\t\t\t\t\tparent.parent.f_detail.f_iv_pb_drug.formIVPiggyBackDrugDetails.mandatory.style.visibility=\"hidden\";\n";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\tif(parent.f_iv_pb.document.forms[0] == undefined){\n\t\t\t\tparent.f_iv_pb.location.href=\"IVPiggyBackVehicle.jsp?";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\";\n\t\t\t}\n\t\t setSchedule();\n\t\t</script>\n";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t  <script>\n\t\t\t\t\t  ExternalDosageCheck(\'ONLOAD\');\n\t\t\t\t   </script>\n";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t<script>\n";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t</html>\n";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		//String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try{

		String params	= request.getQueryString();
		String adr_count	         = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
		String patient_id			 = request.getParameter("patient_id");
		String patient_class		 = request.getParameter("act_patient_class");
		String encounter_id			 = request.getParameter("encounter_id");
		String order_id				 = request.getParameter("order_id");
		String mode                  = request.getParameter("mode");

		String order_line_num        = request.getParameter("order_line_num");
		String classValue	= request.getParameter("classValue")==null?"":request.getParameter("classValue");
		String drug_db_allergy_check_flag			= "N";
		if(mode==null) 
			mode="";
		
		if(order_id==null)
			order_id="";

		String order_type_flag		= request.getParameter("order_type_flag");

		if(order_type_flag==null)   
			order_type_flag="";

		String iv_prep_yn			= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String iv_prep_default		= request.getParameter("iv_prep_default")==null?"":request.getParameter("iv_prep_default");
		String order_set_code		= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
		String prev_order			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");



		String MAR_app_yn = "";
		String buildMAR_checked = "";
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
		String buildMAR_enable = "";
		 SRR20056-CRF-0649.1 */
		MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
		String buildMAR_yn = MAR_app_yn;

		if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
			if(patient_class.equals("IP"))
				buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 */
			if(buildMAR_yn.equals("Y"))
				buildMAR_checked ="Checked";
		}

		String checked				="";

		String disabled1			= "";
		String readonly			    = "";
		String catalog_desc			= "";
		String drug_codes			= "";
		String qty_value			= "";
		String qty_unit			    = "";
		String flag1				= "";
		String strDrugCode			= "";

		ArrayList orderSetCodes		=new ArrayList();
		
		String chk_addmixture       = ""; 
		String time_flag            = ""; 
		String disable_addmixture	= "";
		String alert_practitioner_yn= "";
		String drug_desc	        = "";
		String daily_dose	        = "";
		String unit_dose	        = "";
		String min_daily_dose       = "";
		String min_unit_dose	    = "";
		String dosage_unit	        = "";
		String mon_graph	        = "";
		String recomm_yn	        = "";
		String dosage_std	        = "";
		String recomm_dosage_by	        = "";
		String dosage_by	        = "";
		String calc_by_ind	        = "";
		String display              = "display:none";
		String allergy_flag         = "hidden";
		String doselimit_flag       = "hidden";
		String currentrx_flag       = "hidden";
		String over_ride_flag       = "hidden";
		String currentrx_flag_img						= "hidden";
		String allergy_flag_img						= "hidden";
		String doselimit_flag_img						= "hidden";
		
//		String  allergy_YN="N", doselimit_YN="N", currentrx_YN="N"; 
		String allergy_override_reason="";
		String dosage_limit_override_reason="";
		String duplicate_drug_override_reason="";
		String f_i_flag="N";
		String display_tdm = "visibility:hidden";
		HashMap drugReasons  =  null;
		String uom_code				= "";
		String uom_desc				= "";
		//code added for external data base checks 
		String drug_code			= "";
		String perform_external_database_checks_yn	=	"N";	
		String external_database_checks_overrided	=	"N";	
		String loading_ext_prod_id					=	"";
		String external_dosage_override_reason		=   "";	
		String external_duplicate_override_reason	=   "";
		String external_interaction_override_reason	=   "";
		String external_contra_override_reason		=   ""; 
		String external_alergy_override_reason		=   ""; 
		String fract_dose_round_up_yn				=   "";
		String drug_db_dosage_check_flag			=   "Y";
		String ext_prod_id							=   "";
		String external_checks						=   "hidden";

	   // String allergy_override_reason_flag			=  "N";	
		String duplicate_drug_override_reason_flag	=  "N";
		String interaction_override_reason_flag		=  "Y";
		String contraind_override_reason_flag		=  "N";
		String drug_adr_style						= "hidden";
		
		String ex_bean_id   = "@ExternalProductLinkBean";
		String ex_bean_name = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

		String facility_id					= (String)session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );

		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
		String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);
		String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
		String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
		String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
		String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
		String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);   

		//crf 0189
		String disaExst="";
		

		param_bean.clear();	

		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		String or_bean_name		= "eOR.OrderEntryBean";
		OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

	   //ends here

		String bean_id				= "IVPiggyBackBean"+patient_id+encounter_id;
		String bean_name			= "ePH.IVPiggyBackBean";
		IVPiggyBackBean bean		= (IVPiggyBackBean)getBeanObject( bean_id,bean_name, request ) ;

		String iv_bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name			= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name, request ) ;


		iv_bean.setDrug_DB_Product_id(drug_db_product_id);
		iv_bean.setPatId(patient_id);
		iv_bean.setEncId(encounter_id);

		drug_db_interface_yn = "Y";
		iv_bean.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);



		HashMap record;
		HashMap record1;
		/***********************************************************************************************
		  New Enhancement for malasiya :Code for validating IVADMIXTURE APPLICAPABLE and FROM_TIME and 
						TO_TIME in PHPARAMETER FOR FACILITY UNDER IVADMIXTURE TAB starts 
		  date:11/22/2004
		*************************************************************************************************/
	/*	if(!order_type_flag.equals("Existing")&& !mode.equals("amend"))
		{   */
			record1					= new HashMap(); 
			record1					= bean.ChkAdMixture();
			chk_addmixture			= (String)record1.get("IV_ADMIXTURE_APPL_YN");
			alert_practitioner_yn	= (String)record1.get("ALERT_PRACTITIONER_YN");
		
			if(chk_addmixture.equals("N"))
			   disable_addmixture="Disabled";		    
			else
			{
			   disable_addmixture="";
			   time_flag=(String)record1.get("time_flag");
			}
	/*	}*/
		/*************************************Endshere**************************************************/
//out.println("==iv_bean=1==="+iv_bean.getOrderDate());

		iv_bean.setIVPB("Y");
		ArrayList drugList		= iv_bean.getDrugDetails();	  

		if((iv_bean.getOrder_type_flag()).equals("Existing")) 
			disaExst = "";
		if(mode.equals("amend")){
			disaExst ="disabled";
		}
//out.println("==iv_bean==2=="+iv_bean.getOrderDate());

		String strength_value		="0";
		String strength_uom_desc	="";
		String strength_uom			="";
		String dosage_type			="";
		HashMap drugDetails	    = null;
		HashMap drugDetailsAmend	    = null;

		if(drugList.size() > 0){
			drugDetails	    = (HashMap)drugList.get(0);
			strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
			strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
			strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
			dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");

		}

		String disabled	= "";
		String generic_id			="";
		String generic_name			="";
		String mono_graph			="";
		String limit_ind			="";
		String allergy_yn			="";
		String current_rx			="";	
		String srl_no				="";
		String form_code			="";
		String pres_qty_value		="";
		String pres_base_uom		="";
		String freq_code			="";
		String durn_value			="";
		String or_durn_desc			="";
		String auth_yn				="";
		String approval_yn			="";
		String cosign_yn			="";
		String consent_reqd_yn		="";
		String order_type_code		="";
		String fract_dose_appl_yn	="";
		                             
		String route_code			="";
		String end_date				="";
		String dup_drug_desc		="";
		String allergy_desc			="";
		String exceed_dose_desc		="";
		String bms_qty				="";
		String dflt_qty_uom			="";
		String tab_qty_value		="";
		String qty_desc_code		="";
		String amend_yn				="";
		String ord_auth_reqd_yn		="";		
		String ord_spl_appr_reqd_yn	="";	
		String ord_cosign_reqd_yn	="";	
		String ord_authorized_yn	="";	
		String ord_authorized_prev_yn	="";
		String ord_approved_yn		="";	
		String ord_cosigned_yn		="";	
		String sRegRopt				= "";
		String strength_per_value_pres_uom = "";
		String strength_per_pres_uom	   = "";
		String serialNum = "";	
		String dosage_uom_code = "";
		String calc_dose_based_on	= "D";
		String calc_dose_by		    = "";
		String calc_dose_value	    = "";
		String displaydose			= "";
		String displayBSA			= "style='display:none'";
		String kg_selected			= "Selected";
		String m2_selected			= "";
		String select_calc_dose_Dosage="checked";
		String select_calc_dose_WT_BSA="";
		String disable_calc_dose	="";
		ArrayList orderSetValues = new ArrayList();
		String dflt_code	= "";
		int dose_decimal = 2;

		if((request.getParameter("drugSelect") != null && request.getParameter("drugSelect").equals("Y"))|| mode.equals("amend")){
			
			disabled	= "";
			int srlNo		= 0;
//			srlNo			= Integer.parseInt(serialNum);
			drugList			= iv_bean.getDrugDetails();

			if(drugList.size() > 0)
				drugDetails			= (HashMap)drugList.get(0);
			orderSetValues	= iv_bean.getOrderSetValues();
			generic_id			= (String)drugDetails.get("GENERIC_ID");

			drug_desc			= (String)drugDetails.get("DRUG_DESC");
			drug_codes			= (String)drugDetails.get("DRUG_CODE");
			generic_name			= (String)drugDetails.get("GENERIC_NAME");
			daily_dose			= (String)drugDetails.get("DAILY_DOSE");
			min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_DOSE");
			min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_DOSE");
			unit_dose			= (String)drugDetails.get("UNIT_DOSE")==null?"":(String)drugDetails.get("UNIT_DOSE");
			dosage_std			= (String)drugDetails.get("DOSAGE_STD")==null?"":(String)drugDetails.get("DOSAGE_STD");

			recomm_dosage_by			= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
			calc_by_ind			= (String)drugDetails.get("CALC_BY_IND")==null?"":(String)drugDetails.get("CALC_BY_IND");
			mono_graph			= (String)drugDetails.get("MONO_GRAPH")==null?"":(String)drugDetails.get("MONO_GRAPH");
			limit_ind			= (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
			allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
			current_rx			= (String)drugDetails.get("CURRENT_RX");
			srl_no				= (String)drugDetails.get("SRL_NO");
			strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
			strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
			strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
			form_code			= (String)drugDetails.get("FORM_CODE");

			pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
			pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
			freq_code			= (String)drugDetails.get("FREQ_CODE");
			durn_value			= (String)drugDetails.get("DURN_VALUE");
			or_durn_desc			= (String)drugDetails.get("OR_DURN_DESC");
			auth_yn				= (String)drugDetails.get("AUTH_YN");
			approval_yn			= (String)drugDetails.get("APPROVAL_YN");
			cosign_yn			= (String)drugDetails.get("COSIGN_YN");
			consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
			order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
			fract_dose_appl_yn	= (String)drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_APPL_YN");
			route_code			= (String)drugDetails.get("ROUTE_CODE");
			end_date			= (String)drugDetails.get("END_DATE");			
			
			if(mode.equals("amend")){
				dup_drug_desc			= (String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?(String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"):(String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON");
				allergy_desc			= (String)drugDetails.get("ALLERGY_OVERRIDE_REASON")==null?(String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON"):(String)drugDetails.get("ALLERGY_OVERRIDE_REASON");
				exceed_dose_desc		= (String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?(String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"):(String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON");
				calc_dose_based_on	= (String)drugDetails.get("CALC_DOSE_BASED_ON");
				if(calc_dose_based_on!=null && calc_dose_based_on.equals("B"))
				{
					select_calc_dose_Dosage="";
					select_calc_dose_WT_BSA="checked";
					calc_dose_by			= (String)drugDetails.get("CALC_DOSE_BY")==null?"KG":(String)drugDetails.get("CALC_DOSE_BY");
					calc_dose_value			= (String)drugDetails.get("CALC_DOSE_VALUE")==null?"":(String)drugDetails.get("CALC_DOSE_VALUE");
					displaydose="style='display:none'";
					displayBSA="";
					if(calc_dose_by.equals("M2"))
					{
						kg_selected="";
						m2_selected="Selected";
					}
				}
			}
			else{
				dup_drug_desc			= (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails.get("CURRENTRX_REMARKS");
				allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS")==null?"":(String)drugDetails.get("ALLERGY_REMARKS");
				exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS")==null?"":(String)drugDetails.get("DOSE_REMARKS");
			}
			
			bms_qty						= (String)drugDetails.get("BMS_QTY");
			dflt_qty_uom				= (String)drugDetails.get("DFLT_QTY_UOM");
			tab_qty_value				= (String)drugDetails.get("TAB_QTY_VALUE");
			qty_desc_code				= (String)drugDetails.get("QTY_DESC_CODE");
			amend_yn					= (String)drugDetails.get("AMEND_YN");

			qty_value					= (String)drugDetails.get("QTY_VALUE");
			dosage_unit					= (String)drugDetails.get("DOSAGE_UNIT");
			ord_auth_reqd_yn			= (String)drugDetails.get("ORD_AUTH_REQD_YN");
			ord_spl_appr_reqd_yn		= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
			ord_cosign_reqd_yn			= (String)drugDetails.get("ORD_COSIGN_REQD_YN");
			ord_authorized_yn			= (String)drugDetails.get("ORD_AUTHORIZED_YN");
			ord_authorized_prev_yn		= (String)drugDetails.get("ORD_AUTHORIZED_PREV_YN");
			ord_approved_yn				= (String)drugDetails.get("ORD_APPROVED_YN");
			ord_cosigned_yn				= (String)drugDetails.get("ORD_COSIGNED_YN");
			
			sRegRopt					= (String)drugDetails.get("REQD_OR_OPT_IND"); 
			strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
			strength_per_pres_uom		= (String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
			ext_prod_id					= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
			drug_db_dosage_check_flag	= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	


			perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");		
			loading_ext_prod_id			= ext_prod_id;

			external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
			external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
			external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
			external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
			external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");

			if(fract_dose_appl_yn.equals("N"))
				dose_decimal = 0;
			
			if(recomm_dosage_by.equals("B"))
				recomm_dosage_by = "Q";		
		

			if (!classValue.equals("AMENDEDDRUGS")) {
					
				String orgLineNum = Integer.toString(srlNo+1);
				HashMap qtyValues =	iv_bean.getQtyValue(patient_id,order_id,orgLineNum);
				dflt_code = (String)qtyValues.get("strengthUom")==null?"":(String)qtyValues.get("strengthUom");

				if((iv_bean.getOrder_type_flag()).equals("Existing")) 
					qty_desc_code = dflt_code;
			}
		}//*********************************************

		if(order_type_flag.equals("Existing")||mode.equals("amend")){
	
			disabled1="disabled";
			if(!prev_order.equals("") && prev_order.equals("previous")){
				readonly="";
//				current_rx			= (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
			}
			else{
				readonly="readonly";
			}
				  
			ArrayList exstngIVorder = (ArrayList)iv_bean.getExistingIVRecords(order_id,"","");  //RUT-CRF-0062
			record					= new HashMap();
			int siz=exstngIVorder.size();
			String lengt=siz+"";
			if(lengt.equals("1")){
				drugDetailsAmend					= (HashMap)exstngIVorder.get(0);
			}
			else{
				drugDetailsAmend					= (HashMap)exstngIVorder.get(1);
			}

			drug_desc				= drugDetailsAmend.get("DRUG_DESC")==null?(String)drugDetailsAmend.get("CATALOG_DESC"):(String)drugDetailsAmend.get("DRUG_DESC");
			catalog_desc			= (String)drugDetailsAmend.get("CATALOG_DESC");
			drug_codes				= (String)drugDetailsAmend.get("ORDER_CATALOG_CODE");
			qty_value				= (String)drugDetailsAmend.get("QTY_VALUE");
			qty_unit				= (String)drugDetailsAmend.get("QTY_UNIT");
			dosage_type			= (String)drugDetailsAmend.get("DOSAGE_TYPE");
			dosage_uom_code			= (String)drugDetailsAmend.get("DOSAGE_UOM_CODE")==null?"":(String)drugDetailsAmend.get("DOSAGE_UOM_CODE");
			if(record.get("BUILDMAR_YN")==null){
				drugDetailsAmend.put("BUILDMAR_YN",MAR_app_yn);
			}
			buildMAR_yn = (String) drugDetailsAmend.get("BUILDMAR_YN");

			if(buildMAR_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
				if(patient_class.equals("IP"))
					buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 */
				if(buildMAR_yn.equals("Y"))
					buildMAR_checked ="Checked";
			}
//out.println("==iv_bean=3==="+iv_bean.getOrderDate());

			iv_bean.setDrugDetails(drug_codes,"","","","","",""); //CRF-0062
			drugList			= iv_bean.getDrugDetails();

			if(drugList.size() > 0)
				drugDetails			= (HashMap)drugList.get(0);

			if(drugDetails != null && drugDetails.size() >0){
				strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
				strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
				strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
				

				current_rx = (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
				limit_ind = (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
				allergy_yn = (String)drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN");
			}


			 drugReasons=new HashMap();
			 HashMap drugInfo=iv_bean.getAddDrugInfo(drug_codes);
			 String iv_ingredient_yn=(String)drugInfo.get("IV_INGREDIENT_YN");
			 String iv_fluid_yn=(String)drugInfo.get("IV_FLUID_YN");
			 if( iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("Y")){
				 order_line_num="1";f_i_flag="Y";
			 }
			 else{
				 order_line_num="2";
			 }
		 
			 ext_prod_id					= (String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");

			if(mode.equals("amend")){
				drugReasons=iv_bean.getDrugReasons(order_id,order_line_num,ext_prod_id);
			}

			allergy_override_reason=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");
			dosage_limit_override_reason=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
			duplicate_drug_override_reason=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");

			if(!allergy_override_reason.equals("")){
				allergy_flag="visible";
				allergy_yn="Y";
			}
			if(!dosage_limit_override_reason.equals("")){
				doselimit_flag="visible";
				limit_ind="N";
			}
			if(!duplicate_drug_override_reason.equals("")){
				currentrx_flag="visible";
				current_rx="Y";
			}

	//		if(!allergy_override_reason.equals("") || !dosage_limit_override_reason.equals("") || !duplicate_drug_override_reason.equals("")) over_ride_flag="visible";
	

			mon_graph				= (String)drugDetailsAmend.get("MONO_GRAPH");
			recomm_yn				= (String)drugDetailsAmend.get("RECOMM_YN");

			if(recomm_yn.equals("Y")){
				drug_desc				= (String)drugDetails.get("DRUG_DESC");
				daily_dose				= (String)drugDetailsAmend.get("DAILY_DOSE");
				unit_dose				= (String)drugDetailsAmend.get("UNIT_DOSE");
				min_daily_dose		    = (String)drugDetailsAmend.get("MIN_DAILY_DOSE");
				min_unit_dose			= (String)drugDetailsAmend.get("MIN_UNIT_DOSE");
				dosage_unit			    = (String)drugDetailsAmend.get("DOSAGE_UNIT")==null?"":(String)drugDetailsAmend.get("DOSAGE_UNIT");	   
				dosage_std			    = (String)drugDetailsAmend.get("DOSAGE_STD")==null?"":(String)drugDetailsAmend.get("DOSAGE_STD");	   
				calc_by_ind			    = (String)drugDetailsAmend.get("CALC_BY_IND")==null?"":(String)drugDetailsAmend.get("CALC_BY_IND");	   
				recomm_dosage_by			    = (String)drugDetailsAmend.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetailsAmend.get("RECOMM_DOSAGE_BY");	   
				dosage_by			    = (String)drugDetailsAmend.get("DOSAGE_TYPE")==null?"":(String)drugDetailsAmend.get("DOSAGE_TYPE");	   
				display="display:inline";
			}
			else{
				display="display:none";
			}


			if(order_type_flag.equals("Existing")){
			  flag1="Existing";	
			  iv_bean.setOrder_type_flag(flag1);
			} 
			
			if(iv_prep_yn==null)      
				iv_prep_yn="";

			if(iv_prep_yn.equals("3"))
				checked="";
			else  
				   checked="checked"; 
		}// if amend
		/*else{
			if(limit_ind.equals("Y"))
				doselimit_flag = "visible";
			if(allergy_yn.equals("Y"))
				allergy_flag = "visible";
			if(current_rx.equals("Y"))
				currentrx_flag = "visible";
		//}
		if(allergy_yn.equals("Y") || limit_ind.equals("Y") || current_rx.equals("Y"))
				over_ride_flag="visible";*/

		String tdmOrderId = "";
			   tdmOrderId			= iv_bean.getOrderIdForTDMDtls(patient_id,drug_codes);

		if(tdmOrderId==null||tdmOrderId.equals("")){
			display_tdm="visibility:hidden";
		}else{
			display_tdm="visibility:visible";
		} 

		if(drugDetails != null){
			drug_code			= (String)drugDetails.get("DRUG_CODE");


		   if(Integer.parseInt(adr_count)>0){
				int drug_adr_count = iv_bean.getADRCount(patient_id,drug_code);   
				if(drug_adr_count>0){
					drug_adr_style="visible";
				}
			}
			drug_db_dosage_check_flag	= (String) drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	

			perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");		
			loading_ext_prod_id				 = ext_prod_id;

			external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
			external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");	
			external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");	
			external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");	
			external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");	
		}

		
		//code for drug interaction check
		HashMap drug_Interactions				= null;
		String drug_db_interact_check_flag	= "N";
		String drug_db_duptherapy_flag		= "N";
		String drug_db_contraind_check_flag	= "N";
		String dup_drug_det					= "";
		String external_database_overrided_yn = "";
		String external_database_overrided_reason = "";
	//perform_external_database_checks_yn = "Y"; && !mode.equals("amend")

		if(perform_external_database_checks_yn.equals("Y")&& !(ext_prod_id.equals("")) ){
			if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
					
				HashMap tempDetails= null;
				ArrayList reqChecks = new ArrayList();
				reqChecks.add("N"); //Dosage Check 
				reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
				reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
				reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
				reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
				HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", null ,null, null, "N","",""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
				if(drugDBCheckResult!=null)
					beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
				if(drug_db_allergy_check_yn.equals("Y")){
					/*tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
					if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
						drug_db_allergy_check_flag="Y";
					}*/
					if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS)
						String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
						if(allergy_alert!=null && !allergy_alert.equals(""))
							drug_db_allergy_check_flag="Y";
					} 
					else {  
						tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
						if(tempDetails!=null && tempDetails.size()>0){
							 drug_db_allergy_check_flag="Y";
						}
					} 					
				}

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
					tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
					if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
						drug_db_contraind_check_flag="Y";
					}		
				}
			}
			/*
			if(drug_db_interact_check_yn.equals("Y")){
				if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
					beanex.getDDInteractions(loading_ext_prod_id);//Store interactions
					drug_Interactions		= beanex.getInteractions();//get Interactions
					if(drug_Interactions.size()>0){							
					   drug_db_interact_check_flag = "Y";
					   interaction_override_reason_flag = "Y";
					   external_database_checks_overrided = "Y";
					}
				}
			}

			if(drug_db_duptherapy_yn.equals("Y")){ 

				dup_drug_det			= beanex.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result
				if(!dup_drug_det.equals("")&&dup_drug_det!=null){
					current_rx = "N";
					drugDetails.put("CURRENT_RX","N");
					drug_db_duptherapy_flag = "Y";
					duplicate_drug_override_reason_flag = "Y";
					external_database_checks_overrided = "Y";
				}
			}
			if(drug_db_contraind_check_yn.equals("Y")){
				if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
					ArrayList ex_prod_ids =new ArrayList();
					ex_prod_ids.add(loading_ext_prod_id);

					boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
					HashMap contra_indications =(HashMap)beanex.getContraIndications();
					if(contra_indications.containsKey(ext_prod_id)){
						// String  contra_indication_for_drug   =(String)contra_indications.get(ext_prod_id);
					   if(contra_indications.containsKey(ext_prod_id)){
						drug_db_contraind_check_flag = "Y";
						contraind_override_reason_flag = "Y";
						external_database_checks_overrided = "Y";
					   }
					}					  
				}
			}
			
			if(drug_db_allergy_check_yn.equals("Y")){ 
				ArrayList ex_prod_ids =new ArrayList();
					ex_prod_ids.add(loading_ext_prod_id);
				if(ext_prod_id!=null&& !ext_prod_id.equals("") && ex_prod_ids!=null && !ex_prod_ids.equals("")){
					beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get allergy
					HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
//out.println("drug_alergies="+drug_alergies+"==ext_prod_id=="+ext_prod_id);
					if(drug_alergies.containsKey(ext_prod_id)){
						allergy_yn = "N";
						drugDetails.put("ALLERGY_YN","N");
						drug_db_allergy_check_flag="Y";
					}	
				}
			}
			*/
			if(drugDetails != null){
				drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
				drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
				drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
				drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_check_flag);
			}
			
			drugDetails.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);

			if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
				external_database_overrided_yn = "Y";

			if(external_database_overrided_yn.equals("Y") && (external_interaction_override_reason.equals("")|| external_duplicate_override_reason.equals("") || external_contra_override_reason.equals("") || external_dosage_override_reason.equals("") || external_alergy_override_reason.equals("")))
				external_database_overrided_reason="N";
			else
				external_database_overrided_reason="Y";
			if(external_database_overrided_reason.equals("Y"))
				external_checks	= "hidden";
			else
				external_checks = "visible";

			drugDetails.put("EXTERNAL_DATABASE_OVERRIDED_REASON",external_database_overrided_reason);
	

			if(drug_db_dosecheck_yn.equals("N") && drug_db_duptherapy_yn.equals("N") && drug_db_interact_check_yn.equals("N") && drug_db_contraind_check_yn.equals("N") && drug_db_allergy_check_yn.equals("N"))
				external_checks	= "hidden";
	

		/*	if(perform_external_database_checks_yn.equals("Y")){
				external_checks = "visible";
			}*/

			if(drug_db_duptherapy_flag.equals("Y"))
				currentrx_flag = "hidden";
			if(drug_db_dosage_check_flag.equals("Y"))
				doselimit_flag = "hidden";
			if(drug_db_allergy_check_flag.equals("Y"))
				allergy_flag = "hidden";
		}
		else{
			drug_db_product_id = "";
		}


		if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
				external_database_overrided_yn = "Y";


		if(external_database_overrided_yn.equals("Y") && (drug_db_interact_check_flag.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && external_duplicate_override_reason.equals("") )|| (drug_db_contraind_check_flag.equals("Y")&& external_contra_override_reason.equals("") )|| (drug_db_dosage_check_flag.equals("Y") && external_dosage_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && external_alergy_override_reason.equals("")))
			external_database_overrided_reason="N";
		else{
			external_database_overrided_reason="Y";
		}

		if(external_database_overrided_reason.equals("Y"))
			external_checks	= "hidden";
		else
			external_checks = "visible";

		if(limit_ind.equals("N"))
			doselimit_flag = "visible";
	
		//}
//out.println("allergy_yn="+allergy_yn+"=drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"=allergy_override_reason="+allergy_override_reason);
		if(allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {
				if(allergy_override_reason.equals("")){
					allergy_flag = "visible";
					allergy_flag_img = "visible";
				}
				else{
					allergy_flag = "visible";
					allergy_flag_img = "hidden";
				}
			}else{
				allergy_flag = "hidden";
				allergy_flag_img = "hidden";
			}



			if(current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
				if(duplicate_drug_override_reason.equals("")){
					currentrx_flag = "visible";
					currentrx_flag_img = "visible";
				}
				else{
					currentrx_flag = "visible";
					currentrx_flag_img = "hidden";
				}
			}else{
				currentrx_flag = "hidden";
				currentrx_flag_img = "hidden";
			}

		if(limit_ind.equals("N") && !drug_db_dosecheck_yn.equals("Y")) {
				if(dosage_limit_override_reason.equals("")){
					doselimit_flag = "visible";
					doselimit_flag_img = "visible";
				}
				else{
					doselimit_flag = "visible";
					doselimit_flag_img = "hidden";
				}
			}
		else{
				doselimit_flag = "hidden";
				doselimit_flag_img = "hidden";
		}

		if(allergy_yn.equals("Y") || limit_ind.equals("N") || current_rx.equals("Y"))
				over_ride_flag="visible";


		
	/*	if(mode.equals("amend")){
			out.println(doselimit_flag_img+",,"+allergy_flag_img+",,"+currentrx_flag_img);
			if(doselimit_flag_img.equals("visible") || allergy_flag_img.equals("visible") || currentrx_flag_img.equals("visible"))
					over_ride_flag="visible";
			else
				over_ride_flag="hidden";
		}*/

	//	iv_bean.setIVPB("Y");


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(drug_adr_style));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
								
								if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
									if(((drug_db_interact_check_flag.equals("Y") && drug_db_interact_check_yn.equals("Y"))|| (drug_db_duptherapy_flag.equals("Y") && drug_db_duptherapy_yn.equals("Y") )|| (drug_db_contraind_check_flag.equals("Y")&& drug_db_contraind_check_yn.equals("Y") )|| (drug_db_dosage_check_flag.equals("Y") && drug_db_dosecheck_yn.equals("Y")) || (drug_db_allergy_check_flag.equals("Y") && drug_db_allergy_check_yn.equals("Y"))) && !ext_prod_id.equals("")){

            _bw.write(_wl_block12Bytes, _wl_block12);
									}else{

            _bw.write(_wl_block13Bytes, _wl_block13);
									}							
								}else{
									if((drug_db_interact_check_flag.equals("Y") && drug_db_interact_check_yn.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && drug_db_duptherapy_yn.equals("Y") && external_duplicate_override_reason.equals(""))|| (drug_db_contraind_check_flag.equals("Y")&& drug_db_contraind_check_yn.equals("Y")&& external_contra_override_reason.equals("") )|| (drug_db_dosage_check_flag.equals("Y") && drug_db_dosecheck_yn.equals("Y")&& dosage_limit_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && drug_db_allergy_check_yn.equals("Y")&& external_alergy_override_reason.equals(""))){										

            _bw.write(_wl_block14Bytes, _wl_block14);
									}
									else if((drug_db_interact_check_flag.equals("Y") && !external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && !external_duplicate_override_reason.equals(""))|| (drug_db_contraind_check_flag.equals("Y")&& !external_contra_override_reason.equals("") )|| (drug_db_dosage_check_flag.equals("Y") && !dosage_limit_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && !external_alergy_override_reason.equals(""))){

            _bw.write(_wl_block15Bytes, _wl_block15);
									}else{
	
            _bw.write(_wl_block16Bytes, _wl_block16);
								}
								}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(allergy_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(allergy_flag_img));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(doselimit_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(doselimit_flag_img));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(currentrx_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(currentrx_flag_img));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disabled1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(drug_codes));
            _bw.write(_wl_block32Bytes, _wl_block32);
						if(!drug_desc.equals("")){

            _bw.write(_wl_block33Bytes, _wl_block33);

						}else{	

            _bw.write(_wl_block34Bytes, _wl_block34);
						}

            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(over_ride_flag));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(display_tdm));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

					if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){

            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disable_addmixture));
            _bw.write(_wl_block46Bytes, _wl_block46);

					}
					else if(f_i_flag.equals("Y")){

            _bw.write(_wl_block47Bytes, _wl_block47);

					}
					else{

            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block50Bytes, _wl_block50);

					}
					if(MAR_app_yn.equals("Y")){

            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block54Bytes, _wl_block54);

					}
					else{

            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

					}

            _bw.write(_wl_block57Bytes, _wl_block57);
 if (strength_value.equals("0")) {				
						select_calc_dose_Dosage="checked";
						select_calc_dose_WT_BSA="";
						disable_calc_dose="disabled";						
						}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(select_calc_dose_Dosage));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disable_calc_dose));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(select_calc_dose_WT_BSA));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disable_calc_dose));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(displaydose));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
						//disaExst
						if (strength_value.equals("0")) {

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
						}
						else {
							if(dosage_type.equals("Q")) {

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

							}
							else {

            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

							}
						}

            _bw.write(_wl_block70Bytes, _wl_block70);

						String str_value = "";
						if (strength_value.equals("0")) {
							disabled = "";
							str_value	= pres_qty_value;

            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
						}
						else {
							if(dosage_type.equals("S")) {
								str_value	= strength_value;
								disabled	= "DISABLED";

            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

							}
							else {
								str_value	= pres_qty_value;
								disabled	= "";

            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

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

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( str_value ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( disabled ));
            _bw.write(_wl_block78Bytes, _wl_block78);
//disaExst
							if (!strength_value.equals("0")) {

								if(dosage_type.equals("S")) {


            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( strength_uom ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( strength_uom_desc ));
            _bw.write(_wl_block65Bytes, _wl_block65);

								}
								else {

            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

									Hashtable QtyDescDetails	= (Hashtable)iv_bean.listQtyDetails(drug_codes);
									Enumeration keys_des		= QtyDescDetails.keys();
									String def_uom				= "";

									while(keys_des.hasMoreElements()) {
										uom_code	= (String)keys_des.nextElement();
										uom_desc	= (String)QtyDescDetails.get(uom_code);

										if(!uom_code.equals("dflt_code")) {
//											if(uom_code.equals(qty_desc_code))qty_unit
											if(uom_code.equals(dosage_uom_code))
												def_uom = "SELECTED";
											else
												def_uom = "";

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( uom_code ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( def_uom ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( uom_desc ));
            _bw.write(_wl_block65Bytes, _wl_block65);

										}
									}
								}
							}
							else {

            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

								Hashtable QtyDescDetails	= (Hashtable)iv_bean.listQtyDetails(drug_codes);
								Enumeration keys_des		= QtyDescDetails.keys();
								String def_uom				= "";

								if (amend_yn.equals("N"))
									dflt_code = QtyDescDetails.get("dflt_code") == null ? "" : QtyDescDetails.get("dflt_code").toString();
								else
									dflt_code = qty_desc_code;
								while(keys_des.hasMoreElements()) {
									uom_code	= (String)keys_des.nextElement();
									uom_desc	= (String)QtyDescDetails.get(uom_code);

									if(!uom_code.equals("dflt_code")) {
//										if(uom_code.equals(dflt_code))
										if(uom_code.equals(qty_unit))
											def_uom = "SELECTED";
										else
											def_uom = "";

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( uom_code ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( def_uom ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( uom_desc ));
            _bw.write(_wl_block65Bytes, _wl_block65);

									}
								}
							}
							

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(displayBSA));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(calc_dose_value));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( strength_uom_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(kg_selected));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(m2_selected));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(display));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(display));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(display));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block100Bytes, _wl_block100);

				if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){

            _bw.write(_wl_block101Bytes, _wl_block101);

				}

            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf( form_code ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf( drug_codes ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf( pres_qty_value ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( pres_base_uom ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf( uom_code ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf( dosage_unit ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf( strength_uom_desc ));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf( strength_uom ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf( strength_value ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf( qty_desc_code ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(iv_bean_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(iv_bean_name));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(f_i_flag));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(mon_graph));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(recomm_dosage_by));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(calc_by_ind));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(order_set_code));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(dosage_by));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(MAR_app_yn));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(current_rx));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(allergy_desc));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(exceed_dose_desc));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(dup_drug_desc));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block146Bytes, _wl_block146);

				if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(time_flag));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(alert_practitioner_yn));
            _bw.write(_wl_block149Bytes, _wl_block149);

				}
				if(order_type_flag.equals("Existing")||mode.equals("amend")){

            _bw.write(_wl_block150Bytes, _wl_block150);

				}
				else {

            _bw.write(_wl_block151Bytes, _wl_block151);

				}

            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(fract_dose_round_up_yn));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_dosage_override_reason)));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_duplicate_override_reason)));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_interaction_override_reason)));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_contra_override_reason)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_alergy_override_reason)));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(interaction_override_reason_flag));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(contraind_override_reason_flag));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(drug_db_allergy_check_flag));
            _bw.write(_wl_block165Bytes, _wl_block165);

			if(!mode.equals("amend")){

            _bw.write(_wl_block166Bytes, _wl_block166);

			}
	   if(iv_prep_default.equals("3") || iv_prep_default.equals("4")){
			orderSetCodes = (ArrayList) iv_bean.getOrdersetCodes(order_set_code);
			strDrugCode = (String) orderSetCodes.get(1);

            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(order_set_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strDrugCode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block168Bytes, _wl_block168);

		}


            _bw.write(_wl_block169Bytes, _wl_block169);

	
			if(order_type_flag.equals("Existing")||mode.equals("amend")){
				if(!prev_order.equals("") && prev_order.equals("previous")){

            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block171Bytes, _wl_block171);
	
				}
				else{

            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block173Bytes, _wl_block173);
	
				}
			}
			

            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf( params ));
            _bw.write(_wl_block175Bytes, _wl_block175);

		if (mode!=null && !mode.equals("blank")&& !mode.equals("amend") && request.getParameter("drugSelect")!=null && !request.getParameter("drugSelect").equals("Y") && perform_external_database_checks_yn.equals("Y")){		  
			  if(drug_db_dosecheck_yn.equals("Y")){

            _bw.write(_wl_block176Bytes, _wl_block176);
 
				}

            _bw.write(_wl_block177Bytes, _wl_block177);

				  //out.println("viewMedicationAlert('"+patient_id+"','"+loading_ext_prod_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dosage_check_flag+"','ONLOAD','"+external_dosage_override_reason+"','"+drug_code+"','"+srl_no+"','"+external_duplicate_override_reason+"','"+external_interaction_override_reason+"','"+external_contra_override_reason+"','"+pract_name+"','"+external_alergy_override_reason+"','"+drug_db_dosecheck_yn+"')");

            _bw.write(_wl_block178Bytes, _wl_block178);

			}

            _bw.write(_wl_block179Bytes, _wl_block179);

		putObjectInBean(bean_id,bean,request);
		putObjectInBean(iv_bean_id,iv_bean,request);
		putObjectInBean(or_bean_id,ORbean,request);	
	}
	catch(Exception e){
		e.printStackTrace();
	}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDetail.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllergyDrug.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ExceedDosageLimit.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateMedication.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.override.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Admixture.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Admixture.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
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
}
