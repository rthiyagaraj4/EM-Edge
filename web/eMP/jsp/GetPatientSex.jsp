<!--,op.CurrencyFormat.*-->
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<Script src="../../eMP/js/PatientSearch.js" language="JavaScript"></Script>


<%
	Connection con = null;
	ResultSet rs =null ;
	ResultSet rs1 =null ;
	String mother_min_age = "";
	String patient_id = request.getParameter("PATIENT_ID");
	if (patient_id==null) patient_id = "";
	
	patient_id = java.net.URLDecoder.decode(patient_id);		
	Statement stmt = null;
	PreparedStatement pstmt = null;

	try{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs = stmt.executeQuery("select NB_MOTHER_MIN_AGE from mp_param");
		if (rs.next())
		{
			mother_min_age = rs.getString(1);
			if (mother_min_age == null) mother_min_age = "";
		}
	}
	catch (Exception e)
	{
		out.println("Exception "+e);
	}	
	try 
	{
		pstmt = con.prepareStatement("select sex, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'), 1) from mp_patient where patient_id = ?");
		pstmt.setString(1, patient_id);

		rs1=pstmt.executeQuery();

		if(rs1.next())
		{			
			out.println("<script>parent.frames[3].frames[0].document.result_form.sex.value='"+rs1.getString(1)+"';</script>");			
			out.println("<script>parent.frames[3].frames[0].document.result_form.age.value='"+rs1.getString(2)+"';</script>");
			out.println("<script>parent.frames[3].frames[0].document.result_form.min_age.value='"+mother_min_age+"';</script>");
			out.println("<script>buildTableOptions(\""+patient_id+"\");</script>");
		}
	}
	catch (Exception e)
	{
		out.println("Exception "+e);
	}
	finally
	{ 
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if (stmt!=null) stmt.close();
		if (pstmt!=null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

