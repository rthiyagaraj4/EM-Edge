<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>				    
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eAE/js/AESearchVisit.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onMouseDown="CodeArrest()"  onKeyDown = 'lockKey()'>
<!-- Tuesday, January 12, 2010 changed method (post to get) 18111 -->
<form name = "SearchVisitQueryResult" action="../../eAE/jsp/AESearchVisitQueryResult.jsp" method="get"  >
<% 
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

Connection conn=null;
PreparedStatement pstmt	= null ;
ResultSet rs=null;
String	encounter_id="";
String patient_id="";


String p_mode=request.getParameter("pmode");
String function_name=request.getParameter("function_name")==null?"":request.getParameter("function_name");
String Include_Arrive_startCons_yn=request.getParameter("Include_Arrive_startCons_yn")==null?"":request.getParameter("Include_Arrive_startCons_yn");
//Below line Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
String five_level_triage_appl_yn =	(request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");

String max_days1=request.getParameter("max_days_allow_update");
if ((max_days1 == null) ||  (max_days1.equals("null")) || (max_days1.equals("")))
   max_days1 = "0";
String oper_stn_id = request.getParameter("oper_stn_id");
if (oper_stn_id == null) oper_stn_id = "";
String facilityId = (String) session.getValue( "facility_id" ) ;
String  where_criteria1= request.getParameter("where_criteria");
int max_days=0;
max_days=Integer.parseInt(max_days1);
String loginuser 	= (String) session.getValue( "login_user" ) ;
String whereClause = request.getParameter("whereclause");
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
String queue_status_desc = "";
if (p_mode == null) p_mode = "";

int start=0;
int end=0;
int i=0;
int aname=1;
StringBuffer  where_criteria = new StringBuffer();
where_criteria.append(where_criteria1);
try
{
	conn=ConnectionManager.getConnection(request);
%>
</head>
<%
try
{
	
    if(whereClause!=null)
    {
    where_criteria.append(whereClause);
    }
    if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
    if (to == null){ end = 11; }   else {  end = Integer.parseInt( to ) ; }

   if(!(p_mode==null || p_mode.equals("")))
    {
        if (p_mode.equals("CANCELVISIT"))
        {
			/*		Modified for CRF - PMG20089-CRF-0541 (IN08081)
					Modified by Suresh M Date : 11/12/2009
			*/
				
			 if(Include_Arrive_startCons_yn.equals("Y")) 
				 where_criteria.append(" and a.queue_status <='04' ");
			else
				where_criteria.append(" and a.queue_status='01' ");

          where_criteria.append(" and trunc(sysdate)-trunc(a.queue_date) < "+max_days+"  and a.LOCN_CODE not in   (select  locn_code from am_restrn_for_oper_stn where facility_id = '"+facilityId+"' and Oper_stn_id='"+oper_stn_id+"'  and appl_user_id = '"+loginuser+"' and cancel_visit_yn = 'N' )");
        }
        if(p_mode.equals("REVISEVISIT"))
        {         
          where_criteria.append(" and a.queue_status<='02'  and (sysdate - a.queue_date)< "+max_days+" and a.LOCN_CODE not in   (select  locn_code from am_restrn_for_oper_stn where facility_id = '"+facilityId+"' and Oper_stn_id='"+oper_stn_id+"'  and appl_user_id = '"+loginuser+"' and  revise_visit_yn = 'N')  ");
        }
    }
}
catch(Exception e)
{
	e.printStackTrace();
}

try{    
    StringBuffer strsql3 = new StringBuffer();
	strsql3.append("select  a.encounter_id,to_char(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time, a.queue_status, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.LOCN_CODE,'"+locale+"','1') clinic_desc, OP_GET_DESC.OP_VISIT_TYPE(a.FACILITY_ID, a.VISIT_TYPE_CODE,'"+locale+"','2') visit_type_desc,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE, a.treatment_area_code,'"+locale+"' ,'2') treatment_area_desc,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') practitioner_name, to_char(a.queue_date,'dd/mm/yyyy') queue_date, a.patient_id,decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name,SUBSTR (get_patient_line (a.patient_id,'"+locale+"'),1,INSTR (get_patient_line (a.patient_id,'"+locale+"'),'#')- 1) patient_details  from op_patient_queue a, mp_patient b  where a.patient_class = 'EM' and  a.facility_id = ?  and a.patient_id = b.patient_id ");
	strsql3.append(where_criteria.toString());
	strsql3.append("order by to_date(queue_date,'dd/mm/yyyy hh24:mi') desc");
	
    pstmt=conn.prepareStatement(strsql3.toString());
	pstmt.setString(1, facilityId);
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
		<table border="0" width="100%" cellspacing='0' cellpadding='0' align='center' >
		<tr width='100%' >
		<td align='right' class='white'>
			<table align='right'>
                <tr>
                   <td>
                 <%
					if ( !(start <= 1)) {
				%>
					<A href='javascript:submitPrevNext(<%=(start-11)%>,<%=(end-11)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A> 
				<%
					}
					if (endOfRes.equals("1")){
				%>
					<A  id='nextvalue' href='javascript:submitPrevNext(<%=(start+11)%>,<%=(end+11)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A> 
					
				<%
                }
				%>
		   	</td>
        </tr>
    </table>
</td>
</tr>
<tr>

<table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1' align='center'>
<tr>
    <th width='15%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
    <th width='15%'><fmt:message key="Common.regndatetime.label" bundle="${common_labels}"/></th>
    <th width='25%'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
    <th width='15%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
	<% if(Include_Arrive_startCons_yn.equals("Y"))  {%>
 	<th width='15%'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></th>
	<% }%>
	<th width='15%'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></th>
<%}

String rowclass = "" ;
String visit_adm_dtime="";
String locationDesc="";
String practDesc="";
String	queueStatus="";
String queue_date="";
String patient_name="";
String treatment_area_desc="";

        if ( i % 2 == 0 )
            rowclass = "QRYEVEN" ;
        else
            rowclass = "QRYODD" ;

		visit_adm_dtime=rs.getString("visit_adm_date_time");
		encounter_id=rs.getString("encounter_id");
		patient_id=rs.getString("patient_id");
		
		patient_name=rs.getString("patient_details");
		locationDesc=rs.getString("clinic_desc");
		practDesc=rs.getString("practitioner_name");			
		if(practDesc == null) practDesc="";
		
		treatment_area_desc=rs.getString("treatment_area_desc");
			if(treatment_area_desc == null) treatment_area_desc="";

		queueStatus=rs.getString("queue_status");
		if(queueStatus == null) queueStatus="&nbsp;";
		if(queueStatus.equals(""))
        queue_status_desc ="&nbsp;";
		if(queueStatus.equals("01"))			        queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
		if(queueStatus.equals("02"))                  queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels");		
		if(queueStatus.equals("03"))						queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels");
		if(queueStatus.equals("04"))		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");	
		if(queueStatus.equals("07"))		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
		if(queueStatus.equals("09"))		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Autoclosed.label","ae_labels");
		if(queueStatus.equals("99"))		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
		 
		queue_date=rs.getString("queue_date");
		patient_id=rs.getString("patient_id");

		int count =0;
		
	String sql1 ="select count(*) from AE_PAT_EMERGENCY_DETAIL where encounter_id = '"+encounter_id+"' and facility_id ='"+facilityId+"' ";
		
		
		 ResultSet rs1=null;
		 pstmt=conn.prepareStatement(sql1);
		 rs1=pstmt.executeQuery(sql1);
			while(rs1.next()) 
			{		 
				count = rs1.getInt(1);
			}

			if(pstmt != null) pstmt.close();
			if(rs1  != null) rs1.close();
			
    
       out.println("<tr style='background-color:'><td class='"+rowclass+"'>");
	   int columnCount = 0;
	   if(Include_Arrive_startCons_yn.equals("Y")) 
			columnCount = 6;
		else
			columnCount = 5;
%>
<!--     <a name="<%=aname%>" onClick="changeRowColor(this,<%=columnCount%>);"  href="javascript:closew('<%=encounter_id%>','<%=queue_date%>','<%=patient_id%>','<%=queueStatus%>','<%=facilityId%>','<%=practDesc%>','<%=count%>');"> Thursday, June 17, 2010 Venkat s -->

 	<a name="<%=aname%>" onClick="changeRowColor(this,<%=columnCount%>);"  href='javascript:closew("<%=encounter_id%>","<%=queue_date%>","<%=patient_id%>","<%=queueStatus%>","<%=facilityId%>","<%=java.net.URLEncoder.encode(practDesc)%>","<%=count%>");'>
<%

	    out.println(encounter_id+"</a>");
		out.println("</td><td class='"+rowclass+"'>" );
        out.println(DateUtils.convertDate(visit_adm_dtime,"DMYHM","en",locale)+"</td><td class='"+rowclass+"'>" );
        out.println(patient_name+"</td><td class='"+rowclass+"'>" );       
		out.println(locationDesc+"</td><td class='"+rowclass+"'>" );

		/* Modified for CRF - PMG20089-CRF-0541 (IN08081)
			Modified by Suresh M Date : 11/12/2009
			New column Treatment Area is introduced in Cancel Attendence Function.
		*/
		if(Include_Arrive_startCons_yn.equals("Y")) {
			if(!treatment_area_desc.equals("")) {
				 out.println(treatment_area_desc+"</td><td class='"+rowclass+"'>" );
			} else {
				out.println("&nbsp;</td><td class='"+rowclass+"'>" );
			}
		}
        out.println(queue_status_desc+"</td></tr>" );
        aname++;
        i++;     
 		cnt++;
 }//endwhile
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
 if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%}
	
    if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
    if((strsql3 != null) && (strsql3.length() > 0))
	{
		strsql3.delete(0,strsql3.length());
	}

    }catch(Exception e)
    {
		e.printStackTrace();
    }
}catch(Exception e)
   {
		e.printStackTrace();
   }
   
   finally
   {
	   out.println("<script> parent.frames[1].document.forms[0].Search.disabled = false;</script>");
       if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }

%>
</tr>
</table>
</tr>
</table>
<input type='hidden' name='function_name' id='function_name' value="<%=function_name%>" >
<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
<input type='hidden' name='where_criteria' id='where_criteria' value="<%=where_criteria.toString()%>">
<input type='hidden' name='from' id='from' value="<%=start%>" >
<input type='hidden' name='to' id='to' value="<%=end%>" >
<input type='hidden' name='pmode' id='pmode' value='<%=p_mode%>'>
<input type='hidden' name='max_days_allow_update' id='max_days_allow_update' value='<%=max_days%>'>
<input type='hidden' name='max_days' id='max_days' value='<%=max_days%>'>
<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
<input type='hidden' name='Include_Arrive_startCons_yn' id='Include_Arrive_startCons_yn' value='<%=Include_Arrive_startCons_yn%>'>
<input type='hidden' name='five_level_triage_appl_yn' id='five_level_triage_appl_yn' value='<%=five_level_triage_appl_yn%>'>
</form>
</BODY>
</HTML>

