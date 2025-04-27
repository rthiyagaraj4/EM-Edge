<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*,java.util.*, webbeans.eCommon.* , java.text.* , java.sql.Date,eCommon.XSSRequestWrapper" %>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<html>
<Script>
	function getNext(flagSelect)
	{
	   var patientid		= document.forms[0].patientid.value ;
	   var from				= document.forms[0].from.value ;
	   var to				= document.forms[0].to.value ;	   
	   var flag				= flagSelect ;
	   var previousRecord	= document.forms[0].previousRecord.value;
	   var nextRecord		= document.forms[0].nextRecord.value ;
       var facility			= document.forms[0].facility.value ;
	   var encounType		= document.forms[0].encounType.value ;
	   var encounterID		= document.forms[0].encounterID.value;	   
	   var order_by			= document.forms[0].order_by.value;
	   
	   document.location.href='../../eMR/jsp/vwEncounterDetailResult.jsp?from=' + from + '&to=' + to + '&facility=' + facility + '&patientid=' +  patientid +'&flag=' + flag + '&nextRecord=' + nextRecord+'&previousRecord=' + previousRecord +
	   '&facility=' +  facility + '&encounType=' + encounType +'&encounterID=' +encounterID+'&order_by=' + order_by ;
	}


	async function viewReferral(ref)
			{
				var retVal = 	new String();
				var dialogHeight= "34vh" ;
				var dialogTop = "57vw" ;
				var dialogWidth	= "50" ;
				var status = "no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var retVal = await window.showModalDialog("../../eOP/jsp/ViewPatReferral.jsp?referral_id="+ref,arguments,features);
			}
	


async function view_appt_dtl(ref_no){
    
    var retVal =    new String();
    var dialogHeight= "30vh" ;
    var dialogWidth = "50vw" ;
    var dialogTop = "100" ;
    var center = "1" ;
    var status="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments   = "" ;
    retVal = await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+ref_no+"&flag=Visit_Reg",arguments,features);
    }




 </Script>

