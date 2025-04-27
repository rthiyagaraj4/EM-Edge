package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.net.URLDecoder;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eCommon.Common.*;
import javax.servlet.http.HttpSession;
import com.ehis.persist.PersistenceHelper;
import ePH.IVPrescriptionBean;
import eOR.OrderEntryBean;
import ePH.DrugInterfaceControlBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pharmcrxdetailsview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/pharmCrxDetailsView.jsp", 1709118020865L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/js/pharmCrxDetailsView.js\"></script> \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t<script>clearFrequencyList();</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t\t\t\t\n                    <script>\n\t\t\t\t\taddFrequencyListCrx(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');\n\t\t\t\t\t</script>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>defaultFreq(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\');</script>\n                    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<div data-role = \"none\"  class = \"blurPopup\" onclick=\"\" data-popid=\"\" style=\"z-index:10000\"></div>\n<form id=\"formCRXPrescriptionDetails\" name=\"formCRXPrescriptionDetails\" id=\"formCRXPrescriptionDetails\" method = \"post\" action = \"\" class=\"ChartSummaryFormElem\">\t\t\n\t<div class=\"ChartSummaryBlockVar\" id=\"rxDetailsSummaryBlock\" data-role = \"none\">\n\t\t<div class=\"ChartSummaryMainTable\" data-role = \"none\">\n\t\t\t\t<div data-role = \"none\" class =\"ChartSummaryPageHeader\">\n               \t\t<div class=\"ChartSummaryHeaderCell\" data-role = \"none\">\n                  \t\t<div class=\"ChartSummaryHeaderCont\" data-role = \"none\">\n                     \t\t<div class=\"ChartSummaryHeaderTable ChartSummaryHeaderTableTheme\" data-role = \"none\">\n                        \t\t<div class=\"ChartSummaryHeaderRow\" data-role = \"none\">\n                           \t\t\t<div class=\"ChartSummaryHeaderTextCol\" data-role = \"none\">\n                              \t\t\t<div class=\"ChartSummaryHeaderText ChartSummaryHeaderTextTheme\" data-role = \"none\">CRx</div>\n                           \t\t\t</div>\n                           \t\t\t<div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n                              \t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"completeCRxDetailsConfirm()\"><img src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/images/CS_Ok16x16.png\"></div>\n                           \t\t\t</div>\n\t\t                           <div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n\t\t                              <div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"closeCrxDetailsView()\"><img src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/images/CS_Close16x16.png\"></div>\n\t\t                           </div>\n                       \t \t\t</div>\n                     \t\t</div>\n                  \t\t</div>\n               \t\t</div>\n            \t</div>\n\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageContent ChartSummaryPageContentTheme\" >\n\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageContentCell\">\n\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryMainWrapper pharmDataMainWrapper\" >\n\t\t\t\t\t\t\t<div class=\"ChartSummaryMainScroller pharmDataContentScroller\"  data-role = \"none\">\t\t\t\t\t \t\t\t\t\t \n\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:100%;\" data-role = \"none\">\t\n\t\t\t\t\t\t\t\t\t<div  class=\"row crxDetailsViewHeaderRowWrapper\" data-role = \"none\">\n\t\t\t                            <div class=\"table ivHeaderWrapper\" style=\"width:100%;height:25%;\">\n\t\t\t\t\t\t\t\t\t        <div class=\"row fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t        <div class=\"cell ivHeaderWrapperContent\">\n\t\t\t\t\t\t\t\t\t\t\t\t    <div  class=\"drugDetailsTab segoeuiBold\" id=\"CRxDrugTab\"  onclick=\"openDrugDetailsTab()\">Drug Details</div> <!--to handle in jquery-->\n\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"adminDetailsTab segoeuiBold\" id=\"CRxAdminTab\" onclick=\"openAdminDetailsTab()\">Administration Details</div>\n\t\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t                                </div>                                      \n\t\t\t                            </div>\n\t                           \t\t</div>\n\t\t\t\t\t\t\t\t\t\n\t<!-- Drug details  tab -->\t\t\t\t\t\t\t\t\n\t<div id=\"CRxDrug\" class=\"row\" style=\"width:100%;height: 85%;background-color:#f5f9fc;\" >\n        <div class=\"table\" style=\"width:100%;height:100%;\">    \n\t\t    <div class=\"row\" style=\"height:10%;width: 100%;\">\n\t\t        <div class=\"row IVrxLabel segoeuiBold paddingBottom5px\" style=\"padding-left:5px;display:block;\">\n\t\t            Prescribing  by\n\t\t\t\t</div>\t \n\t\t\t\t<div class=\"row ivrxSubTabs\" style=\"background-color: #f5f9fc;\">\n\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:100%;\">\n                        <div class=\"ivrxTabsContainer\" style=\"margin-top:0;\">\t\t\t\t\t\t\t\t\n                            <div class=\"radioTabs\" id=\"CRxStrength\">\n\t\t\t\t\t\t\t\t<div class=\"table radioTabsTable\">\n\t\t\t\t\t\t\t\t    <div class=\"row\">\n\t\t\t\t\t\t\t\t\t    <div class=\"cell radioTabsCell\">\n\t\t\t\t\t\t\t\t\t\t    <div id=\"CRxStrengthOption\" class=\"ivrxTabs ivrxTabsOnActive\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n                                    <div class=\"row\">\n\t\t\t\t\t\t\t\t\t    <div  id=\"CRxStrengthLabel\" class=\"cell ivrxDescription ivrxTabsDescOnActive\">\n\t\t\t\t\t\t\t\t\t\t     Strength\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div class=\"radioTabs\" id=\"CRxRatio\">\n\t\t\t\t\t\t\t\t<div class=\"table radioTabsTable\">\n\t\t\t\t\t\t\t\t    <div class=\"row\">\n\t\t\t\t\t\t\t\t\t    <div class=\"cell radioTabsCell\">\n\t\t\t\t\t\t\t\t\t\t    <div id=\"CRxRatioOption\" class=\"ivrxTabs\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n                                    <div class=\"row\">\n\t\t\t\t\t\t\t\t\t    <div  id=\"CRxRatioLabel\" class=\"cell ivrxDescription\">\n\t\t\t\t\t\t\t\t\t\t  Ratio\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n                            <div class=\"radioTabs\" id=\"CRxPercentage\">\n\t\t\t\t\t\t\t\t<div class=\"table radioTabsTable\">\n\t\t\t\t\t\t\t\t    <div class=\"row\">\n\t\t\t\t\t\t\t\t\t    <div class=\"cell radioTabsCell\">\n\t\t\t\t\t\t\t\t\t\t    <div id=\"CRxPercentOption\" class=\"ivrxTabs\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n                                    <div class=\"row\">\n\t\t\t\t\t\t\t\t\t    <div id=\"CRxPercentLabel\" class=\"cell ivrxDescription\">\n\t\t\t\t\t\t\t\t\t\t  Percentage %\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n                </div>\n\t\t\t</div>\t\t\t\t\t\n                <!-- Strength -->\t                      \t\t\t\t\t\t\t\t\t \n\t\t\t\t<div id=\"CRx_strength\" class=\"row ivrxDetailsViewContentRowWrapper\"  data-role = \"none\">\n\t\t\t\t\t<div class=\"detailsViewMainWrapper\">\t\n                        ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<div id=\"CRx_strength_Inner\" >\n\t\t\t\t\t\t\t    <div class=\"CRxBannerIndWrapper\" style=\"\">\n\t\t\t\t\t\t\t\t\t<div style=\"height:auto;width:100%\">\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"CRxBannerContent\" >\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"ivrxDrugHeader segoeuiBold\">\n\t\t\t\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"pharmRxOrderStrength\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pharmRxOrderItemDesc\">\n\t\t\t                                    ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t                                    <label class=\"pharmRxOrderItemLabel\">Strength : </label>\n                                                <span class=\"pharmRxOrderItemInfo segoeuiBold\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span>\t \n                                                ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \n\t\t\t                                    <label class=\"pharmRxOrderItemLabel\">Form : </label>\n\t\t\t                                    <span class=\"pharmRxOrderItemInfo segoeuiBold\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"current_qty_S";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" name=\"current_qty_S";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t                                </div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"CRxBannerIconsWrap\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"pharmRxOrderItemIconsVRalign\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/eIPAD/images/externalDatabase25X25.png\" class=\"imgBannerIndicator\"></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span name=\"\" class=\"pharmRxOrderItemIconsVRalign\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/beyondDoseLimit25X25.png\" class=\"imgBannerIndicator\"></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span name=\"\" class=\"pharmRxOrderItemIconsVRalign\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="/eIPAD/images/duplicateDrug25X25.png\" class=\"imgBannerIndicator\"></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span  class=\"pharmRxOrderItemIconsVRalign\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="/eIPAD/images/pharmAllergy25X25.png\" class=\"imgBannerIndicator\"></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"CRxBannerContent\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"IVrxLabel segoeuiBold paddingBottom5px\" style=\"padding-top:10px;\">Quantity<font class=\"rxMandatorIndi\">*</font></div>\n\t\t\t\t\t\t\t\t\t\t\t<input id=\"strengthQty_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" type=\"text\" class=\"k-textbox\" style=\"height:43px;width:99%;\"  size=\"6\" maxlength=\"6\" onblur=\"calculateOrderQuantiyInStrengthMode(";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =")\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"pharHtWtTextboxDurnUnit\"id=\"strengthQty_UOM_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t    </div>\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t \n\t\t\t\t\t\t\t    <div class=\"detailsViewWrapper detailsViewWrapBorder\" style=\"\">\n\t\t\t\t\t\t\t\t   <div id=\"dynamicContentWrapper\" style=\"padding-bottom:15px;padding-top:0px;\" class=\"paddingLeftRight10px ivWithAddDynamicContentWrapperCss onOrientationChangeDynamicWrapper\">\t\t\t\n                                                ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"textareaWrapper\" id=\"crxDrugIndication\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Drug indications\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea  id=\"txtDrugIndi_S";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" class=\"k-textbox\" maxlength=\"255\" style=\"height:57px;width:99%;\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n                                                ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n                                                <div class=\"textareaWrapper\" id=\"crxDrugRemarks_Strength\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Remarks\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea  id=\"drugRemTextarea_S";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" class=\"k-textbox\"maxlength=\"40\" style=\"height:57px;width:100%;\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>   \t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"textareaWrapper\" id=\"crxDuplicateDrugOverride\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Duplicate drug override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t \t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea id=\"txtDuplicateDrug_S";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"  value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" class=\"k-textbox\" maxlength=\"255\" style=\"height:57px;width:99%;\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"DuplicateDrug_S";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n                                                ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"DuplicateDrug_S";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="    \t\t\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"textareaWrapper\" id=\"crxAllergyOverride\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Allergy override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                 </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t         <textarea id=\"txtAllergyOverride_S";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t     </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"AllergyOverride_S";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"AllergyOverride_S";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"textareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Beyond dosage limit override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea id=\"txtBeyondDosage_S";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"  class=\"k-textbox\"  maxlength=\"255\" style=\"height:57px;width:99%;\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t     </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"BeyondDosage_S";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"BeyondDosage_S";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<input type=\"hidden\" id=\"drug_code_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" name=\"drug_code_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"\t value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" id=\"drug_name";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" name=\"drug_name";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_class";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"drug_class";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_prod_id";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"external_prod_id";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"Perform_ext_db_checks_YN";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"Perform_ext_db_checks_YN";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" value=\"N\">\n\t\t\t\t\t\t<input type=\"hidden\" id=\"strength";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" name=\"strength";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\"\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" id=\"strengthDesc_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" name=\"strengthDesc_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"strength_uom";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"strength_uom";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"\tvalue=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"strength_uom_need";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"strength_uom_need";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"\tvalue=\"\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"generic_id";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"generic_id";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"generic_name";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"generic_name";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"\tvalue=\"\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_base_uom";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"pres_base_uom";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"\tid=\"pres_base_uom";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_base_uom_need";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"pres_base_uom_need";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" value=\"\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"equvalentUOM_conversion_value";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"equvalentUOM_conversion_value";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"equvalentUOM_conversion_factor";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"equvalentUOM_conversion_factor";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"contentInPresBaseUOM";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"contentInPresBaseUOM";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"orderQty";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" id=\"orderQty";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"orderQtyUOM";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"orderQtyUOM";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"strength_uom_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"strength_uom_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" value=\"\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\t\n\t\t                \n\t\t            </div>\n                </div>\t\t\t\t\t\n\t            <!-- Strength ends -->\n\t\t\t\t<!-- Ratio -->\n               \t<div id=\"CRx_ratio\" style=\"display:none;\" class=\"row ivrxDetailsViewContentRowWrapper\"  data-role = \"none\">\t\t\t\t\t\n\t\t\t\t\t<div class=\"detailsViewMainWrapper\">\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t    <div id=\"CRx_ratio_inner\">\t\n\t\t\t\t\t\t\t<div class=\"finalProdSection\" style=\"\">\n\t\t\t\t\t\t\t\t\t<div class=\"finalProdContent\" style=\"\" >\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"IVrxLabel segoeuiBold fullHtHalfWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<span>Required final product quantity</span><font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>\t  \n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"width:50%;\" >\n\t\t\t\t\t\t\t\t\t\t\t <div style=\"width: 49%;display:inline-block;\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"ivrxWithAddDrugUnit k-textbox\" style=\"width:100%;height:43px;\"  id=\"final_prod_qty\" onblur=\"percentageRatioCalculation(\'o\',\'NX\',\'R\')\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"  maxlength=\"3\"/>\n\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"width: 49%;display:inline-block;\">\n\t\t\t\t\t\t\t\t\t\t\t\t <div  class=\"interDurationTime\">\n\t\t\t\t\t\t\t\t\t             \n\t                                            <select style=\"width:100%;\" id=\"req_qty_UOM\" onChange=\"validateUOMRatioPercent(\'R\',this)\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t                                              </div>\n\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t    <div class=\"detailsViewMainWrapper\">\n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\t\n\t\t\t\t\t\t\t    <div class=\"CRxBannerIndWrapper\" style=\"\">\n\t\t\t\t\t\t\t\t\t<div style=\"height:auto;width:100%\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"CRxBannerContent\" >\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"ivrxDrugHeader segoeuiBold\">\n\t\t\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell pharmRxOrderStrength\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pharmRxOrderItemDesc\">\n\t\t\t                                    ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"current_qty_R";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" name=\"current_qty_R";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"CRxBannerContent\">\n\t\t\t\t\t\t\t\t\t\t  <div style=\"display:flex;\">\n\t\t\t\t\t\t\t\t\t\t   <div style=\"width:33%;padding-right:5px;\">\n\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\" style=\"padding-top:5px;\">Ratio<font class=\"rxMandatorIndi\">*</font></div>\n\t\t\t\t\t\t\t\t\t\t\t <input type=\"text\" class=\"k-textbox\" id=\"ratio_value_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" style=\"height:43px;width:100%;\" maxlength=\"2\" onblur=\"percentageRatioCalculation(\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\',\'PR\',\'R\')\"/>\n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t   <div style=\"width:33%;padding-right:5px;\">\n\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\" style=\"padding-top:5px;\">Req qty</div>\n\t\t\t\t\t\t\t\t\t\t\t <input  type=\"text\" class=\"k-textbox k-state-disabled\" id=\"ratio_req_qty_";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" style=\"height:43px;width:100%;\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" readonly></input>\n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t   <div style=\"width:33%;padding-right:5px;\">\n\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\"  style=\"padding-top:5px;\">Derived qty</div>\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"interInputWrap\">\n\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"pharContentKgLabel fullWidth\">\n\t\t\t\t\t\t\t\t\t\t\t       <input type=\"text\" class=\"k-textbox k-state-disabled\" id=\"ratio_derived_qty_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" readonly></input>\n\t\t\t\t\t\t\t\t\t\t\t       <div class=\"pharHtWtTextboxUnit\" style=\"right:2%\" id=\"ratioQty_UOM_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t      </div>\n\t\t\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t    </div>\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t \n\t\t\t\t\t\t\t    <div class=\"detailsViewWrapper detailsViewWrapBorder\">\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div id=\"dynamicContentWrapper\" style=\"padding-bottom:15px;padding-top:0px;display:inline-block;\" class=\"paddingLeftRight10px  onOrientationChangeDynamicWrapper\">\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"textareaWrapper\" id=\"crxDrugIndication\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Drug indications\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea  id=\"txtDrugIndi_R";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" > ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" \t\t\t\t\t\t\t\t\t\t\t\t\n                                                <div class=\"textareaWrapper\" id=\"crxDrugRemarks_Ratio\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Remarks\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea id=\"drugRemTextarea_R";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" class=\"k-textbox\" maxlength=\"40\" style=\"height:57px;width:100%;\">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"textareaWrapper\" id=\"crxDuplicateDrugOverride\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Duplicate drug override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea id=\"txtDuplicateDrug_R";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"DuplicateDrug_R";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"DuplicateDrug_R";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="    \t\t\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"textareaWrapper\" id=\"crxAllergyOverride\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Allergy override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                 </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t         <textarea id=\"txtAllergyOverride_R";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"  class=\"k-textbox\" maxlength=\"255\" style=\"height:57px;width:99%;\">";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t     </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"AllergyOverride_R";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"AllergyOverride_R";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"textareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Beyond dosage limit override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea id=\"txtBeyondDosage_R";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"   value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" class=\"k-textbox\"  maxlength=\"255\" style=\"height:57px;width:99%;\">";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t     </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"BeyondDosage_R";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"BeyondDosage_R";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t                        </div> \n\t\t\t\t\t    </div>\t\n\t\t\t\t    </div>\n                </div>\t\t\t\t\t\n\t\t\t\t\n                <!-- Ratio ends-->\t\t\t\t\n\t\t        <!-- Percentage begins-->\n\t\t\t\t<div id=\"CRx_Percentage\" style=\"display:none;\" class=\"row ivrxDetailsViewContentRowWrapper\"  data-role = \"none\">\t\n\t\t\t\t\t<div class=\"detailsViewMainWrapper\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t\t<div id=\"CRx_Percentage_inner\">\t\n\t\t\t\t\t    <div class=\"finalProdSection\">\n\t\t\t\t\t\t\t\t<div class=\"finalProdContent\">\n\t\t\t\t\t\t\t\t   <div class=\"IVrxLabel segoeuiBold fullHtHalfWt\" >\n\t\t\t\t\t\t\t\t      <span>Required final product quantity</span><font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div style=\"width:50%;\" >\n\t\t\t\t\t\t\t\t   <div style=\"width: 49%;display:inline-block;\" >\n\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"ivrxWithAddDrugUnit k-textbox\" name=\"final_prod_qty_P\" id=\"final_prod_qty_P\" id=\"final_prod_qty_P\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" onblur=\"percentageRatioCalculation(\'o\',\'NX\',\'P\')\"  size=5 maxlength=3 style=\"width:100%;height:43px;\"/>\n\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t   <div style=\"width: 49%;display:inline-block;\">\n\t\t\t\t\t\t\t\t\t  <div  class=\"interDurationTime\">\n\t                                      <select name=final_prod_qty_uom id=\"final_prod_qty_uom\" style=\"width:100%;\" onchange=\"validateUOMRatioPercent(\'P\',this)\">\n\t                                      \t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t                                      </select>\n                                     </div>\n\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"detailsViewMainWrapper\">\n                            ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t    <div class=\"CRxBannerIndWrapper\" style=\"\">\n\t\t\t\t\t\t\t\t\t<div style=\"height:auto;width:100%\">\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"CRxBannerContent\" >\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:flex;\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:84%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxDrugHeader segoeuiBold\"> ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =" </div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell pharmRxOrderStrength\">\n\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"pharmRxOrderItemDesc\">\n \t\t\t                                            ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t                                            <label class=\"pharmRxOrderItemLabel\">Strength : </label>\n\t\t\t                                            <span class=\"pharmRxOrderItemInfo segoeuiBold\">";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</span>\t \n\t\t\t                                            ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" \n\t\t\t                                            <label class=\"pharmRxOrderItemInfo\">Form : </label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"pharmRxOrderItemInfo segoeuiBold\">";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"current_qty_P";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" name=\"current_qty_P";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t                                          </div>\n\t\t\t                                    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"CRxBannerIconsWrap\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"CRxBaseCheckWrap\">\n\t\t\t\t\t\t\t\t\t\t\t<span style=\"display:inline-block;width:45%;float:right;\"><input style=\"height: 20px;width: 20px;vertical-align: text-top;\" type=\"checkbox\" ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 =" name=\'baseDrug";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' id=\'baseDrug";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' onclick=\"selectBaseDrug(this)\"></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span  class=\"pharmRxOrderItemLabel IVrxLabel\" style=\"display:inline-block;vertical-align: middle;height: 15px;width:45%;color: #65696f;float:right;padding-top:3px;\">Base</span>\t\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"CRxBannerContent\" >\n\t\t\t\t\t\t\t\t\t\t\t <div style=\"display:flex;\">\n\t\t\t\t\t\t\t\t\t\t   <div style=\"width:33%;padding-right:5px;\">\n\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\" style=\"padding-top:5px;\">Percentage<font class=\"rxMandatorIndi\">*</font></div>\n\t\t\t\t\t\t\t\t\t\t\t  <input type=\"text\" class=\"k-textbox\" style=\"height:43px;width:100%;\" ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =" name=\"percent_ratio";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" size=2 id=\"percent_ratio";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"  onKeyPress=\"return percentageRatioValidation(this)\" onblur=\"percentageRatioCalculation(\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\',\'PR\',\'P\')\"></input>\n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t   <div style=\"width:33%;padding-right:5px;\">\n\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\" style=\"padding-top:5px;\"> Req qty</div>\n\t\t\t\t\t\t\t\t\t\t\t  <input type=\"text\" class=\"k-textbox\" style=\"height:43px;width:100%;\" name=\"req_qty_p";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" id=\"req_qty_p";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" size=1  maxlength=\"6\" id=\"req_qty_p";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" readonly ></input>\n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t   <div style=\"width:33%;padding-right:5px;\">\n\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\" style=\"padding-top:5px;\" >Derived qty</div>\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"interInputWrap\">\n\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"pharContentKgLabel fullWidth\">\n\t\t\t\t\t\t\t\t\t\t\t       <input type=\"text\" class=\"k-textbox\" style=\"height:43px;width:100%;\" name=\"derived_qty_p";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" id=\"derived_qty_p";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"  id=\"derived_qty_p";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" size=\"3\" maxlength=\"6\" readonly ></input>\n\t\t\t\t\t\t\t\t\t\t\t       <div class=\"pharHtWtTextboxUnit\" style=\"right:2%\" id=\"stock_display_unit_P";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" name=\"stock_display_unit_P";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t      </div>\n\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t    </div>\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t \n\t\t\t\t\t\t\t    <div class=\"detailsViewWrapper detailsViewWrapBorder\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"dynamicContentWrapper\" style=\"padding-bottom:15px;padding-top:0px;display:inline-block;\" class=\"paddingLeftRight10px  onOrientationChangeDynamicWrapper\">\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"textareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Drug indications\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea id=\"txtDrugIndi_P";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n                                                    <div class=\"textareaWrapper\" id=\"crxDrugRemarks_Percent\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Remarks\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea id=\"drugRemTextarea_P";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"textareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Duplicate drug override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea id=\"txtDuplicateDrug_P";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"DuplicateDrug_P";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"DuplicateDrug_P";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"textareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Allergy override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                 </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t         <textarea id=\"txtAllergyOverride_P";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"AllergyOverride_P";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"AllergyOverride_P";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"textareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Beyond dosage limit override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea id=\"txtBeyondDosage_P";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"BeyondDosage_P";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"BeyondDosage_P";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t                    ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n                    </div>\t\t\t\t\t\n\t\t\t\t<!-- Percentage ends-->\t\n                </div>\n\t\t<!-- Pharmacy legend starts --> <div id=\"CRxAddLegend\"></div><!-- Pharmacy legend ends --> \t\t\t\t\t\t\t\n\t    </div>\n\t</div>\n    <!-- Admin Details Tab Starts -->\n\t<div id=\"CRxAdmin\" class=\"row\" style=\"height:85%;width:100%;background-color:#f5f9fc;\" data-role = \"none\">\t\n\t    <div class=\"detailsViewMainWrapper\" >\t\t\t\t\t\n\t\t\t<div class=\"fullWidth\">\t   \t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t<div style=\"display:flex;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t<div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingTopBottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t   Dosage<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t <div id=\"\" class=\"table ivInterDoseDetailsWrapper\" style=\"width:100%;\">\n\t                                           <div  class=\"row fullWtHalfHt\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\" style=\"\">\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"ivrxWithAddInfuseRateUnit k-textbox\" name=\"dosage_value\" id=\"dosage_value\" id=\"dosage_value\" size=\"1\" maxlength=\"3\" onblur=\"dosageChange(this);\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" style=\"height:43px;width:98%;\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"pharHtWtTextboxUnit\" name=\"dosage_uom_display\" style=\"right:14px;\"></div>   \n\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell detailsCell\">\t\t\t\t\t\t\t\t\t\t\t\t      \n\t\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"dropDown\" style=\"width:100%;height:36px;\">\n\t                                                    <select style=\"width: 100%\" id=\"dosageUOM\" name=\"uom\" id=\"uom\">\n\t                                                       <!-- %= DosageInfo % -->\n\t                                                    </select>\n\t                                                  </div>\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\n\t\t\t\t    </div> \n\t\t\t\t<div style=\"width:0.2%;\">\n\t\t\t\t</div>\n\t\t\t\t<div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingTopBottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t   Frequency<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t                                      \n                                                <select  style=\"width:99% ! important;height:43px;\"  id=\"freq_value_crx\" class=\"ivrxDosageByCss k-textbox\">\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t    </select>\t\t\t\t\t\t\t\t\t\t\t\t\n\t              </div>\t \t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t    <div style=\"display:flex;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t  <div class=\"IVrxLabel segoeuiBold\" style=\"padding-top:10px;padding-bottom:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t   Duration<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseDetailsWrapper\" class=\"table interDurationRepeat\">\n\t                                               <div id=\"doseInput\" class=\"row fullWtHalfHt\">\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"k-textbox ivRxWithAddInfuseOverInput\" style=\"height:43px;width:98%;\" id =\"duration_details\" name=\"duration_details\" id=\"duration_details\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" onblur=\"validateDuration()\" maxlength=\"2\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell detailsCell\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t   <select class=\"ivRxWithAddInfuseOverInput k-textbox\" style=\"height:43px;width:99%;\" id=\"durn_desc_crx\" name=\"durn_desc_crx\" id=\"durn_desc_crx\">\n\t                                                   </select> \n\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div> \n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:flex;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"IVrxLabel segoeuiBold paddingTopBottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t   Start date and time<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n                                                <input style=\"width:99% ! important\" class=\"dropDown\" id=\"crxStartDate\" value=\"\" />\n\t\t\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t  <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingTopBottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t   End date and time<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<input style=\"width:99% ! important\" class=\"dropDown ivrxDosageByCss\" id=\"crxEndDate\" value=\"\" disabled/>\n\t\t\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"interTextareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\" style=\"padding-left:10px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 3px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tBuild MAR\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"interInputWrap\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"buildMAR_yn\" id=\"buildMAR_yn\" style=\"height: 20px;width: 20px;\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" ";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 =" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \t\t\n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"interTextareaWrapper\" >\n\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\" style=\"padding-left:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 4px;\">\n\t\t\t\t\t\t\t\t\t\t\t           Admixture\n\t\t\t\t\t\t\t\t\t\t\t         </div>\n\t\t\t\t\t\t\t\t\t\t\t         <div class=\"interInputWrap\" >\n                                                       <input style=\"height: 20px;width: 20px;\" name=\"Admixture\" id=\"Admixture\" type=\"checkbox\" checked=\"yes\" disabled=\"true\"/>\n                                                     </div> \n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t        </div>\n\t    </div>\t\n\t</div>           \n\t<!-- Admin Details Tab Ends -->\n    <!-- CRx details footer -->\t\t\n\t<div style=\"height:40px;width:100%;position:absolute;bottom:0;\" class=\"row\" >\t\n\t\t\t\t\t<div class=\"table\" style=\"height:100%;width:100%\">\n\t\t\t\t\t\t\t\t <div  class=\"row pharmCartBottomContainer\" style=\"height:1%;\" data-role = \"none\">\n\t\t\t                         <div class=\"cell billingBottomBorder\" style=\"background-color:#ffffff;\" data-role = \"none\"></div>\n\t\t\t                     </div>\n\t\t\t                     <div  class=\"row pharmItemDescNameCell\" style=\" height: calc(100% - 94%);line-height: 35px;background-color:#ffffff;\" data-role = \"none\">\n\t\t\t                          <div class=\"cell pharmRxOrderFooterCell\"  data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"pharmRxOrderItemDesc\">\n\t\t\t                                    <div class=\"pharmRxOrderItemLabelFooter\">Dispense Location : </div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width: 2px;height:1px;\" class=\"pharmRxOrderItemInfoFooter\"></div>\n\t\t\t                                    <div class=\"pharmRxOrderItemInfoFooter segoeuiBold\">";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="</div>\n\t\t\t                                 </div>\n\t\t\t                           </div>\n\t\t\t\t\t\t\t\t\t  <div class=\"cell pharmRxOrderFooterCell\" id=\"total_ratio\" style=\"display: none\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t      <div class=\"pharmRxOrderItemDescFooter\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"pharmRxOrderItemLabelFooter\">Ratio:</div> \n\t\t\t                                <div style=\"width: 2px;height:1px;\" class=\"pharmRxOrderItemInfoFooter\"></div>\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"total_ratio_display\" class=\"pharmRxOrderItemInfoFooter segoeuiBold\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t                              </div>\n\t\t\t\t\t\t\t\t\t  </div> \n\t\t\t                          <div class=\"cell pharmRxOrderFooter\" id=\"total_qty\" style=\"display: none\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t      <div class=\"pharmRxOrderItemDescFooter\">\n\t\t\t                                 <div class=\"pharmRxOrderItemLabelFooter\">Total quantity:</div>\n\t\t\t\t\t\t\t\t\t\t\t <div style=\"width:2px;height:1px\" class=\"pharmRxOrderItemInfoFooter\"></div>\n\t\t\t                                 <div id=\"total_qty_display\" class=\"pharmRxOrderItemInfoFooter segoeuiBold\">\n\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t                          </div>\n\t\t\t\t\t\t\t\t\t  <div class=\"cell pharmRxOrderFooter\" id=\"total_qty_percent\" style=\"display: none\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t      <div class=\"pharmRxOrderItemDescFooter\">\n\t\t\t                                 <div class=\"pharmRxOrderItemLabelFooter\">Total quantity:</div>\n\t\t\t\t\t\t\t\t\t\t\t <div style=\"width:2px;height:1px\" class=\"pharmRxOrderItemInfoFooter\"></div>\n\t\t\t                                 <div id=\"total_qty_percent_display\" class=\"pharmRxOrderItemInfoFooter segoeuiBold\">\n\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t                          </div>\n\t\t\t           \t\t     </div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t<!-- CRx details footer ends -->\t\n    </div>\t\n\t</div>\t\t\t\t\t\t\n\t</div>\n\t</div>\n\t</div>\n    </div> \t\n        \t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"\t\t\tname=\"bean_id_CRX\" id=\"bean_id_CRX\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"\t\t\tname=\"DosageValue\" id=\"DosageValue\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"\t\t\tname=\"DosageText\" id=\"DosageText\"/>\n\t\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\"        name=\"bean_name_CRX\" id=\"bean_name_CRX\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\"     name=\"start_date_fluid\" id=\"start_date_fluid\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\"       name=\"end_date_fluid\" id=\"end_date_fluid\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\"            name=\"END_DATES\" id=\"END_DATES\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\"          name=\"START_DATES\" id=\"START_DATES\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\"           name=\"durn_value\" id=\"durn_value\" />\n\t\t<input type=\"hidden\" value=\"\"                          name=\"calcualted_durn_value\" id=\"calcualted_durn_value\"\t\t>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\"       name=\"interval_value\">\n\t\t<input type=\"hidden\" value=\"\"                          name=\"interval_value\" id=\"interval_value\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\"          name=\"freq_nature\"   id=\"freq_nature\"/>\n\t\t<input type=\"hidden\" value=\"\"                          name=\"durn_type\" id=\"durn_type\" id=\"durn_type\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\"    name=\"repeat_durn_type\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\"         name=\"scheduled_yn\"\t/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" name=\"drug_db_interface_yn\"/>\n\t\t<input type=\"hidden\" value=\"\"                          name=\"dosage_detail\" id=\"dosage_detail\" id=\"dosage_detail\"/>\n\t\t<input type=\"hidden\" value=\"\"                          name=\"back_date\" id=\"back_date\" />\n\t\t<input type=\"hidden\" value=\"\"                          name=\"future_date\" id=\"future_date\"/>\n\t\t\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\tvalue=\"new\">\n\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\t\tvalue=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n\t\t<input type=\"hidden\" name=\"act_patient_class\" id=\"act_patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\"> \n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">\n\t\t<input type=\"hidden\" name=\"resp_id\" id=\"resp_id\"\t\t        value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\n\t\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\"\t\t    value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n\t\t<input type=\"hidden\" name=\"result_factor\" id=\"result_factor\"\tid=\"result_factor\"\t    value=\"\">\n\t\t<input type=\"hidden\" name=\"prescribingBy\" id=\"prescribingBy\"\t\tvalue=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" name=\"allDrugs\" id=\"allDrugs\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" name=\"allDrugs_count\" id=\"allDrugs_count\"/>\n\t\t<input type=\"hidden\" name=\"current_freq_code\" id=\"current_freq_code\"\t  id=\"current_freq_code\"\t    value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n\t\t<input type=\"hidden\" name=\"current_dosage_uom\" id=\"current_dosage_uom\"\t  id=\"current_dosage_uom\"    value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n\t\t\n\t\t<input type=\"hidden\" name=\"current_drun_code\" id=\"current_drun_code\"\t  id=\"current_drun_code\"\t    value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n\t\t<input type=\"hidden\" name=\"current_start\" id=\"current_start\"\t  id=\"current_start\"\t    value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n\t\t<input type=\"hidden\" name=\"current_end\" id=\"current_end\"\t  id=\"current_end\"\t    value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\n\t\t\n\t\t<div class=\"CSTransactionMessage\" id=\"transactionMsg1\" style=\"background-color:#bd362f;bottom: 45px; left: 10px; display: none;z-index:900002;\">\n\t\t\t\t<img style=\"padding-left:15px;vertical-align:middle;\" src=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="/eIPAD/images/PopError.png\" onclick=\"closeToast()\"/>\n\t\t\t\t<span class=\"rxToastmsg\" id=\"contentRxToastMsg1\">No records found</span>\n\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"transactionMessageContent1\"></div>\n\t\t</div>\t\t\t\n\t\t<div id=\"confirmMsg\" class=\"absoluteCenter\" style=\"z-index: 10005;\">\n\t\t\t<div class=\"Error_Window\">\n\t\t\t\t<div class=\"Error_msg_box\">\n\t\t\t\t<div class=\"Error_msg\">\n\t\t\t\t\t<div class=\"Error_msg_Frame\">\n\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t<div class=\"Error_icon\"><img src=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="/eIPAD/images/OrderPopConfirm.png\" width=\"30\" height=\"30\"> </div>\n\t\t\t\t\t\t\t<div class=\"Error_cont\" id=\"ClinicalNotesConfirmDialogMsg\">Are you sure you wish to cancel the current operation?</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t<div class=\"Error_msg_btn\">\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"okClick\" onclick=\"okClickDialog()\">OK </div>\n\t\t\t\t<div class=\"Error_btn_div\"> </div>\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"cancelClick\" onclick=\"cancelClickDialog()\" data-value=\"true\">Cancel </div>\n\t\t\t</div>\n\t\t\t<div class=\"top_shadow\"> </div>\n\t\t\t</div>\n\t\t</div>\n\t\t\n        \t\t\n    </form>\n   \n</div>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Locale appLocale;
	if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
	else 
	appLocale = new Locale("en");
	ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
	
	String PRES_BY_BASE="";
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext");	
	String facility_id = patientContext.getFacilityId();
	String patient_id = patientContext.getPatientId();
	String patient_class = patientContext.getPatientClass();
	String act_patient_class =  request.getParameter("act_patient_class");
	String encounter_id = patientContext.getEncounterId();
	String resp_id = patientContext.getResponsibilityID();
	String pract_id = patientContext.getClinicianId();
	String location_code = patientContext.getLocationCode();
	String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
	String param_bean_name					= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean		= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
	
	String bean_id_CRX			= "@IVPrescriptionBean_CRX"+ patient_id + encounter_id;
	String bean_name_CRX	= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean_CRX	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_CRX, bean_name_CRX, request);
	
	String ex_bean_id   = "@ExternalProductLinkBean";
	String ex_bean_name = "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
	HashMap drug_data=new HashMap();
	
	
	/* Calculate Dispense Location */
	String bean_id_eph			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name_eph		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id_eph,bean_name_eph,request);
	bean.setLanguageId(locale);

	String location_type_eph		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code_eph		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String take_home_medication     = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	String priority				    = request.getParameter("priority")==null?"":request.getParameter("priority");
	String dflt_disp_locn	        = "";
	String iv_prep_yn		        = "6";	
	
	//bean.setTakeHomeMedication(take_home_medication);
	ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type_eph,location_code_eph,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
	
	if(ord_disp_location != null & ord_disp_location.size()>0){ 
			dflt_disp_locn	= (String)ord_disp_location.get(2)==null?"":(String)ord_disp_location.get(2);			
		}
	
	/* Dispende Location Ends */
	
	String drug_db_interface_yn				=	param_bean.getDrugDBInterface_yn(facility_id);  
	String drug_db_dose_check_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
	String drug_db_duptherapy_yn			=   param_bean.getDrugDBDuptherapy_yn(facility_id);
	String drug_db_interact_check_yn		=   param_bean.getDrugDBInteract_check_yn(facility_id);
	String drug_db_contraind_check_yn		=   param_bean.getDrugDBContraind_check_yn(facility_id);
	String drug_db_allergy_check_yn			=   param_bean.getDrugDBAllergy_check_yn(facility_id);
	String drug_db_product_id		  		=	param_bean.getDrugDBProductID(facility_id);
	
	bean_CRX.setLanguageId("en");
	bean_CRX.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
	bean_CRX.setDrug_DB_Product_id(drug_db_product_id);
	bean_CRX.setExternalDosageYN(drug_db_dose_check_yn);
	/* drug details tab - field validations */
	
	HashMap drug_detail =	null;	
	
	ArrayList	presDetails	= (ArrayList) bean_CRX.getDrugDetails();	
	HashMap drugDetails			= (HashMap)presDetails.get(0);
	
	ArrayList AllUOMs = bean_CRX.getAllUOMs();	/* required quantity dropdown */
	
	String durn_values            = "";
	String durn_type            = "";
	String start            = "";
	String end            = "";	
	String  dosage_value = "";
	String  dosage_UOM = "";
	String freq_codes = "";	
	
	String drugDescription="";
	String strengthValue="";
	String strengthDesc="";
	String formDesc="";
	String drugCode="";
	String strengthOrder_qty="",strengthQty_UOM="",ratioQty_UOM="";
	String allergyOverride="",drugOverride="",dosagelimitOverride="",drugIndication="";
	String freq_code="",freq_nature="";
	String drug_code_crx="";
	String durn_value="";
	String buildMAR_yn="",buildMAR_ynCheck="",buildMAR_ynEnable="",buildMAR_rule="";
	String repeat_durn_type="",interval_value="",calcualted_durn_value="",scheduled_yn="";
	String total_ratio,total_ratio_qty="",total_percent_qty="";
	String allDrugs="";
    	String DosageInfo="",final_prod_qty_uom="",pres_base_uom_value="";
	String DosageValue="",DosageText="";
	int allDrugs_count = 0;
	
	String start_date_fluid = bean_CRX.getSysdate();
	String end_date_fluid	=  bean_CRX.populateEndDate(start_date_fluid,"24","H");
	
	
	for(int uomsize=0;uomsize<AllUOMs.size();uomsize+=2){
		//System.out.println("allUOMS"+AllUOMs.get(uomsize+1));
		//String requiredQTY = (String)AllUOMs.get(uomsize+1);
		final_prod_qty_uom=final_prod_qty_uom + "<option  value='"+AllUOMs.get(uomsize)+"'>"+AllUOMs.get(uomsize+1)+"</option>";
    }
	
	
	/* populateDate */
	String  START_DATES = (String)drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE");	
	String  END_DATES  =	(String)drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE");
	
	
	/* populateFrequency */
	drug_code_crx = (String)drugDetails.get("FREQ_CODE")==null?"":(String)drugDetails.get("FREQ_CODE");

		ArrayList freqValues	=  (ArrayList) bean_CRX.loadFrequency();  	        
			if(freqValues!=null && freqValues.size()>0){
					
            _bw.write(_wl_block5Bytes, _wl_block5);

					for (int i=0;i<freqValues.size();i+=2){
					
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf((String)freqValues.get(i)));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf((String)freqValues.get(i+1)));
            _bw.write(_wl_block8Bytes, _wl_block8);

					}
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(drug_code_crx));
            _bw.write(_wl_block10Bytes, _wl_block10);
			
			}
			
	/* setting duration value */
	
	/* setting total footer values */
	total_ratio =  (String)drugDetails.get("TOTAL_RATIO")==null?"":(String)drugDetails.get("TOTAL_RATIO");
	total_ratio_qty =  (String)drugDetails.get("TOTAL_RATIO_QTY")==null?"":(String)drugDetails.get("TOTAL_RATIO_QTY");
	total_percent_qty =  (String)drugDetails.get("TOTAL_PERCENT_QTY")==null?"":(String)drugDetails.get("TOTAL_PERCENT_QTY");
    	

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);

                        
				        if(presDetails.size()>0){
						    for(int i=0;i<presDetails.size();i++){	
				                drug_detail = (HashMap) presDetails.get(i);
				                drugCode = (String)drug_detail.get("DRUG_CODE")==null?"":(String)drug_detail.get("DRUG_CODE");
				                if(PRES_BY_BASE.equals("")){
								   PRES_BY_BASE=(String)drug_detail.get("PRES_BY_BASE")==null?"":(String)drug_detail.get("PRES_BY_BASE");	
								}
				              	//for value retaining ABC
				                durn_values            = (String)drug_detail.get("DURN_VALUE")==null?"":(String)drug_detail.get("DURN_VALUE");
				              	if(durn_values.equals("")||durn_values.equals("0")){
				              		durn_values = "1";
				              	}
				        		durn_type            = (String)drug_detail.get("DURN_TYPE")==null?"":(String)drug_detail.get("DURN_TYPE");	
				        		start            = (String)drug_detail.get("START_DATE")==null?"":(String)drug_detail.get("START_DATE");	
				        		end            = (String)drug_detail.get("END_DATE")==null?"":(String)drug_detail.get("END_DATE");	
				        		dosage_value =(String)drug_detail.get("DOSAGE_VALUE")==null?"":(String)drug_detail.get("DOSAGE_VALUE");	
				        		dosage_UOM =(String)drug_detail.get("DOSAGE_UOM")==null?"":(String)drug_detail.get("DOSAGE_UOM");	
				        		freq_codes =  (String)drug_detail.get("FREQ_CODE")==null?"":(String)drug_detail.get("FREQ_CODE");	
				                
				                //banner indicators begins
				                String strength				= (String)drug_detail.get("STRENGTH_VALUE");
				            	String strength_uom			= (String)drug_detail.get("STRENGTH_UOM");
				            	String strength_uom_need	= CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,strength_uom));//Modified for CRF--0749 INC-13640
				            	String dosage				= (String)drug_detail.get("QTY_VALUE");
				            	String dosage_uom			= (String)drug_detail.get("QTY_UOM");
				            	String form_desc			= (String)drug_detail.get("FORM_DESC");
				            	String allergy_override		= (String)drug_detail.get("ALLERGY_OVERRIDE");
				            	String dose_override		= (String)drug_detail.get("DOSE_OVERRIDE");
				            	String currentrx_override	= (String)drug_detail.get("CURRENTRX_OVERRIDE");
				            	String stock_uom			=  	bean_CRX.getStockUOM((String)drug_detail.get("DRUG_CODE"));
				            	String generic_id			= (String)drug_detail.get("GENERIC_ID");
				            	String generic_name			= (String)drug_detail.get("GENERIC_NAME");
				            	String drugDescription1 		= (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC");
				            	String limit_ind			= (String)drug_detail.get("LIMIT_IND");
				            	String allergy_yn			= (String)drug_detail.get("ALLERGY_YN");
				            	String current_rx			= (String)drug_detail.get("CURRENT_RX");
				            	String drug_code			= (String)drug_detail.get("DRUG_CODE");
				            	String srl_no				= (String)drug_detail.get("SRL_NO");
				            	String pres_base_uom		= (String)drug_detail.get("PRES_BASE_UOM"); 
				            	String pres_base_uom_need   =  CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,pres_base_uom));//Modified for CRF--0749
				            	String external_product_id	= (String)drug_detail.get("EXTERNAL_PRODUCT_ID");
				                String perform_ext_db_checks	=(String)drug_detail.get("PERFORM_EXTERNAL_DATABASE_CHECKS"); 
				            	String drug_class = (String)drug_detail.get("DRUG_CLASS")==null?"":(String)drug_detail.get("DRUG_CLASS");	
				            	String startdate = (String)drug_detail.get("START_DATE");
				            	String enddate = (String)drug_detail.get("END_DATE");	
				            	String drug_remstr			=   (String) drug_detail.get("DRUG_REMARKS")==null?"":(String) drug_detail.get("DRUG_REMARKS");
				            	String currentOverRes=  (String) drug_detail.get("CURRENTRX_REMARKS")==null?"":(String) drug_detail.get("CURRENTRX_REMARKS");
				            	String currentAllergyOverRes =  (String) drug_detail.get("ALLERGY_REMARKS")==null?"":(String) drug_detail.get("ALLERGY_REMARKS");
				            	String currentDoseOverRes =  (String) drug_detail.get("DOSE_REMARKS")==null?"":(String) drug_detail.get("DOSE_REMARKS");
				            	
				            	ArrayList exProd				= new ArrayList();
				            	ArrayList drugDesc				= new ArrayList();
				            	String dup_drug_det			    = "";
				            	HashMap drug_Interactions		= null;
				            	//boolean chk_drug_med_condition	= false;
				            	//StringBuffer interaction_det    = new StringBuffer();
				            	//String contra_indication_for_drug   = "";

				            	String drug_db_contraind_check_flag	="N";
				            	String drug_db_interact_check_flag	="N";
				            	String drug_db_duptherapy_flag		="N";
				            	String drug_db_dose_check_flag      ="N"; 
				            	String drug_db_allergy_flag			="N";
				            	//String ext_override_reason		="";
				            	String ext_prod_id                   ="";

				            	ArrayList temp =(ArrayList)bean_CRX.getDrugDetails();
				            	
				            	
				    			 for(int j=0;j<temp.size();j++){
				    				drug_data	=	(HashMap)temp.get(j);					
				    				drugDesc.add((String)drug_data.get("DRUG_DESC"));
				    				ext_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_data.get("EXTERNAL_PRODUCT_ID");
				    				if(!ext_prod_id.equals("")){
				    					 exProd.add(ext_prod_id);
				    				}
				    			 }
				    			 ext_prod_id = drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
				    			 /*
				    				if(exProd.size()>0)
				    					beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids
				    				*/
				    			 if(!ext_prod_id.equals("")){
				    					/*
				    	                if(drug_db_interact_check_yn.equals("Y")){
				    					   beanex.getDDInteractions(external_product_id);//Store interactions
				    					       drug_Interactions		= beanex.getInteractions();//get Interactions
				    						if(drug_Interactions.size()>0){							
				    	                         drug_db_interact_check_flag="Y";
				    						}
				    			        }
				    	                if(drug_db_duptherapy_yn.equals("Y")){ 
				    					   dup_drug_det			= beanex.isDuplicateTherapy(external_product_id);//get dupluicate theraphy result

				    					   if(!dup_drug_det.equals("")&&dup_drug_det!=null)
				    	                        drug_db_duptherapy_flag="Y";
				    					}
				    	                if(drug_db_contraind_check_yn.equals("Y")){
				    						  ArrayList ex_prod_ids =new ArrayList();
				    						  ex_prod_ids.add(external_product_id);
				    					      boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
				    						  HashMap contra_indications =(HashMap)beanex.getContraIndications();
				    						  if(contra_indications.containsKey(external_product_id)){
				    							 drug_db_contraind_check_flag="Y";
				    						  }				  
				    					}

				    					if(drug_db_allergy_check_yn.equals("Y")){
				    						ArrayList ex_prod_ids =new ArrayList();
				    						ex_prod_ids.add(ext_prod_id);
				    						beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
				    						HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
				    						if(drug_alergies.containsKey(ext_prod_id)){
				    							drug_db_allergy_flag	= "Y";
				    						}	
				    					}*/
				    					if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
				    						String storeIDs = "N";
				    						if(exProd.size()>0 )
				    							storeIDs = "Y";
				    							
				    						HashMap tempDetails= null;
				    						ArrayList reqChecks = new ArrayList();
				    						reqChecks.add("N"); //Dosage Check 
				    						reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
				    						reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
				    						reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
				    						reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
				    						HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, startdate, enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
				    						if(drugDBCheckResult!=null)
				    							beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
				    						if(drug_db_allergy_check_yn.equals("Y")){
				    						   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
				    							   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
				    							   if(allergy_alert!=null && !allergy_alert.equals(""))
				    									drug_db_allergy_flag="Y";
				    						   } 
				    						   else {  
				    								tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
				    								if(tempDetails!=null && tempDetails.size()>0){
				    									 drug_db_allergy_flag="Y";
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
				    				}
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);
				    				if(drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_yn.equals("Y")){
				    					//out.println("viewMedicationAlert('"+drug_code+"','"+recno+"','"+patient_id+"','"+external_product_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dose_check_flag+"','ON_LOAD','','','','','','"+drug_db_allergy_flag+"');");
				    				}

				    				if(drug_db_duptherapy_flag.equals("Y")){
				    					current_rx ="N";
				    					drug_detail.put("CURRENT_RX",current_rx);
				    				}

				    				if(drug_db_allergy_flag.equals("Y")){
				    					allergy_yn ="N";
				    					drug_detail.put("ALLERGY_YN",allergy_yn);
				    				}

				    				if(perform_ext_db_checks.equals("Y")){
				    					limit_ind = "Y";
				    					drug_detail.put("LIMIT_IND",limit_ind);
				    				}
				    								
				    				if(!(allergy_yn.equals("N") && limit_ind.equals("Y") && current_rx.equals("N"))){			
				    					//out.println("overrideImg('"+allergy_yn+"','"+allergy_override+"','"+limit_ind+"','"+dose_override+"','"+current_rx+"','"+currentrx_override+"');");
				    				}
				                	
				    				
				    				
				            	
				            	strengthValue = (String)drug_detail.get("STRENGTH_VALUE")==null?"":(String)drug_detail.get("STRENGTH_VALUE");
								strengthDesc = (String)drug_detail.get("STRENGTH_UOM_DESC")==null?"":(String)drug_detail.get("STRENGTH_UOM_DESC");	
								String TOT_STRENGTH_UOM_CODE =(String)drug_detail.get("TOT_STRENGTH_UOM")==null?"":(String)drug_detail.get("TOT_STRENGTH_UOM");
								
								DosageValue=DosageValue+TOT_STRENGTH_UOM_CODE+",";
								DosageText=DosageText+strengthDesc+",";
								
                                formDesc = (String)drug_detail.get("FORM_DESC")==null?"":(String)drug_detail.get("FORM_DESC");	
                                
                                allDrugs+=drugCode+",";
                                allDrugs_count=allDrugs_count+1;
								strengthOrder_qty = (String)drug_detail.get("ORDER_QTY")==null?"":(String)drug_detail.get("ORDER_QTY");
                                strengthQty_UOM = (String)drug_detail.get("PRES_BASE_UOM_DESC")==null?"":(String)drug_detail.get("PRES_BASE_UOM_DESC");
								pres_base_uom_value = (String)drug_detail.get("PRES_BASE_UOM")==null?"":(String)drug_detail.get("PRES_BASE_UOM");
									
								
						   String ORDER_QTY = (String)drug_detail.get("ORDER_QTY")==null?"":(String)drug_detail.get("ORDER_QTY");
						   String DRUG_INDICATION =		 (String)drug_detail.get("DRUG_INDICATION")==null?"":(String)drug_detail.get("DRUG_INDICATION");
						   
						   
								//allergyOverride = (String)drug_detail.get("ALLERGY_YN")==null?"":(String)drug_detail.get("ALLERGY_YN");
								//dosagelimitOverride = (String)drug_detail.get("DOSE_OVERRIDE")==null?"":(String)drug_detail.get("DOSE_OVERRIDE");
								//drugIndication = (String)drug_detail.get("LIMIT_IND")==null?"":(String)drug_detail.get("LIMIT_IND");									
								//drugOverride = (String)drug_detail.get("CURRENT_RX")==null?"":(String)drug_detail.get("CURRENT_RX");
								
                                /* build MAR values */
	                            if(buildMAR_yn.equals("Y"))
			                      buildMAR_ynCheck="checked";
	                            else{
		                          buildMAR_ynCheck="";
		                          buildMAR_yn = "N";
	                            }
						
	                            if(i==0)  {               // To load the build MAR based on the first drug
							      buildMAR_rule	= (String)drugDetails.get("BUILD_MAR_RULE")==null?"":(String)drugDetails.get("BUILD_MAR_RULE");
						        }
						        buildMAR_yn="N";
						        if(buildMAR_rule==null){
							      buildMAR_rule="";
						        }
						        if(buildMAR_rule.equals("CE")){
							      buildMAR_ynCheck ="checked";		
							      buildMAR_ynEnable="";
							      buildMAR_yn="Y";
						        }
						        else if(buildMAR_rule.equals("UE")){
							      buildMAR_ynCheck ="";		
							      buildMAR_ynEnable="";
						        }
						        else if(buildMAR_rule.equals("CD")){
							      buildMAR_ynCheck ="checked";		
							      buildMAR_ynEnable="disabled";
							      buildMAR_yn="Y";
						        }
						        else if(buildMAR_rule.equals("UD")){
							     buildMAR_ynCheck ="";		
							     buildMAR_ynEnable="disabled";
						        }
						
						        bean_CRX.setBuildMAR_yn(buildMAR_yn);
						
	                            buildMAR_yn     = (String)drugDetails.get("BUILDMAR_YN")==null?"":(String)drugDetails.get("BUILDMAR_YN");								
									
                        
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drugDescription1));
            _bw.write(_wl_block15Bytes, _wl_block15);

			                                    if(!strengthValue.equals("0"))
												{ 
											    
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strengthValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strengthDesc));
            _bw.write(_wl_block18Bytes, _wl_block18);

												} 
												
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(formDesc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strengthValue));
            _bw.write(_wl_block23Bytes, _wl_block23);

													if(!ext_prod_id.equals("") && drug_db_interface_yn.equals("Y")){
													
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
													if(dose_override.equals("Y")){
													
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);

													}if(current_rx.equals("Y")){
													
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
													if(allergy_yn.equals("Y")){
													
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);

													}
													
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( ORDER_QTY ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strengthQty_UOM));
            _bw.write(_wl_block37Bytes, _wl_block37);

												//if(perform_ext_db_checks.equals("Y")){
												
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(DRUG_INDICATION ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(DRUG_INDICATION ));
            _bw.write(_wl_block40Bytes, _wl_block40);

												//}
												
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(URLDecoder.decode(drug_remstr, "UTF-8")));
            _bw.write(_wl_block43Bytes, _wl_block43);

												if(current_rx.equals("Y")){
												
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(currentOverRes ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(currentOverRes ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(current_rx ));
            _bw.write(_wl_block48Bytes, _wl_block48);

												}else{
													
													
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(current_rx ));
            _bw.write(_wl_block50Bytes, _wl_block50);

												}
												if(allergy_yn.equals("Y")){
												
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(currentAllergyOverRes));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(currentAllergyOverRes));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(allergy_yn ));
            _bw.write(_wl_block48Bytes, _wl_block48);

												}else{
													
													
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(allergy_yn ));
            _bw.write(_wl_block54Bytes, _wl_block54);

												}
												if(dose_override.equals("Y")){
												
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(currentDoseOverRes));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(currentDoseOverRes));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dose_override ));
            _bw.write(_wl_block58Bytes, _wl_block58);

												}
                                                      else{
													
													
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dose_override ));
            _bw.write(_wl_block54Bytes, _wl_block54);

												}
												
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drugCode));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drugDescription1));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strengthDesc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
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
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pres_base_uom_value));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);

                            }
							if(DosageValue.length()>0)  
								DosageValue = DosageValue.substring(0, DosageValue.length()-1);
							if(DosageText.length()>0)
								DosageText = DosageText.substring(0, DosageText.length()-1);
					    }
					    
            _bw.write(_wl_block101Bytes, _wl_block101);
     String TOTAL_QTY ="";
							 if(presDetails.size()>0){
							 drug_detail = (HashMap) presDetails.get(0);
							 TOTAL_QTY = (String)drug_detail.get("TOTAL_QTY")==null?"":(String)drug_detail.get("TOTAL_QTY");	
							 }
					
					
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(TOTAL_QTY ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(final_prod_qty_uom));
            _bw.write(_wl_block104Bytes, _wl_block104);

				                if(presDetails.size()>0){
						            for(int j=0;j<presDetails.size();j++){	
						            	drug_detail = (HashMap) presDetails.get(j);
						            	if(PRES_BY_BASE.equals("")){
								          PRES_BY_BASE=(String)drug_detail.get("PRES_BY_BASE")==null?"":(String)drug_detail.get("PRES_BY_BASE");	
								        }
							            drugDescription = (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC");
										strengthValue = (String)drug_detail.get("STRENGTH_VALUE")==null?"":(String)drug_detail.get("STRENGTH_VALUE");
								        strengthDesc = (String)drug_detail.get("STRENGTH_UOM_DESC")==null?"":(String)drug_detail.get("STRENGTH_UOM_DESC");	
                                        formDesc = (String)drug_detail.get("FORM_DESC")==null?"":(String)drug_detail.get("FORM_DESC");
										drugCode = (String)drug_detail.get("DRUG_CODE")==null?"":(String)drug_detail.get("DRUG_CODE");
                                        ratioQty_UOM = (String)drug_detail.get("PRES_BASE_UOM_DESC")==null?"":(String)drug_detail.get("PRES_BASE_UOM_DESC");										
										pres_base_uom_value = (String)drug_detail.get("PRES_BASE_UOM")==null?"":(String)drug_detail.get("PRES_BASE_UOM");
						            	
										
										//banner indicators begins
						                String strength				= (String)drug_detail.get("STRENGTH_VALUE");
						            	String strength_uom			= (String)drug_detail.get("STRENGTH_UOM");
						            	String strength_uom_need	= CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,strength_uom));//Modified for CRF--0749 INC-13640
						            	String dosage				= (String)drug_detail.get("QTY_VALUE");
						            	String dosage_uom			= (String)drug_detail.get("QTY_UOM");
						            	String form_desc			= (String)drug_detail.get("FORM_DESC");
						            	String allergy_override		= (String)drug_detail.get("ALLERGY_OVERRIDE");
						            	String dose_override		= (String)drug_detail.get("DOSE_OVERRIDE");
						            	String currentrx_override	= (String)drug_detail.get("CURRENTRX_OVERRIDE");
						            	String stock_uom			=  	bean_CRX.getStockUOM((String)drug_detail.get("DRUG_CODE"));
						            	String generic_id			= (String)drug_detail.get("GENERIC_ID");
						            	String generic_name			= (String)drug_detail.get("GENERIC_NAME");
						            	String drugDescription1 		= (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC");
						            	String limit_ind			= (String)drug_detail.get("LIMIT_IND");
						            	String allergy_yn			= (String)drug_detail.get("ALLERGY_YN");
						            	String current_rx			= (String)drug_detail.get("CURRENT_RX");
						            	String drug_code			= (String)drug_detail.get("DRUG_CODE");
						            	String srl_no				= (String)drug_detail.get("SRL_NO");
						            	String pres_base_uom		= (String)drug_detail.get("PRES_BASE_UOM"); 
						            	String pres_base_uom_need   =  CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,pres_base_uom));//Modified for CRF--0749
						            	String external_product_id	= (String)drug_detail.get("EXTERNAL_PRODUCT_ID");
						                String perform_ext_db_checks	=(String)drug_detail.get("PERFORM_EXTERNAL_DATABASE_CHECKS"); 
						            	String drug_class = (String)drug_detail.get("DRUG_CLASS")==null?"":(String)drug_detail.get("DRUG_CLASS");	
						            	String startdate = (String)drug_detail.get("START_DATE");
						            	String enddate = (String)drug_detail.get("END_DATE");	
						            	String drug_remstr			=   (String) drug_detail.get("DRUG_REMARKS")==null?"":(String) drug_detail.get("DRUG_REMARKS");
						            	String currentOverRes=  (String) drug_detail.get("CURRENTRX_REMARKS")==null?"":(String) drug_detail.get("CURRENTRX_REMARKS");
						    		    String currentAllergyOverRes =  (String) drug_detail.get("ALLERGY_REMARKS")==null?"":(String) drug_detail.get("ALLERGY_REMARKS");
						                String currentDoseOverRes =  (String) drug_detail.get("DOSE_REMARKS")==null?"":(String) drug_detail.get("DOSE_REMARKS");
						            	
						            	ArrayList exProd				= new ArrayList();
						            	ArrayList drugDesc				= new ArrayList();
						            	String dup_drug_det			    = "";
						            	HashMap drug_Interactions		= null;
						            	
						            	String drug_db_contraind_check_flag	="N";
						            	String drug_db_interact_check_flag	="N";
						            	String drug_db_duptherapy_flag		="N";
						            	String drug_db_dose_check_flag      ="N"; 
						            	String drug_db_allergy_flag			="N";
						            	String ext_prod_id                   ="";

						            	ArrayList temp =(ArrayList)bean_CRX.getDrugDetails();
						    			 for(int k=0;k<temp.size();k++){
						    				drug_data	=	(HashMap)temp.get(k);					
						    				drugDesc.add((String)drug_data.get("DRUG_DESC"));
						    				ext_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_data.get("EXTERNAL_PRODUCT_ID");
						    				if(!ext_prod_id.equals("")){
						    					 exProd.add(ext_prod_id);
						    				}
						    			 }
						    			 ext_prod_id = drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
						    			 
						    			 if(!ext_prod_id.equals("")){
						    					/*
						    	                if(drug_db_interact_check_yn.equals("Y")){
						    					   beanex.getDDInteractions(external_product_id);//Store interactions
						    					       drug_Interactions		= beanex.getInteractions();//get Interactions
						    						if(drug_Interactions.size()>0){							
						    	                         drug_db_interact_check_flag="Y";
						    						}
						    			        }
						    	                if(drug_db_duptherapy_yn.equals("Y")){ 
						    					   dup_drug_det			= beanex.isDuplicateTherapy(external_product_id);//get dupluicate theraphy result

						    					   if(!dup_drug_det.equals("")&&dup_drug_det!=null)
						    	                        drug_db_duptherapy_flag="Y";
						    					}
						    	                if(drug_db_contraind_check_yn.equals("Y")){
						    						  ArrayList ex_prod_ids =new ArrayList();
						    						  ex_prod_ids.add(external_product_id);
						    					      boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
						    						  HashMap contra_indications =(HashMap)beanex.getContraIndications();
						    						  if(contra_indications.containsKey(external_product_id)){
						    							 drug_db_contraind_check_flag="Y";
						    						  }				  
						    					}

						    					if(drug_db_allergy_check_yn.equals("Y")){
						    						ArrayList ex_prod_ids =new ArrayList();
						    						ex_prod_ids.add(ext_prod_id);
						    						beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
						    						HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
						    						if(drug_alergies.containsKey(ext_prod_id)){
						    							drug_db_allergy_flag	= "Y";
						    						}	
						    					}*/
						    					if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
						    						String storeIDs = "N";
						    						if(exProd.size()>0 )
						    							storeIDs = "Y";
						    							
						    						HashMap tempDetails= null;
						    						ArrayList reqChecks = new ArrayList();
						    						reqChecks.add("N"); //Dosage Check 
						    						reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
						    						reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
						    						reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
						    						reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
						    						HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, startdate, enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
						    						if(drugDBCheckResult!=null)
						    							beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
						    						if(drug_db_allergy_check_yn.equals("Y")){
						    						   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
						    							   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
						    							   if(allergy_alert!=null && !allergy_alert.equals(""))
						    									drug_db_allergy_flag="Y";
						    						   } 
						    						   else {  
						    								tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
						    								if(tempDetails!=null && tempDetails.size()>0){
						    									 drug_db_allergy_flag="Y";
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
						    				}
						    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
						    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
						    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
						    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
						    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);
						    				if(drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_yn.equals("Y")){
						    					//out.println("viewMedicationAlert('"+drug_code+"','"+recno+"','"+patient_id+"','"+external_product_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dose_check_flag+"','ON_LOAD','','','','','','"+drug_db_allergy_flag+"');");
						    				}

						    				if(drug_db_duptherapy_flag.equals("Y")){
						    					current_rx ="N";
						    					drug_detail.put("CURRENT_RX",current_rx);
						    				}

						    				if(drug_db_allergy_flag.equals("Y")){
						    					allergy_yn ="N";
						    					drug_detail.put("ALLERGY_YN",allergy_yn);
						    				}

						    				if(perform_ext_db_checks.equals("Y")){
						    					limit_ind = "Y";
						    					drug_detail.put("LIMIT_IND",limit_ind);
						    				}
						    								
						    				if(!(allergy_yn.equals("N") && limit_ind.equals("Y") && current_rx.equals("N"))){			
						    					//out.println("overrideImg('"+allergy_yn+"','"+allergy_override+"','"+limit_ind+"','"+dose_override+"','"+current_rx+"','"+currentrx_override+"');");
						    				}
								     
								        //ratio_value_
								        String ratio_precenatge=  (String)drug_detail.get("RATIO_PERCENTAGE")==null?"":(String)drug_detail.get("RATIO_PERCENTAGE");
								        //ratio_req_qty_
								        
								        String reqd_qty=  (String)drug_detail.get("REQD_QTY")==null?"":(String)drug_detail.get("REQD_QTY");
								        String ord_qty=  (String)drug_detail.get("ORDER_QTY")==null?"":(String)drug_detail.get("ORDER_QTY");
								        
								        String DRUG_INDICATION=  (String)drug_detail.get("DRUG_INDICATION")==null?"":(String)drug_detail.get("DRUG_INDICATION");
						        
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(drugDescription));
            _bw.write(_wl_block106Bytes, _wl_block106);

			                                    if(!strengthValue.equals("0"))
												{ 
											    
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strengthValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strengthDesc));
            _bw.write(_wl_block18Bytes, _wl_block18);

												} 
												
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(formDesc));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(j));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strengthValue));
            _bw.write(_wl_block23Bytes, _wl_block23);

													if(!ext_prod_id.equals("") && drug_db_interface_yn.equals("Y")){
													
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
													if(dose_override.equals("Y")){
													
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);

													}if(current_rx.equals("Y")){
													
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
													if(allergy_yn.equals("Y")){
													
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);

													}
													
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ratio_precenatge ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(j));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(j));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(reqd_qty ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(j));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(ord_qty ));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ratioQty_UOM));
            _bw.write(_wl_block115Bytes, _wl_block115);

												//if(drugIndication.equals("Y")){
												
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(DRUG_INDICATION ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(DRUG_INDICATION ));
            _bw.write(_wl_block40Bytes, _wl_block40);

												//}
												
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(j));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(URLDecoder.decode(drug_remstr, "UTF-8") ));
            _bw.write(_wl_block120Bytes, _wl_block120);

												if(current_rx.equals("Y")){
												
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(currentOverRes));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(currentOverRes));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(current_rx ));
            _bw.write(_wl_block48Bytes, _wl_block48);

												}else{
													
													
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(current_rx ));
            _bw.write(_wl_block54Bytes, _wl_block54);

												}
												if(allergy_yn.equals("Y")){
												
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(currentAllergyOverRes));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(currentAllergyOverRes));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(allergy_yn ));
            _bw.write(_wl_block48Bytes, _wl_block48);

												}else{
													
													
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(allergy_yn ));
            _bw.write(_wl_block54Bytes, _wl_block54);

												}
												if(dose_override.equals("Y")){
												
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(j));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(currentDoseOverRes ));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(currentDoseOverRes ));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dose_override ));
            _bw.write(_wl_block58Bytes, _wl_block58);

												}else{
													
													
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dose_override ));
            _bw.write(_wl_block54Bytes, _wl_block54);

												}
												
            _bw.write(_wl_block133Bytes, _wl_block133);

                                    }   
					            } 
					            
            _bw.write(_wl_block134Bytes, _wl_block134);
         //  String TOTAL_QTY;
							 if(presDetails.size()>0){
							 drug_detail = (HashMap) presDetails.get(0);
							 TOTAL_QTY = (String)drug_detail.get("TOTAL_QTY")==null?"":(String)drug_detail.get("TOTAL_QTY");
							 }
					
					
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(TOTAL_QTY ));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(final_prod_qty_uom));
            _bw.write(_wl_block137Bytes, _wl_block137);

						    String allDrugs_percentage="";
                            String DosageInfo_percentage="";
                           //String calcDoseValueUnit="";
                    	
                        
				        if(presDetails.size()>0){
						    for(int i=0;i<presDetails.size();i++){	
						    		drug_detail = (HashMap) presDetails.get(i);
						    		if(PRES_BY_BASE.equals("")){
								       PRES_BY_BASE=(String)drug_detail.get("PRES_BY_BASE")==null?"":(String)drug_detail.get("PRES_BY_BASE");	
								    }
						    	 	drugCode = (String)drug_detail.get("DRUG_CODE")==null?"":(String)drug_detail.get("DRUG_CODE");
					                drugDescription = (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC");
									strengthValue = (String)drug_detail.get("STRENGTH_VALUE")==null?"":(String)drug_detail.get("STRENGTH_VALUE");
							        strengthDesc = (String)drug_detail.get("STRENGTH_UOM_DESC")==null?"":(String)drug_detail.get("STRENGTH_UOM_DESC");	
                                    formDesc = (String)drug_detail.get("FORM_DESC")==null?"":(String)drug_detail.get("FORM_DESC");
									drugCode = (String)drug_detail.get("DRUG_CODE")==null?"":(String)drug_detail.get("DRUG_CODE");
                                    ratioQty_UOM = (String)drug_detail.get("PRES_BASE_UOM_DESC")==null?"":(String)drug_detail.get("PRES_BASE_UOM_DESC");										
									pres_base_uom_value = (String)drug_detail.get("PRES_BASE_UOM")==null?"":(String)drug_detail.get("PRES_BASE_UOM");
									
					                //banner indicators begins
					                String strength				= (String)drug_detail.get("STRENGTH_VALUE");
					            	String strength_uom			= (String)drug_detail.get("STRENGTH_UOM");
					            	String strength_uom_need	= CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,strength_uom));//Modified for CRF--0749 INC-13640
					            	String dosage				= (String)drug_detail.get("QTY_VALUE");
					            	String dosage_uom			= (String)drug_detail.get("QTY_UOM");
					            	String form_desc			= (String)drug_detail.get("FORM_DESC");
					            	String allergy_override		= (String)drug_detail.get("ALLERGY_OVERRIDE");
					            	String dose_override		= (String)drug_detail.get("DOSE_OVERRIDE");
					            	String currentrx_override	= (String)drug_detail.get("CURRENTRX_OVERRIDE");
					            	String stock_uom			=  	bean_CRX.getStockUOM((String)drug_detail.get("DRUG_CODE"));
					            	String generic_id			= (String)drug_detail.get("GENERIC_ID");
					            	String generic_name			= (String)drug_detail.get("GENERIC_NAME");
					            	String drugDescription1 		= (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC");
					            	String limit_ind			= (String)drug_detail.get("LIMIT_IND");
					            	String allergy_yn			= (String)drug_detail.get("ALLERGY_YN");
					            	String current_rx			= (String)drug_detail.get("CURRENT_RX");
					            	String drug_code			= (String)drug_detail.get("DRUG_CODE");
					            	String srl_no				= (String)drug_detail.get("SRL_NO");
					            	String pres_base_uom		= (String)drug_detail.get("PRES_BASE_UOM"); 
					            	String pres_base_uom_need   =  CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,pres_base_uom));//Modified for CRF--0749
					            	String external_product_id	= (String)drug_detail.get("EXTERNAL_PRODUCT_ID");
					                String perform_ext_db_checks	=(String)drug_detail.get("PERFORM_EXTERNAL_DATABASE_CHECKS"); 
					            	String drug_class = (String)drug_detail.get("DRUG_CLASS")==null?"":(String)drug_detail.get("DRUG_CLASS");	
					            	String startdate = (String)drug_detail.get("START_DATE");
					            	String enddate = (String)drug_detail.get("END_DATE");
					            	String drug_remstr			=   (String) drug_detail.get("DRUG_REMARKS")==null?"":(String) drug_detail.get("DRUG_REMARKS");
					            	String currentOverRes=  (String) drug_detail.get("CURRENTRX_REMARKS")==null?"":(String) drug_detail.get("CURRENTRX_REMARKS");
					    		    String currentAllergyOverRes =  (String) drug_detail.get("ALLERGY_REMARKS")==null?"":(String) drug_detail.get("ALLERGY_REMARKS");
					                String currentDoseOverRes =  (String) drug_detail.get("DOSE_REMARKS")==null?"":(String) drug_detail.get("DOSE_REMARKS");
					                
					                
					            	
					            	ArrayList exProd				= new ArrayList();
					            	ArrayList drugDesc				= new ArrayList();
					            	String dup_drug_det			    = "";
					            	HashMap drug_Interactions		= null;
					            	
					            	String drug_db_contraind_check_flag	="N";
					            	String drug_db_interact_check_flag	="N";
					            	String drug_db_duptherapy_flag		="N";
					            	String drug_db_dose_check_flag      ="N"; 
					            	String drug_db_allergy_flag			="N";
					            	String ext_prod_id                   ="";

				            	ArrayList temp =(ArrayList)bean_CRX.getDrugDetails();
				            	
				            	
				    			 for(int j=0;j<temp.size();j++){
				    				drug_data	=	(HashMap)temp.get(j);					
				    				drugDesc.add((String)drug_data.get("DRUG_DESC"));
				    				ext_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_data.get("EXTERNAL_PRODUCT_ID");
				    				if(!ext_prod_id.equals("")){
				    					 exProd.add(ext_prod_id);
				    				}
				    			 }
				    			 ext_prod_id = drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
				    			 /*
				    				if(exProd.size()>0)
				    					beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids
				    				*/
				    			 if(!ext_prod_id.equals("")){
				    					/*
				    	                if(drug_db_interact_check_yn.equals("Y")){
				    					   beanex.getDDInteractions(external_product_id);//Store interactions
				    					       drug_Interactions		= beanex.getInteractions();//get Interactions
				    						if(drug_Interactions.size()>0){							
				    	                         drug_db_interact_check_flag="Y";
				    						}
				    			        }
				    	                if(drug_db_duptherapy_yn.equals("Y")){ 
				    					   dup_drug_det			= beanex.isDuplicateTherapy(external_product_id);//get dupluicate theraphy result

				    					   if(!dup_drug_det.equals("")&&dup_drug_det!=null)
				    	                        drug_db_duptherapy_flag="Y";
				    					}
				    	                if(drug_db_contraind_check_yn.equals("Y")){
				    						  ArrayList ex_prod_ids =new ArrayList();
				    						  ex_prod_ids.add(external_product_id);
				    					      boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
				    						  HashMap contra_indications =(HashMap)beanex.getContraIndications();
				    						  if(contra_indications.containsKey(external_product_id)){
				    							 drug_db_contraind_check_flag="Y";
				    						  }				  
				    					}

				    					if(drug_db_allergy_check_yn.equals("Y")){
				    						ArrayList ex_prod_ids =new ArrayList();
				    						ex_prod_ids.add(ext_prod_id);
				    						beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
				    						HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
				    						if(drug_alergies.containsKey(ext_prod_id)){
				    							drug_db_allergy_flag	= "Y";
				    						}	
				    					}*/
				    					if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
				    						String storeIDs = "N";
				    						if(exProd.size()>0 )
				    							storeIDs = "Y";
				    							
				    						HashMap tempDetails= null;
				    						ArrayList reqChecks = new ArrayList();
				    						reqChecks.add("N"); //Dosage Check 
				    						reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
				    						reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
				    						reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
				    						reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
				    						HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, startdate, enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
				    						if(drugDBCheckResult!=null)
				    							beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
				    						if(drug_db_allergy_check_yn.equals("Y")){
				    						   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
				    							   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
				    							   if(allergy_alert!=null && !allergy_alert.equals(""))
				    									drug_db_allergy_flag="Y";
				    						   } 
				    						   else {  
				    								tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
				    								if(tempDetails!=null && tempDetails.size()>0){
				    									 drug_db_allergy_flag="Y";
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
				    				}
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);
				    				if(drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_yn.equals("Y")){
				    					//out.println("viewMedicationAlert('"+drug_code+"','"+recno+"','"+patient_id+"','"+external_product_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dose_check_flag+"','ON_LOAD','','','','','','"+drug_db_allergy_flag+"');");
				    				}

				    				if(drug_db_duptherapy_flag.equals("Y")){
				    					current_rx ="N";
				    					drug_detail.put("CURRENT_RX",current_rx);
				    				}

				    				if(drug_db_allergy_flag.equals("Y")){
				    					allergy_yn ="N";
				    					drug_detail.put("ALLERGY_YN",allergy_yn);
				    				}

				    				if(perform_ext_db_checks.equals("Y")){
				    					limit_ind = "Y";
				    					drug_detail.put("LIMIT_IND",limit_ind);
				    				}
				    								
				    				if(!(allergy_yn.equals("N") && limit_ind.equals("Y") && current_rx.equals("N"))){			
				    					//out.println("overrideImg('"+allergy_yn+"','"+allergy_override+"','"+limit_ind+"','"+dose_override+"','"+current_rx+"','"+currentrx_override+"');");
				    				}
				                	
				            	
				            
								//strengthDesc = (String)drug_detail.get("STRENGTH_UOM_DESC")==null?"":(String)drug_detail.get("STRENGTH_UOM_DESC");
	                            //ratio_value_
						        String ratio_precenatge=  (String)drug_detail.get("RATIO_PERCENTAGE")==null?"":(String)drug_detail.get("RATIO_PERCENTAGE");
						        //ratio_req_qty_
						        
						        String reqd_qty=  (String)drug_detail.get("REQD_QTY")==null?"":(String)drug_detail.get("REQD_QTY");
						        //ratioQty_UOM_
						        String ord_qty=  (String)drug_detail.get("ORDER_QTY")==null?"":(String)drug_detail.get("ORDER_QTY");
						        String stock_display_unit_UOM= (String)drug_detail.get("PRES_BASE_UOM_DESC")==null?"":(String)drug_detail.get("PRES_BASE_UOM_DESC");								
						        String DRUG_INDICATION =  (String)drug_detail.get("DRUG_INDICATION")==null?"":(String)drug_detail.get("DRUG_INDICATION");
						        String base_drug_selected =  (String)drug_detail.get("BASE_DRUG")==null?"":(String)drug_detail.get("BASE_DRUG");
						        String sel="";
						        String dis="";
						        if(base_drug_selected.equalsIgnoreCase("Y")){
						        	sel="checked='checked'";
						        	dis="disabled='disabled'";
						        }else{
						        	
						        	sel="";
						        	dis="";
						        }
						       System.out.println("selll:"+sel+"dis::"+dis);
						
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(drugDescription));
            _bw.write(_wl_block139Bytes, _wl_block139);

			                                            if(!strengthValue.equals("0"))
														{
														
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(strengthValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strengthDesc));
            _bw.write(_wl_block141Bytes, _wl_block141);

														}
														
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(formDesc));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strengthValue));
            _bw.write(_wl_block145Bytes, _wl_block145);

													if(!ext_prod_id.equals("") && drug_db_interface_yn.equals("Y")){
													
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
													if(dose_override == "Y"){
													
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);

													}if(current_rx == "Y"){
													
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
													if(allergy_yn == "Y"){
													
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);

													}
													
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ratio_precenatge ));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(reqd_qty));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(i));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ord_qty));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(stock_display_unit_UOM));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(DRUG_INDICATION ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(DRUG_INDICATION ));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(URLDecoder.decode(drug_remstr, "UTF-8") ));
            _bw.write(_wl_block164Bytes, _wl_block164);

													if(current_rx.equals("Y")){
													
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(currentOverRes));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(currentOverRes));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(current_rx ));
            _bw.write(_wl_block54Bytes, _wl_block54);

													}
													else{
														
														
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(current_rx ));
            _bw.write(_wl_block168Bytes, _wl_block168);

													}if(allergy_yn.equals("Y")){
													
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(currentAllergyOverRes));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(currentAllergyOverRes));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(allergy_yn ));
            _bw.write(_wl_block54Bytes, _wl_block54);

													}
else{
														
														
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(allergy_yn ));
            _bw.write(_wl_block168Bytes, _wl_block168);

													}
													if(dose_override.equals("Y")){
													
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(currentDoseOverRes ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(currentDoseOverRes ));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dose_override ));
            _bw.write(_wl_block54Bytes, _wl_block54);

													}else{
														
														
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dose_override ));
            _bw.write(_wl_block168Bytes, _wl_block168);

													}
													
            _bw.write(_wl_block175Bytes, _wl_block175);

						    }
				        }
				        
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(dosage_value));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(durn_values));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(buildMAR_ynCheck));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(buildMAR_ynEnable));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(dflt_disp_locn));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(total_ratio));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(total_ratio_qty));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(total_percent_qty));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(bean_id_CRX));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(DosageValue));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(DosageText));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(bean_name_CRX));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(start_date_fluid));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(end_date_fluid));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(END_DATES));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(START_DATES));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(interval_value));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(repeat_durn_type ));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(scheduled_yn));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(PRES_BY_BASE ));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(allDrugs));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(allDrugs_count));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(freq_codes));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(dosage_UOM));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(start));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(end));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block215Bytes, _wl_block215);
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
