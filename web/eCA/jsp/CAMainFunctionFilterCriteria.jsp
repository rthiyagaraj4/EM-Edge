
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0038
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	Connection con = null;

	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");
		
	try
	{
		con	= ConnectionManager.getConnection(request);
	
		String function_id	= "";
		String desc_id		= "";
		String short_desc	= "";
		String ql_ref		= "";
		String default_yn	= "";
		String default_sel	= "";
		String executable_name = "";
		StringBuffer sqlQuery	= new StringBuffer();
		String sql = "";
		String resp_id	= (String)session.getValue("responsibility_id");
		String login_user	= (String)session.getValue("login_user");
		int Existance_Count = 0;
		int count = 0;
		int def_count = 0;
				
				
		function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");		
		//sql = "select 1 Existance_Count from SM_QUICK_LINK_FOR_USER where APPL_USER_ID = ? and DEFAULT_YN = 'Y' and rownum=1 and OPTION_ID =? ";
		try{
		sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, sm_quick_link_list_lang_vw c  WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id =? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_status = 'E' AND  c.language_id = ? AND c.function_spec_yn = 'Y'";//Changed by DineshT

		stmt1 = con.prepareStatement(sql);
	
		stmt1.setString(1,login_user);
		stmt1.setString(2,resp_id);
		stmt1.setString(3,function_id);
		stmt1.setString(4,locale);
		rs1 = stmt1.executeQuery();
		if(rs1.next())
		{
			Existance_Count = rs1.getInt("EXISTANCE_COUNT");
		}
		if(rs1 != null) rs1.close();
		if(stmt1 != null) stmt1.close();}
		catch(Exception e1)
		{
		//out.println("Except "+e1);//COMMON-ICN-0181
		e1.printStackTrace();//COMMON-ICN-0181
		}

		sqlQuery.append("select a.quick_link_ref, C.quick_link_description, B.EXECUTABLE_NAME,a.DEFAULT_YN from ");
		if(Existance_Count>0)
			sqlQuery.append(" SM_QUICK_LINK_FOR_USER A ");
		else
			sqlQuery.append(" SM_QUICK_LINK_RESP A ");
		//sqlQuery.append(", CA_OPTION B,sm_quick_link_list_lang_vw  C where  c.LANGUAGE_ID = '"+locale+"' and B.option_id = ? and c.FUNCTION_SPEC_YN ='Y' AND B.OPTION_ID  = A.OPTION_ID AND C.QUICK_LINK_REF=A.QUICK_LINK_REF AND C.eff_STATUS='E' AND ");//IN29865
		sqlQuery.append(", CA_OPTION B,sm_quick_link_list_lang_vw  C,sm_quick_link_resp d where  c.LANGUAGE_ID = '"+locale+"' and B.option_id = ? and c.FUNCTION_SPEC_YN ='Y' AND B.OPTION_ID  = A.OPTION_ID AND C.QUICK_LINK_REF=A.QUICK_LINK_REF AND C.eff_STATUS='E' AND a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? AND d.link_type = 'F' AND ");//IN29865
		if(Existance_Count>0)
			sqlQuery.append(" A.APPL_USER_ID=?  ");
		else
			sqlQuery.append(" A.RESP_ID=?  ");
		//sqlQuery.append(" and LINK_TYPE = 'F' order by 2 "); //IN29865
		sqlQuery.append(" and A.LINK_TYPE = 'F' order by 2 "); //IN29865
		
		stmt = con.prepareStatement(sqlQuery.toString());
		stmt.setString(1,function_id);
		stmt.setString(2,resp_id);//IN29865
		if(Existance_Count>0)
			stmt.setString(3,login_user);//IN29865
		else
			stmt.setString(3,resp_id);//IN29865
		rs = stmt.executeQuery();

		out.println("var desc_id	= '';");
		out.println("var short_desc	= '---------" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ----------'; ");
		out.println("var opt=parent.CommonToolbar.document.createElement('OPTION'); ");
		out.println("opt.text	=	short_desc; ");
		out.println("opt.value	=	desc_id; ");
		out.println("parent.CommonToolbar.filter.add(opt); ");
		
		//out.println("parent.CommonToolbar.filter.selectedIndex = 0;");
			
		while(rs.next())
		{
			
			short_desc	=	rs.getString("QUICK_LINK_DESCRIPTION");
			ql_ref		=	rs.getString("QUICK_LINK_REF");
			executable_name = rs.getString("EXECUTABLE_NAME");
			desc_id		=	ql_ref + "|" + executable_name;
		    default_yn	=	rs.getString("DEFAULT_YN") == null ? "N" : rs.getString("DEFAULT_YN");
			if(default_yn.equals("Y"))
			{
				default_sel = "selected";
				def_count=count+1;
			}
			else
				default_sel = "";		
			
			out.println("var desc_id	=\""+desc_id+"\" ");	
			out.println("var short_desc	=\""+short_desc+"\";");

			out.println("var opt = parent.CommonToolbar.document.createElement('OPTION');");
			out.println("opt.text	=	short_desc ");
			out.println("opt.value	=	desc_id ");
			out.println("opt.selected = '"+default_sel+"'");
			out.println("parent.CommonToolbar.filter.add(opt)");
			count++;
		} // end of while
	
		out.println("parent.CommonToolbar.filter.selectedIndex ="+def_count+" ;");
		out.println("parent.CommonToolbar.function_id.value=\""+function_id+"\";");
		out.println("parent.CommonToolbar.executable_path.value=\""+executable_name+"\";");
			
		if(rs!=null) rs.close();
		if(stmt!=null)	stmt.close();
	} // end of try
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
	
%>
