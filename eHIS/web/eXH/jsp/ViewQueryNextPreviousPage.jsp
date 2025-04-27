<!DOCTYPE html>
<HTML> 
 
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %>

<HEAD> 
<% 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle	="IeStyle.css";
//String function_id = (String)request.getParameter("function_id");
String qry_id ="";
//Properties p = (Properties) session.getValue("jdbc");
//String loggedUser = p.getProperty("login_user");
//String commType = request.getParameter("commType");
   
String purge_status=request.getParameter("purge_status"); 
String msg_status=request.getParameter("msg_status");
  String QueryOption=XHDBAdapter.checkNull(request.getParameter("Query_Option"));
String posi=XHDBAdapter.checkNull(request.getParameter("posi"));
  String qapplname=request.getParameter("application_Id");
String pagechange=XHDBAdapter.checkNull(request.getParameter("pagechange"));
 String qfacility=request.getParameter("Facility_Id");

 //System.out.println("qapplname :"+qapplname+"qfacility :"+qfacility);
  ArrayList arrCol = null;
  String qryid=XHDBAdapter.checkNull(request.getParameter("qryid"));
  String action_type=XHDBAdapter.checkNull(request.getParameter("action_type"));
//System.out.println("qryid 29:"+qryid);
  HashMap resultsQry=null; 
  //HashMap resultsQry1=null;
  ArrayList arrRow = null;
  String tableNameSuffix="";
  String whereClause="";
String strPrevious ="";
String strNext="";
  Connection conn=null;
  try
	{
		conn = ConnectionManager.getConnection(request);
	

  if(QueryOption.equals("P"))
  {
		qry_id = "VIEWADMINQUERYPROCESS";
  }
  else if(QueryOption.equals("A"))
  {
		qry_id = "VIEWADMINQUERYINITIATE";
  }
  else
  {
       qry_id = "VIEWADMINQUERYPROCESS";  
  }



if(purge_status != null && !purge_status.equals(""))
	{
	 if(purge_status.equals("purge")) 
	 {
		tableNameSuffix = "XH_PURGE_APPL_QRY_MSG_VW A  WHERE    a.FACILITY_ID = d.facility_id AND A.APPLICATION_ID=B.APPLICATION_ID AND  A.APPLICATION_ID=NVL('"+qapplname+"',A.APPLICATION_ID) AND  A.FACILITY_ID=NVL('"+qfacility+"',A.FACILITY_ID)   AND";
	 }
	 else if(purge_status.equals("offline"))
	 {
		 	tableNameSuffix = "XH_OFFLINE_APPL_QRY_MSG_VW A  WHERE    a.FACILITY_ID = d.facility_id AND A.APPLICATION_ID=B.APPLICATION_ID AND  A.APPLICATION_ID=NVL('"+qapplname+"',A.APPLICATION_ID) AND  A.FACILITY_ID=NVL('"+qfacility+"',A.FACILITY_ID)   AND";
	 }
	}
	else 
	{
		tableNameSuffix = "XH_APPLICATION_QRY_MSG_VW A  WHERE    a.FACILITY_ID = d.facility_id AND A.APPLICATION_ID=B.APPLICATION_ID AND  A.APPLICATION_ID=NVL('"+qapplname+"',A.APPLICATION_ID) AND  A.FACILITY_ID=NVL('"+qapplname+"',A.FACILITY_ID) "; 
	} 


	if((qryid != null) && (!(qryid.equals(""))))			
	{
		whereClause =whereClause +"AND A.QUERY_ID = nvl('"+qryid+"',A.QUERY_ID) order by A.QUERY_ID"; 
	} 

  request.setAttribute("tableName",tableNameSuffix); 
  //System.out.println("QueryOption"+QueryOption);
  request.setAttribute("qry_id",qry_id);  
  request.setAttribute("whereClause",whereClause);
  request.setAttribute("maxRec","1"); 
  request.setAttribute("qryid",qryid); 
  XHViewQueryControllerElementBean	xhBean =
  XHViewQueryControllerElementBean.getBean(XHViewQueryControllerElementBean.strBeanName,request,session);
  xhBean.action(request,conn);
  resultsQry = xhBean.getPositionRecord(posi);
	arrRow = (ArrayList)resultsQry.get("qry_result"); 
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 

    

//System.out.println("boolNext "+boolNext+"boolPrevious "+boolPrevious); 
 // resultsQry1 = xhBean.getResultSet(); 
// arrRow = (ArrayList)resultsQry1.get("qry_result");
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
		System.out.println("ViewQueryNextPreviousPage.jsp:Exception "+e);
	}
	finally
	{
		if(conn != null) ConnectionManager.returnConnection(conn);
	}
