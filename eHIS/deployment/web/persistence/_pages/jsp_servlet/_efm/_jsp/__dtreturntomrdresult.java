package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.util.StringTokenizer;
import java.util.*;
import com.ehis.util.*;

public final class __dtreturntomrdresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTReturnToMRDResult.jsp", 1709116823404L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eFM/js/FMReturnToMRD.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\t\t\t\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\tparent.result_frame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\tparent.criteria_frame.document.forms[0].all_button.disabled = false;\n\t\t\tparent.criteria_frame.document.forms[0].patient_id.value = \'\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<body onMouseDown = \"CodeArrest();\" onKeyDown = \'lockKey();\'> \n\t\t<form name=\'FMReturnToMRDResultForm\' id=\'FMReturnToMRDResultForm\' action=\'DTReturnToMRDResult.jsp\' method=\'POST\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<table align=\'right\' ><tr><td  >\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =", ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =")\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</td></tr></table></p>\n\t\t\t<br><br>\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" align=\"CENTER\">\n\t\t<tr>\n\t\t\t<td class=\'columnheader\' width=\"26%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td class=\'columnheader\' width=\"12%\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td class=\'columnheader\' width=\"13%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td class=\'columnheader\' width=\"17%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t<td class=\'columnheader\' width=\"10%\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<tr>\n\t\t\t<!-- Col 1 -->\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"><font size=1><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<input type=\'hidden\' name=\'doc_folder_id";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'doc_folder_id";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'></b>\n\t\t\t<br>&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="<input type=\'hidden\' name=\'doc_type_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'doc_type_code";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'></font></td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" ><font size=\"1\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =",<BR><A HREF CLASS=\"label\" onMouseover=\"changeCursor(this)\" onClick=\"callPatDetails(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;</A></font></td>\t\n\n\t\t\t<!-- ragha -->\n\n\t\t\t<td  CLASS=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" width=\'12%\'>\n\t\t\t<A HREF onMouseover=\"changeCursor(this)\" onClick=\"showEncounter(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\"><font size=1>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</font></A></td>\n\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" align=\"CENTER\"><font size=\"1\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</font></td>\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" align=\'center\'><font size=\"1\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" align=\"CENTER\"><font size=\"1\"><input type=\"checkbox\" name=\"confirm";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"confirm";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onClick=\"markCheckedRecords(this);\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" ></font></td>\t\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t<input type=\"Hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"Hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\"Hidden\" name=\"fs_location\" id=\"fs_location\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\"Hidden\" name=\"fs_req_location\" id=\"fs_req_location\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\"Hidden\" name=\"returning_code\" id=\"returning_code\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\"Hidden\" name=\"date_time\" id=\"date_time\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type=\"Hidden\" name=\"transport_mode\" id=\"transport_mode\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\"Hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t<input type=\"Hidden\" name=\"file_type_appl_yn\" id=\"file_type_appl_yn\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type=\"Hidden\" name=\"file_no\" id=\"file_no\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=\"Hidden\" name=\"file_type\" id=\"file_type\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t<input type=\"Hidden\" name=\"volume_no\" id=\"volume_no\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\"Hidden\" name=\"added_items\" id=\"added_items\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\"Hidden\" name=\"added_patients\" id=\"added_patients\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=\"Hidden\" name=\"show_all_yn\" id=\"show_all_yn\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t<input type=\"Hidden\" name=\"valid_records\" id=\"valid_records\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<input type=\"Hidden\" name=\"transport_mode_desc\" id=\"transport_mode_desc\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t<input type=\"Hidden\" name=\"total_records\" id=\"total_records\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t<input type=\"Hidden\" name=\"doc_folder_ids\" id=\"doc_folder_ids\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type=\"Hidden\" name=\"doc_type_codes\" id=\"doc_type_codes\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\n\n\t\t</form>\n\t\t<script>\n\t\t\tparent.criteria_frame.document.forms[0].fs_location.disabled = true;\n\t\t\tparent.criteria_frame.document.forms[0].fs_req_location.disabled = true;\n\t\t\tparent.criteria_frame.document.forms[0].returning_desc.disabled = true;\n\t\t\tparent.criteria_frame.document.forms[0].ret_button.disabled = true;\n\t\t\tparent.criteria_frame.document.forms[0].all_button.disabled = true;\n\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n</html>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );


