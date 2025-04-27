package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import org.json.simple.*;

public final class __aempsearchresultorder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEMPSearchResultOrder.jsp", 1742377353576L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nCreated by    : Vinod Babu M V -  11/24/2009\nModule/Function : To re order the Current Emergency Result Fields\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n<title>Configure Display Order</title> \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/fonts-min.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/button.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/stdbutton.css\"></link>\n \t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/container.css\'></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/container-skin.css\'></link> \n\t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/skin.css\'></link> \n\n<style type=\"text/css\">\n\ndiv.workarea { padding:10px;  }\ndiv.workareaSeq { padding-left:10px; padding-right:4px; }\n\nul.draglist { \n    position: relative;\n    width: 200px; \n    height:240px;\n    background: #f7f7f7;\n    border: 1px solid gray;\n    list-style: none;\n    margin:0;\n    padding:0;\n}\n\nul.draglist li {\n    margin: 1px;\n    cursor: move; \n}\n\nul.draglist_alt { \n    position: relative;\n    width: 200px; \n    list-style: none;\n    margin:0;\n    padding:0;\n    /*\n       The bottom padding provides the cushion that makes the empty \n       list targetable.  Alternatively, we could leave the padding \n       off by default, adding it when we detect that the list is empty.\n    */\n    padding-bottom:20px;\n}\n\nul.draglistSeq { \n    position: relative;\n    width: 4px; \n    height:240px;\n    background: #f7f7f7;\n    border: 1px solid gray;\n    list-style: none;\n    margin:0;\n    padding:0;\n}\n\nul.draglistSeq_alt { \n    position: relative;\n    width: 5px; \n    list-style: none;\n    margin:0;\n    padding:0;\n\tpadding-bottom:20px;\n}\n\nul.draglist_alt li {\n    margin: 1px;\n    cursor: move; \n}\n\nli.list1 {\n    background-color: #56CBF1;\n    border:1px solid #7EA6B2;\n}\n\nli.list2 {\n    background-color: #56CBF1;\n    border:1px solid #7EA6B2;\n\theight:19px;\n}\n\n#user_actions { float: right; }\n\n</style>\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eAE/js/yahoo-dom-event.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/connection-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/element-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/dragdrop-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/button-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/animation-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/event-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/yahoo-min.js\' language=\'javascript\'></script>\t\n\n\t<SCRIPT LANGUAGE=\"JavaScript\">\n\tvar fieldOrder = \"\";\n\t(function() {\n\tvar Dom = YAHOO.util.Dom;\n\tvar Event = YAHOO.util.Event;\n\tvar DDM = YAHOO.util.DragDropMgr;\n\n\tYAHOO.example.DDApp = {\n    init: function() {\n\n        var rows=17,cols=1,i,j;\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0637*/\n\t\t//var reattendance=\"\";\t\n\t\tif(document.AEMPSearchResultOrderForm.isForAdmission.value==\"true\")\n\t\t{\n\t\t\t rows=18;\n\t\t}\n\t\tif(document.AEMPSearchResultOrderForm.re_attendance.value==\"true\" && document.AEMPSearchResultOrderForm.isPendingForAdmissionAppl.value==\"true\"){//Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658\n\t\t         rows=20;\n\t\t}\t\t\n\t\t//End ML-MMOH-CRF-0637\n\t\t\n        for (i=1;i<cols+1;i=i+1) {\n            new YAHOO.util.DDTarget(\"ul\"+i);\n        }\n\n        for (i=1;i<cols+1;i=i+1) {\n            for (j=1;j<rows+1;j=j+1) {\n                new YAHOO.example.DDList(\"li\" + i + \"_\" + j);\n            }\n        }\n\t Event.on(\"saveOrd\", \"click\", this.saveOrder);\n\n    },\n\n    saveOrder: function() {\n        var parseList = function(ul, title) {\n            var items = ul.getElementsByTagName(\"li\");\n            var out = title + \"=\";\n            for (i=0;i<items.length;i=i+1) {\n                out += items[i].name+\"`\"+items[i].innerHTML+\"~\";\n            }\n\t\t    return out;\n        };\n\n        var ul1=Dom.get(\"ul1\");\n\t\tfieldOrder = parseList(ul1, \"fieldOrder\")\n//\t\talert(fieldOrder);\n\t\tvar handleSuccess = function(o){\n\t\tvar status = \"\";\n\t\t\tif(o.responseText !== undefined){\n\t\t\t\tstatus = \"Transaction id: \" + o.tId;\n\t\t\t\tstatus += \"HTTP status: \" + o.status;\n\t\t\t\tstatus += \"Status code message: \" + o.statusText;\n\t\t\t\tstatus += \"<li>HTTP headers: <ul>\" + o.getAllResponseHeaders + \"</ul></li>\";\n\t\t\t\tstatus += \"JSP response: \" + o.responseText;\n\t\t\t\tstatus += \"Argument object: \" + o.argument;\n\t\t\t}\n\t\t\twindow.returnValue = \'0\';\n\t\t\twindow.close();\n\t\t}\n\t\tvar handleFailure = function(o){\n\t\tvar status = \"\";\n\t\t\tif(o.responseText !== undefined){\n\t\t\t\tstatus = \"Transaction id: \" + o.tId;\n\t\t\t\tstatus += \"HTTP status: \" + o.status;\n\t\t\t\tstatus += \"Status code message: \" + o.statusText;\n\t\t\t\tstatus += \"<li>HTTP headers: <ul>\" + o.getAllResponseHeaders + \"</ul></li>\";\n\t\t\t\tstatus += \"JSP response: \" + o.responseText;\n\t\t\t\tstatus += \"Argument object: \" + o.argument;\n\t\t\t}\n//\t\t\talert(\'Failure status : \' +status);\n\t\t\twindow.returnValue=\'-1\';\n\t\t\twindow.close();\n\t\t}\n\n\t\tvar callback =\n\t\t{\n\t\t  success:handleSuccess,\n\t\t  failure: handleFailure,\n\t\t  argument: []\n\t\t};\n\n        \n\t\tvar request = YAHOO.util.Connect.asyncRequest(\'POST\', \"../../eAE/jsp/AEMPCurEmerOrder.jsp\", callback, fieldOrder);\n\n    },\n\n    switchStyles: function() {\n        Dom.get(\"ul1\").className = \"draglist_alt\";\n        \n    }\n};\n\n//////////////////////////////////////////////////////////////////////////////\n// custom drag and drop implementation\n//////////////////////////////////////////////////////////////////////////////\n\nYAHOO.example.DDList = function(id, sGroup, config) {\n\n    YAHOO.example.DDList.superclass.constructor.call(this, id, sGroup, config);\n\n    this.logger = this.logger || YAHOO;\n    var el = this.getDragEl();\n    Dom.setStyle(el, \"opacity\", 0.67); // The proxy is slightly transparent\n\n    this.goingUp = false;\n    this.lastY = 0;\n};\n\nYAHOO.extend(YAHOO.example.DDList, YAHOO.util.DDProxy, {\n\n    startDrag: function(x, y) {\n        this.logger.log(this.id + \" startDrag\");\n\n        // make the proxy look like the source element\n        var dragEl = this.getDragEl();\n        var clickEl = this.getEl();\n        Dom.setStyle(clickEl, \"visibility\", \"hidden\");\n\n        dragEl.innerHTML = clickEl.innerHTML;\n\n        Dom.setStyle(dragEl, \"color\", Dom.getStyle(clickEl, \"color\"));\n        Dom.setStyle(dragEl, \"backgroundColor\", Dom.getStyle(clickEl, \"backgroundColor\"));\n        Dom.setStyle(dragEl, \"border\", \"2px solid gray\");\n    },\n\n    endDrag: function(e) {\n\n        var srcEl = this.getEl();\n        var proxy = this.getDragEl();\n\n        // Show the proxy element and animate it to the src element\'s location\n        Dom.setStyle(proxy, \"visibility\", \"\");\n        var a = new YAHOO.util.Motion( \n            proxy, { \n                points: { \n                    to: Dom.getXY(srcEl)\n                }\n            }, \n            0.2, \n            YAHOO.util.Easing.easeOut \n        )\n        var proxyid = proxy.id;\n        var thisid = this.id;\n\n        // Hide the proxy and show the source element when finished with the animation\n        a.onComplete.subscribe(function() {\n                Dom.setStyle(proxyid, \"visibility\", \"hidden\");\n                Dom.setStyle(thisid, \"visibility\", \"\");\n            });\n        a.animate();\n    },\n\n    onDragDrop: function(e, id) {\n\n        // If there is one drop interaction, the li was dropped either on the list,\n        // or it was dropped on the current location of the source element.\n        if (DDM.interactionInfo.drop.length === 1) {\n\n            // The position of the cursor at the time of the drop (YAHOO.util.Point)\n            var pt = DDM.interactionInfo.point; \n            // The region occupied by the source element at the time of the drop\n            var region = DDM.interactionInfo.sourceRegion; \n\n            // Check to see if we are over the source element\'s location.  We will\n            // append to the bottom of the list once we are sure it was a drop in\n            // the negative space (the area of the list without any list items)\n            if (!region.intersect(pt)) {\n                var destEl = Dom.get(id);\n                var destDD = DDM.getDDById(id);\n                destEl.appendChild(this.getEl());\n                destDD.isEmpty = false;\n                DDM.refreshCache();\n            }\n\n        }\n    },\n\n    onDrag: function(e) {\n\n        // Keep track of the direction of the drag for use during onDragOver\n        var y = Event.getPageY(e);\n\n        if (y < this.lastY) {\n            this.goingUp = true;\n        } else if (y > this.lastY) {\n            this.goingUp = false;\n        }\n\n        this.lastY = y;\n    },\n\n    onDragOver: function(e, id) {\n    \n        var srcEl = this.getEl();\n        var destEl = Dom.get(id);\n        // We are only concerned with list items, we ignore the dragover\n        // notifications for the list.\n        if (destEl.nodeName.toLowerCase() == \"li\") {\n            var orig_p = srcEl.parentNode;\n            var p = destEl.parentNode;\n            if (this.goingUp) {\n                p.insertBefore(srcEl, destEl); // insert above\n            } else {\n                p.insertBefore(srcEl, destEl.nextSibling); // insert below\n            }\n            DDM.refreshCache();\n        }\n    }\n});\n\nvar oButton = new YAHOO.widget.Button({\n                                        id: \"saveOrd\", \n                                        type: \"push\", \n                                        label: \"Save\", \n                                        container: \"saveOrderId\"\n                                    });\n\nEvent.onDOMReady(YAHOO.example.DDApp.init, YAHOO.example.DDApp, true);\n})();\n\t\n\t/*Added by Thamizh selvi on 10th May 2018 against ML-MMOH-CRF-0658 Start*/\n\twindow.onload = function(){\n\t\tif(document.AEMPSearchResultOrderForm.newRecsCnt && document.AEMPSearchResultOrderForm.recCnt && document.AEMPSearchResultOrderForm.DFCnt){\n\t\t\tvar newRecsCnt = document.AEMPSearchResultOrderForm.newRecsCnt.value;\n\t\t\tvar recCnt = document.AEMPSearchResultOrderForm.recCnt.value;\n\t\t\tvar DFCnt = document.AEMPSearchResultOrderForm.DFCnt.value;\n\t\t\t\n\t\t\tif(newRecsCnt != 0){\n\t\t\t\tinsertNewOrderColumn(recCnt,DFCnt);\t\t\n\t\t\t}\n\t\t}\n\t}\n\t\n\tfunction insertNewOrderColumn(recCnt,DFCnt){\n\t\t$.ajax({  \n\t\t\turl:\'../../servlet/eAE.AEManagePatientServlet\',  \n\t\t\ttype:\'post\',  \n\t\t\tdata:{\'operation_mode\':\'InsertNewOrderColumn\',\'DFCnt\':DFCnt,\'recCnt\':recCnt},\n\t\t\tasync: false, \n\t\t\tsuccess: function(data) {\n\t\t\t\t\n\t\t\t}\n\t\t});\n\t}/*End*/\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</head>\n<body class=\"yui-skin-sam\" onMouseDown=\"CodeArrest()\">\n<form name=\'AEMPSearchResultOrderForm\' id=\'AEMPSearchResultOrderForm\'>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'2\' width=\'100%\'>\n <th colspan=\'2\'>Field order</td>\n<tr>\n<td>\n<div class=\"workareaSeq\">\n<ul id=\"ulSeq\" class=\"draglistSeq\">\n\t<li class=\"list2\" id=\'SeqNo_1\'>01</li>\n\t<li class=\"list2\" id=\'SeqNo_2\'>02</li>\n\t<li class=\"list2\" id=\'SeqNo_3\'>03</li>\n\t<li class=\"list2\" id=\'SeqNo_4\'>04</li>\n\t<li class=\"list2\" id=\'SeqNo_5\'>05</li>\n\t<li class=\"list2\" id=\'SeqNo_6\'>06</li>\n\t<li class=\"list2\" id=\'SeqNo_7\'>07</li>\n\t<li class=\"list2\" id=\'SeqNo_8\'>08</li>\n\t<li class=\"list2\" id=\'SeqNo_9\'>09</li>\n\t<li class=\"list2\" id=\'SeqNo_10\'>10</li>\n\t<li class=\"list2\" id=\'SeqNo_11\'>11</li>\n\t<li class=\"list2\" id=\'SeqNo_12\'>12</li>\n\t<li class=\"list2\" id=\'SeqNo_13\'>13</li>\n\t<li class=\"list2\" id=\'SeqNo_14\'>14</li>\n\t<li class=\"list2\" id=\'SeqNo_15\'>15</li>\n\t<li class=\"list2\" id=\'SeqNo_16\'>16</li>\n\t<li class=\"list2\" id=\'SeqNo_17\'>17</li>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<li class=\"list2\" id=\'SeqNo_18\'>18</li> \n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<li class=\"list2\" id=\'SeqNo_19\'>19</li> \n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<li class=\"list2\" id=\'SeqNo_20\'>20</li> \n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</ul>\n<div>\n</td>\n<td>\n<div class=\"workarea\">\n  <ul id=\"ul1\" class=\"draglist\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n    <li class=\"list1\" id=\'li1_1\'  name=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</li>\n    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n    <li class=\"list1\" id=\'li1_2\'  name=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</li>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n    <li class=\"list1\" id=\'li1_3\'  name=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n    <li class=\"list1\" id=\'li1_4\'  name=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n    <li class=\"list1\" id=\'li1_5\'  name=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n    <li class=\"list1\" id=\'li1_6\'  name=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n    <li class=\"list1\" id=\'li1_7\'  name=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n    <li class=\"list1\" id=\'li1_8\'  name=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n    <li class=\"list1\" id=\'li1_9\'  name=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n    <li class=\"list1\" id=\'li1_10\'  name=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n    <li class=\"list1\" id=\'li1_11\'  name=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n    <li class=\"list1\" id=\'li1_12\'  name=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n    <li class=\"list1\" id=\'li1_13\'  name=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n    <li class=\"list1\" id=\'li1_14\'  name=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n    <li class=\"list1\" id=\'li1_15\'  name=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n    <li class=\"list1\" id=\'li1_16\'  name=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</li> \n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n    <li class=\"list1\" id=\'li1_17\'  name=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n    <li class=\"list1\" id=\'li1_18\'  name=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n    <li class=\"list1\" id=\'li1_19\'  name=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n    <li class=\"list1\" id=\'li1_20\'  name=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n  </ul>\n</div>\n</td>\n</tr>\n<tr>\n<td colspan=\'2\'><div id=\'saveOrderId\' style=\"padding-top:115px;\"></div></td>\n</tr>\n</table>\n<input type=\"hidden\" name=\"isForAdmission\" id=\"isForAdmission\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"re_attendance\" id=\"re_attendance\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"> <!--this line added for this CRF ML-MMOH-CRF-0637 -->\n<!--Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start-->\n<input type=\"hidden\" name=\"isPendingForAdmissionAppl\" id=\"isPendingForAdmissionAppl\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"newRecsCnt\" id=\"newRecsCnt\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"> \n<input type=\"hidden\" name=\"recCnt\" id=\"recCnt\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"> \n<input type=\"hidden\" name=\"DFCnt\" id=\"DFCnt\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"> \n<!--End-->\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

