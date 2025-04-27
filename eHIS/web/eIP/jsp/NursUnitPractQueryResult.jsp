<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	//String url    = "../../eCommon/jsp/MstCodeToolbar.jsp?"; 
	//String params = request.getQueryString() ;
	//String source = url + params ;
	//String function_id = request.getParameter("function_id");
%>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String whereClause = request.getParameter("whereclause");

	StringBuffer sql = new StringBuffer();
	String from  = request.getParameter( "from" ) ;
	String to    = request.getParameter( "to" ) ;
	int andCheck = 0;
	
	if ( (whereClause == null || whereClause.equals("")) )
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
		String nursing_unit_code = request.getParameter("nursing_unit_code");
		String nursing_unit_desc = request.getParameter("nursing_unit_desc");
		String practitioner_id   = request.getParameter("practitioner_id");
		String practitioner_type   = request.getParameter("pract_type");
		if(practitioner_type == null) practitioner_type = "";
		
		
		String practitioner_name = request.getParameter("Practitioner_short_name");
		
		nursing_unit_code = nursing_unit_code.toUpperCase();
		practitioner_id = practitioner_id.toUpperCase();
		
		sql.append( " where facility_id  = '"+facilityId+"' ");
		andCheck=1;				
		
		if ( !(nursing_unit_code == null || nursing_unit_code.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(nursing_unit_code) like  upper('"+nursing_unit_code+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(nursing_unit_code) like upper('"+nursing_unit_code+"%')" );
				andCheck = 1;
			}
		}
		
		if ( !(nursing_unit_desc == null || nursing_unit_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql .append(" and ");
				sql.append("upper(NURSING_UNIT_short_DESC) like  upper('"+nursing_unit_desc+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(NURSING_UNIT_short_DESC) like upper('"+nursing_unit_desc+"%')" );
				andCheck = 1;
			}
		 }

		if ( !(practitioner_id == null || practitioner_id.equals("")) )
		{
		  
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(PRACTITIONER_ID) like  upper('"+practitioner_id+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(PRACTITIONER_ID) like upper('"+practitioner_id+"%')" );
				andCheck = 1;
			}
		  
		}
		if ( !(practitioner_type == null || practitioner_type.equals("")) )
		{
		  
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(PRACT_TYPE) like  upper('"+practitioner_type+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(PRACT_TYPE) like upper('"+practitioner_type+"%')" );
				andCheck = 1;
			}
		  
		}
		if ( !(practitioner_name == null || practitioner_name.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(PRACTITIONER_NAME) like  upper('"+practitioner_name+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(PRACTITIONER_NAME) like upper('"+practitioner_name+"%')" );
				andCheck = 1;
			}
		 }							
	 		String ord[] = request.getParameterValues("orderbycolumns");
	 		if ( !(ord == null || ord .equals("")) )
	 		{
	 			sql.append(" order by ");
	 
	 			for ( int i=0;i < ord.length;i++ )
	 			{
	 			if ( i == ord.length - 1 )
	 				sql.append(ord[i]);
	 			else
	 				sql.append(ord[i]+",");
	 			}
	 		}
	 	}
	 	else
	 	{
	 		sql.append(whereClause);
		}

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

	Connection conn = null;
	Statement stmt=null;
	Statement stmt1=null;
	//ResultSet rset=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	int maxRecord = 0;
	int cc = 0;

	try{
			conn = ConnectionManager.getConnection(request); 
			stmt = conn.createStatement();
			/*StringBuffer strsql1 = new StringBuffer();
			strsql1.append("select count(*) as total from ip_nursing_unit_for_Pract_vw "+sql.toString());

			rs = stmt.executeQuery(strsql1.toString());
			rs.next();
			maxRecord = rs.getInt("total");
			if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
	}
	else
		{*/
			StringBuffer strsql2 = new StringBuffer();
			strsql2.append("select  * from ip_nursing_unit_for_Pract_vw  "+sql.toString());
			rs = stmt.executeQuery(strsql2.toString());

			if ( start != 1 )
				for( int j=1; j<start; i++,j++ ){
					rs.next() ;
				}

				while ( i<=end && rs.next() )
				{

					 if (maxRecord==0)
				{
	%>

				<P>
				<table align='right'>
				<tr>
				<%
				if ( !(start <= 1) )
					out.println("<td align ='right' id='prev'><A HREF='../jsp/NursUnitPractQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

				//if ( !( (start+14) > maxRecord ) )
					out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/NursUnitPractQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
				%>
				</tr>
				</table>
				</P>
				<br><br>
				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.NursingUnitDescription.label" bundle="${ip_labels}"/></th>
				<th><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>

				<%
	/*if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		  }*/
				}
			String classValue = "" ;

	//while ( rs.next() && i<=end )
	//{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			String nursingunitcode 	    = rs.getString("nursing_unit_code");
			String nursingunitshortdesc = rs.getString("nursing_unit_short_desc");
			String practitionerid	    = rs.getString("practitioner_id");
			String practitionername     = rs.getString("practitioner_name");
			String pract_type           = rs.getString("pract_type");
			String finpract = "";
			
			stmt1 = conn.createStatement();
			rs1 = stmt1.executeQuery("select DESC_SYSDEF from am_pract_type where pract_type = '"+pract_type+"'");
			while((rs1.next())&&(cc<=maxRecord))
			{
				cc++;
				finpract = rs1.getString("DESC_SYSDEF");
			
			}
		
			out.println("<tr><td class='" + classValue + "'>");
						
			out.println(nursingunitcode+"</td><td class='" + classValue + "'>");
						
			out.println(nursingunitshortdesc+"</td><td class='" + classValue + "'>");
			
			out.println(practitionerid+"</td><td class='" + classValue + "'>");
			
			out.println(finpract+"</td><td class='" + classValue + "'>");

			out.println(practitionername+"</td><td class='" + classValue + "'>");

			i++;
			maxRecord++;
				}
	
	//}
	//if(rs!=null)rs.close();
	//if(stmt!=null)stmt.close();

		if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			}

			boolean flag = false;
	
			if ( maxRecord < 14 || (!rs.next()) )
				{
						%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
						<% flag = true;
					}
					else
					{%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



					<%
					}
	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}

	finally
	    {
			if(rs1!=null) 	 rs1.close();
			if(rs!=null) 	 rs.close();
			//if(rset!=null) rset.close();
			if(stmt1!=null) stmt1.close();
			if(stmt!=null) stmt.close();
			ConnectionManager.returnConnection(conn,request); ;
		}
%>

</td></tr>
</table>
</BODY>
</HTML>	
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

