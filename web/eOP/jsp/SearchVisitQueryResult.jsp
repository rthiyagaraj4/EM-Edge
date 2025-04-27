<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>

<html>
<head>


<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>



	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eOP/js/rowcolor.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eOP/js/ReviseVisit.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>

<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<form name = "SearchVisitQueryResult" id = "SearchVisitQueryResult">
<% 
	Connection conn=null;
	Statement stmt=null;	
    ResultSet rs=null;
	String op_episode_visit_num="";
	String episode_id="";
	String p_mode=request.getParameter("pmode");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String bl_install_yn= ((String)session.getValue( "bl_operational" ))==null?"N":((String)session.getValue( "bl_operational" )) ;//added for Package Billing
	//String package_bl_install_YN="";
	String locale = (String) session.getValue("LOCALE");
	String  where_criteria= request.getParameter("where_criteria");
	String  package_bl_install_YN= "N";
	if (where_criteria==null) where_criteria= "";
	String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");
	String bl_interfaced_yn=request.getParameter("bl_interfaced_yn")==null?"":request.getParameter("bl_interfaced_yn");
	String Include_Arrive_startCons_yn=request.getParameter("Include_Arrive_startCons_yn")==null?"":request.getParameter("Include_Arrive_startCons_yn");
	String loginuser 	= (String) session.getValue( "login_user" ) ;
	String whereClause = request.getParameter("whereclause");
	if (whereClause == null || whereClause.equals("null"))	whereClause = "";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;	
	if (p_mode == null || p_mode.equals("null") ) p_mode = "";
    int start=0;
	int end=0;
	int i=1;
	String endOfRes="1";
	int aname=1;
	StringBuffer where_criteria_build= new StringBuffer();
	where_criteria_build.setLength(0);

		if ( from == null )
            start = 1 ;
        else
            start = Integer.parseInt( from ) ;

        if ( to == null )
            end = 16 ;
        else
            end = Integer.parseInt( to ) ;
