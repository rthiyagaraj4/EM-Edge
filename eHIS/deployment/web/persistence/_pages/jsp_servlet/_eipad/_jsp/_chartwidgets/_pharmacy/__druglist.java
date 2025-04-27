package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.IVPiggyBackBean;
import eOR.OrderEntryBean;
import ePH.DrugInterfaceControlBean;
import ePH.IVPrescriptionBean;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Hashtable;
import ePH.PrescriptionBean;
import java.text.DateFormat;
import com.ehis.persist.PersistenceHelper;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eDS.Common.JSONObject;
import eDS.Common.JSONArray;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import ePH.PrescriptionBean_1;
import java.text.SimpleDateFormat;
import java.util.Date;;

public final class __druglist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/DrugList.jsp", 1709118020334L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<div class=\"orderDetailsViewCss\">\n<div  id=\"addedDrugListWrapper\" class=\"addedDrugListWrapperCss\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<div  id=\"wholeDrugListWrapper\" class=\"rxWrapperCss\">\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n   <div id=\"drugListScrollerRx\" class=\"drugListScrollerCss\">\n     <div id=\"orderType\" class=\"orderTypeCss\">\n\t    <div class=\"headerIconStyle\">\n\t\t  <div class=\"deleteGroupWrapper\" onclick=\"removeAllRX()\">\n\t\t     <img style=\"position: absolute;left: 7px;top: 6px;\" id=\"deleteDrugType\" src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/Delete_group.PNG\">\n\t\t  </div> \n\t\t</div>\n\t\t<div id=\"collapseWidgetRx\">\n\t\t<div class=\"table headerTypeStyle\">\n\t\t  <div class=\"row headerOrderName\">\n\t\t    <div class=\"cell vAlignBottom\">Rx</div>\n\t\t  </div>\n\t\t  <div class=\"row headerOrderPrice\">\n\t\t    <div class=\"cell vAlignTop\"><span id=\"rx_total_charge_span\">--</span>/<span id=\"rx_patient_payable_span\">--</span></div>\n\t\t  </div>\n\t\t</div>\n\t\t<div class=\"collapseWidgetStyle\" id=\"\">\n\t\t  <img id=\"collapseDrugTypeRx\" class=\"collapseCloseWidget\" src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/Collapse_Widget.png\">\n\t    </div>\n\t\t</div>\n\t </div>\n     <ul id=\"drugList\"  class=\"drugListCss\">      \n      ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n      <li class=\"drugItemStyleWrapper\">\n        <div id=\"drugItem\" class=\"drugItemStyle\">\n\t    <div class=\"deleteDrugStyleWrapper\">\n            <div class=\"deleteDrugStyle deleteRX\" data-DrugCode=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' data-Drugunique=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'  data-DrugType=\'RX\' onclick=\"removeRXItem(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\">\n\t\t\t    <img id=\"deleteDrugItem\" src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/images/Delete_cart.png\">  \t\t   \n            </div>\n\t\t</div>\n\t       \n\t   <div class=\"drugDetailsWrapper\" onclick=\"openPharmacyRxDetails(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")\">\n\t       <div class=\"drugDetailsStyle\"> \n\t\t      <div id=\"warningWrapper\" class=\"warningWrapperCss\">\n\t\t\t     ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="    \n\t\t\t\t <img style=\"padding-right:1px;\" src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/Drug_Warning12x12.png\">\n\t\t\t\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="   \n\t\t\t  </div>\n\t          <div id=\"div1\" class=\"drugDataContainer\">\t\t\t    \t\t\t\t\n                 <div id=\"drugname\" class=\"drugDescription\">\n                   ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n                 </div>\n\t\t\t\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t <div class=\"drugTradeName\">\n                    ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n                 <div id=\"durationdetails\" class=\"durationDetailsWrapper\">\n                    ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" - ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" for ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n                 </div>        \t\t\t\t\n\t\t\t  </div>\n\t\t\t  <div id=\"borderDivWrapper\" class=\"borderDivWrapperCss\">\n\t\t\t    <div class=\"borderDivStyle\">\n\t\t\t    </div>\n\t\t\t  </div>\n\t\t\t  <div id=\"div2\" class=\"drugDateDataWrapper\">\n\t\t\t    <div id=\"footerWrapper\" style=\"width:100%;\">\n\t\t\t\t <div class=\"table drugDateContainer\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t  <span>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</span>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t    <div class=\"cell startMonthStyleWrapper\">\n\t\t\t\t\t\t  <div class=\"table startMonthStyle\">\n                             <div class=\"row\"> \t\t\t\t\t\t  \n\t\t\t\t\t            <div class=\"cell startMonthCellCss\">\n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t         </div>\n\t\t\t\t\t\t\t <div class=\"row\">\n \t\t\t\t\t\t\t    <div class=\"cell startYearCellCss\">\n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t         </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n                 </div>\n                 <div class=\"table toStylingWrapper\">\n                    <div class=\"row\">\n\t\t\t\t\t  <div class=\"cell toStyleCss\">to</div>\n\t\t\t\t\t</div>\n                 </div>\n                 <div class=\"table drugDateContainer\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t   <span>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t        </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n                 </div>\n\t\t\t\t <div class=\"table priceDetailsWrapper\">\n\t\t\t\t    <div class=\"row\">\n\t\t\t\t    ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">/</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<div class=\"cell vAlignMiddle defaultFontColorOnCart\">--</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">/</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">--</div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t</div>\n\t\t\t\t </div>\n\t\t\t\t <div style=\"clear: both;\"></div>\n\t\t\t\t</div>\n\t\t\t  </div>\n           </div>\n\t   </div>      \t\t  \n\t       <div style=\"clear: both;\"></div>\n\t    </div>    \n      </li>     \n      ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n   </ul>\n   </div>\n ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<input type=\"hidden\" name=\"hdnIvRxRecSize\" id=\"hdnIvRxRecSize\" id=\"hdnIvRxRecSize\" value=\"y\" />\n   <div id=\"drugListScrollerIvrx\" class=\"drugListScrollerCss\">\n     <div id=\"orderTypeIvrx\" class=\"orderTypeCss\">\n\t    <div class=\"headerIconStyle\">\n\t\t  <div class=\"deleteGroupWrapper deleteIVIterClass\" data-DrugCode=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'  onclick=\"removeAllIVRX()\">\n\t\t     <img style=\"position: absolute;left: 7px;top: 6px;\" id=\"deleteDrugType\" src=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="/eIPAD/images/Delete_group.PNG\">\n\t\t  </div> \n\t\t</div>\t\t\n\t\t<div id=\"collapseWidgetIvrx\">\t\t\n\t\t<div class=\"table headerTypeStyle\">\n\t\t  <div class=\"row headerOrderName\">\n\t\t    <div class=\"cell vAlignBottom\">IV</div>\n\t\t  </div>\n\t\t  <div class=\"row headerOrderPrice\">\n\t\t    <div class=\"cell vAlignTop\">--/--</div>\n\t\t  </div>\n\t\t</div>\n\t\t<div class=\"collapseWidgetStyle\" id=\"\">\n\t\t  <img id=\"collapseDrugTypeIvrx\" class=\"collapseCloseWidget\" src=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="/eIPAD/images/Collapse_Widget.png\">\n\t    </div>\t\n\t\t</div>\t\t\n\t </div>  \n\t <ul id=\"drugListIvrx\"  class=\"drugListCss\">     \n\t <!-- IV with additives : Multiple Drugs, One Fluid-->\n\t ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t \n      <li class=\"drugItemStyleWrapper\">\n        <div id=\"drugItemIvrxAdditives\" class=\"drugItemStyle\">\n\t    <div class=\"deleteDrugStyleWrapper\">\n            <div class=\"deleteDrugStyle\" data-DrugCode=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onclick=\"removeAllIVD(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\')\">\n\t\t\t    <img id=\"deleteDrugItemIvrxWithAdd\" src=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="/eIPAD/images/Delete_cart.png\">  \t\t   \n            </div>\n\t\t</div>       \n\t   <div class=\"drugDetailsWrapper\" onclick=\'openPharmacyIvrxDetails(event,\"IVD\");\'>\n         <div class=\"drugDetailsStyle\">        \n\t          <div id=\"div1IvrxWithAdd\" style=\"padding-top:15px;\" class=\"drugDataContainer\">\n                 <ul id=\"ivrxDrugListWrapperOnAdd\" style=\"width: 98%;padding: 0px;\">\n\t\t\t\t    ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\t\t\t    \n\t\t\t\t    <li id=\"ivrxDrugListOnAddingWithAdd\" style=\"list-style: none;padding-bottom:10px;\">\n                      <div id=\"drugnameIvrxWithAdd\" class=\"drugDescription table\">\n                        <div class=\"row\">\n\t\t\t\t\t\t<div class=\"cell drugDescriptionInnerCss\">\n                          ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n                        </div>\t\t\n\t\t\t\n                        <div class=\"cell deleteDrugCss deleteIV deleteAllIVD\" style=\"vertical-align:top;\" data-DrugType=\'IVWA\'  data-DrugCode=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' onclick=\"removeIVWithAdd(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\',event,\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\">  \n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\t\t\t\n                           <img src=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="/eIPAD/images/Cart_delete_drug12x12.png\">\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n                        </div>\n\n                        </div>\n                      </div>\n\t\t\t\t      ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t <div class=\"drugTradeName\">\n\t                    ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t                 </div>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\t\t\t \n                      <div id=\"durationdetailsIvrxWithAdd\" class=\"durationDetailsWrapper\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t  \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n                      </div>\n\t\t\t\t    </li>\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n                 </ul>                       \n\t\t\t  </div>\n\t\t\t  <div id=\"borderDivWrapperIvrxWithAdd\" class=\"borderDivWrapperCss borderDivWrapperIvrxStyle\">\n\t\t\t    <div class=\"fluidDescriptionCss\">\n\t\t\t\t     ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t     <div class=\"fluidDescFontStyle\">Fluid not selected</div>\n\t\t\t\t     ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t     <div id=\"fluidnameIvrxWithAdd\" style=\"padding-top:15px;text-align:left;padding-left:1px;\" class=\"drugDescription\">\n                         ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n                     </div>\n                     <div id=\"durationdetailsIvrxWithAddFluid\" style=\"text-align:left;padding-left:1px;\" class=\"durationDetailsWrapper\">\n                         ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" over  ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n                     </div>\n                     ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t</div>\n\t\t\t\t<div class=\"ivrxTypeDescriptionCss\">\n                    IV WITH ADDITIVES\n\t\t\t    </div>\t\t\t   \n\t\t\t  </div>\t\t \n\t\t\t  <div id=\"div2IvrxWithAdd\" class=\"drugDateDataWrapper\">\n\t\t\t    <div style=\"width:100%;\">\n\t\t\t\t <div class=\"table drugDateContainer\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t  <span>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t        </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n                 </div>\n\t\t\t\t <div class=\"table priceDetailsWrapper\">\n\t\t\t\t    <div class=\"row\">\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">--</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">/</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">--</div>\n\t\t\t\t\t</div>\n\t\t\t\t </div>\n\t\t\t\t <div style=\"clear: both;\"></div>\n\t\t\t\t</div>\n\t\t\t  </div>\n        </div>\n\t   </div>   \n\t     ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="        \n                 <div id=\"warningWrapperIvrxWithAdd\" style=\"right: 6px;position: absolute;height: 15px;\">\t\t\t         \n\t\t\t\t \t<img src=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="/eIPAD/images/Drug_Warning12x12.png\">\t\t\t\t   \n\t\t\t  \t</div>  \n\t\t\t  \t ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" \t         \n\t   <div style=\"clear: both;\"></div>\n\t   </div>    \n      </li>\n      ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\t  \n\t  <!-- IV without additives : Multiple Fluids-->\n\t  <ul id=\"drugList\"  class=\"drugListCss\">\t  \n\t  ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t  <li class=\"drugItemStyleWrapper\">\n        <div id=\"drugItemIvrxWithoutAdditives\" class=\"drugItemStyle\">\n\t    <div class=\"deleteDrugStyleWrapper\">\n            <div class=\"deleteDrugStyle deleteIV\" data-DrugCode=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' data-DrugType=\'IVWOA\' onclick=\"removeIVWithoutAdd(\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="/eIPAD/images/Delete_cart.png\">  \t\t   \n            </div>\n\t\t</div>\t       \n\t   <div class=\"drugDetailsWrapper\" onclick=\"openPharmacyIvRxWaDetails(";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =")\">\n\t       <div class=\"drugDetailsStyle\"> \n\t\t      <div id=\"warningWrapperIvrxWithoutAdd\" class=\"warningWrapperCss\">\n\t\t\t       ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="  \n\t\t\t\t <img style=\"padding-right:1px;\" src=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="/eIPAD/images/Drug_Warning12x12.png\">\n\t\t\t\t   ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" \n\t\t\t  </div>\n\t          <div id=\"div1IvrxWithoutAdd\" class=\"drugDataContainer\">\t\t\t    \t\t\t\t\n                 <div id=\"drugnameIvrxWithoutAdd\" class=\"drugDescription\">\n                   <div class=\"drugDescriptionInnerCss\">\n                     ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n                   </div>\n                   <div class=\"deleteDrugCss\">                     \n                   </div>\n                 </div>\t\t\t\t\n\t\t\t\t ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\t\t\t \n                 <div id=\"durationdetails\" class=\"durationDetailsWrapper\">\n                    ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n                 </div>               \t\t\t\t\n\t\t\t  </div>\n\t\t\t  <div id=\"borderDivWrapperWithoutAdd\" class=\"borderDivWrapperCss\">\n\t\t\t    <div class=\"borderDivStyle\">\n\t\t\t       <div class=\"ivrxWithoutAddTypeDescriptionCss\">\n                    IV WITHOUT ADDITIVES\n\t\t\t       </div>\n\t\t\t\t</div>\n\t\t\t  </div>\t\t\t  \n\t\t\t  <div id=\"div2IvrxWithoutAdd\" class=\"drugDateDataWrapper\">\n\t\t\t    <div style=\"width:100%;\">\n\t\t\t\t <div class=\"table drugDateContainer\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t  <span>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t        </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n                 </div>\n\t\t\t\t <div class=\"table priceDetailsWrapper\">\n\t\t\t\t    <div class=\"row\">\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">--</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">/</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">--</div>\n\t\t\t\t\t</div>\n\t\t\t\t </div>\n\t\t\t\t <div style=\"clear: both;\"></div>\n\t\t\t\t</div>\n\t\t\t  </div>\n           </div>\n\t   </div>     \n\t     <div style=\"clear: both;\"></div>\n\t    </div>    \n      </li>\n      ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n      </ul>\n\t  ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t  <!-- IV Intermittent : One Drug, One Fluid-->\n\t  <li class=\"drugItemStyleWrapper\">\n        <div id=\"drugItemIvrxIntermittent\" class=\"drugItemStyle\">\n\t    <div class=\"deleteDrugStyleWrapper\">\n            <div class=\"deleteDrugStyle deleteIV\" data-DrugCode=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' data-DrugType=\"IVInter\"  onclick=\"RemoveIVIntermittent(\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\')\">\n\t\t\t    <img id=\"deleteDrugItemIvrxInter\" src=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="/eIPAD/images/Delete_cart.png\">  \t\t   \n            </div>\n\t\t</div>      \n\t   <div class=\"drugDetailsWrapper\" onclick=\'openPharmacyIvrxDetails(event,\"IVPB\");\'>\n         <div class=\"drugDetailsStyle\">            \n\t          <div id=\"div1IvrxInter\" style=\"padding-top:15px;\" class=\"drugDataContainer\">\n                 <ul id=\"ivrxDrugListWrapperOnAdd\" style=\"width: 98%;padding: 0px;\">\n\t\t\t\t    <li id=\"ivrxDrugListOnAddingWithoutAdd\" style=\"list-style: none;\">\n\t\t\t\t      <div id=\"drugnameIvrxWithoutAdd\" class=\"drugDescription\">\n                         <div class=\"drugDescriptionInnerCss\">\n                           ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n                         </div>\n                         <div class=\"deleteDrugCss\">                     \n                         </div>\n                      </div>\t\t\t\t \n\t\t\t\t      ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n                      <div id=\"durationdetailsIvrx\" class=\"durationDetailsWrapper\">\t\t\t\t\t  \n\t\t\t\t\t  ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\t\t\t\t\t  \n\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\t\t\t\t\t\t\n                      </div>\n\t\t\t\t    </li>\n                 </ul>                 \n\t\t\t  </div>\n\t\t\t  <div id=\"borderDivWrapperIvrxInter\" class=\"borderDivWrapperCss borderDivWrapperIvrxStyle\">\n\t\t\t    <div class=\"fluidDescriptionCss\">\n\t\t\t      ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t     <div class=\"fluidDescFontStyle\">Fluid not selected</div>\n\t\t\t\t  ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t  <div id=\"fluidnameIvrxWithInter\" style=\"padding-top:15px;text-align:left;\" class=\"drugDescription\">\n                         ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n                  </div>\n                  <div id=\"durationdetailsIvrxWithInterFluid\" style=\"text-align:left;\" class=\"durationDetailsWrapper\">\n                       ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n                  </div>\n\t\t\t\t  ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="     \n\t\t\t\t</div>\n\t\t\t\t<div class=\"ivrxTypeDescriptionCss\">\n                    IV INTERMITTENT\n\t\t\t    </div>\t\n\t\t\t  </div>\t\t\t  \n\t\t\t  <div id=\"div2IvrxInter\" class=\"drugDateDataWrapper\">\n\t\t\t    <div style=\"width:100%;\">\n\t\t\t\t <div class=\"table drugDateContainer\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t  <span>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t        </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n                 </div>\n\t\t\t\t <div class=\"table priceDetailsWrapper\">\n\t\t\t\t    <div class=\"row\">\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">--</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">/</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">--</div>\n\t\t\t\t\t</div>\n\t\t\t\t </div>\n\t\t\t\t <div style=\"clear: both;\"></div>\n\t\t\t\t</div>\n\t\t\t  </div>\n        </div>\n\t   </div> \n\t       ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="        \n                 <div id=\"warningWrapperIvrxWithInter\" style=\"right: 6px;position: absolute;height: 15px;\">\n\t\t\t         \n\t\t\t\t \t<img src=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="/eIPAD/images/Drug_Warning12x12.png\">\n\t\t\t\t   \n\t\t\t  \t</div>  \n\t\t\t  \t ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="      \n\t    <div style=\"clear: both;\"></div>\n\t    </div>    \n      </li>\n\t  ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n   </ul>\n   </div>\n   ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n  <!-- CRX Bubble Starts--> \n   <div id=\"drugListScrollerCRX\" class=\"drugListScrollerCss\">\n     <div id=\"orderTypeCRX\" class=\"orderTypeCss\">\n\t    <div class=\"headerIconStyle\">\n\t\t  <div class=\"deleteGroupWrapper deleteIVIterClass\" data-DrugCode=\'id_drugName_tradeName\'  onclick=\"removeAllCRX()\">\n\t\t     <img style=\"position: absolute;left: 7px;top: 6px;\" id=\"deleteDrugTypeCRX\" src=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="/eIPAD/images/Delete_group.PNG\">\n\t\t  </div> \n\t\t</div>\t\t\n\t\t<div id=\"collapseWidgetCRX\">\t\t\n\t\t<div class=\"table headerTypeStyle\">\n\t\t  <div class=\"row headerOrderName\">\n\t\t    <div class=\"cell vAlignMiddle\">CRX</div>\n\t\t  </div>\n\t\t</div>\n\t\t<div class=\"collapseWidgetStyle\" id=\"\">\n\t\t  <img id=\"collapseDrugTypeCRX\" class=\"collapseCloseWidget\" src=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="/eIPAD/images/Collapse_Widget.png\">\n\t    </div>\t\n\t\t</div>\t\t\n\t </div>  \n\t <ul id=\"drugListCrx\"  class=\"drugListCss\">\n      <li class=\"drugItemStyleWrapper\">\n        <div id=\"drugItemIvrxAdditives\" class=\"drugItemStyle\">\n\t    <div class=\"deleteDrugStyleWrapper\">\n            <div class=\"deleteDrugStyle\" data-DrugCode=\'id_drugName_tradeName\' onclick=\"removeAllCRX()\">\n\t\t\t    <img id=\"deleteDrugItemIvrxWithAdd\" src=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="/eIPAD/images/Delete_cart.png\">  \t\t   \n            </div>\n\t\t</div>       \n\t    <div class=\"drugDetailsWrapper\" onclick=\'openPharmacyCrxDetails(\"CRX\",\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\");\'>\n            <div class=\"drugDetailsStyle\">        \n\t          <div id=\"div1IvrxWithAdd\" style=\"padding-top:15px;\" class=\"drugDataContainer\">\n\t\t\t\t\t<ul id=\"ivrxDrugListWrapperOnAdd\" style=\"width: 98%;padding: 0px;\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t    <li id=\"ivrxDrugListOnAddingWithAdd\" style=\"list-style: none;padding-bottom:10px;\">\n                      <div id=\"drugnameIvrxWithAdd\" class=\"drugDescription table\">\n                        <div class=\"row\">\n\t\t\t\t\t\t<div class=\"cell drugDescriptionInnerCss\">\n                          ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n                        </div>\t\n\n\t\t\t<div class=\"cell deleteDrugCss deleteCRX deleteAllCRX\" style=\"vertical-align:top;\" data-DrugType=\'CRX\' data-DrugCode=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' onclick=\"removeCRXDrug(\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\')\">\n                           <img src=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="/eIPAD/images/Cart_delete_drug12x12.png\">\n                        </div>\n                        </div>\n                      </div>\n\t\t\t\t    </li>\n\t\t\t\t    ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n                 </ul>                       \n\t\t\t  </div>\n\t\t\t  <div id=\"borderDivWrapper\" class=\"borderDivWrapperCss\">\n\t\t\t    <div class=\"borderDivStyle durationDetailsWrapper\">\n\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t    </div>\n\t\t\t  </div>\n\t\t\t  <div id=\"div2IvrxWithAdd\" class=\"drugDateDataWrapper\">  \n\t\t\t    <div style=\"width:100%;\">\n\t\t\t\t <div class=\"table drugDateContainer\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t  <span>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t        </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n\t\t\t\t</div>\n\t\t\t\t <div class=\"table priceDetailsWrapper\">\n\t\t\t\t    <div class=\"row\">\t\t\t\t\t\n\t\t\t\t    \t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t<div class=\"cell vAlignMiddle defaultFontColorOnCart\">--</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">/</div>\n\t\t\t\t\t   <div class=\"cell vAlignMiddle defaultFontColorOnCart\">--</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\t\t\t\t\t   \n\t\t\t\t\t</div>\n\t\t\t\t </div>\t\t\t\t \n\t\t\t\t <div style=\"clear: both;\"></div>\n\t\t\t\t</div>\n\t\t\t  </div>\n            </div>\n\t    </div>   \n\t      \n        <div id=\"warningWrapperCrx\" style=\"right: 6px;position: absolute;height: 15px;\">\t\t\t         \n\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="/eIPAD/images/Drug_Warning12x12.png\">\t\t\t\t   \n\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="  \n\t\t</div>  \t         \n\t\t\n\t   <div style=\"clear: both;\"></div>\n\t   </div>    \n      </li>\n   </ul>\n   </div>\n   ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n</div>\n  <input type=\"hidden\" id=\"PHCartErrorExists\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" name=\"PHCartErrorExists\">\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n <div style=\"width: 100%;height: 100%;display: flex;align-items: center;justify-content: center\">\n\t  <div style=\"margin: 0;font-family:Segoe UI Semibold;font-size:12px;color:#6d798f;\"> \t    \n\t\t\tPharmacy cart is empty\n      </div>\n  </div>\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="   \n<input type=\"hidden\" id=\"rx_patient_payable\" name=\"rx_patient_payable\" id=\"rx_patient_payable\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"/>\n<input type=\"hidden\" id=\"rx_total_charge\" name=\"rx_total_charge\" id=\"rx_total_charge\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"/>\n<input type=\"hidden\" id=\"all_patient_payable\" name=\"all_patient_payable\" id=\"all_patient_payable\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"/>\n<input type=\"hidden\" id=\"all_total_charge\" name=\"all_total_charge\" id=\"all_total_charge\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"/>\n</div>  \n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n</div>\n<div class=\"orderDetailsFooterCss\">\n    <div class=\"billingDetails table\">\n\t    <div class=\"row\">\n\t\t\t<div class=\"cell billingDetailsCell\">\n\t\t\t    <div class=\"billingDetailsText segoeuiBold\">Total Charge</div>\n\t\t\t</div>\n\t\t\t<div class=\"cell billingDetailsCell\">\n\t\t\t    <div class=\"table fullHtFullWt\">\n\t\t\t\t\t<div class=\"row fullWtHalfHt\">\n\t\t\t\t\t    <div class=\"cell billingAmount\"><span class=\"segoeuiBold\" id=\"all_total_charge_span\">--</span>/<span id=\"all_patient_payable_span\" class=\"segoeuiBold\">--</span></div>\n\t\t\t        </div>\n\t\t\t\t\t<div class=\"row fullWtHalfHt\">\n\t\t\t\t\t    <div class=\"cell billingAmountInfo segoeuiBold\">Total/Patient</div>\n\t\t\t\t\t</div>\n\t\t\t    </div>\n\t\t\t</div>\n\t\t</div>\n    </div>\n    <div class=\"billingBottomBorder\">\n\t</div>\n</div>\n<script>\n    var collapseRxWidget = \"opened\";\n    var collapseIvrxWidget = \"opened\";\n\tvar collapseCrxWidget = \"opened\";\n    var path;\n    var cartDrugListScroller;\n    function cartDrugListScroll() {\n        cartDrugListScroller = new IScroll(\'#addedDrugListWrapper\', {\n            scrollX: false,\n            scrollY: true,\n            interactiveScrollbars: true,\n            click: true,\n            useTransition: false,\n            hideScrollbar: true,\n            scrollbars: true,\n            bindToWrapper: true,\n            fadeScrollbars: true\n        });\n    }\n    $(document).ready(function() {\n        path = $(\"#hdnPath\").val();\n        cartDrugListScroll();\n        var rx_patient_payable = parseFloat($(\"#rx_patient_payable\").val());\n        var rx_total_charge = parseFloat($(\"#rx_total_charge\").val());\n        var all_patient_payable = parseFloat($(\"#all_patient_payable\").val());\n        var all_total_charge = parseFloat($(\"#all_total_charge\").val());\n        if (rx_total_charge > 0 || rx_patient_payable > 0) {\n            $(\"#rx_total_charge_span\").html(rx_total_charge.toFixed(2));\n            $(\"#rx_patient_payable_span\").html(rx_patient_payable.toFixed(2));\n        }\n        if (all_total_charge > 0 || all_patient_payable > 0) {\n            $(\"#all_total_charge_span\").html(all_total_charge.toFixed(2));\n            $(\"#all_patient_payable_span\").html(all_patient_payable.toFixed(2));\n        }\n    });\n\t\n\tfunction cartClose(){\n\t\t$(\"#cartOpened\").val(\"N\");\n        $(\"#cartView\").hide();\n        $(\"#cartWrapper\").show();\n        $(\"#cart\").show();\n\t}\n\t\n\t\n\n    function openPharmacyRxDetails(drugItemNo) {\n        $(\"#PageLoadingAnimation\").show();\n        $(\"#RxOrderPlaceDiv\").hide();\n        $(\"#RxOrderFieldsDiv\").show();\n        $(\"#RxOrderFieldsDiv\").append(\"<div id=\'PageLoadingAnimation\' class=\'absoluteCenter\'></div>\");\n        $(\"#RxOrderFieldsDiv\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/PharmRxDetailsView.jsp?drugItemNo=\' + drugItemNo, function() {\n            $(\"#PageLoadingAnimation\").hide();\n            $(\"#rxDetailsLegend\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=rxDetailsLegend\', function(res) {});\n        });\n    }\n\n    function openPharmacyIvrxDetails(evt, drugItemType) {\n        $(\"#PageLoadingAnimation\").show();\n        $(\"#RxOrderPlaceDiv\").hide();\n        $(\"#RxOrderFieldsDiv\").show();\n        switch (drugItemType) {\n            case \"IVD\":\n                $(\"#RxOrderFieldsDiv\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/pharmIvRXWithAddView.jsp\', function() {\n                    $(\"#PageLoadingAnimation\").hide();\n                    $(\"#ivRxWithAddLegend\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=ivRxWithAddLegend\',\n                        function(res) {});\n                });\n                break;\n            case \"IVPB\":\n                $(\"#RxOrderFieldsDiv\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/pharmIvRXWithInterView.jsp\', function() {\n                    $(\"#PageLoadingAnimation\").hide();\n                    $(\"#ivRxInterLegend\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=ivRxInterLegend\',\n                        function(res) {});\n                });\n                break;\n        }\n    }\n\n    function openPharmacyIvRxWaDetails(drugItemNo) {\n        $(\"#PageLoadingAnimation\").show();\n        $(\"#RxOrderPlaceDiv\").hide();\n        $(\"#RxOrderFieldsDiv\").show();\n        $(\"#RxOrderFieldsDiv\").append(\"<div id=\'PageLoadingAnimation\' class=\'absoluteCenter\'></div>\");\n\t\t\n\t\tvar takeHomeMedication = $(\"#take_home_medication\").val();\n        var priority = $(\"#priority\").val();\n        var location_code = $(\"#location_code\").val();\n        var location_type = $(\"#location_type\").val();\n            \n        \n\t\t\n        $(\"#RxOrderFieldsDiv\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/pharmIvRXWithoutAdtView.jsp?drugItemNo=\' + drugItemNo + \'&location_type=\' + location_type + \'&location_code=\' + location_code + \'&take_home_medication=\' + takeHomeMedication + \'&priority=\' + priority, function() {\n            $(\"#PageLoadingAnimation\").hide();\n            $(\"#ivRxWithoutAddLegend\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=ivRxWithoutAddLegend\',\n                function(res) {});\n        });\n    }\n\t\n\t\t\n\tfunction openPharmacyCrxDetails(ordertype, lenstr) {\n\t\tvar lenInt = parseInt(lenstr);\n\t\tif(lenInt<2){\n\t\t\tshowToastMsg1(\"Add one or more order drug to the pharmacy cart to access details view\");\n\t\t}\n\t\telse{\n\t\t\t$(\"#PageLoadingAnimation\").show();\n            $(\"#RxOrderPlaceDiv\").hide();\n            $(\"#RxOrderFieldsDiv\").show();\n            $(\"#RxOrderFieldsDiv\").append(\"<div id=\'PageLoadingAnimation\' class=\'absoluteCenter\'></div>\");\n\t\t\t\n            var takeHomeMedication = $(\"#take_home_medication\").val();\n            var priority = $(\"#priority\").val();\n            var location_code = $(\"#location_code\").val();\n            var location_type = $(\"#location_type\").val();\n            \n           // console.log(\"location_type: \"+location_type+\" location_code: \"+location_code+\" takeHomeMedication: \"+takeHomeMedication+\" priority: \"+priority);\n            \n            $(\"#RxOrderFieldsDiv\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/pharmCrxDetailsView.jsp?location_type=\' + location_type + \'&location_code=\' + location_code + \'&take_home_medication=\' + takeHomeMedication + \'&priority=\' + priority, function(){\n\t\t    $(\"#CRxAddLegend\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=CRxAddLegend\',\n                function(res) {});\n\t\t });\n\t\t}\n        \n    }\n\t\n    $(\"#collapseWidgetRx\").click(function() {\n        if (collapseRxWidget == \"opened\") {\n            $(\"#drugList\").hide();\n            collapseRxWidget = \"closed\";\n            $(\"#collapseDrugTypeRx\").removeClass(\"collapseCloseWidget\");\n\t\t\tvar hdnIvRxRecSize = $(\"#hdnIvRxRecSize\").val();\n\t\t\tif(hdnIvRxRecSize == \"y\"){\n            $(\"#drugListScrollerRx\").css(\"border-bottom\", \"5px solid #ffffff\");\n\t\t\t}\n        } else if (collapseRxWidget == \"closed\") {\n            $(\"#drugList\").show();\n            collapseRxWidget = \"opened\";\n            $(\"#collapseDrugTypeRx\").addClass(\"collapseCloseWidget\");\n            $(\"#drugListScrollerRx\").css(\"border-bottom\", \"\");\n        }\n        if (cartDrugListScroller) {\n            cartDrugListScroller.refresh();\n        }\n    });\n\n    $(\"#collapseWidgetIvrx\").click(function() {\n        if (collapseIvrxWidget == \"opened\") {\n            $(\"#drugListIvrx\").hide();\n            collapseIvrxWidget = \"closed\";\n            $(\"#collapseDrugTypeIvrx\").removeClass(\"collapseCloseWidget\");\n        } else if (collapseIvrxWidget == \"closed\") {\n            $(\"#drugListIvrx\").show();\n            collapseIvrxWidget = \"opened\";\n            $(\"#collapseDrugTypeIvrx\").addClass(\"collapseCloseWidget\");\n        }\n        if (cartDrugListScroller) {\n            cartDrugListScroller.refresh();\n        }\n    });\n\t\n\t\n    $(\"#collapseWidgetCRX\").click(function() {\n        if (collapseCrxWidget == \"opened\") {\n            $(\"#drugListCrx\").hide();\n            collapseCrxWidget = \"closed\";\n            $(\"#collapseDrugTypeCRX\").removeClass(\"collapseCloseWidget\");\n        } else if (collapseCrxWidget == \"closed\") {\n            $(\"#drugListCrx\").show();\n            collapseCrxWidget = \"opened\";\n            $(\"#collapseDrugTypeCRX\").addClass(\"collapseCloseWidget\");\n        }\n        if (cartDrugListScroller) {\n            cartDrugListScroller.refresh();\n        }\n    });\n\t\n    function removeRXItem(drugcode, divID) {\n        SetRemoveValues(drugcode, divID, \"REMOVE_ITEM_RX\");\n        $(\"#deleteConfirmMsg\").show();\n    }\n\n    function EnableDuplicateDrug(SelDivId) {\n        var selDivIds = SelDivId.split(\"_\");\n        $(\"div[data-currentid]\").each(function(index, value) {\n            var drugCodeUnique = $(this).attr(\'data-drugcodeunique\');\n            var divId = $(this).attr(\'data-currentid\');\n\n            if (selDivIds[0] == drugCodeUnique) {\n                EnableBubbleItem(divId);\n            }\n            $(this).attr(\"data-role\", \"draggable\");\n        });\n    }\n\n    function okDeleteCartItemDialog() \n\t{\n        var removeType = $(\"#removeType\").val();\n        if (removeType == \"REMOVE_ITEM_RX\") {\n            var selDivID = $(\"#drugDivID\").val();\n            var selDrugCode = $(\"#drugDelCode\").val();\n\t    EnableOrderBasedOnDrugInfo(selDrugCode, selDivID);\n            EnableBubbleItem(selDivID);            \n\t    RemoveItemFromList(selDivID);\t\t\t\n            EnableDuplicateDrug(selDivID);\n            $(\"#\" + selDivID).removeClass(\"cstFieldDullRx\");\n            makeServerCall(selDrugCode, removeType, \"\");\n        } \n\t\telse if (removeType == \"REMOVE_DRUG_IVD\") {\n            var selDivID = $(\"#drugDivID\").val();\n            var selDrugCode = $(\"#drugDelCode\").val();\n\t\t//\tEnableOrderBasedOnDrugInfo(selDrugCode, selDivID);\n            EnableBubbleItem(selDivID);\n            $(\"#\" + selDivID).removeClass(\"cstFieldDullRx\");\n\t    \t\tRemoveItemFromList(selDivID);\n\t\t\tmakeServerCall(selDrugCode, removeType, \"\");\n\t\t}\n\t\telse if (removeType == \"REMOVE_DRUG_CRX\")\n\t\t{\n\t\t\tvar selDivID = $(\"#drugDivID\").val();\n            var selDrugCode = $(\"#drugDelCode\").val();\t\t\t\n\t\t\tEnableBubbleItem(selDivID);\n            $(\"#\" + selDivID).removeClass(\"cstFieldDullRx\");\n\t    \tRemoveItemFromList(selDivID);\n\t\t\tmakeServerCall(selDrugCode, removeType, \"\");\n\t\t}\n\t\telse if (removeType == \"REMOVE_FLUID_IVWA\") \n\t\t{\n            var totalString = $(\"#drugDivID\").val().split(\"$$\");\n            if (totalString.length > 1) {\n                var selDivID = totalString[0];\n                var serNo = totalString[1];\n                var selDrugCode = $(\"#drugDelCode\").val();\n\t\tEnableOrderBasedOnDrugInfo(selDrugCode, selDivID);\n                EnableBubbleItem(selDivID);\t\t\t\t\n\t\tRemoveItemFromList(selDivID);\t\t\t\t\n                $(\"#\" + selDivID).removeClass(\"cstFieldDullRx\");\n                makeServerCall(selDrugCode, removeType, serNo);\n            }\n        }\n\telse if (removeType == \"REMOVE_ALL_IVPB\") \n\t{\n\t\tvar selDivID = $(\"#drugDivID\").val();\n\t\tEnableOrderBasedOnDrugInfo(\"\", selDivID);\n\t\tEnableBubbleItem(selDivID);\n\t\tRemoveItemFromList(selDivID);\n                $(\"#\" + selDivID).removeClass(\"cstFieldDullRx\");\n                makeServerCall(\"\", removeType, \"\");\n        }\n\t\telse if (removeType == \"REMOVE_ALL_RX\") \n\t\t{\n            RemoveAllDrugs(\"deleteRX\");\n            makeServerCall(\"\", removeType, \"\");\n        } else if (removeType == \"REMOVE_ALL_IV\") {\n            RemoveAllDrugs(\"deleteIV\");\n            makeServerCall(\"\", removeType, \"\");\n        }\n\telse if  (removeType == \"REMOVE_ALL_IVD\")\n\t{\n\t\tRemoveAllDrugs(\"deleteAllIVD\");\t\t\n\t\tmakeServerCall(\"\", removeType, \"\");\n\t}\n\telse if(removeType == \"REMOVE_ALL_CRX\")\n\t{\n\t\tRemoveAllDrugs(\"deleteAllCRX\");\n\t\tmakeServerCall(\"\", removeType, \"\");\n\t}\n        $(\"#deleteConfirmMsg\").hide();\t\t\n\t\tif(allAddedDrug.length == 0){\n\t\t\tcartClose();\n\t    }\n    }\n\n    function SetRemoveValues(drugcode, divID, removeType) {\n        $(\"#drugDelCode\").val(drugcode);\n        $(\"#drugDivID\").val(divID);\n        $(\"#removeType\").val(removeType);\n    }\n\n    function RemoveAllDrugs(className) \n\t{\n\t\n        $(\".\" + className).each(function(index, value) {\n\n            EnableBubbleItem($(this).attr(\'data-drugcode\'));\n            RemoveItemFromList($(this).attr(\'data-drugcode\'));\n\t    EnableOrderBasedOnDrugInfo($(this).attr(\'data-drugcode\'), $(this).attr(\'data-drugcode\'));\n\n        });\n    }\n\n    function RemoveItemFromList(drug) \n\t{\t\t\n\n        for (var g = 0; g < allAddedDrug.length; g++) {\n            var drugDetails = allAddedDrug[g];\n            var drugCode = drugDetails.drugCode;\t\n\t      var tempDruTrade=drug.split(\'_\');\n\t\t\n\t\t\t\n            if (drugCode == drug ) {\t\t\t\t\n                allAddedDrug.splice(g, 1);\n\t\t\t\tbreak;\t\n            }\n        }\n\t\tif(allAddedDrug.length == 0){\t\t\t\n\t\t\t $(\"#completePlaceOrdersConfirm\").addClass(\'completePlaceOrdersDisable\');\n\t\t}\n    }\n\n    function removeAllRX() {\n        SetRemoveValues(\"\", \"\", \"REMOVE_ALL_RX\");\n        $(\"#deleteConfirmMsg\").show();\n\n    }\n\n    function EnableBubbleItem(divId) {\n        $(\"#\" + divId).removeClass(\"cstFieldDullRx\");\n        $(\"#\" + divId).kendoDraggable({\n            holdToDrag: true,\n            hold: function(e) {},\n            hint: function(element) {\n                return element.clone();\n            },\n            dragstart: draggableOnDragStart,\n            dragend: draggableOnDragEnd\n        });\n        try {\n\n            $(\"#\" + divId).data(\"kendoDraggable\").userEvents.minHold = 70;\n        } catch (ex) {}\n    }\n\n\t\n\tfunction currentOrderId(drugDetails,drugCode,divId){\n\t\t\n\t\tvar orderDetails=drugDetails;\n\t\t\n\t\tvar drugInfo =orderDetails.drugInfo;\n\t\t\n\t\tfor(var t=0;t< drugInfo.length;t++){\n\t\t\n\t\tvar  currentElemDrug=drugInfo[t];\n\t\t//console.log(\"currentElemDrug:: **********\"+JSON.stringify(currentElemDrug));\n\t\t \n\t\t//console.log(\"currentElemDrug currentElemDrug******\"+currentElemDrug.drugUnique+\"divId:::\"+divId+\"drugCode:::\"+drugCode);\n\t\t\n\t\tvar TradeNames =currentElemDrug.TradeNames;\n\t\tvar durgCodeTrade;\n\t\tif(TradeNames==\"\"){\n\t\t\t\n\t\t\tdurgCodeTrade=currentElemDrug.drugUnique+\"_T\";\n\t\t}else{\n\t\t\t\n\t\t\tdurgCodeTrade=currentElemDrug.drugUnique+\"_\"+TradeNames;\n\t\t}\n\t\t \n\t\t\n\t\t \n\t\tif(divId==durgCodeTrade){\n\t\t\t\n\t\t\treturn  orderDetails.orderId;\n\t\t}\n\t\tvar tempDruTrade=durgCodeTrade.split(\'_\');\n\t\tif( divId.indexOf(tempDruTrade[0]) >= 0){\n\t\t\t\n                  return  orderDetails.orderId;\n \n           }\n\t\t\n\t\t\n\t}\n\t\n\t\n\t}\n\t\n\tfunction enableDrug(drugDetails){\n\t\tvar orderDetails= drugDetails;\n\t\tvar drugInfo =orderDetails.drugInfo;\n\t\t\n\t\tfor(var t=0;t< drugInfo.length;t++){\n\t\t\t\n\t\tvar  currentElemDrug=drugInfo[t];\n\t\t\n\t\tvar durgCodeTrade=currentElemDrug.drugUnique+\"_T\";\n\t\tEnableBubbleItem(durgCodeTrade);\n\t\t}\n\t\t\n\t}\n\t\n\tfunction clearDeleteArray(orderId){\n\t\t\n\t\tfor (var g = 0; g < allAddedDrug.length; g++) {\n        var drugDetails = allAddedDrug[g];\n\t\n\t\tvar order = drugDetails instanceof currentDrug; \n\t\t\n\t//\tconsole.log(\"last_element::\"+order);\n\t\t\n\t\tif(!order){\n\t\t\t\n\t      var order= drugDetails.orderId;\n\t\t  \n\t\t // console.log(\"order:::\"+order+\"order order orderId\"+orderId);\n\t\t  \n\t\t  var drugInfo =drugDetails.drugInfo;\n\t\t  var drugInfoRx=drugInfo[0];\n\t\t  var drug_type=drugInfoRx.drug_type;\n\t\t  \n\t\t  var orderFrom =drugInfoRx.orderFrom;\n\t\t  \n\t\t  if(drug_type==\"Rx\" && orderFrom==\"po\" || drug_type==\"IVWA\" && orderFrom==\"po\" ){\n\t\t\t  \n\t\t   var rxPos =drugInfoRx.rxPos;\n\t\t\t   \n\t\t\t  if(orderId==order){\n\t\t\t  enableDrug(drugDetails);\n\t\t\t  var orderIdRx=orderId+\"_\"+rxPos;\n\t\t\t  EnableBubbleItem(orderIdRx);\n\t\t\t  allAddedDrug.splice(g, 1);\n\t\t\t  \n\t\t  } \n\t\t\t  \n\t\t  }else{\n\t\t\t  \n\t\t\t  if(orderId==order){\n\t\t\t  enableDrug(drugDetails);\n\t\t\t  allAddedDrug.splice(g, 1);\n\t\t\t  \n\t\t  } \n\t\t\t  \n\t\t  }\n\t\t  \n\t\t \n\t\t}\n\t\t\n\t\t}\n\t\t\n\t}\n\t\n\t\n    function EnableOrderBasedOnDrugInfo(drugCode,divId){\n    \n    //\tconsole.log(\"all deatils::\"+allAddedDrug.length);\n\t\t  var drugArray = [];\n\t for (var g = 0; g < allAddedDrug.length; g++) {\n        var drugDetails = allAddedDrug[g];\n\t\t\n\t\t//console.log(\"drugDetails:::drugDetails drugDetails drugDetails drugDetails::\"+JSON.stringify(drugDetails));\n\t\tvar order = drugDetails instanceof currentDrug; \n\t\t\n\t\t//console.log(\"last_element::\"+order);\n\t\t\n\t\tif(!order){\n\t\t\n\tvar orderId = currentOrderId(drugDetails,drugCode,divId);\n\t\n//\tconsole.log(\"order isd::\"+orderId);\n\t\n\t    clearDeleteArray(orderId);\n\t\tEnableBubbleItem(orderId);\n\t\t\n\t\t}\n\t\t\n\t\t\n    }\n    \n\t\n    \t\n    }\n    \n    \n    function removeIVWithAdd(drugcode, event, divID) {\n        event.stopPropagation();\n        SetRemoveValues(drugcode, divID, \"REMOVE_DRUG_IVD\");\n        $(\"#deleteConfirmMsg\").show();\n    }\n    \n    function removeCRXDrug(drugcode, event, divID) {\t\t\n\t\tevent.stopPropagation();\n\t\tSetRemoveValues(drugcode, divID, \"REMOVE_DRUG_CRX\");\n\t\t$(\"#deleteConfirmMsg\").show();\n    }\n    \n    \n    function removeAllCRX(){\n\t\tSetRemoveValues(\"\", \"\", \"REMOVE_ALL_CRX\");\n\t\t$(\"#deleteConfirmMsg\").show();\n    }\n\n    function removeAllIVD(drugcode, divID) {\n        SetRemoveValues(drugcode, divID, \"REMOVE_ALL_IVD\");\n        $(\"#deleteConfirmMsg\").show();\n\t\t//EnableOrderBasedOnDrugInfo(drugcode, divID);\n\t\t//alert(\"called here\");\n    }\n\n    function removeIVWithoutAdd(drugcode, srl, divID) {\n        SetRemoveValues(drugcode, divID + \"$$\" + srl, \"REMOVE_FLUID_IVWA\");\n        $(\"#deleteConfirmMsg\").show();\n       // EnableOrderBasedOnDrugInfo(drugcode, divID);\n    }\n\n\tfunction removeAllIVWA(){\n\t\tmakeServerCall(\"\", \"REMOVE_ALL_IVWA\", \"\");\n\t}\n\n    function RemoveIVIntermittent(divID) {\n        SetRemoveValues(\"\", divID, \"REMOVE_ALL_IVPB\");\n        $(\"#deleteConfirmMsg\").show();\n\t\t//EnableOrderBasedOnDrugInfo(\"\", divID);\n    }\n\n    function removeAllIVRX() {\n\tSetRemoveValues(\"\", \"\", \"REMOVE_ALL_IV\");\n\t$(\"#deleteConfirmMsg\").show();\n    }\n\n    function makeServerCall(drugcode, mode, srlNo){\n\tif (drugcode == \"\")\n\t\tdrugcode = \"N\";\n\tif (srlNo == \"\")\n\t\tsrlNo = \"N\";\n\tvar validationPath = path + \'/mobile/charts/pharmacy/PharmValidationJSONServlet?mode=\' + mode;\n\t$.getJSON(validationPath, {\n\t\tDrugCode: drugcode,\n\t\tSrlNo: srlNo\n\t})\n\t.done(function(json){\n\t\tvar result = json.validationResult;\n\t\trefreshCart();\n\t\t$(\"#cartCount\").text(getCountOfCart());\n\t\t$(\"#countDisplay\").text(getCountOfCart());\n\t})\n\t.fail(function(jqxhr, textStatus, error){\n\t\tvar err = textStatus + \", \" + error;\n\t});\n\t}\n\n    function refreshCart(){\n    \t$(\"#orderDetailsView\").load(path + \'/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp\');\n    }\n</script>\n\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);
 
