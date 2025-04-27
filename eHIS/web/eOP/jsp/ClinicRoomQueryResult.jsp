<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<!--<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>-->
<script language="javascript" src="../../eCommon/js/common.js"></script>

<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT'  onLoad='ClearMsg()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	if(facilityId==null) facilityId="";
	String whereClause = request.getParameter("whereclause");
	
	String sql=""; 
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int andCheck = 0;
	
	if ( (whereClause == null || whereClause.equals("")) )
		{
		sql="";
		String clinic_code = request.getParameter("clinic_code");
		String clinic_desc = request.getParameter("clinic_desc");
		String room=request.getParameter("room");
		String room_desc=request.getParameter("room_desc");
		String enabled = request.getParameter("eff_status");
		
		clinic_code = clinic_code.toUpperCase();
		room = room.toUpperCase();


		sql = " where facility_id = '"+facilityId+"' ";

     	andCheck = 1;
		
		if ( !(clinic_code == null || clinic_code.equals("")) )
		{
				if ( andCheck == 1 )
						{	sql = sql + " and ";
							sql =sql + " upper(clinic_code) like upper('"+clinic_code+"%')";
							andCheck = 1;							
						}
						else
						{
							sql = " where upper(clinic_code) like upper('"+clinic_code+"%')";
							andCheck = 1;
				}
		
		
		
		}
		
		if ( !(clinic_desc == null || clinic_desc.equals("")) )
			  {
				if ( andCheck == 1 )
				{	sql = sql + " and ";
					sql = sql + "upper(clinic_short_desc) like  upper('%"+clinic_desc+"%')" ;
				}
				else
				{
					sql = "where upper(clinic_short_desc) like upper('%"+clinic_desc+"%')" ;
					andCheck = 1;
				}
			 }
			
				if ( !(room == null || room.equals("")) )
					    {
						 if ( andCheck == 1 )
							{	sql = sql + " and ";
								sql = sql + "upper(room_no) like  upper('"+room+"%')" ;
							}
						else
							{
								sql = "where upper(room_no) like upper('"+room+"%')" ;
								andCheck = 1;
							}
						}
				
				if ( !(room_desc == null || room_desc.equals("")) )
					    {
						 if ( andCheck == 1 )
							{	sql = sql + " and ";
								sql = sql + "upper(room_short_desc) like  upper('%"+room_desc+"%')" ;
							}
						else
							{
								sql = "where upper(room_short_desc) like upper('%"+room_desc+"%')" ;
								andCheck = 1;
							}
						}
				
				
				if ( !(enabled == null || enabled.equals("")) )
				{
				   if ( enabled.equals("E") )
				        {
					if ( andCheck == 0 ) {
						sql = "where eff_status='E'";
						andCheck = 1; }
					else
						sql = sql + " and eff_status='E'";
					}
				   if ( enabled.equals("D") )
					{
					if ( andCheck == 0 ) {
						sql = " where  eff_status='D'";
						andCheck = 1; }
					else
						sql = sql + " and eff_status='D'";
					}
				   if ( enabled.equals("B") )
				   	{
				   	//out.println(sql );
			
				   	// sql = sql; nothing is added to get both E and D
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

	Connection conn = null;
	Statement stmt=null;
	ResultSet rset=null;
	ResultSet rs=null;
	int maxRecord = 0;
	
	

	try{	
			conn = ConnectionManager.getConnection(request) ;
			stmt = conn.createStatement();
			String strsql1="select count(*) as total from op_clinic_room_vw  "+sql; //where facility_id = '"+facilityId+"' ";
//out.println("strsql1="+strsql1);
			rs = stmt.executeQuery(strsql1);
			rs.next();
			maxRecord = rs.getInt("total");
if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
}else{
					//String strsql2="select  * from op_clinic_room_vw  "+sql;
					String strsql2="select  clinic_code, clinic_short_desc, eff_status, room_no, ROOM_short_DESC  from op_clinic_room_vw  "+sql;
					//out.println("strsql2="+strsql2);
					rs = stmt.executeQuery(strsql2);
	%>

	<P>
	<table align='right'>
	<tr>
	<td>
	<%
	if ( !(start <= 1) )
		out.println("<A HREF=\"../jsp/ClinicRoomQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"\""+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF=\"../jsp/ClinicRoomQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"\""+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		
	%>
	</td>
	</tr>
	</table>
	</P>
	<br>
	<br>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<td class='columnheader'><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.ClinicDescription.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="eOP.RoomDescription.label" bundle="${op_labels}"/></td>

	<td class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

	<%
	if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		  }

	String classValue = "" ;

	while ( rs.next() && i<=end )
	{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			String cliniccode = rs.getString("clinic_code");
			String clinicshortcode = rs.getString("clinic_short_desc");
			String effstatus = rs.getString("eff_status");
			String room_no= rs.getString("room_no");
			String room_long_desc =rs.getString("ROOM_short_DESC");

			out.println("<tr><td class='" + classValue + "'>");
			out.println(cliniccode+"</td><td class='" + classValue + "'>");
			out.println(clinicshortcode+"</td><td class='" + classValue + "'>");

			out.println(room_no+"</td><td align='left' class='" + classValue + "'>");
			out.println(room_long_desc+"</td><td align='center' align='left' class='" + classValue + "'>");
			
			
			if(effstatus.equals("E"))
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

		i++;
	}
	}//endwhile
	}catch(Exception e){
		out.println(e);
	}	finally   {
		if(stmt!=null) 	stmt.close();
		if(rs!=null) 		rs.close();
		if(rset!=null)		rset.close();
		ConnectionManager.returnConnection(conn,request); 

		}
		
%>

</td></tr>
</table>
</BODY>
</HTML>