public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
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

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

String facility_id				=	"";
String patient_id				=	"";
String fs_location				=	"";
String fs_req_location			=	"";
String returning_code			=	"";
String date_time				=	"";
String transport_mode			=	"";
String transport_mode_desc		=	"";
String file_type_appl_yn		=	"N";
String file_no					=	"";
String file_type				=	"";
String volume_no				=	"";
String from		 				=	"";
String to		 				=	"";
String added_items				=	"";
String added_patients			=	"";
String added_volumes			=	"";
String show_all_yn				=	"Y";
String valid_records			=	"Y";
String class_value				=	"QRYEVEN";
int total_records			= 0;


String doc_folder_id = "", doc_folder_name = "", doc_type_name = "", doc_type="",doc_type_code="";
int record_count				=	0;
int start						=	0 ;
int end							=	0 ;
int count						=	1 ;

StringBuffer sqlBuffer		=	new StringBuffer();
StringBuffer queryBuffer	=	new StringBuffer();
StringBuffer whereBuffer	=	new StringBuffer();

try
{
	facility_id 		=	checkForNull((String) session.getValue("facility_id"));
	fs_location			=	checkForNull(request.getParameter("fs_location"));
	fs_req_location		=	checkForNull(request.getParameter("fs_req_location"));
	returning_code		=	checkForNull(request.getParameter("returning_code"));
	date_time			=	checkForNull(request.getParameter("date_time"));
	transport_mode		=	checkForNull(request.getParameter("transport_mode"));
	transport_mode_desc	=	checkForNull(request.getParameter("transport_mode_desc"));
	patient_id			=	checkForNull(request.getParameter("patient_id"));
	file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"));
	file_no				=	checkForNull(request.getParameter("file_no"));
	file_type			=	checkForNull(request.getParameter("file_type"));
	volume_no			=	checkForNull(request.getParameter("volume_no"));
	from				=	checkForNull(request.getParameter("from"));
	to					=	checkForNull(request.getParameter("to"));
	added_items			=	checkForNull(request.getParameter("added_items"));
	added_patients		=	checkForNull(request.getParameter("added_patients"));
	added_volumes		=	checkForNull(request.getParameter("added_volumes"));
	valid_records		=	checkForNull(request.getParameter("valid_records"));
	show_all_yn			=	checkForNull(request.getParameter("show_all_yn"), "Y");
	
	if (from.equals(""))
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if (to.equals(""))
		end = 10 ;
	else
		end = Integer.parseInt( to ) ;
	
	connection			=	ConnectionManager.getConnection(request);	

	sqlBuffer.append("SELECT a.file_no, a.file_type_code,c.encounter_id,a.file_type_desc, a.volume_no, a.patient_id, get_patient_line (a.patient_id,'"+localeName+"') patient_line, to_char(a.iss_date_time, 'dd/mm/rrrr hh24:mi') iss_date_time, a.curr_fs_locn_code, a.curr_fs_locn_short_desc,a.MR_PAT_FS_LOCN_DESC, a.volume_no,a.doc_folder_id doc_folder_id, a.doc_folder_name, a.doc_type_name,a.doc_type_code, (CASE WHEN b.PATIENT_PERIOD_SPECIFIC='D' THEN ', ' || TO_CHAR(b.from_period,'dd/mm/rrrr ')|| ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE ', ' || get_patient_line(b.patient_id) END)doc_type FROM fm_curr_locn_vw a,fm_doc_folder b,fm_encounter_doc_type_link c ");

	queryBuffer.append("SELECT COUNT(*) record_count FROM fm_curr_locn_vw a, fm_doc_folder b,fm_encounter_doc_type_link c ");
	whereBuffer.append(" where a.doc_folder_id=b.doc_folder_id and a.facility_id=b.facility_id and a.facility_id=c.facility_id and a.file_no=c.file_no ");
	whereBuffer.append(" and a.curr_file_status = 'O' AND a.curr_facility_id = '");
	whereBuffer.append(facility_id);
	whereBuffer.append("' AND a.curr_fs_locn_code = '");
	whereBuffer.append(fs_req_location);
	whereBuffer.append("' ");
	if (!returning_code.equals(""))
	{
		whereBuffer.append(" AND a.CURR_LOCN_ID = '");
		whereBuffer.append(returning_code);
		whereBuffer.append("' ");
	}
	
	if (!show_all_yn.equals("Y"))
	{
	//	whereBuffer.append(" AND a.file_no IN (");
	//	whereBuffer.append(added_items);
	//	whereBuffer.append(") AND a.patient_id IN (");
	whereBuffer.append(" AND a.patient_id IN (");
		whereBuffer.append(added_patients);
		whereBuffer.append(") ");
		
		if (!volume_no.equals(""))
		{
			whereBuffer.append(" AND a.volume_no IN (");
			whereBuffer.append(added_volumes);
			whereBuffer.append(") ");
		}
	}

	queryBuffer.append(whereBuffer.toString());
	preStatement	=	connection.prepareStatement(queryBuffer.toString());

	resultSet		=	preStatement.executeQuery();
	
	if ((resultSet != null) && (resultSet.next()))
		record_count = resultSet.getInt("record_count");

	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();

	if (record_count == 0)
	{
	
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	else
	{
		sqlBuffer.append(whereBuffer.toString());

		if (preStatement != null) preStatement = null;
		if (resultSet != null) resultSet = null;
		preStatement	=	connection.prepareStatement(sqlBuffer.toString());
		resultSet		=	preStatement.executeQuery();
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		if ((!(start <= 1)) || (!( (start+10) > record_count )))
		{
			
            _bw.write(_wl_block10Bytes, _wl_block10);

			if ( !(start <= 1) )
			{
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(start-10));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end-10));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
					
			if ( !( (start+10) > record_count ) )
			{
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end+10));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
			
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		if (resultSet != null)
		{
		
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			int strCount				=	0;
			int inc						=	0;
			String check_attribute		=	"";
			String confirm_values		=	"";
			StringTokenizer strToken	=	null;
			if ( start != 1 )
				for( int j=1; j<start; count++,j++ )
					resultSet.next() ;
			
			while (resultSet.next() && count<=end)
			{
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
				check_attribute = "";
				strToken	=	new StringTokenizer(valid_records, ",");
				strCount	=	strToken.countTokens();
				confirm_values	=	checkForNull(resultSet.getString("file_no"));
				confirm_values	= confirm_values +  "||" + checkForNull(resultSet.getString("volume_no"));
				confirm_values	= confirm_values +  "||" + checkForNull(resultSet.getString("doc_folder_id"));
				confirm_values	= confirm_values +  "||" + checkForNull(resultSet.getString("doc_type_code"));

				for (inc=0; inc<strCount; inc++)
				{
					if (strToken.hasMoreTokens())
						if ((checkForNull(strToken.nextToken())).equals(confirm_values))
							check_attribute = "Checked";
				}
				doc_folder_id = checkForNull(resultSet.getString("doc_folder_id"));
				doc_folder_name = checkForNull(resultSet.getString("doc_folder_name"));
				doc_type_name = checkForNull(resultSet.getString("doc_type_name"));
				doc_type = checkForNull(resultSet.getString("doc_type"));
				doc_type_code = checkForNull(resultSet.getString("doc_type_code"));
	
			
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(doc_folder_name));
            out.print( String.valueOf(doc_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(doc_type_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(resultSet.getString("PATIENT_ID")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(resultSet.getString("PATIENT_ID")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(resultSet.getString("ENCOUNTER_ID")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(resultSet.getString("PATIENT_ID")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(resultSet.getString("FILE_NO")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(resultSet.getString("encounter_id")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(checkForNull(resultSet.getString("iss_date_time"), "&nbsp;")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(checkForNull(resultSet.getString("MR_PAT_FS_LOCN_DESC"), "&nbsp;")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(count));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(confirm_values));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(check_attribute));
            _bw.write(_wl_block46Bytes, _wl_block46);

				count++;
				total_records ++;
			}
		}
	
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(from));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(to));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(fs_location));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(fs_req_location));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(returning_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(date_time));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(transport_mode));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(file_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(added_items));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(added_patients));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(show_all_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(valid_records));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(transport_mode_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block67Bytes, _wl_block67);

	}
if(resultSet!=null)	resultSet.close();
if(preStatement!=null) preStatement.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block68Bytes, _wl_block68);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentdetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.issueddate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.IssuedFSLocation.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ConfirmReturn.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
