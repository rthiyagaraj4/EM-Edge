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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pharmivrxwithaddview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/pharmIvRXWithAddView.jsp", 1709118021162L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="/eIPAD/js/pharmIvRxDetailsViewWithAdd.js\"></script> \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<div data-role = \"none\"  class = \"blurPopup\" onclick=\"\" data-popid=\"\" style=\"z-index:10000\"></div>\n<form id=\"formIVPrescriptionDetails\" name = \"formIVPrescriptionDetails\" method = \"post\" action = \"\" class=\"ChartSummaryFormElem\">\t\t\n\t<div class=\"ChartSummaryBlockVar\" id=\"rxDetailsSummaryBlock\" data-role = \"none\">\n\t\t\t<div class=\"ChartSummaryMainTable\" data-role = \"none\">\n\t\t\t\t<div data-role = \"none\" class =\"ChartSummaryPageHeader\">\n               \t\t<div class=\"ChartSummaryHeaderCell\" data-role = \"none\">\n                  \t\t<div class=\"ChartSummaryHeaderCont\" data-role = \"none\">\n                     \t\t<div class=\"ChartSummaryHeaderTable ChartSummaryHeaderTableTheme\" data-role = \"none\">\n                        \t\t<div class=\"ChartSummaryHeaderRow\" data-role = \"none\">\n                           \t\t\t<div class=\"ChartSummaryHeaderTextCol\" data-role = \"none\">\n                              \t\t\t<div class=\"ChartSummaryHeaderText ChartSummaryHeaderTextTheme\" data-role = \"none\">IV</div>\n                           \t\t\t</div>\n                           \t\t\t<div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n                              \t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"completeIvRxDetailsConfirm()\"><img src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/CS_Ok16x16.png\"></div>\n                           \t\t\t</div>\n\t\t                           <div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n\t\t                              <div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"closeRxDetailsView()\"><img src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/CS_Close16x16.png\"></div>\n\t\t                           </div>\n                       \t \t\t</div>\n                     \t\t</div>\n                  \t\t</div>\n               \t\t</div>\n            \t</div>\n\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageContent ChartSummaryPageContentTheme\" id=\"\">\n\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageContentCell\">\n\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryMainWrapper pharmDataMainWrapper\" id=\"\" >\n\t\t\t\t\t\t\t<div class=\"ChartSummaryMainScroller pharmDataContentScroller\"  data-role = \"none\">\t\t\t\t\t \t\t\t\t\t \n\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:100%;\" data-role = \"none\">\t\n\t\t\t\t\t\t\t\t\t<div  class=\"row ivrxDetailsViewHeaderRowWrapper\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"cell\"  data-role = \"none\">\n\t                                 \t\t<div class=\"table\" style=\"width:100%;height:75%;\" data-role = \"none\">\n\t\t\t                                    <div  class=\"row pharmItemDescNameCell\"  data-role = \"none\">\n\t\t\t                                       <div class=\"cell pharmRxOrderItemName segoeuiBold\"  data-role = \"none\">\n\t\t\t                                          <span class=\"pharmRxOrderItemName10padding\">IV with Additives\n\t\t\t                                          </span>\n\t\t\t                                       </div>                                      \n\t\t\t                                    </div>\n\t\t\t                                    <div  class=\"row pharmItemDescNameCell\"  data-role = \"none\">\n\t\t\t                                       <div class=\"cell pharmRxOrderStrength\"  data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"pharmRxOrderItemDesc\">\n\t\t\t                                             <label class=\"pharmRxOrderItemLabel\">Dispense Location</label>\n\t\t\t                                             <span class=\"pharmRxOrderItemInfo segoeuiBold\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span>\n\t\t\t                                          </div>\n\t\t\t                                       </div>\n\t\t\t                                       <div class=\"cell pharmRxOrderItemRate\"  data-role = \"none\">\n\t\t\t                                          <span class=\"pharmRxOrderItemRateDesc\">-- / --</span>\n\t\t\t                                       </div>\n\t\t\t                                       <div class=\"cell pharmRxOrderItemRate\"  data-role = \"none\">\n\t\t\t                                          <span class=\"pharmRxOrderItemRateLabel\">Total / Patient</span>\n\t\t\t                                       </div>\n\t\t\t                                    </div>\n\t\t\t                                    <div  class=\"row pharmCartBottomContainer\"  data-role = \"none\">\n\t\t\t                                       <div class=\"cell pharmCartBottomImg\" data-role = \"none\">\t\t\t\t\t\t\t\t\t\t \n\t\t\t                                       </div>\n\t\t\t                                    </div>\n\t                                 \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"table ivHeaderWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"row fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell ivHeaderWrapperContent\">\n\t\t\t\t\t\t\t\t\t\t\t\t      <div  class=\"drugDetailsTab segoeuiBold\"  id=\"IVRxDrugTab\"  onclick=\"openDrugDetailsTab()\">Drug Details</div> <!--to handle in jquery-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"adminDetailsTab segoeuiBold\"   id=\"IVRxAdminTab\" onclick=\"openAdminDetailsTab()\">Administration Details</div>\n\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t \t</div>\n\t                              \t\t</div>\n\t                           \t\t</div>\t\t\t\t   \t\t\t\t\t\t\t   \n\t                           \t\t<!-- Drug details tab starts-->\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t<div id=\"drugDetailsIvRxScroller\" class=\"row ivrxDetailsViewContentRowWrapper1\"  data-role = \"none\">\n\t                               \t\t<div class=\"detailsViewMainWrapper\">\n\t\t\t\t\t\t\t\t\t\t   <div class=\"ivrxDrugHeader segoeuiBold\">\n\t\t\t\t\t\t\t\t\t\t\t     Additive(s)/Drugs\n\t\t\t\t\t\t\t\t           </div>\n\t\t\t\t                           ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t    \t<div class=\"detailsViewWrapper\" style=\"border-bottom:1px solid #e4e8ec;\">\n\t\t\t\t\t\t\t\t\t\t\t    <!--div style=\"height:30px;font-family: Segoe UI Semibold;font-size: 15px;color: #096b93;\">\n\t\t\t\t\t\t\t\t\t\t\t     Additive(s)/Drugs\n\t\t\t\t\t\t\t\t\t\t        </div-->\n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"ivWithAdditiveTabCss segoeuiBold paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t\t        <div style=\"float:left;margin-top: 6px;padding-right: 10px;\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"float:left;\">\t\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="                                        \n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"pharmRxOrderItemIconsVRalign\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/images/externalDatabase25X25.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span id=\"span_beyondDoseLimit_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" name=\"span_beyondDoseLimit_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" class=\"pharmRxOrderItemIconsVRalign\" style=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =";\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/beyondDoseLimit25X25.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span id=\"span_duplicateDrug_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" name=\"span_duplicateDrug_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" class=\"pharmRxOrderItemIconsVRalign\"  style=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/eIPAD/images/duplicateDrug25X25.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span id=\"span_allergy_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" class=\"pharmRxOrderItemIconsVRalign\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/eIPAD/images/pharmAllergy25X25.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"pharmRxOrderItemIconsVRalign\" style=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/eIPAD/images/authorizeRxDet25X25.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" class=\"BannerIndicators\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t                                        \t<span class=\"pharmRxOrderItemIconsVRalign\" style=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="/eIPAD/images/cosignRxDet25X25.png\" class=\"imgBannerIndicator\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"pharmRxOrderItemIconsVRalign\" style=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =";padding-right:10px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="/eIPAD/images/Specialapproval.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" class=\"BannerIndicators\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:flex;\" class=\"paddingLeftRight10px\" style=\"padding-right:8px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ivrxContainer\" style=\"padding-right:1px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingTopBottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Calculate By\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t                                <select class=\"dropDown ivWidth99Important\" id=\"ivrxWithAddCalcBy_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" disabled onchange=\"onSelectCalculateBy(";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =", \'onchange\')\">\n\t\t\t\t\t\t                                  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t                                </select>  \n\t\t\t\t\t\t                                ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" onchange=\"onSelectCalculateBy(";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n                                                    <div id=\"enabledOnDosage";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" class=\"ivrxContainer\" style=\"padding-left:1px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"IVrxLabel segoeuiBold paddingTopBottom\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Dosage By\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t                                   <select class=\"dropDown ivrxDosageByCss ivWidth99Important\" id=\"ivrxWithAddDosageBy_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" name=\"dosage";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onchange=\"onSelectDosageBy(";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =", \'onchange\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t                                   </select>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t \t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"disabledOnBodyWt";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" class=\"ivrxContainer\" style=\"display:none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"IVrxLabel segoeuiBold paddingTopBottom\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Dosage By\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t                                   <select class=\"dropDown ivrxDosageByCss ivWidth99Important\" id=\"disabledOnBodyWt_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t\t\t                                 \t  \n\t\t\t\t\t                                   </select>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"dynamicContentWrapper\" style=\"padding-bottom:15px;\" class=\"paddingLeftRight10px ivWithAddDynamicContentWrapperCss onOrientationChangeDynamicWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t    <div id=\"doseDetailsWrapper_Strength";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" class=\"doseDetailsWrapperCss\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseLabel\" style=\"height:35%;width:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"IVrxLabel segoeuiBold\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <span>Strength</span><font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseInput\" style=\"height:65%;width:100%;padding-top: 0.8px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div style=\"width:49.5%;float:left;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"ivrxWithAddDrugUnit k-textbox\" style=\"height: 43px;width: 98%;\" id=\'id_qty_value_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onchange=\"DosageLimitCheck(this, ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =")\" maxlength=\"11\" onKeyPress=\"allowValidNumber(this,event,8,2);\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div style=\"width:49.6%;float:left;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"interDurationTime\" id=\"dosageUnitIvwithAdd_strength";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t                                                   <select class=\"dropDown ivWidth99Important\" id=\"ivWithAddDosageStrengthUnit_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t                                                      <OPTION VALUE=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' SELECTED>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</OPTION>\n\t\t\t                                                   </select>\n\t\t\t                                                  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div style=\"clear: both;\"></div> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t \t<div id=\"doseDetailsWrapper_Dose";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" style=\"display:none;\" class=\" doseDetailsWrapperCss\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseLabel\" style=\"height:35%;width:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"IVrxLabel segoeuiBold\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <span>Dose</span><font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseInput\" style=\"height:65%;width:100%;padding-top: 0.8px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div style=\"width:49.5%;float:left;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"ivrxWithAddDrugUnit k-textbox\" id=\"CALC_DOSE_VALUE_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"  style=\"height:43px;width:98%;\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" onChange=\"DosageLimitCheck(this, ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =");\" maxlength=\"11\" onKeyPress=\"allowValidNumber(this,event,8,2);\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div style=\"width:49.6%;float:left;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"interDurationTime\" id=\"dosageUnitIvwithAdd_qty\">\n\t\t\t                                                    <select class=\"dropDown ivWidth99Important\" id=\"ivWithAddDosageUnit_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t                                                    ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" > ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" </OPTION>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t                                                    </select>\n\t\t\t                                                  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div style=\"clear: both;\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseDetailsWrapper_OnBodyWt";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" style=\"display:none\" class=\"table doseDetailsWrapperCss\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseLabel\" class=\"row fullWtHalfHt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell IVrxLabel segoeuiBold fullHtHalfWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <span>Dose<font class=\"rxMandatorIndi\">*</font></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseInput\" class=\"row fullWtHalfHt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"ivrxWithAddDrugUnit k-textbox\" id=\"CALC_DOSE_VALUE_OnBodyWt";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" onchange=\"calculateDosage_By_BSA_or_Weight(";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =");\" maxlength=\"7\" onKeyPress=\"allowValidNumber(this,event,3,3);\" style=\"height:43px;width:98%\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell detailsCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"interDurationTime\" id=\"bodyWtUnitIvwithAdd\">\n\t\t\t                                                   <select class=\"dropDown ivWidth99Important\" id=\"bodyWtDoseValues_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</OPTION>\n\t\t\t                                                   </select>\n\t\t\t                                                  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ivWithAdddoseRemarksField";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" style=\"width:49.8%;height: 65px;float: left;\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <div style=\"width:100%;height: 35%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"IVrxLabel segoeuiBold\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Remarks\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ivWithAdddoseUnitInput\" style=\"height:65%;width:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div style=\"width:100%;height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \t\t<textarea class=\"k-textbox\" id=\"drugRemTextarea_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" maxlength=\"40\" style=\"height:57px;width:100%;\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ivWithAdddoseUnitsWrapper";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" style=\"display:none;\" class=\"table ivInterDoseUnitWrapper\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"row fullWtHalfHt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"cell fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ivWithAdddoseUnitInput\" class=\"row fullWtHalfHt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"table\" style=\"width:49.4%;height:100%;float:left;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"row fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"cell\" style=\"width:99%;height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"interDurationTime\" id=\"dosageUnitIvwithAddDetails\" >\n\t\t\t                                                         <select class=\"dropDown ivWidth99Important\" id=\"ivWithAdddosageUnitDetails_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =");\">\n\t\t\t                                                           ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t                                                         </select>\n\t\t\t                                                        </div>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t         </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"cell ivInterEqualTo\" >\n\t\t\t                                                        = \t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t                                                  </div>  \t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"table ivInterDoseMG\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"row fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        <div class=\"cell fullHtHalfWt\" >\n\t\t\t                                                         <input type=\"text\" id=\"ivrxDoseDrugUnit";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" name=\"ivrxDoseDrugUnit";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" class=\"ivrxDoseDrugUnit1 k-textbox\" style=\"height:43px;width:99%\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =");\"/> \t\t\t                                                        \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pharHtWtTextboxDurnUnit\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</div> \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t            </div>\t\t\t\t\t\t\t\t\t\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ivWithAddDrugIndications_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" style=\"padding-top:20px;\" class=\"textareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Drug indications\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea id=\"txtDrugIndi_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" class=\"k-textbox\" maxlength=\"255\" style=\"height:57px;width:99%;\">";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ivWithAddAllergyOveride_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" class=\"textareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Allergy override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                 </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t         <textarea class=\"k-textbox\" id=\"txtAllergy_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" maxlength=\"255\" style=\"height:57px;width:99%;\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ivWithAddDuplicateOveride_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" class=\"textareaWrapper\" style=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="; padding-top:20px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Duplicate drug override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t\t                                                    </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <textarea class=\"k-textbox\" id=\"txtDupDrug_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ivrxBeyondDosageOvverride_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" class=\"table textareaWrapper\" style=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t       <div class=\"row fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"cell positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Beyond dosage limit override reason<font class=\"rxMandatorIndi\">*</font>\n\t\t                                                     </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <textarea class=\"k-textbox\" id=\"txtBeyDosLimit_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" name=\"drugDesc";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" id=\"drugDesc";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" name=\"drug_code";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"  id=\"drug_code";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" name=\"strength";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" id=\"strength";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" name=\"qtyDesc";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" id=\"qtyDesc";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" name=\"qty_value";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" id=\"qty_value";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" name=\"strength_uom_desc";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" id=\"strength_uom_desc";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" name=\"dosage_type";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" id=\"dosage_type";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" name=\"qty_desc_code";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" id=\"qty_desc_code";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" name=\"start_date";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" id=\"start_date";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" name=\"strength_uom";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" id=\"strength_uom";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" name=\"strength_value";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" id=\"strength_value";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" name=\"strength_per_pres_uom";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" id=\"strength_per_pres_uom";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" name=\"pres_qty_value";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" id=\"pres_qty_value";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" name=\"ORDERSET_STRENGTH";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id=\"ORDERSET_STRENGTH";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t<input TYPE=\"hidden\" name=\"STR_VAL_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" id=\"STR_VAL_";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t<input TYPE=\"hidden\" name=\"calc_dose_value";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" id=\"calc_dose_value";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" />\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<input TYPE=\"hidden\" name=\"UOM_CODE_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" id=\"UOM_CODE_";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" VALUE=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" name=\"mode\" />\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_product_id_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" id=\"external_product_id_";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"SRL_NO_";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" id=\"SRL_NO_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"LIMIT_IND_";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" id=\"LIMIT_IND_";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"DAILY_DOSE_";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" id=\"DAILY_DOSE_";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"UNIT_DOSE_";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" id=\"UNIT_DOSE_";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"MONO_GRAPH_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"MONO_GRAPH_";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"MIN_DAILY_DOSE_";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" id=\"MIN_DAILY_DOSE_";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"MIN_UNIT_DOSE_";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" id=\"MIN_UNIT_DOSE_";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"CURRENT_RX_";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" id=\"CURRENT_RX_";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"ALLERGY_YN_";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" id=\"ALLERGY_YN_";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"strength_per_value_pres_uom_";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" id=\"strength_per_value_pres_uom_";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"pres_base_uom_";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" id=\"pres_base_uom_";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"drugCount\" value =\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t\t\t\t\t\t\t<!-- Fluid details STARTS -->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t<input type=\"hidden\" name=\"form_code\" id=\"form_code\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t\t<input type=\"hidden\" name=\"route_code\" id=\"route_code\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t<input type=\"hidden\" name=\"base_uom\" id=\"base_uom\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"eqvl_uom_value\" id=\"eqvl_uom_value\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t\t\t<input type=\"hidden\" name=\"STOCK_VALUE\" id=\"STOCK_VALUE\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t<input type=\"hidden\" name=\"DRUG_VOLUME\" id=\"DRUG_VOLUME\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"STOCK_UOM_CODE\" id=\"STOCK_UOM_CODE\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t\t\t<input type=\"hidden\" name=\"BASE_VOLUME\" id=\"BASE_VOLUME\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_type_flag1\" id=\"order_type_flag1\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_set_code\" id=\"order_set_code\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t\t<input type=\"hidden\" name=\"mfr_yn\" id=\"mfr_yn\" value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>\n\t\t\t<input type=\"hidden\" name=\"mfr_remarks\" id=\"mfr_remarks\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t<input type=\"hidden\" name=\"back_date\" id=\"back_date\"\t\tvalue=\"\">\t\t\t\t\t\t\t\t\t\n\t\t                                    <div id=\"ivWithAddFluidDetailsWrapper\"  class=\"interFluidDetailWrapper\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ivWithAddFluidDetailsContent\" class=\"withAddFluidDetailContent\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"interFluidLabel segoeuiBold\">\n\t\t\t\t\t\t\t\t\t\t\t\t     Fluid Details\n\t\t\t\t\t\t\t\t\t\t\t        </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:flex;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Fluid<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t                                            <div id=\"fluidNameIvWithAdd\" class=\"fullWidth\">\n\t\t\t\t                                                    <select id=\"fluidNameIvWithAddValues\" class=\"ivWidth100Important\" style=\"height:43px;\" name=\"fluidNameIvWithAddValues\" id=\"fluidNameIvWithAddValues\" onchange=\"changeFluid(this)\">  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t                                                          \t\t<OPTION id=\"fluid_desc";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" selected>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="</OPTION> \n\t\t\t\t                                                        ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<OPTION id=\"fluid_desc";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</OPTION>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="                                   \n\t\t\t\t                                                    </select>\n\t\t\t\t                                            </div>  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div style=\"width: 0.6%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t     </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Volume<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t                                            <div class=\"interInputWrap\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pharContentKgLabel fullWidth\">\n\t\t\t\t                                            \t\t<input type=\"text\" class=\"k-textbox\"  style=\"width:99.5%;height:43px;\" id=\"volume\" maxlength=\"5\" name=\"volume\" id=\"volume\" onblur=\"setStockValue(this)\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<div class=\"pharHtWtTextboxUnit\" style=\"right:2%\" id=\"stock_display\" name=\"stock_display\">";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<!-- check for lable --> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t                                            </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t                                        \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:flex;\" class=\"paddingLeftRight10px\">\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t  \t<div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t<div class=\"IVrxLabel segoeuiBold paddingBottom5px\" style=\"padding-top:3px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \t\tIV Admixture\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"interInputWrap\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input style=\"height: 20px;width: 20px;\"  type=\"checkbox\" name=\"admixture\" id=\"admixture\" value=\'Y\' disabled />\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t                                            </div> \n\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:1.5%\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingBottom5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Build MAR\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t                                            <div class=\"interInputWrap\" style=\"padding-top:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input style=\"height: 20px;width: 20px;\" id=\"build_mar\" name=\"build_mar\" id=\"build_mar\" type=\"checkbox\" ";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =" ";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t                                        </div>\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<!-- Fluid details ENDS -->\n\t                               \t\t</div> \n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_interface_yn\" id=\"drug_db_interface_yn\" id=\"drug_db_interface_yn\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"> \n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"> \n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"> \n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t \t<!-- Drug Details Tab ends -->\t\t\t\t\t\t\t\t \t\n\t\t\t\t\t\t\t\t<!-- Admin Details Tab Starts -->\n\t                            <div id=\"administrationDetailsIvRxScroller\" class=\"row selectPharmOrder pharmOrderIVRxItemContainer\"  data-role = \"none\">\n\t                                <div class=\"detailsViewMainWrapper\" >\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t    <div class=\"fullWidth\">\t   \t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t        <div style=\"display:flex;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingTopBottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t   Infusion rate<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t <div id=\"ivWithAdddoseDetailsWrapper\" class=\"table ivInterDoseDetailsWrapper\" >\n\t                                           <div id=\"\" class=\"row fullWtHalfHt\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\" style=\"\">\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"ivrxWithAddInfuseRateUnit k-textbox\" name=\"infuse_rate\" id=\"infuse_rate\" size=\"1\" maxlength=\"10\" onblur=\"setInfuseOverValue();\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" style=\"height:43px;width:98%;\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"pharHtWtTextboxUnit\" name=\"infusion_uom_display\"  id=\"infusion_uom_display\" style=\"right:14px;\">";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</div>   \n\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   <div id=\"divider\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"row fullWtHalfHt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"cell dividerContent\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div id=\"\" style=\"left:-5.5px;top:14px;position:absolute;\" class=\"\" >/</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell detailsCell\">\t\t\t\t\t\t\t\t\t\t\t\t      \n\t\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"dropDown\" id=\"\" style=\"width:100%;height:36px;\">\n\t                                                    <select style=\"width: 100%\" id=\"ivrxWithAddInfusionRateUnit\" onchange=\"setInfuseOverValue();\" name=\"infuse_rate_unit\" id=\"infuse_rate_unit\">\n\t                                                       ";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="                                            \n\t                                                    </select>\n\t                                                  </div>\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\n\t\t\t\t\t\t\t\t\t\t\t </div> \n\t\t\t\t\t\t\t\t\t\t\t <div style=\"width:0.2%;\"></div>\n\t\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-top:10px;padding-bottom:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t   Infuse over<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseDetailsWrapper\" class=\"table interDurationRepeat\">\n\t                                               <div id=\"doseInput\" class=\"row fullWtHalfHt\">\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"k-textbox ivRxWithAddInfuseOverInput\" style=\"height:43px;width:98%;\" id =\"INFUSION_PERIOD_VALUE_WA_HRS\" name=\"INFUSION_PERIOD_VALUE\" id=\"INFUSION_PERIOD_VALUE\" onchange=\"setInfuseRateValue();\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" maxlength=\"2\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"pharHtWtTextboxUnit\" style=\"right:11px;\">Hrs</div> \n\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell detailsCell\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"k-textbox ivRxWithAddInfuseOverInput\" style=\"height:43px;width:99%;\" id=\"INFUSION_PERIOD_VALUE_WA_MINS\" name=\"INFUSION_PERIOD_VALUE_MIN\" id=\"INFUSION_PERIOD_VALUE_MIN\" onchange=\"setInfuseRateValue();\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" maxlength=\"2\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"pharHtWtTextboxUnit\" style=\"right:11px;\">mins</div> \n\t\t\t\t\t\t\t\t\t\t\t\t\t   <div id=\"infuse_over_str\" class=\"infuseOverCss\" style=\"\" name=\"infuse_over_str\">";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</div>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div> \n\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t                                        </div>\t \t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t    <div style=\"display:flex;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingTopBottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t   Duration for repeat<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t                                            <input style=\"width:99% ! important;height:43px;\" class=\"ivrxDosageByCss k-textbox\"  onchange=\"chkDuration();\"  type=\"text\" id=\"ivrxDosageBy\" maxlength=\"2\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pharHtWtTextboxDurnUnit\">Hours</div> \n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:flex;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"IVrxLabel segoeuiBold paddingTopBottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t   Start date and time<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t                                            <input style=\"width:99% ! important\" class=\"dropDown\" onchange=\"changeStartDate(this);\" id=\"ivrxWithAddAdminStartDate\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" />  \n\t\t\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t  <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold paddingTopBottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t   End date and time<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t                                            <input style=\"width:99% ! important;\" class=\"dropDown ivrxDosageByCss\" type=\"text\" id=\"ivrxWithAddAdminAdminEndDate\"  value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" maxlength=\"8\" value=\"0\" disabled/>\n\t\t\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t    </div>\t\t\t\t\t\t\t\t\t\n\t                                    </div>\n\t                                </div>\t\n\t                            </div>\n\t\t\t\t\t\t\t\t <!-- Admin Details Tab Ends -->\n\t\t\t\t\t\t\t\t<!-- Pharmacy legend starts -->\n\t\t\t\t\t\t\t\t<div id=\"ivRxWithAddLegend\"></div>\n\t\t\t\t\t\t\t\t<!-- Pharmacy legend ends --> \n\t                        </div>\t\t\t\t\t\t   \t  \n\t                      </div>\t\t\t\t\t\t\n\t                    </div>\n\t                </div>\n\t               </div>\n            </div> \t\t\n        <input type=\"hidden\" name=\"INFUSION_UOM\" id=\"INFUSION_UOM\" value=\"\">\n        <input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\"/>\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" name=\"ph_version\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" name=\"facility_id\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" name=\"patient_id\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" name=\"patient_class\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" name=\"encounter_id\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" name=\"resp_id\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" name=\"pract_id\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" name=\"location_code\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" name=\"location_type\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" name=\"bl_install_yn\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" name=\"start_date_fluid\" id=\"start_date_fluid\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" name=\"end_date_fluid\" id=\"end_date_fluid\" />        \n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" name=\"bean_id_IVD\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" name=\"bean_name_IVD\" />\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" name=\"mode\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\" name=\"trade_code\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" name=\"max_duration\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" name=\"iv_calc_infuse_by\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" name=\"FUTURE_DATE\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\" name=\"locale\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" name=\"sys_date\" />\n\t\t<input type=\"hidden\" name =\"bl_disp_charge_dtl_in_rx_yn\" id =\"bl_disp_charge_dtl_in_rx_yn\" value = \"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" name=\"infusion_over_insert_value\" />\n\t\t<INPUT TYPE=\"hidden\" name=\"FREQUENCY\" id=\"FREQUENCY\" VALUE = \'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\'>\n\t\t<input type=\"hidden\" name=\"freq_desc\" id=\"freq_desc\" value=\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\' >\n\t\t<input type=\"hidden\" name=\"ORDER_TYPE_CODE\" id=\"ORDER_TYPE_CODE\" value=\'PHR\' >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" name=\"END_DATES\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" name=\"START_DATES\" />\n\t\t<input type=\"hidden\" name=\"INFUSION_VALUE_WITHOUT_ROUND\" id=\"INFUSION_VALUE_WITHOUT_ROUND\" value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\" name=\"drugCodes\" />\n\t\t<input type=\"hidden\" value=\"R\" name=\"priority\" id=\"priority\" />\n\t\t<input type=\"hidden\" value=\"\" name=\"take_home_medication\" id=\"take_home_medication\" />\n\t\t<input type=\"hidden\" id = \"typeOfHWcheckWithAdd\" value=\"\" name=\"typeOfHWcheck\" id=\"typeOfHWcheck\" />\t\t\t\t\n\t\t<input type=\"hidden\" name=\"INFUSION_PERIOD_UOM\" id=\"INFUSION_PERIOD_UOM\" value=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\' >\t\t\n\t\t<!--Selected element ID for Height and weight -->\n\t\t<input type=\"hidden\" name=\"valueOfSelectedElem\" id=\"valueOfSelectedElem\" id=\"valueOfSelectedElem\" value=\"\">\n\t\t<div class=\"CSTransactionMessage\" id=\"transactionMsg1\" style=\"background-color:#bd362f;bottom: 45px; left: 10px; display: none;z-index:900002;\">\n\t\t\t<img style=\"padding-left:15px;vertical-align:middle;\" src=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="/eIPAD/images/PopError.png\" onclick=\"closeToast()\"/>\n\t\t\t<span class=\"rxToastmsg\" id=\"contentRxToastMsg1\">No records found</span>\n            <div class=\"formValErrorMsgTheme\" id=\"transactionMessageContent1\"></div>\n        </div>\t\t\n\t\t<div id=\"confirmMsg\" class=\"absoluteCenter\" style=\"z-index: 10005;\">\n\t\t\t<div class=\"Error_Window\">\n\t\t\t\t<div class=\"Error_msg_box\">\n\t\t\t\t<div class=\"Error_msg\">\n\t\t\t\t\t<div class=\"Error_msg_Frame\">\n\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t<div class=\"Error_icon\"><img src=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="/eIPAD/images/OrderPopConfirm.png\" width=\"30\" height=\"30\"> </div>\n\t\t\t\t\t\t\t<div class=\"Error_cont\" id=\"ClinicalNotesConfirmDialogMsg\">Are you sure you wish to cancel the current operation?</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t<div class=\"Error_msg_btn\">\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"okClick\" onclick=\"okClickDialog()\">OK </div>\n\t\t\t\t<div class=\"Error_btn_div\"> </div>\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"cancelClick\" onclick=\"cancelClickDialog()\" data-value=\"true\">Cancel </div>\n\t\t\t</div>\n\t\t\t<div class=\"top_shadow\"> </div>\n\t\t\t</div>\n\t\t</div>\n    </form>\n</div>\n\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );
	
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
	String dose_uom = "";
	String pres_base_uom = "";
	String locale			= (String)session.getAttribute("LOCALE");
	Locale appLocale;
	if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
	else 
	appLocale = new Locale("en");
	ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 	
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
	String selected_drug_codes = "";
	String ph_version =	(String)PhLicenceRights.getKey();
	String facility_id = patientContext.getFacilityId();
	String patient_id = patientContext.getPatientId();
	String patient_class = patientContext.getPatientClass();
	String encounter_id = patientContext.getEncounterId();
	String resp_id = patientContext.getResponsibilityID();
	String pract_id = patientContext.getClinicianId();
	String location_code = patientContext.getLocationCode();
	String location_type = patientContext.getLocationType();	
	String infuse_overs="";
	String infuse_over_hrs="";
	String  infuse_over_mis="";
	String  infusion_rates="";
	String  infuse_over_unitss="";
	String  duration_drun="24";
	String START_DATE ="";
	String END_DATE ="";
	String VOLUME_VALUE="";
	String disp_strs ="";	
	String bl_install_yn = (String) session.getValue( "bl_operational" )==null?"N":(String) session.getValue( "bl_operational" ) ;
	String mode		= CommonRepository.getCommonKeyValue( "MODE_INSERT" ); 
	String sys_date = "";		
	String bean_id_IVD		= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
	String bean_name_IVD	= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean_IVD	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
	bean_IVD.setLanguageId(locale);
	bean_IVD.setPatId(patient_id);
	bean_IVD.setEncId(encounter_id);	
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();	
	HashMap drug_detail =	null;
	HashMap fluid_details = null;	
	ArrayList	presDetails	= (ArrayList) bean_IVD.getDrugDetails();	
	HashMap drugDetails			= (HashMap)presDetails.get(0);
	fluid_details = bean_IVD.getFluidDetails();
	String disp_location;
	if(fluid_details.get("DISP_LOCN_DESC") == null){
		disp_location = (String)drugDetails.get("DISP_LOCN_DESC");
	}else{
		disp_location = (String)fluid_details.get("DISP_LOCN_DESC");
	}
	VOLUME_VALUE=bean_IVD.getVOLUME();
	String  iv_calc_infuse_bys=bean_IVD.getIVCalcInfuseBy();
	if(iv_calc_infuse_bys.equals("I"))
		duration_drun = "24";
	else
		duration_drun = (String)fluid_details.get("DURN_VALUE");			
		String  END_DATES  =	(String)fluid_details.get("END_DATE")==null?"":(String)fluid_details.get("END_DATE");
		String  START_DATES= (String)fluid_details.get("START_DATE")==null?"":(String)fluid_details.get("START_DATE");	
     infuse_overs=	(String)fluid_details.get("SCH_INFUSION_RATE")==null?"":(String)fluid_details.get("SCH_INFUSION_RATE");	
	infuse_over_hrs =(String)fluid_details.get("INFUSION_PERIOD_VALUE")==null?"":(String)fluid_details.get("INFUSION_PERIOD_VALUE");	
	infuse_over_mis = (String)fluid_details.get("INFUSION_PERIOD_VALUE_MIN")==null?"":(String)fluid_details.get("INFUSION_PERIOD_VALUE_MIN");	
	infusion_rates = (String)fluid_details.get("INFUSION_RATE")==null?"":(String)fluid_details.get("INFUSION_RATE");	
	infuse_over_unitss =(String)fluid_details.get("INFUSE_OVER_UNIT")==null?"":(String)fluid_details.get("INFUSE_OVER_UNIT");		
	disp_strs="["+infuse_over_hrs+" Hrs "+infuse_over_mis+" Mins]";	
	String iv_calc_infuse_by=bean_IVD.getIVCalcInfuseBy();	
	sys_date=(String) bean_IVD.getSysdate();
	/* Loading default values into kendo dropdowns */
	String calculateByValues = "";
	String admix_value = "N";
	calculateByValues = calculateByValues + "<OPTION VALUE='D' SELECTED>Dosage</OPTION>";
	calculateByValues = calculateByValues + "<OPTION VALUE='B'>Body wt/BSA</OPTION>"; 	
	String dosageByValues = "";
	dosageByValues = dosageByValues + "<OPTION VALUE='S' SELECTED>Strength</OPTION>";
	dosageByValues = dosageByValues + "<OPTION VALUE='Q'>Quantity</OPTION>"; 	
	String dosageUnitValues = "";
	dosageUnitValues = dosageUnitValues + "<OPTION VALUE='P' SELECTED>Vial(s)</OPTION>";
	dosageUnitValues = dosageUnitValues + "<OPTION VALUE='S' SELECTED>VIAL</OPTION>";
    String dosageStrengthValues = "";
	dosageStrengthValues = dosageStrengthValues + "<OPTION VALUE='M' SELECTED>MG</OPTION>";	
	String bodyWtDoseValues = "";
	bodyWtDoseValues = bodyWtDoseValues + "<OPTION VALUE='M' SELECTED>MG</OPTION>";			
	String dosageUnitDetailedValues = "";	
	/* Loading default values into kendo dropdowns ends */

	int durn_int = Integer.parseInt(duration_drun);
	
	 if(durn_int==0){
		
		duration_drun="24";
		
	} 
	
	/* Banner Indicator Starts */
	String drugDesc ="";
	ArrayList frequencyDetails = bean_IVD.getFrequency();
	String freq_code = "";
	String freq_desc = "";
	if(frequencyDetails.size() > 0){
		freq_code = (String)frequencyDetails.get(0);
		freq_desc = (String)frequencyDetails.get(1);
	}	
	String bl_disp_charge_dtl_in_rx_yn	= "N";	
	String drug_db_interface_yn			= "N";
	String drug_db_product_id			= "";
	String drug_db_dosecheck_yn			= "N";
	String drug_db_duptherapy_yn		= "N";
	String drug_db_interact_check_yn	= "N";
	String drug_db_contraind_check_yn	= "N";
	String drug_db_allergy_check_yn		= "N";	
	String ex_bean_id				= "@ExternalProductLinkBean";
	String ex_bean_name				= "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean beanex  = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);	
	String param_bean_id				= "@DrugInterfaceControlBean";
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );	
	String[] sDrugDBAllChecks = param_bean.drugDBALLChecksYN(facility_id);
	if(sDrugDBAllChecks != null && sDrugDBAllChecks.length>6){
		drug_db_interface_yn			=	sDrugDBAllChecks[0];    
		drug_db_product_id			=	sDrugDBAllChecks[1];    
		drug_db_dosecheck_yn			=	sDrugDBAllChecks[2];    
		drug_db_duptherapy_yn		=	sDrugDBAllChecks[3];    
		drug_db_interact_check_yn	=	sDrugDBAllChecks[4];      
		drug_db_contraind_check_yn	=	sDrugDBAllChecks[5];    
		drug_db_allergy_check_yn		=	sDrugDBAllChecks[6];    
	}
	param_bean.clear();			
	ArrayList exProd				= new ArrayList();
	ArrayList aDrugDesc				= new ArrayList();
	HashMap details = null;	
	String FUTURE_DATE = "";
	for(int k=0;k<presDetails.size();k++){
		drug_detail				=   (HashMap) presDetails.get(k);
		String ext_srl_no				=   (String) drug_detail.get("SRL_NO");
		if(!exProd.contains((String)drug_detail.get("EXTERNAL_PRODUCT_ID"))){
			aDrugDesc.add((String)drug_detail.get("DRUG_DESC"));
			if((String) drug_detail.get("EXTERNAL_PRODUCT_ID")!=null && !((String) drug_detail.get("EXTERNAL_PRODUCT_ID")).equals("")){
			       exProd.add((String)drug_detail.get("EXTERNAL_PRODUCT_ID"));
			}
		}
		FUTURE_DATE = (String)drug_detail.get("FUTURE_DATE");	
	}
	
	HashMap   record = new HashMap();
	String infusion_rate		= "";
	String infuse_over			= "";
	String duration				= "24";
	String start_time			= "";
	String end_time				= "";
	String disabled				= "";
	String order_line_num		= "";
	String QTY_UNIT				= "";
	String renewOrderStartDate  = "";
	String selected1  = "selected";
	String selected2  = "";
	String timeFrame			= "";
	String infusion_period_uom ="H"; 
	String mfr_yn				= "";
	String disable_for_mfr		= "";
	String infuse_over_hr		= "";
	String infuse_over_mi		= "";
	String disp_str				= "";
	String infusionOverUnit		= "";	
	ArrayList exstngIVOrders = bean_IVD.getAllExistingIVOrders();
	if(exstngIVOrders.size() > 0) {
	record = (HashMap)exstngIVOrders.get(0);
	start_time = (String)record.get("START_DATE_TIME");
	end_time = (String)record.get("END_DATE_TIME");
	order_line_num = (String)record.get("ORDER_LINE_NUM");
	mfr_yn = (String)record.get("MFR_YN")==null?"":(String)record.get("MFR_YN");
	if(!mfr_yn.equals("Y")){
		infusion_rate = (String)record.get("INFUSION_RATE");
		infuse_over = (String)record.get("INFUSE_OVER");
		if(!infusion_rate.equals("")){
			if(Float.parseFloat(infusion_rate)<1 && Float.parseFloat(infusion_rate)>0)
			infusion_rate=Float.parseFloat(infusion_rate)+"";
		}
		if(infuse_over.indexOf(".") != -1){
			infuse_over_hr = infuse_over.substring(0,infuse_over.indexOf("."));
			Double temp = new Double(infuse_over);
			temp = temp*60;
			temp = (temp%60);
			infuse_over_mi = Math.round(temp)+"";
			if(infuse_over_mi.indexOf(".") != -1)
				infuse_over_mi = infuse_over_mi.substring(0,infuse_over_mi.indexOf(".")); 
		}
		else{
			infuse_over_hr = infuse_over;
			infuse_over_mi = "";
		}
		infuse_over_hr = infuse_over_hr.equals("")?"0":infuse_over_hr;
		infuse_over_mi = infuse_over_mi.equals("")?"0":infuse_over_mi;
		disp_str = "["+infuse_over_hr+" Hrs "+infuse_over_mi+" Mins]";
		if(iv_calc_infuse_by.equals("I"))
			duration = "24";
		else
			duration = (String)record.get("DURN_VALUE");		
		QTY_UNIT  = (String)record.get("QTY_UNIT")==null?"":(String)record.get("QTY_UNIT");
		if(!QTY_UNIT.equals("")) 
			QTY_UNIT = QTY_UNIT+" / ";
		infusion_period_uom				=(String)record.get("INF_PERIOD_UNIT")==null?"H":(String)record.get("INF_PERIOD_UNIT");

		if(infusion_period_uom.equals("H")){
			selected2="";
			selected1="selected";
			infusionOverUnit="Hour(s)";
			infusion_period_uom="H";
		}
		else  if(infusion_period_uom.equals("M")){ 
			selected1="";
			selected2="selected";
			infusionOverUnit="Minute(s)";
		}
	}
	else{
		disable_for_mfr = "disabled";
		if(iv_calc_infuse_by.equals("I"))
			duration="24";
		else
			duration = (String)((HashMap)bean_IVD.getMFRRecs()).get("totDurnHrs");
	}
	}	
	String infusionRateDetails = "";
	//System.out.println("infuse_over_unitss : " + infuse_over_unitss);
	if(infuse_over_unitss.equals("M")) {
		infusionRateDetails = infusionRateDetails + "<OPTION VALUE='M' selected>Minute(s)</OPTION>";
		infusionRateDetails = infusionRateDetails + "<OPTION VALUE='H'>Hour(s)</OPTION>";
	}
	else {
		infusionRateDetails = infusionRateDetails + "<OPTION VALUE='M'>Minute(s)</OPTION>";
		infusionRateDetails = infusionRateDetails + "<OPTION VALUE='H' selected>Hour(s)</OPTION>";
	}
	if(infuse_over.equals("")) {
		infuse_over = bean_IVD.getINFUSE_OVER();
	}	
	/* Banner Indicator Ends */

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(disp_location));
            _bw.write(_wl_block8Bytes, _wl_block8);

				                           	if(presDetails.size()>0){
												for(int i=0;i<presDetails.size();i++){													
													dosageUnitDetailedValues = "";
				                           			drug_detail = (HashMap) presDetails.get(i);
													drugDesc = (String)drug_detail.get("SHORT_DESC"); 
													String strength = (String)drug_detail.get("ACT_STRENGTH_VALUE");
													String qtyDesc = (String)drug_detail.get("QTY_DESC"); 
													String qty_value = (String)drug_detail.get("QTY_VALUE");
													String strength_uom_desc	= (String)drug_detail.get("STRENGTH_UOM_DESC");
													String dosage_type			= (String)drug_detail.get("DOSAGE_TYPE");
													String qty_desc_code		= (String)drug_detail.get("QTY_DESC_CODE");
													String drug_code = (String)drug_detail.get("DRUG_CODE");
													String start_date = (String)drug_detail.get("START_DATE");
													String strength_uom = (String)drug_detail.get("STRENGTH_UOM");
													String strength_value = (String)drug_detail.get("STRENGTH_VALUE"); 
													String strength_per_pres_uom =  (String)drug_detail.get("STRENGTH_PER_PRES_UOM");
													String pres_qty_value		= (String)drug_detail.get("PRES_QTY_VALUE");
													pres_base_uom =  (String)drug_detail.get("PRES_BASE_UOM");
													String pres_base_uom_desc =  (String)drug_detail.get("PRES_BASE_UOM_DESC");
													String drug_remarks =  (String)drug_detail.get("DRUG_REMARKS")==null?"":(String)drug_detail.get("DRUG_REMARKS");
													String dosage_Type_values = "";
													String str_value	= qty_value;
													String STRENGTH = strength_value;
													if (strength_value.equals("0")) {
														dosage_Type_values += "<OPTION value='Q' > Quantity </OPTION>";
													}
													else {
														if(dosage_type.equals("Q")) {
															dosage_Type_values = "<OPTION value='S' > Strength </OPTION>";
															dosage_Type_values += "<OPTION value='Q' SELECTED > Quantity </OPTION>";
														}else{
															dosage_Type_values = "<OPTION value='S' SELECTED > Strength </OPTION>";
															dosage_Type_values += "<OPTION value='Q' > Quantity </OPTION>";
														}
													}
													String calc_dose_based_on	= (String)drug_detail.get("CALC_DOSE_BASED_ON");
													String calc_dose_by			= (String)drug_detail.get("CALC_DOSE_BY")==null?"":(String) drug_detail.get("CALC_DOSE_BY");
													if(calc_dose_based_on == null)
														calc_dose_based_on = "";
													calculateByValues = "";
													if(calc_dose_based_on.equals("B")) {
														calculateByValues = calculateByValues + "<OPTION VALUE='D'>Dosage</OPTION>";
														calculateByValues = calculateByValues + "<OPTION VALUE='B' SELECTED>Body wt/BSA</OPTION>"; 
													}
													else {
														calculateByValues = calculateByValues + "<OPTION VALUE='D' SELECTED>Dosage</OPTION>";
														calculateByValues = calculateByValues + "<OPTION VALUE='B'>Body wt/BSA</OPTION>"; 
													}													
													String calc_dose_value		= "";													
													if(calc_dose_by.equals("M2"))
													{
														dosageUnitDetailedValues = dosageUnitDetailedValues + "<OPTION VALUE='KG'>KG</OPTION>";
														dosageUnitDetailedValues = dosageUnitDetailedValues + "<OPTION VALUE='M2' SELECTED>M2</OPTION>";
													}
													else {
														dosageUnitDetailedValues = dosageUnitDetailedValues + "<OPTION VALUE='KG' SELECTED>KG</OPTION>";
														dosageUnitDetailedValues = dosageUnitDetailedValues + "<OPTION VALUE='M2' >M2</OPTION>";
													}													
/* Banner Indicator Starts */	
String display_auth_rule			= "display:none";
String color_auth_rule   			= "";
String allergy_yn					=	null;
String limit_ind					=	null;
String drug_db_dosage_check_flag	=  "N";
String drug_db_allergy_check_flag	=  "N";
String ext_prod_id					=	null;
String drug_desc					=	null;
String perform_external_database_checks_yn	=	"";	
ArrayList dosageCheckParams 		= null;
String frequency="", repeat_value="", interval_value="", dosage = "", strength_per_value_pres_uom="", dosage_by="";
String route_code	= "", repeat_durn_type	= "", freq_nature	= "", freq_nature_pas = "I";
String startdate="", enddate="";
String loading_ext_prod_id					=	"";
String srl_no						=	null;
String external_dosage_override_reason		=   "";	
String current_rx					=	null;
String drug_db_duptherapy_flag		=  "N";
String dup_drug_det					= "";
String count_rx				    =	null;
String external_database_overrided_yn	    =	"";	
String drug_db_interact_check_flag			=  "N";
String drug_db_contraind_check_flag			=  "N";
String external_interaction_override_reason	=   "";
String external_contra_override_reason		=   ""; 
String external_alergy_override_reason		=   ""; 
String external_duplicate_override_reason	=   "";
String external_database_overrided_reason	=	"";	
String weight           = request.getParameter("weight")==null?"":request.getParameter("weight");
String bsa              = request.getParameter("bsa")==null?"":request.getParameter("bsa");
allergy_yn							=	(String)drug_detail.get("ALLERGY_YN");
limit_ind							=	(String)drug_detail.get("LIMIT_IND");
drug_db_dosage_check_flag           = (String)drug_detail.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
ext_prod_id			    			=	(String)drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");

drug_desc				= (String)drugDetails.get("DRUG_DESC")==null?(String)drugDetails.get("SHORT_DESC"):(String)drugDetails.get("DRUG_DESC");

perform_external_database_checks_yn = drug_detail.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drug_detail.get("PERFORM_EXTERNAL_DATABASE_CHECKS");	
startdate							= (String)drug_detail.get("START_DATE");
enddate								= (String)drug_detail.get("END_DATE");
srl_no								= (String)drug_detail.get("SRL_NO");
external_dosage_override_reason		= (String) drug_detail.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")==null?"":(String) drug_detail.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
current_rx							= (String)drug_detail.get("CURRENT_RX");
external_duplicate_override_reason	= (String) drug_detail.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")==null?"":(String) drug_detail.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
external_interaction_override_reason= (String) drug_detail.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")==null?"":(String) drug_detail.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
external_contra_override_reason		= (String) drug_detail.get("EXTERNAL_CONTRA_OVERRIDE_REASON")==null?"":(String) drug_detail.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
external_alergy_override_reason		= (String) drug_detail.get("EXTERNAL_ALERGY_OVERRIDE_REASON")==null?"":(String) drug_detail.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
String ord_auth_reqd_yn		= (String) drug_detail.get("ORD_AUTH_REQD_YN")==null?"":(String) drug_detail.get("ORD_AUTH_REQD_YN");
String ord_spl_appr_reqd_yn	= (String) drug_detail.get("ORD_SPL_APPR_REQD_YN")==null?"":(String) drug_detail.get("ORD_SPL_APPR_REQD_YN");
String ord_cosign_reqd_yn	= (String) drug_detail.get("ORD_COSIGN_REQD_YN")==null?"":(String) drug_detail.get("ORD_COSIGN_REQD_YN");
String ord_authorized_yn	= (String) drug_detail.get("ORD_AUTHORIZED_YN")==null?"":(String) drug_detail.get("ORD_AUTHORIZED_YN");
String ord_authorized_prev_yn	= (String) drug_detail.get("ORD_AUTHORIZED_PREV_YN")==null?"":(String) drug_detail.get("ORD_AUTHORIZED_PREV_YN");
String ord_approved_yn		= (String) drug_detail.get("ORD_APPROVED_YN")==null?"":(String) drug_detail.get("ORD_APPROVED_YN");
String ord_cosigned_yn		= (String) drug_detail.get("ORD_COSIGNED_YN")==null?"N":(String) drug_detail.get("ORD_COSIGNED_YN");
String daily_dose			= (String)drug_detail.get("DAILY_DOSE");
String sch_over_yn				= (String)drugDetails.get("SCH_OVER_YN"); // saravanan
if(sch_over_yn==null)
	sch_over_yn		=	"N";
if(ext_prod_id==null)
	ext_prod_id		=	"";
String unit_dose			= (String)drug_detail.get("UNIT_DOSE")==null?"":(String)drug_detail.get("UNIT_DOSE");
String mono_graph			= (String)drug_detail.get("MONO_GRAPH")==null?"":(String)drug_detail.get("MONO_GRAPH");
String min_daily_dose		= (String)drug_detail.get("MIN_DAILY_DOSE")==null?"":(String)drug_detail.get("MIN_DAILY_DOSE");
String min_unit_dose		= (String)drug_detail.get("MIN_UNIT_DOSE")==null?"":(String)drug_detail.get("MIN_UNIT_DOSE");
String exceed_dose_desc		= (String)drug_detail.get("DOSE_REMARKS");
String dup_drug_desc		= (String)drug_detail.get("CURRENTRX_REMARKS");
String allergy_desc			= (String)drug_detail.get("ALLERGY_REMARKS");
String DrugIndicationRemarks= (String)drug_detail.get("DRUG_INDICATION")==null?"":(String) drug_detail.get("DRUG_INDICATION");
calc_dose_value				= (String)drug_detail.get("CALC_DOSE_VALUE")==null?"":(String) drug_detail.get("CALC_DOSE_VALUE");
strength_per_value_pres_uom = (String)drug_detail.get("STRENGTH_PER_VALUE_PRES_UOM");
loading_ext_prod_id				    = ext_prod_id;
if(mode.equals("amend") && count_rx != null && Integer.parseInt(count_rx) <=1){
	current_rx = "N";
	drug_detail.put("CURRENT_RX",current_rx);
}
if(perform_external_database_checks_yn.equals("Y") && !(ext_prod_id.equals("")) ){
	if(drug_db_duptherapy_yn.equals("Y")|| drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") || drug_db_dosecheck_yn.equals("Y") ){
		dosageCheckParams = null;
		if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y")){
			dosageCheckParams = new ArrayList();
			details = (HashMap) bean_IVD.getAllExistingIVOrders().get(0);
			dosage					   = (String)drug_detail.get("STRENGTH_VALUE");
			strength_per_value_pres_uom = (String)drug_detail.get("STRENGTH_PER_VALUE_PRES_UOM");
			strength_per_pres_uom       = (String)drug_detail.get("STRENGTH_PER_PRES_UOM");
			if(!(dosage.equals(""))){
				if(!(strength_per_value_pres_uom.equals(""))){
					dosage					   = (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
				}
				if(!(strength_per_pres_uom.equals(""))){
					dosage					   = (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
				}
			}
			dosage_by				   = (String)drug_detail.get("DOSAGE_TYPE");	
			if(dosage_by.equals(""))
				dosage_by = (String)bean_IVD.getDosage_type();

			if(details.get("INFUSE_OVER") == null || details.get("INFUSE_OVER").equals(""))
				details.put("INFUSE_OVER",(String)details.get("DURN_VALUE"));
		
			int freq	= 1;
			if( !( ((String)details.get("DURN_VALUE")).equals("") ) && !( ((String)details.get("INFUSE_OVER")).equals("") ) ){
				freq = (int)Math.ceil(Float.parseFloat((String)details.get("DURN_VALUE"))/Float.parseFloat((String)details.get("INFUSE_OVER")));
			}										
			dose_uom = "";
			if(dosage_by.equals("S"))
				dose_uom		    =	(String)drug_detail.get("STRENGTH_UOM");         
			else if(dosage_by.equals("Q"))
				dose_uom		    =	(String)drug_detail.get("PRES_BASE_UOM");	
			repeat_value     =   (String)drug_detail.get("REPEAT_VALUE")==null?"":(String)drug_detail.get("REPEAT_VALUE");
			interval_value	=	(String)drug_detail.get("INTERVAL_VALUE")==null?"":(String)drug_detail.get("INTERVAL_VALUE");		
			route_code	= (String)drug_detail.get("ROUTE_CODE")==null?"":(String) drug_detail.get( "ROUTE_CODE" );// Added in January 2014 for CIMS dosage check -start
			qty_desc_code= (String)drug_detail.get("QTY_DESC_CODE")==null?"":(String) drug_detail.get( "QTY_DESC_CODE" );
			repeat_durn_type	= drug_detail.get("REPEAT_DURN_TYPE")==null?"":(String) drug_detail.get( "REPEAT_DURN_TYPE" );
			freq_nature	= drug_detail.get( "FREQ_NATURE" )==null?"":(String) drug_detail.get( "FREQ_NATURE" );
			
			freq_nature_pas = "I";	  
			frequency	    =   "1";
			if(repeat_value != "" && interval_value != "")
				frequency = (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
			dosageCheckParams.add(patient_id);
			dosageCheckParams.add(loading_ext_prod_id);
			dosageCheckParams.add(weight);
			dosageCheckParams.add(bsa);
			dosageCheckParams.add(dosage);
			if(beanex!=null && (beanex.getProdID()).equals("CIMS"))  
				dosageCheckParams.add(qty_desc_code);	
			else
				dosageCheckParams.add(dose_uom);
			dosageCheckParams.add(freq+"");
			dosageCheckParams.add("1");
			dosageCheckParams.add(route_code);	 
			dosageCheckParams.add(repeat_durn_type);	 
			if(freq_nature!=null && !freq_nature.equals(""))
				freq_nature_pas =  freq_nature;
			dosageCheckParams.add(freq_nature_pas);	
			dosageCheckParams.add(interval_value);	 
		}
		HashMap tempDetails= null;
		HashMap drugDBCheckResult= null;
		ArrayList reqChecks = new ArrayList();
		if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y"))
			reqChecks.add("Y"); 
		else
			reqChecks.add("N"); 
		reqChecks.add(drug_db_duptherapy_yn); 
		reqChecks.add(drug_db_interact_check_yn); 
		reqChecks.add(drug_db_contraind_check_yn); 
		reqChecks.add(drug_db_allergy_check_yn); 
		startdate	= (String)drug_detail.get("START_DATE");
		enddate		= (String)drug_detail.get("END_DATE");
		drugDBCheckResult = beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,aDrugDesc, dosageCheckParams, "Y",startdate,enddate); 
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
			if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ 
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
			tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
			if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
				drug_db_contraind_check_flag="Y";
			}		
			else
				drug_db_contraind_check_flag="N";
		}
	}
	drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dosage_check_flag);
	drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
	drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
	drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
	drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_check_flag);
}
else{
	drug_db_product_id = "";
}							
if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
	external_database_overrided_yn = "Y";
