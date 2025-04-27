<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
</head>
<BODY  class='CONTENT' onLoad='' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	
	<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String facilityId						= (String) session.getValue( "facility_id" ) ;
	String whereClause						= request.getParameter("whereclause");

	
	StringBuffer sql = new StringBuffer();									
	String from		= request.getParameter( "from" ) ;
	String to		= request.getParameter( "to" ) ;

	String  admission_type_code		="";
	String  admission_type_desc		="";
	String adm_type_ind				="";
	String eff_status				="";
	String admission_type_longdesc	="";
	String adm_type_ind_code[]		= {"","A","U","M","N","O","D"};
	String adm_type_ind_val[]		= {"--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---","Accident",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"),"Labour and Delivery",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels"),"Observation",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels")};

	Connection con = null;
	Statement stmt=null;
	Statement stmt_bl=null;
	Statement stmt_bl_interface=null;
	ResultSet rs=null;
	ResultSet rs_bl=null;
	ResultSet rs_bl_interface=null;

    String setup_bl_dtls_in_ip_yn="N";

	 String rounding_fee_yn="";        
	 String consumable_fee_yn="";      
	 String adm_wkup_fee_yn="";        
	 String rdng_blng_serv_code="";    
	 String cons_blng_serv_code="";    
	 String wkup_blng_serv_code="";  

