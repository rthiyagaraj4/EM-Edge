package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotes.jsp", 1737343144922L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<!--IN032060 Start.-->\t\t\n\t\t\t<frameset rows=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" class=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" framespacing=\"0\" frameborder=\"0\" onLoad=\"clearMessageFrame()\">\n\t\t\t<frame name=\"RecClinicalNotesTabsFrame\" id=\"RecClinicalNotesTabsFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesTabs.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></frame>\n\t\t\t<frame name=\"RecClinicalNotesFrame\" id=\"RecClinicalNotesFrame\" frameborder=\"no\" scrolling=\"auto\" noresize src=\"../../eCA/jsp/RecClinicalNotesMain.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"></frame>\n\t\t\t</frameset>\n\t\t\t<!--IN032060 End.-->\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script>\t\t\t\t\n\t\t\t\tself.location.href = \"../../eCA/jsp/RecClinicalNotesSearchMain.jsp?accession_num=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&performed_by_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&operations_allowed=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&amendment_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&facility_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&note_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&function_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&patient_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&encounter_id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&res_encounter_id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&episode_type=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&patient_class=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&appl_task_id=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&dispResLinkHYMLYN=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\t\n\t\t\t<frameset rows=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></frame>\n\t\t\t</frameset>\t\t\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<frameset rows=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" framespacing=\"0\" frameborder=\"0\" onLoad=\"clearMessageFrame()\">\n\t\t<frame name=\"RecClinicalNotesTabsFrame\" id=\"RecClinicalNotesTabsFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesTabs.jsp?";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"></frame>\n\t\t<frame name=\"RecClinicalNotesFrame\" id=\"RecClinicalNotesFrame\" frameborder=\"no\" scrolling=\"auto\" noresize src=\"../../eCA/jsp/RecClinicalNotesMain.jsp?";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"></frame>\n\t\t</frameset>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</html>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

	public String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History	Name        Description
------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           created
29/06/2012	  	IN030468		Dinesh T	 BRUHIMS CRF.
04/12/2012		IN032060		Ramesh G	MO-CRF-20059[All the notes which are documented through OT slate when modified 
											by the user who has got privilege to Author and modify these notes and the note 
											type set up is amend original section the system does not store the original note 
											content which was modified. ]
19/12/2012		IN036726		Ramesh G	The Recorded Note cannot be viewed after recording in the following functions:
												1. Result Reporting
                                                2. Review Notes
                                                3. Sign Notes
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created 
30/04/2014  IN041284		 Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory� results in a clinical note section template does not display neatly .	
06/05/2015	IN053733		Ramesh G											When a notifiable recorded against a notifiable diagnosis is marked in error, 
																				the notification to be de-linked from the parent diagnosis
