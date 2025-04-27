package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import eIPAD.selectorder.*;
import eIPAD.selectorder.healthobject.*;
import eIPAD.selectorder.request.*;
import eIPAD.selectorder.response.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __selectorderbasepage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/SelectOrderBasePage.jsp", 1709118032099L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1_0 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title></title> \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script type=\"text/javascript\" src=\"../jquery-1.5.2.min.js\"></script>  \n<script type=\"text/javascript\" src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n \n<link rel=\"stylesheet\" href=\"../css/iPadOrder.css\" />\n</head>\n<script>\nvar  catalogCode = [];\nvar arOrderId = [];\nvar selectedRowCount = 0;\nvar bExpand = false;\nfunction changeOrientation(orient)\n{\n\tif(orient == \"landscape\")\n\t  {\n\t//\tdocument.getElementById(\"dvNotesMenu\").style.min-height = \"492px\";\n\t     $(\"#dvOrderContent\").css(\'min-height\',\'508px\');\n\t     $(\"#dvOrderSave\").css(\'min-height\',\'508px\');\n\t     $(\"#dvSlide\").css(\'min-height\',\'508px\');\n\t     $(\"#orderFrame\").css(\'height\', \'464px\');\n\t     \n\t     $(\"#dvSelectContents\").css(\'min-height\',\'420px\');\n\t     document.getElementById(\"orderFrame\").contentWindow.changeOrientation(orient);\n\t    // setAlignment1(orient);\n\t  }\n  else\n\t  {\n \t     $(\"#dvOrderContent\").css(\'min-height\',\'765px\');\n \t     $(\"#dvOrderSave\").css(\'min-height\',\'765px\');\n \t    $(\"#dvSlide\").css(\'min-height\',\'765px\');\n \t     $(\"#orderFrame\").css(\'height\', \'721px\');\n \t    $(\"#dvSelectContents\").css(\'min-height\',\'677px\');\n \t    document.getElementById(\"orderFrame\").contentWindow.changeOrientation(orient);\n \t    // setAlignment1(orient);\n\t  }\n}\nfunction setAlignment1(orientation)\n{\n\t\n\t//alert(window.orientation);\n\t//alert(orientation);\n\tvar dvContentHeight =  $(\"#dvOrderContent\").height();\n\t//alert(dvContentHeight);\n\tif(!isNaN(dvContentHeight))\n\t{\n\t\tvar dvheight = parseInt(dvContentHeight);\n\t\tif(orientation == \"landscape\")\n\t\t{\n\t\t\tif(dvheight > 508)\n\t\t\t{\n\t\t\t\t $(\"#dvOrderSave\").css(\'min-height\', dvheight);\n\t\t\t}\n\t\t}\n\t\telse if(orientation == \"portrait\")\n\t\t{\n\t\t\tif(dvheight > 765)\n\t\t\t{\n\t\t\t\t $(\"#dvOrderSave\").css(\'min-height\', dvheight);\n\t\t\t}\n\t\t}\n\t}\n\t\n}\nfunction setAlignment()\n{\n\t\n\tvar orientation = document.getElementById(\"hdnOrientation\").value;\n\n\tvar dvContentHeight =  $(\"#dvOrderContent\").height();\n\tif(!isNaN(dvContentHeight))\n\t{\n\t\tvar dvheight = parseInt(dvContentHeight);\n\t\t\n\t\tif(orientation == \"0\")\n\t\t{\n\t\t\t\n\t\t\tif(dvheight > 765)\n\t\t\t{\n\t\t\t\t $(\"#dvOrderSave\").css(\'min-height\', dvheight);\n\t\t\t}\n\t\t}\n\t\telse \n\t\t{\n\t\t\tif(dvheight > 508)\n\t\t\t{\n\t\t\t\t $(\"#dvOrderSave\").css(\'min-height\', dvheight);\n\t\t\t}\n\t\t}\n\t\t\n\t}\n\t\n}\nfunction slide()\n{\n\t//alert(\"hi\");\n\tbExpand = false;\n\t$(\'#dvOrderSave\').css(\"width\", \"5%\");\n\t$(\'#dvOrderContent\').css(\"width\", \"95%\");\n\tdocument.getElementById(\"dvOrderSave\").style.display = \"none\";\n\tdocument.getElementById(\"dvSlide\").style.display = \"block\";\n}\nfunction expand()\n{\n\tbExpand = true;\n\t$(\'#dvOrderSave\').css(\"width\", \"30%\");\n\t$(\'#dvOrderContent\').css(\"width\", \"70%\");\n\tdocument.getElementById(\"dvOrderSave\").style.display = \"block\";\n\tdocument.getElementById(\"dvSlide\").style.display = \"none\";\n}\nfunction Loading()\n{\n\t///* ---Saraswathi added - Start */\n\tif(document.getElementById(\"hdnSaveResult\").value == \"FAILURE\")\n\t{\n\t\talert(\'Save Failed\');\n\t}\n\telse if(document.getElementById(\"hdnSaveResult\").value == \"SUCCESS\")\n\t{\n\t\talert(\'Save was Successful!\');\n\t}\n\t///* ---Saraswathi added - End */\n\tchangeSrchOrderState();\n}\nfunction searchTabActive()\n{\n\tvar patclass = document.getElementById(\"hdnPatClass\").value\n\tdocument.getElementById(\"orderFrame\").src = \"SearchOrder.jsp?patientclass=\" + patclass;\n\tchangeSrchOrderState();\n}\nfunction changeSrchOrderState()\n{\n\tvar element1 = document.getElementById(\"tdTickSheet\");\n\tvar element2 = document.getElementById(\"tdExstOrder\");\n\tvar element3 = document.getElementById(\"tdSearchOrder\");\n\t\n\tvar spElement1 = document.getElementById(\"spSrchOrder\");\n\tvar spElement2 = document.getElementById(\"spExtOrd\");\n\tvar spElement3 = document.getElementById(\"spTickSheet\");\n\t\n\telement1.setAttribute(\"class\",\"tdTab\");\n\telement2.setAttribute(\"class\",\"tdTab\");\n\telement3.setAttribute(\"class\",\"tdTabActive\");\n\t\n\tspElement1.setAttribute(\"class\",\"spTabActive\");\n\tspElement2.setAttribute(\"class\",\"spTab\");\n\tspElement3.setAttribute(\"class\",\"spTab\");\n}\nfunction changeTickSheetState()\n{\n\tvar patclass = document.getElementById(\"hdnPatClass\").value\n\tdocument.getElementById(\"orderFrame\").src = \"TickSheetBasePage.jsp?patientclass=\" + patclass;\n\tvar element1 = document.getElementById(\"tdTickSheet\");\n\tvar element2 = document.getElementById(\"tdExstOrder\");\n\tvar element3 = document.getElementById(\"tdSearchOrder\");\n\t\n\tvar spElement1 = document.getElementById(\"spSrchOrder\");\n\tvar spElement2 = document.getElementById(\"spExtOrd\");\n\tvar spElement3 = document.getElementById(\"spTickSheet\");\n\t\n\telement1.setAttribute(\"class\",\"tdTabActive\");\n\telement2.setAttribute(\"class\",\"tdTab\");\n\telement3.setAttribute(\"class\",\"tdTab\");\n\t\n\tspElement1.setAttribute(\"class\",\"spTab\");\n\tspElement2.setAttribute(\"class\",\"spTab\");\n\tspElement3.setAttribute(\"class\",\"spTabActive\");\n}\n\nfunction changeExtState()\n{\n\t///* ---Saraswathi added - Start */\n\tdocument.getElementById(\"orderFrame\").src = \"ExistingOrders.jsp\";\n\t///* ---Saraswathi added - End */\n\tvar element1 = document.getElementById(\"tdTickSheet\");\n\tvar element2 = document.getElementById(\"tdExstOrder\");\n\tvar element3 = document.getElementById(\"tdSearchOrder\");\n\t\n\tvar spElement1 = document.getElementById(\"spSrchOrder\");\n\tvar spElement2 = document.getElementById(\"spExtOrd\");\n\tvar spElement3 = document.getElementById(\"spTickSheet\");\n\t\n\telement1.setAttribute(\"class\",\"tdTab\");\n\telement2.setAttribute(\"class\",\"tdTabActive\");\n\telement3.setAttribute(\"class\",\"tdTab\");\n\t\n\tspElement1.setAttribute(\"class\",\"spTab\");\n\tspElement2.setAttribute(\"class\",\"spTabActive\");\n\tspElement3.setAttribute(\"class\",\"spTab\");\n}\nfunction removeA(arr) {\n    var what, a = arguments, L = a.length, ax;\n    while (L > 1 && arr.length) {\n        what = a[--L];\n        while ((ax= arr.indexOf(what)) !== -1) {\n            arr.splice(ax, 1);\n        }\n    }\n    return arr;\n}\n\nfunction removeSelectedContent(obj)\n{\n\t//alert(obj);\n\t//alert($(obj));\n\t/*\n\talert($(\"#tb1\").attr(\'data-orderCatalogCode\'));\n\t$(\"#tb1\").remove();\n\t*/\n\t//alert($(obj).attr(\'data-orderCatalogCode\'));\n\t\n\tvar orderCatalogCode = $(obj).attr(\'data-orderCatalogCode\');\n\tvar orderid = $(obj).attr(\'data-orderId\');\n\t//if(catalogCode != null)\n   //  catalogCode.splice($.inArray(orderCatalogCode, catalogCode),1);\n\t//alert(\"remove\");\n\t\n\t//alert(orderid);\n\tif(orderid != null && orderid != \"\")\n\t{\n\t\tif(arOrderId != null)\n\t\t{\n\t\t\tarOrderId.splice($.inArray(orderid, arOrderId),1);\n\t\t\t//alert(arOrderId);\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(catalogCode != null)\n\t\t     catalogCode.splice($.inArray(orderCatalogCode, catalogCode),1);\n\t\t//alert(catalogCode);\n\t}\n\t\n\t$(obj).remove();\n\tselectedRowCount--;\n\tdocument.getElementById(\"orderFrame\").contentWindow.deselectCheckBox(orderCatalogCode,orderid);\n\tdocument.getElementById(\"spSelected\").innerHTML = \"Selected (\" + selectedRowCount+ \")\";\n\t//catalogCode.push(orderCatalogCode);\n\t\n}\nfunction addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,objChkBox,orderId)\n{\n\tif(!bExpand)\n\t\t{\n\t\t  expand();\n\t\t}\n\tvar strCatalogCode = \"\";\n\tif(objChkBox.checked)\n\t{\n\t\t\n\t\tvar oCode = $(objChkBox).attr(\'data-orderCatalogCode\');\n\t\tvar bDuplicateCatCode = false;\n\t\tvar bDuplicateORderSet = false;\n\t\tvar orderset = $(objChkBox).attr(\'data-catalogNature\');\n\t\tvar currentOrderSet = $(objChkBox).attr(\'data-currentCatlogNatue\');\n\t\tvar tblOrderSet = \"\";\n\t\tif(orderset == null)\n\t\t{\n\t\t\torderset = \"\";\n\t\t}\n\t\t\n\t\t\n\t\t//alert(oCode)\n\t\t//var tblObj = null;\n\t\t//tblObj = $(\"[data-orderCatalogCode = \'\" + oCode + \"\']\");\n\t\t//alert(tblObj);\n\t\t\n\t\t $(\".tbSelectedResults\").each(function(index, value) {      \n\t\t\t\tstrCatalogCode =  $(this).attr(\'data-orderCatalogCode\');\n\t\t\t\ttblOrderSet = $(this).attr(\'data-orderSet\');\n\t\t\t\tif(strCatalogCode == orderCatalogCode)\n\t\t\t\t{\n\t\t\t\t\tbDuplicateCatCode = true;\n\t\t\t\t}\n\t\t\t\tif(tblOrderSet != null && tblOrderSet != \"\" && currentOrderSet != null && currentOrderSet != \"\")\n\t\t\t\t{\n\t\t\t\t\t//if(tblOrderSet == currentOrderSet && currentOrderSet == \"S\")\n\t\t\t\t\tif(tblOrderSet == \"S\" && currentOrderSet == \"S\")\t\n\t\t\t\t\t{\n\t\t\t\t\t\tbDuplicateORderSet = true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\n\t     });\n\t\t\tif(!bDuplicateCatCode && !bDuplicateORderSet)\n\t\t\t{\n\t\t\t\t$(\'#dvSelectContents\').append(\"<table class = \'tbSelectedResults\' onclick = \'removeSelectedContent(this)\' data-orderSet = \'\" +orderset + \"\' data-orderId =\'\" +orderId + \"\' data-orderCatalogCode =\'\" +orderCatalogCode + \"\' data-orderEncounterId = \'\" +encounterId + \"\' cellpadding = \'0\' cellspacing = \'0\'><tr style = \'width:100%;height:100%\'><td style = \'height : 100%;width:2%\'>&nbsp;</td><td align = \'left\' valign = \'center\' style = \'height : 100%;width:89%;word-break:break-all\' ><span class = \'spanSaveContent\'>\"+catalogSynonym +\"</span></td><td align = \'left\' valign = \'center\' style = \'height : 100%;width:9%\' ><img src = \'../images/Remove.png\'></img></td><tr></table>\");\n\t\t\t\t//$(\'#dvSelectContents\').append(\"<table class = \'tbSelectedResults\' onclick = \'removeSelectedContent(this)\' data-orderId =\'\" +orderId + \"\' data-orderCatalogCode =\'\" +orderCatalogCode + \"\' data-orderEncounterId = \'\" +encounterId + \"\' cellpadding = \'0\' cellspacing = \'0\'><tr style = \'width:100%;height:100%\'><td style = \'height : 100%;width:2%\'>&nbsp;</td><td align = \'left\' valign = \'center\' style = \'height : 100%;width:89%\' ><span class = \'spanSaveContent\'>\"+catalogSynonym +\"</span></td><td align = \'left\' valign = \'center\' style = \'height : 100%;width:9%\' ><img src = \'../images/Remove.png\'></img></td><tr></table>\");\n\t\t\t\t//$(\'#dvSelectContents\').append(\"<table class = \'tbSelectedResults\' onclick = \'removeSelectedContent(this,\" + obj +\")\' data-orderCatalogCode =\'\" +orderCatalogCode + \"\' data-orderEncounterId = \'\" +encounterId + \"\' cellpadding = \'0\' cellspacing = \'0\'><tr style = \'width:100%;height:100%\'><td style = \'height : 100%;width:1%\'></td><td align = \'left\' valign = \'center\' style = \'height : 100%;width:89%\' ><span class = \'spanSaveContent\'>\"+catalogSynonym +\"</span></td><td align = \'left\' valign = \'center\' style = \'height : 100%;width:10%\' ><img src = \'../images/Remove.png\'></img></td><tr></table>\");\n\t\t\t\t//alert(orderId);\n\t\t\t\tif(orderId == null || orderId == \"\")\n\t\t\t\t{\n\t\t\t\t\tcatalogCode.push(orderCatalogCode);\n\t\t\t\t\t//alert(catalogCode);\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tarOrderId.push(orderId);\n\t\t\t\t}\n\t\t\t\tselectedRowCount++;\n\t\t\t\tdocument.getElementById(\"spSelected\").innerHTML = \"Selected (\" + selectedRowCount+ \")\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t\n\t\t\t   var msg = \"\";\n\t\t\t   if(bDuplicateCatCode)\n\t\t\t\t{\n\t\t\t\t   msg = \"Duplicate Orders not allowed\";\n\t\t\t\t}\n\t\t\t   else if(bDuplicateORderSet)\n\t\t\t\t{\n\t\t\t\t   msg = \"Order Set already Selected\";\n\t\t\t\t}\n\t\t\t   alert(msg);\n\t\t\t   objChkBox.checked = false;\n\t\t\t}\n\t\t\n\t\t\n\t}\n\telse\n\t{\n\t\tvar oCode = $(obj";
    private final static byte[]  _wl_block1_0Bytes = _getBytes( _wl_block1_0 );

    private final static java.lang.String  _wl_block1_1 ="ChkBox).attr(\'data-orderCatalogCode\');//data-orderCatalogCode\n\t\tvar ordId = $(objChkBox).attr(\'data-orderId\');\n\t\tvar tblObj = null;\n\t\tif(orderId != null && orderId != \"\")\n\t\t{\n\t\t\ttblObj = $(\"[data-orderId = \'\" + ordId + \"\']\");\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttblObj = $(\"[data-orderCatalogCode = \'\" + oCode + \"\']\");\n\t\t}\n\t\t\n\t\tif(tblObj != null)\n\t\tremoveSelectedContent(tblObj);\n\t}\n\t\n}\nfunction returnCatalogCode()\n{\n\treturn catalogCode;\n}\nfunction returnOrderId()\n{\n\treturn arOrderId;\n}\nfunction placeOrders(objBtn)\n{\n\t///* ---Saraswathi added - Start */\n\tobjBtn.style.border = \"3px solid #48d1d8\";\n\tvar saveButtonClicked = \'false\';\n\t//document.getElementById(\"hdnSaveTriggered\").value = saveButtonClicked;\n\tvar countSelected=0;\n\t///* ---Saraswathi added - End */\n\tvar catalogCode = \"\";\n\tvar catalogSynonym = \"\";\n\tvar encounterId = \"\";\n\t $(\".tbSelectedResults\").each(function(index, value) {      \n\t\tcatalogCode =  $(this).attr(\'data-orderCatalogCode\');\n\t\t//catalogSynonym = $(this).attr(\'data-catalogSynonym\');\n\t\tencounterId = $(this).attr(\'data-orderEncounterId\');\n\t\tvar strCatalogCode = \"<input type = \'hidden\' name = \'hdnCatalogCode\" + index + \"\' value = \'\" + catalogCode + \"\' />\";\n\t\tvar strEncounterCode = \"<input type = \'hidden\' name = \'hdnEncounterCode\" + index + \"\' value = \'\" +encounterId + \"\' />\";\n\t\t$(\'#frmSelectORder\').append(strCatalogCode);\n\t\t$(\'#frmSelectORder\').append(strEncounterCode);\n\t//\t$(\'#frmSelectORder\').append(\"<input type = \'hidden\' name = hdnEnCount\" + index + \" value = \" + encounterId \"/>\");\n\t\t///* ---Saraswathi added - Start */\n\t\tsaveButtonClicked = \"true\";\n\t\tcountSelected++; \n\t\t///* ---Saraswathi added - End */\n\t });\n\t// /* ---Saraswathi added - Start */\n\t document.getElementById(\"hdnCountSelected\").value=countSelected;\n\t document.getElementById(\"hdnSaveTriggered\").value = saveButtonClicked;\n\t //alert(countSelected);\n\t// /* ---Saraswathi added - End */\n\t \n\t document.getElementById(\"frmSelectORder\").submit();\n}\nfunction loadWidgets()\n{\n\twindow.parent.showLoadingMsg();\n}\n</script>\n\n<body  style = \"background-color : #ffffff\" onload = \"Loading()\">\n\t<section data-role = \"page\" style = \"padding:0px;background-color : #ffffff\">\n\t\t <form id = \"frmSelectORder\" method = \"post\" >\n\t\t\t <div data-role = \"none\" class =\'divmain\' id = \'dvmain\'  style=\"padding:0px\" >\n\t\t\t   <div data-role = \"none\" class = \"dvViewNotes\">\n\t\t\t     <table style=\"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t       <tr style=\"width:100%;height:100%\">\n\t\t\t         <td style = \"width : 95%\" align = \"left\" valign = \"center\">\n\t\t\t            <span class = \"spanViewNotes\">Select Orders</span>\n\t\t\t            \n\t\t\t         </td> \n\t\t\t         <td style=\"width:5%\"  align = \"center\" valign = \"middle\" onclick = \"loadWidgets()\">\n\t\t\t            <img src = \"../images/Close.png\"></img>\n\t\t\t         </td>\n\t\t\t       </tr>\n\t\t\t     </table>\n\t\t\t   </div>\n\t\t\t   \n\t\t\t   <div id = \"dvOrderContent\" class = \"dvOrdersContent\" data-role = \"none\">\n\t\t\t   \n\t\t\t     <table id = \"tabOrder\" class = \"tabOrder\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t       <tr >\n\t\t\t         <td class = \"tdTab\" valign = \"center\" align = \"center\" id = \"tdSearchOrder\" onclick = \"searchTabActive()\"><span id = \"spSrchOrder\" class = \"spTab\">Search Orders</span></td>\n\t\t\t         <td class = \"tdTab\" valign = \"center\" align = \"center\" id = \"tdTickSheet\" onclick = \"changeTickSheetState()\"><span id = \"spTickSheet\"class = \"spTab\">Tick Sheets</span></td>\n\t\t\t         <td class = \"tdTab\" valign = \"center\" align = \"center\" id = \"tdExstOrder\" onclick = \"changeExtState()\"><span id = \"spExtOrd\" class = \"spTab\">Existing Orders</span></td>\n\t\t\t       </tr>\n\t\t\t     </table>\n\t\t\t      <div style = \"height:auto;overflow:auto;padding:0px\" data-role = \"none\">\n                      <iframe frameborder=\"0\" id=\"orderFrame\" src=\"SearchOrder.jsp?patientclass=";
    private final static byte[]  _wl_block1_1Bytes = _getBytes( _wl_block1_1 );

    private final static java.lang.String  _wl_block2 ="\" scrolling =\"yes\" style=\"padding:0px;display:block\" width = \"100%\" ></iframe>\n                  </div>   \n\t\t\t        \n\t\t\t   </div> \n\t\t\t   <!--  save div -->\n\t\t\t   <div id = \"dvOrderSave\" class = \"dvOrderSave\" data-role = \"none\" style = \"display:none\">\n\t\t\t      <div data-role = \"none\" class = \"dvViewNotes\" onclick = \"slide()\">\n\t\t\t\t            <table style=\"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t\t       <tr style=\"width:100%;height:100%\">\n\t\t\t\t\t\t         <td style = \"width : 90%\" align = \"left\" valign = \"center\">\n\t\t\t\t\t\t           <span class = \"spTab\" id = \"spSelected\">Selected (0) </span>\n\t\t\t\t\t\t            \n\t\t\t\t\t\t         </td> \n\t\t\t\t\t\t         <td style=\"width:10%\"  align = \"center\" valign = \"bottom\">\n\t\t\t\t\t\t            <img src = \"../images/SelectedPanelRight.png\"></img>\n\t\t\t\t\t\t         </td>\n\t\t\t\t\t\t       </tr>\n\t\t\t\t     </table>\n\t\t\t      </div>\n\t\t\t      <div id = \"dvSelectContents\" class = \"dvSelectContents\" >\n\t\t\t        \n\t\t\t      </div>\n\t\t\t       <div id = \"dvSaveArea\" class = \"dvSaveArea\" >\n\t\t\t          <table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\" class = \"tbSave\">\n\t\t\t\t\t\t     <tr style = \"width:100%;height:100%\" >\n\t\t\t\t\t\t       <td>    \n\t\t\t\t\t\t       </td>\n\t\t\t\t\t\t       <td style = \"width : 80%\" align = \"right\" valign = \"center\">\n\t\t\t\t\t\t        \t<input type =\"button\" name=\'save_btn\' id=\'save_btn\' value=\'Save\' class=\"btnType1\"  data-role = \"none\" onclick = \"placeOrders(this)\" />\n\t\t\t\t\t\t       </td>\n\t\t\t\t\t\t     </tr>\n\t\t\t\t\t     </table>\n\t\t\t      </div>\n\t\t\t   </div>\n\t\t\t   \n\t\t\t   <div id = \"dvSlide\" class = \"dvOrderSLide\" data-role = \"none\" style = \"display:block\" >\n\t\t\t       <div data-role = \"none\" class = \"dvViewNotes\" onclick = \"expand()\">\n\t\t\t\t     <table style=\"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t       <tr style=\"width:100%;height:100%\">\n\t\t\t\t\t         <td style = \"width : 10%\" align = \"center\" valign = \"bottom\">\n\t\t\t\t\t          <img src = \"../images/SelectedPanelLeft.png\"></img>\n\t\t\t\t\t            \n\t\t\t\t\t         </td> \n\t\t\t\t\t         <td style=\"width:90%\"  align = \"center\" valign = \"middle\">\n\t\t\t\t\t            \n\t\t\t\t\t         </td>\n\t\t\t\t\t       </tr>\n\t\t\t\t     </table>\n\t\t\t      </div>\n\t\t\t      <div style = \"height:auto;width:auto\">\n\t\t\t        <table style=\"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t       <tr style=\"width:100%;height:100%\">\n\t\t\t\t\t         <td style = \"width : 10%\" align = \"center\" valign = \"bottom\">\n\t\t\t\t\t          \n\t\t\t\t\t            \n\t\t\t\t\t         </td> \n\t\t\t\t\t         <td style=\"width:90%\"  align = \"center\" valign = \"center\">\n\t\t\t\t\t           <b>S</b><br><b>E</b><br><b>L</b><br><b>E</b><br><b>C</b><br><b>T</b><br><b>E</b><br><b>D</b>\n\t\t\t\t\t         </td>\n\t\t\t\t\t       </tr>\n\t\t\t\t     </table>\n\t\t\t        \n\t\t\t      </div>\n\t\t\t      \n\t\t\t   </div>\n\t\t\t</div><!--   div main -->\n\t\t\t<input type = \"hidden\" name = \"hdnPatClass\" id = \"hdnPatClass\" value = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" />\n\t\t\t<input type = \"hidden\" name = \"hdnOrientation\" id = \"hdnOrientation\" value = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" />\n\t\t\t<!--   Saraswathi added - Start -->\n\t\t\t<input type = \"hidden\" id = \"hdnSaveTriggered\" name = \"hdnSaveTriggered\" value = \"false\" />\n\t\t\t<input type = \"hidden\" id = \"hdnCountSelected\" name = \"hdnCountSelected\" value = \"0\" />\n\t\t\t<input type = \"hidden\" id = \"hdnSaveResult\" name = \"hdnSaveResult\" value = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" />\n\t\t\t<!--   Saraswathi added - Start -->\n\t\t </form> \n\t</section>  \n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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

