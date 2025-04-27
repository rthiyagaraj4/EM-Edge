<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
15/12/2011    IN029312      Menaka V 	    Incident No: IN029312 - <Report is printed either through
											order tracking or clinical event history it prints without proper header and footer. This happens to all the reports defined as procedure note groups. >
24/02/2012	 IN031116	  Ramesh G	  		Report header is overlapping the hospital letter heads & deliverable.
15/03/2012	 IN030419	  Menaka V	  		Clinical Note Logo Header and Report Header .
15/09/2012   IN029712	  Nijithas			Spell check functionality implemented for section templates.
12/03/2013	 IN038468	  Nijithas			Alpha-CA-Note Parameter settings are not saved properly	 	
05/04/2013	 IN039182	  Chowminya G		Restrict all users from result linking all diagnosis which are sensitive only ?in the clinical notes
15/09/2012   IN043031	  Nijithas		 ML-BRU-SCF-0998.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		 Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory? results in a clinical note section template does not display neatly .	
05/02/2016	  IN004500		 Raja S										    GHL-SCF-1000
23/05/2016	  IN055439		 Karthi L										MO_CRF_20102
28/07/2016	  IN059747		 Karthi L										JD-CRF-0199
20/02/2017	  IN061882		 Karthi L										ML-MMOH-CRF-0534 [IN061882]
10/05/2017    IN063865		 Raja S		11/05/2017		Ramesh Goli			ML-MMOH-CRF-0534.1
18/05/2017    IN063798		 Raja S		22/05/2017		Ramesh Goli			ML-MMOH-CRF-0807
12/02/2018	  IN063931		Prakash C	25/01/2018		Ramesh		        KDAH-CRF-0431
17/05/2018	  IN066108		Kamalakannan	25/01/2018		Ramesh		        GHL-CRF-0497
10/10/2018	  IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
18/03/2020	  IN071264		Nijitha S	 18/03/2020			Ramesh G	   GHL-CRF-0604
18/11/2020	  7605			SIVABAGYAM M		18/11/2020		RAMESH G	PMG2020-COMN-CRF-0085	
19/04/2021	  6484			Durga Natarajan		19/04/2021		RAMESH G	MO-CRF-20147.7 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*, eMR.*, eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>
<%
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	boolean isSiteSpecific  = false;//IN063931
%>
<html>
<head>
		<title><fmt:message key="eCA.Noteparameter.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

//String chekval	=(request.getParameter("chekval")==null)?"":request.getParameter("chekval");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/NoteParameter.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' onLoad="Focusing('days_back_date')">
<form name="note_param_form" id="note_param_form" action="../../servlet/eCA.NoteParamServlet" method="post" target="messageFrame">
 <%
