package jsp_servlet._emr._jsp;

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

public final class __mrreportsearchresultorder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MRReportSearchResultOrder.jsp", 1709118977736L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<title>Configure Display Order</title> \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/fonts-min.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/button.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/stdbutton.css\"></link>\n \t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/container.css\'></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/container-skin.css\'></link> \n\t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/skin.css\'></link> \n\n<style type=\"text/css\">\n\ndiv.workarea { padding:10px;  }\ndiv.workareaSeq { padding-left:10px; padding-right:4px; }\n\nul.draglist { \n    position: relative;\n    width: 260px; \n    height:240px;\n    background: #f7f7f7;\n    border: 1px solid gray;\n    list-style: none;\n    margin:0;\n    padding:0;\n}\n\nul.draglist li {\n    margin: 1px;\n    cursor: move; \n}\n\nul.draglist_alt { \n    position: relative;\n    width: 200px; \n    list-style: none;\n    margin:0;\n    padding:0;\n    /*\n       The bottom padding provides the cushion that makes the empty \n       list targetable.  Alternatively, we could leave the padding \n       off by default, adding it when we detect that the list is empty.\n    */\n    padding-bottom:20px;\n}\n\nul.draglistSeq { \n    position: relative;\n    width: 4px; \n    height:240px;\n    background: #f7f7f7;\n    border: 1px solid gray;\n    list-style: none;\n    margin:0;\n    padding:0;\n}\n\nul.draglistSeq_alt { \n    position: relative;\n    width: 5px; \n    list-style: none;\n    margin:0;\n    padding:0;\n\tpadding-bottom:20px;\n}\n\nul.draglist_alt li {\n    margin: 1px;\n    cursor: move; \n}\n\nli.list1 {\n    background-color: #56CBF1;\n    border:1px solid #7EA6B2;\n}\n\nli.list2 {\n    background-color: #56CBF1;\n    border:1px solid #7EA6B2;\n\theight:23px;\n}\n\n#user_actions { float: right; }\n\n</style>\n\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eAE/js/yahoo-dom-event.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/connection-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/element-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/dragdrop-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/button-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/animation-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/event-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/yahoo-min.js\' language=\'javascript\'></script>\t\n\n\t<SCRIPT LANGUAGE=\"JavaScript\">\n\tvar fieldOrder = \"\";\n\t(function() {\n\tvar Dom = YAHOO.util.Dom;\n\tvar Event = YAHOO.util.Event;\n\tvar DDM = YAHOO.util.DragDropMgr;\n\n\tYAHOO.example.DDApp = {\n    init: function() { \n\n        var rows=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =",cols=1,i,j;\n        for (i=1;i<cols+1;i=i+1) {\n            new YAHOO.util.DDTarget(\"ul\"+i);\n        }\n\n        for (i=1;i<cols+1;i=i+1) {\n            for (j=1;j<rows+1;j=j+1) {\n                new YAHOO.example.DDList(\"li\" + i + \"_\" + j);\n            }\n        }\n\t Event.on(\"saveOrd\", \"click\", this.saveOrder);\n\n    },\n\n    saveOrder: function() { \n        var parseList = function(ul, title) { \n            var items = ul.getElementsByTagName(\"li\");\n            var out = title + \"=\";\n\t\t\t\n            for (i=0;i<items.length;i=i+1) {\n\t\t\t\t\n\t\t\t\t//out += items[i].name+\"`\"+document.getElementById(\"chk_\"+(i+1)).value+\"@\"+items[i].innerHTML+\"~\";\n\t\t\t\tout += items[i].name+\"`\"+items[i].innerHTML+\"~\";\n            }\n\t\t    return out;\n        };\n\n        var ul1=Dom.get(\"ul1\");\n\t\t\n\t\tfieldOrder = parseList(ul1, \"fieldOrder\")\n\t\t\n\t\tvar handleSuccess = function(o){\n\t\tvar status = \"\";\n\t\t\tif(o.responseText !== undefined){\n\t\t\t\tstatus = \"Transaction id: \" + o.tId;\n\t\t\t\tstatus += \"HTTP status: \" + o.status;\n\t\t\t\tstatus += \"Status code message: \" + o.statusText;\n\t\t\t\tstatus += \"<li>HTTP headers: <ul>\" + o.getAllResponseHeaders + \"</ul></li>\";\n\t\t\t\tstatus += \"JSP response: \" + o.responseText;\n\t\t\t\tstatus += \"Argument object: \" + o.argument;\n\t\t\t}\n\t\t\twindow.returnValue = \'0\';\n\t\t\twindow.close();\n\t\t}\n\t\tvar handleFailure = function(o){\n\t\tvar status = \"\";\n\t\t\tif(o.responseText !== undefined){\n\t\t\t\tstatus = \"Transaction id: \" + o.tId;\n\t\t\t\tstatus += \"HTTP status: \" + o.status;\n\t\t\t\tstatus += \"Status code message: \" + o.statusText;\n\t\t\t\tstatus += \"<li>HTTP headers: <ul>\" + o.getAllResponseHeaders + \"</ul></li>\";\n\t\t\t\tstatus += \"JSP response: \" + o.responseText;\n\t\t\t\tstatus += \"Argument object: \" + o.argument;\n\t\t\t}\n\n\t\t\twindow.returnValue=\'-1\';\n\t\t\twindow.close();\n\t\t}\n\n\t\tvar callback =\n\t\t{\n\t\t  success:handleSuccess,\n\t\t  failure: handleFailure,\n\t\t  argument: []\n\t\t};\n\t\t\n\t\tvar request = YAHOO.util.Connect.asyncRequest(\'POST\', \"../../eMR/jsp/MRReportResultOrder.jsp\", callback, fieldOrder);\n\n    },\n\n    switchStyles: function() {\n        Dom.get(\"ul1\").className = \"draglist_alt\";\n        \n    }\n};\n\n//////////////////////////////////////////////////////////////////////////////\n// custom drag and drop implementation\n//////////////////////////////////////////////////////////////////////////////\n\nYAHOO.example.DDList = function(id, sGroup, config) {\n\n    YAHOO.example.DDList.superclass.constructor.call(this, id, sGroup, config);\n\n    this.logger = this.logger || YAHOO;\n    var el = this.getDragEl();\n    Dom.setStyle(el, \"opacity\", 0.67); // The proxy is slightly transparent\n\n    this.goingUp = false;\n    this.lastY = 0;\n};\n\nYAHOO.extend(YAHOO.example.DDList, YAHOO.util.DDProxy, {\n\n    startDrag: function(x, y) { \n        this.logger.log(this.id + \" startDrag\");\n\n        // make the proxy look like the source element\n        var dragEl = this.getDragEl();\n        var clickEl = this.getEl();\n        Dom.setStyle(clickEl, \"visibility\", \"hidden\");\n\n        dragEl.innerHTML = clickEl.innerHTML;\n\n        Dom.setStyle(dragEl, \"color\", Dom.getStyle(clickEl, \"color\"));\n        Dom.setStyle(dragEl, \"backgroundColor\", Dom.getStyle(clickEl, \"backgroundColor\"));\n        Dom.setStyle(dragEl, \"border\", \"2px solid gray\");\n    },\n\n    endDrag: function(e) { \n\n        var srcEl = this.getEl();\n        var proxy = this.getDragEl();\n\n        // Show the proxy element and animate it to the src element\'s location\n        Dom.setStyle(proxy, \"visibility\", \"\");\n        var a = new YAHOO.util.Motion( \n            proxy, { \n                points: { \n                    to: Dom.getXY(srcEl)\n                }\n            }, \n            0.2, \n            YAHOO.util.Easing.easeOut \n        )\n        var proxyid = proxy.id;\n        var thisid = this.id;\n\n        // Hide the proxy and show the source element when finished with the animation\n        a.onComplete.subscribe(function() {\n                Dom.setStyle(proxyid, \"visibility\", \"hidden\");\n                Dom.setStyle(thisid, \"visibility\", \"\");\n            });\n        a.animate();\n    },\n\n    onDragDrop: function(e, id) { \n        // If there is one drop interaction, the li was dropped either on the list,\n        // or it was dropped on the current location of the source element.\n        if (DDM.interactionInfo.drop.length === 1) {\n\n            // The position of the cursor at the time of the drop (YAHOO.util.Point)\n            var pt = DDM.interactionInfo.point; \n            // The region occupied by the source element at the time of the drop\n            var region = DDM.interactionInfo.sourceRegion; \n\n            // Check to see if we are over the source element\'s location.  We will\n            // append to the bottom of the list once we are sure it was a drop in\n            // the negative space (the area of the list without any list items)\n            if (!region.intersect(pt)) {\n                var destEl = Dom.get(id);\n                var destDD = DDM.getDDById(id);\n                destEl.appendChild(this.getEl());\n                destDD.isEmpty = false;\n                DDM.refreshCache();\n            }\n\n        }\n    },\n\n    onDrag: function(e) { \n\n        // Keep track of the direction of the drag for use during onDragOver\n        var y = Event.getPageY(e);\n\n        if (y < this.lastY) {\n            this.goingUp = true;\n        } else if (y > this.lastY) {\n            this.goingUp = false;\n        }\n\n        this.lastY = y;\n    },\n\n    onDragOver: function(e, id) { \n    \n        var srcEl = this.getEl();\n        var destEl = Dom.get(id);\n        // We are only concerned with list items, we ignore the dragover\n        // notifications for the list.\n        if (destEl.nodeName.toLowerCase() == \"li\") {\n            var orig_p = srcEl.parentNode;\n            var p = destEl.parentNode; \n            if (this.goingUp) {\n                p.insertBefore(srcEl, destEl); // insert above\n            } else {\n                p.insertBefore(srcEl, destEl.nextSibling); // insert below\n            }\n            DDM.refreshCache();\n        }\n    }\n});\n\nvar oButton = new YAHOO.widget.Button({\n                                        id: \"saveOrd\", \n                                        type: \"push\", \n                                        label: \"Save\", \n                                        container: \"saveOrderId\"\n                                    });\n\nEvent.onDOMReady(YAHOO.example.DDApp.init, YAHOO.example.DDApp, true);\n})();\n\n\n\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\"yui-skin-sam\" onMouseDown=\"CodeArrest()\">\n<form name=\'MRResultOrderForm\' id=\'MRResultOrderForm\'>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'2\' width=\'100%\'>\n <th colspan=\'2\'>Field order</td>\n<tr>\n<td>\n<div class=\"workareaSeq\">\n<ul id=\"ulSeq\" class=\"draglistSeq\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<li class=\"list2\" id=\'SeqNo_";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</li>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t</ul>\n<div>\n</td>\n<td>\n<div class=\"workarea\">\n  <ul id=\"ul1\" class=\"draglist\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n   <li class=\"list1\" id=\'li1_";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'  name=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n   <input type=\'checkbox\' name=\'chk_";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' id=\'chk_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</li>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n  </ul>\n</div>\n</td>\n</tr>\n<tr>\n<td colspan=\'2\'><div id=\'saveOrderId\'></div></td>\n</tr>\n</table>\n\n</form>\n</body>\n</html>\n\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection con = null;
ArrayList arrList = new ArrayList();
//Below line added for this CRF ML-MMOH-CRF-0637



JSONObject fieldOrderJSON	= new JSONObject();

int recCnt = 0;



try {
		String facility_id  =	(String)session.getValue("facility_id");
		String loginUser = ((String)session.getValue("login_user")==null)?"":(String)session.getValue("login_user");
		con		=	(Connection)ConnectionManager.getConnection(request);		
		
		
		fieldOrderJSON = eMR.MRCommonBean.getFieldOrder(con,facility_id,loginUser);
	
		arrList		= (ArrayList) fieldOrderJSON.get("appendedFields");
		recCnt		= (Integer) fieldOrderJSON.get("recCnt");
		




}
 catch(Exception e)
 {
	 e.printStackTrace();
 }
 finally
 {	
	if(con!=null) ConnectionManager.returnConnection(con,request);
 }

            _bw.write(_wl_block2Bytes, _wl_block2);
 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(recCnt));
            _bw.write(_wl_block5Bytes, _wl_block5);

for(int i=1;i<=recCnt;i++)
{
	String j = String.format("%02d", i);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(i));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(j));
            _bw.write(_wl_block8Bytes, _wl_block8);

}

            _bw.write(_wl_block9Bytes, _wl_block9);
  String display = "";
	String name = "";
	String str = "";
	String name_chk="";
	String name_chk_status="";
	StringTokenizer sToken = null ;
	int size = arrList.size();
	for (int m=1; m <= size; ++m)
	{
	 str = (String)arrList.get(m-1);
	 sToken = new StringTokenizer(str,"~");
	 name = sToken.nextToken();
	 display = sToken.nextToken().trim();
	 name_chk = sToken.nextToken().trim();
	 
	
	 
	 
	 if(name_chk == null || name_chk.equals("null"))
	 name_chk = "";
	
	String dis_field="";
	
	if(name.equals("request_id") ||name.equals("patient_id") || name.equals("patient_name")  )
		dis_field="disabled";
	
			
			if (name_chk.equals("Y"))
			{	name_chk_status = "checked";}
			else if (name_chk.equals("N"))
			{
				name_chk_status = "unchecked";				 
			}

	 
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(m));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(m));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(m));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(m));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dis_field));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(name_chk_status));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(name_chk));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(display));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
