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
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eCommon.Common.*;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ehis.persist.PersistenceHelper;
import ePH.PrescriptionBean;
import ePH.PrescriptionBean_1;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pharmrxdetailsview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/PharmRxDetailsView.jsp", 1709118021724L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="/eIPAD/js/PharmRxDetails.js\"></script> \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n   ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<div data-role = \"none\"  class = \"blurPopup\" onclick=\"\" data-popid=\"\" style=\"z-index:10000\"></div>\n   <div class=\"ChartSummaryBlockVar\" id=\"rxDetailsSummaryBlock\" data-role = \"none\">\n      <form id=\"rxDetailsViewForm\" name = \"rxDetailsViewForm\" method = \"post\" action = \"\" class=\"ChartSummaryFormElem\">\n         <div class=\"ChartSummaryMainTable\" data-role = \"none\">\n            <div data-role = \"none\" class =\"ChartSummaryPageHeader\">\n               <div class=\"ChartSummaryHeaderCell\" data-role = \"none\">\n                  <div class=\"ChartSummaryHeaderCont\" data-role = \"none\">\n                     <div class=\"ChartSummaryHeaderTable ChartSummaryHeaderTableTheme\" data-role = \"none\">\n                        <div class=\"ChartSummaryHeaderRow\" data-role = \"none\">\n                           <div class=\"ChartSummaryHeaderTextCol\" data-role = \"none\">\n                              <div class=\"ChartSummaryHeaderText ChartSummaryHeaderTextTheme\" data-role = \"none\">Rx</div>\n                           </div>\n                           <div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n                              <div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"completeRxDetailsConfirm()\"><img src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/CS_Ok16x16.png\"></div>\n                           </div>\n                           <div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n                              <div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"closeRxDetailsView()\"><img src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/images/CS_Close16x16.png\"></div>\n                           </div>\n                        </div>\n                     </div>\n                  </div>\n               </div>\n            </div>\n            <div data-role = \"none\" class = \"ChartSummaryPageContent ChartSummaryPageContentTheme\" id=\"\">\n               <div data-role = \"none\" class = \"ChartSummaryPageContentCell\">\n                  <div data-role = \"none\" class = \"ChartSummaryMainWrapper pharmDataMainWrapper\" id=\"\" >\n                     <div class=\"ChartSummaryMainScroller pharmDataContentScroller\"  data-role = \"none\">\n                        <div class=\"table pharmDataItemHeight\"  data-role = \"none\">\n                           <div  class=\"row pharmOrderItemBannerRow\"  data-role = \"none\">\n                              <div class=\"cell pharmOrderItemHeader\"  data-role = \"none\">\n                                 <div class=\"table pharmDataItemHeight\"  data-role = \"none\">\n                                    <div  class=\"row pharmItemDescNameCell\"  data-role = \"none\">\n                                       <div class=\"cell pharmRxOrderItemName segoeuiBold\"  data-role = \"none\">\n                                          <span class=\"pharmRxOrderItemName10padding \">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n                                          </span>\n                                       </div>\n                                       <div class=\"cell pharmRxOrderItemIcons\"  data-role = \"none\">\n                                       ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="                                        \n                                          <span class=\"pharmRxOrderItemIconsVRalign\">\n                                          <img src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/externalDatabase25X25.png\" class=\"imgBannerIndicator\">\n                                          </span>\n                                       ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n                                          <span id=\"span_beyondDoseLimit\" name=\"span_beyondDoseLimit\" class=\"pharmRxOrderItemIconsVRalign\" style=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =";\'>\n                                          <img src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/images/beyondDoseLimit25X25.png\" class=\"imgBannerIndicator\">\n                                          </span>\n                                       ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n                                          <span class=\"pharmRxOrderItemIconsVRalign\">\n                                          <img src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/drugInteraction25X25.png\" class=\"imgBannerIndicator\">\n                                          </span>\n                                       ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n                                          <span id=\"span_duplicateDrug\" name=\"span_duplicateDrug\" class=\"pharmRxOrderItemIconsVRalign\"  style=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/eIPAD/images/duplicateDrug25X25.png\" class=\"imgBannerIndicator\">\n                                          </span>\n                                       ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n                                          <span id=\"span_allergy\" class=\"pharmRxOrderItemIconsVRalign\">\n                                          <img src=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/eIPAD/images/pharmAllergy25X25.png\" class=\"imgBannerIndicator\">\n                                          </span>\n                                       ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n                                          <span class=\"pharmRxOrderItemIconsVRalign\" style=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/eIPAD/images/authorizeRxDet25X25.png\" class=\"imgBannerIndicator\">\n                                          <img src=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" class=\"BannerIndicators\"/>\n                                          </span>\n                                       ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/eIPAD/images/cosignRxDet25X25.png\" class=\"imgBannerIndicator\"/>\n                                          <img src=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n                                          <span class=\"pharmRxOrderItemIconsVRalign\" style=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =";padding-right:10px;\">\n                                          <img src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/Specialapproval.png\" class=\"imgBannerIndicator\">\n                                          <img src=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" class=\"BannerIndicators\"/>\n                                          </span>                                         \n                                       </div>\n                                    </div>\n                                    <div  class=\"row pharmItemDescNameCell\"  data-role = \"none\">\n                                       <div class=\"cell pharmRxOrderStrength\"  data-role = \"none\">\n                                          <div class=\"pharmRxOrderItemDesc\">\n                                             <label class=\"pharmRxOrderItemLabel\">Strength</label>\n                                             ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n                                             <span class=\"pharmRxOrderItemInfo segoeuiBold\">&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</span>\n                                          </div>\n                                          <div class=\"pharmRxOrderItemDesc\">\n                                             <label class=\"pharmRxOrderItemLabel\">Form</label>\n                                             <span class=\"pharmRxOrderItemInfo segoeuiBold\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</span>\n                                          </div>\n                                          <div class=\"pharmRxOrderItemDesc\">\n                                             <label class=\"pharmRxOrderItemLabel\">Dispense location</label>\n                                             <span class=\"pharmRxOrderItemInfo segoeuiBold\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</span>\n                                          </div>\n                                       </div>\n                                       <div class=\"cell pharmRxOrderItemRate\"  data-role = \"none\">\n                                          <span class=\"pharmRxOrderItemRateDesc\"><span class=\"segoeuiBold\" id=\"bl_total_charge_amt_detvw\">--</span> / <span class=\"segoeuiBold\" id=\"bl_patient_payable_amt_detvw\">--</span></span>\n                                       </div>\n                                       <div class=\"cell pharmRxOrderItemRate\"  data-role = \"none\">\n                                          <span class=\"pharmRxOrderItemRateLabel segoeuiBold\">Total / Patient</span>\n                                       </div>\n                                    </div>\n                                    <div  class=\"row pharmCartBottomContainer\"  data-role = \"none\">\n                                       <div class=\"cell pharmCartBottomImg\" data-role = \"none\">\t\t\t\t\t\t\t\t\t\t \n                                       </div>\n                                    </div>\n                                 </div>\n                              </div>\n                           </div>\n                           <div id=\"pharmRxScroller\" class=\"row selectPharmOrder pharmOrderRxItemContainer\" data-role = \"none\">\n                              <div style=\"position:relative;width:100%;height:auto;\">\n                                 <div class=\"rxSectionHeader segoeuiBold\" id=\"\">Drug detail</div>\n                                 <div class=\"sectionWrapper\">\n\t\t\t\t\t\t\t\t    <div id=\"rowOne\" class=\"padding10px\" style=\"display:flex;\">\n\t\t\t\t\t\t\t\t\t   <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n                                          <div class=\"rxLabel\">\n\t\t\t\t\t\t\t\t\t\t    Priority<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t  <select style=\"width:100%\" id=\"rxPriority\" name=\"rxPriority\" id=\"rxPriority\">\n\t\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="                                            \n\t\t\t\t\t\t\t\t\t\t  </select>\n                                       </div>\n\t\t\t\t\t\t\t\t\t   <div style=\"width:0.8%;\"></div>\n\t\t\t\t\t\t\t\t\t   <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n                                          <div>\n                                             <div class=\"rxLabel\">Route<font class=\"rxMandatorIndi\">*</font></div>\n                                             <div  class=\"dropDown\" >\n                                                <select name=\"route_code\" id=\"route_code\" onChange=\"getActionText(this,\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\');\" style=\"width: 100%\" id=\"routeDpList\"> ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="                                            \n                                                </select>\n                                             </div>\n                                          </div>\n                                          <span class=\"rxDrugRouteLabel\" id=\"rxDrugRouteVal\" >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</span>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div id=\"rowSecond\" class=\"padding10px\" style=\"display:flex;\">\n\t\t\t\t\t\t\t\t\t   <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n                                          <div id=\"tradeNameDpListDisable\" class=\"rxLabel\">Trade name</div>\n                                          <div  class=\"dropDown\" >\n                                             <select style=\"width:100%;\" id=\"tradeNameDpList\" name=\"tradeNameDpList\" id=\"tradeNameDpList\"> ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="                                            \n                                             </select>\n                                          </div>\n                                       </div>\n\t\t\t\t\t\t\t\t\t   <div style=\"width:0.8%;\"></div>\n\t\t\t\t\t\t\t\t\t   <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n\t\t\t\t\t\t\t\t\t      <div class=\"rxLabel\">Build MAR</div>\n                                          <div  class=\"rxCheckbox\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t<input id=\"buildMarChk\" style=\"height: 20px;width: 20px;\" type=\"checkbox\" name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" onclick=\'assignValue1(this);\'/>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\t<!-- &nbsp;<input type=\'hidden\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\'> -->\n\t\t\t\t\t\t\t\t\t\t<fmt:message key=\"ePH.BuildMAR.label\" bundle=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"/>&nbsp;\n\t\t\t\t\t\t\t\t\t\t<input id=\"buildMarChk\" name=\'buildMAR_yn\' id=\'buildMAR_yn\' style=\"height: 20px;width: 20px;\" type=\"checkbox\" value=\'N\' disabled/>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t</div>\n                                 </div>\n                                 <div class=\"pharmacySectionSperator\"></div>\n                                 <div class=\"rxSectionHeader segoeuiBold\">Dosage detail</div>\n                                 <div class=\"sectionWrapper\">\n\t\t\t\t\t\t\t\t    <div id=\"dosageDetailRowOne\" class=\"padding10px\" style=\"display:flex;\">\n\t\t\t\t\t\t\t\t\t   <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n                                          <div class=\"rxLabel\">\n\t\t\t\t\t\t\t\t\t\t    Dosage by<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t  <input style=\"width:100%;padding-left: 0px;\" class=\"dropDown rxTextArea\" type=\"text\" id=\"rxDosageBy\" maxlength=\"8\" value=\"0\"/>\n                                       </div>\n\t\t\t\t\t\t\t\t\t   <div style=\"width:0.8%;\"></div>\n\t\t\t\t\t\t\t\t\t   <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n\t\t\t\t\t\t\t\t\t        <div style=\"width:100%;height:33px\">\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:100%;height:48px\">\n                                            <div style=\"width:49.5%;float:left;\">\n                                               <input style=\"width:100%;height:43px;\"  class=\"dropDown rxTextArea k-textbox\" type=\"text\" id=\"rxDosageByVal\" name=\"rxDosageByVal\" id=\"rxDosageByVal\" maxlength=\"13\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" onchange=\"lookForChange(this);showBillingDetails();\" onKeyPress=\"allowValidNumber(this,event,8,";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =")\" />\n                                            </div>\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:1%;height:43px;float:left;\">\n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                            <div style=\"width:49.5%;float:left;\">\n                                               <div  class=\"dropDown\" >\n                                                  <select style=\"width:100%;\" id=\"dosageUOMDpList\" name=\"dosageUOMDpList\" id=\"dosageUOMDpList\" onchange=\"showBillingDetails();\">\n\t\t\t\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="                                            \n                                                  </select>\n                                               </div>\n                                            </div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                       </div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div id=\"dosageDetailRowTwo\" class=\"padding10px\" style=\"display:flex;\">\n\t\t\t\t\t\t\t\t\t    <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n\t\t\t\t\t\t\t\t\t        <div class=\"rxLabel\">Frequency<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t    </div>\n                                            <div  class=\"dropDown\" >\n                                               <select style=\"width:100%\" id=\"frequencyDpList\" name=\"frequencyDpList\" id=\"frequencyDpList\" onchange=\"freqChange(this,\'Y\',\'N\',\'ChangeFreq\',\'pBilling\')\">\n   \t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="                                            \n                                               </select>\n                                            </div>\n\t\t\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"width:0.8%;\"></div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"rxContainer alignTwo\" id=\"prnRemarks\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"\" class=\"rxLabel\" >PRN remarks<font  id=\"prnMandatory\" class=\"rxMandatorIndi\">*</font></div>                                       \n\t\t\t\t\t\t\t\t\t\t\t\t<textarea type=\"text\" maxlength=\"60\" id=\"prnTextarea\" style=\"width:99%\" class=\"rxDetailsTextArea k-textbox\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</textarea>                                       \n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n                                 </div>\n                                 <div class=\"pharmacySectionSperator\"></div>\n                                 <div class=\"rxSectionHeader segoeuiBold\">Duration detail</div>\n                                 <div class=\"sectionWrapper\">\n\t\t\t\t\t\t\t\t    <div id=\"durationRowOne\" class=\"padding10px\" style=\"display:flex;\">\n\t\t\t\t\t\t\t\t\t   <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n\t\t\t\t\t\t\t\t\t        <div class=\"rxLabel\">\n\t\t\t\t\t\t\t\t\t\t\t   Duration<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:100%;\">\n                                            <div style=\"width:49.5%;float:left;\">\n                                               <input style=\"width:100%;height:43px;\"  class=\"dropDown rxTextArea k-textbox\" type=\"text\" id=\"rxDurationDetails\" name=\"rxDurationDetails\" id=\"rxDurationDetails\" maxlength=\"3\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" onchange=\"showBillingDetails();\" />\n                                            </div>\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:1%;height:43px;float:left;\">\n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                            <div style=\"width:49.5%;float:left;\">\n                                               <div  class=\"dropDown\" >\n                                                  <select style=\"width: 100%\" id=\"durationDpList\" name=\"durationDpList\" id=\"durationDpList\" \n\t\t\t\t\t\t\t\t\t\t\t\t  value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"> ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t\t\t\t  </select>\n                                               </div>\n\t\t\t\t\t\t\t\t\t\t\t   <input type=\"hidden\" name=\"tmp_durn_value\" id=\"tmp_durn_value\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\t\t\t\t\t\t\t       <input type=\"hidden\" name=\"tmp_durn_desc\" id=\"tmp_durn_desc\"  value=\"D\">\n                                            </div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n                                       </div>\n\t\t\t\t\t\t\t\t\t   <div style=\"width:0.8%;\"></div>\n\t\t\t\t\t\t\t\t\t   <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n\t\t\t\t\t\t\t\t\t         <div class=\"rxLabel\">Drug remarks\n\t\t\t\t\t\t\t\t\t\t\t </div>\n                                             <div class=\"rxCheckbox\">\n                                                <textarea type=\"text\" maxlength=\"40\" id=\"drugRemTextarea\" style=\"width:100%\" class=\"rxDetailsTextArea k-textbox\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</textarea>  \n                                             </div>\t \n\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t    <div id=\"durationRowTwo\" class=\"padding10px\" style=\"display:flex;\">\n\t\t\t\t\t\t\t\t\t   <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n                                          <div class=\"rxLabel\">\n\t\t\t\t\t\t\t\t\t\t    Start date and time<font class=\"rxMandatorIndi\">*</font>\n\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t  <input style=\"width:100% ! important;\" class=\"dropDown\" id=\"rxStartDate\" onchange=\"populateEndDate(\'DATECHANGE\')\" onblur=\"populateEndDate(\'DATECHANGE\')\"/>\n                                       </div>\n\t\t\t\t\t\t\t\t\t   <div style=\"width:0.8%;\"></div>\n\t\t\t\t\t\t\t\t\t   <div style=\"display: inline-block;width: 49.5%;height: 80px;\">\n                                          <div>\n                                             <div class=\"rxLabel\">End date and time<font class=\"rxMandatorIndi\">*</font></div>\n                                             <div  class=\"dropDown\" >\n                                                <input style=\"width:100% ! important;\" class=\"dropDown\" id=\"rxEndDate\" name=\"rxEndDate\" id=\"rxEndDate\" onblur=\"validateEndDate(this,\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\');\"/>\n                                             </div>\n                                          </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n                                 </div>\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div style=\"height: auto;padding: 0px 10px 0px 10px;width: 98%;display: inline-block;\">\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"rxContainer alignThree\"  id=\"algOverrideRsn\" style=\"float:left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"rxLabel\" >Allergy override reason<font class=\"rxMandatorIndi\">*</font></div>\n\t\t\t\t\t\t\t\t\t\t<textarea style=\"width:99%\" type=\"text\" maxlength=\"255\" id=\"txtAllergyOverReason\" class=\"dropDown rxDetailsTextArea k-textbox\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t  \t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"rxContainer alignTwo\" id=\"drugOverrideRsn\" style=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"txtDupDrugOverReasonLabel\" class=\"rxLabel\" >Duplicate drug override reason<font class=\"rxMandatorIndi\">*</font></div>                                       \n\t\t\t\t\t\t\t\t\t\t\t\t<textarea type=\"text\" maxlength=\"255\" id=\"txtDupDrugOverReason\" style=\"width:99%\" class=\"rxDetailsTextArea k-textbox\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</textarea>                                       \n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"rxContainer alignTwo\" id=\"exceedOverrideRsn\" style=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"txtExceedOverReasonLabel\" class=\"rxLabel\" >Beyond dosage limit override reason<font class=\"rxMandatorIndi\">*</font></div>                                       \n\t\t\t\t\t\t\t\t\t\t\t\t<textarea type=\"text\" maxlength=\"255\" id=\"txtExceedOverReason\" style=\"width:99%\" class=\"rxDetailsTextArea k-textbox\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"rxContainer alignTwo\" id=\"drugInterOverrideRsn\" style=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"txtDrugInterOverReasonLabel\" class=\"rxLabel\" >Drug interaction override reason<font class=\"rxMandatorIndi\">*</font></div>                                       \n\t\t\t\t\t\t\t\t\t\t\t\t<textarea type=\"text\" maxlength=\"255\" id=\"txtDrugInterOverReason\" style=\"width:99%\" class=\"rxDetailsTextArea k-textbox\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</textarea>                                       \n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"rxContainer alignThree\" id=\"drugIndiOverrideRsn\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"txtDrugIndicationsLabel\" class=\"rxLabel\">Drug indications</div>\n\t\t\t\t\t\t\t\t\t\t\t<textarea style=\"width:99%\" type=\"text\" maxlength=\"255\" id=\"txtDrugIndications\" class=\"dropDown rxDetailsTextArea k-textbox\">";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</textarea> \n\t\t\t\t\t\t\t\t\t\t</div>                                        \t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t  \t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"rxContainer alignFive\" id=\"patCounslingReq\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"rxLabel\">Patient counselling required</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"rxCheckbox\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input style=\"height: 20px;width: 20px;\" type=\"checkbox\" value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'  \n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="  id=\"patCounsellingReq\" />\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t <input type = \"hidden\" name =\"patCounsellingReq\" id =\"patCounsellingReq\"/>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t \t\t\t\t \n                              </div>\n                           </div>\n\t\t\t\t<!-- Pharmacy legend starts -->\n\t\t\t\t\t<div id=\"rxDetailsLegend\"></div>\n\t\t\t\t<!-- Pharmacy legend ends -->\t\n                        </div>\n                     </div>\n                  </div>\n               </div>\n            </div>         \n         </div>\n         <input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"/>\n         <input type = \"hidden\" name =\"hdnpriorityValue\" id =\"hdnpriorityValue\" value = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"/>\t\t \t\n         <input type = \"hidden\" name =\"hdnDosageType\" id =\"hdnDosageType\" value = \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"/>\t\n         <input type = \"hidden\" name =\"hdnOriDosageType\" id =\"hdnOriDosageType\" value = \"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"/>\t\t \n\t\t <input type = \"hidden\" name =\"hdnbuildMarChecked\" id =\"hdnbuildMarChecked\" value = \"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"/>\n\t\t <input type = \"hidden\" name =\"hdnStrengthVal\" id =\"hdnStrengthVal\" value = \"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"/>\n\t\t <input type = \"hidden\" name =\"hdnStrengthUomDesc\" id =\"hdnStrengthUomDesc\" value = \"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"/>\n\t\t <input type = \"hidden\" name =\"hdnbuildMarEnable\" id =\"hdnbuildMarEnable\" value = \"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"/>\n\t\t <input type = \"hidden\" name =\"hdnTradeOptionEnable\" id =\"hdnTradeOptionEnable\" value = \"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"/>\n\t\t <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" name=\"form_code\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" name=\"qty_desc_code\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" name=\"pres_base_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" name=\"strength_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" name=\"strength_value\">\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" name=\"pres_base_uom_desc\">\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" name=\"billable_item_yn\" id=\"billable_item_yn\">\t \n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" name=\"strength_uom_desc\">\t\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" name=\"pres_base_uom_desc\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" name=\"dosage_type\">\t\n\t\t<input type = \"hidden\" name =\"ext_prod_id\" id =\"ext_prod_id\" value = \"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"/>\n\t\t <input type = \"hidden\" name =\"in_formulary_yn\" id =\"in_formulary_yn\" value = \"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"/>\n\t\t <input type = \"hidden\" name =\"patient_id\" id =\"patient_id\" value = \"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"/>\n\t\t <input type = \"hidden\" name =\"bl_install_yn\" id =\"bl_install_yn\" value = \"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"/>\n\t\t <input type = \"hidden\" name =\"bl_disp_charge_dtl_in_rx_yn\" id =\"bl_disp_charge_dtl_in_rx_yn\" value = \"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"/>\n\t\t <input type = \"hidden\" name =\"drug_db_dosecheck_yn\" id =\"drug_db_dosecheck_yn\" value = \"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"/>\n\t\t <input type = \"hidden\" name =\"drug_code\" id =\"drug_code\" value = \"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"/>\n\t\t <input type = \"hidden\" name =\"srl_no\" id =\"srl_no\" value = \"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"/>\n\t\t <input type = \"hidden\" name =\"start_date\" id =\"start_date\" value = \"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"/>\n\t\t<input type = \"hidden\" name =\"generic_id\" id =\"generic_id\" value = \"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"/>\n\t\t<input type = \"hidden\" name =\"freq_code\" id =\"freq_code\" value = \"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"/>\n\t\t<input type = \"hidden\" name =\"freq_nature\" id =\"freq_nature\" value = \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"/>\n\t\t<input type = \"hidden\" name =\"calc_def_dosage_yn\" id =\"calc_def_dosage_yn\" value = \"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"/>\n\t\t<input type = \"hidden\" name =\"repeat_value\" id =\"repeat_value\" value = \"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" onchange=\"showBillingDetails()\"/>\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" > \n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"> \n\t\t<input type=\"hidden\" name=\"presBean_id\" id=\"presBean_id\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t<input type=\"hidden\" name=\"presBean_name\" id=\"presBean_name\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" name=\"init_qty\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" name=\"calling_mode\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" name=\"tab_qty_value\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" name=\"sliding_scale_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" name=\"rowVal\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" name=\"scheduled_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" name=\"repeat_durn_type\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" name=\"split_dose_yn_val\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" name=\"dflt_qty_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" name=\"def_freq_found\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" name=\"allow_duplicate\">\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" name=\"drug_db_interface_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" name=\"drug_db_duptherapy_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" name=\"max_durn_for_refill_pres\">\t\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" name=\"no_refill\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" name=\"order_set_code\">\n\t\t<input type=\"hidden\" value=\"\" name=\"freq_value\" id=\"freq_value\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" name=\"interval_value\" onchange=\"showBillingDetails();\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" name=\"act_patient_class\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" name=\"current_rx\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" name=\"fract_dose_appl_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" name=\"admin_time\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" name=\"admin_qty\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" name=\"dsg_reason\"> \n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" name=\"dup_reason\"> \n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" name=\"con_reason\"> \n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" name=\"int_reason\"> \n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" name=\"alg_reason\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" name=\"qty_reqd_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" name=\"rx_qty_by_pres_base_uom_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" name=\"split_dose_yn\">\n\t\t<input type=\"hidden\" name=\"taper_disable\" id=\"taper_disable\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" name=\"sch_over_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" name=\"refill_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" name=\"refill_yn_from_param\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" name=\"refill_cont_order_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" name=\"refill_start_date\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" name=\"refill_end_date\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_durn_desc\" id=\"in_durn_desc\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_durn_value\" id=\"in_durn_value\">\n\t\t<input type=\"hidden\" name=\"limit_ind\" id=\"limit_ind\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t<input type=\"hidden\" name=\"external_patient_id\" id=\"external_patient_id\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t\t<input type=\"hidden\" name=\"max_durn_for_dm_pres\" id=\"max_durn_for_dm_pres\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t<input type=\"hidden\" name=\"chk_for_dm_max_durn_action\" id=\"chk_for_dm_max_durn_action\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t<input type=\"hidden\" name=\"max_durn_for_ip_pres\" id=\"max_durn_for_ip_pres\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t<input type=\"hidden\" name=\"chk_for_ip_max_durn_action\" id=\"chk_for_ip_max_durn_action\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t<input type=\"hidden\" name=\"max_durn_for_op_pres\" id=\"max_durn_for_op_pres\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t<input type=\"hidden\" name=\"chk_for_op_max_durn_action\" id=\"chk_for_op_max_durn_action\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" name=\"max_durn_value\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" name=\"chk_for_max_durn_action\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" name=\"force_auth_yn\">\n\t\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t\t<input type=\"hidden\" name=\"interaction_exists\" id=\"interaction_exists\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t<input type=\"hidden\" name=\"amend_yn\" id=\"amend_yn\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" name=\"dup_found\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" name=\"ord_authorized_prev_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" name=\"ord_auth_reqd_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" name=\"authroize_yn_val\">\n\t\t<input type=\'hidden\' name=\'DrugRemarksEntered\' id=\'DrugRemarksEntered\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n\t\t<input type=\'hidden\' name=\'bl_incl_excl_override_reason_code\' id=\'bl_incl_excl_override_reason_code\' value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>\n\t\t<input type=\'hidden\' name=\'bl_incl_excl_override_reason_desc\' id=\'bl_incl_excl_override_reason_desc\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\n\t\t<input type=\'hidden\' name=\'bl_def_override_excl_incl_ind\' id=\'bl_def_override_excl_incl_ind\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n\t\t<input type=\'hidden\' name=\'bl_override_excl_incl_ind\' id=\'bl_override_excl_incl_ind\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n\t\t<input type=\'hidden\' name=\'bl_override_allowed_yn\' id=\'bl_override_allowed_yn\' value=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" name=\"preg_remarks\" >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" name=\"ph_version\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" name=\"consider_stock_for_pres_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" name=\"dose_override\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" name=\"strength_per_pres_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" name=\"strength_per_value_pres_uom\">\n\t\t<input type=\"hidden\" value=\"\" name=\"conv_factor\" id=\"conv_factor\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" name=\"allergy_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" name=\"brought_by_pat\" onchange=\"showBillingDetails();\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" name=\"take_home\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" name=\"pat_counseling_reqd\">\n\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" name=\"stock_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" name=\"mono_graph\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" name=\"unit_dose\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" name=\"daily_dose\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" name=\"generic_name\">\n\t\t<INPUT TYPE=\"hidden\" name=\"recomm_dosage_by\" id=\"recomm_dosage_by\" VALUE=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"take_medication_yn_val\" id=\"take_medication_yn_val\" VALUE=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"freq_chng_durn_desc\" id=\"freq_chng_durn_desc\" VALUE=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"durn_value\" id=\"durn_value\" VALUE=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\t\t\n\t\t<input type=\"hidden\" value=\"\" name=\"calcualted_durn_value\" id=\"calcualted_durn_value\">\t\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" name=\"man_rem_on_prn_freq_yn\">\t\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" name=\"source\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" name=\"back_date\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" name=\"future_date\">\n\t\t<input type=\"hidden\" name=\"pregnency_yn\" id=\"pregnency_yn\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\t\t\n\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" name=\"absol_qty\" />\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" name=\"patient_class\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" name=\"facility_id\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" name=\"encounter_id\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" name=\"resp_id\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" name=\"pract_id\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" name=\"location_code\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" name=\"order_type_code\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" name=\"drug_class\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" name=\"sch_over_yn\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" name=\"refill_cont_order_yn\"/>\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" name=\"split_dose\"/>\n\t\t\n\t\t<div class=\"CSTransactionMessage\" id=\"transactionMsg1\" style=\"background-color:#bd362f;bottom: 45px; left: 10px; display: none;z-index:900002;\">\n\t\t\t<img style=\"padding-left:15px;vertical-align:middle;\" src=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="/eIPAD/images/PopError.png\" onclick=\"closeToast()\"/>\n\t\t\t<span class=\"rxToastmsg\" id=\"contentRxToastMsg1\">No records found</span>\n            <div class=\"formValErrorMsgTheme\" id=\"transactionMessageContent1\"></div>\n        </div>\n\t\t\n\t\t<div id=\"confirmMsg\" class=\"absoluteCenter\" style=\"z-index: 10005;\">\n\t\t\t<div class=\"Error_Window\">\n\t\t\t\t<div class=\"Error_msg_box\">\n\t\t\t\t<div class=\"Error_msg\">\n\t\t\t\t\t<div class=\"Error_msg_Frame\">\n\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t<div class=\"Error_icon\"><img src=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="/eIPAD/images/OrderPopConfirm.png\" width=\"30\" height=\"30\"> </div>\n\t\t\t\t\t\t\t<div class=\"Error_cont\" id=\"ClinicalNotesConfirmDialogMsg\">Are you sure you wish to cancel the current operation?</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t<div class=\"Error_msg_btn\">\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"okClick\" onclick=\"okClickDialog()\">OK </div>\n\t\t\t\t<div class=\"Error_btn_div\"> </div>\n\t\t\t\t<div class=\"Error_btn_div_con\" id=\"cancelClick\" onclick=\"cancelClickDialog()\" data-value=\"true\">Cancel </div>\n\t\t\t</div>\n\t\t\t<div class=\"top_shadow\"> </div>\n\t\t\t</div>\n\t\t</div>\n\t\t\t<script>\n";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n\t\t\t\t\tduplicateWarning();\n";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t\t\tshowToastMsg(\"Default frequency is not found in the applicable frequencies list\");\n\t\t\t\t\tfreqChange(document.rxDetailsViewForm.frequencyDpList,\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'); \n";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t\tfreqChange(document.rxDetailsViewForm.frequencyDpList,\'N\', \'N\', \'ChangeFreq\');\n\t\t\t\t\tvar PriorityDPList = $(\"#rxPriority\").data(\"kendoDropDownList\");\n\t\t\t\t\t$(\'#rxPriority\').css(\"opacity\",\"0.3\");\n\t\t\t\t\tPriorityDPList.enable(false);\t\t\t\t\n";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t\t\tfreqChange(document.rxDetailsViewForm.frequencyDpList,\'N\',\'N\',\'ChangeFreq\');\n";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t//validateAllDates(); \n\t\t\t\t\tdurationConversn(document.rxDetailsViewForm.durationDpList);\n";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t</script>\n      </form>\n   </div>\n\n";
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
   
   PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
   
   String ph_version =	(String)PhLicenceRights.getKey();
   String facility_id = patientContext.getFacilityId();
   String patient_id = patientContext.getPatientId();
   String patient_class = patientContext.getPatientClass();
   String encounter_id = patientContext.getEncounterId();
   String resp_id = patientContext.getResponsibilityID();
   String pract_id = patientContext.getClinicianId();
   String location_code = patientContext.getLocationCode();
   String bl_install_yn = (String) session.getValue( "bl_operational" )==null?"N":(String) session.getValue( "bl_operational" ) ;
   String mode		= CommonRepository.getCommonKeyValue( "MODE_INSERT" ); 
   
   //Rx View Code Starts
   
  String bean_id = "@PrescriptionBean_1"+patient_id+encounter_id;	
  String bean_name	= "ePH.PrescriptionBean_1";
  PrescriptionBean_1 bean =(PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request); 
  bean.setLanguageId(locale);
   
   String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
   String presBean_name		= "ePH.PrescriptionBean";	
   PrescriptionBean presBean = (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request);               
   presBean.setLanguageId(locale);	  
   String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
   
  HashMap drug_detail =	null;
  ArrayList	presDetails	= (ArrayList) bean.getpresDetails();
  String drugItemNo = request.getParameter("drugItemNo");
  int drugIndex = Integer.parseInt(drugItemNo);
  drug_detail = (HashMap) presDetails.get(drugIndex);
   String calling_mode ="blank";
   
   int dose_decimal				= 6;
  String drugDesc = (String)drug_detail.get("SHORT_DESC"); 
  String drug_code = (String)drug_detail.get("DRUG_CODE");
  String form_code = (String)drug_detail.get("FORM_CODE"); 
  String route_code = (String)drug_detail.get("ROUTE_CODE");
  String priority= (String)drug_detail.get("PRIORITY");
  String freq_code= (String)drug_detail.get("FREQ_CODE");
  String dosage_type= (String)drug_detail.get("DOSAGE_TYPE");
  String qty_desc_code = (String)drug_detail.get("QTY_DESC_CODE");
  String pres_base_uom = (String)drug_detail.get("PRES_BASE_UOM");
  String order_type_code = (String)drug_detail.get("ORDER_TYPE_CODE");
  String drug_class = (String)drug_detail.get("DRUG_CLASS");
   String route_option=	"";   
   String buildMAR_checked= "";
   String buildMAR_rule = "";
   String buildMAR_yn= "N";
   String sys_date = "";
   String man_rem_on_prn_freq_yn = (String)drug_detail.get("MANDATORY_REM_ON_PRN_FREQ_YN");
   //Build MAR check box
   	ArrayList param_vals	=	bean.getParameterValues();
	    String allow_without_diag="";
		String 	allow_without_wt="";
		String bl_disp_charge_dtl_in_rx_yn1="";
		String disp_charge_dtl_in_drug_lkp_yn="";
		String disp_price_type_in_drug_lkp="";
		String dc_mar_appl_yn="";
		String disch_med_mar_appl_yn ="";
		String em_mar_appl_yn="";
		String ip_mar_appl_yn="";
		String op_mar_appl_yn="";
		String split_based_priority_yn		= "";
		String split_based_drug_class_yn		= "";
		String narcotic_aprvl_form_req_yn		= "";
		String print_narcotic_form_by_default		= "";
		String rx_qty_by_pres_base_uom_yn		= "";
		String atc_allergy_alert_level		= "";
		String print_mar_label_yn			= "";
		String dispPrescripionDuration		= "";
		String diag_for_medn_order_by		= "";
		String default_prev_drug_sel		= "";
		String preview_rx_yn				= "";
		String disp_prev_vital_signs_yn		= "";
		String max_length_prn_reason		= "";
		String max_durn_for_ip_pres			= "";
		String chk_for_ip_max_durn_action	= "";
		String max_durn_for_op_pres			= "";
		String chk_for_op_max_durn_action	= "";
		String max_durn_for_dm_pres			= "";
		String chk_for_dm_max_durn_action	= "";
		String trade_display_yn				= "";
		String drug_interaction_check_yn	= "";
		String allow_priv_to_order_yn		= "";
		
		String buildMAR_enable ="";
		String take_medication_yn_val	= "";
		int medication_rec				= 0;
	
	if(param_vals!=null && param_vals.size()!=0) {
		int iCount=0;
		 allow_without_diag				=	(String)param_vals.get(iCount++);
		 allow_without_wt				=	(String)param_vals.get(iCount++);
		 bl_disp_charge_dtl_in_rx_yn1		=	(String)param_vals.get(iCount++);
		 disp_charge_dtl_in_drug_lkp_yn	=	(String)param_vals.get(iCount++);
		 disp_price_type_in_drug_lkp		=	(String)param_vals.get(iCount++);
		 dc_mar_appl_yn					=	(String)param_vals.get(iCount++);
		 em_mar_appl_yn					=	(String)param_vals.get(iCount++);
		 ip_mar_appl_yn					=	(String)param_vals.get(iCount++);
		 op_mar_appl_yn					=	(String)param_vals.get(iCount++);
		 
		 disch_med_mar_appl_yn			=	(String)param_vals.get(iCount++);
		 split_based_priority_yn		=	(String)param_vals.get(iCount++);//10
		 split_based_drug_class_yn		=	(String)param_vals.get(iCount++);
		 narcotic_aprvl_form_req_yn		=	(String)param_vals.get(iCount++);
		 print_narcotic_form_by_default	=	(String)param_vals.get(iCount++);
		 rx_qty_by_pres_base_uom_yn		=	(String)param_vals.get(iCount++);
		 atc_allergy_alert_level			=   (String)param_vals.get(iCount++);
		 iCount++; 
		print_mar_label_yn			=   (String)param_vals.get(iCount++); 
		iCount++; 
		dispPrescripionDuration	=	(String)param_vals.get(iCount++);
		diag_for_medn_order_by=(String)param_vals.get(iCount++);
		default_prev_drug_sel			=   (String)param_vals.get(iCount++); 
		preview_rx_yn					=	(String)param_vals.get(iCount++);
		disp_prev_vital_signs_yn	=	(String)param_vals.get(iCount++);

		max_length_prn_reason			=   (String)param_vals.get(iCount++); 
		max_durn_for_ip_pres		=	(String)param_vals.get(iCount++); 
		chk_for_ip_max_durn_action	=	(String)param_vals.get(iCount++);
		max_durn_for_op_pres		=	(String)param_vals.get(iCount++);
		chk_for_op_max_durn_action	=	(String)param_vals.get(iCount++); 
		max_durn_for_dm_pres		=	(String)param_vals.get(iCount++);
		chk_for_dm_max_durn_action	=	(String)param_vals.get(iCount++);
		trade_display_yn			=	(String)param_vals.get(iCount++);
		drug_interaction_check_yn	=	(String)param_vals.get(iCount++);
		iCount++;
		allow_priv_to_order_yn	=	(String)param_vals.get(iCount++);
	}
	if(patient_class!=null && patient_class.equals("OP")){		
		take_medication_yn_val	= "N";
	}
	else{
		if(!patient_class.equals("XT")){			
			medication_rec=(int)bean.getHomeMecdicationYn(encounter_id,facility_id);
		}
		if(medication_rec>0){			
			take_medication_yn_val	= "Y";
			patient_class="OP";
		}
		else{			
			take_medication_yn_val	= "N";
		}
	}		         
               String take_home_med = take_medication_yn_val; // To Match Desktop webcode
               String MAR_app_yn="";		
                if(take_home_med.equals("Y"))
                                MAR_app_yn =  disch_med_mar_appl_yn; 
                else if(patient_class.equals("DC"))
                                MAR_app_yn =  dc_mar_appl_yn; 
                else if(patient_class.equals("EM"))
                                MAR_app_yn =  em_mar_appl_yn; 
                else if(patient_class.equals("IP"))
                                MAR_app_yn = ip_mar_appl_yn; 
                else if(patient_class.equals("OP"))
                                MAR_app_yn =  op_mar_appl_yn; 
					if(MAR_app_yn.equals("Y")){					
   buildMAR_rule=(String) drug_detail.get("BUILD_MAR_RULE")==null?"":(String) drug_detail.get("BUILD_MAR_RULE");	
						if(drug_detail.get("BUILDMAR_YN")==null || drug_detail.get("BUILDMAR_YN").toString().equals("")){
							if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("CD")){
								buildMAR_checked="checked";
								buildMAR_yn="Y";
							}
							else if(buildMAR_rule.equals("UE") || buildMAR_rule.equals("UD")){
								buildMAR_checked="";
								buildMAR_yn="N";
							}
						}
						else{
							buildMAR_yn=drug_detail.get("BUILDMAR_YN").toString();

							if(buildMAR_yn.equals("Y")){
								buildMAR_checked ="checked";							
							}
							else
								buildMAR_checked ="";		
						}
						if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("UE")){
							buildMAR_enable="";
						}
						else if(buildMAR_rule.equals("CD") || buildMAR_rule.equals("UD")){
							buildMAR_enable="disabled";
						}
						if( calling_mode.equals("taper")|| calling_mode.equals("tapered"))
							buildMAR_enable ="disabled";
						if(buildMAR_yn.equals("Y"))
							buildMAR_checked ="checked";
					}
		//End			
		
   // Patient Brought Med		
   String brought_by_pat = (String)drug_detail.get("BROUGHT_BY_PAT");   
   if(brought_by_pat==null) 
		brought_by_pat	=	"N";
	//end				
		
   //Patient Counselling Check		
   String chk_pat_couns_req = "";
   String check_pat_con	= (String)drug_detail.get("PAT_COUNSELING_REQD");   						
   if(check_pat_con == null)
	   check_pat_con = "N";
   if(check_pat_con.equals("Y")){
	chk_pat_couns_req="checked";
   }
		//end			 
   String trade_option=	""; 
   String priority_option = "";
   String trade_option_disable=	"";
   String actionText =	"";   
   String trade_code =(String)drug_detail.get("TRADE_CODE");   
   String qty_option= "";
   String qty_value="";    
   String strength_uom = (String)drug_detail.get("STRENGTH_UOM");  
   String strength_uom_desc = (String)drug_detail.get("STRENGTH_UOM_DESC"); 
   String strength_value= (String) drug_detail.get("STRENGTH_VALUE");
   String ori_dosage_type =(String)drug_detail.get("ORI_DOSAGE_TYPE"); 
   String freq_option =	"";	
   boolean def_freq_found =	false; 
   String freq_nature =	"";	    
   String duration_option =	"";
   String dflt_qty_uom =	"";	  
   dflt_qty_uom				= (String) drug_detail.get("DFLT_QTY_UOM");   
   String pres_base_uom_desc	= (String) drug_detail.get("PRES_BASE_UOM_DESC");
   Hashtable DurnDescDetails = new Hashtable();    
   if(route_code==null || route_code.equals ("") )
   route_option= route_option + "<option value='' selected>&nbsp;&nbsp;&nbsp;---"+"Select Value"+"---&nbsp;&nbsp;&nbsp;</option>";
   else
   actionText = presBean.getActionText(form_code,route_code);
   
   //Route Values
   ArrayList routes =	presBean.getRoutes(form_code); 
   for(int l=0; l<routes.size(); l+=3) { 
            if( ((String)routes.get(l)).equals(route_code) ) {  
   route_option=route_option + "<option  value='"+(String)routes.get(l)+"'selected>"+(String)routes.get(l+1)+"</option>";	
   }
   else {	
   route_option= route_option + "<option value='"+(String)routes.get(l)+"'>"+(String)routes.get(l+1)+"</option>";				
   }							
   }
   sys_date=(String) presBean.getSysdate();
   //end
   
   //Trade values
   ArrayList trades = presBean.getTrades(drug_code); 
       if(trades != null){
     for(int l=0; l<trades.size(); l+=2) {
   
   if( ((String)trades.get(l)).equals(trade_code) ) {  
   trade_option=trade_option + "<option  value='"+(String)trades.get(l)+"'selected>"+(String)trades.get(l+1)+"</option>";	
   }
   else {	
   trade_option= trade_option + "<option value='"+(String)trades.get(l)+"'>"+(String)trades.get(l+1)+"</option>";				
   }		   
    } 
    }
	else{
	trade_option="<option value='' selected>&nbsp;&nbsp;&nbsp;---"+"Select Value"+"---&nbsp;&nbsp;&nbsp;</option>";
	}
	if(trades.size() == 0){
		trade_option_disable ="disabled";
	}
	//End
	
	//Priority Options
	priority_option=priority_option + "<option  value='U' selected>Urgent</option>";	
	priority_option=priority_option + "<option  value='R' selected>Routine</option>";	
	//
   
   //Quantity Values
    ArrayList QtyDescDetails	= (ArrayList)presBean.loadQtyDetails(form_code);   
	for(int i=0; i<QtyDescDetails.size(); i+=3)	{
		if(dosage_type.equals("S")){ 			
		qty_option	=  "<option value='"+strength_uom+"' selected>"+strength_uom_desc+"</option>";	
		}
		else if(dosage_type.equals("Q")){
			if(((String)QtyDescDetails.get(i)).equals(qty_desc_code)){
				qty_option	=  qty_option+"<option value='"+QtyDescDetails.get(i)+"'selected>"+QtyDescDetails.get(i+1)+"</option>";
		 	}
			else{
				qty_option	= qty_option+"<option value='"+QtyDescDetails.get(i)+"'>"+QtyDescDetails.get(i+1)+"</option>";
			}
		}else{
			
          qty_option	=  "<option value='"+pres_base_uom+"' selected>"+pres_base_uom_desc+"</option>";
		}		
	}
	//End	    
    
            _bw.write(_wl_block5Bytes, _wl_block5);
 	
	String display_auth_rule = "display:none";
    String color_auth_rule   = "";  
    String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id)==null?"":param_bean.getDrugDBAllergy_check_yn(facility_id);
    String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id)==null?"":param_bean.getDrugDBInterface_yn(facility_id);
    String drug_db_duptherapy_yn	    =	param_bean.getDrugDBDuptherapy_yn(facility_id)==null?"":param_bean.getDrugDBDuptherapy_yn(facility_id);
    String drug_db_dosecheck_yn 		=	param_bean.getDrugDBDosecheck_yn(facility_id);
    String bl_disp_charge_dtl_in_rx_yn	= 	request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");   
	String ext_checks_overrided			= "";
	String drug_db_dosage_check_flag	= "";
	String drug_db_duptherapy_flag		= "";
	String drug_db_contraind_check_flag	= "";
	String drug_db_interact_check_flag	= "";
	String drug_db_allergy_flag			= "";
	String dsg_reason					= "";
	String dup_reason					= "";
	String con_reason					= "";
	String int_reason					= "";
	String alg_reason					= "";
	String ext_prod_id					= null;
	String in_formulary_yn				= "";
	String limit_ind					= null;
	String interaction_exists			= "";
	String allergy_yn					= null;
	String ord_spl_appr_reqd_yn			= "";
	String ord_approved_yn				= "";
	String ord_cosign_reqd_yn			= "";
	String ord_cosigned_yn				= "";
	String current_rx					= "";
	String repeat_value					= "";
	String start_date					= "";
	String generic_id					= "";
	String calc_def_dosage_yn			= "";
	String fract_dose_appl_yn           ="";
	String current_rx_tapered			= "";
	String duplicate_check_at_atc_yn	= "";
	String drug_code_sliding			= "";
	String srl_no_sliding				= "";
	String copied_drug_yn				= "";
	String amend_yn						= "";	
	String drug_desc					= "";
	String drug_name_1					= "";
	String provide_taper				= "";
	String split_dose					= "";
	String tab_qty_value				= "";
	String strength_per_value_pres_uom	= "";
	String sliding_scale_yn				= ""; 
	String split_dose_yn_val			= "N";
	String rowVal						= "";
	String scheduled_yn					= "";
	String repeat_durn_type				= "";
	String absol_qty					= "";
	String prn_dose						= "";
	String allow_duplicate				= "";
	String ord_auth_reqd_yn				= "";
	String ord_authorized_yn			= "";
	String max_durn_for_refill_pres		= "";
	String no_refill					= "";
	String order_set_code				= "";
	String interval_value				= "";
	String act_patient_class			= "";
	String back_date					= "";
	String future_date					= "";
	String pregnency_yn					= "";
	String durn_value					= "";
	String freq_chng_durn_desc			= "";
	String uom_disp						= "";
	String form_desc					= "";
	String disp_locn_desc				= "";
	String admin_time					= "";
	String admin_qty					= "";
	String qty_reqd_yn					= "";
	String split_dose_yn				= "";
	String taper_disable 				= "";
	String drug_tapered	 				= "";
	String sch_over_yn					= "";
	String refill_yn		            = "";
	String refill_cont_order_yn			= "";
	String refill_yn_from_param	        = "";
	String refill_start_date			= "";
	String refill_end_date				= "";
	String max_durn_value				= "";
	String chk_for_max_durn_action		= "";
	String force_auth_yn			    = "";
	String allergy_remarks				= "";
	String exceed_dose_remarks			= "";
	String prn_remarks     				= "";
	String duplicate_drug_remarks		= "";
	String drug_interaction_remarks		= "";
	String DrugIndicationRemarks		= "";
	String pt_coun_reqd_yn				= "";
	boolean dup_found					= false;
	String orig_current_rx				= "";
	String ord_authorized_prev_yn		= "";
	String DrugRemarksEntered			= "";
	String bl_incl_excl_override_reason_code = "";
	String bl_incl_excl_override_reason_desc = "";
	String bl_def_override_excl_incl_ind     = "";
	String bl_override_excl_incl_ind         = "";
	String bl_override_allowed_yn            = "";
	String preg_remarks					= ""; 
	String consider_stock_for_pres_yn	= "";
	String dose_override				= "";
	String strength_per_pres_uom		= "";
	String conv_factor					= "";
	int take_home						= 0;
	String disp_locn_code				= "";
	String stock_uom					= "";
	String mono_graph					= "";
	String unit_dose					= "";
	String daily_dose					= "";
	String generic_name					= "";
	String statFreqCode					= "";
	boolean statFeqFound 				= false;
	String recomm_dosage_by     		= "";
	String billable_item_yn = "";	
	String drug_remarks = "";
	pregnency_yn	=presBean.getPregnencyYN(patient_id);	
	if(presDetails!=null && presDetails.size()>0){
		String curr_code = (String)(((HashMap) presDetails.get(presDetails.size()-1)).get("DRUG_CODE"));
		ArrayList ordergrp	=(ArrayList) bean.ordsortList();
		ArrayList grp		=(ArrayList) bean.sortList();
		String atc_level_1	=	"";
		String atc_level_2	=	"";
		String atc_level_3	=	"";
		String atc_level_4		=	"";  // added for the incedent no : 27465 
		String atc_level_5		=	"";  // added for the incedent no : 27465 
		String temp_generic_id = "";
		String temp_drug_code="";
		String ATC_dup_drug_code="";     // added for the incedent no : 27465 
		ArrayList atc_dup_drug_code= null;
		ArrayList atc_values =  new ArrayList();
		HashMap drugdetail	 =	null;
		for(int i=0;i<presDetails.size();i++){
			current_rx_tapered = "";
			drugdetail=(HashMap) presDetails.get(i);
			duplicate_check_at_atc_yn       = (String) drugdetail.get("DUPLICATE_CHECK_AT_ATC_YN");   //added for skr-scf-0143 IN 29184
			if(!drug_code_sliding.equals("") && drug_code_sliding.equals((String)drugdetail.get("DRUG_CODE")) && srl_no_sliding.equals((String)drugdetail.get("SRL_NO"))){
				drugdetail.put("BL_DEF_OVERRIDE_EXCL_INCL_IND","");
				drugdetail.put("BL_OVERRIDE_EXCL_INCL_IND","");
				drugdetail.put("BL_TOTAL_CHARGE_AMT","");   //added on 15dec-09
				drugdetail.put("BL_PATIENT_PAYABLE_AMT",""); //added on 15dec-09
				drugdetail.put("BL_DECIMAL_FORMAT_STRING",bean.getBLDecimalFormatString()); // priya --added for IN19010 --24/02/2010
			}
			ext_prod_id			= (String)drugdetail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugdetail.get("EXTERNAL_PRODUCT_ID");
			drug_db_duptherapy_flag		=  (String)drugdetail.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drugdetail.get("DRUG_DB_DUPTHERAPY_FLAG");
			copied_drug_yn		=  (String)drugdetail.get("COPIED_DRUG_YN")==null?"":(String)drugdetail.get("COPIED_DRUG_YN");
			current_rx_tapered = drugdetail.get("CURRENT_RX")==null?"":(String)drugdetail.get("CURRENT_RX");// moved out from the below if condition for MO-GN-5490 [IN:054620] - [IN:055921] -start
			amend_yn			= drugdetail.get("AMEND_YN")==null?"":(String)drugdetail.get("AMEND_YN");
			if( current_rx_tapered.equals("Y") && !drugdetail.containsKey("ORIG_CURRENT_RX")) {
				drugdetail.put("ORIG_CURRENT_RX","Y");							
			}
			else if( !current_rx_tapered.equals("Y") && !amend_yn.equals("Y") && !drugdetail.containsKey("ORIG_CURRENT_RX")){ 
				drugdetail.put("ORIG_CURRENT_RX","N");		
			} 
			if(duplicate_check_at_atc_yn!=null && duplicate_check_at_atc_yn.equals("Y") ){ //if condition added for skr-scf-0143 IN 29184
				atc_level_1	=	(String)drugdetail.get("ATC_CLASS_LEV1_CODE");
				atc_level_2	=	(String)drugdetail.get("ATC_CLASS_LEV2_CODE");
				atc_level_3	=	(String)drugdetail.get("ATC_CLASS_LEV3_CODE");
				atc_level_4	    =	(String)drugdetail.get("ATC_CLASS_LEV4_CODE");
				atc_level_5	    =	(String)drugdetail.get("ATC_CLASS_LEV5_CODE");
				drug_desc	=	(String)drugdetail.get("DRUG_DESC");
				drug_name_1=drug_desc;
				drug_name_1=drug_name_1.replaceAll(" ","%20");
				drug_name_1=java.net.URLEncoder.encode(drug_name_1,"UTF-8");
				drug_name_1=drug_name_1.replaceAll("%2520","%20");
				temp_generic_id	=	(String)drugdetail.get("GENERIC_ID");
				temp_drug_code = (String)drugdetail.get("DRUG_CODE");
				provide_taper	=	"";
				if(drugdetail.get("TAPPERED_OVER")!=null)
					provide_taper	= (String)drugdetail.get("TAPPERED_OVER");			
				if( (!provide_taper.equals("Y")) && (drugdetail.get("ALERT_YN")==null && (drugdetail.get("CURRENTRX_REMARKS")==null || ((String)drugdetail.get("CURRENTRX_REMARKS")).equals("")))) {
					atc_dup_drug_code = new ArrayList();
					atc_dup_drug_code = (ArrayList)drugdetail.get("ATC_DUP_DRUG_CODE");
					if(atc_dup_drug_code == null)
						atc_dup_drug_code = new ArrayList();
					if(!atc_values.contains(temp_drug_code)){ // ie. only while tapering, same drug will be allowed, and if its tapering need not chk for duplicate
						if(atc_values.contains(temp_generic_id)){
							drugdetail.put("CURRENT_RX","Y");
							atc_dup_drug_code.add(temp_drug_code);
							drugdetail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
							drugdetail.put("ALERT_YN","Generic :");
						}
						else if(atc_values.contains(atc_level_4)){    // added else if condition for the incedent no : 27465
							drugdetail.put("CURRENT_RX","Y");
							drugdetail.put("ATC_LEVEL_DUPLICATION","Y");
							drugdetail.put("ALERT_YN","Level 4:");
							atc_dup_drug_code.add(temp_drug_code);
							drugdetail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incedent no : 27465 
						}
						else{
							atc_values.add(drug_desc);
							atc_values.add(temp_drug_code);
							atc_values.add(temp_generic_id);
							if(!(atc_level_1==null || atc_level_1.equals("")))
								atc_values.add(atc_level_1);
							if(!(atc_level_2==null || atc_level_2.equals("")))
								atc_values.add(atc_level_2);
							if(!(atc_level_3==null || atc_level_3.equals("")))
								atc_values.add(atc_level_3);
							if(!(atc_level_4==null || atc_level_4.equals(""))){ // added condition for the incedent no : 27465 
								atc_values.add(atc_level_4);
							}
							if(!(atc_level_5==null || atc_level_5.equals(""))){ // added for the incedent no : 27465 
								atc_values.add(atc_level_5);
							}
						}
					}
					else{
						drugdetail.put("CURRENT_RX","N");
					}
				}
			}
		}
	}		
	drug_db_dosage_check_flag	= (String)drug_detail.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_DOSAGE_CHECK_FLAG");
	drug_db_duptherapy_flag		= (String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG");
	drug_db_contraind_check_flag= (String)drug_detail.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_CONTRAIND_CHECK_FLAG");
	drug_db_interact_check_flag	= (String)drug_detail.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_INTERACT_CHECK_FLAG");
	drug_db_allergy_flag		= (String)drug_detail.get("DRUG_DB_ALLERGY_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_ALLERGY_FLAG");
	dsg_reason					= (String)drug_detail.get("EXT_DDB_DSG_REASON")==null?"":(String)drug_detail.get("EXT_DDB_DSG_REASON");
	dup_reason					= (String)drug_detail.get("EXT_DDB_DUP_REASON")==null?"":(String)drug_detail.get("EXT_DDB_DUP_REASON");
	con_reason					= (String) drug_detail.get("EXT_DDB_CON_REASON")==null?"":(String)drug_detail.get("EXT_DDB_CON_REASON");
	int_reason					= (String) drug_detail.get("EXT_DDB_INT_REASON")==null?"":(String)drug_detail.get("EXT_DDB_INT_REASON");
	alg_reason					= (String) drug_detail.get("EXT_DDB_ALG_REASON")==null?"":(String)drug_detail.get("EXT_DDB_ALG_REASON");
	ext_prod_id					= (String)drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
	in_formulary_yn				= (String) drug_detail.get("IN_FORMULARY_YN")==null?"":(String) drug_detail.get("IN_FORMULARY_YN");
	limit_ind					= drug_detail.get("LIMIT_IND")==null?"":(String)drug_detail.get("LIMIT_IND");
	interaction_exists			= (String) drug_detail.get("INTERACTION_EXISTS")==null?"N": (String) drug_detail.get("INTERACTION_EXISTS");
	allergy_yn					= drug_detail.get("ALLERGY_YN")==null?"":(String)drug_detail.get("ALLERGY_YN");
	billable_item_yn			= drug_detail.get("BILLABLE_ITEM_YN")==null?"N":(String)drug_detail.get("BILLABLE_ITEM_YN");
	//From Details View
	ord_spl_appr_reqd_yn		= (String) drug_detail.get("ORD_SPL_APPR_REQD_YN");
	ord_approved_yn				= (String) drug_detail.get("ORD_APPROVED_YN");
	ord_cosign_reqd_yn			= (String) drug_detail.get("ORD_COSIGN_REQD_YN");
	ord_cosigned_yn				= (String) drug_detail.get("ORD_COSIGNED_YN");
	ord_auth_reqd_yn			= (String) drug_detail.get("ORD_AUTH_REQD_YN");
	ord_authorized_yn			= (String) drug_detail.get("ORD_AUTHORIZED_YN");
	repeat_value				= (String) drug_detail.get("REPEAT_VALUE")==null?"1":(String) drug_detail.get("REPEAT_VALUE");
	start_date					= (String) drug_detail.get("START_DATE");
	generic_id					= (String) drug_detail.get("GENERIC_ID");
	fract_dose_appl_yn			= (String) drug_detail.get("FRACT_DOSE_APPL_YN")==null?"":(String) drug_detail.get("FRACT_DOSE_APPL_YN");
	calc_def_dosage_yn			= (String) drug_detail.get("CALC_DEF_DOSAGE_YN")==null?"":(String) drug_detail.get("CALC_DEF_DOSAGE_YN");
	split_dose					= (String) drug_detail.get("SPLIT_DOSE_PREVIEW")==null?"":(String) drug_detail.get("SPLIT_DOSE_PREVIEW");
	tab_qty_value				= (String) drug_detail.get("TAB_QTY_VALUE");
	strength_per_value_pres_uom	= (String) drug_detail.get("STRENGTH_PER_VALUE_PRES_UOM");
	sliding_scale_yn			= (String) drug_detail.get("SLIDING_SCALE_YN")==null?"N":(String)drug_detail.get("SLIDING_SCALE_YN");
	sliding_scale_yn			= "N";
	split_dose_yn_val			= (String) drug_detail.get("SPLIT_DOSE_YN_VAL")==null?"":(String) drug_detail.get("SPLIT_DOSE_YN_VAL");
	rowVal						= (String) drug_detail.get("rowVal");
	scheduled_yn				= (String) drug_detail.get("SCHEDULED_YN")==null?"N":(String) drug_detail.get("SCHEDULED_YN");
	repeat_durn_type			= drug_detail.get("REPEAT_DURN_TYPE")==null?"D":(String) drug_detail.get("REPEAT_DURN_TYPE");
	absol_qty					= (String)drug_detail.get("ABSOL_QTY");
	prn_dose					= (String)drug_detail.get("PRN_DOSES_PRES_PRD_FILL");
	allow_duplicate				= (String) drug_detail.get("ALLOW_DUPLICATE_DRUG");
	max_durn_for_refill_pres	= (String) drug_detail.get("MAX_DURN_FOR_REFILL_PRES");
	no_refill					= (String) drug_detail.get("NO_REFILL");
	order_set_code	   			= (String) drug_detail.get("ORDER_SET_CODE")==null?"":(String) drug_detail.get("ORDER_SET_CODE");
	interval_value				= (String)drug_detail.get("INTERVAL_VALUE")==null?"1":(String)drug_detail.get("INTERVAL_VALUE");
	act_patient_class			= (String)drug_detail.get("act_patient_class")==null?"1":(String)drug_detail.get("act_patient_class");
	back_date					= (String) drug_detail.get("BACK_DATE");
	future_date					= (String) drug_detail.get("FUTURE_DATE");
	durn_value					= (String) drug_detail.get("DURN_VALUE");
	freq_chng_durn_desc   =  drug_detail.get("freq_chng_durn_desc")==null?"D":(String) drug_detail.get("freq_chng_durn_desc");
	form_desc					= (String) drug_detail.get("FORM_DESC");
	disp_locn_desc				= (String) drug_detail.get("DISP_LOCN_DESC")==null?"":(String) drug_detail.get("DISP_LOCN_DESC");
	admin_time					= (String) drug_detail.get("ADMIN_TIME");
	admin_qty					= (String) drug_detail.get("ADMIN_QTY");
	qty_reqd_yn					= (String) drug_detail.get("QTY_REQD_YN");
	split_dose_yn				= (String) drug_detail.get("SPLIT_DOSE_YN")==null?"":(String) drug_detail.get("SPLIT_DOSE_YN");
	drug_tapered				= drug_detail.get("DRUG_TAPERED_YN")==null?"":(String)drug_detail.get("DRUG_TAPERED_YN");
	sch_over_yn					= (String)drug_detail.get("SCH_OVER_YN");
	if(drug_detail.containsKey("REFILL_YN")){
		refill_yn = drug_detail.get("REFILL_YN")==null?"N":(String)drug_detail.get("REFILL_YN");
	}
	refill_cont_order_yn		= (String) drug_detail.get("REFILL_CONT_ORDER_YN");
	if(drug_detail.containsKey("REFILL_YN_FROM_PARAM")){
		refill_yn_from_param = drug_detail.get("REFILL_YN_FROM_PARAM")==null?"N":(String)drug_detail.get("REFILL_YN_FROM_PARAM");
	}
	refill_start_date			= (String) drug_detail.get("REFILL_START_DATE");
	refill_end_date				= (String) drug_detail.get("REFILL_END_DATE");
	max_durn_value				= (String) drug_detail.get("MAX_DURN_VALUE");
	chk_for_max_durn_action		= (String) drug_detail.get("CHK_FOR_MAX_DURN_ACTION");
	force_auth_yn				= (String) drug_detail.get("FORCE_AUTH_YN");	
	allergy_remarks				= (String) drug_detail.get("ALLERGY_REMARKS")==null?"":(String)drug_detail.get("ALLERGY_REMARKS");
	exceed_dose_remarks			= (String) drug_detail.get("DOSE_REMARKS")==null?"":(String)drug_detail.get("DOSE_REMARKS");
	
	prn_remarks			= (String) drug_detail.get("PRN_REMARKS")==null?"":(String)drug_detail.get("PRN_REMARKS");
	duplicate_drug_remarks		= (String) drug_detail.get("CURRENTRX_REMARKS")==null?"":(String)drug_detail.get("CURRENTRX_REMARKS");
	drug_interaction_remarks	= (String) drug_detail.get("INTERACTION_REMARKS")==null?"":(String)drug_detail.get("INTERACTION_REMARKS");
	DrugIndicationRemarks 		= (String) drug_detail.get("DRUG_INDICATION")==null?"":(String)drug_detail.get("DRUG_INDICATION");
	pt_coun_reqd_yn				= (String) drug_detail.get("PT_COUN_REQD_YN");
	ord_authorized_prev_yn		= (String) drug_detail.get("ORD_AUTHORIZED_PREV_YN");
	DrugRemarksEntered		 	= (String) drug_detail.get("DrugRemarksEntered")==null?"":(String) drug_detail.get("DrugRemarksEntered");
	bl_incl_excl_override_reason_code = (String) drug_detail.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"": (String) drug_detail.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"); 
	bl_incl_excl_override_reason_desc = (String) drug_detail.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"": (String) drug_detail.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
	bl_def_override_excl_incl_ind    = (String) drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND"); 
	bl_override_excl_incl_ind        = (String) drug_detail.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drug_detail.get("BL_OVERRIDE_EXCL_INCL_IND");  
	bl_override_allowed_yn			  = (String) drug_detail.get("BL_OVERRIDE_ALLOWED_YN")==null?"": (String) drug_detail.get("BL_OVERRIDE_ALLOWED_YN"); 
	preg_remarks = (String) drug_detail.get("PREG_REMARKS")==null?"":(String)drug_detail.get("PREG_REMARKS");
	consider_stock_for_pres_yn	= (String) drug_detail.get("CONSIDER_STOCK_FOR_PRES_YN");
	dose_override				= (String) drug_detail.get("DOSE_OVERRIDE");
	strength_per_pres_uom		= (String) drug_detail.get("STRENGTH_PER_PRES_UOM");
	disp_locn_code				= (String) drug_detail.get("DISP_LOCN_CODE")==null?"":(String) drug_detail.get("DISP_LOCN_CODE");
	stock_uom					= (String) drug_detail.get("STOCK_UOM_DESC");
	mono_graph					= (String) drug_detail.get("MONO_GRAPH");
	unit_dose					= (String) drug_detail.get("UNIT_DOSE");
	daily_dose					= (String) drug_detail.get("DAILY_DOSE");
	generic_name				= (String) drug_detail.get("GENERIC_NAME");
	freq_nature					= (String) drug_detail.get("FREQ_NATURE")==null?"": (String) drug_detail.get("FREQ_NATURE");
	copied_drug_yn				= (String) drug_detail.get("COPIED_DRUG_YN")==null?"N":(String) drug_detail.get("COPIED_DRUG_YN");
	recomm_dosage_by			= (String) drug_detail.get("RECOMM_DOSAGE_BY")==null?"":(String)drug_detail.get("RECOMM_DOSAGE_BY");
	drug_remarks = (String) drug_detail.get("DRUG_REMARKS")==null?"":(String)drug_detail.get("DRUG_REMARKS");
		
	if(recomm_dosage_by.equals("B"))
		recomm_dosage_by = "Q";
	
	if(!preg_remarks.equals(""))
		preg_remarks = java.net.URLEncoder.encode(preg_remarks,"UTF-8");
	
	if(bl_override_excl_incl_ind.equals(""))
		bl_override_excl_incl_ind = bl_def_override_excl_incl_ind;
	
	if( drug_detail.containsKey("ORIG_CURRENT_RX") && ((String)drug_detail.get("ORIG_CURRENT_RX")).equals("Y") ) {
		orig_current_rx	=	(String)drug_detail.get("ORIG_CURRENT_RX");
	}
	
	if(!ext_prod_id.equals("") && drug_db_allergy_check_yn.equals("Y") && drug_db_allergy_flag.equals("Y")){
		allergy_yn = "N";
		drug_detail.put("ALLERGY_YN",allergy_yn);
	}
   
	if((drug_db_dosage_check_flag.equals("Y") && (dsg_reason.equals(""))) ||(drug_db_duptherapy_flag.equals("Y")&&(dup_reason.equals(""))) || (drug_db_contraind_check_flag.equals("Y") && (con_reason.equals(""))) || (drug_db_interact_check_flag.equals("Y") && (int_reason.equals("")))||  (drug_db_allergy_flag.equals("Y") && (alg_reason.equals("")))){
		ext_checks_overrided = "N";
	}
	else
		ext_checks_overrided = "Y";
	
	current_rx					= (String) drug_detail.get("CURRENT_RX")==null?"":(String) drug_detail.get("CURRENT_RX");
	
	if(prn_dose==null || prn_dose.equals("")) {
		prn_dose	=	"1";
	}
	
	if(absol_qty==null || absol_qty.equals(""))
		absol_qty		=	"0";
	
	if(freq_nature.equals("P") && absol_qty.equals("0")) {
		absol_qty		=	prn_dose;	
	}
	
	if(!dosage_type.equals("A")) {
		if(!freq_nature.equals("P"))
			absol_qty			=	"1";
	}
	
	if(durn_value==null || durn_value.equals("") || durn_value.equals("0"))
		durn_value="1";
	
	if( drug_tapered.equals("Y")) //Added for [IN:038913] Bru-HIMS-CRF-093/18 //|| tappered_over.equals("Y")) - commented for SKR-SCF-0955 [IN:047620]
		taper_disable="disabled";	
	
	//Duration Values
        DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
		Enumeration keys_des		= DurnDescDetails.keys();
		String	durn_code			= "";
		while(keys_des.hasMoreElements())	{
			durn_code		= (String)keys_des.nextElement();
			if(freq_chng_durn_desc.equals(durn_code)) {
				duration_option	= duration_option + "<option value='"+durn_code+"' selected='selected'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
			}
			else {
				duration_option	= duration_option + "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
			}
		}
		
		if(((orig_current_rx.equals("Y") && !amend_yn.equals("Y") )||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N") && !calling_mode.equals("tapered") && !calling_mode.equals("taper")) { 
			dup_found	=	true;
		}
		if(dosage_type.equals("Q"))
			conv_factor = (String) bean.getConvFactor(qty_desc_code,pres_base_uom);
		
		if(encounter_id!=null && !(encounter_id.equals(""))){
			take_home=(int)bean.getTakeHomeCount();
	}
   // End 
   
   //Frequency values
   HashMap  freqValues 	=(HashMap)bean.populateFrequencyValues(drug_code,freq_code,calling_mode,patient_class);
       ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
		ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
		ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");  
        if(freqValues.size()>0 && (dup_found) && amend_yn.equals("Y")){
			if(allow_duplicate.equals("N")){
				ArrayList stat_freqs	=	presBean.loadStatFreqs();
				for(int i=0;i<stat_freqs.size();i+=2){
					if(freq_code.equals((String) stat_freqs.get(i))){
						freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
						freq_code	    = ((String) stat_freqs.get(i));
					}
					else{
						freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"' >"+((String) stat_freqs.get(i+1))+"</option>";
					}
					freq_nature	    = "O";
				}
			}
			else {
				for(int i=0;i<freqCode.size();i++){					
					if( dup_found  && !amend_yn.equals("Y")) {
						if( ((String) FreqNature.get(i)).equals("O")) {
							freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
						}
					}
					else {
						if(((String) freqCode.get(i)).equals(freq_code)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
							freq_nature	    = (String) FreqNature.get(i);
							def_freq_found  = true;
						} 
						else {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
						}
					}
				}
			}
		}
		else if(freqValues.size()>0 && !(dup_found)){
			statFreqCode = freq_code;
				if(priority.equals("U") && !amend_yn.equals("Y")){
					ArrayList stat_freqs	=	presBean.loadStatFreqs();
					if(stat_freqs.size()>0){
						for(int i=0;i<stat_freqs.size();i+=2){
							statFreqCode=(String) stat_freqs.get(i);
							for(int j=0;j<freqCode.size();j++){
								freq_code=(String) freqCode.get(j);
								if(statFreqCode.equals(freq_code)){
									statFeqFound = true;
									break;
								}
							}
						}
					}
				}

				for(int i=0;i<freqCode.size();i++){
					if( dup_found ) {
						if( ((String) FreqNature.get(i)).equals("O")) { 
							freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
							statFeqFound = true;
						}
					}
					else {
						if(((String) FreqNature.get(i)).equals("O"))
							statFeqFound = true;
						if(((String) freqCode.get(i)).equals(statFreqCode)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
							def_freq_found  = true;
							freq_nature	    = (String) FreqNature.get(i); 
						} 
						else {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
						}
					}
				}
			if(amend_yn.equals("Y"))
				def_freq_found  = true;
		}
		else if(dup_found ) { 
			for(int i=0;i<freqCode.size();i++){
				if(((String) FreqNature.get(i)).equals("O")){
					freq_code = (String)freqCode.get(i);
					statFeqFound = true;
					break;
				}
			}
			ArrayList stat_freqs	=	presBean.loadStatFreqs();			
			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				freq_nature	    = "O";
			}
		} 

		if(freq_option.equals("")) {
			ArrayList stat_freqs	=	presBean.loadStatFreqs();
			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				statFeqFound = true;
				freq_nature	   =	"O";
				freq_code	   = ((String) stat_freqs.get(i));
			}
		}
   //end

   		qty_value					= (String) drug_detail.get("QTY_VALUE");			
   
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(drugDesc));
            _bw.write(_wl_block9Bytes, _wl_block9);

                                       if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {
                                       
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
 }
                                       display_auth_rule = "display:none";
                                       if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") ){
                                    	   display_auth_rule = "display:inline-block";
                                       }
                                       
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
 
                                       if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  interaction_exists.equals("Y") ) {
                                       
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
 }
                                    	   display_auth_rule = "display:none";
                                    	   if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y")) && current_rx!=null && current_rx.equals("Y")){
                                        	   display_auth_rule = "display:inline-block";
                                           }
                                       
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
  
                                       if((ext_prod_id.equals("") || !drug_db_allergy_check_yn.equals("Y") || !drug_db_allergy_flag.equals("Y")) && allergy_yn!=null && allergy_yn.equals("Y")){
                                       
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
 }
                                       display_auth_rule = "display:none";
               							color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
               							
               							if(ord_auth_reqd_yn.equals("Y")){
               								display_auth_rule = "display:inline-block";
        									if(ord_authorized_yn.equals("Y"))
        										color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
        								}
                                       
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block23Bytes, _wl_block23);

                                   		display_auth_rule = "display:none";
               							color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
               							if(ord_cosign_reqd_yn.equals("Y")){
               								display_auth_rule = "display:inline-block";
               								if(ord_cosigned_yn.equals("Y"))
               									color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
               							}
                                       
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block23Bytes, _wl_block23);

                                       	display_auth_rule = "display:none";
               							color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
               							if(ord_spl_appr_reqd_yn.equals("Y")){
               								display_auth_rule = "display:inline-block";
        									if(ord_approved_yn.equals("Y"))
        										color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
        								}
                                       
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block28Bytes, _wl_block28);

												uom_disp = bean.getUomDisplay((String)session.getValue("facility_id"),strength_uom);
												if(uom_disp == null || uom_disp.equals("null"))
													uom_disp = "";
												if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
													strength_value = Float.parseFloat(strength_value)+"";//"0"+strength_value ;
											
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(uom_disp));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disp_locn_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(priority_option));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(route_option));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(actionText));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(trade_option));
            _bw.write(_wl_block38Bytes, _wl_block38);

										if(MAR_app_yn.equals("Y")){
										
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block43Bytes, _wl_block43);

										}
										else{
										
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block45Bytes, _wl_block45);

										}
										
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(qty_value ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(qty_option));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(freq_option));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf( URLDecoder.decode(prn_remarks, "UTF-8")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(freq_chng_durn_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(duration_option));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( URLDecoder.decode(drug_remarks, "UTF-8") ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block57Bytes, _wl_block57);
  
                                       	if((ext_prod_id.equals("") || !drug_db_allergy_check_yn.equals("Y") || !drug_db_allergy_flag.equals("Y")) && allergy_yn!=null && allergy_yn.equals("Y")){
                                       	
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(allergy_remarks));
            _bw.write(_wl_block59Bytes, _wl_block59);
 } 
										
            _bw.write(_wl_block60Bytes, _wl_block60);

										display_auth_rule = "display:none;";
                             	   		if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y")) && current_rx!=null && current_rx.equals("Y")){
                                 	   		display_auth_rule = "display:inline-block;";
                                    	}
										
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(duplicate_drug_remarks));
            _bw.write(_wl_block63Bytes, _wl_block63);

										display_auth_rule = "display:none;";
                             	   		if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") ){
                                 	   		display_auth_rule = "display:inline-block;";
                                    	}
										
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(exceed_dose_remarks));
            _bw.write(_wl_block63Bytes, _wl_block63);

										display_auth_rule = "display:none;";
                             	   		if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  interaction_exists.equals("Y") ) {
                                 	   		display_auth_rule = "display:inline-block;";
                                    	}
										
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(drug_interaction_remarks));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block69Bytes, _wl_block69);

										if(pt_coun_reqd_yn!=null && pt_coun_reqd_yn.equals("Y")){
								  		
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(check_pat_con));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(chk_pat_couns_req));
            _bw.write(_wl_block72Bytes, _wl_block72);
}else {
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(ori_dosage_type));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(trade_option_disable));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(qty_desc_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(pres_base_uom));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(pres_base_uom_desc));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(billable_item_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(pres_base_uom_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(bl_disp_charge_dtl_in_rx_yn));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(drugIndex+1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(calc_def_dosage_yn));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(repeat_value));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(presBean_name));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(tab_qty_value));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(rowVal));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(scheduled_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(split_dose_yn_val));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(dflt_qty_uom));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(def_freq_found));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(allow_duplicate));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(drug_db_duptherapy_yn));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(max_durn_for_refill_pres));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(no_refill));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(order_set_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(interval_value));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(current_rx));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(fract_dose_appl_yn));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(admin_time));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(admin_qty));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(dsg_reason));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(dup_reason));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(con_reason));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(int_reason));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(alg_reason));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(qty_reqd_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(rx_qty_by_pres_base_uom_yn));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(split_dose_yn));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(sch_over_yn));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(refill_yn));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(refill_yn_from_param));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(refill_cont_order_yn));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(refill_start_date));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(refill_end_date));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(bean.getExternalpatient_id()==null?"":bean.getExternalpatient_id()));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(max_durn_for_dm_pres));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(chk_for_dm_max_durn_action));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(max_durn_for_ip_pres));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(chk_for_ip_max_durn_action));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(max_durn_for_op_pres));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(chk_for_op_max_durn_action));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(max_durn_value));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(chk_for_max_durn_action));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(force_auth_yn));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(interaction_exists));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(amend_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(dup_found));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(ord_authorized_prev_yn));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(ord_auth_reqd_yn));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(ord_authorized_yn));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(bl_incl_excl_override_reason_code));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(bl_incl_excl_override_reason_desc));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(bl_def_override_excl_incl_ind));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(bl_override_excl_incl_ind));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(bl_override_allowed_yn));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(preg_remarks));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(ph_version));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(consider_stock_for_pres_yn));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(dose_override));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(strength_per_pres_uom));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(brought_by_pat));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(take_home));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(check_pat_con));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf( recomm_dosage_by ));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf( take_medication_yn_val ));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf( freq_chng_durn_desc ));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf( durn_value ));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(man_rem_on_prn_freq_yn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(back_date));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(future_date));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(pregnency_yn));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(absol_qty ));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(sch_over_yn));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(refill_cont_order_yn));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(split_dose));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block208Bytes, _wl_block208);
			
			if(!amend_yn.equals("Y") && orig_current_rx.equals("Y") && allow_duplicate.equals("N") ) {	

            _bw.write(_wl_block209Bytes, _wl_block209);

				}
				else if(!amend_yn.equals("Y") && !statFeqFound && priority.equals("U")){
					out.println("showToastMsg('Applicable frequency for Urgent priority not defined for the drug');");
					out.println("$('#rxPriority').data('kendoDropDownList').value('Routine');");
				}
				else if(!def_freq_found &&  !amend_yn.equals("Y")){

            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block211Bytes, _wl_block211);

				}
			
				if((orig_current_rx.equals("Y")||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N")) {	 // && (patient_class.equals("IP") || take_home>0)

            _bw.write(_wl_block212Bytes, _wl_block212);

				}
				else if(copied_drug_yn.equals("N") && !amend_yn.equals("Y")){		

            _bw.write(_wl_block213Bytes, _wl_block213);

				}
				else if(copied_drug_yn.equals("Y") && !amend_yn.equals("Y")){

            _bw.write(_wl_block214Bytes, _wl_block214);

				}

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
