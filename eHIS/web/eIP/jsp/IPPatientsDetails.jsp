<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle     = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
   String locale	 = (String)session.getAttribute("LOCALE");  
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eIP/js/IPCountLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body OnMouseDown='CodeArrest();' class='CONTENT' onKeyDown = 'lockKey();' >
<form name='dd' id='dd'>
<%
Connection con			   = null;
ResultSet rset			   = null ;
PreparedStatement pstmt    = null;
StringBuffer  sql		   = new StringBuffer();
String Nursing_unit_code   = "";
String facilityid          = "";
String Speciality_code     = "";
String From_date           = "";
String To_date             = "";
String Practitioner_id     = "";
String patient_catogory    = "";
//String admission_date_time = "";
String classValue		   = "";
//String prev_val            = "";
//String prev_val2           = "";
String specialty_short_desc= "";
String practitioner_name   = "";
String disp_value          = "";
String pre_dis_value       = "";
String endOfRes            ="1";
String from                = "";
String to                  = "";
String wherecuasesql       = "";
//int count                  = 0 ;
//int z					   = 0 ;
//int records_to_show		   = 20;
//int maxRecords             = 0 ;
int start                  = 0 ;
int end                    = 0 ;
int i                      = 1 ;
int cnt                    = 0 ;



try{
Nursing_unit_code       = checkForNull(request.getParameter("Nursing_unit_code")) ;
facilityid              = checkForNull(request.getParameter("facilityid")) ;
Speciality_code         = checkForNull(request.getParameter("Speciality_code")) ;
From_date               = checkForNull(request.getParameter("From_date")) ;
To_date                 = checkForNull(request.getParameter("To_date")) ;
Practitioner_id         = checkForNull(request.getParameter("Practitioner_id")) ;
patient_catogory        = checkForNull(request.getParameter("patient_catogory")) ;
wherecuasesql           = checkForNull(request.getParameter("sql"));
from                    = checkForNull(request.getParameter( "from")) ;
to                      = checkForNull(request.getParameter( "to"));



 
 /*Below condition modified by Venkatesh.S on 19-Feb-2013 against 37942 */
 
if(wherecuasesql.equals("")){
if(!Nursing_unit_code.equals("")){ 
	wherecuasesql=" and a.nursing_unit_code = '"+Nursing_unit_code+"'";}
if(!Speciality_code.equals("")){
	wherecuasesql=wherecuasesql+" and a.specialty_code = '"+Speciality_code+"' ";}
if(!Practitioner_id.equals("")){
	wherecuasesql=wherecuasesql+" and a.practitioner_id = '"+Practitioner_id+"' ";}
if(!From_date.equals("") && !To_date.equals("")){
	wherecuasesql=wherecuasesql+" and trunc(a.admission_date_time) BETWEEN TO_DATE ('"+From_date+"', 'DD/MM/YYYY') AND TO_DATE ('"+To_date+"', 'DD/MM/YYYY')";
}else if(!From_date.equals("")){
	wherecuasesql=wherecuasesql+" and trunc(a.admission_date_time) >= TO_DATE ('"+From_date+"', 'DD/MM/YYYY') ";
}else if(!To_date.equals("")){ 
	wherecuasesql=wherecuasesql+" and trunc(a.admission_date_time) <= TO_DATE ('"+To_date+"', 'DD/MM/YYYY') ";}
	 /* end 37942 */
	 
if ( ! patient_catogory.equals("") && patient_catogory.equals("IP_PAT_COUNT") ){
      wherecuasesql = " ip_open_encounter_vw a, mp_patient b  WHERE a.patient_id = b.patient_id AND a.gender = b.sex AND a.facility_id = '"+facilityid+"' AND   a.patient_class = 'IP' "+wherecuasesql;
}else if(!patient_catogory.equals("") && patient_catogory.equals("FRGN_PAT_COUNT")){
      wherecuasesql =" ip_open_encounter_vw a WHERE patient_class = 'IP' AND a.citizen_yn = 'N' AND facility_id = '"+facilityid+"' "+wherecuasesql;
}else if(!patient_catogory.equals("") && patient_catogory.equals("DISC_ADV_COUNT")){
      wherecuasesql=" ip_open_encounter_vw a, ip_discharge_advice b WHERE b.CANCELLATION_DATE_TIME IS null and b.DIS_ADV_STATUS IN (0,9) and  a.ENCOUNTER_ID =  b.ENCOUNTER_ID and a.facility_id = '"+facilityid+"'"+wherecuasesql;
}else if(!patient_catogory.equals("") && patient_catogory.equals("CORP_PAT_COUNT")){
      wherecuasesql=" ip_open_encounter_vw a, bl_episode_fin_dtls b  WHERE b.settlement_ind = 'R' and  b.episode_type = 'I' and a.patient_class = 'IP' and  a.encounter_id = b.encounter_id  and a.facility_id ='"+facilityid+"' "+wherecuasesql;
}else if(!patient_catogory.equals("") && patient_catogory.equals("INSU_PAT_COUNT")){
      wherecuasesql=" ip_open_encounter_vw a, bl_episode_fin_dtls b  WHERE b.settlement_ind = 'X' and  b.episode_type = 'I' and a.patient_class = 'IP' and  a.encounter_id = b.encounter_id  and a.facility_id ='"+facilityid+"' "+wherecuasesql;
}else if(!patient_catogory.equals("") && patient_catogory.equals("FREE_PAT_COUNT")){
      wherecuasesql=" ip_open_encounter_vw a, bl_episode_fin_dtls b  WHERE b.blng_grp_id = 'FREE'  and b.episode_type = 'I'  and  a.patient_class = 'IP'  and a.encounter_id = b.encounter_id and a.facility_id = '"+facilityid+"'"+wherecuasesql;
}else if(!patient_catogory.equals("") && patient_catogory.equals("CASH_PAT_COUNT")){ 
       wherecuasesql="ip_open_encounter_vw a, bl_episode_fin_dtls b   WHERE  b.settlement_ind = 'C'  and  b.blng_grp_id != 'FREE' and  b.episode_type = 'I' and  a.patient_class = 'IP'  and a.encounter_id = b.encounter_id and a.facility_id = '"+facilityid+"'"+wherecuasesql;}
      wherecuasesql=wherecuasesql+" ORDER BY a.specialty_short_desc, a.practitioner_short_name, TO_DATE (a.admission_date_time, 'DD/MM/RRRR HH24:MI') "; }
	   




sql.append("select  TO_CHAR (a.admission_date_time, 'dd/mm/rrrr hh24:mi') admission_date_time ,a.encounter_id,a.patient_id ,DECODE ('"+locale+"', '"+locale+"', a.patient_name, NVL (a.patient_name_loc_lang, a.patient_name)) patient_name,a.gender gender,ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', 2) nursing_unit_short_desc,ip_get_desc.ip_bed_class (a.bed_class_code, '"+locale+"', 2) bed_class_short_desc,ip_get_desc.ip_bed_type (a.bed_type_code, '"+locale+"', 2) bed_type_short_desc,bed_no,a.room_no, am_get_desc.am_speciality (specialty_code, 'en', '2') specialty_short_desc,am_get_desc.am_practitioner (practitioner_id, 'en', '1') practitioner_short_name from "+wherecuasesql);



con					    = ConnectionManager.getConnection(request); 
pstmt                   = con.prepareStatement(sql.toString());
rset                    = pstmt.executeQuery();

if (from ==""){start = 1 ;}   else {  start = Integer.parseInt( from ) ; }
if (to ==""){ end = 20 ; }    else {  end = Integer.parseInt( to ) ; }
	
		
if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	
%>
    
<%

 
while(i<=end && rset.next()){ 
if (cnt == 0)
	{             
	
%><p>

<table align="right">
<tr>
<td >
  <%if ( !(start <= 1) ){
  out.println("<A HREF='../../eIP/jsp/IPPatientsDetails.jsp?Nursing_unit_code="+Nursing_unit_code+"&facilityid="+facilityid+"&Speciality_code="+Speciality_code+"&From_date="+From_date+"&To_date="+To_date+"&Practitioner_id="+Practitioner_id+"&sql="+java.net.URLEncoder.encode(wherecuasesql)+"&from="+(start-20)+"&to="+(end-20)+"'text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
  %>

<%} if ( endOfRes.equals("1") ){ 
out.println("<A id='nextval' HREF='../../eIP/jsp/IPPatientsDetails.jsp?Nursing_unit_code="+Nursing_unit_code+"&facilityid="+facilityid+"&Speciality_code="+Speciality_code+"&From_date="+From_date+"&To_date="+To_date+"&Practitioner_id="+Practitioner_id+"&sql="+java.net.URLEncoder.encode(wherecuasesql)+"&from="+(start+20)+"&to="+(end+20)+"'text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>



<%}%>
</td>
</tr>
</table><br></p>
 <div style="position:relative;height:90vh;width:100vw;overflow:auto"> 
<table  align='center' border="1"  cellspacing='0' cellpadding='0' ><tr></tr>
<thead id="TabHead">
<tr style="position: sticky; top: 0; background-color: white; z-index: 1;">
         <td  nowrap class="COLUMNHEADER"> <fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
		<td width='100px'  nowrap class="COLUMNHEADER"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td> 
		<td  nowrap class="COLUMNHEADER"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td  nowrap class="COLUMNHEADER"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td  width='60px' nowrap class="COLUMNHEADER"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td  width='85px' nowrap class="COLUMNHEADER"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td  nowrap class="COLUMNHEADER"><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
		<td  nowrap class="COLUMNHEADER"><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
		<td width='60px' nowrap class="COLUMNHEADER"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
		<td  width='70px' nowrap class="COLUMNHEADER"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
		</tr> <br/>
 </thead>
 
<input type='hidden' name='Nursing_unit_code' id='Nursing_unit_code' value='<%=Nursing_unit_code%>'></input>
<input type='hidden' name='Speciality_code' id='Speciality_code' value='<%=Speciality_code%>'></input>
<input type='hidden' name='From_date' id='From_date' value='<%=From_date%>'></input>
<input type='hidden' name='To_date' id='To_date' value='<%=To_date%>'></input>
<input type='hidden' name='Practitioner_id' id='Practitioner_id' value='<%=Practitioner_id%>'></input>
<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>'></input>

         <tbody>  
<%}
 

   if ( i % 2 == 0 )
       classValue = "QRYEVEN" ;
   else
	   classValue = "QRYODD" ;
	
 specialty_short_desc  = checkForNull(rset.getString("specialty_short_desc"));
  practitioner_name     = checkForNull(rset.getString("practitioner_short_name"));
  String bed_no=checkForNull(rset.getString("BED_NO"));
  String room_no=checkForNull(rset.getString("ROOM_NO"));
    if(room_no.equals(""))
	     room_no="&nbsp";
     if(bed_no.equals(""))
	  bed_no="&nbsp"; 
	
  disp_value            = specialty_short_desc;
  if (!practitioner_name.equals("")){disp_value = disp_value+"/"+practitioner_name;}
  if (!pre_dis_value.equals(disp_value) || pre_dis_value.equals(""))
out.println("<tr><td nowrap align='left' nowrap class='CAGROUPHEADING'>"+disp_value+"</td></tr>");	
out.println("<tr><td nowrap align='left' class='"+classValue+"'><font size='1'>"+checkForNull(rset.getString("ADMISSION_DATE_TIME"))+"</font></td>");
out.println("<td nowrap align='left'  class='"+classValue+"'><font size='1'>"+checkForNull(rset.getString("ENCOUNTER_ID"))+"</font></td>");
out.println("<td nowrap align='left' class='"+classValue+"'><font size='1'>"+checkForNull(rset.getString("PATIENT_ID"))+"</font></td>");
out.println("<td nowrap align='left' class='"+classValue+"'><font size='1'>"+checkForNull(rset.getString("PATIENT_NAME"))+"</font></td>");
out.println("<td nowrap align='left' class='"+classValue+"'><font size='1'>"+checkForNull(rset.getString("GENDER"))+"</font></td>");
out.println("<td nowrap align='left' class='"+classValue+"'><font size='1'>"+checkForNull(rset.getString("NURSING_UNIT_SHORT_DESC"))+"</font></td>");
out.println("<td nowrap align='left' class='"+classValue+"'><font size='1'>"+checkForNull(rset.getString("BED_CLASS_SHORT_DESC"))+"</font></td>");
out.println("<td nowrap align='left' class='"+classValue+"'><font size='1'>"+checkForNull(rset.getString("BED_TYPE_SHORT_DESC"))+"</font></td>");
out.println("<td nowrap align='left' class='"+classValue+"'><font size='1'>"+bed_no+"</font></td>");
out.println("<td nowrap align='left' class='"+classValue+"'><font size='1'>"+room_no+"</font></td></tr>");

	    i++;
	cnt++;
pre_dis_value=disp_value ;  	  
	  } 
	   
	   
	   if (!rset.next() && cnt!=0 )
    {
    endOfRes = "0";	
	   %>
<script>
document.getElementById("nextval").innerHTML=" ";
</script>
	   <%}%>
	   </tbody>
</table>
</div>
</form >
</body>
</html>
	
	   
<%}catch (Exception e){
e.printStackTrace();
out.println("IPPatientsDetails.jsp :"+e);
}finally 
{

try{ 
		 if(rset != null) rset.close();
		 if(pstmt != null) pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();}	
	if(con!=null) ConnectionManager.returnConnection(con,request);

} 
%>


<%!
	
	 public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

