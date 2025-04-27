<!DOCTYPE html>
<%
/*  
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100           ?          		created
14/07/2012	IN033487		Menaka V	 	CA> Record Clinical Note>After setup note to add 1 Note per
												Encounter but if users access to add same note in same time then system allow to record more than 1 note.							
17/12/2012  IN035950      	Nijitha        	CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.	
03/06/2013	IN040265		Ramesh G		Issue 1: At print preview the addendum details displayed as "Addendum Created by"  instead of "Addendum Recorded by"
												Issue 2: Addendum details  displayed twice.
03/06/2013	IN040266		Ramesh G		Issue 1: Record Clinical Notes->Search Tab->Update->System is displaying the updated text in different font in Print Preview and Print.
												Issue 2: Chart Summary->Lab Results->Note Type text data is displayed in different font.
												Issue 3: OT Surgeon Notes->System is displaying the text in different font in Print Preview and Print.
05/09/2013	IN043083		Chowminya G		Issue With NRIC in Medical Certificate Function													
17/12/2013	IN044085		Ramesh G		Bru-HIMS-CRF-024.2 										 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		 Ramesh G		30/04/2014		Sunil KV		The alignment for result Link for laboratory? results in a clinical note section template does not display neatly .	
02/06/2014	  IN037701		Nijitha											SKR-CRF-0036
05/05/2015	IN053298		Ramesh G		05/05/2015		Akbar S			When we attach an image to the clinical note part of the image is not displayed.
12/05/2015	IN053733		Ramesh G										Bru-HIMS-CRF-024.3
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template 
04/09/2015	IN057329		Ramesh G										In Modify Mode, when a note is having a single section,Copy from previous note button is not available.
01/02/2015 INT-CA005_CA	RAJA S											Script Error found issue which checking IE11 in Patient Assessment
13/05/2016		IN059571	Ramesh G										Problem:Lab & Radiology Results are not transferring to CA screen, from yesterday nigh the background job was running.
22/01/2018	IN063931		Prakash C		23/01/2018		Ramesh			KDAH-CRF-0431(Copy previous section)
15/02/2018	 IN063799		Prakash C		15/02/2018		Ramesh			ML-MMOH-CRF-0808
22/05/2018	 IN067607		Raja S			22/05/2018		Ramesh G		ML-MMOH-CRF-1130.2
27/07/2018	IN068105		Raja S			27/07/2018		Ramesh G		MMS-DM-CRF-0143
24/09/2018	IN068725		Raja S			24/09/2018		Ramesh G		MMS-ICN-00102
06/09/2019	IN071335	   	Ramesh G										Common-ICN-0012
9/9/2019	IN071291		Nijitha s		9/9/2019		Ramesh G		TBMC-SCF-0089
18/03/2020	IN071264		Nijitha S									GHL-CRF-0604
27/05/2020		IN072879		SIVABAGYAM M		27/05/2020		RAMESH G		MMS-DM-SCF-0688
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCA.*,java.awt.image.BufferedImage,javax.imageio.ImageIO,sun.misc.BASE64Decoder,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %><!--IN071264-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	eCA.PatientBannerGroupLine manageEmailBean = null; //IN052940
%>
<html>
<head>
	<title><fmt:message key="eCA.RichTextEditor.label" bundle="${ca_labels}"/></title>
	<%
		
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%> 
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/prototype.js'></script>
	<script>
	//IN041284 Start.
	//function showSectionTemplate_new(curr_sec_hdg_code,curr_section_type,curr_child_sec_hdg_code, template_title,patient_id,episode_id,sex,dob)
	//IN059571 Start.
	//function showSectionTemplate_new(curr_sec_hdg_code,curr_section_type,curr_child_sec_hdg_code, template_title,patient_id,episode_id,sex,dob,dispResLinkHYMLYN)
	function showSectionTemplate_new(curr_sec_hdg_code,curr_section_type,curr_child_sec_hdg_code, template_title,patient_id,episode_id,sex,dob,dispResLinkHYMLYN,noteSplCharValidate)
	//IN059571 End.
	//IN041284 End.	
	{	
		var arguments		=	"" ;		
		var action_url		=	'../../eCA/jsp/RecClinicalNotesTemplateMain.jsp';
		action_url			+=	"?curr_sec_hdg_code="+curr_sec_hdg_code+"&curr_section_type="+curr_section_type+"&curr_child_sec_hdg_code="+curr_child_sec_hdg_code+"&template_title="+template_title+"&operation_mode=&patient_id="+patient_id+"&episode_id="+episode_id+"&Sex="+sex+"&Dob="+dob;
		action_url			+="&dispResLinkHYMLYN="+dispResLinkHYMLYN;  //IN041284
		action_url			+="&noteSplCharValidate="+noteSplCharValidate;  //IN059571
		parent.RecClinicalNotesSecDetailsFrame.location.href	= action_url;
		parent.EditorTitleFrame.location.href = "../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?editor_title="+encodeURIComponent(template_title,"UTF-8");			
		setTimeout("fnEnableLinks()",1500);		
	}

	function fnEnableLinks(){	
		parent.frameSetIdMessage.rows='*%,0%'
		compressSectionFrames();
	}

	function callMeToGetEditor()
	{
		document.GetEditorForm.target = parent.RecClinicalNotesSecDetailsFrame.name;
		document.GetEditorForm.submit();
	}
	
	function changeEditorTitle_new(editor_title,image_linked_yn)
	{	
		parent.EditorTitleFrame.location.href = "../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?editor_title="+encodeURIComponent(editor_title,"UTF-8")+"&image_linked_yn="+image_linked_yn;
	}
	//function recordSectionDetails()//Commented for IN067607
	function recordSectionDetails(myHIXYNFLG)//IN067607
	{
		var noteType = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;//IN035950
		var notifiable_code = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.notifiable_code.value;//IN044085
		var notifiable_emailYN = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.notifiable_emailYN.value;//IN044085
		var noteCopiedYN =parent.RecClinicalNotesToolbarFrame.document.getElementById("noteCopiedYN").value;//IN068105
		var sexValue =parent.RecClinicalNotesHeaderFrame.document.getElementById("Sex").value;//IN072879
		var speciality_name =parent.RecClinicalNotesHeaderFrame.document.getElementById("speciality_name").value;//IN072879
		var location_code =parent.RecClinicalNotesHeaderFrame.document.getElementById("location_code").value;//IN072879
		//IN035950 Starts
		/*var noteType="";
		if(null!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm && null!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type)
		{
		noteType = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value
		}*/
		
		
		//IN035950 Ends
		var FieldRef = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.Field_Ref.value
		//IN071264 Starts
		var accession_num = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.accession_num.value;
		var accession_num_auto = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num_auto.value;
		var patient_id = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
		var encounter_id = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		var prev_sec_hdg_code = document.getElementById("prev_sec_hdg_code").value;
		var prev_child_sec_hdg_code = document.getElementById("prev_child_sec_hdg_code").value;
		if(undefined==accession_num_auto){
			
			accession_num_auto ="";
		}
		//IN071264 Ends
		var ContrAcc = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.contr_mod_accession_num.value
		var module_id = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.module_id.value
