<!DOCTYPE html>
  <!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	FM\File movement history
-->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.* "  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/QueryFMCurrentFileStatus.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <head>

 <BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
 <form name="QueryFMSearchResult" id="QueryFMSearchResult" action="../../eFM/jsp/QueryFMCurrentFileStatusResult.jsp" method="post" 	>
 
 <%
		Connection con = ConnectionManager.getConnection(request);
		java.sql.Statement stmt	= null;
		ResultSet rset	= null ;
		java.sql.Statement stmt1	= null;
		ResultSet rset1	= null ;

		String facility			= (request.getParameter("facility")==null)?"":request.getParameter("facility") ;
		String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;
		
		   	
		String sql				= "" ;	
		String classValue		="";
		int	counter				=0;
 %>

  <%try{%>
		
	 <% 
		 
	 sql="SELECT APPT_REF_NO,TO_CHAR(APPT_DATE,'DD/MM/RRRR') APPT_DATE,TO_CHAR(APPT_DATE,'DY') DAY, " +
	"PRACTITIONER_SHORT_NAME,CLINIC_SHORT_DESC,APPT_TYPE_CODE,TO_CHAR(APPT_TIME,'HH24:MI')APPT_TIME, "+
	"TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') APPT_FROM_TIME, "+
	 "TO_CHAR(APPT_SLAB_TO_TIME,'HH24:MI') APPT_TO_TIME  FROM  OA_APPT_MR_LIST_VW  " +
    "WHERE FACILITY_ID='" + facility +"' AND PATIENT_ID='" + patientid + "' AND TRUNC(APPT_DATE)>= SYSDATE";

		  								 
	stmt			= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                     ResultSet.CONCUR_UPDATABLE);
    rset		 	= stmt.executeQuery(sql) ;
			 
	%>
			
<table border="1" cellpadding="0" cellspacing="0" align='center' width="100%">
				
		<tr >
			<th  width="10%" height="20" ><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></th>
			<th  width="9%" height="20" ><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
			<th  width="4%" height="20" ><fmt:message key="Common.day.label" bundle="${common_labels}"/></th>
			<th  width="25%" height="20" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			<th  width="27%" height="20" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></th>
			<th  width="13%" height="20" ><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>			
			<th  width="12%" height="20" >&lt;--<fmt:message key="Common.time.label" bundle="${common_labels}"/>--&gt;<br>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</th>
		</tr>


		<%while(rset.next()){
				
				counter++ ;
				if ( counter % 2 == 0 )
		  		classValue = "QRYODD" ;
				else
		  		classValue = "QRYEVEN" ;
			
		%>
			<tr>
			
			<td  width="10%" height="20" class='<%=classValue%>' ><font size=1><%=(rset.getString("APPT_REF_NO")==null)?"":"<b>"+rset.getString("APPT_REF_NO")%>
			</td>
			
			<td  width="9%" height="20" class='<%=classValue%>' ><font size=1>
			<%=(rset.getString("APPT_DATE")==null)?"&nbsp":rset.getString("APPT_DATE")%>
			</td>
			
			<td  width="4%" height="20" class='<%=classValue%>'><font size=1>
			<%=(rset.getString("DAY")==null)?"&nbsp":rset.getString("DAY")%>
			</td>
			
			<td  width="25%" height="20" class='<%=classValue%>'><font size=1>
			<%=(rset.getString("PRACTITIONER_SHORT_NAME")==null)?"&nbsp":
			rset.getString("PRACTITIONER_SHORT_NAME")%>
			</td>
			
			<td  width="27%" height="20" class='<%=classValue%>'><font size=1>
			<%=(rset.getString("CLINIC_SHORT_DESC")==null)?"&nbsp":rset.getString("CLINIC_SHORT_DESC")%> </td>	
			<%
			String DecodeVisitTypeCode ="";
			String VISIT_TYPE_CODE=				(rset.getString("APPT_TYPE_CODE")==null)?"":rset.getString("APPT_TYPE_CODE")  ;
			 sql="select  SHORT_DESC from op_visit_type where VISIT_TYPE_CODE='" +VISIT_TYPE_CODE+ "'"; 
			stmt1			= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                     ResultSet.CONCUR_UPDATABLE);
		    rset1		 	= stmt1.executeQuery(sql) ;
			if(rset1.next())
			{
			DecodeVisitTypeCode =
			(rset1.getString("SHORT_DESC")==null)?"&nbsp":rset1.getString("SHORT_DESC")	;
			}
			if(rset1!=null)	rset1.close();
			if(stmt1!=null)	stmt1.close();
			%>

			<td  width="13%" height="20" class='<%=classValue%>'><font size=1>
			<%=DecodeVisitTypeCode%> 
			</td>			
			
			<td  width="12%" height="20" class='<%=classValue%>'><font size=1>&nbsp;
		<%=(rset.getString("APPT_FROM_TIME")==null)?"&nbsp":rset.getString("APPT_FROM_TIME")%>&nbsp;
		&nbsp;<%=(rset.getString("APPT_TO_TIME")==null)?
		 "&nbsp":rset.getString("APPT_TO_TIME")%> 
			</td>
		</tr>

	<%}%>
		
	</table>
    
 <%
	if(stmt!=null)	stmt.close();
	if(rset!=null)	rset.close();
	if(stmt1!=null)	stmt1.close();
	if(rset1!=null)	rset1.close();	 
 }catch(Exception e){
		  out.println("Exception while fetching connection :" + e ) ;
}finally{ 
	 
	ConnectionManager.returnConnection(con, request); 
 }%>

   <input type='hidden' name='facility' id='facility' value='<%=facility%>' >	 
  <input type='hidden' name='patientid' id='patientid' value=<%=patientid%> >	
 
 </form>
 </body>
 </html>

