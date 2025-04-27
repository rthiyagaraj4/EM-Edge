<!DOCTYPE html>
<%--
	FileName	: SubserviceinfacilityPopulate.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%><%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%request.setCharacterEncoding("UTF-8");	
	String getservice = request.getParameter("getservice")==null ? "" : request.getParameter("getservice");
	String opfacilityid = request.getParameter("facility_id");

	Connection con= null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;

try
{	
	con = ConnectionManager.getConnection(request);	
		
	if(getservice.equals("one"))
	{
		%>
		<html>
			<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<%
		pstmt 	= con.prepareStatement( "Select distinct service_code,service_short_desc from am_facility_service_vw where operating_facility_id ='"+opfacilityid+"' and eff_status='E' order by service_short_desc" ) ;
		rs = pstmt.executeQuery() ;
		String str1 = "";
		String str2 = "";
		if( rs != null ) 
		{
%>
	
			<script>
				var n=parent.f_query_add_mod.document.getElementById('service_code').options.length;
				for(var i=0;i<n;i++)
				{
					parent.f_query_add_mod.document.getElementById('service_code').remove("service_code");				
				}			
				var tp =" ---Select--- ";
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				parent.f_query_add_mod.document.getElementById('service_code').add(opt);					
			</script>	        
				        
				
<% 			while( rs.next() ) 
			{
				str1 = rs.getString( "service_code" ) ;
				str2 = rs.getString( "service_short_desc" );
				out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+"element.text = \""+str2+"\";"+ "element.value= \""+str1+"\";"+"parent.f_query_add_mod.document.subserviceinfacility_form.service_code.add(element);</script>");
			}
		}
		if(rs!=null)rs.close();
		pstmt.close() ;      		
		out.println("</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>");		
	}
	else if(getservice.equals("two"))
	{
	//Sub service

		String servicecode  = request.getParameter("service_code");
		String opfacilityid1 = request.getParameter("facility_id");
	%>		
		<html>
			<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<%
		pstmt 	= con.prepareStatement( "Select subservice_code,short_desc from am_subservice where service_code ='"+servicecode+"' and eff_status = 'E' order by upper(short_desc)" ) ;
		
		rs = pstmt.executeQuery() ;
		String str3 = "";
		String str4 = "";
		if( rs != null ) 
		{
%>
				<script>
					var n=parent.f_query_add_mod.document.getElementById('dept_code').options.length;
					for(var i=0;i<n;i++)
					{
						parent.f_query_add_mod.document.getElementById('dept_code').remove("dept_code");				
					}			
					var tp =" ---Select--- ";
					var opt=parent.f_query_add_mod.document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					parent.f_query_add_mod.document.getElementById('dept_code').add(opt);					
				
					var n=parent.f_query_add_mod.document.getElementById('subservice_code').options.length;
					for(var i=0;i<n;i++)
					{
						parent.f_query_add_mod.document.getElementById('subservice_code').remove("subservice_code");				
					}			
					var tp =" ---Select--- ";
					var opt=parent.f_query_add_mod.document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					parent.f_query_add_mod.document.getElementById('subservice_code').add(opt);					
				</script>		
<%
	
			while( rs.next() ) 
			{
				str3 = rs.getString( "subservice_code" ) ;
				str4 = rs.getString( "short_desc" );
				out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+"element.text = \""+str4+"\";"+ "element.value= \""+str3+"\";"+"parent.f_query_add_mod.document.subserviceinfacility_form.subservice_code.add(element);</script>");
			}
		}
		if(rs!=null)rs.close();
		pstmt.close() ;   
	
		pstmt 	= con.prepareStatement("Select dept_short_desc,dept_code from am_facility_service_vw where operating_facility_id ='"+opfacilityid1+"' and service_code ='"+servicecode+"'" ) ;
		rs = pstmt.executeQuery() ;
		String str7 = "";
		String str8 = "";
		if( rs != null ) 
		{
		        
			while( rs.next() ) 
			{
				str7 = rs.getString( "dept_code" ) ;
				str8 = rs.getString( "dept_short_desc" );
				out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+"element.text = \""+str8+"\";"+ "element.value= \""+str7+"\";"+"parent.f_query_add_mod.document.subserviceinfacility_form.dept_code.add(element);</script>");
			}
		}
		
		  %>
		</script>
			  </head>
			  <body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body>
			  </html>
			  <%
	  if(rs!=null)rs.close();
	  if(pstmt!=null)pstmt.close();
	}
  
	else {
	
		
		String deptcode = request.getParameter("dept_code");
		String opfacilityid2 = request.getParameter("facility_id");
%>
		<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%	
		pstmt 	= con.prepareStatement( "Select section_code,section_short_desc from am_facility_section_vw where operating_facility_id ='"+opfacilityid2+"' and dept_code ='"+deptcode+"' order by upper(section_short_desc)" ) ;
		
		rs = pstmt.executeQuery() ;
		
		String str5 = "";
		String str6 = "";
		if( rs != null ) 
		
		{
%>				<script>
					var n=parent.f_query_add_mod.document.getElementById('section_code').options.length;
					for(var i=0;i<n;i++)
					{
						parent.f_query_add_mod.document.getElementById('section_code').remove("section_code");				
					}			
					var tp =" ---Select--- ";
					var opt=parent.f_query_add_mod.document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					parent.f_query_add_mod.document.getElementById('section_code').add(opt);					
				</script>		
<%				
			while( rs.next() ) 
			{
		
				str5 = rs.getString( "section_short_desc" ) ;
				str6 = rs.getString( "section_code" );
				out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+"element.text = \""+str5+"\";"+ "element.value= \""+str6+"\";"+"parent.f_query_add_mod.document.getElementById('section_code').add(element);</script>");
			}
		}
		%>
		</script>
			</head>
			<body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body>
			</html>	
	<%
			}
}
catch(Exception e)
{}
finally
	{
	try
	{
	 if (rs != null)	  rs.close();
	 if (pstmt != null)   pstmt.close();
	}
	catch(Exception e)
	{}
	 ConnectionManager.returnConnection(con,request);
}
  
%>

