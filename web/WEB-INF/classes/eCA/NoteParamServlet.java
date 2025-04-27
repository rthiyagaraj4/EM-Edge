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
?             100            ?           created
15/12/2011    IN029312      Menaka V 	 Incident No: IN029312 - <Report is printed either through
										 order tracking or clinical event history it prints without proper header and footer. This happens to all the reports defined as procedure note groups. > 
24/02/2012	 IN031116	  Ramesh G	     Report header is overlapping the hospital letter heads & deliverable.
15/03/2012	 IN030419	  Menaka V	  	 Clinical Note Logo Header and Report Header .
15/09/2012   IN029712	  Nijithas		 Spell check functionality implemented for section templates.
05/04/2013	 IN039182	  Chowminya G	 Restrict all users from result linking all diagnosis which are sensitive only  in the clinical notes
15/09/2012   IN043031	  Nijithas		 ML-BRU-SCF-0998.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		 Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory  results in a clinical note section template does not display neatly .	
05/02/2016	  IN004500		 Raja S										    GHL-SCF-1000
23/05/2016	  IN055439		 Karthi L										MO_CRF_20102
28/07/2016	  IN059747		 Karthi L										JD-CRF-0199
20/02/2017	  IN061882		 Karthi L									    ML-MMOH-CRF-0534 [IN061882]
10/05/2017    IN063865       Raja S		11/05/2017		Ramesh Goli			ML-MMOH-CRF-0534.1
18/05/2017    IN063798		 Raja S		22/05/2017		Ramesh Goli			ML-MMOH-CRF-0807
17/05/2018	  IN066108		Kamalakannan	25/01/2018		Ramesh		        GHL-CRF-0497
10/10/2018	  IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
18/03/2020	  IN071264		Nijitha S	    18/03/2020	Ramesh G	    GHL-CRF-0604
18/11/2020	  7605			SIVABAGYAM M		18/11/2020		RAMESH G	PMG2020-COMN-CRF-0085	
20/04/2021	  6484			Ramesh Goli		20/04/2021		RAMESH G			MO-CRF-20147.7 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class NoteParamServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		PrintWriter out = null;

		try
		{
			out = res.getWriter();
			insertEncounterParam(req, res, out);
		}
		catch(Exception e)
		{
			out.println("Exception in Main Block : "+e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req, res);

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/ecis.css'></link> <script src='../../eCommon/js/common.js' language='javascript'></script> <script language='javascript' src='../eMP/js/ActiveInactive.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");

	} catch(Exception e)
{	}
}

