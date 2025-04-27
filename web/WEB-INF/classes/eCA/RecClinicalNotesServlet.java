/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100           ?           	created
17/07/2012	  IN033881		Menaka V		If a note is forwarded to another practitioner for review,
											addendum recorded by forwarding practitioner is lost.			
09/08/2012	  IN033976		Dinesh T		Commented the block of code, because it is pop uping the message 
											"Operation Completed Successfully" twice.	 												
28/09/2012    IN034910		Dinesh T		Alert message is not appearing sometimes	
10/17/2012	  IN033487		Dinesh T		Multi encounter				
12/11/2012	  IN036165		Chowminya G		Multi encounter	- status Check				
17/12/2012    IN035950      Nijitha        	CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
07/01/2013 	  IN037173      Chowminya G     Multi encounter	- status Check - with upload file													
06/02/2013	IN037675		Dinesh T		IN037675
19/02/2013	IN038003		Nijitha S		CRF-CA- CHL-CRF-0011/01- Patient Social History->More than 1 note can be recorded
21/12/2012	IN030465		Ramesh G		Triggers an alert upon documentation of a Notifiable Disease.	
15/03/2013	  IN038493	    NijithaS			CRF-CA- CHL-CRF-0011/04- Social History Widget->While Modifying a image Linked Section we get script error	
23/09/2013   IN043263		Chowminya G		Clinical Notes Missing
17/12/2013	IN044085		Ramesh G		Bru-HIMS-CRF-024.2 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/04/2014	IN048276		Ramesh G		21/04/2014		Sunil Kumar KV		User enters data and signs off a clinical note. Note displays in the search tab as "Authorized", 
																				However on selecting the note, all the data which is entered in the note is missing. Note just displays as empty.
02/06/2014	  IN037701		Nijitha												SKR-CRF-0036
06/05/2015	IN053733		Ramesh G											When a notifiable recorded against a notifiable diagnosis is marked in error, 
																				the notification to be de-linked from the parent diagnosis
12/05/2015	IN053733		Ramesh G											Bru-HIMS-CRF-024.3
05/08/2015	IN055185		Ramesh G											ML-BRU-SCF-1598 [IN:055185]
05/08/2015	IN054894		Ramesh G											AAKH-SCF-0125.1 [IN:054894]
22/01/2016	IN057193		Karthi L											Flag For Discharge Summary Not Done																						
04/02/2016	IN057201		Karthi L											View Forwarded Referral Letter Under Consults
01/11/2016	IN061988		Vijayakumar K										AAKH-CRF-0088.3 [IN:061988]
08/12/2016	IN061959     Vijayakumar K									GHL-SCF-1111 [IN061959] changes done in the method getCareSetMatrix
22/05/2018	IN067607		Raja S			22/05/2018		Ramesh G			ML-MMOH-CRF-1130.2
20/07/2018	IN067717		Ramesh G		20/07/2018							ML-MMOH-CRF-0898.1
27/07/2018	IN068105		Raja S			27/07/2018	Ramesh G		MMS-DM-CRF-0143
05/06/2018	IN67872			Dinesh T		05/06/2018	Ramesh G		GHL-CRF-0497.1	
06/09/2019	IN071335	   	Ramesh G											Common-ICN-0012
18/03/2020	IN071264		Nijitha S	    18/03/2020	Ramesh G	    GHL-CRF-0604
27/05/2020		IN072879		SIVABAGYAM M		27/05/2020		RAMESH G		MMS-DM-SCF-0688
03/03/2022    29024          Pranay                                                    unused local variable[Common-ICN-0092  ]
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA ;

