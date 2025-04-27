<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,java.net.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>

	<head>
	
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
		<script>
		 function closeRFID(val){						
		parent.window.returnValue = val
		parent.window.close();
	}
		</script>
	</head>
 		
		<%
			Connection	con			        = null;
			java.sql.Statement	stmt		= null;
			ResultSet	rs					= null;				
			PreparedStatement pstmt			= null;
		
			//String locale=(String)session.getAttribute("LOCALE"); 	
			String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
		%>

	<body onKeyDown = 'lockKey()'>
		<%
			StringBuffer whereBuffer = new StringBuffer();
			StringBuffer sqlBuffer = new StringBuffer(); 
	try
	{
     	request.setCharacterEncoding("UTF-8");
		String rfid_tag_no			= checkForNull(request.getParameter("rfid_tag_no"));
		String patient_id			= checkForNull(request.getParameter("patient_id"));
		String search_criteria			= checkForNull(request.getParameter("search_criteria"));	
		con=ConnectionManager.getConnection(request);		
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;	
		String endOfRes="1";
		int start=0;
		int end=0;
		int i=1;
			if ( from == null )
            start = 1 ;
        else
            start = Integer.parseInt( from ) ;

        if ( to == null )
            end = 12 ;
        else
            end = Integer.parseInt( to ) ;
	
		if(!rfid_tag_no.equals("")){			  
			if(search_criteria.equals("S")){
				whereBuffer.append("and upper(rfid_tag_num) like upper('"+rfid_tag_no+"%') ");
			}else if(search_criteria.equals("E")){
				whereBuffer.append("and  upper(rfid_tag_num) like upper('%"+rfid_tag_no+"') ");
			}else  if(search_criteria.equals("C")){
				whereBuffer.append("and  upper(rfid_tag_num) like upper('%"+rfid_tag_no+"%') ");
			}		
		}
      
        String rfid_tag_num = "";       
        String rowclass = "";       
       //Maheshwaran k modified the Query for the Bru-HIMS-CRF-369 -IN039615 as on 29/08/2013
      	sqlBuffer.append( " select rfid_tag_num,occupying_patient_id from XT_RFID_TAG where occupying_patient_id is null ");
		if(!patient_id.equals("")){
			sqlBuffer.append("union  SELECT rfid_tag_num, occupying_patient_id FROM xt_rfid_tag where occupying_patient_id = '"+patient_id+"'   ");    
		}
		
		if(!whereBuffer.equals(""))
			sqlBuffer.append(whereBuffer);
			 
		 
		 
     			stmt = con.createStatement() ;				
				rs     = stmt.executeQuery(sqlBuffer.toString()) ;		

				if ( !(start== 1) )			
				for( int j=1; j<start; i++,j++ )   
				rs.next() ;  

				int count=0 ;
				%>
				<form name ='RFIDTagForm'>
				 <table border='0' cellpadding='0' cellspacing='0' width='100%' >					
				 <%			
				
					while( i<=end && rs.next()){						
					   if ( count % 2 == 0 )
						  rowclass = "QRYEVEN" ;
					  else
						 rowclass = "QRYODD" ;
					  %>
					  <%
					  if(count == 0){%>
					  <tr width='100%' >
				<td align='right' class='white'>
					<table align='right'>
						<tr>
						   <td>
							<%
							if ( !(start <= 1) )
							{
								out.println("<A HREF='../../eMO/jsp/RFIDTagResult.jsp?rfid_tag_no="+rfid_tag_no+"&search_criteria="+search_criteria+"&from="+(start-12)+"&to="+(end-12)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
							}

							if (endOfRes.equals("1"))
							 {
								out.println("<A id='nextval' HREF='../../eMO/jsp/RFIDTagResult.jsp?rfid_tag_no="+rfid_tag_no+"&search_criteria="+search_criteria+"&from="+(start+12)+"&to="+(end+12)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
							 }

							
							%>
								</td>
								</tr>
								</table>
							</td>
							</tr>
						
					   <tr><td class='columnheader' width='15%'><fmt:message key="eMO.RFIDTag.label" bundle="${mo_labels}"/></td></tr>
					  <%}
					   count++;							
					    rfid_tag_num = rs.getString("rfid_tag_num");		
					    out.println("<tr style='background-color:'><td class='"+rowclass+"'><a href=javascript:closeRFID(\""+rfid_tag_num+"\")>");							
					    out.println(rfid_tag_num+"</a> ");
					    out.println("</td></tr>");
						i++;
     			      }
			       				
			
		
		if(count == 0){%>
			<script>	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); </script>
		<%}
		
		
		if (!rs.next() && count!=0 ){
		 endOfRes = "0";	
		 %><script>document.getElementById("nextval").innerHTML=" ";</script><% 
		 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{		
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();			
				if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
		}
%>		
</form>
	</body>
	</table>
</html>

<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

