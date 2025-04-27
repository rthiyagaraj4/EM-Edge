<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String facility_id			= (String) session.getValue( "facility_id" ) ;
	String locale               = (String)session.getAttribute("LOCALE"); 
	String userid           = (String) session.getValue("login_user");
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eOP/js/BatchProcess.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest();" onKeyDown ='lockKey()'>
<form name="assPracForAutoClose" id="assPracForAutoClose">
<%
	Connection con=null;
	Statement stmt;
	ResultSet rset;

	String classValue = "";
	String p_encounter_id = "";
	String p_queue_no = "";
	String p_patient_id = "";
	String p_regn_time = "";
	String p_status = "";
	String queue_status = "";
	String pat_curr_locn_type_desc="";
    String module_id=request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String  bl_interfaced_yn = (request.getParameter("bl_interfaced_yn")==null)?"N": request.getParameter("bl_interfaced_yn");

	String  bl_install_yn = (request.getParameter("bl_install_yn")==null)?"N": request.getParameter("bl_install_yn");
	
	String oth_res_class = "";		 
	String locn_type	 = "";			
	String locn_code	 = "";		
	String date_time	 = "";		
	String patient_details="";
    String queue_date="";
    String locn_desc ="";
	String prev_locn_code="";
	String oper_id="";
	String pract_id = "";
	String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;	
    String patient_class = "";	
	String episode_id = "";
	String visit_id = "";
	String  mds_mode="";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String allow_chkout_with_bill_stmt_yn = (request.getParameter("allow_chkout_with_bill_stmt_yn")==null)?"N": request.getParameter("allow_chkout_with_bill_stmt_yn");
 	

	if(module_id.equals("OP"))
		{	
        patient_class = "OP";		
		mds_mode="OC";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		}
	else if(module_id.equals("AE"))		
		{
        patient_class = "EM";
		mds_mode="EC";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		}

	
	try {
			int start = 0 ;
			int end = 0 ;
			int i=1;
			int endOfRes=1;
			int num=1;
    
			if ( from == null )
				start = 1 ;
			else
				start = Integer.parseInt( from ) ;

			if ( to == null )
				end = 10 ;
			else
				end = Integer.parseInt( to ) ;	
			
			

			con=ConnectionManager.getConnection(request);
			stmt=con.createStatement();	

			String sql_op = "Select AM_OPER_STN_ACCESS_CHECK('"+facility_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') FROM dual" ;
			rset=stmt.executeQuery(sql_op);
			rset.next();
			oper_id = rset.getString(1);

			if(stmt!=null)
				stmt.close();
			if(rset!=null)
				rset.close();
			

			stmt=con.createStatement();			
			String sql="select encounter_id, Practitioner_id ,queue_num, patient_id, TO_CHAR (queue_date, 'dd/mm/yyyy') queue_date, queue_status , TO_CHAR (queue_date, 'dd/mm/yyyy HH24:MI') regn_date_time , (CASE   WHEN INSTR(GET_PATIENT_LINE(PATIENT_ID,'"+locale+"'),'#')>0 THEN    SUBSTR(GET_PATIENT_LINE(PATIENT_ID,'"+locale+"'),1,INSTR(GET_PATIENT_LINE(PATIENT_ID,'"+locale+"'),'#')-1)END) patient_details ";  
			if(module_id.equals("OP"))
		    {
				sql=sql+",OTHER_RES_CLASS,";
			}else
			{
				sql=sql+",'' OTHER_RES_CLASS,";
			}
		
			sql=sql+ "  locn_type,am_get_desc.am_care_locn_type(locn_type,'"+locale+"', '1') pat_curr_locn_type_desc, locn_code,op_get_desc.OP_CLINIC(facility_id,locn_code,'"+locale+"',2)locn_desc, TO_CHAR (DECODE (queue_status,'01',check_in_date_time,'02', arrive_date_time,'03', vital_signs_date_time,'04', cons_srvc_start_date_time, '05', NULL,'06', subs_arrive_date_time),'dd/mm/yyyy hh24:mi') dt,episode_id,op_episode_visit_num from ";

			if(module_id.equals("OP"))
			{
				//sql=sql+" op_current_patient WHERE facility_id = '"+facility_id+"' AND queue_date < SYSDATE - (SELECT visit_compl_days FROM op_param WHERE operating_facility_id = '"+facility_id+"') AND queue_status < '07' ";
				sql=sql+" op_current_patient,op_param WHERE facility_id = '"+facility_id+"' and operating_facility_id = facility_id   AND TRUNC(queue_date) < TRUNC((SYSDATE - visit_compl_days)) and queue_status < '07' ";
			}
			else
			{
				//sql=sql+" ae_current_patient WHERE facility_id = '"+facility_id+"' AND queue_date < SYSDATE - (SELECT visit_compl_days FROM op_param WHERE operating_facility_id = '"+facility_id+"') AND queue_status < '07' ";
				sql=sql+" ae_current_patient,op_param WHERE facility_id = '"+facility_id+"' and operating_facility_id = facility_id and TRUNC(queue_date) < TRUNC((SYSDATE - visit_compl_days)) and queue_status < '07' ";
			}

			//Maheshwaran K modified MR_MDS_RECORDED_YN for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			sql = sql+"AND MR_MDS_RECORDED_YN(facility_id,encounter_id,'"+patient_class+"',null,'"+mds_mode+"',null) = 'Y' "; 		

			if( bl_install_yn.equals("Y") && bl_interfaced_yn.equals("Y") )
			{
				sql = sql+"  AND BLOPIN.VISIT_AUTO_CLOSE_YN(facility_id, LOCN_CODE, VISIT_TYPE_CODE, DECODE(PRACTITIONER_ID,'*ALL','',PRACTITIONER_ID),ENCOUNTER_ID)='N' ";
			}
			
			sql = sql+" ORDER BY locn_code ";
			
			//BLOPIN.VISIT_AUTO_CLOSE_YN(facility_id, LOCN_CODE, VISIT_TYPE_CODE, DECODE(PRACTITIONER_ID,'*ALL','',PRACTITIONER_ID))='N' ORDER BY locn_code "; 
			
			rset=stmt.executeQuery(sql);      		
	
			if ( start != 1 )
			{
				for( int k=1; k<start; i++,k++ )
				{
					rset.next() ;
				}
			}
			try {

					int cnt=0;
					while(i<=end && rset.next()) {
						if(cnt==0) {
			%>             <P>
							<table align='right'  >
								<tr>
									<td>
										
										<%

										if ( !(start <= 1) )
											out.println("<A HREF='../../eOP/jsp/AssignPractForAutoClose.jsp?from="+(start-10)+"&module_id="+module_id+"&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn+"&bl_interfaced_yn="+bl_interfaced_yn+"&bl_install_yn="+bl_install_yn+"&to="+(end-10)+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

										if ( endOfRes == 1 ) 
											out.println("<A id='nextval' HREF='../../eOP/jsp/AssignPractForAutoClose.jsp?from="+(start+10)+"&module_id="+module_id+"&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn+"&bl_interfaced_yn="+bl_interfaced_yn+"&bl_install_yn="+bl_install_yn+"&to="+(end+10)+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
										%>
									</td>
								</tr>
							</table>
							<br><br>
							</p>
							

							<table border="1" width="90%" cellspacing='0' cellpadding='0' align='center'>

								<th class='columnheader' width='12%' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
								
								<th class='columnheader' width='5%'nowrap><fmt:message key="eOP.RegnDateTime.label" bundle="${op_labels}"/></th>
								<th class='columnheader' nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
								
								<th class='columnheader' width='13%' nowrap><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></th>				 
		 
		 
					 <%
					 }

					 if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					 else
						classValue = "QRYODD" ;					 
					 pract_id			 = rset.getString("Practitioner_id");
					 oth_res_class		 = rset.getString("OTHER_RES_CLASS");
					 locn_type			 = rset.getString("locn_type");
					 locn_code			 = rset.getString("locn_code");
					 date_time			 = rset.getString("dt");
					 locn_desc           =  rset.getString("locn_desc");
					 p_encounter_id      = String.valueOf(rset.getLong("encounter_id"));
					 p_queue_no			 = rset.getString("queue_num");
					 p_patient_id        = rset.getString("patient_id");	
					 p_regn_time         = rset.getString("regn_date_time");
					 p_regn_time=DateUtils.convertDate(p_regn_time,"DMYHM","en",locale);
					 patient_details     = rset.getString("patient_details"); 
					pat_curr_locn_type_desc=rset.getString("pat_curr_locn_type_desc"); 
					 episode_id			 = rset.getString("episode_id"); 
					 visit_id			 = rset.getString("op_episode_visit_num"); 

					queue_date=rset.getString("queue_date")==null?"":rset.getString("queue_date"); 
					
					 p_status	= rset.getString("queue_status")==null?"":rset.getString("queue_status");

						if(p_status.equals("00"))
						{
						queue_status="";
						}
						else if(p_status.equals("01"))
						{
						queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckedIn.label","op_labels");
						}else if(p_status.equals("02"))
						{
						queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ArrivedAtNursStn.label","op_labels");
						}else if(p_status.equals("03"))
						{
							queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VitalSignRecorded.label","op_labels");
						}else if(p_status.equals("04"))
						{
							queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
						}else if(p_status.equals("05"))
						{
								queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treat/Invest.label","common_labels");
						}else if(p_status.equals("06"))
						{queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RetFrmInvest.label","op_labels");
						}else if(p_status.equals("07"))	
						{
						queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
						}
				    
					if(!locn_code.equals(prev_locn_code))	
						{
					%>	
					<tr><td   class='CAGROUPHEADING' nowrap colspan=4><font size='1' ><b><%=pat_curr_locn_type_desc%>/<%=locn_desc%></td></tr>
					<%prev_locn_code=locn_code;
						}%>
					<tr>
						<td class='<%=classValue%>' class='QRY'><font size='1'><%=p_encounter_id%></td>
						
						<td class='<%=classValue%>' class='QRY' NOWRAP><font size='1'><%=p_regn_time%></td>
				<%
						if (p_queue_no==null) {
				%>
							<td class='<%=classValue%>' class='QRY'><font size='1'><%=patient_details%></td>  
				<%
						} else {
							
							String link = ""; 
							
							if(p_status.equals("07") || p_status.equals("08") )
								link="";
							//else 
								//link="<a href='' name='ass_pract"+num+"' onClick=callAssPract("+p_encounter_id+","+p_patient_id+","+locn_type+","+locn_code+","+oth_res_class+","+date_time+","+p_status+");>";						
						
				%>
						<td class='<%=classValue%>' class='QRY'><a href='javascript:callChkOut("<%=p_encounter_id%>","<%=p_patient_id%>","<%=locn_type%>","<%=locn_code%>","<%=pract_id%>","<%=queue_date%>","<%=module_id%>","<%=episode_id%>","<%=visit_id%>","<%=allow_chkout_with_bill_stmt_yn%>");' name='ass_pract<%=num%>'><font size='1'><%=patient_details%></font></a></td>
				<% 
						} 
				%>
						
						<td class='<%=classValue%>' class='QRY'><font size='1'><%=queue_status%></td>
					</tr>
				<%
						i++;
						num++;
						cnt++;

					}

					//if (cnt == 0) 						//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");

					if(!rset.next() && cnt!=0)
					{
						endOfRes = 0 ;
					%>

					<script>
						document.getElementById("nextval").innerHTML=" ";
					</script>

					<% }

					if(stmt!=null)
						stmt.close();
					if(rset!=null)
						rset.close();

				} catch(Exception e) {
					e.printStackTrace();
				}
    } catch(Exception e) {
		out.println("Exception in outer of try AssignPractForAutoClose File"+e);
		e.printStackTrace();
	} finally {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}	
%>

<input type='hidden' name='oper_id' id='oper_id' value='<%=oper_id%>'>
<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>

</table>
</form>
</body>
</html>


