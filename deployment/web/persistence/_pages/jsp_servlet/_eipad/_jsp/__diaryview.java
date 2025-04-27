package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public final class __diaryview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/DiaryView.jsp", 1738426027007L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n<!DOCTYPE html>\n<html>\n<head>\n\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\"\n\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<!-- <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  -->\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>-->\n<!--  -->\n<link href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/css/DiaryView.css\" type=\"text/css\" rel=\"stylesheet\" />\n<link href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/DiaryViewThemeA.css\" type=\"text/css\" rel=\"stylesheet\" />\n\n  \n<script src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jquery.mobile-1.0a4.1.min.js\"></script>  \n\n<script src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/js/weekWidget.js\"></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/js/iscroll5/iscroll.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/kendo.web.min.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/css/kendo.common.min.css\" type=\"text/css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/css/kendo.default.min.css\" type=\"text/css\" />\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12_0 ="\n<!-- <script type=\"application/javascript\" src=\"../js/DiaryView.js\"></script> -->\n\n<script type=\"text/javascript\">\nvar path;\nvar currentWeek;\nvar firstDate;\nvar firstDay;\nvar currMonth;\nvar month;\nvar year;\nvar startDate;\nvar lastDay;\nvar endDate;\nvar hdnOrderBy = \"null\";\n\nfunction openCal(){\n\tvar calDatePicker = $(\"#date_picker\").data(\"kendoDatePicker\");\n\tcalDatePicker.open();\n}\nfunction twoDigitString(num){\n\tif(num<10) return \"0\"+num;\n\telse return \"\"+num;\n}\nfunction StringToDate(string){\n\tvar d = new Date();\n\t//var str=\'01/07/2013 11:18:13\';\n\tvar datenum,month,year;\n\tvar hr=0, min=0, sec=0;\n\tvar datetimearr = string.split(\" \");\n\tif(datetimearr[0]){\n\t\tvar datearr = datetimearr[0].split(\"/\");\n\t\tif(datearr[0])\n\t\t\tdatenum = parseInt(datearr[0]);\n\t\tif(datearr[1])\n\t\t\tmonth = parseInt(datearr[1]);\n\t\tif(datearr[2])\n\t\t\tyear = parseInt(datearr[2]);\n\t}\n\tif(datetimearr[1]){\n\t\tvar timearr = datetimearr[1].split(\":\");\n\t\tif(timearr[0])\n\t\t\thr = parseInt(timearr[0]);\n\t\tif(timearr[1])\n\t\t\tmin = parseInt(timearr[1]);\n\t\tif(timearr[2])\n\t\t\tsec = parseInt(timearr[2]);\n\t}\n\t\n\td.setDate(datenum);\n\td.setMonth(month-1);\n\td.setFullYear(year);\n\t//if(hr!=0)\n\td.setHours(hr);\n\t//if(min!=0)\n\td.setMinutes(min);\n\t//if(sec!=0)\n\td.setSeconds(sec);\n\treturn d;\n}\n\nfunction loadDate() {\n\tcurrentWeek = $(\'#calender\').data(\"currentWeek\");\n\ttodayWeekNo = currentWeek.todayWeekNo;\n\tcurrentWeekNo = currentWeek.currentWeekNo;\n\tfirstDay = currentWeek.firstDay;\n\tfirstDate = firstDay.getDate();\n\tcurrMonth = currentWeek.currentMonth;\n\tmonth = currMonth + 1;\n\tyear = currentWeek.currentYear;\n\tstartDate = firstDate + \'/\' + month + \'/\' + year;\n\tlastDay = currentWeek.seventhDay;\n\tlastDate = lastDay.getDate();\n\tif ((lastDate < 7) && (month <12)) {\n\t\tmonth = currMonth + 2;\n\t}\n\telse\n\t\tif((lastDate < 7) && (month==12)){\n\t\tmonth = 01;\n\t\tyear = year +1;\n\t}\n\tendDate = lastDate + \'/\' + month + \'/\' + year;\n\t$(\"#DiarViewFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\n $(\"#DiarViewFrame\").load(path + \"/eIPAD/jsp/DiaryViewDetail.jsp?startDate=\"+ startDate + \"&endDate=\" + endDate+ \"&hdnOrderBy=\" + hdnOrderBy);\n\n\n}\n\nfunction openDiaryViewDetail() {\n\tloadDate();\n}\n\n$(document).ready(\n\t\tfunction() {\n\t\t\tparent.removeSpinner();\n\t\t\tparent.setIframeHeight();\n\t\t\tpath = $(\'#hdnPath\').val();\n\t\t\tvar serverDateFetched = StringToDate($(\"#hdnServerDate\").val());\n\t\t\t$(\'#calender\').weekWidget({\n\t\t\t\tcallBackForNext : openDiaryViewDetail,\n\t\t\t\tcallBackForPrev : openDiaryViewDetail,\n\t\t\t\tcallBackForToday : openDiaryViewDetail,\n\t\t\t\tcallBackForSelect : scrollToDatePosition,\n\t\t\t\tserverDate : serverDateFetched\n\t\t\t});\n\t\t\tloadDate();\n\t\t});\n\n\ndocument.addEventListener(\'touchmove\', function(e) {\n\te.preventDefault();\n}, false);\n\n//scroller func\n//variables for setting the content frame height according to the device\n//below values are header footer heights\n\nvar header_borderheight;\nvar content_height;\nvar scroller_height;\nvar date = new Date();\n\nvar scrollContent1;\n\nfunction scrollToDatePosition(){\n\tvar dateFetchFunc = $(\'#calender\').data(\'getDate\');\n\tvar selectedDate = $(\'#calender\').data(\'selectedDate\');\n\tvar dd = twoDigitString(selectedDate.getDate());\n\tvar mm = twoDigitString(selectedDate.getMonth()+1);\n\tvar yy = twoDigitString(selectedDate.getFullYear());\n\tvar formattedDate = dd+\"/\"+mm+\"/\"+yy;\n\tvar dateSeperatorElemId = $(\"[data-bookingdate=\'\"+formattedDate+\"\']\").attr(\'id\');\n\t\n\tif(scrollContent1){\n\t\tscrollContent1.scrollToElement(\"#\"+dateSeperatorElemId, 0);\n\t}\n\t\n\t\n}\nfunction loaded1() {\n\t \n\t setTimeout(function() {\n\t\tscrollContent1 = new iScroll(\'divcnt\',{\n\t\tonScrollEnd: function(e) {\n\t\t\t//alert(\'scroll end func is called\');\n\t\t\t\t\t\t  var dateChangeFunc = $(\'#calender\').data(\'setDate\');\n\t\t\t\t\t\t var scrolledDate;\n\t\t\t\t\t\t var headerSet = false;\n\t\t\t\t\t $.each($(\".dateSeperatorStart\"), function() { \n\t\t\t\t\t\t //alert(\'datechenge event is called\');\n\t\t\t\t\t\t var currentDateCount = parseInt($(this).data(\'datecount\'));\n\t\t\t\t\t\t var nextDateSeperator = $(\"[data-datecount=\'\"+(currentDateCount+1)+\"\']\");\n\t\t\t\t\t\t $(\"#testred\").html($(this).data(\'datecount\') + \"  ---- \" +nextDateSeperator.data(\"bookingdate\"));\n\t\t\t\t\t\t// alert(nextDateSeperator.offset().top);\n\t\t\t\t\t\t\n\t\t\t\t\t\tif($(this).offset().top - 160 <=  0 && !headerSet && nextDateSeperator.length && nextDateSeperator.offset().top - 160 >= 0){ //$(\"#DiaryHeader\").height() - $(\"#calender\").height()\n\t\t\t\t\t\t\t// alert(\'entered in if block\');\n\t\t\t\t\t\t $(\"#testred\").html(\"entered in if\");\n\t\t\t\t\t\t\t curDate =$(this).data(\'bookingdate\');\n\t\t\t\t\t\t\t scrolledDate = StringToDate(curDate);\n\t\t\t\t\t\t\t// alert(curDate);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t  //if (scrollContent1.y != scrollContent1.maxScrollY) \n\t\t\t\t\t\t\t \tdateChangeFunc(scrolledDate);\n\t\t\t\t\t\t\t//$(\"#testred\").html(\"--\"+$(this).offset().top+\" -- \"+scrolledDate); \n\t\t\t\t\t\t\t headerSet = true;\n\t\t\t\t\t\t\t //alert(\'scroll end event is called\');\n\t\t\t\t\t\t }\n\t\t\t\t\t\telse if($(this).offset().top - 160 <=  0 && !headerSet && !nextDateSeperator.length){\n\t\t\t\t\t\t\tcurDate =$(this).data(\'bookingdate\');\n\t\t\t\t\t\t\t scrolledDate = StringToDate(curDate);\n\t\t\t\t\t\t\t dateChangeFunc(scrolledDate);\n\t\t\t\t\t\t\t headerSet = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t });\n\t\t    },\n\t\t    bounce: false,\n\t\t    //momentum: false\n\t\t\tuseTransform: true,\n\t\t\tscrollY: true, \n\t\t\tscrollbars: true,\n\t\t\tinteractiveScrollbars: true\n\t\t});\n\t}, 100); \n\n}\nfunction addEmptyDiv() {\n\tif($(\".dateSeperatorStart\").length){\n\t\tvar lastDateSepPos = $(\".dateSeperatorStart:last\").offset().top;\n\t\tvar emptyAreaPos = $(\"#EmptyScrollArea\").offset().top;\n\t\tvar wrapperHeight = $(\"#divcnt\").height();\n\t\tif((emptyAreaPos - lastDateSepPos) < wrapperHeight){\n\t\t\tvar emptyAreaHeight = wrapperHeight - (emptyAreaPos - lastDateSepPos);\n\t\t\t$(\"#EmptyScrollArea\").css(\"height\", emptyAreaHeight+\"px\");\n\t\t}\n\t}\n\tif(scrollContent1){\n\t\t//alert(\"scroller getting destroyed\");\n\t\tscrollContent1.destroy();\n\t\tscrollContent1 = null;\n\t}\n\tloaded1();\n\tif(scrollContent1){\n\t\tscrollContent1.refresh();\n\t\tscrollContent1.scrollTo(0,0,0);\n\t}\n}\ndocument.addEventListener(\'touchmove\', function(e) {\n\te.preventDefault();\n}, false);\n\n//document.addEventListener(\'DOMContentLoaded\', loaded1, false);\n\nfunction changeOrientation(orient, HFheight) {\n\t//here the heights of the diary view contents frame and the height of the scrolling portion are set\n\theader_borderheight = $(\"#DiaryHeader\").height()+$(\"#calender\").height();\n\tdiary_headerHeight = $(\"#DiaryHeader\").height();\n\tcontent_height = parent.getTotalPageDivHeight() - diary_headerHeight - HFheight - 5; //5px bottom margin\n\tscroller_height = parent.getTotalPageDivHeight() - header_borderheight - HFheight - 5; //5px bottom margin\n\tdocument.getElementById(\"divcnt\").style.height = scroller_height + \"px\";\n\tdocument.getElementById(\"DiaryViewContents\").style.height = content_height + \"px\";\n\tif(scrollContent1)\n\t\tscrollContent1.refresh();\n\taddEmptyDiv();\n//\t(typeof scrollContent1.refresh === \"function\" ) || scrollContent1.refresh();\n}\nvar i =0;\nvar j=0;\nfunction fnOrderBy(orderByVal) {\n\t hdnOrderBy = orderByVal; \n\t\n\tif(orderByVal == \"\" || orderByVal == \"null\"){\n    \t$(\'#orderByNone\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    \t$(\'#orderByOP\').removeClass(\'WidgetFilterButtonSelTheme\').addClass(\'WidgetFilterButtonTheme\');\n    \t$(\'#orderByOT\').removeClass(\'WidgetFilterButtonSelTheme\').addClass(\'WidgetFilterButtonTheme\');\n\t\t$(\"#DiarViewFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\n    \t$(\"#DiarViewFrame\").load(path + \"/eIPAD/jsp/DiaryViewDetail.jsp?startDate=\" + startDate + \"&endDate=\" + endDate + \"&hdnOrderBy=\" + orderByVal);\n\n\t}\n     if(orderByVal == \"OP\"){\n       \t if(i == 0)\n    \t\t {\n    \t\t$(\'#orderByOP\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    \t\t$(\'#orderByNone\').removeClass(\'WidgetFilterButtonSelTheme\').addClass(\'WidgetFilterButtonTheme\');\n    \t\t$(\'#orderByOT\').removeClass(\'WidgetFilterButtonSelTheme\').addClass(\'WidgetFilterButtonTheme\');\n\t\t\t$(\"#DiarViewFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\n    \t\t$(\"#DiarViewFrame\").load(path + \"/eIPAD/jsp/DiaryViewDetail.jsp?startDate=\" + startDate + \"&endDate=\" + endDate + \"&hdnOrderBy=\" + orderByVal); \n    \t\ti=1;\n       \t\t }\n    \t else \n    \t\t if( i == 1)\n    \t\t {\n    \t\t orderByVal = null;\n    \t\t $(\'#orderByNone\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    \t\t $(\'#orderByOP\').removeClass(\'WidgetFilterButtonSelTheme\').addClass(\'WidgetFilterButtonTheme\');\n    \t\t $(\'#orderByOT\').removeClass(\'WidgetFilterButtonSelTheme\').addClass(\'WidgetFilterButtonTheme\');\n\t\t\t $(\"#DiarViewFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\n    \t\t $(\"#DiarViewFrame\").load(path + \"/eIPAD/jsp/DiaryViewDetail.jsp?startDate=\" + startDate + \"&endDate=\" + endDate + \"&hdnOrderBy=\" + orderByVal);\n    \t\t i=0;\n    \t\t }\n\t}\n    \t if(orderByVal == \"OT\"){\n    \t\t if(j == 0)\n    \t\t\t {\n    \t\t\t\t$(\'#orderByOT\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    \t\t\t\t$(\'#orderByNone\').removeClass(\'WidgetFilterButtonSelTheme\').addClass(\'WidgetFilterButtonTheme\');\n    \t\t\t\t$(\'#orderByOP\').removeClass(\'WidgetFilterButtonSelTheme\').addClass(\'WidgetFilterButtonTheme\');\n\t\t\t\t\t$(\"#DiarViewFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\n    \t\t\t\t$(\"#DiarViewFrame\").load(path + \"/eIPAD/jsp/DiaryViewDetail.jsp?startDate=\" + startDate + \"&endDate=\" + endDate + \"&hdnOrderBy=\" + orderByVal);\n    \t\t\t\tj=1;\n    \t\t\t }\n    \t\t else \n    \t\t\t if(j == 1)\n    \t\t\t\t {\n    \t\t\t\t orderByVal = null;\n    \t    \t\t $(\'#orderByNone\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    \t    \t\t $(\'#orderByOP\').removeClass(\'WidgetFilterButtonSelTheme\').addClass(\'WidgetFilterButtonTheme\');\n    \t    \t\t $(\'#orderByOT\').removeClass(\'WidgetFilterButtonSelTheme\').addClass(\'WidgetFilterButtonTheme\');\n\t\t\t\t\t $(\"#DiarViewFrame\").append(\"<div class=\'loadingCartItem\'></div>\");\n    \t    \t\t $(\"#DiarViewFrame\").load(path + \"/eIPAD/jsp/DiaryViewDetail.jsp?startDate=\" + startDate + \"&endDate=\" + endDate + \"&hdnOrderBy=\" + orderByVal);\n    \t    \t\t j=0;\n    \t\t\t\t }\n\t}\n    \t\n}\n\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<style>\n.Cal_Top{\n\t-webkit-tap-highlight-color: rgba(0,0,0,0);\n}\n</style>\n\n</head>\n<body>\n\t<div data-role=\"page\" class=\"ipListParent\"\n\t\tstyle=\"padding: 0px; width: 100%; height: 100%;\">\n\n\t\t<form style=\"width: 100%; height: 100%\">\n\n\n\t\t\t<!-- Added for header  -->\n\n\t\t\t<div class=\"diaryHeader\" id=\"DiaryHeader\">\n\t\t\t\t<div class=\"ipHeaderMenuContainer1 ipHeaderMenuContainer1Theme\">\n\t\t\t\t\t<table style=\"height: 100%; width: 100%\" cellpadding=\"0\"\n\t\t\t\t\t\tcellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t\t\t\t<td style=\"width: 50px; padding-left: 5px;\">\n\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" onclick=\"parent.toggleMenu()\">\n\t\t\t\t\t\t\t\t\t<img src=\"../images/MenuIcon.png\" />";
    private final static byte[]  _wl_block12_0Bytes = _getBytes( _wl_block12_0 );

    private final static java.lang.String  _wl_block12_1 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td style=\"width: auto\">\n\t\t\t\t\t\t\t\t<div class=\"ipHeaderPageTitle ipHeaderPageTitleTheme\">My Diary</div>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td style=\"width: 50%; padding-right: 10px;\" align=\"right\"\n\t\t\t\t\t\t\t\tvalign=\"center\">\n\t\t\t\t\t\t\t\t<table\n\t\t\t\t\t\t\t\t\tclass=\"ipContentHolderIconContainer WidgetFilterContTheme\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'null\')\"  id=\"orderByNone\"> <img src=\"../images/view01.png\"style=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'OP\')\" id=\"orderByOP\">  <img src=\"../images/OP_icon.png\" style=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'OT\')\" id=\"orderByOT\"> <img src=\"../images/OT.png\" style=\"vertical-align: middle;\" /></td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</div>\n\n\t\t\t<div class=\"content divIPcontent divIPcontentTheme\" id=\"DiaryViewContents\" style=\"overflow:hidden;min-height:100px\">\n\t\t\t\t<div class=\"background Diary_Main\">\n\t\t\t\t\t<div class=\"background Diary_Left\">\n\t\t\t\t\t\t<div class=\"left_block Diary_Left\"></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"background Diary_Right\">\n\t\t\t\t\t\t<div class=\"right_block DiaryRight Diary_Right\">\n\t\t\t\t\t\t\t<div class=\"content\">\n\t\t\t\t\t\t\t\t<div class=\"top_block D_Right_Top\"></div>\n\t\t\t\t\t\t\t\t<div class=\"top_block D_Right_Cen\"></div>\n\t\t\t\t\t\t\t\t<div class=\"bottom_block D_Right_Bottom\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"background Diary_Content\">\n\t\t\t\t\t\t<div class=\"background Diary_Msg_Box\">\n\t\t\t\t\t\t\t<div class=\"center_block Diary_Msg_Box\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<div id=\"calender\" class=\"TopCal_Strip\"></div>\n\t\t\t\t\t\t\t\t<div id=\"divcnt\" style=\"overflow: hidden; position: relative;\">\n\t\t\t\t\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"DiarViewFrame\" style=\"width: 100%; height: 100%\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\n\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block12_1Bytes = _getBytes( _wl_block12_1 );

    private final static java.lang.String  _wl_block13 ="\" />\n\t\t\t<input type=\"hidden\" name=\"startDate\" id=\"startDate\" id=\"hdnStartDate\"\n\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \" /> <input type=\"hidden\" name=\"endDate\" id=\"endDate\"\n\t\t\t\tid=\"hdnEndDate\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" /> <input type=\"hidden\"\n\t\t\t\tname=\"hdnOrderBy\" id=\"hdnOrderBy\" id=\"hdnOrderBy\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" />\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<!-- <input type=\"hidden\" name=\"hdnServerDate\" id=\"hdnServerDate\" id=\"hdnServerDate\" value=\"19/09/2014\" /> -->\n\t\t\t<input type=\"hidden\" name=\"hdnServerDate\" id=\"hdnServerDate\" id=\"hdnServerDate\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" />\n\t\t<!--  <div id=\"testred\" style=\"position:fixed;bottom:0px;right:0px;background:red;height:30px;width:300px\"></div> --> \n\t\t</form>\n\t\t\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12_0Bytes, _wl_block12_0);
            _bw.write(_wl_block12_1Bytes, _wl_block12_1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ startDate}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ endDate}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ hdnOrderBy}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
SimpleDateFormat weekWidgetFormat = new SimpleDateFormat("dd/MM/yyyy"); 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(weekWidgetFormat.format(new Date())));
            _bw.write(_wl_block18Bytes, _wl_block18);
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
