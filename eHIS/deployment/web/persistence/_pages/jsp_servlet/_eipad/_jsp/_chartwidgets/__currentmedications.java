package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.currentmedications.healthobject.CurrentMedicationHO;
import eIPAD.chartsummary.currentmedications.response.CurrentMedicationRes;
import eIPAD.chartsummary.currentmedications.healthobject.CurMedMultipleFlowRateHO;
import ePH.QueryPatientDrugProfileBean;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import eIPAD.chartsummary.common.response.ErrorInfo;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __currentmedications extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/CurrentMedications.jsp", 1709118017178L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<script>\n$(document).ready(function() {\n});\nvar detailOpen = false;\nvar curOrderId ;\nvar prOrderId ;\n function showDetails(orderId){\n\t curOrderId = orderId;\n\t if(curOrderId != prOrderId)\n\t\t {\n\t \t\tif(detailOpen!=true){\n\t \t\t\t$(\'#multipleFluidDetails\'+curOrderId).show();\n\t \t\t\t$(\'#showMultipleDetail\'+curOrderId).addClass(\"rotateImg\");\n\t \t\t\tscrollerRefresh(CSMainScroll);\n\t \t\t}\n\t \t\telse{\n\t \t\t\t\tif(prOrderId != null){\n\t \t\t\t\t\t$(\'#multipleFluidDetails\'+prOrderId).hide();\n\t \t\t\t\t\t$(\'#showMultipleDetail\'+prOrderId).removeClass(\"rotateImg\");\n\t \t\t\t\t\t$(\'#multipleFluidDetails\'+curOrderId).show();\n\t \t\t\t\t\t$(\'#showMultipleDetail\'+curOrderId).addClass(\"rotateImg\");\n\t \t\t\t\t\tscrollerRefresh(CSMainScroll);\n\t \t\t\t\t}\n\t \t\t\t}\n\t \t\t\n\t \t\tdetailOpen =true;\n\t \t}\n\t else{\n\t\t if(detailOpen == true) {\n\t\t\t $(\'#multipleFluidDetails\'+curOrderId).hide();\n\t\t\t $(\'#showMultipleDetail\'+curOrderId).removeClass(\"rotateImg\");\n\t\t\t scrollerRefresh(CSMainScroll);\n\t\t\t detailOpen=false;\n\t\t }\n\t\t else{\n\t\t\t $(\'#multipleFluidDetails\'+curOrderId).show();\n\t\t\t $(\'#showMultipleDetail\'+curOrderId).addClass(\"rotateImg\");\n\t\t\t scrollerRefresh(CSMainScroll);\n\t\t\t detailOpen=true;\n\t\t }\n\t }\n\t prOrderId = curOrderId; \n }\n function filterCurMedication(filterByVal){\n\t loadCurrentMedication(filterByVal);\n }\n\n function loadCurrentMedication(filterByVal){\n     \n\t  $(\"#CurrentMedicationFrame\").load( path + \"/mobile/chartsummary/CurrentMedicationView?filterByVal=\" +filterByVal,function(){\n\t\t\tscrollerRefresh(CSMainScroll);\n\t\t\t$(\"[data-filterIcon = \'CM\']\").each(function(index, value) {  \n\t\t\tif(filterByVal == \'all\')\n\t\t\t {\n\t\t\t\t  $(\"[data-filterBy = \'cmallrecords\']\").removeClass(\"notesIconTheme\").addClass(\"notesIconSelectedTheme\"); \n\t\t\t\t\n\t\t\t }\n\t\t\t else\n\t\t\t {\n\t\t\t\t if(filterByVal.indexOf($(this).attr(\"data-filterBy\")) != -1)\t \n\t\t\t\t\t{\n\t\t\t\t\t $(this).removeClass(\"notesIconTheme\").addClass(\"notesIconSelectedTheme\");\n\t\t\t\t\t $(\"[data-filterBy = \'cmallrecords\']\").removeClass(\"notesIconSelectedTheme\").addClass(\"notesIconTheme\");\n\t\t\t\t\t}\n\t\t\t }\n\t\t\t});\n\t  });\n}\n \n</script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<div class=\"widgetParent widgetParentTheme\" style=\"position:relative;\" data-role = \"none\">\n\t \t<form id=\"currentMedicationForm\" class=\"currentMedicationForm\" action=\"\" method=\"post\" name=\"currentMedicationForm\" id=\"currentMedicationForm\"> \n\t\t\t<div class=\"widgetTable\" data-role = \"none\">\n\t\t\t\t<div class=\"widgetHeaderRow widgetHeaderRowTheme\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t\t\t<div class=\"widgetHeaderMarginExtn widgetHeaderMarginExtnTheme\" data-role = \"none\"></div>\n\t\t\t\t\t\t<div class=\"widgetHeaderIcontriangle\" data-role = \"none\"></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"widgetHeaderCell widgetHeaderCellTheme\" data-role = \"none\">\n\t\t\t\t\t\t<div class=\"widgetHeaderSubTable\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"widgetHeaderSubRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"widgetHeaderIconCol1\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"widgetHeaderIconButton widgetHeaderIconButtonTheme\" data-role = \"none\"><img src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/CS_Allergies.PNG\" class=\"widgetHeaderButtonImage\"></div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"widgetHeaderHeadingTextCol\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<span class=\"widgetHeaderHeadingTextTheme\" data-role = \"none\">Current Medication</span> \n\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"widgetHeaderCountButtonTheme\" id=\"currentMedicationViewCount\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t \t<div class=\"notesFilterCol\" data-role=\"none\" > \n\t\t\t\t\t\t\t\t\t<table style=\"height: 100%; width: 100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t\t\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 100%\" align=\"right\" valign=\"center\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"notesFilterContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table style=\"width: 100%; height: 100%;\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  class=\"notesIconSelectedTheme\" valign=\"center\" align=\"center\" data-filterIcon = \"CM\" data-filterBy = \"cmallrecords\"   onclick = \"filterCurMedication(\'all\')\"><img src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/images/view01.png\" style=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  class=\"notesIconTheme\" valign=\"center\" align=\"center\" data-filterIcon = \"CM\" data-filterBy = \"norRx\"  onclick = \"filterCurMedication(\'norRx\')\"><img src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/Rx.png\" style=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  class=\"notesIconTheme\" valign=\"center\" align=\"center\" data-filterIcon = \"CM\" data-filterBy = \"comRx\"   onclick = \"filterCurMedication(\'comRx\')\"><img src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/CRx.png\" style=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  class=\"notesIconTheme\" valign=\"center\" align=\"center\" data-filterIcon = \"CM\" data-filterBy = \"IVRx\"   onclick = \"filterCurMedication(\'IVRx\')\" ><img src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/images/IV.png\" style=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t\t\n\t\n\t\t\t\t<div class=\"widgetContentRow\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t\t\t\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"widgetContentCell widgetContentCellTheme WidgetContentStripTheme\" data-role = \"none\">\n\t\t\t\t\t\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<div class=\"PDContentTable WidgetContentStripTheme\" id=\"CMTable\"  data-role = \"none\" >\n\t\t\t\t\t\t\t\t<div class=\"PDContentRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"\" class=\"curMedOutCol  WidgetContentStripCol1Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"PDIcon WidgetContentStripCol1BoxTheme\" style=\"text-align:center;\"  data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedIconContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/IV.png\" style=\"vertical-align:middle;\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div id=\"outerTbCol2\"; class=\"curMedCol2Cell curMedColBorderTheme\" >\n\t\t\t\t\t\t\t\t\t\t \t<div id=\"repeat\" class=\"curMedCol2InnerTab01\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"r1\" style=\"display: table;width: 100%;\" class=\"curMedCol2InnerRow01\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"PDContentCol2\" data-role = \"none\" style=\"width:95%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedCol2InnerTab01\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedCol2InnerRow02\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"col1\" class=\"curMedCol2InnerCell\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"WidgetParaHeadTextTheme PDdescText curMedCol2InnerTabCell01\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t<div class=\"curMedCol2InnerTabRow02\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"curMedCol2InnerTabCell02 curMedDetailsFontTheme\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tFluid \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-weight:normal;\"> Total Volume :</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id= \"col2\"  class=\"curMedInnTab02Cell01IV\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"curMedCol2InnTab02IV\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div class=\"curMedInnerCell\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"curMedIVMultiRowTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t<div class=\"curMedIVMultiRow\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"curMedDetailsFontTheme curMedIVMultiRowCell\"  onclick=\"showDetails(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t <div style=\"float:right;\" class=\"table\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t<div class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t<div class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\tMultiple Flow Rate \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t<div class=\"curMedTabCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t<img id=\"showMultipleDetail";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" src=\"/eHIS/eIPAD/images/EXPCOL.PNG\" ; />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t<span style=\"font-weight:normal;\"> Rate - </span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" /";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t<span style=\"font-weight:normal;\"> over </span> ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div class=\"curMedIVMultiRow\">\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"curMedDetailsFontThemeIV curMedIVMultiRowCell\" > \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" for ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" , ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t</div> \t\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div class=\"cell\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedInnTab02Cell02 curMedStatusThemeActive\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedInnTab02Cell02 curMedStatusThemeNormal\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t\t</div>\t \n\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div id=\"PDCol3\"  class=\"curMedCol3OutCell curMedCol3Theme\" > \n\t\t\t\t\t\t\t\t\t\t  <div class=\"curMedCol3InnTab01\">\n\t\t\t\t\t\t\t\t\t\t   <div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"outerCol1\" class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\"  class=\"curMedDateNumTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol2\" class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div id=\"innerTab01\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow1\" class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow2\" class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t \t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t<div  class=\"curMedDateDashTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t \t  \t\t- \n\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"outerCol2\" class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\" class=\"curMedDateNumTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol2\" class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div id=\"innerTab01\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow1\" class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow2\" class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div  class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t   <div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t   \t\t\t<div class=\"curMedTimeTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t   \t\t</div>\n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"cell\"></div> <!-- empty div created for alignment --> \n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t   \t\t\t<div class=\"curMedTimeTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t   \t\t</div>\n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t</div> \t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t \t <div class=\"WidgetContentStripTheme\" >\n\t\t\t\t\t\t\t\t\t\t<div id=\"multipleFluidDetails";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" class=\"WidgetContentStripTheme\"  style=\"display:none;margin-left:5px;margin-right:5px;border: 1px solid #B8CEDB; margin-top:5px;margin-bottom:5px;\">\n\t\t\t\t\t\t\t\t \t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t <div  class=\"WidgetContentStripTheme PDContentTable\" >\n\t\t\t\t\t\t\t\t \t <div class=\"curMedCol2InnerRow01\">\n\t\t\t\t\t\t\t\t\t \t \n\t\t\t\t\t\t\t\t\t\t<div class=\"curMedIVMultiTableRow\">\n\t\t\t\t\t\t\t\t\t\t\t<!-- Column 1 -->\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"\" class=\"curMedOutCol  WidgetContentStripCol1Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedMultiIVTable\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"curMedInnerCell\" style=\"text-align:center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="/eIPAD/images/CM_Child-icon.png\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t <!-- Column 2 -->\n\t\t\t\t\t\t\t\t\t\t<div id=\"outerTbCol2\"; class=\"curMedCol2Cell  \" >\n\t\t\t\t\t\t\t\t\t\t \t<div id=\"repeat\" class=\"curMedCol2InnerTab01\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"r1\" style=\"display: table;width: 100%;\" class=\"curMedCol2InnerRow02IVMulti\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedIVMultiRow02Cell\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"curMedDetailsFontThemeNormal\"> Infuse volume : </span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"curMedDetailsFontTheme\" > ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"curMedDetailsFontThemeNormal\"> , Rate - </span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"curMedDetailsFontTheme\" > ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" </span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"curMedDetailsFontThemeNormal\"> / </span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"curMedDetailsFontTheme\" > ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" </span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"curMedDetailsFontThemeNormal\"> over </span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"curMedDetailsFontTheme\" > ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t \t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"r2\" class=\"curMedCol2InnerRow02IVMulti\" > \n\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedIVMultiRow02Cell\" >\n\t\t\t\t\t\t\t\t\t \t\t\t\t\t<span  class=\"curMedDetailsFontThemeNormal\">Gap </span>\n\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t \t\t\t\t\t<span class=\"curMedDetailsFontTheme\" > 0.00 Hrs </span>\n\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t \t\t\t\t\t<span class=\"curMedDetailsFontTheme\">  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" Hrs </span>\n\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t <!-- Col 3 -->\n\t\t\t\t\t\t\t\t\t\t<div id=\"PDCol3\"  class=\"curMedCol3OutCellRight \"  > \n\t\t\t\t\t\t\t\t\t\t  <div class=\"curMedCol3InnTabIV\">\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"outerCol1\" class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\"  class=\"curMedDateNumTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol2\" class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div id=\"innerTab01\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow1\" class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow2\" class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div class=\"curMedDateDashTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t  \t\t- \n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"outerCol2\" class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\" class=\"curMedDateNumTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol2\" class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div id=\"innerTab01\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow1\" class=\"row;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow2\" class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t   <div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t   \t\t\t<div class=\"curMedTimeTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t   \t\t</div>\n\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t</div> \t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<!-- </div> -->\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\t \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\n\t\t\t\t</div>\t\n\t\t\t</div>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t</div>\t\n\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div id=\"PDCol3\"  class=\"curMedCol3OutCell curMedCol3Theme\" > \n\t\t\t\t\t\t\t\t<div class=\"curMedCol3InnTab01\">\n\t\t\t\t\t\t\t\t   <div class=\"row\">\n\t\t\t\t\t\t\t\t\t<div id=\"outerCol1\" class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\"  class=\"curMedDateNumTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol2\" class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t<div id=\"innerTab01\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow1\" class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\"> \n\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow2\" class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t \t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t \t\t<div  class=\"curMedDateDashTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t \t  \t\t- \n\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div id=\"outerCol2\" class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\"  class=\"curMedDateNumTheme curMedInnerCell\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol2\" class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t<div id=\"innerTab01\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow1\" class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow2\" class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t</div> \t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\t  \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" \n\t\t\t\t\t\t\t\t\t<!-- --------------------Current Medication widget content starts here----------------------- -->\n\t\t\t\t\t<div class=\"PDContentTable WidgetContentStripTheme\" id=\"CMTable\"  data-role = \"none\" >\n\t\t\t\t\t\t<div class=\"PDContentRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div style=\"\" class=\"curMedOutCol  WidgetContentStripCol1Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"curMedTable\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t  <div  class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"PDIcon WidgetContentStripCol1BoxTheme\" style=\"text-align:center;\"  data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedIconContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="/eIPAD/images/Rx.png\" style=\"vertical-align:middle;\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div id=\"outerTbCol2\"; class=\"curMedCol2Cell curMedColBorderTheme\" >\n\t\t\t\t\t\t\t\t \t<div id=\"repeat\" class=\"curMedCol2InnerTab01\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"r1\" style=\"display: table;width: 100%;\" class=\"curMedCol2InnerRow01\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"PDContentCol2\" data-role = \"none\" style=\"width:95%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedCol2InnerTab01\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedCol2InnerRow02\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"col1\" class=\"curMedCol2InnerCell\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"WidgetParaHeadTextTheme PDdescText curMedCol2InnerTabCell01\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedCol2InnerTabRow02\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"curMedCol2InnerTabCell02 WidgetNormalTextTheme\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =", ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id= \"col2\" style=\" text-align: right; \" class=\"curMedInnTab02Cell01\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"curMedCol2InnTab\">\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedInnerCell\" >\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div  class=\"curMedCol2InnTabCell03 curMedDetailsFontTheme\"> \n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedStatusIndi\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedInnTab02Cell02 curMedStatusThemeActive\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedInnTab02Cell02 curMedStatusThemeNormal\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t \t\t\t</div>\t \n\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t<div id=\"PDCol3\"  class=\"curMedCol3OutCell curMedCol3Theme\" > \n\t\t\t\t\t\t\t\t  <div class=\"curMedCol3InnTab01\">\n\t\t\t\t\t\t\t\t   <div class=\"row\">\n\t\t\t\t\t\t\t\t\t<div id=\"outerCol1\" class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\"  class=\"curMedDateNumTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol2\" class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t<div id=\"innerTab01\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow1\" class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"curMedDateMthYrTheme cell\"> \n\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t \t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t \t\t<div  class=\"curMedDateDashTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t \t  \t\t- \n\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div id=\"outerCol2\" class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\"  class=\"curMedDateNumTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t</div> \t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol2\" class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t<div id=\"innerTab01\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow1\" class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div  class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow2\" class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div  class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t   </div>\t\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"PDCol3\"  class=\"curMedCol3OutCell curMedCol3Theme\" > \n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedCol3InnTab01\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"outerCol1\" class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\"  class=\"curMedDateNumTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol2\" class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div id=\"innerTab01\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow1\" class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow2\" class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div class=\"curMedInnerCell\" class=\"curMedDateDashTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t  \t\t- \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"outerCol2\" class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\"  class=\"curMedDateNumTheme curMedInnerCell\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol2\" class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div id=\"innerTab01\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow1\" class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div id=\"innerRow2\" class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div  class=\"curMedDateMthYrTheme cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\t  \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="   \n\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t   <div class=\"PDContentTable WidgetContentStripTheme\"  id=\"PDTable\"   data-role = \"none\" >\n\t\t\t\t\t\t\t\t\t<div class=\"PDContentRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div style=\"\" class=\"curMedOutCol  WidgetContentStripCol1Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"PDIcon WidgetContentStripCol1BoxTheme\" style=\"text-align:center;\"  data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedIconContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="/eIPAD/images/CRx.png\" style=\"vertical-align:middle;\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="/eIPAD/images/IV.png\" style=\"vertical-align:middle;\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<!-- Column 2 for dispaly detials Starts --> \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div id=\"outerTbCol2\"; class=\"curMedCol2Cell curMedColBorderTheme\" >\n\t\t\t\t\t\t\t\t \t\t\t<div id=\"repeat\" class=\"curMedCol2InnerTab01\">\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="      \n\t\t\t\t\t\t\t            \n\t\t\t\t\t\t\t            <div id=\"printBorder\" class=\"curMedCol2InnerRow01\">\n\t\t\t\t\t\t\t \t\t\t\t<div  class=\"curMedCompoundBorder curMedBorderTheme\"></div>\n\t\t\t\t\t\t\t \t\t\t</div> \n\t\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t<div id=\"r1\" style=\"display: table;width: 100%;\" class=\"curMedCol2InnerRow01\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"PDContentCol2\" data-role = \"none\" style=\"width:95%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedCol2InnerTab01\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedCol2InnerRow02\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"col1\" class=\"curMedCol2InnerCell\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"WidgetParaHeadTextTheme PDdescText curMedCol2InnerTabCell01\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"curMedCol2InnerTabRow02\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"curMedCol2InnerTabCell02 WidgetNormalTextTheme\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id= \"col2\" style=\" text-align: right; \" class=\"curMedInnTab02Cell01\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div  class=\"curMedCol2InnTab\">\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"curMedInnerCell\" >\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div  class=\"curMedCol2InnTabCell03 curMedDetailsFontTheme\"> \n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="  ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"col1\" class=\"curMedCol2InnerCell\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"WidgetParaHeadTextTheme PDdescText curMedCol2InnerTabCell01\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id= \"col2\"  class=\"curMedInnTab02Cell01IV\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"curMedCol2InnTab02IV\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div class=\"curMedInnerCell\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"curMedIVMultiRowTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t<div class=\"curMedIVMultiRow\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"curMedDetailsFontTheme curMedIVMultiRowCell\"  onclick=\"showDetails(\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t \t\t\t</div>\t \n\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div id=\"PDCol3\"  class=\"curMedCol3OutCell curMedCol3Theme\" > \n\t\t\t\t\t\t\t\t<div class=\"curMedCol3InnTab01\">\n\t\t\t\t\t\t\t\t   <div class=\"row\">\n\t\t\t\t\t\t\t\t\t<div id=\"outerCol1\" class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"innerTab\" class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"innerCol1\"  class=\"curMedDateNumTheme curMedInnerCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t</div> \t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" \n\t\t\t\t\n\t\t\t\t\t\t<div class=\"WidgetVwErrContainer\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t \t</form> \n\t</div>\n\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );
	
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


						  public ArrayList<String> getMntName(String strDate){ 
							 String[] dateSplit = strDate.split(" ");
						  	 String dateNumber = dateSplit[0];
						  	 String dateTime = dateSplit[1];
							 String[] dateItems = dateNumber.split("/");
							 ArrayList<String> dateItem = new ArrayList<String>();
					 		 String dateNo = dateItems[0];
					 		 dateItem.add(dateNo);
					 		 String dateMth = dateItems[1];
					 		 int mthNo = Integer.parseInt(dateMth);
					 		 String dateYear = dateItems[2];
					 		 dateItem.add(dateYear);
					 		 String monthString = null;
					 		 switch (mthNo) {
					            case 1:  monthString = "JAN";
					                     break;
					            case 2:  monthString = "FEB";
					                     break;
					            case 3:  monthString = "MAR";
					                     break;
					            case 4:  monthString = "APR";
					                     break;
					            case 5:  monthString = "MAY";
					                     break;
					            case 6:  monthString = "JUN";
					                     break;
					            case 7:  monthString = "JUL";
					                     break;
					            case 8:  monthString = "AUG";
					                     break;
					            case 9:  monthString = "SEP";
					                     break;
					            case 10: monthString = "OCT";
					                     break;
					            case 11: monthString = "NOV";
					                     break;
					            case 12: monthString = "DEC";
					                     break;
					            default: monthString = "Invalid month";
					                     break;
					 	 	}
					 		 
					 		dateItem.add(monthString);
					 		dateItem.add(dateTime);
					 		return dateItem; 
					 	 } 
	 					 

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
 