Connection con = null;
ArrayList arrList = new ArrayList();
//Below line added for this CRF ML-MMOH-CRF-0637
Boolean reattendance = false;
/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
Boolean isPendingForAdmissionAppl	= false;
JSONObject fieldOrderJSON	= new JSONObject();
int newRecsCnt = 0;
int recCnt = 0;
int DFCnt = 0;
/*End*/

Boolean isForAdmission = false;

try {
		String facility_id  =	(String)session.getValue("facility_id");
		String loginUser = ((String)session.getValue("login_user")==null)?"":(String)session.getValue("login_user");
		con		=	(Connection)ConnectionManager.getConnection(request);		
		
		/*Added by Thamizh selvi on 9th May 2018 against ML-MMOH-CRF-0658*/
		fieldOrderJSON = eAE.AECommonBean.getFieldOrder(con,facility_id,loginUser);
	
		arrList		= (ArrayList) fieldOrderJSON.get("appendedFields");
		newRecsCnt	= (Integer) fieldOrderJSON.get("newRecsCnt");
		recCnt		= (Integer) fieldOrderJSON.get("recCnt");
		DFCnt		= (Integer) fieldOrderJSON.get("DFCnt");
		/*End*/

		//Below line added for this CRF ML-MMOH-CRF-0637
		reattendance = CommonBean.isSiteSpecific(con, "AE", "RE_ATTENDANCE");
		//Added by Himanshu S for ML-MMOH-CRF-1972				
		isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");
		
		isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_PENDING_FOR_ADMISSION_TAB");//Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658

}
 catch(Exception e)
 {
	 e.printStackTrace();
 }
 finally
 {	
	if(con!=null) ConnectionManager.returnConnection(con,request);
 }

            _bw.write(_wl_block4Bytes, _wl_block4);
