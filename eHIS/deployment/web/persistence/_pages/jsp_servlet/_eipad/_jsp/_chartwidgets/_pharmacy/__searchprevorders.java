package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.PrescriptionBean;
import ePH.IVPrescriptionBean;
import eIPAD.chartsummary.clinicalnotes.healthobject.NotesData;
import eIPAD.HealthObjects.Notes;
import java.util.ArrayList;
import java.text.DateFormat;
import com.ehis.persist.PersistenceHelper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eOR.ExistingOrder;
import ePH.DrugSearchBean;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import ePH.PrescriptionBean_1;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public final class __searchprevorders extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/SearchPrevOrders.jsp", 1709118022162L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/iPadPharmaColumLayout.css\" />\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" /> \t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<div id=\"OrdListHWrapper_";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" style=\"position: relative; height:100%; width: 100%; overflow: hidden;\" class=\"ordListHWrapper table\">\t\t \t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<div style=\"position:absolute; width: auto; height: 100%;\" id=\"OrdItemscroller_";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<ul id=\"OrdListColWrap_";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" class=\"ordListColWrap row\" style=\"height: 100%; margin-top: 0px; padding-left: 0px;\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<li>\n\t\t<div  id=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" \n\t\tdata-currentid=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  \n\t\tdata-drugCodeUnique=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" \n\t\tdata-drugname=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" \n\t\tdata-drugtypecode=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" \n\t\tdata-drugcodesall=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" \n\t\tdata-drugUniqueall=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"\n\t\tdata-previous=\"po\"\n\t\tdata-drugCode=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" \n\t\tdata-orderId=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" \n\t\tdata-drugtypedesc=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" \n\t\tdata-tradeCodes=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" \n\t\tdata-tradeName=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"\n\t\tdata-ivrxispresent=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" \n\t\tdata-priority=\"R\"\n\t\tdata-rxpos=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" \n\t\tdata-ordercatcode=\"\" \n\t\tdata-previligegroupdrugordering_yn=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"\n\t\tdata-diagnosis_found_yn=\"\" \n\t\tdata-appl_for_age_grp_yn=\"\" \n\t\tdata-in_formulary=\"\" \n\t\tdata-drug_class=\"\" \n\t\tdata-stock_yn=\"\" \n\t\tdata-allow_yn=\"\" \n\t\tdata-avl_qty=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\n\t\tclass=\"rxBuble rxBubleSlotOne rxBubleTable ordDraggable_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t<div class=\"rxBubleRow\">\n\t\t\t    <div class=\"rxBubleCellContentDesc\">\n\t\t\t\t   <div class=\"rxBubleCellContent\">\n\t\t\t\t\t\t<div class=\"rxBubleLable\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</div>\n\t\t\t\t\t\t<div class=\"rxBubleLableDrugFreq\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"rxBubleCellContentTime\">\n\t\t\t\t <div id=\"div2\" class=\"drugDateDataWrapper\">\n\t\t\t    <div id=\"footerWrapper\" style=\"width:100%;padding-left: 3px;\">\n\t\t\t\t<div class=\"rxBubleCellContentBubble\">\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<div class=\"rxBubleCellStatusCheck ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" ></div>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<div class=\"rxBubleCellBubbleContent\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"rxBubleCellContentType\">\n\t\t\t\t<span class=\"rxBubleDrugType\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</span>\n\t\t\t\t</div>\t\t\t\t\n\t\t\t\t  <div class=\"table\" style=\"width:52px;float:right;\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t   <span>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</span>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t    <div class=\"cell startMonthStyleWrapper\">\n\t\t\t\t\t\t  <div class=\"table startMonthStyle\">\n                             <div class=\"row\"> \t\t\t\t\t\t  \n\t\t\t\t\t            <div class=\"cell startMonthCellCss\">\n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t         </div>\n\t\t\t\t\t\t\t <div class=\"row\">\n \t\t\t\t\t\t\t    <div class=\"cell startYearCellCss\">\n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t        </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n                 </div>\t\t\t\t\t \n\t\t\t\t <div  style=\"float:right;width:17px;\" class=\"table\">\n                    <div class=\"row\">\n\t\t\t\t\t  <div class=\"cell toStyleCssPrevOrders\">to</div>\n\t\t\t\t\t</div>\n                 </div>\t\t\t\t \n\t\t\t\t <div class=\"table\" style=\"width:52px;float:right;\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t  <span>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t         </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n                 </div>\t\t\t\t\t \n\t\t\t\t <div style=\"clear: both;\"></div>\n\t\t\t\t</div>\n\t\t\t  </div>\n\t\t\t</div>\n\t\t\t\t   ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t<div class=\"rxBubleCellIconInStock\"><img src=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="/eIPAD/images/Drag25x25.png\"></div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t<div class=\"rxBubleCellIconOutStock\"><img src=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t</div>\n\t\t</div>\n    </li>\n     ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\n\t\t<li>\n\t\t<div  id=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"\n\t\tdata-drugUniqueall=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" \n\t\tdata-durgDesp=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" \n\t\t\n\t\tdata-tradeCodes=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"\n\t\tdata-avl_qty=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"\n\t\t\n\t\tclass=\"rxBuble rxBubleSlotTwo rxBubleTable ordDraggable_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t<div class=\"rxBubleRow\">\t\t\t\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\t\n\t\t\t\t<div class=\"rxBubleCellContentDesc\">\n\t\t\t\t   <div class=\"rxBubleCellContent\">\n\t\t\t\t\t<div class=\"rxBubleLable\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</div>\n\t\t\t\t\t<div class=\"rxBubleLableDrugFreq\"> \n\t\t\t\t\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t</div>\n                </div>\t\t\t\t\t\n\t\t\t\t</div>\t\t\t\t\n\t\t\t\t<div class=\"drugItemSeperator\">\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="/eIPAD/images/FluidAdditiveDiff.PNG\">\n\t\t\t\t</div>\n\t\t\t\t <div class=\"rxBubleCellContentDesc\">\n\t\t\t\t   <div class=\"rxBubleCellContent\">\n\t\t\t\t\t<div class=\"rxBubleLable\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</div>\n\t\t\t\t\t<div class=\"rxBubleLableDrugFreq\"> \n\t\t\t\t\t  ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t</div>\n                </div>\t\t\t\t\t\n\t\t\t\t</div>\t\t\t\t\n\t\t\t\t<div class=\"rxBubleCellContentTime\">\n\t\t\t\t <div id=\"div2\" class=\"drugDateDataWrapper\">\n\t\t\t    <div id=\"footerWrapper\" style=\"width:100%;padding-left: 3px;\">\n\t\t\t\t<div class=\"rxBubleCellContentBubble\">\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\t\t\t\n\t\t\t\t\t<div class=\"rxBubleCellStatusCheck ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" ></div>\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"rxBubleCellContentType\" style=\"width:59px;\">\n\t\t\t\t<span  style=\"width:59px;\" class=\"rxBubleDrugType\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</span>\n\t\t\t\t</div>\t \n                 <div class=\"table drugDateContainer\" style=\"width:54px;float:right;\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t   <span>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t        </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n                 </div>\t\t\t\t\t \n\t\t\t\t <div  style=\"float:right;\" class=\"table toStylingWrapper\">\n                    <div class=\"row\">\n\t\t\t\t\t  <div class=\"cell toStyleCssPrevOrders\">to</div>\n\t\t\t\t\t</div>\n                 </div>\t\t\t\t \n\t\t\t\t <div class=\"table drugDateContainer\" style=\"width:52px;float:right;\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t  <span>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t         </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n                 </div>\t\n\t\t\t\t \n\t\t\t\t <div style=\"clear: both;\"></div>\n\t\t\t\t</div>\n\t\t\t  </div>\n\t\t\t</div>\n\t\t\t\t   ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t</div>\n\t\t</div>\n    </li>\t\n    ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t<li>\n\t\t\t<div  id=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" \n\t\t\n\t\tdata-drugCode=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"\n\t\tdata-previous=\"po\"\n\t\tdata-tradeCodes=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"\n\t\t\tclass=\"rxBuble  rxBubleTable ordDraggable_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t<div class=\"rxBubleRow\"> ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\t\t\n\t\t\t<div class=\"rxBubleCellContentDesc\">\n\t\t\t\t<div class=\"rxBubleCellContent\">\n\t\t\t\t\t<div class=\"rxBubleLable\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</div>\n\t\t\t\t\t<div class=\"rxBubleLableDrugFreq\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</div>\n\t\t\t\t</div>\n\t\t\t</div>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<div class=\"drugItemSeperator\">\t<img src=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="/eIPAD/images/FluidAdditiveDiff.PNG\"></div>\n\t\t\t\t<div class=\"rxBubleCellContentDesc\">\n\t\t\t\t\t<div class=\"rxBubleCellContent\">\n\t\t\t\t\t\t<div class=\"rxBubleLable\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" \n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t<div class=\"rxBubleCellContentDesc\">\n\t\t\t\t<div class=\"rxBubleCellContent\">\n\t\t\t\t\t<div class=\"rxBubleLable\">";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t<div class=\"drugItemSeperator\">\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="/eIPAD/images/MoreIVWA.PNG\">\n\t\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t<div class=\"drugItemSeperator\">\t<img src=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="/eIPAD/images/FluidAdditiveDiff.PNG\"></div>\n\t\t\t<div class=\"rxBubleCellContentDesc\">\n\t\t\t\t<div class=\"rxBubleCellContent\">\n\t\t\t\t\t<div class=\"rxBubleLable\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t</div>\t\t\t\n\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\t\t\t\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t<div class=\"rxBubleCellContentTime\">\n\t\t\t<div id=\"div2\" class=\"drugDateDataWrapper\">\n\t\t\t    <div id=\"footerWrapper\" style=\"width:100%;padding-left: 3px;\">\n\t\t\t\t<div class=\"rxBubleCellContentBubble\">\n\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" ></div>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"rxBubleCellContentType\">\n\t\t\t\t<span style=\"\" class=\"rxBubleDrugType\">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</span>\n\t\t\t\t</div>\t\t\t\t\n\t\t\t\t <div class=\"table drugDateContainer\" style=\"width:54px;float:right;\"> \n                     <div class=\"row\">\n\t\t\t\t\t    <div class=\"cell drugStartDateStyle\">\n\t\t\t\t\t\t   <span>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t</div>\n\t\t</div>\n    </li>\t\n\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\n\t\t\t\n\t\t\t<li>\n\t\t\t<div  id=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" \n\t\tdata-priority=\"R\"\n\t\tdata-ordercatcode=\"\" \n\t\tdata-previligegroupdrugordering_yn=\"\"\n\t\tdata-diagnosis_found_yn=\"\" \n\t\tdata-appl_for_age_grp_yn=\"\" \n\t\tdata-in_formulary=\"\" \n\t\tdata-drug_class=\"\" \n\t\tdata-stock_yn=\"\" \n\t\tdata-allow_yn=\"\" \n\t\tdata-avl_qty=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"\n\t\t\n\t\t\n\t\tclass=\"rxBuble rxBubleSlotOne rxBubleTable ordDraggable_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t<div class=\"rxBubleRow\">\n\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t   \n\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t    <div class=\"rxBubleCellContentCrx\">\n\t\t\t   <div class=\"rxBubleCellContentDtl\">\n\t\t\t\t\t<div class=\"rxBubleLable\">";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</div>\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t<div class=\"drugItemSeperator\">\n\t\t\t\t <img src=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="/eIPAD/images/MoreIVWA.PNG\">\n\t\t\t\t</div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\n\t\t\t<div class=\"rxBubleLableDrugFreqCrx\">";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</div>\n\t\t\t\n\t\t\t\n\t\t\t<div class=\"rxBubleCellContentTime\">\n\t\t\t\t <div id=\"div2\" class=\"drugDateDataWrapper\">\n\t\t\t    <div id=\"footerWrapper\" style=\"width:100%;padding-left: 3px;\">\n\t\t\t\t<div class=\"rxBubleCellContentBubble\">\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t         </div>\n\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t </div>\n                 </div>\t\t\t\t\t \n\t\t\t\t <div style=\"clear: both;\"></div>\n\t\t\t\t</div>\n\t\t\t  </div>\n\t\t\t</div>\n\t\t\t\n\t\t\t\n\t\t\n\t\t\t<div class=\"rxBubleCellIconOutStock\"><img src=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="/eIPAD/images/Drag25x25.png\"></div>\n\t\t\t\n\t\t\t</div>\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t </div>\n\t\t    </li>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t</ul>\n\t</div>\n\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n    <div id=\"noPrevOreders\" class=\"table\" style=\"width:100%;height:99%;background:#edf1f3;\" data-role = \"none\">\n\t\t<div class=\"pharmEmptyData\">\n\t\t  No previous orders available\n\t\t</div>\n\t</div>\n\t<input type=\"hidden\" name=\"hdnPrevOrderSize\" id=\"hdnPrevOrderSize\" id=\"hdnPrevOrderSize\" value=\"0\" />\n\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\t\n\t</div>\t\n<script src=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="/eIPAD/js/PharamaColumnLayout.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="/eIPAD/js/lib/kendo/kendo.all.min.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="/eIPAD/css/kendo/kendo.common.min.css\" />\n<script>\n    $(document).ready(function() {\n        var checkForRec = $(\'#no_record\').val();\n        if (checkForRec != \'no\') \n\t\t{\t\t\n            var ordListColWrap = $(\'#\' + \"OrdListColWrap_A\");\n            var ordListColParent = ordListColWrap.parent();\n           var ordListColItems1 = ordListColWrap.children();         \n           onOriChange();\t\n\t\t   setTimeout(function() {\n          // assignOrdItemsHScroll_S();\n           //dragAndDrop();\n            }, 500);         \t\t   \n            $(\'#no_record\').val(\"\");\n        }    }); \n</script>\n</html>\n\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);

