<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<html>
 <head>
 </head>
	<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
	<%
		request.setCharacterEncoding("UTF-8");
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		int counter=0;
		StringBuffer menutreesql = new StringBuffer();
		String main_menu_id = "";
		String desktop_chart ="";

		String option_desc = "",option_type="",prev_option_desc = "";
		String option_desc1 = "";
		String option_value ="";
		String header_option_id = "";
		String option_tot_value = "";

		//String spc="         ";
		String spc = "\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0";
		String option_text="";
		int level_no = 1;

		desktop_chart = request.getParameter("desktop_chart")==null?"":request.getParameter("desktop_chart");
		main_menu_id = request.getParameter("main_menu_id")==null?"":request.getParameter("main_menu_id");

		if(menutreesql.length() > 0) menutreesql.delete(0,menutreesql.length());
		menutreesql.append("select DISTINCT LEVEL as LVL_NO, ");
		menutreesql.append("a.option_id as option_id,");
		menutreesql.append(" a.option_occurance, ");
		menutreesql.append("a.header_option_id as header_option_id,");
		menutreesql.append("a.HEADER_OPTION_OCCURANCE, a.ORDER_SEQ_NO ");
		menutreesql.append("as ORDER_SEQ_NO, nvl((select ");
		menutreesql.append("nvl(USER_DEF_SHORT_DESC,SHORT_DESC)");
		menutreesql.append("||DECODE(OPTION_TYPE,'F',");
		menutreesql.append("'('||HIST_OR_RECORD||')') from ");
		menutreesql.append("ca_option where option_id=a.option_id)");
		menutreesql.append(",(select SHORT_DESC from ca_menu_header ");
		menutreesql.append("where menu_id=a.option_id)) ");
		menutreesql.append("option_desc,nvl((select option_type ");
		menutreesql.append("from ca_option where option_id = ");
		menutreesql.append("a.option_id),'M') option_type from ");
		menutreesql.append("ca_menu_detail a Where desktop_chart= ? ");
		menutreesql.append("and menu_id= ?  start with menu_id= ? and ");
		menutreesql.append("a.HEADER_OPTION_ID = ? and HEADER_OPTION_OCCURANCE=1 and desktop_chart= ? ");
		menutreesql.append("connect by prior ");
		menutreesql.append("a.OPTION_ID=a.HEADER_OPTION_ID and ");
		menutreesql.append("a.OPTION_OCCURANCE = ");
		menutreesql.append("a.HEADER_OPTION_OCCURANCE order by ");
		menutreesql.append("ORDER_SEQ_No");

		try
		{
		
			con = ConnectionManager.getConnection(request);
		
			pstmt = con.prepareStatement(menutreesql.toString());

			pstmt.setString(1,desktop_chart);
			pstmt.setString(2,main_menu_id);
			pstmt.setString(3,main_menu_id);
			pstmt.setString(4,main_menu_id);
			pstmt.setString(5,desktop_chart);
		
			rs = pstmt.executeQuery();
			
			out.println("<script>");
				
			while(rs.next())
			{
				counter++;

				option_type = rs.getString("option_type");
				if(option_type == null)
					option_type = "";

				option_desc = rs.getString("option_desc");
				
				
				
				
				if(option_desc == null)
					option_desc = "";
				

				
				level_no = rs.getInt("LVL_NO");

				if(option_desc.equals(prev_option_desc) && level_no != 1)
					continue;
				
				prev_option_desc = new String(option_desc);
				
				header_option_id = rs.getString("header_option_id");
				if(header_option_id == null)
					header_option_id = "";

				option_value = rs.getString("option_id");

				if(option_value == null)
					option_value = "";
		
				if(level_no == 1)
				{
				
					option_desc1 =option_desc;
					option_tot_value = option_value+"#1#";
					
				}
				else if(level_no == 2)
				{
					option_desc1 = spc+option_desc;
					option_tot_value = option_value+"#2#"; 
				}
				else if(level_no == 3)
				{
				
				option_desc1 = spc+spc+option_desc;			
				option_tot_value = option_value+"#3#";

				}
				else if(level_no == 4)
				{
					
					option_desc1 = spc+spc+spc+option_desc;
					option_tot_value = option_value+"#4#";

				}
				else if(level_no == 5)
				{
					
					option_desc1 = spc+spc+spc+spc+option_desc;
					option_tot_value = option_value+"#5#";

				}
		
				option_text = option_tot_value+option_type;

				out.println("var opt = parent.construct_ca_menu.document.createElement('OPTION');");
				out.println("opt.text = '"+option_desc1+"';");
				out.println("opt.value =' "+option_text+"';");

				if(option_type.equals("M") )
				{
					out.println("opt.style.color='RED'");
				}
				else
				{
						out.println("opt.style.color='BLACK'");
				}
			
				out.println("parent.construct_ca_menu.document.forms[0].MainMenus.add(opt);");	
			}
			out.println("</script>");

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
	}

	catch(Exception e)
	{
		//out.println("Exception While Getting Exisitng Menu: "+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
<script>

	<%if(counter > 0){%>
		parent.frames[1].document.forms[0].mode.value = "UPDATE";
	<%}%>
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
</script>

</body>
</html>


