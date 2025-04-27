package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.common.constants.WidgetItems;
import eIPAD.chartsummary.common.response.WidgetOrderResponse;
import eIPAD.chartsummary.common.bc.WidgetOrderBC;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import eIPAD.chartsummary.common.response.TransactionResponse;
import eIPAD.chartsummary.common.response.ErrorInfo;
import java.util.Locale;
import java.util.ResourceBundle;

public final class __chartsummarybase_45_newui extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/ChartSummaryBase-newUI.jsp", 1738426018437L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<!DOCTYPE html> \n<html> \n<head> \n<title></title>  \n\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/jquery.mobile-1.3.1.min.css\" />\n<script src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/jquery-1.9.1.js\"></script> \n<script src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/jquery.mobile-1.3.1.min.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/css/iPADThemeA.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/css/iPADUserPre.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/css/iPADNew.css\" />\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/js/iscroll.js\"></script>\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/js/ActiveProblems.js\"></script>\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/js/UserPreference.js\"></script>\n<link href=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/css/kendo.dataviz.min.css\" rel=\"stylesheet\">\n <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/css/kendo.common.min.css\" />\n <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/css/kendo.default.min.css\" />\n <script src=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/eIPAD/kendo.all.min.js\"></script> \n<script src=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19_0 ="/eIPAD/kendo.dataviz.min.js\"></script>\n<script type=\"text/javascript\">\nvar CSMainScroll ;\nvar path;\nvar bclinicalNotesLoaded = false; //c\nvar bOrientationChanged = false; //cn\nvar clinicalNotesFilterBy = \"A\"; //cn\nvar notesHorizontalScroll; //cn\nvar currentNotesHScrollingId; //cn\nvar currentNotesScrollingId; //cn\nvar cnNoteType; //cn\nvar bfullViewOpen = false; //cn\nvar bAccordionViewLoaded = false; //cn\nvar arrCnVisitedPages = []; //cn\nvar cnCurrentPage = 0; //cn\nvar prevCnNoteType = \"\"; //cn\nvar bVitalsLoaded = false;\nfunction assignCSScroll() {\n\t\t setTimeout(function () {\n\t\t\tCSMainScroll = new iScroll(\'ChartSummaryMainWrapper\', {\n\t\t\tuseTransform: true,\n\t\t\tzoom: false,\n\t\t\tonBeforeScrollStart: function (e) {\n\t\t\tvar target = e.target;\n\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' )\n\t\t\te.preventDefault();\n\t\t\t}\n\t\t\t});\n\t}, 100); \n}\ndocument.addEventListener(\'touchmove\', function(e) {\n\te.preventDefault();\n}, false);\ndocument.addEventListener(\'DOMContentLoaded\', assignCSScroll, false);\n//---------vitals start---------------------\n//var vitalsWidth;\n\nfunction assignVitalsWrapperWidth()\n{\n\t//$(\"#vitalsSwipeWrapper\").css(\"width\" , \"200px\");//dummy width\n\tvar swipeContentCellWidth = $(\"#vitalsTable\").width();\n\t//alert(swipeContentCellWidth);\n\tswipeContentCellWidth = swipeContentCellWidth + \"px\";\n\t//alert(swipeContentCellWidth);\n\t$(\"#vitalsSwipeWrapper\").css(\"width\" , swipeContentCellWidth);\n\t\n}\n\nfunction assignVitalsScrollerWidth()\n{\n\tvar swipeContentCellWidth = $(\"#vitalsTable\").width();\n\tvar vitalsScrollerWidth = 0;\n\tvar vitalsBubbleCount = 0;\n\t//vitalWidgetContainer\n\t$(\".vitalWidgetContainer\").each(function(index, value) {\n\t\tvitalsScrollerWidth = vitalsScrollerWidth + $(this).width();\n\t\tvitalsBubbleCount++;\n\t});\n\tif(vitalsScrollerWidth <= swipeContentCellWidth )\n\t{\n\t\tvitalsScrollerWidth = swipeContentCellWidth + \"px\";\n\t}\n\telse\n\t{\n\t\t\tvitalsScrollerWidth = vitalsScrollerWidth + vitalsBubbleCount * 10 + \"px\";\n\t}\n\t$(\"#vitalsScroller\").css(\"width\" , vitalsScrollerWidth);\n\t\n}\n\n//--------vitals end------------------------\nfunction showFullViewNotes(obj) {\n\tvar nt = $(obj).attr(\"data-expandNoteType\");\n\t$(\"[data-fullView = \'true\']\").each(function(index, value) {\n\t\t$(this).hide();\n\t});\n\tarrCnVisitedPages = null;\n\tarrCnVisitedPages = [];\n\t$(\"[data-noteType = \" + cnNoteType +\"]\").show();\n\tif(cnNoteType != nt)\n\t{\n\t\t$(\"[data-fullviewNoteType = \" + nt +\"]\").show();\n\t\t$(\"[data-noteType = \" + nt +\"]\").show();\n\t\tbfullViewOpen = true;\n\t    $(\"[data-fullviewNoteType = \" + nt +\"]\").load( path + \"/mobile/chartsummary/ClinicalNotesView?filterBy=\" +clinicalNotesFilterBy + \"&noteType=\" + nt+ \"&viewType=AccordionView\",function(){\n\t\t\t$(document).ready(function(){\n\t\t\t\t//bclinicalNotesLoaded = true;\n\t\t\t\taccordionNotesViewDimensions(nt);\n\t\t\t\thorizontalNotesScroll(nt);\n\t\t\t\tscrollerRefresh(CSMainScroll);\n\t\t\t\tbAccordionViewLoaded = true;\n\t\t\t\tcnCurrentPage = 0;\n\t\t\t\tif(arrCnVisitedPages != null)\n\t\t\t\t{\n\t\t\t\t\tvar PageID = nt + \"0\";\n\t\t\t\t\tarrCnVisitedPages.push(PageID);\t\n\t\t\t\t}\n\t\t\t});\n\t\t\t\n\t\t});\n\t    \n\t    $(\"[data-imagaeNoteType = \" + cnNoteType +\"]\").attr(\"src\" , path + \"/eIPAD/images/Expandview.png\");\n\t    cnNoteType = nt;\n\t    $(\"[data-imagaeNoteType = \" + nt +\"]\").attr(\"src\" , path + \"/eIPAD/images/Collapseview.png\");\n\t    \n\t}\n\telse\n\t{\n\t\tif(bfullViewOpen)\n\t\t{\n\t\t\t$(\"[data-fullviewNoteType = \" + nt +\"]\").hide();\n\t\t\t$(\"[data-noteType = \" + nt +\"]\").show();\n\t\t\tbfullViewOpen = false;\n\t\t\t$(\"[data-imagaeNoteType = \" + nt +\"]\").attr(\"src\" , path + \"/eIPAD/images/Expandview.png\");\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//horizontalNotesScroll(nt);\n\t\t\t$(\"[data-fullviewNoteType = \" + nt +\"]\").show();\n\t\t\t$(\"[data-noteType = \" + nt +\"]\").show();\n\t\t\tbfullViewOpen = true;\n\t\t\tif(notesHorizontalScroll != null)\n\t\t\t{\n\t\t\t\t//accordionNotesViewDimensions(cnNoteType);\n\t\t\t\t//alert(notesHorizontalScroll.currPageX);\n\t\t\t\tnotesHorizontalScroll.refresh();\n\t\t\t\t//notesHorizontalScroll.scrollToPage(cnCurrentPage,0);\n\t\t\t\t//alert(notesHorizontalScroll.currPageX);\n\t\t\t}\n\t\t\t$(\"[data-imagaeNoteType = \" + nt +\"]\").attr(\"src\" , path + \"/eIPAD/images/Collapseview.png\");\n\t\t}\n\t\tscrollerRefresh(CSMainScroll);\n\t}\n}\nfunction horizontalNotesScroll(noteType)\n{\n\t//notesHorizontalScroll = null;\n\t//$(\".fullViewWrapper\").bind(\'touchstart click\', function(event) {\n\t\t//alert(\"notetype =\" + noteType);\n\t\tvar currentNotesId = $(\"[data-fullViewWrapper = \" + noteType +\"]\").attr(\'id\');\n\t\t//alert(\"hi\");\n\t\t// var currentNotesId = $(this).attr(\'id\');\n\t\t if(currentNotesHScrollingId != null)\n\t\t {\n\t\t\t //alert(\"global =\" +currentNotesHScrollingId);\n\t\t\t //alert( \"local = \" + currentNotesId)\n\t\t\t if(currentNotesHScrollingId != currentNotesId)\n\t\t\t {\n\t\t\t\t// alert(\"hi2\");\n\t\t\t\t notesHorizontalScroll = new iScroll(currentNotesId, {\n\t\t\t\t\t\thScrollbar : false,\n\t\t\t\t\t\tsnap: true,\n\t\t\t\t\t\tmomentum: false,\n\t\t\t\t\t\tvScroll : false,\n\t\t\t\t\t\tonScrollEnd: function () {\n\t\t\t\t\t\t\t//alert(this.currPageX);\n\t\t\t\t\t\t\tloadFullViewBubbleNotes(this.currPageX,noteType);\n\t\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\t currentNotesHScrollingId = currentNotesId;\t\n\t\t\t }\n\t\t }\n\t\t else\n\t\t {\n\t\t\t// alert(\"hi12\");\n\t\t\t currentNotesHScrollingId = currentNotesId;\n\t\t\t notesHorizontalScroll = new iScroll(currentNotesId, {\n\t\t\t\t\thScrollbar : false,\n\t\t\t\t\tsnap: true,\n\t\t\t\t\tmomentum: false,\n\t\t\t\t\tvScroll : false,\n\t\t\t\t\tonScrollEnd: function () {\n\t\t\t\t\t\t//alert(this.currPageX);\n\t\t\t\t\t\tloadFullViewBubbleNotes(this.currPageX,noteType);\n\t\t\t\t\t}\n\t\t\t});\n\t\t\t \n\t\t }\n\t//});\n}\nfunction scrollToPage(pageNumber,cuuDivObj,noteType)\n{\n\tcnCurrentPage = pageNumber;\n\n\tif(notesHorizontalScroll != null)\n\t{\n\t\t//accordionNotesViewDimensions(cnNoteType);\n\t\t//alert(notesHorizontalScroll.currPageX);\n\t\t//notesHorizontalScroll.refresh();\n\t\tnotesHorizontalScroll.scrollToPage(cnCurrentPage,0);\n\t//\tloadFullViewBubbleNotes(pageNumber,noteType);\n\t\t//alert(notesHorizontalScroll.currPageX);\n\t}\n}\nfunction loadFullViewBubbleNotes(pageNumber,noteType)\n{\n\tcnCurrentPage = pageNumber;\n\t//alert(\"pagenumber = \" + cnCurrentPage);\n\tvar pageId = noteType + pageNumber;\n\tif(pageNumber != null && pageNumber != \"\")\n\t{\n\t\tpageNumber = parseInt(pageNumber);\t\n\t}\n\tvar startIndex = 0;\n\tstartIndex = (pageNumber * 15);\n\tvar endIndex = startIndex + 15;\n\tvar pageCount = $(\"[data-pageId = \" + pageId  +\"]\").attr(\"data-pageCount\");\n\tif(pageCount != null && pageCount != \"\")\n\t{\n\t\tpageCount = parseInt(pageCount);\t\n\t}\n\t//alert($.inArray(pageId, arrCnVisitedPages));\n\tvar bPageIdLoaded = false;\n\tif(arrCnVisitedPages != null && $.inArray(pageId, arrCnVisitedPages) != -1)\n\t{\n\t\tbPageIdLoaded = true;\t\n\t}\n\t//alert(\"pageloaded =\" + bPageIdLoaded)\n\tif(pageCount > 1 && !bPageIdLoaded)\n\t{\n\t\t$(\"[data-pageId = \" + pageId  +\"]\").load( path + \"/mobile/chartsummary/ClinicalNotesView?filterBy=\" +clinicalNotesFilterBy + \"&noteType=\" + noteType+ \"&viewType=addNoteBubble&startIndex=\" + startIndex+ \"&endIndex=\" + endIndex,function(){\n\t\t\t\n\t\t});\n\t}\n\t$(\"[data-pageIconNoteType= \"+ noteType+\"]\").each(function(index, value) {\n\t\t\n\t\t $(this).removeClass(\"selectedPageIcons\").addClass(\"normalPageIcons\");\n\t\t if($(this).attr(\"data-pageIconNumber\") == pageNumber)\n\t\t {\n\t\t\t $(this).removeClass(\"normalPageIcons\").addClass(\"selectedPageIcons\");\n\t\t }\n\t});\n\t\n\tarrCnVisitedPages.push(pageId);\n}\nfunction accordionNotesViewDimensions(noteType)\n{\n\tvar count = 0;\n\t$(\"[data-child = \" + noteType +\"]\").each(function(index, value) {\n\t\tcount++;\n\t});\n\tvar fullViewScrollerWidth = count * 100 + \"%\";\n\n\t$(\"[data-fullViewScroller = \" + noteType +\"]\").each(function(index, value) {\n\t\t\n\t\t$(this).css(\"width\", fullViewScrollerWidth);\n\n\t});\n\tvar childWidth = 100 / count + \"%\";\n\n\t$(\"[data-child = \" + noteType +\"]\").each(function(index, value) {\n\t\t\n\t\t$(this).css(\"width\", childWidth);\n\t});\n}\n\nfunction loadClinicalNotes(filterBy,viewPage,finalStartDate,finalEndDate,encounterID){\n\tif(filterBy == \"A\")\n\t{\t\n\t\tclinicalNotesFilterBy = \"\";\n\t}\n\telse if(filterBy == \"N\")\n\t{\t\t\n\t\tif(clinicalNotesFilterBy != null  &&  clinicalNotesFilterBy.length > 0 && clinicalNotesFilterBy.indexOf(\"NUR$\") == -1 )\n\t\t{\n\t\t\tclinicalNotesFilterBy = clinicalNotesFilterBy + \",NUR$\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tclinicalNotesFilterBy = \"NUR$\";\n\t\t}\n\t}\n\telse if(filterBy == \"P\")\n\t{\n\t\tif(clinicalNotesFilterBy != null && clinicalNotesFilterBy.length > 0 && clinicalNotesFilterBy.indexOf(\"PHY$\") == -1)\n\t\t{\n\t\t\tclinicalNotesFilterBy = clinicalNotesFilterBy + \",PHY$\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tclinicalNotesFilterBy = \"PHY$\";\n\t\t}\n\t}\n\telse if(filterBy == \"C\")\n\t{\n\t\tif(clinicalNotesFilterBy != null && clinicalNotesFilterBy.length > 0 && clinicalNotesFilterBy.indexOf(\"CLI$\") == -1)\n\t\t{\n\t\t\tclinicalNotesFilterBy = clinicalNotesFilterBy + \",CLI$\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tclinicalNotesFilterBy = \"CLI$\";\n\t\t}\n\t}\n\telse\n\t{\n\t\tclinicalNotesFilterBy = \"\";\n\t}\n\t\n\tvar firstClick=false;\n\tvar splAvailable=null\t;\n\tif($(\"[filter-type=\"+filterBy+\"]\").hasClass(\'notesIconSelectedTheme\'))\n\t{\n\t\tfirstClick=true;\n\t\tclinicalNotesFilterBy = \"\";\n\t\tsplAvailable=\"\";\n\t\t$(\".dataContainerFullView\").show();\t\t\t\n\t\t$(\"#CNdivcnt\").find(\".clinicalNotesContent\").show();  \n\t}\n\telse\n\t{\n\t\tsplAvailable=viewPage;\t\t\n\t\t$(\"#CNdivcnt\").find(\".clinicalNotesContent\").show();  \n\t}\n\t\nif(viewPage==\'widgetView\'){\t\n     \t$(\"#clinicalNotesFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\t\n\t    $(\"#clinicalNotesFrame\").load( path + \"/mobile/chartsummary/ClinicalNotesView?viewPage=widgetView&filterBy=\" +clinicalNotesFilterBy,function(){\n\t\tscrollerRefresh(CSMainScroll);\n\t\tbclinicalNotesLoaded = true;\n\t\tbfullViewOpen = false;\n\t\tcnNoteType = \"\";\n\t\tbAccordionViewLoaded = false;\n\t\tcurrentNotesHScrollingId = \"\";\n\t\tarrCnVisitedPages = null;\n\t\tarrCnVisitedPages = [];\n\t\tcnCurrentPage = 0;\n\t\t\n\t\t$(\"[data-filterIcon = \'T\']\").each(function(index, value) {\n\t\t\tif($(this).attr(\'filter-type\') != filterBy){\n\t\t\t\t$(this).removeClass(\"notesIconSelectedTheme\");\n\t\t\t}\n\t\t\t});\n\t\t\t\n\t\t\t\n\t\tif(firstClick){\n\t\t\t\n\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").removeClass(\"notesIconSelectedTheme\");\n\t\t\t\t}else{\n\t\t\t\t\t\n\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").addClass(\"notesIconSelectedTheme\");\n\t\t}\n\t\t\n\t});\n\t}\n\t\nelse\n{\n\t$(\"#clinicalNotesFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t$(\"#clinicalNotesFrame\").load( path + \"/mobile/chartsummary/ClinicalNotesView?viewPage=widgetView&filterBy=\" +clinicalNotesFilterBy,function(){\n\t\tscrollerRefresh(CSMainScroll);\n\t\tbclinicalNotesLoaded = true;\n\t\tbfullViewOpen = false;\n\t\tcnNoteType = \"\";\n\t\tbAccordionViewLoaded = false;\n\t\tcurrentNotesHScrollingId = \"\";\n\t\tarrCnVisitedPages = null;\n\t\tarrCnVisitedPages = [];\n\t\tcnCurrentPage = 0;\n\t\t\n\t\t\n\t\tvar arrSPL =[];\t\t\t\n\t\t$(\".dataContainerFullView\").hide();\n\t\tarrSPL.push(splAvailable); \n\t\tif(splAvailable)\n\t\t{\n\t\t\tvar specialityCount = document.getElementById(\"hdnCount\").value;\n\t\t\tfor(var i=0; i<specialityCount; i++){\n\t\t\t\tvar noteType = document.getElementById(\"hdnSpeciality\"+i).value;\n\t";
    private final static byte[]  _wl_block19_0Bytes = _getBytes( _wl_block19_0 );

    private final static java.lang.String  _wl_block19_1 ="\t\t\t$(\'.dataContainerFullView[data-notetype=\'+noteType+\']\').show();\n\t\t\t}\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\n\t\t\t$(\".dataContainerFullView\").each(function(){\n\t\t\t\t$(this).show();\n\t\t\t});\n\t\t}\n\t\n\t\t$(\"[data-filterIcon = \'T\']\").each(function(index, value) {\n\t\t\t\tif($(this).attr(\'filter-type\') != filterBy)\n\t\t\t\t{\n\t\t\t\t\t$(this).removeClass(\"notesIconSelectedTheme\");\n\t\t\t\t}\n\t\t\t});\n\t\t\tif(firstClick){\n\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").removeClass(\"notesIconSelectedTheme\");\n\t\t\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").addClass(\"notesIconSelectedTheme\");\n\t\t\t\t\t\n\t\t\t}\n\t\thideNoteAndBubbles();\n\t\t //var splWidgetCount =$(\'.clinicalNotesContent:visible\').length; dataContainerFullView\n\t\t //$(\'#ClinicalNotesCountBtn\').val(splWidgetCount);\n\t\t \n\t\t if(filterBy == \"SPL\"){\n\t\t var splWidgetCount =$(\'.dataContainerFullView:visible\').length; \n\t\t $(\'#ClinicalNotesCountBtn\').val(splWidgetCount);\n\t\t }\n\t\t\n\t\tif($(\'.clinicalNotesContent:visible\').length >= 1){\n\t\t\t$(\'.mySpecialityNoRecords\').hide();\n\t\t\tscrollerRefresh(CSMainScroll)\n\t\t}else{\n\t\t\t$(\'.mySpecialityNoRecords\').show();\n\t\t\tscrollerRefresh(CSMainScroll)\n\t\t}\n\t});\n\t\n}\n   hideNoteAndBubbles();\n   clinicalNotesFilterBy = \"\";// clear all exist filters\n\n}\nfunction hideNoteAndBubbles(){\n\t$(\".clinicalNotesContent\").each(function (i,v ){\n\t\t\t\t if ($(this).find(\".dataContainerFullView:visible\").length == 0)\n\t\t\t\t {\n\t\t\t\t\t$(this).hide();\n\t\t\t\t }\n\t\t\t\t else{\n\t\t\t\t\t $(this).show();\n\t\t\t\t }\t \n\t\t\t});\n\t\t\t$(\".bubbleDivider\").each(function (i,v ){\n\t\t\t\tif($(this).prevUntil(\".bubbleDivider\").is(\":visible\") && $(this).nextUntil(\".bubbleDivider\").is(\":visible\") ){\n\t\t\t\t\t$(this).show();\n\t\t\t\t}else{\n\t\t\t\t\t$(this).hide();\n\t\t\t\t}\n\t\t\t});\n}\n\nfunction userInstances(){\n\t\n\tthis.userInsName=\"\";\n\tthis.userInsCont=\"\";\n\t\n}\n\nfunction checkForUndefined(userValue){\n\t\n\tif(userValue==undefined){\n\t\t\n\t\tuserValue=\"0\";\n\t}\n\t\n\treturn userValue;\n}\n\nfunction updateWidgetItemsCount(){\n \n var ClinicalNotesCount =$(\"#ClinicalNotesCountBtn\").val();\n console.log(\"ClinicalNotesCount:\"+checkForUndefined(ClinicalNotesCount));\n $(\"#countDisplayNOTES\").text(checkForUndefined(ClinicalNotesCount));\n\t//clicnical notes\n\t\n\t//ClinicalNotesCountBtn\n\t\n\t var allergyCount =$(\"#allergyViewCount\").val();\n\t console.log(\"allergyCount:\"+checkForUndefined(allergyCount));\n\t$(\"#countDisplayALLERGY\").text(checkForUndefined(allergyCount));\n\t//allergy\n\t\n\t//allergyViewCount\n\t\n\t\n\tvar procedureDetailsCount =$(\"#procedureDetailsViewCount\").val();\n\tconsole.log(\"procedureDetailsCount:\"+checkForUndefined(procedureDetailsCount));\n\t$(\"#countDisplayPROCEDURE\").text(checkForUndefined(procedureDetailsCount));\n\t//procedure details viewPage\n\t\n\t//procedureDetailsViewCount\n\t\n\t\n\tvar activeProblemCount =$(\"#activeProblemViewCount\").val();\n\tconsole.log(\"activeProblemCount:\"+checkForUndefined(activeProblemCount));\n\t$(\"#countDisplayPROBLEMS\").text(checkForUndefined(activeProblemCount));\n\t//active problem\n\t\n\t//activeProblemViewCount\n\t\n\t\n\tvar resultsCount =$(\"#resultsViewCount\").val();\n\tconsole.log(\"resultsCount:\"+checkForUndefined(resultsCount));\n\t$(\"#countDisplayRESULTS\").text(checkForUndefined(resultsCount));\n\t//Results \n\t\n\t//resultsViewCount\n\t\n\tvar pendingOrderCount =$(\"#pendingOrderViewCount\").val();\n\tconsole.log(\"pendingOrderCount:\"+checkForUndefined(pendingOrderCount));\n\t$(\"#countDisplayPENDINGORDERS\").text(checkForUndefined(pendingOrderCount));\n\t//pending Order\n\t\n\t//pendingOrderViewCount\n\tvar currentMedicationCount =$(\"#currentMedicationViewCount\").val();\n\tconsole.log(\"currentMedicationCount:\"+checkForUndefined(currentMedicationCount));\n\t$(\"#countDisplayMEDICATIONS\").text(checkForUndefined(currentMedicationCount));\n\t//current medication\n\t\n\t//currentMedicationViewCount\n\n}\n\n$(document).ready(function(){\n\t\n\t//var allAddedCount=[];\n\t\n\t$(\"#userPrefernceMainWrapper\").hide();\n\t\n\tparent.setOnLoadContentPaneHeight();\n\tpath = $(\'#hdnPath\').val();\n\t$(\"#VitalsFrame\").load(path + \"/LatestVitals?isRankRequired=S&fromScreen=CV\" ,function(response, status, xhr){\n\t\t//alert(\"hi\");\n\t\t//alert(status);\n\t\t//alert(xhr.statusText);\n\t\tif(status == \"error\")\n\t\t{\n\t\t\t$(\"#transactionMessageContent\").append(\"Error in Loading Vitals View\");\n\t\t\t\n\t\t\t$(\"#transactionMsg\").attr(\"class\" , \"formValErrorTheme CSTransactionMessage\");\n\t\t\tshowTransactionMessage();\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//allAddedCount.push();\n\t\t\tupdateWidgetItemsCount();\n\t\t\tscrollerRefresh(CSMainScroll);\n\t\t\tbVitalsLoaded = true;\n\t\t}\n\n\t});\n\tvar scrollToWidget = $(\"#scrollToWidget\").val();\n\t$(\"#AllergyWidgetframe\").append(\"<div class=\'loadSpinner\'></div>\");\n\t$(\"#AllergyWidgetframe\").load( path + \"/chartsummary/AllergyServlet\",function(){\n\t\tupdateWidgetItemsCount();\n\t\tscrollerRefresh(CSMainScroll);\n\t});\n\t$(\"#procWidgetframe\").append(\"<div class=\'loadSpinner\'></div>\");\n\t$(\"#procWidgetframe\").load( path + \"/mobile/chartsummary/ProcedureView\",function(){\n\t\tupdateWidgetItemsCount();\n\t\tscrollerRefresh(CSMainScroll);\n\t});\n\t$(\"#ProblemsDiagnosisWidgetframe\").append(\"<div class=\'loadSpinner\'></div>\");\n\t$(\"#ProblemsDiagnosisWidgetframe\").load( path + \"/mobile/chartsummary/ProblemsDiagnosisView\",function(){\n\t\tupdateWidgetItemsCount();\n\t\tscrollerRefresh(CSMainScroll);\n\t\tsetTimeout(function () {\n\t\tif(scrollToWidget && scrollToWidget==\"APD\"){\n\t\t\tCSMainScroll.scrollToElement(\".ProblemsDiagnosisWidgetframe\",0);\n\t\t}\n\t\t}, 100);\n\t});\n\t$(\"#ResultsWidgetframe\").append(\"<div class=\'loadSpinner\'></div>\");\n\t$(\"#ResultsWidgetframe\").load( path + \"/mobile/chartsummary/ResultsView\",function(){\n\t\tupdateWidgetItemsCount();\n\t\tscrollerRefresh(CSMainScroll);\n\t});\n\t$(\"#PendingOrdersframe\").append(\"<div class=\'loadSpinner\'></div>\");\n \t$(\"#PendingOrdersframe\").load( path + \"/mobile/chartsummary/PendingOrdersView\",function(){\n\t\tupdateWidgetItemsCount();\n\t\tscrollerRefresh(CSMainScroll);\n\t});\n\t$(\"#CurrentMedicationFrame\").append(\"<div class=\'loadSpinner\'></div>\");\n \t$(\"#CurrentMedicationFrame\").load( path + \"/mobile/chartsummary/CurrentMedicationView?filterByVal=all\",function(){\n\t\tupdateWidgetItemsCount();\n\t\tscrollerRefresh(CSMainScroll);\n\t});\n\tloadClinicalNotes(\"A\");//cn\t\n\tif(transactionOccured){\n\t\tshowTransactionMessage();\n\t}\n\n});\n\nfunction scrollerRefresh(scroller){\n\tif(scroller != null){\n\t\tscroller.refresh();\n\t}\n\t\n}\nvar width;\nfunction assignSliderWidth()\n{\t\n\t$(\".swipeWrapper\").each(function(index, value) {  \n\t\t$(this).css(\"width\",\"200px\"); // assigning dummy width.\n\t\n\t});\n   // var notesScrollerWidth = 0;\n\t$(\".swipeTable\").each(function(index, value) {      \n\t\tvar contentCount =  $(this).attr(\'data-count\');\n\t\t//var noteTypeValue = $(this).attr(\'data-noteType\');\n\t\t width = $(this).width() - $(\"[data-content = \'\" + contentCount + \"\']\").width();\n\t\t\n\t\t$(\".swipeWrapper\").each(function(index, value) {  \n\t\t\t$(this).css(\"width\",width);\n\t\t\tvar idCount = $(this).attr(\'data-IdCount\');\n\t\t\n\t\t});//swipewrapper\n\t\t\n    });//swipetable\n\n}\nfunction setScrollerWidth()\n{\n\tvar swipecount = 1;\n\t$(\".swipeWrapper\").each(function(index, value) {  \t\n\t\tvar idCount = $(this).attr(\'data-IdCount\');\n\t\tvar noteTypeValue = $(this).attr(\'data-noteType\');\n\t\tvar noteScrollerWidth = 0;\n\t\t\n\t\t$(\"[data-noteTypeValue = \'\" + noteTypeValue + \"\']\").each(function(index, value) { \n\t\t\tnoteScrollerWidth = noteScrollerWidth + $(this).width();\n\t\t\tswipecount++;\n\t\t});//notetype\n\t\tif(noteScrollerWidth < width)\n\t\t\tnoteScrollerWidth = width  + \"px\";\n\t\telse\n\t\t\tnoteScrollerWidth =  noteScrollerWidth  + swipecount * 8+\"px\";\n\t\t\t\t\n\t\t$(\'#notesScroller\' + idCount).css(\"width\",noteScrollerWidth);\n\t\t//noteScrollerWidth = 0;\n\t});//swipewrapper\n}\nfunction changeOrientation(orient, EMHFheight)\n{\n\tbOrientationChanged = true; //cn\n\tvar CSHFheight = $(\'#CSHeader\').height() + $(\'#CSFooter\').height();\n\tvar content_height = parent.getTotalPageDivHeight()  - EMHFheight - CSHFheight - 10;//margin 5px\n\tdocument.getElementById(\"ChartSummaryMainWrapper\").style.height = content_height+\"px\";\n\t\n\t\n\tif(bVitalsLoaded)\n\t{\n\t\t$(\"#vitalsSwipeWrapper\").css(\"width\" , \"10px\");\n\t}\n\t/*\n\tif(CSMainScroll != null)\n\t\tCSMainScroll.refresh();\n\t*/\n\tif(bclinicalNotesLoaded)\n\t{\n\t\tassignSliderWidth();\n\t\tsetScrollerWidth();\n\t\tif(myScrollnotes != null)\n\t\t{\n\t\t\tmyScrollnotes.refresh();\t\n\t\t}\n\t\t//alert(notesHorizontalScroll);\n\t\tif(bAccordionViewLoaded)\n\t\t{\n\t\t\t//accordionNotesViewDimensions(cnNoteType);\n\t\t}\n\t\tif(notesHorizontalScroll != null)\n\t\t{\n\t\t\t//accordionNotesViewDimensions(cnNoteType);\n\t\t\t//alert(notesHorizontalScroll.currPageX);\n\t\t\tnotesHorizontalScroll.refresh();\n\t\t\tnotesHorizontalScroll.scrollToPage(cnCurrentPage,0);\n\t\t\t//alert(notesHorizontalScroll.currPageX);\n\t\t}\n\t}\n\tif(bVitalsLoaded)\n\t{\n\t\tassignVitalsWrapperWidth();\n\t\tassignVitalsScrollerWidth();\n\t\tif(vitalsScroll != null)\n\t\t{\n\t\t\tvitalsScroll.refresh();\t\n\t\t}\n\t\t\n\t}\n\tif(CSMainScroll != null)\n\t\tCSMainScroll.refresh();\n}\nfunction showTransactionMessage(){\n\t$(\"#transactionMsg\").show();\n\tsetTimeout(function(){\n\t\t$(\"#transactionMsg\").hide();\n\t},5000);\n\t$(\"#transactionMsg\").bind(\'click\',function(){\n\t\t$(this).hide();\n\t});\n}\n\nvar transactionOccured = false;\nfunction closeChartSummary(){\n\tparent.closeChartSummary();\n\t\n}\nvar EncListScroll;\nfunction toggleEncListPopup(){\n\tif(EncListScroll == null){\n\t\tEncListScroll = new iScroll(\'EncListcontainer-wrapper\', {\n\t\t\tuseTransform : true,\n\t\t\tzoom : false,\n\t\t\tonBeforeScrollStart : function(e) {\n\t\t\t\tvar target = e.target;\n\t\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\t\n\t\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' ){\n\t\t\t\t\te.preventDefault();\n\t\t\t\t}\n\t\n\t\t\t\te.stopPropagation();\n\t\t\t}\n\t\t});\n\t}\n\t$(\"#EncListPopup\").toggle();\n\tif($(\'#EncListPopup\').is(\':visible\')){\n\t\t$(\'#dvMez\').show();\n\t\t$(\"#dvMez\").data(\"popid\",\"EncListPopup\");\n\t\tsetTimeout(function() {\n\t\t\t$(\"#dvMez\").on(\"click\",closeMez);\n\t\t}, 500);\n\t}\n\tif($(\'#EncListPopup\').is(\':hidden\')){\n\t\t$(\'#dvMez\').hide();\n\t\t$(\"#dvMez\").data(\"popid\",\"\");\n\t\t$(\"#dvMez\").off();\n\t}\n\tif(EncListScroll!=null && $(\'#EncListPopup\').is(\':visible\')){\n\t\tEncListScroll.refresh();\n\t}\n\n}\nfunction closeMez(){\n\tvar popid = $(\"#dvMez\").data(\"popid\");\n\t$(\"#\"+popid).hide();\n\t$(\"#dvMez\").hide();\n\t$(\"#dvMez\").off();\n}\n\nfunction chooseEncounter(encIdSelected){\n\tparent.chooseEncounter(encIdSelected);\n}\n\nfunction chooseEncounterForNote(encIdSelected, openingPage){\n\t parent.chooseEncounterForNote(encIdSelected,openingPage);\n}\n\nfunction closePopup(popupId){\n\tvar popupObj = $(\"#\"+popupId);\n\t$(\"#dvMez\").hide();\n\t$(\"#dvMez\").data(\"popid\",\"\");\n\t$(popupObj).hide();\n\t$(\"#dvMez\").off();\n}\n\nfunction openOrdersFrame(){\n\t$(\"#PageLoadingAnimation\").show();\n\twindow.location.replace(path+\"/mobile/charts/orders/MNewOrderServlet\");\n}\nfunction openChartSummaryFrame(){\n\t$(\"#PageLoadingAnimation\").show();\n\twindow.location.replace(path+\"/mobile/chartsummary/ChartWidgetsView\");\n}\nfunction openClinicalNotes(){\n\t$(\"#PageLoadingAnimation\").show();\t\n\twindow.location.replace(path+\"/mobile/charts/notes/OpenClinicalNoteServ";
    private final static byte[]  _wl_block19_1Bytes = _getBytes( _wl_block19_1 );

    private final static java.lang.String  _wl_block19_2 ="let\"); \n\n}\nfunction openClinicalEvents(){\n\t$(\"#PageLoadingAnimation\").show();\n\t//window.parent.$(\'#hdnopeningPage\').val(\'clinicalEvents\');\n\t//window.parent.$(\"#ChartsBaseForm\").submit();\n\twindow.location.replace(path+\"/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventsBasePage.jsp\"); \n}\nfunction openPharmacyOrders(){\n\t$(\"#PageLoadingAnimation\").show();\n\tparent.openPharmacyOrders();\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\n#ChartSummaryMainWrapper .loadSpinner {\n\twidth: 100%;\n\theight: 80px;\n\tbackground-image: url(";
    private final static byte[]  _wl_block19_2Bytes = _getBytes( _wl_block19_2 );

    private final static java.lang.String  _wl_block20 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\tposition:static;\n}\n</style>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<script>\n\t\t\ttransactionOccured = true;\n\t</script>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" \n\n\n</head>\n<body style=\"display: block; margin: 0px; height: 100%; width: 100%;\">\n<div id=\"PageLoadingAnimation\" class=\"absoluteCenter\"></div>\n\t<div class = \"ChartSummaryParent ChartSummaryParentTheme\" data-role=\"page\">\n\t\t<div class=\"ChartSummaryBlock\" id=\"ChartSummaryBlock\" data-role = \"none\">\n\t\t\t<form id=\"ChartSummaryForm\" name = \"ChartSummaryForm\" method = \"post\" action = \"\" class=\"ChartSummaryFormElem\">\n\t\t\t\t<div class=\"ChartSummaryMainTable\" style=\"position:relative;\" data-role = \"none\">\n\t\t\t\t\t<div data-role = \"none\" class =\"ChartSummaryPageHeader\" id=\"CSHeader\">\n\t\t\t\t\t\t<div class=\"ChartSummaryHeaderCell\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderCont\" data-role = \"none\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!-- Encounter popup starts -->\n\t\t\t\t\t\t\t\t<div id=\"EncListPopup\" class=\"EncListPopParentContainer\">\n\t\t\t\t\t\t\t\t\t<div class=\"EncListPopupArrowUpTheme\"></div>\n\t\t\t\t\t\t\t\t\t<div class=\"EncListAreaContainer EncListAreaContainerTheme\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n<!-- \t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\n\t\t\t\t\t\t\t\t\t\t\t\tHeader starts here\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" class=\"EncPopHeaderHeader EncPopHeaderHeaderTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:25%;vertical-align:middle;text-align:center\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopHeaderButtonTheme\" style=\"text-align:center\" onclick=\"hideEncListPopup()\">Cancel</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopHeaderTextTheme\" style=\"display:table-cell;vertical-align:middle;width:50%\">Encounter</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:25%;vertical-align:middle;text-align:center\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopHeaderButtonTheme\" style=\"text-align:center\" onclick=\"chooseEncounter(\'\')\">Current</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\theader ends here\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t\t\t\t\t<!-- <div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\n\t\t\t\t\t\t\t\t\t\t\t\tSlider for Patient class filter starts here\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopClassFilterContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;\" class=\"EncPopSliderContainerTheme EncPopSliderContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\tSlider for Patient class filter starts here\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t<!--All Encounters List content starts here-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopCurrentEncContainerTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\" class=\"EncPopCurrentEncStripTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Current/Base Encounter item starts -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\"  onclick=\"chooseEncounter(\'\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row;\" class=\"EncPopListRow\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListIconCol\"><img src=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/eIPAD/images/OutPatient32x32.png\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListDetCol\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopCurPractTextTheme\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopCurIdTextTheme\">EN ID - ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:bottom;text-align:right\"><div  class=\"EncPopCurDateTextTheme\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListIconCol\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Current/Base Encounter item ends -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Other Encounter items scroller starts-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"EncListcontainer-wrapper\" class=\"EncListPopupWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"EncListcontainer-contents\" class=\"EncListPopupScroller\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Other Encounter items starts -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onclick=\"chooseEncounter(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row;\" class=\"EncPopListRow\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListIconCol\"><img src=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="/eIPAD/images/OutPatient32x32.png\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListDetCol\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopPractTextTheme\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopIdTextTheme\">EN ID - ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:bottom;text-align:right\"><div  class=\"EncPopDateTextTheme\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListIconCol\"><img src=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="/eIPAD/images/Right_Arrow.png\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Other Encounter items ends -->\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Other Encounter items scroller ends  -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<!--All Encounters List content ends here -->\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<!-- Encounter popup ends -->\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderTable ChartSummaryHeaderTableTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderIconCol\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" id=\"userPrefrences\" onclick=\"userPreferedClick();\"><img src=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="/eIPAD/images/MenuIcon.png\"></div>\n\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderTextCol\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderText ChartSummaryHeaderTextTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</div><!-- TODO replace with message bundle text -->\n\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncLeftCol\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" data-role = \"none\" onclick=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"><img src=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="/eIPAD/images/Previous16x16.png\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncListCol\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncList ChartSummaryHeaderEncListTheme\" data-role = \"none\" style=\"display:table\" onclick=\"toggleEncListPopup()\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncLstContainer\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncIDLabel\" data-role = \"none\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" - </div> <!-- TODO replace with localized text -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncID\" data-role = \"none\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =",</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncPatClass\" data-role = \"none\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" - </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncPracName\" data-role = \"none\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncCount\" data-role = \"none\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="0";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="/";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncDrpIcon\" data-role = \"none\"><img src=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="/eIPAD/images/Down12x12.png\" class=\"ChartSummaryHeaderEncDrpImg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncRightCol\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="/eIPAD/images/Next16x16.png\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"closeChartSummary()\"><img src=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="/eIPAD/images/CS_Close16x16.png\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageContent ChartSummaryPageContentTheme\" id=\"ChartSummaryPageContent\">\n\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageContentCell\">\n\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryMainWrapper\" id=\"ChartSummaryMainWrapper\" style=\" overflow:hidden;position:relative\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t   <div class=\"ChartSummaryMainScroller\" style=\"width:100%;overflow:hidden\" data-role = \"none\"><!-- scrolling content starts -->\n\t\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" id = \"VitalsFrame\" class=\"ChartWidgetframe VITALS\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"AllergyWidgetframe\" class=\"ChartWidgetframe ALLERGY\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"procWidgetframe\" class=\"ChartWidgetframe PROCEDURE\" data-role = \"none\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ProblemsDiagnosisWidgetframe\" class=\"ChartWidgetframe PROBLEMS ProblemsDiagnosisWidgetframe\" data-role = \"none\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"clinicalNotesFrame\" class=\"ChartWidgetframe NOTES\" data-role = \"none\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ResultsWidgetframe\" class=\"ChartWidgetframe RESULTS\" data-role = \"none\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"PendingOrdersframe\" class=\"ChartWidgetframe PENDINGORDERS\" data-role = \"none\" style = \"padding:0px\"></div>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"CurrentMedicationFrame\" class=\"ChartWidgetframe MEDICATIONS\" data-role = \"none\" style = \"padding:0px\"></div>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" id = \"VitalsFrame\" class=\"ChartWidgetframe\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t<div id=\"AllergyWidgetframe\" class=\"ChartWidgetframe\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t<div id=\"procWidgetframe\" class=\"ChartWidgetframe\" data-role = \"none\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t<div id=\"ProblemsDiagnosisWidgetframe\" class=\"ChartWidgetframe ProblemsDiagnosisWidgetframe\" data-role = \"none\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t<div id=\"clinicalNotesFrame\" class=\"ChartWidgetframe\" data-role = \"none\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t<div id=\"ResultsWidgetframe\" class=\"ChartWidgetframe\" data-role = \"none\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t<div id=\"PendingOrdersframe\" class=\"ChartWidgetframe\" data-role = \"none\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t<div id=\"CurrentMedicationFrame\" class=\"ChartWidgetframe\" data-role = \"none\" style = \"padding:0px\"></div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t</div><!-- scrolling content ends -->\n\t\t\t\t\t\t\t\t<div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" onclick=\"closeMez()\" data-popid=\"\"></div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup - STARTS -->\n\t\t\t\t\t\t\t\t<div id=\"CSCommonPopUpContainer\" class=\"CSCommonPopUpContainer\">\n\t\t\t\t\t\t\t\t\t<!-- <div id=\"CSCommonPopUpContainer-arrowUp\" class=\"CSCommonPopup-arrowUpTheme\"></div> -->\n\t\t\t\t\t\t\t\t\t<div  class=\"CSCommonPopup CSCommonPopupTheme\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;height:40px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table\" class=\"CSCommonPopupHeader CSCommonPopupHeaderTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:100px;vertical-align:middle;text-align:left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"CSCommonPopupCloseBtnTheme\" id=\"CSCommonPopupCloseBtn\" onclick=\"closePopup(\'CSCommonPopUpContainer\')\">Close</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:80%;vertical-align:middle;text-align:center;padding-right:150px;\" class=\"CSCommonPopupHeaderTextTheme\" id=\"CSCommonPopUpContainer-title\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row; \">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SFSBackgroundTheme\" style=\"display:table-cell;/* width:100% */;\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"CSCommonPopUpContainer-wrapper\" class=\"CSCommonPopupWrapper\" style=\"margin:10px;background:#fff;height:332px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"CSCommonPopUpContainer-scroller\" class=\"CSCommonPopupScroller\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"CSCommonPopUpContainer-contents\" class=\"CSCommonPopupContents\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<!-- <div id=\"CSCommonPopUpContainer-arrowDown\" class=\"CSCommonPopup-arrowDownTheme\"></div> -->\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup - ENDS-->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!-- Transaction message -->\n\t\t\t\t\t\t\t\t<div class=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" CSTransactionMessage\" id=\"transactionMsg\" style=\"bottom: 10px; left: 10px; display: none\">\n\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id = \"transactionMessageContent\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<!-- End of Transaction message -->\n\t\t\t\t\t\t\t\t<div class=\" CSTransactionMessage\" id=\"transactionMsg_userpref\" style=\"bottom: 10px; left: 10px; display: none;z-index:10000\">\n\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id = \"transactionMessageContent_userpref\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooter\"  id=\"CSFooter\">\n\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterCell\">\n\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterCont\">\n\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterTable ChartSummaryPageFooterTableTheme\">\n\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterRow\">\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterFirstCol\" style=\"\"></div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnSelTheme\" onclick=\"openChartSummaryFrame()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openClinicalNotes()\"><!-- openClinicalNotes() -->\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\"> Clinical<br/>Notes</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openOrdersFrame()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openClinicalEvents()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">Clinical Events</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openPharmacyOrders()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">Pharmacy Order</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterLastCol\" style=\"\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div data-role = \"none\" class = \"userPrefernceMainWrapper\" id=\"userPrefernceMainWrapper\" \n\t\t\t\tstyle=\"top:42px;bottom:0px;left: 0;z-index: 6000;overflow: hidden;position: absolute;margin-left: 0px;width: 100%;display: table-row;\">\n\t\t\t\t</div>\n\t\t\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" />\n\t\t\t\t<input type = \"hidden\" name = \"scrollToWidget\" id = \"scrollToWidget\" value =\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" />\n\n\t\t\t</form>\n\t\t</div>\n\t</div>\n\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block3Bytes, _wl_block3);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
