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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pharmivrxwithoutadtview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/pharmIvRXWithoutAdtView.jsp", 1709118021584L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="/eIPAD/js/PharmIvRxWithoutAdt.js\"></script> \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<div data-role = \"none\"  class = \"blurPopup\" onclick=\"\" data-popid=\"\" style=\"z-index:10000\"></div>\n<div class=\"ChartSummaryBlockVar\" id=\"rxDetailsSummaryBlock\" data-role = \"none\">\n   <form id=\"rxDetailsIvRxWaViewForm\" name = \"rxDetailsIvRxWaViewForm\" method = \"post\" action = \"\" class=\"ChartSummaryFormElem\">\n      <div class=\"ChartSummaryMainTable\" data-role = \"none\">\n         <div data-role = \"none\" class =\"ChartSummaryPageHeader\">\n            <div class=\"ChartSummaryHeaderCell\" data-role = \"none\">\n               <div class=\"ChartSummaryHeaderCont\" data-role = \"none\">\n                  <div class=\"ChartSummaryHeaderTable ChartSummaryHeaderTableTheme\" data-role = \"none\">\n                     <div class=\"ChartSummaryHeaderRow\" data-role = \"none\">\n                        <div class=\"ChartSummaryHeaderTextCol\" data-role = \"none\">\n                           <div class=\"ChartSummaryHeaderText ChartSummaryHeaderTextTheme\" data-role = \"none\">IV</div>\n                        </div>\n                        <div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n                           <div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"completeIvRxDetailsConfirm()\"><img src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/CS_Ok16x16.png\"></div>\n                        </div>\n                        <div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n                           <div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"closeIvRxDetailsView()\"><img src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/CS_Close16x16.png\"></div>\n                        </div>\n                     </div>\n                  </div>\n               </div>\n            </div>\n         </div>\n         <div data-role = \"none\" class = \"ChartSummaryPageContent ChartSummaryPageContentTheme\" id=\"\">\n            <div data-role = \"none\" class = \"ChartSummaryPageContentCell\">\n               <div data-role = \"none\" class = \"ChartSummaryMainWrapper pharmDataMainWrapper\" id=\"\" >\n                  <div class=\"ChartSummaryMainScroller pharmDataContentScroller\"  data-role = \"none\">\n                     <div class=\"table pharmDataItemHeight\"  data-role = \"none\">\n                        <div  class=\"row pharmOrderItemBannerRow\"  data-role = \"none\">\n                           <div class=\"cell pharmOrderItemHeader\"  data-role = \"none\">\n                              <div class=\"table pharmDataItemHeight\"  data-role = \"none\">\n                                 <div  class=\"row pharmItemDescNameCell\"  data-role = \"none\">\n                                    <div class=\"cell pharmRxOrderItemName segoeuiBold\"  data-role = \"none\">\n                                       <span class=\"pharmRxOrderItemName10padding\">IV without Additives\n                                       </span>\n                                    </div>\n                                 </div>\n                                 <div  class=\"row pharmItemDescNameCell\"  data-role = \"none\">\n                                    <div class=\"cell pharmRxOrderStrength\"  data-role = \"none\">\n                                       <div class=\"pharmRxOrderItemDesc\">\n                                          <label class=\"pharmRxOrderItemLabel\">Dispense Location</label>\n                                          <span class=\"pharmRxOrderItemInfo segoeuiBold\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span>\n                                       </div>\n                                    </div>\n                                    <div class=\"cell pharmRxOrderItemRate\"  data-role = \"none\">\n                                       <span class=\"pharmRxOrderItemRateDesc\">-- / --</span>\n                                    </div>\n                                    <div class=\"cell pharmRxOrderItemRate\"  data-role = \"none\">\n                                       <span class=\"pharmRxOrderItemRateLabel\">Total / Patient</span>\n                                    </div>\n                                 </div>\n                                 <div  class=\"row pharmCartBottomContainer\"  data-role = \"none\">\n                                    <div class=\"cell pharmCartBottomImg\" data-role = \"none\">\t\t\t\t\t\t\t\t\t\t \n                                    </div>\n                                 </div>\n                              </div>\n                           </div>\n                        </div>\n                        <div  class=\"row pharmIvRxOrderItemBannerRow\"  data-role = \"none\">\n                           <div class=\"cell\"  style=\"padding-left: 5px;\" data-role = \"none\">\n                              <div class=\"table pharmDataItemHeight\"  data-role = \"none\">\n                                 <div  class=\"row pharmItemDescNameCell\"  data-role = \"none\">\n                                    <div class=\"cell pharmRxOrderItemName segoeuiBold\"  data-role = \"none\">\n                                       <span style=\"padding-left: 5px;\">Fluid\n                                       </span>\n                                    </div>\n                                 </div>\n                                 <div  class=\"row pharmIvRxItemDescNameCell\"  data-role = \"none\">\n                                    <div class=\"cell pharmRxOrderStrength\"  data-role = \"none\">\n                                       <div class=\"pharmRxOrderItemDesc\" style=\"padding-left:5px !important\n                                          \">                                           \n                                          <span class=\"pharmRxOrderItemMainHeader\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</span>\n                                       </div>\n                                    </div>\n                                 </div>\n                              </div>\n                           </div>\n                        </div>\n                        <div id=\"pharmIvRxWAScroller\" class=\"row selectPharmOrder pharmOrderIvRxItemContainer\" data-role = \"none\">\n                           <div style=\"position:relative;width:100%;height:auto;\">\n                              <div class=\"pharmIvRxDetailRow\">\n                                 <div  class=\"pharmIvRxDetailIndRow\">\n                                    <div class=\"pharmIvRxLeftDetailRowContent\" >\n                                       <div class=\"pharmIvRxDetailLabel\" >\n                                          <div class=\"pharmIvRxDetailLabelContent segoeuiBold\">\n                                             Start date and time\n                                             <font style=\"color: red\">*</font>\n                                          </div>\n                                       </div>\n                                       <div class=\"pharmIvRxDetailCntlContent\">\n                                          <input style=\"width:99.5% ! important;\" class=\"dropDown\" id=\"ivRxStartDate\" onchange=\"strtEndDateTime();\"onBlur=\"strtEndDateTime();\" />\n                                       </div>\n                                    </div>\n                                 </div>                               \n                                 <div  class=\"pharmIvRxDetailIndRow\">\n                                    <div class=\"pharmIvRxRightDetailRowContent\" >\n                                       <div class=\"pharmIvRxDetailLabel\" >\n                                          <div class=\"pharmIvRxDetailLabelContent segoeuiBold\">\n                                             End date and time\n                                          </div>\n                                       </div>\n                                       <div class=\"pharmIvRxDetailCntlContent withAddEnddateCss\">\n                                          <input style=\"width:99.3% ! important;padding-left: 2px;\" class=\"dropDown\" id=\"ivRxEndDate\" />\n                                       </div>\n                                    </div>\n                                 </div>\n                              </div>\n                              <div class=\"pharmIvRxDetailRow\">\n                                 <div  class=\"pharmIvRxDetailIndRow\">\n                                    <div class=\"pharmIvRxLeftDetailRowContent\" >\n                                       <div class=\"pharmIvRxDetailLabel\" >\n                                          <div class=\"pharmIvRxDetailLabelContent segoeuiBold\">\n                                             Duration for repeat\n                                             <font style=\"color: red\">*</font>\n                                          </div>\n                                       </div>\n                                       <div class=\"pharmIvRxDetailCntlContent\">\n                                          <input style=\"width:100% ! important;height:43px;\" class=\"dropDown k-textbox\" type=\"text\" id=\"ivRxDurationForRepeat\" maxlength=\"3\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\n                                          <div class=\"pharmIvRxDetailInnerContent\">Hours</div>\n                                       </div>\n                                    </div>\n                                 </div>                               \n                                 <div  class=\"pharmIvRxDetail2IndRow\">\n                                    <div class=\"pharmIvRxRightDetailRowContent\" >\n                                       <div class=\"pharmIvRxDetailLabel\" >\n                                          <div class=\"pharmIvRxDetailLabelContent segoeuiBold\">\n                                             Infusion rate\n                                             <font style=\"color: red\">*</font>\n                                          </div>\n                                       </div>\n                                       <div class=\"pharmIvRxDetailCntlContentWa\">\n                                          <input style=\"width:100% ! important;height:43px;\" class=\"dropDown k-textbox\" type=\"text\" id=\"ivRxInfusionRate\" maxlength=\"7\"  onKeyPress=\"return allowValidNumber(this,event,6,2);\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n                                          <div style=\"width: 98%;\" class=\"pharmIvRxDetailInnerContent\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</div>\n\t\t\t\t\t\t\t\t\t\t  <div  class=\"pharmIvRxDetailInnerContent\" style=\"height:auto;margin-right: -5px;\">/ </div>\n                                       </div>\t\t\t\t\t\t\t\t   \n                                    </div>\n                                 </div>\n                                 <div  class=\"pharmIvRxDetail2IndRow\">\n                                    <div class=\"pharmIvRxLeftDetailRowContent\" >\n                                       <div class=\"pharmIvRxDetailLabel\" >\n                                          <div class=\"pharmIvRxDetailLabelContent segoeuiBold\">\t\t\t\t\t\t\t\t \n                                          </div>\n                                       </div>\n                                       <div class=\"pharmIvRxDetailCntlContent\">\n                                          <input style=\"width: calc(100% - 5px)! important;\"  name=\"ivRxInfusionDpList\" id=\"ivRxInfusionDpList\" class=\"dropDown\" type=\"text\" id=\"ivRxInfusionDpList\" />\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n                                       </div>\n                                    </div>\n                                 </div>\n                              </div>\n                              <div class=\"pharmIvRxDetailRow\">\n                                 <div  class=\"pharmIvRxDetailIndRow\">\n                                    <div class=\"pharmIvRxLeftDetailRowContent\" >\n                                       <div class=\"pharmIvRxDetailLabel\" >\n                                          <div class=\"pharmIvRxDetailLabelContent segoeuiBold\">\n                                             Volume\n                                             <font style=\"color: red\">*</font>\n                                          </div>\n                                       </div>\n                                       <div class=\"pharmIvRxDetailCntlContent\">\n                                          <input style=\"width:100% ! important;height:43px;\" class=\"dropDown k-textbox\" type=\"text\" id=\"ivRxVolumeUnit\" maxlength=\"5\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n                                          <div class=\"pharmIvRxDetailInnerContent\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div>\n                                       </div>\n                                    </div>\n                                 </div>                               \n                                 <div  class=\"pharmIvRxDetail2IndRow\">\n                                    <div class=\"pharmIvRxRightDetailRowContent\" >\n                                       <div class=\"pharmIvRxDetailLabel\" >\n                                          <div class=\"pharmIvRxDetailLabelContent segoeuiBold\">\n                                             Infuse over\n                                             <font style=\"color: red\">*</font>\t\t\t\t\t\t\t\t \n                                          </div>\n                                       </div>\n                                       <div class=\"pharmIvRxDetailCntlContentWa\">\n                                          <input style=\"width:100% ! important;height:43px;\"  class=\"dropDown k-textbox\" type=\"text\" id=\"ivRxInfusionOverHrs\" name=\"ivRxInfusionOverHrs\" id=\"ivRxInfusionOverHrs\" maxlength=\"2\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n                                          <div style=\"width: 97%;\" class=\"pharmIvRxDetailInnerContent\">Hrs</div>\n                                       </div>\n                                    </div>\n                                 </div>\n                                 <div  class=\"pharmIvRxDetail2IndRow\">\n                                    <div class=\"pharmIvRxLeftDetailRowContent\" >\n                                       <div class=\"pharmIvRxDetailLabel\" >\n                                          <div class=\"pharmIvRxDetailLabelContent segoeuiBold\">\t\t\t\t\t\t\t\t \n                                          </div>\n                                       </div>\n                                       <div class=\"pharmIvRxDetailCntlContent\">\n                                          <input style=\"width: calc(100% - 5px)! important;height:43px;\" class=\"dropDown k-textbox\" type=\"text\" id=\"ivRxInfusionOverMins\" name=\"ivRxInfusionOverMins\" id=\"ivRxInfusionOverMins\" maxlength=\"2\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n                                          <div style=\"width:calc(100% - 10px);right:6px;\" class=\"pharmIvRxDetailInnerContent\">Mins</div>\n                                       </div>\n                                    </div>\n                                 </div>\n                              </div>\n                              <div style=\"width: 100%;height: 120px;\">\n                                 <div  style=\"float: left;width: 49%;height: 100px;\">\n                                    <div class=\"pharmIvRxLeftDetailRowContent\" >\n                                       <div class=\"pharmIvRxDetailLabel\" >\n                                          <div class=\"pharmIvRxDetailLabelContent segoeuiBold\">\n                                             Drug remarks\t\t\t\t\t\t\t \n                                          </div>\n                                       </div>\n                                       <div style=\"width: 99%;height: 57px;\">\n                                          <textarea type=\"text\" style=\"width:100% ! important;height:50px;\"maxlength=\"255\" id=\"ivRxDrugRemarks\" class=\"dropDown k-textbox\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</textarea>\t\t\t\t\t\t\t\t \n                                       </div>\n                                    </div>\n                                 </div>                             \n                                 <div  style=\"float: left;width: 49%;height: 100px;\">\n                                    <div class=\"pharmIvRxRightDetailRowContent\" >\n                                       <div class=\"pharmIvRxDetailLabel\" >\n                                          <div class=\"pharmIvRxDetailLabelContent segoeuiBold\">\n                                             Build MAR\t\t\t\t\t\t\t \n                                          </div>\n                                       </div>\n                                       <div style=\"width: 99%;height: 57px;\">\n\t\t\t\t\t\t\t\t\t     <input id=\"buildMarChk\" style=\"height: 20px;width: 20px;\" type=\"checkbox\" name=\'buildMarChk\' id=\'buildMarChk\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" />\n\t\t\t\t\t\t\t\t\t\t </div>\n                                    </div>\n                                 </div>\n                              </div>\n                           </div>\n                        </div>\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- Pharmacy legend starts -->\n\t\t\t\t\t\t\t<div id=\"ivRxWithoutAddLegend\"></div>\n\t\t\t\t\t\t\t<!-- Pharmacy legend ends --> \n                     </div>\n                  </div>\n               </div>\n            </div>\n         </div>\n      </div>\n      <input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/>\n      <input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n      <input type=\"hidden\" name=\"start_date\" id=\"start_date\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n      <input type=\"hidden\" name=\"end_date\" id=\"end_date\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n      <input type=\"hidden\" name=\"back_date\" id=\"back_date\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n      <input type=\"hidden\" name=\"future_date\" id=\"future_date\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\t\n      <input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n      <input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n      <input type=\"hidden\" name=\"iv_calc_infuse_by\" id=\"iv_calc_infuse_by\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t  <INPUT TYPE=\"hidden\" name=\"infusion_over_insert_value\" id=\"infusion_over_insert_value\" VALUE=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' >\n\t  <INPUT TYPE=\"hidden\" name=\"FLUID_CODE\" id=\"FLUID_CODE\" VALUE=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t  <INPUT TYPE=\"hidden\" name=\"mfr_yn\" id=\"mfr_yn\" VALUE=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\t  \n\t  <input type=\"hidden\" name=\"stock_value\" id=\"stock_value\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t  <input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t  <input type=\"hidden\" name=\"disp_locn_type\" id=\"disp_locn_type\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t  <input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t  <input type=\"hidden\" name=\"take_home_medication\" id=\"take_home_medication\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t  <input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t  <input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t  <input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t  <input type=\"hidden\" name=\"locn_code\" id=\"locn_code\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t  <input type=\"hidden\" name=\"pract_name\" id=\"pract_name\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t  <input type=\"hidden\" name=\"infuse_over_unit_sch\" id=\"infuse_over_unit_sch\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\t  \t  \n      <div class=\"CSTransactionMessage\" id=\"transactionMsg1\" style=\"background-color:#bd362f;bottom: 45px; left: 10px; display: none;z-index:900002\">\n         <img style=\"padding-left:15px;vertical-align:middle;\" src=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="/eIPAD/images/PopError.png\" onclick=\"closeToast()\"/>\n         <span class=\"rxToastmsg\" id=\"contentRxToastMsg1\">No records found</span>\n         <div class=\"formValErrorMsgTheme\" id=\"transactionMessageContent1\"></div>\n      </div>\n      <div id=\"confirmMsg\" class=\"absoluteCenter\" style=\"z-index: 10005;\">\n         <div class=\"Error_Window\">\n            <div class=\"Error_msg_box\">\n               <div class=\"Error_msg\">\n                  <div class=\"Error_msg_Frame\">\n                     <div>\n                        <div class=\"Error_icon\"><img src=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="/eIPAD/images/OrderPopConfirm.png\" width=\"30\" height=\"30\"> </div>\n                        <div class=\"Error_cont\" id=\"ClinicalNotesConfirmDialogMsg\">Are you sure you wish to cancel the current operation?</div>\n                     </div>\n                  </div>\n               </div>\n            </div>\n            <div class=\"Error_msg_btn\">\n               <div class=\"Error_btn_div_con\" id=\"okClick\" onclick=\"okClickDialog()\">OK </div>\n               <div class=\"Error_btn_div\"> </div>\n               <div class=\"Error_btn_div_con\" id=\"cancelClick\" onclick=\"cancelClickDialog()\" data-value=\"true\">Cancel </div>\n            </div>\n            <div class=\"top_shadow\"> </div>\n         </div>\n      </div>\n   </form>\n</div>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );
	
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
   if(patientContext!=null){
   String patient_id = patientContext.getPatientId();
   String encounter_id = patientContext.getEncounterId();
   String patient_class = patientContext.getPatientClass();
   String facility_id = patientContext.getFacilityId();   
   String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
   String or_bean_name		= "eOR.OrderEntryBean";
   OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name , request) ;
   String locn_type			= (String)ORbean.getLocationType();
   String locn_code			= (String)ORbean.getLocationCode();
   String pract_id			= (String)ORbean.getPractitionerId();
   String pract_name		= (String)ORbean.getPractitionerName();  
   String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patient_id + encounter_id;
   String bean_name_IVWA	= "ePH.IVPrescriptionBean";
   IVPrescriptionBean bean_IVWA	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
   String iv_calc_infuse_by=bean_IVWA.getIVCalcInfuseBy();   
   ArrayList AllFluids = bean_IVWA.getAllFluids();
   String take_home_medication = bean_IVWA.getTakeHomeMedication();
   String drugItemNo = request.getParameter("drugItemNo");
   int value=Integer.valueOf(drugItemNo);
   HashMap fluidDetail = (HashMap)AllFluids.get(value);		
   String drug_desc = (String)fluidDetail.get("DRUG_DESC");
   String order_set_code = (String)fluidDetail.get("ORDER_CATALOG_CODE");
   String qty_desc = (String)fluidDetail.get("QTY_DESC");//ml
   String qty_value = (String)fluidDetail.get("QTY_VALUE"); // 1 ml
   String qty_uom = (String)fluidDetail.get("QTY_UOM");
   String pres_base_uom_desc = (String)fluidDetail.get("PRES_BASE_UOM_DESC");//Bottle
   String pres_qty_value = (String)fluidDetail.get("PRES_QTY_VALUE");//1 bottle
   
   
   /* Dispense Location */

   IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id_IVWA,bean_name_IVWA,request);
   bean.setLanguageId(locale);
   String perf_locn_desc="";
   
   
   String location_type_eph		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
   String location_code_eph		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
   String take_home_medication_eph     = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
   String priority				    = request.getParameter("priority")==null?"":request.getParameter("priority");
   String iv_prep_yn		        = "5";	
	
   //bean.setTakeHomeMedication(take_home_medication);
   ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type_eph,location_code_eph,take_home_medication_eph,priority,iv_prep_yn,"",patient_id,encounter_id);
	
   if(ord_disp_location != null & ord_disp_location.size()>0){ 
			perf_locn_desc	= (String)ord_disp_location.get(2)==null?"":(String)ord_disp_location.get(2);			
   }
   
   /* Dispense Location ends */
   
   
   String start_date = (String)fluidDetail.get("START_DATE");					
   String durn_value = (String)fluidDetail.get("DURN_VALUE");
   String infusion_over = (String)fluidDetail.get("INFUSE_OVER");
   String infuse_rate = (String)fluidDetail.get("INFUSION_RATE");
   String future_date = (String)fluidDetail.get("FUTURE_DATE");
   String back_date = (String)fluidDetail.get("BACK_DATE");
   String disp_locn_code = (String)fluidDetail.get("DISP_LOCN_CODE");
   String disp_locn_type = (String)fluidDetail.get("DISP_LOCN_TYPE");
   String infuse_over_unit_sch = (String)fluidDetail.get("INFUSE_OVER_UNIT_SCH");
   String mfr_remarks			=(String)fluidDetail.get("MFR_REMARKS");
   if(mfr_remarks ==null){
	   mfr_remarks ="";
   }
   String end_date		= bean_IVWA.populateEndDate(start_date, durn_value, "H");
   String infuse_over_hr		="";
   String infuse_over_mi		="";
   String mfr_yn				= "N";// Need to check
   //String mfr_remarks			= "N";// Need to check
   String mode				= CommonRepository.getCommonKeyValue( "MODE_MODIFY" ); 
   bean_IVWA.setMode( mode ) ;
   if(infusion_over.indexOf(".") != -1){
   			infuse_over_hr = infusion_over.substring(0,infusion_over.indexOf("."));
   			Double temp = new Double(infusion_over);
   			temp = temp*60;
   			temp = (temp%60);
   			infuse_over_mi = String.valueOf(Math.round(temp))+"";   			
   		}
   		else{
   			infuse_over_hr = infusion_over;
   			infuse_over_mi = "";
   		}
   		infuse_over_hr = infuse_over_hr.equals("")?"0":infuse_over_hr;
   		infuse_over_mi = infuse_over_mi.equals("")?"0":infuse_over_mi;   
   //Build MAR
   String buildMAR_yn		= ""; 
   String buildMAR_checked  = "";
   String buildMAR_enable   = "";
   String buildMAR_rule	    = "";
   infuse_over_hr=(String)fluidDetail.get("INFUSION_PERIOD_VALUE");
   infuse_over_mi=(String)fluidDetail.get("INFUSION_PERIOD_VALUE_MIN"); 
   buildMAR_rule = (String) fluidDetail.get("BUILD_MAR_RULE");
   buildMAR_yn = (String) fluidDetail.get("BUILD_MAR_YN");   
   if(buildMAR_yn.equals("Y"))
		buildMAR_checked ="Checked";
	else
		buildMAR_checked="";
   
   if(buildMAR_rule.equals("CE")){
	   buildMAR_enable   = "";
   }
   else if(buildMAR_rule.equals("UE")){
	   buildMAR_enable   = "";
   }
   else if(buildMAR_rule.equals("CD")){
	   buildMAR_enable   = "disabled";
   }
   else if(buildMAR_rule.equals("UD")){
	   buildMAR_enable   = "disabled";
   }  
   //  'CE' - Checked Enabled  'UE' - Un-Checked Enabled  'CD' - Checked Disabled  'UD' - Un-Checked Disabled   			
   //End
   
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( perf_locn_desc ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( durn_value ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( infuse_rate ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( pres_base_uom_desc ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( qty_value ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( pres_base_uom_desc ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(infuse_over_hr));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(infuse_over_mi));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(URLDecoder.decode(mfr_remarks, "UTF-8")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(URLDecoder.decode(mfr_remarks, "UTF-8")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(back_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(future_date));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( bean_id_IVWA ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( bean_name_IVWA ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( iv_calc_infuse_by ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(infusion_over));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_set_code ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(mfr_yn ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disp_locn_type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(take_home_medication));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(infuse_over_unit_sch));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block46Bytes, _wl_block46);

   }    
     
            _bw.write(_wl_block47Bytes, _wl_block47);
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
