<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' OnMouseDown='CodeArrest()' onKeyDown='lockKey()';>");

	String whereClause = request.getParameter("whereclause");

	StringBuffer sql				= new StringBuffer();
	String from						= request.getParameter( "from" ) ;
	String to						= request.getParameter( "to" ) ;
	String setup_bl_dtls_in_ip_yn	= "N";
	String facilityId				= (String)session.getValue("facility_id");
	String blng_class_code			= "";
	String blng_class_desc			= "";
	String blng_serv_code			= "";
	String blng_serv_desc			= "";
    String dly_charge				= "";

	if ( (whereClause == null || whereClause.equals("")) )
	{
	
	if(sql.length() > 0) sql.delete(0,sql.length());
	String bedTypeCode = request.getParameter("bed_type_code");
	String bedTypeDesc = request.getParameter("bed_type_desc");
	String bedClassCode=request.getParameter("bed_class_code");
	String enabled = request.getParameter("enabled");
	String special_bed_type = request.getParameter("special_bed_type");
	String bedClassShortDesc=request.getParameter("bed_class_short_desc");
	
	bedTypeCode=bedTypeCode.toUpperCase();
	bedClassCode=bedClassCode.toUpperCase();

	int andCheck = 0;

	if ( !(bedTypeCode == null || bedTypeCode.equals("")) )
		{
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append("where  bed_type_code like '"+bedTypeCode+"%'");
		andCheck = 1;
		}

	if ( !(bedTypeDesc == null || bedTypeDesc.equals("")) )
	   {
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(bed_type_long_desc) like  upper('"+bedTypeDesc+"%')" );
		}
		else
		{
			
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where upper(bed_type_long_desc) like upper('"+bedTypeDesc+"%')" );
			andCheck = 1;
		}
	 }

	if ( !(bedClassCode == null || bedClassCode.equals("")) )
	    {
		 if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(bed_class_code) like  upper('"+bedClassCode+"%')" );
			}
		else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(bed_class_code) like upper('"+bedClassCode+"%')" );
				andCheck = 1;
			}
	}

		if ( !(bedClassShortDesc == null || bedClassShortDesc.equals("")) )
	    {
		 if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(bed_class_short_desc) like  upper('"+bedClassShortDesc+"%')" );
			}
		else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(bed_class_short_desc) like upper('"+bedClassShortDesc+"%')" );
				andCheck = 1;
			}
		}

	   if ( !(enabled == null || enabled.equals("")) )
	   {
		if ( enabled.equals("E") )
		{
			if ( andCheck == 0 ) 
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where eff_status='E'");
				andCheck = 1;
			}
			else
				sql.append(" and eff_status='E'");
		 }

		if ( enabled.equals("D") )
		 {
			if ( andCheck == 0 ) 
			{
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where  eff_status='D'");
				andCheck = 1;
			}
			else
				sql.append(" and eff_status='D'");
		  }
	}

	if ( !(special_bed_type == null || special_bed_type.equals("")) )
	{
		if ( special_bed_type.equals("Y") )
		{
			if ( andCheck == 0 ) 
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where SPECIAL_BED_TYPE_YN ='Y' ");
				andCheck = 1;
			}
			else
				sql.append(" and SPECIAL_BED_TYPE_YN ='Y' ");
		}

		if ( special_bed_type.equals("N") )
		{
			if ( andCheck == 0 ) 
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				//sql.append(" where SPECIAL_BED_TYPE_YN ='N' ");
				sql.append(" where (special_bed_type_yn = 'N' or special_bed_type_yn = '' or special_bed_type_yn is null) ");
				andCheck = 1;
			}
			else
			{
				//sql.append(" and SPECIAL_BED_TYPE_YN ='N'");
				sql.append(" and (special_bed_type_yn = 'N' or special_bed_type_yn = '' or special_bed_type_yn is null) ");
			}
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
			sql.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else{
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
	Statement stmt_bl_vw=null;
	//ResultSet rset=null;
	int maxRecord = 0;

	Statement stmt_bl=null;
	ResultSet rset_bl=null;
	ResultSet rs_bl_vw=null;
	ResultSet rs=null;
try{
	conn= ConnectionManager.getConnection(request); 
	stmt = conn.createStatement();
	stmt_bl_vw = conn.createStatement();

	stmt_bl = conn.createStatement();
	StringBuffer sql_bl = new StringBuffer();
	sql_bl.append("select setup_bl_dtls_in_ip_yn from ip_param where facility_id='"+facilityId+"' ");
	rset_bl = stmt_bl.executeQuery(sql_bl.toString());
	if(rset_bl!= null)
	{
		if(rset_bl.next())
		{		
			setup_bl_dtls_in_ip_yn = rset_bl.getString("setup_bl_dtls_in_ip_yn");
		}	
	}	

/*StringBuffer strsql1 = new StringBuffer();
strsql1.append(" select count(*) as total from IP_BED_TYPE_VW "+sql.toString());
rs = stmt.executeQuery(strsql1.toString());
rs.next();
maxRecord = rs.getInt("total");
if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}else{*/
StringBuffer strsql2 = new StringBuffer();
strsql2.append("select * from ip_bed_type_vw "+sql.toString());

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

				<p>
				<table align='right'>
				<tr>
				<%
					if ( !(start <= 1) )
						out.println("<td align ='right' id='prev'><A HREF='BedTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='BedTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					%>
				
				</tr>
				</table>
				</p>
				<br>
				<br>

				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<%if(setup_bl_dtls_in_ip_yn.equals("N"))
				{	%>
					<th><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/></th>
					<th><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/> Description</th>
					<th><fmt:message key="eIP.SpecialBedType.label" bundle="${ip_labels}"/></th>
					<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				<%	}
					else
					{	%>
						<th><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th> 
						<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/></th>
						<th><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="eIP.DailyCharge.label" bundle="${ip_labels}"/></th>
						<th><fmt:message key="eIP.SpecialBedType.label" bundle="${ip_labels}"/></th>
						<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				<%	}//end of else
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

							String effstatus	= rs.getString("eff_status");
							String SplBedstatus	= rs.getString("SPECIAL_BED_TYPE_YN");
							if ( SplBedstatus == null || SplBedstatus.equals("null")||SplBedstatus.equals(""))
								SplBedstatus="N";

							out.println("<tr><td class='" + classValue + "'>");
							String bed_type_code = rs.getString("bed_type_code");
							out.println("<a href='AddModifyBedType.jsp?bed_type_code="+ bed_type_code + "' target='f_query_add_mod' >");

							out.println(bed_type_code+"</a></td><td class='" + classValue + "' nowrap>");
							out.println(rs.getString("bed_type_long_desc")+"</td><td class='" + classValue + "' nowrap>");
							out.println(rs.getString("bed_type_short_desc") );
							out.println("</td><td class='" + classValue + "' nowrap>");
							out.println(rs.getString("bed_class_code") );
							out.println("</td><td class='" + classValue + "' nowrap>");
							out.println(rs.getString("bed_class_short_desc") );
							out.println("</td><td class='" + classValue + "' nowrap align='center'>");

							if(setup_bl_dtls_in_ip_yn.equals("Y"))
							{
								try
								{
									String sql_bl_vw=" select  blng_class_code,blng_class_desc,blng_serv_code,blng_serv_desc,dly_charge  from ip_bed_type where bed_type_code ='"+bed_type_code+"' ";
									rs_bl_vw = stmt_bl_vw.executeQuery(sql_bl_vw);
									rs_bl_vw.next();
									blng_class_code				= rs_bl_vw.getString("blng_class_code") == null ? "&nbsp;":rs_bl_vw.getString("blng_class_code");
									blng_class_desc				= rs_bl_vw.getString("blng_class_desc") == null ? "&nbsp;":rs_bl_vw.getString("blng_class_desc");
									blng_serv_code				= rs_bl_vw.getString("blng_serv_code") == null ? "&nbsp;":rs_bl_vw.getString("blng_serv_code");
									blng_serv_desc				= rs_bl_vw.getString("blng_serv_desc") == null ? "&nbsp;":rs_bl_vw.getString("blng_serv_desc");
									dly_charge				= rs_bl_vw.getString("dly_charge") == null ? "&nbsp;":rs_bl_vw.getString("dly_charge");
						
										out.println(blng_class_code+"</td><td  class='" + classValue + "' nowrap>");
										out.println(blng_class_desc+"</td><td  class='" + classValue + "' nowrap>");
										out.println(blng_serv_code+"</td><td  class='" + classValue + "' nowrap>");
										out.println(blng_serv_desc+"</td><td align='right' class='" + classValue + "' nowrap>");
										out.println(dly_charge+"</td><td  class='" + classValue + "' nowrap align='center'>");

								}catch(Exception e) {
									//out.println(e);
									e.printStackTrace();
									}
							}

							if(SplBedstatus.equals("Y"))
									out.println("<img src='../../eCommon/images/enabled.gif'></img></td><td  class='" + classValue + "' nowrap align='center'>");
							else
									out.println("<img src='../../eCommon/images/RRnwd.gif'></img></td><td class='" + classValue + "' nowrap align='center'>");


							if(effstatus.equals("E"))
									out.println("<img src='../../eCommon/images/enabled.gif'></img>");
							else
									out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
							out.println("</td>");
							out.println("</tr>");

							i++;
							maxRecord++;
							 blng_class_code="";
							 blng_class_desc="";
							 blng_serv_code="";
							 blng_serv_desc="";
							 dly_charge="";
		}
		%>

		</td></tr>
		</table>
		<br><center>

		<%
//}
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
	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		//if (rset != null) rset.close();
		if (rset_bl != null) rset_bl.close();
		if (rs != null) rs.close();
		if (rs_bl_vw != null) rs_bl_vw.close();
		if (stmt != null) stmt.close();
		if (stmt_bl != null) stmt_bl.close();
		if (stmt_bl_vw != null) stmt_bl_vw.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>

</center>
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

