package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.ORReviewResult.ORReviewResultHome;
import eOR.Common.OrRepository;
import com.ehis.eslp.ServiceLocator;
import eIPAD.pendingresults.PrevResultDateContainer;
import eIPAD.pendingresults.PrevResultCountResponse;
import eIPAD.pendingresults.PreviousResultsResponse;
import eIPAD.pendingresults.PreviousResultsRequest;
import eIPAD.pendingresults.ResultDetail;
import eIPAD.pendingresults.ResultCategory;
import java.util.Map.Entry;
import eIPAD.pendingresults.PendingResultForPatient;
import eIPAD.pendingresults.PatientDetail;
import eIPAD.pendingresults.PendingResultsResponse;
import eIPAD.pendingresults.PendingResults;
import eCommon.Common.CommonBean;
import eIPAD.pendingresults.PendingResultsRequest;
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

public final class __pendingresults_45_newui extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/PendingResults-newUI.jsp", 1738426118115L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1_0 ="\n<!DOCTYPE html>\n<html>\n<head>\n\n<title>Pending Results Review</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<!--  <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  -->\n\n<!-- <link rel=\"stylesheet\" href=\"../css/iPadPendingResultCriteria.css\" /> -->\n<link rel=\"stylesheet\" href=\"../css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<!-- <script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>  -->\n<script type=\"application/javascript\" src=\"../js/iscroll.js\"></script>\n<!--  -->\n\n\n\n<script type=\"text/javascript\">\n\n//variables for setting the content frame height according to the device\n//below values are header footer heights\nvar pageHFheight= 90;\nvar content_height;\n\n\nvar prMainScroll ;\n\nfunction assignPrScroll() {\n\t\t setTimeout(function () {\n\t\tprMainScroll = new iScroll(\'divcnt\', {\n\t\t\tuseTransform: true,\n\t\t\tzoom: false,\n\t\t\tonBeforeScrollStart: function (e) {\n\t\t\tvar target = e.target;\n\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' )\n\t\t\te.preventDefault();\n\t\t\t}\n\t\t\t});\n\t}, 100); \n}\n\ndocument.addEventListener(\'DOMContentLoaded\', assignPrScroll, false);\n\ndocument.addEventListener(\'touchmove\', function(e) {\n\te.preventDefault();\n}, false);\n\n\nvar globaldrWidth;\nvar currentScrollingPendResDiv;\n\n//previous results scroller object\nvar prevResScroll;\nfunction assignPrevResHorizontalScroll(){\n\t\t//When the detailed result is scrolled iscroll object is assigned to this div\n\t  $(\'.prevResWrapperDiv\').bind(\'touchstart click\', function(event) { \n\n\t\t  //alert(currentScrollingPendResDiv);\n\t\t  var currentDiv = $(this).attr(\'id\');\n\t\t  //alert(currentDiv);\n\n\t\t  \n\t\t  if(currentScrollingPendResDiv){\n\t\t\t  \n\t\t\t  if(currentScrollingPendResDiv != currentDiv){\n\t\t\t\t  prevResScroll = new iScroll(currentDiv, {\n\t\t\t\t\t\thScrollbar : false\n\t\t\t\t});\n\t\t\t\tcurrentScrollingPendResDiv = currentDiv;\n\t\t\t\t\n\t\t\t  }\n\t\t  }\n\t\t  else{\n\t\t\t  currentScrollingPendResDiv = currentDiv;\n\t\t\t  prevResScroll = new iScroll(currentDiv, {\n\t\t\t\t\thScrollbar : false\n\t\t\t});\n\t\t  }\n\t\t  \n\n\t\t  \n\t  });  \n}\n\ndocument.addEventListener(\'DOMContentLoaded\', assignPrevResHorizontalScroll, false);\n\n\n//function to compute the previous results column width. This function should be called whenever the result frame gets resized\nfunction computeDrWidth(){\n\tvar globalprWidth= $(\'.prContentTable\').width();\n\t// detailed results div width will be calculated below. 12 is the border and margin values\n\tglobaldrWidth = Math.floor((globalprWidth - 12)/2);\n\t$(\'.drResultCategoryHeader\').css(\'width\', globaldrWidth+\'px\');\n\t$(\'.prevResWrapperDiv\').css(\'width\', globaldrWidth+\'px\');\n\t//alert(globaldrWidth);\n}\n\nfunction LoadPrevResDivs(){\n\t\n\t$(\".prevResScrollerDiv:in-viewport\").each(\n\t\t\tfunction() {\n\t\t\t\tvar recordNum = $(this).attr(\'data-patnum\');\n\t\t\t\t//alert(\"showing hscroll div\" +recordNum);\n\t\t\t\t//Calculating the scroller width for each of the previous results div after loading detailed results. \n\t\t\t\t//This is required to make the horizontal iScroll scroll till the end of the contents\n\t\t\t\t//If the previous results url is not loaded before load it, otherwise donot load it\n\t\t\t\tif($(\'#prevResScroller\' + recordNum).find(\'.drRowContainerTheme table\').length < 1)\n\t\t\t\t{\n\t\t\t\t\t//alert(\"loading prev res\" +recordNum);\n\t\t\t\t\t$(\'#prevResScroller\' + recordNum).load(\n\t\t\t\t\t\tdocument.getElementById(\"hdnDetailedResUrl\"\n\t\t\t\t\t\t\t\t+ recordNum).value,\n\t\t\t\t\t\tfunction() {\n\t\t\t\t\t\t\tvar scrollerWidth = $(\n\t\t\t\t\t\t\t\t\t\'#prevResScroller\' + recordNum).find(\n\t\t\t\t\t\t\t\t\t\'.drRowContainerTheme table\').width();\n\t\t\t\t\t\t\t//alert(recordNum + \' -  \' +scrollerWidth);\n\t\t\t\t\t\t\t$(\'#prevResScroller\' + recordNum).css(\'width\',\n\t\t\t\t\t\t\t\t\tscrollerWidth + \'px\');\n\t\t\t\t\t\t});\n\t\t\t\t}\n\t\t\t});\n}\n\n\tvar currentScrollingDrDiv\n\tvar detResScroll;\n\tfunction assignDetResVScroll() {\n\t\t//When the detailed result is scrolled iscroll object is assigned to this div\n\t\t$(\'.wrapperNested\').bind(\n\t\t\t\t\'touchmove click\',\n\t\t\t\tfunction(event) {\n\t\t\t\t\t//prMainScroll.disable();\n\t\t\t\t\t//alert(currentScrollingDrDiv);\n\t\t\t\t\tvar currentDiv = $(this).attr(\'id\');\n\t\t\t\t\t//alert(currentDiv);\n\n\t\t\t\t\tif (currentScrollingDrDiv) {\n\n\t\t\t\t\t\tif (currentScrollingDrDiv != currentDiv) {\n\t\t\t\t\t\t\tsetTimeout(function () {\n\t\t\t\t\t\t\t\t//alert(\"Creating new dr scroll\");\n\t\t\t\t\t\t\t\tdetResScroll = new iScroll(currentDiv, {\n\t\t\t\t\t\t\t\t\tuseTransform : true,\n\t\t\t\t\t\t\t\t\tzoom : false,\n\t/* \t\t\t\t\t\t\t\tbounce: false,\n\t\t\t\t\t\t\t\t\tbounceLock: true,\n\t\t\t\t\t\t\t\t\tmomentum: false, */\n\t\t\t\t\t\t\t\t\tonBeforeScrollStart : function(e) {\n\t\t\t\t\t\t\t\t\t\tvar target = e.target;\n\t\t\t\t\t\t\t\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\t\t\t\t\t\t\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' )\n\t\t\t\t\t\t\t\t\t\te.preventDefault();\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t//e.preventDefault(); \n\t\t\t\t\t\t\t\t\t\te.stopPropagation();\n\t\t\t\t\t\t\t\t\t}/*  ,\n\t\t\t\t\t\t\t\t\tonScrollEnd: function() {\n\t\t\t\t\t\t\t\t\t\tsetTimeout(function () {\n\t\t\t\t\t\t\t\t\t\t  //LoadPrevResDivs();\n\t\t\t\t\t\t\t\t\t\t}, 100); \n\t\t\t\t\t\t\t\t\t}  */\n\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}, 100); \n\t\t\t\t\t\t\tcurrentScrollingDrDiv = currentDiv;\n\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\n\t\t\t\t\t\t//alert(\"Creating new dr scroll\");\n\t\t\t\t\t\tcurrentScrollingDrDiv = currentDiv;\n\t\t\t\t\t\t\n\t\t\t\t\t\tsetTimeout(function () {\n\t\t\t\t\t\tdetResScroll = new iScroll(currentDiv, {\n\t\t\t\t\t\t\tuseTransform : true,\n\t\t\t\t\t\t\tzoom : false,\n\t\t/* \t\t\t\t\tbounce: false,\n\t\t\t\t\t\t\tbounceLock: true,\n\t\t\t\t\t\t\tmomentum: false, */\n\t\t\t\t\t\t\tonBeforeScrollStart : function(e) {\n\t\t\t\t\t\t\t\tvar target = e.target;\n\t\t\t\t\t\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\t\t\t\t\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' )\n\t\t\t\t\t\t\t\te.preventDefault();\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t//e.preventDefault(); \n\t\t\t\t\t\t\t\te.stopPropagation();\n\t\t\t\t\t\t\t} /* ,\n\t\t\t\t\t\t\tonScrollEnd: function() {\n\t\t\t\t\t\t\t\tsetTimeout(function () {\n\t\t\t\t\t\t\t\t\t  LoadPrevResDivs();\n\t\t\t\t\t\t\t\t\t}, 100); \n\t\t\t\t\t\t\t}  */\n\t\t\t\t\t\t});\n\t\t\t\t\t\t\n\t\t\t\t\t\t}, 100); \n\t\t\t\t\t}\n\n\t\t\t\t});\n\t}\n\t\n\tdocument.addEventListener(\'DOMContentLoaded\', assignDetResVScroll, false);\n\t//document.addEventListener(\'DOMContentLoaded\', LoadPrevResDivs, false);\n\n\n\n\n\t$(document).ready(\n\t\t\tfunction() {\t\t\t\n\t\t\t\t  parent.removeSpinner();\n\t\t\t\t//Calling computeDrWidth() function to set the detailed results div width\n\t\t\t\tcomputeDrWidth();\n\t\t\t\tparent.setIframeHeight();\n\t\t\t\t\n\n\t\t\t\t//When enter key or space key is pressed in the patient ID text box, submit the form\n\t\t\t\t$(\'#PatientIdText\').bind(\'keypress\', function(e) {\n\t\t\t\t\tif (e.which == 32) {//space bar\n\t\t\t\t\t\t//alert(\'space\');\n\t\t\t\t\t\tsearchPendingResults();\n\t\t\t\t\t}\n\t\t\t\t\tif (e.which == 13) {//enter key\n\t\t\t\t\t\t//alert(\'enter\');\n\t\t\t\t\t\tsearchPendingResults();\n\t\t\t\t\t}\n\n\t\t\t\t});\n\n\t\t\t\t//Applying selected style to the current normalcy\n\t\t\t\tvar currentNormalcySelected = document\n\t\t\t\t\t\t.getElementById(\"hdnNormalcyVal\").value;\n\t\t\t\t//alert(currentNormalcySelected);\n\t\t\t\tif (currentNormalcySelected == \"\"\n\t\t\t\t\t\t|| currentNormalcySelected == \"Z\"\n\t\t\t\t\t\t|| currentNormalcySelected == \"S\")\n\t\t\t\t\t$(\'#normalcyAll\').removeClass(\'prContentHolderIconTheme\')\n\t\t\t\t\t\t\t.addClass(\'prContentHolderSelectedIconTheme\');\n\t\t\t\telse if (currentNormalcySelected == \"A\")\n\t\t\t\t\t$(\'#normalcyAbnormal\').removeClass(\n\t\t\t\t\t\t\t\'prContentHolderIconTheme\').addClass(\n\t\t\t\t\t\t\t\'prContentHolderSelectedIconTheme\');\n\t\t\t\telse if (currentNormalcySelected == \"C\")\n\t\t\t\t\t$(\'#normalcyCritical\').removeClass(\n\t\t\t\t\t\t\t\'prContentHolderIconTheme\').addClass(\n\t\t\t\t\t\t\t\'prContentHolderSelectedIconTheme\');\n\t\t\t\telse if (currentNormalcySelected == \"N\")\n\t\t\t\t\t$(\'#normalcyNormal\')\n\t\t\t\t\t\t\t.removeClass(\'prContentHolderIconTheme\').addClass(\n\t\t\t\t\t\t\t\t\t\'prContentHolderSelectedIconTheme\');\n\n\t\t\t});\n\t\n\tfunction toggleMenuPR(){\n\t\t\n\t\tparent.toggleMenu();\n\t\t\n\t\t//setting timeout for computing detailed results column width because\n\t\t//a small gap will be created due to slow transition in the menu\n\t\tsetTimeout(function(){\n\t\t\tcomputeDrWidth();\n\t\t},500);\n\t\t\n\t\t\n\t}\n\n\tvar bShCriteria = true;\n\n\tfunction changeOrientation(orient,HFheight) {\n\t \tcontent_height = parent.getTotalPageDivHeight() - pageHFheight - HFheight;\n\t\tdocument.getElementById(\"divcnt\").style.height = content_height+\"px\";\n\t\tif (prMainScroll != null)\n\t\t\tprMainScroll.refresh();\n\t\tcomputeDrWidth();\n\t}\n\tfunction showCriteria() {\n\t\t$(\'#searchCriteriaDiv\').slideToggle(\'fast\');\n\t\tif (bShCriteria) {\n\t\t\tbShCriteria = false;\n\t\t\tdocument.getElementById(\"imgCriteria\").src = \"../images/Heading-Panel-Up-Arrow.png\";\n\t\t} else {\n\t\t\tbShCriteria = true;\n\t\t\tdocument.getElementById(\"imgCriteria\").src = \"../images/Heading-Panel-down-Arrow.png\";\n\t\t}\n\t}\n\n\tfunction clearPatientIdText() {\n\n\t\tdocument.getElementById(\"PatientIdText\").value = \"\";\n\t\tdocument.getElementById(\"hdnPatientId\").value = \"\";\n\t}\n\n\tfunction searchPendingResults() {\n\t\t// get the selected period from the hidden component\n\t\tvar hdnFromPeriod = document.getElementById(\"hdnFromPeriod\");\n\t\tif (hdnFromPeriod) {\n\t\t\tselectedFromPeriod = hdnFromPeriod.value;\n\t\t}\n\t\t// the below code to also consider to period is only\n\t\t// to maintain uniformity - to period is not of use\n\t\t// presently\n\t\tvar hdnToPeriod = document.getElementById(\"hdnToPeriod\");\n\t\tvar toPeriod;\n\t\tif (hdnToPeriod) {\n\t\t\ttoPeriod = hdnToPeriod.value;\n\t\t}\n\n\t\t// set the flag that search button is clicked\n\t\tvar hdnSearchClicked = document.getElementById(\"hdnSearchClicked\");\n\t\tif (hdnSearchClicked) {\n\t\t\thdnSearchClicked.value = \"Y\";\n\t\t}\n\n\t\t// get the selected normalcy and set it to the hidden component\n\t\t/* \t\tvar normalcyComp = document.getElementById(\"NormalcyComp\");\n\t\t var hdnNormalcyComp = document.getElementById(\"hdnNormalcyVal\");\n\t\t if(normalcyComp){\n\t\t var selectedNormalcy = normalcyComp.options[normalcyComp.selectedIndex].value;\n\t\t if(hdnNormalcyComp){\n\t\t hdnNormalcyComp.value = selectedNormalcy;\n\t\t }\n\t\t }\n\t\t */\n\t\tvar selectedNormalcy;\n\t\tvar hdnNormalcyComp = document.getElementById(\"hdnNormalcyVal\");\n\t\tif (hdnNormalcyComp) {\n\t\t\tif (hdnNormalcyComp.value != null && hdnNormalcyComp.value != \'\')\n\t\t\t\tselectedNormalcy = hdnNormalcyComp.value;\n\t\t\telse\n\t\t\t\tselectedNormalcy = \'S\';\n\t\t}\n\n\t\t// get the patient id from the text and set it to the hidden component\n\t\tvar patientIdComp = document.getElementById(\"PatientIdText\");\n\t\tvar hdnPatientComp = document.getElementById(\"hdnPatientId\");\n\t\tif (patientIdComp) {\n\t\t\tvar patientId = patientIdComp.value;\n\t\t\tpatientId = $.trim(patientId);\n\t\t\tpatientId = patientId.toUpperCase();\n\t\t\tpatientIdComp.value = patientId;\n\t\t\tif (hdnPatientComp) {\n\t\t\t\thdnPatientComp.value = patientId;\n\t\t\t}\n\t\t}\n\n\t\t// need to get groupby, and task applicability now\n\t\tvar hdnGroupbyComp = document.getElementById(\"hdnGroupby\");\n\t\tvar groupbyVal;\n\t\tif (hdnGroupbyComp) {\n\t\t\tgrou";
    private final static byte[]  _wl_block1_0Bytes = _getBytes( _wl_block1_0 );

    private final static java.lang.String  _wl_block1_1 ="pbyVal = hdnGroupbyComp.value;\n\t\t}\n\n\t\tvar hdnTaskApplicability = document\n\t\t\t\t.getElementById(\"hdnGetTaskApplicability\");\n\t\tvar taskApplicabilityVal;\n\t\tif (hdnTaskApplicability) {\n\t\t\ttaskApplicabilityVal = hdnTaskApplicability.value;\n\t\t}\n\n\t\tvar hdnCompleteReviewClicked = document\n\t\t\t\t.getElementById(\"hdnForwardReviewClicked\");\n\t\tif (hdnCompleteReviewClicked) {\n\t\t\thdnCompleteReviewClicked.value = \"\";\n\t\t}\n\n\t\t// get the form and set the source url\n\t\tvar pendingResultsForm = document.getElementById(\"PendingResultsForm\");\n\t\tif (pendingResultsForm) {\n\t\t\tpendingResultsForm.action = \"PendingResults-newUI.jsp?hdnFromPeriod=\"\n\t\t\t\t\t+ selectedFromPeriod\n\t\t\t\t\t+ \"&hdnToPeriod=\"\n\t\t\t\t\t+ toPeriod\n\t\t\t\t\t+ \"&hdnNormalcyVal=\"\n\t\t\t\t\t+ selectedNormalcy\n\t\t\t\t\t+ \"&hdnGetTaskApplicability=\"\n\t\t\t\t\t+ taskApplicabilityVal\n\t\t\t\t\t+ \"&hdnGroupby=\" + groupbyVal;\n\t\t\tpendingResultsForm.submit();\n\t\t}\n\t}\n\n\tfunction setNormalcy(normalcy) {\n\t\tdocument.getElementById(\"hdnNormalcyVal\").value = normalcy;\n\t\tsearchPendingResults();\n\n\t}\n\n\tfunction Practitioner(strCode, strDesc) {\n\t\tdocument.getElementById(\"hdnPractCode\").value = strCode;\n\t\tdocument.getElementById(\"hdnPractDesc\").value = strDesc;\n\n\t\tforwardResult();\n\t}\n\n\tfunction showPractitioner() {\n\t\tdocument.getElementById(\"srchFrame\").src = \"Practitioner.jsp\";\n\t\t$(\"#PendingResultsForm\").toggle(\"fast\");\n\t\t$(\"#Dialog\").toggle(\"fast\");\n\t}\n\n\tfunction showPracSfs() {\n\t\tdocument.getElementById(\"sfsFrame\").src = \"PendingResultsPractitionerSFS-newUI.jsp\";\n\t\t$(\"#sfs\").css(\'z-index\', \"1000\");\n\t\t$(\"#sfsarrow\").css(\'z-index\', \"1000\");\n\t\t$(\'#sfs\').toggle();\n\t\t$(\'#sfsarrow\').toggle();\n\t}\n\n\tfunction completeReview() {\n\t\tvar totalRecordComp = document.getElementById(\"hdnTotalRecords\");\n\t\tvar totalRecords;\n\t\tvar totalRecordsInt;\n\t\tif (totalRecordComp) {\n\t\t\ttotalRecords = totalRecordComp.value;\n\t\t\ttotalRecordsInt = parseInt(totalRecords);\n\t\t}\n\t\t//alert(\'total records=\'+totalRecordsInt);\n\n\t\tvar checkComp;\n\t\tvar checkedCompCount = 0;\n\t\tvar selectedRows = \"\";\n\t\tfor (count = 1; count <= totalRecordsInt; count++) {\n\t\t\tcheckComp = document.getElementById(\"check\" + count);\n\t\t\tif (checkComp) {\n\t\t\t\tif (checkComp.checked) {\n\t\t\t\t\tif (checkedCompCount > 0) {\n\t\t\t\t\t\tselectedRows += \",\" + count;\n\t\t\t\t\t} else {\n\t\t\t\t\t\tselectedRows += \"\" + count;\n\t\t\t\t\t}\n\t\t\t\t\tcheckedCompCount++;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tif (checkedCompCount == 0) {\n\t\t\talert(\'Check Atleast One Event\');\n\t\t\treturn false;\n\t\t}\n\n\t\tvar selectedRowsComp = document.getElementById(\"hdnSelectedRows\");\n\t\tif (selectedRowsComp) {\n\t\t\tselectedRowsComp.value = selectedRows;\n\t\t}\n\n\t\t// this should be deleted after the entire code for complete review\n\t\t// is done\n\t\t//return false;\n\n\t\tvar completeReviewComp = document\n\t\t\t\t.getElementById(\"hdnCompleteReviewClicked\");\n\t\tif (completeReviewComp) {\n\t\t\tcompleteReviewComp.value = \"Y\";\n\t\t}\n\n\t\tvar confirmFlag = confirm(\"Do you want to complete the review of Selected Pending Results\");\n\t\tif (confirmFlag) {\n\t\t\tvar pendingResultsForm = document\n\t\t\t\t\t.getElementById(\"PendingResultsForm\");\n\t\t\tif (pendingResultsForm) {\n\t\t\t\tpendingResultsForm.submit();\n\t\t\t}\n\t\t} else {\n\t\t\treturn false;\n\t\t}\n\n\t}\n\n\tfunction forwardResult() {\n\t\tvar totalRecordComp = document.getElementById(\"hdnTotalRecords\");\n\t\tvar totalRecords;\n\t\tvar totalRecordsInt;\n\t\tif (totalRecordComp) {\n\t\t\ttotalRecords = totalRecordComp.value;\n\t\t\ttotalRecordsInt = parseInt(totalRecords);\n\t\t}\n\t\t//alert(\'total records=\'+totalRecordsInt);\n\n\t\tvar checkComp;\n\t\tvar checkedCompCount = 0;\n\t\tvar selectedRows = \"\";\n\t\tfor (count = 1; count <= totalRecordsInt; count++) {\n\t\t\tcheckComp = document.getElementById(\"check\" + count);\n\t\t\tif (checkComp) {\n\t\t\t\tif (checkComp.checked) {\n\t\t\t\t\tif (checkedCompCount > 0) {\n\t\t\t\t\t\tselectedRows += \",\" + count;\n\t\t\t\t\t} else {\n\t\t\t\t\t\tselectedRows += \"\" + count;\n\t\t\t\t\t}\n\t\t\t\t\tcheckedCompCount++;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tif (checkedCompCount == 0) {\n\t\t\talert(\'Check Atleast One Event\');\n\t\t\treturn false;\n\t\t}\n\n\t\tvar selectedRowsComp = document.getElementById(\"hdnSelectedRows\");\n\t\tif (selectedRowsComp) {\n\t\t\tselectedRowsComp.value = selectedRows;\n\t\t}\n\n\t\t// this should be deleted after the entire code for complete review\n\t\t// is done\n\t\t//return false;\n\n\t\tvar completeReviewComp = document\n\t\t\t\t.getElementById(\"hdnCompleteReviewClicked\");\n\t\tif (completeReviewComp) {\n\t\t\tcompleteReviewComp.value = \"N\";\n\t\t}\n\n\t\tvar forwardReviewComp = document\n\t\t\t\t.getElementById(\"hdnForwardReviewClicked\");\n\t\tif (forwardReviewComp) {\n\t\t\tforwardReviewComp.value = \"Y\";\n\t\t}\n\n\t\tvar confirmFlag = confirm(\"Do you want to Forward the selected Results\");\n\t\tif (confirmFlag) {\n\t\t\tvar pendingResultsForm = document\n\t\t\t\t\t.getElementById(\"PendingResultsForm\");\n\t\t\tif (pendingResultsForm) {\n\t\t\t\tpendingResultsForm.submit();\n\t\t\t}\n\t\t} else {\n\t\t\treturn false;\n\t\t}\n\n\t}\n\n\tfunction selectAllRecords() {\n\n\t\tparentchkbox = document.getElementById(\"selectAll\");\n\t\t$(\"#divcnt input:checkbox\").each(function() {\n\t\t\tthis.checked = parentchkbox.checked;\n\t\t});\n\n\t}\n\n\tfunction selectPatientCategories(pc) {\n\n\t\tparentchkbox = document.getElementById(\"checkb\" + pc);\n\t\t$(\"[data-patientcat = \'\" + pc + \"\']\").each(function() {\n\t\t\tthis.checked = parentchkbox.checked;\n\t\t});\n\n\t}\n\n\tfunction selectAllPatientCategories(patientCounter) {\n\t\tparentchkbox = document.getElementById(\"checkc\" + patientCounter);\n\t\t$(\"[data-patient = \'\" + patientCounter + \"\']\").each(function() {\n\t\t\tthis.checked = parentchkbox.checked;\n\t\t});\n\t}\n\n\tfunction DisplayOrHideDetails(HeaderName, tableobj) {\n\t\tvar objImgId = \"expander\" + HeaderName;\n\t\tvar objImg = document.getElementById(objImgId)\n\t\tvar imgPath = objImg.src;\n\t\tif (imgPath.indexOf(\"Collapse\") != -1) {\n\t\t\tobjImg.src = \"../images/Expandview.png\";\n\t\t\t$(\"[data-class = \'\" + HeaderName + \"\']\").css(\'display\', \'none\');\n\t\t\t$(\"[data-class=\'Expandable\" + HeaderName + \"\']\").removeClass(\n\t\t\t\t\t\'prContentTableSelectedTheme\').addClass(\n\t\t\t\t\t\'prContentTableTheme\');\n\t\t} else {\n\t\t\tobjImg.src = \"../images/Collapseview.png\";\n\t\t\t$(\"[data-class = \'\" + HeaderName + \"\']\").css(\'display\', \'block\');\n\t\t\t$(\"[data-class=\'Expandable\" + HeaderName + \"\']\").removeClass(\n\t\t\t\t\t\'prContentTableTheme\').addClass(\n\t\t\t\t\t\'prContentTableSelectedTheme\');\n\t\t}\n\t\tvar src = \"../images/Expanded group Icon.png\";\n\t\t// $(\"[data-image = \'\" + HeaderName + \"\']\").css(\'background\', \'url(\' + src + \')\'); \n\t\t$(\"[data-image = \'\" + HeaderName + \"\']\").attr(\"src\", src);\n\n\n\t\tif (prMainScroll != null)\n\t\t\tprMainScroll.refresh();\n\t\t\n\t\tif(prevResScroll !=null)\n\t\t\tprevResScroll.refresh();\n\t\t\n\t\t//assignDetResVScroll();\n\t\tif (detResScroll != null) {\n\t\t\tdetResScroll.refresh();\n\t\t}\n\n\t}\n\t\n\n\n\tfunction DetailedResultExpand(expUIMarker) {\n\n\t\t$(\"[data-fulldet = \'detResCompressCol\" + expUIMarker + \"\']\").css(\n\t\t\t\t\'width\', \'50%\');\n\t\t$(\"[data-fulldet = \'detResHideCol\" + expUIMarker + \"\']\").css(\'display\',\n\t\t\t\t\'none\');\n\t\t$(\"[data-fulldet = \'detResExpandCol\" + expUIMarker + \"\']\").css(\'width\',\n\t\t\t\tglobaldrWidth + \'px\');\n\t\t$(\"[data-fulldet = \'detResExpandCol\" + expUIMarker + \"\']\").css(\n\t\t\t\t\'display\', \'block\');\n\t\t$(\"[data-fulldet = \'detResExpandColHead\" + expUIMarker + \"\']\").css(\n\t\t\t\t\'display\', \'block\');\n\t\t$(\"[data-fulldet = \'detResCloseCol\" + expUIMarker + \"\']\").css(\n\t\t\t\t\'display\', \'block\');\n\t\t$(\"[data-fulldet = \'detResExpandCol\" + expUIMarker + \"\'] .prevResScrollerDiv\").each(\n\t\t\t\tfunction() {\n\t\t\t\t\tvar recordNum = $(this).attr(\'data-patnum\');\n\t\t\t\t\t//Calculating the scroller width for each of the previous results div after loading detailed results. \n\t\t\t\t\t//This is required to make the horizontal iScroll scroll till the end of the contents\n\t\t\t\t\tif($(\'#prevResScroller\' + recordNum).find(\'.drRowContainerTheme table\').length < 1)\n\t\t\t\t\t{\n\t\t\t\t\t$(\'#prevResScroller\' + recordNum).load(\n\t\t\t\t\t\t\tdocument.getElementById(\"hdnDetailedResUrl\"\n\t\t\t\t\t\t\t\t\t+ recordNum).value,\n\t\t\t\t\t\t\tfunction() {\n\t\t\t\t\t\t\t\tvar scrollerWidth = $(\n\t\t\t\t\t\t\t\t\t\t\'#prevResScroller\' + recordNum).find(\n\t\t\t\t\t\t\t\t\t\t\'.drRowContainerTheme table\').width();\n\t\t\t\t\t\t\t\t//alert(recordNum + \' -  \' +scrollerWidth);\n\t\t\t\t\t\t\t\t$(\'#prevResScroller\' + recordNum).css(\'width\',\n\t\t\t\t\t\t\t\t\t\tscrollerWidth + \'px\');\n\t\t\t\t\t\t\t});\n\t\t\t\t\t}\n\t\t\t\t}); \n\n\t\t//assignPrevResHorizontalScroll();\n\t\t//assignDetResVScroll();\n\t\t\n\t\t//LoadPrevResDivs();\n\t\tif (prevResScroll != null) {\n\t\t\tprevResScroll.refresh();\n\t\t}\n\t\tif (detResScroll != null) {\n\t\t\tdetResScroll.refresh();\n\t\t} \n\t}\n\n\tfunction DetailedResultCompress(expUIMarker) {\n\t\t$(\"[data-fulldet = \'detResCompressCol\" + expUIMarker + \"\']\").css(\n\t\t\t\t\'width\', \'100%\');\n\t\t$(\"[data-fulldet = \'detResHideCol\" + expUIMarker + \"\']\").css(\'display\',\n\t\t\t\t\'block\');\n\t\t$(\"[data-fulldet = \'detResExpandCol\" + expUIMarker + \"\']\").css(\'width\',\n\t\t\t\t\'0%\');\n\t\t$(\"[data-fulldet = \'detResExpandCol\" + expUIMarker + \"\']\").css(\n\t\t\t\t\'display\', \'none\');\n\t\t$(\"[data-fulldet = \'detResExpandColHead\" + expUIMarker + \"\']\").css(\n\t\t\t\t\'display\', \'none\');\n\t\t$(\"[data-fulldet = \'detResCloseCol\" + expUIMarker + \"\']\").css(\n\t\t\t\t\'display\', \'none\');\n\t}\n\n\tfunction DetailedIndvResultExpand(recordCounter) {\n\n\t\t$(\"[data-indvdet = \'detResCompressCol\" + recordCounter + \"\']\").css(\n\t\t\t\t\'width\', \'50%\');\n\t\t$(\"[data-indvdet = \'detResArrowCol\" + recordCounter + \"\']\").css(\n\t\t\t\t\'display\', \'none\');\n\t\t$(\"[data-indvdet = \'detResCloseCol\" + recordCounter + \"\']\").css(\n\t\t\t\t\'display\', \'block\');\n\t\t$(\"[data-indvdet = \'detResExpandCol\" + recordCounter + \"\']\").css(\n\t\t\t\t\'width\', globaldrWidth + \'px\');\n\t\t$(\"[data-indvdet = \'detResExpandCol\" + recordCounter + \"\']\").css(\n\t\t\t\t\'display\', \'block\');\n\n\t\t//Calculating the scroller width for each of the previous results div after loading detailed results. \n\t\t//This is required to make the horizontal iScroll scroll till the end of the contents\n\t\tif($(\'#prevResScroller\' + recordCounter).find(\'.drRowContainerTheme table\').length < 1)\n\t\t{\n\t \t\t$(\'#prevResScroller\' + recordCounter).load(\n\t\t\t\t\tdocument.getElementById(\"hdnDetailedResUrl\"\n\t\t\t\t\t\t\t+ recordCounter).value,\n\t\t\t\t\tfunction() {\n\t\t\t\t\t\tvar scrollerWidth = $(\n\t\t\t\t\t\t\t\t\'#prevResScroller\' + recordCounter).find(\n\t\t\t\t\t\t\t\t\'.drRowContainerTheme table\').width();\n\t\t\t\t\t\t//alert(recordNum + \' -  \' +scrollerWidth);\n\t\t\t\t\t\t$(\'#prevResScroller\' + recordCounter).css(\'width\',\n\t\t\t\t\t\t\t\tscrollerWidth + \'px\');\n\t\t\t\t\t}); \n\t\t}\n\t\t//assignPrevResHorizontalScroll();\n\t\t//assignDetResVScroll();\n\t\t\n\t\t//LoadPrevResDivs();\n\t\tif (prevResScroll != null) {\n\t\t\tprevResScroll.refresh();\n\t\t}\n/* \t\tif (detResScroll != null) {\n\t\t\tdetResScroll.refresh();\n\t\t} */\n\t}\n\n\tfunction DetailedIndvResultCompress(recordCounter,recordGroup) {\n\t\t$(\"[data-indvdet = \'detResCompressCol\" + recordCounter + \"\']\").css(\n\t\t\t\t\'width\', \'100%\');\n\t\t$(\"[data-indvdet = \'detResArrowCol\" + recordCounter + \"\']\").css(\n\t\t\t\t\'display\', \'block\');\n\t\t$(\"[data-indvdet = \'detResCloseCol\" + recordCounter + \"\']\").css(\n\t\t\t\t\'display\', \'none\');\n\t\t$(\"[data-indvdet = \'detResExpandCol\" + recordCounter + \"\']\").css(\n\t\t\t\t\'width\', \'0%\');\n\t\t$(\"[data-indvdet = \'detResExpandCol\" + recordCounter + \"\']\").css(\n\t\t\t\t\'displa";
    private final static byte[]  _wl_block1_1Bytes = _getBytes( _wl_block1_1 );

    private final static java.lang.String  _wl_block1_2 ="y\', \'none\');\n\t\t//when all previous results are closed, header is also collapsed\n\t\tif($(\"[data-fulldet = \'detResExpandCol\" + recordGroup + \"\']:visible\").length == 0){\n\t\t\tDetailedResultCompress(recordGroup);\n\t\t}\n\t\t\t\n\t}\n\n\tfunction toggleLegend() {\n\t\t$(\'#legendContainer\').toggle();\n\t}\n\n\tfunction showPeriodSelect() {\n\t\t$(\"#periodSelect\").css(\'z-index\', \"1000\");\n\t\t$(\"#periodArrow\").css(\'z-index\', \"2000\");\n\t\t$(\'#periodSelect\').toggle();\n\t\t$(\'#periodArrow\').toggle();\n\t}\n\tfunction selectPeriod(sPeriod) {\n\t\tshowPeriodSelect();\n\t\tdocument.getElementById(\"hdnSelectedPeriod\").value = sPeriod;\n\t\tdocument.getElementById(\"hdnFromPeriod\").value = sPeriod;\n\t\tsearchPendingResults();\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body style= \"width:100%; height:100%;\">\n\t<div id = \"sfsarrow\" data-role = \"none\" class = \"pr-sfs-bubble-arrow sfs-bubble-arrowIPTheme\" ></div>\n   \t<div data-role = \"none\" class = \"pr-sfs sfsIPTheme\"  id = \"sfs\" >\n  \t \t<iframe id = \"sfsFrame\" frameborder=\"0\" style = \"display:block;\" scrolling =\"no\" height = \"300px\" width = \"400px\" src = \"\"></iframe>  \n   \t</div> \n\t<div id = \"periodArrow\" data-role = \"none\" class = \"periodSelectArrow periodSelectArrowTheme\" ></div>\n   \t<div data-role = \"none\" class = \"periodSelectContainer periodSelectContainerTheme\"  id = \"periodSelect\" >\n\t\t\t<table cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t<tr><td><div class=\"periodSelectRowNormal periodSelectRowNormalTheme\" onclick=\"selectPeriod(\'LOD\')\">Last One Day</div></td></tr>\n\t\t\t\t<tr><td><div class=\"periodSelectRowNormal periodSelectRowNormalTheme\" onclick=\"selectPeriod(\'LTD\')\">Last Three Days</div></td></tr>\n\t\t\t\t<tr><td><div class=\"periodSelectRowNormal periodSelectRowNormalTheme\" onclick=\"selectPeriod(\'LOW\')\">Last One Week</div></td></tr>\n\t\t\t\t<tr><td><div class=\"periodSelectRowNormal periodSelectRowNormalTheme\" onclick=\"selectPeriod(\'LOM\')\">Last One Month</div></td></tr>\n\t\t\t\t<tr><td><div class=\"periodSelectRowNormal periodSelectRowNormalTheme\" onclick=\"selectPeriod(\'LOY\')\">Last One Year</div></td></tr>\n\t\t\t</table>\n   \t</div> \n\t<div data-role = \"page\" style = \"padding:0px;width:100%;height:100%;\">\n\n\t\t<form name=\'PendingResultsForm\' id=\'PendingResultsForm\' method=\'post\' id=\"PendingResultsForm\" style = \"width:100%;height:100%;\">\n\n\t\t\t<div class =\"prHeader\">\n\t\t\t\t<div class=\"prHeaderMenuContainer1 prHeaderMenuContainer1Theme\">\n\t\t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t<td style = \"width:7%; padding-left:5px;\">\n\t\t\t        \t\t\t<div class = \"WidgetButtonTheme\" onclick=\"toggleMenuPR()\"><img src = \"../images/MenuIcon.png\"/></div>\n\t\t\t   \t\t\t\t</td>\n\t\t\t    \t\t\t<td style = \"width:73%\">\n\t\t\t         \t\t\t<div class = \"prHeaderPageTitle prHeaderPageTitleTheme\">Pending Results Review</div>\n\t\t\t   \t\t\t\t</td>\n\t\t\t\t\t   \t\t<td style = \"width:20%\">\n\t\t\t\t\t         \t\t<div class=\"prHeaderSearchPatientText prHeaderSearchPatientTextTheme\">\n\t\t\t\t\t         \t\t<table cellpadding = \"0\" cellspacing = \"0\" border = \"0\"><tr>\n\t\t\t\t\t\t\t\t   \t<td style=\"width:5%; padding-top:5px\"><img src=\"../images/Search.png\" onclick=\"searchPendingResults()\" style=\"margin-left:5px;\"/></td>\n\t\t\t\t\t\t\t\t    <td style=\"width:90%;\">\n\t\t\t\t\t\t\t\t        <input type=\"text\" name = \"PatientIdText\" id = \"PatientIdText\"  placeholder=\"Patient ID\"  class=\"prHeaderSearchPatientTxtBox prHeaderSearchPatientTxtBoxTheme\" value = \"";
    private final static byte[]  _wl_block1_2Bytes = _getBytes( _wl_block1_2 );

    private final static java.lang.String  _wl_block2 ="\">\n\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t   \t<td style=\"width:5%; padding-top:5px;padding-right:6px\"><img src=\"../images/Close-small.png\" style=\"padding-right: 10px\" onclick=\"clearPatientIdText()\"/></td>\n\t\t\t\t\t\t\t\t   \t</tr></table>\n\t\t\t\t\t\t\t\t   \t</div>\n\t\t\t\t\t   \t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t    \t\t</table>\n\t\t\t\t</div>\n\n\t  \t\t\t<div class = \"prHeaderMenuContainer2\">\n\t  \t\t\t\t<div  data-role =\"none\" class =\"prContentHolderHeader prContentHolderHeaderTheme\">\n\t\t\t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  \t\t\t\t<tr style = \"height:100%;width:100%\" align=\"center\" valign=\"middle\">\n\t\t\t\t\t\t\t\t<td style = \"width:4%\">\n\t\t\t\t\t\t\t         <div class=\"prCheckboxContainer\"><input type=\"checkbox\" name=\"selectAll\" id=\"selectAll\" id=\"selectAll\" value=\"selectAll\" onchange=\"selectAllRecords()\" class=\"prCheckboxTheme\"></div>\n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td style = \"width:8%\">\n\t\t\t\t\t\t\t         <div class = \"WidgetButtonTheme\" onclick=\"showPracSfs()\"><img src = \"../images/Forward.png\"/></div>\n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td style = \"width:4%\"></td>\n\t\t\t\t\t\t\t    <td style = \"width:8%\">\n\t\t\t\t\t\t\t         <div class = \"WidgetButtonTheme\" onclick=\"completeReview()\"><img src = \"../images/ReviewComplete.PNG\"/></div>\n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td style = \"width:20%\">\n\n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td style = \"width:30%\"><div class = \"prHeaderMenu2ButtonsTheme\" onclick=\"showPeriodSelect()\">";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</div></td>\n\t\t\t\t\t\t\t    <td style = \"width:15%\" align = \"right\" valign = \"center\">\n\t\t\t\t\t\t\t    \t<table class= \"prContentHolderIconContainer\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t\t\t\t    <tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class = \"prContentHolderIconTheme\" onclick=\"setNormalcy(\'S\')\" id=\"normalcyAll\"><img src = \"../images/view01.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t<td class = \"prContentHolderIconTheme\" onclick=\"setNormalcy(\'N\')\" id=\"normalcyNormal\"><div class=\"prNormalcyNormalTheme\"></div></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"prContentHolderIconTheme\" onclick=\"setNormalcy(\'A\')\" id=\"normalcyAbnormal\"><div class=\"prNormalcyAbnormalTheme\"></div></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"prContentHolderIconTheme\" onclick=\"setNormalcy(\'C\')\" id=\"normalcyCritical\"><div class=\"prNormalcyCriticalTheme\"></div></td>\n\n\t\t\t\t\t\t\t\t        </tr>\n\t\t\t\t\t\t        \t</table>\t\n\t\t\t\t\t\t    \t</td>\n\t\t\t \t\t\t\t</tr>\n\t\t    \t\t\t</table>\t  \n\t  \t\t\t\t</div>\n\t  \t\t\t</div>\n\t  \t\t</div>\n\n\n\t\n\t\t<div id = \'divcnt\'  class = \'divPRcontent divPRcontentTheme\' >\n\t\t\t<div style = \"width:100%;height:auto;overflow:auto\" >\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t<script>\n\t\t\t\talert(\"Could not complete the review.\");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<script>\n\t\t\t\talert(\"Could not complete the review. Error in getting result from EJB layer \");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<script>\n\t\t\t\talert(\"Could not forward the result.\");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\talert(\"Successfully forwarded the result.\");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\talert(\"Could not forward the result. Error in getting result from EJB layer \");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\n\t\t\t\n\t\t\t<span class=\"prSearchResultsEmptyTheme\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\n\t\t\t\n\n\t\t\t<input type=\"hidden\" id=\"hdnTotalRecords\" name=\"hdnTotalRecords\" id=\"hdnTotalRecords\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n\t\t\t\n\t\t\t\t<table class = \"prContentTable prContentTableTheme\" cellpadding = \"0\" cellspacing = \"0\"  border = \"0\" data-class=\"Expandable";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t<tr class=\"prResultsHeader\">\n\t\t\t\t\t<td style=\'width: 4%\' align=\"center\" valign=\"middle\"> \n\t\t\t\t\t\t<div class=\"prCheckboxContainer\">\n\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"checkc";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" name=\"checkc";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onchange=\"selectAllPatientCategories(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\" value=\"\" class=\"prCheckbox prCheckboxTheme\">\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td style=\'width: 96%\' align=\'left\'>\n\t\t\t\t\t\t<table style=\"width: 100%;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" onclick=\"DisplayOrHideDetails(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' , this)\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td style=\'width: 88%\' align=\'left\'>\n\t\t\t\t\t\t\t\t<div class=\"prTxtRowsBold prTxtRowsBoldTheme\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</div>\n\t\t\t\t\t\t\t\t<div class=\"prTxtRows prTxtRowsTheme\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div>\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td style=\"width:6%\" align=\"center\">\n\t\t\t\t\t\t\t\t\t<div><input type=\"button\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" class=\"prCountButtonTheme\"> </div>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td style=\"width:6%\" align=\"center\">\n\t\t\t\t\t\t\t\t\t<div><img id=\"expander";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" src=\"../images/Expandview.png\"/></div>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\t\t\t\t\n\t\t\t\t<div data-role=\"none\" data-class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" style=\"display: none;position:relative\">\n\t\t\t\t\t\t<div style=\"border: 1px solid #afb0b0;position:relative\">\n\n\t\t\t\t\t\t\t<div class=\"prDetailedResultsExpandedContainer\" style=\"overflow:hidden;position:relative\">\n\t\t\t\t\t\t\t\t<div id=\"prDetailedResultsHeader\" style=\"position: relative; float: left; display: block; width: 100%\" data-fulldet=\"detResCompressCol";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t\t\t\t\t\t<table style=\"width: 100%;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%;\" class=\"prResultCategoryHeader prResultCategoryHeaderTheme\">\n\t\t\t\t\t\t\t\t\t\t\t<td style=\'width: 3%\' align=\"center\" valign=\"middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"prCheckboxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"checkb";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" name=\"checkb";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" onchange=\"selectPatientCategories(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\')\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" data-patient=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" class=\"prCheckbox prCheckboxTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\'width: 80%\' align=\'left\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"prResultCategoryTextStyleTheme\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 7%\" align=\'left\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" class=\"prCountButtonTheme\"> \n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\'width: 10%\' align=\'right\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"prDetailedResultsToggleIcon\" data-fulldet=\"detResHideCol";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onclick=\"DetailedResultExpand(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../images/ResultOpen.PNG\" />\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div style=\"position: relative; float: right; display: none; width: 0%;\" class=\"drResultCategoryHeader drResultCategoryHeaderTheme\" data-fulldet=\"detResExpandColHead";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t\t\t\t\t\t<div class=\"drDetailedResultsToggleIcon\" onclick=\"DetailedResultCompress(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\')\">\n\t\t\t\t\t\t\t\t\t\t<img src=\"../images/ResultClose.PNG\" />\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\n\t\t\t\t\t\t\t\t<div id=\"wrapperNested";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" class=\"wrapperNested\" style=\"position:relative;width:100%;overflow:hidden;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="height:325px; ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t\t\t\t\t\t<div id=\"scrollerNested\" class=\"scrollerNestedDiv\" style=\"height:auto;width:100%;overflow:hidden\">\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnPatientId";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"hdnPatientId";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" />\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnEventClass";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"hdnEventClass";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" />\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnEventCode";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"hdnEventCode";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" /> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnEventGroup";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"hdnEventGroup";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" />\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnHistRectType";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"hdnHistRectType";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" />\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnNormalcyIndicator";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"hdnNormalcyIndicator";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" /> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnControlSysId";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"hdnControlSysId";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" /> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnAccessionNum";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"hdnAccessionNum";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" /> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnReviewRemarks";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"hdnReviewRemarks";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" value=\"\" /> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnReviewType";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"hdnReviewType";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" />\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnCreationDateTime";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"hdnCreationDateTime";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" /> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnControlSysEventCode";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"hdnControlSysEventCode";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" /> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnEncounterId";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"hdnEncounterId";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" />\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnDetailedResUrl";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"hdnDetailedResUrl";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" />\n\n\n\t\t\t\t\t\t\t\t<div class=\"prDetailedResultsStrip prDetailedResultsStripTheme\" data-role=\"none\" data-class=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" style=\"display: block; position: relative; float: left; width: 100%\" data-childrows=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" data-fulldet=\"detResCompressCol";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" data-indvdet=\"detResCompressCol";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t\t\t\t\t\t<table style=\'width: 100%; height: 100%\' border=\'0\'\n\t\t\t\t\t\t\t\t\t\tcellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t\t\t\t\t\t\t\t<tr style=\'width: 100%; height: 100%\'>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\'width: 3%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"prCheckboxContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"prCheckboxTheme\" id=\'check";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' name=\'check";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' value=\"check\" data-patient=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" data-patientcat=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\'width: 3%\' class=\"prDetailedResultsNormalcy\" valign=\"middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div></div> ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"prNormalcyAbnormalTheme\"></div> ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"prNormalcyCriticalTheme\"></div> ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"prNormalcyNormalTheme\"></div> ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 80%\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t<table style=\'width: 100%; height: 100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"prDetailedResultsTextStyle1Theme\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"prDetailedResultsTextStyle2Theme\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 5%\" align=\"center\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div onclick=\"DetailedIndvResultExpand(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\')\" data-fulldet=\"detResHideCol";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" data-indvdet=\"detResArrowCol";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../images/Right_Arrow.png\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div onclick=\"DetailedIndvResultCompress(\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\',\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\')\" data-fulldet=\"detResCloseCol";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" data-indvdet=\"detResCloseCol";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" style=\"display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../images/CloseDark.png\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\n\n\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"drExpandableColsTheme prevResWrapperDiv\"\n\t\t\t\t\t\t\t\t\tstyle=\"position: relative; float: right; display: none; width: 0%; height: 63px; background-color: #143E4F; border-bottom: 1px solid #C7CFD2; border-top: 1px solid #FFFFFF;\"\n\t\t\t\t\t\t\t\t\tdata-fulldet=\"detResExpandCol";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"\n\t\t\t\t\t\t\t\t\tdata-indvdet=\"detResExpandCol";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"wrapper";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\n\t\t\t\t\t\t\t\t\t<div id=\"prevResScroller";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" class=\"prevResScrollerDiv\" data-patnum=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\n\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div> </div> <!-- </div> -->\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\n\t\t\t\t</div>\n\t\t\t\t<div class=\"legendToggler legendTogglerTheme\" onclick=\"toggleLegend()\">\n\t\t\t\t\t<img src=\"../images/LegendIcon.png\" style=\"padding:10px 10px 10px 22px;\" />\n\t\t\t\t</div>\n\t\t\t\t<div class=\"legendContainer\" id=\"legendContainer\">\n\t\t\t\t\t<table class=\"tblegends tblegendsTheme\" border=\"0\" cellpadding=\"\" cellspacing=\"\">\n\t\t\t\t\t\t<tr style=\"width: 100%; height: 100%;\">\n\t\t\t\t\t\t\t<td style=\"width: 20px; height: 100%; padding-left: 5px;\">\n\t\t\t\t\t\t\t\t<div class=\"prNormalcyCriticalTheme\"></div>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td style=\"width: auto; height: 100%;\" class=\"legendTextFooterTheme\">Critical</td>\n\t\t\t\t\t\t\t<td style=\"width: 20px; height: 100%; padding-left: 5px;\">\n\t\t\t\t\t\t\t\t<div class=\"prNormalcyAbnormalTheme\"></div>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td style=\"width: auto; height: 100%;\" class=\"legendTextFooterTheme\">Abnormal</td>\n\t\t\t\t\t\t\t<td style=\"width: 20px; height: 100%; padding-left: 5px;\">\n\t\t\t\t\t\t\t\t<div class=\"prNormalcyNormalTheme\"></div>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td style=\"width: auto; height: 100%\">Normal</td>\n\t\t\t\t\t\t\t<td style=\"width: 40%; height: 100%\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</div>\n\n\t\t\t<input type=\"hidden\" id=\"hdnPatientCounter\" name=\"hdnPatientCounter\" id=\"hdnPatientCounter\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnFromPeriod\" id=\"hdnFromPeriod\" id=\"hdnFromPeriod\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" />\n\t\t\t<input type=\"hidden\" name=\"hdnToPeriod\" id=\"hdnToPeriod\" id=\"hdnToPeriod\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnNormalcyVal\" id=\"hdnNormalcyVal\" id=\"hdnNormalcyVal\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnPatientId\" id=\"hdnPatientId\" id=\"hdnPatientId\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnSearchClicked\" id=\"hdnSearchClicked\" id=\"hdnSearchClicked\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" /> <input type=\"hidden\" name=\"hdnGroupby\" id=\"hdnGroupby\" id=\"hdnGroupby\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnCANormalcyInd\" id=\"hdnCANormalcyInd\" id=\"hdnCANormalcyInd\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" />\n\t\t\t<input type=\"hidden\" name=\"hdnGetTaskApplicability\" id=\"hdnGetTaskApplicability\" id=\"hdnGetTaskApplicability\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnSelectedPeriod\" id=\"hdnSelectedPeriod\" id=\"hdnSelectedPeriod\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" /> \n\t\t\t<input type=\"hidden\" ame=\"hdnPractDesc\" id=\"hdnPractDesc\" value=\"\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnPractCode\" id=\"hdnPractCode\" id=\"hdnPractCode\" value=\"\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnCompleteReviewClicked\" id=\"hdnCompleteReviewClicked\" id=\"hdnCompleteReviewClicked\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" />\n\t\t\t<input type=\"hidden\" name=\"hdnForwardReviewClicked\" id=\"hdnForwardReviewClicked\" id=\"hdnForwardReviewClicked\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnSelectedRows\" id=\"hdnSelectedRows\" id=\"hdnSelectedRows\" value=\"\" />\n\n\n\t\t</form>\n\n\t\t<!-- \t <div data-role=\"none\" id=\'Dialog\' style=\"width:100%; height:auto;display:none;background:#ffffff;\">\n    \t <iframe src = \"\" width = \"100%\" height = \"1000px\" scrolling = \"yes\" id=\"srchFrame\" frameborder=\"0\"></iframe>  \n\t </div> -->\n\n\t</div>\n\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	// from and to period is not useful as of now but having such 
	// properties in the request helps when the from and to time period
	// components are introduced
	String fromPeriod = request.getParameter("hdnFromPeriod");
	fromPeriod = CommonBean.checkForNull(fromPeriod,
			IPADConstants.LAST_ONE_WEEK);
	if (fromPeriod.trim().equals("")) {
		fromPeriod = IPADConstants.LAST_ONE_WEEK;
	}

	String toPeriod = request.getParameter("hdnTPeriod");
	toPeriod = CommonBean.checkForNull(toPeriod);

	String selectedPeriod = request.getParameter("hdnSelectedPeriod");//hdnSelectedPeriod
	selectedPeriod = CommonBean.checkForNull(selectedPeriod,
			IPADConstants.LAST_ONE_WEEK);
	
	String selectedPeriodText="";
	if(selectedPeriod.equals("LOD")){
		selectedPeriodText="Last One Day";
	}
	else if(selectedPeriod.equals("LTD")){
		selectedPeriodText="Last Three Days";
	}
	else if(selectedPeriod.equals("LOM")){
		selectedPeriodText="Last One Month";
	}
	else if(selectedPeriod.equals("LOY")){
		selectedPeriodText="Last One Year";
	}
	else{
		selectedPeriodText="Last One Week";
	}

	String searchClicked = request.getParameter("hdnSearchClicked");
	if (searchClicked == null || searchClicked.trim().equals("")) {
		searchClicked = "Y";
	}

	String normalcy = "";
	String patientId = "";
	// if search button is clicked then this page is reloaded
	// hence the need to set the patient id and the normalcy
	// comes in this case only
	if ("Y".equalsIgnoreCase(searchClicked)) {
		// changed to get the patient id from the patient text
		if(request.getParameter("hdnPatientId") != null && request.getParameter("hdnPatientId") != "")
		{
			patientId = ((String)request.getParameter("hdnPatientId")).trim().toUpperCase();
		}
		patientId = CommonBean.checkForNull(patientId);
		normalcy = request.getParameter("hdnNormalcyVal");
		normalcy = CommonBean.checkForNull(normalcy, "Z");
	} else {
		normalcy = request.getParameter("hdnNormalcyVal");
		normalcy = CommonBean.checkForNull(normalcy, "Z");
	}

	String groupby = request.getParameter("hdnGroupby");
	groupby = CommonBean.checkForNull(groupby);
	//String caNormalcyInd = request.getParameter("normalcy_ind");
	//caNormalcyInd = CommonBean.checkForNull(caNormalcyInd,"Z");
	String getTaskApplicability = request
			.getParameter("hdnGetTaskApplicability");
	getTaskApplicability = CommonBean
			.checkForNull(getTaskApplicability);

	// this will store the complete review clicked status
	String completeReviewClicked = request
			.getParameter("hdnCompleteReviewClicked");
	completeReviewClicked = CommonBean.checkForNull(
			completeReviewClicked, "N");

	// this will store the forward review clicked status
	String forwardReviewClicked = request
			.getParameter("hdnForwardReviewClicked");
	forwardReviewClicked = CommonBean.checkForNull(
			forwardReviewClicked, "N");

	String selectedRows = request.getParameter("hdnSelectedRows");
	selectedRows = CommonBean.checkForNull(selectedRows);

            _bw.write(_wl_block1_0Bytes, _wl_block1_0);
            _bw.write(_wl_block1_1Bytes, _wl_block1_1);
            _bw.write(_wl_block1_2Bytes, _wl_block1_2);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(selectedPeriodText ));
            _bw.write(_wl_block3Bytes, _wl_block3);

		PendingResultsResponse pendingResultsResponse = null;
		Map<PatientDetail, PendingResultForPatient> pendingResultMap = null;
		int recordCounter = 1;
		// this will contain the total records obtained
		int totalRecords = 0;
		// code should be put here to complete the review if
		// user has clicked on complete review button
		// same way handle the forward to practitioner request
		if ("Y".equalsIgnoreCase(completeReviewClicked)) {
			String hist_rec_type = "";
			String contr_sys_id = "";
			String contr_sys_event_code = "";
			String accession_num = "";
			String review_type = "";
			String create_date_time = "";
			String review_remarks = "";

			String practitionerId = (String) session
					.getValue("ca_practitioner_id");
			StringTokenizer stTokenizer = new StringTokenizer(selectedRows,
					",");
			String token = null;
			String record[] = null;
			int selectionCounter = 0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			int commaIndex = selectedRows.indexOf(",");
			if(commaIndex < 0 && !selectedRows.trim().equals("")){
				token = selectedRows;
				hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
				contr_sys_id = request.getParameter("hdnControlSysId"
						+ token);
				contr_sys_event_code = request
						.getParameter("hdnControlSysEventCode" + token);
				accession_num = request.getParameter("hdnAccessionNum"
						+ token);
				review_type = request.getParameter("hdnReviewType"
						+ token);
				create_date_time = request
						.getParameter("hdnCreationDateTime" + token);
				review_remarks = request
						.getParameter("hdnReviewRemarks" + token);

				record = new String[7];
				record[0] = hist_rec_type;
				record[1] = contr_sys_id;
				record[2] = contr_sys_event_code;
				record[3] = accession_num;
				record[4] = review_type;
				record[5] = create_date_time;
				record[6] = review_remarks;

				// this is the key used in the desktop application
				// and only this key is understood by the ejb
				dataMap.put("review_data" + selectionCounter, record);
				selectionCounter++;
			}
			else{
				if (stTokenizer != null) {
					while (stTokenizer.hasMoreTokens()) {
						token = stTokenizer.nextToken();
						token = token.trim();
	
						// now get the individual fields
						hist_rec_type = request.getParameter("hdnHistRectType"
								+ token);
						contr_sys_id = request.getParameter("hdnControlSysId"
								+ token);
						contr_sys_event_code = request
								.getParameter("hdnControlSysEventCode" + token);
						accession_num = request.getParameter("hdnAccessionNum"
								+ token);
						review_type = request.getParameter("hdnReviewType"
								+ token);
						create_date_time = request
								.getParameter("hdnCreationDateTime" + token);
						review_remarks = request
								.getParameter("hdnReviewRemarks" + token);
	
						record = new String[7];
						record[0] = hist_rec_type;
						record[1] = contr_sys_id;
						record[2] = contr_sys_event_code;
						record[3] = accession_num;
						record[4] = review_type;
						record[5] = create_date_time;
						record[6] = review_remarks;
	
						// this is the key used in the desktop application
						// and only this key is understood by the ejb
						dataMap.put("review_data" + selectionCounter, record);
	
						selectionCounter++;
					}
				}
			}

			// now set the practitioner id, login id and the total count
			// in this case, login id and practitioner id are the same
			dataMap.put("pract_id", practitionerId);
			dataMap.put("login_by_id", practitionerId);
			dataMap.put("totalCount", "" + selectionCounter);

			Map<String, String> sqlMap = new HashMap<String, String>();
			try {
				sqlMap.put("SQL_OR_RESULT_REVIEW_DELETE", OrRepository
						.getOrKeyValue("SQL_OR_RESULT_REVIEW_DELETE"));
				sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT", OrRepository
						.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT"));
				sqlMap.put(
						"SQL_OR_RESULT_REVIEW_REVIEWED_PRACT",
						OrRepository
								.getOrKeyValue("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT"));
			} catch (Exception e) {
				e.printStackTrace();
				// nothing much can be done here
			}
			// get the properties to be passed to EJB from session
			Properties jdbc_props = (Properties) session.getValue("jdbc");
			dataMap.put("properties", jdbc_props);

			Object home = null;
			Object busObj = null;
			Object argArray[] = null;
			Map<String, Object> map = new HashMap<String, Object>();
			try{
				home = ServiceLocator.getInstance().getHome(
						OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI"),
						ORReviewResultHome.class, true);
				busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);

				argArray = new Object[2];
				argArray[0] = dataMap;
				argArray[1] = sqlMap;
				Class[] paramArray = new Class[2];
				paramArray[0] = dataMap.getClass();
				paramArray[1] = sqlMap.getClass();
				map = (HashMap) (busObj
						.getClass().getMethod("insert", paramArray)).invoke(
						busObj, argArray);

				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
				
				Object result = map.get("result");
				if(result instanceof Boolean){
					if(!((Boolean)result).booleanValue()){
				
            _bw.write(_wl_block4Bytes, _wl_block4);
		
					}
				}else{
				
            _bw.write(_wl_block5Bytes, _wl_block5);

				}
				
				// set the search clicked so that new set of pending results
				// are fetched from db
				if("Y".equalsIgnoreCase(searchClicked)){
					searchClicked = "Y";
				}
			}catch(Exception ex){
				ex.printStackTrace();	
			}
			
		}

		// this code is for forward functionality
		if ("Y".equalsIgnoreCase(forwardReviewClicked)) {

			String hist_rec_type = "";
			String contr_sys_id = "";
			String event_code = "";
			String accession_num = "";
			String review_type = "";
			String create_date_time = "";
			String review_remarks = "";
			String normalcy_ind = "";

			String practitionerId = (String) session
					.getValue("ca_practitioner_id");
			StringTokenizer stTokenizer = new StringTokenizer(selectedRows,
					",");
			String token = null;
			String record[] = null;
			int selectionCounter = 0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			// this list will have the details of all the records
			// being forwarded
			List<Map<String,String>> forwardPractDetailsList = new ArrayList<Map<String,String>>();
			// Map will have the details about one record being forwarded
			Map<String,String> forwardPractDetailsMap = new HashMap<String,String>();
			
			int commaIndex = selectedRows.indexOf(",");
			if(commaIndex < 0 && !selectedRows.trim().equals("")){
				token = selectedRows;
				hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
				contr_sys_id = request.getParameter("hdnControlSysId"
						+ token);
				event_code = request
						.getParameter("hdnEventCode" + token);
				accession_num = request.getParameter("hdnAccessionNum"
						+ token);
				review_type = request.getParameter("hdnReviewType"
						+ token);
				normalcy_ind = request.getParameter("hdnNormalcyIndicator"+token);
				
				forwardPractDetailsMap.put("hist_rec_type", hist_rec_type);
				forwardPractDetailsMap.put("contr_sys_id", contr_sys_id);
				forwardPractDetailsMap.put("accession_num", accession_num);
				forwardPractDetailsMap.put("review_type", review_type);
				forwardPractDetailsMap.put("event_code", event_code);
				forwardPractDetailsMap.put("normalcy_ind", normalcy_ind);
				
				forwardPractDetailsList.add(forwardPractDetailsMap);
				selectionCounter++;
			}
			else{
				if (stTokenizer != null) {
					while (stTokenizer.hasMoreTokens()) {
						token = stTokenizer.nextToken();
						token = token.trim();
	
						// now get the individual fields
						hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
						contr_sys_id = request.getParameter("hdnControlSysId"
								+ token);
						event_code = request
								.getParameter("hdnEventCode" + token);
						accession_num = request.getParameter("hdnAccessionNum"
								+ token);
						review_type = request.getParameter("hdnReviewType"
								+ token);
						normalcy_ind = request.getParameter("hdnNormalcyIndicator"+token);
						
						selectionCounter++;
					}
				}
			}

			// now form the forward practitioner id list
			List<String> forwardPractIdList = new ArrayList<String>();
			// get the practitioner id to forward the result
			// from the request parameter
			// presently the assumption is that this parameter will contain
			// only one practitioner id - in future, multiple practitioner
			// id selection can be also be supported by setting
			// a comma separated string in the parameter
			String forwardPractId = request.getParameter("hdnPractCode");
			forwardPractIdList.add(forwardPractId);
			dataMap.put("forwardPract_id",forwardPractIdList);
			
			// this is the key used in the desktop application
			// and only this key is understood by the ejb
			dataMap.put("forwardPractHash", forwardPractDetailsList);
			// now set the practitioner id, login id and the total count
			// in this case, login id and practitioner id are the same
			dataMap.put("pract_id", practitionerId);
			dataMap.put("login_by_id", practitionerId);
			// no need to send the total count as it is not needed
			//dataMap.put("totalCount", "" + selectionCounter);

			Map<String, String> sqlMap = new HashMap<String, String>();
			try {
				sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT",
						OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT") );
	            sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK",
	            		OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK") );
			} catch (Exception e) {
				e.printStackTrace();
				// nothing much can be done here
				
            _bw.write(_wl_block6Bytes, _wl_block6);

			}
			// get the properties to be passed to EJB from session
			Properties jdbc_props = (Properties) session.getValue("jdbc");
			dataMap.put("properties", jdbc_props);

			Object home = null;
			Object busObj = null;
			Object argArray[] = null;
			Map<String, Object> map = new HashMap<String, Object>();
			try{
				home = ServiceLocator.getInstance().getHome(
						OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI"),
						ORReviewResultHome.class, true);
				busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);

				argArray = new Object[2];
				argArray[0] = dataMap;
				argArray[1] = sqlMap;
				Class[] paramArray = new Class[2];
				paramArray[0] = dataMap.getClass();
				paramArray[1] = sqlMap.getClass();
				map = (HashMap) (busObj
						.getClass().getMethod("modify", paramArray)).invoke(
						busObj, argArray);

				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
				
				Object result = map.get("result");
				if(result instanceof Boolean){
					if(!((Boolean)result).booleanValue()){
				
            _bw.write(_wl_block6Bytes, _wl_block6);
		
					}else{
				
            _bw.write(_wl_block7Bytes, _wl_block7);
		
					}
				}else{
				
            _bw.write(_wl_block8Bytes, _wl_block8);

				}
				
				// set the search clicked so that new set of pending results
				// are fetched from db
				if("Y".equalsIgnoreCase(searchClicked)){
					searchClicked = "Y";
				}
			}catch(Exception ex){
				ex.printStackTrace();	
			}
			
		}

		int patientCounter = 0;
		
		if ("Y".equalsIgnoreCase(searchClicked)) {
			PendingResultsRequest pendingResultsRequest = new PendingResultsRequest();
			pendingResultsRequest.setRequest(request);
			pendingResultsRequest.setSession(session);
			pendingResultsRequest.setNormalcyIndicator(normalcy);
			pendingResultsRequest.setLocale(IPADConstants.LOCALE);

			PendingResults beanInst = new PendingResults();
			pendingResultsResponse = beanInst
					.getPendingResults(pendingResultsRequest);
			pendingResultMap = pendingResultsResponse
					.getPendingResultsMap();
			totalRecords = pendingResultsResponse.getTotalRecords();

			if (pendingResultMap == null || pendingResultMap.isEmpty()) {
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block10Bytes, _wl_block10);

					} else {
							Set<Entry<PatientDetail, PendingResultForPatient>> entrySet = pendingResultMap
									.entrySet();
							Iterator<Entry<PatientDetail, PendingResultForPatient>> iterator = entrySet
									.iterator();
							Entry<PatientDetail, PendingResultForPatient> entry = null;
							PatientDetail patientDetail = null;
							String patientDetailString = null;
							// this var is used as the parameter
							// passed to the expand or hide js function parameter
							// basically this var will contain the patient name
							// without single quote
							String patDtlStrForDisplay = null;
							int pendingResultCount = 0;

							
							
							PendingResultForPatient pendingResultForPatient = null;
							Map<ResultCategory, List<ResultDetail>> pendingResultMapForPatient = null;
							ResultCategory resultCategory = null;
							Entry<ResultCategory, List<ResultDetail>> resultCatEntry = null;
							while (iterator.hasNext()) {
								
								// increment the patient counter
								patientCounter++;
								
								entry = iterator.next();
								patientDetail = entry.getKey();
								patientDetailString = patientDetail.getPatientId();
								
								// code added to fix the bug where if the patient name
								// itself contains a single quote then the 
								// javascript function called to expand or hide does not
								// work - in fact the js function itself is not being called
								patDtlStrForDisplay = "";
								int charIndex = 0;
								int oldIndex = 0;
								while(true){
									charIndex = patientDetailString.indexOf("'",charIndex);
									if(charIndex < 0){
										break;
									}
									if(oldIndex < charIndex){
										oldIndex++;
									}
									patDtlStrForDisplay += patientDetailString.substring(oldIndex, charIndex);
									oldIndex = charIndex;
									charIndex++;
								}
								if(oldIndex > 0){
									patDtlStrForDisplay += patientDetailString.substring(oldIndex+1);	
								}else{
									patDtlStrForDisplay += patientDetailString;
								}
								
								
								patientDetailString += " ";
								patientDetailString += patientDetail.getAge();
								patientDetailString += ",";
								patientDetailString += patientDetail.getSex();
								patientDetailString += "    ";
								//patientDetailString += patientDetail.getPatientId();

								pendingResultForPatient = entry.getValue();
								pendingResultCount = pendingResultForPatient
										.getPendingRecordCountForPatient();
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patDtlStrForDisplay));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patientCounter));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientCounter));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patientCounter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patDtlStrForDisplay));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patientDetailString));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patientDetail.getPatientName()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pendingResultCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patDtlStrForDisplay));
            _bw.write(_wl_block21Bytes, _wl_block21);

					pendingResultMapForPatient = pendingResultForPatient
										.getPendingResultMapForPatient();
								Set<Entry<ResultCategory, List<ResultDetail>>> resultCatSet = pendingResultMapForPatient
										.entrySet();
								Iterator<Entry<ResultCategory, List<ResultDetail>>> resultCatItr = resultCatSet
										.iterator();
								List<ResultDetail> resultDetailList = null;
								int resCatCount = 0; //We use this variable for grouping the category results for the expandable view in UI

								while (resultCatItr.hasNext()) {
									resCatCount++;
									String expUIMarker = "P"+patientCounter+"R"+resCatCount;
									//patDtlStrForDisplay +="_R"+resCatCount;
									resultCatEntry = resultCatItr.next();
									resultCategory = resultCatEntry.getKey();
									//pendingResultCount = pendingResultForPatient.getPatientRecordCountForCategory(resultCategory);

									resultDetailList = resultCatEntry.getValue();
									if (resultDetailList != null
											&& !resultDetailList.isEmpty()) {
										
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patDtlStrForDisplay));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(resultDetailList.size()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patientCounter));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(resultCategory.getCategory()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(resultDetailList.size()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block35Bytes, _wl_block35);

									String DetResScrollerheight = "height:325px;";
								
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block37Bytes, _wl_block37);
 if(resultDetailList.size()>5){ 
            _bw.write(_wl_block38Bytes, _wl_block38);
} 
            _bw.write(_wl_block39Bytes, _wl_block39);

									String eventName = null;
									final String REPORTEDBY = "Reported by";
									final String AT = "at";
									String practitioner = null;
									String reportedTime = null;
									StringBuffer resultBuff = new StringBuffer();
									String resultNum = "";
									String resultNumUom = "";
									String completeResult = "";
									String notesType = null;
									String normalLow = "";
									String normalHigh = "";
									String resultStr = "";
									int recordIndex = 0;

									String patient_Id = null;
									String eventClass = null;
									String eventGroup = null;
									String eventCode = null;
									String histRecType = null;
									String normalcyInd = null;
									// extra parameters needed for processing
									String sysId = null;
									String accessionNum = null;
									String createDateTime = null;
									String reviewType = null;
									String controlSysEventCode = null;
									String encounterId = null;

									// iterate through the records and show the results
									for (ResultDetail resultDetail : resultDetailList) {

										patient_Id = resultDetail.getPatientId();
										patient_Id = CommonBean.checkForNull(patient_Id);
										eventClass = resultDetail.getEventClass();
										eventClass = CommonBean.checkForNull(eventClass);
										eventGroup = resultDetail.getEventGroup();
										eventGroup = CommonBean.checkForNull(eventGroup);
										eventCode = resultDetail.getEventCode();
										eventCode = CommonBean.checkForNull(eventCode);
										histRecType = resultDetail.getHistoryRecType();
										normalcyInd = resultDetail.getNormalcyInd();
										normalcyInd = CommonBean.checkForNull(normalcyInd);

										sysId = resultDetail.getSysId();
										sysId = CommonBean.checkForNull(sysId);

										accessionNum = resultDetail.getAccessionNum();
										accessionNum = CommonBean.checkForNull(accessionNum);

										createDateTime = resultDetail.getCreateDateTime();
										createDateTime = CommonBean.checkForNull(createDateTime);
										createDateTime = DateUtils.convertDate(createDateTime, "DMYHM", "en", "en");

										reviewType = resultDetail.getReviewType();
										reviewType = CommonBean.checkForNull(reviewType);

										controlSysEventCode = resultDetail.getContrSysEventCode();
										controlSysEventCode = CommonBean.checkForNull(controlSysEventCode);

										encounterId = resultDetail.getEncounterId();
										encounterId = CommonBean.checkForNull(encounterId);

										// this code will form the result string 
										// which needs to be shown in the GUI
										resultBuff.delete(0, resultBuff.length());
										eventName = resultDetail.getEventName();
										practitioner = resultDetail.getReportedBy();
										reportedTime = resultDetail.getReportedAt();
										resultBuff.append(REPORTEDBY).append(" ");
										resultBuff.append(practitioner).append(" ");
										resultBuff.append(AT).append(" ");
										resultBuff.append(reportedTime);

										notesType = resultDetail.getNotesType();
										resultStr = resultDetail.getResultStr();
										resultNum = resultDetail.getResultNum();
										resultNumUom = resultDetail.getResultNumUom();
										normalLow = resultDetail.getNormalLow();
										normalHigh = resultDetail.getNormalHigh();
										if ("NUM".equalsIgnoreCase(notesType)) {
											completeResult = resultNum + "&nbsp;&nbsp;" + resultNumUom + "&nbsp;&nbsp;" + "(" + normalLow + "-"
													+ normalHigh + ")";
										} else if ("STR".equalsIgnoreCase(notesType)) {

										}

										StringBuffer detResUrl = new StringBuffer("PreviousResultsData-newUI.jsp");
										detResUrl.append("?hdnSelectedPeriod=");
										detResUrl.append(fromPeriod);
										detResUrl.append("&hdnFromPeriod=");
										detResUrl.append(fromPeriod);
										detResUrl.append("&hdnToPeriod=");
										detResUrl.append(toPeriod);
										detResUrl.append("&hdnSearchClicked=");
										detResUrl.append(searchClicked);
										detResUrl.append("&hdnNormalcyVal=");
										detResUrl.append(normalcy);
										detResUrl.append("&hdnCANormalcyInd=");
										detResUrl.append(normalcy);
										detResUrl.append("&hdnPatient_Id=");
										detResUrl.append(patient_Id);
										detResUrl.append("&hdnGroupby=");
										detResUrl.append(groupby);
										detResUrl.append("&hdnGetTaskApplicability=");
										detResUrl.append(getTaskApplicability);
										detResUrl.append("&hdnPractDesc=");
										detResUrl.append("");
										detResUrl.append("&hdnPractCode=");
										detResUrl.append("");
										detResUrl.append("&hdnPatientid=");
										detResUrl.append(patient_Id);
										detResUrl.append("&hdnEventClass=");
										detResUrl.append(eventClass);
										detResUrl.append("&hdnEventCode=");
										detResUrl.append(eventCode);
										detResUrl.append("&hdnEventGroup=");
										detResUrl.append(eventGroup);
										detResUrl.append("&hdnHistRectType=");
										detResUrl.append(histRecType);
										detResUrl.append("&hdnNormalcyIndicator=");
										detResUrl.append(normalcyInd);
										detResUrl.append("&hdnEpisodeId=");
										detResUrl.append(encounterId);
										detResUrl.append("&hdnPatClass=");
										detResUrl.append("IP");
								
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(eventClass));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(eventCode));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(eventGroup));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(histRecType));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(normalcyInd));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sysId));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(accessionNum));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reviewType));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(createDateTime));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(controlSysEventCode));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(detResUrl));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(resultCategory.getCategory()));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(resultCategory.getCategory()));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(patientCounter));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block77Bytes, _wl_block77);

													if (normalcyInd.equals("") || normalcyInd.equals("Z") || normalcyInd.equals("S")) {
												
            _bw.write(_wl_block78Bytes, _wl_block78);

 													} else if (normalcyInd.equals("A")) {
												 
            _bw.write(_wl_block79Bytes, _wl_block79);

												 	} else if (normalcyInd.equals("C")) {
												 
            _bw.write(_wl_block80Bytes, _wl_block80);

												 	} else if (normalcyInd.equals("N")) {
												 
            _bw.write(_wl_block81Bytes, _wl_block81);

												 	}
 												
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(eventName));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(resultBuff.toString()));
            _bw.write(_wl_block84Bytes, _wl_block84);
            _bw.write(_wl_block85Bytes, _wl_block85);

													// TODO
													// need to get the count of previous results
													PreviousResultsRequest previousResultsRequest = new PreviousResultsRequest();
													previousResultsRequest.setRequest(request);
													previousResultsRequest.setSession(session);
													previousResultsRequest.setPatientId(patient_Id);
													previousResultsRequest.setLocale(IPADConstants.LOCALE);
													previousResultsRequest.setEventClass(eventClass);
													previousResultsRequest.setEventCode(eventCode);
													previousResultsRequest.setEventGroup(eventGroup);
													previousResultsRequest.setHistRectType(histRecType);
													previousResultsRequest.setMaskDates(true);

													PrevResultCountResponse prevResultCountResponse = beanInst.getPreviousResultsCount(previousResultsRequest);
													List<PrevResultDateContainer> previousResultsCountList = prevResultCountResponse.getPrevResultDateContainerList();
													if (previousResultsCountList != null && !previousResultsCountList.isEmpty()) {
												
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);

												 	}
												 
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(expUIMarker));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block97Bytes, _wl_block97);
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block100Bytes, _wl_block100);

									recordIndex++;
															// this is a global counter
															recordCounter++;
														}
								
            _bw.write(_wl_block101Bytes, _wl_block101);

						}
									}
								}

							}
						}
					
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(patientCounter));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(fromPeriod));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(toPeriod));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(normalcy));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(searchClicked));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(groupby));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(normalcy));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(getTaskApplicability));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(selectedPeriod));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(completeReviewClicked));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(forwardReviewClicked));
            _bw.write(_wl_block114Bytes, _wl_block114);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
