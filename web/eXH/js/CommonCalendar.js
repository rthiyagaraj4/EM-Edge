/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var localeName
if(localeName ==null)localeName="en";

document.write("<link rel='StyleSheet' href='../eCommon/html/calendar.css' type='text/css' ></link>");
document.write("<script type='text/javascript' src=\"../eCommon/js/calScript/"+localeName+"/calendar.js\"></script>");
document.write("<script type='text/javascript' src=\"../eCommon/js/common.js\"></script>");



 /*
  *  enableFlag variable is used to determine if the calendar in div tag is already in use,and if it is so then to restrict the user to 
  *  open another div until the furst div is closed.
  *  
  */

		var  enableFlag=false;

/*------------------------------------------------Drag Event Functions Starts Here------------------------------------------------------------------------------------*/
/*
 *     BrowserConfiguration function for the dragEvent action.
 */

		function Browser() {

		  var ua, s, i;

		  this.isIE    = false;
		  this.isNS    = false;
		  this.version = null;

		  ua = navigator.userAgent;

		  s = "MSIE";
		  if ((i = ua.indexOf(s)) >= 0) {
			this.isIE = true;
			this.version = parseFloat(ua.substr(i + s.length));
			return;
		  }

		  s = "Netscape6/";
		  if ((i = ua.indexOf(s)) >= 0) {
			this.isNS = true;
			this.version = parseFloat(ua.substr(i + s.length));
			return;
		  }

		  // Treat any other "Gecko" browser as NS 6.1.

		  s = "Gecko";
		  if ((i = ua.indexOf(s)) >= 0) {
			this.isNS = true;
			this.version = 6.1;
			return;
		  }
		}
		var browser = new Browser();

		// Global object to hold drag information.

		var dragObj = new Object();
		dragObj.zIndex = 0;


		function dragStart(event, id) {
		  var el;
		  
		  var x, y;

		  // If an element id was given, find it. Otherwise use the element being
		  // clicked on.

		  if(id ==null)	id="divID"

		  if (id)
			dragObj.elNode = document.getElementById(id);
		  else {
			if (browser.isIE)
			  dragObj.elNode = window.event.target;
			if (browser.isNS)
			  dragObj.elNode = event.target;

			// If this is a text node, use its parent element.

			if (dragObj.elNode.nodeType == 3)
			  dragObj.elNode = dragObj.elNode.parentNode;
		  }

		  // Get cursor position with respect to the page.
		  if (browser.isIE) {
			x = window.event.clientX + document.documentElement.scrollLeft
			  + document.body.scrollLeft;
			y = window.event.clientY + document.documentElement.scrollTop
			  + document.body.scrollTop;
		  }
		  if (browser.isNS) {
			x = event.clientX + window.scrollX;
			y = event.clientY + window.scrollY;
		  }

		  // Save starting positions of cursor and element.

		  dragObj.cursorStartX = x;
		  dragObj.cursorStartY = y;
		  dragObj.elStartLeft  = parseInt(dragObj.elNode.style.left, 10);
		  dragObj.elStartTop   = parseInt(dragObj.elNode.style.top,  10);

		  if (isNaN(dragObj.elStartLeft)) dragObj.elStartLeft = 0;
		  if (isNaN(dragObj.elStartTop))  dragObj.elStartTop  = 0;

		  // Update element's z-index.

		  dragObj.elNode.style.zIndex = ++dragObj.zIndex;

		  // Capture mousemove and mouseup events on the page.

		  if (browser.isIE) {
			document.attachEvent("onmousemove", dragGo);
			document.attachEvent("onmouseup",   dragStop);


			window.event.cancelBubble = true;
			window.event.returnValue = false;
		  }
		  if (browser.isNS) {
			document.addEventListener("mousemove", dragGo,   true);
			document.addEventListener("mouseup",   dragStop, true);
			event.preventDefault();
		  }
		}

		function dragGo(event) {
		  var x, y;
		  // Get cursor position with respect to the page.

		  if (browser.isIE) {
			x = window.event.clientX + document.documentElement.scrollLeft
			  + document.body.scrollLeft;
			y = window.event.clientY + document.documentElement.scrollTop
			  + document.body.scrollTop;
		  }
		  if (browser.isNS) {
			x = event.clientX + window.scrollX;
			y = event.clientY + window.scrollY;
		  }

		  // Move drag element by the same amount the cursor has moved.

		  dragObj.elNode.style.left = (dragObj.elStartLeft + x - dragObj.cursorStartX) + "px";
		  dragObj.elNode.style.top  = (dragObj.elStartTop  + y - dragObj.cursorStartY) + "px";

		  if (browser.isIE) {
			window.event.cancelBubble = true;
			window.event.returnValue = false;
		  }
		  if (browser.isNS)
			event.preventDefault();

		  hideShowCovered(dragObj.elNode)
		}

		function dragStop(event) {
					
		  // Stop capturing mousemove and mouseup events.

		  if (browser.isIE) {
			document.detachEvent("onmousemove", dragGo);
			document.detachEvent("onmouseup",   dragStop);
		  }
		  if (browser.isNS) {
			document.removeEventListener("mousemove", dragGo,   true);
			document.removeEventListener("mouseup",   dragStop, true);
		  }
		  hideShowCovered(dragObj.elNode)
		}
