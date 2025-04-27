<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Description
--------------------------------------------------------------------------------------------------------
?            100            ?           		created
08/12/2011	 IN29865		MenakaV	 			CA>Quick Link for Filter>If All the Descriptions are un-checked
												in Customize Descriptions, all the Descriptions defined in Quick Link for Responsibility for the filter is not displayed.
--------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%

	request.setCharacterEncoding("UTF-8");
	//Properties p = (Properties)session.getValue("jdbc");
	//String locale	= (String) p.getProperty("LOCALE");
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;// IN29865
	String locale			= (String) p.getProperty("LOCALE");//IN29865
	String userId=((String) session.getValue("login_user")).trim();

	PreparedStatement stmt = null;
	ResultSet rs = null;
	Connection con = null;
	
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	
	try
	{
		con	= ConnectionManager.getConnection(request);
	
		String desc_id		= "";
		String short_desc	= "";
		String default_yn	= "";
		String default_yn_sel	= "";
		String ql_ref = "";
		String executable_name = "";
		//IN29865 Starts
		String sql = "";
		int Existance_Count = 0;
		String resp_id	= (String)session.getValue("responsibility_id");
		String login_user	= (String)session.getValue("login_user");
		
		//IN29865 Ends
		int default_count = 0;

		//String resp_id = (String) session.getValue("responsibility_id");
		StringBuffer sqlQuery	= new StringBuffer();
		
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script src='../../eCommon/js/common.js' language='javascript'></script>");
		out.println("<script language='javascript'>");

		String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
		
		//sqlQuery.append("select a.quick_link_ref, a.quick_link_description, B.EXECUTABLE_NAME from sm_quick_link_list A, CA_OPTION B, SM_QUICK_LINK_RESPONSIBILITY C where A.eff_STATUS='E' AND A.option_id = ? AND B.OPTION_ID = A.OPTION_ID and a.quick_link_description = c.quick_link_description and c.RESP_ID = ? order by 2 ");
		/* IN29865 Starts
		sqlQuery.append("select a.quick_link_ref, a.quick_link_description, B.EXECUTABLE_NAME,c.DEFAULT_YN from sm_quick_link_list A, CA_OPTION B, SM_QUICK_LINK_FOR_USER C where A.eff_STATUS='E' AND A.option_id = ? AND B.OPTION_ID = A.OPTION_ID and a.quick_link_ref = c.quick_link_ref and a.FUNCTION_SPEC_YN ='Y' and c.APPL_USER_ID = ?  and c.LINK_TYPE ='F' order by 2 ");
		
		stmt = con.prepareStatement(sqlQuery.toString());
		stmt.setString(1,function_id);
		stmt.setString(2,userId);
		//stmt.setString(2,resp_id);
		rs = stmt.executeQuery();
		IN29865 Ends */
		// IN29865 Starts
		try{
		sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, sm_quick_link_list_lang_vw c  WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id =? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_status = 'E' AND  c.language_id = ? AND c.function_spec_yn = 'Y'";

		stmt = con.prepareStatement(sql);
	
		stmt.setString(1,login_user);
		stmt.setString(2,resp_id);
		stmt.setString(3,function_id);
		stmt.setString(4,locale);
		rs = stmt.executeQuery();
		if(rs.next())
		{
			Existance_Count = rs.getInt("EXISTANCE_COUNT");
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();}
		catch(Exception e1)
		{
		//out.println("Except "+e1);//COMMON-ICN-0181
                 e1.printStackTrace();//COMMON-ICN-0181
		}
		
		sqlQuery.append("select a.quick_link_ref, C.quick_link_description, B.EXECUTABLE_NAME,A.DEFAULT_YN from ");
		if(Existance_Count>0)
			sqlQuery.append(" SM_QUICK_LINK_FOR_USER A ");
		else
			sqlQuery.append(" SM_QUICK_LINK_RESP A ");
		sqlQuery.append(", CA_OPTION B,sm_quick_link_list_lang_vw  C,sm_quick_link_resp d where  c.LANGUAGE_ID = '"+locale+"' and B.option_id = ? and c.FUNCTION_SPEC_YN ='Y' AND B.OPTION_ID  = A.OPTION_ID AND C.QUICK_LINK_REF=A.QUICK_LINK_REF AND C.eff_STATUS='E' AND  a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? AND d.link_type = 'F' AND");
		if(Existance_Count>0)
			sqlQuery.append(" A.APPL_USER_ID=?  ");
		else
			sqlQuery.append(" A.RESP_ID=?  ");
		sqlQuery.append(" and A.LINK_TYPE = 'F' order by 2 ");
		
		stmt = con.prepareStatement(sqlQuery.toString());
		stmt.setString(1,function_id);
		stmt.setString(2,resp_id);
		
		if(Existance_Count>0)
			stmt.setString(3,login_user);
		else
			stmt.setString(3,resp_id);
		rs = stmt.executeQuery();
		//IN29865 Ends
		out.println("var desc_id	= '';");
		out.println("var short_desc	= '---------" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ----------'; ");
		if(function_id.equals("PREVIOUS_NOTES"))
		{
			out.println("var opt=parent.RecClinicalNotesPrevFilterCriteriaFrame.document.createElement('OPTION'); ");
		}else{
			out.println("var opt=parent.CommonToolbar.document.createElement('OPTION'); ");
		}
		out.println("opt.text	=	short_desc; ");
		out.println("opt.value	=	desc_id; ");
		if(function_id.equals("PREVIOUS_NOTES"))
		{ 
			out.println("parent.RecClinicalNotesPrevFilterCriteriaFrame.RecClinicalNotesPrevNotesFilterCriteriaForm.filter.add(opt); ");
			out.println("parent.RecClinicalNotesPrevFilterCriteriaFrame.RecClinicalNotesPrevNotesFilterCriteriaForm.filter.selectedIndex = 0;");
		}else{
			out.println("parent.CommonToolbar.filter.add(opt); ");
			out.println("parent.CommonToolbar.filter.selectedIndex = 0;");
		}	
		while(rs.next())
		{
			short_desc	=	rs.getString("QUICK_LINK_DESCRIPTION");
			ql_ref = rs.getString("QUICK_LINK_REF") == null ? "" : rs.getString("QUICK_LINK_REF");
			executable_name = rs.getString("EXECUTABLE_NAME") == null ? "" : rs.getString("EXECUTABLE_NAME");
			desc_id = ql_ref + "|" + executable_name;
            default_yn	=	rs.getString("DEFAULT_YN")==null?"N":rs.getString("DEFAULT_YN");
			if(function_id.equals("PREVIOUS_NOTES"))
			{
				if(default_yn.equals("Y"))
				{
					default_count++;
					default_yn_sel ="selecetd";
					out.println("var queryString = parent.RecClinicalNotesPrevFilterCriteriaFrame.RecClinicalNotesPrevNotesFilterCriteriaForm.query_string.value");
					if(executable_name.indexOf("?") != -1)
						out.println("parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href='"+executable_name+"&'+queryString+'&pre_ql_ref="+ql_ref+"'");
					else
						out.println("parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href='"+executable_name+"?'+queryString+'&pre_ql_ref="+ql_ref+"'");
				}
				else
				{
					default_yn_sel  ="";
				}
				out.println("var desc_id	=\""+desc_id+"\";");
				out.println("var short_desc	=\""+short_desc+"\";");
				out.println("var opt = parent.RecClinicalNotesPrevFilterCriteriaFrame.document.createElement('OPTION'); ");
				out.println("opt.text	=	short_desc; ");
				out.println("opt.value	=	desc_id; ");
				out.println("opt.selected = '"+default_yn_sel+"'");
				out.println("parent.RecClinicalNotesPrevFilterCriteriaFrame.RecClinicalNotesPrevNotesFilterCriteriaForm.filter.add(opt); ");
			
			}
			else
			{
				if(default_yn.equals("Y"))
				{
					default_count++;
					default_yn_sel ="selecetd";
					out.println("var queryString = parent.CommonToolbar.refForm.queryString.value");
					if(executable_name.indexOf("?") != -1)
						out.println("top.content.workAreaFrame.location.href='"+executable_name+"&'+queryString+'&ql_ref="+ql_ref+"'");
					else
						out.println("top.content.workAreaFrame.location.href='"+executable_name+"?'+queryString+'&ql_ref="+ql_ref+"'");
				}
				else
				{
					default_yn_sel  ="";
				}
			
				out.println("var desc_id	=\""+desc_id+"\";");
				out.println("var short_desc	=\""+short_desc+"\";");
				out.println("var opt = parent.CommonToolbar.document.createElement('OPTION'); ");
				out.println("opt.text	=	short_desc; ");
				out.println("opt.value	=	desc_id; ");
				out.println("opt.selected = '"+default_yn_sel+"'");
				out.println("parent.CommonToolbar.filter.add(opt); ");
			}
			
		} 
		if(default_count == 0)
		{
			if(function_id.equals("PREVIOUS_NOTES"))
			{
				if(executable_name.equals(""))
				executable_name = "../../eCA/jsp/RecClinicalNotesPrevNotesSearchCriteria.jsp";
			out.println("var queryString = parent.RecClinicalNotesPrevFilterCriteriaFrame.RecClinicalNotesPrevNotesFilterCriteriaForm.query_string.value");
			

			if(executable_name.indexOf("?") != -1)
			{
				out.println("parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href='"+executable_name+"&default_yn=N&'+queryString");
			}
			else
			{
				out.println("parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href='"+executable_name+"?default_yn=N&'+queryString");

			}
			}
			else
			{
			//The following block was added for ICN17687 starts here 
			if(executable_name.equals("")){
			String exec_query="select EXECUTABLE_NAME from ca_option where option_id=?";
			PreparedStatement exec_stmt = null;
			ResultSet exec_rs = null;
			exec_stmt = con.prepareStatement(exec_query);
			exec_stmt.setString(1,function_id);
			exec_rs = exec_stmt.executeQuery();
			while(exec_rs.next())
				executable_name=exec_rs.getString("EXECUTABLE_NAME");
			}
			//if(executable_name.equals(""))
				//executable_name = "../../eCA/jsp/FlowSheet.jsp";

			//ends here
			out.println("var queryString = parent.CommonToolbar.refForm.queryString.value");
			
			if(executable_name.indexOf("?") != -1)
			{
				out.println("top.content.workAreaFrame.location.href='"+executable_name+"&default_yn=N&'+queryString");
			}
			else
			{
				out.println("top.content.workAreaFrame.location.href='"+executable_name+"?default_yn=N&'+queryString");

			}
			
			}
		}

		out.println("</script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><body CLASS='MESSAGE' onKeyDown='lockKey()'> </body></html>");
		
		if(rs!=null) rs.close();
		if(stmt!=null)	stmt.close();
	} // end of try
	catch(Exception e)
	{
		out.println("</script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></head><body CLASS='MESSAGE' onKeyDown='lockKey()'>");
		out.println("Exception@1 : "+e);
		out.println("</body></html>");
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
	
%>