if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

            _bw.write(_wl_block5Bytes, _wl_block5);

CurrentMedicationRes cmResponse = (CurrentMedicationRes)request.getAttribute("Response");
boolean isSuccessResponse = false;
boolean isEmptyResponse = true;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
List<CurrentMedicationHO> curMedList = new ArrayList<CurrentMedicationHO>();
CurrentMedicationHO curMedHO = null;
if(cmResponse!=null){
	isSuccessResponse = cmResponse.isSuccessResponse();
	isEmptyResponse = cmResponse.isEmptyDataResponse();
	curMedList = cmResponse.getCurrentMedicationList();
	errorList = cmResponse.getErrorsList();
	//if(curMedList!=null && !curMedList.isEmpty())
		//isEmptyResponse = false;
	
}
int count = cmResponse.getCount();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(count));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block13Bytes, _wl_block13);
 
						 String prevOrderId = "";
						 boolean compoundRxRow = false; // to check if previous row is of compound Rx 
						 boolean prevComp = false; // to check if the items found are compound Rx or not 
						 String strComDtNo = "", strComDtMth="", strComDtYr="";
						 String endComDtNo = "", endComDtMth="",endComDtYr="";
						 int borderCheck = 0;
						 
						 if(isSuccessResponse && !isEmptyResponse) {
							 for(int i =0;i<curMedList.size();i++ )
							 {
								 curMedHO = curMedList.get(i);
								 
							 	 String currOrderId = curMedHO.getOrderId();
							 	
							 	 String startDate = curMedHO.getStartDate();
							 	 String endDate = curMedHO.getEndDate();
							 	 ArrayList<String> startDtItem = getMntName(startDate);
							 	 String stDtNo = startDtItem.get(0);
							 	 String stDtMth = startDtItem.get(2);
							 	 String stDtYr = startDtItem.get(1);
							 	 String stDtTime = startDtItem.get(3);
							 	 ArrayList<String> endDtItem = getMntName(endDate);
							 	 String endDtNo = endDtItem.get(0);
							 	 String endDtMth = endDtItem.get(2);
							 	 String endDtYr = endDtItem.get(1);
							 	 String endDtTime = endDtItem.get(3);
							 	 
							 	 String RxValue = curMedHO.getPrepYN();
							 	 String lineStatus = curMedHO.getLineStatus();
							 	 String statusFrmQuery = curMedHO.getStatus();
							 	 String returnedQty = curMedHO.getReturnedQty();
							 	 String patientClass = curMedHO.getPatientClass();
							 	 String dischargeMed = curMedHO.getDischargeMed();
							 	 String multiFlowRateYN = curMedHO.getSplitFluidMedicationYN();
							 	 
							 	 
							 	 String status = "*A"; // it is directly declared as *A because in desktop version it is send a url parameter and its value is *A in almost all cases 
							 	
							 	 String	bean_id			=	"QueryPatientDrugProfileBean" ;
								 String	bean_name		=	"ePH.QueryPatientDrugProfileBean";
							 	 QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
							 	 String futureYN = bean.compareDate(startDate);
							 	 String expiryYN = bean.compareDate(endDate);
							 	 String activeMed = "";
							 	 
							 	if(!returnedQty.equals("") ){  // the following code to check the active medication. Right now only active medication is shown in indication. 
									if((status.equals("A") || status.equals("*A")) && (lineStatus.equals("DP") || lineStatus.equals("DF")) && (futureYN.equals("N")) && !expiryYN.equals("N")){
										activeMed = "active";
									}
									else{
										if(futureYN.equals("Y")) 
											activeMed	= "FUTURE_Rx";
										else if(expiryYN.equals("N")){
											activeMed	= "EXPIRED_MEDICATION";
										}
										else if (lineStatus.equals("CN"))
											activeMed	= "CANCEL";
										else if (lineStatus.equals("DC"))
											activeMed	= "DIS-CONTINUED";
										else if(dischargeMed.equals("D"))
											activeMed="DISCHARGEMED1";
										else if (lineStatus.equals("HD") || lineStatus.equals("HC"))
											activeMed	= "HOLD";
										else
											activeMed	= "active";
											
										}
								 	}
								 	else if (lineStatus.equals("CN")){
										
										if(expiryYN.equals("N"))
											activeMed	= "EXPIRED_MEDICATION";
										else
											activeMed	= "CANCEL";
									}
									else if (lineStatus.equals("DC")){
										
										if(expiryYN.equals("N"))
											activeMed	= "EXPIRED_MEDICATION";
										else
											activeMed	= "DIS-CONTINUED";
									}
									else if( ((statusFrmQuery.equalsIgnoreCase("active")) || ((patientClass.equals("IP") || patientClass.equals("DC")) && (lineStatus.equals("OS") || lineStatus.equals("RG") || lineStatus.equals("IP") || lineStatus.equals("VF")) ) || ((patientClass.equals("OP") || patientClass.equals("EM")) && (lineStatus.equals("OS") || lineStatus.equals("RG") || lineStatus.equals("IP") || lineStatus.equals("VF") || lineStatus.equals("DP") || lineStatus.equals("DF")) ))){
										//(lineStatus.equals("DP") || lineStatus.equals("DF") )
		
										if(futureYN.equals("Y")) { 
											
											activeMed	= "FUTURE_Rx";
										}
										else{
											
											if(expiryYN.equals("N")){
											
												activeMed	= "EXPIRED_MEDICATION";
											}
											else {
												if(dischargeMed.equals("D")){
													
													activeMed="DISCHARGEMED1";
												}
												else 
													activeMed	= "active";
											}
											
										}
								}							 	 

							//if(RxValue.equals("1") || RxValue.equals("3") || RxValue.equals("5")){
								if(RxValue.equals("1000") ){
								prevComp = false;
								if(!compoundRxRow){
								
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(curMedHO.getDrugName()  ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( curMedHO.getDosageDetails() ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(currOrderId));
            _bw.write(_wl_block18Bytes, _wl_block18);
 if(multiFlowRateYN.equalsIgnoreCase("Y")) { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(currOrderId ));
            _bw.write(_wl_block20Bytes, _wl_block20);
 } else { 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( curMedHO.getInfusionRate() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(curMedHO.getInfusionVolStrUnit() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curMedHO.getInfusionPerUnit() ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(curMedHO.getInfusionTime() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(curMedHO.getInfusionOverUnit() ));
            _bw.write(_wl_block25Bytes, _wl_block25);
 } 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( curMedHO.getFrequency() ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curMedHO.getDuration()  ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(curMedHO.getDuration_desc() ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(curMedHO.getOrderQty() ));
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(activeMed.equals("active")){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
 }else {
            _bw.write(_wl_block31Bytes, _wl_block31);
 } 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(stDtNo ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( stDtMth ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(stDtYr  ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( endDtNo ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( endDtMth ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( endDtYr ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(stDtTime ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(endDtTime ));
            _bw.write(_wl_block40Bytes, _wl_block40);
 
								int multiRowBorder = 0;
								if(multiFlowRateYN.equalsIgnoreCase("Y")){
								 	 ArrayList<CurMedMultipleFlowRateHO> multiFlowRateDetailList = curMedHO.getMulitpleFlowRate();
								 	 
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(currOrderId ));
            _bw.write(_wl_block42Bytes, _wl_block42);
 
								 	 for(int j=0;j<multiFlowRateDetailList.size();j++)
								 	 {
								 		 CurMedMultipleFlowRateHO multiflowDetail = new CurMedMultipleFlowRateHO();
								 		 multiflowDetail= multiFlowRateDetailList.get(j);
								 		 String gapDuration = multiflowDetail.getGapInHrs(); // in hrs 
								 		 String startIVRxDate = multiflowDetail.getStartDateTime();
								 		 ArrayList<String> startDtIVRxItem = getMntName(startIVRxDate);
									 	 String stDtIVNo = startDtIVRxItem.get(0);
									 	 String stDtIVMth = startDtIVRxItem.get(2);
									 	 String stDtIVYr = startDtIVRxItem.get(1);
									 	 String stDtIVTime = startDtIVRxItem.get(3);
								 		 String endIVRxDate = multiflowDetail.getEndDateTime();
								 		 ArrayList<String> endDtIVRxItem = getMntName(endIVRxDate);
									 	 String endDtIVNo = endDtIVRxItem.get(0);
									 	 String endDtIVMth = endDtIVRxItem.get(2);
									 	 String endDtIVYr = endDtIVRxItem.get(1);
									 	 String endDtIVTime = endDtIVRxItem.get(3);
									 	 
								
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(multiflowDetail.getTotalStrength() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(multiflowDetail.getTotStrengthUOM() ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(multiflowDetail.getInfusionRate() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(multiflowDetail.getInfusionVolStrUnit() ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(multiflowDetail.getInfusionPerUnit() ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(multiflowDetail.getInfuseOver() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(multiflowDetail.getInfuseOverUnit() ));
            _bw.write(_wl_block48Bytes, _wl_block48);
if(gapDuration.equals("") || gapDuration.equals(null) ) { 
            _bw.write(_wl_block49Bytes, _wl_block49);
 }else {  
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(gapDuration ));
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(stDtIVNo ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( stDtIVMth ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(stDtIVYr  ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( endDtIVNo ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( endDtIVMth ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( endDtIVYr ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(stDtTime ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(endDtTime ));
            _bw.write(_wl_block59Bytes, _wl_block59);
 		
								 multiRowBorder++;
								 	 }
							 	 
            _bw.write(_wl_block60Bytes, _wl_block60);
 		 	 
								}
								}
								  else{
									  if(compoundRxRow){ // this is given to check whether a row is of compoundRx or Normal RX 
									  compoundRxRow= false;
							
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strComDtNo ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf( strComDtMth ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strComDtYr  ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( endComDtNo ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( endComDtMth ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( endComDtYr ));
            _bw.write(_wl_block67Bytes, _wl_block67);
 		  
							  }
									  i--; // i variable for going to a previous item. 
							  }			
							}
								
							else if(RxValue.equals("") ){
								  prevComp = false;
								  if(!compoundRxRow){
						
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(curMedHO.getDrugName()  ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf( curMedHO.getFormDesc() ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( curMedHO.getRouteDesc() ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( curMedHO.getDosageDetails() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( curMedHO.getFrequency() ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curMedHO.getDuration()  ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(curMedHO.getDuration_desc() ));
            _bw.write(_wl_block73Bytes, _wl_block73);
 if(activeMed.equals("active")){ 
            _bw.write(_wl_block74Bytes, _wl_block74);
 }else {
            _bw.write(_wl_block75Bytes, _wl_block75);
 } 
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(stDtNo ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( stDtMth ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(stDtYr  ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( endDtNo ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( endDtMth ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( endDtYr ));
            _bw.write(_wl_block79Bytes, _wl_block79);
 
							 }
								  else{
									  if(compoundRxRow){  // this is given to check whether a row is of compoundRx or Normal RX 
									  compoundRxRow= false;
									  
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strComDtNo ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf( strComDtMth ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strComDtYr  ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( endComDtNo ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( endComDtMth ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( endComDtYr ));
            _bw.write(_wl_block67Bytes, _wl_block67);
 		  
							  }
									  i--; // i variable for going to a previous item. 
							  }	
							  }
							  // else if(RxValue.equals("6")) { 
							  else if(RxValue.equals("6")|| RxValue.equals("1") || RxValue.equals("3") || RxValue.equals("5")) {
									if(!prevOrderId.equals(currOrderId)){
										compoundRxRow = true;
											if(prevComp) { 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strComDtNo ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( strComDtMth ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strComDtYr  ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( endComDtNo ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( endComDtMth ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf( endComDtYr ));
            _bw.write(_wl_block88Bytes, _wl_block88);
 } 
            _bw.write(_wl_block89Bytes, _wl_block89);
 if(RxValue.equals("6")) { 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block91Bytes, _wl_block91);
 } else {
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block92Bytes, _wl_block92);
 } 
            _bw.write(_wl_block93Bytes, _wl_block93);
 }
											   if(borderCheck!=0 && prevOrderId.equals(currOrderId))
											   {
									  		 
            _bw.write(_wl_block94Bytes, _wl_block94);
 } 
            _bw.write(_wl_block95Bytes, _wl_block95);
 if(RxValue.equals("6")) { 
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(curMedHO.getDrugName()  ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf( curMedHO.getFormDesc() ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( curMedHO.getRouteDesc() ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( curMedHO.getDosageDetails() ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf( curMedHO.getFrequency() ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curMedHO.getDuration()  ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(curMedHO.getDuration_desc() ));
            _bw.write(_wl_block73Bytes, _wl_block73);
 if(activeMed.equals("active")){ 
            _bw.write(_wl_block74Bytes, _wl_block74);
 }else {
            _bw.write(_wl_block75Bytes, _wl_block75);
 } 
            _bw.write(_wl_block100Bytes, _wl_block100);
 } else {
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(curMedHO.getDrugName()  ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( curMedHO.getDosageDetails() ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(currOrderId));
            _bw.write(_wl_block18Bytes, _wl_block18);
 if(multiFlowRateYN.equalsIgnoreCase("Y")) { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(currOrderId ));
            _bw.write(_wl_block20Bytes, _wl_block20);
 } else { 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( curMedHO.getInfusionRate() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(curMedHO.getInfusionVolStrUnit() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curMedHO.getInfusionPerUnit() ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(curMedHO.getInfusionTime() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(curMedHO.getInfusionOverUnit() ));
            _bw.write(_wl_block25Bytes, _wl_block25);
 } 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( curMedHO.getFrequency() ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curMedHO.getDuration()  ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(curMedHO.getDuration_desc() ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(curMedHO.getOrderQty() ));
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(activeMed.equals("active")){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
 }else {
            _bw.write(_wl_block31Bytes, _wl_block31);
 } 
            _bw.write(_wl_block103Bytes, _wl_block103);
 }
            _bw.write(_wl_block104Bytes, _wl_block104);

									  			// The date variables are taken into another variables to print them after the complete compound Rx items are done. 
 											  borderCheck++;
											  strComDtNo = stDtNo ;
											  strComDtMth = stDtMth;
											  strComDtYr = stDtYr;
											  endComDtNo = endDtNo;
											  endComDtMth = endDtMth;
											  endComDtYr = endDtYr;
			
									   		  prevOrderId = currOrderId; 
									   		  prevComp = true;
									   		}
									 }
									 if(compoundRxRow)
									 {
										 compoundRxRow= false;
								  		
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(strComDtNo ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf( strComDtMth ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strComDtYr  ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( endComDtNo ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( endComDtMth ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( endComDtYr ));
            _bw.write(_wl_block106Bytes, _wl_block106);
 		 }
						}
						else{
            _bw.write(_wl_block107Bytes, _wl_block107);

							for(int k=0;k<errorList.size();k++){
							
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf( errorList.get(k).getErrorMessage()));
            _bw.write(_wl_block109Bytes, _wl_block109);
} 
            _bw.write(_wl_block110Bytes, _wl_block110);
}
            _bw.write(_wl_block111Bytes, _wl_block111);
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
