<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*" %>
<html> 
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"> </link>
	 -->
	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/common.js">	</script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>
<body CLASS='MESSAGE' onKeyDown = 'lockKey()'>
<%
			Connection conn=null;
			Statement stmtn = null;
			Statement stmt = null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			ResultSet rs3=null;
try
{			
	request.setCharacterEncoding("UTF-8");
			conn = ConnectionManager.getConnection(request);
			 stmtn = conn.createStatement();
			 stmt = conn.createStatement();
			String clinic_date= request.getParameter("clinic_date");
			if( clinic_date == null) clinic_date="";
			String Practitioner_id=request.getParameter("Practitioner_id");
			if( Practitioner_id == null) Practitioner_id="";
			String open_to_all_pract_yn= request.getParameter("open_to_all_pract_yn");
			if( open_to_all_pract_yn == null) open_to_all_pract_yn="";
			String clinic_code= request.getParameter("clinic_code");
			if( clinic_code == null) clinic_code="";
			String clinic_type= request.getParameter("clinic_type");
			if( clinic_type == null) clinic_type="";
			String param = request.getParameter("param");
			if( param == null) param="";
			String facilityid=(String)session.getValue("facility_id");
	
			if(param.equals("ForPract"))
			{

			}
		else if( param.equals("ForDate") && !clinic_date.equals(""))
			{	
				String wd1="";
			
				String sql4="select day_no , ROUND(to_date('"+clinic_date+"', 'dd/mm/yyyy') - trunc(sysdate))date_val from sm_day_of_week where ltrim(rtrim(day_of_week)) = ltrim(rtrim(to_char(to_date('"+clinic_date+"','DD/MM/YYYY'),'DAY')))";
				//rs3 = stmt.executeQuery(sql4);
				pstmt = conn.prepareStatement(sql4);
				pstmt.setString(1,clinic_date);
				pstmt.setString(2,clinic_date);
				rs3 = pstmt.executeQuery();
				while(rs3.next())
				{
						wd1 = rs3.getString("date_val");
						%><script>parent.frames[1].document.getElementById("day_no").value="<%=rs3.getString(1)%>" </script><%
				}
			if(rs3 !=null) rs3.close();
			

		int check=Integer.parseInt(wd1);
		if(check < 0 )
		{
			%><script>alert(getMessage('SCH_GR_TODAY','OA'));</script>
			<script>parent.frames[1].document.forms[0].clinic_date.value='';</script>
			<script>parent.frames[1].document.forms[0].clinic_date.focus();</script>
		<%}
		else
		{
			//String sql1="Select '1' From oa_clinic_schedule where facility_id='"+facilityid +"' and  Clinic_code='"+clinic_code+"'  and clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy')  and Nvl(Practitioner_id,'X')= nvl( '"+Practitioner_id+"' ,'X') ";
			String sql1="Select '1' From oa_clinic_schedule where facility_id=? and  Clinic_code=? and clinic_date =to_date(?,'dd/mm/yyyy')  and Nvl(Practitioner_id,'X')= nvl(? ,'X') ";
		//	rs = stmtn.executeQuery(sql1);  
			
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,clinic_code);
			pstmt.setString(3,clinic_date);
			pstmt.setString(4,Practitioner_id);
			rs = pstmt.executeQuery();
			if( rs != null)
			{
				if( rs.next())
				{%>
					<script>alert(getMessage('SCH_ALREADY_EXISTS','OA'));</script>
					<script>parent.frames[1].document.forms[0].clinic_date.value='';</script>
					<script>parent.frames[1].document.forms[0].clinic_date.focus();</script>
				<%}			
			}	
		}
	 }
 if(rs !=null) rs.close();
 if(rs3 !=null) rs3.close();
 if(stmt !=null) stmt.close();
 if(stmtn !=null) stmtn.close();
}
catch(Exception e){ 
//out.println(e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>
</body>
</html>

