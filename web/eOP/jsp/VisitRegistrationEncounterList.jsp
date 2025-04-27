<!DOCTYPE html>
			  
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>

<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='stylesheet' type='text/css' href='../html/text.css'></link>
</head>
<BODY  OnMouseDown='CodeArrest();' onKeyDown ='lockKey();' class='CONTENT'>
<form name='encounter_list' id='encounter_list'>
<%
  String facility_id=(String)session.getValue("facility_id");
  String patient_id=request.getParameter("patient_id");
  String encounterid=request.getParameter("encounter_id");
  if(patient_id==null)patient_id="";
  Connection con=null;
  Statement stmt=null;
  Statement cstmt=null;
  ResultSet rset=null;
  ResultSet countrset=null;
  String classValue="";
  int query_even_odd=1;
  String encounter_id="";
  String patient_class="";
  String status="";
  String location="";
  String encounter_date="";
  String practitioner="";
  int count=0;
  %>
  <table border='0' cellpadding='0' cellspacing='0' width='100%'>
  <tr>
     <td align='left'>
		<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
		  <jsp:param name="Facility_Id" value="<%=facility_id%>" />
		  <jsp:param name="EncounterId" value="<%=encounterid%>" />
        </jsp:include>
	 </td>
  </tr>
  </table>
  
  <%
  try
  {
   con=ConnectionManager.getConnection(request);
  String esqlcount="select count(*) FROM PR_ENCOUNTER_VW A,AM_PATIENT_CLASS B WHERE FACILITY_ID ='"+facility_id+"' AND PATIENT_ID = '"+patient_id+"' AND (VISIT_STATUS <> '99' OR ADT_STATUS <> '09') AND VISIT_ADM_DATE_TIME = (SELECT MAX(VISIT_ADM_DATE_TIME) FROM PR_ENCOUNTER WHERE FACILITY_ID = '"+facility_id+"' AND PATIENT_ID = '"+patient_id+"') AND A.PATIENT_CLASS = B.PATIENT_CLASS";
	
	cstmt=con.createStatement();
	countrset=cstmt.executeQuery(esqlcount);
	if(countrset.next()) count=countrset.getInt(1);

	if(countrset != null) countrset.close();
	if(cstmt != null) cstmt.close();

	if(count<=0)
	  {
		%>
	<script>
	  alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));
    </script>
    <%}else{
   
  String esql="SELECT ENCOUNTER_ID, TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME,ATTEND_PRACTITIONER_ID, PRACTITIONER_NAME, ASSIGN_CARE_LOCN_CODE, CLINIC_NAME LOCATION,A.PATIENT_CLASS, SHORT_DESC PATIENT_CLASS_DESC, DECODE(ADT_STATUS, NULL, VISIT_STATUS) STATUS FROM PR_ENCOUNTER_VW A,AM_PATIENT_CLASS B WHERE FACILITY_ID ='"+facility_id+"' AND PATIENT_ID = '"+patient_id+"' AND (VISIT_STATUS <> '99' OR ADT_STATUS <> '09') AND VISIT_ADM_DATE_TIME = (SELECT MAX(VISIT_ADM_DATE_TIME) FROM PR_ENCOUNTER WHERE FACILITY_ID = '"+facility_id+"' AND PATIENT_ID = '"+patient_id+"') AND A.PATIENT_CLASS = B.PATIENT_CLASS";
  
   stmt=con.createStatement();
   rset=stmt.executeQuery(esql);
   %>
       <table border='1' cellpadding='0' cellspacing='0' width='100%'>
	   <td class='columnheader' align='left'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
	   <td class='columnheader' align='left'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	   <td class='columnheader' align='left'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	   <td class='columnheader' align='left'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	   <td class='columnheader' align='left'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	   <td class='columnheader' align='left'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	   <%
	   while(rset.next())
	   {
		  encounter_date=rset.getString("VISIT_ADM_DATE_TIME");
		  if(encounter_date==null)encounter_date="&nbsp;";
		  encounter_id=rset.getString("ENCOUNTER_ID");
		  if(encounter_id==null)encounter_id="&nbsp;";
		  patient_class=rset.getString("PATIENT_CLASS_DESC");
		  if(patient_class==null)patient_class="&nbsp;";
		  location=rset.getString("LOCATION");
		 if(location==null)location="&nbsp;";
		  practitioner=rset.getString("PRACTITIONER_NAME");
		  if(practitioner==null)practitioner="&nbsp;";
		  status=rset.getString("STATUS");
			if(status==null)status="&nbsp;";
		   
		   if (query_even_odd == 1)
                        {
                            query_even_odd = 2;
                            classValue = "QRYODD";
                        }
                        else
                        {
                            classValue = "QRYEVEN";
                            query_even_odd = 1;
                         }
           out.println("<tr><td  class='" + classValue + "'>");
		   out.println(encounter_date);
		   out.println("</td><td  class='"+classValue+"'>");
		   out.println(encounter_id);
		   out.println("</td><td  class='"+classValue+"'>");
		   out.println(patient_class);
		   out.println("</td><td  class='"+classValue+"'>");
		   out.println(location);
           out.println("</td><td  class='"+classValue+"'>");
		   out.println(practitioner);
		   out.println("</td><td class='"+classValue+"'>");
		   out.println(status);
		   out.println("</td></tr>");
         }
		 %>
   </table>
   <%}   
  }catch(Exception e){ out.println(e.toString());}
  finally
  {
	   if(rset!=null)rset.close();
	  if(stmt!=null)stmt.close();
	 
	  if(con!=null) ConnectionManager.returnConnection(con,request);
  }
%>
</form>
</body>
</html>

