<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
<script language=javascript src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class=MESSAGE OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
</body>
<%
Connection con =null;
try
{
	
	String facility_id =  (String) session.getValue("facility_id") ;
	String login_pract = (String) session.getValue("ca_practitioner_id");
	con = ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
		String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		
		String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String physicianid="";
		String chkphysicianid = "select practitioner_id from op_patient_queue where facility_id = ?  and encounter_id = ?  and locn_type =? and locn_code = ?";
		
		stmt = con.prepareStatement(chkphysicianid);
		stmt.setString(1,facility_id);
		stmt.setString(2,episodeid);
		stmt.setString(3,location_type);
		stmt.setString(4,location_code);
		rs = stmt.executeQuery();
		while(rs!=null && rs.next())
		{
			physicianid = rs.getString("practitioner_id")==null?"":rs.getString("practitioner_id");
		}
		if(physicianid.equals("*ALL"))
		{
			String sql_query= "Select Team_Id from Am_Pract_For_Team_Vw where Facility_Id = ? and Practitioner_Id = ? and Appl_for_op_yn = 'Y' and Speciality_Code = (select specialty_code from pr_encounter where facility_id = ? and encounter_id = ?)";
			String team_id ="";
			int rowCount = 0;	
			if (rs!=null) rs.close();
			if(stmt != null)stmt.close();
			stmt = con.prepareStatement(sql_query);
			stmt.setString(1,facility_id);
			stmt.setString(2,login_pract);
			stmt.setString(3,facility_id);
			stmt.setString(4,episodeid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				team_id = rs.getString(1);
				rowCount++;
			}
			if(team_id == null) team_id = "";
//			out.println("<script>alert('" + rowCount + "')</script>");
			if(rowCount <= 1)
			{%>
				<script>
					var a = confirm(getMessage("PAT_UNASSIGN","CA"));
					var teamid = '<%=team_id%>';
//					alert(teamid);
					if(a) 
					{
						var HTMLVal = "<html><head><link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link></head>";
						HTMLVal += "<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'><form name='OpenChartForm' id='OpenChartForm' action='../../servlet/eCA.CAMainFrameValidateServlet?<%=request.getQueryString()%>' method = 'post'>";
						HTMLVal += "<input type=hidden name=medical_team value='" + teamid + "'";
						HTMLVal += "<input type=hidden name=insert_op value='Y'";
						HTMLVal += "</form>";
						HTMLVal += "</body></html>";
						top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
						top.content.messageFrame.document.OpenChartForm.submit();	
					}
				</script>
			<%}
			else if (rowCount > 1)
			{%>
				<script>
					var episodeid = '<%=episodeid%>'; 
					var retVal = 	new String();
					var dialogHeight = "8";
					var dialogWidth  = "22";
					var dialogTop    = "250";
					var dialogLeft   = "190";
					var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; scroll=no; " ;
					var arguments    = "" ;		
					retVal 	 	 = window.showModalDialog("../../eCA/jsp/PatListSelectMedTeam.jsp?episode_id="+episodeid,arguments,features);
					if(retVal != null)
					{
						var HTMLVal = "<html><head><link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link></link></head>";
						HTMLVal += "<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'><form name='OpenChartForm' id='OpenChartForm' action='../../servlet/eCA.CAMainFrameValidateServlet?<%=request.getQueryString()%>' method = 'post'>";
						HTMLVal += "<input type=hidden name=medical_team value='" + retVal + "'";
						HTMLVal += "<input type=hidden name=insert_op value='Y'";
						HTMLVal += "</form>";
						HTMLVal += "</body></html>";
						top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
						top.content.messageFrame.document.OpenChartForm.submit();	
					
					}
				</script>
			<%}
		}
		
	
	%>
</html>
<%
		if(rs!=null) rs.close();
		if(stmt != null) stmt.close();
}
catch ( Exception e) 
{
	//out.println("Exception @ try "+e.toString());//COMMON-ICN-0181
       e.printStackTrace();//COMMON-ICN-0181
}
finally 
{
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}%>

