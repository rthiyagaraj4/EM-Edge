package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import eIPAD.chartsummary.common.response.TransactionResponse;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;

public final class __clinicalnotesbasepage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/ClinicalNotesBasePage.jsp", 1709118014318L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<!DOCTYPE html> \n<html> \n<head> \n<title></title>  \n\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jquery.mobile-1.3.1.min.css\" />\n<script src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/jquery-1.9.1.js\"></script> \n<script src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/jquery.mobile-1.3.1.min.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/css/iPADNew.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/css/mCommon.css\" /> \n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/js/iscroll.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/css/kendo.common.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/css/kendo.default.min.css\" />\n<script src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14_0 ="/eIPAD/kendo.web.min.js\"></script>\n<script type=\"text/javascript\">\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\nvar bclinicalNotesLoaded = false; //cn\nvar currentNotesScrollingId; //cn\nvar currentNotesHScrollingId; //cn\nvar CSMainScroll ;\nvar notesHorizontalScroll; //cn\nvar path;\nvar AccNumber = [];\n\n$(document).ready(function(){\n\tpath = $(\'#hdnPath\').val();\n\tvar transactionOccurred = $(\"#transactionOccurred\").val();\n\tif(transactionOccurred == \'true\'){\n\t\tshowTransactionMessage();\n\t}\n$(window).resize(function() {\n\t\t var resWidth =($(window).width() - 235)+\'px\';\n\t\t   $(\'.rightContentWrap\').css({\'width\':resWidth});\n\t\t   assignSliderWidth();\n\t\t   setScrollerWidth()\n\t});\n\t\n    $(\"#SlideSfsFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\t\n\t//$(\"#SlideSfsFrame\").load(path+\"/mobile/ClinicalNotesSFSServlet\");\n\t\n\t/*if($(\'#hdnCurrentEncID\').val() != undefined){\n\t\t//$(\"#SlideSfsFrame\").load(path+\"/mobile/ClinicalNotesSFSServlet?encounterID=\"+$(\'#hdnCurrentEncID\').val());\n\t\tchooseEncounterFilter($(\'#hdnCurrentEncID\').val(),\'clinicalNotes\',\'fullViewEncounter\');\n\t}*/\n});\n\nfunction showTransactionMessage(){\n\t$(\"#transactionMsg\").show();\n\tsetTimeout(function(){\n\t\t$(\"#transactionMsg\").hide();\n\t},5000);\n\t$(\"#transactionMsg\").bind(\'click\',function(){\n\t\t$(this).hide();\n\t});\n}\nfunction addCnoteSpinner(){\n\t$(\"#ChartSummaryBlock\").find(\"#ClinicalNotes\").append(\"<div class=\'loadingCartItem\' id=\'spinnerDiv\'></div>\");\n}\nfunction remCnoteSpinner(){\n\t$(\"#ChartSummaryBlock\").find(\"#ClinicalNotes\").find(\"#spinnerDiv\").remove();\n}\nfunction openOrdersFrame(){\n\t$(\"#PageLoadingAnimation\").show();\n\twindow.location.replace(path+\"/mobile/charts/orders/MNewOrderServlet\");\n}\nfunction openChartSummaryFrame(){\n\t$(\"#PageLoadingAnimation\").show();\n\twindow.location.replace(path+\"/mobile/chartsummary/ChartWidgetsView\");\n}\nfunction openClinicalNotes(){\n\n\twindow.location.replace(path+\"/mobile/charts/notes/OpenClinicalNoteServlet\");\n}\nfunction openClinicalEvents(){\n\t$(\"#PageLoadingAnimation\").show();\n\twindow.parent.$(\'#hdnopeningPage\').val(\'clinicalEvents\');\n\twindow.parent.$(\"#ChartsBaseForm\").submit();\n}\nfunction openPharmacyOrders(){\n\t$(\"#PageLoadingAnimation\").show();\n\tparent.openPharmacyOrders();\n}\nfunction assignCSScroll() {\n\t setTimeout(function () {\n\t\tCSMainScroll = new iScroll(\'ChartSummaryMainWrapper\', {\n\t\tuseTransform: true,\n\t\tzoom: false,\n\t\tonBeforeScrollStart: function (e) {\n\t\tvar target = e.target;\n\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' )\n\t\te.preventDefault();\n\t\t},\n\t\tbounce: false,\n\t    //momentum: false\n\t\tuseTransform: true,\n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true\n\t\t});\n}, 100); \n}\ndocument.addEventListener(\'DOMContentLoaded\', assignCSScroll, false);\n\nfunction loadClinicalNotes(filterBy,viewPage,finalStartDate,finalEndDate,encounterID){\n\t\n\t//clinicalNotesFilterBy = filterBy;\n\tif(filterBy == \"A\")\n\t{\n\t\tclinicalNotesFilterBy = \"\";\n\t}\n\telse if(filterBy == \"N\")\n\t{\n\t\t\n\t\tif(clinicalNotesFilterBy != null  &&  clinicalNotesFilterBy.length > 0 && clinicalNotesFilterBy.indexOf(\"NUR$\") == -1 )\n\t\t{\n\t\t\tclinicalNotesFilterBy = clinicalNotesFilterBy + \",NUR$\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tclinicalNotesFilterBy = \"NUR$\";\n\t\t}\n\t}\n\telse if(filterBy == \"P\")\n\t{\n\t\t//clinicalNotesFilterBy = \"PHY$\";\n\t\tif(clinicalNotesFilterBy != null && clinicalNotesFilterBy.length > 0 && clinicalNotesFilterBy.indexOf(\"PHY$\") == -1)\n\t\t{\n\t\t\tclinicalNotesFilterBy = clinicalNotesFilterBy + \",PHY$\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tclinicalNotesFilterBy = \"PHY$\";\n\t\t}\n\t}\n\telse if(filterBy == \"C\")\n\t{\n\t\t//clinicalNotesFilterBy = \"CLI$\";\n\t\tif(clinicalNotesFilterBy != null && clinicalNotesFilterBy.length > 0 && clinicalNotesFilterBy.indexOf(\"CLI$\") == -1)\n\t\t{\n\t\t\tclinicalNotesFilterBy = clinicalNotesFilterBy + \",CLI$\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tclinicalNotesFilterBy = \"CLI$\";\n\t\t}\n\t}\n\telse\n\t{\n\t\tclinicalNotesFilterBy = \"\";\n\t}\n\tvar firstClick=false;\n\tvar splAvailable=null\t;\n\tif($(\"[filter-type=\"+filterBy+\"]\").hasClass(\'notesIconSelectedTheme\'))\n\t{\n\t\tfirstClick=true;\n\t\tclinicalNotesFilterBy = \"\";\n\t\tsplAvailable=\"\";\n\t\t$(\".dataContainerFullView\").show();\t\t\t\n\t\t$(\"#CNdivcnt\").find(\".clinicalNotesContent\").show();  \n\t}\n\telse\n\t{\n\t\tsplAvailable=viewPage;\t\t\n\t\t$(\"#CNdivcnt\").find(\".clinicalNotesContent\").show();  \n\t}\n\t\t\n\t\n\t\t\n\tif(viewPage==\'fullView\'){\n\t\t\n\t\t\n     \t\n\t\taddCnoteSpinner();\n\t   $(\"#clinicalNotesFrame\").load( path + \"/mobile/chartsummary/ClinicalNotesView?viewPage=fullView&filterBy=\" +clinicalNotesFilterBy,function(){\n\t\tremCnoteSpinner();\n\t\tscrollerRefresh(CSMainScroll);\n\t\tbclinicalNotesLoaded = true;\n\t\tbfullViewOpen = false;\n\t\tcnNoteType = \"\";\n\t\tbAccordionViewLoaded = false;\n\t\tcurrentNotesHScrollingId = \"\";\n\t\tarrCnVisitedPages = null;\n\t\tarrCnVisitedPages = [];\n\t\tcnCurrentPage = 0;\n\t\t\n\t\t$(\"[data-filterIcon = \'T\']\").each(function(index, value) {\n\t\t\tif($(this).attr(\'filter-type\') != filterBy){\n\t\t\t\t$(this).removeClass(\"notesIconSelectedTheme\");\n\t\t\t}\n\t\t\t});\n\t\t\t\n\t\t\t\n\t\tif(firstClick){\n\t\t\t\n\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").removeClass(\"notesIconSelectedTheme\");\n\t\t\t\t}else{\n\t\t\t\t\t\n\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").addClass(\"notesIconSelectedTheme\");\n\t\t}\n\t\t\n\t});\n\t}\n\telse if(viewPage==\'fullViewTimeRange\'){\n\t\t$(\"#clinicalNotesFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\t\n\t\t$(\"#clinicalNotesFrame\").load( path + \"/mobile/chartsummary/ClinicalNotesView?viewPage=fullViewTimeRange&filterBy=\" +clinicalNotesFilterBy+\"&finalStartDate=\"+finalStartDate+\"&finalEndDate=\"+finalEndDate,function(){\n\t\t\tscrollerRefresh(CSMainScroll);\n\t\t\tbclinicalNotesLoaded = true;\n\t\t\tbfullViewOpen = false;\n\t\t\tcnNoteType = \"\";\n\t\t\tbAccordionViewLoaded = false;\n\t\t\tcurrentNotesHScrollingId = \"\";\n\t\t\tarrCnVisitedPages = null;\n\t\t\tarrCnVisitedPages = [];\n\t\t\tcnCurrentPage = 0;\n\t\t\t\n\t\t\t$(\"[data-filterIcon = \'T\']\").each(function(index, value) {\n\t\t\t\tif($(this).attr(\'filter-type\') != filterBy)\n\t\t\t\t{\t\n\t\t\t\t$(this).removeClass(\"notesIconSelectedTheme\");\n\t\t\t\t}\n\t\t\t});\n\t\t\tif(firstClick){\n\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").removeClass(\"notesIconSelectedTheme\");\n\t\t\t\t}else{\t\t\t\t\t\n\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").addClass(\"notesIconSelectedTheme\");\n\t\t\t\t}\n\t\t\tdisabledRows();\n\t\t\t\n\t\t});\n\t\t}\n\telse if(viewPage==\'fullViewEncounter\'){\n\t\t$(\"#clinicalNotesFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t\t$(\"#clinicalNotesFrame\").load( path + \"/mobile/chartsummary/ClinicalNotesView?viewPage=fullViewEncounter&filterBy=\" +clinicalNotesFilterBy+\"&encounterID=\"+encounterID,function(){\n\t\t\tscrollerRefresh(CSMainScroll);\n\t\t\tbclinicalNotesLoaded = true;\n\t\t\tbfullViewOpen = false;\n\t\t\tcnNoteType = \"\";\n\t\t\tbAccordionViewLoaded = false;\n\t\t\tcurrentNotesHScrollingId = \"\";\n\t\t\tarrCnVisitedPages = null;\n\t\t\tarrCnVisitedPages = [];\n\t\t\tcnCurrentPage = 0;\n\t\t\tsetTimeout(function(){\n\t\t\t\tparent.setTimeFrame();\n\t\t\t\t$(\'div[id^=\"SLSfsTickEN\"]\').hide();\n\t\t\t\t$(\"#SLSfsTickEN\"+encounterID).show();\n\t\t\t},0);\t\n\t\t\t$(\"[data-filterIcon = \'T\']\").each(function(index, value) {\n\t\t\t\tif($(this).attr(\'filter-type\') != filterBy)\n\t\t\t\t{\n\t\t\t\t\t$(this).removeClass(\"notesIconSelectedTheme\");\n\t\t\t\t}\n\t\t\t});\n\t\t\tif(firstClick){\n\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").removeClass(\"notesIconSelectedTheme\");\n\t\t\t\t}else{\n\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").addClass(\"notesIconSelectedTheme\");\n\t\t\t}\n\t\t\tdisabledRows();\n\t\t});\n\t\t}\n\t\telse\n\t\t{\n\t\t\n\t\t\taddCnoteSpinner();\n\t\t\t$(\"#clinicalNotesFrame\").load( path + \"/mobile/chartsummary/ClinicalNotesView?viewPage=fullView&filterBy=\" +clinicalNotesFilterBy,function(){\n\t\t\t\tremCnoteSpinner();\n\t\t\t\tscrollerRefresh(CSMainScroll);\n\t\t\t\tbclinicalNotesLoaded = true;\n\t\t\t\tbfullViewOpen = false;\n\t\t\t\tcnNoteType = \"\";\n\t\t\t\tbAccordionViewLoaded = false;\n\t\t\t\tcurrentNotesHScrollingId = \"\";\n\t\t\t\tarrCnVisitedPages = null;\n\t\t\t\tarrCnVisitedPages = [];\n\t\t\t\tcnCurrentPage = 0;\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tvar arrSPL =[];\t\t\t\n\t\t\t\t$(\".dataContainerFullView\").hide();\n\t\t\t\tarrSPL.push(splAvailable); \n\t\t\t\tif(splAvailable)\n\t\t\t\t{\n\t\t\t\t\tvar specialityCount = document.getElementById(\"hdnCount\").value;\n\t\t\t\t\t\n\t\t\t\t\tfor(var i=0; i<specialityCount; i++){\n\t\t\t\t\t\tvar noteType = document.getElementById(\"hdnSpeciality\"+i).value;\n\t\t\t\t\t\t$(\'.dataContainerFullView[data-notetype=\'+noteType+\']\').show();\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t$(\".dataContainerFullView\").each(function(){\n\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t});\n\t\t\t\t}\n\t\t\t\n\t\t\t\t$(\"[data-filterIcon = \'T\']\").each(function(index, value) {\n\t\t\t\t\t\tif($(this).attr(\'filter-type\') != filterBy)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t$(this).removeClass(\"notesIconSelectedTheme\");\n\t\t\t\t\t\t}\n\t\t\t\t\t});\n\t\t\t\t\tif(firstClick){\n\t\t\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").removeClass(\"notesIconSelectedTheme\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t$(\"[filter-type=\"+filterBy+\"]\").addClass(\"notesIconSelectedTheme\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\thideNoteAndBubbles();\n\t\t\t\tif($(\'.clinicalNotesContent:visible\').length >= 1){\n\t\t\t\t\t$(\'.mySpecialityNoRecords\').hide();\n\t\t\t\t}else{\n\t\t\t\t\t$(\'.mySpecialityNoRecords\').show();\n\t\t\t\t}\n\t\t\t});\n\t\t}\n\t\thideNoteAndBubbles();\n\t\tclinicalNotesFilterBy = \"\";// clear all exist filters\n}\nfunction disabledRows(){\n\tvar filterNote ={\n\t\t\t\t\"listItemNT\":[],\n\t\t\t\t\"listItemMAS\":[],\n\t\t\t\t\"listItemST\":[],\n\t\t\t\t\"listItemPB\":[]\n\t\t\t}\n\t\t\t$(\".dataContainerFullView:visible\").each(function (i,v ){\n\t\t\t\tfilterNote[\'listItemMAS\'].push($(this).attr(\'data-serv\'));\n\t\t\t\tfilterNote[\'listItemST\'].push($(this).attr(\'data-status\'));\n\t\t\t\tfilterNote[\'listItemPB\'].push($(this).attr(\'data-perform\'));\n\t\t\t\tfilterNote[\'listItemNT\'].push($(this).parents(\'.swipeWrapper\').attr(\'data-notetype\'));\n\t\t\t});\n\t\t\t$(\'.SlideSfsFrame\').find(\".listItemNT[data-speccode],.listItemST[data-speccode],.listItemMAS[data-speccode],.listItemPB[data-speccode]\").hide();\n\t\t\t$(\'#headingNT,#headingMAS,#headingST,#headingPB\').removeClass(\'disabledRowRecords\');\n\t\t\tfor (var key in filterNote) {\n\t\t\t\t  if (filterNote.hasOwnProperty(key) && filterNote[key].length > 0)  {\n\t\t\t\t\t for(var i=0; i<filterNote[key].length; i++){\n\t\t\t\t\t\t $(\'.SlideSfsFrame\').find(\".\"+key+\"[data-speccode=\'\"+filterNote[key][i]+\"\']\").show();\n\t\t\t\t\t }\t \n\t\t\t\t  }else{\n\t\t\t\t\tif($(\'.SlideSfsFrame\').find(\".\"+key+\":visible\").length == 0){\n\t\t\t\t\t\t$(\'.SlideSfsFrame\').find(\".\"+key).parents(\'div[id^=\"content\"]\').siblings(\'div[id^=\"heading\"]\').addClass(\'disabledRowRecords\');\n\t\t\t\t\t\t$(\'.SlideSfsFrame\').find(\".\"+key).parents(\'div[id^=\"content\"]\').hide();\n\t\t\t\t\t\t$(\'.SlideSfsFrame\').find(\".disabledRowRecords\").siblings(\'div[id^=\"textBox\"]\').hide();\n\t\t\t\t\t}\n\t\t\t\t  }\n\t\t\t}\n}\nfunction hideNoteAndBubbles(){\n\t$(\".clinicalNotesContent\").each(function (i,v ){\n\t\t\t\t if ($(this).find(\".dataContainerFullView:visible\").length == 0)\n\t\t\t\t {\n\t\t\t\t\t$(this).hide();\n\t\t\t\t }\n\t\t\t\t else{\n\t\t\t\t\t $(this).show();\n\t\t\t\t }\t \n\t\t\t});\n\t\t\t$(\".bubbleDivider\").each(function (i,v ){\n\t\t\t\tif($(this).prevUntil(\".bubbleDivider\").is(\":visible\") && $(this).nextUntil(\".bubbleDivider\").is(\":vi";
    private final static byte[]  _wl_block14_0Bytes = _getBytes( _wl_block14_0 );

    private final static java.lang.String  _wl_block14_1 ="sible\") ){\n\t\t\t\t\t$(this).show();\n\t\t\t\t}else{\n\t\t\t\t\t$(this).hide();\n\t\t\t\t}\n\t\t\t});\n}\n\nfunction scrollerRefresh(scroller){\n\tif(scroller != null){\n\t\tscroller.refresh();\n\t}\n\t\n}\n\n\n\nfunction clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN){\n\t//closing fullview on filter\n\t$(\"[data-fullView = \'true\']\").each(function(index, value) {\n\t\t$(\"[data-noteType = \" + $(this).attr(\'data-fullviewnotetype\')+\"]\").find(\".swipeWrapper\").show();\n\t\t$(this).hide();\n\t});\n\tcnNoteType =\'\';\n\tvar totalCount = arrPB.length + arrNT.length + arrMAS.length + arrST.length + arrML.length + arrSPL.length +arrSN.length;\n\tvar filterNote ={\n\t\t\t\t\"listItemNT\":[],\n\t\t\t\t\"listItemMAS\":[],\n\t\t\t\t\"listItemST\":[],\n\t\t\t\t\"listItemPB\":[]\n\t\t\t}\n\tif(totalCount>0){\n\t\t$(\"#CNdivcnt\").find(\".clinicalNotesContent\").show(); \n\trows= $(\"#CNdivcnt\").find(\".dataContainerFullView\").hide();\n\t\tvar MatchedValues =\'\';\n\t\tif(arrNT.length > 1){\n\t\t\tfor(var i=0; i<arrNT.length; i++){\n\t\t\t\t\t MatchedValues = \"[data-notetype = \'\"+arrNT[i]+\"\']\";\n\t\t\t\t\t if(arrMAS.length > 0)\n\t\t\t\t\t\t MatchedValues += \"[data-serv = \'\"+arrMAS[0]+\"\']\";\n\t\t\t\t\t if(arrST.length > 0)\n\t\t\t\t\t\t MatchedValues += \"[data-status = \'\"+arrST[0]+\"\']\";\n\t\t\t\t\t if(arrPB.length > 0)\n\t\t\t\t\t\t MatchedValues += \"[data-perform = \'\"+arrPB[0]+\"\']\";\n\t\t\t\t\t$(\'.dataContainerFullView\'+MatchedValues).show();\n\t\t\t }\t\n\t\t}else{\n\t\t\tif(arrNT.length > 0)\n\t\t\t MatchedValues = \"[data-notetype = \'\"+arrNT[0]+\"\']\";\n\t\t\t if(arrMAS.length > 0)\n\t\t\t\t MatchedValues += \"[data-serv = \'\"+arrMAS[0]+\"\']\";\n\t\t\t if(arrST.length > 0)\n\t\t\t\t MatchedValues += \"[data-status = \'\"+arrST[0]+\"\']\";\n\t\t\t if(arrPB.length > 0)\n\t\t\t\t MatchedValues += \"[data-perform = \'\"+arrPB[0]+\"\']\";\n\t\t\t$(\'.dataContainerFullView\'+MatchedValues).show();\n\t\t}\n\t\t\n\t\t\n\t\tif(arrSPL.length>0){\n\t\t\tvar specialityCount = document.getElementById(\"hdnCount\").value;\n\t\t\t\n\t\t\tfor(var i=0; i<specialityCount; i++){\n\t\t\t\tvar noteType = document.getElementById(\"hdnSpeciality\"+i).value;\n\t\t\t\t$(\"[data-notetype = \'\"+noteType+\"\']\").each(function (i,v ){\n\t\t\t\t\t$(this).show();\n\t\t\t\t});\n\t\t\t}\n\t\t}\n\t}\n\telse if(totalCount==0){\n\t\trows= $(\"#CNdivcnt\").find(\".clinicalNotesContent\").show();  \n\t\t$(\"#CNdivcnt\").find(\".dataContainerFullView\").show();   \n\t\t\t \n\t\t }\n\t//searchbynotes icon functionality\n\tif(arrNT.length > 0){\n\t\t\t$(\'.searchByNotes\').addClass(\"enableSearch\");\n\t\t}else{\n\t\t\t$(\'.searchByNotes\').removeClass(\"enableSearch\")\n\t}\t  \n\t$(\".clinicalNotesContent\").each(function (i,v ){\n\t\t\t if ($(this).find(\".dataContainerFullView:visible\").length == 0)\n\t\t\t {\n\t\t\t\t$(this).hide();\n\t\t\t }\n\t\t\t else{\n\t\t\t\t $(this).show();\n\t\t\t }\t \n\t});\n\t\tif($(\'.clinicalNotesContent:visible\').length >= 1){\n\t\t\t$(\'.mySpecialityNoRecords\').hide();\n\t\t}else{\n\t\t\t$(\'.mySpecialityNoRecords\').show();\n\t\t}\n\t$(\".dataContainerFullView:visible\").each(function (i,v ){\n\t\t\tfilterNote[\'listItemMAS\'].push($(this).attr(\'data-serv\'));\n\t\t\tfilterNote[\'listItemST\'].push($(this).attr(\'data-status\'));\n\t\t\tfilterNote[\'listItemPB\'].push($(this).attr(\'data-perform\'));\n\t\t\tfilterNote[\'listItemNT\'].push($(this).parents(\'.swipeWrapper\').attr(\'data-notetype\'));\n\t});\n\t$(\'.SlideSfsFrame\').find(\".listItemNT[data-speccode],.listItemST[data-speccode],.listItemMAS[data-speccode],.listItemPB[data-speccode]\").hide();\n\tfor (var key in filterNote) {\n\t\t  if (filterNote.hasOwnProperty(key) && filterNote[key].length > 0)  {\n\t\t\t for(var i=0; i<filterNote[key].length; i++){\n\t\t\t\t $(\'.SlideSfsFrame\').find(\".\"+key+\"[data-speccode=\'\"+filterNote[key][i]+\"\']\").show();\n\t\t\t }\t\n\t\t\t\n\t\t  }  \n\t}\n\t\n\t\n\t$(\".bubbleDivider\").each(function (i,v ){\n\t\tif($(this).prevUntil(\".bubbleDivider\").is(\":visible\") && $(this).nextUntil(\".bubbleDivider\").is(\":visible\") ){\n\t\t\t$(this).show();\n\t\t}else{\n\t\t\t$(this).hide();\n\t\t}\n\t});\n\tremCnoteSpinner();\n }\n\n$(document).ready(function(){\n\tparent.setOnLoadContentPaneHeight();\n\tloadClinicalNotes(\'A\',\'fullView\',\'\',\'\',\'\');//cn\n});\n\nfunction closeClinicalNotes(){ \n\tparent.closeChartSummary();\n\t\n}\n\n\nfunction changeOrientation(orient, EMHFheight){\n\tbOrientationChanged = true; //cn\n\tvar CSHFheight = $(\'#CSHeader\').height() + $(\'#CSFooter\').height();\n\tvar content_height = parent.getTotalPageDivHeight()  - EMHFheight - CSHFheight - 10;//margin 5px\n\tdocument.getElementById(\"ChartSummaryMainWrapper\").style.height = content_height+\"px\";\n\t\n\tif(bclinicalNotesLoaded){\n\t\tassignSliderWidth();\n\t\tsetScrollerWidth();\n\t\tif(myScrollnotes != null){\n\t\t\tmyScrollnotes.refresh();\t\n\t\t}\n\t\t\n\t\tif(bAccordionViewLoaded){\n\t\t\t//accordionNotesViewDimensions(cnNoteType);\n\t\t}\n\t\tif(notesHorizontalScroll != null){\n\t\t\t//accordionNotesViewDimensions(cnNoteType);\n\t\t\t//alert(notesHorizontalScroll.currPageX);\n\t\t\tnotesHorizontalScroll.refresh();\n\t\t\tnotesHorizontalScroll.scrollToPage(cnCurrentPage,0);\n\t\t\t//alert(notesHorizontalScroll.currPageX);\n\t\t}\n\t}\n}\nfunction accordionNotesViewDimensions(noteType){\n\tvar count = 0;\n\t$(\"[data-child = \" + noteType +\"]\").each(function(index, value) {\n\t\tcount++;\n\t});\n\tvar fullViewScrollerWidth = count * 100 + \"%\";\n\n\t$(\"[data-fullViewScroller = \" + noteType +\"]\").each(function(index, value) {\n\t\t\n\t\t$(this).css(\"width\", fullViewScrollerWidth);\n\n\t});\n\tvar childWidth = 100 / count + \"%\";\n\n\t$(\"[data-child = \" + noteType +\"]\").each(function(index, value) {\n\t\t\n\t\t$(this).css(\"width\", childWidth);\n\t});\n}\nfunction scrollToPage(pageNumber,cuuDivObj,noteType)\n{\n\tcnCurrentPage = pageNumber;\n\n\tif(notesHorizontalScroll != null)\n\t{\n\t\t//accordionNotesViewDimensions(cnNoteType);\n\t\t//alert(notesHorizontalScroll.currPageX);\n\t\t//notesHorizontalScroll.refresh();\n\t\tnotesHorizontalScroll.scrollToPage(cnCurrentPage,0);\n\t//\tloadFullViewBubbleNotes(pageNumber,noteType);\n\t\t//alert(notesHorizontalScroll.currPageX);\n\t}\n}\nfunction loadFullViewBubbleNotes(pageNumber,noteType)\n{\n\tcnCurrentPage = pageNumber;\n\t//alert(\"pagenumber = \" + cnCurrentPage);\n\tvar pageId = noteType + pageNumber;\n\tif(pageNumber != null && pageNumber != \"\")\n\t{\n\t\tpageNumber = parseInt(pageNumber);\t\n\t}\n\tvar startIndex = 0;\n\tstartIndex = (pageNumber * 15);\n\tvar endIndex = startIndex + 15;\n\tvar pageCount = $(\"[data-pageId = \" + pageId  +\"]\").attr(\"data-pageCount\");\n\tif(pageCount != null && pageCount != \"\")\n\t{\n\t\tpageCount = parseInt(pageCount);\t\n\t}\n\t//alert($.inArray(pageId, arrCnVisitedPages));\n\tvar bPageIdLoaded = false;\n\tif(arrCnVisitedPages != null && $.inArray(pageId, arrCnVisitedPages) != -1)\n\t{\n\t\tbPageIdLoaded = true;\t\n\t}\n\t//alert(\"pageloaded =\" + bPageIdLoaded)\n\tif(pageCount > 1 && !bPageIdLoaded)\n\t{\n\t\t$(\"[data-pageId = \" + pageId  +\"]\").load( path + \"/mobile/chartsummary/ClinicalNotesView?filterBy=\" +clinicalNotesFilterBy + \"&noteType=\" + noteType+ \"&viewType=addNoteBubble&startIndex=\" + startIndex+ \"&endIndex=\" + endIndex,function(){\n\t\t\t\n\t\t});\n\t}\n\t$(\"[data-pageIconNoteType= \"+ noteType+\"]\").each(function(index, value) {\n\t\t\n\t\t $(this).removeClass(\"selectedPageIcons\").addClass(\"normalPageIcons\");\n\t\t if($(this).attr(\"data-pageIconNumber\") == pageNumber)\n\t\t {\n\t\t\t $(this).removeClass(\"normalPageIcons\").addClass(\"selectedPageIcons\");\n\t\t }\n\t});\n\t\n\tarrCnVisitedPages.push(pageId);\n}\n\n\nfunction assignSliderWidth()\n{\t\n\t$(\".swipeWrapper\").each(function(index, value) {  \n\t\t$(this).css(\"width\",\"200px\"); // assigning dummy width.\n\t\n\t});\n   // var notesScrollerWidth = 0;\n\t$(\".swipeTable\").each(function(index, value) {      \n\t\tvar contentCount =  $(this).attr(\'data-count\');\n\t\t//var noteTypeValue = $(this).attr(\'data-noteType\');\n\t\t width = $(this).width() - $(\"[data-content = \'\" + contentCount + \"\']\").width();\n\t\t if(width <= 200)\n\t\t\twidth = 120;\n\t\t\t$(\".swipeWrapper\").each(function(index, value) {  \n\t\t\t$(this).css(\"width\",width);\n\t\t\tvar idCount = $(this).attr(\'data-IdCount\');\n\t\t\n\t\t});//swipewrapper\n\t\t\n    });//swipetable\n\n}\nfunction setScrollerWidth()\n{\n\tvar swipecount = 1;\n\t$(\".swipeWrapper\").each(function(index, value) {  \t\n\t\tvar idCount = $(this).attr(\'data-IdCount\');\n\t\tvar noteTypeValue = $(this).attr(\'data-noteType\');\n\t\tvar noteScrollerWidth = 0;\n\t\t\n\t\t$(\"[data-noteTypeValue = \'\" + noteTypeValue + \"\']\").each(function(index, value) { \n\t\t\tnoteScrollerWidth = noteScrollerWidth + $(this).width();\n\t\t\tswipecount++;\n\t\t});//notetype\n\t\tif(noteScrollerWidth < width)\n\t\t\tnoteScrollerWidth = width  + \"px\";\n\t\telse\n\t\t\tnoteScrollerWidth =  noteScrollerWidth  + swipecount * 8+\"px\";\n\t\t\t\t\n\t\t$(\'#notesScroller\' + idCount).css(\"width\",noteScrollerWidth);\n\t\t//noteScrollerWidth = 0;\n\t});//swipewrapper\n}\nvar filteredNotes =[];\nfunction showFullViewNotes(obj, type){\n\tvar nt = $(obj).attr(\"data-expandNoteType\");\n\t$(\"[data-fullView = \'true\']\").each(function(index, value) {\n\t\t$(this).hide();\n\t});\n\tarrCnVisitedPages = null;\n\tarrCnVisitedPages = [];\n\n\t$(\"[data-noteType = \" + cnNoteType +\"]\").find(\".swipeWrapper\").show();\n\tif(cnNoteType != nt)\n\t{\n\t\tfilteredNotes =[];\n\t\t$(\"[data-noteType = \" + nt +\"]\").find(\".swipeWrapper .dataContainerFullView:visible\").each(function(index, value) {\n\t\t\tfilteredNotes.push($(this).attr(\'data-accnumber\'));\n\t\t});\n\t\t\n\t\t$(\"[data-fullviewNoteType = \" + nt +\"]\").show();\n\t\t$(\"[data-noteType = \" + nt +\"]\").find(\".swipeWrapper\").hide();\n\t\tbfullViewOpen = true;\n\t\tvar encounterID = document.getElementById(\"hdnSelEncID\").value;\n\t\t\n\t\tif(type == \"normalView\" ){\n\t    $(\"[data-fullviewNoteType = \" + nt +\"]\").load( path + \"/mobile/chartsummary/ClinicalNotesView?filterBy=\" +clinicalNotesFilterBy + \"&noteType=\" + nt+ \"&viewType=AccordionView&viewPage=fullViewEncounter&encounterID=\" + encounterID,function(){\n\t    \t$(document).ready(function(){\n\t\t\t\t//bclinicalNotesLoaded = true;\n\t\t\t\taccordionNotesViewDimensions(nt);\n\t\t\t\thorizontalNotesScroll(nt);\n\t\t\t\tscrollerRefresh(CSMainScroll);\n\t\t\t\tbAccordionViewLoaded = true;\n\t\t\t\tcnCurrentPage = 0;\n\t\t\t\tif(arrCnVisitedPages != null)\n\t\t\t\t{\n\t\t\t\t\tvar PageID = nt + \"0\";\n\t\t\t\t\tarrCnVisitedPages.push(PageID);\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t$(\".notesFullViewTable .notesBubbleContainer\").hide();\n\t\t\t\t$(\".notesFullViewTable .notesBubbleContainer\").each(function(index, value) {\n\t\t\t\t\tif(filteredNotes.indexOf($(this).attr(\'data-accnumber\')) != -1){\n\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\t\n\t\t\t});\n\t\t\t\n\t\t});\n\t    }\n\t    else if (type == \"timeRangeView\" ){\n\t    \tvar startDate = document.getElementById(\"hdnStrDate\").value;\n\t    \tvar endDate = document.getElementById(\"hdnEndDate\").value;\n\t    \t$(\"[data-fullviewNoteType = \" + nt +\"]\").load( path + \"/mobile/chartsummary/ClinicalNotesView?filterBy=\" +clinicalNotesFilterBy + \"&noteType=\" + nt+ \"&viewType=AccordionViewTimeRange&viewPage=fullViewTimeRange&finalStartDate=\" + startDate + \"&finalEndDate=\" + endDate ,function(){\n\t    \t$(document).ready(function(){\n\t\t\t\t//bclinicalNotesLoaded = true;\n\t\t\t\taccordionNotesViewDimensions(nt);\n\t\t\t\thorizontalNotesScroll(nt);\n\t\t\t\tscrollerRefresh(CSMainScroll);\n\t\t\t\tbAccordionViewLoaded = true;\n\t\t\t\tcnCurrentPage = 0;\n\t\t\t\tif(arrCnVisitedPages != null)\n\t\t\t\t{\n\t\t\t\t\tvar PageID = nt + \"0\";\n\t\t\t\t\tarrCnVisitedPages.push(PageID);\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t$(\".notesFullViewTable .no";
    private final static byte[]  _wl_block14_1Bytes = _getBytes( _wl_block14_1 );

    private final static java.lang.String  _wl_block14_2 ="tesBubbleContainer\").hide();\n\t\t\t\t$(\".notesFullViewTable .notesBubbleContainer\").each(function(index, value) {\n\t\t\t\t\tif(filteredNotes.indexOf($(this).attr(\'data-accnumber\')) != -1){\n\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\t\n\t\t\t});\n\t\t\t\n\t\t});\n\t    }\n\t    $(\"[data-imagaeNoteType = \" + cnNoteType +\"]\").attr(\"src\" , path + \"/eIPAD/images/Expandview.png\");\n\t    cnNoteType = nt;\n\t    $(\"[data-imagaeNoteType = \" + nt +\"]\").attr(\"src\" , path + \"/eIPAD/images/Collapseview.png\");\n\t    \n\t}\n\telse\n\t{\n\t\tif(bfullViewOpen)\n\t\t{\n\t\t\t$(\"[data-fullviewNoteType = \" + nt +\"]\").hide();\n\t\t\t$(\"[data-noteType = \" + nt +\"]\").find(\".swipeWrapper\").show();\n\t\t\tbfullViewOpen = false;\n\t\t\t$(\"[data-imagaeNoteType = \" + nt +\"]\").attr(\"src\" , path + \"/eIPAD/images/Expandview.png\");\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//horizontalNotesScroll(nt);\n\t\t\t$(\"[data-fullviewNoteType = \" + nt +\"]\").show();\n\t\t\t$(\"[data-noteType = \" + nt +\"]\").find(\".swipeWrapper\").hide();\n\t\t\tbfullViewOpen = true;\n\t\t\tif(notesHorizontalScroll != null)\n\t\t\t{\n\t\t\t\t//accordionNotesViewDimensions(cnNoteType);\n\t\t\t\t//alert(notesHorizontalScroll.currPageX);\n\t\t\t\tnotesHorizontalScroll.refresh();\n\t\t\t\t//notesHorizontalScroll.scrollToPage(cnCurrentPage,0);\n\t\t\t\t//alert(notesHorizontalScroll.currPageX);\n\t\t\t}\n\t\t\t$(\"[data-imagaeNoteType = \" + nt +\"]\").attr(\"src\" , path + \"/eIPAD/images/Collapseview.png\");\n\t\t}\n\t\tscrollerRefresh(CSMainScroll);\n\t}\n}\nfunction horizontalNotesScroll(noteType)\n{\n\t//notesHorizontalScroll = null;\n\t//$(\".fullViewWrapper\").bind(\'touchstart click\', function(event) {\n\t\t//alert(\"notetype =\" + noteType);\n\t\tvar currentNotesId = $(\"[data-fullViewWrapper = \" + noteType +\"]\").attr(\'id\');\n\t\t//alert(\"hi\");\n\t\t// var currentNotesId = $(this).attr(\'id\');\n\t\t if(currentNotesHScrollingId != null)\n\t\t {\n\t\t\t //alert(\"global =\" +currentNotesHScrollingId);\n\t\t\t //alert( \"local = \" + currentNotesId)\n\t\t\t if(currentNotesHScrollingId != currentNotesId)\n\t\t\t {\n\t\t\t\t// alert(\"hi2\");\n\t\t\t\t notesHorizontalScroll = new iScroll(currentNotesId, {\n\t\t\t\t\t\thScrollbar : false,\n\t\t\t\t\t\tsnap: true,\n\t\t\t\t\t\tmomentum: false,\n\t\t\t\t\t\tvScroll : false,\n\t\t\t\t\t\tonScrollEnd: function () {\n\t\t\t\t\t\t\t//alert(this.currPageX);\n\t\t\t\t\t\t\tloadFullViewBubbleNotes(this.currPageX,noteType);\n\t\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\t currentNotesHScrollingId = currentNotesId;\t\n\t\t\t }\n\t\t }\n\t\t else\n\t\t {\n\t\t\t// alert(\"hi12\");\n\t\t\t currentNotesHScrollingId = currentNotesId;\n\t\t\t notesHorizontalScroll = new iScroll(currentNotesId, {\n\t\t\t\t\thScrollbar : false,\n\t\t\t\t\tsnap: true,\n\t\t\t\t\tmomentum: false,\n\t\t\t\t\tvScroll : false,\n\t\t\t\t\tonScrollEnd: function () {\n\t\t\t\t\t\t//alert(this.currPageX);\n\t\t\t\t\t\tloadFullViewBubbleNotes(this.currPageX,noteType);\n\t\t\t\t\t}\n\t\t\t});\n\t\t\t \n\t\t }\n\t//});\n}\n\nvar EncListScroll;\nfunction toggleEncListPopup(){\n\tif(EncListScroll == null){\n\t\tEncListScroll = new iScroll(\'EncListcontainer-wrapper\', {\n\t\t\tuseTransform : true,\n\t\t\tzoom : false,\n\t\t\tonBeforeScrollStart : function(e) {\n\t\t\t\tvar target = e.target;\n\t\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\t\n\t\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' ){\n\t\t\t\t\te.preventDefault();\n\t\t\t\t}\n\t\n\t\t\t\te.stopPropagation();\n\t\t\t}\n\t\t});\n\t}\n\t$(\"#EncListPopup\").toggle();\n\tif($(\'#EncListPopup\').is(\':visible\')){\n\t\t$(\'#dvMez\').show();\n\t\t$(\"#dvMez\").data(\"popid\",\"EncListPopup\");\n\t\tsetTimeout(function() {\n\t\t\t$(\"#dvMez\").on(\"click\",closeMez);\n\t\t}, 500);\n\t}\n\tif($(\'#EncListPopup\').is(\':hidden\')){\n\t\t$(\'#dvMez\').hide();\n\t\t$(\"#dvMez\").data(\"popid\",\"\");\n\t\t$(\"#dvMez\").off();\n\t}\n\tif(EncListScroll!=null && $(\'#EncListPopup\').is(\':visible\')){\n\t\tEncListScroll.refresh();\n\t}\n\n}\nfunction closeMez(){\n\tvar popid = $(\"#dvMez\").data(\"popid\");\n\t$(\"#\"+popid).hide();\n\t$(\"#dvMez\").hide();\n\t$(\"#dvMez\").off();\n}\n\nvar openingPage = \"clinicalNotes\"; \n\nvar setTimeFrame;\nfunction EncountersInRange(finalStartDate,finalEndDate,viewPage){\n\tdocument.getElementById(\"hdnStrDate\").value = finalStartDate;\n\tdocument.getElementById(\"hdnEndDate\").value = finalEndDate;\n\t$(\'div[id^=\"SLSfsTickEN\"]\').hide();\t\n\tloadClinicalNotes(\"A\",viewPage,finalStartDate,finalEndDate,\'\');\t\n\t$(\"#SlideSfsFrame\").load(path+\"/mobile/ClinicalNotesSFSServlet?viewPage=fullViewTimeRange&finalStartDate=\"+finalStartDate+\"&finalEndDate=\"+finalEndDate);\n}\nfunction chooseEncounterFilter(encounterID, openingPages, viewPage){\n\t//addCnoteSpinner();\n\t//\tparent.setTimeFrame();\n\t\t document.getElementById(\"hdnSelEncID\").value = encounterID;\n\t\t/*  if($(\"#SLSfsTickEN\"+encounterID).is(\":visible\")){ //On/Off logic is commented. do not remove.\n\t\t\t\tif($(\'#contentEC .listItemEC\').length ==1){\n\t\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t  $(\'div[id^=\"SLSfsTickEN\"]\').hide();\n\t\t\t  $(\"#SLSfsTickEN\"+encounterID).hide();\n\t\t\t loadClinicalNotes(\'A\',viewPage,\' \',\' \',\'\');\n\t\t }else{ */\n\t\t\t //clearing notetype and ticks\n\t\t\tarrNT=[];\n\t\t\t$(\"#AfterSelectionNT\").html(\'\');\n\t\t\t$(\".SLSfsTickVisible\").hide();\n\t\t\t$(\'.searchByNotes\').removeClass(\"enableSearch\");\n\t\t\n\t\t\t $(\'div[id^=\"SLSfsTickEN\"]\').hide();\n\t\t\t $(\"#SLSfsTickEN\"+encounterID).show();\n\t\t\t loadClinicalNotes(\'A\',viewPage,\' \',\' \',encounterID);\n\t\t\t //$(\"#clinicalNotesFrame\").load( path + \"/mobile/chartsummary/ClinicalNotesView?viewPage=fullViewEncounter&filterBy=A&encounterID=\"+encounterID);\n\t\t\t $(\"#SlideSfsFrame\").load(path+\"/mobile/ClinicalNotesSFSServlet?viewPage=fullViewEncounter&encounterID=\"+encounterID);\n\t\t/*  }  */\n\t\t\n\t\tparent.setTimeFrame();\n}\nfunction chooseShowNotesFilter(showNotes){\n\t\n\n\t /* if($(\"#SLSfsTickSN\"+showNotes).is(\":visible\")){\n\t\t $(\"#SLSfsTickSN\"+showNotes).hide();\n\t\t $(\'div[id^=\"SLSfsTickSN\"]\').hide()\n\t\t loadClinicalNotes(\'A\',viewPage,\' \',\' \',\'\');\n\t }else{\n\t\t $(\'div[id^=\"SLSfsTickSN\"]\').hide();\n\t\t $(\"#SLSfsTickSN\"+showNotes).show();\n\t\t loadCNFilter(showNotes);\n\t } */\n}\n\nfunction closePopup(popupId){\n\tvar popupObj = $(\"#\"+popupId);\n\t$(\"#dvMez\").hide();\n\t$(\"#dvMez\").data(\"popid\",\"\");\n\t$(popupObj).hide();\n\t$(\"#dvMez\").off();\n}\n\nvar isOpened = false;\nfunction showSlideSFS()\n{\n\tisOpened=true;\n\t//parent.setTimeFrame();\n\t//$(\"#SlideSfsFrame\").load(path+\"/mobile/ClinicalNotesSFSServlet\");\n\t$(\"#SlideSfsFrame\").load(path+\"/mobile/ClinicalNotesSFSServlet?viewPage=fullViewEncounter&encounterID=\"+$(\'#currentECID\').val());\n\t$(\'#SlideSfsFrame\').show();/*changed*/\n\t$(\'.slidesFrameWrap\').css({\'display\':\'table-cell\'});/*changed*/\n\t$(\"#SlideSFSOpener\").hide();\n\tvar resWidth =($(window).width() - 235)+\'px\';\n   \t$(\'.rightContentWrap\').css({\'width\':resWidth});\n   \tassignSliderWidth();\n   \tsetScrollerWidth();\n\t$(\".sliderSwipe\").hide();\n}\nfunction hideSlideSFS(){\n\t$(\"#SlideSfsFrame\").hide();\n\t$(\"#SlideSFSOpener\").show();\n\t$(\".sliderSwipe\").show();\n}\n//swipe left close filter /*changed*/\n$( document ).on( \"swiperight\", \".sliderSwipe\", function( e ) {\n\tshowSlideSFS();\n});\n$( document ).on( \"swiperight\", \"#SlideSFSOpener\", function( e ) {\n\t\n\tshowSlideSFS();\n});\nfunction openPharmacyOrders(){\n\t$(\"#PageLoadingAnimation\").show();\n\tparent.openPharmacyOrders();\n}\t\t\t\t\t\t\t\t\t\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\n.absoluteCenter {\n  margin: auto;\n  position: absolute;\n  top: 0; left: 0; bottom: 0; right: 0;\n}\n.slideSfsOpener\n{\n\tposition:absolute;\n\tz-index:6000;\n\ttop: calc(100%/2); \n}\n.SlideSfsFrame{\n\twidth:235px;\n\theight:calc(100% - 10px);\n\tposition:absolute; \n\tz-index:5000;\n\tmargin-top:5px;\n\tbackground-color: #eaedf2;\n}\n.slidesFrameWrap{\n\tdisplay:none;\n}\n.sliderSwipe{\n\tposition: absolute;\n\twidth: 20px;\n\theight: 100%;\n}\n#PageLoadingAnimation{\n\tz-index: 10000;\n\tposition: absolute;\n\tleft: 0px;\n\ttop: 0px;\n\twidth: 100%;\n\theight: 100%;\n\tbackground-color: #808080;\n\topacity: 0.6;\n\tbackground-image: url(";
    private final static byte[]  _wl_block14_2Bytes = _getBytes( _wl_block14_2 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\tdisplay: none; \n}\n\n</style>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n</head>\n<body style=\"display: block; margin: 0px; height: 100%; width: 100%;\">\n\t <div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" onclick=\"\" data-popid=\"\" onclick=\"closeMez()\"></div> \n\t\t<div style=\"display:table;table-layout:fixed;width: 100%;\">\n\t\t<div style=\"display:table-row\">\n\t\t\t<div  class=\"slidesFrameWrap\">\n\t\t\t\t<!-- Slide SFS popup STARTS -->\n\t\t\t\t\t\t\t\t<div class=\"SlideSfsFrame\" id=\"SlideSfsFrame\"></div>\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name =\"currentECID\" id =\"currentECID\" value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n\t\t\t\t<!-- Slide SFS popup ENDS -->\n\t\t\t</div>\n\t\t\t<div style=\"display:table-cell;\" class=\"rightContentWrap\">\n\t\t\n\t<!--  Slide SFS overlay button STARTS -->\n  \t     <div class=\"sliderSwipe\" ></div>\n    <div  class=\"slideSfsOpener\" onclick=\"showSlideSFS()\" id=\"SlideSFSOpener\"><img id=\"sfsSearchImg\" src=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/eIPAD/images/Open_window.png\"/></div>\n\t\t\n\t<!--  Slide SFS overlay button ENDS -->\n\t\n\t\n\t\n\t<div class = \"ChartSummaryParent ChartSummaryParentTheme\"  style=\"position:inherit\" data-role=\"page\" >\n\t\t<div class=\"ChartSummaryBlock\" id=\"ChartSummaryBlock\" data-role = \"none\">\n\t\t\n\t\t<div id=\"PageLoadingAnimation\" class=\"absoluteCenter\"></div>\n\t\t\n\t\t\t<form id=\"ChartSummaryForm\" name = \"ChartSummaryForm\" method = \"post\" action = \"\" class=\"ChartSummaryFormElem\">\n\t\t\t\t<div class=\"ChartSummaryMainTable\" data-role = \"none\">\n\t\t\t\t\t<div data-role = \"none\" class =\"ChartSummaryPageHeader\" id=\"CSHeader\">\n\t\t\t\t\t\t<div class=\"ChartSummaryHeaderCell\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderCont\" data-role = \"none\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- Encounter popup starts -->\n\t\t\t\t\t\t\t\t<div id=\"EncListPopup\" class=\"EncListPopParentContainer\">\n\t\t\t\t\t\t\t\t\t<div class=\"EncListPopupArrowUpTheme\"></div>\n\t\t\t\t\t\t\t\t\t<div class=\"EncListAreaContainer EncListAreaContainerTheme\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n<!-- \t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\n\t\t\t\t\t\t\t\t\t\t\t\tHeader starts here\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" class=\"EncPopHeaderHeader EncPopHeaderHeaderTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:25%;vertical-align:middle;text-align:center\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopHeaderButtonTheme\" style=\"text-align:center\" onclick=\"hideEncListPopup()\">Cancel</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopHeaderTextTheme\" style=\"display:table-cell;vertical-align:middle;width:50%\">Encounter</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:25%;vertical-align:middle;text-align:center\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopHeaderButtonTheme\" style=\"text-align:center\" onclick=\"chooseEncounter(\'\')\">Current</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\theader ends here\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t\t\t\t\t<!-- <div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\n\t\t\t\t\t\t\t\t\t\t\t\tSlider for Patient class filter starts here\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopClassFilterContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;\" class=\"EncPopSliderContainerTheme EncPopSliderContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\tSlider for Patient class filter starts here\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t<!--All Encounters List content starts here-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopCurrentEncContainerTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\" class=\"EncPopCurrentEncStripTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Current/Base Encounter item starts -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\"  onclick=\"chooseEncounterForNote(\'\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row;\" class=\"EncPopListRow\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListIconCol\"><img src=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/eIPAD/images/OutPatient32x32.png\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListDetCol\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopCurPractTextTheme\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopCurIdTextTheme\">EN ID - ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:bottom;text-align:right\"><div  class=\"EncPopCurDateTextTheme\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListIconCol\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Current/Base Encounter item ends -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Other Encounter items scroller starts-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"EncListcontainer-wrapper\" class=\"EncListPopupWrapper\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"EncListcontainer-contents\" class=\"EncListPopupScroller\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Other Encounter items starts -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onclick=\"chooseEncounterForNote(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row;\" class=\"EncPopListRow\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListIconCol\"><img src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/OutPatient32x32.png\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListDetCol\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopPractTextTheme\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"EncPopIdTextTheme\">EN ID - ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:bottom;text-align:right\"><div  class=\"EncPopDateTextTheme\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"EncPopListIconCol\"><img src=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="/eIPAD/images/Right_Arrow.png\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Other Encounter items ends -->\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Other Encounter items scroller ends  -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<!--All Encounters List content ends here -->\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<!-- Encounter popup ends -->\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderTable ChartSummaryHeaderTableTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderIconCol\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\"><img src=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="/eIPAD/images/MenuIcon.png\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderTextCol\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderText ChartSummaryHeaderTextTheme\" data-role = \"none\">Clinical Notes</div><!-- TODO replace with message bundle text -->\n\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\t<!-- </div> -->\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\" onclick=\"closeClinicalNotes()\">\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"closeClinicalNotes()\"><img src=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="/eIPAD/images/CS_Close16x16.png\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<div id=\"ClinicalNotes\" class=\"divClinicalNotesContent divAllergyContentTheme\" style=\"padding: 0px; overflow: hidden\" data-role=\"none\"> \n\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageContent ChartSummaryPageContentTheme\" id=\"ChartSummaryPageContent\">\n\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageContentCell\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryMainWrapper\" id=\"ChartSummaryMainWrapper\" style=\" overflow:hidden;position:relative\">\n\t\t\t\t\t\t\t\t<div class=\"ChartSummaryMainScroller\" id=\"ChartSummaryMainScrollerID\" style=\"width:100%;height:auto\" data-role = \"none\"><!-- scrolling content starts -->\n\t\t\t\t\t\t\t\t\t<div id=\"clinicalNotesFrame\" class=\"ChartWidgetframe\" data-role=\"none\" style = \"padding:0px;\"></div>\n\t\t\t\t\t\t\t\t</div><!-- scrolling content ends -->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup, but not currently used in Orders - STARTS CONSIDER FOR REMOVAL TODO-->\n\t\t\t\t\t\t\t\t<div id=\"CSCommonPopUpContainer\" class=\"CSCommonPopUpContainer\">\n\t\t\t\t\t\t\t\t\t<!-- <div id=\"CSCommonPopUpContainer-arrowUp\" class=\"CSCommonPopup-arrowUpTheme\"></div> -->\n\t\t\t\t\t\t\t\t\t<div  class=\"CSCommonPopup CSCommonPopupTheme\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;height:40px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table\" class=\"CSCommonPopupHeader CSCommonPopupHeaderTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:100px;vertical-align:middle;text-align:left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"CSCommonPopupCloseBtnTheme\" id=\"CSCommonPopupCloseBtn\" onclick=\"closePopup(\'CSCommonPopUpContainer\')\">Close</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:80%;vertical-align:middle;text-align:center;padding-right:150px;\" class=\"CSCommonPopupHeaderTextTheme\" id=\"CSCommonPopUpContainer-title\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row; \">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SFSBackgroundTheme\" style=\"display:table-cell;/* width:100% */;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"CSCommonPopUpContainer-wrapper\" class=\"CSCommonPopupWrapper\" style=\"margin:10px;background:#fff;height:332px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"CSCommonPopUpContainer-scroller\" class=\"CSCommonPopupScroller\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"CSCommonPopUpContainer-contents\" class=\"CSCommonPopupContents\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<!-- <div id=\"CSCommonPopUpContainer-arrowDown\" class=\"CSCommonPopup-arrowDownTheme\"></div> -->\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup but not currently used in Orders - ENDS-->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!-- Transaction message -->\n\t\t\t\t\t\t\t\t<div class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" CSTransactionMessage\" id=\"transactionMsg\" style=\"bottom: 10px; left: 10px; display: none\">\n\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id = \"transactionMessageContent\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<!-- End of Transaction message -->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooter\"  id=\"CSFooter\">\n\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterCell\">\n\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterCont\">\n\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterTable ChartSummaryPageFooterTableTheme\">\n\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterRow\">\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterFirstCol\"></div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openChartSummaryFrame()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnSelTheme\" onclick=\"openClinicalNotes()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">Clinical<br/>Notes</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openOrdersFrame()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openClinicalEvents()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">Clinical Events</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openPharmacyOrders()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">Pharmacy Order</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterLastCol\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"transactionOccurred\" id=\"transactionOccurred\" id=\"transactionOccurred\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnSelEncID\" id = \"hdnSelEncID\" value =\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" />\n\t\t\t\t<input type = \"hidden\" name = \"hdnStrDate\" id = \"hdnStrDate\" value =\" \" />\n\t\t\t\t<input type = \"hidden\" name = \"hdnEndDate\" id = \"hdnEndDate\" value =\" \" />\n\t\t\t</form>\n\t\t</div>\n\t\t\n\t\t<div style=\"width:100%;height:100%;display:none;\" id=\"clinicalNotesDiv\">\n\t\t<div style=\"display:table;width:100%;height:100%;\" >\n\t\t\t<div style=\"display:table-row\">\n\t\t\t\t<div style=\"display:table-cell;padding:5px;\">\n\t\t\t\t\t<div style=\"display:table;width:100%;height:100%;position:relative\" id=\"clinicalNotesDiv\">\n\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t<div style=\"display:table-cell;width:100%;height:100%;background:white;position:absolute\" id=\"ClinicalNotesContentDisplay\">\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\t</div>\n\t\t\n\t</div>\n\t\t<!-- end of table row -->\n\t\t</div>\n\t</div>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
PatContext patientContextInsit = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
String currentEcID = patientContextInsit.getEncounterId();
	

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
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
            _bw.write(_wl_block14_0Bytes, _wl_block14_0);
            _bw.write(_wl_block14_1Bytes, _wl_block14_1);
            _bw.write(_wl_block14_2Bytes, _wl_block14_2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block3Bytes, _wl_block3);

String formValErrClass = "";
String transactionMessage = "";
String transactionResult = "";
String transactionOccurred = "false";
if(request.getParameter("transactionOccurred") != null && request.getParameter("transactionOccurred").equals("true")){
	transactionOccurred = request.getParameter("transactionOccurred") == null?"":request.getParameter("transactionOccurred");
	transactionMessage = request.getParameter("transactionMessage") == null?"":request.getParameter("transactionMessage");
	transactionResult = request.getParameter("transactionResult") == null?"":request.getParameter("transactionResult");
	if(transactionResult.equals("0")){ 
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

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(currentEcID));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(currentEncounter.getPractShortName()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(currentEncounter.getEncounterId()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(currentEncounter.getFromDate() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(allEncArrayList!=null && allEncArrayList.size()>1){
																		
            _bw.write(_wl_block23Bytes, _wl_block23);
for(int i=1;i<allEncArrayList.size();i++){ 
																			EncounterHO iEncounter = allEncArrayList.get(i);
																			String cssClassName = "EncPopNormEncStripTheme";
																			if(secondaryEncSelected && selectedEncounter.equals(iEncounter.getEncounterId())){
																				cssClassName = "EncPopSelEncStripTheme";
																				selectedEncIndex = i;
																			}
																			
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cssClassName ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(iEncounter.getEncounterId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(iEncounter.getPractShortName()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(iEncounter.getEncounterId()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iEncounter.getFromDate() ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);

																			}
																			
																			
            _bw.write(_wl_block32Bytes, _wl_block32);
} 
            _bw.write(_wl_block33Bytes, _wl_block33);
 
									String encLeftNaviStyle = "WidgetButtonTheme";
									String encRightNaviStyle = "WidgetButtonTheme";
									String encLeftNaviClickFunc = "";
									String encRightNaviClickFunc = "";
									if(selectedEncIndex <= 0){
										encLeftNaviStyle = "WidgetButtonDisableTheme";
									}
									//select base encounter
									else if(selectedEncIndex == 1){
										encLeftNaviClickFunc = "chooseEncounterForNote('')";
									}
									else{
										encLeftNaviClickFunc = "chooseEncounterForNote('"+allEncArrayList.get(selectedEncIndex-1).getEncounterId()+"')";
									}
									if(selectedEncIndex+1 >= allEncArrayList.size()){
										encRightNaviStyle = "WidgetButtonDisableTheme";
									}
									else{
										encRightNaviClickFunc = "chooseEncounterForNote('"+allEncArrayList.get(selectedEncIndex+1).getEncounterId()+"')";
									}
								
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block37Bytes, _wl_block37);
            _bw.write(_wl_block38Bytes, _wl_block38);
            _bw.write(_wl_block39Bytes, _wl_block39);
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(formValErrClass ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(transactionMessage ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(csResBundle.getString("common.chartSummary") ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(csResBundle.getString("common.order") ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(transactionOccurred ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patientContext.getEncounterId()));
            _bw.write(_wl_block48Bytes, _wl_block48);
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