request.setCharacterEncoding("UTF-8");
 String patientClass = "";
/* ---Saraswathi added - Start */
 String saveTriggered = "";
 String saveResult = "NotYetSaved";
 /* ---Saraswathi added - end */
 if(request.getParameter("patientclass") != null)
 {
	 patientClass = request.getParameter("patientclass");
 }
 String orientation = "landscape";
 if(request.getParameter("orientation") != null)
 {
	 orientation = request.getParameter("orientation").trim();
 }
 
 /* ---Saraswathi added - Start */
 if(request.getParameter("hdnSaveTriggered") != null)
 {
	 saveTriggered = request.getParameter("hdnSaveTriggered");
 }
 
 if(saveTriggered != null && saveTriggered.equals("true"))
 {
	 int orderCount = Integer.parseInt(request.getParameter("hdnCountSelected"));
	 java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
	 ArrayList<InsertOrderHO> insertOrderHOArrayList = new ArrayList<InsertOrderHO>();
	 InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
	 InsertOrderResponse insertOrderResponse = new InsertOrderResponse();
	 SelectOrderDetails selectOrderDetails = new SelectOrderDetails();
	 for(int i=0;i<orderCount;i++)
	 {
		 InsertOrderHO insertOrderHO = new InsertOrderHO();
		 String catalogCode = request.getParameter("hdnCatalogCode" + i);
		 String patientID = (String)session.getValue("PatientID");
		 String encounterId = request.getParameter("hdnEncounterCode" + i);
		 String addedById = (String)session.getValue("login_user");
		 String addedDate = dateFormat.format(new java.util.Date());
				 //com.ehis.util.DateUtils.getCurrentDate("DMY", "en");
		 String addedAtWsNo = "IPAD";
		 String addedFacilityId = (String)session.getValue("facility_id")==null?"ISoft":(String)session.getValue("facility_id");
		 String modifiedById = addedById;
		 String modifiedDate = addedDate;
		 String modifiedAtWsNo = addedAtWsNo;
		 String modifiedFacilityId = addedFacilityId;
		 String facilityId = addedFacilityId;
		 String ordPractId = (String)session.getValue("ca_practitioner_id")==null ? "Default pract ID" :(String)session.getValue("ca_practitioner_id");
		 String ordDateTime = addedDate;
		 String recentStatusInd = "";//nullable
		 
		 insertOrderHO.setPatientID(patientID);
		 insertOrderHO.setOrderCatalogCode(catalogCode);
		 insertOrderHO.setEncounterId(encounterId);
		 insertOrderHO.setAddedById(addedById);
		 insertOrderHO.setAddedDate(addedDate);
		 insertOrderHO.setAddedAtWsNo(addedAtWsNo);
		 insertOrderHO.setAddedFacilityId(addedFacilityId);
		 insertOrderHO.setModifiedById(modifiedById);
		 insertOrderHO.setModifiedDate(modifiedDate);
		 insertOrderHO.setModifiedAtWsNo(modifiedAtWsNo);
		 insertOrderHO.setModifiedFacilityId(modifiedFacilityId);
		 insertOrderHO.setFacilityId(facilityId);
		 insertOrderHO.setOrdPractId(ordPractId);
		 insertOrderHO.setOrdDateTime(ordDateTime);
		 insertOrderHO.setRecentStatusInd(recentStatusInd);
		 
		 insertOrderHOArrayList.add(insertOrderHO);
	 }
	 insertOrderRequest.setHttpRequest(request);
	 insertOrderRequest.setInsertOrderHOArrayList(insertOrderHOArrayList);
	 insertOrderResponse = selectOrderDetails.insertOrder(insertOrderRequest);
	 saveResult = insertOrderResponse.getStatus();
	 System.out.println(insertOrderResponse.getStatus());
 }
 /* ---Saraswathi added - end */

            _bw.write(_wl_block1_0Bytes, _wl_block1_0);
            _bw.write(_wl_block1_1Bytes, _wl_block1_1);
            out.print( String.valueOf(patientClass ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientClass ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(orientation ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(saveResult ));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
