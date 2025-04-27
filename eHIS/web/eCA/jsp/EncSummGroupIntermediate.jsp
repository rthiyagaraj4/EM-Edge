<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
18/07/2013     		1   		Sethuraman      Created for Searching encounter Summary Groups/Sub-Groups 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/EncSummaryGroup.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String groupType = "";
	String description = "";
	String sql = "";
	int count =0;
	try
	{
			con = ConnectionManager.getConnection(request);
			groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");
			description = request.getParameter("groupCode") == null ? "" : request.getParameter("groupCode");	
			
			/*Changes expected here*/
			/*
			if (groupType.equalsIgnoreCase("lbin"))
			{				
				sql = "SELECT test_code code, long_desc description FROM rl_test_code where group_test_yn  = 'Y' and (upper(test_code) like upper(?) or upper(long_desc) like upper(?) ) ORDER BY  long_desc";		
			}
			if (groupType.equalsIgnoreCase("rdin"))
			{			
				sql = "SELECT exam_code code, long_desc description FROM rd_exams where group_exam_yn  = 'Y' and (upper(exam_code) like upper(?) or upper(long_desc) like upper(?) ) ORDER BY  long_desc";		
			}
			*/
			
			//sql = "select event_code code, short_desc description from cr_event_hist_rec_vw where hist_rec_type = '"+groupType+"' and language_id = '"+locale+"' and (upper(event_code) like upper(?) or  upper(short_desc) like upper(?)) order by  short_desc";//common-icn-0180
			sql = "select event_code code, short_desc description from cr_event_hist_rec_vw where hist_rec_type = ? and language_id = ? and (upper(event_code) like upper(?) or  upper(short_desc) like upper(?)) order by  short_desc";//common-icn-0180
			
			description = description + "%";
			ps = con.prepareStatement(sql);
			//ps.setString(1,description);//common-icn-0180
			//ps.setString(2,description);//common-icn-0180
			
			//common-icn-0180 starts
			ps.setString(1,groupType);
			ps.setString(2,locale);
			ps.setString(3,description);
			ps.setString(4,description);
			//common-icn-0180 ends
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
					out.println("parent.f_query_add_mod.document.summgroup_form.es_group_code.value='"+rs.getString(1)+"' ");
					out.println("parent.f_query_add_mod.document.summgroup_form.flag.value='true' ");	
					out.println("parent.f_query_add_mod.document.summgroup_form.es_group_desc.value='"+rs.getString(2)+"' ");
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");

			if(count == 0 || count > 1)
			{
				/*Changes expected here*/
				/*
				if (groupType.equalsIgnoreCase("lbin"))
				{
					sql = "SELECT test_code code, long_desc description FROM rl_test_code where group_test_yn  = 'Y' and upper(test_code) like upper(?) and upper(long_desc) like upper(?) ORDER BY  long_desc";		
				}
				if (groupType.equalsIgnoreCase("rdin"))
				{
					sql = "SELECT exam_code code, long_desc description FROM rd_exams where group_exam_yn  = 'Y' and upper(exam_code) like upper(?) and upper(long_desc) like upper(?) ORDER BY  long_desc";		
				}
				*/
				
				sql = "select event_code code, short_desc description from cr_event_hist_rec_vw where hist_rec_type = '"+groupType+"' and language_id = '"+locale+"' and upper(event_code) like upper(?) and  upper(short_desc) like upper(?) order by short_desc";
				
%>
	<script>
		 retArray = callGroupCodeType1("<%=sql%>","Group/Sub-Group",parent.f_query_add_mod.document.summgroup_form.es_group_code);
			if(retArray != null && retArray !="")	
			{
				parent.f_query_add_mod.document.summgroup_form.es_group_desc.value = retArray[1];
				parent.f_query_add_mod.document.summgroup_form.es_group_code.value = retArray[0];
				parent.f_query_add_mod.document.summgroup_form.flag.value = 'true';
				parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
			}
			else
			{
				parent.f_query_add_mod.document.summgroup_form.es_group_desc.value = "";
				parent.f_query_add_mod.document.summgroup_form.es_group_code.value = "";
				parent.f_query_add_mod.document.summgroup_form.flag.value = 'true';
				parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			}			
	</script>
<%
		 }	
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in Section For Note Type Intermediate Module "+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}
%>
 </body>
</html>

