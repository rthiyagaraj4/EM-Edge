<!DOCTYPE html>
<HTML>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD> 
<%  
String sStyle =   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
sStyle="IeStyle.css";
//String applicationID = XHDBAdapter.checkNull(request.getParameter("applicationID"));
//String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
///String msgID = XHDBAdapter.checkNull(request.getParameter("msgID"));
//String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module")); 
String protocolMode = XHDBAdapter.checkNull(request.getParameter("protocolMode")); 
//String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
//String eventType = request.getParameter("even_type");															  
//String applicationName = XHDBAdapter.checkNull(request.getParameter("applicationName"));
//String facilityName = XHDBAdapter.checkNull(request.getParameter("facilityName"));
String whereClause=XHDBAdapter.checkNull(request.getParameter("whereClause")); 
//System.out.println("whereClause ViewEventNextPreviousPage.jsp :"+whereClause);
																													  
String pagechange=XHDBAdapter.checkNull(request.getParameter("pagechange"));
String action_type=XHDBAdapter.checkNull(request.getParameter("action_type"));

HashMap resultsQry=null;  
  //HashMap resultsQry1=null;
  ArrayList arrRow = null;
  String tableNameSuffix=""; 
  Connection conn=null;
String strPrevious ="";
String strNext="";
 ArrayList arrCol = null; 
  try
{ 
 


	conn = ConnectionManager.getConnection(request);
				if(purge_status != null && !purge_status.equals(""))
		{
			tableNameSuffix = sub_module+"_"+purge_status+"_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
		}
		else
		{
			tableNameSuffix = sub_module+"_EVENT_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
		} 
		String posi=XHDBAdapter.checkNull(request.getParameter("posi"));
		
 request.setAttribute("tableName",tableNameSuffix); 
 
  request.setAttribute("qry_id","VIEW_GENERAL_EVENTS");   
 request.setAttribute("whereClause",whereClause);														   
 request.setAttribute("maxRec","1"); 
  XHViewQueryControllerElementBean	xhBean =
  XHViewQueryControllerElementBean.getBean(XHViewQueryControllerElementBean.strBeanName,request,session);
  xhBean.action(request,conn);
	
 resultsQry  = xhBean.getPositionRecord(posi); 
  arrRow = (ArrayList)resultsQry.get("qry_result"); 

	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
if (boolPrevious == true)
  {
	strPrevious = " ";
  }  
  else
  {
	strPrevious = "disabled";
  }
  if (boolNext== true)
  {
	strNext  = " ";
  }
  else
  {
	strNext  = "disabled";
  }
	}
	catch(Exception e)
	{
		System.out.println("Exception "+e);
	}
	finally
	{
		if(conn != null) ConnectionManager.returnConnection(conn);
	}

%>
<input type="hidden" name="pagechange" id="pagechange" id="pagechange" value='<%=pagechange%>'>
<%

for (int j=0; j<arrRow.size();j++)
{
  arrCol = (ArrayList)arrRow.get(j);
 

%>

<input type="hidden" name="applicationID" id="applicationID" id="applicationID" VALUE='<%=(String)arrCol.get(0)%>' />
<input type="hidden" name="applicationName" id="applicationName" value='<%=(String)arrCol.get(1)%>' />
<input type="hidden" name="facilityID" id="facilityID" id="facilityID" VALUE='<%=((String)arrCol.get(8))%>' />
<input type="hidden" name="facilityName" id="facilityName" value='<%=(String)arrCol.get(7)%>' />
<input type="hidden" name="msgID" id="msgID" id="msgID" value="<%=(String)arrCol.get(2)%>"/> 

<input type="hidden" name="even_type" id="even_type" id="even_type" value='<%=(String)arrCol.get(4)%>'/>
<input type="hidden" name="protocol_link_id" id="protocol_link_id" id="protocol_link_id" value='<%=(String)arrCol.get(25)%>'/>
<input type="hidden" name="position" id="position" value='<%=arrCol.get(29)%>' /> 
<%}%>








 

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/ViewEventsFooter.js" ></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad='formload()'>
<form name="application_setup_base_form" id="application_setup_base_form"  method="POST"   action=''>
<table width="100%">

