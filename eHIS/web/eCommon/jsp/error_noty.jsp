<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*"%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<head>
    <Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
    <Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<!-- Added by Sethu for Practitioner Alert Messages -->
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	
	<link rel="stylesheet" type="text/css" href="../../eCommon/noty/css/jquery.noty.css"/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/noty/css/noty_theme_default.css"/>
<%
    String button_events = "onselectstart=\"ButtonOnSelectStart()\" ondragstart=\"ButtonOnDragStart()\" onmousedown=\"ButtonOnMouseDown(this)\"  onmouseup=\"ButtonOnMouseUp(this)\" onmouseout=\"ButtonOnMouseOut(this)\" onmouseover=\"ButtonOnMouseOver(this)\" onclick=\"ButtonOnClick(this)\" ondblclick=\"ButtonOnDblClick(this)\" ";
%>
<style type="text/css">  
	a:link { color:"red" }
	#myoutercontainer { position:relative }
	#myinnercontainer { position:absolute; top:15%;}
</style> 

<script language="JavaScript">

var t;
var timer_is_on=false;
var practArryMessage = new Array();
var msgCount = 0;
var appl_user_id = "";

function timedCount()
{
	t=setTimeout("timedCount()",5000);
	notifyPract();	
}

function doTimer()
{
	document.getElementById("msgNumber").innerHTML="";
	/*
	if (!timer_is_on)
	{
		timer_is_on=1;
		timedCount();
	}
	*/
	
}

function notyMessageSound(){	
	var soundfile = "../../eCommon/images/notify.wav";
	document.getElementById("dummy").innerHTML= "<embed src=\""+soundfile+"\" hidden=\"true\" autostart=\"true\" loop=\"false\" />";
}

function notyCloseMessage(message_id){	
	
	var functionID = "EVENT_MSG_SHOWN_YN";	
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/PractitionerAlertQuery.jsp?function_id="+functionID+"&messageId="+message_id, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);			
	
}
function showUserAlertDetails(applUserId){
	var retVal			=	"";
	var dialogTop		=	"160" ;
	var dialogHeight	=	"20" ;
	var dialogWidth		=	"40" ;
	var status			=	"no";
	var arguments		=	"" ;
	var sql				=	"";
	var search_code		=	"";
	var search_desc		=	"";
	var title			=	"";
	var param			=	"";
	var action_url		=   "";
	var features		=	"";

	action_url		=	'../../eCA/jsp/PractitionerAlertDetails.jsp';
	features		=	"dialogHeight:" + dialogHeight +"; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url		+=	"?userId="+applUserId;
	
	retVal				=	window.showModalDialog(action_url,arguments,features);	
}
function notifyPract(){
	
	var alertflag = "";
	var event_indicator = "";
	var event_title = "";	
	var event_desc = "";
	var patient_id = "";
	var notyType = "";
	var noty_id = "";
	var message_id = "";
	var layout = "";

	var functionID = "query";

	practArryMessage = new Array();

	msgCount = 0;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	document.getElementById("msgNumber").innerHTML="";
	
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/PractitionerAlertQuery.jsp?function_id="+functionID+"&messageId="+message_id, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);		

	if (msgCount == "0")
	{		
		document.getElementById('imgTable').style.visibility="hidden";
	}
	else
	{		
		//document.getElementById('imgTable').style.visibility="visible";
		document.getElementById('imgTable').style.visibility="visible";
		//document.getElementById("msgNumber").innerHTML=msgCount;	
		//document.getElementById('msgNumber').innerHTML=msgCount;	
		document.getElementById('msgNumber').innerHTML="<a href='javascript:showUserAlertDetails(\""+escape(appl_user_id)+"\");'>"+msgCount+"</a>";
	}
	
	
	

	if((practArryMessage.length) == 0)
	{
		event_indicator = "";
		event_title = "";	
		event_desc = "";
		patient_id = "";
		notyType = "";
	}
	else
	{	
		
		for(var j=0;j<practArryMessage.length;j++)
		{
			var pract_dtls = practArryMessage[j].split("~");
			event_indicator = pract_dtls[0];
			event_title = pract_dtls[1];
			event_desc = pract_dtls[2];
			patient_id = pract_dtls[3];	
			message_id =  pract_dtls[4];

			if (event_indicator=="W")
				notyType= "alert";
			if (event_indicator=="E")
				notyType= "error";
			if (event_indicator=="I")
				notyType= "success";

			if (event_title == ""){
				event_title = "EMPTY TITLE";
			}

			if (event_indicator=="W")
				layout = "topCenter";
			if (event_indicator=="E")
				layout = "topCenter";
			if (event_indicator=="I")
				layout = "topCenter";

				
			noty_id = noty({"text":event_title, "layout":layout,"type":notyType,"animateOpen":{"height":"toggle"},"animateClose":{"height":"toggle"},"speed":500,"timeout":5000,"closeButton":false,"closeOnSelfClick":true,"closeOnSelfOver":false,"modal":false,"onShow":notyMessageSound(), "onClose":notyCloseMessage(message_id)});			
		}
		
	}
	
	
	
}
</script>