String id_drugName_tradeName="";

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){
	String patient_id = patientContext.getPatientId();
	String encounter_id = patientContext.getEncounterId();
	String patient_class = patientContext.getPatientClass();
	String facility_id = patientContext.getFacilityId();
	String episode_type	= patient_class.substring(0,1);	
	String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
try{
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;	
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean	= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request); 
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)PersistenceHelper.getBeanObject(presBean_id, presBean_name, request );
	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;

	String param_bean_id		= "@DrugInterfaceControlBean"+patient_id+encounter_id;
	String param_bean_name		= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
	
	IVPiggyBackBean beanBack = (IVPiggyBackBean)PersistenceHelper.getBeanObject("IVPiggyBackBean"+patient_id+encounter_id, "ePH.IVPiggyBackBean", request);
	
  HashMap drug_detail	 =	null;
  ArrayList	presDetails	=(ArrayList) bean.getpresDetails();
  
  /* ivrx list */ 
  ArrayList drugDetails;
  ArrayList AllFluids;
 
  String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
  String bean_name_IVD	= "ePH.IVPrescriptionBean";
  IVPrescriptionBean bean_IVD	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
 
  String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
  String bean_name_IVPB	= "ePH.IVPrescriptionBean";
  IVPrescriptionBean bean_IVPB	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
  
  String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
  String bean_name_IVWA	= "ePH.IVPrescriptionBean";
  IVPrescriptionBean bean_IVWA	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
  
  String bean_id_CRX			= "@IVPrescriptionBean_CRX"+ patientContext.getPatientId() + patientContext.getEncounterId();
  String bean_name_CRX	= "ePH.IVPrescriptionBean";
  IVPrescriptionBean bean_CRX	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_CRX, bean_name_CRX, request);

  boolean cartErrorExists = false;
  float rx_patient_payable_fl = 0;
  float rx_total_charge_fl = 0;
  
  float all_patient_payable_fl = 0;
  float all_total_charge_fl = 0;

            _bw.write(_wl_block3Bytes, _wl_block3);

