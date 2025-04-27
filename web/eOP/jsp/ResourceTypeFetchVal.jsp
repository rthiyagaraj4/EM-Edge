<!DOCTYPE html>

<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>	
<%
        request.setCharacterEncoding("UTF-8");
		String sql1=null;
       	String sql4=null;
		Connection con = null;
		Statement stmt =null;
		ResultSet rset=null;
		
		try{

			con=ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			
			String code1="";
			String desc="";
			String desc1="";
			String name=request.getParameter("visit_type_ind");
			String value=request.getParameter("value");
			String facility_id=request.getParameter("facility_id");
			String sql3=null;
			String func=request.getParameter("function");
			String comp=" ";		
			String comp2="";
			String code2="";
			
		%>
          <html><HEAD>
		<!-- 	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


				</HEAD>
		<body CLASS='MESSAGE' onKeyDown = 'lockKey();'><form name='nam1' id='nam1'>
         
		  <%
		if(name!=null)
			name=name.trim();
		if(func.equals("Insert"))
			{
			
		if(name.equals("indicator"))
	      	 {
			sql1="select distinct short_desc,visit_type_code from op_visit_type where visit_type_ind='"+value+"' and facility_id='"+facility_id+"' and eff_status='E' ";
			if(sql1!=null)
			     rset=stmt.executeQuery(sql1);
		  comp="parent.f_query_add_mod.document.forms[0].visittype";
		  while(rset.next()) 
			{
				desc=rset.getString(1);
				code1=rset.getString(2);
			%>
			<script>
				var temp="<%=desc%>";
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=temp;
				opt.value="<%=code1%>";
				var comp=<%=comp%>
				comp.add(opt)
         	</script>	  
		<%
		} 
		   
		  if(rset != null) rset.close();
	      
		 }   // If closed here (Indicator)
			if(name.equals("visittype"))
				{
			     
			   String status="Y";
			   sql4="select resource_srl_no from op_resource_type_for_appt where visit_type_code='"+value+"'";
			   	
				if(sql4!=null)
				   rset=stmt.executeQuery(sql4);
				if(!rset.next()&&!value.equals(""))
					{
					status="X";
                    if(status=="X"){
					%>
                <script>
				 parent.f_query_add_mod.document.forms[0].Gifstatus.value="E";
				 parent.f_query_add_mod.document.getElementById("resourcetype").style.display="";
			 	</script>
                     <%
					}//if closed here
					}
					else
						{
					%>
                    <script>
					 parent.f_query_add_mod.document.forms[0].Gifstatus.value="";
				     parent.f_query_add_mod.document.getElementById("resourcetype").style.display="";
			 	</script>
                     <%	  
						} 
						
			 if(rset != null) rset.close();
			}
            comp2="parent.f_query_add_mod.document.forms[0].resourcetype";
		  if(name.equals("resourceclass"))
				{ 
			      if(!value.equals(""))
					{  
				  if(value.equals("P"))
					    sql3="select desc_userdef,pract_type from am_pract_type where eff_status='E'  order by desc_userdef";
					else if(value.equals("R"))
					   sql3="select short_desc,locn_type from am_care_locn_type where care_locn_type_ind='R' order by long_desc";
				   else if(value.equals("E"))
						sql3="select short_desc,resource_type from am_resource_type where eff_status='E' and resource_class='E' order by long_desc";
				    else if(value.equals("O"))
						sql3="select short_desc,resource_type from am_resource_type where eff_status='E' and resource_class='O' order by long_desc";
				 
				  rset=stmt.executeQuery(sql3);
				
				 while(rset.next())
				  {
				     desc1=rset.getString(1);
					 code2=rset.getString(2);
				 %>
			      <script>
				    var opt=parent.f_query_add_mod.document.createElement("OPTION");
				    opt.text="<%=desc1%>";
				    opt.value="<%=code2%>";
				    var comp2=<%=comp2%>
				    comp2.add(opt)
			     </script>   
					<%
				  }//while close
					}
				}//if closed here	
				      
		if(rset != null) rset.close();
		
		if(stmt != null) stmt.close();
		}//Insert If closed
}catch(Exception e) { out.println(e.toString());}
		finally
	       {
			try{
				if(rset != null ) rset.close();
				if(stmt != null) stmt.close();
			}catch(Exception e){}
			if(con!=null) ConnectionManager.returnConnection(con,request);			
	       }
	%>	
     </form></body></html>

