<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%String sStyle	=
            (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>



<%												   
			Connection con=null;
			con = ConnectionManager.getConnection(request);
			Hashtable hash = (Hashtable)obj.parseXMLString( request );
		 	hash = (Hashtable)hash.get("SEARCH") ;
            request.setCharacterEncoding("UTF-8");
			java.sql.Statement stmt= con.createStatement();
			ResultSet rset=null;
			String mode = (String) hash.get("mode") ;
			if(mode == null) mode=""; 
			String date_value = (String) hash.get("date_value") ;			
			if(date_value == null) date_value="";

			String converted_date="";

		try{

			if(mode.trim().equals("1")){
		    	String sql = "select to_char(TO_DATE('"+date_value+"','DD/MM/YYYY'),'DD/MM/YYYY','NLS_CALENDAR=''Arabic Hijrah''')   converted_date from dual ";
				

				rset = stmt.executeQuery(sql);		
				if(rset != null && rset.next()) {

					converted_date=rset.getString("converted_date");
				  
				
					%> 					
						if(document.getElementById("date_of_birth_hj")!=null)document.getElementById("date_of_birth_hj").value='<%=converted_date%>';
					<%
				}
			
			
			}

		}catch(Exception e){
			out.println(e);
			e.printStackTrace();
			}
		finally { 
			ConnectionManager.returnConnection(con,request);
			hash.clear();
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
		}
%>
