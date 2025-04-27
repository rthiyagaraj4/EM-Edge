package jsp_servlet._eipad._jsp._chartwidgets._recordconsent;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.recordconsent.healthobject.RecordConsentFieldItem;
import eIPAD.chartsummary.recordconsent.response.RecordConsentFieldResponse;
import eIPAD.chartsummary.recordconsent.bc.RecordConsentBC;
import eOR.ConsentOrders;
import com.ehis.persist.PersistenceHelper;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.healthobject.PatContext;

public final class __patientconsentlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/recordconsent/PatientConsentList.jsp", 1709118023240L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n\n<script>\n\n$( document ).ready(function() {      \n        initConsentListScroller();\t \n     var singleItem= $(\"#singleItem\").val();\n\t\t\n\t\tif(singleItem==\"true\"){\n\t\t\t\n\t\t\t  $(\"#ConsentFormSelPopup\").show();\n\t\t\tshowMez(\'ConsentFormSelPopup\');\t \n\t\t}\n\t \n\t\n        $(\"#RecordConsentCanceBtn\").off();\n        $(\"#RecordConsentCanceBtn\").click(function() {\n        \treturnToIPList();\n    \t});\n        disableButtonId(\'RecordConsentTickBtn\');\n});\n\n\nvar consentListScroll;\nfunction initConsentListScroller() {\n\tconsentListScroll = new IScroll(\'#ConsentMainWrapper\', { \n\t\tscrollX: false, \n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true,\n\t\tclick: true\n\t});\n}\n\n\n</script>\n\t<div class=\"consentListContainer\">\n\t\t<div class=\"consentList\">\n\t\t\t<div id=\"ConsentMainWrapper\" class=\"ConsentMainWrapper\" data-role=\"none\">\n\t\t\t\t<div class=\"ConsentMainscroller\" class=\"ConsentMainscroller\" data-role=\"none\">\t\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<!-- Each Consent item STARTS -->\n   \t\t\t\t\t<div class=\"consentListItemContainer\" cellpadding = \"0\" cellspacing = \"0\"  border = \"0\">\n        \t\t\t\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t\t\t\t                \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t<div class=\"trIpRows1 consentListItem\" style=\"margin-bottom:5px;\" onclick=\"editConsentForm(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\">\n           \t\t\t\t\t<!-- <td class=\"tdLegendCol\" align=\"center\" valign = \"center\" style = \"width:30px;\"> -->\n           \t\t\t\t\t<div  class=\"consentListItemCol1\">\n              \t\t\t\t\t<div class = \"\" ><img src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/consentIcon30x30.png\"/></div>\n           \t\t\t\t\t</div>\n           \t\t\t\t\t<div class=\"consentListItemCol2\">\n\t\t\t\t\t             <div class = \"consentDetails\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t<div class=\"rows trIpChildRows\">\n\t\t\t\t\t                \t<div class=\"rowdata\" colspan = \"2\" >\n\t\t\t\t\t                          <div class = \"txtRows txtRowsTheme\" style=\"color:#333b46; padding-left:0px;\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t                          \t<span class = \"txtRows ptIdGender \"style=\"color:#a3a3a3;\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t\t\t                          </div>\n\t\t\t\t\t                    </div>\n\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t\t\t<div class=\"rows trIpChildRows\">\n\t\t\t\t                         <div class=\"rowdata\" colspan = \"2\">\t\t\t\t                        \n\t\t\t\t                          \t<span class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =",</span>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">\n\t\t\t\t                          \t\tBefore Order Release\n\t\t\t\t                          \t</span>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n                  \t\t\t\t\t\t\t<span class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">\n\t\t\t\t                          \t\tBefore Order Registration\n\t\t\t\t                          \t</span>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"rows trIpChildRows\">\n\t\t\t\t\t                    <div class=\"rowdata\" >\n\t\t\t\t\t                     \t<span class=\"lz-list-data2 lz-list-data2Theme\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</span>\n\t\t\t\t\t                   </div>\n\t\t\t\t\t                </div>\n\t\t\t\t\t             </div>\n           \t\t\t\t\t</div>\n        \t\t\t\t</div>\t\t\t\t                          \t\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span>\n\t\t\t\t\t                          </div>\n\t\t\t\t\t                    </div>\n\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t\t\t<div class=\"rows trIpChildRows\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"rowdata\" colspan = \"2\">\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span>\n\t\t\t\t\t                   </div>\n\t\t\t\t\t                </div>\n\t\t\t\t\t             </div>\n           \t\t\t\t\t</div>\n        \t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<div class=\"trIpRows1 consentListItem\" style=\"margin-bottom:5px;\" onclick=\"showConsentSelPop(this)\" data-order_index=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' data-comp=\'5\'  data-consent_seq=\'1\' data-order-catalog=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' data-order_id=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' data-order_line_num=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' data-stage-catalog=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n           \t\t\t\t\t<!-- <td class=\"tdLegendCol\" align=\"center\" valign = \"center\" style = \"width:30px;\"> -->\n           \t\t\t\t\t<div  class=\"consentListItemCol1\">\n              \t\t\t\t\t<div class = \"\" ><img src=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</span>\n\t\t\t\t\t                          </div>\n\t\t\t\t\t                    </div>\n\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t\t\t<div class=\"rows trIpChildRows\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"rowdata\" colspan = \"2\"  \n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\ndata-stage-catalog=\'A\'\n\t\t\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\ndata-stage-catalog=\'R\'\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t>\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">Choose consent form <img src=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="/eIPAD/images/AddConsent16x16.PNG\" style=\"vertical-align:middle\" title=\"Add button\"></img>,</span>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tvar index=0;\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tvar consent_seq=\"1\";\n\t\t\t\t\t\t\t\t\t\t\tvar order_catalog=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\';\n\t\t\t\t\t\t\t\t\t\t\tvar order_id=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\';\n\t\t\t\t\t\t\t\t\t\t\tvar order_line_num=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\n    $(\"#currentCode\").val(order_catalog);\n\t$(\"#currentOrderId\").val(order_id);\n\t$(\"#currentLineNum\").val(order_line_num);\n\t$(\"#currentSeq\").val(consent_seq);\n\t$(\"#currentindex\").val(index);\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\t\t\t\t\t\t\t\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<script>\n$(\"#currentstage\").val(\"A\");\n</script>\n\t\t\t\t\t\t\t\t\t\t\t<span data-stage-catalog=\'A\' class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">\n\t\t\t\t                          \t\tBefore Order Release\n\t\t\t\t                          \t</span>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n      \n<script>\n$(\"#currentstage\").val(\"R\");\n</script>\n\t  <span  data-stage-catalog=\'R\' class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">\n\t\t\t\t                          \t\tBefore Order Registration\n\t\t\t\t                          \t</span>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</span>\n\t\t\t\t\t                   </div>\n\t\t\t\t\t                </div>\n\t\t\t\t\t             </div>\n           \t\t\t\t\t</div>\n        \t\t\t\t</div>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t                \n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="        \t\t\t\t<div class=\"trIpRows1 consentListItem\" style=\"margin-bottom:5px;\">\n           \t\t\t\t\t<!-- <td class=\"tdLegendCol\" align=\"center\" valign = \"center\" style = \"width:30px;\"> -->\n           \t\t\t\t\t<div  class=\"consentListItemCol1\">\n              \t\t\t\t\t<div class = \"\" ><img src=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</span>\n\t\t\t\t\t                          </div>\n\t\t\t\t\t                    </div>\n\t\t\t\t\t                </div>\n\t\t\t\t\t                <div class=\"rows trIpChildRows\">\n\t\t\t\t\t                    <div class=\"rowdata\" >\n\t\t\t\t\t                     \t<span class=\"lz-list-data2 lz-list-data2Theme\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</span>\n\t\t\t\t\t                   </div>\n\t\t\t\t\t                </div>\n\t\t\t\t\t             </div>\n           \t\t\t\t\t</div>\n        \t\t\t\t</div>\n        \t\t\t\t<!-- MultiConsent Table STARTS -->\n\t\t\t\t\t\t<div class=\"trIpRows1 consentListItem\" style=\"margin-bottom:5px\">\n           \t\t\t\t\t<!-- <td class=\"tdLegendCol\" align=\"center\" valign = \"center\" style = \"width:30px;\"> -->\n           \t\t\t\t\t<div  class=\"consentListItemCol1\">\n              \t\t\t\t\t<div class = \"\"  style=\"width:100px;\"></div>\n           \t\t\t\t\t</div>\n           \t\t\t\t\t<div class=\"consentListItemCol2\" style=\"width:100%\">\n\t\t\t\t\t\t\t\t<div class=\"contentInsideTable\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row;width: 100%;\">\n        \t\t\t\t\t\t\t\t<div style=\"display: table-cell;\">\n        \t\t\t\t\t\t\t\t\t<div class=\"consentListTab\">\n        \t\t\t\t\t\t\t\t\t\t<div class=\"consentListRow\">\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="        \t\t\t\t\t\t\t\t\t\t\n        \t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListCol\">Before Order Release</div>\n        \t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListCol consentListColBoder\">Before Order Registration</div>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListCol\">Before Order Release</div>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListCol\">Before Order Registration</div>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="        \t\t\t\n    \t\t\t\t\t\t\t\t\t\t\n        \t\t\t\t\t\t\t\t\t\t</div>\n        \t\t\t\t\t\t\t\t\t</div>\n        \t\t\t\t\n        \t\t\t\t\t\t\t\t</div>\n        \t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n        \t\t\t\t\t\t\t<div style=\"display:table-row;width: 100%;\">\n        \t\t\t\t\t\t\t\t<div style=\"display: table-cell;\">\n        \t\t\t\t\t\t\t\t\t<div class=\"consentListTab\">\n        \t\t\t\t\t\t\t\t\t\t<div class=\"consentListRow\">\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent\" data-order_index=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" data-consent_form_id=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" data-consent_seq=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" onclick=\"editConsentForm(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\')\">\n        \t\t\t\t\t\t\t\t\t\t\t\t<div onclick=\"\" data-consent-id=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' data-order-catalog=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="/eIPAD/images/EditForm_18x18.png\" style=\"vertical-align:middle;padding-left:10px;\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n        \t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent\" data-consent_seq=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n        \t\t\t\t\t\t\t\t\t\t\t\t<div onclick=\"\"  data-consent-id=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' data-consent-id=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="/eIPAD/images/ConsentComplete_18x18.png\" style=\"vertical-align:middle;padding-left:10px;\" title=\"dbltickButton\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n        \t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent\">\n        \t\t\t\t\t\t\t\t\t\t\t\t<div onclick=\"showConsentSelPop(this)\"  data-order_index=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'  data-comp=\'3\' data-stage-catalog=\'A\'  data-consent_seq=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' data-consent_seq=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =">Choose consent form\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="/eIPAD/images/AddConsent16x16.PNG\" style=\"vertical-align:middle;padding-left:10px;\" title=\"Add button\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent\">\n        \t\t\t\t\t\t\t\t\t\t\t\t\n        \t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent consentListColBoder\" data-order_index=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent consentListColBoder\" data-consent_seq=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n        \t\t\t\t\t\t\t\t\t\t\t\t<div onclick=\"\" data-consent-id=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent consentListColBoder\" data-consent_seq=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n        \t\t\t\t\t\t\t\t\t\t\t\t<div onclick=\"showConsentSelPop(this)\" data-order_index=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'  data-comp=\'2\' data-stage-catalog=\'R\' data-consent_seq=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'data-order-catalog=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>Choose consent form\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent consentListColBoder\">\n        \t\t\t\t\t\t\t\t\t\t\t\t\n        \t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div onclick=\"\" data-consent-id=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="/eIPAD/images/EditForm_18x18.png\" style=\"vertical-align:middle;padding-left:10px;\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent\" data-consent_seq=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div onclick=\"\"  data-consent-id=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="/eIPAD/images/ConsentComplete_18x18.png\" title=\"dbltickButton\" style=\"vertical-align:middle;padding-left:10px;\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent\" data-consent_seq=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'  data-comp=\'1\' data-stage-catalog=\'A\' data-consent_seq=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent\" data-order_index=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'  data-order-catalog=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"consentListColContent\" data-consent_seq=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="/eIPAD/images/ConsentComplete_18x18.png\" style=\"vertical-align:middle;padding-left:10px;\" title=\"dbltickButton\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' data-comp=\'4\' data-stage-catalog=\'R\' data-consent_seq=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="        \t\t\t\t\t\t\t\t\t\t\t\n        \t\t\t\t\t\t\t\t\t\t</div>\n        \t\t\t\t\t\t\t\t\t</div>\n        \t\t\t\t\t\t\t\t</div>\n        \t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="        \t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n           \t\t\t\t\t</div>\n        \t\t\t\t</div>\n        \t\t\t\t<!-- MultiConsent Table ENDS -->\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="        \t\t\t\t\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" id=\"consentOrderItem";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" name=\"consentOrderItem";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" \n\t\t\t\t\t\tdata-order_catalog_code=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"\n\t\t\t\t\t\tdata-order_id=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"\n\t\t\t\t\t\tdata-order_line_num=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"\n\t\t\t\t\t\tdata-consent_form_list=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"\n\t\t\t\t\t\tdata-recd_consent_id=\"\"\n\t\t\t\t\t\tdata-chk=\"Y\"\n\t\t\t\t\t\tdata-consent_form_id=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"\n\t\t\t\t\t\tdata-consent_stage=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"\n\t\t\t\t\t\tdata-noteligible_consent_id=\"\"\n\t\t\t\t\t\tdata-patient_name=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"\n\t\t\t\t\t\tdata-ord_typ_code=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"\n\t\t\t\t\t\tdata-ord_status=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"\n\t\t\t\t\t\tdata-ord_consent_yn=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"\n\t\t\t\t\t\tdata-ord_id=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"\n\t\t\t\t\t\tdata-ord_line_num=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"\n\t\t\t\t\t\tdata-appt_reqd_yn=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"\n\t\t\t\t\t\tdata-order_pract_name=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"\n\t\t\t\t\t\tdata-ord_appr_by_user_id=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"\n\t\t\t\t\t\tdata-ord_appr_reqd_yn=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"\n\t\t\t\t\t\tdata-ord_consent_by_id=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"\n\t\t\t\t\t\tdata-ord_consent_reqd_yn=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"\n\t\t\t\t\t\tdata-order_catalog_code=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"\n\t\t\t\t\t\tdata-patientdetails=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"\n\t\t\t\t\t\tdata-order_category=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"\n\t\t\t\t\t\tdata-ord_catalog_desc=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"\n\t\t\t\t\t\tdata-pat_class=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"\n\t\t\t\t\t\tdata-pat_id=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"\n\t\t\t\t\t\tdata-priority=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"\n\t\t\t\t\t\tdata-location_type=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"\n\t\t\t\t\t\tdata-location_code=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\"\n\t\t\t\t\t\tdata-encount_id=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\"\n\t\t\t\t\t\tdata-ord_auth_reqd_yn=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"\n\t\t\t\t\t\tdata-ord_auth_by_pract_id=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"\n\t\t\t\t\t\tdata-link_ref_no=\"\"\n\t\t\t\t\t\tdata-link_ref=\"\"\n\t\t\t\t\t\tdata-link_ref_det=\"\"\n\t\t\t\t\t\tdata-con_bo_cnt=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"\n\t\t\t\t\t\tdata-con_br_cnt=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"\n\t\t\t\t\t\tdata-con_rbo_cnt=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"\n\t\t\t\t\t\tdata-con_rbr_cnt=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"\n\t\t\t\t\t\tdata-con_id=\"\"\n\t\t\t\t\t\tdata-con_stage=\"\"\n\t\t\t\t\t\tdata-order_set_id=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"\n\t\t\t\t\t\tdata-consent_seq=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"\n\t\t\t\t\t\t/>\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t<input type=hidden name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\t\t\t<input type=hidden name=\'singleItem\' id=\'singleItem\' id=\'singleItem\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"1\">\n\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t<input type=\"hidden\" name=\"security_level\" id=\"security_level\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"curr_sys_date\" id=\"curr_sys_date\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t<!--<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"\">--><!--returned frm modal window-->\n\t\t\t<input type=\"hidden\" name=\"source_type\" id=\"source_type\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"source_code\" id=\"source_code\" value=\"\">\n\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"\">\t\n\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t<div class=\"consentListItemContainer\"> No Pending Consents for this patient</div>\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\t\t\t\t\t\n\n\t\n   \t\t\t\t</div>\t\n   \t\t\t</div>\t\t\t\t\n\t<!--  legend scroll portion ends-->\t\n\t\t</div>\n\t</div>\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
String SingleVariable=request.getParameter("SingleVariable")==null?"false":request.getParameter("SingleVariable");
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
	ArrayList StatusDetail = new ArrayList();
	String period_from = "";
	String period_to = "";
	int start = 1;
	int end = 500; //TODO remove this arbitrary number
	String practitioner_type = (String)session.getValue("practitioner_type");
	String speciality_code = "";
	String consentRec_order_id = "";
	
	String order_catalog_code;
	String order_catalog_desc;
	String order_id;
	String order_line_num;
	
	int consent_req_bef_order;
	int consent_req_bef_regn;
	String consent_stage = "";
	int total_consents;
	
	StatusDetail = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type, speciality_code, consentRec_order_id) ;
	ArrayList multiConsentList = new ArrayList();
	ArrayList multiNonAssConsentList = new ArrayList();
	String[] multiConsentDtls = null;
	String[] multiConsentLine = null;
	
	if(StatusDetail.size()>0){
		for(int k=0;k<StatusDetail.size();k++){
			int consent_seq = 1;
			String[] record = (String[])StatusDetail.get(k);
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
			
			order_catalog_code	=(String)record[24];
			order_id = (String)record[5];
			order_line_num = (String)record[25];
			multiConsentLine = new String[4];
			multiConsentLine = bean.MultiListConsentsLine((String)record[5],(String)record[25]);
			consent_req_bef_order = Integer.parseInt(multiConsentLine[2]);
			consent_req_bef_regn = Integer.parseInt(multiConsentLine[3]);
			total_consents = consent_req_bef_order + consent_req_bef_regn;
			order_catalog_desc = (String) multiConsentLine[1];
			
			multiConsentDtls = bean.MultiListDtls(order_catalog_code, practitioner_id);
			multiConsentList = null;
			if(multiConsentDtls[0].equals("F"))
			{
				multiConsentList = bean.multiConsentDraftValues(order_catalog_code,order_id,order_line_num);
			}
			if(multiConsentList==null || multiConsentList.size()==0)
			{
				multiConsentList = bean.MultiListConsentsForNew(order_catalog_code,order_id,order_line_num, practitioner_id);
			}
			boolean singleCol = false;
			int noOfRows = 0;
			/* multiConsentList	 = bean.MultiListConsentsdtl(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);
			if(multiConsentList.size()==0)
			{
				multiConsentList	 = bean.MultiListConsents(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);
			} */
			//multiNonAssConsentList = bean.MultiListConsentsNotAssociated(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);	
			
			

            _bw.write(_wl_block5Bytes, _wl_block5);

			if(total_consents==1){
				consent_seq++;
				if(consent_req_bef_order == 1){
					consent_stage ="A";
				}else if(consent_req_bef_regn == 1){
					consent_stage ="R";
				}

            _bw.write(_wl_block6Bytes, _wl_block6);

				if(multiConsentDtls[0].equals("F") && !multiConsentDtls[5].equals("") && !multiConsentDtls[3].equals("")){
				

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(k));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentDtls[3] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentDtls[5] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(consent_stage));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(order_catalog_desc ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(record[2] ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(multiConsentDtls[5] ));
            _bw.write(_wl_block13Bytes, _wl_block13);

				if(consent_req_bef_order == 1){

            _bw.write(_wl_block14Bytes, _wl_block14);

				}else if(consent_req_bef_regn == 1){

            _bw.write(_wl_block15Bytes, _wl_block15);

				}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(record[8] ));
            _bw.write(_wl_block17Bytes, _wl_block17);

			}else{
				if(multiConsentList.size()>0){
					String[] singleVariableConsent = (String[])multiConsentList.get(0);
					

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(k));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(singleVariableConsent[1] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(singleVariableConsent[2] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(consent_stage));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(order_catalog_desc ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(record[2] ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(singleVariableConsent[2] ));
            _bw.write(_wl_block13Bytes, _wl_block13);

				if(consent_req_bef_order == 1){

            _bw.write(_wl_block14Bytes, _wl_block14);

				}else if(consent_req_bef_regn == 1){

            _bw.write(_wl_block15Bytes, _wl_block15);

				}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(record[8] ));
            _bw.write(_wl_block19Bytes, _wl_block19);
			
				}
				else{

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(consent_stage));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(order_catalog_desc ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(record[2] ));
            _bw.write(_wl_block26Bytes, _wl_block26);

				if(consent_req_bef_order == 1){
					

            _bw.write(_wl_block27Bytes, _wl_block27);

				}else if(consent_req_bef_regn == 1){

            _bw.write(_wl_block28Bytes, _wl_block28);

				}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(SingleVariable.equals("true")) { 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block34Bytes, _wl_block34);

				}

            _bw.write(_wl_block35Bytes, _wl_block35);

				if(consent_req_bef_order == 1){

            _bw.write(_wl_block36Bytes, _wl_block36);

				}else if(consent_req_bef_regn == 1){

            _bw.write(_wl_block37Bytes, _wl_block37);

				}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(record[8] ));
            _bw.write(_wl_block38Bytes, _wl_block38);
					
				}
			}

            _bw.write(_wl_block39Bytes, _wl_block39);

			}

            _bw.write(_wl_block40Bytes, _wl_block40);

			if(total_consents>1){
				

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(order_catalog_desc ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(record[2] ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(record[8] ));
            _bw.write(_wl_block43Bytes, _wl_block43);

				if(consent_req_bef_order>=1 && consent_req_bef_regn>=1){
					noOfRows = consent_req_bef_order>consent_req_bef_regn?consent_req_bef_order:consent_req_bef_regn;

            _bw.write(_wl_block44Bytes, _wl_block44);

				}else if(consent_req_bef_order>1){
					singleCol = true;
					noOfRows = consent_req_bef_order;

            _bw.write(_wl_block45Bytes, _wl_block45);

				}else if(consent_req_bef_regn>1){
					singleCol = true;
					noOfRows = consent_req_bef_regn;

            _bw.write(_wl_block46Bytes, _wl_block46);

				}

            _bw.write(_wl_block47Bytes, _wl_block47);

				ArrayList befRelConsentList = new ArrayList();
				ArrayList befRegConsentList = new ArrayList();
				for(int i=0;i<multiConsentList.size();i++){
					//befRelConsentList = new ArrayList();
					//befRegConsentList = new ArrayList();
					String[] multiConsentValues = (String[])multiConsentList.get(i);
					if(multiConsentValues[3].equals("A"))
						befRelConsentList.add(multiConsentValues);
					if(multiConsentValues[3].equals("R"))
						befRegConsentList.add(multiConsentValues);
				}
				
				for(int i=0;i<noOfRows;i++){
					

            _bw.write(_wl_block48Bytes, _wl_block48);

					if(!singleCol){
						if(i < consent_req_bef_order){
							//consent_seq++;
							String[] multiConsentValues;
							if(befRelConsentList.size()>i){
								multiConsentValues = (String[])befRelConsentList.get(i);
							}else{
								multiConsentValues = null;
							}
							if(multiConsentValues!=null){
								if(multiConsentValues[10].equals("N")){
									consent_seq++;

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(k));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(k));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[1] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block57Bytes, _wl_block57);

								}else{
									consent_seq++;

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block61Bytes, _wl_block61);
								
								}
							}else{

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(k));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block66Bytes, _wl_block66);
								
							}
						}else{

            _bw.write(_wl_block67Bytes, _wl_block67);
							
						}
						
						if(i < consent_req_bef_regn){
							//consent_seq++;
							String[] multiConsentValues;
							if(befRegConsentList.size()>i){
								multiConsentValues = (String[])befRegConsentList.get(i);
							}else{
								multiConsentValues = null;
							}
							if(multiConsentValues!=null){
								if(multiConsentValues[10].equals("N")){
									consent_seq++;

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(k));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(k));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[1] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block57Bytes, _wl_block57);

								}else{
									consent_seq++;

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block61Bytes, _wl_block61);
								
								}
							}else{

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(k));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block66Bytes, _wl_block66);
								
							}
						}else{

            _bw.write(_wl_block77Bytes, _wl_block77);
							
						}
					}else{
						//consent_seq++;
						if(i < consent_req_bef_order){
							String[] multiConsentValues;
							if(befRelConsentList.size()>i){
								multiConsentValues = (String[])befRelConsentList.get(i);
							}else{
								multiConsentValues = null;
							}
							if(multiConsentValues!=null){
								if(multiConsentValues[10].equals("N")){
									consent_seq++;

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(k));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(k));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[1] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block79Bytes, _wl_block79);

								}else{
									consent_seq++;

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block82Bytes, _wl_block82);
								
								}
								
							}
							else{

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(k));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block66Bytes, _wl_block66);
								
							}
						}else if(i < consent_req_bef_regn){
							//consent_seq++;
							String[] multiConsentValues;
							if(befRegConsentList.size()>i){
								multiConsentValues = (String[])befRegConsentList.get(i);
							}else{
								multiConsentValues = null;
							}
							if(multiConsentValues!=null){
								if(multiConsentValues[10].equals("N")){
									consent_seq++;

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(k));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(k));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[1] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block79Bytes, _wl_block79);

								}else{
									consent_seq++;

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(multiConsentValues[2] ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block88Bytes, _wl_block88);
								
								}					
							}
							else{

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(k));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(consent_seq ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block66Bytes, _wl_block66);
								
							}
						}	
					}

            _bw.write(_wl_block90Bytes, _wl_block90);

				}

            _bw.write(_wl_block91Bytes, _wl_block91);

			}

            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(k));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(k));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(multiConsentDtls[0]));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(multiConsentDtls[3]));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(multiConsentDtls[4]));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(record[20]));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(record[12]));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(record[13]));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(record[17]));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(record[26]));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(record[21]));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(record[16]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[15]));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(record[18]));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(record[17]));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(record[24]));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(record[20]+","+patientContext.getGender()+"/"+record[27]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[6]));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(record[9]));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(record[23]));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(consent_req_bef_order));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(consent_req_bef_regn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(consent_req_bef_order));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(consent_req_bef_regn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(record[28]));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(consent_seq));
            _bw.write(_wl_block130Bytes, _wl_block130);

		}

            _bw.write(_wl_block131Bytes, _wl_block131);
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(StatusDetail.size()));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(SingleVariable));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf( practitioner_id));
            _bw.write(_wl_block138Bytes, _wl_block138);
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale)));
            _bw.write(_wl_block140Bytes, _wl_block140);
            _bw.write(_wl_block131Bytes, _wl_block131);
            _bw.write(_wl_block131Bytes, _wl_block131);
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block138Bytes, _wl_block138);
            _bw.write(_wl_block142Bytes, _wl_block142);

	}else{

            _bw.write(_wl_block143Bytes, _wl_block143);
	
	}
}else{
	out.println("No Patient Selected");
}


            _bw.write(_wl_block144Bytes, _wl_block144);

PersistenceHelper.putObjectInBean(bean_id,bean,request);



            _bw.write(_wl_block145Bytes, _wl_block145);
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
