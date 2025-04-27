package jsp_servlet._eipad._jsp._chartwidgets._recordconsent;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.ConsentOrders;
import com.ehis.persist.PersistenceHelper;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import eIPAD.chartsummary.common.response.TransactionResponse;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.healthobject.PatContext;

public final class __patientconsentlisteditorview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/recordconsent/PatientConsentListEditorView.jsp", 1709118023443L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n<script>\n\n$(document).ready(function () {\n\t\n\tenableRecordConsentTickBtn();\n\t$(\"#RecordConsentCanceBtn\").off();\n    $(\"#RecordConsentCanceBtn\").click(function() {\n    \treturnToIPListWithWarning();\n\t});\n});\n\n\n\n</script>\n\n\n<div class=\"consentListContainer\">\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n   <div class=\"consentList\">\n   \n      <div class=\"mdivTable\">\n         <div class=\"mheaderRowConsent\">\n            <div class=\"mheaderCellConsent\">\n               <div class=\"consentListItemContainer\" cellpadding = \"0\" cellspacing = \"0\"  border = \"0\">\n                  <div class=\"trIpRows1 consentListItem\" >\n                     <td class=\"tdLegendCol\" align=\"center\" valign = \"center\" style = \"width:30px;\">\n                        <div  class=\"consentListItemColCKD\" onclick=\"backToOrderList()\">\n                           <div class=\"CNButtonItemTheme\" id=\"CNActionBtnPreviewNote\"><img src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/ConsentBackward16x16.png\"/></div>\n                        </div>\n                        <div class=\"consentListItemCol2\">\n                           <div class = \"consentDetails\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n                              <div class=\"rows trIpChildRows\">\n                                 <div class=\"rowdata\" colspan = \"2\" >\n                                    <div class = \"txtRows txtRowsTheme\" style=\"color:#333b46; padding-left:0px;\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n                                       <span class = \"txtRows ptIdGender \"style=\"color:#a3a3a3;\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span>\n                                    </div>\n                                 </div>\n                              </div>\n                              <div class=\"rows trIpChildRows\">\n                                 <div class=\"rowdata\" colspan = \"2\">\n                                    <span class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =", </span>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="                                    \n                                    <span class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">Before Order Release</span>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="     \n\t\t\t\t\t\t\t\t\t<span class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">Before Order Registration</span>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="                               \n                                 </div>\n                              </div>\n                              <div class=\"rows trIpChildRows\">\n                                 <div class=\"rowdata\" >\n                                    <span class=\"lz-list-data2 lz-list-data2Theme\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\n                                 </div>\n                              </div>\n                           </div>\n                        </div>\n                  </div>\n               </div>\n            </div>\n         </div>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n         <div class=\"mheaderRowInnerContent\">\t  \n\t         <div class=\"mheaderCellInnerContent\">\n\t\t         <div style=\"width: 100%;height:100%;background-color: white;display: table;border: 1px solid #d8d8d8;box-shadow: 0px 1px 3px rgba(121,123,125,0.5);\">  \n\t\t         \t<div style=\"min-height: 300px;\" id=\"RecConsentRTE\" name=\"RecConsentRTE\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div> \n\t\t         </div>\n\t         </div>\n         </div>   \n      </div>\n      \n   </div>\n   <input type=\"hidden\" id=\"consent_form_text";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" name=\"consent_form_text";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" value=\"\"/>\n   <input type=\"hidden\" id=\"chk";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" name=\"chk";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" value=\"y\"/>\n   <input type=\"hidden\" id=\"consent_stage";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" name=\"consent_stage";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/>\n   <input type=\"hidden\" id=\"consent_form_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" name=\"consent_form_id";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n   <input type=hidden name=\'patient_name";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'patient_name";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t<input type=hidden name=\'ord_typ_code";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'ord_typ_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"/>\n\t<input type=hidden name=\'ord_status";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'ord_status";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"/>\n\t<input type=hidden name=\'ord_consent_yn";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'ord_consent_yn";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"/>\n\t<input type=hidden name=\'ord_id";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'ord_id";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"/>\n\t<input type=hidden name=\'ord_line_num";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'ord_line_num";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"/>\n\t<input type=hidden name=\'appt_reqd_yn";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'appt_reqd_yn";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"/>\n\t<input type=hidden name=\'order_pract_name";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'order_pract_name";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"/>\n\t<input type=hidden name=\'cont_order_ind";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'cont_order_ind";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"/>\n\t<input type=\"hidden\" name=\"ord_appr_by_user_id";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"ord_appr_by_user_id";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"/>\n\t<input type=\"hidden\" name=\"ord_appr_reqd_yn";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"ord_appr_reqd_yn";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"/>\n\t<input type=\"hidden\" name=\"ord_consent_by_id";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"ord_consent_by_id";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"/>\n\t<input type=\"hidden\" name=\"ord_consent_reqd_yn";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"ord_consent_reqd_yn";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"/>\n\t<input type=\"hidden\" name=\"order_catalog_code";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"order_catalog_code";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"/>\t\t\t\t\n\t<input type=hidden name=\'patientdetails";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'patientdetails";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"/>\n\t<input type=hidden name=\'order_category";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'order_category";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'/>\n\t<input type=hidden name=\'ord_catalog_desc";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'ord_catalog_desc";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'/>\n\t<input type=hidden name=\'pat_class";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'pat_class";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'/>\n\t<input type=hidden name=\'pat_id";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'pat_id";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'/>\n\t<input type=hidden name=\'priority";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'priority";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'/>\n\t<input type=hidden name=\'location_type";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'location_type";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'/>\n\t<input type=hidden name=\'location_code";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'location_code";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'/>\n\t<input type=hidden name=\'encount_id";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'encount_id";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'/>\n\t<input type=hidden name=\'ord_auth_reqd_yn";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' id=\'ord_auth_reqd_yn";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'/>\n\t<input type=hidden name=\'ord_auth_by_pract_id";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' id=\'ord_auth_by_pract_id";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'/>\n\t<input type=\"hidden\" name=\"link_ref_no";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"link_ref_no";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" value=\"\"/>\n\t<input type=\"hidden\" name=\"link_ref";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"link_ref";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" value=\"\"/>\n\t<input type=\"hidden\" name=\"link_ref_det";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"link_ref_det";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" value=\"\"/>\n\t<input type=hidden name=\'con_bo_cnt";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' id=\'con_bo_cnt";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"/>\n\t<input type=hidden name=\'con_br_cnt";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' id=\'con_br_cnt";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"/>\n\t<input type=hidden name=\'con_rbo_cnt";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' id=\'con_rbo_cnt";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"/>\n\t<input type=hidden name=\'con_rbr_cnt";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' id=\'con_rbr_cnt";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"/>\n\t\n\t<input type=\'hidden\' name=\"con_stage";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"con_stage";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"/>\n\t<input type=\'hidden\' name=\"order_set_id";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"order_set_id";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"/>\n\t\n\t<input type=hidden name=\'total_recs\' id=\'total_recs\' value=\'1\'/>\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"/>\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"/>\n\t<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"/>\n\t<input type=\"hidden\" name=\"practitioner_name\" id=\"practitioner_name\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"/>\n\t<input type=\"hidden\" name=\"security_level\" id=\"security_level\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"/>\n\t<input type=\"hidden\" name=\"curr_sys_date\" id=\"curr_sys_date\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"/>\n\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"\"/>\n\t<!--<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"\">--><!--returned frm modal window-->\n\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\n\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\n   \n\n   \n   \n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\n</div>\n\n\n<script>\n\n\twindow.addEventListener(\"orientationchange\", function() {\n\t\twindow.parent.$(\"body\").scrollTop(250);\n\t\tvar me = document.activeElement;\n\t\t$(me).contents().find(\"body\")[0].blur(); \n\t\tsetCkeContentHeight();\n\t}, true);\n\n \n \n  function initRTE(){\n\tCKEDITOR.config.toolbar = [\n\t\t{ name: \'clipboard\', items: [ \'Cut\', \'Copy\', \'Paste\', \'PasteFromWord\', \'-\', \'Undo\', \'Redo\' ] },\n\t\t{ name: \'editing\', items: [ \'SelectAll\' ] },\n\t\t{ name: \'basicstyles\', items: [ \'Bold\', \'Italic\', \'Underline\' ] },\n\t\t{ name: \'colors\', items: [ \'TextColor\', \'BGColor\' ] },\n\t\t{ name: \'paragraph\', items: [ \'NumberedList\', \'BulletedList\', \'-\', \'Outdent\', \'Indent\', \'-\',  \'JustifyLeft\', \'JustifyCenter\', \'JustifyRight\', \'JustifyBlock\' ] },\n\t\t{ name: \'styles\', items: [ \'Format\', \'FontSize\' ] },\n\t];\n\tCKEDITOR.config.resize_enabled = false;\n\tCKEDITOR.config.allowedContent = true;\n\teditor = CKEDITOR.replace(\'RecConsentRTE\', {\n\t\tremovePlugins: \'floatingspace,resize,elementspath\',\n\t\tresize_enabled: false\n\t});\n\teditor.on( \'loaded\', function( evt ) \n\t{ \t \n\t\t\t$(\".cke\").css({\"box-sizing\":\"border-box\",\"height\":\"100%\"});\n\t\t\t$(\".cke_inner\").css({\"box-sizing\":\"border-box\",\"width\":\"100%\",\"height\":\"100%\",\"display\":\"flex\",\"align-items\":\"stretch\",\"flex-direction\":\"column\"});\n   \n\t\t\t$(\".cke_top\").css({\"box-sizing\":\"border-box\",\"width\":\"100%\",\"z-index\":\"1\"});\n\t\t\t$(\".cke_contents\").css({\"box-sizing\":\"border-box\",\"width\":\"100%\",\"overflow-y\":\"hidden !important\"});\n\t\t\t$(\".cke_wysiwyg_frame\").css({\"position\":\"relative\",\"width\":\"100%\",\"height\":\"100%\"});\n\t\t\tsetCkeContentHeight();\n\t\t\t\n\t});  \n\teditor.on(\'focus\', function(){\n\t\twindow.parent.$(\"body\").scrollTop(250);\n\t});  \n}\n\ninitRTE();\nfunction setCkeContentHeight(){\n\t\t\t\t\t\t//getting window height\n\t\t\t\t\t\tvar windowHeight = parent.document.body.clientHeight;\n\t\t\t\t\t\t\n\t\t\t\t\t\t//getting cke_top top position\n\t\t\t\t\t\t//getting cke_top height\n\t\t\t\t\t\tvar EMContentTopValue =  $(\"#EMHeader\", parent.document).height();\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar ckeTopValue = $(\".cke_top\").offset().top;\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar cke_contentTop_value = EMContentTopValue + ckeTopValue + $(\".cke_top\").height();//33\n\t\t\t\t\t\t\n\t\t\t\t\t\t//getting em footer top position\n\t\t\t\t\t\tvar EMFooterLink = $(\"#EMFooter\", parent.document);\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar EMFooterHeight = EMFooterLink.height();\n\t\t\t\t\t\t\n\t\t\t\t\t\t//getting height of cke_content\n\t\t\t\t\t\tvar cke_content_height = windowHeight - cke_contentTop_value - EMFooterHeight ;\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(\".cke_contents\").css(\'height\',cke_content_height);\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(\'.cke_wysiwyg_frame\').contents().find(\'html\').css({\"overflow\":\"hidden\",\"height\":cke_content_height+\"px\"});\n\t\t\t\t\t\t$(\'.cke_wysiwyg_frame\').contents().find(\'body\').css({\"overflow\":\"auto\",\"height\":cke_content_height+\"px\"}); \n\t\t\t\t\t\t\n\n}\n</script>\n\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

