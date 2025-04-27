<!DOCTYPE html>

<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title></title>
		<%
			request.setCharacterEncoding("UTF-8");	
			String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/SpltyEventOutcome.js'></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'secForNoteTypeValuesForm'>
		<%
			Connection			con			=	null;
			PreparedStatement	pstmt		=	null;
			ResultSet			rs			=	null;
			String module_id	="";
			String module_name	="";

			String Event_query= " select MODULE_ID,MODULE_NAME   from SM_MODULE where  MODULE_GROUP_ID='SS' order by 2 ";
		%>

		<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
				<tr>
				<td class='label' width ='25%'></td>
				<td class='label' width ='25%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
				<td class='fields' width ='50%'>
				<select name="module_name" id="module_name" onchange='setModuleId(this)' >
				<option value="">&nbsp;&nbsp;&nbsp;&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- ----- &nbsp;&nbsp;&nbsp;&nbsp;</option>
				
				<%
					try{
						con				=	ConnectionManager.getConnection(request);
						pstmt			=	con.prepareStatement(Event_query);
						rs				=	pstmt.executeQuery();
				
						while(rs.next())
						{
							module_id		=	rs.getString("MODULE_ID");
							module_name		=	rs.getString("MODULE_NAME");
						
						
						%>
						<option value="<%=module_id%>"><%=module_name%></option>
						<%
						
						}

				
						}
					catch(Exception e )
						{  
							//out.println("Exception@1: "+e);//COMMON-ICN-0181 
							 e.printStackTrace();//COMMON-ICN-0181
						}
					finally
						{
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
							if(con != null) con.close();
						}
				%>
				</select><img src='../../eCommon/images/mandatory.gif'>
				</td>
				</tr>

				<tr>
				<td class='label' width ='25%'></td>
				<td class='label' width ='25%'><fmt:message key="eCA.SpecialityEvent.label" bundle="${ca_labels}"/></td>
				<td class='fields' width ='50%'><input type="text" name="splty_event" id="splty_event" onBlur='getspltyEvent1(this)'><input type ='Button' class='button' name='btnSpltyEvnt' id='btnSpltyEvnt' value='?' Onclick='getspltyEvent()'  ><img src='../../eCommon/images/mandatory.gif'></td>
				</tr>
				<tr> <td class='label' colspan=2></td> 
				<td width='25%' align ="right" ><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="return showSearchResults();"></td></tr>

			</table>

			<input type='hidden' name='module_id' id='module_id'	value=''>
			<input type='hidden' name='event_id' id='event_id'	value=''>

		</form>
	</body>	
</html>

