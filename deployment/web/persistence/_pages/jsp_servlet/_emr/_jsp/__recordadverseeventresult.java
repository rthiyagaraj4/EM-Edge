package jsp_servlet._emr._jsp;

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
import java.util.StringTokenizer;
import java.util.TreeMap;
import eCommon.XSSRequestWrapper;

public final class __recordadverseeventresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecordAdverseEventResult.jsp", 1709119026567L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<HTML>\n<head>\n\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t<script src=\"../../eOA/js/QueryLocnForDay.js\"></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n\t <script language=\'javascript\' src=\"../js/MedRecRequestMain.js\"></script>\n  <script language=\'javascript\' src=\"../js/RecordAdverseEventCriteria.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\n</head>\n<body OnMouseDown=\'CodeArrest();\' onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =",";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =")\' onKeyDown=\'lockKey()\'>\n<form name=\'MedRecRequestResult\' id=\'MedRecRequestResult\'  action=\"../../eMR/jsp/MedRecRequestResult.jsp\" method=\"post\"  >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\">\n\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<td>\t\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \t\t\t\n\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</tr></table>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t<td>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t</table><br><br>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<th align=\'center\' nowrap>&nbsp;</th>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<th align=\'center\' nowrap>&nbsp;Select All&nbsp;<BR><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\'selectAll(this,\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\");\'></th>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<th align=\'center\' nowrap>Encounter Date</th>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<th align=\'center\' nowrap>Encounter Type</th>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t<th align=\'center\' nowrap>Encounter ID</th>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n \t\t\t<th align=\'center\' nowrap>Patient ID</th> \n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<th align=\'left\' nowrap>Patient Name</th>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<th align=\'center\' nowrap>Location Type</th>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<th align=\'center\' nowrap>Location</th>\n\t\t\t<th align=\'center\' nowrap>Speciality</th>\n\t\t\t<th align=\'center\' nowrap>Room</th>\n\t\t\t<th align=\'center\' nowrap>Bed</th>\n\t\t\t<th align=\'center\' nowrap>Practitioner</th>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</table>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<!-- <table align=\'right\'>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" \n\t\t\t</tr>\n\t\t</table> -->\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<TR><td colspan=6 class=\"white\">&nbsp;</td></TR>\n\t\t</table>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<TR>\n<!-- \t\t<th align=\'center\' nowrap>Patient ID</th> -->\n\t\t\t<th align=\'center\' nowrap>Encounter Type</th> \n\t\t\t<th align=\'center\' nowrap>Admission Date</th> \n\t\t\t<th align=\'center\' nowrap>Encounter ID</th>\n\t\t\t<th align=\'center\' nowrap>Location Type</th>\n\t\t\t<th align=\'center\' nowrap>Location</th>\n\t\t\t<th align=\'center\' nowrap>Practitioner</th>\n\t\t\t<th align=\'center\' nowrap>Speciality</th>\n\t\t\t<th align=\'center\' nowrap>Discharge Date</th>\n\t\t</TR>\n\t\t\t<input type=\'hidden\' name=\'tempIDS\' id=\'tempIDS\'  >\n\t\t\t<input type=\'hidden\' name=\'encIDS\' id=\'encIDS\' >\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<script>\n\t\t\tenc_id\t= \'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\n\t\t\tdocument.forms[0].encIDS.value=document.forms[0].encIDS.value+enc_id+\"|\";\n//\t\t\talert(\"encIDS.value after adding : \"+document.forms[0].encIDS.value)\n\t\t</script>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<script>\n\t\t\tenc_id\t= \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\tdocument.forms[0].encIDS.value=document.forms[0].encIDS.value+enc_id+\"|\";\n//\t\t\talert(\"encIDS.value after adding : \"+document.forms[0].encIDS.value)\n\t\t</script>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</TABLE>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t<input type=\'hidden\' name=\'no_of_days\' id=\'no_of_days\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n\t<input type=\'hidden\' name=\'bl_install\' id=\'bl_install\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t<input type=\'hidden\' name=\'PatientId\' id=\'PatientId\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" >\n\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n\t<input type=\'hidden\' name=\'finalSelect\' id=\'finalSelect\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t<input type=\'hidden\' name=\'temp1\' id=\'temp1\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t<input type=\'hidden\' name=\'criteria\' id=\'criteria\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\n\t<!-- <input type=\'hidden\' name=\'EncounterId\' id=\'EncounterId\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'> -->\n\t<input type=\'hidden\' name=\'lstPatientClass\' id=\'lstPatientClass\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t<input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t<input type=\'hidden\' name=\'alt_id1_exp_date\' id=\'alt_id1_exp_date\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\n\t<input type=\'hidden\' name=\'alt_id2_exp_date\' id=\'alt_id2_exp_date\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n\n\t<input type=\'hidden\' name=\'p_discharge_date_from\' id=\'p_discharge_date_from\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\n\t<input type=\'hidden\' name=\'p_discharge_date_to\' id=\'p_discharge_date_to\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n\n\t<input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n\t<input type=\'hidden\' name=\'alt_id1_no\' id=\'alt_id1_no\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t<input type=\'hidden\' name=\'alt_id2_no\' id=\'alt_id2_no\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n\t<input type=\'hidden\' name=\'alt_id3_no\' id=\'alt_id3_no\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t<input type=\'hidden\' name=\'alt_id4_no\' id=\'alt_id4_no\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t<input type=\'hidden\' name=\'other_alt_type\' id=\'other_alt_type\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t<input type=\'hidden\' name=\'other_alt_Id\' id=\'other_alt_Id\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n\t<input type=\'hidden\' name=\"selectAll_yn\" id=\"selectAll_yn\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\'hidden\' name=\"hddEncID\" id=\"hddEncID\" value=\"\">\n\t<input type=\'hidden\' name=\"PatientId\" id=\"PatientId\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\'hidden\' name=\"p_encounter_id\" id=\"p_encounter_id\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t<input type=\'hidden\' name=\"FacilityId\" id=\"FacilityId\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t<input type=\'hidden\' name=\"marked_status\" id=\"marked_status\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\n\n\t<br><center>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n</center>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet MedicalReportReq= null;synchronized(session){
                MedicalReportReq=(webbeans.eCommon.RecordSet)pageContext.getAttribute("MedicalReportReq",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(MedicalReportReq==null){
                    MedicalReportReq=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("MedicalReportReq",MedicalReportReq,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

String title =request.getParameter("title")==null?"":request.getParameter("title");	

if(!title.equals(""))
{
	out.println("<title>"+title+"</title>");
}

	String classValue	 = "";
	StringBuffer sqlbuff = new StringBuffer();
	String FacilityId		= (String) session.getValue( "facility_id" ) ;	
	String criteria =request.getParameter("criteria")==null?"":request.getParameter("criteria");	
	String jsp_name =request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");	
//	String flagSelect = request.getParameter("fromSelect")==null?"":request.getParameter("fromSelect");
	String finalSelect="",temp1="";

	String selectAll_yn=request.getParameter("selectAll_yn")==null?"":request.getParameter("selectAll_yn");
	if(selectAll_yn == null) selectAll_yn="";
	finalSelect=request.getParameter("finalSelect")==null?"":request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";
	
	String Enc_Type=request.getParameter("lstPatientClass")==null?"":request.getParameter("lstPatientClass");

	String orderBy=request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	if(orderBy == null || orderBy.equals("ET")) 
		orderBy = " to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') desc";
	else if(orderBy.equals("ED")) 
		orderBy = "a.visit_adm_date_time desc";

	String cause_ind	=	request.getParameter("cause_ind")==null?"":request.getParameter("cause_ind");
	String alt_id1_exp_date=request.getParameter("alt_id1_exp_date")==null?"":request.getParameter("alt_id1_exp_date");
	if(alt_id1_exp_date == null) alt_id1_exp_date="";

	String alt_id2_exp_date=request.getParameter("alt_id2_exp_date")==null?"":request.getParameter("alt_id2_exp_date");
	if(alt_id2_exp_date == null) alt_id2_exp_date="";
	
	String p_discharge_date_from=request.getParameter("p_discharge_date_from")==null?"":request.getParameter("p_discharge_date_from");

	String p_discharge_date_to=request.getParameter("p_discharge_date_to")==null?"":request.getParameter("p_discharge_date_to");
	

	String national_id_no=request.getParameter("national_id_no")==null?"":request.getParameter("national_id_no");
	if(national_id_no == null) national_id_no="";

	String alt_id1_no=request.getParameter("alt_id1_no")==null?"":request.getParameter("alt_id1_no");
	if(alt_id1_no == null) alt_id1_no="";
	
	String alt_id2_no=request.getParameter("alt_id2_no")==null?"":request.getParameter("alt_id2_no");
	if(alt_id2_no == null) alt_id2_no="";
	
	String alt_id3_no=request.getParameter("alt_id3_no")==null?"":request.getParameter("alt_id3_no");
	if(alt_id3_no == null) alt_id3_no="";
	
	String alt_id4_no=request.getParameter("alt_id4_no")==null?"":request.getParameter("alt_id4_no");
	if(alt_id4_no == null) alt_id4_no="";

	String other_alt_type	=request.getParameter("other_alt_type")==null?"":request.getParameter("other_alt_type");
	if(other_alt_type == null) other_alt_type="";
	String other_alt_Id		=request.getParameter("other_alt_Id")==null?"":request.getParameter("other_alt_Id");
	if(other_alt_Id == null) other_alt_Id="";

	temp1=request.getParameter("temp1")==null?"":request.getParameter("temp1");
	if(temp1 == null) temp1="";


	String mlc_oscc = request.getParameter("marked_status")==null?"":request.getParameter("marked_status");
	String flag="";
	flag=(request.getParameter("flag")==null) ? "" : request.getParameter("flag");

	String  req_start   =   "", req_end     =   "";
    String  checkedOnes         =   "";

    req_start       =   (request.getParameter("from")==null)   ?   "0" :   request.getParameter("from");
    req_end         =   (request.getParameter("to")==null)     ?   "0" :   request.getParameter("to");

	if( jsp_name == null) jsp_name="";
	String window_styl=request.getParameter("window_styl");
	if( window_styl == null) window_styl="";
	String close_yn	=request.getParameter("close_yn");
	if( close_yn == null) close_yn="";
	String win_top =request.getParameter("win_top");
	if( win_top == null) win_top="";
	String win_height =request.getParameter("win_height");
	if(win_height ==null) win_height="";
	String dialogTop =request.getParameter("dialogTop");
	if(dialogTop ==null) dialogTop="";
	String win_width =request.getParameter("win_width");
	if( win_width == null) win_width="";
	String modal=request.getParameter("modal");
	if(modal == null) modal="";
	String module=request.getParameter("module");
	if(module == null) module="";
	String model_window=request.getParameter("model_window");
	if( model_window == null) model_window="";
	String function_id=request.getParameter("function_id");
	if( function_id == null) function_id="";

	String prog_id=request.getParameter("prog_id");
	if( prog_id == null) prog_id="";
	String p_practitioner_id=request.getParameter("practitioner_id");
	if( p_practitioner_id == null) p_practitioner_id="";
	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";

	String no_of_days			=request.getParameter("no_of_days");
	if(no_of_days == null) no_of_days="";
	
//	String sql = "";
	String PatientId		=	request.getParameter("PatientId") ;
	if(PatientId	== null || PatientId.equals("null"))		
		PatientId = "";		
	
	String EncounterId		=	request.getParameter("p_encounter_id") ;
	if(EncounterId	== null || EncounterId.equals("null"))		
		EncounterId = "";

	String AdmissionDate	=	request.getParameter("AdmissionDate")==null?"":request.getParameter("AdmissionDate") ;
	
	String DischargeDate	=	request.getParameter("DischargeDate") ;

	if(AdmissionDate == null || AdmissionDate.equals("null"))	AdmissionDate = "";
	if(DischargeDate	== null || DischargeDate.equals("null"))DischargeDate = "";

	String whereClause = request.getParameter("whereclause");
	if(whereClause	== null || whereClause.equals("null"))	
	{
		whereClause= "";
	}
	else
	{
		//sql = whereClause;
	}

	String from = checkForNull(request.getParameter( "from" )) ;
	String to = checkForNull(request.getParameter( "to" )) ;
	String modal_yn = checkForNull(request.getParameter("modal_yn")) ;
	String install_yn="";
	if(modal_yn.equals("Y"))
		install_yn =checkForNull(request.getParameter( "bl_install_yn" )) ;


	int start = 0 ;
	int end = 0 ;
    int i=1;


	if ( from == null )
		start = 1 ;
	else
	{
		if(from.equals(""))start=1;
		else
		start = Integer.parseInt( from ) ;
	}

	if ( to == null )
		end = 10 ;
	else
	{
		if(to.equals(""))end=10;
		else
		end = Integer.parseInt( to ) ;
	}

	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	Statement stmt_bl = null;
	ResultSet rs_bl=null;

	Connection conn = ConnectionManager.getConnection(request);	
try
{
//	int recordCount			=	0;
	if(from != null && to != null)
	{
		 int j=0;
		 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		 {
			 if(request.getParameter("chk"+(i)) != null)
			 {
				 checkedOnes = request.getParameter("chk"+(i));
				 if(!(MedicalReportReq.containsObject(checkedOnes)))
				 {
					 MedicalReportReq.putObject(checkedOnes);
				 }
				 j++;
			 }
		 }	
		 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
		i = 1 ;
//Check for bl_interfaced_yn condition.......added by kishore
	if(!modal_yn.equals("Y"))
	{
		String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from ip_param where facility_id='"+FacilityId+"'";
		try
		{
			stmt_bl=conn.createStatement();
			rs_bl=stmt_bl.executeQuery(query_bl_interface);
			if(rs_bl.next())
			{
				install_yn=rs_bl.getString("bl_interfaced_yn");
			}
		
		if(rs_bl != null) rs_bl.close();
		if(stmt_bl != null) stmt_bl.close();
		}
		catch(Exception e)
		{
			//out.println("Exception @try1"+e);
			e.printStackTrace();
		}
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(start));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(end));
            _bw.write(_wl_block6Bytes, _wl_block6);

		String Where  = "";

		Where  = " where a.patient_id=b.patient_id and b.patient_id like '"+PatientId+"%' and a.facility_id='"+FacilityId+"' ";

if(call_function.equals("QUERY_MATERNAL_REPORT")) 
{	
	if(cause_ind.equals(""))
	{
		Where = Where + " and disposition_type in ( select discharge_type_code from ip_discharge_type where maternal_death_yn = 'Y' and eff_status = 'E') ";
	}
	else
	{
		Where = Where + " and disposition_type ='"+cause_ind+"'  ";
	}
}

if ( !(Enc_Type == null || Enc_Type.equals("")) )
{
	Where = Where + " and upper(PATIENT_CLASS) like upper('"+Enc_Type+"%') ";
}

if ( !(EncounterId == null || EncounterId.equals("")) )
{
	Where = Where + " and upper(a.encounter_id) like upper('"+EncounterId+"%') ";
}

if ( !(alt_id1_exp_date == null || alt_id1_exp_date.equals("")) )
{
	Where = Where + " and a.visit_adm_date_time >= to_date('"+alt_id1_exp_date+"','dd/mm/yyyy hh24:mi')";
}


if ( !(alt_id2_exp_date == null || alt_id2_exp_date.equals("")) )
{
	Where = Where + " and a.visit_adm_date_time <= to_date('"+alt_id2_exp_date+"','dd/mm/yyyy hh24:mi')";
}

if ( !(p_discharge_date_from == null || p_discharge_date_from.equals("")) )
{
	Where = Where + " and a.DISCHARGE_DATE_TIME >= to_date('"+p_discharge_date_from+"','dd/mm/yyyy hh24:mi')";
}

if ( !(p_discharge_date_to == null || p_discharge_date_to.equals("")) )
{
	Where = Where + " and a.DISCHARGE_DATE_TIME <= to_date('"+p_discharge_date_to+"','dd/mm/yyyy hh24:mi')";
}

if ( !(national_id_no == null || national_id_no.equals("")) )
{
	Where = Where + " and upper(b.NATIONAL_ID_NO) like upper('"+national_id_no+"%') ";
}
if ( !(alt_id1_no == null || alt_id1_no.equals("")) )
{
	Where = Where + " and upper(b.alt_id1_no) like upper('"+alt_id1_no+"%') ";
}
if ( !(alt_id2_no == null || alt_id2_no.equals("")) )
{
	Where = Where + " and upper(b.alt_id2_no) like upper('"+alt_id2_no+"%') ";
}
if ( !(alt_id3_no == null || alt_id3_no.equals("")) )
{
	Where = Where + " and upper(b.alt_id3_no) like upper('"+alt_id3_no+"%') ";
}
if ( !(alt_id4_no == null || alt_id4_no.equals("")) )
{
	Where = Where + " and upper(b.alt_id4_no) like upper('"+alt_id4_no+"%') ";
}

if ( !(other_alt_type == null || other_alt_type.equals("")) )
{
	Where = Where + " and upper(b.oth_alt_id_type) like upper('"+other_alt_type+"%') ";
}
if ( !(other_alt_Id == null || other_alt_Id.equals("")) )
{
	Where = Where + " and upper(b.oth_alt_Id_no) like upper('"+other_alt_Id+"%') ";
}

if(call_function.equals("QUERY_MARK_MLC_OSCC"))
{
	if(PatientId.equals("") && EncounterId.equals(""))
	{
		if (mlc_oscc.equals(""))
		{
			Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";
		}	
		else if (mlc_oscc.equals("O"))
		{
			Where = Where + "and a.oscc_yn = 'Y' ";
		}	
		else if (mlc_oscc.equals("M"))
		{
			Where = Where + "and a.mlc_yn='Y' ";
		}	
	}
	else if (!PatientId.equals("") && !EncounterId.equals(""))
	{
		if (mlc_oscc.equals("")){Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";}	
		else if (mlc_oscc.equals("O")){Where = Where + "and a.oscc_yn = 'Y' ";}	
		else if (mlc_oscc.equals("M")){Where = Where + "and a.mlc_yn='Y' ";}	
	}
	else if (!PatientId.equals(""))
	{
		if (mlc_oscc.equals("")){Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";}	
		else if (mlc_oscc.equals("O")){Where = Where + "and a.oscc_yn = 'Y' ";}	
		else if (mlc_oscc.equals("M")){Where = Where + "and a.mlc_yn='Y'";}	
	}
}


if ( !(orderBy == null || orderBy.equals("")) )
{
	Where = Where + " order by "+orderBy+" ";
}
	int maxRecord = 0;
	if(!modal_yn.equals("Y"))
	{
			if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
			sqlbuff.append("select count(1) from  pr_encounter a, mp_patient b");
			sqlbuff.append(Where);
		/*sql = "select count(1) from  pr_encounter a,mp_patient b,am_speciality d,am_practitioner e,op_clinic f,ip_nursing_unit g,am_patient_class h " + Where;*/

		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();

		pstmt = conn.prepareStatement(sqlbuff.toString());
		rs = pstmt.executeQuery();

		if(rs.next())
		   maxRecord = rs.getInt(1);
	}
	if (maxRecord==0 && !modal_yn.equals("Y"))
	{			
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));//document.location.href='../../eCommon/html/blank.html'</script>");
	}
	else
	{
	    if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
		sqlbuff.append("select a.patient_id,b.patient_name,decode (b.sex,'M','Male','F','Female','U','Unknown')gender,");
		sqlbuff.append("to_char(b.date_of_birth,'dd/mm/yy')birth_date,  ");
		sqlbuff.append("to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') encounter_date,");
		sqlbuff.append("a.encounter_id, (CASE WHEN a.specialty_code IS NOT NULL THEN (SELECT short_desc FROM am_speciality WHERE speciality_code = a.specialty_code)END) speciality_desc,");
		sqlbuff.append("(CASE WHEN a.assign_care_locn_type = 'C' THEN (SELECT short_desc FROM op_clinic WHERE facility_id = a.facility_id AND clinic_code = a.assign_care_locn_code) WHEN assign_care_locn_type = 'N' THEN (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = a.assign_care_locn_code) END ) locn_desc,");
		sqlbuff.append("(CASE WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner  WHERE practitioner_id = a.attend_practitioner_id) END) practitioner_name,(CASE WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT PRACT_TYPE FROM am_practitioner  WHERE practitioner_id = a.attend_practitioner_id) END) practitioner_type, a.assign_room_num room_no, a.assign_bed_num bed_no, DECODE (a.assign_care_locn_type,'C', 'Clinic','N', 'Nursing Unit') locn_type, b.alt_id1_no alt_id1_no, b.alt_id2_no alt_id2_no, b.alt_id3_no alt_id3_no, b.alt_id4_no alt_id4_no,(CASE WHEN a.patient_class IS NOT NULL THEN (SELECT short_desc FROM am_patient_class WHERE patient_class = a.patient_class) END ) patient_class, a.patient_class patient_class_code, TO_CHAR (a.discharge_date_time,'dd/mm/yy hh24:mi') discharge_date_time,a.attend_practitioner_id FROM pr_encounter a, mp_patient b ");

		sqlbuff.append(Where);

 
	if(rs != null)rs.close();
	if(pstmt  != null)pstmt.close();
	pstmt = conn.prepareStatement(sqlbuff.toString());
	rs = pstmt.executeQuery();

	if(!flag.equals("true"))
	{
		if(!PatientId.equals(""))
		{	
            _bw.write(_wl_block7Bytes, _wl_block7);
	if(!call_function.equals("QUERY_MATERNAL_REPORT"))
			{	
            _bw.write(_wl_block8Bytes, _wl_block8);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(PatientId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block11Bytes, _wl_block11);
	}	
            _bw.write(_wl_block12Bytes, _wl_block12);
	}	
            _bw.write(_wl_block13Bytes, _wl_block13);

		if ( !(start <= 1) )
			out.println("<A HREF=\"javascript:submitPrevNext("+(start-10)+","+(end-10)+")\" text-decoration='none'>Previous</A>");
		if ( !( (start+10) > maxRecord ) )
			out.println("<A HREF=\"javascript:submitPrevNext("+(start+10)+","+(end+10)+")\" text-decoration='none'>Next</A>");
		
            _bw.write(_wl_block14Bytes, _wl_block14);
	if(!call_function.equals("QUERY_MATERNAL_REPORT"))
	{	
            _bw.write(_wl_block15Bytes, _wl_block15);
	}	
            _bw.write(_wl_block1Bytes, _wl_block1);
 if(	!call_function.equals("MARK_MLC_OSCC") && 
		!call_function.equals("DIAG_RECODE") && !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")&&
		!call_function.equals("QUERY_MARK_MLC_OSCC") &&
		!call_function.equals("QUERY_MATERNAL_REPORT") )
		{	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(start));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(end));
            _bw.write(_wl_block18Bytes, _wl_block18);
	}	
            _bw.write(_wl_block19Bytes, _wl_block19);
	if(!call_function.equals("QUERY_MARK_MLC_OSCC")) 
	{	
            _bw.write(_wl_block20Bytes, _wl_block20);
	}	
            _bw.write(_wl_block21Bytes, _wl_block21);
	if(call_function.equals("QUERY_MARK_MLC_OSCC"))
	{
		if (PatientId.equals("")) 
		{	
            _bw.write(_wl_block22Bytes, _wl_block22);
		} 
	}	
	if(call_function.equals("QUERY_MATERNAL_REPORT"))
	{	
            _bw.write(_wl_block23Bytes, _wl_block23);
	}	
	if(!call_function.equals("QUERY_MATERNAL_REPORT")&&!call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE")&&!call_function.equals("QUERY_MARK_MLC_OSCC"))
	{	
            _bw.write(_wl_block24Bytes, _wl_block24);
	}	
            _bw.write(_wl_block25Bytes, _wl_block25);

//		String classValue	 = "";
		String chkAttribute = "";
		if ( rs != null )
		{
			if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

				while ( rs.next() && i<=end )
				{
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					String Patient_ID=rs.getString("patient_id");				
					String Patient_Name=rs.getString("patient_name");				
					String conGender=rs.getString("gender");				
					String Date_of_Birth=rs.getString("birth_date");				
					String Patient_Class=rs.getString("patient_class");	
					String Encounter_Date=rs.getString("encounter_date");				
					String Encounter_ID=rs.getString("encounter_id");				
					String con_Speciality=rs.getString("speciality_desc");				
					String con_Location=rs.getString("locn_desc");				
					String con_Practitioner=rs.getString("practitioner_name");				
					String practitioner_type=rs.getString("practitioner_type");	
					String patient_class=rs.getString("PATIENT_CLASS");	
					String room_no=rs.getString("room_no");				
					String bed_no=rs.getString("room_no");				
					String locn_type=rs.getString("locn_type");		
					String Encounter_Type = rs.getString("locn_type");
					String Patient_Class_code= rs.getString("patient_class_code");
					String attend_practitioner_id= rs.getString("attend_practitioner_id");

//		recordCount =	MedicalReportReq.getSize();
		if(MedicalReportReq.containsObject(Encounter_ID))  
			chkAttribute = "CHECKED";
		else
			chkAttribute="";

		int recordIndex = MedicalReportReq.indexOfObject(Encounter_ID);
		if(recordIndex!=-1)
		if(chkAttribute.equals("CHECKED"))    									    	MedicalReportReq.removeObject(recordIndex);


/*
					String alt_id1_no=rs.getString(15);				
					String alt_id2_no=rs.getString(16);				
					String alt_id3_no=rs.getString(17);				
					String alt_id4_no=rs.getString(18);				
					//String con_Select=rs.getString(10);				
*/


					if(Patient_ID==null	      || Patient_ID.equals("null"))		    
						Patient_ID = "";
					if(Patient_Name==null	  || Patient_Name.equals("null"))				Patient_Name = "";
					if(conGender==null	      || conGender.equals("null"))		    
						conGender = "";
					if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
						Date_of_Birth = "";
					if(Patient_Class==null	  || Patient_Class.equals("null"))
						Patient_Class = "";
					if(Encounter_Date==null	  || Encounter_Date.equals("null"))
						Encounter_Date = "";
					if(Encounter_ID==null	  || Encounter_ID.equals("null"))
						Encounter_ID = "";
					if(con_Speciality==null	  || con_Speciality.equals("null"))
						con_Speciality = "&nbsp;";
					if(con_Location==null	  || con_Location.equals("null"))
						con_Location = "&nbsp;";
					if(con_Practitioner==null || con_Practitioner.equals("null"))
						con_Practitioner = "&nbsp;";
					if(room_no==null || room_no.equals("null"))
						room_no = "&nbsp;";
					if(bed_no==null || bed_no.equals("null"))
						bed_no = "&nbsp;";
					if(locn_type==null || locn_type.equals("null"))
						locn_type = "&nbsp;";
					if(Encounter_Type==null || Encounter_Type.equals("null"))
						Encounter_Type = "&nbsp;";
		out.println("<tr>");
		if(!call_function.equals("QUERY_MATERNAL_REPORT"))
		{
			out.println("<td align='left' class='"+classValue+"'>");
			out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+Patient_Class_code+"')\">");	
			out.print("+</a></td>");				
		}

		if(!call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE") && !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")  && !call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("QUERY_MATERNAL_REPORT") )
		{
			out.println("<td align=middle nowrap class='"+classValue+"'><input type=checkbox name='chk"+i+"' id='chk"+i+"' value='"+i+"' onClick='javascript:RemSelectAll();chkServices(this);' /></td>");
		}

		out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");

		if(!call_function.equals("QUERY_MARK_MLC_OSCC"))
		{
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				//Patient_Class--Encounter_Type
		}
		if(call_function.equals("MARK_MLC_OSCC") )
		{
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','MARK_MLC_OSCC','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
		}
		else if(call_function.equals("DIAG_RECODE"))
		{
			out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecodeDiagnosis('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
		}		
		else if(call_function.equals("MR_ALLERGY_RECORDING"))
		{
			out.println("<td nowrap class='"+classValue+"'><a href=javascript:AdverseEvent('"+Encounter_ID+"','"+Patient_ID+"','"+attend_practitioner_id+"','"+practitioner_type+"','"+Patient_Class_code+"')>"+Encounter_ID+"</a></td>");
		}
		else if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
		{
			out.println("<td nowrap class='"+classValue+"'><a href=javascript:DiagnososConfirmationDtls('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
		}
		else if(call_function.equals("QUERY_MARK_MLC_OSCC"))
		{
			if (!PatientId.equals(""))
			{
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','QUERY_MARK_MLC_OSCC','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
			}
			else if(PatientId.equals(""))
			{
				out.println("<td nowrap class='"+classValue+"'>"+Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','QUERY_MARK_MLC_OSCC','"+Patient_ID+"')>"+Patient_ID+"</a></td>");
			}
		}
		else if(call_function.equals("QUERY_MATERNAL_REPORT"))
		{	
			out.println("<td align='left' class='"+classValue+"'>");
			out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+""+"')\">");	
			out.print(""+Encounter_ID+"</a></td>");
		}
		else
		{
			out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
		}
		if(call_function.equals("QUERY_MATERNAL_REPORT"))
		{	
			out.println("<td nowrap class='"+classValue+"'>" +Patient_Name+"</td>");
		}
		if(!call_function.equals("QUERY_MATERNAL_REPORT")&&!call_function.equals("MEDICAL_REPORT_REQUEST")&&!call_function.equals("MARK_MLC_OSCC")&&!call_function.equals("DIAG_RECODE")&&!call_function.equals("QUERY_MARK_MLC_OSCC"))
		{	
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"</td>");
				//Encounter_Type-Patient_Class
		}

				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"/"+con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +room_no+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +bed_no+"</td>");
				out.println("<td nowrap class='"+classValue+"'>"+con_Practitioner+"</td>");
				out.println("</tr>");
				i++;
			}
		}

	
            _bw.write(_wl_block26Bytes, _wl_block26);
	}
	else //if(flag.equals("true"))
	{
	/// DISPLAY IN MODAL WINDOW
	
            _bw.write(_wl_block27Bytes, _wl_block27);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(PatientId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block29Bytes, _wl_block29);


	if(!finalSelect.equals("SELECTALL"))
	{
		TreeMap ssm=new TreeMap();
		String selitem="";
		selitem=(request.getParameter("selitem")==null) ? "" : request.getParameter("selitem");
		selitem=selitem.substring(1);
		selitem=selitem.substring(0,selitem.length()-1);
		
		StringTokenizer st=new StringTokenizer(finalSelect,"~");

		int temp=st.countTokens();
		String practId="";
		/*String objName="";*/
		String enable_dis="";
		for(int u2=0;u2<temp;u2++)
		{
			String st2=st.nextToken();
			StringTokenizer st1=new StringTokenizer(st2,"$");
			practId=st1.nextToken();
			st1.nextToken();
			enable_dis=st1.nextToken();
			if(enable_dis.equals("E"))
			ssm.put(practId,practId);
			else
			{
				if(ssm.containsKey(practId))
				ssm.remove(practId);
			}
		}


		//StringTokenizer st=new StringTokenizer(selitem,",");
		/*st=new StringTokenizer(selitem,",");
		while(st.hasMoreTokens())
		{
			String key=st.nextToken();			
			ssm.put(key,key);
		}*/

		if (rs != null)
		{
			//if (start != 1 )
			//for(int j=1; j<start; i++,j++ )
			//rs.next() ;
			int clsCnt=1;

		while(rs.next())
		{
			if(ssm.containsKey(new String(i+"")))
			{
				
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				String Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");				
				String Encounter_ID=rs.getString("encounter_id");				
				String con_Speciality=rs.getString("speciality_desc");				
				String con_Location=rs.getString("locn_desc");				
				String con_Practitioner=rs.getString("practitioner_name");				
				String locn_type=rs.getString("locn_type");	
				if(locn_type==null	      || locn_type.equals("null"))		    
					locn_type = "";

				String Dis_dateTime =	rs.getString("discharge_date_time");	
				if(Dis_dateTime==null	      || Dis_dateTime.equals("null"))		    
					Dis_dateTime = "&nbsp;";

				if(Patient_ID==null	      || Patient_ID.equals("null"))		    
					Patient_ID = "";
				if(Patient_Name==null	  || Patient_Name.equals("null"))		Patient_Name = "&nbsp";
				if(conGender==null	      || conGender.equals("null"))		    
					conGender = "&nbsp";
				if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))		Date_of_Birth = "&nbsp;";
				if(Patient_Class==null	  || Patient_Class.equals("null"))		Patient_Class = "";
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))		Encounter_Date = "";
				if(Encounter_ID==null	  || Encounter_ID.equals("null"))		Encounter_ID = "";
				if(con_Speciality==null	  || con_Speciality.equals("null"))		con_Speciality = "&nbsp;";
				if(con_Location==null	  || con_Location.equals("null"))		con_Location = "&nbsp;";
				if(con_Practitioner==null || con_Practitioner.equals("null"))	con_Practitioner = "&nbsp;";
				out.println("<tr>");				
//			out.println("<td nowrap class='"+classValue+"'>" +Patient_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime+"</td>");
				out.println("</tr>");
				clsCnt++;
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs.getString("encounter_id")));
            _bw.write(_wl_block31Bytes, _wl_block31);

				}
				i++;
			}
			if(clsCnt == 1)
			{
				out.println("<script>alert('Encouter has to be selected for Medical Report Request');parent.window.close();</script>");
				//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));parent.window.close();</script>");
			}
		}
	}
	else if(finalSelect.equals("SELECTALL"))
	{
//		out.println("<script>alert('SelectAll is Checked...Page Under Construction')</script>");

		if (rs != null)
		{
			int clsCnt=1;
			while(rs.next())
			{
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				String Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");				
				String Encounter_ID=rs.getString("encounter_id");				
				String con_Speciality=rs.getString("speciality_desc");				
				String con_Location=rs.getString("locn_desc");				
				String con_Practitioner=rs.getString("practitioner_name");			
				String locn_type=rs.getString("locn_type");		
				if(locn_type==null || locn_type.equals("null"))		    
					locn_type = "";

				String Dis_dateTime =	rs.getString("DISCHARGE_DATE_TIME");	
				if(Dis_dateTime==null	      || Dis_dateTime.equals("null"))		    
					Dis_dateTime = "&nbsp;";

				if(Patient_ID==null	      || Patient_ID.equals("null"))		    
					Patient_ID = "";
				if(Patient_Name==null	  || Patient_Name.equals("null"))
					Patient_Name = "";
				if(conGender==null	      || conGender.equals("null"))		    
					conGender = "";
				if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
					Date_of_Birth = "";
				if(Patient_Class==null	  || Patient_Class.equals("null"))
					Patient_Class = "";
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))
					Encounter_Date = "";
				if(Encounter_ID==null	  || Encounter_ID.equals("null"))
					Encounter_ID = "";
				if(con_Speciality==null	  || con_Speciality.equals("null"))
					con_Speciality = "";
				if(con_Location==null	  || con_Location.equals("null"))
					con_Location = "";
				if(con_Practitioner==null || con_Practitioner.equals("null"))
					con_Practitioner = "";
				out.println("<tr>");				
//				out.println("<td nowrap class='"+classValue+"'>" +Patient_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime+"</td>");
				out.println("</tr>");


            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block33Bytes, _wl_block33);
	

				clsCnt++;
				i++;
			}
		}
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();
	}// E.O SelectAll
	
            _bw.write(_wl_block34Bytes, _wl_block34);
	}
	
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(module));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(start));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(end));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(temp1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(criteria));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Enc_Type));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(orderBy));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(alt_id2_exp_date));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(p_discharge_date_from));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(p_discharge_date_to));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(other_alt_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(other_alt_Id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(selectAll_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(mlc_oscc));
            _bw.write(_wl_block75Bytes, _wl_block75);

}
if(!finalSelect.equals("SELECTALL"))
{
	
	StringTokenizer st=new StringTokenizer(finalSelect,"~");
	/*String practId="";*/ String objName="";
	String enable_dis="";
	int temp=st.countTokens();

	for(int u2=0;u2<temp;u2++)
	{
		String st2=st.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");
		st1.nextToken();
		objName=st1.nextToken();
		enable_dis=st1.nextToken();

		if(enable_dis.equals("E"))
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=true;</script>");
		else
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=false;</script>");
	}
}
}catch ( Exception e )
{ 
	//out.println("Expection in MedRecRequestResult.jsp : "+e);
	e.printStackTrace();
}

finally
{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	ConnectionManager.returnConnection(conn,request);
//	session.setAttribute("MedicalReportReq", MedicalReportReq);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block76Bytes, _wl_block76);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
