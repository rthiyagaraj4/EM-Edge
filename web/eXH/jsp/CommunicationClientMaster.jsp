<!DOCTYPE html>
<!-- Comment added on 2/7/2008 --> 
<HTML>	     
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,java.net.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String locale = ((String)session.getAttribute("LOCALE"));
%>
<HEAD>				    
<%
try
{	
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
System.out.println("PATH 11 "+request.getRequestURI());
System.out.println("PATH 12 "+request.getContextPath());
%>
 					   
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'></link> 
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eXH/js/CommnClients.js'></script>									 
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='javascript' src='../../eXH/js/ExternalApplication.js'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>						 

<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad='onLoadOfpage();forwardRequest();'>
<%
String CLIENT_ID = "";              
String CLIENT_NAME = "";            
String OUTBOUND_YN = "";            		 
String INBOUND_YN = "";             
String INBOUND_IP_ADDRESS = "";     	  
String INBOUND_PORT_NUMBER = "";    
String INBOUND_IP_ADDRESSF = "";     
String INBOUND_PORT_NUMBERF = ""; 
String IN_USE_YN = "Y";              
String INBOUND_APPLICATION_ID = ""; 
String INBOUND_PROTOCOL_LINK_ID = "";
String OUTBOUND_APPLICATION_ID = "";
//String INBOUND_FACILITY_ID = "";
//String OUTBOUND_FACILITY_ID=""; 
String PROTOCOL_LINK_ID = "";      
String IN_USE_YN_COMM = "";
String mode = request.getParameter("mode");
String reportOPDir = "";

CLIENT_ID = XHDBAdapter.checkNull(request.getParameter("client_id"));
CLIENT_NAME = XHDBAdapter.checkNull(request.getParameter("client_name"));
OUTBOUND_YN = XHDBAdapter.checkNull(request.getParameter("main_outbound_in_use"));
INBOUND_YN = XHDBAdapter.checkNull(request.getParameter("main_inbound_in_use"));
IN_USE_YN = XHDBAdapter.checkNull(request.getParameter("main_in_use"));
INBOUND_IP_ADDRESS = XHDBAdapter.checkNull(request.getParameter("inbound_tcp_addr"));
INBOUND_PORT_NUMBER = XHDBAdapter.checkNull(request.getParameter("inbound_port_num"));
String message = XHDBAdapter.checkNull(request.getParameter("message"));

String dmode = request.getParameter("dmode");
//String protocol_link_id = request.getParameter("protocol_link_id");

boolean updateMode = false;

ResultSet rs1=null;
Statement stmt1=null;
Connection con=null;
int id = 0;
int inID = 0;
String outboundID = "";
String inboundID = "";

String sql1="";
try
{
	con=ConnectionManager.getConnection();
}catch(Exception ex ){
	System.out.println("(CommunicationClientMaster:Exception) :"+ex.toString());}

if(INBOUND_IP_ADDRESS==null) INBOUND_IP_ADDRESSF=""; else INBOUND_IP_ADDRESSF=INBOUND_IP_ADDRESS;
if(INBOUND_PORT_NUMBER==null) INBOUND_PORT_NUMBERF=""; else INBOUND_PORT_NUMBERF=INBOUND_PORT_NUMBER;

if(mode.equals("U"))
{
	CLIENT_ID=request.getParameter("client_id");

	sql1="SELECT CLIENT_NAME,OUTBOUND_YN,INBOUND_YN,INBOUND_IP_ADDRESS,INBOUND_PORT_NUMBER,IN_USE_YN FROM XH_COMM_CLIENT WHERE CLIENT_ID='"+CLIENT_ID+"'";
	try
	{
		if(mode != null && mode.equalsIgnoreCase("U")) updateMode = true;

		stmt1=con.createStatement();
		rs1=stmt1.executeQuery(sql1);
		if(rs1.next())
		{
			CLIENT_NAME = rs1.getString(1);
			OUTBOUND_YN = rs1.getString(2);
			INBOUND_YN = rs1.getString(3);
			INBOUND_IP_ADDRESS = rs1.getString(4);
			INBOUND_PORT_NUMBER = rs1.getString(5);
			IN_USE_YN = rs1.getString(6);
		}
		if(INBOUND_IP_ADDRESS==null) INBOUND_IP_ADDRESSF=""; else INBOUND_IP_ADDRESSF = INBOUND_IP_ADDRESS;
		if(INBOUND_PORT_NUMBER==null) INBOUND_PORT_NUMBERF=""; else INBOUND_PORT_NUMBERF = INBOUND_PORT_NUMBER;

	}
	catch(Exception e1)
	{
		System.out.println("(CommunicationClientMaster:Exception-1) "+e1.toString());
		e1.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			if(rs1!=null)rs1.close();
			if(stmt1!=null)stmt1.close();				
		}
		catch(Exception e)
		{
			out.println("(CommunicationClientMaster:Exception-2) "+e);
		}
	}//end of finally block
}//end of mode=U
%>
<form name="Master_client_comm_form" id="Master_client_comm_form" method='post' action='../../servlet/eXH.CommunicationClientMasterServlet'>
<table cellpadding=3 width="100%" align=center>