String orderNature="A";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(orderNature));
            _bw.write(_wl_block7Bytes, _wl_block7);

PatContext patientContextInsit = (PatContext)session.getAttribute("PatientContext"); 
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");		
		String patient_id	=	patientContextInsit.getPatientId();
		String encounter_id	=	patientContextInsit.getEncounterId();	
		String facility_id = patientContextInsit.getFacilityId();
		String EO_beanid		=	"@existingorderbean"+patient_id+encounter_id;
		String EO_beanname		=	"eOR.ExistingOrder";
		String previousOrderStr="";
		int orSize=0;
		ExistingOrder EO_bean	= (ExistingOrder)PersistenceHelper.getBeanObject( EO_beanid,EO_beanname,request );				
		String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name			= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 Pres_bean= (PrescriptionBean_1)PersistenceHelper.getBeanObject( bean_id,bean_name,request);			
		
		String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
		String presBean_name		= "ePH.PrescriptionBean";	
		PrescriptionBean presBean = (PrescriptionBean)PersistenceHelper.getBeanObject( presBean_id,presBean_name,request);   
		
		
		ArrayList allValues	=	new ArrayList();				
		Pres_bean.setLanguageId(locale);
		Properties properties	= (Properties) session.getValue("jdbc");					
		String curr_sys_date	= "";		
		ArrayList sysdate = (ArrayList)EO_bean.getSysDateTime(properties);
		for(int i=0;i<sysdate.size();i++){
			curr_sys_date	= (String)sysdate.get(0);
		}	
		
		String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+patient_id+encounter_id;
		String bean_name_IVPB	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
	Calendar calendar = Calendar.getInstance();		
	String order_to=sdf.format(sdf.parse(curr_sys_date));	
	calendar.setTime(sdf.parse(curr_sys_date));	
	calendar.add(Calendar.MONTH, -2);	
	String order_from=sdf.format(calendar.getTime());
	String pat_class="B";
	String ord_status		= "A";
	String pract_id="";	
	String from="";
	String to="1000";
	String drug_desc="";
	String group_by="PR";
	String drug_priv_appln_yn="Y";
	String resp_id=patientContextInsit.getResponsibilityID();
	String 	log_pract_id=patientContextInsit.getClinicianId();
	String avl_qty="";
	HashMap total_result	= Pres_bean.getPreviousOrders(pat_class,pract_id,patient_id,ord_status,order_from,order_to,from,to,drug_desc,group_by,drug_priv_appln_yn,resp_id, log_pract_id);	
	allValues		=	(ArrayList)total_result.get("RESULT");	
    String DrugSearchbean_id 			= "@DrugSearchBean"+patient_id+encounter_id;
	String	DrugSearchbean_name			=	"ePH.DrugSearchBean";	
	DrugSearchBean DrugSearchbean = (DrugSearchBean)PersistenceHelper.getBeanObject(DrugSearchbean_id, DrugSearchbean_name, request ) ;
	ArrayList drug_dtls =	null;
	ArrayList stock_dtls	=	null;
	String strFluidName="";
	String strdrug_CompleteDetails="";	
	if (allValues.size()>=2) 
	{
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block10Bytes, _wl_block10);
	
		String previousorder_id="";	    
		int count=0;
		String nextOrder="";
		int nextOrderidPosition=0;
		String orders_id_rx="";
		int orders_id_rx_pos=0;
		String checkForStock="";
		for(int i=0; i<allValues.size(); i+=22) 
			{				
				String trade_code="";
				count=count+1;
				nextOrderidPosition=count*23+2;
				if((nextOrderidPosition)>allValues.size()){//2 is order ID position
					nextOrder="";
				}
				else
				{
					nextOrder=(String)allValues.get(nextOrderidPosition);			
				}
				if(i==0)
					++i;								
				String orderStatus=(String)allValues.get(i);
				String cClassName="";
				if(orderStatus.equals("CN"))
					cClassName="rxBubleCellStatusCheckCancel";
				else if(orderStatus.equals("DC"))
					cClassName="rxBubleCellStatusCheckDiscontinued";
				else 
					cClassName="";
				String order_id = (String)allValues.get(i+1);
				Integer  order_line_no = Integer.parseInt((String)allValues.get(i+2));
				String drug_code = (String)allValues.get(i+3);
				//System.out.println("drug_code--------------------->"+drug_code);
				ArrayList trades = new ArrayList();
				trades = presBean.getTrades(drug_code); 
				String default_tradeName = "";
				if(trades.size() > 0){
					default_tradeName = (String)trades.get(0);
					trade_code=(String)trades.get(0);
					//System.out.println("default_tradeName==>>"+default_tradeName);
				}
				
				String drug_name =(String)allValues.get(i+4);	
				String qty_uom, strength_value;
				strength_value = (String) allValues.get(i+5);
				
				if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) < 1)
					strength_value = Float.parseFloat(strength_value)+"";
				qty_uom = (String) allValues.get(i+6);
				if(qty_uom!=null && !qty_uom.equals(""))
					qty_uom = Pres_bean.getUomDisplay(facility_id,allValues.get(i+6).toString());
				String startDate =(String)allValues.get(i+12);
				String endDate =(String)allValues.get(i+13);
				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");	//TODO	
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
				String drugType ="";
				String drugTypeDesc ="";
				String drugTypeCode ="";
				String drugGenCat="";
				
				
				  
				   
				   
				drugType = (String)allValues.get(i+17);				
					if(drugType == null ||drugType.equals("")){
						drugTypeCode = "Rx";
						drugTypeDesc = "";
						drugGenCat="RX";
					}
                   else	if(drugType.equals("5")){
					   drugTypeCode = "IVWA";
					   drugTypeDesc ="WITHOUT ADDITIVES";	
					   drugGenCat="IV";
				   }
                   else	if(drugType.equals("6")){
					   drugTypeCode = "CRx";
					   drugTypeDesc ="COMPOUND RX";
					   drugGenCat="Crx";
				   }				   
                   else	if(drugType.equals("1") ||drugType.equals("2") ){
					   drugTypeCode = "IVD";
					   drugTypeDesc ="WITH ADDITIVES";	
					   drugGenCat="IV";
				   }
				   else	if(drugType.equals("3") ||drugType.equals("4") ){
					   drugTypeCode = "IVPB";
					   drugTypeDesc ="INTERMITTENT";
					   drugGenCat="IV";
				   }
					
					//strength_value = (String) allValues.get(i+5);
					
					
				String drug_CompleteDetails = strength_value+" "+qty_uom+" - "+allValues.get(i+8)+" For "+allValues.get(i+9)+" "+allValues.get(i+11);				
			    String id_drug= drug_code.replaceAll("[-+.^:,]","");						
                String trad="T";				
				String id_drugName_tradeName=id_drug+"_"+trad+i;
				String priv_appl_yn = (String)allValues.get(i+21);
				String order_ids= order_id.replaceAll("[-+.^:,]","");						
                String lineNum=(String)allValues.get(i+2);				
				String id_order_ids_lineNum=order_ids;	
				//String id_drug="T";				
				String ivrxIsPresent = request.getParameter("ivrxChk");
				
				drug_dtls	=	DrugSearchbean.getPreferredDrugDetails(drug_code);
				if(drug_dtls!=null && drug_dtls.size() > 0){
					trade_code=	(String)drug_dtls.get(3);
				}
				String drug_class="";
				avl_qty="";
				stock_dtls	= DrugSearchbean.checkStock(drug_code, trade_code, drug_class, "","","",patient_id,encounter_id);
				if(stock_dtls!=null && stock_dtls.size() > 0){
					avl_qty	=	(String)stock_dtls.get(1);
				}	
				
				 if(Float.parseFloat(avl_qty)>0){
					 if(!checkForStock.equals("out-stock"))
					 	checkForStock="in-stock";
				 }else{				 
					 checkForStock="out-stock";
				 }
				 System.out.println(drug_name + " Stock :  "+avl_qty + " checkForStock " + checkForStock);
	 if((drugTypeCode.equals("Rx")&& drugTypeDesc.equals(""))|| ivrxIsPresent.equals("Y") && drugTypeDesc.equals("WITHOUT ADDITIVES")){
		 
		 ArrayList exstngIVorder = 	iv_bean.getExistingIVRecords(order_id, "Y", "IP");//TODO -- change patient_class hardcoded
		
	  String	 drug_codesEX ="";
	  String drugCodeUniq="";
	  
	
		 for(int e=0;e<exstngIVorder.size();e++){
			 
			 HashMap extDrugList		=	(HashMap)exstngIVorder.get(e); 
			 String drug_codeex=	(String)extDrugList.get("ORDER_CATALOG_CODE")==null?"":(String)extDrugList.get("ORDER_CATALOG_CODE"); 
			 
			 
			 drug_codesEX +=drug_codeex+",";
			 drugCodeUniq+=drug_codeex.replaceAll("[-+.^:,]","")+",";
	
			 
		 }
	
		 if(exstngIVorder.size()>0){
			 drug_codesEX = drug_codesEX.substring(0, drug_codesEX.length()-1);
			 drugCodeUniq = drugCodeUniq.substring(0, drugCodeUniq.length()-1)+"";
		 }
		 
		 //orders_id_rx_pos
		 
		 if(!orders_id_rx.equals(order_ids)){
			 
			 orders_id_rx_pos=0;
			 
		 }
		 
		 orders_id_rx_pos= orders_id_rx_pos+1;
		 
		 id_order_ids_lineNum=order_ids+"_"+orders_id_rx_pos;
		 orders_id_rx=order_ids;
		 
		 drug_codesEX=drug_code;
		 drugCodeUniq=drug_code.replaceAll("[-+.^:,]","");
	 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drugTypeCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_codesEX));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(drugCodeUniq));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drugTypeDesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(default_tradeName));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ivrxIsPresent));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(orders_id_rx_pos));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(priv_appl_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(checkForStock));
            _bw.write(_wl_block27Bytes, _wl_block27);

		System.out.println("checkForStock KNs : " + checkForStock);
		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(drug_CompleteDetails));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(cClassName.length()>0){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cClassName));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drugGenCat));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drugTypeDesc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(formattedEndDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(formattedEndMonth));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(formattedEndYear));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(formattedStartDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(formattedStartMonth));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(formattedStartYear));
            _bw.write(_wl_block40Bytes, _wl_block40);

				     if(Float.parseFloat(avl_qty)>0){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
}
	else if(ivrxIsPresent.equals("Y") && drugTypeDesc.equals("INTERMITTENT")){		
		if(!previousorder_id.equals(order_id)) {
			strFluidName=drug_name;
			strdrug_CompleteDetails=drug_CompleteDetails;
			
		//	strength_value = (String) allValues.get(i+5);
		
		//System.out.println("(String) allValues.get(i+5)"+(String) allValues.get(i+5)+"(String) allValues.get(i+8)"+(String) allValues.get(i+8));
		
	//	System.out.println("drug_CompleteDetailsdrug_CompleteDetailsdrug_CompleteDetails::"+drug_CompleteDetails);
			
			ArrayList exstngIVorder = 	iv_bean.getExistingIVRecords(order_id, "Y", "IP");//TODO -- change patient_class hardcoded
			
			  String	 drug_codesEX ="";
			  String drugCodeUniq="";
				 for(int e=0;e<exstngIVorder.size();e++){
					 
					 HashMap extDrugList		=	(HashMap)exstngIVorder.get(e); 
					 String drug_codeex=	(String)extDrugList.get("ORDER_CATALOG_CODE")==null?"":(String)extDrugList.get("ORDER_CATALOG_CODE"); 
					
					 drug_codesEX+=drug_codeex+",";
					 drugCodeUniq+=drug_codeex.replaceAll("[-+.^:,]","")+",";	
					
					 
				 }
		
				 if(exstngIVorder.size()>0){
					 drug_codesEX = drug_codesEX.substring(0, drug_codesEX.length()-1); 
					 drugCodeUniq = drugCodeUniq.substring(0, drugCodeUniq.length()-1)+"";
				 }
				
			
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drugTypeCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_codesEX));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drugCodeUniq));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(drugTypeDesc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(default_tradeName));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(checkForStock));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block51Bytes, _wl_block51);
 } else if(previousorder_id.equals(order_id)) {
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(drug_CompleteDetails));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(strFluidName));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strdrug_CompleteDetails));
            _bw.write(_wl_block57Bytes, _wl_block57);
