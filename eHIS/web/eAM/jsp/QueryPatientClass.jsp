<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<body class=MESSAGE onKeyDown = 'lockKey()'>
<%
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		//String sql="";
		out.println("<script>");
		try
		{
			request.setCharacterEncoding("UTF-8");	
			con = ConnectionManager.getConnection(request);
			String patienttype = request.getParameter("patient_type");
			pstmt = con.prepareStatement("select patient_class,short_desc from am_patient_class where patient_class not in (select patient_class from am_patient_type_class where patient_type = '" + patienttype + "') order by short_desc");
            rs = pstmt.executeQuery();
            String code = "";
            String desc = "";
            if(rs != null)
            {
				for(; rs.next(); out.println("var element = parent.f_query_add_mod.document.createElement('OPTION');element.text = '" + desc + "';" + "element.value= '" + code + "';" + "parent.f_query_add_mod.document.pattypeclass_form.available_patient_class.add(element);"))
                {
                    desc = rs.getString("short_desc");
                    code = rs.getString("patient_class");
                }

            }
			if(rs!=null) 	rs.close();
	        if(pstmt!=null) pstmt.close();
			code = ""; 
			desc = "";  

            pstmt = con.prepareStatement("select patient_class,short_desc from am_patient_class where patient_class in (select patient_class from am_patient_type_class where patient_type = '" + patienttype + "') order by short_desc");
            rs = pstmt.executeQuery();
            if(rs != null)
            {
                for(; rs.next(); out.println("var element = parent.f_query_add_mod.document.createElement('OPTION');element.text = '" + desc + "';" + "element.value= '" + code + "';" + "parent.f_query_add_mod.document.pattypeclass_form.selected_patient_class.add(element);"))
                {
                    desc = rs.getString("short_desc");
                    code = rs.getString("patient_class");
                }

            }
           if(rs!=null) 	rs.close();
	       if(pstmt!=null) pstmt.close();
			out.println("</script>");
		}catch(Exception e){
			out.println(e);
		}
		finally {
			  if (rs != null)   rs.close();
			  if (pstmt != null) pstmt.close();
			  ConnectionManager.returnConnection(con,request);
		}
%>
</body>
</html>