//		var Performed = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_id.value
//		var evtdttime = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.value
		//IN037701 Starts
		if(undefined!=parent.messageFrameReference)
			parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.target	=	parent.messageFrameReference.name;
		else
			parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.target	=	parent.messageframe.name;
		//IN037701 Ends
		//IN044085 Start.
		//parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action	=	'../../servlet/eCA.RecClinicalNotesServlet?note_type='+noteType+"&Field_Ref="+FieldRef +"&contr_mod_accession_num="+ContrAcc+'&module_id='+module_id;
		//parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action	=	'../../servlet/eCA.RecClinicalNotesServlet?note_type='+noteType+"&Field_Ref="+FieldRef +"&contr_mod_accession_num="+ContrAcc+'&module_id='+module_id+'&notifiable_code='+notifiable_code+'&notifiable_emailYN='+notifiable_emailYN;//Commented for IN067607
		//IN044085 End.
		//parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action	=	'../../servlet/eCA.RecClinicalNotesServlet?note_type='+noteType+"&Field_Ref="+FieldRef +"&contr_mod_accession_num="+ContrAcc+'&module_id='+module_id+'&notifiable_code='+notifiable_code+'&notifiable_emailYN='+notifiable_emailYN+'&myHIXYN='+myHIXYNFLG;//modified for IN067607//commented for IN068105
		//parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action	=	'../../servlet/eCA.RecClinicalNotesServlet?note_type='+noteType+"&Field_Ref="+FieldRef +"&contr_mod_accession_num="+ContrAcc+'&module_id='+module_id+'&notifiable_code='+notifiable_code+'&notifiable_emailYN='+notifiable_emailYN+'&myHIXYN='+myHIXYNFLG+'&noteCopiedYN='+noteCopiedYN+"&accession_num_auto="+accession_num_auto+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&prev_child_sec_hdg_code_as="+prev_child_sec_hdg_code+"&prev_sec_hdg_code_as="+prev_sec_hdg_code;//modified for IN067607 //modified for IN068105//Added for IN071264 //IN072879
		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action	=	'../../servlet/eCA.RecClinicalNotesServlet?note_type='+noteType+"&Field_Ref="+FieldRef +"&contr_mod_accession_num="+ContrAcc+'&module_id='+module_id+'&notifiable_code='+notifiable_code+'&notifiable_emailYN='+notifiable_emailYN+'&myHIXYN='+myHIXYNFLG+'&noteCopiedYN='+noteCopiedYN+"&accession_num_auto="+accession_num_auto+"&encounter_id="+encounter_id+"&prev_child_sec_hdg_code_as="+prev_child_sec_hdg_code+"&prev_sec_hdg_code_as="+prev_sec_hdg_code+'&location_code='+location_code+'&speciality_name='+speciality_name+'&Sex='+sexValue+"&patient_id="+patient_id;//modified for IN067607 //modified for IN068105//Added for IN071264 //IN072879
		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.method	=	'post';
		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.submit();
	}

	async function showLinkDocuments(sec_hdg_code, sec_content_type, child_sec_hdg_code, child_sec_content_type, result_linked_rec_type,image_linked_yn)
	{
		var episode_type	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.episode_type.value;
		var encounter_id	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		var patient_id		= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;

		var retVal				=	"";
		var dialogTop			=	"80" ;
		var dialogHeight		=	"30" ;
		var dialogWidth			=	"80" ;
		var status				=	"no";
		var arguments			=	"" ;
		var sql					=	"";
		var search_code			=	"";
		var search_desc			=	"";
		var title				=	"";
		var param				=	"";
		var action_url			=   "";
		

		action_url			=	'../../eCA/jsp/RecClinicalNotesLinkHistMain.jsp';
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		action_url			+=	"?result_linked_rec_type="+result_linked_rec_type+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&patient_id="+patient_id;

		if(image_linked_yn=='Y')
			var url = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.location.href;
		else
			var	url	=	parent.RecClinicalNotesSecDetailsFrame.location.href;

		if( (url.indexOf('/eCA/jsp/RTEditor.jsp')!=-1) )
		{
			if(image_linked_yn=='Y')
				parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.focus();
			else
				parent.RecClinicalNotesSecDetailsFrame.RTEditor0.focus();
		}
			
		retVal				= await	window.showModalDialog(action_url,arguments,features);
		
		if (retVal != null)
		{
			if( (url.indexOf('/eCA/jsp/RTEditor.jsp')==-1) )
			{
				await swapHeaderValues();
				await assignSectionDetails(sec_hdg_code,sec_content_type,child_sec_hdg_code, child_sec_content_type, result_linked_rec_type,'sectionEdit',doc_exists);
			}
			else
			{
				if(image_linked_yn=='Y')							
					var txtRange			=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.createTextRange();
				else
					var txtRange			=	parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.createTextRange();
				
				var section_content	=	txtRange.text;

				if(section_content.length>0)
				{
					if(result_linked_rec_type=='CLNT'||result_linked_rec_type=='MEDN'||result_linked_rec_type=='ALGY'||result_linked_rec_type=='DIAG' || result_linked_rec_type == 'PTCR' || result_linked_rec_type == 'LBIN' || result_linked_rec_type == 'LBRP'|| result_linked_rec_type == 'RDIN' || result_linked_rec_type == 'RDRP' || result_linked_rec_type == 'SUNT' || result_linked_rec_type == 'TRET' )
						retVal	= "<br>"+retVal;
					
				}
			
				if(result_linked_rec_type!="" && result_linked_rec_type!=null)
				{
					if(image_linked_yn=='Y')							
						parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",(retVal));
					else
						parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",(retVal));
				}
				else
				{
					if(image_linked_yn=='Y')
						parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.execCommand("paste","",retVal );
					else
						parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.execCommand("paste","",retVal );
				}			
			}
		}

		parent.RecClinicalNotesToolbarFrame.document.forms[0].link_doc.disabled = false;
}
	</script>
