
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<%
   request.setCharacterEncoding("UTF-8"); 

   String module_id=request.getParameter("module_id");
   //String menu_id=request.getParameter("menuid");
   String mode=request.getParameter("mode");
   mode 		 = (mode == null)?"":mode;
   
  
   String dev_tool="";

    Connection con = null;
	try{
		con					      = ConnectionManager.getConnection(request);
	
	if(mode.equals("function")){
	
	try
	{
		String function_id="";
		String function_name="";	
		String sql="";

		//StringBuffer menuoptsql= new StringBuffer();
		//String menu_id_opt		=	"";
		//String short_desc_opt	=	"";
		//String str1				= "";
		//String deft_menu_id				= "";
		//String deft_menu_name				= "";

		
		//con=ConnectionManager.getConnection(request);
		Statement stmt = con.createStatement();
		ResultSet rs;
		PreparedStatement pstmt = null; 
	
		sql ="select function_id, function_name from Sm_Function where module_id=?  and desktop_appl_yn='Y'  order by  function_name";
		pstmt=con.prepareStatement(sql); 
		pstmt.setString(1,module_id); // COMMON-ICN-0184
    	//rs = stmt.executeQuery(sql);
    
    	rs = pstmt.executeQuery();

		while(rs.next())
		{
			function_id=rs.getString("function_id");
			function_name=rs.getString("function_name");
			%>	
				<script>
				var temp = "<%=function_id%>";
				var temp1="<%=function_name%>";
				//var opt=parent.f_query_add_mod.frameAddModifyCreateUserDesktop.document.createElement("OPTION");
				var opt = parent.f_query_add_mod.construct_ca_menu.document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				//parent.f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.Function_id.add(opt);
				parent.f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Function_id.add(opt);
				
			 	
			  </script>
				
			<%	
				}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			
				
/*

			sql="Select menu_id,menu_name,root_menu_yn, dev_tool from sm_menu_hdr where  root_menu_yn='Y' and menu_id ='"+menu_id+"'";
				
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					while(rs.next()){
					dev_tool=rs.getString("dev_tool");
						*/
						
			%>	
				<script>
			/*	var temp = "<%=dev_tool%>";
				if(temp=="F")
				{
				parent.f_query_add_mod.document.forms[0].dektop_id_desc.disabled=true;
				parent.f_query_add_mod.document.forms[0].dektop_id_desc1.disabled=true;
			    }
					
				if(temp=="J")
				{
				parent.f_query_add_mod.document.forms[0].dektop_id_desc.disabled=false;
				parent.f_query_add_mod.document.forms[0].dektop_id_desc1.disabled=false;
			    }
			*/	
			  </script>
				
			<%	
				//}
				%>


		
			<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		
		<%
				
	//	if (stmt != null) stmt.close();
		//if (rs != null) rs.close();
				



		out.println("<!DOCTYPE html><html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
	}
	catch(Exception e) 
	{ 
		out.println("Exception in GetUserDesktopValue.jsp mode = function ..."+e.toString());
		
		e.printStackTrace(System.err);
	}
	finally
	{
		//if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	}
	else if(mode.equals("summary"))
	{

		StringBuffer menuoptsql= new StringBuffer();
		String menu_id_opt		=	"";
		String short_desc_opt	=	"";
		String str1				= "";
		String appl_scope = request.getParameter("appl_scope");

		String deft_menu_id				= "";
		String deft_menu_name				= "";

		
		
	 try{
			
		//con=ConnectionManager.getConnection(request);
		ResultSet rs;
		PreparedStatement stmt2 = null; 


		stmt2=con.prepareStatement("select DESKTOP_SUMMARY_ID,DESKTOP_SUMMARY_NAME from SM_DESKTOP_SUM_HDR where SYS_USER_DEF_IND ='S' AND DESKTOP_SUMMARY_TYPE=? ");
			
			stmt2.setString(1,appl_scope);
			rs=stmt2.executeQuery();
		 while(rs.next())
			{		 
				deft_menu_id=rs.getString("DESKTOP_SUMMARY_ID");
			    deft_menu_name=rs.getString("DESKTOP_SUMMARY_NAME");
			   
			
			
			%>
			
				<script>
						 temp = "<%=deft_menu_id%>";
						 temp1="<%=deft_menu_name%>";
						var opt= parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.Menu.add(opt);
			 	
				 </script>
						
			<% 
			}
			if(stmt2 != null) stmt2.close();
			if(rs != null) rs.close();
		
		
		menuoptsql.append("SELECT SUMMARY_COMP_ID menu_id,SUMMARY_COMP_DESC short_desc FROM SM_DESKTOP_SUM_COMP WHERE SUMMARY_COMP_TYPE	='T' AND APPLICABLITY_SCOPE=? ");
		
		stmt2= con.prepareStatement(menuoptsql.toString());
		stmt2.setString(1,appl_scope);
		rs=stmt2.executeQuery();
			
				str1="#1#M";  
				
				while(rs.next())
				{ 
					menu_id_opt		=	rs.getString("menu_id");
					short_desc_opt	=	rs.getString("short_desc");

					if(menu_id_opt == null)		menu_id_opt="";
					if(short_desc_opt == null)	short_desc_opt="";

					
					%>	
				<script>
						 temp = "<%=menu_id_opt%>"+"<%=str1%>";
						 temp1="<%=short_desc_opt%>";
						var opt= parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.Menuopts.add(opt);
			 	
				 </script>
				
			<%	

				//out.println("<option value='"+menu_id_opt+str1+"'>"+short_desc_opt+"</option>");
				}
				if (stmt2 != null) stmt2.close();
				if (rs != null) rs.close();
				
				menuoptsql.delete(0,menuoptsql.length());

			menuoptsql.append("SELECT SUMMARY_COMP_ID menu_id,SUMMARY_COMP_DESC short_desc FROM SM_DESKTOP_SUM_COMP WHERE SUMMARY_COMP_TYPE	='S' AND APPLICABLITY_SCOPE=? ");
		
		stmt2= con.prepareStatement(menuoptsql.toString());
		stmt2.setString(1,appl_scope);
		rs=stmt2.executeQuery();
			
				str1="#2#F";  
				
				while(rs.next())
				{ 
					menu_id_opt		=	rs.getString("menu_id");
					short_desc_opt	=	rs.getString("short_desc");

					if(menu_id_opt == null)		menu_id_opt="";
					if(short_desc_opt == null)	short_desc_opt="";
					
					%>	
				<script>
						 temp = "<%=menu_id_opt%>"+"<%=str1%>";
						 temp1="<%=short_desc_opt%>";
						var opt= parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.funcopt.add(opt);
			 	
				 </script>
				
			<%	

				//out.println("<option value='"+menu_id_opt+str1+"'>"+short_desc_opt+"</option>");
				}
				if (stmt2 != null) stmt2.close();
				if (rs != null) rs.close();






		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		//if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	}
	else if(mode.equals("CA_summary"))
	{
       // StringBuffer menuoptsql= new StringBuffer();
		String option_id="";
		String long_desc="";
		//String str1				= "";
				
	 try{
			
		//con=ConnectionManager.getConnection(request);
		ResultSet rs;
		PreparedStatement stmt2 = null; 


		stmt2=con.prepareStatement("select OPTION_ID,long_desc from ca_option where DESKTOP_YN='Y' AND OPTION_TYPE='F' and OPEN_IN_MODAL_WINDOW_YN='N' order by 2");
						
			rs=stmt2.executeQuery();
		 while(rs.next())
			{		 
				option_id=rs.getString("OPTION_ID");
			    long_desc=rs.getString("long_desc");
			 		
			%>
			
				<script>
						 temp = "<%=option_id%>";
						 temp1="<%=long_desc%>";
						var opt= parent.f_query_add_mod.construct_ca_menu.document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Function_id.add(opt);
			 	
				 </script>
						
			<% 
			}
			if(stmt2 != null) stmt2.close();
			if(rs != null) rs.close();

			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
	 }catch(Exception e) { 
		 out.println(e.toString());
		 e.printStackTrace();
		 }
	finally
	{
		//if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	}
	else if(mode.equals("PHIS_SUMMARY"))
	{
		String option_id="";
		String long_desc="";
	 try{
		ResultSet rs;
		PreparedStatement stmt2 = null; 

		stmt2=con.prepareStatement("select SUMMARY_COMP_ID,SUMMARY_COMP_DESC from SM_DESKTOP_SUM_COMP where SUMMARY_COMP_TYPE='S' and APPLICABLE_MODULE_ID = ? order by 2");
		stmt2.setString(1,module_id);				
		rs=stmt2.executeQuery();
		while(rs.next())
			{		 
				option_id=rs.getString("SUMMARY_COMP_ID");
			    long_desc=rs.getString("SUMMARY_COMP_DESC");
			 		
			%>			
				<script>
						var opt= parent.f_query_add_mod.construct_ca_menu.document.createElement("OPTION");
						opt.text="<%=long_desc%>";
						opt.value="<%=option_id%>";
						parent.f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Function_id.add(opt);			 	
				</script>
						
			<% 
			}
			if(stmt2 != null) stmt2.close();
			if(rs != null) rs.close();

			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
	 }catch(Exception e) { 
		 out.println(e.toString());
		 e.printStackTrace();
		 }
	}
	else
{ %>
        	<script>
		           parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0";
			 </script>

<%	
}
	}
	catch(Exception e){
		e.toString();
		e.printStackTrace();
		}
	finally {
		           ConnectionManager.returnConnection(con,request);  
		    }
%>