try{
	con =ConnectionManager.getConnection(request); 
	stmt_bl_interface= con.createStatement();
	stmt_bl= con.createStatement();
	try
	{
		
		StringBuffer sql_bl_interface = new StringBuffer();
		sql_bl_interface.append("select setup_bl_dtls_in_ip_yn from ip_param where facility_id='"+facilityId+"' ");
		rs_bl_interface = stmt_bl_interface.executeQuery(sql_bl_interface.toString());
		if(rs_bl_interface!=null)
		{
			while(rs_bl_interface.next())
			 {
				setup_bl_dtls_in_ip_yn=rs_bl_interface.getString("setup_bl_dtls_in_ip_yn");
			 }
		}
	 }catch(Exception e){
	//out.print("Exception here1 :"+e);
	e.printStackTrace();
	}

	if ( (whereClause == null || whereClause.equals("")) )
	{
		/*	Parameter variable definition starts here
			variables that holds the data/values coming from the criteria screen
		*/
		admission_type_code	= request.getParameter("admission_type_code");
		admission_type_desc	= request.getParameter("admission_type_desc");
		adm_type_ind		= request.getParameter("adm_type_ind");
			if(adm_type_ind == null) adm_type_ind ="";
			
		eff_status			= request.getParameter("eff_status");
		
		admission_type_code = admission_type_code.toUpperCase();

		/*Parameter variable definition ends here*/
		int andCheck						 = 0;

		if(admission_type_code!=null && !admission_type_code.equals(""))
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" where upper(admission_type_code) like upper('"+admission_type_code+"%')");
			andCheck = 1;
		}

		if(admission_type_desc!=null && !admission_type_desc.equals(""))
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append(" upper(long_desc) like  upper('"+admission_type_desc+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where upper(long_desc) like upper('"+admission_type_desc+"%')" );
				andCheck = 1;
			}
		}

		if(!adm_type_ind.equals("All"))
		{
			if ( andCheck == 0 )
			{
				sql.append(" where upper(adm_type_ind)=upper('"+adm_type_ind+"')");
				andCheck = 1;
			}
			else
				sql.append(" and upper(adm_type_ind)=upper('"+adm_type_ind+"')");
		}
		
		if ( eff_status.equals("E") )
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
	   if ( eff_status.equals("D") )
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
		if(sql.length() > 0) sql.delete(0,sql.length());
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

	
	int maxRecord = 0;

	try
	{
		/*StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from ip_admission_type "+sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
		stmt.close();
		rs.close();

if(maxRecord == 0)
	{
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}else{*/
		StringBuffer strsql2 = new StringBuffer();
		strsql2.append("select * from ip_admission_type  "+sql.toString());
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
						out.println("<td align ='right' id='prev'><A HREF='../jsp/AdmissionTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/AdmissionTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					%>
				
			</tr>
		</table>
		</P>
		<br>
		<br>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<%if(setup_bl_dtls_in_ip_yn.equals("Y"))
			{%>
			<tr>
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>				
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="eIP.RoundingBillingService.label" bundle="${ip_labels}"/></th>
				<th ><fmt:message key="eIP.ConsumableBillingService.label" bundle="${ip_labels}"/></th>
				<th ><fmt:message key="eIP.WorkupBillingService.label" bundle="${ip_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
			
			<%}
			else
			{%>
			<tr>
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
				<%
			}
					}
				/*if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
						rs.next() ;*/

			String classValue = "" ;

			if(setup_bl_dtls_in_ip_yn.equals("Y"))
			{
				//while ( rs.next() && i<=end )
				//{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

							admission_type_code	=rs.getString("admission_type_code");
							admission_type_desc	=rs.getString("short_desc");
							admission_type_longdesc	=rs.getString("long_desc");
							adm_type_ind		=rs.getString("adm_type_ind");
							eff_status		=rs.getString("eff_status");
							rounding_fee_yn         =rs.getString("rounding_fee_yn");
							if(rounding_fee_yn==null)
								rounding_fee_yn="";
							rdng_blng_serv_code     =rs.getString("rdng_blng_serv_desc");
							if(rdng_blng_serv_code==null)
								rdng_blng_serv_code="";
							consumable_fee_yn       =rs.getString("consumable_fee_yn"); 
							if(consumable_fee_yn==null)
								consumable_fee_yn="";
							cons_blng_serv_code     =rs.getString("cons_blng_serv_desc");
							if(cons_blng_serv_code==null)
								cons_blng_serv_code="";
							adm_wkup_fee_yn         =rs.getString("adm_wkup_fee_yn");  
							if(adm_wkup_fee_yn==null)
								adm_wkup_fee_yn="";
							wkup_blng_serv_code     =rs.getString("wkup_blng_serv_desc"); 
							if(wkup_blng_serv_code==null)
								wkup_blng_serv_code="";
						
						out.println("<tr>");
						out.println("<td class='" + classValue + "'><a  href='../jsp/addModifyAdmissionType.jsp?admission_type_code="+admission_type_code+"' target='f_query_add_mod' >");
						out.println(admission_type_code+"</a></td>");
						out.print("<td class='" + classValue + "'>"+admission_type_longdesc+"</td>");
						out.print("<td class='" + classValue + "'>"+admission_type_desc+"</td>");

						String adm_type_ind_desc="";
						for(int kk=0;kk<adm_type_ind_val.length;kk++)
						{
							if(adm_type_ind_code[kk].equals(adm_type_ind))
							{
								adm_type_ind_desc=adm_type_ind_val[kk];
								break;
							}
						}
						out.print("<td class='" + classValue + "'>");
						out.print(adm_type_ind_desc+"</td>");
						if(setup_bl_dtls_in_ip_yn.equals("Y"))
						{
															
							out.print("<td class='" + classValue + "' nowrap >");
							if(!(rdng_blng_serv_code.equals("")))
							out.print(rdng_blng_serv_code+"</td>");
							else
							out.print("&nbsp;</td>");
							out.print("<td class='" + classValue + "'  nowrap>");
							if(!(cons_blng_serv_code.equals("")))
							out.print(cons_blng_serv_code+"</td>");
							else
							out.print("&nbsp;</td>");
							out.print("<td class='" + classValue + "'  nowrap>");
							if(!(wkup_blng_serv_code.equals("")))
							out.print(wkup_blng_serv_code+"</td>");
							else
							out.print("&nbsp;</td>");

						}
						out.print("<td class='" + classValue + "' align='center'>");
						if(eff_status.equals("E"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");
						out.print("</td>");
						out.print("</tr>");
						i++;
						maxRecord++;

				  //}//endwhile
				}
				else
				{	//while ( rs.next() && i<=end )
					//{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						admission_type_code	=rs.getString("admission_type_code");
						admission_type_desc	=rs.getString("short_desc");
						admission_type_longdesc	=rs.getString("long_desc");
						adm_type_ind		=rs.getString("adm_type_ind");
						eff_status		=rs.getString("eff_status");

						out.println("<tr>");
						out.println("<td class='" + classValue + "'><a  href='../jsp/addModifyAdmissionType.jsp?admission_type_code="+admission_type_code+"' target='f_query_add_mod' >");
						out.println(admission_type_code+"</a></td>");
						out.print("<td class='" + classValue + "'>"+admission_type_longdesc+"</td>");
						out.print("<td class='" + classValue + "'>"+admission_type_desc+"</td>");

						String adm_type_ind_desc="";
						for(int kk=0;kk<adm_type_ind_val.length;kk++)
						{
							if(adm_type_ind_code[kk].equals(adm_type_ind))
							{
								adm_type_ind_desc=adm_type_ind_val[kk];
								break;
							}
						}
						out.print("<td class='" + classValue + "'>");
						out.print(adm_type_ind_desc+"</td>");						
						out.print("<td class='" + classValue + "' align='center'>");
						if(eff_status.equals("E"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");
						out.print("</td>");
						out.print("</tr>");
						i++;
						maxRecord++;

				  	//}//endwhile				
				}
		}//endwhile
			

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

					if (rs != null) rs.close();
					if (rs_bl != null) rs_bl.close();
					if (rs_bl_interface != null) rs_bl_interface.close();

					if (stmt != null) stmt.close();
					if (stmt_bl != null) stmt_bl.close();
					if (stmt_bl_interface != null) stmt_bl_interface.close();


			}
			catch(Exception e)
			{
				//out.print("main try"+e.toString());
				e.printStackTrace();
			}

}catch(Exception e) {
	//out.println(e.toString());
	e.printStackTrace();
	}
finally
	{
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