strFluidName="";
					  strdrug_CompleteDetails="";
					  //WithCount=0;
					  
            _bw.write(_wl_block58Bytes, _wl_block58);
if(cClassName.length()>0){
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(cClassName));
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drugGenCat));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(drugTypeDesc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(formattedEndDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(formattedEndMonth));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(formattedEndYear));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(formattedStartDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(formattedStartMonth));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(formattedStartYear));
            _bw.write(_wl_block64Bytes, _wl_block64);

				     if(Float.parseFloat(avl_qty)>0){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
}} else if(ivrxIsPresent.equals("Y") && drugTypeDesc.equals("WITH ADDITIVES")){		
		if(!previousorder_id.equals(order_id)) {
			strFluidName=drug_name;
			strdrug_CompleteDetails=drug_CompleteDetails;
			
			ArrayList exstngIVorder = 	iv_bean.getExistingIVRecords(order_id, "Y", "IP");//TODO -- change patient_class hardcoded
			
			  String drug_codesEX ="";
			  String drugCodeUniq="";
				 for(int e=0;e<exstngIVorder.size();e++){
					 
					 HashMap extDrugList		=	(HashMap)exstngIVorder.get(e); 
					 String drug_codeex=	(String)extDrugList.get("ORDER_CATALOG_CODE")==null?"":(String)extDrugList.get("ORDER_CATALOG_CODE"); 
					
					 drug_codesEX+=drug_codeex+",";
					 drugCodeUniq+=drug_codeex.replaceAll("[-+.^:,]","")+",";	
							
				 }
		
				 if(exstngIVorder.size()>0){
					 drug_codesEX = drug_codesEX.substring(0, drug_codesEX.length()-1); 
					 drugCodeUniq = drugCodeUniq.substring(0, drugCodeUniq.length()-1)+""; 
					 
				 }
				
				

			
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drugTypeCode));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(drugTypeDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_codesEX));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drugCodeUniq));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(default_tradeName));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(checkForStock));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block70Bytes, _wl_block70);
 
		} else if(previousorder_id.equals(order_id) && order_line_no==2) {
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(drug_CompleteDetails));
            _bw.write(_wl_block73Bytes, _wl_block73);
 if(!previousorder_id.equals(nextOrder)) {
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(strFluidName));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strdrug_CompleteDetails));
            _bw.write(_wl_block76Bytes, _wl_block76);