String scrollToWidget = request.getParameter("scrollToWidget")==null?"":request.getParameter("scrollToWidget");

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19_0Bytes, _wl_block19_0);
            _bw.write(_wl_block19_1Bytes, _wl_block19_1);
            _bw.write(_wl_block19_2Bytes, _wl_block19_2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);

TransactionResponse transactResp;
String formValErrClass = "";
String transactMsg = "";
if(request.getAttribute("TRANSACTION_RESPONSE") != null){
            _bw.write(_wl_block21Bytes, _wl_block21);

	transactResp = (TransactionResponse)request.getAttribute("TRANSACTION_RESPONSE");
	ArrayList<ErrorInfo> errorList = transactResp.getErrorsList();
	for(ErrorInfo e:errorList){
		transactMsg = transactMsg + e.getErrorMessage() + " ";
	}
	if(transactResp.getTransactionResult() == TransactionResponse.SUCCESS){ 
		formValErrClass= "formValSuccessTheme";
	}
	else{
		formValErrClass= "formValErrorTheme";
	}
}

EncounterListResponse allEncountersResp = (EncounterListResponse)request.getAttribute("EncounterListResponse");
ArrayList<EncounterHO> allEncArrayList = new ArrayList<EncounterHO>();
EncounterHO currentEncounter = new EncounterHO();
if(allEncountersResp!=null && allEncountersResp.isSuccessResponse() && !allEncountersResp.isEmptyDataResponse()){
	allEncArrayList = allEncountersResp.getEncounterList();
	currentEncounter = allEncArrayList.get(0);
}
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String selectedEncounter = "";
boolean secondaryEncSelected = false;
int selectedEncIndex = 0;
if(patientContext.getSelectedEncounterId()!= null && !patientContext.getSelectedEncounterId().equals("")){
	selectedEncounter = patientContext.getSelectedEncounterId();
	secondaryEncSelected = true;
}

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(currentEncounter.getPractShortName()));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(currentEncounter.getEncounterId()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(currentEncounter.getFromDate() ));
            _bw.write(_wl_block26Bytes, _wl_block26);