try
{
		conlCon = ConnectionManager.getConnection(request);
		StringBuffer sblQry = new StringBuffer();
		String module_id = "";
		// Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500 
		String maxNoImgAllowed = "";
		// ends here.
		int days_backdate   = 0;
		
		String  note_img_ref_folder    = "";

		int file_size = 0;
		String mail_unit ="",xsl_flder="",print_hdr_in_ds_yn="Y",print_hdr_in_ds_checked = "checked";
		String print_hdr_in_ceh_yn="Y",print_hdr_in_ceh_checked = "checked";//IN029312
		//IN030419 Starts
		String print_logo_hdr_in_all_yn="Y",print_logo_hdr_in_all_checked = "checked";
		String print_rpt_hdr_in_all_yn="Y",print_rpt_hdr_in_all_checked = "checked";
		// IN029712 Starts
		String spell_checker_yn = "N", spell_checker_checked = "";
		String spell_checker_popup = "P";
		String spell_checker_inline = "I";
		String spell_checker_popup_checked = "";
	    String spell_checker_inline_checked = "";
	    String spell_chk_def_opt = null;
	 	// IN029712 Ends
		//IN030419 Ends
		String rstl_lnk_sensidiag_yn = "Y";//IN039182
		String lnk_sensidiag_checked = "";//IN039182
		String display_result_linkin_HTML_yn = "N";//IN041284
		String display_dis_text_print = ""; //IN004500
		String display_result_linkin_HTML_checked = ""; //IN041284
		String hdr_foot_mergin_yn="N",hdr_foot_mergin_checked = "";//[IN031116]
		String text_format_default_yn = ""; // MO_CRF_20102[IN055439]				
		String text_format_default_checked = "N"; // MO_CRF_20102[IN055439]	
		int vw_PREV_NOTE_DAYS=0;//IN043031		
		String amend_result_note_yn = "N"; //JD-CRF-0199 [IN059747]
		String amend_result_note_checked = ""; //JD-CRF-0199 [IN059747]
		//ML-MMOH-CRF-0534 [IN061882] - Start
		String disable_spec_type_yn = "N";
		String disable_spec_type_checked = "";	
		String disable_ref_range_yn = "N";
		String disable_ref_range_checked = "";
		String dateTimeFormat_yn = "N"; //Added for IN063865
		String dateTimeFormat_checked = ""; //Added for IN063865
		int noOfEncounters = 1; //Added for IN063798
		String access_inError_yn = "N";	 //IN066108
		String inError_checked = ""; //IN066108
		String accessRightsUnsignedNotes_yn = "N"; //IN066108
		String accessRightsUnsignedNotes_yn_checked = ""; //IN066108
		String logo_header_width="40";//IN068669
		String logo_header_hght="40"; //IN068669
		String autoSaveChk = "";//IN071264
		String auto_Save_YN = "";//IN071264
		String auto_Save_Time ="";//IN071264
		String display_note_description="";//7605
		String checknote="";//7605
		//ML-MMOH-CRF-0534 [IN061882] - End
		String compress_note_content_YN="";//6484
		String checkcompress="";//6484
		/* Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500
				added a new column for select query MAX_NO_IMG_ALLOWED */	
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN  FROM ca_note_param ");	//IN029312
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN FROM ca_note_param ");//IN030419		//CRF -001//IN039182 included LINK_SENST_DIAG_YN
		//IN041284 Start.
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS FROM ca_note_param ");//IN030419		//CRF -001//IN039182 included LINK_SENST_DIAG_YN				
		//IN041284 End.

		//IN004500 Start.
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN FROM ca_note_param ");
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT FROM ca_note_param ");	// commented for MO_CRF_20102[IN055439]			
		//IN004500 End.
		/*sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN FROM ca_note_param "); // MO_CRF_20102[IN055439]  */ //Commented for IN059747
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN FROM ca_note_param "); // modified for JD-CRF-0199 [IN059747] - Commented for ML-MMOH-CRF-0534 [IN061882]
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN FROM ca_note_param "); // modified for ML-MMOH-CRF-0534 [IN061882]
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN, DIS_REP_DATETIME_YN FROM ca_note_param "); // modified for ML-MMOH-CRF-0534.1[IN063865]
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN, DIS_REP_DATETIME_YN, NO_OF_ENCOUNTERS FROM ca_note_param "); // modified for ML-MMOH-CRF-0807[IN063798]// 
		 //sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN, DIS_REP_DATETIME_YN, NO_OF_ENCOUNTERS,IN_ERROR_YN,UNSIGNED_ACCESS_YN FROM ca_note_param ");//IN066108
		  //sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN, DIS_REP_DATETIME_YN, NO_OF_ENCOUNTERS,IN_ERROR_YN,UNSIGNED_ACCESS_YN,LOGO_HDR_WIDTH,LOGO_HDR_HEIGHT, AUTO_SAVE_YN, AUTO_SAVE_TIME FROM ca_note_param ");//IN068669//IN71264
		   sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN, DIS_REP_DATETIME_YN, NO_OF_ENCOUNTERS,IN_ERROR_YN,UNSIGNED_ACCESS_YN,LOGO_HDR_WIDTH,LOGO_HDR_HEIGHT, AUTO_SAVE_YN, AUTO_SAVE_TIME,DISP_NOTE_DESC,COMPRESS_NOTE_CONTENT_YN FROM ca_note_param ");//IN068669//IN71264//7605//6484

		pstmt = conlCon.prepareStatement( sblQry.toString());
		rslRst = pstmt.executeQuery();
		if(rslRst.next())
		{
			do
			{
				module_id = rslRst.getString("module_id");
				// Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500 
				maxNoImgAllowed = rslRst.getString("MAX_NO_IMG_ALLOWED")==null?"":rslRst.getString("MAX_NO_IMG_ALLOWED");
				logo_header_width=rslRst.getString("LOGO_HDR_WIDTH")==null?"40":rslRst.getString("LOGO_HDR_WIDTH");//IN068669
				logo_header_hght=rslRst.getString("LOGO_HDR_HEIGHT")==null?"40":rslRst.getString("LOGO_HDR_HEIGHT");//IN068669
				// ends here.
				auto_Save_YN				= rslRst.getString("AUTO_SAVE_YN")==null?"N":rslRst.getString("AUTO_SAVE_YN");//IN071264
				auto_Save_Time =        rslRst.getString("AUTO_SAVE_TIME")==null?"":rslRst.getString("AUTO_SAVE_TIME");//IN071264
				display_note_description=rslRst.getString("DISP_NOTE_DESC")==null?"":rslRst.getString("DISP_NOTE_DESC");//7605
				compress_note_content_YN=rslRst.getString("COMPRESS_NOTE_CONTENT_YN")==null?"":rslRst.getString("COMPRESS_NOTE_CONTENT_YN");//6484
				if(module_id == null) 
				{
					module_id = "";
				}
				days_backdate= rslRst.getInt("days_backdate");
				file_size= rslRst.getInt("NOTE_LINKED_FILE_LIMIT");
				mail_unit = rslRst.getString("NOTE_LINKED_FILE_LIMIT_UNIT");
				if(mail_unit == null) 
				{
					mail_unit = "";
				}
				note_img_ref_folder=rslRst.getString("NOTE_IMAGE_REP_FOLDER")==null?"":rslRst.getString("NOTE_IMAGE_REP_FOLDER");

				xsl_flder=rslRst.getString("XML_PARSER_FOLDER")==null?"":rslRst.getString("XML_PARSER_FOLDER");
					print_hdr_in_ds_yn=rslRst.getString("PRINT_HDR_IN_DS_YN");
					print_hdr_in_ceh_yn=rslRst.getString("PRINT_HDR_IN_CEH_YN");//IN029312
					//out.println("<script>alert('print_hdr_in_ds_yn"+print_hdr_in_ds_yn+"')</script>");
					if (print_hdr_in_ds_yn==null ||print_hdr_in_ds_yn.equals("N"))
								print_hdr_in_ds_checked="";
					else
							print_hdr_in_ds_checked="checked";	
					//IN029312 starts
					if (print_hdr_in_ceh_yn==null ||print_hdr_in_ceh_yn.equals("N"))
								print_hdr_in_ceh_checked="";
					else
							print_hdr_in_ceh_checked="checked";
					//IN029312 Ends

					//[IN031116] Start
					hdr_foot_mergin_yn=(rslRst.getString("HDR_FT_MARGIN_IN_NOTE_YN")==null)?"":rslRst.getString("HDR_FT_MARGIN_IN_NOTE_YN");
					if (hdr_foot_mergin_yn==null ||hdr_foot_mergin_yn.equals("N"))
							hdr_foot_mergin_checked="";
					else
							hdr_foot_mergin_checked="checked";	

					//[IN031116] Ends
					//IN030419 Starts
					print_logo_hdr_in_all_yn=rslRst.getString("LOGO_HDR_ALL_PAGE_YN");
					if (print_logo_hdr_in_all_yn==null ||print_logo_hdr_in_all_yn.equals("N"))
						print_logo_hdr_in_all_checked="";
					else
						print_logo_hdr_in_all_checked="checked";
					print_rpt_hdr_in_all_yn=rslRst.getString("RPT_HDR_ALL_PAGE_YN");
					if (print_rpt_hdr_in_all_yn==null ||print_rpt_hdr_in_all_yn.equals("N"))
						print_rpt_hdr_in_all_checked="";
					else
						print_rpt_hdr_in_all_checked="checked";
					//IN030419 Ends
					//IN029712 Starts
					spell_checker_yn = rslRst.getString("SPELL_CHK_REQ_YN");
					if(spell_checker_yn==null || spell_checker_yn.equals("N"))
						spell_checker_checked = "";
					else
						spell_checker_checked = "checked";
					spell_chk_def_opt = rslRst.getString("SPELL_CHK_DEF_OPT");
					if("P".equals(spell_chk_def_opt)){
						spell_checker_popup_checked = "checked";
					}else {
						spell_checker_popup_checked = "";
					}
					if("I".equals(spell_chk_def_opt))
						spell_checker_inline_checked = "checked";
					else
						spell_checker_inline_checked = "";
					//IN029712 Ends
					//IN039182 - Start
					rstl_lnk_sensidiag_yn=rslRst.getString("LINK_SENST_DIAG_YN");
					if (rstl_lnk_sensidiag_yn==null ||rstl_lnk_sensidiag_yn.equals("N"))
						lnk_sensidiag_checked="";
					else
						lnk_sensidiag_checked="checked";
					//IN039182 - End
					//IN071264 starts
					if(auto_Save_YN.equals("Y"))
						autoSaveChk="checked";
					if(auto_Save_YN.equals("N")){
						auto_Save_Time="";
					}
					//IN071264 ends
					
					//IN041284 Start.
					display_result_linkin_HTML_yn = rslRst.getString("DISP_RES_LINK_HTML_YN");
					if (display_result_linkin_HTML_yn==null ||display_result_linkin_HTML_yn.equals("N"))
						display_result_linkin_HTML_checked="";
					else
						display_result_linkin_HTML_checked="checked";
					//IN041284 End.
					//IN043031 Starts
					vw_PREV_NOTE_DAYS = rslRst.getInt("VW_PREV_NOTE_DAYS");
					//IN043031 Ends

					display_dis_text_print = rslRst.getString("CEH_DISC_TEXT")==null?"":rslRst.getString("CEH_DISC_TEXT");//IN004500
					// MO_CRF_20102[IN055439] - Start
					text_format_default_yn =  rslRst.getString("TEXT_FORMAT_DEFAULT_YN")==null ? "": rslRst.getString("TEXT_FORMAT_DEFAULT_YN");
					if("Y".equals(text_format_default_yn)){
						text_format_default_checked = "checked";
					} else {
						text_format_default_checked = "";
					} // MO_CRF_20102[IN055439]	- End
					
					//JD-CRF-0199 [IN059747] - Start
					amend_result_note_yn = rslRst.getString("AMEND_RESULT_NOTE_YN")==null?"N":rslRst.getString("AMEND_RESULT_NOTE_YN");
					if("Y".equals(amend_result_note_yn))
						amend_result_note_checked = "checked";
					else
						amend_result_note_checked = "";
					//JD-CRF-0199 [IN059747] - End	
					//ML-MMOH-CRF-0534 [IN061882] - Start
					
					disable_spec_type_yn = rslRst.getString("DISABLE_SPEC_TYPE_YN")==null?"N":rslRst.getString("DISABLE_SPEC_TYPE_YN");
					disable_ref_range_yn = rslRst.getString("DISABLE_REF_RANGE_YN")==null?"N":rslRst.getString("DISABLE_REF_RANGE_YN");
					if("Y".equals(disable_spec_type_yn))
						disable_spec_type_checked = "checked";
					else
						disable_spec_type_checked = "";
					if("Y".equals(disable_ref_range_yn))
						disable_ref_range_checked = "checked";
					else
						disable_ref_range_checked = "";	
					//ML-MMOH-CRF-0534 [IN061882] - End
					// ML-MMOH-CRF-0534.1[IN063865] Starts
					dateTimeFormat_yn = rslRst.getString("DIS_REP_DATETIME_YN")==null?"N":rslRst.getString("DIS_REP_DATETIME_YN");
					if("Y".equals(dateTimeFormat_yn))
						dateTimeFormat_checked = "checked";
					else
						dateTimeFormat_checked = "";	
					// ML-MMOH-CRF-0534.1[IN063865] Ends
					// ML-MMOH-CRF-0807[IN063798] Starts
					noOfEncounters = rslRst.getInt("NO_OF_ENCOUNTERS");
					// ML-MMOH-CRF-0807[IN063798] Ends
					//IN066108 starts
					access_inError_yn = rslRst.getString("IN_ERROR_YN")==null?"N":rslRst.getString("IN_ERROR_YN");
					if("Y".equals(access_inError_yn))
						inError_checked = "checked";
					else
						inError_checked = "";	
					accessRightsUnsignedNotes_yn = rslRst.getString("UNSIGNED_ACCESS_YN")==null?"N":rslRst.getString("UNSIGNED_ACCESS_YN");
					if("Y".equals(accessRightsUnsignedNotes_yn))
						accessRightsUnsignedNotes_yn_checked = "checked";
					else
						accessRightsUnsignedNotes_yn_checked = "";	
					//IN066108 ends
					//7605 starts
					if(display_note_description.equals("Y"))
						checknote="checked";
					else
						checknote="";
						//7605 ends
	  //6484 starts
					if(compress_note_content_YN.equals("Y"))
						checkcompress ="checked";
					else
						checkcompress ="";
	//6484 ends  
			}
			while(rslRst.next());
			out.println("<input type='hidden' name='mode' id='mode' value='update'>");
		}
		else
		{
			out.println("<input type='hidden' name='mode' id='mode' value='insert'>");
		}		
			if(rslRst!=null) rslRst.close();
			if(pstmt!=null) pstmt.close();		

%> <%
//IN063931 starts	
	try{
	isSiteSpecific = CommonBean.isSiteSpecific(conlCon, "CA","COPY_FROM_PREV_SECTION");
	}
	 catch(Exception e) {
        System.out.println("error:"+e.getMessage());
		e.printStackTrace();
    }
//IN063931 ends
%>
<BR><BR><BR><BR><BR>
	<table cellpadding='3' cellspacing='0' border='0' width='75%' align='center'>
	
	
	<tr>
	  <td width="25%" class="label"><fmt:message key="eCA.Backdate.label" bundle="${ca_labels}"/></td>
	  <td width="50%" colspan="2" class='fields'>&nbsp;<input type="text" name="days_back_date" id="days_back_date" size="2" maxlength="2" onKeyPress="return (allowValidNumber(this,event,2,0))" <% if(days_backdate != 0) {%> value = '<%= days_backdate %>' <% } %> OnBlur="checkSequence(this);CheckNum(this)" >&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'>
	  </td>
	</tr>

	<tr>
	  <td width="25%"  class="label"><fmt:message key="eCA.XSLfolder.label" bundle="${ca_labels}"/></td>
	  <td width="50%"  colspan="2" class='fields'>&nbsp;<input type='text'  name='xsl_flder' id='xsl_flder'  value ='<%=xsl_flder%>' size='50' maxlength='200'></td>
	</tr>

	<tr>
	  <td width="25%" class="label"><fmt:message key="eCA.FileSizeLimit.label" bundle="${ca_labels}"/></td>
	  <td width="50%" colspan="2" class='fields'>&nbsp;<input type="text" name="file_size" id="file_size" size="8" maxlength="8" onKeyPress="return (allowValidNumber(this,event,2,0))" <% if(file_size != 0) {%> value = '<%= file_size %>' <% } %> OnBlur="checkSequence(this);CheckNum(this);checkRange(this)" >
	  
	  

		  <select name="email_size_unit" id="email_size_unit" onchange='checkRange()'>

			  <%if(mail_unit.equalsIgnoreCase("") ){%>
		  <option value='K' selected>KB</option>
		   <option value='M'>MB</option></select></td>
			<%}%>
			<%if(mail_unit.equalsIgnoreCase("K") ){%>
		  <option value='K' selected>KB</option>
		   <option value='M'>MB</option></select></td>
			<%}%>
			
			<%if(mail_unit.equalsIgnoreCase("M") ){%>
		  <option value='K' >KB</option>
		  <option value='M'selected>MB</option></select></td>
			<%}%>
	</tr>

	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.PrintDischargeSummaryHeader.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="print_discharge" id="print_discharge" value ='<%=print_hdr_in_ds_yn%>'  <%=print_hdr_in_ds_checked%>   onclick="OndischargeChange(this)" ></td>
 	</tr>
	<!-- Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500 -->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.MaxNoImgAllowed.label" bundle="${ca_labels}"/></td>
		<td colspan="2" class='fields'>&nbsp;<input type="text" name='txtMaxNoImgAllowed' id='txtMaxNoImgAllowed' size='3' maxlength='2' onkeypress='return (allowValidNumber(this,event,2,0))' value='<%=maxNoImgAllowed%>' onblur='checkNumber(this)'></td>
 	</tr>
	<!--IN029312 Starts-->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.PrintEventHeaderinClinicalEventHistory.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="print_eventheader" id="print_eventheader" value ='<%=print_hdr_in_ceh_yn%>'  <%=print_hdr_in_ceh_checked%>   onclick="OnclinicalEvthdrChange(this)" ></td>
 	</tr>
	<!--IN029312 Ends-->
	<!-- ends here. -->
	<!--[IN031116] Starts-->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.HeaderFooterMargin.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="hdrfoot_margin" id="hdrfoot_margin" value ='<%=hdr_foot_mergin_yn%>'  <%=hdr_foot_mergin_checked%>   onclick="OnHdrFooterChange(this)" ></td>
 	</tr>
	<!--[IN031116] Ends-->
	<!-- IN030419 Starts -->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.LogoHeaderForAllPages.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="LogoHeaderForAllPages" id="LogoHeaderForAllPages" value ='<%=print_logo_hdr_in_all_yn%>'  <%=print_logo_hdr_in_all_checked%>   onclick="OnlogoHdrChange(this)" ></td>
 	</tr>
 	<!-- IN068669 starts -->
 	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.LogoHeadersizeDimensions.label" bundle="${ca_labels}"/></td>&nbsp;
		<td colspan="2" align='left'>
			<table cellpadding='0' cellspacing='0' border='0' width='250px'>
				<tr>
					<td width="15%" class="label" align='left'><fmt:message key="eCA.Height.label" bundle="${ca_labels}"/></td>
					<td width="20%" align='left'>
						<input type="text" name="logo_header_hght" id="logo_header_hght"  size='2' maxlength='2' onKeyPress="return (allowValidNumber(this,event,2,0))" value = '<%= logo_header_hght %>' onclick="OnlogoHdrChange(this)" onblur="checkNumberRange(this)">
					</td>
					<td width="10%" class="label" align='left'><fmt:message key="eCA.Px.label" bundle="${ca_labels}"/></td>	
					<td width="10%">&nbsp;&nbsp;</td>			
					<td width="15%" class="label"><fmt:message key="eCA.Width.label" bundle="${ca_labels}"/></td> 
					<td colspan="20%" align='left'>
						<input type="text" name="logo_header_width" id="logo_header_width"  size='2' maxlength='2' onKeyPress="return (allowValidNumber(this,event,2,0))" value ='<%=logo_header_width%>' onclick="OnlogoHdrChange(this)" onblur="checkNumberRange(this)">
					</td>
					<td width="10%" class="label" align='left'><fmt:message key="eCA.Px.label" bundle="${ca_labels}"/></td>
				</tr>
			</table>			
		</td>
	</tr>
 	<!-- IN068669ends -->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.ReportHeaderForAllPages.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="ReportHeaderForAllPages" id="ReportHeaderForAllPages" value ='<%=print_rpt_hdr_in_all_yn%>'  <%=print_rpt_hdr_in_all_checked%>   onclick="OnRptHdrChange(this)" ></td>
 	</tr>
 	<!-- IN029712 Starts -->
 	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.SpellChecker.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="SpellChecker" id="SpellChecker" value = <%=spell_checker_yn %> <%=spell_checker_checked %> onclick ="OnSpellCheckerChange(this)"></td>
	</tr>	
	<tr id="SpellCheckDefOptId" style="display:none">
		<td width="25%" class="label"><fmt:message key="eCA.DefaultSpellChecker.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left' class="label"><input type="radio" name="SpellCheckDefOpt" id="SpellCheckDefOpt" value=<%=spell_checker_popup %> id="pop" name="pop" <%=spell_checker_popup_checked %> onclick="spellCheckerDefaultChange(this)"> <fmt:message key="eCA.SpellCheckerPopUp.label" bundle="${ca_labels}"/></td>
	</tr>
	<tr id="SpellCheckDefOptId1" style="display:none">
		<td width="25%" class="label"></td>
		<td colspan="1" align='left' class="label"><input type="radio" name="SpellCheckDefOpt" id="SpellCheckDefOpt" value= <%=spell_checker_inline %> id="inl" <%=spell_checker_inline_checked%> onclick="spellCheckerDefaultChange(this)" ><fmt:message key="eCA.SpellCheckerInLine.label" bundle="${ca_labels}"/></td>
	</tr>
	<!-- IN029712 Ends -->
	<!-- IN030419 Ends -->
	<!-- IN039182 Start-->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.ResultLinkSensitiveDia.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="ResultLinkSensitiveDia" id="ResultLinkSensitiveDia" value = <%=rstl_lnk_sensidiag_yn %> <%=lnk_sensidiag_checked %> onclick ="linkSensitiveChange(this)"></td>
	</tr>	
	<!-- IN039182 Ends -->
	
	<!-- IN043031 -->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.MaxDaysViewPreviousNotes.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="text" name="vw_PREV_NOTE_DAYS" id="vw_PREV_NOTE_DAYS" size='3' maxlength='2' onkeypress='return (allowValidNumber(this,event,2,0))' value = <%=vw_PREV_NOTE_DAYS %> onblur='CheckPositiveNumber(this)'></td>
	</tr>	
	<!-- IN043031 Ends -->
	
	<!-- IN041284 Start -->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.DisplayResultLinkInHTML.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="display_result_linkin_HTML" id="display_result_linkin_HTML" value = <%=display_result_linkin_HTML_yn %> <%=display_result_linkin_HTML_checked %> onclick ="DisplayResultLinkinHTMLChange(this)"></td>
	</tr>
	<!-- IN004500 Start -->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.DisplayDisPrintText.label" bundle="${ca_labels}"/></td>
		 <td width="50%"  colspan="2" class='fields'>&nbsp;<input type='text' name='display_disclaimer_text_print' id='display_disclaimer_text_print'  value ='<%=display_dis_text_print %>' size='50' maxlength='250'></td>
	</tr>	
	<!-- IN004500 Ends -->
	<!-- IN041284 Ends -->
	<!--  MO_CRF_20102[IN055439]  Start --> 		
	<tr> 
		<td width="25%" class="label"><fmt:message key="eCA.TextFormatDflt.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="text_format_default_yn" id="text_format_default_yn" value = <%=text_format_default_yn%> <%=text_format_default_checked %> onclick ="checkTextFormatDflt(this)"></td>
	</tr>
	<!--  MO_CRF_20102[IN055439]  End -->

	<!-- JD-CRF-0199 [IN059747] - Start -->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.amendResultNote.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="amend_result_note_yn" id="amend_result_note_yn" value =<%=amend_result_note_yn%> <%=amend_result_note_checked%> onclick ="checkAmendClinResultNote(this)"></td>
	</tr>
	<!-- JD-CRF-0199 [IN059747] - End -->
	<!-- ML-MMOH-CRF-0534 [IN061882] - Start -->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.disprefrange.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="disable_ref_range_yn" id="disable_ref_range_yn" value =<%=disable_ref_range_yn%> <%=disable_ref_range_checked%> onclick ="checkDispRefRange(this)"></td>
	</tr>
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.dispspectype.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="disable_spec_type_yn" id="disable_spec_type_yn" value =<%=disable_spec_type_yn%> <%=disable_spec_type_checked%> onclick ="checkDispSpecType(this)"></td>
	</tr>		
	<!-- ML-MMOH-CRF-0534 [IN061882] - End -->
	<!-- ML-MMOH-CRF-0534.1 [IN063865] - Start -->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.datetimeformat.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="datetime_format_yn" id="datetime_format_yn" value =<%=dateTimeFormat_yn%> <%=dateTimeFormat_checked%> onclick ="checkDateTimeFormat(this)"></td>
	</tr>
	<!-- ML-MMOH-CRF-0534.1 [IN063865] - End -->
	<!-- KDAH-CRF-0431 [IN063931] - starts -->
	<%
	if(isSiteSpecific){%>
		<tr>
		<td width="25%" class="label"><fmt:message key="eCA.noofenccopyprevnotessec.label" bundle="${ca_labels}"/></td>
		<td width="50%"  colspan="2" class='fields'>&nbsp;<input type='text' name='noofenc_copyprevnotes' id='noofenc_copyprevnotes'  value ='<%=noOfEncounters%>' size='1' maxlength='1' onkeypress='return (allowValidNumber(this,event,1,0))' onblur='checkNumber(this)'></td>
	</tr>
<%}else{%>
	<!-- ML-MMOH-CRF-0807 [IN063798] - Start -->
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.noofenccopyprevnotes.label" bundle="${ca_labels}"/></td>
		<td width="50%"  colspan="2" class='fields'>&nbsp;<input type='text' name='noofenc_copyprevnotes' id='noofenc_copyprevnotes'  value ='<%=noOfEncounters%>' size='1' maxlength='1' onkeypress='return (allowValidNumber(this,event,1,0))' onblur='checkNumber(this)'></td>
	</tr>
<%}%>
<!-- IN066108 start -->
	
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.AccessRightsApplicabilityForInError.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="access_inError_yn" id="access_inError_yn" value =<%=access_inError_yn %> <%=inError_checked%> onclick ="checkInError(this)"></td>
	</tr>
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.AccessRightsApplicabilityForUnsignedNotes.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" name="accessRightsUnsignedNotes_yn" id="accessRightsUnsignedNotes_yn" value =<%=accessRightsUnsignedNotes_yn %> <%=accessRightsUnsignedNotes_yn_checked%> onclick ="checkUnsign(this)"></td>
	</tr>
	
	<!-- IN071264 starts -->
	
	<tr>
		<td width="25%" class="label"><fmt:message key="eCA.AllowAutoSaveInNotes.label" bundle="${ca_labels}"/></td>
		<td colspan="2" align='left'><input type="checkbox" id="allowAutoSaveInNotes_yn" name="auto_Save_YN" id="auto_Save_YN" value='<%=auto_Save_YN%>' onclick ="checkAutoSave(this)" <%=autoSaveChk%>></td>
	</tr>
	
	<tr id='allowAutoSaveForEvery' style="display:none;">
	  <td width="25%" class="label"><fmt:message key="eCA.AllowAutoSaveForEvery.label" bundle="${ca_labels}"/></td>
	  <td width="50%" colspan="2" class='fields'>&nbsp;<input type="text" name="auto_Save_Time" id="auto_Save_Time" value= '<%=auto_Save_Time%>' size="1" maxlength="1" onKeyPress="return isValidInteger();return allowValidNumber(this, event,1,0)" onBlur="copyPasteChk(this);checkForMandatory(this);" >&nbsp;<fmt:message key="eCA.minutes.label" bundle="${ca_labels}"/><img src='../../eCommon/images/mandatory.gif'>
	  </td>
	</tr>
	<!-- IN071264 ends -->
	<tr><!--7605 starts-->
	  <td width="25%" class="label"><fmt:message key="eCA.DisplayNoteDescription.label" bundle="${ca_labels}"/></td>
	  <td width="50%" colspan="2" class='fields'>&nbsp;<input type="checkbox" name="disp_note_description" id="disp_note_description" value= '<%=display_note_description%>' <%=checknote%> onclick="SelectBox(this);" >
	  </td>
	</tr><!--7605 ends-->
	<!-- 6484 starts -->
	<tr> 
	  <td width="25%" class="label"><fmt:message key="eCA.NoteContentCompressionRequired.label" bundle="${ca_labels}"/></td>
	  <td width="50%" colspan="2" class='fields'>&nbsp;<input type="checkbox" name="comp_note_content_YN" id="comp_note_content_YN" value= '<%=compress_note_content_YN%>' <%=checkcompress%> onclick="checkBox(this);" >
	  </td>
	</tr> 
	<!-- 6484 ends -->
	
	
	

<!-- IN066108 end -->	
	<!-- KDAH-CRF-0431 [IN063931] - End -->
	<!-- ML-MMOH-CRF-0807 [IN063798] - End -->
	</table>
	<input type=hidden name='notes_select_criteria' id='notes_select_criteria' value='D'>
	<input type=hidden name="note_img_ref_folder1" id="note_img_ref_folder1" value="">
	<!--<input type=hidden name="print_dischar" id="print_dischar" value='Y'>--><!-- IN038468 -->
	<input type=hidden name="print_dischar" id="print_dischar" value='<%=print_hdr_in_ds_yn%>'><!-- IN038468 -->
	<!--<input type=hidden name="print_clinical_evt_hrd" id="print_clinical_evt_hrd" value='Y'>--><!-- IN029312 -->
	<input type=hidden name="print_clinical_evt_hrd" id="print_clinical_evt_hrd" value='<%=print_hdr_in_ceh_yn%>'><!-- IN038468 -->
	<!--<input type=hidden name="hdrfoot_margin_val" id="hdrfoot_margin_val" value='N'> --><!-- [IN031116] -->
	<input type=hidden name="hdrfoot_margin_val" id="hdrfoot_margin_val" value='<%=hdr_foot_mergin_yn%>'>
	<!--<input type=hidden name="print_logo_hdr_in_all_pages" id="print_logo_hdr_in_all_pages" value='Y'>--><!-- IN030419 -->
	<input type=hidden name="print_logo_hdr_in_all_pages" id="print_logo_hdr_in_all_pages" value='<%=print_logo_hdr_in_all_yn%>'><!-- IN038468 -->
	<!--<input type=hidden name="print_rpt_hdr_in_all_pages" id="print_rpt_hdr_in_all_pages" value='Y'>--><!-- IN030419 -->
	<input type=hidden name="print_rpt_hdr_in_all_pages" id="print_rpt_hdr_in_all_pages" value='<%=print_rpt_hdr_in_all_yn%>'><!-- IN038468 -->
	<input type=hidden name="spell_checker_yn" id="spell_checker_yn" value=<%=spell_checker_yn %>><!-- IN029712 -->
	<input type=hidden name="spell_chk_def_opt" id="spell_chk_def_opt" value=<%=spell_chk_def_opt %>><!-- IN029712 -->
	<input type=hidden name="rstl_lnk_sensidiag_yn" id="rstl_lnk_sensidiag_yn" value=<%=rstl_lnk_sensidiag_yn %>><!-- IN039182 -->
	<input type=hidden name="display_result_linkin_HTML_yn" id="display_result_linkin_HTML_yn" value=<%=display_result_linkin_HTML_yn %>><!-- IN041284 -->
	<input type=hidden name="display_disclaimer_text_print" id="display_disclaimer_text_print" value=<%=display_dis_text_print %>><!-- IN004500 -->
	<input type=hidden name="logo_header_hght" id="logo_header_hght" value=<%=logo_header_hght%>><!-- IN068669 -->
	<input type=hidden name="logo_header_width" id="logo_header_width" value=<%=logo_header_width%>><!-- IN068669 -->
	<input type=hidden name="auto_Save_Time" id="auto_Save_Time" value="<%=auto_Save_Time%>"><!--IN071264-->
	<input type=hidden id="disp_note_description" name="disp_note_desc" id="disp_note_desc" value="<%=display_note_description%>"><!--Exception-PMG2020-COMN-CRF-0085-->
	<input type=hidden id="comp_note_content_YN" name="comp_note_cont" id="comp_note_cont" value="<%=compress_note_content_YN%>"><!--6484-->
</form>
<!-- IN029712 Starts-->
<script>
var spell_cheker_ = document.note_param_form.SpellChecker.value;
var spell_chk_opt_   = document.note_param_form.spell_chk_def_opt.value;
if(spell_cheker_ == 'Y'){	
	document.getElementById('SpellCheckDefOptId').style.display='';
	/* document.getElementById('SpellCheckDefOptId1').style.display=''; */
	if(spell_chk_opt_ == 'P')
		document.getElementById("SpellCheckDefOpt").checked=true;
	/* else if(spell_chk_opt_ == 'I')	
		document.getElementById("inl").checked=true; */
}
//IN071264 starts
if("Y"=='<%=auto_Save_YN%>')
	document.getElementById("allowAutoSaveForEvery").style='display';
else
		document.getElementById("allowAutoSaveForEvery").style.display='none';
//IN071264 ends
</script>
<!-- IN029712 Ends-->
</body>
</html>
<%
		
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in addNoteParam.jsp:"+e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);

}
%>