strFluidName="";
							strdrug_CompleteDetails="";
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);
} else if(previousorder_id.equals(order_id) && order_line_no==3) {
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(drug_CompleteDetails));
            _bw.write(_wl_block80Bytes, _wl_block80);
 if(order_id.equals(nextOrder)){
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strFluidName));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(strdrug_CompleteDetails));
            _bw.write(_wl_block85Bytes, _wl_block85);
strFluidName="";
						strdrug_CompleteDetails="";
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block87Bytes, _wl_block87);
 if(order_line_no>1 && !previousorder_id.equals(nextOrder)){
            _bw.write(_wl_block88Bytes, _wl_block88);
if(cClassName.length()>0){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cClassName));
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drugGenCat));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(drugTypeDesc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(formattedEndDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(formattedEndMonth));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(formattedEndYear));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(formattedStartDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(formattedStartMonth));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(formattedStartYear));
            _bw.write(_wl_block40Bytes, _wl_block40);

				     if(Float.parseFloat(avl_qty)>0){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block92Bytes, _wl_block92);
}}else if(drugTypeCode.equalsIgnoreCase("CRx") &&  drugTypeDesc.equalsIgnoreCase("COMPOUND RX")){
			 String	 drug_codesEX ="";
			  String drugCodeUniq="";
			  ArrayList exstngIVorder = 	iv_bean.getExistingIVRecords(order_id, "Y", "IP");//TODO -- change patient_class hardcoded
			 int orderSize=exstngIVorder.size();
			
			if(orderSize>=7){
				
				orderSize=7;
			}
			
            _bw.write(_wl_block93Bytes, _wl_block93);
  if(!previousOrderStr.equalsIgnoreCase(order_id)){
				previousOrderStr=order_id;
				orSize=0;
				
			
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id_order_ids_lineNum));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drugTypeCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_codesEX));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(drugCodeUniq));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drugTypeDesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(default_tradeName));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ivrxIsPresent));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(checkForStock));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block98Bytes, _wl_block98);
 }
            _bw.write(_wl_block99Bytes, _wl_block99);
 orSize=orSize+1;
		

		
            _bw.write(_wl_block100Bytes, _wl_block100);
 	if(orSize <= 7){ 	
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block102Bytes, _wl_block102);
 
				}
		
			
			if(orSize==orderSize){
			
            _bw.write(_wl_block103Bytes, _wl_block103);
 	if(orderSize>=7){ 	
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block105Bytes, _wl_block105);
 	} 	
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(drug_CompleteDetails));
            _bw.write(_wl_block107Bytes, _wl_block107);
if(cClassName.length()>0){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cClassName));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drugGenCat));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drugTypeDesc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(formattedEndDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(formattedEndMonth));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(formattedEndYear));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(formattedStartDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(formattedStartMonth));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(formattedStartYear));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block109Bytes, _wl_block109);

			
			}
			if(orSize==exstngIVorder.size()){
			orSize=0;
			previousOrderStr="";
			}
			
            _bw.write(_wl_block110Bytes, _wl_block110);
	}	
		if(group_by.equals("PR")){			
			previousorder_id	=	order_id;			
			++i;
		}}
            _bw.write(_wl_block111Bytes, _wl_block111);

	}else{      
	
            _bw.write(_wl_block112Bytes, _wl_block112);
		
	}	
	
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block116Bytes, _wl_block116);
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
