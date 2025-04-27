<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>

<%
  Connection conn=null;
  Statement stmt=null;
  ResultSet rs=null;
  PreparedStatement pstmt=null;
  int maxRecord = 0;
  int i=0;
  request.setCharacterEncoding("UTF-8");	
  request= new XSSRequestWrapper(request);
  response.addHeader("X-XSS-Protection", "1; mode=block");
  response.addHeader("X-Content-Type-Options", "nosniff");
  String locale = (String)session.getAttribute("LOCALE");


  String facility_id = request.getParameter("facility_id")==null ?"":request.getParameter("facility_id");
  String loc = request.getParameter("locn")==null ?"":request.getParameter("locn");
  String from_pract = request.getParameter("from_pract")==null ?"":request.getParameter("from_pract");
  String to_pract = request.getParameter("to_pract")==null ?"":request.getParameter("to_pract");
  String day = request.getParameter("day")==null ?"":request.getParameter("day");
  String from_date = request.getParameter("from_dt")==null ?"":request.getParameter("from_dt");
  String to_date = request.getParameter("to_dt")==null ?"":request.getParameter("to_dt");
  String reason = request.getParameter("reason")==null ?"":request.getParameter("reason");
  String reason1 = request.getParameter("reason1")==null ?"":request.getParameter("reason1");
  String locationType=request.getParameter("locationType")==null?"":request.getParameter("locationType");
  String resourceType=request.getParameter("resourceType")==null?"":request.getParameter("resourceType");
  String practid ="";
  String cliniccode ="";
  String clinicdate ="";
  String L_clinic_code="";
  String primary_yn = "";
  String care_locn_type_ind="";
  String resource_class="";

  from_date=DateUtils.convertDate(from_date,"DMY",locale,"en");
  to_date=DateUtils.convertDate(to_date,"DMY",locale,"en");


  StringTokenizer st = new StringTokenizer(loc,"|");
  while (st.hasMoreTokens()) 
  {
        L_clinic_code=st.nextToken();
    st.nextToken();
  st.nextToken();
  }

// String sql="Select TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') Clinic_date,CLINIC_DATE clnc_date, INITCAP(to_char(Clinic_date,'DAY')) day, NVL(Total_slots_booked,0)+ NVL(Total_slots_overbooked,0) no_of_appts,nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked,primary_resource_yn, practitioner_id, clinic_code,care_locn_type_ind,resource_class from OA_CLINIC_SCHEDULE Where facility_id = '"+facility_id+"' and clinic_code = '"+L_clinic_code+"'  and practitioner_id = '"+from_pract+"' and care_locn_type_ind='"+locationType+"'and resource_class='"+resourceType+"' and rtrim(to_char(clinic_date,'DAY')) = nvl(rtrim('"+day+"'), rtrim(to_char(clinic_date,'DAY'))) and clinic_date between TO_DATE('"+from_date+"','DD/MM/YYYY') and TO_DATE('"+to_date+"','DD/MM/YYYY') and clinic_date not in ( Select   Clinic_date from OA_CLINIC_SCHEDULE Where facility_id ='"+facility_id+"' and clinic_code = '"+L_clinic_code+"' and practitioner_id = '"+to_pract+"' and rtrim(to_char(clinic_date,'DAY'))  =nvl(rtrim('"+day+"'),rtrim(to_char(clinic_date,'DAY')) )  and care_locn_type_ind='"+locationType+"'and resource_class='"+resourceType+"' and clinic_date between TO_DATE('"+from_date+"','DD/MM/YYYY') and TO_DATE('"+to_date+"','DD/MM/YYYY'))  order by clnc_date   ";
 String sql="Select TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') Clinic_date,CLINIC_DATE clnc_date, INITCAP(to_char(Clinic_date,'DAY')) day, NVL(Total_slots_booked,0)+ NVL(Total_slots_overbooked,0) no_of_appts,nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked,primary_resource_yn, practitioner_id, clinic_code,care_locn_type_ind,resource_class from OA_CLINIC_SCHEDULE Where facility_id = ? and clinic_code = ?  and practitioner_id = ? and care_locn_type_ind=? and resource_class=? and rtrim(to_char(clinic_date,'DAY')) = nvl(rtrim(?), rtrim(to_char(clinic_date,'DAY'))) and clinic_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') and clinic_date not in ( Select   Clinic_date from OA_CLINIC_SCHEDULE Where facility_id =? and clinic_code = ? and practitioner_id = ? and rtrim(to_char(clinic_date,'DAY'))  =nvl(rtrim(?),rtrim(to_char(clinic_date,'DAY')) )  and care_locn_type_ind=? and resource_class=? and clinic_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY'))  order by clnc_date   ";
	
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
   <script src='../../eOA/js/ChangePractitionerforGenSch.js' language='javascript'></script>
   <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
   <script language='javascript' src='../../eCommon/js/common.js'></script>

</head>

<BODY  class='CONTENT'  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name="search_result_form" id="search_result_form" action='../../servlet/eOA.ChangePractitionerforGenSchServlet' method='post' target='messageFrame'>
   <DIV align='left'>
