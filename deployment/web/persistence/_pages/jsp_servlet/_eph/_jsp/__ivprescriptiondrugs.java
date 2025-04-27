package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eOR.*;
import eOR.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ivprescriptiondrugs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVPrescriptionDrugs.jsp", 1709120901877L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!-- ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IVPrescriptionWithAdditives.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t</HEAD>\n\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n\t\t<FORM name=\"formIVPrescriptionDrugList\" id=\"formIVPrescriptionDrugList\">\n\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"6\"><font style=\"font-size:9\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font></td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"external_dosage_override_reason";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"      value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"   value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"external_interaction_override_reason";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"external_contra_override_reason";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_alergy_override_reason";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"external_alergy_override_reason";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"abuse_override_remarks";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"abuse_override_remarks";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"><!--added for aakh-crf-0140 -->\n\t\t\t\t\t\t\t<TR TITLE=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<TD CLASS=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" COLSPAN=\"\" NOWRAP WIDTH=\"64%\" onClick=\"defaultDrug(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\');\"  onMouseOver=\"changeCursor(this); changeCol(this);\" onMouseOut=\"realCol(this,\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\');\"><FONT CLASS=\"HYPERLINK\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</FONT>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t<IMG onMouseOver=\"changeCursor(this)\" STYLE=\"filter:Chroma(Color=#FFFFFF)\" SRC=\"../../ePH/images/info.gif\" HEIGHT=\"20\" WIDTH=\"20\" onClick=\"loadDrugInfo(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\')\">\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t</TD>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n\t\t\t\t\t\t\t\t<TD CLASS=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t<TD CLASS=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\" ><img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\' height =20 width =20 title=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' ></img></TD>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" WIDTH=\"6%\">&nbsp;</TD>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t<TD CLASS=\"SHIFTTOTAL\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\" id=\"ext_ddb_override_indc";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"  onclick=\"viewMedicationAlert(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\',\'PRESPAD\',\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\" onmouseover=\"changeCursor(this);\">\n\t\t\t\t\t\t\t\t<img name=\"ext_ddb_override_img";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" src=\'../../ePH/images/exceed1.gif\' style=\"visibility:";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =";\" ></img>\n\t\t\t\t\t\t\t\t&nbsp;</TD>\n\t\t\t\t\t\t\t<!--\t<TD CLASS=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\">&nbsp;</TD>\n\t\t\t\t\t\t\t\t<TD CLASS=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" WIDTH=\"6%\">&nbsp;</TD>\n\t\t\t\t\t\t\t\t<TD CLASS=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\">&nbsp;</TD>-->\n\t\t\t\t\t\t\t\t\t\t  \n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\" id=\"override_indc";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"><img name=\"override_img";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" src=\'../../ePH/images/exceed1.gif\' style=\"visibility:hidden;\" ></img>&nbsp;</TD>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t<TD CLASS=\"ALLERGY\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\" TITLE=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' onClick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\');\" onMouseOver=\"changeCursor(this);\">&nbsp;";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&nbsp;</TD>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\">&nbsp;</TD>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t<TD CLASS=\"DOSELIMIT\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\" TITLE=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' onMouseOver=\"changeCursor(this);\" onClick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');\">&nbsp;";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&nbsp;</TD><!-- Modified for IN:070451  -->\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t<TD CLASS=\"CURRENTRX\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\" TITLE=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' onMouseOver=\"changeCursor(this);\" onClick=\"callCurrentMedication(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\')\">&nbsp;";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t<TD CLASS=\"CURRENTRX\" style=\"BACKGROUND-COLOR:purple;\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\" TITLE=\'Drug Abuse\' onMouseOver=\"changeCursor(this);\" onClick=\"showAbuseDetails(\'\',\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\',\'Clicking\')\">&nbsp;";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</TR>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"drug_code_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"\t value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_class_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"drug_class_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_prod_id_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"ext_prod_id_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_db_dose_check_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"external_db_dose_check_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_dup_check_yn";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"ext_med_alerts_fired_for_dup_check_yn";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_inte_check_yn";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"ext_med_alerts_fired_for_inte_check_yn";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_contra_check_yn";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"ext_med_alerts_fired_for_contra_check_yn";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_dosage_check_yn";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"ext_med_alerts_fired_for_dosage_check_yn";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_allergy_check_yn";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" id=\"ext_med_alerts_fired_for_allergy_check_yn";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"abuse_override_remarks\" id=\"abuse_override_remarks\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" >\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"abuse_override\" id=\"abuse_override\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t</TABLE>\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" VALUE=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" VALUE=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"patient_id\" id=\"patient_id\" VALUE=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_codes\" id=\"drug_codes\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"tot_volume\" id=\"tot_volume\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"weight\" id=\"weight\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"bsa\" id=\"bsa\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\n\t\t\t\t\t<!-- added for ml-mmoh-crf-0863 start -->\n\t\t\t\t    <INPUT type=\"hidden\" name=\"take_home_medication\" id=\"take_home_medication\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t\t\t<INPUT type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t\t\t<INPUT type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n<!-- added for ml-mmoh-crf-0863 end -->\n\t\t\t\t\t\n\t\t\t\t\t<script>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\tloadDrugCodes();\t\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\tsetTimeout(\"defaultDrug(\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\');\",1500);\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t<script>setTimeout(\"setOrdersetIVDrugs(\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\');\",1000);</script>\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t</FORM>\n\t</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );
	
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
30/06/2020      IN:072715                  Haribabu            30/06/2020     Manickavasagam J     MMS-DM-CRF-0165
06/01/2021		 TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
25-05-2022               AAKH-CRF-0140      PRATHYUSHA
--------------------------------------------------------------------------------------------------------------
*/    

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Connection con			= null;    //added for aakh-crf-0140
				con						   = ConnectionManager.getConnection(request);//added for aakh-crf-0140
	   	

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

		String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");
		String adr_count	    = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
		String order_id			= request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_set_code   = request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
		String weight           = request.getParameter("weight")==null?"":request.getParameter("weight");
		String bsa              = request.getParameter("bsa")==null?"":request.getParameter("bsa");
		// added for ml-mmoh-crf-0863 start 
		String iv_prep_yn		= request.getParameter("iv_prep_yn") == null ? "":request.getParameter("iv_prep_yn");
		String take_home_medication		= request.getParameter("take_home_medication") == null ? "":request.getParameter("take_home_medication");
		String priority		= request.getParameter("priority") == null ? "":request.getParameter("priority");
		boolean drug_abuse_app=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
		System.out.println("take_home_medication in IVprescriptiondrugs.jsp"+take_home_medication);
		System.out.println("priority in  IVprescriptiondrugs.jsp"+priority);
		System.out.println("iv_prep_yn in  IVprescriptiondrugs.jsp "+iv_prep_yn);
		// added for ml-mmoh-crf-0863 end
		if(weight.equals(""))
			weight = "0";
		if(bsa.equals(""))
			bsa = "0";
		ArrayList orderSetCodes	= new ArrayList();
		String iv_prep_default  = request.getParameter("iv_prep_default")==null?"":request.getParameter("iv_prep_default");
		StringBuffer ordsetDrugCodes = new StringBuffer();
		String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request) ;
		bean.setPatId(patient_id);
		bean.setEncId(encounter_id);

		if(iv_prep_default.equals("1") || iv_prep_default.equals("2")){
			if(!order_set_code.equals("")) 
				orderSetCodes = bean.getOrdersetCodes(order_set_code);

			if(orderSetCodes != null && orderSetCodes.size() > 1) {
				for(int i=1; i<orderSetCodes.size();i++){
					ordsetDrugCodes.append((String)orderSetCodes.get(i));
					ordsetDrugCodes.append(",");
				}
			}
			bean.setDrugCodes(ordsetDrugCodes.toString());
		}
		String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		String facility_id					= (String)session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		/* Commented for SRR20056-SCF-7354
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
		String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);
		String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
		String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
		String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
		String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
		String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);
		*/
		String drug_db_interface_yn			= "N";//Added for SRR20056-SCF-7354
		String drug_db_product_id			= "";
		String drug_db_dosecheck_yn			= "N";
		String drug_db_duptherapy_yn		= "N";
		String drug_db_interact_check_yn	= "N";
		String drug_db_contraind_check_yn	= "N";
		String drug_db_allergy_check_yn		= "N";
		String abuse_exists="";//added for aakh-crf-0140
		String abuse_action="";//added for aakh-crf-0140
		String abuse_override="";//added for aakh-crf-0140
				String abuse_override_remarks="";
