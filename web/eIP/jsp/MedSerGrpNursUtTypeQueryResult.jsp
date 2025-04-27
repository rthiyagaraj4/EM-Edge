<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' onLoad='ClearMsg();' onMouseDown='CodeArrest()' onKeyDown='lockKey()';>");
	String facilityId					= (String) session.getValue( "facility_id" ) ;
	String whereClause				    = request.getParameter("whereclause");

	StringBuffer sql = new StringBuffer();								
	//Variable that holds where clause for that's dynamically constructed
	String from = request.getParameter( "from" ) ;		
	//Variable that contains the number from which the display of the record starts
	String to = request.getParameter( "to" ) ;		
	//Variable that contains the number from which the display of the record ends
	String  med_ser_grp_code		="";
	String  med_ser_grp_desc		="";
	String nursing_unit_type_code   ="";
	String nursing_unit_type_desc	="";
	
	if ( (whereClause == null || whereClause.equals("")) )
	{
		/*Parameter variable definition starts here
		  variables that holds the data/values coming from the criteria screen*/

		med_ser_grp_code	=request.getParameter("med_ser_grp_code");
		med_ser_grp_desc  =request.getParameter("med_ser_grp_desc");
		nursing_unit_type_code			=request.getParameter("nursing_unit_type_code");
		nursing_unit_type_desc=request.getParameter("nursing_unit_type_desc");
		
		med_ser_grp_code=med_ser_grp_code.toUpperCase();
		nursing_unit_type_code=nursing_unit_type_code.toUpperCase();

		if(med_ser_grp_code!=null && !med_ser_grp_code.equals(""))
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("and upper(MED_SER_GRP_CODE) like upper('"+med_ser_grp_code+"%')");
		}

		if(med_ser_grp_desc!=null && !med_ser_grp_desc.equals(""))
		{
				sql.append(" and ");
				sql.append("upper(MED_SER_GRP_short_DESC) like  upper('"+med_ser_grp_desc+"%')" );
		}

		if(nursing_unit_type_code!=null && !nursing_unit_type_code.equals(""))
		{
				sql.append(" and ");
				sql.append("upper(nursing_unit_type_code) like  upper('"+nursing_unit_type_code+"%')" );
		}

		if(nursing_unit_type_desc!=null && !nursing_unit_type_desc.equals(""))
		{
				sql.append(" and ");
				sql.append("upper(nursing_unit_type_short_desc) like  upper('"+nursing_unit_type_desc+"%')" );
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

	Connection con = null;
	Statement stmt=null;
	//ResultSet rset=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{	con = ConnectionManager.getConnection(request); 
		
		/*StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from Ip_med_ser_grp_nurs_ut_type_vw where facility_id = '"+facilityId+"' "+sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
		stmt.close();
		rs.close();
if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}else{*/
		StringBuffer strsql2 = new StringBuffer();
		strsql2.append("select * from Ip_med_ser_grp_nurs_ut_type_vw where facility_id = '"+facilityId+"'  "+sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2.toString());

		if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
			rs.next() ;

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
						out.println("<td align ='right' id='prev'><A HREF='../jsp/MedSerGrpNursUtTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/MedSerGrpNursUtTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					%>
				
			</tr>
		</table>
		</P>
		<br>
		<br>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th ><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			</tr>
				<%
					}
				/*if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
						rs.next() ;
				*/	
						String classValue = "" ;

				//while ( rs.next() && i<=end )
				//{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

							med_ser_grp_code			=rs.getString("MED_SER_GRP_CODE");
							med_ser_grp_desc			=rs.getString("MED_SER_GRP_short_DESC");
							nursing_unit_type_code				=rs.getString("NURSING_UNIT_TYPE_CODE");
							nursing_unit_type_desc		=rs.getString("NURSING_UNIT_TYPE_short_DESC");
						
							out.println("<tr>");
							out.println("<td class='" + classValue + "'><a  href='../jsp/addModifyMedSerGrpNursUtType.jsp?med_ser_grp_code="+med_ser_grp_code+"&nursing_unit_type_code="+nursing_unit_type_code+"' target='f_query_add_mod' >");
							out.println(med_ser_grp_code+"</a></td>");
							out.print("<td class='" + classValue + "'>"+med_ser_grp_desc+"</td>");
							out.print("<td class='" + classValue + "'>"+nursing_unit_type_code+"</td>");
							out.print("<td class='" + classValue + "'>"+nursing_unit_type_desc+"</td>");
							out.print("</tr>");
							i++;
							maxRecord++;
			}//endwhile
			//}
							if(maxRecord == 0)
							{
								out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
							}

						
							if ( maxRecord < 14 || (!rs.next()) )
								{
										%>
									<script >
										if (document.getElementById("next"))
											document.getElementById("next").style.visibility='hidden';
									</script>
										<% 
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
										
			}
			catch(Exception e)
			{
				out.print(e.toString());
			}
			finally   
			{
					if(stmt!=null) 	stmt.close();
					if(rs!=null) 		rs.close();
					//if(rset!=null)		rset.close();
					ConnectionManager.returnConnection(con,request);
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

