<!DOCTYPE html>
<%
/*  							 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date	Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           							created

26/11/2014	IN050580		Nijitha 								MO-CRF-20080
12/03/2014	IN052859 		Nijitha									MO-CRF-20080
---------------------------------------------------------------------------------------------------------------
*/
%> 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*,eCA.*,java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="beanObj"  scope="page"  class="eCA.CARefferralNotesBean"/>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String called_from = request.getParameter("called_from");
	String called_from_func = request.getParameter("called_from_func");
	String clinicianId = request.getParameter("practitioner");
	String login_user = (String)session.getValue("ca_practitioner_id");//IN052859
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script type="text/javascript" src="../../eCA/js/CANotesRefferalTracking.js"></script>
	<script type="text/javascript" src="../../eCA/js/RecClinicalNotesPart1.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<style>
div.scroll {
	overflow-y: scroll;
	overflow-x: hidden;
}
</style>
<%
String className = "class='columnHeadercenter'";
String tclassName = "class='grid'";
String tdclassName ="class='gridData'";
if("PRINT".equals(called_from)){
	className = "";
	tclassName = "";
	tdclassName ="style='font-family:Verdana;font-size:9pt'";
}
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='notesRefferedFromForm' id='notesRefferedFromForm' action="../../servlet/eCA.ReviewNotesServlet" method="post" target=messageFrame>
<table  <%=tclassName%> cellpadding=0 cellspacing=0 border='1' width="100%">
	<TR border='0' ID='divTitleTable'>
		<%
		if(!"PRINT".equals(called_from)){
		%>
			<TH <%=className%> style='cursor:pointer;' align='left' onClick='expandCollapseYN("<%=called_from%>")'><IMG SRC='../../eCommon/images/expand-all.gif'/></TH>
			<%
			if("REFERREDTO".equals(called_from))
			{%>
				<TH <%=className%> colspan=5 align='center'><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></TH> 
			<%}else{%>
				<TH <%=className%> colspan=5 align='center'><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></TH>
			<%
			}
		}else{
			if("REFERREDTO".equals(called_from_func))
			{%>
				<TH <%=className%> colspan=6 align='center'><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></TH> 
			<%}else{%>
				<TH <%=className%> colspan=6 align='center'><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></TH>
			<%
			}		
		}%>
	</tr>	
	<TR border='0' ID='divTitleTableCol' style="text-align:left;">
	   <TH <%=className%> width='130px'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></TH>
	   <TH <%=className%> width='150px'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></TH>
	   <TH <%=className%> width='90px'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></TH>
	   <TH <%=className%> width='200px'><fmt:message key="eCA.referredLocationDtls.label" bundle="${ca_labels}"/></TH>
	   <TH <%=className%> width='100px'><fmt:message key="Common.status.label" bundle="${common_labels}"/></TH>
	   <%
	   if("REFERREDFROM".equals(called_from))
	   {
			if(login_user.equals(clinicianId))
			{%>
				<TD <%=className%> width='100px'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></TD>
			<%}
	   }%>
	</tr>
