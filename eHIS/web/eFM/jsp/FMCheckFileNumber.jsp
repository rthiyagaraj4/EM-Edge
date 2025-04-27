<!DOCTYPE html>
<!--
	Developed by 		:	Prakash.S
	Module				:	eFM (File Management)
	Function			:	TO Validate the Entered File number
-->
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con =null;
	Statement stmt=null; 
	ResultSet rs=null;
	String file_no 	= 	"", sql="", curr_file_status="", facility_id="", return_date_time="";
	String iss_date_time = 	"";
	int total=0;
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	try
	{
		con			=	webbeans.eCommon.ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		stmt = con.createStatement();
		file_no = 	request.getParameter("file_no");
		if(file_no == null) file_no="";
		if(!(file_no.equals("")))
		{
			sql="Select count(*) as total, return_date_time, iss_date_time, curr_file_status from fm_curr_locn where file_no='"+file_no+"' and facility_id='"+facility_id+"' group by return_date_time, iss_date_time, curr_file_status";

			try
			{
				rs = stmt.executeQuery(sql);
				if ((rs.next()))
				{
					return_date_time	=	rs.getString("return_date_time");
					iss_date_time		=	rs.getString("iss_date_time");
					curr_file_status	=	rs.getString("curr_file_status");
					total				=	rs.getInt("total");
				}

				if(return_date_time == null) return_date_time="";
				if(iss_date_time == null) iss_date_time="";
				if(curr_file_status == null) curr_file_status="";
	

				out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE' onKeyDown = 'lockKey()'>");
			//	out.println("<script language=\"javascript\" src=\"../../eFM/js/eFMmessages.js\"></script>");

				if(total != 0)
				{
					if((return_date_time.equals(""))&&(iss_date_time.equals("")))
					{
						out.println("<script>");
						out.println("var msg=getMessage(\"FILE_IN_PERM_LOC\",\"FM\");");
						out.println("parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;");
						out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.focus();");
						out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.select();");
						out.println("</script>");
					}
					else
					{
						if(!(curr_file_status.equals("")))
						{
							if(curr_file_status.equals("L"))
							{
								out.println("<script>");
								out.println("var msg=getMessage(\"RETURN_DATE_NOT_CHANGED\",\"FM\");");
								out.println("parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.focus();");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.select();");
								out.println("</script>");
							}
							else if(curr_file_status.equals("T"))
							{
								out.println("<script>");
								out.println("var msg=getMessage(\"FILE_IN_TRANSIT_CANNOT_PROCEED\",\"FM\");");
								out.println("parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.focus();");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.select();");
								out.println("</script>");
								
							}
							else if(curr_file_status.equals("A"))
							{
								out.println("<script>");
								out.println("var msg=getMessage(\"RETURN_DATE_ARCHIVED\",\"FM\");");
								out.println("parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.focus();");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.select();");
								out.println("</script>");

							}
						}
					}
				}
				else
				{
					out.println("<script>");
					out.println("var msg=getMessage(\"FILE_NOT_EXIST\",\"FM\");");
					out.println("parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;");
					out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.focus();");
					out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.select();");
					out.println("</script>");

				}
				
			}
			catch(Exception e1)
			{
				out.println(e1);
			}
			
		}
		out.println("</script></body>");
	if (rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println(e);
		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body>");
	}
	finally
	{		
		webbeans.eCommon.ConnectionManager.returnConnection(con,request);
	}
%>

