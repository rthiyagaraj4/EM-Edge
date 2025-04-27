<!DOCTYPE html>
<%@ page import ="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;
	request.setCharacterEncoding("UTF-8");	

	String locale	= (String)session.getAttribute("LOCALE");
	
	try
	{
	 
	con	=	ConnectionManager.getConnection(request);	
	String cust_group_code="",cust_code="",short_name="";

	//unused variable, commented on 09/06/05
	String query_ref_source="",/*facility_id="",*/ slmt_ind="",adm_rec_flag="", strModuleId = "";

	cust_group_code	= 	request.getParameter("cust_group_code");
	slmt_ind		= 	request.getParameter("slmt_ind");
	adm_rec_flag	= 	request.getParameter("adm_rec_flag");
	strModuleId     =   request.getParameter("module_id");

	if(cust_group_code==null) cust_group_code="";
	cust_group_code=cust_group_code.trim();	

	if(slmt_ind==null) slmt_ind="";
	slmt_ind=slmt_ind.trim();	

	if(adm_rec_flag==null) adm_rec_flag="";
	adm_rec_flag=adm_rec_flag.trim();		

	if ( strModuleId == null ) strModuleId="";
	strModuleId = strModuleId.trim();
	

	out.println("<html><head>");

	/*
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>");
	*/


	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<link rel='StyleSheet' href='../../eCommon/html/'"+sStyle+" type='text/css'/>");

//	out.println("<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>");	

	
		
	stmt = con.createStatement();	
	
		
	out.println("<script language='javascript'>");		

	if (slmt_ind.equals("X") && adm_rec_flag.equals("2"))	
	{		

		query_ref_source="select short_name, cust_code from ar_customer_lang_vw where language_id='"+locale+"' and nvl(patient_flag,'N') = 'Y' and nvl(pat_com_flag,'N') = 'N' and nvl(insurance_yn,'N') = 'Y' and  nvl(cust_group_code,'X') like nvl('"+cust_group_code+"','%') and status is null and  (('"+strModuleId+"' in ('OP','AE') and nvl(op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP') and nvl(ip_yn,'N') = 'Y') or '"+strModuleId+"' = 'MP') order by short_name";

	}

	else if (slmt_ind.equals("X") && adm_rec_flag.equals("1"))	
	{
		query_ref_source="select short_name, cust_code from ar_customer_lang_vw where language_id='"+locale+"' and nvl(patient_flag,'N') = 'Y' and nvl(pat_com_flag,'N') = 'N' and nvl(insurance_yn,'N') = 'N' and nvl(cust_group_code,'X') like nvl('"+cust_group_code+"','%') and status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP') and nvl(ip_yn,'N') = 'Y') or '"+strModuleId+"' = 'MP') order by short_name";
	}
			
	else
	{ 

		query_ref_source="select short_name, cust_code from ar_customer_lang_vw where language_id='"+locale+"' and nvl(patient_flag,'N') = 'Y' and nvl(pat_com_flag,'N') = 'Y' and nvl(cust_group_code,'X') like nvl('"+cust_group_code+"','%') and status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP') and nvl(ip_yn,'N') = 'Y') or '"+strModuleId+"' = 'MP') order by short_name";
	
	}	
	
		//out.println("</head><body><br>Query : "+query_ref_source+"</body>");
			
		rs = stmt.executeQuery(query_ref_source);	

		
		out.println("var cust_code	= 'select';");
		out.println("var short_name	= '         ---- Select ----       ';");
		
		out.println("var opt=parent.frames[1].frames[0].document.createElement('OPTION'); ");
		if (cust_group_code.length() > 0) 
		{	out.println("opt.text	=	short_name; ");
			out.println("opt.value	=	cust_code; ");
	
			if (slmt_ind.equals("X") && adm_rec_flag.equals("2"))	
			{	out.println("parent.frames[1].frames[0].document.forms[0].cust_3.add(opt); ");
				out.println("parent.frames[1].frames[0].document.forms[0].cust_3.selectedIndex = 0;");
			}
			else if (slmt_ind.equals("X") && adm_rec_flag.equals("1"))	
			{	out.println("parent.frames[1].frames[0].document.forms[0].cust_2.add(opt); ");
				out.println("parent.frames[1].frames[0].document.forms[0].cust_2.selectedIndex = 0;");
			}
			else			
			{	

			out.println("parent.frames[1].frames[0].document.forms[0].cust_1.add(opt); ");
			out.println("parent.frames[1].frames[0].document.forms[0].cust_1.selectedIndex = 0;");
			}
		}
		while(rs.next())
			{
				
				cust_code	=	rs.getString("cust_code");
				short_name	=	rs.getString("short_name");

				out.println("var cust_code	= '"+cust_code+"';");
				out.println("var short_name	= '"+short_name+"';");

				out.println("var opt = parent.frames[1].frames[0].document.createElement('OPTION'); ");
				out.println("opt.text	=	short_name; ");
				out.println("opt.value	=	cust_code; ");
				if (slmt_ind.equals("X") && adm_rec_flag.equals("2"))	
				{out.println("parent.frames[1].frames[0].document.forms[0].cust_3.add(opt); ");}
				else if (slmt_ind.equals("X") && adm_rec_flag.equals("1"))	
				{out.println("parent.frames[1].frames[0].document.forms[0].cust_2.add(opt); ");}
				else
				{out.println("parent.frames[1].frames[0].document.forms[0].cust_1.add(opt); ");}

			} // end of while
			
			out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE'> </body></html>");
		} // end of try
		catch(Exception e)
		{
			out.println("</script></head><body CLASS='MESSAGE'>");
			out.println("Exception@1 : "+e);
			out.println("</body></html>");
		}
		finally
		{
			if (rs != null)   rs.close();
			if(stmt!=null)	stmt.close();
			ConnectionManager.returnConnection(con, request);
		}
		
		//out.println("</script></head><body CLASS='MESSAGE'> </body></html>");
%>

