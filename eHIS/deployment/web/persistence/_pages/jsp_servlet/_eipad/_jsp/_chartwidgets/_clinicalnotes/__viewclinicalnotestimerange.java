package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ResourceBundle;
import java.util.*;
import eIPAD.chartsummary.clinicalnotes.response.*;
import eIPAD.chartsummary.clinicalnotes.healthobject.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import com.google.gson.Gson;;

public final class __viewclinicalnotestimerange extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/ViewClinicalNotesTimeRange.jsp", 1709118016256L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/css/kendo.common.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/kendo.default.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/css/kendo.dataviz.min.css\" />\n\n<script src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/kendo.web.min.js\"></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<script type=\"text/javascript\">\n\tvar myScrollnotes;\n\tfunction scrollNotes() {\n\t\t$(\'.swipeWrapper\').bind(\'touchstart click\', function(event) {\n\t\t\t var currentNotesId = $(this).attr(\'id\');\n\t\t\t if(currentNotesScrollingId)\n\t\t\t {\n\t\t\t\t if(currentNotesScrollingId != currentNotesId)\n\t\t\t\t {\n\t\t\t\t\t\tmyScrollnotes = new iScroll(currentNotesId, {\n\t\t\t\t\t\t\thScrollbar : false\n\t\t\t\t\t});\n\t\t\t\t\t\tcurrentNotesScrollingId = currentNotesId;\t\n\t\t\t\t }\n\t\t\t }\n\t\t\t else\n\t\t\t {\n\t\t\t\t currentNotesScrollingId = currentNotesId;\n\t\t\t\t\tmyScrollnotes = new iScroll(currentNotesId, {\n\t\t\t\t\t\thScrollbar : false\n\t\t\t\t});\n\t\t\t }\n\t\t});\n\t}\n\tfunction filterNotes(filterBy,loggedInUser) \n\t{\n\t\t\n\t\t\t\n\t\tif(loggedInUser == undefined)\n\t\tloadClinicalNotes(filterBy, \'fullView\', \'\', \'\', \'\');\n\telse\n\t\tloadClinicalNotes(filterBy, loggedInUser, \'\', \'\', \'\');\n\t\t\n\t\n\t}\n\tvar arrSPL = [];\n\tfunction myList(val,type){\n\t\t/* if(type==\"ML\"){\n\t\t\tif($(\"#SLSfsTickMLPract\").is(\":visible\")){\n\t\t\t\tvar index = arrML.indexOf(val);\n\t\t\t\tarrML.splice(index, 1);\n\t\t\t\t$(\"#SLSfsTickMLPract\").hide();\n\t\t\t\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t\t\t}\n\t\t\telse{\n\t\t\t\tarrML.push(val); \n\t\t\t\t$(\"#SLSfsTickMLPract\").show();\n\t\t\t\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t\t\t}\n\t\t} */\n\t\tif(type==\"SPL\"){\n\t\t\t\n\t\t\t\tarrSPL.push(val); \n\t\t\t\t\n\t\t\t\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t\t\t\n\t\t}\n\t}\n\tfunction unique(list) {\n\t  var result = [];\n\t  $.each(list, function(i, e) {\n\t\tif ($.inArray(e, result) == -1) result.push(e);\n\t  });\n\t  return result;\n\t}\n    var currentBubble;\n    var CurPageNum;\n    var CurPos;\n    var accArrayStr = $(\"#hdnAccessionNum\").val();\n\taccArray = $.parseJSON(accArrayStr);\n\taccArray = unique(accArray);\n\taccArray = AccNumber.length > 0 ? AccNumber : accArray;\n\tfunction showNotesSwipeNew(typ,accArray) {\n\t\tvar accessionNumLT;\n    \tvar accessionNumRT;\n    \tvar accNumPos;\n    \tvar inr;\n    \tvar dcr;\n    \tif(typ==\'LT\'){\n\t\t\tif (currentBubble != null && currentBubble != \'\') {\n\t\t\t\taccessionNumLT = encodeURIComponent(currentBubble);\n\t\t\t\taccNumPos = accArray\n\t\t\t\t\t\t.indexOf(decodeURIComponent(accessionNumLT));\n\t\t\t\tinr = ++accNumPos;\n\t\t\t\tCurPageNum = accNumPos + 1;\n\t\t\t\tif (inr < accArray.length) {\n\t\t\t\t\taccessionNumLT = accArray[inr];\n\t\t\t\t\tshowNotesContentFullView(accessionNumLT);\n\t\t\t\t\tcurrentBubble = accessionNumLT;\n\t\t\t\t}\n    \t\t}\n    \t}\n    \tif(typ==\'RT\'){\n    \t\tif(currentBubble!=null && currentBubble!=\'\'){\n    \t\t\taccessionNumRT = encodeURIComponent(currentBubble);\n\t\t\t\taccNumPos = accArray\n\t\t\t\t\t\t.indexOf(decodeURIComponent(accessionNumRT));\n\t\t\t\tdcr = --accNumPos;\n    \t\t\tCurPageNum=accNumPos+1;\n    \t\t\tif(dcr != -1){\n    \t\t\t\taccessionNumRT = accArray[dcr];\n            \t\tshowNotesContentFullView(accessionNumRT);\n            \t\tcurrentBubble = accessionNumRT;\n    \t\t\t}\n    \t\t}\n    \t}\n    }\n\n     function showNotesContentFullView(accessionNum){\n    \t$(\'#ClinicalNotesContentDisplay\').load(path+\'/eIPAD/jsp/ViewClinicalNotesContentFullView.jsp?accession_num=\' + accessionNum);\n    \t$(\'#ChartSummaryBlock\').hide();\n    \t$(\'#clinicalNotesDiv\').show();\n    \t$(\'#SlideSFSOpener\').hide();\n    } \n\tfunction showNoteContentClick(bubbleObj) \n\t{\n\t\t\taccessionNum = $(bubbleObj).attr(\"data-accNumber\");\n\t\t\t$(\"[data-fullView = \'true\']\").each(function(index, value) {\n\t\t\t\t$(\"[data-noteType = \" + $(this).attr(\'data-fullviewnotetype\')+\"]\").find(\".swipeWrapper\").show();\n\t\t\t\t$(this).hide();\n\t\t\t});\n\t\t\tcnNoteType =\'\';\n\t\t\t$(\".dataContainerFullView:visible\").each(function (i,v ){\n\t\t\t\tAccNumber.push($(this).attr(\'data-accnumber\'));\n\t\t\t});\n\t\t\n\t\taccArray = AccNumber.length > 0 ? AccNumber : accArray;\n\t\tif (accessionNum != null && accessionNum != \"\") {\n\t\t\tcurrentBubble = accessionNum;\n\t\t\taccessionNum = escape(accessionNum);\n\t\t\tshowNotesContentFullView(accessionNum);\n\t\t\tCurPos = accArray.indexOf(decodeURIComponent(accessionNum));\n\t\t\t//curPos = accArray.indexOf(\"CNHS14$00000000088507\");\n\t\t\tCurPageNum = 1 + CurPos;\n\t\t}\n\t\t$(\'.slidesFrameWrap\').hide();\n\t\t$(\'.ChartSummaryParent \').css(\'position\', \'absolute\');\n\t}\n    \n    function closeNotesContentFullView(){\n\t\tAccNumber=[];\n     \t$(\'#ChartSummaryBlock\').show();\n     \t$(\'#clinicalNotesDiv\').hide();\n     \tif(isOpened){\n\t\t\t$(\'.slidesFrameWrap\').show()\n\t\t}else{\n\t\t\t$(\'#SlideSFSOpener\').show();\n\t\t}\n\t\t$(\'.ChartSummaryParent \').css(\'position\',\'inherit\');\n     } \n    var accArray;\n    $(document).ready(function() {\n\t\tassignSliderWidth();\n\t\tsetScrollerWidth();\n\t\tscrollNotes();\n\t});\n\tfunction openCreateCNFrame(){\n\t\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src =\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/mobile/charts/notes/MRecClinicalNotesInit\';\n\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\n</script>\n\n<div class=\"procWidgetParent widgetParentTheme\" data-role=\"none\">\n\t<div class=\"widgetTable\" data-role=\"none\">\n\t\t<div class=\"widgetHeaderRow widgetHeaderRowTheme\" data-role=\"none\"><!-- header row -->\n\t\t\t <div class=\"widgetHeaderMarginCell\" style=\"width:auto\" data-role=\"none\">\n\t\t\t\t<!-- <div class=\"widgetHeaderMarginExtn widgetHeaderMarginExtnTheme\" data-role=\"none\"></div> -->\n\t\t\t\t<!-- <div class=\"widgetHeaderIcontriangle\" data-role=\"none\"></div> -->\n\t\t\t</div>\n\t\t\t\n\t\t\t<div class=\"widgetHeaderCell widgetHeaderCellTheme\" data-role=\"none\">\n\t\t\t\t<div class=\"widgetHeaderSubTable\" data-role=\"none\">\n\t\t\t\t\t<div class=\"widgetHeaderSubRow\" data-role=\"none\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t\t\t\t\t   <div class=\"widgetHeaderHeadingTextCol\" data-role=\"none\">\n\t\t\t\t\t\t\t<span class=\"widgetHeaderHeadingTextTheme\" data-role=\"none\"></span>\n\t\t\t\t\t\t</div>   \n\t\t\t\t\t\t<div class=\"clinicalNotesFilterCol\" data-role=\"none\" >\n\t\t\t\t\t\t\t<table style=\"height: 100%; width: 100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t\t\t\t\t\t<td style=\"width: 100%\" align=\"right\" valign=\"center\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"notesFilterContainer\">\n\t\t\t\t\t\t\t\t\t\t\t<table style=\"width: 100%; height: 100%;\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!--<td class=\"notesIconTheme\" filter-type=\"A\" valign=\"center\" align=\"center\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-filterIcon=\"T\" data-filterBy=\"A\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"filterNotes(\'A\')\"><img\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/view01.png\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"vertical-align: middle;\" /></td>-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"notesIconTheme\" filter-type=\"N\" valign=\"center\" align=\"center\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-filterIcon=\"T\" data-filterBy=\"NUR$\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"filterNotes(\'N\')\"><img\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/Nursing_NotesW24x24.png\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"notesIconTheme\" filter-type=\"P\" valign=\"center\" align=\"center\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-filterIcon=\"T\" data-filterBy=\"PHY$\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"filterNotes(\'P\')\"><img\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/images/PhysicianNotesW24x24.png\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"notesIconTheme\" filter-type=\"C\" valign=\"center\" align=\"center\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-filterIcon=\"T\" data-filterBy=\"CLI$\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"filterNotes(\'C\')\"><img\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/images/Clinician_NotesW24x24.png\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"notesIconTheme\" filter-type=\"SPL\" valign=\"center\" align=\"center\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-filterIcon=\"T\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"filterNotes(\'SPL\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\"><img\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/MySpecialty24x24.png\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t   \t\t<td style = \"padding-left:5px;\" class=\"widgetHeaderPlusButtonCell\" data-role = \"none\" onclick=\"openCreateCNFrame()\">\n\t\t\t\t\t   \t\t\n\t\t\t\t\t   \t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" ><img src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/CS_add16x16.png\"></div>\n\t\t\t\t\t\n\t\t\t\t\t   \t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div><!-- header row ends -->\n\t\t<div id=\"CNdivcnt\" class=\"widgetContentRow\" data-role=\"none\"><!-- content row starts -->\n\t\t\t<div class=\"widgetHeaderMarginCell\" data-role=\"none\"></div>\n\t\t\t<div class=\"widgetContentCell   \" data-role=\"none\">\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n\t\t\t\t<div class=\"AllergyContentTable WidgetContentStripTheme clinicalNotesContent\" data-notetype=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" data-role=\"none\" id=\"cTable\"><!-- content strip starts -->\n\t\t\t\t\t<div class=\"AllergyContentRow AllergyContentRowTheme\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"notesContentCol1 WidgetContentStripCol1Theme\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"AllergyReactionCount WidgetContentStripCol1BoxTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"ClinicalNoteCountCircleTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCountCircleText\" data-role=\"none\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/eIPAD/images/";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"  class=\"NotesImage\" />\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"notesContentCol2\" data-role=\"none\">\n\t\t\t\t\t\t\t<div data-role=\"none\" class=\"swipeTable\" id=\"swipeTable\" data-count=\"1\" >\n\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-row;vertical-align:middle; width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t<div data-role=\"none\" data-content=\"1\" style=\"display: table-cell;word-break:break-all; width: 1%; height: 67px; vertical-align: middle; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\"  class=\"WidgetParaHeadTextTheme notesText\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-cell; width: 98%; height: 67px; vertical-align: middle; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"swipeWrapper\" id=\"wrapper";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" data-IdCount = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" data-noteType = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"> <!-- wrapper starts -->\n\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"notesScroller\" id=\"notesScroller";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"> <!-- scroller starts -->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n   \t\t \t\t\t\t\t\t\t \t\t\t\t   \t\t\t\t\t<div data-role=\"none\" class = \"bubbleDivider notesDividerTheme\" data-noteTypeValue = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></div>\n   \t\t \t\t\t\t\t\t\t \t\t\t\t   \t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"dataContainerFullView\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-noteTypeValue = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-accNumber = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-notetype=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-serv=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-perform=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-status=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-showNote=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick = \"showNoteContentClick(this)\"> <!-- data buble starts-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table; width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-row; width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-cell; width: 1%; height: 100%; vertical-align: middle; text-align: center; border-radius: 30px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"iconContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t<img src=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-cell; width: 99%; height: 100%; border-radius: 30px; vertical-align: middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"dateContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"notesDate\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div><!-- data bubble ends -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t\t</div><!-- scroller ends -->\n\t\t\t\t\t\t\t\t\t\t</div><!-- wrapper ends -->\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"notesContentCol3\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"notesExpandCollapse\" data-role=\"none\" data-expandNoteType = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" onclick = \"showFullViewNotes(this ,\'timeRangeView\')\">\n\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="/eIPAD/images/Expandview.png\" id=\"ExpCollAllergy\" data-imagaeNoteType = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"></img>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div><!-- div table ends   -->\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t   \t<!-- full view for each table -->\n\t\t\t\t<div data-role = \"none\" style = \"display:none;width:100%;height:auto;background-color:#ffffff\" data-fullViewNoteType = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" data-fullView = \"true\">\n\t\t\t\t</div>\n\t\t\t\t<!-- full view for each table ends -->\t\t\n\t\t\t   \t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t   \t\t<div class=\"WidgetVwErrContainer\">\n\t\t\t\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t \t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\n\t\t\t   \t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t<input type = \"hidden\" name =\"hdnCNCount\" id =\"hdnCNCount\" value = \'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'/>\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t<div class=\"WidgetVwErrContainer mySpecialityNoRecords\" style=\"display:none\">\n\t\t\t\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">\n\t\t\t\t\t\t\tNo clinical notes recorded for the patient\n\t\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<input type = \"hidden\" name =\"hdnAccessionNum\" id =\"hdnAccessionNum\" value = \'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'/>\n\n\t\t\t<!-- var str = \"1,2,3,4,5,6\";\n\t\t\t\t var temp = new Array();\n\t\t\t\t temp = str.split(\",\"); -->\n\t\t\t\n\t\t\t\n\t\t\t</div><!-- content cell ends -->\n\t\t</div><!-- content row ends -->\n\t</div><!-- widget table ends -->\n</div>\n\t\t\t<!-- mySpecialityList STARTS -->\n            ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t<input type = \"hidden\" name =\"hdnCount\" id =\"hdnCount\" value = \"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"/>\n\t\t\t<input type = \"hidden\" name =\"hdnLoggedInUser\" id =\"hdnLoggedInUser\" value = \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"/>\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t<input type = \"hidden\" name =\"hdnSpeciality\" id =\"hdnSpeciality";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" value = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\n<!-- div paren end -->\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Locale appLocale;
	String noteStatus = "";
	if (session.getAttribute("LOCALE") != null
			&& !session.getAttribute("LOCALE").equals(""))
		appLocale = new Locale((String) session.getAttribute("LOCALE"));
	else
		appLocale = new Locale("en");
	ResourceBundle csResBundle = ResourceBundle.getBundle(
			"eIPAD.chartsummary.common.resourcebundle.cslabels",
			appLocale);
	
	int nListSize = 0;
	ClinicalNotesResponse oCnRes = null;
	List<ClinicalNoteGroup> listNoteGroup = null;
	if(request.getAttribute("ClinicalNotesViewResponse") != null)
	{
		oCnRes = (ClinicalNotesResponse)request.getAttribute("ClinicalNotesViewResponse");
		if(oCnRes != null)
		{
			listNoteGroup = oCnRes.getListNoteGroup();
			
		}
		if(listNoteGroup != null)
		{
			nListSize = listNoteGroup.size();
		}
	}	
	Gson gson = new Gson();
	String jsonFieldRes = "";
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
	String loggedInUser = patientContext.getLoggedInUser();

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(loggedInUser));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);

				ArrayList<String> accArray = new ArrayList<String>();
				int nLoopCount = 0;
			    String notesImage = "PhysicianNotesW24x24.png" ;
			   	if(nListSize > 0 )
			   	{
			   		ClinicalNoteGroup oCnGrp = null;
			   		int nSubLoopCount = 0;
			   		int nSubLoopSize = 0;
			   		String dateValue = "";
			   		for(nLoopCount = 0; nLoopCount < nListSize; nLoopCount++)
			   		{
			   			oCnGrp = listNoteGroup.get(nLoopCount);
			   			if(oCnGrp != null)
			   			{
			   				 nSubLoopCount = 0;
					   		 nSubLoopSize = 0;
					   		 List<NoteDetailsTimeRange> oLstNoteDetailsTimeRanges = null;
					   		 oLstNoteDetailsTimeRanges = oCnGrp.getListNoteDetailsTimeRange();
					   		 if(oLstNoteDetailsTimeRanges != null)
					   		 {
					   			nSubLoopSize = oLstNoteDetailsTimeRanges.size(); 
					   		 }
					   		
			 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oCnGrp.getChildCount() ));
            _bw.write(_wl_block20Bytes, _wl_block20);

								   String eventClass = oCnGrp.getGroupDescription().getEventClass();
								   if(eventClass != null)
								   {
									   if(eventClass.equals("NUR$"))
									   {
										   notesImage = "Nursing_NotesW24x24.png";
									   }
									   else if(eventClass.equals("CLI$"))
									   {
										   notesImage = "Clinician_NotesW24x24.png";
									   }
									   else
									   {
										   notesImage = "PhysicianNotesW24x24.png" ;
									   }
								   }
								
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(notesImage ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByDesc()));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block28Bytes, _wl_block28);

												if(nSubLoopSize > 0)
												{
													NoteDetailsTimeRange oNoteDetailsTimeRange = null;
													for(nSubLoopCount = 0 ; nSubLoopCount < nSubLoopSize;nSubLoopCount++ )
													{
														oNoteDetailsTimeRange = oLstNoteDetailsTimeRanges.get(nSubLoopCount);
														if(oNoteDetailsTimeRange != null)
														{
											  
            _bw.write(_wl_block29Bytes, _wl_block29);

											  				if(nSubLoopCount > 0)
   		 							 				   		{
   		 							 				   			if(!dateValue.equals(oNoteDetailsTimeRange.getDescription().getDescription())  )
   		 							 				   			{
   		 							 				   				
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block31Bytes, _wl_block31);
 
   		 							 				   			}
   		 							 				   		}
   		 							 				      dateValue = oNoteDetailsTimeRange.getDescription().getDescription();
   		 							 				      if(oNoteDetailsTimeRange.getStatus() != null)
   		 							 				      {
   		 							 				    	  if(oNoteDetailsTimeRange.getStatus().equals("1"))
   		 							 				    	  {
   		 							 				    		  noteStatus = "In_Progress24x24.png";
   		 							 				    	  }
   		 							 				    	  else if(oNoteDetailsTimeRange.getStatus().equals("2"))
   		 							 				    	  {
   		 							 				    		  noteStatus = "Transcribed24x24.png";
   		 							 				    	  }
   		 							 				    	  else if(oNoteDetailsTimeRange.getStatus().equals("3"))
 		 							 				    	  {
 		 							 				    		  noteStatus = "Unauthorized24x24.png";
 		 							 				    	  }
   		 							 				    	  else if(oNoteDetailsTimeRange.getStatus().equals("4"))
		 							 				    	  {
		 							 				    		  noteStatus = "Authorized24x24.png";
		 							 				    	  }
   		 							 				    	  else if(oNoteDetailsTimeRange.getStatus().equals("5"))
		 							 				    	  {
		 							 				    		  noteStatus = "Modified.png";
		 							 				    	  }
   		 							 				    	  else if(oNoteDetailsTimeRange.getStatus().equals("9"))
		 							 				    	  {
		 							 				    		  noteStatus = "InError24x24.png";
		 							 				    	  }
   		 							 				    	  else
   		 							 				    	  {
   		 							 				    		  noteStatus = "";
   		 							 				    	  }
   		 							 				      }
   		 							 				 		accArray.add(oNoteDetailsTimeRange.getAccessionNum());
											  				
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(oNoteDetailsTimeRange.getAccessionNum()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(oNoteDetailsTimeRange.getNoteType()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(oNoteDetailsTimeRange.getServiceCode()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(oNoteDetailsTimeRange.getPerformedBy()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oNoteDetailsTimeRange.getStatus()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oNoteDetailsTimeRange.getActionType()));
            _bw.write(_wl_block39Bytes, _wl_block39);

																			    	if(!noteStatus.equals(""))
																			    	{
																			    		
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(noteStatus));
            _bw.write(_wl_block41Bytes, _wl_block41);
 
																			    	}
																			    
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(oNoteDetailsTimeRange.getDescription().getDescription() ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(oNoteDetailsTimeRange.getDescription().getEventTime() ));
            _bw.write(_wl_block44Bytes, _wl_block44);

														}//if notedetails
													}//for
												}//if subloop
												
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block48Bytes, _wl_block48);

			   			}//oCrgp
			   			
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block50Bytes, _wl_block50);
 		
			   		}//for
			   	}//if
			   	else
			   	{
			   		
            _bw.write(_wl_block51Bytes, _wl_block51);

							 		if(oCnRes != null)
							 		{
							 			
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(oCnRes.getErrorsList().get(0).getErrorMessage() ));
            _bw.write(_wl_block53Bytes, _wl_block53);
 
							 		}
							 
            _bw.write(_wl_block54Bytes, _wl_block54);

			   	}
			   	int count = accArray.size();
			   
				
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(count));
            _bw.write(_wl_block56Bytes, _wl_block56);

				jsonFieldRes = gson.toJson(accArray);
				
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(jsonFieldRes));
            _bw.write(_wl_block58Bytes, _wl_block58);

            int nLoopCount1 = 0;
        	int nRowCount = 0;
        	String specCode= "";
        	ClinicalNotesBC objBC = new ClinicalNotesBC();//calling bc
			ClinicalNotesFieldResponse oClintSPL = objBC.getMySpecialityList(patientContext);//for response
		 	List<ClinicalNotesFieldItem> MySpecialityListSFS;//to get the list
			ClinicalNotesFieldItem oCNFieldItemsSPL;//obj to get field values
			MySpecialityListSFS = oClintSPL.getFieldList();
			int nLstCountSPL = MySpecialityListSFS.size(); 
			
			
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(nLstCountSPL));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(loggedInUser));
            _bw.write(_wl_block61Bytes, _wl_block61);

			for(nLoopCount1=0; nLoopCount1<nLstCountSPL; nLoopCount1++){ 
				oCNFieldItemsSPL = MySpecialityListSFS.get(nLoopCount1);
				  	if(oCNFieldItemsSPL != null ){
					specCode = oCNFieldItemsSPL.getDesc();
			
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(nLoopCount1));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block61Bytes, _wl_block61);

				  	}
			}
			
            _bw.write(_wl_block64Bytes, _wl_block64);
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
