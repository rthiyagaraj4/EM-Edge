<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<%
	Connection conn=null;
	try{
		       request.setCharacterEncoding("UTF-8");
		conn = ConnectionManager.getConnection(request);
		Statement stmt=conn.createStatement();
		%>
		<Script Language="JavaScript"	src="../../eCommon/js/ValidateControl.js"></Script>
		<HTML>
		<head>
		<%
          String sStyle	=         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()';  class='CONTENT' >
		<%
			
			String whereClause = request.getParameter("whereclause");
			StringBuffer sql=new StringBuffer();
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;

			if ( (whereClause == null || whereClause.equals("")) ) {
				sql.setLength(0);
				String Module_Id = request.getParameter("Module_Id");
				String Report_ID = request.getParameter("Report_ID");
				String Report_Desc = request.getParameter("Report_Desc");
				String Facility_ID = request.getParameter("Facility_ID");
				String Facility_Name = request.getParameter("Facility_Name");
				String Report_Group_ID = request.getParameter("Report_Group_ID");
				String Report_Group_Desc = request.getParameter("Report_Group_Desc");

				int andCheck = 0;

				if ( !(Module_Id == null || Module_Id.equals("")) ) {
					sql.setLength(0);
					sql.append( "where upper(Module_id) like upper('");
					sql.append(Module_Id);
					sql.append("%')");
					andCheck = 1;
				}

				if ( !(Report_ID == null || Report_ID.equals("")) ) {
						if ( andCheck == 1 ) {	
							sql.append(" and ");
							sql.append("upper(Report_ID) like  upper('");
							sql.append(Report_ID);
							sql.append("%')" );
						}
						else  {	
							sql.append( "where upper(Report_ID) like upper('");
							sql.append(Report_ID);
							sql.append("%')" );
							andCheck = 1;
						}
				}

				if ( !(Report_Desc == null || Report_Desc.equals("")) ) {
						if ( andCheck == 1 ) {	
							sql.append(" and ");
							sql.append("upper(Report_Desc) like  upper('");
							sql.append(Report_Desc);
							sql.append("%') ");
						}
						else  {	
							sql.setLength(0);
							sql.append("where upper(Report_Desc) like upper('");
							sql.append(Report_Desc);
							sql.append("%') ");
							andCheck = 1;
						}
				}

				if ( !(Facility_ID == null || Facility_ID.equals("")) ) {
					if ( andCheck == 1 ) {	
						sql.append(" and ");
						sql.append("upper(Facility_ID) like  upper('");
						sql.append(Facility_ID);
						sql.append("%')");
					}
					else {	
						sql.setLength(0);
						sql.append( "where upper(Facility_ID) like upper('");
						sql.append(Facility_ID);
						sql.append("%')");
						andCheck = 1;
					}
				}

				if ( !(Facility_Name == null || Facility_Name.equals("")) ) {
					if ( andCheck == 1 ) {	
						sql.append(" and ");
						sql.append("upper(Facility_Name) like  upper('");
						sql.append(Facility_Name);
						sql.append("%') ");
					}
					else {	
						sql.setLength(0);
						sql.append("where upper(Facility_Name) like upper('");
						sql.append(Facility_Name);
						sql.append("%') ");
						andCheck = 1;
					}
				}

				if ( !(Report_Group_ID == null || Report_Group_ID.equals("")) ) {
					if ( andCheck == 1 ) {	
						sql.append(" and ");
						sql.append("upper(Report_Group_ID) like  upper('");
						sql.append(Report_Group_ID);
						sql.append("%')");
					}
					else {	
						sql.setLength(0);
						sql.append("where upper(Report_Group_ID) like upper('");
						sql.append(Report_Group_ID);
						sql.append("%')");
						andCheck = 1;
					}
				}

				if ( !(Report_Group_Desc == null || Report_Group_Desc.equals("")) ) {
					if ( andCheck == 1 ) {	
						sql.append(" and ");
						sql.append(" upper(REPORT_GROUP_NAME)  like  upper('");
						sql.append(Report_Group_Desc);
						sql.append("%') ");
					}
					else {	
						sql.setLength(0);				
						sql.append("where upper(REPORT_GROUP_NAME)  like upper('");
						sql.append(Report_Group_Desc);
						sql.append("%') ");
						andCheck = 1;
					}
				}


				//appending order by clause 
				String ord[] = request.getParameterValues("orderbycolumns");
				

				if ( !(ord == null || ord .equals("")) )
				{	
					sql.append(" order by ");
					for ( int i=0;i < ord.length;i++ )
					{	
					if ( i == ord.length - 1 )
						sql.append(ord[i]);
					else 
						sql.append(ord[i]);
						sql.append(",");
					}
				}
			} 
			else 
				sql.setLength(0);	
				sql.append(whereClause);
			
			
			int start = 0 ;       
			int end = 0 ;
			int i=1;
				
			if ( from == null )
				start = 1 ;
			else
				start = Integer.parseInt( from ) ; 
			
			if ( to == null )
				end = 14 ;
			else 
				end = Integer.parseInt( to ) ;

			int cnt = 0;
			String endOfRes="1";
			ResultSet rs =null;
			/*ResultSet rs = stmt.executeQuery("select count(*) as total from Sm_Report_For_Fcy_Vw "+sql.toString());
			rs.next();
			maxRecord = rs.getInt("total");
			if(rs!=null) rs.close();
				if(maxRecord == 0)
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");*/

			rs = stmt.executeQuery("select * from Sm_Report_For_Fcy_Vw "+sql.toString()); 

			 	if ( start != 1 )
 	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  String classValue = "" ;
	  
	  while ( i<=end  && rs.next()){
		  if(cnt==0){
		%>

		<p>
		<table align='right'>
		<tr>
		<td>
		<%
		if ( !(start <= 1) )
			out.println("<A HREF='../jsp/queryReportForFacilityTable.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		if (endOfRes.equals("1"))
			out.println("<A id='nextval' HREF='../jsp/queryReportForFacilityTable.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		%>
		</td>
		</tr>
		</table>
		<br><br>
		</p>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th width="20%"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ReportID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSM.ReportGroupID.label" bundle="${sm_labels}"/></th>
		<th><fmt:message key="eSM.ReportGroupDesc.label" bundle="${sm_labels}"/></th>

		<%}
		
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				

				String M_ID = rs.getString("Module_id"); 
				String M_NAME = rs.getString("Module_name"); 
				String R_ID = rs.getString("Report_Id");
				String R_Desc = rs.getString("Report_Desc");
				String F_ID = rs.getString("Facility_Id");
				String F_Name = rs.getString("Facility_Name");
				String Rg_ID = rs.getString("Report_Group_ID");
				
				
				out.println("<tr><td class='" + classValue + "' align='left'><a href='../jsp/ReportForFacilityModify.jsp?Module_ID=" + M_ID + "&Report_ID=" + R_ID + "&Facility_ID=" + F_ID + "' target='f_query_add_mod' >" + M_NAME + "</a></td>"); 
				out.println("<td align='left' class='" + classValue + "'>" + R_ID + "</td>"); 
				out.println("<td align='left' class='" + classValue + "'>" + R_Desc + "</td>"); 
				out.println("<td align='left' class='" + classValue + "'>" + F_ID + "</td>"); 
				out.println("<td align='left' class='" + classValue + "'>" + F_Name + "</td>"); 
				out.println("<td class='" + classValue + "'>" + Rg_ID + "</td>");   
				if( rs.getString("REPORT_GROUP_NAME")==null ) 
					out.println("<td class='" + classValue + "'>&nbsp;</td>");
				else
					out.println("<td class='" + classValue + "'>" + rs.getString("REPORT_GROUP_NAME") + "</td>"); 
				i++;	
				cnt++;
	} 
	if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	if(!rs.next()&&cnt!=0){
		endOfRes="0";
		%>
		<script>
			document.getElementById('nextval').innerHTML=" ";
		</script>
	<%}
		if(rs !=null) rs.close();
		if(stmt != null) stmt.close();
		%>

		</tr>
		</table>
		<br><center>
		<%	
		}catch(Exception e){
			out.println(e);
			e.printStackTrace();
			}
	
	finally { 
			ConnectionManager.returnConnection(conn,request);
}
%>
</center>
</BODY>
</HTML>

