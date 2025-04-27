<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript">
			function validateSlots(obj,rownum)
			{
				if (!(obj.readOnly)){
				if(obj.value == '') obj.value=0;

				if(CheckNum(obj))
				{
					var a = eval("document.getElementById('block_slot')"+rownum+".value");
					var arr = a.split("`");
					totalslots = arr[0];
					if(eval(obj.value)>totalslots)
					{
						var error = getMessage('BLOCK_SLOTS_ARE_MORE','OA');
						alert(error)
						obj.focus();
					}
				}
				}
			}
    function validateVisit(obj,max_value,total_booked,total_blocked)
	{
		
		if(parseInt(max_value)>0){
			
				if(parseInt(obj.value)>(parseInt(max_value)-(parseInt(total_booked)+parseInt(total_blocked)))){
				
				
				alert(getMessage("BLOCK_VISITS_ARE_MORE","OA"));
				if(obj.readOnly){
				}else{
					obj.focus();
				}

			}
		}
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		String facilityid = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String visit_limit_rule = request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule");
		String slot_appt_ctrl = request.getParameter("slot_appt_ctrl")==null?"":request.getParameter("slot_appt_ctrl");
		String locncode =request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String practitionerid = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
		String blockdate = request.getParameter("block_date")==null?"":request.getParameter("block_date");
		String alcncriteria = request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
		
		String sql="";
		String alcncriteriadesc = "";
		 String max_first_visits = "";
                            String total_first_visits = "";
							String max_other_visits = "";
							String total_other_visits = "";
							String total_slots_booked="";
							String max_patients_per_day= "";

							String total_first_visits_blocked ="" ;
							String total_other_visits_blocked ="";

		if(alcncriteria.equals("NG"))
		{
			alcncriteriadesc = "Nationaligy Group";
		}
		String slotsblocked = request.getParameter("slots_blocked")==null?"&nbsp;":request.getParameter("slots_blocked");
				//	out.println("1");


		Connection con = null ;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		//String className = "";
		int i =0;
		String readOnly = "";
		String pat_or_slot_flag =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels");
		if (slot_appt_ctrl.equals("S"))
			pat_or_slot_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Slot.label","common_labels");


			//out.println("two");
%>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="BlockApptAllocationDetails_form" id="BlockApptAllocationDetails_form">
	<table cellpadding=0 cellspacing=0 width="100%" border=1>
	<%if (slot_appt_ctrl.equals("S")){%>
		<tr>
			<td colspan=5 class=DATA>
				<b><fmt:message key="eOA.Slotstobeblocked.label" bundle="${oa_labels}"/> = <%=slotsblocked%></b>
				</td>
		</tr>
		<%}%>
		<input type="hidden" value="<%=slotsblocked%>" name=slots_blocked>
		<tr>
			
			<td class='COLUMNHEADER'><%=alcncriteriadesc%>&nbsp;</th>
			<td class='COLUMNHEADER'><fmt:message key="Common.Max.label" bundle="${common_labels}"/> <%=pat_or_slot_flag%></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.booked.label" bundle="${common_labels}"/> <%=pat_or_slot_flag%></td>
			<td class='COLUMNHEADER'><fmt:message key="eOA.SlotsBlocked.label" bundle="${oa_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="eOA.BlockSlots.label" bundle="${oa_labels}"/></td>
		</tr>
		<%
			
			try
			 {
				con= ConnectionManager.getConnection(request);
				stmt=con.createStatement();
				%>
               
				<%
					if(alcncriteria.equals("NG"))
					{
				//sql = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.stat_grp_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,am_stat_group b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+blockdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.stat_grp_id(+) ORDER BY 2 DESC";
				sql = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.stat_grp_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,am_stat_group b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.stat_grp_id(+) ORDER BY 2 DESC";
				
					}
					else if(alcncriteria.equals("BG"))
					{
					//sql = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,bl_blng_grp b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+blockdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.blng_grp_id(+) ORDER BY 2 DESC ";
					sql = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,bl_blng_grp b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.blng_grp_id(+) ORDER BY 2 DESC ";
						}
					else if(alcncriteria.equals("PC"))
					{
						//sql  = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots long_desc from oa_clinic_schedule_dtl a,mp_pat_category b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+blockdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.pat_cat_code(+) ORDER BY 2 DESC ";
						sql  = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots long_desc from oa_clinic_schedule_dtl a,mp_pat_category b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.pat_cat_code(+) ORDER BY 2 DESC ";
					}
					try
					 {
					  if((!alcncriteria.equals("")) ){
							//rs = stmt.executeQuery(sql);
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,facilityid);
							pstmt.setString(2,locncode);
							pstmt.setString(3,blockdate);
							pstmt.setString(4,practitionerid);
							rs = pstmt.executeQuery();
							if(rs !=null)
							{
								while(rs.next())
								{
									
									if(rs.getInt("final_slots") == 0 )
										readOnly = "readonly";
									else
										readOnly = "";

									String code = rs.getString("alcn_catg_code")==null?"":rs.getString("alcn_catg_code");
									String desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
									if(code.equals("*O")) desc = "Others";
									String passvalue = rs.getInt("final_slots")+"`"+alcncriteria+"`"+code+"`"+"$"+"`";%>
		

									<tr><td  class='QRYODD'><%=desc%></td>
									<td   class='QRYODD' align='center'><%=rs.getInt("max_patients")%></td>
									<td   class='QRYODD' align='center'><%=(rs.getInt("total_booked_patients")-rs.getInt("total_blocked_slots"))%></td>
									<td   class='QRYODD' align='center'><%=rs.getInt("total_blocked_slots")%></td>
									<td   class='QRYODD'><input type=hidden name=block_slot<%=i%> value='<%=passvalue%>' >
									<input type=text <%=readOnly%> name='block_slot_text<%=i%>' value=0  maxlength=3 size=3 style='text-align:right' onBlur='javascript:validateSlots(this,<%=i%>);' onKeyPress='return(ChkNumberInput(this,event,0));'></td>
		
								</tr>
							<%		i++;
						}
					}
				}
			 }
			 catch (Exception e){
					//out.println("EROOR"+e);
					 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
				}
				finally	{
					
				}
                out.println("<input type='hidden' value='"+i+"' name='total_count' id='total_count'>");
                out.println("<input type='hidden' value='"+slot_appt_ctrl+"' name='slot_appt_ctrl' id='slot_appt_ctrl'>");
			

				if ( visit_limit_rule.equals("E")||visit_limit_rule.equals("M")){



					//added by viswanath;;;
/*sql = "select max_first_visits,nvl(total_slots_booked,0) total_slots_booked ,nvl(max_patients_per_day,0) max_patients_per_day,nvl(total_first_visit,0) total_first_visits,max_other_visits,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits,nvl(total_first_visits_blocked,0) total_first_visit_blocked,nvl(total_other_visits_blocked,0) total_other_visits_blocked from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_code='"+locncode+"' and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date('"+blockdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl('"+practitionerid+"','|')";
						//Added by Kiruthiga on 07/11/2005
						if(rs!=null) rs.close();
						//End

					rs = stmt.executeQuery(sql);
					if(rs !=null){
					out.println("<th align = left colspan = 5>Visit Type</th>");
						while(rs.next()){

                           max_first_visits = rs.getString("max_first_visits");
							 total_slots_booked=rs.getString("total_slots_booked");
							 max_patients_per_day= rs.getString("max_patients_per_day");
                             total_first_visits = rs.getString("total_first_visits");
							max_other_visits = rs.getString("max_other_visits");
							total_other_visits = rs.getString("total_other_visits");
							if (max_first_visits==null) max_first_visits= "0";
							if (total_first_visits==null) total_first_visits= "0";
							if (max_other_visits==null) max_other_visits= "0";
							if (total_other_visits==null) total_other_visits= "0";
							 total_first_visits_blocked = rs.getString("total_first_visit_blocked");
							total_other_visits_blocked = rs.getString("total_other_visits_blocked");
							String first_read_only="";
							String other_read_only="";*/
					//ended by viswanath;;;;
				   
			//out.println("2");

						//sql = "select max_first_visits,nvl(total_slots_booked,0) total_slots_booked ,nvl(max_patients_per_day,0) max_patients_per_day,nvl(total_first_visit,0) total_first_visits,max_other_visits,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits,nvl(total_first_visits_blocked,0) total_first_visit_blocked,nvl(total_other_visits_blocked,0) total_other_visits_blocked from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_code='"+locncode+"' and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date('"+blockdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl('"+practitionerid+"','|')";
						sql = "select max_first_visits,nvl(total_slots_booked,0) total_slots_booked ,nvl(max_patients_per_day,0) max_patients_per_day,nvl(total_first_visit,0) total_first_visits,max_other_visits,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits,nvl(total_first_visits_blocked,0) total_first_visit_blocked,nvl(total_other_visits_blocked,0) total_other_visits_blocked from oa_clinic_schedule where facility_id=? and clinic_code=? and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl(?,'|')";
						

					//rs = stmt.executeQuery(sql);

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facilityid);
					pstmt.setString(2,locncode);
					pstmt.setString(3,blockdate);
					pstmt.setString(4,practitionerid);
					rs = pstmt.executeQuery();
					if(rs !=null)
					{

					%>
						
						<td class='COLUMNHEADER' colspan = 5><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
					<%
						while(rs.next())
						{

                            max_first_visits = rs.getString("max_first_visits");
                            total_first_visits = rs.getString("total_first_visits");
							 max_other_visits = rs.getString("max_other_visits");
							 total_other_visits = rs.getString("total_other_visits");
							 total_slots_booked=rs.getString("total_slots_booked");
							 max_patients_per_day= rs.getString("max_patients_per_day");
							if (max_first_visits==null) max_first_visits= "0";
							if (total_first_visits==null) total_first_visits= "0";
							if (max_other_visits==null) max_other_visits= "0";
							if (total_other_visits==null) total_other_visits= "0";
							if (total_slots_booked==null) total_slots_booked= "0";
							if (max_patients_per_day==null) max_patients_per_day= "0";
							 total_first_visits_blocked = rs.getString("total_first_visit_blocked");
							 total_other_visits_blocked = rs.getString("total_other_visits_blocked");
							String first_read_only="";
							String other_read_only="";
							if (Integer.parseInt(max_first_visits)>0){
								if (max_first_visits.equals(total_first_visits))
								 first_read_only = "readOnly";
							}
							if (Integer.parseInt(max_other_visits)>0){
								if (max_other_visits.equals(total_other_visits))
								  other_read_only = "readOnly";
							}

		//	out.println("5");

								%>
								<tr><td class=QRYODD><fmt:message key="Common.firstvisit.label" bundle="${common_labels}"/></td>
								<td  class=QRYODD align='center'><%=max_first_visits%></td>
								<td  class= QRYODD  align='center'><%=total_first_visits%>
								</td>
								<td  class=QRYODD align='center'><%=total_first_visits_blocked%></td>
								<td  class=QRYODD >
								<input type=text name='first_visit_text' id='first_visit_text' value=0  maxlength=3 size=3 style='text-align:right'<%=first_read_only%> onBlur='javascript:validateVisit(this,<%=max_first_visits%>,<%=total_first_visits%>,<%=total_first_visits_blocked%>);' onKeyPress='return(ChkNumberInput(this,event,0));'></td>
								</tr>
									<%
								%>
								<tr><td class=QRYEVEN><fmt:message key="Common.othervisit.label" bundle="${common_labels}"/></td>
								<td  class=QRYEVEN align='center'><%=max_other_visits%></td>
								<td  class=QRYEVEN align='center'><%=total_other_visits%>
								</td>
								<td  class=QRYEVEN align='center'><%=total_other_visits_blocked%></td>
								<td  class=QRYEVEN >
								<input type=text name='other_visit_text' id='other_visit_text' value=0  maxlength=3 size=3 style='text-align:right' <%=other_read_only%>  onBlur='javascript:validateVisit(this,<%=max_other_visits%>,<%=total_other_visits%>,<%=total_other_visits_blocked%>);' onKeyPress='return(ChkNumberInput(this,event,0));'></td>
								</tr>
									<%
						}
					}
				}
				if(stmt !=null) stmt.close();
				if(rs !=null) rs.close();
				}catch (Exception e){
					//out.println("EROOR@238"+e);
					e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
				}
				finally	{
					if(stmt !=null) stmt.close();
					if(rs !=null) rs.close();
					ConnectionManager.returnConnection(con,request);
				}
			
		%>
		<input type='hidden' name='total_slots_booked' id='total_slots_booked' value='<%=total_slots_booked%>'>
		<input type='hidden' name='max_patients_per_day' id='max_patients_per_day' value='<%=max_patients_per_day%>'>
		<input type='hidden' name='max_first_visits' id='max_first_visits' value='<%=max_first_visits%>'>
		<input type='hidden' name='max_other_visits' id='max_other_visits' value='<%=max_other_visits%>'>
		<input type='hidden' name='total_first_visits_blocked' id='total_first_visits_blocked' value='<%=total_first_visits%>'>
		<input type='hidden' name='total_other_visits_blocked' id='total_other_visits_blocked' value='<%=total_other_visits%>'>
			

	</table>
</form>
</body>
</html>

