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
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' onKeyDown='lockKey()' OnMouseDown='CodeArrest()'>");

	String from = request.getParameter( "from" ) ;
	String to   = request.getParameter( "to" ) ;
	
	String bookingtype="" ;
	String gensrlnum  ="" ;
	String nxtsrlno   ="" ;
	String maxsrlno   ="" ;
	String effstatus  ="" ;	  		

	
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
	StringBuffer sqlQuery = new StringBuffer();
	String facilityid  =  (String) session.getValue( "facility_id" ) ;
	int maxRecord = 0;

	try{
		conn = ConnectionManager.getConnection(request); 
		stmt = conn.createStatement();
		/*sqlQuery.append("select count(*) as total from ip_bed_booking_srl_ctrl where facility_id = '"+facilityid+"'");
		rs = stmt.executeQuery(sqlQuery.toString());
		if(rs != null && rs.next())
		maxRecord = rs.getInt("total");
		if(rs!=null) rs.close();*/
		if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("select * from ip_bed_booking_srl_ctrl where  facility_id='"+facilityid+"' ");
		rs = stmt.executeQuery(sqlQuery.toString());

		if ( start != 1 )
	 	  for( int j=1; j<start; i++,j++ )
	 	  {
	 	  	rs.next() ;
	  	  }

		  while ( i<=end && rs.next())
		  {
			  if (maxRecord==0)
				{
		
%>

<p>
		<table align='right'>
		  <tr>
		   
<%
		     if ( !(start <= 1) )
		 	out.println("<td align ='right' id='prev'><A HREF='../jsp/BedBkgSrlCtrlQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A> </td>");
		     //if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/BedBkgSrlCtrlQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A> </td>");
%>		   
		  </tr>
		</table>
</p>
<br>
	<br>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		  <th><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></th>
	 	  <th><fmt:message key="Common.nextsrlno.label" bundle="${common_labels}"/></th>
	 	  <th><fmt:message key="Common.maxserialno.label" bundle="${common_labels}"/></th>
		  

<%
				}
 		 /* if ( start != 1 )
	 	  for( int j=1; j<start; i++,j++ )
	 	  {
	 	  	rs.next() ;
	  	  }*/
	  		String classValue = "";
	  	  
		  //while ( rs.next() && i<=end )
		 // {
	 	   	if ( i % 2 == 0 )
		  		classValue = "QRYEVEN" ;
		   	else
		  		classValue = "QRYODD" ;
			
			bookingtype  =rs.getString("BOOKING_TYPE");
			gensrlnum    =rs.getString("GEN_BOOKING_SRL_YN");
			nxtsrlno     =rs.getString("NEXT_BOOKING_SRL_NO");
			maxsrlno     =rs.getString("MAX_BOOKING_SRL_NO");
					
			String BookType="";
                        if(bookingtype.equals("B"))
			    BookType="Block Bed";
		        if(bookingtype.equals("D"))
			    BookType="Block Bed On Discharge";
			if(bookingtype.equals("T"))
			    BookType="Patient Transfer";
                        if(bookingtype.equals("H"))
		       	    BookType="Holding Bed";
					       	    
                        if (nxtsrlno == null )
                           nxtsrlno="&nbsp;";
                        
                        if (maxsrlno ==  null )
		            maxsrlno="&nbsp;";   
		           
                       	   
		  	out.println("<tr><td class='" + classValue + "'>");
		   			   	
		   	out.println("<a href='../jsp/AddModifyBedBkgSrlCtrl.jsp?booking_type="+ bookingtype + "&gen_srl_num="+gensrlnum+"&nxt_srl_no="+nxtsrlno+"&max_srl_no="+maxsrlno+"&eff_status="+effstatus+"' target='f_query_add_mod' >");		   	
		   	out.println(BookType+"</td>");
		   	
		   	
			out.println("</a></td><td  class='" + classValue + "' align ='right'>");
			out.println(nxtsrlno+"</td><td class='" + classValue + "' align='right'>");
			
			out.println(maxsrlno+"</td><td  class='" + classValue + "'>");			

		   	i++;
			maxRecord++;

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
	   }catch(Exception e){	
	   //e.toString();
	   e.printStackTrace();
	   }
	    finally  
	    {
			try{
			if(rs!=null)	rs.close();
			if(stmt!=null)	stmt.close();
			ConnectionManager.returnConnection(conn,request); 
			}catch(Exception ee){
				//out.println("Error while Closing the connections :"+ee.toString());
				ee.printStackTrace();
				}
	    }
%>

	   </td>
	 </tr>
      </table>

<%
      //rs.close();
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