</head>
<%
	
	String		prev_sec_content_type					= "";
	String 		prev_sec_hdg_code						= "";
	String 		prev_child_sec_hdg_code					= "";
	String 		prev_result_link_type					= "";
	String 		ageDependentCompIds						= "";
	String 		compDependentAgeGrps					= "";
	String 		patient_id								= "";
	String 		ageDependentResults						= "";
	String 		no_of_rows								= "";
	String 		section_content							= "";
	String 		prev_image_linked_yn					= "";
	String 		prev_populated_section_tblrowID			= "";
	String 		strContentEditableYn					= "";
	String 		curr_section_type						= "";
	String 		url_for_details_frame					= "";
	String 		image_view_counter						= "";
	String 		encounter_id							= "";
	String 		template_title							= "";
	String 		curr_sec_hdg_code						= "";
	String 		curr_child_sec_hdg_code					= "";
	String 		grid_component_ids						= "";
	String 		section_image_content					= "";
	String 		section_image_height					= "";  //IN053298
	String 		curr_image_linked_yn					= "";
	String 		sec_content_type						= "";
	String 		editor_title							= "";
	String 		operation_mode							= "";
	String 		note_type								= "";
	String 		image_edited_yn							= "";
	String 		curr_result_link_type					= "";
	String 		curr_result_link_yn						= "";
	String		patient_class							= "";
	String		accession_num							= "";
	String		episode_type							= "";
	String		strRecFlag								= "";
	String		strKey									=	"";
	String		field_ref								=	"";
	String		contr_mod_accession_num					=	"";
	String 		contr_oth_accession_num					=	"";
	String		Sex										=	"";
	String		Dob										=	"";
	String		module_id								=	"";
	String		xslURL1  								=	"";
	String		xslURL									=	"";
	String		appl_task_id							=	"";
	String		selection_type							=	"";
	String		clear_values							=	"";
	String 		dispResLinkHYMLYN						=	""; //IN041284
	String 		noteSplCharValidate						=	"N"; //IN059571
	String		myHIXYN								=	"N";//IN067607
	Properties tempProp = null;
	String chk_Empty = "";
	Connection con = null;
	//IN033487 Starts
	//Connection con1 = null;commented for checkstyle
	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;
	//String note_group_id = "";commented for checkstyle
	//String no_of_rec_per_enc = "";commented for checkstyle
	//int record_cnt_for_enc = 0;commented for checkstyle
	//boolean search_screen_activated = false;commented for checkstyle
	//String msgfrom = "";commented for checkstyle
	String facility_id = "";
	//IN033487 ends
	String resp_id	= "";	//IN052940
	String previousNote_accession_num = "";  //IN052940
	String ca_disp_copy_prev_notes_yn = "";  //IN052940
	String call_for_copy_previous_sec 	= "";//IN063931
	String call_for_copy_previous_note 	= "";//IN063931
	String ca_disp_copy_prev_section_yn ="";//IN063931
	String display="";//IN063799
	String noteCopiedYN = "";//IN068105
	String speciality_name="",location_code="";//IN072879