/*-----------------------------------------Drag Event Functions End Here--------------------------------------------------------------------------------------------*/


/*--------------------------------- Function callDHTMLcalendar() displays the calendar in a div tag.------------------------------------------------------------*/
 
		function callDHTMLCalendar(obj,x,y,time_format,diff_Yr)
		{
			   document.attachEvent('onmousedown',hideDiv);

		    	var div=null;
				if(document.getElementById("divID")==null)
				{
					div = document.createElement("div");
					div.setAttribute("id",'divID');
		            div.style.position = "absolute";  
					div.style.width = 50;  
					div.style.height = 30;
					div.style.posLeft=x;
					div.style.posTop=y;
					div.style.cursor="hand"
					div.attachEvent('onmousedown',function() {dragStart('divID')})
				}
				else
				{
					div=document.getElementById("divID")
					div.style.posLeft=x;
					div.style.posTop=y;
					div.style.visibility="visible"
				}
				var mytable = document.createElement("TABLE");
					mytable.setAttribute("id",'tab');
					mytable.style.border="1"
					mytable.style.cursor="none"
					mytable.style.paddingTop="0";
					mytable.style.paddingBottom="0";
					mytable.style.paddingRight="0";
					mytable.style.padding="0";
					mytable.style.height="100%"
					mytable.style.width="100%"
					mytable.cellSpacing=0
					mytable.cellSpacing=0
					mytable.style.cursor="default"

				var mytablebody = document.createElement("TBODY");
					 mytablebody.style.border="none"
					 mytablebody.style.cursor="default"

				var mytoprow=document.createElement("TR");
					mytoprow.style.border="none"
					mytoprow.setAttribute('id','tablerow');
					mytoprow.style.cursor="default"
					mytoprow.style.height=10;

				var mytd=document.createElement("TD");
					mytd.setAttribute('id','tabletd');
					mytd.innerHTML="Calendar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					mytd.className="COMMONTOOLBARFUNCTION"
					mytd.noWrap="true"
					mytd.align="left"
					mytd.vAlign="top"
					mytd.attachEvent('onmousedown',function() {dragStart('divID')})
				var mybutton=document.createElement("IMG");
					mybutton.src='../../eCommon/images/disabled.gif';
					mybutton.style.cursor="hand"
					mybutton.attachEvent('onmousedown',hideDiv );

				var mysecrow=document.createElement("TR");
			
				var mytext=document.createElement("TD");
						mytext.setAttribute('id','textid');
						mytext.style.border="none"
						mytext.style.cursor="none"
						mytext.vAlign="top"
						mytext.style.height="100%"
						mytext.style.width="100%"
						mytext.style.cursor="default"
						mytext.className="COMMONTOOLBARFUNCTION"
						mytext.innerHTML = generateCalendar('','','',obj,"isDiv","divID","",time_format,diff_Yr);

						mysecrow.appendChild(mytext);
						mytd.appendChild(mybutton);
						mytoprow.appendChild(mytd);
						mytablebody.appendChild(mytoprow);
						mytablebody.appendChild(mysecrow);
						mytable.appendChild(mytablebody);
//alert(generateCalendar('','','',obj,"isDiv","divID","",time_format,diff_Yr));
					div.appendChild(mytable); 
					document.getElementsByTagName("body")[0].appendChild(div);

					hideShowCovered(div)
		}		

/*-----------------------------------------callDHTMLCalendar() Functions End Here-------------------------------------------------------------------------------*/