String drug_abuse_gif="";//added for aakh-crf-0140
				String abuse_restrict_tran="N";//added for AAKH-CRF-0140
		String[] sDrugDBAllChecks = param_bean.drugDBALLChecksYN(facility_id);
		if(sDrugDBAllChecks != null && sDrugDBAllChecks.length>6){
			drug_db_interface_yn			=	sDrugDBAllChecks[0];    
			drug_db_product_id			=	sDrugDBAllChecks[1];    
			drug_db_dosecheck_yn			=	sDrugDBAllChecks[2];    
			drug_db_duptherapy_yn		=	sDrugDBAllChecks[3];    
			drug_db_interact_check_yn	=	sDrugDBAllChecks[4];      
			drug_db_contraind_check_yn	=	sDrugDBAllChecks[5];    
			drug_db_allergy_check_yn		=	sDrugDBAllChecks[6];    
		}//SRR20056-SCF-7354
		param_bean.clear();		
		bean.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);	
		String or_bean_name			= "eOR.OrderEntryBean";
		String or_bean_id			= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean		= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
		ArrayList drugList		= null;
		drugList		        = bean.getDrugDetails();
		int drug_adr_count      = 0;

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

				if ((drugList != null)&&(drugList.size() > 0)) {
					String tmp_srl_no				=	null;
					String srl_no					=	null;
					String drug_desc				=	null;
					String drug_code				=   null;
					String drug_class				=   null;
					String generic_id				=	null;
					String generic_name				=	null;
					String allergy_yn				=	null;
					String qty_value				=	null;
					String or_qty_desc				=	null;
					String limit_ind				=	null;
					String mono_graph				=	null;
					String daily_dose				=	null;
					String unit_dose				=	null;
					String min_daily_dose			=	null;
					String min_unit_dose			=	null;
					String current_rx				=	null;
					String count_rx				    =	null;
					String allergy_override			=	null;
					String dose_override			=	null;
					String currentrx_override		=	null;
					String sch_over_yn				=	null;
					String ext_prod_id				=	null;						
					String strength_per_value		=   "0";
					String strength_per_pres		=	"0";
					String dosage_type				=	"";
					String tot_volume				=	"0";
					String dosage_unit				=	"";
					String dosage_std               =   "";
					//String abuse_override="";//added for aakh-crf-0140
					//String abuse_override_remarks="";
					String perform_external_database_checks_yn	=	"";	
					String external_database_overrided_reason	=	"";	
					String external_database_overrided_yn	    =	"";	
					String loading_ext_prod_id					=	"";
					String drug_db_interact_check_flag			=  "N";
					String drug_db_duptherapy_flag				=  "N";
					String drug_db_allergy_check_flag			=  "N";
					String drug_db_contraind_check_flag			=  "N";
					String drug_db_dosage_check_flag			=  "N";
					String external_dosage_override_reason		=   "";	
					String external_duplicate_override_reason	=   "";
					String external_interaction_override_reason	=   "";
					String external_contra_override_reason		=   ""; 
					String external_alergy_override_reason		=   ""; 
					String dose_unit_desc ="";//Added for IN:070451
					String dose_unit_desc1="";//Added for IN:070451
					String ext_dosage_reason		=   ""; //Added new variable on 18/oct/2010
					String startdate="", enddate="";// Added for ML-BRU-SCF-0811 [IN:039394]
					String pract_name							= (String)orbean.getPractitionerName();
					String extVisble							= "visible";

					//Added for MMS-DM-CRF-0177
					String new_generic_name = ""; 
					String pre_alloc_appl = ""; 
					String drug_search = "";
					pre_alloc_appl = bean.getPreAllocApplYN();
					//Added for MMS-DM-CRF-0177
					
					String ex_bean_id				= "@ExternalProductLinkBean";
					String ex_bean_name				= "ePH.ExternalProductLinkBean";
					ExternalProductLinkBean beanex  = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

					String classValue				= "SELECTEDRUGS";
					ArrayList exProd				= new ArrayList();
					ArrayList drugDesc				= new ArrayList();
					HashMap drug_Interactions				= null;
					String  dose_uom = "", frequency="", repeat_value="", interval_value="", dosage="",  strength_per_value_pres_uom="", strength_per_pres_uom="", dosage_by="" ;
					HashMap details = null;
					ArrayList dosageCheckParams = null;
					String dup_drug_det					= "";
					String route_code	= "", qty_desc_code= "", repeat_durn_type	= "", freq_nature	= "", freq_nature_pas = "I";// Added in January 2014 for CIMS dosage check 
					HashMap drugDetails = null;
					for(int k=0;k<drugList.size();k++){
						HashMap drug_detail				=   (HashMap) drugList.get(k);
						String ext_srl_no				=   (String) drug_detail.get("SRL_NO");
						if(!exProd.contains((String)drug_detail.get("EXTERNAL_PRODUCT_ID"))){
							drugDesc.add((String)drug_detail.get("DRUG_DESC"));
							if((String) drug_detail.get("EXTERNAL_PRODUCT_ID")!=null && !((String) drug_detail.get("EXTERNAL_PRODUCT_ID")).equals("")){
							       exProd.add((String)drug_detail.get("EXTERNAL_PRODUCT_ID"));
							}
						}
					}
					/*if(exProd.size()>0)
						beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids*/

					for(int i=0;i<drugList.size();i++) {
						//if(mode.equals("amend")){i = i+1;}
						drugDetails = (HashMap)drugList.get(i);
						if ( (drugDetails!=null) && (drugDetails.size() > 0) ){
							extVisble	= "visible";
							srl_no					= (String)drugDetails.get("SRL_NO");
							drug_desc				= (String)drugDetails.get("DRUG_DESC")==null?(String)drugDetails.get("SHORT_DESC"):(String)drugDetails.get("DRUG_DESC");
							drug_code				= (String)drugDetails.get("DRUG_CODE");
							drug_class				= (String)drugDetails.get("DRUG_CLASS")==null?"":(String)drugDetails.get("DRUG_CLASS");
							generic_id				= (String)drugDetails.get("GENERIC_ID");
							generic_name			= (String)drugDetails.get("GENERIC_NAME");
							allergy_yn				= (String)drugDetails.get("ALLERGY_YN");
							qty_value				= (String)drugDetails.get("QTY_VALUE");
							or_qty_desc				= (String)drugDetails.get("OR_QTY_DESC");
							limit_ind				= (String)drugDetails.get("LIMIT_IND");
							mono_graph				= (String)drugDetails.get("MONO_GRAPH");
							daily_dose				= (String)drugDetails.get("DAILY_DOSE");
							unit_dose				= (String)drugDetails.get("UNIT_DOSE");
							min_daily_dose			= (String)drugDetails.get("MIN_DAILY_DOSE");
							min_unit_dose			= (String)drugDetails.get("MIN_UNIT_DOSE");
							dosage_std				= (String)drugDetails.get("DOSAGE_STD");
							//added for aakh-crf-0140 start
							if(drug_abuse_app){
								
							
							abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");
							abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");
							abuse_restrict_tran=(String)drugDetails.get("ABUSE_RESTRIC_TRN")==null?"":(String)drugDetails.get("ABUSE_RESTRIC_TRN");
							abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"N":(String)drugDetails.get("ABUSE_OVERRIDE");
							abuse_override_remarks=(String)drugDetails.get("abuse_override_remarks")==null?"":(String)drugDetails.get("abuse_override_remarks");
							
							System.out.println("248 abuse_override_remarks"+abuse_override_remarks);
							}
							else{
								abuse_exists="N";
								abuse_action="U";
								abuse_restrict_tran="N";
								abuse_override_remarks="";
								abuse_override="N";
							}
							//added for aakh-crf-0140end
							//Added for IN:070451 start
							String max_daily_ceeling_dose			= (String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
							String min_daily_ceeling_dose			= (String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
							String max_unit_ceeling_dose			= (String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
							String min_unit_ceeling_dose			= (String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
							dosage_unit			=	(String)drugDetails.get("DOSAGE_UNIT");
							if(!dosage_unit.equals("")){ // Added for ML-MMOH-SCF-0864 - Start
								   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit);
								   dose_unit_desc1= dose_unit_desc;
									System.out.println("dose_unit_desc--11>"+dose_unit_desc);
									if(dose_unit_desc==null || dose_unit_desc=="" ) {
									  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
									  dose_unit_desc1= dose_unit_desc;
								     if(dosage_unit.split("/").length>=2)
									   dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
									
									} 

								}
								//Added for IN:070451 end
							current_rx				= (String)drugDetails.get("CURRENT_RX");
							count_rx				= (String)drugDetails.get("COUNT_RX");
							allergy_override		= (String)drugDetails.get("ALLERGY_OVERRIDE");
							dose_override			= (String)drugDetails.get("DOSE_OVERRIDE");
							currentrx_override		= (String)drugDetails.get("CURRENTRX_OVERRIDE");
							sch_over_yn				= (String)drugDetails.get("SCH_OVER_YN");
							ext_prod_id			    = (String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
							//dosage_unit			    = (String)drugDetails.get("DOSAGE_UNIT")//Commentted for IN:070451
							strength_per_value		= (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
							strength_per_pres		= (String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
							dosage_type			    = (String)drugDetails.get("DOSAGE_TYPE");
							perform_external_database_checks_yn = drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");	
	
							
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
							
							loading_ext_prod_id				    = ext_prod_id;
							drug_db_dosage_check_flag           = (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
							external_dosage_override_reason		= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
							external_duplicate_override_reason	= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
							external_interaction_override_reason= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
							external_contra_override_reason		= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
							external_alergy_override_reason		= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");

							if(external_dosage_override_reason.equals("")){
								external_dosage_override_reason = (String)(((HashMap)bean.getAmendDoseRemarks()).get("1")) == null?"":(String)(((HashMap)bean.getAmendDoseRemarks()).get("1"));
								drugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",external_dosage_override_reason);
							}

							if(mode.equals("amend") && count_rx != null && Integer.parseInt(count_rx) <=1){
								current_rx = "N";
								drugDetails.put("CURRENT_RX",current_rx);
							}

							if(dosage_type!=null && dosage_type.equals("S")){
								if(!(strength_per_pres.equals(""))&& !(tot_volume.equals("")) && !(strength_per_value.equals(""))){
									if(strength_per_pres.equals(qty_value)){
										tot_volume = (Float.parseFloat(tot_volume) + Float.parseFloat(strength_per_value))+"";
									}
									else if(!(strength_per_pres.equals("")) && !(qty_value.equals("")) && !strength_per_pres.equals(qty_value)){
										tot_volume = (Math.ceil(Float.parseFloat(tot_volume) + ( (Float.parseFloat(strength_per_value) / Float.parseFloat(strength_per_pres)) * Float.parseFloat(qty_value) )))+"";
									}
								}
							}
							if( drugDetails.get("AMEND_YN")!=null && ((String)drugDetails.get("AMEND_YN")).equals("Y") ) {							
								classValue="AMENDEDDRUGS";
							}
							else{
								classValue="SELECTEDRUGS";
								if(tmp_srl_no==null) {
									tmp_srl_no	=	srl_no;
								}
							} 
							//code for drug interaction check
							drug_Interactions				= null;
							dup_drug_det					= "";
							if(perform_external_database_checks_yn.equals("Y") && !(ext_prod_id.equals("")) ){
								if(drug_db_duptherapy_yn.equals("Y")|| drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") || drug_db_dosecheck_yn.equals("Y") ){
									dosageCheckParams = null;
									if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y")){
										dosageCheckParams = new ArrayList();
										details = (HashMap)bean.getAllExistingIVOrders().get(0);
										dosage					   = (String)drugDetails.get("STRENGTH_VALUE");
										strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
										strength_per_pres_uom       = (String)drugDetails.get("STRENGTH_PER_PRES_UOM");
										if(!(dosage.equals(""))){
											if(!(strength_per_value_pres_uom.equals(""))){
											   dosage					   = (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
											}
											if(!(strength_per_pres_uom.equals(""))){
											   dosage					   = (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
											}
										}
										dosage_by				   = (String)drugDetails.get("DOSAGE_TYPE");	
										if(dosage_by.equals(""))
											dosage_by = (String)bean.getDosage_type();

//infuse over wil be same as duration in case of mfr coz flow duration is sum of the infuse over value. 
										if(details.get("INFUSE_OVER") == null || details.get("INFUSE_OVER").equals(""))
											details.put("INFUSE_OVER",(String)details.get("DURN_VALUE"));
		
										int freq	= 1;
										if( !( ((String)details.get("DURN_VALUE")).equals("") ) && !( ((String)details.get("INFUSE_OVER")).equals("") ) ){
											freq = (int)Math.ceil(Float.parseFloat((String)details.get("DURN_VALUE"))/Float.parseFloat((String)details.get("INFUSE_OVER")));
										}
										//freq = Integer.parseInt(freq)+"";
										 dose_uom = "";
										if(dosage_by.equals("S"))
											dose_uom		    =	(String)drugDetails.get("STRENGTH_UOM");         
										else if(dosage_by.equals("Q"))
											dose_uom		    =	(String)drugDetails.get("PRES_BASE_UOM");	
										repeat_value     =   (String)drugDetails.get("REPEAT_VALUE")==null?"":(String)drugDetails.get("REPEAT_VALUE");
										interval_value	=	(String)drugDetails.get("INTERVAL_VALUE")==null?"":(String)drugDetails.get("INTERVAL_VALUE");		
										route_code	= (String)drugDetails.get("ROUTE_CODE")==null?"":(String) drugDetails.get( "ROUTE_CODE" );// Added in January 2014 for CIMS dosage check -start
										qty_desc_code= (String)drugDetails.get("QTY_DESC_CODE")==null?"":(String) drugDetails.get( "QTY_DESC_CODE" );
										repeat_durn_type	= drugDetails.get("REPEAT_DURN_TYPE")==null?"":(String) drugDetails.get( "REPEAT_DURN_TYPE" );
										freq_nature	= drugDetails.get( "FREQ_NATURE" )==null?"":(String) drugDetails.get( "FREQ_NATURE" );
										freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check -end
										
										frequency	    =   "1";
										if(repeat_value != "" && interval_value != "")
											frequency = (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
										dosageCheckParams.add(patient_id);
										dosageCheckParams.add(loading_ext_prod_id);
										dosageCheckParams.add(weight);
										dosageCheckParams.add(bsa);
										dosageCheckParams.add(dosage);
										if(beanex!=null && (beanex.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
											dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
										else
											dosageCheckParams.add(dose_uom);
										dosageCheckParams.add(freq+"");
										dosageCheckParams.add("1");
										dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
										dosageCheckParams.add(repeat_durn_type);	 
										 if(freq_nature!=null && !freq_nature.equals(""))
											 freq_nature_pas =  freq_nature;
										 dosageCheckParams.add(freq_nature_pas);	
										 dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
									}
									HashMap tempDetails= null;
									HashMap drugDBCheckResult= null;
									ArrayList reqChecks = new ArrayList();
									if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y"))
										reqChecks.add("Y"); //Dosage Check 
									else
										reqChecks.add("N"); //Dosage Check 

									reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
									reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
									reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
									reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
									/*if(mode.equals("amend")){
										beanex.removeSelectedDrugonAmend(ext_prod_id);
									}*/
									startdate	= (String)drugDetails.get("START_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
									enddate		= (String)drugDetails.get("END_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
									drugDBCheckResult = beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, dosageCheckParams, "Y",startdate,enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
									if(drugDBCheckResult!=null)
										beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
									if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y")){
										drug_db_dosage_check_flag = "N";
										if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
											tempDetails = (HashMap)drugDBCheckResult.get("DOSECHECK");
											if(tempDetails != null && tempDetails.size() > 0){
												beanex.setDosageCheck(ext_prod_id, srl_no,tempDetails);
												drug_db_dosage_check_flag = "Y";
											}
										}
										if(drug_db_dosage_check_flag.equals("N")){
											tempDetails =beanex.getDosageCheck(ext_prod_id, srl_no);
											if(tempDetails != null && tempDetails.containsKey(ext_prod_id)){
												beanex.removeDosageCheck(ext_prod_id, srl_no);
											}
										}
										if(!external_dosage_override_reason.equals(""))
											drug_db_dosage_check_flag="Y";
									}
									if(drug_db_allergy_check_yn.equals("Y")){
									   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
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
										else									
											 drug_db_interact_check_flag="N";
									}

									if(drug_db_duptherapy_yn.equals("Y")){ 
									   dup_drug_det	= (String)drugDBCheckResult.get("DUPCHECK");
									   if(dup_drug_det!=null && !dup_drug_det.equals(""))
											drug_db_duptherapy_flag="Y";
									   else{
											drug_db_duptherapy_flag="N";
									   }
									}
									if(drug_db_contraind_check_yn.equals("Y")){
										if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS
											tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */

				System.err.println("----------tempDetailList"+tempDetails);
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
								/*if(drug_db_interact_check_yn.equals("Y")){
										if(loading_ext_prod_id!=null && !loading_ext_prod_id.equals("")){
											beanex.getDDInteractions(loading_ext_prod_id);//Store interactions
											drug_Interactions		= beanex.getInteractions();//get Interactions
											if(drug_Interactions.size()>0){							
												drug_db_interact_check_flag="Y";
											}
										}
									}
									if(mode.equals("amend")){
										beanex.removeSelectedDrugonAmend(ext_prod_id);
									}
									if(drug_db_duptherapy_yn.equals("Y")){ 
										if(ext_prod_id!=null&& !ext_prod_id.equals("")){
											dup_drug_det			= beanex.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result
											if(dup_drug_det!=null && (!dup_drug_det.equals(""))){
												drug_db_duptherapy_flag="Y";
											}
										}
									}

									if(drug_db_allergy_check_yn.equals("Y")){ 
										ArrayList ex_prod_ids =new ArrayList();
											ex_prod_ids.add(loading_ext_prod_id);
										if(ext_prod_id!=null&& !ext_prod_id.equals("") && ex_prod_ids!=null && !ex_prod_ids.equals("")){
											beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get allergy
											HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
											
											if(drug_alergies.containsKey(ext_prod_id)){
												drug_db_allergy_check_flag="Y";
											}	
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
												drug_db_contraind_check_flag="Y";
											}					  
										}
									} 
									
									if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y")){
										HashMap details = (HashMap)bean.getAllExistingIVOrders().get(0);
										HashMap drugDosageResult	= new HashMap();
										ArrayList dosageCheckParams = new ArrayList();
										String dosage					   = (String)drugDetails.get("STRENGTH_VALUE");
										String strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
										String strength_per_pres_uom       = (String)drugDetails.get("STRENGTH_PER_PRES_UOM");
										if(!(dosage.equals("")))
										{
											if(!(strength_per_value_pres_uom.equals("")))
											{
											   dosage					   = (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
											}
											if(!(strength_per_pres_uom.equals("")))
											{
											   dosage					   = (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
											}
										}
										String dosage_by				   = (String)drugDetails.get("DOSAGE_TYPE");	
										if(dosage_by.equals(""))
											dosage_by = (String)bean.getDosage_type();

										//infuse over wil be same as duration in case of mfr coz flow duration is sum of the infuse over value. 
										if(details.get("INFUSE_OVER") == null || details.get("INFUSE_OVER").equals(""))
											details.put("INFUSE_OVER",(String)details.get("DURN_VALUE"));
		
										int freq	= 1;
										if( !( ((String)details.get("DURN_VALUE")).equals("")   ) && !( ((String)details.get("INFUSE_OVER")).equals("")    ) )
										{
											freq = (int)Math.ceil(Float.parseFloat((String)details.get("DURN_VALUE"))/Float.parseFloat((String)details.get("INFUSE_OVER")));
										}

					//					freq = Integer.parseInt(freq)+"";
										String  dose_uom	    = "";
										if(dosage_by.equals("S"))
											dose_uom		    =	(String)drugDetails.get("STRENGTH_UOM");         
										else if(dosage_by.equals("Q"))
											dose_uom		    =	(String)drugDetails.get("PRES_BASE_UOM");	
										String repeat_value     =   (String)drugDetails.get("REPEAT_VALUE")==null?"":(String)drugDetails.get("REPEAT_VALUE");
										String interval_value	=	(String)drugDetails.get("INTERVAL_VALUE")==null?"":(String)drugDetails.get("INTERVAL_VALUE");		
										
										String frequency	    =   "1";
										if(repeat_value != "" && interval_value != "")
											frequency = (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
										dosageCheckParams.add(patient_id);
										dosageCheckParams.add(loading_ext_prod_id);
										dosageCheckParams.add(weight);
										dosageCheckParams.add(bsa);
										dosageCheckParams.add(dosage);
										dosageCheckParams.add(dose_uom);
										dosageCheckParams.add(freq+"");
										dosageCheckParams.add("1");

										//String ext_beanid   = "@ExternalProductLinkBean";
										//String ext_beanname = "ePH.ExternalProductLinkBean";
										//ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
										drugDosageResult = beanex.getDrugDosageCheck(dosageCheckParams);

										if(drugDosageResult != null && drugDosageResult.size() > 0){
											beanex.setDosageCheck(loading_ext_prod_id, srl_no,drugDosageResult);	
											drug_db_dosage_check_flag="Y";
										}
										else{
											HashMap ext_dosage_det =beanex.getDosageCheck(loading_ext_prod_id, srl_no);
											if(ext_dosage_det != null && ext_dosage_det.size()>0){
												beanex.removeDosageCheck(loading_ext_prod_id, srl_no);
											}
										}	
										if(!external_dosage_override_reason.equals(""))
											drug_db_dosage_check_flag="Y";
									}		*/						
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dosage_check_flag);
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_check_flag);
							}
							else{
								drug_db_product_id = "";
							}
							drugDetails.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
							if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
								external_database_overrided_yn = "Y";

							if(external_database_overrided_yn.equals("Y") && ((drug_db_interact_check_flag.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && external_duplicate_override_reason.equals("")) || (drug_db_contraind_check_flag.equals("Y") && external_contra_override_reason.equals("")) || (drug_db_dosage_check_flag.equals("Y") && external_dosage_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && external_alergy_override_reason.equals(""))))
								external_database_overrided_reason="N";
							else
								external_database_overrided_reason="Y";

							if(external_database_overrided_reason.equals("Y"))
								extVisble	= "hidden";

							if(drug_db_allergy_check_flag.equals("Y")){
								drugDetails.put("ALLERGY_YN","N");
								allergy_yn = "N";
							}
							if(drug_db_duptherapy_flag.equals("Y")){
								drugDetails.put("CURRENT_RX","N");
								current_rx = "N";
							}
							if(drug_db_dosage_check_flag.equals("Y"))
								drugDetails.put("LIMIT_IND","Y");						

							drugDetails.put("EXTERNAL_DATABASE_OVERRIDED_REASON",external_database_overrided_reason);
							if(mode.equals("amend")){
								extVisble	= "hidden";
								HashMap drugReasons     = new HashMap();

								drugReasons =bean.getDrugReasons(order_id,(i+2)+"",ext_prod_id);
								System.out.println("656 ivprescription drugs"+drugReasons);

								if(drugReasons != null){
								//	if(drug_db_interface_yn.equals("N") || ext_prod_id.equals("")){
										if((String)drugReasons.get("ALLERGY_OVERRIDE_REASON") != null ){ 
											allergy_override = "Y";
											//drugDetails.put("ALLERGY_REMARKS",(String)drugReasons.get("ALLERGY_OVERRIDE_REASON"));// Modified for IN:072715 commentted to fix existing bug
											if(drug_db_allergy_check_flag.equals("N")){
												allergy_yn="Y";
												drugDetails.put("ALLERGY_YN","Y");
											}else{
												allergy_yn="N";
												drugDetails.put("ALLERGY_YN","N");
												drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN",drug_db_allergy_check_flag);
												drugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",(String)drugReasons.get("ALLERGY_OVERRIDE_REASON"));
											}
										}										
										
										if((String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON") != null ){
											dose_override ="Y";		
										//	drugDetails.put("DOSE_REMARKS",(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON"));// Modified for IN:072715 commentted to fix existing bug
											drugDetails.put("LIMIT_IND","N");
										}
										else{
											dose_override ="N";	
											ext_dosage_reason=(String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");//Null Handling done for the incident num:24145 on 18/Oct/2010===By Sandhya
											drugDetails.put("LIMIT_IND","Y");
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dosage_check_flag);
											//drugDetails.put("DOSE_REMARKS",(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON"));// Modified for IN:072715 commentted to fix existing bug

										}

										if((String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON") != null){
											currentrx_override="Y";		
											
											if(drug_db_duptherapy_flag.equals("N")){
											//	drugDetails.put("CURRENTRX_REMARKS",(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON"));// Modified for IN:072715 commentted to fix existing bug
												current_rx = "Y";
												drugDetails.put("CURRENT_RX","Y");
											}else {
												drugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON"));
												drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
												current_rx = "N";
												drugDetails.put("CURRENT_RX","N");
											}
											
										}
										if((String)drugReasons.get("ABUSE_DRUG_OVERRIDE_REASON") != null){ 
											if(abuse_override_remarks.equals("")){
											drugDetails.put("abuse_override_remarks",(String)drugReasons.get("ABUSE_DRUG_OVERRIDE_REASON"));
											}
											drugDetails.put("ABUSE_OVERRIDE","Y");
										}
								//	}
									//else{
									if(drug_db_interface_yn.equals("Y") && !ext_prod_id.equals("")){

										if((String)drugReasons.get("EXTERNAL_ALERGY_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",(String)drugReasons.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
											drugDetails.put("ALLERGY_YN","Y");
											drug_db_allergy_check_flag = "Y";
										}
										if((String)drugReasons.get("EXTERNAL_DOSAGE_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",(String)drugReasons.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));
											drug_db_dosage_check_flag      = "Y";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dosage_check_flag);
											drugDetails.put("LIMIT_IND","N");
										}
										if((String)drugReasons.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",(String)drugReasons.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));
											drug_db_duptherapy_flag = "Y";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
										}
										if((String)drugReasons.get("INTERACTION_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",(String)drugReasons.get("INTERACTION_OVERRIDE_REASON"));
											drug_db_interact_check_flag = "Y";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
										}
										if((String)drugReasons.get("CONTRAIND_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON",(String)drugReasons.get("CONTRAIND_OVERRIDE_REASON"));
											drug_db_contraind_check_flag = "Y";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
										}
										if((String)drugReasons.get("CONTRAIND_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON",(String)drugReasons.get("CONTRAIND_OVERRIDE_REASON"));
											drug_db_contraind_check_flag = "Y";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
										}
										
										
										

//***********************
							
							if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
								external_database_overrided_yn = "Y";

							if(external_database_overrided_yn.equals("Y") && ((drug_db_interact_check_flag.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && external_duplicate_override_reason.equals("")) || (drug_db_contraind_check_flag.equals("Y") && external_contra_override_reason.equals("")) || (drug_db_dosage_check_flag.equals("Y") && external_dosage_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && external_alergy_override_reason.equals(""))))
								external_database_overrided_reason="N";
							else
								external_database_overrided_reason="Y";

							if(external_database_overrided_reason.equals("Y"))
								extVisble	= "hidden";

							if(drug_db_allergy_check_flag.equals("Y")){
								drugDetails.put("ALLERGY_YN","N");
								allergy_yn = "N";
							}
							if(drug_db_duptherapy_flag.equals("Y")){
								drugDetails.put("CURRENT_RX","N");
								current_rx = "N";
							}
							if(drug_db_dosage_check_flag.equals("Y"))
								drugDetails.put("LIMIT_IND","Y");	
//***********************
									}
								}

								 external_dosage_override_reason		= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	

								 external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");

								 external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
								 external_contra_override_reason		= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
								 external_alergy_override_reason		= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
								 System.out.println("in drug pageabuse_override_remarks"+abuse_override_remarks);
								// abuse_override_remarks=(String) drugDetails.get("abuse_override_remarks");

							}

							String allergy_override_gif		= "";
							String overdose_override_gif	= "";
							String currrx_override_gif		= "";
							if(sch_over_yn==null)
								sch_over_yn		=	"N";
							if(ext_prod_id==null)
								ext_prod_id		=	"";

							String tooltip					= new_generic_name+"/"+generic_name+" - "+qty_value+" "+or_qty_desc; //Modified for MMS-DM-CRF-0177
							String dispDesc					= "";
							
							//code changed to display drug name fully....on 10/5/2004
							dispDesc=drug_desc;
							if(allergy_override!=null && allergy_override.equals("N")) {
								allergy_override_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
							}
							else {
								allergy_override_gif="&nbsp;";
							}

							if(dose_override!=null && dose_override.equals("N")) {
								overdose_override_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
							}
							else {
								overdose_override_gif="&nbsp;";
							}

							if(currentrx_override!=null && currentrx_override.equals("N")) {
								currrx_override_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
							}
							else {
								currrx_override_gif="&nbsp;";
							}
							abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"N":(String)drugDetails.get("ABUSE_OVERRIDE");
							abuse_override_remarks=(String)drugDetails.get("abuse_override_remarks")==null?"":(String)drugDetails.get("abuse_override_remarks");
							
							System.out.println("815 abuse_override_remarks"+abuse_override_remarks);
							System.out.println("815 abuse_override"+abuse_override);
							
							if(abuse_override_remarks!=null && abuse_override.equals("N")){//added for aakh-crf-0140
								drug_abuse_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
							}
							else{
								drug_abuse_gif="&nbsp;";
							}
							if(!classValue.equals("AMENDEDDRUGS") && (!order_id.equals(""))){
								int srlNo = 1;
								if(srl_no != null)
									srlNo         = Integer.parseInt(srl_no);

								String orgLineNum = Integer.toString(srlNo+1);
								HashMap qtyValues =	bean.getQtyValue(patient_id,order_id,orgLineNum);
								dosage_type       = (String)qtyValues.get("dosage_type")==null?"":(String)qtyValues.get("dosage_type");
								qty_value         = (String)qtyValues.get("qty_value");
						
								drugDetails.put("DOSAGE_TYPE",dosage_type);
								drugDetails.put("QTY_VALUE",qty_value);
							}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(external_dosage_override_reason));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(external_duplicate_override_reason));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(external_interaction_override_reason));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(external_contra_override_reason));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(external_alergy_override_reason));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(abuse_override_remarks));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block30Bytes, _wl_block30);

							if(sch_over_yn.equals("Y") ) {

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(new_generic_name));
            _bw.write(_wl_block36Bytes, _wl_block36);

								if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) { // && drug_db_interface_yn.equals("Y") Added for PMG2018-COMN-CRF-0002

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);

								}

            _bw.write(_wl_block39Bytes, _wl_block39);

							}
							else {

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(new_generic_name));
            _bw.write(_wl_block36Bytes, _wl_block36);

								if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) { // && drug_db_interface_yn.equals("Y") Added for PMG2018-COMN-CRF-0002

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);

								}

            _bw.write(_wl_block39Bytes, _wl_block39);

							}
							if( Integer.parseInt(adr_count)>0){
								drug_adr_count = bean.getADRCount(patient_id,drug_code);
								if(drug_adr_count>0){

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
				
								}
								else{

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
	             
								}
							}
							if(external_database_overrided_yn.equals("Y") && !ext_prod_id.equals("") && (drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") ||drug_db_allergy_check_flag.equals("Y") ||drug_db_contraind_check_flag.equals("Y") || drug_db_dosage_check_flag.equals("Y"))){


            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_dosage_override_reason,"UTF-8")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_duplicate_override_reason,"UTF-8")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_interaction_override_reason,"UTF-8")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_contra_override_reason,"UTF-8")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name,"UTF-8")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_alergy_override_reason,"UTF-8")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_db_allergy_check_flag));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(extVisble));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);

							}
							else{


            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block56Bytes, _wl_block56);

							}								
							if(allergy_yn!=null && allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {

            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(allergy_override_gif));
            _bw.write(_wl_block60Bytes, _wl_block60);

								}
								else {

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);

								}
								if(limit_ind!=null && limit_ind.equals("N") && !drug_db_dosage_check_flag.equals("Y")) {

            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(mono_graph,"UTF-8")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dose_unit_desc1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(overdose_override_gif));
            _bw.write(_wl_block65Bytes, _wl_block65);

								}
								else {

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);

								}
								if(current_rx!=null && current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(currrx_override_gif));
            _bw.write(_wl_block60Bytes, _wl_block60);

								}
								else {

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);

								}if(abuse_exists.equals("Y") && abuse_action.equals("B") ) {//added for aakh-crf-0140

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(drug_abuse_gif));
            _bw.write(_wl_block60Bytes, _wl_block60);

								}
								else {

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);

								}
								

            _bw.write(_wl_block71Bytes, _wl_block71);

							//}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_db_allergy_check_flag));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(abuse_override_remarks ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(abuse_override ));
            _bw.write(_wl_block93Bytes, _wl_block93);

						}
					}

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf( bean.getDrugCodes() ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(tot_volume));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(bsa));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(take_home_medication));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block104Bytes, _wl_block104);

						if(!mode.equals("amend")){

            _bw.write(_wl_block105Bytes, _wl_block105);

						}
						if(tmp_srl_no!=null ) { 

            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(tmp_srl_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block107Bytes, _wl_block107);

						}

            _bw.write(_wl_block108Bytes, _wl_block108);

				}
			if(iv_prep_default.equals("1") || iv_prep_default.equals("2")){

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(ordsetDrugCodes.toString()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block110Bytes, _wl_block110);

			}

	/*		String or_bean_name			= "eOR.OrderEntryBean";
			String or_bean_id			= "@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean		= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();
			String key = orbean.getPatientId() + orbean.getEncounterId();
			java.util.HashMap previousValues	= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
			String order_catalog_code 			= orbean.getOrderCatalogCode(previousValues, "PH");*/


            _bw.write(_wl_block111Bytes, _wl_block111);
 putObjectInBean(bean_id,bean,request); 
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Additive(s).label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drugs.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllergyDrug.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ExceedDosageLimit.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateMedication.label", java.lang.String .class,"key"));
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
}
