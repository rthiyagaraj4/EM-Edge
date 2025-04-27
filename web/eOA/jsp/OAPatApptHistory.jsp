<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
		request.setCharacterEncoding("UTF-8");	
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String display=request.getParameter("display")==null?"":request.getParameter("display");
		String name_prefix=request.getParameter("name_prefix")==null?"":request.getParameter("name_prefix");
		String first_name=request.getParameter("first_name")==null?"":request.getParameter("first_name");	
		String second_name=request.getParameter("second_name")==null?"":request.getParameter("second_name");
		String third_name=request.getParameter("third_name")==null?"":request.getParameter("third_name");
		String family_name=request.getParameter("family_name")==null?"":request.getParameter("family_name");
		String name_suffix=request.getParameter("name_suffix")==null?"":request.getParameter("name_suffix");
		String name_prefix_oth_lang=request.getParameter("name_prefix_oth_lang")==null?"":request.getParameter("name_prefix_oth_lang");
		String first_name_oth_lang=request.getParameter("first_name_oth_lang")==null?"":request.getParameter("first_name_oth_lang");	
		String second_name_oth_lang=request.getParameter("second_name_oth_lang")==null?"":request.getParameter("second_name_oth_lang");
		String third_name_oth_lang=request.getParameter("third_name_oth_lang")==null?"":request.getParameter("third_name_oth_lang");
		String family_name_oth_lang=request.getParameter("family_name_oth_lang")==null?"":request.getParameter("family_name_oth_lang");
		String name_suffix_oth_lang=request.getParameter("name_suffix_oth_lang")==null?"":request.getParameter("name_suffix_oth_lang");
		String gender=request.getParameter("gender")==null?"":request.getParameter("gender");
		String contact_no=request.getParameter("contact_no")==null?"":request.getParameter("contact_no");
		String nationality=request.getParameter("nationality")==null?"":request.getParameter("nationality");
		String language=request.getParameter("language")==null?"":request.getParameter("language");
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id=(String) session.getValue( "facility_id" ) ;
		StringBuffer and_cond=new StringBuffer();
		String sql="";
		String classValue = "";	
		int per_chk_cancld_past_appts=Integer.parseInt(request.getParameter("per_chk_cancld_past_appts")==null?"0":request.getParameter("per_chk_cancld_past_appts"));
		int per_chk_cancld_fut_appts=Integer.parseInt(request.getParameter("per_chk_cancld_fut_appts")==null?"0":request.getParameter("per_chk_cancld_fut_appts"));
		int per_chk_past_resch_appts=Integer.parseInt(request.getParameter("per_chk_past_resch_appts")==null?"0":request.getParameter("per_chk_past_resch_appts"));
		int per_chk_fut_resch_appts=Integer.parseInt(request.getParameter("per_chk_fut_resch_appts")==null?"0":request.getParameter("per_chk_fut_resch_appts"));
		int no_of_cancld_appts_for_alert=Integer.parseInt(request.getParameter("no_of_cancld_appts_for_alert")==null?"0":request.getParameter("no_of_cancld_appts_for_alert"));
		int no_of_resch_appts_for_alert=Integer.parseInt(request.getParameter("no_of_resch_appts_for_alert")==null?"0":request.getParameter("no_of_resch_appts_for_alert"));
		int per_chk_for_no_show_alert=Integer.parseInt(request.getParameter("per_chk_for_no_show_alert")==null?"0":request.getParameter("per_chk_for_no_show_alert"));
		int no_of_noshow_appts_for_alert=Integer.parseInt(request.getParameter("no_of_noshow_appts_for_alert")==null?"0":request.getParameter("no_of_noshow_appts_for_alert"));
		int per_chk_for_fut_appts_alert =Integer.parseInt(request.getParameter("per_chk_for_fut_appts_alert")==null?"0":request.getParameter("per_chk_for_fut_appts_alert")); //Added for RUT-SCF-0208 (36344) as on 26/11/2012 by Selvin M
		int t=0;
		Connection con = null;
		PreparedStatement ps=null ;
		ResultSet rset=null; 
		try
		{			
			con = ConnectionManager.getConnection(request);
			if(patient_id.equals("")){
					if (!name_prefix.equals("")){					
								and_cond.append(" and name_prefix =?");					
					}
					if (!first_name.equals("")){					
								and_cond.append(" and upper(first_name) like upper(?)");					
					}
					if (!second_name.equals("")){					
								and_cond.append(" and upper(second_name) like upper(?)");					
					}
					if (!third_name.equals("")){				
								and_cond.append(" and upper(third_name) like upper(?)");						
					}
					if (!family_name.equals("")){					
								and_cond.append(" and upper(family_name) like upper(?)");											
					}
					if (!name_suffix.equals("")){					
						and_cond.append(" and upper(name_suffix) like upper(?)");					
					}
					if (!name_prefix_oth_lang.equals("")){
						and_cond.append(" and upper(name_prefix_loc_lang) like upper(?)");
					}
					if (!first_name_oth_lang.equals("")){
						and_cond.append(" and upper(first_name_loc_lang) like upper(?)");
					}
					if (!second_name_oth_lang.equals("")){
						and_cond.append(" and upper(second_name_loc_lang) like upper(?)");
					}
					if (!third_name_oth_lang.equals("")){				
						and_cond.append(" and upper(third_name_loc_lang) like upper(?)");					
					}
					if (!family_name_oth_lang.equals("")){					
						and_cond.append(" and upper(family_name_loc_lang) like upper(?)");									
					}
					if (!name_suffix_oth_lang.equals("")){					
						and_cond.append(" and upper(name_suffix_loc_lang) like upper(?)");					
					}					
					if(!gender.equals("")){
								and_cond.append(" and gender=?");	
					}
					if(!contact_no.equals("")){
								and_cond.append(" and oth_contact_no=?");	
					}
					if(!nationality.equals("")){			
								and_cond.append(" and country_code=?");					
					}
			}
			else
				and_cond.append(" and patient_id='"+patient_id+"'");	
		

			if(display.equals("Reschedule")){	
				// Below Changes done for RUT-CRF-0005.1 by Sudhakar
				sql="select appt_ref_no,to_char(appt_date,'dd/mm/yyyy')appt_date_from,to_char(appt_tr_date,'dd/mm/yyyy')appt_date_to,to_char(appt_slab_from_time,'hh24:mi') || '-' || to_char(appt_slab_to_time,'hh24:mi') appt_time_from,to_char(added_date,'dd/mm/yyyy')reschedule_date,AM_GET_DESC.AM_CONTACT_REASON(REASON_FOR_TRANSFER,'"+locale+"','1')reason_tranfer,AM_GET_DESC.AM_SPECIALITY(from_speciality_code,'"+locale+"','2')speciality_from,AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2')practitioner_from,to_char(tr_appt_slab_from_time,'hh24:mi') || '-' || to_char(tr_appt_slab_to_time,'hh24:mi') appt_time_to,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')speciality_to,AM_GET_DESC.AM_PRACTITIONER(tr_practitioner_id,'"+locale+"','2')practitioner_to,sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"',1)modified_by from OA_APPT_DEL_TR where facility_id='"+fac_id+"' "+and_cond+" and appt_status='N' and bulk_transfer_yn!='Y' and appt_date between trunc(sysdate) - "+per_chk_past_resch_appts+" and trunc(sysdate) + "+per_chk_fut_resch_appts +"order by added_date";
				//System.out.println("sql Reschedule:"+sql);		
				ps = con.prepareStatement(sql);
				if (patient_id.equals("")){
					int psCount=1;			
					if (!name_prefix.equals("")){
						ps.setString(psCount++,name_prefix);
					}
					if (!first_name.equals("")){
						ps.setString(psCount++,first_name);
					}
					if (!second_name.equals("")){
						ps.setString(psCount++,second_name);
					}
					if (!third_name.equals("")){				
						ps.setString(psCount++,third_name);					
					}
					if (!family_name.equals("")){					
						ps.setString(psCount++,family_name);										
					}
					if (!name_suffix.equals("")){					
						ps.setString(psCount++,name_suffix);					
					}			
					
					if (!name_prefix_oth_lang.equals("")){
						ps.setString(psCount++,name_prefix_oth_lang);
					}
					if (!first_name_oth_lang.equals("")){
						ps.setString(psCount++,first_name_oth_lang);
					}
					if (!second_name_oth_lang.equals("")){
						ps.setString(psCount++,second_name_oth_lang);
					}
					if (!third_name_oth_lang.equals("")){				
						ps.setString(psCount++,third_name_oth_lang);					
					}
					if (!family_name_oth_lang.equals("")){					
						ps.setString(psCount++,family_name_oth_lang);										
					}
					if (!name_suffix_oth_lang.equals("")){					
						ps.setString(psCount++,name_suffix_oth_lang);					
					}
					if (!gender.equals("")){					
						ps.setString(psCount++,gender);											
					}
					if(!contact_no.equals("")){			
						ps.setString(psCount++,contact_no);				
					}
					if(!nationality.equals("")){				
						ps.setString(psCount++,nationality);					
					}					
				}
				rset=ps.executeQuery();
				int colsPan =0;
				if(patient_id.equals(""))
					colsPan = 7;
				else
					colsPan = 6;
			%>			
			<table  border='1' cellpadding='0' cellspacing='0' width='100%' >
			<tr>
			<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->	
			<td class='CAHIGHERLEVELCOLOR' align = 'left' colspan='12'><fmt:message key="Common.Reschedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Appointments.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
			<td align='center' colspan='<%=colsPan%>'><b><fmt:message key="Common.Reschedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>			
			<td align='center' colspan='4'><b><fmt:message key="Common.Reschedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
			</tr>
			<tr>
			<td class='CAGROUP' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>			
			<td class='CAGROUP' nowrap><fmt:message key="Common.Reschedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.on.label" bundle="${common_labels}"/></b></td>			
			<td class='CAGROUP' nowrap><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.practitioner.label" bundle="${mp_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>			
			<td class='CAGROUP' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.practitioner.label" bundle="${mp_labels}"/></td>
			<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->
			<td class='CAGROUP' nowrap><fmt:message key="Common.LastModifiedBy.label" bundle="${mp_labels}"/></td>
			</tr>				
			<%			
			t = 1;				
			while ( rset.next() )
			{				
				if ( t % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;				
				String appt_no=rset.getString("appt_ref_no") == null ?"" : rset.getString("appt_ref_no");
				String appt_date_from=rset.getString("appt_date_from") == null ?"" : rset.getString("appt_date_from");
				String appt_time_from=rset.getString("appt_time_from") == null ?"" : rset.getString("appt_time_from");
				String reschedule_date=rset.getString("reschedule_date") == null ?"" : rset.getString("reschedule_date");
				String reason_tranfer=rset.getString("reason_tranfer") == null ?"" : rset.getString("reason_tranfer");
				String speciality_from=rset.getString("speciality_from") == null ?"" : rset.getString("speciality_from");
				String practitioner_from=rset.getString("practitioner_from") == null ?"" : rset.getString("practitioner_from");
				
				String appt_date_to=rset.getString("appt_date_to") == null ?"" : rset.getString("appt_date_to");
				String appt_time_to=rset.getString("appt_time_to") == null ?"" : rset.getString("appt_time_to");				
				String speciality_to=rset.getString("speciality_to") == null ?"" : rset.getString("speciality_to");				
				String practitioner_to=rset.getString("practitioner_to") == null ?"" : rset.getString("practitioner_to");
				String modified_by=rset.getString("modified_by") == null ?"" : rset.getString("modified_by");				
			%>
				<tr>
				<td nowrap>&nbsp;<%=appt_no%></td>
				<td nowrap>&nbsp;<%=appt_date_from%></td>
				<td nowrap>&nbsp;<%=appt_time_from%></td>
				<td nowrap>&nbsp;<%=reschedule_date%></td>
				<td nowrap>&nbsp;<%=reason_tranfer%></td>
				<td nowrap>&nbsp;<%=speciality_from%></td>
				<td nowrap>&nbsp;<%=practitioner_from%></td>
				<td nowrap>&nbsp;<%=appt_date_to%></td>
				<td nowrap>&nbsp;<%=appt_time_to%></td>
				<td nowrap>&nbsp;<%=speciality_to%></td>
				<td nowrap>&nbsp;<%=practitioner_to%></td>
				<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->				
				<td nowrap>&nbsp;<%=modified_by%></td>				
				</tr>
	<%t++;
		}%>
	</table>	
<%}else if(display.equals("Cancel")){
		if(rset != null)rset.close();	
		// Below Changes done for RUT-CRF-0005.1 by Sudhakar
		sql="select appt_ref_no,to_char(appt_date,'dd/mm/yyyy')appt_date,to_char(appt_slab_from_time,'hh24:mi') || '-' || to_char(appt_slab_to_time,'hh24:mi') appt_time,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')speciality,AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2')practitioner,AM_GET_DESC.AM_CONTACT_REASON(REASON_FOR_CANCEL,'"+locale+"','1')reason_cancel,sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"',1)modified_by from OA_APPT_DEL_TR where facility_id='"+fac_id+"' "+and_cond+" and appt_status='C' and appt_date between trunc(sysdate) - "+per_chk_cancld_past_appts+" and trunc(sysdate) + "+per_chk_cancld_fut_appts ;			
		ps = con.prepareStatement(sql);
		//System.out.println("sql Cancel:"+sql);
		if (patient_id.equals("")){
			int psCount=1;			
			if (!name_prefix.equals("")){
				ps.setString(psCount++,name_prefix);
			}
			if (!first_name.equals("")){
				ps.setString(psCount++,first_name);
			}
			if (!second_name.equals("")){
				ps.setString(psCount++,second_name);
			}
			if (!third_name.equals("")){				
				ps.setString(psCount++,third_name);					
			}
			if (!family_name.equals("")){					
				ps.setString(psCount++,family_name);										
			}
			if (!name_suffix.equals("")){					
				ps.setString(psCount++,name_suffix);					
			}			
			
			if (!name_prefix_oth_lang.equals("")){
				ps.setString(psCount++,name_prefix_oth_lang);
			}
			if (!first_name_oth_lang.equals("")){
				ps.setString(psCount++,first_name_oth_lang);
			}
			if (!second_name_oth_lang.equals("")){
				ps.setString(psCount++,second_name_oth_lang);
			}
			if (!third_name_oth_lang.equals("")){				
				ps.setString(psCount++,third_name_oth_lang);					
			}
			if (!family_name_oth_lang.equals("")){					
				ps.setString(psCount++,family_name_oth_lang);										
			}
			if (!name_suffix_oth_lang.equals("")){					
				ps.setString(psCount++,name_suffix_oth_lang);					
			}
			if (!gender.equals("")){					
				ps.setString(psCount++,gender);											
			}
			if(!contact_no.equals("")){			
				ps.setString(psCount++,contact_no);				
			}
			if(!nationality.equals("")){				
				ps.setString(psCount++,nationality);					
			}
		}
		rset=ps.executeQuery();
%>	
	<table  border='1' cellpadding='0' cellspacing='0' width='100%' >
	<tr>
		<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->
	<td class='CAHIGHERLEVELCOLOR' align = 'left' colspan='7'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Appointments.label" bundle="${common_labels}"/></td>
	</tr>	
	<tr>
			
			<td class='CAGROUP' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>		
			<td class='CAGROUP' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>			
			<td class='CAGROUP' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.practitioner.label" bundle="${mp_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.ReasonforCancellation.label" bundle="${mp_labels}"/></td>
			<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->
			<td class='CAGROUP' nowrap><fmt:message key="Common.LastModifiedBy.label" bundle="${mp_labels}"/></td>
     </tr>
<%
			t = 1;				
			while ( rset.next() )
			{
				if ( t % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				String appt_no=rset.getString("appt_ref_no") == null ?"" : rset.getString("appt_ref_no");
				String appt_date=rset.getString("appt_date") == null ?"" : rset.getString("appt_date");
				String appt_time=rset.getString("appt_time") == null ?"" : rset.getString("appt_time");
				String speciality=rset.getString("speciality") == null ?"" : rset.getString("speciality");
				String practitioner=rset.getString("practitioner") == null ?"" : rset.getString("practitioner");		
				String reason_cancel=rset.getString("reason_cancel") == null ?"" : rset.getString("reason_cancel");	
				String modified_by=rset.getString("modified_by") == null ?"" : rset.getString("modified_by");				
%>
			<tr>
			
				<td nowrap>&nbsp;<%=appt_no%></td>				
				<td nowrap>&nbsp;<%=appt_date%></td>
				<td nowrap>&nbsp;<%=appt_time%></td>
				<td nowrap>&nbsp;<%=speciality%></td>
				<td nowrap>&nbsp;<%=practitioner%></td>
				<td nowrap>&nbsp;<%=reason_cancel%></td>
				<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->
				<td nowrap>&nbsp;<%=modified_by%></td>
			</tr>
<%t++;
		}%>
	</table>		
<%}else if(display.equals("Noshow")){
		if(rset != null)rset.close();
		//Below Changes done for RUT-CRF-0005.1 by Sudhakar
		sql="select appt_ref_no,to_char(appt_date,'dd/mm/yyyy')appt_date,to_char(appt_slab_from_time,'hh24:mi') || '-' || to_char(appt_slab_to_time,'hh24:mi')appt_time,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')speciality,AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2')practitioner,sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"',1)modified_by from OA_APPT where facility_id='"+fac_id+"' "+and_cond+" AND TO_DATE (TO_CHAR (appt_date, 'dd/mm/yyyy')|| ' '|| TO_CHAR (appt_time, 'HH24:mi'),'dd/mm/yyyy HH24:mi') < SYSDATE and appt_status != 'A' and appt_date between trunc(sysdate) - "+per_chk_for_no_show_alert+" and trunc(sysdate)";		
		ps = con.prepareStatement(sql);
		//System.out.println("sql Noshow:"+sql);
		if (patient_id.equals("")){
			int psCount=1;			
			if (!name_prefix.equals("")){
				ps.setString(psCount++,name_prefix);
			}
			if (!first_name.equals("")){
				ps.setString(psCount++,first_name);
			}
			if (!second_name.equals("")){
				ps.setString(psCount++,second_name);
			}
			if (!third_name.equals("")){				
				ps.setString(psCount++,third_name);					
			}
			if (!family_name.equals("")){					
				ps.setString(psCount++,family_name);										
			}
			if (!name_suffix.equals("")){					
				ps.setString(psCount++,name_suffix);					
			}			
			
			if (!name_prefix_oth_lang.equals("")){
				ps.setString(psCount++,name_prefix_oth_lang);
			}
			if (!first_name_oth_lang.equals("")){
				ps.setString(psCount++,first_name_oth_lang);
			}
			if (!second_name_oth_lang.equals("")){
				ps.setString(psCount++,second_name_oth_lang);
			}
			if (!third_name_oth_lang.equals("")){				
				ps.setString(psCount++,third_name_oth_lang);					
			}
			if (!family_name_oth_lang.equals("")){					
				ps.setString(psCount++,family_name_oth_lang);										
			}
			if (!name_suffix_oth_lang.equals("")){					
				ps.setString(psCount++,name_suffix_oth_lang);					
			}
			if (!gender.equals("")){					
				ps.setString(psCount++,gender);											
			}
			if(!contact_no.equals("")){			
				ps.setString(psCount++,contact_no);				
			}
			if(!nationality.equals("")){				
				ps.setString(psCount++,nationality);					
			}
		}		
		rset=ps.executeQuery();	
		%>	
	<table  border='1' cellpadding='0' cellspacing='0' width='100%' >
	<tr>
	<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->
	<td class='CAHIGHERLEVELCOLOR' align = 'left' colspan='6'><fmt:message key="Common.noshow.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Appointments.label" bundle="${common_labels}"/></td>
	</tr>	
	<tr>
	<td class='CAGROUP' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>			
			<td class='CAGROUP' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.practitioner.label" bundle="${mp_labels}"/></td>
			<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->
			<td class='CAGROUP' nowrap><fmt:message key="Common.LastModifiedBy.label" bundle="${mp_labels}"/></td>
     </tr>
	 <%
			t = 1;	
			while ( rset.next() )
			{
				if ( t % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				String appt_no=rset.getString("appt_ref_no") == null ?"" : rset.getString("appt_ref_no");
				String appt_date=rset.getString("appt_date") == null ?"" : rset.getString("appt_date");
				String appt_time=rset.getString("appt_time") == null ?"" : rset.getString("appt_time");
				String speciality=rset.getString("speciality") == null ?"" : rset.getString("speciality");
				String practitioner=rset.getString("practitioner") == null ?"" : rset.getString("practitioner");				
				String modified_by=rset.getString("modified_by") == null ?"" : rset.getString("modified_by");
%>
			<tr>
				<td nowrap>&nbsp;<%=appt_no%></td>
				<td nowrap>&nbsp;<%=appt_date%></td>
				<td nowrap>&nbsp;<%=appt_time%></td>
				<td nowrap>&nbsp;<%=speciality%></td>
				<td nowrap>&nbsp;<%=practitioner%></td>
				<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->
				<td nowrap>&nbsp;<%=modified_by%></td>
			</tr>
<%t++;
	}%>
	</table>
<%}else if(display.equals("Future")){
		if(rset != null)rset.close();
		//Commented by Selvin M for RUT-SCF-0208 (36344) as on 26/11/2012
		/*sql="select appt_ref_no,to_char(appt_date,'dd/mm/yyyy')appt_date,to_char(appt_slab_from_time,'hh24:mi') || '-' || to_char(appt_slab_to_time,'hh24:mi')appt_time,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')speciality,AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2')practitioner from OA_APPT where facility_id='"+fac_id+"' "+and_cond+"  and appt_status = '1' and TO_DATE (   TO_CHAR (appt_date, 'dd/mm/yyyy')|| ' ' || TO_CHAR (appt_time, 'HH24:mi'),'dd/mm/yyyy HH24:mi') > SYSDATE";	*/
		//Modified by Selvin M for RUT-SCF-0208 (36344) as on 26/11/2012
		//Below Changes done for RUT-CRF-0005.1 by Sudhakar
		sql="select appt_ref_no,to_char(appt_date,'dd/mm/yyyy')appt_date,to_char(appt_slab_from_time,'hh24:mi') || '-' || to_char(appt_slab_to_time,'hh24:mi')appt_time,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')speciality,AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2')practitioner,sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"',1)modified_by from OA_APPT where facility_id='"+fac_id+"' "+and_cond+"  and appt_status = '1' and TO_DATE (   TO_CHAR (appt_date, 'dd/mm/yyyy')|| ' ' || TO_CHAR (appt_time, 'HH24:mi'),'dd/mm/yyyy HH24:mi') > SYSDATE and appt_date between trunc(sysdate) and trunc(sysdate)+ "+per_chk_for_fut_appts_alert+" "; 
		ps = con.prepareStatement(sql);
		//System.out.println("sql Future:"+sql);
		if (patient_id.equals("")){
			int psCount=1;			
			if (!name_prefix.equals("")){
				ps.setString(psCount++,name_prefix);
			}
			if (!first_name.equals("")){
				ps.setString(psCount++,first_name);
			}
			if (!second_name.equals("")){
				ps.setString(psCount++,second_name);
			}
			if (!third_name.equals("")){				
				ps.setString(psCount++,third_name);					
			}
			if (!family_name.equals("")){					
				ps.setString(psCount++,family_name);										
			}
			if (!name_suffix.equals("")){					
				ps.setString(psCount++,name_suffix);					
			}			
			
			if (!name_prefix_oth_lang.equals("")){
				ps.setString(psCount++,name_prefix_oth_lang);
			}
			if (!first_name_oth_lang.equals("")){
				ps.setString(psCount++,first_name_oth_lang);
			}
			if (!second_name_oth_lang.equals("")){
				ps.setString(psCount++,second_name_oth_lang);
			}
			if (!third_name_oth_lang.equals("")){				
				ps.setString(psCount++,third_name_oth_lang);					
			}
			if (!family_name_oth_lang.equals("")){					
				ps.setString(psCount++,family_name_oth_lang);										
			}
			if (!name_suffix_oth_lang.equals("")){					
				ps.setString(psCount++,name_suffix_oth_lang);					
			}
			if (!gender.equals("")){					
				ps.setString(psCount++,gender);											
			}
			if(!contact_no.equals("")){			
				ps.setString(psCount++,contact_no);				
			}
			if(!nationality.equals("")){				
				ps.setString(psCount++,nationality);					
			}
		}
		rset=ps.executeQuery();

	%>	
	<table  border='1' cellpadding='0' cellspacing='0' width='100%' >
	<tr>
	<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->
	<td class='CAHIGHERLEVELCOLOR' align = 'left' colspan='6'><fmt:message key="Common.Future.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Appointments.label" bundle="${common_labels}"/></td>
	</tr>	
	<tr>
			<td class='CAGROUP' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>			
			<td class='CAGROUP' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.practitioner.label" bundle="${mp_labels}"/></td>
			<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->
			<td class='CAGROUP' nowrap><fmt:message key="Common.LastModifiedBy.label" bundle="${mp_labels}"/></td>
     </tr>
	 <%
			t = 1;	
			while ( rset.next() )
			{		
				if ( t % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				String appt_no=rset.getString("appt_ref_no") == null ?"" : rset.getString("appt_ref_no");
				String appt_date=rset.getString("appt_date") == null ?"" : rset.getString("appt_date");
				String appt_time=rset.getString("appt_time") == null ?"" : rset.getString("appt_time");
				String speciality=rset.getString("speciality") == null ?"" : rset.getString("speciality");
				String practitioner=rset.getString("practitioner") == null ?"" : rset.getString("practitioner");				
				String modified_by=rset.getString("modified_by") == null ?"" : rset.getString("modified_by");				
	%>
			<tr>
				<td nowrap>&nbsp;<%=appt_no%></td>
				<td nowrap>&nbsp;<%=appt_date%></td>
				<td nowrap>&nbsp;<%=appt_time%></td>
				<td nowrap>&nbsp;<%=speciality%></td>
				<td nowrap>&nbsp;<%=practitioner%></td>
				<!--Below Changes done for RUT-CRF-0005.1 by Sudhakar-->
				<td nowrap>&nbsp;<%=modified_by%></td>
			</tr>
<%t++;
	}%>		
	 </table>	
<%}	
	if(rset != null)rset.close();
	}catch(Exception e){
			//out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
 %>
  </html>

