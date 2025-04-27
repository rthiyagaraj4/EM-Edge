<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<HTML>
	<head>
		<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	</head>
		<BODY OnMouseDown='CodeArrest()'   onKeyDown = 'lockKey()'; class='CONTENT'>
<%
	
	      request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	try{
	conn = ConnectionManager.getConnection(request);
	ResultSet rs=null;
	Statement stmt = conn.createStatement();

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	
	String cd = request.getParameter("module_id");
	String longdesc = request.getParameter("report_desc");
	String reportid=request.getParameter("report_id");
	String facilityid=request.getParameter("facility_id");
	String facilityname=request.getParameter("facility_name");
	String destlocntype=request.getParameter("dest_locn_type");
	String destlocncode=request.getParameter("dest_locn_code");
	String destlocndesc=request.getParameter("dest_locn_desc");
	String wsid=request.getParameter("ws_no");
	String printerid=request.getParameter("printer");
	String queue_name=request.getParameter("queue_name");

	if(!(queue_name==null || queue_name.equals(""))){
		StringBuffer temp=new StringBuffer();
			temp=new StringBuffer();
			StringTokenizer stoken=new StringTokenizer(queue_name," ");
			while(stoken.hasMoreTokens()){
				temp=temp.append(new StringBuffer(stoken.nextToken()));
			}
		if(queue_name.indexOf("\\")!=-1){
		queue_name=new String(temp);
		}
	}


	if(destlocntype.equals("null") || destlocntype.equals(null))
		destlocntype = "";

	if ( !(cd == null || cd.equals("")) )
	{
		sql.append(" and upper(pr.module_id) like upper('");
		sql.append(cd);
		sql.append("%')");
	}
	
	
	if ( !(longdesc == null || longdesc.equals("")) ){
				sql.append(" and upper(pr.report_desc)  like upper('");
				sql.append(longdesc);
				sql.append("%') ");
	  }
	  
	  if(!(reportid==null || reportid.equals(""))) {
	        	sql.append(" and upper(pr.report_id) like upper('");
				sql.append(reportid);
				sql.append("%')" );
	   } 

/* added by chitra on 16/10/2001 */
	   if(!(facilityid==null || facilityid.equals("")))  {
	       	sql.append(" and upper(pr.facility_id) like upper('");
			sql.append(facilityid);
			sql.append("%')");
	   } 

	   if(!(facilityname==null || facilityname.equals("")))  {
	         	sql.append(" and  upper(pr.facility_id) like upper('");
				sql.append(facilityname);
				sql.append("%') ");
	   } 


	   if(!(destlocntype==null || destlocntype.equals("")))	  {
	   	     	sql.append(" and upper(pr.dest_locn_type) = upper('");
				sql.append(destlocntype);
				sql.append("')");
	   } 


	  if(!(destlocncode==null || destlocncode.equals("")))
	  {
	       	sql.append( " and upper(pr.dest_locn_code) like upper('");
			sql.append(destlocncode);
			sql.append("%')");
	   } 


	   if(!(destlocndesc==null || destlocndesc.equals("")))
	  {
	       	sql.append( " and upper(pr.dest_locn_desc)  like upper('");
			sql.append(destlocndesc);
			sql.append("%') ");
	   } 


	   if(!(wsid==null || wsid.equals("")))
	  {
	       	sql.append(" and upper(pr.ws_no) like upper('");
			sql.append(wsid);
			sql.append("%')");
	   } 

	   if(!(printerid==null || printerid.equals("")))
	  {
	       	sql.append(" and upper(pr.printer_id1) = upper('");
			sql.append(printerid);
			sql.append("')");
	   } 

	   if(!(queue_name==null || queue_name.equals("")))
	  {
	       	sql.append(" and upper(b.queue_name) like upper('");
			sql.append(queue_name);
			sql.append("%')");
	   } 

	 /* added by chitra on 16/10/2001 ends */    
	
		
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
			sql.append(ord[i]);
			sql.append(",");
		}
	}
	} //end of where clause IF
	else 
		sql.setLength(0);
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




