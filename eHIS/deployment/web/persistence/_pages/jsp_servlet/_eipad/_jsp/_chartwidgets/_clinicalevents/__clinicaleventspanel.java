package jsp_servlet._eipad._jsp._chartwidgets._clinicalevents;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.CLEventHistory.bc.ClinicalEventsBC;
import eIPAD.chartsummary.CLEventHistory.request.ClinicalEventsFilterRequest;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventDatewiseCountResponse;
import eIPAD.chartsummary.CLEventHistory.healthobject.CLEventHistoryItemHO;
import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventHistItemCount;
import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventDateCountItem;
import java.util.Date;
import java.text.SimpleDateFormat;
import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventHistItemCountDets;
import java.util.List;

public final class __clinicaleventspanel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalevents/ClinicalEventsPanel.jsp", 1709118013975L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="                \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<div class=\"eventsSidePanel\" >\t\n\t<div class=\"dateSelection\">\t\t\n\t\t<div class=\"selectdate\">Select a date</div> \n\t\t<div style=\"display: inline-block;float:right;margin:-5px;margin-top:1px;\"><input id=\"cevtdate\"></div>\t\t\n\t</div>\t\t\n\t<div id=\"datePanelWrap\" style=\"Clear:both;top:5px;padding-top: 0px;\">\n\t\t<div class=\"datePanelScroller\">\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t<div class=\"dayWiseWrap selectedDate\" onclick=\"dateChangeOnClick(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\')\" id=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" data-intialvalue=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" data-dateValue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\t\n\t\t\t\t\t\t\t<input type=\"hidden\"  name = \"intialvalue\" id = \"intialvalue\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<div class=\"dayWiseWrap\" onclick=\"dateChangeOnClick(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\', \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t<div class=\"table\">\n\t\t\t\t\t\t\t\t<div class=\"date-header\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" \n\t\t\t\t\t\t\t\t\t\t\tclass=\"row SLSfsInlineBlock SLSfsInlineBlockTheme clincalTheme";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" \n\t\t\t\t\t\t\t\t\t\t\tonclick=\"eventsOnClick(event,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\"> \n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsInlineBlockCell SLSfsInlineBlockCellTheme\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsInlineBlockClose\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\"  name = \"eventDates\" id = \"eventDates\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\"  name = \"eventType\" id = \"eventType\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\"  name = \"patClass\" id = \"patClass\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30_0 ="\" />\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t</div>\t\n</div>\n<div id=\"PageLoadingAnimation\" class=\"absoluteCenter\"></div>\n<script>\n\tfunction formatSystemDate(d) {\n        var month = \'\' + (d.getMonth() + 1),\n        day = \'\' + d.getDate(),\n        year = d.getFullYear();\n        return [year, month, day].join(\'-\');\n    }\n\t\n\tfunction getFormattedDate(t_sdate){\n\t\tvar currDate = new Date();\n\t\tvar formmatedCurrDate = formatSystemDate(currDate); \t\t\t\n\t\tvar previousDate = new Date(new Date().getTime() - 60*60*24*1000);\n\t\tvar formmatedPrevDate = formatSystemDate(previousDate); \t\t\t\n\t\tvar combineDatestr = \"\";\n\t\t\t\n\t\tif(t_sdate == formmatedCurrDate){\n\t\t\tcombineDatestr = \"Today\";\n\t\t}\n\t\telse if(t_sdate == formmatedPrevDate){\n\t\t\tcombineDatestr = \"Yesterday\";\n\t\t}\n\t\telse{\n\t\t\tvar sptdate = String(t_sdate).split(\"-\");\n\t        var monthsList = [\'Jan\', \'Feb\', \'Mar\', \'Apr\', \'May\', \'Jun\', \'Jul\', \'Aug\', \'Sep\', \'Oct\', \'Nov\', \'Dec\'];\n\t        var Month = sptdate[1];\n\t        var Day = sptdate[2];\n\t        var Year = sptdate[0];\n\t        combineDatestr = Day + \" \" + monthsList[Month - 1] + \" \" + Year;\n\t\t}\n\t\treturn combineDatestr;\n\t} \t\t\n\t\n\tfunction setHeightAndBase(){\n\t    var fromTopValues=0;\n\t    $(\"div[data-notes]\").each( function (index, value) {\n\t\t    var dataNotes =$(this).attr(\'data-notes\');\n            var headerID = dataNotes;\n\t\t    var headerTop= $(\"#\"+headerID).height();\n\t        $(this).attr(\'data-start\', fromTopValues);\n            fromTopValues=fromTopValues+headerTop;\n                $(this).attr(\'data-height\', headerTop);\n                $(this).attr(\'data-end\', fromTopValues);\n            });\n\t}\n \n    function addHideAttribute(pos){\n\t\tvar counts=[];\n\t\tvar display=\"display\";\n\t\t$(\"div[data-notes]\").each( function (index, value){\n\t\t\tvar datadisp =$(this).attr(\'data-disp\');\n\t\t\tif(datadisp==display){\n\t\t\t\tcounts.push(display);\n\t\t\t}\n\t\t});\n\t\tif(counts.length>5){\n\t\t    var dataHeight =$(\"#\"+pos+\"_event\").attr(\'data-height\');\n            var showEvents=$(\"#\"+pos+\"_event\");\n\t\t    $(\"#\"+pos+\"_event\").attr(\"data-disp\", \"none\");\t\n\t\t    $(\"#\"+pos+\"_event\").attr(\"data-removed\", \"yes\");\t\n\t\t    $(\"#\"+pos+\"_event\").attr(\"data-previous\",dataHeight);\t\n\t\t}\n\t}\n\t\n    function addShowAttribute(pos){\n\t\tvar showEvents=$(\"#\"+pos+\"_event\");\n\t\t$(\"#\"+pos+\"_event\").attr(\"data-disp\", \"display\");\n\t\t$(\"#\"+pos+\"_event\").css(\'display\',\'block\');\n\t}\n\t\n\tfunction onInitialLoad(){\n\t\t$(\'.notesViewWrapper .notes\').empty();\n\t\tvar dateArr=[];\n\t\tvar adder=[];\n\t\tif ($(\"#eventDates\").val() != null && $(\"#eventDates\").val() != \"\") {\n\t\t\tdateArr = $(\"#eventDates\").val().split(\",\");\n\t\t\tdateArr.pop();\n\t\t}\n\t\telse if($(\"#eventDates\").val() == \"\"){\n\t\t\t$(\"#noEventsMsg\").css(\"display\",\"block\");\n\t\t}\n\t\tif(dateArr.length>0)\t\t\n\t\t\t$(\"#PageLoadingAnimation\").show();\n         \n\t\t    for(var i=0;i<dateArr.length;i++){\n\t\t  $(\'.notesViewWrapper .notes\').append(\'<div style=\"display:none;\" id=\"\'+i+\'_event\" data-disp=\"none\" data-positions=\'+i+\' data-date=\'+dateArr[i]+\' data-notes=\"\'+i+\'_event\"><div class=\"clinicalEventDateHeader header\'+i+\'\"><div class=\"clinicalEventDateSpan\"><div class=\"clinicalEventDatePosition\">\'+getFormattedDate(dateArr[i])+\'</div></div></div><div style=\"overflow:hidden;\" id=\"date\'+dateArr[i]+\'\" class=\"note\'+i+\'\"></div></div>\'); \n\t\t    }\n\t\t\n\t\t    var dateArrLength=dateArr.length;\n\t\t    var count;\n\t\t    if(dateArrLength>=5){\n\t\t       count=5;\t\t\t\t\n\t\t    }else{\n\t\t\t   count=dateArrLength;\t\t\t\t\n\t\t    }\n\t\t\n\t\t    for(var i=0;i<count;i++){   \t\t\n\t\t        addShowAttribute(i);\n\t\t\t    $(\".note\"+i).append(\"<div class=\'PageLoadingAnimationInside\'></div>\");\t\n\t            var selected_encd= $(\'#SelectedhdnEncIDs\').val();\t\n\t            var startFilterDate= $(\'#Selectedhdnstart\').val();\n\t            var endFilterDate= $(\'#Selectedhdnend\').val();\n\t            var PCFilter= $(\'#Selectedhdnpc\').val();\n\t            var HTFilter= $(\'#SelectedhdnHT\').val();\n\t\t\n\t\t\t    if(selected_encd==undefined){\n\t\t\t\t selected_encd=\"\";\n\t\t\t    }\n\t\t\t    if(startFilterDate==undefined){\n\t\t\t\t startFilterDate=\"\";\n\t\t\t    }\n\t\t\t    if(endFilterDate==undefined){\n\t\t\t\t endFilterDate=\"\";\n\t\t\t    }\n\t\t\t    if(PCFilter==undefined){\n\t\t\t\t PCFilter=\"\";\n\t\t\t    }\n\t\t\t    if(HTFilter==undefined){\n\t\t\t\t HTFilter=\"\";\n\t\t\t    }\t\t\t\n\t\t\t    $(\"#\"+i+\"_event\").css(\'display\',\'block\');\n\t    \t    $(\".note\"+i).load(path+\'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventSelectedView.jsp?date=\'+dateArr[i]+\'&pos=\'+i+\'&selected_encd=\'+selected_encd+\'&startFilterDate=\'+startFilterDate+\'&endFilterDate=\'+endFilterDate+\'&PCFilter=\'+PCFilter+\'&HTFilter=\'+HTFilter,\n        \t      function(res){ \n\t\t\t\t\tadder.push(res);\n\t\t\t\t\tif(adder.length==count){\n\t\t\t\t\t  CEMainScroll.scrollToElement(\".header0\" , 0 );\n\t\t\t\t\t  $(\"#PageLoadingAnimation\").hide();\n\t\t\t\t\t  setHeightAndBase();\t\n\t\t\t\t\t}\n\t\t\t\t\tCEMainScroll.refresh();\t\n                  }\n\t\t        );\t\t\t\t\t  \n\t        }\t    \n\t\n\t    var availableDates = $(\'#eventDates\').val().slice(0, -1).split(\",\");\n        var minDate = availableDates[availableDates.length - 1].split(/[^0-9]/);\n        var pastDate = new Date(minDate[0], minDate[1] - 1, \"01\"); \n        var today = new Date();\n        var maxDate = new Date(today.getFullYear(), today.getMonth() + 1, \"0\");\n        $(\"#cevtdate\").kendoDatePicker({\n            value: new Date(),\n            min: new Date(pastDate.setDate(pastDate.getDate())),\n            max: new Date(maxDate.setDate(maxDate.getDate())),\n            dates: availableDates,\n            disableDates: function(date) {\n                            var dates = $(\"#cevtdate\").data(\"kendoDatePicker\").options.dates;\n                            if (date && compareDates(date, dates)) {\n                                return false;\n                            } else\n                            {\n                                return true;\n                            }\n            },\n            change: function() {\n                        var value = this.value();\n                        var evtId = value.getFullYear().toString() + \'-\' + (value.getMonth() + 1).toString() + \'-\' + value.getDate().toString();\n                        dateChangeOnClick(evtId);\n            }\n        }); \n    }  \n\t\t\n\t$(document).ready(function() {\t\n        parent.setOnLoadContentPaneHeight();\n        datePanelWrap = new IScroll(\'#datePanelWrap\', {\n\t\t   vScroll: true,\n\t\t   click: true,\n           mouseWheel: true\n        });\n\t    onInitialLoad();\n        if ($(\'.selectedDate input\').val() != undefined) {\n           $(\'#EventsSidePanel\').show();        \n        } else{\n\t\t   $(\'#EventsSidePanel\').hide();\n\t\t}\n\t\t   \t\n        $(document).on(\'click\', \'.dayWiseWrap\', function() {\n            $(\'.dayWiseWrap\').removeClass(\'selectedDate\');\n            $(this).toggleClass(\'selectedDate\');\n        });\n    });\n\n    function available(date) {\n        dmy = date.getDate() + \"-\" + (date.getMonth() + 1) + \"-\" + date.getFullYear();\n        if ($.inArray(dmy, availableDates) != -1) {\n            return [true, \"\", \"Available\"];\n        } else {\n            return [false, \"\", \"unAvailable\"];\n        }\n    }\n\n    function compareDates(date, dates) {\n        for (var i = 0; i < dates.length; i++) {\n            var dateArray = dates[i].split(/[^0-9]/);\n            var dt = new Date(dateArray[0], dateArray[1] - 1, dateArray[2]);\n            if (dt.getDate() == date.getDate() && dt.getMonth() == date.getMonth() && dt.getYear() == date.getYear()) {\n                return true;\n            }\n        }\n    }\n\t\n\tfunction getAllPostions(){\t\t\n\t\tvar checkArray=[];\n\t\tvar eventDatesObj = $(\"#eventDates\").val().split(\",\");\n        eventDatesObj.pop();\t\t \n\t\tfor(var i=0;i<eventDatesObj.length;i++){  \t\t \n\t\t  checkArray.push(i);\t\t\n\t\t}\t\t \n\t\treturn  checkArray;\n\t}\n\t\n\tfunction checkGivenValuesInsideRange(start,end){\n\t\t var checkArray=[];\n\t\t var eventDatesObj = $(\"#eventDates\").val().split(\",\");\n         eventDatesObj.pop();\n\t\t var allPos=getAllPostions();\n\t\n\t\t for(var i=start;i<=end;i++){  \t\t \n\t\t    if(allPos.indexOf(i)!=-1){\t\t\t\t\n\t\t\t\tcheckArray.push(i);\t\t\t\t\n\t\t    }\t\t \n        }\t\t\n\t\treturn  checkArray;\t\t\n\t}\n\n\tfunction dateChangeOnClick(date,position){\n        $(\".SLSfsInlineBlockTheme\").removeClass(\'highlightSelectedEvent\'); \n        $(\'.notesViewWrapper .notes\').html(\'\');\t\n\t    var eventDatesObj = $(\"#eventDates\").val().split(\",\");\n\t    eventDatesObj.pop();\n        var pos = parseInt(position);\n        var adder = [];\n        var selectedPos;\n\n        if (position == undefined) {\n           var datePosInCalendar = eventDatesObj.indexOf(date);\n           selectedPos = datePosInCalendar;\n        } else {\n           selectedPos = position;\n        }\t\n\t    var start= parseInt(selectedPos)-parseInt(2);\n\t    var end= parseInt(selectedPos)+parseInt(2);\t\n\t    $(\"#PageLoadingAnimation\").show();\n\n\t    for(var i=0;i<eventDatesObj.length;i++){\t\n\t\t  $(\'.notesViewWrapper .notes\').append(\'<div style=\"display:none;\" id=\"\'+i+\'_event\" data-disp=\"none\" data-positions=\'+i+\' data-date=\'+eventDatesObj[i]+\' data-notes=\"\'+i+\'_event\"><div class=\"clinicalEventDateHeader header\'+i+\'\"><div class=\"clinicalEventDateSpan\"><div class=\"clinicalEventDatePosition\">\'+getFormattedDate(eventDatesObj[i])+\'</div></div></div><div style=\"overflow:hidden;\" id=\"date\'+eventDatesObj[i]+\'\" class=\"note\'+i+\'\"></div></div>\'); \n\t\t} \t\t\n\t\tvar rangeChecker=checkGivenValuesInsideRange(start,end);\n\t\tvar len=eventDatesObj.length;\n\t\tvar count;\n\t\tif(len>=5){\n\t\t   count=5;\t\t\t\t\n\t\t} else {\n\t\t\tcount=len;\t\t\t\t\n\t\t}\n\t\t\n\t\tvar selected_encd= $(\'#SelectedhdnEncIDs\').val();\n\t\tvar startFilterDate= $(\'#Selectedhdnstart\').val();\n\t    var endFilterDate= $(\'#Selectedhdnend\').val();\n\t    var PCFilter= $(\'#Selectedhdnpc\').val();\n\t    var HTFilter= $(\'#SelectedhdnHT\').val();\n\t\tif(selected_encd==undefined){\n\t\t\tselected_encd=\"\";\n\t\t}\n\t\tif(startFilterDate==undefined){\n\t\t\tstartFilterDate=\"\";\n\t\t}\n\t\tif(endFilterDate==undefined){\n\t\t\tendFilterDate=\"\";\n\t\t}\n\t\tif(PCFilter==undefined){\n\t\t\tPCFilter=\"\";\n\t\t}\n\t\tif(HTFilter==undefined){\n\t\t\tHTFilter=\"\";\n\t\t}\n\t\t\n\t\tfor(var i=start;i<=end;i++){   \t\t\n\t\t    addShowAttribute(i);\n\t\t\t$(\"#\"+i+\"_event\").css(\'display\',\'block\');\t\t\t\n\t\t\t$(\".note\"+i).append(\"<div class=\'PageLoadingAnimationInside\'></div>\");\t\t\t\t\n\t    \t$(\".note\"+i).load(path+\'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventSelectedView.jsp?date=\'+eventDatesObj[i]+\'&pos=\'+i+\'&selected_encd=\'+selected_encd+\'&startFilterDate=\'+startFilterDate+\'&endFilterDate=\'+endFilterDate+\'&PCFilter=\'+PCFilter+\'&HTFilter=\'+HTFilter,\n        \t  function(res, status, xhr){\n        \t\t$(\"#PageLoadingAnimation\").hide();\n\t\t\t\tadder.push(res);\n\t\t\t\tif(adder.length==rangeChecker.length){\n\t\t\t\t\t$(\"#PageLoadingAnimation\").hide();\n\t\t\t\t\tCEMainScroll.refresh();\t\n\t\t\t\t\tsetHeightAndBase();\n                    CEMainScroll.scrollToElement(\".header\"+selectedPos , 0 );\t\t\t\t\t  \n\t\t\t\t}\t\n              }\n\t\t    );\t\t\t\t\t  \n\t    }\n\t  \n\t\t$(\'.dayWiseWrap\').removeClass(\'selec";
    private final static byte[]  _wl_block30_0Bytes = _getBytes( _wl_block30_0 );

    private final static java.lang.String  _wl_block30_1 ="tedDate\');\n        $(\"#\"+date).toggleClass(\'selectedDate\');\n        datePanelWrap.scrollToElement(\".selectedDate\", 1);\n        $(\'#cevtdate\').data(\'kendoDatePicker\').value(date);\n    }\t\n\n    function clear(range,min,max){\n\t  if(range==\"min\"){\n\t    addHideAttribute(max);\n\t  }else{\n\t    addHideAttribute(min);\n\t  }\n\t  setHeightAndBase();\n    }\n\n    function hideAllDivs(){\t\n        $(\"div[data-notes]\").each( function (index, value) {\n            var data_date =$(this).attr(\'data-date\');\n            var data_disp =$(this).attr(\'data-disp\');\n\t        var data_pos =$(this).attr(\'data-positions\');\n\n           if(data_disp==\"none\"){\n\t          $(\"#\"+data_pos+\"_event\").css(\'display\',\'none\');\t\n\t          var dat=\"#date\"+data_date;\t  \n              $(dat).html(\'\');\n           }  \n        });\n    }\n\n    function getMinMaxDate(){\n\t\tvar visibleDatesArr=[];\t\t\t\t\n\t\t$(\"div[data-notes]\").each( function (index, value) {\t\t\t\n\t\t\tvar divDisp = $(this).attr(\'data-disp\');\n\t\t\tvar divPos = $(this).attr(\'data-positions\');\n\t\t\tif(divDisp == \"display\"){\n\t\t\t\tvisibleDatesArr.push(divPos);\n\t\t\t}\n\t\t});\t\n\t\treturn visibleDatesArr;\n    }\n\n\tfunction getLastHideCount(){\n\t    var indexes=0;\n\t    $(\"div[data-notes]\").each( function (index, value) {\t\t\t\n\t\t\tvar removeDiv = $(this).attr(\'data-removed\');\n\t\t\tvar divHeight = $(this).attr(\'data-previous\');\t\t\t\n\t\t\tif(removeDiv == \"yes\"){\n\t\t\t\tindexes=indexes+1;\n\t\t\t}\n\t\t});\t\t\n\t\treturn  indexes;\n    }\n\t\n    function moveToScrollPos(vals){\n\t    var height=0;\n\t    var indexes=0;\n\t    var finalHeight=0;\n\t    $(\"div[data-notes]\").each( function (index, value) {\t\t\t\n\t\t\tvar removeDiv = $(this).attr(\'data-removed\');\n\t\t\tvar divHeight = $(this).attr(\'data-previous\');\n\t\t\t\n\t\t\tif(removeDiv == \"yes\"){\n\t\t\t\tindexes=indexes+1;\t\t\t\t\n\t\t\t\theight=parseInt(height)+parseInt(divHeight);\n\t\t\t}\n\t\t});\t\t\n\t    var calculatedVal=parseInt(vals)-parseInt(height);\t\t\t\n\t    finalHeight=parseInt(calculatedVal)+(parseInt(indexes)*parseInt(1));\n\t    return  finalHeight;\t\n    }\n\t\n\tfunction removeAttribute(){\t\n\t    $(\"div[data-notes]\").each( function (index, value) {\t\t\t\n\t\t\tvar removeDiv = $(this).attr(\'data-removed\');\n\t\t\tvar divHeight = $(this).attr(\'data-previous\');\n\t\t\t\n\t\t\tif(removeDiv == \"yes\"){\n\t\t\t\t$(this).removeAttr(\'data-removed\');\n\t\t\t\t$(this).removeAttr(\'data-previous\');\n\t\t\t}\n\t\t});\t\n\t}\n\t\n    function loadDataOnEnd(date,position,range,min,max,vals){\n\t    var eventDatesObj = $(\"#eventDates\").val().split(\",\");\n        eventDatesObj.pop();\n        var pos = parseInt(position);\n\t    var loadData1;\n\t    var loadData2;\n\t    var loadPos1;\n\t    var loadPos2;\n\t    var currectloadData;\n\t    var loadData;\n\t    var totalClear=0;\n\t    var visibleDatesArr = getMinMaxDate();\n\t\tvar minValue=visibleDatesArr[0];\n\t\tvar maXvalue=visibleDatesArr[visibleDatesArr.length-1];\n\t\t\n\t    if(range==\"min\"){\n\t\t   loadData1 = eventDatesObj[parseInt(position) - parseInt(1)];\n           loadData2 = eventDatesObj[parseInt(position) - parseInt(2)];\t \t\t \n\t       loadPos1 = parseInt(position) - parseInt(1);\n\t\t   loadPos2 = parseInt(position) - parseInt(2);\t\t \n\t    }else if(range==\"max\"){\n\t\t   loadData1 = eventDatesObj[parseInt(position) + parseInt(1)];\n           loadData2 = eventDatesObj[parseInt(position) + parseInt(2)];\n\t       loadPos1 = parseInt(position) + parseInt(1);\n\t\t   loadPos2 = parseInt(position) + parseInt(2);\n\t    }\n\t\n\t    var selected_encd= $(\'#SelectedhdnEncIDs\').val();\n\t    var startFilterDate= $(\'#Selectedhdnstart\').val();\n\t    var endFilterDate= $(\'#Selectedhdnend\').val();\n\t    var PCFilter= $(\'#Selectedhdnpc\').val();\n\t    var HTFilter= $(\'#SelectedhdnHT\').val();\n\t\n\t    if(selected_encd==undefined){\n\t\t\tselected_encd=\"\";\n\t\t}\n\t\tif(startFilterDate==undefined){\n\t\t\tstartFilterDate=\"\";\n\t\t}\n\t\tif(endFilterDate==undefined){\n\t\t\tendFilterDate=\"\";\n\t\t}\n\t\tif(PCFilter==undefined){\n\t\t\tPCFilter=\"\";\n\t\t}\n\t\tif(HTFilter==undefined){\n\t\t\tHTFilter=\"\";\n\t\t}\n\n\t\tif(eventDatesObj.indexOf(loadPos1)==-1){\n\t\t\ttotalClear=totalClear+1;\n\t\t\taddShowAttribute(loadPos1);\n\t\t\tclear(range,min,max);\n\t\t}\n\t\t\t\t\t\n\t    $(\".note\"+loadPos1).append(\"<div class=\'PageLoadingAnimationInside\'></div>\");\t\n\t    $(\".note\"+loadPos1).load(path+\'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventSelectedView.jsp?date=\'+loadData1+\'&pos=\'+loadPos1+\'&selected_encd=\'+selected_encd+\'&startFilterDate=\'+startFilterDate+\'&endFilterDate=\'+endFilterDate+\'&PCFilter=\'+PCFilter+\'&HTFilter=\'+HTFilter,\n        \t\tfunction(res){\t\n\t\t\t\t\t$(\"#PageLoadingAnimation\").hide();\n\t\t\t\t\thideAllDivs();\n\t\t\t\t\tsetHeightAndBase();\t\t\t\t\t\n\t\t\t\t\tif(range==\"max\"){\t\t\t\t\t\t\n\t\t\t\t\t   var recentHideCount=getLastHideCount();\t\t\t\t\t\n\t\t\t\t\t   if(recentHideCount==totalClear){\n\t\t\t\t\t      var scrolls=moveToScrollPos(vals) * parseInt(-1);\t\t\t\t\n\t\t\t\t          setTimeout(function(){ CEMainScroll.scrollTo(0,scrolls); }, 500); \n\t\t\t\t\t   }\t\t\t\t\t\t\t\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\tCEMainScroll.refresh();\n                }\t\t\n\t    );\t\n\t\n\t    if(eventDatesObj.indexOf(loadPos2)==-1){\n\t\t\ttotalClear=totalClear+1;\n\t\t\taddShowAttribute(loadPos2);\n\t\t\tvar visibleDatesArr = getMinMaxDate();\n\t\t    var minValue=visibleDatesArr[0];\n\t\t    var maXvalue=visibleDatesArr[visibleDatesArr.length-1];\n\t\t    clear(range,minValue,maXvalue);\t\t\t\t\n\t\t}\t\n\t    $(\".note\"+loadPos2).append(\"<div class=\'PageLoadingAnimationInside\'></div>\");\t\n\t    $(\".note\"+loadPos2).load(path+\'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventSelectedView.jsp?date=\'+loadData2+\'&pos=\'+loadPos2+\'&selected_encd=\'+selected_encd+\'&startFilterDate=\'+startFilterDate+\'&endFilterDate=\'+endFilterDate+\'&PCFilter=\'+PCFilter+\'&HTFilter=\'+HTFilter,\n        \t\tfunction(res){\t\n\t\t\t\t\t$(\"#PageLoadingAnimation\").hide();\n\t\t\t\t\thideAllDivs();\n\t\t\t\t\tsetHeightAndBase();\t\t\t\t\t\n\t\t\t\t    if(range==\"max\"){\n\t\t\t\t\t   var recentHideCount=getLastHideCount();\t\t\t\t\t\n\t\t\t\t\t    if(recentHideCount==totalClear){\n\t\t\t\t\t      var scrolls=moveToScrollPos(vals) * parseInt(-1);\n\t\t                  setTimeout(function(){ CEMainScroll.scrollTo(0,scrolls); }, 500); \n\t\t\t\t\t    }\n\t\t\t\t    }\n\t\t\t\t\tCEMainScroll.refresh();\t\n                }\t\t\n\t    );\t\n\t\t\n\t    if(range==\"min\"){\n\t\t   loadData=eventDatesObj[loadPos2];\n\t\t   currectloadData=eventDatesObj[minValue];\t\t\n\t    }else if(range==\"max\"){\n\t\t   loadData=eventDatesObj[pos];\n\t\t   currectloadData=eventDatesObj[maXvalue];\t\t\n\t    }\n\n\t    if(eventDatesObj.length>5){\n\t\t    if(loadData==undefined){\n\t\t\t  $(\'.dayWiseWrap\').removeClass(\'selectedDate\');\n              $(\"#\"+currectloadData).toggleClass(\'selectedDate\');\n\t\t\t  datePanelWrap.scrollToElement(\".selectedDate\", 1);\n\t\t    }else{\n\t\t\t  $(\'.dayWiseWrap\').removeClass(\'selectedDate\');\n              $(\"#\"+loadData).toggleClass(\'selectedDate\');\n\t\t\t  datePanelWrap.scrollToElement(\".selectedDate\", 1);\n\t\t    }\n\t    }\n         \t\n    }\t\n\n    function eventsOnClick(evt, eventDateObj) {\n\t    evt.stopPropagation();\n\t    var str = eventDateObj;\n        var res = str.split(\"_\");    \n\t    var current= res[1];\n\t    var htmlElem= $(\".\"+eventDateObj).html();\n\t    var eventDatesObjs = $(\"#eventDates\").val().split(\",\");\n        eventDatesObjs.pop();\n\t    var datePosInCalendar = eventDatesObjs.indexOf(current);\n\n\t    if(htmlElem==undefined){\n\t\t    dateChangeOnClick(current,datePosInCalendar);\n            setTimeout(function(){  \t\t \n\t\t       CEMainScroll.scrollToElement(\".\"+eventDateObj , 1 );\n            }, 1500);\n\t    }else{\n\t\t    CEMainScroll.scrollToElement(\".\"+eventDateObj , 1 );\n\t    }\n\n\t    $(\".SLSfsInlineBlockTheme\").removeClass(\'highlightSelectedEvent\');\t\n\t    $(\"#\"+eventDateObj).toggleClass(\'highlightSelectedEvent\');\t\n\t    $(\'.dayWiseWrap\').removeClass(\'selectedDate\');\n        $(\"#\"+current).toggleClass(\'selectedDate\');\n\t    datePanelWrap.scrollToElement(\".selectedDate\", 1);\t\n    }\n\n    CEMainScroll.on (\'scrollStart\', function () {\n        $(\".SLSfsInlineBlockTheme\").removeClass(\'highlightSelectedEvent\');\n    });\n\n</script>\n\n<style>\n.PageLoadingAnimationInside{\n\tz-index: 10000;\n\twidth: 100%;\n\theight: 25px;\n\tbackground-color: #808080;\n\topacity: 0.4;\n\tbackground-image: url(";
    private final static byte[]  _wl_block30_1Bytes = _getBytes( _wl_block30_1 );

    private final static java.lang.String  _wl_block31 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\t \n}\n.highlightSelectedEvent{\n\tbox-shadow: 0px 2px 3px #888888;\n}\n</style>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block4Bytes, _wl_block4);

				PatContext patientContext = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
				String loggedInUser = patientContext.getLoggedInUser();
				ClinicalEventsBC objEvents = new ClinicalEventsBC();
				ClinicalEventsFilterRequest eventsReq = new ClinicalEventsFilterRequest();
				eventsReq.setPatientContext(patientContext);
				
				String encounterIDs = request.getParameter("encounterIds")==null?"":request.getParameter("encounterIds");				
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");
				String patientClass= request.getParameter("patientClass");
				String historyType = request.getParameter("historyType");
		
				StringTokenizer stoken = new java.util.StringTokenizer(encounterIDs,",");	
				ArrayList<String> encounterIdList = new ArrayList<String>();
				while(stoken.hasMoreTokens()){
					String encId	=	(String) stoken.nextToken();
					encounterIdList.add(encId);
				}				
				eventsReq.setEncounterIdList(encounterIdList);
				eventsReq.setFromDate(startDate);
				eventsReq.setToDate(endDate);
				eventsReq.setPatientClass(patientClass);
				eventsReq.setHistoryType(historyType);				
				
				ClinicalEventDatewiseCountResponse res = objEvents.getDatewiseEventsCount(eventsReq);
				
				List<ClinicalEventDateCountItem> eventsList;
				ClinicalEventDateCountItem objHO;
				eventsList = res.getDatewiseEventList();
				int countEvents = eventsList.size();
				
				String eventDates = new String("");
				String eventType = new String("");
				String patClass = new String("");
				for(int nLoopCount=0; nLoopCount<countEvents; nLoopCount++)
					{ 
						objHO = eventsList.get(nLoopCount);
						ArrayList<ClinicalEventHistItemCount> objEventItems =objHO.getEventItemsCount();
						if(objHO != null ){
							Date todayDt = new Date();
							Date yesdayDt =new Date(new Date().getTime() - 60*60*24*1000);
							String todayDateStr = new String("");
							String yesdayDateStr = new String("");
							String dateStr = new String("");
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d"); 
							String startDateStr = dateFormat.format(objHO.getEventDate());
							eventDates=eventDates+startDateStr+",";
							SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
							todayDateStr= formatter.format(todayDt).toUpperCase();
							yesdayDateStr= formatter.format(yesdayDt).toUpperCase();
							dateStr= formatter.format(objHO.getEventDate()).toUpperCase();
							if (dateStr.equals(todayDateStr))
								todayDateStr="Today";
							else if (dateStr.equals(yesdayDateStr))
								todayDateStr="Yesterday";
							else
								todayDateStr=dateStr;
						
            _bw.write(_wl_block5Bytes, _wl_block5);
if(nLoopCount == 0){
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(startDateStr));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(startDateStr));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(startDateStr));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(objHO.getEventDate()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(startDateStr));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(startDateStr));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(startDateStr));
            _bw.write(_wl_block15Bytes, _wl_block15);
}	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(todayDateStr));
            _bw.write(_wl_block17Bytes, _wl_block17);
	for(int j=0; j<objEventItems.size(); j++)
										{ 
											ClinicalEventHistItemCount objHistItem =objEventItems.get(j);
											 if(eventType.indexOf(objHistItem.getHistType()) == -1){
												eventType=eventType+objHistItem.getHistType()+",";	  
											 }
									 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(objHistItem.getHistType()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(startDateStr));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(objHistItem.getHistType()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(objHistItem.getHistType()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(startDateStr));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(objHistItem.getHistDesc()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(objHistItem.getCount()));
            _bw.write(_wl_block24Bytes, _wl_block24);
	ArrayList<ClinicalEventHistItemCountDets>  singleItmes	=	objHistItem.getEventDetailsList();
													 for(int k=0;k<singleItmes.size();k++){
														 ClinicalEventHistItemCountDets singleItme=singleItmes.get(k);														 
														 if(patClass.indexOf(singleItme.getPatientClass()) == -1){
															patClass=patClass+singleItme.getPatientClass()+",";	  
														}
											}}
            _bw.write(_wl_block25Bytes, _wl_block25);
}}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(eventDates));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(eventType));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patClass));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block30_0Bytes, _wl_block30_0);
            _bw.write(_wl_block30_1Bytes, _wl_block30_1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);
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