if(isForAdmission){
            _bw.write(_wl_block5Bytes, _wl_block5);
}
            _bw.write(_wl_block6Bytes, _wl_block6);
if(reattendance){
            _bw.write(_wl_block7Bytes, _wl_block7);
}
            _bw.write(_wl_block6Bytes, _wl_block6);
if(isPendingForAdmissionAppl){
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
  String display = "";
	String name = "";
	String str = "";
	StringTokenizer sToken = null ;
	int size = arrList.size();
	
	
	for (int m=1; m <= size; ++m)
	{
	 str = (String)arrList.get(m-1);
	 sToken = new StringTokenizer(str,"~");
	 name = sToken.nextToken();
	 display = sToken.nextToken().trim();
	 if (m==1) {  
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block12Bytes, _wl_block12);
 } else	if (m==2) {  
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==3) {  
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==4) {  
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==5) {  
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==6) {  
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==7) {  
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==8) {  
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==9) {  
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==10) {  
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==11) {  
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==12) {  
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==13) {  
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==14) {  
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==15) {  
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else	if (m==16) {  
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block29Bytes, _wl_block29);
 } else	if (m==17) {  
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else     if(isForAdmission && m==18) {  
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block29Bytes, _wl_block29);
} else	if (reattendance && m==19) {  
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block29Bytes, _wl_block29);
}	else if(isPendingForAdmissionAppl && m==20) {  
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display));
            _bw.write(_wl_block29Bytes, _wl_block29);
}	}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(isForAdmission));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(reattendance));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(isPendingForAdmissionAppl));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(newRecsCnt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recCnt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(DFCnt));
            _bw.write(_wl_block40Bytes, _wl_block40);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
