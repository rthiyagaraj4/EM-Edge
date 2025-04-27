<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/SpltyAssTask.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name="specialityAssTaskForm" id="specialityAssTaskForm"  method ='post' target='messageFrame' action='../../servlet/eCA.SpltyAssTaskServlet'>
	<BR><BR>
<%
	  
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
	String sql = "";
	try
	{   
			con = ConnectionManager.getConnection(request);
			String moduleId = "";
			String eventId = "";
			String category1 = "";
			String taskType1 = "";
			String taskcode = "";
			String taskdesc = "";
			String eventDesc = "";
			String readonly="";
			String disabled="";

		if(mode.equals("delete"))
		{		readonly="readonly";
				disabled ="disabled";
				moduleId =  request.getParameter("module") == null ? "" : request.getParameter("module");
				moduleId=moduleId.trim();
				eventId =  request.getParameter("eventId") == null ? "" : request.getParameter("eventId");
				eventId=eventId.trim();
				category1 =  request.getParameter("category1") == null ? "" : request.getParameter("category1");
				category1=category1.trim();
				taskType1 =  request.getParameter("taskType1") == null ? "" : request.getParameter("taskType1");
				taskType1=taskType1.trim(); 
				taskcode =  request.getParameter("taskcode") == null ? "" : request.getParameter("taskcode");

				try{
			 if(taskType1.equals("N"))
		     sql = "SELECT  NOTE_TYPE_DESC  FROM ca_note_type WHERE eff_status='E'  and NOTE_TYPE=?";
			 else
			 sql = "SELECT SHORT_DESC   FROM ca_chart WHERE eff_status='E' and CHART_ID=?";
			 ps = con.prepareStatement(sql);
			 ps.setString(1,taskcode.trim());
		     rs = ps.executeQuery();
			 if(rs.next())
			{
			 if(taskType1.equals("N"))
			 taskdesc=rs.getString("NOTE_TYPE_DESC");
			 else
			   taskdesc=rs.getString("SHORT_DESC");
			}
			 if(rs != null) rs.close();
		     if(ps != null) ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			try{
			 sql = "SELECT  SPLTY_EVENT_DESC  FROM CA_SPLTY_EVENT WHERE eff_status='E' and SPLTY_EVENT_CODE=?";
			 ps = con.prepareStatement(sql);
			 ps.setString(1,eventId);
		     rs = ps.executeQuery();
			 if(rs.next())
			{
			   eventDesc=rs.getString("SPLTY_EVENT_DESC");
			}
			 if(rs != null) rs.close();
		     if(ps != null) ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}

	}
		
		sql = "select MODULE_ID,MODULE_NAME   from SM_module where MODULE_GROUP_ID='SS' order by 2";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
%>
<table border='0' cellspacing='0' cellpadding='3' width='100%' align='center'>
		
		<tr>
			<td class ='label' ><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
			<td class ='fields' >
			<select name ="module"  maxlength='2' <%=disabled%>><option  value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				
<%
		while(rs.next())
		{

			if (moduleId.trim().equals(rs.getString(1).trim()))
				{
					out.println("<option value='"+rs.getString(1)+"' selected>"+rs.getString(2)+"</option>");		
				}
				else
				{
					out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");	
				}
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
%>			</select><img src="../../eCommon/images/mandatory.gif" align="center" >
			</td>
		</tr>
	<tr><td class='label'><fmt:message key="eCA.SpecialityEvent.label" bundle="${ca_labels}"/> </td>
		   <td class='fields'> <input type ='hidden' name='event_id' id='event_id' value='<%=eventId%>'><input type ='text' name='splty_event' id='splty_event' size='20'   value="<%=eventDesc%>" <%=readonly%> onBlur='getspltyEvent1(this,splty_event)'><input type ='Button' class='button' name='buttonSpltyEvent' id='buttonSpltyEvent' value='?' Onclick='getspltyEvent()' <%=disabled%> ><img src="../../eCommon/images/mandatory.gif" align="center" ></td>
	</tr>
		  <tr>
			<td class ='label' ><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
			<td class ='fields' >
			<select name ="category"  maxlength='2' <%=disabled%>><option  value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
			
		   <%if(category1.equals("N")) {%>
						<option  value="N"  selected> <fmt:message key="eCA.NonSpecific.label" bundle="${ca_labels}"/></option>
         <%}else{%>
			<option  value="N"> <fmt:message key="eCA.NonSpecific.label" bundle="${ca_labels}"/></option>
		 <%} %>
		   <%if(category1.equals("M")) {%>
						<option  value="M"  selected> <fmt:message key="Common.Mother.label" bundle="${common_labels}"/></option>
         <%}else{%>
			<option  value="M"> <fmt:message key="Common.Mother.label" bundle="${common_labels}"/></option>
		 <%} %>  
		   	 <%if(category1.equals("F")) {%>
						<option  value="F"  selected> <fmt:message key="eCA.Foetus.label" bundle="${ca_labels}"/></option>
         <%}else{%>
			<option  value="F"> <fmt:message key="eCA.Foetus.label" bundle="${ca_labels}"/></option>
		 <%} %>
		   	 
		    </select><img src="../../eCommon/images/mandatory.gif" align="center" >
		  </td>
	 </tr>
		<tr>
			<td class ='label' ><fmt:message key="eCA.TaskType.label" bundle="${ca_labels}"/></td>
			<td class ='fields' >
			<select name ="taskType"  maxlength='2' <%=disabled%> onchange="enable(this)"><option  value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			 <%if(taskType1.equals("N")) {%>
						<option  value="N"  selected> <fmt:message key="Common.note.label" bundle="${common_labels}"/></option>
         <%}else{%>
			<option  value="N"> <fmt:message key="Common.note.label" bundle="${common_labels}"/></option>
		 <%} %>  
		   	 <%if(taskType1.equals("C")) {%>
						<option  value="C"  selected> <fmt:message key="Common.Chart.label" bundle="${common_labels}"/></option>
         <%}else{%>
			<option  value="C"> <fmt:message key="Common.Chart.label" bundle="${common_labels}"/></option>
		 <%} %>
		  </select><input type ='hidden' name='taskTypeCode' id='taskTypeCode' value='<%=taskcode%>'><input type ='text' name='taskTypeDesc' id='taskTypeDesc' size='20'   value="<%=taskdesc%>" <%=readonly%> onBlur='getTaskType1(this,taskTypeDesc)'   disabled><input type ='Button' class='button' name='buttonTaskType' id='buttonTaskType' value='?' Onclick='getTaskType()'  disabled><img src="../../eCommon/images/mandatory.gif" align="center" >
		  </td>
	 </tr>
	
</table>
				  <input type ='hidden' name='mode' id='mode' value='<%=mode%>'>	
				  <input type ='hidden' name='moduleId' id='moduleId' value='<%=moduleId%>'>
				 
				 
				

</form>
<%
	}
	catch(Exception ee)
	{
	//	out.println("Exception in SpecialtyEventAddModifyIntermediate Module "+ee.toString());//COMMON-ICN-0181
                ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(con != null) 
			  {	
				ConnectionManager.returnConnection(con);
				con.close();
			  }
			}
		catch(Exception e){
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}

%>
	</body>
</html>

