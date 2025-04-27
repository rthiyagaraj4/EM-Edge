<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
	String p_module_id		= "XH" ;
	String p_report_id		= "XHREVENT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String sessionid		= "";
%>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js" ></script>
<script language="javascript" src="../../eXH/js/EventsOutbound.js" ></script>
<script language="javascript" src='../../eCommon/js/ValidateControl.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eXH/js/eXHPatientSearch.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
Connection con=null;
try
{
con=ConnectionManager.getConnection();
}catch(Exception e1)
{
	System.out.println("ReportEventsOutbound.jsp:Exception--1 :"+e1.toString());
}
String queryFacility ="SELECT DISTINCT A.FACILITY_ID, s.facility_name  FROM 	xh_appl_for_facility a, sm_facility_param_lang_vw s  WHERE s.language_id='"+locale+"' and	a.facility_id = s.facility_id";
String queryEvent="SELECT DISTINCT(ET.EVENT_TYPE),ET.EVENT_NAME  FROM XH_EVENT_TYPE_LANG_VW ET WHERE ET.LANGUAGE_ID='"+locale+"'";
String queryuser="SELECT USERENV('SESSIONID'), TO_CHAR(SYSDATE,'DDMMYYHH24MISS')"+
			" FROM DUAL";
ResultSet result=null;
Statement stmt=null;
stmt=con.createStatement();
String pateint_query="select patient_id_length from mp_param";
			String pat_id_length="";
			
	       	result=stmt.executeQuery(pateint_query);
			if (result.next() && result != null)
			{
				pat_id_length = result.getString(1);
			
			}
			if(result!=null) result.close();

%>
<form name="report_events_out_bound" id="report_events_out_bound" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<td class='COLUMNHEADER'colspan=2 ><fmt:message key="eXH.ReportCriteria.Label" bundle="${xh_labels}"/></td>
<tr>
<td width='30%'></td> 
<td width='70%'></td> 
</tr>
<tr>
<td class=label ><fmt:message key="eXH.Facility.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name ="ND_FACILITY_ID" id ="ND_FACILITY_ID" >
<option value=''>--------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------------</option>
<%
try
	{
		result=stmt.executeQuery(queryFacility);
		while(result.next())
		{
	%>	
			<option value='<%=result.getString(1)%>'><%=result.getString(2)%></option>
	<%	
		}
	    if(result!=null)result.close();
	%>

		</select></td></tr>
	
	<%
	}catch(Exception e1)
	{
		System.out.println("ReportEventsOutbound.jsp:Exception-1 : :"+e1.toString());
	}
%>
<tr>
<td  class=label><fmt:message key="eXH.Status.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
<select id="STATUS" name="STATUS" id="STATUS">
	<option value = 'L'><fmt:message key="eXH.All.Label" bundle="${xh_labels}"/></option>                                              
	<option value = 'A'><fmt:message key="eXH.AbouttoSplit.Label" bundle="${xh_labels}"/></option>
	<option value = 'S'><fmt:message key="eXH.Abouttoprocess.Label" bundle="${xh_labels}"/></option>
	<option value = '0'><fmt:message key="eXH.Unprocessed.Label" bundle="${xh_labels}"/></option>
	<option value = 'N'><fmt:message key="eXH.NotRequired.Label" bundle="${xh_labels}"/></option>
	<option value = 'E'><fmt:message key="eXH.Error.Label" bundle="${xh_labels}"/></option>
</select>
</td>
</tr>
<tr>
<td width='30%'></td> 
<td width='70%'></td> 
</tr>
</table>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr >
<td >
	<fieldset style=" border-color:black;"><legend><b><fmt:message key="eXH.From.Label" bundle="${xh_labels}"/></b></legend>
	<table cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr>
	<td width='25%'></td> 
	<td width='75%'></td> 
	</tr>
	<tr>
		<td class=label ><fmt:message key="eXH.EventType.Label" bundle="${xh_labels}"/></td>
		<td class='fields'><select name="ND_FROM_EVENT_TYPE" id="ND_FROM_EVENT_TYPE" id="ND_FROM_EVENT_TYPE" >
		<option value=''>-----------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>------------</option>
		<%
