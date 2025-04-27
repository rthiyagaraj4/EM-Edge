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
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' onKeyDown='lockKey()' OnMouseDown='CodeArrest()';>");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String whereClause = request.getParameter("whereclause");

	StringBuffer sql = new StringBuffer();
	String from		= request.getParameter( "from" ) ;
	String to		= request.getParameter( "to" ) ;
	int andCheck	= 0;
	String deposit	= "";
	String finalamt	= "";
	String setup_bl_dtls_in_ip_yn	= "N";
	String ALLOW_BED_SWAP_YN		= "";

	if ((whereClause == null || whereClause.equals("")))
	{
		if(sql.length() > 0) sql.delete(0,sql.length());

		String bedclasscode		= request.getParameter("bed_class_code");
		String shortdesc		= request.getParameter("short_desc");
		String enabled			= request.getParameter("enabled");
		ALLOW_BED_SWAP_YN		= request.getParameter("ALLOW_BED_SWAP_YN");

		bedclasscode		=	bedclasscode.toUpperCase();

		if ( !(bedclasscode == null || bedclasscode.equals("")) )
		{
				sql.append(" where upper(bed_class_code) like upper('"+bedclasscode+"%') ");
				andCheck = 1;
		}

		if ( !(shortdesc == null || shortdesc.equals("")) )
		{
				if ( andCheck == 1 )
				{
					sql.append(" and ");
					sql.append("upper(long_desc) like  upper('"+shortdesc+"%')" );
				}
				else
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" where upper(long_desc) like upper('"+shortdesc+"%')" );
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

	if ( !(ALLOW_BED_SWAP_YN == null || ALLOW_BED_SWAP_YN.equals("")) )
	{
	   if ( ALLOW_BED_SWAP_YN.equals("Y") )
	   {
			if ( andCheck == 0 ) 
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where ALLOW_BED_SWAP_YN='Y'");
				andCheck = 1;
			}
			else
				sql.append(" and ALLOW_BED_SWAP_YN='Y'");
	   }
	   if ( ALLOW_BED_SWAP_YN.equals("N") )
	   {
			if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where  ALLOW_BED_SWAP_YN='N'");
				andCheck = 1;
			}
			else
				sql.append(" and ALLOW_BED_SWAP_YN='N'");
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
	}
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
	ResultSet rs=null;
	int maxRecord = 0;

	Statement stmt_bl=null;
	ResultSet rset_bl=null;
	ResultSet rs_bl=null;
	StringBuffer sql_bl_bed = new StringBuffer();
	try{
	conn = ConnectionManager.getConnection(request); 
	stmt_bl = conn.createStatement();
	StringBuffer sql_bl = new StringBuffer();
	sql_bl.append("select setup_bl_dtls_in_ip_yn from ip_param where facility_id='"+facilityId+"' ");
	rset_bl = stmt_bl.executeQuery(sql_bl.toString());

	if(rset_bl!=null)
	{
		if(rset_bl.next())
		{
			setup_bl_dtls_in_ip_yn = rset_bl.getString("setup_bl_dtls_in_ip_yn");
		}
	}
		if (rset_bl != null) rset_bl.close();
		if (stmt_bl != null) stmt_bl.close();

			stmt = conn.createStatement();
			/*StringBuffer strsql1 = new StringBuffer();
			strsql1.append("select count(*) as total from ip_bed_class "+sql.toString());
			rs = stmt.executeQuery(strsql1.toString());
			rs.next();
			maxRecord = rs.getInt("total");
if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}else{*/
			StringBuffer strsql2 = new StringBuffer();
			strsql2.append("select bed_class_code,long_desc,short_desc,eff_status,ALLOW_BED_SWAP_YN from ip_bed_class "+sql.toString());
			rs = stmt.executeQuery(strsql2.toString());

			if ( start != 1 )
			 for( int j=1; j<start; i++,j++ )
			 {
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
						out.println("<td align ='right' id='prev'><A HREF='../jsp/BedClassQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/BedClassQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					%>
					
					</tr>
					</table>
					</P>
					<br>
					<br>
				  <%if(setup_bl_dtls_in_ip_yn.equals("Y")){%>
					<table border="1" width="100%" cellspacing='0' cellpadding='0' >
					<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eIP.DepositAmount.label" bundle="${ip_labels}"/></th>
					<th><fmt:message key="eIP.AdditionalDepositAmount.label" bundle="${ip_labels}"/></th>
					<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
					<%}
					else
					{%>
					<table border="1" width="100%" cellspacing='0' cellpadding='0' >
					<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eIP.AllowBedSwap.label" bundle="${ip_labels}"/></th>
					<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>					
	<%
					}
				}
	
	/*if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	 {
		rs.next() ;
	 }*/

					String classValue = "" ;

	//if(rs != null)
	//{
		//while ( rs.next() && i<=end )
		//{

					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					String	bedclasscode	= rs.getString("bed_class_code");
					String effstatus		= rs.getString("eff_status");
					String allowbedSwap_yn	= rs.getString("ALLOW_BED_SWAP_YN");

					if(setup_bl_dtls_in_ip_yn.equals("Y"))
					{
						if(sql_bl_bed.length() > 0) sql_bl_bed.delete(0,sql_bl_bed.length());
						sql_bl_bed.append("select * from bl_ip_bed_class where bed_class_code='"+bedclasscode+"' ");
						stmt_bl = conn.createStatement();
						rs_bl = stmt_bl.executeQuery(sql_bl_bed.toString());
						if(rs_bl!=null)
						 {
							while(rs_bl.next())
							{
									deposit	 	= rs.getString("DEPOSIT_AMOUNT_NORMAL") == null ? "&nbsp;":rs.getString("deposit_amount_normal");
									
									finalamt 	= rs.getString("DEPOSIT_CHARGE_SURGERY") == null? "&nbsp;":rs.getString("deposit_charge_surgery");
							}
						 }
						if (rset_bl != null) rset_bl.close();
						if (stmt_bl != null) stmt_bl.close();
					}	 

					out.println("<tr><td class='" + classValue + "'>");
					out.println("<a href='../jsp/AddModifyBedClass.jsp?bed_class_code="+bedclasscode+"' target='f_query_add_mod' >");
					out.println(bedclasscode+"</a></td><td class='" + classValue + "'>");
					out.println(rs.getString("long_desc")+"</td><td class='" + classValue + "'>");
					out.println(rs.getString("short_desc")+"</td><td  align='center' class='" + classValue + "'>");
			
					if(setup_bl_dtls_in_ip_yn.equals("Y"))
					{
						out.println(deposit+"</td><td align='right' class='" + classValue + "'>");
						out.println(finalamt+"</td><td align='center' class='" + classValue + "'>");
					}

					if(allowbedSwap_yn.equals("Y"))
						out.println("<img src='../../eCommon/images/enabled.gif'></img></td><td align='center' class='" + classValue + "'>");
					else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img></td><td align='center' class='" + classValue + "'>");
					
						
					if(effstatus.equals("E"))
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
					
					i++;
					deposit="";
					finalamt="";
					maxRecord++;
				}//endwhile
	//}
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

	}catch(Exception e){
		//e.toString();
		e.printStackTrace();
	}	
	finally 
	{
		if(stmt!=null) 		stmt.close();
		if(stmt_bl!=null) 	stmt_bl.close();

		if(rs!=null) 		rs.close();
		if(rs_bl!=null) 	rs_bl.close();
		if(rset_bl!=null) 	rset_bl.close();
		
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