import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import eCA.RecClinicalNotes.*;
import eCommon.XSSRequestWrapper;  
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class RecClinicalNotesServlet extends HttpServlet
{
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		java.io.PrintWriter out = response.getWriter();

        try
        {
			recordRecClinicalNotes(request,out);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception@Servlet:1 : "+e);//common-icn-0181
		}
    }

	private synchronized void recordRecClinicalNotes(HttpServletRequest request, java.io.PrintWriter out) throws ServletException, java.io.IOException
	{
		HttpSession				session	=	null;
		java.util.Properties	p		=	null;

		Connection				con			=	null;

		out.println ("<html><head>");
		out.println ("<title>Result</title></head>");
		out.println ("<body class='MESSAGE'>");

		webbeans.eCA.RecClinicalNotesSectionBean clinicalNotesSectionBean = null;

		//shaiju
		eCA.PatientBannerGroupLine manageEmailBean = null;

		HashMap htRecClinicalNotes					=	new java.util.HashMap();

		String		clinician_id					=	"",		clinician_name				=	"";
		String		facility_id						=	"",		accession_num				=	"";
		String		patient_id						=	"",		episode_type				=	"";
		String		encounter_id					=	"",		patient_class				=	"";
		String		event_type_caption				=	"",		note_type					=	"";
		String		service_code					=	"",		event_class					=	"";
		String		note_type_security_level		=	"",		event_date_caption			=	"";
		String		event_date_time					=	"",		event_perf_by_caption		=	"";
		String		performed_by_id					=	"",		event_title_caption			=	"";
		String		event_title_desc				=	"",		note_content				=	"";
		String		event_auth_by_caption			=	"",		authorized_by_id			=	"";
		String		authorized_date_time			=	"",		event_status_caption		=	"";
		String		event_status					=	"",		login_user_id				=	"";
		String		encntr_date						=	"",		amendment_type				=	"";
		String		forwarded_clinician_id			=	"",		resp_name					=	"";
		String		serv_facl_spec_yn				=	"",		privilege_type				=	"";
		String		note_type_desc					=	"",		operation_mode				=	"";
		String		login_at_ws_no					=	"",		action_comment				=	"";
		String		function_id						=	"",		resp_id						=	"";
		String		window_close					=	"";
		String		contr_mod_accession_num			=	"";
		String		contr_oth_accession_num			=	""; //IN053733
		String		doc_linked_note_yn				=	"";
		String		strInsertFlag					=	"N";
		String		locale							=	"";
		//shaiju
		String		forward_mode				= "";
		String		module_id					= "";
		String		appl_task_id				= "";
		String		selection_type				= "";
		HashMap     multiHash					= null;
		String     called_from					= "";
		String 		record_mode					= "";	//[IN033677]
		String		srl_no						= "";   //[IN033677]
		String forwardToFac = "";//IN037675
		String notifiable_code = "CANFREP"; //IN044085
		String notifiable_emailYN ="N";		//IN044085
		String print_notes_yn = "";
		String p_notes_view = "";//IN037701
		String nf_patient_id	= "";	//IN053733
		String nf_encounter_id = "";	//IN053733
		String myHIXFlg = ""; //IN067607
		String noteCopiedYN = "";//IN068105
		String prev_sec_hdg_code_as="";//IN071264
		String prev_child_sec_hdg_code_as = "";//IN071264
		String Sex="",speciality_name="",location_code="";//IN072879
		//StringBuffer sql = null;

		//Connection			con		=	null;
		//PreparedStatement	pstmt	=	null;
		//ResultSet rs = null;
		//Hashtable tabdata = null;
		//StringBuffer replaceString = null;
		//String errorMsg = "";
		//shaiju
		int count = 0;

		//int			count							=	0;
		try
        {
			session							=	request.getSession(false);
			con = ConnectionManager.getConnection(request);//IN67872 CS

			clinicalNotesSectionBean=(webbeans.eCA.RecClinicalNotesSectionBean)com.ehis.persist.PersistenceHelper.getObjectFromBean( "sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

			p							=	(Properties)	session.getValue("jdbc") ;
			locale						=	(String)		p.getProperty("LOCALE");

			login_user_id				=	(String)		session.getValue("login_user");
			facility_id					=	(String)		session.getValue("facility_id");
			resp_name					=	(String)		session.getValue("resp_name");
			clinician_id				=	(String)		session.getValue("ca_practitioner_id");
			clinician_name				=	(String)		session.getValue("practitioner_name");
			resp_id						=	(String)		session.getValue("responsibility_id");

			login_at_ws_no				=	checkForNull( p.getProperty("client_ip_address"));
			operation_mode				=	checkForNull( request.getParameter("operation_mode")		);
			accession_num				=	checkForNull( request.getParameter("accession_num")			);
			amendment_type				=	checkForNull( request.getParameter("amendment_type")		);

			forwarded_clinician_id		=	checkForNull( request.getParameter("forwarded_clinician_id"));
			action_comment				=	checkForNull( request.getParameter("action_comment")		);
			action_comment				=   java.net.URLDecoder.decode(action_comment);
			performed_by_id				=	checkForNull( request.getParameter("performed_by_id")		);

			privilege_type				=	checkForNull( request.getParameter("privilege_type")		);

			function_id					=	checkForNull( request.getParameter("function_id")			);

			String field_ref			=	checkForNull( request.getParameter("Field_Ref")	);
			window_close				=	checkForNull( request.getParameter("window_close")			);
			contr_mod_accession_num		=	checkForNull( request.getParameter("contr_mod_accession_num")	);
			contr_oth_accession_num		=	checkForNull( request.getParameter("contr_oth_accession_num")	); //IN)53733	
			doc_linked_note_yn			=	checkForNull( request.getParameter("doc_linked_note_yn"),"N");

			//Shaiju
			forward_mode			=	checkForNull( request.getParameter("forward_mode"));
			//Shaiju

			module_id				=	checkForNull( request.getParameter("module_id"));

			appl_task_id			=	checkForNull( request.getParameter("appl_task_id"));

			called_from			=	checkForNull( request.getParameter("called_from"));
			p_notes_view 		=   checkForNull( request.getParameter("p_notes_view"));//IN037701
			note_type					=	checkForNull( request.getParameter("note_type")					);//IN071264
			record_mode					=	checkForNull( request.getParameter("record_mode")		);   //[IN033677]
			srl_no						=	checkForNull( request.getParameter("srl_no")			);   //[IN033677]
			forwardToFac = checkForNull(request.getParameter("forwardToFac"));//IN037675
			myHIXFlg = request.getParameter("myHIXYN")==null?"N":(String)request.getParameter("myHIXYN");//IN067607
			noteCopiedYN = request.getParameter("noteCopiedYN")==null?"N":(String)request.getParameter("noteCopiedYN");//IN068105
			Sex = request.getParameter("Sex")==null?"":(String)request.getParameter("Sex");//IN072879
			location_code = request.getParameter("location_code")==null?"":(String)request.getParameter("location_code");//IN072879
			speciality_name = request.getParameter("speciality_name")==null?"":(String)request.getParameter("speciality_name");//IN072879
			notifiable_code = request.getParameter("notifiable_code")==null?"CANFREP":(String)request.getParameter("notifiable_code"); //IN044085
			if("".equals(notifiable_code))
				notifiable_code="CANFREP";
			notifiable_emailYN  = request.getParameter("notifiable_emailYN")==null?"N":(String)request.getParameter("notifiable_emailYN"); //IN044085
			nf_patient_id	=checkForNull( request.getParameter("patient_id"));	//IN053733
			nf_encounter_id	=checkForNull( request.getParameter("encounter_id")); //IN053733
			if( operation_mode.equals("Record") || operation_mode.equals("Sign") || operation_mode.equals("ModifySection") || operation_mode.equals("UpdateRecord") ||  operation_mode.equals("ModifyAddendum") || operation_mode.equals("SignOnModify") )
			{
				serv_facl_spec_yn			=	checkForNull( request.getParameter("serv_facl_spec_yn")			);
				note_type_desc				=	checkForNull( request.getParameter("note_type_desc")			);
				patient_id					=	checkForNull( request.getParameter("patient_id")				);
				episode_type				=	checkForNull( request.getParameter("episode_type")				);
				encounter_id				=	checkForNull( request.getParameter("encounter_id")				);
				patient_class				=	checkForNull( request.getParameter("patient_class")				);
				event_type_caption			=	checkForNull( request.getParameter("event_type_caption")		);
			//	note_type					=	checkForNull( request.getParameter("note_type")					);//IN071264
				service_code				=	checkForNull( request.getParameter("service_code")				);
				event_class					=	checkForNull( request.getParameter("event_class"),"PHY$"				);
				note_type_security_level	=	checkForNull( request.getParameter("note_type_security_level")	);
				event_date_caption			=	checkForNull( request.getParameter("event_date_caption"	)		);
				event_date_time				=	checkForNull( request.getParameter("event_date_time")			);
				event_perf_by_caption		=	checkForNull( request.getParameter("event_perf_by_caption")		);
				event_title_caption			=	checkForNull( request.getParameter("event_title_caption")		);
				event_title_desc			=	checkForNull( request.getParameter("event_title_desc")			);
				note_content				=	checkForNull( request.getParameter("note_content")				);
				event_auth_by_caption		=	checkForNull( request.getParameter("event_auth_by_caption")		);
				authorized_by_id			=	checkForNull( request.getParameter("authorized_by_id")			);

				authorized_date_time		=	checkForNull( request.getParameter("authorized_date_time")		);
				event_status_caption		=	checkForNull( request.getParameter("event_status_caption")		);
				event_status				=	checkForNull( request.getParameter("event_status"),"1"			);

				if (event_status.equals(""))
					event_status="j";

				event_date_time				=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM",locale,"en");
				encntr_date					=	checkForNull( request.getParameter("visit_adm_date")			);
				appl_task_id			=	checkForNull( request.getParameter("appl_task_id"));
				selection_type			=	checkForNull( request.getParameter("selection_type"));
				//forwardToFac = checkForNull(request.getParameter("forwardToFac"));//IN037675

				//shaiju st
				manageEmailBean = (eCA.PatientBannerGroupLine)com.ehis.persist.PersistenceHelper.getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

				//list = manageEmailBean.returnSortList();
				multiHash = manageEmailBean.returnHashMap();
				//Collections.sort(list);

				//shaiju en
				/*
				clinicalNotesSectionBean.getPatientSection(patient_id);

				if(!locale.equals("en"))
				{
					try
					{
						con							=	ConnectionManager.getConnection(request);

						DomParser 	dpforDtConvert	= new DomParser();

						String strDtConvQry = "select sec_hdg_code, nvl(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, nvl(CHILD_SEC_CONTENT_TYPE, SEC_CONTENT_TYPE)  sec_content_type from ca_note_section_view where note_type = ? ";

						pstDtCon		= con.prepareStatement(strDtConvQry);
						pstDtCon.setString(1,note_type);

						rstCon		= pstDtCon.executeQuery();

						String strSecTy			=	"";
						String strSecCd			=	"";
						String strSubSecCd		=	"";
						String strSecEd			=	"N";
						String strSecContent	=	"";

						StringBuffer sbContentIn	= new StringBuffer();
						StringBuffer sbResult	=	 new StringBuffer();

						while (rstCon.next())
						{

							strSecCd		= rstCon.getString("sec_hdg_code");
							strSubSecCd		= rstCon.getString("child_sec_hdg_code");
							strSecTy		= rstCon.getString("sec_content_type");

							sbContentIn.delete(0,sbContentIn.length());
							sbResult.delete(0,sbResult.length());
							strSecContent	= "";

							if(strSecTy.equals("T") )
							{
								//strSecEd		=	clinicalNotesSectionBean.getSectionEdited(strSecCd,strSubSecCd);

								//if(strSecEd == null)
								//strSecEd	= "N";

								//if(strSecEd.equals("Y") )
									strSecContent	=	(String) clinicalNotesSectionBean.getSectionContent(strSecCd,strSubSecCd);

								if(!strSecContent.equals("") )
								{
									sbContentIn.append(strSecContent);
									sbResult = dpforDtConvert.tempDateConvert(sbContentIn,locale);
									clinicalNotesSectionBean.setSectionContent(strSecCd,strSubSecCd,sbResult.toString());
								}
							}
						}
					}
					catch (Exception eDT)
					{

					}
					finally
					{
						if(con!=null)	ConnectionManager.returnConnection(con,request);
					}
				}
				*/
			}

			try
			{
				htRecClinicalNotes.put ( "operation_mode",			operation_mode				);
				htRecClinicalNotes.put ( "clinician_id",			clinician_id				);
				htRecClinicalNotes.put ( "clinician_name",			clinician_name				);
				htRecClinicalNotes.put ( "resp_name",				resp_name					);
				htRecClinicalNotes.put ( "responsibility_id",		resp_id						);
				htRecClinicalNotes.put ( "facility_id",				facility_id					);
				htRecClinicalNotes.put ( "login_user_id",			login_user_id				);
				htRecClinicalNotes.put ( "login_at_ws_no",			login_at_ws_no				);
				htRecClinicalNotes.put ( "accession_num",			accession_num				);
				htRecClinicalNotes.put ( "amendment_type",			amendment_type				);
				htRecClinicalNotes.put ( "performed_by_id",			performed_by_id				);
				htRecClinicalNotes.put ( "forwarded_clinician_id",	forwarded_clinician_id		);
				htRecClinicalNotes.put ( "action_comment",			action_comment				);
				htRecClinicalNotes.put ( "privilege_type",			privilege_type				);
				htRecClinicalNotes.put ( "serv_facl_spec_yn",		serv_facl_spec_yn			);
				htRecClinicalNotes.put ( "note_type_desc",			note_type_desc				);
				htRecClinicalNotes.put ( "patient_id",				patient_id					);
				htRecClinicalNotes.put ( "episode_type",			episode_type				);
				htRecClinicalNotes.put ( "encounter_id",			encounter_id				);
				htRecClinicalNotes.put ( "patient_class",			patient_class				);
				htRecClinicalNotes.put ( "event_type_caption",		event_type_caption			);
				htRecClinicalNotes.put ( "note_type",				note_type					);
				htRecClinicalNotes.put ( "service_code",			service_code				);
				htRecClinicalNotes.put ( "event_class",				event_class					);
				htRecClinicalNotes.put ( "security_level",			note_type_security_level	);
				htRecClinicalNotes.put ( "event_date_caption",		event_date_caption			);
				htRecClinicalNotes.put ( "event_date_time",			event_date_time				);
				htRecClinicalNotes.put ( "event_perf_by_caption",	event_perf_by_caption		);
				htRecClinicalNotes.put ( "event_title_caption",		event_title_caption			);
				htRecClinicalNotes.put ( "event_title_desc",		event_title_desc			);
				htRecClinicalNotes.put ( "note_content",			note_content				);
				htRecClinicalNotes.put ( "event_auth_by_caption",	event_auth_by_caption		);
				htRecClinicalNotes.put ( "authorized_by_id",		authorized_by_id			);
				htRecClinicalNotes.put ( "authorized_date_time",	authorized_date_time		);
				htRecClinicalNotes.put ( "event_status_caption",	event_status_caption		);
				htRecClinicalNotes.put ( "event_status",			event_status				);
				htRecClinicalNotes.put ( "encntr_date",				encntr_date					);
				htRecClinicalNotes.put ( "contr_mod_accession_num",	contr_mod_accession_num		);
				htRecClinicalNotes.put ( "doc_linked_note_yn",		doc_linked_note_yn			);
				htRecClinicalNotes.put ( "LOCALE",					locale						);
				htRecClinicalNotes.put ( "forward_mode",			forward_mode				);
				htRecClinicalNotes.put ( "appl_task_id",			appl_task_id				);
				htRecClinicalNotes.put ( "selection_type",			selection_type				);
				htRecClinicalNotes.put ( "multiHash",				multiHash						);
				htRecClinicalNotes.put ( "function_id",				function_id						);
				htRecClinicalNotes.put ( "record_mode",				record_mode					);  //[IN033677]
				htRecClinicalNotes.put ( "srl_no",					srl_no					);  //[IN033677]
				htRecClinicalNotes.put("forwardToFac",forwardToFac);//IN037675
				htRecClinicalNotes.put ( "contr_oth_accession_num",contr_oth_accession_num);  //IN053733
				htRecClinicalNotes.put ( "myHIXFlg",myHIXFlg);  //IN067607
				htRecClinicalNotes.put ( "noteCopiedYN",noteCopiedYN);  //IN068105
				htRecClinicalNotes.put ( "Sex",Sex);  //IN072879
				htRecClinicalNotes.put ( "speciality_name",speciality_name);  //IN072879
				htRecClinicalNotes.put ( "location_code",location_code);  //IN072879
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception while putting HashMap datas!"+e);
				return;
			}

			try
			{
				java.util.HashMap results = null;
				boolean inserted = false;
				String error_msg = "";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
					local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecClinicalNotes", RecClinicalNotesHome.class, local_ejbs);

				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				//IN071335 Changes Start.
				//String contextUrl = HttpUtils.getRequestURL(request).toString();
				//contextUrl = contextUrl.substring(0,contextUrl.indexOf("servlet/"));
				ServletContext context = request.getSession().getServletContext();
				String contextUrl = context.getRealPath("/");
				//IN071335 Changes End.
				webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
				converter.setXSLFileContextReference(contextUrl);
				try
				{
					boolean continueFlow = false;
					String conForSign = "N";//--[IN033487]
					//[IN033487] on 10/17/2012
					//IN071264 Starts
					if("AutoSave".equals(operation_mode) || "SaveDraft".equals(operation_mode) || "AutoSaveUpdate".equals(operation_mode) || "SaveDraftUpdate".equals(operation_mode)){
						accession_num				=	checkForNull( request.getParameter("accession_num_auto")			);
						patient_id					=	checkForNull( request.getParameter("patient_id")				);
						encounter_id				=	checkForNull( request.getParameter("encounter_id")				);
						prev_sec_hdg_code_as				=	checkForNull( request.getParameter("prev_sec_hdg_code_as")				);//IN071264
						prev_child_sec_hdg_code_as				=	checkForNull( request.getParameter("prev_child_sec_hdg_code_as")				);//IN071264
						htRecClinicalNotes.put ( "accession_num",			accession_num				);
						htRecClinicalNotes.put ( "patient_id",			patient_id				);
						htRecClinicalNotes.put ( "encounter_id",			encounter_id				);
						htRecClinicalNotes.put ( "operation_mode",			operation_mode				);
						htRecClinicalNotes.put ( "amendment_type",			amendment_type				);
						htRecClinicalNotes.put ( "clinician_id",			clinician_id				);
						htRecClinicalNotes.put ( "prev_sec_hdg_code_as",			prev_sec_hdg_code_as				);
						htRecClinicalNotes.put ( "resp_id",			resp_id				);
						htRecClinicalNotes.put ( "prev_child_sec_hdg_code_as",			prev_child_sec_hdg_code_as				);
						
						//PreparedStatement as_pstmt = null;//Common-ICN-0092  
						//ResultSet as_rs=null;	//Common-ICN-0092 
						
						Object asArray[] = new Object[5];
						asArray[0] = p;
						asArray[1] = htRecClinicalNotes;
						asArray[2] = clinicalNotesSectionBean;
						asArray[3] = converter;
						asArray[4] = strInsertFlag;

						Class [] asparamArray = new Class[5];
						asparamArray[0] = p.getClass();
						asparamArray[1] = htRecClinicalNotes.getClass();
						asparamArray[2] = clinicalNotesSectionBean.getClass();
						asparamArray[3] = converter.getClass();
						asparamArray[4] = strInsertFlag.getClass();
						
						results = (java.util.HashMap)(busObj.getClass().getMethod("recordRecClinicalNotesAutosave",asparamArray)).invoke(busObj,asArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
					}
					//IN071264 Ends
					if(operation_mode.equals("Record") || operation_mode.equals("Sign"))
					{
						//Connection l_con = ConnectionManager.getConnection(request);//IN67872 CS
						PreparedStatement l_pstmt = null;
						ResultSet l_rs=null;	
						String note_count = "0";
					
						try
						{
								//l_pstmt = l_con.prepareStatement("select count(*)total from ca_encntr_note where patient_id=? and encounter_id =? and NOTE_TYPE = ? and event_status !='9' "); //--[IN036165]//IN67872 CS
								l_pstmt = con.prepareStatement("select count(*)total from ca_encntr_note where patient_id=? and encounter_id =? and NOTE_TYPE = ? and event_status !='9' "); //--[IN036165]//IN67872 CS
								l_pstmt.setString(1,patient_id);
								l_pstmt.setString(2,encounter_id);
								l_pstmt.setString(3,note_type);

								l_rs = l_pstmt.executeQuery();
								
								while(l_rs.next())
								{
									note_count = l_rs.getString("total");
									note_count = note_count==null?"0":note_count ; //new line on 10/17/2012
								}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						finally
						{
							if(l_rs!=null)
							  l_rs.close();
							if(l_pstmt!=null)
								l_pstmt.close();
							
							//IN67872 CS, starts
							/*if(l_con!=null)
								ConnectionManager.returnConnection(l_con,request);*/
							//IN67872 CS, ends
						}

						//String l_pat_key1 = patient_id+encounter_id+note_type+"SETUP";//checkstyle
						//Connection l_con1 = ConnectionManager.getConnection(request);//IN67872 CS
						PreparedStatement l_pstmt1 = null;
						ResultSet l_rs1 = null;
						String note_count_setup = "0";

						try
						{
								//l_pstmt1 = l_con1.prepareStatement("select NO_OF_REC_PER_ENC from ca_note_group where note_group =( select NOTE_GROUP_ID from ca_note_type where note_type = ?)"); //IN67872 CS
								l_pstmt1 = con.prepareStatement("select NO_OF_REC_PER_ENC from ca_note_group where note_group =( select NOTE_GROUP_ID from ca_note_type where note_type = ?)");//IN67872 CS
								note_count_setup = "0";
								l_pstmt1.setString(1,note_type);
								l_rs1 = l_pstmt1.executeQuery();
								while(l_rs1.next())
								{
									note_count_setup = l_rs1.getString("NO_OF_REC_PER_ENC");
									note_count_setup = note_count_setup==null?"0":note_count_setup ;
								}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						finally
						{
							if(l_rs1!=null)
								l_rs1.close();
							if(l_pstmt1!=null)
								l_pstmt1.close();
							
							//IN67872 CS, starts
							/*if(l_con1!=null)
								ConnectionManager.returnConnection(l_con1,request);*/
							//IN67872 CS, ends
						}
						//--[IN033487] - reopen Start
						if(operation_mode.equals("Sign") && (!accession_num.equals("")))
						{
							//Connection l_con2 = ConnectionManager.getConnection(request);//IN67872 CS
							PreparedStatement l_pstmt2 = null;
							ResultSet l_rs2 = null;
							String l_stus = "0";
							try
							{
									//l_pstmt2 = l_con2.prepareStatement("select EVENT_STATUS from ca_encntr_note where accession_num=?");//IN67872 CS
									l_pstmt2 = con.prepareStatement("select EVENT_STATUS from ca_encntr_note where accession_num=?");//IN67872 CS
									l_pstmt2.setString(1,accession_num);
									l_rs2 = l_pstmt2.executeQuery();
									
									while(l_rs2.next())
									{
										l_stus = l_rs2.getString("EVENT_STATUS");
										l_stus = l_stus==null?"0":l_stus ; //new line on 10/17/2012
									}
									if(l_stus.equals("1"))
									{
										conForSign = "Y";
									}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							finally
							{   
								if(l_rs2!=null)
									l_rs2.close();
								if(l_pstmt2!=null)
									l_pstmt2.close();
							
								//IN67872 CS, starts
								/*if(l_con2!=null)
									ConnectionManager.returnConnection(l_con2,request);*/
								//IN67872 CS, ends
							}
						}
						//--[IN033487] - reopen End
						//[IN037173] - Start
						if(operation_mode.equals("Record") && (!accession_num.equals("")))
						{
							//Connection l_con3 = ConnectionManager.getConnection(request);//IN67872 CS
							PreparedStatement l_pstmt3 = null;
							ResultSet l_rs3 = null;
							String l_stus1 = "Y";
							conForSign = "Y";
							try
							{
									//l_pstmt3 = l_con3.prepareStatement("select EXT_IMAGE_APPL_ID from ca_encntr_note where accession_num=?");//IN67872 CS
									l_pstmt3 = con.prepareStatement("select EXT_IMAGE_APPL_ID from ca_encntr_note where accession_num=?");//IN67872 CS
									l_pstmt3.setString(1,accession_num);
									l_rs3 = l_pstmt3.executeQuery();
									
									while(l_rs3.next())
									{
										//l_stus1 = l_rs3.getString("EXT_IMAGE_APPL_ID");//to handle null IN043263
										l_stus1 = l_rs3.getString("EXT_IMAGE_APPL_ID")==null?"":l_rs3.getString("EXT_IMAGE_APPL_ID");//IN043263
									}
									
									if(l_stus1.equals(""))
									{
										conForSign = "N";
									}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							finally
							{   
								if(l_rs3!=null)
									l_rs3.close();
								if(l_pstmt3!=null)
									l_pstmt3.close();
								
								//IN67872 CS, starts
								/*if(l_con3!=null)
									ConnectionManager.returnConnection(l_con3,request);*/
								//IN67872 CS, ends
							}
						}						
						//[IN037173] - End
						if(appl_task_id.equals("CLINICAL_NOTES"))
						{
							if(Integer.valueOf(note_count_setup) == 0)
							{
								continueFlow=true;
							}
							else
							{
								if((Integer.valueOf(note_count) < Integer.valueOf(note_count_setup)) || conForSign.equals("Y") )
								{
									continueFlow=true;
								}
							}
						}
						else
						{
							continueFlow=true;	
						}

						
					}
					//--[IN033487], ends

					if(operation_mode.equals("Sign") || operation_mode.equals("SignOnModify") )
					{

						Object argArray[] = new Object[4];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;
						argArray[2] = clinicalNotesSectionBean;
						argArray[3] = converter;

						Class [] paramArray = new Class[4];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						paramArray[2] = clinicalNotesSectionBean.getClass();
						paramArray[3] = converter.getClass(); 						
						
						if(operation_mode.equals("Sign"))
						{
							if(continueFlow)
							{
								results = (java.util.HashMap)(busObj.getClass().getMethod("signRecClinicalNotes",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
								if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
							}
							else
							{
								results = new HashMap();
								results.put( "status" ,new Boolean("false"));
								results.put("error",(String)MessageManager.getMessage(locale,"MAX_NOTES_LIMIT","CA").get("message")) ;
								results.put("print_notes_yn","N") ;
							}	
						}
						else
						{
							results = (java.util.HashMap)(busObj.getClass().getMethod("signRecClinicalNotes",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							if(htRecClinicalNotes != null) htRecClinicalNotes.clear();	
						}

					}
					else if( operation_mode.equals("Record") || operation_mode.equals("UpdateRecord") )
					{
						Object argArray[] = new Object[5];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;
						argArray[2] = clinicalNotesSectionBean;
						argArray[3] = converter;
						argArray[4] = strInsertFlag;

						Class [] paramArray = new Class[5];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						paramArray[2] = clinicalNotesSectionBean.getClass();
						paramArray[3] = converter.getClass();
						paramArray[4] = strInsertFlag.getClass();
						
						
						
						if(operation_mode.equals("Record"))
						{
							if(continueFlow)
							{
								results = (java.util.HashMap)(busObj.getClass().getMethod("recordRecClinicalNotes",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
								if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
							}
							else
							{
								results = new HashMap();
								results.put( "status" ,new Boolean("false"));
								results.put("error",(String)MessageManager.getMessage(locale,"MAX_NOTES_LIMIT","CA").get("message")) ;
								results.put("print_notes_yn","N") ;
							}
						}
						else
						{
							results = (java.util.HashMap)(busObj.getClass().getMethod("recordRecClinicalNotes",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							if(htRecClinicalNotes != null) htRecClinicalNotes.clear();	
						}
					}
					else if(operation_mode.equals("Forward"))
					{
						StringBuffer sql = new StringBuffer();
						StringBuffer replaceString = new StringBuffer();

						PreparedStatement pstmt = null;
						ResultSet rs = null;

						sql.append("SELECT Count(*) FROM ca_encntr_note_audit_log Where action_status = 'RQ' And action_type in ('RV','RS','FS') "); //AND  ACTION_BY_ID = ?
						if(forward_mode.equals("S"))
						{
							sql.append(" AND  ACTION_BY_GROUP_CODE = ?");
						}
						else
							sql.append(" AND  ACTION_BY_ID = ?");

						sql.append(" AND facility_id	= ? AND accession_num = ? ");

						try
						{
							//con = ConnectionManager.getConnection(request);//IN67872 CS

							pstmt = con.prepareStatement(sql.toString());

							pstmt.setString(1,forwarded_clinician_id);
							pstmt.setString(2,facility_id);
							pstmt.setString(3,accession_num);
							rs = pstmt.executeQuery();

							while(rs!=null && rs.next())
							{
								count = rs.getInt(1);
							}

							if(count > 0)
							{
								java.util.Hashtable err_data = MessageManager.getMessage(locale,"REVIEW_REC_ALREDY_EXISTS","CA");

								int index=0;
								error_msg= (String) err_data.get("message");
								replaceString = new StringBuffer(error_msg);

								if((index=replaceString.toString().indexOf("<br>"))!=-1)
								{
									replaceString=replaceString.replace(index,index+"<br>".length()," ");
								}

								out.println("<script language=\"javascript\">");
								out.println("alert('" + replaceString.toString().replace("'", "")+ "');");
								out.println("if(top.content!=undefined){");
								out.println("if(top.content.messageFrame){");
								out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp'");// Added by Ambiga.M for 18712 on 2/24/2010
								out.println("}}");
								out.println("</script>");
								//out.println("parent.window.close();");

							}
						}
						catch(Exception e)
						{
							//out.println("Exceptionin getting connection : "+e);//common-icn-0181
							e.printStackTrace();
						}
						finally
						{   
							if(rs != null) rs.close();
							if(pstmt!=null) pstmt.close();
							
							//if(con!=null)  ConnectionManager.returnConnection(con,request);//IN67872 CS
						}

						if(count==0)
						{

							Object argArray[] = new Object[2];
							argArray[0] = p;
							argArray[1] = htRecClinicalNotes;
							Class [] paramArray = new Class[2];
							paramArray[0] = p.getClass();
							paramArray[1] = htRecClinicalNotes.getClass();
							results = (java.util.HashMap)(busObj.getClass().getMethod("forwardRecClinicalNotes",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
						}
						else
						{
								out.println("<script language=\"javascript\">");
								//out.println("alert('"+replaceString.toString()+"')");
								// Added by Ambiga.M for 18712 on 2/24/2010
								out.println("if(top.content!=undefined){");
								out.println("if(top.content.messageFrame){");
								out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp'");// Added by Ambiga.M for 18712 on 2/24/2010
								out.println("}}");
								// Added by Ambiga.M ends
								out.println("</script>");
								return;
						}
					}

					else if(operation_mode.equals("Review"))
					{
						Object argArray[] = new Object[2];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;

						Class [] paramArray = new Class[2];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("reviewRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
					}
					else if( operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") )
					{
						Object argArray[] = new Object[4];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;
						argArray[2] = clinicalNotesSectionBean;
						argArray[3] = converter;
						Class [] paramArray = new Class[4];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						paramArray[2] = clinicalNotesSectionBean.getClass();
						paramArray[3] = converter.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("modifyRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
					}
					else if(operation_mode.equals("Delete"))
					{
						Object argArray[] = new Object[2];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;

						Class [] paramArray = new Class[2];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("deleteRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
					}
					else if(operation_mode.equals("MakeAsError"))
					{
						Object argArray[] = new Object[2];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;

						Class [] paramArray = new Class[2];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("errorRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
					}
					/*
					else if(operation_mode.equals("SignOnModify"))
					{
						Object argArray[] = new Object[2];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;
						Class [] paramArray = new Class[2];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("signOnModifyRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
					}
					*/
					else if("REJECT".equals(operation_mode))//IN67872, starts
					{
						Object argArray[] = new Object[2];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;

						Class [] paramArray = new Class[2];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("rejectRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();						
					}//IN67872
					error_msg		= "";
					inserted		=	( ((Boolean) results.get( "status" )).booleanValue() );
					accession_num	=	(String)	results.get("accession_num");
					error_msg		=	(String)	results.get("error") ;
					print_notes_yn		=	(String)	results.get("print_notes_yn") ;

					results.clear();
					//AAKH-SCF-0125.1 [IN:054894]  Start.
					if(inserted)
					{						
						out.println("<script language=\"javascript\">");						
						out.println("var xmlDoc		='';");						
						out.println("var xmlHttp		= new XMLHttpRequest() ;");						
						out.println("xmlStr	=\"<root><SEARCH \" ;");						
						out.println("xmlStr += \" accession_num='"+accession_num+"'\";");						
						out.println("xmlStr +=\" /></root>\" ;");						
						out.println("xmlDoc = new DOMParser().parseFromString(xmlStr, 'text/xml') ;");						
						out.println("xmlHttp.open( \"POST\",\"../eCA/jsp/RecClinicalNotesReBuildIntermediate.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"\", false ) ;");						
						out.println("xmlHttp.send(xmlDoc);");					
						out.println("</script>");
					}
					//AAKH-SCF-0125.1 [IN:054894]  End.
				}
				catch(Exception e)
				{
					//out.println("Exception@recordingEJB : "+e);
					System.err.println("Exception@recordingEJB : "+e);
					//out.println("Trancation Could not be Completed,Plese Try again.");
					e.printStackTrace();
					//AAKH-SCF-0125.1 [IN:054894]  Start.
					if(!"".equals(accession_num))
					{						
						out.println("<script language=\"javascript\">");						
						out.println("var xmlDoc		='';");						
						out.println("var xmlHttp		=  new XMLHttpRequest() ;");						
						out.println("xmlStr	=\"<root><SEARCH \" ;");						
						out.println("xmlStr += \" accession_num='"+accession_num+"'\";");						
						out.println("xmlStr +=\" /></root>\" ;");						
						out.println("xmlDoc = new DOMParser().parseFromString(xmlStr, 'text/xml') ;");							
						out.println("xmlHttp.open( \"POST\",\"../eCA/jsp/RecClinicalNotesReBuildIntermediate.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"\", false ) ;");						
						out.println("xmlHttp.send(xmlDoc);");					
						out.println("</script>");
					}
					//AAKH-SCF-0125.1 [IN:054894]  End.
				}


				if(doc_linked_note_yn.equals("N") || doc_linked_note_yn.equals(""))
				{
					if(inserted && !"AutoSave".equals(operation_mode) && !"SaveDraft".equals(operation_mode) && !"AutoSaveUpdate".equals(operation_mode) && !"SaveDraftUpdate".equals(operation_mode))//IN071264 
					{
						/*if( function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES") )// || function_id.equals("NOTIFIABLEFORM")
						{

							out.println("<script language=\"javascript\">");
							out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");
							out.println("</script>");
						/*

						/*	out.println("<script language=\"javascript\">");
							out.println("top.opener.location.reload();");
							out.println("top.opener.parent.frames(1).location.reload();//}");
							out.println("top.close();");
							out.println("</script>");*/
						//	}

						out.println("<script language=\"javascript\">");

						
						//IN033976, starts
						if( /*function_id.equals("SIGN_NOTES") || */ function_id.equals("REVIEW_NOTES") &&  !operation_mode.equals("MakeAsError") && !operation_mode.equals("Forward"))//IN034910
						{						
							//out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");//IN033881
							out.println("alert('"+error_msg.toString().replace("'", "")+"')");//IN033881
							out.println("top.close();");//IN033881
						}
						//IN033976, ends

						if( (operation_mode.equals("Sign") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum")) && ((!function_id.equals("SIGN_NOTES")) && !(function_id.equals("REVIEW_NOTES"))) )
						{
							if(module_id.equals("MC"))
							{
								out.println("if(top.content.matFrame != null)");
								out.println("if(top.content.matFrame.maternitytreeframe != null)");
								out.println("if(top.content.matFrame.maternitytreeframe.document.maternityMenu != null)");
								out.println("query_string = top.content.matFrame.maternitytreeframe.maternityMenu.queryString.value;");
								out.println("top.content.matFrame.maternitytreeframe.location.href = '../eCA/jsp/MaternityConsMenu.jsp?'+query_string;");

								//out.println("top.content.matFrame.maternitytreeframe.location.reload();");
							}
							/*
							if(module_id.equals("OH"))
							{
								out.println("if(top.content.matFrame != null){");
								out.println("if(top.content.matFrame.maternitytreeframe != null){");
								out.println("if(top.content.matFrame.maternitytreeframe.document.maternityMenu != null){");
								//out.println("top.content.matFrame.maternitytreeframe.location.reload();");
								// new
								out.println("query_string = top.content.matFrame.maternityeventframe.tempmaternityMenu.queryString.value;");
								out.println("var sel_progression_no = top.content.matFrame.maternityeventframe.tempmaternityMenu.progression_select.value;");
								out.println("top.content.matFrame.maternitytreeframe.location.href = '../eCA/jsp/ProgressNotesMenu.jsp?'+query_string+'&sel_progression_no='+sel_progression_no;}}}");
								if(error_msg.lastIndexOf("<br>") != -1)
									error_msg = error_msg.substring(0, error_msg.lastIndexOf("<br>"));

								out.println("alert('1.."+error_msg+"')");

								out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");


							}*/

							//IN037701 Starts
							//IN035950 Starts
							/*out.println("if(null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.frames(0)){");
							out.println("var query_string = top.content.workAreaFrame.frames(0).document.forms(0).query_string.value;");
							out.println("}");
							out.println("else{");
							out.println("var query_string = parent.document.PatientSocialHistoryForm.query_string.value;");
							out.println("}");*/
							out.println("if(\"CA_SPC\"==\""+called_from+"\" && \"S\" == \""+p_notes_view+"\"){");
							out.println("var query_string = top.frames[0].document.forms[0].query_string.value;");
							out.println("}");
							out.println("else if(\"CA_SPC\"==\""+called_from+"\" && \"D\" == \""+p_notes_view+"\"){");
							out.println("var query_string = top.frames[0].document.forms[0].query_string.value;");
							out.println("}else{");
							out.println("if(undefined != top.content && null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.frames[0]){");
							out.println("var query_string = top.content.workAreaFrame.frames[0].document.forms[0].query_string.value;");
							out.println("}");
							out.println("else{");
							out.println("var query_string = parent.document.PatientSocialHistoryForm.query_string.value;");
							out.println("}");
							out.println("}");
							//IN037701 Ends
							
							//IN035950 Ends
							if(function_id.equals("NOTIFIABLEFORM"))
							{

								if(operation_mode.equals("Sign")&&(!field_ref.equals("")))
								{
									out.println("top.opener."+field_ref+".value='"+accession_num+"';");									
									//out.println("window.returnValue='"+accession_num+"';");
								}else{ //IN053733
									out.println("if(top.NotifiableNoteFrm!=null)"); //IN053733
									out.println("top.NotifiableNoteFrm.document.NotifiableNoteForm.tempAccession_Num.value='"+accession_num+"';"); //IN053733
								}  //IN053733
								if(error_msg.lastIndexOf("<br>") != -1)
									error_msg = error_msg.substring(0, error_msg.lastIndexOf("<br>"));

								out.println("alert('"+error_msg.toString().replace("'", "")+"')");
								//IN053733 Start
								if(!"CANFREP".equals(notifiable_code) ){									
									out.println("window.close();");
								}else{
									out.println("top.content.workAreaFrame.location.href = '../eCA/jsp/RecClinicalNotes.jsp?&accession_num="+accession_num+"&operation_mode=&'+query_string;");
								}
								//IN053733 End.
								//IN044085 Start.
								//out.println("top.content.workAreaFrame.sendEmailNF('"+accession_num+"','"+patient_id+"')"); //IN030465
								if(("CANFREP".equals(notifiable_code))||(!"CANFREP".equals(notifiable_code) && "Y".equals(notifiable_emailYN))){
									out.println("top.content.workAreaFrame.sendEmailNF('"+accession_num+"','"+patient_id+"','"+notifiable_code+"')"); 
								}
								//IN044085 End.
							}
							//IN067717 Start.
							else if(function_id.equals("BIRTH_REG_NOTES"))
							{
								out.println("alert('"+error_msg.toString().replace("'", "")+"');");
								out.println("window.returnValue='"+accession_num+"###Success';");
								out.println("window.close();");
							}
							//IN067717 End.
							else if(function_id.equals("SPCL_NOTE"))
							{
								
								if(operation_mode.equals("Sign")&&(!field_ref.equals("")) )
								{
									out.println("if (top.opener != null){");
									out.println("if (top.opener."+field_ref+" != null){");
									out.println("top.opener."+field_ref+".value='"+accession_num+"';}}");
									out.println("else{window.returnValue='"+accession_num+"';}");
								}

								if(appl_task_id.equals("PROGRESS_NOTES"))
								{

									out.println("query_string = top.content.matFrame.maternityeventframe.tempmaternityMenu.queryString.value;");
									out.println("var sel_progression_no = top.content.matFrame.maternityeventframe.tempmaternityMenu.progression_select.value;");
									out.println("top.content.matFrame.maternitytreeframe.location.href = '../eCA/jsp/ProgressNotesMenu.jsp?'+query_string+'&sel_progression_no='+sel_progression_no;");
									out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");

									out.println("top.content.workAreaFrame.location.href = '../eCommon/html/blank.html';");

									window_close = "N";

									if(error_msg.lastIndexOf("<br>") != -1)
										error_msg = error_msg.substring(0, error_msg.lastIndexOf("<br>"));

									out.println("alert('"+error_msg.toString().replace("'", "")+"')");

									out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecControlFrame.callPrintOnSign('"+print_notes_yn+"','"+accession_num+"','"+note_type+"','"+patient_id+"','"+facility_id+"','"+encounter_id+"','"+event_date_time+"','"+patient_class+"','"+performed_by_id+"','"+episode_type+"','"+note_type_desc+"');");

								}
								else
								{
									out.println("top.content.workAreaFrame.location.href = '../eCA/jsp/RecClinicalNotes.jsp?&accession_num="+accession_num+"&operation_mode=&'+query_string;");
									window_close = "Y";
								}

								out.println("if('"+window_close+"'=='Y')");
								out.println("top.close();");
							}
							else if(function_id.equals("TASK_LIST"))
							{

								if(error_msg.lastIndexOf("<br>") != -1)
									error_msg = error_msg.substring(0, error_msg.lastIndexOf("<br>"));

								out.println("alert('"+error_msg.toString().replace("'", "")+"')");

								out.println("top.close();");
								out.println("if (top.opener && !top.opener.closed){");
								out.println("top.opener.location.reload();}");
							}
							//ML-MMOH-CRF-0356 [IN057193] - Start
							else if(function_id.equals("DECEASEDFORM")&&(called_from.equals("DECEASEDFORM")) ||function_id.equals("DISCHARGE_SUMMARY")&&(called_from.equals("PEND_DISC_NOTE")) || function_id.equals("REFERRAL_LETTER")&&(called_from.equals("REFFERAL_NOTE_FROM_PAS")))
							{

								if(error_msg.lastIndexOf("<br>") != -1)
									error_msg = error_msg.substring(0, error_msg.lastIndexOf("<br>"));

								out.println("alert('"+error_msg.toString().replace("'", "")+"')");
								out.println("window.returnValue='"+accession_num+"';");		
								out.println("window.close();");
							}
							//ML-MMOH-CRF-0356 [IN057193] - End
							//IN061988 starts
							else if("PH_NOTES".equals(function_id) && "PH_NOTES".equals(called_from))
							{
								out.println("window.returnValue='"+accession_num+"';");
								out.println("window.close();");
							}
							//IN061988 ends	
							else
							{

								if( operation_mode.equals("Sign") )
								{
									out.println("query_string += '&callback_mode=Add';");
								}
								else
								{
									out.println("query_string += '&callback_mode=Search';");
								}

								if(appl_task_id.equals("PROGRESS_NOTES"))
								{
									out.println("query_string = top.content.matFrame.maternityeventframe.tempmaternityMenu.queryString.value;");
									out.println("var sel_progression_no = top.content.matFrame.maternityeventframe.tempmaternityMenu.progression_select.value;");
									out.println("top.content.matFrame.maternitytreeframe.location.href = '../eCA/jsp/ProgressNotesMenu.jsp?'+query_string+'&sel_progression_no='+sel_progression_no;");

									out.println("top.content.workAreaFrame.location.href = '../eCommon/html/blank.html'");
									out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");

								}

								if(error_msg.lastIndexOf("<br>") != -1)
									error_msg = error_msg.substring(0, error_msg.lastIndexOf("<br>"));

								out.println("alert('"+error_msg.toString().replace("'", "")+"')");
								//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecControlFrame.callPrintOnSign('"+print_notes_yn+"','"+accession_num+"','"+note_type+"','"+patient_id+"','"+facility_id+"','"+encounter_id+"','"+encntr_date+"','"+event_date_time+"','"+service_code+"','"+patient_class+"','"+performed_by_id+"','"+episode_type+"','"+note_type_desc+"');");

								//IN035950 Starts
								//IN037701 Starts
								out.println("if(\"CA_SPC\"==\""+called_from+"\"){");
								out.println("top.close();");
								out.println("}else{");
								//IN037701 Ends
						
								out.println("if(null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame){");
								out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecControlFrame.callPrintOnSign('"+print_notes_yn+"','"+accession_num+"','"+note_type+"','"+patient_id+"','"+facility_id+"','"+encounter_id+"','"+event_date_time+"','"+patient_class+"','"+performed_by_id+"','"+episode_type+"','"+note_type_desc+"');");
								out.println("}");
								out.println("else if(null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesHeaderFrame){");								
								out.println("top.content.workAreaFrame.RecClinicalNotesHeaderFrame.callPrintOnSign('"+print_notes_yn+"','"+accession_num+"','"+note_type+"','"+patient_id+"','"+facility_id+"','"+encounter_id+"','"+event_date_time+"','"+patient_class+"','"+performed_by_id+"','"+episode_type+"','"+note_type_desc+"');");
								out.println("}");
								out.println("}");//IN037701
								//IN035950 Ends
								//Start[IN038003]
								if(appl_task_id.equals("PAT_HISTORY"))
								{
									
									out.println("top.content.workAreaFrame.location.href = '../eCA/jsp/PatientSocialHistory.jsp?'+query_string;");
									/*IN037701 Start.
									out.println("if(\"CA_SPC\"==\""+called_from+"\"){");
									out.println("top.close();");
									out.println("}else{");
										out.println("top.content.workAreaFrame.location.href = '../eCA/jsp/PatientSocialHistory.jsp?'+query_string;");
									out.println("}");
									//IN037701 End.*/
								}
								//End[IN038003]
								else if(!appl_task_id.equals("PROGRESS_NOTES"))
								{
									//out.println("alert('RecClinicalNoteServlet------1010-------->"+called_from+"');");
									//out.println("top.content.workAreaFrame.location.href = '../eCA/jsp/RecClinicalNotes.jsp?'+query_string;");//IN035950
									//IN035950 Starts
								out.println("if(undefined!=top.content && null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame){");
								
								out.println("top.content.workAreaFrame.location.href = '../eCA/jsp/RecClinicalNotes.jsp?'+query_string;");
								/*//IN037701 Start
									out.println("if(\"CA_SPC\"==\""+called_from+"\"){");
									out.println("top.close();");
									out.println("}else{");
									out.println("top.content.workAreaFrame.location.href = '../eCA/jsp/RecClinicalNotes.jsp?'+query_string;");
									out.println("}");
								//IN037701 End.*/
								out.println("}");
								out.println("else  if(undefined!=top.content && null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesHeaderFrame){");
								
								out.println("self.location.href = '../eCA/jsp/RecClinicalNotesMain.jsp?'+query_string;");
								/*//IN037701 Start.
									out.println("if(\"CA_SPC\"==\""+called_from+"\"){");
									out.println("self.close();");
									out.println("}else{");
									out.println("self.location.href = '../eCA/jsp/RecClinicalNotesMain.jsp?'+query_string;");
									out.println("}");
								//IN037701 End.*/
								out.println("}");
								//IN035950 Ends
								//out.println("}");//IN037701
								}
															}

							//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.disableButtons(false,'"+operation_mode+"');");
							out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");
						}
						else if( operation_mode.equals("Record") || operation_mode.equals("UpdateRecord") )
						{
							if(field_ref==null)
							{

							}
							if(function_id.equals("NOTIFIABLEFORM")&&(!field_ref.equals("")))
							{
								out.println("top.opener."+field_ref+".value='"+accession_num+"';");
								//out.println("window.returnValue='"+accession_num+"';");
							}else if(function_id.equals("NOTIFIABLEFORM")&&(field_ref.equals(""))){ //IN053733
								out.println("top.NotifiableNoteFrm.document.NotifiableNoteForm.tempAccession_Num.value='"+accession_num+"';"); //IN053733
							} //IN053733
							//IN067717 Start.
							else if(function_id.equals("BIRTH_REG_NOTES"))
							{	
								out.println("alert('"+error_msg.toString().replace("'", "")+"');");
								out.println("window.returnValue='"+accession_num+"###Success';");
							}
							//IN067717 End.
							//ML-MMOH-CRF-0356 [IN057193] - Start
							if(function_id.equals("DECEASEDFORM")&&(called_from.equals("DECEASEDFORM")) ||function_id.equals("DISCHARGE_SUMMARY")&&(called_from.equals("PEND_DISC_NOTE"))) {
									//.println("top.PendDiscSummDetailsFrame.document.forms(0).tempAccession_Num.value='"+accession_num+"';"); //IN053733
									out.println("window.returnValue='"+accession_num+"';");
							} 
							//ML-MMOH-CRF-0356 [IN057193] - End	
							//ML-MMOH-CRF-0362 [IN057201] - Start
							if(function_id.equals("REFERRAL_LETTER")&&(called_from.equals("REFFERAL_NOTE_FROM_PAS"))) {
									out.println("window.returnValue='"+accession_num+"';");
							} 
							//ML-MMOH-CRF-0362 [IN057201] - End		
							if(function_id.equals("SPCL_NOTE")&& (!field_ref.equals(""))){
									out.println("if (top.opener != null){");
									out.println("if (top.opener."+field_ref+" != null){");
									out.println("top.opener."+field_ref+".value='"+accession_num+"';}}");
									out.println("else{window.returnValue='"+accession_num+"';}");
							}
							//	out.println("top.opener."+field_ref+".value='"+accession_num+"';");
							//IN061988 starts
							if("PH_NOTES".equals(function_id) && "PH_NOTES".equals(called_from))
							{
								out.println("window.returnValue='"+accession_num+"';");
								out.println("window.close();"); //closing the PH window while recording the notes IN061959
							}
							//IN061988 ends	

								if(appl_task_id.equals("PROGRESS_NOTES"))
								{
									out.println("query_string = top.content.matFrame.maternityeventframe.tempmaternityMenu.queryString.value;");
									out.println("var sel_progression_no = top.content.matFrame.maternityeventframe.tempmaternityMenu.progression_select.value;");
									out.println("top.content.matFrame.maternitytreeframe.location.href = '../eCA/jsp/ProgressNotesMenu.jsp?'+query_string+'&sel_progression_no='+sel_progression_no;");

									/*
									if(error_msg.lastIndexOf("<br>") != -1)
									error_msg = error_msg.substring(0, error_msg.lastIndexOf("<br>"));

									out.println("alert('6..."+error_msg+"')"); */

									out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");

								}
							//IN038003	Starts
							//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms(0).accession_num.value='"+accession_num+"';");
							out.println("if(null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame){ ");
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].accession_num.value='"+accession_num+"';");
							out.println("}");
							out.println("else{");
							out.println("top.content.workAreaFrame.RecClinicalNotesHeaderFrame.document.forms[0].accession_num.value='"+accession_num+"';");

							
							out.println("}");
							//IN038003	Ends
							//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.disableButtons(false,'"+operation_mode+"');");
							//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms(0).event_date_time.disabled=true;");
							//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.chief_complaints.style.display='none'");

							if(!operation_mode.equals("UpdateRecord"))
							{//IN071264 Starts
							out.println("if(null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame && undefined!=top.content.workAreaFrame.RecClinicalNotesHeaderFrame && null!=top.content.workAreaFrame.RecClinicalNotesHeaderFrame.document && undefined!=top.content.workAreaFrame.RecClinicalNotesHeaderFrame.document){ ");
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.all.common_calander.disabled=true;");
								out.println("}");
							}//IN071264 Ends
							/* Commented On 30/03/2007 */
							//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms(0).performed_by_id.disabled=true;");
							//IN038003 Starts
							//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecControlFrame.location.href='../eCA/jsp/RecClinicalNotesSectionControl.jsp?accession_num="+accession_num+"&note_type="+note_type+"&operation_mode=sectionView&chk_Empty=true&Field_Ref=" + field_ref +"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&window_close=" + window_close+"&contr_mod_accession_num="+contr_mod_accession_num+"';"); //contr_mod_accession_num
							out.println("if(null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecControlFrame){ ");
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecControlFrame.location.href='../eCA/jsp/RecClinicalNotesSectionControl.jsp?accession_num="+accession_num+"&note_type="+note_type+"&operation_mode=sectionView&chk_Empty=true&Field_Ref=" + field_ref +"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&window_close=" + window_close+"&contr_mod_accession_num="+contr_mod_accession_num+"';"); //contr_mod_accession_num
							out.println("}");
							out.println("else{");
							out.println("top.content.workAreaFrame.RecClinicalNotesSecControlFrame.location.href='../eCA/jsp/RecClinicalNotesSectionControl.jsp?accession_num="+accession_num+"&note_type="+note_type+"&operation_mode=sectionView&chk_Empty=true&Field_Ref=" + field_ref +"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&window_close=" + window_close+"&contr_mod_accession_num="+contr_mod_accession_num+"';"); 
							
							out.println("}");
							//IN038003 End
							//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href='../eCA/jsp/NewRecClinicalNotesSection.jsp?accession_num="+accession_num+"&note_type="+note_type+"&operation_mode="+operation_mode+"&facility_id="+facility_id+"&encounter_id="+encounter_id+"&Field_Ref=" + field_ref + "';");

							out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");

							//Start[IN038003]
							//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms(0).sign.disabled=false;");
							out.println("if(null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame){ ");
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].sign.disabled=false;");
							out.println("}");
							out.println("else{");
							out.println("top.content.workAreaFrame.RecClinicalNotesToolbarFrame.document.forms[0].sign.disabled=false;");
							out.println("}");
							out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");
								if(appl_task_id.equals("PAT_HISTORY"))
								{
							out.println("if(undefined!= top.content && null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.frames[0]){");//IN037701
							out.println("var query_string = top.content.workAreaFrame.frames[0].document.forms[0].query_string.value;");
							out.println("}");
							out.println("else{");
							out.println("var query_string = parent.document.PatientSocialHistoryForm.query_string.value;");
							out.println("}");
								out.println("top.content.workAreaFrame.location.href = '../eCA/jsp/PatientSocialHistory.jsp?'+query_string;");
								
								}
								//End[IN038003]

						}
						else if((operation_mode.equals("Forward") || operation_mode.equals("Delete") || operation_mode.equals("MakeAsError") || operation_mode.equals("Review") || operation_mode.equals("SignOnModify") || operation_mode.equals("Sign")) && ( function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES")))
						{

							if(error_msg.lastIndexOf("<br>") != -1)
								error_msg = error_msg.substring(0, error_msg.lastIndexOf("<br>"));

							out.println("alert('" + error_msg.toString().replace("'", "")+ "');");
						/*	if(function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES"))
							{ */
								out.println("top.opener.location.reload();");
								out.println("top.opener.parent.frames[1].location.reload();");
								out.println("top.close();");
							/*}
							else
							{
								out.println("parent.window.close();");
							}*/
						}
						//else if( (operation_mode.equals("Forward") || operation_mode.equals("Delete") || operation_mode.equals("MakeAsError") || operation_mode.equals("Review") || operation_mode.equals("SignOnModify")) && (! (function_id.equals("NOTIFIABLEFORM"))) )//IN067717//IN67872
						else if( (operation_mode.equals("Forward") || operation_mode.equals("Delete") || operation_mode.equals("MakeAsError") || operation_mode.equals("REJECT")||operation_mode.equals("Review") || operation_mode.equals("SignOnModify")) && (! (function_id.equals("NOTIFIABLEFORM") || function_id.equals("BIRTH_REG_NOTES"))) )//IN067717//IN67872
						{

							if(appl_task_id.equals("PROGRESS_NOTES"))
								{
									out.println("query_string = top.content.matFrame.maternityeventframe.tempmaternityMenu.queryString.value;");
									out.println("var sel_progression_no = top.content.matFrame.maternityeventframe.tempmaternityMenu.progression_select.value;");
									out.println("top.content.matFrame.maternitytreeframe.location.href = '../eCA/jsp/ProgressNotesMenu.jsp?'+query_string+'&sel_progression_no='+sel_progression_no;");

									out.println("top.content.workAreaFrame.location.href = '../eCommon/html/blank.html';");

									/*
									if(error_msg.lastIndexOf("<br>") != -1)
									error_msg = error_msg.substring(0, error_msg.lastIndexOf("<br>"));

									out.println("alert('7..."+error_msg+"')"); */
									out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");

								}//IN061988 starts
								else if("PH_NOTES".equals(appl_task_id)&&("Delete".equals(operation_mode)||"MakeAsError".equals(operation_mode)))
								{
									if(error_msg.lastIndexOf("<br>") != -1)
										error_msg = error_msg.substring(0,error_msg.lastIndexOf("<br>"));
									//out.println("window.returnValue='MakeAsError';");
									//out.println("window.close();");
									out.println("alert('"+error_msg.toString().replace("'", "")+"');");
									out.println("top.window.returnValue='MakeAsError';");
									out.println("top.close()");
									out.println("top.window.close();");
								}
								else if("PH_NOTES".equals(appl_task_id)&&("SignOnModify".equals(operation_mode)))
								{
									if(error_msg.lastIndexOf("<br>") != -1)
									error_msg = error_msg.substring(0, error_msg.lastIndexOf("<br>"));

									out.println("alert('" + error_msg.toString().replace("'", "")+ "');");
									out.println("top.close()");
									out.println("top.window.close();");
								}
								//IN061988 ends
								else
								{

									if(error_msg.lastIndexOf("<br>") != -1)
										error_msg = error_msg.substring(0,error_msg.lastIndexOf("<br>"));


									out.println("alert('"+error_msg.toString().replace("'", "")+"');");
									out.println("top.close()");
									out.println("parent.window.close();");
									if(operation_mode.equals("REJECT") && function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES"))//IN67872, starts
									{
											out.println("top.opener.location.reload();");
											out.println("top.opener.parent.frames[1].location.reload();");//change frames(1) with frame name
											out.println("top.close();");
									}//IN67872, ends
								}
						}//IN061988 starts
						//else if( (operation_mode.equals("Forward") || operation_mode.equals("Delete") || operation_mode.equals("MakeAsError") || operation_mode.equals("Review") || operation_mode.equals("SignOnModify")) && (function_id.equals("NOTIFIABLEFORM")) )
						//else if( (operation_mode.equals("Forward") || operation_mode.equals("Delete") || operation_mode.equals("MakeAsError") || operation_mode.equals("Review") || operation_mode.equals("SignOnModify")) && (function_id.equals("NOTIFIABLEFORM")||"PH_NOTES".equals(function_id)) )//Commented for IN067717
						else if( (operation_mode.equals("Forward") || operation_mode.equals("Delete") || operation_mode.equals("MakeAsError") || "REJECT".equals(operation_mode) || operation_mode.equals("Review") || operation_mode.equals("SignOnModify")) && (function_id.equals("NOTIFIABLEFORM")||"PH_NOTES".equals(function_id)||function_id.equals("BIRTH_REG_NOTES")) )//Commented for IN067717//IN67872
						//IN061988 ends
						{

							if(error_msg.lastIndexOf("<br>") != -1)
								error_msg = error_msg.substring(0,error_msg.lastIndexOf("<br>"));

							if(function_id.equals("NOTIFIABLEFORM"))
							{
								//out.println("alert('"+operation_mode+"');");

								/*
								if(operation_mode.equals("Delete") || operation_mode.equals("MakeAsError"))
									out.println("top.opener.parent.RecDiagnosisAddModify.document.forms(0).accession_number.value='"+accession_num+"';");
								*/
								//IN053733 Start.
								if((operation_mode.equals("MakeAsError")||operation_mode.equals("Delete"))&&!"CANFREP".equals(notifiable_code)){
									String sessionNFKey = nf_patient_id+nf_encounter_id+"NFERROR";
									session.setAttribute(sessionNFKey, "MakeAsError");
								}
								//IN053733 End.
								out.println("alert('"+error_msg.toString().replace("'", "")+"');");
								out.println("top.close();");
							}//IN061988 starts
							//IN067717 Start.
							else if(function_id.equals("BIRTH_REG_NOTES"))
							{									
								out.println("alert('"+error_msg.toString().replace("'", "")+"');");
								if("Delete".equals(operation_mode)||"MakeAsError".equals(operation_mode))
									out.println("parent.window.returnValue='MakeAsError';");
								out.println("parent.window.close();");
							}
							//IN067717 End.
							else if("PH_NOTES".equals(function_id) && ("Delete".equals(operation_mode)||"MakeAsError".equals(operation_mode)))
							{
								
								out.println("alert('"+error_msg.toString().replace("'", "")+"');");
								out.println("parent.window.returnValue='MakeAsError';");
								out.println("parent.window.close();");
							}
							//IN061988 ends

						/*	out.println("var query_string = top.content.workAreaFrame.frames(0).document.forms(0).query_string.value;");
							out.println("top.content.workAreaFrame.location.href = '../eCA/jsp/RecClinicalNotes.jsp?operation_mode=&'+query_string;");
							out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");*/
						}

						out.println("</script>");
					}
					else
					{

						//out.println(error_msg);
					
						out.println("<script>");

						if(operation_mode.equals("ModifyAddendum"))			
						{
							out.println("var query_string = top.content.workAreaFrame.frames[0].document.forms[0].query_string.value;");

							out.println("query_string += '&callback_mode=Search';");

							out.println("alert('"+error_msg.toString().replace("'", "")+"')");
							out.println("top.content.workAreaFrame.location.href = '../eCA/jsp/RecClinicalNotes.jsp?'+query_string;");

						}
						else 
						{ 
							out.println("if('AutoSave'!='"+operation_mode+"' && 'SaveDraft'!='"+operation_mode+"' && 'AutoSaveUpdate'!='"+operation_mode+"' && 'SaveDraftUpdate'!='"+operation_mode+"'){"); 
							out.println("alert('"+error_msg.toString().replace("'", "")+"')");//--[IN033487]
							out.println("}");
							out.println("if(('AutoSaveUpdate'=='"+operation_mode+"' || 'SaveDraftUpdate'=='"+operation_mode+"') && 'PAT_HISTORY'=='"+appl_task_id+"'){"); 
							out.println("alert('APP-CA0150 Operation Completed Successfully')");//--[IN033487]
							out.println("}");
							//out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'");Commentted - [IN033487]

							//	out.println("alert(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame)");

							//out.println("if(!top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame)");
							//IN038493 Start
							out.println("var objFrame= eval('top.content.workAreaFrame.RecClinicalNotesFrame')");
						
							out.println("if(objFrame!=undefined){");

							// IN038493 end.
							out.println("if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame!=null){");//IN071264
							//IN071264 Starts
							
							out.println("if('AutoSave'!='"+operation_mode+"' && 'SaveDraft'!='"+operation_mode+"' && 'AutoSaveUpdate'!='"+operation_mode+"' && 'SaveDraftUpdate'!='"+operation_mode+"'){"); 
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.location.href = '../eCommon/html/blank.html' ");
							out.println("}");
							out.println("}");
							out.println("else{");						
							out.println("if('AutoSave'!='"+operation_mode+"' && 'SaveDraft'!='"+operation_mode+"' && 'AutoSaveUpdate'!='"+operation_mode+"' && 'SaveDraftUpdate'!='"+operation_mode+"' ){"); 
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.location.href = '../eCommon/html/blank.html' ");
							out.println("}");
							out.println("if('AutoSave'!='"+operation_mode+"' && 'SaveDraft'!='"+operation_mode+"' && 'AutoSaveUpdate'!='"+operation_mode+"' && 'SaveDraftUpdate'!='"+operation_mode+"'){"); 
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.EditorTitleFrame.location.href = '../eCommon/html/blank.html' ");
							out.println("}");
							out.println("}");
							//IN071264 Ends
							// IN048276 Start.
							//out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.reload();");
							
							String reqString = request.getQueryString(); 
							
							//IN071264 Starts
							out.println("var operation_mode_as = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.operation_mode_as.value");

							out.println("if('AutoSave'=='"+operation_mode+"' || 'AutoSaveUpdate'=='"+operation_mode+"' ){"); 
						
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num_auto.value='"+accession_num+"'");
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.operation_mode.value=''");
							
							out.println("if(operation_mode_as != 'ModifyAddendum'){");
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.prev_child_sec_hdg_code.value='"+prev_child_sec_hdg_code_as+"'");//IN071264
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.prev_sec_hdg_code.value='"+prev_sec_hdg_code_as+"'");//IN071264
							out.println("}");
							out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp'");
							//out.println("alert(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num_auto.value)");
							
							out.println("}else if('SaveDraft'=='"+operation_mode+"' || 'SaveDraftUpdate'=='"+operation_mode+"' ){");
							String error_msg_as = "Draft Record Saved Successfully";
							
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num_auto.value='"+accession_num+"'");
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.operation_mode.value=''");
							out.println("if(operation_mode_as != 'ModifyAddendum'){");
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.prev_child_sec_hdg_code.value='"+prev_child_sec_hdg_code_as+"'");//IN071264
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.prev_sec_hdg_code.value='"+prev_sec_hdg_code_as+"'");//IN071264
							out.println("}");
							out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg_as+"'");
							out.println("}else{");
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href='../eCA/jsp/RecClinicalNotesSection.jsp?"+reqString+"'");
							// IN048276 End.
							out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].sign.disabled=false;");
							out.println("}");
							//IN071264 Ends
							//IN038493 Start.
							out.println("}else{");
								out.println("if(top.content.workAreaFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame!=null)");
								out.println("top.content.workAreaFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.location.href = '../eCommon/html/blank.html' ");
								out.println("else");
								out.println("top.content.workAreaFrame.RecClinicalNotesSecDetailsFrame.location.href = '../eCommon/html/blank.html' ");
								
								out.println("top.content.workAreaFrame.EditorTitleFrame.location.href = '../eCommon/html/blank.html' ");							
								out.println("top.content.workAreaFrame.RecClinicalNotesSectionFrame.location.reload();");
								out.println("top.content.workAreaFrame.RecClinicalNotesToolbarFrame.document.forms[0].sign.disabled=false;");
							out.println("}");
							//IN038493 end.
							if(!operation_mode.equals("ModifySection") && !operation_mode.equals("ModifyAddendum") && !"AutoSave".equals(operation_mode) && !"SaveDraft".equals(operation_mode) && !"AutoSaveUpdate".equals(operation_mode) && !"SaveDraftUpdate".equals(operation_mode) )//IN071264 Starts
							{							
							//IN038493 Start.

								out.println("if(objFrame!=undefined){");
								out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].record.disabled=false;");
								out.println("}else{");
								out.println("top.content.workAreaFrame.RecClinicalNotesToolbarFrame.document.forms[0].record.disabled=false;");
								out.println("}");
							//IN038493 end.
							}
						}

						out.println("</script>");

						if( !((operation_mode.equals("Forward") || operation_mode.equals("Delete") || operation_mode.equals("MakeAsError") || operation_mode.equals("Review") || operation_mode.equals("SignOnModify")) && (function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES")  || function_id.equals("NOTIFIABLEFORM")))
						||
						( (!(operation_mode.equals("Forward") || operation_mode.equals("Delete") || operation_mode.equals("MakeAsError") || operation_mode.equals("Review") || operation_mode.equals("SignOnModify"))) && (function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES") || function_id.equals("NOTIFIABLEFORM")))
						||
						(!(operation_mode.equals("Forward") || operation_mode.equals("Delete") || operation_mode.equals("MakeAsError") || operation_mode.equals("Review") || operation_mode.equals("SignOnModify")) && function_id.equals("")) )
						{
							//out.println("<script language=\"javascript\">top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.disableButtons(false,'"+operation_mode+"');</script>");
							//out.println("<script language=\"javascript\">top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.link_doc.disabled	=true;</script>");
							//out.println("<script language=\"javascript\">top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.expandSectionFrames();</script>");
						}
					} // end of else
				}
				else if(doc_linked_note_yn.equals("Y"))
				{

					try
					{
						//RequestDispatcher disp = request.getRequestDispatcher("../eCA/jsp/NewRecClinicalNotesFileUploadError.jsp?err_num=" + java.net.URLEncoder.encode( error_msg.toString() ) +"&err_value="+inserted+"&operation_mode="+operation_mode+"&accession_num="+accession_num);
					}
					catch(Exception e)
					{
						e.printStackTrace();						
					}

					out.println("<script language=\"javascript\">");
					out.println("alert('"+error_msg.toString().replace("'", "")+"')");

					if (called_from.equals("CALLED_FROM_TOOLTIP"))
					{
						out.println("var query_string = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].query_string.value;");
						out.println("var note_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchCriteriaFrame.document.forms[0].note_type.value");
						out.println("query_string += '&note_type='+note_type;");
						out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.location.href  = '../eCA/jsp/RecClinicalNotesSearchResult.jsp?'+query_string");
					}

					// Added by Ambiga.M for 18712 on 2/24/2010
					out.println("if(top.content!=undefined){");
					out.println("if(top.content.messageFrame){");
					out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp'");// Added by Ambiga.M for 18712 on 2/24/2010
					out.println("}}");
					// Added by Ambiga.M ends
					if(function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES"))
					{
						out.println("top.opener.location.reload();");
						out.println("top.opener.parent.frames[1].location.reload();//}");
						out.println("top.close();");
					}
					else
					{
						out.println("parent.window.close();");
					}
					out.println("</script>");
				}	// end of else N
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception while accessing RecClinicalNotes EJB for Inseting Records!"+e);//common-icn-0181
			}
		}
		catch(Exception e)
		{
			//out.println("Exception@Insert:1 e : "+e);//common-icn-0181
			e.printStackTrace();
		}
		finally
		{
			/*out.println("<script>");		out.println("if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms(0).sign != null){top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms(0).sign.disabled=false;}");
			out.println("</script>");  */
			out.println("</body></html>");
			//IN67872 CS, starts
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
			//IN67872 CS, ends
		}
	} // end of method recordRecClinicalNotes

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
} // end of class RecClinicalNotesServlet
