<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown='lockKey()';>");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ((whereClause == null || whereClause.equals("")))
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
		String medsergrpcode = request.getParameter("med_ser_grp_code");
		String shortdesc = request.getParameter("long_desc");
		String effstatus = request.getParameter("eff_status");

	//Added BY SRIDHAR on 11 MAY 2004
	//Nursing Unit Applicable To either INPATIENT or DAY CARE 
		String applicable_to = request.getParameter("applicable_to");
		if (applicable_to == null || applicable_to.equals("")) applicable_to="";

		medsergrpcode=medsergrpcode.toUpperCase();
		shortdesc=shortdesc.toUpperCase();

		if ( !(medsergrpcode == null || medsergrpcode.equals("")) )
				sql.append(" and upper(med_ser_grp_code) like upper('"+medsergrpcode+"%')");

		if ( !(shortdesc == null || shortdesc.equals("")) )
				sql.append(" and upper(a.long_desc) like upper('"+shortdesc+"%')");

//Added BY SRIDHAR on 11 MAY 2004
//Nursing Unit Applicable To either INPATIENT or DAY CARE 

		if ( !(applicable_to == null || applicable_to.equals("")) )
		sql.append(" and upper(APPL_PATIENT_CLASS) like upper('"+applicable_to+"%')");


		if ( !(effstatus == null || effstatus.equals("")) )
		{
		   if ( effstatus.equals("E") )
				sql.append(" and eff_status='E'");
		   if ( effstatus.equals("D") )
				sql.append(" and eff_status='D'");
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
				sql.append(ord[i]+",");
			}
		}
	} //end of where clause IF
	else
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

	Connection conn = null;
	Statement stmt=null;
	//ResultSet rset=null;
	ResultSet rs=null;
	int maxRecord = 0;


	try{		
			conn = ConnectionManager.getConnection(request);
			/*stmt = conn.createStatement();
			StringBuffer strsql1 = new StringBuffer();
			strsql1.append("select count(*) as total from ip_medical_service_group a where facility_id = '"+facilityId+"' "+sql.toString());
			rs = stmt.executeQuery(strsql1.toString());
			rs.next();
			maxRecord = rs.getInt("total");
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
	}else
	{
			*/
			StringBuffer strsql2 = new StringBuffer();
			strsql2.append("select a.med_ser_grp_code med_ser_grp_code, a.long_desc long_desc, a.short_desc short_desc, a.appl_patient_class appl_patient_class, a.eff_status eff_status, b.short_desc patient_class from ip_medical_service_group a, am_patient_class b where a.facility_id = '"+facilityId+"' and b.patient_class (+) = a.appl_patient_class "+sql.toString());
			stmt = conn.createStatement();
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
		out.println("<td align ='right' id='prev'><A HREF='../jsp/MedicalServiceGrpQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//if ( !( (start+14) > maxRecord ) )
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/MedicalServiceGrpQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>
	
	</tr>
	</table>
	</P>
	<br>
	<br>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<!-- 	<th>Applicable To</th>
 -->	
 <th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

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

			String	 medsergrpcode = rs.getString("med_ser_grp_code");
			String	 ApplicableTo = rs.getString("patient_class");
				if(ApplicableTo == null) ApplicableTo = "&nbsp;";

			String effstatus = rs.getString("eff_status");

			out.println("<tr><td class='" + classValue + "'>");
			out.println("<a href='../jsp/addModifyMedicalServiceGrp.jsp?med_ser_grp_code="+medsergrpcode+"&facility_id="+facilityId+"' target='f_query_add_mod' >");
			out.println(medsergrpcode+"</a></td><td class='" + classValue + "'>");
			out.println(rs.getString("LONG_DESC")+"</td><td class='" + classValue + "'>");
			out.println(rs.getString("SHORT_DESC")+"</td><td align='center' class='" + classValue + "'>");
			//out.println(ApplicableTo+"</td><td align='center' class='" + classValue + "'>");
			if(effstatus.equals("E"))
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");

			i++;
			maxRecord++;
			}//endwhile
		//if (rs != null) rs.close();
		//if (stmt != null) stmt.close();
//}
			if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
				}

						
				if ( maxRecord < 14 || (!rs.next()) )
					{
							%>
						<script >
							if (document.getElementById('next'))
								document.getElementById('next').style.visibility='hidden';
						</script>
							<% 
						}
						else
						{%>
						<script >
							if (document.getElementById('next'))
								document.getElementById('next').style.visibility='visible';
						</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



						<%
						}
	}catch(Exception e){
		e.toString();
		out.println(e);
	}	finally   {
		if(stmt!=null) 	stmt.close();
		if(rs!=null) 		rs.close();
		//if(rset!=null)		rset.close();
		ConnectionManager.returnConnection(conn,request);
		}
%>

</td></tr>
</table>
</BODY>
</HTML>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>

