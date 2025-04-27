<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
       request.setCharacterEncoding("UTF-8");
%>
<html>

<%
	String qry = request.getParameter("qry");
	if(qry.equals("Y")) 
	{
		String Facility_Id  = (String) session.getValue("facility_id");
		String type     = request.getParameter("type");
		String locale=(String)session.getAttribute("LOCALE");
		String serv_code= request.getParameter("serv_code");
		String cln_code = request.getParameter("cln_code");
		String ent_date = request.getParameter("ent_date");
		String speciality_code = request.getParameter("speciality_code");
		String L_Table_Heading="";
		String L_Col_Title="";
		StringBuffer sql=new StringBuffer();
		StringBuffer mainsql= new StringBuffer();

		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;

		int start = 0 ;
		int end = 0 ;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = 14 ;
		else
			end = Integer.parseInt( to ) ;

		try 
		{
			sql.append(" where  facility_id='"+Facility_Id+"' and patient_class = 'OP' and");
			sql.append( " to_char(queue_date,'mm/yyyy') = '"+ent_date+"' ");

			if (serv_code != null && !serv_code.equals("")){
				sql.append( " and service_code = '"+serv_code+"' ");
			}
			if (cln_code != null && !cln_code.equals("")){
				sql.append( " and locn_code = '"+cln_code+"' ");
			}
			if (speciality_code != null && !speciality_code.equals("")){
				sql.append( " and SPECIALITY_CODE ='"+speciality_code+"' ");
			}

		    if(type.equals("A")){
				L_Table_Heading = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.StatisticsBySplty.label","op_labels");
				L_Col_Title     = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");						
				sql.append( " GROUP BY am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2) order by 1");
			} else if(type.equals("S")){
				L_Table_Heading = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.StatisticsbyService.label","op_labels");
				L_Col_Title     = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels");									
				sql.append( " GROUP BY am_get_desc.AM_SERVICE(service_code,'"+locale+"',2) order by 1");
			}else{		
				L_Table_Heading     = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.StatisticsbyLocation.label","op_labels");
				L_Col_Title     = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels");
				sql.append( " GROUP BY op_get_desc.op_clinic(facility_id,locn_code,'"+locale+"',1) order by 1");
			}		
		}
		catch(Exception e) { out.print(e); e.printStackTrace();}

%>
	<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/rowcolor.js' language='javascript'></script>

<SCRIPT LANGUAGE="JavaScript">

function clearmsg()
{
    parent.parent.frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num= ';
}
</SCRIPT>
<head>
<%

	Connection conn =null;
	Statement stmt = null;
	ResultSet rset=null; 

	try
	{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		String maxRecord = "1";

		if(type.equals("A")) {
			mainsql.append("SELECT   am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)  sdesc,  ");        
		}else if(type.equals("S")) {
			mainsql.append("SELECT   am_get_desc.AM_SERVICE(service_code,'"+locale+"',2) sdesc, "); 
		}else{
			mainsql.append("SELECT   op_get_desc.op_clinic(facility_id,locn_code,'"+locale+"',1) sdesc,  ");
		}
		mainsql.append (" SUM (DECODE (queue_status, 'XX', 0, 1)) Totat_Visits,SUM (DECODE (queue_status, '99', 1, 0)) Cancelled_Visits,SUM (DECODE (queue_status, '04', 1, 0)) Attended_Not_CheckedOut,SUM(case when CONS_SRVC_START_DATE_TIME is not null then DECODE (queue_status, '07', 1, 0)  else 0 end) Consulted_CheckedOut,SUM(case when CONS_SRVC_START_DATE_TIME is not null then DECODE (queue_status, '09', 1, 0)  else 0 end) Attended_Auto_CheckedOut,         SUM (DECODE (queue_status, '01', 1, '02', 1,'03',1, 0)) Not_Attended,SUM(case when CONS_SRVC_START_DATE_TIME is null then DECODE (queue_status, '09', 1, 0)  else 0 end) Not_Attended_Auto_CheckedOut,SUM(case when CONS_SRVC_START_DATE_TIME is null then DECODE (queue_status, '07', 1, 0)  else 0 end) Not_Attended_CheckedOut  from op_patient_queue ");
		mainsql.append(sql);
		//out.println("mainsql.toString(): "+mainsql.toString());
		rset = stmt.executeQuery(mainsql.toString());

	%>
	   <%
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




		</head>
		<body onload='clearmsg();' onKeyDown = 'lockKey();'>
		<form name='result_form' id='result_form'>
			<P>
			<br>
			</P>

	<%
		int count=0;
		String classValue = "";
		/*String sdesc="";
		String tatnd="";
		String natnd="";
		String disch="";*/
		int i = 1;
		
		if(rset != null) 
		{		
			if ( start != 1 )
				 for( int j=1; j<start; i++,j++ )
					  rset.next() ;

			while(rset.next() && i<=end){
				if ( i%2 == 0 )
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
				%><%
				if(count == 0){%>
					<table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>

					<tr>
					<td class='label' width='20%'><b><%=L_Table_Heading%></b></td>
					<td  class='label' width='75%'>&nbsp;</td>
					<%
					if ( !(start <= 1) )
						out.println("<td class='label' width='5%' align='right'><A HREF='../../eOP/jsp/OPStatQueryResult.jsp?qry=Y&type="+type+"&serv_code="+serv_code+"&cln_code="+cln_code+"&speciality_code="+speciality_code+"&ent_date="+ent_date+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			
					if (maxRecord.equals("1"))
						out.println("<td class='label' width='5%' align='right'><A  id='nextval' HREF='../../eOP/jsp/OPStatQueryResult.jsp?qry=Y&type="+type+"&serv_code="+serv_code+"&cln_code="+cln_code+"&speciality_code="+speciality_code+"&ent_date="+ent_date+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					%>
					</td>
					</tr>
					</table>
					<table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
					<tr><td align='center'>
					<table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
					<th class='columnheader' align='center' width="20%" rowspan="3"><%=L_Col_Title%></td>					
					<th class='columnheader' align='center' width="10%" rowspan="3" ><fmt:message key="eOP.TotalVisits.label" bundle="${op_labels}"/></th>
					<th class='columnheader' align='center' width="10%" rowspan="3"><fmt:message key="eOP.CancelledVisits.label" bundle="${op_labels}"/></th>
					<th class='columnheader' align='center' width="30%"  colspan="3"><fmt:message key="eOP.Attended.label" bundle="${op_labels}"/></th>					
					<th class='columnheader' align='center' width="30%"   colspan="3"><fmt:message key="eOP.notattended.label" bundle="${op_labels}"/></th>
					
					</tr>
					<tr></tr>
					<tr>
						<td class='columnheader' align='center' width="10%" ><fmt:message key="eOP.NoCheckout.label" bundle="${op_labels}"/></td>
						<td class='columnheader' align='center' width="10%" ><fmt:message key="eOP.Checkout.label" bundle="${op_labels}"/></td>
						<td class='columnheader' align='center' width="10%" ><fmt:message key="eOP.AutoCheckout.label" bundle="${op_labels}"/></td>				
						<td class='columnheader' align='center' width="10%" ><fmt:message key="eOP.NoCheckout.label" bundle="${op_labels}"/></td>
						<td class='columnheader' align='center' width="10%" ><fmt:message key="eOP.Checkout.label" bundle="${op_labels}"/></td>
						<td class='columnheader' align='center' width="10%" ><fmt:message key="eOP.AutoCheckout.label" bundle="${op_labels}"/></td>	
					
					</tr>
					
					
					
					
					<%
				}
				count++;
				/*sdesc=rset.getString("sdesc");
				sdesc=rset.getString("totat_visits");
				sdesc=rset.getString("cancelled_visits");
				tatnd=rset.getString("attended");
				natnd=rset.getString("notattended");
				disch=rset.getString("discharged");
				*/
				out.println("<tr><td  class='" + classValue + "'>" + rset.getString("sdesc") + "</td><td  class='" + classValue + "' style='text-align:center;'>" + rset.getString("totat_visits") + "</td><td  class='" + classValue + "' style='text-align:center;'>" + rset.getString("cancelled_visits") + "</td><td  class='" + classValue + "' style='text-align:center;' width='10%'>" + rset.getString("Attended_Not_CheckedOut") + "</td><td  class='" + classValue + "' style='text-align:center;' width='10%'>" + rset.getString("Consulted_CheckedOut") + "</td><td  class='" + classValue + "' style='text-align:center;' width='10%'>" + rset.getString("Attended_Auto_CheckedOut") + "</td><td  class='" + classValue + "' style='text-align:center;' width='10%'>" + rset.getString("Not_Attended") + "</td><td  class='" + classValue + "' style='text-align:center;' width='10%'>" + rset.getString("Not_Attended_CheckedOut") + "</td><td  class='" + classValue + "' style='text-align:center;' width='10%' >" + rset.getString("Not_Attended_Auto_CheckedOut") + "</td></tr>");
				i++;
			}
		}
		if (i == 1)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
		}
		if (!rset.next() && count!=0){	
			 maxRecord  = "0";	
			 %> <script>document.getElementById("nextval").innerHTML=" ";</script><% 
		 }

		mainsql.setLength(0);
		sql.setLength(0);
	}
	catch(Exception e){
		out.println("Excep:"+e);e.printStackTrace();
	}
	finally 
	{
		out.println("<script>parent.frames[0].document.getElementById('service_button').disabled=false;parent.frames[0].document.getElementById('clinic_button').disabled=false;parent.frames[0].document.getElementById('speciality_button').disabled=false</script>");
		try{
		  if(rset != null) rset.close();
		  if(stmt != null) stmt.close();
		}catch(Exception e){}
		if(conn != null) ConnectionManager.returnConnection(conn,request);
	} 

%>
</table>
</td></tr>
</table>

</form>
</body>
<% } %>
</html>