if(bean_IVD.getDrugDetails().size()>0 || bean_IVPB.getDrugDetails().size()>0 || bean_IVWA.getAllFluids().size()>0 || bean.getpresDetails().size()>0 || bean_CRX.getDrugDetails().size()>0){

            _bw.write(_wl_block4Bytes, _wl_block4);

  // "this is for RX order type"   
  if(presDetails!=null && presDetails.size()>0){ 

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);

     for(int a=0;a<presDetails.size();a++){
		drug_detail=(HashMap) presDetails.get(a);		
		String drugDesc = (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC"); 
        	String drugCode = (String)drug_detail.get("DRUG_CODE")==null?"":(String)drug_detail.get("DRUG_CODE");						
		String freqDuration = (String)drug_detail.get("DURN_VALUE")==null?"":(String)drug_detail.get("DURN_VALUE"); //"5" for 5 days
		String freqValue = (String)drug_detail.get("FREQ_VALUE")==null?"":(String)drug_detail.get("FREQ_VALUE"); //"3" -- 3 days
		String freq_desc = (String)drug_detail.get("FREQ_DESC")==null?"":(String)drug_detail.get("FREQ_DESC"); //"Three times a day"
		String freq_nature = (String)drug_detail.get("FREQ_NATURE")==null?"":(String)drug_detail.get("FREQ_NATURE");
		String durationDesc = (String)drug_detail.get("DURN_DESC")==null?"":(String)drug_detail.get("DURN_DESC");// "Day(s)"
		String durationType = (String)drug_detail.get("DURN_TYPE")==null?"":(String)drug_detail.get("DURN_TYPE"); 	
		String srlNo = (String)drug_detail.get("SRL_NO")==null?"":(String)drug_detail.get("SRL_NO");
		String dosage_type = (String)drug_detail.get("DOSAGE_TYPE")==null?"":(String)drug_detail.get("DOSAGE_TYPE"); 
		String qtyDesc = (String)drug_detail.get("QTY_DESC")==null?"":(String)drug_detail.get("QTY_DESC"); //Tablet(s)
		String absDesc = (String)drug_detail.get("PRES_BASE_UOM_DESC")==null?"":(String)drug_detail.get("PRES_BASE_UOM_DESC"); //Absolute
		String formDesc = (String)drug_detail.get("FORM_DESC")==null?"":(String)drug_detail.get("FORM_DESC"); //Tablet(s)
		String qtyVal = (String)drug_detail.get("QTY_VALUE")==null?"":(String)drug_detail.get("QTY_VALUE");
		//String tradeName = "";
		String tradeName = (String)drug_detail.get("TRADE_NAME")==null?"":(String)drug_detail.get("TRADE_NAME");
		String startDate = (String)drug_detail.get("START_DATE")==null?"":(String)drug_detail.get("START_DATE");
		String strength_uom	= (String) drug_detail.get("STRENGTH_UOM")==null?"":(String)drug_detail.get("STRENGTH_UOM");
		String strength_value = (String) drug_detail.get("STRENGTH_VALUE")==null?"":(String)drug_detail.get("STRENGTH_VALUE");
		String patient_payable = (String) drug_detail.get("BL_PATIENT_PAYABLE_AMT")==null?"0":(String)drug_detail.get("BL_PATIENT_PAYABLE_AMT");
		String total_charge = (String) drug_detail.get("BL_TOTAL_CHARGE_AMT")==null?"0":(String)drug_detail.get("BL_TOTAL_CHARGE_AMT");
		String  in_formulary_yn = (String) drug_detail.get("IN_FORMULARY_YN")==null?"0":(String)drug_detail.get("IN_FORMULARY_YN");
		String bl_error_code			= (String)drug_detail.get("BL_ERROR_CODE")==null?"":(String)drug_detail.get("BL_ERROR_CODE"); 
		String bl_sys_message_id		= (String)drug_detail.get("BL_SYS_MESSAGE_ID")==null?"":(String)drug_detail.get("BL_SYS_MESSAGE_ID");
		String bl_error_text			= (String)drug_detail.get("BL_ERROR_TEXT")==null?"":(String)drug_detail.get("BL_ERROR_TEXT");
		String man_rem_on_prn_freq_yn = (String)drug_detail.get("MANDATORY_REM_ON_PRN_FREQ_YN")==null?"N":(String)drug_detail.get("MANDATORY_REM_ON_PRN_FREQ_YN");
		float patient_payable_fl = 0;
		float total_charge_fl = 0;
		String bl_install_yn = orbean.getBillingInterfaceYn() == null ? "" : orbean.getBillingInterfaceYn();
		ArrayList param_vals	=	bean.getParameterValues();
		String bl_disp_charge_dtl_in_rx_yn		=	(String)param_vals.get(2);
		if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y") && in_formulary_yn.equals("Y")){
			if((bl_error_code.equals("") && bl_sys_message_id.equals("") && bl_error_text.equals(""))){
				patient_payable_fl = Float.parseFloat(patient_payable);
				total_charge_fl = Float.parseFloat(total_charge);
				rx_patient_payable_fl = rx_patient_payable_fl + patient_payable_fl;
				rx_total_charge_fl = rx_total_charge_fl + total_charge_fl;
				all_patient_payable_fl = all_patient_payable_fl + patient_payable_fl;
				all_total_charge_fl = all_total_charge_fl + total_charge_fl;
			}
		}
		String pat_counseling_reqd = (String)drug_detail.get("PAT_COUNSELING_REQD");
		if(pat_counseling_reqd==null||pat_counseling_reqd.equals("")){
			pat_counseling_reqd = "N";
			drug_detail.put("PAT_COUNSELING_REQD",pat_counseling_reqd);
		}
	
		String uom_disp = bean.getUomDisplay(facility_id,strength_uom);
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");	//TODO
		if(startDate==null||startDate.equals("")){
			startDate = df.format(new Date());
			drug_detail.put("START_DATE",startDate);
			
		}
		String endDate = (String)drug_detail.get("END_DATE"); 
		if(endDate==null || endDate.equals("")){//TODO
			endDate = (String)drug_detail.get("END_DATE")==null?(String)drug_detail.get("START_DATE"):(String)drug_detail.get("END_DATE");  
			drug_detail.put("END_DATE",endDate);
		}
		String freq_code = (String)drug_detail.get("FREQ_CODE")==null?"":(String)drug_detail.get("FREQ_CODE");  
		String priority = (String)drug_detail.get("PRIORITY")==null?"":(String)drug_detail.get("PRIORITY");  
		String allow_duplicate = (String) drug_detail.get("ALLOW_DUPLICATE_DRUG")==null?"":(String)drug_detail.get("ALLOW_DUPLICATE_DRUG");
		String allow_duplicate_op				= (String) drug_detail.get("ALLOW_DUPLICATE_DRUG_OP")==null?"":(String)drug_detail.get("ALLOW_DUPLICATE_DRUG_OP");
		
		if(patient_class.equals("OP") || patient_class.equals("EM")|| patient_class.equals("XT")){
			allow_duplicate = allow_duplicate_op;
		}
		String current_rx	= (String)drug_detail.get("CURRENT_RX")==null?"N":(String)drug_detail.get("CURRENT_RX");
		
		DateFormat fMonth = new SimpleDateFormat("MMM");
		DateFormat fDate = new SimpleDateFormat("dd");
		DateFormat fYear = new SimpleDateFormat("yyyy");
		Date startDate_dt = df.parse(startDate);
		Date endDate_dt = df.parse(endDate);
		String formattedStartDate = fDate.format(startDate_dt);		
		String formattedStartMonthSmallCase = fMonth.format(startDate_dt);
		String formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
		String formattedStartYear = fYear.format(startDate_dt);

		String formattedEndDate = fDate.format(endDate_dt);		
		String formattedEndMonthSmallCase = fMonth.format(endDate_dt);
		String formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();
		String formattedEndYear = fYear.format(endDate_dt);		
		String drugMandatoryWarning = "N";
		String allergy_yn	= (String)drug_detail.get("ALLERGY_YN")==null?"N":(String)drug_detail.get("ALLERGY_YN");
		if(allergy_yn.equals("Y")){
			String allergy_remarks = (String)drug_detail.get("ALLERGY_REMARKS")==null?"":(String)drug_detail.get("ALLERGY_REMARKS");
			if(allergy_remarks.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}
		}
		String limit_ind	= (String)drug_detail.get("LIMIT_IND")==null?"Y":(String)drug_detail.get("LIMIT_IND");
		if(limit_ind.equals("N")){
			String dose_remarks = (String)drug_detail.get("DOSE_REMARKS")==null?"":(String)drug_detail.get("DOSE_REMARKS");
			if(dose_remarks.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}
		} 
		String route_code = (String)drug_detail.get("ROUTE_CODE")==null?"":(String)drug_detail.get("ROUTE_CODE");
		if(route_code.equals("")){
			drugMandatoryWarning = "Y";
			cartErrorExists = true;
		}
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id)==null?"":param_bean.getDrugDBInterface_yn(facility_id);
		String drug_db_duptherapy_yn	    =	param_bean.getDrugDBDuptherapy_yn(facility_id)==null?"":param_bean.getDrugDBDuptherapy_yn(facility_id);
		String ext_prod_id					= (String)drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID"); 
		if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y")) && current_rx!=null && current_rx.equals("Y")){	
			String currentrx_remarks = (String)drug_detail.get("CURRENTRX_REMARKS")==null?"":(String)drug_detail.get("CURRENTRX_REMARKS");
			if(currentrx_remarks.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}
		}
		String interaction_exists	= (String)drug_detail.get("INTERACTION_EXISTS")==null?"N":(String)drug_detail.get("INTERACTION_EXISTS");
		if(interaction_exists.equals("Y")){
			String interaction_remarks = (String)drug_detail.get("INTERACTION_REMARKS")==null?"":(String)drug_detail.get("INTERACTION_REMARKS");
			if(interaction_remarks.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}
		}
		//Checking if PRN rem is mandatory
		if(man_rem_on_prn_freq_yn.equals("Y") && freq_nature.equals("P")){
			String interaction_remarks = (String)drug_detail.get("PRN_REMARKS")==null?"":(String)drug_detail.get("PRN_REMARKS");
			if(interaction_remarks.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}
		}
		HashMap freqValues = (HashMap)bean.populateFrequencyValues(drugCode,freq_code,"modify",patient_class);
		ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
		ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
		ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
		boolean statFeqFound = false;
		boolean def_freq_found = false;
		boolean dup_found = false;
		String statFreqCode = "";
		String freq_option = "";
		if(current_rx.equals("Y") && allow_duplicate.equals("N")){
			dup_found = true;
		}
		drug_detail.put("SCHEDULED_YN","N");//TODO
		if(freq_code.equals("")){
			drugMandatoryWarning = "Y";
			cartErrorExists = true;
		}
		if(freq_nature.equals("")){
			drug_detail.put("FREQ_NATURE","O");//TODO
		}
     if(durationType.equals("") || durationDesc.equals("")){ 
		Hashtable DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
			durationType = "D";
			durationDesc = (String)DurnDescDetails.get("D");
			
			drug_detail.put("DURN_DESC",durationDesc);
			drug_detail.put("DURN_TYPE",durationType);
      } 				
	  
	  /*forenabling the div */
	  String id_drug= drugCode.replaceAll("[-+.^:,]","");
	  String trad="T";
		if(!tradeName.equalsIgnoreCase(""))
		{
		trad=tradeName;
		}
	 String id_trad= trad.replaceAll("[-+.^:,]","");	
     id_drugName_tradeName=id_drug+"_"+id_trad;
      
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(id_drug));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(drugCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(a));
            _bw.write(_wl_block14Bytes, _wl_block14);

				  if(drugMandatoryWarning.equalsIgnoreCase("Y")){ 
				 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);

				 }
				 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(drugDesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
 if(!tradeName.equalsIgnoreCase(""))
				 {
				 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tradeName));
            _bw.write(_wl_block18Bytes, _wl_block18);

				 }
				 String quantityDesc = "";
				 if(dosage_type.equals("S")){
					 quantityDesc = uom_disp;
				 }
				 
				 else if(dosage_type.equals("Q")){
					 quantityDesc = qtyDesc;
				 }
				 else {
					 quantityDesc = absDesc;
				 }
				 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(qtyVal));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(quantityDesc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(freqDuration));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(durationDesc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(formattedStartDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(formattedStartMonth));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(formattedStartYear));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(formattedEndDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(formattedEndMonth));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(formattedEndYear));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(patient_payable_fl!=0 || total_charge_fl!=0) {
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(total_charge));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_payable));
            _bw.write(_wl_block32Bytes, _wl_block32);
}else{ 
            _bw.write(_wl_block33Bytes, _wl_block33);
} 
            _bw.write(_wl_block34Bytes, _wl_block34);

      }
      
            _bw.write(_wl_block35Bytes, _wl_block35);

 } 
