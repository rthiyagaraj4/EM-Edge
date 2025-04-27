package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.HealthObjects.InPatientContext;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eIPAD.HealthObjects.*;
import eIPAD.sfs.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __ipslidesfs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/IPSlideSFS.jsp", 1709118028005L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t\n<!DOCTYPE html>\n<html>\n<head>\n<title>IP View</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\"\n\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no\" />\n<!-- <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> -->\n\n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" /> \n<link rel=\"stylesheet\" href=\"../css/iPadNew_IP.css\" />\n<link rel=\"stylesheet\" href=\"../css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"../css/IPSlideSFS.css\" />\n<script src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/js/iscroll5/iscroll.js\"></script>\n<!-- <script type=\"application/javascript\" src=\"../js/iscroll.js\"></script> -->\n<script src=\"../jquery-1.9.1.min.js\"></script>\n<script src=\"../jquery.mobile-1.3.1.min.js\"></script>\n\n\n\n\n<script type=\"text/javascript\">\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n$.extend($.expr[\":\"], {\n\t\"containsIN\": function(elem, i, match, array) {\n\treturn (elem.textContent || elem.innerText || \"\").toLowerCase().indexOf((match[3] || \"\").toLowerCase()) >= 0;\n\t}\n\t});\n\nvar sfsScrollSP;\nvar sfsScrollPR;\nvar sfsScrollNU;\nvar sfsMainScroll;\nvar currentViewMore;\nvar viewLessHeight;\nvar arrSP = [];\nvar arrPR = [];\nvar arrNU = [];\nvar currentSearchText;\nvar path;\n\nfunction loaded() {\n\tsfsMainScroll=  new IScroll(\'#slSfsWrapperMain\', { scrollbars: true, click: true, mouseWheel: true, disableMouse: false, disablePointer: true } );\n\tsfsScrollPR = new IScroll(\'#slSfsWrapperPR\', { scrollbars: true, click: true,  mouseWheel: true, disableMouse: false, disablePointer: true  } );\n\tif($(\"#slSfsWrapperSP\").is(\":visible\")){\n\tsfsScrollSP = new IScroll(\'#slSfsWrapperSP\', { scrollbars: true, click: true,  mouseWheel: true, disableMouse: false, disablePointer: true  } );\n\t}\n\tif($(\"#slSfsWrapperNU\").is(\":visible\")){\n\tsfsScrollNU = new IScroll(\'#slSfsWrapperNU\', { scrollbars: true, click: true,  mouseWheel: true, disableMouse: false, disablePointer: true  } );\n\t}\n}\n\nfunction refreshMain(){\n\t\n\t$(\".SLSfsCircleVisibleTheme\").hide();\n\t$(\".slSfsAfterSelection\").hide();\n\tif($(\'#searchInputSFSSP\').length > 0)\n\t $(\'#searchInputSFSSP\').val(\'\');\n\tif($(\'#searchInputSFSPR\').length > 0)\n\t$(\'#searchInputSFSPR\').val(\'\');\n\tif($(\'#searchInputSFSNU\').length > 0)\n\t$(\'#searchInputSFSNU\').val(\'\');\n\tif($(\'#txtPatientId\').length > 0)\n\t\t$(\'#txtPatientId\').val(\'\');\n\t//document.getElementById(\"IpSearchForm\").submit();\n\tarrSP.splice(0,arrSP.length);\n\tarrPR.splice(0,arrPR.length);\n\tarrNU.splice(0,arrNU.length);\n\tparent.hideRows(arrSP,arrPR,arrNU);\n\tsfsMainScroll.refresh();\n\n\tvar loggedInUser = $(\'#hdnLoggedInUser\').val();\n\tvar loggedInUserDesc = $(\'#hdnLoggedInUserDesc\').val();\n\n\tselectedPract(loggedInUser, loggedInUserDesc,  \'SlectedPract\');\n\tparent.refresh();\n}\n\nfunction refresh(current,other1,other2){\n\tdocument.getElementById(\"searchInputSFS\"+current).value = \"\";\n\t$(\"#list\"+current).find(\".listItem\"+current).show();\n\t$(\".slSfsTickVisible\"+current).hide();\n\t$(\"#ref\"+current).addClass(\'sfsReloadDefault\');\n\tif(current==\'SP\'){\n\t\t$(\"#SPAfterSel\").empty();\n\t\tarrSP.splice(0,arrSP.length);\n\t\tsfsScrollSP.refresh();\n\t}\n\tif(current==\'PR\'){\n\t\t$(\"#PRAfterSel\").empty();\n\t\tarrPR.splice(0,arrPR.length);\n\t\tsfsScrollPR.refresh();\n\t}\n\tif(current==\'NU\'){\n\t\t$(\"#NUAfterSel\").empty();\n\t\tarrNU.splice(0,arrNU.length);\n\t\tsfsScrollNU.refresh();\n\t}\n\tif($(\"#AfterSelection\"+current).is(\":visible\")){\n\t\t$(\'#AfterSelection\'+current).empty();\n\t\t$(\"#AfterSelection\"+current).hide();\n\t}\n\tparent.hideRows(arrSP,arrPR,arrNU);\n}\n\nfunction enableSlideSfsIcon(){\n\tvar patientID = $(\"#txtPatientId\").val();\n\t\n\tif(patientID == \'\' || $.trim(patientID).length == 0)\n\t{\n\t\t$( \"#txtPatientIdSearchIcon\" ).removeClass( \"enableSlSfsSearchIcon\" ).addClass( \"slSfsSearchIcon\" );\n\t\t$(\"#ClearPatIdTxt\").hide();\n\t}\n\telse\n\t{\n\t\t$( \"#txtPatientIdSearchIcon\" ).removeClass( \"slSfsSearchIcon\" ).addClass( \"enableSlSfsSearchIcon\" );\t\t\n\t\t$(\"#ClearPatIdTxt\").show();\n\t}\n}\nfunction hideSlideSFS(){\n\tparent.hideSlideSFS();\n}\n\nfunction slidesfsSearchByPat(){\n\tvar patientID = $(\"#txtPatientId\").val();\n\tif(patientID != \'\' || $.trim(patientID).length != 0)\n\t\tparent.slideSearchByPat(patientID);\t\n}\n\nfunction viewMore(expand, collapse1, collapse2){\n\tcurrentViewMore = expand;\n\t$(\"#ViewMore\"+expand).hide();\n\t$(\"#ViewMore\"+collapse1).hide();\n\t$(\"#ViewMore\"+collapse2).hide();\n\t$(\"#ViewLess\"+expand).show();\n\t$(\"#textBox\"+collapse1).hide();\n\t$(\"#textBox\"+collapse2).hide();\n\t$(\"#content\"+collapse1).hide();\n\t$(\"#content\"+collapse2).hide();\n\tsetViewMoreHeight(expand,collapse1,collapse2);\n\tsfsMainScroll.refresh();\n\tif(expand == \"SP\"){\n\t\tsfsScrollSP.refresh();\n\t}\n\tif(expand == \"PR\"){\n\t\tsfsScrollPR.refresh();\n\t}\n\tif(expand == \"NU\"){\n\t\tsfsScrollNU.refresh();\n\t}\n}\nfunction viewLess(current,other1,other2){\n\tif(currentViewMore != \"\"){\n\t\t$(\"#ViewMore\"+current).show();\n\t\t$(\"#ViewMore\"+other1).show();\n\t\t$(\"#ViewMore\"+other2).show();\n\t\t$(\"#ViewLess\"+current).hide();\n\t\t$(\"#textBox\"+other1).show();\n\t\t$(\"#textBox\"+other2).show();\n\t\t$(\"#content\"+other1).show();\n\t\t$(\"#content\"+other2).show();\n\t\t$(\"#data\"+currentViewMore).height(viewLessHeight);\n\t\tif(currentViewMore == \"SP\"){\n\t\t\tsfsScrollSP.refresh();\n\t\t}\n\t\tif(currentViewMore == \"PR\"){\n\t\t\tsfsScrollPR.refresh();\n\t\t}\t\t\t\n\t\tif(currentViewMore == \"NU\"){\n\t\t\tsfsScrollNU.refresh();\n\t\t}\n\t}\n\tcurrentViewMore=\"\";\n\tsfsMainScroll.refresh();\n}\n\nfunction setViewMoreHeight(){\n\tvar fullHeight = $(\"#slSfsWrapperMain\").height();\n\tfullHeight = fullHeight - $(\"#headingSP\").height() - $(\"#headingPR\").height() - $(\"#headingNU\").height() + $(\"#heading\"+currentViewMore).height() - $(\"#textBoxSP\").height() - $(\"#textBoxPR\").height() - $(\"#textBoxNU\").height();\n\t$(\"#data\"+currentViewMore).height(fullHeight);\n}\n\n\n/*changed to single selection*/\nfunction showTick(val, type){ \nparent.addSpinner();\n\tif(type==\"SP\"){\t\n\t\t arrSP =[];\n\t\tif($(\"#slSfsTickSP\"+val).is(\":visible\")){\n\t\t\t $(\"#slSfsTickSP\"+val).hide();\n\t\t\t $(\'div[id^=\"slSfsTickSP\"]\').hide();\n\t\t}\n\t\telse{\n\t\t\tarrSP.push(val);\n\t\t\t$(\'div[id^=\"slSfsTickSP\"]\').hide();\n\t\t\t$(\"#slSfsTickSP\"+val).show();\n\t\t\t\t\n\t\t}\n\t\tparent.hideRows(arrSP,arrPR,arrNU);\n\t\tif($(\'#searchInputSFS\'+type).length > 0)\n\t\t\t$(\'#searchInputSFS\'+type).val(\'\');\n\t}\n\t\n\tif(type==\"NU\"){\t\n\t\tarrNU =[];\n\t\tif($(\"#slSfsTickNU\"+val).is(\":visible\")){\n\t\t\t$(\"#slSfsTickNU\"+val).hide();\n\t\t\t$(\'div[id^=\"slSfsTickNU\"]\').hide();\n\t\t}\n\t\telse{\n\t\t\tarrNU.push(val); \n\t\t\t$(\'div[id^=\"slSfsTickNU\"]\').hide();\n\t\t\t$(\"#slSfsTickNU\"+val).show();\t\t\n\t\t}\n\t\tparent.hideRows(arrSP,arrPR,arrNU);\t\n\t\t\n\t\tif($(\'#searchInputSFS\'+type).length > 0)\n\t\t\t$(\'#searchInputSFS\'+type).val(\'\');\t\n\t}\n\tsfsScrollNU.refresh();\t\n\tsfsScrollSP.refresh();\t\n\t\n}\nfunction selectedPract(val, desc, dPage){\n\tparent.clearHdnPatientValue();\n\t/* if($(\"#slSfsTickPR\"+val).is(\":visible\")){\n\t\t $(\"#slSfsTickPR\"+val).hide();\n\t\t $(\'div[id^=\"slSfsTickPR\"]\').hide();\n\t\t $(\".listItemPR\").show();\n\t\t $(\"#listItemPR\"+val).show();\n\t\t $(\"#slSfsTickPR\"+val).hide();\n\t\t if($(\"#contentSP\").is(\":visible\")){\n\t\t\t $(\"#contentSP\").hide();\n\t\t }\n\t\t if($(\"#textBoxSP\").is(\":visible\")){\n\t\t\t $(\"#textBoxSP\").hide();\n\t\t }\n\t\t if($(\"#contentNU\").is(\":visible\")){\n\t\t\t $(\"#contentNU\").hide();\n\t\t }\n\t\t if($(\"#textBoxNU\").is(\":visible\")){\n\t\t\t $(\"#textBoxNU\").hide();\n\t\t }\n\t\t \n\t\t \n\t\t \n\n\t\t sfsScrollPR.refresh();\n\t}\n\telse{\n\t\tarrPR.push(val); \n\t\t $(\'div[id^=\"slSfsTickPR\"]\').hide();\n\t\t $(\".listItemPR\").hide();\n\t\t $(\"#listItemPR\"+val).show();\n\t\t $(\"#slSfsTickPR\"+val).show();\n\t\t \n\t\t $(\"#textBoxSP\").show();\n\t\t $(\"#textBoxNU\").show();\n\t\t $(\"#contentSP\").show();\n\t\t $(\"#contentNU\").show();\n\t\t \n\t\t document.getElementById(\"hdnSelectedPractiotinerID\").value = val\n\t\t document.getElementById(\"hdnSfsClinicianId\").value = val\n\t\t parent.selectedPract(val, dPage);\n\t\t sfsScrollPR.refresh();\n\t} */\n\t$(\"#searchInputSFSPR\").blur();\n\tparent.selectedPract(val, desc, dPage);\n\t/* sfsScrollPR.refresh(); */\n}\nfunction removeInblockItem(val,type){\n\t$(\"#inBlockItem\"+val).remove();\n\tif(type == \'SP\'){\n\t\tvar index = arrSP.indexOf(val);\n\t\tarrSP.splice(index,1);\n\t\t\tif(arrSP.length<1){\n\t\t\t\t$(\"#SPAfterSel\").hide();\n\t\t\t\t$(\"#AfterSelectionSP\").empty();\n\t\t\t}\n\t\tparent.hideRows(arrSP,arrPR,arrNU);\n\t\t$(\"#slSfsTickSP\"+val).hide();\n\t\t\n\t\t$(\"#contentSP\").show();\n \t\t$(\"#textBoxSP\").show();\n\t\tsfsScrollSP.refresh();\n\t}\n\tif(type == \'PR\'){\n\t\tvar index = arrPR.indexOf(val);\n\t\tarrPR.splice(index,1);\n\t\t\tif(arrPR.length<1){\n\t\t\t\t$(\"#PRAfterSel\").hide();\n\t\t\t\t$(\"#AfterSelectionPR\").empty();\n\t\t\t}\n\t\tparent.hideRows(arrSP,arrPR,arrNU);\n\t\t$(\"#slSfsTickPR\"+val).hide();\n\t\t\n\t\t$(\"#contentPR\").show();\n \t\t$(\"#textBoxPR\").show();\n \t\t$(\"#arrowPR\").removeClass(\'slSfsarrow\');\n \t\tsfsScrollPR.refresh();\n\t}\n\tif(type ==\'NU\'){\n\t\tvar index = arrNU.indexOf(val);\n\t\tarrNU.splice(index,1);\n\t\t\tif(arrNU.length<1){\n\t\t\t\t$(\"#NUAfterSel\").hide();\n\t\t\t\t$(\"#AfterSelectionNU\").empty();\n\t\t\t}\n\t\tparent.hideRows(arrSP,arrPR,arrNU);\n\t\t$(\"#slSfsTickNU\"+val).hide();\n\t\t$(\"#contentNU\").show();\n \t\t$(\"#textBoxNU\").show();\n\t\tsfsScrollNU.refresh();\n\t\t}\n}\n\nfunction clearPatIdTxt(){\n\tdocument.getElementById(\"txtPatientId\").value = \"\";\t\n\t$(\"#ClearPatIdTxt\").hide();\n\t$( \"#txtPatientIdSearchIcon\" ).removeClass( \"enableSlSfsSearchIcon\" ).addClass( \"slSfsSearchIcon\" );\n}\nfunction clearTxt(current,other1,other2){\n\tdocument.getElementById(\"searchInputSFS\"+current).value = \"\";\n\t//parent.hideRows(arrSP,arrPR,arrNU);\n\t$(\"#list\"+current).find(\".listItem\"+current).show();\n\tif(current=\'SP\'){\n\t\tsfsScrollSP.refresh();\n\t}\n\tif(current=\'PR\'){\n\t\t$(\"#slSfsScrollerPR\").empty();\n\t\tsfsScrollPR.refresh(); \n\t\t\n\t\t/* var practID =arrPR[0];\n\t\tvar scrollToPR = \".listItemPR\"+practID;\n\t\tsfsScrollPR.scrollToElement(scrollToPR , 0 ); */\n\t\t\n\t}\n\tif(current=\'NU\'){\n\t\tsfsScrollNU.refresh(); \n\t}\n}\n\nfunction downArrow(current,other1,other2){\n\t\n\t$(\"#content\"+current).toggle();\n\t$(\"#textBox\"+current).toggle();\n\tif(current==\"SP\"){\n\t\tif($(\"#AfterSelectionSP\").is(\":visible\")){\n\t\t\t$(\"#AfterSelectionSP\").empty();\n\t\t\t$(\"#AfterSelectionSP\").hide();\n\t\t\t$(\"#contentSP\").show();\n\t \t\t$(\"#textBoxSP\").show();\n\t \t\tsfsScrollSP.refresh(); \n\t\t}\n\t\t \n\t\t if(arrSP.length>0){\n\t\t\t\t$(\"#AfterSelectionSP\").show();\n\t\t\t\tfor(var i=0;i<arrSP.length;i++){\n\t\t\t\t\tvar specCode= arrSP[i];\n\t\t\t\t\tvar specDesc =\"\";\n\t\t\t\t\t$(\"[data-speccode = \'\"+specCode+\"\']\").each(function (i,v ){\n\t\t\t\t\t\tspecDesc = $(this).data(\"specdesc\");\n\t\t\t\t\t});\n\t\t \t\t\tvar inblockSP =\'<div id=\"inBlockItem\'+specCode+\'\" class=\"row slSfsInlineBlock slSfsInlineBlockTheme\"> <div class=\"cell slSfsInlineBlockCell slSfsInlineBlockCellTheme\"> \'+ specDesc +\' </div><div class=\"cell slSfsInlineBlockClose\" onclick=\"removeInblockItem(&quot;\'+specCode+\'&quot;,&quot;SP&quot;)\"><img src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/images/Close10x10.PNG\"></div></div>\';\n\t\t \t\t\t$(\"#AfterSelectionSP\").append(inblockSP);    \n\t\t\t \t}\n\t\t\t\t\n\t\t\t\t$(\"#AfterSelectionSP\").show();\n\t    \t    $(\"#contentSP\").hide();\n\t \t\t    $(\"#textBoxSP\").hide();\n\t \t\t \n\t\t\t}\n\t\t\telse {\n\t\t\t\tsfsScrollSP.refresh(); \n\t\t\t}\n\t }\n\t \n\t if(current==\"PR\"){\n\t\t if($(\"#AfterSelectionPR\").is(\":visible\")){\n\n\t\t\t\t \n\t\t\t\t$(\"#AfterSelectionPR\").empty();\n\t\t\t\t$(\"#AfterSelectionPR\").hide();\n\t\t\t\t$(\"#contentPR\").show();\n\t\t \t\t$(\"#textBoxPR\").show();\n\t\t \t\tvar PractID = arrPR[0];\n\t\t\t\tvar scrollToPR;\n\t\t\t\tscrollToPR = \".listItemPR\"+PractID;\n\t\t\t\tsfsScrollPR.scrollToElement(scrollToPR , 0 );\n\t\t\t\tsfsScrollPR.refresh();\n\t\t\t}\n\t\t else if(arrPR.length>0){\n\t\t\t\tfor(var i=0;i<arrPR.length;i++){\n\t\t\t\t\tvar practCode = arrPR[i];\n    \t\t\t\tvar practDesc =\"\";\n    \t\t\t\t$(\"[data-practcode = \'\"+practCode+\"\']\").each(function (i,v ){\n    \t\t\t\t\tpractDesc = $(this).data(\"practdesc\");\n\t\t\t\t\t});\n    \t\t \t\tvar inblockPR =\'<div id=\"inBlockItem\'+practCode+\'\" class=\"row slSfsInlineBlock slSfsInlineBlockTheme\"> <div class=\"cell slSfsInlineBlockCell slSfsInlineBlockCellTheme\"> \'+ practDesc +\' </div><div class=\"cell slSfsInlineBlockClose\" onclick=\"removeInblockItem(&quot;\'+practCode+\'&quot;,&quot;PR&quot;)\"><img src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/Close10x10.PNG\"></div></div>\';\n    \t\t \t\t$(\"#AfterSelectionPR\").empty();\n    \t\t \t\t$(\"#AfterSelectionPR\").append(inblockPR);    \n    \t\t \t}\n\t\t\t\t$(\"#AfterSelectionPR\").show();\n\t    \t    $(\"#contentPR\").hide();\n\t \t\t    $(\"#textBoxPR\").hide();\n\t \t\t   \tvar PractID = arrPR[0];\n\t\t\t\tvar scrollToPR;\n\t\t\t\tscrollToPR = \".listItemPR\"+PractID;\n\t\t\t\tsfsScrollPR.scrollToElement(scrollToPR , 0 );\n\t\t\t\t\n\t \t\t \n\t\t\t}\n\t\t\n\t }\n\t \n\t if(current==\"NU\"){\n\t\t if($(\"#AfterSelectionNU\").is(\":visible\")){\n\t\t\t \tvar index = arrNU.indexOf(0);\n\t\t\t\tarrNU.splice(index,1);\n\t\t\t \t\n\t\t\t\t$(\"#AfterSelectionNU\").empty();\n\t\t\t\t$(\"#AfterSelectionNU\").hide();\n\t\t\t\t$(\"#contentNU\").show();\n\t\t \t\t$(\"#textBoxNU\").show();\n\t\t \t\tsfsScrollNU.refresh(); \n\t\t\t}\n\t\t \n\t\t if(arrNU.length>0){\n\t\t\t\t$(\"#AfterSelectionNU\").show();\n\t\t\t\tfor(var i=0;i<arrNU.length;i++){\n\t\t\t\t\tvar nursingUnitCode= arrNU[i];\n\t\t\t\t\tvar nursingUnitDesc =\"\";\n\t\t\t\t\t$(\"[data-nursingunitcode = \'\"+nursingUnitCode+\"\']\").each(function (i,v ){\n\t\t\t\t\t\tnursingUnitDesc = $(this).data(\"nursingunitdesc\");\n\t\t\t\t\t});\n\t \t\t\t\tvar inblockNU =\'<div id=\"inBlockItem\'+nursingUnitCode+\'\" class=\"row slSfsInlineBlock slSfsInlineBlockTheme\"> <div class=\"cell slSfsInlineBlockCell slSfsInlineBlockCellTheme\"> \'+ nursingUnitDesc +\' </div><div class=\"cell slSfsInlineBlockClose\" onclick=\"removeInblockItem(&quot;\'+nursingUnitCode+\'&quot;,&quot;NU&quot;)\"><img src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/Close10x10.PNG\"></div></div>\';\n\t \t\t\t\t$(\"#AfterSelectionNU\").append(inblockNU);    \n\t \t\t\t}\n\t    \t\t\n\t\t\t\t$(\"#AfterSelectionNU\").show();\n\t    \t    $(\"#contentNU\").hide();\n\t \t\t    $(\"#textBoxNU\").hide();\n\t \t\t \n\t\t\t}\n\t\t\telse {\n\t\t\t\tsfsScrollNU.refresh();\n\t\t\t}\n\t }\n\t \n\t if($(\"#content\"+current).is(\":visible\")){\n\t\t  $(\"#arrow\"+current).removeClass(\'slSfsarrow\');\n\t\t}\n\t\telse{\n\t\t\t$(\"#arrow\"+current).addClass(\'slSfsarrow\');\n\t\t}\n\t\n\t\n}\n$(document).ready(function(){\n\t//$(\"#codePR_Static\").html(($(\"#hdnSfsPractitionerId\",parent.document).val()));\n\t$(\"#textPR_Static\").html($(\"#hdnSfsPractitionerDesc\",parent.document).val()+\'<br><span class=\"slSfsViewItemTextSmall slSfsViewItemTextSmallTheme\" id=\"codePR_Static\">\'+$(\"#hdnSfsPractitionerId\",parent.document).val()+\'</span>\');\n\tpath = $(\'#hdnPath\').val();\n\tloaded();\n\tif(sfsScrollSP != null){\n\t\tsfsScrollSP.on(\'beforeScrollStart\', function () {\n\t\t\tsfsMainScroll.disable();\n\t\t});\n\t\tsfsScrollSP.on(\'scrollEnd\', function () {\n\t\t\tsfsMainScroll.enable();\n\t\t});\n\t}\n\tif(sfsScrollPR != null){\n\t\tsfsScrollPR.on(\'beforeScrollStart\', function () {\n\t\t\tsfsMainScroll.disable();\n\t\t});\n\t\tsfsScrollPR.on(\'scrollEnd\', function () {\n\t\t\tsfsMainScroll.enable();\n\t\t});\n\t}\n\tif(sfsScrollNU != null){\n\t\tsfsScrollNU.on(\'beforeScrollStart\', function () {\n\t\t\tsfsMainScroll.disable();\n\t\t});\n\t\tsfsScrollNU.on(\'scrollEnd\', function () {\n\t\t\tsfsMainScroll.enable();\n\t\t});\n\t}\n\t$(\'#slSfsWrapperMain\').on(\'touchstart click\', function(){\n\t\tsfsMainScroll.enable();\n\t});\n\t$(\'#ClearPatIdTxt\').hide();\n\t$(\'#AfterSelectionPR\').hide();\n\t$(\'#AfterSelectionSP\').hide();\n\t$(\'#AfterSelectionNU\').hide();\n\t\n\tif($(\"#searchInputSFSSP\").is(\":visible\")){\n\t$(\"#searchInputSFSSP\").keyup(function () {\n\tvar rows = $(\"#listSP\").find(\".listItemSP\").hide();\n\tsfsScrollSP.refresh();\n\t   if (this.value.length) {\n\t\t    addSpinnerNU();\n\t\t   parent.addSpinner();\n\t       var data = this.value.split(\" \");\n\t       //$.each(data, function (i, v){\n\t       \t\t//var val = v.toLowerCase(); \n\t       \t\tvar val = this.value.toLowerCase();\n\t       \t\trows.filter(\":containsIN(\'\" + val + \"\')\").show();\n\t       \t\tsfsScrollSP.refresh();\n\t\t\t\t//});\n\t\t\t\t removeSpinner();\n\t   \t\t}\n\t   \telse{\n\t   \t\trows.show();\t\n\t   \t\tsfsScrollSP.refresh();\n\t   \t}\n\t}); \n\t}\n\t\n\tfunction addSpinnerNU(){\n\tvar a = $(\"#spinnerDiv\")\n\n\tif(a.length ==0)\n\t\t$(\"#slSfsWrapperNU\").append(\"<div class=\'loadingCartItem\' id=\'spinnerDiv\'></div>\");\n}\n\tfunction removeSpinner(){\n\tvar a = $(\"#spinnerDiv\")\n\n\tif(a.length > 0)\n\t$(\"#spinnerDiv\").remove();\n}\n\t/* if($(\"#searchInputSFSPR\").is(\":visible\")){ */\n\t$(\"#searchInputSFSPR\").keyup(function () {\n\t\t\n\t\tif (this.value.length == 3 ){\n\t\t\t\n\t\t\t$(\"#spinnerDiv_PRSFS\").show();\n\t\t\n\t\t\tcurrentSearchText = this.value;\n\t\t\t$(\'#slSfsScrollerPR\').load(path+\"/eIPAD/jsp/IPSlideSFSPractSearch.jsp?practSearchText=\"+this.value,function(){\n\t\t\t\tsfsScrollPR.refresh();\n\t\t\t\t$(\"#spinnerDiv_PRSFS\").hide();\n\t\t\t\t//$(\"#searchInputSFSPR\").blur();\n\t\t\t\t\n\t\t\t});\n\t\t}else if(this.value.length > 3){\n\t\t\tvar rows = $(\"#listPR\").find(\".listItemPR\").hide();\n\t\t\t var data = this.value.split(\" \");\n\t       //$.each(data, function (i, v){\n\t       \t//var val = v.toLowerCase(); \n\t       \tvar val = this.value.toLowerCase();\n\t       \tvar visibleData = rows.filter(\":containsIN(\'\" + val + \"\')\").show();\n\t       \tif(visibleData.length<=0){\n\t       \t\n\t       \t\t$(\"#listPR_NoResults\").css(\"display\",\"block\");\n\t       \t}\n\t       \tsfsScrollPR.refresh();\n\t\t}\n       \telse if(this.value.length < 3){\n    \t    $(\'#slSfsScrollerPR\').empty();\n       \t}\n\t\t\n\t/* var rows = $(\"#listPR\").find(\".listItemPR\").hide();\n\tsfsScrollPR.refresh();\n\t   if (this.value.length) {\n\t       var data = this.value.split(\" \");\n\t       //$.each(data, function (i, v){\n\t       \t//var val = v.toLowerCase(); \n\t       \tvar val = this.value.toLowerCase();\n\t       \trows.filter(\":containsIN(\'\" + val + \"\')\").show();\n\t       \tsfsScrollPR.refresh();\n\t   \t\t//});\n\t   \t}\n\t   \telse{\n\t   \t\trows.show();\n\t   \t\tsfsScrollPR.refresh();\n\t\t\t   \t}\n\t\t\t    var searchVal = $(\"#searchInputSFSPR\").val();\n\t\t\t\tif(searchVal.length == 0){\n\t\t\t\t\tvar PractID = arrPR[0];\n\t\t\t\t\tvar scrollToPR;\n\t\t\t\t\tscrollToPR = \".listItemPR\"+PractID;\n\t\t\t\t\tsfsScrollPR.scrollToElement(scrollToPR , 0);\n\t   \t} */\n\t}); \n\t       \n\t//}\n\tif($(\"#searchInputSFSNU\").is(\":visible\")){\n\t$(\"#searchInputSFSNU\").keyup(function () {\n\tvar rows = $(\"#listNU\").find(\".listItemNU\").hide();\n\t  if (this.value.length) {\n\t\t  addSpinnerNU();\n\t      var data = this.value.split(\" \");\n\t      //$.each(data, function (i, v){\n\t      \t//var val = v.toLowerCase(); \n\t      \tvar val = this.value.toLowerCase();\n\t\t\trows.filter(\":containsIN(\'\" + val + \"\')\").show();\n\t\t\tsfsScrollNU.refresh();\n\t      \t//});\n\t\t\t removeSpinner();\n\t  \t}\n\t  \telse{ \n\t  \t\trows.show();\n\t\t\tsfsScrollNU.refresh();\n\t  \t}\n\t});\n\t}\n\t\n\tvar PractID = $(\'#hdnSfsClinicianId\').val();\n\t$(\"#slSfsTickPR\"+PractID).show();\n\tarrPR.push(PractID);\n\tvar scrollToPR;\n\tscrollToPR = \".listItemPR\"+PractID;\n\tsfsScrollPR.scrollToElement(scrollToPR , 0 );\n\t\n\t$(\'input\').bind(\'focus\', function(e) {\n\t\t\twindow.parent.$(\'#divParent\').css(\'position\',\'fixed\')\t\t\n\t});\n\t$(\'input\').bind(\'blur\', function(e) {\n\t\t\twindow.parent.$(\'#divParent\').css(\'position\',\'absolute\')\t\t\n\t});\n\t/* $( document).on( \"swipeleft\", \"#IpSearchForm\", function( e ) {\n\t\thideSlideSFS();\n\t}); */\n\tparent.setIframeSFSHeight();\n });\n function changeOrientation(orient, HFheight)\n {\n \tcontent_height = parent.getTotalPageDivHeight() - HFheight-5;\n\tdocument.getElementById(\"IPsfsTable\").style.height = content_height+\"px\";\n\twindow.parent.$(\"#SlideSfs\").css(\"height\", content_height+\"px\");\n\t\n }\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body style=\"width: 100%; height: 100%;\">\n\t<form name=\'IpSearchForm\' id=\'IpSearchForm\' id=\"IpSearchForm\" method=\'post\' style=\"background-color: #eaedf2;\">\n\t\t<!-- main table STARTS -->\n\t\t<div class=\"table\" id=\"IPsfsTable\" style=\"width:100%;height:100%; position: absolute; overflow: hidden; background:#eaedf2\"> \n\t\t\t<!-- header row STARTS -->\n\t\t\t<div class=\"row\" style=\"height:40px; width:100%\"> <!-- MR1 -->\n\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t<div class=\"table\" style=\"width:100%; height:100%\">\n\t\t\t\t\t\t<div class=\"row slSfsHeader slSfsHeaderTheme\">\n\t\t\t\t\t\t\t<div class=\"cell slSfsHeaderText slSfsHeaderTextTheme\">SEARCH / FILTER</div>\n\t\t\t\t\t\t\t<div class=\"cell slSfsHeaderCell\" id=\"refMain\" onclick=\"refreshMain()\"><img src =\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/images/Reload24x24.png\" /></div>\n\t\t\t\t\t\t\t<div class=\"cell slSfsHeaderCell\"  onclick=\"hideSlideSFS()\"><img src = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/images/CloseSearch24x24.png\" /></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<!-- Text box row starts-->\t\n\t\t\t<div class=\"row\" style=\"height:40px; width:100%\"> <!-- MR2 -->\n\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t<div class=\"table\" style=\"height:40px; width:96%; margin-top:4px; margin-left:4px; margin-right:4px\">\n\t\t\t\t\t\t<div class=\"row\" style=\"background:#ffffff; height:100%; width:100%\">\n\t\t\t\t\t\t\t<div class=\"cell\" style=\"width:99%\">\n\t\t\t\t\t\t\t\t<div class=\"table slSfsMainTextBox\">\n\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"background:#ffffff; height:100%; width:100%\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align:middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"slSfsTxtBox\" style=\"color:#9da5b3; height:24px\" name = \"txtPatientId\" id = \"txtPatientId\" placeholder=\"Patient ID/Bed No.\" maxlength=\"20\" value = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  onKeyUp=\"enableSlideSfsIcon()\" onChange=\"enableSlideSfsIcon()\"/>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" id=\"ClearPatIdTxt\" onclick=\"clearPatIdTxt()\" style=\"vertical-align: middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\" slSfsTextBoxCloseButton\"  ><img src=\"../images/Close-small.png\" style=\"width:10px; height:10px\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"cell\" style=\" width:1%; vertical-align: middle; text-align: center;\">\n\t\t\t\t\t\t\t\t<div id=\"txtPatientIdSearchIcon\" class=\"slSfsSearchIcon\" onclick=\"slidesfsSearchByPat()\"><img src = \"../images/SearchSFS14x14.png\" style=\"vertical-align: middle; text-align: center; padding-top: 12px;\"/></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<!-- Text box row ends  -->\n\t\t\t<!-- header row ENDS -->\n\t\t\t<div class=\"row\" style=\"height:96%; width:100%\"> <!-- MR3 -->\n\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t<div style=\"width:100%;height:100%;overflow:hidden;position:relative\">\n\t\t\t\t\t\t<div id=\"slSfsWrapperMain\">\n\t\t\t\t\t\t\t<div id=\"slSfsScrollerMain\">\n\t\t\t\t\t\t\t\t<div class=\"table\" id=\"sfsMainTable\" style=\"width:96%; margin:4px;position:relative\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<!-- PR Content starts here-->\n\t\t\t\t\t\t\t\t\t\t<div class=\"table filterTextWrap\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" id=\"headingPR\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row slSfsCategoryBlock\" onclick=\"downArrow(\'PR\',\'SP\',\'NU\')\" style=\"width:100%; height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell slSfsDivText slSfsDivTextTheme\" > PRACTITIONER </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <div class=\"cell slSfsHeaderCell\" onclick=\"refresh(\'PR\',\'SP\',\'NU\')\"> <img  id=\"refPR\" src = \"../images/ReloadGrySFS.png\"  style=\"padding-top:4px\"/></div> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell slSfsHeaderCell\" id=\"arrowPR\"  ><img  src = \"../images/DownarrowSFS.png\" /></div>\n\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" id=\"textBoxPR\" style=\"width:100%; height:40px; background:#ffffff; \">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table slSfsDivShadow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"height:30px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align:middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"searchInputSFSPR\" class=\"slSfsDivLevelTxtBox\" style=\"color:#9da5b3; height:24px;\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"width: 11%;padding:0px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:90%;margin-top:4px;background-color:#dbdbdb;border-radius:10px;\" onclick=\"clearTxt(\'PR\',\'SP\',\'NU\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <img style=\"vertical-align:middle;padding-top:0;margin-top:-3px\" src=\"../images/Close-small.png\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" id=\"contentPR\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"slSfsNormalView\" id=\"dataPR\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"slSfsWrapperPR\" style=\"height:100%; width:100%; background-color: #ffffff;\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"slSfsScrollerPR\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" id=\"spinnerDiv_PRSFS\" style=\"width:100%; height:100%;position:relative;display:none\">\n\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t<div class=\"row listItemPR_Static\"   id=\"listItemPR_Static\" style=\"width:100%; height:45px;\" onclick=\"\" data-practcode=\"\" data-practdesc=\"\">\n\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\t<div class=\'loadingCartItem\' ></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" id=\"listPR_Static\" style=\"width:100%; height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t<div class=\"row listItemPR_Static\"   id=\"listItemPR_Static\" style=\"width:100%; height:45px;\" onclick=\"\" data-practcode=\"\" data-practdesc=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- border-bottom: 1px solid #f6f6f6; -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell slSfsViewItemTextPract slSfsViewItemTextPractTheme\" id=\"textPR_Static\"><br>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"slSfsViewItemTextSmall slSfsViewItemTextSmallTheme\" id=\"codePR_Static\"></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsListTickPractTheme\"><div class=\"slSfsTickVisiblePR SLSfsCircleVisibleTheme\" id=\"slSfsTickPR_Static\"\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row slSfsAfterSelection\" id=\"PRAfterSel\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"padding-left:10px;display:block\" id=\"AfterSelectionPR\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- PR Content ends here-->\n\t\t\t\t\t\t\t\t\t\t<!-- SP Content Stars Here -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t<div class=\"table filterTextWrap\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" id=\"headingSP\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row disabledRow\" id=\"headingSP\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row slSfsCategoryBlock\" onclick=\"downArrow(\'SP\',\'PR\',\'NU\')\" style=\"width:100%; height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell slSfsDivText slSfsDivTextTheme\" > SPECIALITY </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <div class=\"cell slSfsHeaderCell\" onclick=\"refresh(\'SP\',\'PR\',\'NU\')\"> <img  id=\"refSP\" src = \"../images/ReloadGrySFS.png\"  style=\"padding-top:4px\"/></div> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell slSfsHeaderCell\" id=\"arrowSP\"  ><img  src = \"../images/DownarrowSFS.png\" /></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" id=\"textBoxSP\" style=\"width:100%; height:40px; background:#ffffff; \">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table slSfsDivShadow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"height:30px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align:middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"searchInputSFSSP\" class=\"slSfsDivLevelTxtBox\" style=\"color:#9da5b3;height:26px;\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\"  style=\"vertical-align: middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" slSfsTextBoxCloseButton\" onclick=\"clearTxt(\'SP\',\'PR\',\'NU\')\"><img src=\"../images/Close-small.png\" style=\"width:10px; height:10px\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" id=\"contentSP\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"slSfsNormalView\" id=\"dataSP\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"slSfsWrapperSP\" style=\"background-color: #ffffff;\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"slSfsScrollerSP\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"table\" id=\"listSP\" style=\"width:100%; height:100%;\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t   ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"listItemSP\" style=\"width:100%; height:40px;\" onclick=\"showTick(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'SP\')\" data-speccode=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" data-specdesc=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell slSfsViewItemText slSfsViewItemTextTheme\" id=\"textSP";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell slSfsListTick\" id=\"divSP";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"><div class=\"slSfsTickVisibleSP SLSfsCircleVisibleTheme\" id=\"slSfsTickSP";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" style=\"display:none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\n\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t    <div class=\"row slSfsAfterSelection\" id=\"SPAfterSel\">\n\t\t\t\t\t\t\t\t\t\t   \t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"padding-left:10px;display:block\" id=\"AfterSelectionSP\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t                                        </div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- SP Content ends here-->\n\t\t\t\t\t\t\t\t\t\t<!-- NU Content starts here-->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" id=\"headingNU\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row disabledRow\" id=\"headingNU\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row slSfsCategoryBlock\" onclick=\"downArrow(\'NU\',\'SP\',\'PR\')\" style=\"width:100%; height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell slSfsDivText slSfsDivTextTheme\" > NURSING UNIT </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <div class=\"cell slSfsHeaderCell\" onclick=\"refresh(\'NU\',\'SP\',\'PR\')\"> <img  id=\"refNU\" src = \"../images/ReloadGrySFS.png\"  style=\"padding-top:4px\"/></div> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell slSfsHeaderCell\" id=\"arrowNU\" ><img  src = \"../images/DownarrowSFS.png\" /></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" id=\"textBoxNU\" style=\"width:100%; height:40px; background:#ffffff; \">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table slSfsDivShadow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"height:30px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align:middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"searchInputSFSNU\" class=\"slSfsDivLevelTxtBox\" style=\"color:#9da5b3;height:26px;\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align: middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" slSfsTextBoxCloseButton\"  onclick=\"clearTxt(\'NU\',\'SP\',\'PR\')\"><img src=\"../images/Close-small.png\" style=\"width:10px; height:10px\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t  \t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t  \t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t  \t\t\t\t\t\t\t\t\t\t\t</div>\n\t  \t\t\t\t\t\t\t\t\t\t</div>\n  \t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\t<div class=\"row\" id=\"contentNU\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"slSfsNormalView\" id=\"dataNU\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"slSfsWrapperNU\" style=\"height:100%; width:100%; background-color: #ffffff;\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"slSfsScrollerNU\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"table\" id=\"listNU\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t  ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"listItemNU\" style=\"width:100%; height:40px;\" onClick=\"showTick(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\',\'NU\')\" data-nursingunitcode=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" data-nursingunitdesc=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell slSfsViewItemText slSfsViewItemTextTheme\" id=\"textNU";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell slSfsListTick\"><div class=\"slSfsTickVisibleNU SLSfsCircleVisibleTheme\" id=\"slSfsTickNU";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" style=\"display:none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"row slSfsAfterSelection\" id=\"NUAfterSel\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"padding-left:10px;display:block\" id=\"AfterSelectionNU\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" \n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- NU Content ends here-->\n\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div><!-- end of main table -->\n\t\t\n\t\t<input type = \"hidden\" name =\"hdnSelectedPractiotinerID\" id =\"hdnSelectedPractiotinerID\" value = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnClinicianId\" id =\"hdnClinicianId\" value = \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnSfsClinicianId\" id =\"hdnSfsClinicianId\" value = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnLoggedInUser\" id =\"hdnLoggedInUser\" value = \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnLoggedInUserDesc\" id =\"hdnLoggedInUserDesc\" value = \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"/>\n\t\t\n\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" />\n\t</form>\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	InPatientContext objInPatientContext = new InPatientContext();
	objInPatientContext.setRequest(request);
	
	String locale = "en";
	String facilityId = "";
	String fSpecialityId = "";
	String fSpecialityName = "";
	String fNursingUnitId = "";
	String fNursingUnitName = "";
	String fPractitionerId = "";
	String fPractitionerName = ""; 
	String fSfsContext = "";
	
	

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
            out.print( String.valueOf(objInPatientContext.getPatientId() ));
            _bw.write(_wl_block10Bytes, _wl_block10);

									SFSContext oSFSContext = new SFSContext();
									String sfacility_id = "";
									String sclinicianId = "";
									String sPractionerId = "";
									String selectedPractID = "";
									String specCode= "";
									String practCode = "";
									String nursingCode= "";
									String clinicianId = "";
									oSFSContext.setRequest(request);
									if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
									{
										sfacility_id = (String)session.getValue("facility_id");
										oSFSContext.setSfacility_id(sfacility_id);
									}
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
									{
										sclinicianId = (String)session.getValue("ca_practitioner_id");
										oSFSContext.setSclinicianId(sclinicianId);
									}
									/* if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId") != "")
									{
										sPractionerId = (String)request.getParameter("hdnPractitionerId");
										oSFSContext.setsPractionerId(sPractionerId);
									} */
									
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")	
									{
										sclinicianId = (String)session.getValue("ca_practitioner_id");
										oSFSContext.setsPractionerId(sclinicianId); //for Nursing Unit search alone always the practitioner ID is the login practitioner
									}
									if(request.getParameter("selectedPractID") != null){
										
										selectedPractID = (String)request.getParameter("selectedPractID");
										oSFSContext.setsPractionerId(selectedPractID);
									}
									
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
									{
										clinicianId = (String)session.getValue("ca_practitioner_id");
										objInPatientContext.setClinicianId(clinicianId);
									}
									if(session.getValue("practitioner_name") != null && session.getValue("practitioner_name") != "")
									{
										fPractitionerName = (String)session.getValue("practitioner_name");
										objInPatientContext.setClinicianDesc(fPractitionerName);
									}
									
												
									   int nRowCount = 1;		       			    
									   int nLoopCount = 0;
									   
									   int nListSizeSP = 0;
									   int nListSizePR = 0;
									   int nListSizeNU = 0;
									 
									   SFSDetails bean = new SFSDetails();
									   List<SFSUnit> objSfsDetailsSP = new ArrayList<SFSUnit>();
									   List<SFSUnit> objSfsDetailsPR = new ArrayList<SFSUnit>();
									   List<SFSUnit> objSfsDetailsNU = new ArrayList<SFSUnit>();
									   
									   int sfsContextTypePR = 4;
									   int sfsContextTypeSP = 5;
									   int sfsContextTypeNU = 6;
									
            _bw.write(_wl_block11Bytes, _wl_block11);

											
												oSFSContext.setType(sfsContextTypePR);  
												objSfsDetailsPR = bean.getSFSUnit(oSFSContext); 
							   					nListSizePR =  objSfsDetailsPR.size();
							   					SFSUnit sfsUnitPR = null;
							   					
							   						/* if(nListSizePR > 10){ */
											 
            _bw.write(_wl_block12Bytes, _wl_block12);

						   						/* } */
						   						/* if(nListSizePR >0 ){ */
										
            _bw.write(_wl_block13Bytes, _wl_block13);

										try {
											
            _bw.write(_wl_block14Bytes, _wl_block14);
            _bw.write(_wl_block15Bytes, _wl_block15);

											}catch ( Exception e ){
											e.printStackTrace();
											}
											finally{
											}
											/* } */
											
            _bw.write(_wl_block16Bytes, _wl_block16);

										oSFSContext.setType(sfsContextTypeSP);  
										objSfsDetailsSP = bean.getSFSUnit(oSFSContext); 
										
										
										
										nListSizeSP =  objSfsDetailsSP.size();
								   		SFSUnit sfsUnitSP = null;
										
            _bw.write(_wl_block17Bytes, _wl_block17);

										if(nListSizeSP > 0){
										
            _bw.write(_wl_block18Bytes, _wl_block18);

										}else{
										
            _bw.write(_wl_block19Bytes, _wl_block19);

										}
										
            _bw.write(_wl_block20Bytes, _wl_block20);

											
								   	 				   
										   	if(nListSizeSP > 10){
											
            _bw.write(_wl_block21Bytes, _wl_block21);

										   		}
										   			if(nListSizeSP > 0){
										   					
											
            _bw.write(_wl_block22Bytes, _wl_block22);
				   
															   try {
																
															   	
																   
            _bw.write(_wl_block23Bytes, _wl_block23);

																 	  for(nLoopCount = 0 ; nLoopCount < nListSizeSP; nLoopCount++)
																 	  {
																 		 sfsUnitSP = objSfsDetailsSP.get(nLoopCount);
																 		  if(sfsUnitSP != null )
																		  {
																 			 specCode = sfsUnitSP.getsCode(); 
											 
											 				 	   
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sfsUnitSP.getsDescription() ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sfsUnitSP.getsDescription()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block31Bytes, _wl_block31);

															  				}
															  					nRowCount = nRowCount + 1;
																		} 
																 
            _bw.write(_wl_block32Bytes, _wl_block32);

											   }catch ( Exception e ){
													e.printStackTrace();
													}
													finally{
													}
										   			}
											
											
            _bw.write(_wl_block33Bytes, _wl_block33);

										oSFSContext.setType(sfsContextTypeNU);  
										objSfsDetailsNU = bean.getSFSUnit(oSFSContext); 
									    
										nListSizeNU =  objSfsDetailsNU.size();
									    SFSUnit sfsUnitNU = null;
										
            _bw.write(_wl_block17Bytes, _wl_block17);

										if(nListSizeNU > 0){
										
            _bw.write(_wl_block34Bytes, _wl_block34);

										}else{
										
            _bw.write(_wl_block35Bytes, _wl_block35);

										}
										
            _bw.write(_wl_block36Bytes, _wl_block36);

											
											
										    if(nListSizeNU > 10){
										    
            _bw.write(_wl_block37Bytes, _wl_block37);

										    	}
										    	if(nListSizeNU > 0){
										  
  										
            _bw.write(_wl_block38Bytes, _wl_block38);

														   try {
															
														    
															   
            _bw.write(_wl_block39Bytes, _wl_block39);

														 	  for(nLoopCount = 0 ; nLoopCount < nListSizeNU; nLoopCount++)
														 	  {
														 		 sfsUnitNU = objSfsDetailsNU.get(nLoopCount);
														 		  if(sfsUnitNU != null )
																  {
														 			 nursingCode=sfsUnitNU.getsCode();
													 		  
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(nursingCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nursingCode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sfsUnitNU.getsDescription()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nursingCode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sfsUnitNU.getsDescription()));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(nursingCode));
            _bw.write(_wl_block45Bytes, _wl_block45);

														  		}
														  		nRowCount = nRowCount + 1;
																} 
														 	 	
            _bw.write(_wl_block46Bytes, _wl_block46);
  
										   }catch ( Exception e ){
												e.printStackTrace();
												}
												finally{
										  }
										  }
										
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(objInPatientContext.getPractionerId()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(objInPatientContext.getClinicianId()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oSFSContext.getsPractionerId()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(objInPatientContext.getClinicianId()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(fPractitionerName));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block53Bytes, _wl_block53);
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