String bean_id = "Or_ConsentOrders" ;
String bean_name = "eOR.ConsentOrders";
ConsentOrders bean = (ConsentOrders)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");

            _bw.write(_wl_block4Bytes, _wl_block4);

	if(patientContext!=null){
		String locale = patientContext.getLocale();
		String facility_id = (String)session.getValue("facility_id");
		String source_type = "";
		String source_code = "";
		String practitioner_id = (String)session.getValue("ca_practitioner_id");
		String priority = "";
		String ord_cat = "";
		String order_by = "P";
		String patientId = patientContext.getPatientId();
		String period_from = "";
		String period_to = "";
		int start = 1;
		int end = 500; //TODO remove this arbitrary number
		String practitioner_type = (String)session.getValue("practitioner_type");
		String speciality_code = "";
		String consentRec_order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
		
		String encounter_id = patientContext.getEncounterId();
		
		String consent_form_id = request.getParameter("consent_form_id")==null?"":request.getParameter("consent_form_id");
		String consent_form_desc = request.getParameter("consent_form_desc")==null?"":request.getParameter("consent_form_desc");
		String consent_stage = request.getParameter("consent_stage")==null?"":request.getParameter("consent_stage");
		
		ArrayList StatusDetail = new ArrayList();
		StatusDetail = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type, speciality_code, consentRec_order_id) ;
		String[] record = (String[])StatusDetail.get(0);
		if(record[2].compareTo("R")==0)
		{
			record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		}
		else if(record[2].compareTo("U")==0)
		{		 
			record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");	
		}
		else if(record[2].compareTo("S")==0)
		{
			record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
		}
		String[] multiConsentLine = new String[4];
		multiConsentLine = bean.MultiListConsentsLine((String)record[5],(String)record[25]);
		

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(multiConsentLine[1] ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(record[2] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(consent_form_desc ));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(consent_stage.equals("A")){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}else if(consent_stage.equals("R")) {
            _bw.write(_wl_block11Bytes, _wl_block11);
} 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[8] ));
            _bw.write(_wl_block13Bytes, _wl_block13);

	ArrayList ConsentFormId = null;
	ConsentFormId = bean.getFormId(consentRec_order_id,record[25],consent_form_id);
	String[] records = (String[]) ConsentFormId.get(0);
	String consentFormData = bean.getConsentDetail(records[0].trim(),"0",   records[3],   patientId, facility_id, encounter_id, consentRec_order_id) ;//set form content in the bean
	String i = "0";
	String patientdetails=record[20]+","+patientContext.getGender()+"/"+record[27]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[6];
	int consent_req_bef_order = Integer.parseInt(multiConsentLine[2]);
	int consent_req_bef_regn = Integer.parseInt(multiConsentLine[3]);
	String mode = "1";
	String practitioner_name = (String)session.getValue("practitioner_name");
	String security_level = (String)session.getValue("security_level");
	if(security_level == null)
		security_level  = "1";
	String curr_sys_date=com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);


            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(consentFormData ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(consent_stage));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(consent_form_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[20]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[12]));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[13]));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[17]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[26]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[21]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[14]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(record[16]));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(record[15]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(record[18]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(record[17]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(record[24]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patientdetails));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[9]));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[23]));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(consent_req_bef_order));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(consent_req_bef_regn));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(consent_req_bef_order));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(consent_req_bef_regn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(consent_stage));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.checkForNull(record[28],"")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf( practitioner_id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf( practitioner_name));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(security_level));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(curr_sys_date));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block101Bytes, _wl_block101);
            _bw.write(_wl_block102Bytes, _wl_block102);
            _bw.write(_wl_block102Bytes, _wl_block102);
            _bw.write(_wl_block103Bytes, _wl_block103);
            _bw.write(_wl_block102Bytes, _wl_block102);
            _bw.write(_wl_block104Bytes, _wl_block104);

	}

            _bw.write(_wl_block105Bytes, _wl_block105);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
}
