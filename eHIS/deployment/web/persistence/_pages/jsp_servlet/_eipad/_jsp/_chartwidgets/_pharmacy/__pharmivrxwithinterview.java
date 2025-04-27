package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

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
import ePH.IVPrescriptionBean;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eOR.OrderEntryBean;

public final class __pharmivrxwithinterview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/pharmIvRXWithInterView.jsp", 1709118021381L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="/eIPAD/js/pharmIvRxDetailsViewIntermitant.js\"></script> \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\n <form id=\"formIVPBDrugDetails\" name = \"formIVPBDrugDetails\" method = \"post\" action = \"\" class=\"ChartSummaryFormElem\">\n<div data-role = \"none\"  class = \"blurPopup\" onclick=\"\" data-popid=\"\" style=\"z-index:10000\"></div>\n   <div class=\"ChartSummaryBlockVar\" id=\"rxDetailsSummaryBlock\" data-role = \"none\">     \n         <div class=\"ChartSummaryMainTable\" data-role = \"none\">          \n\t\t\t<div data-role = \"none\" class =\"ChartSummaryPageHeader\">\n               <div class=\"ChartSummaryHeaderCell\" data-role = \"none\">\n                  <div class=\"ChartSummaryHeaderCont\" data-role = \"none\">\n                     <div class=\"ChartSummaryHeaderTable ChartSummaryHeaderTableTheme\" data-role = \"none\">\n                        <div class=\"ChartSummaryHeaderRow\" data-role = \"none\">\n                           <div class=\"ChartSummaryHeaderTextCol\" data-role = \"none\">\n                              <div class=\"ChartSummaryHeaderText ChartSummaryHeaderTextTheme\" data-role = \"none\">IV</div>\n                           </div>\n                           <div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n                              <div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"completeIvRxDetailsConfirm()\"><img src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/CS_Ok16x16.png\"></div>\n                           </div>\n                           <div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n                              <div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"closeRxDetailsView()\"><img src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/CS_Close16x16.png\"></div>\n                           </div>\n                        </div>\n                     </div>\n                  </div>\n               </div>\n            </div>\t\t\t\n            <div data-role = \"none\" class = \"ChartSummaryPageContent ChartSummaryPageContentTheme\" id=\"\">\n               <div data-role = \"none\" class = \"ChartSummaryPageContentCell\">\n                  <div data-role = \"none\" class = \"ChartSummaryMainWrapper pharmDataMainWrapper\" id=\"\" >\n                     <div class=\"ChartSummaryMainScroller pharmDataContentScroller\"  data-role = \"none\">\t\t\t\t\t \t\t\t\t\t \n                        <div class=\"table\" style=\"width:100%;height:100%;\" data-role = \"none\">\t\n                           <div  class=\"row ivrxDetailsViewHeaderRowWrapper\" data-role = \"none\">\n                              <div class=\"cell\"  data-role = \"none\">\n                                 <div class=\"table\" style=\"width:100%;height:75%;\" data-role = \"none\">\n                                    <div  class=\"row pharmItemDescNameCell\"  data-role = \"none\">\n                                       <div class=\"cell pharmRxOrderItemName segoeuiBold\"  data-role = \"none\">\n                                          <span class=\"pharmRxOrderItemName10padding\">IV intermittent\n                                          </span>\n                                       </div>\n\t\t\t\t\t\t\t\t\t   <div class=\"cell pharmRxOrderItemIcons\"  data-role = \"none\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"pharmRxOrderItemIconsVRalign\">\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/images/externalDatabase25X25.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t</span>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t\t\t<span id=\"span_beyondDoseLimit\" name=\"span_beyondDoseLimit\" class=\"pharmRxOrderItemIconsVRalign\" style=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/images/beyondDoseLimit25X25.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t</span>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t<span id=\"span_duplicateDrug\" name=\"span_duplicateDrug\" class=\"pharmRxOrderItemIconsVRalign\"  style=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/images/duplicateDrug25X25.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t</span>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t<span id=\"span_allergy\" class=\"pharmRxOrderItemIconsVRalign\">\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/pharmAllergy25X25.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t</span>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"pharmRxOrderItemIconsVRalign\" style=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/eIPAD/images/authorizeRxDet25X25.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" class=\"BannerIndicators\"/>\n\t\t\t\t\t\t\t\t\t\t\t</span>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/eIPAD/images/cosignRxDet25X25.png\" class=\"imgBannerIndicator\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"pharmRxOrderItemIconsVRalign\" style=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =";padding-right:10px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/eIPAD/images/Specialapproval.png\" class=\"imgBannerIndicator\">\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" class=\"BannerIndicators\"/>\n\t\t\t\t\t\t\t\t\t\t\t</span>  \n\t\t\t\t\t\t\t\t\t   </div>\n                                    </div>\n                                    <div  class=\"row pharmItemDescNameCell\"  data-role = \"none\">\n                                       <div class=\"cell pharmRxOrderStrength\"  data-role = \"none\">\n\t\t\t\t\t\t\t\t\t      <div class=\"pharmRxOrderItemDesc\">\n                                             <label class=\"pharmRxOrderItemLabel\">Dispense Location</label>\n                                             <span class=\"pharmRxOrderItemInfo segoeuiBold\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</span>\n                                          </div>\n                                       </div>\n                                       <div class=\"cell pharmRxOrderItemRate\"  data-role = \"none\">\n                                          <span class=\"pharmRxOrderItemRateDesc\">-- / --</span>\n                                       </div>\n                                       <div class=\"cell pharmRxOrderItemRate\"  data-role = \"none\">\n                                          <span class=\"pharmRxOrderItemRateLabel\">Total / Patient</span>\n                                       </div>\n                                    </div>\n                                    <div  class=\"row pharmCartBottomContainer\"  data-role = \"none\">\n                                       <div class=\"cell pharmCartBottomImg\" data-role = \"none\">\t\t\t\t\t\t\t\t\t\t \n                                       </div>\n                                    </div>\n                                 </div>\n\t\t\t\t\t\t\t\t <div class=\"table ivHeaderWrapper\">\n\t\t\t\t\t\t\t\t    <div class=\"row fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t   <div class=\"cell ivHeaderWrapperContent\">\n\t\t\t\t\t\t\t\t\t      <div  class=\"drugDetailsTab segoeuiBold\"  id=\"IVRxDrugTab\"  onclick=\"openDrugDetailsTab()\">Drug Details</div>\n\t\t\t\t\t\t\t\t\t\t  <div class=\"adminDetailsTab segoeuiBold\"   id=\"IVRxAdminTab\" onclick=\"openAdminDetailsTab()\">Administration Details</div>\n\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t </div>\n                              </div>\n                           </div>\t\t\t\t   \t\t\t\t\t\t   \n                           <!-- Drug details tab starts-->\t\t\t\t\t\t\t \n                            <div id=\"drugDetailsIvRxScroller\" class=\"row ivrxDetailsViewContentRowWrapper1\" data-role = \"none\">\n                                <div class=\"detailsViewMainWrapper\" >\t\t\t\t\t\n\t\t\t\t\t\t\t\t    <div class=\"fullWidth\" style=\"border-bottom: 1px solid #e4e8ec;\"> \n\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t    <div class=\"ivrxDrugHeader segoeuiBold\" style=\"padding-bottom:5px;\">\n\t\t\t\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t    <div style=\"display:flex;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 5px;\">\n\t\t\t\t\t\t\t\t\t\t\t   Calculate By <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>                                          \n\t\t\t\t\t\t\t\t\t\t\t <div class=\"fullWidth\" >\n                                             <select class=\"ivWidth100Important\" id=\"ivInterCalcBy\" name=\"ivInterCalcBy\" id=\"ivInterCalcBy\" onchange=\"onSelectCalculateBy()\">  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n                                             </select>\n                                          </div>\n\t\t\t\t\t\t\t\t\t\t </div>\n                                         <div style=\"width:0.6%\"></div>\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom:5px;\" >\n\t\t\t\t\t\t\t\t\t\t\t   Dosage By <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"fullWidth\" >\n                                             <select style=\"width:99.5%\" id=\"ivInterDosageBy\" name=\"ivInterDosageBy\" id=\"ivInterDosageBy\">  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="                                      \n                                             </select>\n                                            </div>\n\t\t\t\t\t\t\t\t\t\t </div>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t    </div>                                    \t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div id=\"dynamicContentWrapper\" class=\"interDetailsViewWrapper interDynamicContentWrapperCss paddingLeftRight10px\">\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div id=\"strengthWrapper\"  class=\"table doseDetailsWrapperCss\" >\n\t\t\t\t\t\t\t\t\t\t <div id=\"doseLabel\" class=\"row\" >\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell IVrxLabel segoeuiBold\" style=\"padding-bottom:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t      <div id=\"strength_dosage_lable\" style=\"display:inline-block;\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" </div><div style=\"display:inline-block;\"><font style=\"color: red;padding-left:2px;\">*</font></div>\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell halfHtHalfWt\" >\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                           <div id=\"doseInput\" class=\"row fullWtHalfHt\">\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\">\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"ivrxDrugUnit k-textbox\" style=\"height:43px;width:98%;\" id=\"str_qty_units\" class=\"ivrxstrenghtUnit\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" maxlength=\"11\" onKeyPress=\"allowValidNumber(this,event,8,2);\" onchange=\"setCalculatedQty(this); DosageLimitCheck(this);setDrugDosageDetails();\" />\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell detailsCell\">\t\t\t\t\t\t\t\t\t\t\t      \n\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"dropDown interDurationTime\" id=\"dosageUnitIvwithInterDuration\">\n                                                    <select style=\"width: 100%\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" id=\"ivstrenghtRateUnit\">   \n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n                                                    </select>\n                                                  </div>\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t    </div>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div id=\"ivIntermitantDIOveride\" class=\"interTextareaWrapper\" style=\"padding-top:1px\">\n\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\" style=\"padding-left:5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 3px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    Drug indication\n                                                     </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t     <textarea class=\"k-textbox\" style=\"height:57px;width:98.5%;\" maxlength=\"255\" id=\"Drug_indication\" name=\"Drug_indication\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<!-- Body Weight section starts -->\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div id=\"ivRxbodyWt\">\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t <div id=\"doseDetailsWrapper\" class=\"table doseDetailsWrapperCss\" >\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseLabel\" class=\"row fullWtHalfHt\" >\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell IVrxLabel segoeuiBold fullHtHalfWt\" >\n\t\t\t\t\t\t\t\t\t\t\t      <span>Dose</span><font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\" >\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"doseInput\" class=\"row fullWtHalfHt\" >\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\" >\n\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"ivrxDrugUnit k-textbox\" id=\"body_weight_dose\" style=\"height:43px;width:98%\" onblur=\"calculateDosage_By_BSA_or_Weight(\'\');\" maxlength=\"7\" onKeyPress=\"allowValidNumber(this,event,3,3);\"  SIZE=\"10\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell detailsCell\">\n\t\t\t\t\t\t\t\t\t\t\t      \n\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"interDurationTime\" id=\"dosageUnitIvwithAdd\">\n                                                    <select style=\"width: 100%\" id=\"ivInterDosageUnit\">\n                                                    ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n                                                    </select>\n                                                  </div>\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t <div id=\"divider\" class=\"table ivIntermittentdivider\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"row fullWtHalfHt\" >\n\t\t\t\t\t\t\t\t\t\t\t  <div class=\"cell dividerContent\" >\n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"inetrDividerCommon\" style=\"left:1px;\">/</div>\n\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t     </div>\n\t\t\t\t\t\t\t\t\t\t <div id=\"ivIntermitantdoseUnitsWrapper\" style=\"padding-left:5px;\" class=\"table ivRxInterDoseUnitWrapper\" >\n\t\t\t\t\t\t\t\t\t\t    <div class=\"row fullWtHalfHt\">\n\t\t\t\t\t\t\t\t\t\t\t  <div class=\"cell fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"ivIntermitantdoseUnitInput\" class=\"row fullWtHalfHt\" >\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t     <div class=\"table\" style=\"width:48.5%;height:100%;float:left;\">\n\t\t\t\t\t\t\t\t\t\t\t       <div class=\"row fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"cell\" style=\"width:99%;height:100%;\">\t\t\t\t\t\t\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"dropDown interDurationTime\" id=\"ivIntermitantdosageUnitDetails\" >\n                                                         <select style=\"width: 100%\" id=\"ivInterDosageUnitValues\" value=\"\">     \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n                                                         </select>\n                                                        </div>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t         </div>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n                                                  </div>\n                                                  <div style=\"float:left;padding:12px 0px 12px 0px;\">=</div>    \t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"table\" style=\"width:49%;height:100%;float:left;\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"row fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t\t        <div class=\"cell\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"\" style=\"padding-left:0px;position:relative;\">\n                                                          <input type=\"text\" style=\"height:43px;width:99%;\" class=\"ivrxDoseDrugUnit k-textbox\" id=\"strength_weight_dose\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" onchange=\"setCalculatedQty(this); DosageLimitCheck(this);setDrugDosageDetails();\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"pharHtWtTextboxUnit pharHtWtTextboxUnitCss\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</div>  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t            </div>\n\t\t\t\t\t\t\t\t\t\t\t\t     </div>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t </div>\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t<!-- Body Weight section ends -->\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t<div id=\"ivrxBeyondDosageOvverride\" class=\"table interTextareaWrapper\" style=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t\t\t\t\t\t\t\t       <div class=\"row fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"cell positionRelative\" >\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 5px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t  Beyond dosage limit override reason \n\t\t\t\t\t\t\t\t\t\t\t\t\t    <font style=\"color: red\">*</font>\n                                                     </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t     <textarea class=\"k-textbox\" style=\"height:57px;width:100%;\" id=\"txtivInterBeyDosageOveride\" name=\"txtivInterBeyDosageOveride\" maxlength=\"255\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div id=\"intermitantDivider\" class=\"table ivInterDividerSpace\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"row fullWtHalfHt\">\n\t\t\t\t\t\t\t\t\t\t\t  <div class=\"cell dividerContent\">\n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"inetrDividerCommonstyle\"></div>\n\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t     </div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t<div id=\"ivIntermitantDuplicateOveride\" class=\"interTextareaWrapper\" style=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 5px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    Duplicate drug override reason \n\t\t\t\t\t\t\t\t\t\t\t\t\t    <font style=\"color: red\">*</font>\n                                                     </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t     <textarea class=\"k-textbox\" style=\"height:57px;width:100%;\" id=\"txtivInterDupOveride\" name=\"txtivInterDupOveride\" maxlength=\"255\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\n\t\t\t\t\t\t\t\t\t\t<div id=\"ivIntermitantAllergyOveride\" class=\"interTextareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\" >\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 5px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    Allergy override reason <font style=\"color: red\">*</font>\n                                                     </div>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t     <textarea class=\"k-textbox\" style=\"height:57px;width:100%;\" id=\"txtivInterAllergyOveride\" name=\"txtivInterAllergyOveride\" maxlength=\"255\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div id=\"ivrxInterBuildMAR\" class=\"interTextareaWrapper\">\n\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\" style=\"padding-left:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 3px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tBuild MAR\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"interInputWrap\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input style=\"height: 20px;width: 20px;\" name=\"buildMAR_yn\" id=\"buildMAR_yn\" id=\"buildMAR_yn\" value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" type=\"checkbox\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \t\t\n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div id=\"ivIntermitantAddMix\" class=\"interTextareaWrapper\" >\n\t\t\t\t\t\t\t\t\t\t       <div class=\"fullHtFullWt\">\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"positionRelative\" style=\"padding-left:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t     <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 4px;\">\n\t\t\t\t\t\t\t\t\t\t\t           Admixture\n\t\t\t\t\t\t\t\t\t\t\t         </div>\n\t\t\t\t\t\t\t\t\t\t\t         <div class=\"interInputWrap\" >\n                                                       <input style=\"height: 20px;width: 20px;\" ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="  id=\"Admixture\" name=\"Admixture\" type=\"checkbox\" />\n                                                     </div> \n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t       </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t    </div>\n                                    <div id=\"ivIntermitantFluidDetailsWrapper\"  style=\"height: 150px;max-height:1000px;\" class=\"interFluidDetailWrapper\" >\n\t\t\t\t\t\t\t\t\t  <div id=\"ivIntermitantFluidDetailsContent\" style=\"max-height:1000px;\" class=\"interFluidDetailContent\">\n\t\t\t\t\t\t\t\t\t    <div class=\"interFluidLabel segoeuiBold\">\n\t\t\t\t\t\t\t\t\t     Fluid Details\n\t\t\t\t\t\t\t\t        </div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:flex;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 5px;\">\n\t\t\t\t\t\t\t\t\t\t\t   Fluid <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                            <div  class=\"dropDown\" id=\"ivIntermitantfluidName\" class=\"fluidnameCss\" style=\"width:99%;height:27px;\">\n                                                    <select style=\"width: 100%\" data-value-primitive=\"true\"  name=\"ivIntermitantFluidNameValues\" id=\"ivIntermitantFluidNameValues\" id=\"ivIntermitantFluidNameValues\" >                                            \n                                                    </select>\n                                            </div>  \n\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t <div style=\"width:0.2%\"></div>\n\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom: 5px;\">\n\t\t\t\t\t\t\t\t\t\t\t   Volume <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                            <div class=\"interInputWrap\">\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\n                                            <input style=\"height:43px;width:99.5%;\" type=\"text\" id=\"volume_value\"  class=\"k-textbox\" name=\"volume_value\" id=\"volume_value\"  onblur=\"setFluidVolume(this); calInfuseOver();setSchedule();\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" maxlength=\"5\" class=\"interFluidvolumeCss ivrxDrugUnit\"/>\n\t\t\t\t\t\t\t\t\t\t\t  <div class=\"pharHtWtTextboxUnit pharHtWtTextboxUnitCss\" id=\"volume_unit\" style=\"\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</div>     \n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                            </div>\n\t\t\t\t\t\t\t\t\t\t </div>\n                                        </div>\n\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t</div>\n                                </div> \t\t\t\t\t\t\t\t\t\n                             </div>\n\t\t\t\t\t\t\t <!-- Drug Details Tab ends -->\n\t\t\t\t\t\t\t<!-- Pharmacy legend starts-->  <div id=\"ivRxInterLegend\"></div> <!-- Pharmacy legend ends --> \t\t\t\t\t\t\t\n\t\t\t\t\t\t\t <!-- Admin Details Tab Starts -->\n                            <div id=\"administrationDetailsIvRxScroller\" class=\"row selectPharmOrder pharmOrderRxInterItemContainer\"  data-role = \"none\">\n                                <div class=\"detailsViewMainWrapper\" >\t\t\t\t\t\n\t\t\t\t\t\t\t\t    <div class=\"fullWidth\">\t   \t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t        <div style=\"display:flex;padding-top:15px;height:80px;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t   Infusion rate <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t <div id=\"ivIntermitantdoseDetailsWrapper\" style=\"width:100%;\" class=\"table ivInterDoseDetailsWrapper\" >\n                                           <div id=\"\" class=\"row fullWtHalfHt\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\" style=\"\">\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t    <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" class=\"ivrxDrugUnit k-textbox\" style=\"height:43px;width:98%\" id=\"INFUSION_VALUE\" maxlength=\"10\" name=\"INFUSION_VALUE\" id=\"INFUSION_VALUE\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" onchange=\"calInfuseOver();\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"pharHtWtTextboxUnit pharHtWtTextboxUnitCss\" id=\"inFusion_units\" name=\"inFusion_units\" style=\"\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</div>    \n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t   <div id=\"divider\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"row fullWtHalfHt\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"cell dividerContent\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div id=\"\" style=\"left:-5px;top:14px;position:absolute;\" class=\"\" >/</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell detailsCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"dropDown\" id=\"\" style=\"width:100%;height:27px;\">\n                                                    <select style=\"width: 100%\" id=\"infusionRateUnit\" value=\" \"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" >Minutes</option>\n\t\t\t\t\t\t\t                         <option value=\"H\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" >Hours</option>\n                                                    </select>\n                                                  </div>\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t </div>\n                                         <div style=\"width:0.6%\"></div>\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\" style=\"height:92px\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t   Infuse over <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t <div id=\"doseDetailsWrapper\" class=\"table\" style=\"width:100%;height:65px;float:left;\">\n                                              <div id=\"doseInput\" class=\"row fullWtHalfHt\">\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\" style=\"height:43px;width:98%;\" class=\"ivrxDrugUnit k-textbox\" id=\"infusion_over_hrs\" name=\"infusion_over_hrs\" id=\"infusion_over_hrs\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" maxlength=\"2\" onChange=\"CheckNum(this);calInfusionRate();showAdminRate();\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"pharHtWtTextboxUnit pharHtWtTextboxUnitCss\" style=\"\">Hrs</div> \n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell detailsCell\" style=\"padding-right:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"ivRxInterContentKgLabel\" style=\"padding-left:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t <input style=\"width:100% ! important;height:43px;\" class=\"dropDown ivrxDosageByCss k-textbox\" type=\"text\" id=\"infusion_over_mins\" name=\"infusion_over_mins\" id=\"infusion_over_mins\"  maxlength=\"2\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" onChange=\"CheckNum(this);calInfusionRate();showAdminRate();\"/>\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t     <div id=\"infuse_over_str\" class=\"infuseOverCss\"style=\"\" name=\"infuse_over_str\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"ivInterInfuseUnit\" style=\"\">mins</div> \t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                        </div>\t\t\n\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:flex;\" class=\"paddingLeftRight10px\"> \n\t\t\t\t\t\t\t\t\t\t<div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t   Frequency <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                            <div class=\"interInputWrap\">\n\t\t\t\t\t\t\t\t\t\t\t<select  style=\"width:100%\"  id=\"frequencyList\" class=\"interFluidvolumeCss ivrxDrugUnit\">\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</select>\n                                            </div>\n\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t <div style=\"width:0.6%\"></div>\n\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t   Duration for repeat\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t   <div id=\"doseDetailsWrapper\" class=\"table interDurationRepeat\">\n                                           <div id=\"doseInput\" class=\"row fullWtHalfHt\">\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell fullHtHalfWt\">\n\t\t\t\t\t\t\t\t\t\t\t      <div class=\"pharContentKgLabel\" style=\"padding-left:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t      <input type=\"text\"  class=\"k-textbox\" style=\"height:43px;width:98%;\" id=\"Duration_for_repeat\" onblur=\"calEndDate();\" name=\"Duration_for_repeat\" id=\"Duration_for_repeat\" maxlength=\"2\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" class=\"ivrxDrugUnit\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"pharHtWtTextboxUnit pharHtWtTextboxUnitCss\"  style=\"\"></div> \n\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"cell detailsCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"dropDown interDurationTime\" id=\"dosageUnitIvwithInterDuration\">\n                                                    <select style=\"width: 100%\" id=\"ivInterinfusionRateUnit\">    ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="                                       \n                                                    </select>\n                                                  </div>\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t </div>  \t\n                                         </div>\t\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:flex;\" class=\"paddingLeftRight10px\">\n\t\t\t\t\t\t\t\t\t\t <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t   Start date and time <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                            <input style=\"width:100% ! important\" class=\"dropDown\"   id=\"ivInterStartDate\" onBlur=\"chkBackFutureDate(this,\'en\');calEndDate()\" value=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" />  \n\t\t\t\t\t\t\t\t\t\t  </div>\n                                          <div style=\"width:0.6%\"></div>\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t  <div class=\"ivrxContainer\">\n\t\t\t\t\t\t\t\t\t\t    <div class=\"IVrxLabel segoeuiBold\" style=\"padding-bottom:5px;\">\n\t\t\t\t\t\t\t\t\t\t\t   End date and time <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                            <input style=\"width:99.5% ! important;\" class=\"dropDown ivrxDosageByCss\" type=\"text\" id=\"ivInterEndDate\" readonly=\"readonly\" maxlength=\"8\" value=\"0\"/>\n\t\t\t\t\t\t\t\t\t\t  </div>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t    </div>\t\t\t\t\t\t\t\t\t\n                                    </div>\n                                </div>\t\n                            </div>\n\t\t\t\t\t\t\t <!-- Admin Details Tab Ends -->\n                        </div>\t\t\t\t\t\t   \t  \n                      </div>\t\t\t\t\t\t\n                    </div>\n                </div>\n               </div>\n            </div> \t\t\n        </div>\n                <input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"/>\t<INPUT TYPE=\"hidden\" name=\"FORM_CODE\" id=\"FORM_CODE\" VALUE=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\t\t\n\t\t        <INPUT TYPE=\"hidden\" name=\"ABC\" id=\"ABC\" VALUE=\"ABC\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"DRUG_CODE\" id=\"DRUG_CODE\" VALUE=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"TRADE_CODE\" id=\"TRADE_CODE\" VALUE=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"TRADE_NAME\" id=\"TRADE_NAME\" VALUE=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"start_date\" id=\"start_date\" VALUE=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"end_date\" id=\"end_date\" VALUE=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"sys_date\" id=\"sys_date\" VALUE=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\t\t\t\t\t\t\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"PRES_QTY_VALUE\" id=\"PRES_QTY_VALUE\" VALUE=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"PRES_BASE_UOM\" id=\"PRES_BASE_UOM\" VALUE=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"UOM_CODE\" id=\"UOM_CODE\" VALUE=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"dosage_unit\" id=\"dosage_unit\" VALUE=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"STRENGTH_UOM_DESC\" id=\"STRENGTH_UOM_DESC\" VALUE=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"STRENGTH_UOM_CODE\" id=\"STRENGTH_UOM_CODE\" VALUE=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"STR_VAL\" id=\"STR_VAL\" VALUE=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ORDERSET_STRENGTH\" id=\"ORDERSET_STRENGTH\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"QTY_DESC_CODE\" id=\"QTY_DESC_CODE\" VALUE=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"mode\" id=\"mode\"\tvalue=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"patient_class\" id=\"patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"bean_id\" id=\"bean_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"\t>\n\t\t\t\t<input type=\"hidden\"\tname=\"bean_name\" id=\"bean_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"\t>\n\t\t\t\t<input type=\"hidden\"\tname=\"patient_id\" id=\"patient_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"\t>\n\t\t\t\t<input type=\"hidden\"\tname=\"encounter_id\" id=\"encounter_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"patient_ids\" id=\"patient_ids\"\t\tvalue=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"\t>\n\t\t\t\t<input type=\"hidden\"\tname=\"encounter_ids\" id=\"encounter_ids\"\t\tvalue=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"iv_bean_id\" id=\"iv_bean_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"\t>\n\t\t\t\t<input type=\"hidden\"\tname=\"iv_bean_name\" id=\"iv_bean_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"f_i_flag\" id=\"f_i_flag\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\t\n\t\t\t\t<input type=\"hidden\"\tname=\"mono_graph\" id=\"mono_graph\"\tvalue=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"daily_dose\" id=\"daily_dose\"\t\tvalue=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"unit_dose\" id=\"unit_dose\"\t\tvalue=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"min_daily_dose\" id=\"min_daily_dose\"\tvalue=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"min_unit_dose\" id=\"min_unit_dose\"\tvalue=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"recom_dosage_unit\" id=\"recom_dosage_unit\"\tvalue=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"drug_desc\" id=\"drug_desc\"\t    value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"recomm_yn\" id=\"recomm_yn\"\t    value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"dosage_std\" id=\"dosage_std\"\t    value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"recomm_dosage_by\" id=\"recomm_dosage_by\"\t    value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"calc_by_ind\" id=\"calc_by_ind\"\t    value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"tdmOrderId\" id=\"tdmOrderId\"\t    value=\"\">\n\t\t\t\t<input type=\"hidden\"\tname=\"order_set_code\" id=\"order_set_code\"\tvalue=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"dosage_by\" id=\"dosage_by\"\tvalue=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"MAR_app_yn\" id=\"MAR_app_yn\"\tvalue=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"generic_id\" id=\"generic_id\"\t    value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\t\n\t\t\t\t<input type=\"hidden\"\tname=\"generic_name\" id=\"generic_name\"\t    value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"limit_ind\" id=\"limit_ind\"\t    value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"allergy_yn\" id=\"allergy_yn\"\t    value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"current_rx\" id=\"current_rx\"\t    value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"srl_no\" id=\"srl_no\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"allergy_desc\" id=\"allergy_desc\"\t    value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"exceed_dose_desc\" id=\"exceed_dose_desc\"\tvalue=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t\t<input type=\"hidden\"\tname=\"dup_drug_desc\" id=\"dup_drug_desc\"\tvalue=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"> \n\t\t\t\t<input type=\"hidden\"\tname=\"order_id\" id=\"order_id\"\tvalue=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"> \n\t\t\t\t<input type=\"hidden\"\tname=\"iv_fluid_yn\" id=\"iv_fluid_yn\"\tvalue=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"> \n\t\t\t\t<input type=\"hidden\"\tname=\"selected_b\" id=\"selected_b\" id=\"selected_b\"\tvalue=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"> \t\t\t\t\n\t\t\t\t<input type=\"hidden\"\tname=\"in_durn_desc\" id=\"in_durn_desc\"\tvalue=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"> \t\t\t\t\t\t\t\t\t\t\t\t\n<!-- Below 2 hidden fields added  for IN23745 --16/09/2010-- priya  to hold the actual strength and eq qty value from setup-->\n\t\t\t\t<input type=\"hidden\"\tname=\"strength_per_value_pres_uom\" id=\"strength_per_value_pres_uom\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drug_strength_value\" id=\"drug_strength_value\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t<!-- for validating ivapplicapable parameter in PH PARAMETER FOR FACILITY -->\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t<!-- <input type=\"hidden\"\tname=\"time_flag\" id=\"time_flag\"\tvalue=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"> -->\n\t\t\t\t\t<input type=\"hidden\"\tname=\"alert_practitioner_yn\" id=\"alert_practitioner_yn\"\tvalue=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t<input type=\"hidden\"\tname=\"AUTH_YN_VAL\" id=\"AUTH_YN_VAL\"\t    value=\"Y\">\n\t\t\t\t\t<input type=\"hidden\"\tname=\"APPROVAL_YN_VAL\" id=\"APPROVAL_YN_VAL\"\tvalue=\"Y\">\n\t\t\t\t\t<input type=\"hidden\"\tname=\"COSIGN_YN_VAL\" id=\"COSIGN_YN_VAL\"\tvalue=\"Y\">\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t<input type=\"hidden\"\tname=\"AUTH_YN_VAL\" id=\"AUTH_YN_VAL\"\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\"\tname=\"APPROVAL_YN_VAL\" id=\"APPROVAL_YN_VAL\"\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\"\tname=\"COSIGN_YN_VAL\" id=\"COSIGN_YN_VAL\"\tvalue=\"\">\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t<!--end here -->\n\t\t\t\t<input type=\"hidden\" name=\"perform_external_database_checks_yn\" id=\"perform_external_database_checks_yn\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"external_product_id\" id=\"external_product_id\"     value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"fract_dose_round_up_yn\" id=\"fract_dose_round_up_yn\"  value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason\" id=\"external_dosage_override_reason\" value=";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =">\n\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason\" id=\"external_duplicate_override_reason\" value=";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =">\n\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason\" id=\"external_interaction_override_reason\" value=";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =">\n\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason\" id=\"external_contra_override_reason\" value=";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =">\n\t\t\t\t<input type=\"hidden\" name=\"external_alergy_override_reason\" id=\"external_alergy_override_reason\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drug_db_dose_check_flag\" id=\"drug_db_dose_check_flag\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_dup_check_yn\" id=\"ext_med_alerts_fired_for_dup_check_yn\" value=\"drug_db_duptherapy_flag\">\n\t\t\t\t<!-- <input type=\"hidden\" name=\"ext_med_alerts_fired_for_inte_check_yn\" id=\"ext_med_alerts_fired_for_inte_check_yn\" value=\"interaction_override_reason_flag\"> -->\n\t\t\t\t<!--<input type=\"hidden\" name=\"ext_med_alerts_fired_for_contra_check_yn\" id=\"ext_med_alerts_fired_for_contra_check_yn\" value=\"contraind_override_reason_flag\">-->\n\t\t\t\t<!--<input type=\"hidden\" name=\"ext_med_alerts_fired_for_inte_check_yn\" id=\"ext_med_alerts_fired_for_inte_check_yn\" value=\"drug_db_interact_check_flag\">-->\n\t\t\t\t<!--<input type=\"hidden\" name=\"ext_med_alerts_fired_for_contra_check_yn\" id=\"ext_med_alerts_fired_for_contra_check_yn\" value=\"drug_db_contraind_check_flag\">-->\n\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_allergy_check_yn\" id=\"ext_med_alerts_fired_for_allergy_check_yn\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"back_date\" id=\"back_date\"\t\tvalue=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"future_date\" id=\"future_date\"\t\tvalue=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\"\t\tvalue=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"route_code\" id=\"route_code\"\t\tvalue=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"DrugIndicationRemarks\" id=\"DrugIndicationRemarks\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\"><!--Added for  ML-BRU-CRF-072[Inc:29938]-->\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"type\" id=\"type\"  id=\"type\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"type\"  id=\"qty_value\" name=\"qty_value\" id=\"qty_value\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"calcBy\" id=\"calcBy\"  id=\"calcBy\" value=\"D\">\n\t\t\t\t\t\n\t<input type=\"hidden\" name=\"INFUSION_PERIOD_VALUE\" id=\"INFUSION_PERIOD_VALUE\" id=\"INFUSION_PERIOD_VALUE\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\"\t\tvalue=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"\t\t>\n\t\t\t<input type=\"hidden\" name=\"END_DATE_TIME\" id=\"END_DATE_TIME\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"freq_changed_yn\" id=\"freq_changed_yn\" value=\"N\">\n\t\t\t\n\t\t\t<!-- <input type=\"hidden\" name=\"INFUSION_PERIOD_UOM\" id=\"INFUSION_PERIOD_UOM\"\tvalue=";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="> -->\n\t\t\t<input type=\"hidden\" name=\"INFUSION_PERIOD_UOM\" id=\"INFUSION_PERIOD_UOM\"\tvalue=\"H\">\n\t\t\t<input type=\"hidden\" name=\"INFUSION_UOM\" id=\"INFUSION_UOM\"\tvalue=";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 =">\n\t\t\t<input type=\"hidden\" name=\"DURN_UNIT\" id=\"DURN_UNIT\"\t\tvalue=";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="> <!-- changed from H to ";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =" for SRR20056-SCF-7374-->\n\t\t\t<input type=\"hidden\" name=\"STOCK_VALUE\" id=\"STOCK_VALUE\"\t\tvalue=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"\t>\n\t     \t<input type=\"hidden\" name=\"PRACT_ID\" id=\"PRACT_ID\"\t\tvalue=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t<input type=\"hidden\" name=\"LOCN_CODE\" id=\"LOCN_CODE\"\t\tvalue=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t\t<input type=\"hidden\" name=\"EQVL_UOM_CODE\" id=\"EQVL_UOM_CODE\"\tvalue=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"STOCK_UOM_CODE\" id=\"STOCK_UOM_CODE\"\tvalue=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"mode1\" id=\"mode1\"\t        value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"repeat_value\" id=\"repeat_value\"\tvalue=\"\"\t>\n\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\"\t    value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"infusion_over_insert_value\" id=\"infusion_over_insert_value\"\tvalue=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"calcualted_durn_value\" id=\"calcualted_durn_value\"\tvalue=\"\"\t>\n\t\t\t<input type=\"hidden\" name=\"interval_value\" id=\"interval_value\"\tvalue=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"freq_nature\" id=\"freq_nature\"   \tvalue=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"repeat_durn_type\" id=\"repeat_durn_type\"value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"scheduled_yn\" id=\"scheduled_yn\"\tvalue=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t<input type=\"hidden\" name=\"back_date\" id=\"back_date\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"future_date\" id=\"future_date\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"iv_calc_infuse_by\" id=\"iv_calc_infuse_by\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"BMS_QTY\" id=\"BMS_QTY\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" >\n\t\t\t<input type=\"hidden\" name=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" >\n\t\t\t<input type=\"hidden\" name=\"drug_db_interface_yn\" id=\"drug_db_interface_yn\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" >\n\t\t\t<input type=\"hidden\" name=\"order_type_code\" id=\"order_type_code\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" >\n\t\t\t<input type=\"hidden\" name=\"volume_unit_code\" id=\"volume_unit_code\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"/>\t\n\t\t\t<input type=\"hidden\" name=\"volume_unit_desp\" id=\"volume_unit_desp\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\"/>\t\n\t\t\t<input type=\"hidden\" name=\"LOCN_TYPE\" id=\"LOCN_TYPE\"\t\tvalue=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\t\n\t\t\t<input type=\"hidden\" id = \"typeOfHWcheckInter\" value=\"\" name=\"typeOfHWcheckInter\" id=\"typeOfHWcheckInter\" />\n\n\t\t\t<div class=\"CSTransactionMessage\" id=\"transactionMsg1\" style=\"background-color:#bd362f;bottom: 45px; left: 10px; display: none;z-index:900002;\">\n\t\t\t\t<img style=\"padding-left:15px;vertical-align:middle;\" src=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="/eIPAD/images/PopError.png\" onclick=\"closeToast()\"/>\n\t\t\t\t<span class=\"rxToastmsg\" id=\"contentRxToastMsg1\">No records found</span>\n\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"transactionMessageContent1\"></div>\n\t\t\t</div>\t\t\t\n\t\t\t<div id=\"confirmMsg\" class=\"absoluteCenter\" style=\"z-index: 10005;\">\n\t\t\t<div class=\"Error_Window\">\n\t\t\t\t<div class=\"Error_msg_box\">\n\t\t\t\t<div class=\"Error_msg\">\n\t\t\t\t\t<div class=\"Error_msg_Frame\">\n\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t<div class=\"Error_icon\"><img src=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="/eIPAD/images/OrderPopConfirm.png\" width=\"30\" height=\"30\"> </div>\n\t\t\t\t\t\t\t<div class=\"Error_cont\" id=\"ClinicalNotesConfirmDialogMsg\">Are you sure you wish to cancel the current operation?</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t<div class=\"Error_msg_btn\">\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"okClick\" onclick=\"okClickDialog()\">OK </div>\n\t\t\t\t<div class=\"Error_btn_div\"> </div>\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"cancelClick\" onclick=\"cancelClickDialog()\" data-value=\"true\">Cancel </div>\n\t\t\t</div>\n\t\t\t<div class=\"top_shadow\"> </div>\n\t\t\t</div>\n\t\t</div>\n    </form>\n";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n<script>\n\nsetTimeout(\"callForDefalutLoad(\'D\',\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\',\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\');\",1000);\n\n</script>\n\n";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\n\t<script>\n\n\t\n\tvar def= $(\"#selected_b\").val();\t\n\tif (def == \"D\") {\n        showDosageBY();\n        $(\"#strenght_quality\").show();\n        hideAllBnsWeight();\n\n    } else {\n\t\tcheckForHtWt();\n        hideDosageBY();\n        $(\"#strenght_quality\").hide();\n        calculateDosage_By_BSA_or_Weight(\"\");\n        showAllBnsWeight();\n    }\t\t\n\t</script>\n</div>\n\n";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

	PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
	String drugCodes        ="" ;
	String location_type			= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code			= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String take_home_medication		= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	String priority					= request.getParameter("priority")==null?"":request.getParameter("priority");
	String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn"); 
	String facility_id					= (String)session.getValue("facility_id");
	String param_bean_id				= "@DrugInterfaceControlBean";
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );				
	String ex_bean_id   = "@ExternalProductLinkBean";
	String ex_bean_name = "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);  
	String dflt_disp_locn	= "";	
	String patient_id=patientContext.getPatientId();
    String encounter_id= patientContext.getEncounterId();
	String patient_class= patientContext.getPatientClass();
	ArrayList drugList = new ArrayList() 	;
	String bean_id_pig				= "IVPiggyBackBean"+patient_id+encounter_id;
	String bean_name_pig			= "ePH.IVPiggyBackBean";
	IVPiggyBackBean bean_pig		= (IVPiggyBackBean)getBeanObject( bean_id_pig,bean_name_pig, request ) ;
	String bean_id_IVD			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
	String bean_name_IVD	= "ePH.IVPrescriptionBean";
	IVPrescriptionBean iv_bean 	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
	ArrayList ord_disp_location  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
	if(ord_disp_location != null & ord_disp_location.size()>0){
		dflt_disp_locn	= (String)ord_disp_location.get(2);
	}
	String disaExst="";
	String params	= request.getQueryString();
	String adr_count	         = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
	String order_id				 = request.getParameter("order_id");
	String mode                  = request.getParameter("mode");
	String answer				= request.getParameter("answer")==null?"":request.getParameter("answer");
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
	String iv_prep_default		= request.getParameter("iv_prep_default")==null?"":request.getParameter("iv_prep_default");
	String order_set_code		= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
	String prev_order			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String MAR_app_yn = "";
	String buildMAR_checked = "";
	String buildMAR_enable  = ""; 
	String buildMAR_rule	= "";  
	MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	String buildMAR_yn = MAR_app_yn;
    String checked				="";
	String disabled1			= "";
	String readonly			    = "";
	String catalog_desc			= "";
	String drug_codes			= "";
	String qty_value			= "";
	String qtys			= "";
	String qty_unit			    = "";
	String flag1				= "";
	String strDrugCode			= "";
	ArrayList orderSetCodes		=new ArrayList();
	String chk_addmixture       = ""; 
	String time_flag            = ""; 
	String disable_addmixture	= "";
	String alert_practitioner_yn= "";
	String mon_graph	        = "";
	String display              = "display:none";
	String allergy_flag         = "hidden";
	String doselimit_flag       = "hidden";
	String currentrx_flag       = "hidden";
	String over_ride_flag       = "hidden";
	String currentrx_flag_img						= "hidden";
	String allergy_flag_img						= "hidden";
	String doselimit_flag_img						= "hidden";
	String allergy_override_reason="";
	String dosage_limit_override_reason="";
	String duplicate_drug_override_reason="";
	String f_i_flag="N";
	String display_tdm = "visibility:hidden";
	HashMap drugReasons  =  null;
	String uom_code				= "";
	String uom_desc				= "";
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
	String duplicate_drug_override_reason_flag	=  "N";
	String interaction_override_reason_flag		=  "Y";
	String contraind_override_reason_flag		=  "N";
	String drug_adr_style						= "hidden";	
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;		
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();
	String pract_id		= (String)ORbean.getPractitionerId();	
	drugList		= iv_bean.getDrugDetails(); 	
	String strength_value		="0";
	String strength_uom_desc	="";
	String strength_uom			="";
	String dosage_type			="";
	HashMap drugDetails	    = null;
	HashMap drugDetailsAmend	    = null;
	if(drugList.size() > 0){
		if(drugList !=null && drugList.size() > 0)
		drugDetails			= (HashMap)drugList.get(0);	
		strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
		strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
		strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
		dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");		
	}
	String disabled	= "";
	String drug_desc="";
	String daily_dose="";
	String min_daily_dose="";
	String min_unit_dose="";
	String unit_dose="";
	String dosage_std="";
	String recomm_dosage_by="";
	String calc_by_ind="";
	String dosage_unit="";
	String iv_ingredient_yn="";
	String iv_fluid_yn="";
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
	String startdate			="";
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
	String disp_location_desp	="";
	String disp_location_code	="";
	String strength_per_value_pres_uom = "";
	String strength_per_pres_uom	   = "";
	String serialNum			= "";	
	String dosage_uom_code		= "";
	String calc_dose_based_on	= "D";
	String calc_dose_by		    = "";
	String selD="selected";
	String selB="";
	String sel="D";
	String calc_dose_value	    = "";
	String displaydose			= "";
	String displayBSA			= "style='display:none'";
	String kg_selected			= "Selected";
	String m2_selected			= "";
	String select_calc_dose_Dosage="checked";
	String select_calc_dose_WT_BSA="";
	String disable_calc_dose	  ="";
	ArrayList orderSetValues	  = new ArrayList();
	String dflt_code			  = "";
	String DrugIndicationRemarks		=   "";
	int dose_decimal			  = 2;
	String vehicle_code="";
	String vehicle_desp="";
	String volumeCode="ml";
	String drunDuration="";
	String 	disp_str = "";
	String volume="";	
	disabled	= "";
	int srlNo		= 0;
	drugList			= iv_bean.getDrugDetails();
	orderSetValues	    = iv_bean.getOrderSetValues();
	generic_id			= (String)drugDetails.get("GENERIC_ID");
	drug_desc			= (String)drugDetails.get("DRUG_DESC");
	String recomm_yn			= (String)drugDetails.get("RECOMM_YN")==null?"":(String)drugDetails.get("RECOMM_YN");
	String trade_name= (String)drugDetails.get("TRADE_NAME");
	String trade_code= (String)drugDetails.get("TRADE_CODE");
	String SHORT_DESC=(String)drugDetails.get("SHORT_DESC");
	String dosage_by 		    = (String)drugDetails.get("DOSAGE_TYPE");
	drug_codes			= (String)drugDetails.get("DRUG_CODE");
	generic_name		= (String)drugDetails.get("GENERIC_NAME");
	daily_dose			= (String)drugDetails.get("DAILY_DOSE");
	min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_DOSE");
	min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_DOSE");
	unit_dose			= (String)drugDetails.get("UNIT_DOSE")==null?"":(String)drugDetails.get("UNIT_DOSE");
	dosage_std			= (String)drugDetails.get("DOSAGE_STD")==null?"":(String)drugDetails.get("DOSAGE_STD");
	recomm_dosage_by	= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
	calc_by_ind			= (String)drugDetails.get("CALC_BY_IND")==null?"":(String)drugDetails.get("CALC_BY_IND");
	mono_graph			= (String)drugDetails.get("MONO_GRAPH")==null?"":(String)drugDetails.get("MONO_GRAPH");
	limit_ind			= (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
	allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
	current_rx			= (String)drugDetails.get("CURRENT_RX");
	srl_no				= (String)drugDetails.get("SRL_NO");
	strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
	strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
	strength_uom		= (String)drugDetails.get("STRENGTH_UOM");
	form_code			= (String)drugDetails.get("FORM_CODE");
	pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
	pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
	freq_code			= (String)drugDetails.get("FREQ_CODE");
	durn_value			= (String)drugDetails.get("DURN_VALUE");
	or_durn_desc		= (String)drugDetails.get("OR_DURN_DESC");
	auth_yn				= (String)drugDetails.get("AUTH_YN");
	approval_yn			= (String)drugDetails.get("APPROVAL_YN");
	cosign_yn			= (String)drugDetails.get("COSIGN_YN");
	consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
	order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
	fract_dose_appl_yn	= (String)drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_APPL_YN");
	route_code			= (String)drugDetails.get("ROUTE_CODE");
	end_date			= (String)drugDetails.get("END_DATE");			
	startdate			= (String)drugDetails.get("START_DATE");
	volume=iv_bean.getVOLUME();	
		dup_drug_desc			= (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails.get("CURRENTRX_REMARKS");
		allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS")==null?"":(String)drugDetails.get("ALLERGY_REMARKS");
		exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS")==null?"":(String)drugDetails.get("DOSE_REMARKS");
	drunDuration= (String)drugDetails.get("DURN_VALUE");	
	DrugIndicationRemarks		=  (String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");	
	external_dosage_override_reason			= (String) drugDetails.get("DOSE_REMARKS")==null?"":(String) drugDetails.get("DOSE_REMARKS");		
	external_duplicate_override_reason		= (String) drugDetails.get("CURRENTRX_REMARKS")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS");	
	external_interaction_override_reason	= (String) drugDetails.get("DRUG_INDICATION")==null?"":(String) drugDetails.get("DRUG_INDICATION");	
	external_alergy_override_reason			= (String) drugDetails.get("ALLERGY_REMARKS")==null?"":(String) drugDetails.get("ALLERGY_REMARKS");						
		String CALC_DOSE_BY=(String) drugDetails.get("CALC_DOSE_BY")==null?"":(String) drugDetails.get("CALC_DOSE_BY");		
		  if(CALC_DOSE_BY.equalsIgnoreCase("M2")){			  
	                                    kg_selected			= "";
	                                    m2_selected			= "selected";
		  }		
			calc_dose_based_on=(String) drugDetails.get("CALC_DOSE_BASED_ON")==null?"":(String) drugDetails.get("CALC_DOSE_BASED_ON");			
			if(calc_dose_based_on.equalsIgnoreCase("D")){				
				selD="selected";
				sel="D";
			}else if (calc_dose_based_on.equalsIgnoreCase("B")){				
				selB="selected";
				sel="B";
			}			
	String calculteBY="";
	calculteBY=calculteBY + "<option  value='D'" +selD +">Dosage</option>";	
	calculteBY=calculteBY + "<option  value='B' "+selB +">Body wt/BSA</option>";		
	if(!DrugIndicationRemarks.equals(""))
		 DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); 
	buildMAR_rule=(String)drugDetails.get("BUILD_MAR_RULE");
	buildMAR_yn="N";			
	if(buildMAR_rule.equals("CE")){
		buildMAR_enable="";
		buildMAR_checked="checked";
		buildMAR_yn="Y";						
	}
	else if(buildMAR_rule.equals("UE")){
		buildMAR_enable="";
		buildMAR_checked="";
	}
	else if(buildMAR_rule.equals("CD")){
		buildMAR_enable="disabled";
		buildMAR_checked="checked";
		buildMAR_yn="Y";						
	}
	else if(buildMAR_rule.equals("UD")){
		buildMAR_enable="disabled";
		buildMAR_checked="";
	}
	iv_bean.setBuildMAR_yn(buildMAR_yn);	
strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
strength_uom		= (String)drugDetails.get("STRENGTH_UOM");		
qtys					= (String)drugDetails.get("QTY_VALUE");
	bms_qty						= (String)drugDetails.get("BMS_QTY");
	dflt_qty_uom				= (String)drugDetails.get("DFLT_QTY_UOM");
	tab_qty_value				= (String)drugDetails.get("TAB_QTY_VALUE");
	qty_unit          =(String)drugDetails.get("QTY_DESC_CODE");
	qty_desc_code				= (String)drugDetails.get("QTY_DESC_CODE")==null?(String)drugDetails.get("QTY_UNIT"):(String)drugDetails.get("QTY_DESC_CODE");
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
	disp_location_desp					= (String)drugDetails.get("DISP_LOCN_DESC");
	disp_location_code					= (String)drugDetails.get("DISP_LOCN_CODE");
	
	
     
     
	iv_ingredient_yn = (String)drugDetails.get("IV_INGREDIENT_YN");
	iv_fluid_yn      = (String)drugDetails.get("IV_FLUID_YN");
	perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");			
	dosage_uom_code				= (String)drugDetails.get("PRES_BASE_UOM")==null?qty_desc_code:(String)drugDetails.get("PRES_BASE_UOM");
	String dosageBY="";
	if (strength_value.equals("0")) {
		dosageBY=dosageBY+	"<OPTION VALUE='Q'>Quantity</OPTION>";
	}
	else {
		if(dosage_type.equals("Q")) {
			dosageBY=dosageBY+	"<OPTION VALUE='S'>Strength</OPTION>";
			dosageBY=dosageBY+	"<OPTION VALUE='Q' SELECTED>Quantity</OPTION>";
		}
		else {
			dosageBY=dosageBY+	"<OPTION VALUE='S' SELECTED>Strength</OPTION>";
			dosageBY=dosageBY+	"<OPTION VALUE='Q' >Quantity</OPTION>";
		}
	}
	String calcDoseValueUnit="";
	calcDoseValueUnit=calcDoseValueUnit + "<option  value='"+strength_uom +"'selected>"+strength_uom_desc+"</option>";	
	String calcDoseQualitySelection=""; 
	calcDoseQualitySelection=calcDoseQualitySelection+"<option value='KG' "+ kg_selected +">KG</option>";
	calcDoseQualitySelection=calcDoseQualitySelection+"<option value='M2' "+ m2_selected +" >M2</option>";		
	String str_value = "";
	String type="";
	if (strength_value.equals("0")) {
		disabled = "";
		str_value	= pres_qty_value;
		type="Dose";
	}
	else {
		if(dosage_type.equals("S")) {
			str_value	= strength_value;
			disabled	= "DISABLED";
			type="Strength";
		}
		else {
			str_value	= qtys;
			disabled	= "";
			type="Dose";						
		}
	}
	if(qty_value!=null && !qty_value.equals("")) {
		//str_value	=	qty_value;
	}
	if(orderSetValues.size() > 0){
		for(int i = 0; i < orderSetValues.size(); i=i+8){
			if(orderSetValues.get(i).equals(drug_codes)){
				qty_value	= (String)orderSetValues.get(i+1);
				if(dosage_type.equals("S")){
					str_value = ((Float.parseFloat(qty_value)*Float.parseFloat(strength_value))/Float.parseFloat(strength_per_value_pres_uom))+"";
				}
			}
		}
	}
	String SterngthOrQulityVals=""; 
	if (!strength_value.equals("0")) {
		if(dosage_type.equals("S")) {
			SterngthOrQulityVals=SterngthOrQulityVals+"<option  value='"+strength_uom +"'selected>"+strength_uom_desc+"</option>";
		}
		else {
			//SterngthOrQulityVals=SterngthOrQulityVals+"<option  value=''>selected</option>";
			Hashtable QtyDescDetails	= (Hashtable)iv_bean.listQtyDetails(drug_codes);
			Enumeration keys_des		= QtyDescDetails.keys();
			String def_uom				= "";
			while(keys_des.hasMoreElements()) {
				uom_code	= (String)keys_des.nextElement();
				uom_desc	= (String)QtyDescDetails.get(uom_code);
				if(!uom_code.equals("dflt_code")) {
					if(uom_code.equals(dosage_uom_code))
						def_uom = "SELECTED";
					else
						def_uom = "";
					SterngthOrQulityVals=SterngthOrQulityVals+"<option  value='"+uom_code +"'"+def_uom+">"+uom_desc+"</option>";
				}
			}
		}
	}
	else {
		//SterngthOrQulityVals=SterngthOrQulityVals+"<option  value=''>selected</option>";
		Hashtable QtyDescDetails	= (Hashtable)iv_bean.listQtyDetails(drug_codes);
		Enumeration keys_des		= QtyDescDetails.keys();
		String def_uom				= "";
		if (amend_yn == null || amend_yn.equals("N"))
			dflt_code = QtyDescDetails.get("dflt_code") == null ? "" : QtyDescDetails.get("dflt_code").toString();
		else
			dflt_code = qty_desc_code;
		while(keys_des.hasMoreElements()) {
			uom_code	= (String)keys_des.nextElement();
			uom_desc	= (String)QtyDescDetails.get(uom_code);
			if(!uom_code.equals("dflt_code")) {
				if(uom_code.equals(qty_unit))
					def_uom = "SELECTED";
				else
					def_uom = "";
				SterngthOrQulityVals=SterngthOrQulityVals+"<option  value='"+uom_code +"'"+def_uom+">"+uom_desc+"</option>";
			}
		}
	}
	calc_dose_by			= (String)drugDetails.get("CALC_DOSE_BY")==null?"KG":(String)drugDetails.get("CALC_DOSE_BY");
	calc_dose_value			= (String)drugDetails.get("CALC_DOSE_VALUE")==null?"":(String)drugDetails.get("CALC_DOSE_VALUE");
	String end_date_time		="";
	String infuse_over			="";
	String infusion_rate		="";
	String selected1            ="";
	String selected2            ="";
	String durn_value_new			="";
	String freq_value			="";
	String optSelected			="";
	String order_catalog_code	="";
	String order_catalog_code1  ="";
	String stock_uom_code		="", stock_uom_desc=""; 
	String stock_value			="";
	String optSelected1			="";
	int    durn_value1			=0; 
	int    J					=0; 
	String order_line_num_new       ="";
	String temp					="";
	String infusion_over_time	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
	String durn_type1			="";
	String readonly_new				="";
	String disabled_new				="";
	String  repeat_value		="";
	String drug_code			="";
	String srl_no_new               ="";
	String infusion_uom			="H"; 
	String order_id_new				= request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_type_flag_new		= request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String mode_new					= request.getParameter("mode")==null?"":request.getParameter("mode");
	String prev_order_new			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String patient_id_new			= request.getParameter("patient_id");
	String patient_class_new		= request.getParameter("act_patient_class");
	String encounter_id_new			= request.getParameter("encounter_id");
	String facility_id_new			= (String)session.getValue("facility_id");
	String answer_new				= request.getParameter("answer")==null?"":request.getParameter("answer");
	String order_date	= iv_bean.getOrderDate();
	String sys_date				= order_date;
	String infuse_over_hr	= "";
	String infuse_over_mi	= "";
	String infuse_over_units	= "";
	String durn_type		= "";
	String durn_calc		= "";
	String freq_nature		= "F";
	String freq_value_durn	= "";
	String interval_value	= "";
	String repeat_value_durn= "";
	String schedule_yn		= "";
	String repeat_durn_type	= "";
	String freq_durn_type	= "";
	String scheduled_yn		= "N";
	String split_dose_yn	= "";
	String qty_value_new		= "";
	String freq_code_new		= "";
	ArrayList tmp_freq_values = new ArrayList();
	float total_qty			= 0.0f;
	String final_qty		= "";
	boolean split_chk		=	false;
	String tooltiptable		= "";
	String adm_time			= "";
    HashMap record;
	HashMap record1;	
	HashMap chkValuescheduleFrequency	=	null;
	ArrayList frequencyValues	        =	null;
	HashMap fluid_det =(HashMap)iv_bean.getFluidDetails();	
	if(scheduled_yn.equals("Y")){ 
	chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency();	
	if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
		frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(order_catalog_code);
		}
	} 	
	infuse_over=     (String)fluid_det.get("INFUSE_OVER");
	infusion_rate = (String)fluid_det.get("INFUSION_RATE");
	infuse_over_hr	= (String)fluid_det.get("INFUSION_PERIOD_VALUE");
	infuse_over_mi	=  (String)fluid_det.get("INFUSION_PERIOD_VALUE_MIN");
	infuse_over_units =  (String)fluid_det.get("INFUSE_OVER_UNIT");
	volumeCode=(String)fluid_det.get("PRES_BASE_UOM_DESC")==null?"":(String)fluid_det.get("PRES_BASE_UOM_DESC");	
	vehicle_code 			= (String)drugDetails.get("vehicle");	
	if(vehicle_code==null || vehicle_code==""){
		vehicle_code 			= (String)fluid_det.get("DRUG_CODE");		
	}		
	disp_str="["+infuse_over_hr+" Hrs "+infuse_over_mi+" Mins]";	
	
	ArrayList stockDetails = iv_bean.getStockDetails(vehicle_code, "1");


	String volume_unit_value="";


	if (stockDetails.size() != 0){
		
		volume_unit_value=(String)stockDetails.get(1);
		vehicle_desp=iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1));
	}
		
	
	
	infuse_over=	(String)drugDetails.get("SCH_INFUSION_RATE")==null?"":(String)drugDetails.get("SCH_INFUSION_RATE");	
	infuse_over_hr =(String)drugDetails.get("INFUSION_PERIOD_VALUE")==null?"":(String)drugDetails.get("INFUSION_PERIOD_VALUE");	
	infuse_over_mi = (String)drugDetails.get("INFUSION_PERIOD_VALUE_MIN")==null?"":(String)drugDetails.get("INFUSION_PERIOD_VALUE_MIN");	
	infusion_rate = (String)drugDetails.get("INFUSION_RATE")==null?"":(String)drugDetails.get("INFUSION_RATE");	
	infuse_over_units =(String)drugDetails.get("INFUSION_PERIOD_UOM")==null?"":(String)drugDetails.get("INFUSION_PERIOD_UOM");		
	disp_str="["+infuse_over_hr+" Hrs "+infuse_over_mi+" Mins]";	
		if(infuse_over_units.equalsIgnoreCase("H")){
		selected1="selected";		
	}else{
			selected2="selected";		
	}	
	/* Banner Indicator Starts */	
	String display_auth_rule = "display:none";
    String color_auth_rule   = "";	
	String drug_db_interact_check_flag	= "N";
	String drug_db_interface_yn			= "N";
	String drug_db_product_id			= "";
	String drug_db_dosecheck_yn			= "N";
	String drug_db_duptherapy_yn		= "N";
	String drug_db_interact_check_yn	= "N";
	String drug_db_contraind_check_yn	= "N";
	String drug_db_allergy_check_yn		= "N";
	String dup_drug_det					= "";
	String drug_db_duptherapy_flag		= "N";
	String drug_db_contraind_check_flag	= "N";
	String external_database_overrided_yn = "";
	String external_database_overrided_reason = "";	
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
	if(order_type_flag.equals("Existing")||mode.equals("amend")){
	
			disabled1="disabled";
			if(!prev_order.equals("") && prev_order.equals("previous")){
				readonly="";
			}
			else{
				readonly="readonly";
			}
			String act_pat_class = request.getParameter("act_pat_class")== null?"": request.getParameter("act_pat_class");  
			ArrayList exstngIVorder = (ArrayList)iv_bean.getExistingIVRecords(order_id,answer,act_pat_class); 
			record					= new HashMap();
			int siz=exstngIVorder.size();
			String lengt=siz+"";
			if(lengt.equals("1")){
				drugDetailsAmend					= (HashMap)exstngIVorder.get(0);
			}
			else{
				drugDetailsAmend					= (HashMap)exstngIVorder.get(1);
			}
			pres_base_uom = drugDetailsAmend.get("PRES_BASE_UOM")==null?"":(String) drugDetailsAmend.get("PRES_BASE_UOM"); 
			strength_per_value_pres_uom = drugDetailsAmend.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String) drugDetailsAmend.get("STRENGTH_PER_VALUE_PRES_UOM"); 	
			strength_value = drugDetailsAmend.get("STRENGTH_VALUE")==null?"":(String) drugDetailsAmend.get("STRENGTH_VALUE"); 
			drug_desc				= drugDetailsAmend.get("DRUG_DESC")==null?(String)drugDetailsAmend.get("CATALOG_DESC"):(String)drugDetailsAmend.get("DRUG_DESC");
			catalog_desc			= (String)drugDetailsAmend.get("CATALOG_DESC");
			drug_codes				= (String)drugDetailsAmend.get("ORDER_CATALOG_CODE");			
			dosage_type			    = (String)drugDetailsAmend.get("DOSAGE_TYPE");
			dup_drug_desc			= (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails.get("CURRENTRX_REMARKS");
			allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS")==null?"":(String)drugDetails.get("ALLERGY_REMARKS");
			exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS")==null?"":(String)drugDetails.get("DOSE_REMARKS");			
			buildMAR_yn = drugDetailsAmend.get("BUILD_MAR_YN")==null?"":drugDetailsAmend.get("BUILD_MAR_YN").toString();
			if(buildMAR_yn!=null && buildMAR_yn.equals("Y"))
				buildMAR_checked ="Checked";
			else{
				buildMAR_checked ="";
				buildMAR_yn="N";
			}			
			buildMAR_rule=drugDetailsAmend.get("BUILD_MAR_RULE").toString();
			buildMAR_rule=buildMAR_rule==null?"":buildMAR_rule;
			
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
			iv_bean.setBuildMAR_yn(buildMAR_yn);		
			if(drugDetails != null && drugDetails.size() >0){
			ord_auth_reqd_yn			= (String)drugDetails.get("ORD_AUTH_REQD_YN");
			ord_spl_appr_reqd_yn		= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
			ord_cosign_reqd_yn			= (String)drugDetails.get("ORD_COSIGN_REQD_YN");
			ord_authorized_yn			= (String)drugDetails.get("ORD_AUTHORIZED_YN");
				strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
				strength_uom		= (String)drugDetails.get("STRENGTH_UOM");				
				current_rx = (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
				limit_ind  = (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
				allergy_yn = (String)drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN");
			}
			if(drug_db_dosecheck_yn.equals("Y") && ext_prod_id != "") {
				drugDetails.put("LIMIT_IND","Y");
			}
			 drugReasons=new HashMap();
		     iv_ingredient_yn = (String)drugDetails.get("IV_INGREDIENT_YN");
			 iv_fluid_yn      = (String)drugDetails.get("IV_FLUID_YN");
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
		}	
	if(perform_external_database_checks_yn.equals("Y")&& !(ext_prod_id.equals("")) ){
		if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
			HashMap tempDetails= null;
			HashMap drugDBCheckResult= null;
			ArrayList reqChecks = new ArrayList();
			reqChecks.add("N"); 
			reqChecks.add(drug_db_duptherapy_yn);
			reqChecks.add(drug_db_interact_check_yn); 
			reqChecks.add(drug_db_contraind_check_yn);
			reqChecks.add(drug_db_allergy_check_yn); 
			ArrayList exProd				= new ArrayList();
			ArrayList drug_desc_array		= new ArrayList();
			drug_desc_array.add(drug_desc);
			if(!ext_prod_id.equals(""))
				exProd.add(ext_prod_id);
			drugDBCheckResult = beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drug_desc_array, null, "Y", startdate, end_date); 
			if(drugDBCheckResult!=null)
				beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
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
				dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
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

		if(external_database_overrided_reason !=null && external_database_overrided_reason.equals("Y"))
			external_checks	= "hidden";
		else
			external_checks = "visible";
		drugDetails.put("EXTERNAL_DATABASE_OVERRIDED_REASON",external_database_overrided_reason);

		if(drug_db_dosecheck_yn.equals("N") && drug_db_duptherapy_yn.equals("N") && drug_db_interact_check_yn.equals("N") && drug_db_contraind_check_yn.equals("N") && drug_db_allergy_check_yn.equals("N"))
			external_checks	= "hidden";
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
	/* Banner Indicator Ends */	
	record1					= bean_pig.ChkAdMixture();
	chk_addmixture			= (String)record1.get("IV_ADMIXTURE_APPL_YN");
	if(chk_addmixture.equals("N"))
	   disable_addmixture="disabled";		    
	else
	{
	   disable_addmixture="";
	}	
	String drug_db_interface_yn1			= "N";
	String drug_db_product_id1			= "";
	String drug_db_dosecheck_yn1			= "N";
	String drug_db_duptherapy_yn1		= "N";
	String drug_db_interact_check_yn1	= "N";
	String drug_db_contraind_check_yn1	= "N";
	String drug_db_allergy_check_yn1		= "N"; 	
	String current_rx1 = (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
	String limit_ind1  = (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
	String allergy_yn1 = (String)drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN"); 
	durn_type = (String)drugDetails.get("DURN_TYPE")==null?"":(String)drugDetails.get("DURN_TYPE"); 
    if(durn_value.equals(""))
		durn_value = "1";
	if(durn_type==null || durn_type.equals("")){
		durn_type="D";	
		repeat_durn_type="D";
	}
					
	String drun_values="";
	drun_values=drun_values+"<option  value='selcted'>selcted</option>";	
	if(durn_type.equals("Y")){
		
		drun_values=drun_values+"<option selected  value='Y'>year</option>";
	}else{
		drun_values=drun_values+"<option   value='Y'>year</option>";
	}
	if(durn_type.equals("L")){
		drun_values=drun_values+"<option selected  value='L'>Months</option>";
	}else{
		drun_values=drun_values+"<option   value='L'>Months</option>";
	}
	if(durn_type.equals("W")){
		drun_values=drun_values+"<option selected  value='W'>Weeks</option>";
	}else{
		drun_values=drun_values+"<option   value='W'>Weeks</option>";
	}
	if(durn_type.equals("D")){
		drun_values=drun_values+"<option selected  value='D'>Days</option>";
	}else{
		drun_values=drun_values+"<option   value='D'>Days</option>";
	}	
	if(durn_type.equals("H")){
		drun_values=drun_values+"<option selected  value='H'>Hours</option>";
	}else{
		drun_values=drun_values+"<option   value='H'>Hours</option>";
	}
	if(durn_type.equals("M")){
		drun_values=drun_values+"<option selected  value='M'>Minutes</option>";
	}else{
		drun_values=drun_values+"<option   value='M'>Minutes</option>";
	}			

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);

											if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
												if(((drug_db_interact_check_flag.equals("Y") && drug_db_interact_check_yn.equals("Y"))|| (drug_db_duptherapy_flag.equals("Y") && drug_db_duptherapy_yn.equals("Y") )|| (drug_db_contraind_check_flag.equals("Y")&& drug_db_contraind_check_yn.equals("Y") )|| (drug_db_dosage_check_flag.equals("Y") && drug_db_dosecheck_yn.equals("Y")) || (drug_db_allergy_check_flag.equals("Y") && drug_db_allergy_check_yn.equals("Y"))) && !ext_prod_id.equals("")){

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);

												}
											}											
											display_auth_rule = "display:none";
											if(limit_ind.equals("N")) {
												display_auth_rule = "display:inline-block";
											}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);

											display_auth_rule = "display:none";
											if(current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
												display_auth_rule = "display:inline-block";
											}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);

											if(allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);

											}
											display_auth_rule = "display:none";
											color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
											if(ord_auth_reqd_yn.equals("Y")){
												display_auth_rule = "display:inline-block";
													if(ord_authorized_yn.equals("Y"))
														color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
												}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block19Bytes, _wl_block19);

											display_auth_rule = "display:none";
											color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
											if(ord_cosign_reqd_yn.equals("Y")){
												display_auth_rule = "display:inline-block";
												if(ord_cosigned_yn.equals("Y"))
													color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
											}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block19Bytes, _wl_block19);

											display_auth_rule = "display:none";
											color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
											if(ord_spl_appr_reqd_yn.equals("Y")){
												display_auth_rule = "display:inline-block";
												if(ord_approved_yn.equals("Y"))
													color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
											}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disp_location_desp ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(calculteBY));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dosageBY));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(type));
            _bw.write(_wl_block29Bytes, _wl_block29);

											   String read="";
											   if(type.equalsIgnoreCase("Strength")){
												   read="disabled";												   
											   }
											   
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(read ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(SterngthOrQulityVals));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(external_interaction_override_reason));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(calc_dose_value));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(calcDoseValueUnit));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(calcDoseQualitySelection));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
 											display_auth_rule = "display:none";
											if(limit_ind.equals("N")) {
												display_auth_rule = "display:table";
											} 

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(external_dosage_override_reason));
            _bw.write(_wl_block42Bytes, _wl_block42);

											display_auth_rule = "display:none";
											if(current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
												display_auth_rule = "display:table";
											}

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(external_duplicate_override_reason));
            _bw.write(_wl_block45Bytes, _wl_block45);
	if(allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {  
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(external_alergy_override_reason));
            _bw.write(_wl_block47Bytes, _wl_block47);
} 
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disable_addmixture));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(volume ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(volumeCode ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(infuse_over));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(volumeCode ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(infuse_over_hr));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(infuse_over_mi));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(disp_str ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(drunDuration ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drun_values));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( form_code ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( drug_codes ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( trade_code ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( trade_name ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( startdate ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf( end_date ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( sys_date ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( pres_qty_value ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf( pres_base_uom ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( uom_code ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( dosage_unit ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf( strength_uom_desc ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( strength_uom ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( strength_value ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( qty_desc_code ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bean_id_IVD));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(bean_name_IVD));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bean_id_IVD));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(bean_name_IVD));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(f_i_flag));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(mon_graph));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(recomm_dosage_by));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(calc_by_ind));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(order_set_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(dosage_by));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(MAR_app_yn));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(current_rx));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(allergy_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(exceed_dose_desc));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(dup_drug_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(iv_fluid_yn));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(iv_fluid_yn));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block121Bytes, _wl_block121);

				if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(time_flag));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(alert_practitioner_yn));
            _bw.write(_wl_block124Bytes, _wl_block124);

				}
				if(order_type_flag.equals("Existing")||mode.equals("amend")){

            _bw.write(_wl_block125Bytes, _wl_block125);

				}
				else {

            _bw.write(_wl_block126Bytes, _wl_block126);

				}

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(fract_dose_round_up_yn));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_dosage_override_reason,"UTF-8")));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_duplicate_override_reason,"UTF-8")));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_interaction_override_reason,"UTF-8")));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_contra_override_reason,"UTF-8")));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_alergy_override_reason,"UTF-8")));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(drug_db_allergy_check_flag));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(type));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(qtys));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(infusion_uom));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(infusion_uom));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(drug_codes));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(infuse_over));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(interval_value));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(repeat_durn_type ));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(scheduled_yn));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(bms_qty));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(volume_unit_value));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(vehicle_desp));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block171Bytes, _wl_block171);
	
//System.out.println("iv_ingredient_yn:"+iv_ingredient_yn+"iv_fluid_yn::"+iv_fluid_yn);

if( iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("N")){ 
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(order_set_code));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(drug_codes));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(bean_id_IVD));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(bean_name_IVD));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(vehicle_code));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block174Bytes, _wl_block174);
 }
            _bw.write(_wl_block175Bytes, _wl_block175);
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag1.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
}
