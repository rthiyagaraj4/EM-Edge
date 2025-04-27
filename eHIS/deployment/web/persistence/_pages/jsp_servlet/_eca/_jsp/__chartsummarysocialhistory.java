package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.zip.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import eCA.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.Common.*;
import java.io.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummarysocialhistory extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummarySocialHistory.jsp", 1709115714933L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tDescription\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           \tcreated\n09/07/2012\tIN035928\t\tNijitha\t\t\tCHL-CRF-0044 - 35928\n26/02/2013\tIN035924\t  Karthi L\t \tCA View chart summary ?RESULT WIDGET? should come blank if patient visit hospital after 6 month or time interval defined by customer(CHL-CRF-018)\t\t\t\n18/06/2013  EMR           Nijitha         EMG-CRF18 \t      EMG-CRF18 - encounter specific query has been modified to patient specific.\t\n03/06/2014\tIN049436\t  Nijitha\t\t\tML-BRU-SCF-1350\n---------------------------------------------------------------------------------------------------------\nDate       \tEdit History   \tName        \tRev.Date\tRev.Name\tDescription\n---------------------------------------------------------------------------------------------------------\n28/05/2018\tIN065341\tPrakash C\t29/05/2018\tRamesh G\tMMS-DM-CRF-0115\n03/04/2019\tIN069978       \tPrakash C\t03/04/2019\tRamesh G\tMMS-ICN-00116\n20/04/2021\t6484\t\t\tRamesh Goli\t\t20/04/2021\t\tRAMESH G\t\tMO-CRF-20147.7\n---------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<html>\n<head>\n\t\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\' />\n\t\t\t<!-- ****  Modified by kishor kumar n on 05/12/2008 for crf0387 applied new css grid. **** -->\n\t\t\n\t\t\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesFileUpload.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<script>\n\tfunction showNoteData(accession_num,from,no_modalval,encounter_id,contr_mod_accession_num,notestatus,note_group_desc)//[IN032721]\n\t{\n\t\tvar dialogHeight\t= \"39\" ;\n\t\tvar dialogWidth\t\t= \"60\" ;\n\t\tvar status\t\t\t= \"no\";\n\t\tvar scroll\t\t\t= \"yes\";\n\t\tvar dialogTop\t\t= \"100\";\n\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\tvar no_modal=no_modalval;\n\t\tvar function_id = \"\";\n\t\tvar called_function_id=\"\";\n\t\tif(from != \'DISCHARGE_SUMMARY\')\n\t\t{\n\t\tvar note_group=note_group_desc;\n\t    var status=notestatus;\n\n\t    var statustxt=\'\';\n\t\t\n\t\tif(status ==  \'3\')\n\t    statustxt =  \'Unauthorized\'\n\t\telse if(status ==  \'4\')\n\t    statustxt =  \'Authorized\'\n\t\telse if(status ==  \'5\')\n\t    statustxt =  \'Modified\'\n\t\telse if(status ==  \'5\')\n\t    statustxt =  \'In Error\' \n\t\taccession_num=accession_num;\t\n\t\t}\n\t\tdocument.socialHistory.location.href =\"../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num=\"+accession_num; \n\t//\tvar retval = window.showModalDialog(\'../../eCA/jsp/ViewClinicalNoteNoteContentDeatail.jsp?accession_num=\'+accession_num+\'&no_modal=\'+no_modal+\'&note_group=\'+note_group+\'&statustxt=\'+statustxt+\'&fun=VCN&called_function_id=\'+called_function_id+\'&encounter_id=\'+encounter_id+\'&function_id=\'+function_id+\'&contr_mod_accession_num=\'+contr_mod_accession_num,arguments,features);\n\t}\n\t</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n<center>\n<form name=\'socialHistory\' id=\'socialHistory\' action=\"\"  method=\"\" target=\"\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<table border=\"0\" width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' >\n\t\t\t\t <td class=\'gridData\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t</table>\n\t\t\t\t ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t<input type=hidden name=query_string value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=hidden name=new_query_string value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\n\t<!-------------hidden fields for fileupload-------------------->\n\t<input type=hidden name=accession_num value=\'\'>\n\t<input type=hidden name=function_id value=\'\'>\n\t<input type=hidden name=privilege_type value=\'\'>\n\t<input type=hidden name=forwarded_clinician_id value=\'\'>\n\t<input type=hidden name=action_comment value=\'\'>\n\t<input type=hidden name=performed_by_id value=\'\'>\n\t<input type=hidden name=operation_mode value=\'\'>\n\t<input type=hidden name=doc_linked_note_yn value=\'\'>\n\t<input type=hidden name=appl_task_id value=\'\'>\n\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\'\'>\n\t<!--Added by Ambiga.M for 18712 on 2/24/2010   --> \n\t<input type=hidden name=forward_mode value=\'\'>\n\n\n<!------------------------------------------------------------>\n\n<br><br>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:12%; visibility:hidden;\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\' >\n\t<tr><td width=\'100%\' id=\'t\'></td></tr>\n\t</table>\n\t</div>\t\n\n</form>\n</center>\n</body>\n</html>\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		//String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
//String sStyle = "";
if(!"".equals(prefStyleSheet)){
 sStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends
		java.util.Properties p = (java.util.Properties) session
				.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
	//IN065341 starts
		String bean_id = "ca_CentralizedBean" ;
		String bean_name = "eCA.CentralizedBean";
		CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	//IN065341 ends	
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(title));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	PreparedStatement pstmtcnt = null;
	ResultSet rscnt = null;

	StringBuffer query_notes_detail = new StringBuffer();
	StringBuffer query_string = new StringBuffer();
	//StringBuffer whereClause = new StringBuffer();	//Checkstyle 4.0 Beta 6

	String function_id = "";
	//String classValue = "";	//Checkstyle 4.0 Beta 6
	String facility_id = "";
	//String accession_num = "";	//Checkstyle 4.0 Beta 6
	String note_type = "";
	//String note_type_desc = "";
	String note_group = "";
	String appl_task_id = "";
	//String service_code = "";	//Checkstyle 4.0 Beta 6
	//String service_name = "";	//Checkstyle 4.0 Beta 6
	//String event_title_desc = "";	//Checkstyle 4.0 Beta 6
	//String event_date_time = "";	//Checkstyle 4.0 Beta 6
	//String performed_by_id = "";	//Checkstyle 4.0 Beta 6
	//String performed_by_name = "";	//Checkstyle 4.0 Beta 6
	//String authorized_by_name = "";	//Checkstyle 4.0 Beta 6
	//String status = "";	//Checkstyle 4.0 Beta 6
	//String status1 = "";	//Checkstyle 4.0 Beta 6
	//String tblrow_id = "";	//Checkstyle 4.0 Beta 6
	String login_user_id = "";
	String clinician_id = "";
	String resp_id = "";
	//String operations_allowed = "";	//Checkstyle 4.0 Beta 6
	//String amendment_type = "";	//Checkstyle 4.0 Beta 6
	//String privilege_type = "";	//Checkstyle 4.0 Beta 6
	String patient_id = "";
	String encounter_id = "";
	String episode_type = "";
	String lower_limit = "";
	String upper_limit = "";
	String from_date_time = "";
	String to_date_time = "";
	String event_status = "";
	//String status_display_text = "";	//Checkstyle 4.0 Beta 6
	String filter = "";
	//String strModifiedId = "";	//Checkstyle 4.0 Beta 6
	String patient_class = "";
	String other_unsigned_yn = "";
	//String doc_linked = "";	//Checkstyle 4.0 Beta 6
	//String doc_linked_note_yn = "";	//Checkstyle 4.0 Beta 6
	String med_anc = "";
	String contr_mod_accession_num = "";
	String performed_by = "";
	String ref_no = "";
	//String doc_ref_id = "";	//Checkstyle 4.0 Beta 6
	//String Encline = "";	//Checkstyle 4.0 Beta 6
	//String oldEncline = "";	//Checkstyle 4.0 Beta 6
	String speciality_code = "";	//Checkstyle 4.0 Beta 6
	//String res_encounter_id = "";	//Checkstyle 4.0 Beta 6
	//String eventClass="";	//Checkstyle 4.0 Beta 6
	String	notes_content		=	"";
	
	java.sql.Clob			note_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	//String current_event_class_desc="";	
	//	String noteDetail="";	//Checkstyle 4.0 Beta 6

	int  maxRecordsDisp = 10;
	int startIndex = 0, endIndex = 0;
	int totalRecordCount = 0, colIndex = 0;
	//int sec_count = 0;	//Checkstyle 4.0 Beta 6

	patient_id = (request.getParameter("patient_id") == null) ? ""
			: request.getParameter("patient_id");
	//IN065341 starts
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	if(called_from.equals("CDR")){
		encounter_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		patient_class = (request.getParameter("pat_class") == null) ? ""
			: request.getParameter("pat_class");
		facility_id = (request.getParameter("facility_id1") == null) ? ""
			: request.getParameter("facility_id1");	
	}else{//IN065341 ends
	  encounter_id = request.getParameter("encounter_id") == null? ""
			: request.getParameter("encounter_id");
	  patient_class = (request.getParameter("patient_class") == null) ? ""
			: request.getParameter("patient_class");
	  facility_id = (String) session.getValue("facility_id");
	}//IN065341 
	episode_type = (request.getParameter("episode_type") == null) ? ""
			: request.getParameter("episode_type");
	event_status = (request.getParameter("status") == null) ? "0"
			: request.getParameter("status");
	other_unsigned_yn = (request.getParameter("other_unsigned_yn") == null) ? "Y"
			: request.getParameter("other_unsigned_yn");
	filter = (request.getParameter("filter") == null) ? "A" : request
			.getParameter("filter");
	function_id = (request.getParameter("function_id") == null) ? ""
			: request.getParameter("function_id");
	from_date_time = (request.getParameter("from_date_time") == null) ? ""
			: request.getParameter("from_date_time");
	to_date_time = (request.getParameter("to_date_time") == null) ? ""
			: request.getParameter("to_date_time");
	lower_limit = (request.getParameter("lower_limit") == null) ? "1"
			: request.getParameter("lower_limit");
	upper_limit = (request.getParameter("upper_limit") == null) ? ("" + maxRecordsDisp)
			: request.getParameter("upper_limit");
	note_type = (request.getParameter("note_type") == null) ? ""
			: request.getParameter("note_type");
	note_group = (request.getParameter("note_group") == null) ? ""
			: request.getParameter("note_group");
	appl_task_id = (request.getParameter("p_appl_task_id") == null) ? ""
			: request.getParameter("p_appl_task_id");
	performed_by = (request.getParameter("performed_by") == null) ? ""
			: request.getParameter("performed_by");
	med_anc = (request.getParameter("med_anc") == null) ? "" : request
			.getParameter("med_anc");
	contr_mod_accession_num = (request
			.getParameter("contr_mod_accession_num") == null) ? ""
			: request.getParameter("contr_mod_accession_num");
	ref_no = (request.getParameter("ref_no") == null) ? "" : request
			.getParameter("ref_no");
	speciality_code = (request.getParameter("speciality_code") == null) ? ""
			: request.getParameter("speciality_code");
	//String option_id = (request.getParameter("option_id") == null) ? "" : request.getParameter("option_id");	//Checkstyle 4.0 Beta 6

	query_string.append("patient_id=");
	query_string.append(patient_id);
	query_string.append("&encounter_id=");
	query_string.append(encounter_id);
	query_string.append("&episode_type=");
	query_string.append(episode_type);
	query_string.append("&function_id=");
	query_string.append(function_id);
	query_string.append("&from_date_time=");
	query_string.append(from_date_time);
	query_string.append("&to_date_time=");
	query_string.append(to_date_time);
	query_string.append("&appl_task_id=");
	query_string.append(appl_task_id);
	query_string.append("&patient_class=");
	query_string.append(patient_class);
	query_string.append("&filter=");
	query_string.append(filter);
	query_string.append("&status=");
	query_string.append(event_status);
	query_string.append("&other_unsigned_yn=");
	query_string.append(other_unsigned_yn);
	query_string.append("&med_anc=");
	query_string.append(med_anc);
	query_string.append("&performed_by=");
	query_string.append(performed_by);
	query_string.append("&ref_no=");
	query_string.append(ref_no);
	query_string.append("&speciality_code=");
	query_string.append(speciality_code);

	from_date_time = com.ehis.util.DateUtils.convertDate(
			from_date_time, "DMYHM", locale, "en");
	to_date_time = com.ehis.util.DateUtils.convertDate(to_date_time,
			"DMYHM", locale, "en");

	startIndex = Integer.parseInt(lower_limit);
	endIndex = Integer.parseInt(upper_limit);

	try {

		con = ConnectionManager.getConnection(request);

		login_user_id = (String) session.getValue("login_user");
	//	facility_id = (String) session.getValue("facility_id");COMMENTED FOR IN065341
		resp_id = (String) session.getValue("responsibility_id");
		clinician_id = (String) session.getValue("ca_practitioner_id");
		
		// added below lines for CHL-CRF-018 IN035924 - START
		StringBuffer encListBuf = new StringBuffer();
		ArrayList encounterList = null;
	//IN065341 starts	
	if(!called_from.equals("CDR")){
		CAEncounterList oEncounterList = new CAEncounterList();
		HashMap encounterMap = oEncounterList.getPatEncounterList(patient_id, facility_id, content_ID);
		String scope_disp = (String)encounterMap.get("SCOPE_DISP");
		Integer no_of_days_before = (Integer)encounterMap.get("NO_OF_DAYS");
		int no_of_days = no_of_days_before.intValue();
		encounterList = (ArrayList)encounterMap.get("ENC_LIST");
		
		if( no_of_days >= 1  &&  scope_disp.equalsIgnoreCase("P"))
		{
			Iterator iterator = encounterList.iterator();
			int index = 0;
			
			while(iterator.hasNext())
			{	
				index++;
				encListBuf.append("'");
				encListBuf.append(iterator.next());
				
				if(encounterList.size() >= index )
				{
					encListBuf.append("'");
				}
				
				if(encounterList.size() != index )
				{
					encListBuf.append(",");
				}
			}
		}
		else if(scope_disp.equalsIgnoreCase("P"))
		{
			encListBuf.append("'");
			encListBuf.append(encounter_id);
			encListBuf.append("'");
		}		
		//CHL-CRF-018 IN035924 - END
	}//IN065341 ends		
		//query_notes_detail.append("	select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type, b.note_type_desc,b.note_group_id, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and a.encounter_id = NVL(?,0) and b.language_id = ?  and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) "); //Query commented and has splited for CHL-CRF-018
		
		//query_notes_detail.append("select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type, b.note_type_desc,b.note_group_id, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? "); // modified for IN035924  CHL-CRF-018
		//query_notes_detail.append("select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type, b.note_type_desc,b.note_group_id, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? AND A.EVENT_STATUS NOT IN('9')")//IN038840
		//query_notes_detail.append("select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type, b.note_type_desc,b.note_group_id, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? AND A.EVENT_STATUS NOT IN('9') and b.language_id = ?  and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)");//EMR - encounter specific is made patient specific
		//query_notes_detail.append("select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type, 		b.note_type_desc,b.note_group_id, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? AND A.EVENT_STATUS NOT IN('9') and b.language_id = ?  and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)");//IN049436		
		//6484 Start.
		//query_notes_detail.append("select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type,b.note_type_desc,b.note_group_id,to_char( NVL2(a.ext_image_appl_id, 'Y', 'N'))  doc_linked , a.service_code, AM_GET_DESC.AM_SERVICE ##REPDB##(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN ##REPDB##( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp ##REPDB## where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id from 	ca_encntr_note##CLOB## a, ca_note_type_lang_vw ##REPDB## b where CA_GET_APPL_NOTE_OPERN ##REPDB##( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? AND A.EVENT_STATUS NOT IN('9') and b.language_id = ?  and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP ##REPDB## WHERE APPL_TASK_ID=?)");//IN065341		
		query_notes_detail.append("select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type,b.note_type_desc,b.note_group_id,to_char( NVL2(a.ext_image_appl_id, 'Y', 'N'))  doc_linked , a.service_code, AM_GET_DESC.AM_SERVICE ##REPDB##(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id,  replace(AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content,a.compress_note_content_yn,a.compress_note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN ##REPDB##( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp ##REPDB## where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id from 	ca_encntr_note##CLOB## a, ca_note_type_lang_vw ##REPDB## b where CA_GET_APPL_NOTE_OPERN ##REPDB##( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? AND A.EVENT_STATUS NOT IN('9') and b.language_id = ?  and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP ##REPDB## WHERE APPL_TASK_ID=?)");		
		//6484 End.
		// Commented for EMR since CRF-018 is not valid for Social History
		/*if(scope_disp.equalsIgnoreCase("D")) // condition added for CHL-CRF-018 IN035924 START
		{	
			query_notes_detail.append("and a.encounter_id = NVL(?,0) and b.language_id = ?  and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)");
		}
		else if(scope_disp.equalsIgnoreCase("P")) 
		{	
			query_notes_detail.append("and a.encounter_id in ("+encListBuf+") and b.language_id = ?  and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)");
		}
		else if(scope_disp.equalsIgnoreCase("C"))
		{
			query_notes_detail.append("and a.encounter_id = NVL(?,0) AND event_date_time between (sysdate - ?) and sysdate and b.language_id = ?  and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)");
		}*/
		
		// CHL-CRF-018 IN035924 END
	//IN069978 starts	
		if(called_from.equals("CDR")){
			query_notes_detail.append(" and a.encounter_id=?");
		}
	//IN069978 ends	
		query_notes_detail.append(" order by event_date_time DESC");
	//IN065341 starts
		if(called_from.equals("CDR")){
			bean.executeCDR(con,patient_id,encounter_id,RepDb,"SOCIAL_HISTORY");
		}
			String result = query_notes_detail.toString();			
			result=result.replaceAll("##REPDB##",RepDb);
			result=result.replaceAll("##CLOB##",clob_data);
			//pstmt = con.prepareStatement(result);		
			pstmt = con.prepareStatement(result,
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
	//IN065341 ends	
		pstmt.setString(++colIndex, locale);
		pstmt.setString(++colIndex, locale);
		pstmt.setString(++colIndex, locale);
		pstmt.setString(++colIndex, resp_id);
		pstmt.setString(++colIndex, clinician_id);
		pstmt.setString(++colIndex, login_user_id);
		pstmt.setString(++colIndex, other_unsigned_yn);

		pstmt.setString(++colIndex, resp_id);
		pstmt.setString(++colIndex, resp_id);
		pstmt.setString(++colIndex, clinician_id);
		pstmt.setString(++colIndex, login_user_id);
		pstmt.setString(++colIndex, other_unsigned_yn);
		//	pstmt.setString( ++colIndex,	locale			);
		pstmt.setString(++colIndex, patient_id);

	
		//pstmt.setString(++colIndex, facility_id);//IN049436
		// Commented for EMR since CRF-018 is not valid for Social History
		/*if(scope_disp.equalsIgnoreCase("D") || scope_disp.equalsIgnoreCase("C")) //condition added for CHL-CRF-018 - IN035924 
		{
			pstmt.setString(++colIndex, encounter_id);
		}
			
		if(scope_disp.equalsIgnoreCase("C")) // added for CHL-CRF-018 - IN035924 
		{
			pstmt.setInt(++colIndex, no_of_days);
		}*/
		
		pstmt.setString(++colIndex, locale);

		if (!(from_date_time.equals("")))
			pstmt.setString(++colIndex, from_date_time);

		if (!(to_date_time.equals(""))) {
			pstmt.setString(++colIndex, to_date_time);
		}
		if (!(event_status.equals("0"))) {

			pstmt.setString(++colIndex, event_status);
		}
		if (!(contr_mod_accession_num.equals(""))) {

			pstmt.setString(++colIndex, contr_mod_accession_num);
		}
		if ((filter.equals("R"))) {

			pstmt.setString(++colIndex, clinician_id);

		} else if ((filter.equals("S"))) {
			pstmt.setString(++colIndex, clinician_id);

		}

		if (!note_type.equals("")) {

			pstmt.setString(++colIndex, note_type);

		}
	
		if (!performed_by.equals("")) {

			pstmt.setString(++colIndex, performed_by);
		}

		if (!med_anc.equals("")) {

			pstmt.setString(++colIndex, med_anc);
		}
		pstmt.setString(++colIndex, "PAT_HISTORY");
	//IN069978 starts	
		if(called_from.equals("CDR")){
			pstmt.setString(++colIndex, encounter_id);
		}
	//IN069978 ends	
		rs = pstmt.executeQuery();
		
		if (!(rs.next())) {
			out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr></table>");
		} else {
			rs.last();
			totalRecordCount = rs.getRow();
			rs.beforeFirst();
		
			while (rs.next()) {
				//6484 Start.
				if("Y".equals(rs.getString("compress_note_content_yn")==null?"":(String)rs.getString("compress_note_content_yn"))){
					
					java.sql.Blob note_blob =  (java.sql.Blob)rs.getBlob("compress_note_content");
					if(note_blob!=null && note_blob.length()>0){
						InputStream ins1 = note_blob.getBinaryStream();
						ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
						int i;
						while((i = ins1.read()) != -1) 
							bytearrayoutputstream.write(i);
						
						byte[] compressed	=bytearrayoutputstream.toByteArray();
						if(compressed.length > 0){
							if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
								GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
								BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

								String line;
								while ((line = bufferedReader.readLine()) != null) {
									notes_content += line;
								}
							}					
						}
					}					
				}else{
				//6484 End.
					note_content= (java.sql.Clob) rs.getObject("note_content");					
					if(note_content != null){
						try
						{
							content_reader	= note_content.getCharacterStream();
							bf_content_reader = new java.io.BufferedReader(content_reader);
							char[] arr_notes_content = new char[(int)note_content.length()];
							bf_content_reader.read(arr_notes_content,0,(int)note_content.length());
							notes_content = new String(arr_notes_content);
							bf_content_reader.close();
						}
						catch(Exception e)
						{
							//out.println("Exception@2-readCLOB : "+e);//COMMON-ICN-0181
							e.printStackTrace();//COMMON-ICN-0181
						}
					}					
				}
				if(!notes_content.equals(""))
				{
					//IN044358 Start.
					String str="<th style=\"border-style:dashed;font-size:9pt;font-weight:boldl;\"";
					String str1="<td style=\"border-style:dashed;font-size:9pt;text-align:center;font-weight:bold;\"";
					notes_content = notes_content.replaceAll(str,str1);
					String str_ ="<th style=\"color:black;font-size:9pt;font-weight:normal;border-style:dashed;\"";
					String str1_ ="<td style=\"color:black;font-size:9pt;font-weight:normal;border-style:dashed;text-align:center;\"";
					notes_content = notes_content.replaceAll(str_,str1_);
					notes_content = notes_content.replaceAll("</th>","</td>");
					notes_content = notes_content.replaceAll("<!--","<!-- ");
					//IN044358 End.
					notes_content = notes_content.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  //IN048271
					notes_content = notes_content.replaceAll("PAGE-BREAK-BEFORE: always;","");           //[IN056353]
					notes_content = notes_content.replaceAll("<HTML><BODY><PRE>","<PRE>");				//IN067635
					notes_content = notes_content.replaceAll("</PRE></BODY></HTML>","</PRE>");			//IN067635
					notes_content = notes_content.replaceAll("line-height: 100%"," ");			//IN068396
					int nIndex = notes_content.indexOf("<BODY onKeyDown='lockKey()'>");
					if(nIndex==-1)
					{
						nIndex = notes_content.indexOf("<BODY>");
					}
					int nIndex1 = notes_content.lastIndexOf("</BODY>");
					
					if(nIndex != -1 && nIndex1 != -1)
						notes_content = notes_content.substring(nIndex+6,nIndex1);
					
				}
				
				 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(notes_content));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
		}
		if (rscnt != null)
			rscnt.close();				
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();

	} catch (Exception e) {
		//out.println("Exception@1 : " + e);//COMMON-ICN-0181
		e.printStackTrace();
	} finally {
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
