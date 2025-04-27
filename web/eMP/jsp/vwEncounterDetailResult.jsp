<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%

String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eMP/js/VwEncounterDetails.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function scrollTitle()
{
	  var scrollXY = document.body.scrollTop;
	  if(scrollXY == 0)
	  {
					document.getElementById('divDataTitle').style.position = 'static';
					document.getElementById('divDataTitle').style.posTop  = 0;
	  }
	  else
	  {
				document.getElementById('divDataTitle').style.position = 'relative';
				document.getElementById('divDataTitle').style.posTop  = scrollXY;
	  }
}

</script>
</head>
<BODY onMouseDown="CodeArrest();" onscroll="scrollTitle();" onKeyDown ='lockKey()'>
<form name="EncounterResultForm" id="EncounterResultForm"  >

 <%
		Connection con = null;
		Statement newstmt	= null;
		ResultSet rset	= null ;
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String facility = (String) session.getAttribute( "facility_id" ) ;
		String billing = (String) session.getAttribute( "bl_operational" ) ;
		String order_by = "18";
		String visit_adm_date_time = "";
		String discharge_date_time = "";
	    String disp_cancelled_previous_enc_yn="Y";  
		String flag				=
		(request.getParameter("flag")==null)?"":request.getParameter("flag");
				String from				=
		(request.getParameter("from")==null)?"":request.getParameter("from") ;
		String to				=
		(request.getParameter("to")==null)?"":request.getParameter("to");
		String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;
		String encounType		= (request.getParameter("encounType")==null)?"":request.getParameter("encounType") ;
		String encounterID		= (request.getParameter("encounterID")==null)?"":request.getParameter("encounterID") ;
		String encounter_id = ""; 
		String sortby		= (request.getParameter("sortby")==null)?"ENCOUNTER_DATE DESC":request.getParameter("sortby") ;
         
		String ecount=(request.getParameter("ecount")==null)?"0":request.getParameter("ecount") ;
		
		int counter				= 0  ;
		int noOfRecords			= 0  ;
		
		String sql				= "" ;
		String classValue		="";
		String visitid = "";
		String episodetype = "";
		String episodeid = "";
		String patientclass = "";