/*----------------Function showCalendar() displays the calendar in Modal Dialog Format/Div Format based on the position occupied in the GUI---------*/


		async function showCalendar(id, date_format,time_format,modal_yn) 
		{
			/*
			if (parent.parent.f_query_add_mod){
				parent.parent.f_query_add_mod.document.forms[0].action="../../eCommon/html/blank.html";
				parent.parent.f_query_add_mod.document.forms[0].target="messageFrame";
			}
			*/
			
			if (document.forms[0]){
				originalFormAction = document.forms[0].action;
				originalFormTarget = document.forms[0].target;
				document.forms[0].action="../../eCommon/html/blank.html";
				document.forms[0].target="messageFrame";
			}
			
			
			 // Commented by Marimuthu on 24/10/2009 for incident IN015512
			 //var locn = window.location.href;
			 // End of Comment

			 //var el = eval("document.all."+id);
			
			 var el = eval(document.getElementById(id));
			 
			 var isModal="isDiv";
			 var timeSet="";
			if ( (date_format==undefined) || (date_format=='') || (date_format==null) || (date_format=='null'))
			{
					timeSet="dd/mm/yyyy";
			}
			else 
			{
					timeSet=date_format;
			}
			if ( (time_format!=undefined) && (time_format!='') && (time_format!=null) && (time_format!='null') )
			{

				timeSet = timeSet +' '+ time_format;
			}
/*			if(modal_yn=='modal')		
			{
					showInModal(el,timeSet)
					return false;
			}
*/           
			if ( ( ! document.getElementById("CACalanderFun") ) && (document.getElementById(id).type !='hidden') )
			{
				//eval("document.all."+id).blur();
				
				document.getElementById(id).blur();
			}
			
			if(enableFlag)
			{
					return false;
			}
			else
			{
				enableFlag=true;
			}
			
			 // Commented by Marimuthu on 24/10/2009 for incident IN015512
			//timeSet = timeSet+"&locn="+locn;
			// End of Comment
			
			await showInModal(el,timeSet);
			//return false;
			// Only if we can show the dhtml calendar
			//if(document.body.offsetWidth>250 && document.body.offsetHeight > 250)
/*			if(document.body.offsetWidth>320 && document.body.offsetHeight > 320)
			{
					var x =event.x
					var y =  event.y;

					bodwidth = document.body.offsetWidth
					bodheight = document.body.offsetHeight
// Changed from 70 to 150 and 250 to 320
					var layerHeight = 150
					var layerWidth = 320

					var x =event.x
					var y =  event.y;

					x = x + layerWidth
					y = y +  layerHeight

					if(x<bodwidth)
						x =event.x
					else
						x = x - (layerWidth*2)

					if(y<bodheight)
						 y =event.y
					else
						y = y - (layerHeight*2)

					y+=document.body.scrollTop
					x+=document.body.scrollLeft

					var cal = callDHTMLCalendar(id,x,y,timeSet);
					return false;
			}
			// Display in the Modal window
			 else
			 {
					showInModal(el,timeSet)
					
					return false;
				}
*/
		}
/*-----------------------------------------showCalendar() Function End Here--------------------------------------------------------------------------------------------*/

/*-----------------------------------------showInModal() Function displays the calendar in ModalDialog Format---------------------------------------------------*/
	async function showInModal(args,timeSet)
	{       
			var dialogHeight= "55vh" ;
			var dialogWidth	= "50vw" ;
			var status = "no";
			//var arguments = "";
			var features	=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			var  dateValue=await window.showModalDialog('../../eCommon/jsp/CommonStaticCalenderGlad.jsp?timeSet='+timeSet,args, features);
			
			
		/*	var serverTime="";
			if( (timeSet=="dd/mm/yyyy") || (timeSet=="dd/mm/y") || (timeSet=="mm/y") )
			{
					serverTime=""
			}
			else 
			{
				Dt = new Date();
				serverTime=Dt.getHours()+':'+Dt.getMinutes();
			}
			
			var formatedDate=null;*/
			var formatedDate = dateValue;


	/*		if(serverTime.length==0)
				formatedDate= dateValue;
			else
				formatedDate= dateValue+" "+serverTime;
			//var formatedDate= dateValue+" "+serverTime*/

			if(formatedDate==undefined)
			{
					 args.value= "";
			}
			else
			{
					args.value =formatedDate;
			}
			if ( ( ! document.getElementById("CACalanderFun") ) && (args.type !='hidden') )
			{
			args.focus();
			enableFlag=false;
			}
			
    }
/*-----------------------------------------showInModal() Function ends here---------------------------------------------------------------------------------------------*/

/*-----------------------------------------hideShowCovered Function starts here----------------------------------------------------------------------------------------*/
/*
 *  This function is used to make the underlying elements in the GUI to hide or become visible when the calendar is dragged across the screen.
 */
