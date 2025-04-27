<!DOCTYPE html>
<HTML>
<%@ page import= "java.util.*" %>
<%@ page import="java.sql.Connection,com.ehis.util.DateUtils,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
session.putValue("PatientSearch","true" );
%>	

<HEAD>
																									  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	

<%											 
String queryFacility;
String applicationId = request.getParameter("applnname");
String function_id=XHDBAdapter.checkNull(request.getParameter("function_id"));
//String function_id = request.getParameter("function_id"); // used to populate communicatio mode list items.	
%>		    

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/ApplicationMessages.js"></script>
<script language="javascript" src="../../eXH/js/XHAjaxUtil.js"></script>
<script Language="JavaScript" src="../../eXH/js/ViewEventsOutbound.js"></script>
<script language="javascript" src="../../eXH/js/ViewEvents.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>																		   

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown='submitFormOnEnter()' onLoad="initSetup();">
<%
Connection con = null;

Properties p = (Properties) session.getValue("jdbc");								   
String loggedUser = p.getProperty("login_user");	 
String facility = XHDBAdapter.checkNull(request.getParameter("facility"));
String event_status = XHDBAdapter.checkNullNoTrim(request.getParameter("event_status"));
String protocol_link_name = XHDBAdapter.checkNull(request.getParameter("protocol_link_name"));
String interface_module = XHDBAdapter.checkNull(request.getParameter("interface_module"));
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
String externalAccNoFrom = XHDBAdapter.checkNull(request.getParameter("externalAccNoFrom"));
String externalAccNoTo = XHDBAdapter.checkNull(request.getParameter("externalAccNoTo"));
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String msg_status = XHDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
String action_typ = XHDBAdapter.checkNull(request.getParameter("action_typ"));					 
String msg_date = XHDBAdapter.checkNull(request.getParameter("msg_date"));
String pat_id = XHDBAdapter.checkNull(request.getParameter("pat_id"));
String episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
String visit_id = XHDBAdapter.checkNull(request.getParameter("visit_id"));
String last_processed_date = XHDBAdapter.checkNull(request.getParameter("last_processed_date"));
String not_req_rsn = XHDBAdapter.checkNull(request.getParameter("not_req_rsn"));
String addeddate = XHDBAdapter.checkNull(request.getParameter("addeddate"));
String addedwsno = XHDBAdapter.checkNull(request.getParameter("addedwsno"));
String modfid = XHDBAdapter.checkNull(request.getParameter("modfid"));
String modifieddate = XHDBAdapter.checkNull(request.getParameter("modifieddate"));
String modifiedwsno = XHDBAdapter.checkNull(request.getParameter("modifiedwsno"));
String merg_pat_id = XHDBAdapter.checkNull(request.getParameter("merg_pat_id"));
String episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
String addid = XHDBAdapter.checkNull(request.getParameter("addid"));
String dispMode = XHDBAdapter.checkNull(request.getParameter("dispMode"));
String isFromEditQuery = XHDBAdapter.checkNull(request.getParameter("editquery"));	 
// End populate variables
  System.out.println(" ViewEventsOutboundHeader.jsp purge_status  :"+purge_status);
String strXlsAuth = null;


