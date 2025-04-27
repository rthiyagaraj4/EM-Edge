<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*" %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");	
	String category = request.getParameter("category");
	


	String stat_code="";
	String stat_desc="";
	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;%>
			
	
	<%try{
		    con = ConnectionManager.getConnection(request);
			out.println("<html><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body>");
			stmt= con.createStatement();	
		
			String sql="";
     	  //added condition check clinic_type,CARE_LOCN_TYPE_IND by rajesh 19/10/2004 
           sql="select  stat_grp_desc,stat_grp_id from am_stat_group where STAT_GRP_CAT = '"+category+"'  order by 1";%>
          <script>
			 obj=parent.frames[1].frames[0].document.getElementById('stat_group')  
		     len=obj.length
				var i=1;
				while(i<len)
				{
					len=obj.length
					obj.remove(i)
				}
		   </script>
		 <%  rs = stmt.executeQuery(sql) ;
		   	if(rs!=null)
			    {
					while (rs.next())
					{			
                        
						
						 stat_code = rs.getString(1);	
						 if(stat_code==null) stat_code="";
				 
						 stat_desc = rs.getString(2);
						 if(stat_desc==null) stat_desc="";
					%>
				<script>
						
				       
			//		var obj =parent.frames[1].frames[1].document.practitioner1_form.stat_group;
					opt=parent.frames[1].frames[0].document.createElement("OPTION");
				    opt.text='<%=stat_code %>';
				    opt.value='<%=stat_desc%>';
					
					parent.frames[1].frames[0].document.getElementById('stat_group').add(opt);

			


                </script>
         <%}
					
					
		}

				
				
			
			
			
		

		}catch(Exception e) { out.println("Main : "+e.toString());}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con,request); 
	}
	out.println("</html>");		
	
%>	

