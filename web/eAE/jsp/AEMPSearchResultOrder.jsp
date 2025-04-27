<!DOCTYPE html>
<!-- 
Created by    : Vinod Babu M V -  11/24/2009
Module/Function : To re order the Current Emergency Result Fields
-->
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
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
    width: 200px; 
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
	height:19px;
}

#user_actions { float: right; }

</style>

	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
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

        var rows=17,cols=1,i,j;
		/*Below line added for this CRF ML-MMOH-CRF-0637*/
		//var reattendance="";	
		if(document.AEMPSearchResultOrderForm.isForAdmission.value=="true")
		{
			 rows=18;
		}
		if(document.AEMPSearchResultOrderForm.re_attendance.value=="true" && document.AEMPSearchResultOrderForm.isPendingForAdmissionAppl.value=="true"){//Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658
		         rows=20;
		}		
		//End ML-MMOH-CRF-0637
		
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
                out += items[i].name+"`"+items[i].innerHTML+"~";
            }
		    return out;
        };

        var ul1=Dom.get("ul1");
		fieldOrder = parseList(ul1, "fieldOrder")
//		alert(fieldOrder);
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
//			alert('Failure status : ' +status);
			window.returnValue='-1';
			window.close();
		}

		var callback =
		{
		  success:handleSuccess,
		  failure: handleFailure,
		  argument: []
		};

        
		var request = YAHOO.util.Connect.asyncRequest('POST', "../../eAE/jsp/AEMPCurEmerOrder.jsp", callback, fieldOrder);

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
	
	/*Added by Thamizh selvi on 10th May 2018 against ML-MMOH-CRF-0658 Start*/
	window.onload = function(){
		if(document.AEMPSearchResultOrderForm.newRecsCnt && document.AEMPSearchResultOrderForm.recCnt && document.AEMPSearchResultOrderForm.DFCnt){
			var newRecsCnt = document.AEMPSearchResultOrderForm.newRecsCnt.value;
			var recCnt = document.AEMPSearchResultOrderForm.recCnt.value;
			var DFCnt = document.AEMPSearchResultOrderForm.DFCnt.value;
			
			if(newRecsCnt != 0){
				insertNewOrderColumn(recCnt,DFCnt);		
			}
		}
	}
	
	function insertNewOrderColumn(recCnt,DFCnt){
		$.ajax({  
			url:'../../servlet/eAE.AEManagePatientServlet',  
			type:'post',  
			data:{'operation_mode':'InsertNewOrderColumn','DFCnt':DFCnt,'recCnt':recCnt},
			async: false, 
			success: function(data) {
				
			}
		});
	}/*End*/
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
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
%>
</head>
<body class="yui-skin-sam" onMouseDown="CodeArrest()">
<form name='AEMPSearchResultOrderForm' id='AEMPSearchResultOrderForm'>
<table border='0' cellpadding='0' cellspacing='2' width='100%'>
 <th colspan='2'>Field order</td>
<tr>
<td>
<div class="workareaSeq">
<ul id="ulSeq" class="draglistSeq">
	<li class="list2" id='SeqNo_1'>01</li>
	<li class="list2" id='SeqNo_2'>02</li>
	<li class="list2" id='SeqNo_3'>03</li>
	<li class="list2" id='SeqNo_4'>04</li>
	<li class="list2" id='SeqNo_5'>05</li>
	<li class="list2" id='SeqNo_6'>06</li>
	<li class="list2" id='SeqNo_7'>07</li>
	<li class="list2" id='SeqNo_8'>08</li>
	<li class="list2" id='SeqNo_9'>09</li>
	<li class="list2" id='SeqNo_10'>10</li>
	<li class="list2" id='SeqNo_11'>11</li>
	<li class="list2" id='SeqNo_12'>12</li>
	<li class="list2" id='SeqNo_13'>13</li>
	<li class="list2" id='SeqNo_14'>14</li>
	<li class="list2" id='SeqNo_15'>15</li>
	<li class="list2" id='SeqNo_16'>16</li>
	<li class="list2" id='SeqNo_17'>17</li>
	<%if(isForAdmission){%>
	<li class="list2" id='SeqNo_18'>18</li> 
	<%}%>
	<%if(reattendance){%>
	<li class="list2" id='SeqNo_19'>19</li> 
	<%}%>
	<%if(isPendingForAdmissionAppl){%>
	<li class="list2" id='SeqNo_20'>20</li> 
	<%}%>
	</ul>
<div>
</td>
<td>
<div class="workarea">
  <ul id="ul1" class="draglist">
<%  String display = "";
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
	 if (m==1) {  %>
    <li class="list1" id='li1_1'  name="<%=name%>"><%=display%></li>
    <% } else	if (m==2) {  %>
    <li class="list1" id='li1_2'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==3) {  %>
    <li class="list1" id='li1_3'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==4) {  %>
    <li class="list1" id='li1_4'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==5) {  %>
    <li class="list1" id='li1_5'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==6) {  %>
    <li class="list1" id='li1_6'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==7) {  %>
    <li class="list1" id='li1_7'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==8) {  %>
    <li class="list1" id='li1_8'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==9) {  %>
    <li class="list1" id='li1_9'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==10) {  %>
    <li class="list1" id='li1_10'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==11) {  %>
    <li class="list1" id='li1_11'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==12) {  %>
    <li class="list1" id='li1_12'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==13) {  %>
    <li class="list1" id='li1_13'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==14) {  %>
    <li class="list1" id='li1_14'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==15) {  %>
    <li class="list1" id='li1_15'  name="<%=name%>"><%=display%></li>
	<% } else	if (m==16) {  %>
    <li class="list1" id='li1_16'  name="<%=name%>"><%=display%></li> 
	<% } else	if (m==17) {  %>
    <li class="list1" id='li1_17'  name="<%=name%>"><%=display%></li>
	<%}else     if(isForAdmission && m==18) {  %>
    <li class="list1" id='li1_18'  name="<%=name%>"><%=display%></li> 
	<%} else	if (reattendance && m==19) {  %>
    <li class="list1" id='li1_19'  name="<%=name%>"><%=display%></li> 
	<%}	else if(isPendingForAdmissionAppl && m==20) {  %>
    <li class="list1" id='li1_20'  name="<%=name%>"><%=display%></li> 
	<%}	}%>
  </ul>
</div>
</td>
</tr>
<tr>
<td colspan='2'><div id='saveOrderId' style="padding-top:115px;"></div></td>
</tr>
</table>
<input type="hidden" name="isForAdmission" id="isForAdmission" value="<%=isForAdmission%>">
<input type="hidden" name="re_attendance" id="re_attendance" value="<%=reattendance%>"> <!--this line added for this CRF ML-MMOH-CRF-0637 -->
<!--Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start-->
<input type="hidden" name="isPendingForAdmissionAppl" id="isPendingForAdmissionAppl" value="<%=isPendingForAdmissionAppl%>">
<input type="hidden" name="newRecsCnt" id="newRecsCnt" value="<%=newRecsCnt%>"> 
<input type="hidden" name="recCnt" id="recCnt" value="<%=recCnt%>"> 
<input type="hidden" name="DFCnt" id="DFCnt" value="<%=DFCnt%>"> 
<!--End-->
</form>
</body>
</html>