/*try{
	rs = stmt.executeQuery("select count(*) as total from sm_print_routing_vw pr, sm_printer b    where pr.printer_id1 = b.printer_id "+sql.toString());
	rs.next();
	maxRecord = rs.getInt("total");
	if(rs!=null) rs.close();
	if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");

	}catch (Exception ce) {out.println("Here "+ce);}*/

	try
		{
		int cnt = 0;
		String endOfRes="1";
		String sql1=" select  b.printer_name printer_name1, "+
							" c.printer_name printer_name2, "+
							" d.printer_name printer_name3, "+
							" pr.*,b.queue_name queue_name   from sm_print_routing_vw pr, sm_printer b,sm_printer c, "+
							" sm_printer d where pr.printer_id1= b.printer_id (+)  and  pr.printer_id2= c.printer_id (+)  "+
							" and pr.printer_id3=d.printer_id (+) "+sql.toString();
		rs = stmt.executeQuery(sql1);
	if ( start != 1 )
 		for( int j=1; j<start; i++,j++ )
			 rs.next() ;
	  String classValue = "" ;
	  
	  while ( i<=end  && rs.next()){
		  if(cnt==0){
	%>

		<p>
		<table align='right'>
		<tr>
		<td>
		<%
		if ( !(start <= 1) )
			out.println("<A HREF='../../eSM/jsp/queryPrintRouting.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if (endOfRes.equals("1"))
			out.println("<A id='nextval' HREF='../../eSM/jsp/queryPrintRouting.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		%>
		</td>
		</tr>
		</table>
		<br><br>
		</p>
  
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.Module.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ReportID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSM.DestLocn.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSM.DestLocn.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSM.DestLocn.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.workstation.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>1</th> 
		<th><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>2</th> 
		<th><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>3</th> 
		<th><fmt:message key="eSM.QueueName.label" bundle="${sm_labels}"/></th> 


		<%}

			if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				  else
					classValue = "QRYODD" ;
				  

			out.println("<tr><td  nowrap class='" + classValue + "'>");
			String code = rs.getString("module_name"); 
			String report=rs.getString("report_id");
			String slno=rs.getString("srl_no");
			String id = rs.getString("module_id");
			String dest_locn_type =rs.getString("dest_locn_type");
			if(dest_locn_type == null) dest_locn_type="&nbsp;";
			
			// if ( rs.getString("eff_status").equals("E") )
			out.println("<a href='../../eSM/jsp/PrintRoutingModify.jsp?module_id="+ id +"&report_id="+report+ "&srl_no="+slno +"' target='f_query_add_mod' >"); 
			out.println(code+"</a></td><td  nowrap class='" + classValue + "'>");
			out.println(report+"</a></td><td nowrap class='" + classValue + "'>");

			out.println( rs.getString("report_desc") );
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println( rs.getString("facility_id")==null?"&nbsp": rs.getString("facility_id"));
			out.println("</td><td nowrap class='" + classValue + "'>");

			out.println( rs.getString("facility_name")==null?"&nbsp": rs.getString("facility_name"));
				
			out.println("</td><td nowrap class='" + classValue + "'>");
			
			if(dest_locn_type.equals("C")) dest_locn_type="Clinic";
			else
			if(dest_locn_type.equals("L")) dest_locn_type="Location";
			else
			if(dest_locn_type.equals("N")) dest_locn_type="Nursing Unit";
			else
			if(dest_locn_type.equals("O")) dest_locn_type="Service Location";
			else
			if(dest_locn_type.equals("P")) dest_locn_type="Pharmacy";
			else
			if(dest_locn_type.equals("S")) dest_locn_type="Store";
			else
			if(dest_locn_type.equals("E")) dest_locn_type="Procedure Unit";
			else
			if(dest_locn_type.equals("Y")) dest_locn_type="Daycare Unit";
			else
			if(dest_locn_type.equals("R")) dest_locn_type="External";
			
			out.println(dest_locn_type) ;
					
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.print(rs.getString("dest_locn_code")==null?"&nbsp;":rs.getString("dest_locn_code")) ;

			out.println("</td><td nowrap class='" + classValue + "'>");

			 if(rs.getString("dest_locn_type").equals("Location"))
			{
				out.println( rs.getString("dest_locn_code")==null?"&nbsp":rs.getString("dest_locn_code") );
			 }
			 else 
			{
				out.print(rs.getString("dest_locn_desc") ==null?"&nbsp":rs.getString("dest_locn_desc") );
			}
			out.println("</td><td  nowrap class='" + classValue + "'>");
			out.print(rs.getString("ws_no")==null?"&nbsp":rs.getString("ws_no") );
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.print(rs.getString("printer_name1")==null?"&nbsp":rs.getString("printer_name1"));
			out.println("</td><td nowrap  class='" + classValue + "'>");
			out.print(rs.getString("printer_name2")==null?"&nbsp":rs.getString("printer_name2"));
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.print(rs.getString("printer_name3")==null?"&nbsp":rs.getString("printer_name3"));
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.print(rs.getString("queue_name")==null?"&nbsp":rs.getString("queue_name"));

			i++;
					cnt++;
	} 
	if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	if(!rs.next()&&cnt!=0){
		endOfRes="0";
		%>
		<script>
			document.getElementById('nextval').innerHTML=" ";
		</script>
	<%} 
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		%>

		</td></tr>
		</table>
		<br><center>

		<%
		}
catch ( Exception e ){ out.println("Exception "+e);}

finally{
	
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;

	}
}catch(Exception e){out.println(e);}
	
finally { 
	ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</BODY>
</HTML>