//System.out.println("strNext :"+strNext);
//System.out.println("strPrevious :"+strPrevious);
%>
<input type="hidden" name="pagechange" id="pagechange" id="pagechange" value='<%=pagechange%>'>
<%

for (int j=0; j<arrRow.size();j++)
{
  arrCol = (ArrayList)arrRow.get(j);
  	//System.out.println("129 :"+arrCol.get(29));

%>

<input type="hidden" name="Application_id" id="Application_id" id="Application_id" VALUE='<%=(String)arrCol.get(0)%>' />
<input type="hidden" name="Facility_Id" id="Facility_Id" id="Facility_Id" VALUE='<%=((String)arrCol.get(2))%>' />
<input type="hidden" name="msg_id" id="msg_id" id="msg_id" value="<%=(String)arrCol.get(28)%>"/>
<input type="hidden" name="QUERYID" id="QUERYID" id="QUERYID" value="<%=arrCol.get(1)+""%>"/>
<input type="hidden" name="event_type" id="event_type" id="event_type" value='<%=(String)arrCol.get(19)%>'/>
<input type="hidden" name="Protocollink_id" id="Protocollink_id" id="Protocollink_id" value='<%=(String)arrCol.get(22)%>'/>
<input type="hidden" name="STATUSTEXT" id="STATUSTEXT" id="STATUSTEXT" value='<%=java.net.URLEncoder.encode((String)arrCol.get(12))+""%>'/>
<input  type="hidden" name=qapplname value='<%=(String)arrCol.get(23)%>' />
<input  type="hidden" name=qfacility value='<%=(String)arrCol.get(24)%>' />
<input  type="hidden" name=qmsg_dt1 value='' />
<input  type="hidden" name=qmsg_dt2 value='' />

<input  type="hidden" name=qostatus value='<%=QueryOption%>' />
<input  type="hidden" name=application_Msg id=application_Msg value='<%=(String)arrCol.get(25)%>' />
<input  type="hidden" name=Error_msg id=Error_msg  value='<%=(String)arrCol.get(26)%>' />
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
<script> 


function formload()
{
if(document.getElementById("pagechange").value=='N')
{


}
else
{
	
	document.getElementById("pagechange").value='N';	
var appl=document.getElementById("Application_id").value
var faci=this.document.getElementById("Facility_id").value;
var msgid=this.document.getElementById("msg_id").value;
var queryid=this.document.getElementById("QUERYID").value;
var event_type=this.document.getElementById("event_type").value;
var Protocollink_id=this.document.getElementById("Protocollink_id").value;
var statustext=escape(this.document.getElementById("STATUSTEXT").value);
var application_Msg=escape(this.document.getElementById("application_Msg").value);
var Error_msg=escape(this.document.getElementById("Error_msg").value);
var qapplname=escape(this.document.getElementById("qapplname").value);
var qfacility=escape(this.document.getElementById("qfacility").value);
var msg_status=this.document.getElementById("msg_status").value;
var purge_status=this.document.getElementById("purge_status").value;
var qostatus=this.document.getElementById("qostatus").value;
var position=parseInt(this.document.getElementById("position").value);
var posi=position;
	var typ=this.document.getElementById("action_type").value;
	if(typ=='L')
    {
		document.getElementById("lastrecord").disabled=true;
var url="application_Id="+appl+"&Facility_Id="+faci+"&Msg_Id="+msgid+"&qryid="+queryid+"&Even_type="+event_type+"&protocol_link_id="+Protocollink_id+"&STATUSTEXT="+statustext+"&application_Msg="+application_Msg+"&Error_msg="+Error_msg+"&qapplname="+qapplname+"&faciname="+qfacility+"&qmsg_dt1=&qmsg_dt2=&msg_status="+msg_status+"&purge_status="+purge_status+"&Query_Option="+qostatus+"&posi="+posi+"&action_type=A&pagechange="+document.getElementById("pagechange").value; 
parent.frames[1].document.location.href='../../eXH/jsp/ViewQryMsgFooterMain.jsp?'+url;
/*parent.frames[2].document.location.href='../../eXH/jsp/ViewMsgAuditLogDtl.jsp?appl_name='+qapplname+'&facility='+qfacility+'&event_type='+event_type+'&msg_id='+msgid+'&amsg_dt1=&amsg_dt2=&status='+msg_status;*/
var url2="appl_name="+appl.value+"&facility="+faci.value+"&msg_id="+msgid+"&event_type="+event_type+"&purge_status="+purge_status+"&commMode=&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en";

parent.frames[2].document.location.href="../../eXH/jsp/ViewMsgReviewAuditLog.jsp?"+url2;
	}
	else if(typ=='F')
	{
		document.getElementById("firstrecord").disabled=true;

		var url="application_Id="+appl+"&Facility_Id="+faci+"&Msg_Id="+msgid+"&qryid="+queryid+"&Even_type="+event_type+"&protocol_link_id="+Protocollink_id+"&STATUSTEXT="+statustext+"&application_Msg="+application_Msg+"&Error_msg="+Error_msg+"&qapplname="+qapplname+"&faciname="+qfacility+"&qmsg_dt1=&qmsg_dt2=&msg_status="+msg_status+"&purge_status="+purge_status+"&Query_Option="+qostatus+"&posi="+posi+"&action_type=A&pagechange="+document.getElementById("pagechange").value; 
parent.frames[1].document.location.href='../../eXH/jsp/ViewQryMsgFooterMain.jsp?'+url;
/*parent.frames[2].document.location.href='../../eXH/jsp/ViewMsgAuditLogDtl.jsp?appl_name='+qapplname+'&facility='+qfacility+'&event_type='+event_type+'&msg_id='+msgid+'&amsg_dt1=&amsg_dt2=&status='+msg_status;*/
var url2="appl_name="+appl.value+"&facility="+faci.value+"&msg_id="+msgid+"&event_type="+event_type+"&purge_status="+purge_status+"&commMode=&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en";

parent.frames[2].document.location.href="../../eXH/jsp/ViewMsgReviewAuditLog.jsp?"+url2;
	}
	else
	{
 
//alert("differ queryid :"+queryid);
//alert("after click"+posi);
//alert(posi);

var url="application_Id="+appl+"&Facility_Id="+faci+"&Msg_Id="+msgid+"&qryid="+queryid+"&Even_type="+event_type+"&protocol_link_id="+Protocollink_id+"&STATUSTEXT="+statustext+"&application_Msg="+application_Msg+"&Error_msg="+Error_msg+"&qapplname="+qapplname+"&faciname="+qfacility+"&qmsg_dt1=&qmsg_dt2=&msg_status="+msg_status+"&purge_status="+purge_status+"&Query_Option="+qostatus+"&posi="+posi+"&action_type=A&pagechange="+document.getElementById("pagechange").value; 
parent.frames[1].document.location.href='../../eXH/jsp/ViewQryMsgFooterMain.jsp?'+url;
/*parent.frames[2].document.location.href='../../eXH/jsp/ViewMsgAuditLogDtl.jsp?appl_name='+qapplname+'&facility='+qfacility+'&event_type='+event_type+'&msg_id='+msgid+'&amsg_dt1=&amsg_dt2=&status='+msg_status;*/
var url2="appl_name="+appl.value+"&facility="+faci.value+"&msg_id="+msgid+"&event_type="+event_type+"&purge_status="+purge_status+"&commMode=&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en";

parent.frames[2].document.location.href="../../eXH/jsp/ViewMsgReviewAuditLog.jsp?"+url2;

	}

}
}
//******************************************************************************************
function funAction(typ)
{
	if(typ=='L')
    {

		document.getElementById("action_type").value = "L";
       var act = '../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type='+document.getElementById("action_type").value;
	this.document.forms[0].action = act;
	this.document.forms[0].target="f_query_";
	this.document.forms[0].submit();

/*parent.frames[0].document.location.href='../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type='+document.getElementById("action_type").value;*/

	}
	else if(typ=='F')
	{
		document.getElementById("action_type").value = "F";
		 var act = '../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type='+document.getElementById("action_type").value;
	this.document.forms[0].action = act;
	this.document.forms[0].target="f_query_";
	this.document.forms[0].submit();
/*parent.frames[0].document.location.href='../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type='+document.getElementById("action_type").value;*/
	}
	else
	{
	document.getElementById("action_type").value = "A";
var appl=document.getElementById("Application_id").value
var faci=this.document.getElementById("Facility_id").value;
var msgid=this.document.getElementById("msg_id").value;
var queryid=this.document.getElementById("QUERYID").value;
var event_type=this.document.getElementById("event_type").value;
var Protocollink_id=this.document.getElementById("Protocollink_id").value;
var statustext=escape(this.document.getElementById("STATUSTEXT").value);
var application_Msg=escape(this.document.getElementById("application_Msg").value);
var Error_msg=escape(this.document.getElementById("Error_msg").value);
var qapplname=escape(this.document.getElementById("qapplname").value);
var qfacility=escape(this.document.getElementById("qfacility").value);

var msg_status=this.document.getElementById("msg_status").value;
var purge_status=this.document.getElementById("purge_status").value;
var qostatus=this.document.getElementById("qostatus").value;
var posi="";
//alert("on click queryid :"+queryid);
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
var url="application_Id="+appl+"&Facility_Id="+faci+"&Msg_Id="+msgid+"&qryid="+queryid+"&Even_type="+event_type+"&protocol_link_id="+Protocollink_id+"&STATUSTEXT="+statustext+"&application_Msg="+application_Msg+"&Error_msg="+Error_msg+"&qapplname="+qapplname+"&faciname="+qfacility+"&qmsg_dt1=&qmsg_dt2=&msg_status="+msg_status+"&purge_status="+purge_status+"&Query_Option="+qostatus+"&posi="+posi+"&action_type=A&pagechange=Y"; 
parent.frames[0].document.location.href='../../eXH/jsp/ViewQueryNextPreviousPage.jsp?'+url;
	/*var act = '../../eXH/jsp/ViewQueryNextPreviousPage.jsp?'+url;
	this.document.forms[0].action = act;
	this.document.forms[0].target='';
	this.document.forms[0].submit(); */
	}

}


 function windowclose()
{
/*application_Id="+this.document.forms[0].Application_id.value+"&Facility_Id="+this.document.forms[0].Facility_id.value+"&Msg_Id="+this.document.forms[0].msg_id.value+"&qryid="+this.document.forms[0].QUERYID.value+"&Even_type="+this.document.forms[0].event_type.value+"&protocol_link_id="+this.document.forms[0].Protocollink_id.value+"&STATUSTEXT="+escape(this.document.forms[0].STATUSTEXT.value)+"&application_Msg="+escape(appl_msg)+"&Error_msg="+escape(err_msg)+"&qapplname="+this.document.forms[0].qapplname.value+"&faciname="+this.document.forms[0].qfacility.value+"&qmsg_dt1="+this.document.forms[0].qmsg_dt1.value+"&qmsg_dt2="+this.document.forms[0].qmsg_dt2.value+"&msg_status="+document.forms[0].msg_status.value+"&purge_status="+this.document.forms[0].purge_status.value+"&Query_Option="+this.document.forms[0].qostatus.value,arguments,features);*/

/*parent.document.location.href="../../eXH/jsp/ViewQryMsgFooterMasterMain.jsp?application_Id="+this.document.forms[0].Application_id.value+"&Facility_Id="+this.document.forms[0].Facility_id.value+"&Msg_Id="+this.document.forms[0].msg_id.value+"&qryid="+this.document.forms[0].QUERYID.value+"&Even_type="+this.document.forms[0].event_type.value+"&protocol_link_id="+this.document.forms[0].Protocollink_id.value+"&STATUSTEXT="+escape(this.document.forms[0].STATUSTEXT.value)+"&application_Msg="+escape(appl_msg)+"&Error_msg="+escape(err_msg)+"&qapplname="+this.document.forms[0].qapplname.value+"&faciname="+this.document.forms[0].qfacility.value+"&qmsg_dt1="+this.document.forms[0].qmsg_dt1.value+"&qmsg_dt2="+this.document.forms[0].qmsg_dt2.value+"&msg_status="+document.forms[0].msg_status.value+"&purge_status="+this.document.forms[0].purge_status.value+"&Query_Option="+this.document.forms[0].qostatus.value,arguments,features*/

}
</script>
<input  type="hidden" name=msg_status value='<%=msg_status%>' /> 
<input type="hidden" name="purge_status" id="purge_status" id="purge_status" value='<%=purge_status%>'/>
<input type="hidden" name="action_type" id="action_type" id="action_type" value='<%=action_type%>'/>
</form>
</body>
</html>

