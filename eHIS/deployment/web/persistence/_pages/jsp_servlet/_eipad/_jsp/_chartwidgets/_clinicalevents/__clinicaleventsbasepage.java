package jsp_servlet._eipad._jsp._chartwidgets._clinicalevents;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __clinicaleventsbasepage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalevents/ClinicalEventsBasePage.jsp", 1738426597060L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<!DOCTYPE html>\n<html>\n    <head>\n        <meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n\t\t\n        <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="/eIPAD/jquery.mobile-1.3.1.min.css\" />\n\t\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/jquery-ui-1.7.2.custom.css\" />\n        <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/iPADNew.css\" />\n\t\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/css/iPADThemeA.css\" /> \n\t\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/mCommon.css\" /> \n\t\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/SlideSFS.css\" />\n\t\t <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/css/kendo.common.min.css\" />\n        <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/css/kendo.default.min.css\" />\n    </head>\n\n    <body style=\"display: block; margin: 0px; height: 100%; width: 100%;\">\n    <div class=\"ChartSummaryParent ChartSummaryParentTheme clinicalEventsWrap\" data-role=\"page\">\n\t\t<div id=\"PageLoadingAnimation\" class=\"absoluteCenter\">\n\t\t</div>\n        <!--SFS jsp starts-->\n\t\t<div  class=\"slideSfsOpener\"  id=\"SlideOpener\">\n\t\t\t<img id=\"sfsSearchImg\" src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/Open_window.png\"/>\n\t\t</div>\t\t\n\n\t\t<div class=\"EventsSideSFS\" id=\"EventsSideSFS\">\n\t\t</div>\n\t\t<!--SFS jsp ends-->\n\t\t<div class=\"ChartSummaryBlock\" id=\"ChartSummaryBlock\" data-role = \"none\">\n\t\t\t<form id=\"ChartSummaryForm\" name = \"ChartSummaryForm\" method = \"post\" action = \"\" class=\"ChartSummaryFormElem\">\n\t\t\t\t<div class=\"ChartSummaryMainTable\" data-role = \"none\">\n\t\t\t\t\t<div data-role = \"none\" class =\"ChartSummaryPageHeader\" id=\"CSHeader\">\n\t\t\t\t\t\t<div class=\"ChartSummaryHeaderCell\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderCont\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderTable ChartSummaryHeaderTableTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderIconCol\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\"><img src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/MenuIcon.png\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderTextCol\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderText ChartSummaryHeaderTextTheme\" data-role = \"none\">Clinical Events</div>\n\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t<div class=\"ChartSummaryHeaderEncRightCol\" data-role=\"none\" onclick=\"closeClinicalEvents()\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"closeClinicalEvents()\"><img src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/images/CS_Close16x16.png\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div id=\"ClinicalEvents\" class=\"divClinicalEventsContent divAllergyContentTheme\"  data-role=\"none\"> \n\t\t\t\t\t\t<div data-role=\"none\" class=\"ChartSummaryPageContent ChartSummaryPageContentTheme\" id=\"ChartSummaryPageContent\"  >\n\t\t\t\t\t\t\t<div data-role=\"none\" class=\"ChartSummaryPageContentCell\" >\n\t\t\t\t\t\t\t\t<div id=\"EventsSidePanel\"></div>\n\t\t\t\t\t\t\t\t<div id=\"EventsMainViewContent\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooter\"  id=\"CSFooter\">\n\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterCell\">\n\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterCont\">\n\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterTable ChartSummaryPageFooterTableTheme\">\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterRow\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterFirstCol\" ></div>\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openChartSummaryFrame()\">\n\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">Chart Summary</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n                                            <div data-role=\"none\" class=\"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openClinicalNotes()\">\n                                                <!-- openClinicalNotes() -->\n                                                <div data-role=\"none\" class=\"ChartSummaryPageFooterText\">Clinical Notes</div>\n                                            </div>\n                                            <div data-role=\"none\" class=\"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openOrdersFrame()\">\n                                                <div data-role=\"none\" class=\"ChartSummaryPageFooterText\">Order</div>\n                                            </div>\n                                            <div data-role=\"none\" class=\"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnSelTheme\" onclick=\"openClinicalEvents()\">\n                                                <div data-role=\"none\" class=\"ChartSummaryPageFooterText\">Clinical Events</div>\n                                            </div>\n                                            <div data-role = \"none\" class = \"ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme\" onclick=\"openPharmacyOrders()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"ChartSummaryPageFooterText\">Pharmacy Order</div>\n\t\t\t\t\t\t\t\t\t</div>\n                                            <div data-role=\"none\" class=\"ChartSummaryPageFooterLastCol\"></div>\n                                        </div>\n                                    </div>\n                                </div>\n                            </div>\n                        </div>\n                        <input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" />\n                </div>\n            </form>\n        </div>\n    </div>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n    <script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/js/iscroll5/iscroll.js\"></script>  \t\t\n    <!-- <script src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/kendo.web.min.js\"></script> -->\n\t<script src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/kendo.all.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n    <script>\n\t\tvar path;\n\t\tvar CEMainScroll;\n\t\tvar setTimeFrame;\n\t\tvar encounterIDs = \"\";\n\t\tvar hideSFS=\"False\";\n\n        $(document).ready(function() {\n            path = $(\'#hdnPath\').val();\n            parent.setOnLoadContentPaneHeight();\n\n            $(\'#EventsSidePanel\').load(path + \'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventsPanel.jsp\');\n            $(\'#EventsMainViewContent\').load(path + \'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventsViewContent.jsp\');\n\n            $(document).on(\"click\", \"#SlideOpener\", function() {\n                $(\'#ChartSummaryBlock \').css(\"width\", \"calc(100% - 245px)\");\n                $(\'#ChartSummaryBlock \').css(\'float\', \'right\');\n\t\t\t\tif(hideSFS==\"False\")\n\t\t\t\t{\n\t\t\t\t\t$(\'#EventsSideSFS\').load(path + \'/mobile/ClinicalEventsSFSServlet\');\n\t\t\t\t\thideSFS=\"True\";\n\t\t\t\t}\n\t\t\t\n                $(\'#EventsSideSFS\').show();\n                $(\'#SlideOpener\').hide();\n                $(\'.eventsMainPanel\').hide();\n                $(\'.FilterOpenMsg\').css(\'display\', \'table\');\n                CEMainScroll.refresh();\n            });\n        });\n\n        function closeClinicalEvents() {\n            parent.closeChartSummary();\n        }\n\n        function openOrdersFrame() {\n\t\t\t$(\"#PageLoadingAnimation\").show();\n            window.location.replace(path + \"/mobile/charts/orders/MNewOrderServlet\");\n        }\n\n        function openChartSummaryFrame() {\n\t\t\t$(\"#PageLoadingAnimation\").show();\n            window.location.replace(path + \"/mobile/chartsummary/ChartWidgetsView\");\n        }\n\n\t\tfunction openClinicalEvents() {\t\t\t\n\t\t\t$(\"#PageLoadingAnimation\").show();\n\t\t\twindow.parent.$(\'#hdnopeningPage\').val(\'clinicalEvents\');\n\t\t\twindow.parent.$(\"#ChartsBaseForm\").submit();\n\t\t}\n\t\t\n\t\tfunction openClinicalNotes() {\n            $(\"#PageLoadingAnimation\").show();\n            window.location.replace(path+\"/mobile/charts/notes/OpenClinicalNoteServlet\");\n        }\n\t\t\n\t\tfunction openPharmacyOrders(){\n\t\t\t$(\"#PageLoadingAnimation\").show();\n\t\t\tparent.openPharmacyOrders();\n\t\t}\n\n        function changeOrientation(orient, EMHFheight) {\n            var CSHFheight = $(\'#CSHeader\').height() + $(\'#CSFooter\').height();\n            var content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight - 10; //margin 5px\n            $(\"#ChartSummaryMainWrapper\").css(\"height\", content_height + \'px\');\n            $(\'.eventsSidePanel,.FilterOpenMsg\').css(\"height\", content_height + \'px\');\n            $(\'#datePanelWrap\').css(\"height\", (content_height - 50) + \'px\');\n\t\t    $(\'.noEventsMsgDisplay\').css(\"height\", (content_height - 25) + \'px\');\n\t\t    $(\'.noEventsMsgDisplay\').css(\"line-height\", (content_height - 25) + \'px\');\n        }\n    \n\t    function EncountersInRange(finalStartDate, finalEndDate,arrPC,arrHT) {\n            $(\'div[id^=\"SLSfsTickEN\"]\').hide();\n\t        $(\'div[id^=\"SLSfsTickPC\"]\').hide();\n\t        $(\"#listPC\").find(\".listItemPC\").show();\t\t\t\n\t        $(\'div[id^=\"SLSfsTickHT\"]\').hide();\n\t        $(\"#listHT\").find(\".listItemHT\").show();\n\t        var arrPCval=\"\";\n\t        var arrHTval=\"\";\n\t        if(arrPC.length>0) arrPCval=arrPC[0];\n\t        if(arrHT.length>0) arrHTval=arrHT[0];\n\t        loadClinicalEvents(\'\', finalStartDate ,finalEndDate,arrPCval,arrHTval);\n        }\n\n        function loadClinicalEvents(encounterIds, finalStartDate, finalEndDate,patientClass,historyType) {\n\t        var  startDate=\"\";\n\t        var  endDate=\"\";\t\t\n\t        if(finalStartDate!=\"\" && finalStartDate!=undefined){\t\n\t\t      finalStartDate=finalStartDate.split(\"-\");\t\n\t\t      finalEndDate=finalEndDate.split(\"-\");\t\n\t\t      startDate=finalStartDate[2]+\"/\"+finalStartDate[1]+\"/\"+ finalStartDate[0];\n\t\t      endDate=finalEndDate[2]+\"/\"+finalEndDate[1]+\"/\"+ finalEndDate[0];\n\t        }\t\n\t\n\t        $(\'#EventsSidePanel\').load(path + \'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventsPanel.jsp\',{\"encounterIds\": encounterIds,\"startDate\": startDate,\"endDate\": endDate,\"patientClass\": patientClass,\"historyType\": historyType},function(){\t\t\n              $(\".listItemPC\").hide();\t\n\t          var patClassSFSSel =$(\'#patClass\').val();\n\t          if(patClassSFSSel !=\'null\' && patClassSFSSel !=\"\"){\n                var eventPatClass = patClassSFSSel.split(\",\");\n                $.each( eventPatClass, function( index, value ){\n                  $(\"#PC_\"+value).show();\n                });\n\t          }\n\t          $(\".listItemHT\").hide();\n\t          var eventTypeSFSSel =$(\'#eventType\').val();\n\t          if(eventTypeSFSSel !=\'null\' && eventTypeSFSSel !=\"\"){\n                var eventPatType = eventTypeSFSSel.split(\",\");\n                $.each( eventPatType, function( index, value ){\n                  $(\"#HT_\"+value).show();\n                });\n                $(\"#dataHT\").show();\n              }else{\n\t\t        $(\"#dataHT\").hide();\n\t\t      }\n            });   \n        }\n\n        function clinicalEventsFilter(st,en,arrHT, arrPC) {\t    \n\t        var listItemHT=[];\n\n\t        if(arrPC.length>0){\n\t\t      $(\'.EventsSideSFS\').find(\".listItemPC[data-speccode]\").hide();\n\t\t      var MatchedValues = \"[data-speccode=\'\"+arrPC[0]+\"\']\";\n\t\t      $(\'.EventsSideSFS\').find(\".listItemPC\" + MatchedValues).show();\n\t\t    }\n\t        else{\n\t\t\t  $(\'.EventsSideSFS\').find(\".listItemPC[data-speccode]\").show();\n\t\t\t}\n\t\t   \n\t\t    if(arrHT.length>0){\n\t\t      $(\'.EventsSideSFS\').find(\".listItemHT[data-speccode]\").hide();\n\t\t      var MatchedValues = \"[data-speccode=\'\"+arrHT[0]+\"\']\";\t\t\n\t\t      $(\'.EventsSideSFS\').find(\".listItemHT\" + MatchedValues).show();\n\t        }\n\t        else{\t\t\n\t\t      $(\'.EventsSideSFS\').find(\".listItemHT[data-speccode]\").show();\n\t        }\n\t\n\t        $(\".listItemHT:visible\").each(function (i,v){\t\n\t\t\t  listItemHT.push($(this).attr(\'data-speccode\'));\n\t        });\n\t        var arrPCval=\"\";\n\t        var arrHTval=\"\";\n\t        if(arrPC.length>0) arrPCval=arrPC[0];\n\t        if(arrHT.length>0) arrHTval=arrHT[0];\n\t        loadClinicalEvents(encounterIDs, st, en,arrPCval,arrHTval);\n\t\t}\n\n        function chooseEncounterFilter(encounterID, openingPages) {\n\t        if ($(\"#contentPC\").is(\":visible\"))\t\n\t\t       CNFilterSectionToggle(\'PC\');\n\t\n\t        if ($(\"#contentHT\" ).is(\":visible\"))\t\n\t\t       CNFilterSectionToggle(\'HT\');\n\t\t\n\t        $(\'div[id^=\"SLSfsTickPC\"]\').hide();\n\t        $(\"#listPC\").find(\".listItemPC\").show();\n\t        arrPC.length=0;\n\t        $(\'div[id^=\"SLSfsTickHT\"]\').hide();\n\t        $(\"#listHT\").find(\".listItemHT\").show();\n\t        arrHT.length=0;\t\n\n\t        var encIDs = $(\'#hdnEncIDs\').val().split(\",\");\n            encounterIDs = \"\";\n            if ($(\"#SLSfsTickEN\" + encounterID).is(\":visible\")) {\n               if ($(\'#contentEC .listItemEC\').length == 1) {\n                  return;\n               }\n               $(\"#SLSfsTickEN\" + encounterID).hide();\n            } \n\t\t\telse {\n              //clearing notetype and ticks\t\t\t \n              $(\"#AfterSelectionNT\").html(\'\');\n              $(\'.searchByNotes\').removeClass(\"enableSearch\");\n              $(\"#SLSfsTickEN\" + encounterID).show();\n            }\n\n            for (var i = 0; i < encIDs.length - 1; i++) {\n              if ($(\"#SLSfsTickEN\" + encIDs[i]).is(\":visible\")) {\n                 encounterIDs = encounterIDs + encIDs[i] + \",\";\n              }\n            }\n            encounterIDs = encounterIDs.slice(0, -1);\t\n\t        var arrPCval=\"\";\n\t        var arrHTval=\"\";\n\t        if(arrPC.length>0) arrPCval=arrPC[0];\n\t        if(arrHT.length>0) arrHTval=arrHT[0];\n\t        $(\"#SelectedhdnEncIDs\").val(encounterIDs);\n\n\t        loadClinicalEvents(encounterIDs, \"\", \"\",arrPCval,arrHTval);\n            parent.setTimeFrame();\n        }\n    </script>\n    </body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
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
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
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
