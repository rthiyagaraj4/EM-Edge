<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*,java.net.*,java.text.*" 
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML><head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>


<%
    Connection conn =null;
    
    PreparedStatement pstmt=null;
    ResultSet rs=null;  
    
	try
	{    /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	     String   locale = (String)session.getValue("LOCALE");
		 
	    /*end SS-CRF-0010 [IN034516]*/
		conn = ConnectionManager.getConnection(request);
		String  loginfacilityid  =  (String) session.getValue( "facility_id" ) ;
	    String whereClause = request.getParameter("whereclause");

		StringBuffer sql = new StringBuffer("");
		String from = request.getParameter( "from" ) ;
	    String to = request.getParameter( "to" ) ;


		if ( (whereClause == null || whereClause.equals("")) )
		{
			String locntype = request.getParameter("locn_type");
		    String locntypedesc = request.getParameter("locn_type_short_desc");
		    String locncode = request.getParameter("locn_code");
		    String locndesc = request.getParameter("locn_short_desc");
		    String pid = request.getParameter("practitioner_id");
		    String pname = request.getParameter("practitioner_name");

		    int andCheck = 0;

			/* The where condition for the sql query be dynamically created based on the values of location type and practitioner name. */

		    sql.append("where facility_id = '"+loginfacilityid+"'");
		    andCheck = 1;

		    locntype=locntype.toUpperCase();
			/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
			if ( !(locntype == null || locntype.equals("")) )
		    {
		        if ( andCheck == 1 )
				{
		            sql.append(" and upper(a.locn_type) like  upper('"+locntype+"%')");
				}
		        else
				{
		            sql.append("where upper(a.locn_type) like upper('"+locntype+"%')");
		            andCheck = 1;
				}
		    }

		    if ( !(locntypedesc == null || locntypedesc.equals("")) )
		    {
		        if ( andCheck == 1 )
				{
		            sql.append(" and upper(a.locn_type_short_desc) like  upper('"+locntypedesc+"%')");
				}
		        else
				{
		            sql.append("where upper(a.locn_type_short_desc) like upper('"+locntypedesc+"%')");
		            andCheck = 1;
				}
		    }

		    locncode=locncode.toUpperCase();
		    if ( !(locncode == null || locncode.equals("")) )
		    {
				if ( andCheck == 1 )
		        {
		            sql.append(" and upper(a.locn_code) like  upper('"+locncode+"%')");
		        }
				else
		        {
		            sql.append("where upper(a.locn_code) like upper('"+locncode+"%')");
		            andCheck = 1;
				}
		    }

			if ( !(locndesc == null || locndesc.equals("")) )
		    {
				if ( andCheck == 1 )
		        {
				    sql.append(" and upper(a.locn_short_desc) like  upper('"+locndesc+"%')");
			    }
		        else
				{
		            sql.append("where upper(a.locn_short_desc) like upper('"+locndesc+"%')");
				    andCheck = 1;
		        }
		    }

		    pid=pid.toUpperCase();
		
			if ( !(pid == null || pid.equals("")) )
		    {
		        if ( andCheck == 1 )
		        {
				    sql.append(" and upper(a.practitioner_id) like  upper('"+pid+"%')");
		        }
				else
		        {
		            sql.append("where upper(a.practitioner_id) like upper('"+pid+"%')");
				    andCheck = 1;
		        }
		    }


		    if ( !(pname == null || pname.equals("")) )
		    {
				if ( andCheck == 1 )
		        {
				    sql.append(" and upper(a.practitioner_name) like  upper('"+pname+"%')");
			    }
		        else
		        {
					sql.append("where upper(a.practitioner_name) like upper('"+pname+"%')");
					andCheck = 1;
			    }
		    }

			/*CRF end SS-CRF-0010 [IN034516]*/
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
		{
		    sql.append(whereClause);
	    }

		int start = 0 ;
	    int end = 0 ;
		int i=1;
		int cnt = 0;

	    if ( from == null )
		    start = 1 ;
	    else
		    start = Integer.parseInt( from ) ;

	    if ( to == null )
		    end = 14 ;
	    else
		    end = Integer.parseInt( to ) ;

	    //int maxRecord = 0;

		try
	    {
    
			/*String strsql1="select count(*) as total from op_queue_num_for_locn_vw "+sql;

		    pstmt = conn.prepareStatement(strsql1);
		    rs = pstmt.executeQuery();  
		    rs.next();
		    maxRecord = rs.getInt("total");
			if(maxRecord == 0)		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	
		  if(rs != null ) rs.close();
		  if(pstmt != null ) pstmt.close();

		}catch(Exception e) { out.println(e.toString());}

		try
		{*/
			/* The available Queue Numbering control records are taken from the database table op_queue_num_for_locn_vw based on the dynamically created where condition which is in the String variable "sql" --- Srijagadeesh */

			
		 /* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
          String strsql2="SELECT  a.*, am_get_desc.am_facility_room (a.facility_id,a.ROOM_NUM, '"+locale+"', 2) room_desc FROM op_queue_num_for_locn_vw  a "+sql;
		 /*CRF end SS-CRF-0010 [IN034516]*/
		 
				
	        pstmt = conn.prepareStatement(strsql2);
		    rs = pstmt.executeQuery();  	
			
			 if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
					rs.next() ;

			 while( i<=end && rs.next() )
			 { 	
				 if( cnt == 0)
				 {
%>
		<P>
		<table align='right'>
		<tr>
			<td>
<%
				if ( !(start <= 1) )
			        out.println("<A HREF='../../eOP/jsp/OpqueuenumberingQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
			   
			        out.println("<A id='nextval' HREF='../../eOP/jsp/OpqueuenumberingQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
			</td>
		</tr>
		</table>
		<br><br>
		</P>

	    <table border="1" width="100%" cellspacing='0' cellpadding='0'>
 <!--venkat-->
			<th class=' columnheader'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
		    <th class=' columnheader'><fmt:message key="eOP.LocationTypeDescription.label" bundle="${op_labels}"/></th>
		    <th class=' columnheader'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></th>
		    <th class=' columnheader'><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></th>
		    <th class=' columnheader'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
		    <th class=' columnheader'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
			<!--  Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516]  -->
			<th class=' columnheader'><fmt:message key="Common.room.label" bundle="${common_labels}"/></th>
			<!-- CRF end SS-CRF-0010 [IN034516] -->
            <th class=' columnheader'><fmt:message key="eOP.OtherResourceID.label" bundle="${op_labels}"/></th>
			<%
			}
		   
			    String classValue="";		   
	            if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
			    else
					classValue = "QRYODD" ;

		        out.println("<tr><td class='" + classValue + "'>");
				String ltype = rs.getString("locn_type");
		       	String lcode= rs.getString("locn_code");
				String pracid=rs.getString("practitioner_id");
		        String pracname=rs.getString("practitioner_name");
		        String walkin=rs.getString("WALK_IN_QUEUE_ID");
				String referral=rs.getString("REFERRAL_QUEUE_ID");
				String appt=rs.getString("APPT_QUEUE_ID");
				String other_resource=rs.getString("OTHER_RES_CLASS");
				String other_resource_desc=rs.getString("OTHER_RES_CLASS_DESC");
				String other_resource_id=rs.getString("OTHER_RESOURCE_ID");
		   
		//Code added/modified by Tushar .T. Bhat on 19-Feb-04
		
				String roomNumber = rs.getString("room_num");
				/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				String room_desc=rs.getString("room_desc");
				/*CRF end SS-CRF-0010 [IN034516]*/

				if(roomNumber == null) roomNumber = "";
                /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */

                  if(room_desc == null ){ room_desc=""; }
				
				/*CRF end SS-CRF-0010 [IN034516]*/
				if(pracname == null) pracname="&nbsp ";

				 /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
                 out.println("<a href='../../eOP/jsp/addModifyOpqueuenumbering.jsp?locn_code="+ lcode +"&locn_type="+ltype+"&practitioner_id="+pracid+"&room_num="+roomNumber+"&room_desc="+room_desc+"&WALK_IN_QUEUE_ID="+walkin+"&REFERRAL_QUEUE_ID="+referral+
			    "&APPT_QUEUE_ID="+appt+"&OTHER_RES_CLASS="+other_resource+"&OTHER_RESOURCE_DESC="+other_resource_desc+"&OTHER_RESOURCE_NO="+other_resource_id+"&source=Modify"+"'target='f_query_add_mod' >"+ltype+"</a></td>");
				/*CRF end SS-CRF-0010 [IN034516]*/
				
 %>
				<td class='<%=classValue%>'><%=rs.getString("locn_type_short_desc")%></td><td class='<%=classValue%>'>
 
 <%              /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				 out.println("<a href='../../eOP/jsp/addModifyOpqueuenumbering.jsp?locn_code="+ lcode +"&locn_type="+ltype+"&practitioner_id="+pracid+"&room_num="+roomNumber+"&room_desc="+room_desc+"&WALK_IN_QUEUE_ID="+walkin+"&REFERRAL_QUEUE_ID="+referral+
			     "&APPT_QUEUE_ID="+appt+"&OTHER_RES_CLASS="+other_resource+"&OTHER_RESOURCE_DESC="+other_resource_desc+"&OTHER_RESOURCE_NO="+other_resource_id+"&source=Modify"+"'target='f_query_add_mod' >"+lcode+"</a></td>");
                 /*CRF end SS-CRF-0010 [IN034516]*/
 %>
				<td class='<%=classValue%>'><%=rs.getString("locn_short_desc")%></td><td class='<%=classValue%>'>
	 
<%              /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				out.println("<a href='../../eOP/jsp/addModifyOpqueuenumbering.jsp?locn_code="+ lcode +"&locn_type="+ltype+"&practitioner_id="+pracid+"&room_num="+roomNumber+"&room_desc="+room_desc+"&WALK_IN_QUEUE_ID="+walkin+"&REFERRAL_QUEUE_ID="+referral+
			     "&APPT_QUEUE_ID="+appt+"&OTHER_RES_CLASS="+other_resource+"&OTHER_RESOURCE_DESC="+other_resource_desc+"&OTHER_RESOURCE_NO="+other_resource_id+"&source=Modify"+"'target='f_query_add_mod' >"+pracid+"</a></td>");
				 /*CRF end SS-CRF-0010 [IN034516]*/


%>
				<td class='<%=classValue%>'><%=pracname%></td><td class='<%=classValue%>'>
<%
               /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				out.println("<a href='../../eOP/jsp/addModifyOpqueuenumbering.jsp?locn_code="+ lcode +"&locn_type="+ltype+"&practitioner_id="+pracid+"&room_num="+roomNumber+"&room_desc="+room_desc+"&WALK_IN_QUEUE_ID="+walkin+"&REFERRAL_QUEUE_ID="+referral+
			   "&APPT_QUEUE_ID="+appt+"&OTHER_RES_CLASS="+other_resource+"&OTHER_RESOURCE_DESC="+other_resource_desc+"&OTHER_RESOURCE_NO="+other_resource_id+"&source=Modify"+"'target='f_query_add_mod' >"+roomNumber+" "+room_desc);
			   /*CRF end SS-CRF-0010 [IN034516]*/
        %>
		<td class='<%=classValue%>'><%=rs.getString("other_resource_id")%></td>
		<%
		//Code added/modified by Tushar .T. Bhat on 19-Feb-04 ends
    

				i++;
				cnt++;
			}//end of while

			}// end oftry

	    catch(Exception e) { out.println(e.toString());} 

if( cnt == 0 )			
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

if( !rs.next() && cnt!=0 )
{   
%>
<script>
	document.getElementById("nextval").innerHTML = " ";
</script>
<% } %>

</td></tr>
</table>
<br><center>

<%
 if(rs != null ) rs.close();
 if(pstmt !=null ) pstmt.close();

 
}catch(Exception e) { out.println(e.toString());}
finally 
{
	if (pstmt != null) pstmt.close();
    if (rs != null)   rs.close();
		ConnectionManager.returnConnection(conn,request); 
}
%>

</center>
</BODY>
</HTML>

