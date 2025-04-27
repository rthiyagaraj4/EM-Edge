<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
?           	100			?	         	?				?			created

07/02/2014	IN046648		Karthi 		07/02/2014		Ramesh			Specialty name is not displayed completely if the specialty name contains any special characters	
03/07/2015	IN052940		Ramesh G									In Clinical note there should be an option to auto fetch/Copy data from same template 
																		if filled up earlier for same patient in template format.
24/01/2018	IN063931		Prakash C	25/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)																						
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session); //IN063931
%>
<html><head>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>  -->
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
<script language='javascript'>
var frame = "";
if(top.document.getElementById("dialog-body"))
{
	frame = top.document.getElementById("dialog-body").contentWindow;
}
else
	frame = top;
function getMessageFrame()
{
	if(top.content!=null && !top.document.getElementById('dialog-body'))
			 
		return top.content.messageFrame;
	else
		return frame.messageframe;	
}
var messageFrameReference = getMessageFrame();
<%
	Connection			con			=	null;

	PreparedStatement	pstmt		=	null;
	PreparedStatement   pstmtcnt	=	null;
	
	ResultSet			rs			= null;
	ResultSet			rscnt		= null;

	String		query_section_details	=	"",	note_type					=	"";
	String		resp_id					=	"",	encounter_id				=	"";	
	String		patient_id				=	"",	clinician_id				=	"";
	String		clinician_name			=	"",	facility_id					=	"";
	String		event_class				=	"",	serv_facl_spec_yn			=	"";
	String		privilege_type			=	"",	note_type_desc				=	"";
	String		event_type_caption		=	"",	note_type_security_level	=	"";
	String		event_date_caption		=	"",	event_perf_by_caption		=	"";
	String		event_title_caption		=	"",	event_title_desc			=	"";
	String		event_auth_by_caption	=	"",	event_status_caption		=	"";
	String		service_code			=	"";
	String		login_user_id			=	"",	query_canned_text			=	"";
	String		sys_date_time			=	"", med_splty_grp_code			=	"";
	String		note_group_id			=	"",	no_of_rec_per_enc			=	"";
	String		role_based_access_yn	=	"",	pre_cond_for_rec 			=	"";
	String		patient_class			=	"", appl_task_id				=	"";
	String		doc_linked_note_yn		=	"";
	String		def_service_code		=	"";
	String		location_code		=	"";
	String		ql_flag		=	"";
	String		medanc_serv_ql		=	"";
	String		performed_by_ql		=	"";
	String		dflt_transcription_yn		=	"";
	String 		ca_disp_copy_prev_notes_yn = "";  //IN052940
	String 		ca_disp_copy_prev_section_yn = "N";  //IN063931
	

	boolean	enable_cannedtext			=	false,	error_flag				=	false;
	boolean	search_screen_activated		=	false;

	int sec_count = 0;

	try
	{
		con					=	ConnectionManager.getConnection(request);

		facility_id			=	(String)		session.getValue("facility_id");
		login_user_id		=	(String)		session.getValue("login_user");
		resp_id				=	(String)		session.getValue("responsibility_id");
		clinician_id		=	(String)		session.getValue("ca_practitioner_id");
		clinician_name		=	checkForNull((String)		session.getValue("practitioner_name"));
		clinician_name		=	clinician_name.replace('\'',' ');
		note_type			=	checkForNull( request.getParameter("note_type") );
		patient_id			=	checkForNull( request.getParameter("patient_id") );
		encounter_id		=	checkForNull( request.getParameter("encounter_id") );
		patient_class		=	checkForNull( request.getParameter("patient_class") );
		appl_task_id		=	checkForNull( request.getParameter("appl_task_id") );
		def_service_code	=	checkForNull( request.getParameter("defa_speciality_code") );
		location_code	=	checkForNull( request.getParameter("location_code") );
		medanc_serv_ql	=	checkForNull( request.getParameter("medanc_serv_ql") );
		performed_by_ql	=	checkForNull( request.getParameter("performed_by_ql") );
		ql_flag	=	checkForNull( request.getParameter("ql_flag") );
		

		try
		{
			String countQuerySec = "select count(*) count  from ca_note_section  where note_type = ? ";
			pstmtcnt = con.prepareStatement(countQuerySec);
			pstmtcnt.setString(1,note_type);

			rscnt = pstmtcnt.executeQuery();
			
			while(rscnt.next())
			{
				sec_count = rscnt.getInt("count");
			}
			
		}
		catch (Exception eee)
		{
			eee.printStackTrace() ;			
		}
		finally
		{
			if (rscnt != null) rscnt.close();
			if (pstmtcnt != null) pstmtcnt.close();
		}

		
		try
		{
			//query_section_details = " select event_class, serv_facl_spec_yn, privilege_type, note_type_desc, event_type_caption, note_type_security_level, event_date_caption, event_perf_by_caption, event_title_caption, event_auth_by_caption, event_status_caption, note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,DOC_LINKED_NOTE_YN from ca_note_type_for_resp_view where resp_id = ? and note_type = ? ";
			// IN052940 Start.
			//query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =b.NOTE_GROUP_ID ) dflt_transcription_yn from 	CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";
			//query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =b.NOTE_GROUP_ID ) dflt_transcription_yn, /*ca_disp_copy_prev_notes_yn(A.note_type)*/ (select  (select copy_prev_notes_yn  from ca_appl_task where appl_task_id = (select appl_task_id from ca_note_group where note_group=a.note_group_id)) from ca_note_type a where note_type=b.note_type) ca_disp_copy_prev_notes_yn from CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";//commented by prakash IN063931
			//IN052940  End.
			query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =b.NOTE_GROUP_ID ) dflt_transcription_yn, (select  (select copy_prev_notes_yn  from ca_appl_task where appl_task_id = (select appl_task_id from ca_note_group where note_group=a.note_group_id)) from ca_note_type a where note_type=b.note_type) ca_disp_copy_prev_notes_yn,(select  (select copy_prev_section_yn  from ca_appl_task where appl_task_id = (select appl_task_id from ca_note_group where note_group=a.note_group_id)) from ca_note_type a where note_type=b.note_type) ca_disp_copy_prev_section_yn from CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";// IN063931
			pstmt		=	con.prepareStatement(query_section_details);
			
			pstmt.setString(1, resp_id);
			pstmt.setString(2, note_type);
			pstmt.setString(3, locale);
			rs	=	pstmt.executeQuery();

			if(rs.next())
			{
				event_class					=	checkForNull( rs.getString("event_class") );
				serv_facl_spec_yn			=	checkForNull( rs.getString("serv_facl_spec_yn") );
				privilege_type				=	checkForNull( rs.getString("privilege_type") );
				note_type_desc				=	checkForNull( rs.getString("note_type_desc") );
				event_type_caption			=	checkForNull( rs.getString("event_type_caption") );
				note_type_security_level	=	checkForNull( rs.getString("security_level") );
				event_date_caption			=	checkForNull( rs.getString("event_date_caption") );
				event_perf_by_caption		=	checkForNull( rs.getString("event_perf_by_caption") );
				event_title_caption			=	checkForNull( rs.getString("event_title_caption") );
				event_title_desc			=	checkForNull( rs.getString("event_title_caption") );
				event_auth_by_caption		=	checkForNull( rs.getString("event_auth_by_caption") );
				event_status_caption		=	checkForNull( rs.getString("event_status_caption") );
				note_group_id				=	checkForNull( rs.getString("note_group_id") );
				sys_date_time				=	checkForNull( rs.getString("sys_date_time") );
				doc_linked_note_yn			=	checkForNull( rs.getString("DOC_LINKED_NOTE_YN") );
				dflt_transcription_yn		=	checkForNull( rs.getString("dflt_transcription_yn") );
				ca_disp_copy_prev_notes_yn  =	checkForNull( rs.getString("ca_disp_copy_prev_notes_yn") ); //IN052940
				ca_disp_copy_prev_section_yn  =	checkForNull( rs.getString("ca_disp_copy_prev_section_yn") ); //IN063931
				sectionBean.setCopyPrevSectionYN(ca_disp_copy_prev_section_yn);//IN063931
				//sys_date_time				=	com.ehis.util.DateUtils.convertDate(sys_date_time,"DMYHM","en",locale);
				sys_date_time				=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
					
				%>
					//alert('<%=note_type%>');
					
					frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].sel_note_type.value = '<%=note_type%>';
					frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].transcription_yn.value = '<%=dflt_transcription_yn%>';
				//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].doc_linked_note_yn.value = '<%=doc_linked_note_yn%>';

				<%
					
				if(privilege_type.equals("1"))
				{
					if(ql_flag.equals("Y"))
						{
							
						%>
						
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_id.value		= 	'<%=performed_by_ql%>';
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.value = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.perf_pract_name_ql.value ;
								
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].search_btn.disabled = false;
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.disabled=false;
							
		
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performing_phy_name.value = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.perf_pract_name_ql.value ;
					 <%
						}
						else
						{
					%>	frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].search_btn.disabled = false;
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].performed_by_phy_name.disabled = false;						
						
				<%
					}
				} // end of if(privilege_type.equals("1"))
				else
				{
					
				%>		frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].search_btn.disabled = true;	
				
					//alert('<%=clinician_id%>');
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_id.value		= 	'<%=clinician_id%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.value = 	'<%=clinician_name%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.disabled=true;
						
		
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performing_phy_name.value = '<%=clinician_name%>';
				<%
					

				
				} // end of else
				
				%>
				//alert('<%=note_group_id%>');				
				frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_group.value = '<%=note_group_id%>';
				frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_group.disabled = true;
				<%
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

				String query_note_group_props = "select NO_OF_REC_PER_ENC,ROLE_BASED_ACCESS_YN,PRE_COND_FOR_REC from ca_note_group where NOTE_GROUP=?";

				pstmt = con.prepareStatement(query_note_group_props);
				pstmt.setString(1, note_group_id);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					no_of_rec_per_enc		= checkForNull(rs.getString("NO_OF_REC_PER_ENC")); 
					role_based_access_yn	= checkForNull(rs.getString("ROLE_BASED_ACCESS_YN")); 
					role_based_access_yn=role_based_access_yn;
					pre_cond_for_rec			= checkForNull(rs.getString("PRE_COND_FOR_REC")); 
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
				if(pre_cond_for_rec.equals("D"))
				{
					if(patient_class.equals("IP") || patient_class.equals("DC"))
					{
						String query_ip_dis_advice =	 "select 1 from ip_discharge_advice where facility_id =? and  encounter_id=? and DIS_ADV_STATUS in ('0','1')";
						pstmt = con.prepareStatement(query_ip_dis_advice);
						pstmt.setString(1, facility_id);
						pstmt.setString(2, encounter_id);
						rs = pstmt.executeQuery();						
						if(!rs.next())
						{
							error_flag = true;
							%>
							var msg = getMessage('DIS_ADV_NOT_EXISTS','CA');
							alert(msg);
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.focus();
							messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp?err_num='+msg;
						<%}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}
				}
				else if(pre_cond_for_rec.equals("E"))
				{
					
					String install_yn = "";
					String query_install_yn = "SELECT  INSTALL_YN     FROM SM_MODULE  WHERE MODULE_ID='AE'";
					pstmt = con.prepareStatement(query_install_yn);
					rs = pstmt.executeQuery();
					if(rs.next())
						install_yn = checkForNull(rs.getString("INSTALL_YN"));						
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					String query_chk_deceased = "";
					if(install_yn.equals("Y"))
						query_chk_deceased = "SELECT 1 FROM MR_DEATH_REGISTER_HDR WHERE PATIENT_ID=?";
					else
						query_chk_deceased = "select DECEASED_YN from mp_patient where patient_id=? and DECEASED_YN='Y'";

					pstmt = con.prepareStatement(query_chk_deceased);
					pstmt.setString(1, patient_id);
					rs = pstmt.executeQuery();
					
					if(!rs.next())
					{
						error_flag = true;
						%>
						var msg = getMessage('DECEASED_ONLY','CA');
						//var msg = "APP-CA00120 This Note is applicable only for deceased patients.";
						alert(msg);
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.focus();
						messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp?err_num='+msg;
					<%}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}

				
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(!error_flag)
				{
					if(!no_of_rec_per_enc.equals(""))
					{
						try
						{
							String query = "select count(*) from ca_encntr_note where encounter_id = ? and facility_id=? and note_type = ? and event_status in ('1','2','3','4','5') ";
							pstmt = con.prepareStatement(query);
							pstmt.setString(1, encounter_id);
							pstmt.setString(2, facility_id);
							pstmt.setString(3, note_type);
							rs = pstmt.executeQuery();
							rs.next();
							if(rs.getInt(1) >=  Integer.parseInt(no_of_rec_per_enc))
							{
								search_screen_activated = true;
								%>
								alert(getMessage("MAX_NOTES_LIMIT","CA"));
								//alert("APP-CA00101 Allowed number of records per encounter reached the limit...You cannot create a new note ...");
								var query_string = frame.content.workAreaFrame.RecClinicalNotesTabsFrame.document.RecClinicalNotesTabForm.query_string.value;
								frame.content.workAreaFrame.RecClinicalNotesFrame.location.href = '../../eCA/jsp/RecClinicalNotesMain.jsp?'+query_string;
							<%}
			
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();							
						}
						catch(Exception e)
						{
							e.printStackTrace();
							//out.println("Exception at Point 4.12-->" + e.getMessage());//COMMON-ICN-0181
						}
					}
					if(!search_screen_activated)
					{
						query_section_details = " SELECT service_code med_splty_grp_code FROM pr_encounter WHERE encounter_id = ? and facility_id= ? ";
						pstmt		=	con.prepareStatement(query_section_details);
						pstmt.setString	(	1,	encounter_id	);
						pstmt.setString	(	2,	facility_id	);
						rs	=	pstmt.executeQuery();
						if(rs.next())
						{
							med_splty_grp_code	=	rs.getString("med_splty_grp_code");
							if(med_splty_grp_code==null) med_splty_grp_code = "";
						}

						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();

						query_canned_text = "Select 1 from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ?  and rownum=1 ";
						pstmt		=	con.prepareStatement(query_canned_text);
						pstmt.setString(1,med_splty_grp_code);
						pstmt.setString(2,med_splty_grp_code);
						pstmt.setString(3,login_user_id);
						pstmt.setString(4,login_user_id);
						pstmt.setString(5,note_type);
						pstmt.setString(6,note_type);
						rs			=	pstmt.executeQuery();
						
						if(rs.next())
							enable_cannedtext = true;

						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();


						if(serv_facl_spec_yn.equals("Y") )
						{
							query_section_details = "select ca_note_type_by_serv.service_code from ca_note_type_by_serv, AM_FACILITY_SERVICE_VW where ca_note_type_by_serv.facility_id=AM_FACILITY_SERVICE_VW.operating_facility_id and ca_note_type_by_serv.note_type = ?  and ca_note_type_by_serv.service_code=AM_FACILITY_SERVICE_VW.SERVICE_CODE AND ca_note_type_by_serv.SERVICE_CODE = ?";

							pstmt		=	con.prepareStatement(query_section_details);
							
							pstmt.setString(1, note_type);
							pstmt.setString(2, def_service_code);
							rs	=	pstmt.executeQuery();

							if(rs.next())
								 service_code = rs.getString(1);

							if(service_code == null) service_code ="";

							if(!service_code.equals(""))
							{
								if(ql_flag.equals("Y"))
								{
								if(!service_code.equals(medanc_serv_ql)&&!medanc_serv_ql.equals(""))
									{
								%>
									frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value						="";
										
										
									
								<%

									}
									else
									{
								%>
										
									/*alert('1223....'+frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_name_ql.value);
										frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value						= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_name_ql.value;*/

									frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value						= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value;
									frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.value					= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.defa_speciality_code.value;



								<%
									}
									
								}
								else
								{
								%>
								
								frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value						= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value;
								frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.value					= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.defa_speciality_code.value;
								
								<%
								}
								

							}
							else
							{
								%>
								
								
								frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value						= "";
								frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.value					= "";
								<%
							}
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();

						}
						else
						{
						
							if(ql_flag.equals("Y"))
							{

								if(!def_service_code.equals(medanc_serv_ql)&&!medanc_serv_ql.equals(""))
								{

							%>
								frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value						="";
								

							<%	

								}
								else
								{
							%>
								
								 	frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value						= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value;
								 	frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.value					= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.defa_speciality_code.value;

							<%
								}

							}
							else
							{	
							
							%>
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value						= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value;
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.value					= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.defa_speciality_code.value;
							<%
							}
								
						}


						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(event_type_caption.equals(""))		event_type_caption		=	"Note Type";
						if(event_date_caption.equals(""))		event_date_caption		=	"Date/Time";
						if(event_perf_by_caption.equals(""))	event_perf_by_caption	=	"Performed By";
						if(event_title_caption.equals(""))		event_title_caption		=	"Note Title";
						if(event_status_caption.equals(""))		event_status_caption	=	"Note Status";
						if(event_auth_by_caption.equals(""))	event_auth_by_caption	=	"Authorized By";
						
					%>
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_class.value						= '<%=event_class%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_facl_spec_yn.value			= '<%=serv_facl_spec_yn%>';
						
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.privilege_type.value					= '<%=privilege_type%>';					
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_type_caption.value			= '<%=event_type_caption%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type_security_level.value	= '<%=note_type_security_level%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_caption.value			= '<%=event_date_caption%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_perf_by_caption.value		= '<%=event_perf_by_caption%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_title_caption.value			= '<%=event_title_caption%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_status_caption.value		= '<%=event_status_caption%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_auth_by_caption.value		= '<%=event_auth_by_caption%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.getElementById("td_note_type").innerText			= '<%=event_type_caption%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.getElementById("td_event_date_time").innerText= '<%=event_date_caption%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.getElementById("td_performed_by_id").innerText= '<%=event_perf_by_caption%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.getElementById("td_event_title_desc").innerText= '<%=event_title_caption%>';
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.enable_cannedtext.value			= '<%=enable_cannedtext%>';
						//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.doc_linked_note_yn.value			= '<%=doc_linked_note_yn%>';
						
						<%
						if(ql_flag.equals("Y"))//sys_date_time
						{
						%>
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.value = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sys_date_time.value;

						<%
						}
						else
						{			
						%>		
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.value				= '<%=sys_date_time%>';
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sys_date_time.value					= '<%=sys_date_time%>';
						
					<%	}
						//defaulting the service if the note is connected to only one service
								
						
						if(sec_count > 0 && doc_linked_note_yn.equals("Y"))
						{
						%>
							
											// new 

						var event_title_desc ="" ;
						var note_status ="";
						var performed_by_pract ="";
						var performed_date ="";
						var attending_practitioner ="";
						var speciality_name ="";
						var Sex ="";
						var visit_adm_date ="";
						var med_service ="";
						var accession_num ="";
						var location_code ="";

						event_title_desc = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_title_desc.value ;
						performed_by_pract = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.value ;
						performed_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.value ;
						attending_practitioner = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.attending_practitioner.value ;
						service_name = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value ;
						speciality_name = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.speciality_name.value ;
						Sex = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.Sex.value ;
						visit_adm_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.visit_adm_date.value ;
						discharge_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.discharge_date.value ;
						med_service = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value ;
						accession_num = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value ;
						location_code = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.location_code.value ;						

						//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&event_title_desc='+event_title_desc+'&note_status='+note_status+'&performed_by_pract='+performed_by_pract+'&performed_date='+performed_date+'&attending_practitioner='+attending_practitioner+'&speciality_name='+speciality_name+'&Sex='+Sex+'&visit_adm_date='+visit_adm_date+'&med_service='+med_service+'&accession_num='+accession_num+'&discharge_date='+discharge_date+'&location_code='+location_code;

						// new 
				//	frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = '../../eCA/jsp/RecClinicalNotesToolbar.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&doc_linked_note_yn=<%=doc_linked_note_yn%>';
					if ("<%=doc_linked_note_yn%>" == "Y")
					{
						if (frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0])
						{							setToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].fileupload_btn,true);
						}
							
					}else{					
						if (frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0])
						{							setToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].fileupload_btn,false);
						}						
					}
							//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&event_title_desc='+event_title_desc+'&note_status='+note_status+'&performed_by_pract='+performed_by_pract+'&performed_date='+performed_date+'&attending_practitioner='+attending_practitioner+'&speciality_name='+speciality_name+'&Sex='+Sex+'&visit_adm_date='+visit_adm_date+'&med_service='+med_service+'&accession_num='+accession_num+'&discharge_date='+discharge_date+'&location_code='+location_code; // commented for IN046648
							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&event_title_desc='+event_title_desc+'&note_status='+note_status+'&performed_by_pract='+performed_by_pract+'&performed_date='+performed_date+'&attending_practitioner='+attending_practitioner+'&speciality_name='+encodeURIComponent(speciality_name,"UTF-8")+'&Sex='+Sex+'&visit_adm_date='+visit_adm_date+'&med_service='+med_service+'&accession_num='+accession_num+'&discharge_date='+discharge_date+'&location_code='+location_code; // modified for IN046648
							//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = '../../eCA/jsp/RecClinicalNotesToolbar.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&doc_linked_note_yn=<%=doc_linked_note_yn%>';
						<%
						}
						else if(doc_linked_note_yn.equals("Y") && sec_count == 0 )
						{
						%>
							
							frame.content.workAreaFrame.RecClinicalNotesFrame.frameSetIdSection.cols="100%,0%,0%";

							//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUpload.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&appl_task_id=<%=appl_task_id%>';
							//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&appl_task_id=<%=appl_task_id%>';

							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&appl_task_id=<%=appl_task_id%>&called_from=NOTES_HEADER';

							frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&appl_task_id=<%=appl_task_id%>&called_from=NOTES_HEADER';
					<%
						}
						else
						{
							
						%>
							
						var event_title_desc ="" ;
						var note_status ="";
						var performed_by_pract ="";
						var performed_date ="";
						var attending_practitioner ="";
						var speciality_name ="";
						var Sex ="";
						var visit_adm_date ="";
						var med_service ="";
						var accession_num ="";
						var location_code ="";

						event_title_desc = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_title_desc.value ;
						performed_by_pract = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.value ;
						performed_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.value ;
						attending_practitioner = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.attending_practitioner.value ;
						service_name = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value ;
						speciality_name = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.speciality_name.value ;
						Sex = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.Sex.value ;
						visit_adm_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.visit_adm_date.value ;
						discharge_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.discharge_date.value ;
						
						med_service = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value ;
						
						accession_num = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value ;
						location_code = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.location_code.value ;
					
						//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = '../../eCA/jsp/RecClinicalNotesToolbar.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&doc_linked_note_yn=<%=doc_linked_note_yn%>';
						if ("<%=doc_linked_note_yn%>" == "Y")
						{
							setToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].fileupload_btn,true);
						}else{
							setToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].fileupload_btn,false);
						}
						//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&event_title_desc='+event_title_desc+'&note_status='+note_status+'&performed_by_pract='+performed_by_pract+'&performed_date='+performed_date+'&attending_practitioner='+attending_practitioner+'&speciality_name='+speciality_name+'&Sex='+Sex+'&visit_adm_date='+visit_adm_date+'&med_service='+med_service+'&accession_num='+accession_num+'&discharge_date='+discharge_date+'&location_code='+location_code; // commented for IN046648
						frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&event_title_desc='+event_title_desc+'&note_status='+note_status+'&performed_by_pract='+performed_by_pract+'&performed_date='+performed_date+'&attending_practitioner='+attending_practitioner+'&speciality_name='+encodeURIComponent(speciality_name,"UTF-8")+'&Sex='+Sex+'&visit_adm_date='+visit_adm_date+'&med_service='+med_service+'&accession_num='+accession_num+'&discharge_date='+discharge_date+'&location_code='+location_code; // modified for IN046648
						//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = '../../eCA/jsp/RecClinicalNotesToolbar.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&doc_linked_note_yn=<%=doc_linked_note_yn%>';
					<%					
						}
							// included by arul on 8th march 2003 --- end
					}//end of if(!search_screen_activated)
				}// end of if(!error_flag)
				%>
				if ("<%=dflt_transcription_yn%>" == "Y")
				{
					setToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].req_transcription,true);

				}
				else
				{
					setToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].req_transcription,false);
				}
				<!-- IN052940 Start.  -->	
				if ("<%=note_type%>" != "" && "<%=ca_disp_copy_prev_notes_yn%>"=="Y")
				{
					setToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Notes,true);
				}
				else{
					setToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Notes,false);
				}
				<!-- IN052940 End.  -->	
				<!-- IN063931 starts  -->	
				if ("<%=note_type%>" != "" && "<%=ca_disp_copy_prev_section_yn%>"=="Y")
				{		
					setToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Section,true);
				}
				else{
					setToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Section,false);
				}
				<!-- IN063931 starts  -->	
				<%
			} // end of if(rs.next())
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		} // end of try
		catch(Exception e)
		{
			//out.println("Exception@4 : "+e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}	
	}
	catch(Exception e)
	{
		//out.println("Exception@5:"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
%>
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
</head><body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='MESSAGE'></body></html>
<%
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