function hideShowCovered(element) {

    var tags = new Array("applet", "iframe", "select");
    var el = element;

    var p = getAbsolutePos(el);
    var EX1 = p.x;
    var EX2 = el.offsetWidth + EX1;
    var EY1 = p.y;
    var EY2 = el.offsetHeight + EY1;

    for (var k = tags.length; k > 0; ) {
        var ar = document.getElementsByTagName(tags[--k]);
        var cc = null;

        for (var i = ar.length; i > 0;) {
            cc = ar[--i];

            p = getAbsolutePos(cc);
            var CX1 = p.x;
            var CX2 = cc.offsetWidth + CX1;
            var CY1 = p.y;
            var CY2 = cc.offsetHeight + CY1;

            if ((CX1 > EX2) || (CX2 < EX1) || (CY1 > EY2) || (CY2 < EY1) || el.style.visibility=='hidden') {
                cc.style.visibility = "visible";
            } else {
                cc.style.visibility = "hidden";
            }
        }
    }
}
/*-------------------------------------------------------------------hideShowCovered Function ends here--------------------------------------------------------------*/
/*-------------------------------------------------------------------hideDiv Funtion starts here---------------------------------------------------------------------------*/
/*
 *  This function is used to hide the calendar which is there in the div format when the user happens to click  anywhere on the screen
 */
function hideDiv()
{
		enableFlag=false;
		var el=document.getElementById("divID")
		el.removeChild(document.getElementById("tab"));
		el.style.visibility="hidden"
		document.detachEvent('onmousedown',hideDiv)
		hideShowCovered(document.getElementById("divID"))
}

/*-------------------------------------------------------------------hideDiv Funtion ends here------------------------------------------------------------------------------*/

/*------------------------------------------------------------------- getAbsolutePos  Funtion starts here-------------------------------------------------------------------*/
/*
 *  This function is used to set the position of the div.
 */
function getAbsolutePos (el) 
{
		var r = { x: el.offsetLeft, y: el.offsetTop };
		if (el.offsetParent) 
		{
			var tmp = getAbsolutePos(el.offsetParent);
			r.x += tmp.x;
			r.y += tmp.y;
    }
    return r;
};

/*------------------------------------------------------------------- getAbsolutePos  Funtion ends  here-------------------------------------------------------------------*/

/*---------------------------------------------------------------------getTimeFormat function begins here----------------------------------------------------------------*/
 function getTime(format){
            var date = new Date();
            var hour = date.getHours();
            var min = date.getMinutes();

			hour < 10 ? hour = "0" + hour : hour = hour
            min < 10 ? min = "0" + min : min = min
            var sec = date.getSeconds();
            sec < 10 ? sec = "0" + sec : sec = sec
            if (format == 'hh:mm')
                {
                    return hour + ":" + min;
                }
                else if (format == 'hh:mm:ss'){
                    return hour + ":" + min + ":" + sec;
                }
    }

/*---------------------------------------------------------------------getTimeFormat function ends here------------------------------------------------------------------*/

// below functions added for MMS-QH-CRF-0145

