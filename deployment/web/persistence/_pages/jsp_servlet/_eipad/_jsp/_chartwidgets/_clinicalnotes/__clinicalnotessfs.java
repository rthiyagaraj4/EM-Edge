package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.clinicalnotes.daoimpl.ClinicalNotesDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import java.util.*;
import eIPAD.chartsummary.clinicalnotes.response.*;
import eIPAD.chartsummary.clinicalnotes.healthobject.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import eIPAD.chartsummary.common.response.TransactionResponse;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import com.google.gson.Gson;;

public final class __clinicalnotessfs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/ClinicalNotesSFS.jsp", 1709118014522L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="  \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\"\n\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no\" />\n<title>ClinicalNotesSFS</title>\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/SlideSFS.css\" />\n<script src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/js/iscroll5/iscroll.js\"></script>\n<!-- <script type=\"application/javascript\" src=\"../js/iscroll.js\"></script> -->\n<script src=\"../jquery-1.9.1.min.js\"></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script type=\"text/javascript\">\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n$.extend($.expr[\":\"], { //search as you type\n\t\"containsIN\": function(elem, i, match, array) {\n\treturn (elem.textContent || elem.innerText || \"\").toLowerCase().indexOf((match[3] || \"\").toLowerCase()) >= 0;\n\t}\n\t});\nvar SLSfsScrollMain;\n\nvar SLSfsScrollEC;\nvar SLSfsScrollPB;\nvar SLSfsScrollNT;\nvar SLSfsScrollMAS;\nvar SLSfsScrollST;\n\n\n\nvar currentViewMore;\nvar viewLessHeight;\nvar arrNT = [];\nvar arrMAS = [];\nvar arrPB = [];\nvar arrST = [];\nvar arrML = [];\nvar arrSPL = [];\nvar arrSN = [];\nfunction CNFilterLoaded() {\n\tSLSfsScrollMain=  new IScroll(\'#SLSfsWrapperMain\', { \t\n\t        scrollX: false, \n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true,\n\t\tclick: true,\n\t\tuseTransition: false,\n\t\tbindToWrapper: true \n        } );\n\t\n\ttry{\n\t\tSLSfsScrollEC = new IScroll(\'#SLSfsWrapperEC\', { scrollbars: true, click: true,  mouseWheel: true } );\n\t\tSLSfsScrollNT = new IScroll(\'#SLSfsWrapperNT\', { scrollbars: true, click: true,  mouseWheel: true } );\n\t\tSLSfsScrollMAS = new IScroll(\'#SLSfsWrapperMAS\', { scrollbars: true, click: true,  mouseWheel: true } );\n\t\tSLSfsScrollPB = new IScroll(\'#SLSfsWrapperPB\', { scrollbars: true, click: true,  mouseWheel: true } );\n\t\tSLSfsScrollST = new IScroll(\'#SLSfsWrapperST\', { scrollbars: true, click: true,  mouseWheel: true } );\n\t}\n\tcatch(err){\n\t\t\n\t}\n}\nfunction hideSlideSFS(){\n//$(\"#CNFilterHeader\").hide();\n$(\"#SlideSfsFrame\").hide();\n\t$(\'.slidesFrameWrap\').css({\'display\':\'none\'});/*changed*/\n\t$(\'.rightContentWrap\').css({\'width\':\'100%\'});/*changed*/\n\t$(\"#SlideSFSOpener\").show();\n\t$(\".sliderSwipe\").show();\n\tassignSliderWidth();\n\tsetScrollerWidth();\n\tisOpened=false;\n\tif($(\'#hdnActiveEncID\').val() != undefined){\n\t\t$(\"#SLSfsTickEN\"+$(\'#hdnActiveEncID\').val()).hide();\n\t\tchooseEncounterFilter($(\'#hdnActiveEncID\').val(),\'clinicalNotes\',\'fullViewEncounter\');\n\t}\n}\n//swipe left close filter /*changed*/\n$( document ).on( \"swipeleft\", \"#SlideSfsFrame\", function( e ) {\n\thideSlideSFS();\n});\nfunction refreshMain(){\n\t/* $(\"CNFilterContent\").empty();\n\t$(\"CNFilterContent\").show(); */\n\tif(SLSfsScrollNT != undefined)\n\t\tSLSfsScrollNT.refresh();\n\tif(SLSfsScrollMAS != undefined)\n\t\tSLSfsScrollMAS.refresh();\n\tif(SLSfsScrollPB != undefined)\n\t\tSLSfsScrollPB.refresh();\n\tif(SLSfsScrollST != undefined)\n\t\tSLSfsScrollST.refresh();\n\tif(SLSfsScrollMain != undefined)\n\t\tSLSfsScrollMain.refresh();\n\t$(\"#listNT\").find(\".listItemNT\").show();\n\t$(\"#listMAS\").find(\".listItemMAS\").show();\n\t$(\"#listPB\").find(\".listItemPB\").show();\n\t$(\"#listST\").find(\".listItemST\").show();\n\t$(\"#listML\").find(\".listItemML\").show();\n\t$(\"#listSPL\").find(\".listItemSPL\").show();\n\t$(\".SLSfsTickVisible\").hide();\n\t$(\".SLSfsAfterSelectionTheme\").hide();\n\tif($(\'#hdnActiveEncID\').val() != undefined){\n\t\t$(\"#SLSfsTickEN\"+$(\'#hdnActiveEncID\').val()).hide();\n\t\tchooseEncounterFilter($(\'#hdnActiveEncID\').val(),\'clinicalNotes\',\'fullViewEncounter\');\n\t}\n\t\n\tif($(\'#searchInputSFSPB\').length > 0)\n\t $(\'#searchInputSFSPB\').val(\'\');\n\tif($(\'#searchInputSFSNT\').length > 0)\n\t$(\'#searchInputSFSNT\').val(\'\');\n\tif($(\'#searchInputSFSMAS\').length > 0)\n\t$(\'#searchInputSFSMAS\').val(\'\');\n\tif($(\'#searchInputSFSST\').length > 0)\n\t$(\'#searchInputSFSST\').val(\'\');\n\tarrNT.splice(0,arrNT.length);\n\tarrMAS.splice(0,arrMAS.length);\n\tarrPB.splice(0,arrPB.length);\n\tarrST.splice(0,arrST.length);\n\tarrML.splice(0,arrML.length);\n\tarrSPL.splice(0,arrSPL.length);\n\tarrSN.splice(0,arrSN.length);\n\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t$(\"#AfterSelectionNT\").html(\'\');\n}\n\nfunction CNFilterShowTick(val, type){ \n\tif(type==\"PB\"){\t\n\t arrPB =[];\n\t\tif($(\"#SLSfsTickPB\"+val).is(\":visible\")){\n\t\t\tvar index = arrPB.indexOf(val);\n\t\t\tarrPB.splice(index, 1);\n\t\t\t$(\"#SLSfsTickPB\"+val).hide();\n\t\t}\n\t\telse{\n\t\t\tarrPB.push(val); \n\t\t\t$(\"#SLSfsTickPB\"+val).show();\n\t\t\t}\n\t}\n\tif(type==\"NT\"){\t\n\t\tif($(\"#SLSfsTickNT\"+val).is(\":visible\")){\n\t\t\tvar index = arrNT.indexOf(val);\n\t\t\tarrNT.splice(index, 1);\n\t\t\t$(\"#SLSfsTickNT\"+val).hide();\n\t\t\t\n\t\t}\n\t\telse{\n\t\t\tarrNT.push(val); \n\t\t\t$(\"#SLSfsTickNT\"+val).show();\n\t\t\t\n\t\t\t}\n\t\tif(arrNT.length > 0){\n\t\t\t$(\'.searchByNotes\').addClass(\"enableSearch\");\n\t\t}else{\n\t\t\t$(\'.searchByNotes\').removeClass(\"enableSearch\")\n\t\t}\n\t}\n\tif(type==\"MAS\"){\n\t\tarrMAS =[];\n\t\t if($(\"#SLSfsTickMAS\"+val).is(\":visible\")){\n\t\t\t $(\"#SLSfsTickMAS\"+val).hide();\n\t\t\t $(\'div[id^=\"SLSfsTickMAS\"]\').hide();\n\t\t\t \n\t\t }else{\n\t\t\t arrMAS.push(val);\n\t\t\t $(\'div[id^=\"SLSfsTickMAS\"]\').hide();\n\t\t\t $(\"#SLSfsTickMAS\"+val).show();\n\t\t\t \n\t\t }\n\t\t\n\t}\n\tif(type==\"SN\"){\n\t\tarrSN =[];\n\t\t if($(\"#SLSfsTickSN\"+val).is(\":visible\")){\n\t\t\t $(\"#SLSfsTickSN\"+val).hide();\n\t\t\t $(\'div[id^=\"SLSfsTickSN\"]\').hide();\n\t\t }else{\n\t\t\t arrSN.push(val);\n\t\t\t $(\'div[id^=\"SLSfsTickSN\"]\').hide();\n\t\t\t $(\"#SLSfsTickSN\"+val).show(); \n\t\t }\n\t\t\n\t}\n\tif(type==\"ST\"){\t\n\t\tarrST = [];\n\t\tif($(\"#SLSfsTickST\"+val).is(\":visible\")){\n\t\t\tvar index = arrST.indexOf(val);\n\t\t\tarrST.splice(index, 1);\n\t\t\t$(\"#SLSfsTickST\"+val).hide();\n\t\t}\n\t\telse{\n\t\t\tarrST.push(val); \n\t\t\t$(\"#SLSfsTickST\"+val).show();\n\t\t\t}\n\t}\n\tif(type !=\"NT\"){\t\n\t\taddCnoteSpinner();\n\t\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t}\n\tif(arrNT.length == 0 && type ==\"NT\" ){\n\t\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t}\n\tif(SLSfsScrollNT != undefined)\n\t\tSLSfsScrollNT.refresh();\n\tif(SLSfsScrollMAS != undefined)\n\t\tSLSfsScrollMAS.refresh();\n\tif(SLSfsScrollPB != undefined)\n\t\tSLSfsScrollPB.refresh();\n\tif(SLSfsScrollST != undefined)\n\t\tSLSfsScrollST.refresh();\n\t\n\tSLSfsScrollMain.refresh();\n}\nfunction searchByNoteType(event){\n\tevent.stopPropagation();\n\taddCnoteSpinner();\n\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t\t\n\t\t if($(\"#AfterSelectionNT\").is(\":visible\")){\n\t\t\t\t$(\"#AfterSelectionNT\").empty();\n\t\t\t}\n\t\t\tif(arrNT.length>0){\n\t\t\t\t$(\"#NTAfterSel\").show();\n\t\t\t\tfor(var i=0;i<arrNT.length;i++){\n\t\t\t\t\tvar specCode= arrNT[i];\n\t\t\t\t\tvar specDesc =\"\";\n\t\t\t\t\t$(\"[data-speccode = \'\"+specCode+\"\']\").each(function (i,v ){\n\t\t\t\t\t\tspecDesc = $(this).data(\"specdesc\");\n\t\t\t\t\t});\n\t\t \t\t\tvar inblockNT =\'<div id=\"inBlockItem\'+specCode+\'\" class=\"row SLSfsInlineBlock SLSfsInlineBlockTheme\"> <div class=\"cell SLSfsInlineBlockCell SLSfsInlineBlockCellTheme\"> \'+ specDesc +\' </div><div class=\"cell SLSfsInlineBlockClose\" onclick=\"removeInblockItem(&quot;\'+specCode+\'&quot;,&quot;NT&quot;)\"><img src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/images/Close10x10.PNG\"></div></div>\';\n\t\t \t\t\t$(\"#AfterSelectionNT\").append(inblockNT);    \n\t\t\t \t}\n\t\t\t\tvar addmoreNT =\'<div class=\"row SLSfsInlineBlock SLSfsInlineBlockTheme\"> <div class=\"cell SLSfsInlineBlockCell SLSfsInlineBlockCellTheme\" onclick=\"addmoreFilter(&quot;NT&quot;)\"> Add more </div> </div>\';\n\t\t\t\t$(\"#AfterSelectionNT\").append(addmoreNT);\n\t\t\t\t$(\"#AfterSelectionNT\").show();\n\t\t\t\t$(\"#contentNT\").hide();\n\t \t\t    $(\"#textBoxNT\").hide();\n\t\t\t}\n\t\t\t\n\t\t\n\tSLSfsScrollMain.refresh();\n}\nfunction myList(val,type){\n\tif(type==\"ML\"){\n\t\tif($(\"#SLSfsTickMLPract\").is(\":visible\")){\n\t\t\tvar index = arrML.indexOf(val);\n\t\t\tarrML.splice(index, 1);\n\t\t\t$(\"#SLSfsTickMLPract\").hide();\n\t\t\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t\t}\n\t\telse{\n\t\t\tarrML.push(val); \n\t\t\t$(\"#SLSfsTickMLPract\").show();\n\t\t\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t\t}\n\t}\n\tif(type==\"SPL\"){\n\t\tif($(\"#SLSfsTickMLServ\").is(\":visible\")){\n\t\t\tvar index = arrML.indexOf(val);\n\t\t\tarrSPL.splice(index, 1);\n\t\t\t$(\"#SLSfsTickMLServ\").hide();\n\t\t\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t\t}\n\t\telse{\n\t\t\tarrSPL.push(val); \n\t\t\t$(\"#SLSfsTickMLServ\").show();\n\t\t\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\t\t}\n\t}\n}\n\nfunction CNFilterClearTxt(current,other1,other2,other3){\n\tdocument.getElementById(\"searchInputSFS\"+current).value = \"\";\n\t$(\"#list\"+current).find(\".listItem\"+current).show();\n\tif(current=\'NT\'){\n\t\tSLSfsScrollNT.refresh();\n\t}\n\tif(current=\'MAS\'){\n\t\tSLSfsScrollMAS.refresh();\n\t}\n\tif(current=\'PB\'){\n\t\tSLSfsScrollPB.refresh();\n\t}\n\tif(current=\'ST\'){\n\t\tSLSfsScrollST.refresh();\n\t}\n}\n\nfunction CNFilterSectionToggle(current){\n\t$(\"#content\"+current).toggle();\n\t$(\"#textBox\"+current).toggle();\n\t$(\"#ViewMore\"+current).toggle();\n\t\n\t\n\t if($(\"#content\"+current).is(\":visible\")){\n\t\t\t$(\"#arrow\"+current).addClass(\'SLSfsarrow\');\n\t\t}\n\t\telse{\n\t\t\t$(\"#arrow\"+current).removeClass(\'SLSfsarrow\')\t;\n\t\t}\n\t \n\tSLSfsScrollMain.refresh();\n\t \n\tif(SLSfsScrollEC != null){\n\tSLSfsScrollEC.refresh();}\n\t\n\tif(SLSfsScrollPB != null){\n\tSLSfsScrollPB.refresh();}\n\t\n\tif(SLSfsScrollNT != null){\n\tSLSfsScrollNT.refresh();}\n\t\n\tif(SLSfsScrollMAS != null){\n\tSLSfsScrollMAS.refresh();}\n\t\n\tif(SLSfsScrollST != null){\n\tSLSfsScrollST.refresh();}\n\t \n}\n\nfunction addmoreFilter(current){\n\t\n\t$(\"#data\"+current).height(viewLessHeight); \n\t$(\"#content\"+current).show();\n\t$(\"#textBox\"+current).show();\n\t$(\"#ViewMore\"+current).show();\n\t$(\"#AfterSelection\"+current).hide();\n\t$(\'#AfterSelection\'+current).empty();\n\tif($(\"#content\"+current).is(\":visible\")){\n\t\t\t$(\"#arrow\"+current).addClass(\'SLSfsarrow\');\n\t}\n\t$(\'.listItem\'+current).show();\n\tSLSfsScrollNT.refresh();\n}\nfunction removeInblockItem(val,type){\n\t//$(\"#inBlockItem\"+val).remove();\n\tif(type==\"NT\") {\n\t\t$(\"#inBlockItem\"+val).remove();\n\t\t$(\"#SLSfsTickNT\"+val).hide();\n\t\tvar index = arrNT.indexOf(val);\n\t\tarrNT.splice(index,1);\n\t\t\tif(arrNT.length<1){\n\t\t\t\t $(\"#NTAfterSel\").hide();\n\t\t\t\t $(\"#AfterSelectionNT\").html(\'\');\n\t\t\t\t//$(\"#AfterSelectionSP\").empty();\n\t\t\t\t//$(\"#dataSP\").height(viewLessHeight);\n\t\t\t\t//$(\"#refSP\").addClass(\'sfsReloadDefault\');\n\t\t\t\tSLSfsScrollNT.refresh();\n\t\t\t}\n\t}\n\t\n\t\n\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n}\n/*refresh filetr*/\n function refreshFilter(current,event){\n\t event.stopPropagation();\n\tif(current == \'NT\'){\n\t\tarrNT =[];\n\t\t $(\'div[id^=\"SLSfsTickNT\"]\').hide();\n\t\t  $(\"#AfterSelectionNT\").html(\'\');\n\t\tSLSfsScrollNT.refresh();\n\t}\n\t/*if(current == \'ST\'){\n\t\tarrST =[];\n\t\t $(\'div[id^=\"SLSfsTickST\"]\').hide();\n\t\tSLSfsScrollST.refresh();\n\t}\n\tif(current == \'PB\'){\n\t\tarrPB =[];\n\t\t $(\'div[id^=\"SLSfsTickPB\"]\').hide();\n\t\tSLSfsScrollPB.refresh();\n\t}*/\n\tclinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);\n\tSLSfsScrollMain.refresh();\n}\n \n \n \n/*time frame slider start*/\n \n \n  \tvar dateArrayStr = $(\"#hdnEncounterDate\").val();\n  \tvar dateArrSize = $(\"#hdnDateArrCount\").val();\n\tdateArray = $.parseJSON(dateArrayStr);\n\t\n\tvar encArrayStr = $(\"#hdnEncounterEnc\").val();\n  \tvar encArrSize = $(\"#hdnEncArrCount\").val();\n\tencArray = $.parseJSON(encArrayStr);\n\t\n\tvar datePos = dateArrSize - 1;\n\tvar encPos = encArrSize - 1;\n\n\tvar cuurentDate = new Date();\n\tvar currDate = new Date();\n\tvar srtDate = new Date(currDate.setMonth(currDate.getMonth() - 3));\n\t\n\tvar startDate = kendo.toString(srtDate, \'yyyy/M/d\' ).split(\'\\/\');\t\n\tif(startDate[1].length == 2){\n\t\tvar prevDate = new Date(startDate[0]+\"/\"+startDate[1]+\"/\"+startDate[2]);\n\t}else{\n\t\tvar prevDate = new Date(startDate[0]+\"/0\"+startDate[1]+\"/\"+startDate[2]);\n\t}\n\n\tprevDate.setHours(0,0,0);\n\tcuurentDate.setHours(0,0,0);\n\t\n\tparent.setTimeFrame=function(){\n\t$(\'.startLabel\').text(kendo.toString(prevDate, \'d MMM yyyy\' ));\n    var viewModel = kendo.observable({\n        // 24*60*60*1000 = 86400000\n        selectedStartDate: prevDate,\n        selectedEndDate: cuurentDate,\n\t\tdatepickerStartValue:prevDate,\n\t\tdatepickerEndValue:cuurentDate,\n        selectedDateRange: [],\n\t\tpickerStartTime:\'\',\n\t\tpickerEndTime:\'\',\n        selectedDatesChanged: function(){\n\t\t\t\t//to set slider on select date picker\n\t\t\t\tif(viewModel.selectedEndDate.getTime() <= viewModel.datepickerStartValue.getTime()){\n\t\t\t\t\talert(\"start date should be less than current date\");\n\t\t\t\t\tviewModel.set(\'datepickerStartValue\',viewModel.selectedStartDate);\n\t\t\t\t\tviewModel.set(\"pickerStartTime\",viewModel.selectedStartDate.getTime());\n\t\t\t\t}\n\t\t\t\tif(viewModel.selectedStartDate.getTime() > viewModel.datepickerEndValue.getTime()){\n\t\t\t\t\talert(\"end date should not be less than start date\");\n\t\t\t\t\tviewModel.set(\'datepickerEndValue\',viewModel.selectedEndDate);\n\t\t\t\t\tviewModel.set(\"pickerEndTime\",viewModel.selectedEndDate.getTime())\n\t\t\t\t}\n\t\t\t\tif(viewModel.selectedStartDate.getTime() <= viewModel.datepickerStartValue.getTime()){\n\t\t\t\t\t//does not allow to select lesser date of start date\n\t\t\t\t\tviewModel.pickerStartTime = viewModel.datepickerStartValue.getTime();\n\t\t\t\t}else{\n\t\t\t\t\talert(\"select correct daterange\");\n\t\t\t\t\tviewModel.set(\'datepickerStartValue\',viewModel.selectedStartDate);\n\t\t\t\t\tviewModel.set(\"pickerStartTime\",viewModel.selectedStartDate.getTime());\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(viewModel.selectedEndDate.getTime() >= viewModel.datepickerEndValue.getTime())\t{\n\t\t\t\t\t//does not allow to select greater date of end date\n\t\t\t\t\tviewModel.pickerEndTime = viewModel.datepickerEndValue.getTime();\n\t\t\t\t}else{\n\t\t\t\t\talert(\"select correct daterange\");\n\t\t\t\t\tviewModel.set(\'datepickerEndValue\',viewModel.selectedEndDate);\n\t\t\t\t\tviewModel.set(\"pickerEndTime\",viewModel.selectedEndDate.getTime())\n\t\t\t\t}\n            \tviewModel.updateDateSlider();\n            \t//to hide datepickers for default dates\n            \t/*var dateRange = $(\"#dateSlider\").data(\"kendoRangeSlider\").value();\n            \tvar startMatch = (kendo.toString(new Date(dateRange[0]), \'d MMM yyyy\' ) ==  kendo.toString(new Date(prevDate), \'d MMM yyyy\' ));\n            \tvar endMatch = (kendo.toString(new Date(dateRange[1]), \'d MMM yyyy\' ) ==  kendo.toString(new Date(cuurentDate), \'d MMM yyyy\' ));\n            \t\n            \tif(startMatch && endMatch){\n\t\t\t\t\t\t$(\'.selectedDates\').hide();\n\t\t\t\t}else{\n\t\t\t\t\t$(\'.selectedDates\').show();\n\t\t\t\t}*/\n        },\n        dateStart: \'\',\n        dateEnd: \'\',\n        dateRangeChanged: function(){\n            var dateRange = $(\"#dateSlider\").data(\"kendoRangeSlider\").value();\n            var startdate = kendo.toString(new Date(dateRange[0]), \'d MMM yyyy\' );\n            var enddate = kendo.toString(new Date(dateRange[1]), \'d MMM yyyy\' );\n            viewModel.set(\'dateStart\', startdate);\n            viewModel.set(\'dateEnd\', enddate);\n            viewModel.set(\'selectedDateRange\', dateRange);\n\t\t\t//to set datepicker on drag \n\t\t\tviewModel.set(\'datepickerStartValue\',new Date(dateRange[0]));\n\t\t\tviewModel.set(\'datepickerEndValue\',new Date(dateRange[1]));\n\t\t\t/*if(startdate == kendo.toString(new Date(prevDate), \'d MMM yyyy\' ) && enddate == kendo.toString(new Date(cuurentDate), \'d MMM yyyy\' )){\n\t\t\t\t\t$(\'.selectedDates\').hide();\n\t\t\t}else{\n\t\t\t\t$(\'.selectedDates\').show();\n\t\t\t}*/\n        },\n        updateDateSlider: function(){\n            if ( viewModel.selectedStartDate <= viewModel.selectedEndDate)\n            {\n                // reinitialize the date slider, since sliders do not support dynamic changes\n                var slider = $(\"#dateSlider\").data(\"kendoRangeSlider\");\n                    if (slider){\n                var wrapper = slider.wrapper;\n                var element = slider.element;\n                slider.destroy();\n                wrapper.before(element.show());\n                wrapper.remove();\n            }\n            $(\"#dateSlider\").kendoRangeSlider({\n                largeStep: 86400000,\n                smallStep: 86400000,\n                min: viewModel.selectedStartDate.getTime(),\n                max: viewModel.selectedEndDate.getTime(),\n                tickPlacement:\'none\',\n                value: [viewModel.selectedStartDate.getTime(), viewModel.selectedEndDate.getTime()],\n\t\t\t\tselectionStart:(viewModel.pickerStartTime == \'\')  ? viewModel.selectedStartDate.getTime() : viewModel.pickerStartTime,\n\t\t\t\tselectionEnd: (viewModel.pickerEndTime == \'\') ? viewModel.selectedEndDate.getTime() : viewModel.pickerEndTime,\n                tooltip: {\n                    template: kendo.template(\'#=kendo.toString(new Date(selectionStart), \\\'M/d/yyyy\\\' ) # to #=kendo.toString(new Date(selectionEnd), \\\'M/d/yyyy\\\' ) #\')\n                },\n                change: viewModel.dateRangeChanged\n            });\n                viewModel.resizeSliders();\n                viewModel.dateRangeChanged();\n            }\n                     \n        },\n        resizeSliders: function(){\n            // resize the sliders to fill the container\n              var sliders = $(\"[data-role=\'rangeslider\']\");\n                sliders.each(function (index, ele) {        \n                var slider = $(ele).getKendoRangeSlider();\n                slider.wrapper.css(\"width\", \"100%\");\n                //slider.resize();\n            });\n        }\n    });\n    \n\n    kendo.bind(\'body\', viewModel);\n    viewModel.updateDateSlider();\n    viewModel.resizeSliders();\n\n\t}\n//search by time frame\nvar temp;\nvar i;\nvar j=0;\n//var openingPage=\"clinicalNotes\";\nvar selectedDateArr = [];\nfunction SearchByTimeFrame(){\n\tvar dateRange = $(\"#dateSlider\").data(\"kendoRangeSlider\").value();\n\tvar startdate = kendo.toString(new Date(dateRange[0]), \'d MMM yyyy\' );\n    var enddate = kendo.toString(new Date(dateRange[1]), \'d MMM yyyy\' );\n    \n    var startDateformat = kendo.toString(new Date(startdate), \'yyyy/MM/dd\' );\n    var startDateformatfinal =  startDateformat.split(\'\\/\');\n    var finalStartDate = startDateformatfinal[0]+\'-\'+startDateformatfinal[1]+\'-\'+startDateformatfinal[2];\n    \n    var endDateformat = kendo.toString(new Date(enddate), \'yyyy/MM/dd\' );\n    var endDateformatfinal =  endDateformat.split(\'\\/\');\n    var finalEndDate = endDateformatfinal[0]+\'-\'+endDateformatfinal[1]+\'-\'+endDateformatfinal[2];\n    \n    \n    var viewPage=\"fullViewTimeRange\";\n    \n\t//removing selected notetypes and ticks\n\tarrNT=[];\n\t$(\"#AfterSelectionNT\").html(\'\');\n\t$(\".SLSfsTickVisible\").hide();\n\t$(\'.searchByNotes\').removeClass(\"enableSearch\")\n\tEncountersInRange(finalStartDate,finalEndDate,viewPage);\n}\n   \n    //var firstEnc = encArray[encPos]; logic of timeframe with encounter n date together inside SearchByTimeFrame function\n   /*  if(dateArrSize>0){\n    \tfor(i=0;i<dateArrSize;i++){\n    \t\tvar formatdate = dateArray[j].split(\' \')[0].split(\'\\/\');\n    \t\tvar formatDate1 =  new Date(formatdate[2]+\"-\"+formatdate[1]+\"-\"+formatdate[0]);\n    \t\t\n    \t\tvar finalEcDate =new Date(formatDate1).getTime();\n    \t\tvar finalEndDate =new Date(enddate).getTime();\n    \t\tvar finalstartdate = new Date(startdate).getTime();\n    \t\t\n    \t\tif(finalEcDate < finalEndDate && finalEcDate > finalstartdate ){\n    \t\t\ttemp = dateArray[j];\n    \t\t\talert(temp);\n    \t\t\tselectedDateArr.push(temp);\n    \t\t\tEncountersInRange(selectedDateArr,openingPage);\n    \t\t}\n    \t\tj++;\n    \t}\n    }       */\n    function iScrollRefresh(){\n\t      setTimeout(function(){\n\t    \t  SLSfsScrollEC.refresh(); \n\t      }, 500);\n\t    }\n$(document).ready(function(){\n\tCNFilterLoaded();\n\tparent.setTimeFrame();\n\t//arrow setting intial for EC\n\tif($(\"#contentEC\").is(\":visible\")){\n\t\t$(\"#arrowEC\").addClass(\'SLSfsarrow\');\n\t\tif(SLSfsScrollEC != null){\n\t\t\tSLSfsScrollEC.refresh();\n\t\t}\n\t}\n\tiScrollRefresh();\n\t\n\t$(\"#ViewLessPB\").hide();\n\t$(\"#ViewLessNT\").hide();\n\t$(\"#ViewLessMAS\").hide();\n\t$(\"#ViewLessST\").hide();\n\t$(\"#ViewLessST\").hide();\n\t//initially closed state\n\t\n\t$(\"#contentTF\").hide();\n\t$(\"#contentPB\").hide();\n\t$(\"#textBoxPB\").hide();\n\t$(\"#contentNT\").hide();\n\t$(\"#textBoxNT\").hide();\n\t$(\"#contentMAS\").hide();\n\t$(\"#textBoxMAS\").hide();\n\t$(\"#contentST\").hide();\n\t$(\"#textBoxST\").hide();\n\t\n\tif(SLSfsScrollEC != null){\n\tSLSfsScrollEC.on(\'beforeScrollStart\', function () {\n\t\tSLSfsScrollMain.disable();\n\t});\n\tSLSfsScrollEC.on(\'scrollEnd\', function () {\n\t\tSLSfsScrollMain.enable();\n\t});}\n\t\n\tif(SLSfsScrollPB != null){\n\tSLSfsScrollPB.on(\'beforeScrollStart\', function () {\n\t\tSLSfsScrollMain.disable();\n\t});\n\tSLSfsScrollPB.on(\'scrollEnd\', function () {\n\t\tSLSfsScrollMain.enable();\n\t});}\n\t\n\tif(SLSfsScrollNT != null){\n\tSLSfsScrollNT.on(\'beforeScrollStart\', function () {\n\t\tSLSfsScrollMain.disable();\n\t});\n\tSLSfsScrollNT.on(\'scrollEnd\', function () {\n\t\tSLSfsScrollMain.enable();\n\t});}\n\t\n\tif(SLSfsScrollMAS != null){\t\n\tSLSfsScrollMAS.on(\'beforeScrollStart\', function () {\n\t\tSLSfsScrollMain.disable();\n\t});\n\tSLSfsScrollMAS.on(\'scrollEnd\', function () {\n\t\tSLSfsScrollMain.enable();\n\t});}\n\t\n\tif(SLSfsScrollST != null){\n\tSLSfsScrollST.on(\'beforeScrollStart\', function () {\n\t\tSLSfsScrollMain.disable();\n\t});\n\tSLSfsScrollST.on(\'scrollEnd\', function () {\n\t\tSLSfsScrollMain.enable();\n\t});}\n\t\n\t$(\'#SLSfsWrapperMain\').on(\'touchstart click\', function(){\n\t\tSLSfsScrollMain.enable();\n\t});\n\t$(\"#searchInputSFSPB\").keyup(function(){\n\t\tvar rows = $(\"#listPB\").find(\".listItemPB\").hide();\n\t\t   if (this.value.length) {\n\t\t       var data = this.value.split(\" \");\n\t\t       $.each(data, function (i, v){\n\t\t       \t\tvar val = v.toLowerCase(); \n\t\t       \t\trows.filter(\":containsIN(\'\" + val + \"\')\").show();\n\t\t\t\t\t});\n\t\t   \t\t}\n\t\t   \telse rows.show();\t\n\t\t});\n\t$(\"#searchInputSFSNT\").keyup(function () {\n\t\tvar rows = $(\"#listNT\").find(\".listItemNT\").hide();\n\t\t   if (this.value.length) {\n\t\t       var data = this.value.split(\" \");\n\t\t       $.each(data, function (i, v){\n\t\t       \t\tvar val = v.toLowerCase(); \n\t\t       \t\trows.filter(\":containsIN(\'\" + val + \"\')\").show();\n\t\t\t\t\t});\n\t\t   \t\t}\n\t\t   \telse rows.show();\t\n\t\t\tSLSfsScrollNT.refresh();\n\t\t});\n\t$(\"#searchInputSFSMAS\").keyup(function () {\n\t\tvar rows = $(\"#listMAS\").find(\".listItemMAS\").hide();\n\t\t   if (this.value.length) {\n\t\t       var data = this.value.split(\" \");\n\t\t       $.each(data, function (i, v){\n\t\t       \t\tvar val = v.toLowerCase(); \n\t\t       \t\trows.filter(\":containsIN(\'\" + val + \"\')\").show();\n\t\t\t\t\t});\n\t\t   \t\t}\n\t\t   \telse rows.show();\t\n\t\t});\n\t$(\"#searchInputSFSST\").keyup(function () {\n\t\tvar rows = $(\"#listST\").find(\".listItemST\").hide();\n\t\t   if (this.value.length) {\n\t\t       var data = this.value.split(\" \");\n\t\t       $.each(data, function (i, v){\n\t\t       \t\tvar val = v.toLowerCase(); \n\t\t       \t\trows.filter(\":containsIN(\'\" + val + \"\')\").show();\n\t\t\t\t\t});\n\t\t   \t\t}\n\t\t   \telse rows.show();\t\n\t\t});\n\t\t\n\t\t$(\".selectedDates input\").kendoDatePicker({\n\t\t\t\tformat: \"dd/MM/yyyy\"\n\t\t});\n\t$(\'div[id^=\"SLSfsTickEN\"]\').hide();\n\t$(\"#SLSfsTickEN\"+$(\'#hdnCurrentEncID\').val()).show();\n});\n\n</script>\n\n\t\n<!-- main table STARTS -->\n<div id=\"CNFilterHeader\" style=\"width:100%;height:100%; position: relative; display: table;\">\n<div class=\"row\" style=\"height: 2%;\">\n  <div class=\"cell\">\n\t<div style=\"width:100%;height:40px\"><!-- MR1 -->\n\t\t<div>\n\t\t\t<div class=\"table\" style=\"width:100%;\">\n\t\t\t\t<div class=\"row SLSfsHeader SLSfsHeaderTheme\">\n\t\t\t\t\t<div class=\"cell SLSfsHeaderText SLSfsHeaderTextTheme\">SEARCH / FILTER</div>\n\t\t\t\t\t<div class=\"cell SLSfsHeaderCell\" id=\"refMain\" onclick=\"refreshMain()\"><img src = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/Reload24x24.png\" /></div>\n\t\t\t\t\t<div class=\"cell SLSfsHeaderCell\"  onclick=\"hideSlideSFS()\"><img src = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/CloseSearch24x24.png\" /></div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\t\t\n\t</div>\n\t</div>\n\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<!-- \t<div class=\"row\" id=\"CNFilterContent\" style=\"height:98%; width:100%\"> MR2\n\t\t<div class=\"cell\"> \n\t\t\t<div style=\"width:100%;height:98%;overflow:hidden;position:relative\">-->\n\t\t\t\t<div  style=\"height: 98%;display:table-row\">\n\t\t\t\t<div class=\"cell\">\n\t\t\t\t<div id=\"SLSfsWrapperMain\" style=\"overflow: hidden;position: relative;width: 100%;height:100%;\">\n\t\t\t\t\t<div id=\"SLSfsScrollerMain\" style=\"position: absolute;width: 100%;height: auto;\">\n\t\t\t\t\t\t<div class=\"table\" id=\"SLSfsMainTable\" style=\"width:100%;position:relative;background:#cfd6e1\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<!-- My spl notes and My notes -->\n\t\t\t\t\t\t\t<!-- Encounter selection STARTS -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<div class=\"table encounterTimeframeWrap\">\n\t\t\t\t\t\t\t<div class=\"table filterTextWrap\">\n\t\t\t\t\t\t\t<div class=\"row\" id=\"headingEC\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row SLSfsCategoryBlock\" onclick=\"CNFilterSectionToggle(\'EC\')\" style=\"width:100%; height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsDivText SLSfsDivTextTheme\" >ENCOUNTER</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsHeaderCellTab SLSfsarrow\" id=\"arrowEC\" ><img  src =\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/DownarrowSFS.png\" /></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"row\" id=\"contentEC\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"SLSfsNormalView\" id=\"dataEC\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsWrapperEC\" style=\"background-color: #ffffff;\"> \n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsScrollerEC\">\n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"table\" id=\"listEC\" style=\"width:100%; height:100%;\">\n\t\t\t\t\t\t\t\t\t\t   \t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"listItemEC\" style=\"width:100%; height:40px;\" onclick=\"chooseEncounterFilter(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'clinicalNotes\',\'fullViewEncounter\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell SLSfsViewItemText SLSfsViewItemTextTheme\" id=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align:middle\"><div class=\"ipOPText\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size:13px;color:#797b7c\">EN ID ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</p>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size:10px;color:#d3c9c9\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" &nbsp ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</p>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsListTick SLSfsListTickTheme\"><div class=\"SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme\" id=\"SLSfsTickEN";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" style=\"display:none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name =\"hdnCurrentEncID\" id =\"hdnCurrentEncID\" value = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/> ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name =\"hdnActiveEncID\" id =\"hdnActiveEncID\" value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t  \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<!-- Encounter selection ENDS -->\n\t\t\t\t\t\t\t<!-- TimeFrame STARTS -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t<div class=\"table filterTextWrap\">\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"hdnDateArrCount\" id =\"hdnDateArrCount\" value = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'/>\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"hdnEncArrCount\" id =\"hdnEncArrCount\" value = \'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'/>\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"hdnEncounterDate\" id =\"hdnEncounterDate\" value = \'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'/>\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"hdnEncounterEnc\" id =\"hdnEncounterEnc\" value = \'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'/>\n\t\t\t\t\t\t\t<div class=\"row\" id=\"headingTF\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row SLSfsCategoryBlock\" onclick=\"CNFilterSectionToggle(\'TF\')\"  style=\"width:100%; height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsDivText SLSfsDivTextTheme\" >TIME FRAME</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsHeaderCellTab \" id=\"arrowTF\" ><img  src =\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="/eIPAD/images/DownarrowSFS.png\" /></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"row\" id=\"contentTF\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"SLSfsNormalView\" id=\"dataTF\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsWrapperTF\" style=\"background-color: #ffffff;\"> \n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsScrollerTF\">\n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"table\" id=\"listTF\" style=\"width:100%; height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"listItemTF\" style=\"width:100%;\" onclick=\"\" data-speccode=\"\" data-specdesc=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell timeFrameSlider\"><div id=\"dateSlider\"><input/> <input/></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"rangeLabels\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"startLabel\"></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"endLabel\">Today</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"selectedDates\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input data-role=\"datepicker\" data-bind=\"value:datepickerStartValue, events:{change:selectedDatesChanged}\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input data-role=\"datepicker\"  data-bind=\"value:datepickerEndValue, events:{change:selectedDatesChanged}\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"timeFrameSearch\" onclick=\"SearchByTimeFrame()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" id=\"btnsfs\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t \t<img src=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="/eIPAD/images/Search18x18.png\" width=\"16px\" ;=\"\" height=\"16px\" style=\"padding-top: 3px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t  \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<!-- TimeFrame ENDS -->\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"table\"  style=\"width:100%;position:relative;background:#eaedf2;\">\n\t\t\t\t\t\t\t<div class=\"table allFilterBgwarp\">\n                            <!-- Clinical Notes Type STARTS -->\n                            \n                            <div class=\"table filterTextWrap\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<div class=\"row\" id=\"headingNT\" style=\"height:40px\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t<div class=\"row disabledRow\" id=\"headingNT\" style=\"height:40px\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row SLSfsCategoryBlock\" onclick=\"CNFilterSectionToggle(\'NT\')\" style=\"width:100%; height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsDivText SLSfsDivTextTheme\" >NOTE TYPE<span class=\"clearFilter\" onclick=\"refreshFilter(\'NT\',event)\">CLEAR</span><span class=\"searchByNotes\" onclick=\"searchByNoteType(event)\"><img  src =\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="/eIPAD/images/SearchGray16x16.png\" /></span></div>\n\t\t\t\t\t\t\t\t\t\t\t<!-- <div class=\"cell slSfsHeaderCell\" onclick=\"refresh(\'SP\',\'PR\',\'NU\')\"> <img  id=\"refSP\" src = \"../images/ReloadGrySFS.png\"  style=\"padding-top:4px\"/></div> -->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsHeaderCellTab \" id=\"arrowNT\" ><img  src =\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="/eIPAD/images/DownarrowSFS.png\" /></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t<div class=\"row\" id=\"textBoxNT\" style=\"width:100%; height:40px; background:#ffffff; \">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsDivShadow SLSfsDivShadowTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align:middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"searchInputSFSNT\" class=\"SLSfsDivLevelTxtBox\" style=\"color:#9da5b3;\"/>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\"  style=\"vertical-align: middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" SLSfsTextBoxCloseButton SLSfsTextBoxCloseButtonTheme\" onclick=\"CNFilterClearTxt(\'NT\',\'MAS\',\'PB\',\'ST\')\"><img src=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="/eIPAD/images/Close-small.png\" style=\"width:10px; height:10px\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t    \t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t<div class=\"row\" id=\"contentNT\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t<div class=\"SLSfsNormalView\" id=\"dataNT\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsWrapperNT\" style=\"background-color: #ffffff;\"> \n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsScrollerNT\">\n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"table\" id=\"listNT\" style=\"width:100%; height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t \t   \t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"listItemNT\" style=\"width:100%; height:40px;\" onclick=\"CNFilterShowTick(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\',\'NT\')\" data-speccode=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" data-specdesc=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell SLSfsViewItemText SLSfsViewItemTextTheme\" id=\"textNT";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</div>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsListTick SLSfsListTickTheme\" id=\"divNT";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"><div class=\"SLSfsTickVisible SLSfsTickVisibleTheme\" id=\"SLSfsTickNT";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" style=\"display:none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t  \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t<!-- <div class=\"row\" id=\"ViewMoreNT\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsTabText SLSfsTabTextTheme\" onclick=\"viewMore(\'NT\',\'MAS\',\'PB\',\'ST\')\"> View More </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t<!-- <div class=\"row\" id=\"ViewLessNT\"  style=\"height:40px\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsTabText SLSfsTabTextTheme\"  onclick=\"viewLess(\'NT\',\'MAS\',\'PB\',\'ST\')\"> Close </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t    </div> -->\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t    <div class=\"row SLSfsAfterSelectionTheme\" id=\"NTAfterSel\">\n\t\t\t\t\t\t   \t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"padding-left:10px;display:block\" id=\"AfterSelectionNT\"></div>\n\t\t\t\t\t\t\t\t</div>\n                            </div>\n                            </div>\n                            ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" \n                           <!-- Clinical Notes Type ENDS -->\n                           <!-- Med n AncServ STARTS -->\n                            <div class=\"table filterTextWrap\">\n                            ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t<div class=\"row\" id=\"headingMAS\" style=\"height:40px\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t<div class=\"row disabledRow\" id=\"headingMAS\" style=\"height:40px\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row SLSfsCategoryBlock\" onclick=\"CNFilterSectionToggle(\'MAS\')\" style=\"width:100%; height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsDivText SLSfsDivTextTheme\" >MED SERVICES</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsHeaderCellTab \" id=\"arrowMAS\" ><img  src =\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t<div class=\"row\" id=\"textBoxMAS\" style=\"width:100%; height:40px; background:#ffffff; \">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsDivShadow SLSfsDivShadowTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align:middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"searchInputSFSMAS\" class=\"SLSfsDivLevelTxtBox\" style=\"color:#9da5b3;\"/>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\"  style=\"vertical-align: middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" SLSfsTextBoxCloseButton SLSfsTextBoxCloseButtonTheme\" onclick=\"CNFilterClearTxt(\'MAS\',\'NT\',\'PB\',\'ST\')\"><img src=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t<div class=\"row\" id=\"contentMAS\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t<div class=\"SLSfsNormalView\" id=\"dataMAS\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsWrapperMAS\" style=\"background-color: #ffffff;\"> \n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsScrollerMAS\">\n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"table\" id=\"listMAS\" style=\"width:100%; height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t \t   \t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"listItemMAS\" style=\"width:100%; height:40px;\" onclick=\"CNFilterShowTick(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\',\'MAS\')\" data-speccode=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell SLSfsViewItemText SLSfsViewItemTextTheme\" id=\"textMAS";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsListTick SLSfsListTickTheme\" id=\"divMAS";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"><div class=\"SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme\" id=\"SLSfsTickMAS";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t<!-- <div class=\"row\" id=\"ViewMoreMAS\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsTabText SLSfsTabTextTheme\" onclick=\"viewMore(\'MAS\',\'NT\',\'PB\',\'ST\')\"> View More </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t<!-- <div class=\"row\" id=\"ViewLessMAS\"  style=\"height:40px\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsTabText SLSfsTabTextTheme\"  onclick=\"viewLess(\'MAS\',\'NT\',\'PB\',\'ST\')\"> Close </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t    </div> -->\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t    <div class=\"row SLSfsAfterSelectionTheme\" id=\"MASAfterSel\">\n\t\t\t\t\t\t   \t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"padding-left:10px;display:block\" id=\"AfterSelectionMAS\"></div>\n\t\t\t\t\t\t\t\t</div>\n                            </div>\n                            </div>\n                             ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n                            \n                            <!-- Med n AncServ ENDS -->\n                            <!-- Status STARTS -->\n                            <div class=\"table filterTextWrap\">\n                            ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t<div class=\"row\" id=\"headingST\" style=\"height:40px\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t<div class=\"row disabledRow\" id=\"headingST\" style=\"height:40px\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row SLSfsCategoryBlock\" onclick=\"CNFilterSectionToggle(\'ST\')\" style=\"width:100%; height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsDivText SLSfsDivTextTheme\" >STATUS</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsHeaderCellTab \" id=\"arrowST\" ><img  src =\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t<div class=\"row\" id=\"textBoxST\" style=\"width:100%; height:40px; background:#ffffff; \">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsDivShadow SLSfsDivShadowTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align:middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"searchInputSFSST\" class=\"SLSfsDivLevelTxtBox\" style=\"color:#9da5b3;\"/>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\"  style=\"vertical-align: middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" SLSfsTextBoxCloseButton SLSfsTextBoxCloseButtonTheme\" onclick=\"CNFilterClearTxt(\'ST\',\'NT\',\'MAS\',\'PB\')\"><img src=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="/eIPAD/images/Close-small.png\" style=\"width:10px; height:10px\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t    \t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t   \t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t<div class=\"row\" id=\"contentST\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t<div class=\"SLSfsNormalView\" id=\"dataST\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsWrapperST\" style=\"background-color: #ffffff;\"> \n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsScrollerST\">\n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"table\" id=\"listST\" style=\"width:100%; height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t \t   \t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"listItemST\" style=\"width:100%; height:40px;\" onclick=\"CNFilterShowTick(\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\',\'ST\')\" data-speccode=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell SLSfsViewItemText SLSfsViewItemTextTheme\" id=\"textST";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsListTick SLSfsListTickTheme\" id=\"divST";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"><div class=\"SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme\" id=\"SLSfsTickST";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t<!-- <div class=\"row\" id=\"ViewMoreST\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsTabText SLSfsTabTextTheme\" onclick=\"viewMore(\'ST\',\'NT\',\'MAS\',\'PB\')\"> View More </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t<!-- <div class=\"row\" id=\"ViewLessST\"  style=\"height:40px\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsTabText SLSfsTabTextTheme\"  onclick=\"viewLess(\'ST\',\'NT\',\'MAS\',\'PB\')\"> Close </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t    </div> -->\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t    <div class=\"row SLSfsAfterSelectionTheme\" id=\"STAfterSel\">\n\t\t\t\t\t\t   \t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"padding-left:10px;display:block\" id=\"AfterSelectionST\"></div>\n\t\t\t\t\t\t\t\t</div>\n                            </div>\n                            </div>\n                            ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" \n                            <!-- Status ENDS -->\n                            <!-- Performed by STARTS -->\n                            <div class=\"table filterTextWrap\">\n                            ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t<div class=\"row\" id=\"headingPB\" style=\"height:40px\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t<div class=\"row disabledRow\" id=\"headingPB\" style=\"height:40px\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t   \t \n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row SLSfsCategoryBlock\"  onclick=\"CNFilterSectionToggle(\'PB\')\"style=\"width:100%; height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsDivText SLSfsDivTextTheme\" >BY PRACTITIONER</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsHeaderCellTab\" id=\"arrowPB\"><img  src =\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t<div class=\"row\" id=\"textBoxPB\" style=\"width:100%; height:40px; background:#ffffff; \">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsDivShadow SLSfsDivShadowTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align:middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"searchInputSFSPB\" class=\"SLSfsDivLevelTxtBox\" style=\"color:#9da5b3;\"/>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\"  style=\"vertical-align: middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" SLSfsTextBoxCloseButton SLSfsTextBoxCloseButtonTheme\" onclick=\"CNFilterClearTxt(\'PB\',\'NT\',\'MAS\',\'ST\')\"><img src=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t<div class=\"row\" id=\"contentPB\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t<div class=\"SLSfsNormalView\" id=\"dataPB\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsWrapperPB\" style=\"background-color: #ffffff;\"> \n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsScrollerPB\">\n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"table\" id=\"listPB\" style=\"width:100%; height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t \t   \t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"listItemPB\" style=\"width:100%; height:40px;\" onclick=\"CNFilterShowTick(\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\',\'PB\')\" data-speccode=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell SLSfsViewItemText SLSfsViewItemTextTheme\" id=\"textPB";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</div> ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsListTick SLSfsListTickTheme\" id=\"divPB";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"><div class=\"SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme\" id=\"SLSfsTickPB";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t  \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t<!-- <div class=\"row\" id=\"ViewMorePB\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsTabText SLSfsTabTextTheme\" onclick=\"viewMore(\'PB\',\'NT\',\'MAS\',\'ST\')\"> View More </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t<!-- <div class=\"row\" id=\"ViewLessPB\"  style=\"height:40px\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsTabText SLSfsTabTextTheme\"  onclick=\"viewLess(\'PB\',\'NT\',\'MAS\',\'ST\')\"> Close </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t    </div> -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t    <div class=\"row SLSfsAfterSelectionTheme\" id=\"PBAfterSel\">\n\t\t\t\t\t\t   \t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"padding-left:10px;display:block\" id=\"AfterSelectionPB\"></div>\n\t\t\t\t\t\t\t\t</div>\n                            </div>\n                            </div>\n                            ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" \n                            <!-- performed by ENDS -->\n\t\t\t\t\t\t</div><!-- allFilterBgwarp end-->\n                            <!-- showNotes STARTS-->\n                            ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n                            <!-- showNotes ENDS-->\n                             ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t</div><!-- cell close-->\n\t\t\t\t</div><!-- row end-->\n\t\t\t<!-- \t</div>\n\t\t\t\n\t</div>\n\t</div> -->\n</div>\n\n\n\t\n\n\n\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Locale appLocale; //for session values
	if (session.getAttribute("LOCALE") != null
			&& !session.getAttribute("LOCALE").equals(""))
		appLocale = new Locale((String) session.getAttribute("LOCALE"));
	else
		appLocale = new Locale("en");
	ResourceBundle csResBundle = ResourceBundle.getBundle(
			"eIPAD.chartsummary.common.resourcebundle.cslabels",
			appLocale);
		
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
	String loggedInUser = patientContext.getLoggedInUser();
	String currentEncID = patientContext.getEncounterId();
	
	Gson gson = new Gson();
	String jsonFieldResDate = "";
	String jsonFieldResEnc = "";
	String viewPage = request.getParameter("viewPage");
	String finalStartDate = request.getParameter("finalStartDate");
	String finalEndDate = request.getParameter("finalEndDate");
	String selectedEncounterID ="";
	
	selectedEncounterID = request.getParameter("encounterID");
	//patientContext.setEncounterId((String)selectedEncounters);

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);

	int nLoopCount = 0;
	int nRowCount = 0;
	String specCode= "";
	ClinicalNotesBC objBC = new ClinicalNotesBC();//calling bc
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block13Bytes, _wl_block13);

							
							EncounterListResponse allEncountersResp = (EncounterListResponse)request.getAttribute("EncounterListResponse");
							ArrayList<EncounterHO> allEncArrayList = new ArrayList<EncounterHO>();
							EncounterHO currentEncounter = new EncounterHO();
							if(allEncountersResp!=null && allEncountersResp.isSuccessResponse() && !allEncountersResp.isEmptyDataResponse()){
								allEncArrayList = allEncountersResp.getEncounterList();
						
							}
						
							
            _bw.write(_wl_block14Bytes, _wl_block14);
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);

																for(int i=0;i<allEncArrayList.size();i++){ 
																	EncounterHO iEncounter = allEncArrayList.get(i);
																	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(iEncounter.getEncounterId()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(iEncounter.getPatientClass()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(iEncounter.getEncounterId()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(iEncounter.getFromDate() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(iEncounter.getToDate()));
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iEncounter.getEncounterId()));
            _bw.write(_wl_block24Bytes, _wl_block24);

																	}
															
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(selectedEncounterID));
            _bw.write(_wl_block26Bytes, _wl_block26);
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patientContext.getEncounterId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            _bw.write(_wl_block28Bytes, _wl_block28);

							ArrayList<String> dateArray = new ArrayList<String>();
							ArrayList<String> encArray = new ArrayList<String>();
							
							for(int i=0;i<allEncArrayList.size();i++){ 
							EncounterHO EncounterLst = allEncArrayList.get(i);
							dateArray.add(EncounterLst.getFromDate());
							encArray.add(EncounterLst.getEncounterId());
							}
							int hdnDateArrCount = dateArray.size();
							int hdnEncArrCount = encArray.size();
							jsonFieldResDate = gson.toJson(dateArray);
							jsonFieldResEnc = gson.toJson(encArray);
							
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(hdnDateArrCount));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(hdnEncArrCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(jsonFieldResDate));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(jsonFieldResEnc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block35Bytes, _wl_block35);

							ClinicalNotesFieldResponse oClint = objBC.getNoteTypeListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);//for response
						 	List<ClinicalNotesFieldItem> NoteTypeList;//to get the list
							ClinicalNotesFieldItem oCNFieldItemsNT;//obj to get field values
							NoteTypeList = oClint.getFieldList();
							int nLstCountNT = NoteTypeList.size();
							
						   	
            _bw.write(_wl_block36Bytes, _wl_block36);
 if(nLstCountNT > 0){
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);

							if(nLstCountNT > 10){
							
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);

							}
							try {
							if(nLstCountNT > 0){
							
            _bw.write(_wl_block45Bytes, _wl_block45);
            _bw.write(_wl_block46Bytes, _wl_block46);

												 	   		for(nLoopCount=0; nLoopCount<nLstCountNT; nLoopCount++){ 
													 	  		oCNFieldItemsNT = NoteTypeList.get(nLoopCount);
													 		  	if(oCNFieldItemsNT != null ){
													 			specCode = oCNFieldItemsNT.getCode();
								 
								 				 	   
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oCNFieldItemsNT.getDesc()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(oCNFieldItemsNT.getDesc()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block55Bytes, _wl_block55);

												  				}
												  					nRowCount = nRowCount + 1;
															} 
													 
            _bw.write(_wl_block56Bytes, _wl_block56);

							}
							if(nLstCountNT > 4){
							
            _bw.write(_wl_block57Bytes, _wl_block57);

							}
						    
            _bw.write(_wl_block58Bytes, _wl_block58);
 } 
								catch( Exception e ){
									e.printStackTrace();
								}
								finally{
								}
            _bw.write(_wl_block59Bytes, _wl_block59);

							ClinicalNotesFieldResponse oClintMAS = objBC.getMedServListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);//for response
						 	List<ClinicalNotesFieldItem> MedServList;//to get the list
							ClinicalNotesFieldItem oCNFieldItemsMAS;//obj to get field values
							MedServList = oClintMAS.getFieldList();
							int nLstCountMAS = MedServList.size();
							
						   	
            _bw.write(_wl_block36Bytes, _wl_block36);
 if(nLstCountMAS > 0){
            _bw.write(_wl_block60Bytes, _wl_block60);
}else{
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);

							if(nLstCountMAS > 10){
							
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);

							}
							try {
							if(nLstCountMAS > 0){
							
            _bw.write(_wl_block65Bytes, _wl_block65);
            _bw.write(_wl_block66Bytes, _wl_block66);

												 	   		for(nLoopCount=0; nLoopCount<nLstCountMAS; nLoopCount++){ 
													 	  		oCNFieldItemsMAS = MedServList.get(nLoopCount);
													 		  	if(oCNFieldItemsMAS != null ){
													 			specCode = oCNFieldItemsMAS.getCode();
								 
								 				 	   
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oCNFieldItemsMAS.getDesc()));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(oCNFieldItemsMAS.getDesc()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block55Bytes, _wl_block55);

												  				}
												  					nRowCount = nRowCount + 1;
															} 
													 
            _bw.write(_wl_block56Bytes, _wl_block56);

							}
							if(nLstCountMAS > 4){
							
            _bw.write(_wl_block72Bytes, _wl_block72);

							}
						    
            _bw.write(_wl_block73Bytes, _wl_block73);
 } 
								catch( Exception e ){
									e.printStackTrace();
								}
								finally{
								}
            _bw.write(_wl_block74Bytes, _wl_block74);

                            ClinicalNotesFieldResponse oClintStatus = objBC.getStatusListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);
                            List<ClinicalNotesFieldItem> StatusList;
                            ClinicalNotesFieldItem oCNFieldItemsStatus;
                            StatusList = oClintStatus.getFieldList();
                            int nLstCountStatus = StatusList.size();
							try {
						   	
            _bw.write(_wl_block36Bytes, _wl_block36);
 if(nLstCountStatus > 0){
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);

							if(nLstCountStatus > 10){
							
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block80Bytes, _wl_block80);

							}
							if(nLstCountStatus > 0){
						   	
            _bw.write(_wl_block81Bytes, _wl_block81);
            _bw.write(_wl_block82Bytes, _wl_block82);

												 	   		for(nLoopCount=0; nLoopCount<nLstCountStatus; nLoopCount++){ 
												 	   			oCNFieldItemsStatus = StatusList.get(nLoopCount);
													 		  	if(oCNFieldItemsStatus != null ){
													 			specCode = oCNFieldItemsStatus.getCode();
								 
								 				 	   
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oCNFieldItemsStatus.getDesc()));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(oCNFieldItemsStatus.getDesc()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block55Bytes, _wl_block55);

												  				}
												  					nRowCount = nRowCount + 1;
															} 
													 
            _bw.write(_wl_block56Bytes, _wl_block56);

							   	}
							if(nLstCountStatus > 4){
							
            _bw.write(_wl_block88Bytes, _wl_block88);

							}
						    
            _bw.write(_wl_block89Bytes, _wl_block89);
 } 
								catch( Exception e ){
									e.printStackTrace();
								}
								finally{
								}
            _bw.write(_wl_block90Bytes, _wl_block90);

							ClinicalNotesFieldResponse oClintPB = objBC.getPerformedByListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);//for response
						 	List<ClinicalNotesFieldItem> PerformedByList;//to get the list
							ClinicalNotesFieldItem oCNFieldItemsPB;//obj to get field values
							PerformedByList = oClintPB.getFieldList();
							int nLstCountPB = PerformedByList.size();
							
						   	
            _bw.write(_wl_block36Bytes, _wl_block36);
 if(nLstCountPB > 0){
            _bw.write(_wl_block91Bytes, _wl_block91);
}else{
            _bw.write(_wl_block92Bytes, _wl_block92);
}
            _bw.write(_wl_block93Bytes, _wl_block93);
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);

							if(nLstCountPB > 10){
							
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);

							}
							try {
							if(nLstCountPB > 0){
							
            _bw.write(_wl_block96Bytes, _wl_block96);
            _bw.write(_wl_block97Bytes, _wl_block97);

											 	   		for(nLoopCount=0; nLoopCount<nLstCountPB; nLoopCount++){ 
											 	   			oCNFieldItemsPB = PerformedByList.get(nLoopCount);
												 		  	if(oCNFieldItemsPB != null ){
												 			specCode = oCNFieldItemsPB.getCode();
								 
								 				 	   
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oCNFieldItemsPB.getDesc()));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(oCNFieldItemsPB.getDesc()));
            _bw.write(_wl_block101Bytes, _wl_block101);
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block55Bytes, _wl_block55);

												  				}
												  					nRowCount = nRowCount + 1;
															} 
													 
            _bw.write(_wl_block104Bytes, _wl_block104);

							   	}
							if(nLstCountPB > 4){
							
            _bw.write(_wl_block105Bytes, _wl_block105);

							}
							
            _bw.write(_wl_block106Bytes, _wl_block106);
 } 
								catch( Exception e ){
									e.printStackTrace();
								}
								finally{
								}
            _bw.write(_wl_block107Bytes, _wl_block107);
            _bw.write(_wl_block108Bytes, _wl_block108);
            _bw.write(_wl_block109Bytes, _wl_block109);
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
