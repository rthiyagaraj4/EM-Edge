<!DOCTYPE html>
<!-- 
Created by    : Vinod Babu M V -  11/24/2009
Module/Function : To re order the Current Emergency Result Fields
-->
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<%
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
%>
<html>
<head>
<title>Configure Display Order</title> 

<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/fonts-min.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/button.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/stdbutton.css"></link>
 	<link rel="stylesheet" type ="text/css" href='../../eAE/html/container.css'></link>
	<link rel="stylesheet" type ="text/css" href='../../eAE/html/container-skin.css'></link> 
	<link rel="stylesheet" type ="text/css" href='../../eAE/html/skin.css'></link> 

<style type="text/css">

div.workarea { padding:10px;  }
div.workareaSeq { padding-left:10px; padding-right:4px; }

ul.draglist { 
    position: relative;
    width: 260px; 
    height:240px;
    background: #f7f7f7;
    border: 1px solid gray;
    list-style: none;
    margin:0;
    padding:0;
}

ul.draglist li {
    margin: 1px;
    cursor: move; 
}

ul.draglist_alt { 
    position: relative;
    width: 200px; 
    list-style: none;
    margin:0;
    padding:0;
    /*
       The bottom padding provides the cushion that makes the empty 
       list targetable.  Alternatively, we could leave the padding 
       off by default, adding it when we detect that the list is empty.
    */
    padding-bottom:20px;
}

ul.draglistSeq { 
    position: relative;
    width: 4px; 
    height:240px;
    background: #f7f7f7;
    border: 1px solid gray;
    list-style: none;
    margin:0;
    padding:0;
}

ul.draglistSeq_alt { 
    position: relative;
    width: 5px; 
    list-style: none;
    margin:0;
    padding:0;
	padding-bottom:20px;
}

ul.draglist_alt li {
    margin: 1px;
    cursor: move; 
}

li.list1 {
    background-color: #56CBF1;
    border:1px solid #7EA6B2;
}

li.list2 {
    background-color: #56CBF1;
    border:1px solid #7EA6B2;
	height:23px;
}

#user_actions { float: right; }

