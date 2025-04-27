<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* "  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head></head>

<% 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	ResultSet rs1 = null;
	PreparedStatement pstmt1 = null;
	StringBuffer menuidsql =new StringBuffer();
	String funoptsql = "";
	String desktop_yn ="";
	String fun_opt_id="";
	String short_desc_fun_opt="";
	String str="#2#F";
	String menu_id = "";
	String short_desc = "";
	desktop_yn = (request.getParameter("desktop_hdn")==null)?"":request.getParameter("desktop_hdn");


	// this check is to ppulate the function options depending upon the desktop_yn

	if(desktop_yn.equals("Y"))
	{
		
		funoptsql = "select option_id, nvl(user_def_short_desc,short_desc) short_desc from ca_option where option_type='F'and NVL(DESKTOP_YN,'N') = 'Y' order by 2";

	}
	else
	{
		funoptsql = "select option_id, nvl(user_def_short_desc,short_desc)||'('||HIST_OR_RECORD||')' short_desc from ca_option where option_type='F'and (nvl(APPL_OP_YN,'N')= 'Y' OR nvl(APPL_IP_YN,'N')= 'Y' OR nvl(APPL_EM_YN,'N')= 'Y' OR nvl(APPL_DC_YN,'N')= 'Y') order by 2";
	}


	menuidsql.append("select menu_id, short_desc from ca_menu_header where root_menu_yn='Y' and eff_status='E' and NVL(SYSTEM_DEFINED_YN,'N')='N' ");

	if(desktop_yn.equals("Y"))
	{
		menuidsql.append(" and desktop_yn='Y'");
	}
	else 
	{
		menuidsql.append(" and patient_chart_yn='Y'");
	}

	menuidsql.append(" order by short_desc");

	try
	{
		con = ConnectionManager.getConnection(request);
		
		pstmt1 = con.prepareStatement(funoptsql);
		rs1 = pstmt1.executeQuery();

		
		out.println("<script>");

		while(rs1.next())
		{
			fun_opt_id=rs1.getString("option_id");
			short_desc_fun_opt=rs1.getString("short_desc");
			
			if(fun_opt_id == null)
				fun_opt_id="";
			if(short_desc_fun_opt == null)
				short_desc_fun_opt="";
			
			out.println("var opt = parent.frames[1].document.createElement('OPTION');");
			out.println("opt.text = '"+short_desc_fun_opt+"';");
			out.println("opt.value ='"+fun_opt_id+str+"';");
			out.println("parent.frames[1].document.forms[0].funcopt.add(opt);");	
		}
		out.println("</script>");
			
		pstmt = con.prepareStatement(menuidsql.toString());
		rs = pstmt.executeQuery();

		out.println("<script>");

	
		while(rs.next())
		{
			menu_id = rs.getString("menu_id");
			if(menu_id == null){
					menu_id = "";}

			short_desc = rs.getString("short_desc");
			if(short_desc == null)
				short_desc = "";

			out.println("var opt = parent.frames[1].document.createElement('OPTION');");
			out.println("opt.text = '"+short_desc+"';");
			out.println("opt.value ='"+menu_id+"';");
			out.println("parent.frames[1].document.forms[0].Menu.add(opt);");	
		}
	out.println("</script>");

%>

	<script>
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
	</script>
<%
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();

}
catch(Exception ex)
{
	//out.println("Exception "+ex);//COMMON-ICN-0181
	ex.printStackTrace() ;
}
finally
{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</html>