try
{
	conn=ConnectionManager.getConnection(request);
	
    if(!whereClause.equals("")) 
	{
		where_criteria_build.append(whereClause);   
    } else 
	{
		if(!(p_mode==null || p_mode.equals(""))) 
		{
			if (p_mode.equals("CANCELVISIT")) 
			{
				/*		Modified for CRF - PMG20089-CRF-0541 (IN08081) 
						Modified by Suresh M
				*/
				if(Include_Arrive_startCons_yn.equals("Y")) 
					where_criteria_build.append(" AND A.QUEUE_STATUS <= '04' ");
				else
			 		where_criteria_build.append(" AND A.QUEUE_STATUS = '01' ");  

			   where_criteria_build.append(" AND EXISTS (SELECT 1 FROM AM_OS_USER_LOCN_ACCESS_VW WHERE FACILITY_ID = A.FACILITY_ID  AND LOCN_CODE = A.LOCN_CODE AND OPER_STN_ID = '"+oper_id+"' AND APPL_USER_ID = '"+loginuser+"' AND LOCN_TYPE = A.LOCN_TYPE AND CANCEL_VISIT_YN = 'Y') ");
            
			}else 	if(p_mode.equals("REVISEVISIT")) 
			{     			 
			  where_criteria_build.append(" AND A.QUEUE_STATUS IN('01','02','03','04') AND EXISTS (SELECT 1 FROM AM_OS_USER_LOCN_ACCESS_VW WHERE FACILITY_ID = A.FACILITY_ID  AND LOCN_CODE = A.LOCN_CODE AND OPER_STN_ID = '"+oper_id+"' AND APPL_USER_ID = '"+loginuser+"' AND LOCN_TYPE = A.LOCN_TYPE AND REVISE_VISIT_YN = 'Y') ");
			}		
		 }
	}
	 
	stmt = conn.createStatement();//added for Package Billing

	if(p_mode.equals("REVISEVISIT") && bl_install_yn.equals("Y")){//added for Package Billing
		package_bl_install_YN= request.getParameter("package_bl_install_YN")==null?"N":request.getParameter("package_bl_install_YN");
	}		  
		   
	StringBuffer strsql2=new StringBuffer().append("SELECT A.ENCOUNTER_ID ENCOUNTER_ID, A.OP_EPISODE_VISIT_NUM, A.EPISODE_ID, TO_CHAR (A.CHECK_IN_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME, A.QUEUE_STATUS QUEUE_STATUS_DESC, A.ARRIVE_DATE_TIME ARRIVE_DATE_TIME, A.VITAL_SIGNS_DATE_TIME VITAL_SIGNS_DATE_TIME, OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.LOCN_CODE,'"+locale+"',1) CLINIC_DESC, A.PATIENT_ID PATIENT_ID, AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"',1) PRACTITIONER_NAME, TO_CHAR(A.QUEUE_DATE, 'DD/MM/YYYY') QUEUE_DATE, (CASE WHEN INSTR(GET_PATIENT_LINE(A.PATIENT_ID,'"+locale+"'),'#')>0 THEN  SUBSTR(GET_PATIENT_LINE(A.PATIENT_ID,'"+locale+"'),1,INSTR(GET_PATIENT_LINE(A.PATIENT_ID,'"+locale+"'),'#')-1) END ) PATIENT_DETAILS, A.QUEUE_NUM QUEUE_NUM FROM  OP_CURRENT_PATIENT A, OP_PARAM B");
	if(!(p_mode==null || p_mode.equals(""))) 
	{
		//strsql2.append(", AM_OS_USER_LOCN_ACCESS_VW b  WHERE A.FACILITY_ID = '"+facilityId+"' AND A.FACILITY_ID = E.OPERATING_FACILITY_ID ");
	} 
	else 
	{
		strsql2.append("  WHERE A.FACILITY_ID = '"+facilityId+"' AND A.FACILITY_ID = B.OPERATING_FACILITY_ID ");
	}
	if(!p_mode.equals(""))
			strsql2.append(" WHERE A.FACILITY_ID = '"+facilityId+"' AND A.FACILITY_ID = B.OPERATING_FACILITY_ID AND TRUNC(SYSDATE)-TRUNC(A.CHECK_IN_DATE_TIME)<= B.VISIT_REV_CANCEL_DAYS ");

	 strsql2.append(where_criteria).append(where_criteria_build.toString()).append(" ORDER BY A.CHECK_IN_DATE_TIME");
	 

	 //stmt = conn.createStatement();	 //added for Package Billing commented and moved to the top
	 rs = stmt.executeQuery(strsql2.toString());

	 if ( !(start== 1) )			
			for( int j=1; j<start; i++,j++ )   
				rs.next() ;  
	 
	 int cnt=0;

	 try {	
		
		while( i<=end && rs.next() )
		{ 
			if(cnt == 0)
			{
				%>
				<p>
				<table border="0" width="100%" cellspacing='0' cellpadding='0' align='center'>
				<tr width='100%' >
				<td align='right' class='white'>
					<table align='right'>
						<tr>
						   <td>
							<%
							if ( !(start <= 1) )
							{
								out.println("<A HREF='../../eOP/jsp/SearchVisitQueryResult.jsp?package_bl_install_YN="+package_bl_install_YN+"&bl_interfaced_yn="+bl_interfaced_yn+"&oper_id="+oper_id+"&pmode="+p_mode+"&from="+(start-16)+"&to="+(end-16)+"&whereclause="+URLEncoder.encode(where_criteria+where_criteria_build.toString())+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
							}

							if (endOfRes.equals("1"))
							 {
								out.println("<A id='nextval' HREF='../../eOP/jsp/SearchVisitQueryResult.jsp?package_bl_install_YN="+package_bl_install_YN+"&bl_interfaced_yn="+bl_interfaced_yn+"&oper_id="+oper_id+"&pmode="+p_mode+"&from="+(start+16)+"&to="+(end+16)+"&whereclause="+URLEncoder.encode(where_criteria+where_criteria_build.toString())+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
							 }

							strsql2.setLength(0);
							%>
								</td>
								</tr>
								</table>
							</td>
							</tr>
							<tr>

							<table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1' align='center' >
								<tr>
								<th class='columnheader' width='15%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
								<th class='columnheader' width='15%' ><fmt:message key="Common.regndatetime.label" bundle="${common_labels}"/></th>
								<th class='columnheader' width='25%'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
								<th class='columnheader' width='15%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
								<th class='columnheader' width='15%' ><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
								<th class='columnheader' width='15%'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></th>
			<%
			}

			String rowclass = "" ;

			String visit_adm_dtime="";
			String	encounterID="";
			String	patDetails="";
			String locationDesc="";
			String practDesc="";
			String	queueStatus="";
			String	status="";
			String queue_date="";
			String patientID="";
			String arrive_date_time="";
			String vital_signs_date_time="";
			int queue_num=0;
	

	
	    if ( i % 2 == 0 )
            rowclass = "QRYEVEN" ;
        else
            rowclass = "QRYODD" ;
    
      	visit_adm_dtime=rs.getString("VISIT_ADM_DATE_TIME");
		encounterID=rs.getString("encounter_id");
        op_episode_visit_num=rs.getString("op_episode_visit_num")==null?"":rs.getString("op_episode_visit_num");
		episode_id=rs.getString("episode_id")==null?"":rs.getString("episode_id"); 
		
		
		patDetails=rs.getString("PATIENT_DETAILS");
		locationDesc=rs.getString("CLINIC_DESC");
		practDesc=rs.getString("PRACTITIONER_NAME");
		if(practDesc == null) practDesc="&nbsp;";
		queueStatus=rs.getString("QUEUE_STATUS_DESC");
		status = queueStatus;		
		if(queueStatus == "00")
			queueStatus=" ";
		else if(queueStatus.equals("01"))
			queueStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckedIn.label","op_labels");
		else if(queueStatus.equals("02"))
			queueStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ArrivedAtNursStn.label","op_labels");
		else if(queueStatus.equals("03"))
			queueStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VitalSignRecorded.label","op_labels");
		else if(queueStatus.equals("04"))
			queueStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
		else if(queueStatus.equals("05"))
			queueStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treat/Invest.label","common_labels");
		else if(queueStatus.equals("06"))
			queueStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RetFrmInvest.label","op_labels");
		else if(queueStatus.equals("07"))
			queueStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedOut.label","common_labels");
		else if(queueStatus.equals("08"))
		queueStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.AutoCloseVisit.label","op_labels");
		else if(queueStatus.equals("09"))
		queueStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.AutoCloseVisit.label","op_labels");
		


		if(queueStatus == null) queueStatus="&nbsp;";
		queue_date=rs.getString("queue_date");
		patientID=rs.getString("patient_id");
		arrive_date_time=rs.getString("arrive_date_time");
		vital_signs_date_time=rs.getString("vital_signs_date_time");
		queue_num=rs.getInt("queue_num");

		String visit_adm_dtime_display=DateUtils.convertDate(visit_adm_dtime,"DMYHM","en",locale);
        out.println("<tr style='background-color:'><td class='"+rowclass+"'>");

%>
    <a name="<%=aname%>" id="<%=aname%>"  onClick="changeRowColor(this,6);"  href="javascript:closew('<%=encounterID%>','<%=queue_date%>','<%=patientID%>','<%=queueStatus%>','<%=arrive_date_time%>','<%=vital_signs_date_time%>','<%=queue_num%>','<%=bl_interfaced_yn%>','<%=status%>','<%=op_episode_visit_num%>','<%=episode_id%>','<%=cnt%>','<%=package_bl_install_YN%>');"> <!-- added for Package Billing -->   
 
<%
        out.println(encounterID+"</a>");
		out.println("</td><td class='"+rowclass+"'>" );
        out.println(visit_adm_dtime_display+"</td><td class='"+rowclass+"'>" );
        out.println(patDetails+"</td><td class='"+rowclass+"'>" );
		out.println(locationDesc+"</td><td class='"+rowclass+"'>" );
		out.println(practDesc+"</td><td class='"+rowclass+"'>" );
        out.println(queueStatus+"</td></tr>" );
        aname++;
        i++;
		cnt++;
    }
	//rs.previous();
   if (!rs.next() && cnt!=0 )
    {
    endOfRes = "0";	
	
	%>
		<script>
		document.getElementById("nextval").innerHTML=" ";
		//document.getElementById("nextval").style.visibility='hidden';
		</script>
		<!-- <tr>
			<td class='labelcenter' colspan='12'><fmt:message key="Common.EndofResults.label" bundle="${common_labels}"/></td>
		</tr>	 -->
	<%
 }
}catch(Exception e){
	
	e.printStackTrace();
	}

	  if(stmt != null) stmt.close();
	  if(rs != null) rs.close();
	  where_criteria_build.setLength(0);

if(cnt==0)	
   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");

}catch(Exception e)
   {
   }
   
   finally
   {
      try{
	  out.println("<script>parent.frames[1].document.forms[0].Search.disabled = false ;</script>");
	  
	  if(rs != null) rs.close();
	  if(stmt != null) stmt.close();
	  
	  }catch(Exception e){}

	  if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }
%>
</table>
</tr>
</table>
<input type='hidden' name='patientid' id='patientid'>
<input type='hidden' name='where_criteria' id='where_criteria' value="<%=where_criteria%>">
<input type='hidden' name='oper_id' id='oper_id' value="<%=oper_id%>">
<!-- added for Package Billing -->
<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>">

</form>
</BODY>
</HTML>