<head>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>

		async function GetShowRemarks(name,remarksvalue,remarkstype)
		{
			var comments;
			var inputArr = document.getElementsByTagName("input");
			for (u=0;u<inputArr.length;u++)
			{
				if (inputArr[u].name == name)
				{
					comments = inputArr[u].value;
				}
			}

			var retVal;
			var dialogHeight ='9vh' ;
			var dialogWidth = '30vw' ;
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
			var arguments;

			   if(comments=='' || comments == "null")
				  comments ='';
				arguments = comments ;

			retVal =await  window.showModalDialog('../../eFM/jsp/GetShowRemarks.jsp?title=Return Remarks&RemarksValue='+escape(remarksvalue)+'&RemarksType='+remarkstype,arguments,features);

				for (u=0;u<inputArr.length;u++){
					if (inputArr[u].name == name){
						inputArr[u].value = ''+retVal+'';
					}
				}
		}

		async function Openrecordwin(functionid,episodeid,visitid,locncode,locntype,bednum,roomnum,dischgedate,visitadmdate,episodestatus,patientclass,seclevel,protectionind,ip_practitioner_id)
		{
			
			var patientid=document.getElementById("patientid").value;				
			var episodetype="";		
			var gender=document.getElementById("patient_sex").value;			
			var age=document.getElementById("patient_age").value;			
			var dob=document.getElementById("dob").value;			
			if(patientclass == "IP")
			{
					episodetype = "I";

			}
			else if(patientclass == "OP" )
			{
				episodetype="O";
			}
			else
			{
				episodetype="O";
			}
			
			var relnreqyn="";
			var pq="";
			var ca="";
			var mode="";



			
			var dialogHeight ='26vh' ;
			var dialogWidth = '45vw' ;
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
			var arguments;
			
			
			if(functionid == "RECORD_PROCEDURE")
			{
				retVal =await window.showModalDialog('../../eCA/jsp/PatProcRecord.jsp?option_id='+functionid+'&patient_id='+patientid+'&visit_id='+visitid+'&episode_id='+episodeid+'&location_code='+locncode+'&location_type='+locntype+'&bed_num='+bednum+'&room_num='+roomnum+'&episode_type='+episodetype+'&discharge_date='+dischgedate+'&visit_adm_date='+visitadmdate+'&episode_Status='+episodestatus+'&Sex='+gender+'&ip_practitioner_id='+ip_practitioner_id+'&Age='+age+'&Dob='+dob+'&security_level='+seclevel+'&protection_ind='+protectionind+'&reln_req_yn=Y&IP_YN=Y&modal_yn=Y&patient_class='+patientclass+'&PQ=Y&CA=N&mode=R',arguments,features);
			}
			else if (functionid == "DIAGNOSES")
			{
				retVal = await window.showModalDialog('../../eCA/jsp/PatProblemMain.jsp?option_id='+functionid+'&patient_id='+patientid+'&visit_id='+visitid+'&episode_id='+episodeid+'&location_code'+locncode+'&location_type='+locntype+'&bed_num='+bednum+'&room_num='+roomnum+'&episode_type='+episodetype+'&discharge_date='+dischgedate+'&visit_adm_date='+visitadmdate+'&episode_Status='+episodestatus+'&Sex='+gender+'&ip_practitioner_id='+ip_practitioner_id+'&Age='+age+'&Dob='+dob+'&security_level='+seclevel+'&protection_ind='+protectionind+'&reln_req_yn=Y&IP_YN=Y&patient_class='+patientclass+'&PQ=Y&CA=N&mode=R',arguments,features);
			}
		}
	</script>
 <head>

 <BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()'>
 <form name="EncounterResultForm" id="EncounterResultForm" action="../../eMR/jsp/vwEncounterDetailResult.jsp" method="post" 	>

 <%
		String locale			= (String)session.getAttribute("LOCALE");
		Connection con = ConnectionManager.getConnection(request);
		
		ResultSet rset	= null ;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
	//	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy") ;

	//	String queryCriteria	= (request.getParameter("criteria")==null)?"":request.getParameter("criteria") ;
		String flag				=
		(request.getParameter("flag")==null)?"":request.getParameter("flag");
		String facility			= (request.getParameter("facility")==null)?"":request.getParameter("facility") ;		
		String from				= request.getParameter("from") ;
		String to				= request.getParameter("to");
		String fromdate=(request.getParameter("fromdate")==null)?"":request.getParameter("fromdate");
		String todate=(request.getParameter("todate")==null)?"":request.getParameter("todate");
		String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;		
		String encounType		= (request.getParameter("encounType")==null)?"":request.getParameter("encounType") ;
		String encounterID		= (request.getParameter("encounterID")==null)?"":request.getParameter("encounterID") ;
		String order_by		= (request.getParameter("order_by")==null)?"":request.getParameter("order_by") ;	

		String function_id= (request.getParameter("function_id")==null)?"":request.getParameter("function_id") ;	
		//String whereClause =(request.getParameter("whereclause")==null)?"":request.getParameter("whereclause") ;
			
		int noOfRecords			= 0  ;
		int start = 0 ;
		int end = 0 ;
		//String sqlCriteria		= "" ;
		String sql				= "" ;
		String classValue		="";//p_req_remarks="",p_iss_remarks="";
		String episodeid="";
		String assgncarelocncode="";
		String assgncarelocntype="";
		String bednum="";
		String roomnum="";
		//String episodetype="";
		String episodestatus="";
		String patientclass="";
		String dischargedate="";
		String visitadndatetime="";
		String gender="";
		String age="";
		String dob="";
		String valstr="";
		String seclevel="";
		String protectionind="";
		String visitid=""; 
		String ip_practitioner_id="";

		  if ( from == null )
	  {
        start = 1 ;
	  }
    else
	  {		
        start = Integer.parseInt( from ) ;
	  }

    if ( to == null )
	  {
        end = 12 ;
	  }
    else
	  {		
        end = Integer.parseInt( to ) ;
	  }
