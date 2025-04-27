package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.OrderEntryBean;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ehis.persist.PersistenceHelper;
import ePH.IVPrescriptionBean;

public final class __pharmbase extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/PharmBase.jsp", 1709293412690L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n                                                            <div data-role=\"none\" id=\"dvMez\" class=\"blurPopup\" onclick=\"\" data-popid=\"\" style=\"z-index:10000\"></div>\n                                                            <!-- TODO -->\n                       <!-- Ht n Wt PopUp starts-->\n\t\t\t\t\t\t<div id=\"pharmacyValidationPopUp\" class=\"absoluteCenter\" style=\"box-shadow: 0px 0px 10px 5px #7e8081;z-index: 10005; display: none;\">\n\t\t\t\t\t\t   <div class=\"pharPopHeader segoeuiBold\">Enter height and weight</div>\n\t\t\t\t\t\t   <div class=\"HeightPopcontent\">\n\t                            <div class=\"rxDurationSectionWrapper\">\n                                    <div class=\"rxLeftContainerDuration\">\n                                       <div class=\"rxLabel segoeuiBold\" style=\"padding-top: 10px;\">Height <font style=\"display:none;\" id=\"ht_mandatory\" class=\"rxMandatorIndi\">*</font></div>\n                                        <div class=\"pharmIvRxDetailCntlContentWa\" style=\"padding-top: 1px;\">                                      \n\t\t\t\t\t\t\t\t\t\t  <input style=\"width:100% ! important;height:43px;\" id=\"enter_height\" class=\"dropDown k-textbox\" type=\"text\"  maxlength=\"5\" />\n                                          <div class=\"pharmIvRxDetailInnerContent\">cms</div>\n                                       </div>\t\t\t\t\t\t\t\t\t\t   \n                                       <div class=\"rxLabel segoeuiBold\" style=\"clear: both;\">BSA</div>\n\t\t\t\t\t\t\t\t\t   <div style=\"width:100% ! important;\" class=\"pharContentBMIBSAValue\" id=\"RxBsaValue\"></div>\n                                    </div>\n                                    <div class=\"rxRightContainer\" style=\"padding-top:0px\" >\n\t\t\t\t\t\t\t\t\t\t<div class=\"rxLabel segoeuiBold\" style=\"padding-top:10px\">Weight <font style=\"display:none;\" id=\"wt_mandatory\" class=\"rxMandatorIndi\">*</font></div>\n                                        <div class=\"pharmIvRxDetailCntlContentWa\">                                      \n\t\t\t\t\t\t\t\t\t\t  <input style=\"width:100% ! important;height:43px;\" id=\"enter_weight\" class=\"dropDown k-textbox\" type=\"text\"  maxlength=\"6\" />\n                                          <div class=\"pharmIvRxDetailInnerContent\">kgs</div>\n                                       </div>\t\t\t\t\t\t\t\t\t   \n                                       <div class=\"rxLabel segoeuiBold\" style=\"clear: both;\">BMI</div>\t\t\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t   <div style=\"width:100% ! important;\" class=\"pharContentBMIBSAValue\" id=\"RxBmiValue\"></div>\n                                      </div>\n                                </div>\t  \n\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t   <div class=\"pharPopFooter\">\n\t\t\t\t\t\t      <div id=\"heightCheckOk\" disable=\"true\" class=\"pharPopOk segoeuiBold\" onClick=\"closeHWPopupOK()\">OK</div>\n\t\t\t\t\t\t      <div class=\"pharPopCancel segoeuiBold\" onClick=\"closeHWPopupCAN()\">CANCEL</div>\n\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- Ht n Wt PopUp ends -->   \n                                                            <div class=\"ChartSummaryParent ChartSummaryParentTheme\" data-role=\"page\" id=\"RxOrderPlaceDiv\">\n                                                                <div class=\"ChartSummaryBlockVar\" id=\"ChartSummaryBlock\" data-role=\"none\">\n                                                                    <form id=\"PharmBaseForm\" name=\"PharmBaseForm\" id=\"PharmBaseForm\" method=\"post\" action=\"\" class=\"ChartSummaryFormElem\">\n                                                                        <div class=\"ChartSummaryMainTable\" data-role=\"none\">\n                                                                            <div data-role=\"none\" class=\"ChartSummaryPageHeader\" id=\"CSHeader\">\n                                                                                <div class=\"ChartSummaryHeaderCell\" data-role=\"none\">\n                                                                                    <div class=\"ChartSummaryHeaderCont\" data-role=\"none\">\n                                                                                        <div class=\"ChartSummaryHeaderTable ChartSummaryHeaderTableTheme\" data-role=\"none\">\n                                                                                            <div class=\"ChartSummaryHeaderRow\" data-role=\"none\">\n                                                                                                <div class=\"ChartSummaryHeaderIconCol\" data-role=\"none\">\n                                                                                                    <div class=\"WidgetButtonTheme\" data-role=\"none\"><img src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/images/MenuIcon.png\"></div>\n                                                                                                </div>\n                                                                                                <div class=\"ChartSummaryHeaderTextCol\" data-role=\"none\">\n                                                                                                    <div class=\"ChartSummaryHeaderText ChartSummaryHeaderTextTheme\" data-role=\"none\">Pharmacy Order</div>\n                                                                                                </div>\n                                                                                                <div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n                                                                                                    <div class=\"WidgetButtonTheme completePlaceOrdersDisable\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"completePlaceOrdersConfirm\"data-role=\"none\" onclick=\"completePlaceOrders_confirm()\"><img src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/images/CS_Ok16x16.png\"></div>\n                                                                                                </div>\n                                                                                                <div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n                                                                                                    <div class=\"WidgetButtonTheme\" data-role=\"none\" onclick=\"closeChartSummary()\"><img src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/CS_Close16x16.png\"></div>\n                                                                                                </div>\n                                                                                            </div>\n                                                                                        </div>\n                                                                                    </div>\n                                                                                </div>\n                                                                            </div>\n                                                                            <div data-role=\"none\" class=\"ChartSummaryPageContent ChartSummaryPageContentTheme\" id=\"\">\n                                                                                <div data-role=\"none\" class=\"ChartSummaryPageContentCell\">\n                                                                                    <div data-role=\"none\" class=\"ChartSummaryMainWrapper pharmDataMainWrapper\" id=\"\">\n                                                                                        <div class=\"ChartSummaryMainScroller pharmDataContentScroller\" data-role=\"none\">\n                                                                                            <div class=\"table pharmDataItemHeight\" style=\"table-layout:fixed;\" data-role=\"none\">\n                           <div  class=\"row selectPharmOrder pharmOrderItemHeaderRow\" data-role = \"none\" id=\"PharmAvailableTabs\">\n                              <div id=\"pharmPrevOrder\" class=\"cell pharmOrderTab\"  onclick=\"selectPharmOrderTab(this,\'prevOdr\')\" data-role = \"none\"> Previous Orders\n                              </div>\n                              <div id=\"pharmTickSheet\" class=\"cell pharmOrderTab\"  onclick=\"selectPharmOrderTab(this,\'tickSheet\')\" data-role = \"none\"> Ticksheet </div>\n                              <div id=\"pharmRx\" class=\"cell pharmOrderTab\"  onclick=\"selectPharmOrderTab(this,\'rxTab\')\" data-role = \"none\"> Rx </div>\n                              ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n                              <div class=\"cell pharmOrderTab\"  onclick=\"selectPharmOrderTab(this,\'crxTab\')\" data-role = \"none\"> Compounding Rx </div>\n                              ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n                              <div class=\"cell pharmOrderTab\"  onclick=\"selectPharmOrderTab(this,\'ivrxTab\')\" data-role = \"none\"> IV </div>\n                              ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n                           </div>\t\t\t\t\t\t   \t\t\t\t\n\t\t\t\t\t\t   <div  id=\"ivrxSubTypes\" class=\"row ivrxSubTabs\" style=\"display:none;\">\n                              <div class=\"ivrxTabsContainer\">\t\t\t\t\t\t\t\t\n                                <div style=\"width:33%;height:50px;font-size: 14px;font-family:Segoe UI Semibold;color: #9298ae;\" onclick=\"selectIvrxMode(\'D\',\'ivWithAdd\')\">\n\t\t\t\t\t\t\t\t   <div class=\"table\" style=\"width:100%;height:50px;\">\n\t\t\t\t\t\t\t\t      <div class=\"row\">\n\t\t\t\t\t\t\t\t\t     <div class=\"cell\" style=\"vertical-align: bottom;text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t    <div id=\"ivWithAddOption\" class=\"ivrxTabs ivrxTabsOnActive\"></div>\n\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t  </div>\n                                      <div class=\"row\">\n\t\t\t\t\t\t\t\t\t     <div id=\"ivWithAddDesc\" class=\"cell ivrxDescription ivrxTabsDescOnActive\">\n\t\t\t\t\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<div style=\"width:33%;height:50px;font-size: 14px;font-family:Segoe UI Semibold;color: #9298ae;\" onclick=\"selectIvrxMode(\'IVF\',\'ivWithoutAdd\')\">\n\t\t\t\t\t\t\t\t   <div class=\"table\" style=\"width:100%;height:50px;\">\n\t\t\t\t\t\t\t\t      <div class=\"row\">\n\t\t\t\t\t\t\t\t\t     <div class=\"cell\" style=\"vertical-align: bottom;text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t    <div id=\"ivWithoutAddOption\" class=\"ivrxTabs\"></div>\n\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t  </div>\n                                      <div class=\"row\">\n\t\t\t\t\t\t\t\t\t     <div id=\"ivWithoutAddDesc\" class=\"cell ivrxDescription\">\n\t\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n                                <div style=\"width:33%;height:50px;font-size: 14px;font-family:Segoe UI Semibold;color: #9298ae;\" onclick=\"selectIvrxMode(\'D\',\'ivInter\')\">\n\t\t\t\t\t\t\t\t   <div class=\"table\" style=\"width:100%;height:50px;\">\n\t\t\t\t\t\t\t\t      <div class=\"row\">\n\t\t\t\t\t\t\t\t\t     <div class=\"cell\" style=\"vertical-align: bottom;text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t    <div id=\"ivIntermittentOption\" class=\"ivrxTabs\"></div>\n\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t  </div>\n                                      <div class=\"row\">\n\t\t\t\t\t\t\t\t\t     <div id=\"ivIntermittentDesc\" class=\"cell ivrxDescription\">\n\t\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t  </div>\n                           </div>                       \t\t\t\t\t   \n                           <div class=\"row\" id=\"searchResultsList\" style=\"width:auto;height:90%;background:#edf1f3;\" data-role = \"none\">  \n\t\t\t                 <div class=\"cell\" style=\"width:auto;height:99%;\">\n\t\t\t\t\t\t       <div class=\"table\"  style=\"width:100%;height:100%;table-layout:fixed;\">\n\t\t\t\t\t\t          <div class=\"row\" style=\"width:100%;height:1%;background:#edf1f3;\" data-role = \"none\">\n\t\t\t\t\t\t             <div class=\"cell\" style=\"width:100%;height:auto;\">                                        \n\t\t\t\t\t\t\t\t\t\t<div id=\"drugSearchBox\" class=\"divEventTheme\" style=\"width: calc(100% - 12px);margin-left: 5px;margin-top: 10px;margin-bottom: 3px;\">\n\t\t\t                            <table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; height: 100%\">\n\t\t\t\t                           <tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t                          <td style=\"width: 99%; height: 100%\" valign=\"middle\">\n                                                 <input type=\"text\" class=\"txtContent\" style=\"height:31px;width:98%;padding-left: 5px;\" onkeyup=\"filterNoteTypes(event)\" id=\"NoteTypeFilterTxt\" name=\"NoteTypeFilterTxt\" id=\"NoteTypeFilterTxt\" />\n\t\t\t\t\t                          </td>\n\t\t\t\t\t                          <td style=\"width: 1%; height: 100%\">\n\t\t\t\t\t\t                        <div id=\"cellblur\" class=\"cellDivider\">\n\t\t\t\t\t\t\t                      <div id=\"addSearchClass\" class=\"dvSerarchIcon\" style=\"display: block;\" onclick=\"clearTemplateFilterTxt(event)\">\n\t\t\t\t\t\t\t                         <img src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/images/SearchGray16x16.png\" id=\"NoteFilterTxtClearButton\">\n\t\t\t\t\t\t\t                      </div>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t                      <div id=\"removeSearchClass\" class=\"dvSerarchIcon\" style=\"padding-left: 5px;display: block;\" onclick=\"clearSearchFilterTxt()\">\n\t\t\t\t\t\t\t                         <img src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/images/Close-small.png\" id=\"NoteFilterTxtClearButton\">\n\t\t\t\t\t\t\t                      </div>\t\t\n\t\t\t\t\t\t                        </div>\n\t\t\t\t\t                           </td>\n\t\t\t\t                           </tr>\n\t\t\t                            </table>\n\t\t                                </div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t<div id=\"drugDropDownTicksheet\" class=\"ticksheetHolder\" style=\"display:none\">\n\t\t\t                               <div style=\"width:calc(100% - 10px);height:48px;margin-top: 7px;margin-left: 5px;\">\n\t\t\t\t\t\t\t\t\t\t     <select style=\"width: 100%;\" id=\"drugDropDownTicksheet1\" name=\"drugDropDownTicksheet1\" id=\"drugDropDownTicksheet1\">\n\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t   <div id=\"loadticksheetSecParent\" style=\" display:none; width:100%;height:8vhpx;\">\n\t\t\t\t\t\t\t\t\t\t       <div id=\"loadticksheetSections\" style=\"width:100%;height:40px;\">\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"noticksheetMsg\" class=\"noRecordsMainDiv\" >\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<p class=\"noRecordsText\">No ticksheet found </p> \n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t\t\t\t\t\t     \n\t\t\t\t\t\t              </div>\n\t\t\t\t\t\t            </div>\n<div class=\"row\" style=\"width:auto;height:99%;\" data-role=\"none\">\n<div class=\"cell\" style=\"width:auto;height:100%;\">\n<div class=\"container\" id=\"rxSearchResults\">\n</div>\n<div id=\"cartWrapper\" class=\"cartWrapper\">\n   <div id=\"cart\" class=\"cart\">\n      <div id=\"innerCart\" class=\"innerCart\">\n         <div class=\"shoppingCart\">\n            <img class=\"cartImage\" src=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/eIPAD/images/Cart.png\">\n         </div>\n         <div class=\"shoppingCart\">\n            <div class=\"cartCount\">\n               <span id=\"cartCount\" style=\"position: relative;top: 2px;left: 0px;font-family:Segoe UI;-webkit-font-smoothing: antialiased;letter-spacing: -0.8px;font-weight: 600;\">0  \n               </span>\n            </div>\n         </div>\n      </div>\n   </div>\n</div>\n<div id=\"cartExpandWrapper\" style=\"display:none\">\n   <div id=\"cartOnExpand\">\n      <div id=\"cartSymbol\">\n         <div id=\"innerCartOnExpand\" class=\"innerCart\">\n            <div class=\"shoppingCart\">\n               <img class=\"cartImage\" src=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/eIPAD/images/Cart.png\">\n            </div>\n            <div class=\"shoppingCart\">\n               <div class=\"cartCount\">\n                  <span id=\"cartCountOnExpand\" style=\"position: relative;top: 2px;left: 0px;font-family:Segoe UI;-webkit-font-smoothing: antialiased;letter-spacing: -0.8px;font-weight: 600;\">0  \n                  </span>\n               </div>\n            </div>\n         </div>\n      </div>\n      <div id=\"dropBasket\">\n         <div id=\"shoppingCartText\" class=\"shoppingCartText\">\n         </div>\n      </div>\n   </div>\n</div>\n<div class=\"cardShadowWrapper\">\n   <img class=\"cartShadowTop\" src=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/eIPAD/images/CartShadow.PNG\">\n   <img class=\"cartShadowBottom\" src=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/eIPAD/images/CartShadow.PNG\">\n</div>\n<!-- drug interaction check Pop starts -->\n<div id=\"PharmacyCartValidationDrugInteraction\"  class=\"absoluteCenter drugInteractionPopMainWrapper\" >\n\t<div class=\"drugInteractionPopWrapper\" >\n        <div id=\"popupContainer\" class=\"drugInterPopupContainer\">\n\t\t    <div class=\"pharPopHeader\" style=\"width:auto;padding:0px;\">\n\t\t\t\t<div class=\"table\" style=\"width:100%;height:100%\">\n\t\t\t\t<div class=\"row\" style=\"width:100%;height:100%\">\n\t\t\t\t\t<div class=\"cell drugInterImgWrapper\" style=\"\"><img src=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/eIPAD/images/Warning_icon25x23.png\" ></div>\n\t\t\t\t\t<div class=\"cell \"style=\"width:auto;height:100%;\"> Interaction details</div>\n\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t   </div>\n\t\t   <div id=\"popContent\" class=\"drugInterContentWrap\" >\n\t\t      <div id=\"contentHeader\" class=\"drugInterContentHeaderWrap\">\n\t\t\t    <div class=\"drugInteractionLabelWrapper\" >\n\t\t\t\t   <span class=\"drugInteractionLabel\">Severity level</span>\n\t\t\t\t  <span id=\"severity_level\" class=\"segoeuiBold drugInteractionLabelContent\"></span>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"drugInteractionLabelWrapper\" >\n\t\t\t\t<span class=\"drugInteractionLabel\">Documentation</span>\n\t\t\t\t <span id=\"probability\"  class=\"segoeuiBold drugInteractionLabelContent\"></span>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"drugInteractionLabelWrapper\" >\n\t\t\t\t<span class=\"drugInteractionLabel\">Sigficant level</span>\n\t\t\t\t <span id=\"significant_level\"  class=\"segoeuiBold drugInteractionLabelContent\"></span>\n\t\t\t\t</div>\n\t\t\t\t<div style=\"clear: both;\"></div>\n\t\t\t  </div>\n\t\t\t  <div class=\"drugInteractionLabel drugInterDescLabel\">Interaction description</div>\n\t\t\t  <div id=\"drugInterScrollableWrap\" class=\"drugInterScrollCss\" >\n\t\t\t     <div id=\"DrugInteractionDesc\" class=\"segoeuiBold drugInterDescContent\">\n\t\t\t\t </div> \n\t\t\t  </div>\n\t\t   </div>\n\t\t   <div class=\"pharPopFooter\" style=\"\">\n\t\t   <div id=\"\" disable=\"true\" class=\"pharPopOk segoeuiBold\" onClick=\"okPopup()\">OK</div>\t\t\t\n\t\t   </div>\n\t\t</div>         \t\t\n\t</div>\n</div>\n<!-- drug interaction check Pop ends -->\n\n\n<div id=\"PharmacyCartValidationDrugMessage\" class=\"absoluteCenter\" style=\"z-index: 10005;\">\n   <div class=\"Error_Window\">\n      <div class=\"Error_msg_box\">\n         <div class=\"Error_msg\">\n            <div style=\"width:20% !important;\" class=\"Error_msg_Frame\">\n               <div>\n                  <div class=\"Error_iconCenter\"><img src=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/eIPAD/images/OrderPopWarning.png\" width=\"30\" height=\"30\"> </div>    \n\t\t\t   </div>\n            </div>\n\t\t\t <div style=\"width:80% !important;\" class=\"Error_msg_Frame\">\n               <div>                  \n                  <div class=\"Error_contCenter\" id=\"PharmaMsg\"></div>\n               </div>\n            </div>\n         </div>\n      </div>\n      <div class=\"Error_msg_Okbtn\">\n         <div class=\"Error_btn_div_con\" id=\"drugClick\" data-value=\"true\">OK </div>\n      </div>\n      <div class=\"top_shadow\"> </div>\n   </div>\n</div>\n\n<!-- Discharge medication Pop starts -->\n<div id=\"PharmacyCartValidationDialogDis\" class=\"absoluteCenter\" style=\"z-index: 10005;\">\n   <div class=\"Error_Window\">\n      <div class=\"Error_msg_box\">\n         <div class=\"Error_msg\">\n            <div class=\"Error_msg_Frame\">\n               <div>\n                  <div class=\"Error_icon\"><img src=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/eIPAD/images/OrderPopConfirm.png\" width=\"30\" height=\"30\"> </div>\n                  <div class=\"Error_cont\" id=\"ClinicalNotesConfirmDialogMsg\">Do you want to treat this as patient\'s discharge medication?</div>\n               </div>\n            </div>\n         </div>\n      </div>\n      <div class=\"Error_msg_btn\">\n         <div class=\"Error_btn_div_con\" id=\"cancelClick\" onclick=\"cancelClickDialog()\">Cancel </div>\n         <div class=\"Error_btn_div\"> </div>\n         <div class=\"Error_btn_div_con\" id=\"trueClick\" onclick=\"trueClickDialog()\" data-value=\"true\">Confirm </div>\n      </div>\n      <div class=\"top_shadow\"> </div>\n   </div>\n</div>\n<!-- Discharge medication Pop starts -->\n                                                                                                                    \n<!-- Cart close Pop starts -->\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<div id=\"cartCloseconfirmMsg\" class=\"absoluteCenter\" style=\"z-index: 999999;\">\n\t\t\t<div class=\"Error_Window\">\n\t\t\t\t<div class=\"Error_msg_box\">\n\t\t\t\t<div class=\"Error_msg\">\n\t\t\t\t\t<div class=\"Error_msg_Frame\">\n\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t<div class=\"Error_icon\"><img src=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/eIPAD/images/OrderPopConfirm.png\" width=\"30\" height=\"30\"> </div>\n\t\t\t\t\t\t\t<div class=\"Error_cont\" id=\"ClinicalNotesConfirmDialogMsg\">Are you sure you wish to cancel the current operation?</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t<div class=\"Error_msg_btn\">\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"okClick\" onclick=\"okCartClickDialog()\">OK </div>\n\t\t\t\t<div class=\"Error_btn_div\"> </div>\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"cancelClick\" onclick=\"cancelCartClickDialog()\" data-value=\"true\">Cancel </div>\n\t\t\t</div>\n\t\t\t<div class=\"top_shadow\"> </div>\n\t\t\t</div>\n</div>\n<!-- Cart close Pop ends -->\n\n<!-- Delete Pop starts -->\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<div id=\"deleteConfirmMsg\" class=\"absoluteCenter\" style=\"z-index: 999999;\">\n\t<div class=\"Error_Window\">\n\t\t<div class=\"Error_msg_box\">\t\t\t\t\n\t\t <div class=\"Error_msg\">\n            <div style=\"width:20% !important;\" class=\"Error_msg_Frame\">\n               <div>\n                  <div class=\"Error_iconCenter\"><img src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/OrderPopConfirm.png\" width=\"30\" height=\"30\"> </div>    \n\t\t\t   </div>\n            </div>\n\t\t\t <div style=\"width:80% !important;\" class=\"Error_msg_Frame\">\n               <div>                  \n                  <div class=\"Error_contCenter\" id=\"ClinicalNotesConfirmDialogMsg\">Do you want to remove this order from cart?</div>\n               </div>\n            </div>\n         </div>\t\t\t\t\t\t\t\n\t\t</div>\n\t\t\t<div class=\"Error_msg_btn\">\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"okClick\" onclick=\"okDeleteCartItemDialog(\'ok\')\">OK </div>\n\t\t\t\t<div class=\"Error_btn_div\"> </div>\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"cancelClick\" onclick=\"cancelDeleteCartClickDialog()\" data-value=\"true\">Cancel </div>\n\t\t\t</div>\n\t\t\t<div class=\"top_shadow\"> </div>\n\t</div>\n\t\t   <input type=\"hidden\" id=\"drugDelCode\" name=\"drugDelCode\" id=\"drugDelCode\" value=\"\"/>\n                   <input type=\"hidden\" id=\"drugDivID\" name=\"drugDivID\" id=\"drugDivID\" value=\"\"/>\n\t\t   <input type=\"hidden\" id=\"removeType\" name=\"removeType\" id=\"removeType\" value=\"\"/>\n\t\t   <input type=\"hidden\" id=\"drugSrl\" name=\"drugSrl\" id=\"drugSrl\" value=\"\"/>\n</div>\n<!-- Delete Pop ends -->\n<!-- Cart View -->\n<div id=\"cartView\" style=\"display: none\" class=\"viewCartWrapper\">\n   <div id=\"cartViewHeader\" class=\"cartViewHeaderStyle\">\n      <div class=\"cartViewHeaderContent\">\n         <img class=\"padding15Px\" src=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="/eIPAD/images/Cart.png\">\n         <span class=\"padding15Px viewCartText\">\n         Cart Items \n         </span>\n         <div class=\"cartItemCountWrapper\">\n            <div style=\"position: relative;background-color:#23789e;text-align: center;border-radius: 50%;height: 29px;width: 29px;\">\n               <span id=\"countDisplay\" class=\"countDisplayStyle\">0</span>\n            </div>\n         </div>\n      </div>\n      <div class=\"closeCartPanel\">\n         <img id=\"closeCartView\" src=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="/eIPAD/images/Close_panel.png\">\n      </div>\n   </div>\n   <div id=\"cartViewDetails\" class=\"cartViewDetailsCss\">\n      <div id=\"orderDetailsView\" class=\"innerCartDetailsCss\">       \n      </div>\n   </div>\n</div>\n<!-- Cart View ends-->\n</div>\n</div>\n</div>\n</div>\n</div>\t\t\t\t\t\t\t  \n<!-- Pharmacy legend starts -->\n<div id=\"pharBaseLegend\"></div> \t\n<!-- Pharmacy legend ends -->\n</div>\n</div>\n<div id=\"blurSearchResultsList1\" style=\"display:none;width: 100%;height:100%;background-color : #808080;opacity : 0.6;position:absolute;z-index : 9000;\"></div>\n<div id=\"blurSearchResultsList\" style=\"display:none;width: calc(100% - 310px);height:100%;background-color : #808080;opacity : 0.6;position:absolute;z-index : 9000;\">\n</div>\n</div>\n<div class=\"CSTransactionMessage rxBaseToastContentError\" id=\"transactionMsg\" style=\"bottom:107px;z-index: 900002;\">\n   <img id=\"imgTransactionMsg\" style=\"padding-left:15px;vertical-align:middle;\" src=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="/eIPAD/images/PopError.png\" onclick=\"closeToast()\">\n   <span class=\"rxToastmsg\" id=\"rxToastmsg\">Some error occured</span>\n   <div class=\"formValErrorMsgTheme\" id=\"transactionMessageContent\"></div>\n</div>\n</div>\n</div>\n<div data-role=\"none\" class=\"ChartSummaryPageFooter\" id=\"CSFooter\">\n   <div data-role=\"none\" class=\"ChartSummaryPageFooterCell\">\n      <div data-role=\"none\" class=\"ChartSummaryPageFooterCont\">\n         <div data-role=\"none\" class=\"ChartSummaryPageFooterTable ChartSummaryPageFooterTableTheme\">\n            <div data-role=\"none\" class=\"ChartSummaryPageFooterRow\">\n               <div data-role=\"none\" class=\"ChartSummaryPageFooterFirstCol\"></div>\n               <div data-role=\"none\" class=\"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openOtherChartFunctions(\'chartSummary\')\">\n                  <div data-role=\"none\" class=\"ChartSummaryPageFooterText\">\n                     ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n                  </div>\n               </div>\n               <div data-role=\"none\" class=\"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openOtherChartFunctions(\'clinicalNotes\')\">\n                  <div data-role=\"none\" class=\"ChartSummaryPageFooterText\">Clinical<br/>Notes</div>\n               </div>\n               <div data-role=\"none\" class=\"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openOtherChartFunctions(\'placeOrder\')\">\n                  <div data-role=\"none\" class=\"ChartSummaryPageFooterText\">\n                     ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n                  </div>\n               </div>\n               <div data-role=\"none\" class=\"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openOtherChartFunctions(\'clinicalEvents\')\">\n                  <div data-role=\"none\" class=\"ChartSummaryPageFooterText\">Clinical Events</div>\n               </div>\n               <div data-role=\"none\" class=\"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnSelTheme\" onclick=\"openPharmacyFunction()\">\n                  <div data-role=\"none\" class=\"ChartSummaryPageFooterText\">Pharmacy Order</div>\n               </div>\n               <div data-role=\"none\" class=\"ChartSummaryPageFooterLastCol\"></div>\n            </div>\n         </div>\n      </div>\n   </div>\n</div>\n</div>\n<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" />\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n<input type=\"hidden\" name=\"height\" id=\"height\" id=\"height\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" />\n<input type=\"hidden\" name=\"weight\" id=\"weight\" id=\"weight\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" />\n<input type=\"hidden\" name=\"bsa\" id=\"bsa\" id=\"bsa\" size=\"5\" maxlength=\"5\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"></td>\n<input type=\"hidden\" name=\"bmi\" id=\"bmi\" id=\"bmi\" size=\"5\" maxlength=\"5\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"></td>\n<input type=\"hidden\" value=\"\" name=\"ht_wt_check\" id=\"ht_wt_check\" />\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n<input type=\"hidden\" name=\"external_prescription\" id=\"external_prescription\" value=\"false\" />\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n<input type=\"hidden\" name=\"external_prescription\" id=\"external_prescription\" value=\"true\" />\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" />\n<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" />\n<input type=\"hidden\" name=\"pract_name\" id=\"pract_name\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" />\n<input type=\"hidden\" name=\"presel_order_category_yn\" id=\"presel_order_category_yn\" value=\"N\" />\n<!-- TODO check if value is correct-->\n<input type=\"hidden\" id=\"take_home_medication\" name=\"take_home_medication\" id=\"take_home_medication\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" />\n<input type=\"hidden\" name=\"home_leave_yn_chk\" id=\"home_leave_yn_chk\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" />\n<input type=\"hidden\" name=\"allergic_yn\" id=\"allergic_yn\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" />\n<!-- <input type=\"hidden\" value=\"NO\" name=\"order_type\" id=\"order_type\"> -->\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<!-- TODO check if required -->\n<input type=\"hidden\" name=\"height_unit\" id=\"height_unit\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\"hidden\" name=\"weight_unit\" id=\"weight_unit\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type=\"hidden\" name=\"calculated_date\" id=\"calculated_date\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type=\"hidden\" name=\"visit_date\" id=\"visit_date\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<input type=\"hidden\" name=\"ref_sys_date\" id=\"ref_sys_date\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<input type=\"hidden\" name=\"order_type_code_yn\" id=\"order_type_code_yn\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<input type=\"hidden\" id=\"location_type\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<input type=\"hidden\" id=\"location_code\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<input type=\"hidden\" name=\"drug_class\" id=\"drug_class\" value=\"\">\n<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n<input type=\"hidden\" name=\"act_patient_class\" id=\"act_patient_class\" id=\"act_patient_class\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n<input type=\"hidden\" name=\"order_remarks\" id=\"order_remarks\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<input type=\"hidden\" name=\"actual_patient_class\" id=\"actual_patient_class\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<input type=\"hidden\" name=\"source_type\" id=\"source_type\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<input type=\"hidden\" name=\"source_code\" id=\"source_code\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<input type=\"hidden\" name=\"attend_pract_id\" id=\"attend_pract_id\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\"hidden\" name=\"resp_id\" id=\"resp_id\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n<input type=\"hidden\" name=\"back_date\" id=\"back_date\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n<input type=\"hidden\" name=\"future_date\" id=\"future_date\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n<input type=\"hidden\" name=\"licence\" id=\"licence\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n<input type=\"hidden\" name=\"servide_code\" id=\"servide_code\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"> \n<input type=\"hidden\" name=\"service_search_yn\" id=\"service_search_yn\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n<input type=\"hidden\" name=\"problem_ind\" id=\"problem_ind\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n<input type=\"hidden\" name=\"version_no\" id=\"version_no\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n<input type=\"hidden\" name=\"QueryString\" id=\"QueryString\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n<!-- TODO check if required -->\n<input type=\"hidden\" name=\"take_medication_yn_chk\" id=\"take_medication_yn_chk\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n<input type=\"hidden\" name=\"take_medication_yn_dis\" id=\"take_medication_yn_dis\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n<input type=\"hidden\" name=\"allow_without_wt\" id=\"allow_without_wt\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n<input type=\"hidden\" name=\"allow_without_diag\" id=\"allow_without_diag\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n<input type=\"hidden\" name=\"diag_for_medn_order_by\" id=\"diag_for_medn_order_by\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n<input type=\"hidden\" name=\"patient_age\" id=\"patient_age\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n<input type=\"hidden\" name=\"date_of_birth\" id=\"date_of_birth\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n<input type=\"hidden\" name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n<input type=\"hidden\" name=\"diag_size\" id=\"diag_size\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n<input type=\"hidden\" name=\"diag_text_size\" id=\"diag_text_size\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n<input type=\"hidden\" name=\"sliding_scale\" id=\"sliding_scale\" value=\"\">\n<input type=\"hidden\" name=\"num\" id=\"num\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n<input type=\"hidden\" name=\"height_min_value\" id=\"height_min_value\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n<input type=\"hidden\" name=\"height_max_value\" id=\"height_max_value\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n<input type=\"hidden\" name=\"weight_min_value\" id=\"weight_min_value\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n<input type=\"hidden\" name=\"weight_max_value\" id=\"weight_max_value\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n<input type=\"hidden\" name=\"height_min_digits\" id=\"height_min_digits\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=\"hidden\" name=\"height_max_digits\" id=\"height_max_digits\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n<input type=\"hidden\" name=\"weight_min_digits\" id=\"weight_min_digits\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<input type=\"hidden\" name=\"weight_max_digits\" id=\"weight_max_digits\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<input type=\"hidden\" name=\"iv_prep_default\" id=\"iv_prep_default\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<input type=\"hidden\" name=\"order_set_code\" id=\"order_set_code\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"\">\n<input type=\"hidden\" name=\"bl_disp_charge_dtl_in_rx_yn\" id=\"bl_disp_charge_dtl_in_rx_yn\" id=\"bl_disp_charge_dtl_in_rx_yn\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n<input type=\"hidden\" name=\"disp_price_type_in_drug_lkp\" id=\"disp_price_type_in_drug_lkp\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n<input type=\"hidden\" name=\"disp_charge_dtl_in_drug_lkp_yn\" id=\"disp_charge_dtl_in_drug_lkp_yn\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n<input type=\"hidden\" name=\"bl_install_yn\" id=\"bl_install_yn\" id=\"bl_install_yn\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n<input type=\"hidden\" name=\"dc_mar_appl_yn\" id=\"dc_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n<input type=\"hidden\" name=\"em_mar_appl_yn\" id=\"em_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n<input type=\"hidden\" name=\"ip_mar_appl_yn\" id=\"ip_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n<input type=\"hidden\" name=\"op_mar_appl_yn\" id=\"op_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n<input type=\"hidden\" name=\"disch_med_mar_appl_yn\" id=\"disch_med_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n<input type=\"hidden\" name=\"split_based_priority_yn\" id=\"split_based_priority_yn\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n<input type=\"hidden\" name=\"split_based_drug_class_yn\" id=\"split_based_drug_class_yn\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n<input type=\"hidden\" name=\"max_durn_for_ip_pres\" id=\"max_durn_for_ip_pres\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n<input type=\"hidden\" name=\"chk_for_ip_max_durn_action\" id=\"chk_for_ip_max_durn_action\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n<input type=\"hidden\" name=\"max_durn_for_op_pres\" id=\"max_durn_for_op_pres\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n<input type=\"hidden\" name=\"chk_for_op_max_durn_action\" id=\"chk_for_op_max_durn_action\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n<input type=\"hidden\" name=\"max_durn_for_dm_pres\" id=\"max_durn_for_dm_pres\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n<input type=\"hidden\" name=\"chk_for_dm_max_durn_action\" id=\"chk_for_dm_max_durn_action\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n<input type=\"hidden\" name=\"trade_display_yn\" id=\"trade_display_yn\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n<input type=\"hidden\" name=\"narcotic_aprvl_form_req_yn\" id=\"narcotic_aprvl_form_req_yn\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n<input type=\"hidden\" name=\"print_narcotic_form_by_default\" id=\"print_narcotic_form_by_default\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n<!--External Drug Interface Controls -->\n<input type=\"hidden\" name=\"drug_db_interface_yn\" id=\"drug_db_interface_yn\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n<input type=\"hidden\" name=\"drug_db_product_id\" id=\"drug_db_product_id\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n<input type=\"hidden\" name=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n<input type=\"hidden\" name=\"drug_db_duptherapy_yn\" id=\"drug_db_duptherapy_yn\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n<input type=\"hidden\" name=\"drug_db_interact_check_yn\" id=\"drug_db_interact_check_yn\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n<input type=\"hidden\" name=\"drug_db_contraind_check_yn\" id=\"drug_db_contraind_check_yn\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n<input type=\"hidden\" name=\"drug_db_allergy_check_yn\" id=\"drug_db_allergy_check_yn\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n<input type=\"hidden\" name=\"adr_count\" id=\"adr_count\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n<input type=\"hidden\" name=\"MAR\" id=\"MAR\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n<input type=\"hidden\" name=\"MItemsOnly\" id=\"MItemsOnly\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n<input type=\"hidden\" name=\"man_rem_on_prn_freq_yn\" id=\"man_rem_on_prn_freq_yn\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n<input type=\"hidden\" name=\"max_length_prn_reason\" id=\"max_length_prn_reason\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n<input type=\"hidden\" name=\"rx_qty_by_pres_base_uom_yn\" id=\"rx_qty_by_pres_base_uom_yn\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n<input type=\"hidden\" name=\"weight_rec_appl_age_group_check_flag\" id=\"weight_rec_appl_age_group_check_flag\" value=\"\">\n<input type=\"hidden\" name=\"wt_mand_yn\" id=\"wt_mand_yn\" value=\"\">\n<!-- added for Bru-HIMS-CRF-079 IN[029945]  -->\n<input type=\"hidden\" name=\"ht_mand_yn\" id=\"ht_mand_yn\" value=\"\">\n<!--  added for Bru-HIMS-CRF-079 IN[029945]  -->\n<input type=\"hidden\" name=\"atc_allergy_alert_level\" id=\"atc_allergy_alert_level\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n<input type=\"hidden\" name=\"NBPRequestApplYN\" id=\"NBPRequestApplYN\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n<input type=\"hidden\" name=\"drug_interaction_check_yn\" id=\"drug_interaction_check_yn\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n <input type=\"hidden\" id=\"priority\" name=\"priority\" id=\"priority\" value=\"R\"> \n<input type=\"hidden\" name=\"home_leave_yn_val\" id=\"home_leave_yn_val\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n<!-- added for Bru-HIMS-CRF-093[29960] -->\n<input type=\"hidden\" name=\"home_leave_fm\" id=\"home_leave_fm\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n<input type=\"hidden\" name=\"home_leave_to\" id=\"home_leave_to\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n<!-- adding end for Bru-HIMS-CRF-093[29960] -->\n<input type=\"hidden\" name=\"print_mar_label_yn\" id=\"print_mar_label_yn\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n<!-- added for MMS-QH-CRF-0080 [IN:038064] -->\n<input type=\"hidden\" name=\"buildMAR_yn\" id=\"buildMAR_yn\" value=\"N\">\n<!-- added for MMS-QH-CRF-0080 [IN:038064] -->\n<input type=\"hidden\" name=\"trimester\" id=\"trimester\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n<!--added for CRF RUT-CRF-0063[29601] -->\n<input type=\"hidden\" name=\"lmp_date\" id=\"lmp_date\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n<!--added for CRF RUT-CRF-0063[29601] -->\n<input type=\"hidden\" name=\"pregnency_yn\" id=\"pregnency_yn\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n<!--added for CRF RUT-CRF-0063[29601] -->\n<input type=\"hidden\" name=\"pract_type\" id=\"pract_type\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n<!--added for ML-BRU-SCF-0958 [IN:042045] -->\n<input type=\"hidden\" name=\"allergy_conf_reqd_yn\" id=\"allergy_conf_reqd_yn\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n<!--added for ML-BRU-SCF-0958 [IN:042045] -->\n<input type=\"hidden\" name=\"excludeADRAllergyAlert_yn\" id=\"excludeADRAllergyAlert_yn\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n<!--Added for HSA-SCF-0011 [IN:042444] -->\n<input type=\"hidden\" name=\"witness_for_verbal_order_yn\" id=\"witness_for_verbal_order_yn\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n<!-- Added for AAKH-CRF-0023[IN:038259] -->\n<input type=\"hidden\" name=\"login_user_prac_id\" id=\"login_user_prac_id\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n<!-- Added for AAKH-CRF-0023[IN:038259] -->\n<input type=\"hidden\" name=\"dispPrescripionDuration\" id=\"dispPrescripionDuration\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n<!-- Added for BRU-HIMS-CRF-403 [IN:044541] -->\n<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n<!-- TODO insert episode id instead of encounter ID-->\n<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n<!-- Added for HSA-CRF-0152 [IN:048469] -->\n<input type=\"hidden\" name=\"called_from_verbal_order\" id=\"called_from_verbal_order\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n<!-- //added for PMG2012-CRF-0019 [IN:035859] AutoComplete start -->\n<input type=\"hidden\" name=\"default_prev_drug_sel\" id=\"default_prev_drug_sel\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n<input type=\"hidden\" name=\"preview_rx_yn\" id=\"preview_rx_yn\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n<!-- //added for ML-MMOH-CRF-0341 [IN:057179] -->\n<input type=\"hidden\" name=\"allow_priv_to_order_yn\" id=\"allow_priv_to_order_yn\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n<input type=\"hidden\" name=\"drug_seach_autocomplete_yn\" id=\"drug_seach_autocomplete_yn\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n<!-- //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -end -->\n<input type=\"hidden\" name=\"disp_prev_vital_signs_yn\" id=\"disp_prev_vital_signs_yn\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n<!--added for ML-MMOH-CRF-0346 [IN:057185]-->\n<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n<!--added for JD-CRF-198-->\n<input type=\"hidden\" name=\"alternateOrder\" id=\"alternateOrder\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n<!--added for JD-CRF-198-->\n<input type=\"hidden\" name=\"currentStage\" id=\"currentStage\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n<!-- Added for IVRxType -->\n\t<input type=\"hidden\" name=\"ivrxMode\" id=\"ivrxMode\" id=\"ordersModeType\" value=\"\">\t\n\t<input type=\"hidden\" name=\"ivrxOperation\" id=\"ivrxOperation\" id=\"ivrxOperation\" value=\"New\">\n<!-- ticksheet on change dropdown-->\t\n\t<input type=\"hidden\" name=\"ticksheetValue\" id=\"ticksheetValue\" id=\"ticksheetValue\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\t\n\t<input type=\"hidden\" name=\"ticksheetCodeValue\" id=\"ticksheetCodeValue\" id=\"ticksheetCodeValue\" value=\"\">\n\t<input type=\"hidden\" name=\"ticksheetDescValue\" id=\"ticksheetDescValue\" id=\"ticksheetDescValue\" value=\"\">\n <input type=\"hidden\" name=\"PharmPrescriptionMode\" id=\"PharmPrescriptionMode\" id=\"PharmPrescriptionMode\" value=\"RX\">\n <input type=\"hidden\" name=\"ivrxCheck\" id=\"ivrxCheck\" id=\"ivrxCheck\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n <input type=\"hidden\" name=\"cartOpened\" id=\"cartOpened\" id=\"cartOpened\" value=\"N\">\n<!-- Added for height weight check-->\n<input type=\"hidden\" id=\"weight_mandatory\" name=\"weight_mandatory\" id=\"weight_mandatory\" value=\"N\">\n<input type=\"hidden\" id=\"height_mandatory\"  name=\"height_mandatory\" id=\"height_mandatory\" value=\"N\">\n<input type=\"hidden\" id=\"height_weight_mandatory\" name=\"height_weight_mandatory\" id=\"height_weight_mandatory\" value=\"N\">\n \n";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n</form>\n</div>\n</div>\n<div class=\"CSTransactionMessage rxBaseToastContentError\" id=\"transactionMsg2\" style=\"z-index: 900002;\">\n   <img id=\"imgTransactionMsg\" style=\"padding-left:15px;vertical-align:middle;\" src=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="/eIPAD/images/PopError.png\" onclick=\"closeToast()\">\n   <span class=\"rxToastmsg\" id=\"rxToastmsg2\"></span>\n   <div class=\"formValErrorMsgTheme\" id=\"transactionMessageContent\"></div>\n</div>                                           \n<div class=\"ChartSummaryParent ChartSummaryParentTheme\" data-role=\"page\" id=\"RxOrderFieldsDiv\" style=\"display:none;z-index:10002\"></div>\n<script src=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="/eIPAD/js/Pharmacy.js\"></script>\n\n";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals("")){
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
}
else{ 
  	appLocale = new Locale("en");
} 
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){
try{
String patient_id = patientContext.getPatientId();
String encounter_id	= patientContext.getEncounterId();
String patient_class = patientContext.getPatientClass();
String facility_id = patientContext.getFacilityId();
String locale = patientContext.getLocale();
String or_bean_name				= "eOR.OrderEntryBean";
String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
String bean_name			= "ePH.PrescriptionBean_1";
PrescriptionBean_1 bean		= (PrescriptionBean_1)PersistenceHelper.getBeanObject( bean_id, bean_name, request );
String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
String presBean_name		= "ePH.PrescriptionBean";
PrescriptionBean presBean		= (PrescriptionBean)PersistenceHelper.getBeanObject(presBean_id, presBean_name, request );
String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
String param_bean_name				= "ePH.DrugInterfaceControlBean";
DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
String pregn_bean_id = "PregnancyCategory" ;
String pregn_bean_name = "ePH.PregnancyCategoryBean";
PregnancyCategoryBean pregn_bean = (PregnancyCategoryBean)PersistenceHelper.getBeanObject( pregn_bean_id, pregn_bean_name, request ) ;
String ph_bean_id 				= "@DrugSearchBean"+patient_id+encounter_id;
String ph_bean_name 			= "ePH.DrugSearchBean";
DrugSearchBean ph_drug_bean		= (DrugSearchBean)PersistenceHelper.getBeanObject( ph_bean_id, ph_bean_name, request ) ;

String episode_type= patientContext.getPatientClass();
if(episode_type !=null && (!episode_type.equals("")))
	episode_type = episode_type.substring(0,1);
if(episode_type !=null && episode_type.equals("X"))
	episode_type = "R";
 String bed_num="";
 String room_num="";
/* Get Applicable tabs code STARTS */   	
String facilityparam_bean_id	= "FacilityParameter" ;
String facilityparam_bean_name = "ePH.ParameterFacilityBean";
ParameterFacilityBean facilityparam_bean = (ParameterFacilityBean)PersistenceHelper.getBeanObject( facilityparam_bean_id, facilityparam_bean_name, request ) ;
String iv_rx_chk ="";
String comp_rx_chk = "";
ArrayList arrList = (ArrayList)facilityparam_bean.checkForPHFacilityParamExistence(facility_id);
if(arrList.get(66) != null){
	comp_rx_chk = (String)arrList.get(66);
}
if(arrList.get(67) != null){
   	iv_rx_chk = (String)arrList.get(67);
}
String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
String bean_name_IVD	= "ePH.IVPrescriptionBean";
IVPrescriptionBean bean_IVD	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
String bean_name_IVWA	= "ePH.IVPrescriptionBean";
IVPrescriptionBean bean_IVWA	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
String bean_name_IVPB	= "ePH.IVPrescriptionBean";
IVPrescriptionBean bean_IVPB	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
String iv_with_additives = "";
String iv_without_additives = "";
String iv_intermittent = "";
ArrayList ivLegends = bean_IVD.getIvLegends();
if (ivLegends != null && ivLegends.size() > 1) {
	iv_with_additives = (String) ivLegends.get(0);
	iv_without_additives = (String) ivLegends.get(1);
	iv_intermittent = (String) ivLegends.get(2);
}	
/* IVRx description ends */ 
/* Ticksheet starts */ 
orbean.setOrderCategoryYn("PH");
String[] record	 = null;
String order_category = "PH";
String ticksheetValue			= "";
ArrayList TickSheets = orbean.getTickSheet(order_category);
String tickSheetDpList="";
String defaultSelTickSheet="";
if(TickSheets !=null && TickSheets.size()>0)
{	
	record = (String[])TickSheets.get(0);
	defaultSelTickSheet=record[0];
	record = null;
	for(int i=0; i<TickSheets.size(); i++){		
		record = (String[])TickSheets.get(i);
		tickSheetDpList= tickSheetDpList+"<option value='"+((String) record[0])+"'>"+((String) record[1])+"</option>";
		record = null;	
	}
}
String tick_sheet_id = "002";
String order_type = "";
ArrayList SectionDisplay = orbean.getSectionPopulate(order_category,tick_sheet_id,order_type);
		for(int j=0; j<SectionDisplay.size(); j++)
		{
			record = (String[])SectionDisplay.get(j);
			System.out.println(record[0]+ " -- " +record[1]+"");
			record = null;
		} 
/* Ticksheet ends */ 

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);

                              if(comp_rx_chk.equals("Y")){
                              
            _bw.write(_wl_block7Bytes, _wl_block7);

                              }
                              if(iv_rx_chk.equals("Y")){
                              
            _bw.write(_wl_block8Bytes, _wl_block8);

                              }

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(iv_with_additives));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(iv_without_additives));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(iv_intermittent));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(TickSheets !=null && TickSheets.size()>0){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tickSheetDpList));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(csResBundle.getString("common.chartSummary") ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(csResBundle.getString("common.order") ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block33Bytes, _wl_block33);

	/* code extracted from \eHIS\web\ePH\jsp\PrescriptionHeader_1.jsp STARTS */
	String licence=(String)(PhLicenceRights.getKey());
	String version_no=(String) PhVersionNo.getVersion();
	String function_id="PH";	
	String iv_prep_default = ""; //TODO
	String function_from = "";	
	String act_patient_class = patientContext.getPatientClass(); //actual patientclass
	if(patient_class.trim().equals("DC")) 
		patient_class="IP";
	if(patient_class.trim().equals("EM")) 
		patient_class="OP";
	String location_type = "";
	String location_code = "";
	String visit_adm_date = "";	
	EncounterListRequest encReq = new EncounterListRequest();
	encReq.setPatientContext(patientContext);
	EncounterListBC encBC = new EncounterListBC();
	//get the current encounter details
	encReq.setFilterEncounterId(patientContext.getEncounterId());
	EncounterListResponse currentEncResp;
	currentEncResp = encBC.getEncounterList(encReq);
	if(currentEncResp.isSuccessResponse() && !currentEncResp.isEmptyDataResponse()){
		EncounterHO currentEnc = currentEncResp.getEncounterList().get(0);
		if(currentEnc!=null){
			location_type = currentEnc.getAssignCareLocnType();
			if(location_type.equals("W"))
				location_type = "N";
			if(location_type.equals("E"))
				location_type ="C";
			location_code = currentEnc.getAssignCareLocnCode();
			visit_adm_date = currentEnc.getVisitDate();
		}		
	}
	ph_drug_bean.setsource_code(location_code);
	ph_drug_bean.setsource_type(location_type);
	String leg_value_1				= "";
	String leg_uom_1				= "";
	String leg_value_2				= "";
	String leg_uom_2				= "";
	float bsa						= 0f;
	String bsa_str					= "";
	String rec_date					=  "";
	String bmi_str					=  "";
	String visit_date				= "";
	String sys_date					= "";
	String calculated_date			= "";
	String order_type_code_yn		= "";
	String take_medication_yn_chk	= "";
	String take_medication_yn_dis	= "";
	String take_medication_yn_val	= "";
	String home_leave_yn_val	= "";
	String home_leave_disp	= "";
	int homeleave_rec				= 0;
	int homeleave_chk				= 0;
	int medication_rec				= 0;
	String login_user_prac_id		= (String)orbean.getLoginPractId();
	String pract_id					= (String) orbean.getPractitionerId();
	String resp_id					= (String) orbean.getResponsibilityId();
	String pract_reln_id			= (String) orbean.getRelationshipId();
	String pract_name				= (String) orbean.getPractitionerName();
	String attend_pract_id			= (String) orbean.getAttendPractitionerId();
	String order_remarks			= "";
	String man_rem_on_prn_freq_yn	= "";
	boolean MItemsOnly				= false;
	String narcotic_aprvl_form_req_yn	    = "";
	String print_narcotic_form_by_default	= "";
	String rx_qty_by_pres_base_uom_yn	    = "";
	String back_date				= "";
	String future_date				= "";
	String servide_code				= (String) orbean.getServiceCode();
	String service_search_yn		= (String) orbean.getRestrictYn();
	String allow_without_wt			=	"";
	String allow_without_diag		=	"";
	String patient_age				=	"";
	String date_of_birth			=	"";
	String gender				    =	"";
	String atc_allergy_alert_level   =	"N";
	String drug_interaction_check_yn   =	"N";
	String dispPrescripionDuration   =	""; 
	String pract_type   =	(String) orbean.getPractitionerType();
	String generic_id="";
	String alternateOrder="N";
	String currentStage="";
	String height_min_value			= "";
	String height_max_value			= "";
	String weight_min_value			= "";
	String weight_max_value			= "";
	String height_min_digits		= "";
	String height_max_digits		= "";
	String height_dec_digits		= "";
	String weight_dec_digits		= "";
	String weight_min_digits		= "";
	String weight_max_digits		= "";
	String comp_rx_appl_yn			= "N";
	String iv_rx_appl_yn			= "N";
	String oncology_rx_appl_yn		= "N";
	String tpn_rx_appl_yn			= "N";
	String tdm_appl_yn				= "N";	
	String order_set_code = "";
	String	bl_install_yn			=	orbean.getBillingInterfaceYn()	== null ? "" : orbean.getBillingInterfaceYn();
	int adr_count =(int)bean.getADRCount(patient_id,"%");
	String MAR = "";
	String called_from_verbal_order =bean.getCalled_from_verbal_order(); 
	String mode = CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	boolean allergy_conf_reqd_yn = bean.getAllergyConfDtls(patient_id, encounter_id);
	String NBPRequestApplYN = presBean.getNBPRequestAppl(resp_id, pract_reln_id, encounter_id, patient_id);
	String excludeADRAllergyAlert_yn = bean.getExcludeADRAllergyAlert();
	String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
	String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);    
	String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
	String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
	String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
	String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
	String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);   
	String overlap_period_for_op        =   param_bean.getOverlapPeriodForOP(facility_id);
	String overlap_period_for_ip        =   param_bean.getOverlapPeriodForIP(facility_id);
	bean.setOverlapPeriodForOP(overlap_period_for_op);
	bean.setOverlapPeriodForIP(overlap_period_for_ip);
	
	bean_IVD.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
	bean_IVD.setExternalDosageYN(drug_db_dosecheck_yn);
	
	bean_IVWA.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
	bean_IVWA.setExternalDosageYN(drug_db_dosecheck_yn);
	
	bean_IVPB.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
	bean_IVPB.setExternalDosageYN(drug_db_dosecheck_yn);
	
	String allergic_yn				=  "N";
	int num = bean.loadallergydetail(patient_id);
	if(num>0){
		allergic_yn = "Y";
	}
	int index = 0;
	HashMap discr_values	=	presBean.getHgtWgtDtls(patient_id);
	if(discr_values.containsKey("HEIGHT_MIN_VALUE")) {	
		height_min_value	=	(String)discr_values.get("HEIGHT_MIN_VALUE");
		height_max_value	=	(String)discr_values.get("HEIGHT_MAX_VALUE");
		height_min_digits	=	(String)discr_values.get("HEIGHT_MIN_DIGITS");
		height_max_digits	=	(String)discr_values.get("HEIGHT_MAX_DIGITS");
		height_dec_digits	=	(String)discr_values.get("HEIGHT_DEC_DIGITS");
	}
	if(discr_values.containsKey("WEIGHT_MIN_VALUE")) {	
		weight_min_value	=	(String)discr_values.get("WEIGHT_MIN_VALUE");
		weight_max_value	=	(String)discr_values.get("WEIGHT_MAX_VALUE");
		weight_min_digits	=	(String)discr_values.get("WEIGHT_MIN_DIGITS");
		weight_max_digits	=	(String)discr_values.get("WEIGHT_MAX_DIGITS");
		weight_dec_digits	=	(String)discr_values.get("WEIGHT_DEC_DIGITS");
	}

	HashMap appl_orders	=	bean.getApplicableOrders(facility_id);
	if(appl_orders != null){
		comp_rx_appl_yn		=	(String)appl_orders.get("COMP_RX_APPL_YN")==null?"N":(String)appl_orders.get("COMP_RX_APPL_YN");
		iv_rx_appl_yn		=	(String)appl_orders.get("IV_RX_APPL_YN")==null?"N":(String)appl_orders.get("IV_RX_APPL_YN");
		oncology_rx_appl_yn	=	(String)appl_orders.get("ONCOLOGY_RX_APPL_YN")==null?"N":(String)appl_orders.get("ONCOLOGY_RX_APPL_YN");
		tpn_rx_appl_yn		=	(String)appl_orders.get("TPN_RX_APPL_YN")==null?"N":(String)appl_orders.get("TPN_RX_APPL_YN");
		tdm_appl_yn			=	(String)appl_orders.get("TDM_APPL_YN")==null?"N":(String)appl_orders.get("TDM_APPL_YN");
		man_rem_on_prn_freq_yn =(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN")==null?"N":(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN"); 
	}
	HashMap HeaderHtWtValues = (HashMap) presBean.loadHeaderHtWtValues(facility_id,patient_id,encounter_id,act_patient_class);
	if( HeaderHtWtValues.size()>1 ){
		 if(HeaderHtWtValues.containsKey("HEIGHT")){
			leg_value_1		= (String) HeaderHtWtValues.get("HEIGHT");
			leg_uom_1		= (String) HeaderHtWtValues.get("HEIGHT_UOM");
			rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");	
		 }
		if(HeaderHtWtValues.containsKey("WEIGHT")){
			leg_value_2		= (String) HeaderHtWtValues.get("WEIGHT");
			leg_uom_2		= (String) HeaderHtWtValues.get("WEIGHT_UOM");
			rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");	
		 }
		
		bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
		if(leg_uom_1==null) 
			leg_uom_1= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Cms.label", "ph_labels");
		if(leg_uom_2==null) 
			leg_uom_2=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Kgs.label", "common_labels");
		bsa_str			= (String.valueOf(bsa));
		
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)>0 && !leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)>0  ) {
			bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
			index	=	bmi_str.indexOf(".");
			if(bmi_str.length()>=(index+3) ) {
				bmi_str	=(bmi_str.substring(0,index+3));
			}
		}
		if(bsa_str.equals("0.0")) 
			bsa_str= "";
		if(bmi_str.equals("0.0")) 
			bmi_str= "";
	}
	String bl_disp_charge_dtl_in_rx_yn		= "";
	String disp_charge_dtl_in_drug_lkp_yn	= "";
	String disp_price_type_in_drug_lkp	= "";
	String dc_mar_appl_yn				= "";
	String em_mar_appl_yn				= "";
	String ip_mar_appl_yn				= "";
	String op_mar_appl_yn				= "";
	String disch_med_mar_appl_yn		= "";
	String split_based_priority_yn		= "";
	String split_based_drug_class_yn	= "";
	String print_mar_label_yn="";
	String default_prev_drug_sel ="";
	String allow_priv_to_order_yn="";
	String preview_rx_yn ="";
	String disp_prev_vital_signs_yn ="N";
	String max_length_prn_reason		= "";
	String max_durn_for_ip_pres			= "";
	String chk_for_ip_max_durn_action	= "";
	String max_durn_for_op_pres			= "";
	String chk_for_op_max_durn_action	= "";
	String max_durn_for_dm_pres			= "";
	String chk_for_dm_max_durn_action	= "";
	String trade_display_yn				= "";
	String diag_for_medn_order_by="P"; 
	String leave_fm                     ="";
	String leave_to                     ="";
    String tempstartString = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String tempendString  = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String tempsysString  = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String problem_ind = "";	
	ArrayList param_vals	=	bean.getParameterValues();
	if(param_vals!=null && param_vals.size()!=0) {
		int iCount=0;
		allow_without_diag				=	(String)param_vals.get(iCount++); //0
		allow_without_wt				=	(String)param_vals.get(iCount++);
		bl_disp_charge_dtl_in_rx_yn		=	(String)param_vals.get(iCount++);
		disp_charge_dtl_in_drug_lkp_yn	=	(String)param_vals.get(iCount++);
		disp_price_type_in_drug_lkp		=	(String)param_vals.get(iCount++);
		dc_mar_appl_yn					=	(String)param_vals.get(iCount++);
		em_mar_appl_yn					=	(String)param_vals.get(iCount++);
		ip_mar_appl_yn					=	(String)param_vals.get(iCount++);
		op_mar_appl_yn					=	(String)param_vals.get(iCount++);
		disch_med_mar_appl_yn			=	(String)param_vals.get(iCount++);
		split_based_priority_yn			=	(String)param_vals.get(iCount++);//10
		split_based_drug_class_yn		=	(String)param_vals.get(iCount++);
		narcotic_aprvl_form_req_yn		=	(String)param_vals.get(iCount++);
		print_narcotic_form_by_default	=	(String)param_vals.get(iCount++);
		rx_qty_by_pres_base_uom_yn		=	(String)param_vals.get(iCount++);
		atc_allergy_alert_level			=   (String)param_vals.get(iCount++);//15
		iCount++; //added for added for CRF MMS-QH-CRF-0068 [IN:037980] (allow_without_diag_dd)//16
		print_mar_label_yn			=   (String)param_vals.get(iCount++); //Added for MMS-QH-CRF-0080 [IN:038064] //17
		iCount++; // added for  MMS-QH-CRF-0080 [IN:038064] //18
		dispPrescripionDuration	=	(String)param_vals.get(iCount++);//19
		diag_for_medn_order_by=(String)param_vals.get(iCount++);//20 //MMS-SCF-0325 [IN:048069]
		default_prev_drug_sel			=   (String)param_vals.get(iCount++); //21 //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		preview_rx_yn					=	(String)param_vals.get(iCount++);//22//added for ML-MMOH-CRF-0341 [IN:057179]
		disp_prev_vital_signs_yn	=	(String)param_vals.get(iCount++);//23 //Added for ML-MMOH-CRF-0346 [IN:057185]
		max_length_prn_reason			=   (String)param_vals.get(iCount++); //24
		max_durn_for_ip_pres		=	(String)param_vals.get(iCount++); //25
		chk_for_ip_max_durn_action	=	(String)param_vals.get(iCount++);//26
		max_durn_for_op_pres		=	(String)param_vals.get(iCount++);//27
		chk_for_op_max_durn_action	=	(String)param_vals.get(iCount++); //28
		max_durn_for_dm_pres		=	(String)param_vals.get(iCount++);
		chk_for_dm_max_durn_action	=	(String)param_vals.get(iCount++);
		trade_display_yn			=	(String)param_vals.get(iCount++);
		drug_interaction_check_yn	=	(String)param_vals.get(iCount++);//32
		iCount++;//added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		allow_priv_to_order_yn	=	(String)param_vals.get(iCount++);//34 //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
	} 
	String witness_for_verbal_order_yn	= ""; 
	witness_for_verbal_order_yn = bean.getWitnessForVerbalOrder();
	order_remarks	= (String)bean.getPresRemarks();
	LinkedHashMap hmPrev_vital_signs = null;//Added for ML-MMOH-CRF-0346 [IN:057185]
	if("Y".equals(disp_prev_vital_signs_yn) && !("XT".equals(act_patient_class)))//added for ML-MMOH-CRF-0346 [IN:057185]
		hmPrev_vital_signs	=(LinkedHashMap) presBean.loadPrevHtWtValues(facility_id, patient_id,encounter_id, act_patient_class);
	else 
		disp_prev_vital_signs_yn="N";
	HashMap patient_details	=	bean.getPatientDetails_1(patient_id);
	if(patient_details!=null && patient_details.size()!=0) {
		patient_age	=	(String)patient_details.get("age");
		date_of_birth	=	(String)patient_details.get("date_of_birth");
		gender	=	(String)patient_details.get("sex");
		gender	=	gender.substring(0,1).toUpperCase();
	}
	//check for recorded diagnosis
	ArrayList diagnosis	=	bean.checkDiagnosis(patient_id, encounter_id, diag_for_medn_order_by);
	int diag_size	=	(diagnosis).size();
	//getting system date
	//sys_date=(String) DateUtils.getCurrentDate("DMYHM",locale); //Commented for IN031192 - Leap year_CA_Pharmacy order_Thai login
	sys_date=(String) presBean.getSysdate();  //Added for IN031192 - Leap year_CA_Pharmacy order_Thai login
	String pregnency_yn				=presBean.getPregnencyYN(patient_id);//added for CRF RUT-CRF-0063[29601]--start
	String lmp_date                 =presBean.getLMPDate(patient_id);
	double preg_week                =Math.ceil(presBean.getCalPregStage(sys_date,lmp_date));
	String trimester                =presBean.getTrimster(preg_week);
	bean.setPregnencyYN(pregnency_yn);
	bean.setPregTrimester(trimester);//added for CRF RUT-CRF-0063[29601] --end
	bean.setCalledFrom("");
	//getting back date of order date/time
	HashMap BackDates=(HashMap) presBean.getBackDate(sys_date);
	if(BackDates.size()>0){
		back_date			= (String) BackDates.get("BACK_DATE");
		future_date			= (String) BackDates.get("FUTURE_DATE");
	}
	//Added for IN031192 - Leap year_CA_Pharmacy order_Thai login -Start
	if(!locale.equals("en")){
		sys_date =	com.ehis.util.DateUtils.convertDate(sys_date,"DMYHM","en",locale);
		back_date			= com.ehis.util.DateUtils.convertDate(back_date,"DMYHM","en",locale);
		future_date			= com.ehis.util.DateUtils.convertDate(future_date,"DMYHM","en",locale);
	}
	//Added for IN031192 - Leap year_CA_Pharmacy order_Thai login -End
	bean.setOrderDate(sys_date); //Moved from above for IN031192 - Leap year_CA_Pharmacy order_Thai login
	//adding start for Bru-HIMS-CRF-093 [IN:029960]
	HashMap homeleave_vals	=	presBean.getHomeLeaveDates(encounter_id,facility_id);
	ArrayList takeHomeDates = new ArrayList();//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	if(homeleave_vals!=null && homeleave_vals.size()>0){
		leave_fm = (String)homeleave_vals.get("LEAVE_FR_DATE");
		leave_to = (String)homeleave_vals.get("LEAVE_TO_DATE");
		tempstartString  = leave_fm.substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		tempendString  = leave_to.substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		tempsysString = (String) presBean.getSysdate().substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		takeHomeDates.add(leave_fm);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		takeHomeDates.add(leave_to);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		bean.setTakeHomeDates(takeHomeDates);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	}
	homeleave_chk = presBean.getHomeLeaveCHK(tempsysString,tempstartString,tempendString);//adding end for Bru-HIMS-CRF-093 [IN:029960]//Modified for Bru-HIMS-CRF-093-DD1[IN047223]
	//validation for Home Medication
	if(patient_class!=null && patient_class.equals("OP")){
		take_medication_yn_chk	= "";
		take_medication_yn_dis	= "disabled";
		take_medication_yn_val	= "N";
	}
	else{
		if(!patient_class.equals("XT")){			
			medication_rec=(int)bean.getHomeMecdicationYn(encounter_id,facility_id);
		}
		if(medication_rec>0){
			take_medication_yn_chk	= "checked";
			take_medication_yn_dis	= "";
			take_medication_yn_val	= "N";
			patient_class="OP";
		}
		else{
			take_medication_yn_chk	= "";
			take_medication_yn_dis	= "disabled";//not to show discharge medication pop
			take_medication_yn_val	= "N";
		}
	}
	if(patient_class.equals("IP")){			//adding start for Bru-HIMS-CRF-093 [IN:029960]
		homeleave_rec=(int)presBean.getHomeLeaveYn(encounter_id,facility_id);
	}
	if(homeleave_rec>0 && homeleave_chk>0 ){
		home_leave_yn_val	= "Y";
	}
	else
		home_leave_yn_val	= "N"; //adding end for Bru-HIMS-CRF-093 [IN:029960]
	if(patient_class.equals("IP") && home_leave_yn_val.equals("Y")) //adding start for Bru-HIMS-CRF-093 [IN:029960] 
		home_leave_disp = "";
	else
		home_leave_disp = "display:none;";
		
	String or_order_type_code_yn="";
	String or_order_type_value="";
	HashMap OrderType=(HashMap) presBean.populateOrderType(patient_class);
	if(OrderType.size()>0){
		or_order_type_code_yn=(String) OrderType.get("ORDER_TYPE_CODE_YN");
		if(or_order_type_code_yn==null) 
			or_order_type_code_yn="N";
	}
	if(or_order_type_code_yn.equals("Y")){
		or_order_type_value=(String) orbean.getOrderTypeValue();
	}
	else{
		or_order_type_value="";
	}		
	ArrayList	ht_wt_uom	=	presBean.getHTWTUOM(patient_id);
	if(ht_wt_uom!=null && ht_wt_uom.size() > 1) {
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)==0)
			leg_value_1="";
		if(!leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)==0  ) 
			leg_value_2="";
		if(leg_value_1==null || leg_value_1.equals("")) {
			leg_uom_1	=	(String)ht_wt_uom.get(0);	
			if( ht_wt_uom.size() > 2) {
				leg_value_1 =	(String)ht_wt_uom.get(2);	
			}
		}
		if(leg_value_2==null || leg_value_2.equals("")) {
			leg_uom_2	=	(String)ht_wt_uom.get(1);	
			if( ht_wt_uom.size() > 4) {
				leg_value_2 =	(String)ht_wt_uom.get(3);
				rec_date	=	(String)ht_wt_uom.get(4);
			}
		}
		if((leg_value_2==null || leg_value_2.equals("")) &&( leg_uom_1==null || leg_uom_1.equals("")))
			rec_date = "";
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)==0)
			leg_value_1="";
		if(!leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)==0  ) 
			leg_value_2="";
		bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
		bsa_str			= (String.valueOf(bsa));
		if(!leg_value_1.equals("") && !leg_value_2.equals("")) {
			bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
			index	=	bmi_str.indexOf(".");
			if(bmi_str.length()>=(index+3) ) {
				bmi_str	=(bmi_str.substring(0,index+3));
			}
		}
		if(bsa_str.equals("0.0")) 
			bsa_str= "";
		if(bmi_str.equals("0.0"))
			bmi_str= "";
	}	
	/* code extracted from \eHIS\web\ePH\jsp\PrescriptionHeader_1.jsp ENDS */

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(leg_value_1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(leg_value_2));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bsa_str));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bmi_str));
            _bw.write(_wl_block38Bytes, _wl_block38);
if( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("")){ 
            _bw.write(_wl_block39Bytes, _wl_block39);
} else{
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(take_medication_yn_val));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(home_leave_yn_val));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(allergic_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bed_num));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(leg_uom_1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(leg_uom_2));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(calculated_date));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(visit_date));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(order_type_code_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block63Bytes, _wl_block63);

String new_patient_class="";
if( take_medication_yn_val == "Y"){
	new_patient_class="IP";

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(new_patient_class));
            _bw.write(_wl_block63Bytes, _wl_block63);

}else{

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block63Bytes, _wl_block63);

}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(order_remarks));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(attend_pract_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(back_date));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(future_date));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(licence));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(servide_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(service_search_yn));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(problem_ind));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(take_medication_yn_chk));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(take_medication_yn_dis));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(allow_without_wt));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(allow_without_diag));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(diag_for_medn_order_by));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(diag_size));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(bean.getDiagText()==null?" 0 ":(bean.getDiagText()).size()));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(num));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(height_min_value));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(height_max_value));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(weight_min_value));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(weight_max_value));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(height_min_digits));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(height_max_digits));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(weight_min_digits));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(weight_max_digits));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(iv_prep_default));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(order_set_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(bl_disp_charge_dtl_in_rx_yn));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(disp_price_type_in_drug_lkp));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(disp_charge_dtl_in_drug_lkp_yn));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(dc_mar_appl_yn));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(em_mar_appl_yn));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(ip_mar_appl_yn));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(op_mar_appl_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(disch_med_mar_appl_yn));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(split_based_priority_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(split_based_drug_class_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(max_durn_for_ip_pres));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(chk_for_ip_max_durn_action));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(max_durn_for_op_pres));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(chk_for_op_max_durn_action));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(max_durn_for_dm_pres));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(chk_for_dm_max_durn_action));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(trade_display_yn));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(narcotic_aprvl_form_req_yn));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(print_narcotic_form_by_default));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(drug_db_product_id));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(drug_db_duptherapy_yn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(drug_db_interact_check_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(drug_db_contraind_check_yn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(drug_db_allergy_check_yn));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(adr_count));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(MAR));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(MItemsOnly));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(man_rem_on_prn_freq_yn));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(max_length_prn_reason));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(rx_qty_by_pres_base_uom_yn));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(atc_allergy_alert_level));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(NBPRequestApplYN));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(drug_interaction_check_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(home_leave_yn_val));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(leave_fm));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(leave_to));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(print_mar_label_yn));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(bean.getPregTrimester()));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(lmp_date));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(pregnency_yn));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(allergy_conf_reqd_yn));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(excludeADRAllergyAlert_yn));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(witness_for_verbal_order_yn));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(login_user_prac_id));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(dispPrescripionDuration));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(called_from_verbal_order));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(default_prev_drug_sel));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(preview_rx_yn));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(allow_priv_to_order_yn));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(bean.getDrugSeachAutocomplete_yn()));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(disp_prev_vital_signs_yn));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(alternateOrder));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(currentStage));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(defaultSelTickSheet));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(iv_rx_chk));
            _bw.write(_wl_block165Bytes, _wl_block165);

bean_IVD.setATCAllergyLevel(atc_allergy_alert_level);
bean_IVWA.setATCAllergyLevel(atc_allergy_alert_level);
bean_IVPB.setATCAllergyLevel(atc_allergy_alert_level);
PersistenceHelper.putObjectInBean(bean_id,bean,request);
PersistenceHelper.putObjectInBean(or_bean_id,orbean,request);
PersistenceHelper.putObjectInBean(presBean_id,presBean,request);
PersistenceHelper.putObjectInBean(ph_bean_id,ph_drug_bean,request);
PersistenceHelper.putObjectInBean(pregn_bean_id,pregn_bean,request);
PersistenceHelper.putObjectInBean(param_bean_id,param_bean,request);   
PersistenceHelper.putObjectInBean(bean_id_IVD,bean_IVD,request);
PersistenceHelper.putObjectInBean(bean_id_IVWA,bean_IVWA,request);
PersistenceHelper.putObjectInBean(bean_id_IVPB,bean_IVPB,request);
}
catch(Exception e){
	e.printStackTrace();
}
}

            _bw.write(_wl_block166Bytes, _wl_block166);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block168Bytes, _wl_block168);
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
