<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	</head>


	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eOP/js/OPCancelledCheckout.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
    <form name="maitain_acc_per" id="maitain_acc_per"  method="post" target="messageFrame">
	<%
    request.setCharacterEncoding("UTF-8");
    String locale=(String)session.getAttribute("LOCALE");
    String Facility_Id = (String) session.getValue("facility_id");
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
    
		String encounterid="";
		
		String classValue="";
		String disposition="";
		String checkout="";
		String visit="";
		String patientid="";
		String patientname="";
		String location="";
		String speciality="";
		String practitioner="";
		String cancelleddate="";
		String cancellresons="";
		String cancelledby="";
		String gender_tab="";
	    String gender_st="";
	    String cancel_checkout_remarks=""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		Boolean isRemarksFieldAppl = false;

Connection con = ConnectionManager.getConnection(request);
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	
     String from = request.getParameter( "from" ) ;
	 String to = request.getParameter( "to" ) ;
	 try{

		isRemarksFieldAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "REMARKS_FOR_OTHERS"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

         if ( (whereClause == null || whereClause.equals("")) )
	    {

			  String speciality_desc = request.getParameter("speciality_desc")==null?"":request.getParameter("speciality_desc");
			  String oplocation_desc = request.getParameter("location_desc")==null?"":request.getParameter("location_desc");
			  String oppract_desc = request.getParameter("pract_desc")==null?"":request.getParameter("pract_desc");
			  String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			  String gender = request.getParameter("gender")==null?"":request.getParameter("gender");
			  //String encounter_id = request.getParameter("encounter_id");
			  String txtdtfrm = request.getParameter("patfrom")==null?"":request.getParameter("patfrom");
			  String txtdtto = request.getParameter("patto")==null?"":request.getParameter("patto");
              String cancelled_by = request.getParameter("cancelled_by")==null?"":request.getParameter("cancelled_by");
			  String locationtype =request.getParameter("locationtype")==null?"":request.getParameter("locationtype");
			 // String sysdate =request.getParameter("sysdate1")==null?"":request.getParameter("sysdate1");
			

			  
              if(!oplocation_desc.equals(""))
		     sql.append(" and a.LOCN_CODE = '"+oplocation_desc+"' ");

			  
              if(!locationtype.equals(""))
		     sql.append(" and a.LOCN_TYPE = '"+locationtype+"' ");

			  if(!oppract_desc.equals(""))
		     sql.append(" and a.PRACTITIONER_ID = '"+oppract_desc+"' ");

			  if(!patient_id.equals(""))
		     sql.append(" and a.PATIENT_ID = '"+patient_id+"' ");

              if(!gender.equals("A"))
             	{
			     if(!gender.equals(""))
		         sql.append(" and b.Sex = '"+gender+"' ");
	           }

			  if(!speciality_desc.equals(""))
		       sql.append(" and a.SPECIALITY_CODE = '"+speciality_desc+"' ");

	         if(!cancelled_by.equals(""))
		     sql.append(" and a.CANCELLED_BY_ID = '"+cancelled_by+"' ");

             /*if(!txtdtfrm.equals(""))
		     sql.append(" AND TO_CHAR(TRUNC(TO_DATE (a.QUEUE_DATE, 'dd/mm/yyyy'))) = TO_CHAR(TO_DATE ('"+txtdtfrm+"', 'dd/mm/yyyy')) ");

	         if(!txtdtto.equals(""))
	          sql.append(" AND TO_CHAR(TRUNC(TO_DATE (a.CANCELLED_DATE, 'dd/mm/yyyy'))) = TO_CHAR(TO_DATE ('"+txtdtto+"', 'dd/mm/yyyy')) ");*/
			  if(!txtdtfrm.equals(""))
			{
				sql.append(" and trunc(a.queue_date) >= trunc(to_date('"+txtdtfrm+"','dd/mm/yyyy')) ");
			}

			if(!txtdtto.equals(""))
			{
				sql.append(" and trunc(a.queue_date) <= trunc(to_date('"+txtdtto+"','dd/mm/yyyy')) ");
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


	}
	else
	{
	sql.setLength(0);
	sql.append(whereClause);
	}   
       
}
	 catch(Exception e){
		 out.println("valu "+ e);
		 }



	 int start = 0 ;
	 int end = 0 ;
	 int i=1;

	 if ( from == null )
		start = 1 ;
	 else
		start = Integer.parseInt( from ) ;

	 if ( to == null )
	  	end = 12 ;
	 else
		end = Integer.parseInt( to ) ;
		try
		{
			pstmt = con.prepareStatement("SELECT a.ENCOUNTER_ID,a.LOCN_TYPE,to_char(a.QUEUE_DATE,'dd/mm/yyyy hh24:mi') QUEUE_DATE, a.PATIENT_ID, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name,b.Sex Gender, op_get_desc.OP_CLINIC(a.facility_id,a.LOCN_CODE, '"+locale+"',1) clinic_desc , a.SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(a.SPECIALITY_CODE,'"+locale+"',2)  SPECIALITY_DESC, a.PRACTITIONER_ID, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, to_char(a.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, a.DISASTER_YN, a.TRAUMA_YN, am_get_desc.am_disposition_type(a.disposition_type,'"+locale+"',2) disposition_short_desc, a.CANCEL_REASON_CODE, am_get_desc.am_contact_reason(a.CANCEL_REASON_CODE,'"+locale+"',1) CANCEL_REASON_DESC, a.CANCELLED_BY_ID, sm_get_desc.SM_APPL_USER(a.CANCELLED_BY_ID,'en',1) user_name,to_char(a.CANCELLED_DATE,'dd/mm/yyyy hh24:mi') CANCELLED_DATE, c.cancel_checkout_remarks FROM op_cancelled_checkout a,mp_patient b, op_patient_queue c WHERE a.facility_id = '"+Facility_Id+"'  and  a.patient_id = b.patient_id AND a.facility_id = c.facility_id AND a.encounter_id = c.encounter_id AND a.patient_id = c.patient_id AND b.patient_id = c.patient_id and a.patient_class='OP'"+sql.toString()); //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

			rs = pstmt.executeQuery();
			int cnt=0;
	  String endOfRes="1";
	  	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }
  
 while (i<=end && rs.next()){
	if(cnt==0){

%>
<P>
<table align='right'>
<tr >
<td>
<%
if ( !(start <= 1) )
		{
	%>
	<A HREF='../../eOP/jsp/OPCancelledCheckoutQuerySearchResult.jsp?from=<%=(start-12)%>&to=<%=(end-12)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>

	<%
		}

if (endOfRes.equals("1"))
		{
	%>
		<A id='nextvalue' HREF='../../eOP/jsp/OPCancelledCheckoutQuerySearchResult.jsp?from=<%=(start+12)%>&to=<%=(end+12)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>

<%
		}
%>
</td>
</tr>
</table>
	<br><br>
</P><table border="1"  cellspacing='0' cellpadding='0' width="100%">
	<tr>
		<th><fmt:message key="Common.DispType.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></th>
	    <th><fmt:message key="Common.CheckoutDate.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>

		<th><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>


		<th><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/> <fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></th>
		<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
		<%if(isRemarksFieldAppl){%>
		<th><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		<%}%>
		<th><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></th>
		</tr>
<%}		
		
		
cnt++;

if (i % 2 == 0 )
  	classValue = "QRYEVEN" ;
 else
  	classValue = "QRYODD" ;
     gender_tab=rs.getString("Gender");
		if(gender_tab.equals("M"))
			gender_st="Male";
		else if(gender_tab.equals("F"))
			gender_st="Female";
		else if(gender_tab.equals("U"))
			gender_st="Unknown";
   disposition	= (rs.getString("disposition_short_desc")==null?"&nbsp;":rs.getString("disposition_short_desc"));
   visit	= (rs.getString("QUEUE_DATE")==null?"&nbsp;":rs.getString("QUEUE_DATE"));
   visit = DateUtils.convertDate(visit,"DMYHM","en",locale);/*Added by Rameswar on 30-Sep-15 for Leap Year Issue*/
   checkout	= (rs.getString("DISCHARGE_DATE_TIME")==null?"&nbsp;":rs.getString("DISCHARGE_DATE_TIME"));
   checkout = DateUtils.convertDate(checkout,"DMYHM","en",locale);/*Added by Rameswar on 30-Sep-15 for Leap Year Issue*/
   patientid	= (rs.getString("PATIENT_ID")==null?"&nbsp;":rs.getString("PATIENT_ID"));
   patientname= (rs.getString("patient_name")==null?"&nbsp;":rs.getString("patient_name"));
   encounterid	= (rs.getString("ENCOUNTER_ID")==null?"&nbsp;":rs.getString("ENCOUNTER_ID"));
   location	= (rs.getString("clinic_desc")==null?"&nbsp;":rs.getString("clinic_desc"));
   speciality	= (rs.getString("SPECIALITY_DESC")==null?"&nbsp;":rs.getString("SPECIALITY_DESC"));
   practitioner=(rs.getString("practitioner_name")==null?"&nbsp;":rs.getString("practitioner_name"));
   cancelleddate=(rs.getString("CANCELLED_DATE")==null?"&nbsp;":rs.getString("CANCELLED_DATE"));
   cancelleddate= DateUtils.convertDate(cancelleddate,"DMYHM","en",locale);/*Added by Rameswar on 30-Sep-15 for Leap Year Issue*/
   cancellresons=(rs.getString("CANCEL_REASON_DESC")==null?"&nbsp;":rs.getString("CANCEL_REASON_DESC"));
   cancelledby=(rs.getString("user_name")==null?"&nbsp;":rs.getString("user_name"));

   cancel_checkout_remarks=(rs.getString("cancel_checkout_remarks")==null?"&nbsp;":rs.getString("cancel_checkout_remarks")); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114


    out.println("<tr>");
    out.println("<td class='" + classValue + "' nowrap><font size=1>"+disposition +"</td>");
    out.println("<td class='" + classValue + "' nowrap><font size=1>"+visit +"</td>");
    out.println("<td class='" + classValue + "' nowrap><font size=1>"+checkout +"</td>");
    out.println("<td class='" + classValue + "' nowrap><font size=1>"+patientid +"</td>");
    out.println("<td class='" + classValue + "' nowrap><font size=1>"+patientname +"</td>");
    out.println("<td class='" + classValue + "' nowrap><font size=1>"+gender_st +"</td>");
    out.println("<td class='" + classValue + "'nowrap><font size=1>"+encounterid +"</td>");
	out.println("<td class='" + classValue + "' nowrap><font size=1>"+location +"</td>");
	out.println("<td class='" + classValue + "' nowrap><font size=1>"+speciality +"</td>");
	out.println("<td class='" + classValue + "' nowrap><font size=1>"+practitioner +"</td>");
	out.println("<td class='" + classValue + "' nowrap><font size=1>"+cancelleddate +"</td>");
	out.println("<td class='" + classValue + "' nowrap><font size=1>"+cancellresons +"</td>");
	//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	if(isRemarksFieldAppl){
	out.println("<td class='" + classValue + "' nowrap><font size=1>"+cancel_checkout_remarks +"</td>");
	}
	out.println("<td class='" + classValue + "' nowrap><font size=1>"+cancelledby +"</td>");
  
   out.println("</tr>");

				 i++;

	
			}

			if( cnt == 0 )						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");

		if(!rs.next()&&cnt!=0){
	endOfRes="0";
	%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
		<!--<tr>
			<td class='labelcenter' colspan='14'><fmt:message key="Common.EndofResults.label" bundle="${common_labels}"/></td>
		</tr>-->	
	<%}
	
 %>

 <%
			if(rs!=null)rs.close();
			pstmt.close();
		}catch(Exception e)
		{ out.println(e); }
		finally{
		 	 if(rs!=null) rs.close();
			 if(pstmt!=null) pstmt.close();
		     if(con!=null)
		 ConnectionManager.returnConnection(con,request);
	}

		
%>
</table>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