<tr><td colspan=6 align='right'><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type='button' class='button' value='|<' name="firstrecord" id="firstrecord" id="firstrecord" onClick="funAction('F')"><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type='button' class='button' value='<<'  onClick="funAction('P')" <%=strPrevious%>><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type='button' class='button' value='>>'  onClick="funAction('N')" <%=strNext%>><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type='button' class='button' value='>|' name="lastrecord" id="lastrecord" onClick="funAction('L')"></td></tr>	
</table>

<input type="hidden" name="purge_status" id="purge_status" id="purge_status" value='<%=purge_status%>'/>
<input type="hidden" name="protocolMode" id="protocolMode" id="protocolMode" value='<%=protocolMode%>'/>
<input type="hidden" name="action_type" id="action_type" id="action_type" value='<%=action_type%>'/>
<input type="hidden" name="sub_module" id="sub_module" id="sub_module" value='<%=sub_module%>'/>

<input type="hidden" name="whereclause" id="whereclause" id="whereclause" value='<%=java.net.URLEncoder.encode(whereClause)%>'/>



   




<script>  

function formload()
{
if(document.getElementById("pagechange").value=='N')
{


}
else
{
	

	document.getElementById("pagechange").value='N';	
var applicaionID=document.getElementById("applicationID").value;
var facilityId=this.document.getElementById("facilityID").value;
var msgID=this.document.getElementById("msgID").value;
var eventType=this.document.getElementById("even_type").value;
var protocol_link_id=this.document.getElementById("protocol_link_id").value;
var applicationName=escape(this.document.getElementById("applicationName").value);
var facilityName=escape(this.document.getElementById("facilityName").value);
var purge_status=this.document.getElementById("purge_status").value;
var position=parseInt(this.document.getElementById("position").value);
var protocolMode=this.document.getElementById("protocolMode").value;
var sub_module=this.document.getElementById("sub_module").value;
var posi=position;
	var typ=this.document.getElementById("action_type").value;
	if(typ=='L')
    {
	this.document.getElementById("lastrecord").disabled=true;

	
		var url="applicationID="+applicaionID+
				"&facilityID="+facilityId+
				"&msgID="+msgID+
				"&facilityName="+facilityName+
				"&applicationName="+applicationName+
				"&protocolMode="+protocolMode+
				"&sub_module="+sub_module+				"&srlNo=&protocol_link_id="+protocol_link_id+"&purge_status="+purge_status+"&even_type="+eventType+"&posi="+(posi-1)+"&protocolMode="+protocolMode+"&action_type=L&pagechange="+document.getElementById("pagechange").value+"&wherecaluse="+document.getElementById("whereclause").value;
				
		//parent.frames[1].document.location.href='../../eXH/jsp/ViewEventExceptionsHeaderMain.jsp?'+url;
		parent.parent.frames[0].document.location.href='../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?'+url;
//var url2="appl_name="+applicationID.value+"&facility="+facilityID.value+"&msg_id="+msgID+"&event_type="+eventType+"&purge_status="+purge_status+"&commMode="+protocolMode+"&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en";

//parent.frames[2].document.location.href="../../eXH/jsp/ViewMsgReviewAuditLog.jsp?"+url2;



	}
	else if(typ=='F')
	{
		
		this.document.getElementById("firstrecord").disabled=true;
		var url="applicationID="+applicaionID+
				"&facilityID="+facilityId+
				"&msgID="+msgID+
				"&facilityName="+facilityName+
				"&applicationName="+applicationName+
				"&protocolMode="+protocolMode+ 
				"&sub_module="+sub_module+			 	"&srlNo=&protocol_link_id="+protocol_link_id+"&purge_status="+purge_status+"&even_type="+eventType+"&posi="+posi+"&protocolMode="+protocolMode+"&action_type=F&pagechange="+document.getElementById("pagechange").value+"&wherecaluse="+document.getElementById("whereclause").value; 
		
parent.parent.frames[0].document.location.href='../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?'+url;

/*parent.frames[1].document.location.href='../../eXH/jsp/ViewEventExceptionsHeaderMain.jsp?'+url;
var url2="appl_name="+applicationID.value+"&facility="+facilityID.value+"&msg_id="+msgID+"&event_type="+eventType+"&purge_status="+purge_status+"&commMode="+protocolMode+"&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en";
parent.frames[2].document.location.href="../../eXH/jsp/ViewMsgReviewAuditLog.jsp?"+url2;*/
	}
	else
	{  
		
		 var url="applicationID="+applicaionID+
				"&facilityID="+facilityId+
				"&msgID="+msgID+ 
				"&facilityName="+facilityName+
				"&applicationName="+applicationName+
				"&protocolMode="+protocolMode+
				"&sub_module="+sub_module+			 	"&srlNo=&protocol_link_id="+protocol_link_id+"&purge_status="+purge_status+"&even_type="+eventType+"&posi="+posi+"&action_type=Q&pagechange="+document.getElementById("pagechange").value+"&wherecaluse="+document.getElementById("whereclause").value; 
//parent.frames[1].document.location.href='../../eXH/jsp/ViewEventExceptionsHeaderMain.jsp?'+url;

parent.parent.frames[0].document.location.href='../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?'+url;
var url2="appl_name="+applicationID.value+"&facility="+facilityID.value+"&msg_id="+msgID+"&event_type="+eventType+"&purge_status="+purge_status+"&commMode="+protocolMode+"&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en";


//parent.frames[2].document.location.href="../../eXH/jsp/ViewMsgReviewAuditLog.jsp?"+url2;
	}

}
}
//******************************************************************************************
function funAction(typ)
{
	if(typ=='L')
    {

		document.getElementById("action_type").value = "L";
       var act = '../../eXH/jsp/ViewEventNextPreviousPage.jsp?action='+document.getElementById("action_type").value+"&whereClause="+document.getElementById("whereclause").value;
	this.document.forms[0].action = act;
	this.document.forms[0].target="f_query_";  
	this.document.forms[0].submit();

/*parent.frames[0].document.location.href='../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type='+document.getElementById("action_type").value;*/

	} 
	else if(typ=='F')
	{ 
		document.getElementById("action_type").value = "F";
		 var act = '../../eXH/jsp/ViewEventNextPreviousPage.jsp?action='+document.getElementById("action_type").value+"&whereClause="+document.getElementById("whereclause").value;
	this.document.forms[0].action = act;
	this.document.forms[0].target="f_query_"; 
	this.document.forms[0].submit();
/*parent.frames[0].document.location.href='../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type='+document.getElementById("action_type").value;*/
	}
	else
	{
	document.getElementById("action_type").value = "A";
var applicaionID=document.getElementById("applicationID").value; 
var facilityId=this.document.getElementById("facilityID").value;
var msgID=this.document.getElementById("msgID").value;
var eventType=this.document.getElementById("even_type").value;
var protocol_link_id=this.document.getElementById("protocol_link_id").value;
var applicationName=escape(this.document.getElementById("applicationName").value);
var facilityName=escape(this.document.getElementById("facilityName").value);
var purge_status=this.document.getElementById("purge_status").value;
var position=parseInt(this.document.getElementById("position").value);
var protocolMode=this.document.getElementById("protocolMode").value;
var sub_module=this.document.getElementById("sub_module").value;
var posi="";
if(typ=="N")
{
var position=parseInt(this.document.getElementById("position").value);
position=position+1;
posi=position;
}
else
{
var position=parseInt(this.document.getElementById("position").value);
position=position-1;
posi=position;
	} 

//alert("on click"+posi);
var url="applicationID="+applicaionID+
				"&facilityID="+facilityId+
				"&msgID="+msgID+
				"&facilityName="+facilityName+
				"&applicationName="+applicationName+
				"&protocolMode="+protocolMode+
				"&sub_module="+sub_module+			"&srlNo=&protocol_link_id="+protocol_link_id+"&purge_status="+purge_status+"&even_type="+eventType+"&posi="+posi+"&action_type=A&pagechange=Y"+"&whereClause="+document.getElementById("whereclause").value; 
parent.frames[0].document.location.href='../../eXH/jsp/ViewEventNextPreviousPage.jsp?'+url;
	/*var act = '../../eXH/jsp/ViewQueryNextPreviousPage.jsp?'+url;
	this.document.forms[0].action = act;
	this.document.forms[0].target='';
	this.document.forms[0].submit(); */
	}

}


 function windowclose()
{









}
</script>



</form>
</body>
</html>