//	int			exc										=	0;
//	int			exc1									=	0;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	facility_id		=	(String)session.getValue("facility_id");//IN033487
	resp_id		=	(String)session.getValue("responsibility_id");
	strRecFlag							=		checkForNull(request.getParameter("rec_flag"));
	prev_sec_hdg_code					=		checkForNull(request.getParameter("prev_sec_hdg_code"));
	prev_child_sec_hdg_code				=		checkForNull(request.getParameter("prev_child_sec_hdg_code"));
	patient_id							=		checkForNull(request.getParameter("patient_id"));
	section_content						=		checkForNull(request.getParameter("section_content"));
	prev_populated_section_tblrowID		=		checkForNull(request.getParameter("prev_populated_section_tblrowID"));
	image_view_counter					=		checkForNull(request.getParameter("image_view_counter"));
	encounter_id						=		checkForNull(request.getParameter("encounter_id"));
	template_title						=		checkForNull(request.getParameter("template_title"));
	curr_sec_hdg_code					=		checkForNull(request.getParameter("curr_sec_hdg_code"));
	curr_child_sec_hdg_code				=		checkForNull(request.getParameter("curr_child_sec_hdg_code"));
	grid_component_ids					=		checkForNull(request.getParameter("grid_component_ids"));
	section_image_content				=		checkForNull(request.getParameter("section_image_content"));
	section_image_height				= 		checkForNull(request.getParameter("section_image_height"));	//IN053298
	editor_title						=		checkForNull(request.getParameter("editor_title"));
	operation_mode						=		checkForNull(request.getParameter("operation_mode"));
	note_type							=		checkForNull(request.getParameter("note_type"));
	image_edited_yn						=		checkForNull(request.getParameter("image_edited_yn"));
	no_of_rows							=		checkForNull(request.getParameter("no_of_rows"));
	patient_class						=		checkForNull(request.getParameter("patient_class"));
	accession_num						=		checkForNull(request.getParameter("accession_num"));
	String accession_num_auto = checkForNull(request.getParameter("accession_num_auto"));//IN071264
	episode_type						=		checkForNull(request.getParameter("episode_type"));
	field_ref							=		checkForNull( request.getParameter("Field_Ref")	);
	noteCopiedYN						=		checkForNull( request.getParameter("noteCopiedYN")	); //IN068105
	speciality_name						=		checkForNull( request.getParameter("speciality_name")	); //IN072879	
	location_code						=		checkForNull( request.getParameter("location_code")	); //IN072879
	
	contr_mod_accession_num				=		checkForNull( request.getParameter("contr_mod_accession_num")	);
	contr_oth_accession_num				=		checkForNull( request.getParameter("contr_oth_accession_num")	); //IN053733
	Sex				=		checkForNull( request.getParameter("Sex")	);
	Dob				=		checkForNull( request.getParameter("Dob")	);
	module_id		=		checkForNull( request.getParameter("module_id")	);
	appl_task_id		=		checkForNull( request.getParameter("appl_task_id"));
	selection_type		=		checkForNull( request.getParameter("selection_type"));
	chk_Empty		=		request.getParameter("chk_Empty")==null?"false":request.getParameter("chk_Empty");
	clear_values		=		request.getParameter("clear_values")==null?"":request.getParameter("clear_values");
	dispResLinkHYMLYN	=	request.getParameter("dispResLinkHYMLYN")==null?"N":(String)request.getParameter("dispResLinkHYMLYN"); //IN041284
	noteSplCharValidate	=	request.getParameter("noteSplCharValidate")==null?"N":(String)request.getParameter("noteSplCharValidate"); //IN059571
	myHIXYN			=	request.getParameter("myHIXYN")==null?"N":(String)request.getParameter("myHIXYN"); //IN067607
	previousNote_accession_num = checkForNull( request.getParameter("previousNote_accession_num"));		 //IN052940
	call_for_copy_previous_sec	   = checkForNull( request.getParameter("call_for_copy_previous_sec"));//IN063931
	call_for_copy_previous_note	   = checkForNull( request.getParameter("call_for_copy_previous_note"));//IN063931
	display   =request.getParameter("display")==null?"Y":request.getParameter("display"); //IN063799
	if (encounter_id.equals(""))
		encounter_id = "0";
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session); //IN052940
	manageEmailBean.clearBean(); //IN052940
	ca_disp_copy_prev_notes_yn = manageEmailBean.getCopyPreviousNotesYN(resp_id, locale,note_type);
	ca_disp_copy_prev_section_yn = manageEmailBean.getCopyPreviousSectionYN(resp_id, locale,note_type);//IN063931
	// IN071335 Changes Start.
	//xslURL   = HttpUtils.getRequestURL(request).toString();
	//xslURL = xslURL.substring(0,xslURL.indexOf("jsp/"));
	xslURL	=  application.getRealPath("/eCA/")+"/";	
	// IN071335 Changes End.
	xslURL1 = xslURL + "html/RecClinicalNotesTemplateDispayView.xsl";
	


	try
	{
		//excepThrow();

		//exc1 = exc/0;
	
		con	= ConnectionManager.getConnection(request);
		
		strKey	= patient_id + "~"+encounter_id;
		strKey = strKey.trim();

		tempProp = sectionBean.getPatientSection(strKey);
			
		StringBuffer sectionContentXML	=	new StringBuffer();
		StringBuffer sbSecFormat		=	new StringBuffer();
		StringBuffer sbOutFormat		=	new StringBuffer();
		
		String contentXML="";
		StringBuffer contentOutXML = new StringBuffer();

		Hashtable htParameter=new Hashtable();
		Hashtable htPatdet=new Hashtable();
		Hashtable htOutParameter ;
		if(!(prev_sec_hdg_code.equals("")) || !(prev_child_sec_hdg_code.equals("")))
		{
			prev_sec_content_type		= sectionBean.getSectionType(prev_sec_hdg_code,prev_child_sec_hdg_code);
			
			prev_result_link_type		= sectionBean.getResultLinked(prev_sec_hdg_code,prev_child_sec_hdg_code);
			prev_image_linked_yn		= sectionBean.getImageLinked(prev_sec_hdg_code,prev_child_sec_hdg_code);
			
		}
		
		if(!(curr_sec_hdg_code.equals("")) || !(curr_child_sec_hdg_code.equals("")))
		{
			curr_section_type		= sectionBean.getSectionType(curr_sec_hdg_code,curr_child_sec_hdg_code);			
			curr_image_linked_yn	= sectionBean.getImageLinked(curr_sec_hdg_code,curr_child_sec_hdg_code);
			curr_result_link_yn		= sectionBean.getResultLinked(curr_sec_hdg_code,curr_child_sec_hdg_code);
			curr_result_link_type	= sectionBean.getHistoryType(curr_sec_hdg_code,curr_child_sec_hdg_code);
			
		}
		//IN068105 starts
		PreparedStatement psEncNote = null;
		ResultSet rsEncNote = null;
		try{

			psEncNote =	con.prepareStatement("SELECT NOTES_COPIED_YN FROM CA_ENCNTR_NOTE WHERE ACCESSION_NUM=?");
			psEncNote.setString(1,accession_num);			
			rsEncNote	= psEncNote.executeQuery();		
			if(rsEncNote.next())
			{
				noteCopiedYN=rsEncNote.getString("NOTES_COPIED_YN")==null?"N":rsEncNote.getString("NOTES_COPIED_YN");//IN068725
			}
		}
		catch(Exception m){
				m.printStackTrace();
		}
		finally{
					if(rsEncNote!=null) rsEncNote.close();
					if(psEncNote!=null) psEncNote.close();
		}
		//IN068105 ends
		if(prev_sec_content_type.equals("T"))
		{
			try
			{
			
			Enumeration enumParameter=request.getParameterNames();
			
			String parameterName="";
			String parameterValue="";
					
			while(enumParameter.hasMoreElements())
			{
				parameterName=(String)enumParameter.nextElement();
				
				parameterValue = request.getParameter(parameterName)==null?"":request.getParameter(parameterName);
				htParameter.put(parameterName, parameterValue);
				
			}
			
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				
			}
			
			htOutParameter = new Hashtable(htParameter);

			eCA.DomParser parser = new eCA.DomParser();
		
			contentXML=(String)sectionBean.getSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code);
						
		//	eCA.DomParser outparser = new eCA.DomParser();

			try
			{
				//con	= ConnectionManager.getConnection(request);

				if (contentXML == null || contentXML.equals("") )
				{
					contentXML = "";
					PreparedStatement psSec = null;
					ResultSet rsSec = null;
			
					String strSecGetQuery = "Select AGE_GRP_DEP_COMP_INFO,DEP_AGE_GRP_INFO,TEMPLATE_FORMAT from CA_SECTION_HDG where sec_hdg_code = ? ";
			
					psSec =	con.prepareStatement(strSecGetQuery);
					psSec.setString(1,prev_child_sec_hdg_code);			
					rsSec	= psSec.executeQuery();		
						
					if(rsSec.next())
					{
						ageDependentCompIds		= rsSec.getString(1)==null?"":rsSec.getString(1); 
						compDependentAgeGrps	= rsSec.getString(2)==null?"":rsSec.getString(2);
						Clob clb = rsSec.getClob(3);				
					
						if(clb!=null)
						{
							java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
							String line = null;
							
							while((line=r.readLine()) != null) 
							{
								sbSecFormat.append(line);
							}
						}
					}
					//check for the age group dependency and call a function to delete the component from the XML by parsing it
					if(rsSec!=null) rsSec.close();
					if(psSec!=null) psSec.close();

					PreparedStatement psage = null;
					ResultSet rsage = null;
	
					if(!ageDependentCompIds.equals(""))
					{
						String functionSQL = "Select ca_comp_visibility(?,?) from dual";
						psage =con.prepareStatement(functionSQL);

						psage.setString(1,compDependentAgeGrps);
						psage.setString(2,patient_id);
						rsage = psage.executeQuery();

						if(rsage.next())
						{
							ageDependentResults = rsage.getString(1);
							eCA.AgeGroupCodeDependencyParser ageGroupBeanObj=new eCA.AgeGroupCodeDependencyParser();
							sbSecFormat = ageGroupBeanObj.removeAgeDependentComponents(sbSecFormat,ageDependentCompIds,ageDependentResults);
						}
					}
					if(rsage!=null) rsage.close();
					if(psage!=null) psage.close();
				
					contentXML = sbSecFormat.toString();
				}
				if(!grid_component_ids.equals(""))
				{			
					eCA.GridComponent gridComp = new eCA.GridComponent();			
					contentXML = gridComp.updateXML(no_of_rows, contentXML).toString();			
					gridComp = null;
				}
				if (contentXML!= null && !contentXML.equals("") &&  clear_values.equals("clearTemplateValues"))
				{	
					htParameter = parser.clearComponentValues(new StringBuffer(contentXML),htParameter);
					htOutParameter = htParameter;
					
					//htParameter.clear();
					sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
				}

				sectionContentXML.append(contentXML);	
				StringBuffer sectionContentUpdatedXML=new StringBuffer();
				if(!sectionContentXML.toString().equals("") && sectionContentXML != null && !clear_values.equals("clearTemplateValues"))
				{ 						
					chk_Empty = parser.isTemplateEmpty(sectionContentXML,htParameter);							
					if(operation_mode.equals("") && chk_Empty.equals("false"))
					{						
						sectionBean.removeSectionContent( prev_sec_hdg_code,prev_child_sec_hdg_code);
					}
					
					
				//Added By Sridhar Reddy V on 13/05/2010 to restrict recording empty section.
					if(chk_Empty.equals("true"))
					{
						//***************************** [CRF-118] Start *****************************					
						eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
						HashMap paramHash=new HashMap();
						Hashtable tempParameter=new Hashtable();
						paramHash.put("#p_patient_id#",patient_id);
						paramHash.put("#p_encounter_id#",encounter_id);
						paramHash.put("#p_accNum#",accession_num);
						paramHash.put("#p_locale#",locale);
						tempParameter = dynamicCompDetails.getDynamicCompDetails(sectionContentXML,paramHash);
						if(tempParameter.size()>0){					
						htParameter.putAll(tempParameter);
						}
						//*****************************[CRF-118] Ends *****************************
						sectionContentUpdatedXML=parser.updateXMLContentValues(sectionContentXML,htParameter,locale);
						//sectionContentUpdatedXML=parser.removeEmptyValuesGridComp(sectionContentUpdatedXML); //Missing Grid rows
						sectionContentUpdatedXML=parser.displayGridCompYN(display,no_of_rows,sectionContentUpdatedXML);//IN063799
						sectionContentUpdatedXML=parser.displayMatrixCompYN(display,sectionContentUpdatedXML);//IN063799
					}
					
				}
				parser=null;				
				
				


				// new changes
					PreparedStatement pstmt = null;
					ResultSet rs = null;
				String output_yn =  "";

				output_yn = sectionBean.getOutputExistYN(prev_sec_hdg_code,prev_sec_hdg_code);
				if(output_yn.equals("Y") && !clear_values.equals("clearTemplateValues") && !sectionContentUpdatedXML.equals(""))
				{
					String output_format_qry ="select OUTPUT_XML_FORMAT from  CA_SEC_OUTPUT_FORM b where b.SEC_HDG_CODE =?" ;
					pstmt=	con.prepareStatement(output_format_qry);
					pstmt.setString(1,prev_sec_hdg_code);	
					rs	= pstmt.executeQuery();	

					if(rs.next())
					{
						
						Clob clb1 = rs.getClob("OUTPUT_XML_FORMAT");				
					
						if(clb1!=null)
						{
							java.io.BufferedReader r = new java.io.BufferedReader(clb1.getCharacterStream());
							String line = null;
							
							while((line=r.readLine()) != null) 
							{
								sbOutFormat.append(line);
							}
						}
					}
					
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					contentOutXML = sbOutFormat;

				}
				StringBuffer contentOutUpdatedXML = new StringBuffer();
				
				
				
			
			//	htParameter.put("C_MRFROM2","abcd");
			//	htParameter.put("C_MRTO3","efgh");
			
				
				htPatdet = sectionBean.getPatOutDetails(patient_id);
				
				if(htPatdet!=null)
				{
					htOutParameter.put("PATIENT_ID",htPatdet.get("PATIENT_ID"));
					htOutParameter.put("PATIENT_NAME",htPatdet.get("PATIENT_NAME"));
					//htOutParameter.put("REGN_DATE",htPatdet.get("REGN_DATE"));//TBMC-SCF-0089 Commented
					htOutParameter.put("REGN_DATE",getDateBasedOnLocale((String)htPatdet.get("REGN_DATE"),locale,"DMY"));//TBMC-SCF-0089
					htOutParameter.put("GENDER",htPatdet.get("GENDER"));
					htOutParameter.put("RESIDENTAIL_ADDRESS",htPatdet.get("RESIDENTAIL_ADDRESS"));
					htOutParameter.put("AGE",htPatdet.get("AGE"));
					htOutParameter.put("FACILITY_NAME",htPatdet.get("FACILITY_NAME"));
					//htOutParameter.put("DATE_OF_BIRTH",htPatdet.get("DATE_OF_BIRTH"));//TBMC-SCF-0089 Commented
					htOutParameter.put("DATE_OF_BIRTH",getDateBasedOnLocale((String)htPatdet.get("DATE_OF_BIRTH"),locale,"DMY"));//TBMC-SCF-0089
					htOutParameter.put("MAR_STATUS_CODE",htPatdet.get("MAR_STATUS_CODE"));
					htOutParameter.put("NATIONALITY_CODE",htPatdet.get("NATIONALITY_CODE"));
					htOutParameter.put("RH_FACTOR",htPatdet.get("RH_FACTOR"));
					htOutParameter.put("BLOOD_GRP",htPatdet.get("BLOOD_GRP"));
					htOutParameter.put("RES_AREA_CODE",htPatdet.get("RES_AREA_CODE"));
					htOutParameter.put("RES_TOWN_CODE",htPatdet.get("RES_TOWN_CODE"));
					htOutParameter.put("RELGN_CODE",htPatdet.get("RELGN_CODE"));
					htOutParameter.put("NAME_PREFIX",htPatdet.get("NAME_PREFIX"));
					htOutParameter.put("REGION_CODE",htPatdet.get("REGION_CODE"));
					htOutParameter.put("ENCOUNTER_ID",htPatdet.get("ENCOUNTER_ID"));
					htOutParameter.put("CURRENT_LOCATION",htPatdet.get("CURRENT_LOCATION"));
					htOutParameter.put("ATTENDING_PRACTITIONER",htPatdet.get("ATTENDING_PRACTITIONER"));
					//htOutParameter.put("ADMISSION_DATE",htPatdet.get("ADMISSION_DATE"));//TBMC-SCF-0089 Commented
					htOutParameter.put("ADMISSION_DATE",getDateBasedOnLocale((String)htPatdet.get("ADMISSION_DATE"),locale,"DMYHM"));//TBMC-SCF-0089 
					htOutParameter.put("SPECIALITY",htPatdet.get("SPECIALITY"));
					htOutParameter.put("PATIENT_CLASS",htPatdet.get("PATIENT_CLASS"));
					htOutParameter.put("ROOM_NUM",htPatdet.get("ROOM_NUM"));
					htOutParameter.put("BED_NUM",htPatdet.get("BED_NUM"));
					htOutParameter.put("SERVICE_CODE",htPatdet.get("SERVICE_CODE"));
					htOutParameter.put("ATT_PRACT_WITH_CREDENTIAL",htPatdet.get("ATT_PRACT_WITH_CREDENTIAL"));
					htOutParameter.put("PATIENT_NRIC",htPatdet.get("PATIENT_NRIC"));//IN043083

				}
				if(!contentOutXML.toString().equals("") && contentOutXML != null)
				{ 
					if(parser==null)
					{
						parser = new eCA.DomParser();	
					}								
					contentOutUpdatedXML=parser.updateXMLOutContentValues(sectionContentUpdatedXML,contentOutXML,htOutParameter,locale,xslURL1);								
				}
			

				String prev_sec_hdg_code_out ="";
				String prev_child_sec_hdg_code_out ="";

				prev_sec_hdg_code_out = prev_sec_hdg_code+"_out";
				prev_child_sec_hdg_code_out = prev_child_sec_hdg_code+"_out";

				
				


				// new changes ends..
				
				
				parser=null;
				sectionBean.setSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code,sectionContentUpdatedXML.toString());
				sectionBean.setSectionValues(prev_sec_hdg_code_out,prev_child_sec_hdg_code_out,"T","N","N","N","N","","N","N", contentOutUpdatedXML.toString(),"",output_yn);
				

			putObjectInBean("sectionBean",sectionBean,session);		
			}
			catch(Exception ex)
			{
				//out.println("Exception @ RecClinicalemplateCtrl"+ex.toString());//COMMON-ICN-0181
				ex.printStackTrace();
			}
			
		}//end of Template Based Sections
		else if(prev_sec_content_type.equals("F") || prev_sec_content_type.equals("R"))
		{			
			if(!(section_content.equals("")) )
			{				
				sectionBean.setSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code, "<ADDRESS>"+section_content+"<ADDRESS>"); //IN040265,IN040266
			}
			else if (section_content.equals("")&&( !(appl_task_id.equals("PAT_MEDICAL_REPORT")&&selection_type.equals("M"))) )
			{				
				sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
			}
			
			if(prev_image_linked_yn.equals("Y") && image_edited_yn.equals("Y")){
				sectionBean.setSectionImageContent(prev_sec_hdg_code,prev_child_sec_hdg_code,section_image_content);
				sectionBean.setSectionImageHeight(prev_sec_hdg_code,prev_child_sec_hdg_code,section_image_height);		//IN053298
			}
			putObjectInBean("sectionBean",sectionBean,session);
		}

		if(!section_content.equals("") && !prev_populated_section_tblrowID.equals(""))
		{
			out.println("<script>");
			out.println("var tblrow_id = eval(\"parent.RecClinicalNotesSectionFrame.document." + prev_populated_section_tblrowID + "\");");
			out.println("if(tblrow_id != null)");
			out.println("{");
			out.println("tblrow_id.cells(0).className = \"POPULATED_SECTION\";");
			out.println("}");
			out.println("</script>");
		}
		//IN052940 Start.
		if(!"".equals(previousNote_accession_num) && !"undefined".equals(previousNote_accession_num)){			
			//IN063931 start
			/*sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
			String	sql = "SELECT SEC_HDG_CODE,SUBSEC_HDG_CODE,NOTES_SECTION_CONTENT FROM CA_ENCNTR_NOTE_SECTION WHERE ACCESSION_NUM = ?";	
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1,previousNote_accession_num);*/
			
			if("Y".equals(call_for_copy_previous_note))
			{
				sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
				String	sql = "SELECT SEC_HDG_CODE,SUBSEC_HDG_CODE,NOTES_SECTION_CONTENT FROM CA_ENCNTR_NOTE_SECTION WHERE ACCESSION_NUM = ?";
	
				pstmt1 = con.prepareStatement(sql);
				pstmt1.setString(1,previousNote_accession_num);
			}
			if("Y".equals(call_for_copy_previous_sec))
			{
				sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
				String	sql_sec = "SELECT SEC_HDG_CODE,SUBSEC_HDG_CODE,NOTES_SECTION_CONTENT FROM CA_ENCNTR_NOTE_SECTION WHERE ACCESSION_NUM = ? and SEC_HDG_CODE= ?";
			
				pstmt1 = con.prepareStatement(sql_sec);
				pstmt1.setString(1,previousNote_accession_num);
				pstmt1.setString(2,prev_sec_hdg_code);
			}
			//IN063931 ends
			rs1 = pstmt1.executeQuery();			
			java.sql.Clob			clob_content	= null;
			while(rs1.next()){	
				String clobData="";			
				clob_content = (java.sql.Clob) rs1.getObject("NOTES_SECTION_CONTENT");
				if(clob_content!=null && clob_content.length() > 0){
					clobData = clob_content.getSubString(1,( (int)clob_content.length() ));
				}				
				sectionBean.setSectionContent((String) rs1.getString("SEC_HDG_CODE"),(String) rs1.getString("SUBSEC_HDG_CODE"),clobData);				
			}		
			
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
		
		}
		//IN052940 End.
	}
	
	catch(Exception e)
	{
		
		e.printStackTrace();
	}finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	
	// this code takes care of the display part of the current section.......
	try
	{
		section_content = "";		
		//IN071264 Starts
		String section_content_autosave_temp = "";
		String auto_save_yn ="N";
		CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
		auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
		//IN071264 Ends
		if(!curr_sec_hdg_code.equals("") && !curr_child_sec_hdg_code.equals(""))
		{
			/* section_content = (java.lang.String) sectionBean.getSectionContent(curr_sec_hdg_code,
					curr_child_sec_hdg_code); *///IN071264 
			 if("Y".equals(auto_save_yn) &&  (operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") || 
					operation_mode.equals("UpdateRecord") )){
				section_content_autosave_temp = (java.lang.String) sectionBean.getSectionContent("temp"+curr_sec_hdg_code,
						"temp"+curr_child_sec_hdg_code);
			}
			if(null!=section_content_autosave_temp && !"".equals(section_content_autosave_temp)){
				section_content = section_content_autosave_temp;
			}
			else{
				section_content = (java.lang.String) sectionBean.getSectionContent(curr_sec_hdg_code,
					curr_child_sec_hdg_code);
			}
			if(section_content == null || section_content.equals("") )
				section_content = "";
			
			section_content			=	java.net.URLEncoder.encode(section_content,"UTF-8");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
%>
 <BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<form name='RecClinicalNotesSecControlForm' id='RecClinicalNotesSecControlForm' method='post' >
	<input type='hidden' name='image_linked_yn' id='image_linked_yn' value='<%=curr_image_linked_yn%>'>
	<input type='hidden' name='operation_mode' id='operation_mode' value='<%=operation_mode%>'>
	<input type='hidden' name='curr_section_type' id='curr_section_type' value='<%=curr_section_type%>'>
	<input type='hidden' name='curr_result_link_type' id='curr_result_link_type' value='<%=curr_result_link_type%>'>
	<input type='hidden' name="section_image_content" id="section_image_content" >
	<input type='hidden' name="section_image_height" id="section_image_height" >  <!-- IN053298 -->
	<input type='hidden' name="section_content" id="section_content" >
	<input type = 'hidden' name = 'Field_Ref' value="<%=field_ref%>">
	<input type = 'hidden' name = 'contr_mod_accession_num' value="<%=contr_mod_accession_num%>">
	<input type = 'hidden' name='contr_oth_accession_num' id='contr_oth_accession_num' value="<%=contr_oth_accession_num %>">  <!-- IN053733 -->
	<input type='hidden' name='Sex' id='Sex' value='<%=Sex%>'>
	<input type='hidden' name='Dob' id='Dob' value='<%=Dob%>'>
	<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
	<input type='hidden' name='accession_num' id='accession_num' value='<%=accession_num%>'>
	<input type='hidden' name='dispResLinkHYMLYN' id='dispResLinkHYMLYN' value='<%=dispResLinkHYMLYN%>'> <!-- //IN041284 -->
	<input type='hidden' name='noteSplCharValidate' id='noteSplCharValidate' value='<%=noteSplCharValidate%>'> <!-- //IN059571 -->
		<input type='hidden' name='accession_num_auto' id='accession_num_auto'
			value='<%=accession_num_auto%>'>
		<input type='hidden' name='prev_sec_hdg_code' id='prev_sec_hdg_code'
			value='<%=prev_sec_hdg_code%>'>
				<input type='hidden' name='prev_child_sec_hdg_code' id='prev_child_sec_hdg_code'
			value='<%=prev_child_sec_hdg_code%>'>
		<!--IN071264-->
</form>
<%
//IN068105
if(noteCopiedYN.equals("Y")){
%>
<script>
	setTimeout("parent.RecClinicalNotesToolbarFrame.document.forms[0].noteCopiedYN.value='<%=noteCopiedYN%>';",1000);//IN068105
</script>
<%
}
//IN068105
	if(curr_section_type.equals("T"))
	{		
		%>
			<!-- <script language='javascript'>	-->
			<script>
			//IN041284 Start
			//var template_mode = 	showSectionTemplate_new("<%=curr_sec_hdg_code%>","<%=curr_section_type%>","<%=curr_child_sec_hdg_code%>","<%=editor_title%>","<%=patient_id%>","<%=encounter_id%>","<%=Sex%>","<%=Dob%>");
			//IN059571 Start.
			//var template_mode = 	showSectionTemplate_new("<%=curr_sec_hdg_code%>","<%=curr_section_type%>","<%=curr_child_sec_hdg_code%>","<%=editor_title%>","<%=patient_id%>","<%=encounter_id%>","<%=Sex%>","<%=Dob%>","<%=dispResLinkHYMLYN%>");
			var template_mode = 	showSectionTemplate_new("<%=curr_sec_hdg_code%>","<%=curr_section_type%>","<%=curr_child_sec_hdg_code%>","<%=editor_title%>","<%=patient_id%>","<%=encounter_id%>","<%=Sex%>","<%=Dob%>","<%=dispResLinkHYMLYN%>","<%=noteSplCharValidate%>");
			//IN059571 End.
			//IN041284 End.			
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%
	}
	else if(curr_section_type.equals("F") || curr_section_type.equals("R"))
	{		
		
		if(curr_image_linked_yn.equals("Y"))
		{
			url_for_details_frame = "../../eCA/jsp/RecClinicalNotesEditorsFrame.jsp?content_editable_yn="+strContentEditableYn+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&editor_param=I";
		}else if(appl_task_id.equals("PAT_MEDICAL_REPORT")&&selection_type.equals("M"))
		{
			
			url_for_details_frame = "../../eCA/jsp/RecClinicalNotesSectionView.jsp?note_type="+note_type+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&appl_task_id="+appl_task_id+"&selection_type="+selection_type;
				//+"&multi_sec_hdg_code="+multi_sec_hdg_code+"&multi_child_sec_hdg_code="+multi_child_sec_hdg_code;
		}
		else {
			
			url_for_details_frame = "../../eCA/jsp/RTEditor.jsp?content_editable_yn="+strContentEditableYn+"&editor_param=R";
		}
		putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session); //IN052940	
		%>

		<form name='GetEditorForm' id='GetEditorForm' method='post' action='<%=url_for_details_frame%>'>	
			<input type='hidden' name='RTEText' id='RTEText' value='<%=section_content%>'>
			<input type='hidden' name='image_linked_yn' id='image_linked_yn' value='<%=curr_image_linked_yn%>'>
			<input type='hidden' name='curr_sec_hdg_code' id='curr_sec_hdg_code' value='<%=curr_sec_hdg_code%>'>
			<input type='hidden' name='curr_child_sec_hdg_code' id='curr_child_sec_hdg_code' value='<%=curr_child_sec_hdg_code%>'>
			<input type='hidden' name='curr_section_type' id='curr_section_type' value='<%=curr_section_type%>'>
			<input type='hidden' name='curr_result_link_type' id='curr_result_link_type' value='<%=curr_result_link_type%>'>
			<input type='hidden' name='curr_result_link_yn' id='curr_result_link_yn' value='<%=curr_result_link_yn%>'>
			<input type='hidden' name='sec_hdg_code' id='sec_hdg_code' value='<%=sec_content_type.equals("S")?curr_child_sec_hdg_code:curr_sec_hdg_code%>'>
			<input type='hidden' name='ModuleID' id='ModuleID' value='CA'>
			

		</form>
		</body>
</html>
		<script language='javascript'>			
			changeEditorTitle_new("<%=editor_title%>","<%=curr_image_linked_yn%>");
			callMeToGetEditor();
		</script>

		<%
	}
	else if(operation_mode.equals("sectionView"))
	{ 			
		if(chk_Empty.equals("false") && prev_sec_content_type.equals("T") && !clear_values.equals("clearTemplateValues")){
		
		%>
					<script>		
					alert(getMessage("FILL_COMPONENT",'CA'));		
					
					var curr_sec_hdg_code = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById("sec_hdg_code").value;
					
					var curr_section_type = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById("sec_content_type").value;
					
					var curr_child_sec_hdg_code = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById("child_sec_hdg_code").value;
					
					var editor_title = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById("template_title").value;					
					
					assignSectionDetails(curr_sec_hdg_code,curr_child_sec_hdg_code,editor_title,'','sectionView');
					
					//Newly added  by Name :Selvin M  Date :16 june 2011 INCIDENT NO: 27228 Changes:newly added Starts
					parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='<b>Click on "Notes View" for "Record" & "SIGN" buttons</b>';
					//Ends
					setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].sign,false);	
					setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].record,false);
					setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].notesView,true);							
					parent.frameSetIdMessage.rows='*%,0%';

				</script>
		<% }else{ %>
						
					<script>									
					var multi_sec_hdg_code = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.multi_sec_hdg_code.value;
					var noteCopiedYN = parent.RecClinicalNotesToolbarFrame.document.forms[0].noteCopiedYN.value//IN068105
						var multi_child_sec_hdg_code = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.multi_child_sec_hdg_code.value
						parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record.disabled = false;//note missing changes
						parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign.disabled = false;//note missing changes
						//parent.RecClinicalNotesSecDetailsFrame.location.href = '../../eCA/jsp/RecClinicalNotesSectionView.jsp?note_type=<%=note_type%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&appl_task_id=<%=appl_task_id%>&selection_type=<%=selection_type%>&multi_sec_hdg_code='+multi_sec_hdg_code+'&multi_child_sec_hdg_code='+multi_child_sec_hdg_code;//Commented for IN068105
						parent.RecClinicalNotesSecDetailsFrame.location.href = '../../eCA/jsp/RecClinicalNotesSectionView.jsp?note_type=<%=note_type%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&appl_task_id=<%=appl_task_id%>&selection_type=<%=selection_type%>&multi_sec_hdg_code='+multi_sec_hdg_code+'&multi_child_sec_hdg_code='+multi_child_sec_hdg_code+'&noteCopiedYN='+noteCopiedYN;//modified for IN068105
						</script>				
	<%			
			}
	}
	else if(operation_mode.equals("Preview"))
	{		
		%>
			<script>			
			//var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;IN035950
			//IN035950 Start
			if(undefined!=top.content && null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame)
			{//IN037701
			var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;	
			}
			else
			{
				var Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;	
			}
			//IN035950 End
			var note_title			= "";
			var med_service			= "";
			var event_date_time		= "";
			var performed_by_name	= "";

			event_date_time		= Obj.event_date_time.value;
			performed_by_name	= Obj.performing_phy_name.value;
			note_title			= Obj.event_title_desc.value;

			if(Obj.serv_disp != null)
				med_service			= Obj.serv_disp.value;

			//var url ='../../eCA/jsp/RecClinicalNotesPrintPreview.jsp?note_type=<%=note_type%>&encounter_id=<%=encounter_id%>&episode_type=<%=episode_type%>&accession_num=<%=accession_num%>&patient_class=<%=patient_class%>&patient_id=<%=patient_id%>&note_title='+encodeURIComponent(note_title)+'&med_service='+encodeURIComponent(med_service)+'&event_date_time='+event_date_time+'&performed_by_name='+encodeURIComponent(performed_by_name); //[IN032721]
			//var url ='../../eCA/jsp/RecClinicalNotesPrintPreview.jsp?note_type=<%=note_type%>&encounter_id=<%=encounter_id%>&episode_type=<%=episode_type%>&accession_num=<%=accession_num%>&patient_class=<%=patient_class%>&patient_id=<%=patient_id%>&note_title='+encodeURIComponent(note_title)+'&med_service='+encodeURIComponent(med_service)+'&event_date_time='+event_date_time+'&performed_by_name='+encodeURIComponent(performed_by_name)+'&contr_mod_accession_num=<%=contr_mod_accession_num %>';  //[IN032721]//IN053733
			//var url ='../../eCA/jsp/RecClinicalNotesPrintPreview.jsp?note_type=<%=note_type%>&encounter_id=<%=encounter_id%>&episode_type=<%=episode_type%>&accession_num=<%=accession_num%>&patient_class=<%=patient_class%>&patient_id=<%=patient_id%>&note_title='+encodeURIComponent(note_title)+'&med_service='+encodeURIComponent(med_service)+'&event_date_time='+event_date_time+'&performed_by_name='+encodeURIComponent(performed_by_name)+'&contr_mod_accession_num=<%=contr_mod_accession_num %>&contr_oth_accession_num=<%=contr_oth_accession_num%>';  //IN053733 //commented for IN068105
			var url ='../../eCA/jsp/RecClinicalNotesPrintPreview.jsp?note_type=<%=note_type%>&encounter_id=<%=encounter_id%>&episode_type=<%=episode_type%>&accession_num=<%=accession_num%>&patient_class=<%=patient_class%>&patient_id=<%=patient_id%>&note_title='+encodeURIComponent(note_title)+'&med_service='+encodeURIComponent(med_service)+'&event_date_time='+event_date_time+'&performed_by_name='+encodeURIComponent(performed_by_name)+'&contr_mod_accession_num=<%=contr_mod_accession_num%>&contr_oth_accession_num=<%=contr_oth_accession_num%>&noteCopiedYN=<%=noteCopiedYN%>';  //modified for IN068105
			window.open(url,'Document','height=570,width=790,top=0,left=0,resizable=yes,scrollbars=yes' );  
			
			</script>
		<%
	}
	else if(strRecFlag.equals("") && (operation_mode.equals("Record") || operation_mode.equals("Sign") || operation_mode.equals("ModifySection")) )
	{
		%>
				<script>
					//recordSectionDetails();//Commented for IN067607
					recordSectionDetails('<%=myHIXYN%>');//Modified for IN067607
				</script>
				<%
		
		
		
		
	}else if(operation_mode.equals("Update")) {  %>
		
		<script>			
			//setTimeout("parent.RecClinicalNotesSecDetailsFrame.location.href = '../../eCA/jsp/RecClinicalNotesSectionView.jsp?note_type=<%=note_type%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>'",1500);//Commented for IN068105
			setTimeout("parent.RecClinicalNotesSecDetailsFrame.location.href = '../../eCA/jsp/RecClinicalNotesSectionView.jsp?note_type=<%=note_type%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&noteCopiedYN=<%=noteCopiedYN%>'",1500);//modified for IN068105
		//setButtonsforOperations("<%=operation_mode%>",true);
		</script>
<%}%>
<script>
<!-- IN057329 Start.  -->	
if ("<%=note_type%>" != "" && "<%=ca_disp_copy_prev_notes_yn%>"=="Y" && "<%=operation_mode%>"=="" )
{
	if(parent.RecClinicalNotesToolbarFrame.document.forms[0]!=null)  //INT-CA005_CA_Patient Assessment.docx  found issue which checking IE11
	setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Notes,true); 
}<!-- IN057329 End.  -->	
<!-- IN063931 Start.  -->	
if ("<%=note_type%>" != "" && "<%=ca_disp_copy_prev_section_yn%>"=="Y" && "<%=operation_mode%>"=="" )
{
	if(parent.RecClinicalNotesToolbarFrame.document.forms[0]!=null)    
	setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Section,true);
}
<!-- IN063931 End.  -->	
</script>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}	
//TBMC-SCF-0089 Start	
public String getDateBasedOnLocale(String date, String locale,String format) 
	{
	      String returnLocaledate ="";
	      try
				{
	    	      if(!"en".equals(locale))
	    	      {	  
					returnLocaledate  =  com.ehis.util.DateUtils.convertDate(date,format,"en",locale);	
	    	      }
	    	      else{
	    	    	  returnLocaledate = date;
	    	      }
				}
			catch(Exception e)
			{
				System.out.println("Exception  while geting SM_CONVERT_DATE_2T:"+e);
				e.printStackTrace();
			}
	     
		return returnLocaledate;
	}
	//TBMC-SCF-0089 End	
%>