12/06/2015	IN055877		Ramesh G										MR Transaction ? Record Diagnosis ? Work Related Form -Webpage.
19/08/2015	IN054952		Karthi L										ML-BRU-SCF-1588
04/02/2016	IN057201		Karthi L										View Forwarded Referral Letter Under Consults
13/05/2016		IN059571	Ramesh G										Problem:Lab & Radiology Results are not transferring to CA screen, from yesterday nigh the background job was running.
22/5/2018	IN066108		Dinesh T	22/5/2018		Ramesh G		GHL-CRF-0497
20/07/2018	IN067717		Ramesh G	20/07/2018		Ramesh G		ML-MMOH-CRF-0898.1
27/05/2020		IN072879		SIVABAGYAM M		27/05/2020		RAMESH G		MMS-DM-SCF-0688
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	Connection				con			=	null;
	PreparedStatement		pstmt		=	null;
	ResultSet				rs			=	null;
	
	String	performed_by_id				=	"";
	String 	operations_allowed			=	"";
	String 	amendment_type				=	"";
	String 	function_id					=	"";
	String callback_mode					="";
	String 	facility_id					=	"";
	String	note_type					=	"";
	String 	patient_id					=	"";
	String 	encounter_id				=	"";
	String	operation_mode				=	"";
	String	accession_num				=	"";
	String	resp_id						=	"";
	String	clinician_id				=	"";
	String	login_user_id				=	"";
	String	frame_size					=	"";
	String	query_ca_note_param			=	"";
	String	episode_type			=	"";
	String	patient_class			=	"";
	String	appl_task_id			=	"";
	String	sql						=	"";
	String	contr_mod_accession_num	=	"";
	String  contr_oth_accession_num =   "";	//IN053733
	String	qs						=	"";
	String  notifiable_code			=	""; //IN053733
	String called_from				=	""; //IN053733
	String dispResLinkHYMLYN 		=   "N";  //IN041284
	String noteSplCharValidate		=   "N";  //IN059571
	boolean change_gui					= false;
	String show_others_unsinged_yn = "N";	//added for ML-BRU-SCF-1588 [IN054952]
	String senior_radiologist_yn = ""; //added for ML-BRU-SCF-1588 [IN054952]
	String deflt_search_mode_from_refral_yn = ""; //ML-MMOH-CRF-0362 [IN057201]		
	String l_inerror_access_yn = "N";//IN066108
	String l_sign_others_unsigned_notes_access_yn = "N";//IN066108
	String speciality_name="";//IN072879
	String sex = "";//IN072879
	String location_code = "";//IN072879
	con					=	ConnectionManager.getConnection(request);

	try
	{		

		facility_id			=	(String) session.getValue("facility_id");
		login_user_id		=	(String) session.getValue("login_user");
		resp_id				=	(String) session.getValue("responsibility_id");
		clinician_id		=	(String) session.getValue("ca_practitioner_id");

		callback_mode			=	checkForNull(request.getParameter("callback_mode"));

		function_id			=	checkForNull(request.getParameter("function_id"));
		accession_num		=	checkForNull(request.getParameter("accession_num"));
		note_type			=	checkForNull(request.getParameter("note_type"));
		operation_mode		=	checkForNull(request.getParameter("operation_mode"));
			
		patient_id			=	checkForNull(request.getParameter("patient_id"));
		encounter_id		=	checkForNull(request.getParameter("encounter_id"));
		episode_type		=	checkForNull(request.getParameter("episode_type"));
		patient_class		=	checkForNull(request.getParameter("patient_class"));
		appl_task_id		=	checkForNull(request.getParameter("appl_task_id"));
		contr_mod_accession_num		=	checkForNull(request.getParameter("contr_mod_accession_num"));
		contr_oth_accession_num		=	checkForNull(request.getParameter("contr_oth_accession_num")); //IN053733
		show_others_unsinged_yn = checkForNull(request.getParameter("show_others_unsinged_yn")); //added for ML-BRU-SCF-1588 [IN054952]
		senior_radiologist_yn = checkForNull(request.getParameter("senior_radiologist_yn")); //added for ML-BRU-SCF-1588 [IN054952] - Start
		sex = checkForNull(request.getParameter("Sex"));
		location_code = checkForNull(request.getParameter("location_code"));
		speciality_name=checkForNull(request.getParameter("speciality_name")); //IN072879
		if(senior_radiologist_yn.equals("") || senior_radiologist_yn == null) {
			senior_radiologist_yn = "N";
		}
		//added for ML-BRU-SCF-1588 [IN054952] - End
		deflt_search_mode_from_refral_yn = checkForNull(request.getParameter("deflt_search_mode_from_refral_yn")); //ML-MMOH-CRF-0362 [IN057201]		
		//IN053733 Start.
		notifiable_code = checkForNull(request.getParameter("notifiable_code"));
		if(!"".equals(notifiable_code)){
			note_type	=	checkForNull(request.getParameter("p_note_type"));
		}
		called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");  //IN053733 
		//IN053733 End.
		/*Added by Jyothi on 21/01/2010 at 6:39 PM for IN017835*/
		/*Accession number and operation mode were passed while calling from Task List function*/
		
		if(!contr_mod_accession_num.equals("") && accession_num.equals("")&&function_id.equals("TASK_LIST"))
		{
			sql = "select ACCESSION_NUM from ca_encntr_note where CONTR_MOD_ACCESSION_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,contr_mod_accession_num);
			rs = pstmt.executeQuery();
			if(rs.next())
				accession_num = rs.getString(1) == null ? "" : rs.getString(1);

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			if(!accession_num.equals(""))
				operation_mode = "Update";

			qs = request.getQueryString()+"&accession_num="+accession_num+"&operation_mode="+operation_mode;
		}
		else
			qs = request.getQueryString();

		/*Added by Jyothi on 21/01/2010 at 6:39 PM for IN017835 -- end */
		//IN066108, starts	
		pstmt = con.prepareStatement("select IN_ERROR_YN,UNSIGNED_ACCESS_YN from CA_NOTE_PARAM");
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			l_inerror_access_yn = rs.getString(1) == null ? "N" : rs.getString(1);
			l_sign_others_unsigned_notes_access_yn = rs.getString(2) == null ? "N" : rs.getString(2);
			System.out.println("l_inerror_access_yn=>"+l_inerror_access_yn+",l_sign_others_unsigned_notes_access_yn=>"+l_sign_others_unsigned_notes_access_yn);
		}
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		//IN066108, ends
		if (!accession_num.equals("") && operation_mode.equals(""))
		{
			//IN055877 Start.
			//query_ca_note_param =	"select  a.performed_by_id, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ) operations_allowed, b.ammendment_type from ca_encntr_note a, ca_note_type b where a.accession_num = ? and b.note_type = ? and a.event_status != '9' and a.note_type = b.note_type";//IN030468
			String queryCond ="";
			//if(!"".equals(contr_oth_accession_num) && "MR_DIAG".equals(called_from)){//IN067717
			if((!"".equals(contr_oth_accession_num) && "MR_DIAG".equals(called_from))||("BIRTH_REG_NOTES".equals(function_id))){//Modified for IN067717
				queryCond ="";
			}else{
				queryCond ="and b.note_type = ?";
			}
			//query_ca_note_param =	"select  a.performed_by_id, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ) operations_allowed, b.ammendment_type from ca_encntr_note a, ca_note_type b where a.accession_num = ? "+queryCond+" and a.event_status != '9' and a.note_type = b.note_type";//IN030468 // commented for ML-BRU-SCF-1588 [IN054952]
			//query_ca_note_param =	"select  a.performed_by_id, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?, ?) operations_allowed, b.ammendment_type from ca_encntr_note a, ca_note_type b where a.accession_num = ? "+queryCond+" and a.event_status != '9' and a.note_type = b.note_type"; // modified for ML-BRU-SCF-1588 [IN054952]//IN066108
			query_ca_note_param =	"select  a.performed_by_id, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?, ?,?,?) operations_allowed, b.ammendment_type from ca_encntr_note a, ca_note_type b where a.accession_num = ? "+queryCond+" and a.event_status != '9' and a.note_type = b.note_type"; // modified for ML-BRU-SCF-1588 [IN054952]//IN066108
			//IN055877 End.
			pstmt			=	con.prepareStatement(query_ca_note_param);
			System.out.println(" 148. RecClinicalNotes.jsp => " +  query_ca_note_param);
			int colIndex	=	0;			

			pstmt.setString( ++colIndex,	resp_id			);
			pstmt.setString( ++colIndex,	clinician_id	);
			pstmt.setString( ++colIndex,	login_user_id	);
			pstmt.setString( ++colIndex,	show_others_unsinged_yn	); // added for ML-BRU-SCF-1588 [IN054952]
			pstmt.setString( ++colIndex,	senior_radiologist_yn); // added for ML-BRU-SCF-1588 [IN054952]
			pstmt.setString( ++colIndex,	l_inerror_access_yn	); //IN066108
			pstmt.setString( ++colIndex,	l_sign_others_unsigned_notes_access_yn	); //IN066108
			//pstmt.setString( ++colIndex,	facility_id		);//IN030468
			pstmt.setString( ++colIndex,	accession_num	);
			System.out.println(" 158. RecClinicalNotes.jsp => resp_id" +  resp_id + " clinician_id " + clinician_id + " login_user_id " + login_user_id + " show_others_unsinged_yn " + show_others_unsinged_yn + " accession_num " + accession_num + " note_type " + note_type + " senior_radiologist_yn " + senior_radiologist_yn);
			//IN055877 Start.
			//pstmt.setString( ++colIndex,	note_type	);			
			//if(!"".equals(contr_oth_accession_num) && "MR_DIAG".equals(called_from)){//IN067717
			if((!"".equals(contr_oth_accession_num) && "MR_DIAG".equals(called_from))||("BIRTH_REG_NOTES".equals(function_id))){//Modified for IN067717
			}else{
				pstmt.setString( ++colIndex,	note_type	);
			}
			//IN055877 End.

			rs				=	pstmt.executeQuery();

			if( operation_mode.equals("Modify") || operation_mode.equals("ModifyAddendum") )
				change_gui			=	false;

			if(rs.next())
			{
				change_gui			=	true;
				performed_by_id		=	checkForNull(rs.getString("performed_by_id"));
				operations_allowed	=	checkForNull(rs.getString("operations_allowed"));
				amendment_type		=	checkForNull(rs.getString("ammendment_type"));
			}

			if(rs != null) rs.close();
			if(pstmt != null)pstmt.close();
    	}
		//IN041284 Start.		
		//IN059571 Start.
		//sql = "select DISP_RES_LINK_HTML_YN from CA_NOTE_PARAM";
		sql = "select DISP_RES_LINK_HTML_YN,NOTE_SPL_CHAR_VALD from CA_NOTE_PARAM";
		//IN059571 End.
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()){
			dispResLinkHYMLYN = rs.getString(1) == null ? "N" : (String) rs.getString(1);
			noteSplCharValidate = rs.getString(2) == null ? "N" : (String) rs.getString(2); //IN059571
		}
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		
		qs = qs+"&dispResLinkHYMLYN="+dispResLinkHYMLYN;
		qs = qs+"&noteSplCharValidate="+noteSplCharValidate; //IN059571
		//IN041284 End.
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
		if(function_id.equals("NOTIFIABLEFORM") ){
			frame_size	=	"3%,97%";
			
		}else{
			frame_size	=	"5%,93%";
		}
		
		if(function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES")){
			frame_size	=	"0%,100%"; //1%,99%			

	}
	if("Y".equals(deflt_search_mode_from_refral_yn)){ //ML-MMOH-CRF-0362 [IN057201] - Start
		qs =qs+"&callback_mode=Search";	
	}// ML-MMOH-CRF-0362 [IN057201] - End
	if(change_gui)
	{	//[IN036726] Start.		
		//if(function_id.equals("SPCL_NOTE") && appl_task_id.equals("OT_NOTES")){  //IN053733
		//IN061988 starts
		//if((function_id.equals("SPCL_NOTE") && appl_task_id.equals("OT_NOTES"))||(!"".equals(notifiable_code))){//IN053733
		//if((function_id.equals("SPCL_NOTE") && appl_task_id.equals("OT_NOTES"))||(!"".equals(notifiable_code))||(function_id.equals("PH_NOTES") && appl_task_id.equals("PH_NOTES"))){//IN053733
		if((function_id.equals("SPCL_NOTE") && appl_task_id.equals("OT_NOTES"))||(!"".equals(notifiable_code))||(function_id.equals("PH_NOTES") && appl_task_id.equals("PH_NOTES"))||(function_id.equals("BIRTH_REG_NOTES") && appl_task_id.equals("BIRTH_REG_NOTES"))){//Modified for IN067717
		//IN061988 ends
			qs =qs+"&callback_mode=Search"; //IN032060
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(frame_size));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getParameter("cname")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block13Bytes, _wl_block13);

		}else{
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(performed_by_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(operations_allowed));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(amendment_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dispResLinkHYMLYN));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		//[IN036726] End.
	}
	else if(function_id.equals("DECEASEDFORM") && appl_task_id.equals("DECEASEDFORM"))
	{	
		if(!"View".equals(callback_mode)){		
			if("Search".equals(callback_mode))
			qs =qs+"&callback_mode=Search"; 
			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(frame_size));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getParameter("cname")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block30Bytes, _wl_block30);

		}else if("View".equals(callback_mode)){
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(performed_by_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(operations_allowed));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(amendment_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dispResLinkHYMLYN));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
	}
	else
	{	
		
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(frame_size));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getParameter("cname")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block34Bytes, _wl_block34);

	}
		
            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalNotes.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
