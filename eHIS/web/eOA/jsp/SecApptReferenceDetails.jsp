<!DOCTYPE html>

 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
<head>
<title><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></title>

 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 <table border='1' cellpadding='0' cellspacing='0' width='102%' align='center' >

<%
		Connection con = null;
		Statement	stmt		=null;
		ResultSet	rs			=null;
		PreparedStatement pstmt=null;
		Statement	stmt1		=null;
		Statement stmt3 =null;
		
		ResultSet	rs1			=null;
		ResultSet   rs2			=null;	
		request.setCharacterEncoding("UTF-8");

		String appt_no2	= request.getParameter("appt_no2");
		String fac_id2	= request.getParameter("fac_id2");
		String called_from	= request.getParameter("called_from")==null?"":request.getParameter("called_from");//Added for the CRF - Bru-HIMS-CRF-0198
		String classValue		="";
		String appt_time	="";
		String appt_time1	="";
		String str1="";
		String resource_class	="";
		String resource_id		="";
		String sql4="";
		String sql5="";
		String RESOURCE_ID="";
		String RESOURCE_CLASS="";
		String res_description="";
		String name	="";
		String gender	="";
		String pat_id	="";
		String age	="";
		String clinic_name	="";
		String pat_short_name	="";
		String appt_ref	="";
		String appt_date1="";
		//String resc_desc="";
		int i=0;
					String locale=(String)session.getAttribute("LOCALE");