<tr>
<td class=label ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
<td class='fields'>
	<input type=text name=client_id id=client_id size=20 maxlength="20" value='<%=CLIENT_ID%>' title='Client ID' <%=mode.equals("U")?"readonly":""%> onblur='ChangeUpperCase(this);checkSpecialChar(this);'>
	<img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
<td class="label">IP Address</td>
<td>
	<input type="text" name="inbound_tcp_addr" id="inbound_tcp_addr" size="20" maxlength="15" value="<%= INBOUND_IP_ADDRESSF %>" title="IP Address (required if this gateway has to be started from application)">
</td>
</tr>
<tr>
<td class=label ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
<td class='fields'>
	<input type=text name =client_name size=20 maxlength="15" value='<%=CLIENT_NAME%>' title='Client Name'>
	<img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
<td class="label">Port No</td>
<td>
	<input type="text" name="inbound_port_num" id="inbound_port_num" size="20" maxlength="15" value="<%= INBOUND_PORT_NUMBERF %>" title="Port No (required if this gateway has to be started from application)">
</td>
</tr>
<tr>
<td class="label"><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
	<input type=checkbox name=main_outbound_in_use id=main_outbound_in_use <%=OUTBOUND_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=OUTBOUND_YN.equals("Y")?"Y":"N"%>' flag='O'>
</td><td></td><td></td></tr>
<tr>
<td class="label"><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
	<input type=checkbox name =main_inbound_in_use <%=INBOUND_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=INBOUND_YN.equals("Y")?"Y":"N"%>' flag='I'>
</td><td></td><td></td></tr>

<tr>
<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=checkbox name =main_in_use <%=IN_USE_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=IN_USE_YN.equals("Y")?"Y":"N"%>'>
	
</td></tr>
	<!--
<tr>
<td class=label ></td>
<td class='fields'>

 <input type='button' class='button' name='CheckEligibility' id='CheckEligibility' 
													value='CheckEligibility' 
													onclick="openBLeligibilityCriteria();">

 <input type='button' class='button' name='openePOS' id='openePOS' 
													value='open POS' 
													onclick="OpenPOS();">

 <input type='button' class='button' name='printUCAF' id='printUCAF' 
													value='print UCAF' 
													onclick="openEpad();">

 <input type='button' class='button' name='eNotification' id='eNotification' 
													value='eNotification' 
													onclick="checkEnotification();">

</td></tr>
-->
</table>

<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
        <tr><td class='white'>
		<ul id="tablist" class="tablist" style=padding-left:0px;>
			<li class="tablistitem" title="<fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/>">
				<a onclick="callJSPs('out')" class="tabClicked" id='out' >
					<span class="tabAspan" id="out_tabspan"><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></span>
				</a>
			 </li>
			 <li class="tablistitem" title="<fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/>">
				<a onclick="callJSPs('inb')" class="tabA" id="inb" >
					<span class="tabAspan" id="inb_tabspan"><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
		   </ul>
	 </td>
   </tr>
</table>
  
<!---------------------------------outbound------------------------------>
<div id='outbounddiv' style='display:none'>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%

