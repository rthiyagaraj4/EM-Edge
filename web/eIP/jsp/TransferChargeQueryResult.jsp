<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>


<%
	request.setCharacterEncoding("UTF-8"); 
	out.println("<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' class='CONTENT' onLoad='ClearMsg()'>");
	String whereClause				= request.getParameter("whereclause");
	String sql						= "";
	String from						= request.getParameter( "from" ) ;		
	String to						= request.getParameter( "to" ) ;			
	String from_bed_type_code		= "";
	String from_bed_type_desc		= "";
	String to_bed_type_code			= "";
	String to_bed_type_desc			= "";
	String eff_status				= "";
	String transfer_serv_charge		= "";
	StringBuffer	sqlQuery		= new StringBuffer();

	if ( (whereClause == null || whereClause.equals("")) )
	{
		/*	Parameter variable definition starts here
			variables that holds the data/values coming from the criteria screen
		*/
		from_bed_type_code			= request.getParameter("fr_bed_type_code");
		from_bed_type_desc			= request.getParameter("fr_bed_type_short_desc");
		to_bed_type_code			= request.getParameter("to_bed_type_code");
		to_bed_type_desc			= request.getParameter("to_bed_type_short_desc");
		eff_status					= request.getParameter("eff_status");
		/*Parameter variable definition ends here*/
		int andCheck = 0;

		if(from_bed_type_code!=null && !from_bed_type_code.equals(""))
		{
			if ( andCheck == 1 )
			{
			sql = sql + " and ";
			sql = "and fr_bed_type_code like '"+from_bed_type_code+"%'";
			}
			else
			{
				 sql = "where fr_bed_type_code like '"+from_bed_type_code+"%'";
				andCheck = 1;
			}
		}

		if(from_bed_type_desc!=null && !from_bed_type_desc.equals(""))
		{
				if( andCheck == 1 )
			{
				sql = sql + " and ";
				sql = sql + "fr_bed_type_short_desc like  '"+from_bed_type_desc+"%'" ;
			}
			else
			{
				 sql=" where fr_bed_type_short_desc like  '"+from_bed_type_desc+"%'" ;
				 andCheck = 1;

			}
		}

		if(to_bed_type_code!=null && !to_bed_type_code.equals(""))
		{
				if( andCheck == 1 )
			{
				sql = sql + " and ";
				sql = sql + "to_bed_type_code like  '"+to_bed_type_code+"%'" ;
			}
			else
			{
				   sql=" where to_bed_type_code like  '"+to_bed_type_code+"%'" ;
				   andCheck=1;
			
			}
		}

		if(to_bed_type_desc!=null && !to_bed_type_desc.equals(""))
		{
				if( andCheck == 1 )
			{
				sql = sql + " and ";
				sql = sql + "to_bed_type_short_desc like  '"+to_bed_type_desc+"%'" ;
			}
			else
			{
					 sql=" where to_bed_type_short_desc like  '"+to_bed_type_desc+"%'" ; 
					 andCheck=1;
			}
		}

		if ( eff_status.equals("E") )
		{
			if( andCheck == 1 )
			{
				sql=sql +" and ";
				sql = sql + " and eff_status='E'";
			}
			else
			{
				 sql="where eff_status='E'";
			}

		}
	   if (eff_status.equals("D") )
	    {
			if( andCheck == 1 )
			{
				sql=sql +" and ";
				sql = sql + " and eff_status='D'";
			}
			else
			{
				   sql="where eff_status='D'";
			}
		}


		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql+" order by ";

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql=sql+ord[i];
			else
				sql=sql+ord[i]+",";
			}
		}
	}
	else
	{
		sql=whereClause;
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

	Connection con = null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{
		con =ConnectionManager.getConnection(request); 
		sqlQuery.append("select count(*) as total from ip_transfer_charge_vw  "+sql);
		stmt=con.createStatement();
		rs = stmt.executeQuery(sqlQuery.toString());
		rs.next();
		maxRecord = rs.getInt("total");
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("select * from ip_transfer_charge_vw  "+sql);
		stmt=con.createStatement();
		rs = stmt.executeQuery(sqlQuery.toString());
		%>

		<P>
		<table align='right'>
			<tr>
				<td>
					<%
					if ( !(start <= 1) )
						out.println("<A HREF='../jsp/TransferChargeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					if ( !( (start+14) > maxRecord ) )
						out.println("<A HREF='../jsp/TransferChargeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

					%>
				</td>
			</tr>
		</table>
		</P>
		<br>
		<br>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th><fmt:message key="eIP.FromBedType.label" bundle="${ip_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.FromBedType.label" bundle="${ip_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.ToBedType.label" bundle="${ip_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.ToBedType.label" bundle="${ip_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.TransferServiceCharge.label" bundle="${ip_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
				<%
				if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
						rs.next() ;
					
				String classValue = "" ;

				while ( rs.next() && i<=end )
				{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;


							from_bed_type_code	=rs.getString("fr_bed_type_code");
							from_bed_type_desc	=rs.getString("fr_bed_type_short_desc");
							to_bed_type_code	=rs.getString("to_bed_type_code");
							to_bed_type_desc	=rs.getString("to_bed_type_short_desc");
							eff_status     		=rs.getString("eff_status");
							transfer_serv_charge=checkForNull(rs.getString("transfer_serv_charge"),"&nbsp;");
						out.println("<tr>");
						out.print("<td class='" + classValue + "'><a  href='../jsp/AddModifyTransferCharge.jsp?param=query&FR_BED_TYPE_CODE="+from_bed_type_code+"&to_bed_type_code="+to_bed_type_code+"' target='f_query_add_mod' >"+from_bed_type_code+"</a></td>");
						out.print("<td class='" + classValue + "'><a  href='../jsp/AddModifyTransferCharge.jsp?param=query&FR_BED_TYPE_CODE="+from_bed_type_code+"&to_bed_type_code="+to_bed_type_code+"' target='f_query_add_mod' >"+from_bed_type_desc+"</a></td>");
						out.print("<td class='" + classValue + "'><a  href='../jsp/AddModifyTransferCharge.jsp?param=query&FR_BED_TYPE_CODE="+from_bed_type_code+"&to_bed_type_code="+to_bed_type_code+"' target='f_query_add_mod' >"+to_bed_type_code+"</a></td>");
						out.print("<td class='" + classValue + "'><a  href='../jsp/AddModifyTransferCharge.jsp?param=query&FR_BED_TYPE_CODE="+from_bed_type_code+"&to_bed_type_code="+to_bed_type_code+"' target='f_query_add_mod' >"+to_bed_type_desc+"</a></td>");
						out.print("<td class='" + classValue + "'><a  href='../jsp/AddModifyTransferCharge.jsp?param=query&FR_BED_TYPE_CODE="+from_bed_type_code+"&to_bed_type_code="+to_bed_type_code+"' target='f_query_add_mod' >"+transfer_serv_charge+"</a></td>");
						out.print("<td align='center' class='" + classValue + "'>");
						 if(eff_status.equals("E"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("&nbsp;");
						out.println("</td>");
						out.print("</tr>");
						i++;
				}//endwhile
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			}
			catch(Exception e)
			{
				//out.print(e.toString());
				e.printStackTrace();
			}
			finally   
			{
				try {
					if(stmt!=null) 	stmt.close();
					if(rs!=null) 		rs.close();
					ConnectionManager.returnConnection(con,request); 
				}catch(Exception ee){/* out.println("Error while closing the conenctions :"+ee.toString()); */ ee.printStackTrace();}
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