if(bean_IVD.getDrugDetails().size()>0 || bean_IVPB.getDrugDetails().size()>0 || bean_IVWA.getAllFluids().size()>0){

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block39Bytes, _wl_block39);
	 
	String drug_db_interface_yn			= "N";
	String drug_db_product_id			= "";
	String drug_db_dosecheck_yn			= "N";
	String drug_db_duptherapy_yn		= "N";
	String drug_db_interact_check_yn	= "N";
	String drug_db_contraind_check_yn	= "N";
	String drug_db_allergy_check_yn		= "N";
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
	 drugDetails =  bean_IVD.getDrugDetails();
	 if(drugDetails.size()>0)
	 {
		HashMap drugDetail2 = (HashMap)drugDetails.get(0);
		String drug_code2 = (String)drugDetail2.get("DRUG_CODE");
		String tradeName2 = (String)drugDetail2.get("TRADE_NAME")==null?"":(String)drugDetail2.get("TRADE_NAME");
		/*forenabling the div */
		String id_drug2= drug_code2.replaceAll("[-+.^:,]","");
		String trad2="T";
		if(!tradeName2.equalsIgnoreCase("")){
			trad2=tradeName2;
		} 
	 	String id_trad2= trad2.replaceAll("[-+.^:,]","");	
     		id_drugName_tradeName=id_drug2+"_"+id_trad2;
	 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(drug_code2));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block43Bytes, _wl_block43);

				    String drugMandatoryWarning = "N";
					DateFormat df;
					String formattedStartDate="";		
		            String formattedStartMonthSmallCase="";
		            String formattedStartMonth="";		
		            String formattedStartYear="";
		            String formattedEndDate="";		
		            String formattedEndMonthSmallCase="";
		            String formattedEndMonth="";				
		            String formattedEndYear="";		
					String order_type="";
					HashMap FluidDetails = bean_IVD.getFluidDetails();
					for(int c=0;c<drugDetails.size();c++){
						HashMap drugDetail = (HashMap)drugDetails.get(c);
						String drug_desc = (String)drugDetail.get("DRUG_DESC");
						String drug_code = (String)drugDetail.get("DRUG_CODE");
						String qty_desc = (String)drugDetail.get("QTY_DESC");//AMPOULE
						qty_desc = bean.getUomDisplay(facility_id,qty_desc);
						if(qty_desc.equalsIgnoreCase("")||qty_desc==null){
							
							qty_desc=(String)drugDetail.get("QTY_DESC");
						}
						
						drugDetail.put("QTY_DESC",qty_desc);
						
						 order_type = (String)drugDetail.get("ORDER_TYPE");//ORDER_TYPE
						String qty_value = (String)drugDetail.get("QTY_VALUE");//1
						String pres_qty_value=(String)drugDetail.get("PRES_QTY_VALUE");
						String ori_dosage_type=(String)drugDetail.get("ORI_DOSAGE_TYPE");
						String calc_dose_based_on=(String)drugDetail.get("CALC_DOSE_BASED_ON")==null?"":(String)drugDetail.get("CALC_DOSE_BASED_ON"); 
						String calc_dose_value=(String)drugDetail.get("CALC_DOSE_VALUE");
						String pres_qty_uom=(String)drugDetail.get("PRES_QTY_UOM");
						String start_date = (String)drugDetail.get("START_DATE");
						String end_date = (String)drugDetail.get("END_DATE");						
						String freq_desc = (String)drugDetail.get("FREQ_DESC")==null?"":(String)drugDetail.get("FREQ_DESC"); //"Three times a day"
						String freq_duration = (String)drugDetail.get("DURN_VALUE")==null?"":(String)drugDetail.get("DURN_VALUE"); //"5" for 5 days
						String duration_desc = (String)drugDetail.get("DURN_DESC")==null?"":(String)drugDetail.get("DURN_DESC");// "Day(s)"
						String duration_type = (String)drugDetail.get("DURN_TYPE")==null?"":(String)drugDetail.get("DURN_TYPE");// "Day(s)"
						String freq_value = (String)drugDetail.get("FREQ_VALUE")==null?"":(String)drugDetail.get("FREQ_VALUE"); //"3" -- 3 days
						String fluid_durn_value = (String)FluidDetails.get("DURN_VALUE")==null?"24":(String)FluidDetails.get("DURN_VALUE"); //"3" -- 3 days
						df = new SimpleDateFormat("dd/MM/yy HH:mm");	//TODO
		                  if(start_date==null||start_date.equals("")){
			                  start_date = df.format(new Date());
			                  drugDetail.put("START_DATE",start_date);		
		                  }						
		                  if(end_date==null || end_date.equals("")){//TODO
			               end_date = (String)drugDetail.get("END_DATE")==null?(String)drugDetail.get("START_DATE"):(String)drugDetail.get("END_DATE");  
			               drugDetail.put("END_DATE",end_date);
		                  }			
		                  
		                  if(end_date.equalsIgnoreCase("")){
		      		    	
		      		    	end_date=(String)drugDetail.get("START_DATE");
		      		       }
						   	int durn_int = Integer.parseInt(fluid_durn_value);
						   	if(durn_int==0){
						   		fluid_durn_value = "24";
						   	}
							String freq_durations="";
						   /* if(durn_int>=24){
							   
							   freq_durations="24";
						   }else{
							   
							   freq_durations=freq_duration;
						   } */
						   end_date	=  bean_IVD.populateEndDate(start_date,fluid_durn_value,"H");
		                  
						String dosage_type = (String)drugDetail.get("DOSAGE_TYPE");
						String tradeName = (String)drugDetail.get("TRADE_NAME")==null?"":(String)drugDetail.get("TRADE_NAME");
						String dosage_by = "Strength";
						if(dosage_type.equals("S")){
							dosage_by = "Strength";
						}else if(dosage_type.equals("Q")){
							dosage_by = "Quantity";
						}					
						String current_rx = (String)drugDetail.get("CURRENT_RX")==null?"N":(String)drugDetail.get("CURRENT_RX");
						if(current_rx.equals("Y") && !drug_db_duptherapy_yn.equals("Y")) {
							String currentrx_remarks =  (String)drugDetail.get("CURRENTRX_REMARKS")==null?"":(String)drugDetail.get("CURRENTRX_REMARKS");
							if(currentrx_remarks.equals("")){
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						}
						String limit_ind	= (String)drugDetail.get("LIMIT_IND")==null?"Y":(String)drugDetail.get("LIMIT_IND");
						if(limit_ind.equals("N") && !drug_db_dosecheck_yn.equals("Y")){
							String dose_remarks = (String)drugDetail.get("DOSE_REMARKS")==null?"":(String)drugDetail.get("DOSE_REMARKS");
							if(dose_remarks.equals("")){
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						} 
						String allergy_yn	= (String)drugDetail.get("ALLERGY_YN")==null?"N":(String)drugDetail.get("ALLERGY_YN");
						if(allergy_yn.equals("Y") && !drug_db_allergy_check_yn.equals("Y")){
							String allergy_remarks = (String)drugDetail.get("ALLERGY_REMARKS")==null?"":(String)drugDetail.get("ALLERGY_REMARKS");
							if(allergy_remarks.equals("")){
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						}			


                        	float qty_value_fl = Float.parseFloat(qty_value);
					
				if(qty_value_fl==0){
					drugMandatoryWarning = "Y";
					cartErrorExists = true;
				}						
				DateFormat fMonth = new SimpleDateFormat("MMM");
		                DateFormat fDate = new SimpleDateFormat("dd");
		                DateFormat fYear = new SimpleDateFormat("yyyy");
		                Date startDate_dt = df.parse(start_date);
		                Date endDate_dt = df.parse(end_date);		
		                formattedStartDate = fDate.format(startDate_dt);		
		                formattedStartMonthSmallCase = fMonth.format(startDate_dt);
		                formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
		                formattedStartYear = fYear.format(startDate_dt);
		                formattedEndDate = fDate.format(endDate_dt);		
		                formattedEndMonthSmallCase = fMonth.format(endDate_dt);
		                formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();				
		                formattedEndYear = fYear.format(endDate_dt);			
						 /*forenabling the div */
	                    String id_drug= drug_code.replaceAll("[-+.^:,]","");
	                    String trad="T";
		                if(!tradeName.equalsIgnoreCase(""))
		                {	
		                 trad=tradeName;
		                }	 
	                    String id_trad= trad.replaceAll("[-+.^:,]","");	
                            id_drugName_tradeName=id_drug+"_"+id_trad;
				    
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block48Bytes, _wl_block48);
if(order_type.equalsIgnoreCase("Normal"))	{	
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block50Bytes, _wl_block50);
 } 
            _bw.write(_wl_block51Bytes, _wl_block51);
 if(!tradeName.equalsIgnoreCase(""))
					 {
					 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tradeName));
            _bw.write(_wl_block53Bytes, _wl_block53);

					 }
				      
            _bw.write(_wl_block54Bytes, _wl_block54);
 if(calc_dose_based_on.equals("B")){
							ori_dosage_type="Q";
						}
            _bw.write(_wl_block55Bytes, _wl_block55);
 if (ori_dosage_type.equals("Q")) {
							 if (calc_dose_based_on.equals("B")) {
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(calc_dose_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pres_qty_uom));
            _bw.write(_wl_block57Bytes, _wl_block57);
} else {
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(pres_qty_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(qty_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
}}
						if (ori_dosage_type.equals("S")) {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(qty_desc));
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);

					}
					
            _bw.write(_wl_block60Bytes, _wl_block60);

				     
				     String fluid_drug_desc = (String)FluidDetails.get("DRUG_DESC");
					String fluid_qty_uom_desc = (String)FluidDetails.get("PRES_BASE_UOM_DESC");
                    fluid_qty_uom_desc = bean.getUomDisplay(facility_id,fluid_qty_uom_desc);
					
					if(fluid_qty_uom_desc.equalsIgnoreCase("")||fluid_qty_uom_desc==null){
							
							fluid_qty_uom_desc = (String)FluidDetails.get("PRES_BASE_UOM_DESC");
						}
						FluidDetails.put("PRES_BASE_UOM_DESC",fluid_qty_uom_desc);
						
					String fluid_qty_uom = (String)FluidDetails.get("QTY_UOM");
					String fluid_qty_value = (String)FluidDetails.get("QTY_VALUE");						
					String INFUSION_PERIOD_VALUE = (String)FluidDetails.get("INFUSION_PERIOD_VALUE");
					String INFUSION_PERIOD_VALUE_MIN = (String)FluidDetails.get("INFUSION_PERIOD_VALUE_MIN");					
					String fluid_tradeName = (String)FluidDetails.get("TRADE_NAME")==null?"":(String)FluidDetails.get("TRADE_NAME");
					String Fluid_drugcode = (String)FluidDetails.get("DRUG_CODE");
					String infusion_over = bean_IVD.getINFUSE_OVER();
					if(infusion_over.equals("")){
						infusion_over = "0";
					}
					float infusion_over_fl = Float.parseFloat(infusion_over);
					String 	inf_over_displaystr = INFUSION_PERIOD_VALUE+" Hrs "+INFUSION_PERIOD_VALUE_MIN+" Mins";
					if(infusion_over_fl==0){
						drugMandatoryWarning = "Y";
						cartErrorExists = true;
					}
					
				 	 if(FluidDetails.isEmpty() || Fluid_drugcode==null ||Fluid_drugcode.equals("")){
				 		drugMandatoryWarning = "Y";
						cartErrorExists = true;				 	 				 		
				     
            _bw.write(_wl_block61Bytes, _wl_block61);

				 	 }else{
				 		
				     
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(fluid_drug_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fluid_qty_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fluid_qty_uom_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(inf_over_displaystr ));
            _bw.write(_wl_block65Bytes, _wl_block65);

				 	 }
                     
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(formattedStartDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(formattedStartMonth));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(formattedStartYear));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(formattedEndDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(formattedEndMonth));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(formattedEndYear));
            _bw.write(_wl_block67Bytes, _wl_block67);

				  if(drugMandatoryWarning.equalsIgnoreCase("Y")){ 
				 
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block69Bytes, _wl_block69);

				 }
				 
            _bw.write(_wl_block70Bytes, _wl_block70);

	  }	 
	  AllFluids = bean_IVWA.getAllFluids();
	  if(AllFluids.size()>0){	  
      
            _bw.write(_wl_block71Bytes, _wl_block71);

	  for(int c=0;c<AllFluids.size();c++){		  
		  	String drugMandatoryWarning = "N";
			HashMap fluidDetail = (HashMap)AllFluids.get(c);
			String drug_desc = (String)fluidDetail.get("DRUG_DESC");
			String drug_code = (String)fluidDetail.get("DRUG_CODE");
			String qty_desc = (String)fluidDetail.get("QTY_DESC");//ml
			String qty_value = (String)fluidDetail.get("QTY_VALUE"); // 1 ml
			String pres_base_uom_desc = (String)fluidDetail.get("PRES_BASE_UOM_DESC");//Bottle
			String pres_qty_value = (String)fluidDetail.get("PRES_QTY_VALUE");//1 bottle
			String start_date = (String)fluidDetail.get("START_DATE");
			String end_date = (String)fluidDetail.get("END_DATE");
			String infusion_over = (String)fluidDetail.get("INFUSE_OVER");
				String infusion_over_hrs = (String)fluidDetail.get("INFUSION_PERIOD_VALUE");
					String infusion_over_mins = (String)fluidDetail.get("INFUSION_PERIOD_VALUE_MIN");
			if(infusion_over.equals("")){
				infusion_over = "0";
			}
			float infusion_over_fl = Float.parseFloat(infusion_over);
			int infusion_period_value = new Double(infusion_over_fl).intValue();
			int infusion_period_value_min = new Double(Math.ceil((infusion_over_fl)*60)%60).intValue();			
			String 	inf_over_displaystr = infusion_over_hrs+" Hrs "+infusion_over_mins+" Mins";	
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");	//TODO
		            if(start_date==null||start_date.equals("")){
			                  start_date = df.format(new Date());
			                  fluidDetail.put("START_DATE",start_date);		
		            }						
		            if(end_date==null || end_date.equals("")){//TODO
			               end_date = (String)fluidDetail.get("END_DATE")==null?(String)fluidDetail.get("START_DATE"):(String)fluidDetail.get("END_DATE");  
			               fluidDetail.put("END_DATE",end_date);
		            }		
			String infuse_over = (String)fluidDetail.get("INFUSE_OVER");
			String tradeName = (String)fluidDetail.get("TRADE_NAME")==null?"":(String)fluidDetail.get("TRADE_NAME");
			if(infuse_over.equals("")){
				infuse_over = "0";
			}
			float infuse_over_fl = Float.parseFloat(infuse_over);
			if(infuse_over_fl==0 ){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}	        
			DateFormat fMonth = new SimpleDateFormat("MMM");
            DateFormat fDate = new SimpleDateFormat("dd");
            DateFormat fYear = new SimpleDateFormat("yyyy");
            Date startDate_dt = df.parse(start_date);
            Date endDate_dt = df.parse(end_date);
            String formattedStartDate = fDate.format(startDate_dt);		
            String formattedStartMonthSmallCase = fMonth.format(startDate_dt);
            String formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
            String formattedStartYear = fYear.format(startDate_dt);
            String formattedEndDate = fDate.format(endDate_dt);		
            String formattedEndMonthSmallCase = fMonth.format(endDate_dt);
            String formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();				
            String formattedEndYear = fYear.format(endDate_dt);	
			int c_Value = c+1;
			 /*forenabling the div */
	                    String id_drug= drug_code.replaceAll("[-+.^:,]","");
	                    String trad="T";
		                if(!tradeName.equalsIgnoreCase(""))
		                {	
		                 trad=tradeName;
		                }	 
	                    String id_trad= trad.replaceAll("[-+.^:,]","");	
                        id_drugName_tradeName=id_drug+"_"+id_trad;
	  
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(c_Value));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(c));
            _bw.write(_wl_block75Bytes, _wl_block75);

				  if(drugMandatoryWarning.equalsIgnoreCase("Y")){ 
				 
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block77Bytes, _wl_block77);

				 }
				 
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
 if(!tradeName.equalsIgnoreCase(""))
				 {
				 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tradeName));
            _bw.write(_wl_block18Bytes, _wl_block18);

				 }
				 
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pres_base_uom_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(inf_over_displaystr ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(formattedStartDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(formattedStartMonth));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(formattedStartYear));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(formattedEndDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(formattedEndMonth));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(formattedEndYear));
            _bw.write(_wl_block82Bytes, _wl_block82);

	  }
      
            _bw.write(_wl_block83Bytes, _wl_block83);

	  }	    
	  drugDetails =  bean_IVPB.getDrugDetails();		
	  if(drugDetails.size()>0){
		  String drugMandatoryWarning = "N";
		  HashMap drugDetail = (HashMap)drugDetails.get(0);		  
			String drug_desc = (String)drugDetail.get("DRUG_DESC");
			String qty_desc = (String)drugDetail.get("QTY_DESC");
			String qty_value = (String)drugDetail.get("PRES_QTY_VALUE");
			String DOSAGE_TYPE = (String)drugDetail.get("DOSAGE_TYPE");	
			
			String pres_qty_value=(String)drugDetail.get("PRES_QTY_VALUE");
			String ori_dosage_type=(String)drugDetail.get("ORI_DOSAGE_TYPE");
			String calc_dose_based_on=(String)drugDetail.get("CALC_DOSE_BASED_ON")==null?"":(String)drugDetail.get("CALC_DOSE_BASED_ON"); 
			String calc_dose_value=(String)drugDetail.get("CALC_DOSE_VALUE");
			String pres_qty_uom=(String)drugDetail.get("PRES_QTY_UOM");
			
			if(DOSAGE_TYPE.equalsIgnoreCase("S")){
				String strength_value = (String)drugDetail.get("STRENGTH_VALUE");
				drugDetail.put("PRES_QTY_VALUE", strength_value);
			}					
			String drugCode = (String)drugDetail.get("DRUG_CODE")==null?"":(String)drugDetail.get("DRUG_CODE");	
			String start_date = (String)drugDetail.get("START_DATE");
			String end_date = (String)drugDetail.get("END_DATE");		
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");	//TODO
            if(start_date==null||start_date.equals("")){
			    start_date = df.format(new Date());
			    drugDetail.put("START_DATE",start_date);		
		    }						
		    if(end_date==null || end_date.equals("")){//TODO
			   end_date = (String)drugDetail.get("END_DATE")==null?(String)drugDetail.get("START_DATE"):(String)drugDetail.get("END_DATE");  
			   drugDetail.put("END_DATE",end_date);
		    }			
		    if(end_date.equalsIgnoreCase("")){
		    	
		    	end_date=(String)drugDetail.get("START_DATE");
		    }
			String dosage_type = (String)drugDetail.get("DOSAGE_TYPE");
			String tradeName = (String)drugDetail.get("TRADE_NAME")==null?"":(String)drugDetail.get("TRADE_NAME");
			String dosage_by = "Strength";
			if(dosage_type.equals("S")){
				qty_value=(String)drugDetail.get("PRES_QTY_VALUE")==null?"":(String)drugDetail.get("PRES_QTY_VALUE");
				dosage_by = "Strength";
			}else if(dosage_type.equals("Q")){
				dosage_by = "Quantity";
			}			
			
			 float qty_value_flw = Float.parseFloat(qty_value);
					
						if(qty_value_flw==0){
							drugMandatoryWarning = "Y";
							cartErrorExists = true;
						}

						
						
						
			String current_rx = (String)drugDetail.get("CURRENT_RX")==null?"N":(String)drugDetail.get("CURRENT_RX");
			if(current_rx.equals("Y") && !drug_db_duptherapy_yn.equals("Y")) {
				String currentrx_remarks =  (String)drugDetail.get("CURRENTRX_REMARKS")==null?"":(String)drugDetail.get("CURRENTRX_REMARKS");
				if(currentrx_remarks.equals("")){
					drugMandatoryWarning = "Y";
					cartErrorExists = true;
				}
			}
			String limit_ind	= (String)drugDetail.get("LIMIT_IND")==null?"Y":(String)drugDetail.get("LIMIT_IND");
			if(limit_ind.equals("N") && !drug_db_dosecheck_yn.equals("Y")){
				String dose_remarks = (String)drugDetail.get("DOSE_REMARKS")==null?"":(String)drugDetail.get("DOSE_REMARKS");
				if(dose_remarks.equals("")){
					drugMandatoryWarning = "Y";
					cartErrorExists = true;
				}
			} 
			String allergy_yn	= (String)drugDetail.get("ALLERGY_YN")==null?"N":(String)drugDetail.get("ALLERGY_YN");
			if(allergy_yn.equals("Y") && !drug_db_allergy_check_yn.equals("Y")){
				String allergy_remarks = (String)drugDetail.get("ALLERGY_REMARKS")==null?"":(String)drugDetail.get("ALLERGY_REMARKS");
				if(allergy_remarks.equals("")){
					drugMandatoryWarning = "Y";
					cartErrorExists = true;
				}
			}
			String freq_code = (String)drugDetail.get("FREQ_CODE");
			
			ArrayList freqValues = beanBack.getSheduleFrequency(drugCode);				
			if( freqValues.size()>0){
				String contains="no";
				for (int i=0;i<freqValues.size();i+=2){
					//System.out.println("addFrequencyList(\""+((String)freqValues.get(i))+"\",\""+((String)freqValues.get(i+1))+"\",\""+freq_code.trim()+"\")");
					
					String genertedCode=(String)freqValues.get(i);
				
					if(genertedCode.equals(freq_code.trim())){
						contains="yes";
					}
					
				}
				
				if(contains.equalsIgnoreCase("no")){
					
					freq_code="";
				}
			}
			
			
			if(freq_code==null || freq_code.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}			
			DateFormat fMonth = new SimpleDateFormat("MMM");
            DateFormat fDate = new SimpleDateFormat("dd");
            DateFormat fYear = new SimpleDateFormat("yyyy");
            Date startDate_dt = df.parse(start_date);
            Date endDate_dt = df.parse(end_date);
            String formattedStartDate = fDate.format(startDate_dt);		
            String formattedStartMonthSmallCase = fMonth.format(startDate_dt);
            String formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
            String formattedStartYear = fYear.format(startDate_dt);
            String formattedEndDate = fDate.format(endDate_dt);		
            String formattedEndMonthSmallCase = fMonth.format(endDate_dt);
            String formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();				
            String formattedEndYear = fYear.format(endDate_dt);
			/*forenabling the div */
	                    String id_drug= drugCode.replaceAll("[-+.^:,]","");
	                    String trad="T";
		                if(!tradeName.equalsIgnoreCase(""))
		                {	
		                 trad=tradeName;
		                }	 
	                    String id_trad= trad.replaceAll("[-+.^:,]","");	
                        id_drugName_tradeName=id_drug+"_"+id_trad;		
	  
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block88Bytes, _wl_block88);
 if(!tradeName.equalsIgnoreCase(""))
					 {
					 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tradeName));
            _bw.write(_wl_block53Bytes, _wl_block53);

					 }
				 	
            _bw.write(_wl_block89Bytes, _wl_block89);
 if(calc_dose_based_on.equals("B")){
						ori_dosage_type="Q";
					  }
            _bw.write(_wl_block90Bytes, _wl_block90);
 if (ori_dosage_type.equals("Q")) {
							if (calc_dose_based_on.equals("B")) {
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(calc_dose_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pres_qty_uom));
            _bw.write(_wl_block57Bytes, _wl_block57);
} else {
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(pres_qty_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(qty_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
}}
					if (ori_dosage_type.equals("S")) {
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(qty_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block92Bytes, _wl_block92);

			      HashMap FluidDetails = bean_IVPB.getFluidDetails();
	              if(FluidDetails.isEmpty()){
	            	  
	            	  drugMandatoryWarning = "Y";
	  					cartErrorExists = true;		           
	              
            _bw.write(_wl_block93Bytes, _wl_block93);

	              }else{
	            	String fluid_drug_desc = (String)FluidDetails.get("DRUG_DESC");
	            	String fluid_qty_uom_desc = (String)FluidDetails.get("PRES_BASE_UOM_DESC");
					 fluid_qty_uom_desc = bean.getUomDisplay(facility_id,fluid_qty_uom_desc);
					 if(fluid_qty_uom_desc.equalsIgnoreCase("")||fluid_qty_uom_desc==null){
							
							fluid_qty_uom_desc = (String)FluidDetails.get("PRES_BASE_UOM_DESC");
						}
						
						FluidDetails.put("PRES_BASE_UOM_DESC",fluid_qty_uom_desc);
	          		String fluid_qty_uom = (String)FluidDetails.get("QTY_UOM");
	          		String fluid_qty_value = (String)FluidDetails.get("QTY_VALUE");
	          		String fluid_tradeName = (String)FluidDetails.get("TRADE_NAME")==null?"":(String)FluidDetails.get("TRADE_NAME");
					String infusion_over = bean_IVPB.getINFUSE_OVER();
					String INFUSION_PERIOD_VALUE = (String)FluidDetails.get("INFUSION_PERIOD_VALUE");					
					String INFUSION_PERIOD_VALUE_MIN = (String)FluidDetails.get("INFUSION_PERIOD_VALUE_MIN");					
					String 	inf_over_displaystr = INFUSION_PERIOD_VALUE+" Hrs "+INFUSION_PERIOD_VALUE_MIN+" Mins";				
					if(infusion_over.equals("")){
						infusion_over = "0";
					}
					float infusion_over_fl = Float.parseFloat(infusion_over);					
					if(infusion_over_fl==0){
						drugMandatoryWarning = "Y";
						cartErrorExists = true;
					}
				  
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(fluid_drug_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(fluid_qty_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fluid_qty_uom_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(inf_over_displaystr ));
            _bw.write(_wl_block96Bytes, _wl_block96);

				  }
				  
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(formattedStartDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(formattedStartMonth));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(formattedStartYear));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(formattedEndDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(formattedEndMonth));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(formattedEndYear));
            _bw.write(_wl_block98Bytes, _wl_block98);

				  if(drugMandatoryWarning.equalsIgnoreCase("Y")){ 
				 
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block100Bytes, _wl_block100);

				 }
				 
            _bw.write(_wl_block101Bytes, _wl_block101);

	  }
	  
            _bw.write(_wl_block102Bytes, _wl_block102);

   }
   drugDetails =  bean_CRX.getDrugDetails();		
   if(drugDetails.size()>0){
	String drugMandatoryWarning = "N";
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");		
	String start_date_fluid="";
	String end_date_fluid="";
   
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(drugDetails.size() ));
            _bw.write(_wl_block107Bytes, _wl_block107);

					ArrayList freqValues = (ArrayList) bean_CRX.loadFrequency();
					String bl_patient_payable = "";
					String bl_charge_amt = "";
					float patient_payable = 0;
					float total_charge = 0;
					String freqDuration = "";
					String durnType = "";
					String interval_value = "";
					String freq_desc = "";
					String dosageval = "";
					String dosageuom = "";
					String ordered_qty = "";
					String qty_unit = "";
					String eqvl_value = "";
					String ing_order_uom = "";
					String qty_value = "";
					String freq_code = bean_CRX.getFREQ_CODE();
					String bl_install_yn = orbean.getBillingInterfaceYn() == null ? "" : orbean.getBillingInterfaceYn();
					ArrayList param_vals = bean.getParameterValues();
					String bl_disp_charge_dtl_in_rx_yn = (String) param_vals.get(2);
					String pack_size = "";
					String durn_value = "";
					String bl_decimal_format_string = "#0.00";
					DecimalFormat dfTest = dfTest = new DecimalFormat(bl_decimal_format_string);
					durn_value = request.getParameter("durn_value") == null ? "" : request.getParameter("durn_value");
					for (int c = 0; c < drugDetails.size(); c++) {
						HashMap drugDetail = (HashMap) drugDetails.get(c);
						String allergy_yn = (String) drugDetail.get("ALLERGY_YN") == null ? "N" : (String) drugDetail.get("ALLERGY_YN");
						if (allergy_yn.equals("Y")) {
							String allergy_remarks = (String) drugDetail.get("ALLERGY_REMARKS") == null ? "" : (String) drugDetail.get("ALLERGY_REMARKS");
							if (allergy_remarks.equals("")) {
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						}
						String doseOverride = (String) drugDetail.get("DOSE_OVERRIDE") == null ? "N" : (String) drugDetail.get("DOSE_OVERRIDE");
						if (doseOverride.equals("Y")) {
							String doseRemark = (String) drugDetail.get("DOSE_REMARKS") == null ? "" : (String) drugDetail.get("DOSE_REMARKS");
							if (doseRemark.equals("")) {
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						}

						String currentRx = (String) drugDetail.get("CURRENT_RX") == null ? "N" : (String) drugDetail.get("CURRENT_RX");
						if (currentRx.equals("Y")) {
							String currentRemark = (String) drugDetail.get("CURRENTRX_REMARKS") == null ? "" : (String) drugDetail.get("CURRENTRX_REMARKS");
							if (currentRemark.equals("")) {
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						}

						start_date_fluid = (String) drugDetail.get("START_DATE") == null ? "" : (String) drugDetail.get("START_DATE");
						end_date_fluid = (String) drugDetail.get("END_DATE") == null ? "" : (String) drugDetail.get("END_DATE");
						double iOrdQty = 0;
						String drugDesc = (String) drugDetail.get("DRUG_DESC") == null ? "" : (String) drugDetail.get("DRUG_DESC");
						String drugCode = (String) drugDetail.get("DRUG_CODE") == null ? "" : (String) drugDetail.get("DRUG_CODE");
						pack_size = bean_CRX.getPackSize(drugCode);
						String tradeName = (String) drugDetail.get("TRADE_NAME") == null ? "" : (String) drugDetail.get("TRADE_NAME");

						freqDuration = (String) drugDetail.get("DURN_VALUE") == null ? "" : (String) drugDetail.get("DURN_VALUE");
						if (freqDuration.equals("0")) {
							freqDuration = "1";
						}
						durnType = (String) drugDetail.get("DURN_TYPE") == null ? "" : (String) drugDetail.get("DURN_TYPE");
						
						qty_value = (String) drugDetail.get("ORDER_QTY");						
						if (qty_value == null || qty_value.equals(""))
							qty_value = "0";					
						
						float ing_unit_qty = Float.parseFloat(qty_value);
						
						String freqValue = (String) drugDetail.get("FREQ_VALUE") == null ? "" : (String) drugDetail.get("FREQ_VALUE");
						bl_decimal_format_string = (String) drugDetail.get("BL_DECIMAL_FORMAT_STRING") == null ? "#0" : (String) drugDetail.get("BL_DECIMAL_FORMAT_STRING");
						String freq_nature = (String) drugDetail.get("FREQ_NATURE") == null ? "" : (String) drugDetail.get("FREQ_NATURE");
						interval_value = (String) drugDetail.get("INTERVAL_VALUE") == null ? "" : (String) drugDetail.get("INTERVAL_VALUE");
						String srlNo = (String) drugDetail.get("SRL_NO") == null ? "" : (String) drugDetail.get("SRL_NO");
						String dosage_type = (String) drugDetail.get("DOSAGE_TYPE") == null ? "" : (String) drugDetail.get("DOSAGE_TYPE");
						String qtyDesc = (String) drugDetail.get("QTY_DESC") == null ? "" : (String) drugDetail.get("QTY_DESC");
						String absDesc = (String) drugDetail.get("PRES_BASE_UOM_DESC") == null ? "" : (String) drugDetail.get("PRES_BASE_UOM_DESC");
						String formDesc = (String) drugDetail.get("FORM_DESC") == null ? "" : (String) drugDetail.get("FORM_DESC");
						String qtyVal = (String) drugDetail.get("QTY_VALUE") == null ? "" : (String) drugDetail.get("QTY_VALUE");
						String totalqty = (String) drugDetail.get("TOTAL_QTY") == null ? "" : (String) drugDetail.get("TOTAL_QTY");
						String orderqty = (String) drugDetail.get("ORDER_QTY") == null ? "" : (String) drugDetail.get("ORDER_QTY");
						String pres_by = (String) drugDetail.get("PRES_BY_BASE") == null ? "" : (String) drugDetail.get("PRES_BY_BASE");
						dosageval = (String) drugDetail.get("DOSAGE_VALUE") == null ? "" : (String) drugDetail.get("DOSAGE_VALUE");
						dosageuom = (String) drugDetail.get("DOSAGE_UOM") == null ? "" : (String) drugDetail.get("DOSAGE_UOM");
						durn_value = (String) drugDetail.get("DURN_VALUE") == null ? "" : (String) drugDetail.get("DURN_VALUE");
						
						String item_code = (String) drugDetail.get("ITEM_CODE") == null ? "" : (String) drugDetail.get("ITEM_CODE");
						String fract_dose = (String) drugDetail.get("FRACT_DOSE_ROUND_UP_YN") == null ? "" : (String) drugDetail.get("FRACT_DOSE_ROUND_UP_YN");
						String strength_per_value_pres_uom = (String) drugDetail.get("STRENGTH_PER_VALUE_PRES_UOM") == null ? "" : (String) drugDetail.get("STRENGTH_PER_VALUE_PRES_UOM");
						String strength_per_pres_uom = (String) drugDetail.get("STRENGTH_PER_PRES_UOM") == null ? "" : (String) drugDetail.get("STRENGTH_PER_PRES_UOM");
						String amend_repeat_value = (String) drugDetail.get("amend_repeat_value") == null ? "" : (String) drugDetail.get("amend_repeat_value");
						if (amend_repeat_value.equals(""))
							amend_repeat_value = (String) drugDetail.get("REPEAT_VALUE") == null ? "1" : (String) drugDetail.get("REPEAT_VALUE");
						String amend_durn_value = (String) drugDetail.get("amend_durn_value") == null ? "" : (String) drugDetail.get("amend_durn_value");
						if (amend_durn_value.equals(""))
							amend_durn_value = (String) drugDetail.get("DURN_VALUE") == null ? "" : (String) drugDetail.get("DURN_VALUE");
						if (item_code.equals("")) {
							item_code = (String) drugDetail.get("ORDER_CATALOG_CODE");
						}

						float in_tot_qty = 0.0f;						
						if (dosage_type != null) {
							if (dosage_type.equals("S")) {
								in_tot_qty = 0.0f;
								if (fract_dose.equals("Y")) {
									in_tot_qty = new Double(Math.ceil(ing_unit_qty / Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
								} else {
									in_tot_qty = new Double(Math.ceil(ing_unit_qty / Float.parseFloat(strength_per_pres_uom) * Float.parseFloat(strength_per_value_pres_uom))).floatValue();
								}								
								if (freq_nature.equals("I")) {
									in_tot_qty = in_tot_qty * (Float.parseFloat(durn_value)) * (24 / (Float.parseFloat(interval_value)));
								} else if (freq_nature.equals("F") || freq_nature.equals("C")) {
									in_tot_qty = in_tot_qty * (Float.parseFloat(amend_repeat_value)) * (Float.parseFloat(amend_durn_value));
								} else if (freq_nature.equals("O")) {
									in_tot_qty = in_tot_qty;
								}
								ordered_qty = in_tot_qty + "";
								ordered_qty = (Math.ceil(Float.parseFloat(ordered_qty) / Float.parseFloat(pack_size))) + "";
							} else {
								qty_unit = (String) drugDetail.get("QTY_DESC_CODE");
								ing_order_uom = (String) drugDetail.get("PRES_BASE_UOM");
								eqvl_value = bean_CRX.getConvFactor(ing_order_uom, qty_unit);
								if (eqvl_value.equals("")) eqvl_value = "1";
								in_tot_qty = 0.0f;
								if (fract_dose.equals("Y")) {
									in_tot_qty = new Double(Math.ceil(ing_unit_qty / (Float.parseFloat(pack_size)))).floatValue() * Float.parseFloat(eqvl_value);
								} else {
									in_tot_qty = ing_unit_qty * Float.parseFloat(eqvl_value);
								}

								if (freq_nature.equals("I")) {
									in_tot_qty = in_tot_qty * (Float.parseFloat(durn_value)) * (24 / (Float.parseFloat(interval_value)));
								} else if (freq_nature.equals("F") || freq_nature.equals("C")) {
									in_tot_qty = in_tot_qty * (Float.parseFloat(amend_repeat_value)) * (Float.parseFloat(amend_durn_value));
								} else if (freq_nature.equals("O")) {
									in_tot_qty = in_tot_qty;
								}

								if (!fract_dose.equals("Y")) {
									in_tot_qty = new Double(Math.ceil((in_tot_qty) / Float.parseFloat(pack_size))).floatValue();
								}
								ordered_qty = in_tot_qty + "";
							}
						}
						drugDetail.put("ORDERED_QTY", ordered_qty);
						
						bean_CRX.setBillingDetail(drugDetail, episode_type, patient_id, encounter_id, item_code, ordered_qty, take_home_medication);
						String billable_item_yn = (String) drugDetail.get("BILLABLE_ITEM_YN") == null ? "" : (String) drugDetail.get("BILLABLE_ITEM_YN");
						String in_formulary_yn = (String) drugDetail.get("IN_FORMULARY_YN") == null ? "" : (String) drugDetail.get("IN_FORMULARY_YN");

						if (bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y") && billable_item_yn.equals("Y")) {
							bl_charge_amt = (String) drugDetail.get("BL_CHARGE_AMT") == null ? "0.0" : (String) drugDetail.get("BL_CHARGE_AMT");
							bl_patient_payable = (String) drugDetail.get("BL_PATIENT_PAYABLE") == null ? "0.0" : (String) drugDetail.get("BL_PATIENT_PAYABLE");
							//patient_payable = (String) drugDetail.get("BL_PATIENT_PAYABLE_AMT")==null?"0":(String)drugDetail.get("BL_PATIENT_PAYABLE_AMT");
							//total_charge =(String)drugDetail.get("BL_TOTAL_CHARGE_AMT")==null?"0":(String)drugDetail.get("BL_TOTAL_CHARGE_AMT");
							
							if (!bl_patient_payable.equals(""))
								patient_payable += Float.parseFloat(bl_patient_payable);
							if (!bl_charge_amt.equals(""))
								total_charge += Float.parseFloat(bl_charge_amt);
						} else {
							bl_charge_amt = "0";
							bl_patient_payable = "0";
						}

						all_total_charge_fl += Float.parseFloat(bl_charge_amt);
						all_patient_payable_fl += Float.parseFloat(bl_patient_payable);

						if (orderqty == null)
							orderqty = "";
						orderqty = orderqty.equals("") ? "0" : orderqty;
						iOrdQty = Math.ceil(Float.parseFloat(orderqty));

						if (drugMandatoryWarning.equals("N") && (orderqty.equals("") || dosageval.equals("") || durn_value.equals("") || freq_code.equals(""))) {
							drugMandatoryWarning = "Y";
							cartErrorExists = true;
						}
						if (drugMandatoryWarning.equals("N") && (pres_by.equals("R") || pres_by.equals("P")) && totalqty.equals("")) {
							drugMandatoryWarning = "Y";
							cartErrorExists = true;
						}
						if (drugMandatoryWarning.equals("N") && pres_by.equals("P") && totalqty.equals("")) {
							drugMandatoryWarning = "Y";
							cartErrorExists = true;
						}

						String id_drug = drugCode.replaceAll("[-+.^:,]", "");
						String trad = "T";
						if (!tradeName.equalsIgnoreCase(""))
							trad = tradeName;
						String id_trad = trad.replaceAll("[-+.^:,]", "");
						id_drugName_tradeName = id_drug + "_" + id_trad;
					
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(drugDesc));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(drugCode));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block112Bytes, _wl_block112);
					
                    }
					if(start_date_fluid.equals(""))
						 start_date_fluid=bean_CRX.getSysdate();
					//System.out.println("freqDuration: "+freqDuration); 
					if(end_date_fluid.equals(""))	
						end_date_fluid	=  bean_CRX.populateEndDate(start_date_fluid,freqDuration,durnType);
					
                    				
						
					DateFormat fMonth = new SimpleDateFormat("MMM");
					DateFormat fDate = new SimpleDateFormat("dd");
					DateFormat fYear = new SimpleDateFormat("yyyy");
					Date startDate_dt = df.parse(start_date_fluid);
					Date endDate_dt = df.parse(end_date_fluid);
					String formattedStartDate = fDate.format(startDate_dt);		
					String formattedStartMonthSmallCase = fMonth.format(startDate_dt);
					String formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
					String formattedStartYear = fYear.format(startDate_dt);
					String formattedEndDate = fDate.format(endDate_dt);		
					String formattedEndMonthSmallCase = fMonth.format(endDate_dt);
					String formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();				
					String formattedEndYear = fYear.format(endDate_dt);						
					String 	dosandfreq= dosageval+dosageuom;
					
					if(freqValues!=null && freqValues.size()>0){
					for (int i=0;i<freqValues.size();i+=2){                   						
						if(freq_code.equals((String)freqValues.get(i)))
						{
							freq_desc=(String)freqValues.get(i+1);
							break;
						}				
					}					
					}		
					if(dosandfreq.equals(""))
						dosandfreq=freq_desc;
					else
						dosandfreq=dosandfreq + " - " + freq_desc;	
					
				    
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(dosandfreq));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(formattedStartDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(formattedStartMonth ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(formattedStartYear ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(formattedEndDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(formattedEndMonth));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(formattedEndYear));
            _bw.write(_wl_block115Bytes, _wl_block115);
if(patient_payable!=0 || total_charge!=0) {
						String patient_payable_str = dfTest.format(patient_payable);
						String total_charge_str = dfTest.format(total_charge);
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(total_charge_str));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_payable_str ));
            _bw.write(_wl_block116Bytes, _wl_block116);
}else{ 
            _bw.write(_wl_block117Bytes, _wl_block117);
} 
            _bw.write(_wl_block118Bytes, _wl_block118);
if(drugMandatoryWarning.equalsIgnoreCase("Y")){
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block120Bytes, _wl_block120);
}
            _bw.write(_wl_block121Bytes, _wl_block121);

    }
   
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(cartErrorExists ));
            _bw.write(_wl_block123Bytes, _wl_block123);

  }else{

            _bw.write(_wl_block124Bytes, _wl_block124);

 }

            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(rx_patient_payable_fl ));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(rx_total_charge_fl ));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(all_patient_payable_fl ));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(all_total_charge_fl ));
            _bw.write(_wl_block129Bytes, _wl_block129);

}
catch(Exception ex){
	System.out.println(ex.getMessage());
	ex.printStackTrace();
}
}

            _bw.write(_wl_block130Bytes, _wl_block130);
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