boolean boolToggle =  true;	
String strTDClass = "";
String strBeanName = XHFacilityControllerBean.strBeanName;
try
{
	XHFacilityControllerBean	xhBean = XHFacilityControllerBean.getBean(strBeanName,request,session);
	xhBean.action(request,con);
	HashMap resultsQry1 = xhBean.getResultSet();
	ArrayList arrRow1 = (ArrayList)resultsQry1.get("qry_result"); 
	ArrayList arrCol1 = null;	
	boolean boolNext = ((Boolean)resultsQry1.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry1.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}
	%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
if(arrRow1.size()==0)
{
%>

<% } else { %>
<tr>
	<td colspan="5" align="right" class="CAGROUP">
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious%></A>
	<A class='label' style='cursor:pointer' onClick="funAction('N')"><%=strNext%></A>
	</td>
</tr>
<tr>
<td class='COLUMNHEADER' colspan=4 align=center><fmt:message key="eXH.OutboundSettings.Label" bundle="${xh_labels}"/></td>
</tr>
<tr></tr>
<tr>
	<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='20%'><fmt:message key="eXH.Protocol.Label" bundle="${xh_labels}"/></td>	
	<td class='COLUMNHEADER' width='20%'><fmt:message key="eXH.LogDir.Label" bundle="${xh_labels}"/></td>	
	<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>	
</tr>
<%
String outbound_status = "";
String outbound_disabled = "";
boolean outbound_status_color = false;
for (int j=0; j<arrRow1.size();j++)
{	
	arrCol1 = (ArrayList)arrRow1.get(j);
	if (boolToggle == true)
	{
		strTDClass = "QRYEVEN";
		boolToggle =  false;
	}
	else
	{
		strTDClass = "QRYODD";
		boolToggle =  true;
	}

	OUTBOUND_APPLICATION_ID = ((String)arrCol1.get(0)).equals("null")?"":(String)arrCol1.get(0);			
	IN_USE_YN_COMM = XHDBAdapter.checkNull((String)arrCol1.get(4));
	PROTOCOL_LINK_ID = XHDBAdapter.checkNull((String)arrCol1.get(5));
	
	String id_for_outbound_select = OUTBOUND_APPLICATION_ID+PROTOCOL_LINK_ID+"_OUTBOUND_SELECT";


	outbound_status = XHDBAdapter.checkNull((String)arrCol1.get(7));
	outbound_disabled = "";	
	reportOPDir = XHDBAdapter.checkNull((String)arrCol1.get(8)); 
%>
<tr>					  
	
	<input type="hidden" id='<%=id_for_outbound_select%>' name='<%=id_for_outbound_select+"APP"%>' value='<%=OUTBOUND_APPLICATION_ID%>'> 

	<td class='<%=strTDClass%>' width="25%">
		<input type="hidden" name="facility_id" id="facility_id" value="XX">
		<%if(outbound_status != null && outbound_status.equalsIgnoreCase("Y")) { 
		outbound_status_color = true;
		outbound_disabled = "disabled"; %> <font color=green> <%}%>
		<%=((String)arrCol1.get(1)).equals("null")?"":(String)arrCol1.get(1)%>
		<%if(outbound_status != null && outbound_status.equalsIgnoreCase("Y")) {%> </font> <%}%>
	</td>			

	<td class='<%=strTDClass%>' width="35%">
		
		<input type="hidden" name="PID" id="PID" value="<%=(String)arrCol1.get(5)%>">
			

		<%
			String protocolID = id_for_outbound_select+"_protocolLinkID"; 
			String protocolName = id_for_outbound_select+"_protocolLinkName";
				String protocolIDName=id_for_outbound_select+"_protocolID"; 
			outboundID = "out"+id;
			id++;			
		%>		   
		 <input type="hidden" id="<%=protocolIDName%>" name='<%=protocolIDName%>' value="<%=((String)arrCol1.get(9))==null?"":(String)arrCol1.get(9)%>"> 		
		<input type="text" size="40" id='<%=outboundID%>' value='<%=((String)arrCol1.get(5))==null?"":(String)arrCol1.get(6)%>' 
		<%=updateMode?"disabled":""%> name="<%=protocolName%>" id='<%=protocolName%>'
		onBlur="protocolLink('<%=protocolID%>','<%=protocolName%>','<%=id_for_outbound_select%>','O');">
			
		<input type="hidden" id="<%=protocolID%>" name='<%=protocolID%>' value="<%=((String)arrCol1.get(5))==null?"":(String)arrCol1.get(5)%>">			    
		
		<% if(!mode.equalsIgnoreCase("U")) { %>
		<input class='BUTTON' type="button" name=protocolLinkVal id=protocolLinkVal value='?'		
		onClick="protocolLink('<%=protocolID%>','<%=protocolName%>','<%=id_for_outbound_select%>','<%=protocolIDName%>','O');">
		<img src='../../eCommon/images/mandatory.gif' align=middle>
		<% } %>

		<% if(mode.equalsIgnoreCase("U")) { %>
		<input type="button" class='BUTTON' name=protocolLinkVal id=protocolLinkVal value='<fmt:message key="Common.Add.label" bundle="${common_labels}" />'
			onClick="addProtocolLinkID(	'<%=OUTBOUND_APPLICATION_ID%>',
								'<%=((String)arrCol1.get(1)).equals("null")?"":(String)arrCol1.get(1)%>',
								'<%=(String)arrCol1.get(5)%>',
								'<%=CLIENT_ID%>',
								'<%=outboundID%>',
								'O',
								'<%=CLIENT_NAME%>');">		

		<% } %>
	</td>
	<td class='<%=strTDClass%>' width="20%">
		<div id='out_<%=outboundID%>_cb' <%=IN_USE_YN_COMM.equals("Y")?"style='display:block;'":"style='display:none;'"%>>
			<INPUT TYPE="text" NAME="<%=id_for_outbound_select%>_reportOPDir1" maxlength="100" ID="<%=outboundID%>_reportOPDir1" VALUE="<%=reportOPDir%>" onBlur="pathValidation(this,<%=outboundID%>_reportOPDir)">		
		<img src='../../eCommon/images/mandatory.gif' align=middle>
		</div>
		<div id='out_<%=outboundID%>_cb_nodisp' <%=IN_USE_YN_COMM.equals("Y")?"style='display:none;'":"style='display:block;'"%>>
			<INPUT TYPE="text" NAME="<%=id_for_outbound_select%>_reportOPDir1" maxlength="100" ID="<%=outboundID%>_reportOPDir2" VALUE="<%=reportOPDir%>" onBlur="pathValidation(this,<%=outboundID%>_reportOPDir)">
		</div>
		<input type="hidden" NAME="<%=id_for_outbound_select%>_reportOPDir" ID="<%=outboundID%>_reportOPDir" VALUE="<%=reportOPDir%>">
	</td>

	<td class='<%=strTDClass%>' align="center" width="10%">		
		<input type=checkbox name='<%=id_for_outbound_select%>' <%=IN_USE_YN_COMM.equals("Y")?"checked":""%> flag='O' id='out_<%=outboundID%>' onClick=validatecheckbox1(this,'out_<%=outboundID%>_cb','<%=outboundID%>_reportOPDir','<%=protocolIDName%>','out_<%=outboundID%>');		   value='<%=IN_USE_YN_COMM.equals("Y")?"Y":"N"%>'>
	</td>	
</tr>				    
		
<%
}
if(outbound_status_color) { %>
		<tr>
		<td colspan=6 class=label><img src='../../eXH/images/green_square.jpg' width=40 height=15 ><fmt:message key="eXH.Recently.Label" bundle="${xh_labels}"/></td>
		</tr>
<% } 
}
if(resultsQry1!=null) resultsQry1.clear();
if(arrCol1!=null) arrCol1.clear();
if(arrRow1!=null) arrRow1.clear();
}
catch(Exception exception)
{
	System.out.println("EXCEPTION IN  first CommunicationClientmasterOutbound.jsp :"+exception.toString());
	exception.printStackTrace(System.err);
}
%>
</table>
<br></br>
</div>

