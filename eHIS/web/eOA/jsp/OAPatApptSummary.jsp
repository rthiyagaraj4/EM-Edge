<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");		
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");	
		String name_prefix=java.net.URLDecoder.decode((request.getParameter("name_prefix")==null?"":request.getParameter("name_prefix")).trim());
		String first_name=java.net.URLDecoder.decode((request.getParameter("first_name")==null?"":request.getParameter("first_name")).trim());	
		String second_name=java.net.URLDecoder.decode((request.getParameter("second_name")==null?"":request.getParameter("second_name").trim()));
		String third_name=java.net.URLDecoder.decode((request.getParameter("third_name")==null?"":request.getParameter("third_name")).trim());
		String family_name=java.net.URLDecoder.decode((request.getParameter("family_name")==null?"":request.getParameter("family_name")).trim());
		String name_suffix=java.net.URLDecoder.decode((request.getParameter("name_suffix")==null?"":request.getParameter("name_suffix")).trim());
		String name_prefix_oth_lang=java.net.URLDecoder.decode((request.getParameter("name_prefix_oth_lang")==null?"":request.getParameter("name_prefix_oth_lang")).trim());
		String first_name_oth_lang=java.net.URLDecoder.decode((request.getParameter("first_name_oth_lang")==null?"":request.getParameter("first_name_oth_lang")).trim());	
		String second_name_oth_lang=java.net.URLDecoder.decode((request.getParameter("second_name_oth_lang")==null?"":request.getParameter("second_name_oth_lang")).trim());
		String third_name_oth_lang=java.net.URLDecoder.decode((request.getParameter("third_name_oth_lang")==null?"":request.getParameter("third_name_oth_lang")).trim());
		String family_name_oth_lang=java.net.URLDecoder.decode((request.getParameter("family_name_oth_lang")==null?"":request.getParameter("family_name_oth_lang")).trim());
		String name_suffix_oth_lang=java.net.URLDecoder.decode((request.getParameter("name_suffix_oth_lang")==null?"":request.getParameter("name_suffix_oth_lang")).trim());
		String patient_name=request.getParameter("patient_name")==null?"":request.getParameter("patient_name");
		String gender=request.getParameter("gender")==null?"":request.getParameter("gender");
		String contact_no=request.getParameter("contact_no")==null?"":request.getParameter("contact_no");
		String nationality=request.getParameter("nationality")==null?"":request.getParameter("nationality");
		//String language=request.getParameter("language")==null?"":request.getParameter("language");
		//String locale=(String)session.getAttribute("LOCALE");
		String fac_id=(String) session.getValue( "facility_id");
		String sql="";
		String classValue = "";
		String noshow_cnt="";
		String future_cnt="";
		String reschedule_cnt="";
		String cancel_cnt="";
		StringBuffer and_cond=new StringBuffer();
		int resultCount =0;
		
		int no_of_fut_appts_for_alert=Integer.parseInt(request.getParameter("no_of_fut_appts_for_alert")==null?"0":request.getParameter("no_of_fut_appts_for_alert"));
		int per_chk_for_fut_appts_alert=Integer.parseInt(request.getParameter("per_chk_for_fut_appts_alert")==null?"0":request.getParameter("per_chk_for_fut_appts_alert"));
		int no_of_resch_appts_for_alert=Integer.parseInt(request.getParameter("no_of_resch_appts_for_alert")==null?"0":request.getParameter("no_of_resch_appts_for_alert"));
		int per_chk_past_resch_appts=Integer.parseInt(request.getParameter("per_chk_past_resch_appts")==null?"0":request.getParameter("per_chk_past_resch_appts"));
		int per_chk_fut_resch_appts=Integer.parseInt(request.getParameter("per_chk_fut_resch_appts")==null?"0":request.getParameter("per_chk_fut_resch_appts"));
		int no_of_cancld_appts_for_alert=Integer.parseInt(request.getParameter("no_of_cancld_appts_for_alert")==null?"0":request.getParameter("no_of_cancld_appts_for_alert"));
		int per_chk_cancld_past_appts=Integer.parseInt(request.getParameter("per_chk_cancld_past_appts")==null?"0":request.getParameter("per_chk_cancld_past_appts"));
			
		
		int per_chk_cancld_fut_appts=Integer.parseInt(request.getParameter("per_chk_cancld_fut_appts")==null?"0":request.getParameter("per_chk_cancld_fut_appts"));		
		int no_of_noshow_appts_for_alert=Integer.parseInt(request.getParameter("no_of_noshow_appts_for_alert")==null?"0":request.getParameter("no_of_noshow_appts_for_alert"));
		int per_chk_for_no_show_alert=Integer.parseInt(request.getParameter("per_chk_for_no_show_alert")==null?"0":request.getParameter("per_chk_for_no_show_alert"));
		
		
		

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
								and_cond.append(" and name_suffix =?");					
					}
					if (!name_prefix_oth_lang.equals("")){					
								and_cond.append(" and name_prefix_loc_lang =?");					
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
								and_cond.append(" and name_suffix =?");					
					}
					
					if(!gender.equals("")){
								and_cond.append(" and gender='"+gender+"'");	
					}
					if(!contact_no.equals("")){
								and_cond.append(" and oth_contact_no='"+contact_no+"'");	
					}
					if(!nationality.equals("")){			
								and_cond.append(" and country_code='"+nationality+"'");					
					}
			}
			else
				and_cond.append(" and patient_id='"+patient_id+"'");	



			//sql="select (select count(*) from oa_appt where facility_id='"+fac_id+"' "+and_cond+" AND APPT_STATUS='1' AND to_date(to_char(APPT_DATE,'dd/mm/yyyy') || ' ' || to_char(APPT_TIME,'HH24:mi'),'dd/mm/yyyy HH24:mi') < sysdate		AND APPT_DATE BETWEEN TRUNC(SYSDATE-"+per_chk_for_no_show_alert+") AND TRUNC(SYSDATE))noshow_cnt,(select count(*) from oa_appt where facility_id='"+fac_id+"' "+and_cond+" and appt_date between trunc(sysdate) and trunc(sysdate)+"+per_chk_for_fut_appts_alert+" and appt_status = '1')future_cnt,(select count(*) from oa_appt_del_tr where facility_id='"+fac_id+"' "+and_cond+" and appt_status='N' and bulk_transfer_yn!='Y' and appt_date between trunc(sysdate) - "+per_chk_past_resch_appts+" and trunc(sysdate) + "+per_chk_fut_resch_appts+" )reschedule_cnt,(select count(*) from OA_APPT_DEL_TR where facility_id='"+fac_id+"' "+and_cond+" and appt_status='C' and appt_date between trunc(sysdate) - "+per_chk_cancld_past_appts+" and trunc(sysdate) + "+per_chk_cancld_fut_appts+" )cancel_cnt from dual";	
			sql="select (select count(*) from oa_appt where facility_id='"+fac_id+"' "+and_cond+" AND APPT_STATUS='1' AND to_date(to_char(APPT_DATE,'dd/mm/yyyy') || ' ' || to_char(APPT_TIME,'HH24:mi'),'dd/mm/yyyy HH24:mi') < sysdate		AND APPT_DATE BETWEEN TRUNC(SYSDATE-"+per_chk_for_no_show_alert+") AND TRUNC(SYSDATE))noshow_cnt,(select count(*) from oa_appt where facility_id='"+fac_id+"' "+and_cond+" AND to_date(to_char(APPT_DATE,'dd/mm/yyyy') || ' ' || to_char(APPT_TIME,'HH24:mi'),'dd/mm/yyyy HH24:mi') > sysdate  AND APPT_DATE BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE+"+per_chk_for_fut_appts_alert+") and appt_status = '1')future_cnt,(select count(*) from oa_appt_del_tr where facility_id='"+fac_id+"' "+and_cond+" and appt_status='N' and bulk_transfer_yn!='Y' and appt_date between trunc(sysdate) - "+per_chk_past_resch_appts+" and trunc(sysdate) + "+per_chk_fut_resch_appts+" )reschedule_cnt,(select count(*) from OA_APPT_DEL_TR where facility_id='"+fac_id+"' "+and_cond+" and appt_status='C' and appt_date between trunc(sysdate) - "+per_chk_cancld_past_appts+" and trunc(sysdate) + "+per_chk_cancld_fut_appts+" )cancel_cnt from dual";	
			//System.out.println("OAPatApptSummary.jsp sql :"+sql);
			ps = con.prepareStatement(sql);
			int psCount=1;
			if (patient_id.equals("")){
				// no Show appts
				if(!name_prefix.equals("")){
					ps.setString(psCount++,name_prefix);
				}
				if(!first_name.equals("")){
					ps.setString(psCount++,first_name);
				}
				if(!second_name.equals("")){
					ps.setString(psCount++,second_name);
				}
				if(!third_name.equals("")){
					ps.setString(psCount++,third_name);
				}
				if(!family_name.equals("")){
					ps.setString(psCount++,family_name);
				}
				if(!name_suffix.equals("")){
					ps.setString(psCount++,name_suffix);
				}
				
				if(!name_prefix_oth_lang.equals("")){
					ps.setString(psCount++,name_prefix_oth_lang);
				}
				if(!first_name_oth_lang.equals("")){
					ps.setString(psCount++,first_name_oth_lang);
				}
				if(!second_name_oth_lang.equals("")){
					ps.setString(psCount++,second_name_oth_lang);
				}
				if(!third_name_oth_lang.equals("")){
					ps.setString(psCount++,third_name_oth_lang);
				}
				if(!family_name_oth_lang.equals("")){
					ps.setString(psCount++,family_name_oth_lang);
				}
				if(!name_suffix_oth_lang.equals("")){
					ps.setString(psCount++,name_suffix_oth_lang);
				}
				
				// future appts
				if(!name_prefix.equals("")){
					ps.setString(psCount++,name_prefix);
				}
				if(!first_name.equals("")){
					ps.setString(psCount++,first_name);
				}
				if(!second_name.equals("")){
					ps.setString(psCount++,second_name);
				}
				if(!third_name.equals("")){
					ps.setString(psCount++,third_name);
				}
				if(!family_name.equals("")){
					ps.setString(psCount++,family_name);
				}
				if(!name_suffix.equals("")){
					ps.setString(psCount++,name_suffix);
				}
				
				if(!name_prefix_oth_lang.equals("")){
					ps.setString(psCount++,name_prefix_oth_lang);
				}
				if(!first_name_oth_lang.equals("")){
					ps.setString(psCount++,first_name_oth_lang);
				}
				if(!second_name_oth_lang.equals("")){
					ps.setString(psCount++,second_name_oth_lang);
				}
				if(!third_name_oth_lang.equals("")){
					ps.setString(psCount++,third_name_oth_lang);
				}
				if(!family_name_oth_lang.equals("")){
					ps.setString(psCount++,family_name_oth_lang);
				}
				if(!name_suffix_oth_lang.equals("")){
					ps.setString(psCount++,name_suffix_oth_lang);
				}
				
				//reschedule appts
				if(!name_prefix.equals("")){
					ps.setString(psCount++,name_prefix);
				}
				if(!first_name.equals("")){
					ps.setString(psCount++,first_name);
				}
				if(!second_name.equals("")){
					ps.setString(psCount++,second_name);
				}
				if(!third_name.equals("")){
					ps.setString(psCount++,third_name);
				}
				if(!family_name.equals("")){
					ps.setString(psCount++,family_name);
				}
				if(!name_suffix.equals("")){
					ps.setString(psCount++,name_suffix);
				}
				
				if(!name_prefix_oth_lang.equals("")){
					ps.setString(psCount++,name_prefix_oth_lang);
				}
				if(!first_name_oth_lang.equals("")){
					ps.setString(psCount++,first_name_oth_lang);
				}
				if(!second_name_oth_lang.equals("")){
					ps.setString(psCount++,second_name_oth_lang);
				}
				if(!third_name_oth_lang.equals("")){
					ps.setString(psCount++,third_name_oth_lang);
				}
				if(!family_name_oth_lang.equals("")){
					ps.setString(psCount++,family_name_oth_lang);
				}
				if(!name_suffix_oth_lang.equals("")){
					ps.setString(psCount++,name_suffix_oth_lang);
				}
				
				//cancelled appts
				if(!name_prefix.equals("")){
					ps.setString(psCount++,name_prefix);
				}
				if(!first_name.equals("")){
					ps.setString(psCount++,first_name);
				}
				if(!second_name.equals("")){
					ps.setString(psCount++,second_name);
				}
				if(!third_name.equals("")){
					ps.setString(psCount++,third_name);
				}
				if(!family_name.equals("")){
					ps.setString(psCount++,family_name);
				}
				if(!name_suffix.equals("")){
					ps.setString(psCount++,name_suffix);
				}
				
				if(!name_prefix_oth_lang.equals("")){
					ps.setString(psCount++,name_prefix_oth_lang);
				}
				if(!first_name_oth_lang.equals("")){
					ps.setString(psCount++,first_name_oth_lang);
				}
				if(!second_name_oth_lang.equals("")){
					ps.setString(psCount++,second_name_oth_lang);
				}
				if(!third_name_oth_lang.equals("")){
					ps.setString(psCount++,third_name_oth_lang);
				}
				if(!family_name_oth_lang.equals("")){
					ps.setString(psCount++,family_name_oth_lang);
				}
				if(!name_suffix_oth_lang.equals("")){
					ps.setString(psCount++,name_suffix_oth_lang);
				}
			}
			rset=ps.executeQuery();
			if( rset.next() )
			{
				resultCount++;
				noshow_cnt=rset.getString("noshow_cnt") == null ?"0" : rset.getString("noshow_cnt");
				future_cnt=rset.getString("future_cnt") == null ?"0" : rset.getString("future_cnt");
				reschedule_cnt=rset.getString("reschedule_cnt") == null ?"0" : rset.getString("reschedule_cnt");
				cancel_cnt=rset.getString("cancel_cnt") == null ?"0" : rset.getString("cancel_cnt");
			}
			//System.out.println("future_cnt 1:"+future_cnt);
			/*if(rset != null)rset.close();
			sql="select (select count(*) from oa_appt_del_tr where facility_id='"+fac_id+"' "+and_cond+" and appt_status='N' and bulk_transfer_yn!='Y' and appt_date between trunc(sysdate) - "+per_chk_past_resch_appts+" and trunc(sysdate) + "+per_chk_fut_resch_appts+" )reschedule_cnt,(select count(*) from OA_APPT_DEL_TR where facility_id='"+fac_id+"' "+and_cond+" and appt_status='C' and appt_date between trunc(sysdate) - "+per_chk_cancld_past_appts+" and trunc(sysdate) + "+per_chk_cancld_fut_appts+" )cancel_cnt from dual";		
			//System.out.println("sql 2:"+sql);
			ps = con.prepareStatement(sql);
			rset=ps.executeQuery();
			if( rset.next() )
			{
				reschedule_cnt=rset.getString("reschedule_cnt") == null ?"0" : rset.getString("reschedule_cnt");
				cancel_cnt=rset.getString("cancel_cnt") == null ?"0" : rset.getString("cancel_cnt");
			}*/	

			/*if((no_of_cancld_appts_for_alert==0 || no_of_cancld_appts_for_alert >= Integer.parseInt(cancel_cnt))){
				cancel_cnt="0";
			}
			if((no_of_resch_appts_for_alert==0 || no_of_resch_appts_for_alert >= Integer.parseInt(reschedule_cnt))){
				reschedule_cnt="0";
			}
			
			if((no_of_fut_appts_for_alert==0 || no_of_fut_appts_for_alert >= Integer.parseInt(future_cnt))){
				future_cnt="0";
			}*/
			if(no_of_noshow_appts_for_alert >  Integer.parseInt(noshow_cnt)){
				noshow_cnt="0";
			}
		  /*Below Line Added and Above Line Commented for	this SCF RUT-SCF-0200 [IN:035936]*/
		    if(Integer.parseInt(cancel_cnt)<=no_of_cancld_appts_for_alert ){
				cancel_cnt="0";
			} 
			if(Integer.parseInt(reschedule_cnt)<=no_of_resch_appts_for_alert){
				reschedule_cnt="0";
			} 		
			if(Integer.parseInt(future_cnt) <=no_of_fut_appts_for_alert){
				future_cnt="0";
			} 
           		
			//RUT-SCF-0200 [IN:035936]
			%>
			<form name='OAPatApptSummary' id='OAPatApptSummary'>
			<table  border='1' cellpadding='0' cellspacing='0' width='100%' >
			<br>
			<tr>
			<td class='CAHIGHERLEVELCOLOR' align = 'center' colspan='5'><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
			<%
			if(!patient_id.equals("")){%>
			<td class='CAGROUP' nowrap align='center'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>	
			<%}else{%>
			<td class='CAGROUP' nowrap align='center'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>	
			<%}%>
			<td class='CAGROUP' nowrap align='center'><fmt:message key="Common.noshow.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Appointments.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap align='center'><fmt:message key="Common.Reschedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Appointments.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap align='center'><fmt:message key="Common.Future.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Appointments.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap align='center'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Appointments.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
			<%
			if(!patient_id.equals("")){%>
			<td class='<%=classValue%>' nowrap><p align='center'><%=patient_id%></p></td>		
			<%}else{%>
			<td class='<%=classValue%>' nowrap><p align='center'><%=patient_name%></p></td>		
			<%}%>
			<td class='<%=classValue%>' nowrap><p align='center'><%=noshow_cnt%>&nbsp;&nbsp;<%if(Integer.parseInt(noshow_cnt)>0){%><input type='button' value='+' onclick='ShowHistory("Noshow","<%=patient_id%>","<%=first_name%>","<%=second_name%>","<%=third_name%>","<%=family_name%>","<%=gender%>","<%=contact_no%>")'><%}%></p></td>
			<td class='<%=classValue%>' nowrap><p align='center'><%=reschedule_cnt%>&nbsp;&nbsp;<%if(Integer.parseInt(reschedule_cnt)>0){%><input type='button' value='+' onclick='ShowHistory("Reschedule","<%=patient_id%>","<%=first_name%>","<%=second_name%>","<%=third_name%>","<%=family_name%>","<%=gender%>","<%=contact_no%>")'><%}%></p></td>
			<td class='<%=classValue%>' nowrap><p align='center'><%=future_cnt%>&nbsp;&nbsp;<%if(Integer.parseInt(future_cnt)>0){%><input type='button' value='+' onclick='ShowHistory("Future","<%=patient_id%>","<%=first_name%>","<%=second_name%>","<%=third_name%>","<%=family_name%>","<%=gender%>","<%=contact_no%>")'><%}%></p></td>
			<td class='<%=classValue%>' nowrap><p align='center'><%=cancel_cnt%>&nbsp;&nbsp;<%if(Integer.parseInt(cancel_cnt)>0){%><input type='button' value='+' onclick='ShowHistory("Cancel","<%=patient_id%>","<%=first_name%>","<%=second_name%>","<%=third_name%>","<%=family_name%>","<%=gender%>","<%=contact_no%>")'><%}%></p></td>
			</tr>
			</table>
		<input type="hidden" name='name_prefix' id='name_prefix' value="<%=name_prefix%>">
		<input type="hidden" name='first_name' id='first_name' value="<%=first_name%>">
		<input type="hidden" name='second_name' id='second_name' value="<%=second_name%>">
		<input type="hidden" name='third_name' id='third_name' value="<%=third_name%>">
		<input type="hidden" name='family_name' id='family_name' value="<%=family_name%>">
		<input type="hidden" name='name_suffix' id='name_suffix' value="<%=name_suffix%>">
		<input type="hidden" name='name_prefix_oth_lang' id='name_prefix_oth_lang' value="<%=name_prefix_oth_lang%>">
		<input type="hidden" name='first_name_oth_lang' id='first_name_oth_lang' value="<%=first_name_oth_lang%>">
		<input type="hidden" name='second_name_oth_lang' id='second_name_oth_lang' value="<%=second_name_oth_lang%>">
		<input type="hidden" name='third_name_oth_lang' id='third_name_oth_lang' value="<%=third_name_oth_lang%>">
		<input type="hidden" name='family_name_oth_lang' id='family_name_oth_lang' value="<%=family_name_oth_lang%>">
		<input type="hidden" name='name_suffix_oth_lang' id='name_suffix_oth_lang' value="<%=name_suffix_oth_lang%>">
		<input type="hidden" name='no_of_fut_appts_for_alert' id='no_of_fut_appts_for_alert' value="<%=no_of_fut_appts_for_alert%>">
		<input type="hidden" name='per_chk_for_fut_appts_alert' id='per_chk_for_fut_appts_alert' value="<%=per_chk_for_fut_appts_alert%>">
		<input type="hidden" name='no_of_resch_appts_for_alert' id='no_of_resch_appts_for_alert' value="<%=no_of_resch_appts_for_alert%>">
		<input type="hidden" name='per_chk_past_resch_appts' id='per_chk_past_resch_appts' value="<%=per_chk_past_resch_appts%>">
		<input type="hidden" name='per_chk_fut_resch_appts' id='per_chk_fut_resch_appts' value="<%=per_chk_fut_resch_appts%>">
		<input type="hidden" name='no_of_cancld_appts_for_alert' id='no_of_cancld_appts_for_alert' value="<%=no_of_cancld_appts_for_alert%>">
		<input type="hidden" name='per_chk_cancld_past_appts' id='per_chk_cancld_past_appts' value="<%=per_chk_cancld_past_appts%>">
		<input type="hidden" name='per_chk_cancld_fut_appts' id='per_chk_cancld_fut_appts' value="<%=per_chk_cancld_fut_appts%>">
		<input type="hidden" name='no_of_noshow_appts_for_alert' id='no_of_noshow_appts_for_alert' value="<%=no_of_noshow_appts_for_alert%>">		
		<input type="hidden" name='per_chk_for_no_show_alert' id='per_chk_for_no_show_alert' value="<%=per_chk_for_no_show_alert%>">			
		</form>
		<%
			if(resultCount == 0){
				//out.println("<script>alert(getMessage('APPT_NOT_EXISTS_FOR_SEL_PAT','OA'));window.close();</script>");
			}	
          if(rset != null)rset.close();	
		  if(ps != null) ps.close();
		}catch(Exception e){
			//out.println(e.toString());
			e.printStackTrace();
		}finally{
			ConnectionManager.returnConnection(con,request);
		}
		%>
		</body>
		</html>
		

