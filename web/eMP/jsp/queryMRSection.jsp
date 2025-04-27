<!DOCTYPE html>
<!-- Last Modified Date Time : 9/26/2005 10:46 AM -->

<%@ page import ="java.sql.*, java.util.*, java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>


<%
	Connection conn			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null;
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >");

	String from	= request.getParameter("from");
	String to	= request.getParameter("to");

	//String facilityid = (String) session.getValue("facility_id");


/***** *******/  

String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	/*Added by lakshmanan for security issue ID 174131244 on 14-08-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174131244 on 14-08-2023 end */
	
	if ( (whereClause == null || whereClause.equals("")) )
	{
		String cd = request.getParameter("mr_section_code");

		cd = cd.toUpperCase();

		String facility_id = request.getParameter("a.facility_id");

		if (facility_id==null) facility_id="";
			facility_id = facility_id.toUpperCase();

		String facility_name = request.getParameter("facility_name");

		if (facility_name==null) facility_name="";
			facility_name = facility_name.toUpperCase();

		String long_name = request.getParameter("long_name"); 
		if (long_name==null) long_name="";
			long_name = long_name.toUpperCase();


		String eff_status = request.getParameter("eff_status");
       if ( !(cd == null || cd.equals("")) )
		{
			sbQuery.append(" and mr_section_code like ? ");
			psthashmap.put(++psthmcount,cd+"%");
			//sbQuery.append(cd);
			//sbQuery.append("%'");
	
		}

		if ( !(long_name == null || long_name.equals("")) )
		{
			
				sbQuery.append("and  (upper(long_name) like ? ");
				psthashmap.put(++psthmcount,long_name+"%");
				//sbQuery.append(long_name);
				//sbQuery.append("%'");

				sbQuery.append("or  upper(short_name) like ? )");
				psthashmap.put(++psthmcount,long_name+"%");
				//sbQuery.append(long_name);
				//sbQuery.append("%')");
				
				
	   }
   


	if ( !(facility_id == null || facility_id.equals("")) )
		{
			
				sbQuery.append("and upper(A.facility_id) like ? ");
				psthashmap.put(++psthmcount,facility_id+"%");
				//sbQuery.append(facility_id);
				//sbQuery.append("%'");
		 }

	if ( !(facility_name == null || facility_name.equals("")) )
		{
			
				sbQuery.append("and  upper(facility_name) like ? ");
				psthashmap.put(++psthmcount,facility_name+"%");
				//sbQuery.append(facility_name);
				//sbQuery.append("%'");
				
		}
    
		if ( !(eff_status == null || eff_status.equals("")) )
		{
		   if ( eff_status.equals("E") ){
			   sbQuery.append(" and eff_status='E'");
		   }
		   if ( eff_status.equals("D") ){
			   sbQuery.append(" and eff_status='D'");
		   }
		}

		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
		{
			sbQuery.append(" order by ");
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
				}
			}
		}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
	}

/*************************/
	
	int start	= 0;
	int end		= 0;
	int i		= 1;

	if(from == null) start = 1 ;
	else start = Integer.parseInt( from ) ;

	if(to == null) end = 14 ;
	else end = Integer.parseInt( to ) ;

	try
	{
		conn = ConnectionManager.getConnection(request);
		
	/*	int maxRecord = 0;
		
		try
		{
			pstmt = conn.prepareStatement("select count(*) as total from mr_section");
			rs = pstmt.executeQuery();
			rs.next();
			maxRecord = rs.getInt("total");
		}
		catch(Exception e) { out.println(e.toString());}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		}
		
		if(maxRecord == 0) 			
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
		}*/
		
		try
		{	/*Added by lakshmanan for security issue ID 174131244 on 14-08-2023 start */
			int pstcount=1;
			pstmt = conn.prepareStatement("SELECT A.facility_id, facility_name, mr_section_code, long_name, short_name, mr_section_type, next_srl_no, max_srl_no, eff_status FROM mr_section A, sm_facility_param B WHERE A.facility_id = B.facility_id " +sbQuery.toString());
			while ( pstcount<=psthashmap.size()) {
			pstmt.setString(pstcount,(String) psthashmap.get(pstcount));
			pstcount++;
			}
			psthashmap.clear();
			/*Added by lakshmanan for security issue ID 174131244 on 14-08-2023 end */
			rs = pstmt.executeQuery();
			%>
			
				<%

				if(start != 1)
					for(int j=1; j<start; i++,j++)
			   			rs.next();

			   	String classValue	= "";
				String facilityname	= "";
				String facilitycode	= "";
				String code				= "";
				String mr_section_type			= "";
				int cnt = 0;
				while(i<=end && rs.next())
				{
					if(cnt==0)
					{ %>
						<P>
					<table align='right'>
						<tr>
					<%
					if(!(start <= 1))
					{
						out.println("<td align ='right' id='prev'><A HREF='../jsp/queryMRSection.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
					} %>
					<td align ='right' id='next' style='visibility:hidden'>
				<%	/*if(!((start+14) > maxRecord))
					{*/
						out.println("<A HREF='../jsp/queryMRSection.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
					//}
					%>
					</td>
				</tr>
			</table>
			<BR><BR>
			</P>
			<center>
			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.longname.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.MRSectionType.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.nextsrlno.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.maxserialno.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				<%	}
					if(i % 2 == 0) classValue = "QRYEVEN";
					else classValue = "QRYODD" ;
					
					facilityname = "";
					facilitycode = "";
					code		 = "";
					
					mr_section_type =  rs.getString("mr_section_type");

					switch (mr_section_type.charAt(0))
					{
						case  'C' :
									mr_section_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Central.label","common_labels") ;		
									break;
						case  'D' :
									mr_section_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Departmental.label","common_labels");
									break;
					}
					out.println("<tr><td align='left' class='"+classValue+"'>");
					
					facilitycode = rs.getString("facility_id");
					out.println(facilitycode);
					facilityname = rs.getString("facility_name");					
					out.println("<td align='left' class='"+classValue+"'>");
					out.println(facilityname);
					out.println("<td align='left' class='"+classValue+"'>");
					
					code = rs.getString("mr_section_code");
					out.println("<a href='../jsp/MRSectionModify.jsp?section_code="+code+"&facility_id="+facilitycode+"' target='f_query_add_mod'>"+code+"</a></td>");
			
					out.println("<td class='"+classValue+"'>");
					out.println( rs.getString("long_name") );
				
					out.println("</td><td class='"+classValue+"'>");
					out.println(rs.getString("short_name"));
				
					out.println("</td><td class='"+classValue+"'>");
					out.println(mr_section_type);

					out.println("</td><td class='"+classValue+"'>");
					out.println(rs.getLong("next_srl_no"));
				
					out.println("</td><td class='"+classValue+"'>");
					out.println(rs.getLong("max_srl_no"));
				
					out.println("</td><td class='"+classValue+"' align='center'>");

					if(rs.getString("eff_status").equals("E"))
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				
					i++;
					cnt++;
				}
				if (cnt==0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
				boolean flag = false;
				if ( cnt < 14 || (!rs.next()) ) {
				%>
					<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='hidden';
					</script>
				<% flag = true;
						} else {%>
					<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<%}%>
				</td>
				</tr>
			</table>
			</center>
			<br>
			<center>
			<%
		}
		catch(Exception e) { 
			e.printStackTrace();
			}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

	}catch(Exception e) { 
		e.printStackTrace();
		}
	finally
	{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
	%>
	</center>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? ""	: inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