<%
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String resp_id = (String)session.getValue("responsibility_id");	
	beanObj.setLocale(localeName);
	beanObj.setPatient_id(request.getParameter("patientId"));
	beanObj.setClinician_id(clinicianId);
	beanObj.setFacility_id(request.getParameter("facility"));
	beanObj.setSpeciality_code(request.getParameter("specialty_code"));
	beanObj.setPeriod_from(request.getParameter("fromDate"));
	beanObj.setPeriod_to(request.getParameter("toDate"));
	beanObj.setStatus(request.getParameter("status"));
	beanObj.setLocation_code(request.getParameter("locn_code"));
	beanObj.setResp_id(resp_id);
	beanObj.setForwardToFacility(request.getParameter("forward_to_facility"));
	beanObj.setReferralStatus(request.getParameter("referral_status"));
	beanObj.setPatientClass(request.getParameter("patientclass"));
	beanObj.setToSpecialityCode(request.getParameter("to_specialty_code"));

	String dispMode = "none";
	List referralData = null;
	if("REFERREDTO".equals(called_from) || ("PRINT".equals(called_from) && "REFERREDTO".equals(called_from_func))){
		referralData = beanObj.getRefferalNotesForPract("REFFEREDTO");
	}
	else
	{
		referralData = beanObj.getRefferalNotesForPract("REFFEREDFROM");
	}
	List referralKey = (ArrayList)referralData.get(0);
	HashMap<String, List<String>> referralNotesMap = (HashMap<String, List<String>>)referralData.get(1);
	
	List referralNotes = new ArrayList();
	List<String> referralNotesDate = new ArrayList<String>();;
	String request_date_time = null;
	String actionType =null;
	String facility_id =null;
	String action_by_type = null;
	String action_group_desc = null;
	int i =1;
	int j =0;
	int totalRec = 0;
	String event_status = "";
	String status="";
	String dtvalue = "";
	String value = "";
	String action_status = "";
	String enabledYN = "enabled";
	String encounter_id = "";
	String patdetailsFormat = "";
	String facility_name = "";
	String location_desc = "";
	String patdetails ="";
	String notetypedesc = "";
	String privilegetype = "";
	String	patient_id = "";
	String  request_by_id = "";
	String accession_num = "";
	int referralDate =0;
	String requested_by_name="";
	StringTokenizer patientDetails = null;
	String request_date_time_old = null;
	String keyVal = "";
	String actionTypeCode = "";
	try 
	{
		if(null!=referralKey && referralKey.size()>0)
		{
			for(int m=0;m<referralKey.size();m++)
			{
				keyVal =(String) referralKey.get(m);
				referralNotes =referralNotesMap.get(referralKey.get(m));
				j=0;
				 for (int noteCnt=0;noteCnt<referralNotes.size();noteCnt++) 
				 { 
					referralNotesDate = (ArrayList)referralNotes.get(noteCnt);
					
					for (int noteDateCnt=0;noteDateCnt<referralNotesDate.size();noteDateCnt+=18) 
					{
						totalRec++;
						patdetails = referralNotesDate.get(noteDateCnt)==null?"":referralNotesDate.get(noteDateCnt);
						notetypedesc =  referralNotesDate.get(noteDateCnt+1)==null?"":referralNotesDate.get(noteDateCnt+1);
						privilegetype	=referralNotesDate.get(noteDateCnt+2)==null?"": referralNotesDate.get(noteDateCnt+2);
						patient_id	=	referralNotesDate.get(noteDateCnt+3)==null?"": referralNotesDate.get(noteDateCnt+3).toString();
						requested_by_name	=	(String)referralNotesDate.get(noteDateCnt+4)==null?"":referralNotesDate.get(noteDateCnt+4);
						request_by_id	=	referralNotesDate.get(noteDateCnt+5)==null?"":(String) referralNotesDate.get(noteDateCnt+5);
						facility_name	=	referralNotesDate.get(noteDateCnt+6)==null?"": referralNotesDate.get(noteDateCnt+6);
						action_status	=	referralNotesDate.get(noteDateCnt+7)==null?"":referralNotesDate.get(noteDateCnt+7);
						encounter_id	=	referralNotesDate.get(noteDateCnt+8)==null?"":referralNotesDate.get(noteDateCnt+8);
						location_desc	=	referralNotesDate.get(noteDateCnt+9)==null?"": referralNotesDate.get(noteDateCnt+9);
						action_group_desc	=	referralNotesDate.get(noteDateCnt+10)==null?"":referralNotesDate.get(noteDateCnt+10);
						action_by_type	=referralNotesDate.get(noteDateCnt+11)==null?"":referralNotesDate.get(noteDateCnt+11);
						facility_id	=	referralNotesDate.get(noteDateCnt+12)==null?"": referralNotesDate.get(noteDateCnt+12);
						actionType	=	referralNotesDate.get(noteDateCnt+13)==null?"": referralNotesDate.get(noteDateCnt+13);
						request_date_time	=	referralNotesDate.get(noteDateCnt+14)==null?"": referralNotesDate.get(noteDateCnt+14);
						event_status	=	referralNotesDate.get(noteDateCnt+15)==null?"": referralNotesDate.get(noteDateCnt+15);
						accession_num	=referralNotesDate.get(noteDateCnt+16)==null?"": referralNotesDate.get(noteDateCnt+16);
						actionTypeCode = referralNotesDate.get(noteDateCnt+17)==null?"": referralNotesDate.get(noteDateCnt+17);
						
						if("CO".equals(action_status))
						{
							enabledYN = "disabled";
						}
						else
						{
							enabledYN = "enabled";
						}
						
						patdetails = patdetails.replace('|',',');
						patientDetails = new StringTokenizer(patdetails,",");
						for(int patDet = 0;patDet<=2;patDet++)
						{			
							patdetailsFormat = patientDetails.nextToken()+", "+patdetailsFormat;
						}
						patdetailsFormat+= "<br>"+patient_id+", "+"<BR>"+encounter_id;
						if(event_status.equals("1"))
							status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
						else if(event_status.equals("2"))
							status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
						else if(event_status.equals("3"))
							status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
						else if(event_status.equals("4"))
							status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
						else if(event_status.equals("5"))
							status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
						else if(event_status.equals("9"))
							status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
							
						if(event_status.equals("2") || event_status.equals("3")){
							value = null+"~"+accession_num+"~"+clinicianId+"~"+facility_id+"~"+notetypedesc+"~"+"Z";//IN052859
						}	
						else
							value = privilegetype+"~"+accession_num+"~"+clinicianId+"~"+facility_id+"~"+notetypedesc+"~"+request_by_id+"~"+action_by_type;//IN052859
						
						if(!keyVal.equals(request_date_time_old))
						{
							out.println("<tr style='cursor:pointer;' onClick =\"displayDetails('"+i+"','"+called_from+"')\" >");
						%>
						
						<td <%=tdclassName%> colspan='6' style='color:blue' id = 'tab<%=i%><%=j%>'><%=keyVal%><b>(</b><%=referralNotes.size()%><b>)</b></td></tr>
						<%
						request_date_time_old = keyVal;
						}
						if("PRINT".equals(called_from))
						 {
							dispMode = request.getParameter("reviewNotes"+called_from_func+i+"_"+j);
							if("".equals(dispMode))
								dispMode = "none";
						 }
						 out.println("<tr id='reviewNotes"+called_from+i+"_"+j+"' style='display:"+dispMode+"'>");
						 out.println("<td  "+tdclassName+" wrap  >"+request_date_time+"</td>");
						 out.println("<td  "+tdclassName+" wrap  >"+patdetailsFormat+"</td>");
						 out.println("<td  "+tdclassName+" wrap  ><a href=\"javascript:showNoteData('"+accession_num+"','','','"+encounter_id+"','','"+status+"','')\">"+notetypedesc+"</a></td>");
						 
						 out.println("<td  "+tdclassName+" >"+facility_name+"<BR>"+"/"+action_group_desc+"/"+"<BR>"+requested_by_name+"/ "+location_desc+"</td>");
						 out.println("<td  "+tdclassName+" ><a href =\"javascript:showNoteStatus('"+accession_num+"','NA')\" >"+status+"</td></a>");
						 if("REFERREDFROM".equals(called_from) )
						 {
							if(login_user.equals(clinicianId))
								out.println("<td width ='10%' "+tdclassName+" id='check"+i+"_"+j+"' ><input type='checkbox' id='chk_"+i+"_"+j+"'  style='display:none' value='"+value+"' onClick =\"callSendBackWindow(this,'"+i+"','"+j+"','"+actionType+"')\" "+enabledYN+" ></td>");
						 }
						  out.println("</tr>");
						  //out.println("</tr>");
						  out.println(" <input type='hidden' name='actionType"+i+"_"+j+"' id='actionType"+i+"_"+j+"' value="+actionTypeCode+">");
						}	
					  j++;
					  patdetailsFormat ="";
					}
				 out.println(" <input type='hidden' name='rowIndex"+i+"' id='rowIndex"+i+"' value="+referralNotes.size()+">");
				 i++;
				}
			}
			
		}
	catch(Exception e){
		e.printStackTrace();
	}

	if(totalRec==0){ 
		out.println("<tr><td "+tdclassName+" colspan='5'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
	}
%>
<input type="hidden" name="final_values" id="final_values" value="">
<input type="hidden" name="remarks" id="remarks" value="">
<input type="hidden" name="noofrec<%=called_from%>" id="noofrec<%=called_from%>" value="<%=totalRec%>">
<input type="hidden" name="expandYN" id="expandYN" value="EXPANDALL">
</table>
</form>
</body>
</html>

