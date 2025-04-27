<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eMO/js/MOEmbalmRegistration.js' language='javascript'></script>
<%


  request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey();' >");
Connection conn  =  null;
try{  
    

	conn 						 =  ConnectionManager.getConnection(request);
	StringBuffer sql 			 = new StringBuffer();
    String whereClause 			 = request.getParameter("whereclause");
	String function          	 = request.getParameter("function");
 	String facilityid			 =(String)session.getValue("facility_id");
    String from 				 = request.getParameter( "from" ) ;
    String to 					 = request.getParameter( "to" ) ;
	String function_id = request.getParameter("function_id");
	 
    if ( (whereClause == null || whereClause.equals("")) )
	 {
	  
	  String patientId  			     = request.getParameter("patientId");
	  String applicantID  		     	 = request.getParameter("ApplicantID");
	  String embalm_Status  		     = request.getParameter("Embalm_Status");
	  String dateofApplication  	     = request.getParameter("dateofApplication");
	  String todate  	     = request.getParameter("todate");	 
	  
	    if (!(patientId == null || patientId.equals("")) )
        {
        sql.append(" and upper (PATIENT_ID) like upper('"+patientId+"%')");
        }
		 if ( !(applicantID == null || applicantID.equals("")) )
        {
         sql.append(" and upper(REQUESTOR_ID) like upper('"+applicantID+"%')");
        }
		 if ( !(embalm_Status == null || embalm_Status.equals("")) )
        {    
		     if(!embalm_Status.equals("A")){
            sql.append(" and EMBALM_STATUS like '"+embalm_Status+"%'");}
       
	   }

	if(function.equals("EMBALM")){
	    if ( !(dateofApplication == null || dateofApplication.equals("")) )
        {			
         sql.append(" AND EMBALM_REQ_DATE = to_date('"+dateofApplication+"','dd/mm/yyyy') ");
        }
	}else{
		 if ( !(dateofApplication == null || dateofApplication.equals("")) ||  !(todate == null || todate.equals(""))){
		 if ( (dateofApplication == null || dateofApplication.equals("")) ) dateofApplication    = "01/01/1800";	
			
			 if ( !(todate == null || todate.equals("")) ){
				sql.append(" AND EMBALM_REQ_DATE between to_date('"+dateofApplication+"','dd/mm/yyyy') and to_date('"+todate+"','dd/mm/yyyy') ");
			 }else  {
				sql.append(" AND EMBALM_REQ_DATE between to_date('"+dateofApplication+"','dd/mm/yyyy') and to_date(sysdate,'dd/mm/yyyy') ");
			 }
		
	 }
	}

		
		String ord[] = request.getParameterValues("orderbycolumns");
	           
	              if ( !(ord == null || ord .equals("")) )
                   {     
                    sql.append(" order by ");
                    for ( int i=0;i < ord.length;i++ ) {   
			 
                  if ( i == ord.length - 1 )
                            sql.append(ord[i]);
                        else
                            sql.append(ord[i]).append(",");
                }            
              } 
	   } else
            sql.append(whereClause);    //whereclause else if
		   
		   String endOfRes="1";

			int start = 0 ;
			int end = 0 ;
			int i=1;
			int cnt=0;
			int maxRecord=0;
			if ( from == null )
				start = 1 ;
			else
	 			start = Integer.parseInt( from ) ;
			if ( to == null )
				end = 14 ;
			else
				end = Integer.parseInt( to ) ;
	 
    	 Statement stmt1;
         ResultSet rset;
	     stmt1=conn.createStatement();
         StringBuffer strsql1 = new StringBuffer(); 
		 strsql1.append("SELECT SRL_NO,PATIENT_ID,REQ_PATIENT_NAME,REQUESTOR_ID,EMBALM_STATUS,TO_CHAR(EMBALM_REQ_DATE, 'dd/mm/yyyy') EMBALM_REQ_DATE FROM MO_EMBALM_SERVICE WHERE FACILITY_ID='"+facilityid+"' ").append(sql);
		if(function.equals("EMBALM"))	{
			strsql1.append( ",srl_no desc");
		}else{
			strsql1.append( " AND EMBALM_STATUS !='09'  order by srl_no desc");
		}
	
		 rset = stmt1.executeQuery(strsql1.toString()); 
		 
            if ( start != 1 )
             for( int j=1; j<start; i++,j++ )
              rset.next() ;		 
		 
	     while ( i<=end && rset.next() )
         {
		   	if (cnt == 0)
	         { %>
			 
	<form name='query_resource' id='query_resource'>
    <P>
    <table align='right'>
    <tr>
    <td>	
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eMO/jsp/EmbalmQueryResult.jsp?function="+function+"&function_id="+function_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( endOfRes.equals("1") )

    out.println("<A id='nextval' HREF='../../eMO/jsp/EmbalmQueryResult.jsp?function="+function+"&function_id="+function_id+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>		
</td>
</tr>
</table><br><br>
</P>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td class='columnheader'><fmt:message key="Common.SlNo.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="eMO.ApplicantID.label" bundle="${mo_labels}"/></td>
<td class='columnheader'><fmt:message key="eMO.EmbalmStatus.label" bundle="${mo_labels}"/></td>
<td class='columnheader'><fmt:message key="eMO.DateofApplication.label" bundle="${common_labels}"/></td>
            <%}			 
		   
		     String classValue = "" ;
             if ( i % 2 == 0 )
             classValue = "QRYEVEN" ;
         else
	         classValue = "QRYODD" ;
			 
		     String disp_patientid	  =(rset.getString("PATIENT_ID")==null)?"&nbsp;":rset.getString("PATIENT_ID");
			 String patient_name     =(rset.getString("REQ_PATIENT_NAME")==null)?"&nbsp;":rset.getString("REQ_PATIENT_NAME");
			 String requestor_id	 =(rset.getString("REQUESTOR_ID")==null)?"":rset.getString("REQUESTOR_ID");
			  String requestor_date	 =(rset.getString("embalm_req_date")==null)?"&nbsp;":rset.getString("embalm_req_date");
			  String srl_no			 = rset.getString("srl_no");
			  String embl_status 	 = (rset.getString("embalm_status")==null)?"&nbsp;":rset.getString("embalm_status");
			 
			  String requestor_id_display="";
			  
			   
			 if(requestor_id.trim().equals("")){
			       requestor_id_display="&nbsp;";
			  }else{
			  requestor_id_display=requestor_id;
			  }	    
			  if(embl_status.equals("01"))
			            embl_status="Registered";  
               else if(embl_status.equals("04"))
      		 	      embl_status="Completed";
				 else if(embl_status.equals("09"))  
				       embl_status="Cancelled";
out.println("<tr><td align=='left' class='" + classValue + "'>"); 
if(function.equals("EMBALM"))	{
     if(!embl_status.equals("Cancelled")){
      out.println("<a href=javascript:showResult('" + srl_no + "','"+disp_patientid+"','"+requestor_id+"','"+function+"','"+facilityid+"') target=''>");
      out.println(srl_no+"</a></td><td class='" + classValue + "'>");}
   else {
         out.println(srl_no+"</a></td><td class='" + classValue + "'>");
		}
}else{
	out.println("<a href=javascript:showResult('" + srl_no + "','"+disp_patientid+"','"+requestor_id+"','"+function+"','"+facilityid+"') target=''>");
      out.println(srl_no+"</a></td><td class='" + classValue + "'>");
}
    out.println(disp_patientid);
    out.println("</td><td class='" + classValue + "'>");
    out.println(patient_name);
    out.println("</td><td class='" + classValue + "'>");
    out.println(requestor_id_display);
    out.println("</td><td class='" + classValue + "'>");
    out.println(embl_status);
    out.println("</td><td class='" + classValue + "'>");
    out.println(requestor_date);
    out.println("</td><td align='center' class='" + classValue + "'>");
	out.println("</td>");
		   i++;
		  cnt++;
		 } //while end	

		 
		 if( cnt == 0 )
	   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
		 
	if(!rset.next() && cnt!=0 )
     {
	     endOfRes = "0";		
    %>
	<input type='hidden' name='function_id' id='function_id' value='<%=function%>'>
<script>
	document.getElementById("nextval").innerHTML=" ";
	//document.getElementById("nextval").style.visibility='hidden';
</script>

  <% } 

		 
  if(stmt1!=null)stmt1.close();
   if(rset != null) rset.close();
	  sql.setLength(0); 
	  strsql1.setLength(0);
	  
}catch(Exception e)
	{
	  e.printStackTrace();
	}
finally
	{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);  

	}

%>
</td></tr>
</table>
</form>
</BODY>
</HTML>

