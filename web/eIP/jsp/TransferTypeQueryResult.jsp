<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8"); 
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown='lockKey()';>");
	String whereClause				= request.getParameter("whereclause");

	String sql									="";													//Variable that holds where clause for that's dynamically constructed
	String from								= request.getParameter( "from" ) ;		
	//Variable that contains the number from which the display of the record starts
	String to									= request.getParameter( "to" ) ;			
	//Variable that contains the number from which the display of the record ends
	String  transfer_type_code		="";
	String  transfer_type_desc		="";
	String eff_status						="";
	String transfer_type_longdesc="";
	String charge_yn="";
	String sql_bl="";
	String blocking_type_desc="";

	String informd_dtls_yn = "";//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

	Connection con = null;
	Statement stmt=null;
	//ResultSet rset=null;
	ResultSet rs=null;
	Statement stmt_bl = null;
	Statement stmt_bl_interface = null;
	ResultSet rs_bl = null;
	ResultSet rs_bl_interface = null;
try{
	con = ConnectionManager.getConnection(request); 

	Boolean isCnrmReqPatOutChngAppl	= eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

  stmt_bl = con.createStatement();
  stmt_bl_interface= con.createStatement();
  String setup_bl_dtls_in_ip_yn="N";
  String facilityid=(String)session.getValue("facility_id");
  //added by shubha

		try{
							String sql_bl_interface="select setup_bl_dtls_in_ip_yn from ip_param where facility_id='"+facilityid+"' ";
							rs_bl_interface = stmt_bl_interface.executeQuery(sql_bl_interface);
							if(rs_bl_interface!=null )
							{
								while(rs_bl_interface.next())
								 {
										setup_bl_dtls_in_ip_yn=rs_bl_interface.getString("setup_bl_dtls_in_ip_yn");
								 }
							}
					  }catch(Exception e){
		/* out.print("Exception here1 :"+e); */ e.printStackTrace();}


	if ( (whereClause == null || whereClause.equals("")) )
	{
		/*	Parameter variable definition starts here
			variables that holds the data/values coming from the criteria screen
		*/
		transfer_type_code	=request.getParameter("transfer_type_code");
		transfer_type_desc  =request.getParameter("transfer_type_desc");
		blocking_type_desc	=request.getParameter("BLOKCING_TYPE_SHORT_DESC");

		informd_dtls_yn	=request.getParameter("informed_dtls_mand_yn");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

		eff_status					 =request.getParameter("eff_status");
		
		transfer_type_code=transfer_type_code.toUpperCase();
		
		
		/*Parameter variable definition ends here*/
		int andCheck						 = 0;

		if(transfer_type_code!=null && !transfer_type_code.equals(""))
		{
			sql = " where upper(transfer_type_code) like upper('"+transfer_type_code+"%')";
			andCheck = 1;
		}
		//check for blocking_type_desc
		if(blocking_type_desc!=null && !blocking_type_desc.equals(""))
		{
			if ( andCheck == 1 )
			{
			sql = sql + " and upper(BLOKCING_TYPE_SHORT_DESC) like upper('"+blocking_type_desc+"%')";
			}
			else
			{
			sql = " where upper(BLOKCING_TYPE_SHORT_DESC) like upper('"+blocking_type_desc+"%')";
			andCheck = 1;
			}
		}

		if(transfer_type_desc!=null && !transfer_type_desc.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql = sql + " and ";
				sql = sql + " upper(long_desc) like  upper('"+transfer_type_desc+"%')" ;
			}
			else
			{
				sql = " where upper(long_desc) like upper('"+transfer_type_desc+"%')" ;
				andCheck = 1;
			}
		}

		/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start*/
		if(isCnrmReqPatOutChngAppl)
		{
			if ( !(informd_dtls_yn == null || informd_dtls_yn.equals("")) )
			{
				if ( informd_dtls_yn.equals("Y") )
				{
					if ( andCheck == 0 )
					{
						sql = "where informed_dtls_mand_yn='Y'" ;
						andCheck = 1;}
			
					else
						sql	= sql + " and informed_dtls_mand_yn='Y' " ;
				}
				if ( informd_dtls_yn.equals("N") )
				{
					if ( andCheck == 0 )
					{
						sql = "where  informed_dtls_mand_yn='N'";
						andCheck = 1;}
					else
						sql = sql + "and informed_dtls_mand_yn='N'";
				}
			}
		}/*End*/

		if ( eff_status.equals("E") )
		{
			if ( andCheck == 0 )
			{
				sql = " where eff_status='E'";
				andCheck = 1;
			}
			else
				sql = sql + " and eff_status='E'";
		}
	   if ( eff_status.equals("D") )
	   {
			if ( andCheck == 0 )
			{
				sql = " where eff_status='D'";
				andCheck = 1;
			}
			else
			sql = sql + " and eff_status='D'";
		}


		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql + " order by ";

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

	int maxRecord = 0;
	
		/*String strsql1="select count(*) as total from ip_transfer_type_vw "+sql;
		stmt=con.createStatement();

		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");
		stmt.close();
		rs.close();
if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}else{*/
		String strsql2="select * from ip_transfer_type_vw  "+sql;
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;
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
						out.println("<td align ='right' id='prev'><A HREF='../jsp/TransferTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/TransferTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
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
				<th><fmt:message key="eIP.BlockingType.label" bundle="${ip_labels}"/></th>
				<th><fmt:message key="Common.Chargeable.label" bundle="${common_labels}"/></th>

				<% if(isCnrmReqPatOutChngAppl){ %>
				<th><fmt:message key="eIP.InformedDtlsMand.label" bundle="${ip_labels}"/></th><!--Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617-->
				<% } %>

				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
		<%}
		else
		{%>
			<tr>
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>				
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.BlockingType.label" bundle="${ip_labels}"/></th>
				
				<% if(isCnrmReqPatOutChngAppl){ %>
				<th><fmt:message key="eIP.InformedDtlsMand.label" bundle="${ip_labels}"/></th><!--Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617-->
				<% } %>

				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>

				<%
			}
					}
				/*if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
						rs.next() ;*/

						String classValue = "" ;

				//while ( rs.next() && i<=end )
				//{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;


							transfer_type_code			=rs.getString("transfer_type_code");
							transfer_type_desc			=rs.getString("short_desc");
							transfer_type_longdesc			=rs.getString("long_desc");
							blocking_type_desc			=rs.getString("BLOKCING_TYPE_SHORT_DESC");
							if(blocking_type_desc==null) blocking_type_desc="&nbsp";

							informd_dtls_yn				=rs.getString("informed_dtls_mand_yn");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617
							eff_status					=rs.getString("eff_status");

						out.println("<tr>");
						out.println("<td class='" + classValue + "'><a  href='../jsp/addModifyTransferType.jsp?transfer_type_code="+transfer_type_code+"' target='f_query_add_mod' >");
						out.println(transfer_type_code+"</a></td>");
						out.print("<td class='" + classValue + "'>"+transfer_type_longdesc+"</td>");
						out.print("<td class='" + classValue + "'>"+transfer_type_desc+"</td>");
						out.print("<td class='" + classValue + "'>"+blocking_type_desc+"</td>");

						if(setup_bl_dtls_in_ip_yn.equals("Y"))
						{
							try
							{
								sql_bl="select * from bl_ip_transfer_type where transfer_type_code='"+transfer_type_code+"' ";
								rs_bl = stmt_bl.executeQuery(sql_bl);
								if(rs_bl!=null)
								 {
									 while(rs_bl.next())
										{
											 charge_yn=rs_bl.getString("charge_yn");

									  }
								}
							 }catch(Exception e) {/* out.println("here2"+e); */ e.printStackTrace();}

						out.print("<td class='" + classValue + "' align='center'>");
						if(charge_yn.equals("Y"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");
						out.print("</td>");
				    }

						/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617*/
						if(isCnrmReqPatOutChngAppl)
						{
							out.println("</td><td class='" + classValue + "' align='center'>");
							if (informd_dtls_yn.equals("Y") )
								out.println("<img src='../../eCommon/images/enabled.gif'></img>");
							else
								out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
						}/*End*/

						out.print("<td class='" + classValue + "' align='center'>");
						if(eff_status.equals("E"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");
						out.print("</td>");
						out.print("</tr>");
					i++;
					maxRecord++;
					charge_yn="";
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
				//out.print("here3"+e.toString());
				e.printStackTrace();
			}
			finally
			{
					if(stmt_bl!=null) 	stmt_bl.close();
					if(stmt_bl_interface!=null) 	stmt_bl_interface.close();
					if(stmt!=null) 	stmt.close();
					if(rs!=null) 		rs.close();
					//if(rset!=null)		rset.close();
					if(rs_bl!=null)     rs_bl.close();
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

