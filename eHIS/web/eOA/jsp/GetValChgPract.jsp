<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*" %>
  <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
     <script language='javascript' src='../../eOA/js/ChangePractitionerforGenSch.js'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
   <script language='javascript' src='../../eCommon/js/common.js'></script>


   </head>
  <body class='MESSAGE' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
  <form name='temporary' id='temporary'>
  <%

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs=null;
	PreparedStatement pstmt=null;
    Statement stmt1=null;
    ResultSet rs1=null;
    Statement stmt2=null;
    ResultSet rs2=null;
	%>
		<script>  
		parent.f_query_add_mod.f_search.document.ChangePract_form.pract_to.value="";
		</script>
		<%

     try {
		 request.setCharacterEncoding("UTF-8");
		 conn = ConnectionManager.getConnection(request);
          String locn= request.getParameter("locn");
          String facility_id = request.getParameter("facility_id");
          String L_clinic_code="";

   	  StringTokenizer st = new StringTokenizer(locn,"|");
   	  while (st.hasMoreTokens()) {
   	       L_clinic_code=st.nextToken();
   	     st.nextToken();
   	      st.nextToken();
   	  }
   	  stmt = conn.createStatement();
      String sql2="";
      String day_of_week="";
      String day_text="";
      	//sql2="select distinct a.day_no,INITCAP(b.day_of_week) day_of_week from oa_clinic_time_table a, sm_day_of_week b ";
      	//sql2=sql2 + "where a.day_no = b.day_no and a.clinic_code='" + L_clinic_code + "' and a.facility_id='" + facility_id+"' order by 1";
		sql2="select distinct a.day_no,INITCAP(b.day_of_week) day_of_week from oa_clinic_time_table a, sm_day_of_week b where a.day_no = b.day_no and a.clinic_code=? and a.facility_id=? order by 1";
       //	stmt1 = conn.createStatement();
       // rs1 = stmt1.executeQuery(sql2);
		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1,L_clinic_code);
		pstmt.setString(2,facility_id);
		rs1 = pstmt.executeQuery();
     %>

        <script language='javascript'>
          clear_select();
        </script>

     <%	 if (rs1.next() ) {

	   do {
	         day_of_week = rs1.getString("day_of_week");
	         day_text = day_of_week.toUpperCase();

			if(day_of_week.equals("Monday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(day_of_week.equals("Tuesday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(day_of_week.equals("Wednesday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(day_of_week.equals("Thursday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(day_of_week.equals("Friday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(day_of_week.equals("Saturday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(day_of_week.equals("Sunday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}


      %>
        <script language='javascript'>
          var opt;
          opt = parent.f_query_add_mod.f_search.document.createElement("OPTION");
          opt.text = '<%= day_of_week %>';
          opt.value= '<%= day_text %>';       
          parent.f_query_add_mod.f_search.document.ChangePract_form.day.add(opt);
        </script>
      <%

	   } while(rs1.next());
	}
	else {
      %>
        <script>
        </script>

      <%
      	  return;
      	}

	  if (rs != null) rs.close();
   	  if (rs1 != null) rs1.close();
   	  if (rs2 != null) rs2.close();
	  if (stmt != null) stmt.close();
   	  if (stmt1 != null) stmt1.close();
   	  if (stmt2 != null) stmt2.close();

    } catch (Exception e) { 
//out.println( e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
   	finally {
	  ConnectionManager.returnConnection(conn,request);
   	}
    %>
   </form>
  </body>

