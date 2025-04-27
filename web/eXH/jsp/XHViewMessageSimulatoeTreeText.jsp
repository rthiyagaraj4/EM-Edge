<!DOCTYPE html>
 <HTML>
<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,webbeans.eCommon.ConnectionManager,oracle.sql.*,oracle.jdbc.driver.*" %>
<%@ page import = "java.util.*,java.io.*,java.lang.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
String eventName=XHDBAdapter.checkNull(request.getParameter("event"));
String standard_code=XHDBAdapter.checkNull(request.getParameter("standard_code"));
request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<HEAD>
<title><%=eventName%> <fmt:message key="Common.description.label" bundle="${common_labels}"/></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</HEAD>
 <script language="javascript" src="../../eCommon/js/CommonCalendar.js" ></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
<script language='javascript' src='../../eXH/js/ViewServerProcessErrors.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
<script>
function formload()
{
   var message=getMessage('XH0087','XH');
	  alert(message);		
	  document.forms[0].Msg_text.focus();
}
</script>

<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()' onLoad="formload();" >
<form>
<%
	String url="";
	String event_name=""; 
	String applicationId = "";
	String facilityId = "";
	String msgId = "";
	String eventType = "";
	String ProtocolID = "";							    
	String Msq_txt = "";
	String MsgText = "";		   
	String Standard_code = "";
	String Message_syntax = "";
	String Standard_symbols = "";
	String errorMsg = "";
	String event="";
	String Standard_type = "";
	String msgstatus = "";	
	String applicationName=XHDBAdapter.checkNull(request.getParameter("applicationName"));
	String facilityName=XHDBAdapter.checkNull(request.getParameter("facilityName"));
	String protocol_mode = XHDBAdapter.checkNull(request.getParameter("protocolMode"));
	String sub_module = request.getParameter("sub_module");
	String srlNo = request.getParameter("srlNo");
    applicationId = request.getParameter("applicationID"); 
    facilityId = request.getParameter("facilityID");
    msgId = request.getParameter("msgID");
    ProtocolID = request.getParameter("protocol_link_id");
	String event_type = request.getParameter("event_type");
	Connection dbConn = null;												 
	Statement stmt = null; 
	ResultSet rs = null;
  String sqlstr=""; 
String Element_desc="";
try
{ 
	dbConn = ConnectionManager.getConnection(request);
}
catch(Exception w)
{
	System.out.println("Errors in ViewElementTreeText.jsp "+w);
}
try
{
	
	if(protocol_mode.equals("Inbound")||protocol_mode.equals("inbound")) 
	{
		protocol_mode="I";  										    
	} 
	else if(protocol_mode.equals("Outbound")||protocol_mode.equals("outbound"))
	{
		protocol_mode="O";
	}

							 			 


}
catch(Exception e)
{
	System.out.println("Errors in ViewElementTreeText.jsp "+e);
}
finally
	{
	 try{
			if(rs!=null)	   
			{
				rs.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
			ConnectionManager.returnConnection(dbConn);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewElementTreeText.jsp :"+ex.toString());
		   ex.printStackTrace(System.err); }
	} 



 %> 																	  
<table cellspacing=0 cellpadding=3 width="100%" align="center"> 
<tr>
	<td class='fields'><TEXTAREA NAME="Msg_text" ROWS="40" COLS="65" onblur="funSaveOption()"></TEXTAREA></td> 
</tr> 
<tr>
</tr> 
</table>
<input type=hidden name="applicationName" id="applicationName" id="applicationName" value='<%=applicationName%>'>
<input type=hidden name="facilityName" id="facilityName" id="facilityName" value='<%=facilityName%>'>
<input type=hidden name="protocol_mode" id="protocol_mode" id="protocol_mode" value='<%=protocol_mode%>'>
<input type=hidden name="sub_module" id="sub_module" id="sub_module" value='<%=sub_module%>'>
<input type=hidden name="applicationId" id="applicationId" id="applicationId" value='<%=applicationId%>'>
<input type=hidden name="facilityId" id="facilityId" id="facilityId" value='<%=facilityId%>'>
<input type=hidden name="msgId" id="msgId" id="msgId" value=''>
<input type=hidden name="ProtocolID" id="ProtocolID" id="ProtocolID" value='<%=ProtocolID%>'>
<input type=hidden name="event_type" id="event_type" id="event_type" value='<%=event_type%>'>		   	  
</form>																			  
<script>
function funSaveOption() 			 	 
{																			  
			
			//  !=null || document.forms[0].Msg_text.value!=""
		if(document.forms[0].Msg_text.value){  			parent.f_query_add_mod_tree.document.location.href="../../eXH/jsp/XHViewMessageSimulateDisplay.jsp?applicationName="+document.forms[0].applicationName.value+"&applicationID="+document.forms[0].applicationId.value+	"&facilityID="+document.forms[0].facilityId.value+"&facilityName="+document.forms[0].facilityName.value+"&protocol_link_id="+document.forms[0].ProtocolID.value+"&even_type="+document.forms[0].event_type.value+"&Msg_text="+escape(document.forms[0].Msg_text.value);
		} 
		else
		{

		}
}
 function windowclose()							    					   
 {									    		   
	 window.close();			   							    				       
 }																 
</script>
													   
</BODY>													    
</HTML> 										 