</head>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'  onload="doTimer()">
<p align="left">
<span id="dummy" style="display:inline"></span>
<div id="myoutercontainer">
	<div id="myinnercontainer">
		<table id="imgTable" border="0" cellpadding="0" cellspacing="0" width="24" height="24" background="../../eCommon/images/Info.png"  align="right">
			<tr align="center">
				<td> <font size="+1" color="red" align="center"><span id="msgNumber" style="display:inline"></span></font></td>
			</tr>
		</table>
	</div>
</div>
<!--
<img name="image1" id="image1" src="../../eCommon/images/becreate.gif" width="30" height="16" onClick="notifyPract()" title="Notification" align="right">
-->
<%                

    String error=request.getParameter( "err_num" );
    //String home_required_yn=request.getParameter("home_required_yn");
	
    if ( error != null ) {
        String queryString = (String) session.getValue( "queryString" ) ;
        if ( queryString == null ) queryString = "" ;
		
        if ( error == null ) error = "" ;


%>
	<script language='JavaScript'>
	if(parent.commontoolbarFrame!=null){
		var qry_stg="<%=queryString%>";
		var error="<%=error%>";
		var qry_string1= qry_stg.lastIndexOf("&expand");
		var finalString;
		var expand;
		var url;
		var final_name=getLabel("Common.menu.label","Common");
		if(parent.commontoolbarFrame.document.forms[0])
		{
			if(parent.commontoolbarFrame.document.forms[0].home)
			{
				if(parent.commontoolbarFrame.document.forms[0].home.value !=null )
				{
					if(parent.commontoolbarFrame.document.forms[0].home.value ==final_name )
					{
						expand="0";
					}
					else
					{
						expand="1";
					}
				}
			}
		}
		else
		{
			expand="0";
		}
		if(qry_string1 !=-1)
		{
			finalString=qry_stg.substring(0,qry_string1);
			url="commonToolbar.jsp?qry_stg="+finalString+"&expand="+expand;
		}
		else
		{
			url="commonToolbar.jsp?qry_stg="+qry_stg+"&expand="+expand;
		}
		if(error=="R")
		{	
			parent.commontoolbarFrame.location.href=url;
			parent.reset();
		}
		else
		{
			parent.commontoolbarFrame.location.href=url;
		}	
	}
	</script>
<%
			
////changes ends.
		
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		
        if ( error_value.equals( "1" ) )
		{
            out.println( "<script language='JavaScript'>parent.onSuccess();"+
            "document.writeln(\""+error+"\")" +
            "</script>" ) ;
		}else if(error.equals("R"))
		{
		}else
		{
                out.println( error ) ;
		}
            
/*
            if(error.indexOf("APP-SM0001") !=-1 || error.indexOf("APP-SM0002") !=-1 ||  error.indexOf("APP-SM0003") !=-1) 
                out.println("<script>alert('"+error.substring(0,error.length()-4)+"')</script>");
*/

            
    }

%>
</p>

</BODY>

