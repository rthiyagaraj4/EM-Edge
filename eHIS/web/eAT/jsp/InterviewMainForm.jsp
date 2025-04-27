<!DOCTYPE html>
<%@page  import="eOT.*,eOT.Common.*, eCommon.Common.CommonBean, java.util.HashMap,java.util.ArrayList,java.sql.Connection,  java.sql.PreparedStatement,java.sql.Statement, java.sql.ResultSet, webbeans.eCommon.ConnectionManager" %>

	
	<%
	
	Connection connection   = null ;
	PreparedStatement stmt = null ;
	Statement st =null ;
	ResultSet rs = null ;
	ResultSet location = null ;
	ResultSet technology = null ;

try{
			
			String sql1 ="select CITY_ID , CITY_NAME  from  INTERVIEW_CITY_LIST" ;
			String sql2 ="SELECT TECH_ID,TECH_NAME FROM TECH_LIST ORDER BY 2" ;
			String sql3 ="insert into INTERVIEW_CITY_LIST values(?,'?')";
	   		connection	= ConnectionManager.getConnection(request);
			st= connection.createStatement();
			location = st.executeQuery(sql1);
			technology = stmt.executeQuery(sql2);
			



%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    
  </head>
  
  <body>
	<FORM name="interviewForm" id="interviewForm" action="Interview.jsp" method="GET">	 
	<br>
  <TABLE align="left" border="1" cellspacing="10" width="200px" height="">
			
	
			<TR>
				<TD width="300">First Name</TD>
				<TD>
					<INPUT type="text" name="firstName" id="firstName" size="20" />
				</TD></TR>
			<TR>
				<TD width="300"><P></P><P>ShortName</P><P></P></TD>
				<TD>
					<INPUT type="text" name ="shortName" maxlength="20"></TD></TR>
			<TR>
				<TD>
					 &nbsp;Date of Birth
				</TD><TD>
					<INPUT type="text"  name ="dob"  "maxlength="20" value="dob"></TD></TR>
			<TR>
				<TD width="300" name="sex">
					 &nbsp;Sex
				</TD>
				<TD>
						<SELECT name="gender" id="gender">
							<OPTION value="male">
								male
							</option>
							<OPTION value="female" selected>
								female
							</option>
						</SELECT>


					</TD>
</TR>
			<TR>
				<TD width="300">Location</TD>
				<TD width="200">
	
<select>
<%	
	while(location.next())
	{
%>	
<option value='<%=location.getString(1)%>'>
			<%=location.getString(2)%>
</option>
<%	
	} 
	
%>
</select>
	</td>

					</td>					
	</TR>
			<TR>
				<TD width="300">Technology</TD>
				<TD>

	<select>
	<%	
		while(location.next())
		{
	%>	
	<option value='<%=technology.getString(1)%>'>
				<%=technology.getString(2)%>
	</option>
	<%	
		} 
		
	%>
	</select>
		</TD>
				
			</TR>
			<TR>
				<TD width="300">Interview Date</TD>
				<TD>
					<INPUT type="text" name="interviewdate" id="interviewdate" size="20" />
				</TD></TR>
			<TR>
				<TD width="300">Interviewed By</TD>
				<TD>
					<INPUT type="text" name="interviewedBy" id="interviewedBy" size="20" />
				</TD></TR></TABLE>
		
		<INPUT type="submit" name="apply" id="apply" value="Apply" />
		<P></P><P></P><P></P><P></P><P></P><P></P><P></P><P></P><P></P><P></P><P></P><P></P></body>
</FORM>
</html>
<%
}catch ( Exception e ) {
System.err.println("Caught Exception error : "+e);
e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(st!=null) st.close();
		if(stmt!=null) stmt.close();
		if(connection!=null) ConnectionManager.returnConnection(connection,request);
	}catch(Exception es){es.printStackTrace();}
}

%>	