function showCalendar_hj(id, date_format,time_format,modal_yn) {  
	 
			 // Commented by Marimuthu on 24/10/2009 for incident IN015512
			 //var locn = window.location.href;
			 // End of Comment
                         
			 var el = document.getElementById(id);
			 var isModal="isDiv";
			 var timeSet="";
			if ( (date_format==undefined) || (date_format=='') || (date_format==null) || (date_format=='null'))
			{
					timeSet="dd/mm/yyyy"
			}
			else 
			{
					timeSet=date_format
			}
			if ( (time_format!=undefined) && (time_format!='') && (time_format!=null) && (time_format!='null') )
			{

				timeSet = timeSet +' '+ time_format;
			}
/*			if(modal_yn=='modal')		
			{
					showInModal(el,timeSet)
					return false;
			}
*/
			if ( ( ! document.getElementById("CACalanderFun") ) && (document.getElementById(id).type !='hidden') )
			{
				document.getElementById(id).blur();
			}

			if(enableFlag)
			{
					return false
			}
			else
			{
				enableFlag=true;
			}
			
			 // Commented by Marimuthu on 24/10/2009 for incident IN015512
			//timeSet = timeSet+"&locn="+locn;
			// End of Comment

			showInModal_hj(el,timeSet);
			return false;
			// Only if we can show the dhtml calendar
			//if(document.body.offsetWidth>250 && document.body.offsetHeight > 250)
/*			if(document.body.offsetWidth>320 && document.body.offsetHeight > 320)
			{
					var x =event.x
					var y =  event.y;

					bodwidth = document.body.offsetWidth
					bodheight = document.body.offsetHeight
// Changed from 70 to 150 and 250 to 320
					var layerHeight = 150
					var layerWidth = 320

					var x =event.x
					var y =  event.y;

					x = x + layerWidth
					y = y +  layerHeight

					if(x<bodwidth)
						x =event.x
					else
						x = x - (layerWidth*2)

					if(y<bodheight)
						 y =event.y
					else
						y = y - (layerHeight*2)

					y+=document.body.scrollTop
					x+=document.body.scrollLeft

					var cal = callDHTMLCalendar(id,x,y,timeSet);
					return false;
			}
			// Display in the Modal window
			 else
			 {
					showInModal(el,timeSet)
					
					return false;
				}
*/
		}


	async function showInModal_hj(args,timeSet)
	{
			var dialogHeight= "30vh" ;
			var dialogWidth	= "15vw" ;
			var status = "no";
			//var args = "";
			var features	=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			var  dateValue=await window.showModalDialog('../../eCommon/jsp/CommonStaticCalenderGlad_hj.jsp?timeSet='+timeSet,args, features);
			
		/*	var serverTime="";
			if( (timeSet=="dd/mm/yyyy") || (timeSet=="dd/mm/y") || (timeSet=="mm/y") )
			{
					serverTime=""
			}
			else 
			{
				Dt = new Date();
				serverTime=Dt.getHours()+':'+Dt.getMinutes();
			}
			
			var formatedDate=null;*/
			var formatedDate = dateValue;


	/*		if(serverTime.length==0)
				formatedDate= dateValue;
			else
				formatedDate= dateValue+" "+serverTime;
			//var formatedDate= dateValue+" "+serverTime*/

			if(formatedDate==undefined)
			{
					 args.value= "";
			}
			else
			{
					args.value =formatedDate;
					//alert();
					convertToGD(formatedDate)
			}
			if ( ( ! document.getElementById("CACalanderFun") ) && (args.type !='hidden') )
			args.focus();
			enableFlag=false;
    }
	
	/*function calc_hij(obj){ 

	if(document.getElementById("hij_appl_YN").value=='Y'){
		if(obj.value !='') {
			if(document.getElementById("invalid_dob").value=='N'){
				var hijDay =convertToHij(obj.value);

				document.getElementById("date_of_birth_hj").value=hijDay;
			}else{
				document.getElementById("date_of_birth_hj").value='';
			}
		}else{
			document.getElementById("date_of_birth_hj").value='';
		}
	}

} */

function calc_hij(obj){ 

	if(document.getElementById("hij_appl_YN").value=='Y'){
		if(obj.value !='') {
			if(document.getElementById("invalid_dob").value=='N'){ 
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest()	

			xmlStr ="<root><SEARCH mode='1' date_value=\""+obj.value+"\"/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")					
			xmlHttp.open("POST","../../eCommon/jsp/ConvertHDT.jsp",false)

			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)

			eval(responseText)
			
			
				//var hijDay =convertToHij(obj.value); 
              //document.getElementById("date_of_birth_hj").value=hijDay;
			}else{
				document.getElementById("date_of_birth_hj").value='';
			}
		}else{
			document.getElementById("date_of_birth_hj").value='';
		}
	}

}

function convertToGD(hijDate){

	var hijriDate;

	if(hijDate){
		
		hijriDate=document.getElementById("date_of_birth_hj").value;
	}else{
		hijriDate=hijDate;
	}

	
	if(hijriDate !='') {

		if(validDate(hijriDate,"DMY",localeName)){
			
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest()	
			if(document.getElementById("birth_time"))
            var birth_time = parent.frames[2].document.forms[0].birth_time.value;
			xmlStr ="<root><SEARCH mode='1' date_value=\""+hijriDate+"\"";
			xmlStr+=" birth_time=\""+birth_time+"\" ";
			xmlStr +=" /></root>";
			
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")					
			xmlHttp.open("POST","../../eCommon/jsp/ConvertDT.jsp",false)

			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
            if(document.getElementById("birth_date"))
			date_Validate(document.getElementById("birth_date").value);

			//if(document.getElementById("b_age").value=='' && document.getElementById("b_months").value=='' &&  document.getElementById("b_days").value=='' &&  document.getElementById("b_hours").value==''){
			if(document.getElementById("CalledFromFunction").value!="REGISTER_NEWBORN"){ //this condtion  added for MMS-QH-CRF-0145.1 [IN:047497]
			    gotoNext(document.getElementById("date_of_birth"));
				disableEnableYMDH(document.getElementById("date_of_birth"));
			}
			
			//}
		}else{
			alert("getmessgae"+getMessage("INVALID_DATE_FMT", "SM"));
			
			document.getElementById("date_of_birth_hj").select();
		}
		
	}
}

// end for MMS-QH-CRF-0145

