package jsp_servlet._eor._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __newprocedureaddmodifypractmulti extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcedureAddModifyPractMulti.jsp", 1709119746000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n <head>\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\">\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../js/NewProcedure.js\' language=\'javascript\'></script>\n<script src=\'../js/NewProcedureMain.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<form name=\'multipract_form\' id=\'multipract_form\'  action=\'\' method=\'get\' target=\'messageFrame\'>\n\n<table border=0 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\" align=center>\n<tr>\n\t<td class=\'label\' width=\'10%\' align=\'right\' colspan=\'\' nowrap>Medical Team</td>\n\t<td class=\'label\' width=\'30%\' colspan=\'\'><SELECT name=\"med_team\" id=\"med_team\">\n\t<option>-----Select-----</option>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</SELECT>\n\t</td>\n\t<td class=\'label\' align=\'center\' width=\'20%\'>Practitioner</td>\n\t<td class=\'label\' align=\'30%\' width=\'\'><input type=\"text\"  name=\"pract_description\" id=\"pract_description\" value=\"\" size=13 ><input type=\'button\' class=\'button\' name=\"pract_btn\" id=\"pract_btn\" value=\'?\' onclick=\"displayMultiPract()\"></td> \n\t\t<input type=\"hidden\"  name=\"pract_code\" id=\"pract_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"postn_description\" id=\"postn_description\" value=\"\" >\n\t\t<input type=\"hidden\" name=\"postn_code\" id=\"postn_code\" value=\"\" >\n\t<td class=\'label\' align=\'right\' width=\'\'><!-- Priority<select name=\"priority\" id=\"priority\"><option value=\"1\">Elective</option><option value=\"5\">Emergency</option><option value=\"7\">Semi-Critical</option><option value=\"9\">Critical</option></select></td>\n\t<td class=\'label\' align=\'center\' colspan=\'3\'>&nbsp ;<input type=\'button\' class=\'button\' name=\"notes_btn\" id=\"notes_btn\" value=\'Notes\' onclick=\"callClinicalNotes(\'\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'\')\"> --></td>\n\t\t\n</tr>\n<tr>\n\t<td class=\'label\' width=\'\' colspan=\'6\'>\n\t\t<table border=1 cellspacing=0 cellpadding = 3 width=\'100%\' align=\'center\' style=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' id=\'\'>\n\t\t<tr>\n\t\t\t<td class=columnheader width=\'5%\'></td>\n\t\t\t<td class=columnheader width=\'50%\'>Practitioner</td>\n\t\t\t<td class=columnheader width=\'35%\'>Role</td>\n\t\t\t<td class=columnheader width=\'10%\'>Select</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=\'\' class=\'QRYEVEN\' align=\'center\'><font size=1><a href=\"javascript:showPractWindow(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\">+</a></font></td>\n\t\t\t<td colspan=\'\' class=\'QRYEVEN\' ><font size=1>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font></td>\n\t\t\t<td colspan=\'\' class=\'QRYEVEN\' ><select name=\'role_desc0\' id=\'role_desc0\' onchange=\'\'>\n\t\t\t\t<option value=\'\'>--- Select ---</option>\n\t\t\t\t<option value=\'01\' selected>Main Surgeon</option>\n\t\t\t\t<option value=\'11\'>Assisting Surgeon\t</option>\n\t\t\t\t<option value=\'21\'>Anaesthetist</option>\n\t\t\t\t<option value=\'41\'>Consultant</option>\n\t\t\t\t<option value=\'51\'>Scrub Nurse\t</option>\n\t\t\t\t</select></td>\n\t\t\t<td colspan=\'\' class=\'QRYEVEN\'  align=\'center\'><input type=\'checkbox\' name=\'pract_chk0\' id=\'pract_chk0\' checked readonly></td>\n\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' name=\'pract_code0\'>\n\t\t\t<input type=\'hidden\' value=\'\' name=\'pract_type_code0\' id=\'pract_type_code0\'><input type=\'hidden\' value=\'\' name=\'postn_code0\' id=\'postn_code0\'><input type=\'hidden\'  name=\'postn_desc0\' id=\'postn_desc0\' value=\'\'>\n\t\t</tr> \n\t\t<tr style=\'height:1pt\'>\n\t\t\t<td colspan=\'4\' class=\'QRYEVEN\' id=\'pract_val\'></td>\n\t\t</tr>\n\t\t</table>\n\t</td>\n</tr>\n<tr style=\'display:none\'>\n\t<td align=\"right\" valign=\"middle\" class=\"label\">Intra - Procedural Complications</td>\n\t<td colspan=\'5\'><textarea name=\"findings\" rows=\'1\' cols=\'60\'\n\tonBlur=\"makeValidString(this);\" maxlength=500  onFocus=\'\' onKeyPress=\'\'></textarea></td>\n</tr>\n<tr style=\'display:none\'>\n\t<td align=\"right\" valign=\"middle\" class=\"label\">Actions taken to resolve complications</td>\n\t<td colspan=\'5\'><textarea name=\"impression\" rows=\'2\' cols=\'60\'\n\tonBlur=\"makeValidString(this);\" maxlength=500  onFocus=\'\' onKeyPress=\'\'></textarea></td>\n</tr>\n<tr style=\'display:none\'>\n\t<td align=\"right\" valign=\"middle\" class=\"label\">Remarks</td>\n\t<td colspan=\'5\'><textarea name=\"disposition\" rows=\'3\' cols=\'60\' onBlur=\"makeValidString(this);\" maxlength=500  onFocus=\'\' onKeyPress=\'\' ></textarea></td>\n</tr>\n</table>\n\n<input type=\"hidden\" name = \"Practitioner_Id\" value =\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\"hidden\" name = \"relationship_id\" value =\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\"hidden\" name = \"Locn_Code\" value =\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\"hidden\" name = \"Locn_Type\" value =\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\"hidden\" name = \"Patient_Id\" value =\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name = \"Encounter_Id\" value =\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name = \"currentdate\" value =\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name = \"as_evidenced_by_hid\" value =\"\">\n<input type=\"hidden\" name = \"accry_code\" value =\"\">\n<input type=\"hidden\" name = \"accry_code_ind\" value =\"\">\n<!-- Params for Code Set up...Get papulate from Script file. -->\n<input type=\"hidden\" name = \"term_set_id\" value =\"\">\n<input type=\"hidden\" name = \"priority_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"nature_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"severity_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"onset_type_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"factors_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"notification_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"notifiable_yn\" value =\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<!-- hidden fields for search -->\n<input type=\"hidden\" name = \"dob\" value =\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\"hidden\" name = \"age\" value =\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\"hidden\" name = \"sex\" value =\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\"hidden\" name = \"facilityId\" value =\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name = \"mode\" value =\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name = \"modal_yn\" value =\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n<input type=\'hidden\' name=\'onset_date_temp\' id=\'onset_date_temp\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\t\n<input type=\'hidden\' name=\'status_date_temp\' id=\'status_date_temp\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'status_srl_no\' id=\'status_srl_no\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'onset_date1\' id=\'onset_date1\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'pract_retval\' id=\'pract_retval\' value=\'\'>\n<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\'\'>\n<input type=\'hidden\' name=\'anesthesia\' id=\'anesthesia\' value=\'\'>\n<input type=\'hidden\' name=\'anesthesia_det\' id=\'anesthesia_det\' value=\'\'>\n<input type=\'hidden\' name=\'indication\' id=\'indication\' value=\'\'>\n<input type=\'hidden\' name=\'record_type\' id=\'record_type\' value=\'O\'>\n<input type=\'hidden\' name=\'ca_practitioner_id\' id=\'ca_practitioner_id\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=\'totalRecords\' id=\'totalRecords\' value=\'1\'>\n<input type=\'hidden\' name=\'priority\' id=\'priority\' value=\'\'>\n<input type=\'hidden\' name=\'nature\' id=\'nature\' value=\'\'>\n<input type=\'hidden\' name=\'start_dt\' id=\'start_dt\' value=\'\'>\n<input type=\'hidden\' name=\'end_dt\' id=\'end_dt\' value=\'\'>\n<input type=\'hidden\' name=\'multi_session\' id=\'multi_session\' value=\'\'>\n<input type=\'hidden\' name=\'consent\' id=\'consent\' value=\'\'>\n<input type=\'hidden\' name=\'multi_proc_records\' id=\'multi_proc_records\' value=\'\'>\n<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'>\n<input type=\'hidden\' name=\'reason\' id=\'reason\' value=\'\'>\n<input type=\'hidden\' name=\'outcome\' id=\'outcome\' value=\'\'>\n<input type=\'hidden\' name=\'status\' id=\'status\' value=\'\'>\n\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
	String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con      = null;
	Statement stmt		= null;
	ResultSet rset		= null;
	
	PreparedStatement stmt2	= null;
	PreparedStatement pstmt	= null;
	ResultSet rs2	= null;
	String Practitioner_Id="";	String relationship_id	="";
	String Locn_Code	="";	String Locn_Type	="";
	String Patient_Id	="";	String Encounter_Id	="";
	String currentdate	="";	String facilityId ="";
	String dob = ""; String age = "";
	String sex = ""; String associate_codes ="";
	String notifiable_yn;
	
	String term_code = "";	String term_set_id = "";
	String nature = "";  	String onset_date = "";
	String status = "";  	String srl_no = "";     
	
	String	severity = "";	String	onset_type = "";
	String	priority = "";	String	accuracy_code = "";
	String	remarks = "";	String	status_date = "";
	String patient_class	="";	
	String disimage = "display:none";
	//String disimage = "display:inline";
	
	String def_status	=""; String date_status	="";
	String def_disable	="";  String occur_srl_no="";
	String style_def = "";		String mode="";
	String modal_yn="";	
	
	String facility_id=checkForNull((String)session.getValue("facility_id"));
	String practitioner_type=checkForNull((String)session.getValue("practitioner_type"));
	String ca_practitioner_id=(String) session.getAttribute("ca_practitioner_id") == null?"" :(String) session.getAttribute("ca_practitioner_id");
	StringBuffer sql=new StringBuffer(); 

	try
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
		currentdate				= dateFormat.format(new java.util.Date()) ;
		onset_date				= currentdate;
		status_date				= currentdate;
		occur_srl_no			= checkForNull(request.getParameter("occur_srl_no"));
		srl_no					= checkForNull(request.getParameter("srl_no"));
		Practitioner_Id			= checkForNull(request.getParameter("Practitioner_Id"));	
		relationship_id			= checkForNull(request.getParameter("relationship_id"));
		Locn_Code				= checkForNull(request.getParameter("location_code"));			
		Locn_Type				= checkForNull(request.getParameter("location_type"));
		Patient_Id				= checkForNull(request.getParameter("patient_id"));
		patient_class			= checkForNull(request.getParameter("patient_class"));
		Encounter_Id			= checkForNull(request.getParameter("encounter_id"));
		associate_codes			= checkForNull(request.getParameter("associate_codes"));		
		age						= checkForNull(request.getParameter("Age"));	
		dob						= checkForNull(request.getParameter("Dob"));	
		sex						= checkForNull(request.getParameter("Sex"));	
		mode					= checkForNull(request.getParameter("mode"));
		modal_yn				= checkForNull(request.getParameter("modal_yn"));
		notifiable_yn			= checkForNull(request.getParameter("notifiable_yn"));
		
		if(Practitioner_Id.equals("") || Practitioner_Id.equals("null")){
			Practitioner_Id		= (String)session.getValue("ca_practitioner_id");
		}
		//modal_yn="Y";
		term_set_id			=checkForNull(request.getParameter("term_set_id"));
		if(!term_set_id.equals(""))
			disimage = "display:inline";
		term_code				=checkForNull(request.getParameter("term_code"));

		String term_short_desc = "";
		String codes = "";			String Aselect ="";			String Pselect ="";
		String Wselect ="";			String pri_N_select ="";	String pri_H_select ="";
		String pri_C_select ="";	String sevr_L_select ="";	String sevr_D_select ="";
		String sevr_S_select ="";	String sevr_E_select ="";	String stus_A_select ="";
		String stus_R_select ="";	String stus_X_select ="";	String stus_E_select ="";

		String type_A_select = "";	String type_C_select = "";	String mandatory_status	=""; 
		String code_ind	="";		String mandatory_disable	=""; String diff_group_id	="";
		String def_select = "";
		
		con = ConnectionManager.getConnection(request);

	if(modal_yn.equals("Y"))
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append("select OCCUR_SRL_NO from pr_diagnosis  where patient_id = ? ");
		sql.append(" and TERM_SET_ID=? and TERM_CODE=?  and CURR_STATUS ='A' ");
		pstmt = con.prepareStatement( sql.toString() ) ;
		pstmt.setString( 1, Patient_Id) ;
		pstmt.setString( 2, term_set_id) ;
		pstmt.setString( 3, term_code) ;
		rset = pstmt.executeQuery() ;
		while(rset.next())
		{
			occur_srl_no=checkForNull(rset.getString("OCCUR_SRL_NO"));
			//System.out.println("occur_srl_no--------"+occur_srl_no);
		}if (pstmt!=null) pstmt.close();
		 if(rset!=null) rset.close();
		if(!occur_srl_no.equals(""))
			mode="modify";
	}	
		
	if(mode.equals("modify"))
	{
		disimage = "display:inline";
		mandatory_status="readonly";
		mandatory_disable	="disabled";
		def_select = "";
		
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append("select a.patient_id,a.term_set_id,a.term_code,");
		sql.append("B.long_desc term_short_desc,a.code_indicator,");
		sql.append("to_char(a.onset_date,'dd/mm/yyyy') onset_date ,a.curr_severity, ");
		sql.append("a.curr_onset_type,a.curr_facility_id,"); 
		sql.append("a.curr_encounter_id,a.curr_practitioner_id ,a.curr_practitioner_reln_id,"); sql.append("a.curr_locn_type,a.curr_locn_code,a.curr_nature,a.curr_priority,");
		sql.append("a.curr_accuracy_code,a.curr_accuracy_ind, a.curr_remarks, a.curr_status,"); sql.append("to_char(a.curr_status_date,'dd/mm/yyyy') status_date ,nvl(c.diff_group_id,'0') diff_group_id ");
		sql.append(" from pr_diagnosis a, mr_term_code b,");
		sql.append(" pr_differential_diagnosis c where a.term_code=b.term_code  ");
		sql.append(" and a.term_set_id=b.term_set_id  and "); 
		sql.append(" c.term_code(+)=a.term_code ");
		sql.append(" and c.OCCUR_SRL_NO(+)=a.OCCUR_SRL_NO and c.term_set_id(+) = a.term_set_id and ");
		sql.append(" c.patient_id(+)=a.patient_id and ");
		sql.append(" a.patient_id=? and a.term_set_id=? and a.term_code=? "); 
		sql.append(" and a.OCCUR_SRL_NO=?");

		stmt2 = con.prepareStatement(sql.toString());
		stmt2.setString(1,Patient_Id);
		//System.out.println(Patient_Id);
		stmt2.setString(2,term_set_id);
		//System.out.println(term_set_id);
		stmt2.setString(3,term_code);
		//System.out.println(term_code);
		stmt2.setString(4,occur_srl_no);
		//System.out.println(occur_srl_no);
		rs2 = stmt2.executeQuery();

		while(rs2.next())
		{
			status					= checkForNull(rs2.getString("curr_status"));
			Patient_Id				= checkForNull(rs2.getString("patient_id"));
			term_set_id				= checkForNull(rs2.getString("term_set_id"));
			term_code				= checkForNull(rs2.getString("term_code"));
			term_short_desc			= checkForNull(rs2.getString("term_short_desc"));
			onset_date				= checkForNull(rs2.getString("onset_date"));
			severity				= checkForNull(rs2.getString("curr_severity"));
			onset_type				= checkForNull(rs2.getString("curr_onset_type"));
			Practitioner_Id			= checkForNull(rs2.getString("curr_practitioner_id"));
			relationship_id			= checkForNull(rs2.getString("curr_practitioner_reln_id"));
			Locn_Type				= checkForNull(rs2.getString("curr_locn_type"));
			Locn_Code				= checkForNull(rs2.getString("curr_locn_code"));
			nature					= checkForNull(rs2.getString("curr_nature"));
			priority				= checkForNull(rs2.getString("curr_priority"));
			accuracy_code			= checkForNull(rs2.getString("curr_accuracy_code"));
			remarks					= checkForNull(rs2.getString("curr_remarks"));
			diff_group_id			= checkForNull(rs2.getString("diff_group_id"));
			status_date				= checkForNull(rs2.getString("status_date"));
			code_ind				= checkForNull(rs2.getString("code_indicator"));
			//Encounter_Id			= checkForNull(rs2.getString("curr_encounter_id"));
			
		}
		
		if(rs2!=null) rs2.close();
		if(stmt2!=null) stmt2.close();
		
		if(nature.equals("A"))
			Aselect = "selected";
		else if(nature.equals("P"))
			Pselect = "selected";
		else if(nature.equals("W"))
			Wselect = "selected";

		if(priority.equals("N"))
			pri_N_select = "selected";
		else if(priority.equals("H"))
			pri_H_select = "selected";
		else if(priority.equals("C"))
			pri_C_select = "selected";

		if(severity.equals("L"))
			sevr_L_select = "selected";
		else if(severity.equals("D"))
			sevr_D_select = "selected";
		else if(severity.equals("S"))
			sevr_S_select = "selected";
		else if(severity.equals("E"))
			sevr_E_select = "selected";
	
		if(status.equals("A"))
		{	
			stus_A_select = "selected";
			def_status="";
			date_status="readOnly";
			def_disable	="";
		}
		else if(status.equals("R"))
		{
			stus_R_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
		else if(status.equals("X"))
		{
			stus_X_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
		else if(status.equals("E"))
		{
			stus_E_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
	
		if(onset_type.equals("A"))
			type_A_select = "selected";
		else if(onset_type.equals("C"))
			type_C_select = "selected";

	//For Supprot Diiagnosis.......
	if(sql.length() > 0) sql.delete(0,sql.length());
	int temp=0;
	String supp_term_code=""; String supp_term_desc ="";
	StringBuffer temp_associate_codes=new StringBuffer();
	sql.append(" select a.supp_term_code ,b.short_desc from pr_support_diagnosis a , ");
	sql.append(" mr_term_code b where b.term_code = a.supp_term_code and a.patient_id =? and ");
	sql.append(" a.term_code = ? and b.term_set_id = ? and occur_srl_no=? and srl_no=");
	sql.append("(select max(srl_no) from pr_support_diagnosis where patient_id=a.PATIENT_ID and "); 
	sql.append("term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and occur_srl_no=a.occur_srl_no) ");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,Patient_Id);
		pstmt.setString(2,term_code);
		pstmt.setString(3,term_set_id);
		pstmt.setString(4,occur_srl_no);
		rset = pstmt.executeQuery();

		temp = 0;
		while(rset.next())
		{
			supp_term_code = rset.getString(1);
			supp_term_desc = rset.getString(2);
							
			if(temp == 0)
				temp_associate_codes.append(supp_term_code + "~" + supp_term_desc);
				else
					temp_associate_codes.append("|" + supp_term_code + "~" + supp_term_desc);	
				temp++;
		}
		
		if(associate_codes.equals(""))
			associate_codes=temp_associate_codes.toString();
		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();
	}
	else
	{
		def_disable="";			def_status	="";
		mandatory_status="";	mandatory_disable	="";
		def_select = "selected";
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

		
	String sql1 = "select team_id, short_desc from am_medical_team where facility_id = ? and eff_status='E' order by 2";
    try
	{
		pstmt =con.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1,facility_id);
		rset=pstmt.executeQuery();
		String name="",id="",sel="";
		String med_code="";	
		while(rset!=null && rset.next())
		{
			name=rset.getString(2);
			id =rset.getString(1);
			if(mode.equals("update")){
				if (id.trim().equalsIgnoreCase(med_code))
					sel="selected";
				else sel="";
			}else{
				sel="";
			}
			out.println("<option value='"+id+"' " + sel +">"+name+"</option>");
		}
		
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
		System.out.println("Exception in medteam.jsp"+e.toString());
	}

    
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block12Bytes, _wl_block12);
//=disimage
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(notifiable_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(age));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(status_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block36Bytes, _wl_block36);


} 
catch(Exception sqle)
{
	//out.println(sqle.getMessage());//COMMON-ICN-0181
    sqle.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block37Bytes, _wl_block37);
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
