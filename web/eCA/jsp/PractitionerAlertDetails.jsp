<%@ page contentType="text/html;charset=UTF-8" import="java.io.*"%>
<%@ page import="java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<title> Practitioner Notifications</title>
	 <%
 		request.setCharacterEncoding("UTF-8");	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String applUserId = "";
		String event_title = "";
		String classValue= "gridData";
		
		
		applUserId = request.getParameter("userId") == null ? "" : request.getParameter("userId");		
		
		String sqlSel = "Select MESG_ID, PATIENT_ID, EVENT_NORMALACY_IND, EVENT_TITLE, EVENT_DESC, EVENT_READ_YN from sm_user_notification where EVENT_READ_YN ='N' and APPL_USER_ID = ? order by rowid asc";	

		System.out.println(" -----------------PRACTITIONER ALERT DETAILS ----------------------: ");

		System.out.println(" -----------------APPL_USER_ID ZZZZ ----------------------: "+applUserId);
	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try
		{
			con = ConnectionManager.getConnection(request);
			ps = con.prepareStatement(sqlSel);
			ps.setString(1,applUserId);
			res = ps.executeQuery();
			
			System.out.println(" -----------------SQLSEL ----------------------: "+sqlSel);			
		%>
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>	
		<script language="JavaScript">
			function showNotificationDetails(mesgId, mesgDetails){	
				document.getElementById('mesgDetails').value = mesgDetails;

				var functionID = "EVENT_READ_YN";	
	
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				
				xmlStr	="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eCA/jsp/PractitionerAlertQuery.jsp?function_id="+functionID+"&messageId="+mesgId, false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);	
			}
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
	<body onKeyDown="lockKey()">
		<form name='practNotificationForm' id='practNotificationForm'>		
			<div style='width:640px;height:120px;overflow:auto'>
			<table width="100%" align="center" class="grid" >
				<tr>
					<th width="30%"><fmt:message key='Common.patientId.label' bundle='${common_labels}'/></th>
					<th width="20%"><fmt:message key='Common.MessageType.label'  bundle='${common_labels}'/></th>
					<th width="50%"><fmt:message key='Common.Message.label' bundle='${common_labels}'/></th>
				</tr>
				<%					
					String mesg_id = "";
					String patient_id = "";
					String event_normalacy_ind = "";
					event_title = "";
					String event_desc = "";
					String event_read_yn = "";

					String event_indicator = "";
					//int cnt = 0;
					
					try
					{		
						System.out.println(" -----------------INSIDE TRY PRACTITIONER ----------------------: ");	
						while(res.next())
						{							
							mesg_id = res.getString("MESG_ID") == null ? "" : res.getString("MESG_ID");
							patient_id = res.getString("PATIENT_ID") == null ? "" : res.getString("PATIENT_ID");
							event_normalacy_ind = res.getString("EVENT_NORMALACY_IND") == null ? "" : res.getString("EVENT_NORMALACY_IND");
							event_title = res.getString("EVENT_TITLE") == null ? "EMPTY_MESSAGE" : res.getString("EVENT_TITLE");
							event_desc = res.getString("EVENT_DESC") == null ? "EMPTY_MESSAGE" : res.getString("EVENT_DESC");

							if (event_normalacy_ind.equals("I")) event_indicator = "Information";

							if (event_normalacy_ind.equals("W")) event_indicator = "Alert";

							if (event_normalacy_ind.equals("E")) event_indicator = "Warning";

							System.out.println(" -----------------INSIDE EVENT_NORMALACY_IND ----------------------: "+event_normalacy_ind);
							System.out.println(" -----------------INSIDE EVENT_INDICATOR ----------------------: "+event_indicator);

							%> 	
							<tr>
								<td width="30%" class='<%=classValue%>'><%=patient_id%></td>
								<td width="20%" class='<%=classValue%>'><%=event_indicator%></td>
								<td width="50%" class='<%=classValue%>'><a href="javascript:showNotificationDetails('<%=mesg_id%>','<%=event_desc%>')"><%=event_title%></a></td>
							</tr>												
							<%
						}
						if(res != null) res.close();
						if(ps != null) ps.close();
					}
					catch(Exception e)
					{
						System.out.println(" -----------------INSIDE catch  ----------------------: "+e.toString());
						out.println("Exception at try of PractitionerAlertDetails.jsp -"+e.toString());
						e.printStackTrace();
					}
					finally
					{
						if(res != null) res.close();
						if(ps != null) ps.close();
						if(con != null) ConnectionManager.returnConnection(con,request);
					}
		}//end of try
		catch(Exception ee)
		{
			System.out.println(" -----------------INSIDE catch ee ----------------------: "+ee.toString());
			out.println("Exception at try-main of PractitionerAlertDetails.jsp -"+ee.toString());
			ee.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
	%>
			</table>
			</div>
			<br>
			<br>
			<table align='center' class='grid' width='100%'>
				<tr>
					<td class=label>Message Description</td>
					<td colspan=2>
						<textarea class="COMMENTS" name="mesgDetails" rows="8" cols ="60"></textarea>
					</td>
				</tr>
			</table>
			<br>
			<br>
			<table align='center' width='100%'>
				<tr align="right">
				<td><INPUT TYPE="button" name="bcls" id="bcls" class="button" value="Close" onClick='window.close()'></td>
				</tr>
			</table>			
		</form>
	</body>
</html>

