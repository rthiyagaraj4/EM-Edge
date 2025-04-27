<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;

	StringBuffer sql = new StringBuffer();

	String Facility_Id = (String) session.getValue("facility_id");
	String loc_code = request.getParameter("locn_code");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	try
	{
		conn=ConnectionManager.getConnection(request);
		if( loc_code == null || loc_code.equals("") )
		{
		
		/* The following sql query is used to select the Visit type based on various Clinic_code and facilities  ---  Srijagadeesh */

			sql =sql.append( "select visit_type_code,visit_type_short_desc from op_visit_type_for_clinic_vw where clinic_code = '"+loc_code+"' and facility_id = '"+Facility_Id+"' order by 2");
		}
		else
		{
			if (loc_code.equals("*ALL") ) 
			{
				sql = sql.append("select '*A' visit_type_code,'*ALL' visit_type_short_desc from dual union ");
				sql =sql.append("select visit_type_code,visit_type_short_desc from op_visit_type_for_clinic_vw where facility_id = '"+Facility_Id+"' order by 2");
			}
			else
			{
				sql =sql.append( "select '*A' visit_type_code,'*ALL' visit_type_short_desc from dual union ");
				sql =sql.append( "select visit_type_code,visit_type_short_desc from op_visit_type_for_clinic_vw where clinic_code = '"+loc_code+"' and facility_id = '"+Facility_Id+"' order by 2");
			}
		}

			pstmt = conn.prepareStatement(sql.toString());
			rset = pstmt.executeQuery();
			String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>";
			out.println(a1);
%>
	<script>
		var n=parent.frames[1].document.forms[0].opvisit.options.length;
		for(var i=0;i<n;i++)
		{
			parent.frames[1].document.forms[0].opvisit.remove("opvisit");	
		}
		var tp =" -------- "+getLabel("Common.defaultSelect.Label","Common")+" -------- ";
		var opt=parent.frames[1].document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.frames[1].document.forms[0].opvisit.add(opt);
	</script>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>

	<%	
		if(rset != null)
		{	
			while( rset.next() ) 
			{
				String str1 = rset.getString("visit_type_code") ;
				String str2 = rset.getString("visit_type_short_desc");
	
				out.println("<script>var element = parent.f_query_add_mod.document.createElement('OPTION');"+
					"element.text = '"+str2+"';"+ 
					"element.value= '"+str1+"';"+
					"parent.f_query_add_mod.document.forms[0].opvisit.add(element);</script>");
			}
		}
	}
	catch(Exception e){out.println("Excep VISIT:"+e);}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null)   rset.close();
		if (conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>

