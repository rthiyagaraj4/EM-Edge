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

public final class __recprevioussectionsrchresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecPreviousSectionSrchResults.jsp", 1709116230262L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n<html>\n<head>\n\t<title>Recorded Previous Section Search Result</title>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesFileUpload.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n<script>\nfunction scrollTitleBar()\t//function to make the heading of the table static\n{\n\tvar scrollXY = document.body.scrollTop;\n\t\tdocument.getElementById(\"divTitleTable\").style.position = \'relative\';\n\t\tdocument.getElementById(\"divTitleTable\").style.posTop  = scrollXY-1;\t\t\n}\n</script>\t\n<style>\n\t\t.gridDataSelect\n\t\t{\n\t\t\theight:18px;\n\t\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\t\tfont-size: 8pt;\n\t\t\tcolor: #FFFFFF;\n\t\t\tfont-weight:normal;\n\t\t\ttext-align:left;\n\t\t\tpadding-left:10px;\n\t\t\tpadding-right:10px;\n\t\t\tvertical-align:middle;\n\t\t\tborder-bottom:1px;\n\t\t\tborder-top:0px;\n\t\t\tborder-left:0px;\n\t\t\tborder-right:0px;\t\n\t\t\tbackground-color: #2E9AFE;\t\n\t\t\tborder-style:solid;\n\t\t\tborder-color:#EEEEEE;\n\t\t}\n</style>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\' onScroll=\'scrollTitleBar()\'>\n<center>\n<form name=\'RecClinicalSectionSearchResultForm\' id=\'RecClinicalSectionSearchResultForm\' action=\"\" method=\"\" target=\"\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\t\t\t\t\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<table  class=\'gridComponentHolder\' WIDTH=\'100%\' align=\'center\'  >\n\t\t\t\t\t<tr><td CLASS=\'BODYCOLORFILLED\' >&nbsp;</td>\t\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<td class=\'LABEL\'  width=\'8%\'><a class=\'gridLink\' href=\"../../eCA/jsp/RecPreviousSectionSrchResults.jsp?lower_limit=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&upper_limit=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&note_group=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&note_type=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&curr_sec_hdg_code=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&curr_child_sec_hdg_code=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" style=\"text-decoration:none;  font-weight:bold\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<td class=\'LABEL\' align=\'center\' width=\'8%\'><a class=\'gridLink\' href=\"../../eCA/jsp/RecPreviousSectionSrchResults.jsp?lower_limit=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" style=\"text-decoration:none; font-weight:bold\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<table class=\'grid\' width=\'100%\'  align=\'center\' id=\"\">\n\t\t\t<tr id=\"divTitleTable\">\n\t\t\t\t<td class=\'columnheadercenter\'>Sections</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table class=\'grid\' width=\'100%\'  align=\'center\' id=\"tablePreRec\">\n\t\t\t\t<tr id=\"divTitleTable\">\n\t\t\t\t\t<td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t<td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t<td class=\'columnheadercenter\'>Note Type Desc</td>\n\t\t\t\t\t<td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onClick=\"showPreviousSectionView(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\" style=\'cursor:pointer\'>\n\t\t\t\t\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t</table>\n\t\t\t\t<input type=hidden name=query_string value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t<input type=hidden name=new_query_string value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t<input type=hidden name=notifiable_code value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t\n\t\t\t\t<input type=hidden name=accession_num value=\'\'>\n\t\t\t\t<input type=hidden name=function_id value=\'\'>\n\t\t\t\t<input type=hidden name=privilege_type value=\'\'>\n\t\t\t\t<input type=hidden name=forwarded_clinician_id value=\'\'>\n\t\t\t\t<input type=hidden name=action_comment value=\'\'>\n\t\t\t\t<input type=hidden name=performed_by_id value=\'\'>\n\t\t\t\t<input type=hidden name=operation_mode value=\'\'>\n\t\t\t\t<input type=hidden name=doc_linked_note_yn value=\'\'>\n\t\t\t\t<input type=hidden name=appl_task_id value=\'\'>\n\t\t\t\t<input type=hidden name=called_from value=\'\'>\t\n\t\t\t\t<input type=hidden name=rowCnt value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\t\n\t\t\t\t<input type=hidden name=curr_sec_hdg_code value=\'\'>\n\t\t\t\t<input type=hidden name=curr_child_sec_hdg_code value=\'\'>\n</form>\n</center>\n</body>\n</html>\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

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
Date		Edit History		Name	Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
24/01/2018	IN063931		Prakash C	25/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)								
------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection			con			=	null;

	PreparedStatement	pstmtcnt	=	null;
	ResultSet			rscnt		=	null;
	
	PreparedStatement   pstmtSec	= 	null;	
	ResultSet			rsSec		=	null;
	
	StringBuffer query_string		=	new StringBuffer();
	StringBuffer query_section_detail		=	new StringBuffer();

	String	function_id				=	"";
	String	classValue				=	"";
	String	facility_id				=	"";	
	String	note_type				=	"";	
	String	note_type_desc			=	"";
	String	note_group				=	"";		
	String	appl_task_id			=	"";		
	String	event_date_time			=	"";
	String	performed_by_name		=	"";
	String	authorized_by_name		=	"";
	String	status					=	"";	
	String	status1					=	"";
	String	tblrow_id				=	"";
	String	login_user_id			=	"";	
	String	clinician_id			=	"";
	String	resp_id					=	"";		
	String	patient_id				=	"";	
	String	encounter_id			=	"";
	String	episode_type			=	"";
	String	lower_limit				=	"";	
	String	upper_limit				=	"";
	String	from_date_time			=	"";	
	String	curr_sec_hdg_code		=	"";
	String 	curr_sec_accession_num	=	"";
	String 	curr_child_sec_hdg_code	=	"";
	String	to_date_time			=	"";
	String	event_status			=   "";	
	String	status_display_text		=	"";
	String	filter					=	"";
	String	patient_class			=	"";
	String	other_unsigned_yn		=	"";
	String	med_anc					=	"";
	String 	sec_hdg_code			=	"";
	String 	subsec_hdg_code			=	"";
	String	contr_mod_accession_num					=	"";
	String	performed_by			=	"";
	String	ref_no			=	"";
	String encline="";
	String oldEncline="";
	String speciality_code="";
	String p_called_from="";
	String notifiable_code = ""; 
	String nf_accession_num 	=""; 
	String called_from				=	""; 
	String p_event_class_widget	="";
	String encounter_desc	=	"";
	eCA.RecClinicalNotesPractBean pracObj = new eCA.RecClinicalNotesPractBean();
	
	java.sql.Clob	clob_notes_section_content_html	=	null;
	
	int		rowCnt					=	0,		maxRecordsDisp		=	10;
	int		startIndex				=	0,		endIndex			=	0;
	int		totalRecordCount		=	0;
	int		secIndex				=	0;

	patient_id			=	(request.getParameter("patient_id")==null) 		?	""	:	request.getParameter("patient_id");
	encounter_id		=	(request.getParameter("encounter_id")==null) 	?	""	:	request.getParameter("encounter_id");
	patient_class		=	(request.getParameter("patient_class")==null) 	?	""	:	request.getParameter("patient_class");
	episode_type		=	(request.getParameter("episode_type")==null) 	?	""	:	request.getParameter("episode_type");
	event_status		=	(request.getParameter("status")==null) 			?	"0"	:	request.getParameter("status");	
	filter				=	(request.getParameter("filter")==null) 			?	"A"	:	request.getParameter("filter");
	function_id			=	(request.getParameter("function_id")==null) 	? 	""	:	request.getParameter("function_id");
	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	lower_limit			=	(request.getParameter("lower_limit")==null)		?	"1"					:	request.getParameter("lower_limit");
	upper_limit			=	(request.getParameter("upper_limit")==null)		?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
	note_type			=   (request.getParameter("note_type")==null)		?	""	:	request.getParameter("note_type");
	note_group			=	(request.getParameter("note_group")==null)		?	""	:	request.getParameter("note_group");
	appl_task_id		=	(request.getParameter("appl_task_id")==null)	?	""	:	request.getParameter("appl_task_id");
	performed_by 		=   (request.getParameter("performed_by")==null)	?	""	:	request.getParameter("performed_by");
	med_anc 			=	(request.getParameter("med_anc")==null)			?	""	:	request.getParameter("med_anc");
	ref_no 				= 	(request.getParameter("ref_no")==null)			?	""	:	request.getParameter("ref_no");
	speciality_code 	= 	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");		
	notifiable_code		=	(request.getParameter("notifiable_code")==null)	?	""	:	request.getParameter("notifiable_code"); 
	nf_accession_num	=	(request.getParameter("accession_num")==null)	?	""	:	request.getParameter("accession_num"); 
	called_from			=	(request.getParameter("called_from")==null)		?	""	:	request.getParameter("called_from"); 
	
	p_called_from				=	(request.getParameter("p_called_from_widget")==null)	?	""	: request.getParameter("p_called_from_widget");
	p_event_class_widget 		= 	(request.getParameter("p_event_class_widget") == null) 	? 	"" 	: request.getParameter("p_event_class_widget");
	other_unsigned_yn			=	(request.getParameter("other_unsigned_yn")==null) 		?	"N"	: request.getParameter("other_unsigned_yn");
	contr_mod_accession_num 	= 	(request.getParameter("contr_mod_accession_num")==null)	?	""	: request.getParameter("contr_mod_accession_num");
	curr_sec_hdg_code			=	(request.getParameter("curr_sec_hdg_code")==null)	?	""	:	request.getParameter("curr_sec_hdg_code");
	curr_child_sec_hdg_code		=	(request.getParameter("curr_child_sec_hdg_code")==null)	?	""	:	request.getParameter("curr_child_sec_hdg_code");
	
	
	
	query_string.append("patient_id=");			query_string.append(patient_id);
	query_string.append("&encounter_id=");		query_string.append(encounter_id);
	query_string.append("&episode_type=");		query_string.append(episode_type);
	query_string.append("&function_id=");		query_string.append(function_id);
	query_string.append("&from_date_time="); 	query_string.append(from_date_time);
	query_string.append("&to_date_time="); 		query_string.append(to_date_time);
	query_string.append("&appl_task_id="); 		query_string.append(appl_task_id);
	query_string.append("&patient_class="); 	query_string.append(patient_class);
	query_string.append("&filter="); 			query_string.append(filter);
	query_string.append("&status="); 			query_string.append(event_status);
	query_string.append("&other_unsigned_yn="); query_string.append(other_unsigned_yn);
	query_string.append("&med_anc="); 			query_string.append(med_anc);
	query_string.append("&performed_by="); 		query_string.append(performed_by);
	query_string.append("&ref_no="); 			query_string.append(ref_no);
	query_string.append("&notifiable_code="); 	query_string.append(notifiable_code); 
	query_string.append("&called_from="); 		query_string.append(called_from); 
	query_string.append("&speciality_code="); 	query_string.append(speciality_code);


	from_date_time		= com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time		= com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	
	startIndex		=	Integer.parseInt(lower_limit);
	endIndex		=	Integer.parseInt(upper_limit);

	try
	{

		con				=	ConnectionManager.getConnection(request);

		String encounterList = "";
		if("DC".equals(patient_class) || "IP".equals(patient_class) )
		 encounterList = pracObj.getPreviousEncounter(patient_id,encounter_id,con);
		login_user_id	=	(String)		session.getValue("login_user");
		facility_id		=	(String)		session.getValue("facility_id");
		resp_id			=	(String)		session.getValue("responsibility_id");
		clinician_id	 =	(String)		session.getValue("ca_practitioner_id");

			
				query_section_detail.append("Select b.ACCESSION_NUM, b.SEC_HDG_CODE, b.SUBSEC_HDG_CODE, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, (select to_char(VISIT_ADM_DATE_TIME,'DD-MM-YYYY') || ' / ' || decode(patient_class, 'IP','Inpatient','OP','Outpatient','DC','Daycare','EM','Emergency') || ' / ' ||  encounter_id  || ' / ' || am_get_desc.am_speciality(SPECIALTY_CODE,'en',2) from pr_encounter where facility_id = a.facility_id and encounter_id= a.encounter_id) encounterdesc,(select note_type_desc from CA_NOTE_TYPE where note_type = a.note_type) note_type_desc, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ') authorized_by_name, a.event_status status, b.NOTES_SEC_CONT_HTML from CA_ENCNTR_NOTE a, CA_ENCNTR_NOTE_SECTION b where a. accession_num = b. accession_num  and b.SEC_HDG_CODE = ? and b.SUBSEC_HDG_CODE = ? and b.NOTES_SEC_CONT_HTML is not null");
				
				query_section_detail.append(" 	and a.event_status in ('4','5') ");
				if(!(from_date_time.equals("")))
					query_section_detail.append(" 	and a.event_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");
				if(!(to_date_time.equals("")))
					query_section_detail.append(" 	and a.event_date_time <= to_date( ?,'dd/mm/yyyy hh24:mi' )+0.00068287 ");
					query_section_detail.append(" and a.patient_id =? ");
				if("DC".equals(patient_class) || "IP".equals(patient_class) ){
					//query_section_detail.append(" and a.ENCOUNTER_ID in "+encounterList);//common-icn-0180 
					query_section_detail.append(" and a.ENCOUNTER_ID in "+encounterList);//common-icn-0180 
				}
				//query_section_detail.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");//common-icn-0180 
				query_section_detail.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT',?,?,a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");//common-icn-0180 
				
				query_section_detail.append("	order by event_date_time desc");
				
				
				pstmtSec = con.prepareStatement(query_section_detail.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				pstmtSec.setString( ++secIndex, locale);
				pstmtSec.setString( ++secIndex, locale);
				pstmtSec.setString( ++secIndex, curr_sec_hdg_code);
				pstmtSec.setString( ++secIndex, curr_child_sec_hdg_code);
				if(!(from_date_time.equals(""))){
					pstmtSec.setString	(	++secIndex,	from_date_time	);
				}
				if(!(to_date_time.equals(""))){
					pstmtSec.setString( ++secIndex, to_date_time);
				}
				pstmtSec.setString( ++secIndex, patient_id);
				//common-icn-0180 starts
				if("DC".equals(patient_class) || "IP".equals(patient_class) ){
					pstmtSec.setString( ++secIndex, encounterList);
				}
				pstmtSec.setString( ++secIndex, clinician_id);
				pstmtSec.setString( ++secIndex, resp_id);
				//common-icn-0180 ends
				rsSec = pstmtSec.executeQuery();
				
		if(!(rsSec.next())){
		
            _bw.write(_wl_block8Bytes, _wl_block8);
		
		}else{
			rsSec.last();
			totalRecordCount	=	rsSec.getRow();
			rsSec.beforeFirst();
			
			if( totalRecordCount>maxRecordsDisp){
				
            _bw.write(_wl_block9Bytes, _wl_block9);

					if(startIndex>maxRecordsDisp)
					{
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((startIndex-maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((endIndex-maxRecordsDisp)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

					}
					if(totalRecordCount>endIndex)
					{
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((startIndex+maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((endIndex+maxRecordsDisp)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

					}
				
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
			
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);


			if(startIndex>1)
			rsSec.absolute((startIndex-1));	
				
				while(rsSec.next())
				{
					tblrow_id		=	"tblrow_id"+(rowCnt);
					rowCnt++;
					
					if( (rowCnt%2)==0 )
						classValue	=	"QRYEVEN";
					else
						classValue	=	"QRYODD";
					
					curr_sec_accession_num			= rsSec.getString("ACCESSION_NUM")==null?"&nbsp;":rsSec.getString("ACCESSION_NUM");
					sec_hdg_code					= rsSec.getString("sec_hdg_code")==null?"&nbsp;":rsSec.getString("sec_hdg_code");
					subsec_hdg_code					= rsSec.getString("subsec_hdg_code")==null?"&nbsp;":rsSec.getString("subsec_hdg_code");
					event_date_time  				= rsSec.getString("event_date_time1")==null?"&nbsp;":rsSec.getString("event_date_time1");
					encounter_desc					= rsSec.getString("encounterdesc")==null?"&nbsp;":rsSec.getString("encounterdesc");
					note_type_desc					= rsSec.getString("note_type_desc")==null?"&nbsp;":rsSec.getString("note_type_desc");
					performed_by_name				= rsSec.getString("performed_by_name")==null?"&nbsp;":rsSec.getString("performed_by_name");
					authorized_by_name				= rsSec.getString("authorized_by_name")==null?"&nbsp;":rsSec.getString("authorized_by_name");
					status1							= rsSec.getString("status")==null?"&nbsp;":rsSec.getString("status");
					clob_notes_section_content_html	= (java.sql.Clob) rsSec.getClob("NOTES_SEC_CONT_HTML");
					
					event_date_time				= com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);
					
					if(status1.equals("1"))
						status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
					else if(status1.equals("2"))
						status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
					else if(status1.equals("3"))
						status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
					else if(status1.equals("4"))
						status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
					else if(status1.equals("5"))
						status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
					else if(status1.equals("9"))
						status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
					
					status_display_text	= status;
					
					if(!curr_sec_accession_num.equals("")&&sec_hdg_code.equals(curr_sec_hdg_code)&&subsec_hdg_code.equals(curr_child_sec_hdg_code))
					{
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curr_sec_accession_num));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(subsec_hdg_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((rowCnt)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(event_date_time));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(performed_by_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((authorized_by_name == null || authorized_by_name.equals("") )?"&nbsp;":authorized_by_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(status_display_text));
            _bw.write(_wl_block31Bytes, _wl_block31);

					}
					oldEncline=encline;
				if(rowCnt>=maxRecordsDisp) break;
				}
				
			}
		} 
			
	catch(Exception e){
		System.out.println("Exception@ 501.RecPreviousNotesSrchResults.jsp : "+e);
		e.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
		if(rscnt!=null)	rscnt.close();
		if(pstmtcnt!=null) pstmtcnt.close();
		if(rsSec!=null) rsSec.close();
		if(pstmtSec!=null) pstmtSec.close();	
	}
	
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(notifiable_code ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rowCnt ));
            _bw.write(_wl_block36Bytes, _wl_block36);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VisitPatientClassEncounterSpecilityDtls.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
