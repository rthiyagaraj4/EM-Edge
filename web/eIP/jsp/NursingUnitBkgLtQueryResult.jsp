<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String whereClause = request.getParameter("whereclause");
	String sql=""; ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String max_male_dly_booking="";
	String max_female_dly_booking="";
	String max_total_dly_booking="";
	String max_unknown_dly_booking="";

	if ((whereClause == null || whereClause.equals("")))
	{
		sql="";

		String nursingunitcode	= request.getParameter("nursing_unit_code");
		String nursingunitdesc	= request.getParameter("nursing_unit_short_desc");
		String bedclasscode	= request.getParameter("bed_class_code");
		String bedclassdesc	= request.getParameter("bed_class_short_desc");

		nursingunitcode		= nursingunitcode.toUpperCase();
	  	bedclasscode		= bedclasscode.toUpperCase();


		if ( !(nursingunitcode == null || nursingunitcode.equals("")) )
				sql = sql + " and upper(nursing_unit_code) like upper('"+nursingunitcode+"%')";

		if ( !(nursingunitdesc == null || nursingunitdesc.equals("")) )
				sql = sql + " and upper(nursing_unit_short_desc) like upper('"+nursingunitdesc+"%')";

		if ( !(bedclasscode == null || bedclasscode.equals("")) )
				sql = sql + " and upper(bed_class_code) like upper('"+bedclasscode+"%')";

		if ( !(bedclassdesc == null || bedclassdesc.equals("")) )
				sql = sql + " and upper(bed_class_short_desc) like upper('"+bedclassdesc+"%')";

		//appending order by clause
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
	} //end of where clause IF
	else
		sql = whereClause;

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
	ResultSet rs=null;
	int maxRecord = 0;

	try{
			conn = ConnectionManager.getConnection(request); 
			/*stmt = conn.createStatement();
			String strsql1="select count(*) as total from IP_BOOK_LIMIT_BY_NURS_UT_VW where facility_id = '"+facilityId+"' "+sql;
			rs = stmt.executeQuery(strsql1);
			rs.next();
			maxRecord = rs.getInt("total");
			if(rs!=null) 		rs.close();
			if(stmt!=null) 	stmt.close();

if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}
else
{
*/
		String strsql2="select * from IP_BOOK_LIMIT_BY_NURS_UT_VW where facility_id = '"+facilityId+"' "+sql;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		  }

		 while ( i<=end && rs.next()  )
			{
			  if (maxRecord==0)
					{
	%>

	<P>
	<table align='right'>
	<tr>
	
	<%
	if ( !(start <= 1) )
		out.println("<td align ='right' id='prev'><A HREF='NursingUnitBkgLtQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//if ( !( (start+14) > maxRecord ) )
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='NursingUnitBkgLtQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>
	
	</tr>
	</table>
	</P>
	<br>
	<br>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eIP.NursingUnitDescription.label" bundle="${ip_labels}"/></th>
	<th><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/></th>
	<th><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.maximum.label" bundle="${common_labels}"/> <fmt:message key="Common.male.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.maximum.label" bundle="${common_labels}"/> <fmt:message key="Common.female.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.maximum.label" bundle="${common_labels}"/> <fmt:message key="Common.unknown.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.maximum.label" bundle="${common_labels}"/> <fmt:message key="Common.total.label" bundle="${common_labels}"/></th>

	<%
					}
	/*if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		  }
		  */

		String classValue = "" ;

	//while ( rs.next() && i<=end )
	//{
		if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;

		String	ncode		= rs.getString("nursing_unit_code");
		String	ndesc		= rs.getString("nursing_unit_short_desc");
		String bcode		= rs.getString("bed_class_code");
		String bdesc		= rs.getString("bed_class_short_desc");
		/*
		int  max_unknown_dly_booking=rs.getInt("max_unknown_dly_booking");
		int maxmaledlybooking		= rs.getInt("max_male_dly_booking")  ;
		int maxfemaledlybooking	= rs.getInt("max_female_dly_booking");
		int maxtotaldlybooking		= rs.getInt("max_total_dly_booking") ;
		*/
		max_male_dly_booking	= String.valueOf(rs.getInt("max_male_dly_booking"));
					if(max_male_dly_booking.equals("0"))max_male_dly_booking="&nbsp;";
					max_female_dly_booking	= String.valueOf(rs.getInt("max_female_dly_booking"));
					if(max_female_dly_booking.equals("0"))max_female_dly_booking="&nbsp;";
					max_total_dly_booking	= String.valueOf(rs.getInt("max_total_dly_booking"));
					if(max_total_dly_booking.equals("0"))max_total_dly_booking="&nbsp;";
					max_unknown_dly_booking	= String.valueOf(rs.getInt("max_unknown_dly_booking"));
					if(max_unknown_dly_booking.equals("0"))max_unknown_dly_booking="&nbsp;";


		out.println("<tr><td class='" + classValue + "'>");
		out.println(ncode+"</td><td class='" + classValue + "'>");
		out.println(ndesc+"</td><td class='" + classValue + "'>");
		out.println(bcode+"</td><td class='" + classValue + "'>");
		out.println(bdesc+"</td><td class='" + classValue + "'>");
		out.println(max_male_dly_booking+"</td><td class='" + classValue + "'>");
		out.println(max_female_dly_booking+"</td><td class='" + classValue + "'>");
		out.println(max_unknown_dly_booking+"</td><td class='" + classValue + "'>");
		out.println(max_total_dly_booking+"</td></tr>");

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
		if(rs!=null) 		rs.close();
		if(stmt!=null) 	stmt.close();

	}catch(Exception e)
	{
		out.println(e);
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request); 
	}
%>

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

