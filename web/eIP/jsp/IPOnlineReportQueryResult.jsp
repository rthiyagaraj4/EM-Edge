<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' class='CONTENT' onLoad='ClearMsg()'>");

	String whereClause = request.getParameter("whereclause");

	StringBuffer sql = new StringBuffer();

	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	if(sql.length() > 0) sql.delete(0,sql.length());
		
	  String nursingunitcode		= request.getParameter("nursing_unit_code") ;    
	  if ( (nursingunitcode == null || nursingunitcode.equals("")) )
		  nursingunitcode= "";
	  String nursingunitdesc		= request.getParameter("nursing_unit_desc");
	  if ( (nursingunitdesc == null || nursingunitdesc.equals("")) )
		  nursingunitdesc= "";
	  String reportid			= request.getParameter("report_id") ;      
	   if ( (reportid == null || reportid.equals("")) )
		  reportid= "";
	  String reportdesc			= request.getParameter("report_desc");
	    if ( (reportdesc == null || reportdesc.equals("")) )
		  reportdesc= "";
	  String printonbookingyn		= request.getParameter("print_on_booking_yn") ;     
	    if ( (printonbookingyn == null || printonbookingyn.equals("")) )
		  printonbookingyn= "";
	  String printonadmissionyn		= request.getParameter("print_on_admission_yn") ;  
	      if ( (printonadmissionyn == null || printonadmissionyn.equals("")) )
		  printonadmissionyn= "";

	  String printontransferrequestyn	= request.getParameter("print_on_transfer_request_yn") ;
	   if ( (printontransferrequestyn == null || printontransferrequestyn.equals("")) )
		  printontransferrequestyn= "";

	  String printonconformtransferyn	= request.getParameter("print_on_conform_transfer_yn") ;
	    if ( (printonconformtransferyn == null || printonconformtransferyn.equals("")) )
		  printonconformtransferyn= "";
	  String printonbedassignedyn		= request.getParameter("print_on_bed_assigned_yn") ;  
	    if ( (printonbedassignedyn == null || printonbedassignedyn.equals("")) )
		  printonbedassignedyn= "";
	  
	  String printondischargeyn		= request.getParameter("print_on_discharge_yn") ;   
	     if ( (printondischargeyn == null || printondischargeyn.equals("")) )
		  printondischargeyn= "";

		  String print_on_disch_adv_yn		= request.getParameter("print_on_disch_adv_yn") ;   
	     if ( (print_on_disch_adv_yn == null || print_on_disch_adv_yn.equals("")) )
		  print_on_disch_adv_yn= "";
	  
	  nursingunitcode			= nursingunitcode.toUpperCase();
	  reportid				= reportid.toUpperCase();
	  
		nursingunitcode=nursingunitcode.toUpperCase();

		if ( !(nursingunitcode == null || nursingunitcode.equals("")) )
		{
			   sql.append(" and nursing_unit_code like upper('"+nursingunitcode+"%') ");
		}

		if ( !(nursingunitdesc == null || nursingunitdesc.equals("")) )
		{
			   sql.append(" and upper(nursing_unit_short_desc)  like upper('"+nursingunitdesc+"%')");
		}

		if ( !(reportid == null || reportid.equals("")) )
		{
			 	sql.append(" and upper(report_id)  like upper('"+reportid+"%') ");
		}

		if ( !(reportdesc == null || reportdesc.equals("")) )
		{
			 	sql.append(" and upper(report_desc)  like upper('"+reportdesc+"%') ");
		}

		if ( !(printonbookingyn == null || printonbookingyn.equals("")) )
		{
			   if ( printonbookingyn.equals("Y") )
			   {
						sql.append(" and print_on_booking_yn='Y'");
				}
				if ( printonbookingyn.equals("N") )
				{
						sql.append(" and print_on_booking_yn='N'");
				}
		}

		if ( !(printonadmissionyn == null || printonadmissionyn.equals("")) )
		{
			   if ( printonadmissionyn.equals("Y") )
			   {
						sql.append(" and print_on_admission_yn='Y'");
				}
				if ( printonadmissionyn.equals("N") )
				{
						sql.append(" and print_on_admission_yn='N'");
				}
		}

		if ( !(printontransferrequestyn == null || printontransferrequestyn.equals("")) )
		{
			   if ( printontransferrequestyn.equals("Y") )
			   {
						sql.append(" and print_on_transfer_request_yn='Y'");
				}
				if ( printontransferrequestyn.equals("N") )
				{
						sql.append(" and print_on_transfer_request_yn='N'");
				}
		}

		if ( !(printonconformtransferyn == null || printonconformtransferyn.equals("")) )
		{
			   if ( printonconformtransferyn.equals("Y") )
			   {
						sql.append(" and print_on_conform_transfer_yn='Y'");
				}
				if ( printonconformtransferyn.equals("N") )
				{
						sql.append(" and print_on_conform_transfer_yn='N'");
				}
		}

		if ( !(printonbedassignedyn == null || printonbedassignedyn.equals("")) )
		{
			   if ( printonbedassignedyn.equals("Y") )
			   {
						sql.append(" and print_on_bed_assigned_yn='Y'");
				}
				if ( printonbedassignedyn.equals("N") )
				{
						sql.append(" and print_on_bed_assigned_yn='N'");
				}
		}

		if ( !(printondischargeyn == null || printondischargeyn.equals("")) )
		{
			   if ( printondischargeyn.equals("Y") )
			   {
					sql.append(" and print_on_discharge_yn='Y'");
				}
				if ( printondischargeyn.equals("N") )
				{
					sql.append(" and print_on_discharge_yn='N'");
				}
		}
		if ( !(print_on_disch_adv_yn == null || print_on_disch_adv_yn.equals("")) )
		{
			   if ( print_on_disch_adv_yn.equals("Y") )
			   {
					sql.append(" and print_on_disch_adv_yn='Y'");
				}
				if ( print_on_disch_adv_yn.equals("N") )
				{
					sql.append(" and print_on_disch_adv_yn='N'");
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
	} //end of where clause IF
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

	Statement stmt=null;
	ResultSet rs=null;
	Connection conn=null;
	int maxRecord = 0;

	try{

		conn = ConnectionManager.getConnection(request); ;
		String facilityId = (String)session.getValue("facility_id");
		/*stmt = conn.createStatement();
		StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from ip_online_report_vw where facility_id='"+facilityId+"' "+sql.toString());
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");*/
		StringBuffer strsql2 = new StringBuffer();
		strsql2.append("select * from ip_online_report_vw where facility_id='"+facilityId+"' "+sql.toString());
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
		<p>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eIP/jsp/IPOnlineReportQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eIP/jsp/IPOnlineReportQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

	%>
		
		</tr>
		</table>
		</p>
		<br>
		<br>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<!-- <th>Nursing Unit Code</th>
		<th>Nursing Unit Description</th>
		<th>Report ID</th>
		<th>Report Description</th>
		<th>Booking</th>
		<th>Transfer Request</th>
		<th>Admission Without Bed</th>
		<th>Transfer Confirmation</th>
		<th>Admission With Bed</th>
		<th>Discharge</th> --><!-- Booking  Admission  Assign Bed  Transfer Patient  Discharge  -->
		<th><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eIP.NursingUnitDescription.label" bundle="${ip_labels}"/></th>
		<th><fmt:message key="Common.ReportID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.booking.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.admission.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.AssignBed.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eIP.TransferRequest.label" bundle="${ip_labels}"/></th>
		<th><fmt:message key="Common.TransferPatient.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></th>
		


	<%
				}
		 /* if ( start != 1 )
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
			  

			String nursingunitcode = rs.getString("nursing_unit_code");
			String reportid = rs.getString("report_id");

			out.println("<tr><td class='" + classValue + "'>");

			out.println(nursingunitcode);
			out.println("</td><td class='" + classValue + "'>");

			out.println(rs.getString("nursing_unit_short_desc"));
			out.println("</td><td class='" + classValue + "'>");

			out.println( reportid);
			out.println("</td><td class='" + classValue + "'>");

			out.println( rs.getString("report_desc"));
			out.println("</td><td class='" + classValue + "' align='center'>");
			if ( rs.getString("print_on_booking_yn").equals("N") )
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			out.println("</td><td class='" + classValue + "' align='center'>");
			if ( rs.getString("print_on_admission_yn").equals("N") )
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			out.println("</td><td class='" + classValue + "' align='center'>");
			if ( rs.getString("print_on_bed_assigned_yn").equals("N") )
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			out.println("</td><td class='" + classValue + "' align='center'>");


				if ( rs.getString("print_on_transfer_request_yn").equals("N") )
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			out.println("</td><td class='" + classValue + "' align='center'>");
			
			
			if ( rs.getString("print_on_conform_transfer_yn").equals("N") )
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			out.println("</td><td class='" + classValue + "' align='center'>");


				if ( rs.getString("print_on_disch_adv_yn").equals("N") )
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			    out.println("</td><td class='" + classValue + "' align='center'>");

			
			if ( rs.getString("print_on_discharge_yn").equals("N") )
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			    out.println("</td><td class='" + classValue + "' align='center'>");
			i++;
			maxRecord++;

	  }//endwhile
			//if(rs!=null)	rs.close();
			//if(stmt!=null)	stmt.close();
			if(maxRecord == 0)
			{
				out.println("<script src='../../eCommon/js/common.js' language='javascript'></script>");
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
				out.print(e.toString());
	   }
		finally {
			try{
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs.close();
			}
			catch(Exception e)
			{out.println("Exception in tryCatch : "+ e.toString());}
			ConnectionManager.returnConnection(conn,request); ;
		}
%>

</td></tr>
</table>
<br><center>

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

