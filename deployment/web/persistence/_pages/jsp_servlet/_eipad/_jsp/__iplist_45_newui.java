package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.google.gson.Gson;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __iplist_45_newui extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/IPList-newUI.jsp", 1738426043837L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1_0 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>IP View</title> \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<!-- <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> -->\n\n\n<link rel=\"stylesheet\" href=\"../css/iPadNew_IP.css\" />  \n<link rel=\"stylesheet\" href=\"../css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" />  \n<script src=\"../jquery-1.9.1.min.js\"></script>  \n\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script> -->\n<script type=\"application/javascript\" src=\"../js/iscroll.js\"></script>\n\n\n<script type=\"text/javascript\">\n//variables for setting the content frame height according to the device\n//below values are header footer heights\n\n\n\n//parent.removeSpinner();\n//var legendsScroll ;\nfunction loaderInd() {\n\tsetTimeout(function () {\n\t\t parent.legendsScroll = new iScroll(\'legendWrapper\');\n\t}, 100);\n\t\n} \n\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\ndocument.addEventListener(\'DOMContentLoaded\', loaderInd, false);\n\n\n\nvar header_borderheight= 90;\nvar content_height;\n\nvar scrollContent1 ;\nvar scrollNav;\nvar ArrayOfPats=[];\nvar ArrayOfEncounter=[];\n\nfunction loaded1() {\n\t//scrollContent1 = new iScroll(\'divcnt\');\n\t//scrollNav = new iScroll(\'contentWrapper2\');\n\tsetTimeout(function () {\n\t\tparent.scrollContent1 = new iScroll(\'divcnt\');\n\t}, 100);\n\t}\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\ndocument.addEventListener(\'DOMContentLoaded\', loaded1, false);\n\nvar indicatorTypeScroll;\n\n $(document).ready(function () {\n\t var ipCount =  document.getElementById(\"hdnIPCount\").value;\n\t parent.updateIPCount(ipCount);\n\t //click, long press and swipe events of patient list are managed in below code\n\tvar pressTimer;\n\tvar ua = navigator.userAgent,\n    evnt = (ua.match(/iPad/i)) ? \"touchstart\" : \"click\";\n\t$(\".IPContentTableTheme\").bind(evnt,function(event){\n\t\tvar swipeEvent=false;\n\t\tpressTimer = window.setTimeout(function() {\n\t\t\t  //this is a tap-hold\n\t\t$(\'#RecordConsentQAItem\').hide();\n\t\tvar  patientId =$(event.currentTarget).attr(\"data-patientid\");\t\n\t\t$(\"#lpPatientId\").val(patientId);\n\t\tif($(\'#Consent_\'+patientId).is(\":visible\")){\n\t\t\t$(\'#RecordConsentQAItem\').show();\n\t\t}\n\t\t$(\"#navTypeModal\").show();\n\t\tvar  episodeId =$( event.currentTarget ).attr(\"data-episodeId\");\n\t\t$(\"#lpEpisodeId\").val(episodeId);\n\t\tvar  admDateTime =$( event.currentTarget ).attr(\"data-admDateTime\");\n\t\t$(\"#lpAdmDateTime\").val(admDateTime);\n\t\tvar  dischargeDateTime =$( event.currentTarget ).attr(\"data-dischargeDateTime\");\n\t\t$(\"#lpDischargeDateTime\").val(dischargeDateTime);\n\t\tvar  locationType =$( event.currentTarget ).attr(\"data-locationType\");\n\t\t$(\"#lplocationType\").val(locationType);\n\t\tvar  locationCode =$( event.currentTarget ).attr(\"data-locationCode\");\n\t\t$(\"#lpLocationCode\").val(locationCode);\n\t\tvar  serviceCode =$( event.currentTarget ).attr(\"data-serviceCode\" );\n\t\t$(\"#lpServiceCode\").val(serviceCode);\t\t\n\t\tevent.preventDefault();\t\t\t\t\n\n\t\t$(\".navModal-content\").css(\'position\',\"absolute\");\n\t\t$(\".navModal-content\").css(\'top\',\"0\");\n\t\t$(\".navModal-content\").css(\'right\',\"0\");\n\t\t$(\".navModal-content\").css(\'left\',\"0\");\n\t\t$(\".navModal-content\").css(\'bottom\',\"0\");\n\t\t\t},750);\n\tif( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {\n\t\t\t\t\t\t//behaviour for end\n\t\t$(\".IPContentTableTheme\").bind(\"touchend\", function(e){\n\t\t\t\t\tclearTimeout(pressTimer);\n\t\t\t\t\tif(!swipeEvent){\n\t\t\t\t\t\t\n\t\t\t\t\tvar  patientId =$(event.currentTarget).attr(\"data-patientid\");\t\n\t\t\t\t\t$(\"#lpPatientId\").val(patientId);\n\t\t\t\t\tvar  episodeId =$( event.currentTarget ).attr(\"data-episodeId\");\n\t\t\t\t\t$(\"#lpEpisodeId\").val(episodeId);\n\t\t\t\t\tvar  admDateTime =$( event.currentTarget ).attr(\"data-admDateTime\");\n\t\t\t\t\t$(\"#lpAdmDateTime\").val(admDateTime);\n\t\t\t\t\tvar  dischargeDateTime =$( event.currentTarget ).attr(\"data-dischargeDateTime\");\n\t\t\t\t\t$(\"#lpDischargeDateTime\").val(dischargeDateTime);\n\t\t\t\t\tvar  locationType =$( event.currentTarget ).attr(\"data-locationType\");\n\t\t\t\t\t$(\"#lplocationType\").val(locationType);\n\t\t\t\t\tvar  locationCode =$( event.currentTarget ).attr(\"data-locationCode\");\n\t\t\t\t\t$(\"#lpLocationCode\").val(locationCode);\n\t\t\t\t\tvar  serviceCode =$( event.currentTarget ).attr(\"data-serviceCode\" );\n\t\t\t\t\t$(\"#lpServiceCode\").val(serviceCode);\n\t\t\t\t\t\n\t\t\t\t\tif ($(\'#navTypeModal\').css(\'display\') == \'none\') {\n\t\t\t\t\t\topenPatient(patientId,episodeId,admDateTime,dischargeDateTime,locationType,locationCode,serviceCode)\n\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\n\t\t\t\t\tevent.preventDefault();\n\t\t\t\t\t}\n\t\t  $(\".IPContentTableTheme\").off(\'touchend\');\n\t\t});\n\t\t//behaviour for  move\n\t\t$(\".IPContentTableTheme\").bind(\'touchmove\', function(e){\n\t\t\tswipeEvent = true;\n\t\t});\n\t}else{\n\t    $(\".IPContentTableTheme\").bind(\"mouseleave\", function () {\n            \t\tclearTimeout(pressTimer);\n\t\t\t\t\tvar  patientId =$(event.currentTarget).attr(\"data-patientid\");\t\n\t\t\t\t\t$(\"#lpPatientId\").val(patientId);\n\t\t\t\t\tvar  episodeId =$( event.currentTarget ).attr(\"data-episodeId\");\n\t\t\t\t\t$(\"#lpEpisodeId\").val(episodeId);\n\t\t\t\t\tvar  admDateTime =$( event.currentTarget ).attr(\"data-admDateTime\");\n\t\t\t\t\t$(\"#lpAdmDateTime\").val(admDateTime);\n\t\t\t\t\tvar  dischargeDateTime =$( event.currentTarget ).attr(\"data-dischargeDateTime\");\n\t\t\t\t\t$(\"#lpDischargeDateTime\").val(dischargeDateTime);\n\t\t\t\t\tvar  locationType =$( event.currentTarget ).attr(\"data-locationType\");\n\t\t\t\t\t$(\"#lplocationType\").val(locationType);\n\t\t\t\t\tvar  locationCode =$( event.currentTarget ).attr(\"data-locationCode\");\n\t\t\t\t\t$(\"#lpLocationCode\").val(locationCode);\n\t\t\t\t\tvar  serviceCode =$( event.currentTarget ).attr(\"data-serviceCode\" );\n\t\t\t\t\t$(\"#lpServiceCode\").val(serviceCode);\n\t\t\t\t\t\n\t\t\t\t\tif ($(\'#navTypeModal\').css(\'display\') == \'none\') {\n\t\t\t\t\t\topenPatient(patientId,episodeId,admDateTime,dischargeDateTime,locationType,locationCode,serviceCode)\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\tevent.preventDefault();\n        });\n\t}\n\t});\t\n\t $(\"#closePoPUp\").bind(evnt,function(e){\n\t\t $(\"#navTypeModal\").css(\"display\",\"none\");\n\t });\n\t \n\t$(\'#navTypeModal\').click(function (e) {\t\n    if ($(e.target).is(\"#navTypeModal\")) {\n        if ($(\'#navTypeModal\').is(\':visible\')) {\n            $(\'#navTypeModal\').hide();\n        }\n    }  \n    }); \n\t \n\t\n\t parent.setIframeHeight();\n\tvar currentOrderBy = document.getElementById(\"hdnOrderBy\").value;\n    if(currentOrderBy == \"\" || currentOrderBy == \"OR\")\n    \t$(\'#orderByNone\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    else if(currentOrderBy == \"patient_name\")\n    \t$(\'#orderByPatientName\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    else if(currentOrderBy == \"physician_name\")\n    \t$(\'#orderByPhysicianName\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    else if(currentOrderBy == \"bed_num\")\n    \t$(\'#orderByBedNum\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    \n    //submitting form when space or enter key is pressed in the patient id text box\n    $(\'#txtPatientId\').bind(\'keypress\', function(e) {\n        if (e.which == 32){//space bar\n            //alert(\'space\');\n        \tipFormSubmit();\n        }\n        if (e.which == 13){//enter key\n            //alert(\'enter\');\n        \tipFormSubmit();\n        }\n        \n\t});\n    \n    //------scroll----------\n    //sfsrelated code below\n    $(\"#btnsfs\").bind(\'touchstart\', function(event) { \n        // jQuery clones events, but only with a limited number of properties for perf reasons. Need the original event to get \'touches\' \n        var e = event.originalEvent;\n        var scrollStartPos =  e.touches[0].pageY;\n        scrollStartPos = scrollStartPos;\n        var tleft = e.touches[0].pageX - \"15\"\n         $(\"#sfs\").css(\'z-index\', \"1000\");\n         $(\"#sfsarrow\").css(\'z-index\',\"1000\");\n    }); \n });\n \n \n function changeOrientation(orient, HFheight)\n {\n \tcontent_height = parent.getTotalPageDivHeight() - header_borderheight - HFheight;\n\tdocument.getElementById(\"divcnt\").style.height = content_height+\"px\";\n\t\n\tif(parent.scrollContent1 != null)\n\tparent.scrollContent1.refresh();\n }\n\n function clearPatientIdText()\n {\n\t document.getElementById(\"txtPatientId\").value=\"\";\n\t document.getElementById(\"hdnPatientId\").value =\"\";\n }\n function toggleLegend(){\n\t\n\t $(\'#legendContainer\').toggle(); \n\t var totalWidth = 0;\n\t $(\'#legendScroller .legendTabs\').each(function(index) {\n     totalWidth += parseInt($(this).outerWidth());\n   \t});\n\t$(\'#legendScroller\').css(\"width\",(totalWidth+90)+\'px\');\n\t\n\tsetTimeout(function () {\n\t\tparent.legendsScroll.refresh();\n    }, 0);\t\n\t\n }\n function hideLegend(){\n\t $(\'#legendContainer\').hide(); \n }\n function openPatient(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode)\n {\n\t\n\t //window.parent.slidee(\"true\");\n\t\n\t//alert(patientid);\n\t//alert(\"hi\");\n\t//alert(episodeId);\n\twindow.parent.loadwidgets(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode);\n\t//document.getElementById(\"IpForm\").submit();\n\t//window.open(\"Appointment.html\");\n }\n function show(objBtn)\n {\n\t  //alert(\"hiii\");\n\t    var myBars = \'directories=no,location=no,menubar=no,status=no\' ;\n\t\tvar myOptions = \'width=\' + window.screen.availwidth + \', height=\' + window.screen.availheight + \', resizable=no, fullscreen=yes\' ;\n\t\t//var myFeatures = myBars + \', \' + myOptions ;\n\t\tvar myFeatures =  myOptions ;\n\t\t//var ecisWindow = open( \'iPadWidget.html\', \'iPadWidget.html\', myFeatures,false ) ;\n\t\t\n\t\t//var retval = window.showModalDialog(\"AppView.jsp\", \"\", myFeatures);\n\t\t//$.mobile.changePage(\'#Dialog\',{role:\'dialog\'})\n\t\t//$.mobile.changePage(\'#Dialog\',{role:\'dialog\',transition: \"pop\"})\n\t//\tdocument.getElementById(\"srchFrame\").src = \"appview.html\";\n    //   $.mobile.changePage(\"#Dialog\", \"slide\" , false,false);\n\t\t//alert(\"finished\");\n\t\tobjBtn.style.border = \"3px solid #48d1d8\";\n\t\tdocument.getElementById(\"hdnPatientId\").value = document.getElementById(\"txtPatientId\").value;\n\t\t document.getElementById(\"hdnNursingUnit\").value = \"\";\n\t\t document.getElementById(\"hdnClinicianId\").value = \"\";\n\t\t document.getElementById(\"hdnSpeciality\").value = \"\";\n\t\t//document.getElementById(\"hdnClinicianId\").value = document.getElementById(\"txtPracId\").value;\n\t\t//document.getElementById(\"hdnNursingUnit\").value = document.getElementById(\"txtNursingUnit\").value;\n\t\t//document.getElementById(\"hdnSpeciality\").value = document.getElementById(\"txtSpeciality\").value;\n\t\tdocument.getElementById(\"IpForm\").submit();\n\n\n }\n\n function ipFormSubmit()\n {\n\t //$.trim($(\"#hdnPatientId\").val($.trim($(\"#txtPatientId\").val())));\n\t //alert(document.getElementById(\"txtPatientId\").value.length);\n\t //var trimmedPatId= document.getElementById(\"txtP";
    private final static byte[]  _wl_block1_0Bytes = _getBytes( _wl_block1_0 );

    private final static java.lang.String  _wl_block1_1 ="atientId\").value.trim();\n\t //alert(trimmedPatId.length);\n\t document.getElementById(\"hdnPatientId\").value = document.getElementById(\"txtPatientId\").value;\n\t document.getElementById(\"IpForm\").submit();\n }\n\n\n function fnOrderBy(orderByVal)\n {\n\t//alert(orderByVal);\n\t document.getElementById(\"hdnOrderBy\").value = orderByVal;\n\t document.getElementById(\"IpForm\").submit();\n }\n\n function showsfs()\n {\n \n \tdocument.getElementById(\"sfsFrame\").src = \"IPSearch-newUI.jsp\";\n \t$(\"#sfs\").css(\'z-index\', \"1000\");\n \t$(\"#sfsarrow\").css(\'z-index\',\"1000\");\n \t$(\'#sfs\').toggle();\n \t$(\'#sfsarrow\').toggle();\n \n }\n\n\n \n function refresh(){\n\t document.getElementById(\"hdnOrderBy\").value = \"\";\n\t document.getElementById(\"hdnPatientId\").value = \"\";\n\t document.getElementById(\"hdnNursingUnit\").value = \"\";\n\t document.getElementById(\"hdnClinicianId\").value = \"\";\n\t document.getElementById(\"hdnSpeciality\").value = \"\";\n\t document.getElementById(\"IpForm\").submit();\n }\n function showNoRelationError(){\n\t parent.showErrorWindow(\'No Patient Practitioner Relationship exists\');\n }\n \n function action(navType){ \n\t $(\"#PageLoadingAnimation\").show();\n\t var patientid = $(\"#lpPatientId\").val();\n\t var episodeId = $(\"#lpEpisodeId\").val();\n\t var admitDate = $(\"#lpAdmDateTime\").val();\n\t var dischargeDateTime = $(\"#lpDischargeDateTime\").val();\n\t var locnType = $(\"#lplocationType\").val();\n\t var locnCode = $(\"#lpLocationCode\").val();\n\t var servicecode = $(\"#lpServiceCode\").val();\n\t window.parent.loadwidgets(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode,navType);\t \n\t} \n function slidesfsSearch(patientID){\n\n\t /* alert(patientID); */\n\t document.getElementById(\"hdnPatientId\").value = patientID;\n\t document.getElementById(\"hdnNursingUnit\").value = \"\";\n\t document.getElementById(\"hdnClinicianId\").value = \"\";\n\t document.getElementById(\"hdnSpeciality\").value = \"\";\n\t document.getElementById(\"IpForm\").submit();\n }\n function clearHdnPatientValue(){\n\t document.getElementById(\"hdnPatientId\").value = \"\";\n }\n function selectedPract(val, desc,  dPage){\n\t document.getElementById(\"hdnClinicianId\").value = val;\n\t document.getElementById(\"hdnSfsClinicianId\").value = val;\n\t window.parent.$(\"#SlideSfsFrame\").contents().find(\"#IpSearchForm\").append(\'<input type=\"hidden\" id=\"selectedPractID\" name=\"selectedPractID\" id=\"selectedPractID\" value=\"\'+val+\'\" />\');\n\t window.parent.$(\"#SlideSfsFrame\").contents().find(\"#IpSearchForm\").submit();\n\t window.parent.$(\"#SlideSfsFrame\").contents(). find(\"#slSfsTickPR\"+val).show();\n\t document.getElementById(\"IpForm\").submit();\n\t \n }\n \n function hideRows(arrSP,arrPR,arrNU){\n\tvar SPArray =[];\n\tvar NUArray =[];\n\t var totalCount = arrSP.length + arrPR.length + arrNU.length ;\n\t if(totalCount>0){\n\t  \trows = window.parent.$(\"#frameIP\").contents().find(\"#divcnt .IPContentTable1\").hide();\n\t  \tif(arrPR.length>0){\n\t\t\t for( var j =0;j<arrPR.length;j++){\n\t\t\t\t\tvar code = arrPR[j];\n\t\t\t\t\t$(\"[data-pract = \'\"+code+\"\']\").each(function (i,v ){\n\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\tparent.scrollContent1.refresh();\n\t\t\t\t\t});\n\t\t\t  }\n\t\t}\n\t\t\t\t  if(arrSP.length>0){\n\t\t\t\t\t for( var j =0;j<arrSP.length;j++){\n\t\t\t\t\t\tvar code = arrSP[j];\n\t\t\t\t\t\twindow.parent.$(\"#frameIP\").contents().find(\"[data-speccode = \'\"+code+\"\']\").show();\n\t\t\t\t\t\tparent.scrollContent1.refresh();\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t window.parent.$(\"#SlideSfsFrame\").contents().find(\".listItemNU[data-nursingunitcode]\").hide();\n\t\t\t\t window.parent.$(\"#frameIP\").contents().find(\".IPContentTable1\").each(function (i,v ){\n\t\t\t\t\t\t\t\tif($(this).is(\":visible\")){\n\t\t\t\t\t\t\t\t  var nCode =$(this).attr(\'data-nursingunitcode\');\n\t\t\t\t\t\t\t\t   NUArray.push(nCode);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t });\n\t\t\t\t window.parent.$(\"#SlideSfsFrame\").contents().find(\".listItemNU\").removeClass(\'filteredNU\');\n\t\t\t\tfor(var i=0; i<NUArray.length; i++){\n\t\t\t\t\t var code = NUArray[i];\n\t\t\t\t\twindow.parent.$(\"#SlideSfsFrame\").contents().find(\".listItemNU[data-nursingunitcode = \'\"+code+\"\']\").show().addClass(\'filteredNU\');\n\t\t\t\t}\n\t \t}\n\t  \telse{\n\t  \t\tif(arrNU.length>0){\n\t  \t\t\tparent.scrollContent1.refresh();\n\t  \t\t}\n\t  \t\telse{\n\t\t  \t\twindow.parent.$(\"#SlideSfsFrame\").contents().find(\".listItemNU\").show();\n\t\t  \t\twindow.parent.$(\"#SlideSfsFrame\").contents().find(\".listItemSP\").show();\n\t\t  \t\twindow.parent.$(\"#frameIP\").contents().find(\".IPContentTable1\").show();\n\t  \t\t}\n\t  \t}\n\t\t\t if(arrNU.length >0){\n\t\t\t\t\t for( var j =0;j<arrNU.length;j++){\n\t\t\t\t\t\t\tvar code = arrNU[j];\n\t\t\t\t\t\t\twindow.parent.$(\"#frameIP\").contents().find(\"[data-nursingunitcode = \'\"+code+\"\']\").show();\n\t\t\t\t\t\t\tparent.scrollContent1.refresh();\n\t\t\t\t\t  }\n\t\t\t\t \n\t\t\t\t\twindow.parent.$(\"#SlideSfsFrame\").contents().find(\".listItemSP[data-speccode]\").hide();\n\t\t\t\t\t window.parent.$(\"#frameIP\").contents().find(\".IPContentTable1\").each(function (i,v ){\n\t\t\t\t\t\t\t\t\tif($(this).is(\":visible\")){\n\t\t\t\t\t\t\t\t\t  var sCode =$(this).attr(\'data-speccode\');\n\t\t\t\t\t\t\t\t\t   SPArray.push(sCode);\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t });\n\t\t\t\t\t  window.parent.$(\"#SlideSfsFrame\").contents().find(\".listItemSP\").removeClass(\'filteredSP\');\n\t\t\t\t\tfor(var i=0; i<SPArray.length; i++){\n\t\t\t\t\t\t var code = SPArray[i];\n\t\t\t\t\t\twindow.parent.$(\"#SlideSfsFrame\").contents().find(\".listItemSP[data-speccode = \'\"+code+\"\']\").show().addClass(\'filteredSP\');;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t }\n\t\t\t if(arrSP.length>0 && arrNU.length>0){\n\t\t\t\t  window.parent.$(\"#frameIP\").contents().find(\".IPContentTable1\").hide();\n\t\t\t\t  window.parent.$(\"#frameIP\").contents().find(\"[data-speccode=\'\"+arrSP[0]+\"\'][data-nursingunitcode = \'\"+arrNU[0]+\"\']\").show(); \n\t\t\t\t  parent.scrollContent1.refresh();\n\t\t\t }\n\t\t \n\t }\n\t else if(totalCount==0){\n\t\trows= window.parent.$(\"#frameIP\").contents().find(\"#divcnt .IPContentTable1\").show();\n\t\t\t  window.parent.$(\"#SlideSfsFrame\").contents().find(\".listItemNU,.listItemSP\").show(); \n\t\t\t  parent.scrollContent1.refresh();\n\t\t }\n\tparent.removeSpinner();\n\t \n }\n function addSpinner(){\n\tvar a = $(\"#spinnerDiv\")\n\n\tif(a.length ==0)\n\t\t$(\"#divContent\").append(\"<div class=\'loadingCartItem\' id=\'spinnerDiv\'></div>\");\n}\nfunction removeSpinner(){\n\n\tvar a = $(\"#spinnerDiv\")\n\n\tif(a.length > 0)\n\t$(\"#spinnerDiv\").remove();\n}\n//Added by Subha-V20190403/KDAH-CRF-0517/Starts\nfunction openPatientTasksDiv(patientId,encounterId){\n\t$(\".overlayDivPatTasksClass\").hide();\n\t$(\".loadingPatientTasks\").hide();\n\t$(\"#OverlayDivPatTasks_\"+patientId).show();\n\t\n\t$(\"#loadingPatientTasks_\"+patientId).show();\n\tvar path = $(\"#hdnPath\").val();\n\tvar facilityId = $(\"#facilityId\").val();\n\tvar clinicianId = $(\"#clinicianId\").val();\n\tvar validationPath = path + \'/mobile/ip/InPatientTasksJSONServlet\';\n    $.getJSON(validationPath, {\n            patientId: patientId,\n            encounterId: encounterId,\n            facilityId: facilityId,\n            clinicianId: clinicianId,\n            requestMode: \'PATIENT_TASKS\'\n        })\n        .done(function(json) {\n            var result_chargeCons = json.chargeConsultationTask.taskPending;\n            $(\"#loadingPatientTasks_\"+patientId).hide();\n            if(result_chargeCons){\n            \t$(\"#ChargePatientBtn_\"+patientId).removeClass(\"imgGrayscale\");\n            \t$(\"#ChargePatientBtn_\"+patientId).attr(\'onClick\', \'chargePatient(this);\');\n            }else{\n            \t$(\"#ChargePatientBtn_\"+patientId).addClass(\"imgGrayscale\");\n            \t$(\"#ChargePatientBtn_\"+patientId).attr(\'onClick\', \'\');\n            }\n            //alert(result_chargeCons);\n        })\n        .fail(function(jqxhr, textStatus, error) {\n            var err = textStatus + \", \" + error;\n        });\n}\n\nfunction closePatientTasksDiv(patientId){\n\tif($(\"#OverlayDivPatTasks_\"+patientId).is(\":visible\")){\n\t\t$(\"#OverlayDivPatTasks_\"+patientId).hide();\n\t}\n}\n\nfunction chargePatient(btnObj){\n\tvar path = $(\"#hdnPath\").val();\n\tvar facilityId = $(\"#facilityId\").val();\n\tvar clinicianId = $(\"#clinicianId\").val();\n\tvar loginuserid = $(\"#loginuserid\").val();\n\tvar client_ip_address = $(\"#client_ip_address\").val();\n\tvar patientId = $(btnObj).data(\"patientid\");\n\tvar encounterId = $(btnObj).data(\"encounterid\");\n\tvar validationPath = path + \'/mobile/ip/InPatientTasksJSONServlet\';\n\t$(\"#loadingPatientTasks_\"+patientId).show();\n    $.getJSON(validationPath, {\n            patientId: patientId,\n            encounterId: encounterId,\n            facilityId: facilityId,\n            clinicianId: clinicianId,\n            loginuserid: loginuserid,\n            client_ip_address: client_ip_address,\n            requestMode: \'PATIENT_CHARGE\'\n        })\n        .done(function(json) {\n            $(\"#ChargePatientBtn_\"+patientId).addClass(\"imgGrayscale\");\n            $(\"#loadingPatientTasks_\"+patientId).hide();\n            var msg = json.errorsList[0].errorMessage;\n            if(msg) {\n            \tif(json.transactionResult == -1){\n            \t\tshowTransactionMessageFailed(msg);\n            \t}else{\n            \t\tshowTransactionMessageSuccess(msg);\n            \t}\n            }\n            else {\n            \tif(json.transactionResult == -1){\n            \t\tshowTransactionMessageFailed(\"Failed to Charge\");\n            \t}else{\n            \t\tshowTransactionMessageSuccess(\"Charged successfully\");\n            \t}\n            }\n            closePatientTasksDiv(patientId);\n        })\n        .fail(function(jqxhr, textStatus, error) {\n        \t\t$(\"#loadingPatientTasks_\"+patientId).hide();\n\t            var err = textStatus + \", \" + error;\n\t            console.log(err);\n\t            var errChargeMsg = json.errorsList[0].errorMessage;\n           \t\tif(errChargeMsg)\n            \t\tshowTransactionMessageFailed(errChargeMsg);\n            \telse\n            \t\tshowTransactionMessageFailed(\"Failed to Charge\");\n           \t\tclosePatientTasksDiv(patientId);\n        });\n}\n\nfunction showTransactionMessageSuccess(msg){\n\thideLegend();\n\t$(\"#transactionMsg\").removeClass(\"formValErrorTheme\").addClass(\"formValSuccessTheme\");\n\t$(\"#transactionMessageContent\").html(msg)\n\t$(\"#transactionMsg\").show();\n\tsetTimeout(function(){\n\t\t$(\"#transactionMsg\").hide();\n\t},5000);\n\t$(\"#transactionMsg\").bind(\'click\',function(){\n\t\t$(this).hide();\n\t});\n}\n\nfunction showTransactionMessageFailed(msg){\n\thideLegend();\n\t$(\"#transactionMsg\").removeClass(\"formValSuccessTheme\").addClass(\"formValErrorTheme\");\n\t$(\"#transactionMessageContent\").html(msg)\n\t$(\"#transactionMsg\").show();\n\tsetTimeout(function(){\n\t\t$(\"#transactionMsg\").hide();\n\t},5000);\n\t$(\"#transactionMsg\").bind(\'click\',function(){\n\t\t$(this).hide();\n\t});\n}\n//Added by Subha-V20190403/KDAH-CRF-0517/Ends\n </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n <style>\n #PageLoadingAnimation{\n\tz-index: 10000;\n\tposition: absolute;\n\tleft: 0px;\n\ttop: 0px;\n\twidth: 100%;\n\theight: 100%;\n\tbackground-color: #808080;\n\topacity: 0.6;\n\tbackground-image: url(";
    private final static byte[]  _wl_block1_1Bytes = _getBytes( _wl_block1_1 );

    private final static java.lang.String  _wl_block2 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\tdisplay: none; \n}\n.loadingCartItem {\n\twidth: 100%;\n\theight: 80px;\n\tbackground-image: url(";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n}\n.loadingPatientTasks {\n\twidth: 100%;\n\theight:100%;\n\tbackground:rgba(0,0,0,0.2);\n\tbackground-image: url(";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\t z-index: 99;\n\t position:absolute;\n\t display:none;\n}\n.ipContentMoreBtn{\n\tbackground-image: url(";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/images/more_vertical24x24.png);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n}\n.imgGrayscale {\n    -webkit-filter: grayscale(1);\n    opacity: 0.7;\n}\n.CSTransactionMessage{\n    \n    border-radius: 5px 5px 5px 5px;\n    /*box-shadow: 0 2px 2px 2px #D0D0D0;*/\n    height: 45px;\n    margin-top: 0;\n\topacity: 0.8; \n    position: absolute;\n    text-align: left;\n    width: 95%;\n    z-index: 100;\n}\n </style>\n </head>\n<body style= \"width:100%; height:100%;\"  >\n<div id=\"PageLoadingAnimation\" class=\"absoluteCenter\"></div>\n                        <div id=\"navTypeModal\" class=\"navModal\">\n\t\t\t\t\t\t           <div class=\"navModal-content\">\n\t\t\t\t\t\t                 <div class=\"navAccess\">QUICK ACCESS</div>\n\t\t\t\t\t\t                 <div class=\"navScroll\">\n                                          <div class=\"popTable navControl\" onclick=\"action(\'clinicalNotes\')\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellLab\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/ClinicalNote16x16.PNG\">\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellCont\">Clinical Notes</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellClick\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/Arrow_24x24.png\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t                        </div>\n\t\t\t\t\t                        \n\t\t\t\t\t                        <div class=\"popTable navControl\" onclick=\"action(\'placeOrder\')\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellLab\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/images/PlaceOrder16x16.PNG\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellCont\">Place Order</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellClick\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/images/Arrow_24x24.png\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t                        </div>\n\t\t\t\t\t                        \n\t\t\t\t\t                        <div class=\"popTable navControl\" onclick=\"action(\'recordConsent\')\" style=\"display:none\" id=\"RecordConsentQAItem\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellLab\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/Consent16x16.PNG\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellCont\">Record Consent</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellClick\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/Arrow_24x24.png\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t                        </div>\n\t\t\t\t\t                        \n\t\t\t\t\t                        <div class=\"popTable navControl\" onclick=\"action(\'clinicalEvents\')\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellLab\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/images/ClinicalEvent16x16.PNG\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellCont\">Clinical Events</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellClick\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/images/Arrow_24x24.png\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t                        </div>\n\t\t\t\t\t                        \n\t\t\t\t\t                        <div class=\"popTable navControl\" onclick=\"action(\'pharmacy\')\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellLab\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/images/Pharmacy_Quick16x16.PNG\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellCont\">Pharmacy Order</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"popTableRowCellClick\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/Arrow_24x24.png\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t                        </div>\n\t\t\t\t\t                        \n                                          </div>\n\t\t\t\t\t\t\t\t         <div class=\"navCancel\"  id=\"closePoPUp\"><div style=\"padding-right: 10px;\">CANCEL</div></div>   \n\t\t\t\t\t\t          </div>\n\t\t\t\t\t\t</div>  \n\t<div id = \"sfsarrow\" data-role = \"none\" class = \"sfs-bubble-arrow sfs-bubble-arrowIPTheme\" ></div>\n   \t<div data-role = \"none\" class = \"sfs sfsIPTheme\"  id = \"sfs\" >\n  \t \t<iframe id = \"sfsFrame\" frameborder=\"0\" style = \"display:block;\" scrolling =\"no\" height = \"300px\" width = \"340px\" src = \"IPSearch-newUI.jsp\"></iframe>  \n   \t</div> \n\t<div data-role = \"page\" class=\"ipListParent\" style = \"padding:0px;width:100%;height:100%;\">\n\t\t<form name=\'IpForm\' id=\'IpForm\' method=\'post\' id=\"IpForm\" style = \"width:100%;height:100%;\">\n\t\t\t<div class =\"ipHeader\">\n\t\t\t\t<div class=\"ipHeaderMenuContainer1 ipHeaderMenuContainer1Theme\">\n\t\t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t<td style = \"width:50px; padding-left:5px;\">\n\t\t\t        \t\t\t<div class = \"WidgetButtonTheme\" onclick=\"parent.toggleMenu()\"><img src = \"../images/MenuIcon.png\"/></div>\n\t\t\t   \t\t\t\t</td>\n\t\t\t    \t\t\t<td style = \"width:auto\">\n\t\t\t         \t\t\t<div class = \"ipHeaderPageTitle ipHeaderPageTitleTheme\"> In Patient</div>\n\t\t\t   \t\t\t\t</td>\n\t\t\t\t\t   \t\t<!--<td style = \"width:200px\">\n\t\t\t\t\t         \t\t<div class=\"ipHeaderSearchPatientText ipHeaderSearchPatientTextTheme\">\n\t\t\t\t\t         \t\t<table cellpadding = \"0\" cellspacing = \"0\" border = \"0\"><tr>\n\t\t\t\t\t\t\t\t   \t<td style=\"width:5%; padding-top:5px\"><img src=\"../images/Search.png\" onclick=\"show(this)\" style=\"margin-left:5px;\"/></td>\n\t\t\t\t\t\t\t\t    <td style=\"width:90%;\">\n\t\t\t\t\t\t\t\t        \t<input type=\"text\" name = \"txtPatientId\" id = \"txtPatientId\"  placeholder=\"Patient ID\" onchange=\"show(this)\" class=\"ipHeaderSearchPatientTxtBox ipHeaderSearchPatientTxtBoxTheme\" value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t   \t<td style=\"width:5%; padding-top:5px;padding-right:6px\"><img src=\"../images/Close-small.png\" style=\"padding-right: 10px\" onclick=\"clearPatientIdText()\"/></td>\n\t\t\t\t\t\t\t\t   \t</tr></table>\n\t\t\t\t\t\t\t\t   \t</div>\n\t\t\t\t\t   \t\t</td>\n\t\t\t\t\t\t\t<td style = \"width:50px; padding-left:5px;padding-right:5px;text-align:right\" onclick=\"showsfs()\">\n\t\t\t\t\t        \t<div class = \"WidgetButtonTheme\" id=\"btnsfs\" ><img src = \"../images/Search.png\" style=\"padding-top:5px;\"/></div>\n\t\t\t\t\t   \t\t</td>-->\n\t\t\t\t\t\t</tr>\n\t\t    \t\t</table>\n\t\t\t\t</div>\n\n\t  \t\t\t<div class = \"ipHeaderMenuContainer2\">\n\t  \t\t\t\t<div  data-role =\"none\" class =\"ipContentHolderHeader ipContentHolderHeaderTheme\">\n\t\t\t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  \t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t    <td style = \"width:10%\">\n\t\t\t\t\t\t\t         <span class = \"ipContentHolderRefreshIcon\"><img src = \"../images/Refresh_black.png\" onclick=\"refresh()\"/></span>\n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td></td>\n\t\t\t\t\t\t\t    <td style = \"width:50%;padding-right:10px;\" align = \"right\" valign = \"center\">\n\t\t\t\t\t\t\t    \t<table class= \"ipContentHolderIconContainer WidgetFilterContTheme\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t\t\t\t    <tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class = \"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'OR\')\" id=\"orderByNone\"><img src = \"../images/view01.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'bed_num\')\" id=\"orderByBedNum\"><img src = \"../images/ByBed.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'patient_name\')\" id=\"orderByPatientName\"><img src = \"../images/ByPatient.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'physician_name\')\" id=\"orderByPhysicianName\"><img src = \"../images/View03.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        </tr>\n\t\t\t\t\t\t        \t</table>\t\n\t\t\t\t\t\t    \t</td>\n\t\t\t \t\t\t\t</tr>\n\t\t    \t\t\t</table>\t  \n\t  \t\t\t\t</div>\n\t  \t\t\t</div>\n\t  \t\t</div>\n    \t\t<div id = \"divcnt\"  class = \"divIPcontent divIPcontentTheme\" style=\"overflow:hidden\">\n\t\t\t\t<div style = \"width:100%;height:auto;overflow:auto\" >\n\t\t\t\t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t  <div style=\"display:table;width:100%;position:relative\" class=\"IPContentTable1\" style=\"height:70px;max-height:110px;width:100%\" id=\"patientID";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" data-patientid=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" data-episodeId=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" data-admDateTime=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" data-dischargeDateTime=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" data-locationType=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" data-locationCode=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="  data-serviceCode=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  data-speccode=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"  data-nursingunitcode=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n\t\t\t\t  \t<div class=\"loadingPatientTasks\" id=\"loadingPatientTasks_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" ></div>\n\t\t\t\t  \t<div id=\"OverlayDivPatTasks_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" class=\"overlayDivPatTasksClass\" style=\"position:absolute; width:100%; height:100%;display:none;background:rgba(102,255,255,0.2)\" >\n\t\t\t\t  \t\t<div style=\"display:table;width:100%;height:100%\">\n\t\t\t\t  \t\t\t<div style=\"display:table-row\">\n\t\t\t\t  \t\t\t\t<div style=\"display:table-cell;width:90%\" onclick=\"closePatientTasksDiv(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\">\n\t\t\t\t  \t\t\t\n\t\t\t\t  \t\t\t\t</div>\n\t\t\t\t  \t\t\t\t<div style=\"display:table-cell;width:200px;\">\n\t\t\t\t  \t\t\t\t\t<div style=\"display:table;width:100%;height:100%\">\n\t\t\t\t  \t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t  \t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;width:100px\" >\n\t\t\t\t\t  \t\t\t\t\t\t\t<div style=\" height: 60px; width: 60px\" id=\"ChargePatientBtn_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" class=\"imgGrayscale\" data-patientid =\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' data-encounterid = \'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onclick=\"\">\n\t\t\t\t\t  \t\t\t\t\t\t\t\t<div style=\"\">\n\t\t\t\t\t  \t\t\t\t\t\t\t\t\t<img src=\"../images/invoice60x60.png\"/>\n\t\t\t\t\t  \t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t  \t\t\t\t\t\t\t</div>\n\t\t\t\t\t  \t\t\t\t\t\t</div>\n\t\t\t\t\t  \t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;min-width:25px\" onclick=\"closePatientTasksDiv(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')\">\n\t\t\t\t\t  \t\t\t\t\t\t\n\t\t\t\t\t  \t\t\t\t\t\t</div>\n\t\t\t\t  \t\t\t\t\t\t</div>\n\t\t\t\t  \t\t\t\t\t</div>\n\t\t\t\t  \t\t\t\t</div>\n\t\t\t\t  \t\t\t</div>\t\t\t\t  \t\n\t\t\t\t  \t\t</div>\n\t\t\t\t  \t</div>\n\t\t\t\t  \t<div style=\"display:table-row\">\n\t\t\t\t  \t\t<div style=\"display:table-cell\">\n\t\t\t\t  \n   \t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n   \t\t\t\t\t\t<table class = \"IPContentTableTheme\" style=\"height:70px;max-height:110px;width:100%\" id=\"patientID";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" cellpadding = \"0\" cellspacing = \"0\"  border = \"0\">\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n   \t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n   \t\t\t\t\t\t<table data-patientid=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" data-speccode=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" class = \"IPContentTable1 IPContentTableTheme\" id=\"patientID";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" cellpadding = \"0\" cellspacing = \"0\"  border = \"0\" onclick = \"showNoRelationError()\">\n   \t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n        \t\t\t\t\t<tr class=\"trIpRows1\" style=\"background-color:white;float:left;\">\n\t           \t\t\t\t\t<td  class=\"ipListLeftIndicator\">\n\t              \t\t\t\t\t<div class = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" ></div>\n\t           \t\t\t\t\t</td>\n\t           \t\t\t\t\t<td style=\"width:70px; align=\"center\" valign = \"center\" >\n\t\t           \t\t\t\t\t<div class = \"imgPhoto1 imgPhotoTheme\">\n\t\t             \t\t\t\t\t<img width=\"55\" height=\"55\" src=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="/mobile/PatientImageServlet?PatientId=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" class=\"PatImgTagTheme\"/>\n\t\t             \t\t\t\t</div>\n\t           \t\t\t\t\t</td>\n           \t\t\t\t\t\n\t           \t\t\t\t\t<script>\n\t           \t\t\t\t\t\n\t           \t\t\t\t\tArrayOfPats.push(\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\");\n\t           \t\t\t\t\tArrayOfEncounter.push(\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\");\n\t           \t\t\t\t\t\n\t           \t\t\t\t\t</script>\n           \t\t\t\t\t\t<td style=\"width: 90%\">\n\t\t\t\t\t            \t<table style = \"width:100%;padding-left:10px\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px\";>\n\t\t\t\t\t                \t\t<td style=\"width:100%;word-break:break-all\" colspan = \"2\" >\n\t\t\t\t\t                        ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t                         \n\t\t\t\t\t                          <div class = \"txtRows txtRowsTheme\" style=\"color:#333b46; padding-left:0px;\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="<span class = \"txtRows ptIdGender \"style=\"color:#a3a3a3;font-weight: normal;padding-left:5px;\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</span></div>\n\t\t\t\t\t                          \n\t\t\t\t\t                    \t</td>\n\t\t\t\t\t                \t</tr>\n\t               \t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px;\">\n\t\t\t\t\t                         <td style=\"width:100%;word-break:break-all\" colspan = \"2\">\n\t\t\t\t\t                          <span class=\"lz-list-label lz-list-labelTheme\" style=\"padding-left:0px;\">Practitioner :</span><span class=\"lz-list-data1 lz-list-data1Theme\"  style=\"color:#504f4f\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</span>\n\t\t\t\t\t                         </td>\n\t                         \n\t                \t\t\t\t\t</tr>\n\t\t\t\t\t\t                <tr class=\"trIpChildRows\" style=\"height:20px;\">\n\t\t\t\t\t\t                    <td style=\"width:100%;word-break:break-all\" >\n\t\t\t\t\t\t                     <span class=\"lz-list-label lz-list-labelTheme\" style=\"padding-left:0px;\" >Room,Bed No :</span><span class=\"lz-list-data1 lz-list-data1Theme\" style=\"color:#504f4f\">\n\t\t\t\t\t\t                     ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =", ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="<span class=\"lz-list-data2 lz-list-data2Theme\"> On ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</span></span>  \n\t\t\t\t\t\t                   </td>\n\t\t\t\t\t\t                </tr>\n\t\t\t\t\t              \t\t<tr>\n\t\t\t\t\t                \t\t<td>\t\n\t\t\t\t\t                \n\t\t\t\t\t\t\t\t\t          <!-- Indicator portion -->\n\t\t\t\t\t\t\t\t\t              \n\t\t\t\t\t\t\t\t\t              <div class=\"iplIndicators\">\n\t\t\t\t\t\t\t\t\t               <span id=\"PendingTask_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"><img src=\"../images/PaddingTask20x20.png\"/></span>\n\t\t\t\t\t\t\t\t\t               <span id=\"NewResult_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"><img src=\"../images/NewResult20x20.png\"/></span>\n\t\t\t\t\t\t\t\t\t               <span id=\"Abnormal_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"><img src=\"../images/AbnormalResult20x20.png\"/></span>\n\t\t\t\t\t\t\t\t\t                <span id=\"NewNotes_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"><img src=\"../images/NewNote20x20.png\"/></span>\n\t\t\t\t\t\t\t\t\t                <span id=\"Discharge_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"><img src=\"../images/Discharge20x20.png\"/></span>\n\t\t\t\t\t\t\t\t\t                <span id=\"Medication_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"><img src=\"../images/MedicationIndicator20x20.png\"/></span>\n\t\t\t\t\t\t\t\t\t                <span id=\"Consent_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"><img src=\"../images/Consent20x20.png\"/></span>\n\t\t\t\t\t\t\t\t\t                <span id=\"PatientinOT_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"><img src=\"../images/PatientinOT20x20.png\"/></span>\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t              </div>   \n\t\t\t\t\t\t\t\t\t              \n\t\t\t\t\t\t\t\t\t          <!-- Indicator portion -->                   \t                                        \t\t\t                     \t\t\t\t       \t\t\t\t                                       \n                                 \t \n\t\t\t\t\t\t\t        \t\t</td>\t\n\t\t\t\t\t              \t\t</tr>\t\t\t\t             \n\t\t\t\t\t             \t</table>\n           \t\t\t\t\t\t</td>\n        \t\t\t\t\t</tr>\n   \t\t\t\t\t\t</table>   \n   \t\t\t\t\t</div>\n   \t\t\t\t\t<div style=\"display:table-cell;width:30px;max-width:30px;min-width:30px;vertical-align:middle;border-bottom: 1px solid #eaedf2;background-color:white;\" onclick=\"openPatientTasksDiv(\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\', \'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\')\">\n        \t\t\t\t\t<!-- <div class = \"ipContentMoreBtn\"></div> -->\n        \t\t\t\t\t<img src=\"../images/more_vertical24x24.png\">\n     \t\t\t\t</div>\n     \t\t\t</div>\n     \t\t</div>\n           \t\t\t\t\t\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t  $(document).ready(function () {\n\t\t\t\t\t\t\t\tvar parentDiv = $(\'#divcnt\').height();\n\t\t\t\t\t\t\t\t$(\'#NoRecordsMiddleAlign\').height(parentDiv);\n\t\t\t\t\t\t\t  });\n\t\t\t\t\t\t\t  window.addEventListener(\"orientationchange\", function() {\n\n\t\t\t\t\t\t\t\t\tvar parentDiv = $(\'#divcnt\').height();\n\t\t\t\t\t\t\t\t\t$(\'#NoRecordsMiddleAlign\').height(parentDiv);\n\t\t\t\t\t\t\t\t}, true);\n           \t\t\t\t\t</script>\n\t\t\t\t\t\t\t   <div id=\"NoRecordsMiddleAlign\" class=\"ipSearchResultsEmptyTheme\">\n\t\t\t\t\t\t\t\t\t<table style = \'height:100%;width:100%\'>\n\t\t\t\t\t\t\t\t\t\t<tr style = \'height:100%;width:100%\'>\n\t\t\t\t\t\t\t\t\t\t\t<td style = \'height:100%;width:100%\' align = \'center\' valign = \'middle\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<span style = \'font-family:Arial;font-weight:normal;font-size:13px;color:#bdbdbd;\'>No Records Found</span>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t  \n <script>\n\t\t             \n$(document).ready(function(){\n\tvar path;\n    var vals;  \n\t  \n\t  var allEncount;\n\tpath = document.getElementById(\"hdnPath\").value;\n    // alert(\"allPatsIds:\"+path);\n     \n\t  vals=ArrayOfPats;  \n\t  \n\t  allEncount=ArrayOfEncounter;\n\t$.ajax({\n\t\t  method: \"GET\",\n\t\t  url: path+\"/mobile/InPatientDetails/IpIndicator\",\n\t\t  data: {pat_ids: vals.join(),encounter_ids:allEncount.join()}\n\t})\n\t.done(function(response) {\n\t\tparent.removeSpinner();\n\t\tif(response==null){\t\t\n\t\t   return;\n\t\t\t}\n\t\t\t\n\t\n\tvar data=response;\n\n\tfor(var i =0 ;i<data.length;i++){\n\t\t\n\t\tvar patientObj=data[i];\n\t\t\n\t\t\n\tvar patientID=patientObj.patId;\n\n\t//var allTypesOfFilter=patientObj.typesOfIndicator;\n\tvar indicatorDetails=patientObj.typesOfIndicator;\n\n\n\t/* var newNotes=\"NewNotes_\"+patientID;\n\tvar pendingTask=\"PaddingTask_\"+patientID;\n\tvar abnormal=\"Abnormal_\"+patientID;\n\t//var discharge=\"Discharge_\"+patientID;\n\tvar note=\"New_\"+patientID;\n\t */\n\n\t/* var meds=\"Medication_\"+patientID;\n\tvar consent=\"Consent_\"+patientID;\n\tvar otPats=\"PatientinOT_\"+patientID;\n\t */\n\n\n\t\tfor(var j=0;j<indicatorDetails.length;j++){\t\t\n\t\t\tvar indicators=indicatorDetails[j];\n\t\t\t\n\t\t\tif(indicators.indicatorType==\"newnotes\"){\n\t\t\t\t\n\t\t\t//var check=indicators.showIndicator;\n\t\t\t\n\t\t\tif(indicators.showIndicator){\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t$(\'#NewNotes_\'+patientID).css(\"display\",\"inline-block\");\n\t\t\t}else{\n\t\t\t\t\n\t\t\t\t$(\'#NewNotes_\'+patientID).hide();\n\t\t\t}\n\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\tif(indicators.indicatorType==\"pending\"){\n\t\t\t\t\n\t\t\t\t//var check=indicators.showIndicator;\n\t\t\t\t\n\t\t\t\tif(indicators.showIndicator){\n\t\t\t\t\t\n\t\t\t\t\t$(\'#PendingTask_\'+patientID).css(\"display\",\"inline-block\");\n\t\t\t\t}else{\n\t\t\t\t\t\n\t\t\t\t\t$(\'#PendingTask_\'+patientID).hide();\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\tif(indicators.indicatorType==\"abnormal\"){\n\t\t\t\t\n\t\t\t\t//var check=indicators.showIndicator;\t\t\t\n\t\t\t\tif(indicators.showIndicator){\t\t\t\t\n\t\t\t\t\t$(\'#Abnormal_\'+patientID).css(\"display\",\"inline-block\");\n\t\t\t\t} \n\t\t\t\telse\n\t\t\t\t{\t\t\t\t\n\t\t\t\t\t$(\'#Abnormal_\'+patientID).hide();\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\n\t\t\t if(indicators.indicatorType==\"newresult\"){\n\t\t\t\t\t\n\t\t\t\t\t//var check=indicators.showIndicator;\n\t\t\t\t\t\n\t\t\t\t\tif(indicators.showIndicator){\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(\'#NewResult_\'+patientID).css(\"display\",\"inline-block\");\n\t\t\t\t\t}else{\n\t\t\t\t\t\t\n\t\t\t\t\t     $(\'#NewResult_\'+patientID).hide();\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t \n\t\t\t \n\t         if(indicators.indicatorType==\"discharge\"){\n\t\t\t\t\t\n\t\t\t\t\t//var check=indicators.showIndicator;\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tif(indicators.showIndicator){\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(\'#Discharge_\'+patientID).css(\"display\",\"inline-block\");\n\t\t\t\t\t}else{\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(\'#Discharge_\'+patientID).hide();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t         if(indicators.indicatorType==\"consent\")\n\t\t\t {\n\t\t\t\t\n\t\t\t\tif(indicators.showIndicator)\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t$(\'#Consent_\'+patientID).css(\"display\",\"inline-block\");\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t$(\'#Consent_\'+patientID).hide();\n\t\t\t\t}\n\t\t\t}\n\t\t\t\t\n\t\t\t\t}\n     \n\t\tparent.scrollContent1.refresh();\n\t}\n\n\n\t//call for Record/sign\n\t\t//recordNotes(operation_mode);\n\n\t});\n\n});\n\n\n </script>\n\t\t\t\t\t  \n\t\t\t\t\t  \n\t\t\t\t \n   </div>\n   \t\t\n    <div class=\"legendToggler legendTogglerTheme\" onclick=\"toggleLegend()\"><img src = \"../images/LegendIcon.png\" style=\"padding:10px 10px 10px 22px;\"/></div>\n   <!-- Added by Subha-V20190403/KDAH-CRF-0517/Starts -->\n   \t<div class=\"CSTransactionMessage\" id=\"transactionMsg\" style=\"bottom: 10px; left: 10px; display: none\">\n\t\t<div class=\"formValErrorMsgTheme\" id = \"transactionMessageContent\"></div>\n\t</div>\t\n\t<!-- Added by Subha-V20190403/KDAH-CRF-0517/Ends -->\t\n   <!-- legend scroll portion -->\t\n   \t\t\n   \t\t\t\t\n \t<div  id =\"legendContainer\" style=\"font-family: \'Arial\';font-size:12px;\">\t\t\t\t\t\n\t\t<div id=\"legendWrapper\">\n\t\t\t<div id=\"legendScroller\">\n\t\t\t\t<div class=\"legendTabs\" ><div class = \"dvLegendDischargedTheme\"></div><span class=\"liSpanScroll\">Discharged</span></div>\n\t\t\t\t<div class=\"legendTabs\" ><div class=\"dvLegendDeceasedTheme\" ></div><span class=\"liSpanScroll\">Deceased</span></div>\n\t\t\t\t<div class=\"legendTabs\" ><div class=\"dvLegendNewBornTheme\"></div><span class=\"liSpanScroll\">Newborn Exist</span></div>\n\t\t\t\t<div class=\"legendTabs\" ><div class = \"dvLegendNoRelationTheme\"></div><span class=\"liSpanScroll\">No PP Relationship</span></div>\n\t\t\t\t<div class=\"legendTabs\" ><img src=\"../images/PaddingTask20x20.png\"/><span class=\"liSpanScroll\">Pending Task</span></div>\n\t\t\t\t<div class=\"legendTabs\" ><img src=\"../images/NewResult20x20.png\"/><span class=\"liSpanScroll\">New Result</span></div>\n\t\t\t\t<div class=\"legendTabs\" ><img src=\"../images/AbnormalResult20x20.png\"/><span class=\"liSpanScroll\">Abnormal Result</span></div>\n\t\t\t\t<div class=\"legendTabs\" ><img src=\"../images/NewNote20x20.png\" /><span class=\"liSpanScroll\">New Clinical Notes  </span></div>\n\t\t\t\t<div class=\"legendTabs\" ><img src=\"../images/Discharge20x20.png\" /><span class=\"liSpanScroll\">Discharge Due</span></div>\n\t\t\t\t<div class=\"legendTabs\" ><img src=\"../images/MedicationIndicator20x20.png\" /><span class=\"liSpanScroll\">Medication Due</span></div>\n\t\t\t\t<div class=\"legendTabs\" ><img src=\"../images/Consent20x20.png\" /><span class=\"liSpanScroll\">Consent</span></div>\n\t\t\t\t<div class=\"legendTabs\" ><img src=\"../images/PatientinOT20x20.png\"/><span class=\"liSpanScroll\">Patient in OT</span></div>\n\t\t\t  </div>\n\t\t</div>\n\t</div> \t\n   </div>\n   \t\t\t\t\n  \n\t<!--  legend scroll portion ends-->\t\n</div>\n</div>\n   \n   \t\t\t\t\n   \t\t\t</div>\n<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" /> \n<input type = \"hidden\" name =\"lpPatientId\" id =\"lpPatientId\"  value =\"\"/>\n<input type = \"hidden\" name =\"lpEpisodeId\" id =\"lpEpisodeId\"  value =\"\"/>\n<input type = \"hidden\" name =\"lpAdmDateTime\" id =\"lpAdmDateTime\"  value =\"\"/>\n<input type = \"hidden\" name =\"lpDischargeDateTime\" id =\"lpDischargeDateTime\"  value =\"\"/>\n<input type = \"hidden\" name =\"lplocationType\" id =\"lplocationType\"  value =\"\"/>\n<input type = \"hidden\" name =\"lpLocationCode\" id =\"lpLocationCode\"  value =\"\"/>\n<input type = \"hidden\" name =\"lpServiceCode\" id =\"lpServiceCode\"  value =\"\"/>\t\n<input type = \"hidden\" name =\"hdnPatientId\" id =\"hdnPatientId\" value = \"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"/>\n<input type = \"hidden\" name =\"hdnNursingUnit\" id =\"hdnNursingUnit\" value = \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"/>\n<input type = \"hidden\" name =\"hdnClinicianId\" id =\"hdnClinicianId\" value = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"/>\n<input type = \"hidden\" name =\"hdnSfsClinicianId\" id =\"hdnSfsClinicianId\" value = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"/>\n<input type = \"hidden\" name =\"hdnSpeciality\" id =\"hdnSpeciality\" value = \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"/>\n<input type = \"hidden\" name =\"hdnOrderBy\" id =\"hdnOrderBy\" value = \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"/>\n<input type = \"hidden\" name =\"hdnIPCount\" id =\"hdnIPCount\" value = \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"/>\n<!-- Added by Subha-V20190403/KDAH-CRF-0517/Starts -->\n<input type = \"hidden\" name =\"facilityId\" id =\"facilityId\" value = \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"/>\n<input type = \"hidden\" name =\"clinicianId\" id =\"clinicianId\" value = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"/>\n<!-- Added by Subha-V20190403/KDAH-CRF-0517/Ends -->\n</form> \n\n\n  \n\t  ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t</div> <!--  data-role = \"page\" div -->\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
	SFSContext oSfsContext = new SFSContext();
	InPatientContext oInPatientContext = new InPatientContext();
	oInPatientContext.setRequest(request);
	String facility_id= ""; //(String)session.getValue("facility_id");
	String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
	String sPatientId = "" ;
	String sNursingUnitCode = "";
	String sNursingUnit = "";
	String sClinicianDesc = "";
	String sSpecialityCode = "";
	String sSpeciality = "";
	String sOrderBy = "";
	String sFacilityId = "";
	String sPractionerId = "";
	String sfsPractionerId = "";
	String sPractionerDesc = "";
	boolean patPractRelReqd = false;
	Gson gson = new Gson();
	List<String> allPatientIds = new ArrayList<String>();
	List<String> allEncounerIds = new ArrayList<String>();
	 
	if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
	{
		facility_id = (String)session.getValue("facility_id");
		oInPatientContext.setFacilityId(facility_id);
	}
	
	if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
	{
		clinicianId = (String)session.getValue("ca_practitioner_id");
		oInPatientContext.setClinicianId(clinicianId);
	}
	String className = "dvLegendNotRequired";
	StringTokenizer st = null;
	String deceasedYn = "";
	int noofchildren = 0;
	String relationYn = "";
	String tempDischargeDate = "";
	String strPatientName = "";
	String strPatientIdGender ="";
	String strPatientDetails = "";
	
	
	if(request.getParameter("hdnPatientId") != null && request.getParameter("hdnPatientId") != "" && request.getParameter("hdnPatientId") != " ")
	{
	 
		sPatientId = ((String)request.getParameter("hdnPatientId")).trim();
		oInPatientContext.setPatientId(sPatientId);
	 
	}
	
	if(request.getParameter("hdnNursingUnit") != null && request.getParameter("hdnNursingUnit") != "" && request.getParameter("hdnNursingUnit") != " ")
	{
	  
	 sNursingUnitCode = (String)request.getParameter("hdnNursingUnit");
	 oInPatientContext.setNursingUnitCode(sNursingUnitCode);
	}
	if(request.getParameter("hdnClinicianId") != null && request.getParameter("hdnClinicianId") != "" && request.getParameter("hdnClinicianId") != " ")
	{
	
	 sPractionerId = (String)request.getParameter("hdnClinicianId");
	 oInPatientContext.setPractionerId(sPractionerId);
	 
	}
	if(request.getParameter("hdnSfsClinicianId") != null )
	{
	
	 sfsPractionerId = (String)request.getParameter("hdnSfsClinicianId");
	 oSfsContext.setsPractionerId(sfsPractionerId);

	}
	if(request.getParameter("hdnSpeciality") != null && request.getParameter("hdnSpeciality") != "" && request.getParameter("hdnSpeciality") != " ")
	{
	
	 sSpecialityCode = (String)request.getParameter("hdnSpeciality");
	 oInPatientContext.setSpecialityCode(sSpecialityCode);
	}
	
	if(request.getParameter("hdnOrderBy") != null &&  request.getParameter("hdnOrderBy") != "")
	{
		
		sOrderBy = (String)request.getParameter("hdnOrderBy");
		oInPatientContext.setOrderBy(sOrderBy);
	}
	
	
	if(request.getParameter("txtPracId") != null &&  request.getParameter("txtPracId") != "")
	{
		
		sPractionerDesc = (String)request.getParameter("txtPracId");
		oInPatientContext.setPractionerDesc(sPractionerDesc);
	}
	
	if(request.getParameter("txtNursingUnit") != null &&  request.getParameter("txtNursingUnit") != "")
	{
		
		sNursingUnit = (String)request.getParameter("txtNursingUnit");
		oInPatientContext.setNursingUnit(sNursingUnit);
		
	}
	if(request.getParameter("txtSpeciality") != null &&  request.getParameter("txtSpeciality") != "")
	{
		
		sSpeciality = (String)request.getParameter("txtSpeciality");
		oInPatientContext.setSpeciality(sSpeciality);
		
	}
	


            _bw.write(_wl_block1_0Bytes, _wl_block1_0);
            _bw.write(_wl_block1_1Bytes, _wl_block1_1);
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
            out.print( String.valueOf(oInPatientContext.getPatientId() ));
            _bw.write(_wl_block16Bytes, _wl_block16);

				  int nClassCount = 1;
				  int cnt = 0;
				  String Status = "";
				  String emergencyYn = "";
				  String n = null;
				  
				  InPatientList bean = new InPatientList();
				  //Check if Practioner Patient Relationship is enabled in the setup
				  patPractRelReqd = bean.patientPractRelnReqdYN().equals("Y")?true:false;
				  List<InPatients> objInPatientList = new ArrayList<InPatients>(); 
				  int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
				  int nCssCount = 1;  // To display alternate Row Color.
				 
				  int nListSize = 0;
			
				  int nLoopCount = 0;
				  InPatients oInPatients = null;
				  try {
					  objInPatientList = bean.getInPatientLis(oInPatientContext);
					  if(objInPatientList != null)
					  {
					       nListSize =  objInPatientList .size();
					       
					  }
					 if(nListSize > 0)
					 {
					   for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
						{
					 
						   oInPatients = objInPatientList.get(nLoopCount); 
						   
						   allPatientIds.add(oInPatients.sPatientId);
						   allEncounerIds.add(oInPatients.sEpisodeId);
						   
						   
						  //System.out.println("all values sizes::"+allPatientIds.size()); 
						   
						   if(oInPatients != null)
						   {
					        Status = oInPatients.sStatus;
					        st = new StringTokenizer(Status,"|");
							  while (st.hasMoreTokens())
								{
									emergencyYn = st.nextToken();
									deceasedYn = st.nextToken();
									n = st.nextToken();
									if(!(n == null || n.equals("")))
										noofchildren = Integer.parseInt(n);
									relationYn = st.nextToken();
								}
					  
							  if(oInPatients.sDischargeDateTime != null)
							  {
									if( !oInPatients.sDischargeDateTime.equals(""))
										className = "dvLegendDischargedTheme";
							  }
							  
								
								if(deceasedYn.equals("D"))
								{
									className = "dvLegendDeceasedTheme";
									
								}
								if(noofchildren > 0) 
									className = "dvLegendNewBornTheme";
								
								if(relationYn.equals("N"))
								{
									className = "dvLegendNoRelationTheme";
								}
								
								 deceasedYn = "";
								 noofchildren = 0;
								 relationYn = "";
								 tempDischargeDate = "";
								 
								 boolean openChartSum = true;
								 if(patPractRelReqd){
									 if(oInPatients.relnExists){
										 openChartSum = true;
									 }else{
										 openChartSum = false;
									 }
								 }
								 
				  
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oInPatients.sEpisodeId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oInPatients.sAdmDateTime));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oInPatients.sDischargeDateTime));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oInPatients.locationType));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oInPatients.locationCode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(oInPatients.serviceCode));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oInPatients.sSpecialityCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oInPatients.locationCode));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oInPatients.sEpisodeId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(openChartSum){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oInPatients.sEpisodeId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oInPatients.sAdmDateTime));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oInPatients.sDischargeDateTime));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oInPatients.locationType));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oInPatients.locationCode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(oInPatients.serviceCode));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oInPatients.sSpecialityCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oInPatients.locationCode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{ 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oInPatients.sEpisodeId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oInPatients.sAdmDateTime));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oInPatients.sDischargeDateTime));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oInPatients.locationType));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oInPatients.locationCode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(oInPatients.serviceCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(oInPatients.sSpecialityCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oInPatients.locationCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block41Bytes, _wl_block41);
} 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(className ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(oInPatients.sEpisodeId));
            _bw.write(_wl_block47Bytes, _wl_block47);
  
					                        // strPatientDetails = out.println(rs.getString("patient_name") )+ " " + out.println(rs.getString("sex"),rs.getString("age")) + " " + out.println(rs.getString("patient_id"));
					                        strPatientName = oInPatients.sPatientName + ",";
		  		                            strPatientIdGender = oInPatients.sPatientId + ", " + oInPatients.sGender + " " ;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strPatientIdGender ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(oInPatients.sPhysicianName));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(oInPatients.sRoomNo));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(oInPatients.sBedNo));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(oInPatients.sAdmDateTime));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(oInPatients.sEpisodeId));
            _bw.write(_wl_block64Bytes, _wl_block64);

							   }
					   className = "dvLegendNotRequired";
					     nRowCount = nRowCount + 1;
						  if(nCssCount==1)
						  {
							   nCssCount = nCssCount +1;
						  }
						  else
						  {
							  nCssCount = nCssCount -1;
						  }	 
					   }//for
					 
						 }//if listsize 
						 else
						 {
							 
            _bw.write(_wl_block65Bytes, _wl_block65);
 
						 }
					  
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(oInPatientContext.getPatientId()));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(oInPatientContext.getNursingUnitCode() ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(oInPatientContext.getPractionerId() ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(oSfsContext.getsPractionerId() ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(oInPatientContext.getSpecialityCode() ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(oInPatientContext.getOrderBy() ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(nListSize));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(oInPatientContext.getFacilityId()));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(oInPatientContext.getClinicianId()));
            _bw.write(_wl_block76Bytes, _wl_block76);

	}catch ( Exception e ){
		out.println("Exception " + e);
		e.printStackTrace();
	}
	finally{
	
	}
	
            _bw.write(_wl_block77Bytes, _wl_block77);
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
