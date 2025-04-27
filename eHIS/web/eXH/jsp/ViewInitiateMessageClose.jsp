<!DOCTYPE html>
<HTML>

<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD> 
<% 													    
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle	="IeStyle.css";
     
				  

 String applicationID = XHDBAdapter.checkNull(request.getParameter("applicationID"));
String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
String msgID = XHDBAdapter.checkNull(request.getParameter("msgID"));
String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));					   
String protocolMode = XHDBAdapter.checkNull(request.getParameter("protocolMode")); 
String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));					 
String eventType = request.getParameter("even_type");
String accessionNumber= XHDBAdapter.checkNull(request.getParameter("accessionNumber")); 
String msgDate= XHDBAdapter.checkNull(request.getParameter("msgDate")); 
String pat_id= XHDBAdapter.checkNull(request.getParameter("pat_id"));
String episode_type= XHDBAdapter.checkNull(request.getParameter("episode_type"));
String episode_id= XHDBAdapter.checkNull(request.getParameter("episode_id"));
String visit_id= XHDBAdapter.checkNull(request.getParameter("visit_id"));
//String rebuildop= XHDBAdapter.checkNull(request.getParameter("RebuildOP")); 
String replayop= XHDBAdapter.checkNull(request.getParameter("ReplayOP")); 
String facilityName=XHDBAdapter.checkNull(request.getParameter("facilityName"));
String applicationName=XHDBAdapter.checkNull(request.getParameter("applicationName"));
 String whereClause=XHDBAdapter.checkNull(request.getParameter("whereClause")); 
 String posi=XHDBAdapter.checkNull(request.getParameter("posi"));
//String reloadop=XHDBAdapter.checkNull(request.getParameter("ReloadOP"));

System.out.println("protocolMode 15 ViewQueryMessageViewerClose.jsp:"+protocolMode);
%> 

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/ViewEventsOutbound.js" ></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onUnload='pageunload();' >
<form name="application_setup_base_form" id="application_setup_base_form"  method="POST"   action=''>
<table width="100%">
<tr> 
<input type='hidden' name='applicationName' id='applicationName' id='applicationName' value='<%=applicationName%>' >
<input type='hidden' name='facilityName' id='facilityName' id='facilityName' value='<%=facilityName%>' >
<input type='hidden' name='applicationID' id='applicationID' id='applicationID' value='<%=applicationID%>' >
<input type='hidden' name='facilityID' id='facilityID' id='facilityID' value='<%=facilityID%>'>
<input type='hidden' name='msgID' id='msgID' id='msgID' value='<%=msgID%>'>
<input type='hidden' name='srlNo' id='srlNo' id='srlNo' value='<%=srlNo %>'>
<input type='hidden' name='sub_module' id='sub_module' id='sub_module' value='<%=sub_module %>'>
<input type='hidden' name='protocolMode' id='protocolMode' id='protocolMode' value='<%=protocolMode %>'>
<input type='hidden' name='protocol_link_id' id='protocol_link_id' id='protocol_link_id' value='<%=protocol_link_id %>'>
<input type='hidden' name='purge_status' id='purge_status' id='purge_status' value='<%=purge_status %>'>
<input type='hidden' name='eventType' id='eventType' id='eventType' value='<%=eventType %>'>
<input type='hidden' name='accessionNumber' id='accessionNumber' id='accessionNumber' value='<%=accessionNumber%>'>
<input type='hidden' name='msgDate' id='msgDate' id='msgDate' value='<%=msgDate %>'>
<input type='hidden' name='pat_id' id='pat_id' id='pat_id' value='<%=pat_id %>'>
<input type='hidden' name='episode_type' id='episode_type' id='episode_type' value='<%=episode_type %>'>
<input type='hidden' name='visit_id' id='visit_id' id='visit_id' value='<%=visit_id %>'>
<input type='hidden' name='episode_id' id='episode_id' id='episode_id' value='<%=episode_id %>'> 
<input type='hidden' name='protocolMode' id='protocolMode' id='protocolMode' value='<%=protocolMode %>'>
<input type='hidden'  name='buttonInvoked' id='buttonInvoked' id='buttonInvoked'>
<input type="hidden" name="position" id="position" value='<%=posi%>' /> 
<input type='hidden'  name='wherecaluse' id='wherecaluse' id='wherecaluse' value='<%=whereClause%>'>

<td class=white align='right'><%if(protocolMode.equals("O"))
{%>
<input  type='button' class='button' value='<fmt:message key="eXH.Replay.Label" bundle="${xh_labels}"/>' onClick="processMSG('replay')" <%=replayop.equals("true")?"":"disabled"%>  >
<%} 
%><input  type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='windowclose()'></td></tr>  	
 
</table>
<script> 
async function unloadpage()
{
	var buttonInvoked=this.document.getElementById("buttonInvoked").value;
		var posi=parseInt(this.document.getElementById("position").value);

	/*var url="../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?applicationID="+this.document.getElementById("applicationID").value+
				"&facilityID="+this.document.getElementById("facilityID").value+
				"&msgID="+this.document.getElementById("msgID").value+
				"&facilityName="+this.document.getElementById("facilityName").value+
				"&applicationName="+this.document.getElementById("applicationName").value+
				"&protocolMode="+this.document.getElementById("protocolMode").value+
				"&sub_module="+this.document.getElementById("sub_module").value+				"&srlNo=&protocol_link_id="+this.document.getElementById("protocol_link_id").value+"&purge_status="+this.document.getElementById("purge_status").value+"&even_type="+this.document.getElementById("eventType").value+"&posi="+(posi)+"&protocolMode="+this.document.getElementById("protocolMode").value+"&action_type=&wherecaluse="+document.getElementById("whereClause").value; 
		 
 

var arguments  =new Array();
	var dialogHeight = "250";
	var dialogWidth  = "250";
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;help:no" ;
	
	await window.showModalDialog(url,arguments,features); */
		//parent.frames[1].document.location.href='../../eXH/jsp/ViewEventExceptionsHeaderMain.jsp?'+url;
		//parent.parent.frames[0].document.location.href='../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?'+url;
}


