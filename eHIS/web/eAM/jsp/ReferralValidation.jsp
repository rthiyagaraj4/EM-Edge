<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script src='../../eCommon/js/common.js' language='javascript'></script>
<html>
<body class='message' onKeyDown = 'lockKey()'>  
<% 
Connection con = null;
ResultSet rs=null;
PreparedStatement stmt2=null;
PreparedStatement stmt=null;
ResultSet rs2=null;
 String locale			= (String)session.getAttribute("LOCALE");

 String pr_id = checkForNull(request.getParameter("process_id"));


  int process = Integer.parseInt(pr_id);

  
 //Below Added for checkstyle
  try{
	  con = ConnectionManager.getConnection(request);
// FOR POPULATING THE town list WHEN area list HAS BEEN SELECTED...........
    if(process == 7)
    {
		String postal_code = request.getParameter("postal_code");
		if(postal_code == null) postal_code = "";  	

		String res_area_code = request.getParameter("res_area_code");
		if(res_area_code==null) res_area_code ="";
		
		String region_code = request.getParameter("region_code");
		if(region_code==null) region_code =""; 

		String prev_region = request.getParameter("prev_region");
		if(prev_region==null) prev_region ="";       
		
		String res_town_code = request.getParameter("res_town_code");
		if (res_town_code==null) res_town_code ="";

		
		String fieldName ="";
		String fieldName1 ="";
		String fieldName2 ="";
		String fieldName3 ="";
		String fieldName4 ="";
		String fieldName5 ="";
        String mode = request.getParameter("mode") ;
		if (mode==null) mode="";
        String sql = "";
		
		if(mode.equals("first_postal_code"))
		{
			fieldName = "contact2_res_town_code";
			fieldName1 = "contact2_res_area_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
			fieldName5 = "f_town";
		}
		else if(mode.equals("next_postal_code"))
		{
			fieldName = "contact1_res_town_code";
			fieldName1 = "contact1_res_area_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
			fieldName5 = "n_town";
		}
		else if(mode.equals("employ_postal_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "contact3_res_area_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
			fieldName5 = "e_town";
		}
		else if(mode.equals("r_postal_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_area_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
			fieldName5 = "r_town";
		}
		else if(mode.equals("m_postal_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_area_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
			fieldName5 = "m_town";
		}
		else if(mode.equals("contact1_res_town_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
		}
		else if(mode.equals("contact2_res_town_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
		}
		else if(mode.equals("contact3_res_town_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
		}
		else if(mode.equals("m_town_code")){
			
			fieldName = "m_area_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
		}
		else if(mode.equals("r_town_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
		}
		else if(mode.equals("contact1_res_area_code")){
			fieldName = "contact1_res_town_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_town";
		}
		else if(mode.equals("contact2_res_area_code")){
			fieldName = "contact2_res_town_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_town";
		}
		else if(mode.equals("contact3_res_area_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_town";
		}
		else if(mode.equals("r_area_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_town";
		}
		else if(mode.equals("m_area_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_town";
		}
		else if(mode.equals("contact1_region_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "contact1_res_town_code";
			fieldName2 = "next_postal_code";
			fieldName3 = "n_area";
			fieldName4 = "n_town";
		}
		else if(mode.equals("contact2_region_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "contact2_res_town_code";
			fieldName2 = "first_postal_code";
			fieldName3 = "f_area";
			fieldName4 = "f_town";
		}
		else if(mode.equals("contact3_region_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "contact3_res_town_code";
			fieldName2 = "employ_postal_code";
			fieldName3 = "e_area";
			fieldName4 = "e_town";
		}
		else if(mode.equals("r_region_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_town_code";
			fieldName2 = "r_postal_code";
			fieldName3 = "r_area";
			fieldName4 = "r_town";
		}
		else if(mode.equals("m_region_code")){
			fieldName = "m_area_code";
			fieldName1 = "m_town_code";
			fieldName2 = "m_postal_code";
			fieldName3 = "m_area";
			fieldName4 = "m_town";
		}

 

        if (!postal_code.equals(""))
		{
            
			String town_code="";
			sql = "select a.res_town_code, b.long_desc res_town_desc from mp_postal_code_lang_vw a, mp_res_town_lang_vw b where a.language_id='"+locale+"' and a.postal_code = '"+postal_code+"' and a.res_town_code = b.res_town_code and a.language_id=b.language_id";
             stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			if (rs.next())
			{

				town_code = rs.getString(2);
                if (town_code==null) town_code="";
				out.println("<script>if (parent.frames[1].document.all."+fieldName+" !=null) parent.frames[1].document.all."+fieldName+".value=\""+town_code+"\";");
				out.println("parent.frames[1].document.all."+fieldName5+".value=\""+(rs.getString("res_town_code")==null ? "" : rs.getString("res_town_code"))+"\";</script>");

				sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+rs.getString(1)+"') and a.region_code = b.region_code and a.language_id=b.language_id" ;
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();

				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if (rs.next())
				{
					out.println("<script>if (parent.frames[1].document.all."+fieldName1+" != null) parent.frames[1].document.all."+fieldName1+".value=\""+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"\";");
					out.println("if (parent.frames[1].document.all."+fieldName2+" !=null) parent.frames[1].document.all."+fieldName2+".value=\""+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"\";");
				 	out.println("parent.frames[1].document.all."+fieldName4+".value=\""+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"\";");
				 	out.println("parent.frames[1].document.all."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";</script>");
				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		if(!res_town_code.equals(""))
		{
			
			sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+res_town_code+"') and a.region_code = b.region_code and a.language_id=b.language_id";
			
		
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{

				 out.println("<script> if(parent.frames[1].document.all."+fieldName+" != null) parent.frames[1].document.all."+fieldName+".value=\""+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"\";");
				 
				 out.println("if (parent.frames[1].document.all."+fieldName2+" !=null) parent.frames[1].document.all."+fieldName2+".value=\""+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"\";");
				 out.println("parent.frames[1].document.all."+fieldName4+".value=\""+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"\";");
				 out.println("parent.frames[1].document.all."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";");
			}	
			out.println("if (parent.frames[1].document.all."+fieldName1+" !=null) {parent.frames[1].document.all."+fieldName1+".value=''} </script>");

			//sql="select postal_code from mp_postal_code where res_town_code = '"+res_town_code+"'";
			sql="select postal_code,short_desc from mp_postal_code_lang_vw where res_town_code = '"+res_town_code+"' and language_id='"+locale+"'";

		

			stmt2 = con.prepareStatement(sql);
			rs2 = stmt2.executeQuery();
			if(rs2.next())
			{
				out.println("<script>if (parent.frames[1].document.all."+fieldName1+" !=null) {parent.frames[1].document.all."+fieldName1+".value = \""+(rs2.getString("postal_code")==null ? "" : rs2.getString("postal_code"))+"\"}");

				out.println("if (parent.frames[1].document.all."+fieldName1+"1 !=null) {parent.frames[1].document.all."+fieldName1+"1.value = \""+(rs2.getString("short_desc")==null ? "" : rs2.getString("short_desc"))+"\"}</script>");
				
			}
			/*	if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code"))
			{
			out.println("<script>if(parent.frames[1].document.all."+fieldName1+"1)parent.frames[1].document.all."+fieldName1+"1.focus();</script>");
			}
			else
			{
			out.println("<script>if(parent.frames[1].document.all."+fieldName1+")parent.frames[1].document.all."+fieldName1+".focus();</script>");
			}*/
			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
			if(rs2!=null) rs2.close();
			if(stmt2 != null) stmt2.close();
		}
		if(!res_area_code.equals(""))
		{
			sql = "select region_code,long_desc from mp_region_lang_vw where language_id='"+locale+"' and region_code = (select region_code from mp_res_area where res_area_code ='"+res_area_code+"')";
			
	
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				out.println("<script>if (parent.frames[1].document.all."+fieldName1+" !=null) parent.frames[1].document.all."+fieldName1+".value='';");
				out.println("if (parent.frames[1].document.all."+fieldName2+" !=null) parent.frames[1].document.all."+fieldName2+".value=\""+(rs.getString("long_desc")==null ? "" : rs.getString("long_desc"))+"\";");
				out.println(" parent.frames[1].document.all."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";</script>");
			}
			else
			{
				out.println("<script> if(parent.frames[1].document.all."+fieldName+") parent.frames[1].document.all."+fieldName+".value='';");
				out.println("if (parent.frames[1].document.all."+fieldName1+") parent.frames[1].document.all."+fieldName1+".value='';");
				out.println("if (parent.frames[1].document.all."+fieldName2+" ) parent.frames[1].document.all."+fieldName2+".value='';");
				out.println("parent.frames[1].document.all."+fieldName3+".value='';");
				out.println("parent.frames[1].document.all."+fieldName4+".value='';</script>");
			}
		/*	out.println("<script>if(parent.frames[1].document.all."+fieldName1+")</script>");
			if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code"))
			{
			out.println("<script>if (parent.frames[1].document.all."+fieldName2+"1){parent.frames[1].document.all."+fieldName1+"1.focus();}</script>");
			}
			else
			{
			out.println("<script>parent.frames[1].document.all."+fieldName1+".focus();</script>");
			}*/

			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
		}

			
      	if(!region_code.equals("") && !prev_region.equals("") && !region_code.equals(prev_region))
		{			         
			 out.println("<script>if(parent.frames[1].document.all."+fieldName+" )");			
			 out.println("parent.frames[1].document.all."+fieldName+".value='';");
			 out.println("if(parent.frames[1].document.all."+fieldName2+") parent.frames[1].document.all."+fieldName2+".value='';");
			 out.println("if (parent.frames[1].document.all."+fieldName1+") parent.frames[1].document.all."+fieldName1+".value='';");
			 out.println("parent.frames[1].document.all."+fieldName3+".value='';");
			 out.println("parent.frames[1].document.all."+fieldName4+".value='';</script>");

				
			/*
			if(fieldName2.equals("next_postal_code") || fieldName2.equals("first_postal_code") || fieldName2.equals("employ_postal_code") || fieldName2.equals("m_postal_code") || fieldName2.equals("r_postal_code"))
			{
			out.println("<script>if (parent.frames[1].document.all."+fieldName2+"1) {parent.frames[1].document.all."+fieldName2+"1.focus();}  </script>");
			}
			else
			{
				out.println("<script>parent.frames[1].document.all."+fieldName2+".focus();</script>");
			}
			*/
		}
    }
	//Below Added for checkstyle
  }
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(con!=null) ConnectionManager.returnConnection(con, request); 
	}
	//Ended for checkstyle
%>
</body>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>
</html> 

