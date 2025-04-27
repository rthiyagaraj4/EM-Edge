<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../js/DayCareUnitLink.js'></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' onLoad='ClearMsg()'  onKeyDown='lockKey()' OnMouseDown='CodeArrest()'>");
	String facilityId	= (String) session.getValue( "facility_id" ) ;
	String whereClause	= request.getParameter("whereclause");
	StringBuffer sql	= new StringBuffer(); 
	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	int andCheck		= 0;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
		String nursing_unit_code	= request.getParameter("nursing_unit_code");
		String nursing_unit_desc	= request.getParameter("nursing_unit_desc");
		String clinic_code			= request.getParameter("clinic_code");
		String clinic_short_desc		= request.getParameter("clinic_short_desc");
		nursing_unit_code	= nursing_unit_code.toUpperCase();
		clinic_code			= clinic_code.toUpperCase();

		sql.append(" where facility_id  = '"+facilityId+"' ");
		andCheck = 1;

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
			{	sql.append(" and ");
				sql.append("upper(NURSING_UNIT_short_DESC) like  upper('"+nursing_unit_desc+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(NURSING_UNIT_short_DESC) like upper('"+nursing_unit_desc+"%')" );
				andCheck = 1;
			}
		 }

		if ( !(clinic_code == null || clinic_code.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(clinic_code) like  upper('"+clinic_code+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(clinic_code) like upper('"+clinic_code+"%')" );
				andCheck = 1;
			}
		}

		if ( !(clinic_short_desc == null || clinic_short_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(clinic_short_desc) like  upper('"+clinic_short_desc+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(clinic_short_desc) like upper('"+clinic_short_desc+"%')" );
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

	int start	= 0;
	int end		= 0;
	int i		= 1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	Connection conn = null;
	Statement stmt	= null;
	ResultSet rs	= null;
	int maxRecord	= 0;   

	try{	conn = ConnectionManager.getConnection(request); 
			stmt = conn.createStatement();

			/*StringBuffer strsql1 = new StringBuffer();
			strsql1.append("select count(*) as total from IP_DC_UNIT_FOR_NURS_UNIT_VW  "+sql.toString());
			rs = stmt.executeQuery(strsql1.toString());
			rs.next();
			maxRecord = rs.getInt("total");
			if(rs!=null) rs.close();
			if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}else{*/
			StringBuffer strsql2 = new StringBuffer();
			strsql2.append("select * from IP_DC_UNIT_FOR_NURS_UNIT_VW "+sql.toString());
			rs = stmt.executeQuery(strsql2.toString());

			if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		  }

		  while (  i<=end && rs.next())
			{
			  if (maxRecord==0)
				{
				 %>
					<P>
					<table align='right'>
					<tr>
					<%
					if ( !(start <= 1) )
						out.println("<td align ='right' id='prev'><A HREF='../jsp/DayCareUnitLinkResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/DayCareUnitLinkResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					%>
					
					</tr>
					</table>
					</P>
					<br>
					<br>
					<table border="1" width="100%" cellspacing='0' cellpadding='0'>
					<th><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eIP.NursingUnitDescription.label" bundle="${ip_labels}"/></th>
					<th><fmt:message key="Common.daycareunitcode.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.daycareunitdesc.label" bundle="${common_labels}"/></th>
					<%
				}
	/*if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		  }*/

					String classValue = "" ;

	//while ( rs.next() && i<=end )
	//{
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					String nursingunitcode 	    = rs.getString("nursing_unit_code");
					String nursingunitshortdesc = rs.getString("nursing_unit_short_desc");
					String cliniccode			= rs.getString("clinic_code");
					String clinicshortname		= rs.getString("clinic_short_desc");

					out.println("<tr><td class='" + classValue + "'>");
					out.println(nursingunitcode+"</a></td><td class='" + classValue + "'>");
					out.println(nursingunitshortdesc+"</a></td><td class='" + classValue + "'>");
					out.println(cliniccode+"</a></td><td class='" + classValue + "'>");
					out.println(clinicshortname+"</a></td><td class='" + classValue + "'>");			
					i++;
					maxRecord++;
			}
	
//if(rs!=null) rs.close();
//if(stmt!=null) stmt.close();

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
				
//}
	}catch(Exception e){ out.println(e);
		
	}	finally   
	        {
		  if(stmt!=null) stmt.close();
	     	  if(rs!=null) 	 rs.close();
		  ConnectionManager.returnConnection(conn,request);
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

