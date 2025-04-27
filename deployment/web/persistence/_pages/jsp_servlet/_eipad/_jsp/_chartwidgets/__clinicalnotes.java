package jsp_servlet._eipad._jsp._chartwidgets;

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

public final class __clinicalnotes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ClinicalNotes.jsp", 1709118016662L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<script type=\"text/javascript\">\n\tvar myScrollnotes;\n\tfunction scrollNotes() {\n\t\t$(\'.swipeWrapper\').bind(\'touchstart click\', function(event) {\n\t\t\t var currentNotesId = $(this).attr(\'id\');\n\t\t\t if(currentNotesScrollingId)\n\t\t\t {\n\t\t\t\t if(currentNotesScrollingId != currentNotesId)\n\t\t\t\t {\n\t\t\t\t\t\tmyScrollnotes = new iScroll(currentNotesId, {\n\t\t\t\t\t\t\thScrollbar : false\n\t\t\t\t\t});\n\t\t\t\t\t\tcurrentNotesScrollingId = currentNotesId;\t\n\t\t\t\t }\n\t\t\t }\n\t\t\t else\n\t\t\t {\n\t\t\t\t currentNotesScrollingId = currentNotesId;\n\t\t\t\t\tmyScrollnotes = new iScroll(currentNotesId, {\n\t\t\t\t\t\thScrollbar : false\n\t\t\t\t});\n\t\t\t }\n\t\t});\n\t} \n     \n    function filterNotes(filterBy,loggedInUser) \n\t{\t\t\n\t\tif(loggedInUser == undefined)\n\t\t  loadClinicalNotes(filterBy, \'widgetView\', \'\', \'\', \'\');\n\t    else\n\t\t  loadClinicalNotes(filterBy, loggedInUser, \'\', \'\', \'\');\n   }\n    \n    function showNoteContentClick(bubbleObj)\n    {\n    \tvar accessionNum = $(bubbleObj).attr(\"data-accNumber\");\n    \tif(accessionNum != null && accessionNum != \"\")\n    \t\t{\n    \t\taccessionNum = escape(accessionNum);\n    \t\t}\n    \twindow.parent.showNotesContent(accessionNum);\n    }\n\t$(document).ready(function() {\n\t\tassignSliderWidth();\n\t\tsetScrollerWidth();\n\t\tscrollNotes();\t\t\n\t});\n</script>\n<div class=\"procWidgetParent widgetParentTheme\" data-role=\"none\">\n\t<div class=\"widgetTable\" data-role=\"none\">\n\t\t<div class=\"widgetHeaderRow widgetHeaderRowTheme\" data-role=\"none\"><!-- header row -->\n\t\t\t<div class=\"widgetHeaderMarginCell\" data-role=\"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginExtn widgetHeaderMarginExtnTheme\" data-role=\"none\"></div>\n\t\t\t\t<div class=\"widgetHeaderIcontriangle\" data-role=\"none\"></div>\n\t\t\t</div>\n\t\t\t<div class=\"widgetHeaderCell widgetHeaderCellTheme\" data-role=\"none\">\n\t\t\t\t<div class=\"widgetHeaderSubTable\" data-role=\"none\">\n\t\t\t\t\t<div class=\"widgetHeaderSubRow\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"widgetHeaderIconCol1\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"widgetHeaderIconButton widgetHeaderIconButtonTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/images/CS_Clinical_Notes_32x32.PNG\" class=\"widgetHeaderButtonImage\"></img>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t<div class=\"widgetHeaderHeadingTextCol\" data-role=\"none\">\n\t\t\t\t\t\t\t<span class=\"widgetHeaderHeadingTextTheme\" data-role=\"none\">Clinical Notes</span> <input type=\"button\" class=\"widgetHeaderCountButtonTheme\" id=\"ClinicalNotesCountBtn\" value=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"notesFilterCol\" data-role=\"none\" >\n\t\t\t\t\t\t\t<table style=\"height: 100%; width: 100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t\t\t\t\t\t<td style=\"width: 100%\" align=\"right\" valign=\"center\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"notesFilterContainer\">\n\t\t\t\t\t\t\t\t\t\t\t<table style=\"width: 100%; height: 100%;\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"notesIconTheme\" filter-type=\"N\" valign=\"center\" align=\"center\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-filterIcon=\"T\" data-filterBy=\"NUR$\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"filterNotes(\'N\')\"><img\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/Nursing_NotesW24x24.png\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"notesIconTheme\" filter-type=\"P\" valign=\"center\" align=\"center\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-filterIcon=\"T\" data-filterBy=\"PHY$\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"filterNotes(\'P\')\"><img\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/PhysicianNotesW24x24.png\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"notesIconTheme\" filter-type=\"C\" valign=\"center\" align=\"center\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-filterIcon=\"T\" data-filterBy=\"CLI$\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"filterNotes(\'C\')\"><img\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/images/Clinician_NotesW24x24.png\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"notesIconTheme\" filter-type=\"SPL\" valign=\"center\" align=\"center\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-filterIcon=\"T\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"filterNotes(\'SPL\',\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\"><img\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/MySpecialty24x24.png\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div><!-- header row ends -->\n\t\t<div class=\"widgetContentRow\" id=\"CNdivcnt\" data-role=\"none\"><!-- content row starts -->\n\t\t\t<div class=\"widgetHeaderMarginCell\" data-role=\"none\"></div>\n\t\t\t<div class=\"widgetContentCell\" data-role=\"none\">\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n\t\t\t\t<div class=\"AllergyContentTable WidgetContentStripTheme clinicalNotesContent\"\n\t\t\t\t    data-notetype=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" \n\t\t\t\t\tdata-role=\"none\" id=\"cTable\">\n\t\t\t\t\t<!-- content strip starts -->\n\t\t\t\t\t<div class=\"AllergyContentRow AllergyContentRowTheme\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"notesContentCol1 WidgetContentStripCol1Theme\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"AllergyReactionCount WidgetContentStripCol1BoxTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCountCircleTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCountCircleText\" data-role=\"none\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  class=\"NotesImage\" />\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"notesContentCol2\" data-role=\"none\">\n\t\t\t\t\t\t\t<div data-role=\"none\" class=\"swipeTable\" id=\"swipeTable\" data-count=\"1\" >\n\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-row;vertical-align:middle; width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t<div data-role=\"none\" data-content=\"1\" style=\"display: table-cell;word-break:break-all; width: 1%; height: 67px; vertical-align: middle; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"WidgetParaHeadTextTheme notesText\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-cell; width: 98%; height: 67px; vertical-align: middle; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"swipeWrapper\" id=\"wrapper";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" data-IdCount = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" data-noteType = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"> <!-- wrapper starts -->\n\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"notesScroller\" id=\"notesScroller";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"> <!-- scroller starts -->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n   \t\t \t\t\t\t\t\t\t \t\t\t\t   \t\t\t\t\t<div data-role=\"none\" class = \"bubbleDivider notesDividerTheme\" data-noteTypeValue = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></div>\n   \t\t \t\t\t\t\t\t\t \t\t\t\t   \t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"dataContainerFullView\" data-notetype=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" data-noteTypeValue = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" data-accNumber = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onclick = \"showNoteContentClick(this)\"> <!-- data buble starts-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table; width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-row; width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-cell; width: 1%; height: 100%; vertical-align: middle; text-align: center; border-radius: 30px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"iconContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t<img src=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-cell; width: 99%; height: 100%; border-radius: 30px; vertical-align: middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"dateContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"notesDate\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div><!-- data bubble ends -->\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t\t\t</div><!-- scroller ends -->\n\t\t\t\t\t\t\t\t\t\t</div><!-- wrapper ends -->\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"notesContentCol3\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"notesExpandCollapse\" data-role=\"none\" data-expandNoteType = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onclick = \"showFullViewNotes(this)\">\n\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="/eIPAD/images/Expandview.png\" id=\"ExpCollAllergy\" data-imagaeNoteType = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"></img>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div><!-- div table ends   -->\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t   \t<!-- full view for each table -->\n\t\t\t\t<div data-role = \"none\" style = \"display:none;width:100%;height:auto;background-color:#ffffff\" data-fullViewNoteType = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" data-fullView = \"true\">\n\t\t\t\t</div>\n\t\t\t\t<!-- full view for each table ends -->\t\t\n\t\t\t   \t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t   \t\t<div class=\"WidgetVwErrContainer\">\n\t\t\t\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t \t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\n\t\t\t   \t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t<input type=\"hidden\" name=\"hdnCNCount\" id=\"hdnCNCount\" id=\"hdnCNCount\"\n\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' />\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<div class=\"WidgetVwErrContainer mySpecialityNoRecords\" style=\"display:none\">\n\t\t\t\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">\n\t\t\t\t\t\t\tNo clinical notes recorded for the patient\n\t\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<input type=\"hidden\" name=\"hdnAccessionNum\" id=\"hdnAccessionNum\" id=\"hdnAccessionNum\"\n\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' />\n\t\t\t\n\t\t\t <!-- mySpecialityList STARTS -->\n                            ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"hdnCount\" id =\"hdnCount\" value = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"/>\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"hdnLoggedInUser\" id =\"hdnLoggedInUser\" value = \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"hdnSpeciality\" id =\"hdnSpeciality";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" value = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t</div><!-- content cell ends -->\n\t\t</div><!-- content row ends -->\n\t</div><!-- widget table ends -->\n</div><!-- div paren end -->\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

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
	int noteCount = 0;
	int totalNoteCount = 0;
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
			for(int i=0;i<nListSize;i++){
				noteCount = listNoteGroup.get(i).getChildCount();
				totalNoteCount = totalNoteCount + noteCount;
			}
		}
	}	
	Gson gson = new Gson();
	String jsonFieldRes = "";
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
	String loggedInUser = patientContext.getLoggedInUser();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(totalNoteCount));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(loggedInUser));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);

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
					   		 List<NoteDetails> oLstNoteDetails = null;
					   		 oLstNoteDetails = oCnGrp.getListNoteDetails();
					   		 if(oLstNoteDetails != null)
					   		 {
					   			nSubLoopSize = oLstNoteDetails.size();
					   		 }
					   		
			 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oCnGrp.getChildCount() ));
            _bw.write(_wl_block13Bytes, _wl_block13);

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
								
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(notesImage ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByDesc()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block21Bytes, _wl_block21);

												if(nSubLoopSize > 0)
												{
													NoteDetails oNoteDetails = null;
													for(nSubLoopCount = 0 ; nSubLoopCount < nSubLoopSize;nSubLoopCount++ )
													{
														oNoteDetails = oLstNoteDetails.get(nSubLoopCount);
														if(oNoteDetails != null)
														{
											  
            _bw.write(_wl_block22Bytes, _wl_block22);

											  				if(nSubLoopCount > 0)
   		 							 				   		{
   		 							 				   			if(!dateValue.equals(oNoteDetails.getDescription().getDescription())  )
   		 							 				   			{
   		 							 				   				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block24Bytes, _wl_block24);
 
   		 							 				   			}
   		 							 				   		}
   		 							 				      dateValue = oNoteDetails.getDescription().getDescription();
   		 							 				      if(oNoteDetails.getStatus() != null)
   		 							 				      {
   		 							 				    	  if(oNoteDetails.getStatus().equals("1"))
   		 							 				    	  {
   		 							 				    		  noteStatus = "In_Progress24x24.png";
   		 							 				    	  }
   		 							 				    	  else if(oNoteDetails.getStatus().equals("2"))
   		 							 				    	  {
   		 							 				    		  noteStatus = "Transcribed24x24.png";
   		 							 				    	  }
   		 							 				    	  else if(oNoteDetails.getStatus().equals("3"))
 		 							 				    	  {
 		 							 				    		  noteStatus = "Unauthorized24x24.png";
 		 							 				    	  }
   		 							 				    	  else if(oNoteDetails.getStatus().equals("4"))
		 							 				    	  {
		 							 				    		  noteStatus = "Authorized24x24.png";
		 							 				    	  }
   		 							 				    	  else if(oNoteDetails.getStatus().equals("5"))
		 							 				    	  {
		 							 				    		  noteStatus = "Modified.png";
		 							 				    	  }
   		 							 				    	  else if(oNoteDetails.getStatus().equals("9"))
		 							 				    	  {
		 							 				    		  noteStatus = "InError24x24.png";
		 							 				    	  }
   		 							 				    	  else
   		 							 				    	  {
   		 							 				    		  noteStatus = "";
   		 							 				    	  }
   		 							 				      }
											  				
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oNoteDetails.getNoteType()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(oNoteDetails.getAccessionNum() ));
            _bw.write(_wl_block28Bytes, _wl_block28);

																			    	if(!noteStatus.equals(""))
																			    	{
																			    		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(noteStatus));
            _bw.write(_wl_block30Bytes, _wl_block30);
 
																			    	}
																			    
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(oNoteDetails.getDescription().getDescription() ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oNoteDetails.getDescription().getEventTime() ));
            _bw.write(_wl_block33Bytes, _wl_block33);

														}//if notedetails
													}//for
												}//if subloop
												
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block37Bytes, _wl_block37);

			   			}//oCrgp
			   			
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block39Bytes, _wl_block39);
 		
			   		}//for
			   	}//if
			   	else
			   	{
			   		
            _bw.write(_wl_block40Bytes, _wl_block40);

							 		if(oCnRes != null)
							 		{
							 			
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(oCnRes.getErrorsList().get(0).getErrorMessage() ));
            _bw.write(_wl_block42Bytes, _wl_block42);
 
							 		}
							 
            _bw.write(_wl_block43Bytes, _wl_block43);

			   	}
			   	int count = accArray.size();
			   
				
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);

				jsonFieldRes = gson.toJson(accArray);
				if(nListSize > 0 )
				{
				
            _bw.write(_wl_block46Bytes, _wl_block46);

				}
				
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(jsonFieldRes));
            _bw.write(_wl_block48Bytes, _wl_block48);

                            int nLoopCount1 = 0;
                        	int nRowCount = 0;
                        	String specCode= "";
                        	ClinicalNotesBC objBC = new ClinicalNotesBC();//calling bc
							ClinicalNotesFieldResponse oClintSPL = objBC.getMySpecialityList(patientContext);//for response
						 	List<ClinicalNotesFieldItem> MySpecialityListSFS;//to get the list
							ClinicalNotesFieldItem oCNFieldItemsSPL;//obj to get field values
							MySpecialityListSFS = oClintSPL.getFieldList();
							int nLstCountSPL = MySpecialityListSFS.size(); 
							
							
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(nLstCountSPL));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(loggedInUser));
            _bw.write(_wl_block51Bytes, _wl_block51);

							for(nLoopCount1=0; nLoopCount1<nLstCountSPL; nLoopCount1++){ 
								oCNFieldItemsSPL = MySpecialityListSFS.get(nLoopCount1);
								  	if(oCNFieldItemsSPL != null ){
									specCode = oCNFieldItemsSPL.getDesc();
							
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nLoopCount1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block51Bytes, _wl_block51);

								  	}
							}
							
            _bw.write(_wl_block54Bytes, _wl_block54);
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
