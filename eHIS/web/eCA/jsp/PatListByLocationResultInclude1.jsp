<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="java.sql.*,webbeans.eCommon.*, java.text.*, eCA.* ,eOR.Common.*, eOR.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<% String sStyle = (String)session.getAttribute("PREFERRED_STYLE") == null?"IeStyle.css":(String)session.getAttribute("PREFERRED_STYLE"); %>
<%
	Connection  con =null;
	String facility_id=(String)session.getValue("facility_id");
	if(facility_id == null) facility_id="";
	webbeans.op.PatientData patdata = new  webbeans.op.PatientData();    
	patdata.setFacility_id(facility_id);
	String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	CACommonGetPatientDtlBean bean1					= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	PreparedStatement stmtMotherLink = null;
	
	PatListByLocationResult bean ;
	String bean_id = "CA_ca_patListbylocationresult" ;
	String bean_name = "eCA.PatListByLocationResult";
	
	String clinicianId =(String)session.getValue("ca_practitioner_id");

	ResultSet rsPatList = (ResultSet)request.getAttribute("rsPatList");

	
	ResultSet rsMotherLink = null;	
	boolean outpHeader=false, inpHeader=false;
	
	StringBuffer layer = new StringBuffer();
	
	String currcompstring = "", prevcompstring = "`", status =		null,sex="",currpract = null, currvisitdate = null,emergencyYn = null, deceasedYn = null, relationYn = null,className = null,className1 = null, text = null, disp_cls_cons_date =null;                  
	StringTokenizer st = null;
	String n =null, datedisplay = null, practScheduled= null, tempDischargeDate = "";
	boolean header = false;
	String p_queue_status = null; // added for CRF 192 - IN030532
	String pendDisSummColor = "#000000", pendDisSummtTip = ""; //ML-MMOH-CRF-0356 [IN057193]		
	int count= 1, iterate = 0, end = 0,res_pat_rec_count=0, i=0,k=0,accessRightsViewPatient=0;
			
	
			
	String bar_code_site_yn = "",allow_muti_bedside_review_yn="";//getParam
	iterate=Integer.parseInt(request.getParameter("iterate")); 
	end=Integer.parseInt(request.getParameter("end")); 
	i= Integer.parseInt(request.getParameter("i"));
	

	
	String locn_type=request.getParameter("locn_type");
	bar_code_site_yn=request.getParameter("bar_code_site_yn");

	allow_muti_bedside_review_yn=request.getParameter("allow_muti_bedside_review_yn");

	String decesedColor =request.getParameter("decesedColor");
	String relnreqyn =request.getParameter("relnreqyn");
	String locale =request.getParameter("locale");
	String apgar_score =request.getParameter("apgar_score");
	String queue_status =request.getParameter("queue_status");
	String visit_episode_status =request.getParameter("visit_episode_status");
	String link_allowed_yn =request.getParameter("link_allowed_yn");
	String locationType =request.getParameter("locationType");
	String queueValue =request.getParameter("queueValue");
	String Sdate =request.getParameter("Sdate");
	String unscheduledyn =request.getParameter("unscheduledyn");
	String past=request.getParameter("past");
	String legendstyle=request.getParameter("legendstyle");
	String c4cStatuDisplay=request.getParameter("c4cStatuDisplay");
	String qms_call_counter=request.getParameter("qms_call_counter");
	String qms_interfaced_yn=request.getParameter("qms_interfaced_yn");
	String pre_dis_advc_prep_site_YN=request.getParameter("pre_dis_advc_prep_site_YN");

	String scan_count_required_yn=request.getParameter("scan_count_required_yn");
	String alert_required_yn=request.getParameter("alert_required_yn");
	String remarks_required_yn=request.getParameter("remarks_required_yn");

	String patName=request.getParameter("patName");
	String encounterID=request.getParameter("encounterID");
	String q_num=request.getParameter("q_num");
	String queueNumber=request.getParameter("queueNumber");
	String rowclass=request.getParameter("rowclass");
	String episode_type_desc=request.getParameter("episode_type_desc");
	String bedside_ref_review_status=request.getParameter("bedside_ref_review_status");
	String restPatientYN=request.getParameter("restPatientYN");
	String pi_clinical_stud_gif=request.getParameter("pi_clinical_stud_gif");
	
	Boolean isQMSapplicable = Boolean.parseBoolean(request.getParameter("isQMSapplicable"));
	Boolean isVirtualConsSiteSpec = Boolean.parseBoolean(request.getParameter("isVirtualConsSiteSpec"));
	Boolean isVirtualConsSDGSpec = Boolean.parseBoolean(request.getParameter("isVirtualConsSDGSpec"));
	Boolean qnum_patlist_bylocation = Boolean.parseBoolean(request.getParameter("qnum_patlist_bylocation"));


	Boolean flag = true;

	   String queNoFlag 	=	request.getParameter("queNoFlag")==null?"":request.getParameter("queNoFlag");//ML-MMOH-CRF-2069.1	
		String SECONDARY_TRIAGE_QUEUE_NO 	=	request.getParameter("SECONDARY_TRIAGE_QUEUE_NO")==null?"":request.getParameter("SECONDARY_TRIAGE_QUEUE_NO");//ML-MMOH-CRF-2069.1
		String QueueSecondaryFlag 	=	request.getParameter("QueueSecondaryFlag")==null?"":request.getParameter("QueueSecondaryFlag");//ML-MMOH-CRF-2069.1	
	int counts =Integer.parseInt(request.getParameter("counts"));

	String sqlMotherLink = "select a.patient_id pat_id, replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) ,'''','')  short_name, to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH, a.WEIGHT, a.WEIGHT_UNIT, a.LENGTH ||' cms'  LENGTH_OF_BABY,a.CIRCUMFERENCE ||' cms'  CIRCUMFERENCE_OF_HEAD,a.APGAR_SCORE, b.sex from mp_birth_register a,mp_patient b where  b.patient_id=a.patient_id and a.mother_patient_id= ? and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by pat_id asc  ";
			try{
				con = ConnectionManager.getConnection(request);
				Boolean referralRegister = CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");
				bean = (PatListByLocationResult)getObjectFromBean( bean_id, bean_name, session ) ;
				stmtMotherLink = con.prepareStatement(sqlMotherLink);

				
				while(rsPatList.next() && iterate <=end ) 
				{
	
					patName="";//IN067111
					res_pat_rec_count  = rsPatList.getInt("RES_STUDIES_CNT"); //CRF-025	- IN030466
					
					if(res_pat_rec_count > 0)
						pi_clinical_stud_gif = "<img src='../../eCA/images/PI_ClinicalStudies.gif'/>";
					else
						pi_clinical_stud_gif = "";
					encounterID = rsPatList.getString("EPISODE_ID"); // added for CRF 192 - IN030532				
					p_queue_status = rsPatList.getString("queue_status");  // added for CRF 192 - IN030532
					q_num =rsPatList.getString("QUEUE_NUM")==null?"":rsPatList.getString("QUEUE_NUM");							
					if(q_num.equals("0")) queueNumber = "&nbsp;";
							else queueNumber = rsPatList.getString("QUEUE_NUM");
					String p_patient_id = rsPatList.getString("patient_id");// CRF 192 - IN030532


					iterate++ ;

					flag=false;
					
					if (k % 2 == 0 )
						rowclass = "gridData";
					else
						rowclass = "gridData";
					if(locn_type.equals("RP")){
						String patient_status="";
						String title ="";
						String dateofbirth1  ="";
						flag = false;			
						if(header == false)
						{
						%>
						<jsp:include page="../../eCA/jsp/PatListByLocationResultHeader01.jsp" flush="true" /> 
						<%
							header = true;
							i++;
						}
						rowclass = "gridData";				
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date = "&nbsp;";
						patient_status	= rsPatList.getString("patient_status") == null ? "" : rsPatList.getString("patient_status");
						episode_type_desc = rsPatList.getString("PATIENT_CLASS")==null?"":rsPatList.getString("PATIENT_CLASS");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						status = rsPatList.getString("STATUS") == null ? "" : rsPatList.getString("STATUS");
						bedside_ref_review_status = rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
					    restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
						accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding endIN072994
						if("U".equals(sex))
							sex = "Unknown";
						sex  = bean.getLabel(pageContext,sex);
						status  = bean.getLabel(pageContext,status);
						if(allow_muti_bedside_review_yn.equals("Y")){
							if(bedside_ref_review_status.equals("P"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
							else if(bedside_ref_review_status.equals("C"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
							else if(bedside_ref_review_status.equals("N")) // IN052595 
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595
							else if(bedside_ref_review_status.equals("X"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
							else if(bedside_ref_review_status.equals("S"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
						}
						if(rsPatList.getString("unAssigned_yn").equals("N"))
							title = "Speciality Specific Patient (Unassigned)";
						else
							title = "";						
						st = new StringTokenizer(patient_status,"|");
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
						if(!( rsPatList.getString("DISCHARGE_DATE_TIME") == null))
							if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
								className = "DISCHARGED";
						if(deceasedYn.equals("D")){
							className = "CADECEASED";
							rowclass = "DECEASED1";
							decesedColor = "";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor = "";
						}else{
							decesedColor = "";
						}
						if(noofchildren > 0) 
							className = "NEWBORN";
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
							layer = new StringBuffer();
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									if(locale.equals("en"))
									  dateofbirth1=rsMotherLink.getString("date_of_birth");
									else
									  dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
									apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
								if(rsMotherLink!=null) rsMotherLink.close();
							}	
						}
						out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
						out.println("<tr><td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
						if(rsPatList.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("")) 
							out.println("<td onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a></font></td>");						
						else
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+patName+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id"))+"</font></a></font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rsPatList.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("DISCHARGE_DATE_TIME")==null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("ROOM_NO")==null?"&nbsp;":rsPatList.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("BED_NO")==null?"&nbsp;":rsPatList.getString("BED_NO"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif +"</a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("attend_pract_name")== null ? "&nbsp;" : rsPatList.getString("attend_pract_name")) +"</font></td>"); //modifid above for CRF-025 IN030466									
						if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y")){
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			%>
								<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
			<%
								out.println("</a></font></td>");
								}//IN064836 start
								else
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			%>
								<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
			<%
								out.println("</a></font></td>");
							}
							//IN064836 ends
						}	// added for IN048463 - Start
						else {  
								if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals(""))){
									if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
										out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
				%>
									<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
				<%
									out.println("</a></font></td>");
									}//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}						
							else if(!referralRegister|| "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}
							else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			%>
								<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
			<%
								out.println("</a></font></td>");
							}
						} // added for IN048463 - End
							out.println("<script language='javascript'>");
							out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
							out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
							out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added forIN072994
						    out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added forIN072994
						    out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added forIN072994
							out.println("</script>");
		%>
						<input type="hidden" name="patient_id<%=i%>" value='<%=rsPatList.getString("patient_id")%>'>
						<input type="hidden" name="referral_id<%=i%>" value='<%=rsPatList.getString("referral_id")%>'>
						<input type="hidden" name="location_code<%=i%>" value='<%=rsPatList.getString("ASSIGN_CARE_LOCN_CODE")%>'>
						<input type="hidden" name="practitioner_Id<%=i%>" value='<%=rsPatList.getString("ATTEND_PRACTITIONER_ID")%>'>
						<input type="hidden" name="sex<%=i%>" value='<%=rsPatList.getString("sex")%>'>
						<input type="hidden" name="unAssigned_yn<%=i%>" value='<%=rsPatList.getString("unAssigned_yn")%>'>
						<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'><!--32902-->
					<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!--32902-->
		<%
						i++;
						k++;
					}else{
						status			= rsPatList.getString("status")==null?"":rsPatList.getString("status");
						queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
						visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
						episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994
						if(episode_type_desc.equals("IP")){
							if(patName.equals("X")){
								continue;
							}else if(patName.indexOf("|")!=-1){
								patName = patName.substring(patName.indexOf("|")+1);
								link_allowed_yn="N";
							}
						}
						queue_status  = bean.getLabelTxt(pageContext, episode_type_desc, queue_status, visit_episode_status); //Code changed to reduce number of code line
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						if(sex.equals("M") || sex.equals("Male") )
							sex ="M";
						else if(sex.equals("F") || sex.equals("Female"))
							sex ="F";
						else if(sex.equals("U") || sex.equals("Unknown"))
							sex ="U";
						currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
						currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date ="&nbsp;";
						st = new StringTokenizer(status,"|");
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}				
						tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");
						if(deceasedYn.equals("D")){
							className="CADECEASED"; rowclass = "DECEASED1"; decesedColor="";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";  decesedColor="";
						}else{
							decesedColor="";
						}
						if (!deceasedYn.equals("D")){	
							if(!tempDischargeDate.equals("")) className = "DISCHARGED";
							else if((noofchildren > 0)) className = "NEWBORN";
						}
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
						if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
							disp_cls_cons_date = "&nbsp;";
						if(!disp_cls_cons_date.equals("&nbsp;")){
							disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);
						}else{
							disp_cls_cons_date = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
						if(rsPatList.getString("episode_type").equals("O")){
							if(outpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+ rsPatList.getString("QRYTIME")+"</b>'}</script>");
								%>
								<tr><td class='columnheader' width='16px'>&nbsp;</td><td class='columnheader' width='16px'>&nbsp;</td>
								<td class='columnheader' nowrap><a class='gridLink'  onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.Sno.label" bundle="${ca_labels}"/></a></td><!--54073-->
								<td class='columnheader' nowrap><a class='gridLink' id='a01'   href="javascript:callForOrderByLoc('LOC');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a02'   href="javascript:callForOrderByLoc('AT');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></a></td>
							     <% if(locationType.equals("OP")){%>	
							   <td class='columnheader' nowrap><a class='gridLink' id='a05'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></td>
							    <%}%>
								<td class='columnheader' nowrap><a class='gridLink' id='a03'   href="javascript:callForOrderByLoc('QN');" onclick='changeColor(this);' style='color:white'><%=queueValue%></a></td>
								<!--- ML-MMOH-CRF-2069.1--->
								<%if(qnum_patlist_bylocation && queNoFlag.equalsIgnoreCase("Y") && QueueSecondaryFlag.equalsIgnoreCase("Y") && (locn_type.equals("EM") || locationType.equals("EM"))){ %>
								<td class='columnheader' nowrap><a class='gridLink' id='a18'   href="javascript:callForOrderByLoc('QN2');" onclick='changeColor(this);' style='color:white'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QNo.label","ca_labels")%></a></td>
								<%} %>
								<!--- ML-MMOH-CRF-2069.1--->
								<% 							
								if(isQMSapplicable && locn_type.equals("OP")){ 
								%>
									<td class='columnheader' width="" nowrap><fmt:message key="eOP.CallTicket.label" bundle="${op_labels}"/></td>
								<%}%>
								<td class='columnheader' nowrap><a class='gridLink' id='a04'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td>
								<%
								if(isVirtualConsSiteSpec && "OP".equals(locationType)){%>
								<td class='columnheader'   nowrap><a style='color:white'   ><fmt:message key="eCA.ConsultationType.label" bundle="${ca_labels}"/></a></td>
								<%}
								%>
								<td class='columnheader' nowrap><a class='gridLink' id='a08'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a06'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a  class='gridLink' id='a07'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a12'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a13'   href="javascript:callForOrderByLoc('SAP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></a></td>
								<% if(locationType.equals("OP")){%>
								<td class='columnheader' nowrap><a class='gridLink' id='a15'   href="javascript:callForOrderByLoc('VT');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></a></td>
								<%}%>
								<td class='columnheader' nowrap><a  class='gridLink' id='a09'   href="javascript:callForOrderByLoc('VD');" onclick='changeColor(this);' style='color:pink'><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap colspan=2><a class='gridLink' id='a11'   href="javascript:callForOrderByLoc('QS');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></td>							
								<td class='columnheader' nowrap> <fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></td><!-- IN044246 -->
								<td class='columnheader' nowrap><a class='gridLink' id='a10' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.ConsEndDate.label" bundle="${ca_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a14'   href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td>
								<% if(locationType.equals("EM")){%>
								<td class='columnheader' nowrap><a class='gridLink' id='a05'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></td></tr>
								 <% }%>
								<%
								i++; i++;  outpHeader=true;
							}						
							datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
							if(datedisplay.equals(Sdate)) 
								datedisplay = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CurrentQueue.label","ca_labels");
							if(unscheduledyn.equals("Y") && past.equals("N")){
								practScheduled= "Unassigned";
								if(currpract.equals(""))    
									practScheduled = "Unassigned";
								else
									practScheduled = "Assigned";
								currcompstring = practScheduled;						
							}else if(unscheduledyn.equals("N") && past.equals("Y")){
								currcompstring = currvisitdate;
							}else if(unscheduledyn.equals("Y") && past.equals("Y")){
								practScheduled= "Unassigned";
								if(currpract.equals(""))    
									practScheduled = "Unassigned";
								else 
									practScheduled = "Assigned";
								currcompstring = practScheduled+currvisitdate;
							}
							if(!currcompstring.equals("")){
								if(!currcompstring.equals(prevcompstring)){
									i++;
								}
							}	
						    restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							c4cStatuDisplay="";
							if(isVirtualConsSDGSpec && "OP".equals(locationType)  && ("Y".equals(rsPatList.getString("C4C_STATUS_DISPLAY")))){
								c4cStatuDisplay="<img src='../../eCA/images/bellIcon.png' alt='Patient Waiting for Virtual Consultation'/>";
							}
							out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+ counts++ +"&nbsp;"+c4cStatuDisplay+"</td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td id='rtb"+i+"' class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td>");//51817 						
						if(locationType.equals("OP"))	{	
							if(rsPatList.getString("referral_id")!= null){
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
							}else{
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
							}
						}
						    out.println("<td id='rtc"+i+"' class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td>");
						  //ML-MMOH-CRF-2069.1 start
						    if(qnum_patlist_bylocation && queNoFlag.equalsIgnoreCase("Y")  && QueueSecondaryFlag.equalsIgnoreCase("Y") && (locn_type.equals("EM") || locationType.equals("EM"))){
								
								String qnumber= rsPatList.getString("SECONDARY_TRIAGE_QUEUE_NO")== null?"&nbsp;&nbsp;&nbsp;":rsPatList.getString("SECONDARY_TRIAGE_QUEUE_NO");
								out.println("<td id='rtb"+i+"' class=gridData nowrap>&nbsp;"+qnumber+"</td>");
								
								
							}
							//ML-MMOH-CRF-2069.1 end
							//<!-- 51817 Ends
							int qms_call_cnt = rsPatList.getInt("QMS_CALL_COUNT"); // added for  // added for CRF 192 - IN030532 - Start
							String callRecall="Call.png";
							String mouseOver="Call Patient";
							if(qms_call_cnt >=1)
							{
								callRecall="Recall.png";
								mouseOver="Recall Patient";
								qms_call_cnt=(qms_call_cnt-1)<=0?0:(qms_call_cnt-1);
								qms_call_counter=String.valueOf(qms_call_cnt);
							}else{
								qms_call_counter="";
							}
							if(isQMSapplicable && locn_type.equals("OP")){	
								if(qms_interfaced_yn.equals("Y") && !encounterID.equals("0") && !p_queue_status.equals("01") && !"&nbsp;".equals((String)rsPatList.getString("QUEUE_NUM"))){
									out.println("<td id='rtp"+i+"' class=gridData nowrap><img style='cursor:pointer;' src='../../eCommon/images/"+callRecall+"' alt='"+mouseOver+"' onclick=\"callPatient('"+p_patient_id+"','"+encounterID+"','"+queueNumber+"');\" >&nbsp;<FONT size=1>"+qms_call_counter+"</td> "); //IN000000
								}else{
									out.println(" <td id='rtp"+i+"' class = gridData nowrap>&nbsp;</td> ");//IN000000
								}
							} // END added for CRF 192 - IN030532					
							if(link_allowed_yn.equals("Y")){
								out.println("<td id='rtd"+i+"' class=gridData nowrap><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN000000							
							}else{
								out.println("<td id='rtd"+i+"' class=gridData nowrap><font color="+decesedColor+">"+patName);//IN000000
							}
							if(isVirtualConsSiteSpec && "OP".equals(locationType) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
								out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
							}else if(isVirtualConsSiteSpec && "OP".equals(locationType)){ 	
								out.println("<td id='rtct"+i+"' class='gridData' nowrap>&nbsp;</td>");
							}
							%>
							    <!--32902 start-->
									<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'><!--32902-->
									<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!--32902-->
								<!--32902 end--->
								<%
							out.println("</font></td><td id='rte"+i+"' class=gridData nowrap>"+rsPatList.getString("patient_id")+"</td><td id='rtf"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rtg"+i+"' class=gridData nowrap>"+sex+"</td><td id='rth"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td><td id='rti"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("SPLTY_NAME")+"</a></td>");//Added - Changes suggested by sunil
							if(locationType.equals("OP")){
							out.println("<td id='rtq"+i+"' class=gridData nowrap>"+rsPatList.getString("visit_type")+"</td>");
							}
							out.println("<td id='rtj"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rtk"+i+"' class=gridData nowrap colspan='2'>"+queue_status+"</td><td id='rtl"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td id='rtm"+i+"' class=gridData nowrap>"+disp_cls_cons_date+"</td><td id='rtn"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>");
						if(locationType.equals("EM")){	
							if(rsPatList.getString("referral_id")!= null){
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}}
						}
						else if(rsPatList.getString("episode_type").equals("I"))
						{
							if("Y".equals(rsPatList.getString("PEND_DISC_SUM_YN"))){ //ML-MMOH-CRF-0356 [IN057193] 
								pendDisSummColor = "'color:red;'";
								pendDisSummtTip = "alt ='Discharge Summary is not done' title= 'Discharge Summary is not done'";
							}else { 
								pendDisSummColor = "'color:black;'";
								pendDisSummtTip = "";
							} //ML-MMOH-CRF-0356 [IN057193]
							layer = new StringBuffer();
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									apgar_score=rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append( "<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale)+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}							
							}
							if(inpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								%>
								<tr>
								<td class='columnheader' width='16px'>&nbsp;</td>
								<td class='columnheader' width='16px'>&nbsp;</td>
								<td class='columnheader' nowrap><a class='gridLink'  onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.Sno.label" bundle="${ca_labels}"/></a></td><!--54073-->
								<td class='columnheader' nowrap><a class='gridLink' id='a01'   href="javascript:callForOrderByLoc('LOC');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap colspan='3'><a class='gridLink' id='a02'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a06'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a04'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a05'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a11'   href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a10'   href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a12'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a13'   href="javascript:callForOrderByLoc('SAP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a07'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:pink'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></a></td><!--Changes suggested by sunil-->
								<td class='columnheader' nowrap><a class='gridLink' id='a08'   href="javascript:callForOrderByLoc('IQS');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap> <fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></td><!-- IN044246 -->							
								<td class='columnheader' nowrap><a class='gridLink' id='a09' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a14'   href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td>
								<td class='columnheader' nowrap><a class='gridLink' id='a03'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></td>
							<%
								if("Y".equals(pre_dis_advc_prep_site_YN)){
							%>
								<td class='columnheader' nowrap><a class='gridLink' id='a18'   href="javascript:callForOrderByLoc('PDA');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.PreDischargeAdvice.label" bundle="${ca_labels}"/></a></td>
							<%
								}
							%>
								</tr>
									<%
								i++; i++; inpHeader=true;	
							}
							 restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
							out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+counts++ +"</td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td id='rtb"+i+"' onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class=gridData nowrap colspan='3'>");//54073
							if(link_allowed_yn.equals("Y")){
								out.println("<a class='gridLink'  href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN032928													
							}
							else{
								out.println("<font color="+decesedColor+">"+patName);
							}
							out.println("</font></td><td id='rtc"+i+"' class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td id='rtd"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rte"+i+"' class=gridData nowrap>"+sex+"</td>");
							out.println("<td id='rtk"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("BED_NUM")+"</a></td>");
							out.println("<td id='rtl"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("ROOM_NUM")+"</a></td>");
							out.println("<td id='rtf"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td>");
							out.println("<td id='rtg"+i+"' class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td id='rth"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rti"+i+"' class=gridData nowrap style="+pendDisSummColor+pendDisSummtTip+">"+queue_status+"</td>");
							out.println("<td id='rtj"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td id='rtm"+i+"' class=gridData nowrap>"+disp_cls_cons_date+"</td><td id='rtn"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>"); // added for CRF-025 - IN030466//Changes suggested bu sunil
							if(rsPatList.getString("referral_id")!= null){
								if("N".equals(pre_dis_advc_prep_site_YN)){
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}
								else{
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}else{
								if("N".equals(pre_dis_advc_prep_site_YN)){	
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}else{
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}
							if("Y".equals(pre_dis_advc_prep_site_YN)){
								if("Y".equals(rsPatList.getString("pre_disg_advice_YN"))){
									out.println("<td class=gridData nowrap>");
								%>
									<fmt:message key="eCA.Prepared.label" bundle="${ca_labels}"/>	
								<%
								out.println("</td></tr>");
								}else{
									out.println("<td class=gridData nowrap>");
								%>
									<fmt:message key="eCA.NotPrepared.label" bundle="${ca_labels}"/>
								<%
									out.println("</td></tr>");
								}
							}
						}
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");					
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
					   %>
						<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'><!--32902-->
						<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!--32902-->
						<%
						i++; k++;
						prevcompstring = currcompstring; link_allowed_yn="Y";
					}
				}
				/* } */
				if(rsPatList!=null) rsPatList.close();
				if(rsMotherLink!=null) rsMotherLink.close();	
				if(stmtMotherLink!=null) stmtMotherLink.close();	
			
				
			}catch(Exception e2){
				e2.printStackTrace();
			}
			finally{
				if(con!=null)
					ConnectionManager.returnConnection(con,request);
			}
			%>