if(external_database_overrided_yn.equals("Y") && ((drug_db_interact_check_flag.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && external_duplicate_override_reason.equals("")) || (drug_db_contraind_check_flag.equals("Y") && external_contra_override_reason.equals("")) || (drug_db_dosage_check_flag.equals("Y") && external_dosage_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && external_alergy_override_reason.equals(""))))
	external_database_overrided_reason="N";
else
	external_database_overrided_reason="Y";
if(external_dosage_override_reason.equals("")){
	external_dosage_override_reason = (String)(((HashMap)bean_IVD.getAmendDoseRemarks()).get("1")) == null?"":(String)(((HashMap)bean_IVD.getAmendDoseRemarks()).get("1"));
	drug_detail.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",external_dosage_override_reason);
}		
if(drug_db_allergy_check_flag.equals("Y")){
	drug_detail.put("ALLERGY_YN","N");
	allergy_yn = "N";
}
/* Banner Indicator Ends */													
				                           
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(drugDesc));
            _bw.write(_wl_block10Bytes, _wl_block10);

													//if(external_database_overrided_yn.equals("Y") && !ext_prod_id.equals("") && (drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") ||drug_db_allergy_check_flag.equals("Y") ||drug_db_contraind_check_flag.equals("Y") || drug_db_dosage_check_flag.equals("Y"))){
													if(!sch_over_yn.equals("Y") && !ext_prod_id.equals("")){

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
													}													
													display_auth_rule = "display:none";
													if(limit_ind!=null && limit_ind.equals("N") && !drug_db_dosage_check_flag.equals("Y")){
														display_auth_rule = "display:inline-block";
													}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
																										
													display_auth_rule = "display:none";
													if(current_rx!=null && current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
														display_auth_rule = "display:inline-block";
													}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
														
													if(allergy_yn!=null && allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);

													}
													display_auth_rule = "display:none";
													color_auth_rule   = "/eIPAD/images/Req_icon.PNG";              							
													if(ord_auth_reqd_yn != null && ord_auth_reqd_yn.equals("Y")){
														display_auth_rule = "display:inline-block";
														if(ord_authorized_yn.equals("Y"))
															color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
													}

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block27Bytes, _wl_block27);

													display_auth_rule = "display:none";
													color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
													if(ord_cosign_reqd_yn != null && ord_cosign_reqd_yn.equals("Y")){
														display_auth_rule = "display:inline-block";
														if(ord_cosigned_yn.equals("Y"))
															color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
													}

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block27Bytes, _wl_block27);

													display_auth_rule = "display:none";
													color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
													if(ord_spl_appr_reqd_yn != null && ord_spl_appr_reqd_yn.equals("Y")){
														display_auth_rule = "display:inline-block";
														if(ord_approved_yn.equals("Y"))
															color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
													}

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(strength_value.equals("0")){	 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(calculateByValues));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{ 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(calculateByValues));
            _bw.write(_wl_block37Bytes, _wl_block37);
} 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(dosage_Type_values));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( STRENGTH));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(pres_qty_value));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);

																Hashtable QtyDescDetails	= (Hashtable)bean_IVD.listQtyDetails(drug_code);
																Enumeration keys_des		= QtyDescDetails.keys();
																String uom_code				= "";
																String uom_desc				= "";
																String def_uom				= "";
						
																while(keys_des.hasMoreElements()) {
																	uom_code	= (String)keys_des.nextElement();
																	uom_desc	= (String)QtyDescDetails.get(uom_code);
						
																	if(!uom_code.equals("dflt_code")) {
																		if(dosage_type.equals("S")) {
																			if(uom_code.equals(pres_base_uom))
																				def_uom = "SELECTED";
																			else
																				def_uom = "";
																		}
																		else {
																			if(uom_code.equals(qty_desc_code))
																				def_uom = "SELECTED";
																			else
																				def_uom = "";
																		}
																
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(def_uom));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(uom_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);

																	}
																}
																
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(calc_dose_value));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(drug_remarks ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(dosageUnitDetailedValues));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block82Bytes, _wl_block82);
														
													if(allergy_yn!=null && allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(allergy_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);
 													}
													display_auth_rule = "display:none";
													if(current_rx!=null && current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
														display_auth_rule = "display:table";
													}

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(java.net.URLEncoder.encode(dup_drug_desc,"UTF-8")));
            _bw.write(_wl_block82Bytes, _wl_block82);

													display_auth_rule = "display:none";
													if(limit_ind!=null && limit_ind.equals("N") && !drug_db_dosage_check_flag.equals("Y")){
														display_auth_rule = "display:table";
													}

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(exceed_dose_desc));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(drugDesc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(strength));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(qtyDesc));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(qty_desc_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(STRENGTH));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(strength_per_pres_uom));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(pres_qty_value));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(calc_dose_value));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(i));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( srl_no));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(i));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( limit_ind));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( daily_dose ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( unit_dose ));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( mono_graph ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( min_daily_dose ));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( min_unit_dose ));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( current_rx ));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( allergy_yn ));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( strength_per_value_pres_uom ));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( pres_base_uom ));
            _bw.write(_wl_block155Bytes, _wl_block155);

												}
											
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(presDetails.size()));
            _bw.write(_wl_block157Bytes, _wl_block157);
	
				                           	}
											
            _bw.write(_wl_block158Bytes, _wl_block158);

										 	ArrayList dfltFluidDetails = null;
											ArrayList dfltFluidDetails_desc = null;
											String drugCodes = bean_IVD.getDrugCodes();
											if(presDetails.size()==1){
												dfltFluidDetails = bean_IVD.getCompFluidDetails(drugCodes.substring(0,drugCodes.length()-1),pract_id,resp_id);
											}
											else if (presDetails.size()>1){
												selected_drug_codes = "";
												selected_drug_codes += drugCodes.substring(0,drugCodes.length()-1);
												dfltFluidDetails = bean_IVD.getCompFluidDetailsForMultipeDrugs(selected_drug_codes,pract_id,resp_id);
											}	
											String STRENGTH_PER_VALUE_PRES_UOM = (String)fluid_details.get("STRENGTH_PER_VALUE_PRES_UOM");

											String BUILD_MAR_YN = (String)fluid_details.get("BUILD_MAR_YN");
											String PRES_QTY_UOM = (String)fluid_details.get("PRES_QTY_UOM");
											ArrayList exstngIVOrdersDts	= new ArrayList();
											exstngIVOrdersDts		= bean_IVD.getAllExistingIVOrders();
											 String start_date_fluid="";
											 String end_date_fluid="";
											if(exstngIVOrdersDts.size()>0){
												start_date_fluid=START_DATES;
												end_date_fluid=END_DATES;
												if(start_date_fluid.equalsIgnoreCase("") ||end_date_fluid.equalsIgnoreCase("") ){
													start_date_fluid = bean_IVD.getSysdate();
		   											 end_date_fluid	=  bean_IVD.populateEndDate(start_date_fluid,"24","H");
		   										
												
												}
	                                           }else{
	                                        	   
	                                        	 start_date_fluid = bean_IVD.getSysdate();
	   											 end_date_fluid	=  bean_IVD.populateEndDate(start_date_fluid,"24","H");
	   										
	                                           }
	                                           
											
												String trade_code = (String)fluid_details.get("TRADE_CODE");
											String max_duration = (String)fluid_details.get("DURN_VALUE");											
											String fluid_code = (String)fluid_details.get("DRUG_CODE");
																				
											String buildMAR_yn		= "";
	String MAR_app_yn		= "";
	String buildMAR_checked	= "";
	String buildMAR_rule	= "";  
	String buildMAR_enable	= "";
	String params			= request.getQueryString();
	String adr_count		= request.getParameter("adr_count") == null ? "0":request.getParameter("adr_count");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
	String iv_prep_yn		= request.getParameter("iv_prep_yn") == null ? "":request.getParameter("iv_prep_yn");
 	String order_type_flag	= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	String order_set_code	= request.getParameter("order_set_code") == null ? "":request.getParameter("order_set_code");
	ArrayList orderSetCodes	= new ArrayList();
	HashMap   orderSetFluid = new HashMap();
	String iv_prep_default	= request.getParameter("iv_prep_default") == null ? "":request.getParameter("iv_prep_default");
	MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	buildMAR_yn = MAR_app_yn;
	String form_code			=	"";
	String route_code			=	"";
	String order_type_code		=	"";
	String Disabled				=	"";
	String checkVal				=   "";
	String admix_value1			=   "";
	String CATALOG_DESC			=   "";
	String ORDER_CATALOG_CODE   =   "";	
	String stock_value			=   "0";
	String FLUID_UNIT_QTY		=   "";
	String stock_uom_code		=   "";
	String time_flag            =   ""; 
	String disable_addmixture	=   "";
	String alert_practitioner_yn=   "";
	String chk_addmixture       =   ""; 
	String base_volume			=   "";	
    String fluid_adr_display    =   "hidden";
	String mfr_display			=	"hidden";
	String read					=	"";
	String mfr_remarks			=	"";
	String remarksDisplay		=	"display:none";
	exstngIVOrders	= new ArrayList();
	iv_calc_infuse_by=bean_IVD.getIVCalcInfuseBy(); //added for SKR-CRF-0035 start
	String iv_calc_infuse_display="", iv_calc_duration_display="";
	if(iv_calc_infuse_by.equals("I")){
		iv_calc_infuse_display="display:inline;";
		iv_calc_duration_display="display:none;";
	}
	else{
		iv_calc_infuse_display="display:none;";
		iv_calc_duration_display="display:inline;";
	}	
	if(iv_prep_default.equals("1") || iv_prep_default.equals("2")){		
		if(!order_set_code.equals("")) 
			orderSetCodes = bean_IVD.getOrdersetCodes(order_set_code);
		if((orderSetCodes.size() != 0) &&(bean_IVD.getFluidCompatibility().equals("Y"))) {
			orderSetFluid = bean_IVD.getOrderSetDrugs((String)orderSetCodes.get(0)); 
			ArrayList orderSetValues	= bean_IVD.getOrderSetValues();
			String	sReqRnot			= "";
			fluid_code					= (String)orderSetFluid.get("drug_code");
			CATALOG_DESC				= (String)orderSetFluid.get("drug_desc");
			bean_IVD.setFluidDetails(fluid_code,"","","",""); // CRF-0062 NEWLY ADDED
			if(orderSetValues.get(0).equals(fluid_code)){
				stock_value				= (String)orderSetValues.get(1);		
				sReqRnot				= (String)orderSetValues.get(6);
			}
			if(sReqRnot.equals("R")) 
				Disabled = "disabled";
		} 
	}	
	ArrayList stockDetails = bean_IVD.getStockDetails(fluid_code, "1");
	if (stockDetails.size() != 0)
		stock_value=(String)stockDetails.get(0);											
	if(VOLUME_VALUE == null || VOLUME_VALUE == "")
		VOLUME_VALUE = stock_value;
	if(iv_prep_yn.equals("1")){
		checkVal="unchecked";
		admix_value = "N";
	}
	else if(iv_prep_yn.equals("2")){
		checkVal="checked";
		admix_value = "Y";
	}
	else checkVal="";
		if(mode == null) mode="";		
		String resetYN = request.getParameter("reset")==null?"": request.getParameter("reset");
		HashMap hm_fluid_details = null;
		if(!resetYN.equals("Y")){
			if(bean_IVD.getFluidDetails()==null || (bean_IVD.getFluidDetails()).size()==0){				
			}
		}
		hm_fluid_details = bean_IVD.getFluidDetails();				
		if(hm_fluid_details != null){
			if(hm_fluid_details.size()>0){
				fluid_code		= (String)hm_fluid_details.get("DRUG_CODE");
				order_type_code = (String)hm_fluid_details.get("ORDER_TYPE_CODE");
				if(hm_fluid_details.get("BUILD_MAR_YN")==null){
					hm_fluid_details.put("BUILD_MAR_YN",MAR_app_yn);
				}
				buildMAR_yn		= (String) hm_fluid_details.get("BUILD_MAR_YN");
				buildMAR_rule = (String)hm_fluid_details.get("BUILD_MAR_RULE"); 				
				if(buildMAR_yn!=null && buildMAR_yn.equals("Y"))
					buildMAR_checked ="Checked";
				else
					buildMAR_checked="";					
				buildMAR_rule=(buildMAR_rule==null)?"":buildMAR_rule;					
				if(buildMAR_rule.equals("CE")){
					buildMAR_enable="";
				}
				else if(buildMAR_rule.equals("UE")){
					buildMAR_enable="";
				}
				else if(buildMAR_rule.equals("CD")){
					buildMAR_enable="disabled";
				}
				else if(buildMAR_rule.equals("UD")){
					buildMAR_enable="disabled";
				}
			}			
			if( Integer.parseInt(adr_count)>0){
		    int fluid_adr_count = bean_IVD.getADRCount(patient_id,fluid_code);
		    if(fluid_adr_count>0)
			  fluid_adr_display ="visible";
	     }
	 HashMap record1					=	new HashMap(); 
	record1					=	bean_IVD.ChkAdMixture();
	chk_addmixture			=	(String)record1.get("IV_ADMIXTURE_APPL_YN");
	alert_practitioner_yn	=	(String)record1.get("ALERT_PRACTITIONER_YN");
	if(chk_addmixture.equals("N") || mfr_display.equals(""))
	   disable_addmixture	=	"Disabled";		    
	else{
	   disable_addmixture	=	"";
	}	
}		
											
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf( bean_id_IVD ));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf( bean_name_IVD ));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(stock_uom_code));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(base_volume));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf( order_type_flag ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf( order_set_code ));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf( locale ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(read.equals("")?"N":"Y"));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(mfr_remarks));
            _bw.write(_wl_block172Bytes, _wl_block172);

			                                                          		int i=0;
																	String dfl_sel=	(String)fluid_details.get("DRUG_CODE");
																	String PRES_BASE_UOM_DESC_FULD=	(String)fluid_details.get("PRES_BASE_UOM_DESC");
																		String selected="";
																			for(int j=1; j<dfltFluidDetails.size();j+=7){
																				if(dfl_sel != null && (dfltFluidDetails.get(j-1)).equals(dfl_sel)){
																		
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dfltFluidDetails.get(j-1)));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(dfltFluidDetails.get(j)));
            _bw.write(_wl_block175Bytes, _wl_block175);

																				}
																				else if(dfl_sel == null && dfltFluidDetails.get(j+2).equals("Y")) {
																		
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dfltFluidDetails.get(j-1)));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(dfltFluidDetails.get(j)));
            _bw.write(_wl_block175Bytes, _wl_block175);
		
																				}
																				else{
																		
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dfltFluidDetails.get(j-1)));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(dfltFluidDetails.get(j)));
            _bw.write(_wl_block178Bytes, _wl_block178);

																					
																				}
																				i++;
																			}
				                                                        
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(VOLUME_VALUE));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(PRES_BASE_UOM_DESC_FULD));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf( drug_db_dosecheck_yn));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf( drug_db_interface_yn));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf( bean_id_IVD));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf( bean_name_IVD));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf( infuse_overs));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(PRES_BASE_UOM_DESC_FULD));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(infusionRateDetails));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf( infuse_over_hrs ));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(infuse_over_mis ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf( disp_strs));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf( duration_drun ));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(START_DATES ));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(END_DATES ));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(ph_version));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(start_date_fluid));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(end_date_fluid));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(bean_id_IVD));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(bean_name_IVD));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(max_duration));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(iv_calc_infuse_by));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(FUTURE_DATE));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(bl_disp_charge_dtl_in_rx_yn));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(infuse_over));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(END_DATES));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(START_DATES));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(infuse_overs));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(drugCodes));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(infusion_period_uom));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block229Bytes, _wl_block229);
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