try
	{
		con = ConnectionManager.getConnection(request);
	 	if(from != null)
			{
				from = "'" + from + "'" ;
			}
		if(to != null)
			{
				to   = "'" + to + "'" ;
			}
               
			  sql="SELECT disp_cancel_prev_enc_yn FROM MP_PARAM"; 
			  newstmt= con.createStatement();
		      rset = newstmt.executeQuery(sql) ;
			  
			  if(rset.next())
				disp_cancelled_previous_enc_yn=(rset.getString("disp_cancel_prev_enc_yn")==null)?"Y":rset.getString("disp_cancel_prev_enc_yn");
			  
			  if(rset != null) rset.close();
	          if(newstmt != null) newstmt.close();

			if(disp_cancelled_previous_enc_yn.equals("Y")){
       sql="SELECT A.ENCOUNTER_ID, A.PATIENT_ID, A.OP_EPISODE_VISIT_NUM visitid, A.EPISODE_ID eid, TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME, A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE, A.ASSIGN_CARE_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(A.ASSIGN_CARE_LOCN_TYPE,'"+locale+"','1') ASSIGN_CARE_LOCN_TYPE_DESC, A.ASSIGN_CARE_LOCN_CODE, DECODE (A.ASSIGN_CARE_LOCN_TYPE, 'N', (IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+locale+"','1')), (OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+locale+"','1'))) ASSIGN_CARE_LOCN_DESC, A.SERVICE_CODE, AM_GET_DESC.AM_SERVICE(A.service_code,'"+locale+"','2') SERVICE_SHORT_DESC, A.SUBSERVICE_CODE, AM_GET_DESC.AM_SUBSERVICE(A.service_code, A.subservice_code,'"+locale+"','2') SUBSERVICE_SHORT_DESC, A.ASSIGN_ROOM_NUM, A.ASSIGN_BED_NUM, A.ATTEND_PRACTITIONER_ID, AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME, A.APPT_ID, A.PATIENT_CLASS PAT, AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+locale+"','1') PATIENT_CLASS_DESC, A.DISPOSITION_TYPE, DECODE (A.PATIENT_CLASS,'IP', (IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+locale+"','2')),'DC',(IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+locale+"','2')) ,(AM_GET_DESC.AM_DISPOSITION_TYPE(A.DISPOSITION_TYPE,'"+locale+"','1'))) DISPOSITION_TYPE_DESC, TO_CHAR (A.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') DISCHARGE_DATE_TIME, A.DISP_REFERRAL_ID FROM  PR_ENCOUNTER A WHERE A.FACILITY_ID = '" +facility+ "' AND (a.encounter_id <> '"+encounterID+"' OR NVL('"+encounterID+"','X') = NVL('','X')) AND A.PATIENT_ID = '" +patientid+ "' AND TRUNC (A.VISIT_ADM_DATE_TIME) BETWEEN NVL (TO_DATE ("+from+ ", 'DD/MM/YYYY'), TO_DATE ('01/01/1900','DD/MM/YYYY')) AND NVL (TO_DATE ("+to+ ", 'DD/MM/YYYY'), TO_DATE ('31/12/5000','DD/MM/YYYY')) AND A.PATIENT_CLASS = DECODE ('"+encounType + "', '', A.PATIENT_CLASS, '"+encounType+ "') ORDER BY "+ sortby;
		 
		 }else{
		 /*Below query added by venkatesh against GDOH-CRF-0091 [IN059621] on 22/06/2016 */
		sql="SELECT A.ENCOUNTER_ID, A.PATIENT_ID, A.OP_EPISODE_VISIT_NUM visitid, A.EPISODE_ID eid, TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME, A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE, A.ASSIGN_CARE_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(A.ASSIGN_CARE_LOCN_TYPE,'"+locale+"','1') ASSIGN_CARE_LOCN_TYPE_DESC, A.ASSIGN_CARE_LOCN_CODE, DECODE (A.ASSIGN_CARE_LOCN_TYPE, 'N', (IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+locale+"','1')), (OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+locale+"','1'))) ASSIGN_CARE_LOCN_DESC, A.SERVICE_CODE, AM_GET_DESC.AM_SERVICE(A.service_code,'"+locale+"','2') SERVICE_SHORT_DESC, A.SUBSERVICE_CODE, AM_GET_DESC.AM_SUBSERVICE(A.service_code, A.subservice_code,'"+locale+"','2') SUBSERVICE_SHORT_DESC, A.ASSIGN_ROOM_NUM, A.ASSIGN_BED_NUM, A.ATTEND_PRACTITIONER_ID, AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME, A.APPT_ID, A.PATIENT_CLASS PAT, AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+locale+"','1') PATIENT_CLASS_DESC, A.DISPOSITION_TYPE, DECODE (A.PATIENT_CLASS,'IP', (IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+locale+"','2')),'DC',(IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+locale+"','2')) ,(AM_GET_DESC.AM_DISPOSITION_TYPE(A.DISPOSITION_TYPE,'"+locale+"','1'))) DISPOSITION_TYPE_DESC, TO_CHAR (A.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') DISCHARGE_DATE_TIME, A.DISP_REFERRAL_ID FROM  PR_ENCOUNTER A WHERE A.FACILITY_ID = '" +facility+ "' AND (a.encounter_id <> '"+encounterID+"' OR NVL('"+encounterID+"','X') = NVL('','X')) AND A.PATIENT_ID = '" +patientid+ "' AND ((A.VISIT_STATUS !='99' AND  A.ADT_STATUS IS NULL) OR  A.ADT_STATUS!='09' AND A.VISIT_STATUS IS NULL) AND TRUNC (A.VISIT_ADM_DATE_TIME) BETWEEN NVL (TO_DATE ("+from+ ", 'DD/MM/YYYY'), TO_DATE ('01/01/1900','DD/MM/YYYY')) AND NVL (TO_DATE ("+to+ ", 'DD/MM/YYYY'), TO_DATE ('31/12/5000','DD/MM/YYYY')) AND A.PATIENT_CLASS = DECODE ('"+encounType + "', '', A.PATIENT_CLASS, '"+encounType+ "') ORDER BY "+ sortby;
}



		 newstmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 rset = newstmt.executeQuery(sql) ;
		while(rset.next())
			noOfRecords = noOfRecords + 1;

 %>
		<%rset.beforeFirst(); 

	  if (noOfRecords== 0)
	  {
	  %>
	  	<script>
		alert( getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		window.close();
		//parent.frames[2]. location.href ="../../eCommon/html/blank.html" ;
		</script>
	 <%
	  }
 	  else
	  {
	%>
		<div id='divDataTitle' style='postion:relative'>
		<table border="1"   align="center" >

		<tr>
		<td  width='160px' nowrap class="COLUMNHEADER"><a href="javascript:sortData('<%=encounterID%>','<%=encounType%>' ,'<%=patientid%>','ENCOUNTER_DATE' ,'<%=ecount%>' )" ><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></a></td>
		<td  width='120px' nowrap class="COLUMNHEADER"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
		<td  width='110px' nowrap class="COLUMNHEADER"><a href="javascript:sortData('<%=encounterID%>','<%=encounType%>' ,'<%=patientid%>','a.encounter_id' ,'<%=ecount%>' )"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></a></td>
    	<td  width='110px' nowrap class="COLUMNHEADER"><a href="javascript:sortData('<%=encounterID%>','<%=encounType%>' ,'<%=patientid%>','A.ASSIGN_CARE_LOCN_TYPE' ,'<%=ecount%>' )"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td  width='110px' nowrap class="COLUMNHEADER"><a href="javascript:sortData('<%=encounterID%>','<%=encounType%>' ,'<%=patientid%>','ASSIGN_CARE_LOCN_DESC' ,'<%=ecount%>' )" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td  width='110px' nowrap class="COLUMNHEADER"><a href="javascript:sortData('<%=encounterID%>','<%=encounType%>' ,'<%=patientid%>','SERVICE_SHORT_DESC' ,'<%=ecount%>' )" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td  width='110px' nowrap class="COLUMNHEADER"><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
		<td  width='75px' nowrap class="COLUMNHEADER"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
		<td  width='90px' nowrap class="COLUMNHEADER"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
		<td  width='210px' nowrap class="COLUMNHEADER"><a href="javascript:sortData('<%=encounterID%>','<%=encounType%>' ,'<%=patientid%>','PRACTITIONER_NAME' ,'<%=ecount%>' )" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td  width='170px' nowrap class="COLUMNHEADER"><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
		<td  width='130px' nowrap class="COLUMNHEADER"><fmt:message key="Common.DispType.label" bundle="${common_labels}"/></td>
		<%if(billing.equals("Y")) {%>
		<td width='150px' nowrap class="COLUMNHEADER"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></td>
		<td width='150px' nowrap class="COLUMNHEADER"><fmt:message key="Common.BillingDetails.label" bundle="${common_labels}"/></td>
			<%}%>
		</tr>		
	</table>
		</div>
<table border=1   align="center" >
	<%	 if(rset.next())
	  {	%>
	<%rset.beforeFirst();}%>
		<%
		int i = 1;
		while(rset.next()) 
		{
		  visitid = rset.getString("visitid");
			if(visitid==null)
				visitid="";

		  episodeid = rset.getString("eid");
		  if(episodeid==null)
				episodeid="";
		  patientclass = rset.getString("pat");
		  if(patientclass==null)
				patientclass="";
		  if(patientclass.equals("IP"))
			{
				episodetype = "I";
			}
		  if(patientclass.equals("OP"))
			{
				episodetype = "O";
			}
		  if(patientclass.equals("EM"))
			{
				episodetype = "E";
			}
		  if(patientclass.equals("DC"))
			{
				episodetype = "D";
			}
		counter++ ;
		if ( counter % 2 == 0 )
		  	classValue = "QRYODD" ;
		else
		  	classValue = "QRYEVEN" ;

		visit_adm_date_time=rset.getString("VISIT_ADM_DATE_TIME");
		if(visit_adm_date_time != null)
		{
			visit_adm_date_time= DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",localeName);
		}
		else
			visit_adm_date_time="";
		%>
		<tr>
			<td  width='160px'  align='left' nowrap class='<%=classValue%>'><font size='1'><%=visit_adm_date_time%></td>

			<td  width='120px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("PATIENT_CLASS_DESC")==null)?"&nbsp;":rset.getString("PATIENT_CLASS_DESC")%></td>

			<% encounter_id = rset.getString("ENCOUNTER_ID")==null?"":rset.getString("ENCOUNTER_ID");%>		
			<td   width='110px'nowrap align='right' class="<%=classValue%>"><font size=1><a href='javascript:onclick=view_discharge("<%=encounter_id%>","<%=patientid%>","<%=patientclass%>")'><%=encounter_id%></a></td>
			<td  width='110px' nowrap align='left' class="<%=classValue%>"><font size=1>
			<%=(rset.getString("ASSIGN_CARE_LOCN_TYPE_DESC")==null)?"&nbsp;":rset.getString("ASSIGN_CARE_LOCN_TYPE_DESC")%>
			</td>

			<td  width='110px' align='left' nowrap class="<%=classValue%>" nowrap><font size=1>
			<%=(rset.getString("ASSIGN_CARE_LOCN_DESC")==null)?"&nbsp;":rset.getString("ASSIGN_CARE_LOCN_DESC")%>
			</td>

			<td  width='110px' align='left' nowrap class="<%=classValue%>"><font size=1>
		 	<%=(rset.getString("SERVICE_SHORT_DESC")==null)?"&nbsp;":rset.getString("SERVICE_SHORT_DESC")%>		
			</td>
			<td  align='left' width='110px' nowrap class="<%=classValue%>"><font size=1>
		 	<%=(rset.getString("SUBSERVICE_SHORT_DESC")==null)?"&nbsp;":rset.getString("SUBSERVICE_SHORT_DESC")%>		
			</td>


			<td   width='75px' align='left' nowrap class="<%=classValue%>" nowrap><font size=1>
			<%=(rset.getString("ASSIGN_ROOM_NUM")==null)?"&nbsp;":rset.getString("ASSIGN_ROOM_NUM")%>
			</td>

			<td width='90px' align='left'  nowrap class="<%=classValue%>" nowrap><font size=1>
			<%=(rset.getString("ASSIGN_BED_NUM")==null)?"&nbsp;":rset.getString("ASSIGN_BED_NUM")%>
			</td>

			<td width='210px'align='left'  nowrap class="<%=classValue%>" nowrap><font size=1>
			<%=(rset.getString("PRACTITIONER_NAME")==null)?"&nbsp;":rset.getString("PRACTITIONER_NAME")%>
			</td>
			<%
				discharge_date_time=rset.getString("DISCHARGE_DATE_TIME");
			if(discharge_date_time != null)
			{
				discharge_date_time= DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
			}
			else
				discharge_date_time="";
			%>

			<td  width='170px' align='left' nowrap class="<%=classValue%>"><font size=1>
			<%=(discharge_date_time=="")?"&nbsp;":discharge_date_time%>			
			</td>
			<td  width='130px' align='left' nowrap class="<%=classValue%>"><font size=1>
			<%=(rset.getString("DISPOSITION_TYPE_DESC")==null)?"&nbsp;":rset.getString("DISPOSITION_TYPE_DESC")%>
			</td> 
			<%if(billing.equals("Y")){%>
			<td  width='150px' align='center' nowrap class="<%=classValue%>"><font size=1>
			<A HREF='javascript:callbilling("<%=visitid%>","<%=episodetype%>","<%=patientid%>","<%=facility%>","<%=episodeid%>")'><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></A>
			</td> 
			<td  width='150px' align='center' nowrap class="<%=classValue%>"><font size=1>
			<A HREF='javascript:funViewEncounterDet("<%=patientid%>","<%=episodetype%>","<%=episodeid%>","<%=visitid%>","<%=facility%>","<%=encounterID%>")'><fmt:message key="Common.BillingDetails.label" bundle="${common_labels}"/></A>
			</td> 
				<%}%>
			</tr>
  <%
  	i++;
  }
	  }
	%>
	</table> 
 <%}catch(Exception e){%>
		 <% out.println("Exception while fetching connection :" + e) ;%>
 <%}finally{
		try{
	if(rset!=null)
	rset.close();
	if(newstmt!=null)
	newstmt.close();
		}catch(Exception e){}
	 if( con != null) ConnectionManager.returnConnection(con, request);%>
 <%}%>
  <input type='hidden' name='flag' id='flag' value='<%=flag%>' > 
  <input type='hidden' name='noOfRecords' id='noOfRecords' value='<%=noOfRecords%>' >
  <input type='hidden' name='facility' id='facility' value='<%=facility%>' >
  <input type='hidden' name='from' id='from' value=<%=from%> >
  <input type='hidden' name='to' id='to' value=<%=to%> >
  <input type='hidden' name='patientid' id='patientid' value=<%=patientid%> >
  <input type='hidden' name='order_by' id='order_by' value='<%=order_by%>'>
  <input type='hidden' name='encounterID' id='encounterID' value='<%=encounterID%>'>
  <input type='hidden' name='encounType' id='encounType' value='<%=encounType%>'>  
 </form>
 </body>
 </html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : 

inputString);
	}
%>

