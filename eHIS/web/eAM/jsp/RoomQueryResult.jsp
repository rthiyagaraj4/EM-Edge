<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY   OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >
<form name='result_form' id='result_form'>
<%
	request.setCharacterEncoding("UTF-8");	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//String facilityid	=(String)session.getValue("facility_id");
	String whereClause = request.getParameter("whereclause");
	String roomdesc  ="";
	String roomtype ="";
	String bldngdesc="";
	String floorcode="";
	String floordesc ="";
	String enabled ="";
	String bldngcode ="";
	String function_id ="";
//	String sql ;
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	//sql="";
	sbQuery.setLength(0);
	String roomnum    = request.getParameter("room_num")==null ?"":request.getParameter("room_num");
	String room_long_desc  = request.getParameter("room_num")==null ?"":request.getParameter("long_desc");

	 roomdesc   = request.getParameter("short_desc")==null ?"":request.getParameter("short_desc");
	 roomtype   = request.getParameter("locn_type")==null ?"":request.getParameter("locn_type");
	 bldngcode  = request.getParameter("bldng_code")==null ?"":request.getParameter("bldng_code");
	 bldngdesc  = request.getParameter("bldng_short_desc")==null ?"":request.getParameter("bldng_short_desc");
	 floorcode  = request.getParameter("floor_code")==null ?"":request.getParameter("floor_code");
	 floordesc  = request.getParameter("floor_short_desc")==null ?"":request.getParameter("floor_short_desc");
	 enabled	= request.getParameter("eff_status")==null ?"":request.getParameter("eff_status");
	 function_id	= request.getParameter("function_id")==null ?"":request.getParameter("function_id");
	//String chkValue    = request.getParameter("chk_box")==null ?"":request.getParameter("chk_box");
	String operating_facility_id =  request.getParameter("operating_facility_id")==null ?"":request.getParameter("operating_facility_id");
	String facility_name =  request.getParameter("facility_name")==null ?"":request.getParameter("facility_name");