</style>


	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eAE/js/yahoo-dom-event.js' language='javascript'></script>
	<script src='../../eAE/js/connection-min.js' language='javascript'></script>
	<script src='../../eAE/js/element-min.js' language='javascript'></script>	
	<script src='../../eAE/js/dragdrop-min.js' language='javascript'></script>
	<script src='../../eAE/js/button-min.js' language='javascript'></script>	
	<script src='../../eAE/js/animation-min.js' language='javascript'></script>	
	<script src='../../eAE/js/event-min.js' language='javascript'></script>	
	<script src='../../eAE/js/yahoo-min.js' language='javascript'></script>	

	<SCRIPT LANGUAGE="JavaScript">
	var fieldOrder = "";
	(function() {
	var Dom = YAHOO.util.Dom;
	var Event = YAHOO.util.Event;
	var DDM = YAHOO.util.DragDropMgr;

	YAHOO.example.DDApp = {
    init: function() { 

        var rows=<%=recCnt%>,cols=1,i,j;
        for (i=1;i<cols+1;i=i+1) {
            new YAHOO.util.DDTarget("ul"+i);
        }

        for (i=1;i<cols+1;i=i+1) {
            for (j=1;j<rows+1;j=j+1) {
                new YAHOO.example.DDList("li" + i + "_" + j);
            }
        }
	 Event.on("saveOrd", "click", this.saveOrder);

    },

    saveOrder: function() { 
        var parseList = function(ul, title) { 
            var items = ul.getElementsByTagName("li");
            var out = title + "=";
			
            for (i=0;i<items.length;i=i+1) {
				
				//out += items[i].name+"`"+document.getElementById("chk_"+(i+1)).value+"@"+items[i].innerHTML+"~";
				out += items[i].name+"`"+items[i].innerHTML+"~";
            }
		    return out;
        };

        var ul1=Dom.get("ul1");
		
		fieldOrder = parseList(ul1, "fieldOrder")
		
		var handleSuccess = function(o){
		var status = "";
			if(o.responseText !== undefined){
				status = "Transaction id: " + o.tId;
				status += "HTTP status: " + o.status;
				status += "Status code message: " + o.statusText;
				status += "<li>HTTP headers: <ul>" + o.getAllResponseHeaders + "</ul></li>";
				status += "JSP response: " + o.responseText;
				status += "Argument object: " + o.argument;
			}
			window.returnValue = '0';
			window.close();
		}
		var handleFailure = function(o){
		var status = "";
			if(o.responseText !== undefined){
				status = "Transaction id: " + o.tId;
				status += "HTTP status: " + o.status;
				status += "Status code message: " + o.statusText;
				status += "<li>HTTP headers: <ul>" + o.getAllResponseHeaders + "</ul></li>";
				status += "JSP response: " + o.responseText;
				status += "Argument object: " + o.argument;
			}

			window.returnValue='-1';
			window.close();
		}

		var callback =
		{
		  success:handleSuccess,
		  failure: handleFailure,
		  argument: []
		};
		
		var request = YAHOO.util.Connect.asyncRequest('POST', "../../eMR/jsp/MRReportResultOrder.jsp", callback, fieldOrder);

    },

    switchStyles: function() {
        Dom.get("ul1").className = "draglist_alt";
        
    }
};

//////////////////////////////////////////////////////////////////////////////
// custom drag and drop implementation
//////////////////////////////////////////////////////////////////////////////

YAHOO.example.DDList = function(id, sGroup, config) {

    YAHOO.example.DDList.superclass.constructor.call(this, id, sGroup, config);

    this.logger = this.logger || YAHOO;
    var el = this.getDragEl();
    Dom.setStyle(el, "opacity", 0.67); // The proxy is slightly transparent

    this.goingUp = false;
    this.lastY = 0;
};

YAHOO.extend(YAHOO.example.DDList, YAHOO.util.DDProxy, {

    startDrag: function(x, y) { 
        this.logger.log(this.id + " startDrag");

        // make the proxy look like the source element
        var dragEl = this.getDragEl();
        var clickEl = this.getEl();
        Dom.setStyle(clickEl, "visibility", "hidden");

        dragEl.innerHTML = clickEl.innerHTML;

        Dom.setStyle(dragEl, "color", Dom.getStyle(clickEl, "color"));
        Dom.setStyle(dragEl, "backgroundColor", Dom.getStyle(clickEl, "backgroundColor"));
        Dom.setStyle(dragEl, "border", "2px solid gray");
    },

    endDrag: function(e) { 

        var srcEl = this.getEl();
        var proxy = this.getDragEl();

        // Show the proxy element and animate it to the src element's location
        Dom.setStyle(proxy, "visibility", "");
        var a = new YAHOO.util.Motion( 
            proxy, { 
                points: { 
                    to: Dom.getXY(srcEl)
                }
            }, 
            0.2, 
            YAHOO.util.Easing.easeOut 
        )
        var proxyid = proxy.id;
        var thisid = this.id;

        // Hide the proxy and show the source element when finished with the animation
        a.onComplete.subscribe(function() {
                Dom.setStyle(proxyid, "visibility", "hidden");
                Dom.setStyle(thisid, "visibility", "");
            });
        a.animate();
    },

    onDragDrop: function(e, id) { 
        // If there is one drop interaction, the li was dropped either on the list,
        // or it was dropped on the current location of the source element.
        if (DDM.interactionInfo.drop.length === 1) {

            // The position of the cursor at the time of the drop (YAHOO.util.Point)
            var pt = DDM.interactionInfo.point; 
            // The region occupied by the source element at the time of the drop
            var region = DDM.interactionInfo.sourceRegion; 

            // Check to see if we are over the source element's location.  We will
            // append to the bottom of the list once we are sure it was a drop in
            // the negative space (the area of the list without any list items)
            if (!region.intersect(pt)) {
                var destEl = Dom.get(id);
                var destDD = DDM.getDDById(id);
                destEl.appendChild(this.getEl());
                destDD.isEmpty = false;
                DDM.refreshCache();
            }

        }
    },

    onDrag: function(e) { 

        // Keep track of the direction of the drag for use during onDragOver
        var y = Event.getPageY(e);

        if (y < this.lastY) {
            this.goingUp = true;
        } else if (y > this.lastY) {
            this.goingUp = false;
        }

        this.lastY = y;
    },

    onDragOver: function(e, id) { 
    
        var srcEl = this.getEl();
        var destEl = Dom.get(id);
        // We are only concerned with list items, we ignore the dragover
        // notifications for the list.
        if (destEl.nodeName.toLowerCase() == "li") {
            var orig_p = srcEl.parentNode;
            var p = destEl.parentNode; 
            if (this.goingUp) {
                p.insertBefore(srcEl, destEl); // insert above
            } else {
                p.insertBefore(srcEl, destEl.nextSibling); // insert below
            }
            DDM.refreshCache();
        }
    }
});

var oButton = new YAHOO.widget.Button({
                                        id: "saveOrd", 
                                        type: "push", 
                                        label: "Save", 
                                        container: "saveOrderId"
                                    });

Event.onDOMReady(YAHOO.example.DDApp.init, YAHOO.example.DDApp, true);
})();





</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class="yui-skin-sam" onMouseDown="CodeArrest()">
<form name='MRResultOrderForm' id='MRResultOrderForm'>
<table border='0' cellpadding='0' cellspacing='2' width='100%'>
 <th colspan='2'>Field order</td>
<tr>
<td>
<div class="workareaSeq">
<ul id="ulSeq" class="draglistSeq">
<%
for(int i=1;i<=recCnt;i++)
{
	String j = String.format("%02d", i);
%>

	<li class="list2" id='SeqNo_<%=i%>'><%=j%></li>

<%
}
%>

	</ul>
<div>
</td>
<td>
<div class="workarea">
  <ul id="ul1" class="draglist">
<%  String display = "";
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

	 
	%>
	
   <li class="list1" id='li1_<%=m%>'  name="<%=name%>">
   <input type='checkbox' name='chk_<%=m%>' id='chk_<%=m%>' id='chk_<%=m%>' <%=dis_field%>  <%=name_chk_status%> value='<%=name_chk%>'><%=display%></li>
	<%}%>
  </ul>
</div>
</td>
</tr>
<tr>
<td colspan='2'><div id='saveOrderId'></div></td>
</tr>
</table>

</form>
</body>
</html>