if(allEncArrayList!=null && allEncArrayList.size()>1){
																		
            _bw.write(_wl_block27Bytes, _wl_block27);
for(int i=1;i<allEncArrayList.size();i++){ 
																			EncounterHO iEncounter = allEncArrayList.get(i);
																			String cssClassName = "EncPopNormEncStripTheme";
																			if(secondaryEncSelected && selectedEncounter.equals(iEncounter.getEncounterId())){
																				cssClassName = "EncPopSelEncStripTheme";
																				selectedEncIndex = i;
																			}
																			
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(cssClassName ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iEncounter.getEncounterId()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(iEncounter.getPractShortName()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(iEncounter.getEncounterId()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(iEncounter.getFromDate() ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block35Bytes, _wl_block35);

																			}
																			
																			
            _bw.write(_wl_block36Bytes, _wl_block36);
} 
            _bw.write(_wl_block37Bytes, _wl_block37);
 
									String encLeftNaviStyle = "WidgetButtonTheme";
									String encRightNaviStyle = "WidgetButtonTheme";
									String encLeftNaviClickFunc = "";
									String encRightNaviClickFunc = "";
									if(selectedEncIndex <= 0){
										encLeftNaviStyle = "WidgetButtonDisableTheme";
									}
									//select base encounter
									else if(selectedEncIndex == 1){
										encLeftNaviClickFunc = "chooseEncounter('')";
									}
									else{
										encLeftNaviClickFunc = "chooseEncounter('"+allEncArrayList.get(selectedEncIndex-1).getEncounterId()+"')";
									}
									if(selectedEncIndex+1 >= allEncArrayList.size()){
										encRightNaviStyle = "WidgetButtonDisableTheme";
									}
									else{
										encRightNaviClickFunc = "chooseEncounter('"+allEncArrayList.get(selectedEncIndex+1).getEncounterId()+"')";
									}
								
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(csResBundle.getString("common.chartSummary") ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(encLeftNaviStyle ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encLeftNaviClickFunc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            _bw.write(_wl_block45Bytes, _wl_block45);
            _bw.write(_wl_block46Bytes, _wl_block46);
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(csResBundle.getString("common.enId") ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(allEncArrayList.get(selectedEncIndex).getEncounterId()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(allEncArrayList.get(selectedEncIndex).getPatientClass()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(allEncArrayList.get(selectedEncIndex).getPractShortName()));
            _bw.write(_wl_block51Bytes, _wl_block51);
if(selectedEncIndex+1<10){
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            out.print( String.valueOf(selectedEncIndex+1));
            _bw.write(_wl_block53Bytes, _wl_block53);
if(allEncArrayList.size()<10){
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            out.print( String.valueOf(allEncArrayList.size()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(encRightNaviStyle ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encRightNaviClickFunc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block57Bytes, _wl_block57);

									WidgetOrderBC bc = new WidgetOrderBC();
									
									
									 
									 
									WidgetOrderResponse widgetOrderResp = bc.getUserWidgetOrder(patientContext);
									if(widgetOrderResp.isSuccessResponse()){
										ArrayList<WidgetItems> activeWidgets = widgetOrderResp.getActiveWidgets();
										for(int x=0;x<activeWidgets.size();x++){
											WidgetItems currentItem = activeWidgets.get(x); 
											if(currentItem.getWidgetId().equals(WidgetItems.VITALS.getWidgetId())){
									
            _bw.write(_wl_block58Bytes, _wl_block58);

											}
											else if(currentItem.getWidgetId().equals(WidgetItems.ALLERGY.getWidgetId())){
									
            _bw.write(_wl_block59Bytes, _wl_block59);
			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.PROCEDURE.getWidgetId())){
									
            _bw.write(_wl_block60Bytes, _wl_block60);
			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.PROBLEMS.getWidgetId())){
									
            _bw.write(_wl_block61Bytes, _wl_block61);
			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.NOTES.getWidgetId())){
									
            _bw.write(_wl_block62Bytes, _wl_block62);
			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.RESULTS.getWidgetId())){
									
            _bw.write(_wl_block63Bytes, _wl_block63);
			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.PENDINGORDERS.getWidgetId())){
									
            _bw.write(_wl_block64Bytes, _wl_block64);
			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.MEDICATIONS.getWidgetId())){
									
            _bw.write(_wl_block65Bytes, _wl_block65);
			
											}
									
            _bw.write(_wl_block66Bytes, _wl_block66);

										}
									}
									else{ 
            _bw.write(_wl_block67Bytes, _wl_block67);
} 
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(formValErrClass ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(transactMsg ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(csResBundle.getString("common.chartSummary") ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(csResBundle.getString("common.order") ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(scrollToWidget ));
            _bw.write(_wl_block74Bytes, _wl_block74);
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
