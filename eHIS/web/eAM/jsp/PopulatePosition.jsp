<!DOCTYPE html>
<%--
	FileName	: PopulatePosition.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<%
request.setCharacterEncoding("UTF-8");	
//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String pract_type = request.getParameter("pract_type");
	String pos_code = request.getParameter("pos_code");

	String position_code="";
	String position_desc="";
	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;%>
		
	<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body>
	
	<%try
		{
		    con = ConnectionManager.getConnection(request);
			
			stmt= con.createStatement();	
		
			String sql="";
     	    sql="select POSITION_CODE,POSITION_DESC from am_position where role_type = 'P' and staff_type = '"+pract_type+"' or staff_type is null  and eff_status = 'E' order by 2";
          
		   rs = stmt.executeQuery(sql) ;
		   	if(rs!=null)
			    {
					while (rs.next())
					{			
                
						 position_code = rs.getString(1);	
						 if(position_code==null) position_code="";
				 
						 position_desc = rs.getString(2);
						 if(position_desc==null) position_desc="";
					%>
				<script>
						
			       
					var obj =parent.frames[1].frames[1].document.practitioner1_form.job_title;
			
					opt=parent.frames[1].frames[1].document.createElement("OPTION");
					
				   if('<%=position_code%>'=='<%=pos_code%>')
					opt.selected=true;	
					opt.text='<%=position_desc%>';
				    opt.value='<%=position_code%>';
					
					parent.frames[1].frames[1].document.getElementById('job_title').add(opt);
                   </script>
         <%}
		}
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		finally
		{
			ConnectionManager.returnConnection(con,request); 
		}
		
	
%>	
</html>

