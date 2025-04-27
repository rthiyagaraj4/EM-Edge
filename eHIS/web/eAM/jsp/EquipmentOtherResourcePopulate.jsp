<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%

		String sql=null;
		Connection con = null;
		
		PreparedStatement pstmt=null;
		ResultSet rset=null;		
		
		try
		{
			request.setCharacterEncoding("UTF-8");
			con=ConnectionManager.getConnection(request);
	
			String code="";
			String desc="";
			String name=request.getParameter("name");
			String value=request.getParameter("value");
			String facId=request.getParameter("facId").trim();
			String resource_class=request.getParameter("resource_class");
			String bldng=request.getParameter("bldng");

			String comp=" ";
			//String func=request.getParameter("function");	
			
						
			try
			{
				if(name!=null)
					name=name.trim();
						
				if(value!=null)
					value=value.trim();
				
				if(facId!=null)
					facId=facId.trim();

				if(resource_class!=null)
					resource_class=resource_class.trim();

				if(bldng!=null)
					bldng=bldng.trim();
				
			
				if(name.equals("resource_class"))
				{
					sql = "select resource_type,short_desc from am_resource_type where resource_class= '"+resource_class+"' and eff_status='E' order by short_desc";
					comp="parent.f_query_add_mod.document.forms[0].resource_type";
				}	

				if(name.equals("facId"))
				{
					sql = "select bldng_code,short_desc from am_bldng where operating_facility_id= '"+facId+"' and eff_status='E' order by short_desc";
					comp="parent.f_query_add_mod.document.forms[0].bldng";
				}
					
				if(name.equals("bldng"))
				{
					sql = "select floor_code,short_desc from am_bldng_floor where operating_facility_id= '"+facId+"' and bldng_code= '"+bldng+"' and eff_status='E' order by short_desc";	
					comp="parent.f_query_add_mod.document.forms[0].flor";
				}
					
					
				if(sql!=null)
				{
						pstmt=con.prepareStatement(sql);
						rset = pstmt.executeQuery();
				}
									
				
				%>
				  <html><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>
				<%
				if(rset != null) 
				{
					while( rset.next() ) 
					{
						code=rset.getString(1);
						desc=rset.getString(2);
					%>
					<script>
							
						var temp = "<%=code%>";
						var temp1="<%=desc%>";
						var opt=parent.document.f_query_add_mod.document.createElement("OPTION")
						//var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						var comp=<%=comp%>
						comp.add(opt)
					</script>
					<%		   	  
					}
				}

				if(pstmt != null) pstmt.close();
				if(rset != null) rset.close();
			}catch(Exception e) { out.println(e.toString());}		   	  

	}catch(Exception e) { out.println(e.toString());}
	finally
	{
			if(con!=null) ConnectionManager.returnConnection(con,request);			
	
	}
	%>	
 </form></body></html>