/******** added for no of beds on 05/02/04 bt Sridhar for Emal Enhancements *********/
//String bedno =  request.getParameter("No_Of_Beds_Max")==null ?"":request.getParameter("No_Of_Beds_Max");
/****************************** End of Addition *******************************/

	//int andCheck = 0;

	 if ( !(roomnum == null || roomnum.equals("")) )
		{
		 sbQuery.append(" and  upper(a.room_num) like upper('"+roomnum+"%')");
		//sql += " and  upper(a.room_num) like upper('"+roomnum+"%')";
		//andCheck = 1;
		}

		if(!(room_long_desc == null || room_long_desc.equals("")))
		{
			sbQuery.append(" and  upper(a.long_desc) like upper('"+room_long_desc+"%')");
		}


	 if ( !(operating_facility_id == null || operating_facility_id.equals("")) )
		{
		 sbQuery.append(" and  upper(a.operating_facility_id) like upper('"+operating_facility_id+"%')");
		//sql += " and  upper(a.operating_facility_id) like upper('"+operating_facility_id+"%')";
		//andCheck = 1;
		}

	 if ( !(facility_name == null || facility_name.equals("")) )
		{
		 sbQuery.append(" and  upper(b.facility_name) like upper('"+facility_name+"%')");
		//sql += " and  upper(b.facility_name) like upper('"+facility_name+"%')";
		//andCheck = 1;
		}

	if ( !(roomdesc == null || roomdesc.equals("")) )
		{
			sbQuery.append(" and upper(short_desc)  like  upper('"+roomdesc+"%') ");
			//sql = sql + " and upper(short_desc)  like  upper('"+roomdesc+"%') " ;
		}

	if ( !(roomtype == null || roomtype.equals("")) )
	    {
			sbQuery.append("and upper(room_type)  like  upper('"+roomtype+"%')");
			//sql = sql + " and upper(room_type)  like  upper('"+roomtype+"%') " ;
		}

	if ( !(bldngcode == null || bldngcode.equals("")) )
	    {
			sbQuery.append(" and upper(bldng_code) like  upper('"+bldngcode+"%')");
		//	sql = sql + " and upper(bldng_code) like  upper('"+bldngcode+"%')" ;
		}

	if ( !(bldngdesc == null || bldngdesc.equals("")) )
	    {
			sbQuery.append(" and upper(bldng_short_desc)  like  upper('"+bldngdesc+"%') ");
			//sql = sql + " and upper(bldng_short_desc)  like  upper('"+bldngdesc+"%') " ;
		}

	
	if ( !(floorcode == null || floorcode.equals("")) )
	    {
				sbQuery.append(" and upper(floor_code) like  upper('"+floorcode+"%')");
		//	sql = sql + " and upper(floor_code) like  upper('"+floorcode+"%')" ;
		}


	if ( !(floordesc == null || floordesc.equals("")) )
	    {
			sbQuery.append("and upper(floor_short_desc) like  upper('"+floordesc+"%') ");
			//sql = sql + "and upper(floor_short_desc) like  upper('"+floordesc+"%') " ;
		}

	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	        {
			sbQuery.append("and eff_status='E'");
			//sql = sql + " and eff_status='E'";
		}
	   if ( enabled.equals("D") )
		{

			sbQuery.append(	" and eff_status='D'");
			//sql = sql + " and eff_status='D'";
		}
	   if ( enabled.equals("B") )
	   	{
	   	//out.println(sql );

	   	// sql = sql; nothing is added to get both E and D
		}
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");


	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append(" order by ");
	//	sql=sql+" order by ";

		for ( int i=0;i < ord.length;i++ )
	 	{
			if ( i == ord.length - 1 )
				sbQuery.append(ord[i]);
				//sql=sql+ord[i];
			else
				sbQuery.append(ord[i]+",");
				//sql=sql+ord[i]+",";
		}
	}
	} //end of where clause IF

	else{
		sbQuery.setLength(0);
		sbQuery.append( whereClause);
		//sql =;

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


//out.println(sql);	

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

int maxRecord = 0;


try{
	conn = ConnectionManager.getConnection(request);



	String strsql2="select * from am_facility_room_vw a ,sm_facility_param b  where a.operating_facility_id =b.facility_id "+sbQuery.toString();
 	stmt = conn.createStatement();
	if (rs != null)   rs.close();
	rs = stmt.executeQuery(strsql2);

	 if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	  while ( i<=end && rs.next() )
{
		  if(maxRecord==0)
	{

	%>

<p>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/RoomQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/RoomQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
<!-- 
 The below hidden field is being defined so as to pass function id to the webhelp.jsp through lockkey() function, which is required for displaying online help since  same jsp is used in IP ROOM/CUBICLE and AM ROOM both we need function id. -Vinod 3/6/2009 
 -->
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>' >
</tr>
</table>
</p>
<br><br>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th nowrap ><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></th>
<!-- New Column added for no of beds on 05/02/04 by Sridhar for Emal Enhancement -->
<!-- <th nowrap >No Of Beds Max</th> -->
<th nowrap ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.building.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.building.label" bundle="${common_labels}"/><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.FloorCode.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="eAM.FloorDescription.label" bundle="${am_labels}"/></th>
<th nowrap ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
 
	  String classValue = "" ;

        if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	out.println("<center>");
	out.println("<tr><td class='" + classValue + "'>" );
	String roomnum = rs.getString("room_num");
	 roomdesc=rs.getString("short_desc");
	//String longdesc=rs.getString("long_desc");
	 roomtype = request.getParameter("room_type");
	//String bldngcode = request.getParameter("bldng_code");
 bldngdesc=request.getParameter("bldng_short_desc");
	 floorcode=request.getParameter("floor_code");
 floordesc=request.getParameter("floor_short_desc");
	 enabled 		= request.getParameter("eff_status");
//	String facilityid	=(String)session.getValue("facility_id");
	String facility_name = rs.getString("facility_name");
	String facility_id = rs.getString("operating_facility_id");
	 bldngcode=(rs.getString("bldng_code")==null)?"":rs.getString("bldng_code");

/********************* Added for No of Beds on 05/02/04 ***********************/
//	String bedno =  rs.getString("No_Of_Beds_Max");
/****************************** End of Addition *******************************/

	out.println("<a href='../../eAM/jsp/addModifyRoom.jsp?room_num="+ roomnum +"&source=Modify"+"&function_id="+function_id+"&facility_name="+java.net.URLEncoder.encode(facility_name)+"&operating_facility_id="+facility_id+"    'target='f_query_add_mod'>");
	out.println(facility_id+"</a></td><td nowrap class='" + classValue + "'>");
	out.println(facility_name+"</td><td nowrap class='" + classValue + "'>");
	out.println("<a href='../../eAM/jsp/addModifyRoom.jsp?room_num="+ roomnum +"&source=Modify"+"&function_id="+function_id+"&facility_name="+java.net.URLEncoder.encode(facility_name)+"&operating_facility_id="+facility_id+"    'target='f_query_add_mod'>");
	out.println(roomnum+"</a></td><td nowrap class='" + classValue + "'>");

	out.println( rs.getString("long_desc") );
	out.println("</td><td nowrap class='" + classValue + "'>");

/****************************** Added for No Of Beds ***************************/
//	out.println(bedno+"</a></td><td nowrap class='" + classValue + "'>");
/****************************** End of Addition *******************************/

	//out.println("<a href='../../eAM/jsp/addModifyRoom.jsp?room_num="+ roomnum +"&short_desc="+roomdesc+"&long_desc="+longdesc+"&source=Modify"+"'target='f_query_add_mod'>");
	out.println( rs.getString("short_desc") );
	out.println("</td><td nowrap class='" + classValue + "'>");

	//out.println("<a href='../../eAM/jsp/addModifyRoom.jsp?room_num="+ roomnum +"&short_desc="+roomdesc+"&long_desc="+longdesc+"&source=Modify"+"'target='f_query_add_mod'>");
	out.println( rs.getString("room_type_desc") );
	out.println("</td><td nowrap class='" + classValue + "'>");

	//out.println("<a href='../../eAM/jsp/addModifyRoom.jsp?room_num="+ roomnum +"&short_desc="+roomdesc+"&long_desc="+longdesc+"&source=Modify"+"'target='f_query_add_mod'>");

	if (rs.getString("bldng_code")==null || rs.getString("bldng_code").equals("null") || rs.getString("bldng_code").equals(""))
		out.println("&nbsp;");
	else
		out.println( rs.getString("bldng_code") );
	out.println("</td><td nowrap class='" + classValue + "'>");

	//out.println("<a href='../../eAM/jsp/addModifyRoom.jsp?room_num="+ roomnum +"&short_desc="+roomdesc+"&long_desc="+longdesc+"&source=Modify"+"'target='f_query_add_mod'>");
	if (rs.getString("bldng_short_desc")==null || rs.getString("bldng_short_desc").equals("null") || rs.getString("bldng_short_desc").equals(""))
		out.println("&nbsp;");
	else
		out.println( rs.getString("bldng_short_desc") );
	out.println("</td><td nowrap class='" + classValue + "'>");

	//out.println("<a href='../../eAM/jsp/addModifyRoom.jsp?room_num="+ roomnum +"&short_desc="+roomdesc+"&long_desc="+longdesc+"&source=Modify"+"'target='f_query_add_mod'>");
	if (rs.getString("floor_code")==null || rs.getString("floor_code").equals("null") || rs.getString("floor_code").equals(""))
		out.println("&nbsp;");
	else
		out.println( rs.getString("floor_code") );

	out.println("</td><td nowrap class='" + classValue + "'>");

	//out.println("<a href='../../eAM/jsp/addModifyRoom.jsp?room_num_code="+ roomnum + "' target='f_query_add_mod' >");
	//out.println("<a href='../../eAM/jsp/addModifyRoom.jsp?room_num="+ roomnum +"&short_desc="+roomdesc+"&long_desc="+longdesc+"&source=Modify"+"'target='f_query_add_mod'>");
	if (rs.getString("floor_short_desc")==null || rs.getString("floor_short_desc").equals("null") || rs.getString("floor_short_desc").equals(""))
		out.println("&nbsp;");
	else
		out.println( rs.getString("floor_short_desc") );

	out.println("</td><td nowrap align='center'  class='" + classValue + "'>");

	if ( rs.getString("eff_status").equals("E") )

		out.println("<img src='../../eCommon/images/enabled.gif'></img>");

	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
	}//end of while

	if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}

	 if (rs != null)   rs.close();
	 if (stmt != null) stmt.close();
}//end of try
	catch(Exception e) { //out.println(e.toString());
		e.printStackTrace();
	}

	finally {
	 
 	  ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>
<!--%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/RoomQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/RoomQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/next.gif' alt='Next' border='0'></A>");
rs.close();
%-->

</center>
</form>
</BODY>
</HTML>