<!----------------------------------inbound------------------------->
<div id='inbounddiv' style='display:none'>
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<td class='COLUMNHEADER' colspan=2 align=center><fmt:message key="eXH.InboundSettings.Label" bundle="${xh_labels}"/></td>
</tr>
<tr></tr>
</table>
<%
try
{ 
	String strBeanName1 = XHFacilityInboundControllerBean.strBeanName;
	XHFacilityInboundControllerBean	xhBean1 = XHFacilityInboundControllerBean.getBean(strBeanName1,request,session);
	xhBean1.action(request,con);
	HashMap resultsQry = xhBean1.getResultSet();
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}
	%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>

<%
if(arrRow.size()==0)
{
%>

<% } else { %>

<tr>
	<td colspan="5" align="right" class="CAGROUP">
	<A class='label' style='cursor:pointer' onClick="funAction('PI')"><%=strPrevious%></A>
	<A class='label' style='cursor:pointer' onClick="funAction('NI')"><%=strNext%></A>
	</td>
</tr>
<tr>
<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='20%'><fmt:message key="eXH.Protocol.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='20%'><fmt:message key="eXH.LogDir.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
</tr>
<%
	boolean inbound_status_color = false;
boolToggle = true;
for (int j=0; j<arrRow.size();j++)
{
	arrCol = (ArrayList)arrRow.get(j);
	if (boolToggle == true)
	{
		strTDClass = "QRYEVEN";
		boolToggle =  false;
	}
	else
	{
		strTDClass = "QRYODD";
		boolToggle =  true;
	}

	INBOUND_APPLICATION_ID=((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(0);				
	INBOUND_PROTOCOL_LINK_ID=XHDBAdapter.checkNull((String)arrCol.get(5));			
	IN_USE_YN_COMM=((String)arrCol.get(4)).equals("null")?"":(String)arrCol.get(4);  

	String id_for_inbound_select = INBOUND_APPLICATION_ID+INBOUND_PROTOCOL_LINK_ID+"_INBOUND_SELECT";
	String inbound_status = XHDBAdapter.checkNull((String)arrCol.get(7));
	String inbound_disabled = "";
	reportOPDir = XHDBAdapter.checkNull((String)arrCol.get(8));

	%>
	<tr>
	<input type="hidden" id='<%=id_for_inbound_select%>' name='<%=id_for_inbound_select+"APP"%>' value='<%=INBOUND_APPLICATION_ID%>'> 
	<td class='<%=strTDClass%>' width="25%">
	<%if(inbound_status != null && inbound_status.equalsIgnoreCase("Y")) 
		{
		inbound_disabled="disabled";
		inbound_status_color = true;
	%> 
		<font color=green> 
	<%}%>
		<%=((String)arrCol.get(1)).equals("null")?"":(String)arrCol.get(1)%>
		<%if(inbound_status != null && inbound_status.equalsIgnoreCase("Y")) {%> 
		</font> 
	<%}%>
	</td>			
	<td class='<%=strTDClass%>' width="35%">
			
	<%
		String inboundProtocolID = id_for_inbound_select+"_protocolLinkID"; 
		String inboundProtocolName = id_for_inbound_select+"_protocolLinkName";		    
		String proprotocolID=id_for_inbound_select+"_protocolID"; 
		inboundID = "in"+inID;
		inID++;				
	%>					
	<input type="text" size="40" id=<%=inboundID%> value='<%=((String)arrCol.get(5))==null?"":(String)arrCol.get(6)%>' 
	<%=updateMode?"disabled":""%> name="<%=inboundProtocolName%>"	id='<%=inboundProtocolName%>'
	onBlur="protocolLink('<%=inboundProtocolID%>','<%=inboundProtocolName%>','<%=id_for_inbound_select%>','<%=proprotocolID%>','I');">	  
																						   
	<input type="hidden" id="<%=inboundProtocolID%>" name='<%=inboundProtocolID%>' value="<%=((String)arrCol.get(5))==null?"":(String)arrCol.get(5)%>">
	 <input type="hidden" id="<%=proprotocolID%>" name='<%=proprotocolID%>' value="<%=((String)arrCol.get(9))==null?"":(String)arrCol.get(9)%>">   
	<% if(!mode.equalsIgnoreCase("U")) { %>
	<input class='BUTTON' type="button" name=protocolLinkVal id=protocolLinkVal value='?' onClick="protocolLink('<%=inboundProtocolID%>','<%=inboundProtocolName%>','<%=id_for_inbound_select%>','<%=proprotocolID%>','I');">
	<img src='../../eCommon/images/mandatory.gif' align=middle>
	<% } %>																											    

	<% if(mode.equalsIgnoreCase("U")) { %>
	<input type="button" class='BUTTON' name=protocolLinkVal id=protocolLinkVal value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>'
	onClick="addProtocolLinkID('<%=INBOUND_APPLICATION_ID%>',
						'<%=((String)arrCol.get(1)).equals("null")?"":(String)arrCol.get(1)%>',				
						'<%=((String)arrCol.get(5))%>',
						'<%=CLIENT_ID%>',
						'<%=inboundID%>',
						'I','<%=CLIENT_NAME%>');">			

	<% } %>

	</td>																						 
	<td class='<%=strTDClass%>' width="20%">		
		<div id="in_<%=inboundID%>_cb" name="in_<%=inboundID%>_cb" <%=IN_USE_YN_COMM.equals("Y")?"style='display:block;'":"style='display:none;'"%>>
			<INPUT TYPE="text" NAME="<%=id_for_inbound_select%>_reportOPDir1" maxlength="100" ID="<%=inboundID%>_reportOPDir1" VALUE="<%=reportOPDir%>" onBlur="pathValidation(this,<%=inboundID%>_reportOPDir)">
			<img src='../../eCommon/images/mandatory.gif' align=middle>
		</div>
		<div id="in_<%=inboundID%>_cb_nodisp" <%=IN_USE_YN_COMM.equals("Y")?"style='display:none;'":"style='display:block;'"%>>
			<INPUT TYPE="text" NAME="<%=id_for_inbound_select%>_reportOPDir2" maxlength="100" ID="<%=inboundID%>_reportOPDir2" VALUE="<%=reportOPDir%>" onBlur="pathValidation(this,<%=inboundID%>_reportOPDir)">			
		</div>
		<input type="hidden" NAME="<%=id_for_inbound_select%>_reportOPDir" ID="<%=inboundID%>_reportOPDir" VALUE="<%=reportOPDir%>">
	</td>																									 

	<td class='<%=strTDClass%>' align="center" width="10%">				
		<input type="checkbox" name='<%=id_for_inbound_select%>' <%=IN_USE_YN_COMM.equals("Y")?"checked":""%> flag='I' id='in_<%=inboundID%>' onClick=validatecheckbox1(this,'in_<%=inboundID%>_cb','<%=inboundID%>_reportOPDir','<%=proprotocolID%>','in_<%=inboundID%>')   value='<%=IN_USE_YN_COMM.equals("Y")?"Y":"N"%>' INBOUND_APPLICATION_ID='<%=INBOUND_APPLICATION_ID%>'>
	</td>
	</tr>
<% 
}
if(inbound_status_color) { 
%>
		<tr>
			<td colspan=6 class=label><img src='../../eXH/images/green_square.jpg' width=40 height=15 >
				<fmt:message key="eXH.Recently.Label" bundle="${xh_labels}"/>
			</td>
		</tr>
<%}
}
if(resultsQry!=null) resultsQry.clear();
if(arrCol!=null) arrCol.clear();
if(arrRow!=null) arrRow.clear();
}
catch(Exception exception)
{
	System.out.println("EXCEPTION IN second coomunicationclientmasteroutbound.jsp :"+exception.toString());
	exception.printStackTrace(System.err);
}
finally
{
	ConnectionManager.returnConnection(con);
}
%>
</table>
<br></br>
</div>
<input type="hidden" name=tab_mode id=tab_mode value='<%=mode%>'>
<input type="hidden" name=message id=message id="message" value='<%=message%>'>
<input type="hidden" name=locale id=locale value='<%=locale%>'/>
<input type="hidden" name=mode id=mode value='<%=mode%>'/>
<input type="hidden" name=flag id=flag />
<input type='hidden' name='action_type' id='action_type' value='R'>
<input type='hidden' name='OUTBOUND_YN' id='OUTBOUND_YN' id='OUTBOUND_YN' value='<%=OUTBOUND_YN%>'>
<input type='hidden' name='INBOUND_YN' id='INBOUND_YN' id='INBOUND_YN' value='<%=INBOUND_YN%>'>
<input type='hidden' name='IN_USE_YN' id='IN_USE_YN' id='IN_USE_YN' value='<%=IN_USE_YN%>'>	

<input type='hidden' name='dmode' id='dmode' value='<%=dmode%>'>
<input type='hidden' name='id' id='id' value='<%=id%>'>
<input type='hidden' name='inID' id='inID' value='<%=inID%>'>
<input type='hidden' id="update_mode" name='update_mode' id='update_mode' value=''>
<input type='hidden' id="del_application_id" name='del_application_id' id='del_application_id' value=''>
<input type='hidden' id="del_facility_id" name='del_facility_id' id='del_facility_id' value=''>
<input type='hidden' id="del_protocol_link" name='del_protocol_link' id='del_protocol_link' value=''>
<input type='hidden' id="del_client_id" name='del_client_id' id='del_client_id' value=''>
<input type='hidden' id="forward_request" name='del_client_id' id='del_client_id' value='<%=(String)request.getParameter("forwardRequest")%>'>


	<%
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}	
%>
<input type='hidden' name='inbound_tcp_addr' id='inbound_tcp_addr' value='000.00.000.000'>
<input type='hidden' name='inbound_port_num' id='inbound_port_num' value='0000'>
</form>	
</BODY>
</HTML>