function pageunload()
{

	/*	this.document.forms[0].action='../eXH/jsp/ViewEventsInteractiveDtlTest1.jsp'; 	
		this.document.forms[0].target='f_query_add_mod';
		this.document.forms[0].submit();*/
	// parent..
}

 function windowclose()
{

  
parent.window.close(); 
}

function processMSG(buttonInvoked)
{
				var url='&accessionNumber='+this.document.getElementById("accessionNumber").value+
				'&applicationId='+this.document.getElementById("applicationID").value+
				'&facilityId='+this.document.getElementById("facilityID").value+
				'&messageId='+this.document.getElementById("msgID").value+
				'&eventType='+this.document.getElementById("eventType").value+
				'&purge_status='+this.document.getElementById("purge_status").value+
				'&sub_module='+this.document.getElementById("sub_module").value+
				'&protocol_link_id='+this.document.getElementById("protocol_link_id").value+'&protocolMode='+this.document.getElementById("protocolMode").value+
				'&mode=Q'+
				'&msgDate='+this.document.getElementById("msgDate").value+ 
				'&pat_id='+this.document.getElementById("pat_id").value+
				'&episode_id='+this.document.getElementById("episode_id").value+
			 	'&episode_type='+this.document.getElementById("episode_type").value+'&srlNo='+this.document.forms[0].srlNo.value+	'&visit_id='+this.document.getElementById("visit_id").value+'&buttonInvoked='+buttonInvoked+'&functionType=Review';
         
//this.document.getElementById("buttonInvoked").value=buttonInvoked;
/* var url='&accessionNumber='+this.document.getElementById("accessionNumber").value+
				'&applicationId='+this.document.getElementById("applicationID").value+
				'&facilityId='+this.document.getElementById("facilityID").value+
				'&messageId='+this.document.getElementById("msgID").value+
				'&eventType='+this.document.getElementById("eventType").value+
				'&purge_status='+this.document.getElementById("purge_status").value+
				'&sub_module='+this.document.getElementById("sub_module").value+
				'&protocol_link_id='+this.document.getElementById("protocol_link_id").value+'&protocolMode='+this.document.getElementById("protocolMode").value+
				'&mode=Q'+
				'&msgDate='+this.document.getElementById("msgDate").value+ 
				'&pat_id='+this.document.getElementById("pat_id").value+
				'&episode_id='+this.document.getElementById("episode_id").value+
				'&episode_type='+this.document.getElementById("episode_type").value+
				'&visit_id='+this.document.getElementById("visit_id").value+'&buttonInvoked='+buttonInvoked+'&commMode=Review';*/
 				//alert(parent.parent.frames[0].name); 
	this.document.forms[0].action='../../servlet/eXH.XHViewEventsOutboundServlet?'+url;
	this.document.forms[0].target='f_query_reviw_mod';   
	this.document.forms[0].submit();  
//parent.window.close();
//unloadpage();
} 
function process(buttonInvoked) 
{

	var url='&accessionNumber='+this.document.getElementById("accessionNumber").value+
				'&applicationId='+this.document.getElementById("applicationID").value+
				'&facilityId='+this.document.getElementById("facilityID").value+
				'&messageId='+this.document.getElementById("msgID").value+
				'&eventType='+this.document.getElementById("eventType").value+
				'&purge_status='+this.document.getElementById("purge_status").value+
				'&sub_module='+this.document.getElementById("sub_module").value+
				'&protocol_link_id='+this.document.getElementById("protocol_link_id").value+'&protocolMode='+this.document.getElementById("protocolMode").value+
				'&mode=Q'+
				'&msgDate='+this.document.getElementById("msgDate").value+ 
				'&pat_id='+this.document.getElementById("pat_id").value+
				'&episode_id='+this.document.getElementById("episode_id").value+
				'&episode_type='+this.document.getElementById("episode_type").value+'&srlNo='+this.document.forms[0].srlNo.value+	'&visit_id='+this.document.getElementById("visit_id").value+'&buttonInvoked='+buttonInvoked+'&commMode=Review';
	this.document.forms[0].action='../../servlet/eXH.XHViewEventsOutboundServlet?'+url;
	this.document.forms[0].target='f_query_reviw_mod';   
	this.document.forms[0].submit();  
	
	
	/*var url='&accessionNumber='+this.document.forms[0].accessionNumber.value+
				'&applicationId='+this.document.forms[0].applicationID.value+
				'&facilityId='+this.document.forms[0].facilityID.value+
				'&messageId='+this.document.forms[0].msgID.value+
				'&eventType='+this.document.forms[0].eventType.value+
				'&purge_status='+this.document.forms[0].purge_status.value+
				'&sub_module='+this.document.forms[0].sub_module.value+
				'&protocol_link_id='+this.document.forms[0].protocol_link_id.value+
				'&mode=Q'+
				'&srlNo='+this.document.forms[0].srlNo.value+
				'&buttonInvoked='+buttonInvoked+'&commMode=Review';*/

/*	this.document.forms[0].action='../../servlet/eXH.XHViewEventsOutboundServlet?'+url;
	this.document.forms[0].target='f_query_reviw_mod'; 
	this.document.forms[0].submit();  */
}
</script>
</form> 
</body>
</html>
   





