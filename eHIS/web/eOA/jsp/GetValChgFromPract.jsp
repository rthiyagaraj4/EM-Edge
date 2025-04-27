<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*" %>
  <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script language='javascript' src='../../eCommon/js/common.js'></script>

  </head>
  <body class='MESSAGE' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
  <form name='temporary1' id='temporary1'>
  <% 
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs=null; 
    PreparedStatement pstmt=null;
request.setCharacterEncoding("UTF-8");  
     try {
     	  conn =ConnectionManager.getConnection(request);
          String pract_id= request.getParameter("pract_id");
          String facility_id = request.getParameter("facility_id");
          String loc= request.getParameter("loc");
	     String locale=(String)session.getAttribute("LOCALE");

	  String L_clinic_code="";
	  String L_open_to_all_pract_yn="";
	String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");	          
	  StringTokenizer st = new StringTokenizer(loc,"|");
	  while (st.hasMoreTokens()) {
	        L_clinic_code=st.nextToken();
	       st.nextToken();
	        L_open_to_all_pract_yn=st.nextToken(); 
   	  } 

   	  String sql="";
   	  String practitioner_name="";
   	  String practitioner_id="";
           	  
   	  stmt = conn.createStatement(); 
   	  if (L_open_to_all_pract_yn == "Y") {
   	   //  sql="select AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name,practitioner_id, from am_pract_for_facility_vw ";
   	     sql="select AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1') practitioner_name,practitioner_id, from am_pract_for_facility_vw ";
   	     //sql=sql+"where eff_status='E' and facility_id='"+facility_id+"' and practitioner_id != '"+pract_id+"' order by 1";
   	     sql=sql+"where eff_status='E' and facility_id=? and practitioner_id != ? order by 1";
   	  }   
   	  else {
   	     
      	   //sql="Select a.practitioner_id, b.short_name practitioner_name from am_pract_for_facility a,  am_practitioner_lang_vw b , op_clinic c  where b.practitioner_id = a.practitioner_id and language_id = '"+locale+"' and a.eff_status = 'E' and a.facility_id = '"+facility_id+"'and c.facility_id = a.facility_id and c.clinic_code = '"+L_clinic_code+"'  and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facility_id+"' and practitioner_id = b.practitioner_id )) and nvl(c.pract_type, b.pract_type) = b.pract_type and a.practitioner_id != '"+pract_id+"' order by 2";
      	   sql="Select a.practitioner_id, b.short_name practitioner_name from am_pract_for_facility a,  am_practitioner_lang_vw b , op_clinic c  where b.practitioner_id = a.practitioner_id and language_id = ? and a.eff_status = 'E' and a.facility_id = ? and c.facility_id = a.facility_id and c.clinic_code = ?  and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = ? and practitioner_id = b.practitioner_id )) and nvl(c.pract_type, b.pract_type) = b.pract_type and a.practitioner_id != ? order by 2";
  	     
   	  }
   	 // rs = stmt.executeQuery(sql);
	   pstmt = conn.prepareStatement(sql);
		 if (L_open_to_all_pract_yn == "Y") {
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,pract_id);
		}   
   	  else {
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,L_clinic_code);
		pstmt.setString(4,facility_id);
		pstmt.setString(5,pract_id);
	}
		rs = pstmt.executeQuery();
     %>
        
        <script language='javascript'>
             var opt1;
	     opt1 = parent.f_query_add_mod.f_search.document.createElement("OPTION");
	     opt1.text = ' ---------<%=default_select%>--------- ';
	     opt1.value='';
             parent.f_query_add_mod.f_search.document.ChangePract_form.pract_to.add(opt1);
        </script> 
        
     <%	 if (rs.next() ) {

	   do { 
	         practitioner_name = rs.getString("practitioner_name");
	         practitioner_id = rs.getString("practitioner_id");
      %>
        <script language='javascript'>
          var opt;
          opt = parent.f_query_add_mod.f_search.document.createElement("OPTION");
          opt.text = '<%= practitioner_name %>';
          opt.value='<%= practitioner_id %>';
          parent.f_query_add_mod.f_search.document.ChangePract_form.pract_to.add(opt); 
        </script>  
      <%
	  	  
	   } while(rs.next());
	}
		if (stmt != null) stmt.close(); 
   	  if (rs != null) rs.close();
	} catch (Exception e) {
//out.println( e.toString() );
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
   	finally {
   	  
	  ConnectionManager.returnConnection(conn,request);
   	}
    %>
   </form>
  </body> 

