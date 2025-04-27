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
		<script language="JavaScript" src ="../../eCA/js/SpecialityTasksForEvents.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name="specialityTasksForEeventForm" id="specialityTasksForEeventForm"  method ='post' target='messageFrame' action='../../servlet/eCA.SpecialtyEventServlet'>
	<BR><BR>
<%
	  
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
//	ResultSet rsmodify = null;
	String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
	String sql = "";
//	String sqlmodify = "";
	try
	{   
			con = ConnectionManager.getConnection(request);
			String moduleId = "";
//			String code_vlue = "";
			
		sql = "select MODULE_ID,MODULE_NAME   from SM_module where MODULE_GROUP_ID='SS' order by 2";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
%>
<table border='0' cellspacing='0' cellpadding='3' width='100%' align='center'>
		
		<tr>
			<td class ='label' ><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
			<td class ='fields' >
			<select name ="module"  maxlength='2' ><option  value="">----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
				
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
		   <td class='label'><fmt:message key="eCA.SpecialtyTaskHeaderCode.label" bundle="${ca_labels}"/></td>
			<td class='fields'><input type="text" name="code" id="code" value=""  maxlength='6'  size='6' ></td>

</tr>

	<tr><td class='label'><fmt:message key="eCA.SpecialityEvent.label" bundle="${ca_labels}"/> </td>
		   <td class='fields'><input type ='text' name='splty_event' id='splty_event' size='20'   value=""><input type ='Button' class='button' name='buttonSpltyEvent' id='buttonSpltyEvent' value='?' Onclick='getspltyEvent()' ><img src="../../eCommon/images/mandatory.gif" align="center" ></td>
			<td class='label'><fmt:message key="eCA.NoOfTransactionsAllowed.label" bundle="${ca_labels}"/></td>
		   <td class='fields'><input type="text" name="no_of_trans" id="no_of_trans" value=""  maxlength='2'  size="3"  onKeyPress='return numOnly();'></td>
	 </tr>
	 <tr>
			<td colspan='3'></td>
		   <td class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick="loadFrames();"></td>
		</tr>

</table>
				  
				  <input type ='hidden' name='mode' id='mode' value='<%=mode%>'>	
				  <input type ='hidden' name='event_id' id='event_id' value=''>
</form>
<%
	}
	catch(Exception ee)
	{
		out.println("Exception in SpecialtyEventAddModifyIntermediate Module "+ee.toString());
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
			//out.println(e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
			}
	}

%>
	</body>
</html>