/*
	  if(fromdate != null)
			fromdate="'"+fromdate+"'";

	if(todate != null)
			todate="'"+todate+"'";
*/
	  try{		  

	  

sql="select count(*) as total FROM PR_ENCOUNTER A	,AM_CARE_LOCN_TYPE B ,OP_CLINIC C,IP_NURSING_UNIT D	,AM_PRACTITIONER E	,AM_PATIENT_CLASS F	,IP_DISCHARGE_TYPE G,AM_DISPOSITION_TYPE H  ,op_episode_for_service i WHERE A.FACILITY_ID= '" +facility + "' AND A.ENCOUNTER_ID = nvl('"+encounterID+"',A.ENCOUNTER_ID) AND A.PATIENT_ID= '" +patientid + "' AND A.ASSIGN_CARE_LOCN_TYPE	= B.LOCN_TYPE AND A.FACILITY_ID	= C.FACILITY_ID (+) AND A.ASSIGN_CARE_LOCN_CODE  = C.CLINIC_CODE (+) AND A.FACILITY_ID	= C.FACILITY_ID (+) AND A.ASSIGN_CARE_LOCN_CODE  = D.NURSING_UNIT_CODE (+) AND A.ATTEND_PRACTITIONER_ID = E.PRACTITIONER_ID (+) AND A.PATIENT_CLASS  = F.PATIENT_CLASS AND A.DISPOSITION_TYPE = G.DISCHARGE_TYPE_CODE (+) AND A.DISPOSITION_TYPE = H.DISP_TYPE (+) AND TRUNC( A.VISIT_ADM_DATE_TIME) BETWEEN    " +
"NVL( TO_DATE('"+  fromdate + "', 'dd/MM/yyyy'),TO_DATE('01/01/1900','dd/MM/yyyy')) AND " +
"NVL( TO_DATE('"+  todate + "', 'dd/MM/yyyy'),TO_DATE('31/12/5000','dd/MM/yyyy')) AND A.PATIENT_CLASS=decode('"+encounType + "','',A.PATIENT_CLASS,'"+encounType + "') and a.patient_id=i.patient_id and a.episode_id=i.episode_id and a.visit_status < '08' ";

pstmt=con.prepareStatement(sql);
rset=pstmt.executeQuery();
if(rset != null)
{
	if(rset.next())
	{
		noOfRecords=rset.getInt("total");
	}
}
 if(pstmt != null) pstmt.close();
	  if(rset != null) rset.close();
	 	

 sql="SELECT A.ENCOUNTER_ID ,to_char(A.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE_TIME, A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE,A.ASSIGN_CARE_LOCN_TYPE ASSIGN_CARE_LOCN_TYPE ,B.SHORT_DESC ASSIGN_CARE_LOCN_TYPE_DESC, A.ASSIGN_CARE_LOCN_CODE ASSIGN_CARE_LOCN_CODE ,DECODE(A.ASSIGN_CARE_LOCN_TYPE, 'C', C.SHORT_DESC, 'N', D.SHORT_DESC) ASSIGN_CARE_LOCN_DESC ,A.ASSIGN_ROOM_NUM, A.ASSIGN_BED_NUM,  A.ATTEND_PRACTITIONER_ID ,E.PRACTITIONER_NAME ,A.APPT_ID ,A.PATIENT_CLASS patient_class ,F.SHORT_DESC PATIENT_CLASS_DESC ,A.DISPOSITION_TYPE ,DECODE(A.PATIENT_CLASS, 'IP', G.SHORT_DESC, H.SHORT_DESC) DISPOSITION_TYPE_DESC ,to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME ,A.DISP_REFERRAL_ID,a.episode_id episode_id, i.episode_status episode_status,a.security_level security_level,a.protection_ind protection_ind,a.op_episode_visit_num op_episode_visit_num FROM PR_ENCOUNTER A	,AM_CARE_LOCN_TYPE B ,OP_CLINIC C,IP_NURSING_UNIT D	,AM_PRACTITIONER E	,AM_PATIENT_CLASS F	,IP_DISCHARGE_TYPE G,AM_DISPOSITION_TYPE H  ,op_episode_for_service i WHERE A.FACILITY_ID= '" +facility + "' AND A.ENCOUNTER_ID = nvl('"+encounterID+"',A.ENCOUNTER_ID) AND A.PATIENT_ID= '" +patientid + "' AND A.ASSIGN_CARE_LOCN_TYPE	= B.LOCN_TYPE AND A.FACILITY_ID	= C.FACILITY_ID (+) AND A.ASSIGN_CARE_LOCN_CODE  = C.CLINIC_CODE (+) AND A.FACILITY_ID	= C.FACILITY_ID (+) AND A.ASSIGN_CARE_LOCN_CODE  = D.NURSING_UNIT_CODE (+) AND A.ATTEND_PRACTITIONER_ID = E.PRACTITIONER_ID (+) AND A.PATIENT_CLASS  = F.PATIENT_CLASS AND A.DISPOSITION_TYPE = G.DISCHARGE_TYPE_CODE (+) AND A.DISPOSITION_TYPE = H.DISP_TYPE (+) AND TRUNC( A.VISIT_ADM_DATE_TIME) BETWEEN    " +
"NVL( TO_DATE('"+  fromdate + "', 'dd/MM/yyyy'),TO_DATE('01/01/1900','dd/MM/yyyy')) AND " +
"NVL( TO_DATE('"+  todate + "', 'dd/MM/yyyy'),TO_DATE('31/12/5000','dd/MM/yyyy')) AND A.PATIENT_CLASS=decode('"+encounType + "','',A.PATIENT_CLASS,'"+encounType + "') and a.patient_id=i.patient_id and a.episode_id=i.episode_id and a.visit_status < '08' ORDER BY " +order_by + " DESC, ENCOUNTER_DATE DESC";

pstmt= con.prepareStatement(sql);

rset = pstmt.executeQuery() ;

	  if (noOfRecords== 0)
	  {
	  %>
	  	<script>
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		//  parent.frames[1].document.forms[0].search[1].disabled=false;

		parent.frames[2]. location.href ="../../eCommon/html/blank.html" ;
		</script>
	 <%
	  }
 	  else
	  {
	%>

 

			<table align='right'>
			<tr>
				<td>
			 <%
				if ( !(start <= 1) )
		  {
	//out.println("<A HREF='../../eOP/jsp/ConcludeEpisodeResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	out.println("<A href='../../eMR/jsp/recDiagProcEncDtlsResult.jsp?from="+(start-12)+"&to="+(end-12)+"&fromdate=" + fromdate + "&todate=" + todate+"&patientid=" +  patientid +"&flag=next&encounType=" + encounType +"&facility=" + facility + "&order_by=" + order_by +"&encounterID=" + encounterID + "&function_id="+function_id+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	
		  }

if ( !( (start+14) > noOfRecords ) )
		  {
	//out.println("<A HREF='../../eOP/jsp/ConcludeEpisodeResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	out.println("<A href='../../eMR/jsp/recDiagProcEncDtlsResult.jsp?from="+(start+12)+"&to="+(end+12)+"&fromdate=" + fromdate + "&todate=" + todate+"&patientid=" +  patientid +"&flag=next&encounType=" + encounType +"&facility=" + facility + "&order_by=" + order_by +"&encounterID=" + encounterID + "&function_id="+function_id+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		  }
	%>
			

			</td>


		</tr>

	</table>
		<br><br>



		<table border="0" cellpadding="0" cellspacing="0" align='center' width="100%">

	<tr>
		<td >
	<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
    <jsp:param name="Patient_ID" value="<%=patientid%>"/>
	</jsp:include>
		</td>
	</tr>
	<!-- <tr><td  class='BODYCOLORFILLED' colspan='3'>&nbsp;</td></tr> -->
		
 		</table>

		<table border="1" cellpadding="0" cellspacing="0" align='center' width="100%">
	
	<tr >
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/> </th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>		
		</tr>		

		<%
		int i = 1;
		if(rset != null)
		  {
			 if ( start != 1 )
				{
					 for( int k=1; k<start; i++,k++ )
					 {
					  rset.next() ;
					 }
				}

		while(rset.next() && i <= end) 
		{
			
		//counter++ ;
		if ( i % 2 == 0 )
		  	classValue = "QRYODD" ;
		else
		  	classValue = "QRYEVEN" ;
		%>
		
			<tr></tr>
		<tr>
			<%
			visitadndatetime=(rset.getString("VISIT_ADM_DATE_TIME"));
		episodeid=rset.getString("episode_id");	
		visitid=rset.getString("op_episode_visit_num");
		assgncarelocncode=rset.getString("ASSIGN_CARE_LOCN_CODE");
			assgncarelocntype=rset.getString("ASSIGN_CARE_LOCN_TYPE");
			dischargedate=rset.getString("DISCHARGE_DATE_TIME");
			episodestatus=rset.getString("episode_status");
			patientclass=rset.getString("patient_class");	
			seclevel=rset.getString("security_level");
			protectionind=rset.getString("protection_ind");
			roomnum=rset.getString("ASSIGN_ROOM_NUM");
			bednum=rset.getString("ASSIGN_BED_NUM");
			
			ip_practitioner_id=rset.getString("ATTEND_PRACTITIONER_ID");
			if(ip_practitioner_id==null) ip_practitioner_id="";

			%>
			<td  height="20"  class='<%=classValue%>'><font size=1><%=(visitadndatetime==null)?"&nbsp;"
			:visitadndatetime%></td>

			<td  height="20" class='<%=classValue%>' ><font size=1> <%=(rset.getString("PATIENT_CLASS_DESC")==null)?"&nbsp;":rset.getString("PATIENT_CLASS_DESC")%></td>

			<td  height="20" class="<%=classValue%>"><font size=1>
		 	<a href="javascript:Openrecordwin('<%=function_id%>','<%=episodeid%>','<%=visitid%>','<%=assgncarelocncode%>','<%=assgncarelocntype%>','<%=bednum%>','<%=roomnum%>','<%=dischargedate%>',	'<%=visitadndatetime%>','<%=episodestatus%>','<%=patientclass%>','<%=seclevel%>','<%=protectionind%>','<%=ip_practitioner_id%>')" ><%=(rset.getString("ENCOUNTER_ID")==null)?"&nbsp;":rset.getString("ENCOUNTER_ID")%></a>		
			</td>

			<td  height="20" class="<%=classValue%>"><font size=1>

			<%=(rset.getString("ASSIGN_CARE_LOCN_TYPE_DESC")==null)?"&nbsp;":rset.getString("ASSIGN_CARE_LOCN_TYPE_DESC")%>
			</td>

			<td  height="20" class="<%=classValue%>" nowrap><font size=1>
			<%=(rset.getString("ASSIGN_CARE_LOCN_DESC")==null)?"&nbsp;":rset.getString("ASSIGN_CARE_LOCN_DESC")%>
			</td>
				<%
				
				%>

			<td  height="20" class="<%=classValue%>" nowrap><font size=1>
			<%=(roomnum==null)?"&nbsp;":roomnum%>
			</td>
<%
				

				%>
			<td  height="20" class="<%=classValue%>" nowrap><font size=1>
			<%=(bednum==null)?"&nbsp;":bednum%>
			</td>

			<td  height="20" class="<%=classValue%>" nowrap><font size=1>
			<%=(rset.getString("PRACTITIONER_NAME")==null)?"&nbsp;":rset.getString("PRACTITIONER_NAME")
				%>
					
			</td>			
			</tr>
       <%		

			pstmt1=con.prepareStatement("select get_patient.get_line_detail(?,?) Pline FROM dual");
			pstmt1.setString(1,patientid);
			pstmt1.setString(2,locale);
			rs=pstmt1.executeQuery();
			rs.next();
			valstr=rs.getString(1);
			StringTokenizer strval=new StringTokenizer(valstr,"|");
			String nval=strval.nextToken();
			String ival="";
			ival=strval.nextToken();
			String noval="";
			String Patientname="";
			

			if(nval != null || !nval.equals(""))
			{
				strval=new StringTokenizer(nval,",");
				if(strval.countTokens() == 4)
				{
				noval=strval.nextToken();
				}
					Patientname=strval.nextToken();
				age=strval.nextToken();
				gender=strval.nextToken();

			}

			if(pstmt1 != null) pstmt1.close();
			if(rs != null) rs.close();

			pstmt1=con.prepareStatement("select to_char(date_of_birth,'dd/mm/yyyy') from mp_patient where patient_id='"+patientid+"'");
			rs=pstmt1.executeQuery();
			rs.next();
			dob=rs.getString(1);

			if(pstmt1 != null) pstmt1.close();
			if(rs != null) rs.close();			
 
  	i++;
  }
	  }
	  }
	  if ( pstmt != null )  pstmt.close();
	%>
	</table>


 <%}catch(Exception e)
	{
		//out.println("Exception while fetching connection :" + e) ;
		e.printStackTrace();
	}finally{%>
	 <%
	if(rset!=null) rset.close();
	
	ConnectionManager.returnConnection(con, request);%>
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
  <input type='hidden' name='episode_id' id='episode_id' value='<%=episodeid%>'>
<input type='hidden' name='assgn_care_locn_code' id='assgn_care_locn_code' value='<%=assgncarelocncode%>' >
<input type='hidden' name='assgn_care_locn_type' id='assgn_care_locn_type' value='<%=assgncarelocntype%>' >
<input type='hidden' name='bed_num' id='bed_num' value='<%=bednum%>' >
<input type='hidden' name='room_num' id='room_num' value='<%=roomnum%>' >
<input type='hidden' name='patient_class' id='patient_class' value='<%=patientclass%>' >
<input type='hidden' name='discharge_date' id='discharge_date' value='<%=dischargedate%>' >
<input type='hidden' name='visit_adm_date_time' id='visit_adm_date_time' value='<%=visitadndatetime%>' >
<input type='hidden' name='episode_status' id='episode_status' value='<%=episodestatus%>' >
<input type='hidden' name='patient_age' id='patient_age' value='<%=age%>' >
<input type='hidden' name='patient_sex' id='patient_sex' value='<%=gender%>' >
<input type='hidden' name='dob' id='dob' value='<%=dob%>' >
<input type='hidden' name='sec_level' id='sec_level' value='<%=seclevel%>' >
<input type='hidden' name='protection_ind' id='protection_ind' value='<%=protectionind%>' >
<input type='hidden' name='visit_id' id='visit_id' value='<%=visitid%>' >

 </form>
 </body>
 </html>


