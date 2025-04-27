package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __querycurrentdocstatus extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryCurrentDocStatus.jsp", 1709116879797L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eFM/js/QueryFMCurrentFileStatus.js\' language=\'javascript\'></script>\n<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n</head>\n\n<body OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey();\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'query_doc_criteria_form\' id=\'query_doc_criteria_form\' method=\'post\' target=\'messageFrame\' action=\'../../eFM/jsp/QueryFMCurrentFileStatusResult.jsp\'>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'98%\' align=\'center\'>\n\t\t<tr>\n\t<td >\t\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\t\n\t\t<TD class=\'button\'><input type=button name=Add value=\'Search \' class=button onClick=\"checkDocumentValue(p_file_no)\">\n\t\t\t&nbsp;\n\t\t\t</TD>\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<input type=\'hidden\' name=\'facility\' id=\'facility\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'currfilelocn\' id=\'currfilelocn\' value=\'\'>\n<input type=\'hidden\' name=\'ManualReq\' id=\'ManualReq\' value=\'Y\'>\n<input type=\'hidden\' name=\'Req_fac_id\' id=\'Req_fac_id\' value=\'\'>\n<input type=\'hidden\' name=\'Req_fac_name\' id=\'Req_fac_name\' value=\'\'>\n<input type=\'hidden\' name=\'Req_locn_code\' id=\'Req_locn_code\' value=\'\'>\n<input type=\'hidden\' name=\'Req_locn_desc\' id=\'Req_locn_desc\' value=\'\'>\n<input type=\'hidden\' name=\'Req_locn_iden\' id=\'Req_locn_iden\' value=\'\'>\n<input type=\'hidden\' name=\'Req_locn_mr_locn\' id=\'Req_locn_mr_locn\' value=\'\'>\n<input type=\'hidden\' name=\'No_Of_Days\' id=\'No_Of_Days\' value=\'\'>\n<input type=\'hidden\' name=\'Req_by\' id=\'Req_by\' value=\'\'>\n<input type=\'hidden\' name=\'Req_by_name\' id=\'Req_by_name\' value=\'\'>\n<input type=\'hidden\' name=\'Narration_code\' id=\'Narration_code\' value=\'\'>\n<input type=\'hidden\' name=\'Narration_desc\' id=\'Narration_desc\' value=\'\'>\n<input type=\'hidden\' name=\'Pat_line\' id=\'Pat_line\' value=\'\'>\n\n<input type=\'hidden\' name=\'validFile\' id=\'validFile\' value=\'\'>\n<input type=\'hidden\' name=\'currStatDesc\' id=\'currStatDesc\' value=\'\'>\n<input type=\'hidden\' name=\'currIdDesc\' id=\'currIdDesc\' value=\'\'>\n<input type=\'hidden\' name=\'Curr_locn_desc\' id=\'Curr_locn_desc\' value=\'\'>\n<input type=\'hidden\' name=\'Req_on\' id=\'Req_on\' value=\'\'>\n<input type=\'hidden\' name=\'Curr_locn_code\' id=\'Curr_locn_code\' value=\'\'>\n<input type=\'hidden\' name=\'Curr_locn_iden\' id=\'Curr_locn_iden\' value=\'\'>\n<input type=\'hidden\' name=\'Curr_locn_mr_locn\' id=\'Curr_locn_mr_locn\' value=\'\'>\n\n<input type=\'hidden\' name=\'appointmentDays\' id=\'appointmentDays\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'bookingDays\' id=\'bookingDays\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'doc_or_file\' id=\'doc_or_file\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'f_curr_fs_locn\' id=\'f_curr_fs_locn\' value=\'\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

	Connection connection		= ConnectionManager.getConnection(request);
	String facility_id	= (String) session.getValue("facility_id");
	String sql			= "";
	String file_type_appl_yn = "N";
	String doc_or_file = request.getParameter("doc_or_file")==null?"F":request.getParameter("doc_or_file");
	
	int appointmentDays = 0;
	int bookingDays = 0;
//	int patient_id_max_length	=	0;

	Statement statement =	null;
	ResultSet resultSet =	null;
		
	try
	{
		statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			 sql = "select NO_DAYS_CHECK_APPT_INQUIRY, NO_DAYS_CHECK_BOOK_INQUIRY from fm_parameter where  FACILITY_ID='" + facility_id + "'" ;
		 resultSet = statement.executeQuery(sql);
		 while (resultSet.next())
		 {
			appointmentDays =resultSet.getInt("NO_DAYS_CHECK_APPT_INQUIRY");
			bookingDays		=resultSet.getInt("NO_DAYS_CHECK_BOOK_INQUIRY");
		 }
		 if(resultSet!=null)	resultSet.close();
		if(statement!=null)	statement.close();

		statement	=	connection.createStatement();
		resultSet	=	null;
		resultSet	=	statement.executeQuery("SELECT patient_id_length, file_type_appl_yn FROM mp_param ");
		if((resultSet != null) && (resultSet.next()))
		{
		//	patient_id_max_length	=	resultSet.getInt("patient_id_length");
			file_type_appl_yn		=	resultSet.getString("file_type_appl_yn");
		}
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null"))
			file_type_appl_yn = "N";

            _bw.write(_wl_block8Bytes, _wl_block8);
            {java.lang.String __page ="../../eFM/jsp/FMFileSearchComponentValues.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("frame_name"), weblogic.utils.StringUtils.valueOf("parent.searchFrame")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("query_doc_criteria_form")},{ weblogic.utils.StringUtils.valueOf("messageframe_name"), weblogic.utils.StringUtils.valueOf("parent.messageFrame")},{ weblogic.utils.StringUtils.valueOf("patientid_name"), weblogic.utils.StringUtils.valueOf("p_patient_id")},{ weblogic.utils.StringUtils.valueOf("fileno_name"), weblogic.utils.StringUtils.valueOf("p_file_no")},{ weblogic.utils.StringUtils.valueOf("filetype_name"), weblogic.utils.StringUtils.valueOf("file_type")},{ weblogic.utils.StringUtils.valueOf("volumeno_name"), weblogic.utils.StringUtils.valueOf("volume_no")},{ weblogic.utils.StringUtils.valueOf("doctype_appl_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("table_width"), weblogic.utils.StringUtils.valueOf("100")},{ weblogic.utils.StringUtils.valueOf("locn_code"), weblogic.utils.StringUtils.valueOf("f_curr_fs_locn")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block10Bytes, _wl_block10);

	if(resultSet!=null)	resultSet.close();
	if(statement!=null)	statement.close();
}
catch(Exception e)
{
	out.println(e);
}
finally
{	
	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(appointmentDays));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bookingDays));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(doc_or_file));
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
