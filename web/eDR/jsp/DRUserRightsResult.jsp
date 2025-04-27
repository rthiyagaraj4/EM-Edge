<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script  language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function callResultColor()
	{
		parent.frames[2].location.href = '../../eDR/jsp/DRUserRightsQueryResultColor.jsp';
	}
</script>
</head>
<BODY class='CONTENT' onLoad="" onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="query_form_results" id="query_form_results">
<%
	
	Connection conn = ConnectionManager.getConnection(request);
	String sql ="";

	String whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter("from");
	String to			= request.getParameter("to");

	if((whereClause == null || whereClause.equals("")))
	{
		sql	= "";

		String cd				= request.getParameter("appl_user_id");
		String empno			= request.getParameter("employee_no");
		String cd1				= request.getParameter("appl_user_name");
		String status			= request.getParameter("eff_status");
		String search_level		= request.getParameter("search_privilege_level");
		String identify_level	= request.getParameter("identify_privilege_level");
		String merge_level		= request.getParameter("merge_privilege_level");
		String administer_level = request.getParameter("administer_privilege_level");

		int andCheck = 0;
		if(!(cd == null || cd.equals("")))
		{
			cd  = cd.toUpperCase();
			sql = "where appl_user_id like '"+cd+"%'";
			andCheck = 1;
		}

		if(!(cd1 == null || cd1.equals("")))
		{
			cd1 = cd1.toUpperCase();
			if(andCheck == 1)
			{
				sql = sql + " and ";
				sql = sql + "upper(appl_user_name) like '"+cd1+"%' " ;
			}
			else
			{
				sql = "where upper(appl_user_name) like '"+cd1+"%'";
				andCheck = 1;
			}
		}
		if(!(empno == null || empno.equals("")))
		{
			empno = empno.toUpperCase();
			if(andCheck == 1)
			{
				sql = sql + " and ";
				sql = sql + "upper(employee_no) like '"+empno+"%' " ;
			}
			else
			{
				sql = "where upper(employee_no) like '"+empno+"%'";
				andCheck = 1;
			}
		}
		if(!(search_level == null || search_level.equals("")) && !(search_level.equals("S")))
		{
			search_level=search_level.toUpperCase();
			if(andCheck == 1)
			{
				sql = sql + " and ";
				sql = sql + "search_privilege_level like '"+search_level+"%' " ;
			}
			else
			{
				sql = "where search_privilege_level like '"+search_level+"%'";
				andCheck = 1;
			}
		}
		if(!(identify_level == null || identify_level.equals("")) && !(identify_level.equals("S")))
		{
			identify_level=identify_level.toUpperCase();
			if(andCheck == 1)
			{
				sql = sql + " and ";
				sql = sql + "identify_privilege_level like '"+identify_level+"%' " ;
			}
			else
			{
				sql = "where identify_privilege_level like '"+identify_level+"%'";
				andCheck = 1;
			}
		}
		if(!(merge_level == null || merge_level.equals("")) && !(merge_level.equals("S")))
		{
			merge_level = merge_level.toUpperCase();
			if(andCheck == 1)
			{
				sql = sql + " and ";
				sql = sql + "merge_privilege_level like '"+merge_level+"%' " ;
			}
			else
			{
				sql = "where merge_privilege_level like '"+merge_level+"%'";
				andCheck = 1;
			}
		}
		if(!(administer_level == null || administer_level .equals(""))  && !(administer_level.equals("S")))
		{
			administer_level =administer_level.toUpperCase();
			if( andCheck == 1)
			{	
				sql = sql + " and ";
				sql = sql + "administer_privilege_level like '"+administer_level+"%' " ;
			}
			else
			{
				sql = "where administer_privilege_level like '"+administer_level+"%'";
				andCheck = 1;
			}
		}
		if(!(status == null || status.equals("")))
		{
			if(andCheck == 1)
			{
				sql = sql + " and ";
				sql = sql + "eff_status in  decode('"+status+"','E','E','D','D',eff_status)" ;
			}
			else
			{
				sql = "where eff_status in  decode('"+status+"','E','E','D','D',eff_status)" ;
				andCheck = 1;
			}
		}
	}
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	if(!(ord == null || ord .equals("")))
	{
		sql = sql+" order by ";
		for(int i=0; i < ord.length; i++)
	 	{
			if(i == ord.length - 1) sql = sql+ord[i];
			else sql = sql+ord[i]+",";
		}
	} 
	else
	{
		sql = whereClause;
	}
	
	int start	= 0;
	int end		= 0;
	int i	= 1;
	int endOfRes = 1;
	int cnt =0;
	if(from == null) start = 1 ;
	else start = Integer.parseInt(from);

	if(to == null) end = 14 ;
	else end = Integer.parseInt(to);

	java.sql.Statement stmt	= null;
	ResultSet rset			= null;
	ResultSet rs			= null;

	StringBuffer strsql2 = null;
	strsql2 = new StringBuffer();

	//int maxRecord = 0;

	try
	{
		
		stmt = conn.createStatement();

	/*	String strsql1="select count(*) as total from dr_user_rights_vw "+sql;
		rs = stmt.executeQuery(strsql1);
		if(rs.next())
		maxRecord = rs.getInt(1);
		if(rs != null) rs.close();*/

		

		strsql2.append("select employee_no,appl_user_id, appl_user_name, decode(search_privilege_level,'N','None','A','All Facilities','L','Logged-in Facility') search_privilege_level, decode(identify_privilege_level,'N','None','A','All Facilities','L','Logged-in Facility')identify_privilege_level, decode(merge_privilege_level,'N','None','A','All Facilities','L','Logged-in Facility') merge_privilege_level, decode(unmerge_privilege_level,'N','None','A','All Facilities','L','Logged-in Facility') unmerge_privilege_level, decode(administer_privilege_level,'N','None','A','All Facilities','L','Logged-in Facility') administer_privilege_level, eff_status from dr_user_rights_vw ");
		strsql2.append(sql);
		rs = stmt.executeQuery(strsql2.toString());

		if(start != 1)
			for(int j=1; j<start; i++,j++ )			
				rs.next() ;
			
		/*rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();

		if (maxRecord==0) 		
		{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}else{*/
		while( i<=end && rs.next() ) 
		{
			if(cnt == 0) 
			{
		%>
		<p>
		<table align='right'>
			<tr>
				<td>	
				<%
				if(!(start <= 1))
					out.println("<A HREF='../../eDR/jsp/DRUserRightsResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				
				if( endOfRes == 1 )
					out.println("<A id='nextval' HREF='../../eDR/jsp/DRUserRightsResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				%>
				</td>
			</tr>
		</table>
		<BR><BR>
		</p>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<th class="columnheader"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
			<th class="columnheader"><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
			<th class="columnheader"><fmt:message key="Common.EmployeeNo.label" bundle="${common_labels}"/></th>
			<th class="columnheader"><fmt:message key="Common.search.label" bundle="${common_labels}"/> </th>
			<th class="columnheader"><fmt:message key="eDR.IdentifyMainDuplicates.label" bundle="${dr_labels}"/></th>
			<th class="columnheader"><fmt:message key="eDR.Merge.label" bundle="${dr_labels}"/></th>
			<th class="columnheader"><fmt:message key="Common.Administer.label" bundle="${common_labels}"/></th>
			<th class="columnheader"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			<%
					
			}
			String classValue = "";

				if(i % 2 == 0) classValue = "QRYEVEN" ;
				else classValue = "QRYODD" ;

				out.println("<tr><td class='" + classValue + "'>");

				String code		= rs.getString("appl_user_id");
				String eff		= rs.getString("eff_status");
				String em_no	= rs.getString("employee_no");
			
				if(em_no == null) em_no = "&nbsp;";

				out.println("<a href='../../eDR/jsp/DRUserRightsAddMod.jsp?p_appl_user_id="+ code + "& target=f_query_add_mod&operation=modify' >");
				out.println(code+"</a></td><td align='left' class='" + classValue + "'>");
				out.println( rs.getString("appl_user_name") );
				out.println("</td><td align='center' class='" + classValue + "'>");
				out.println(em_no);
				out.println("</td><td align='center' class='" + classValue + "'>");
				out.println( rs.getString("search_privilege_level") );
				out.println("</td><td align='center' class='" + classValue + "'>");
				out.println(rs.getString("identify_privilege_level") );
				out.println("</td><td align='center' class='" + classValue + "'>");
				out.println(rs.getString("merge_privilege_level") );
				out.println("</td><td align='center' class='" + classValue + "'>");
				out.println(rs.getString("administer_privilege_level") );
				out.println("</td><td align='center' align='right' class='" + classValue + "'>");
				
				if(eff.equals("E"))
				{
					%>
					<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
					<%
				}
				else 
				{
					%>
					<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
					<%
				}
				
				out.println("</td><td align='center' align='right' class='" + classValue + "'>");
				i++;	
				cnt++;
			} //endwhile
			if (cnt == 0)				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");	
			if( !rs.next() && cnt!=0 )
			{
			%>
			<script>
				document.getElementById('nextval').innerHTML = " ";
			</script>
			<% }		
					
			if((strsql2 != null) && (strsql2.length() > 0))
			{
				strsql2.delete(0,strsql2.length());
			}

			if(rs != null) rs.close();
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e)
		{
			out.print(e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(conn,request);
		}
		%>
		</td></tr>
	</table>
	<br><center>
	</center>
</BODY>
</HTML>

