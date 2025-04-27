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
String applicationId,queryFacility;
applicationId = request.getParameter("applnname");
String function_id = request.getParameter("function_id"); // used to populate communicatio mode list items.	
%>		    

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>			   
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/XHAjaxUtil.js"></script>
<script language="javascript" src="../../eXH/js/XHViewMessageView.js"></script>
<script language="javascript">												    
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown='lockKey()' >
<%
String select = "";
Connection con = null;
Properties p = (Properties) session.getValue("jdbc");
String loggedUser = p.getProperty("login_user");
String strXlsAuth = null;	
ResultSet result = null;
Statement stmt = null;
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
String interface_module = XHDBAdapter.checkNull(request.getParameter("interface_module"));
String moduleListQuery	= "SELECT interface_module_id,interface_desc FROM xh_interface WHERE module_id="; 
String queryApplication = "SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW WHERE LANGUAGE_ID='"+locale+"'"; 
String subModuleListQuery = "SELECT DISTINCT XH.module_id,SM.module_name FROM xh_interface XH,sm_module SM WHERE XH.module_id=sm.module_id ORDER BY SM.module_name";
try
{
	con = ConnectionManager.getConnection();
%>
<form name="ViewEventsOutboundHeader" id="ViewEventsOutboundHeader" method="post">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
   		<tr>
		<td class=label><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name ="applnname" id="applnname" onChange='onChangeApplication()' style="width: 200px">
		<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
		<% 
		try
		{  
			select = "";
			stmt=con.createStatement();
																				    
		    queryApplication = queryApplication;
			result=stmt.executeQuery(queryApplication);			
			String tempApp = "";
			while(result.next())
			{
				tempApp = result.getString(1);
				
		%>				 
			<option value='<%=tempApp%>' ><%=result.getString(2)%></option> 
		<%
				
			}
			if(result!=null) result.close();
			if(stmt!=null) stmt.close();
		%>
		   </select> <img src='../../eCommon/images/mandatory.gif' align=middle></td></tr>
		<%
			}catch(Exception e1)
			{
				System.out.println("(XHMessageViewerSimulator.jsp:Exception-1) "+e1.toString());
			}
		%>
	
		</select><input type='hidden' name='Rule' id='Rule'></td>		       
		<tr>
		<td class=label><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<select name="facility" id="facility" id="facility" style="width: 200px">
			<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
		<% 
		try
		{  
			stmt=con.createStatement();
		
				queryFacility = "SELECT DISTINCT A.FACILITY_ID code, s.facility_name name FROM XH_DATA_GROUP_DETAIL a, sm_facility_param_lang_vw s  WHERE s.LANGUAGE_ID='"+locale+"' AND a.facility_id = s.facility_id";
			

		//	System.out.println("queryFacility "+queryFacility);
			
			result=stmt.executeQuery(queryFacility);								   
			String tempFacility = "";

			while(result.next())
			{ 
				tempFacility = result.getString(1);
		 %>
			<option value='<%=result.getString(1)%>' <%=select%>><%=result.getString(2)%></option> 			  
		<%
			}
		%>
			</select> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
			<%
			}catch(Exception e1)
			{
				System.out.println("(XHMessageViewerSimulator.jsp:Exception-1) "+e1.toString());
			}
		%>
	
			</tr>
			<tr>
			<td class=label width="10%"><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td>
			<td width="21%">
			<INPUT TYPE="text" id="protocol_link_name" name="protocol_link_name" id="protocol_link_name" onBlur='searchProtocolID();'  >
			<input class="BUTTON" type="button"  name=protocolIDSearch id=protocolIDSearch value='?' onClick="searchProtocolID()">
			<input type="hidden" id="protocol_link_id" name="protocol_link_id" id="protocol_link_id"  > <img src='../../eCommon/images/mandatory.gif' align=middle>
		</td>									   
		</tr>	
		 <td class=label><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<select name="eventtype" id="eventtype" id="eventtype" style="width: 200px" disabled>
		<option value = ''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>	   
						</select> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
		</tr>
		<tr>
			<td class=label ><fmt:message key="eXH.CommMode.Label" bundle="${xh_labels}"/></td>
				<td class='fields'>
					<select id="comm_mode" name="comm_mode" id="comm_mode" onChange="onChangeCommMode1()" style="width: 200px">	    
						<option value="outbound"><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></option>			   
						<option value="inbound"><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></option>
					</select>
				</td>											  				    
		   </tr>						 
		   <tr>
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
				if(interface_module.equals(""))
				{
					if(tempModuleID != null && tempModuleID.equalsIgnoreCase("XH")) defSelect = "selected";
				}
				else
				{
					if(tempModuleID != null && interface_module.equalsIgnoreCase(tempModuleID)) defSelect="selected";
				} 
			%>
			<option value='<%=tempModuleID%>' <%=defSelect%> ><%=result.getString(2)%></option> 
	<%
			defSelect = "";
			}					                                   
	%>				
		
	<%																							    
		}catch(Exception e1)
		{
			System.out.println("(XHMessageViewerSimulator.jsp:Exception-6) "+e1.toString());
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
		<td class=label><fmt:message key="eXH.InterfaceDomain.Label" bundle="${xh_labels}"/></td>
		<td class='fields'>
		<select name="sub_module" id="sub_module" id="sub_module" style="width: 150px" onChange="onChangeApplication()">				
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
			<option value='<%=tempModuleID%>'  <%=defSelect%>><%=result.getString(2)%></option> 
	<%
			defSelect = "";
			}					                                    
	%>				
		
	<%
		}catch(Exception e1)
		{
			System.out.println("(XHMessageViewerSimulator.jsp:Exception-6) "+e1.toString());
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
				<tr>
		<td colspan="6" align="right">
		<input class="BUTTON" type="button"  name=mainSearch id=mainSearch value='Message Simulator' onClick="funClick()" align="right" >	    
		</td>																													 
		</tr>
</table>
			

																	  
	 <input type='hidden' name='applicationName' id='applicationName' value=''>
	<input type='hidden' name='orderBy' id='orderBy' value='1'>									   
	<input type='hidden' name='order' id='order' value='A'>
	<input type='hidden' name='tabValue' id='tabValue' value=''>
	<input type='hidden' name='pmode' id='pmode' value='F'>						 
	<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='function_id' id='function_id' id='function_id' value='<%=function_id%>'>	

	
<%
} 
catch(Exception e1)
{ 
	System.out.println("(XHMessageViewerSimulator.jsp:Exception) "+e1.toString());
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</form>
</body>
</html>