try{

	con = ConnectionManager.getConnection(request);
	stmt1					=con.createStatement();
	stmt=con.createStatement();
	stmt3=con.createStatement();
	if(called_from.equals("")){
		//sql4="select APPT_REF_NO,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(RESOURCE_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, RESOURCE_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, RESOURCE_ID,'"+locale+"','2')) RESOURCE_DESC,RESOURCE_ID,RESOURCE_CLASS,to_char(APPT_DATE,'dd/mm/yyyy')Apptdate,to_char(APPT_SLAB_FROM_TIME,'hh24:mi')Appttime, to_char(APPT_SLAB_TO_TIME,'hh24:mi')Appttime1 from OA_RESOURCE_FOR_APPT  where appt_ref_no = nvl('"+appt_no2+"',appt_ref_no)  and FACILITY_ID='"+fac_id2+"' ORDER by  APPTDATE,APPTTIME";
		sql4="select APPT_REF_NO,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(RESOURCE_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, RESOURCE_ID,?,'2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, RESOURCE_ID,?,'2')) RESOURCE_DESC,RESOURCE_ID,RESOURCE_CLASS,to_char(APPT_DATE,'dd/mm/yyyy')Apptdate,to_char(APPT_SLAB_FROM_TIME,'hh24:mi')Appttime, to_char(APPT_SLAB_TO_TIME,'hh24:mi')Appttime1 from OA_RESOURCE_FOR_APPT  where appt_ref_no = nvl(?,appt_ref_no)  and FACILITY_ID=? ORDER by  APPTDATE,APPTTIME";
	}else{
		//sql4="select APPT_REF_NO,AM_GET_DESC.AM_PRACTITIONER(RESOURCE_ID,'"+locale+"','1') RESOURCE_DESC,RESOURCE_ID,RESOURCE_CLASS,to_char(APPT_DATE,'dd/mm/yyyy')Apptdate,to_char(APPT_SLAB_FROM_TIME,'hh24:mi')Appttime, to_char(APPT_SLAB_TO_TIME,'hh24:mi')Appttime1 from OA_RESOURCE_FOR_APPT  where appt_ref_no = nvl('"+appt_no2+"',appt_ref_no)  and FACILITY_ID='"+fac_id2+"' and resource_class='P' ORDER by  APPTDATE,APPTTIME";//Added for the CRf - Bru-HIMS-CRF-0198		
		sql4="select APPT_REF_NO,AM_GET_DESC.AM_PRACTITIONER(RESOURCE_ID,?,'1') RESOURCE_DESC,RESOURCE_ID,RESOURCE_CLASS,to_char(APPT_DATE,'dd/mm/yyyy')Apptdate,to_char(APPT_SLAB_FROM_TIME,'hh24:mi')Appttime, to_char(APPT_SLAB_TO_TIME,'hh24:mi')Appttime1 from OA_RESOURCE_FOR_APPT  where appt_ref_no = nvl(?,appt_ref_no)  and FACILITY_ID=? and resource_class='P' ORDER by  APPTDATE,APPTTIME";//Added for the CRf - Bru-HIMS-CRF-0198		
	}

		//rs = stmt.executeQuery(sql4);
		pstmt = con.prepareStatement(sql4);
		pstmt.setString(1,locale);
		if(called_from.equals("")){
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,appt_no2);
		pstmt.setString(5,fac_id2);
		}else{
		pstmt.setString(2,appt_no2);
		pstmt.setString(3,fac_id2);
		}
		rs = pstmt.executeQuery();
		if ( rs != null )
		{  
			 %>
			 <table border='0' cellpadding='0' cellspacing='0' width='102%' align='center' >
			 <% 
//sql5="select APPT_REF_NO, PATIENT_ID, APPT_TIME, PATIENT_NAME, GENDER, get_age(date_of_birth) age, AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,'"+locale+"','1')CARE_LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_SHORT_NAME, to_char(APPT_DATE,'dd/mm/yyyy')Apptdate from oa_appt where appt_ref_no = nvl('"+appt_no2+"',appt_ref_no) and FACILITY_ID='"+fac_id2+"'";
			 sql5="select APPT_REF_NO, PATIENT_ID, APPT_TIME, PATIENT_NAME, GENDER, get_age(date_of_birth) age, AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,?,'1')CARE_LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,?,'1') CLINIC_SHORT_DESC, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) PRACTITIONER_SHORT_NAME, to_char(APPT_DATE,'dd/mm/yyyy')Apptdate from oa_appt where appt_ref_no = nvl(?,appt_ref_no) and FACILITY_ID=?";
			//rs1 = stmt1.executeQuery(sql5);
			
			pstmt = con.prepareStatement(sql5);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,appt_no2);
			pstmt.setString(7,fac_id2);
			rs1 = pstmt.executeQuery();
			if ( rs1 != null )
			while(rs1.next())
			{	
				name=rs1.getString("PATIENT_NAME");
				gender=rs1.getString("GENDER");
				pat_id=rs1.getString("PATIENT_ID");
				age=rs1.getString("age");
				clinic_name=rs1.getString("CLINIC_SHORT_DESC");
				pat_short_name=rs1.getString("PRACTITIONER_SHORT_NAME");
				appt_ref=rs1.getString("APPT_REF_NO");
				appt_date1=rs1.getString("Apptdate");
				if(appt_date1==null) appt_date1="";

				String appt_date1_disply=DateUtils.convertDate(appt_date1,"DMY","en",locale);

				if(age==null) age="";
				if(name==null) name="";
				if(pat_id==null) pat_id="";
				if(appt_ref==null) appt_ref="";
				if(pat_short_name==null) pat_short_name="";
				if(gender==null) gender="";
				if(clinic_name==null) clinic_name="";
			%>
		 <tr>
			 <td  class='PATIENTLINECOLOROTHLANG'  nowrap width='30%' align='left' colspan='2'><font size='-1'><b><%=name%>/<%=gender%>/<%=age%></b></font></td>
			 <td  class='PATIENTLINECOLOROTHLANG'  width='50%' nowrap align='left' colspan='2'><b>&nbsp;</b></td> 
			 <td width='5%' align='right' width='30%' class='PATIENTLINECOLOROTHLANG' colspan='2' align='right' nowrap ><font size='-1'><b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></b></font></td>
			 <td  class='PATIENTLINECOLOROTHLANG'  width='30%' nowrap align='left' colspan='1'><font size='-1'><b>&nbsp;&nbsp;<%=pat_id%></b></font></td>
		</tr>
	
		<tr>
			 <td  class='PATIENTLINECOLOROTHLANG'  nowrap align='left' colspan='2'><font size='-1'><b><%=clinic_name%>&nbsp;/&nbsp;<%=pat_short_name%></b></font></td>
			 <td  class='PATIENTLINECOLOROTHLANG'  nowrap align='left' colspan='2'><b></b></td> 
			 
			 <td  class='PATIENTLINECOLOROTHLANG'  nowrap align='right' colspan='2'><font size='-1'><b><fmt:message        			key="Common.apptno.label" bundle="${common_labels}"/></b>&nbsp;</font></td>
			 
			 <td  class='PATIENTLINECOLOROTHLANG'  nowrap align='left' colspan='1'><font size='-1'><b><%=appt_ref%>&nbsp;|<fmt:message 		   key="Common.apptdate.label" bundle="${common_labels}"/>&nbsp;<%=appt_date1_disply%></b></font></td>
		 </tr>
		
</table>

<table border='1' cellpadding='0' cellspacing='0' width='102%' align='center' >
	<tr>
			<td class='COLUMNHEADER'  width='30%' nowrap><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  width='28%' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  width='28%' nowrap><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  width='25%' nowrap><b><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></b></td>
			<td class='COLUMNHEADER'  width='25%' nowrap><b><fmt:message key="Common.totime.label" bundle="${common_labels}"/></b></td>
	</tr>
	<% } //end of while
		
		while(rs.next())
		{	
			if ( i % 2 == 0 )
			  classValue = "QRYEVEN" ;
		   else
			  classValue = "QRYODD" ;
		
				appt_no2=rs.getString("APPT_REF_NO");
			
				
			




				resource_id=rs.getString("RESOURCE_DESC");
				if(resource_id==null){
				resource_id="&nbsp;";
				}
			
				RESOURCE_ID=rs.getString("RESOURCE_ID");
				if(RESOURCE_ID==null) {
					RESOURCE_ID="&nbsp;";
				}
				RESOURCE_CLASS=rs.getString("RESOURCE_CLASS");
				if(RESOURCE_CLASS==null) {
					RESOURCE_CLASS="&nbsp;";
				}

				if(RESOURCE_CLASS.equals("P"))
				{
				resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(RESOURCE_CLASS.equals("R"))
				{
				resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(RESOURCE_CLASS.equals("E"))
				{
				resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(RESOURCE_CLASS.equals("O"))
				{
				resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
				}

				appt_time=rs.getString("Appttime");
				if(appt_time==null){
				appt_time="&nbsp;";
				}
				appt_time1=rs.getString("Appttime1");
				if(appt_time1==null){
				appt_time1="&nbsp;";
				}
				if(RESOURCE_CLASS.equals("P"))
				{
						//str1  = "select a.pract_type res_type, a.short_name descrip, b.desc_sysdef res_desc from am_practitioner_lang_vw a, am_pract_type_lang_vw b where nvl(a.practitioner_id,'x')=nvl('"+RESOURCE_ID+"','x') and b.pract_type=a.pract_type and a.language_id = '"+locale+"' and a.language_id = b.language_id " ;
				        str1 = "SELECT a.pract_type res_type, a.short_name descrip, b.desc_sysdef res_desc " + "FROM am_practitioner_lang_vw a, am_pract_type_lang_vw b " + "WHERE NVL(a.practitioner_id, 'x') = NVL(?, 'x') " + "AND b.pract_type = a.pract_type " + "AND a.language_id = ? " + "AND a.language_id = b.language_id"; //MODIFIED FOR PREPARED STATEMENT ISSUE
				}else if(RESOURCE_CLASS.equals("R"))
				{
						//str1  = "select a.room_type res_type, a.short_desc descrip, b.short_desc res_desc from am_facility_room_lang_vw a, am_care_locn_type_lang_vw b where nvl(a.room_num,'x')=nvl('"+RESOURCE_ID+"','x') and a.OPERATING_FACILITY_ID='"+fac_id2+"' and a.room_type=b.LOCN_TYPE and a.language_id = '"+locale+"' and a.language_id = b.language_id" ;
						str1 = "SELECT a.room_type res_type, a.short_desc descrip, b.short_desc res_desc " + "FROM am_facility_room_lang_vw a, am_care_locn_type_lang_vw b " + "WHERE NVL(a.room_num, 'x') = NVL(?, 'x') " + "AND a.operating_facility_id = ? " + "AND a.room_type = b.locn_type " + "AND a.language_id = ? " + "AND a.language_id = b.language_id"; //MODIFIED FOR PREPARED STATEMENT ISSUE
				}else{
						//str1  = "select a.resource_type res_type, a.short_desc descrip, b.short_desc res_desc from am_resource_lang_vw a, am_resource_type_lang_vw b where nvl(a.resource_id,'x')=nvl('"+RESOURCE_ID+"','x') and a.facility_id= '"+fac_id2+"' and a.resource_Class='"+RESOURCE_CLASS+"' and a.resource_type=b.resource_type and a.language_id = '"+locale+"' and a.language_id = b.language_id" ;
						str1 = "SELECT a.resource_type res_type, a.short_desc descrip, b.short_desc res_desc " + "FROM am_resource_lang_vw a, am_resource_type_lang_vw b " + "WHERE NVL(a.resource_id, 'x') = NVL(?, 'x') " + "AND a.facility_id = ? " + "AND a.resource_Class = ? " +"AND a.resource_type = b.resource_type " + "AND a.language_id = ? " + "AND a.language_id = b.language_id"; /*MODIFIED FOR ML-MMOH-SCF-3103-TF*/
				}

					//rs2=stmt3.executeQuery(str1);
					pstmt = con.prepareStatement(str1);
					pstmt.setString(1,RESOURCE_ID);
					if(RESOURCE_CLASS.equals("P")){
					pstmt.setString(2,locale);
					}else if(RESOURCE_CLASS.equals("R")){
					pstmt.setString(2,fac_id2);
					pstmt.setString(3,locale);
					}else{
					pstmt.setString(2,fac_id2);
					pstmt.setString(3,RESOURCE_CLASS);
					pstmt.setString(4,locale);
					}
					rs2 = pstmt.executeQuery();

					res_description="";
					if(rs2 !=null )
					{
						while(rs2.next())
						{
						res_description=rs2.getString("res_desc");
						}
					}
					if(rs2 !=null)rs2.close();


		%>
	<tr>
		<td  class='<%=classValue%>'  nowrap ><%=resource_class%></td>
		<td  class='<%=classValue%>'  nowrap ><%=res_description%></td>
		<td  class='<%=classValue%>'  nowrap ><%=resource_id%></td>
		<td  class='<%=classValue%>'  nowrap ><%=appt_time%></td>
		<td  class='<%=classValue%>'  nowrap ><%=appt_time1%></td>
	</tr> 
	<%	
			i++;
		
	}//end of while
			
  } 

  if(i == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
window.close();</script>
<%}


  if(rs !=null) rs.close();
		%>
		</table>
	<%
	if (rs != null) rs.close();
	if (rs1 != null) rs1.close();
	if(rs2 !=null)rs2.close();
	if (stmt != null) stmt.close();
	if (stmt1 != null) stmt1.close();
	if (stmt3 != null) stmt3.close();

}
catch(Exception e)
	{
	//out.println("one L :" +e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</body>
</html> 

