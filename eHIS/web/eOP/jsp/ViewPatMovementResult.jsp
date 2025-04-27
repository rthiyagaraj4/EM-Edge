<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@	page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" %>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>



<HTML>
 <head>
   <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
 <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
 </head>
<BODY class='CONTENT' onKeyDown='lockKey();'>
<form>
<%
 
  Connection con=null;
  Statement stmt=null;
  ResultSet rs=null;
  String encounterid=request.getParameter("encounterid");
  String facility_id= (String) session.getValue( "facility_id" ) ;
  String locale=(String)session.getAttribute("LOCALE"); 
  //int noOfRecords= 0  ;
  String date_time="";
  String movement_type="";
  String loc_desc="";
  String movement_reason="";
  String whodone="";
  String classValue="";
  String date_time_display="";
  int i = 0;	
  int cnt = 0;
 
  try
  {
	 
	  String sql="SELECT   a.ENCOUNTER_ID encounter_id,  A.MOVEMENT_TYPE,  DECODE(a.to_locn_type, 'W', get_desc ('en', 'rd_clinic_lang_vw', 'LONG_DESC', 'CLINIC_CODE', a.to_locn_code),'O', get_desc ('en', 'ot_oper_room_lang_vw', 'LONG_DESC', 'OPER_ROOM_CODE', a.to_locn_code),'N',IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.to_locn_code,'"+locale+"','1'), 'R',  AM_GET_DESC.AM_FACILITY_ROOM(a.facility_id,a.to_locn_code,'"+locale+"','2'),OP_GET_DESC.OP_CLINIC(a.facility_id, a.to_locn_code,'"+locale+"','1')) locn_desc,  a.ADDED_BY_ID whodone,  TO_CHAR(a.modified_date,  'dd/mm/yyyy hh24:mi:ss') trans_date, AM_GET_DESC.AM_CONTACT_REASON(A.MOVEMENT_REASON_CODE,  '"+locale+"',  '1') MOVEMENT_REASON FROM   pr_patient_movement a WHERE   a.FACILITY_ID='"+facility_id+"' AND   a.ENCOUNTER_ID='"+encounterid+"' ORDER BY a.modified_date desc";
	  
	  Boolean enteredByAppl = false;	// Added by shagar for ML-MMOH-CRF-1328
	  con = ConnectionManager.getConnection(request);
	  enteredByAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "ENTERED_BY");// Added by shagar for ML-MMOH-CRF-1328
	  //String sql="select a.ENCOUNTER_ID encounter_id, Decode(a.MOVEMENT_TYPE,'A', 'Arrived at ','D','Departed to',null) MOVEMENT_TYPE,Decode(a.TO_LOCN_TYPE, 'N', (select short_desc from ip_nursing_unit where facility_id=a.facility_id and nursing_unit_code=a.TO_LOCN_CODE),(select short_desc from op_clinic where facility_id=a.facility_id and clinic_code=a.TO_LOCN_CODE)) locn_desc, a.ADDED_BY_ID whodone, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss')trans_date,decode(a.MOVEMENT_REASON_CODE,null, null, (select CONTACT_REASON from am_contact_reason where CONTACT_REASON_CODE=a.MOVEMENT_REASON_CODE))  MOVEMENT_REASON,to_char(b.QUEUE_DATE,'dd/mm/yyyy hh24:mi') QUEUE_DATE,decode(b.PRACTITIONER_ID,null, null,(select practitioner_name from am_practitioner where PRACTITIONER_ID=b.PRACTITIONER_ID)) practitioner_name,decode(b.SPECIALITY_CODE,null, null,(select short_desc from am_speciality where SPECIALITY_CODE=b.SPECIALITY_CODE)) speciality_desc from pr_patient_movement a, op_patient_queue b where a.FACILITY_ID='"+facility_id+"' and a.ENCOUNTER_ID='"+encounterid+"' and a.FACILITY_ID=b.facility_id and a.ENCOUNTER_ID=b.ENCOUNTER_ID order by a.ADDED_DATE desc ";

	  stmt=con.createStatement();
	  rs=stmt.executeQuery(sql);
	  
	  while(rs.next())
	  {
		if( cnt == 0 )
		{	 
		%>
			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<td class='columnheader' width='20%' nowrap><fmt:message key="eOP.MovementDateTime.label" bundle="${op_labels}"/></td>
			<td class='columnheader' width='20%' nowrap><fmt:message key="eOP.MovementType.label" bundle="${op_labels}"/></td>
			<td class='columnheader' width='20%' nowrap><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/> </td>
			<td class='columnheader' width='20%' nowrap><fmt:message key="eOP.MovementReason.label" bundle="${op_labels}"/></td>
			<%if(enteredByAppl){ // Added by shagar for ML-MMOH-CRF-1328 %>
			<td class='columnheader' width='20%' nowrap><fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/></td>
            <%} else{%>
			<td class='columnheader' width='20%' nowrap><fmt:message key="Common.whodoneit.label" bundle="${common_labels}"/></td>
			<%}%>
		<%		
		}

				
			if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
		        classValue = "QRYODD" ;
			date_time=rs.getString("trans_date");
			if(date_time == null) date_time="";
			date_time_display=DateUtils.convertDate(date_time,"DMYHMS","en",localeName);
			movement_type=rs.getString("MOVEMENT_TYPE");
			if(movement_type == null) movement_type="";
			if(movement_type.equals("A"))
            movement_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.Arrivedat.label","op_labels");
			else if(movement_type.equals("D"))
            movement_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.Departedto.label","op_labels"); 
			loc_desc=rs.getString("locn_desc");
			if(loc_desc == null) loc_desc="";
			movement_reason=rs.getString("MOVEMENT_REASON");
			
			if(movement_reason == null) movement_reason="&nbsp;";
			whodone=rs.getString("whodone");
			if(whodone == null) whodone="";
		  %>
		  <tr>
			  <td align='left' class='<%=classValue%>' width='20%' nowrap><%=date_time_display%></td>
			  <td align='left' class='<%=classValue%>' width='20%' nowrap><%=movement_type%></td>
			  <td align='left' class='<%=classValue%>' width='20%' nowrap><%=loc_desc%></td>
			  <td align='left' class='<%=classValue%>' width='20%' nowrap><%=movement_reason%></td>
			  <td align='left' class='<%=classValue%>' width='20%' nowrap><%=whodone%></td>
		  </tr>
		  <%
			i++;
			cnt++;
		}
		%>
</table>
<%
	if(cnt == 0)
	{				
%>
	<script>
	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));
	parent.frames[2]. location.href ="../../eCommon/html/blank.html" ;
	</script>
<%
	}
  
  }catch(Exception e)
  {
	  e.printStackTrace();
  }finally
  {
	  if(rs != null) rs.close();
	  if(stmt != null) stmt.close();
	  if(con!=null) ConnectionManager.returnConnection(con,request); 
  }

%>
</form>
</body>
</html>