private void insertEncounterParam(HttpServletRequest req, HttpServletResponse res, PrintWriter out)	{

	java.util.Properties p;

	String module_id				= "CA";
	String days_back_date			= "";
	String mode						= "";
	String facilityId				= "" ;
	String client_ip_address		= "";
	String note_img_ref_folder		= "";
	String xsl_flder				= "";
	String file_size_unit			= "";
	String email_size_unit			= "";
	String print_discharge			= "";
	String print_eventheader			= "";//IN029312
	String hdrfoot_margin_val		= ""; //[IN031116]
	String LogoHeaderForAllPages			= "";//IN030419
	String ReportHeaderForAllPages			= "";//IN030419
	String ResultLinkSensiDiag			    = "";//IN039182
	String DisplayResultLinkinHTML		    = "N";//IN041284
	String displayDisclaimerTextPrinting	= "";//IN004500
	String locale					= "";
	String errorMsg					= "";
	String error_value				= "";
	/* Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500 */
	String maxNoImgAllowed			= "";
	// ends here.
	String vw_PREV_NOTE_DAYS = "0";// IN043031 
	String text_format_default_yn = ""; //  MO_CRF_20102[IN055439]  
	String amend_result_note_yn = "N"; //JD-CRF-0199 [IN059747]
	String disable_ref_range_yn	= "N"; //ML-MMOH-CRF-0534 [IN061882]
	String disable_spec_type_yn 	= "N"; //ML-MMOH-CRF-0534 [IN061882]
	String dateTimeFormat_yn	= "N";	//ML-MMOH-CRF-0534.1 [IN063865]
	int int_noOfEncounters		= 1; //ML-MMOH-CRF-0807[IN063798]
	String access_inError_yn	= "N";//IN066108
	String accessRightsUnsignedNotes_yn = "N";//IN066108
	String logo_header_width_no="";//IN068669
	String logo_header_hght_no=""; //IN068669
	String auto_Save_YN="N";//IN071264
	String auto_Save_Time		= "";//IN071264
	String display_note_description="";//7605
	String compress_note_content_YN="";//6484
	HttpSession session			= req.getSession(false);

	p					= (java.util.Properties) session.getValue( "jdbc" ) ;
	locale				= (String) p.getProperty("LOCALE");
	facilityId			= (String) session.getValue( "facility_id" ) ;
	client_ip_address	= p.getProperty("client_ip_address");
	mode				= req.getParameter("mode") != null ? req.getParameter("mode") : "";
	/* Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500 */
    maxNoImgAllowed		=	req.getParameter("txtMaxNoImgAllowed")==null?"":req.getParameter("txtMaxNoImgAllowed");
	// ends here.

	String spell_chk_def_opt = null;
	String spell_checker_yn = null;
	try
	{
		int ilDays_back_date = 0;
		int file_size = 0;

		try
		{
			print_discharge		=	req.getParameter("print_dischar");
			print_eventheader   =	req.getParameter("print_clinical_evt_hrd");//IN029312
			hdrfoot_margin_val	=	req.getParameter("hdrfoot_margin_val");//[IN031116]
			//IN030419 Starts
			LogoHeaderForAllPages   =	req.getParameter("print_logo_hdr_in_all_pages");
			ReportHeaderForAllPages   =	req.getParameter("print_rpt_hdr_in_all_pages");
			//IN030419 Ends
			days_back_date		=	req.getParameter("days_back_date");
			spell_checker_yn = req.getParameter("spell_checker_yn");//IN029712
			spell_chk_def_opt = req.getParameter("spell_chk_def_opt");//IN029712
			ResultLinkSensiDiag = req.getParameter("rstl_lnk_sensidiag_yn");//IN039182
			DisplayResultLinkinHTML = req.getParameter("display_result_linkin_HTML_yn");//IN041284
			vw_PREV_NOTE_DAYS = req.getParameter("vw_PREV_NOTE_DAYS");// IN043031 
			displayDisclaimerTextPrinting = req.getParameter("display_disclaimer_text_print"); //IN004500
			logo_header_width_no= req.getParameter("logo_header_width")==null?"40": req.getParameter("logo_header_width");//IN068669
			logo_header_hght_no= req.getParameter("logo_header_hght")==null?"40": req.getParameter("logo_header_hght");//IN068669
			// IN043031 Starts
			if(vw_PREV_NOTE_DAYS==null || "".equals(vw_PREV_NOTE_DAYS))
				vw_PREV_NOTE_DAYS="0";
			// IN043031 Ends
			text_format_default_yn 			= req.getParameter("text_format_default_yn")==null?"N":req.getParameter("text_format_default_yn");//  MO_CRF_20102[IN055439]
			amend_result_note_yn 			= req.getParameter("amend_result_note_yn") == null?"N":req.getParameter("amend_result_note_yn"); //JD-CRF-0199 [IN059747]
			disable_ref_range_yn	    	= req.getParameter("disable_ref_range_yn") == null?"N":req.getParameter("disable_ref_range_yn");//ML-MMOH-CRF-0534 [IN061882]
			disable_spec_type_yn  			= req.getParameter("disable_spec_type_yn") == null?"N":req.getParameter("disable_spec_type_yn");//ML-MMOH-CRF-0534 [IN061882]
			dateTimeFormat_yn		    	= req.getParameter("datetime_format_yn") == null?"N":req.getParameter("datetime_format_yn");//ML-MMOH-CRF-0534.1 [IN063865]	
			int_noOfEncounters		    	= Integer.parseInt((String)(req.getParameter("noofenc_copyprevnotes") == null?"1":req.getParameter("noofenc_copyprevnotes")));//ML-MMOH-CRF-0807 [IN063798]
			access_inError_yn		    	= req.getParameter("access_inError_yn") == null?"N":req.getParameter("access_inError_yn");//IN066108
			accessRightsUnsignedNotes_yn	= req.getParameter("accessRightsUnsignedNotes_yn") == null?"N":req.getParameter("accessRightsUnsignedNotes_yn");//IN066108
			//IN071264 starts
			auto_Save_YN					= req.getParameter("auto_Save_YN")==null?"N":req.getParameter("auto_Save_YN");//IN071264
			auto_Save_Time					= req.getParameter("auto_Save_Time")==null?"":req.getParameter("auto_Save_Time");//IN071264
			display_note_description		= req.getParameter("disp_note_description")==null?"N":req.getParameter("disp_note_description");//Exception-PMG2020-COMN-CRF-0085 --7605
			//IN071264 ends
			compress_note_content_YN		= req.getParameter("comp_note_content_YN")==null?"N":req.getParameter("comp_note_content_YN");//6484
			
			if(days_back_date == null)
				ilDays_back_date = 0;
			else
				ilDays_back_date = Integer.parseInt(days_back_date);

			file_size_unit = req.getParameter("file_size");

			if((file_size_unit == null)||file_size_unit.equals(""))
				file_size = 0;
			else
				file_size = Integer.parseInt(file_size_unit);
		}
		catch(Exception e)
		{
			e.printStackTrace();

			ilDays_back_date = 0;
			file_size = 0;
		}

		note_img_ref_folder				=	"";
		xsl_flder						=	req.getParameter("xsl_flder");
		email_size_unit					=	req.getParameter("email_size_unit");

		String addedById				=	(String) p.getProperty( "login_user" ) ;
		String modifiedById				=	addedById ;
		String addedFacilityId			=	facilityId;
		String modifiedFacilityId		=	facilityId ;
		String addedAtWorkstation		=	client_ip_address;
		String modifiedAtWorkstation	=	addedAtWorkstation ;

		HashMap tabdata					=	new HashMap();

		String condflds[]={};

		java.util.HashMap results = new HashMap();
		HashMap dupflds=new HashMap();

		tabdata.put("module_id",module_id);

		tabdata.put("days_backdate",new Integer(ilDays_back_date));
		tabdata.put("added_by_id",addedById);
		tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("added_facility_id", addedFacilityId);
		tabdata.put("added_at_ws_no",addedAtWorkstation);
		tabdata.put("modified_by_id",modifiedById);
		tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("modified_facility_id",modifiedFacilityId);
		tabdata.put("SPELL_CHK_REQ_YN",spell_checker_yn);//IN029712
		tabdata.put("SPELL_CHK_DEF_OPT",spell_chk_def_opt);//IN029712
		tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
		tabdata.put("NOTE_IMAGE_REP_FOLDER",note_img_ref_folder );
		tabdata.put("NOTE_LINKED_FILE_LIMIT",new Integer(file_size));
		tabdata.put("NOTE_LINKED_FILE_LIMIT_UNIT",email_size_unit );
		tabdata.put("XML_PARSER_FOLDER",xsl_flder );
		tabdata.put("PRINT_HDR_IN_DS_YN",print_discharge);
		tabdata.put("PRINT_HDR_IN_CEH_YN",print_eventheader);//IN029312
		tabdata.put("HDR_FT_MARGIN_IN_NOTE_YN",hdrfoot_margin_val);//[IN031116]
		//IN030419 Starts
		tabdata.put("LOGO_HDR_ALL_PAGE_YN",LogoHeaderForAllPages);
		tabdata.put("RPT_HDR_ALL_PAGE_YN",ReportHeaderForAllPages);
		//IN030419 Ends
		tabdata.put("LINK_SENST_DIAG_YN", ResultLinkSensiDiag); //IN039182
		tabdata.put("DISP_RES_LINK_HTML_YN",DisplayResultLinkinHTML);
		/* Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500 */
		tabdata.put("MAX_NO_IMG_ALLOWED", maxNoImgAllowed);
		// ends here.
		tabdata.put("VW_PREV_NOTE_DAYS", Integer.parseInt(vw_PREV_NOTE_DAYS));// IN043031
		tabdata.put("CEH_DISC_TEXT",displayDisclaimerTextPrinting); //IN004500
		tabdata.put("TEXT_FORMAT_DEFAULT_YN",text_format_default_yn);//  MO_CRF_20102[IN055439] 
		tabdata.put("AMEND_RESULT_NOTE_YN",amend_result_note_yn); //JD-CRF-0199 [IN059747]
		tabdata.put("disable_ref_range_yn",disable_ref_range_yn); //ML-MMOH-CRF-0534 [IN061882]
		tabdata.put("disable_spec_type_yn",disable_spec_type_yn); //ML-MMOH-CRF-0534 [IN061882]
		tabdata.put("DIS_REP_DATETIME_YN",dateTimeFormat_yn); //ML-MMOH-CRF-0534.1 [IN063865]
		tabdata.put("NO_OF_ENCOUNTERS",new Integer(int_noOfEncounters)); //ML-MMOH-CRF-0807 [IN063798]
		tabdata.put("IN_ERROR_YN",access_inError_yn); //IN066108
		tabdata.put("UNSIGNED_ACCESS_YN",accessRightsUnsignedNotes_yn); //IN066108
		tabdata.put("LOGO_HDR_HEIGHT",logo_header_hght_no);//IN068669
		tabdata.put("LOGO_HDR_WIDTH",logo_header_width_no); //IN068669
		tabdata.put("AUTO_SAVE_YN",auto_Save_YN);//IN071264
		tabdata.put("AUTO_SAVE_TIME",auto_Save_Time);//IN071264
		tabdata.put("DISP_NOTE_DESC",display_note_description);//7605
		tabdata.put("COMPRESS_NOTE_CONTENT_YN",compress_note_content_YN);//6484
		dupflds.put("module_id","CA");

		boolean local_ejbs = false;
		String table_data = "CA_NOTE_PARAM";

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
			local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;

		if(mode.equals("insert"))
			argArray[2] = condflds;
		else  if(mode.equals("update"))
			argArray[2] = dupflds;

		argArray[3] = table_data ;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();

		if(mode.equals("insert"))
			paramArray[2] = condflds.getClass();
		else if (mode.equals("update"))
			paramArray[2] = dupflds.getClass();

		paramArray[3] = table_data.getClass();

		if(mode.equals("insert"))
		 results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		else if(mode.equals("update"))
			 results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		tabdata.clear();
		dupflds.clear();
		argArray = null;
		paramArray = null;

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		errorMsg = (String) results.get("error") ;
		results.clear();
		error_value = "0" ;

		if ( inserted )
			error_value = "1" ;

		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ,"UTF-8") + "&err_value=" + error_value );
	}
	catch ( Exception e )
	{
		//out.println("Exception occured at Insert Block  : "+e.toString());//common-icn-0181
		e.printStackTrace();
	}
	}
}