<% 	
try
	{
		conn = ConnectionManager.getConnection(request);  
		stmt = conn.createStatement();
	  	//rs = stmt.executeQuery(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,L_clinic_code);
		pstmt.setString(3,from_pract);
		pstmt.setString(4,locationType);
		pstmt.setString(5,resourceType);
		pstmt.setString(6,day);
		pstmt.setString(7,from_date);
		pstmt.setString(8,to_date);
		pstmt.setString(9,facility_id);
		pstmt.setString(10,L_clinic_code);
		pstmt.setString(11,to_pract);
		pstmt.setString(12,day);
		pstmt.setString(13,locationType);
		pstmt.setString(14,resourceType);
		pstmt.setString(15,from_date);
		pstmt.setString(16,to_date);
		rs = pstmt.executeQuery();
	  	String noofappts = "";
	  	String classValue = "";
		String clinicdate_disp="";
		String day_code="";
		String day_desc="";
	  	if(rs!=null) 
	      	{
	  	  while(rs.next() )
	  	  {
			  if(i==0)
			  {
%>					
			  <table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
        <td class='COLUMNHEADER'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
        <td class='COLUMNHEADER'><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
        <td class='COLUMNHEADER'><fmt:message key="eOA.NoOfAppts.label" bundle="${oa_labels}"/></td>
        <td class='COLUMNHEADER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td> 
<%
		  }
			 if ( i % 2 == 0 )
		      classValue = "QRYEVEN" ;
		   else
		      classValue = "QRYODD" ;
		    practid 	= rs.getString ("practitioner_id");
	  	   cliniccode 	= rs.getString ("clinic_code");
	  	   clinicdate 	= rs.getString("clinic_date");
		   clinicdate_disp=DateUtils.convertDate(clinicdate,"DMY","en",locale);

		   care_locn_type_ind= rs.getString("care_locn_type_ind");	
		   resource_class= rs.getString("resource_class");	
			noofappts = rs.getString("total_slots_booked");
			primary_yn = rs.getString("primary_resource_yn");

			day_code = rs.getString("day");
			day_code=day_code.trim();
				if(day_code.equalsIgnoreCase("Monday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(day_code.equalsIgnoreCase("Tuesday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(day_code.equalsIgnoreCase("Wednesday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(day_code.equalsIgnoreCase("Thursday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(day_code.equalsIgnoreCase("Friday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(day_code.equalsIgnoreCase("Saturday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(day_code.equalsIgnoreCase("Sunday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}



%>
	  	   <tr><td  class='<%=classValue%>' ><%=clinicdate_disp%>
	  	 	  	   <input type='hidden' name='clinic_date<%=i%>' id='clinic_date<%=i%>' value='<%=rs.getString("clinic_date")%>'>
	  	   </td><td  class='<%= classValue%>'>
		<%=day_desc%>
<%
	  	   if(!(noofappts.equals("0"))){ 
%>
	  	      	</td><td class='<%=classValue%>'>
				<%if(primary_yn.equals("Y")){%>
				<a href=javascript:show_modwin('<%=cliniccode%>','<%=practid%>','<%=rs.getString("day").trim()%>','<%=clinicdate%>','<%=care_locn_type_ind%>','<%=resource_class%>') alt='Appointment Details' >
				<%}%>
				<%=noofappts%>
 <%
				}
				else {
%>	
	  	   	</td><td class='<%=classValue%>'><%=noofappts%> 
<% 
					} 
%>
	  	   </td><td class='<%=classValue%>'  > 
	  	   <input type='checkbox' name='ad_chk_<%=i%>' id='ad_chk_<%=i%>' checked  onClick='setVal(this)'> </td> 
			
			
			<input type='hidden' name='con_val_<%=i%>' id='con_val_<%=i%>' value='<%=rs.getString("clinic_date")%>'> </td></tr>
			<% i++;
	  	   maxRecord++;
			  }
%>
	           <script language='javascript'>
                parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num= '
				parent.frames[0].document.forms[0].genRep1.disabled = false;
			  </script>
<%
	   if(i==0){
%>
				  <script>alert(getMessage('NO_RECORD_FETCHED','OA'))</script> 
<%
		   }
			  }
	      else {
	        %>
	           <script language='javascript'>
				parent.frames[0].document.forms[0].genRep1.disabled = true;                parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+getMessage('NO_RECORD_FETCHED','OA');
              </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	      }


	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();

} catch(Exception e){
//out.println("ee"+e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally   {
   ConnectionManager.returnConnection(conn,request);
}
 %>

      </table>
      <input type='hidden' name='no_of_rec' id='no_of_rec' value='<%=i%>' >
		<input type='hidden' name='day' id='day'  value= '<%=day%>' >
		<input type='hidden' name='final_vals' id='final_vals'  value= '' >
		<input type='hidden' name='sel_rec' id='sel_rec'  value= '' >
		<input type='hidden' name='P_Practitioner_Id' id='P_Practitioner_Id'  value= "<%=from_pract%>" >
		<input type='hidden' name='P_To_Practitioner_Id' id='P_To_Practitioner_Id'  value= "<%=to_pract%>" >
		<input type='hidden' name='eff_from' id='eff_from'  value= "<%=from_date%>" >
		<input type='hidden' name='eff_to' id='eff_to'  value= "<%=to_date%>">
		<input type='hidden' name='reason' id='reason'  value= "<%=reason%>" >
		<input type='hidden' name='reason1' id='reason1'  value= "<%=reason1%>">
		<input type="hidden" name="p_module_id" id="p_module_id"   value="OA"></input>
		<input type="hidden" name="p_report_id" id="p_report_id"   value="OAAFAPLST"></input>
		<input type="hidden" name="P_Facility_id" id="P_Facility_id" value='<%=facility_id%>'></input>
		<input type="hidden" name="locncode" id="locncode" value='<%=loc%>'></input>
		<input type="hidden" name="P_Report_Title" id="P_Report_Title" value='List_of_Appointments_for_change_of_Practitioner'></input>
		<input type="hidden" name="maxRecs" id="maxRecs" value="<%=maxRecord%>"></input>
		<input type="hidden" name="locnType" id="locnType" value="<%=locationType%>">
		<input type="hidden" name="resType" id="resType" value="<%=resourceType%>">
		<input type="hidden" name="resource_value" id="resource_value" value="<%=primary_yn%>">
    </DIV>
   </form>
   </body>
  </html>