try
{
con = ConnectionManager.getConnection();

if(applicationId == null) applicationId = "";
else if(applicationId.equals("null")) applicationId = "";

String queryEventType	= "SELECT DISTINCT me.EVENT_TYPE , me.EVENT_NAME FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me WHERE me.LANGUAGE_ID='"+locale+"' AND me.COMMUNICATION_TYPE = 'O' AND M.APPLICATION_ID = NVL('"+applicationId+"',M.APPLICATION_ID) AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'";
queryFacility			= "SELECT DISTINCT A.FACILITY_ID, s.facility_name FROM xh_appl_for_facility a, sm_facility_param_lang_vw s  WHERE s.LANGUAGE_ID='"+locale+"' AND a.facility_id = s.facility_id AND a.application_id = NVL('"+applicationId+"', application_id) ";
String queryApplication = "SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW WHERE LANGUAGE_ID='"+locale+"'";
String moduleListQuery	= "SELECT interface_module_id,interface_desc FROM xh_interface WHERE module_id=";
String subModuleListQuery = "SELECT DISTINCT XH.module_id,SM.module_name FROM xh_interface XH,sm_module SM WHERE XH.module_id=sm.module_id ORDER BY SM.module_name";

String authSql = "SELECT replay_yn,rebuild_yn,reload_yn,comm_exception_yn,write_to_excel,audit_yn FROM xh_authorized_user WHERE LOGIN_NAME='"+loggedUser+"'"; 
ResultSet authRS = null;

try
{	
	authRS = con.createStatement().executeQuery(authSql);
	if(authRS.next())
	{				
		strXlsAuth = authRS.getString("write_to_excel");		
	}		
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
finally
{
	if(authRS != null) authRS.close();
}

ResultSet result = null;
Statement stmt = null;																		   

stmt = con.createStatement();
String pateint_query = "select patient_id_length from mp_param";
String pat_id_length = "";

result=stmt.executeQuery(pateint_query);
if (result.next() && result != null)
{
	pat_id_length = result.getString(1);
}
if(result!=null) result.close();
if(stmt!=null) stmt.close();

// Variables used to populate all the fields when coming from Edit Query & Query caused no records functionality.
// Start of populate variables
String msg_dt1 = XHDBAdapter.checkNull(request.getParameter("msg_dt1"));
String msg_id1 = XHDBAdapter.checkNull(request.getParameter("msg_id1"));
String msg_dt2 = XHDBAdapter.checkNull(request.getParameter("msg_dt2"));
String msg_id2 = XHDBAdapter.checkNull(request.getParameter("msg_id2"));
String applnname = XHDBAdapter.checkNull(request.getParameter("applnname"));
String eventtype = XHDBAdapter.checkNull(request.getParameter("eventtype"));
String comm_mode = XHDBAdapter.checkNull(request.getParameter("comm_mode"));

if(!("Y".equals(isFromEditQuery))) // Defaulting current date for Message Date fields,if the flow the not coming from Edit Query.
{
	msg_dt1 = msg_dt2 = DateUtils.getCurrentDate("DMY",locale);	
}

if(comm_mode.equals(""))
{
	comm_mode = "outbound";
}

String select = ""; // variable to default the list item for application, eventtype list box.

%>

<form name="ViewEventsOutboundHeader" id="ViewEventsOutboundHeader" method="post">
<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
  <tr>
<!--  <TD ID="search_tab_link" ALIGN="left" WIDTH="15%" HEIGHT="20" STYLE="background-color:#FFFFFF" onMouseover="changeCursor(this)"><IMG SRC="../../eXH/images/Additional_click.gif" BORDER="0" onClick="tab_click('search_tab')" ID="search_tab"></IMG></TD>
  <TD ID="additional_tab_link" ALIGN="left" WIDTH="15%" HEIGHT="20" STYLE="background-color:#FFFFFF" onMouseover="changeCursor(this)"><IMG SRC="../../eXH/images/Additional.gif" BORDER="0" onClick="tab_click('additional_tab')" ID="additional_tab"></IMG></TD>
  <TD ID="audit_tab_link" ALIGN="left" WIDTH="15%" HEIGHT="20" STYLE="background-color:#FFFFFF" onMouseover="changeCursor(this)"><IMG SRC="../../eXH/images/Additional.gif" BORDER="0" onClick="tab_click('audit_tab')" ID="audit_tab"></IMG></TD>


   <td class='white'>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="General">
				<a onclick="tab_click('search_tab')" class="tabClicked" id='search_tab' >
					<span class="tabSpanclicked" id="search_tab_tabspan">General</span>
				</a>
			 </li>
			 <li class="tablistitem" title="Additional">
				<a onclick="tab_click('additional_tab')" class="tabA" id="additional_tab" >
					<span class="tabAspan" id="additional_tab_tabspan">Additional</span>
				</a>
		   </li>
		   <li class="tablistitem" title="Audit">
				<a onclick="tab_click('audit_tab')" class="tabA" id="audit_tab" >
					<span class="tabAspan" id="audit_tab_tabspan">Audit</span>
				</a>
		   </li> 
       </ul>
	 </td>
-->
   </tr>
</table>

<div id="general" style="display:block">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr>
		<td></td>
		<td>
		<fieldset style=" border-color:black;"  ><legend style="color: black;"><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></legend>
			<table cellspacing=0 cellpadding=3 width='100%' align=center>
			<tr>
				<td width='28%'></td> 
				<td width='72%'></td> 
			</tr>
			
			<tr>
				<td class=label><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type=text name=msg_dt1 id=msg_dt1 value="<%=msg_dt1%>" size=11 onBlur='isAfterCurrDate(this);'> <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('msg_dt1','dd/mm/y');" ></td>  
			</tr>
			<tr>
				<td class=label ><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></td>
				<td class='fields'><input type=text name=msg_id1 id=msg_id1 value="<%=msg_id1%>" size=25 maxlength="20" onKeyPress='return(CheckForSpecChars(event));return(ChkNumberInput(this,event,0))'></td>
			</tr>
			
			<tr style="display:none;">				
				<td class=label><fmt:message key="eXH.ExtAccNo.Label" bundle="${xh_labels}"/></td>				
				<td class='fields' colspan=1><INPUT TYPE="text" name="externalAccNoFrom" id="externalAccNoFrom" ID="externalAccNoFrom" maxlength="300" value="<%=externalAccNoFrom%>" size=25></td>  				
			</tr>
			
			</table>	
		</fieldset>
		</td>
		<td></td>
		<td>
		<fieldset style=" border-color:black;"><legend style="color: black;"><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></legend>		
			<table cellspacing=0 cellpadding=3 width='100%' align=center>

				<tr>
				<td width='28%'></td> 
				<td width='72%'></td> 
				</tr>
				
				<tr>
				<td class=label><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='fields'>
				<input type=text name= msg_dt2 id=msg_dt2 value="<%=msg_dt2%>" size=11 onBlur='isAfterCurrDate(this);'> 
				<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('msg_dt2','dd/mm/y');">
				</td>				
				</tr>

				<tr>
				<td class=label><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></td>
				<td class='fields'>
				<input type=text name=msg_id2 id=msg_id2 value="<%=msg_id2%>" size=25 maxlength="20" onKeyPress='return(CheckForSpecChars(event));return(ChkNumberInput(this,event,0))'>
				</td>
				</tr>
				
				<tr style="display:none;">					
				<td class=label><fmt:message key="eXH.ExtAccNo.Label" bundle="${xh_labels}"/></td>				
				<td class='fields' colspan=1><INPUT TYPE="text" name="externalAccNoTo" id="externalAccNoTo" ID="externalAccNoTo" maxlength="300" value="<%=externalAccNoTo%>" size=25></td> 					
				</tr>
				
			</table>	
	    </fieldset>
		</td>
		<td></td>
	</tr>
</table>

<br>
<fieldset style=" border-color:grey;">
<table cellspacing=0 cellpadding=3 width='100%' align=center>

		<tr>
		<td class=label><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name ="applnname" id="applnname" onChange='onChangeApplication()' style="width: 200px">
		<%
			if(!applnname.equals("") && applnname.equalsIgnoreCase("*A")) select = "selected"; 
		%>
		<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>					
		
		<% 
		try
		{  
			select = "";
			stmt=con.createStatement();
			// Check to populate list item Interactive			
			if(function_id != null && (!function_id.equalsIgnoreCase("XH_J_ADMINISTER_EVENTS")
										&& !function_id.equalsIgnoreCase("XI_J_ADMINISTER_EVENTS")
										&& !function_id.equalsIgnoreCase("XM_J_ADMINISTER_EVENTS")
										&& !function_id.equalsIgnoreCase("XS_J_ADMINISTER_EVENTS")
										&& !function_id.equalsIgnoreCase("XF_J_ADMINISTER_EVENTS")
										&& !function_id.equalsIgnoreCase("XB_J_ADMINISTER_EVENTS")))
			{				
				queryApplication = queryApplication+" AND interactive_yn='Y'";
			}

			  System.out.println(" ViewEventsOutboundHeader queryApplication :"+queryApplication);
			result=stmt.executeQuery(queryApplication);			
			String tempApp = "";
			while(result.next())
			{
				tempApp = result.getString(1);
				if(!applnname.equals("") && applnname.equalsIgnoreCase(tempApp)) select = "selected";
		%>				 
			<option value='<%=tempApp%>' <%=select%>><%=result.getString(2)%></option> 
		<%
				select = "";
			}
			if(result!=null) result.close();
			if(stmt!=null) stmt.close();
		%>
		   </select></td</tr>
		<%
			}catch(Exception e1)
			{
				System.out.println("(ViewEventsOutboundHeader.jsp:Exception-1) "+e1.toString());
			}
		%>
	
		</select><input type='hidden' name='Rule' id='Rule'></td>
		<td class=label><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
		<td class='fields'>											    
		<select name="eventtype" id="eventtype" id="eventtype" style="width: 200px">
		<option value = ''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<!-- <% 
				try
				{  
					String tempEventType = "";
					stmt=con.createStatement();	
					// Check to populate list item Interactive
					if(function_id != null && !function_id.equalsIgnoreCase("XH_J_ADMINISTER_EVENTS"))
					{
						queryEventType = queryEventType+" AND application_id IN (SELECT application_id FROM XH_APPLICATION WHERE interactive_yn='Y')";
					}					
					result=stmt.executeQuery(queryEventType);
					while(result.next())
					{
						tempEventType = result.getString(1);
						if(!eventtype.equals("") && eventtype.equalsIgnoreCase(tempEventType)) select = "selected";
			 %>
				<option value='<%=tempEventType%>' <%=select%>><%=result.getString(2)%></option> 
			 <%
						select = "";
					}
					if(result!=null) result.close();
					if(stmt!=null) stmt.close();
			 %>			
			 <%
				}
				catch(Exception e1)
				{					
					e1.printStackTrace(System.err);
					System.out.println("(ViewEventsOutboundHeader.jsp:Exception-3) "+e1.toString());
				}
			 %> -->

			</select>
			</td>
			<td class=label><fmt:message key="eXH.CommMode.Label" bundle="${xh_labels}"/></td>
		<td class='fields'>
			<select id="comm_mode" name="comm_mode" id="comm_mode" onChange="onChangeCommMode1()" style="width: 200px">
			<%
			// Check to populate list item Interactive			
			if(function_id != null && (function_id.equalsIgnoreCase("XH_J_ADMINISTER_EVENTS")
										|| function_id.equalsIgnoreCase("XI_J_ADMINISTER_EVENTS")
										|| function_id.equalsIgnoreCase("XM_J_ADMINISTER_EVENTS")
										|| function_id.equalsIgnoreCase("XS_J_ADMINISTER_EVENTS")
										|| function_id.equalsIgnoreCase("XB_J_ADMINISTER_EVENTS")
										|| function_id.equalsIgnoreCase("XF_J_ADMINISTER_EVENTS"))){
			%>
				<option value="outbound" <%=comm_mode.equalsIgnoreCase("outbound")?"selected":""%>><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></option>
				<option value="inbound" <%=comm_mode.equalsIgnoreCase("inbound")?"selected":""%>><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></option>
			<%}
			else{%>
				<option value="InterActive"><fmt:message key="eXH.Interactive.Label" bundle="${xh_labels}"/></option>
			<%}%>
			</select>
		</td>
			</tr>
		<tr>
		<td class=label><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<select name="facility" id="facility" id="facility" style="width: 200px">
			<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<% 
		try
		{  
			stmt=con.createStatement();
			
			if(function_id != null && function_id.equalsIgnoreCase("XH_J_ADMINISTER_EVENTS"))
			{				
				queryFacility = "SELECT DISTINCT A.FACILITY_ID code, s.facility_name name FROM XH_DATA_GROUP_DETAIL a, sm_facility_param_lang_vw s  WHERE s.LANGUAGE_ID='"+locale+"' AND a.facility_id = s.facility_id";
			} 
			if(function_id != null && function_id.equalsIgnoreCase("XH_J_ADMINISTER_INTRC_EVENTS"))
			{				
				queryFacility = "SELECT S.FACILITY_ID code, s.facility_name name FROM sm_facility_param s  WHERE s.LANGUAGE_ID='"+locale+"' ";
			}
			
			

		//	System.out.println("queryFacility "+queryFacility);
			
			result=stmt.executeQuery(queryFacility);
			String tempFacility = "";														  

			while(result.next())
			{ 
				tempFacility = result.getString(1);
			//	System.out.println("tempFacility "+tempFacility);
				if(!facility.equals("") && facility.equalsIgnoreCase(tempFacility)) select = "selected";
		%>
			<option value='<%=result.getString(1)%>' <%=select%>><%=result.getString(2)%></option> 
		<%
				select = "";
			}
		%>
			</select></td>
		<%
		}catch(Exception e1)
		{
			System.out.println("(ViewEventsOutboundHeader.jsp:Exception-4) "+e1.toString());
		}																									   
		finally
		{
			try
			{
				if(result!=null)result.close();
				if(stmt!=null) stmt.close();	
			//	 ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				out.println("(ViewEventsOutboundHeader.jsp:Exception-5) "+e);
			}
		}			
			 %>

		<td  class=label><fmt:message key="Common.EventStatus.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<DIV ID="outEventStatusDiv" style="display: block;">
			<select name="event_status" id="event_status" id="event_status" style="width: 200px">					
				<option value = ''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>                                              
				<option value = 'A' <%=event_status.equals("A")?"selected":""%>><fmt:message key="eXH.AbouttoSplit.Label" bundle="${xh_labels}"/></option>			
				<option value = ' ' <%=event_status.equals(" ")?"selected":""%>><fmt:message key="eXH.Unprocessed.Label" bundle="${xh_labels}"/></option> 
		<!--	<option value = 'L' <%=event_status.equals("L")?"selected":""%>><fmt:message key="eXH.SuccessfullyLoaded.Label" bundle="${xh_labels}"/></option> -->
		<!--	<option value = 'R' <%=event_status.equals("R")?"selected":""%>><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option> -->
				<option value = 'S' <%=event_status.equals("S")?"selected":""%>><fmt:message key="eXH.SuccessfullyProcessed.Label" bundle="${xh_labels}"/></option>				
		<!--	<option value = 'N' <%=event_status.equals("N")?"selected":""%>><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option> -->
				<option value = 'E' <%=event_status.equals("E")?"selected":""%>><fmt:message key="Common.Error.label" bundle="${common_labels}"/></option>
		   </select>
		</DIV>
		<DIV ID="inEventStatusDiv" style="display: none;">							    
			<select name="event_status" id="event_status" id="event_status" disabled style="width: 200px">					
				<option value = ''><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>                                              				
		   </select>
		</DIV>
		</td>

		<td class=label ><fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/></td>
		<td class='fields'>
			<select name="msg_status" id="msg_status" id="msg_status" style="width: 200px">					
			</select>			 			   
		</td>
</tr>
</table>								  
</fieldset>
<br>
<fieldset style="border-color:grey;">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr>
	<td class=label width="10%"><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td>
	
	<td width="21%">
		<INPUT TYPE="text" id="protocol_link_name" name="protocol_link_name" id="protocol_link_name" onBlur='searchProtocolID();changeProtocolVal()'  value="<%=protocol_link_name%>">
		<input class="BUTTON" type="button"  name=protocolIDSearch id=protocolIDSearch value='?' onClick="searchProtocolID()">
		<input type="hidden" id="protocol_link_id" name="protocol_link_id" id="protocol_link_id"  value="<%=protocol_link_id%>">
	</td>
	
	<td class=label width="10%"><fmt:message key="eXH.QueueType.Label" bundle="${xh_labels}"/></td>
	<td class=field width="20%">
		<select id="purge_status" name="purge_status" id="purge_status" style="width: 150px">
			<option value=""><fmt:message key="eXH.Online.Label" bundle="${xh_labels}"/></option>
			<option value="OFFLINE" <%=purge_status.equalsIgnoreCase("offline")?"selected":""%>><fmt:message key="eXH.Offline.Label" bundle="${xh_labels}"/></option>
			<option value="PURGE" <%=purge_status.equalsIgnoreCase("purge")?"selected":""%>><fmt:message key="eXH.Purge.Label" bundle="${xh_labels}"/></option>				
		</select>
	</td>															     
																							  
	<% if(strXlsAuth != null && strXlsAuth.equalsIgnoreCase("Y")){ %>
	<td class=label><fmt:message key="eXH.OutputType.Label" bundle="${xh_labels}"/></td>
	<td class=field>
		<select id="dispMode" name="dispMode" id="dispMode" style="width: 150px">					 
			<option value='display' <%=dispMode.equalsIgnoreCase("display")?"selected":""%>><fmt:message key="Common.DisplayResult.label" bundle="${common_labels}"/></option>
			<option value='review' <%=dispMode.equalsIgnoreCase("review")?"selected":""%>><fmt:message key="eXH.ReviewDisplay.Label" bundle="${xh_labels}"/></option>
			<option value='excel' <%=dispMode.equalsIgnoreCase("excel")?"selected":""%>><fmt:message key="eXH.WriteToXls.Label" bundle="${xh_labels}"/></option>		    
		</select>
	</td>
	<% }else{ %>
		<td>&nbsp;</td>	<td><INPUT TYPE="hidden" name="dispMode" id="dispMode" value="display">&nbsp;</td>
	<%}%>

	</tr>

	<tr>
	<!-- This field not required as of now... -->
	<td class=label style="display:none"><fmt:message key="eXH.InterfaceDomain.Label" bundle="${xh_labels}"/></td>			
		<td class='fields' style="display:none">
		<select name="interface_module" id="interface_module" id="interface_module" onChange="clearOptions();onChangeCommMode(this)" style="width: 150px">
		<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		
	<% 
		try
		{  
			String tempModuleID = "";
			String defSelect = "";
			stmt = con.createStatement();
			result = stmt.executeQuery(subModuleListQuery);
			while(result.next())
			{ 						
				tempModuleID = result.getString(1);	  

				// check to make module XH as default select	
			
		
				  if(interface_module.equals(""))
				{
					if(tempModuleID != null && tempModuleID.equalsIgnoreCase("XH")) defSelect = "selected";	   
				}
				else
				{
					if(tempModuleID != null && interface_module.equalsIgnoreCase(tempModuleID)) defSelect="selected";
				} 
			

	%>
			<option value='<%=tempModuleID%>' <%=defSelect%>><%=result.getString(2)%></option> 
	<%
			defSelect = "";
			}					                                   
	%>				
		
	<%
		}catch(Exception e1)
		{
			System.out.println("(ViewEventsOutboundHeader.jsp:Exception-6) "+e1.toString());
		}
		finally
		{
			try
			{
				 if(result!=null)result.close();
				 if(stmt!=null) stmt.close();							
			}
			catch(Exception e)
			{
				out.println("(ViewEventsOutboundHeader.jsp:Exception-7) "+e);
			}
		}
	%>
	
		</select>
		<img src='../../eCommon/images/mandatory.gif'></td>

		<TD CLASS="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></TD>
		<TD CLASS="fields"><INPUT TYPE="text" name="pat_id" id="pat_id" ID="pat_id" VALUE="<%= pat_id %>"></TD>

		<td class=label><fmt:message key="eXH.InterfaceDomain.Label" bundle="${xh_labels}"/></td>
		<td class='fields' >
		<select name="sub_module" id="sub_module" id="sub_module" style="width: 150px" onChange="onChangeApplication()" <%=function_id.equalsIgnoreCase("XH_J_ADMINISTER_INTRC_EVENTS")?"disabled":""%>>				
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</Option>
		<% 
		try
		{  															   
			String tempModuleID = "";
			String defSelect = "";
																							  
			if(interface_module.equals(""))	moduleListQuery = moduleListQuery+"'XH'";
			else moduleListQuery = moduleListQuery+"'"+interface_module+"'";

			moduleListQuery = moduleListQuery+" ORDER BY interface_desc";

			stmt = con.createStatement();
			result = stmt.executeQuery(moduleListQuery);

			while(result.next())
			{ 						
				tempModuleID = result.getString(1);
					
			
					if(sub_module.equals(""))	    
				{
					// check to make module XH as default select
					if(tempModuleID != null && tempModuleID.equalsIgnoreCase("XH")) defSelect="selected";
				}
				else											   
				{
					if(tempModuleID != null && sub_module.equalsIgnoreCase(tempModuleID)) defSelect="selected";
				}
				
	%>			   
			<option value='<%=tempModuleID%>' <%=defSelect%>><%=result.getString(2)%></option> 
	<%
			defSelect = "";
			}					                                   
	%>				
		
	<%
		}catch(Exception e1)
		{
			System.out.println("(ViewEventsOutboundHeader.jsp:Exception-6) "+e1.toString());
		}
		finally
		{
			try
			{
				 if(result!=null)result.close();
				 if(stmt!=null) stmt.close();							
			}
			catch(Exception e)
			{
				out.println("(ViewEventsOutboundHeader.jsp:Exception-7) "+e);
			}
		}
	%>
			</option>
		</select>				
		<img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
</table>
</div>

<!--***************************************ADDITIONAL**********************************************-->
<div id="auditional" style="display:none"> 
		<table cellspacing=0 cellpadding=3 width='100%' align=center>
			<tr>				
			<td class=label>Message Date</td>
			<td class='fields'><input type=text name=msg_date id=msg_date id="msg_date" value="<%=msg_date%>" size=15 onBlur='CheckDate(this);' 
				onselect ='Checkcurrdate(msg_date);'>
			 <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('msg_date','dd/mm/y');"></td>
			 <td class=label></td>
			<td class=label></td>
			</tr>
			<tr>
			
			<td class=label>Merged PatID</td>
			<td class='fields'><input type=text name=merg_pat_id id="merg_pat_id" value="<%=merg_pat_id%>" size=15 >

			</tr>
			<tr>													    
			<td class=label >Episode Type</td>
			<td class='fields'><input type=text name=episode_type id="<%=episode_type%>" size=15 >
			<td class=label>Episode ID</td>
			<td class='fields'><input type=text name=episode_id id="episode_id" value="<%=episode_id%>" size=15 >

			</tr>
			<tr>
			<td class=label >Visit ID </td>
			<td class='fields'><input type=text name=visit_id id="visit_id" value="<%=visit_id%>" size=15 >
			<td class=label>Action Type</td>
			<td class='fields'> <select name=action_typ id="action_typ">
				<option value = ''>All</option>
				<option value = 'I' <%=action_typ.equals("I")?"selected":""%>>Insert</option> 
				<option value = 'U' <%=action_typ.equals("U")?"selected":""%>>Update</option>
			</select></td>

			</tr>
			<tr>
			<td class=label >Last Processed Date</td>
			<td class='fields'><input type=text name=last_processed_date id="last_processed_date" value="<%=last_processed_date%>" size=15 onBlur='CheckDate(this);'>
			<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('last_processed_date','dd/mm/y');"></td>
			<td class=label>Not Req.Reason</td>
			<td class='fields'><input type=text name=not_req_rsn id="not_req_rsn" value="<%=not_req_rsn%>" size=15 >

			</tr>
	</table>
</div>
<!--****************************************AUDIT********************************************-->
<div id="audit" style="display:none"> 
<table cellspacing=0 cellpadding=3 width='100%' align=center>


			<tr>
			<td class=label >Added ID </td>
			<td class='fields'><input type=text name=addid id="addid" value="<%=addid%>" size=15 >
			<td class=label>Added Date</td>
			<td class='fields'><input type=text name=addeddate id="addeddate" value="<%=addeddate%>" size=15 onBlur='CheckDate(this);'>
				 <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('addeddate','dd/mm/y');"></td>
			</tr>

			<tr>
			<td class=label >Added WS No</td>
			<td class='fields'><input type=text name=addedwsno id="addedwsno" value="<%=addedwsno%>" size=15 >
			<td class=label>Modified ID</td>
			<td class='fields'><input type=text name=modfid id="modfid" value="<%=modfid%>" size=15 >
			</tr>

			<tr>
			<td class=label >Modified Date </td>
			<td class='fields'>
				<input type=text name=modifieddate id="modifieddate" value="<%=modifieddate%>" size=15 onBlur='CheckDate(this);'>
				<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('modifieddate','dd/mm/y');">
			</td>
			<td class=label>Modified WS No</td>
			<td class='fields'><input type=text name=modifiedwsno id="modifiedwsno" value="<%=modifiedwsno%>" size=15 >
			</tr>
</table>
</div>
<!--********************************************COMMON***********************************-->
	<table width='100%' cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr align="right">
<td colspan=4 class='BUTTON'><input class='BUTTON' type="button"  ID="search" name=search value='Search' onClick="func1()"></td>
</tr>
	</table>
	<input type='hidden' name='orderBy' id='orderBy' value='23'>
	<input type='hidden' name='order' id='order' value='A'>
	<input type='hidden' name='tabValue' id='tabValue' value=''>
	<input type='hidden' name='pmode' id='pmode' value='F'>
	<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='function_id' id='function_id' id='function_id' value='<%=function_id%>'>	
	<input type='hidden' name='tempMsgStatus' id='tempMsgStatus' id='tempMsgStatus' value='<%=msg_status%>'>
	<input type='hidden' name='tempEventStatus' id='tempEventStatus' id='tempEventStatus' value='<%=eventtype%>'>
<%
} 
catch(Exception e1)
{ 
	System.out.println("(ViewEventsOutboundHeader.jsp:Exception) "+e1.toString());
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</form>
</body>
</html>