try
	{
		result=stmt.executeQuery(queryEvent);
		while(result.next())
		{
	%>	
			<option value='<%=result.getString(1)%>'><%=result.getString(2)%></option>
	<%	
		}
	    if(result!=null)result.close();
	%>

		</select></td></tr>
	
	<%
	}catch(Exception e1)
	{
		System.out.println("ReportEventsOutbound.jsp:Exception-2 : :"+e1.toString());
	}
	
%>
	</select>
		</td>
	</tr>
	
	<tr>
		<td class=label ><fmt:message key="eXH.Patient.Label" bundle="${xh_labels}"/></td>
		<td class='fields'><input type=text size=25 id="ND_FROM_PATIENT_ID" name="ND_FROM_PATIENT_ID" id="ND_FROM_PATIENT_ID" maxlength="<%=pat_id_length%>" onBlur="makeValidString(this);ChangeUpperCase(this);document.forms[0].clear.onclick();" onKeypress='return CheckForSpecChars(event);'> <input class='BUTTON' type="button"  name=reset value='?' onClick="callSearchScreen()"></td>
	</tr>
	<tr>
	<td width='25%'></td> 
	<td width='75%'></td> 
	</tr>
	
	</table>	
	</fieldset>
</td>
<td >
	<fieldset style=" border-color:black;"><legend><b><fmt:message key="eXH.To.Label" bundle="${xh_labels}"/></b></legend>
	<table cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr>
	<td width='25%'></td> 
	<td width='75%'></td> 
	</tr>
	<tr>
		<td class=label ><fmt:message key="eXH.EventType.Label" bundle="${xh_labels}"/></td>
		<td class='fields'><select name="ND_TO_EVENT_TYPE" id="ND_TO_EVENT_TYPE" id="ND_TO_EVENT_TYPE" >
		<option value=''>--------------------------------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-----------------------------</option>
		 <%
                   try
				   {
					    result =stmt.executeQuery(queryEvent);
						while(result.next())
					   {
		  	 %>
		        		<option value ='<%=result.getString(1)%>'><%=result.getString(2)%></option>	
		     <% 
					   }
			           if(result!=null)result.close();
                   }
				   catch(Exception e1)
				   {
						System.out.println("ReportEventsOutbound.jsp:Exception-3 :"+e1.toString());
				   }
				   
			 %>
			</select>	</td></tr>

	<tr>
		<td class=label ><fmt:message key="eXH.Patient.Label" bundle="${xh_labels}"/></td>
		<td class='fields'><input type=text size=25 id="ND_TO_PATIENT_ID1" name="ND_TO_PATIENT_ID" id="ND_TO_PATIENT_ID" maxlength="<%=pat_id_length%>" onBlur="makeValidString(this);ChangeUpperCase(this);document.forms[0].clear.onclick();" onKeypress='return CheckForSpecChars(event);'> <input class='BUTTON' type="button"  name=reset value='?' onClick="callSearchScreen1()"></td>
	</tr>
	<tr>
	<td width='20%'></td> 
	<td width='80%'></td> 
	</tr>
	
	</table>	
	</fieldset> 
</td>
</tr>
<tr><td></td><td></td></tr>
</table>
 <%
                   try
				   {
					    result =stmt.executeQuery(queryuser);
						while(result.next())
					   {
		  	             sessionid=result.getString(1);
						 					   }
			          if(result!=null)result.close();
                   }
				   catch(Exception e1)
				   {
						System.out.println("2 :"+e1.toString());
				   }
				   finally
				{
                if(stmt!=null)stmt.close();
				ConnectionManager.returnConnection(con);
				}
			 %>

<input type="hidden" name="SESSION_ID" id="SESSION_ID"	value="<%=sessionid %>">
<input type="hidden" name="ND_OPERATING_FACILITY_ID" id="ND_OPERATING_FACILITY_ID" value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" value="<%= p_report_id %>">
<input type="hidden" name="PGM_DATE" id="PGM_DATE" value="">
</form>
</body>
</html>

